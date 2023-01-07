package uminho.dss.trabalhopratico.Carro;

public abstract class Carro {
    private String Id;
    private String marca;
    private int cilindrada;
    private int potencia;
    private double fiabilidade;

    public Carro() {
        this.marca = "";
        this.cilindrada=0;
        this.potencia=0;
        this.fiabilidade=0;
    }

    public Carro(String marca, String modelo, int cilindrada, int potencia, double fiabilidade) {
        this.marca = marca+" "+modelo;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.fiabilidade = fiabilidade;
    }


    public Carro(Carro other) {
        this.Id = other.Id;
        this.marca = other.marca;
        this.cilindrada = other.cilindrada;
        this.potencia = other.potencia;
        this.fiabilidade = other.fiabilidade;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public double getFiabilidade() {
        return fiabilidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setFiabilidade(double fiabilidade) {
        this.fiabilidade = fiabilidade;
    }

    abstract public Carro clone();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    @Override
    public String toString() {
        return this.marca;
    }
}