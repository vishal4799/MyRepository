package com.bmc.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DeckDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Combination of LIFO and FIFO
		//LIFO-Stack, FIFO-Queue
		//can work as both stack as well as queue
		//pronounced as deck
		Deque deckStack=new ArrayDeque();//stack implementation 
		deckStack.push(10);
		deckStack.push(30);
		deckStack.push(45);
		System.out.println(deckStack);
		
		System.out.println("First Element:"+deckStack.peekFirst());
		System.out.println(deckStack.pop());
		System.out.println(deckStack.pop());
		System.out.println(deckStack.pop());
		
		System.out.println(deckStack);

		Deque deckQueue=new ArrayDeque();//queue implementation FIFO
		deckQueue.add(10);
		deckQueue.add(20);
		deckQueue.add(30);
		
		Iterator iterator =deckQueue.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		
		
		

	}

}
