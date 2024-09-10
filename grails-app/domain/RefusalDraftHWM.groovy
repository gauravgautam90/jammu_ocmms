
public class RefusalDraftHWM {
	
	Long id
	HazardeousWasteAuthApp applicationId
	String authNumber
	Date dateCreated
	String officername
	String officerdesig
	String copyTo
	String refNo
	Date draftLetterDate
	String termsConditions
	String industryName
	String industryAddress
	String toString(){
	    "DraftRefusal"
		}
	    static def constraints = {	
	    	applicationId(blank:false)
	    		    	
	    }
	
}
