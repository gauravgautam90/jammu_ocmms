class HcfAddressFacilityBmwMaster {
	
	Long id
	String hcfFacilityName
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	
	String toString(){
          "$hcfFacilityName"    

    	}
    	static def constraints = {
      
    	}
}

