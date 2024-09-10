import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class EncodeDecode
{
//  public static void main(String[] args)
//  {
//    

//	try
//	  {
//	    String  str= Encrypt("test string","a@m#i$t");

//		String str1=Decrypt(str,"a@m#i$t");

//	  }
//	 catch (Exception e) {
//        // An exception here probably means the JCE provider hasn't
//        // been permanently installed on this system by listing it
//        // in the $JAVA_HOME/jre/lib/security/java.security file.
//        // Therefore, we have to install the JCE provider explicitly.

//        Provider sunjce = new com.sun.crypto.provider.SunJCE();
//        Security.addProvider(sunjce);
//      }
//
//
//  }
  public  String Encrypt (String text, String key) throws Exception 
  {
     System.out.print("inside encryption :-)");
	  Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
     byte[] keyBytes = new byte[16];
     byte[] b = key.getBytes("UTF-8");
     int len = b.length;
     if (len > keyBytes.length)
	 len = keyBytes.length;
     System.arraycopy(b, 0, keyBytes, 0, len);
     SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
     IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
     cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
     byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
     BASE64Encoder encoder = new BASE64Encoder();
     return encoder.encode(results);
  }
  
  
  public  String Decrypt(String text, String key) throws Exception 
  {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length)
			len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		BASE64Decoder decoder = new BASE64Decoder();
		byte[] results = cipher.doFinal(decoder.decodeBuffer(text));
		return new String(results, "UTF-8");
 }
public String getMd5(String input){
	  
      try { 

          // Static getInstance method is called with hashing MD5 
          MessageDigest md = MessageDigest.getInstance("MD5"); 

          // digest() method is called to calculate message digest 
          //  of an input digest() return array of byte 
          byte[] messageDigest = md.digest(input.getBytes()); 

          // Convert byte array into signum representation 
          BigInteger no = new BigInteger(1, messageDigest); 

          // Convert message digest into hex value 
          String hashtext = no.toString(16); 
          while (hashtext.length() < 32) { 
              hashtext = "0" + hashtext; 
          } 
          return hashtext; 
      }  

      // For specifying wrong message digest algorithms 
      catch (NoSuchAlgorithmException e) { 
          throw new RuntimeException(e); 
      } 
  }   
}