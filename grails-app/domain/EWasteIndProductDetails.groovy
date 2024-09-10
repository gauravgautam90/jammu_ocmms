/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class EWasteIndProductDetails{

	Long id
	 
	String year
	String product
	String quantity
	UnitMaster Unit
	EWaste application
	String toString(){
		"$id"
	}
	
	static mapping = {
    } 
    static def constraints = {
		
	}
	
}
