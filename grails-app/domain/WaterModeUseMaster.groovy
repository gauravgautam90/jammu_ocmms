class WaterModeUseMaster{
	
	Long id
	String modeUsage
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$modeUsage"    
	}
    	
	static def constraints = {
		modeUsage(blank:false,unique:true)
    }
}