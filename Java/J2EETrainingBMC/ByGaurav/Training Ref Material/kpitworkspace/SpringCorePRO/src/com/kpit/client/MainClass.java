package com.kpit.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.kpit.beans.MyBean;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		//Traditional approach
		MyBean mybean=new MyBean();
		mybean.x();
		
		//Resolving dependency during runtime based on meta data
		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory ioc1=new XmlBeanFactory(resource);
		MyBean mybean1=(MyBean)ioc1.getBean("mybean");
		mybean1.x();
		
		ApplicationContext ioc2=new ClassPathXmlApplicationContext("applicationContext.xml");
		MyBean mybean2=(MyBean)ioc2.getBean("mybean");
		mybean2.x();
		
		
		Resource resourcefilesystem=new FileSystemResource("d:\\SpringConfig\\applicationContext.xml");
		BeanFactory ioc3=new XmlBeanFactory(resourcefilesystem);
		MyBean mybean3=(MyBean)ioc3.getBean("mybean");
		mybean3.x();
		
		//Spring implements Singleton and Factory design pattern
		
		ApplicationContext ioc4=new ClassPathXmlApplicationContext("applicationContext.xml");
		MyBean mybean4=(MyBean)ioc4.getBean("mybean");
		MyBean mybean5=(MyBean)ioc4.getBean("mybean");

      if(mybean4==mybean5)
    	  System.out.println("References point to same object");
		
		
		*/
		AbstractApplicationContext  ioc5=new ClassPathXmlApplicationContext("applicationContext.xml");
		ioc5.getBean("mybean");
		
		
      ioc5.registerShutdownHook();
		
			
		
	}

}
