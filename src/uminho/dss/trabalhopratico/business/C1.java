package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.business.Carro;

public class C1 extends Carro {

    public C1() {
        super();
    }

    public C1(String marca, String modelo, int potencia) {
        super(marca, modelo, 6000, potencia, 95);
    }

    public C1(C1 p) {
        super(p);
    }

    @Override
    public C1 clone() {
        return new C1(this);
    }

    @Override
    public String toString() {
        return "C1{"+super.toString()+"}";
    }
}
