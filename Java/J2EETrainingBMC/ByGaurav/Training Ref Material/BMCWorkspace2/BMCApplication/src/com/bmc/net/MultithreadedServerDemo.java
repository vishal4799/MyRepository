package com.bmc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MultithreadedServerDemo {
	    ServerSocket serverSocket;
	    boolean whetherServerOn = true;
	    private String time;
	    
	    public MultithreadedServerDemo() 
	    { 
	        try 
	        { 
	            serverSocket = new ServerSocket(6789); 
	        } 
	        catch(IOException e) 
	        { 
	            System.out.println("Error creating server socket on port 6789. Terminating."); 
	            System.exit(1); 
	        } 
	        Calendar calendar = Calendar.getInstance();
	        SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a zzz");
	        time=formatter.format(calendar.getTime());
	        System.out.println("Current Time: " + formatter.format(calendar.getTime()));

	        while(whetherServerOn) 
	        {                        
	            try 
	            { 
	                Socket clientSocket = serverSocket.accept();

	                WorkerServiceThread worker = new WorkerServiceThread(clientSocket);
	                worker.start(); 
	            } 
	            catch(IOException e) 
	            { 
	                System.out.println("Exception encountered on accept :"); 
	                e.printStackTrace(); 
	            } 
	        }
	        try 
	        { 
	            serverSocket.close(); 
	            System.out.println("Server Stopped"); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Problem stopping server socket"); 
	            System.exit(1); 
	        } 
	    } 
	    class WorkerServiceThread extends Thread {
	    	
	   	    private Socket clientSocket;
	        boolean serviceThreadRunning = true; 

	        public WorkerServiceThread() 
	        { 
	            super(); 
	        } 

	        public WorkerServiceThread(Socket clientSocket) 
	        { 
	            this.clientSocket = clientSocket; 

	        } 

	        public void run() 
	        {            
	            BufferedReader in = null; 
	            PrintWriter out = null; 
	            System.out.println("Accepted Client Address - " + clientSocket.getInetAddress().getHostName()); 
	            try 
	            {                                
	                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
	                out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream())); 
	                while(serviceThreadRunning) 
	                {                    
	                    String clientMessage = in.readLine(); 
	                    System.out.println("Client message :" + clientMessage);

	                    if(!whetherServerOn) 
	                    { 
	                        System.out.print("Server has already stopped"); 
	                        out.println("Server has already stopped"); 
	                        out.flush(); 
	                        serviceThreadRunning = false;   
	                    } 
	                    if(clientMessage.equalsIgnoreCase("quit")) { 
	                        serviceThreadRunning = false;   
	                        System.out.print("Stopping client thread for client : "); 
	                    } else if(clientMessage.equalsIgnoreCase("end")) { 
	                        serviceThreadRunning = false;   
	                        System.out.print("Stopping client thread for client : "); 
	                        whetherServerOn = false;
	                    } else {
	                            out.println("Client sent message :"+clientMessage+" at "+time); 
	                            out.flush(); 
	                    }
	                } 
	            } 
	            catch(Exception e) 
	            { 
	                e.printStackTrace(); 
	            } 
	            finally 
	            { 
	                try 
	                {                    
	                    in.close(); 
	                    out.close(); 
	                    clientSocket.close(); 
	                    System.out.println("...Stopped"); 
	                } 
	                catch(IOException e) 
	                { 
	                    e.printStackTrace(); 
	                } 
	            } 
	        } 

	    }
	    
	    public static void main(String args[]){
	    	MultithreadedServerDemo server=new MultithreadedServerDemo();
	    	
	    }
}
