package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadPeopleWithCondition {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection peopleConection = ConnectionFactory.getConnectionDB();

		System.out.println("Informe o nome (ou parte dele) para pesquisa:\n");
		String choose = scanner.nextLine();

        String querySql = "SELECT * FROM pessoas WHERE nome LIKE ?";

        PreparedStatement statement = peopleConection.prepareStatement(querySql);

        statement.setString(1, "%" + choose + "%");

        ResultSet resultConnection = statement.executeQuery();
        
        List<Pessoa> people = new ArrayList<>();

        while(resultConnection.next()) {
            int codigo = resultConnection.getInt("codigo");
            String nome = resultConnection.getString("nome");
            people.add(new Pessoa(codigo, nome));
        }

        for(Pessoa p: people) {
            System.out.println(p.getCode() + " --> " + p.getName());
        }

        statement.close();
        peopleConection.close();

        scanner.close();
    }
}
