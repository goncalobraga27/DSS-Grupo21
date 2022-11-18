import Carro.Carro;

public class Registo {

    private final int idRegisto;
    private int nAfinacoes;
    private final Carro carro;
    private final Piloto piloto;
    private final Jogador jogador;

    public Registo(int idRegisto, Carro c, Piloto p, Jogador j) {
        this.idRegisto = idRegisto;
        this.nAfinacoes = 0;
        this.carro = c;
        this.piloto = p;
        this.jogador = j;
    }
    public Registo(Registo that) {
        this.idRegisto = that.idRegisto;
        this.nAfinacoes = that.nAfinacoes;
        this.carro = that.carro.clone();
        this.piloto = that.piloto.clone();
        this.jogador = that.jogador.clone();
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

    public Registo clone() {
        return new Registo(this);
    }
}