package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.data.CampeonatoDAO;
import uminho.dss.trabalhopratico.data.CarroDAO;
import uminho.dss.trabalhopratico.data.CircuitoDAO;
import uminho.dss.trabalhopratico.data.PilotoDAO;

import java.util.ArrayList;
import java.util.Collection;
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

    public void addCampeonato(String nome_circuito,ArrayList<String> circuitos) {
        this.campeonatos.addCampeonato(nome_circuito,circuitos);
    }

    public void addPiloto(String nome, double cvs,double sva) {
        this.campeonatos.addPiloto(nome,cvs,sva);
    }

    public void addCarroC1Hbr(String marca,String modelo,int potenciaMC,int PotenciaME) {
        this.campeonatos.addCarroC1Hbr(marca,modelo,potenciaMC,PotenciaME);
    }

    public void addCarroC1(String marca,String modelo,int potenciaMC) {
        this.campeonatos.addCarroC1(marca,modelo,potenciaMC);
    }

    public void addCarroC2Hbr(String marca,String modelo,int cilindrada,int potenciaMC,int PotenciaME) {
        this.campeonatos.addCarroC2Hbr(marca,modelo,cilindrada,potenciaMC,PotenciaME);
    }

    public void addCarroC2(String marca,String modelo,int cilindrada,int potenciaMC) {
        this.campeonatos.addCarroC2(marca,modelo,cilindrada,potenciaMC);
    }

    public Collection<Circuito> getCircuitos() {
        return this.campeonatos.getCircuitos();
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

    public boolean validacilindrada(int categoria,int value) {
        if (categoria==2)
            return value>3000 && value<5000;
        else
            return value>2000 && value<4000;
    }
}
