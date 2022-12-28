
import java.util.Map;

public class F1ManagerLN {
    private Map<String,Carro> carros;
    private Map<String,Campeonato> campeonatos;
    private Map<String,Administrador> administradores;
    private Map<String,Jogador> jogadores;

    public F1ManagerLN(){
        this.carros=CarroDAO.getInstance();
        this.campeonatos=CampeonatoDAO.getInstance();
        this.administradores=AdministradorDAO.getInstance();
        this.jogadores=JogadorDAO.getInstance();
    }
}
