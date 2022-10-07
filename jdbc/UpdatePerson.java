package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class UpdatePerson {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o codigo da pessoa: ");
        int code = input.nextInt();

        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        String update = "UPDATE pessoas SET nome=? WHERE codigo=?";

        Connection conn = ConnectionFactory.getConnectionDB();

        PreparedStatement stmt = conn.prepareStatement(select);
        stmt.setInt(1, code);
        ResultSet r = stmt.executeQuery();

        if(r.next()) {
            Person p = new Person(r.getInt(1), r.getString(2));

            System.out.println("Nome atual: " + p.getName());
            input.nextLine();

            System.out.println("Informe o novo nome: ");
            String newName = input.nextLine();

            stmt.close();
            stmt = conn.prepareStatement(select);
            stmt.setString(1, newName);
            stmt.setInt(2, code);

            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa nao encontrada!");
        }
        conn.close();
        input.close();
    }
}
