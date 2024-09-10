class RoleMaster {
	Long id
	String roleName
	String roleDesc
	GroupMaster group
 	Date dateCreated
 	String createdBy
 	Date lastUpdated
 	String updatedBy
 	String eeRecommendation
 	String returnPower
 	
//  for inspection module
 	String typeoff 
 	long forwardCount
 	boolean canDoInspection
 	
  	String toString(){
    "$roleName"
	}
    static def constraints = {	
    	group(nullable:false)
    	roleName(blank:false,unique:'group')
    	createdBy(nullable:false)
    	updatedBy(nullable:false)
    	
    }
}