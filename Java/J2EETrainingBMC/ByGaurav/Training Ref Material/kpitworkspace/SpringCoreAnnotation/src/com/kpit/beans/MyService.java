package com.kpit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class MyService {

	@Autowired(required=true)@Qualifier("myInterfaceImpl2")
	private MyInterface myinterface;
	

	public void someMethod(){
		myinterface.x();
	}
	
	public static void main(String args[]){
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//new MyService().someMethod();
		
		MyService service=(MyService)ioc.getBean("myService");
		service.someMethod();
		
	}
	
	
}
