package uminho.dss.trabalhopratico.business;

public abstract class Carro {
    private String Id;
    private String marca;
    private String modelo;
    private int cilindrada;
    private int potencia;
    private double fiabilidade;

    public Carro() {
        this.marca = "";
        this.modelo= "";
        this.cilindrada=0;
        this.potencia=0;
        this.fiabilidade=0;
    }

    public Carro(String marca, String modelo, int cilindrada, int potencia, double fiabilidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.fiabilidade = fiabilidade;
    }

    public Carro(Carro other) {
        this.marca = other.marca;
        this.modelo = other.modelo;
        this.cilindrada = other.cilindrada;
        this.potencia = other.potencia;
        this.fiabilidade = other.fiabilidade;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
}