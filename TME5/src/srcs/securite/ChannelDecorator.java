package srcs.securite;

import java.io.IOException;
import java.net.InetAddress;

public class ChannelDecorator implements Channel{

	private final Channel channel;
	
	public ChannelDecorator(Channel cha) {
		this.channel = cha;
	}

	/**
	 * @param bytesArray
	 * @throws IOException
	 * @see srcs.securite.Channel#send(byte[])
	 */
	public void send(byte[] bytesArray) throws IOException {
		channel.send(bytesArray);
	}

	/**
	 * @return
	 * @throws IOException
	 * @see srcs.securite.Channel#recv()
	 */
	public byte[] recv() throws IOException {
		return channel.recv();
	}

	/**
	 * @return
	 * @see srcs.securite.Channel#getRemoteHost()
	 */
	public InetAddress getRemoteHost() {
		return channel.getRemoteHost();
	}

	/**
	 * @return
	 * @see srcs.securite.Channel#getRemotePort()
	 */
	public int getRemotePort() {
		return channel.getRemotePort();
	}

	/**
	 * @return
	 * @see srcs.securite.Channel#getLocalHost()
	 */
	public InetAddress getLocalHost() {
		return channel.getLocalHost();
	}

	/**
	 * @return
	 * @see srcs.securite.Channel#getLocalPort()
	 */
	public int getLocalPort() {
		return channel.getLocalPort();
	}
	
}
