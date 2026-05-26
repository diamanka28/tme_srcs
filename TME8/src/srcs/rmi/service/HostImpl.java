package srcs.rmi.service;

import java.lang.reflect.InvocationTargetException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HostImpl implements Host{
	
	private List<String> services;
	
	public HostImpl() {
		this.services = new ArrayList<>();
	}
	@Override
	public Remote deployNewService(String serviceName, Class<? extends FunctionService> serviceClass)
			throws RemoteException {
		// TODO Auto-generated method stub
		if(this.services.contains(serviceName)) {
			throw new IllegalArgumentException("Ce service est déjà présent");
		}
		try {
			FunctionService service = serviceClass.getDeclaredConstructor(String.class).newInstance(serviceName);
			FunctionService stub = (FunctionService) UnicastRemoteObject.exportObject(service, 0);
			
			Registry registre;
			registre = LocateRegistry.getRegistry();
			
			registre.rebind(serviceName, stub);
			this.services.add(serviceName);
			return stub;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Remote deployExistingService(String serviceName, FunctionService service) throws RemoteException {
		// TODO Auto-generated method stub
		
		if(this.services.contains(serviceName)) {
			throw new IllegalArgumentException("Service existe déjà!");
			
		}
		FunctionService stub = (FunctionService) UnicastRemoteObject.exportObject(service, 0);
		Registry registre;
		registre = LocateRegistry.getRegistry();
		registre.rebind(serviceName, stub);
		this.services.add(serviceName);
		
		return stub;
	}

	@Override
	public Boolean undeployService(String serviceName) throws RemoteException {
		// TODO Auto-generated method stub
		
		Registry registre;
		registre = LocateRegistry.getRegistry();
		
		try {
			Remote service = registre.lookup(serviceName);
			registre.unbind(serviceName);
			UnicastRemoteObject.unexportObject(service, true);
			
			this.services.remove(serviceName);
			return true;
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			return false;
		}
		
		return false;
	}

	@Override
	public List<String> getServices() throws RemoteException {
		// TODO Auto-generated method stub
		return this.services;
	}

}
