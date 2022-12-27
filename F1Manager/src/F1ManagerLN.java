
import java.util.Map;

public class F1ManagerLN {
    private Map<String,Carro> carros;
    private Map<String,Campeonato> campeonatos;
    public F1ManagerLN(){
        this.carros=CarroDAO.getInstance();
        this.campeonatos=CampeonatoDAO.getInstance();
    }
}
