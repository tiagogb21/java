package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreatePerson {
    public static void main(String[] args) throws SQLException {
        Scanner insert = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        
        String name = insert.nextLine();
        
        Connection connection = ConnectionFactory.getConnectionDB();
        
        String sql = "INSERT INTO pessoas (nome) VALUES (?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, name);
        
        statement.execute();
        
        System.out.println("Pessoa incluida com sucesso!");
        
        insert.close();
    }
}
