# Java-RMI-Tracking-and-Chatting-System
Simple distributed system using Java RMI

 Implemented in Eclipse

All java files are created inside "rmiPackage" package

After compiling in Eclipse, bin folder inside the project folder under workspace will have compiled java files

<ol> 
 <li> Open 1st cmd --> locate project folder --> bin folder --> rmic rmiPackage.ServerImpl
then,
--> rmic rmiPackage.ClientImpl
then,
--> rmiregistry
 </li>

<li> Open 2nd cmd --> locate project folder --> bin folder --> java rmiPackage.Server </li>

<li> Open 3rd cmd --> locate project folder --> bin folder --> java rmiPackage.Client first_client 25 50 24 </li>

<li> Open 4th cmd --> locate project folder --> bin folder --> java rmiPackage.Client second_client  0 50 10 </li>

<li> Open 5th cmd --> locate project folder --> bin folder --> java rmiPackage.Client third_client 0 0 21 </li>
</ol>
