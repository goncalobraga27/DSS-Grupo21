package Carro;

public class C1 extends Carro {

    public C1() {
        super();
    }

    public C1(String marca, String modelo, String cilindrada, String potencia, String fiabilidade) {
        super(marca, modelo, cilindrada, potencia, fiabilidade);
    }

    public C1(C1 p) {
        super(p.getMarca(), p.getModelo(), p.getCilindrada(), p.getPotencia(), p.getFiabilidade());
    }
}
