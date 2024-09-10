/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class EWasteDisposalDetails{

	Long id
	 
	String type
	String category
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
