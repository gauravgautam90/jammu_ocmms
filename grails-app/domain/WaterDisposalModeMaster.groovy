class WaterDisposalModeMaster{
	
	Long id
	String disposalMode
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$disposalMode"    
	}
    	
	static def constraints = {
		disposalMode(blank:false,unique:true)
    }
}