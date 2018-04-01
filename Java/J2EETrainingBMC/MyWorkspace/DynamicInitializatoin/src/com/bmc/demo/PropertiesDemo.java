package com.bmc.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesDemo {

	public static void main(String[] args) {
		File file = new File("C:\\propertiesPathTest\\server.properties");
		try(InputStream is = new FileInputStream(file)){
			Properties prop = new Properties();
			prop.load(is);
			System.out.println("IP: "+prop.getProperty("ip"));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		//ResourceBundle bundle = ResourceBundle.getBundle("C:\\propertiesPathTest\\server.properties");//no need of extn and also path as it's already in classpath
		//System.out.println("Driver: "+bundle.getString("ip"));
	}

}
