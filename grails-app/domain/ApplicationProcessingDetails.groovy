class ApplicationProcessingDetails {
	
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
	boolean clarification
	String clarificationNote
	boolean inspection
	String inspectionNote
	boolean inspectionClose
	String inspectionCloseNote
	boolean approve
	String approveNote
	boolean reject
	String rejectNote
	boolean attachedFile
	boolean clarificationAttachedFile
	boolean clarificationReplyAttachedFile
	boolean inspectionAttachedFile
	boolean inspectionCloseAttachedFile
	IndApplicationDetails application
	boolean returned
	String returnNote
	boolean resubmitStatus
	String scrutinyStatus  // Added by depak for scrutiny 
	String scrutinyDescription // 
	String approvalStatus 
	
	 public ApplicationProcessingDetails(){
		
		
		scrutinyStatus = ""
		scrutinyDescription = ""
			
}
	String toString(){
        "$id"
         }
	static def constraints = {
      }
	static mapping = {
		resubmitStatus defaultValue:false
		returned defaultValue:false
		returnNote defaultValue:"''"		}
	
}
