package uminho.dss.trabalhopratico.business;

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

    private boolean avariou(Carro c) {
        return (ThreadLocalRandom.current().nextDouble(0, 9999) % 10000) < c.getFiabilidade();
    }

    private double determinaUltrapassagem(double cilindrada, double potencia, double biasPiloto, double periciaPiloto) {
        cilindrada += ThreadLocalRandom.current().nextDouble(-.99, .99);
        potencia += ThreadLocalRandom.current().nextDouble(-.99, .99);
        periciaPiloto = condicaoMeteorologica == CHUVA
            ? periciaPiloto
            : 1. - periciaPiloto;
        return (cilindrada * .2) + (potencia * .3) + (biasPiloto * .2) + (periciaPiloto * .3);
    }

    private double probabilidadeUltrapassar(Registo r) {
        Carro c = r.getCarro();
        if(avariou(c)) {
            return 0.;
        }
        double cilindrada = c.getCilindrada();
        double potencia = c.getPotencia();
        Piloto p = r.getPiloto();
        double biasPiloto = p.getSegurancaAgressividade();
        double periciaPiloto = p.getChuvaTempoSeco();
        return determinaUltrapassagem(cilindrada, potencia, biasPiloto, periciaPiloto);
    }

    public Iteracao simula() {
        if(this.iteracoes.size() == 0) {
            Iteracao cur = new Iteracao(this.nomeCircuito, 0);
            cur.setResultados(new TreeSet<>(lr));
            return cur;
        }
        Iteracao prev = this.iteracoes.last();
        Iteracao cur = new Iteracao(this.nomeCircuito, prev.getnIteracao() + 1);

        TreeSet<Registo> novosResultados = new TreeSet<>(Comparator.comparingDouble(Registo::getProbUltrapassar));
        SeccaoCircuito seccao = Objects.requireNonNull(seccoesCircuito.poll());
        for(Registo r : prev.getResultados()) {
            double probabilidadeUltrapassar = probabilidadeUltrapassar(r);
            if(Double.compare(0., probabilidadeUltrapassar) != 0.) {
                r.setProbUltrapassar((probabilidadeUltrapassar * .3) * (seccao.getGDU() * .7));
                novosResultados.add(r);
            }
        }
        cur.setResultados(novosResultados);
        return cur;
    }
}
