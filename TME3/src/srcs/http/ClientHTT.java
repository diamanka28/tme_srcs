package srcs.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHTT {
	
	public static void main(String[] args) {
		try {
			Socket serveur = new Socket("www.google.fr", 80);
			InputStream in = serveur.getInputStream();
			OutputStream out = serveur.getOutputStream();
			
			String request = "GET /toto.html HTTP/1.1\r\n" +
							"Host: www.google.fr\r\n" +
							"\r\n" ;
			out.write(request.getBytes());
			out.flush();
			int b;
			while((b = in.read()) != -1){
				System.out.write(b);
			}
			serveur.close();
							
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
