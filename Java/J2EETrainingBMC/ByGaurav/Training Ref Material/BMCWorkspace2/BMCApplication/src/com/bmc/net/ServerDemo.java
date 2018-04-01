package com.bmc.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String args[]) throws Exception
	{
		String clientInput;
		String messageFromServer;
		ServerSocket serverSocket = new ServerSocket(6789);
		while(true)
		{
			Socket	clientSocket = serverSocket.accept();
			InputStreamReader ir = new InputStreamReader(clientSocket.getInputStream());
			DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader br = new BufferedReader(ir);
			clientInput = br.readLine();
			messageFromServer = clientInput.toUpperCase() + "\n";
			dos.writeBytes(messageFromServer);
		}
	}
}
