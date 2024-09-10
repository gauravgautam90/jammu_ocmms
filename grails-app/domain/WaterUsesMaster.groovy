class WaterUsesMaster{
	
	Long id
	String useType
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$useType"    
	}
    	
	static def constraints = {
		useType(blank:false,unique:true)
    }
}