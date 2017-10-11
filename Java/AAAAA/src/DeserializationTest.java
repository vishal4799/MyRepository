import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream("C:\\NotificationJob.txt");
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            Object object1 = (Object)in.readObject();
             
            in.close();
            file.close();
             
            System.out.println("Object has been deserialized ");
            System.out.println(object1.toString());
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
 
	}

}