package srcs.http;

import java.io.*;
import java.net.Socket;

public class GetProcessor implements RequestProcessor {

    @Override
    public void process(Socket connexion) {

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connexion.getInputStream()));
            PrintWriter out = new PrintWriter(
                    connexion.getOutputStream());

            // Lire ligne de requête
            String requestLine = br.readLine();
            if (requestLine == null)
                return;

            String[] parts = requestLine.split(" ");
            if (parts.length != 3 || !parts[0].equals("GET")) {
                send400(out);
                return;
            }

            String path = parts[1];

            // Lire les en-têtes
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty());

            File file = new File(path);

            if (!file.exists() || file.isDirectory()) {
                send404(out);
                file.toString();
                return;
            }

            out.print("HTTP/1.1 200 OK\r\n");
            out.print("\r\n");
            out.flush();

            FileInputStream fis = new FileInputStream(file);
            OutputStream os = connexion.getOutputStream();

            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send400(PrintWriter out) {
        out.print("HTTP/1.1 400 Bad Request\r\n\r\n");
        out.flush();
    }

    private void send404(PrintWriter out) {
        out.print("HTTP/1.1 404 Not Found\r\n\r\n");
        out.flush();
    }
    
    public static void main(String[] args) {
		Serveur serveur = new Serveur(7080, new GetProcessor());
		
		serveur.start();
	}
}