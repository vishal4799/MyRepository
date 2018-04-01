package com.bmc.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
	        Preferences prefs = Preferences.userRoot().node("com/bmc/preferences");

	        String color = prefs.get("Color", "Blue");

	        new PreferencesDemo().putPrefs(prefs);

	        System.out.println("Color:" + color);

	        OutputStream stream = new FileOutputStream("D:\\IO\\prefs.xml");
	        prefs.exportNode(stream);
		}catch(Exception e){
			e.printStackTrace();
		}
		}

	    public void putPrefs(Preferences prefs) {
	        prefs.put("Color", "Red");
	    }

	}


