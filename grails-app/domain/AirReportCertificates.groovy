/**
 * 
 */



/**
 * @author Chaitanya.vishwamoha
 *
 */
public class AirReportCertificates{

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
	   String idOfSample
	   String sampleType
	  
	   
	    
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
		     
	 }
	
}
