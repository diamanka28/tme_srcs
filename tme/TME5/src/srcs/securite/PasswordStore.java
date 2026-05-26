package srcs.securite;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PasswordStore {

	private final String algoHach;
	private final Map<String, byte[]> passwds = new HashMap<>();
	
	public PasswordStore(String algo) {
		this.algoHach = algo;
	}
	
	public void storePassword(String user, String passwd) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoHach);
			md.update(passwd.getBytes());
			this.passwds.put(user, md.digest());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkPassword(String user, String passwd) {
	    try {
	        MessageDigest md = MessageDigest.getInstance(this.algoHach);
	        md.update(passwd.getBytes());

	        byte[] hash = md.digest();

	        byte[] stored = this.passwds.get(user);

	        if (stored == null) {
	            return false;
	        }

	        return Arrays.equals(hash, stored);

	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
