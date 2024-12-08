package org.libertas;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoEsporte {
	private Connection connection;
	
	public ConexaoEsporte() {
		try {
//			cria conexao com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "api", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void desconecta() {
		try {	
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	} 

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
