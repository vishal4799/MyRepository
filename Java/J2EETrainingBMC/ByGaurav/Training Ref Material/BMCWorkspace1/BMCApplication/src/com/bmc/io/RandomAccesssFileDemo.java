package com.bmc.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccesssFileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String data="Java is object oriented";
		
		RandomAccessFile randomAccess=new RandomAccessFile("d:\\io\\Random.txt","rw");
		randomAccess.seek(10);
		randomAccess.writeBytes(data);
		//randomAccess.close();
		
		long currentPos=randomAccess.getFilePointer();
		
		String data1="But they say Java is slow";
		randomAccess.seek(currentPos+2);
		randomAccess.writeBytes(data1);
		randomAccess.close();

	}

}
