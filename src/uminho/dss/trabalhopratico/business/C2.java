package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.business.Carro;

public class C2 extends Carro {

    public C2() {
        super();
    }

    public C2(String marca, String modelo,int cilindrada, int potencia) {
        super(marca, modelo, cilindrada, potencia, 0.8);
    }

    public C2(C2 p) {
        super(p.getMarca(), p.getModelo(), p.getCilindrada(), p.getPotencia(), p.getFiabilidade());
    }

    public C2 clone () {
        return new C2(this);
    }
}
