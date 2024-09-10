class ActivityRecord {
	
	Long id
	String userType
	String userID
	String ipAddress
	Date dateCreated
	String activity
	String status
	
	public ActivityRecord(){
		dateCreated = new Date()
		ipAddress = ""
		userType = ""
		userID = ""	
		activity = ""
		status = ""
	}
	
    static constraints = {
		
		
    }
	
}
