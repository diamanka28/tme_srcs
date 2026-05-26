package rev.rmi.task;

import java.rmi.RemoteException;

public class Worker implements ComputeEngine{
	
	@Override
	public <T> T executeTask(Task<T> t) throws RemoteException {
		return t.execute();
	}
}
