public class UploadCertificateBMW{
	
	Long id
	BioMedicalWaste applicationId
	Date startDate
	Date endDate

 	String createdBy
 	Date lastUpdated
 	String updatedBy
 	
 	
 	String refData
 	String referenceNo
 	Date referenceDate
 	
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