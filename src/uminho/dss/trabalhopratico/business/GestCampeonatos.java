package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.data.CampeonatoDAO;
import uminho.dss.trabalhopratico.data.CarroDAO;
import uminho.dss.trabalhopratico.data.CircuitoDAO;
import uminho.dss.trabalhopratico.data.PilotoDAO;

import java.util.*;
import java.util.stream.Collectors;

public class GestCampeonatos implements IGestCampeonatos {
    private Map<String, Carro> carros;
    private Map<String, Campeonato> campeonatos;
    private Map<String, Circuito> circuitos;
    private Map<String,Piloto> pilotos;

    public GestCampeonatos () {
        this.carros= CarroDAO.getInstance();
        this.campeonatos= CampeonatoDAO.getInstance();
        this.circuitos= CircuitoDAO.getInstance();
        this.pilotos= PilotoDAO.getInstance();
    }

    public void addCircuito(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas,ArrayList<SeccaoCircuito> seccao) {
        Circuito c = new Circuito(nome_circuito,distancia, n_curvas,  n_chicanes, n_voltas,seccao);
        this.circuitos.put(c.getNome_circuito(),c);
    }

    public void addCampeonato(String nome_circuito,ArrayList<String> circuitos) {
        ArrayList<Circuito>circ= new ArrayList<>();
        for (String m : circuitos){
            Circuito circuito = this.circuitos.get(m);
            circ.add(circuito);
        }
        Campeonato camp = new Campeonato(nome_circuito,circ);
        this.campeonatos.put(camp.getName(), camp);
    }

    public void addPiloto(String nome, double cvs,double sva) {
        Piloto p = new Piloto(nome,cvs,sva);
        this.pilotos.put(p.getNomePiloto(),p);
    }

    public void addCarro(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas) {
        //Circuito c = new Circuito(nome_circuito, distancia, n_curvas, n_chicanes, n_voltas);
        //this.circuitos.put(c.getnome(), c);
    }

    public void addCarroC1Hbr(String marca,String modelo,int potenciaMC,int PotenciaME) {
        C1Hbr c1= new C1Hbr(marca,modelo,potenciaMC,PotenciaME);
    }
    public void addCarroC1(String marca,String modelo, int potenciaMC) {
        C1 c1= new C1(marca,modelo,potenciaMC);
    }

    public void addCarroC2Hbr(String marca,String modelo,int cilindrada,int potenciaMC,int PotenciaME) {
        C2Hbr c2 = new C2Hbr(marca,modelo,cilindrada,potenciaMC,PotenciaME);
    }

    public void addCarroC2(String marca,String modelo,int cilindrada,int potenciaMC) {
        C2 c2 = new C2(marca,modelo,cilindrada,potenciaMC);
    }


    public Collection<Circuito> getCircuitos() {
        return this.circuitos.values();
    }

}