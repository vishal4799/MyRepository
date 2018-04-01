package com.bmc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class FileAttributeDemo {

	public static void main(String[] args) throws IOException {
		//IO
		File file = new File("C:\\AdvancedJavaTrainingBMC\\File1.txt");
		System.out.println("Directory:"+file.isDirectory());
		System.out.println("File:"+file.isFile());
		System.out.println("Exists:"+file.exists());
		System.out.println("Absolute:"+file.isAbsolute());
		System.out.println("Size:"+file.length());
		System.out.println("Can Write:"+file.canWrite());
		
		//NIO
		Path path = Paths.get("C:\\AdvancedJavaTrainingBMC\\File1.txt");
		DosFileAttributes attr = Files.readAttributes(path, DosFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
		System.out.println("Read only:"+attr.isReadOnly());
		System.out.println("System:"+attr.isSystem());
		System.out.println("Symbolic:"+attr.isSymbolicLink());
		
		Path path1= Paths.get("C:\\AdvancedJavaTrainingBMC\\File1.txt");
		System.out.println("Contains Name:"+path1.getNameCount());
		System.out.println("Ends with File1:"+path1.endsWith("File1.txt"));
		System.out.println("File Name:"+path1.getFileName());
		System.out.println("same path:"+path1.equals(path));
		
		Path path2= Paths.get("C:\\AdvancedJavaTrainingBMC\\File1.txt");
		FileSystem fs = path2.getFileSystem();
		Iterable<FileStore> stores = fs.getFileStores();
		for (FileStore s : stores) {
			System.out.println("free space:"+s.getUnallocatedSpace());
			System.out.println("total space:"+s.getTotalSpace());
			System.out.println("Usable space:"+s.getUsableSpace());
			System.out.println("name:"+s.name());
		}
		
		
	}

}
