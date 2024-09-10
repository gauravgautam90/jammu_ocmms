class EffluentTypeMaster {
	Long id
	String effluentType
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
    String toString(){
        "$effluentType"    
    }
    static def constrains = {
    	effluentType(blank:false,unique:true)
    }
}