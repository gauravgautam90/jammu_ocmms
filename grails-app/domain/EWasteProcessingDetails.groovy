/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class EWasteProcessingDetails{

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
String noticeType
	boolean reject
	boolean attachedFile
	String inspectionDays
	String clarificationDays;
	String rejectNote
	String applicationId
	String applicationFor
	boolean clarificationAttachedFile
	boolean clarificationReplyAttachedFile
	boolean inspectionAttachedFile
	boolean inspectionCloseAttachedFile
	boolean returned
    String returnNote
    boolean resubmitStatus
    
	String toString(){
        "$id"
         }
	static def constraints = {
      }
	static mapping = {
		resubmitStatus defaultValue:false
		returned defaultValue:false
		returnNote defaultValue:"''"		
}
}
