package com.bmc.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredefinedCharacterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aabcd";
		Pattern p = Pattern.compile("\\d{1}");
		Matcher m=p.matcher(s);
		if (m.find()) { System.out.println("Found:nnn " + m.group());
        }
		
		String t = "Jo told me 20 ways to San Jose in 15 minutes.";
		 
        Pattern p1 = Pattern.compile("\\d\\d");
        Matcher m1 = p1.matcher(t);
        if (m1.find()) { System.out.println("Found: " + m1.group());
        }
 
        Pattern p2 = Pattern.compile("\\sin\\s");
        Matcher m2 = p2.matcher(t);
        if (m2.find()) { System.out.println("Found: " + m2.group());
        }
 
        Pattern p3 = Pattern.compile("\\Sin\\S");
        Matcher m3 = p3.matcher(t);
        if (m3.find()) { System.out.println("Found: " + m3.group());
        }
	}

}
