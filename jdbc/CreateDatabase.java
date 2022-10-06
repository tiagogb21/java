package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main() throws SQLException {
        final String url = "jdbc:mysql://localhost:3306?verifyServerCertifcate=false&useSSL=true";
        final String user = "root";
        final String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        statement.execute("CREATE DATABASE IF NOT EXISTS pessoas");

        System.out.println("Success!");

        connection.close();
    }
}
