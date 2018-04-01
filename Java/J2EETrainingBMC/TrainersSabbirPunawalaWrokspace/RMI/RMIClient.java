import javax.naming.*;
import java.util.Scanner;

public class RMIClient {
	public static void main(String[] args){
		try{
			Context naming = new InitialContext();
			
			RemoteIntf remote = (RemoteIntf)naming.lookup("rmi://localhost:1099/RemoteJNDI");
			System.out.println("Enter salary:");
			Scanner scanner = new Scanner(System.in);
			double salary = scanner.nextDouble();
			
			double tax = remote.computeTax(salary);
			System.out.println("Tax:"+tax);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}