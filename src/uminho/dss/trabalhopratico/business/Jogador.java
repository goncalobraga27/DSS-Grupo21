package uminho.dss.trabalhopratico.business;

public class Jogador extends Utilizador {
    private int pontuacao;


    public Jogador(Jogador that) {
        super(that.getNomeUtilizador(), that.getPassword());
        this.pontuacao = that.pontuacao;
    }
    public Jogador(String username,String password,int pontuacao){
        super(username,password);
        this.pontuacao = pontuacao;
    }
    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Jogador clone() {
        return new Jogador(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador that = (Jogador) o;
        return super.equals(that) && this.pontuacao==that.getPontuacao();
    }

    @Override
    public String toString() {
        return "Jogador{" +
                super.toString()+
                "pontuacao=" + pontuacao +
                '}';
    }
}