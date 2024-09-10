class DistrictMaster{
	Long id
	String districtCode
	String districtName
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
		"$districtName"
	}
	static def constraints = {
		districtName(blank:false,unique:true)
		districtCode(blank:false,unique:true)
		
		createdBy(nullable:false)
		updatedBy(nullable:false)
	}
	
}