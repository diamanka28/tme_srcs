package srcs.persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import srcs.banque.Compte;

public class PersistanceCompte {
	
	public static void saveCompte(String f, Compte e) throws IOException {
		try (OutputStream out = new FileOutputStream(f)){
			e.save(out);
		}
	}
	
	public static Compte loadCompte(String f) throws IOException{
		FileInputStream file = new FileInputStream(f);
		Compte cpt = new Compte(file);
		return cpt;
	}

}
