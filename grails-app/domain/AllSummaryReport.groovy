class AllSummaryReport{
	
	Long id
	String applicationId
	String indRegMasterId
	String applicationName
	String groupId
	String groupName
	String districtId    // DistrictOfficeMaster 
	String districtName
	String roleId
	String roleName
	String officerName
	String applicationType
	String applicationFor
	String certificateFor
	String applicationStatus
	Date pendingSince
	String pendingWith
	Date applicationRecieptDate
	
//	 add some new field
	String indTypeId
	String indTypeName
	String indCategoryId
	String indCategoryName
///// add field for home page report
	String lastClarificationDate
	String lastForward
	//// added field for dashboard
	String indAddress
	Date clarificationRaiseDt
	Date clarificationSubmitDt
	Date dateOfIssue
	Date dateOfexpiry
	String indId
	String occEmail
	String occMobile
	
	AllSummaryReport(){
		indAddress="";
		indId = "";
		occEmail="";
		occMobile="";
	}
	
	String toString(){
          "$id"    
	}
    
    static def constraints = {
    	applicationId(blank:false,unique:true)
    }
    
    static mapping = {
    	
    }
}