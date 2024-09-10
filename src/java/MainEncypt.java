import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MainEncypt{
	public static void main(String[]args){   
		try{
		EncryptDecrypt enc = new EncryptDecrypt();
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		MainEncypt main = new MainEncypt();
		//main.writeKey(key);
		
		//String encyptedUserId = enc.encrypt("srvcdesk",key);
		//String encyptedPassword = enc.encrypt("L0gi2008!",key);
		
		//String dbencyptedUserId = enc.encrypt("mdbadmin",key);
		//String dbencyptedPassword = enc.encrypt("mdbadm1n",key);
		
		main.writeKey(key);
		SecretKey key2 = main.readKey();
		
		String a =enc.encrypt("varun",key2);
		
		String b = enc.decrypt(a,key2);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void writeKey(SecretKey key){
		try {
           
            FileOutputStream fos = new FileOutputStream("C:\\obj1.dat");
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
	public SecretKey readKey(){
		try{

            FileInputStream fis = new FileInputStream("C:\\obj1.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            //
            // To read the Book object use the ObjectInputStream.readObject() method.
            // This method return Object type data so we need to cast it back the its
            // origin class, the Book class.
            //
            SecretKey key = (SecretKey) ois.readObject();
           
 
            ois.close();
            return key;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}