/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class ApplicationFileRecord{



	//	 private static final int FIVE_MEG_IN_BYTES = 1024*1024*5
		
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
		   IndApplicationDetails indApplication
		   String appProcessId
		   
		   
		   public ApplicationFileRecord()
				{
			 appProcessId = ""	
		   
				}
		   
		   static constraints = {
			   //  data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
			     data( nullable: false, minSize: 1)
			     name( nullable: false, blank: false )
			     description( nullable: false, blank: false )
			     size( nullable: false,maxSize: 2 )
			     extension( nullable: false )
			     createdBy(blank:false)
			     updatedBy(blank:false)
			     typeOfFile(blank:false)
			     indApplication(nullable: false,blank:false)
			   }
		
	
	
}
