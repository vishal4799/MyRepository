package com.bmc.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String t = "It was the best of times";
	    
        Pattern pattern = Pattern.compile("the");
        Matcher matcher = pattern.matcher(t);
    
        if (matcher.find()) { System.out.println("Found match!"); }

		
	}

}
