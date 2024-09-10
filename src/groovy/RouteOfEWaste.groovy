public class RouteOfEWaste{

	public boolean routeWasteManagementApp(Long applicationId,String applicationFor,IndustryRegMaster indregInstance){
		println("Checking-routin--")
		def routed = false
		def offIns=OfficeMaster.findByPriority(1)
		def groupName=applicationFor
		//def groupPresent=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc=? and gm.office=? ",[groupName,offIns])

		def applicationIdLong=applicationId
		def objectType 
		def grp = new GroupMaster()
		def grpList
		
		System.out.println("offIns : "+offIns);
		System.out.println("groupName : "+groupName);
		//System.out.println("indregInstance : "+indregInstance.district);
		
		
			System.out.println("applicationIdLong : "+applicationIdLong);
			objectType=EWaste.findById(applicationIdLong)
			
			System.out.println("objectType : "+indregInstance);
//////////	/ Ashish Code Starts //////////
			def locationId = indregInstance.district.id
			
			System.out.println("locationId : "+locationId);
			System.out.println("groupName : "+groupName);
			//Satish commented-----
			//grpList = GroupDistrictMaster.findAll("from GroupDistrictMaster where district.id=? and group.groupDesc='EWaste'",[locationId.toLong()])
			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
			
			System.out.println("group size "+grpList.group.groupName)
			for(int i=0;i<grpList.size();i++){
				System.out.println("i "+i)
				System.out.println("office "+((grpList.get(i)).group).office)
				
				if(((grpList.get(i)).group).office == offIns){
					System.out.println("group "+(grpList.get(i)).group)
					grp = (grpList.get(i)).group
				}
		
			System.out.println("F Group "+grp)
			
			//////////////// Ashish Code Ends ////////////
		}
		System.out.println("objectType saroj : "+objectType)
		if(!grpList){
			System.out.println("Group not Present");
			def EWasteManagementUnattendedApplication=new EWasteManagementUnattendedApplication()
			EWasteManagementUnattendedApplication.applicationId=applicationId+""
			EWasteManagementUnattendedApplication.applicationFor=applicationFor
			EWasteManagementUnattendedApplication.routedStatus="unattended"
			EWasteManagementUnattendedApplication.save()
			println("1111")
			objectType.applicationStatus="unattended"
			objectType.dateCreated= new Date()
			objectType.save()
		}else {
			//def group=groupPresent[0]

			println("Group is present")
          
			// Satish commented-----
		    // def roleVsActList = EWasteRoleVsActivity.findAllByActivity(EWasteActivityMaster.findByActivityCode("001"))
			def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
			
			
			
			System.out.println("roleVsActlist size "+roleVsActList.size())
			
			for(int i=0;i<roleVsActList.size();i++){
				if(((roleVsActList.get(i)).role).group == grp){
					def appPendDetails
					appPendDetails = EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails indPower where indPower.applicationId=? order by indPower.id desc",[applicationId.toString()])
					println("appPendDetails "+appPendDetails)
					if(appPendDetails==null){
						
						
						appPendDetails = new EWasteManagementPendingDetails()
						appPendDetails.applicationId = applicationId+""
					}
					appPendDetails.applicationFor = groupName
					appPendDetails.applicationStatus ="pending"
					appPendDetails.indRegInstance =indregInstance
					
				    appPendDetails.role = (roleVsActList.get(i)).role
					appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
					
					if(appPendDetails.save(flush:true)){
						routed = true
						System.out.println("application routed")
					}else{
						appPendDetails.errors.each {
		    		        println it
		    		   }
		    		}
					objectType.applicationStatus="Inprogress"
						objectType.dateCreated= new Date()
						objectType.save()
					
				}else{
					
				}
				
			}
			if(!routed){
				def EWasteManagementUnattendedApplication=new EWasteManagementUnattendedApplication()
				EWasteManagementUnattendedApplication.applicationId=applicationId+""
				EWasteManagementUnattendedApplication.applicationFor=applicationFor
				EWasteManagementUnattendedApplication.routedStatus="unattended"
				EWasteManagementUnattendedApplication.save()
				println("222222")
				objectType.applicationStatus="unattended"
				objectType.save()
				
			}
			return routed
		
		}
		
	}
	
	
}
