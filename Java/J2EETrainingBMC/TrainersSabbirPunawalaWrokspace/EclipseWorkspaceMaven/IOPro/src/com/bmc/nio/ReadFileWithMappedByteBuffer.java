package com.bmc.nio;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class ReadFileWithMappedByteBuffer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile aFile = new RandomAccessFile("D:\\IO\\test.txt", "r");
		FileChannel inChannel = aFile.getChannel();
		MappedByteBuffer buffer = 
				inChannel.map(FileChannel.MapMode.READ_ONLY, 0,
						inChannel.size());
		
		buffer.load();  
		for (int i = 0; i < buffer.limit(); i++)
		{
			System.out.print((char) buffer.get());
		}
		buffer.clear(); 
		inChannel.close();
		aFile.close();

	}

}
