package com.bmc.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque deck=new ArrayDeque();
		deck.push(10);
		deck.push(20);
		deck.push(30);
		System.out.println(deck.pop());
		
		
		Deque deck1=new ArrayDeque();
		deck1.add(10);
		deck1.add(20);
		deck1.add(30);
		System.out.println(deck1.getFirst());

	}

}