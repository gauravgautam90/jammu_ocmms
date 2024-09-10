/**
 * 
 */



/**
 * @author robin.soni
 *
 */
public class RecordCertificate{
	
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
 	String maxQuantity
 	String copyTo
 	
 	String wasteWater
 	String capInvest
 	String waterConsume
 	String sewageEffluent
 	String specificConditionsforAuth
 	String typeofCertificate
 	
 	public RecordCertificate()
	{
		typeofCertificate="Prepared"
	}
 	
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
