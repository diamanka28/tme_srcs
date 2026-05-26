package srcs.persistance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PersistanceArray {

	public static void saveArrayInt(String f, int[] tab) throws IOException {
		OutputStream out = new FileOutputStream(f);
		
		try (DataOutputStream file = new DataOutputStream(out)) {
			int i = 0;
			//Ecriture de la taille
			file.writeInt(tab.length);
			//les éléments du tableau
			for(i=0; i<tab.length; i++) {
				file.writeInt(tab[i]);;
			}
			out.close();
			file.close();
		}
	}
	
	public static int[] loadArrayInt(String fichier) throws IOException {
		
		try (FileInputStream in= new FileInputStream(fichier);){
			DataInputStream file = new DataInputStream(in);
			//lecture de la taille
			int size = file.readInt();
			//déclaration du tableau
			int[] tab= new int[size];
			//lecture des éléments du tableau
			for(int i = 0; i<size; i++) {
				tab[i] = file.readInt();
			}
			file.close();
			in.close();
			
			return tab;
		}
	}
}
