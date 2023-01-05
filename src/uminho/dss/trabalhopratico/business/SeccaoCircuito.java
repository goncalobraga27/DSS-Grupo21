package uminho.dss.trabalhopratico.business;

public class SeccaoCircuito implements Comparable<SeccaoCircuito> {
    public static final int RETA=0;
    public static final int CURVA=1;
    public static final int CHICANE=2;
    private final int tipoSeccao;
    private final int ordem;
    private final double GDU;

    public SeccaoCircuito(int tipoSeccao, int ordem, double GDU) {
        this.tipoSeccao = tipoSeccao;
        this.ordem = ordem;
        this.GDU = GDU;
    }

    public SeccaoCircuito(SeccaoCircuito s){
        this.tipoSeccao=s.getTipoSeccao();
        this.ordem=s.getOrdem();
        this.GDU=s.getGDU();
    }
    public int getTipoSeccao() {
        return tipoSeccao;
    }

    public int getOrdem() {
        return ordem;
    }

    public double getGDU() {
        return GDU;
    }

    @Override
    public SeccaoCircuito clone(){
        return new SeccaoCircuito(this);
    }

    @Override
    public String toString() {
        return "SeccaoCircuito {" +
                "tipoSeccao=" + tipoSeccao +
                ", ordem=" + ordem +
                ", GDU=" + GDU +
                '}';
    }

    @Override
    public int compareTo(SeccaoCircuito sc) {
        return Integer.compare(this.ordem, sc.ordem);
    }
}
