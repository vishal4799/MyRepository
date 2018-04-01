package com.bmc.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackReferencingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String t="121212";
		Pattern p1 = Pattern.compile("(\\d\\d)(\\d\\d)\\2");
        Matcher m1 = p1.matcher(t);
        if (m1.find()) { System.out.println("Found: " + m1.group());
        }

	}

}
