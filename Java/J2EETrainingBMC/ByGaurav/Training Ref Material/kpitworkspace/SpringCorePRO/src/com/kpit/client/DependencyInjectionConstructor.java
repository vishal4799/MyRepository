package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.helper.DataSource;

public class DependencyInjectionConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource datasource=(DataSource)ioc.getBean("datasource");
		System.out.println(datasource);

	}

}
