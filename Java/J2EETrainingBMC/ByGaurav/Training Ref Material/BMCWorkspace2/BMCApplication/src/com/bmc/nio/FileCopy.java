package com.bmc.nio;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class FileCopy {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*//IO
        File file1=new File("D:\\IO\\File1.txt");
        InputStream is=new FileInputStream(file1);
        File file2=new File("D:\\IO\\File9.txt");
        OutputStream os=new FileOutputStream(file2);
        
        int k=0;
        while((k=is.read())!=-1){
            os.write(k);
            
        }
        os.close();
        
        //Character-based Stream
        
        Reader reader=new FileReader(file1);
        BufferedReader buffer=new BufferedReader(reader);
        Writer writer=new FileWriter(file2);
        String str=null;
        while((str=buffer.readLine())!=null){
            writer.write(str);
        }
        writer.close();
        */
        
        //NIO
        
        Path path1=Paths.get("D:\\IO\\File3.txt");
        //Path path2=Paths.get("D:\\IO\\File11.txt");
        
        Path path3=Paths.get("D:\\MovedFile1\\File3.txt");
        //Files.copy(path1,path2,StandardCopyOption.REPLACE_EXISTING);
        
        Files.move(path1, path3, StandardCopyOption.ATOMIC_MOVE);
    }
    
}
