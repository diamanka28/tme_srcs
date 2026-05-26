package rev.rmi.task;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputeEngine extends Remote {

	<T> T executeTask(Task<T> t) throws RemoteException;
}
