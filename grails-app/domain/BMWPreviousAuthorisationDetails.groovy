public class BMWPreviousAuthorisationDetails{

	Long id
	String application
	IndustryRegMaster indUser
	String BMWApplication_Date
	String BMWAType
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