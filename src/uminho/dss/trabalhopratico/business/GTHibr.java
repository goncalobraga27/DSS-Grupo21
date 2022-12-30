package uminho.dss.trabalhopratico.business;

public class GTHibr extends GT {
    private int motor_eletrico;

    public GTHibr(String marca, String modelo, int cilindrada, int potencia,double taxa_degradacao , int eletrico) {
        super(marca, modelo, cilindrada, potencia,taxa_degradacao);
        this.motor_eletrico = eletrico;
    }

    public GTHibr(GTHibr p) {
        super(p.getMarca(), p.getModelo(), p.getCilindrada(), p.getPotencia(), p.gettaxa_degradacao());
        this.motor_eletrico = p.motor_eletrico;
    }

    public GTHibr clone() {
        return new GTHibr(this);
    }
}
