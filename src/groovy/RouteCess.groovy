/**
 * 
 */



/**
 * @author robin.soni
 *
 */
public class RouteCess{

	public boolean routeCessApp(CessReturn cessInstance){
		
		def routed = false
		def offIns=OfficeMaster.findByPriority(1)
		def groupCess=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc='CESS'and gm.office=? ",[offIns])
		if(!groupCess){
			def CessUnattendedInstance=new CessUnattendedApplication()
			CessUnattendedInstance.cessReturn=cessInstance		
			CessUnattendedInstance.cessAppliedFromDate=cessInstance.cessAppliedFromDate
			CessUnattendedInstance.cessAppliedToDate=cessInstance.cessAppliedToDate
			CessUnattendedInstance.routedStatus="unattended"
			CessUnattendedInstance.indRegInstance=cessInstance.industryReg
			if(CessUnattendedInstance.save(flush:true)){
				routed = true
			}else{
				CessUnattendedInstance.errors.each {
		       }
			}
			cessInstance.applicationStatus="unattended"
				cessInstance.save()
			return routed
			}else{
				def group=groupCess[0]
				def roleVsActList = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("001"))
				if(roleVsActList){
					for(int i=0;i<roleVsActList.size();i++){
						if(((roleVsActList.get(i)).role).group == group){
							def cessPendDetails = new CessPendingDetails()
							cessPendDetails.indRegInstance=cessInstance.industryReg
							cessPendDetails.cessReturn = cessInstance
							cessPendDetails.applicationStatus = "pending"
							cessPendDetails.role = (roleVsActList.get(i)).role
							cessPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
							cessPendDetails.cessAppliedFromDate=cessInstance.cessAppliedFromDate
							cessPendDetails.cessAppliedToDate=cessInstance.cessAppliedToDate
							if(cessPendDetails.save(flush:true)){
								routed = true
							}else{
								cessPendDetails.errors.each {
								}
							}
						}else{
							if(!routed){
							}
						}
					}
					return routed
				}else{
					def CessUnattendedInstance=new CessUnattendedApplication()
					CessUnattendedInstance.cessReturn=cessInstance		
					CessUnattendedInstance.cessAppliedFromDate=cessInstance.cessAppliedFromDate
					CessUnattendedInstance.cessAppliedToDate=cessInstance.cessAppliedToDate
					CessUnattendedInstance.routedStatus="unattended"
					CessUnattendedInstance.indRegInstance=cessInstance.industryReg
					if(CessUnattendedInstance.save(flush:true)){
						routed = true
					}else{
						CessUnattendedInstance.errors.each {
						}
					}
					cessInstance.applicationStatus="unattended"
						cessInstance.save()
				}
			}
	
	}
}
