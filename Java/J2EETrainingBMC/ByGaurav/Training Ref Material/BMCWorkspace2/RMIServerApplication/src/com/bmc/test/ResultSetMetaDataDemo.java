package com.bmc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.bmc.helper.ConnectionManager;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConnectionManager manager=new ConnectionManager();
		try {
			Connection connection=manager.openConnection();
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from employees");
			ResultSetMetaData rsm=resultSet.getMetaData();
			
			int cols=rsm.getColumnCount();
			
			for(int i=1;i<=cols;i++){
				System.out.println("Column Name:"+rsm.getColumnName(i));
				System.out.println("Column Type:"+rsm.getColumnTypeName(i));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
