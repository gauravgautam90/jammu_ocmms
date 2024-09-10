                                                                                                              
import java.lang.Exception
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.Format;
import java.text.ParseException;
import java.io.File
import java.io.FileInputStream
import java.lang.NumberFormatException
import org.apache.commons.fileupload.DiskFileUpload
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile
class WasteManagementProcessingDetailsController {
    
def index = {
    		 try {
    		    redirect(action:list,params:params) 
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

static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
    	 try {
    	     params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ wasteManagementProcessingDetailsInstanceList: WasteManagementProcessingDetails.list( params ), wasteManagementProcessingDetailsInstanceTotal: WasteManagementProcessingDetails.count() ]
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

 def show = {
    	 try {
    	 def wasteManagementProcessingDetailsInstance = WasteManagementProcessingDetails.get( params.id )
    	        if(!wasteManagementProcessingDetailsInstance) {
    	            flash.message = "WasteManagementProcessingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ wasteManagementProcessingDetailsInstance : wasteManagementProcessingDetailsInstance ] }
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

def delete = {
        def wasteManagementProcessingDetailsInstance = WasteManagementProcessingDetails.get( params.id )
        if(wasteManagementProcessingDetailsInstance) {
            try {
                wasteManagementProcessingDetailsInstance.delete()
                flash.message = "WasteManagementProcessingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "WasteManagementProcessingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "WasteManagementProcessingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    	  def wasteManagementProcessingDetailsInstance = WasteManagementProcessingDetails.get( params.id )
    	        if(!wasteManagementProcessingDetailsInstance) {
    	            flash.message = "WasteManagementProcessingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ wasteManagementProcessingDetailsInstance : wasteManagementProcessingDetailsInstance ]
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

 def update = {
    	 try {
    	 def wasteManagementProcessingDetailsInstance = WasteManagementProcessingDetails.get( params.id )
    	        if(wasteManagementProcessingDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(wasteManagementProcessingDetailsInstance.version > version) {
    	                    wasteManagementProcessingDetailsInstance.errors.rejectValue("version", "wasteManagementProcessingDetails.optimistic.locking.failure", "Another user has updated this WasteManagementProcessingDetails while you were editing.")
    	                    render(view:'edit',model:[wasteManagementProcessingDetailsInstance:wasteManagementProcessingDetailsInstance])
    	                    return
    	                }
    	            }
    	            wasteManagementProcessingDetailsInstance.properties = params
    	            if(!wasteManagementProcessingDetailsInstance.hasErrors() && wasteManagementProcessingDetailsInstance.save()) {
    	                flash.message = "WasteManagementProcessingDetails ${params.id} updated"
    	                redirect(action:show,id:wasteManagementProcessingDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[wasteManagementProcessingDetailsInstance:wasteManagementProcessingDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WasteManagementProcessingDetails not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
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

 def create = {
    	 try {
    	  def wasteManagementProcessingDetailsInstance = new WasteManagementProcessingDetails()
    	        wasteManagementProcessingDetailsInstance.properties = params
    	        return ['wasteManagementProcessingDetailsInstance':wasteManagementProcessingDetailsInstance]
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

 def save = {
    	 try {
    	  def wasteManagementProcessingDetailsInstance = new WasteManagementProcessingDetails(params)
    	        if(!wasteManagementProcessingDetailsInstance.hasErrors() && wasteManagementProcessingDetailsInstance.save()) {
    	            flash.message = "WasteManagementProcessingDetails ${wasteManagementProcessingDetailsInstance.id} created"
    	            redirect(action:show,id:wasteManagementProcessingDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[wasteManagementProcessingDetailsInstance:wasteManagementProcessingDetailsInstance])
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
    
def appProcessing = {
    	 try {
    	 def fileId=null
    	    	if(params.fileid!=null)
    	    	{
    	    		fileId=params.fileid
    	    	}
    	    	boolean viewCert
    	    	if(params.checkForView!=null)
    	    	{
    	    		if(params.checkForView=='true')
    	    		{
    	    			viewCert=true
    	    		}
    	    	}
    	    	def applicationDetails = WasteManagementPendingDetails.get((params.id).toLong())
    	    	def appFor=applicationDetails.applicationFor
    	    	def appIdStr=applicationDetails.applicationId
    	    	def appId=(applicationDetails.applicationId).toLong()
    	    	def application
    	    	def isRenew
    	    	boolean chk
    	    	def list = WasteManagementCertificates.findAllWhere(applicationId:appId)
    	    	if(list.size()>0)
    	    	{
    	    		chk=true
    	    	}
    	    	println("----appFor-and --applicationDetails---"+appFor+"----"+applicationDetails)
    	    	if(appFor=="HWM"){
    	    		application=HazardeousWasteAuthApp.get(appId)
    	    		isRenew=application.is_Renew
    	    	}else if(appFor=="MSW"){
    	    		application=MunicipalSolidWaste.get(appId)
    	    		if(application.authorizationType=="FreshApplication")
    	    		{
    	    		isRenew="No"
    	    		}
    	    		else
    	    		{
    	    			isRenew="Yes"
    	    		}
    	    	}else if(appFor=='BMW'){
    	    	application=BioMedicalWaste.get(appId)
    	    		if(application.authorizationType=="FreshApplication")
    	    		{
    	    		isRenew="No"
    	    		}
    	    		else
    	    		{
    	    			isRenew="Yes"
    	    		}
    	    	}else{
    	    		application=PlasticWaste.get(appId)
    	    		if(application.authorisationAppliedFor=='fresh'){
    	    			isRenew='No'
    	    		}else{
    	    			isRenew='Yes'
    	    		}
    	    	}
    	    def app = WasteManagementPendingDetails.findByApplicationId(appIdStr)
    	    	def roleHeader=app.role.roleName
    	    	def roleActList = RoleVsActivity.findAllByRole(app.role)
    	    	def actionList = new ArrayList()
    	    	def clarification = false
    	    	def inspection = false
    	    	def approve = false
    	    	def reject = false
    	    	def inspectionClose = false
    	    	def prepareCertificate = false
    	    	def fwdRoleList = new ArrayList()
    	    	/*def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
    	    	for(int i=0;i<workFlowMasterList.size();i++){ 
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
    	    		}
    	    	}
    	    	println("----application-----"+application.id)
    	    	def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAllByApplicationId(appIdStr,[sort:'dateCreated',order:'desc',offset:0])
    	    	if(applicationProcessingDetailsInstanceList){
    	    		def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
    	    		model:[roleHeader:roleHeader,actionList:actionList,clarification:clarification,inspection:inspection,applicationDetails:applicationDetails,fwdRoleList:fwdRoleList,app:app,approve:approve,reject:reject,inspectionClose:inspectionClose,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,prepareCertificate:prepareCertificate,appIdStr:appIdStr,appFor:appFor,isRenew:isRenew,appId:appId,viewCert:viewCert,fileId:fileId,chk:chk, application:application,appl:application]
    	    	}else{
    	    		model:[roleHeader:roleHeader,actionList:actionList,clarification:clarification,inspection:inspection,applicationDetails:applicationDetails,fwdRoleList:fwdRoleList,app:app,approve:approve,reject:reject,inspectionClose:inspectionClose,applicationProcessingDetailsInstance:null,prepareCertificate:prepareCertificate,appIdStr:appIdStr,appFor:appFor,isRenew:isRenew,appId:appId,viewCert:viewCert,fileId:fileId,chk:chk, application:application,appl:application]
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

def processApp = {
	println("params inn waste processApp-----"+params)
    	 try {
    	    def redirectBack = false
    	    	def applicationPending = WasteManagementPendingDetails.get((params.appId).toLong())
    	    	def appFor=applicationPending.applicationFor
    	    	def appIdStr=applicationPending.applicationId
    	    	def appId=(applicationPending.applicationId).toLong()
    	    	def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=?",[appId,appFor])
    	    	def application
    	    	def indRegInstance
    	    	def conFeeInst
    	    	
    	    	Response resPush= new Response();
				String consentAppNo=applicationPending.applicationId
				String cafNo=""
				String serviceId=""
				String applicationty=appFor
				String applicationFr=""
				String appRemarks=""
				String statusCode=""
				String pendingWith=""
				String pendingRoleName=""
				String applicationRemarks=""
				String certificateUrl=""
				String printAppUrl=""
				String revertedUrl=""
				//String printAppUrl="https://jkocmms.nic.in/indApplicationDetails/downloadApplicationForm/"+consentAppNo
			//	String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+indAppInstance.indUser.indName+"&indDistrict="+indAppInstance.indUser.district.districtName+"&serviceCode="+indAppInstance.serviceId+"&cafUniqueNo="+indAppInstance.cafUniqueNo
						
    	    	if(appFor=="HWM"){
    	    		application=HazardeousWasteAuthApp.get(appId)
    	    		indRegInstance=application.industryRegMasterObj
    	    		conFeeInst = ConsentFeeMasterHWM.find("from ConsentFeeMasterHWM where application.id=? order by id desc",[appId])	
    	    		println("conFeeInst for HWM:"+conFeeInst)
    	    		cafNo=application.cafUniqueNo // for Single Window
    			    serviceId=application.serviceId
    			    printAppUrl="https://jkocmms.nic.in/hazardeousWasteAuthApp/viewBmwPdf/"+consentAppNo
    			    revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+application.industryRegMasterObj.indName+"&indDistrict="+application.industryRegMasterObj.district.districtName+"&serviceCode="+application.serviceId+"&cafUniqueNo="+application.cafUniqueNo
    	    		
    	    	}else if(appFor=="MSW"){
    	    		application=MunicipalSolidWaste.get(appId)
    	    		indRegInstance=application.indRegMasterObj
    	    		//conFeeInst = ConsentFeeMasterMSW.find("from ConsentFeeMasterMSW where application.id=? order by id desc",[appId])
    	    		cafNo=application.cafUniqueNo // for Single Window
    			    serviceId=application.serviceId
    			    printAppUrl="https://jkocmms.nic.in/municipalSolidWaste/viewMswPdf/"+consentAppNo
    			    revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+application.industryRegMasterObj.indName+"&indDistrict="+application.industryRegMasterObj.district.districtName+"&serviceCode="+application.serviceId+"&cafUniqueNo="+application.cafUniqueNo
    	    	}else if(appFor=='BMW'){
    	    		application=BioMedicalWaste.get(appId)
    	    		indRegInstance=application.industryRegMasterObj
    	    		conFeeInst = ConsentFeeMasterBMW.find("from ConsentFeeMasterBMW where application.id=? order by id desc",[appId])    				
    				cafNo=application.cafUniqueNo // for Single Window
    			    serviceId=application.serviceId
    			    printAppUrl="https://jkocmms.nic.in/bioMedicalWaste/viewBmwPdf/"+consentAppNo
    			    revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+application.industryRegMasterObj.indName+"&indDistrict="+application.industryRegMasterObj.district.districtName+"&serviceCode="+application.serviceId+"&cafUniqueNo="+application.cafUniqueNo
    	    	} else{
    	    		application=PlasticWaste.get(appId)
    	    		indRegInstance=application.industryRegMasterObj
    	    	//	conFeeInst = ConsentFeeMasterPWM.find("from ConsentFeeMasterPWM where application.id=? order by id desc",[appId])
    	    		cafNo=application.cafUniqueNo // for Single Window
    			    serviceId=application.serviceId
    			    printAppUrl="https://jkocmms.nic.in/plasticWaste/viewMswPdf2/"+consentAppNo
    			    revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+application.industryRegMasterObj.indName+"&indDistrict="+application.industryRegMasterObj.district.districtName+"&serviceCode="+application.serviceId+"&cafUniqueNo="+application.cafUniqueNo
    	    	}
    	    def rVa = RoleVsActivity.findWhere(role:applicationPending.role, activity:RoleActivityMaster.findByActivityCode("001")) 
    	    	if(rVa){
    	    		def list = WasteManagementPendingDetails.findAllByApplicationId(applicationPending.applicationId)
    	    		for(int i=0;i<list.size();i++){
    	    			if(list.get(i)!=applicationPending){
    	    				(list.get(i)).delete()
    	    			}
    	    		}
    	    	}
    	   
    	        def roleFwd = RoleMaster.get((params.forward).toLong())
    	    	def applicationProcessingDetails = new WasteManagementProcessingDetails()
    	    	applicationProcessingDetails.role = applicationPending.role
    	    	def user = session.userMaster
    	    	user.refresh()
    	    	applicationProcessingDetails.officer = user.userProfile.id
    	    	applicationProcessingDetails.fileNote = params.fileNote
    	    	applicationProcessingDetails.roleFwd = roleFwd
    	    	applicationProcessingDetails.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
    	    	////////////////////Start///////////////Vivek///////////////////////////
    	    	if(params.attachLetter){
    	    	//attaching Clarification report
    	    	def noteHistiryFile11 = new WasteManagementFile()	
    	        	def f11 = request.getFile('attachLetter')
    	        	MultipartFile multi11 = request.getFile('attachLetter')
    	        	if(!f11.empty) {
    	        		
    	        		applicationProcessingDetails.attachedFile=true
    	        		 def applicationFileRecordInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachLetter' order by wmf.id desc",[appId,appFor],[max:1])
    	        		 if(applicationFileRecordInstance){
    	        			 noteHistiryFile11.version =applicationFileRecordInstance[0].version+1
    	        		 }
    	        		 	noteHistiryFile11.size = multi11.getSize() / 1024
    	        		 	if(noteHistiryFile11.size<=6000){
    	        		 	noteHistiryFile11.name =multi11.getOriginalFilename()
    	        			noteHistiryFile11.data=multi11.getBytes() 
    	        	        noteHistiryFile11.extension = extractExtension( multi11 )
    	        		    noteHistiryFile11.description="Attach other file if any"
    	        		 	if(session.userMaster){
    	        		 		noteHistiryFile11.createdBy=session.userMaster
    	        		 		noteHistiryFile11.updatedBy=session.userMaster
    	        		 	}else {
    	        		 		noteHistiryFile11.createdBy=session.indUser
    	        		 		noteHistiryFile11.updatedBy=session.indUser
    	        		 	  }
    	        		    noteHistiryFile11.typeOfFile="attachLetter"
    	        		    noteHistiryFile11.applicationId=appId
    	        		    noteHistiryFile11.applicationFor=appFor 
    	        		    
    	        		    if(appFor=="HWM"){
    	        		    	 noteHistiryFile11.indreg=application.industryRegMasterObj
    	        	    	}else if(appFor=="MSW"){
    	        	    		 noteHistiryFile11.indreg=application.indRegMasterObj
    	        	    	}else if(appFor=='BMW'){
    	        	    		 noteHistiryFile11.indreg=application.industryRegMasterObj
    	        	    	} else{
    	        	    		noteHistiryFile11.indreg=application.industryRegMasterObj
    	        	    	}
    	        		   
    	        		    if(noteHistiryFile11.save()) {
    	        		    	} else {
    	        		    	  redirect(action:'appProcessing',params:["id":indApp.id])
    	        		          }
    	        	}
    				else {
    					flash.message = "Attachment File Size is More Then 5 Mb"
    				    redirectBack = true
    				}
    	        	}
    	    	}else{
        	    		
        	    	}
        	        //close upload	
    	        if((params.clarification).equals("yes")){
    	    		 
    	    		if(application.clarification){
    	    			flash.message = "Clarification already Raised on this application"
    	    			redirectBack = true
    	    		}else{
    	    			application.clarification = true
    	    			application.save()
    	        		applicationProcessingDetails.clarification = true
    	        		applicationProcessingDetails.clarificationNote = params.clarificationNote
    	        	def noteHistiryFile1 = new WasteManagementFile()	
    	        	def f = request.getFile('attachClarificationReport')
    	        	MultipartFile multi = request.getFile('attachClarificationReport')
    	        	if(!f.empty) {
    	        		 applicationProcessingDetails.clarificationAttachedFile = true
    	        		 def applicationFileRecordInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedClarificationReport' order by wmf.id desc",[appId,appFor],[max:1])
    	        		if(applicationFileRecordInstance){
    	        			noteHistiryFile1.version =applicationFileRecordInstance[0].version+1
    	        		 }
    	        		 	noteHistiryFile1.size = multi.getSize() / 1024
    	        		 	if(noteHistiryFile1.size<=6000){
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
    	        		    noteHistiryFile1.applicationId=appId
    	        		    noteHistiryFile1.applicationFor=appFor 
    	        		     if(appFor=="HWM"){
    	        		    	 noteHistiryFile1.indreg=application.industryRegMasterObj
    	        	    	}else if(appFor=="MSW"){
    	        	    		 noteHistiryFile1.indreg=application.indRegMasterObj
    	        	    	}else{
    	        	    		 noteHistiryFile1.indreg=application.industryRegMasterObj
    	        	    	} 
    	        		   
    	        		    if(noteHistiryFile1.save()) {
    	        		     } else {
    	        		    	  redirect(action:'appProcessing',params:["id":indApp.id])
    	        		          }
    	        	}
    				else {
    					flash.message = "Attachment File Size is More Then 5 Mb"
    				    redirectBack = true
    				}
    	        	}
    		}
    	    	}else{
    	    		applicationProcessingDetails.clarification = false
    	    		applicationProcessingDetails.clarificationNote = ""
    	    	}
    	    	if((params.inspection).equals("yes")){ 
    	    		if(application.inspection){
    	    			flash.message = "Inspection already Raised on this application"
    	        		redirectBack = true
    	    		}else{
    	    			application.inspection = true
    	    			application.save()
    	        		applicationProcessingDetails.inspection = true
    	        		applicationProcessingDetails.inspectionNote = params.inspectionNote
    	        		def noteHistiryFile2 = new WasteManagementFile()	
    	            	def f = request.getFile('attachInspectionReport')
    	            	MultipartFile multi = request.getFile('attachInspectionReport')
    	            	if(!f.empty) {
    	            		applicationProcessingDetails.inspectionAttachedFile = true
    	            		 def applicationFileRecordInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedInspectionReport' order by wmf.id desc",[appId,appFor],[max:1])
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
    	            		    	noteHistiryFile2.applicationId=appId  
    	            		    	noteHistiryFile2.applicationFor=appFor 
    	                		    
    	                		    if(appFor=="HWM"){
    	                		    	noteHistiryFile2.indreg=application.industryRegMasterObj
    	                	    	}else if(appFor=="MSW"){
    	                	    		noteHistiryFile2.indreg=application.indRegMasterObj
    	                	    	}else{
    	                	    		noteHistiryFile2.indreg=application.industryRegMasterObj
    	                	    	} 
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
    	            }
    	    	}else{
    	    		applicationProcessingDetails.inspection = false
    	    		applicationProcessingDetails.inspectionNote = ""
    	    	}
    	    	if((params.inspectionClose).equals("yes")){ 
    	    		def noteHistiryFile=new WasteManagementFile()	
    	    		if(appFor=="BMW"){
    	    			def masterReportBMW=WasteManagementFile.findAll("from WasteManagementFile afr where afr.applicationId=? and afr.typeOfFile='Master Report BMW' order by afr.id desc",[application.id])
    					println("hello.."+masterReportBMW)
    					if(!application.inspection){
    						flash.message = "Inspection not Raised on this application"
    						redirect(action:'appProcessing',params:["id":applicationPending.id])
    					}else if(!masterReportBMW){
    						flash.message = "Please first Prepare Industry Master Data and Then Generate Inspection Report"
    							redirect(action:'appProcessing',params:["id":applicationPending.id])
    							return
    					}
    					else{
    						masterReportBMW=WasteManagementFile.findAll("from WasteManagementFile afr where afr.applicationId=? and afr.typeOfFile='Inspection Report BMW' order by afr.id desc",[application.id])
    						if(!masterReportBMW){
    							flash.message = "Please generate Inspection Report"
        							redirect(action:'appProcessing',params:["id":applicationPending.id])
        							return
    						}
    						else if(masterReportBMW){
    							applicationProcessingDetails.inspectionClose=true
    							applicationProcessingDetails.inspectionCloseAttachedFile=true
    						}
    						else 
    						{
    							applicationProcessingDetails.inspectionClose=false	
    						}
    					  application.inspection = false
      	           		  application.save()
      	        		applicationProcessingDetails.inspectionCloseNote = params.inspectionCloseNote
    					}
    	    		}else if(appFor=="HWM"){
    	    			if(!application.inspection){
    						flash.message = "Inspection not Raised on this application"
    						redirect(action:'appProcessing',params:["id":applicationPending.id])
    					}else{
    						def masterReportHWM=WasteManagementFile.findAll("from WasteManagementFile afr where afr.applicationId=? and afr.typeOfFile='Inspection Report HWM' order by afr.id desc",[application.id])
    						if(!masterReportHWM){
    							flash.message = "Please generate Inspection Report"
        							redirect(action:'appProcessing',params:["id":applicationPending.id])
        							return
    						}
    						else if(masterReportHWM){
    							applicationProcessingDetails.inspectionClose=true
    							applicationProcessingDetails.inspectionCloseAttachedFile=true
    						}
    						else 
    						{
    							applicationProcessingDetails.inspectionClose=false	
    						}
    					  application.inspection = false
      	           		  application.save()
      	        		applicationProcessingDetails.inspectionCloseNote = params.inspectionCloseNote	
    	    		}
    	    		}	else{
    	    		
    	    		if(!application.inspection){
    	    			flash.message = "Inspection not Raised on this application"
    	        			redirect(action:'appProcessing',params:["id":applicationPending.id])
    	    		}else{
    	    		def f = request.getFile('inspectionReport')
    	        	MultipartFile multi = request.getFile('inspectionReport')
    	        	if(!f.empty) {
    	        		applicationProcessingDetails.inspectionCloseAttachedFile =true
    	        		 def applicationFileRecordInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='inspectionReport' order by wmf.id desc",[appId,appFor],[max:1])
    	        		 if(applicationFileRecordInstance){
    	        			 noteHistiryFile.version =applicationFileRecordInstance[0].version+1
    	        		 }
    	        		 noteHistiryFile.size = multi.getSize() / 1024
    	        		 if(noteHistiryFile.size<=6000){
    	        		 noteHistiryFile.name =multi.getOriginalFilename()
    	        			 noteHistiryFile.data=multi.getBytes() 
    	        	        noteHistiryFile.extension = extractExtension( multi )
    	        		    noteHistiryFile.description="Application Inspection Report File"
    	        		 	if(session.userMaster){
    	        		 		noteHistiryFile.createdBy=session.userMaster
    	        		 		noteHistiryFile.updatedBy=session.userMaster
    	        		 	}else {
    	        		 		noteHistiryFile.createdBy=session.indUser
    	        		 		noteHistiryFile.updatedBy=session.indUser
    	        		 	  }
    	        	        noteHistiryFile.typeOfFile="inspectionReport"
    	        		    	noteHistiryFile.applicationId=appId 
    	        		    	noteHistiryFile.applicationFor=appFor 
    	            		    
    	            		    if(appFor=="HWM"){
    	            		    	noteHistiryFile.indreg=application.industryRegMasterObj
    	            	    	}else if(appFor=="MSW"){
    	            	    		noteHistiryFile.indreg=application.indRegMasterObj
    	            	    	}else{
    	            	    		noteHistiryFile.indreg=application.industryRegMasterObj
    	            	    	} 
    	        		    	if(noteHistiryFile.save()) {
    	        		    	 } else {
    	        		    	  redirect(action:'appProcessing',params:["id":indApp.id])
    	        		          }
    	        		 }}
    	     			else {
    	     				flash.message = "Attachment File Size is More Then 5 Mb"
    	     			    redirectBack = true
    	     			}
    	        	}
    	         application.inspection = false
    	           		application.save()
    	        		applicationProcessingDetails.inspectionClose = true
    	        		applicationProcessingDetails.inspectionCloseNote = params.inspectionCloseNote
    	    		}
    	    	}	
    	    	else{
    	    		applicationProcessingDetails.inspectionClose = false
    	    		applicationProcessingDetails.inspectionCloseNote = ""
    	    	}
    	    	if((params.inspectionBMW).equals("yes")){
    	    		
    	    	}
    	    	if((params.approve).equals("yes")){
    	    		if(application.inspection){
    	    			flash.message = "Sorry can not Approve Inspection is Raised on this application"
    	        		redirectBack = true
    	    		}else if(application.clarification){
    	    			flash.message = "Sorry can not Approve Clarification is Raised on this application"
    	            	redirectBack = true
    	    		}else if(!checkCertificate){
    	    			flash.message = "Please Generate Certificate first."
    	        			redirectBack = true
    	    		}
    	    	else {
    	    			applicationPending.applicationStatus = "approved"
    		    		applicationPending.save()
    		    		application.applicationStatus = "approved"
    		    			application.save()
    		    		applicationProcessingDetails.approve = true
    		    		applicationProcessingDetails.approveNote = params.approveNote
    		    		
    		    	        statusCode="A"
							appRemarks="Application approved.Certificate has been issued"
						if((application.cafUniqueNo!=null) && (application.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingRoleName=applicationPending.role.roleName
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
							resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.approve = false
    	    		applicationProcessingDetails.approveNote = ""
    	    	}
    	    	
    	    	
    	    	if((params.reject).equals("yes")){ 
    	    		applicationPending.applicationStatus = "rejected"
    	        	applicationPending.save()
    	        	application.applicationStatus = "rejected"
    		    	application.save()
    	    		applicationProcessingDetails.reject = true
    	    		applicationProcessingDetails.rejectNote = params.rejectNote
    	    		
    	                statusCode="R"
						appRemarks="Application rejected."
					if((application.cafUniqueNo!=null) && (application.cafUniqueNo!="")){
						if(roleFwd.id ==(applicationPending.role.id))
						{
						pendingRoleName=applicationPending.role.roleName
						pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
					resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
					}
					}
    	    	}else{
    	    		applicationProcessingDetails.reject = false
    	    		applicationProcessingDetails.rejectNote = ""
    	    	}
    	    	//------------return code---------------//
    	    	if((params.returned).equals("yes")){
    	    		def approval = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails apd where apd.applicationId=? and apd.approvalStatus <> '' order by apd.id desc",[String.valueOf(application.id)])
    	    		if(approval){
    	    		if(approval.approvalStatus=='Approved'){
						flash.message = "Sorry this Application is approved by higher authority you cannot return this application"
							redirectBack = true
						}
					else if(approval.approvalStatus=='Refused'){
						flash.message = "Sorry this Application is refused by higher authority you cannot return this application"
							redirectBack = true
						}
    	    		}
    	    		def appIdReturn = (application.id).toString()
    	    		def applicationSubmitDate;
						//def appDateNew = indApp.applicationDate;
						//Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						//applicationSubmitDate= formatter3.format(appDateNew)
    				def oMobNoReturn;
    				def emailIdReturn;
    			    def occName;
    				if(appFor=="HWM"){
    					oMobNoReturn=application.industryRegMasterObj.occMobile;
    					emailIdReturn = application.industryRegMasterObj.occEmail
    					def appDateNew = application.dateCreated
    					Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						applicationSubmitDate= formatter3.format(appDateNew)
						occName=application.industryRegMasterObj.occName
    				}else if (appFor=="BMW")
    				{
    					oMobNoReturn=application.industryRegMasterObj.occMobile;
    					emailIdReturn = application.industryRegMasterObj.occEmail
    					def appDateNew = application.dateCreated
    					Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						applicationSubmitDate= formatter3.format(appDateNew)
						occName=application.industryRegMasterObj.occName
    				}else if(appFor=='PWM'){
    					oMobNoReturn=application.industryRegMasterObj.occMobile;
    					emailIdReturn = application.industryRegMasterObj.occEmail
    					def appDateNew = application.dateCreated
    					Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
						applicationSubmitDate= formatter3.format(appDateNew)
						occName=application.industryRegMasterObj.occName
    				}
    	    		applicationPending.applicationStatus = "returned"
    	        	applicationPending.save()
    	        	application.applicationStatus = "returned"
    		    	application.save()
    	    		applicationProcessingDetails.returned = true
    	    		applicationProcessingDetails.returnNote = params.returnNote
    	    		if(emailIdReturn!=null && emailIdReturn!="")
    	    		{
						SendMail mail = new SendMail()
						mail.sendReturned(appIdReturn,emailIdReturn,appFor,occName,applicationSubmitDate)
					}
    	    		
    	    		println("Returned Mail has been Sent to industry ")
			      SendSms sms = new SendSms()
			//	sms.sendReturned(appIdReturn,oMobNoReturn,appFor)
					println("Returned SMS has been Sent to industry ")
    	    	}
    	    	else{
    	    		applicationProcessingDetails.returned = false
    	    		applicationProcessingDetails.returnNote = ""
    	    	}
    	    	//---------------end-----------------------------//
    	    	
    	    	def scrutiny = params.scrutiny
    			
    			if(scrutiny=="" || scrutiny==null)
    			{
    				applicationProcessingDetails.scrutinyStatus=""
    			
    			}
    			else
    			{
    				applicationProcessingDetails.scrutinyStatus=scrutiny
    			}
    	    	if(redirectBack){
    	    		println("-in redirectBack--")
    	    		redirect(action:'appProcessing',params:["id":applicationPending.id])
    	    	}else{
    	    		println("-else redirectBack--")
    	    		applicationProcessingDetails.applicationId = applicationPending.applicationId
    	    		applicationProcessingDetails.applicationFor = applicationPending.applicationFor
    	    		applicationProcessingDetails.scrutinyDescription = ""
    	    			
    	   //        Scrutiny code Start by Deepak Here 
    	   
    	   
    	    		if(scrutiny.equals("Complete"))
        				{
        				println("AAAAAAAAAAAAAA SCRUTINYS "+scrutiny)
        				println("params.totalFee*********"+params.totalFee)
        				applicationPending.scrutinyStatus=scrutiny
        				//applicationPending.completionDate=new Date()
        				applicationPending.completionStatus="Completed"
        				applicationProcessingDetails.scrutinyDescription = ""
        				
        					if(params.fileNote==null)
        					{
        						applicationProcessingDetails.fileNote = "";
        					}else
        					{
        						applicationProcessingDetails.fileNote=params.fileNote 
        					}
        				
        				
        				
    					if(conFeeInst){
    				
    					if(params.lateFee1){	
    						conFeeInst.lateFees = (params.lateFee1).toFloat()
    					}
    					
    					if(params.addFee){	
    						conFeeInst.addFees = (params.addFee).toFloat()
    					}
    					
    					/*if(params.totalFee){	
    						conFeeInst.totalFees = (params.totalFee).toFloat()
    					}*/
    					
    					if(params.totalFee!=null && params.totalFee!="" && params.totalFee!="0" && params.totalFee!="0.00"){
							conFeeInst.totalFees = (params.totalFee).toFloat()
							println("conFeeInst.totalFees:111---"+conFeeInst.totalFees)
							
							def test2 = (params.totalFee).toFloat()
							println("test2"+test2)
							}else{
								applicationPending.completionStatus=""
								applicationPending.scrutinyStatus=""
								println("totalFee is null")
								flash.message = "TotalFee cant not be Zero "
									//redirect(action:appProcessing,id:params.indAppDetId,radio:"other");
								redirect(action:'appProcessing',params:["id":applicationPending.id])
								     return
									
							}
    					
    					if(params.feeApplicable){	
    						conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
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
    					}else{
    						
    						if(appFor=="HWM"){
    						conFeeInst = new ConsentFeeMasterHWM()
    						
    						conFeeInst.application = application
    						
    						if(params.lateFee1){	
    							conFeeInst.lateFees = (params.lateFee1).toFloat()
    						}
    						
    						if(params.addFee){	
    							conFeeInst.addFees = (params.addFee).toFloat()
    						}
    						
    						/*if(params.totalFee){	
    							conFeeInst.totalFees = (params.totalFee).toFloat()
    						}*/
    						
    						if(params.totalFee!=null && params.totalFee!="" && params.totalFee!="0" && params.totalFee!="0.00"){
    							conFeeInst.totalFees = (params.totalFee).toFloat()
    							println("conFeeInst.totalFees:PWM--"+conFeeInst.totalFees)
    							
    							def test2 = (params.totalFee).toFloat()
    							println("test2"+test2)
    							}else{
    								applicationPending.completionStatus=""
    								applicationPending.scrutinyStatus=""
    								println("totalFee is null")
    								flash.message = "TotalFee cant not be Zero "
    									//redirect(action:appProcessing,id:params.indAppDetId,radio:"other");
    								redirect(action:'appProcessing',params:["id":applicationPending.id])
    								     return
    									
    							}
    						
    						if(params.feeApplicable){	
    							conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    						}
    						
    							conFeeInst.noOfYears = 0
    							
    							if(conFeeInst.save(flush:true)){
    								println("conFeeInst.save()----"+conFeeInst)
    							}
    							else{
    								println("conFeeInst not save()----")
    								conFeeInst.errors.each {
    			            			        println it
    			            			   }
    							}
    							
    						}else if(appFor=="BMW"){
    							conFeeInst = new ConsentFeeMasterBMW()
    							
    							conFeeInst.application = application
    							
    							if(params.lateFee1){	
    								conFeeInst.lateFees = (params.lateFee1).toFloat()
    							}
    							
    							if(params.addFee){	
    								conFeeInst.addFees = (params.addFee).toFloat()
    							}
    							
    							/*if(params.totalFee){	
    								conFeeInst.totalFees = (params.totalFee).toFloat()
    							}*/
    							
    							if(params.totalFee!=null && params.totalFee!="" && params.totalFee!="0"  && params.totalFee!="0.00"){
        							conFeeInst.totalFees = (params.totalFee).toFloat()
        							println("conFeeInst.totalFees:BMW--"+conFeeInst.totalFees)
        							
        							def test2 = (params.totalFee).toFloat()
        							println("test2"+test2)
        							}else{
        								applicationPending.completionStatus=""
        								applicationPending.scrutinyStatus=""
        								println("totalFee is null")
        								flash.message = "TotalFee cant not be Zero "
        									//redirect(action:appProcessing,id:params.indAppDetId,radio:"other");
        								redirect(action:'appProcessing',params:["id":applicationPending.id])
        								     return
        									
        							}
    							
    							if(params.feeApplicable){	
    								conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    							}
    							
    								conFeeInst.noOfYears = 0
    								
    								if(conFeeInst.save(flush:true)){
    									println("conFeeInst.save()----")
    								}
    								else{
    									println("conFeeInst not save()----")
    									conFeeInst.errors.each {
    				            			        println it
    				            			   }
    								}
    								
    							}else if(appFor=="PWM"){
    								conFeeInst = new ConsentFeeMasterPWM()
    								
    								conFeeInst.application = application
    								
    								if(params.lateFee1){	
    									conFeeInst.lateFees = (params.lateFee1).toFloat()
    								}
    								
    								if(params.addFee){	
    									conFeeInst.addFees = (params.addFee).toFloat()
    								}
    								
    							/*	if(params.totalFee){	
    									conFeeInst.totalFees = (params.totalFee).toFloat()
    								}*/
    								
    								if(params.totalFee!=null && params.totalFee!="" && params.totalFee!="0" && params.totalFee!="0.00"){
            							conFeeInst.totalFees = (params.totalFee).toFloat()
            							println("conFeeInst.totalFees:PMW--"+conFeeInst.totalFees)
            							
            							def test2 = (params.totalFee).toFloat()
            							println("test2"+test2)
            							}else{
            								applicationPending.completionStatus=""
            								applicationPending.scrutinyStatus=""
            								println("totalFee is null")
            								flash.message = "TotalFee cant not be Zero "
            									//redirect(action:appProcessing,id:params.indAppDetId,radio:"other");
            								redirect(action:'appProcessing',params:["id":applicationPending.id])
            								     return
            									
            							}
    								
    								if(params.feeApplicable){	
    									conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    								}
    								
    									conFeeInst.noOfYears = 0
    									
    									if(conFeeInst.save(flush:true)){
    										println("conFeeInst.save()----")
    									}
    									else{
    										println("conFeeInst not save()----")
    										conFeeInst.errors.each {
    					            			        println it
    					            			   }
    									}
    									
    								}/*else if(appFor=="MSW"){
    									conFeeInst = new ConsentFeeMasterMSW()
    									
    									conFeeInst.application = application
    									
    									if(params.lateFee1){	
    										conFeeInst.lateFees = (params.lateFee1).toFloat()
    									}
    									
    									if(params.addFee){	
    										conFeeInst.addFees = (params.addFee).toFloat()
    									}
    									
    									if(params.totalFee){	
    										conFeeInst.totalFees = (params.totalFee).toFloat()
    									}
    									
    									if(params.feeApplicable){	
    										conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    									}
    									
    										conFeeInst.noOfYears = 0
    										
    										if(conFeeInst.save(flush:true)){
    											println("conFeeInst.save()----")
    										}
    										else{
    											println("conFeeInst not save()----")
    											conFeeInst.errors.each {
    						            			        println it
    						            			   }
    										}
    										
    									}else if(appFor=="EWaste"){
    										conFeeInst = new ConsentFeeMasterEWASTE()
    										
    										conFeeInst.application = application
    										
    										if(params.lateFee1){	
    											conFeeInst.lateFees = (params.lateFee1).toFloat()
    										}
    										
    										if(params.addFee){	
    											conFeeInst.addFees = (params.addFee).toFloat()
    										}
    										
    										if(params.totalFee){	
    											conFeeInst.totalFees = (params.totalFee).toFloat()
    										}
    										
    										if(params.feeApplicable){	
    											conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    										}
    										
    											conFeeInst.noOfYears = 0
    											
    											if(conFeeInst.save(flush:true)){
    												println("conFeeInst.save()----")
    											}
    											else{
    												println("conFeeInst not save()----")
    												conFeeInst.errors.each {
    							            			        println it
    							            			   }
    											}
    											
    										}else if(appFor=="BATTERY"){
    											conFeeInst = new BatteryFeeMaster()
    											
    											conFeeInst.application = application
    											
    											if(params.lateFee1){	
    												conFeeInst.lateFees = (params.lateFee1).toFloat()
    											}
    											
    											if(params.addFee){	
    												conFeeInst.addFees = (params.addFee).toFloat()
    											}
    											
    											if(params.totalFee){	
    												conFeeInst.totalFees = (params.totalFee).toFloat()
    											}
    											
    											if(params.feeApplicable){	
    												conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    											}
    											
    												conFeeInst.noOfYears = 0
    												
    												if(conFeeInst.save(flush:true)){
    													println("conFeeInst.save()----")
    												}
    												else{
    													println("conFeeInst not save()----")
    													conFeeInst.errors.each {
    								            			        println it
    								            			   }
    												}
    												
    											}else if(appFor=="Construction and Demolition"){
    												conFeeInst = new ConsentFeeMasterConsDemoli()
    												
    												conFeeInst.application = application
    												
    												if(params.lateFee1){	
    													conFeeInst.lateFees = (params.lateFee1).toFloat()
    												}
    												
    												if(params.addFee){	
    													conFeeInst.addFees = (params.addFee).toFloat()
    												}
    												
    												if(params.totalFee){	
    													conFeeInst.totalFees = (params.totalFee).toFloat()
    												}
    												
    												if(params.feeApplicable){	
    													conFeeInst.calculatedFee = (params.feeApplicable).toFloat()
    												}
    												
    													conFeeInst.noOfYears = 0
    													
    													if(conFeeInst.save(flush:true)){
    														println("conFeeInst.save()----")
    													}
    													else{
    														println("conFeeInst not save()----")
    														conFeeInst.errors.each {
    									            			        println it
    									            			   }
    													}
    													
    												}*/
    					}
        				
    				         statusCode="Payment"
							appRemarks="Request for Payment"
						if((application.cafUniqueNo!=null) && (application.cafUniqueNo!="")){
							if(roleFwd.id ==(applicationPending.role.id))
							{
							pendingRoleName=applicationPending.role.roleName
							pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
						resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
						}
						}
        		}
    	    		
    	    		if(scrutiny.equals("In-Complete"))
    				{
    	    			println("-Inside scrutiny Complete--")
    	    			
    					def noteHistiryFile=new WasteManagementFile()		
    						
    						
    					
    						def f = request.getFile('attachScrutinyReport')
    						MultipartFile multi = request.getFile('attachScrutinyReport')
    						if(!f.empty) {
    							
    			        		 def applicationFileRecordInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='scrutinyReport' order by wmf.id desc",[appId,appFor],[max:1])
    							if(applicationFileRecordInstance){
    								noteHistiryFile.version =applicationFileRecordInstance[0].version+1
    							}
    			        		 noteHistiryFile.size = multi.getSize() / 1024
    							if(noteHistiryFile.size<=6000){
    							noteHistiryFile.name =multi.getOriginalFilename()
    							noteHistiryFile.data=multi.getBytes() 
    							noteHistiryFile.extension = extractExtension( multi )
    							noteHistiryFile.description="Scrutiny Report"
    								noteHistiryFile.applicationId=appId
    									noteHistiryFile.applicationFor=appFor
    									
    							if(session.userMaster){
    								noteHistiryFile.createdBy=session.userMaster
    								noteHistiryFile.updatedBy=session.userMaster
    							}else {
    								noteHistiryFile.createdBy=session.indUser
    								noteHistiryFile.updatedBy=session.indUser
    							}
    							
    							
    							noteHistiryFile.typeOfFile="scrutinyReport"
    							noteHistiryFile.indreg=indRegInstance  
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
    						
    						
    						
    						
    						applicationProcessingDetails.scrutinyDescription = params.scrutinyDescription
    						
    						if(params.fileNote==null)
    						{
    							applicationProcessingDetails.fileNote = "";
    						}else
    						{
    							applicationProcessingDetails.fileNote=params.fileNote 
    						}
    						applicationProcessingDetails.clarification = false
    						applicationProcessingDetails.clarificationNote = " "
    						applicationProcessingDetails.inspection = false
    						applicationProcessingDetails.inspectionNote = " "
    						applicationProcessingDetails.inspectionClose = false
    						application.inspection = false
    						if(appFor=="BATTERY"){
    							
    						}else{
    							application.applicationStatus = "rejected"
    						}
    						

    						application.clarification = false
    						applicationProcessingDetails.inspectionCloseNote = " "
    					    applicationProcessingDetails.reject = true
    					
    					    applicationPending.applicationStatus = "rejected"
    							applicationPending.scrutinyStatus=scrutiny
    							applicationPending.lastUpdated=new Date()
    							applicationPending.completionStatus=scrutiny
    							application.save()
    							
    						/*	if(appFor=="HWM" || appFor=="PWM" || appFor=="EWaste" ){
    							if(application.singleWindow){
    								println("inside single windows")
    								statusCode = "P"
    								def pendWith = WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId= ? order by id desc",[(application.id).toString()])
    								pendingWith = (pendWith.pendingWith).toString()
    								remarks = "Scrutiny In-Complete"
    								printAppURL = ("https://wbocmms.nic.in/plasticWaste/viewMswPdf?appliLoc="+applicationId).toString()+("https://wbocmms.nic.in/plasticWaste/viewMswPdf3?appliLoc="+applicationId).toString()+("https://wbocmms.nic.in/plasticWaste/viewMswPdf2?appliLoc="+applicationId).toString()
    								Response res= new Response();
    								res.sendSingleWindowDetail(applicationId, indName, indAddress, indDistrict, serviceId, cafNo, statusCode, printAppURL, downCertURL, remarks, pendingWith);
    			               	}
    							}*/
    				}
    	    		
    	        	if( applicationProcessingDetails.save(flush:true) ) {
    	        		println("-wasteApp process save--"+applicationProcessingDetails)
    	        		}else{
    	        			println(" process save not save--")
    	        			applicationProcessingDetails.errors.each {
    	        				 println it
    	        		   }
    	        		}
    	    		applicationPending.role = roleFwd
    	        	applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
    	        	println("-wasteApp pending save--")
    	        	applicationPending.save()
    	        	
    	        	
    	        	
    	        	//------------------------------------------All Summary for Waste-----------------------------------------------------------------//
    	        		println("--appId--"+appId)
    	        			println("--appId--"+appId)
    	        	 def enable='false';
                    def pendingFlag='false';
                    def feeAmountId
                    def feeAmountId1
                    
    	           if(appFor=="HWM" ){
                        feeAmountId1 = BankTransactionDetailsHWM.find("from BankTransactionDetailsHWM abc where abc.indApplication.id = ? and abc.transactionStatus = 'S' ",[(appId).toLong()]);
                        feeAmountId = FeeBankDetailsHWM.find("from FeeBankDetailsHWM abc where abc.application.id = ?",[appId.toLong()])
                        if(feeAmountId || feeAmountId1)
        		    	{
        		    		enable='true';
        		    	}
                        }else if(appFor=="BMW"){
                        	println("--appId--BMW ----"+appId)
                            feeAmountId = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW abc where abc.bioApplication.id = ? and abc.transactionStatus = 'S' ",[(appId).toLong()])
                            feeAmountId1 = FeeBankDetailsBMW.find("from FeeBankDetailsBMW abc where abc.application.id = ?",[appId.toLong()])
                            if(feeAmountId || feeAmountId1)
            		    	{
            		    		enable='true';
            		    	}
                        }
                        	println(" enable--"+enable)
    	          	if(enable=="true" ){
    	        	 def allSummaryReportWMSInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(appId).toString()]);
                       def WasteMgmtPendDetInstance=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId = ? ",[(appId).toString()]);	
                       def aPDInstance=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and officer!=? and officerFwd=? order by dateCreated desc limit 1",[WasteMgmtPendDetInstance.applicationId,WasteMgmtPendDetInstance.pendingWith.id,WasteMgmtPendDetInstance.pendingWith.id]);
                       def roleFwd1=WasteMgmtPendDetInstance.role;
                       def role22=WasteMgmtPendDetInstance.pendingWith
                      println("--------allSummaryReportWMSInstance-------"+allSummaryReportWMSInstance)
                       println("--------WasteMgmtPendDetInstance-------"+WasteMgmtPendDetInstance)
                        println("-----aPDInstance----------"+aPDInstance)
                         println("-----roleFwd1----------"+roleFwd1)
                       SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
  	    	           String userInput = "01/01/1950";
  	    	           Date defaulDate = formatter1.parse(userInput);
  	    	           
                       if(!allSummaryReportWMSInstance)
       	    			{
                    	   println("--inside in-allSummaryReportWMSInstance---")
                    	   def indRegMasterInstance=WasteMgmtPendDetInstance.indRegInstance
                    	   allSummaryReportWMSInstance=new AllSummaryReportWMS();
                           allSummaryReportWMSInstance.applicationId=(WasteMgmtPendDetInstance.applicationId).toString()
                           allSummaryReportWMSInstance.indRegMasterId=(indRegMasterInstance.id).toString()
                           allSummaryReportWMSInstance.applicationName=indRegMasterInstance.indName
                           allSummaryReportWMSInstance.districtId=(indRegMasterInstance.district.id).toString()
                           allSummaryReportWMSInstance.districtName=indRegMasterInstance.district.districtName
                           allSummaryReportWMSInstance.roleId=(roleFwd.id).toString();
                           allSummaryReportWMSInstance.categoryName=indRegMasterInstance.category.name
                           allSummaryReportWMSInstance.roleName=roleFwd1.roleName;
                           allSummaryReportWMSInstance.groupId=(roleFwd1.group.id).toString()
                           allSummaryReportWMSInstance.groupName=roleFwd1.group.groupName
                           allSummaryReportWMSInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
                           allSummaryReportWMSInstance.applicationFor=WasteMgmtPendDetInstance.applicationFor
                           allSummaryReportWMSInstance.applicationStatus=WasteMgmtPendDetInstance.applicationStatus
                           allSummaryReportWMSInstance.recieptDate=WasteMgmtPendDetInstance.dateCreated;
                           allSummaryReportWMSInstance.authDate=WasteMgmtPendDetInstance.dateCreated;
                           allSummaryReportWMSInstance.industryTypeId=indRegMasterInstance.industryType.id.toString();
                           allSummaryReportWMSInstance.industryTypeName=indRegMasterInstance.industryType.industryType;
                           allSummaryReportWMSInstance.industryAddress=indRegMasterInstance.indAddress;
                           allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith.id
                           allSummaryReportWMSInstance.dateCreated=WasteMgmtPendDetInstance.dateCreated
                           allSummaryReportWMSInstance.scrutinyStatus=WasteMgmtPendDetInstance.scrutinyStatus;
                           allSummaryReportWMSInstance.indCapInvt=(indRegMasterInstance.indCapInvt).toString()
                           def ind_ins=IndUser.find("from IndUser where industryRegMaster=? order by dateCreated desc limit 1",[indRegMasterInstance]);
                           if(ind_ins)
                           allSummaryReportWMSInstance.indId=ind_ins.id
                           else
                           allSummaryReportWMSInstance.indId="";
                           allSummaryReportWMSInstance.clarificationDate=defaulDate;
                           allSummaryReportWMSInstance.refusedDate=defaulDate;
                           allSummaryReportWMSInstance.returnedDate=defaulDate;
                           allSummaryReportWMSInstance.dateOfIssue=defaulDate;
                           allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
                           if(aPDInstance)
                           allSummaryReportWMSInstance.pendingSince=aPDInstance.dateCreated
                           else
                           allSummaryReportWMSInstance.pendingSince=WasteMgmtPendDetInstance.dateCreated
                           allSummaryReportWMSInstance.pendingWith=((WasteMgmtPendDetInstance.pendingWith).toString()).trim()
                    	   if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true)) 
       	     		         {
                    		   println(" in-allSummaryReportWMSInstance-saved--"+allSummaryReportWMSInstance)
       	     		       }
       	     		           else {
       	     					allSummaryReportWMSInstance.errors.each {
       	     				        println it
       	     					}
       	     				}
                    	   
                    	}
       	    			else
       	    			{    
       	    			 println("--already have in-allSummaryReportWMSInstance---")
       	    				allSummaryReportWMSInstance.applicationStatus=WasteMgmtPendDetInstance.applicationStatus
       	    				if(allSummaryReportWMSInstance.roleId!=(roleFwd1.id).toString())
       	     				{
       	     					allSummaryReportWMSInstance.roleId=((roleFwd1.id).toString())
       	     					allSummaryReportWMSInstance.roleName=roleFwd1.roleName
                                allSummaryReportWMSInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee.employeeLastName
                                allSummaryReportWMSInstance.pendingSince=new Date();
                                //allSummaryReportWMSInstance.pendingWith=(WasteMgmtPendDetInstance.pendingWith).toString()
                                allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith.id
                            }
                        def clr_ins=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and clarification='t' order by dateCreated desc limit 1",[WasteMgmtPendDetInstance.applicationId]);
       					 if(clr_ins){
       							allSummaryReportWMSInstance.clarification=true;
       							allSummaryReportWMSInstance.clarificationType="";
       							allSummaryReportWMSInstance.clarificationDate=clr_ins.dateCreated;
       						  }
       					  else{
       								allSummaryReportWMSInstance.clarificationDate=defaulDate;
       				 }	
       				def refused_ins=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and approvalStatus!='' order by dateCreated desc limit 1",[WasteMgmtPendDetInstance.applicationId]);
       				def returned_ins=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where  applicationId=? order by dateCreated desc limit 1",[WasteMgmtPendDetInstance.applicationId]);
       				println("returned_ins---"+returned_ins)
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
       				if(returned_ins!=null ){
       				if(returned_ins.returned==true && returned_ins.resubmitStatus==false){
       					println("-returned_ins---"+returned_ins)
       						allSummaryReportWMSInstance.returned=true;
       						allSummaryReportWMSInstance.returnedDate=returned_ins.dateCreated;
       				}
       				else{
       					allSummaryReportWMSInstance.returned=false;
       					allSummaryReportWMSInstance.returnedDate=defaulDate;
       				}
       				}
       				if(WasteMgmtPendDetInstance.applicationStatus=='approved' && WasteMgmtPendDetInstance.applicationFor=='HWM'){
       					def record_ins=RecordCertificateHWM.find("from RecordCertificateHWM where application.id=?  order by id desc limit 1",[(WasteMgmtPendDetInstance.applicationId).toLong()]);
       					if(record_ins){
       						allSummaryReportWMSInstance.dateOfIssue=record_ins.issueDate;
       						allSummaryReportWMSInstance.dateOfExpaire=record_ins.expiryDate;
       					}else{
       						allSummaryReportWMSInstance.dateOfIssue=defaulDate;
       						allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
       					}
       					allSummaryReportWMSInstance.pendingSince=new Date();
       					
       					}
       				else if(WasteMgmtPendDetInstance.applicationStatus=='approved' && WasteMgmtPendDetInstance.applicationFor=='BMW'){
       					def record_ins=RecordCertificateBMW.find("from RecordCertificateBMW where application.id=?  order by id desc limit 1",[(WasteMgmtPendDetInstance.applicationId).toLong()]);
       					if(record_ins){
       						allSummaryReportWMSInstance.dateOfIssue=record_ins.issueDate;
       						allSummaryReportWMSInstance.dateOfExpaire=record_ins.expiryDate;
       					}else{
       						allSummaryReportWMSInstance.dateOfIssue=defaulDate;
       						allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
       					}
       					
       					allSummaryReportWMSInstance.pendingSince=new Date();
       					}
       				else{
       					allSummaryReportWMSInstance.dateOfIssue=defaulDate;
       					allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
       					}
       				if(WasteMgmtPendDetInstance.applicationStatus=='approved' && WasteMgmtPendDetInstance.applicationFor=='MSW'){
       				allSummaryReportWMSInstance.pendingSince=new Date();
       				}
       	     	   if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true)) 
       	     		{
       	     		}
       	     		else {
       	     					allSummaryReportWMSInstance.errors.each {
       	     				        println it
       	     					}
       	     				}
       	    			}
    	          	}
    	     //--------------------------------------------------------------------------------------------------------------------------------------//
    	     if(appFor=='PWM'){
    	    	 redirect(controller:'wasteManagementPendingDetails',action:'pendingList2')
    	     }else{
    	     redirect(controller:'wasteManagementPendingDetails',action:'pendingList')
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

def extractExtension( MultipartFile file ) {
    	 try {
    	    String filename = file.getOriginalFilename()
    	        return filename.substring(filename.lastIndexOf( "." ) + 1 )
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

def viewClarificationDocument={
    		 try {
    		  def appFor=params.appliFor
    	        	def appIdStr=params.appliLoc
    	        	def appId=(params.appliLoc).toLong()
    	        	def application
    	        	def type=params.docName
    	        	if(appFor=="HWM"){
    	        		application=HazardeousWasteAuthApp.get(appId)
    	        	}else if(appFor=="MSW"){
    	        		application=MunicipalSolidWaste.get(appId)
    	        	}else if(appFor=="PWM"){
    	        		println("--PWM Application--"+appFor)
    	        		application=PlasticWaste.get(appId)
    	        		println("--PWM Application--"+application)
    	        	}
    	        	else{
    	        		application=BioMedicalWaste.get(appId)
    	        	}
    	    		
    	    		def applicationFileInstance
    	    		if(appFor=='BMW'){
    	 	    	 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='Inspection Report BMW' order by wmf.id desc",[appId,appFor],[max:1])
    	    		}else if(appFor=='HWM'){
    	    			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='Inspection Report HWM' order by wmf.id desc",[appId,appFor],[max:1])
    	    		}else{
    	    		applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile=? order by wmf.id desc",[appId,appFor,type],[max:1])
    	    		}
    	 	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	 		   response.setContentType( "application-xdownload")
    	 		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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

def viewOtherAttachedDocument={
    		 try {
    		def appFor=params.appliFor
    	    		def appIdStr=params.appliLoc
    	        	def appId=(params.appliLoc).toLong()
    	        	def application
    	        	if(appFor=="HWM"){
    	        		application=HazardeousWasteAuthApp.get(appId)
    	        	}else if(appFor=="MSW"){
    	        		application=MunicipalSolidWaste.get(appId)
    	        	}else{
    	        		application=BioMedicalWaste.get(appId)
    	        	}
    	    		def type=params.docName
    	 	    	def applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachLetter' order by wmf.id desc",[appId,appFor],[max:1])
    	 	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	    		if(applicationFileSingleInstance==null){
    					flash.message = "File not Attached by SPCB Officer"
    					redirect(action:appProcessing,id:params.appId2)
    				}else{
    				 response.setContentType( "application-xdownload")
    	 		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
    
def viewOtherAttachedFile = {
    		 try {
    		   def fileVer=(params.verValue).toLong()
    	  	    	def applicatioFor=params.appForWhich
    	  	    	def appId=(params.appliLoc).toLong()
    	  	    	def applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachLetter' and wmf.version=? order by wmf.id desc",[appId,applicatioFor,fileVer],[max:1])
    	  	   if(!applicationFileInstance){
    	  	    		flash.message = "Document not uploaded correctly"
    	  	    			redirect(action:"openApplicationDetails", params:[appliId:appId,docName:applicatioFor])
    	  	   }else{
    	  	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	  		   response.setContentType( "application-xdownload")
    	  		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	  		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
    
def openApplicationDetails = {
    		 try {
    		  def application = params.appliId
    	        	def appForWhich=params.docName
    	        	def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor=? order by dateCreated asc",[application,appForWhich]) 
    	        	def appPending = WasteManagementPendingDetails.find("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor=?",[application,appForWhich])
    	        	println("---applicationProcessingDetailsInstanceList--------"+applicationProcessingDetailsInstanceList)
    	        	println("---appPending--------"+appPending)
    	        	model:[applicationProcessingDetailsInstanceList:applicationProcessingDetailsInstanceList,currentPending:appPending.role,appForWhich:appForWhich,appId:application]
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

 def viewFile1 = {
    		 try {
    		 def fileVer=(params.verValue).toLong()
    	 	    	def applicatioFor=params.appForWhich
    	 	    	def appId=(params.appliLoc).toLong()
    	 	    	def applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedClarificationReport' and wmf.version=? order by wmf.id desc",[appId,applicatioFor,fileVer],[max:1])
    	 	    	if(!applicationFileInstance){
    	 	    		flash.message = "Document not uploaded correctly"
    	 	    			redirect(action:"openApplicationDetails", params:[appliId:appId,docName:applicatioFor])
    	 	    	}else{
    	 	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	 		   response.setContentType( "application-xdownload")
    	 		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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

def viewFile11 = {
    		 try {
    		   def applicatioFor=params.appForWhich
    	  	    	def appId=(params.appliLoc).toLong()
    	  	    	def applicationFileInstance = WasteManagementFile.get(appId)
    	  	    	if(!applicationFileInstance){
    	  	    		flash.message = "Document not uploaded correctly"
    	  	    			redirect(action:"openApplicationDetails", params:[appliId:appId,docName:applicatioFor])
    	  	    	}else{
    	  	    	def applicationFileSingleInstance=applicationFileInstance
    	  		   response.setContentType( "application-xdownload")
    	  		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	  		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
    
def viewFile2 = {
    		 try {
    		def fileVer=(params.verValue).toLong()
    	 	    	def applicatioFor=params.appForWhich
    	 	    	def appId=(params.appliLoc).toLong()
    	 	    	def applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedInspectionReport' and wmf.version=? order by wmf.id desc",[appId,applicatioFor,fileVer],[max:1])
    	 	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	 		   response.setContentType( "application-xdownload")
    	 		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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

def viewFile = {
    		 try {
    		def fileVer=(params.verValue).toLong()
    	 	    	def applicatioFor=params.appForWhich
    	 	    	def appId=(params.appliLoc).toLong()
    	 	    	def applicationFileInstance
    	 	    	if(applicatioFor=='BMW'){
    	 	    		applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='Inspection Report BMW' order by wmf.id desc",[appId,applicatioFor],[max:1])
    	 	    		
    	 	    	}else if(applicatioFor=='HWM'){
    	 	    		applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='Inspection Report HWM' order by wmf.id desc",[appId,applicatioFor],[max:1])
    	 	    		
    	 	    	}
    	 	    	else{
    	 	    	 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='inspectionReport' and wmf.version=? order by wmf.id desc",[appId,applicatioFor,fileVer],[max:1])
    	 	    	}
    	 	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	 		   response.setContentType( "application-xdownload")
    	 		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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

def submitClarification = {
    		 try {
    		def appFor=params.docName
    	        	def appliId=params.appliId
    	        	def appId=appliId.toLong()
    	        	def application
    	        	if(appFor=="HWM"){
    	        		application=HazardeousWasteAuthApp.get(appId)
    	        	}else if(appFor=="MSW"){
    	        		application=MunicipalSolidWaste.get(appId)
    	        	}else if(appFor=="PWM"){
    	        		application=PlasticWaste.get(appId)
    	        	}
    	        	else {
    	        		application=BioMedicalWaste.get(appId)
    	        	}
    	        	def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor=? order by wmpd.id desc",[appliId,appFor]) 
    	        	for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
    	        		if((applicationProcessingDetailsInstanceList.get(i)).clarification){
    	        			return[appClarification:applicationProcessingDetailsInstanceList.get(i),app:application,appFor:appFor,appliId:appliId]
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

def submittedClarification = {
    		 try {
    		   def noteHistiryFile=new WasteManagementFile()
    	    		def appProcessing = new WasteManagementProcessingDetails()
    	        	def appFor1=params.appFor
    	        	def appliId1=params.appliId
    	        	def appId=appliId1.toLong()
    	        	def application
    	        	
    	        	def wastemanagementPendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor=? order by wmpd.id desc ",[appliId1,appFor1],[max:1])
    	        	def updateSummary=AllSummaryReportWMS.find("from AllSummaryReportWMS w where w.applicationId=?",[appliId1])
    	        	def pendingInstance=wastemanagementPendingInstance[0]
    	        	if(appFor1=="HWM"){
    	        		application=HazardeousWasteAuthApp.get(appId)
    	        	}else if(appFor1=="MSW"){
    	        		application=MunicipalSolidWaste.get(appId)
    	        	}else if(appFor1=="PWM"){
    	        		application=PlasticWaste.get(appId)
    	        	}else{
    	        		application=BioMedicalWaste.get(appId)
    	        	}
    	            	def f = request.getFile('indClarificationFile')
    	            	MultipartFile multi = request.getFile('indClarificationFile')
    	                	if(!f.empty) {
    	                		println("Level --1")
    	                		appProcessing.clarificationReplyAttachedFile=true
    	                		def applicationFileRecordInstance=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='indClarificationFile' order by wmf.id desc",[appId,appFor1],[max:1])
    	                		 if(applicationFileRecordInstance){
    	                			 noteHistiryFile.version =applicationFileRecordInstance[0].version+1
    	                		 }
    	                		println("Level --2")
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
    	                		    	noteHistiryFile.applicationId=appId
    	                		    		noteHistiryFile.applicationFor=appFor1
    	                		    		if(appFor1=="HWM"){
    	                        		    	noteHistiryFile.indreg=application.industryRegMasterObj
    	                        	    	}else if(appFor1=="MSW"){
    	                        	    		noteHistiryFile.indreg=application.indRegMasterObj
    	                        	    	}else if(appFor1=="PWM"){
    	                        	    		println("Level --3")
    	                        	    		noteHistiryFile.indreg=application.industryRegMasterObj
    	                        	    	}else{
    	                        	    		noteHistiryFile.indreg=application.industryRegMasterObj
    	                        	    	} 
    	                		    	if(noteHistiryFile.save()) {
    	                		    	 } else {
    	                		    	  redirect(action:'appProcessing',params:["id":pendingInstance.id])
    	                		          }
    	                		 }
    	             			else {
    	             				flash.message = "Attachment File Size is More Then 5 Mb"
    	             			    redirectBack = true
    	             			}
    	                	}
    	                application.clarification = false
    	            	application.save()
    	            	appProcessing.role =pendingInstance.role
    	            	appProcessing.officer = "SPCB"
    	            	appProcessing.roleFwd = pendingInstance.role
    	            	appProcessing.officerFwd = "SPCB"
    	            	appProcessing.clarification = false
    	            	if(params.indClarificationNote){
    	            		println("Level --4")
    	            		appProcessing.clarificationNote= params.indClarificationNote
    	            		appProcessing.fileNote = params.indClarificationNote
    	            	}else{
    	            		appProcessing.clarificationNote = ""
    	            		appProcessing.fileNote=""
    	            	}
    	            	appProcessing.inspection = false
    	            	appProcessing.inspectionNote = ""
    	            	appProcessing.inspectionClose = false
    	            	appProcessing.inspectionCloseNote = ""
    	            	appProcessing.approve = false
    	            	appProcessing.approveNote = ""
    	            	appProcessing.reject =  false
    	            	appProcessing.rejectNote = ""
    	            	appProcessing.returnNote=""
    	            	appProcessing.resubmitStatus=false
    	            	appProcessing.returned=false
    	            	appProcessing.applicationId = appliId1
    	            	appProcessing.applicationFor =appFor1
    	            	if(appProcessing.save(flush:true)){
    	            		println("-in app rp save deatils--")
    	            	}else{
    	            		println("Level --5")
    	            		appProcessing.errors.each {
    	        		    }
    	            	}
    	            	if(updateSummary){
    	            		  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	                      def date = new Date();
    	                      String currentDate = dateFormat.format(date);
    	            		updateSummary.clarificationReplyDate=currentDate
    	            		updateSummary.clarification=false
    	            		updateSummary.save()
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

 def popClose = {}

 def viewFileClarification = {
    		 try {
    		 def fileVer=(params.verValue).toLong()
    	 	    	def applicatioFor=params.appForWhich
    	 	    	def appId=(params.appliLoc).toLong()
    	 	    	def applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='indClarificationFile' and wmf.version=? order by wmf.id desc",[appId,applicatioFor,fileVer],[max:1])
    	 	    	def applicationFileSingleInstance=applicationFileInstance[0]
    	 		   response.setContentType( "application-xdownload")
    	 		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    	 		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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

def spcbShowForm={
    		 try {
    		  def municipalSolidWasteInstance
    	    		def hazardeousWasteAuthAppInstance
    	    		def bioMedicalWasteInstance
    	    		def appFor=params.docName
    	        	def appliId=params.appliId
    	        	def appId=appliId.toLong()
    	        	def application
    	        	if(appFor=="HWM"){
    	        		hazardeousWasteAuthAppInstance=HazardeousWasteAuthApp.get(appId)
    	        		def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
    	        		def indRegInstanceId=indRegInstance.id
    	        		def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    	        		def district=indRegInstanceGet.district.districtName
    	        		def tehsil=indRegInstanceGet.tehsil.tehsilName
    	        		def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
    	        		def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
    	        		def wasteManagementFileList = WasteManagementFile.findAll("from WasteManagementFile as wmf where applicationId=? and wmf.typeOfFile!='attachedInspectionReport' and wmf.typeOfFile!='attachedClarificationReport' and wmf.typeOfFile!='inspectionReport' and wmf.typeOfFile!='indClarificationFile'and wmf.typeOfFile!='HWMForm' and wmf.typeOfFile!='attachLetter' ",[hazardeousWasteAuthAppInstance.id])
    	        		String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
    	        		ArrayList tmp1=new ArrayList()
    	                tmp1=tmp.split(",")
    	               return [ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1] 
    	        	}else if(appFor=="MSW"){
    	        	municipalSolidWasteInstance=MunicipalSolidWaste.get(appId)
    	        		def idab=municipalSolidWasteInstance.id
    	        		def indRegInstanceGet=municipalSolidWasteInstance.indRegMasterObj
    	        		def wasteManagementFileInstance=WasteManagementFile.findAll(" from WasteManagementFile wfd where wfd.applicationId=? and wfd.typeOfFile!='attachedInspectionReport' and wfd.typeOfFile!='attachedClarificationReport' and wfd.typeOfFile!='inspectionReport' and wfd.typeOfFile!='indClarificationFile' and wfd.typeOfFile!='MSWForm' and wfd.typeOfFile!='attachLetter' order by wfd.id desc",[idab])
    	         		def listDoc=new ArrayList()
    	         		for(int ig=0;ig<wasteManagementFileInstance.size();ig++){
    	            		def boolCheck=false
    	            		if(listDoc.size()==0){
    	            			listDoc.add(wasteManagementFileInstance.get(ig))
    	            		}
    	            		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	            			if(listDoc[intCheck].description==(wasteManagementFileInstance.get(ig)).description){
    	            				boolCheck=true
    	            			}
    	            		}
    	            		if(boolCheck==false){
    	            			listDoc.add(wasteManagementFileInstance.get(ig))
    	            		}
    	            	}
    	        		return [ municipalSolidWasteInstance : municipalSolidWasteInstance , indRegInstanceGet:indRegInstanceGet,listDoc:listDoc]
    	        	}else{
    	        		bioMedicalWasteInstance=BioMedicalWaste.get(appId)
    	        		def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
    	        		def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
    	        	
    	        		return [ bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance ] 
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


def viewAuthorisationPopup={
		try{
		def bioMedicalWasteInstance=params.id
		println("-----bioMedicalWasteInstance---"+bioMedicalWasteInstance)
		def bioApp=BioMedicalWaste.get(bioMedicalWasteInstance.toLong())
		def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser=? order by to_date(Issued_date, 'dd/mm/yyyy')",[bioApp.industryRegMasterObj])
		return [previousAuthList:previousAuthList]
		}catch(Exception e){

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
def spcbShowFormNewFormat={
		 try {
			    
				
	    		
	    		def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.appliId )
	    		def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
	    		def listDoc=WasteManagementFile.findAll("from WasteManagementFile where applicationId = ? and typeOfFile='Uploded Documents'  and resubmittedDoc=false ",[hazardeousWasteAuthAppInstance.id]);
	    		def listDoc1=WasteManagementFile.findAll("from WasteManagementFile where applicationId = ? and typeOfFile='Uploded Documents'  and resubmittedDoc=true ",[hazardeousWasteAuthAppInstance.id]);
	    		
	    		
	    		if(!hazardeousWasteAuthAppInstance) {
	    			flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
	    			redirect(action:list)
	    		}
	    		else {
	    			def userType;
	       	        def userId;
	       	        if(session.indUser)
	       	        {
	       	        	userType="Industry";
	       	        	userId = ((session.indUser).toString()).trim();
	       	        	
	       	        }
	       	        else if (session.userMaster)
	       	        {
	       	        	userType="SPCB";
	       	        	userId = ((session.userMaster).toString()).trim();
	       	        	
	       	        }
	       	        def activityRecInstance=new ActivityRecord();
	       	        activityRecInstance.userType=userType;
	       	        activityRecInstance.userID=userId;
	       	        activityRecInstance.ipAddress=request.getRemoteAddr() 
	       		    activityRecInstance.activity = "view"
	       		    activityRecInstance.status = "Waste Application "+params.appliId+ " View Form Click."
	       	        if(activityRecInstance.save()){		   
	       	          }
	       	        	else{
	       	        		activityRecInstance.errors.each {
	       			    	println it
	       			  }
	       		  }
	    			render(view:'spcbShowFormNewFormat',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,listDoc:listDoc,listDoc1:listDoc1] ) 
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


def spcbShowFormNewFormat1={
		 try {
		     	

	            def bioMedicalWasteInstance = BioMedicalWaste.get( params.appliId )        
	            def appId=bioMedicalWasteInstance.id
	            def appFor="BMW"
	            def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
	            def certInstance=checkCertificate[0]
	            def certInstanceId
	            if(certInstance){
	            certInstanceId=certInstance.id
	            }
	        	IndUser indUserInstance=IndUser.find("from IndUser as bb where bb.industryRegMaster=?",[bioMedicalWasteInstance.industryRegMasterObj])
	    		def induserQuery=IndUser.get(indUserInstance.id)
	    		
	    		
	    		def indRegInstance=indUserInstance.industryRegMaster
	    		def indRegInstanceId=indRegInstance.id
	    		def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
	        	
	    		def approveApplicationList= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails bmr where bmr.indRegInstance=? and applicationFor='BMW' and applicationStatus='approved'",[indRegInstanceGet])
	            def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
	          
	            if(!bioMedicalWasteInstance) {
	                flash.message = "BioMedicalWaste not found with id ${params.id}"
	                redirect(action:list)
	            }
	            else {
	            	def userType;
	       	        def userId;
	       	        if(session.indUser)
	       	        {
	       	        	userType="Industry";
	       	        	userId = ((session.indUser).toString()).trim();
	       	        	
	       	        }
	       	        else if (session.userMaster)
	       	        {
	       	        	userType="SPCB";
	       	        	userId = ((session.userMaster).toString()).trim();
	       	        	
	       	        }
	       	        def activityRecInstance=new ActivityRecord();
	       	        activityRecInstance.userType=userType;
	       	        activityRecInstance.userID=userId;
	       	        activityRecInstance.ipAddress=request.getRemoteAddr() 
	       		    activityRecInstance.activity = "view"
	       		    activityRecInstance.status = "Waste Application "+params.appliId+ " View Form Click."
	       	        if(activityRecInstance.save()){		   
	       	          }
	       	        	else{
	       	        		activityRecInstance.errors.each {
	       			    	println it
	       			  }
	       		  }
	            	render(view:'spcbShowFormNewFormat1',model:[certInstanceId:certInstanceId, bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance , id:bioMedicalWasteInstance.id ,approveApplicationList:approveApplicationList]) }
	            	 
	    
	    
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





def uploadConsentOrderBMW = {
		 try {
			    
	        	
	    		

	    		def idAppl= (params.appliId).toLong()
	    		def indApplicationDetailsInstance=BioMedicalWaste.get(idAppl)
	    		
	    		def app = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id.toString())
	    		
	    		def viewCert = false
	    		def certInst = UploadCertificateBMW.findByApplicationId(indApplicationDetailsInstance)
	    		if(certInst)
	    		{
	    			viewCert = true
	    		}
	    		def roleHeader=app.role.roleName
	        	return [appDetId:params.appliId,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert]
	        
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
def uploadConsentOrderPWM={

		 try {
			    
	        	
	    		

	    		def idAppl= (params.appliId).toLong()
	    		def indApplicationDetailsInstance=PlasticWaste.get(idAppl)
	    		
	    		def app = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id.toString())
	    		
	    		def viewCert = false
	    		def certInst = UploadCertificatePWM.findByApplicationId(indApplicationDetailsInstance)
	    		if(certInst)
	    		{
	    			viewCert = true
	    		}
	    		def roleHeader=app.role.roleName
	        	return [appDetId:params.appliId,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert]
	        
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
   
   def saveConsentOrderBMW= {
		 try {
			    
	    		
	    		
	    		
	    		
	    		def idAppl= (params.idIndApp).toLong()
	    		def indApplicationDetailsInstance=BioMedicalWaste.get(idAppl)
	    		
	    		def app = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id.toString())
	    		def recordCerti=RecordCertificateBMW.findByApplication(indApplicationDetailsInstance)
	    		
	    		def viewCert = false
	    		def certInst = UploadCertificateBMW.findByApplicationId(indApplicationDetailsInstance)
	    		if(certInst)
	    		{
	    			viewCert = true
	    		}
	    		def roleHeader=app.role.roleName
	    		
	    		
	    		
	    		def recordCertificateInstance=new UploadCertificateBMW()
	    		
	    		WasteManagementCertificates file=new WasteManagementCertificates()
	    		
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
	    			
	    			if(recordCerti){
	    				recordCerti.expiryDate=y
	    				recordCerti.authorizationNo=params.referenceNo
	    				recordCerti.save()
	    			}
	    			else{
	    				flash.message="Please Generate Authorization Certificate for this Application"
	    					render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    			}
	    			
	    			
	    		}
	    		catch(Exception e) {
	    			flash.message="Enter Both The Consent Granted Dates "
	    			render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    		}

	    if(checkDate) {
	    			
	    			java.sql.Date refDate = new java.sql.Date(zz.getTime())
	    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
	    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
	    			
	    			
	    			if(sqlDate>sqlDate2) {
	    				flash.message="Grant To Date should be Greater than Grant From Date"
	    				render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    				
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
	    						render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    						return
	    				}
	    		    	recordCertificateInstance.referenceNo=refNo
	    		    	recordCertificateInstance.referenceDate=refDate
	    		    	
	    				recordCertificateInstance.updatedBy=session.userMaster
	    				recordCertificateInstance.createdBy=session.userMaster
	    			
	    				recordCertificateInstance.refData="1."
	    				recordCertificateInstance.applicationId=indApplicationDetailsInstance

	    if(!recordCertificateInstance.hasErrors()) {
	    					
	    					def f = request.getFile('consentOrder')
	    					
	    		    		if(!f.empty) {
	    		    			MultipartFile multi = request.getFile('consentOrder')
	    						file.size = multi.getSize() / 1024
	    						file.extension = extractExtension( multi )
	    						file.data=multi.getBytes()
	    						
	    						def abc = "CertiFicate"
	    			            def b = abc+"."+extractExtension( multi )
	    			            file.name =b 
	    			            file.description="Certificate Uploaded Record"	
	    			            	if(session.userMaster==null)
	    			            	{
	    			            		flash.message="Your session has been expired ! Please login again."
	    			            		redirect(uri:'/index.gsp')
	    			            		return
	    			            	}

	    		    			 file.createdBy=indApplicationDetailsInstance.industryRegMasterObj.indName//"abc"//session.userMaster

	    		    	    	 file.updatedBy=indApplicationDetailsInstance.industryRegMasterObj.indName//"xyz"//session.userMaster

	    		    	    	 file.typeOfFile="uploaded"

	    		    	    	 file.indreg=indApplicationDetailsInstance.industryRegMasterObj

	    		    	    	 file.applicationId=indApplicationDetailsInstance.id

	    		    	    	 file.applicationFor="BMW"

	    		    	    	 file.dateCreated=new Date()

	    						
	    						Byte[] bytes=multi.getBytes() 

	    						if(file.save()) {
	    							if(recordCertificateInstance.save(flush:true)){
	    							flash.message = "Certificate Generated and Record Saved "

	    							}
	    							else {
	        							
	    								recordCertificateInstance.errors.each {
	        		        		        println it
	        		        		   }
	        							}
	    							
	    							
	    						} else {
	    							
	    							file.errors.each {
	    		        		        println it
	    		        		   }
	    							
	    							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
	    								render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    								}
	    					}
	    					
	    					
	    					
	    					
	    					flash.userMessage = "Certificate has been uploaded."
	    					
	    
	    }
	    				else {
	    					flash.message="Can not contain special characters or reserve words"
	    					render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    				}
	    		
	    			}	
	    }

	    redirect(action:appProcessing,params:["id":app.id])
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

def saveConsentOrderPWM={

		 try {
			   
	    		def idAppl= (params.idIndApp).toLong()
	    		def indApplicationDetailsInstance=PlasticWaste.get(idAppl)
	    		
	    		def app = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id.toString())
	    		def recordCerti=RecordCertificatePWM.findByApplication(indApplicationDetailsInstance)
	    		
	    		def viewCert = false
	    		def certInst = UploadCertificatePWM.findByApplicationId(indApplicationDetailsInstance)
	    		if(certInst)
	    		{
	    			viewCert = true
	    		}
	    		def roleHeader=app.role.roleName
	    		
	    		
	    		
	    		def recordCertificateInstance=new UploadCertificatePWM()
	    		
	    		WasteManagementCertificates file=new WasteManagementCertificates()
	    		
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
	    			render(view:'uploadConsentOrderPWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    		}

	    if(checkDate) {
	    			
	    			java.sql.Date refDate = new java.sql.Date(zz.getTime())
	    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
	    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
	    			
	    			
	    			if(sqlDate>sqlDate2) {
	    				flash.message="Grant To Date should be Greater than Grant From Date"
	    				render(view:'uploadConsentOrderPWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    				
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
	    						render(view:'uploadConsentOrderBMW',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    						return
	    				}
	    		    	recordCertificateInstance.referenceNo=refNo
	    		    	recordCertificateInstance.referenceDate=refDate
	    		    	
	    				recordCertificateInstance.updatedBy=session.userMaster
	    				recordCertificateInstance.createdBy=session.userMaster
	    			
	    				recordCertificateInstance.refData="1."
	    				recordCertificateInstance.applicationId=indApplicationDetailsInstance

	    if(!recordCertificateInstance.hasErrors()) {
	    					
	    					def f = request.getFile('consentOrder')
	    					
	    		    		if(!f.empty) {
	    		    			MultipartFile multi = request.getFile('consentOrder')
	    						file.size = multi.getSize() / 1024
	    						file.extension = extractExtension( multi )
	    						file.data=multi.getBytes()
	    						
	    						def abc = "CertiFicate"
	    			            def b = abc+"."+extractExtension( multi )
	    			            file.name =b 
	    			            file.description="Certificate Uploaded Record"	
	    			            	if(session.userMaster==null)
	    			            	{
	    			            		flash.message="Your session has been expired ! Please login again."
	    			            		redirect(uri:'/index.gsp')
	    			            		return
	    			            	}

	    		    			 file.createdBy=indApplicationDetailsInstance.industryRegMasterObj.indName//"abc"//session.userMaster

	    		    	    	 file.updatedBy=indApplicationDetailsInstance.industryRegMasterObj.indName//"xyz"//session.userMaster

	    		    	    	 file.typeOfFile="uploaded"

	    		    	    	 file.indreg=indApplicationDetailsInstance.industryRegMasterObj

	    		    	    	 file.applicationId=indApplicationDetailsInstance.id

	    		    	    	 file.applicationFor="PWM"

	    		    	    	 file.dateCreated=new Date()

	    						
	    						Byte[] bytes=multi.getBytes() 

	    						if(file.save()) {
	    							if(recordCertificateInstance.save(flush:true)){
	    							flash.message = "Certificate Generated and Record Saved "

	    							}
	    							else {
	        							
	    								recordCertificateInstance.errors.each {
	        		        		        println it
	        		        		   }
	        							}
	    							
	    							
	    						} else {
	    							
	    							file.errors.each {
	    		        		        println it
	    		        		   }
	    							
	    							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
	    								render(view:'uploadConsentOrderPWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    								}
	    					}
	    					
	    					
	    					
	    					
	    					flash.userMessage = "Certificate has been uploaded."
	    					
	    
	    }
	    				else {
	    					flash.message="Can not contain special characters or reserve words"
	    					render(view:'uploadConsentOrderPWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    				}
	    		
	    			}	
	    }

	    redirect(action:appProcessing,params:["id":app.id])
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
   def viewUploadedBioCert={
		 try {
			    
	        	
	        	def industryId = session.indUser
	        	def userId = session.userMaster
	        	if((userId==null || userId=="") && (industryId==null || industryId==""))
	        	{
	        		flash.message="Your session has been expired ! Please login again."
	        		redirect(controller:"userMaster",action:"logout")
	        	}
	        	

	        	def temp=(params.id).toLong()
	        	def application = WasteManagementCertificates.findAll("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='BMW' and afr.typeOfFile='uploaded' order by afr.id desc",[params.id.toLong()],[max:1])
	      	

	        	def applicationFileSingleInstance=application[(application.size())-1]

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
   
   
def uploadConsentOrderHWM = {
		 try {
			    
	        	
	    		

	    		def idAppl= (params.appliId).toLong()
	    		def indApplicationDetailsInstance=HazardeousWasteAuthApp.get(idAppl)
	    		
	    		def app = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id.toString())
	    		
	    		def viewCert = false
	    		def certInst = UploadCertificateHWM.findByApplicationId(indApplicationDetailsInstance)
	    		if(certInst)
	    		{
	    			viewCert = true
	    		}
	    		def roleHeader=app.role.roleName
	        	return [appDetId:params.appliId,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert]
	        
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
   
 def saveConsentOrderHWM= {
		 try {
			    
	    		
	    		
	    		
	    		
	    		def idAppl= (params.idIndApp).toLong()
	    		def indApplicationDetailsInstance=HazardeousWasteAuthApp.get(idAppl)
	    		
	    		def app = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id.toString())
	    		def recordCerti=RecordCertificateHWM.findByApplication(indApplicationDetailsInstance)
	    		def viewCert = false
	    		def certInst = UploadCertificateHWM.findByApplicationId(indApplicationDetailsInstance)
	    		/*if(certInst)
	    		{
	    			viewCert = true
	    		}*/
	    		def roleHeader=app.role.roleName
	    		
	    		
	    		
	    		def recordCertificateInstance=new UploadCertificateHWM()
	    		
	    		WasteManagementCertificates file=new WasteManagementCertificates()
	    		
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
	    				if(recordCerti){
	    				recordCerti.expiryDate=y
	    				recordCerti.authorizationNo= params.referenceNo
	    					recordCerti.save()
	    				}else{
	    					flash.message="Please Generate Certificate First"
	    		    			render(view:'uploadConsentOrderHWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    		    			return
	    				}
	    			
	    			
	    		}
	    		catch(Exception e) {
	    			flash.message="Enter Both The Consent Granted Dates "
	    			render(view:'uploadConsentOrderHWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    		}

	    if(checkDate) {
	    			
	    			java.sql.Date refDate = new java.sql.Date(zz.getTime())
	    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
	    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
	    			
	    			
	    			if(sqlDate>sqlDate2) {
	    				flash.message="Grant To Date should be Greater than Grant From Date"
	    				render(view:'uploadConsentOrderHWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    				
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
	    						render(view:'uploadConsentOrderHWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    						return
	    				}
	    		    	recordCertificateInstance.referenceNo=refNo
	    		    	recordCertificateInstance.referenceDate=refDate
	    		    	
	    				recordCertificateInstance.updatedBy=session.userMaster
	    				recordCertificateInstance.createdBy=session.userMaster
	    			
	    				recordCertificateInstance.refData="1."
	    				recordCertificateInstance.applicationId=indApplicationDetailsInstance

	    if(!recordCertificateInstance.hasErrors()) {
	    					
	    					
	    					
	    					
	    						
	    					def f = request.getFile('consentOrder')
	    					
	    		    		if(!f.empty) {
	    		    			MultipartFile multi = request.getFile('consentOrder')
	    						file.size = multi.getSize() / 1024
	    						file.extension = extractExtension( multi )
	    						file.data=multi.getBytes()
	    						
	    						def abc = "CertiFicate"
	    			            def b = abc+"."+extractExtension( multi )
	    			            file.name =b 
	    			            file.description="Certificate Uploaded Record"	
	    			            	if(session.userMaster==null)
	    			            	{
	    			            		flash.message="Your session has been expired ! Please login again."
	    			            		redirect(uri:'/index.gsp')
	    			            		return
	    			            	}

	    		    			 file.createdBy=indApplicationDetailsInstance.industryRegMasterObj.indName//"abc"//session.userMaster

	    		    	    	 file.updatedBy=indApplicationDetailsInstance.industryRegMasterObj.indName//"xyz"//session.userMaster

	    		    	    	 file.typeOfFile="uploaded"

	    		    	    	 file.indreg=indApplicationDetailsInstance.industryRegMasterObj

	    		    	    	 file.applicationId=indApplicationDetailsInstance.id

	    		    	    	 file.applicationFor="HWM"

	    		    	    	 file.dateCreated=new Date()

	    						
	    						Byte[] bytes=multi.getBytes() 

	    						if(file.save()) {
	    							if(recordCertificateInstance.save(flush:true)){
	    							flash.message = "Certificate Generated and Record Saved "

	    							}
	    							else {
	        							
	    								recordCertificateInstance.errors.each {
	        		        		        println it
	        		        		   }
	        							}
	    							
	    							
	    						} else {
	    							
	    							file.errors.each {
	    		        		        println it
	    		        		   }
	    							
	    							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
	    								render(view:'uploadConsentOrderHWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
	    								}
	    					}
	    					
	    					
	    					
	    					
	    					flash.userMessage = "Certificate has been uploaded."
	    					
	    redirect(action:appProcessing,params:["id":app.id])
	    return
	    }
	    				else {
	    					flash.message="Can not contain special characters or reserve words"
	    					render(view:'uploadConsentOrderHWM',model:[appDetId:params.idIndApp,indApplicationDetailsInstance:indApplicationDetailsInstance,roleHeader:roleHeader,viewCert:viewCert])
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
   def viewUploadedHazCert={
		 try {
			    
	        	
	        	def industryId = session.indUser
	        	def userId = session.userMaster
	        	if((userId==null || userId=="") && (industryId==null || industryId==""))
	        	{
	        		flash.message="Your session has been expired ! Please login again."
	        		redirect(controller:"userMaster",action:"logout")
	        	}
	        	

	        	def temp=(params.id).toLong()
	        	def application = WasteManagementCertificates.findAll("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='HWM' and afr.typeOfFile='uploaded' order by afr.id desc",[params.id.toLong()],[max:1])
	      	

	        	def applicationFileSingleInstance=application[(application.size())-1]

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


def viewReturnReason ={
try {
	println("--invoked---"+params.id)
		def application = BioMedicalWaste.get((params.id).toLong())
		println("--invoked---"+application)
		def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails w where w.applicationId=? order by w.id desc",[String.valueOf(application.id)]) 
		println("--invoked---"+applicationProcessingDetailsInstanceList.size())
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
def viewReturnReasonForHWM={

		try {
			println("--invoked---"+params.id)
				def application = HazardeousWasteAuthApp.get((params.id).toLong())
				println("--invoked---"+application)
				def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails w where w.applicationId=? order by w.id desc",[String.valueOf(application.id)]) 
				println("--invoked---"+applicationProcessingDetailsInstanceList.size())
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

def popBMWInspectionReport={
		println(params.id)
		def wastePending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails s where s.applicationId=?",[params.id])
		
		def bioMedicalInstance=BioMedicalWaste.get((params.id).toLong())
		def inspectionData=BioMedicalInspectionReport.findByApplication(bioMedicalInstance)
		if(inspectionData){
		return[insData:bioMedicalInstance,inspectionData:inspectionData]
		}else{
			render(view:'popBMWInspectionReport1',model:[insData:bioMedicalInstance])
		}
}/*
def setBmwInspectionData={
		println("params id---"+params)
		def bioInstance=BioMedicalWaste.find("from BioMedicalWaste where id=?",[(params.id).toLong()])
	def wasteInspection =WasteInspectionDetails.find("from WasteInspectionDetails w where w.applicationId=?",[params.id])
	
if(!wasteInspection){
	def insBioInstance=new InspectionBioMedical()
	def wasteInsDetails=new WasteInspectionDetails()
	insBioInstance.properties=bioInstance.properties
	insBioInstance.save(flush:true)
	wasteInsDetails.applicationId=String.valueOf(bioInstance.id)
	wasteInsDetails.wasteInsAppId=insBioInstance.id
	wasteInsDetails.applicationFor="BMW"
	wasteInsDetails.indRegInstance=bioInstance.industryRegMasterObj
	wasteInsDetails.dateCreated= new Date()
	wasteInsDetails.save(flush:true)
}
}


*/
def saveBMWInspectionReport={
		try{
		println("--invoked--"+params.adequateOnSite)
		def bioInstance=BioMedicalWaste.get(params.appId.toLong())
		def reportInstance=BioMedicalInspectionReport.findByApplication(bioInstance)
		if(!reportInstance)
		{
			reportInstance= new BioMedicalInspectionReport()
		}
		String abc=""
		if(params.wasteGenQuantityYellow){
			String k=params.wasteGenQuantityYellow
			abc=abc.concat("YELLOW-")+k
			abc=abc.concat(",")
		}
		if(params.wasteGenQuantityRed){
			String kk=params.wasteGenQuantityRed
			abc=abc.concat("RED-")+kk
			abc=abc.concat(",")
		}
		if(params.wasteGenQuantityBlue){
			String kkk=params.wasteGenQuantityBlue
			abc=abc.concat("BLUE-")+kkk
			abc=abc.concat(",")
		}
		if(params.wasteGenQuantityWhite){
			String kkkk=params.wasteGenQuantityWhite
			abc=abc.concat("WHITE-")+kkkk
			
		}
		reportInstance.wasteGenQuantity=abc
		reportInstance.application=bioInstance
		reportInstance.properties=params.properties
		
		
		/*reportInstance.hcfName=params.hcfName
		reportInstance.correspondenceAddress=params.occAddress
		reportInstance.yearOfEstablishment=params.yearOfEstablishment
		reportInstance.monthofEstablishment=params.commMonth
		reportInstance.indName=params.indName
		reportInstance.indAddress=params.indAddress
		reportInstance.occName=params.occName
		reportInstance.occPhone=params.occPhone
		reportInstance.hcfType=params.hcfType
		reportInstance.hcfTypeMenu=params.hcfTypeMenu
		reportInstance.authorizationSought=params.authorizationSought 
		reportInstance.authunderbiomed=params.authunderbiomed
		reportInstance.consentunderwateract=params.consentunderwateract
		reportInstance.noOfyear=params.noOfyear
		reportInstance.avgOccupancy=params.noOfInOutPatients
		reportInstance.noOfBeds=params.noofbeds
		reportInstance.ctectoStatus=params.ctectoStatus
		reportInstance.authorizationFor=params.authorisationAppliedFor 
		reportInstance.annualReport=params.annualReport
		reportInstance.noOfPersoninBmw=params.noOfPersoninBmw
		reportInstance.sourceBioWasteGen=params.sourceBioWasteGen
		reportInstance.wasteGenQuantity=params.wasteGenQuantity
		reportInstance.colorCodingBins=params.colorCodingBins
		reportInstance.waterProofLabels=params.waterProofLabels
		reportInstance.postersSegregation=params.postersSegregation
		reportInstance.intraRuralTrans=params.intraRuralTrans
		reportInstance.awayHCF=params.awayHCF
		reportInstance.withinHCF=params.withinHCF
		reportInstance.lightingAndVentilation=params.lightingAndVentilation
		reportInstance.leachateProvided=params.leachateProvided
			reportInstance.accessRestricted=params.accessRestricted
			reportInstance.modeofDisposal=params.modeofDisposal
			reportInstance.onSite=params.onSite
			reportInstance.throughCBWTF=params.throughCBWTF
			reportInstance.adequateOnSite=params.adequateOnSite
			reportInstance.untreatedWaste=params.untreatedWaste
			reportInstance.treatedWaste=params.treatedWaste
			reportInstance.trolleysProvided=params.trolleysProvided
			reportInstance.plantProvided=params.plantProvided
			reportInstance.incinerationQuant=params.incinerationQuant
			reportInstance.autoclavingQuant=params.autoclavingQuant
			reportInstance.shreddingQuant=params.shreddingQuant
			reportInstance.chemicaldisQuant=params.chemicaldisQuant
			reportInstance.deepBurialQuant=params.deepBurialQuant
			reportInstance.sharpPit=params.sharpPit
			reportInstance.othermodeTreatment=params.othermodeTreatment
			reportInstance.capacityofAutoclave=params.capacityofAutoclave
			reportInstance.capacityofShredder=params.capacityofShredder
			reportInstance.conditionsofAutoclave=params.conditionsofAutoclave
			reportInstance.trolleywastefeeding=params.trolleywastefeeding
			reportInstance.recordingDeviceAttached=params.recordingDeviceAttached
			reportInstance.performanceofAutoclaving=params.performanceofAutoclaving
			reportInstance.workingofshredder=params.workingofshredder
			reportInstance.quantityofWater=params.quantityofWater
			reportInstance.quantityofWastewater=params.quantityofWastewater
			reportInstance.vehicleWashing=params.vehicleWashing
			reportInstance.containerWashing=params.containerWashing
			reportInstance.effluentTreatmentPlant=params.effluentTreatmentPlant
			reportInstance.neutralization=params.neutralization
			reportInstance.smrConducted=params.smrConducted
			reportInstance.reusedorRecycled=params.reusedorRecycled
			reportInstance.dischargethroughdrain=params.dischargethroughdrain
			reportInstance.etpSludge=params.etpSludge
		reportInstance.plasticTreatment=params.plasticTreatment
		reportInstance.treatedWasteSharps=params.treatedWasteSharps
		reportInstance.mercurywastedisposal=params.mercurywastedisposal
		reportInstance.outdatedCytotoxicDrugs=params.outdatedCytotoxicDrugs
		reportInstance.hyposolutiongenerated=params.hyposolutiongenerated
		reportInstance.segregationofwaste=params.segregationofwaste
		reportInstance.wardsmaintains=params.wardsmaintains
		reportInstance.CBMWTFoperator=params.CBMWTFoperator
		reportInstance.firesafetymeasures=params.firesafetymeasures
		reportInstance.logbookOperation=params.awarenessprogrammes
		reportInstance.awarenessprogrammes=params.awarenessprogrammes
		reportInstance.statusWaste=params.statusWaste
		reportInstance.officerRecom=params.officerRecom
		reportInstance.officerRemark=params.officerRemark
		reportInstance.officerName=params.officerName
		reportInstance.officerDesignation=params.officerDesignation
		reportInstance.stripsporeTest=params.stripsporeTest
			
		*/
		reportInstance.save(flush:true)
		def inspectionFile=WasteManagementFile.findAll("from WasteManagementFile w where w.typeOfFile='Inspection Report BMW' and w.applicationId=?",[bioInstance.id])
		if(inspectionFile.size()>0){
			for(int i=0;i<inspectionFile.size();i++){
				inspectionFile[i].delete();
			}
		}
		
	def user=session.userMaster.toString();
	def insReport = new InspectionReport()
	insReport.getBmwInspectionPdf(bioInstance.id,user)
		
		render(view:'popBMWInspectionReport',model:[insData:bioInstance,inspectionData:reportInstance])
		}catch(Exception e){
			e.printStackTrace();
		}
}

def printFreshInspectionReport={
					def inspectionReportFile=WasteManagementFile.get(params.appliLoc.toLong())
					response.setContentType( "application-xdownload")
    				response.setHeader("Content-Disposition", "attachment;filename=${inspectionReportFile.name}")
    				response.getOutputStream() << new ByteArrayInputStream( inspectionReportFile.data )
}

def popFeesfromOfficerAdd={
		println("--------popFeesfromOfficerAdd--------")

   	 try {
   	    	def app = BioMedicalWaste.get((params.id).toInteger())
   	    	def feeDetailsListByIndustry=FeeBankDetailsBMW.findByApplication(app)
   	    	def feeDetailsList = FeeBankBMWDetailsOfficer.findAllByApplication(app)
   	    	def type=params.type
   	    	return [type:type,id:params.id,feeDetailsList:feeDetailsList,feeDetailsListByIndustry:feeDetailsListByIndustry]
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
		def popFeesfromOfficerView={
		try{
			def app = BioMedicalWaste.get((params.id).toInteger())
	    	def feeDetailsList = FeeBankBMWDetailsOfficer.findAllByApplication(app)
	    	def type=params.type
	    	return [type:type,id:params.id,feeDetailsList:feeDetailsList]
}catch(Exception e){

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
def popFeesfromOfficerEdit={
		println("-----popFeesfromOfficerEdit-----------")

	   	 try {
	   	    	def app = BioMedicalWaste.get((params.id).toInteger())
	   	    	def feeDetailsList = FeeBankBMWDetailsOfficer.findAllByApplication(app)
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
def saveBankFeeDetails={

	   	 try {
	   		 println("params.saveBankFeeDetails.."+params)
	   		 DateCustom dd=new DateCustom()
	   	    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
	   			def type=params.type
	   			def app = BioMedicalWaste.get((params.appId).toInteger())
	   	    	
	   	    		if((params.ddNo).getClass().getName()== "java.lang.String"){
	   	        		def feeBankDetails = new FeeBankBMWDetailsOfficer()
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
	   	        				def feeBankDetails = new FeeBankBMWDetailsOfficer()
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
def deleteFeeBankDetails={
	 try {
	    	def app = BioMedicalWaste.get((params.appId).toInteger())
	    	def type=params.type
	    	if((params.delete).getClass().getName()== "java.lang.String"){
	    		def feeDetInst = FeeBankBMWDetailsOfficer.get((params.delete).toInteger())
	    		feeDetInst.delete()
	    	}else{
	    		if(params.delete){
	        	for(int i=0;i<(params.delete).size();i++){
	        		def feeDetInst = FeeBankBMWDetailsOfficer.get((params.delete[i]).toInteger())
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

def popDeeRecommendationsBMWFresh={
		println("-Print App-"+params)
		def app = BioMedicalWaste.get((params.id).toInteger())
		println("ap"+ app)
		def consentInspectionReportInst = BioMedicalInspectionReport.findByApplication(app)			
		return[appId:app,consentInspectionReportInst:consentInspectionReportInst]	
}

def saveDeeRecommendationsBMWFresh={
		
		def app = BioMedicalWaste.get((params.appId).toLong())
		println("ap"+ app)
		def consentInspectionReportInst = BioMedicalInspectionReport.findByApplication(app)
		if(consentInspectionReportInst){
			consentInspectionReportInst.officerRemark=params.deeRecommendations
			consentInspectionReportInst.officerName=params.officerName
			consentInspectionReportInst.officerDesignation=params.officerDesignation
			consentInspectionReportInst.save(flush:true)
		}
		
		def inspetionReport=WasteManagementFile.findAll("from WasteManagementFile w where w.applicationId=? and typeOfFile='Inspection Report BMW'",[app.id])
		if(inspetionReport.size()>0){
			for(int i=0;i<inspetionReport.size();i++){
				inspetionReport[i].delete()
			}
		}
		
		def user=session.userMaster.toString();
		def insReport = new InspectionReport()
		insReport.getBmwInspectionPdf(app.id,user)
		 flash.message = "Remarks Saved in file"; 
		render(view:'popDeeRecommendationsBMWFresh',model:[appId:app,consentInspectionReportInst:consentInspectionReportInst])
}

def getAppValueForBMW={
		
		println("-------inside in GetAppValueForBMW-------"+params)

		 try {
				def startDate1=params.date
				def endDate1=params.date1
				def applicationType=params.applicationType
				def status=params.status
				def cat=params.cat
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
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor=?  and  abc.authDate >= ? and abc.authDate <= ? and abc.roleId=? and abc.categoryName=?",[applicationType,sqlDate,sqlDate2,(params.id).toString(),cat])	
				}
				else if(status=="pending")
				{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor=? and abc.applicationStatus='pending' and  abc.authDate >= ? and abc.authDate <= ? and abc.roleId=? and abc.categoryName=?",[applicationType,sqlDate,sqlDate2,(params.id).toString(),cat])	
				}
				else if(status=="approved")
				{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor=? and abc.applicationStatus='approved' and  abc.authDate >= ? and abc.authDate <= ? and abc.roleId=? and abc.categoryName=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString(),cat])	
				}
				else if(status=="rejected")
				{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor=? and abc.applicationStatus='rejected' and  abc.authDate >= ? and abc.authDate <= ? and abc.roleId=? and abc.categoryName=?",[applicationType,sqlDate,sqlDate2,(params.id).toString(),cat])	
				}else if(status=="returned")
				{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor=? and abc.applicationStatus='returned' and  abc.authDate >= ? and abc.authDate <= ? and abc.roleId=? ",[applicationType,sqlDate,sqlDate2,(params.id).toString()])	
				}
			   render(view:'getAppValueForBMW',model:[ allSummaryReportList:applicationTotalInstance])
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

def getTotAppBMW={
		
		println("-------inside in GetAppValueForBMW-------"+params)

		 try {
				def startDate1=params.date
				def endDate1=params.date1
				def applicationType=params.applicationType
				def status=params.status
				def cat=params.category
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
					if(cat.equals("all")){
						applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where   abc.authDate >= ? and abc.authDate <= ? and abc.groupId=?"  ,[sqlDate,sqlDate2,params.groupId])
					}else{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.categoryName=? and abc.authDate >= ? and abc.authDate <= ? and abc.groupId=?"  ,[cat,sqlDate,sqlDate2,params.groupId])
					}
				}
				else if(status=="pending")
				{
					if(cat.equals('all')){
						applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='pending' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=?",[sqlDate,sqlDate2,params.groupId])	
					}else{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='pending' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=? and abc.categoryName=?",[sqlDate,sqlDate2,params.groupId,cat])	
					}}
				else if(status=="approved")
				{
					if(cat.equals('all')){
						applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='approved' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=?",[sqlDate,sqlDate2,params.groupId])
					}else{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='approved' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=? and abc.categoryName=? ",[sqlDate,sqlDate2,params.groupId,cat])	
				
				}
					}
				else if(status=="rejected")
				{if(cat.equals('all')){
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='rejected' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=? ",[sqlDate,sqlDate2,params.groupId])	
				}else{
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='rejected' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=? and abc.categoryName=?",[sqlDate,sqlDate2,params.groupId,cat])	
				}
				}else if(status=="returned")
				{applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationFor='BMW' and abc.applicationStatus='returned' and  abc.authDate >= ? and abc.authDate <= ? and abc.groupId=? ",[sqlDate,sqlDate2,params.groupId])	
				
				}
				
			   render(view:'getTotAppBMW',model:[ allSummaryReportList:applicationTotalInstance])
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

def viewUploadedPWMCert={
		try{
			def appId=params.id
			 def certiPWM=WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='PWM' and afr.typeOfFile='uploaded' order by afr.id desc",[appId.toLong()])
			response.setContentType( "application-xdownload")
    				response.setHeader("Content-Disposition", "attachment;filename=${certiPWM.name}")
    				response.getOutputStream() << new ByteArrayInputStream(certiPWM.data) 
		}catch(Exception e){

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
def popHWMInspectionReport={
		try{
		def appId=params.id
		def hazApp=HazardeousWasteAuthApp.get(appId.toLong());
		def inspection=HWMInspection.findByApplication(hazApp)
		if(inspection){
			
		}else{
			inspection= new HWMInspection()
			inspection.dateofvisit=new Date();
			inspection.contactperson=""
			inspection.contact=""
			inspection.desigantion=""
			inspection.dateIssueWater=new Date();
			inspection.dateIssueAir=new Date();
			inspection.dateIssueHwm=new Date();
			inspection.dateValWater=new Date();
			inspection.dateValAir=new Date();
			inspection.dateValHwm=new Date();
			inspection.yearCommission=new Date();
			inspection.caprecyDesc=""
			inspection.remarks=""
			inspection.officerName=""
			inspection.processDesc=""
			inspection.contaminatedRemark=""
			inspection.dateCreated= new Date();
			inspection.createdBy=(session.userMaster).id
			inspection.lastUpdated=new Date()
			inspection.updatedBy=(session.userMaster).id
			inspection.application=hazApp
			if(inspection.save(flush:true) && !inspection.hasErrors()){
				
			}else{

				inspection.errors.each {
					print it
			   }
			
			}
		}
		return[insData:hazApp,inspection:inspection]
		}catch(Exception e){
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
def popAddOfficerDesigHWM={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=OfficerDesignationHwmInspection.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){
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
def popEditOfficerDesigHWM={
		try{
			def id=params.id
			def hwm=HazardeousWasteAuthApp.get(id.toLong())
			def listof=OfficerDesignationHwmInspection.findAllByApplication(hwm)
			return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popOfficerDesigHWMView={

		try{
			
		}catch(Exception e){

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

def saveOfficerDesignation={
		try{
		println("====params=="+params)
		def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
		def ins=new OfficerDesignationHwmInspection()
		ins.officerName=params.officerName
		ins.designation=params.designation
		ins.application=appllication
		ins.save()
		redirect(action:'popAddOfficerDesigHWM',id:appllication.id)
		}catch(Exception e){

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

def popProductDetailsHWM={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=ProductQuanHwmInspection.findAllByApplication(hwm)
		println("=listof="+listof)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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

def saveProductInspect={
		try{
		def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
		def ins=new ProductQuanHwmInspection();
		ins.product=params.product
		if(params.quantity){
			ins.quantity=(params.quantity).toFloat()
		}else{
			ins.quantity=0
		}
		ins.unit=UnitMaster.get(params.unit.toLong())
		ins.status=params.status
		ins.application=appllication
		ins.save()
		redirect(action:'popProductDetailsHWM',id:appllication.id)

		}catch(Exception e){

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
def popHwmGenInspectionAdd={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMGenInspectionDetails.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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

def saveHwmGenInspection={
		try{
	def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
	def ins=new HWMGenInspectionDetails();
	ins.nameHWM=params.nameHwm
	ins.category=params.catgeory
		if(params.quantity){
			ins.quantity=(params.quantity).toFloat()	
		}else{
			ins.quantity=0
		}
	ins.modeoftreatment=params.modeOfTreatment
	ins.unit=UnitMaster.get(params.unit.toLong())
	ins.application=appllication	
	ins.save();
	redirect(action:'popHwmGenInspectionAdd',id:appllication.id)

	}catch(Exception e){

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

def popHwmGeneralInsDetailsAdd={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMGenerationInsDetails.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def saveHwmGeneralInspection={
		try{
		println("=====params==="+params)
		def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
		def ins=new HWMGenerationInsDetails(params)
		ins.application=appllication
		ins.save()
		redirect(action:'popHwmGeneralInsDetailsAdd',id:appllication.id)
		}catch(Exception e){

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
def popHwmStorageAdd={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMstorageIns.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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

def saveHwmStorageInspection={
		try{
		println("=====params==="+params)
		def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
		def ins=new HWMstorageIns(params)
		ins.productionPlant=""
		ins.hmwNameAndCategory=params.hmwNameAndCategory
		ins.quantityHWM=params.quantityHWM
		ins.prevStockQuan=params.prevStockQuan
		ins.actualQuant=params.actualQuant
		ins.balance=params.balance
		ins.datetransfer=params.datetransfer
		ins.application=appllication
		ins.save()
		redirect(action:'popHwmStorageAdd',id:appllication.id)

		}catch(Exception e){

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

def popHWMActualUserAuthAdd={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMActualUserAuth.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def saveHWMActualUserAuth={
		try{
		def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
		def ins=new HWMActualUserAuth(params)
		ins.nameAndAddress=params.nameAndAddress
		ins.spcbName=params.spcbName
		ins.quantityHWM=""
		ins.actAuthGranted=params.actAuthGranted
		ins.nameAndCategory=params.nameAndCategory
		ins.application=appllication
		ins.save()
		redirect(action:'popHWMActualUserAuthAdd',id:appllication.id)
		}catch(Exception e){

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

def popHWMsafetyInsAdd={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMsafetyIns.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popHWMsafetyInsView={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMsafetyIns.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popHWMsafetyInsEdit={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMsafetyIns.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def saveHWMsafetyIns={
		try{
		def appllication=HazardeousWasteAuthApp.get(params.appId.toLong())
		def ins=new HWMsafetyIns(params)
		ins.safetyfacility=params.safetyfacility
		ins.application=appllication
		ins.save();
		redirect(action:'popHWMsafetyInsAdd',id:appllication.id)
		}catch(Exception e){

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
def popViewOfficerDesigHWM={
	try{	
	def id=params.id
	def hwm=HazardeousWasteAuthApp.get(id.toLong())
	def listof=OfficerDesignationHwmInspection.findAllByApplication(hwm)
	return[listof:listof,appDetId:hwm.id]
	}catch(Exception e){
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
def saveHWMInspectionReport={
		try{
		println("===fgggfh========"+params)
		def hwmApp=HazardeousWasteAuthApp.get((params.appId).toLong())
		def inspectionHwm=HWMInspection.findByApplication(hwmApp)
		
		if(inspectionHwm){
			
		}else{
			inspectionHwm= new HWMInspection()
		}
		def sdfh = new SimpleDateFormat("dd/MM/yyyy");
		def dateofvisit= params.dateofvisit_value
		def x = sdfh.parse(dateofvisit);
		java.sql.Date sqlDateVisit = new java.sql.Date(x.getTime())
		inspectionHwm.dateofvisit=sqlDateVisit
		
		def todayDate=sdfh.format(new Date());
		
		def dateIssueWater=params.dateIssueWater_value
		def x1 = sdfh.parse(dateIssueWater);
		java.sql.Date sqlDateIssueWater = new java.sql.Date(x1.getTime())
		inspectionHwm.dateIssueWater=sqlDateIssueWater
		
		
		def dateIssueAir=params.dateIssueAir_value
		def x2= sdfh.parse(dateIssueAir);
		java.sql.Date sqlDateIssueAir = new java.sql.Date(x2.getTime())
		inspectionHwm.dateIssueAir=sqlDateIssueAir
		
		def dateIssueHwm=params.dateIssueHwm_value
		def x3= sdfh.parse(dateIssueHwm);
		java.sql.Date sqlDateIssueHwm = new java.sql.Date(x3.getTime())
		inspectionHwm.dateIssueHwm=sqlDateIssueHwm
		
		
		def dateValWater=params.dateValWater_value
		def x4= sdfh.parse(dateValWater);
		java.sql.Date sqlDateValWater = new java.sql.Date(x4.getTime())
		inspectionHwm.dateValWater=sqlDateValWater
		
		def dateValAir=params.dateValAir_value
		def x5=sdfh.parse(dateValAir)
		java.sql.Date sqlDateValAir = new java.sql.Date(x5.getTime())
		inspectionHwm.dateValAir=sqlDateValAir
		
		def yearCommission=params.yearCommission_value
		def x7=sdfh.parse(yearCommission)
		java.sql.Date sqlDateyearCom = new java.sql.Date(x7.getTime())
		inspectionHwm.yearCommission=sqlDateyearCom
		
		def dateValHwm=params.dateValHwm_value
		def x6=sdfh.parse(dateValHwm)
		java.sql.Date sqlDateValHwm = new java.sql.Date(x6.getTime())
		inspectionHwm.dateValHwm=sqlDateValHwm
		
		if(params.contactperson){
		inspectionHwm.contactperson=params.contactperson
		}else{
			inspectionHwm.contactperson=""
		}
		if(params.contact){
		inspectionHwm.contact=params.contact
		}else{
			inspectionHwm.contact=""
		}
		if(params.desigantion){
		inspectionHwm.desigantion=params.desigantion
		}
		else{
			inspectionHwm.desigantion=""
		}
		if(params.caprecyDesc){
		inspectionHwm.caprecyDesc=params.caprecyDesc
		}else{
			inspectionHwm.caprecyDesc=""
		}
		if(params.processDesc){
		inspectionHwm.processDesc=params.processDesc
		}else{
			inspectionHwm.processDesc=""
		}
		println("====params.remarks==="+params.remarks)
		if(params.remarks){
		inspectionHwm.remarks=params.remarks
		}else{
			inspectionHwm.remarks=""
		}
		inspectionHwm.createdBy=(session.userMaster).id
		inspectionHwm.updatedBy=(session.userMaster).id
		if(params.inspectionOfficer){
		inspectionHwm.officerName=params.inspectionOfficer
		}else{
			inspectionHwm.officerName=''
		}
		if(params.HWcontaminated){
			inspectionHwm.contaminatedRemark=params.HWcontaminated
		}else{
			inspectionHwm.contaminatedRemark=''
		}
		inspectionHwm.application=hwmApp
		File certFile;
		if(inspectionHwm.save(flush:true) && !inspectionHwm.hasErrors()){
			String indName=hwmApp.industryRegMasterObj.indName
			String indAddress=hwmApp.industryRegMasterObj.indAddress
			String website="-"
			String telephone=hwmApp.industryRegMasterObj.occPhoneCode+"-"+hwmApp.industryRegMasterObj.occPhoneNo
			String faxno=hwmApp.industryRegMasterObj.occFaxCode+"-"+hwmApp.industryRegMasterObj.occFaxNo
			String email=hwmApp.industryRegMasterObj.indEmail
			String dobVisit=dateofvisit
			String contactName=params.contactperson
			String mobile=params.contact
			String conDesignation=params.desigantion
			ArrayList listofOfficer
			String processDesc=params.processDesc
			String yearCom=yearCommission
			String wateractvalid=dateIssueWater+"-"+dateValWater
			String airact=dateIssueAir+"-"+dateValAir
			String hwmact=dateIssueHwm+"-"+dateValHwm
			String remarks= params.remarks
			String contaminated=params.HWcontaminated
			
		   
			
			
			
			
			def  arraylist1= new ArrayList()
			def listof1=HWMGenInspectionDetails.findAllByApplication(hwmApp)
		    for(int var=0;var<listof1.size();var++){
			   def abc= new ArrayList()
			   abc.add(listof1[var].nameHWM)
			   abc.add(listof1[var].category)
			   abc.add(listof1[var].quantity.toString()+" "+listof1[var].unit.unitName)
			   abc.add(listof1[var].modeoftreatment)
			   arraylist1.add(abc)
		    }
			
			
			def  arraylist2= new ArrayList()
			def listof2=HWMGenerationInsDetails.findAllByApplication(hwmApp)
			  for(int var=0;var<listof2.size();var++){
				  def abc= new ArrayList()
				  abc.add(listof2[var].productionPlant)
				  abc.add(listof2[var].hmwName)
				  abc.add(listof2[var].quantityHWMGen)
				  abc.add(listof2[var].quantityConsentedCap)
				  abc.add(listof2[var].production1)
				  abc.add(listof2[var].production2)
				  abc.add(listof2[var].input1)
				  abc.add(listof2[var].input2)
				  abc.add(listof2[var].quantityCurrentFinYear)
				  abc.add(listof2[var].quantityPrevFinYear)
				  arraylist2.add(abc)
			  }
			ArrayList arraylist3= new ArrayList()
			 def listof3=HWMstorageIns.findAllByApplication(hwmApp)
			  for(int var=0;var<listof3.size();var++){
				  def abc= new ArrayList()
				  abc.add(listof3[var].hmwNameAndCategory)
				  abc.add(listof3[var].quantityHWM)
				  abc.add(listof3[var].prevStockQuan)
				  abc.add(listof3[var].actualQuant)
				  abc.add(listof3[var].balance)
				  abc.add(listof3[var].datetransfer)
				  arraylist3.add(abc)
				  
			  }
			ArrayList arraylist4= new ArrayList()
			def listof4=HWMActualUserAuth.findAllByApplication(hwmApp)
			for(int var=0;var<listof4.size();var++){
				  def abc= new ArrayList()
				  abc.add(listof4[var].nameAndAddress)
				  abc.add(listof4[var].spcbName)
				  abc.add(listof4[var].actAuthGranted)
				  abc.add(listof4[var].nameAndCategory)
				  arraylist4.add(abc)
			}
			ArrayList arraylist6= new ArrayList()
			def listof6=ProductQuanHwmInspection.findAllByApplication(hwmApp)
			for(int var=0;var<listof6.size();var++){
				 def abc= new ArrayList()
				 abc.add(listof6[var].product)  
				 abc.add(listof6[var].quantity.toString()+" "+listof6[var].unit.unitName)  
				 abc.add(listof6[var].status)  
				 arraylist6.add(abc)
			}
			ArrayList arraylist5= new ArrayList()
			def listof5=HWMsafetyIns.findAllByApplication(hwmApp)
			for(int var=0;var<listof5.size();var++){
				 def abc= new ArrayList()
				 abc.add(listof5[var].safetyfacility)  
				   
				   arraylist5.add(abc)
			}
			def listof7=OfficerDesignationHwmInspection.findAllByApplication(hwmApp)
			ArrayList officerList=new ArrayList()
			for(int var=0;var<listof7.size();var++){
				 def abc= new ArrayList()
				 abc.add(listof7[var].officerName)  
				 abc.add(listof7[var].designation)  
				 officerList.add(abc)
			}
			
			String officerName=params.inspectionOfficer
			HWMInspectionReport inspReport= new HWMInspectionReport()
			WasteManagementFile file=new WasteManagementFile()
			certFile=inspReport.getDetails( indName, indAddress, website, telephone, faxno, email, dobVisit, contactName, mobile, conDesignation, listofOfficer, processDesc, yearCom, wateractvalid, airact, hwmact, arraylist1, arraylist2, arraylist3, arraylist4 ,arraylist6,arraylist5,officerName,todayDate,remarks,contaminated,officerList)
			
			 byte[] b = new byte[(int) certFile.length()];
		
		        FileInputStream fileInputStream = new FileInputStream(certFile);
		        
		         fileInputStream.read(b);
		 	        def fileLength=certFile.length()
		        	 file.size = fileLength / 1024  //f.getSize() 
		 	         file.extension ="pdf"//extractExtension( f )
		 	       	 file.data=b;
		 	       	 file.name="Inspection Report HWM.pdf"
		 	    	 file.description="Inspection Report HWM"
		 	    	 file.createdBy=(session.userMaster).id
		 	    	 file.updatedBy=(session.userMaster).id
		 	    	 file.typeOfFile="Inspection Report HWM"
		 	    	 file.indreg=hwmApp.industryRegMasterObj
		 	    	 file.applicationId=hwmApp.id
		 	    	 file.resubmittedDoc=false
		 	    	 file.applicationFor="HWM"
		 	       	 def wasteFile=WasteManagementFile.findAll("from WasteManagementFile wm where wm.applicationId=? and typeOfFile='Inspection Report HWM'",[hwmApp.id])
		 	       	 if(wasteFile){
		 	       		 for(int i=0;i<wasteFile.size();i++){
		 	       			wasteFile[i].delete();
		 	       		 }
		 	       	 }
		 	       	if(!file.hasErrors() && file.save(flush:true)) {
		 	       		println(" HWM inspection file saved")
		 	       } else {
						file.errors.each {
					   }
					}
			
		}else{
			inspectionHwm.errors.each {
			        println it
				}
		}
		flash.message = "Inspection report Saved..Click on Print InspectionReport"	
		redirect(action:popHWMInspectionReport,params:[id:params.appId])	
		}catch(Exception e){
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
def deleteSafety={
		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = HWMsafetyIns.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = HWMsafetyIns.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popHWMsafetyInsEdit,id:app)	
}
def deleteOfficer={

		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = OfficerDesignationHwmInspection.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = OfficerDesignationHwmInspection.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popEditOfficerDesigHWM,id:app)	

}
def popProductDetailsHWMView={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=ProductQuanHwmInspection.findAllByApplication(hwm)
		println("=listof="+listof)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popProductDetailsHWMEdit={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=ProductQuanHwmInspection.findAllByApplication(hwm)
		println("=listof="+listof)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def deleteProductInspect={
		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = ProductQuanHwmInspection.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = ProductQuanHwmInspection.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popProductDetailsHWMEdit,id:app)	


}
def popHwmGenInspectionView={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMGenInspectionDetails.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popHwmGenInspectionEdit={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMGenInspectionDetails.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def deleteHwmGenInspection={

		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = HWMGenInspectionDetails.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = HWMGenInspectionDetails.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popHwmGenInspectionEdit,id:app)	



}
def popHwmGeneralInsDetailsView={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMGenerationInsDetails.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popHwmGeneralInsDetailsEdit={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMGenerationInsDetails.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def deleteHwmGeneralInspection={
		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = HWMGenerationInsDetails.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = HWMGenerationInsDetails.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popHwmGeneralInsDetailsEdit,id:app)	
}
def popHwmStorageView={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMstorageIns.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popHwmStorageEdit={
		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMstorageIns.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def deleteHwmStorageInspection={

		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = HWMstorageIns.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = HWMstorageIns.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popHwmStorageEdit,id:app)	

}
def popHWMActualUserAuthView={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMActualUserAuth.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def popHWMActualUserAuthEdit={

		try{
		def id=params.id
		def hwm=HazardeousWasteAuthApp.get(id.toLong())
		def listof=HWMActualUserAuth.findAllByApplication(hwm)
		return[listof:listof,appDetId:hwm.id]
		}catch(Exception e){

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
def deleteHWMActualUserAuth={


		def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
    	if((params.delete).getClass().getName()== "java.lang.String"){
    		def feeDetInst = HWMActualUserAuth.get((params.delete).toInteger())
    		feeDetInst.delete()
    	}else{
    		if(params.delete){
        	for(int i=0;i<(params.delete).size();i++){
        		def feeDetInst = HWMActualUserAuth.get((params.delete[i]).toInteger())
        		feeDetInst.delete()
        	}
    		}
    	}
    	redirect(action:popHWMActualUserAuthEdit,id:app)	


}

def viewScrutiny = {
		try {
			println("params----"+params)
			def application
			if(params.applName == "HWM"){
		 application = HazardeousWasteAuthApp.get((params.id).toLong())
			}
			if(params.applName == "BMW"){
	    		 application = BioMedicalWaste.get((params.id).toLong())
	    		}
			if(params.applName == "PWM"){
	    		 application = PlasticWaste.get((params.id).toLong())
	    		}
			if(params.applName == "Construction and Demolition"){
	    		 application = ConstructionDemolitionWaste.get((params.id).toLong())
	    		}
	    		
			def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAllByApplicationId(application.toString(),[sort:'dateCreated',order:'desc',offset:0]) 
//			if(applicationProcessingDetailsInstanceList.scrutinyStatus=='In-Complete'){
//				if(applicationProcessingDetailsInstanceList.returned==true){
//					return[appScrutiny:applicationProcessingDetailsInstanceList,app:application]
//				}
//			}
			
			for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
				if((applicationProcessingDetailsInstanceList.get(i)).scrutinyStatus=='In-Complete'){
					
					println("ppppp-----------2222222-----"+applicationProcessingDetailsInstanceList)
					return[appScrutiny:applicationProcessingDetailsInstanceList.get(i),app:application]
				}
			}
		
		}catch(Exception e) {
	        //e.printStackTrace();
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
//        Added by Deepak for Additional payment
def addPayment = {

		 try {
			 println("addPayment pkkk"+params)
			 def applicationPending = WasteManagementPendingDetails.findByApplicationId(params.id)
			 println("applicationPending AAAAAAAAA "+applicationPending)
   	    	def appFor=applicationPending.applicationFor
   	    	def indApplicationDetailsInstance
   	    	def indRegInstance
   	    	def totalfee
   	    	def feeDetailsList
   	    	def feeAmountId
				if(appFor=="HWM"){
					indApplicationDetailsInstance=HazardeousWasteAuthApp.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeDetailsList = FeeBankOtherDetailsHWM.findAllByApplication(indApplicationDetailsInstance)
		        	totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
					
					feeAmountId = ConsentFeeMasterHWM.find("from ConsentFeeMasterHWM abc where abc.application.id = ?",[(applicationPending.applicationId).toLong()])
					if(!feeAmountId){
						
						def consentFeeMasterInstance = new ConsentFeeMasterHWM()
						
						consentFeeMasterInstance.application = indApplicationDetailsInstance
						consentFeeMasterInstance.noOfYears = 0
						consentFeeMasterInstance.calculatedFee = 0 
						consentFeeMasterInstance.lateFees = 0
						consentFeeMasterInstance.addFees = 0
						consentFeeMasterInstance.totalFees = 0 
						if(consentFeeMasterInstance.save())
			       		{

			       		}else{
			       			consentFeeMasterInstance.errors.each{
			       				println it;
			       			}
			       		}
						
					}
				}else if(appFor=="MSW"){
   	    		indApplicationDetailsInstance=MunicipalSolidWaste.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeAmountId = ConsentFeeMasterMSW.find("from ConsentFeeMasterMSW abc where abc.application.id = ?",[(applicationPending.applicationId).toLong()])
   	    	}else if(appFor=="EWaste"){
   	    		indApplicationDetailsInstance=EWaste.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeAmountId = ConsentFeeMasterEWASTE.find("from ConsentFeeMasterEWASTE abc where abc.application.id = ?",[(applicationPending.applicationId).toLong()])
   	    	}else if(appFor=="PWM"){
   	    		indApplicationDetailsInstance=PlasticWaste.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeDetailsList = FeeBankOtherDetailsPWM.findAllByApplication(indApplicationDetailsInstance)
		        	totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
   	    		feeAmountId = ConsentFeeMasterPWM.find("from ConsentFeeMasterPWM abc where abc.application.id = ?",[(applicationPending.applicationId).toLong()])
   	    	}else if(appFor=="Construction and Demolition"){
   	    		indApplicationDetailsInstance=ConstructionDemolitionWaste.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeAmountId = ConsentFeeMasterConsDemoli.find("from ConsentFeeMasterConsDemoli abc where abc.application.id = ?",[(applicationPending.applicationId).toLong()])
   	    	}else if(appFor=="BATTERY"){
   	    		indApplicationDetailsInstance=BatteryWasteDetails.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeAmountId = BatteryFeeMaster.find("from BatteryFeeMaster abc where abc.application.id = ?",[(applicationPending.applicationId).toLong()])
   	    	}else{
   	    		indApplicationDetailsInstance=BioMedicalWaste.get((applicationPending.applicationId).toLong())
   	    		indRegInstance=indApplicationDetailsInstance.industryRegMasterObj
   	    		feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(indApplicationDetailsInstance)
		        	totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
   	    		feeAmountId = ConsentFeeMasterBMW.find("from ConsentFeeMasterBMW abc where abc.application.id = ? order by id desc",[(applicationPending.applicationId).toLong()])
   	    	println("feeAmountId----cppcpcp--"+feeAmountId)
   	    	}
			 
//	    	 def indApplicationDetailsInstance = HazardeousWasteAuthApp.get( (params.id ).toLong())
	    	
	    	def feeAmount
	    	if(feeAmountId){
	    		
	    		 feeAmount = (feeAmountId.totalFees).toInteger()
	    	}
	    	
	    	
	    	
	        	println("indApplicationDetailsInstance "+indApplicationDetailsInstance)
	    	render(view:'addPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feeAmount:totalfee])
	    
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

def addPaymentOption = {
		try {
			 		println("params in addPaymentOption----"+params)   
			   		
			   		def applicationPending = WasteManagementPendingDetails.findByApplicationId(params.indAppDetId)
			    	def appFor=applicationPending.applicationFor
			    	def indApplicationDetailsInstance
					if(appFor=="HWM"){
						indApplicationDetailsInstance=HazardeousWasteAuthApp.get((applicationPending.applicationId).toLong())
			    	}else if(appFor=="MSW"){
			    		indApplicationDetailsInstance=MunicipalSolidWaste.get((applicationPending.applicationId).toLong())
			    	}else if(appFor=="PWM"){
			    		indApplicationDetailsInstance=PlasticWaste.get((applicationPending.applicationId).toLong())
			    	}else if(appFor=="EWaste"){
			    		indApplicationDetailsInstance=EWaste.get((applicationPending.applicationId).toLong())
			    	}else if(appFor=="Construction and Demolition"){
			    		indApplicationDetailsInstance=ConstructionDemolitionWaste.get((applicationPending.applicationId).toLong())
			    	}else if(appFor=="BATTERY"){
			    		indApplicationDetailsInstance=BatteryWasteDetails.get((applicationPending.applicationId).toLong())
			    	}else{
			    		indApplicationDetailsInstance=BioMedicalWaste.get((applicationPending.applicationId).toLong())
			    	}
			   		
			   			    	
			 		println("indApplicationDetailsInstance in addPaymentOption----"+indApplicationDetailsInstance)   
			    	String fees = params.addFee
			    	 Random random = new Random(new Date().getTime());
			    	int randomInt = random.nextInt(1000000000);
			    	  
			 
					
				session.setAttribute("fee",fees)
					
			    	  
			    	if(params.radio=="online")
			    	{
			    		render(view:'addPaymentOption',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,fees:fees,randomInt:randomInt,appFor:appFor])
			    	}
			    	else
			    	{
			    		redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance)
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


def addBankPaymentMode={
		 try {
			    println("HELLO PARAMS in addBankPaymentMode-----"+params);
			    def applicationPending = WasteManagementPendingDetails.findByApplicationId((params.id).toString())
   	    	def appFor=applicationPending.applicationFor
   	    	def indApplicationDetailsInstance
				if(appFor=="HWM"){
					indApplicationDetailsInstance=HazardeousWasteAuthApp.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="MSW"){
   	    		indApplicationDetailsInstance=MunicipalSolidWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="PWM"){
   	    		indApplicationDetailsInstance=PlasticWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="EWaste"){
   	    		indApplicationDetailsInstance=EWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="Construction and Demolition"){
   	    		indApplicationDetailsInstance=ConstructionDemolitionWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="BATTERY"){
   	    		indApplicationDetailsInstance=BatteryWasteDetails.get((applicationPending.applicationId).toLong())
   	    	}else{
   	    		indApplicationDetailsInstance=BioMedicalWaste.get((applicationPending.applicationId).toLong())
   	    	}
		    	println("indApplicationDetailsInstance-------"+indApplicationDetailsInstance);
		    	[indApplicationDetailsInstance:indApplicationDetailsInstance]
		    
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

def confirmation = {

		 try {
			    
			 
			 	def applicationPending = WasteManagementPendingDetails.findByApplicationId(params.indAppDetId)
   	    	def appFor=applicationPending.applicationFor
   	    	def indApplicationDetailsInstance
				if(appFor=="HWM"){
					indApplicationDetailsInstance=HazardeousWasteAuthApp.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="MSW"){
   	    		indApplicationDetailsInstance=MunicipalSolidWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="PWM"){
   	    		indApplicationDetailsInstance=PlasticWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="EWaste"){
   	    		indApplicationDetailsInstance=EWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="Construction and Demolition"){
   	    		indApplicationDetailsInstance=ConstructionDemolitionWaste.get((applicationPending.applicationId).toLong())
   	    	}else if(appFor=="BATTERY"){
   	    		indApplicationDetailsInstance=BatteryWasteDetails.get((applicationPending.applicationId).toLong())
   	    	}else{
   	    		indApplicationDetailsInstance=BioMedicalWaste.get((applicationPending.applicationId).toLong())
   	    	}
			 
			 
			 
//		    	def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(params.indAppDetId)
		        def indUserIns = (IndUser)(session.indUser)
		    	def abc = IndUser.get(indUserIns.id)
		    	def appPendInst
		    	def testVal = params.testVal
		    	println("testVal "+testVal)
//		    	FormPdf form=new FormPdf()
				def sessValue=(session.indUser).toString()		
		    	float finalPayment = 0;
		    	def industryRegMasterInstance = abc.industryRegMaster
		    	
		    	if(appFor=="HWM"){
		    	def fees = FeeBankDetailsHWM.find("from FeeBankDetailsHWM fee where fee.application=?",[indApplicationDetailsInstance])
				def feeCheque = FeeChequeRecord.find("from FeeChequeRecordHWM afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[indApplicationDetailsInstance])
				if(fees==null)
					{
						
						flash.message="Please Enter Bank Fee Details"
		         	    redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
		           	    return
					}
		    	

					else if(feeCheque==null)			
					{	
				
					flash.message="Please Attach Scan Copy Of all Drafts/Cheques "
						 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
						 return
					  }

		    	
				else
				{
					
				def feeDetailInst = FeeBankDetailsHWM.findAll("from FeeBankDetailsHWM fee where fee.application=?",[indApplicationDetailsInstance])	
					
				for(int i=0; i<feeDetailInst.size(); i++)
				{
					
					finalPayment = finalPayment + feeDetailInst[i].amount
				}
				println("aaaaaaaaaaaaaaaaa...........")
				/*def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
				println("ccccccccc..........."+conFeeInst)
				if(conFeeInst){
					if(conFeeInst.totalFees == finalPayment)
					{
						
					}
					else{
						flash.message="Total Bank Amount should be equal to Total Payable Amount "
							 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
							 return	
						
					}
					
				}*/
				
		    	indApplicationDetailsInstance.completionStatus = "Completed"
		    	indApplicationDetailsInstance.auth_Renew_Date = new Date()
		    	indApplicationDetailsInstance.save()
		    	
		    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
		    
		    if(appPendInst){
		    	appPendInst.completionStatus = "Complete"
		    	appPendInst.lastUpdated = new Date()
		    	appPendInst.save()
		    }
		    
		    	
		    	if(testVal!="true"){
			         
		     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
		     		  if(delPDF!=null){
		     			 
		     		delPDF.delete()
		     		  }
		         
		   		
				 }
		    	

		    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
				}
		    	}else if(appFor=="BMW"){
			    	def fees = FeeBankDetailsBMW.find("from FeeBankDetailsBMW fee where fee.application=?",[indApplicationDetailsInstance])
					def feeCheque = FeeChequeRecordBMW.find("from FeeChequeRecordBMW afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[indApplicationDetailsInstance])
					if(fees==null)
						{
							
							flash.message="Please Enter Bank Fee Details"
			         	    redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
			           	    return
						}
			    	

						else if(feeCheque==null)			
						{	
					
						flash.message="Please Attach Scan Copy Of all Drafts/Cheques "
							 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
							 return
						  }

			    	
					else
					{
						
					def feeDetailInst = FeeBankDetailsBMW.findAll("from FeeBankDetailsBMW fee where fee.application=?",[indApplicationDetailsInstance])	
						
					for(int i=0; i<feeDetailInst.size(); i++)
					{
						
						finalPayment = finalPayment + feeDetailInst[i].amount
					}
					println("aaaaaaaaaaaaaaaaa...........")
				/*	def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
					println("ccccccccc..........."+conFeeInst)
					if(conFeeInst){
						if(conFeeInst.totalFees == finalPayment)
						{
							
						}
						else{
							flash.message="Total Bank Amount should be equal to Total Payable Amount "
								 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
								 return	
							
						}
						
					}*/
					
			    	indApplicationDetailsInstance.completionStatus = "Completed"
			    	indApplicationDetailsInstance.lastUpdated = new Date()
			    	indApplicationDetailsInstance.save()
			    	
			    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
			    
			    if(appPendInst){
			    	appPendInst.completionStatus = "Complete"
			    	appPendInst.lastUpdated = new Date()
			    	appPendInst.save()
			    }
			    
			    	
			    	if(testVal!="true"){
				         
			     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
			     		  if(delPDF!=null){
			     			 
			     		delPDF.delete()
			     		  }
			         
			   		
					 }
			    	

			    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
					}
			    	}else if(appFor=="PWM"){
				    	def fees = FeeBankDetailsPWM.find("from FeeBankDetailsPWM fee where fee.application=?",[indApplicationDetailsInstance])
						def feeCheque = FeeChequeRecordPWM.find("from FeeChequeRecordPWM afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[indApplicationDetailsInstance])
						if(fees==null)
							{
								
								flash.message="Please Enter Bank Fee Details"
				         	    redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
				           	    return
							}
				    	

							else if(feeCheque==null)			
							{	
						
							flash.message="Please Attach Scan Copy Of all Drafts/Cheques "
								 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
								 return
							  }

				    	
						else
						{
							
						def feeDetailInst = FeeBankDetailsPWM.findAll("from FeeBankDetailsPWM fee where fee.application=?",[indApplicationDetailsInstance])	
							
						for(int i=0; i<feeDetailInst.size(); i++)
						{
							
							finalPayment = finalPayment + feeDetailInst[i].amount
						}
						println("aaaaaaaaaaaaaaaaa...........")
					/*	def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
						println("ccccccccc..........."+conFeeInst)
						if(conFeeInst){
							if(conFeeInst.totalFees == finalPayment)
							{
								
							}
							else{
								flash.message="Total Bank Amount should be equal to Total Payable Amount "
									 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
									 return	
								
							}
							
						}*/
						
				    	indApplicationDetailsInstance.completionStatus = "Completed"
				    	indApplicationDetailsInstance.lastUpdated = new Date()
				    	indApplicationDetailsInstance.save()
				    	
				    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
				    
				    if(appPendInst){
				    	appPendInst.completionStatus = "Complete"
				    	appPendInst.completionDate = new Date()
				    	appPendInst.save()
				    }
				    
				    	
				    	if(testVal!="true"){
					         
				     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
				     		  if(delPDF!=null){
				     			 
				     		delPDF.delete()
				     		  }
				         
				   		
						 }
				    	

				    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
						}
				    	}else if(appFor=="MSW"){
							
							def feeDetailInst = FeeBankDetailsMSW.findAll("from FeeBankDetailsMSW fee where fee.application=?",[indApplicationDetailsInstance])	
								
							for(int i=0; i<feeDetailInst.size(); i++)
							{
								
								finalPayment = finalPayment + feeDetailInst[i].amount
							}
							println("aaaaaaaaaaaaaaaaa...........")
						/*	def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
							println("ccccccccc..........."+conFeeInst)
							if(conFeeInst){
								if(conFeeInst.totalFees == finalPayment)
								{
									
								}
								else{
									flash.message="Total Bank Amount should be equal to Total Payable Amount "
										 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
										 return	
									
								}
								
							} */
							
					    	indApplicationDetailsInstance.completionStatus = "Completed"
					    	indApplicationDetailsInstance.lastUpdated = new Date()
					    	indApplicationDetailsInstance.save()
					    	
					    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
					    
					    if(appPendInst){
					    	appPendInst.completionStatus = "Complete"
					    	appPendInst.completionDate = new Date()
					    	appPendInst.save()
					    }
					    
					    	
					    	if(testVal!="true"){
						         
					     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
					     		  if(delPDF!=null){
					     			 
					     		delPDF.delete()
					     		  }
					         
					   		
							 }
					    	

					    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
							}else if(appFor=="EWaste"){
								
								def feeDetailInst = FeeBankDetailsEwaste.findAll("from FeeBankDetailsEwaste fee where fee.application=?",[indApplicationDetailsInstance])	
									
								for(int i=0; i<feeDetailInst.size(); i++)
								{
									
									finalPayment = finalPayment + feeDetailInst[i].amount
								}
								println("aaaaaaaaaaaaaaaaa...........")
							/*	def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
								println("ccccccccc..........."+conFeeInst)
								if(conFeeInst){
									if(conFeeInst.totalFees == finalPayment)
									{
										
									}
									else{
										flash.message="Total Bank Amount should be equal to Total Payable Amount "
											 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
											 return	
										
									}
									
								}  */
								
						    	indApplicationDetailsInstance.completionStatus = "Completed"
						    	indApplicationDetailsInstance.lastUpdated = new Date()
						    	indApplicationDetailsInstance.save()
						    	
						    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
						    
						    if(appPendInst){
						    	appPendInst.completionStatus = "Complete"
						    	appPendInst.completionDate = new Date()
						    	appPendInst.save()
						    }
						    
						    	
						    	if(testVal!="true"){
							         
						     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
						     		  if(delPDF!=null){
						     			 
						     		delPDF.delete()
						     		  }
						         
						   		
								 }
						    	

						    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
								}else if(appFor=="Construction and Demolition"){
									
									def feeDetailInst = FeeBankDetailsConsDemoli.findAll("from FeeBankDetailsConsDemoli fee where fee.application=?",[indApplicationDetailsInstance])	
										
									for(int i=0; i<feeDetailInst.size(); i++)
									{
										
										finalPayment = finalPayment + feeDetailInst[i].amount
									}
									println("aaaaaaaaaaaaaaaaa...........")
								/*	def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
									println("ccccccccc..........."+conFeeInst)
									if(conFeeInst){
										if(conFeeInst.totalFees == finalPayment)
										{
											
										}
										else{
											flash.message="Total Bank Amount should be equal to Total Payable Amount "
												 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
												 return	
											
										}
										
									} */
									
							    	indApplicationDetailsInstance.completionStatus = "Completed"
							    	indApplicationDetailsInstance.lastUpdated = new Date()
							    	indApplicationDetailsInstance.save()
							    	
							    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
							    
							    if(appPendInst){
							    	appPendInst.completionStatus = "Complete"
							    	appPendInst.completionDate = new Date()
							    	appPendInst.save()
							    }
							    
							    	
							    	if(testVal!="true"){
								         
							     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
							     		  if(delPDF!=null){
							     			 
							     		delPDF.delete()
							     		  }
							         
							   		
									 }
							    	

							    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
									}else if(appFor=="BATTERY"){
										
										def feeDetailInst = BatteryFeeBankDetails.findAll("from BatteryFeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])	
											
										for(int i=0; i<feeDetailInst.size(); i++)
										{
											
											finalPayment = finalPayment + feeDetailInst[i].amount
										}
										println("aaaaaaaaaaaaaaaaa...........")
									/*	def conFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[indApplicationDetailsInstance.toString()])
										println("ccccccccc..........."+conFeeInst)
										if(conFeeInst){
											if(conFeeInst.totalFees == finalPayment)
											{
												
											}
											else{
												flash.message="Total Bank Amount should be equal to Total Payable Amount "
													 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
													 return	
												
											}
											
										} */
										
								    	indApplicationDetailsInstance.completionStatus = "Completed"
								    	indApplicationDetailsInstance.save()
								    	
								    appPendInst = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
								    
								    if(appPendInst){
								    	appPendInst.completionStatus = "Complete"
								    	appPendInst.completionDate = new Date()
								    	appPendInst.save()
								    }
								    
								    	
								    	if(testVal!="true"){
									         
								     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
								     		  if(delPDF!=null){
								     			 
								     		delPDF.delete()
								     		  }
								         
								   		
										 }
								    	

								    	render(view:'confirmPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
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

def addBankName={


		
		println("----PARAMS in addBankName----"+params);
		try{
			def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(params.indAppDetId)
    		def bankTransaction = new BankTransactionDetailsHWM()
    		def bank
    		def fees = session.getAttribute("fee");
			def appFor="BMW"
    		if (true){

    			def id = session.getAttribute("random")
		    	bankTransaction.bankId = ""
		    	bankTransaction.amount = session.getAttribute("fee")
		    	bankTransaction.bankName = "Tech Process"
		    	bankTransaction.indApplication = indApplicationDetailsInstance
		    	bankTransaction.dateCreated = new Date()
		    	bankTransaction.lastUpdated = new Date()
		    	bankTransaction.transactionStatus = "F"
		    	bankTransaction.paymentType=""
		    	bankTransaction.id = id
		    	bankTransaction.paymentGateway="BILLDESK"
		    	println("bankTransaction.bankName.id--"+bankTransaction.id)    	
		    	bankTransaction.save()   	
            	
		    	def waterCess = "0"
		        def nocFee = "0"
			    def waterCons = "0"
			    def airCons = "0"
				def ctobothFee = "0"
				def bmw = "0"
				def testingFee = "0"
				def ebg = "0"
				def hmw = "0"
				def ihw = "0"
				def formFee = "0"
			    def misc = "0"
				
			    
			    def group1 = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
		        println("group1---------"+group1)
		        def group = group1.group.groupName
		        def feesOnline = FeeBankOtherDetailsHWM.findAll("from FeeBankOtherDetailsHWM fee where fee.application=?",[indApplicationDetailsInstance])
				println("feesOnline.......>>>>>"+feesOnline.feeFor)
			
		        
	            def indName = indApplicationDetailsInstance.id
	          	def indAddress = indApplicationDetailsInstance.industryRegMasterObj.indAddress
	            def indEmail = indApplicationDetailsInstance.industryRegMasterObj.indEmail
	            println("indName----"+indName)
	            println("indEmail----"+indEmail)
	          	
	            String industryName = indName
	            String merchantCode = indAddress
            	
            	String fee = session.getAttribute("fee")
            	String bankCode ="NA"
            	String industryEmail = indEmail
            	println("feefeefeefeefeefee.......----"+fee)
            	println("industryName----"+industryName)
                println("industryEmail----"+industryEmail)
            	def industryName1 = indApplicationDetailsInstance.industryRegMasterObj.indName
            	VenderRegistration venderRegistrationObj=new VenderRegistration();
                def indNameD=venderRegistrationObj.ReplaceSpecialChar(industryName1)
                println("indNameD-----------------------"+indNameD)
                println(".....priyanka....."+fee.getClass().getName())
            	String txnAmount="0.00"
                if(fee)
                 {
                     txnAmount=fee+""
                 }
                String txnAmount1="0.0"
                if(fee){
                	
                    txnAmount1=fee
                    
                   }
                String shoppingCart="JKPCB_"+txnAmount1+"_0.0"
                String customerId = id    		
                println("......txnAmount....."+txnAmount);
                println("......shoppingCart....."+shoppingCart);
                println("......customerId....."+customerId.getClass().getName());
                println("......industryName....."+industryName.getClass().getName());
                println("......industryEmail....."+industryEmail.getClass().getName());
                  
                def sdfh = new SimpleDateFormat("dd-MM-yyyy"); 
                println("......sdfh.format(new Date())....."+sdfh.format(new Date()));
                String checksum = "Zio5SNM7a47U"
                String merchantId = "JKZPOLCBR"
                String securityId = "jkzpolcbr"
                def transDate = sdfh.format(new Date());
               //def url = "http://164.100.163.18/JKPCB/hazardeousWasteAuthApp/responsePageHDFC"
                def url="https://jkocmms.nic.in/WasteManagementPendingDetails/responsePageHDFC"
                //def url="http://localhost:8080/JKPCB/hazardeousWasteAuthApp/responsePageHDFC"
                println("......securityId....."+securityId.getClass().getName());
                println("......transDate....."+transDate.getClass().getName());
                println("......transDate.toString()...."+transDate.toString().getClass().getName());
                println("......indNameD....."+indNameD.getClass().getName());
                //def transValue = "JKZPOLCBR"+"|"+customerId+"|"+"NA"+"|"+txnAmount+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"INR"+"|"+"NA"+"|"+"R"+"|"+securityId+"|"+"NA"+"|"+"NA"+"|"+"F"+"|"+industryName+"|"+industryEmail+"|"+indNameD+"|"+transDate.toString()+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+url;
                //def transValue = "JKZPOLCBR"+"|"+customerId+"|"+"NA"+"|"+txnAmount+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"INR"+"|"+"NA"+"|"+"R"+"|"+securityId+"|"+"NA"+"|"+"NA"+"|"+"F"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+url;
                def transValue = "JKZPOLCBR"+"|"+customerId+"|"+"NA"+"|"+txnAmount+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"INR"+"|"+"NA"+"|"+"R"+"|"+securityId+"|"+"NA"+"|"+"NA"+"|"+"F"+"|"+industryName+"|"+industryEmail+"|"+indNameD+"|"+transDate.toString()+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+url;
        		println("transValue in bank name---------"+transValue)
                TestHMac checksumGenerate=new TestHMac();
                def checksumValue=checksumGenerate.HmacSHA256(transValue,checksum)
                println("checksumValue---------"+checksumValue)
                String msg = transValue+"|"+checksumValue
                println("msg---------"+msg)
                //response.sendRedirect(msg)
                response.sendRedirect("https://pgi.billdesk.com/pgidsk/PGIMerchantPayment?msg="+msg);
                //render(view:'bankName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction,strMsg:msg])
        	}
    		
    	}catch(Exception e) {
    	e.printStackTrace();
       }
}
   def responsePageHDFC={

    			
    			
    			println("===Session in responsePageHDFC======="+session)
        		def testVal1=session.getAttribute("testVal1");
        		println("===testVal1============"+testVal1);
        	          
        		String msg = request.getParameter("msg")
        		
        		println("4 msg: " + msg)
        		
        		String aa = msg
        		String merchantId = "";
    	    	String transId = "";
    	    	String billDeskId = "";
    	    	String value1 = "";
    	    	String txnAmount = "";
    	
    	    	String bankId = "";
    	    	String value2 = "";
    	    	String txnType = "";
    	    	
    	    	String CurrencyType = "";
    	    	String  type2= "";
    	    	String value4 = ""; 
    	    	String value5 = "";
    	    	String value6 = "";
    	    	String transDateB = "";
    	    	String strAuthStatus = "";
    	    	String value7 = "";
    	    	String appNo = "";
    	    	String indMail = "";
    	    	String indName = "";
    	    	String transDateK = "";
    	    	String value8 = "";
    	    	String value9 = "";
    	    	String value10 = "";
    	    	String value11 = "";
    	    	String strErrorDescription = "";
    	    	String msgChecksum = "";

        		StringTokenizer token = new StringTokenizer(aa,"|");
        		println("5 token: "+token)
        		println("6 token.countTokens(): "+token.countTokens())
        		if(token.countTokens()>0){
        			
        			merchantId = token.nextToken();
        			transId = token.nextToken();
        			billDeskId = token.nextToken();
        			value1 = token.nextToken();
        			txnAmount = token.nextToken();
        			bankId = token.nextToken();
        			value2 = token.nextToken();
        			txnType = token.nextToken();
        			CurrencyType = token.nextToken();
        			type2= token.nextToken();
        			value4 = token.nextToken(); 
        			value5 = token.nextToken();
        			value6 = token.nextToken();
        			transDateB = token.nextToken();
        			strAuthStatus = token.nextToken();
        			value7 = token.nextToken();
        			appNo = token.nextToken();
        			indMail = token.nextToken();
        			indName = token.nextToken();
        			transDateK = token.nextToken();
        			value8 = token.nextToken();
        			value9 = token.nextToken();
        			value10 = token.nextToken();
        			value11 = token.nextToken();
        			strErrorDescription = token.nextToken();
        			msgChecksum = token.nextToken();

    		}
    		else{
    			
    			System.out.println("7 token.countTokens()>0 is false");
    		}
        		def transInstance = BankTransactionDetailsHWM.get(transId) 
        		def appId = transInstance.indApplication
        	    println("1 appId: " + appId)
        	    def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(appId.id)
        	    println("2 responsePage1=>indApplicationDetailsInstance: " + indApplicationDetailsInstance)
        	    def indName1 = indApplicationDetailsInstance.industryRegMasterObj.indName
              	String industryName = indApplicationDetailsInstance.id
              	def indEmail = indApplicationDetailsInstance.industryRegMasterObj.indEmail
              	String industryEmail = indEmail
              	def bioAppId=indApplicationDetailsInstance.id
              	def appPendingInst = WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=?",[String.valueOf(bioAppId)]) 
        		println("8 transId: " + transId)
        		println("9 billDeskId: " + billDeskId)
        		println("10 msgChecksum: " + msgChecksum)
        		def inst = "HWM"
        		def inst1 = "HWM"
        		def inst2 = indApplicationDetailsInstance.is_Renew
        		def val = indApplicationDetailsInstance.industryRegMasterObj
        		def occName = val.occName
        		def fee = transInstance.amount
        		if(session.appId){
        			
        		}else{
        			  session.fee = transInstance.amount
        			   
        			  session.indregName = indApplicationDetailsInstance.industryRegMasterObj
        			  session.appId = indApplicationDetailsInstance.id
        			  session.cafUniqueNo=indApplicationDetailsInstance.cafUniqueNo
        			  session.serviceId=indApplicationDetailsInstance.serviceId
        			  session.login = "xyz"
        			  def insUser=IndUser.findByIndustryRegMaster(indApplicationDetailsInstance.industryRegMasterObj)
        			  session.indUser =insUser 
        			  session.random = transInstance.id
        			  
        		}
        		String checksum = "Zio5SNM7a47U"
        		println("11 inst: " + inst)
        		println("12 inst1: " + inst1)
        		println("13 inst2: " + inst2)
        		println("14 val: " + val)
        		println("15 occName: " + occName)
        		println("16 fee: " + fee)
        		String aa1 = msg;
                String msgChecksum1 = "";
                
                String[] msgbreak=aa1.split("\\|");
                println("17 msgbreak: " + msgbreak)
                msgChecksum1=msgbreak[msgbreak.length-1];
                println("18 msgChecksum1: " + msgChecksum1)
                
                String finalmsg="";
                boolean checksumMatch = false;
         
                println("19 msgbreak.length: " + msgbreak.length)
       		    for(int i=0;i<msgbreak.length-1;i++)
       		    {
       		    	println("20 i: " + i)
       		    	println("21 i==msgbreak.length-2: " + i==msgbreak.length-2)
       		    	println("22 !(i==msgbreak.length-2): " + !(i==msgbreak.length-2))
       		    	if(!(i==msgbreak.length-2)){
       		    		finalmsg=finalmsg+msgbreak[i]+"|";
    	    			println("23 inside if")
    	    			println("24 finalmsg: " + finalmsg)
       		    	}else{
       		    		finalmsg=finalmsg+msgbreak[i];
       		    		println("25 inside else")
    	    			println("26 finalmsg: " + finalmsg)
       		    	}
       		    	
       		    }
       		    System.out.println("27 after for loop finalmsg: "+finalmsg);
       		    TestHMac checksumGenerate=new TestHMac();
       		    println("28 checksumGenerate: " + checksumGenerate)
       		    def checksumres=checksumGenerate.HmacSHA256(finalmsg,checksum)
       		    println("29 checksumres: " + checksumres)
       		    println("30 checksumres==msgChecksum: " + checksumres==msgChecksum)
       		    if(checksumres==msgChecksum)
       		    {
       		    	System.out.println("31 In side True");
       		    	checksumMatch = true;
       		    	
       		    }else{
       		    	
       		    	System.out.println("32 not same....");
       		    }
       		    println("33 checksumMatch: " + checksumMatch)
       		    println("34 strAuthStatus: " + strAuthStatus)
       		    println("35 strAuthStatus.equals(\"0300\"): " + strAuthStatus.equals("0300"))
       		    if(checksumMatch && strAuthStatus.equals("0300"))
       		    {
       		    	
       			       	
                   	println("36 transInstance: "+transInstance)
                   	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
                   	def feeDetailsList = FeeBankOtherDetailsHWM.findAllByApplication(indApplicationDetailsInstance)
                    def a
                   	println("37 testVal1==\"true\": " + testVal1=="true")
           			if(testVal1=="true"){
           				RouteWasteManagement routeWaste=new RouteWasteManagement()
           				def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,"HWM",val)
           		    	updateAllSummaryReportWMS((indApplicationDetailsInstance.id).toString());// all summary
           		     }else{
           		    	RouteWasteManagement routeWaste=new RouteWasteManagement()
           				def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,"HWM",val)
           		    	updateAllSummaryReportWMS((indApplicationDetailsInstance.id).toString());// all summary
           		      }
       			   transInstance.transactionStatus = "S"
       			   println("40 transInstance.transactionStatus: " + transInstance.transactionStatus)
       			   println("41 txnType: " + txnType)
       			   if(txnType=="01"){
       				transInstance.paymentType="Net Banking"
       			   }else if(txnType=="02"){
       				transInstance.paymentType="Credit"
       			   }else if(txnType=="03"){
       				transInstance.paymentType="Debit"
       			   }else if(txnType=="04"){
       				transInstance.paymentType="Cash Card"
       			   }else if(txnType=="05"){
       				transInstance.paymentType="Mobile Wallet"
       			   }else if(txnType=="06"){
       				transInstance.paymentType="IMPS"
       			   }else if(txnType=="07"){
       				transInstance.paymentType="Reward Points"
       			   }else if(txnType=="08"){
       				transInstance.paymentType="Rupay"
       			   }else {
       				transInstance.paymentType=""
       			   }
       			   println("42 transInstance.paymentType: " + transInstance.paymentType)
       			   
       			   transInstance.bankName = "NA"
       			   transInstance.bankId = bankId
       			   transInstance.lastUpdated = new Date()
       		    	
       			 if(transInstance.save()){
       				 println("43 transInstance is saved successfully")
       				 println("44 transInstance.transactionStatus: " + transInstance.transactionStatus)
       			  }
                 else{
               	   	if(transInstance.hasErrors()){
                		 transInstance.errors.allErrors.each {
                			 println it
                	}
               	  } 
                }
       			println("45 after bank transaction instance is saved \ntransInstance.transactionStatus: " + transInstance.transactionStatus)
       			println("46 testVal1==\"true\": " + testVal1=="true")
     	        if(testVal1=="true"){
     	    	   println("47 redirecting to view=onlinePaymentReciept")
     	    	   render(view:'onlinePaymentReciept',model:[indApplicationDetailsInstance:indApplicationDetailsInstance.id,feeDetailsList:feeDetailsList,
              	                                            group:group.group.groupName,strMarketCode:transId,strCSTBANKID:"",
             	                                            dateVal:transInstance.lastUpdated,strTxnAmount:txnAmount,
             	                                            status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,
             	                                            testVal1:testVal1,transInstance:transInstance])
               }
     	       else{
     	    	   println("48 redirecting to view=challanFormGateway")
     	           render(view:'challanFormGateway',model:[indApplicationDetailsInstance:indApplicationDetailsInstance.id,feeDetailsList:feeDetailsList,
     	                                            group:group.group.groupName,strMarketCode:transId,strCSTBANKID:"",
     	                                            dateVal:transInstance.lastUpdated,strTxnAmount:txnAmount,
     	                                            status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,
     	                                            testVal1:testVal1,transInstance:transInstance])
     	    	   }
                }
       		    else{
       		    	strAuthStatus = "0399"; 
       		    	redirect(action:payment,id:indApplicationDetailsInstance.id)   
       		    	return
       		 }		
    	
    	}
   }

