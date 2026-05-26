package srcs.banque;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import srcs.persistance.Sauvegardable;

public class Banque implements Sauvegardable{

	private final Set<Client> clients;
	
	public Banque() {
		clients=new HashSet<>();
	}
	public Banque(InputStream in) throws IOException {
		this.clients = new HashSet<>();
		try (DataInputStream file = new DataInputStream(in)){
			//Prend le nombre de client en premier
			int size = file.readInt();
			String nom, id;
			double solde;
			for(int i=0; i<size; i++) {
				nom = file.readUTF();
				id = file.readUTF();
				solde = file.readDouble();
				Compte cpt = new Compte(id, solde);
				Client clt = new Client(nom, cpt);
				clients.add(clt);
			}
		}
	}
		
	public int nbClients() {
		return clients.size();
	}
	
	public int nbComptes() {
		Set<Compte> comptes = new HashSet<>();
		for(Client c : clients) {
			comptes.add(c.getCompte());
		}
		return comptes.size();
	}
	
	public Client getClient(String nom) {
		for(Client c : clients) {
			if(c.getNom().equals(nom)) return c;
		}
		return null;
	}
	
	public boolean addNewClient(Client c) {
		return clients.add(c);
	}

	@Override
	public void save(OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream file = new DataOutputStream(out);
		int size = this.nbClients();
		file.writeInt(size);
		Iterator<Client> it = clients.iterator();
		while(it.hasNext()) {
			it.next().save(file);
		}
	}
	

}
