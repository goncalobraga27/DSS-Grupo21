package uminho.dss.trabalhopratico.business;

public class GT extends Carro {

    private double taxa_degradacao;

    public GT(String marca, String modelo, String cilindrada, String potencia, String fiabilidade) {
        super(marca, modelo, cilindrada, potencia, fiabilidade);
        this.taxa_degradacao = 0.;
    }

    public GT(String marca, String modelo, String cilindrada, String potencia, String fiabilidade, double taxa_degradacao) {
        super(marca, modelo, cilindrada, potencia, fiabilidade);
        this.taxa_degradacao = taxa_degradacao;
    }

    public GT(GT that) {
        super(that.getMarca(), that.getModelo(), that.getCilindrada(), that.getPotencia(), that.getFiabilidade());
        this.taxa_degradacao = that.taxa_degradacao;
    }

    public double gettaxa_degradacao() {
        return this.taxa_degradacao;
    }

    public void settaxa_degradacao(double taxa) {
        this.taxa_degradacao = taxa;
    }

    public GT clone() {
        return new GT(this);
    }
}