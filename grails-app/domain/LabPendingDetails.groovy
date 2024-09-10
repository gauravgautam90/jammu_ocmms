/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class LabPendingDetails{
	Long id
	SampleHandover sample
	String idOfSample
	String sampleType
	String applicationStatus
	UserMaster pendingWith
	RoleMaster role
	Date dateCreated
 	Date lastUpdated
	
	String toString(){
		"$id"
	}
	static def constraints = {
		
	}
	
	
}
