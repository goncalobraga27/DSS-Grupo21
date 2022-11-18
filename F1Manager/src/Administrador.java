public class Administrador extends Utilizador {
    // há alguma variável de instância aqui?

    public Administrador(String user, String password) {
        super(user, password);
    }

    public Administrador(Administrador that) {
        super(that.getNomeUtilizador(), that.getPassword());
    }

    @Override
    public Administrador clone() {
        return new Administrador(this);
    }
}
