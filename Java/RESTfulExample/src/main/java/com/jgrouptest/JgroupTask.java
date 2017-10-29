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
    boolean b;

    public void start() throws Exception {
    	userName = InetAddress.getLocalHost().getHostName();
    	b = userName.contains("25777");
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
    	if(!msg.getSrc().toString().contains(userName)){
    		System.out.println(msg.getObject());
    		if(!b){
    			Message msgSendBack=new Message(null, null, "RECEIVED::"+msg.getObject());
                try {
					channel.send(msgSendBack);
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    }

    private void eventLoop() {
        long seconds = 0;
        while(true) {
            try {
            	if(b){
	            	Message msg=new Message(null, null, "sent by "+userName+" @ "+seconds+" seconds");
	                channel.send(msg);
	            }
            	Thread.sleep(10000);
                seconds+=10;
            }
            catch(Exception e) {
            }
        }
    }
}
//if (seconds == 60){
//System.out.println(userName+" : 60 seconds...");
//msg=new Message(null, null, userName+" : I m done.");
//channel.send(msg);
//break;
//} else 
//if(seconds % 10 == 0) {
//}
