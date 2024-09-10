/**
 * 
 */



/**
 * @author vinamra.mishra
 *
 */
public class IndHWProductDetails{

	Long id
	HazardeousWasteAuthApp hazardeousWasteAuthAppObj
	String product_Name
	Long product_Qty
	String by_Product_Name
	Long by_Product_Qty
	String raw_Material_Name
	Long raw_Material_Qty
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated

	String toString(){
		"$id"
	}
	
	static def constraints = {
		
		updatedBy(blank:true,nullable:true)
		lastUpdated(blank:true,nullable:true)
	}
}
