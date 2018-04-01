package com.bmc.demo;

public class EnumTest {
	
	final int I;
	
	private int state;
	enum ComputerState{
		ON(1),OFF(0),SUSPEND(2);
		private int value;
		private ComputerState(int value){
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}
	
	public EnumTest(){
		I=20;
		int k = I+1;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	private ComputerState stateEnum;
	public ComputerState getStateEnum() {
		return stateEnum;
	}

	public void setStateEnum(ComputerState stateEnum) {
		this.stateEnum = stateEnum;
	}

	public static void main(String[] args) {
		EnumTest et = new EnumTest();
		et.setState(1);
		et.setState(40);//there is no state 40
		//et.setState2(ComputerState.ON);
	}

	

}
