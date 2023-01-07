package uminho.dss.trabalhopratico.data;


import uminho.dss.trabalhopratico.Utilizador.Jogador;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JogadorDAO implements Map<String, Jogador> {
    private static JogadorDAO singleton = null;

    private JogadorDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS jogador (" +
                    "Username varchar(45) NOT NULL PRIMARY KEY," +
                    "Password varchar(45) NOT NULL,"+
                    "Pontuacao INT DEFAULT 0)";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static JogadorDAO getInstance() {
        if (JogadorDAO.singleton == null) {
            JogadorDAO.singleton = new JogadorDAO();
        }
        return JogadorDAO.singleton;
    }
    /**
     * Obter um carro, dado o seu id
     *
     * @param key id do carro
     * @return do carro caso exista (null noutro caso)
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    public Jogador get(Object key) {
        Jogador a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM jogador WHERE Username='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                a=new Jogador(rs.getString(1),rs.getString(2),rs.getInt(3));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return a;
    }



    /**
     * @return número de carros na base de dados
     */
    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM jogador")) {
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
                     stm.executeQuery("SELECT Username FROM jogador WHERE Username='"+key.toString()+"'")) {
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
        Jogador c = (Jogador) value;
        Jogador j=this.get(c.getNomeUtilizador());
        if (j!=null && j.getNomeUtilizador().equals(c.getNomeUtilizador()) && j.getPassword().equals(c.getPassword())){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Jogador put(String key, Jogador c) {
        Jogador res = null;
        if (!this.containsKey(key)) {
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                stm.executeUpdate(
                        "INSERT INTO jogador(Username,Password) VALUES ('"+c.getNomeUtilizador()+"', '"+c.getPassword()+"') ");
            } catch (SQLException e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }
        return res;
    }

    @Override
    public Jogador remove(Object key) {
        Jogador c = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();) {
            // apagar os jogadors
            stm.executeUpdate("DELETE FROM jogador WHERE Username='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Jogador> jogadores) {
        for(Jogador c : jogadores.values()) {
            this.put(c.getNomeUtilizador(), c);
        }
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE jogador");
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
    public Collection<Jogador> values() {
        Collection<Jogador> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT Username FROM jogador")) { // ResultSet com os ids de todas as turmas
            while (rs.next()) {
                String idC = rs.getString(0); // Obtemos um id do carro do ResultSet
                Jogador c = this.get(idC);                    // Utilizamos o get para construir os carros uma a uma
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
    public Set<Entry<String, Jogador>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }



}



