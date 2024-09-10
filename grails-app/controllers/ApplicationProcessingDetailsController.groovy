import java.lang.Exception
import java.io.*;
import javax.mail.*;
import SendMail;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File
import java.io.FileInputStream
import java.lang.NumberFormatException
import org.apache.commons.fileupload.DiskFileUpload
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile
class ApplicationProcessingDetailsController {
	
	def index = {
			 try { 
			       redirect(action:list,params:params)
				}
			 catch(Exception e) {
			           e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			   redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			         redirect(uri:'/index.gsp');
			 }
	   }
	}
	
	// the delete, save and update actions only accept POST requests
	static allowedMethods = [delete:'POST', save:'POST', update:'POST']
	
	def list = {
		 try { 
		       params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				[ applicationProcessingDetailsInstanceList: ApplicationProcessingDetails.list( params ), applicationProcessingDetailsInstanceTotal: ApplicationProcessingDetails.count() ]
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def show = {
		 try { 
		       def applicationProcessingDetailsInstance = ApplicationProcessingDetails.get( params.id )
				if(!applicationProcessingDetailsInstance) {
					flash.message = "ApplicationProcessingDetails not found with id ${params.id}"
					redirect(action:list)
				}
				else { return [ applicationProcessingDetailsInstance : applicationProcessingDetailsInstance ]
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def delete = {
		def applicationProcessingDetailsInstance = ApplicationProcessingDetails.get( params.id )
		if(applicationProcessingDetailsInstance) {
			try {
				applicationProcessingDetailsInstance.delete()
				flash.message = "ApplicationProcessingDetails ${params.id} deleted"
				redirect(action:list)
			}
			catch(org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "ApplicationProcessingDetails ${params.id} could not be deleted"
				redirect(action:show,id:params.id)
			}
		}
		else {
			flash.message = "ApplicationProcessingDetails not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit = {
		 try { 
		       def applicationProcessingDetailsInstance = ApplicationProcessingDetails.get( params.id )
				if(!applicationProcessingDetailsInstance) {
					flash.message = "ApplicationProcessingDetails not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					return [ applicationProcessingDetailsInstance : applicationProcessingDetailsInstance ]
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		     redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def update = {
		 try { 
		       def applicationProcessingDetailsInstance = ApplicationProcessingDetails.get( params.id )
				if(applicationProcessingDetailsInstance) {
					if(params.version) {
						def version = params.version.toLong()
						if(applicationProcessingDetailsInstance.version > version) {
							applicationProcessingDetailsInstance.errors.rejectValue("version", "applicationProcessingDetails.optimistic.locking.failure", "Another user has updated this ApplicationProcessingDetails while you were editing.")
							render(view:'edit',model:[applicationProcessingDetailsInstance:applicationProcessingDetailsInstance])
							return
						}
					}
					applicationProcessingDetailsInstance.properties = params
					if(!applicationProcessingDetailsInstance.hasErrors() && applicationProcessingDetailsInstance.save()) {
						flash.message = "ApplicationProcessingDetails ${params.id} updated"
						redirect(action:show,id:applicationProcessingDetailsInstance.id)
					}
					else {
						render(view:'edit',model:[applicationProcessingDetailsInstance:applicationProcessingDetailsInstance])
					}
				}
				else {
					flash.message = "ApplicationProcessingDetails not found with id ${params.id}"
					redirect(action:edit,id:params.id)
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	}
	}
	
	def create = {
		 try { 
     		def applicationProcessingDetailsInstance = new ApplicationProcessingDetails()
				applicationProcessingDetailsInstance.properties = params
				return ['applicationProcessingDetailsInstance':applicationProcessingDetailsInstance]
			}
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def save = {
		 try { 
		       def applicationProcessingDetailsInstance = new ApplicationProcessingDetails(params)
				if(!applicationProcessingDetailsInstance.hasErrors() && applicationProcessingDetailsInstance.save()) {
					flash.message = "ApplicationProcessingDetails ${applicationProcessingDetailsInstance.id} created"
					redirect(action:show,id:applicationProcessingDetailsInstance.id)
				}
				else {
					render(view:'create',model:[applicationProcessingDetailsInstance:applicationProcessingDetailsInstance])
				}
		  }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	 }
	}
	
def appProcessing = {
	try { 
	println("params in appProcessing----"+params)

    def indApp = IndApplicationDetails.get((params.id).toLong());
	def viewCertupload=params.viewCertupload
	def viewHWMCertupload=params.viewHWMCertupload
				def certificateFor
				if(indApp){
					if( indApp.applicationType=="CTE"){
						certificateFor="cte"
					}else if(indApp.applicationFor=="air"){
						if(indApp.certificateFor=="new"){
							certificateFor="nAir"
						}else{
							certificateFor="rAir"
						}
					}else {
						if(indApp.certificateFor=="new"){
							certificateFor="nWater"
						}else{
							certificateFor="rWater"
						}
					}
					if(indApp.applicationType=="CTO"){
						
					}
				}
				def viewCert = false
				def viewCert1 = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def uploadCert=UploadConsentOrder.findByApplicationId(indApp)
				def Upload= false
				if(uploadCert){
					Upload=true
				}
				
				def uploadCert1=UploadConsentHWMOrder.findByApplicationId(indApp)
				def Upload1= false
				if(uploadCert1){
					Upload1=true
				}
				
				def certInst = RecordCertificate.findByApplicationId(indApp)
				if(certInst){
					viewCert = true
				}
				def certInst1 = RecordCertificate.find("from RecordCertificate abc where abc.applicationId=? and abc.typeofCertificate='Modified'",[indApp])
				println("certInst1.."+certInst1)
				if(certInst1){
					viewCert1 = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApp])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApp])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def app = ApplicationPendingDetails.findByApplication(indApp)
				def roleHeader=app.role.roleName
				def roleId=app.role
				def roleActList = RoleVsActivity.findAllByRole(app.role)
				def actionList = new ArrayList()
				def clarification = false
				def inspection = false
				def approve = false
				def reject = false
				def inspectionClose = false
				def prepareCertificate = false
				def closeApplication = false /////Add by Pragya
				def fwdRoleList = new ArrayList()
				/*def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
				for(int i=0;i<workFlowMasterList.size();i++){
					println(workFlowMasterList.get(0))
					fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
				}*/
				 def workFlowMasterList = WorkFlowMaster.findAll("from WorkFlowMaster wf,RoleMaster r where wf.role=? and wf.role.id=r.id  order by CASE WHEN  wf.canForwardTo.roleName=? THEN 1 END",[app.role,app.role.roleName])
		    		for(int ii=0;ii<workFlowMasterList.size();ii++){
		    			ArrayList ff=(ArrayList)workFlowMasterList.get(ii)
		    			for(int i9=0;i9<ff.size();i9++){
		    				if(i9==0){
		    					fwdRoleList.add(ff[i9].canForwardTo)
		    				}
		    			}
		    		}
				actionList.add(RoleActivityMaster.findWhere(activityCode:"002"))
				for(int i=0;i<roleActList.size();i++){
					if((roleActList.get(i)).activity.activityCode == "004" ){
						actionList.add((roleActList.get(i)).activity)
					}else if((roleActList.get(i)).activity.activityCode == "006"){
						clarification = true
					}else if((roleActList.get(i)).activity.activityCode == "007"){
						inspection = true
					}else if((roleActList.get(i)).activity.activityCode == "005"){
						approve = true
					}else if((roleActList.get(i)).activity.activityCode == "003"){
						reject = true
					}else if((roleActList.get(i)).activity.activityCode == "008"){
						inspectionClose = true
					}else if((roleActList.get(i)).activity.activityCode == "002"){
						prepareCertificate = true
					}else if((roleActList.get(i)).activity.activityCode == "009"){
						closeApplication = true
					}
				}
				println("approve..."+approve)
				println("clarification..."+clarification)
				println("inspection..."+inspection)
				println("inspectionClose..."+inspectionClose)
				println("reject..."+reject)
				println("viewCert..."+viewCert)
				println("viewCert1..."+viewCert1)
				def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(indApp,[sort:'dateCreated',order:'desc',offset:0])
				if(applicationProcessingDetailsInstanceList){
					def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
					println("------fwdRoleList-----")
					model:[roleId:roleId,viewCert1:viewCert1,certificateFor:certificateFor,roleHeader:roleHeader,actionList:actionList,closeApplication:closeApplication,clarification:clarification,inspection:inspection,fwdRoleList:fwdRoleList,app:app,indApp:indApp,approve:approve,reject:reject,inspectionClose:inspectionClose,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,prepareCertificate:prepareCertificate,viewCert:viewCert,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCertupload:viewCertupload,Upload:Upload,viewHWMCertupload:viewHWMCertupload,Upload1:Upload1]
				}else{
					println("------fwdRoleList--in else---")
					model:[roleId:roleId,viewCert1:viewCert1,certificateFor:certificateFor,roleHeader:roleHeader,actionList:actionList,closeApplication:closeApplication,clarification:clarification,inspection:inspection,fwdRoleList:fwdRoleList,app:app,indApp:indApp,approve:approve,reject:reject,inspectionClose:inspectionClose,applicationProcessingDetailsInstance:null,prepareCertificate:prepareCertificate,viewCert:viewCert,viewR_Certificate:viewR_Certificate,viewR4_Certificate:viewR4_Certificate,viewCertupload:viewCertupload,Upload:Upload,viewHWMCertupload:viewHWMCertupload,Upload1:Upload1]
				}
			}
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		  }
	}
	
	def processApp = {
		try {
			println("params IN processApp..."+params)
			 def redirectBack = false
				def applicationPending = ApplicationPendingDetails.get((params.appId).toLong())
				def indAppInstance=applicationPending.application

			// code to apply check no processing should be done if application is returned and not re-summitted - start
            def appProcessingLastInstance = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application = ? order by dateCreated desc", [indAppInstance])
           println("appProcessingLastInstance----"+appProcessingLastInstance)
            if(appProcessingLastInstance!=null){
                if(appProcessingLastInstance.returned && !appProcessingLastInstance.resubmitStatus){
                	 println("inside this----")
                    redirect(controller: "userMaster", action: "recentAppl")
                    return
                }
            }
            // code to apply check no processing should be done if application is returned and not re-summitted - end
				def rVa = RoleVsActivity.findWhere(role:applicationPending.role, activity:RoleActivityMaster.findByActivityCode("001")) 
				println("rVa----"+rVa)
				if(rVa){
					def list = ApplicationPendingDetails.findAllByApplication(applicationPending.application)
					for(int i=0;i<list.size();i++){
						if(list.get(i)!=applicationPending){
							(list.get(i)).delete()
						}
					}
				}
            
				println("111111----")
				Response resPush= new Response();
				String consentAppNo=indAppInstance.id.toString();
				String cafNo=indAppInstance.cafUniqueNo
				String serviceId=indAppInstance.serviceId
				String applicationty=indAppInstance.applicationType
				String applicationFr=indAppInstance.certificateFor
				String appRemarks=""
				String statusCode=""
				String pendingWith=""
				String pendingRoleName=""
				String applicationRemarks=""
				String certificateUrl=""
				String printAppUrl="https://jkocmms.nic.in/indApplicationDetails/downloadApplicationForm/"+consentAppNo
				String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+indAppInstance.indUser.indName+"&indDistrict="+indAppInstance.indUser.district.districtName+"&serviceCode="+indAppInstance.serviceId+"&cafUniqueNo="+indAppInstance.cafUniqueNo
				def roleFwd = RoleMaster.get((params.forward).toLong())
				println("ROLE FORWARDED..."+roleFwd);
				println("ROLE FORWARDED ID..."+roleFwd.id);
				def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
				println("empUser..."+empUser);
				def applicationProcessingDetails = new ApplicationProcessingDetails()
				applicationProcessingDetails.role = applicationPending.role
				println("applicationProcessingDetails.role..."+applicationProcessingDetails.role);
				def user = session.userMaster
				user.refresh()
				applicationProcessingDetails.officer = user.userProfile.id
				println("applicationProcessingDetails.officer..."+applicationProcessingDetails.officer);
				applicationProcessingDetails.fileNote = params.fileNote
				applicationProcessingDetails.roleFwd = roleFwd
				println("applicationProcessingDetails.roleFwd..."+applicationProcessingDetails.roleFwd);
				applicationProcessingDetails.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
				println("officerFwd..."+applicationProcessingDetails.officerFwd);
				if(params.approvalStatus)
				{
					applicationProcessingDetails.approvalStatus = params.approvalStatus
				}
				else
				{
					applicationProcessingDetails.approvalStatus = " "
				}
				
								/////////// Code for Scrutiny Start
									def scrutiny = params.scrutiny
									println("scrutiny---"+scrutiny)
								if(scrutiny=="" || scrutiny==null)
									{
										applicationProcessingDetails.scrutinyStatus=""
		
									}
									else
									{
										applicationProcessingDetails.scrutinyStatus=scrutiny
									}
			
				if(scrutiny.equals("Complete"))
				{
					println("INside scrutiny completer==")
					def indApp = applicationPending.application
					applicationPending.scrutinyStatus=scrutiny
					applicationPending.completionDate=new Date()
					applicationPending.completionStatus="Completed"
						if(params.fileNote==null)
						{
							applicationProcessingDetails.fileNote = "";
						}else
						{
							applicationProcessingDetails.fileNote=params.fileNote 
						}
					if(params.scrutinyDescription){
					applicationProcessingDetails.scrutinyDescription = params.scrutinyDescription
					}
					if(params.remarks){
						applicationProcessingDetails.scrutinyDescription = params.remarks
						}
					else{
						applicationProcessingDetails.scrutinyDescription = ""	
					}
					
					
					///////////////////////////////////////////////////////////////////////////////////////////////////
					
								def noteHistiryFile=new ApplicationFileRecord()
						 		String apliId = (indApp.id).toString()
								def f = request.getFile('attachScrutinyReport')
								MultipartFile multi = request.getFile('attachScrutinyReport')
								if(!f.empty) {
									
									def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CompleteScrutinyReport' order by afr.id desc",[indAppInstance],[max:1])
									if(applicationFileRecordInstance){
										noteHistiryFile.version =applicationFileRecordInstance[0].version+1
									}
									noteHistiryFile.size = multi.getSize() / 1024
									if(noteHistiryFile.size<=6000){
									noteHistiryFile.name =multi.getOriginalFilename()
									noteHistiryFile.data=multi.getBytes() 
									noteHistiryFile.extension = extractExtension( multi )
									noteHistiryFile.description="Complete Scrutiny Report"
									if(session.userMaster){
										noteHistiryFile.createdBy=session.userMaster
										noteHistiryFile.updatedBy=session.userMaster
									}else {
										noteHistiryFile.createdBy=session.indUser
										noteHistiryFile.updatedBy=session.indUser
									}
									println("Checkbefore data")
									println("Check ing ing")
									noteHistiryFile.typeOfFile="CompleteScrutinyReport"
									noteHistiryFile.indApplication=indAppInstance  
									if(noteHistiryFile.save()) {
										System.out.println("Done getting new file")
									} else {
										println("inEsle")
										redirect(action:'appProcessing',params:["id":indApp.id])
									}
								}
								else {
									println("inEslereynnnnnnnnnnnnnnnnnnnnnnnnnnnn")
									flash.message = "Attachment File Size is More Then 5 Mb"
								    redirectBack = true
								}
								}
					
								
								def conFeeInst = ConsentFeeMaster.find("from ConsentFeeMaster where application=? order by id desc",[applicationPending.application])	
								
								if(conFeeInst){
									if(params.feeApplicable){
										conFeeInst.totalApplicableFee = (params.feeApplicable).toFloat()
									}
									println("feeApplicable---:"+params.feeApplicable)
								if(params.lateFee1){	
									conFeeInst.lateFees = (params.lateFee1).toFloat()
								}
								
								if(params.addFee){	
									conFeeInst.addFees = (params.addFee).toFloat()
								}
								
								if(params.totalFee!=null && params.totalFee!="" && params.totalFee!="0" && params.totalFee!="0.00"){
									conFeeInst.totalFees = (params.totalFee).toFloat()
									println("conFeeInst.totalFees:"+conFeeInst.totalFees)
									
									def test2 = (params.totalFee).toFloat()
									println("test2"+test2)
									}else{
										applicationPending.completionStatus=""
											applicationPending.scrutinyStatus=""
										println("totalFee is null")
										flash.message = "TotalFee cant not be Zero "
											//redirect(action:appProcessing,id:params.indAppDetId,radio:"other");
										redirect(action:'appProcessing',params:["id":indApp.id])
										     return
											
									}
								
								if(conFeeInst.save(flush:true)){
									println("conFeeInst.save()----")
								}
								else{
									println("conFeeInst not save()----")
									conFeeInst.errors.each {
				            			        println it
				            			   }
								}
								
								}
								        statusCode="Payment"
										appRemarks="Request for Payment"
									if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
										if(roleFwd.id ==(applicationPending.role.id))
										{
										pendingRoleName=applicationPending.role.roleName
										pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
										resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
									}
									}
				}
					///////////////////////////////////////////////////////////////////////////////////////////////////
					
				////////////// Scrutiny Code Start
				if(scrutiny.equals("In-Complete")){

					println("ashu-------")
					def appScrutiny;
					if(false)
					 {
								flash.message = "Scrutiny Incomplete has been already done 1 time."
								redirectBack = true
					 }else
					 {
						 		
						 		def noteHistiryFile=new ApplicationFileRecord()
						 		def indApp = applicationPending.application
						 		String apliId = (indApp.id).toString()
								def f = request.getFile('attachScrutinyReport')
								MultipartFile multi = request.getFile('attachScrutinyReport')
								if(!f.empty) {
									
									def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='scrutinyReport' order by afr.id desc",[indAppInstance],[max:1])
									if(applicationFileRecordInstance){
										noteHistiryFile.version =applicationFileRecordInstance[0].version+1
									}
									noteHistiryFile.size = multi.getSize() / 1024
									if(noteHistiryFile.size<=6000){
									noteHistiryFile.name =multi.getOriginalFilename()
									noteHistiryFile.data=multi.getBytes() 
									noteHistiryFile.extension = extractExtension( multi )
									noteHistiryFile.description="Scrutiny Report"
									if(session.userMaster){
										noteHistiryFile.createdBy=session.userMaster
										noteHistiryFile.updatedBy=session.userMaster
									}else {
										noteHistiryFile.createdBy=session.indUser
										noteHistiryFile.updatedBy=session.indUser
									}
									println("Checkbefore data")
									println("Check ing ing")
									noteHistiryFile.typeOfFile="scrutinyReport"
									noteHistiryFile.indApplication=indAppInstance  
									if(noteHistiryFile.save()) {
										System.out.println("Done getting new file")
									} else {
										println("inEsle")
										redirect(action:'appProcessing',params:["id":indApp.id])
									}
								}
								else {
									println("inEslereynnnnnnnnnnnnnnnnnnnnnnnnnnnn")
									flash.message = "Attachment File Size is More Then 5 Mb"
								    redirectBack = true
								}
								}
								applicationProcessingDetails.scrutinyDescription = params.scrutinyDescription
								println("iiiittttttt----"+applicationProcessingDetails.scrutinyDescription)
								if(params.fileNote==null)
								{
									applicationProcessingDetails.fileNote = "";
								}else
								{
									applicationProcessingDetails.fileNote=params.fileNote 
								}
								applicationProcessingDetails.clarification = false
								applicationProcessingDetails.clarificationNote = ""
								applicationProcessingDetails.inspection = false
								applicationProcessingDetails.inspectionNote = ""
								applicationProcessingDetails.inspectionClose = false
								indApp.inspection = false
								indApp.clarification = false
								applicationProcessingDetails.inspectionCloseNote = ""
								applicationProcessingDetails.reject = true
								indApp.save()

								applicationPending.applicationStatus = "rejected"
								applicationPending.scrutinyStatus=scrutiny
								applicationPending.completionDate=new Date()
								applicationPending.completionStatus=scrutiny

								def appId = (indApp.id).toString()
								def oMobNo = "91"+indApp.indUser.occMobile
								def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"

								SendSms sms = new SendSms()
								//sms.scrutinyReturned(appId,oMobNo,appFor)
					 }	
				        statusCode="RBI"
						appRemarks="Scrutiny has been raised on application.Kindly check and reply."
					if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
						if(roleFwd.id ==(applicationPending.role.id))
						{
						pendingRoleName=applicationPending.role.roleName
						pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
					resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
					}
					}
					
				}
				/////////////Scrutiny Code end
				if((params.clarification).equals("yes")){
					println("Inside Clarification Raised");
					def indApp = applicationPending.application
					indApp.clarification = true
						indApp.save()
						applicationProcessingDetails.clarification = true
						applicationProcessingDetails.clarificationNote = params.clarificationNote
//						code attached for dashboard work start from here
						def allSummaryReportInstance1=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(applicationPending.application.id).toString()]);
					   if(allSummaryReportInstance1)
						{
							allSummaryReportInstance1.clarificationRaiseDt=new Date();
							if(allSummaryReportInstance1.save()) {
								
							}
						}
					// code for dashboard ends here
						
						def applicationSubmitDate;
						def appDateNew = indApp.applicationDate;
						Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						applicationSubmitDate= formatter3.format(appDateNew)
						def emailId = indApp.indUser.occEmail
						def occName = indApp.indUser.occName
						def appId = (indApp.id).toString()
						def days = params.clarificationDays
						def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"
						println("appDateNew "+appDateNew)
						println("emailId "+emailId)
						println("occName "+occName)
						println("==========Email Code Raise Clarification Consent Start=========")
						if(emailId!=null && emailId!="")
						{
							SendMail mail = new SendMail()
							mail.sendClarification(appId,days,emailId,appFor,occName,applicationSubmitDate)
						}
				println("Clarification Mail has been Sent to industry ")
				///////////////////////SMS code starts here/////////////////////
				//def appId = (indApp.id).toString()
					//	def days = params.clarificationDays
						def oMobNo = indApp.indUser.occMobile
					//	def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"				
					//	def emailId = indApp.indUser.occEmail
					//	def occName = indApp.indUser.occName
						
						SendSms sms = new SendSms()
				//		sms.sendClarification(appId,days,oMobNo,appFor)
						///////////////ends here///////////////////
						def noteHistiryFile1 = new ApplicationFileRecord()	
						def f6 = request.getFile('attachClarificationReport')
						MultipartFile multi = request.getFile('attachClarificationReport')
						if(!f6.empty) {
							applicationProcessingDetails.clarificationAttachedFile = true
							def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachedClarificationReport' order by afr.id desc",[indAppInstance],[max:1])
							if(applicationFileRecordInstance){
								noteHistiryFile1.version =applicationFileRecordInstance[0].version+1
							}
							noteHistiryFile1.size = multi.getSize() / 1024
							if(noteHistiryFile1.size<=6000) {
							noteHistiryFile1.name =multi.getOriginalFilename()
							noteHistiryFile1.data=multi.getBytes() 
							noteHistiryFile1.extension = extractExtension( multi )
							noteHistiryFile1.description="Application attached Clarification Report"
							if(session.userMaster){
								noteHistiryFile1.createdBy=session.userMaster
								noteHistiryFile1.updatedBy=session.userMaster
							}else {
								noteHistiryFile1.createdBy=session.indUser
								noteHistiryFile1.updatedBy=session.indUser
							}
							noteHistiryFile1.typeOfFile="attachedClarificationReport"
							noteHistiryFile1.indApplication=indAppInstance  
							if(noteHistiryFile1.save()) {
								System.out.println("Done getting new clarification raised file")	
							} else {
								redirect(action:'appProcessing',params:["id":indApp.id])
							}
							}
							else {
								flash.message = "Attachment File Size is More Then 5 Mb"
							    redirectBack = true
							}
						}
				    statusCode="F"
					appRemarks="Clarification has been raised on application.Kindly check and reply."
				if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
					if(roleFwd.id ==(applicationPending.role.id))
					{
					pendingRoleName=applicationPending.role.roleName
					pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				}
				}
				}else{
					applicationProcessingDetails.clarification = false
					applicationProcessingDetails.clarificationNote = ""
				}
//				******************code by vikas for return application*************************//
				if((params.returned).equals("yes")){
					println("in case of return")
					def indApp = applicationPending.application
					def certRecord = RecordCertificate.findByApplicationId(indApp)
					def approval = ApplicationProcessingDetails.find("from ApplicationProcessingDetails apd where apd.application=? and apd.approvalStatus <> '' order by apd.id desc",[indApp])
					if(approval){
					if(approval.approvalStatus=='Approved'){
						flash.message = "Sorry this Application is approved by higher authority you cannot return this application"
							redirectBack = true
						}
					else if(approval.approvalStatus=='Refused'){
						flash.message = "Sorry this Application is refused by higher authority you cannot return this application"
							redirectBack = true
						}
					else{
						applicationPending.applicationStatus = "returned"
						applicationPending.completionDate=new Date()
						applicationPending.save()
						applicationProcessingDetails.returned = true
						applicationProcessingDetails.returnNote = params.returnNote
						applicationProcessingDetails.resubmitStatus=false
						indApp.clarification = false
						indApp.save()
						///////////////////Mail send///////////
						def applicationSubmitDate;
						def appDateNew = indApp.applicationDate;
						Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						applicationSubmitDate= formatter3.format(appDateNew)
						def emailId = indApp.indUser.occEmail
						def occName = indApp.indUser.occName
						def appId = (indApp.id).toString()
						def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"
						println("appDateNew "+appDateNew)
						println("emailId "+emailId)
						println("occName "+occName)
						println("==========Email Code Returned Consent Start=========")
						if(emailId!=null && emailId!="")
						{
							SendMail mail = new SendMail()
							mail.sendReturned(appId,emailId,appFor,occName,applicationSubmitDate)
						}
						println("Returned Mail has been Sent to industry ")
						///////// SMS CODE  ////////
						//def appId = (indApp.id).toString()
						def oMobNo = indApp.indUser.occMobile
						//def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"
						SendSms sms = new SendSms()
					//	sms.sendReturned(appId,oMobNo,appFor)
						statusCode="RBI"
						appRemarks="Application has been returned.Kindly Check and reply."
						if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							pendingRoleName=applicationPending.role.roleName
							resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
						}
					}
					else{
						applicationPending.applicationStatus = "returned"
						applicationPending.completionDate=new Date()
						applicationPending.save()
						applicationProcessingDetails.returned = true
						applicationProcessingDetails.returnNote = params.returnNote
						applicationProcessingDetails.resubmitStatus=false
						indApp.clarification = false
						indApp.save()
//////////////////		/Mail send///////////
						def applicationSubmitDate;
						def appDateNew = indApp.applicationDate;
						Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						applicationSubmitDate= formatter3.format(appDateNew)
						def emailId = indApp.indUser.occEmail
						def occName = indApp.indUser.occName
						def appId = (indApp.id).toString()
						def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"
						println("appDateNew "+appDateNew)
						println("emailId "+emailId)
						println("occName "+occName)
						println("==========Email Code Returned Consent Start=========")
						if(emailId!=null && emailId!="")
						{
							SendMail mail = new SendMail()
							mail.sendReturned(appId,emailId,appFor,occName,applicationSubmitDate)
						}
				println("Returned Mail has been Sent to industry ")
						///////// SMS CODE  ////////
					//	def appId = (indApp.id).toString()
						def oMobNo = indApp.indUser.occMobile
					//	def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"
						SendSms sms = new SendSms()
					//	sms.sendReturned(appId,oMobNo,appFor)
						statusCode="RBI"
						appRemarks="Application has been returned.Kindly Check and reply."
						if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							pendingRoleName=applicationPending.role.roleName
						resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
						}
					}
				else{
					applicationProcessingDetails.returned = false
					applicationProcessingDetails.returnNote = ""
					applicationProcessingDetails.resubmitStatus=false
				}
	if((params.inspection).equals("yes")){ 
		println("Inside inspection Raised");
					def indApp = applicationPending.application
					if(indApp.inspection){
						flash.message = "Inspection already Raised on this application"
						redirectBack = true
					}else{
						indApp.inspection = true
						indApp.save()
						applicationProcessingDetails.inspection = true
						applicationProcessingDetails.inspectionNote = params.inspectionNote
						def noteHistiryFile2 = new ApplicationFileRecord()	
						def f = request.getFile('attachInspectionReport')
						MultipartFile multi = request.getFile('attachInspectionReport')
						if(!f.empty) {
							applicationProcessingDetails.inspectionAttachedFile = true
							def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachedInspectionReport' order by afr.id desc",[indAppInstance],[max:1])
							if(applicationFileRecordInstance){
								noteHistiryFile2.version =applicationFileRecordInstance[0].version+1
							}
							noteHistiryFile2.size = multi.getSize() / 1024
							if(noteHistiryFile2.size<=6000){
							noteHistiryFile2.name =multi.getOriginalFilename()
							noteHistiryFile2.data=multi.getBytes() 
							noteHistiryFile2.extension = extractExtension( multi )
							noteHistiryFile2.description="Application attached Inspection Report"
							if(session.userMaster){
								noteHistiryFile2.createdBy=session.userMaster
								noteHistiryFile2.updatedBy=session.userMaster
							}else {
								noteHistiryFile2.createdBy=session.indUser
								noteHistiryFile2.updatedBy=session.indUser
							}
							noteHistiryFile2.typeOfFile="attachedInspectionReport"
							noteHistiryFile2.indApplication=indAppInstance  
							if(noteHistiryFile2.save()) {
							} else {
								redirect(action:'appProcessing',params:["id":indApp.id])
							}
							}
							else {
								flash.message = "Attachment File Size is More Then 5 Mb"
							    redirectBack = true
							}
						}
						////////////////////SMS code/////////////////////
						def appId = (indApp.id).toString()
						//def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
						def oMobNo = empUser.userProfile.mobile
						def days = params.inspectionDays
						def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"

						SendSms sms = new SendSms()
					//	sms.sendInspection(appId,days,oMobNo,appFor)
						statusCode="F"
						appRemarks="Inspection has been raised by pcb officer"
						if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							pendingRoleName=applicationPending.role.roleName
						resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
					}
				}else{
					applicationProcessingDetails.inspection = false
					applicationProcessingDetails.inspectionNote = ""
				}
				if((params.inspectionClose).equals("yes")){ 
					println("Inside inspectionClose");
					def noteHistiryFile=new ApplicationFileRecord()
					def indApp = applicationPending.application
					def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Inspection Report' order by afr.id desc",[indAppInstance])
					println("hello.."+applicationFileRecordInstance)
					if(!indApp.inspection){
						flash.message = "Inspection not Raised on this application"
						redirect(action:'appProcessing',params:["id":indApp.id])
					}else if(!applicationFileRecordInstance){
						flash.message = "Please first Prepare Industry Master Data and Then Generate Inspection Report"
							redirect(action:'appProcessing',params:["id":indApp.id])
							return
					}
					else{
					applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Inspection Report' and afr.createdBy=? order by afr.id desc",[indAppInstance,(session.userMaster).toString()])
						
						if(applicationFileRecordInstance){
							applicationProcessingDetails.inspectionCloseAttachedFile=true	
						}
						else
						{
							applicationProcessingDetails.inspectionCloseAttachedFile=false	
						}
						String apliId = (indApp.id).toString()
						indApp.inspection = false
						indApp.save()
						applicationProcessingDetails.inspectionClose = true
						applicationProcessingDetails.inspectionCloseNote = params.inspectionCloseNote
						statusCode="F"
						appRemarks="Inspection has been closed by pcb officer"
						if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							pendingRoleName=applicationPending.role.roleName
						resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
					}
				}else{
					applicationProcessingDetails.inspectionClose = false
					applicationProcessingDetails.inspectionCloseNote = ""
				}
				
				if((params.approve).equals("yes")){
					println("Inside approve");
					def indApp = applicationPending.application
					def certRecord = RecordCertificate.findByApplicationId(indApp)
					println("certRecord..."+certRecord)
					def uploadInst = UploadConsentOrder.findByApplicationId(indApp)
					println("uploadInst..."+uploadInst)
					def refusal = ApplicationProcessingDetails.find("from ApplicationProcessingDetails apd where apd.application=? and apd.approvalStatus <> '' order by apd.id desc",[indApp])
					println("refusal..."+refusal)
					if(refusal){
						println("inside...")
					if(refusal.approvalStatus=='Refused'){
						println("inside..refused.")
						flash.message = "Sorry this Application is refused by higher authority you cannot close this application as approved"
							redirectBack = true
						}
					else if(indApp.inspection){
						println("inside..inspection.")
						flash.message = "Sorry can not Approve Inspection is Raised on this application"
						redirectBack = true
					}else if(indApp.clarification){
						println("inside.clarification..")
						flash.message = "Sorry can not Approve Clarification is Raised on this application"
						redirectBack = true
					} else if(!certRecord){
						println("inside.certificate.222222222222.")
						flash.message = "Please generate consent order(Schedule-3) first."
						redirectBack = true
					}else if(!uploadInst){
						flash.message = "Please Upload consent order first."
							redirectBack = true
					}
					else{
						println("else...")
						applicationPending.applicationStatus = "approved"
						applicationPending.completionDate = new Date()
						if(applicationPending.save(flush:true)){
						}else{
							applicationPending.errors.each{
								println it;
							}
						}
						applicationProcessingDetails.approve = true
						applicationProcessingDetails.approveNote = params.approveNote
						///////// SMS CODE  ////////
						def appId = (indApp.id).toString()
						def oMobNo = indApp.indUser.occMobile
						def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"
						SendSms sms = new SendSms()
					//	sms.sendGranted(appId,oMobNo,appFor)
						statusCode="A"
						appRemarks="Application approved.Certificate has been issued"
						if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							pendingRoleName=applicationPending.role.roleName
							certificateUrl="https://jkocmms.nic.in/applicationProcessingDetails/downLoadingCertificate1/"+applicationPending.application.id
							resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
						//////////////////
					}
				}
				}else{
					applicationProcessingDetails.approve = false
					applicationProcessingDetails.approveNote = ""
				}
				if((params.reject).equals("yes")){ 
					println("Inside reject");
					def indApp = applicationPending.application
					applicationPending.applicationStatus = "rejected"
					applicationPending.completionDate = new Date()
					applicationPending.save()
					applicationProcessingDetails.reject = true
					applicationProcessingDetails.rejectNote = params.rejectNote
////////			/ SMS CODE  ////////
					
					def appId = (indApp.id).toString()
					def oMobNo = indApp.indUser.occMobile
					def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"

					SendSms sms = new SendSms()
			//		sms.sendRejected(appId,oMobNo,appFor)
					statusCode="R"
					appRemarks="Application rejected."
						if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							pendingRoleName=applicationPending.role.roleName
							//certificateUrl="http://localhost:8080/JKPCB/applicationProcessingDetails/downloadingCertificate1/"+applicationPending.application.id
						resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
					//////////////////
				}else{
					applicationProcessingDetails.reject = false
					applicationProcessingDetails.rejectNote = ""
				}
				if(redirectBack){
					println("here in redirectBack...."+redirectBack)
					def indApp = applicationPending.application
					redirect(action:'appProcessing',params:["id":indApp.id])
					return
				}else{
					println("here in else.....redirectBack..")
					println("here in else.....redirectBack.."+applicationPending.application)
					applicationProcessingDetails.application = applicationPending.application
					
		/*			if( applicationProcessingDetails.save(flush:true) ) {*/
			
					   if(!applicationProcessingDetails.hasErrors() && applicationProcessingDetails.save(flush:true)) {
						println("here in applicationProcessingDetails.....save..")
						def noteHistiryFile11 = new ApplicationFileRecord()	
								def f1 = request.getFile('attachLetter')
								MultipartFile multi1 = request.getFile('attachLetter')
								if(!f1.empty) {
									applicationProcessingDetails.attachedFile = true
									def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachLetter' order by afr.id desc",[indAppInstance],[max:1])
									if(applicationFileRecordInstance){
										noteHistiryFile11.version =applicationFileRecordInstance[0].version+1
									}
									noteHistiryFile11.size = multi1.getSize() / 1024
									if(noteHistiryFile11.size<=6000) {
									noteHistiryFile11.size = multi1.getSize() / 1024
									noteHistiryFile11.name =multi1.getOriginalFilename()
									noteHistiryFile11.data=multi1.getBytes() 
									noteHistiryFile11.extension = extractExtension( multi1 )
									noteHistiryFile11.description="Attach other file if any"
									if(session.userMaster){
										noteHistiryFile11.createdBy=session.userMaster
										noteHistiryFile11.updatedBy=session.userMaster
									}else {
										noteHistiryFile11.createdBy=session.indUser
										noteHistiryFile11.updatedBy=session.indUser
									}
									noteHistiryFile11.typeOfFile="attachLetter"
									noteHistiryFile11.indApplication=indAppInstance  
									if(noteHistiryFile11.save(flush:true)) {
										System.out.println("Done getting other attached new file")	
									} else {
										noteHistiryFile11.errors.each {
											println it
										}
										redirect(action:'appProcessing',params:["id":indApp.id])
									}
									}
									else {
										flash.message = "Attachment File Size is More Then 5 Mb"
									    redirectBack = true
									}
								}
						def indApp = applicationPending.application
						def appId = (indApp.id).toString()
						//def days = params.clarificationDays
						def oMobNo = indApp.indUser.occMobile
						def appFor = indApp.applicationType+" ("+indApp.applicationFor+")"		
						//def IndName  = indApp.indUser.indName
						//def IndCategory = indApp.indUser.category.name
						//def empName = empUser.userProfile.employeeFirstName+" "+empUser.userProfile.employeeLastName
						//def rec = empUser.userProfile.email
						def roMobNo = empUser.userProfile.mobile
					//	SendMail mail = new SendMail()
					//	mail.sendEmployeeForward(appId,rec,appFor,empName,IndName,IndCategory)
						SendSms sms = new SendSms()
		       //      	sms.sendEmployeeForward(appId,roMobNo,appFor)
						}else{
							println("applicationProcessingDetails not saved----")
						applicationProcessingDetails.errors.allErrors.each {
							println it
						}
					}
					
					println("Testing AllSummary 3333")
					
					println("VINEET KUMAR A============"+roleFwd);
					println("VINEET KUMAR B============"+UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee));
					
					
					applicationPending.role = roleFwd
					applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
					
					println("applicationPending.role "+applicationPending.role)
					println("applicationPending.pendingWith "+applicationPending.pendingWith)
				/*	if(applicationPending.save(flush:true)){
						println("In save");
					}
					else{
						applicationPending.errors.each(){
							println it
						}
					}*/
					
					def payCheck 
					
					if (applicationPending.save(flush: true)) {

						
						if (applicationPending.completionStatus=="Complete"){
							payCheck=true;
						}
	                    println("----------------Start Seven Teen Category Data---------------------");
	                    if (applicationProcessingDetails.approve == true) {
	                    //   boolean ab = saveSvenTeenCategory(applicationProcessingDetails.application)
	                      //  println("---saveSvenTeenCategory---" + ab)
	                    }
	                    println("----------------End Seven Teen Category Data-----------------------");

	                } else {
	                    applicationPending.errors.each {
	                        println it
	                    }
	                }
					
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					println("---payCheck-----------------------"+payCheck);
					
					if(payCheck){
					
					def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(applicationPending.application.id).toString()]);
					
						   if(allSummaryReportInstance)
							{
							  
								allSummaryReportInstance.applicationStatus=applicationPending.applicationStatus
								 
								if(allSummaryReportInstance.roleId!=(applicationPending.role.id).toString())
								{
									
									def fromRole=(allSummaryReportInstance.roleName).toString();
									def toRole=(applicationPending.role.roleName).toString();
									def groupName=(applicationPending.role.group.groupName).toString();
									def forwardRemark="Application forward from "+fromRole+" to "+toRole+" in "+groupName+" group on "+sdfh.format(new Date())+".";
									appRemarks=forwardRemark
									statusCode="F"
									pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
									pendingRoleName=applicationPending.role.roleName
									if((indAppInstance.cafUniqueNo!=null) && (indAppInstance.cafUniqueNo!=""))
									{
									if((params.clarification).equals("yes")){
										appRemarks="Clarification has been raised on Application."+" | "+forwardRemark
									}else if((params.approve).equals("yes"))
									{
										certificateUrl="https://jkocmms.nic.in/applicationProcessingDetails/downLoadingCertificate1/"+applicationPending.application.id.toString();
										statusCode="A";
										appRemarks="Application approved."+" | "+forwardRemark;
										
									}else if((params.reject).equals("yes"))
									{
										
										statusCode="R";
										appRemarks="Application rejected."+" | "+forwardRemark;
										
									}else if((params.returned).equals("yes"))
									{
										
										statusCode="RBI";
										appRemarks="Application has been returned.Application is pending with Industry ,kindly check and reply."
										
									}
									
								resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
									}
										
									allSummaryReportInstance.roleId=(applicationPending.role.id).toString()
									allSummaryReportInstance.roleName=applicationPending.role.roleName
									allSummaryReportInstance.officerName=(RoleProfileAssignment.findByRole(applicationPending.role)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(applicationPending.role)).primaryEmployee.employeeLastName
									allSummaryReportInstance.pendingSince=new Date();
									allSummaryReportInstance.lastForward = sdfh.format(new Date());
									allSummaryReportInstance.pendingWith=(applicationPending.pendingWith.id).toString()
									
									applicationPending.completionDate = new Date()
									applicationPending.save();
								}
								if(applicationPending.applicationStatus=='approved' || applicationPending.applicationStatus=='rejected')
								{
									
									allSummaryReportInstance.pendingSince=new Date();
								}
								
								if(!allSummaryReportInstance.hasErrors() && allSummaryReportInstance.save(flush:true)) 
							    {
									
								 }
							    else {
								allSummaryReportInstance.errors.each {
							        println it
								   }
							    }
							}else{
								
								 //  def roleFwd=applicationPending.role
								   def indRegMasterInstance=applicationPending.application.indUser;
									def applicationDate
								    Date date1=applicationPending.application.actualApplicationDate 
								    Date date2=applicationPending.application.applicationDate
								  
								    	applicationDate=date2;
									def aPDInstance=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and officer!=? and officerFwd=? order by dateCreated desc limit 1",[applicationPending.application,applicationPending.pendingWith.id,applicationPending.pendingWith.id]);
									def aPDInstance1=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by dateCreated desc limit 1",[applicationPending.application]);
									println("aPDInstance1...nappProcessing..."+aPDInstance1)
									println("aPDInstance...nappProcessing..."+aPDInstance)
									allSummaryReportInstance=new AllSummaryReport();
									allSummaryReportInstance.applicationId=(applicationPending.application.id).toString()
									allSummaryReportInstance.indRegMasterId=(indRegMasterInstance.id).toString()
									allSummaryReportInstance.applicationName=indRegMasterInstance.indName
									allSummaryReportInstance.districtId=(indRegMasterInstance.district.id).toString()
									allSummaryReportInstance.districtName=indRegMasterInstance.district.districtName
									
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
									// new add 
										allSummaryReportInstance.indTypeId=(indRegMasterInstance.industryType.id).toString()
										allSummaryReportInstance.indTypeName=indRegMasterInstance.industryType.industryType
										allSummaryReportInstance.indCategoryId=(indRegMasterInstance.category.id).toString()
										allSummaryReportInstance.indCategoryName=indRegMasterInstance.category.name;
									
										allSummaryReportInstance.occEmail=indRegMasterInstance.occEmail
										allSummaryReportInstance.occMobile=indRegMasterInstance.occMobile
//										code added by sharvan for OCMMS dashboard start from here
										SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
										String userInput = "01/01/1950";
										Date defaulDate = formatter1.parse(userInput);
										def indUserId=IndUser.find("from IndUser where industryRegMaster.id=?",[indRegMasterInstance.id])
										
										allSummaryReportInstance.indId=indUserId.id;
										allSummaryReportInstance.clarificationRaiseDt=defaulDate;   
										allSummaryReportInstance.clarificationSubmitDt=defaulDate;
										allSummaryReportInstance.dateOfIssue=defaulDate;
										allSummaryReportInstance.dateOfexpiry=defaulDate;
										allSummaryReportInstance.indAddress=indRegMasterInstance.indAddress;
										// dashboard code ends here		
										if(aPDInstance){
											  allSummaryReportInstance.pendingSince=aPDInstance.dateCreated
											}else{
											  allSummaryReportInstance.pendingSince=applicationPending.application.actualApplicationDate	
											}
												if(applicationPending.applicationStatus=='approved' || applicationPending.applicationStatus=='rejected')
												{
													allSummaryReportInstance.pendingSince=new Date()
												}
											allSummaryReportInstance.pendingWith=(applicationPending.pendingWith).toString()
											allSummaryReportInstance.lastClarificationDate = ''
											
												if(aPDInstance1)
													allSummaryReportInstance.lastForward = sdfh.format(aPDInstance1.dateCreated);	
														else
													allSummaryReportInstance.lastForward = 'Not Forwarded'
														
										if(!allSummaryReportInstance.hasErrors() && allSummaryReportInstance.save(flush:true)) 
									{
											println("aPDInstance...nappProcessing..."+allSummaryReportInstance.lastForward)	
									}else {
										allSummaryReportInstance.errors.each {
									        println it
										}
									}
							     }	
					}
				}
				redirect(controller:'userMaster',action:'openSpcbHome')
				return;
				 
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
def openApplicationDetails = {
 try { 
	 println("params.....fdgdfgdfxg.."+params)

				def application = IndApplicationDetails.get((params.id).toLong())
				def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'asc',offset:0]) 
				def appPending = ApplicationPendingDetails.findByApplication(application)
				def applicationDate = application.actualApplicationDate
				def feeChequeAdditional=FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.additionalfee='YES'",[application])
		    	model:[applicationProcessingDetailsInstanceList:applicationProcessingDetailsInstanceList,currentPending:appPending.role,applicationDate:applicationDate,appPending:appPending,feeChequeAdditional:feeChequeAdditional]
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		     redirect(uri:'/index.gsp');
		 }
	}
	}
	
def viewClarification = {
		 try { 
				def application = IndApplicationDetails.get((params.id).toLong())
				def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'desc',offset:0]) 
				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
					if((applicationProcessingDetailsInstanceList.get(i)).clarification){
						return[appClarification:applicationProcessingDetailsInstanceList.get(i)]
					}
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	}
	}
	
def viewInspection = {
		 try { 
				def application = IndApplicationDetails.get((params.id).toLong())
				def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'desc',offset:0]) 
				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
					if((applicationProcessingDetailsInstanceList.get(i)).inspection){
						return[appInspection:applicationProcessingDetailsInstanceList.get(i)]
					}
				}
			  }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		     redirect(uri:'/index.gsp');
		 }
	   }
	}
	
	def submitClarification = {
		 try { 
				def application = IndApplicationDetails.get((params.id).toLong())
				def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'desc',offset:0]) 
				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
					if((applicationProcessingDetailsInstanceList.get(i)).clarification){
						return[appClarification:applicationProcessingDetailsInstanceList.get(i),app:application]
					}
				}
			}
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}
		
def submittedClarification = {
		 try {
			 def noteHistiryFile=new ApplicationFileRecord()
				def application = IndApplicationDetails.get((params.appId).toLong())
				String apliId = (application.id).toString()
				def appProcessing = new ApplicationProcessingDetails()
				def f = request.getFile('indClarificationFile')
				MultipartFile multi = request.getFile('indClarificationFile')
				if(!f.empty) {
					appProcessing.clarificationReplyAttachedFile=true
					def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indClarificationFile' order by afr.id desc",[application],[max:1])
					if(applicationFileRecordInstance){
						noteHistiryFile.version =applicationFileRecordInstance[0].version+1
					}
					noteHistiryFile.size = multi.getSize() / 1024
					if(noteHistiryFile.size<=6000){
					noteHistiryFile.name =multi.getOriginalFilename()
					noteHistiryFile.data=multi.getBytes() 
					noteHistiryFile.extension = extractExtension( multi )
					noteHistiryFile.description="Application Clarification Report File"
					if(session.userMaster){
						noteHistiryFile.createdBy=session.userMaster
						noteHistiryFile.updatedBy=session.userMaster
					}else {
						noteHistiryFile.createdBy=session.indUser
						noteHistiryFile.updatedBy=session.indUser
					}
					noteHistiryFile.typeOfFile="indClarificationFile"
					noteHistiryFile.indApplication=application  
					if(noteHistiryFile.save()) {
					} else {
						redirect(action:'appProcessing',params:["id":indApp.id])
					}
				}
				else {
					flash.message = "Attachment File Size is More Then 5 Mb"
				    redirectBack = true
				}
				}
				application.clarification = false
				application.save()
				appProcessing.role = RoleMaster.findByRoleName("Industry")
				appProcessing.application = application
				appProcessing.approve = false
				appProcessing.approveNote=""
				appProcessing.clarification=false
				if(params.indClarificationNote){
					appProcessing.clarificationNote= params.indClarificationNote
					appProcessing.fileNote = params.indClarificationNote
				}else{
					appProcessing.clarificationNote = ""
					appProcessing.fileNote=""
				}
				appProcessing.inspection=false
				appProcessing.inspectionClose=false
				appProcessing.inspectionCloseNote=""
				appProcessing.inspectionNote=""
				appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
				println("appProcessing.roleFwd...."+appProcessing.roleFwd)
				appProcessing.officer = "SPCB"
				appProcessing.officerFwd = "SPCB"
				appProcessing.reject = false
				appProcessing.rejectNote = ""
				appProcessing.approvalStatus = ""
						appProcessing.returnNote = ""
					if(appProcessing.save())
					{
					}
					else{
						appProcessing.errors.each {
					        println it
						}
						println("In Else")
					}
				def sdfh = new SimpleDateFormat("dd/MM/yyyy");
				def appPending=ApplicationPendingDetails.findByApplication(application)
				if((application.cafUniqueNo!=null) && (application.cafUniqueNo!="")){
        	    	Response responsePush=new Response();
        	    	String consentAppNo=application.id.toString();
        	    	String cafNo=application.cafUniqueNo
        	    	String applicationType=application.applicationType;
        	    	String applicationFor1=application.certificateFor;
        	    	String statusCode="F"
        	    	String appRemarks="Clarification Replied.Application pending with depaartment"
        	    	String pendingWith=appPending.pendingWith.userProfile.employeeFirstName+""+appPending.pendingWith.userProfile.employeeLastName
        	    	String pendingWithRole=appPending.role.roleName
        	    	String printAppUrl=""
        	    	String revertedUrl=""
        	    	String certificateUrl=""
        	    	String serviceId=application.serviceId
        	    	
        	    	responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationType,applicationFor1,statusCode,appRemarks,pendingWith,pendingWithRole,printAppUrl,revertedUrl,certificateUrl)
        	    	}
				def AllSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[apliId]);
				if(AllSummaryReportInstance)
				{
					AllSummaryReportInstance.lastClarificationDate = sdfh.format(new Date());
					AllSummaryReportInstance.clarificationSubmitDt = new Date();
					AllSummaryReportInstance.pendingSince = new Date();
					AllSummaryReportInstance.save();
				}
				flash.message = "Clarification Submitted"
				redirect(action:popClose)
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def popClose = {
		
	}
	
	def ctoCertificate={
		 try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}
				render(view:'ctoCertificate',model:[viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	   }
	}
	
	def certificate = {
		 try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				indRegInstance.refresh()
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}
				 def recordCertificateInstance = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				render(view:'certificate',model:[recordCertificateInstance:recordCertificateInstance,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def pdf = {
		 try { 
				File certFile
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def officeAddress=params.offAddres
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
				def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
				def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
				def indCategory=(indRegInstance.category.name).toUpperCase()
				def id = (indApplicationDetailsInstance.id).toString()
				def indNewCapInvt = indRegInstance.indCapInvt.toString()
				def id3=indApplicationDetailsInstance.indUser 
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray = new String[sizeVal] 
				for(int i=0; i<conditionMasterList.size();i++) {
					conditionArray[i]=(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG = new String[sizeValG] 
				for(int i=0; i<conditionMasterListG.size();i++) {
					conditionArrayG[i]=(conditionMasterListG.get(i)).condition
				}
				def referenceCheck=params.references
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize] 
				def referenceStore=""
				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
				}
				def dateCreateOn=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateCreateOn
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
				def dDate=new Date()
				def abcFinal=dDate
				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				def val=params.pdfc
				def val2=params.pdfc2
				def val3=params.pdfc3
				DevImg dimg=new DevImg()
				def name=indRegInstance.indName
				def address=indRegInstance.indAddress
				def tehsil1=indRegInstance.tehsil.toString()
				def indCity = indRegInstance.indCity
				def pin =indRegInstance.indPin
				def district=(indRegInstance.district).toString()
				def fileN=params.fileNo
				def order="40001"
				def videNo="980"
				def subject=params.subject
				PdfGeneration pdfG=new PdfGeneration()
				def sCondition=params.specificConditions
				def gCondition=params.generalConditions
				def indusName = indRegInstance.indName
				def indAddress = indRegInstance.indAddress
				def occName = indRegInstance.occName
				def occAddress=indRegInstance.occAddress
				def category=indRegInstance.category.name 
				def regId = indRegInstance.indRegNum
				def regDate = indRegInstance.regDate
				def dfh = new SimpleDateFormat("dd/MM/yyyy"); 
				regDate= dfh.format((java.util.Date) regDate)
				def productDetailsList = new ArrayList()
				def productDetailsInstance=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
				int c = 1
				for(int var10=1;var10<productDetailsInstance.size();var10++)
				{
					def productList= new ArrayList()
					String s = Integer.toString(c)
					productList.add(s)
					productList.add(productDetailsInstance.get(var10).product)
					productList.add(productDetailsInstance.get(var10).byProduct)
					productList.add(productDetailsInstance.get(var10).quantity)
					productList.add(productDetailsInstance.get(var10).unit.unitName)
					productDetailsList.add(productList)
					c++
				}
			def productDetailsList1 = new ArrayList()
				def productDetailsInstance1=CosentCertProductDetails.findAllByApplication(indApplicationDetailsInstance)
			int cc = 1
				for(int var10=0;var10<productDetailsInstance1.size();var10++)
				{
					def productList1= new ArrayList()
					String s = Integer.toString(cc)
					productList1.add(s)
					productList1.add(productDetailsInstance1.get(var10).product)
					productList1.add(productDetailsInstance1.get(var10).quantity)
					productList1.add(productDetailsInstance1.get(var10).unit.unitName)
					productDetailsList1.add(productList1)
					cc++
				}
			def qualityParameterDetailsList1 = new ArrayList()
				def qualityParameterDetailsList2 = new ArrayList()
			def qualityParameterDetailInstance1=ConsentCertEffluentQualityParameter.findAllByApplication(indApplicationDetailsInstance)
				for(int var10=0;var10<qualityParameterDetailInstance1.size();var10++)
				{
					def qualityParamDetailList= new ArrayList()
					def qualityParamDetailList1= new ArrayList()
					if(qualityParameterDetailInstance1.get(var10).treatmentType.equals("Treatment")){
						qualityParamDetailList.add(qualityParameterDetailInstance1.get(var10).qualityParam)
						qualityParamDetailList.add(qualityParameterDetailInstance1.get(var10).range)
						qualityParamDetailList.add(qualityParameterDetailInstance1.get(var10).standardValue)
						qualityParameterDetailsList1.add(qualityParamDetailList)
					}else{
						qualityParamDetailList1.add(qualityParameterDetailInstance1.get(var10).qualityParam)
						qualityParamDetailList1.add(qualityParameterDetailInstance1.get(var10).range)
						qualityParamDetailList1.add(qualityParameterDetailInstance1.get(var10).standardValue)
						qualityParameterDetailsList2.add(qualityParamDetailList1)
					}
				}	
	
////////////////////////////////Air Quality Parameter Details///////////////////////////////////////////////	
def airParameterQualityDetailsList1 = new ArrayList()
				def airParameterQualityDetailsInstance1=ConsentCertAirQualityParameter.findAllByApplication(indApplicationDetailsInstance)
				int ccc = 1
				for(int var10=0;var10<airParameterQualityDetailsInstance1.size();var10++)
				{
					def airParameterQualityDetailsList= new ArrayList()
					String s = Integer.toString(ccc)
					airParameterQualityDetailsList.add(s)
					airParameterQualityDetailsList.add(airParameterQualityDetailsInstance1.get(var10).qualityParameter)
					airParameterQualityDetailsList.add(airParameterQualityDetailsInstance1.get(var10).range)
					airParameterQualityDetailsList.add(airParameterQualityDetailsInstance1.get(var10).standardValue)
					airParameterQualityDetailsList1.add(airParameterQualityDetailsList)
					ccc++
				}
////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
def stackDetailsList = new ArrayList()
			def stackDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
				int cccc = 1
						for(int var10=0;var10<stackDetailsInstance.size();var10++)
							{
							def stackList= new ArrayList()
							String s = Integer.toString(cccc)
							stackList.add(s)
							stackList.add(stackDetailsInstance.get(var10).stackAttachedTo)
							stackList.add(stackDetailsInstance.get(var10).stackVolume)
							stackList.add(stackDetailsInstance.get(var10).stackHeight)
							stackList.add(stackDetailsInstance.get(var10).topDiameter)
							stackList.add(stackDetailsInstance.get(var10).velocityOfGasEmission)
							stackDetailsList.add(stackList)
							cccc++
							}
////////////////////////////////Fuel Details///////////////////////////////////////////////	
	def fuelDetailsList = new ArrayList()
		def fuelDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
							int ccccc = 1
							for(int var10=0;var10<fuelDetailsInstance.size();var10++)
							{
							def fuelDetailsList1= new ArrayList()
							String s = Integer.toString(ccccc)
							fuelDetailsList1.add(s)
							fuelDetailsList1.add(fuelDetailsInstance.get(var10).typeOfFuel)
							fuelDetailsList1.add(fuelDetailsInstance.get(var10).maximumQuantity)
							fuelDetailsList1.add(fuelDetailsInstance.get(var10).unit.unitName)
							fuelDetailsList.add(fuelDetailsList1)
							ccccc++
							}
////////////////////////////////Solid Waste Disposal Details///////////////////////////////////////////////	
def solidWasteDisposalDetailsList1 = new ArrayList()
				def solidWasteDisposalDetailsInstance1=CosentCertSolidWasteDisposalDetails.findAllByApplication(indApplicationDetailsInstance)
					int cs = 1
					for(int var10=0;var10<solidWasteDisposalDetailsInstance1.size();var10++){
							def solidWasteDisposalDetailsList= new ArrayList()
								String s = Integer.toString(cs)
								solidWasteDisposalDetailsList.add(s)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).typeofWaste)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).quantity)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).disMode.disposalMode)
								solidWasteDisposalDetailsList1.add(solidWasteDisposalDetailsList)
								cs++
							}
		
				def copyTo=params.copyTo 
				def fileNumberIn=params.fileNumber
				def endtNumberIn=params.endtNumber
				def offDistrict=params.nameOfDistrict
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def maxQuantity=params.maxQuantity
				def checkDate
				def x
				def y
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					checkDate="checked"
				}
				catch(Exception e) {
					flash.message="Enter Both The Consent Granted Dates "
					render(view:'certificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
				}
				if(checkDate) {
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					if(sqlDate>sqlDate2) {
						flash.message="Grant To Date should be Greater than Grant From Date"
						render(view:'certificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}else {
						 def recordCertificate = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
						 def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
						if(recordCertificate)
							{
							recordCertificate.delete()
							}
						 if(filerecordinstance)
						 {
							 filerecordinstance.delete();
						 }
						recordCertificateInstance.startDate=sqlDate
						recordCertificateInstance.endDate=sqlDate2
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.generalCondition=gCondition
						recordCertificateInstance.specificCondition=sCondition
						recordCertificateInstance.subjectData=params.subject
						recordCertificateInstance.refData=referenceStore
						recordCertificateInstance.maxQuantity=maxQuantity
						recordCertificateInstance.copyTo=copyTo
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunction(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,indNewCapInvt,productDetailsList,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,officeAddress,indCity,pin,tehsil1,district,applType,maxQuantity,productDetailsList1,qualityParameterDetailsList1,qualityParameterDetailsList2,solidWasteDisposalDetailsList1,airParameterQualityDetailsList1,stackDetailsList,fuelDetailsList)
							}else{
								certFile=pdfG.pdfFunctionArray(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,indNewCapInvt,productDetailsList,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,officeAddress,indCity,pin,tehsil1,district,applType,maxQuantity,productDetailsList1,qualityParameterDetailsList1,qualityParameterDetailsList2,solidWasteDisposalDetailsList1,airParameterQualityDetailsList1,stackDetailsList,fuelDetailsList)
							}
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
								redirect(action:appProcessing,params:["id":params.idIndApp])
							} else {
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
								render(view:'certificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
						}
						else {
							render(view:'certificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}
					}
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
		
	def pdfCto={
		 try { 
				File certFile
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def officeAddress=params.offAddres
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
				def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
				def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
				def indCategory=(indRegInstance.category.name).toUpperCase()
				def id3=indApplicationDetailsInstance.indUser 
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray = new String[sizeVal] 
				for(int i=0; i<conditionMasterList.size();i++) {
					conditionArray[i]=(conditionMasterList.get(i)).condition	
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG = new String[sizeValG] 
				for(int i=0; i<conditionMasterListG.size();i++) {
					conditionArrayG[i]=(conditionMasterListG.get(i)).condition
				}
				def referenceCheck=params.references
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize] 
				def referenceStore=""
				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
				}
				def dateCreateOn=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateCreateOn
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
				def dDate=new Date()
				def abcFinal=dDate
				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				def val=params.pdfc
				def val2=params.pdfc2
				def val3=params.pdfc3
				DevImg dimg=new DevImg()
				def name=indRegInstance.indName
				def address=indRegInstance.indAddress
				def tehsil1=indRegInstance.tehsil.toString()
				def district=(indRegInstance.district).toString()
				def fileN=params.fileNo
				def order="40001"
				def videNo="980"
				def subject=params.subject
				CtoPdfGeneration pdfG=new CtoPdfGeneration()
				def sCondition=params.specificConditions
				def gCondition=params.generalConditions
				def productD=params.product
				def productQ=params.productCapacity
				def certificateData=params.certificateBody
				def copyTo=params.copyTo 
				def fileNumberIn=params.fileNumber
				def endtNumberIn=params.endtNumber
				def offDistrict=params.nameOfDistrict
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def checkDate
				def x
				def y
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					checkDate="checked"
				}
				catch(Exception e) {
					flash.message="Enter Both The Consent Granted Dates "
					render(view:'certificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
				}
				if(checkDate) {
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					if(sqlDate>sqlDate2) {
						flash.message="Grant To Date should be Greater than Grant From Date"
						render(view:'ctoCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}else {
						recordCertificateInstance.startDate=sqlDate
						recordCertificateInstance.endDate=sqlDate2
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.generalCondition=gCondition
						recordCertificateInstance.specificCondition=sCondition
						if(params.subject){
							recordCertificateInstance.subjectData=params.subject
						}else{
							recordCertificateInstance.subjectData="subject fixed"
						}
						recordCertificateInstance.refData=referenceStore
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunction(endtNumberIn,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referenceCheck,name,address,tehsil1,district,gCondition,sCondition,copyTo)
							}else{
								certFile=pdfG.pdfFunctionArray(endtNumberIn,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referencesArray,name,address,tehsil1,district,gCondition,sCondition,copyTo)
							}
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
								if(certFile){
									certFile.delete()
								}
							} else {
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
								render(view:'ctocertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
							redirect(action:appProcessing,params:["id":params.idIndApp])
						}
						else {
							render(view:'ctoCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}
					}
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	  }
	}

	def ctoRenewalCertificate={
		 try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				render(view:'ctoRenewalCertificate',model:[viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	 }
	}

	def ctoWaterRenewalCertificate={
		 try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				render(view:'ctoWaterRenewalCertificate',model:[viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def pdfWaterCtoRenew={
		 try {
			 println("params..."+params)
				File certFile
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def officeAddress=params.offAddres
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
				def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
				def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
				def indCategory=(indRegInstance.category.name).toUpperCase()
				def id3=indApplicationDetailsInstance.indUser 
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray = new String[sizeVal] 
				for(int i=0; i<conditionMasterList.size();i++) {
					conditionArray[i]=(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG = new String[sizeValG] 
				for(int i=0; i<conditionMasterListG.size();i++) {
					conditionArrayG[i]=(conditionMasterListG.get(i)).condition
				}
				def referenceCheck=params.references
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize] 
				def referenceStore=""
				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				def dateCreateOn=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateCreateOn
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
				def dDate=new Date()
				def abcFinal=dDate
				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				def val=params.pdfc
				def val2=params.pdfc2
				def val3=params.pdfc3
				DevImg dimg=new DevImg()
				def name=indRegInstance.indName
				def address=indRegInstance.indAddress
				def tehsil1=indRegInstance.tehsil.toString()
				def district=(indRegInstance.district).toString()
				def fileN=params.fileNo
				def order="40001"
				def videNo="980"
				def subject=params.subject
				CtoWaterRenewalPdfGeneration pdfwater=new CtoWaterRenewalPdfGeneration()
				def sCondition=params.specificConditions
				def gCondition=params.generalConditions
				def productD=params.product
				def productQ=params.productCapacity
				def additionalCondition=params.otherConditions
				def certificateData=params.certificateBody
				def copyTo=""
				def fileNumberIn=params.fileNumber 
				def endtNumberIn=params.endtNumber
				def offDistrict=params.nameOfDistrict
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def maxQuantity=""
				def checkDate
				def x
				def y
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					checkDate="checked"
				}
				catch(Exception e) {
					flash.message="Enter Both The Consent Granted Dates "
					render(view:'ctoWaterRenewalCertificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
				}
				if(checkDate) {
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					if(sqlDate>sqlDate2) {
						flash.message="Grant To Date should be Greater than Grant From Date"
						render(view:'ctoWaterRenewalCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}else {
						def recordCertificate = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
						  def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
								if(recordCertificate)
										{
										recordCertificate.delete()
										}
							 if(filerecordinstance)
								 {
									 filerecordinstance.delete();
								 }
						recordCertificateInstance.startDate=sqlDate
						recordCertificateInstance.endDate=sqlDate2
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						if(params.generalConditions){
							recordCertificateInstance.generalCondition=gCondition
						}else{
							recordCertificateInstance.generalCondition="No condition"
						}
						if(params.specificConditions){
							recordCertificateInstance.specificCondition=sCondition
						}else{
							recordCertificateInstance.specificCondition="No condition"
						}
					if(params.subject){
							recordCertificateInstance.subjectData=params.subject
						}else{
							recordCertificateInstance.subjectData="subject fixed"
						}
						recordCertificateInstance.refData=referenceStore
						recordCertificateInstance.copyTo=copyTo
						recordCertificateInstance.maxQuantity=maxQuantity
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfwater.pdfFunction(endtNumberIn,startDate1,endDate1,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referenceCheck,name,address,tehsil1,district,additionalCondition,copyTo)
							}else{
								certFile=pdfwater.pdfFunctionArray(endtNumberIn,startDate1,endDate1,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referencesArray,name,address,tehsil1,district,additionalCondition,copyTo)
							}
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
								if(certFile){
									certFile.delete()
								}
							} else {
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
									render(view:'ctoWaterRenewalCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
							redirect(action:appProcessing,params:["id":params.idIndApp])
											}
						else {
							recordCertificateInstance.errors.each{
								println it
							}
							render(view:'ctoWaterRenewalCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}
								}			
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		     redirect(uri:'/index.gsp');
		 }
	   }
	}
		
	def pdfCtoRenew={
		 try {
				File certFile
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def officeAddress=params.offAddres
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
				def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
				def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
				def indCategory=(indRegInstance.category.name).toUpperCase()
				def id3=indApplicationDetailsInstance.indUser 
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray = new String[sizeVal] 
				for(int i=0; i<conditionMasterList.size();i++) {
					conditionArray[i]=(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG = new String[sizeValG] 
				for(int i=0; i<conditionMasterListG.size();i++) {
					conditionArrayG[i]=(conditionMasterListG.get(i)).condition
				}
				def referenceCheck=params.references
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize] 
				def referenceStore=""
				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				def dateCreateOn=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateCreateOn
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
				def dDate=new Date()
				def abcFinal=dDate
				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				def val=params.pdfc
				def val2=params.pdfc2
				def val3=params.pdfc3
				DevImg dimg=new DevImg()
				def name=indRegInstance.indName
				def address=indRegInstance.indAddress
				def tehsil1=indRegInstance.tehsil.toString()
				def district=(indRegInstance.district).toString()
				def fileN=params.fileNo
				def order="40001"
				def videNo="980"
				def subject=params.subject
				CtoAirRenewalPdfGeneration pdfG=new CtoAirRenewalPdfGeneration()
				def sCondition=params.specificConditions
				def gCondition=params.generalConditions
				def productD=params.product
				def productQ=params.productCapacity
				def additionalCondition=params.otherConditions
				def certificateData=params.certificateBody
				def copyTo=params.copyTo 
				def fileNumberIn=params.fileNumber
				def endtNumberIn=params.endtNumber
				def offDistrict=params.nameOfDistrict
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def maxQuantity=""
				def checkDate
				def x
				def y
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					checkDate="checked"
				}
				catch(Exception e) {
					flash.message="Enter Both The Consent Granted Dates "
					render(view:'ctoRenewalCertificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
				}
				if(checkDate) {
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					if(sqlDate>sqlDate2) {
						flash.message="Grant To Date should be Greater than Grant From Date"
						render(view:'ctoRenewalCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}else {
						def recordCertificate = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
						  def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
								if(recordCertificate)
										{
										recordCertificate.delete()
										}
							 if(filerecordinstance)
								 {
									 filerecordinstance.delete();
								 }
						recordCertificateInstance.startDate=sqlDate
						recordCertificateInstance.endDate=sqlDate2
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						if(params.generalConditions){
							recordCertificateInstance.generalCondition=gCondition
						}else{
							recordCertificateInstance.generalCondition="No condition"
						}
						if(params.specificConditions){
							recordCertificateInstance.specificCondition=sCondition
						}else{
							recordCertificateInstance.specificCondition="No condition"
						}
						if(params.subject){
							recordCertificateInstance.subjectData=params.subject
						}else{
							recordCertificateInstance.subjectData="subject fixed"
						}
						recordCertificateInstance.refData=referenceStore
						recordCertificateInstance.copyTo=copyTo
						recordCertificateInstance.maxQuantity=maxQuantity
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunction(endtNumberIn,startDate1,endDate1,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referenceCheck,name,address,tehsil1,district,additionalCondition,copyTo)
							}else{
								certFile=pdfG.pdfFunctionArray(endtNumberIn,startDate1,endDate1,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referencesArray,name,address,tehsil1,district,additionalCondition,copyTo)
							}
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
								if(certFile){
									certFile.delete()
								}
							} else {
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
								render(view:'ctoRenewalCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
							redirect(action:appProcessing,params:["id":params.idIndApp])
						}
						else {
							render(view:'ctoRenewalCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}
					}
				}
			}catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}

	def extractExtension( MultipartFile file ) {
		 try {
				String filename = file.getOriginalFilename()
				return filename.substring(filename.lastIndexOf( "." ) + 1 )
			}catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def downLoadingCertificate={
			 try {
					def appId=IndApplicationDetails.get((params.id).toLong())
					def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate' order by afr.dateCreated desc",[appId],[max:1])
					println("fileDownLoad.downLoadingCertificate."+fileDownLoad)
					def fileSingle=fileDownLoad.get(0);
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
				 }catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			      redirect(uri:'/index.gsp');
			 }
	  }
	}
	
	def downLoadingAuthorization={
			 try {
					def appId=IndApplicationDetails.get((params.id).toLong())
					def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Authorization' order by afr.dateCreated desc",[appId],[max:1])
					println("fileDownLoad.downLoadingAuthorization."+fileDownLoad)
					def fileSingle=fileDownLoad.get(0);
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
				 }catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			      redirect(uri:'/index.gsp');
			 }
	  }
	}
	
	def viewR_CertificatePdf={
			 try {
					def appId=IndApplicationDetails.get((params.id).toLong())
					def fileDownLoad =ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3' order by afr.lastUpdated desc",[appId],[max:1])
					def fileSingle=fileDownLoad.get(0);
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			   redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			          redirect(uri:'/index.gsp');
			 }
		 }
	}
	def viewR4_CertificatePdf={
			 try {
					def appId=IndApplicationDetails.get((params.id).toLong())
					def fileDownLoad =ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4' order by afr.lastUpdated desc",[appId],[max:1])
					def fileSingle=fileDownLoad.get(0);
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			       redirect(uri:'/index.gsp');
			 }
		  }
	}
	
	def viewFile = {
			 try {
					def fileVer=(params.verValue).toLong()
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Inspection Report'and afr.version=? order by id desc",[application,fileVer],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			          redirect(uri:'/index.gsp');
			 }
			   }
	}
	
	def viewFileClarification = {
			 try {
					def fileVer=(params.verValue).toLong()
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indClarificationFile'and afr.version=?",[application,fileVer],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			   redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			         session.invalidate()
			      redirect(uri:'/index.gsp');
			 }
		 }
	}
	
	def viewClarificationDocument={
			 try {
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def type=params.docName
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile=? order by afr.dateCreated desc",[application,type],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
						response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
		 }
	}
	
	def viewClarificationReportIndustry={
			 try {
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def type=params.docName
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile=? order by afr.dateCreated desc",[application,type],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
//////////////Start/////////Vivek//////////////////////////
	def viewOtherAttachedDocument={
			 try {
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def type=params.docName
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile=? order by afr.dateCreated desc",[application,type],[max:1])
					println("----applicationFileInstance----"+applicationFileInstance.size())
					def applicationFileSingleInstance=applicationFileInstance[0]
					if(applicationFileSingleInstance==null){
						flash.message = "File not Attached by SPCB Officer"
						redirect(action:appProcessing,params:["id":params.appliLoc])
					}else{
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
					}
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		 redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	//-------------for Note Histrory-------------//
	def viewOtherAttachedDocument1={
			 try {
				    println("------created date---"+params.appliLoc)
				   
				    def appId=params.appliLoc.toLong()
				      println("------created date---"+appId)
					//def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def type=params.docName
					 println("------created date---"+type)
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where id=? and afr.typeOfFile=? order by afr.dateCreated desc",[appId,type])
					println("----applicationFileInstance----"+applicationFileInstance.size())
					def createdDate=applicationFileInstance[0].dateCreated
					def applicationFileSingleInstance=applicationFileInstance[0]
					if(applicationFileSingleInstance==null){
						flash.message = "File not Attached by SPCB Officer"
						redirect(action:appProcessing,params:["id":params.appliLoc])
					}else{
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
					}
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		 redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	
	
	
	}
	
	//--------------------End---------------------//
	
	def viewOtherAttachedFile = {
			 try {
				 	def fileVer=(params.verValue).toLong()
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachLetter'and afr.version=?",[application,fileVer],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	 }
	}
	//////////////////End/////////////////////Vivek////////////////////////
	def viewFile1 = {
			 try {
					def fileVer=(params.verValue).toLong()
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def applicationFileInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachedClarificationReport'and afr.version=?",[application,fileVer],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			       redirect(uri:'/index.gsp');
			 }
		  }
	}
		
	def viewFile2 = {
			 try {
					def fileVer=(params.verValue).toLong()
					def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def applicationFileInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachedInspectionReport'and afr.version=?",[application,fileVer],[max:1])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )			
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			            redirect(uri:'/index.gsp');
			 }
	 }
	}
		
	def ctoWaterCertificate = {
			 try {
					def idAppl= (params.appliId).toLong()
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					def roleHeader=app.role.roleName
					def indRegInstance=indApplicationDetailsInstance.indUser
					indRegInstance.refresh()
					def teh=indRegInstance.tehsil
					def dis=indRegInstance.district
					def dateSql=indApplicationDetailsInstance.applicationDate
					def abcFinal1=dateSql
					DateCustom dd1=new DateCustom()
					def dateCreated= (dd1.sQLdate1(abcFinal1))
					def yr=(dateCreated.getYear()).toInteger()+1900
					def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
					def dat=(indApplicationDetailsInstance.applicationDate).getDate()
					def abc=(indApplicationDetailsInstance.id).toString()
					def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
					def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
					def id2=indApplicationDetailsInstance.applicationType
					def consentForVar=indApplicationDetailsInstance.certificateFor
					def applicationForVar=indApplicationDetailsInstance.applicationFor
					def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
					def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
					def sizeVal=conditionMasterList.size()
					def conditionArray =""
					for(int i=0; i<conditionMasterList.size();i++) {
						int srNo=i+1;
						conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
					}
					def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
					def sizeValG=conditionMasterListG.size()
					def conditionArrayG =""
					for(int i=0; i<conditionMasterListG.size();i++) {
						int srNo=i+1;
						conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
					}
					def viewCert = false
					def viewR_Certificate = false
					def viewR4_Certificate = false
					def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
					if(certInst){
						viewCert = true
					}
					def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
					if(r_cert){
						viewR_Certificate=true
					}
					def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
					if(r4_cert){
						viewR4_Certificate=true
					}
					render(view:'ctoWaterCertificate',model:[viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			         redirect(uri:'/index.gsp');
			 }
		 }
	}
	
	def pdfCtoWater={
			 try {
					File certFile
					ApplicationFileRecord file=new ApplicationFileRecord()
					def recordCertificateInstance=new RecordCertificate()
					def appID=params.idIndApp
					def officeAddress=params.offAddres
					def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
					def indRegInstance=indApplicationDetailsInstance.indUser
					def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
					def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
					def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
					def indCategory=(indRegInstance.category.name).toUpperCase()
					def id3=indApplicationDetailsInstance.indUser 
					def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
					def id2=indApplicationDetailsInstance.applicationType
					def consentForVar=indApplicationDetailsInstance.certificateFor
					def applicationForVar=indApplicationDetailsInstance.applicationFor
					def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
					def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
					def sizeVal=conditionMasterList.size()
					def conditionArray = new String[sizeVal] 
					for(int i=0; i<conditionMasterList.size();i++) {
						conditionArray[i]=(conditionMasterList.get(i)).condition
					}
					def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
					def sizeValG=conditionMasterListG.size()
					def conditionArrayG = new String[sizeValG] 
					for(int i=0; i<conditionMasterListG.size();i++) {
						conditionArrayG[i]=(conditionMasterListG.get(i)).condition
					}
					def referenceCheck=params.references
					def refSize=referenceCheck.size()
					def referencesArray = new String[refSize] 
					def referenceStore=""
					if(referenceCheck.getClass().getName()=="java.lang.String") {
						referenceStore="1. "+referenceCheck
					}else{
						for(int varI=0; varI<referenceCheck.size();varI++) {
							int varInteger=varI+1
							referencesArray[varI]=referenceCheck[varI]
							referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
						}
					}
					for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
					}
					def dateCreateOn=indApplicationDetailsInstance.applicationDate
					def abcFinal1=dateCreateOn
					DateCustom dd1=new DateCustom()
					def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
					def dDate=new Date()
					def abcFinal=dDate
					DateCustom dd=new DateCustom()
					def todayDate= (dd.sQLdate1(abcFinal)).toString()
					def val=params.pdfc
					def val2=params.pdfc2
					def val3=params.pdfc3
					DevImg dimg=new DevImg()
					def name=indRegInstance.indName
					def address=indRegInstance.indAddress
					def tehsil1=indRegInstance.tehsil.toString()
					def district=(indRegInstance.district).toString()
					def fileN=params.fileNo
					def order="40001"
					def videNo="980"
					def subject=params.subject
					CtoWaterPdfGeneration pdfG=new CtoWaterPdfGeneration()
					def sCondition=params.specificConditions
					def gCondition=params.generalConditions
					def productD=params.product
					def productQ=params.productCapacity
					def certificateData=params.certificateBody
					def copyTo=params.copyTo 
					def fileNumberIn=params.fileNumber 
					def endtNumberIn=params.endtNumber
					def offDistrict=params.nameOfDistrict
					def draftDate=params.draftLetterDate_value
					def startDate1=params.grantedFrom_value
					def endDate1=params.grantedTo_value
					def maxQuantity=""
					def checkDate
					def x
					def y
					try {
						def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
						x = sdfh.parse(startDate1); //Date
						y = sdfh.parse(endDate1);
						checkDate="checked"
					}
					catch(Exception e) {
						flash.message="Enter Both The Consent Granted Dates "
						render(view:'certificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
					}
					if(checkDate) {
						java.sql.Date sqlDate = new java.sql.Date(x.getTime())
						java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
						if(sqlDate>sqlDate2) {
							flash.message="Grant To Date should be Greater than Grant From Date"
							render(view:'ctoCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}else {
							recordCertificateInstance.startDate=sqlDate
							recordCertificateInstance.endDate=sqlDate2
							recordCertificateInstance.updatedBy=session.userMaster
							recordCertificateInstance.createdBy=session.userMaster
							recordCertificateInstance.generalCondition=gCondition
							recordCertificateInstance.specificCondition=sCondition
							recordCertificateInstance.maxQuantity=maxQuantity
							recordCertificateInstance.copyTo=copyTo
							if(params.subject){
								recordCertificateInstance.subjectData=params.subject
							}else{
								recordCertificateInstance.subjectData="subject fixed"
							}
							recordCertificateInstance.refData=referenceStore
							recordCertificateInstance.applicationId=indApplicationDetailsInstance
							def recordCertificate = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
							def filerecordinstance=	ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
								if(recordCertificate)
									{
									recordCertificate.delete()
									}
								 if(filerecordinstance)
								 {
									 filerecordinstance.delete();
								 }
							if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
								flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
								if(referenceCheck.getClass().getName()=="java.lang.String") {
									certFile=pdfG.pdfFunction(endtNumberIn,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referenceCheck,name,address,tehsil1,district,gCondition,sCondition,copyTo)
								}else{
									certFile=pdfG.pdfFunctionArray(endtNumberIn,productD,productQ,certificateData,fileNumberIn,offDistrict,draftDate,officeAddress,referencesArray,name,address,tehsil1,district,gCondition,sCondition,copyTo)
								}
								def link="link"
								byte[] b = new byte[(int) certFile.length()];
								FileInputStream fileInputStream = new FileInputStream(certFile);
								fileInputStream.read(b);
								def fileLength=certFile.length()
								file.size = fileLength / 1024  //f.getSize() 
								file.extension ="pdf"//extractExtension( f )
								file.data=b;
								file.name="CertiFicate.pdf"
								file.description="Certificate Generation Record"
								file.createdBy=session.userMaster
								file.updatedBy=session.userMaster
								file.typeOfFile="Certificate"
								file.indApplication=indApplicationDetailsInstance
								if(file.save()) {
									if(certFile){
										certFile.delete()
									}
								} else {
									flash.userMessage = "File [${file.name}] has NOT not been uploaded."
									render(view:'ctocertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
								}
								redirect(action:appProcessing,params:["id":params.idIndApp])
							}
							else {
								render(view:'ctoCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
							}
								}
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
		  }
	}
		
	def reportThree = {
			 try {
					def idAppl= (params.appliId).toLong()
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					def viewCert = false
					def viewR_Certificate = false
					def viewR4_Certificate = false
					def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
					if(certInst){
						viewCert = true
					}
					def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
					if(r_cert){
						viewR_Certificate=true
					}
					def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
					if(r4_cert){
						viewR4_Certificate=true
					}
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					def roleHeader=app.role.roleName
					def indRegInstance=indApplicationDetailsInstance.indUser
					indRegInstance.refresh()
					def teh=indRegInstance.tehsil
					def dis=indRegInstance.district
					def applicationReceiptDate=indApplicationDetailsInstance.applicationDate
					def investment=indRegInstance.indCapInvt
					render(view:'R3',model:[roleHeader:roleHeader,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,applicationReceiptDate:applicationReceiptDate,investment:investment])	
				  }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			       redirect(uri:'/index.gsp');
			 }
		   }
	}
	
	def r3Pdf={
			 try {
					File fileStore
					ApplicationFileRecord file=new ApplicationFileRecord()
					def indApplicationDetailsInstance=IndApplicationDetails.get((params.applicationId).toLong())
					def indRegInstance=indApplicationDetailsInstance.indUser
					def industryName=indRegInstance.indName+""
					def industryAddress=indRegInstance.indAddress+""
					def industryLocation=indRegInstance.indCity+""
					def industryInvest=indRegInstance.indCapInvt+""
					def codeNumber=params.codeNumb
					def applicationNumber=params.appliNumber
					def applicationRecieptDate=params.appReceiptDate_value
					def draftLetterDate=params.draftLetterDate_value
					def grantedFrom=params.grantedFrom_value
					def grantedTo=params.grantedTo_value
					def phBefore=params.phBefore
					def phAfter=params.phAfter
					def bodBefore=params.bodBefore
					def bodAfter=params.bodAfter
					def codBefore=params.codBefore
					def codAfter=params.codAfter
					def ssBefore=params.ssBefore
					def ssAfter=params.ssAfter
					def otherBefore=params.otherBefore
					def otherAfter=params.otherAfter
					def sourceWater=params.sourceWater
					def dateStartProduction=params.dateStartProduction_value
					def specialCondition=params.specialCondition
					def productRaw=params.product
					def productCapacityRaw=params.productCap
					def waterConsumptionRaw=params.waterCon
					def waterWasteRaw=params.wasteWater
					def productArraySize=productRaw.size()
					def productArray = new String[productArraySize]
					def productCapacityArray = new String[productArraySize]
					def waterConsumptionArray = new String[productArraySize]
					def wasteWaterArray = new String[productArraySize]
					if(productRaw.getClass().getName()=="java.lang.String"){
					}else{
						for(int var=0;var<productArraySize;var++ ){
							productArray[var]=productRaw[var]
							productCapacityArray[var]=productCapacityRaw[var]
							waterConsumptionArray[var]=waterConsumptionRaw[var]
							wasteWaterArray[var]=waterWasteRaw[var]
						}
					}
					Rpdf3 r3Instance=new Rpdf3();
					if(productRaw.getClass().getName()=="java.lang.String"){
						fileStore=r3Instance.pdfGenerationS(codeNumber,waterWasteRaw,waterConsumptionRaw,productCapacityRaw,productRaw,specialCondition,dateStartProduction,sourceWater,otherAfter,otherBefore,ssAfter,ssBefore,codAfter,codBefore,bodAfter,bodBefore,phAfter,phBefore,grantedTo,grantedFrom,draftLetterDate,applicationNumber,applicationRecieptDate,industryName,industryAddress,industryLocation,industryInvest)
					}else{
						fileStore=r3Instance.pdfGenerationArray(codeNumber,wasteWaterArray,waterConsumptionArray,productCapacityArray,productArray,specialCondition,dateStartProduction,sourceWater,otherAfter,otherBefore,ssAfter,ssBefore,codAfter,codBefore,bodAfter,bodBefore,phAfter,phBefore,grantedTo,grantedFrom,draftLetterDate,applicationNumber,applicationRecieptDate,industryName,industryAddress,industryLocation,industryInvest)
					}
					byte[] b = new byte[(int) fileStore.length()];
					FileInputStream fileInputStream = new FileInputStream(fileStore);
					fileInputStream.read(b);
					def fileLength=fileStore.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.name="R3.pdf"
					file.description="Certificate Generation Record"
					file.createdBy=session.userMaster
					file.updatedBy=session.userMaster
					file.typeOfFile="R3"
					file.indApplication=indApplicationDetailsInstance
					if(file.save()) {
						flash.message="R-3 Prepared."
						redirect(action:appProcessing,params:["id":params.applicationId])
					} else {
						flash.userMessage = "R3 not prepared."
					render(view:'R3',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance])
					}
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
		 }
	}
	
	def reportFour={
			 try {
					def idAppl= (params.appliId).toLong()
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					def roleHeader=app.role.roleName
					def indRegInstance=indApplicationDetailsInstance.indUser
					indRegInstance.refresh()
					def teh=indRegInstance.tehsil
					def dis=indRegInstance.district
					def applicationReceiptDate=indApplicationDetailsInstance.applicationDate
					def investment=indRegInstance.indCapInvt
					def viewCert = false
					def viewR_Certificate = false
					def viewR4_Certificate = false
					def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
					if(certInst){
						viewCert = true
					}
					def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
					if(r_cert){
						viewR_Certificate=true
					}
					def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
					if(r4_cert){
						viewR4_Certificate=true
					}
					render(view:'R4',model:[roleHeader:roleHeader,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,applicationReceiptDate:applicationReceiptDate,investment:investment])
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			      redirect(uri:'/index.gsp');
			 }
		  }
	}
	
	def r4Pdf={
			 try {
					File fileStore
					ApplicationFileRecord file=new ApplicationFileRecord()
					def indApplicationDetailsInstance=IndApplicationDetails.get((params.applicationId).toLong())
					def indRegInstance=indApplicationDetailsInstance.indUser
					def consentIssuedTo=indRegInstance.indName
					def postalAddress=indRegInstance.indAddress
					def indTehsil=indRegInstance.tehsil.tehsilName
					def indDistrict=indRegInstance.district.districtName
					def finalPostalAddress=postalAddress+" Tehsil : "+indTehsil+" District : "+indDistrict
					def indCity=indRegInstance.indCity
					def longitude=params.longitude
					def latitude=params.latitude
					def locationInd=params.locationInd
					def identificationArea=params.identificationArea
					def nameOperationProcess=params.nameOperationProcess
					def identificationNumber=params.identificationNumber
					def proposed=params.proposed
					def nowOperating=params.nowOperating
					def modification=params.modification
					def locationCh=params.locationCh
					def ownerShipCh=params.ownerShipCh
					def orderNumber=params.orderNumber
					def operationDate=params.operationDate_value
					def equipmentStandard=params.equipmentStandard_value
					def emiSourceNumber=params.emiSourceNumber
					def pollEmitted=params.pollEmitted
					def emiRate=params.emiRate
					def conditions=params.consentCondition
					def emiSourceNumberArraySize=emiSourceNumber.size()
					def emiSourceNumberArray = new String[emiSourceNumberArraySize]
					def pollEmittedArray = new String[emiSourceNumberArraySize]
					def emiRateArray = new String[emiSourceNumberArraySize]
					def viewCert = false
					def viewR_Certificate = false
					def viewR4_Certificate = false
					def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
					if(certInst){
						viewCert = true
					}
					def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
					if(r_cert){
						viewR_Certificate=true
					}
					def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
					if(r4_cert){
						viewR4_Certificate=true
					}
					if(emiSourceNumber.getClass().getName()=="java.lang.String"){
					}else{
						for(int var=0;var<emiSourceNumberArraySize;var++ ){
							emiSourceNumberArray[var]=emiSourceNumber[var]
							pollEmittedArray[var]=pollEmitted[var]
							emiRateArray[var]=emiRate[var]
						}
					}
					Rpdf4 r4Instance=new Rpdf4();
					if(emiSourceNumber.getClass().getName()=="java.lang.String"){
						fileStore=r4Instance.pdfGenerationS(conditions,emiRate,pollEmitted,emiSourceNumber,equipmentStandard,operationDate,orderNumber,ownerShipCh,locationCh,modification,nowOperating,proposed,identificationNumber,nameOperationProcess,identificationArea,locationInd,latitude,longitude,indDistrict,indCity,finalPostalAddress,consentIssuedTo)
					}else{
						fileStore=r4Instance.pdfGenerationArray(conditions,emiRateArray,pollEmittedArray,emiSourceNumberArray,equipmentStandard,operationDate,orderNumber,ownerShipCh,locationCh,modification,nowOperating,proposed,identificationNumber,nameOperationProcess,identificationArea,locationInd,latitude,longitude,indDistrict,indCity,finalPostalAddress,consentIssuedTo)
					}
					byte[] b = new byte[(int) fileStore.length()];
					FileInputStream fileInputStream = new FileInputStream(fileStore);
					fileInputStream.read(b);
					def fileLength=fileStore.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.name="R4.pdf"
					file.description="R4 Generation Record"
					file.createdBy=session.userMaster
					file.updatedBy=session.userMaster
					file.typeOfFile="R4"
					file.indApplication=indApplicationDetailsInstance
					if(file.save()) {
						flash.message="R-4 Prepared."
						redirect(action:appProcessing,params:["id":params.applicationId])
					} else {
						flash.userMessage = "R-4 not prepared."
						render(view:'R4',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance])
					}
				}catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			       redirect(uri:'/index.gsp');
			 }
		  }
	}
	
	def openCertificate = {
	}
	
	def open={
	}
	
	/********************************Product Details*********************************************/
    def popConsentCertProductDetailsAdd = {
			 try {
		        	def d = params.d
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def productDetailsList = CosentCertProductDetails.findAllByApplication(app)
		        	return [appDetId:params.id,productDetailsList:productDetailsList,d:d]
		     }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	   }
	}
        
    def popConsentCertProductDetailsView = {
			 try {
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def productDetailsList = CosentCertProductDetails.findAllByApplication(app)
		        	return [appDetId:params.id,productDetailsList:productDetailsList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
 }
	}
        
    def popConsentCertProductDetailsEdit = {
			 try {
			        def app = IndApplicationDetails.get((params.id).toInteger())
		        	def productDetailsList = CosentCertProductDetails.findAllByApplication(app)
		        	return [appDetId:params.id,productDetailsList:productDetailsList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	  }
	}
       
	 def saveProductDetails = {
			 try {
			       def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def indProductDetailsInstanceList = new ArrayList()
			        def qty = 0
			    	def indProductDetailsInstance = new CosentCertProductDetails()
			        		indProductDetailsInstance.application = app
			        		indProductDetailsInstance.product = params.product
			        		indProductDetailsInstance.quantity = params.quantity
			        		indProductDetailsInstance.unit = UnitMaster.get((params.unit).toInteger())
			        		indProductDetailsInstance.save()
			       redirect(action:popConsentCertProductDetailsAdd,id:app)
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       	session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	     }
	}
	
	def deleteProductDetails = {
			 try {
			       def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indProdDetInst = CosentCertProductDetails.get((params.delete).toInteger())
			    		indProdDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indProdDetInst = CosentCertProductDetails.get((params.delete[i]).toInteger())
			        		indProdDetInst.delete()
			        	}
			    	}
			    	redirect(action:popConsentCertProductDetailsEdit,id:app)
			  }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}

	/**************************************Quality of treated effluents*******************************************************/
	 def popConsentCertEffQualityParamAdd = {
			 try {
			       def d = params.d
					def app = IndApplicationDetails.get(params.id.toInteger())
		       	def prameterDetailsList = ConsentCertEffluentQualityParameter.findAllByApplication(app)
		       	return [appDetId:params.id,prameterDetailsList:prameterDetailsList]
		     }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
        
    def popConsentCertEffQualityParamView = {
			 try {
			      def d = params.d
				def app = IndApplicationDetails.get((params.id).toInteger())
		       	def prameterDetailsList = ConsentCertEffluentQualityParameter.findAllByApplication(app)
		        return [appDetId:app,prameterDetailsList:prameterDetailsList,d:d]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
        
    def popConsentCertEffQualityParamEdit = { 
			try {
    	def d = params.d
		def app = IndApplicationDetails.get((params.id).toInteger())
   	def prameterDetailsList = ConsentCertEffluentQualityParameter.findAllByApplication(app)
    	return [appDetId:app,prameterDetailsList:prameterDetailsList,d:d]
				}
			catch(Exception e) {
        e.printStackTrace();
		 flash.message = "Server Busy ..Please try after some time....";
		if(session.indUser){
	redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
    session.invalidate()
    redirect(uri:'/index.gsp');
}
}
	}
       
	 def saveConsentCertEffQualityParam = {
			 try {
			        def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def saveConsentCertEffQualityParamInstance = new ConsentCertEffluentQualityParameter()
			        def qualityParameter=params.qualityParam
					def treatType = params.treatmentType
				def qualityParameterList = ConsentCertEffluentQualityParameter.findAll("from ConsentCertEffluentQualityParameter qua where qua.qualityParam=? and qua.treatmentType=? and qua.application=?",[qualityParameter,treatType,app])
				if(qualityParameterList){
					flash.message = "details for ${qualityParameter} already exits"
					redirect(action:popConsentCertEffQualityParamAdd,id:app)
			    	}else{
					saveConsentCertEffQualityParamInstance.application = app
					saveConsentCertEffQualityParamInstance.treatmentType = params.treatmentType
					saveConsentCertEffQualityParamInstance.range = params.range
					saveConsentCertEffQualityParamInstance.standardValue = params.standardValue
					saveConsentCertEffQualityParamInstance.qualityParam = params.qualityParam
			        	flash.message = "Details Saved"
			    			saveConsentCertEffQualityParamInstance.save()
			       redirect(action:popConsentCertEffQualityParamAdd,id:app)
			   }
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }
		else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def deleteConsentCertEffQualityParam = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indQuaDetInst = ConsentCertEffluentQualityParameter.get((params.delete).toInteger())
			    		indQuaDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indQuaDetInst = ConsentCertEffluentQualityParameter.get((params.delete[i]).toInteger())
			        		indQuaDetInst.delete()
			        	}
			    	}
			    	redirect(action:popConsentCertEffQualityParamEdit,id:app)
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
/**************************************Solid Waste disposal details*******************************************************/
 def popConsentCertSolidWasteDisposalDetailsAdd = {
			 try {
				   	def d = params.d
			       	def app = IndApplicationDetails.get((params.id).toInteger())
			       def CosentCertSolidWasteDisposalDetailsList = CosentCertSolidWasteDisposalDetails.findAllByApplication(app)
			       	return [appDetId:params.id,CosentCertSolidWasteDisposalDetailsList:CosentCertSolidWasteDisposalDetailsList]
			     }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			            redirect(uri:'/index.gsp');
			 }
	 }
	}
       
	def popConsentCertSolidWasteDisposalDetailsView = {
			 try {
				   	def app = IndApplicationDetails.get((params.id).toInteger())
			      	def CosentCertSolidWasteDisposalDetailsList = CosentCertSolidWasteDisposalDetails.findAllByApplication(app)
			       	return [appDetId:params.id,CosentCertSolidWasteDisposalDetailsList:CosentCertSolidWasteDisposalDetailsList]
			    }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			  redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
		  }
	}
       
	def popConsentCertSolidWasteDisposalDetailsEdit = {
			 try {
				   	def app = IndApplicationDetails.get((params.id).toInteger())
			       def CosentCertSolidWasteDisposalDetailsList = CosentCertSolidWasteDisposalDetails.findAllByApplication(app)
			       	return [appDetId:params.id,CosentCertSolidWasteDisposalDetailsList:CosentCertSolidWasteDisposalDetailsList]
			    }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			          redirect(uri:'/index.gsp');
			 }
	  }
	}
      
 def saveConsentCertSolidWasteDisposal = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def ConsentCertSolidWasteDisposalInstance = new CosentCertSolidWasteDisposalDetails(params)
				   ConsentCertSolidWasteDisposalInstance.application = app
					ConsentCertSolidWasteDisposalInstance.typeofWaste = params.typeofWaste
					ConsentCertSolidWasteDisposalInstance.quantity = params.quantity
					ConsentCertSolidWasteDisposalInstance.disMode = WaterDisposalModeMaster.get((params.disMode).toInteger())
			        	flash.message = "Details Saved"
			    			ConsentCertSolidWasteDisposalInstance.save()
			       redirect(action:popConsentCertSolidWasteDisposalDetailsAdd,id:app)
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def deleteConsentCertSolidWasteDisposal = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indQuaDetInst = CosentCertSolidWasteDisposalDetails.get((params.delete).toInteger())
			    		indQuaDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indQuaDetInst = CosentCertSolidWasteDisposalDetails.get((params.delete[i]).toInteger())
			        		indQuaDetInst.delete()
			        	}
			    	}
			    	redirect(action:popConsentCertSolidWasteDisposalDetailsEdit,id:app)
			  }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		     redirect(uri:'/index.gsp');
		 }
	  }
	}
	/**************************************Air Quality Parameter*******************************************************/
	def popConsentCertAirQualityParamAdd = {
			 try {
				   	def d = params.d
			       	def app = IndApplicationDetails.get((params.id).toInteger())
			       	def prameterDetailsList = ConsentCertAirQualityParameter.findAllByApplication(app)
			       	return [appDetId:params.id,prameterDetailsList:prameterDetailsList,d:d]
			    }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       	session.invalidate()
			     redirect(uri:'/index.gsp');
			 }
		  }
	}
       
     def popConsentCertAirQualityParamView = {
			 try {
				   	def app = IndApplicationDetails.get((params.id).toInteger())
			       	def prameterDetailsList = ConsentCertAirQualityParameter.findAllByApplication(app)
			       	return [appDetId:params.id,prameterDetailsList:prameterDetailsList]
			     }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			      session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
		  }
	}
       
       def popConsentCertAirQualityParamEdit = {
			 try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
			       	def prameterDetailsList = ConsentCertAirQualityParameter.findAllByApplication(app)
			       	return [appDetId:params.id,prameterDetailsList:prameterDetailsList]
			    }catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			          session.invalidate()
			            redirect(uri:'/index.gsp');
			 }
		 }
	}
      
 def saveConsentCertAirQualityParam = {
			 try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
			    def saveConsentCertAirQualityParamInstance = new ConsentCertAirQualityParameter(params)
			    		saveConsentCertAirQualityParamInstance.application = app
				    		saveConsentCertAirQualityParamInstance.qualityParameter = params.qualityParameter
				    		saveConsentCertAirQualityParamInstance.range = params.range
				    		saveConsentCertAirQualityParamInstance.standardValue = params.standardValue
				    		flash.message = "Details Saved"
			    			saveConsentCertAirQualityParamInstance.save()
			       redirect(action:popConsentCertAirQualityParamAdd,id:app)
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	     }
	}
	
	def deleteConsentCertAirQualityParam = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indQuaDetInst = ConsentCertAirQualityParameter.get((params.delete).toInteger())
			    		indQuaDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indQuaDetInst = ConsentCertAirQualityParameter.get((params.delete[i]).toInteger())
			        		indQuaDetInst.delete()
			        	}
			    	}
			    	redirect(action:popConsentCertAirQualityParamEdit,id:app)
			  }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	/**************************************Air Stack Details*******************************************************/
	
	def popConsentCertStackDetailsAdd = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		            def consentCertStackList = ConsentCertStackDetails.findAllByApplication(app)
		           return [appDetId:params.id ,consentCertStackList:consentCertStackList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	   }
	}
	
def popConsentCertStackDetailsView = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		            def consentCertStackList = ConsentCertStackDetails.findAllByApplication(app)
		           return [appDetId:params.id ,consentCertStackList:consentCertStackList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	 }
	}
	
def popConsentCertStackDetailsEdit = {
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
		            def consentCertStackList = ConsentCertStackDetails.findAllByApplication(app)
		           return [appDetId:params.id ,consentCertStackList:consentCertStackList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		     session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def saveConsentCertStackDetails = {
			 try {
		        	def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def consentCertStackInst = new ConsentCertStackDetails(params)
		        	consentCertStackInst.application = app
		        	consentCertStackInst.stackAttachedTo =params.stackAttachedTo
		        	consentCertStackInst.stackVolume =params.stackVolume
		        	consentCertStackInst.stackHeight =params.stackHeight
		        	consentCertStackInst.topDiameter =params.topDiameter
		        	consentCertStackInst.velocityOfGasEmission =params.velocityOfGasEmission
		        			def par = UnitMaster.get((params.unit).toInteger())
		        			consentCertStackInst.unit = par
		        			def list = params.pollutionCntrlMeasure
		        		 def b=""
		        		if(list.getClass().getName()== "java.lang.String"){
		        				b=list
		        				}
		        				else{
		        					for (String a : list)
		        				{
		        				b += a + ",";
		        				}
		        				}
		        		consentCertStackInst.pollutionCntrlMeasure = b
		        			consentCertStackInst.typeOfFuel = params.typeOfFuel
		        			consentCertStackInst.maximumQuantity = params.maximumQuantity
		        			consentCertStackInst.save()
		            	redirect(action:popConsentCertStackDetailsAdd,id:app)
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	 }
	}
	
def editConsentAirStack = {
			 try {
			  		def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def consentCertStackDetails = ConsentCertStackDetails.get((params.delete).toInteger())
		        		consentCertStackDetails.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			def consentCertStackDetails = ConsentCertStackDetails.get((params.delete[i]).toInteger())
		            		consentCertStackDetails.delete()
		        		}
		        	}
		        	redirect(action:popConsentCertStackDetailsEdit,id:app)
		     }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}

	def getAppValueForDistrict = {
			 try {
					def redSmall
				    if(params.category == 'redS'){
				        redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Small' and application.indUser.category.name = 'RED' and  application.indUser.district.districtCode = ? ",[params.district])
				    } else if (params.category == 'redL') {           
				       redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Large' and application.indUser.category.name = 'RED' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else if(params.category == 'redM') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Medium'  and application.indUser.category.name = 'RED' and  application.indUser.district.districtCode = ",[params.district])
				    }  else if(params.category == 'orangeS') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Small' and application.indUser.category.name = 'ORANGE' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else if(params.category == 'orangeM') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Medium' and application.indUser.category.name = 'ORANGE' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else if(params.category == 'orangeL') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Large' and application.indUser.category.name = 'ORANGE' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else if(params.category == 'greenS') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Small' and application.indUser.category.name = 'GREEN' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else if(params.category == 'greenM') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Medium' and application.indUser.category.name = 'GREEN' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else if(params.category == 'greenL') 	{
				    	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.industryScale = 'Large'  and application.indUser.category.name = 'GREEN' and  application.indUser.district.districtCode = ? ",[params.district])
				    }  else {
				    	redSmall = null
				    }
					Set<IndustryRegMaster> uniqueIndustry=new LinkedHashSet<IndustryRegMaster>();
					for(ApplicationPendingDetails instance:redSmall)
					{
						uniqueIndustry.add(instance.application.indUser)
					}
					ArrayList newRedSmall=new ArrayList();
				    newRedSmall=uniqueIndustry.toArray();
				    render(view:'getIndListForCategoryScale',model:[redSmall:newRedSmall,type:"RevenueDistrict"])		
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def getTotInd = {
			 try {
					def type=params.type
					def applicationType=params.applicationType
					def certificateFor=params.certificateFor
					def appFor
					if(!applicationType)
					{
						appFor="Not-Selected"
					}
					def startDate1=params.date
					def endDate1=params.date1
					def x
					def y
					def sdfh = new SimpleDateFormat("yyyy-MM-dd"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
					sqlDate2.setDate((sqlDate2.getDate()+1))
					Set<String> uniqueIndustry=new HashSet<String>();
					def indListFinal = new ArrayList()
					def appForList="kkk"
					def groupId=params.groupId	
					def applicationTotalInstance=new ArrayList()
					def allSummaryReportList=new ArrayList()
					def  disList = GroupDistrictMaster.findAll("from GroupDistrictMaster  as abc where abc.group.id=? ORDER BY version Asc",[(groupId).toLong()])
					def  disList1 = disList.district
					for(int kk=0;kk<disList1.size();kk++)
					{
						if(appFor=="Not-Selected"){				 
							 allSummaryReportList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.districtId=?  and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? ",[(disList1.get(kk).id).toString(),sqlDate,sqlDate2])
					    }else{
					      	 allSummaryReportList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.districtId=? and abc.applicationType=? and abc.certificateFor=? and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? ",[(disList1.get(kk).id).toString(),applicationType,certificateFor,sqlDate,sqlDate2])
					    }
						if(allSummaryReportList)
						{
							if(type=="all")
							{
								for(int i=0;i<allSummaryReportList.size();i++)
								{
								   if(uniqueIndustry.add(allSummaryReportList.get(i).indRegMasterId))
								   applicationTotalInstance.add(allSummaryReportList.get(i))
								}
							}
							else if(type=="pending")
							{
								for(int i=0;i<allSummaryReportList.size();i++)
								{
									if(uniqueIndustry.add(allSummaryReportList.get(i).indRegMasterId) && allSummaryReportList.get(i).applicationStatus=="pending")
									applicationTotalInstance.add(allSummaryReportList.get(i))
								}
							}
							else if(type=="approved")
							{
								for(int i=0;i<allSummaryReportList.size();i++)
								{
									if(uniqueIndustry.add(allSummaryReportList.get(i).indRegMasterId) && allSummaryReportList.get(i).applicationStatus=="approved")
									applicationTotalInstance.add(allSummaryReportList.get(i))
								}
							}
							else if(type=="rejected")
							{
								for(int i=0;i<allSummaryReportList.size();i++)
								{
									if(uniqueIndustry.add(allSummaryReportList.get(i).indRegMasterId) && allSummaryReportList.get(i).applicationStatus=="rejected")
									applicationTotalInstance.add(allSummaryReportList.get(i))
								}
							}	
						}
					}
					render(view:'getTotInd',model:[sqlDate3:sqlDate3,appForList:appForList, allSummaryReportList:applicationTotalInstance,sqlDate:sqlDate,sqlDate2:sqlDate2])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	  }
	}

	def getAppValueForTot = {
			 try {
					def startDate1=params.date
					def endDate1=params.date1
					def applicationType=params.applicationType
					def status=params.status
					def x
					def y
					def sdfh = new SimpleDateFormat("yyyy-MM-dd"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
				    java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					sqlDate2.setDate((sqlDate2.getDate()+1))
					def applicationTotalInstance
					if(status=="received")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=?  and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.roleId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])	
					}
					else if(status=="pending")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=? and abc.applicationStatus='pending' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.roleId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])	
					}
					else if(status=="approved")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=? and abc.applicationStatus='approved' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.roleId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])	
					}
					else if(status=="rejected")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=? and abc.applicationStatus='rejected' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.roleId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])	
					}
				   render(view:'getAppValue',model:[ allSummaryReportList:applicationTotalInstance])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def getAppValueForTotOffice = 
	   {
			 try {
					def startDate1=params.date
					def endDate1=params.date1
					def x
					def y
					def sdfh = new SimpleDateFormat("yyyy-MM-dd"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					def applicationType=params.applicationType
					def status=params.status
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					sqlDate2.setDate((sqlDate2.getDate()+1))
		         def applicationTotalInstance
		         if(status=="received")
		         {
		         	applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType=? and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and abc.groupId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])
		         }
		         else if(status=="pending")
		         {
		         	applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=? and abc.applicationStatus='pending' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.groupId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])		
		         }
		         else if(status=="issued")
		         {
		         	applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=? and abc.applicationStatus='approved' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.groupId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])		
		         }
		         else if(status=="rejected")
		         {
		         	applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationType=? and  abc.applicationStatus='rejected' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.groupId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])		
		         }
		         render(view:'getAppValue',model:[ allSummaryReportList:applicationTotalInstance])
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
 }
	
	def getTotApp = {
			 try {
					def status=params.status;
					def category=params.category
					def startDate1=params.date
					def endDate1=params.date1
					def x
					def y
					def sdfh = new SimpleDateFormat("yyyy-MM-dd"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					sqlDate2.setDate((sqlDate2.getDate()+1))
					def applicationTotalInstance
					
					
					String query="";
					if(category=="red")
					{
						query ="and abc.indCategoryName='RED'";
						
					}else if(category=="orange")
					{
						query ="and abc.indCategoryName='ORANGE'";
					}else if(category=="green")
					{
						query ="and abc.indCategoryName='GREEN'";
					}else if(category=="white")
					{
						query ="and abc.indCategoryName='WHITE'";
					}else if(category=="all")
					{
						query ="and abc.indCategoryName IN ('RED','ORANGE','GREEN','WHITE')";
					}
					
					if(status=="received")
					{
						
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.groupId=? and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? "+query+"",[(params.groupId).toString(),sqlDate,sqlDate2])	
					}
					else if(status=="pending")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.groupId=? and abc.applicationStatus='pending' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? "+query+"",[(params.groupId).toString(),sqlDate,sqlDate2])	
					}
					else if(status=="approved")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.groupId=? and abc.applicationStatus='approved' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? "+query+"",[(params.groupId).toString(),sqlDate,sqlDate2])	
					}
					else if(status=="rejected")
					{
						applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.groupId=? and abc.applicationStatus='rejected' and  abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? "+query+"",[(params.groupId).toString(),sqlDate,sqlDate2])	
					}
				    render(view:'getTotApp',model:[allSummaryReportList:applicationTotalInstance])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		           redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	 def getAppValueForTotalPendingTest_BackUp_By_Deepak = {
			 try {
					def days = 0
					def reportType=params.reportType
		            if(params.days){
		                 days = (params.days).toInteger()
		            }
		            def days1 = (params.days1).toInteger()
		            def a= params.a
		            long  diff = 0
		            int diffDays = 0
		            def applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationStatus='pending' and abc.roleId=? ",[(params.id).toString()])
		            def applicationTotalInstanceNew =new ArrayList()
		            if(reportType=="type6")
		            {
		            	applicationTotalInstanceNew=applicationTotalInstance
		            }
		            else
		            {
		            	for(int ip =0; ip<applicationTotalInstance.size(); ip++)
		                {
		                   def  appRecieveDate = applicationTotalInstance.get(ip).applicationRecieptDate
		                   Date today = new Date();
		                   diff = today.getTime() - appRecieveDate.getTime();
		                   diffDays=diff / (1000*60*60*24)+1
		                   if(reportType=="type1")
		                   {
		                	 if(diffDays>=120)
		                		applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
		                   }
		                   else if(reportType=="type2")
		                   {
		                	   if(diffDays < 120  && diffDays> 89)
		                		 applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
		                   }
		                   else if(reportType=="type3")
		                   {
		                	   if(diffDays < 90 && diffDays > 59 )
		                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
		                   }else if(reportType=="type4")
		                   {
		                	   if(diffDays> 29 && diffDays<60)
		                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
		                   }else if(reportType=="type5")
		                   {
		                	   if(diffDays < 31)
		                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
		                   }
		                }
		            }
				    render(view:'getAppValuePendingTest',model:[applicationTotalInstance:applicationTotalInstanceNew])
		     }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	 def getAppValueForTotalPendingTest = {
			 try { 
				 	println("Params in getAppValueForTotalPendingTest:"+params)
				    // report -9 for show data in details of selected days
							def days = 0
							def group1 = params.group1
							println("group1:"+group1)
							def reportType=params.reportType
				            if(params.days){
				                 days = (params.days).toInteger()
				            }
				            def days1 = (params.days1).toInteger()
				            def a= params.a
				            long  diff = 0
				            int diffDays = 0
				            long clDiff = 0
				            int clDiffDays = 0
				            def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[params.id])
				            def OfficerId = userMasterInsta.id
				            def applicationTotalInstance = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[group1,OfficerId])
				            def applicationTotalInstanceNew =new ArrayList()
				            if(reportType=="type6")
				            {
				            	applicationTotalInstanceNew=applicationTotalInstance
				            }
				            else
				            {
				            	for(int ip =0; ip<applicationTotalInstance.size(); ip++)
				                {
				                	def appRecieveDate = applicationTotalInstance[ip].completionDate
				                	
				                	Date today = new Date();
				                 	diff = today.getTime() - appRecieveDate.getTime();
				    				diffDays=diff / (1000*60*60*24) +1
				                  
				                  if(reportType=="type1")
				                   {
				                	 if(diffDays>=120)
				                		
				                		applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                		
				                   }
				                   else if(reportType=="type2")
				                   {
				                	   if(diffDays < 120  && diffDays> 89)
				                		 applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }
				                   else if(reportType=="type3")
				                   {
				                	   if(diffDays < 90 && diffDays > 59 )
				                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }else if(reportType=="type4")
				                   {
				                	   if(diffDays> 30 && diffDays<60)
				                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }else if(reportType=="type5")
				                   {
				                	   if(diffDays>= 0 && diffDays<31)
				                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }
				                }
				            }
				            println("fdkjfdkk")
				           render(view:'getAppValuePendingTest',model:[applicationTotalInstance:applicationTotalInstanceNew])
				    
							}catch(Exception e) {
				            e.printStackTrace();
							 flash.message = "Server Busy ..Please try after some time....";
							if(session.indUser){
				 
				 redirect(controller:'indUser',action:'openIndustryHome')
				 }else if(session.userMaster){
				  
				  redirect(controller:'userMaster',action:'openSpcbHome');
				 }else{
				          
							session.invalidate()
				            redirect(uri:'/index.gsp');
				 }
				            }
	}
	
	
	def getAppValueForTotalPendingWithIndustryTest = {
			 try { 
				 	println("Params in getAppValueForTotalPendingWithIndustryTest:"+params)
				    // report -9 for show data in details of selected days
							def days = 0
							def group1 = params.group1
							println("group1:"+group1)
							def reportType=params.reportType
				            if(params.days){
				                 days = (params.days).toInteger()
				            }
				            def days1 = (params.days1).toInteger()
				            def a= params.a
				            long  diff = 0
				            int diffDays = 0
				            long clDiff = 0
				            int clDiffDays = 0
				            def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[params.id])
				            def OfficerId = userMasterInsta.id
				 //           def applicationTotalInstance = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[group1,OfficerId])
				              def applicationTotalInstance = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and (apd.applicationStatus='returned' OR apd.completionStatus in ('In-Complete','Completed')) and apd.pendingWith.id =?",[group1,OfficerId])         
				 def applicationTotalInstanceNew =new ArrayList()
				            if(reportType=="type6")
				            {
				            	applicationTotalInstanceNew=applicationTotalInstance
				            }
				            else
				            {
				            	for(int ip =0; ip<applicationTotalInstance.size(); ip++)
				                {
				                	def appRecieveDate = applicationTotalInstance[ip].completionDate
				                	
				                	Date today = new Date();
				                 	diff = today.getTime() - appRecieveDate.getTime();
				    				diffDays=diff / (1000*60*60*24) +1
				                  
				                  if(reportType=="type1")
				                   {
				                	 if(diffDays>=120)
				                		
				                		applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                		
				                   }
				                   else if(reportType=="type2")
				                   {
				                	   if(diffDays < 120  && diffDays> 89)
				                		 applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }
				                   else if(reportType=="type3")
				                   {
				                	   if(diffDays < 90 && diffDays > 59 )
				                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }else if(reportType=="type4")
				                   {
				                	   if(diffDays> 30 && diffDays<60)
				                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }else if(reportType=="type5")
				                   {
				                	   if(diffDays>= 0 && diffDays<31)
				                		   applicationTotalInstanceNew.add(applicationTotalInstance.get(ip))
				                   }
				                }
				            }
				            println("applicationTotalInstanceNew -----"+applicationTotalInstanceNew.size())
				           render(view:'getAppValuePendingWithIndustryTest',model:[applicationTotalInstance:applicationTotalInstanceNew])
				    
							}catch(Exception e) {
				            e.printStackTrace();
							 flash.message = "Server Busy ..Please try after some time....";
							if(session.indUser){
				 
				 redirect(controller:'indUser',action:'openIndustryHome')
				 }else if(session.userMaster){
				  
				  redirect(controller:'userMaster',action:'openSpcbHome');
				 }else{
				          
							session.invalidate()
				            redirect(uri:'/index.gsp');
				 }
				            }
	}
	
	def getAppValueForCTOTotal = {
			 try {
				 def applicationTotalInstance
					def applicationTotalInstanceNew=new ArrayList();
			        def days = 0
			        if(params.days){
			           days = (params.days).toInteger()
			        }
			        def days1 = (params.days1).toInteger()
			        def a= params.a
			        long  diff = 0
			        int diffDays = 0
			        def diffArray = new ArrayList()
			        if(a=='d')		
				    { 
					     applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationStatus!='pending' and abc.applicationType ='CTO' and  abc.groupId=? ",[(params.id).toString()])
					     render(view:'getAppValueCTO',model:[a:a,days1:days1,days:days,allSummaryReportList:applicationTotalInstance])
					     return
					 } 
			        else if(a!='z')
					{
			             applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationStatus!='pending' and abc.applicationType ='CTO' and  abc.groupId=? ",[(params.id).toString()])
					}
				    else		
				    { 
					     applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType ='CTO' and  abc.groupId=? ",[(params.id).toString()])
					     render(view:'getAppValueCTO',model:[a:a,days1:days1,days:days,allSummaryReportList:applicationTotalInstance])
					     return
					 }
					for(int ip =0; ip<applicationTotalInstance.size(); ip++)
					{
					 def newArray = new ArrayList()
					 def appRecieveDate=applicationTotalInstance.get(ip).applicationRecieptDate
			         if(appRecieveDate)
					 {
			            Date today = new Date();
			            			diff = today.getTime() - appRecieveDate.getTime();
											diffDays=diff / (1000*60*60*24) +1
											if(days==30 && days1==-1)
											{
												if(diffDays<30)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==60 && days1==30)
											{
												if(diffDays>=30 && diffDays<60)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==90 && days1==60)
											{
												if(diffDays>=60 && diffDays<90)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==120 && days1==90)
											{
												if(diffDays>=90 && diffDays<120)
											applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==120 && days1==-1)
											{
												if(diffDays<=120)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days1==121)
											{
												if(diffDays>120)
												{
													diffArray.add(diffDays)
													applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
												}	
											}
					 					}
					    				 }
					if(days1==121){
						     render(view:'getAppValueCTO',model:[a:a,days1:days1,diffArray:diffArray, allSummaryReportList:applicationTotalInstanceNew])
				         }
					     else if(params.days)
					     {
					         render(view:'getAppValueCTO',model:[a:a,days1:days1,days:days,diffArray:diffArray, allSummaryReportList:applicationTotalInstanceNew])
			             }else{
			                  render(view:'getAppValueCTO',model:[a:a,days1:days1,diffArray:diffArray, allSummaryReportList:applicationTotalInstanceNew]) 
			             }
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	 }
	}	
	
	def getAppValueForCTETotal = 
	{
		try {
				def applicationTotalInstance
					def applicationTotalInstanceNew=new ArrayList();
			        def days = 0
			        if(params.days){
			           days = (params.days).toInteger()
			        }
			        def days1 = (params.days1).toInteger()
			        def a= params.a
			        long  diff = 0
			        int diffDays = 0
			        def diffArray = new ArrayList()
			        if(a=='d')		
				    { 
					     applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationStatus!='pending' and abc.applicationType ='CTE' and  abc.groupId=? ",[(params.id).toString()])
					     render(view:'getAppValueCTENew',model:[a:a,days1:days1,days:days,allSummaryReportList:applicationTotalInstance])
					     return
					} 
			        else if(a!='z')
					{
			             applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.applicationStatus!='pending' and abc.applicationType ='CTE' and  abc.groupId=? ",[(params.id).toString()])
					}
				     else		
				    { 
					     applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType ='CTE' and  abc.groupId=? ",[(params.id).toString()])
					     render(view:'getAppValueCTENew',model:[a:a,days1:days1,days:days,allSummaryReportList:applicationTotalInstance])
					     return
					 }
					for(int ip =0; ip<applicationTotalInstance.size(); ip++)
					{
					 def newArray = new ArrayList()
					 def appRecieveDate=applicationTotalInstance.get(ip).applicationRecieptDate
			         if(appRecieveDate)
					 {
			            Date today = new Date();
			            			diff = today.getTime() - appRecieveDate.getTime();
											diffDays=diff / (1000*60*60*24) +1
											if(days==30 && days1==-1)
											{
												if(diffDays<30)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==60 && days1==30)
											{
												if(diffDays>=30 && diffDays<60)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==90 && days1==60)
											{
												if(diffDays>=60 && diffDays<90)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==120 && days1==90)
											{
												if(diffDays>=90 && diffDays<120)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days==120 && days1==-1)
											{
												if(diffDays<=120)
												applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
											}
											else if(days1==121)
											{
												if(diffDays>120)
												{
													diffArray.add(diffDays)
													applicationTotalInstanceNew.add(applicationTotalInstance.get(ip));
												}	
											}
					 						}
					    				  }
					if(days1==121){
						     render(view:'getAppValueCTENew',model:[a:a,days1:days1,diffArray:diffArray, allSummaryReportList:applicationTotalInstanceNew])
				         }
					     else if(params.days)
					     {
					         render(view:'getAppValueCTENew',model:[a:a,days1:days1,days:days,diffArray:diffArray, allSummaryReportList:applicationTotalInstanceNew])
			             }else{
			                  render(view:'getAppValueCTENew',model:[a:a,days1:days1,diffArray:diffArray, allSummaryReportList:applicationTotalInstanceNew]) 
			             }
			    }
		catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			         redirect(uri:'/index.gsp');
			 }
		 }
	}
	
	def getAppValueDaysWise = {
			 try {
					def applicationType=params.applicationType
					def noOfDays=params.noOfDays
					def newArray = new ArrayList()
					def allSummaryReportList=new ArrayList();
					def applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport  as abc where  abc.roleId=? and abc.applicationType=? and abc.applicationStatus='pending' ",[(params.id).toString(),applicationType])	
					for(int ip=0;ip<applicationTotalInstance.size();ip++)
					{
						def appRecieveDate=applicationTotalInstance.get(ip).pendingSince
						Date today = new Date();
			         	long diffDays = today.getTime() - appRecieveDate.getTime();
			         	diffDays=diffDays / (1000*60*60*24) +1
						if(diffDays>=noOfDays.toLong())
						{
							allSummaryReportList.add(applicationTotalInstance.get(ip))
						}
					}
					render(view:'getAppValue',model:[ allSummaryReportList:allSummaryReportList,status:"pending"])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		 }
	}
//////////////////////////////////////Upload Consent order///////////////////////
def uploadConsentOrder = {
			 try {
				    def idAppl= (params.appliId).toLong()
						def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
						def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
						def viewCertupload = false
						def certInst = UploadConsentOrder.findByApplicationId(indApplicationDetailsInstance)
						if(certInst)
						{
							viewCertupload = true
						}
						def roleHeader=app.role.roleName
				    	return [appDetId:params.appliId,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload]
				     }
			 catch(Exception e) {
				            e.printStackTrace();
							 flash.message = "Server Busy ..Please try after some time....";
							if(session.indUser){
				  redirect(controller:'indUser',action:'openIndustryHome')
				 }else if(session.userMaster){
				  redirect(controller:'userMaster',action:'openSpcbHome');
				 }else{
				        session.invalidate()
				        redirect(uri:'/index.gsp');
				 }
			 }
	}

	def saveConsentOrder= {
			 try {
				  def idAppl= (params.idIndApp).toLong()
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					def viewCertupload = false
					def certInst = UploadConsentOrder.findByApplicationId(indApplicationDetailsInstance)
					if(certInst)
					{
						viewCertupload = true
					}
					def roleHeader=app.role.roleName
					def recordCertificateInstance=new UploadConsentOrder()
					ApplicationFileRecord file=new ApplicationFileRecord()
					def startDate1=params.grantedFrom_value
					def endDate1=params.grantedTo_value
					def referenceDate=params.referenceDate_value
					def checkDate
					def x
					def y
					def zz
					try {
						def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
						x = sdfh.parse(startDate1); //Date
						y = sdfh.parse(endDate1);
						zz = sdfh.parse(referenceDate);
						checkDate="checked"
					}
					catch(Exception e) {
						flash.message="Enter Both The Consent Granted Dates "
						render(view:'uploadConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
					}
					if(checkDate) {
				java.sql.Date refDate = new java.sql.Date(zz.getTime())
						java.sql.Date sqlDate = new java.sql.Date(x.getTime())
						java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
						if(sqlDate>sqlDate2) {
							flash.message="Grant To Date should be Greater than Grant From Date"
							render(view:'uploadConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
						}else {
							recordCertificateInstance.startDate=sqlDate
							recordCertificateInstance.endDate=sqlDate2
			if(session.userMaster==null)
					    	{
								flash.message="Your session has been expired ! Please login again."
					    		redirect(uri:'/index.gsp')
					    		return
					    	}
							def refNo = ""
							if(params.referenceNo)
							{
								refNo = params.referenceNo
							}
							else
							{
								flash.message="Please enter Reference no. for this application"
									render(view:'uploadConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
									return
							}
					    	recordCertificateInstance.referenceNo=refNo
					    	recordCertificateInstance.referenceDate=refDate
					    	recordCertificateInstance.updatedBy=session.userMaster
							recordCertificateInstance.createdBy=session.userMaster
							recordCertificateInstance.applicationId=indApplicationDetailsInstance
							if(!recordCertificateInstance.hasErrors()) {
								def f = request.getFile('consentOrder')
								if(!f.empty) {
								def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='ConsentOrder'",[(indApplicationDetailsInstance.id).toLong()])
								if(filerecordinstance)
										 {
											 filerecordinstance.delete();
										 }
					    			MultipartFile multi = request.getFile('consentOrder')
									file.size = multi.getSize() / 1024
									file.extension = extractExtension( multi )
									file.data=multi.getBytes()
									def abc = "CertiFicate"
						            def b = abc+"."+extractExtension( multi )
						            file.name =b 
						            file.description="Certificate Generation Record"	
						            	if(session.userMaster==null)
						            	{
						            		flash.message="Your session has been expired ! Please login again."
						            		redirect(uri:'/index.gsp')
						            		return
						            	}
					    			file.createdBy=(session.userMaster).toString()
							 	    file.updatedBy=(session.userMaster).toString()
									file.typeOfFile="ConsentOrder"
						 	    	file.indApplication=indApplicationDetailsInstance
						 	    	file.dateCreated=new Date()
									Byte[] bytes=multi.getBytes() 
									if(file.save()) {
										recordCertificateInstance.save()
										flash.message = "Certificate Generated and Record Saved "
									} else {
										flash.userMessage = "File [${file.name}] has NOT not been uploaded."
											render(view:'uploadConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
											}
								}
			redirect(action:appProcessing,params:["id":params.idIndApp,"viewCertupload":viewCertupload])
			}
							else {
								flash.message="Can not contain special characters or reserve words"
								render(view:'uploadConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
							}
					}	
			}
 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def downLoadingCertificate1={
			 try {
					def appId=IndApplicationDetails.get((params.id).toLong())
						def fileDownLoad 
						if(appId.certificateFor!="autoReNew"){
					 fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentOrder' order by afr.dateCreated desc",[appId],[max:1])
						}else{
							 fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate' order by afr.dateCreated desc",[appId],[max:1])
						}
					def fileSingle=fileDownLoad.get(0);
					response.setContentType( "application-xdownload")
				 response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
			  }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }				
	}
		
	def popProductDetailsAddInspection= {
			 try {
				 println("params.popProductDetailsAddInspection..."+params)
					def d = params.d
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def productDetailsList = IndProductDetailsInspection.findAll("from IndProductDetailsInspection s where s.application=? order by id asc",[app])
			    	def appFor=app.certificateFor
			    	def page=params.page
			    	def type=params.type
			    	return [appDetId:params.id,page:page,productDetailsList:productDetailsList,d:d,appFor:appFor,type:type]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
		  }
	}
	
	def popProductDetailsViewInspection = {
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
			    	def productDetailsList = IndProductDetailsInspection.findAll("from IndProductDetailsInspection s where s.application=? order by id asc",[app])
			    	def page=params.page
			    	def appFor=app.certificateFor
			    	def type=params.type
			    	return [type:type,appDetId:params.id,page:page,productDetailsList:productDetailsList,appFor:appFor]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
		  }
	}
	
	def popProductDetailsEditInspection = {
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
			    	def productDetailsList = IndProductDetailsInspection.findAll("from IndProductDetailsInspection s where s.application=? order by id asc",[app])
			    	def page=params.page
			    	def appFor=app.certificateFor
			    	def type=params.type
			    	return [type:type,appDetId:params.id,productDetailsList:productDetailsList,page:page,appFor:appFor]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def saveProductDetailsInspection= {
			 try {
				 println("params..."+params)
					def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def indProductDetailsInstanceList = new ArrayList()
					def type=params.type
			        def qty = 0
			    	params.unit
			    	params.rawMaterials
			    	String []product = params.product
			    	String []quantity = params.quantity
			    	String []byProduct = params.byProduct
			    	String []unit = params.unit
			    	String []rawMaterials = params.rawMaterials
			    	if((params.product).getClass().getName()== "java.lang.String"){
			    		if(params.product != ""){
			    			def indProductDetailsInstance = new IndProductDetailsInspection()
			        		indProductDetailsInstance.application = app
			        		indProductDetailsInstance.product = params.product
			        		indProductDetailsInstance.quantity = params.quantity
			        		indProductDetailsInstance.byProduct = params.byProduct
			        		indProductDetailsInstance.rawMaterials = params.rawMaterials
			        		indProductDetailsInstance.unit = UnitMaster.get((params.unit).toInteger())
			        		indProductDetailsInstance.unitbyProduct = UnitMaster.get((params.unitbyProduct).toInteger())
			        		def qty1 = (params.quantity).toFloat()
			        		qty = qty + qty1
			        		indProductDetailsInstance.save()
			        		indProductDetailsInstanceList.add(indProductDetailsInstance)
			        	}
			    	}else{
			    		for(int i=0;i<params.product.size();i++){
			    			if(product[i] != ""){
			        			def indProductDetailsInstance = new IndProductDetailsInspection()
			            		indProductDetailsInstance.application = indApplicationDetailsInstance
			            		indProductDetailsInstance.product = product[i] 
			            		indProductDetailsInstance.quantity = quantity[i]
			            		indProductDetailsInstance.byProduct = byProduct[i] 
			            		indProductDetailsInstance.rawMaterials = rawMaterials[i]
			            		indProductDetailsInstance.unit = UnitMaster.get((params.unit[i]).toInteger())
			            		indProductDetailsInstance.unitbyProduct = UnitMaster.get((params.unitbyProduct[i]).toInteger())
			            		indProductDetailsInstance.save()
			            		indProductDetailsInstanceList.add(indProductDetailsInstance)
			    			}
			    		}
			    	}
			    def indProdDetailsInstance = IndProductDetailsMaster.findAllWhere(application:app)
				def a = indProdDetailsInstance.quantity
				def d = 0
				for (int j=0;j<indProdDetailsInstance.size();j++){
					d = d+ (a[j]).toFloat()
				}
			    def i =0
			    def p = indProductDetailsInstanceList.quantity[i]
				def b = (p).toFloat()
				d= d+b
				app.annualProdCap = d
				println("type on controller save action..."+type)
				redirect(action:popProductDetailsAddInspection,id:app,params:[d:d,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def deleteProductDetailsInspection = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def type=params.type
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indProdDetInst = IndProductDetailsInspection.get((params.delete).toInteger())
			    		indProdDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indProdDetInst = IndProductDetailsInspection.get((params.delete[i]).toInteger())
			        		indProdDetInst.delete()
			        	}
			    	}
			    	redirect(action:popProductDetailsEditInspection,id:app,params:[type:type])
			   }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popAirStackAddInspection = {
			 try {
			    	def app
			    	if(params.id){
			    		 app = IndApplicationDetails.get((params.id).toInteger())
			    	}else{
			    		app = IndApplicationDetails.get((params.app).toInteger())
			    	}
			    	 def count1
			         def count2 
			        def airInstanceList = AirStackDetailsInspection.findAllWhere(application:app)
			        	if(airInstanceList){
			        	count1 = airInstanceList.size()
			         }
			    	else{
			    		count1 = '0'
			    	}
			    	 	app.noOfStack = count1
			    	def stackList = AirStackDetailsInspection.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<stackList.size();i++){
			    		def pollCntrlList = AirStackPollutionCntrlDetailsMasterInspection.findAllWhere(stack:stackList.get(i))
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	 	def type=params.type
			    	return [type:type,appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,count1:count1,app:app]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
	}

	def popAirStackViewInspection= {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def stackList = AirStackDetailsInspection.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<stackList.size();i++){
			    		def pollCntrlList = AirStackPollutionCntrlDetailsMasterInspection.findAllWhere(stack:stackList.get(i))
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	def type=params.type
			    	return [type:type,appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,app:app]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	}
	}
	
	def popAirStackEditInspection = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def stackList = AirStackDetailsInspection.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<stackList.size();i++){
			    		def pollCntrlList = AirStackPollutionCntrlDetailsMasterInspection.findAllWhere(stack:stackList.get(i))
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	def type=params.type
			    	return [type:type,appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,app:app]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	  }
	}

	def saveAirStackDetailsInspection = {
			 try {
			    	def count1
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def type=params.type
			    	if((params.capacity).getClass().getName()== "java.lang.String"){
			    		def unit = UnitMaster.get((params.capacityUnit).toInteger())
			    		def airStackInst = new AirStackDetailsInspection()
			    		airStackInst.application = app
			    		airStackInst.capacity = params.capacity
			    		airStackInst.heightGrdLevel = params.heightGrdLevel
			    		airStackInst.heightFacLevel = params.heightFacLevel
			    		airStackInst.matOfCon = params.matOfCon
			    		airStackInst.draftType = params.draftType
			    		airStackInst.stack = params.stack
			    		airStackInst.unit = unit
			    		airStackInst.fuelTyp=params.fuelTyp
			    		airStackInst.fuelQty=params.fuelQty
			    		airStackInst.gasQty=params.gasQty
			    		airStackInst.shape=params.shape
			    		airStackInst.diamSize=params.diamSize
			    		airStackInst.gasTemp=params.gasTemp
			    		airStackInst.gasVel=params.gasVel
			    		if(airStackInst.save()){
			    			if((params.pollCntrlMeasure).getClass().getName()== "java.lang.String"){
			    	    		def airStackPollCntrlDetailsInst = new AirStackPollutionCntrlDetailsMasterInspection()
			    	    		airStackPollCntrlDetailsInst.stack = airStackInst
			    	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.pollCntrlMeasure).toInteger())
			    	    		airStackPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
			    	    		airStackPollCntrlDetailsInst.save()
			        		}else{
			        			for(int i=0;i<params.pollCntrlMeasure.size();i++){
			        				def airStackPollCntrlDetailsInst = new AirStackPollutionCntrlDetailsMasterInspection()
			        	    		airStackPollCntrlDetailsInst.stack = airStackInst
			        	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.pollCntrlMeasure[i]).toInteger())
			        	    		airStackPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
			        	    		airStackPollCntrlDetailsInst.save()
			        			}
			        		}
			    		}else{
			    			airStackInst.errors.allErrors.each {
			    			    }
			    		}
			    	}else{
			    		for(int i=0;i<params.capacity.size();i++){
			    		}
			    	}
			    	flash.message = "Details Saved"
			        redirect(action:popAirStackAddInspection,id:app,params:[count1:count1,type:type])
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	}

	def deleteAirStackDetailsInspection = {
			 try {
				 println("params.."+params)
				 def app = IndApplicationDetails.get((params.appId).toInteger())
				 def type=params.type
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def airStackDetInst = AirStackDetailsInspection.get((params.delete).toInteger())
			    		def airStackPollCntrlInstList = AirStackPollutionCntrlDetailsMasterInspection.findAllByStack(airStackDetInst)
			    		for(int j=0;j<airStackPollCntrlInstList.size();j++){
			    			(airStackPollCntrlInstList.get(j)).delete()
			    		}
			    		airStackDetInst.delete()
			    	}else{
			    		if(params.delete)
			    		for(int i=0;i<(params.delete).size();i++){
			    			def airStackDetInst = AirStackDetailsInspection.get((params.delete[i]).toInteger())
			    			def airStackPollCntrlInstList = AirStackPollutionCntrlDetailsMaster.findAllByStack(airStackDetInst)
			    			for(int j=0;j<airStackPollCntrlInstList.size();j++){
			        			(airStackPollCntrlInstList.get(j)).delete()
			        		}
			        		airStackDetInst.delete()
			    		}
			    	}
			    	def page=params.page
			    	redirect(action:popAirStackEditInspection,id:app,params:[page:page,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def deleteAirStackDetailsMaster = {
			 try {
				 def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def airStackDetInst = AirStackDetailsMaster.get((params.delete).toInteger())
			    		def airStackPollCntrlInstList = AirStackPollutionCntrlDetailsMaster.findAllByStack(airStackDetInst)
			    		for(int j=0;j<airStackPollCntrlInstList.size();j++){
			    			(airStackPollCntrlInstList.get(j)).delete()
			    		}
			    		airStackDetInst.delete()
			    	}else{
			    		if(params.delete)
			    		for(int i=0;i<(params.delete).size();i++){
			    			def airStackDetInst = AirStackDetailsMaster.get((params.delete[i]).toInteger())
			    			def airStackPollCntrlInstList = AirStackPollutionCntrlDetailsMaster.findAllByStack(airStackDetInst)
			    			for(int j=0;j<airStackPollCntrlInstList.size();j++){
			        			(airStackPollCntrlInstList.get(j)).delete()
			        		}
			        		airStackDetInst.delete()
			    		}
			    	}
			    	def page=params.page
			    	redirect(action:popAirStackEditMaster,id:app,params:[page:page])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
  
    def popHotelFacilityAddInspection = {
			 try {
				 def app = IndApplicationDetails.get((params.id).toInteger())
		            	def hotelFacilitylist = HotelFacilityDetailInspection.findAllByApplication(app)
		              def districtList = HotelFacilityTypeMaster.list( sort:"typeName", order:"asc")
		              def type=params.type
		              return [type:type,appDetId:params.id ,districtList:districtList,hotelFacilitylist:hotelFacilitylist]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
	}
   
   def saveHotelFacilityDetailInpsection = {
			 try {
		    		def app = IndApplicationDetails.get((params.appId).toInteger())
		    		def type=params.type
		    		def hotelFacilityInst = new HotelFacilityDetailInspection(params)
		    		def hotelFacilityMasterInst = HotelFacilityMaster.get(params.facility.id)
		    		def facilityId = params.facility.id
		    		def facilityTypeList = params.hotelFacilityType.id
		    		def hotelFacilitylist = HotelFacilityDetailInspection.findAll("from HotelFacilityDetailInspection abc where abc.facility.id=? and abc.hotelFacilityType.id=? and abc.application=?",[facilityId.toLong(),facilityTypeList.toLong(),app])
		    		def name = hotelFacilitylist.facility.name
		    		if(hotelFacilitylist)
		    		{
		    		flash.message = "Hotel Facility Details regarding ${name.toString()} already exists"
		    		redirect(action:popHotelFacilityAddInspection,id:app,params:[hotelFacilitylist:hotelFacilitylist,type:type])
		    		}
		    		else
		    		{
		    		hotelFacilityInst.application = app
		    		hotelFacilityInst.capacity = params.capacity
		    		hotelFacilityInst.facilityDetail = params.facilityDetail
		    		hotelFacilityInst.save()
		    		redirect(action:popHotelFacilityAddInspection,id:app,params:[type:type])
		    		}
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	  }		
	} 
  
    def myAjax12 ={
			 try {
		    		def facilityTypeList
		    		def a
		    		def dist
		    		if(params.cont== '9999' ) {
		    			render g.select( width:'10', optionKey:'id',name:'facility.id', from:facilityTypeList)
		    		}
		    		else {
		    		a = params.cont
		    		dist = HotelFacilityTypeMaster.get(a)
		    		facilityTypeList = HotelFacilityMaster.findAll("from HotelFacilityMaster tm where tm.hotelFacilityType=? order by tm.name asc",[dist])
		    		render g.select( width:'10', optionKey:'id',name:'facility.id', from:facilityTypeList)
		    		}
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	}
    
    def popHotelFacilityViewInspection = {
			 try {
		    		def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelFacilitylist = HotelFacilityDetailInspection.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:params.id,hotelFacilitylist:hotelFacilitylist]
		   }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	} 
    
    def popHotelFacilityEditInspection = {
			 try {
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelFacilitylist = HotelFacilityDetailInspection.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:params.id,hotelFacilitylist:hotelFacilitylist]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		 redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	} 
    
    def editHotelFcilityDetailInspection= {
			 try {
			       def app = IndApplicationDetails.get((params.appId).toInteger())
			       def type=params.type
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def hotelFacilityDetail = HotelFacilityDetailInspection.get((params.delete).toInteger())
		        		hotelFacilityDetail.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			def hotelFacilityDetail = HotelFacilityDetailInspection.get((params.delete[i]).toInteger())
		            		hotelFacilityDetail.delete()
		        		}
		        	}
		        	redirect(action:popHotelFacilityEditInspection,id:app,params:[type:type])
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
	  }
	}
   
    def popHotelWaterConsumptionAddInspection = {
			 try {
		         	def app = IndApplicationDetails.get((params.id).toInteger())
		            def hotelWaterConsumptionlist = HotelWaterConsumptionDetailInspection.findAllByApplication(app)
		            def type=params.type
		           return [type:type,appDetId:params.id ,hotelWaterConsumptionlist:hotelWaterConsumptionlist]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
 }				
	}
  
    def saveHotelWaterConsumptionInspection = {
			 try {
		         def app = IndApplicationDetails.get((params.appId).toInteger())
		         def type=params.type
		        	def hotelWaterConsumptionInst = new HotelWaterConsumptionDetailInspection()
		        	def par = HotelWaterConsumptionMaster.get((params.type1).toInteger())
		        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetailInspection.findAll("from HotelWaterConsumptionDetailInspection abc where abc.type=? and abc.application=?",[par,app])
		        	if(hotelWaterConsumptionlist)
		        	{
		        	       flash.message = "Hotel Water Consumption Details regarding ${par.toString()} already exists"
		        	       redirect(action:popHotelWaterConsumptionAddInspection,id:app,params:[hotelWaterConsumptionlist:hotelWaterConsumptionlist])
		        	}
		        	else
		        	{
		        		flash.message = "Hotel Water Consumption Details regarding ${par.toString()} is saved"
		        			hotelWaterConsumptionInst.application = app
		        			hotelWaterConsumptionInst.type = par
		        			hotelWaterConsumptionInst.quantity = params.quantity
		        			hotelWaterConsumptionInst.save()
		            	redirect(action:popHotelWaterConsumptionAddInspection,id:app,params:[type:type])
		        	}
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
  
    def popHotelWaterConsumptionViewInspection= {
			 try {
		         def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetailInspection.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:params.id,hotelWaterConsumptionlist:hotelWaterConsumptionlist]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	  }
	} 
    
    
    def popHotelWaterConsumptionEditInspection = {
			 try {
		         def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetailInspection.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:params.id,hotelWaterConsumptionlist:hotelWaterConsumptionlist]
		     }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	    }
	} 
    
    def editHotelWaterConsumptionInspection = {
			 try {
		       def app = IndApplicationDetails.get((params.appId).toInteger())
		       def type=params.type
 	        	if((params.delete).getClass().getName()== "java.lang.String"){
 	        	def hotelWaterConsumptionDetail = HotelWaterConsumptionDetailInspection.get((params.delete).toInteger())
 	        		hotelWaterConsumptionDetail.delete()
 	        	}else{
 	        		if(params.delete)
 	        		for(int i=0;i<(params.delete).size();i++){
 	        			def hotelWaterConsumptionDetail = HotelWaterConsumptionDetailInspection.get((params.delete[i]).toInteger())
 	            		hotelWaterConsumptionDetail.delete()
 	        		}
 	        	}
 	        	redirect(action:popHotelWaterConsumptionEditInspection,id:app,params:[type:type])
  }
			 catch(Exception e) {
         e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
redirect(controller:'indUser',action:'openIndustryHome')
}else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
       session.invalidate()
      redirect(uri:'/index.gsp');
}
      }
	}
  
	def popAddWaterBudget={
			 try {
		         def d = params.d
		         def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
			        	def waterBudgetList =WaterBudget.findAllByApplication(app)
			        	def type=params.type
			        	return [type:type,appDetId:app,waterBudgetList:waterBudgetList,d:d]		
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			          redirect(uri:'/index.gsp');
			 }
		 }
	}
	def saveWaterBudget = {
			 try {
				 println("params...."+params)
			       def app = IndApplicationDetails.get((params.appid).toInteger())
			       def type=params.type
			    	def waterBudgetList = new WaterBudget()
					waterBudgetList.application = app
					waterBudgetList.waterbudgettype="Domestic"
					waterBudgetList.wcprevious= params.wcprevious
					waterBudgetList.wcpresent= params.wcpresent
					waterBudgetList.egpresent= params.egpresent
					waterBudgetList.egprevious= params.egprevious
					
					waterBudgetList.waterbudgettype2="Industrial process generating biodegradable waste water"
					waterBudgetList.wcprevious2= params.wcprevious2
					waterBudgetList.wcpresent2= params.wcpresent2
					waterBudgetList.egpresent2= params.egpresent2
					waterBudgetList.egprevious2= params.egprevious2
					
					waterBudgetList.waterbudgettype3="Industrial process generating non-biodegradable waste water"
					waterBudgetList.wcprevious3= params.wcprevious3
					waterBudgetList.wcpresent3= params.wcpresent3
					waterBudgetList.egpresent3= params.egpresent3
					waterBudgetList.egprevious3= params.egprevious3
					
					waterBudgetList.waterbudgettype4="Industrial cooling boiler feed,D.M.Plant,etc."
					waterBudgetList.wcprevious4= params.wcprevious4
					waterBudgetList.wcpresent4= params.wcpresent4
					waterBudgetList.egpresent4= params.egpresent4
					waterBudgetList.egprevious4= params.egprevious4
					if(waterBudgetList.save()){
						println("saved")
					}else{
						waterBudgetList.errors.each(){
							print it
						}
					}
			        redirect(action:popAddWaterBudget,params:[appliId:app,type:type])
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
		  }
	}
	
	def popViewWaterBudgetDetails={
			 try {
				 def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
			       def app = IndApplicationDetails.get((appId).toInteger())
		        	def waterBudgetList =WaterBudget.findAllByApplication(app)
		        	def type=params.type
		        		return [type:type,appDetId:app,waterBudgetList:waterBudgetList]
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
		  }
	}
	
	def popWaterBudgetDetailsEdit = {
			 try {
				 def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
			       def app = IndApplicationDetails.get((appId).toInteger())
		        	def waterBudgetList =WaterBudget.findAllByApplication(app)
		        	def type=params.type
		    		return [type:type,appDetId:app,waterBudgetList:waterBudgetList]
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def deleteWaterBudgetDetails = {
			 try {
					def app = IndApplicationDetails.get((params.appid).toInteger())
					def type=params.type
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def waterBudgetInst = WaterBudget.get((params.delete).toInteger())
			    		waterBudgetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def waterBudgetInst = WaterBudget.get((params.delete[i]).toInteger())
			        		waterBudgetInst.delete()
			        	}
			    	}
			    	redirect(action:popWaterBudgetDetailsEdit,params:[appliId:app,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popAddTradeEffluent={
			 try {
				 println("params.."+params)
					def d = params.d
					def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
			        	def tradeEffulentList =TradeEffluent.findAllByApplication(app)
			        	def type=params.type
			        	return [type:type,appDetId:app,tradeEffulentList:tradeEffulentList,d:d]		
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			 redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			       session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
			 }
	}
	
	def saveTradeEffulentDetails = {
			 try {
				 def app = IndApplicationDetails.get((params.appid).toInteger())
				 def type=params.type
			    	def x=params.doss_value
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					def date1 = sdfh.parse(x); //Date
			    		def tradeEffulentInstanceList = new TradeEffluent()
			    	tradeEffulentInstanceList.application = app
			    	tradeEffulentInstanceList.doss=date1
			    	tradeEffulentInstanceList.ph= params.ph
			    	tradeEffulentInstanceList.doin= params.doin
			    	tradeEffulentInstanceList.bdo= params.bdo
			    	tradeEffulentInstanceList.cod= params.cod
			    	tradeEffulentInstanceList.ss= params.ss
			    	tradeEffulentInstanceList.og= params.og
			    	tradeEffulentInstanceList.other= params.other
			        tradeEffulentInstanceList.save()
			        redirect(action:popAddTradeEffluent,params:[appliId:app,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popViewTradeEffluent={
			 try {
				 def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
		        	def tradeEffulentList =TradeEffluent.findAllByApplication(app)
		        	def type=params.type
		        		return [type:type,appDetId:app,tradeEffulentList:tradeEffulentList]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popTradeEffluentEdit = {
			 try {
				 def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
		        	def tradeEffulentList =TradeEffluent.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:app,tradeEffulentList:tradeEffulentList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	   }
	}
	
	def deleteTradeEffluentDetails = {
			 try {
					def app = IndApplicationDetails.get((params.appid).toInteger())
					def type=params.type
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def tradeEffluentInst = TradeEffluent.get((params.delete).toInteger())
			    		tradeEffluentInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def tradeEffluentInst = TradeEffluent.get((params.delete[i]).toInteger())
			        		tradeEffluentInst.delete()
			        	}
			    	}
			    	redirect(action:popTradeEffluentEdit,params:[appliId:app,type:type])
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popAddSewageDetails={
			 try {
					def d = params.d
					def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
			        def sewageDetailsList =SewageDetails.findAllByApplication(app)
			        def type=params.type
			       return [type:type,appDetId:app,sewageDetailsList:sewageDetailsList,d:d]		
				 }
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			       redirect(uri:'/index.gsp');
			 }
		 }
	}
	
	def saveSewageDetails = {
			 try {
					def app = IndApplicationDetails.get((params.appid).toInteger())
					def type=params.type
			    	def x=params.dossc_value
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					def date1 = sdfh.parse(x); //Date
			  		def sewageDetailsList = new SewageDetails()
			    	sewageDetailsList.application = app
			    	sewageDetailsList.dossc=date1
			    	sewageDetailsList.ph= params.ph
			    	sewageDetailsList.tss= params.tss
			    	sewageDetailsList.bdo= params.bdo
			    	sewageDetailsList.save()
			        redirect(action:popAddSewageDetails,params:[appliId:app,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popViewSewageDetails={
			 try {
				 def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
		        	def sewageDetailsList =SewageDetails.findAllByApplication(app)
		        	def type=params.type
		        		return [type:type,appDetId:app,sewageDetailsList:sewageDetailsList]
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		          session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popSewageDetailsEdit = {
			 try {
				 def appId
					if(params.appId){
					appId=params.appId }else{
						appId=params.appliId
					}
					def app = IndApplicationDetails.get((appId).toInteger())
		        	def sewageDetailsList =SewageDetails.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:app,sewageDetailsList:sewageDetailsList]
		     }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def deleteSewageDetails = {
			 try {
					def app = IndApplicationDetails.get((params.appid).toInteger())
					def type=params.type
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def sewageDetailsInst = SewageDetails.get((params.delete).toInteger())
			    		sewageDetailsInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def sewageDetailsInst = SewageDetails.get((params.delete[i]).toInteger())
			        		sewageDetailsInst.delete()
			        	}
			    	}
			    	redirect(action:popSewageDetailsEdit,params:[appliId:app,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
		}				
	}
	
	 def popConsentInspectionReport={
			 try {
				 println("popConsentInspectionReport.."+params)
					def app = IndApplicationDetails.get((params.id).toInteger())
					 println("app.."+app)
					def newInst = ConsentInspectionReport.findByApplication(app)
					println("newInst.."+newInst)
					def list = IndProductDetails.findAll("from IndProductDetails abc where abc.application=?",[app])	
					insertIndustryDataIntoInspection(app)
					return[appId:app,newInst:newInst,list:list,consentInspInst:newInst]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def saveConsentInspectionReport={

			 try {
				 println("in saveConsentInspectionReport..."+saveConsentInspectionReport)
				 println("in params..."+params)
					def indApplicationDetailsInstance=IndApplicationDetails.get(params.appId)
					println("indApplicationDetailsInstance..."+indApplicationDetailsInstance)
					def check = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
					println("check..."+check)
					if(check)
					{
						check.delete()
					}
					def applicationFor =indApplicationDetailsInstance.applicationFor
					println("applicationFor..."+applicationFor)
					def certificateFor = indApplicationDetailsInstance.certificateFor
					println("certificateFor..."+certificateFor)
					def consentInspInst= new ConsentInspectionReport(params)
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String userInput = "01/01/1950";
					Date defaulDate = formatter.parse(userInput);
					def a=formatter.parse(params.periodapplied_value);
					consentInspInst.application=indApplicationDetailsInstance
		            consentInspInst.dateOfReceipt=defaulDate
		            consentInspInst.deeRecommendations=""
		            consentInspInst.dateOfReceiptdistrict=defaulDate
		            consentInspInst.dateOfReceiptcentral=defaulDate
		            consentInspInst.periodapplied=a
		            if(params.redistoff){
		            	println("in params..."+params.redistoff)
		            	consentInspInst.redistoff=params.redistoff
		            }else{
		            	consentInspInst.redistoff=""
		            }
		        	def hotelRest
					def roomCapacity
			if(applicationFor=="hotel")	
			{
				consentInspInst.hotelRest=params.hotelRest
				consentInspInst.roomCapacity=params.roomCapacity
			}else{
				consentInspInst.hotelRest=""
				consentInspInst.roomCapacity=""
			}
		            if((applicationFor=="stonecrusher") || (indApplicationDetailsInstance.indUser.industryType.industryType=="Hot mix plants") ||
		            		(applicationFor=="hotmixplants") || (applicationFor=="stonecrusher and hotmixplants"))
		        	{
		            	consentInspInst.greenBelt=params.greenBelt
						consentInspInst.waterSprinkle=params.waterSprinkle
						consentInspInst.jacketing=params.jacketing
						consentInspInst.windBreaking=params.windBreaking
						consentInspInst.metallingRoads=params.metallingRoads
		        		consentInspInst.spmLevel=params.spmLevel
		        		consentInspInst.resArea=params.resArea  
		        	}else{
		        		consentInspInst.greenBelt=""
		        				consentInspInst.waterSprinkle=""
		        				consentInspInst.jacketing=""
		        				consentInspInst.windBreaking=""
		        				consentInspInst.metallingRoads=""
		        				consentInspInst.spmLevel=""
		        		        consentInspInst.resArea=""
		        	 }
		           if(applicationFor=="brickkilns")	
		        	{consentInspInst.chamber=params.chamber
		            	consentInspInst.chimney=params.chimney
		            consentInspInst.others=params.others
						consentInspInst.plantation=params.plantation
		            consentInspInst.roadsWall=params.roadsWall
		            }else{
		            	consentInspInst.chamber=""
  		                 consentInspInst.chimney=""
	   		                 consentInspInst.others=""
	   		     				consentInspInst.plantation=""
	   		                 consentInspInst.roadsWall="" }
		            if(applicationFor=="both")	
		        	{
		            	consentInspInst.capacityUtili=params.capacityUtili
						consentInspInst.chemicalQty=params.chemicalQty
		        		consentInspInst.chemicalStorage=params.chemicalStorage
		        		consentInspInst.closeShed=params.closeShed
		        		consentInspInst.disposalArrange=params.disposalArrange
						consentInspInst.enviorment=params.enviorment
						consentInspInst.addSewagereq=params.addSewagereq
		        		consentInspInst.expansionPlant=params.expansionPlant
		        		consentInspInst.leachate=params.leachate
						consentInspInst.leachateCollect=params.leachateCollect
						consentInspInst.management=params.management
						consentInspInst.methodOfDisposal=params.methodOfDisposal
		        		consentInspInst.methodOftreatment=params.methodOftreatment
		        		consentInspInst.modernization=params.modernization
						consentInspInst.nonHazQty=params.nonHazQty
						consentInspInst.publicLiability=params.publicLiability
		        		consentInspInst.saleName=params.saleName
						consentInspInst.separateElectric=params.separateElectric
						consentInspInst.sewageEffluent=params.sewageEffluent
						consentInspInst.storedOrDisposed=params.storedOrDisposed
		        		consentInspInst.treatmentArrang=params.treatmentArrang
		        		consentInspInst.typeofNonHaz=params.typeofNonHaz
		        		consentInspInst.areaincSewage=params.areaincSewage
		        		consentInspInst.incSewage=params.incSewage
					}else{
						consentInspInst.capacityUtili=""
						consentInspInst.chemicalQty=""
		        		consentInspInst.chemicalStorage=""
		        		consentInspInst.closeShed=""
						consentInspInst.disposalArrange=""
						consentInspInst.enviorment=""
						consentInspInst.addSewagereq=""
		        		consentInspInst.expansionPlant=""
		        		consentInspInst.leachate=""
						consentInspInst.leachateCollect=""
						consentInspInst.management=""
						consentInspInst.methodOfDisposal=""
		        		consentInspInst.methodOftreatment=""
		        		consentInspInst.modernization=""
						consentInspInst.nonHazQty=""
						consentInspInst.publicLiability=""
		        		consentInspInst.quantityrecycler=""
		        		consentInspInst.saleName=""
						consentInspInst.separateElectric=""
						consentInspInst.sewageEffluent=""
						consentInspInst.storedOrDisposed=""
		        		consentInspInst.treatmentArrang=""
		        		consentInspInst.typeofNonHaz=""
		        		consentInspInst.areaincSewage=""
			        	consentInspInst.incSewage=""
			        }
		            if(params.senstiveArea){
		            	consentInspInst.senstiveArea=params.senstiveArea
		            }else{
		            	consentInspInst.senstiveArea=""
		            }
		            if(params.specificArea){
		            	consentInspInst.specificArea=params.specificArea
		            }else{
		            	consentInspInst.specificArea=""
		            }
		            if(params.legal){
		            	consentInspInst.legal=params.legal
		            }else{
		            	consentInspInst.legal=""
		            }
		            if(params.authorityName){
		            	consentInspInst.authorityName=params.authorityName
		            }else{
		            	consentInspInst.authorityName=""
		            }
		            if(params.brickTiles){consentInspInst.brickTiles=params.brickTiles}else{consentInspInst.brickTiles=""}
		            if(params.prestan){consentInspInst.prestan=params.prestan}else{consentInspInst.prestan=""}
		            if(params.publicComplain){consentInspInst.publicComplain=params.publicComplain}else{consentInspInst.publicComplain=""}
		            if(params.recieveEnviroment){consentInspInst.recieveEnviroment=params.recieveEnviroment}else{consentInspInst.recieveEnviroment=""}
		            if(params.costPCD){consentInspInst.costPCD=params.costPCD}else{consentInspInst.costPCD=""}
		            if(params.reinspoff){consentInspInst.reinspoff=params.reinspoff}else{consentInspInst.reinspoff=""}
		            if(params.reregioff){consentInspInst.reregioff=params.reregioff}else{consentInspInst.reregioff=""}
		            if(params.categoryHaz){consentInspInst.categoryHaz=params.categoryHaz}else{consentInspInst.categoryHaz=""}
		            if(params.areaSpecific){consentInspInst.areaSpecific=params.areaSpecific}else{consentInspInst.areaSpecific=""}
		            if(params.areaSenstive){consentInspInst.areaSenstive=params.areaSenstive}else{consentInspInst.areaSenstive=""}
		            if(!consentInspInst.hasErrors() && consentInspInst.save(flush:true)) {
		            	println("SAVED")
					} else {
						consentInspInst.errors.each {
							println it;
						   }
					}
		    		def inspReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Inspection Report'",[indApplicationDetailsInstance])
						if(inspReport)
		            		{
							inspReport.delete()
		            		}
					if(!consentInspInst.hasErrors() && consentInspInst.save(flush:true)) {
						println("SAVED")
					} else {
						consentInspInst.errors.each {
							println it; 
					   }
					}
					def consentInspectionReportInst = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
					UserMaster sess=(UserMaster)session.userMaster
					def userMasterInst=UserMaster.get(sess.id)
					InspectionReport report=new InspectionReport()
					report.freshReport(indApplicationDetailsInstance.id,userMasterInst.id,consentInspectionReportInst)
					flash.message = "Fresh Inspection Report Details Saved"
					redirect(action:popConsentInspectionReport,id:indApplicationDetailsInstance,consentInspInst:consentInspectionReportInst)		
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		}
	}
 
def printFreshInspectionReport={
			 try {
		   		 def applicationFileInstance
		 	    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
		 	    	applicationFileInstance=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Inspection Report' order by afr.id desc",[application])
		 	    	def applicationFileSingleInstance=applicationFileInstance
		 		   response.setContentType( "application-xdownload")
		 		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
	
def printRegularInspectionReport={
			 try {
		   		 def applicationFileInstance
		 	    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
		 	    	applicationFileInstance=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Regular Inspection Report' order by afr.id desc",[application])
		 	    	def applicationFileSingleInstance=applicationFileInstance
		 		   response.setContentType( "application-xdownload")
		 		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
		
////////////////////////RITESH/////////////////////////////////
	def popDeeRecommendationsFresh = {
			println("popDeeRecommendationsFresh"+params)
			//def type=params.type
			def app = IndApplicationDetails.get((params.id).toInteger())
			println("ap"+ app)
			def consentInspectionReportInst = ConsentInspectionReport.findByApplication(app)			
			return[appId:app,consentInspectionReportInst:consentInspectionReportInst]	
	}
	
	def saveDeeRecommendationsFresh ={
		println("paramsssssssssss...."+params)
		def indApplicationDetailsInstance=IndApplicationDetails.get(params.appId)
		println("indApplicationDetailsInstance...."+indApplicationDetailsInstance)
		def consentInspectionInst = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
		println("consentInspectionInst...."+consentInspectionInst)
		UserMaster sess=(UserMaster)session.userMaster
		println("sess...."+sess)
		def userMasterInst=UserMaster.get(sess.id)
		String recomadationType=(params.type)
		
		
			
		ConsentInspectionReportEERecommendations deeRecommendationInstancebb=new ConsentInspectionReportEERecommendations();
		deeRecommendationInstancebb.application=indApplicationDetailsInstance;
		deeRecommendationInstancebb.deeRecommendations=params.deeRecommendations
		deeRecommendationInstancebb.deeOfficer=userMasterInst
		deeRecommendationInstancebb.dateCreated= new Date()
		deeRecommendationInstancebb.save(flush:true)	
		
		def consentInspectionReportInst = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
		
		InspectionReportDee report=new InspectionReportDee()
		report.freshReport(indApplicationDetailsInstance.id,userMasterInst.id,consentInspectionReportInst,recomadationType)
		
		flash.message = "Officer Remarks Saved"
		
		redirect(action:popDeeRecommendationsFresh,consentInspInst:consentInspectionReportInst,params:[id:indApplicationDetailsInstance,type:recomadationType])
	
		
		
		
}
	
	///////////////////////////////////////////////////////
	
	
	
	
	def popConsentDetailAdd={
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
		        	def consentDetailsList =ConsentDetails.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:app,consentDetailsList:consentDetailsList]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def saveConsentDetails = {
			 try {
					def app = IndApplicationDetails.get((params.appid).toInteger())
					def type=params.type
			    	def x=params.dateConsent_value
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					def date1 = sdfh.parse(x); //Date
			    	def consentDetailsList = new ConsentDetails()
			    	consentDetailsList.application = app
			    	consentDetailsList.dateConsent=date1
			    	consentDetailsList.consent= params.consent
			    	consentDetailsList.number= params.number
			    	consentDetailsList.save()
			    	redirect(action:popConsentDetailAdd,params:[id:app,type:type])
			}
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	  }
	}
	
	def popConsentDetailView={
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
		        	def consentDetailsList =ConsentDetails.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:app,consentDetailsList:consentDetailsList]
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def popConsentDetailEdit = {
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
		        	def consentDetailsList =ConsentDetails.findAllByApplication(app)
		        	def type=params.type
		        	return [type:type,appDetId:app,consentDetailsList:consentDetailsList]
		    }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}
	
	def deleteConsentDetails = {
			 try {
					def app = IndApplicationDetails.get((params.appid).toInteger())
					def type=params.type
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def consentDetailsList = ConsentDetails.get((params.delete).toInteger())
			    		consentDetailsList.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def consentDetailsList = ConsentDetails.get((params.delete[i]).toInteger())
			        		consentDetailsList.delete()
			        	}
			    	}
			    	redirect(action:popConsentDetailEdit,params:[id:app,type:type])
			 }
			 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
  }
	}
	
	def insertIndustryDataIntoInspection(IndApplicationDetails indAppDetailInstance) {
		 try {
			 println("params.in insertIndustryDataIntoInspection."+params)
				def airInstanceList =AirStackDetailsInspection.findAll("from AirStackDetailsInspection  where application = ? ",[indAppDetailInstance])
					if(airInstanceList.size() == 0){
		        		def oldAirInstanceList = AirStackDetailsMaster.findAll("from AirStackDetailsMaster where application = ? ",[indAppDetailInstance])
		        		if(oldAirInstanceList.size() != 0){
		        			for(int i=0;i<oldAirInstanceList.size();i++){
		        				AirStackDetailsInspection airStackMaster = new AirStackDetailsInspection();
		        				def oldAirstackSingleInstance = AirStackDetailsMaster.find("from AirStackDetailsMaster where id = ? ",[oldAirInstanceList.get(i).id])
		        				airStackMaster.application   = indAppDetailInstance
		        				airStackMaster.stack  = oldAirstackSingleInstance.stack
		        				airStackMaster.heightGrdLevel  = oldAirstackSingleInstance.heightGrdLevel
		        				airStackMaster.heightFacLevel  = oldAirstackSingleInstance.heightFacLevel
		        				airStackMaster.draftType  = oldAirstackSingleInstance.draftType
		        				airStackMaster.matOfCon  = oldAirstackSingleInstance.matOfCon
		        				airStackMaster.capacity  = oldAirstackSingleInstance.capacity
		        				airStackMaster.unit	 = oldAirstackSingleInstance.unit
		        				airStackMaster.fuelTyp  = oldAirstackSingleInstance.fuelTyp
		        				airStackMaster.fuelQty  = oldAirstackSingleInstance.fuelQty
		        				airStackMaster.gasQty  = oldAirstackSingleInstance.gasQty
		        				airStackMaster.shape  = oldAirstackSingleInstance.shape
		        				airStackMaster.diamSize  = oldAirstackSingleInstance.diamSize
		        				airStackMaster.gasTemp  = oldAirstackSingleInstance.gasTemp
		        				airStackMaster.gasVel  = oldAirstackSingleInstance.gasVel
		        				if(!airStackMaster.hasErrors() && airStackMaster.save(flush:true)) {
		        				} else {
		        					airStackMaster.errors.each {
		        						println it
		        				    }
		        				}	
		        			}
		        		}else{
		        		}
		       	 }
				def newList5 = IndProductDetailsInspection.findAll("from IndProductDetailsInspection where application = ? ",[indAppDetailInstance])
			if(newList5.size() == 0){
				def oldList5 = IndProductDetailsMaster.findAll("from IndProductDetailsMaster where application = ? ",[indAppDetailInstance])
				if(oldList5.size() != 0){
					for(int i=0;i<oldList5.size();i++){
						IndProductDetailsInspection master5 = new IndProductDetailsInspection();
						def oldSingleInstance5 = IndProductDetailsMaster.find("from IndProductDetailsMaster where id = ? ",[oldList5.get(i).id])
						master5.application   = indAppDetailInstance
						master5.product = oldSingleInstance5.product
						master5.quantity = oldSingleInstance5.quantity
						master5.unit = oldSingleInstance5.unit
						master5.byProduct = oldSingleInstance5.byProduct
						master5.unitbyProduct = oldSingleInstance5.unitbyProduct
						master5.rawMaterials = oldSingleInstance5.rawMaterials
						if(!master5.hasErrors() && master5.save(flush:true)) {
			 	       } else {
							master5.errors.each {
								println it
						   }
						}	
					}
				}else{
				}
			 }
				def newList17 = HotelFacilityDetailInspection.findAll("from HotelFacilityDetailInspection  where application = ? ",[indAppDetailInstance])
			if(newList17.size() == 0){
				def oldList17 = HotelFacilityDetailMaster.findAll("from HotelFacilityDetailMaster where application = ? ",[indAppDetailInstance])
				if(oldList17.size() != 0){
					for(int i=0;i<oldList17.size();i++){
						HotelFacilityDetailInspection master17 = new HotelFacilityDetailInspection();
						def oldSingleInstance17 = HotelFacilityDetailMaster.find("from HotelFacilityDetailMaster where id = ? ",[oldList17.get(i).id])
						master17.application   = indAppDetailInstance
						master17.hotelFacilityType = oldSingleInstance17.hotelFacilityType
						master17.facility = oldSingleInstance17.facility
						master17.capacity=oldSingleInstance17.capacity
						master17.facilityDetail = oldSingleInstance17.facilityDetail
						if(!master17.hasErrors() && master17.save(flush:true)) {
			 	       } else {
							master17.errors.each {
								println it
						    }
						}	
					}
				}else{
				}
			 }
				def newList19 = HotelWaterConsumptionDetailInspection .findAll("from HotelWaterConsumptionDetailInspection where application = ? ",[indAppDetailInstance])
			if(newList19.size() == 0){
				def oldList19 = HotelWaterConsumptionDetailMaster.findAll("from HotelWaterConsumptionDetailMaster where application = ? ",[indAppDetailInstance])
				if(oldList19.size() != 0){
					for(int i=0;i<oldList19.size();i++){
						HotelWaterConsumptionDetailInspection master19 = new HotelWaterConsumptionDetailInspection();
						def oldSingleInstance19 = HotelWaterConsumptionDetailMaster.find("from HotelWaterConsumptionDetailMaster where id = ? ",[oldList19.get(i).id])
						master19.application   = indAppDetailInstance
						master19.type = oldSingleInstance19.type
						master19.quantity = oldSingleInstance19.quantity
						if(!master19.hasErrors() && master19.save(flush:true)) {
			 	       	} else {
							master19.errors.each {
								println it
						    }
						}	
					}
				}else{
				}
			 }
				def newList16 = HotelGeneralDetailsInspection.findAll("from HotelGeneralDetailsInspection where application = ? ",[indAppDetailInstance])
				if(newList16.size() == 0){
					def oldList16 = HotelGeneralDetailsMaster.findAll("from HotelGeneralDetailsMaster where application = ? ",[indAppDetailInstance])
					if(oldList16.size() != 0){
						for(int i=0;i<oldList16.size();i++){
							HotelGeneralDetailsInspection master16= new HotelGeneralDetailsInspection();
							def oldSingleInstance16 = HotelGeneralDetailsMaster.find("from HotelGeneralDetailsMaster where id = ? ",[oldList16.get(i).id])
							master16.application   = indAppDetailInstance
							master16.hotelName = oldSingleInstance16.hotelName
							master16.roomCapacity = oldSingleInstance16.roomCapacity
							master16.restaurantN=oldSingleInstance16.restaurantN
							master16.capacity = oldSingleInstance16.capacity
							master16.year = oldSingleInstance16.year
							master16.investment=oldSingleInstance16.investment
							master16.location = oldSingleInstance16.location
							master16.distance = oldSingleInstance16.distance
							master16.prevention=oldSingleInstance16.prevention
							master16.relInfo = oldSingleInstance16.relInfo
							master16.dgSet = oldSingleInstance16.dgSet
							master16.make=oldSingleInstance16.make
							master16.dgcapacity = oldSingleInstance16.dgcapacity
							master16.deptTourism = oldSingleInstance16.deptTourism
							master16.tourismDetails=oldSingleInstance16.tourismDetails
							master16.septicTank = oldSingleInstance16.septicTank
							master16.soakagePit = oldSingleInstance16.soakagePit
							master16.sewagePlant=oldSingleInstance16.sewagePlant
							master16.hotelchimeny = oldSingleInstance16.hotelchimeny
							master16.exhaustFans = oldSingleInstance16.exhaustFans
							master16.solidWaste=oldSingleInstance16.solidWaste
							master16.greenery = oldSingleInstance16.greenery
							master16.indpendentRestaurant = oldSingleInstance16.indpendentRestaurant
							master16.nocObtained=oldSingleInstance16.nocObtained
							if(!master16.hasErrors() && master16.save(flush:true)) {
				 	       	} else {
								master16.errors.each {
									println it
							    }
							}	
						}
					}else{
					}
				 }
//////////////////////////////////////Hazardeous wAste Details
				def newList20 = HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection where application = ? ",[indAppDetailInstance])
				if(newList20.size() == 0){
					def oldList20 = HazardousWasteGenDetailsMaster.findAll("from HazardousWasteGenDetailsMaster where application = ? ",[indAppDetailInstance])
					if(oldList20.size() != 0){
						for(int i=0;i<oldList20.size();i++){
							HazardousWasteGenDetailsInspection master20= new HazardousWasteGenDetailsInspection();
							def oldSingleInstance16 = HazardousWasteGenDetailsMaster.find("from HazardousWasteGenDetailsMaster where id = ? ",[oldList20.get(i).id])
							master20.application   = indAppDetailInstance
							master20.authFor = oldSingleInstance16.authFor
							master20.sourceName = oldSingleInstance16.sourceName
							master20.categoryName=oldSingleInstance16.categoryName
							master20.quantity = oldSingleInstance16.quantity
							if(!master20.hasErrors() && master20.save(flush:true)) {
				 	       	} else {
				 	       	master20.errors.each {
				 	       		println it
							    }
							}	
						}
					}else{
					}
				 }
def newList191 = HotelGeneralDetailsInspection .findAll("from HotelGeneralDetailsInspection where application = ? ",[indAppDetailInstance])
		if(newList191.size() == 0){
					def oldList19 = HotelGeneralDetailsMaster.findAll("from HotelGeneralDetailsMaster where application = ? ",[indAppDetailInstance])
					if(oldList19.size() != 0){
						for(int i=0;i<oldList19.size();i++){
							HotelGeneralDetailsInspection master19 = new HotelGeneralDetailsInspection();
							def oldSingleInstance19 = HotelGeneralDetailsMaster.find("from HotelGeneralDetailsMaster where id = ? ",[oldList19.get(i).id])
							master19.application   = indAppDetailInstance
							master19.hotelName = oldSingleInstance19.hotelName
							master19.roomCapacity = oldSingleInstance19.roomCapacity
							master19.restaurantN=oldSingleInstance19.restaurantN
							master19.capacity = oldSingleInstance19.capacity
							master19.year = oldSingleInstance19.year
							master19.investment=oldSingleInstance19.investment
							master19.location = oldSingleInstance19.location
							master19.distance = oldSingleInstance19.distance
							master19.prevention=oldSingleInstance19.prevention
							master19.relInfo = oldSingleInstance19.relInfo
							master19.dgSet = oldSingleInstance19.dgSet
							master19.make=oldSingleInstance19.make
							master19.dgcapacity = oldSingleInstance19.dgcapacity
							master19.deptTourism = oldSingleInstance19.deptTourism
							master19.tourismDetails=oldSingleInstance19.tourismDetails
							master19.septicTank = oldSingleInstance19.septicTank
							master19.soakagePit = oldSingleInstance19.soakagePit
							master19.sewagePlant=oldSingleInstance19.sewagePlant
							master19.hotelchimeny = oldSingleInstance19.hotelchimeny
							master19.exhaustFans = oldSingleInstance19.exhaustFans
							master19.solidWaste=oldSingleInstance19.solidWaste
							master19.greenery = oldSingleInstance19.greenery
							master19.indpendentRestaurant = oldSingleInstance19.indpendentRestaurant
							master19.nocObtained=oldSingleInstance19.nocObtained
							if(!master19.hasErrors() && master19.save(flush:true)) {
				 	       	} else {
								master19.errors.each {
									println it
							    }
							}	
						}
					}else{
					}
				 }
def newList195 = StoneCrusherWaterReqInspection .findAll("from StoneCrusherWaterReqInspection where application = ? ",[indAppDetailInstance])
if(newList195.size() == 0){
	def oldList19 = StoneCrusherWaterReqMaster.findAll("from StoneCrusherWaterReqMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			StoneCrusherWaterReqInspection master19 = new StoneCrusherWaterReqInspection();
			def oldSingleInstance19 = StoneCrusherWaterReqMaster.find("from StoneCrusherWaterReqMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.sourceOfWaterSupply = oldSingleInstance19.sourceOfWaterSupply
			master19.quantity = oldSingleInstance19.quantity
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }
def newList1951 = BrickKilnDetailInspection .findAll("from BrickKilnDetailInspection where application = ? ",[indAppDetailInstance])
if(newList1951.size() == 0){
	def oldList19 = BrickKilnDetailMaster.findAll("from BrickKilnDetailMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			BrickKilnDetailInspection master19 = new BrickKilnDetailInspection();
			def oldSingleInstance19 = BrickKilnDetailMaster.find("from BrickKilnDetailMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.capacity = oldSingleInstance19.capacity
			master19.trenchSize = oldSingleInstance19.trenchSize
			master19.chimeny=oldSingleInstance19.chimeny
			master19.height = oldSingleInstance19.height
			master19.ecd = oldSingleInstance19.ecd
			master19.cluster=oldSingleInstance19.cluster
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }				
def newList19512 = BrickSittingCriteriaDetailsInspection.findAll("from BrickSittingCriteriaDetailsInspection where application = ? ",[indAppDetailInstance])
if(newList19512.size() == 0){
	def oldList19 = BrickSittingCriteriaDetailsMaster.findAll("from BrickSittingCriteriaDetailsMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			BrickSittingCriteriaDetailsInspection master19 = new BrickSittingCriteriaDetailsInspection();
			def oldSingleInstance19 = BrickSittingCriteriaDetailsMaster.find("from BrickSittingCriteriaDetailsMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.parameter = oldSingleInstance19.parameter
			master19.distance=oldSingleInstance19.distance
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }
def newList195123a = StoneCrusherControlDevicesInspection .findAll("from StoneCrusherControlDevicesInspection where application = ? ",[indAppDetailInstance])
if(newList195123a.size() == 0){
	def oldList19 = StoneCrusherControlDevicesMasterM.findAll("from StoneCrusherControlDevicesMasterM where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			StoneCrusherControlDevicesInspection master19 = new StoneCrusherControlDevicesInspection();
			def oldSingleInstance19 = StoneCrusherControlDevicesMasterM.find("from StoneCrusherControlDevicesMasterM where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.device = oldSingleInstance19.device
			master19.name = oldSingleInstance19.name
			master19.status = oldSingleInstance19.status
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }		
def newList195123 = StoneCrusherSittingCriteriaInspection .findAll("from StoneCrusherSittingCriteriaInspection where application = ? ",[indAppDetailInstance])
if(newList195123.size() == 0){
	def oldList19 = StoneCrusherSittingCriteriaMaster.findAll("from StoneCrusherSittingCriteriaMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			StoneCrusherSittingCriteriaInspection master19 = new StoneCrusherSittingCriteriaInspection();
			def oldSingleInstance19 = StoneCrusherSittingCriteriaMaster.find("from StoneCrusherSittingCriteriaMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.parameter = oldSingleInstance19.parameter
			master19.distance = oldSingleInstance19.distance
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }	
def newList1951232 = NocAuthorityDetailsInspection .findAll("from NocAuthorityDetailsInspection where application = ? ",[indAppDetailInstance])
if(newList1951232.size() == 0){
	def oldList19 = NocAuthorityDetailsMaster.findAll("from NocAuthorityDetailsMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			NocAuthorityDetailsInspection master19 = new NocAuthorityDetailsInspection();
			def oldSingleInstance19 = NocAuthorityDetailsMaster.find("from NocAuthorityDetailsMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.authorityDetails = oldSingleInstance19.authorityDetails
			master19.number = oldSingleInstance19.number
			master19.status=oldSingleInstance19.status
			master19.date=oldSingleInstance19.date
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }	
def newList19512321 = DGSetParameterDetailsInspection .findAll("from DGSetParameterDetailsInspection where application = ? ",[indAppDetailInstance])
if(newList19512321.size() == 0){
	def oldList19 = DGSetParameterDetailsMaster.findAll("from DGSetParameterDetailsMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			DGSetParameterDetailsInspection master19 = new DGSetParameterDetailsInspection();
			def oldSingleInstance19 = DGSetParameterDetailsMaster.find("from DGSetParameterDetailsMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.parameters = oldSingleInstance19.parameters
			master19.noLoad=oldSingleInstance19.noLoad
			master19.fullLoad = oldSingleInstance19.fullLoad
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }	
def newList195123211 = DGSetEmissionDetailsInspection .findAll("from DGSetEmissionDetailsInspection where application = ? ",[indAppDetailInstance])
if(newList195123211.size() == 0){
	def oldList19 = DGSetEmissionDetailsMaster.findAll("from DGSetEmissionDetailsMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			DGSetEmissionDetailsInspection master19 = new DGSetEmissionDetailsInspection();
			def oldSingleInstance19 = DGSetEmissionDetailsMaster.find("from DGSetEmissionDetailsMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.source = oldSingleInstance19.source
			master19.horsePower = oldSingleInstance19.horsePower
			master19.noLoadRPM=oldSingleInstance19.noLoadRPM
			master19.fullLoadRPM = oldSingleInstance19.fullLoadRPM
			master19.fuelQuantity = oldSingleInstance19.fuelQuantity
			master19.capacity=oldSingleInstance19.capacity
			master19.buildingHeight = oldSingleInstance19.buildingHeight
			master19.stackHeight = oldSingleInstance19.stackHeight
			master19.totalHeight=oldSingleInstance19.totalHeight
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }	
def newList19512321a = DGSetDetailsInspection .findAll("from DGSetDetailsInspection where application = ? ",[indAppDetailInstance])
if(newList19512321a.size() == 0){
	def oldList19 = DGSetDetailsMaster.findAll("from DGSetDetailsMaster where application = ? ",[indAppDetailInstance])
	if(oldList19.size() != 0){
		for(int i=0;i<oldList19.size();i++){
			DGSetDetailsInspection master19 = new DGSetDetailsInspection();
			def oldSingleInstance19 = DGSetDetailsMaster.find("from DGSetDetailsMaster where id = ? ",[oldList19.get(i).id])
			master19.application   = indAppDetailInstance
			master19.makeDGset = oldSingleInstance19.makeDGset
			master19.modelDGset = oldSingleInstance19.modelDGset
			master19.powerRating=oldSingleInstance19.powerRating
			master19.soundLevel = oldSingleInstance19.soundLevel
			master19.location = oldSingleInstance19.location
			master19.loadShedding=oldSingleInstance19.loadShedding
			master19.sheddingInfo = oldSingleInstance19.sheddingInfo
			master19.noise = oldSingleInstance19.noise
			master19.room=oldSingleInstance19.room
			master19.exhaustGas = oldSingleInstance19.exhaustGas
			master19.installation = oldSingleInstance19.installation
			master19.minVibration=oldSingleInstance19.minVibration
			master19.minLeaks = oldSingleInstance19.minLeaks
			master19.fuel = oldSingleInstance19.fuel
			master19.stackHeight=oldSingleInstance19.stackHeight
			master19.heightOfBuilding = oldSingleInstance19.heightOfBuilding
			master19.totalHeight = oldSingleInstance19.totalHeight
			if(!master19.hasErrors() && master19.save(flush:true)) {
 	       	} else {
				master19.errors.each {
					println it
			    }
			}	
		}
	}else{
	}
 }	

		 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		         session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
		}
	}
	
def viewReturnReason = {
		 try {
				def application = IndApplicationDetails.get((params.id).toLong())
				def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'desc',offset:0]) 
				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
					if((applicationProcessingDetailsInstanceList.get(i)).returned==true){
						return[appReturn:applicationProcessingDetailsInstanceList.get(i),app:application]
					}
				}
		}
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	   redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	         redirect(uri:'/index.gsp');
	 }
 }
	}

def dgsetExempCertificate={
		 try {
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				render(view:'dgsetExempCertificate',model:[viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance])	
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	}
	}

def indExempCertificate={
		 try {
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				render(view:'indExempCertificate',model:[viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance])	
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		  redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
     }
	}

def pdfindexmpt={

		 try {
				File certFile
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def officeAddress=params.offAddres
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				ExemptIndPdfGeneration pdfG=new ExemptIndPdfGeneration()
				def indname=indRegInstance.indName
				def indaddress=indRegInstance.indAddress
				def inddistrict=indRegInstance.district.districtName
				def indtehsil=indRegInstance.tehsil.tehsilName
				def indPin=indRegInstance.indPin
				def manufacturing=params.productCapacity
				def divisionalofficer=params.product
				def reginaldirector=""
				def conditions=params.generalConditions
				def copyTo=""
				def fileNumberIn=params.fileNumber
				def endtNumberIn=params.endtNumber
				def offDistrict=params.nameOfDistrict
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def maxQuantity=""
				def wasteWater=params.wasteWater
				def capInvest=params.capInvest
				def waterConsume=params.waterConsume
				def sewageEffluent=params.sewageEffluent
				def specificConditionsforAuth=params.specificConditionsforAuth
///////////////////Consent No////////////////////////
				def occName = indRegInstance.occName
				Integer year1 = new Date().getYear().toInteger()
				String year=(year1+1900).toString()
				String yearString = (String)year.substring(2,4)
				def issuingConsentTypeNo		
				if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="new"){
					issuingConsentTypeNo="01"
				}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="expan"){
					issuingConsentTypeNo="02"
				}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="reNew"){
					issuingConsentTypeNo="03"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="new"){
					issuingConsentTypeNo="04"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="expan"){
					issuingConsentTypeNo="05"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="reNew"){
					issuingConsentTypeNo="06"
				}
/////////////////////to get Current year/////////////////////////////////////
				SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
				java.util.Date nowDate = new java.util.Date();
				String currentYear = formatNowYear.format(nowDate);
				println("currentYear..."+currentYear)
///////////////////////////////////////////////////////////////
				def recordCertificate = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				 def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
				if(recordCertificate)
					{
						recordCertificate.delete()
					}
				 if(filerecordinstance)
				 {
					 filerecordinstance.delete();
				 }
						recordCertificateInstance.startDate=new Date()
						recordCertificateInstance.endDate=new Date()
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.generalCondition=""
						recordCertificateInstance.specificCondition=""
						recordCertificateInstance.subjectData=""
						recordCertificateInstance.maxQuantity=maxQuantity
						recordCertificateInstance.copyTo=copyTo
						recordCertificateInstance.refData=""
						recordCertificateInstance.wasteWater=wasteWater
						recordCertificateInstance.capInvest=capInvest
						recordCertificateInstance.waterConsume=waterConsume
						recordCertificateInstance.sewageEffluent=sewageEffluent
						recordCertificateInstance.specificConditionsforAuth=specificConditionsforAuth
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Exemption Certificate Generated and Record Saved "
								certFile=pdfG.pdfFunction(indname,indaddress,inddistrict,indtehsil,indPin,manufacturing,divisionalofficer,reginaldirector,conditions,draftDate,
										yearString,issuingConsentTypeNo,appID,currentYear,occName)
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
								redirect(action:appProcessing,params:["id":params.idIndApp])
							} else {
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
							render(view:'indExempCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
						}
						else {
							if(recordCertificateInstance.hasErrors()){
								recordCertificateInstance.errors.allErrors.each {
									println it
		                	 }
		                	 } 
						}
				render(view:'indExempCertificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance])	
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
 }
}

def pdfdgsetexmpt=
{

		 try {
				File certFile
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def officeAddress=params.offAddres
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				ExemptDGSetPdfGeneration pdfG=new ExemptDGSetPdfGeneration()
				def indname=indRegInstance.indName
				def indaddress=indRegInstance.indAddress
				def inddistrict=indRegInstance.district.districtName
				def indtehsil=indRegInstance.tehsil.tehsilName
				def indPin=indRegInstance.indPin
				def capacity=params.productCapacity
				def divisionalofficer=params.product
				def reginaldirector=""
				def conditions=params.generalConditions
				def copyTo=""
				def fileNumberIn=params.fileNumber
				def endtNumberIn=params.endtNumber
				def offDistrict=params.nameOfDistrict
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def maxQuantity=""
				def wasteWater=params.wasteWater
				def capInvest=params.capInvest
				def waterConsume=params.waterConsume
				def sewageEffluent=params.sewageEffluent
				def specificConditionsforAuth=params.specificConditionsforAuth
///////////////////Consent No////////////////////////
				def occName = indRegInstance.occName
				Integer year1 = new Date().getYear().toInteger()
				String year=(year1+1900).toString()
				String yearString = (String)year.substring(2,4)
				def issuingConsentTypeNo		
				if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="new"){
					issuingConsentTypeNo="01"
				}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="expan"){
					issuingConsentTypeNo="02"
				}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="reNew"){
					issuingConsentTypeNo="03"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="new"){
					issuingConsentTypeNo="04"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="expan"){
					issuingConsentTypeNo="05"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="reNew"){
					issuingConsentTypeNo="06"
				}
/////////////////////to get Current year/////////////////////////////////////
				SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
				java.util.Date nowDate = new java.util.Date();
				String currentYear = formatNowYear.format(nowDate);
				println("currentYear..."+currentYear)
///////////////////////////////////////////////////////////////
			 def recordCertificate = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
			  def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
					if(recordCertificate)
							{
							recordCertificate.delete()
							}
				 if(filerecordinstance)
					 {
						 filerecordinstance.delete();
					 }
						recordCertificateInstance.startDate=new Date()
						recordCertificateInstance.endDate=new Date()
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.generalCondition=""
						recordCertificateInstance.specificCondition=""
						recordCertificateInstance.subjectData=""
						recordCertificateInstance.maxQuantity=maxQuantity
						recordCertificateInstance.copyTo=copyTo
						recordCertificateInstance.refData=""
						recordCertificateInstance.wasteWater=wasteWater
						recordCertificateInstance.capInvest=capInvest
						recordCertificateInstance.waterConsume=waterConsume
						recordCertificateInstance.sewageEffluent=sewageEffluent
						recordCertificateInstance.specificConditionsforAuth=specificConditionsforAuth
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Exemption Certificate Generated and Record Saved "
								certFile=pdfG.pdfFunction(indname,indaddress,inddistrict,indtehsil,indPin,capacity,divisionalofficer,reginaldirector,conditions,draftDate,
										yearString,issuingConsentTypeNo,appID,currentYear,occName)
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
								redirect(action:appProcessing,params:["id":params.idIndApp])
							} else {
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
								render(view:'dgsetExempCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
						}
						else {
							if(recordCertificateInstance.hasErrors()){
								recordCertificateInstance.errors.allErrors.each {
									println it
		                	  }
		                	 } 
					}
				render(view:'dgsetExempCertificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance])	
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	 }
}

def uploadExemptConsentOrder = {
		 try {
		 		def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def viewCertupload = false
				def certInst = UploadConsentOrder.findByApplicationId(indApplicationDetailsInstance)
				if(certInst)
				{
					viewCertupload = true
				}
				def roleHeader=app.role.roleName
		    	return [appDetId:params.appliId,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload]
		     }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		   redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		         redirect(uri:'/index.gsp');
		 }
	 }
	}

def saveExemptOrder= {
		 try {
		 		def idAppl= (params.idIndApp).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def viewCertupload = false
				def certInst = UploadConsentOrder.findByApplicationId(indApplicationDetailsInstance)
				if(certInst)
				{
					viewCertupload = true
				}
				def roleHeader=app.role.roleName
				def recordCertificateInstance=new UploadConsentOrder()
				ApplicationFileRecord file=new ApplicationFileRecord()
				def referenceDate=params.referenceDate_value
				def zz
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
				zz = sdfh.parse(referenceDate);
				java.sql.Date refDate = new java.sql.Date(zz.getTime())
				if(session.userMaster==null)
				    	{
							flash.message="Your session has been expired ! Please login again."
				    		redirect(uri:'/index.gsp')
				    		return
				    	}
						def refNo = ""
						if(params.referenceNo)
						{
							refNo = params.referenceNo
						}
						else
						{
							flash.message="Please enter Reference no. for this application"
								render(view:'uploadExemptConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
								return
						}
				    	recordCertificateInstance.referenceNo=refNo
				    	recordCertificateInstance.referenceDate=refDate
				    	recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.startDate=new Date()
						recordCertificateInstance.endDate=new Date()
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors()) {	
							def f = request.getFile('consentOrder')
							if(!f.empty) {
								def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='ConsentOrder'",[(indApplicationDetailsInstance.id).toLong()])
								if(filerecordinstance)
										 {
											 filerecordinstance.delete();
										 }
				    			MultipartFile multi = request.getFile('consentOrder')
								file.size = multi.getSize() / 1024
								file.extension = extractExtension( multi )
								file.data=multi.getBytes()
								def abc = "CertiFicate"
					            def b = abc+"."+extractExtension( multi )
					            file.name =b 
					            file.description="Certificate Generation Record"	
					            	if(session.userMaster==null)
					            	{
					            		flash.message="Your session has been expired ! Please login again."
					            		redirect(uri:'/index.gsp')
					            		return
					            	}
								file.createdBy=(session.userMaster).toString()
						 	    file.updatedBy=(session.userMaster).toString()
								file.typeOfFile="ConsentOrder"
					 	    	file.indApplication=indApplicationDetailsInstance
					 	    	file.dateCreated=new Date()
								Byte[] bytes=multi.getBytes() 
								if(file.save()) {
									recordCertificateInstance.save()
									flash.message = "Exemption Certificate Generated and Record Saved "
								} else {
									flash.userMessage = "File [${file.name}] has NOT not been uploaded."
										render(view:'uploadExemptConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
										}
							}					
							redirect(action:appProcessing,params:["id":params.idIndApp,"viewCertupload":viewCertupload])
						}
						else {
							flash.message="Can not contain special characters or reserve words"
						if(recordCertificateInstance.hasErrors()){
								recordCertificateInstance.errors.allErrors.each {
									println it
		                	 }
		                	 } 
							render(view:'uploadExemptConsentOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCertupload:viewCertupload])
						}			
		 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		          redirect(uri:'/index.gsp');
		 }
	 }
	}

def greenCertificate={
		println("in greencertificate"+params)
 try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				insertIndustryDataIntoConsentOrder(indApplicationDetailsInstance)
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				indRegInstance.refresh()
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}				
				 def recordCertificateInstance = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				render(view:'greenCertificate',model:[recordCertificateInstance:recordCertificateInstance,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	  }
	}

def pdfgreen={
		println("params in pdfhgrren....."+params)
			try { 
				File certFile
				File certFile12
				ApplicationFileRecord file=new ApplicationFileRecord()
				def recordCertificateInstance=new RecordCertificate()
				def appID=params.idIndApp
				def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
				def indRegInstance=indApplicationDetailsInstance.indUser
				def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
				def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
				def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
				def indCategory=(indRegInstance.category.name).toUpperCase()
				def id = (indApplicationDetailsInstance.id).toString()
				def indNewCapInvt=indRegInstance.indCapInvt.toString()
				def id3=indApplicationDetailsInstance.indUser 
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray = new String[sizeVal] 
				for(int i=0; i<conditionMasterList.size();i++) {
					conditionArray[i]=(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG = new String[sizeValG] 
				for(int i=0; i<conditionMasterListG.size();i++) {
					conditionArrayG[i]=(conditionMasterListG.get(i)).condition
				}
				def referenceCheck=params.references
				println("referenceCheck1211112 "+referenceCheck.getClass().getName())
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize] 
				def referenceStore=""
				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
				}
				def dateCreateOn=indApplicationDetailsInstance.applicationDate
				def hazType=indApplicationDetailsInstance.hazardeousType
				def abcFinal1=dateCreateOn
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
				def dDate=new Date()
				def abcFinal=dDate
				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				def val=params.pdfc
				def val2=params.pdfc2
				def val3=params.pdfc3
				DevImg dimg=new DevImg()
				def name=indRegInstance.indName
				def address=indRegInstance.indAddress
				def tehsil1=indRegInstance.tehsil.toString()
				def indCity = indRegInstance.indCity
				def pin =indRegInstance.indPin
				def district=(indRegInstance.district).toString()
				def fileN=params.fileNo
				def order="40001"
				def videNo="980"
				def subject=params.subject
				def cntrlequipment=params.cntrlequipment
				PdfGenerationgreen pdfG=new PdfGenerationgreen()
				def sCondition=params.specificConditions
				def gCondition=""
				def indusName = indRegInstance.indName
				def indAddress = indRegInstance.indAddress
				def occName = indRegInstance.occName
				def occAddress=indRegInstance.occAddress
				/////////////////////to get Current year
				SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
				java.util.Date nowDate = new java.util.Date();
				String currentYear = formatNowYear.format(nowDate);
				println("currentYear..."+currentYear)
				def industrytype12=industryTypeMasterInstance.industryType
				def effluentGeneration=""
				def waterConsumption = ""
				///////////////////Consent No////////////////////////
				Integer year1 = new Date().getYear().toInteger()
				String year=(year1+1900).toString()
				String yearString = (String)year.substring(2,4)
				def issuingConsentTypeNo		
				if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="new"){
					issuingConsentTypeNo="01"
				}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="expan"){
					issuingConsentTypeNo="02"
				}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="reNew"){
					issuingConsentTypeNo="03"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="new"){
					issuingConsentTypeNo="04"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="expan"){
					issuingConsentTypeNo="05"
				}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="reNew"){
					issuingConsentTypeNo="06"
				}
////////////////////////////////Authorization Number/////////////////////////////
				def authno="H"
				
////////////////////////////////////////end here
//////////////////////////////Fetch data from Schedule II(IR)////////////////////////////////////////////////////				
					def check = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
					println("check..."+check)
					if(check){
						indNewCapInvt = check.totalCap
					}
					
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
				def category=indRegInstance.category.name 
				def regId = indRegInstance.indRegNum
				def regDate = indRegInstance.regDate
				def dfh = new SimpleDateFormat("dd/MM/yyyy"); 
				regDate= dfh.format((java.util.Date) regDate)
			def productDetailsList1 = new ArrayList()
				def productDetailsInstance1=CosentCertProductDetails.findAllByApplication(indApplicationDetailsInstance)
			int cc = 1
				for(int var10=0;var10<productDetailsInstance1.size();var10++)
				{
					def productList1= new ArrayList()
					String s = Integer.toString(cc)
					productList1.add(s)
					productList1.add(productDetailsInstance1.get(var10).product)
					productList1.add(productDetailsInstance1.get(var10).quantity)
					productList1.add(productDetailsInstance1.get(var10).unit.unitName)
					productDetailsList1.add(productList1)
					cc++
				}

////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
def stackDetailsList = new ArrayList()
			def stackDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
				int cccc = 1
						for(int var10=0;var10<stackDetailsInstance.size();var10++)
							{
							def stackList= new ArrayList()
							String s = Integer.toString(cccc)
							stackList.add(s)
							stackList.add(stackDetailsInstance.get(var10).stackAttachedTo)
							stackList.add(stackDetailsInstance.get(var10).stackVolume)
							stackList.add(stackDetailsInstance.get(var10).stackHeight)
							stackList.add(stackDetailsInstance.get(var10).topDiameter)
							stackList.add(stackDetailsInstance.get(var10).velocityOfGasEmission)
							stackDetailsList.add(stackList)
							cccc++
							}
////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
def fuelDetailsList = new ArrayList()
			def fuelDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
				int e22 = 1
						for(int var10=0;var10<fuelDetailsInstance.size();var10++)
							{
							def fuelList= new ArrayList()
							String s = Integer.toString(e22)
							fuelList.add(s)
							fuelList.add(fuelDetailsInstance.get(var10).typeOfFuel)
							fuelList.add(fuelDetailsInstance.get(var10).maximumQuantity)
							fuelList.add(fuelDetailsInstance.get(var10).unit.unitName)
							fuelDetailsList.add(fuelList)
							e22++
							}
////////////////////////////////Solid Waste Disposal Details///////////////////////////////////////////////	
def solidWasteDisposalDetailsList1 = new ArrayList()
				def solidWasteDisposalDetailsInstance1=CosentCertSolidWasteDisposalDetails.findAllByApplication(indApplicationDetailsInstance)
					int cs = 1
					for(int var10=0;var10<solidWasteDisposalDetailsInstance1.size();var10++){
							def solidWasteDisposalDetailsList= new ArrayList()
								String s = Integer.toString(cs)
								solidWasteDisposalDetailsList.add(s)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).typeofWaste)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).quantity)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).disMode.disposalMode)
								solidWasteDisposalDetailsList1.add(solidWasteDisposalDetailsList)
								cs++
							}
//////////////////////////////////////////Hazardeous Waste Details////////////////////////////////////////////////
def hazardousWasteGenDetailsList = new ArrayList()
def hazardousWasteGenDetailsInstance1=HazardousWasteGenDetailsCert.findAllByApplication(indApplicationDetailsInstance)
	for(int var10=0;var10<hazardousWasteGenDetailsInstance1.size();var10++){
			def hazardousWasteDetailsList= new ArrayList()
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).authFor);
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).sourceName.name);
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.name);
				//hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.category);
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).quantity);
				hazardousWasteGenDetailsList.add(hazardousWasteDetailsList)
			}
println("hazardousWasteGenDetailsList..."+hazardousWasteGenDetailsList);
//////////////////////////////////////////////////////////
////////////////////////////Stack details for hote////////////////////////////
def stackDetailsList1 = new ArrayList()
		def stackDetailsInstance1=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
			int cccc1 = 1
					for(int var10=0;var10<stackDetailsInstance1.size();var10++)
						{
						def stackList1= new ArrayList()
						String s = Integer.toString(cccc1)
						stackList1.add(s)
						stackList1.add(stackDetailsInstance1.get(var10).stackAttachedTo)
						stackList1.add(stackDetailsInstance1.get(var10).stackHeight)
						stackDetailsList1.add(stackList1)
						cccc1++
						}
////////////////////////////////////////////////////////Hotel details////////////////////
def productDetailsList11 = new ArrayList()
def productDetailsInstance11=CosentCertHotelDetails.findAllByApplication(indApplicationDetailsInstance)
int cc3 = 1
for(int var10=0;var10<productDetailsInstance11.size();var10++)
{
	def productList11= new ArrayList()
	String s = Integer.toString(cc3)
	productList11.add(s)
	productList11.add(productDetailsInstance11.get(var10).product)
	productList11.add(productDetailsInstance11.get(var10).quantity)
	productDetailsList11.add(productList11)
	cc3++
}
////////////////////////////////Pollution Control Equipment Details////////////////////////////////////////////	
def PollutionControlList = new ArrayList()
		def PollutionControlInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
		println("PollutionControlInstance...."+PollutionControlInstance)
			int e226 = 1
					for(int var10=0;var10<PollutionControlInstance.size();var10++)
						{
						def PollutionList= new ArrayList()
						String s = Integer.toString(e226)
						PollutionList.add(s)
						String pollControl=PollutionControlInstance.get(var10).pollutionCntrlMeasure
						println("pollControl..."+pollControl)
						pollControl=pollControl.replace("]","")
						pollControl=pollControl.replace("[","")
						println("pollControl..."+pollControl)
						PollutionList.add(pollControl)
						PollutionControlList.add(PollutionList)
						e226++
						}
println("PollutionControlList...."+PollutionControlList)
				def copyTo=params.copyTo 
				def wasteWater=params.wasteWater
				def capInvest=params.capInvest
				def waterConsume=params.waterConsume
				def sewageEffluent=params.sewageEffluent
				def specificConditionsforAuth=params.specificConditionsforAuth
				def fileNumberIn
				if(params.fileNumber){
					fileNumberIn=params.fileNumber
				}else{fileNumberIn=""}
				def endtNumberIn
				if(params.endtNumber){
				endtNumberIn=params.endtNumber
				}else{
					endtNumberIn=""
				}
				def nameOfDistrict=""
				def offDistrict=indRegInstance.district.districtName
				def draftDate=params.draftLetterDate_value
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def maxQuantity=params.maxQuantity
				occName=params.occName
				def indName=params.indName
				def indRegNum=params.indRegNum
				def indRegDate=params.indRegDate_value
				def checkDate
				def x
				def y
				println("startDate1 "+startDate1)
				println("endDate1 "+endDate1)
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					checkDate="checked"
				}
				catch(Exception e) {
					flash.message="Enter Both The Consent Granted Dates "
					render(view:'greenCertificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
				}
				if(checkDate) {
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					if(sqlDate>sqlDate2) {
						flash.message="Grant To Date should be Greater than Grant From Date"
						render(view:'greenCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}else {
						def recordCertificate = RecordCertificate.find("from RecordCertificate abc where abc.applicationId=? and abc.typeofCertificate='Prepared'",[indApplicationDetailsInstance])
						 def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
						def filerecordinstance1=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Authorization'",[(indApplicationDetailsInstance.id).toLong()])
						 if(recordCertificate)
							{
							recordCertificate.delete()
							}
						 if(filerecordinstance)
						 {
							 filerecordinstance.delete();
						 }
						 if(filerecordinstance1)
						 {
							 filerecordinstance1.delete();
						 }
						recordCertificateInstance.startDate=sqlDate
						recordCertificateInstance.endDate=sqlDate2
						recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.generalCondition=gCondition
						recordCertificateInstance.specificCondition=sCondition
						recordCertificateInstance.subjectData=params.subject
						recordCertificateInstance.refData=referenceStore
						recordCertificateInstance.maxQuantity=maxQuantity
						recordCertificateInstance.copyTo=copyTo
						recordCertificateInstance.wasteWater=wasteWater
						recordCertificateInstance.capInvest=capInvest
						recordCertificateInstance.waterConsume=waterConsume
						recordCertificateInstance.sewageEffluent=sewageEffluent
						recordCertificateInstance.typeofCertificate="Prepared"
						if(specificConditionsforAuth!=null){
							recordCertificateInstance.specificConditionsforAuth=specificConditionsforAuth
							}else{
								recordCertificateInstance.specificConditionsforAuth=""
							}
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						boolean hotelCheck=false
						///////////////////////////HOTEL////////////////////////////
						String string = indRegInstance.industryType.industryType;
					      String keyword = "HOTELS";
					      String keyword1 = "Hotels";
					      String keyword2 = "hotels";
					      boolean found = Arrays.asList(string.split(" ")).contains(keyword);
					      boolean found1 = Arrays.asList(string.split(" ")).contains(keyword1);
					      boolean found2 = Arrays.asList(string.split(" ")).contains(keyword2);
					      if(found || found1 || found2){
					            System.out.println("Keyword matched the string"+found);
					            //cementCheck = true;
					            hotelCheck = true;	
					      }
						if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
							flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
							
							println("referenceCheck.getClass().getName()=="+referenceCheck.getClass().getName())
								if(hazType=="HWM"){
									println("deepak 111")
									def  file1=new ApplicationFileRecord()
									def pdAuth=new PdfGenerationAuthorization()
									if(referenceCheck.getClass().getName()=="java.lang.String") {
									
										certFile12=pdAuth.pdfFunctionAuthorization(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
												indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
												applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
												indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsume,effluentGeneration,authno,
												PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,specificConditionsforAuth,hazardousWasteGenDetailsList)
									}else{
										
										certFile12=pdAuth.pdfFunctionAuthorization(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
												indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
												applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
												indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsume,effluentGeneration,authno,
												PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,specificConditionsforAuth,hazardousWasteGenDetailsList)
									}
									def link="link"
										byte[] b1 = new byte[(int) certFile12.length()];
										FileInputStream fileInputStream11 = new FileInputStream(certFile12);
										fileInputStream11.read(b1);
										def fileLength111=certFile12.length()
										file1.size = fileLength111 / 1024  //f.getSize() 
										file1.extension ="pdf"//extractExtension( f )
										file1.data=b1;
										file1.name="Authorization.pdf"
										file1.description="Authorization"
										file1.createdBy=session.userMaster
										file1.updatedBy=session.userMaster
										file1.typeOfFile="Authorization"
										file1.indApplication=indApplicationDetailsInstance
										if(file1.save()) {
										} else {
											file1.errors.each
											{
												println it
											}
										}
								}
							if(hotelCheck){
								println("deepak 444")
								if(referenceCheck.getClass().getName()=="java.lang.String") {
								
									certFile=pdfG.pdfFunctionHotel(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
											indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
											applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,stackDetailsList1,cntrlequipment,fuelDetailsList,industrytype12,
											indCategory,offDistrict,productDetailsList11,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,
											waterConsumption,effluentGeneration,authno,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
								}else{
								
									certFile=pdfG.pdfFunctionHotel(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
											indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
											applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,stackDetailsList1,cntrlequipment,fuelDetailsList,industrytype12,
											indCategory,offDistrict,productDetailsList11,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,
											waterConsumption,effluentGeneration,authno,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
								}	
							}
							else{
								println("deepak 777")
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								
								certFile=pdfG.pdfFunction(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										capInvest,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,applType,maxQuantity,
										productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,currentYear,industrytype12,
										offDistrict,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,nameOfDistrict,waterConsume,
										authno,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList,indCategory)
							}else{
							
								certFile=pdfG.pdfFunctionArray(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										capInvest,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,applType,maxQuantity,
										productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,currentYear,industrytype12,
										offDistrict,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,nameOfDistrict,waterConsume,
										authno,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList,indCategory)
							}}
							def link="link"
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file.size = fileLength / 1024  //f.getSize() 
							file.extension ="pdf"//extractExtension( f )
							file.data=b;
							file.name="CertiFicate.pdf"
							file.description="Certificate Generation Record"
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
							file.typeOfFile="Certificate"
							file.indApplication=indApplicationDetailsInstance
							if(file.save()) {
//								code added for dashboard change start from here
								def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(indApplicationDetailsInstance.id).toString()]);
								if(allSummaryReportInstance)
								{
								allSummaryReportInstance.dateOfIssue=abcFinal;
								allSummaryReportInstance.dateOfexpiry=sqlDate2;
								if( !allSummaryReportInstance.hasErrors()&& allSummaryReportInstance.save(flush:true)){
									
								}
								}
							//code ends here
								redirect(action:appProcessing,params:["id":params.idIndApp])
							} else {
								println("in else file");
								file.errors.each
								{
									println it
								}
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
								render(view:'greenCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
							}
						}
						else {
							println("in else recordCertificateInstance");
							recordCertificateInstance.errors.each
							{
								println it
							}
							render(view:'greenCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}
					}
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		       redirect(uri:'/index.gsp');
		 }
	 }
		
}

def redOrangeCertificate={
		println("in redOrangecertificate"+params)
		try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				println("i am here")
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					
				insertIndustryDataIntoConsentOrder(indApplicationDetailsInstance)
			println("i am here.......")
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				indRegInstance.refresh()
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}
				def recordCertificateInstance = RecordCertificate.find("from RecordCertificate where applicationId=? and typeofCertificate='Prepared'",[indApplicationDetailsInstance])
				render(view:'redOrangeCertificate',model:[recordCertificateInstance:recordCertificateInstance,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	  }
}

def pdfredOange={
		println("params in pdfredOange....."+params)
		
		File certFile
		File certFile12
		ApplicationFileRecord file=new ApplicationFileRecord()
		
		def recordCertificateInstance=new RecordCertificate()
		def appID=params.idIndApp
		def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
		def indRegInstance=indApplicationDetailsInstance.indUser
		def applFor=indApplicationDetailsInstance.applicationFor
		println("--applFor--+-"+applFor)
		def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
		def certFor=indApplicationDetailsInstance.certificateFor
		println("certFor..."+certFor)
		if(certFor.equals("new")){
			certFor="Fresh"
            }
            if(certFor.equals("Modern")){
            	certFor = "Modernization "
            }
            if(certFor.equals("expan")){
            	certFor = "Expansion"
            }
            if(certFor.equals("reNew")){
            	certFor = "Renew"
            } 
		def indCategory=(indRegInstance.category.name).toUpperCase()
		def id = (indApplicationDetailsInstance.id).toString()
		def indNewCapInvt=indRegInstance.indCapInvt.toString()
		def waterConsumption = ""
		def effluentGeneration = ""
		def offDistrict=indRegInstance.district.districtName
		def id3=indApplicationDetailsInstance.indUser 
		def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
		def industrytype12=industryTypeMasterInstance.industryType
		println("industryTypeMasterInstance..."+industryTypeMasterInstance.industryType)
//////////////////////////////Fetch data from Schedule II(IR)////////////////////////////////////////////////////				
		def check = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
		def waterIns=WaterBudget.findByApplication(indApplicationDetailsInstance)
		println("check..."+check)
		println("waterIns..."+waterIns)
		if(check){
			indNewCapInvt = check.totalCap
		}
		if(waterIns){
			waterConsumption = waterIns.wcpresent
			effluentGeneration = waterIns.egpresent
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		def id2=indApplicationDetailsInstance.applicationType
		def consentForVar=indApplicationDetailsInstance.certificateFor
		def applicationForVar=indApplicationDetailsInstance.applicationFor
		def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
		def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
		def sizeVal=conditionMasterList.size()
		def conditionArray = new String[sizeVal] 
		for(int i=0; i<conditionMasterList.size();i++) {
			conditionArray[i]=(conditionMasterList.get(i)).condition
		}
		def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
		def sizeValG=conditionMasterListG.size()
		def conditionArrayG = new String[sizeValG] 
		for(int i=0; i<conditionMasterListG.size();i++) {
			conditionArrayG[i]=(conditionMasterListG.get(i)).condition
		}
		def referenceCheck=params.references
		def refSize=referenceCheck.size()
		def referencesArray = new String[refSize] 
		def referenceStore=""
		if(referenceCheck.getClass().getName()=="java.lang.String") {
			referenceStore="1. "+referenceCheck
		}else{
			for(int varI=0; varI<referenceCheck.size();varI++) {
				int varInteger=varI+1
				referencesArray[varI]=referenceCheck[varI]
				referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
			}
		}
		for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
		}
		def dateCreateOn=indApplicationDetailsInstance.applicationDate
		def hazType=indApplicationDetailsInstance.hazardeousType
		def abcFinal1=dateCreateOn
		DateCustom dd1=new DateCustom()
		def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
		def dDate=new Date()
		def abcFinal=dDate
		DateCustom dd=new DateCustom()
		def todayDate= (dd.sQLdate1(abcFinal)).toString()
		def val=params.pdfc
		def val2=params.pdfc2
		def val3=params.pdfc3
		DevImg dimg=new DevImg()
		def name=indRegInstance.indName
		def address=indRegInstance.indAddress
		def tehsil1=indRegInstance.tehsil.toString()
		def indCity = indRegInstance.indCity
		def pin =indRegInstance.indPin
		def district=(indRegInstance.district).toString()
		def fileN=params.fileNo
		def order="40001"
		def videNo="980"
		def subject=params.subject
		def occName=params.occName
		def indName=params.indName
		def indRegNum=params.indRegNum
		def indRegDate=params.indRegDate_value
		def cntrlequipment
		if(params.cntrlequipment){
			cntrlequipment=params.cntrlequipment
		}else{
			cntrlequipment=""
		}
		PdfGenerationredOrange pdfG=new PdfGenerationredOrange()
		
		def sCondition=params.specificConditions
		def gCondition=params.generalConditions
		def indusName = indRegInstance.indName
		def indAddress = indRegInstance.indAddress
		def occAddress=indRegInstance.occAddress
/////////////////////to get Current year
		SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
		java.util.Date nowDate = new java.util.Date();
		String currentYear = formatNowYear.format(nowDate);
		println("currentYear..."+currentYear)
///////////////////Consent No////////////////////////
		Integer year1 = new Date().getYear().toInteger()
		String year=(year1+1900).toString()
		String yearString = (String)year.substring(2,4)
		def issuingConsentTypeNo		
		if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="new"){
			issuingConsentTypeNo="01"
		}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="expan"){
			issuingConsentTypeNo="02"
		}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="reNew"){
			issuingConsentTypeNo="03"
		}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="new"){
			issuingConsentTypeNo="04"
		}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="expan"){
			issuingConsentTypeNo="05"
		}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="reNew"){
			issuingConsentTypeNo="06"
		}
////////////////////////////////Authorization Number/////////////////////////////
				def authno="H"
////////////////////////////////////////end here
		def category=indRegInstance.category.name 
		def regId = indRegInstance.indRegNum
		def regDate = indRegInstance.regDate
		def dfh = new SimpleDateFormat("dd/MM/yyyy"); 
		regDate= dfh.format((java.util.Date) regDate)
	def productDetailsList1 = new ArrayList()
		def productDetailsInstance1=CosentCertProductDetails.findAllByApplication(indApplicationDetailsInstance)
	int cc = 1
		for(int var10=0;var10<productDetailsInstance1.size();var10++)
		{
			def productList1= new ArrayList()
			String s = Integer.toString(cc)
			productList1.add(s)
			productList1.add(productDetailsInstance1.get(var10).product)
			productList1.add(productDetailsInstance1.get(var10).quantity)
			productList1.add(productDetailsInstance1.get(var10).unit.unitName)
			productDetailsList1.add(productList1)
			cc++
		}
////////////////////////////////////////////////////////Hotel details////////////////////
		def productDetailsList11 = new ArrayList()
		def productDetailsInstance11=CosentCertHotelDetails.findAllByApplication(indApplicationDetailsInstance)
		int cc3 = 1
		for(int var10=0;var10<productDetailsInstance11.size();var10++)
		{
			def productList11= new ArrayList()
			String s = Integer.toString(cc3)
			productList11.add(s)
			productList11.add(productDetailsInstance11.get(var10).product)
			productList11.add(productDetailsInstance11.get(var10).quantity)
			productDetailsList11.add(productList11)
			cc3++
		}
////////////////////////////Stack details for hote////////////////////////////
def stackDetailsList1 = new ArrayList()
	def stackDetailsInstance1=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
		int cccc1 = 1
				for(int var10=0;var10<stackDetailsInstance1.size();var10++)
					{
					def stackList1= new ArrayList()
					String s = Integer.toString(cccc1)
					stackList1.add(s)
					stackList1.add(stackDetailsInstance1.get(var10).stackAttachedTo)
					stackList1.add(stackDetailsInstance1.get(var10).stackHeight)
					stackDetailsList1.add(stackList1)
					cccc1++
					}
////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
def stackDetailsList = new ArrayList()
	def stackDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
		int cccc = 1
				for(int var10=0;var10<stackDetailsInstance.size();var10++)
					{
					def stackList= new ArrayList()
					String s = Integer.toString(cccc)
					stackList.add(s)
					stackList.add(stackDetailsInstance.get(var10).stackAttachedTo)
					stackList.add(stackDetailsInstance.get(var10).stackVolume)
					stackList.add(stackDetailsInstance.get(var10).stackHeight)
					stackList.add(stackDetailsInstance.get(var10).topDiameter)
					stackList.add(stackDetailsInstance.get(var10).velocityOfGasEmission)
					stackDetailsList.add(stackList)
					cccc++
					}
////////////////////////////////Fuel Details////////////////////////////////////////////	
def fuelDetailsList = new ArrayList()
	def fuelDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
		int e22 = 1
				for(int var10=0;var10<fuelDetailsInstance.size();var10++)
					{
					def fuelList= new ArrayList()
					String s = Integer.toString(e22)
					fuelList.add(s)
					fuelList.add(fuelDetailsInstance.get(var10).typeOfFuel)
					fuelList.add(fuelDetailsInstance.get(var10).maximumQuantity)
					fuelList.add(fuelDetailsInstance.get(var10).unit.unitName)
					fuelDetailsList.add(fuelList)
					e22++
					}
////////////////////////////////Pollution Control Equipm,ent Details////////////////////////////////////////////	
def PollutionControlList = new ArrayList()
	def PollutionControlInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
	println("PollutionControlInstance...."+PollutionControlInstance)
		int e226 = 1
				for(int var10=0;var10<PollutionControlInstance.size();var10++)
					{
					def PollutionList= new ArrayList()
					String s = Integer.toString(e226)
					PollutionList.add(s)
					String pollControl=PollutionControlInstance.get(var10).pollutionCntrlMeasure
					println("pollControl..."+pollControl)
					pollControl=pollControl.replace("]","")
					pollControl=pollControl.replace("[","")
					println("pollControl..."+pollControl)
					PollutionList.add(pollControl)
					PollutionControlList.add(PollutionList)
					e226++
					}
println("PollutionControlList...."+PollutionControlList)
////////////////////////////////Solid Waste Disposal Details///////////////////////////////////////////////	
def solidWasteDisposalDetailsList1 = new ArrayList()
		def solidWasteDisposalDetailsInstance1=CosentCertSolidWasteDisposalDetails.findAllByApplication(indApplicationDetailsInstance)
			int cs = 1
			for(int var10=0;var10<solidWasteDisposalDetailsInstance1.size();var10++){
					def solidWasteDisposalDetailsList= new ArrayList()
						String s = Integer.toString(cs)
						solidWasteDisposalDetailsList.add(s)
						solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).typeofWaste)
						solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).quantity)
						solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).disMode.disposalMode)
						solidWasteDisposalDetailsList1.add(solidWasteDisposalDetailsList)
						cs++
					}
////////////////////////////////Hazardeous Waste Details///////////////////////////////////////////////	
def hazardousWasteGenDetailsList = new ArrayList()
		def hazardousWasteGenDetailsInstance1=HazardousWasteGenDetailsCert.findAllByApplication(indApplicationDetailsInstance)
			for(int var10=0;var10<hazardousWasteGenDetailsInstance1.size();var10++){
					def hazardousWasteDetailsList= new ArrayList()
						hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).authFor)
						hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).sourceName.name)
						hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.name)
						//hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.category)
						hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).quantity)
						hazardousWasteGenDetailsList.add(hazardousWasteDetailsList)
					}
println("hazardousWasteGenDetailsList..."+hazardousWasteGenDetailsList)
		def copyTo=params.copyTo
		def wasteWater=params.wasteWater
		def capInvest=params.capInvest
		def waterConsume=params.waterConsume
		def sewageEffluent=params.sewageEffluent
		def specificConditionsforAuth=params.specificConditionsforAuth
		def fileNumberIn
		if(params.fileNumber){
			fileNumberIn=params.fileNumber
		}else{
			fileNumberIn=""
		}
		def endtNumberIn=params.endtNumber
		def draftDate=params.draftLetterDate_value
		def startDate1=params.grantedFrom_value
		def endDate1=params.grantedTo_value
		def maxQuantity=params.maxQuantity
		def checkDate
		def x
		def y
		try {
			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
			x = sdfh.parse(startDate1); //Date
			y = sdfh.parse(endDate1);
			checkDate="checked"
		}
		catch(Exception e) {
			flash.message="Enter Both The Consent Granted Dates "
			render(view:'redOrangeCertificate',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
		}
		if(checkDate) {
			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
			if(sqlDate>sqlDate2) {
				flash.message="Grant To Date should be Greater than Grant From Date"
				render(view:'redOrangeCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
			}else {
				def recordCertificate = RecordCertificate.find("from RecordCertificate abc where abc.applicationId=? and abc.typeofCertificate='Prepared'",[indApplicationDetailsInstance])
				 def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
				def filerecordinstance1=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Authorization'",[(indApplicationDetailsInstance.id).toLong()])
				 if(recordCertificate)
					{
					recordCertificate.delete()
					}
				 if(filerecordinstance)
				 {
					 filerecordinstance.delete();
				 }
				 if(filerecordinstance1)
				 {
					 filerecordinstance1.delete();
				 }
				recordCertificateInstance.startDate=sqlDate
				recordCertificateInstance.endDate=sqlDate2
				recordCertificateInstance.updatedBy=session.userMaster
				recordCertificateInstance.createdBy=session.userMaster
				recordCertificateInstance.generalCondition=gCondition
				recordCertificateInstance.specificCondition=sCondition
				recordCertificateInstance.subjectData=params.subject
				recordCertificateInstance.refData=referenceStore
				recordCertificateInstance.maxQuantity=maxQuantity
				recordCertificateInstance.copyTo=copyTo
				recordCertificateInstance.wasteWater=wasteWater
				recordCertificateInstance.capInvest=capInvest
				recordCertificateInstance.waterConsume=waterConsume
				recordCertificateInstance.sewageEffluent=sewageEffluent
				recordCertificateInstance.typeofCertificate="Prepared"
				if(specificConditionsforAuth!=null){
				recordCertificateInstance.specificConditionsforAuth=specificConditionsforAuth
				}else{
					recordCertificateInstance.specificConditionsforAuth=""
				}
				recordCertificateInstance.applicationId=indApplicationDetailsInstance
				boolean hotelCheck=false
				boolean cementCheck=false
				boolean stonecrushers=false
				boolean stonecrushers1=false
				boolean pharmaCheck=false
				boolean pesticideCheck=false
				boolean bricklinCheck=false
				///////////////////////////HOTEL////////////////////////////
				String string = indRegInstance.industryType.industryType;
			      String keyword = "HOTELS";
			      String keyword1 = "Hotels";
			      String keyword2 = "hotels";
			      boolean found = Arrays.asList(string.split(" ")).contains(keyword);
			      boolean found1 = Arrays.asList(string.split(" ")).contains(keyword1);
			      boolean found2 = Arrays.asList(string.split(" ")).contains(keyword2);
			      if(found || found1 || found2){
			            System.out.println("Keyword matched the string"+found);
			            //cementCheck = true;
			            hotelCheck = true;	
			      }
			  /////////////////////////////CEMENT////////////////////////////////////////////
			  		String keywordC = "CEMENT";
				      String keyword1C = "Cement";
				      String keyword2C = "cement";
				      boolean foundC = Arrays.asList(string.split(" ")).contains(keywordC);
				      boolean found1C = Arrays.asList(string.split(" ")).contains(keyword1C);
				      boolean found2C = Arrays.asList(string.split(" ")).contains(keyword2C);
				      if(foundC || found1C || found2C){
				            System.out.println("Keyword matched the string"+foundC);
				            cementCheck = true;	
				      }
///////////////////////////Stone Crushers////////////////////////////
				      boolean foundS = string.contains("Stone crushers");
				      boolean foundS7 = string.contains("Hot mix plants");
				     if(foundS7){
				            System.out.println("Keyword matched the string"+foundS7);
				           stonecrushers1 = true;	
				      }
				     if(foundS){
				            System.out.println("Keyword matched the string"+foundS);
				           stonecrushers = true;	
				      }
/////////////////////////////Pharma////////////////////////////////////////////
						println("string....."+string)
				  		boolean foundC1 = string.contains("Pharma");
					     if(foundC1){
					            System.out.println("Keyword matched the string"+foundC1);
					            pharmaCheck = true;	
					      }
					      println("pharmaCheck....."+pharmaCheck)
////////////////////////////Pesticide////////////////////////////////////////////
					  		String keywordC11 = "PESTICIDES";
						      String keyword1C11 = "Pesticides";
						      String keyword2C11 = "pesticides";
						      boolean foundC11 = Arrays.asList(string.split(" ")).contains(keywordC11);
						      boolean found1C11 = Arrays.asList(string.split(" ")).contains(keyword1C11);
						      boolean found2C11 = Arrays.asList(string.split(" ")).contains(keyword2C11);
						      if(foundC11 || found1C11 || found2C11){
						            System.out.println("Keyword matched the string"+foundC11);
						            pesticideCheck = true;	
						      }		
//////////////////////////	/Brick Klin//////////////////////////////////////////
								 String keywordB = "Brick Kiln";
							      String keywordB1 = "brick kiln";
							      String keywordB2 = "BRICK KILN";
							      boolean foundB = Arrays.asList(string.split(" ")).contains(keywordB);
							      boolean foundB1 = Arrays.asList(string.split(" ")).contains(keywordB1);
							      boolean foundB2 = Arrays.asList(string.split(" ")).contains(keywordB2);
							      if(foundB || foundB1 || foundB2){
							            System.out.println("Keyword matched the string"+foundB);
							            //cementCheck = true;
							            bricklinCheck = true;	
							      }
//////////////////////////////////////////////////////////////////////////////////	


	println("referenceCheck.getClass().getName()=="+referenceCheck.getClass().getName())
	
	
				if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
					flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
					
						if(hazType=="HWM"){
							println("inside HWM")
							def  file1=new ApplicationFileRecord()
							def pdAuth=new PdfGenerationAuthorization()
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile12=pdAuth.pdfFunctionAuthorization(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,specificConditionsforAuth,hazardousWasteGenDetailsList)
							}else{
								certFile12=pdAuth.pdfFunctionAuthorization(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,specificConditionsforAuth,hazardousWasteGenDetailsList)
							}
							def link="link"
								byte[] b1 = new byte[(int) certFile12.length()];
								FileInputStream fileInputStream11 = new FileInputStream(certFile12);
								fileInputStream11.read(b1);
								def fileLength111=certFile12.length()
								file1.size = fileLength111 / 1024  //f.getSize() 
								file1.extension ="pdf"//extractExtension( f )
								file1.data=b1;
								file1.name="Authorization.pdf"
								file1.description="Authorization"
								file1.createdBy=session.userMaster
								file1.updatedBy=session.userMaster
								file1.typeOfFile="Authorization"
								file1.indApplication=indApplicationDetailsInstance
								if(file1.save()) {
								} else {
									file1.errors.each
									{
										println it
									}
								}
						}
					
					if(hotelCheck || indApplicationDetailsInstance.applicationFor=="hotel"){
						
						println("inside HWM hotelCheck")						
							
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							certFile=pdfG.pdfFunctionHotel(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,stackDetailsList1,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,productDetailsList11,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,
									waterConsumption,effluentGeneration,authno,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}else{
							certFile=pdfG.pdfFunctionHotel(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,stackDetailsList1,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,productDetailsList11,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,
									waterConsumption,effluentGeneration,authno,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}	
					}
					else if(cementCheck){
						println("inside cementCheck")
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							certFile=pdfG.pdfFunctionCement(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
						}else{
							certFile=pdfG.pdfFunctionCement(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
						}	
					}else if(stonecrushers || stonecrushers1 || indApplicationDetailsInstance.applicationFor=="hotmixplants" || 
							indApplicationDetailsInstance.applicationFor=="stonecrusher and hotmixplants" ||
							indApplicationDetailsInstance.applicationFor=="stonecrusher"){
						
						println("inside stonecrushers || hotmixplants || ")
						
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							certFile=pdfG.pdfFunctionStonecrushers(applFor,indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}else{
							certFile=pdfG.pdfFunctionStonecrushers(applFor,indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}	
					}else if(pharmaCheck){
						println("inside pharmaCheck ")
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							certFile=pdfG.pdfFunctionPharma(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
						}else{
							certFile=pdfG.pdfFunctionPharma(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
						}	
					}else if(pesticideCheck){
						println("inside pesticideCheck ")
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							certFile=pdfG.pdfFunctionPesticide(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
						}else{
							certFile=pdfG.pdfFunctionPesticide(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno
									,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
						}	
					}else if(bricklinCheck || indApplicationDetailsInstance.applicationFor=="brickkilns"){
						println("inside pesticideCheck ||  brickkilns")
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							certFile=pdfG.pdfFunctionBricklin(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}else{
							certFile=pdfG.pdfFunctionBricklin(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}
						}else{
							println("--in consent applied for both in Industry--")
					if(referenceCheck.getClass().getName()=="java.lang.String") {
						println("--in consent applied for both in Industry--if single--")
						certFile=pdfG.pdfFunctionIndustry(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
								indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
								applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
								indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
								PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
					}else{
						println("--in consent applied for both in Industry--if multiple--")
						certFile=pdfG.pdfFunctionIndustry(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
								indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
								applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
								indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
								PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
					}}
					def link="link"
					byte[] b = new byte[(int) certFile.length()];
					FileInputStream fileInputStream = new FileInputStream(certFile);
					fileInputStream.read(b);
					def fileLength=certFile.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.name="CertiFicate.pdf"
					file.description="Certificate Generation Record"
					file.createdBy=session.userMaster
					file.updatedBy=session.userMaster
					file.typeOfFile="Certificate"
					file.indApplication=indApplicationDetailsInstance
					if(file.save()) {
//						code added for dashboard change start from here
						def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(indApplicationDetailsInstance.id).toString()]);
						if(allSummaryReportInstance)
						{
						allSummaryReportInstance.dateOfIssue=abcFinal;
						allSummaryReportInstance.dateOfexpiry=sqlDate2;
						if( !allSummaryReportInstance.hasErrors()&& allSummaryReportInstance.save(flush:true)){
							
						}
						}
					//code ends here
						redirect(action:appProcessing,params:["id":params.idIndApp])
					} else {
						file.errors.each
						{
							println it
						}
						flash.userMessage = "File [${file.name}] has NOT not been uploaded."
						render(view:'redOrangeCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}
				
				}
				else {
					println("in else recordCertificateInstance");
					recordCertificateInstance.errors.each
					{
						println it
					}
					render(view:'redOrangeCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
				}
			}
		}
	 

}
//////////////////////////////////////hotel add,view,delete////////////////////////////////////////
def popConsentCertHotelDetailsAdd = {
		 try {
	        	def d = params.d
	        	def app = IndApplicationDetails.get((params.id).toInteger())
	        	def productDetailsList = CosentCertHotelDetails.findAllByApplication(app)
	        	return [appDetId:params.id,productDetailsList:productDetailsList,d:d]
	     }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	   redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	         redirect(uri:'/index.gsp');
	 }
  }
}
   
def popConsentCertHotelDetailsView = {
		 try {
	        	def app = IndApplicationDetails.get((params.id).toInteger())
	        	def productDetailsList = CosentCertHotelDetails.findAllByApplication(app)
	        	return [appDetId:params.id,productDetailsList:productDetailsList]
	    }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	  redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	            redirect(uri:'/index.gsp');
	 }
}
}
   
def popConsentCertHotelDetailsEdit = {
		 try {
		        def app = IndApplicationDetails.get((params.id).toInteger())
	        	def productDetailsList = CosentCertHotelDetails.findAllByApplication(app)
	        	return [appDetId:params.id,productDetailsList:productDetailsList]
	    }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	      redirect(uri:'/index.gsp');
	 }
 }
}
  
def saveHotelDetails = {
		 try {
		       def app = IndApplicationDetails.get((params.appId).toInteger())
		    	def indProductDetailsInstanceList = new ArrayList()
		        def qty = 0
		    	def indProductDetailsInstance = new CosentCertHotelDetails()
		        		indProductDetailsInstance.application = app
		        		indProductDetailsInstance.product = params.product
		        		indProductDetailsInstance.quantity = params.quantity
		        		indProductDetailsInstance.save()
		       redirect(action:popConsentCertHotelDetailsAdd,id:app)
		 }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	       	session.invalidate()
	            redirect(uri:'/index.gsp');
	 }
    }
}

def deleteHotelDetails = {
		 try {
		       def app = IndApplicationDetails.get((params.appId).toInteger())
		    	if((params.delete).getClass().getName()== "java.lang.String"){
		    		def indProdDetInst = CosentCertHotelDetails.get((params.delete).toInteger())
		    		indProdDetInst.delete()
		    	}else{
		    		if(params.delete)
		        	for(int i=0;i<(params.delete).size();i++){
		        		def indProdDetInst = CosentCertHotelDetails.get((params.delete[i]).toInteger())
		        		indProdDetInst.delete()
		        	}
		    	}
		    	redirect(action:popConsentCertHotelDetailsEdit,id:app)
		  }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	       redirect(uri:'/index.gsp');
	 }
}
}
def printInspectionNote={
		try {
			println("params..."+params)
		 def applicationFileInstance
	    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
	    	println("application.."+application)
	    	applicationFileInstance=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Inspection Report' order by afr.id desc",[application])
	    	def applicationFileSingleInstance=applicationFileInstance
		   response.setContentType( "application-xdownload")
		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
  
	}catch(Exception e) {
       e.printStackTrace();
		 flash.message = "Server Busy. Please try after sometime....";
		if(session.indUser){

		redirect(controller:'indUser',action:'openIndustryHome')
		}else if(session.userMaster){

			redirect(controller:'userMaster',action:'openSpcbHome');
		}else{
     
		session.invalidate()
       redirect(uri:'/index.gsp');
		}
      }
		}
//////////////////////////////////Insert data in Consnet Order/////////////////////////////////////////////
def insertIndustryDataIntoConsentOrder(IndApplicationDetails indAppDetailInstance) {
	 try {
		 def pollValue = "";
		 println("params.in insertIndustryDataIntoConsentOrder."+params)
			def airInstanceList =ConsentCertStackDetails.findAll("from ConsentCertStackDetails  where application = ? ",[indAppDetailInstance])
				if(airInstanceList.size() == 0){
	        		def oldAirInstanceList = AirStackDetailsInspection.findAll("from AirStackDetailsInspection where application = ? ",[indAppDetailInstance])
	        		println("oldAirInstanceList..."+oldAirInstanceList)
	        		if(oldAirInstanceList.size() != 0){
	        			println("inside......"+oldAirInstanceList)
	        			for(int i=0;i<oldAirInstanceList.size();i++){
	        				ConsentCertStackDetails airStackMaster = new ConsentCertStackDetails();
	        				def oldAirstackSingleInstance = AirStackDetailsInspection.find("from AirStackDetailsInspection where id = ? ",[oldAirInstanceList.get(i).id])
	        				airStackMaster.application   = indAppDetailInstance
	        				airStackMaster.stackAttachedTo  = oldAirstackSingleInstance.stack
	        				airStackMaster.stackHeight  = oldAirstackSingleInstance.heightGrdLevel
	        				airStackMaster.stackVolume  = oldAirstackSingleInstance.capacity
	        				airStackMaster.topDiameter	 = oldAirstackSingleInstance.shape
	        				airStackMaster.velocityOfGasEmission  = oldAirstackSingleInstance.gasVel
	        				airStackMaster.typeOfFuel  = oldAirstackSingleInstance.fuelTyp
	        				airStackMaster.maximumQuantity  = oldAirstackSingleInstance.fuelQty
	        				airStackMaster.unit  = oldAirstackSingleInstance.unit
	        				def stackList = AirStackDetailsInspection.findAllByApplication(indAppDetailInstance)
	        				println("stackList.."+stackList)
	        				def pollCntrlList = AirStackPollutionCntrlDetailsMasterInspection.findAllWhere(stack:oldAirInstanceList.get(i))
	        				println("pollCntrlList.."+pollCntrlList)
	        				if((pollCntrlList).getClass().getName()== "java.lang.String"){
		        				airStackMaster.pollutionCntrlMeasure=pollCntrlList.pollutionCntrlMeasure.controlMeasure
		    			    	}
		    			    	else{
		    			    		for(int j=0;j<pollCntrlList.size();j++){
		    			    			pollValue = pollCntrlList[j].pollutionCntrlMeasure.controlMeasure +"," + pollValue
		    			    		}
		    			    		airStackMaster.pollutionCntrlMeasure = pollValue
		    			    	}
	    			    if(!airStackMaster.hasErrors() && airStackMaster.save(flush:true)) {
	        				} else {
	        					airStackMaster.errors.each {
	        						println it
	        				    }
	        				}
	        			}
	        		}else{
	        		}
	       	 } 
			def newList5 = CosentCertProductDetails.findAll("from CosentCertProductDetails where application = ? ",[indAppDetailInstance])
			println("newList5.."+newList5)
		if(newList5.size() == 0){
			def oldList5 = IndProductDetailsInspection.findAll("from IndProductDetailsInspection where application = ? ",[indAppDetailInstance])
			println("oldList5.."+oldList5)
			if(oldList5.size() != 0){
				for(int i=0;i<oldList5.size();i++){
					CosentCertProductDetails master5 = new CosentCertProductDetails();
					def oldSingleInstance5 = IndProductDetailsInspection.find("from IndProductDetailsInspection where id = ? ",[oldList5.get(i).id])
					master5.application   = indAppDetailInstance
					master5.product = oldSingleInstance5.product
					master5.quantity = oldSingleInstance5.quantity
					master5.unit = oldSingleInstance5.unit
					if(!master5.hasErrors() && master5.save(flush:true)) {
		 	       } else {
						master5.errors.each {
							println it
					   }
					}	
				}
			}else{
			}
		 }
///////////////////////////////////////Hazardeous Details\
	def newList51 = HazardousWasteGenDetailsCert.findAll("from HazardousWasteGenDetailsCert where application = ? ",[indAppDetailInstance])
			println("newList51.."+newList51)
		if(newList51.size() == 0){
			def oldList51 = HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection where application = ? ",[indAppDetailInstance])
			println("oldList51.."+oldList51)
			if(oldList51.size() != 0){
				for(int i=0;i<oldList51.size();i++){
					HazardousWasteGenDetailsCert master5 = new HazardousWasteGenDetailsCert();
					def oldSingleInstance5 = HazardousWasteGenDetailsInspection.find("from HazardousWasteGenDetailsInspection where id = ? ",[oldList51.get(i).id])
					master5.application   = indAppDetailInstance
					master5.authFor = oldSingleInstance5.authFor
					master5.sourceName = oldSingleInstance5.sourceName
					master5.categoryName = oldSingleInstance5.categoryName
					master5.quantity = oldSingleInstance5.quantity
					if(!master5.hasErrors() && master5.save(flush:true)) {
		 	       } else {
						master5.errors.each {
							println it
					   }
					}	
				}
			}else{
			}
		 }
	 }
	 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	  redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	   redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	         session.invalidate()
	         redirect(uri:'/index.gsp');
	 }
	}
}

///////////////////////////////////////Pragya///////////////////////////////
def popHotelOtherDetailAddInspection = {
			  try {
				  def app = IndApplicationDetails.get((params.id).toInteger())
		            def hotelOtherDetailList = HotelGeneralDetailsInspection.findAllByApplication(app)
		            def type=params.type
		           return [appDetId:params.id ,hotelOtherDetailList:hotelOtherDetailList,type:type]
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}
	    
def saveHotelOtherDetailInspection= {
			  try {
				 def app = IndApplicationDetails.get((params.appId).toInteger())
				 def type=params.type
		          def hotelOtherDetailList = HotelGeneralDetailsInspection.findAllByApplication(app)
		          	if(hotelOtherDetailList)
		          	{
		          		flash.message = "Hotel general details already exists"
			        			redirect(action:popHotelOtherDetailAddInspection,id:app,params:[type:type])
		          	}
		          	else
		          	{      		
		          		flash.message = "Hotel general details saved"
		           def hotelOtherDetailInst = new HotelGeneralDetailsInspection(params)
		      		hotelOtherDetailInst.application = app
		      		
		      		hotelOtherDetailInst.save()
		      		redirect(action:popHotelOtherDetailAddInspection,id:app,params:[type:type])
		          } 
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
 }
	    
 def popHotelOtherDetailViewInspection = {
			  try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelOtherDetailList = HotelGeneralDetailsInspection.findAllByApplication(app)
		        	def type=params.type
		        	return [appDetId:params.id,hotelOtherDetailList:hotelOtherDetailList,type:type]
		  }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}
	    
def popHotelOtherDetailEditInspection = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelOtherDetailList = HotelGeneralDetailsInspection.findAllByApplication(app)
		        	def type=params.type
		        	return [appDetId:params.id,hotelOtherDetailList:hotelOtherDetailList,type:type]
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
} 
	    
def editHotelOtherDetailInspection = {
			  try {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				def type=params.type
  	        	if((params.delete).getClass().getName()== "java.lang.String"){
  	        		def hotelGeneralDetails = HotelGeneralDetailsInspection.get((params.delete).toInteger())
  	        		hotelGeneralDetails.delete()
  	        	}else{
  	        		if(params.delete)
  	        		for(int i=0;i<(params.delete).size();i++){
  	        			def hotelGeneralDetails = HotelGeneralDetailsInspection.get((params.delete[i]).toInteger())
  	            		hotelGeneralDetails.delete()
  	        		}
  	        	}
  	        	redirect(action:popHotelOtherDetailEditInspection,id:app,params:[type:type])
  }catch(Exception e) {
      e.printStackTrace();
		 flash.message = "Server Busy ..Please try after some time....";
		if(session.indUser){
	redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
  session.invalidate()
  redirect(uri:'/index.gsp');
}
}
}
def popHazardActivityGenDetailsCertAdd = {
		 try {
		      def app = IndApplicationDetails.get((params.id).toInteger())
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsCert.findAllByApplication(app)
	    		return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
	     }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def popHazardActivityGenDetailsCertView = {
		 try {
		     def app = IndApplicationDetails.get((params.id).toInteger())
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsCert.findAllByApplication(app)
	    		return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
	    }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def popHazardActivityGenDetailsCertEdit = {
		 try {
		     def app = IndApplicationDetails.get((params.id).toInteger())
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsCert.findAllByApplication(app)
	    		return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
	    }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def myAjax ={
		 try {
		       def hazardNameList
	    		def a
	    		def dist
	    		if(params.cont== '9999' ) {
	    			render g.select( width:'10', optionKey:'id',name:'categoryName.id', from:hazardNameList)
	    		}
	    		else {
	    		a = params.cont
	    		dist = HazardousSourceGenMaster.get(a)
	    		hazardNameList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster tm where tm.sourceName=? ",[dist])
	    		render g.select( width:'10', optionKey:'id',name:'categoryName.id', from:hazardNameList)
	    		}
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def saveHazardGenDetailsCert = {
		 try {
		       def app = IndApplicationDetails.get((params.appId).toInteger())
	    		if((params.quantity).getClass().getName()== "java.lang.String"){
	    			def hazardousWasteGenDetailsInst = new HazardousWasteGenDetailsCert(params)
	    		def hazarName = params.categoryName.id
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsCert.findByApplication(app)
	    		def harardName = HazardousWasteGenDetailsCert.findAll("from HazardousWasteGenDetailsCert indPower where indPower.categoryName.id=? and indPower.application=?",[hazarName.toLong(),app])
	    		
	    		if(harardName)
	    		{
	    		flash.message = "Details regarding ${harardName.categoryName} already exist"
	    		redirect(action:popHazardActivityGenDetailsCertAdd,id:app)
	    		}
	    		else
	    		{
	    		hazardousWasteGenDetailsInst.application = app
	    		def categoryList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster tm where tm.id=? ",[hazarName.toLong()])
	    		
	    		String authReqFor=""

	    		if(hazarWasteGenDetailsList!=null)
	    		{
	    		authReqFor = hazarWasteGenDetailsList.authFor
	    		}
	    		else
	    		{
	    		if(params['chkCollection']=="on") {
	    		authReqFor=authReqFor.concat("Collection")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkReception']=="on") {
	    		authReqFor=authReqFor.concat("Reception")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkTreatment']=="on") {
	    		authReqFor=authReqFor.concat("Treatment")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkTransport']=="on") {
	    		authReqFor=authReqFor.concat("Transport")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkStorage']=="on") {
	    		authReqFor=authReqFor.concat("Storage")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkDisposal']=="on") {
	    		authReqFor=authReqFor.concat("Disposal")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		}
	    		hazardousWasteGenDetailsInst.authFor=authReqFor
	    		hazardousWasteGenDetailsInst.save()
	    		flash.message = "Details Saved"
	    		redirect(action:popHazardActivityGenDetailsCertAdd,id:app)
	    		}}
	    }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def deleteHazardGenDetailsCert = {
		 try {
	    		def app = IndApplicationDetails.get((params.appId).toInteger())
	    		if((params.delete).getClass().getName()== "java.lang.String"){
	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetailsCert.get((params.delete).toInteger())
	    		hazardousWasteGenDetailsInst.delete()
	    		}else{
	    		if(params.delete)
	    		for(int i=0;i<(params.delete).size();i++){
	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetailsCert.get((params.delete[i]).toInteger())
	    		hazardousWasteGenDetailsInst.delete()
	    		}
	    		}
	    		redirect(action:popHazardActivityGenDetailsCertEdit,id:app)
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}
def popHazardActivityGenDetailsAddInspection = {
		 try {
		      def app = IndApplicationDetails.get((params.id).toInteger())
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsInspection.findAllByApplication(app)
	    		def type=params.type
	    		return [type:type,appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
	     }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def popHazardActivityGenDetailsViewInspection = {
		 try {
		     def app = IndApplicationDetails.get((params.id).toInteger())
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsInspection.findAllByApplication(app)
	    		def type=params.type
	    		return [type:type,appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
	    }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def popHazardActivityGenDetailsEditInspection = {
		 try {
		     def app = IndApplicationDetails.get((params.id).toInteger())
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsInspection.findAllByApplication(app)
	    		def type=params.type
	    		return [type:type,appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
	    }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def saveHazardGenDetailsInspection = {
		 try {
		       def app = IndApplicationDetails.get((params.appId).toInteger())
		       def type=params.type
	    		if((params.quantity).getClass().getName()== "java.lang.String"){
	    			def hazardousWasteGenDetailsInst = new HazardousWasteGenDetailsInspection(params)
	    		def hazarName = params.categoryName.id
	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsInspection.findByApplication(app)
	    		def harardName = HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection indPower where indPower.categoryName.id=? and indPower.application=?",[hazarName.toLong(),app])
	    		
	    		if(harardName)
	    		{
	    		flash.message = "Details regarding ${harardName.categoryName} already exist"
	    		redirect(action:popHazardActivityGenDetailsAddInspection,id:app)
	    		}
	    		else
	    		{
	    		hazardousWasteGenDetailsInst.application = app
	    		def categoryList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster tm where tm.id=? ",[hazarName.toLong()])
	    		
	    		String authReqFor=""

	    		if(hazarWasteGenDetailsList!=null)
	    		{
	    		authReqFor = hazarWasteGenDetailsList.authFor
	    		}
	    		else
	    		{
	    		if(params['chkCollection']=="on") {
	    		authReqFor=authReqFor.concat("Collection")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkReception']=="on") {
	    		authReqFor=authReqFor.concat("Reception")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkTreatment']=="on") {
	    		authReqFor=authReqFor.concat("Treatment")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkTransport']=="on") {
	    		authReqFor=authReqFor.concat("Transport")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkStorage']=="on") {
	    		authReqFor=authReqFor.concat("Storage")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		if(params['chkDisposal']=="on") {
	    		authReqFor=authReqFor.concat("Disposal")
	    		authReqFor=authReqFor.concat(",")
	    		}
	    		}
	    		hazardousWasteGenDetailsInst.authFor=authReqFor
	    		hazardousWasteGenDetailsInst.save()
	    		flash.message = "Details Saved"
	    		redirect(action:popHazardActivityGenDetailsAddInspection,id:app,params:[type:type])
	    		}}
	    }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def deleteHazardGenDetailsInspection = {
		 try {
	    		def app = IndApplicationDetails.get((params.appId).toInteger())
	    		def type=params.type
	    		if((params.delete).getClass().getName()== "java.lang.String"){
	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetailsInspection.get((params.delete).toInteger())
	    		hazardousWasteGenDetailsInst.delete()
	    		}else{
	    		if(params.delete)
	    		for(int i=0;i<(params.delete).size();i++){
	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetailsInspection.get((params.delete[i]).toInteger())
	    		hazardousWasteGenDetailsInst.delete()
	    		}
	    		}
	    		redirect(action:popHazardActivityGenDetailsEditInspection,id:app,params:[type:type])
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def popWaterConsumptionDetailAddInspection = {
		   def app = IndApplicationDetails.get((params.id).toInteger())
       	def stoneCrusherWaterReqList = StoneCrusherWaterReqInspection.findAllByApplication(app)
       	def type=params.type
       	return [type:type,appDetId:params.id,stoneCrusherWaterReqList:stoneCrusherWaterReqList]
}

def saveWaterWasteDischrgeDetailInsp={
		try {
			  try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
				  def type=params.type
		        def stoneCrusherWaterReqList = new StoneCrusherWaterReqInspection()
		        	def waterDisp = params.sourceOfWaterSupply
		       def dgList = StoneCrusherWaterReqInspection.findAll("from StoneCrusherWaterReqInspection abc where abc.sourceOfWaterSupply=? and abc.application=?",[waterDisp,app])
		       if(waterDisp=="Not Selected")
		 	{
		 		flash.message = "Please Select Water Source Details"
		     	redirect(action:popWaterConsumptionDetailAddInspection,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
		 	}
		 	else if(dgList)
		 	{
		 		flash.message = "Water Source details regarding ${waterDisp} already exists"
		 		redirect(action:popWaterConsumptionDetailAddInspection,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
		 	}
		 	else
		 	{  	stoneCrusherWaterReqList.sourceOfWaterSupply = waterDisp
		 		stoneCrusherWaterReqList.quantity = params.quantity
		 		stoneCrusherWaterReqList.application = app
		 		stoneCrusherWaterReqList.save(flush:true)
		     	redirect(action:popWaterConsumptionDetailAddInspection,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList,type:type])
		 	} 	
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }

}
def popWaterConsumptionDetailViewInspection={
		try {
			  def app = IndApplicationDetails.get((params.id).toInteger())
	        	def waterConsumptionDetailList = StoneCrusherWaterReqInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,waterConsumptionDetailList:waterConsumptionDetailList]
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
	
}
def popWaterConsumptionDetailEditInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneCrusherWaterReqList = StoneCrusherWaterReqInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneCrusherWaterReqList:stoneCrusherWaterReqList]	
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

def editWaterSourceDetailMasterInsp= {
		  try {
			  def app = IndApplicationDetails.get((params.appId).toInteger())
			  def type=params.type
	        	if((params.delete).getClass().getName()== "java.lang.String"){
	        		def wastersourceDetails = StoneCrusherWaterReqInspection.get((params.delete).toInteger())
	        		wastersourceDetails.delete()
	        	}else{
	        		if(params.delete)
	        		for(int i=0;i<(params.delete).size();i++){
	        			def wastersourceDetails = StoneCrusherWaterReqInspection.get((params.delete[i]).toInteger())
	            		wastersourceDetails.delete()
	        		}
	        	}
	        	redirect(action:popWaterConsumptionDetailEditInspection,id:app,params:[type:type])
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
def popBrickSittingCriteriaAddInspection = {
		  try {
			def app = IndApplicationDetails.get((params.id).toInteger())
	        	def brickSittingCriteriaList = BrickSittingCriteriaDetailsInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,brickSittingCriteriaList:brickSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

def  popBrickSittingCriteriaViewInspection = {
		  try {
			def app = IndApplicationDetails.get((params.id).toInteger())
	        	def brickSittingCriteriaList = BrickSittingCriteriaDetailsInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,brickSittingCriteriaList:brickSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
} 

def popBrickSittingCriteriaEditInspection = {
		  try {
			 def app = IndApplicationDetails.get((params.id).toInteger())
	        	def brickSittingCriteriaList = BrickSittingCriteriaDetailsInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,brickSittingCriteriaList:brickSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
} 

def saveBrickSittingCriteriaInspection= {
		  try {
			    def app = IndApplicationDetails.get((params.appId).toInteger())
			    def type=params.type
	        	def brickSittingCriteriaInst = new BrickSittingCriteriaDetailsInspection()
	        	def par = StoneCrusherParameterMaster.get((params.parameter).toInteger())
	        	def dgList = BrickSittingCriteriaDetailsInspection.findAll("from BrickSittingCriteriaDetailsInspection abc where abc.parameter=? and abc.application=?",[par,app])
	        	if(dgList)
	        	{
	        		flash.message = "Brick Sitting Criteria Details regarding ${par.toString()} already exists"
	        		redirect(action:popBrickSittingCriteriaAddInspection,id:app,params:[brickSittingCriteriaInst:brickSittingCriteriaInst,type:type])
	        	}
	        	else
	        	{
	        		flash.message = "Brick Sitting Criteria Details regarding ${par.toString()} is saved"
	            	brickSittingCriteriaInst.application = app
	            	brickSittingCriteriaInst.parameter = par
	            	brickSittingCriteriaInst.distance = params.distance
	            	brickSittingCriteriaInst.save()
	            	redirect(action:popBrickSittingCriteriaAddInspection,id:app)
	        	}
	}catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

def editBrickSittingCriteriaInspection= {
		  try {
			    def app = IndApplicationDetails.get((params.appId).toInteger())
			    def type=params.type
	        	if((params.delete).getClass().getName()== "java.lang.String")
	        	{
	        		def brickSittingCriteriaInst = BrickSittingCriteriaDetailsInspection.get((params.delete).toInteger())
	        		brickSittingCriteriaInst.delete()
	        	}
	        	else
	        	{
	        		if(params.delete)
	        		for(int i=0;i<(params.delete).size();i++)
	        		{
	        			def brickSittingCriteriaInst = BrickSittingCriteriaDetailsInspection.get((params.delete[i]).toInteger())
	            		brickSittingCriteriaInst.delete()
	        		}
	        	}
	        	redirect(action:popBrickSittingCriteriaEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
def popBrickKilnAddInspection = {
		  try {
			    def app = IndApplicationDetails.get((params.id).toInteger())
	        	def brickList = BrickKilnDetailInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,brickList:brickList]
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
      
 def popBrickKilnEditInspection = {
		  try {
			    def app = IndApplicationDetails.get((params.id).toInteger())
	        	def brickList = BrickKilnDetailInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,brickList:brickList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
      
 def popBrickKilnViewInspection = {
		  try {
			    def app = IndApplicationDetails.get((params.id).toInteger())
	        	def brickList = BrickKilnDetailInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,brickList:brickList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

 def saveBrickKilnDetailInspection = {
		  try {
			    def app = IndApplicationDetails.get((params.appId).toInteger())
			    def type=params.type
          	def airMiscDetailsInst = new BrickKilnDetailInspection(params)
      		def dgList = BrickKilnDetailInspection.findAll("from BrickKilnDetailInspection abc where abc.application=?",[app])
          	if(dgList)
          	{
          		flash.message = "Brick Kiln details already exists"
          		redirect(action:popBrickKilnAddInspection,id:app,params:[airMiscDetailsInst:airMiscDetailsInst])
          	}
          	else
          	{
          		airMiscDetailsInst.application = app
          		airMiscDetailsInst.save()
  	        	redirect(action:popBrickKilnAddInspection,id:app,params:[airMiscDetailsInst:airMiscDetailsInst,type:type])
  	        }
}catch(Exception e) {
    e.printStackTrace();
		 flash.message = "Server Busy ..Please try after some time....";
		if(session.indUser){
	redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
session.invalidate()
redirect(uri:'/index.gsp');
}
}
}

 def editBrickKilnDetailInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.appId).toInteger())
			   def type=params.type
	        	if((params.delete).getClass().getName()== "java.lang.String"){
	        		def airMiscDetInst = BrickKilnDetailInspection.get((params.delete).toInteger())
	        		airMiscDetInst.delete()
	        	}
	        	else
	        	{
	        		if(params.delete)
	        			for(int i=0;i<(params.delete).size();i++)
	        			{
	        			def airMiscDetInst = BrickKilnDetailInspection.get((params.delete[i]).toInteger())
	            		airMiscDetInst.delete()
	        			}
	        	}
	        	redirect(action:popBrickKilnEditInspection,id:app,params:[type:type])
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
def popStoneSittingCriteriaAddInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneSittingCriteriaList = StoneCrusherSittingCriteriaInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

  def  popStoneSittingCriteriaViewInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneSittingCriteriaList = StoneCrusherSittingCriteriaInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
} 

def popStoneSittingCriteriaEditInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneSittingCriteriaList = StoneCrusherSittingCriteriaInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
} 

def saveStoneSittingCriteriaInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.appId).toInteger())
			   def type=params.type
	        	println("cccvvvvvvv111"+app)
			   def stoneSittingCriteriaInst = new StoneCrusherSittingCriteriaInspection()
			   println("cccvvvvvvv222"+stoneSittingCriteriaInst)
			   def par = StoneCrusherParameterMaster.get((params.parameter).toInteger())
	        	println("cccvvvvvvv333"+par)
			   def dgList = StoneCrusherSittingCriteriaInspection.findAll("from StoneCrusherSittingCriteriaInspection abc where abc.parameter=? and abc.application=?",[par,app])
	        	println("cccvvvvvvv444"+dgList)
			   if(dgList)
	        	{
	        		flash.message = "Stone Sitting Criteria Details regarding ${par.toString()} already exists"
	        		redirect(action:popStoneSittingCriteriaAddInspection,id:app,params:[stoneSittingCriteriaInst:stoneSittingCriteriaInst,type:type])
	        	}
	        	else
	        	{
	        		flash.message = "Stone Sitting Criteria Details regarding ${par.toString()} is saved"
	            	stoneSittingCriteriaInst.application = app
	            	stoneSittingCriteriaInst.parameter = par
	            	stoneSittingCriteriaInst.distance = params.distance
	            	stoneSittingCriteriaInst.save(flush:true)
	            	redirect(action:popStoneSittingCriteriaAddInspection,id:app,params:[type:type])
	        	}
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

def editStoneSittingCriteriaInspection= {
		  try {
			   def app = IndApplicationDetails.get((params.appId).toInteger())
			   def type=params.type
	        	if((params.delete).getClass().getName()== "java.lang.String")
	        	{
	        		def stoneSittingCriteriaInst = StoneCrusherSittingCriteriaInspection.get((params.delete).toInteger())
	        		stoneSittingCriteriaInst.delete()
	        	}
	        	else
	        	{
	        		if(params.delete)
	        		for(int i=0;i<(params.delete).size();i++)
	        		{
	        			def stoneSittingCriteriaInst = StoneCrusherSittingCriteriaInspection.get((params.delete[i]).toInteger())
	            		stoneSittingCriteriaInst.delete()
	        		}
	        	}
	        	redirect(action:popStoneSittingCriteriaEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
def popStoneCrusherControlDevicesAddInspection = {
		  try {
			  def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneSittingCriteriaList = StoneCrusherControlDevicesInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
 
def  popStoneCrusherControlDevicesViewInspection = {
		  try {
			def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneSittingCriteriaList = StoneCrusherControlDevicesInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
	  }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
} 

def popStoneCrusherControlDevicesEditInspection = {
		  try {
			 def app = IndApplicationDetails.get((params.id).toInteger())
	        	def stoneSittingCriteriaList = StoneCrusherControlDevicesInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
} 

def saveStoneCrusherControlInspection = {
		  try {
			   def app = IndApplicationDetails.get((params.appId).toInteger())
			   def type=params.type
	        	println("cccvvvvvvv111"+app)
			   def stoneSittingCriteriaInst = new StoneCrusherControlDevicesInspection()
			   println("cccvvvvvvv222"+stoneSittingCriteriaInst)
			   def par = StoneCrusherControlDevicesMaster.get((params.device).toInteger())
	        	println("cccvvvvvvv333"+par)
			   def dgList = StoneCrusherControlDevicesInspection.findAll("from StoneCrusherControlDevicesInspection abc where abc.device=? and abc.application=?",[par,app])
	        	if(dgList)
	        	{
	        		flash.message = "Stone Crusher Pollution Control Devices Details regarding ${par.toString()} already exists"
	        		redirect(action:popStoneCrusherControlDevicesAddInspection,id:app,params:[stoneSittingCriteriaInst:stoneSittingCriteriaInst,type:type])
	        	}
	        	else
	        	{
	        		flash.message = "Stone Crusher Pollution Control Devices Details regarding ${par.toString()} is saved"
	            	stoneSittingCriteriaInst.application = app
	            	stoneSittingCriteriaInst.device = par
	            	stoneSittingCriteriaInst.name = params.name
	            	stoneSittingCriteriaInst.status = params.status
	            	stoneSittingCriteriaInst.save()
	            	redirect(action:popStoneCrusherControlDevicesAddInspection,id:app,params:[type:type])
	        	}
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}

def editStoneCrusherControlInspection= {
		  try {
			   def app = IndApplicationDetails.get((params.appId).toInteger())
			   def type=params.type
	        	if((params.delete).getClass().getName()== "java.lang.String")
	        	{
	        		def stoneSittingCriteriaInst = StoneCrusherControlDevicesInspection.get((params.delete).toInteger())
	        		stoneSittingCriteriaInst.delete()
	        	}
	        	else
	        	{
	        		if(params.delete)
	        		for(int i=0;i<(params.delete).size();i++)
	        		{
	        			def stoneSittingCriteriaInst = StoneCrusherControlDevicesInspection.get((params.delete[i]).toInteger())
	            		stoneSittingCriteriaInst.delete()
	        		}
	        	}
	        	redirect(action:popStoneCrusherControlDevicesEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
def popNocAuthorityAddInspection = {
		  try {
			   def d = params.d
	        	def app = IndApplicationDetails.get((params.id).toInteger())
	        	def nocAuthorityDetailsInst = NocAuthorityDetailsInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,nocAuthorityDetailsInst:nocAuthorityDetailsInst,d:d]
	}catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}  

def popNocAuthorityViewInspection = {
		  try {
			    def d = params.d
	        	def app = IndApplicationDetails.get((params.id).toInteger())
	        	def nocAuthorityDetailsInst = NocAuthorityDetailsInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,nocAuthorityDetailsInst:nocAuthorityDetailsInst,d:d]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}  
 
def popNocAuthorityEditInspection = {
		  try {
			   def d = params.d
	        	def app = IndApplicationDetails.get((params.id).toInteger())
	        	def nocAuthorityDetailsInst = NocAuthorityDetailsInspection.findAllByApplication(app)
	        	def type=params.type
	        	return [type:type,appDetId:params.id,nocAuthorityDetailsInst:nocAuthorityDetailsInst,d:d]
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}  
  
def saveNOCAuthorityInspection = 
  {
		  try {
			   def app = IndApplicationDetails.get((params.appId).toInteger())
			   def type=params.type
		    	def nocAuthorityDetailsInst = new NocAuthorityDetailsInspection(params)
		    	def authorityDetails =params.authorityDetails
		    	def dgList = NocAuthorityDetailsInspection.findAll("from NocAuthorityDetailsInspection abc where abc.authorityDetails=? and abc.application=?",[authorityDetails,app])
		     	 if(dgList)
		 	{
		 		flash.message = "NOC Authority details regarding ${authorityDetails} already exists"
		 		redirect(action:popNocAuthorityAddInspection,id:app,params:[nocAuthorityDetailsInst:nocAuthorityDetailsInst,type:type])
		 	}
		 	else
		 	{  	nocAuthorityDetailsInst.authorityDetails = params.authorityDetails
		 		nocAuthorityDetailsInst.status = params.status
		 		nocAuthorityDetailsInst.number = params.number
		 		
		 		nocAuthorityDetailsInst.date = params.date_value
		 		nocAuthorityDetailsInst.application = app
		 		nocAuthorityDetailsInst.save()
		     	
		 		flash.message = "Details Saved"
		 		redirect(action:popNocAuthorityAddInspection,id:app,params:[nocAuthorityDetailsInst:nocAuthorityDetailsInst])
		 	}
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}

def editNocAuthorityDetailInspection= {
		  try {
			  def app = IndApplicationDetails.get((params.appId).toInteger())
			  def type=params.type
	        	if((params.delete).getClass().getName()== "java.lang.String"){
	        		def wastersolidDetails = NocAuthorityDetailsInspection.get((params.delete).toInteger())
	        		wastersolidDetails.delete()
	        	}else{
	        		if(params.delete)
	        		for(int i=0;i<(params.delete).size();i++){
	        			def wastersolidDetails = NocAuthorityDetailsInspection.get((params.delete[i]).toInteger())
	            		wastersolidDetails.delete()
	        		}
	        	}
	        	redirect(action:popNocAuthorityEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
          e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
      session.invalidate()
      redirect(uri:'/index.gsp');
}
 }
}
def popDGsetAddInspection={
	  try {
	       def app = IndApplicationDetails.get((params.id).toInteger())
	    	def DGList = DGSetDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,DGList:DGList]
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def popDGsetEditInspection = {
	  try {
	        def app = IndApplicationDetails.get((params.id).toInteger())
	    	def DGList = DGSetDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,DGList:DGList]
	  }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def popDGsetViewInspection = {
	  try {
	       def app = IndApplicationDetails.get((params.id).toInteger())
	    	def DGList = DGSetDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,DGList:DGList]
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def saveDGsetInspection = {
	  try {
	        def app = IndApplicationDetails.get((params.appId).toInteger())
	        def type=params.type
        	def DGList=DGSetDetailsInspection.findAll("from DGSetDetailsInspection abcd where abcd.application=?",[app])
        	def a = ""
        	int x = 0
        	float z= 0.0
        	if(DGList)
        	{
        		flash.message="Details already exist!!!"
        		redirect(action:popDGsetAddInspection,id:app,params:[type:type])
        	}
        	else
        	{
        	def dgInst = new DGSetDetailsInspection(params)
        	 a = params.powerRating
        		if(!(a=="")){
        		 x= Integer.parseInt(a)
        		} 
        		if(!(params.heightOfBuilding=="")){
        		z = params.heightOfBuilding.toFloat()
        		}
        		float y =0.0
        		if(x==0){
        			y=0.0
        		}
        		else if(x<50){
        			y=z+1.5   			
        	}
        		else if(x>50 && x<=100) {
        			y=z+2.0
        		}
        		else if(x>100 && x<=150){
        			y=z+2.5
        		}
        		else if(x>150 && x<=200){
        			y=z+3.0
        		}	
        		else if(x>200 && x<=250){
        			y=z+3.5
        		}	
        		else if(x>250 && x<=300){
        			y=z+3.5
        		}
        		dgInst.totalHeight=y
        		dgInst.application = app
        		dgInst.save()
            	flash.message = "Details Saved"
                redirect(action:popDGsetAddInspection,id:app,params:[type:type])
           }
 }catch(Exception e) {
        e.printStackTrace();
		 flash.message = "Server Busy ..Please try after some time....";
		if(session.indUser){
	redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
    session.invalidate()
    redirect(uri:'/index.gsp');
}
}
}

def editDGsetInspection = {
	  try {
	    	def app = IndApplicationDetails.get((params.appId).toInteger())
	    	def type=params.type
	    	if((params.delete).getClass().getName()== "java.lang.String"){
	    		def dgInst = DGSetDetailsInspection.get((params.delete).toInteger())
	    		dgInst.delete()
	    	}
	    	else
	    	{
	    		if(params.delete)
	    			for(int i=0;i<(params.delete).size();i++)
	    			{
	    			def stackDetInst = DGSetDetailsInspection.get((params.delete[i]).toInteger())
	        		stackDetInst.delete()
	    			}
	    	}
	    	redirect(action:popDGsetEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}
def popDGSourceAddInspection = 
{
	  try {
	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	def DGList = DGSetEmissionDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,DGList:DGList]
	  }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def popDGSourceEditInspection = 
{
	  try {
	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	def DGList = DGSetEmissionDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,DGList:DGList]
	  }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def popDGSourceViewInspection = 
{
	  try {
		   def app = IndApplicationDetails.get((params.id).toInteger())
	    	def DGList = DGSetEmissionDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,DGList:DGList]
	  }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def saveDGSourceInspection = 
{
	  try {
		  def app = IndApplicationDetails.get((params.appId).toInteger())
		  def type=params.type
	    	def DGList=DGSetEmissionDetailsInspection.findAll("from DGSetEmissionDetailsInspection abcd where abcd.application=?",[app])
	    	if((params.source).getClass().getName()== "java.lang.String")
	    	{
	    		def dgInst = new DGSetEmissionDetailsInspection(params)
	    		dgInst.application = app
	    		dgInst.save()
	        	flash.message = "Details Saved"
	            redirect(action:popDGSourceAddInspection,id:app,params:[type:type])
	        }
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def editDGSourceInspection = {
	  try {
		    def app = IndApplicationDetails.get((params.appId).toInteger())
		    def type=params.type
	    	if((params.delete).getClass().getName()== "java.lang.String"){
	    		def dgInst = DGSetEmissionDetailsInspection.get((params.delete).toInteger())
	    		dgInst.delete()
	    	}
	    	else
	    	{
	    		if(params.delete)
	    			for(int i=0;i<(params.delete).size();i++)
	    			{
	    			def stackDetInst = DGSetEmissionDetailsInspection.get((params.delete[i]).toInteger())
	        		stackDetInst.delete()
	    			}
	    	}
	    	redirect(action:popDGSourceEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}
def popDGParameterAddInspection = 
{
	  try {
		    def d = params.d
	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	def dgList = DGSetParameterDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,dgList:dgList]
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def popDGParameterViewInspection = 
{
	  try {
		    
	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	def dgList = DGSetParameterDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,dgList:dgList]
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def popDGParameterEditInspection = 
{
	  try {
		    
	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	def dgList = DGSetParameterDetailsInspection.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,appDetId:params.id,dgList:dgList]
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def saveDGParameterInspection = 
{
	  try {
		    def app = IndApplicationDetails.get((params.appId).toInteger())
		    def type=params.type
	    	def dgInstance = new DGSetParameterDetailsInspection()
	    	def parameters = params.parameters
	    	def dgList = DGSetParameterDetailsInspection.findAll("from DGSetParameterDetailsInspection abc where abc.parameters=? and abc.application=?",[parameters,app])
	    	if(parameters=="Not Selected")
	    	{
	    		flash.message = "Please Select Parameters"
	        	redirect(action:popDGParameterAddInspection,id:app,params:[dgInstance:dgInstance,type:type])
	    	}
	    	else if(dgList)
	    	{
	    		flash.message = "D.G. Set Parameter details regarding ${parameters} already exists"
	    		redirect(action:popDGParameterAddInspection,id:app,params:[dgInstance:dgInstance,type:type])
	    	}
	    	else
	    	{
	    		dgInstance.parameters = params.parameters
	    		dgInstance.noLoad = params.noLoad
	    		dgInstance.fullLoad = params.fullLoad 
	    		dgInstance.application = app
	        	dgInstance.save()
	        	redirect(action:popDGParameterAddInspection,id:app,params:[dgInstance:dgInstance,type:type])
	        }
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}

def editDGParameterInspection = 
{
	  try {
		   def app = IndApplicationDetails.get((params.appId).toInteger())
		   def type=params.type
	    	if((params.delete).getClass().getName()== "java.lang.String"){
	    		def indCostDetInst = DGSetParameterDetailsInspection.get((params.delete).toInteger())
	    		indCostDetInst.delete()
	    	}else{
	    		if(params.delete)
	        	for(int i=0;i<(params.delete).size();i++){
	        		def indCostDetInst = DGSetParameterDetailsInspection.get((params.delete[i]).toInteger())
	        		indCostDetInst.delete()
	        	}
	    	}
	    	redirect(action:popDGParameterEditInspection,id:app,params:[type:type])
	 }catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
 }
 else if(session.userMaster){
  redirect(controller:'userMaster',action:'openSpcbHome');
 }else{
        session.invalidate()
        redirect(uri:'/index.gsp');
 }
   }
}
////////////////////////////////////Fee details Officer end///////////////////////////////////////
////////////////////////////////////Fee details Officer end///////////////////////////////////////
def popFeesfromOfficerAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def feeDetailsListByIndustry=FeeBankDetails.findByApplication(app)
    	    	def onlineFeeDetails
    	    	if(!feeDetailsListByIndustry){
    	    		onlineFeeDetails=BankTransactionDetails.find("from BankTransactionDetails bt where bt.indApplication=? and bt.transactionStatus='S'",[app])
    	    	}
    	    	def feeDetailsList = FeeBankDetailsOfficer.findAllByApplication(app)
    	    	def type=params.type
    	    	return [type:type,appDetId:params.id,feeDetailsList:feeDetailsList,feeDetailsListByIndustry:feeDetailsListByIndustry,onlineFeeDetails:onlineFeeDetails]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

def saveBankFeeDetails = {
   	 try {
   		 println("params.saveBankFeeDetails.."+params)
   		 DateCustom dd=new DateCustom()
   	    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
   			def type=params.type
   			def app = IndApplicationDetails.get((params.appId).toInteger())
   	    	
   	    		if((params.ddNo).getClass().getName()== "java.lang.String"){
   	        		def feeBankDetails = new FeeBankDetailsOfficer()
   	            		feeBankDetails.application = app
   	            		feeBankDetails.ddChequeNo = params.ddNo
   	            		feeBankDetails.date = params.dateval
   	            		feeBankDetails.fromDate = params.fromDate_value
   	            		feeBankDetails.toDate = params.toDate_value
   	            		feeBankDetails.bankName = params.bankName
   	            		feeBankDetails.branch = params.branchName
   	            		println("params.ddAmount..."+params.ddAmount)
   	        		println("params.ddAmount..."+params.ddAmount.getClass().getName())
   	            		if(params.ddAmount != ""){
   	            			try{
   	            				println("here inside....")
   	            				feeBankDetails.amount = (params.ddAmount).toDouble()
   	            			}catch (Exception e) {
   	            				feeBankDetails.amount = 0
   	            			}
   	        			}else{
   	        				feeBankDetails.amount = 0
   	        			}
   	        			if(feeBankDetails.save(flush:true)){
   	        			}else{
   	        				feeBankDetails.errors.each {
   	        					println it;
   	        			   }
   	        			}
   	        	}else{
   	        		for(int i=0;i<params.ddNo.size();i++){
   	        			if(ddNo[i]!=""){
   	        				def feeBankDetails = new FeeBankDetailsOfficer()
   	                		feeBankDetails.application = app
   	                		feeBankDetails.ddChequeNo = ddNo[i]
   	                		feeBankDetails.date = date[i]
   	        				feeBankDetails.fromDate = fromDate[i]
   	   	            		feeBankDetails.toDate = toDate[i]
   	                		feeBankDetails.bankName = bankName[i]
   	                		feeBankDetails.branch = branchName[i]
   	            			if(ddAmount[i]!=""){
   	            				feeBankDetails.amount = (ddAmount[i]).toLong()
   	            			}else{
   	            				feeBankDetails.amount = 0
   	            			}
   	                		feeBankDetails.save()
   	                	}
   	        		}
   	        	}	
   	    	redirect(action:popFeesfromOfficerAdd,id:app.id,params:[type:type])
   	   
   	     }catch(Exception e) {
   	            e.printStackTrace();
   				 flash.message = "Server Busy ..Please try after some time....";
   				if(session.indUser){
   			redirect(controller:'indUser',action:'openIndustryHome')
   	 }
   	 else if(session.userMaster){
   	  redirect(controller:'userMaster',action:'openSpcbHome');
   	 }else{
   	        session.invalidate()
   	        redirect(uri:'/index.gsp');
   	 }
   	   }
   }

def popFeesfromOfficerView = {
   	 try {
   	    	def app = IndApplicationDetails.get((params.id).toInteger())
   	    	def feeDetailsList = FeeBankDetailsOfficer.findAllByApplication(app)
   	    	def type=params.type
   	    	return [type:type,appDetId:params.id,feeDetailsList:feeDetailsList]
   	    }catch(Exception e) {
   	            e.printStackTrace();
   				 flash.message = "Server Busy ..Please try after some time....";
   				if(session.indUser){
   			redirect(controller:'indUser',action:'openIndustryHome')
   	 }
   	 else if(session.userMaster){
   	  redirect(controller:'userMaster',action:'openSpcbHome');
   	 }else{
   	        session.invalidate()
   	        redirect(uri:'/index.gsp');
   	 }
   	   }
   }
   
def popFeesfromOfficerEdit = {
   	 try {
   	    	def app = IndApplicationDetails.get((params.id).toInteger())
   	    	def feeDetailsList = FeeBankDetailsOfficer.findAllByApplication(app)
   	    	def type=params.type
   	    	return [type:type,appDetId:params.id,feeDetailsList:feeDetailsList]
   	     }catch(Exception e) {
   	            e.printStackTrace();
   				 flash.message = "Server Busy ..Please try after some time....";
   				if(session.indUser){
   			redirect(controller:'indUser',action:'openIndustryHome')
   	 }
   	 else if(session.userMaster){
   	  redirect(controller:'userMaster',action:'openSpcbHome');
   	 }else{
   	        session.invalidate()
   	        redirect(uri:'/index.gsp');
   	 }
   	   }
   }
def deleteFeeBankDetails = {
   	 try {
   	    	def app = IndApplicationDetails.get((params.appId).toInteger())
   	    	def type=params.type
   	    	if((params.delete).getClass().getName()== "java.lang.String"){
   	    		def feeDetInst = FeeBankDetailsOfficer.get((params.delete).toInteger())
   	    		feeDetInst.delete()
   	    	}else{
   	    		if(params.delete){
   	        	for(int i=0;i<(params.delete).size();i++){
   	        		def feeDetInst = FeeBankDetailsOfficer.get((params.delete[i]).toInteger())
   	        		feeDetInst.delete()
   	        	}
   	    		}
   	    	}
   	    	redirect(action:popFeesfromOfficerEdit,id:app,params:[type:type])
   	    }catch(Exception e) {
   	            e.printStackTrace();
   				 flash.message = "Server Busy ..Please try after some time....";
   				if(session.indUser){
   			redirect(controller:'indUser',action:'openIndustryHome')
   	 }
   	 else if(session.userMaster){
   	  redirect(controller:'userMaster',action:'openSpcbHome');
   	 }else{
   	        session.invalidate()
   	        redirect(uri:'/index.gsp');
   	 }
   	   }
   }  
def popPrintProcessedStatus={
    	 try { 
    	    	def sqlDate=session.sqlDate
    	    	def sqlDate2=session.sqlDate2
    	    	def sqlDate3=session.sqlDate3
    	    	def arr11=session.arr11
    	    render(view:'popPrintProcessedStatus',model:[sqlDate:sqlDate,sqlDate3:sqlDate3,sqlDate2:sqlDate2,arr11:arr11]) 
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
     }
    }
/********** for check list in inspection module ********/
def inspectionPage ={ 
		try {
			println("params.inspectionPage..."+params)
        	def app = IndApplicationDetails.get((params.id).toInteger())
        	println("params.inspectionPage..."+app.getClass().getName())
			def newInst=IndustryInspectionReport.findByApplication(app)
			println("newInst..11111111111111."+newInst)
			def newInst1 = ConsentInspectionReport.findByApplication(app)
			//def newInst1 = ConsentInspectionReport.find("from ConsentInspectionReport where application=?",[app])
			println("newInst..22222222222222newInst1newInst1newInst1newInst1."+newInst1)
			insertIndustryDataIntoInspection(app)
			if(newInst){
				return [newInst: newInst, appId: app,consentInspInst:newInst]
			}else if(newInst1){
				return [newInst: newInst1, appId: app,consentInspInst:newInst1] 
			}else{
				return [newInst: newInst, appId: app,consentInspInst:newInst]
			}
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

def saveInspection =
        {
		try {
			 println("in saveInspection..."+params)
				def indApplicationDetailsInstance=IndApplicationDetails.get(params.appId)
				println("indApplicationDetailsInstance..."+indApplicationDetailsInstance)
				def check = IndustryInspectionReport.findByApplication(indApplicationDetailsInstance)
				println("check..."+check)
				if(check)
				{
					check.delete()
				}
				def applicationFor =indApplicationDetailsInstance.applicationFor
				println("applicationFor..."+applicationFor)
				def certificateFor = indApplicationDetailsInstance.certificateFor
				println("certificateFor..."+certificateFor)
				def consentInspInst= new IndustryInspectionReport(params)
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String userInput = "01/01/1950";
				Date defaulDate = formatter.parse(userInput);
				def a=formatter.parse(params.periodapplied_value);
				consentInspInst.application=indApplicationDetailsInstance
	            consentInspInst.dateOfReceipt=defaulDate
	            consentInspInst.deeRecommendations=""
	            consentInspInst.dateOfReceiptdistrict=defaulDate
	            consentInspInst.dateOfReceiptcentral=defaulDate
	            consentInspInst.periodapplied=a
	        	def hotelRest
				def roomCapacity
		if(applicationFor=="hotel")	
		{
			consentInspInst.hotelRest=params.hotelRest
			consentInspInst.roomCapacity=params.roomCapacity
		}else{
			consentInspInst.hotelRest=""
			consentInspInst.roomCapacity=""
		}
	            if((applicationFor=="stonecrusher") || (indApplicationDetailsInstance.indUser.industryType.industryType=="Hot mix plants"))
	        	{
	            	consentInspInst.greenBelt=params.greenBelt
					consentInspInst.waterSprinkle=params.waterSprinkle
					consentInspInst.jacketing=params.jacketing
					consentInspInst.windBreaking=params.windBreaking
					consentInspInst.metallingRoads=params.metallingRoads
	        		consentInspInst.spmLevel=params.spmLevel
	        		consentInspInst.resArea=params.resArea  
	        	}else{
	        		consentInspInst.greenBelt=""
	        				consentInspInst.waterSprinkle=""
	        				consentInspInst.jacketing=""
	        				consentInspInst.windBreaking=""
	        				consentInspInst.metallingRoads=""
	        				consentInspInst.spmLevel=""
	        		        consentInspInst.resArea=""
	        	 }
	           if(applicationFor=="brickkilns")	
	        	{consentInspInst.chamber=params.chamber
	            	consentInspInst.chimney=params.chimney
	            consentInspInst.others=params.others
					consentInspInst.plantation=params.plantation
	            consentInspInst.roadsWall=params.roadsWall
	            }else{
	            	consentInspInst.chamber=""
		                 consentInspInst.chimney=""
  		                 consentInspInst.others=""
  		     				consentInspInst.plantation=""
  		                 consentInspInst.roadsWall="" }
	            if(applicationFor=="both")	
	        	{
	            	consentInspInst.capacityUtili=params.capacityUtili
					consentInspInst.chemicalQty=params.chemicalQty
	        		consentInspInst.chemicalStorage=params.chemicalStorage
	        		consentInspInst.closeShed=params.closeShed
	        		consentInspInst.disposalArrange=params.disposalArrange
					consentInspInst.enviorment=params.enviorment
					consentInspInst.addSewagereq=params.addSewagereq
	        		consentInspInst.expansionPlant=params.expansionPlant
	        		consentInspInst.leachate=params.leachate
					consentInspInst.leachateCollect=params.leachateCollect
					consentInspInst.management=params.management
					consentInspInst.methodOfDisposal=params.methodOfDisposal
	        		consentInspInst.methodOftreatment=params.methodOftreatment
	        		consentInspInst.modernization=params.modernization
					consentInspInst.nonHazQty=params.nonHazQty
					consentInspInst.publicLiability=params.publicLiability
	        		consentInspInst.saleName=params.saleName
					consentInspInst.separateElectric=params.separateElectric
					consentInspInst.sewageEffluent=params.sewageEffluent
					consentInspInst.storedOrDisposed=params.storedOrDisposed
	        		consentInspInst.treatmentArrang=params.treatmentArrang
	        		consentInspInst.typeofNonHaz=params.typeofNonHaz
	        		consentInspInst.areaincSewage=params.areaincSewage
	        		consentInspInst.incSewage=params.incSewage
				}else{
					consentInspInst.capacityUtili=""
					consentInspInst.chemicalQty=""
	        		consentInspInst.chemicalStorage=""
	        		consentInspInst.closeShed=""
					consentInspInst.disposalArrange=""
					consentInspInst.enviorment=""
					consentInspInst.addSewagereq=""
	        		consentInspInst.expansionPlant=""
	        		consentInspInst.leachate=""
					consentInspInst.leachateCollect=""
					consentInspInst.management=""
					consentInspInst.methodOfDisposal=""
	        		consentInspInst.methodOftreatment=""
	        		consentInspInst.modernization=""
					consentInspInst.nonHazQty=""
					consentInspInst.publicLiability=""
	        		consentInspInst.quantityrecycler=""
	        		consentInspInst.saleName=""
					consentInspInst.separateElectric=""
					consentInspInst.sewageEffluent=""
					consentInspInst.storedOrDisposed=""
	        		consentInspInst.treatmentArrang=""
	        		consentInspInst.typeofNonHaz=""
	        		consentInspInst.areaincSewage=""
		        	consentInspInst.incSewage=""
		        }
	            if(params.senstiveArea){
	            	consentInspInst.senstiveArea=params.senstiveArea
	            }else{
	            	consentInspInst.senstiveArea=""
	            }
	            if(params.specificArea){
	            	consentInspInst.specificArea=params.specificArea
	            }else{
	            	consentInspInst.specificArea=""
	            }
	            if(params.legal){
	            	consentInspInst.legal=params.legal
	            }else{
	            	consentInspInst.legal=""
	            }
	            if(params.authorityName){
	            	consentInspInst.authorityName=params.authorityName
	            }else{
	            	consentInspInst.authorityName=""
	            }
	            if(params.brickTiles){consentInspInst.brickTiles=params.brickTiles}else{consentInspInst.brickTiles=""}
	            if(params.prestan){consentInspInst.prestan=params.prestan}else{consentInspInst.prestan=""}
	            if(params.publicComplain){consentInspInst.publicComplain=params.publicComplain}else{consentInspInst.publicComplain=""}
	            if(params.recieveEnviroment){consentInspInst.recieveEnviroment=params.recieveEnviroment}else{consentInspInst.recieveEnviroment=""}
	            if(params.costPCD){consentInspInst.costPCD=params.costPCD}else{consentInspInst.costPCD=""}
	            if(params.reinspoff){consentInspInst.reinspoff=params.reinspoff}else{consentInspInst.reinspoff=""}
	            if(params.reregioff){consentInspInst.reregioff=params.reregioff}else{consentInspInst.reregioff=""}
	            if(params.categoryHaz){consentInspInst.categoryHaz=params.categoryHaz}else{consentInspInst.categoryHaz=""}
	            if(params.areaSpecific){consentInspInst.areaSpecific=params.areaSpecific}else{consentInspInst.areaSpecific=""}
	            if(params.areaSenstive){consentInspInst.areaSenstive=params.areaSenstive}else{consentInspInst.areaSenstive=""}
	            if(!consentInspInst.hasErrors() && consentInspInst.save(flush:true)) {
	            	println("SAVED")
				} else {
					consentInspInst.errors.each {
						println it;
					   }
				}
	    		def inspReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Inspection Report'",[indApplicationDetailsInstance])
					if(inspReport)
	            		{
						inspReport.delete()
	            		}
				if(!consentInspInst.hasErrors() && consentInspInst.save(flush:true)) {
					println("SAVED")
				} else {
					consentInspInst.errors.each {
						println it; 
				   }
				}
				def IndustryInspectionReportInst = IndustryInspectionReport.findByApplication(indApplicationDetailsInstance)
				UserMaster sess=(UserMaster)session.userMaster
				def userMasterInst=UserMaster.get(sess.id)
				InspectionReport report=new InspectionReport()
				report.regularReport(indApplicationDetailsInstance.id,userMasterInst.id,IndustryInspectionReportInst)
				flash.message = "Regular Inspection Report Details Saved"
				redirect(action:inspectionPage,id:indApplicationDetailsInstance,consentInspInst:IndustryInspectionReportInst)		
		 }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	  redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	   redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	       session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	}

}
def download12 =
{
    try {

        def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
        def fileDownload = ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication = ? order by dateCreated Desc", [indApplicationDetailsInstance])

        response.setContentType("application-xdownload")
        response.setHeader("Content-Disposition", "attachment;filename=${fileDownload.name}")
        response.getOutputStream() << new ByteArrayInputStream(fileDownload.data)
    } catch (Exception e) {
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
        if (session.indUser) {
            redirect(controller: 'indUser', action: 'openIndustryHome')
        } else if (session.userMaster) {
            redirect(controller: 'userMaster', action: 'openSpcbHome');
        } else {
            session.invalidate()
            redirect(uri: '/index.gsp');
        }
    }
}
def popUploadMoreInspectionDoc = {

}

def saveMoreDocs = { try {
    def noteHistiryFile = new ApplicationFileRecord()
    def indApp = params.app
    def indAppInstance = IndApplicationDetails.get((params.app).toInteger())
    def repeat = params.repeat
    def versionUpdate1 = 0


    String strDirectoy = "SPCB_DOCUMENTS"
    boolean success = (new File(strDirectoy)).mkdir();
    if (success) {

    }
    String strDir = strDirectoy + "/" + indApp
    boolean success2 = (new File(strDir)).mkdir();
    if (success2) {

    }
    def f = request.getFile('inspectionReport')
    MultipartFile multi = request.getFile('inspectionReport')
    if (!f.empty) {
        noteHistiryFile.size = multi.getSize() / 1024
        if (noteHistiryFile.size <= 6000) {
            noteHistiryFile.name = multi.getOriginalFilename()
            noteHistiryFile.data = multi.getBytes()
            noteHistiryFile.extension = extractExtension(multi)
            noteHistiryFile.description = "Application Regular Inspection Report File"
            if (session.userMaster) {
                noteHistiryFile.createdBy = session.userMaster
                noteHistiryFile.updatedBy = session.userMaster
            } else {
                noteHistiryFile.createdBy = session.indUser
                noteHistiryFile.updatedBy = session.indUser
            }

            //fileUpload.data=params.payload

            noteHistiryFile.typeOfFile = "regularInspectionReportOtherDocs"

            def applicationProcessingDetailsInstance = ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails apd where apd.application=? and apd.inspectionClose=true ", [indAppInstance])
            if (applicationProcessingDetailsInstance) {

                noteHistiryFile.version = applicationProcessingDetailsInstance.size()
            } else {
                noteHistiryFile.version = 0
            }
            noteHistiryFile.indApplication = indAppInstance
            if (!noteHistiryFile.hasErrors() && noteHistiryFile.save(flush: true)) {
                flash.message = "Document uploaded successfully"
                render(view: 'popUploadMoreInspectionDoc', model: [id: indApp, versionUpdate1: versionUpdate1])
            } else {

                if (noteHistiryFile.hasErrors()) {
                    noteHistiryFile.errors.allErrors.each {
                        println it
                    }
                }
                render(view: 'popUploadMoreInspectionDoc', model: [id: indApp])
            }
        } else {

            flash.message = "Attachment File Size is More Then 5 Mb"
            render(view: 'popUploadMoreInspectionDoc', model: [id: indApp])
        }
    } else {
    	flash.message = "Please Upload document"
        render(view: 'popUploadMoreInspectionDoc', model: [id: indApp])
    }
} catch (Exception e) {
    e.printStackTrace();
    flash.message = "Server is busy , please try after sometime";
    if (session.indUser) {
        redirect(controller: 'indUser', action: 'openIndustryHome')
    } else if (session.userMaster) {
        redirect(controller: 'userMaster', action: 'openSpcbHome');
    } else {
        session.invalidate()
        redirect(uri: '/index.gsp');
    }
}}
def popDeleteInspectionDoc = {
        try {
            def app = IndApplicationDetails.get((params.id).toInteger())
            def listDoc = new ArrayList()


            def applicationFileRecordList = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='regularInspectionReportOtherDocs' order by afr.version ", [app])


            if (applicationFileRecordList) {
                for (int ig = 0; ig < applicationFileRecordList.size(); ig++) {

                    if (applicationFileRecordList.get(ig))
                        listDoc.add(applicationFileRecordList.get(ig))


                }

            }

            return [appDetId: params.id, app: app, listDoc: listDoc]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
def deleteDocs = {
        try {
            //redirect(action:popDeleteInspectionDoc,id:params.id)
            def app = IndApplicationDetails.get((params.indAppId).toInteger())

            if ((params.delete).getClass().getName() == "java.lang.String") {
                def applicationDocumentInstance = ApplicationFileRecord.get((params.delete).toInteger())
                applicationDocumentInstance.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def applicationDocumentInstance = ApplicationFileRecord.get((params.delete[i]).toInteger())

                        applicationDocumentInstance.delete()
                    }
            }
            redirect(action: popDeleteInspectionDoc, id: app)


        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
def getTotAppCategoryWise = {
		 try {
			 println("params..."+params)
				def status=params.status
				def startDate1=params.date
				def endDate1=params.date1
				def cat=params.cat
				def appType=params.appType
				def certFor=params.certFor
				def x
				def y
				def sdfh = new SimpleDateFormat("yyyy-MM-dd"); 
				x = sdfh.parse(startDate1); //Date
				y = sdfh.parse(endDate1);
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				sqlDate2.setDate((sqlDate2.getDate()+1))
				def applicationTotalInstance
				if(params.cat=='WHITE'){
					applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.indCategoryName=? and abc.pendingSince >= ? and abc.pendingSince <= ? ",[(params.districtId).toString(),cat,sqlDate,sqlDate2])	
				}else{
				applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.applicationType=? and abc.certificateFor=? and abc.indCategoryName=? and abc.pendingSince >= ? and abc.pendingSince <= ? ",[(params.districtId).toString(),appType,certFor,cat,sqlDate,sqlDate2])	
				}
				render(view:'getTotAppCategoryWise',model:[allSummaryReportList:applicationTotalInstance])
		 }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	           redirect(uri:'/index.gsp');
	 }
}
}

def getTotAppCategoryWiseOnlyDistrict={
		 try {
			 println("params..."+params)
				def status=params.status
				def startDate1=params.date
				def endDate1=params.date1
				def cat=params.cat
				def appType=params.appType
				def certFor=params.certFor
				def x
				def y
				def sdfh = new SimpleDateFormat("yyyy-MM-dd"); 
				x = sdfh.parse(startDate1); //Date
				y = sdfh.parse(endDate1);
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				sqlDate2.setDate((sqlDate2.getDate()+1))
				def applicationTotalInstance
				applicationTotalInstance = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.pendingSince >= ? and abc.pendingSince <= ? and abc.certificateFor IN ('new','reNew')",[(params.districtId).toString(),sqlDate,sqlDate2])	
				
				render(view:'getTotAppCategoryWise',model:[allSummaryReportList:applicationTotalInstance])
		 }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	           redirect(uri:'/index.gsp');
	 }
}
}

def dwonloadOtherDocumentByInd={
		try {
		  // method for download the other Attach Letter Document
					def appId=Long.parseLong(params.fileId);
					def applicationFileSingleInstance = ApplicationFileRecord.find("from ApplicationFileRecord where id=?",[appId])
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
			  }catch(Exception e) {
		    		            e.printStackTrace();
		    					 flash.message = "Server Busy ..Please try after some time....";
		    					if(session.indUser){
		    			redirect(controller:'indUser',action:'openIndustryHome')
		    		 }else if(session.userMaster){
		    		 redirect(controller:'userMaster',action:'openSpcbHome');
		    		 }else{
		    		      session.invalidate()
		    		       redirect(uri:'/index.gsp');
		    		 }
		    		}
}


def viewFileOtherDocsRegularInspection =
{
    try {
        def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
        // bhanu code start; date: 09-06-2017
        println("indApplicationDetailsInstance: " + indApplicationDetailsInstance)
        // below line is commented and replaced
        // def fileDownload = ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication = ? order by dateCreated Desc", [indApplicationDetailsInstance])
        def fileDownload = ApplicationFileRecord.find("from ApplicationFileRecord where typeOfFile='regularInspectionReportOtherDocs' and indApplication.id=?",[params.id.toLong()])
        println("fileDownload: " + fileDownload)
        // bhanu code ends
        response.setContentType("application-xdownload")
        response.setHeader("Content-Disposition", "attachment;filename=${fileDownload.name}")
        response.getOutputStream() << new ByteArrayInputStream(fileDownload.data)
    } catch (Exception e) {
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
        if (session.indUser) {
            redirect(controller: 'indUser', action: 'openIndustryHome')
        } else if (session.userMaster) {
            redirect(controller: 'userMaster', action: 'openSpcbHome');
        } else {
            session.invalidate()
            redirect(uri: '/index.gsp');
        }
    }
}
def openCerificate = {
		 try {
			 println("params in openCertificate..."+params)
			  def appId=IndApplicationDetails.get((params.id).toLong())
			  def docName=params.docName
			  println("params in appId..."+appId)
						def fileDownLoad = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile=? order by afr.id desc",[appId,docName])
					println("params in fileDownLoad..."+fileDownLoad)
						render (view: "openCerificate", model:[fileDownLoad:fileDownLoad]) 	
				}catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		          
					session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
		            }
}

def openCerificate12 = {
		 try {
			 println("params..."+params)
			def appId=IndApplicationDetails.get((params.id).toLong())
			println("appId..."+appId)
			def fileDownLoad = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentOrder' order by afr.id desc",[appId])
			println("fileDownLoad..."+fileDownLoad)
			if(!fileDownLoad){
				fileDownLoad = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate' order by afr.id desc",[appId])	
			}
		render (view: "openCerificate12", model:[fileDownLoad:fileDownLoad]) 	
				}catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		          
					session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
		            }
}



def openCerificate13 = {
		 try {
			 println("params..."+params)
			def appId=IndApplicationDetails.get((params.id).toLong())
			println("appId..."+appId)
			def fileDownLoad = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentHWMOrder' order by afr.id desc",[appId])
			println("fileDownLoad..."+fileDownLoad)
			
		  render (view: "openCerificate13", model:[fileDownLoad:fileDownLoad]) 	
				}catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		          
					session.invalidate()
		            redirect(uri:'/index.gsp');
		 }
		            }
}
def redOrangeCertificateModified={
		try { 
				def idAppl= (params.appliId).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def viewCert = false
				def viewR_Certificate = false
				def viewR4_Certificate = false
				def certInst = RecordCertificate.find("from RecordCertificate abc where abc.applicationId=? and abc.typeofCertificate='Prepared'",[indApplicationDetailsInstance])
				println("certInst.."+certInst)
				if(certInst){
					viewCert = true
				}
				def r_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R3'",[indApplicationDetailsInstance])
				if(r_cert){
					viewR_Certificate=true
				}
				def r4_cert=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='R4'",[indApplicationDetailsInstance])
				if(r4_cert){
					viewR4_Certificate=true
				}
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					
				insertIndustryDataIntoConsentOrder(indApplicationDetailsInstance)
				def roleHeader=app.role.roleName
				def indRegInstance=indApplicationDetailsInstance.indUser
				indRegInstance.refresh()
				def teh=indRegInstance.tehsil
				def dis=indRegInstance.district
				def dateSql=indApplicationDetailsInstance.applicationDate
				def abcFinal1=dateSql
				DateCustom dd1=new DateCustom()
				def dateCreated= (dd1.sQLdate1(abcFinal1))
				def yr=(dateCreated.getYear()).toInteger()+1900
				def mon=(indApplicationDetailsInstance.applicationDate).getMonth()
				def dat=(indApplicationDetailsInstance.applicationDate).getDate()
				def abc=(indApplicationDetailsInstance.id).toString()
				def fileN="F/"+abc+"/"+dat+"/"+mon+"/"+yr
				def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
				def id2=indApplicationDetailsInstance.applicationType
				def consentForVar=indApplicationDetailsInstance.certificateFor
				def applicationForVar=indApplicationDetailsInstance.applicationFor
				def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
				def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
				def sizeVal=conditionMasterList.size()
				def conditionArray =""
				for(int i=0; i<conditionMasterList.size();i++) {
					int srNo=i+1;
					conditionArray=conditionArray+"\n"+srNo+". "+(conditionMasterList.get(i)).condition
				}
				def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
				def sizeValG=conditionMasterListG.size()
				def conditionArrayG =""
				for(int i=0; i<conditionMasterListG.size();i++) {
					int srNo=i+1;
					conditionArrayG=conditionArrayG+"\n"+srNo+". "+(conditionMasterListG.get(i)).condition
				}
				 def recordCertificateInstance = RecordCertificate.find("from RecordCertificate where applicationId=? order by id desc",[indApplicationDetailsInstance])
				render(view:'redOrangeCertificateModified',model:[recordCertificateInstance:recordCertificateInstance,viewR4_Certificate:viewR4_Certificate,viewR_Certificate:viewR_Certificate,viewCert:viewCert,conditionArray:conditionArray,conditionArrayG:conditionArrayG,roleHeader:roleHeader,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
	  }
}

def pdfredOangeModified={
		println("pdfredOangeModified.."+pdfredOangeModified)
		File certFile
			File certFile12
			ApplicationFileRecord file=new ApplicationFileRecord()
			def recordCertificateInstance=new RecordCertificate()
			def appID=params.idIndApp
			def indApplicationDetailsInstance=IndApplicationDetails.get((params.idIndApp).toLong())
			def indRegInstance=indApplicationDetailsInstance.indUser
			def applFor=indApplicationDetailsInstance.applicationFor
			println("--applFor--"+applFor)
			def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
			def certFor=indApplicationDetailsInstance.certificateFor
			if(certFor.equals("new")){
				certFor="Fresh"
               }
               if(certFor.equals("Modern")){
               	certFor = "Modernization "
               }
               if(certFor.equals("expan")){
               	certFor = "Expansion"
               }
               if(certFor.equals("reNew")){
               	certFor = "Renew"
               } 
			def indCategory=(indRegInstance.category.name).toUpperCase()
			def id = (indApplicationDetailsInstance.id).toString()
			def indNewCapInvt=indRegInstance.indCapInvt.toString()
			def waterConsumption = ""
			def effluentGeneration = ""
			def offDistrict=indRegInstance.district.districtName
			def id3=indApplicationDetailsInstance.indUser 
			def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
			def industrytype12=industryTypeMasterInstance.industryType
//////////////////////////////Fetch data from Schedule II(IR)////////////////////////////////////////////////////				
			def check = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
			def waterIns=WaterBudget.findByApplication(indApplicationDetailsInstance)
			if(check){
				indNewCapInvt = check.totalCap
			}
			if(waterIns){
				waterConsumption = waterIns.wcpresent
				effluentGeneration = waterIns.egpresent
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
			def id2=indApplicationDetailsInstance.applicationType
			def consentForVar=indApplicationDetailsInstance.certificateFor
			def applicationForVar=indApplicationDetailsInstance.applicationFor
			def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
			def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
			def sizeVal=conditionMasterList.size()
			def conditionArray = new String[sizeVal] 
			for(int i=0; i<conditionMasterList.size();i++) {
				conditionArray[i]=(conditionMasterList.get(i)).condition
			}
			def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
			def sizeValG=conditionMasterListG.size()
			def conditionArrayG = new String[sizeValG] 
			for(int i=0; i<conditionMasterListG.size();i++) {
				conditionArrayG[i]=(conditionMasterListG.get(i)).condition
			}
			def referenceCheck=params.references
			def refSize=referenceCheck.size()
			def referencesArray = new String[refSize] 
			def referenceStore=""
			if(referenceCheck.getClass().getName()=="java.lang.String") {
				referenceStore="1. "+referenceCheck
			}else{
				for(int varI=0; varI<referenceCheck.size();varI++) {
					int varInteger=varI+1
					referencesArray[varI]=referenceCheck[varI]
					referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
				}
			}
			for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
			}
			def dateCreateOn=indApplicationDetailsInstance.applicationDate
			def hazType=indApplicationDetailsInstance.hazardeousType
			def abcFinal1=dateCreateOn
			DateCustom dd1=new DateCustom()
			def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
			def dDate=new Date()
			def abcFinal=dDate
			DateCustom dd=new DateCustom()
			def todayDate= (dd.sQLdate1(abcFinal)).toString()
			def val=params.pdfc
			def val2=params.pdfc2
			def val3=params.pdfc3
			DevImg dimg=new DevImg()
			def name=indRegInstance.indName
			def address=indRegInstance.indAddress
			def tehsil1=indRegInstance.tehsil.toString()
			def indCity = indRegInstance.indCity
			def pin =indRegInstance.indPin
			def district=(indRegInstance.district).toString()
			def fileN=params.fileNo
			def order="40001"
			def videNo="980"
			def subject=params.subject
			def occName=params.occName
			def indName=params.indName
			def indRegNum=params.indRegNum
			def indRegDate=params.indRegDate_value
			def cntrlequipment
			if(params.cntrlequipment){
				cntrlequipment=params.cntrlequipment
			}else{
				cntrlequipment=""
			}
			PdfGenerationredOrange pdfG=new PdfGenerationredOrange()
			def sCondition=params.specificConditions
			def gCondition=params.generalConditions
			def indusName = indRegInstance.indName
			def indAddress = indRegInstance.indAddress
			def occAddress=indRegInstance.occAddress
/////////////////////to get Current year
			SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
			java.util.Date nowDate = new java.util.Date();
			String currentYear = formatNowYear.format(nowDate);
			println("currentYear..."+currentYear)
///////////////////Consent No////////////////////////
			Integer year1 = new Date().getYear().toInteger()
			String year=(year1+1900).toString()
			String yearString = (String)year.substring(2,4)
			def issuingConsentTypeNo		
			if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="new"){
				issuingConsentTypeNo="01"
			}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="expan"){
				issuingConsentTypeNo="02"
			}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="reNew"){
				issuingConsentTypeNo="03"
			}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="new"){
				issuingConsentTypeNo="04"
			}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="expan"){
				issuingConsentTypeNo="05"
			}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="reNew"){
				issuingConsentTypeNo="06"
			}
////////////////////////////////Authorization Number/////////////////////////////
					def authno="H"
////////////////////////////////////////end here
			def category=indRegInstance.category.name 
			def regId = indRegInstance.indRegNum
			def regDate = indRegInstance.regDate
			def dfh = new SimpleDateFormat("dd/MM/yyyy"); 
			regDate= dfh.format((java.util.Date) regDate)
		def productDetailsList1 = new ArrayList()
			def productDetailsInstance1=CosentCertProductDetails.findAllByApplication(indApplicationDetailsInstance)
		int cc = 1
			for(int var10=0;var10<productDetailsInstance1.size();var10++)
			{
				def productList1= new ArrayList()
				String s = Integer.toString(cc)
				productList1.add(s)
				productList1.add(productDetailsInstance1.get(var10).product)
				productList1.add(productDetailsInstance1.get(var10).quantity)
				productList1.add(productDetailsInstance1.get(var10).unit.unitName)
				productDetailsList1.add(productList1)
				cc++
			}
////////////////////////////////////////////////////////Hotel details////////////////////
			def productDetailsList11 = new ArrayList()
			def productDetailsInstance11=CosentCertHotelDetails.findAllByApplication(indApplicationDetailsInstance)
			int cc3 = 1
			for(int var10=0;var10<productDetailsInstance11.size();var10++)
			{
				def productList11= new ArrayList()
				String s = Integer.toString(cc3)
				productList11.add(s)
				productList11.add(productDetailsInstance11.get(var10).product)
				productList11.add(productDetailsInstance11.get(var10).quantity)
				productDetailsList11.add(productList11)
				cc3++
			}
////////////////////////////Stack details for hote////////////////////////////
def stackDetailsList1 = new ArrayList()
		def stackDetailsInstance1=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
			int cccc1 = 1
					for(int var10=0;var10<stackDetailsInstance1.size();var10++)
						{
						def stackList1= new ArrayList()
						String s = Integer.toString(cccc1)
						stackList1.add(s)
						stackList1.add(stackDetailsInstance1.get(var10).stackAttachedTo)
						stackList1.add(stackDetailsInstance1.get(var10).stackHeight)
						stackDetailsList1.add(stackList1)
						cccc1++
						}
////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
def stackDetailsList = new ArrayList()
		def stackDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
			int cccc = 1
					for(int var10=0;var10<stackDetailsInstance.size();var10++)
						{
						def stackList= new ArrayList()
						String s = Integer.toString(cccc)
						stackList.add(s)
						stackList.add(stackDetailsInstance.get(var10).stackAttachedTo)
						stackList.add(stackDetailsInstance.get(var10).stackVolume)
						stackList.add(stackDetailsInstance.get(var10).stackHeight)
						stackList.add(stackDetailsInstance.get(var10).topDiameter)
						stackList.add(stackDetailsInstance.get(var10).velocityOfGasEmission)
						stackDetailsList.add(stackList)
						cccc++
						}
////////////////////////////////Fuel Details////////////////////////////////////////////	
def fuelDetailsList = new ArrayList()
		def fuelDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
			int e22 = 1
					for(int var10=0;var10<fuelDetailsInstance.size();var10++)
						{
						def fuelList= new ArrayList()
						String s = Integer.toString(e22)
						fuelList.add(s)
						fuelList.add(fuelDetailsInstance.get(var10).typeOfFuel)
						fuelList.add(fuelDetailsInstance.get(var10).maximumQuantity)
						fuelList.add(fuelDetailsInstance.get(var10).unit.unitName)
						fuelDetailsList.add(fuelList)
						e22++
						}
////////////////////////////////Pollution Control Equipm,ent Details////////////////////////////////////////////	
def PollutionControlList = new ArrayList()
		def PollutionControlInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
		int e226 = 1
					for(int var10=0;var10<PollutionControlInstance.size();var10++)
						{
						def PollutionList= new ArrayList()
						String s = Integer.toString(e226)
						PollutionList.add(s)
						String pollControl=PollutionControlInstance.get(var10).pollutionCntrlMeasure
						pollControl=pollControl.replace("]","")
						pollControl=pollControl.replace("[","")
						PollutionList.add(pollControl)
						PollutionControlList.add(PollutionList)
						e226++
						}
////////////////////////////////Solid Waste Disposal Details///////////////////////////////////////////////	
def solidWasteDisposalDetailsList1 = new ArrayList()
			def solidWasteDisposalDetailsInstance1=CosentCertSolidWasteDisposalDetails.findAllByApplication(indApplicationDetailsInstance)
				int cs = 1
				for(int var10=0;var10<solidWasteDisposalDetailsInstance1.size();var10++){
						def solidWasteDisposalDetailsList= new ArrayList()
							String s = Integer.toString(cs)
							solidWasteDisposalDetailsList.add(s)
							solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).typeofWaste)
							solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).quantity)
							solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).disMode.disposalMode)
							solidWasteDisposalDetailsList1.add(solidWasteDisposalDetailsList)
							cs++
						}
////////////////////////////////Hazardeous Waste Details///////////////////////////////////////////////	
def hazardousWasteGenDetailsList = new ArrayList()
			def hazardousWasteGenDetailsInstance1=HazardousWasteGenDetailsCert.findAllByApplication(indApplicationDetailsInstance)
				for(int var10=0;var10<hazardousWasteGenDetailsInstance1.size();var10++){
						def hazardousWasteDetailsList= new ArrayList()
							hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).authFor)
							hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).sourceName.name)
							hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.name)
							//hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.category)
							hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).quantity)
							hazardousWasteGenDetailsList.add(hazardousWasteDetailsList)
						}
def copyTo=params.copyTo
			def wasteWater=params.wasteWater
			def capInvest=params.capInvest
			def waterConsume=params.waterConsume
			def sewageEffluent=params.sewageEffluent
			def specificConditionsforAuth=params.specificConditionsforAuth
			def fileNumberIn
			if(params.fileNumber){
				fileNumberIn=params.fileNumber
			}else{
				fileNumberIn=""
			}
			def endtNumberIn=params.endtNumber
			def draftDate=params.draftLetterDate_value
			def startDate1=params.grantedFrom_value
			def endDate1=params.grantedTo_value
			def maxQuantity=params.maxQuantity
			def checkDate
			def x
			def y
			try {
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
				x = sdfh.parse(startDate1); //Date
				y = sdfh.parse(endDate1);
				checkDate="checked"
			}
			catch(Exception e) {
				flash.message="Enter Both The Consent Granted Dates "
				render(view:'redOrangeCertificateModified',model:[indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN])
			}
			if(checkDate) {
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				if(sqlDate>sqlDate2) {
					flash.message="Grant To Date should be Greater than Grant From Date"
					render(view:'redOrangeCertificateModified',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
				}else {
					def recordCertificate = RecordCertificate.find("from RecordCertificate abc where abc.applicationId=? and abc.typeofCertificate='Modified'",[indApplicationDetailsInstance])
					def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate1'",[(indApplicationDetailsInstance.id).toLong()])
					def filerecordinstance1=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Authorization1'",[(indApplicationDetailsInstance.id).toLong()])
					if(recordCertificate)
						{
						recordCertificate.delete()
						}
					 if(filerecordinstance)
					 {
						 filerecordinstance.delete();
					 }
					 if(filerecordinstance1)
					 {
						 filerecordinstance1.delete();
					 }
					recordCertificateInstance.startDate=sqlDate
					recordCertificateInstance.endDate=sqlDate2
					recordCertificateInstance.updatedBy=session.userMaster
					recordCertificateInstance.createdBy=session.userMaster
					recordCertificateInstance.generalCondition=gCondition
					recordCertificateInstance.specificCondition=sCondition
					recordCertificateInstance.subjectData=params.subject
					recordCertificateInstance.refData=referenceStore
					recordCertificateInstance.maxQuantity=maxQuantity
					recordCertificateInstance.copyTo=copyTo
					recordCertificateInstance.wasteWater=wasteWater
					recordCertificateInstance.capInvest=capInvest
					recordCertificateInstance.waterConsume=waterConsume
					recordCertificateInstance.sewageEffluent=sewageEffluent
					recordCertificateInstance.typeofCertificate="Modified"
					if(specificConditionsforAuth!=null){
					recordCertificateInstance.specificConditionsforAuth=specificConditionsforAuth
					}else{
						recordCertificateInstance.specificConditionsforAuth=""
					}
					recordCertificateInstance.applicationId=indApplicationDetailsInstance
					boolean hotelCheck=false
					boolean cementCheck=false
					boolean stonecrushers=false
					boolean stonecrushers1=false
					boolean pharmaCheck=false
					boolean pesticideCheck=false
					///////////////////////////HOTEL////////////////////////////
					String string = indRegInstance.industryType.industryType;
				      String keyword = "HOTELS";
				      String keyword1 = "Hotels";
				      String keyword2 = "hotels";
				      boolean found = Arrays.asList(string.split(" ")).contains(keyword);
				      boolean found1 = Arrays.asList(string.split(" ")).contains(keyword1);
				      boolean found2 = Arrays.asList(string.split(" ")).contains(keyword2);
				      if(found || found1 || found2){
				            System.out.println("Keyword matched the string"+found);
				            hotelCheck = true;	
				      }
				  /////////////////////////////CEMENT////////////////////////////////////////////
				  		String keywordC = "CEMENT";
					      String keyword1C = "Cement";
					      String keyword2C = "cement";
					      boolean foundC = Arrays.asList(string.split(" ")).contains(keywordC);
					      boolean found1C = Arrays.asList(string.split(" ")).contains(keyword1C);
					      boolean found2C = Arrays.asList(string.split(" ")).contains(keyword2C);
					      if(foundC || found1C || found2C){
					            System.out.println("Keyword matched the string"+foundC);
					            cementCheck = true;	
					      }
///////////////////////////Stone Crushers////////////////////////////
					      boolean foundS = string.contains("Stone crushers");
					      boolean foundS7 = string.contains("Hot mix plants");
					     if(foundS7){
					            stonecrushers1 = true;	
					      }
					     if(foundS){
					           stonecrushers = true;	
					      }
/////////////////////////////Pharma////////////////////////////////////////////
							boolean foundC1 = string.contains("Pharma");
						     if(foundC1){
						            System.out.println("Keyword matched the string"+foundC1);
						            pharmaCheck = true;	
						      }
////////////////////////////Pesticide////////////////////////////////////////////
						  		String keywordC11 = "PESTICIDES";
							      String keyword1C11 = "Pesticides";
							      String keyword2C11 = "pesticides";
							      boolean foundC11 = Arrays.asList(string.split(" ")).contains(keywordC11);
							      boolean found1C11 = Arrays.asList(string.split(" ")).contains(keyword1C11);
							      boolean found2C11 = Arrays.asList(string.split(" ")).contains(keyword2C11);
							      if(foundC11 || found1C11 || found2C11){
							            System.out.println("Keyword matched the string"+foundC11);
							            pesticideCheck = true;	
							      }		
					if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
						flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
						if(hazType=="HWM"){
								def  file1=new ApplicationFileRecord()
								def pdAuth=new PdfGenerationAuthorization()
								if(referenceCheck.getClass().getName()=="java.lang.String") {
									certFile12=pdAuth.pdfFunctionAuthorization(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
											indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
											applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
											indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
											PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,specificConditionsforAuth,hazardousWasteGenDetailsList)
								}else{
									certFile12=pdAuth.pdfFunctionAuthorization(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
											indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
											applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
											indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
											PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,specificConditionsforAuth,hazardousWasteGenDetailsList)
								}
								def link="link"
									byte[] b1 = new byte[(int) certFile12.length()];
									FileInputStream fileInputStream11 = new FileInputStream(certFile12);
									fileInputStream11.read(b1);
									def fileLength111=certFile12.length()
									file1.size = fileLength111 / 1024  //f.getSize() 
									file1.extension ="pdf"//extractExtension( f )
									file1.data=b1;
									file1.name="Authorization.pdf"
									file1.description="Authorization"
									file1.createdBy=session.userMaster
									file1.updatedBy=session.userMaster
									file1.typeOfFile="Authorization1"
									file1.indApplication=indApplicationDetailsInstance
									if(file1.save()) {
									} else {
										file1.errors.each
										{
											println it
										}
									}
							}
				if(hotelCheck || indApplicationDetailsInstance.applicationFor=="hotel"){
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunctionHotel(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,stackDetailsList1,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,productDetailsList11,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,
										waterConsumption,effluentGeneration,authno,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
							}else{
								certFile=pdfG.pdfFunctionHotel(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,stackDetailsList1,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,productDetailsList11,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,
										waterConsumption,effluentGeneration,authno,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
							}	
						}
						else if(cementCheck){
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunctionCement(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
							}else{
								certFile=pdfG.pdfFunctionCement(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
							}	
						}else if(stonecrushers || stonecrushers1 || indApplicationDetailsInstance.applicationFor=="hotmixplants" || 
								indApplicationDetailsInstance.applicationFor=="stonecrusher and hotmixplants" ||
								indApplicationDetailsInstance.applicationFor=="stonecrusher"){
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunctionStonecrushers(applFor,indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
							}else{
								certFile=pdfG.pdfFunctionStonecrushers(applFor,indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
							}	
						}else if(pharmaCheck){
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunctionPharma(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
							}else{
								certFile=pdfG.pdfFunctionPharma(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
							}	
						}else if(pesticideCheck){
							if(referenceCheck.getClass().getName()=="java.lang.String") {
								certFile=pdfG.pdfFunctionPesticide(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
										capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
							}else{
								certFile=pdfG.pdfFunctionPesticide(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
										applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
										indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno
										,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList)
							}	
						}else{
							println("--if applied for Both in Industry-")
						if(referenceCheck.getClass().getName()=="java.lang.String") {
							println("--if applied for Both in Industry--1")
							certFile=pdfG.pdfFunctionIndustry(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}else{
							println("--if applied for Both in Industry--1")
							certFile=pdfG.pdfFunctionIndustry(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
									indNewCapInvt,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
									applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,industrytype12,
									indCategory,offDistrict,currentYear,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,waterConsumption,effluentGeneration,authno,
									PollutionControlList,wasteWater,capInvest,waterConsume,sewageEffluent,indName,indRegNum,indRegDate)
						}}
						def link="link"
						byte[] b = new byte[(int) certFile.length()];
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						def fileLength=certFile.length()
						file.size = fileLength / 1024  //f.getSize() 
						file.extension ="pdf"//extractExtension( f )
						file.data=b;
						file.name="CertiFicate.pdf"
						file.description="Certificate Generation Record"
						file.createdBy=session.userMaster
						file.updatedBy=session.userMaster
						file.typeOfFile="Certificate1"
						file.indApplication=indApplicationDetailsInstance
						if(file.save()) {
//code added for dashboard change start from here
							def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(indApplicationDetailsInstance.id).toString()]);
							if(allSummaryReportInstance)
							{
							allSummaryReportInstance.dateOfIssue=abcFinal;
							allSummaryReportInstance.dateOfexpiry=sqlDate2;
							if( !allSummaryReportInstance.hasErrors()&& allSummaryReportInstance.save(flush:true)){
								
							}
							}
						//code ends here
							redirect(action:appProcessing,params:["id":params.idIndApp])
						} else {
							file.errors.each
							{
								println it
							}
							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
							render(view:'redOrangeCertificateModified',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
						}
					}
					else {
						recordCertificateInstance.errors.each
						{
							println it
						}
						render(view:'redOrangeCertificateModified',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}
				}
			}	
}

def downLoadingCertificate11={
		 try {
				def appId=IndApplicationDetails.get((params.id).toLong())
				def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate1' order by afr.dateCreated desc",[appId],[max:1])
				println("fileDownLoad.downLoadingCertificate."+fileDownLoad)
				def fileSingle=fileDownLoad.get(0);
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
				response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
}
}

def downLoadingAuthorization11={
		 try {
				def appId=IndApplicationDetails.get((params.id).toLong())
				def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Authorization1' order by afr.dateCreated desc",[appId],[max:1])
				println("fileDownLoad.downLoadingAuthorization."+fileDownLoad)
				def fileSingle=fileDownLoad.get(0);
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
				response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
		 redirect(controller:'indUser',action:'openIndustryHome')
		 }else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		       session.invalidate()
		      redirect(uri:'/index.gsp');
		 }
}
}
def popDeeRecommendationsRegular = {
		println("popDeeRecommendationsFresh"+params)
		//def type=params.type
		def app = IndApplicationDetails.get((params.id).toInteger())
		println("ap"+ app)
		def consentInspectionReportInst = IndustryInspectionReport.findByApplication(app)			
		return[appId:app,consentInspectionReportInst:consentInspectionReportInst]	
}

def saveDeeRecommendationsRegular ={
	println("paramsssssssssss...."+params)
	def indApplicationDetailsInstance=IndApplicationDetails.get(params.appId)
	println("indApplicationDetailsInstance...."+indApplicationDetailsInstance)
	def consentInspectionInst = IndustryInspectionReport.findByApplication(indApplicationDetailsInstance)
	println("consentInspectionInst...."+consentInspectionInst)
	UserMaster sess=(UserMaster)session.userMaster
	println("sess...."+sess)
	def userMasterInst=UserMaster.get(sess.id)
	String recomadationType=(params.type)
	
	
		
	ConsentRegularInspectionEERecommendations deeRecommendationInstancebb=new ConsentRegularInspectionEERecommendations();
	deeRecommendationInstancebb.application=indApplicationDetailsInstance;
	deeRecommendationInstancebb.deeRecommendations=params.deeRecommendations
	deeRecommendationInstancebb.deeOfficer=userMasterInst
	deeRecommendationInstancebb.dateCreated= new Date()
	deeRecommendationInstancebb.save(flush:true)	
	
	def consentInspectionReportInst = IndustryInspectionReport.findByApplication(indApplicationDetailsInstance)
	
	InspectionReportDee report=new InspectionReportDee()
	report.regularReport(indApplicationDetailsInstance.id,userMasterInst.id,consentInspectionReportInst,recomadationType)
	
	flash.message = "Officer Remarks Saved"
	
	redirect(action:popDeeRecommendationsRegular,consentInspInst:consentInspectionReportInst,params:[id:indApplicationDetailsInstance,type:recomadationType])

	
	
	
}



def uploadConsentHWMOrder = {
		 try {
			    def idAppl= (params.appliId).toLong()
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
					def viewHWMCertupload = false
					def certInst = UploadConsentHWMOrder.findByApplicationId(indApplicationDetailsInstance)
					if(certInst)
					{
						viewHWMCertupload = true
					}
					def roleHeader=app.role.roleName
			    	return [appDetId:params.appliId,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewHWMCertupload:viewHWMCertupload]
			     }
		 		catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
			  redirect(controller:'indUser',action:'openIndustryHome')
			 }else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
		 }
}


def saveConsentHWMOrder= {
		 try {
			  def idAppl= (params.idIndApp).toLong()
				def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
				def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				def viewHWMCertupload = false
				def certInst = UploadConsentHWMOrder.findByApplicationId(indApplicationDetailsInstance)
				if(certInst)
				{
					viewHWMCertupload = true
				}
				def roleHeader=app.role.roleName
				def recordCertificateInstance=new UploadConsentHWMOrder()
				ApplicationFileRecord file=new ApplicationFileRecord()
				def startDate1=params.grantedFrom_value
				def endDate1=params.grantedTo_value
				def referenceDate=params.referenceDate_value
				def checkDate
				def x
				def y
				def zz
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(startDate1); //Date
					y = sdfh.parse(endDate1);
					zz = sdfh.parse(referenceDate);
					checkDate="checked"
				}
				catch(Exception e) {
					flash.message="Enter Both The Consent Granted Dates "
					render(view:'uploadConsentHWMOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewHWMCertupload:viewHWMCertupload])
				}
				if(checkDate) {
			java.sql.Date refDate = new java.sql.Date(zz.getTime())
					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
					if(sqlDate>sqlDate2) {
						flash.message="Grant To Date should be Greater than Grant From Date"
						render(view:'uploadConsentHWMOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewHWMCertupload:viewHWMCertupload])
					}else {
						recordCertificateInstance.startDate=sqlDate
						recordCertificateInstance.endDate=sqlDate2
						if(session.userMaster==null)
				    	{
							flash.message="Your session has been expired ! Please login again."
				    		redirect(uri:'/index.gsp')
				    		return
				    	}
						def refNo = ""
						if(params.referenceNo)
						{
							refNo = params.referenceNo
						}
						else
						{
							flash.message="Please enter Reference no. for this application"
								render(view:'uploadConsentHWMOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewHWMCertupload:viewHWMCertupload])
								return
						}
				    	recordCertificateInstance.referenceNo=refNo
				    	recordCertificateInstance.referenceDate=refDate
				    	recordCertificateInstance.updatedBy=session.userMaster
						recordCertificateInstance.createdBy=session.userMaster
						recordCertificateInstance.applicationId=indApplicationDetailsInstance
						if(!recordCertificateInstance.hasErrors()) {
							def f = request.getFile('consentOrder')
							if(!f.empty) {
							def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='ConsentOrder'",[(indApplicationDetailsInstance.id).toLong()])
							if(filerecordinstance)
									 {
										 filerecordinstance.delete();
									 }
				    			MultipartFile multi = request.getFile('consentOrder')
								file.size = multi.getSize() / 1024
								file.extension = extractExtension( multi )
								file.data=multi.getBytes()
								def abc = "CertiFicate"
					            def b = abc+"."+extractExtension( multi )
					            file.name =b 
					            file.description="HWM Certificate Generation Record"	
					            	if(session.userMaster==null)
					            	{
					            		flash.message="Your session has been expired ! Please login again."
					            		redirect(uri:'/index.gsp')
					            		return
					            	}
				    			file.createdBy=(session.userMaster).toString()
						 	    file.updatedBy=(session.userMaster).toString()
								file.typeOfFile="ConsentHWMOrder"
					 	    	file.indApplication=indApplicationDetailsInstance
					 	    	file.dateCreated=new Date()
								Byte[] bytes=multi.getBytes() 
								if(file.save()) {
									recordCertificateInstance.save()
									flash.message = "HWM Certificate Generated and Record Saved "
								} else {
									flash.userMessage = "File [${file.name}] has NOT not been uploaded."
										render(view:'uploadConsentHWMOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewHWMCertupload:viewHWMCertupload])
										}
							}
							redirect(action:appProcessing,params:["id":params.idIndApp,"viewHWMCertupload":viewHWMCertupload])
						}
						else {
							flash.message="Can not contain special characters or reserve words"
							render(view:'uploadConsentHWMOrder',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewHWMCertupload:viewHWMCertupload])
						}
				}	
		}
}
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
}
}

def downLoadingConsentHWMCertificate={
		 try {
				def appId=IndApplicationDetails.get((params.id).toLong())
				def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentHWMOrder' order by afr.dateCreated desc",[appId],[max:1])
				def fileSingle=fileDownLoad.get(0);
				response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )
				response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
		  }
		 catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
}				
}
def popupDetailsofAttachedFile={
		println("-----ind id----"+params.id)
		def appId=params.id.toLong()
		def singleInstance
		def oneVar
		def twoVar
		def applicationfileRecordInstance= ApplicationFileRecord.findAll("from ApplicationFileRecord afd where afd.indApplication.id=? and afd.typeOfFile='attachLetter'",[appId])
		def applicationProcessingInstance=ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails afd where afd.application.id=?  order by dateCreated desc",[appId])
		if(applicationProcessingInstance.size()>0 && applicationfileRecordInstance.size()>0){
	     singleInstance=applicationProcessingInstance[0]
	     oneVar=singleInstance.officerFwd
	     twoVar=applicationfileRecordInstance[0].updatedBy
		}
		println("----true---11-----"+oneVar+"---dfd------"+twoVar)
		if(oneVar==twoVar){
			println("----true--------")
		}else{
			println("----in else--------")
		}
		render(view:'popupDetailsofAttachedFile',model:[ins:applicationfileRecordInstance,insForAppProcess:singleInstance])
}





//http://localhost:8080/OCMMS-0.1/applicationProcessingDetails/testSvenTeenCat?appld=17165
//http://localhost:8080/OCMMS-0.1/applicationProcessingDetails/testSvenTeenCat?appld=8055311
//http://164.100.163.18/PPCB/applicationProcessingDetails/testSvenTeenCat?appld=17165
		
def testSvenTeenCat={
println("params:"+params);
def appId=params.appld
if(appId){
    println("appId:"+appId);
    def app = IndApplicationDetails.find("from IndApplicationDetails where id= ?",[appId.toLong()])

    if(app){
        println("app:"+app)
        boolean ab=saveSvenTeenCategory(app)
        println("ab"+ab)
        return ab;
    }
}else{
    println("appId:"+appId);
}

}

public boolean saveSvenTeenCategory(IndApplicationDetails application) {

    def appPros = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and approve='t' ORDER BY dateCreated desc", [application])
    println("check in approve application:" + appPros);

    if (application.indUser.industryType.dashboard != 0) {

        SevenTeenCategoryData st;
        if (appPros){
            def sevenTeenCat = SevenTeenCategoryData.find("from SevenTeenCategoryData where application_id=? and ( returnNO !='200' and returnNO !='201') ", [(application.id).toString()])
            println("sevenTeenCat:" + sevenTeenCat)

            if (!sevenTeenCat) {

                def sevenTeenCat1 = SevenTeenCategoryData.find("from SevenTeenCategoryData where application_id=?", [(application.id).toString()])
                def indUser = IndUser.find("from IndUser where industryRegMaster=?", [application.indUser])
                def appPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?", [application])

                def rawMtd = RawMaterialDetails.find("from RawMaterialDetails where application=?", [application])
                println("check in Raw Material Details:" + rawMtd)

                if (sevenTeenCat1) {
                    st = sevenTeenCat1;
                } else {
                    st = new SevenTeenCategoryData();
                }

                String industry_id = st.industry_id = indUser.id.toString();
                String industry_name = st.industry_name = application.indUser.indName;
                String ind_address = st.ind_address = application.indUser.indAddress;
                String district_name = st.district_name = application.indUser.district.districtName;
                String ind_category_name = st.ind_category_name = application.indUser.category.name;
                String ind_type_name = st.ind_type_name = application.indUser.industryType.industryType;
                String occ_email = st.occ_email = application.indUser.occEmail;
                String occupier_name = st.occupier_name = application.indUser.occName;
                String occupier_designation = st.occupier_designation = application.indUser.occDesignation;
                String application_id = st.application_id = application.id.toString();

                SimpleDateFormat sdfDestination1 = new SimpleDateFormat("MMM dd yyyy hh:mma");

                String application_reciept_date = st.application_reciept_date = (sdfDestination1.format(appPending.completionDate)).toString();
                String grant_date = st.grant_date = (sdfDestination1.format(appPending.completionDate)).toString();
                String product_name = st.product_name = rawMtd.rawMaterialname
                String quantity = st.quantity = rawMtd.rawMaterialquantity.toString()
                String unit = st.unit = rawMtd.unit.toString()
                String ipaddr = st.ipaddr = request.getRemoteAddr().toString();
                String occ_mobile = st.occ_mobile = application.indUser.occMobile;
                String application_type = st.application_type = application.applicationFor;
                String state = st.state = "Jammu and Kashmir";

                if (!st.hasErrors() && st.save(flush: true)) {
                    println("data has been saved")
                    Response rs = new Response();

                    String setData = rs.sendSevenTeenCategoryData(industry_id, industry_name, ind_address, district_name, ind_category_name, ind_type_name, occ_email, occupier_name, occupier_designation, application_id, application_reciept_date, state, grant_date, product_name, quantity, unit, ipaddr, occ_mobile, application_type);
                    st.returnNO = setData

                    if (!st.hasErrors() && st.save(flush: true)) {
                        println("data has been updated")
                        return true;

                    } else {
                        println("Errors01:-");
                        if (st.hasErrors()) {
                            st.errors.allErrors.each {
                                println it
                            }
                        }
                        return false;
                    }
                    return false;

                } else {
                    println("Errors02:-")
                    if (st.hasErrors()) {
                        st.errors.allErrors.each {
                            println it
                        }
                    }
                    return false;
                }
            } else {
                println("data has been already submited:-")
            }
        }
    }else{
        println("Not In Seven Teen Category")
    }
}

def viewScrutiny = {

		def application = IndApplicationDetails.get((params.id).toLong())
		
		
		def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'desc',offset:0]) 
		println("ppppp----------------"+applicationProcessingDetailsInstanceList)
		for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
			if((applicationProcessingDetailsInstanceList.get(i)).scrutinyStatus=='In-Complete'){
				
				println("ppppp-----------2222222-----"+applicationProcessingDetailsInstanceList)
				return[appScrutiny:applicationProcessingDetailsInstanceList.get(i),app:application]
			}
		}
	
}

def viewScrutinyReportIndustry={
		def application = IndApplicationDetails.get((params.appliLoc).toLong())
		def type=params.docName
		def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile=? order by afr.dateCreated desc",[application,type],[max:1])
		def applicationFileSingleInstance=applicationFileInstance[0]
		if(applicationFileSingleInstance)
		{
		response.setContentType( "application-xdownload")
		response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
		}
		else
		{
			flash.message = "File not Attached by PPCB Officer"
			redirect(action:viewScrutiny,params:["id":params.appliLoc])
		}
	}

def viewFile3 = {
		println("params"+params)
		//println((params.verValue).getClass().getName()+"    :   "+(params.appliLoc).getClass().getName())
		//def fileVer=(params.verValue).toLong()
		//println(fileVer)
		
		def application = IndApplicationDetails.get((params.appliLoc).toLong())
		println("application=========="+application)
		def applicationFileInstance = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='scrutinyReport'",[application])
		println(applicationFileInstance)
		def applicationFileSingleInstance=applicationFileInstance
		response.setContentType( "application-xdownload")
		response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				
	}

}
	
		
		
		

