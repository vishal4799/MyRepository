package com.bmc.entities;
//extends is keyword for specifying super class
//User-SuperClass
//Visitor-SubClass
public class Visitor extends User {
	
	//apart from inheriting from Superclass, Subclass will have its own attributes
	//and functionality independent of Superclass
	private int visitorId;
	
	public Visitor(int vistiorId,String username,String password,String firstname,String lastname,String email){
		
		//from constuctor of subclass you can call constructor of super class
		//matching constructor based on argument will be called
		super(username,password,firstname,lastname,email);//Super should be first statement
		
	}

	public int getVisitorId() {
		return visitorId;
	}
	//Apart from inheriting from superclass, subclass will have its own individual functionality
	
	public boolean registerForEvent(int eventId){
		//some logic
		return true;
		
	}

}
