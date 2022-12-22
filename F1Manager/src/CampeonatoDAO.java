import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CampeonatoDAO {
    private static CampeonatoDAO singleton = null;

    private CampeonatoDAO() {
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS campeonatos(" +
                    "Id varchar(10) NOT NULL PRIMARY KEY,"+
                    "NomeCampeonato varchar(10) NOT NULL";
            ((Statement)stm).executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}
