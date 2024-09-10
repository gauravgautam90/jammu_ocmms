class UserProfile {
	String id                  // this is Employee id
	String employeeFirstName
	String employeeLastName
	String designation
	String department
	String email
	String officePhone
	String mobile
	String status
	Date dateCreated
	String createdBy
	
	Date lastUpdated
	String toString(){
		"$employeeFirstName($id)"
	}
	static mapping = {
		id generator:'assigned'
	}
    static def constraints = {
		id(unique:true)
		employeeFirstName(blank:false)
		employeeLastName(blank:false)
		designation(blank:false)
		department(blank:false)
		email(blank:false,email:true)
		officePhone(blank:false)
		mobile(blank:false ,size:8..15)
		status(blank:false)
		
		
    }
}
