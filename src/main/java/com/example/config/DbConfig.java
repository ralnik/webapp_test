package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class DbConfig {
	
	@Value("${dbdriver}")
	private String dbDriver;
	
	@Value("${dbuser}")
	private String dbUser;
	
	@Value("${dbpassword}")
	private String dbPassword;
	
	@Value("${dbconnection}")
	private String dbConnection;

	@Bean(name = "connectDb")
	@Scope(scopeName = "prototype")
	DBConnection getConnection() {
		return new DBConnection(dbDriver, dbConnection, dbUser, dbPassword);		 
	}
} 
