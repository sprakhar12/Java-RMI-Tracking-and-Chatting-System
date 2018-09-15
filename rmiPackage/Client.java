package rmiPackage;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Naming;

public class Client {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException 
	{
		/* remote clients to get a reference to a remote object */
		String ServerURL = "rmi://localhost/9050";
		ServerInterface serverInterface = (ServerInterface) Naming.lookup(ServerURL);
		new Thread(new ClientImpl(args[0], args[1], args[2], args[3], serverInterface)).start();
	}
}
