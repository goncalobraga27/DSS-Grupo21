package uminho.dss.trabalhopratico.business;

public class SC extends Carro {
    public SC(SC that) {
        super(that.getMarca(), that.getModelo(), that.getCilindrada(),that.getPotencia(), that.getFiabilidade());
    }

    public SC(String marca, String modelo, int cilindrada, int potencia, double fiabilidade, double taxa_degradacao) {
        super(marca, modelo, cilindrada, potencia, fiabilidade);
    }

    public SC clone() {
        return new SC(this);
    }
}