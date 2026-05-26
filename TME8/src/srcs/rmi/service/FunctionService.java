package srcs.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FunctionService<P,R>  extends Remote{

	public String getName() throws RemoteException;
	public Object invoke(Object o) throws RemoteException;
	public FunctionService<P,R> migrateTo(Host hote) throws RemoteException;
}
