package com.kpit.beans;

import org.springframework.stereotype.Component;

@Component
public class MyInterfaceImpl1 implements MyInterface {

	@Override
	public void x() {
		// TODO Auto-generated method stub
System.out.println("impl1");
	}

}
