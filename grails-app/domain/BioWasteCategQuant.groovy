/**
 * 
 */



/**
 * @author Chaitanya.vishwamoha
 *
 */
public class BioWasteCategQuant{

	Long id
	BioMedicalWaste bioMedicalWasteObj
	String category
	int quantity
	String method
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	String toString(){
		"$id"
	}
	/*static def constraints = {
	
	}*/
		
	 static constraints = {
		 bioMedicalWasteObj(nullable: true,blank:true)
	   }
}
