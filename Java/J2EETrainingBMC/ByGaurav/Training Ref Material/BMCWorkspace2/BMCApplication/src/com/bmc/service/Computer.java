package com.bmc.service;

public class Computer {
	
	final static int ON=1;
	final static int OFF=0;
	final static int SUSPEND=3;
	
	enum State{
		
		ON(1),OFF(0),SUSPEND(3);
		
		private int value;
		
		private State(int value){
			this.value=value;
		}
		public int getValue(){
			return value;
		}
		
	}
	
	public void setState(State state){
		//do some operation
		
		switch(state){
		case ON:
			//do some operation
			System.out.println("ON operation performed");
			break;
		case OFF:
			//do some operation
			System.out.println("OFF operation performed");

			break;
		case SUSPEND:
		    //do some operation
			System.out.println("Suspend operation performed");
		    break;
		
		
		}
		
	}
	
	public static void main(String args[]){
		Computer computer=new Computer();
		computer.setState(State.ON);
		//computer.setState(42);//No Allowed
	}

}
