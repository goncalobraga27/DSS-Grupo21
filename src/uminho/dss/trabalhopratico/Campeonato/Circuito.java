package uminho.dss.trabalhopratico.Campeonato;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Circuito {
    private String nome_circuito;
    private double distancia;
    private int n_curvas;
    private int n_chicanes;
    private int n_retas;
    private int n_voltas;
    private Deque<SeccaoCircuito> seccoes;

    public Circuito(Circuito that) {
        this.nome_circuito = that.nome_circuito;
        this.distancia = that.distancia;
        this.n_curvas = that.n_curvas;
        this.n_chicanes = that.n_chicanes;
        this.n_retas = that.n_retas;
        this.n_voltas =that.n_voltas;
        this.seccoes = new ArrayDeque<>();
        for (SeccaoCircuito m :  that.seccoes ){
            this.seccoes.add (m.clone());
        }
    }

    public Circuito(String nome_circuito,double distancia, int n_curvas, int n_chicanes, int n_voltas,ArrayList<SeccaoCircuito> s) {
        this.nome_circuito = nome_circuito;
        /*
         * cada curva tem no meio uma reta, mesma coisa com chicanes,
         * mas hÃ¡ pelo menos uma reta a ligar uma curva e uma chicane
         */
        this.n_retas = (n_curvas + 1) + n_chicanes;
        this.n_chicanes = n_chicanes;
        this.n_curvas = n_curvas;
        this.n_voltas = n_voltas;
        this.distancia = distancia;
        this.seccoes = new ArrayDeque<>();
        for (SeccaoCircuito m :  s ){
            this.seccoes.add (m.clone());
        }
    }
    public Circuito(String nome_circuito) {
        this.nome_circuito = nome_circuito;
        this.n_retas = 0;
        this.n_chicanes = 0;
        this.n_curvas = 0;
        this.n_voltas = 0;
        this.distancia =0;
        this.seccoes = new ArrayDeque<>();
    }


    public String getNome_circuito() {
        return nome_circuito;
    }

    public void setNome_circuito(String nome_circuito) {
        this.nome_circuito = nome_circuito;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getN_curvas() {
        return n_curvas;
    }

    public void setN_curvas(int n_curvas) {
        this.n_curvas = n_curvas;
    }

    public int getN_chicanes() {
        return n_chicanes;
    }

    public void setN_chicanes(int n_chicanes) {
        this.n_chicanes = n_chicanes;
    }

    public int getN_retas() {
        return n_retas;
    }

    public void setN_retas(int n_retas) {
        this.n_retas = n_retas;
    }

    public int getN_voltas() {
        return n_voltas;
    }

    public void setN_voltas(int n_voltas) {
        this.n_voltas = n_voltas;
    }

    public Deque<SeccaoCircuito> getSeccoes() {
        return seccoes;
    }

    public Circuito clone() {
        return new Circuito(this);
    }

    @Override
    public String toString() {
        return "Circuito{" +
                "nome_circuito='" + nome_circuito + '\'' +
                ", distancia=" + distancia +
                ", n_curvas=" + n_curvas +
                ", n_chicanes=" + n_chicanes +
                ", n_retas=" + n_retas +
                ", n_voltas=" + n_voltas +
                ", seccoes=" + seccoes +
                '}';
    }
}