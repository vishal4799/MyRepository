package com.bmc.service;

public class MainClass {
	
	class MyInner extends MyAdapter{
		@Override
		public void x(){
			System.out.println("--Some Implementation--");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Annoymous Class-class without name
		MyAdapter m=new MyAdapter(){
			@Override
			public void x(){
				System.out.println("--Some implementation--");
			}
			
			
		};

		m.x();
		
		MainClass main=new MainClass();
		MainClass.MyInner inner=main.new MyInner();
		inner.x();
		
	}

}
