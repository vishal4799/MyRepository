package com.bmc.demo;

import com.bmc.entities.User;
import com.bmc.entities.Visitor;

public class InheritanceDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Upcasting implictly , reference variable of subclass automatically casted
		//to reference variable of superclass
		User user=new Visitor(1,"sabbirp","sabbir123","sabbir","poonawala","sabbirpoonawala@hotmail.com");
		System.out.println(user.login("sabbir", "sabbir"));
		//user.registerForEvent(101);//not possible 
		Visitor visitor=new Visitor(1,"sabbirp","sabbir123","sabbir","poonawala","sabbirpoonawala@hotmail.com");
		visitor.login("sabbir", "sabbir");//if method is not present in sub class
		//calls method of superclass
		visitor.registerForEvent(101);//since reference variable is of type visitor
		
		
		
		
	}

}