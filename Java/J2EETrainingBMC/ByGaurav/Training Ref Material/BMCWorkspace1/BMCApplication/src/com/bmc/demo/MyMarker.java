package com.bmc.demo;

public class MyMarker implements Marker{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//before performing operation
		//check if it implements Marker interface or not
		
		MyMarker marker=new MyMarker();
		
		System.out.println(Marker.I);
		if(marker instanceof Marker){
			//do operation
		}
		//else dont do operation
		//throw exception
		
		
	}

	public void x1() {
		// TODO Auto-generated method stub
		
	}

}
