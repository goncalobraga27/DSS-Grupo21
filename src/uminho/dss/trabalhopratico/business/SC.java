package uminho.dss.trabalhopratico.business;

public class SC extends Carro {
    public SC(SC that) {
        super(that);
    }

    public SC(String marca, String modelo, int cilindrada, int potencia, double fiabilidade) {
        super(marca, modelo,2500, potencia, fiabilidade);
    }

    public SC clone() {
        return new SC(this);
    }

    @Override
    public String toString() {
        return "SC{"+super.toString()+"}";
    }
}