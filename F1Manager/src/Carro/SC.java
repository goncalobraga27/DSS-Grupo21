package Carro;

public class SC extends Carro {
    public SC(SC that) {
        super(that.getMarca(), that.getModelo(), that.getCilindrada(), that.getFiabilidade(), that.getPotencia());
    }

    public SC clone() {
        return new SC(this);
    }
}