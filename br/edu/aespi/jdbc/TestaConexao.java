package br.edu.aespi.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        Connection connection = new ConnectionFactory().getConnection(); {
            System.out.println("Conexão aberta!");
            
            connection.close();
        }
    
    
}
}