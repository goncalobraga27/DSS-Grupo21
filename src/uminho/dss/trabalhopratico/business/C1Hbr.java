package uminho.dss.trabalhopratico.business;

public class C1Hbr extends C1{
    private int motor_eletrico;

    public C1Hbr(String marca, String modelo,int potencia,int eletrico) {
        super(marca, modelo,potencia);
        this.motor_eletrico = eletrico;
    }

    public C1Hbr(C1Hbr p) {
        super(p.getMarca(), p.getModelo(), p.getPotencia());
        this.motor_eletrico = p.motor_eletrico;
    }

    public C1Hbr clone() {
        return new C1Hbr(this);
    }
}
