package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.Carro.Carro;
import uminho.dss.trabalhopratico.Piloto.Piloto;

import java.time.LocalDateTime;

public class Registo implements Comparable<Registo> {
    private final int idRegisto;
    private int nAfinacoes;
    private final Carro carro;
    private final Piloto piloto;
    private final Jogador jogador;
    private LocalDateTime dataRegisto;
    private double probUltrapassar;

    public Registo(int idRegisto, Carro c, Piloto p, Jogador j) {
        this.idRegisto = idRegisto;
        this.nAfinacoes = 0;
        this.carro = c;
        this.piloto = p;
        this.jogador = j;
        this.dataRegisto = LocalDateTime.now();
        this.probUltrapassar = 1.;
    }

    public Registo(Registo that) {
        this.idRegisto = that.idRegisto;
        this.nAfinacoes = that.nAfinacoes;
        this.carro = that.carro.clone();
        this.piloto = that.piloto.clone();
        this.jogador = that.jogador.clone();
        this.dataRegisto = LocalDateTime.from(that.dataRegisto);
        this.probUltrapassar = 1.;
    }

    public int compareTo(Registo r) {
        return dataRegisto.compareTo(r.getDataRegisto());
    }

    public double getProbUltrapassar() {
        return probUltrapassar;
    }

    public void setProbUltrapassar(double probUltrapassar) {
        this.probUltrapassar = probUltrapassar;
    }

    public void setnAfinacoes(int nAfinacoes) {
        this.nAfinacoes = nAfinacoes;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public LocalDateTime getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(LocalDateTime dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public int getIdRegisto() {
        return idRegisto;
    }

    public int getnAfinacoes() {
        return nAfinacoes;
    }

    public Carro getCarro() {
        return carro.clone();
    }

    public Piloto getPiloto() {
        return piloto.clone();
    }

    public void afinar() {
        ++this.nAfinacoes;
    }

    @Override
    public Registo clone() {
        return new Registo(this);
    }

    @Override
    public String toString() {
        return String.format(
            "%" + 32 + "s | %" + 32 + "s | %" + 32 + "s",
            jogador.getNomeUtilizador(),
            piloto.getNomePiloto(),
            carro.getMarca()
        );
    }
}