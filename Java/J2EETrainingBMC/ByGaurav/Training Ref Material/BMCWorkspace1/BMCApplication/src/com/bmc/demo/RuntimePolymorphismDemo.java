package com.bmc.demo;

import com.bmc.entities.Figure;
import com.bmc.entities.Rectangle;
import com.bmc.entities.Square;

public class RuntimePolymorphismDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Square square=new Square(10);
		//binding is association between object and method
		square.area();//static binding
		
		//Reference variable of super class
		Figure figRef=null;
		figRef=new Square(10);
		//association between object and method happens during runtime
		figRef.area();//area of square will be called //dynamic binding
		
		figRef=new Rectangle(10,20);
		figRef.area();//area of rectangle will be called
		

	}

}
