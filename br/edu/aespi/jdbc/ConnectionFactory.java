package br.edu.aespi.jdbc;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public Connection getConnection() throws ClassNotFoundException {
        String sqliteurl = "jdbc:sqlite:C:\\Users\\axwel\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho07\\alpoo.db";
        
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(sqliteurl);
        }   catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }


}

