package com.bmc.entities;

public class Rectangle extends Figure {
	private double length;
	private double breadth;
	
	
	
	public Rectangle(double length, double breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}



	public double area(){
		
		return length*breadth;
	}

}
