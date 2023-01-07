package uminho.dss.trabalhopratico.business;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Iteracao implements Comparable<Iteracao> {
    private final TreeSet<Registo> resultados;
    private final String nomeCorrida;
    private final int nIteracao;

    public Iteracao(String nomeCorrida, int nIteracao) {
        this.nomeCorrida = nomeCorrida;
        this.nIteracao = nIteracao;
        this.resultados = new TreeSet<>(Comparator.naturalOrder());
    }

    // o comparator disto é relativo a uma ultrapassagem... espero mesmo que isto não implique mudanças
    public TreeSet<Registo> getResultados() {
        return resultados;
    }

    public void setResultados(TreeSet<Registo> resultados) {
        for(Registo r : resultados) {
            this.resultados.add(r.clone());
        }
    }

    public String getNomeCorrida() {
        return nomeCorrida;
    }

    public int getnIteracao() {
        return nIteracao;
    }

    @Override
    public int compareTo(Iteracao i) {
        return Integer.compare(this.nIteracao, i.getnIteracao());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for(Registo r : resultados) {
            ++i;
            builder.append(i).append(r.toString()).append("\n");
        }
        return builder.toString();
    }
}
