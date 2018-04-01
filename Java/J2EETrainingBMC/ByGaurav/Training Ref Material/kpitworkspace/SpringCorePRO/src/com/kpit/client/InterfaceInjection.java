package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.MyInterface;

public class InterfaceInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        MyInterface myinterface=(MyInterface)ioc.getBean("impl1");
        myinterface.x();
	}

}
