package srcs.persistance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

public class PersistanceSauvegardable {
	
	public static void save(String fichier, Sauvegardable s) throws IOException {
		try (OutputStream out = new FileOutputStream(fichier)){
			
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF(s.getClass().getCanonicalName());
			s.save(dos);
		}
	}
	
	public static Sauvegardable load(String fichier) throws IOException {
		try (InputStream in = new FileInputStream(fichier)){
			DataInputStream dis = new DataInputStream(in);
			//Compte!!!! cela doit marcher pour tout objet Sauvegardable
			String nomClass = dis.readUTF();
			Class<?> cl;
			try {
				cl = Class.forName(nomClass);
				Class<? extends Sauvegardable> cls = cl.asSubclass(Sauvegardable.class);
				
				Sauvegardable sauve = cls.getConstructor(InputStream.class).newInstance(dis);
				return sauve;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
