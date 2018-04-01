package com.bmc.entities;

public class Admin extends User {
	
	private int adminId;
	public Admin(int adminId,String username,String password,String firstname,String lastname,String email){
		
		super(username,password,firstname,lastname,email);
	}
	public int getAdminId() {
		return adminId;
	}
	
	public boolean addEvent(){
		//some logic
		return true;
		
	}
	

}
