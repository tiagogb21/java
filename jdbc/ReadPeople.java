package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ReadPeople {
    public static void main(String[] args) throws SQLException {
        Connection peopleConection = ConnectionFactory.getConnectionDB();
        String querySql = "SELECT * FROM pessoas";

        Statement statement = peopleConection.createStatement();
        ResultSet resultConnection = statement.executeQuery(querySql);
        
        List<Person> people = new ArrayList<>();

        while(resultConnection.next()) {
            int codigo = resultConnection.getInt("codigo");
            String nome = resultConnection.getString("nome");
            people.add(new Person(codigo, nome));
        }

        for(Person p: people) {
            System.out.println(p.getCode() + " --> " + p.getName());
        }

        statement.close();
        peopleConection.close();
    }
}
