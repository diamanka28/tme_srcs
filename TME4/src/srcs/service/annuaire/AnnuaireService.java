package srcs.service.annuaire;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import srcs.service.EtatGlobal;
import srcs.service.MyProtocolException;
import srcs.service.Service;
import srcs.service.VoidResponse;

@EtatGlobal
public class AnnuaireService implements Annuaire, Service{

	private final Map<String, String> annuaire = new HashMap<>();
	@Override
	public void execute(Socket connexion) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(connexion.getOutputStream());
			out.flush();
			
			String method = in.readUTF();
			Object response;
			switch (method) {
			case "lookup":{
				String nom = in.readUTF();
				response =(String) lookup(nom);
				break;
			}
			case "bind":{
				String nom = in.readUTF();
				String valeur = (String) in.readUTF();
				bind(nom,valeur);
				response = new VoidResponse();
				break;
			}
			case "unbind":{
				String nom = (String) in.readUTF();
				unbind(nom);
				response = new VoidResponse();
				break;
			}
			default: 
				response = new MyProtocolException("Méthode inconnue "+ method);
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

	@Override
	public synchronized String lookup(String nom) {
		// TODO Auto-generated method stub
		return annuaire.getOrDefault(nom, "");
	}

	@Override
	public synchronized void bind(String nom, String valeur) {
		// TODO Auto-generated method stub
		annuaire.put(nom, valeur);
	}

	@Override
	public synchronized void unbind(String nom) {
		// TODO Auto-generated method stub
		annuaire.remove(nom);
	}

}
