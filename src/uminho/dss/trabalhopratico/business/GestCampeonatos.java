package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.data.CampeonatoDAO;
import uminho.dss.trabalhopratico.data.CarroDAO;
import uminho.dss.trabalhopratico.data.CircuitoDAO;
import uminho.dss.trabalhopratico.data.PilotoDAO;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class GestCampeonatos implements IGestCampeonatos {
    private Map<String, Carro> carros;
    private Map<String, Campeonato> campeonatos;
    private Map<String, Circuito> circuitos;
    private Map<String,Piloto> pilotos;

    public GestCampeonatos () {
        this.carros= CarroDAO.getInstance();
        this.circuitos= CircuitoDAO.getInstance();
        this.campeonatos= CampeonatoDAO.getInstance();
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

    public void addCarroC1Hbr(String marca,String modelo,int potenciaMC,int PotenciaME) {
        C1Hbr c1= new C1Hbr(marca,modelo,potenciaMC,PotenciaME);
        this.carros.put(c1.getMarca(),c1);
        System.out.println(this.carros.get(c1.getMarca()));
    }
    public void addCarroC1(String marca,String modelo, int potenciaMC) {
        C1 c1= new C1(marca,modelo,potenciaMC);
        this.carros.put(c1.getMarca(),c1);
        System.out.println(this.carros.get(c1.getMarca()));
    }

    public void addCarroC2Hbr(String marca,String modelo,int cilindrada,int potenciaMC,int PotenciaME) {
        C2Hbr c2 = new C2Hbr(marca,modelo,cilindrada,potenciaMC,PotenciaME);
        this.carros.put(c2.getMarca(),c2);
        System.out.println(this.carros.get(c2.getMarca()));
    }

    public void addCarroC2(String marca,String modelo,int cilindrada,int potenciaMC) {
        C2 c2 = new C2(marca,modelo,cilindrada,potenciaMC);
        this.carros.put(c2.getMarca(),c2);
        System.out.println(this.carros.get(c2.getMarca()));
    }

    public void addCarroSC(String marca,String modelo,int cilindrada,int potenciaMC,double fiabilidade) {
        SC c2 = new SC(marca,modelo,cilindrada,potenciaMC,fiabilidade);
        this.carros.put(c2.getMarca(),c2);
        System.out.println(this.carros.get(c2.getMarca()));
    }

    public void addCarroGT(String marca,String modelo,int cilindrada,int potenciaMC,double taxa_degradacao) {
        GT gt = new GT(marca,modelo,cilindrada,potenciaMC,taxa_degradacao);
        this.carros.put(gt.getMarca(),gt);
        System.out.println(this.carros.get(gt.getMarca()));
    }
    public void addCarroGTHbr(String marca,String modelo,int cilindrada,int potenciaMC,double taxa_degradacao, int potenciaME) {
        GTHibr gthbr = new GTHibr(marca,modelo,cilindrada,potenciaMC,taxa_degradacao,potenciaME);
        this.carros.put(gthbr.getMarca(),gthbr);
        System.out.println(this.carros.get(gthbr.getMarca()));
    }


    public Collection<Circuito> getCircuitos() {
        return this.circuitos.values().stream().toList();
    }

    public Piloto getPiloto(String nomePiloto){return this.pilotos.get(nomePiloto);}

    public Collection <Piloto> getPilotos(){
        return this.pilotos.values().stream().toList();
    }

    public Campeonato getCampeonato(String nome){
        Campeonato c = new Campeonato();
        c=this.campeonatos.get(nome);
        ArrayList <Circuito> lCirc=new ArrayList<>();
        for(Circuito m : c.getLc().values()){
            lCirc.add(this.circuitos.get(m.getNome_circuito()));
        }
        return  new Campeonato(nome,lCirc);
    }
    public Collection<Campeonato> getCampeonatos() {
        return this.campeonatos.values().stream().toList();
    }

    public Carro getCarro(String marcaModelo){
        return this.carros.get(marcaModelo);
    }

    public Collection <Carro> getCarros(){
        return this.carros.values().stream().toList();
    }

}