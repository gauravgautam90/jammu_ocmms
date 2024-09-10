/**
 * 
 */



/**
 * @author Uday
 *
 */
public class RoutePlasticWasteManagement{



	public boolean routePlasticWasteManagementApp(Long applicationId,String applicationFor,IndustryRegMaster indregInstance){
		println("route waste bmw")
		println("Checking routin")
		println("Checking indregInstance-----------"+indregInstance)
		println("Checking indregInstance-----------"+indregInstance.id)
		def routed = false
//		def office=OfficeMaster.findByPriority(1)
		def office=OfficeMaster.findByPriority(1)
		def groupName=applicationFor
		def IndustryRegMasterObj=  IndustryRegMaster.get((indregInstance.id).toLong())
		def districtttt = IndustryRegMasterObj.district.id
		println("Checking IndustryRegMasterObj-----------"+IndustryRegMasterObj)
		println("Checking districtttt-----------"+districtttt)
		println("Checking office-----------"+office)
		println("Checking office11111111-----------"+office.getClass().getName())
		//def groupPresent=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc=? and gm.office=? ",[groupName,offIns])
		def groupPresent
		def grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(districtttt))
		System.out.println("grpList "+grpList)
		System.out.println("group size "+grpList.size())
		for(int i=0;i<grpList.size();i++){
			System.out.println("i "+i)
			System.out.println("office "+((grpList.get(i)).group).office)
			println(" office11111111-----------"+(((grpList.get(i)).group).office).getClass().getName())
			System.out.println("group111111111 "+(grpList.get(i)).group)
			
		//	def office1 = OfficeMaster.findByPriority(office.toInteger())
				
				
		//		System.out.println("office "+office1)
			
			
			if(((grpList.get(i)).group).office.id == office.id){
				System.out.println("group "+(grpList.get(i)).group)
				groupPresent = (grpList.get(i)).group
			}
		}
		def applicationIdLong=applicationId
		def objectType 
		
		System.out.println("office : "+office);
		System.out.println("groupName : "+groupName);
		System.out.println("groupPresent : "+groupPresent);
		
		if(groupName=="HWM"){
			objectType=HazardeousWasteAuthApp.get(applicationIdLong)
		}else if(groupName=="BMW"){
			objectType=BioMedicalWaste.get(applicationIdLong)
		}else if(groupName=="PWM"){
			objectType=PlasticWaste.get(applicationIdLong)
		}else {
			objectType=MunicipalSolidWaste.get(applicationIdLong)
		}
		System.out.println("objectType : "+objectType)
		if(!groupPresent){
			System.out.println("Group not Present");
			def wasteManagementUnattendedApplication=new WasteManagementUnattendedApplication()
			wasteManagementUnattendedApplication.applicationId=applicationId+""
			wasteManagementUnattendedApplication.applicationFor=applicationFor
			wasteManagementUnattendedApplication.routedStatus="unattended"
				
			
			
			wasteManagementUnattendedApplication.save()
			println("1111")
			objectType.applicationStatus="unattended"
				objectType.save()
		}else {
			def group=groupPresent

			println("Group is present")
			def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
			System.out.println("roleVsActlist  "+roleVsActList)
			System.out.println("roleVsActlist size "+roleVsActList.size())
			for(int i=0;i<roleVsActList.size();i++){
				println("roleVsActList Group is present"+((roleVsActList.get(i)).role).group)
				if(((roleVsActList.get(i)).role).group.id == group.id){
					def applicationProcessingDetails = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails indPower where indPower.applicationId=? order by indPower.id desc",[applicationId.toString()])
					if(applicationProcessingDetails){
					if(applicationProcessingDetails.returned==true && applicationProcessingDetails.resubmitStatus==false){
					applicationProcessingDetails.resubmitStatus = true
					applicationProcessingDetails.save(flush:true)
					}
					}
					def appPendDetails
					appPendDetails = WasteManagementPendingDetails.find("from WasteManagementPendingDetails indPower where indPower.applicationId=? order by indPower.id desc",[applicationId.toString()])
					println("appPendDetails "+appPendDetails)
					if(appPendDetails==null){
						
						
						appPendDetails = new WasteManagementPendingDetails()
						appPendDetails.applicationId = applicationId+""
					}
					
					appPendDetails.applicationFor = groupName
					appPendDetails.applicationStatus ="pending"
					appPendDetails.indRegInstance =indregInstance
					//appPendDetails.bookNo=""
						//appPendDetails.completionDate=new Date()
					appPendDetails.completionStatus=""
						//appPendDetails.recieptDate= new Date()
					//appPendDetails.recieptNo=""
						appPendDetails.scrutinyStatus=""
				
					
					println("varun..."+(roleVsActList.get(i)).role)
					println("varun 2..."+RoleProfileAssignment.findByRole((roleVsActList.get(i)).role))
					println("varun 3... "+UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee))
				
					appPendDetails.role = (roleVsActList.get(i)).role
					appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
					
					if(appPendDetails.save(flush:true)){
						routed = true
						objectType.applicationStatus="Inprogress"
							objectType.save()
						System.out.println("application routed")
					}else{
						appPendDetails.errors.each {
		    		        println it
		    		   }
		    		}
				
					
				}else{
					
				}
				
			}
			if(!routed){
				def wasteManagementUnattendedApplication=new WasteManagementUnattendedApplication()
				wasteManagementUnattendedApplication.applicationId=applicationId+""
				wasteManagementUnattendedApplication.applicationFor=applicationFor
				wasteManagementUnattendedApplication.routedStatus="unattended"
				wasteManagementUnattendedApplication.save()
				println("222222")
				objectType.applicationStatus="unattended"
				objectType.save()
				
			}
			return routed
		
		}
		
	}
	

	
}
