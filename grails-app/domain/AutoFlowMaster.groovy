class AutoFlowMaster {
	Long id
	RoleMaster canForwardTo
	RoleMaster role
	GroupMaster group
	
	String toString(){
		"autoflow ID($id) Group($group)"
	}
	static def constrains = {	
	}
	
	static belongsTo = [role:RoleMaster,group:GroupMaster,canForwardTo:RoleMaster]
    static mapping = {
           //id generator:'assigned'
               role lazy : false
               group lazy : false
               canForwardTo lazy : false
       }
}
