class EffluentDisposalModeMaster{
	Long id
	String disposalMode
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
    String toString(){
        "$disposalMode"    
    }
    static def constrains = {
    	disposalMode(blank:false,unique:true)
    }
	
	
}
