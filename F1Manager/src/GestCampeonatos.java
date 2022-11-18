import Carro.Carro;

import java.util.List;
import java.util.Map;
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
}