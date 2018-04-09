package com.bmc.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestConnection {

	public static void main(String[] args) {
		Connection dbConn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJDBC","root","password");
			Statement stmt = (Statement) dbConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
			while(rs.next()){
				System.out.println(rs.getString(1)+":"+rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}