import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Iteracao implements Comparable<Iteracao>, Comparator<Iteracao> {
    private TreeMap<Integer, Registo> resultados;
    private final String nomeCorrida;
    private final int nIteracao;

    public Iteracao(String nomeCorrida, int nIteracao) {
        this.nomeCorrida = nomeCorrida;
        this.nIteracao = nIteracao;
        this.resultados = new TreeMap<>();
    }

    public TreeMap<Integer, Registo> getResultados() {
        return resultados;
    }

    public void setResultados(TreeMap<Integer, Registo> resultados) {
        for(Map.Entry<Integer, Registo> e : resultados.entrySet()) {
            this.resultados.put(e.getKey(), e.getValue().clone());
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
    public int compare(Iteracao o1, Iteracao o2) {
        return Integer.compare(o1.getnIteracao(), o2.getnIteracao());
    }
}
