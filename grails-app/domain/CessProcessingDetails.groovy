/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class CessProcessingDetails{
	Long id
	Date dateCreated
	Date lastUpdated
	RoleMaster role
	//String role
	String officer
	RoleMaster roleFwd
	//String roleFwd
	String officerFwd
	String fileNote
	CessReturn cessreturn
	
	boolean assessmentIssue
	String assessmentIssueNote
	boolean assessmentIssueClose
	String assessmentIssueCloseNote
	boolean assessmentOrder
	String assessmentOrderNote
	boolean feeDefaulterNotice
	String feeDefaulterNoticeNote
	boolean inspection
	String inspectionNote
	boolean inspectionClose
	boolean attachedFile
	boolean inspectionAttachedFile
	boolean inspectionCloseAttachedFile
	boolean clarificationReplyAttachedFile
	String inspectionCloseNote
	boolean finish
	String finishNote
	
	
	String toString(){
        "$id"
         }
	
static def constraints = {
		
	}
}
