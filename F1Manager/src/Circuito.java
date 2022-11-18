public class Circuito {

    private String nome_circuito;
    private double distancia;
    private int n_curvas;
    private int n_chicanes;
    private int n_retas;
    private int n_voltas;

    public Circuito(Circuito that) {
        this.nome_circuito = that.nome_circuito;
        this.distancia = that.distancia;
        this.n_curvas = that.n_curvas;
        this.n_chicanes = that.n_chicanes;
        this.n_retas = that.n_retas;
        this.n_voltas = that.n_voltas;
    }

    public String getnome() {
        return this.nome_circuito;
    }

    public double getdistancia() {
        return this.distancia;
    }

    public int getn_curvas() {
        return this.n_curvas;
    }

    public int getn_chicanes() {
        return this.n_chicanes;
    }

    public int getn_retas() {
        return this.n_retas;
    }

    public int getn_voltas() {
        return this.n_voltas;
    }

    public void setnome(String nome) {
        this.nome_circuito = nome;
    }

    public void setdistancia(double dist) {
        this.distancia = dist;
    }

    public void setn_curvas(int curvas) {
        this.n_curvas = curvas;
    }

    public void setn_chicanes(int chicanes) {
        this.n_chicanes = chicanes;
    }

    public void setn_retas(int retas) {
        this.n_retas = retas;
    }

    public void set_nvoltas(int voltas) {
        this.n_voltas = voltas;
    }

    public Circuito clone() {
        return new Circuito(this);
    }
}
