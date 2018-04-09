package com.bmc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dbinfo=new File("d:\\io\\DBInfo.properties");
		//Blank properties object
		Properties properties=new Properties();
		InputStream binaryStream=new FileInputStream(dbinfo);
		properties.load(binaryStream);
		//utitlize information from properties file for further processsing
		System.out.println(properties.getProperty("driver"));

	}

}