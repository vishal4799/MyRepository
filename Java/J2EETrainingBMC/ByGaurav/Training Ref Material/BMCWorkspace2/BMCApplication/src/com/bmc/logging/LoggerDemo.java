package com.bmc.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerDemo {
	
	private Logger logger=null;
	private FileHandler handler=null;
	private SimpleFormatter formatter=null;
	
	public LoggerDemo() throws SecurityException, IOException{
	
	this.logger=Logger.getLogger("LoggerDemo");
	this.handler=new FileHandler("D:\\logs\\log.txt",true);
	this.formatter=new SimpleFormatter();
	handler.setFormatter(formatter);
	logger.addHandler(handler);

	}
	public double compute(int a,int b){
		logger.log(Level.INFO,"Method compute called at:"+new Date());
		int c=a+b;
		logger.log(Level.INFO,"Value of c:"+c);
		try{
		int t=c/a;
			if(t>0.5){
				logger.log(Level.WARNING,"Value of t beyond range :"+t);
			}
			
		}catch(ArithmeticException e){
			logger.log(Level.SEVERE,"ArithmeticException thrown a->0");
		}
		
		return c;
	}

	public static void main(String[] args) throws SecurityException, IOException {
		// TODO Auto-generated method stub
		
		LoggerDemo ld=new LoggerDemo();
		ld.compute(0, 20);
		

	}

}
