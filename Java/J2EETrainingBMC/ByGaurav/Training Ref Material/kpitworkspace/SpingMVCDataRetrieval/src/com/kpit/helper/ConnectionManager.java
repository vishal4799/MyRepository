package com.kpit.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager {
	
	private Connection connection;
	@Autowired
	private DataSource datasource;
	
	public Connection openConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName(datasource.getDriver());
		connection=DriverManager.getConnection(datasource.getUrl(),datasource.getUsername(),datasource.getPassword());
		return connection;
		
	}
	
	public void closeConnection() throws SQLException{
		connection.close();
		
		
	}

}
