package uminho.dss.trabalhopratico.business;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return this.getPassword().equals(that.getPassword()) && this.getNomeUtilizador().equals(that.getNomeUtilizador());
    }

    @Override
    public String toString() {
        return "Utilizador: " + this.nomeUtilizador;
    }
}