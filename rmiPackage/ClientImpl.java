package rmiPackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface, Runnable
	{
		private static final long serialVersionUID = 1L;
		public int id=0;
		public String name = null;
		public String x = null;
		public String y = null;
		public String age = null;
		private ServerInterface serverInterface ;
		
		/* Getter and Setter */
		public int getUserid(){
			return id;
		}
		public void setUserid(int count){
			this.id = count;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		
		// Constructor
		public ClientImpl(String name, String x, String y, String age, ServerInterface serverInterface) throws RemoteException 
		{
		this.name = name;
		this.x = x;
		this.y = y;
		this.age = age;
		this.serverInterface = serverInterface;
		serverInterface.ClientRegistry(this);
		}
		
		// Invoked Remote Method
		public void MessageReceived(Integer id, String input) throws RemoteException 
		{
			System.out.println(name + ": "+ input);
		}
		
		//Thread
		public void run() 
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String input;
			
			while(true)
			{
				input = sc.nextLine();
				try 
				{
					if(input.startsWith("send"))
					{
						String[] line = input.split (" ");
						String message ="";
						for(int count=2;count<line.length;count++)
						{
							message+=line[count]+" ";
						}
					serverInterface.Send(Integer.parseInt(line[1]),message);
					}
					
					else if(input.equals("quit"))
					{
						System.exit(0);
					}
					
					else if(input.startsWith("go"))
					{
						String[] line = input.split (" ");
						x = new Integer(Integer.parseInt(x) + Integer.parseInt(line[1])).toString(); 
						y = new Integer(Integer.parseInt(y) + Integer.parseInt(line[2])).toString();
						serverInterface.ClientRegistry(this);
					}
									
					else 
					{
						serverInterface.Send(id, input);
					}
					
				} 
				catch(RemoteException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

