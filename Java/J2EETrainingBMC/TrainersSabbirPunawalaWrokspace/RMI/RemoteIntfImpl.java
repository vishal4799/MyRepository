import java.io.*;

public class RemoteIntfImpl implements RemoteIntf,Serializable{
	public double computeTax(double salary){
		return salary*0.1;
	}
}