class EffluentMeasureStandardMaster{
	Long id
	String measureStandard
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
    String toString(){
        "$measureStandard"    
    }
    static def constraints = {
    	measureStandard(blank:false,unique:true)
    }
	
	
}
