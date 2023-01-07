package uminho.dss.trabalhopratico.Carro;

public class C2Hbr extends C2{
    private int motor_eletrico;

    public C2Hbr(String marca, String modelo,int cilindrada,int potencia,int eletrico) {
        super(marca,modelo,cilindrada,potencia);
        this.motor_eletrico = eletrico;
    }

    public C2Hbr(C2Hbr p) {
        super(p);
        this.motor_eletrico = p.motor_eletrico;
    }

    public int getMotor_eletrico() {
        return motor_eletrico;
    }

    public void setMotor_eletrico(int motor_eletrico) {
        this.motor_eletrico = motor_eletrico;
    }

    public C2Hbr clone() {
        return new C2Hbr(this);
    }

    @Override
    public String toString() {
        return super.toString() + " |C2 Híbrido|";
    }
}

