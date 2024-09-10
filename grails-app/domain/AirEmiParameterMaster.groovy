class AirEmiParameterMaster{
	Long id
	String parameter
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$parameter"    
	}
    	
	static def constraints = {
		parameter(blank:false)
		createdBy(nullable:false)
		updatedBy(nullable:false)
    }
	
	
}
