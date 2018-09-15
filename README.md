# Java-RMI-Tracking-and-Chatting-System
Simple distributed system using Java RMI
Both clients and servers are on the same host

Implemented in Eclipse

All java files are created inside "rmiPackage" package

After compiling in Eclipse, bin folder inside the project folder under workspace will have compiled java files

###### Sample parameters (x, y, age) --> 0 0 20

<ol> 
 <li> Open 1st cmd --> locate project folder --> bin folder --> rmic rmiPackage.ServerImpl
  <ul> <li> then, --> rmic rmiPackage.ClientImpl </li>
       <li> then, --> rmiregistry </li>
  </ul>
 </li>

 <li> Open 2nd cmd --> locate project folder --> bin folder --> java rmiPackage.Server </li>

 <li> Open 3rd cmd --> locate project folder --> bin folder --> java rmiPackage.Client first_client x y age </li>

 <li> Open 4th cmd --> locate project folder --> bin folder --> java rmiPackage.Client second_client x y age </li>

 <li> Open 5th cmd --> locate project folder --> bin folder --> java rmiPackage.Client third_client x y age </li>
</ol>

#### Following requests can be made by each of the registered client

<ul>
 <li><strong>go -50 30</strong> : client wants to go 50m South and 30m East, server updates the location
  and reports the new location (go 40 -20 means go 40m North and 20m West) </li>
 <li><strong>get location</strong> : client wants to know its current (x,y) location, server reports the current
  location of this client </li>
 <li><strong>list 30</strong> : client wants to get the list of users within 30m, server determines such clients/users within 30m of 
  requesting client and send their information (userid, name, age) to the client, client keeps that list in a linked 
  list and prints their user-id, name, and age on the screen </li>
 <li><strong> send userid msg</strong> : client sends msg directly to user-id. Server not involved. </li>
 <li><strong>quit</strong></li>
</ul>
