package com.kpit.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("manager")
@Lazy
public class ConnectionManager {
	
	public ConnectionManager(){
		System.out.println("--Connection Manager constructor--");
	}
	
	public void openConnection(){
		
		System.out.println("--open connection--");
	}

}
