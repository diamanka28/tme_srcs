package srcs.service.calculatrice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import srcs.service.MyProtocolException;
import srcs.service.SansEtat;
import srcs.service.Service;

@SansEtat
public class CalculatriceService implements Calculatrice, Service{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int sous(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return a  * b;
	}

	@Override
	public ResDiv div(int a, int b) {
		// TODO Auto-generated method stub
		return new ResDiv(a / b, a % b);
	}

	@Override
	public void execute(Socket connexion) {
		// TODO Auto-generated method stub
		
		try {
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(connexion.getOutputStream());
		
			String method = in.readUTF();
			Object response;
			switch(method) {
			case "add":{
				int a = (int) in.readInt();
				int b = (int) in.readInt();
				response = add(a,b);
				break;
			}
			case "sous":{
				int a = (int) in.readInt();
				int b = (int) in.readInt();
				response = sous(a,b);
				break;
			}
			case "mult":{
				int a = (int) in.readInt();
				int b = (int) in.readInt();
				response = mult(a,b);
				break;
			}
			case "div":{
				int a = (int) in.readInt();
				int b = (int) in.readInt();
				response =(ResDiv) div(a,b);
				break;
			}
			default: 
				response =  new MyProtocolException("Méthode inconnue: " + method);
			}
			out.writeObject(response);
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			try {
				ObjectOutputStream out = new ObjectOutputStream(connexion.getOutputStream());
				out.writeObject(e);
				out.flush();
				out.close();
			}catch(IOException ea) {}
		}
	}

}
