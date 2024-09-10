/**
 * 
 */



/**
 * @author Mittali
 *
 */
public class RevokeRecordCertificate{
	
	Long id
	IndApplicationDetails applicationId
	Date dateCreated
 	String createdBy
 	//Date lastUpdated
 	String updatedBy
  	String details
 	String certiFor
 	String recieptNo
 	String toString(){
	    "CerificateRecord"
		}
	    static def constraints = {	
	    	applicationId(blank:false)
	    	createdBy(nullable:false)
	    	updatedBy(nullable:false)
	    	
	    }
	
	
}
