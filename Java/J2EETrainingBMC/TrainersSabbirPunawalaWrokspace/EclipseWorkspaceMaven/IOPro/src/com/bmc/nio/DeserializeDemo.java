package com.bmc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeserializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logger logger=Logger.getLogger("DeserializeDemo");
		logger.log(Level.INFO,"Deserializatin started:");
		InputStream is;
		try{
		File file=new File("D:\\IO\\visitor.ser");
	    is=new FileInputStream(file);
	    
	    ObjectInputStream ois=new ObjectInputStream(is);
	    Visitor visitor=(Visitor)ois.readObject();
	    System.out.println(visitor);
	    System.out.println(visitor.getUserName());
	    System.out.println(visitor.getPassword());
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
			
			logger.log(Level.SEVERE,"Exception occurred:"+e.getMessage());
		}

	}

}
