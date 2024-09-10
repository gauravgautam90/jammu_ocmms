/**
 * 
 */



/**
 * @author Shashank srivastava
 *
 */
public class ReopenApplicationRecord{

	Long id
	IndApplicationDetails application	
	UserMaster loggedInUserName
	Date dateCreated
	Date lastUpdated
	UserMaster lastPendingWithId
	RoleMaster lastPendingWithRole
	String ipAddress
	String reasonForReopen
	boolean appReopenStatus
	String otp
	Date dateOfReopen
	boolean docAttached
	
	
	ReopenApplicationRecord(){
			appReopenStatus=false;
			reasonForReopen="" 
			docAttached = false
			dateCreated = new Date()
			lastUpdated = new Date()
			dateOfReopen = new Date()
			ipAddress = ""
			otp = ""
	}
	
	String toString(){
		"$id"
	}
	
    static constraints = {
		
		
    }
	
	
}
