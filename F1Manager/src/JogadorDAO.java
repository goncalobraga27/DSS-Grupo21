import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JogadorDAO implements Map<String,Jogador> {
    private static JogadorDAO singleton = null;

    private JogadorDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Jogador(" +
                    "Id varchar(10) NOT NULL PRIMARY KEY,"+
                    "Username varchar(45) NOT NULL," +
                    "Password varchar(45) NOT NULL";
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
             ResultSet rs = stm.executeQuery("SELECT * FROM Jogador WHERE Id='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
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
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM Jogador")) {
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
                     stm.executeQuery("SELECT Id FROM Jogador WHERE Id='"+key.toString()+"'")) {
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
        return this.containsKey(c.getId());
    }

    @Override
    public Jogador put(String key, Jogador c) {
        Jogador res = null;
        if (!this.containsKey(key)) {
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                // Actualizar a turma
                stm.executeUpdate(
                        "INSERT INTO Jogador VALUES ('" + c.getId() + "', '" + c.getNomeUtilizador() +"', '"+c.getPassword()+ "') "
                );
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
            // apagar os Jogadors
            stm.executeUpdate("DELETE FROM Jogador WHERE Id='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Jogador> Jogadores) {
        for(Jogador c : Jogadores.values()) {
            this.put(c.getId(), c);
        }
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE Jogador");
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
             ResultSet rs = stm.executeQuery("SELECT Id FROM Jogador")) { // ResultSet com os ids de todas as turmas
            while (rs.next()) {
                String idC = rs.getString("Id"); // Obtemos um id do carro do ResultSet
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