package uminho.dss.trabalhopratico.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Campeonato {
    private final String name; // unique
    private final Map<String, Circuito> lc;

    public Campeonato() {
        this.name = "";
        this.lc = new TreeMap<>();
    }

    public Campeonato(String name, List<Circuito> lc) {
        this.name = name;
        this.lc = lc.stream()
                .map(Circuito::clone)
                .collect(Collectors.toMap(
                        Circuito::getNome_circuito, c -> c
                ));
    }

    public Campeonato clone() {
        return new Campeonato(this);
    }

    public Campeonato(Campeonato that) {
        this.name = that.name;
        this.lc = that.lc.values()
                .stream()
                .map(Circuito::clone)
                .collect(Collectors.toMap(
                        Circuito::getNome_circuito, c->c
                ));
    }

    public List<Circuito> listCorridas() {
        return lc.values()
                .stream()
                .map(Circuito::clone)
                .collect(Collectors.toList());
    }

    public void addCircuito(Circuito c) {
        this.lc.put(c.getNome_circuito(), c.clone());
    }

    public String getName() {
        return name;
    }

    public Map<String, Circuito> getLc() {
        return lc;
    }
}
