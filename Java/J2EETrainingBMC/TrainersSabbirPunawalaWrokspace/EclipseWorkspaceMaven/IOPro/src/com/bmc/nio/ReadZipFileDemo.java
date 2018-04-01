package com.bmc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;



public class ReadZipFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        File file = new File("C:\\IO\\IO.zip");
        InputStream input;
        try {

          input = new FileInputStream(file);
          ZipInputStream zip = new ZipInputStream(input);
          ZipEntry entry;
          while(( entry = zip.getNextEntry())!=null){
        	  
        	  System.out.println("File Name:"+entry.getName());
        			  System.out.println("File Size:"+entry.getSize());
          }

           zip.close();
           input.close();
           

           
           
           
           

           
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }


	}


