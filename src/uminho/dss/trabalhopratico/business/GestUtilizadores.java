package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.data.AdministradorDAO;
import uminho.dss.trabalhopratico.data.JogadorDAO;

import java.util.Map;

public class GestUtilizadores {
    private Map<String,Jogador> jogadores ;
    private Map<String,Administrador> administradores;

    public GestUtilizadores(){
        this.administradores= AdministradorDAO.getInstance();
        this.jogadores= JogadorDAO.getInstance();
    }

    public void addJogador(String username,String password){
        Jogador j = new Jogador(username,password,0);
        this.jogadores.put(j.getNomeUtilizador(), j);
    }

    public void addAdministrador(String username,String password){
        Administrador a = new Administrador(username,password);
        this.administradores.put(a.getNomeUtilizador(), a);
    }

    public boolean validaJogador(String username,String password){
        Jogador j = new Jogador(username,password,0);
        return this.jogadores.containsValue(j);
    }

    public boolean validaAdministrador (String username,String password){
        Administrador a = new Administrador(username,password);
        return this.administradores.containsValue(a);
    }

    public Jogador getJogador(String username){
        return this.jogadores.get(username);
    }
}
