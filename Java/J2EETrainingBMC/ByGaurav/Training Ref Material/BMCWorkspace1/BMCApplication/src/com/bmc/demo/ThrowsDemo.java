package com.bmc.demo;

public class ThrowsDemo {

	
	public void x()throws Exception{
		
		//xxxx
	}
	
	public void y()throws Exception{
		x();
	}
	
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ThrowsDemo td=new ThrowsDemo();
		//Exception is propogating from x()-->y()-->main()
		//The last caller in chain must handle exception
		td.y();

	}

}
