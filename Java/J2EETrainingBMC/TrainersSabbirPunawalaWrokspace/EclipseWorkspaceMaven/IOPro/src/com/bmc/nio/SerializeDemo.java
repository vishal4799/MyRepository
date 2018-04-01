package com.bmc.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SerializeDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Logger logger=Logger.getLogger("SerializeDemo");
	    OutputStream os=null;
		logger.log(Level.INFO, "Serialization started:");
		LogRecord record3=null;
		LogRecord record1=null;
		LogRecord record2=null;
		FileHandler handler=null;
		try{
			
	    handler=new FileHandler("D:\\IO\\log.txt",true);
		record1=new LogRecord(Level.INFO, "Serialization started:");
			
		SimpleFormatter formatter=new SimpleFormatter();
		handler.setFormatter(formatter);

		File file=new File("D:\\IO\\visitor.ser");
		os=new FileOutputStream(file);
		
		Visitor visitor=new Visitor("sabbirp","sabbir123",1001,"Pune");
		logger.log(Level.INFO,"Visitor object created successfully");
		record2=new LogRecord(Level.INFO, "Visitor object created successfully");

		
		ObjectOutputStream oos=new ObjectOutputStream(os);
		oos.writeObject(visitor);
		
		}catch(IOException e){
			
			logger.log(Level.SEVERE,"Exception occurred:"+e.getMessage());
		    record3=new LogRecord(Level.SEVERE, "Exception occurred:"+e.getMessage());

		}
		
		finally{
			
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.log(Level.SEVERE,"Exception occurred :"+e.getMessage());
			}
			
			handler.publish(record1);
			handler.publish(record2);
			handler.publish(record3);
			handler.close();
		}
		
		

	}

}
