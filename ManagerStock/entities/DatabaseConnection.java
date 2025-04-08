package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:derby:MeuBancoDeDados;create=true";

    public static Connection getConnection() throws SQLException {
        try {
            // Carrega o driver JDBC do Derby
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do Derby não encontrado!");
            throw new SQLException("Driver JDBC do Derby não encontrado!", e);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw e;
        }
    }
}