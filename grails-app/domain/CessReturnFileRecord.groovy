/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class CessReturnFileRecord{

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
	   CessReturn cessReturn
	  // String month
	  // String year
	  Date cessAppliedFromDate
	  Date cessAppliedToDate
	    
	   static constraints = {
		     data( nullable: false, minSize: 1)
		     name( nullable: false, blank: false )
		     description( nullable: false, blank: false )
		     size( nullable: false )
		     extension( nullable: false )
		     createdBy(blank:false)
		     updatedBy(blank:false)
		     typeOfFile(blank:false)
		     indreg(nullable: false,blank:false)
		     cessReturn(nullable: false,blank:false)
	
}
	
}
