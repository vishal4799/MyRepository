package com.bmc.demo;

public class Computer {
	
	double phonenumber=91_020_67;
	
	enum ComputerState{
		ON("1"),OFF("0"),SUSPEND("2");
		private String value;
		private ComputerState(String value){
			this.value=value;
		}
		public String getValue(){
			return value;
		}
	}
	
	private ComputerState state;

	public ComputerState getState() {
		return state;
	}

	public void setState(ComputerState state) {
    switch(state){
    
    case ON:
    	//do ON
    	break;
    case OFF:
        //do OFF
        break;
    case SUSPEND:
         //SUSPEND
         break;
    
    
    }

		
	}
	
	public static void main(String args[]){
		
		Computer computer=new Computer();
		//computer.setState(1);
		//computer.setState(40);//there is no state 40
		computer.setState(ComputerState.ON);
		
		System.out.println(computer.phonenumber+200_203);
		
		
		
	}
	

}
