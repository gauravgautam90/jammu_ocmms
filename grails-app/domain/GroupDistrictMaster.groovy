class GroupDistrictMaster {
	
	Long id
    DistrictMaster district
    GroupMaster group
    String toString(){
		"($district)"
    }
    static def constraints = {
    	district(blank:false,unique:'group')
    	group(blank:false)
      
    }
}

