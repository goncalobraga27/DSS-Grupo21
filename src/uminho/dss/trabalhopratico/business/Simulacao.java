package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.Campeonato.Circuito;
import uminho.dss.trabalhopratico.Campeonato.SeccaoCircuito;
import uminho.dss.trabalhopratico.Carro.Carro;
import uminho.dss.trabalhopratico.Piloto.Piloto;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Simulacao {
    private final int SECO = 0;
    private final int CHUVA = 1;
    private final List<Registo> lr;
    private final TreeSet<Iteracao> iteracoes;
    private final String nomeCircuito;
    private final Deque<SeccaoCircuito> seccoesCircuito;
    private final int condicaoMeteorologica;

    public Simulacao(Map<Integer, Registo> registers, Circuito c) {
        this.lr = registers.values()
                .stream()
                .map(Registo::clone)
                .collect(Collectors.toList());
        this.iteracoes = new TreeSet<>();
        this.nomeCircuito = c.getNome_circuito();
        this.seccoesCircuito = c.getSeccoes();
        this.condicaoMeteorologica = (ThreadLocalRandom.current().nextInt(SECO, CHUVA * 99) % 2) - 1;
    }

    public Deque<SeccaoCircuito> getSeccoesCircuito() {
        return seccoesCircuito;
    }

    private boolean avariou(Carro c) {
        return (ThreadLocalRandom.current().nextDouble(0, 9999) % 10000) < c.getFiabilidade();
    }

    private double determinaUltrapassagem(double cilindrada, double potencia, double biasPiloto, double periciaPiloto) {
        double ccPercentil = cilindrada * ThreadLocalRandom.current().nextInt(1, 10001) / 10000.;
        double cvPercentil = potencia * ThreadLocalRandom.current().nextInt(1, 10001) / 10000.;
        if(condicaoMeteorologica == CHUVA) {
            periciaPiloto = 1. - periciaPiloto;
        }
        periciaPiloto *= ThreadLocalRandom.current().nextInt(1, 10001) / 10000.;
        return ((ccPercentil / cilindrada) * .2) +
            ((cvPercentil / potencia) * .3) +
            (biasPiloto * .2) +
            (periciaPiloto * .3);
    }

    private double probabilidadeUltrapassar(Registo r) {
        Carro c = r.getCarro();
        if(avariou(c)) {
            return -1.;
        }
        Piloto p = r.getPiloto();
        return determinaUltrapassagem(c.getCilindrada(), c.getPotencia(), p.getSegurancaAgressividade(), p.getChuvaTempoSeco());
    }

    public TreeSet<Iteracao> simulaVolta() {
        Deque<SeccaoCircuito> seccoes = this.seccoesCircuito.stream()
            .map(SeccaoCircuito::clone)
            .collect(Collectors.toCollection(ArrayDeque::new));

        TreeSet<Iteracao> result = new TreeSet<>(Comparator.comparingInt(Iteracao::getnIteracao));
        int size = seccoes.size();
        for(var i = 0; i < size; ++i) {
            result.add(simula(seccoes));
        }
        return result;
    }

    // é para ser usado com um iterator
    public Iteracao simula(Deque<SeccaoCircuito> sc) {
        if(this.iteracoes.size() == 0) {
            Iteracao cur = new Iteracao(this.nomeCircuito, 0);
            this.iteracoes.add(cur);
            cur.setResultados(new TreeSet<>(this.lr));
            return cur;
        }
        Iteracao prev = this.iteracoes.last();
        Iteracao cur = new Iteracao(this.nomeCircuito, prev.getnIteracao() + 1);

        TreeSet<Registo> novosResultados = new TreeSet<>();
        SeccaoCircuito seccao = Objects.requireNonNull(sc.poll());
        for(Registo r : prev.getResultados()) {
            Registo newR = r.clone();
            if(Double.compare(-1., r.getProbUltrapassar()) != 0.) {
                double probabilidadeUltrapassar = probabilidadeUltrapassar(newR);
                newR.setProbUltrapassar((probabilidadeUltrapassar * .65) + (seccao.getGDU() * .35));
                novosResultados.add(newR);
            }
            novosResultados.add(newR);
        }
        cur.setResultados(novosResultados);
        this.iteracoes.add(cur);
        return cur;
    }

}
