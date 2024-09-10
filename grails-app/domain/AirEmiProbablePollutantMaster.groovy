class AirEmiProbablePollutantMaster{
	
	Long id
	String pollutant
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$pollutant"    
	}
    	
	static def constraints = {
		pollutant(blank:false,unique:true)
    }
	
	
}
