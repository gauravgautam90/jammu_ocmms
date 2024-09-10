
public class RecordCertificateBMW{
	
	Long id
	BioMedicalWaste application
	Date issueDate
	Date expiryDate
	String letterNo
	String letterFor
	String termsco
	String authPeriod
 //	String specialCondition
 	String copyTo
 	String subject
 	String authorizationNo
 	String offname
 	String officername
 	String offdesg
 	String draftLetterFor
 	String offAddres
 	String authorizationFor
	String facility
	String serviceProvider
	String collected
	String authCancelled
	String name
	String nameind
	String address
	
	
/////s.no.
 	
 	Long certNo
 	String typeOfOfficer
 	String RegionalOffice
 	String year
 	//////
	
 	public RecordCertificateBMW(){
		 certNo= 0;
	 	 typeOfOfficer = "";
	 	 RegionalOffice = "";
	 	 year = "";
	 	collected="";
	 	facility="";
	 	authCancelled="";
	 	serviceProvider=""
	 		offname=""
	 			letterNo=""
	 				copyTo=""
	}
 	
 	
 	String toString(){
	    "$id"
		}
	    static def constraints = {	
	   
	    	
	    }
	
	
}
