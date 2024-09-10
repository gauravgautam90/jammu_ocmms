/**
 * @author Robin.Soni
 *
 */
public class WasteManagementProcessingDetails{

	Long id
	Date dateCreated
	Date lastUpdated
	RoleMaster role
	String officer
	RoleMaster roleFwd
	String officerFwd
	String fileNote
	boolean clarification
	String clarificationNote
	boolean inspection
	String inspectionNote
	boolean inspectionClose
	String inspectionCloseNote
	boolean approve
	String approveNote
	boolean reject
	boolean attachedFile
	String rejectNote
	String applicationId
	String applicationFor
	boolean clarificationAttachedFile
	boolean clarificationReplyAttachedFile
	boolean inspectionAttachedFile
	boolean inspectionCloseAttachedFile
	String approvalStatus
	String clarificationDays
	boolean returned
    String returnNote
    boolean resubmitStatus
    String scrutinyStatus
	String scrutinyDescription
	String toString(){
        "$id"
         }
	static def constraints = {
      }
	
	
	public WasteManagementProcessingDetails(){
		
		approvalStatus=""
		clarificationDays="";
		scrutinyStatus = ""
		scrutinyDescription = ""
		
	}
	
	
	
	
	
	
}
