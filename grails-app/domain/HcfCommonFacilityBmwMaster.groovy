class HcfCommonFacilityBmwMaster {
	
	Long id
	String hcfCommonFacilityName
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	
	String toString(){
          "$hcfCommonFacilityName"    

    	}
    	static def constraints = {
      
    	}
}

