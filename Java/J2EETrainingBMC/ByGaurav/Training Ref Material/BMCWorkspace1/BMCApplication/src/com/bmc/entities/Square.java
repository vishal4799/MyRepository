package com.bmc.entities;

public class Square extends Figure{
	private double length;
	
	public Square(){}
	
	
	
	
	
	public double getLength() {
		return length;
	}





	public void setLength(double length) {
		this.length = length;
	}

	public Square(double length) {
		super();
		this.length = length;
	}
//Makes more sense of providing implementation

	@Override
	public double area(){
		
		return length*length;
	}
	@Override
	public String toString(){
		StringBuilder builder=new StringBuilder();
		builder.append("The Length is:");
		builder.append(length);
		return builder.toString();
		
	}
	
	

}
