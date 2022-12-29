package uminho.dss.trabalhopratico.data;

import uminho.dss.trabalhopratico.business.Circuito;
import uminho.dss.trabalhopratico.business.SeccaoCircuito;

import java.sql.*;
import java.util.*;

public class CircuitoDAO implements Map<String, Circuito> {

    private static CircuitoDAO singleton = null;

    private CircuitoDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
             String sql = "CREATE TABLE IF NOT EXISTS circuito(" +
                    "nomeCircuito varchar(30) NOT NULL PRIMARY KEY," +
                    "distancia double NOT NULL,"+
                    "n_curvas int NOT NULL," +
                    "n_chicanes int NOT NULL,"+
                    "n_voltas int NOT NULL)";
             stm.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS SeccaoCircuito(" +
                    "nomeCircuito varchar(30) NOT NULL," +
                    "tipoSeccao int NOT NULL,"+
                    "n_ordem int NOT NULL,"+
                    "gdu double NOT NULL,"+
                    "PRIMARY KEY (nomeCircuito,n_ordem),"+
                    "foreign key(nomeCircuito) references circuito(nomeCircuito))";

            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static CircuitoDAO getInstance() {
        if (CircuitoDAO.singleton == null) {
            CircuitoDAO.singleton = new CircuitoDAO();
        }
        return CircuitoDAO.singleton;
    }
    /**
     * Obter um carro, dado o seu id
     *
     * @param key id do carro
     * @return do carro caso exista (null noutro caso)
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */

    public Circuito get(Object key) {
        Circuito c = null;
        ArrayList<SeccaoCircuito> seccoes= new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM circuito WHERE Id='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                ResultSet r = stm.executeQuery("SELECT * FROM SeccaoCircuito WHERE Id='"+key+"'");
                while (r.next()) {
                    SeccaoCircuito s = new SeccaoCircuito(r.getInt(2),r.getInt(3),r.getDouble(4));
                    seccoes.add(s);
                }
                c = new Circuito(rs.getString(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),seccoes);
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    /**
     * @return número de carros na base de dados
     */
    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM Circuitos")) {
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return i;
    }

    /**
     * Método que verifica se existem carros
     *
     * @return true se existirem 0 carros
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Método que cerifica se um id de turma existe na base de dados
     *
     * @param key id da turma
     * @return true se a turma existe
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public boolean containsKey(Object key) {
        boolean r;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs =
                     stm.executeQuery("SELECT nomeCircuito FROM circuito WHERE nomeCircuito='"+key.toString()+"'")) {
            r = rs.next();
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    /**
     * Verifica se uma turma existe na base de dados
     *
     * Esta implementação é provisória. Devia testar o objecto e não apenas a chave.
     *
     * @param value ...
     * @return ...
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public boolean containsValue(Object value) {
        Circuito c = (Circuito) value;
        return this.containsKey(c.getNome_circuito());
    }

    @Override
    public Circuito put(String key, Circuito c) {
        Circuito res = null;
        if (!this.containsKey(key)) {
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                // Actualizar a turma
                stm.executeUpdate(
                        "INSERT INTO circuito VALUES ('" + c.getNome_circuito() + "', '" +c.getDistancia()+ "', '" +c.getN_curvas() + "', '" +c.getN_chicanes() + "', '" +c.getN_voltas()+ "')"
                );
                for (SeccaoCircuito m : c.getSeccoes()) {
                    stm.executeUpdate(
                            "INSERT INTO SeccaoCircuito VALUES ('" + c.getNome_circuito() + "', '" +m.getTipoSeccao()+ "', '" +m.getOrdem() + "', '" +m.getGDU() + "') "
                    );
                }
                // FALTA ACRESCENTAR CORRIDAS Á TABELA QUE ESTÃO COMO VARIAVEL DE INSTÂNCIA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            } catch (SQLException e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }
        return res;
    }

    @Override
    public Circuito remove(Object key) {
        Circuito c = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();) {
            // apagar os Circuitos
            stm.executeUpdate("DELETE FROM circuito WHERE nomeCircuito='"+key+"'");
            stm.executeUpdate("DELETE FROM SeccaoCircuito WHERE nomeCircuito='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Circuito> Circuitos) {
        for(Circuito c : Circuitos.values()) {
            this.put(c.getNome_circuito(), c);
        }
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE circuito");
            stm.executeUpdate("TRUNCATE SeccaoCircuito");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    /**
     * @return Todos os carros da base de dados
     */
    @Override
    public Collection<Circuito> values() {
        Collection<Circuito> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT nomeCircuito FROM circuito")) {
            while (rs.next()) {
                String idC = rs.getString("nomeCircuito"); // Obtemos um id do carro do ResultSet
                Circuito c = this.get(idC);                    // Utilizamos o get para construir os carros uma a uma
                res.add(c);                                 // Adiciona o carro ao resultado.
            }
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }
    @Override
    public Set<Entry<String, Circuito>> entrySet() {
        throw new NullPointerException( "not implemented!");
    }
}
