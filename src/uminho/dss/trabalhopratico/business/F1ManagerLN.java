package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.data.CampeonatoDAO;
import uminho.dss.trabalhopratico.data.CarroDAO;
import uminho.dss.trabalhopratico.data.CircuitoDAO;
import uminho.dss.trabalhopratico.data.PilotoDAO;

import java.util.*;

import static java.awt.SystemColor.menu;

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

    public void addCarroSC(String marca,String modelo,int cilindrada,int potenciaMC,double fiabilidade) {
        this.campeonatos.addCarroSC(marca,modelo,cilindrada,potenciaMC,fiabilidade);
    }

    public void addCarroGT(String marca,String modelo,int cilindrada,int potenciaMC,double taxa_degradacao) {
        this.campeonatos.addCarroGT(marca,modelo,cilindrada,potenciaMC,taxa_degradacao);
    }
    public void addCarroGTHbr(String marca,String modelo,int cilindrada,int potenciaMC,double taxa_degradacao,int potenciaME) {
        this.campeonatos.addCarroGTHbr(marca,modelo,cilindrada,potenciaMC,taxa_degradacao,potenciaME);
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
    public Piloto getPiloto(String nomePiloto){
        return this.campeonatos.getPiloto(nomePiloto);
    }
    public Collection<Piloto> getPilotos(){return this.campeonatos.getPilotos();}
    public  Campeonato getCampeonato(String nome){
        return this.campeonatos.getCampeonato(nome);
    }
    public Carro getCarro(String MarcaModelo){return this.campeonatos.getCarro(MarcaModelo);}
    public Collection<Carro> getCarros(){return this.campeonatos.getCarros();}
    public Jogador getJogador(String username){return this.gUsers.getJogador(username);}
    public Collection<Campeonato> getCampeonatos() {
        return this.campeonatos.getCampeonatos();
    }

    public void simula(String marcaModelo,String nomePiloto,String username,String nomeChamp){
        Registo r1= new Registo(1,this.getCarro(marcaModelo),this.getPiloto(nomePiloto),this.getJogador(username));
        Registo r2= new Registo(2,this.getCarro("Alfa Romeo Guilia GTAm"),this.getPiloto("Carles Senz"),this.getJogador("Onofre"));
        Registo r3= new Registo(3,this.getCarro("Mercedes A180"),this.getPiloto("Cercio Peraz"),this.getJogador("Acacio Carvalho"));
        Registo r4= new Registo(4,this.getCarro("Lexus LFA R"),this.getPiloto("Sbinalla"),this.getJogador("Jacinto Leite"));
        Registo r5= new Registo(5,this.getCarro("Audi TT RS"),this.getPiloto("Mex Verstapene"),this.getJogador("Capelo Rego"));
        Map<Integer, Registo> regs=new HashMap<>();
        regs.put(1,r1);regs.put(2,r2);regs.put(3,r3);regs.put(4,r4);regs.put(5,r5);
        Campeonato championship= this.campeonatos.getCampeonato(nomeChamp);
        List<Circuito> lc = championship.listCorridas();
        for( Circuito c: lc) {
            Simulacao s = new Simulacao(regs, c);
            for(int i=1;i<=c.getN_voltas();i++) {
                TreeSet<Iteracao> it = s.simulaVolta();
                it.forEach(its->System.out.println(its.toString()));
            }
        }


    }

}
