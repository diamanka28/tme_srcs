package srcs.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class ClientProxy {

	private final String serveur;
	private final int port;
	private Socket client;
	
	public ClientProxy(String nom, int po) {
		this.serveur = nom;
		this.port = po;
	}
	public String getServeur() {
		return this.serveur;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public Object invokeService(String name, Object[] params) {
		try {
			client = new Socket(this.serveur, this.port);
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			
			out.flush();
			out.writeUTF(name);
			out.writeObject(params);
			out.flush();
			
			Object result = in.readObject();
			if( result instanceof MyProtocolException) {
				throw (MyProtocolException) result;
			}
			
			return result;
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new MyProtocolException(e.getMessage());
		}
	}
}
