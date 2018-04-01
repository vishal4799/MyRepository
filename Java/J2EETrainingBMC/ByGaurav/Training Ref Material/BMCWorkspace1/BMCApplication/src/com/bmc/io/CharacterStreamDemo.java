package com.bmc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharacterStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fileread=new File("D:\\io\\File3.txt");
		File filewrite=new File("D:\\io\\File4.txt");
		//wrapping
		//reads character by character
		Reader reader=new FileReader(fileread);
		//reads line by line
		BufferedReader buffer=new BufferedReader(reader);
		String data=null;
		
		//writes single char
		Writer writer=new FileWriter(filewrite);
		
		while((data=buffer.readLine())!=null){
			
			writer.write(data);
		}
		//flush data to sink
		writer.flush();
		

	}

}
