package srcs.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LineProcessor implements RequestProcessor{

	@Override
	public void process(Socket connexion) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(connexion.getInputStream()));
			String line;
			
			while((line = in.readLine()) != null) {
				System.out.println(line);
				if(line.isEmpty()) {
					break;
				}
			}
			String reponse = "HTTP/1.1 200 OK\r\n" + 
							 "\r\n" +
							 "<html><h1>Mon serveur HTTP fonctionne</h1></html>";
			PrintWriter os = new PrintWriter(connexion.getOutputStream());
			os.write(reponse);
			os.flush();
			connexion.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Serveur serveur = new Serveur(7000, new LineProcessor());
		
		serveur.start();
	}

}
