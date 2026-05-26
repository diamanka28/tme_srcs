package srcs.rmi.service;

import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.After;
import org.junit.Before;

public class SystemDeployer {

	private final String namehost1="host1";
	private final String namehost2="host2";
	private HostImpl host1;
	private HostImpl host2;
	
	@Before
	public void beforeTest() {
		 this.host1 = new HostImpl();
		 this.host2 = new HostImpl();
		 
		 try {
			Host stub1 = (Host) UnicastRemoteObject.exportObject(host1, 0);
			Host stub2 = (Host) UnicastRemoteObject.exportObject(host2, 0);
			Registry registre;
			try {
				registre = LocateRegistry.getRegistry();
				registre.list();
			}catch(Exception e) {
				registre = LocateRegistry.createRegistry(1099);
			}
			
			registre.rebind(namehost1, stub1);
			registre.rebind(namehost2, stub2);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@After
	public void afterTest() {
		System.out.println("Debut nettoyage!!");
		try {
			Registry registre = LocateRegistry.getRegistry();
			
			// Nettoyage du registre
			String[] names = registre.list();
			for (String name : names) {
			    try {
			        Remote obj = registre.lookup(name);
			        registre.unbind(name);
			        UnicastRemoteObject.unexportObject(obj, true);
			    }catch (Exception e) { }
			}
			
			if (host1 != null) UnicastRemoteObject.unexportObject(host1, true);
	        if (host2 != null) UnicastRemoteObject.unexportObject(host2, true);
	        
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("Nettoyage terminé !!!");
	}
}
