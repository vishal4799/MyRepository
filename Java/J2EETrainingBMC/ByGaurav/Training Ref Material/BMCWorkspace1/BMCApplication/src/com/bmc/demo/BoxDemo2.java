package com.bmc.demo;

import com.bmc.entities.Box;

public class BoxDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Object is immutable
		//Once object is created , data in object  cannot
		//be modified
		Box box1=new Box(10,20,30);
		System.out.println("Volume for box1 is:"+box1.computeVolume());
		
		System.out.println("Box 1 's height:"+box1.getHeight());
		
		Box box2=new Box(180,120,45);
		System.out.println("Volume for box2 is:"+box2.computeVolume());
		
		//Arrays in Java
		//Array-Group of element of same type
		//Array are stored in heap
		//indexing of Array starts with 0
		//Array has predefined property -length
		//Multidimensional array can be created
		//Jagged Array-index of array point to another array
		//Array are fixed-sized
		
		Box boxes[]=new Box[]{box1,box2};//Array of type box
		System.out.println("Volume for two boxes:"+Box.computeVolumeOfAllboxes(boxes));
		
		
	}

}