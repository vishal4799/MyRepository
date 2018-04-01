package com.bmc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.bmc.entities.Employee;

public class SerializeB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		B b=new B(10,20);
		File file=new File("D:\\io\\employee.ser");
		OutputStream os=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		oos.writeObject(b);
		os.close();
		
		File file1=new File("D:\\IO\\employee.ser");
		InputStream is=new FileInputStream(file1);
		ObjectInputStream ois=new ObjectInputStream(is);
		B e=(B)ois.readObject();
		System.out.println("B instance variable:"+e.getB());
		System.out.println("A instance vairable:"+e.getA());

	}

}
