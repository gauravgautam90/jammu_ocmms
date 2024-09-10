import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class TempFile {
  public File testMethod (){
    File tempFile = null;
    
    try {
      tempFile = File.createTempFile("MyFile.txt", ".tmp" );
      
      FileOutputStream fop=new FileOutputStream(tempFile);

      if(tempFile.exists()){
      String str="This data is written through the program";
          fop.write(str.getBytes());

          fop.flush();
          fop.close();
          }
      
      } catch (IOException ex) {

 
      } finally {
        if (tempFile != null) {
        }
      }
      return tempFile;
    }
}
