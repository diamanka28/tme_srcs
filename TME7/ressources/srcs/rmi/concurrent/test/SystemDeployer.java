package srcs.rmi.concurrent.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.After;
import org.junit.Before;

import srcs.rmi.concurrent.SharedVariable;
import srcs.rmi.concurrent.SharedVariableClassical;
import srcs.rmi.concurrent.SharedVariableReliable;

public class SystemDeployer {

	private SharedVariable<Integer> nameServic;
	final String nameService = "variableIntegerReliable";
	
	@Before
	public void beforeTest() {
	    this.nameServic = new SharedVariableReliable<>(0);
	    try {
	        SharedVariable<Integer> stub =(SharedVariable<Integer>) UnicastRemoteObject.exportObject(nameServic, 0);
	        Registry registre;
	        try {
	            // essayer de récupérer un registry existant
	            registre = LocateRegistry.getRegistry();
	            registre.list(); //test si vivant
	        } catch (Exception e) {
	            // sinon le créer
	            registre = LocateRegistry.createRegistry(1099);
	        }
	        registre.rebind(nameService, stub);

	    } catch (RemoteException e) {
	        e.printStackTrace();
	    }
	}
	
	@After
	public void afterTest() throws NotBoundException {
		
		try {
			Registry registre = LocateRegistry.getRegistry();
			registre.unbind(nameService);
		
			UnicastRemoteObject.unexportObject(this.nameServic, true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
