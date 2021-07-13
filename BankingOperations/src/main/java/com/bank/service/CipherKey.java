package com.bank.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;
import javax.crypto.Cipher;
public class CipherKey {
	
	public Cipher Cipher() throws Exception {
		
		Signature sign = Signature.getInstance("SHA256withRSA");
		
		KeyPairGenerator kPG = KeyPairGenerator.getInstance("RSA");
		
		kPG.initialize(2048);
		
		final KeyPair pair = kPG.generateKeyPair();
		
		PublicKey pK = pair.getPublic();
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		
		cipher.init(Cipher.ENCRYPT_MODE, pK);
		
		return cipher;
		
		//https://www.tutorialspoint.com/java_cryptography/
		
	}
}
