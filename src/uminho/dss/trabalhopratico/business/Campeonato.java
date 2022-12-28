package uminho.dss.trabalhopratico.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Campeonato {

    private  String Id;
    private final String name; // unique
    private final Map<String, Corrida> lc;

    public Campeonato() {
        this.name = "";
        this.lc = new TreeMap<>();
    }

    public Campeonato(String name, List<Corrida> lc) {
        this.name = name;
        this.lc = lc.stream()
                .map(Corrida::clone)
                .collect(Collectors.toMap(
                        Corrida::getIdentificador, c -> c
                ));
    }

    public Campeonato clone() {
        return new Campeonato(this);
    }

    public Campeonato(Campeonato that) {
        this.name = that.name;
        this.lc = that.lc.values()
                .stream()
                .map(Corrida::clone)
                .collect(Collectors.toMap(
                        Corrida::getIdentificador, c->c
                ));
    }

    public List<Corrida> listCorridas() {
        return lc.values()
                .stream()
                .map(Corrida::clone)
                .collect(Collectors.toList());
    }

    public void addCorrida(Corrida c) {
        this.lc.put(c.getIdentificador(), c.clone());
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Corrida> getLc() {
        return lc;
    }
}
