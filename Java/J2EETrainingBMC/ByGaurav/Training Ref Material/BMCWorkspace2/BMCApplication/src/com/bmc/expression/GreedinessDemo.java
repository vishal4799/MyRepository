package com.bmc.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedinessDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="abcde9";
		
		Pattern px=Pattern.compile("[a-z]");
		Matcher mx=px.matcher(str);
		if(mx.find()){
		System.out.println("found mx");
		}
		
		String t="Longlonglong ago, in a galaxy far far away.";
        Pattern p1 = Pattern.compile("ago.*far");
        Matcher m1 = p1.matcher(t);
        if (m1.find()) { System.out.println("Found: " + m1.group());
        }
 
        Pattern p2 = Pattern.compile("ago.*?far");
        Matcher m2 = p2.matcher(t);
        if (m2.find()) { System.out.println("Found: " + m2.group());
        }
 
        
	}

}
