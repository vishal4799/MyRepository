package com.bmc.service;

public class MultiThreadedApplication8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread worker1=new Thread(
				()->{
					
					int sum=0;
			
						for(int i=0;i<10;i++){
							sum+=i;
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
					System.out.println("Sum is:"+sum);
					
				}
				
				);
		Thread worker2=new Thread(
				()->System.out.println("Thread runs2")
				);
		
		worker1.start();
		worker2.start();

	}

}
