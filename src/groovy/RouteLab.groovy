/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class RouteLab{

	
	public boolean routeLabApp(SampleHandover sample){
		
		def routed = false
		def labIdentification=sample.groupMasterInstance
		def sampleId=sample.sampleId+""
		def sampleType=sample.sampleType
			
		if(!labIdentification){
			
			return routed
			}else{
				def group=labIdentification
				def roleVsActList = LabRoleVsActivity.findAllByLabActivity(LabActivityMaster.findByActivityCode("001"))
				if(roleVsActList){
					for(int i=0;i<roleVsActList.size();i++){
						if(((roleVsActList.get(i)).role).group == group){
							def labPendDetails = new LabPendingDetails()
							
							labPendDetails.sample = sample
							labPendDetails.applicationStatus = "pending"
							labPendDetails.role = (roleVsActList.get(i)).role
							labPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
							labPendDetails.idOfSample=sampleId
							labPendDetails.sampleType=sampleType
							if(labPendDetails.save(flush:true)){
								routed = true
							}else{
								labPendDetails.errors.each {
								}
							}
						}else{
							if(!routed){
							}
						}
					}
					return routed
				}else{
					
				}
			}
	
	}
}
