package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.MyBean10;

public class AutoWiringInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		MyBean10 mybean10=(MyBean10)ioc.getBean("mybean10");

	}

}
