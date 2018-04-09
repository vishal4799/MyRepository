package com.bmc.multithearding;

public class SingleThreadedApplication {
	
	public int sum(){
		int sum = 0;
		for(int i = 1;i<=10;i++){
			sum+=i;
		}
		return sum;
	}
	
	public double product(){
		double product = 1;
		for(int i = 1;i<=10;i++){
			product*=i;
		}
		return product;
	}
	
	public double div(){
		double div = 1;
		for(int i = 1;i<=10;i++){
			div/=i;
		}
		return div;
	}
	
	public static void main(String[] args) {
		//only one task at a time
		SingleThreadedApplication s = new SingleThreadedApplication();
		System.out.println("sum:"+s.sum());
		System.out.println("product:"+s.product());
		System.out.println("div:"+s.div());
	}

}