<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
testing update WMS tables....
<%

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String userInput = "01/01/1950";
Date defaulDate = formatter.parse(userInput);
def WasMgmtPenDetailList=WasteManagementPendingDetails.list();
//def WasMgmtPenDetailList=WasteManagementPendingDetails.findAll("from  WasteManagementPendingDetails where applicationId in('35845')");

for(int i=0;i<WasMgmtPenDetailList.size();i++)
{
	try
	{
		def WasteMgmtPenDet=WasMgmtPenDetailList.get(i)
		def allSummaryReportWMSInstance=AllSummaryReportWMS.findAll("from  AllSummaryReportWMS where applicationId=?",[WasteMgmtPenDet.applicationId]);
		if(!allSummaryReportWMSInstance)
		{
			def indRegMasterInstance=WasteMgmtPenDet.indRegInstance;
			def roleFwd=WasteMgmtPenDet.role
	        allSummaryReportWMSInstance=new AllSummaryReportWMS();
			allSummaryReportWMSInstance.applicationId=WasteMgmtPenDet.applicationId
		    allSummaryReportWMSInstance.recieptDate=defaulDate; 
			allSummaryReportWMSInstance.indRegMasterId=indRegMasterInstance.id
	        allSummaryReportWMSInstance.applicationName=indRegMasterInstance.indName
			allSummaryReportWMSInstance.districtId=(indRegMasterInstance.district.id).toString()
			allSummaryReportWMSInstance.districtName=indRegMasterInstance.district.districtName
			//allSummaryReportWMSInstance.scrutinyStatus="";
			allSummaryReportWMSInstance.scrutinyStatus=WasteMgmtPenDet.completionStatus
			allSummaryReportWMSInstance.categoryId=indRegMasterInstance.category.id
			allSummaryReportWMSInstance.categoryName=indRegMasterInstance.category.name
			allSummaryReportWMSInstance.roleId=(roleFwd.id).toString();
			allSummaryReportWMSInstance.roleName=roleFwd.roleName;
			allSummaryReportWMSInstance.groupId=(roleFwd.group.id).toString()
			allSummaryReportWMSInstance.groupName=roleFwd.group.groupName
			allSummaryReportWMSInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
			allSummaryReportWMSInstance.applicationFor=WasteMgmtPenDet.applicationFor
			allSummaryReportWMSInstance.applicationStatus=WasteMgmtPenDet.applicationStatus
			allSummaryReportWMSInstance.industryTypeId=indRegMasterInstance.industryType.id;
			allSummaryReportWMSInstance.industryTypeName=indRegMasterInstance.industryType.industryType;
			allSummaryReportWMSInstance.industryAddress=indRegMasterInstance.indAddress;
		    if(WasteMgmtPenDet.applicationFor=='BMW'){
		    	def instance12= BioMedicalWaste.find("from BioMedicalWaste where id=?",[(WasteMgmtPenDet.applicationId).toLong()])
				    if(instance12.authorizationType)
		    	allSummaryReportWMSInstance.authorizationtype=instance12.authorizationType
		    	else
		    		allSummaryReportWMSInstance.authorizationtype=instance12.authorisationAppliedFor
		    		
		    }else if(WasteMgmtPenDet.applicationFor=='HWM')
		    {
		    	
		    	def instance13= HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp where id=?",[(WasteMgmtPenDet.applicationId).toLong()])
					
		    	allSummaryReportWMSInstance.authorizationtype= instance13.is_Renew	
		    }
		    
		    else if(WasteMgmtPenDet.applicationFor=='MSW')
		    {
		    	def instance14= MunicipalSolidWaste.find("from MunicipalSolidWaste where id=?",[(WasteMgmtPenDet.applicationId).toLong()])
				
		    	allSummaryReportWMSInstance.authorizationtype=instance14.authorizationType	
		    }
		    
		     allSummaryReportWMSInstance.indCapInvt=(indRegMasterInstance.indCapInvt).toString()
		     def ind_ins=IndUser.find("from IndUser where industryRegMaster.id=?  order by dateCreated desc limit 1",[indRegMasterInstance.id]);
		     if(ind_ins)
		     allSummaryReportWMSInstance.indId=ind_ins.id
		     else
		    allSummaryReportWMSInstance.indId=""
		    allSummaryReportWMSInstance.dateCreated=WasteMgmtPenDet.dateCreated
		    allSummaryReportWMSInstance.authDate=WasteMgmtPenDet.dateCreated
		    allSummaryReportWMSInstance.pendingWith=((WasteMgmtPenDet.pendingWith).toString()).trim()
	        def clr_ins=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and clarification='t' order by dateCreated desc limit 1",[WasteMgmtPenDet.applicationId]);
		    def instance12;
		   /* if(WasteMgmtPenDet.applicationFor=='BMW'){
				    	 instance12= BioMedicalWaste.find("from BioMedicalWaste where id=? and clarification='t' ",[(WasteMgmtPenDet.applicationId).toLong()])
				    	    
		    }
		    else if(WasteMgmtPenDet.applicationFor=='HWM'){
				    	 instance12= HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp where id=? and clarification='t' ",[(WasteMgmtPenDet.applicationId).toLong()])
				    		    
		    }*/
			/*if(instance12){}else{
				allSummaryReportWMSInstance.clarificationDate=defaulDate;
			}*/
							if(clr_ins){
						allSummaryReportWMSInstance.clarification=true;
						allSummaryReportWMSInstance.clarificationType=""
						allSummaryReportWMSInstance.clarificationDate=clr_ins.dateCreated;
					}
						else{
							allSummaryReportWMSInstance.clarificationDate=defaulDate;
						}	
					
			def refused_ins=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and approvalStatus!='' order by dateCreated desc limit 1",[WasteMgmtPenDet.applicationId]);
			def returned_ins=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? order by dateCreated desc limit 1",[WasteMgmtPenDet.applicationId]);
			if(refused_ins)
			{
			if(refused_ins.approvalStatus=="Refused")
			{
				allSummaryReportWMSInstance.refused=true;
				allSummaryReportWMSInstance.refusedDate=refused_ins.dateCreated;
			}
			else{
				
				allSummaryReportWMSInstance.refusedDate=defaulDate;
			}
			
			}
			else{
				
				allSummaryReportWMSInstance.refusedDate=defaulDate;
			}
			if(returned_ins){
			if(returned_ins.returned==true && returned_ins.resubmitStatus==false){
			allSummaryReportWMSInstance.returned=true;
				allSummaryReportWMSInstance.returnedDate=returned_ins.dateCreated;
				}else{
				allSummaryReportWMSInstance.returnedDate=defaulDate;
				}
				
					}
					
			
			
			else{
			System.out.println("------No----returned_ins-----------")
				allSummaryReportWMSInstance.returnedDate=defaulDate;
			}
			if(WasteMgmtPenDet.applicationStatus=='approved' && WasteMgmtPenDet.applicationFor=='HWM'){
				def record_ins=RecordCertificateHWM.find("from RecordCertificateHWM where application.id=?  order by issueDate desc limit 1",[(WasteMgmtPenDet.applicationId).toLong()]);
				if(record_ins){
					allSummaryReportWMSInstance.dateOfIssue=record_ins.issueDate;
					allSummaryReportWMSInstance.dateOfExpaire=record_ins.expiryDate;
				}else{
					allSummaryReportWMSInstance.dateOfIssue=defaulDate;
					allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
				}
				}
			else if(WasteMgmtPenDet.applicationStatus=='approved' && WasteMgmtPenDet.applicationFor=='BMW'){
				def record_ins=RecordCertificateBMW.find("from RecordCertificateBMW where application.id=?  order by issueDate desc limit 1",[(WasteMgmtPenDet.applicationId).toLong()]);
				if(record_ins){
					allSummaryReportWMSInstance.dateOfIssue=record_ins.issueDate;
					allSummaryReportWMSInstance.dateOfExpaire=record_ins.expiryDate;
				}else{
					allSummaryReportWMSInstance.dateOfIssue=defaulDate;
					allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
				}
				}
			else{
					allSummaryReportWMSInstance.dateOfIssue=defaulDate;
					allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
				}
			///////////////////////////////////////////End Here/////////////////////////////////////////////////////////////////////			
			def aPDInstance=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and officer!=? and officerFwd=? order by dateCreated desc limit 1",[WasteMgmtPenDet.applicationId,WasteMgmtPenDet.pendingWith.id,WasteMgmtPenDet.pendingWith.id]);
			def aPDInstance1=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? order by dateCreated desc limit 1",[WasteMgmtPenDet.applicationId]);
			def aPDInstance2=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? order by dateCreated desc limit 1",[WasteMgmtPenDet.applicationId]);
		   if(aPDInstance){
		   
		    allSummaryReportWMSInstance.pendingSince=aPDInstance.dateCreated
		    }
			else{
		
			  allSummaryReportWMSInstance.pendingSince=WasteMgmtPenDet.dateCreated
			  allSummaryReportWMSInstance.pendingWith=WasteMgmtPenDet.pendingWith
			
			  }
		   
		   if(aPDInstance2){
			   if(clr_ins){
				   
				   if(aPDInstance2.dateCreated > clr_ins.dateCreated){
			    allSummaryReportWMSInstance.clarification=false;
			    allSummaryReportWMSInstance.clarificationReplyDate = formatter.format(aPDInstance2.dateCreated);
				   }
			   }
			   }
		   
		   if(WasteMgmtPenDet.applicationStatus=='approved' || WasteMgmtPenDet.applicationStatus=='rejected')
			{
			   allSummaryReportWMSInstance.pendingSince=aPDInstance1.dateCreated;
			}	  
		
			if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true)) 
			{
			System.out.println("5555555555555555555553--"+allSummaryReportWMSInstance.applicationId);
			
			}
			
			else {
				
				System.out.println("not saved-WMS--"+allSummaryReportWMSInstance.applicationId+"--------returned_ins.dateCreated-----"+returned_ins.dateCreated);
					
				allSummaryReportWMSInstance.errors.each {
			        println it
			       System.out.println(it);
				}
			}	
		}	
		
	}
	catch(Exception e)
	{
		System.out.println("error=====done...........charviiiiiiiiiiii.......======="+e);
		e.printStackTrace();
	}
}

%>
Done.........................		