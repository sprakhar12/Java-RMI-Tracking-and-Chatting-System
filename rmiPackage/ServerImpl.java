package rmiPackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface 
{
	private static final long serialVersionUID = 1L;
	private LinkedList<String> clientList;
	private HashMap <Integer, ClientInterface> Clients;
	public static int count=1;
	
	//Constructor
	public ServerImpl() throws RemoteException 
	{
		Clients = new HashMap <Integer, ClientInterface>();
		clientList = new LinkedList<String>();
	}
	
	/* Invoked Remote Method of ServerInterface in this remote object implementation for assigning Unique IDs to each client
	 * each client gets a reference to a remote object implementation (ClientImpl)
	 * Invoke Remote Method of ClientInterface (getUserid() and setUserid()) in its remote object implementation (ClientImpl)
	 */
	public synchronized void ClientRegistry(ClientInterface client) throws RemoteException 
	{
		if(!Clients.containsKey(client.getUserid())){
			client.setUserid(count);
			this.Clients.put(client.getUserid(), client);
			count++;
		}
	}
	
	// Invoked Remote Method
	public synchronized void Send(Integer id, String input) throws RemoteException 
	{
		
		if(input.equals("get location"))
	 	{
			input= Clients.get(id).getX() +","+ Clients.get(id).getY();
			
	 	}
		
		else if(input.equals("list 30"))
		{
		 	Set<Integer> pointers = Clients.keySet();
		 	String str=" List of clients: \n";
		 	int x1=Integer.parseInt(Clients.get(id).getX());
		 	int y1=Integer.parseInt(Clients.get(id).getY());
		 	int x2=0;
		 	int y2=0;
		 	int x3=0;
		 	int y3=0;
		 	
		 	for(Integer user_id : pointers)
		 	{
		 		clientList.add(Integer.toString(Clients.get(user_id).getUserid()));
		 		clientList.add(Clients.get(user_id).getName());
		 		clientList.add(Clients.get(user_id).getAge());
		 		
		 		x2=Integer.parseInt(Clients.get(user_id).getX());
		 		y2=Integer.parseInt(Clients.get(user_id).getY());
		 		x3=x2-x1;
		 		y3=y2-y1;
		 		if(((x3^2 + y3^2)^1/2) <= 30)
		 		{
		 			str += clientList.get(clientList.size()-3) + " " +clientList.get(clientList.size()-2) + " " + clientList.getLast() + "\n"; 
		 		}
		 	}
		  input = str;
		}
					
		Clients.get(id).MessageReceived(id,input);
	}
}
