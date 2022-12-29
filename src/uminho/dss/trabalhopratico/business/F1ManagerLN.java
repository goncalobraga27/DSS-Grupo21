package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.data.CampeonatoDAO;
import uminho.dss.trabalhopratico.data.CarroDAO;
import uminho.dss.trabalhopratico.data.CircuitoDAO;
import uminho.dss.trabalhopratico.data.PilotoDAO;

import java.util.ArrayList;
import java.util.Map;

public class F1ManagerLN {
    private GestCampeonatos campeonatos;
    private GestUtilizadores gUsers;

    public F1ManagerLN(){
        this.campeonatos= new GestCampeonatos();
        this.gUsers= new GestUtilizadores();
    }

    public void addCircuito(String nome_circuito, double distancia, int n_curvas, int n_chicanes, int n_voltas, ArrayList<SeccaoCircuito> seccoes) {
        this.campeonatos.addCircuito(nome_circuito,distancia,n_curvas,n_chicanes,n_voltas,seccoes);
    }

    public void addCampeonato(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        //Circuito c = new Circuito(nome_circuito, distancia, n_curvas, n_chicanes, n_voltas);
        //this.circuitos.put(c.getnome(), c);
    }

    public void addPiloto(String nome, double cvs,double sva) {
        this.campeonatos.addPiloto(nome,cvs,sva);
    }

    public void addCarro(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        //this.campeonatos.addCarro();
    }
    public void addJogador(String username,String password){
        gUsers.addJogador(username,password);
    }
    public void addAdministrador(String username,String password){
        gUsers.addAdministrador(username,password);
    }

    public boolean validaJogador(String username,String password){
        return gUsers.validaJogador(username,password);
    }
    public boolean validaAdministrador(String username,String password){
        return gUsers.validaAdministrador(username,password);
    }

}
