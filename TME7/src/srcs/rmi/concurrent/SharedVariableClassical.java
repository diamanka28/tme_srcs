package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;

public class SharedVariableClassical<T extends Serializable> implements SharedVariable<T>{
	private T value;
	//vrai si occupé
	private boolean status;
	private Queue<Object> waitingList;
	
	public SharedVariableClassical(T initValue) {
		super();
		this.status = false;
		this.value = initValue;
		this.waitingList = new LinkedList<Object>();
	}
	
	@Override
	public synchronized T obtenir() throws RemoteException {
		
		Object mon_tick = new Object();
		this.waitingList.add(mon_tick);
		
		while(this.status || this.waitingList.peek() != mon_tick) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RemoteException("Thread interompu");
			}
		}
		
		//quitter la liste
		this.waitingList.poll();
		//retutrner la nouvelle objet
		this.status = true;
		return this.value;
	}
	@Override
	public synchronized void relacher(T newVal) throws RemoteException {
		//mise à jour 
		this.value = newVal;
		//deverrouiller
		this.status = false;
		
//		notification mais seule le client à la tete peut manip l'objet
		notifyAll();
	}
		
}
