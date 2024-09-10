
public class DocumentChecklistMaster{

	Long id
	String consentFor
	String applicationFor
	String documentType
	String document
	Date dateCreated
 	String createdBy
 	Date lastUpdated
 	String updatedBy
 	String isMandatory    
	String toString(){
	    "$document"
		}
	    static def constraints = {	
	    	consentFor(blank:false)
	    	applicationFor(blank:false)
	    	document(blank:false)
	    	documentType(blank:false)
	    	createdBy(nullable:false)
	    	updatedBy(nullable:false)
	    	isMandatory(nullable:false)
	    	
	    }
	

	
	
}

	
	

