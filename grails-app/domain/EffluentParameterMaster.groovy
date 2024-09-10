class EffluentParameterMaster{
	Long id
	String parameter
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
    String toString(){
        "$parameter"    
    }
    static def constrains = {
    	parameter(blank:false,unique:true)
    }
}