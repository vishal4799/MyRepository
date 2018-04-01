package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.beans.MyBean4;
import com.kpit.beans.MyBean6;

public class ManualWiringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

		MyBean4 mybean4=(MyBean4)ioc.getBean("mybean4");
		
		MyBean6 mybean6=(MyBean6)ioc.getBean("mybean6");

	}

}
