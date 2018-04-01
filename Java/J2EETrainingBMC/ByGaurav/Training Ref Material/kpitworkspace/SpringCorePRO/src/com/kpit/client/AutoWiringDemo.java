package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.MyBean8;

public class AutoWiringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean8 mybean8=(MyBean8)ioc.getBean("mybean8");
        mybean8.getMybean9().x();
		
	}

}
