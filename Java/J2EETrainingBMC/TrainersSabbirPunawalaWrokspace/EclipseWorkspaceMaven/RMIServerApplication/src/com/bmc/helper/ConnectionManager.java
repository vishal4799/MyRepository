package com.bmc.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private Connection connection=null;
	public Connection openConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sabbir","sabbir");
		return connection;
	}
	
	public void closeConnection() throws SQLException{
		
		connection.close();
	}

}
