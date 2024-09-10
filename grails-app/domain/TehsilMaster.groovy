class TehsilMaster{
	Long id
	String tehsilName
	DistrictMaster district
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	String toString(){
		"$tehsilName"
	}
	static def constraints = {
		
		tehsilName(blank:false,unique:'district')
		district(blank:false)
		createdBy(nullable:false)
    	updatedBy(nullable:false)
		
	}
}