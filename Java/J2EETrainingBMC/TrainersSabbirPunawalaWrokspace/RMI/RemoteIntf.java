import java.rmi.*;

public interface RemoteIntf extends Remote{
	public double computeTax(double salary) throws RemoteException;
}