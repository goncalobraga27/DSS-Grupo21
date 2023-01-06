package uminho.dss.trabalhopratico.business;

public class Piloto {

    private String nomePiloto;
    private double chuvaTempoSeco;
    private double segurancaAgressividade;

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }
    public String getNomePiloto() {
        return this.nomePiloto;
    }
    public void setChuvaTempoSeco(double chuvaTempoSeco) {
        this.chuvaTempoSeco = chuvaTempoSeco;
    }
    public void setSegurancaAgressividade(double segurancaAgressividade) {
        this.segurancaAgressividade = segurancaAgressividade;
    }
    public double getChuvaTempoSeco() {
        return this.chuvaTempoSeco;
    }
    public double getSegurancaAgressividade() {
        return this.segurancaAgressividade;
    }
    public Piloto(Piloto p) {
        this.nomePiloto=p.getNomePiloto();
        this.segurancaAgressividade=p.getSegurancaAgressividade();
        this.chuvaTempoSeco=p.getChuvaTempoSeco();
    }
    public Piloto(String nomePiloto, double chuvaTempoSeco, double segurancaAgressividade) {
        this.nomePiloto=nomePiloto;
        this.segurancaAgressividade=segurancaAgressividade;
        this.chuvaTempoSeco=chuvaTempoSeco;
    }
    public Piloto clone(){
        return new Piloto(this);
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nomePiloto='" + nomePiloto + '\'' +
                ", chuvaTempoSeco=" + chuvaTempoSeco +
                ", segurancaAgressividade=" + segurancaAgressividade +
                '}';
    }
}