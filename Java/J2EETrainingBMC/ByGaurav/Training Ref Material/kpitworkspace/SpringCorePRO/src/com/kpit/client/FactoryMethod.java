package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.MyBean1;

public class FactoryMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		MyBean1 mybean1=(MyBean1)ioc.getBean("mybean1");
		mybean1.x();
	}

}
