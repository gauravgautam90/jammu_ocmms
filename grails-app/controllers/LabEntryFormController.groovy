

class LabEntryFormController {
    
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
    	        [ labEntryFormInstanceList: LabEntryForm.list( params ), labEntryFormInstanceTotal: LabEntryForm.count() ]
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
    		 def labEntryFormInstance = LabEntryForm.get( params.id )
    		 if(!labEntryFormInstance) {
    	            flash.message = "LabEntryForm not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ labEntryFormInstance : labEntryFormInstance ] }
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
        def labEntryFormInstance = LabEntryForm.get( params.id )
        if(labEntryFormInstance) {
            try {
                labEntryFormInstance.delete()
                flash.message = "LabEntryForm ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "LabEntryForm ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "LabEntryForm not found with id ${params.id}"
            redirect(action:list)
        }
    }

  def edit = {
    	 try {
    	def labEntryFormInstance = LabEntryForm.get( params.id )
    	if(!labEntryFormInstance) {
    	            flash.message = "LabEntryForm not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ labEntryFormInstance : labEntryFormInstance ]
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
    		 def labEntryFormInstance = LabEntryForm.get( params.id )
    	        if(labEntryFormInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(labEntryFormInstance.version > version) {
    	                    
    	                    labEntryFormInstance.errors.rejectValue("version", "labEntryForm.optimistic.locking.failure", "Another user has updated this LabEntryForm while you were editing.")
    	                    render(view:'edit',model:[labEntryFormInstance:labEntryFormInstance])
    	                    return
    	                }
    	            }
    	            labEntryFormInstance.properties = params
    	            if(!labEntryFormInstance.hasErrors() && labEntryFormInstance.save()) {
    	                flash.message = "LabEntryForm ${params.id} updated"
    	                redirect(action:show,id:labEntryFormInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[labEntryFormInstance:labEntryFormInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "LabEntryForm not found with id ${params.id}"
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
    			 def labEntryFormInstance = new LabEntryForm()
    	        def labList=GroupMaster.findAll("from GroupMaster as gm where gm.groupDesc='LAB' order By gm.groupName ")
    	        labEntryFormInstance.properties = params
    	        return ['labEntryFormInstance':labEntryFormInstance,labList:labList]
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
    			def labEntryFormInstance = new LabEntryForm(params)
    	        labEntryFormInstance.createdBy=session.userMaster
    	        labEntryFormInstance.updatedBy=session.userMaster
    	        labEntryFormInstance.applicationStatus="In-progress"
    	        	labEntryFormInstance.generateReport=false
    	        if(!labEntryFormInstance.hasErrors() && labEntryFormInstance.save()) {
    	        	def routeLab= new RouteLab()
    	        	def isRouted=routeLab.routeLabApp(labEntryFormInstance)
    	    	 	flash.message = "LabEntryForm ${labEntryFormInstance.id} created"
    	            redirect(action:show,id:labEntryFormInstance.id)
    	        }else {
    	            render(view:'create',model:[labEntryFormInstance:labEntryFormInstance])
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
    
def waterReport={
    	 try {
    		def sampleId=params.appliId
     		def sampleType=params.docName
     	return [sampleType:sampleType,sampleId:sampleId ] 
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
    
def saveWaterReport={
    	 try {
    			def sampleApp
    	    	def sampleId=params.idOfSample
    			def sampleType=params.sampleType
    			if(sampleType=="WaterEffluent"){
    	    		sampleApp=Lab_WaterEffluentMonitoring.get(sampleId)
    	    	}else{
    	    		
    	    			sampleApp=Lab_AmbientAirMonitoring.get(sampleId)
    	    	}
    	    	def labPendInst1 =LabPendingDetails.findAll("from LabPendingDetails as lpd where lpd.idOfSample=? and lpd.sampleType=? order by lpd.dateCreated desc ",[sampleId,sampleType],[max:1])
    	    	def labPendInst=labPendInst1[0]
    	    		def waterReportInstance = new WaterReport()
    	    	waterReportInstance.description=params.description
    	    	waterReportInstance.Aldrin=params.Aldrin
    	    	waterReportInstance.alphaBHC=params.alphaBHC
    	    	waterReportInstance.betaBHC=params.betaBHC
    	    	waterReportInstance.gamaBHC=params.gamaBHC
    	    	waterReportInstance.dDT=params.ddt
    	    	waterReportInstance.Dieldrin=params.dieldrin
    	    	waterReportInstance.enDrin=params.endrin
    	    	waterReportInstance.endoSulphan1=params.endosulphan1
    	    	waterReportInstance.endoSulphan2=params.endosulphan2
    	    	waterReportInstance.heptchlor=params.heptachlor
    	    	waterReportInstance.methoxychlore=params.methoxychlore
    	    	waterReportInstance.malathion=params.malathion
    	    	waterReportInstance.methylParathion=params.methylParathion
    	    	waterReportInstance.phorate=params.phorate
    	    	waterReportInstance.idOfSample=sampleId
    	    	waterReportInstance.sampleType=sampleType
    	    	waterReportInstance.createdBy=session.userMaster
    			waterReportInstance.updatedBy=session.userMaster
    	    	def currentDate=new Date()
    			WaterREportCertificate file= new WaterREportCertificate()
    	    	WaterReportCert cert = new WaterReportCert()
    	    	def certFile=cert.waterReportCert(params.Aldrin,params.alphaBHC,params.betaBHC,params.gamaBHC,params.ddt,params.dieldrin,params.endrin,params.endosulphan1,params.endosulphan2,params.heptachlor,params.methoxychlore,params.malathion,params.methylParathion,params.phorate,currentDate.toString())
    			byte[] b = new byte[(int) certFile.length()];
    			FileInputStream fileInputStream = new FileInputStream(certFile);
    			fileInputStream.read(b);
    			def fileLength=certFile.length()
    	    	 file.size = fileLength / 1024  //f.getSize() 
    	    	file.extension ="pdf"//extractExtension( f )
    	         file.data=b;
    	   	 	file.name="Water Report.pdf"
    	      	 file.description="Water Report"
    		   	 file.createdBy=session.userMaster
    		   	 file.updatedBy=session.userMaster
    		   	 file.typeOfFile="WATER"
    		   	 file.idOfSample=sampleId
    	     	file.sampleType=sampleType
    		   	def fileid = null
    		  if(!waterReportInstance.hasErrors() && waterReportInstance.save()) 
    	    	{
    	    		if(file.save()) {
    	    		 fileid=file.id
    	   			sampleApp.generateReport=true
    	   			sampleApp.save()
    	   	    		 		}else{
    	   	   	 					file.errors.each {
    	   	         		   }
    	   	         		}
    	    		flash.message = "WaterReport ${waterReportInstance.id} saved "
    	    			redirect(controller:"labProcessingDetails",action:"appProcessing",params:[idOfPending:labPendInst.id])
    	       }
    	    	else
    	    	{
    	    		waterReportInstance.errors.each {
    	    		   }
    	    		 redirect(action:waterReport,id:waterReportInstance.id)
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
    
 def airReport={
    	 try {
    		def sampleId=params.appliId
    	 		def sampleType=params.docName
    	 	return [sampleType:sampleType,sampleId:sampleId ] 
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

def saveAirrReport={
     try {
    		def sampleApp
    	    	def sampleId=params.idOfSample
    	    		def sampleType=params.sampleType
    	    		if(sampleType=="WaterEffluent"){
    	        		
    	        			sampleApp=Lab_WaterEffluentMonitoring.get(sampleId)
    	        	}else{
    	        		
    	        			sampleApp=Lab_AmbientAirMonitoring.get(sampleId)
    	        	}
    			def labPendInst1 =LabPendingDetails.findAll("from LabPendingDetails as lpd where lpd.idOfSample=? and lpd.sampleType=? order by lpd.dateCreated desc ",[sampleId,sampleType],[max:1])
    	    	def labPendInst=labPendInst1[0]
    	    	def airReportInstance = new AirReport()
    	    	airReportInstance.initialTimerReading=params.initialTimerReading
    	    	airReportInstance.finalTimerReading=params.finalTimerReading
    	    	airReportInstance.timeInMin=params.timeInMin
    	    	airReportInstance.meanFlowRate=params.meanFlowRate
    	    	airReportInstance.filterPaperno=params.filterPaperno
    	    	airReportInstance.filterPaperInitialWeight=params.filterPaperInitialWeight
    	    	airReportInstance.filterPaperPlusDustWeight=params.filterPaperPlusDustWeight
    	    	airReportInstance.dustInCupWeight=params.dustInCupWeight
    	    	airReportInstance.rSPM=params.rSPM
    	    	airReportInstance.nRD=params.nRD
    	    	airReportInstance.tSPM=params.tSPM
    	    	airReportInstance.sO2=params.sO2
    	    	airReportInstance.nO=params.nO
    	    	airReportInstance.remarks=params.remarks
    	    	def remark=params.remarks
    	    	airReportInstance.idOfSample=sampleId
    	    	airReportInstance.sampleType=sampleType
    	    	airReportInstance.createdBy=session.userMaster
    	    	airReportInstance.updatedBy=session.userMaster
    	    	def currentDate=new Date()
    			AirReportCertificates file= new AirReportCertificates()
    			AirReportCert cert = new AirReportCert()
    			def certFile=cert.airReportCert(params.initialTimerReading,params.finalTimerReading,params.timeInMin,params.meanFlowRate,params.filterPaperno,params.filterPaperInitialWeight,params.filterPaperPlusDustWeight,params.dustInCupWeight,params.rSPM,params.nRD,params.tSPM,params.sO2,params.nO,currentDate.toString(),remark)
    			byte[] b = new byte[(int) certFile.length()];
    			FileInputStream fileInputStream = new FileInputStream(certFile);
    			fileInputStream.read(b);
    			def fileLength=certFile.length()
    	    	 file.size = fileLength / 1024  //f.getSize() 
    	    	 file.extension ="pdf"//extractExtension( f )
    	        file.data=b;
    	   	 	 file.name="Air Report.pdf"
    	      	 file.description="Air Report"
    		   	 file.createdBy=session.userMaster
    		   	 file.updatedBy=session.userMaster
    		   	 file.typeOfFile="AIR"
    		   	 file.idOfSample=sampleId
    	        	file.sampleType=sampleType
    		   	 file.dateCreated=currentDate
    		   	 def fileid = null
    		   	if(!airReportInstance.hasErrors() && airReportInstance.save()) 
    	    	{
    	    		if(file.save()) {
    	    			sampleApp.generateReport=true
    	    			 sampleApp.save()
    	   			 fileid=file.id
    	   	    		 		}else{
    	   	   	 					file.errors.each {
    	   	         		   }
    	   	         		}
    	    		flash.message = "AirReport ${airReportInstance.id} saved "
    	    			redirect(controller:"labProcessingDetails",action:"appProcessing",params:[idOfPending:labPendInst.id])
    	    	}
    	    	else
    	    	{
    	    		airReportInstance.errors.each {
    	   	         		   }
    	             redirect(action:airReport,id:airReportInstance.id)
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
