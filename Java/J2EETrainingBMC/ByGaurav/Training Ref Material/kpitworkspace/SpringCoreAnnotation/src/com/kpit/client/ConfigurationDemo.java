package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.MyBean;

public class ConfigurationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		MyBean mybean=(MyBean)ioc.getBean("mybean");
		mybean.x();
	}

}
