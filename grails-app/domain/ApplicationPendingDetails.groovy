class ApplicationPendingDetails{
	Long id
	IndApplicationDetails application
	String applicationStatus
	UserMaster pendingWith
	RoleMaster role
	
	Date completionDate
	
	String scrutinyStatus // added by deepak for scrutiny
	String completionStatus
	
	public ApplicationPendingDetails()
	{
		completionDate= new Date()
		scrutinyStatus = ""
	    completionStatus = ""
	}
	
	String toString(){
		"$id"
	}
	static def constrains = {
		
	}
}