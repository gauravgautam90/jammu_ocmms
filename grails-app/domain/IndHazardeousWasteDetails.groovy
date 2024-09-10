/**
 * 
 */



/**
 * @author vinamra.mishra
 *
 */
public class IndHazardeousWasteDetails{

	Long id
	HazardeousWasteAuthApp hazardeousWasteAuthAppObj
	String hw_Type
	Long hw_Qty
	String hw_Source
	String waste_Characteristics
	String mode_Of_Storage
	String method_Of_Disposal
	Long capacity_Of_Disposal
	Long quantityDisposed
	String createdBy
	String updatedBy
	Date dateCreated
	
	String toString(){
		"$id"
	}
	static def constraints = {
		
		updatedBy(blank:true,nullable:true)
	}
	
}
