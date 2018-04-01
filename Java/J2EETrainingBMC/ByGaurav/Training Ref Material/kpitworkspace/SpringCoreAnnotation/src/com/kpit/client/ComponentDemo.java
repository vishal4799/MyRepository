package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.ConnectionManager;

public class ComponentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		ConnectionManager manager=(ConnectionManager)ioc.getBean("manager");
		manager.openConnection();

	}

}
