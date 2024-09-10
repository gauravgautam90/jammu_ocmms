/**
 * 
 */



/**
 * @author Uday
 *
 */
public class RawMaterialsPWM{

	Long id
	String rawMaterial
	String quantity
	UnitMaster unit
	PlasticWaste application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
	
}
