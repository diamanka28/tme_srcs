package srcs.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Host extends Remote {

	public Remote deployNewService(String serviceName, Class<? extends FunctionService> serviceClass) throws RemoteException;
	public Remote deployExistingService(String serviceName, FunctionService service) throws RemoteException;
	public Boolean undeployService(String serviceName) throws RemoteException;
	public List<String> getServices() throws RemoteException;
}
