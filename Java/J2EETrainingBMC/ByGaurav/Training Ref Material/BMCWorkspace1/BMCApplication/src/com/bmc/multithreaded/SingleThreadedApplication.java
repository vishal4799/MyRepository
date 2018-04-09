package com.bmc.multithreaded;

public class SingleThreadedApplication {

	/**
	 * @param args
	 */
	
	public double sum(){
		double sum=0;
		
		for(int i=1;i<=10;i++){
			sum+=i;
			System.out.println("Sum done so far:"+sum);
		}
		
		return sum;
	}
	
	public double product(){
		double product=1;
		
		for(int i=1;i<=10;i++){
			product*=i;
			System.out.println("Product done so far:"+product);
		}
		
		return product;
	}
	
	public double div(){
		double div=1;
		
		for(int i=1;i<=10;i++){
			div/=i;
			System.out.println("Division done so far:"+div);
		}
		
		return div;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingleThreadedApplication application=new SingleThreadedApplication();
		System.out.println("Total sum:"+application.sum());
		System.out.println("Total product:"+application.product());
		System.out.println("Total division:"+application.div());

	}

}