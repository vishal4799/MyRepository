package com.bmc.io;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		File file=new File("\\IO\\File1.txt");
		
		System.out.println("Exists or not ?"+file.exists());
		System.out.println("Whether is directory ?"+file.isDirectory());
		System.out.println("Size:"+file.length());
		
		//File class represents FileSystem-Local,Remote
		
		//Reads  properties from java.properties
		Properties properties=System.getProperties();
		//Returns names of property
		Enumeration enumeration=properties.propertyNames();
			//based on name of property, value can be fetched
		while(enumeration.hasMoreElements()){
			String propertyName=(String)enumeration.nextElement();
			System.out.println("Property name:"+propertyName+" Value:"+properties.getProperty(propertyName));
		}
		
		
		
		
		File rootDirs[]=file.listRoots();
		for(File root:rootDirs){
			
			System.out.println(root);
			System.out.println("Total space:"+root.getTotalSpace());
			System.out.println("Free space:"+root.getFreeSpace());
			
		}

	}

}
