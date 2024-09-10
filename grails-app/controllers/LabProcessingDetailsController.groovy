

class LabProcessingDetailsController {
    
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
    	        [ labProcessingDetailsInstanceList: LabProcessingDetails.list( params ), labProcessingDetailsInstanceTotal: LabProcessingDetails.count() ]
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
    		 def labProcessingDetailsInstance = LabProcessingDetails.get( params.id )
    	        if(!labProcessingDetailsInstance) {
    	            flash.message = "LabProcessingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ labProcessingDetailsInstance : labProcessingDetailsInstance ] }
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
        def labProcessingDetailsInstance = LabProcessingDetails.get( params.id )
        if(labProcessingDetailsInstance) {
            try {
                labProcessingDetailsInstance.delete()
                flash.message = "LabProcessingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "LabProcessingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "LabProcessingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

 def edit = {
    	 try {
    		 def labProcessingDetailsInstance = LabProcessingDetails.get( params.id )
    		 if(!labProcessingDetailsInstance) {
    	            flash.message = "LabProcessingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ labProcessingDetailsInstance : labProcessingDetailsInstance ]
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
    		 def labProcessingDetailsInstance = LabProcessingDetails.get( params.id )
    	        if(labProcessingDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(labProcessingDetailsInstance.version > version) {
    	                    
    	                    labProcessingDetailsInstance.errors.rejectValue("version", "labProcessingDetails.optimistic.locking.failure", "Another user has updated this LabProcessingDetails while you were editing.")
    	                    render(view:'edit',model:[labProcessingDetailsInstance:labProcessingDetailsInstance])
    	                    return
    	                }
    	            }
    	            labProcessingDetailsInstance.properties = params
    	            if(!labProcessingDetailsInstance.hasErrors() && labProcessingDetailsInstance.save()) {
    	                flash.message = "LabProcessingDetails ${params.id} updated"
    	                redirect(action:show,id:labProcessingDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[labProcessingDetailsInstance:labProcessingDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "LabProcessingDetails not found with id ${params.id}"
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
    		 def labProcessingDetailsInstance = new LabProcessingDetails()
    	        labProcessingDetailsInstance.properties = params
    	        return ['labProcessingDetailsInstance':labProcessingDetailsInstance]
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
    		 def labProcessingDetailsInstance = new LabProcessingDetails(params)
    	        if(!labProcessingDetailsInstance.hasErrors() && labProcessingDetailsInstance.save()) {
    	            flash.message = "LabProcessingDetails ${labProcessingDetailsInstance.id} created"
    	            redirect(action:show,id:labProcessingDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[labProcessingDetailsInstance:labProcessingDetailsInstance])
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
    		def labApp = LabPendingDetails.get((params.idOfPending).toLong())
    	    	def sampleApp
    	    	def idOfSamp= labApp.idOfSample
    	    	def reportType=labApp.sampleType
    	    	def reportFor
    	    	if(reportType=="WaterEffluent"){
    	    		reportFor="WATER"
    	    			sampleApp=Lab_WaterEffluentMonitoring.get(idOfSamp)
    	    	}else{
    	    		reportFor="AIR"
    	    			sampleApp=Lab_AmbientAirMonitoring.get(idOfSamp)
    	    	}
    	    	 def app=labApp
    	    	def roleHeader=app.role.roleName
    	    	def roleActList = LabRoleVsActivity.findAllByRole(app.role)
    	    	def actionList = new ArrayList()
    	    	def generateCert = false
    	    	def prepareCertificate=false
    	    	def finish = false
    	    	def fwdRoleList = new ArrayList()
    	    	def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
    	    	for(int i=0;i<workFlowMasterList.size();i++){ 
    	    		fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
    	    	}
    	    	actionList.add(LabActivityMaster.findWhere(activityCode:"002"))
    	    	for(int i=0;i<roleActList.size();i++){
    	    		 if((roleActList.get(i)).labActivity.activityCode == "003"){
    	    			 finish = true
    	    		}else if((roleActList.get(i)).labActivity.activityCode == "002"){
    	    			prepareCertificate = true
    	    		}
    	    	}
    	    	def applicationProcessingDetailsInstanceList =  LabProcessingDetails.findAll("from LabProcessingDetails as lpd where lpd.idOfSample=? and lpd.sampleType=? order by lpd.dateCreated desc",[idOfSamp,reportType])
    	    	if(applicationProcessingDetailsInstanceList){
    	    		def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
    	        	model:[roleHeader:roleHeader,actionList:actionList,generateCert:generateCert,finish:finish,fwdRoleList:fwdRoleList,app:app,labApp:labApp,applicationProcessingDetailsInstance:applicationProcessingDetailsInstance,prepareCertificate:prepareCertificate,reportFor:reportFor,sampleApp:sampleApp,reportType:reportType]
    	    	}else{
    	    		model:[roleHeader:roleHeader,actionList:actionList,generateCert:generateCert,finish:finish,fwdRoleList:fwdRoleList,app:app,labApp:labApp,prepareCertificate:prepareCertificate,reportFor:reportFor,sampleApp:sampleApp,reportType:reportType]
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
    	 try {
    		def redirectBack = false
    	    	def sampleApp
    	    	def sampleId=params.idOfSample
    			def sampleType=params.sampleType
    			if(sampleType=="WaterEffluent"){
    	    		sampleApp=Lab_WaterEffluentMonitoring.get(sampleId)
    	    	}else{
    	    		sampleApp=Lab_AmbientAirMonitoring.get(sampleId)
    	    	}
    	    	def applicationPending = LabPendingDetails.get((params.appId).toLong())
    	    	def labAppInstance=applicationPending.sample
    	    	def rVa = LabRoleVsActivity.findWhere(role:applicationPending.role, labActivity:LabActivityMaster.findByActivityCode("001")) 
    	    	if(rVa){
    	    		def list = LabPendingDetails.findAllBySample(applicationPending.sample)
    	    		for(int i=0;i<list.size();i++){
    	    			if(list.get(i)!=applicationPending){
    	    				(list.get(i)).delete()
    	    			}
    	    		}
    	    	}
    	    	def roleFwd = RoleMaster.get((params.forward).toLong())
    	    	def applicationProcessingDetails = new LabProcessingDetails()
    	    	applicationProcessingDetails.role = applicationPending.role
    	    	def user = session.userMaster
    	    	user.refresh()
    	    	applicationProcessingDetails.officer = user.userProfile.id
    	    	applicationProcessingDetails.fileNote = params.fileNote
    	    	applicationProcessingDetails.roleFwd = roleFwd
    	    	applicationProcessingDetails.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
    	    	if((params.complete).equals("yes")){
    	    	   if(sampleApp.generateReport==false){
    	    		 flash.message="Please generate Report first."
    	    		redirectBack=true 
    	    		}else{
    	    		def labPendApp = applicationPending.sample
    	    		sampleApp.applicationStatus="completed"
    	    			sampleApp.save()
    	    		    applicationPending.applicationStatus="completed"
    	    			applicationProcessingDetails.finish=true
    	    			applicationProcessingDetails.finishNote=params.completeNote
    	    		}
    	    	}else{
    	    		applicationProcessingDetails.finishNote=""
    					applicationProcessingDetails.finish=false
    	    	}
    	    	if(redirectBack){
    	    		def indApp = applicationPending.sample
    	    		redirect(action:'appProcessing',params:["idOfPending":applicationPending.id])
    	    	}else{
    	    		applicationProcessingDetails.idOfSample = applicationPending.idOfSample
    	    		applicationProcessingDetails.sampleType = applicationPending.sampleType
    	    		applicationProcessingDetails.generateReport=false
    	    		applicationProcessingDetails.generateReportNote=""
    	        	if( applicationProcessingDetails.save() ) {
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
    	    	def sampleId=params.appliId+""
    	    	def sampleType=params.docName
    	    	def sampleApp
    	    	if(sampleType=="WaterEffluent"){
    	    		sampleApp=Lab_WaterEffluentMonitoring.get(sampleId)
    	    	}else{
    	    		sampleApp=Lab_AmbientAirMonitoring.get(sampleId)
    	    	}
    	    	def applicationProcessingDetailsInstanceList =  LabProcessingDetails.findAll("from LabProcessingDetails as lpd where lpd.idOfSample=? and lpd.sampleType=? order by lpd.dateCreated desc",[sampleId,sampleType])
    	    	def pendList=LabPendingDetails.list()
    	    	def appPending1 =LabPendingDetails.findAll("from LabPendingDetails as lpd where lpd.idOfSample=? and lpd.sampleType=? order by lpd.dateCreated desc ",[sampleId,sampleType],[max:1])
    	    	def appPending=appPending1[0]
    	    	model:[applicationProcessingDetailsInstanceList:applicationProcessingDetailsInstanceList,currentPending:appPending.role]
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
    
 def viewReport={
    	 try {
    	    def appForWhich=params.docName
    	    	def sampleId=params.appliId
    	    	def labFileInstance1
    	    	if(appForWhich=="WaterEffluent"){
    	    		labFileInstance1=WaterREportCertificate.findAll("from WaterREportCertificate as arc where arc.idOfSample=? and arc.sampleType=? order by arc.id desc",[sampleId,appForWhich],[max:1] )
    	    	}else{
    	    	 labFileInstance1=AirReportCertificates.findAll("from AirReportCertificates as arc where arc.idOfSample=? and arc.sampleType=? order by arc.id desc",[sampleId,appForWhich],[max:1] )
    	    	}
    	    	def labFileInstance=labFileInstance1[0]
    	    	def singleInstanceOfWasteManagementFile=labFileInstance
    	    	response.setContentType( "application-xdownload")
    	    		   response.setHeader("Content-Disposition", "attachment;filename=${singleInstanceOfWasteManagementFile.name}")
    	    		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfWasteManagementFile.data )
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
    
 def labShowPopUp={
    	 try {
    	    def sampleType=params.docName
    	    	def sampleIdd=params.appliId
    	    	def lab_AmbientAirMonitoringInstance
    	    	def lab_WaterEffluentMonitoringInstance
    	    	if(sampleType=="WaterEffluent"){
    	    		lab_WaterEffluentMonitoringInstance=Lab_WaterEffluentMonitoring.get(sampleIdd)
    		}else{
    	    	 def abc=Lab_AmbientAirMonitoring.get(sampleIdd)
    	    	lab_AmbientAirMonitoringInstance=Lab_AmbientAirMonitoring.get(sampleIdd)
    		}
    	    if(!lab_WaterEffluentMonitoringInstance && !lab_AmbientAirMonitoringInstance) {
    				flash.message = "Lab not found with id ${params.id}"
    				redirect(action:show)
    			}
    			else { 
    					if(sampleType=="WaterEffluent"){
    						def checkWater="Yes"
    						return [ lab_WaterEffluentMonitoringInstance : lab_WaterEffluentMonitoringInstance,checkWater:checkWater ] 
    					}else{
    						def checkAir="Yes"
    					 return [ lab_AmbientAirMonitoringInstance : lab_AmbientAirMonitoringInstance,checkAir:checkAir ] 
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
    
    def showFinder={
    	 try {
    	   if(params.appForWhich=="AmbientAirMonitoring"){
    	    		redirect(controller:'lab_AmbientAirMonitoring', action:'show',id:params.id ,params:[noEdit:params.noEdit,viewR:params.viewR] )
    	    	}else{
    	    		redirect(controller:'lab_WaterEffluentMonitoring', action:'show',id:params.id ,params:[noEdit:params.noEdit,viewR:params.viewR])
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
    
}
