
public class RecordCertificateHWM{
	
	Long id
	HazardeousWasteAuthApp application
	String copyTo
	Date dateCreated
	Date issueDate
	Date expiryDate
 	String termsConditions
 	String address
 	String authorizationNo
 	String name
 	
 	String office
 	String officerName
 	String officerDes
 	String valid
	
/////s.no.
 	
 	Long certNo
 	String typeOfOfficer
 	String RegionalOffice
 	String year
 	//////
	
 	public RecordCertificateHWM(){
		 certNo= 0;
	 	 typeOfOfficer = "";
	 	 RegionalOffice = "";
	 	year = "";
	 	valid="";
	}
 	
 	
 	String toString(){
	    "$id"
		}
	    static def constraints = {	
	   
	    	
	    }
	
	
}
