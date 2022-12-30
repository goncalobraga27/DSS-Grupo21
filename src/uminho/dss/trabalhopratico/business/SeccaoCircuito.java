package uminho.dss.trabalhopratico.business;


public class SeccaoCircuito {
    public static final int RETA=0;
    private static final int CURVA=1;
    private static final int CHICANE=2;

    private int tipoSeccao;
    private int ordem;
    private double GDU;

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

    public void setTipoSeccao(int tipoSeccao) {
        this.tipoSeccao = tipoSeccao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public double getGDU() {
        return GDU;
    }

    public void setGDU(double GDU) {
        this.GDU = GDU;
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
}
