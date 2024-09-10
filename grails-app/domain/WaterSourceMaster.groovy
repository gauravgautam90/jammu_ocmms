class WaterSourceMaster{
	
	Long id
	String sourceName
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$sourceName"    
	}
    	
	static def constraints = {
		sourceName(blank:false,unique:true)
    }
}