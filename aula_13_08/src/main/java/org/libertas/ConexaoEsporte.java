package org.libertas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoEsporte {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/cadastroapi"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "root";  
    
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver"); 
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public void desconecta() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
