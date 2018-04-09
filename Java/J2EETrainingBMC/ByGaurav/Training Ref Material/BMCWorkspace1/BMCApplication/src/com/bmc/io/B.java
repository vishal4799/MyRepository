package com.bmc.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class B extends A implements Externalizable{

	private int b;
	
	public B(){}
	
	public B(int a,int b){
		super(a);
		this.b=b;
	}

	
	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + "]";
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeInt(this.b);
		out.writeInt(a);
		// TODO Auto-generated method stub
		
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		this.b=in.readInt();
		this.a=in.readInt();
		
	}
	
	
}