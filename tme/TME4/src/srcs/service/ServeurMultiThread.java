package srcs.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMultiThread {
	
	private final int port;
	private final Class<? extends Service> service;
	private Service serviceGlobal = null;
	
	public ServeurMultiThread(int p, Class<? extends Service> serv) {
		this.port = p;
		this.service = serv;
	}
	
	//la méthode de listen
	public void listen() {
		try (ServerSocket ss = new ServerSocket(this.port)){
			while(true) {
				Socket client = ss.accept();
				Service service = getService();
				
				new Thread(()-> {
					service.execute(client);
					try {
						client.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}).start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//la méthode getService
	public Service getService() {
		if(service.isAnnotationPresent(SansEtat.class)) {
			try {
				return service.getDeclaredConstructor().newInstance() ;
			}catch(InstantiationException | InvocationTargetException |
					IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		if(service.isAnnotationPresent(EtatGlobal.class)) {
			if(this.serviceGlobal == null) {
				try {
					this.serviceGlobal = service.getDeclaredConstructor().newInstance() ;
				}catch(InstantiationException | InvocationTargetException |
						IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			return this.serviceGlobal;
		}
		throw new IllegalStateException("La classe doit etre annoté SansEtat ou EtatGlobal");
	}
}
