package rmiPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote 
{
	/* declares each of the methods to call remotely */
	public void MessageReceived(Integer id, String input)throws RemoteException;
	public int getUserid() throws RemoteException;
	public void setUserid(int count) throws RemoteException;
	public String getName() throws RemoteException;
	public String getAge() throws RemoteException;
	public String getX() throws RemoteException;
	public String getY() throws RemoteException;
	public void setX(String x) throws RemoteException;
	public void setY(String y) throws RemoteException;
	
}