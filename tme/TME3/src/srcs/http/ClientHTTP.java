package srcs.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHTTP {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("www.google.fr", 80);

	        PrintWriter out = new PrintWriter(socket.getOutputStream());
	        out.print("GET /index.html HTTP/9.0\r\n");
	        out.print("Host: www.google.fr\r\n");
	        out.print("\r\n");
	        out.flush();

	        InputStream in;
			in = socket.getInputStream();
			int b;
	        while ((b = in.read()) != -1) {
	            System.out.write(b);
	        }
	        socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
