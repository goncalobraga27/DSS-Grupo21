package uminho.dss.trabalhopratico.business;

import java.util.Objects;

public class Administrador extends Utilizador {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return super.equals(that);
    }


}