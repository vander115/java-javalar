package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private String hostName;
	private String userName;
	private String password;
	private String database;

	public Connector() {
//		this.hostName = "da_java.mysql.dbaas.com.br";
//		this.database = "da_java";
//		this.userName = "da_java";
//		this.password = "Tecnicas*2023@";

		this.hostName = "localhost";
		this.database = "db_javalar";
		this.userName = "root";
		this.password = "";
	}

	public Connection getConnection() {
		String url = "jdbc:mysql://" + this.hostName + "/" + this.database
				+ "?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, userName, password);
		} catch (SQLException ex) {
			System.out.println("Não foi possível realizar conexão com o banco de dados :(");
			ex.printStackTrace();
		}
		return null;
	}
}
