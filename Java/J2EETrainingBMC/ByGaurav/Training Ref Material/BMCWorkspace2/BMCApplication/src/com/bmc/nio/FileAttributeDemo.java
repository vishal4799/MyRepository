package com.bmc.nio;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;

public class FileAttributeDemo {
    public static void main(String[] args) throws IOException {
        //Java IO
        File file=new File("D:\\IO\\File1.txt");
        System.out.println("Directory:"+file.isDirectory());
        System.out.println("File:"+file.isFile());
        System.out.println("Exists:"+file.exists());
        System.out.println("Absolute:"+file.isAbsolute());
        System.out.println("Size:"+file.length());
        System.out.println("Can Write:"+file.canWrite());
        
        //NIO
         Path path=Paths.get("D:\\IO\\File1.txt");
         DosFileAttributes attr=Files.readAttributes(path, 
        		 DosFileAttributes.class, 
        		 LinkOption.NOFOLLOW_LINKS);
         System.out.println("Read Only:"+attr.isReadOnly());
         System.out.println("System:"+attr.isSystem());
         System.out.println("Symbolic link:"+attr.isSymbolicLink());
         
         Path path1=Paths.get("D:\\IO\\File1.txt");
         System.out.println("Contains Name:"+path.getNameCount());
         System.out.println("Ends with File1.txt:"+
         path1.endsWith("File1.txt"));
         System.out.println("File Name:"+path1.getFileName());
         Path path2=Paths.get("D:\\IO\\File1.txt");
         System.out.println("Same path:"+path1.equals(path2));
         
         Path path3=Paths.get("D:");
         FileSystem filesystem=path3.getFileSystem();
         Iterable<FileStore> stores=filesystem.getFileStores();
         for(FileStore store:stores){
        	 System.out.println("Free Space:"+store.getUnallocatedSpace());
        	 System.out.println("Total Space:"+store.getTotalSpace());
        	 System.out.println("Usable Space:"+store.getUsableSpace());

             System.out.println(store.name());
         }
         
    }
    
}
