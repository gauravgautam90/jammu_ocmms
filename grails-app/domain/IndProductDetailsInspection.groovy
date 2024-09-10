/**
 * 
 */



/**
 * @author Richa
 *
 */
public class IndProductDetailsInspection{
	Long id
	String product
	String quantity
	UnitMaster unit
	String byProduct
	UnitMaster unitbyProduct
	String rawMaterials
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}
