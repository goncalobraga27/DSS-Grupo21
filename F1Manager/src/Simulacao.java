import Carro.Carro;
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class Simulacao {
    private final Circuito circuito;
    private final List<Registo> lr;

    public Simulacao(Map<Integer, Registo> registers, Corrida corrida) {
        this.circuito = corrida.getCircuito().clone();
        this.lr = registers.values()
                .stream()
                .map(Registo::clone)
                .collect(Collectors.toList());
    }

    public Iteracao simula() {

    }
}
