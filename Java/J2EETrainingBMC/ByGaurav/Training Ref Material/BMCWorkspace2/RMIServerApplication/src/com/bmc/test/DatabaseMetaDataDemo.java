package com.bmc.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.bmc.helper.ConnectionManager;

public class DatabaseMetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectionManager manager=new ConnectionManager();
        try {
			Connection connection=manager.openConnection();
			
			DatabaseMetaData dm=connection.getMetaData();
			System.out.println("Product Name:"+dm.getDatabaseProductName());
			System.out.println("Major version:"+dm.getDatabaseMajorVersion());
			System.out.println("Minor verision:"+dm.getDatabaseMinorVersion());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        
	}

}
