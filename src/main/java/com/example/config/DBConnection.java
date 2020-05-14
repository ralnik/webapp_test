package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DBConnection {
	private final String driver;
	private final String connectionString;
	private final String user;
	private final String password;
	private Connection connection;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(connectionString,user,password);
			return this.connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}	
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
