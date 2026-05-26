package rev.rmi.task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws Exception{
		
		try {
			Registry registre;
			registre = LocateRegistry.getRegistry("localhost", 1099);
			ComputeEngine ww = (ComputeEngine) registre.lookup("Calculateur");
			
			AdditionTask add = new AdditionTask(1.2, 3.3);
			Double res = ww.executeTask(add);
			
			System.out.println("Resultat: " + res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
