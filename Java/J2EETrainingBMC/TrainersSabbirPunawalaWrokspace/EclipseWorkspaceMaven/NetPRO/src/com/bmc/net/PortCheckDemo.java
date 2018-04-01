package com.bmc.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortCheckDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Socket socket;
	    String host = "localhost";

	    for (int i = 0; i < 1024; i++) {
	      try {
	        socket = new Socket(host, i);
	        System.out.println("There is a server on port " + i + " of " + host);
	      }
	      catch (UnknownHostException e) {
	        System.out.println(e);
	        break;
	      }
	      catch (IOException e) {
	      }
	    } 
	  
	  }  
	}


