package uminho.dss.trabalhopratico.data;

import uminho.dss.trabalhopratico.Carro.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarroDAO implements Map<String, Carro> {
    private static CarroDAO singleton = null;

    private CarroDAO() {

        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS carros(" +
                    "Categoria varchar(10) NOT NULL," +
                    "MarcaModelo varchar(45) DEFAULT NULL," +
                    "Cilindrada INT NOT NULL,"+
                    "Potencia INT NOT NULL,"+
                    "Fiabilidade DOUBLE NOT NULL,"+
                    "TaxaDegradacao DOUBLE DEFAULT NULL,"+
                    "MotorEletrico INT DEFAULT NULL," +
                    "PRIMARY KEY (MarcaModelo))";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
    /**
     * Implementação do padrão Singleton
     *
     * @return devolve a instância única desta classe
     */
    public static CarroDAO getInstance() {
        if (CarroDAO.singleton == null) {
            CarroDAO.singleton = new CarroDAO();
        }
        return CarroDAO.singleton;
    }

    /**
     * Obter um carro, dado o seu id
     *
     * @param key id do carro
     * @return do carro caso exista (null noutro caso)
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */

    public Carro get(Object key) {
        Carro t = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM carros WHERE MarcaModelo='"+key+"'")) {
            if (rs.next()) {
                if(rs.getString(1).equals(("SC"))){
                    t=new SC(rs.getString(2),"",rs.getInt(3),rs.getInt(4),rs.getDouble(5));
                }
                else if (rs.getString(1).equals("C1")){
                    t=new C1(rs.getString(2),"",rs.getInt(4));
                }
                else if (rs.getString(1).equals("C2")){
                    t=new C2(rs.getString(2),"",rs.getInt(3),rs.getInt(4));
                }
                else if (rs.getString(1).equals("GT")){
                    t=new GT(rs.getString(2),"",rs.getInt(3),rs.getInt(4),rs.getDouble(6));
                }
                else if (rs.getString(1).equals("C1Hbr")){
                    t=new C1Hbr(rs.getString(2),"",rs.getInt(4),rs.getInt(7));
                }
                else if (rs.getString(1).equals("C2Hbr")){
                    t=new C2Hbr(rs.getString(2),"",rs.getInt(3),rs.getInt(4),rs.getInt(7));
                }
                else {
                    t=new GTHibr(rs.getString(2),"",rs.getInt(3),rs.getInt(4),rs.getInt(6),rs.getInt(7));
                }



            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return t;
    }

    /**
     * @return número de carros na base de dados
     */
    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM carros")) {
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
                     stm.executeQuery("SELECT MarcaModelo FROM carros WHERE MarcaModelo='"+key.toString()+"'")) {
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
        Carro c = (Carro) value;
        return this.containsKey(c.getId());
    }

    @Override
    public Carro put(String key, Carro c) {
        Carro res = null;
        if (!this.containsKey(key)) {
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                if (c.getClass()==C1.class){
                    C1 c1=(C1) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade) VALUES ('" +"C1"+  "', '" + c1.getMarca() +  "', '" + c1.getCilindrada() + "', '" + c1.getPotencia() + "', '" + c1.getFiabilidade() +  "') "
                    );
                }
                if (c.getClass()==C2.class){
                    C2 c2=(C2) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade) VALUES ('" +"C2"+  "', '" + c2.getMarca() +  "', '" + c2.getCilindrada() + "', '" + c2.getPotencia() + "', '" + c2.getFiabilidade() +  "') "
                    );
                }
                if (c.getClass()==GT.class){
                    GT gt=(GT) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade,TaxaDegradacao) VALUES ('" +"GT"+  "', '" + gt.getMarca() +  "', '" + gt.getCilindrada() + "', '" + gt.getPotencia() + "', '" + gt.getFiabilidade() +"', '" + gt.gettaxa_degradacao()+ "') "
                    );
                }
                if(c.getClass() == C1Hbr.class) {
                    C1Hbr c1= (C1Hbr) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade,MotorEletrico) VALUES ('" +"C1Hbr"+  "', '" + c1.getMarca() +  "', '" + c1.getCilindrada() + "', '" + c1.getPotencia() + "', '" + c1.getFiabilidade() + "', '" + ((C1Hbr) c).getMotor_eletrico() + "') "
                    );
                }
                else if(c.getClass() == C2Hbr.class) {
                    C2Hbr c1= (C2Hbr) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade,MotorEletrico) VALUES ('" +"C2Hbr"+  "', '" + c1.getMarca() +  "', '" + c1.getCilindrada() + "', '" + c1.getPotencia() + "', '" + c1.getFiabilidade() + "', '" + ((C2Hbr) c).getMotor_eletrico() + "') "
                    );
                }
                else if(c.getClass() == GTHibr.class) {
                    GTHibr c1= (GTHibr) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade,TaxaDegradacao,MotorEletrico) VALUES ('" +"GTHibr"+  "', '" + c1.getMarca() +  "', '" + c1.getCilindrada() + "', '" + c1.getPotencia() + "', '" + c1.getFiabilidade() + "', '" + c1.gettaxa_degradacao()+"', '" +((GTHibr) c).getMotor_eletrico() + "') "
                    );
                }
                else if (c.getClass() == SC.class){
                    SC c1= (SC) c;
                    stm.executeUpdate(
                            "INSERT INTO carros(Categoria,MarcaModelo,Cilindrada,Potencia,Fiabilidade) VALUES ('" +"SC"+  "', '" + c1.getMarca() +  "', '" + c1.getCilindrada() + "', '" + c1.getPotencia() + "', '" + c1.getFiabilidade() +"') "
                    );
                }

            } catch (SQLException e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }
        return res;
    }

    @Override
    public Carro remove(Object key) {
        Carro c = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();) {
            // apagar os carros
            stm.executeUpdate("DELETE FROM carros WHERE MarcaModelo='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Carro> carros) {
        for(Carro c : carros.values()) {
            this.put(c.getId(), c);
        }
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE carros");
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
    public Collection<Carro> values() {
        Collection<Carro> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT MarcaModelo FROM carros")) { // ResultSet com os ids de todas as turmas
            while (rs.next()) {
                String idC = rs.getString("MarcaModelo"); // Obtemos um id do carro do ResultSet
                Carro c = this.get(idC);                    // Utilizamos o get para construir os carros uma a uma
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
    public Set<Entry<String, Carro>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }



}
