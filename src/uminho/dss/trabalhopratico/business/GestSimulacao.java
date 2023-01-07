package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.Campeonato.Campeonato;
import uminho.dss.trabalhopratico.Carro.Carro;

import java.util.*;
import java.util.stream.Collectors;

public class GestSimulacao implements IGestSimulacao {
    private final Campeonato campeonato;
    private int nRegistos;
    private Map<Integer, Registo> mr;

    public GestSimulacao(Campeonato c) {
        this.campeonato = c;
        this.mr = new HashMap<>();
    }

    public GestSimulacao(Campeonato c, Registo r) {
        this.campeonato = c;
        this.mr = new HashMap<>();
        mr.put(r.getIdRegisto(), r.clone());
    }

    public Campeonato getCampeonato() {
        return this.campeonato.clone();
    }


    /*public List<Corrida> getCorridas() {
      return campeonato.listCorridas(); // this clones, no need to clone again
    }

    @Override
    public List<Registo> getRegistos() {
        return mr.values()
                .stream()
                .map(Registo::clone)
                .collect(Collectors.toList());
    }
    */
    public List<Carro> getCarros() {
        return this.mr.values()
                .stream()
                .map(Registo::getCarro)
                .collect(Collectors.toList());
    }

    /*public void addRegisto(Jogador j, String marca, String modelo, String nomePiloto) {
        // assumindo que a marca e o modelo já existiam e por isso "confia Joca"
        //Carro c = this.carros.get(marca).get(modelo);
        Piloto p = this.pilotos.get(nomePiloto);
        Registo r = new Registo(nRegistos++, c, p, j);
        this.mr.put(nRegistos, r);
    }


    public Map<Corrida, TreeSet<Iteracao>> simulaCampeonato() {
        Map<Corrida, TreeSet<Iteracao>> r = new HashMap<>();

        for(Circuito c : this.campeonato.listCorridas()) {
            Simulacao s = new Simulacao(mr, c);
            TreeSet<Iteracao> cur = r.get(c);
            if(cur == null) {
                cur = new TreeSet<>();
                r.put(c.clone(), cur);
            }
            cur.add(s.simula());
        }
        return r;
    }
     */
}
