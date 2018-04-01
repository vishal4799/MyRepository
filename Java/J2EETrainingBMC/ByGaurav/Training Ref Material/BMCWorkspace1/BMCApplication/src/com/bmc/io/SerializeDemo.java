package com.bmc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.bmc.entities.Employee;

public class SerializeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Object does not exist
		
		//Object is created
		
		//Object in transient mode
		Employee e=new Employee();
		e.setEmpId(900);
		e.setEmpName("Rakesh");
		e.setEmpSalary(32000);
		e.setEmpDesignation("Trainer");
		
		File file=new File("D:\\io\\employee.ser");
		OutputStream os=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		oos.writeObject(e);
		os.close();
		
		
		
		

		
	}

}
