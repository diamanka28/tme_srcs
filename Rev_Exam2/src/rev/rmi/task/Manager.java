package rev.rmi.task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Manager{

	public static void main(String[] args) throws Exception {
		try {
			Worker worker = new Worker();
			ComputeEngine work = (ComputeEngine) UnicastRemoteObject.exportObject(worker, 0);
			
			Registry registre;
			try {
				registre = LocateRegistry.getRegistry(1099);
				registre.list();
			}catch(Exception e) {
				registre = LocateRegistry.createRegistry(1099);
			}
			registre.rebind("Calculateur", work);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
