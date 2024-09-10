public class HWMPreviousAuthorisationDetails{

	Long id
	String application
	IndustryRegMaster indUser
	String HWApplication_Date
	String HWAType
	String AuthorisationNo
	String Issued_date
	String Valid_date
	String wasteManagementFileId
	
	String toString(){
	    "$id"
		}
	    static def constraints = {	
	    	
	    }
}