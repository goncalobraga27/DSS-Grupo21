package uminho.dss.trabalhopratico.Carro;

public class C1Hbr extends C1 {
    private int motor_eletrico;

    public C1Hbr(String marca, String modelo,int potencia,int eletrico) {
        super(marca, modelo,potencia);
        this.motor_eletrico = eletrico;
    }

    public C1Hbr(C1Hbr p) {
        super(p);
        this.motor_eletrico = p.motor_eletrico;
    }

    public int getMotor_eletrico() {
        return motor_eletrico;
    }

    public void setMotor_eletrico(int motor_eletrico) {
        this.motor_eletrico = motor_eletrico;
    }

    public C1Hbr clone() {
        return new C1Hbr(this);
    }


    @Override
    public String toString() {
        return super.toString() + " |C1 Híbrido|";
    }
}
