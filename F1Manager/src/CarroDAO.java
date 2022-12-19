import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CarroDAO {
    private static CarroDAO singleton = null;

    private CarroDAO() {
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS carros(" +
                    "Id varchar(10) NOT NULL PRIMARY KEY,"+
                    "Categoria varchar(10) NOT NULL," +
                    "Marca varchar(45) DEFAULT NULL," +
                    "Modelo varchar(45) DEFAULT NULL," +
                    "Cilindrada INT NOT NULL,"+
                    "Potencia INT NOT NULL,"+
                    "Fiabilidade INT NOT NULL,"+
                    "TaxaDegradacao DOUBLE DEFAULT NULL,"+
                    "MotorEletrico INT DEFAULT NULL";
            ((Statement)stm).executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}
