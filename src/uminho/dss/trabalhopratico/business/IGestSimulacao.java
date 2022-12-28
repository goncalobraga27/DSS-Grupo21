package uminho.dss.trabalhopratico.business;

import uminho.dss.trabalhopratico.business.Carro;
import uminho.dss.trabalhopratico.business.Corrida;
import uminho.dss.trabalhopratico.business.Iteracao;
import uminho.dss.trabalhopratico.business.Registo;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface IGestSimulacao {
    public List<Carro> getCarros();
    public List<Corrida> getCorridas();
    public List<Registo> getRegistos();
    public Map<Corrida, TreeSet<Iteracao>> simulaCampeonato();
}