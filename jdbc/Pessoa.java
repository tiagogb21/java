package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
    public static void main(String[] args) throws SQLException {
        Connection personConection = ConnectionFactory.getConnectionDB();
        String querySql = "CREATE TABLE IF NOT EXISTS pessoas ("
        + "codigo INT AUTO_INCREMENT PRIMARY KEY,"
        + "nome VARCHAR(80) NOT NULL"
        + ")";

        Statement statement = personConection.createStatement();
        statement.execute(querySql);

        System.out.println("Tabela criada com sucesso!");
        personConection.close();
    }
}
