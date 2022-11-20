import Carro.Carro;

import java.util.*;
import java.util.stream.Collectors;

public class GestCampeonatos implements IGestCampeonatos {
    private Campeonato campeonato;
    private Map<String, Registo> mr;

    public Campeonato getCampeonato() {
        return this.campeonato.clone();
    }

    @Override
    public List<Corrida> getCorridas() {
        return campeonato.listCorridas(); // this clones, no need to clone again
    }

    @Override
    public List<Registo> getRegistos() {
        return mr.values()
                .stream()
                .map(Registo::clone)
                .collect(Collectors.toList());
    }

    public List<Carro> getCarros() {
        return this.mr.values()
                .stream()
                .map(Registo::getCarro)
                .collect(Collectors.toList());
    }

    public Map<Corrida, TreeSet<Iteracao>> simulaCampeonato() {
        Map<Corrida, TreeSet<Iteracao>> r = new HashMap<>();

        for(Corrida c : this.campeonato.listCorridas()) {
            Simulacao s = new Simulacao(mr, c);
            TreeSet<Iteracao> cur = r.get(c);
            if(cur == null) {
                cur = new TreeSet<>();
                cur.add(s.simula());
            } else {
                cur.add(s.simula());
            }
        }
        return r;
    }
}