package com.bmc.entities;

public class Programmer extends Employee{
	
	public Programmer(){}
	private int programmerId;
	private int projId;
	public int getProgrammerId() {
		return programmerId;
	}
	public void setProgrammerId(int programmerId) {
		this.programmerId = programmerId;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	
	

	

}
