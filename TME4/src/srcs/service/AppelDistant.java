package srcs.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public interface AppelDistant extends Service {

	@Override
	default void execute(Socket connexion) {
		try {
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(connexion.getOutputStream());
			out.flush();
			
			String methodName = in.readUTF(); //Methode
			Object[] params = (Object[])in.readObject(); //Parametres
			Object response; //reponse
			
			Class<?> cl = this.getClass();
			Method method = null;
			
			for(Method m : cl.getMethods()) {
				if(m.getName().equals(methodName) && m.getParameterCount() == params.length) {
					method = m;
					break;
				}
			}
			if(method == null) {
				response = new MyProtocolException("Methode inconnu " + methodName);
			}else {
				response = method.invoke(this, params);
			}
			
			out.writeObject(response);
			out.flush();
			out.close();
			
		}catch(Exception e){
			
			try (ObjectOutputStream out = new ObjectOutputStream(connexion.getOutputStream());){
				out.writeObject(e);
				out.flush();
				out.close();
			}catch(Exception ea) { }
		}
	}
}
