package com.bmc.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d=new Date();
		System.out.println("Without formatting:"+d);
		
		Locale us=Locale.US;
		
		DateFormat formatUS=DateFormat.getDateInstance(DateFormat.FULL, us);
		System.out.println(formatUS.format(d));
		
		SimpleDateFormat sd=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		System.out.println(sd.format(d));
		

	}

}
