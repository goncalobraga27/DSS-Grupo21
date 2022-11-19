import Carro.Carro;
import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Simulacao {
    private final Corrida corrida;
    private final List<Registo> lr;

    public Simulacao(Map<String, Registo> registers, Corrida corrida) {
        this.corrida = corrida.clone();
        this.lr = registers.values()
                .stream()
                .map(Registo::clone)
                .collect(Collectors.toList());
    }

    // a definir, ou a substituir por algo que verifique ultrapassagens
    private double generateAverageCarSpeed(Carro c) {
        return 0.;
    }

    // gera as classificacoes dos carros por ordem, através da sua velocidade média
    public TreeMap<Double, Registo> geraResultados() {
        Circuito c = this.corrida.getCircuito();
        TreeMap<Double, Registo> tm = new TreeMap<>();
        for(Registo r : this.lr) {
            double avgSpeed = generateAverageCarSpeed(r.getCarro());
            tm.put(avgSpeed, r.clone());
        }
        return tm;
    }
}
