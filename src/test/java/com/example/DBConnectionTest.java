package com.example;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.config.DBConnection;

public class DBConnectionTest {
	
	private Connection connection;

	private Connection getNewConnection() {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbUser = "root";
		String dbPassword = "qwerty";
		String dbConnection = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		return new DBConnection(dbDriver, dbConnection, dbUser, dbPassword).getConnection();
	}
	
	@Before
	public void init() throws SQLException {
		connection = getNewConnection();
	}
	
	@After
	public void close() throws SQLException {
		connection.close();
	}
	
	@Test
	public void shouldGetJdbcConnection() throws SQLException {		 
		assertTrue(connection.isValid(1));
		assertFalse(connection.isClosed());		
	}
	
	@Test
	public void shouldSelectData() throws SQLException {	 	
	 	String query = "select id, color_number, name from tsveta";
		PreparedStatement statement = connection.prepareStatement(query);
		boolean hasResult = statement.execute();
		assertTrue(hasResult);
		ResultSet resultSet = statement.getResultSet();
		resultSet.next();
		String color_name = resultSet.getString("name");
		assertEquals("Red", color_name);
	}
}
