package srcs.securite;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ChannelBasic implements Channel{

	private final Socket connexion;
	
	public ChannelBasic(Socket conn) {
		this.connexion = conn;
	}
	@Override
	public void send(byte[] bytesArray) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream out = new DataOutputStream(this.connexion.getOutputStream());
		
		out.writeInt(bytesArray.length);
		out.write(bytesArray);
		out.flush();
	}

	@Override
	public byte[] recv() throws IOException {
		// TODO Auto-generated method stub
		DataInputStream in = new DataInputStream(this.connexion.getInputStream());
		int len = in.readInt();
		byte[] lect = new byte[len];
		in.readFully(lect);
		return lect;
	}

	@Override
	public InetAddress getRemoteHost() {
		// TODO Auto-generated method stub
		return this.connexion.getInetAddress();
	}

	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return this.connexion.getPort();
	}

	@Override
	public InetAddress getLocalHost() {
		// TODO Auto-generated method stub
		return this.getLocalHost();
	}

	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return this.getLocalPort();
	}
	
}
