/*
   Rename file or directory
   This Java example shows how to rename file or directory using renameTo
   method of Java File class.
*/
 
import java.io.*;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;



public class RenameWindowFileNFolder {
	com.google.cloud.translate.Translate translate = TranslateOptions.newBuilder().setApiKey("<google api key>").build().getService();
	String currentPath = "";
	public static void main(String[] args) {
		String sPath = "C://Song";
		RenameWindowFileNFolder r = new RenameWindowFileNFolder();
		r.traverse(sPath);
//		File oldFolder = new File("C://New folder");
//		//File oldName = new File("C://New folder//New Text Document.txt); 
//		File newFolder = new File("C://a//"+r.translate("folder"));
//		//File newName = new File("C://"+r.translate("folder")+"//"+r.translate("file")+".txt");
//		//boolean isFileRenamed = oldName.renameTo(newName);
//		boolean f2 = oldFolder.renameTo(newFolder);
//		if(f2)
//		   System.out.println("File has been renamed");
//		else
//		   System.out.println("Error renaming the file");
	}
	
	String translate(String name) {
		return translate.translate(name,TranslateOption.sourceLanguage("en"),TranslateOption.targetLanguage("gu")).getTranslatedText();
	}
	void renameTitle(String path, String translatedName, String destPath) {
		try {
			Mp3File mp3file = new Mp3File(path);
			ID3v1 id3v1Tag = new ID3v1Tag();
			if(mp3file.hasId3v1Tag()) {
				id3v1Tag = mp3file.getId3v1Tag();
			} else {
				mp3file.setId3v1Tag(id3v1Tag);
			}
			id3v1Tag.setTitle(translatedName);
			mp3file.save(destPath);
			System.out.println("MP3 file modified.");
		} catch (Exception e) {
			System.out.println("Seems not a MP3 file.");
		}
	}
	
	void traverse(String path) {
		
		File root = new File(path);
	    File[] listOfFiles = root.listFiles();
	    String indentation = "\n";
	    System.out.printf(indentation+"-"+root.getName()+"\n");
	    for (int i = 0; i < listOfFiles.length; i++) {
	    	indentation += "\t ";
	    	String fileName = listOfFiles[i].getName();
	    	String name = "";
	    	boolean isFile = listOfFiles[i].isFile();
	    	if (listOfFiles[i].isDirectory()) {
	    		traverse(path+"//"+fileName);
	    		name = fileName.substring(0, fileName.length());
	    	} else if(isFile) {
	    		if (listOfFiles[i].isHidden()) {
		    		continue;
		    	}
	    		System.out.printf("-"+fileName+"\n");
	    		name = fileName.substring(0, fileName.lastIndexOf('.') >= 0 ? fileName.lastIndexOf('.') : fileName.length());
	    	}
        	File f = new File(path+"//"+fileName); 
	    	String destName, transalatedName = translate(name);
	    	if(name != null && name.equals("") && isFile) {
	    		destName = fileName;
	    	} else {
	    		destName = fileName.replace(name, transalatedName);
	    	}
	    	if(isFile) {
	    		renameTitle(path+"//"+fileName, transalatedName, path+"//"+destName);
	    	}
	    	f.renameTo(new File(path+"//"+destName));
	    }
	}
	
	
}