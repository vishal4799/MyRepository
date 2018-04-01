package com.bmc.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.bmc.collection.Employee;

public class DeserializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		InputStream is=new FileInputStream("D:\\IO\\employee.ser");
		ObjectInputStream ois=new ObjectInputStream(is);
		Employee employee=(Employee)ois.readObject();
		System.out.println(employee);
		System.out.println("Company Id:"+employee.getCompanyId());
		System.out.println("Company Name:"+employee.getCompanyName());

	}

}
