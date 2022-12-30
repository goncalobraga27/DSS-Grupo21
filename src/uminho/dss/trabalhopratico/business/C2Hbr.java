package uminho.dss.trabalhopratico.business;

public class C2Hbr extends C2{
    private int motor_eletrico;

    public C2Hbr(String marca, String modelo,int cilindrada,int potencia,int eletrico) {
        super(marca,modelo,cilindrada,potencia);
        this.motor_eletrico = eletrico;
    }

    public C2Hbr(C2Hbr p) {
        super(p.getMarca(), p.getModelo(),p.getCilindrada(),p.getPotencia());
        this.motor_eletrico = p.motor_eletrico;
    }

    public C2Hbr clone() {
        return new C2Hbr(this);
    }
}

