package uminho.dss.trabalhopratico.business;

public class GTHibr extends GT {
    private int motor_eletrico;

    public GTHibr(String marca, String modelo, String cilindrada, String potencia, int eletrico) {
        super(marca, modelo, cilindrada, potencia, "");
        this.motor_eletrico = eletrico;
    }

    public GTHibr(GTHibr p) {
        super(p.getMarca(), p.getModelo(), p.getCilindrada(), p.getPotencia(), p.getFiabilidade(), p.gettaxa_degradacao());
        this.motor_eletrico = p.motor_eletrico;
    }

    public GTHibr clone() {
        return new GTHibr(this);
    }
}
