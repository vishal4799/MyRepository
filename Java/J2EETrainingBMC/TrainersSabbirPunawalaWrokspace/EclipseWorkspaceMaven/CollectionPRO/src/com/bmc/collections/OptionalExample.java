package com.bmc.collections;

import java.util.Optional;

public class OptionalExample {
	
	 public Integer sum(Optional<Integer> a, Optional<Integer> b){
			
	      //Optional.isPresent - checks the value is present or not
			
	      System.out.println("First parameter is present: " + a.isPresent());
	      System.out.println("Second parameter is present: " + b.isPresent());
			
	      //Optional.orElse - returns the value if present otherwise returns
	      //the default value passed.
	      Integer value1 = a.orElse(new Integer(0));
			
	      //Optional.get - gets the value, value should be present
	      Integer value2 = b.get();
	      return value1 + value2;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OptionalExample od=new OptionalExample();
		
		Integer no1=null;
		Integer no2=20;
		
		Optional<Integer> a=Optional.ofNullable(no1);
		Optional<Integer> b=Optional.of(no2);
		
		od.sum(a, b);
		
	
		

		
	}

}
