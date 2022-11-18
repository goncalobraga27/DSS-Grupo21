public class Corrida {
    private String identificador;

    public Corrida(Corrida that) {
        this.identificador = that.identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Corrida clone() {
        return new Corrida(this);
    }
}
