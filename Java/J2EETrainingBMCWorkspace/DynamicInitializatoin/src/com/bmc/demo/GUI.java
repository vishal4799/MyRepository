package com.bmc.demo;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class GUI extends JFrame{
	public  GUI(String title){
		super(title);
		JButton jb = new JButton("Click Me!");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(jb);
	}
	public static void main(String[] args){
		JFrame frame = new GUI("Executable Jar");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
