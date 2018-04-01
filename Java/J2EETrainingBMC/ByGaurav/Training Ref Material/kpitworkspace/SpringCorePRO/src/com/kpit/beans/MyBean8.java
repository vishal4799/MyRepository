package com.kpit.beans;

public class MyBean8 {
	
	
	public MyBean8(){}
	private MyBean9 mybean9;
	
	public MyBean8(MyBean9 mybean9){
		this.mybean9=mybean9;
	}

	public MyBean9 getMybean9() {
		return mybean9;
	}

	public void setMybean9(MyBean9 mybean9) {
		this.mybean9 = mybean9;
	}

	
	
}
