package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class SharedVariableReliable<T extends Serializable> implements SharedVariable<T>{

	private T value;
	private boolean status;
	private Queue<Object> waitingList;
	
	//Parametres de securite
	private final int delay = 2000;
	private Timer timer;
	
	public SharedVariableReliable(T initValue) {
		this.status = false;
		this.value = initValue;
		this.waitingList = new LinkedList<Object>();
		
		this.timer = new Timer(true);
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
		this.waitingList.poll();
		this.status = true;
		
		startTimer(); //le timer demarre
		
		return this.value;
	}
	@Override
	public synchronized void relacher(T newVal) throws RemoteException {
		
		cancelTimer();
		
		this.value = newVal;
		this.status = false;
		notifyAll();
		
		
	}
		
	
	//methodes de securité
	
	public void cancelTimer() {
		if(this.timer != null) {
			this.timer.cancel();
		}
	}
	
	private void startTimer() {
		cancelTimer(); //supprimer l'ancien timer
		this.timer = new Timer(true); // nouveau thread timer
		this.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				realese();
			}
		}, this.delay);
	}

	private synchronized void realese() {
		if(this.status) {
			System.err.println("Bip!! Bip!!: timer fini");
			this.status = false;
			notifyAll();
		}
	}
}
