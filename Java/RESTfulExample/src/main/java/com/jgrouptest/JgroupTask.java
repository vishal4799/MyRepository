package com.jgrouptest;

import java.io.File;
import java.net.InetAddress;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class JgroupTask extends ReceiverAdapter {
    JChannel channel;
    String userName;

    public void start() throws Exception {
    	userName = InetAddress.getLocalHost().getHostName();
    	System.out.println("JgroupTask : start....");
    	ClassLoader classLoader = getClass().getClassLoader();
		channel=new JChannel(classLoader.getResource("leaderselect.conf").getFile());
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        eventLoop();
        channel.close();
    }
    public void viewAccepted(View view) {
        System.out.println("** view: " + view);
    }

    public void receive(Message msg) {
        System.out.println(msg.getSrc() + ": " + msg.getObject());
    }

    private void eventLoop() {
        long seconds = 1;
        boolean b = userName.contains("25777");
        while(true) {
            try {
            	Message msg=new Message(null, null, userName+ (b ? " : I am still runing..." : " : waiting for my turn..."));
            	channel.send(msg);
            	if (seconds == 60){
                	System.out.println(userName+" : 60 seconds...");
                	msg=new Message(null, null, userName+" : I m done.");
                	channel.send(msg);
                	break;
                } else if(seconds % 10 == 0) {
                	msg=new Message(null, null, userName+(b ? " : Still runing, but not my turn..." : " : I am also runing..."));
                	channel.send(msg);
                	Thread.sleep(1000);
                	seconds++;
                    continue;
                } 
                Thread.sleep(1000);
                seconds++;
            }
            catch(Exception e) {
            }
        }
    }
    
   
}
