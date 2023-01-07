package uminho.dss.trabalhopratico.Carro;

public class GT extends Carro {

    private double taxa_degradacao;

    public GT(String marca, String modelo, int cilindrada, int potencia) {
        super(marca, modelo, cilindrada, potencia, 1);
        this.taxa_degradacao = 0.;
    }

    public GT(String marca, String modelo, int cilindrada, int potencia, double taxa_degradacao) {
        super(marca, modelo, cilindrada, potencia, 1);
        this.taxa_degradacao = taxa_degradacao;
    }

    public GT(GT that) {
        super(that);
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

    @Override
    public String toString() {
        return super.toString() + " |GT|";
    }
}