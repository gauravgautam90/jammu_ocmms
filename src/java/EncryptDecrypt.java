import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

 public class EncryptDecrypt {
        Cipher ecipher;
        Cipher dcipher;
       
        
    public String encrypt(String str,SecretKey key) {
            try {
            	 ecipher = Cipher.getInstance("DES");
            	 ecipher.init(Cipher.ENCRYPT_MODE, key);
                // Encode the string into bytes using utf-8
                byte[] utf8 = str.getBytes("UTF8");
    
                // Encrypt
                byte[] enc = ecipher.doFinal(utf8);
    
                // Encode bytes to base64 to get a string
                return new sun.misc.BASE64Encoder().encode(enc);
            } catch (javax.crypto.BadPaddingException e) {
            } catch (IllegalBlockSizeException e) {
            } catch (UnsupportedEncodingException e) {
            } catch (java.security.NoSuchAlgorithmException e) {
            } catch (java.security.InvalidKeyException e) {
            }catch (javax.crypto.NoSuchPaddingException e) {
            } 
            return null;
            
        }
    
        public String decrypt(String str,SecretKey key) {
            try {
            	dcipher = Cipher.getInstance("DES");
                dcipher.init(Cipher.DECRYPT_MODE, key);
                // Decode base64 to get bytes
                byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
    
                // Decrypt
                byte[] utf8 = dcipher.doFinal(dec);
    
                // Decode using utf-8
                return new String(utf8, "UTF8");
            } catch (javax.crypto.BadPaddingException e) {
            } catch (IllegalBlockSizeException e) {
            } catch (UnsupportedEncodingException e) {
            } catch (java.io.IOException e) {
            }catch (java.security.NoSuchAlgorithmException e) {
            } catch (java.security.InvalidKeyException e) {
            }catch (javax.crypto.NoSuchPaddingException e) {
            } 
            return null;
        }
        public SecretKey readKey(){
    		try{

                FileInputStream fis = new FileInputStream("resources/obj1.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
     
             
                SecretKey key = (SecretKey) ois.readObject();
               
     
                ois.close();
                return key;
    		}catch(Exception e){
    			e.printStackTrace();
    			return null;
    		}
    	}
        
        public void writeKey(SecretKey key){
    		try {
               
                FileOutputStream fos = new FileOutputStream("resources/obj1.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
     
                //
                // Create a Book instance. This book object then will be stored in
                // the file.
                //
                
     
                //
                // By using writeObject() method of the ObjectOutputStream we can
                // make the book object persistent on the books.dat file.
                //
                oos.writeObject(key);
     
                //
                // Flush and close the ObjectOutputStream.
                //
                oos.flush();
                oos.close();
                }catch (IOException e) {
                    e.printStackTrace();
                } catch(Exception e){
                	e.printStackTrace();
                }


    	}
        
             public  SecretKey generateKey() throws Exception{
    	       SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    	        return  key;
              }
              
           
          public String encryptedPassword(String pass) {
        	  SecretKey key2 = readKey();
        	String password=  encrypt(pass, key2);
			return password;
        	  
          }
          public String decryptedPassword(String pass) {
        	  SecretKey key2 = readKey();
        	String password=  decrypt(pass,key2);
			return password;
        	  
          }
    }
 
