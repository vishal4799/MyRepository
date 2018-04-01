package com.kpit.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean(name="mybean")
	public MyBean createMyBean(){
		
		MyBean mybean=new MyBean();
		return mybean;
	}

}
