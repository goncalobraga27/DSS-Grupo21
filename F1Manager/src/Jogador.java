public class Jogador extends Utilizador {
    private int pontuacao;

    public Jogador(Jogador that) {
        super(that.getNomeUtilizador(), that.getPassword());
        this.pontuacao = that.pontuacao;
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
}