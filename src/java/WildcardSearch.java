import java.io.*;
import java.util.regex.*;

 
public class WildcardSearch
{
	private static String sWild = "";
 
 
	/**
	 * @param args - arg[0] = directory to search, arg[1] = wildcard name
	 */
	public static void main(String [] args){
		WildcardSearch a = new WildcardSearch();
		a.my("SPCB_DOCUMENTS","Process Flow Chart*");
	}
	public void my(String args,String argss)
	{
		String sExtDir = args; // directory to search
		sWild = argss;   // wild card to use - example: s??t*.ini
		sWild = replaceWildcards(sWild);
	
		File fileDir = new File(sExtDir);
		File[] arrFile = fileDir.listFiles(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				return (name.toLowerCase().matches(sWild));
			}
		});
		
		for (int i = 0; i < arrFile.length; ++i)
		{
			
		}
	}	// end main
	
	
	/**
	 * Checks for * and ? in the wildcard variable and replaces them correct
	 * pattern characters.
	 * 
	 * @param wild - Wildcard name containing * and ?
	 * @return - String containing modified wildcard name
	 */
	private String replaceWildcards(String wild)
	{
	    StringBuffer buffer = new StringBuffer();
	 
	    char [] chars = wild.toCharArray();
	 
	    for (int i = 0; i < chars.length; ++i)
	    {
	        if (chars[i] == '*')
	            buffer.append(".*");
	        else if (chars[i] == '?')
	            buffer.append(".");
	        else if ("+()^$.{}[]|\\".indexOf(chars[i]) != -1)
	            buffer.append('\\').append(chars[i]);
	        else
	            buffer.append(chars[i]);
	    }
	 
	    return buffer.toString();
	 
	}// end replaceWildcards method

}	// end class
