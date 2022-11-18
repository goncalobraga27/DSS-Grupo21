public abstract class Utilizador {
    private String password;
    private String nomeUtilizador;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public Utilizador() {

    }

    public Utilizador(Utilizador that) {
        this.nomeUtilizador = that.nomeUtilizador;
        this.password = that.password;
    }

    public Utilizador(String nomeUtilizador, String password) {
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
    }

    public abstract Utilizador clone();
}