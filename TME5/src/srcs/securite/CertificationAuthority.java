package srcs.securite;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;

public class CertificationAuthority {

	private final String algoChif;
	private final int taille;
	private final String algoSig;
	private final KeyPair privpub;
	private final Map<String, Certif> certifications = new HashMap<>();
	
	public CertificationAuthority(String chif, int t, String sig) throws NoSuchAlgorithmException {
		this.algoChif = chif;
		this.taille = t;
		this.algoSig = sig;
		
		this.privpub = Util.generateNewKeyPair(this.algoChif, this.taille);
	}
	
	public PublicKey getPublicKey() {
		return this.privpub.getPublic();
	}
	
	public Certif getCertificate(String identifier) {
		return certifications.getOrDefault(identifier, null);
	}
	
	public Certif declarePublicKey(String identifier, PublicKey pkey) throws GeneralSecurityException {
		
		Signature sign = Signature.getInstance(this.algoSig);
		sign.initSign(this.privpub.getPrivate());
		sign.update(pkey.getEncoded());
		
		byte[] signs = sign.sign();
		
		if(this.certifications.containsKey(identifier)) {
			throw new GeneralSecurityException("Il existe deja une clef public.");
		}else {
			Certif cetif = new Certif(identifier,pkey, signs, this.algoSig);
			this.certifications.put(identifier, cetif);
			
			return cetif;
		}
	}
}
