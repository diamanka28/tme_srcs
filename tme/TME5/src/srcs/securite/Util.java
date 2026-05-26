package srcs.securite;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Util {

	public static KeyPair generateNewKeyPair(String algorithm, int sizekey) throws NoSuchAlgorithmException{
		
		KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
		generator.initialize(sizekey);
		
		return generator.generateKeyPair();
		
	}
}
