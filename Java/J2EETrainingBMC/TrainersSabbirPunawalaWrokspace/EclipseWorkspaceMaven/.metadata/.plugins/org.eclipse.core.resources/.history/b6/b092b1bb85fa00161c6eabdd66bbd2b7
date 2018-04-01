package com.bmc.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String clientInput;
		String messageFromServer;
		Socket clientSocket=null;
		try{
		while(true){
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		 clientSocket = new Socket("localhost",6789);
		DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader brSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		clientInput = br.readLine();
		dos.writeBytes(clientInput + "\n");
		messageFromServer = brSocket.readLine();
		System.out.println("Server sent :- " + messageFromServer);
		}
		}catch(Exception e){}
		finally{
		clientSocket.close();
		}
	}

}
