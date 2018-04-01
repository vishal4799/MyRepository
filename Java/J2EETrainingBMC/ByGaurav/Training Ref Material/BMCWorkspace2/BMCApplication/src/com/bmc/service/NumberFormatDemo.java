package com.bmc.service;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale us=Locale.US;
		double salary=45000;
		
		NumberFormat formatterUS=NumberFormat.getInstance(us);
		System.out.println("Number in US Format:"+formatterUS.format(salary));
		
		Locale ge=Locale.GERMANY;
		NumberFormat formatterGER=NumberFormat.getInstance(ge);
		System.out.println("Number in Germany Format:"+formatterGER.format(salary));

		
		NumberFormat formaaterCurrUS=NumberFormat.getCurrencyInstance(us);
		System.out.println("Currency in US Format:"+formaaterCurrUS.format(salary));

		NumberFormat formaaterCurrGER=NumberFormat.getCurrencyInstance(ge);
		System.out.println("Currency in Ger Format:"+formaaterCurrGER.format(salary));
		
		Locale indiaLocale=new Locale("hin","IN");
		NumberFormat formatterIndia=NumberFormat.getInstance(indiaLocale);
		System.out.println("Number in India Format:"+formatterIndia.format(salary));
		
		NumberFormat formaaterCurrIn=NumberFormat.getCurrencyInstance(indiaLocale);
		System.out.println("Currency in Indian Format:"+formaaterCurrIn.format(salary));

		
		
	}

}
