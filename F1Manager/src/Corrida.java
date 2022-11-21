public class Corrida {
    private final String identificador;
    private final Circuito circuito;
    public Corrida(Corrida that) {
        this.identificador = that.identificador;
        this.circuito = that.circuito.clone();
    }

    public Circuito getCircuito() {
        return this.circuito.clone();
    }

    public String getIdentificador() {
        return identificador;
    }

    public Corrida clone() {
        return new Corrida(this);
    }
}
