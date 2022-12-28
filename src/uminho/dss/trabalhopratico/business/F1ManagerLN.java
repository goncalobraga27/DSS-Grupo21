package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.business.Campeonato;
import uminho.dss.trabalhopratico.business.Carro;
import uminho.dss.trabalhopratico.business.Circuito;
import uminho.dss.trabalhopratico.data.CampeonatoDAO;
import uminho.dss.trabalhopratico.data.CarroDAO;
import uminho.dss.trabalhopratico.data.CircuitoDAO;

import java.util.Map;

public class F1ManagerLN {
    private Map<String, Carro> carros;
    private Map<String, Campeonato> campeonatos;
    private Map<String, Circuito> circuitos;

    private GestUtilizadores gUsers;

    public F1ManagerLN(){
        this.carros= CarroDAO.getInstance();
        this.campeonatos= CampeonatoDAO.getInstance();
        this.circuitos= CircuitoDAO.getInstance();
        this.gUsers= new GestUtilizadores();
    }

    public void addCircuito(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        Circuito c = new Circuito(nome_circuito,distancia, n_curvas,  n_chicanes,  n_voltas);
        this.circuitos.put(c.getnome(),c);
    }

    public void addCampeonato(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        Circuito c = new Circuito(nome_circuito, distancia, n_curvas, n_chicanes, n_voltas);
        this.circuitos.put(c.getnome(), c);
    }
    public void addPiloto(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        Circuito c = new Circuito(nome_circuito, distancia, n_curvas, n_chicanes, n_voltas);
        this.circuitos.put(c.getnome(), c);
    }

    public void addCarro(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        Circuito c = new Circuito(nome_circuito, distancia, n_curvas, n_chicanes, n_voltas);
        this.circuitos.put(c.getnome(), c);
    }
    public void addJogador(String username,String password){
        gUsers.addJogador(username,password);
    }
    public void addAdministrador(String username,String password){
        gUsers.addAdministrador(username,password);
    }

}
