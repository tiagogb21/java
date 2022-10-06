package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnectionDB() {
        try {
            final String url = "jdbc:mysql://localhost:3306/pessoas";
            final String user = "root";
            final String password = "123456";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
