class AirEmiControlMeasureMaster{
		
	Long id
	String controlMeasure
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$controlMeasure"    
	}
    	
	static def constraints = {
		controlMeasure(blank:false,unique:true)
    }
	
	
}
