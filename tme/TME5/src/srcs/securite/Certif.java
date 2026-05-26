package srcs.securite;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;

public class Certif {

	private final String identifier;
	private final PublicKey publicKey;
	private final byte[] sign;
	private final String algorithm;
	
	protected Certif(String privateKey, PublicKey publicKey, byte[] sign, String algorithm) {
		super();
		this.identifier = privateKey;
		this.publicKey = publicKey;
		this.sign = sign;
		this.algorithm = algorithm;
	}

	/**
	 * @return the privateKey
	 */
	public String getIdentifier() {
		return this.identifier;
	}

	/**
	 * @return the publicKey
	 */
	public PublicKey getPublicKey() {
		return this.publicKey;
	}

	/**
	 * @return the sign
	 */
	public byte[] getSign() {
		return sign;
	}

	/**
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}
	
	public boolean verify(PublicKey publickeyauthorithy) throws GeneralSecurityException{
		
		Signature sig = Signature.getInstance(algorithm);
		sig.initVerify(publickeyauthorithy);
		sig.update(publicKey.getEncoded());
		
		boolean valid = sig.verify(sign);
		
		return valid;
	}
}

	
