package com.kpit.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kpit.helper.DataSource1;

public class DependencyInjectionSetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource1 datasource=(DataSource1)ioc.getBean("datasource1");
		System.out.println(datasource);

	}

}
