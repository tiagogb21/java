package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ReadPeople {
    public static void main(String[] args) throws SQLException {
        Connection personConection = ConnectionFactory.getConnectionDB();
        String querySql = "SELECT * FROM pessoas";

        Statement statement = personConection.createStatement();
        ResultSet resultConnection = statement.executeQuery(querySql);
        
        List<Pessoa> person = new ArrayList<>();

        while(resultConnection.next()) {
            int codigo = resultConnection.getInt("codigo");
            String nome = resultConnection.getString("nome");
            person.add(new Pessoa(codigo, nome));
        }

        for(Pessoa p: person) {
            System.out.println(p.getCode() + " --> " + p.getName());
        }

        statement.close();
        personConection.close();
    }
}
