Record  Inserting into  table....
<%@page import="java.text.*;"%>
<%

int total=0;
def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
def applicationPendingList=ApplicationPendingDetails.list();	
for(int ii=0;ii<applicationPendingList.size();ii++)
{
	try
	{
		def applicationPending=applicationPendingList.get(ii)
		def allSummaryReportInstance=AllSummaryReport.findByApplicationId((applicationPending.application.id).toString());
		if(!allSummaryReportInstance)
		{
			def indRegMasterInstance=applicationPending.application.indUser;
			def applicationDate
		    Date date1=applicationPending.application.actualApplicationDate 
		    Date date2=applicationPending.application.applicationDate
		    if(date1<date2)
		    	applicationDate=date1;
		    else
		    	applicationDate=date2;
			def roleFwd=applicationPending.role
			def aPDInstance=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and officer!=? and officerFwd=? order by dateCreated desc limit 1",[applicationPending.application,applicationPending.pendingWith.id,applicationPending.pendingWith.id]);
			def aPDInstance1=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by dateCreated desc limit 1",[applicationPending.application]);
			def aPDInstance2=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and clarification=false  and clarificationNote!='' and clarificationNote!=' '  order by dateCreated desc limit 1",[applicationPending.application]);
			allSummaryReportInstance=new AllSummaryReport();
			allSummaryReportInstance.applicationId=(applicationPending.application.id).toString()
			allSummaryReportInstance.indRegMasterId=(indRegMasterInstance.id).toString()
			allSummaryReportInstance.applicationName=indRegMasterInstance.indName
			allSummaryReportInstance.districtId=(indRegMasterInstance.district.id).toString()
			allSummaryReportInstance.districtName=indRegMasterInstance.district.districtName

////////	/???????			 code added for dashboard 
				def clarificatonInstance=ApplicationProcessingDetails.find("from ApplicationProcessingDetails ind where ind.application=? and ind.clarification=true order by ind.id desc",[applicationPending.application])
				def clarificatonInstanceClose=ApplicationProcessingDetails.find("from ApplicationProcessingDetails ind where ind.application=? and ind.clarification=false and ind.fileNote not in ('',' ') order by ind.id desc",[applicationPending.application])
				def  recordCertificateExpDate=RecordCertificate.find("from RecordCertificate ind where ind.applicationId=? order by ind.id desc",[applicationPending.application])
				def indUserId=IndUser.find("from IndUser where industryRegMaster.id=?",[indRegMasterInstance.id])
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String userInput = "01/01/1950";
				Date defaulDate = formatter.parse(userInput);
				allSummaryReportInstance.indId=indUserId.id;
				if(clarificatonInstance){
					allSummaryReportInstance.clarificationRaiseDt=clarificatonInstance.lastUpdated
					}else{
						allSummaryReportInstance.clarificationRaiseDt=defaulDate
					}
					if(clarificatonInstanceClose){
						allSummaryReportInstance.clarificationSubmitDt=clarificatonInstanceClose.lastUpdated
					}else{
						allSummaryReportInstance.clarificationSubmitDt=defaulDate
					}
				if(recordCertificateExpDate){
						allSummaryReportInstance.dateOfIssue=recordCertificateExpDate.startDate
						allSummaryReportInstance.dateOfexpiry=recordCertificateExpDate.endDate
						
						}else{
							allSummaryReportInstance.dateOfIssue=defaulDate
							allSummaryReportInstance.dateOfexpiry=defaulDate
							
						}
				allSummaryReportInstance.indAddress=indRegMasterInstance.indAddress;
				///////??????
						if(aPDInstance2)
					allSummaryReportInstance.lastClarificationDate = sdfh.format(aPDInstance2.dateCreated);	
						else
					allSummaryReportInstance.lastClarificationDate = ''
					if(aPDInstance1)
							allSummaryReportInstance.lastForward = sdfh.format(aPDInstance1.dateCreated);	
								else
							allSummaryReportInstance.lastForward = 'Not Forwarded'
				/////////??????
			allSummaryReportInstance.roleId=(roleFwd.id).toString();
			allSummaryReportInstance.roleName=roleFwd.roleName;
			allSummaryReportInstance.groupId=(roleFwd.group.id).toString()
			allSummaryReportInstance.groupName=roleFwd.group.groupName
			allSummaryReportInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
			allSummaryReportInstance.applicationType=applicationPending.application.applicationType
			allSummaryReportInstance.applicationFor=applicationPending.application.applicationFor
			allSummaryReportInstance.certificateFor=applicationPending.application.certificateFor
			allSummaryReportInstance.applicationStatus=applicationPending.applicationStatus
			allSummaryReportInstance.applicationRecieptDate=applicationDate;
			allSummaryReportInstance.indTypeId=(indRegMasterInstance.industryType.id).toString()
			allSummaryReportInstance.indTypeName=indRegMasterInstance.industryType.industryType
			allSummaryReportInstance.indCategoryId=(indRegMasterInstance.category.id).toString()
			allSummaryReportInstance.indCategoryName=indRegMasterInstance.category.name;
			if(aPDInstance)
			  allSummaryReportInstance.pendingSince=aPDInstance.dateCreated
			else
			  allSummaryReportInstance.pendingSince=date1		  
			allSummaryReportInstance.pendingWith=(applicationPending.pendingWith).toString()
			if(aPDInstance1){
			if(applicationPending.applicationStatus=='approved' || applicationPending.applicationStatus=='rejected')
				{
				allSummaryReportInstance.pendingSince=aPDInstance1.dateCreated;
				}
			}else{
				allSummaryReportInstance.pendingSince=applicationDate
			}
			if(!allSummaryReportInstance.hasErrors() && allSummaryReportInstance.save(flush:true)) 
			{}
			
			else {
				System.out.println("not saved======"+applicationPendingList.get(ii).application+"=======");
				allSummaryReportInstance.errors.each {
					 println it 
				}
			}	
		}	
		
	}
	catch(Exception e)
	{
		System.out.println("error======"+applicationPendingList.get(ii).application+"======="+e);
		e.printStackTrace();
	}
}
%>
Done