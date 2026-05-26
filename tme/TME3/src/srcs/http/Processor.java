package srcs.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Processor implements RequestProcessor{

	@Override
	public void process(Socket connexion) {
		try {
			InputStream is = connexion.getInputStream();
			int data;
			while((data = is.read()) != -1) {
				System.out.write(data);
			}
			
			connexion.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Serveur serveur = new Serveur(9092, new Processor());
		serveur.start();
	}
}
