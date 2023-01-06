package uminho.dss.trabalhopratico.business;

public class GTHibr extends GT {
    private int motor_eletrico;

    public GTHibr(String marca, String modelo, int cilindrada, int potencia,double taxa_degradacao , int eletrico) {
        super(marca, modelo, cilindrada, potencia,taxa_degradacao);
        this.motor_eletrico = eletrico;
    }

    public GTHibr(GTHibr p) {
        super(p);
        this.motor_eletrico = p.motor_eletrico;
    }

    public int getMotor_eletrico() {
        return motor_eletrico;
    }

    public void setMotor_eletrico(int motor_eletrico) {
        this.motor_eletrico = motor_eletrico;
    }

    public GTHibr clone() {
        return new GTHibr(this);
    }

    @Override
    public String toString() {
        return "GTHibr{" +super.toString()+
                "motor_eletrico=" + motor_eletrico +
                '}';
    }
}
