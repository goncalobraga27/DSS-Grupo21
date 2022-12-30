package uminho.dss.trabalhopratico.business;

import com.sun.source.tree.Tree;
import uminho.dss.trabalhopratico.business.Circuito;

import java.util.*;
import java.util.stream.Collectors;

public class Simulacao {
    private final Circuito circuito;
    private final List<Registo> lr;

    public Simulacao(Map<Integer, Registo> registers, Circuito c) {
        this.circuito=c.clone();
        this.lr = registers.values()
                .stream()
                .map(Registo::clone)
                .collect(Collectors.toList());
    }

    public Iteracao simula() {
        // to be done
        return new Iteracao("bla", 0);
    }
}
