package rmiPackage;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class Server 
{
	public static void main(String[] args) throws MalformedURLException, RemoteException
	{
		// Bind the remote object instance to the name "9050" 
		Naming.rebind("9050", new ServerImpl());
	}
}
