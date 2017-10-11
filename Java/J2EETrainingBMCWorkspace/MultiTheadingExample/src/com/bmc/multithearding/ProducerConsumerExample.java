package com.bmc.multithearding;

public class ProducerConsumerExample{
	public static void main(String [] args){
		Queue queue = new Queue();
		
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		
		producer.start();
		consumer.start();
	}
}
