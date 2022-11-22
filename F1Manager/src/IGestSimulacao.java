import Carro.Carro;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface IGestSimulacao {
    public List<Carro> getCarros();
    public List<Corrida> getCorridas();
    public List<Registo> getRegistos();
    public Map<Corrida, TreeSet<Iteracao>> simulaCampeonato();
}