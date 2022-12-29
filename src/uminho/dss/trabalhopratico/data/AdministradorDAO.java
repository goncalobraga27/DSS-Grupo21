package uminho.dss.trabalhopratico.data;
import uminho.dss.trabalhopratico.business.Administrador;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdministradorDAO implements Map<String, Administrador> {
    private static AdministradorDAO singleton = null;

    private AdministradorDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS administrador (" +
                    "Username varchar(45) NOT NULL PRIMARY KEY," +
                    "Password varchar(45) NOT NULL)";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static AdministradorDAO getInstance() {
        if (AdministradorDAO.singleton == null) {
            AdministradorDAO.singleton = new AdministradorDAO();
        }
        return AdministradorDAO.singleton;
    }
    /**
     * Obter um carro, dado o seuusername
     *
     * @param key username do carro
     * @return do carro caso exista (null noutro caso)
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    public Administrador get(Object key) {
        Administrador a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM administrador WHERE Username='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                a=new Administrador(rs.getString(1),rs.getString(2));
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
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM administrador")) {
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
     * Método que cerifica se umusername de turma existe na base de dados
     *
     * @param key username da turma
     * @return true se a turma existe
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public boolean containsKey(Object key) {
        boolean r;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs =
                     stm.executeQuery("SELECT Username FROM administrador WHERE Username='"+key.toString()+"'")) {
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
        Administrador c = (Administrador) value;
        return c.equals(this.get(c.getNomeUtilizador()));
    }

    @Override
    public Administrador put(String key, Administrador c) {
        Administrador res = null;
        if (!this.containsKey(key)) {
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                stm.executeUpdate(
                        "INSERT INTO administrador VALUES ('" + c.getNomeUtilizador() +"', '"+c.getPassword()+ "') "
                );
            } catch (Exception e) {
                System.out.println("Administrador inválido");
            }
        }
        return res;
    }

    @Override
    public Administrador remove(Object key) {
        Administrador c = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();) {
            // apagar os Administradors
            stm.executeUpdate("DELETE FROM administrador WHERE Username='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Administrador> Administradores) {
        for(Administrador c : Administradores.values()) {
            this.put(c.getNomeUtilizador(), c);
        }
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE administrador");
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
    public Collection<Administrador> values() {
        Collection<Administrador> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT Username FROM administrador")) { // ResultSet com osusernames de todas as turmas
            while (rs.next()) {
                String idC = rs.getString("Username"); // Obtemos um username do carro do ResultSet
                Administrador c = this.get(idC);                    // Utilizamos o get para construir os carros uma a uma
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
    public Set<Entry<String, Administrador>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }



}



