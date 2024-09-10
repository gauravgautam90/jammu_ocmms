class AllSummaryReportWMS{
	
	Long id
	String applicationId
	String indRegMasterId
	String applicationStatus
	String scrutinyStatus
	String applicationFor
	Date pendingSince
	String pendingWith
    Date dateCreated
	Date recieptDate
	String applicationName
	String districtId  
	String districtName
	long categoryId
	String categoryName
	String roleId
	String roleName
	String groupId
	String groupName
	String officerName
	String industryTypeId
	String industryTypeName
	String industryAddress    String indCapInvt
	String indId
	String authorizationtype
	Date authDate
	boolean clarification
	String  clarificationType
	Date clarificationDate
	String clarificationReplyDate
	Date dateOfIssue
	Date dateOfExpaire
	boolean refused
	boolean returned
	Date refusedDate
	Date returnedDate
	public AllSummaryReportWMS(){
		
		clarification=false;
		clarificationType= "N/A"
		indId="N/A"
		indCapInvt="0.0"	
		refused=false;
		returned=false;	
		authorizationtype="N/A"
		clarificationReplyDate=""
			
	   }
		String toString(){
        "$id"    
     	}
	 static def constraints = {
	    	applicationId(blank:false,unique:true)
	    }

}