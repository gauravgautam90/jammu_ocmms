class MyAudit {
	
	String userID
	String ipAddress
	Date loginDate
	Date logoutDate
	String loginStatus
	String userType
	String reason

    static constraints = {
		logoutDate(nullable:true)
		
    }
	
}
