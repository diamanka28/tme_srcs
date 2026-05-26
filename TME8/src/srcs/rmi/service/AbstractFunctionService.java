package srcs.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract class AbstractFunctionService<P, R> implements FunctionService<P,R>{

	private final String name;
	
	private Boolean ismigrated;
	private Boolean ismigrating;
	
	private FunctionService<P,R> serviceCopy  = null;
	
	public AbstractFunctionService(String nom) {
		super();
		this.name = nom;
		this.ismigrated = false;
		this.ismigrating = false;
	}
	
	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public synchronized Object invoke(Object o) throws RemoteException {
		// TODO Auto-generated method stub
		long timestart = System.currentTimeMillis();
		while(this.ismigrating) {
			try {
				wait(5000);
				if(System.currentTimeMillis() - timestart > 5000) {
					throw new RemoteException("Trop d'attente!!!");
				}
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		//si migrté
		if(this.ismigrated) {
			return this.serviceCopy.invoke(o);
		}
		//sinon
		P params = (P) o;
		R retours = perform(params);
		return retours;
	}

	@Override
	public synchronized FunctionService<P,R> migrateTo(Host hote) throws RemoteException {
		// TODO Auto-generated method stub
		
		if(this.ismigrated) {
			throw new RemoteException("Déjà migré!!");
		}
	
		this.ismigrating = true;
		
		try {
			Remote remote = hote.deployExistingService(this.name, this);
			this.serviceCopy =(FunctionService<P, R>) remote;
			this.ismigrated = true;
	
			return this.serviceCopy;
		}finally{
			this.ismigrating = false;
			notifyAll();
		}
	}

	protected abstract R perform(P params);
}
