package com.bmc.service;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {

	class FrameWindow extends Frame{
		
		public FrameWindow(){
			setLayout(new FlowLayout());
			Button b=new Button("Click Me");
			add(b);
			b.addActionListener(
					(e)->System.out.println("Button clicked")
					
					);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyFrame myframe=new MyFrame();
		Frame frame=myframe.new FrameWindow();
		frame.setSize(400,500);
		frame.setVisible(true);

	}

}
