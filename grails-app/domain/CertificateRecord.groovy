/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class CertificateRecord{

	Long id
	IndApplicationDetails applicationId
	Date startDate
	Date endDate
	Date dateCreated
 	String createdBy
 	Date lastUpdated
 	String updatedBy
 	String generalCondition
 	String specificCondition
 	String subjectData
 	String refData
 	
 	String toString(){
	    "CerificateRecord"
		}
	    static def constraints = {	
	    	applicationId(blank:false)
	    	startDate(blank:false)
	    	endDate(blank:false )
	    	createdBy(nullable:false)
	    	updatedBy(nullable:false)
	    	
	    }
	
	
}
