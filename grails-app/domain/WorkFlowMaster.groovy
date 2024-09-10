class WorkFlowMaster {
	Long id
	RoleMaster canForwardTo
	RoleMaster role
	GroupMaster group
	
	String toString(){
		"workflow ID($id) Group($group)"
	}
	static def constrains = {	
	}
}
