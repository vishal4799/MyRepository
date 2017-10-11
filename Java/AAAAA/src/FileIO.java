import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileIO {
	//String path = "C:\\Users\\vmakwana\\Documents\\MyDocuments\\TestJavaProjects\\AAAAA\\resources\\file1.txt";
	String path = "C:\\sample.txt";
	StringBuilder file1 = new StringBuilder();
	StringBuilder file2 = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		FileIO f = new FileIO();
		long startTime = System.nanoTime();
		f.fileReader();
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime)+":fileReader");
		startTime = System.nanoTime();
		f.fileInputStream();
		endTime = System.nanoTime();
		System.out.println((endTime - startTime)+":fileInputStream:");
		startTime = System.nanoTime();
		f.fileWriter();
		endTime = System.nanoTime();
		System.out.println((endTime - startTime)+"::fileWriter");
		startTime = System.nanoTime();
		f.bufferedWriter();
		endTime = System.nanoTime();
		System.out.println((endTime - startTime)+":bufferedWriter:");
		
	}
	//slower
	void fileReader() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		try {
		    String line = br.readLine();
		    while (line != null) {
		        file1.append(line);
		        file1.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    //System.out.println(sb.toString());
		} finally {
		    br.close();
		}
	}
	//faster
	void fileInputStream() throws IOException{
		FileInputStream fin = new FileInputStream(path);
        BufferedInputStream bin = new BufferedInputStream(fin);
        int character;
        while((character=bin.read())!=-1) {
            file2.append((char) character);
        }
        //System.out.println(sb.toString());
        bin.close();
        fin.close();
	}
	//slower
	void fileWriter() throws IOException{
		FileWriter wr = new FileWriter(path);
		wr.write(file1+":========concat=========:"+file2);
	    wr.close();
	}
	//faster
	void bufferedWriter() throws IOException{
		BufferedWriter wr = new BufferedWriter(new FileWriter(path));
		wr.write(file1+":========concat=========:"+file2);
	    wr.close();
	}
	
    

}
