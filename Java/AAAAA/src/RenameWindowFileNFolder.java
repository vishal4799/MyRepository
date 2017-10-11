/*
   Rename file or directory
   This Java example shows how to rename file or directory using renameTo
   method of Java File class.
*/
 
import java.io.*;

import com.gtranslate.Language;
import com.gtranslate.Translator;
 
public class RenameWindowFileNFolder {
	public static void main(String[] args) {
	    //create source File object
		Translator translate = Translator.getInstance();
		String text = translate.translate("Hello", Language.ENGLISH, Language.GUJARATI);
		System.out.println(text);
//		File oldName = new File("C://TestFolderRename//TestFileRenameM.txt");
//		   
//		//create destination File object
//		File newName = new File("C://TestFolderRename//વિશાલ.txt");
//		boolean isFileRenamed = oldName.renameTo(newName);
//		if(isFileRenamed)
//		   System.out.println("File has been renamed");
//		else
//		   System.out.println("Error renaming the file");
	}
}