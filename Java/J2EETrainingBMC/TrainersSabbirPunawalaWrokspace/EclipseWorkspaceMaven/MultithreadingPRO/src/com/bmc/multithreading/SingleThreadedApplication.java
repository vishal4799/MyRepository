package com.bmc.multithreading;

public class SingleThreadedApplication {
	
	public int sum(){
		int sum=0;
		for(int i=1;i<=10;i++){
			sum+=i;
		}
		
		return sum;
	}
	
	public double product(){
		
		double product=1;
		
		for(int i=1;i<=10;i++){
			product*=i;
		}
		return product;
		
	}
	
	public double div(){
		double div=1;
		for(int i=1;i<=10;i++){
			div/=i;
		}
		return div;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//only one task at a time
		
		SingleThreadedApplication application=new SingleThreadedApplication();
		System.out.println("Sum:"+application.sum());
		System.out.println("Product:"+application.product());
		System.out.println("Div:"+application.div());

	}

}
