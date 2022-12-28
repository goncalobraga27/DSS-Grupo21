package uminho.dss.trabalhopratico.business;

public class Piloto {

    private String nomePiloto;
    private float chuvaTempoSeco;
    private float segurancaAgressividade;

    /**
     *
     * @param nomePiloto
     */
    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public String getNomePiloto() {
        return this.nomePiloto;
    }

    /**
     *
     * @param chuvaTempoSeco
     */
    public void setChuvaTempoSeco(float chuvaTempoSeco) {
        this.chuvaTempoSeco = chuvaTempoSeco;
    }

    /**
     *
     * @param segurancaAgressividade
     */
    public void setSegurancaAgressividade(float segurancaAgressividade) {
        this.segurancaAgressividade = segurancaAgressividade;
    }

    public float getChuvaTempoSeco() {
        return this.chuvaTempoSeco;
    }

    public float getSegurancaAgressividade() {
        return this.segurancaAgressividade;
    }

    public Piloto() {
        // TODO - implement Piloto.Piloto
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param p
     */
    public Piloto(Piloto p) {
        // TODO - implement Piloto.Piloto
        throw new UnsupportedOperationException();
    }

    public Piloto(String nomePiloto, float chuvaTempoSeco, float segurancaAgressividade) {
        // TODO - implement Piloto.Piloto
        throw new UnsupportedOperationException();
    }

    public Piloto clone() {
        // TODO - implement Piloto.clone
        throw new UnsupportedOperationException();
    }

}