package util;

import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.security.MessageDigest;


public class Criptografia {
	public static String MD5(String login, String senha){
	 	String sen = ""; String juncao = login + senha;
	 		try {
	 			MessageDigest md = MessageDigest.getInstance("MD5");
	 			sen = (new BigInteger(1, md.digest(juncao.getBytes()))).toString(16);
	 		} catch (NoSuchAlgorithmException e) {
	 			e.printStackTrace();
	 		}
	 		return sen;
	}

//	public static void main(String[] args) {
//		System.out.println(MD5("1000", "123456"));
//	}
}




