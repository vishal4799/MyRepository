package com.bmc.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bmc.entities.Square;
import com.bmc.helper.BMCFactory;

public class DynamicMethodInvocationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dummy object
		Square dummy=new Square();
		Class squareClassData=dummy.getClass();//getClass() method of Object class returns Class Ref
		try {
			Method areaMethod=squareClassData.getMethod("area",null);
			
			Square square=(Square)BMCFactory.createInstance("com.bmc.entities.Square");
			square.setLength(30);
			try {
				double area=(Double)areaMethod.invoke(square, null);
				System.out.println("Computed Area:"+area);
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
