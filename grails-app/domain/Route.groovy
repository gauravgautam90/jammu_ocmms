/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class Route{

	String industrySize
	String industryCategory
	String office
	
	static def constraints = {
		industrySize(blank:false)
		industryCategory(blank:false)
		office(blank:false)
	}
}
