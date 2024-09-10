/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class EWasteManagementFile{

	 Long id
	   byte[] data
	   String name
	   String description
	   int size
	   String extension
	   Date dateCreated
	   Date lastUpdated
	   String createdBy
	   String updatedBy
	   String typeOfFile
	   IndustryRegMaster indreg
	   Long applicationId
	   String applicationFor
	   
	    
	   static constraints = {
		     data( nullable: false, minSize: 1)
		     name( nullable: false, blank: false )
		     description( nullable: false, blank: false )
		     size( nullable: false )
		     extension( nullable: false )
		     createdBy(blank:false)
		     updatedBy(blank:true,nullable:true)
		     lastUpdated(blank:true,nullable:true)
		     typeOfFile(blank:false)
		     indreg(nullable: false,blank:false)
		     applicationFor(nullable: false,blank:false)
	 }
	
}
