public abstract class Carro {
    private String Id;
    private String marca;
    private String modelo;
    private String cilindrada;
    private String potencia;
    private String fiabilidade;

    public Carro(String marca, String modelo, String cilindrada, String potencia, String fiabilidade) {
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

    public String getCilindrada() {
        return cilindrada;
    }

    public String getPotencia() {
        return potencia;
    }

    public String getFiabilidade() {
        return fiabilidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public void setFiabilidade(String fiabilidade) {
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