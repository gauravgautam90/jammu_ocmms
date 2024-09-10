class NewUser{
	Long id
	String name
	String mobile
	
	String userId
	Date dateCreated
	Date lastUpdated
	
	boolean regUpdated
	String registrationFor
	String password
	String passwordEncrypt
	
	Long regId
	String category
	String industryType
	String categoryId
	String industryTypeId
	String indScale
	String indScaleId
	String address
	
	String district
	String districtId
	public NewUser(){
		
		dateCreated = new Date();
		lastUpdated = new Date();
		regUpdated = false;
		registrationFor = "industry"
		categoryId = ""
		indScaleId = ""
		regId = 0
		district = ""
		districtId = ""
		
	}
	
	
	
	String toString(){
		"$id"
	}
	static def constraints = {
		
	}
}