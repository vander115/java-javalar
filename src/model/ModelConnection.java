package model;

import java.sql.*;

public class ModelConnection {
	private String hostName;
	private String userName;
	private String password;
	private String database;

	public ModelConnection() {
		this.hostName = "da_java.mysql.dbaas.com.br";
		this.database = "da_java";
		this.userName = "da_java";
		this.password = "Tecnicas*2023@";
	}

	public Connection getConnection() {
		String url = "jdbc:mysql://" + this.hostName + "/" + this.database + "?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, userName, password);
		} catch (SQLException ex) {
			System.out.println("Não foi possível realizar conexão com o banco de dados :(");
			ex.printStackTrace();
		}
		return null;
	}
}
