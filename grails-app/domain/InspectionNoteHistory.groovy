/**
 * 
 */



/**
 * @author Ashish
 *
 */
public class InspectionNoteHistory{

	Long id
	IndApplicationDetails application
	RoleMaster role
	RoleMaster roleFwd
	String officer
	String officerFwd
	String inspectionNote
	String inspectionDescriptionNote                 // for inspection note(Description)
	String fileNote                            // for clarification
	String noticeType                          // for clarification
	boolean clarification                      // for clarification
	String clarificationNote                   // for clarification
	String clarificationDays   				   // for clarification
	boolean clarificationAttachedFile          // for clarification
	boolean clarificationReplyAttachedFile     // for clarification
	boolean approve                            // for close after Approve
	String approveNote						   // for Approve	Note
	boolean reject                             // for Close after Refused    
	String rejectNote                          // for Refused  Note
	String approvalStatus                      // for Approved/Refused
	String revokeNote                          // for Revoke Activity
	boolean revoke                             // for Revoke Activity
	String closeIndNote                        // for closeInd Activity
	boolean closeInd                           // for closeInd Activity
	String revokeCloseIndNote                  // for revoke closeInd Activity
	boolean revokeCloseInd                     // for revoke closeInd Activity
	Date dateCreated
	Date lastUpdated
	boolean applicationClosed
	String typeOfInspection // Regular Inspection OR Fresh Inspection  

	boolean previousReportAttachedFile
	
	
}
