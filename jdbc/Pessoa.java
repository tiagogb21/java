package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
    int code;
    String name;

    public Pessoa(int code, String name) {
        this.code = code;
        this.name = name;
    }

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

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
