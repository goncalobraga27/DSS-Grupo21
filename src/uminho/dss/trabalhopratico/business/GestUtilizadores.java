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
        Jogador j = new Jogador(username,password);
        this.jogadores.put(j.getNomeUtilizador(), j);
    }

    public void addAdministrador(String username,String password){
        Administrador a = new Administrador(username,password);
        this.administradores.put(a.getNomeUtilizador(), a);
    }

    public void validaJogador(String username,String password){
        Jogador j = new Jogador(username,password);
        this.jogadores.containsValue(j);
    }

    public void validaAdministrador (String username,String password){
        Administrador a = new Administrador(username,password);
        this.administradores.containsValue(a);
    }
}
