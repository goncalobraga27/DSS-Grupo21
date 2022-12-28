package uminho.dss.trabalhopratico.business;

public class Administrador extends Utilizador {

    private String Id;

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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


}