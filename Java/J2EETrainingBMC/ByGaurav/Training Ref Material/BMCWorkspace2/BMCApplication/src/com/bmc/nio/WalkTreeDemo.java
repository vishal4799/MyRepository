package com.bmc.nio;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkTreeDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//IO
		System.out.println("******Out put based on IO*******");
		File directory=new File("C:\\java");
		String[] dirContent = directory.list();
		for (String fileName : dirContent) {
		    System.out.println(fileName);
		}
		System.out.println("******Out put based on IO*******");
		
		//IO File Filter
		System.out.println("******Out put based on IO FileNameFilter*******");
		File[] selectedFiles = directory.listFiles(new FileFilter() {
		    @Override
		    public boolean accept(File pathname) {
		        if (pathname.getName().endsWith("java"))
		            return true;
		        return false;
		    }
		});
		
		for (File selectedFile : selectedFiles) {
		    System.out.println(selectedFile.getAbsolutePath());
		}
		System.out.println("******Out put based on IO FileNameFilter*******");


		//NIO
		System.out.println("******Out put based on NIO FileVisitor*******");

		Files.walkFileTree(Paths.get("C:\\Java"), new FileVisitorDemo());

		System.out.println("******Out put based on NIO FileVisitor*******");

	}

}
