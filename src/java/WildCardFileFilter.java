import java.io.*;
import java.util.regex.*;
 
public class WildCardFileFilter implements FileFilter
{
    private String _pattern = "";
 
    public WildCardFileFilter(String pattern)
    {
        _pattern = pattern.replace("*", ".*").replace("?", ".");
    }
    public WildCardFileFilter()
    {
        
    }
 
    public boolean accept(File file)
    {
	return Pattern.compile(_pattern).matcher(file.getName()).find();
    }
    
    public String getFile(String directory,String fileName){
    	try{
    		
        	File dir = new File(directory);
        	String fileLoc = fileName+"*";
        	File[] files = dir.listFiles(new WildCardFileFilter(fileLoc));
        	/* 
        	for (File file : files)
        	  */
        	
        	return files[0].getAbsolutePath();
    	}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
    	
    	//return files[0];
    }
    
    public static void main(String[] args){
    	File dir = new File("SPCB_DOCUMENTS");
    	File[] files = dir.listFiles(new WildCardFileFilter("Process Flow Chart*"));
    	 
    	for (File file : files)
    	    System.out.println(file.getName());
    }
}