package com.bmc.assertions;

public class AssertionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfAdults=2;
		int noOfChild=3;
		int totalNoofTickets=noOfAdults+noOfChild;
		
		int tickets[]=new int[totalNoofTickets];
		int pass=1;
		for(int i=0;i<tickets.length-1;i++){
			tickets[i]=pass;
			pass++;
		}
		int n=0;
		while(n<tickets.length){
			assert tickets[n]!=0:"Pass not issued";
			System.out.println("Pass issued:"+tickets[n]);
			n++;
		}

	}

}
