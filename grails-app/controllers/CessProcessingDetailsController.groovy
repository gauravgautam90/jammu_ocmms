import groovy.sql.Sql

import java.lang.Exception
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File
import java.io.FileInputStream
import java.lang.NumberFormatException
//import org.apache.commons.fileupload.DiskFileUpload
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile

class CessProcessingDetailsController {

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
    	        [ cessProcessingDetailsInstanceList: CessProcessingDetails.list( params ), cessProcessingDetailsInstanceTotal: CessProcessingDetails.count() ]
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
    			 def cessProcessingDetailsInstance = CessProcessingDetails.get( params.id )
    			 if(!cessProcessingDetailsInstance) {
    	            flash.message = "CessProcessingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ cessProcessingDetailsInstance : cessProcessingDetailsInstance ] }
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
        def cessProcessingDetailsInstance = CessProcessingDetails.get( params.id )
        if(cessProcessingDetailsInstance) {
            try {
                cessProcessingDetailsInstance.delete()
                flash.message = "CessProcessingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CessProcessingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "CessProcessingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    			 def cessProcessingDetailsInstance = CessProcessingDetails.get( params.id )
    			 if(!cessProcessingDetailsInstance) {
    	            flash.message = "CessProcessingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ cessProcessingDetailsInstance : cessProcessingDetailsInstance ]
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
    	        def cessProcessingDetailsInstance = CessProcessingDetails.get( params.id )
    	        if(cessProcessingDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(cessProcessingDetailsInstance.version > version) {
    	                    cessProcessingDetailsInstance.errors.rejectValue("version", "cessProcessingDetails.optimistic.locking.failure", "Another user has updated this CessProcessingDetails while you were editing.")
    	                    render(view:'edit',model:[cessProcessingDetailsInstance:cessProcessingDetailsInstance])
    	                    return
    	                }
    	            }
    	            cessProcessingDetailsInstance.properties = params
    	            if(!cessProcessingDetailsInstance.hasErrors() && cessProcessingDetailsInstance.save()) {
    	                flash.message = "CessProcessingDetails ${params.id} updated"
    	                redirect(action:show,id:cessProcessingDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[cessProcessingDetailsInstance:cessProcessingDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "CessProcessingDetails not found with id ${params.id}"
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
    	        def cessProcessingDetailsInstance = new CessProcessingDetails()
    	        cessProcessingDetailsInstance.properties = params
    	        return ['cessProcessingDetailsInstance':cessProcessingDetailsInstance]
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
    	        def cessProcessingDetailsInstance = new CessProcessingDetails(params)
    	        if(!cessProcessingDetailsInstance.hasErrors() && cessProcessingDetailsInstance.save()) {
    	            flash.message = "CessProcessingDetails ${cessProcessingDetailsInstance.id} created"
    	            redirect(action:show,id:cessProcessingDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[cessProcessingDetailsInstance:cessProcessingDetailsInstance])
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
    
   
    def cessProcessing = {
    	 try {
    	    	def cessReturnApp = CessReturn.get((params.id).toLong())
    	    	def cessAssessOrderInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='AssessmentOrder' order by crf.id desc",[cessReturnApp],[max:1])
    	    	def cessAssessOrderFinalInstance
    	    	if(cessAssessOrderInstance){
    	    	 cessAssessOrderFinalInstance=cessAssessOrderInstance[0]
    	    	}
    	    	def cessAssessfeeDefaulterList=CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='feeDefaulterNotice' order by crf.id desc",[cessReturnApp],[max:1])
    	    	def cessAssessfeeDefaulter
    	    	if(cessAssessfeeDefaulterList){
    	    		cessAssessfeeDefaulter=cessAssessfeeDefaulterList[0]
    	    	}
    	    	def cessAssessissueInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='AssessmentIssue' order by crf.id desc",[cessReturnApp],[max:1])
    	    	def cessAssessIssueFinalInstance
    			 if(cessAssessissueInstance){
    				 cessAssessIssueFinalInstance=cessAssessissueInstance[0]
    			 }
    	    	def app = CessPendingDetails.findByCessReturn(cessReturnApp)
    	    	def roleHeader=app.role.roleName
    	    	def roleActList = CessRoleVsActivity.findAllByRole(app.role)
    	    	def actionList = new ArrayList()
    	    	def assessmentIssue = false
    	    	def assessmentOrder = false
    	    	def feeDefaulterNotice = false
    	    	def inspection=false
    	    	def inspectionClose=false
    	    	def appCompleted=false
    	    	
    	    	def fwdRoleList = new ArrayList()
    	    	
    	    	def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
    	    	for(int i=0;i<workFlowMasterList.size();i++){ 
    	    		fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
    	    	}
    	    	actionList.add(CessActivityMaster.findWhere(activityCode:"002"))
    	    	for(int i=0;i<roleActList.size();i++){
    	    		 if((roleActList.get(i)).activity.activityCode == "002"){
    	    			assessmentIssue = true
    	    		}else if((roleActList.get(i)).activity.activityCode == "003"){
    	    			assessmentOrder = true
    	    		}else if((roleActList.get(i)).activity.activityCode == "004"){
    	    			feeDefaulterNotice = true
    	    		}else if((roleActList.get(i)).activity.activityCode == "005"){
    	    			inspection = true
    	    		}else if((roleActList.get(i)).activity.activityCode == "006"){
    	    			appCompleted = true
    	    		}else if((roleActList.get(i)).activity.activityCode == "007"){
    	    			inspectionClose = true
    	    		}
    	    	}
    	    	def applicationProcessingDetailsInstanceList =  CessProcessingDetails.findAllByCessreturn(cessReturnApp,[sort:'dateCreated',order:'desc',offset:0])
    	    	if(applicationProcessingDetailsInstanceList){
    	    		def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
    	        	model:[cessAssessfeeDefaulter:cessAssessfeeDefaulter,cessAssessIssueFinalInstance:cessAssessIssueFinalInstance,cessAssessOrderFinalInstance:cessAssessOrderFinalInstance,roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app,appCompleted:appCompleted,inspection:inspection,inspectionClose:inspectionClose]
    	    	}else{
    	    		model:[cessAssessfeeDefaulter:cessAssessfeeDefaulter,cessAssessIssueFinalInstance:cessAssessIssueFinalInstance,cessAssessOrderFinalInstance:cessAssessOrderFinalInstance,roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:null,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app,appCompleted:appCompleted,inspection:inspection,inspectionClose:inspectionClose]
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
    
    def processCessApp = {
    	 try {
    	    	def redirectBack = false
    	    	CessReturnFileRecord file=new CessReturnFileRecord()
    	    	def applicationPending = CessPendingDetails.get((params.appId).toLong())
    	    	def indAppInstance=applicationPending.cessReturn
    	    	def rVa = CessRoleVsActivity.findWhere(role:applicationPending.role, activity:CessActivityMaster.findByActivityCode("001")) 
    	    	if(rVa){
    	    		def list = CessPendingDetails.findAllByCessReturn(applicationPending.cessReturn)
    	    		for(int i=0;i<list.size();i++){
    	    			if(list.get(i)!=applicationPending){
    	    				(list.get(i)).delete()
    	    			}
    	    		}
    	    	}
    	    	def roleFwd = RoleMaster.get((params.forward).toLong())
    	    	def applicationProcessingDetails = new CessProcessingDetails()
    	    	applicationProcessingDetails.role = applicationPending.role
    	    	def user = session.userMaster
    	    	user.refresh()
    	    	applicationProcessingDetails.officer = user.userProfile.id
    	    	applicationProcessingDetails.fileNote = params.fileNote
    	    	applicationProcessingDetails.roleFwd = roleFwd
    	    	applicationProcessingDetails.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
    	    	if((params.assessmentOrderRadio).equals("yes")){
    	    		def indcessApp = applicationPending.cessReturn
    	    		def checkAssessmentIssue=CessReturnFileRecord.findAll("from CessReturnFileRecord as crfr where crfr.cessReturn=? and crfr.typeOfFile='AssessmentOrder'",[indcessApp])
    	    		if(!checkAssessmentIssue){
    	    			flash.message = "Please Generate First Assessment Order."
    	            		redirectBack = true
    	    		}else if(indcessApp.assessmentOrder){
    	    			flash.message = "Assessment Order already raised on this application"
    	        		redirectBack = true
    	    		}else{
    	    			indcessApp.assessmentOrder=true
    	    			indcessApp.save()
    	    			applicationProcessingDetails.assessmentOrder=true
    	    			applicationProcessingDetails.assessmentOrderNote=params.assessmentOrderNote
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.assessmentOrder=false
    				applicationProcessingDetails.assessmentOrderNote=""
    	    	}
    	    	
    	    	if((params.inspection).equals("yes")){ 
    	    		def indcessApp = applicationPending.cessReturn
    	    		if(indcessApp.inspection){
    	    			flash.message = "Inspection already Raised on this application"
    	    			redirectBack = true
    	    		}else{
    	    			indcessApp.inspection = true
    	    			indcessApp.save()
    	        		applicationProcessingDetails.inspection = true
    	        		applicationProcessingDetails.inspectionNote = params.inspectionNote
    	        			
    	            	def f = request.getFile('attachInspectionReport')
    	            	MultipartFile multi = request.getFile('attachInspectionReport')
    	            	if(!f.empty) {
    	            		 applicationProcessingDetails.inspectionAttachedFile = true
    	            		 def applicationFileRecordInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord afr where afr.cessReturn=? and afr.typeOfFile='attachedInspectionReport' order by afr.id desc",[indAppInstance],[max:1])
    	            		 if(applicationFileRecordInstance){
    	            			 file.version =applicationFileRecordInstance[0].version+1
    	            		 }
    	            		 file.size = multi.getSize() / 1024
    	            		 if(file.size<=6000){
    	            		 file.name =multi.getOriginalFilename()
    	            			file.data=multi.getBytes() 
    	            	        file.extension = extractExtension( multi )
    	            		    file.description="Application attached Inspection Report"
    	            		 	if(session.userMaster){
    	            		 		file.createdBy=session.userMaster
    	            		 		file.updatedBy=session.userMaster
    	            		 	}else {
    	            		 		file.createdBy=session.indUser
    	            		 		file.updatedBy=session.indUser
    	            		 	  }
    	            	      file.typeOfFile="attachedInspectionReport"
    	            		    	file.cessReturn=indAppInstance  
    	            		    	file.cessAppliedFromDate=indAppInstance.cessAppliedFromDate
    	            		    		file.cessAppliedToDate=indAppInstance.cessAppliedToDate
    	            		    		file.indreg=indAppInstance.industryReg
    	            		    if(file.save()) {
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
    	    	}
    	    	else{
    	    		applicationProcessingDetails.inspection = false
    	    		applicationProcessingDetails.inspectionNote = ""
    	    	}
    	    	
    	    	if((params.inspectionClose).equals("yes")){ 
    	    		def noteHistiryFile=new ApplicationFileRecord()
    	    		def indcessApp = applicationPending.cessReturn
    	    		if(!indcessApp.inspection){
    	    			flash.message = "Inspection not Raised on this application"
    	    				redirectBack = true
    	    		}else{
    	    		def f = request.getFile('inspectionReport')
    	    		MultipartFile multi = request.getFile('inspectionReport')
    	            	if(!f.empty) {
    	            		 applicationProcessingDetails.inspectionCloseAttachedFile =true
    	            		 def applicationFileRecordInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord afr where afr.cessReturn=? and afr.typeOfFile='InspectionCloseReport' order by afr.id desc",[indAppInstance],[max:1])
    	            		 if(applicationFileRecordInstance){
    	            			 file.version =applicationFileRecordInstance[0].version+1
    	            		 }
    	            		 file.size = multi.getSize() / 1024
    	            		 if(file.size<=6000){
    	            		 file.name =multi.getOriginalFilename()
    	            			file.data=multi.getBytes() 
    	            	        file.extension = extractExtension( multi )
    	            		    file.description="Application attached Inspection Report"
    	            		 	if(session.userMaster){
    	            		 		file.createdBy=session.userMaster
    	            		 		file.updatedBy=session.userMaster
    	            		 	}else {
    	            		 		file.createdBy=session.indUser
    	            		 		file.updatedBy=session.indUser
    	            		 	  }
    	            	      file.typeOfFile="InspectionCloseReport"
    	            		    	file.cessReturn=indAppInstance  
    	            		    	file.cessAppliedFromDate=indAppInstance.cessAppliedFromDate
    	            		    		file.cessAppliedToDate=indAppInstance.cessAppliedToDate
    	            		    		file.indreg=indAppInstance.industryReg
    	            		    if(file.save()) {
    	            		       
    	            		       } else {
    	            		    	  redirect(action:'appProcessing',params:["id":indApp.id])
    	            		          }
    	            		 }
    	          			else {
    	          				flash.message = "Attachment File Size is More Then 5 Mb"
    	          			    redirectBack = true
    	          			}
    	        	}
    	          	indcessApp.inspection = false
    	    			indcessApp.save()
    	        		applicationProcessingDetails.inspectionClose = true
    	        		applicationProcessingDetails.inspectionCloseNote = params.inspectionCloseNote
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.inspectionClose = false
    	    		applicationProcessingDetails.inspectionCloseNote = ""
    	    	}
    	    	
    	    	if((params.assessmentIssue).equals("yes")){
    	    		def indcessApp = applicationPending.cessReturn
    	    		def checkAssessmentIssue=CessReturnFileRecord.findAll("from CessReturnFileRecord as crfr where crfr.cessReturn=? and crfr.typeOfFile='AssessmentIssue'",[indcessApp])
    	    		if(!checkAssessmentIssue){
    	    			flash.message = "Please Generate First Pre Assessment Notice."
    	            		redirectBack = true
    	    		}else if(indcessApp.assessmentIssue){
    	    			flash.message = "Pre-Assessment notice already raised on this application"
    	        		redirectBack = true
    	    		}else{
    	    			indcessApp.assessmentIssue=true
    	    			indcessApp.save()
    	    			applicationProcessingDetails.assessmentIssue=true
    	    			applicationProcessingDetails.assessmentIssueNote=params.assessmentIssueNote
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.assessmentIssue=false
    	    		applicationProcessingDetails.assessmentIssueNote=""
    	    	}
    	    	
    	    	if((params.feeDefaulterNoticeRadio).equals("yes")){
    	    		def indcessApp = applicationPending.cessReturn
    	    		def checkAssessmentIssue=CessReturnFileRecord.findAll("from CessReturnFileRecord as crfr where crfr.cessReturn=? and crfr.typeOfFile='feeDefaulterNotice'",[indcessApp])
    	    		if(!checkAssessmentIssue){
    	    			flash.message = "Please Generate First Fee Defaulter Notice."
    	            		redirectBack = true
    	    		}else if(indcessApp.feesNotice){
    	    			flash.message = "Fee Notice is already raised on this application"
    	        		redirectBack = true
    	    		}else{
    	    			indcessApp.feesNotice=true
    	    			indcessApp.save()
    	    			applicationProcessingDetails.feeDefaulterNotice=true
    	    			applicationProcessingDetails.feeDefaulterNoticeNote=params.feeDefaulterNoticeRadio
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.feeDefaulterNotice=false
    				applicationProcessingDetails.feeDefaulterNoticeNote=""
    	    	}
    	    	
    	    	if((params.applicationCompleted).equals("yes")){
    	    		def indcessApp = applicationPending.cessReturn
    	    		if(!indcessApp.fees){
    	    			flash.message = "Fee Details not sent by Industry"
    	            		redirectBack = true
    	    		}else{
    	    			
    	    			indcessApp.applicationStatus="Completed"
    	    				indcessApp.save()
    	    		applicationPending.applicationStatus="completed"
    	    			applicationProcessingDetails.finish=true
    	    			applicationProcessingDetails.finishNote=params.assessmentOrderNote
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.finishNote=""
    					applicationProcessingDetails.finish=false
    	    	}
    	    	
    				applicationProcessingDetails.assessmentIssueClose=false
    				applicationProcessingDetails.assessmentIssueCloseNote=""
    					
    	    	if(redirectBack){
    	    		def indApp = applicationPending.cessReturn
    	    		redirect(action:'cessProcessing',params:["id":indApp.id])
    	    	}else{
    	    		applicationProcessingDetails.cessreturn = applicationPending.cessReturn
    	        	if( applicationProcessingDetails.save() ) {
    	        		def file11 = new CessReturnFileRecord()
    	        	    	def f11 = request.getFile('attachLetter')
    	        	    	MultipartFile multi11 = request.getFile('attachLetter')
    	        	    	if(!f11.empty) {
    	        	    		
    	        	    		applicationProcessingDetails.attachedFile = true
    	        	    		 def applicationFileRecordInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord afr where afr.cessReturn=? and afr.typeOfFile='attachLetter' order by afr.id desc",[indAppInstance],[max:1])
    	        	    		 if(applicationFileRecordInstance){
    	        	    			 file11.version =applicationFileRecordInstance[0].version+1
    	        	    		 }
    	        	    		 file11.size = multi11.getSize() / 1024
    	        	    		 if(file11.size<=6000){
    	        	    		 file11.name =multi11.getOriginalFilename()
    	        	    			file11.data=multi11.getBytes() 
    	        	    	        file11.extension = extractExtension( multi11 )
    	        	    		    file11.description="Attach other file if any"
    	        	    		 	if(session.userMaster){
    	        	    		 		file11.createdBy=session.userMaster
    	        	    		 		file11.updatedBy=session.userMaster
    	        	    		 	}else {
    	        	    		 		file11.createdBy=session.indUser
    	        	    		 		file11.updatedBy=session.indUser
    	        	    		 	  }
    	        	    	      file11.typeOfFile="attachLetter"
    	        	    		    	file11.cessReturn=indAppInstance  
    	        	    		    	file11.cessAppliedFromDate=indAppInstance.cessAppliedFromDate
    	        	    		    		file11.cessAppliedToDate=indAppInstance.cessAppliedToDate
    	        	    		    		file11.indreg=indAppInstance.industryReg
    	        	    		    if(file11.save()) {
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
    	        			applicationProcessingDetails.errors.each {
    	        		   }
    	        		}
    	    		applicationPending.role = roleFwd
    	        	applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
    	        	applicationPending.save()
    	     
    	        	redirect(controller:'userMaster',action:'openSpcbHome')
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
    
    def openApplicationDetails = {
    		 try {
    		    	def application = CessReturn.get((params.id).toLong())
    		    	def applicationProcessingDetailsInstanceList =  CessProcessingDetails.findAllByCessreturn(application,[sort:'dateCreated',order:'asc',offset:0]) 
    		    	def appPending = CessPendingDetails.findByCessReturn(application)
    		    	
    		    	def cessReturnfilesInspection=CessReturnFileRecord.findAll("from CessReturnFileRecord as crfr where crfr.cessReturn=? and crfr.typeOfFile='attachedInspectionReport'",[application] )
    		    	def cessReturnfilesInspectionClose=CessReturnFileRecord.findAll("from CessReturnFileRecord as crfr where crfr.cessReturn=? and crfr.typeOfFile='InspectionCloseReport'",[application] )
    		    	def cessReturnfilesInspectionSize
    		    	def cessReturnfilesInspectionCloseSize
    		    	if(cessReturnfilesInspection){
    		    		 cessReturnfilesInspectionSize=cessReturnfilesInspection.size()
    		    	}else{
    		    		 cessReturnfilesInspectionSize=0
    		    	}
    		    	if(cessReturnfilesInspectionClose){
    		    		cessReturnfilesInspectionCloseSize=cessReturnfilesInspectionClose.size()
    		    	}else{
    		    		cessReturnfilesInspectionCloseSize=0
    		    	}
    		    	model:[applicationProcessingDetailsInstanceList:applicationProcessingDetailsInstanceList,currentPending:appPending.role,cessReturnfilesInspectionCloseSize:cessReturnfilesInspectionCloseSize,cessReturnfilesInspectionSize:cessReturnfilesInspectionSize]
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
    
    def showCessSpcb = {
    		 try {
    				def cessReturnInstance = CessReturn.get( (params.id).toLong() )
    				def industryRegId=cessReturnInstance.industryReg
    				def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
    					
    					if(!cessReturnInstance) {
    					flash.message = "CessReturn not found with id ${params.id}"
    					redirect(action:createSingle)
    					}
    					else { 
    						render(view:'showCess',model:[ cessReturnInstance : cessReturnInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList])
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
    
    def assessmentIssueGenerate={
    		 try {
    				def idAppl= (params.appliId).toLong()
    		    	def cessReturnInstance=CessReturn.get(idAppl)
    		    	def industryReg=cessReturnInstance.industryReg
    		    	return ['industryReg':industryReg,cessReturnInstance:cessReturnInstance]
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
    
    def generateAssessmentIssueGenerate={
    		 try {
    				def industryReg=IndustryRegMaster.get((params.idIndReg).toLong())
    	    		CessReturnFileRecord file=new CessReturnFileRecord()
    	    		def checkForView=false
    	        	def idCessReturn=(params.idCessreturn).toLong()
    	        	def cessInstance=CessReturn.get(idCessReturn)
    	        	def cessReturnApp=CessReturn.get(idCessReturn)
    	        	def app = CessPendingDetails.findByCessReturn(cessInstance)
    	        	def roleHeader=app.role.roleName
    	        	def roleActList = CessRoleVsActivity.findAllByRole(app.role)
    	        	def actionList = new ArrayList()
    	        	def assessmentIssue = false
    	        	def assessmentOrder = false
    	        	def feeDefaulterNotice = false
    	        	
    	        	def fwdRoleList = new ArrayList()
    	        	
    	        	def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
    	        	for(int i=0;i<workFlowMasterList.size();i++){ 
    	        	fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
    	        	}
    	        	
    	        	actionList.add(CessActivityMaster.findWhere(activityCode:"002"))
    	        	for(int i=0;i<roleActList.size();i++){
    	        		 if((roleActList.get(i)).activity.activityCode == "002"){
    	        			assessmentIssue = true
    	        		}else if((roleActList.get(i)).activity.activityCode == "003"){
    	        			assessmentOrder = true
    	        		}else if((roleActList.get(i)).activity.activityCode == "004"){
    	        			feeDefaulterNotice = true
    	        		}
    	        	}
    	        	
    	        	def applicationProcessingDetailsInstanceList =  CessProcessingDetails.findAllByCessreturn(cessInstance,[sort:'dateCreated',order:'desc',offset:0])
    	        	
    	        	def grantedFromDateCheck=params.grantedFrom_value+""
    	        	def grantedToDateCheck=params.grantedTo_value+""
    	        	
    	        	def draftLetterCheck=params.draftLetterDate_value+""
    	        	def checkDate
    	    		def x
    	    		def y
    	    		def p
    	    		    try
    	    				{
    	    					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    	    					x = sdfh.parse(grantedFromDateCheck); //Date
    	    					y = sdfh.parse(grantedToDateCheck);
    	    					p = sdfh.parse(draftLetterCheck);
    	    					checkDate="checked"
    	    				}
    	    				catch(Exception e)
    	    				{
    	    				}
    	    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    	    				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    	    			java.sql.Date sqlDatep = new java.sql.Date(p.getTime())
    	    			
    	    			if(sqlDate>sqlDate2)
    	    			{
    	    				flash.message="Assesment Period To Date should be Greater than Assesment Period From Date"
    	    					redirect(action:"assessmentIssueGenerate", params:[appliId:idCessReturn])

    	    					
    	    			}else if(sqlDate2 > new Date()){
    	    				flash.message="Assesment Period To Date should be less than current date."
    	    					redirect(action:"assessmentIssueGenerate", params:[appliId:idCessReturn])

    	    			}else if(sqlDatep > new Date()){
    	    				flash.message="Notice date cannot be greater than current date."
    	    					redirect(action:"assessmentIssueGenerate", params:[appliId:idCessReturn])

    	    			}
    	    			else{
    	    			
    	    		def industryName=industryReg.indName+""
    	    		def industryPlot=industryReg.plotNo+""
    	    		def industryAddress=industryReg.indAddress+""
    	    		def industryTehsil=industryReg.tehsil.tehsilName+""
    	    		def industryDistrict=industryReg.district.districtName+""
    	        	
    	        	def copyTo=params.copyTo
    	        	def nameOfDistrict=params.nameOfDistrict
    	        	def draftLetterDate=params.draftLetterDate_value
    	        	def grantedFromDate=params.grantedFrom_value
    	        	def grantedToDate=params.grantedTo_value
    	        	def fromDate1=params.fromDate
    	        	def toDate1=params.toDate
    	        	def offAddres=params.offAddres
    	        	def fileNumber=params.fileNumber
    	        	def endtNumber = params.endtNumber
    	        	def waterConsumptionClass1= params.waterConI
    	        	def waterConsumptionClass2=	params.waterConII
    	      		def waterConsumptionClass3= params.waterConIII
    	      		def waterConsumptionClass4= params.waterConIV
    	       		def remarks1= params.remarksI
    	       		def remarks2= params.remarksII
    	       		def remarks3= params.remarksIII
    	       		def remarks4= params.remarksIV
    	       		def issueDateHearing= params.clarDate_value
    	       		def cessRupees=params.waterCessRupee
    	        	
    	       		def cessStartDate=params.cessFromDate
    	       		def cessEndDate=params.cessToDate
    	       		def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
    	    		def a
    	    		def b1
    	    		java.sql.Date upperDate
    	    		java.sql.Date leastDate
    	    		
    	    		String year = cessStartDate.substring(0,4);
    	            String month = cessStartDate.substring(5,7);
    	            String day = cessStartDate.substring(8,10);
    	         		
    	    		String lD = year+"/"+month+"/"+day
    	            
    	            def leastDate1 = lD
    	            b1 = sdfh.parse(leastDate1)
    	    		    		
    	    		        
    	    		leastDate = new java.sql.Date(b1.getTime())
    	    		
    	    		String year1 = cessEndDate.substring(0,4);
    	            String month1 = cessEndDate.substring(5,7);
    	            String day1 = cessEndDate.substring(8,10);
    	              		
    	    		String uD = year1+"/"+month1+"/"+day1
    	            
    	            def upperDate1 = uD
    	            a = sdfh.parse(upperDate1)
    	    		        
    	    		upperDate = new java.sql.Date(a.getTime())
    	    		       		
    	        	AssessmentIssue  assess=new AssessmentIssue()
    	    	   def certFile=assess.assessmentIssueFunction( nameOfDistrict, draftLetterDate, offAddres, industryName, industryPlot, industryAddress, industryTehsil, industryDistrict, fileNumber, grantedFromDate, grantedToDate,  fromDate1, toDate1, waterConsumptionClass1, waterConsumptionClass2, waterConsumptionClass3, waterConsumptionClass4, remarks1, remarks2, remarks3, remarks4, issueDateHearing, cessRupees,copyTo, endtNumber)
    	    	   byte[] b = new byte[(int) certFile.length()];
    	            
    	            FileInputStream fileInputStream = new FileInputStream(certFile);
    	            fileInputStream.read(b);
    	            def fileLength=certFile.length()
    	            	file.size = fileLength / 1024  //f.getSize() 
    	     	         file.extension ="pdf"//extractExtension( f )
    	     	       	 file.data=b;
    	     	       	 file.name="AssessmentIssue.pdf"
    	     	    	 file.description="AssessmentIssue Generation Record"
    	     	    	 file.createdBy=session.userMaster
    	     	    	 file.updatedBy=session.userMaster
    	     	    	 file.typeOfFile="AssessmentIssue"
    	     	    	 file.indreg=industryReg
    	     	    	file.cessReturn=cessInstance
    	     	    	file.cessAppliedFromDate=leastDate
    	     	    	file.cessAppliedToDate=upperDate
    	     	    	if(file.save()) {
    	     	    	  flash.message = "Pre Assessment Notice is generated properly."
    	     	    		 checkForView=true
    	     	    		 } else {
    	     	    		 flash.message = "Pre Assessment Notice is not generated."
    	     	    		  if(applicationProcessingDetailsInstanceList){
    	     	 	        		def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
    	     	 	            	render(view: 'cessProcessing',model:[roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app])
    	     	 	        	}else{
    	     	 	        		render(view: 'cessProcessing',model:[roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:null,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app])
    	     	 	        	}
    	     	     }
    	     	       	 if(checkForView){
    	     	       	 def cessAssessissueInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='AssessmentIssue' order by crf.id desc",[cessInstance],[max:1])
    	    	        	 def cessAssessIssueFinalInstance
    	    	    		 if(cessAssessissueInstance){
    	    	    			 cessAssessIssueFinalInstance=cessAssessissueInstance[0]
    	    	    		 }
    	    	    	
    	    	        	redirect(action:cessProcessing,id:cessInstance.id)
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
    
    def assessmentOrder={
    		 try {
    		    	def idAppl= (params.appliId).toLong()
    		    	def cessReturnInstance=CessReturn.get(idAppl)
    		    	def industryReg=cessReturnInstance.industryReg
    		    	return ['industryReg':industryReg,cessReturnInstance:cessReturnInstance]
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
    
     def generateAssessmentOrder={
    		 try {
    		    	session.nameOfDistrict=params.nameOfDistrict
    		    	session.offAddres=params.offAddres
    		    	session.fileNumber=params.fileNumber
    		    	session.remark=params.remark
    		    	CessAssesmentOrderDetails cessAssessmentInstance = new CessAssesmentOrderDetails()
    		    	CessReturnFileRecord file=new CessReturnFileRecord()
    		    	
    		    	def industryReg=IndustryRegMaster.get((params.idIndReg).toLong()) 
    		    	def checkForView=false
    		    	def idCessReturn=(params.idCessreturn).toLong()
    		    	def cessInstance=CessReturn.get(idCessReturn)
    		    	
    		    	def app = CessPendingDetails.findByCessReturn(cessInstance)
    		    	def roleHeader=app.role.roleName
    		    	def roleActList = CessRoleVsActivity.findAllByRole(app.role)
    		    	def actionList = new ArrayList()
    		    	def assessmentIssue = false
    		    	def assessmentOrder = false
    		    	def feeDefaulterNotice = false
    		    	
    		    	def fwdRoleList = new ArrayList()
    		    	
    		    	def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
    		    	for(int i=0;i<workFlowMasterList.size();i++){ 
    		    		fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
    		    	}
    		    	
    		    	actionList.add(CessActivityMaster.findWhere(activityCode:"002"))
    		    	for(int i=0;i<roleActList.size();i++){
    		    		 if((roleActList.get(i)).activity.activityCode == "002"){
    		    			assessmentIssue = true
    		    		}else if((roleActList.get(i)).activity.activityCode == "003"){
    		    			assessmentOrder = true
    		    		}else if((roleActList.get(i)).activity.activityCode == "004"){
    		    			feeDefaulterNotice = true
    		    		}
    		    	}
    		    	def applicationProcessingDetailsInstanceList =  CessProcessingDetails.findAllByCessreturn(cessInstance,[sort:'dateCreated',order:'desc',offset:0])
    		    	def grantedFromDateCheck=params.grantedFrom_value+""
    		    	def grantedToDateCheck=params.grantedTo_value+""
    		    	
    		    	def draftLetterCheck=params.draftLetterDate_value+""
    		    	def checkDate
    				def x
    				def y
    				def p
    					try
    						{
    							def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    							x = sdfh.parse(grantedFromDateCheck); //Date
    					      	y = sdfh.parse(grantedToDateCheck);
    							p = sdfh.parse(draftLetterCheck);
    							checkDate="checked"
    						}
    						catch(Exception e)
    						{
    						}
    						java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    						java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    					java.sql.Date sqlDatep = new java.sql.Date(p.getTime())
    					
    					if(sqlDate>sqlDate2)
    					{
    						flash.message="Assesment Order To Date should be Greater than Assesment Order From Date"
    							redirect(action:"assessmentOrder", params:[appliId:idCessReturn])
    					}else
    						if(sqlDate2 > new Date()){
    						flash.message="Assesment Order To Date should be less than current date."
    							redirect(action:"assessmentOrder", params:[appliId:idCessReturn])

    					}else if(sqlDatep > new Date()){
    						flash.message="Assessment Order date cannot be greater than current date."
    							redirect(action:"assessmentOrder", params:[appliId:idCessReturn])

    					}
    					else{
    				
    		    	def industryName=industryReg.indName+""
    				def industryPlot=industryReg.plotNo+""
    				def industryAddress=industryReg.indAddress+""
    				def industryTehsil=industryReg.tehsil.tehsilName+""
    				def industryDistrict=industryReg.district.districtName+""
    		    	
    		    	def nameOfDistrict=params.nameOfDistrict
    		    	def draftLetterDate=params.draftLetterDate_value
    		    	def grantedFromDate=params.grantedFrom_value
    		    	def grantedToDate=params.grantedTo_value
    		    	def fromDate1=params.fromDate
    		    	def toDate1=params.toDate
    		    	def offAddres=params.offAddres
    		    	def fileNumber=params.fileNumber
    		    	
    		    	def remark=params.remark
    		    	
    		    	def mineQtyRebate=params.mineQtyRebate
    		    	def mineRebateAllowed=params.mineRebateAllowed
    		    	def mineConsumption=params.mineConsumption
    		    	def mineGrossAmount=params.mineGrossAmount
    		    	def mineNeTPayable=params.mineNeTPayable
    		    	
    		    	def domesticNeTPayable=params.domesticNeTPayable 
    		    	def domesticConsumption=params.domesticConsumption
    		    	def domesticQtyRebate=params.domesticQtyRebate
    		    	def domesticRebateAllowed=params.domesticRebateAllowed
    		    	def domesticGrossAmount=params.domesticGrossAmount
    		    	
    		    	def pollutantGrossAmount=params.pollutantGrossAmount
    		    	def pollutantQtyRebate=params.pollutantQtyRebate
    		    	def pollutantRebateAllowed=params.pollutantRebateAllowed
    		    	def pollutantNeTPayable=params.pollutantNeTPayable
    		    	def pollutantConsumption=params.pollutantConsumption
    		    	
    		    	def pollutantToxicRebateAllowed=params.pollutantToxicRebateAllowed
    		    	def pollutantToxicQtyRebate=params.pollutantToxicQtyRebate
    		    	def pollutantToxicConsumption=params.pollutantToxicConsumption
    		    	def pollutantToxicGrossAmount=params.pollutantToxicGrossAmount
    		    	def pollutantToxicNeTPayable=params.pollutantToxicNeTPayable
    		    	def rupeesInWords=params.rupeesInWords 
    		    	def totRupees=params.totRupees
    		    	def totRupees1=params.totRupees1
    		    	def sayRupee1=params.sayRupee1
    		    	def sayRupee2=params.sayRupee2
    		    	def dueDate=params.dueDate_value
    		    	def type=params.type
    		    	def type1=params.type1
    		    	
    		    	def cessStartDate=params.cessFromDate
    		   		def cessEndDate=params.cessToDate
    		   		def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
    				def a
    				def b1
    				java.sql.Date upperDate
    				java.sql.Date leastDate
    				
    				String year = cessStartDate.substring(0,4);
    		        String month = cessStartDate.substring(5,7);
    		        String day = cessStartDate.substring(8,10);
    		     		
    				String lD = year+"/"+month+"/"+day
    		        
    		        def leastDate1 = lD
    		        b1 = sdfh.parse(leastDate1)
    				        
    				leastDate = new java.sql.Date(b1.getTime())
    				
    				String year1 = cessEndDate.substring(0,4);
    		        String month1 = cessEndDate.substring(5,7);
    		        String day1 = cessEndDate.substring(8,10);
    		          		
    				String uD = year1+"/"+month1+"/"+day1
    		        
    		        def upperDate1 = uD
    		        a = sdfh.parse(upperDate1)
    				        
    				upperDate = new java.sql.Date(a.getTime())
    				def notice
    		    	def dueD 
    		    	def assesFromDate 
    		    	def assesToDate 
    		    	try{
    		    		def sdfh1 = new SimpleDateFormat("dd/MM/yyyy")
    		    		notice = sdfh1.parse(draftLetterDate)
    		    		dueD = sdfh1.parse(dueDate)
    		    		assesFromDate = sdfh1.parse(grantedFromDate)
    		    		assesToDate = sdfh1.parse(grantedToDate)
    		    		
    		    	}
    				catch(Exception e)
    				{
    					
    				}
    		    	java.sql.Date noticeDate1 = new java.sql.Date(notice.getTime())
    		    	java.sql.Date dueDate1 = new java.sql.Date(dueD.getTime())
    		    	java.sql.Date assesmentFromDate1 = new java.sql.Date(assesFromDate.getTime())
    		    	java.sql.Date assesmentToDate1 = new java.sql.Date(assesToDate.getTime())
    		    	cessAssessmentInstance.noticeDate = noticeDate1
    		       cessAssessmentInstance.dueDate = dueDate1
    		       cessAssessmentInstance.indreg = industryReg
    		       cessAssessmentInstance.cessReturn = cessInstance
    		       cessAssessmentInstance.assesmentFromDate = assesmentFromDate1
    		       cessAssessmentInstance.assesmentToDate = assesmentToDate1
    		       cessAssessmentInstance.letterNo = fileNumber
    		       cessAssessmentInstance.remarks = remark
    		       cessAssessmentInstance.indCoolingConsumption = mineConsumption.toFloat()
    			   cessAssessmentInstance.indCoolingGrossAmount = mineGrossAmount.toFloat()
    			   cessAssessmentInstance.indCoolingQtyWaterRebate = mineQtyRebate.toFloat()
    			   cessAssessmentInstance.indCoolingRebateAllowed = mineRebateAllowed.toFloat()
    			   cessAssessmentInstance.indCoolingConsumptionNetAmount = mineNeTPayable.toFloat()
    			   cessAssessmentInstance.domesticConsumption = domesticConsumption.toFloat()
    			   cessAssessmentInstance.domesticGrossAmount = domesticGrossAmount.toFloat()
    			   cessAssessmentInstance.domesticQtyWaterRebate = domesticQtyRebate.toFloat()
    			   cessAssessmentInstance.domesticRebateAllowed = domesticRebateAllowed.toFloat()
    			   cessAssessmentInstance.domesticConsumptionNetAmount =domesticNeTPayable.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreConsumption = pollutantConsumption.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreGrossAmount = pollutantGrossAmount.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreQtyWaterRebate = pollutantQtyRebate.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreRebateAllowed =pollutantRebateAllowed.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreConsumptionNetAmount =pollutantNeTPayable.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreNotConsumption = pollutantToxicConsumption.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreNotGrossAmount =pollutantToxicGrossAmount.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreNotQtyWaterRebate =pollutantToxicQtyRebate.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreNotRebateAllowed =pollutantToxicRebateAllowed.toFloat()
    			   cessAssessmentInstance.processingPollutantsAreNotConsumptionNetAmount = pollutantToxicNeTPayable.toFloat()
    			   cessAssessmentInstance.grossAmountTotal = sayRupee1.toFloat()
    			   cessAssessmentInstance.netAmountTotal = sayRupee2.toFloat()
    		    	cessAssessmentInstance.save()
    			  AssessmentOrder  assess=new AssessmentOrder()
    		    	
    		    	File certFile
    		    	
    		    	certFile=assess.assessmentOrder_Function(nameOfDistrict,draftLetterDate,offAddres,industryName,industryPlot,industryAddress,industryTehsil,industryDistrict,fileNumber,grantedFromDate,grantedToDate,mineConsumption,mineGrossAmount,mineQtyRebate,mineRebateAllowed,mineNeTPayable,domesticConsumption,domesticGrossAmount,domesticQtyRebate,domesticRebateAllowed,domesticNeTPayable,pollutantConsumption,pollutantGrossAmount,pollutantQtyRebate,pollutantRebateAllowed,pollutantNeTPayable,pollutantToxicConsumption,pollutantToxicGrossAmount,pollutantToxicQtyRebate,pollutantToxicRebateAllowed,pollutantToxicNeTPayable,totRupees, sayRupee1, sayRupee2, dueDate,remark,rupeesInWords, fromDate1, toDate1, type,type1, totRupees1)
    		    	
    		    	  byte[] b = new byte[(int) certFile.length()];
    		        
    		        FileInputStream fileInputStream = new FileInputStream(certFile);
    		        fileInputStream.read(b);
    		 	        
    		 	        def fileLength=certFile.length()
    		        	file.size = fileLength / 1024  //f.getSize() 
    		 	         file.extension ="pdf"//extractExtension( f )
    		 	       	 file.data=b;
    		 	       	 file.name="AssessmentOrder.pdf"
    		 	    	 file.description="AssessmentOrder Generation Record"
    		 	    	 file.createdBy=session.userMaster
    		 	    	 file.updatedBy=session.userMaster
    		 	    	 file.typeOfFile="AssessmentOrder"
    		 	    	 file.indreg=industryReg
    		 	    	file.cessReturn=cessInstance
    		 	    	file.cessAppliedFromDate=leastDate
    		 	    	file.cessAppliedToDate=upperDate
    		 	    	if(file.save()) {
    		 	    	 flash.message = "Assessment Order is generated properly."
    		 	    		 checkForView=true
    		 	    		 } else {
    		 	    		 flash.message = "Assessment Order is not generated."
    		 	    		  if(applicationProcessingDetailsInstanceList){
    		 	 	        		def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
    		 	 	            	render(view: 'cessProcessing',model:[roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app])
    		 	 	        	}else{
    		 	 	        		render(view: 'cessProcessing',model:[roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:null,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app])
    		 	 	        	}
    		 	     }
    		 	       	 if(checkForView){
    		 	       	 def cessAssessOrderInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='AssessmentOrder' order by crf.id desc",[cessInstance],[max:1])
    			        	 def cessAssessOrderFinalInstance
    			    		 if(cessAssessOrderInstance){
    			    		 cessAssessOrderFinalInstance=cessAssessOrderInstance[0]
    			    		 }
    			    	redirect(action:cessProcessing,id:cessInstance.id)
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
    
    def feeNotice={
    		 try {
    	    		def idAppl= (params.appliId).toLong()
    	    	def cessReturnInstance=CessReturn.get(idAppl)
    	    	def industryReg=cessReturnInstance.industryReg
    	    	return ['industryReg':industryReg,cessReturnInstance:cessReturnInstance]
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
    
    def generateFee_Notice={
    		 try {
    			 CessReturnFileRecord file=new CessReturnFileRecord()
    	        	CessFeeNoticeDetails cessFeeNoticeInstance = new CessFeeNoticeDetails()
    	        	
    	        	def industryReg=IndustryRegMaster.get((params.idIndReg).toLong()) 
    	        	def checkForView=false
    	        	def idCessReturn=(params.idCessreturn).toLong()
    	        	def cessInstance=CessReturn.get(idCessReturn)
    	        	
    	        	def app = CessPendingDetails.findByCessReturn(cessInstance)
    	        	def roleHeader=app.role.roleName
    	        	def roleActList = CessRoleVsActivity.findAllByRole(app.role)
    	        	def actionList = new ArrayList()
    	        	def assessmentIssue = false
    	        	def assessmentOrder = false
    	        	def feeDefaulterNotice = false
    	        	
    	        	def fwdRoleList = new ArrayList()
    	        	
    	        	def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
    	        	for(int i=0;i<workFlowMasterList.size();i++){ 
    	        		fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
    	        	}
    	        	
    	        	actionList.add(CessActivityMaster.findWhere(activityCode:"002"))
    	        	for(int i=0;i<roleActList.size();i++){
    	        		 if((roleActList.get(i)).activity.activityCode == "002"){
    	        			assessmentIssue = true
    	        		}else if((roleActList.get(i)).activity.activityCode == "003"){
    	        			assessmentOrder = true
    	        		}else if((roleActList.get(i)).activity.activityCode == "004"){
    	        			feeDefaulterNotice = true
    	        		}
    	        	}
    	        	
    	        	def applicationProcessingDetailsInstanceList =  CessProcessingDetails.findAllByCessreturn(cessInstance,[sort:'dateCreated',order:'desc',offset:0])
    	        	def grantedFromDateCheck=params.grantedFrom_value+""
    	        	def grantedToDateCheck=params.grantedTo_value+""
    	        	def orderDateCheck=params.orderDate_value+""
    	        	def draftLetterCheck=params.draftLetterDate_value+""
    	        	def due_DateCheck=params.due_Date_value+""
    	        	def paid_On_DateCheck=params.paid_On_Date_value+""
    	        	def amountDueDateCheck=params.dueDate_value+""
    	        	
    	        	def checkDate
    	    		def x
    	    		def y
    	    		def p
    	    		def q
    	    		try{
    	    				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    	    					x = sdfh.parse(grantedFromDateCheck); //Date
    	    					y = sdfh.parse(grantedToDateCheck);
    	    					p = sdfh.parse(orderDateCheck); //Date
    	    					q = sdfh.parse(draftLetterCheck);
    	    					checkDate="checked"
    	    				}
    	    				catch(Exception e)
    	    				{
    	    				}
    	    			
    	    				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    	    				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    	    			java.sql.Date sqlDatep = new java.sql.Date(p.getTime())
    					java.sql.Date sqlDateq = new java.sql.Date(q.getTime())
    	    			
    	    			if(sqlDate>sqlDate2)
    	    			{
    	    				flash.message="Assesment Order To Date should be Greater than Assesment Order From Date"
    	    					redirect(action:"feeNotice", params:[appliId:idCessReturn])
    	    			}else
    	    				if(sqlDate2 > new Date()){
    	    				flash.message="Assesment Order To Date should be less than current date."
    	    					redirect(action:"feeNotice", params:[appliId:idCessReturn])
    		
    	    			}else if(sqlDatep > new Date()){
    	    				flash.message="Assessment Order date cannot be greater than current date."
    	    					redirect(action:"feeNotice", params:[appliId:idCessReturn])
    		
    	    			}else if(sqlDateq > new Date()){
    	    				flash.message="Letter Date cannot be greater than current date."
    	    					redirect(action:"feeNotice", params:[appliId:idCessReturn])
    		
    	    			}
    	    			else{
    	    		def industryName=industryReg.indName+""
    	    		def industryPlot=industryReg.plotNo+""
    	    		def industryAddress=industryReg.indAddress+""
    	    		def industryTehsil=industryReg.tehsil.tehsilName+""
    	    		def industryDistrict=industryReg.district.districtName+""
    	    		def copyTo=params.copyTo
    	        	def orderNumber=params.orderNumber+""
    	        	def orderDate=params.orderDate_value+""
    	        	def nameOfDistrict=params.nameOfDistrict+""
    	        	def draftLetterDate=params.draftLetterDate_value+""
    	        	def fromDate1=params.fromDate+""
    	        	def toDate1=params.toDate+""
    	        	def offAddres=params.offAddres+""
    	        	def fileNumber=params.fileNumber+""
    	        	def endtNumber=params.endtNumber+""
    	        	def serial_No=params.serial_No+""
    	        	def due_Date=params.due_Date_value+""
    	        	def paid_On_Date=params.paid_On_Date_value+""
    	        	def assessment_Amount=params.assessment_Amount+""
    	        	def balance_Amount=params.balance_Amount+""
    	        	def interest=params.interest+""
    	        	def total_payable=params.total_payable+""
    	        	def amountDueDate=params.dueDate_value+""
    	        	
    	        	def cessStartDate=params.cessFromDate
    	       		def cessEndDate=params.cessToDate
    	       		def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
    	    		def a
    	    		def b1
    	    		java.sql.Date upperDate
    	    		java.sql.Date leastDate
    	    		
    	    		String year = cessStartDate.substring(0,4);
    	            String month = cessStartDate.substring(5,7);
    	            String day = cessStartDate.substring(8,10);
    	         		
    	    		String lD = year+"/"+month+"/"+day
    	            
    	            def leastDate1 = lD
    	            b1 = sdfh.parse(leastDate1)
    	    		        
    	    		leastDate = new java.sql.Date(b1.getTime())
    	    		
    	    		String year1 = cessEndDate.substring(0,4);
    	            String month1 = cessEndDate.substring(5,7);
    	            String day1 = cessEndDate.substring(8,10);
    	              		
    	    		String uD = year1+"/"+month1+"/"+day1
    	           
    	            def upperDate1 = uD
    	            a = sdfh.parse(upperDate1)
    	    		        
    	    		upperDate = new java.sql.Date(a.getTime())
    	    
    	    		def orderDate1
    	    	def notice 
    	    	def assesFromDate 
    	    	def assesToDate 
    	    	def dueFeeDate 
    	    	def dueDate 
    	    	def paidDate
    	    	try{
    	    		def sdfh1 = new SimpleDateFormat("dd/MM/yyyy")
    	    		notice = sdfh1.parse(draftLetterDate)
    	    		orderDate1 = sdfh1.parse(orderDate)
    	    		assesFromDate = sdfh1.parse(grantedFromDateCheck)
    	    		assesToDate = sdfh1.parse(grantedToDateCheck)
    	    		dueFeeDate = sdfh1.parse(amountDueDate)
    	    		dueDate = sdfh1.parse(due_Date)
    	    		paidDate = sdfh1.parse(paid_On_Date)
    	    	}
    			catch(Exception e)
    			{
    			}
    	    	java.sql.Date noticeDate1 = new java.sql.Date(notice.getTime())
    	    	java.sql.Date orderDate2 = new java.sql.Date(orderDate1.getTime())
    	    	java.sql.Date assesmentFromDate1 = new java.sql.Date(assesFromDate.getTime())
    	    	java.sql.Date assesmentToDate1 = new java.sql.Date(assesToDate.getTime())
    	    	java.sql.Date dueDate1 = new java.sql.Date(dueDate.getTime())
    	    	java.sql.Date dueFeeDate1 = new java.sql.Date(dueFeeDate.getTime())
    	    	java.sql.Date paidDate1 = new java.sql.Date(paidDate.getTime())
    	    	
    	      cessFeeNoticeInstance.assesmentOrderDate = orderDate2
    		   cessFeeNoticeInstance.indreg = industryReg
    		   cessFeeNoticeInstance.cessReturn = cessInstance
    		   cessFeeNoticeInstance.assesmentFromDate = assesmentFromDate1
    		   cessFeeNoticeInstance.assesmentToDate = assesmentToDate1
    		   cessFeeNoticeInstance.letterNo = fileNumber
    		   cessFeeNoticeInstance.assesmentOrderNo = orderNumber
    		   cessFeeNoticeInstance.noticeDate = noticeDate1
    		   cessFeeNoticeInstance.dueFeeDate = dueFeeDate1
    		   cessFeeNoticeInstance.dueDate = dueDate1
    		   cessFeeNoticeInstance.paidOnDate = paidDate1
    		   cessFeeNoticeInstance.assesmentAmount =  assessment_Amount.toFloat()
    		   cessFeeNoticeInstance.balanceAmount = balance_Amount.toFloat()
    		   cessFeeNoticeInstance.interestAmount = interest.toFloat()
    		   cessFeeNoticeInstance.totalPayableAmount = total_payable.toFloat()
    		   cessFeeNoticeInstance.copyTo = copyTo
    		   cessFeeNoticeInstance.officeAddress = offAddres
    		   cessFeeNoticeInstance.endtNo = endtNumber
    		   cessFeeNoticeInstance.officeDistrict = nameOfDistrict
    		    cessFeeNoticeInstance.save()
    		   
    	        	FeeDefaulterNotice feenotice=new FeeDefaulterNotice()
    	        	
    	        	File certFile
    	        	
    	        	certFile=feenotice.feeDefaulterNoticeFunction( nameOfDistrict, draftLetterDate, offAddres, industryName, industryPlot, industryAddress, industryTehsil, industryDistrict, fileNumber,grantedFromDateCheck,grantedToDateCheck, orderNumber, orderDate, serial_No, due_Date, paid_On_Date, assessment_Amount, balance_Amount, interest, total_payable,  amountDueDate,copyTo, fromDate1, toDate1, endtNumber)
    	        	byte[] b = new byte[(int) certFile.length()];
    	            
    	            FileInputStream fileInputStream = new FileInputStream(certFile);
    	            fileInputStream.read(b);
    	     	        
    	     	        def fileLength=certFile.length()
    	            	file.size = fileLength / 1024  //f.getSize() 
    	     	         file.extension ="pdf"//extractExtension( f )
    	     	       	 file.data=b;
    	     	       	 file.name="FeeDefaulterNotice.pdf"
    	     	    	 file.description="feeDefaulterNotice Generation Record"
    	     	    	 file.createdBy=session.userMaster
    	     	    	 file.updatedBy=session.userMaster
    	     	    	 file.typeOfFile="feeDefaulterNotice"
    	     	    	 file.indreg=industryReg
    	     	    	file.cessReturn=cessInstance
    	     	    	file.cessAppliedFromDate=leastDate
    	     	    	file.cessAppliedToDate=upperDate
    	     	    	 if(file.save()) {
    	     	    	  flash.message = "Fee Defaulter Notice Order is generated properly."
    	     	    		 checkForView=true
    	     	    		 } else {
    	     	    	 flash.message = "Fee Defaulter Notice Order is not generated."
    	     	    		  if(applicationProcessingDetailsInstanceList){
    	     	 	        		def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
    	     	 	            	render(view: 'cessProcessing',model:[roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app])
    	     	 	        	}else{
    	     	 	        		render(view: 'cessProcessing',model:[roleHeader:roleHeader,actionList:actionList,assessmentIssue:assessmentIssue,assessmentOrder:assessmentOrder,feeDefaulterNotice:feeDefaulterNotice,applicationProcessingDetailsInstance:null,cessReturnApp:cessReturnApp,fwdRoleList:fwdRoleList,app:app])
    	     	 	        	}
    	     	     }
    	     	       	 if(checkForView){
    	     	       redirect(action:cessProcessing,id:cessInstance.id)
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
    
    def viewAssessOrder={
    		 try {
    		    	def application = CessReturnFileRecord.get((params.appliId).toLong())
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewAssessIssue={
    		 try {
    		    	def application = CessReturnFileRecord.get((params.appliId).toLong())
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewInspectionDocument1={
    		 try {
    		    	def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='attachedInspectionReport' order by crf.id desc",[cessReturnInstance],[max:1])
    		    	def application=applicationList[0]
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
   
     def viewOtherAttachedFile={
    		 try {
    		    	def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='attachLetter' order by crf.id desc",[cessReturnInstance],[max:1])
    		    	def application=applicationList[0]
    		    	
    		    	def applicationFileSingleInstance=application
    		    	if(applicationFileSingleInstance==null){
    					flash.message = "File not Attached by SPCB Officer"
    					redirect(action:cessProcessing,params:["id":params.appliLoc])
    				}else{
    				 response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
        
    def viewOtherAttachedFileInNoteHistory = {
    		 try {
    		    	def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def fileVer=(params.verValue).toLong()
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='attachLetter' and crf.version=? order by crf.id desc",[cessReturnInstance,fileVer],[max:1])
    		    	def application=applicationList[0]
    		    	
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
	
    def viewInspectionDocument={
    		 try {
    		    	def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def fileVer=(params.verValue).toLong()
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='attachedInspectionReport' and crf.version=? order by crf.id desc",[cessReturnInstance,fileVer],[max:1])
    		    	def application=applicationList[0]
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewInspectionCloseDocument1={
    		 try {
    	    		def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='InspectionCloseReport'  order by crf.id desc",[cessReturnInstance],[max:1])
    		    	def application=applicationList[0]
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewInspectionCloseDocument={
    		 try {
    	    		def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def fileVer=(params.verValue).toLong()
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='InspectionCloseReport' and crf.version=? order by crf.id desc",[cessReturnInstance,fileVer],[max:1])
    		    	def application=applicationList[0]
    		    	
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
  
    def viewCessIssueDocument={
    		 try {
    	    		def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='indClarificationIssueFile' order by crf.id desc",[cessReturnInstance],[max:1])
    		    	def application=applicationList[0]
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewCessIssueDocument1={
    		 try {
    		    	def cessReturnInstance=CessReturn.get((params.appliLoc).toLong())
    	    		def fileVer=(params.verValue).toLong()
    	    		def applicationList = CessReturnFileRecord.findAll("from CessReturnFileRecord crf where crf.cessReturn=? and crf.typeOfFile='indClarificationIssueFile' and crf.version=? order by crf.id desc",[cessReturnInstance,fileVer],[max:1])
    		    	def application=applicationList[0]
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewFeeNotice={
    		 try {
    		    	def application = CessReturnFileRecord.get((params.appliId).toLong())
    		    	def applicationFileSingleInstance=application
    			   response.setContentType( "application-xdownload")
    			   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
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
    
    def viewInspection = {
    		 try {
    		    	def application = CessReturn.get((params.id).toLong())
    	    		def cessProcessingDetailsInstanceList =  CessProcessingDetails.findAllBycessreturn(application,[sort:'dateCreated',order:'desc',offset:0]) 
    	    		for(int i=0;i<cessProcessingDetailsInstanceList.size();i++){
    	    			if((cessProcessingDetailsInstanceList.get(i)).inspection){
    	    				return[appInspection:cessProcessingDetailsInstanceList.get(i)]
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
    
}