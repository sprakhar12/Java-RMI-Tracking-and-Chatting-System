package rmiPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote
{
	/* declares each of the methods to call remotely */
	public void ClientRegistry(ClientInterface clientInterface) throws RemoteException;
	public void Send(Integer id, String input) throws RemoteException;
}


