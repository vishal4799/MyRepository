import java.rmi.*;

public class Server {
	public static void main(String[] args){
		try{
			RemoteIntf remoteIntf = new RemoteIntfImpl();
			Naming.rebind("RemoteJNDI",remoteIntf);
		} catch(Exception e){
			e.printStackTrace();
		}
		while(true){}
	}
	
}