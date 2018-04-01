package com.bmc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.bmc.entities.Employee;

public class DeserialzieDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		
		File file=new File("D:\\IO\\employee.ser");
		InputStream is=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(is);
		Employee e=(Employee)ois.readObject();
		System.out.println(e);

	}

}
