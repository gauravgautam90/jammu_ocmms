/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class RouteWasteManagement{

	public boolean routeWasteManagementApp(Long applicationId,String applicationFor,IndustryRegMaster indregInstance){
		def grpList
		def routed = false
		def offIns=OfficeMaster.findByPriority(1)
		def groupName=applicationFor
		//def groupPresent=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc=? and gm.office=? ",[groupName,offIns])
		def groupPresent
		def applicationIdLong=applicationId
		def objectType 
		def group = new GroupMaster()
		def industryName;
		
		println("groupName===="+groupName);
		if(groupName=="HWM"){
			objectType=HazardeousWasteAuthApp.get(applicationIdLong)
			def locationId = objectType.industryRegMasterObj.district.id
			industryName=objectType.industryRegMasterObj.indName;
			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
			for(int i=0;i<grpList.size();i++){
				
				
				if(((grpList.get(i)).group).office == offIns){
					
					group = (grpList.get(i)).group
				}
			}
			
			
		}else if(groupName=="BMW"){
			println("INSIDE BMW ===="+groupName);
			objectType=BioMedicalWaste.get(applicationIdLong)
			def locationId = objectType.industryRegMasterObj.district.id
			industryName=objectType.industryRegMasterObj.indName;
			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId));
			for(int i=0;i<grpList.size();i++){
				
				
				if(((grpList.get(i)).group).office == offIns){
					
					group = (grpList.get(i)).group
				}
			}
			
			println("INSIDE grpList ===="+grpList);
			
		}else {
			objectType=MunicipalSolidWaste.get(applicationIdLong)
			def locationId = objectType.indRegMasterObj.district.id
			industryName=objectType.indRegMasterObj.indName;
			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
			for(int i=0;i<grpList.size();i++){
				
				
				if(((grpList.get(i)).group).office == offIns){
					
					group = (grpList.get(i)).group
				}
			}
			
		}
		println("INSIDE grpList ===="+grpList);
		if(!grpList){
			println("INSIDE grpList B ===="+grpList);
			def wasteManagementUnattendedApplication=new WasteManagementUnattendedApplication()
			wasteManagementUnattendedApplication.applicationId=applicationId+""
			wasteManagementUnattendedApplication.applicationFor=applicationFor
			wasteManagementUnattendedApplication.routedStatus="unattended"
			wasteManagementUnattendedApplication.save()
			objectType.applicationStatus="unattended"
			objectType.save()
		}else {
			/*def wastePendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wm where wm.applicationId=?",[String.valueOf(applicationId)])
			if(wastePendingInstance.size()>0){
				for(int i=0;i<wastePendingInstance.size();i++){
					wastePendingInstance[i].delete()
				}
			}*/
			//def group=groupPresent[0]
			println("INSIDE grpList C ===="+grpList);
			def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
			for(int i=0;i<roleVsActList.size();i++){
				if(((roleVsActList.get(i)).role).group == group){
					def statusValue= false
					def appPendDetails
					def	appPendDetails1 = WasteManagementPendingDetails.find("from WasteManagementPendingDetails indPower where indPower.applicationId=? order by indPower.applicationId desc",[applicationId.toString()])
					System.out.println("appPendDetails1 "+appPendDetails1)
					
					if(appPendDetails1==null){
						
						System.out.println("appPendDetails1 INSIDE IF NULL "+appPendDetails1)	
						 appPendDetails = new WasteManagementPendingDetails()
						appPendDetails.applicationId = applicationId+""			
						
						appPendDetails.applicationFor = groupName
						appPendDetails.applicationStatus ="pending"
						appPendDetails.indRegInstance =indregInstance				
						appPendDetails.completionStatus=""		
						
							appPendDetails.scrutinyStatus=""
							
								def applicationProcessingDetails = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails indPower where indPower.applicationId=? order by indPower.id desc",[applicationId.toString()])
								if(applicationProcessingDetails){
									if(applicationProcessingDetails.returned==true && applicationProcessingDetails.resubmitStatus==false){
								statusValue=true
								applicationProcessingDetails.resubmitStatus = true
								applicationProcessingDetails.save(flush:true)
								objectType.applicationStatus="Completed"
								objectType.save()
									}
								
								}
					 	appPendDetails.role = (roleVsActList.get(i)).role
						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
						if(appPendDetails.save(flush:true)){
							println("INSIDE grpListF ===="+appPendDetails);
							routed = true
								
						}else{
							println("ELSE ====");
							appPendDetails.errors.each {
								println it
			    		   }
			    		}
					}else if(appPendDetails1.completionStatus=="In-Complete" && appPendDetails1.scrutinyStatus=="In-Complete" && appPendDetails1.applicationStatus=="rejected"){
						System.out.println("scrutiny in-complete");
						appPendDetails1.applicationStatus = "pending"
						appPendDetails1.scrutinyStatus = "In-Process"
						appPendDetails1.completionStatus = "In-Process"
						if(appPendDetails1.save(flush:true)){
							System.out.println("scrutiny in-complete saved");
						}else{
							appPendDetails1.errors.each {
			    		        println it
			    		   }
			    		}
				}else if(appPendDetails1.completionStatus=="Completed" && appPendDetails1.scrutinyStatus=="Complete"){
					System.out.println("scrutiny Complete");
					appPendDetails1.applicationStatus = "pending"
					appPendDetails1.scrutinyStatus = "Complete"
					appPendDetails1.completionStatus = "Complete"
					if(appPendDetails1.save(flush:true)){
						System.out.println("scrutiny Complete saved");
					}else{
						appPendDetails1.errors.each {
			    		        println it
			    			}
			    		}
					}else if(appPendDetails1.applicationStatus=="returned"){
					System.out.println("returned resubmit");
					appPendDetails1.applicationStatus = "pending"
					appPendDetails1.scrutinyStatus = "Complete"
					appPendDetails1.completionStatus = "Complete"
					if(appPendDetails1.save(flush:true)){
						System.out.println("returned resubmit Complete saved");
					}else{
						appPendDetails1.errors.each {
			    		        println it
			    			}
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
				objectType.applicationStatus="unattended"
				objectType.save()
				
			}
			
			
			return routed
		
		}
		
	}
	
}
