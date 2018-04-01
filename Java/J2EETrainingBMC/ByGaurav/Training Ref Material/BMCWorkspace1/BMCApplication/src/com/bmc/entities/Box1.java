package com.bmc.entities;

public class Box1 {
	//No-arg constructor
	//Used to create blank object
	public Box1(){}
	//Attribute or properties should be private
	private double height;
	private double width;
	private double breadth;
	
	//to mutate values of attribute -setter() -Mutator
	//to retrieve value of attribute -getter() -accessor
	
	public void setHeight(double height){
		
		//setting value of height for current object
		this.height=height;//this.height--->current object's instance
		//variable height
		//height--->argument
		
	}
	//object on which getHeight() is called , its instance variable
	//height value is returned
	public double getHeight(){
		return height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getBreadth() {
		return breadth;
	}
	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}
	
	

}
