package com.bmc.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String message;
		String modifiedmessage;
		BufferedReader inkbd =new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost",6789);
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader innet = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		message = inkbd.readLine();
		out.writeBytes(message + "\n");
		modifiedmessage = innet.readLine();
		System.out.println("Server sent :- " + modifiedmessage);
		//clientSocket.close();

	}

}
