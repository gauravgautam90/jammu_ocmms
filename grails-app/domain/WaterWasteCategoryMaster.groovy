 class WaterWasteCategoryMaster{
	Long id
	String category
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
          "$category"    
	}
    	
	static def constraints = {
		category(blank:false,unique:true)
    }
}