
import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
class WasteManagementPendingDetailsController {
    
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
    	        [ wasteManagementPendingDetailsInstanceList: WasteManagementPendingDetails.list( params ), wasteManagementPendingDetailsInstanceTotal: WasteManagementPendingDetails.count() ]
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
    	  def wasteManagementPendingDetailsInstance = WasteManagementPendingDetails.get( params.id )
    	        if(!wasteManagementPendingDetailsInstance) {
    	            flash.message = "WasteManagementPendingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ wasteManagementPendingDetailsInstance : wasteManagementPendingDetailsInstance ] }
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
        def wasteManagementPendingDetailsInstance = WasteManagementPendingDetails.get( params.id )
        if(wasteManagementPendingDetailsInstance) {
            try {
                wasteManagementPendingDetailsInstance.delete()
                flash.message = "WasteManagementPendingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "WasteManagementPendingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "WasteManagementPendingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    	   def wasteManagementPendingDetailsInstance = WasteManagementPendingDetails.get( params.id )
    	        if(!wasteManagementPendingDetailsInstance) {
    	            flash.message = "WasteManagementPendingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ wasteManagementPendingDetailsInstance : wasteManagementPendingDetailsInstance ]
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
    	 def wasteManagementPendingDetailsInstance = WasteManagementPendingDetails.get( params.id )
    	        if(wasteManagementPendingDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(wasteManagementPendingDetailsInstance.version > version) {
    	                     wasteManagementPendingDetailsInstance.errors.rejectValue("version", "wasteManagementPendingDetails.optimistic.locking.failure", "Another user has updated this WasteManagementPendingDetails while you were editing.")
    	                    render(view:'edit',model:[wasteManagementPendingDetailsInstance:wasteManagementPendingDetailsInstance])
    	                    return
    	                }
    	            }
    	            wasteManagementPendingDetailsInstance.properties = params
    	            if(!wasteManagementPendingDetailsInstance.hasErrors() && wasteManagementPendingDetailsInstance.save()) {
    	                flash.message = "WasteManagementPendingDetails ${params.id} updated"
    	                redirect(action:show,id:wasteManagementPendingDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[wasteManagementPendingDetailsInstance:wasteManagementPendingDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WasteManagementPendingDetails not found with id ${params.id}"
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
    	   def wasteManagementPendingDetailsInstance = new WasteManagementPendingDetails()
    	        wasteManagementPendingDetailsInstance.properties = params
    	        return ['wasteManagementPendingDetailsInstance':wasteManagementPendingDetailsInstance]
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
    	 def wasteManagementPendingDetailsInstance = new WasteManagementPendingDetails(params)
    	        if(!wasteManagementPendingDetailsInstance.hasErrors() && wasteManagementPendingDetailsInstance.save()) {
    	            flash.message = "WasteManagementPendingDetails ${wasteManagementPendingDetailsInstance.id} created"
    	            redirect(action:show,id:wasteManagementPendingDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[wasteManagementPendingDetailsInstance:wasteManagementPendingDetailsInstance])
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

    def pendingList={
	try {
		    
	    	def userProfileInstance=(UserMaster) session.userMaster
	    	def application
	    	def isClarList=new ArrayList()
	    	def isInspecList=new ArrayList()
	    	def appId
	    	def wasteManagementPendingList=new ArrayList()
	    	def wasteManagementPendingList1=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wpd where wpd.pendingWith=? and wpd.applicationStatus='pending'  and wpd.applicationFor!='HWMAnnualReturn' and wpd.applicationFor!='BMWAnnualReturn' and wpd.applicationFor!='PWM'  order by wpd.dateCreated desc",[userProfileInstance])
	    	
	    	if(wasteManagementPendingList1){
	    	for (int i=0;i<wasteManagementPendingList1.size();i++){
	    		def instancePend=wasteManagementPendingList1[i]
	    		def appFor=instancePend.applicationFor
	    		def appIdStr=instancePend.applicationId
	    		appId=(instancePend.applicationId).toLong()
	    	//	println("AAAAAAAAAAAA "+appFor)
	    		if(appFor == "HWM"){
	    			println("appId HWM "+appId)
	        		application=HazardeousWasteAuthApp.get(appId)
	        		if(application){
	        		println("application HWM "+application)
	        		isClarList.add(application.clarification)
	        		isInspecList.add(application.inspection)
	        		wasteManagementPendingList.add(instancePend)
	        		}
	        	}else if(appFor == "MSW"){
	        		//println("appId MSW "+appId)
	        		application=MunicipalSolidWaste.get(appId)
	        		if(application){
		        		println("application MSW "+application)
		        		isClarList.add(application.clarification)
		        		isInspecList.add(application.inspection)
		        		wasteManagementPendingList.add(instancePend)
		        		}
	        	}
	        	else {
	        	//	println("pendingList "+appFor)
	        	//	println("appId else"+appId)
	        		application=BioMedicalWaste.get(appId)
	        		if(application){
	        		println("application else "+application)
	        		isClarList.add(application.clarification)
	        		isInspecList.add(application.inspection)
	        		wasteManagementPendingList.add(instancePend)
	        		}
	        	}
	    	}
	    	}

	    //	println("wasteManagementPendingList "+wasteManagementPendingList)
	    //	println("wasteManagementPendingList111111111111111111111 "+wasteManagementPendingList1)
	    	def wasteManagementCompletedList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wpd where wpd.pendingWith=? and wpd.applicationStatus!='pending' and wpd.applicationStatus!='returned' and wpd.applicationFor!='HWMAnnualReturn' and wpd.applicationFor!='BMWAnnualReturn' and wpd.applicationFor!='PWM'  order by wpd.dateCreated desc",[userProfileInstance]) 

	    	
	    	return ['wasteManagementPendingList':wasteManagementPendingList,wasteManagementCompletedList:wasteManagementCompletedList,isClarList:isClarList,isInspecList:isInspecList,appId:appId]
	    
	    
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
   
   def wasteSummary={
	

	 try {
		    
	    	
	    	def applicationReceivedCountB=BioMedicalWaste.findAll("From BioMedicalWaste as bmw WHERE bmw.applicationStatus!='unattended' and  bmw.completionStatus='Completed' order by bmw.id desc " )
	    	def applicationReceivedCountM=MunicipalSolidWaste.findAll("From MunicipalSolidWaste as bmw WHERE bmw.applicationStatus!='unattended' and bmw.completionStatus='Completed' order by bmw.id desc ")
	    	def applicationReceivedCountH=HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp as bmw WHERE bmw.applicationStatus!='unattended' and bmw.completionStatus='Completed' order by bmw.id desc " )
	    	def applicationReceivedCountP=PlasticWaste.findAll("From PlasticWaste as bmw WHERE bmw.applicationStatus!='unattended' and bmw.completionStatus='Completed' order by bmw.id desc " )
	    	
	    	def applicationCompletedCountB=BioMedicalWaste.findAll("From BioMedicalWaste as bmw WHERE bmw.applicationStatus!='unattended' and bmw.applicationStatus NOT IN ('Inprogress','Completed') and  bmw.completionStatus='Completed' order by bmw.id desc " )
	    	def applicationCompletedCountM=MunicipalSolidWaste.findAll("From MunicipalSolidWaste as bmw WHERE bmw.applicationStatus!='unattended' and bmw.applicationStatus NOT IN ('Inprogress','Completed') and bmw.completionStatus='Completed' order by bmw.id desc " )
	    	def applicationCompletedCountH=HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp as bmw WHERE bmw.applicationStatus!='unattended' and bmw.applicationStatus NOT IN ('Inprogress','Completed') and bmw.completionStatus='Completed'  order by bmw.id desc ")
	    	def applicationCompletedCountP=PlasticWaste.findAll("From PlasticWaste as bmw WHERE bmw.applicationStatus!='unattended' and bmw.applicationStatus NOT IN ('Inprogress','Completed') and bmw.completionStatus='Completed'  order by bmw.id desc ")
	    	
	    	def applicationPendingCountB=BioMedicalWaste.findAll("From BioMedicalWaste as bmw WHERE  bmw.applicationStatus IN ('Inprogress','Completed') and  bmw.completionStatus='Completed'  order by bmw.id desc ")
	    	def applicationPendingCountM=MunicipalSolidWaste.findAll("From MunicipalSolidWaste as bmw WHERE  bmw.applicationStatus IN ('Inprogress','Completed') and bmw.completionStatus='Completed' order by bmw.id desc  ")
	    	def applicationPendingCountH=HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp as bmw WHERE  bmw.applicationStatus IN ('Inprogress','Completed') and bmw.completionStatus='Completed' order by bmw.id desc  ")
	    	def applicationPendingCountP=PlasticWaste.findAll("From PlasticWaste as bmw WHERE  bmw.applicationStatus IN ('Inprogress','Completed') and bmw.completionStatus='Completed' order by bmw.id desc  ")
	    	
	    	
	    	def applicationUnattendedCountB=BioMedicalWaste.findAll("From BioMedicalWaste as bmw WHERE  bmw.applicationStatus='unattended' and  bmw.completionStatus='Completed' order by bmw.id desc  ")
	    	def applicationUnattendedCountM=MunicipalSolidWaste.findAll("From MunicipalSolidWaste as bmw WHERE  bmw.applicationStatus='unattended' and bmw.completionStatus='Completed' order by bmw.id desc  ")
	    	def applicationUnattendedCountH=HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp as bmw WHERE  bmw.applicationStatus='unattended' and bmw.completionStatus='Completed' order by bmw.id desc " )
	    	def applicationUnattendedCountP=PlasticWaste.findAll("From PlasticWaste as bmw WHERE  bmw.applicationStatus='unattended' and bmw.completionStatus='Completed' order by bmw.id desc " )



	    	
	    	def receivedCount=applicationReceivedCountB.size()+applicationReceivedCountM.size()+applicationReceivedCountH.size()+applicationReceivedCountP.size()
	    	def completedCount=applicationCompletedCountB.size()+applicationCompletedCountM.size()+applicationCompletedCountH.size()+applicationCompletedCountP.size()
	    	def pendingCount=applicationPendingCountB.size()+applicationPendingCountM.size()+applicationPendingCountH.size()+applicationPendingCountP.size()
	   		def unattendedCount=applicationUnattendedCountB.size()+applicationUnattendedCountM.size()+applicationUnattendedCountH.size()+applicationUnattendedCountP.size()
	   		println("=====applicationReceivedCountB======"+applicationReceivedCountB.size())
	   		println("=====applicationCompletedCountB======"+applicationCompletedCountB.size())
	   		println("=====applicationPendingCountB======"+applicationPendingCountB.size())
	   		println("=====applicationUnattendedCountB======"+applicationUnattendedCountB.size())
	   		def fullListToPrintB= new ArrayList()
	   		def allFourB= new ArrayList()
	    	def appListB= new ArrayList()
	    	def statusListB= new ArrayList()
	    	def pendingWithB= new ArrayList()
			def pendingWithRoleB= new ArrayList()
	    	
	    	def appList= new ArrayList()
	    	
	    	def fullListToPrintM= new ArrayList()
	   		def allFourM= new ArrayList()
	    	def appListM= new ArrayList()
	    	def statusListM= new ArrayList()
	    	def pendingWithM= new ArrayList()
			def pendingWithRoleM= new ArrayList()
	    	
	    	def fullListToPrintH= new ArrayList()
	   		def allFourH= new ArrayList()
	    	def appListH= new ArrayList()
	    	def statusListH= new ArrayList()
	    	def pendingWithH= new ArrayList()
			def pendingWithRoleH= new ArrayList()
	    	
	    	def fullListToPrintP= new ArrayList()
	   		def allFourP= new ArrayList()
	    	def appListP= new ArrayList()
	    	def statusListP= new ArrayList()
	    	def pendingWithP= new ArrayList()
			def pendingWithRoleP= new ArrayList()
	    	
	   		
	   		def wasteManagementListB
	   		def wasteManagementListM
	   		def wasteManagementListH
	   		def wasteManagementListP
	   		
	   		def finalListToPrint=new ArrayList()
	   		
	   		def checkVariableRec=false
	   		def checkVariableCom=false
	   		def checkVariable=false
	   		def checkVariableUn=false
	   		
	   		def linksch="true"
	   		
	   		if(params.checkVar){
	   			if(params.checkVar=="received"){
	   				if(applicationReceivedCountB){
	   				for(int a=0;a<applicationReceivedCountB.size();a++)
					{
						allFourB=applicationReceivedCountB.get(a)
						if(allFourB)
						{
							checkVariableRec=true
							
							appListB.add((allFourB))
							def appliFor="BMW"
							def appliIdStr=(allFourB.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListB.add(checkInst.applicationStatus)
											pendingWithB.add(checkInst.pendingWith)
											pendingWithRoleB.add(checkInst.role)
											}
											else
											{
												statusListB.add("Unattended")
												pendingWithB.add("Unknown")
												pendingWithRoleB.add("Unknown")
											}
						}
					}
	   				}
	   				if(applicationReceivedCountM){
	   				for(int a=0;a<applicationReceivedCountM.size();a++)
					{
						allFourM=applicationReceivedCountM.get(a)
						if(allFourM)
						{
							checkVariableRec=true
							appList.add((allFourM))
							appListM.add((allFourM))
							def appliFor="MSW"
							def appliIdStr=(allFourM.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListM.add(checkInst.applicationStatus)
											pendingWithM.add(checkInst.pendingWith)
											pendingWithRoleM.add(checkInst.role)
											}
											else
											{
												statusListM.add("Unattended")
												pendingWithM.add("Unknown")
												pendingWithRoleM.add("Unknown")
											}
						}
					}
	   				}
	   				if(applicationReceivedCountP){

		   				for(int a=0;a<applicationReceivedCountP.size();a++)
						{
							allFourP=applicationReceivedCountP.get(a)
							if(allFourP)
							{
								checkVariableRec=true
								appList.add((allFourP))
								appListP.add((allFourP))
								def appliFor="PWM"
								def appliIdStr=(allFourP.id).toString()
							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='PWM'",[appliIdStr],[max:1])
							def checkInst=	checkInstList[0]			
							if(checkInst)
												{
												statusListP.add(checkInst.applicationStatus)
												pendingWithP.add(checkInst.pendingWith)
												pendingWithRoleP.add(checkInst.role)
												}
												else
												{
													statusListP.add("Unattended")
													pendingWithP.add("Unknown")
													pendingWithRoleP.add("Unknown")
												}
							}
						}
		   					
	   				}	
	   				if(applicationReceivedCountH){
	   				for(int a=0;a<applicationReceivedCountH.size();a++)
					{
						allFourH=applicationReceivedCountH.get(a)
						if(allFourH)
						{
							checkVariableRec=true
							appList.add((allFourH))
							appListH.add((allFourH))
							def appliFor="HWM"
							def appliIdStr=(allFourH.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListH.add(checkInst.applicationStatus)
											pendingWithH.add(checkInst.pendingWith)
											pendingWithRoleH.add(checkInst.role)
											}
											else
											{
												statusListH.add("Unattended")
												pendingWithH.add("Unknown")
												pendingWithRoleH.add("Unknown")
											}
						}
					}
	   				}
	   				wasteManagementListB=appListB
	   				wasteManagementListM=appListM
	   				wasteManagementListH=appListH
	   				
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
	   	        }else if(params.checkVar=="completed"){
	   				if(applicationCompletedCountB){
	   				for(int a=0;a<applicationCompletedCountB.size();a++)
					{
						allFourB=applicationCompletedCountB.get(a)
						if(allFourB)
						{
							checkVariableCom=true
							appListB.add((allFourB))
							def appliFor="BMW"
							def appliIdStr=(allFourB.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListB.add(checkInst.applicationStatus)
											pendingWithB.add(checkInst.pendingWith)
											pendingWithRoleB.add(checkInst.role)
											}
											else
											{
												statusListB.add("Unattended")
												pendingWithB.add("Unknown")
												pendingWithRoleB.add("Unknown")
											}
						}
					}
	   				}
	   				if(applicationCompletedCountP){

		   				for(int a=0;a<applicationCompletedCountP.size();a++)
						{
							allFourP=applicationCompletedCountP.get(a)
							if(allFourP)
							{
								checkVariableCom=true
								appListP.add((allFourP))
								def appliFor="PWM"
								def appliIdStr=(allFourP.id).toString()
							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='PWM'",[appliIdStr],[max:1])
							def checkInst=	checkInstList[0]			
							if(checkInst)
												{
												statusListP.add(checkInst.applicationStatus)
												pendingWithP.add(checkInst.pendingWith)
												pendingWithRoleP.add(checkInst.role)
												}
												else
												{
													statusListP.add("Unattended")
													pendingWithP.add("Unknown")
													pendingWithRoleP.add("Unknown")
												}
							}
						}
		   					
	   				}	
	   				if(applicationCompletedCountM){
	   				for(int a=0;a<applicationCompletedCountM.size();a++)
					{
						allFourM=applicationCompletedCountM.get(a)
						if(allFourM)
						{
							checkVariableCom=true
							appListM.add((allFourM))
							def appliFor="MSW"
							def appliIdStr=(allFourM.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListM.add(checkInst.applicationStatus)
											pendingWithM.add(checkInst.pendingWith)
											pendingWithRoleM.add(checkInst.role)
											}
											else
											{
												statusListM.add("Unattended")
												pendingWithM.add("Unknown")
												pendingWithRoleM.add("Unknown")
											}
						}
					}
	   				}
	   				if(applicationCompletedCountH){
	   				for(int a=0;a<applicationCompletedCountH.size();a++)
					{
						allFourH=applicationCompletedCountH.get(a)
						if(allFourH)
						{
							checkVariableCom=true
							appListH.add((allFourH))
							def appliFor="HWM"
							def appliIdStr=(allFourH.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListH.add(checkInst.applicationStatus)
											pendingWithH.add(checkInst.pendingWith)
											pendingWithRoleH.add(checkInst.role)
											}
											else
											{
												statusListH.add("Unattended")
												pendingWithH.add("Unknown")
												pendingWithRoleH.add("Unknown")
											}
						}
					}
	   				}
	   				wasteManagementListB=appListB
	   				wasteManagementListM=appListM
	   				wasteManagementListH=appListH
	   				wasteManagementListP=appListP
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
	   	            
	   				
	   			}else if(params.checkVar=="pending"){
	   				if(applicationPendingCountB){
	   				for(int a=0;a<applicationPendingCountB.size();a++)
					{
						allFourB=applicationPendingCountB.get(a)
						if(allFourB)
						{
							checkVariable=true
							appListB.add((allFourB))
							
							def appliFor="BMW"
								def appliIdStr=(allFourB.id).toString()
							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
							def checkInst=	checkInstList[0]			
							if(checkInst)
												{
												statusListB.add(checkInst.applicationStatus)
												pendingWithB.add(checkInst.pendingWith)
												pendingWithRoleB.add(checkInst.role)
												}
												else
												{
													statusListB.add("Unattended")
													pendingWithB.add("Unknown")
												    pendingWithRoleB.add("Unknown")
												}
						}
					}
	   				}
	   				if(applicationPendingCountP){

		   				for(int a=0;a<applicationPendingCountP.size();a++)
						{
							allFourP=applicationPendingCountP.get(a)
							if(allFourP)
							{
								checkVariable=true
								appListP.add((allFourP))
								
								def appliFor="PWM"
									def appliIdStr=(allFourP.id).toString()
								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='PWM'",[appliIdStr],[max:1])
								def checkInst=	checkInstList[0]			
								if(checkInst)
													{
													statusListP.add(checkInst.applicationStatus)
													pendingWithP.add(checkInst.pendingWith)
													pendingWithRoleP.add(checkInst.role)
													}
													else
													{
														statusListP.add("Unattended")
														pendingWithP.add("Unknown")
													    pendingWithRoleP.add("Unknown")
													}
							}
						}
		   					
	   				}
	   				if(applicationPendingCountM){
	   				for(int a=0;a<applicationPendingCountM.size();a++)
					{
						allFourM=applicationPendingCountM.get(a)
						if(allFourM)
						{
							checkVariable=true
							appListM.add((allFourM))
							
							def appliFor="MSW"
								def appliIdStr=(allFourM.id).toString()
							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
							def checkInst=	checkInstList[0]			
							if(checkInst)
												{
												statusListM.add(checkInst.applicationStatus)
												pendingWithM.add(checkInst.pendingWith)
												pendingWithRoleM.add(checkInst.role)
												}
												else
												{
													statusListM.add("Unattended")
													pendingWithM.add("Unknown")
												    pendingWithRoleM.add("Unknown")
												}
						}
					}
	   				}
	   				if(applicationPendingCountH){
	   				for(int a=0;a<applicationPendingCountH.size();a++)
					{
						allFourH=applicationPendingCountH.get(a)
						if(allFourH)
						{
							checkVariable=true
							appListH.add((allFourH))
							def appliFor="HWM"
								def appliIdStr=(allFourH.id).toString()
							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
							def checkInst=	checkInstList[0]			
							if(checkInst)
												{
												statusListH.add(checkInst.applicationStatus)
												pendingWithH.add(checkInst.pendingWith)
												pendingWithRoleH.add(checkInst.role)
												}
												else
												{
													statusListH.add("Unattended")
													pendingWithH.add("Unknown")
												    pendingWithRoleH.add("Unknown")
												}
						}
					}
	   				}
	   				wasteManagementListB=appListB
	   				wasteManagementListM=appListM
	   				wasteManagementListH=appListH
	   				wasteManagementListP=appListP
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
	   	            
	   				
	   			}else{
	   				if(applicationUnattendedCountB){
	   				for(int variable1=0;variable1<applicationUnattendedCountB.size();variable1++)
							
						{
						allFourB=applicationUnattendedCountB.get(variable1)
						if(allFourB)
						{
							checkVariableUn=true
							appListB.add((allFourB))
							
							def appliFor="BMW"
								def appliIdStr=(allFourB.id).toString()
							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
							def checkInst=	checkInstList[0]			
							if(checkInst)
												{
												statusListB.add(checkInst.applicationStatus)
												pendingWithB.add(checkInst.pendingWith)
												pendingWithRoleB.add(checkInst.role)
												}
												else
												{
													statusListB.add("Unattended")
													pendingWithB.add("Unknown")
												    pendingWithRoleB.add("Unknown")
												}
						}
					}
	   				}
	   				if(applicationUnattendedCountP){
	   					for(int variable1=0;variable1<applicationUnattendedCountP.size();variable1++)
								
							{
							allFourP=applicationUnattendedCountP.get(variable1)
							if(allFourP)
							{
								checkVariableUn=true
								appListP.add((allFourP))
								
								def appliFor="PWM"
									def appliIdStr=(allFourP.id).toString()
								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='PWM'",[appliIdStr],[max:1])
								def checkInst=	checkInstList[0]			
								if(checkInst)
													{
													statusListP.add(checkInst.applicationStatus)
													pendingWithP.add(checkInst.pendingWith)
													pendingWithRoleP.add(checkInst.role)
													}
													else
													{
														statusListP.add("Unattended")
														pendingWithP.add("Unknown")
													    pendingWithRoleP.add("Unknown")
													}
							}
						}
		   					
	   				}	
	   				if(applicationUnattendedCountM){
	   				for(int variable1=0;variable1<applicationUnattendedCountM.size();variable1++)
						
					{
					allFourM=applicationUnattendedCountM.get(variable1)
					if(allFourM)
					{
						checkVariableUn=true
						appListM.add((allFourM))
						
						def appliFor="MSW"
							def appliIdStr=(allFourM.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListM.add(checkInst.applicationStatus)
											pendingWithM.add(checkInst.pendingWith)
											pendingWithRoleM.add(checkInst.role)
											}
											else
											{
												statusListM.add("Unattended")
												pendingWithM.add("Unknown")
												pendingWithRoleM.add("Unknown")
											}
					}
				}
	   				}
	   				if(applicationUnattendedCountH){
	   				for(int variable1=0;variable1<applicationUnattendedCountH.size();variable1++)
						
					{
					allFourH=applicationUnattendedCountH.get(variable1)
					if(allFourH)
					{
						checkVariableUn=true
						appListH.add((allFourH))
						
						def appliFor="HWM"
							def appliIdStr=(allFourH.id).toString()
						def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
						def checkInst=	checkInstList[0]			
						if(checkInst)
											{
											statusListH.add(checkInst.applicationStatus)
											pendingWithH.add(checkInst.pendingWith)
											pendingWithRoleH.add(checkInst.role)
											}
											else
											{
												statusListH.add("Unattended")
												pendingWithH.add("Unknown")
												pendingWithRoleH.add("Unknown")
											}
					}
				}
	   				}
	   				wasteManagementListB=appListB
	   				wasteManagementListM=appListM
	   				wasteManagementListH=appListH
	   				wasteManagementListP=appListP
	   				
	   				
	   			}
	   			
	   		}else{
	   			
	   			
	   		}



	    	fullListToPrintB=wasteManagementListB
	    	fullListToPrintM=wasteManagementListM
	    	fullListToPrintH=wasteManagementListH
	    	fullListToPrintP=wasteManagementListP
	    	
	   		
	   		if(checkVariableRec){
	   			finalListToPrint=applicationReceivedCountB+applicationReceivedCountM+applicationReceivedCountH
	   		}else if(checkVariableCom){
	   			finalListToPrint=applicationCompletedCountB+applicationCompletedCountM+applicationCompletedCountH
	   		}else if(checkVariable){
	   			finalListToPrint=applicationPendingCountB+applicationPendingCountM+applicationPendingCountH
	   		}else if(checkVariableUn){
	   			finalListToPrint=applicationUnattendedCountB+applicationUnattendedCountM+applicationUnattendedCountH
	   		}
					
	    	
	   		render(view:'searchPage',model:[finalListToPrint:finalListToPrint,linksch:linksch,applicationUnattendedCountB:applicationUnattendedCountB,applicationUnattendedCountP:applicationUnattendedCountP,applicationUnattendedCountM:applicationUnattendedCountM,applicationUnattendedCountH:applicationUnattendedCountH,applicationCompletedCountP:applicationCompletedCountP,applicationCompletedCountB:applicationCompletedCountB,applicationCompletedCountM:applicationCompletedCountM,applicationCompletedCountH:applicationCompletedCountH,applicationReceivedCountB:applicationReceivedCountB,applicationReceivedCountP:applicationReceivedCountP,applicationReceivedCountM:applicationReceivedCountM,applicationReceivedCountH:applicationReceivedCountH,checkVariableUn:checkVariableUn,checkVariableCom:checkVariableCom,checkVariableRec:checkVariableRec,applicationPendingCountP:applicationPendingCountP,applicationPendingCountB:applicationPendingCountB,applicationPendingCountM:applicationPendingCountM,applicationPendingCountH:applicationPendingCountH,fullListToPrintM:fullListToPrintM,fullListToPrintH:fullListToPrintH,fullListToPrintB:fullListToPrintB,fullListToPrintP:fullListToPrintP,statusListB:statusListB,statusListM:statusListM,statusListH:statusListH,statusListP:statusListP,pendingWithB:pendingWithB,pendingWithM:pendingWithM,pendingWithH:pendingWithH,pendingWithP:pendingWithP,pendingWithRoleB:pendingWithRoleB,pendingWithRoleM:pendingWithRoleM,pendingWithRoleH:pendingWithRoleH,pendingWithRoleP:pendingWithRoleP,receivedCount:receivedCount,completedCount:completedCount,pendingCount:pendingCount,unattendedCount:unattendedCount,checkVariable:checkVariable])
	    
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

def search={
    	 try {
    	  def checkDate
    	    	Date today = new Date();
    	    	def x
    	    	def y
    	    	def startDate1=params.start_date_value
    			def endDate1=params.end_date_value
    			def category=(params.category)
    			def categoryLong
    			def finalListToPrint=new ArrayList()
    			if(params.category!="xyz"){
    				categoryLong=(params.category).toLong()
    			}
    			def status=params.status
    			if(status=='Inprogress' || status=='inProgress'){
    				status='Completed'
    			}
    			def statusType=params.statusType
    			def bioList
    			def municipalList
    			def hazardeousList
    			def allFourB= new ArrayList()
    	    	def appListB= new ArrayList()
    	    	def statusListB= new ArrayList()
    	    	def pendingWithB= new ArrayList()
    			def pendingWithRoleB= new ArrayList()
    	    	def allFourM= new ArrayList()
    	    	def appListM= new ArrayList()
    	    	def statusListM= new ArrayList()
    	    	def pendingWithM= new ArrayList()
    			def pendingWithRoleM= new ArrayList()
    	    	def allFourH= new ArrayList()
    	    	def appListH= new ArrayList()
    	    	def statusListH= new ArrayList()
    	    	def pendingWithH= new ArrayList()
    			def pendingWithRoleH= new ArrayList()
    			def checkBio=false
    	    	try
    			{
    				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    				x = sdfh.parse(startDate1); //Date
    				y = sdfh.parse(endDate1);  //Date
    				checkDate="checked"
    			}
    			catch(Exception e)
    			{
    				flash.message="Enter Both The Dates in Correct Format "
    				redirect(action:wasteSummary)
    			}	
    			if(checkDate)
    			{
    				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    				sqlDate2.setDate((sqlDate2.getDate()+1))
    			if(startDate1 && endDate1 && category == "xyz" && status == "xyz" && statusType=="xyz"){
    				bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.id desc",[sqlDate,sqlDate2])
    				if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    			 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus != 'unattended' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.id desc",[sqlDate,sqlDate2])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    	 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.id",[sqlDate,sqlDate2])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    			}else if(startDate1 && endDate1 && category!= "xyz" && status == "xyz" && statusType=="xyz"){
    				 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.indRegMasterObj.category.id=? ",[sqlDate,sqlDate2,categoryLong])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    					appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    	 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus != 'unattended' and msw.dateCreated>=? and msw.dateCreated<=? and msw.indRegMasterObj.category.id=? ",[sqlDate,sqlDate2,categoryLong])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    			 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? and hwa.industryRegMasterObj.category.id=? ",[sqlDate,sqlDate2,categoryLong])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    			}else if(startDate1 && endDate1 && category == "xyz" && status != "xyz" && statusType=="xyz"){
    				 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=?",[status,sqlDate,sqlDate2])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    				 
    				 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = ? and msw.dateCreated>=? and msw.dateCreated<=?",[status,sqlDate,sqlDate2])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    				 
    				 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = ? and hwa.dateCreated>=? and hwa.dateCreated<=?",[status,sqlDate,sqlDate2])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    			}else if(startDate1 && endDate1 && category != "xyz" && status != "xyz" && statusType=="xyz"){
    				 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.indRegMasterObj.category.id=? ",[status,sqlDate,sqlDate2,categoryLong])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    				 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = ? and msw.dateCreated>=? and msw.dateCreated<=? and msw.indRegMasterObj.category.id=? ",[status,sqlDate,sqlDate2,categoryLong])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    				 
    				 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = ? and hwa.dateCreated>=? and hwa.dateCreated<=? and hwa.industryRegMasterObj.category.id=? ",[status,sqlDate,sqlDate2,categoryLong])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    			}else if(startDate1 && endDate1 && category == "xyz" && status == "xyz" && statusType!="xyz"){
    				if(statusType=="BMW"){
    				 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=?",[sqlDate,sqlDate2])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    				}
    				if(statusType=="MSW"){
    				 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus != 'unattended' and msw.dateCreated>=? and msw.dateCreated<=?",[sqlDate,sqlDate2])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    				if(statusType=="HWM"){
    				 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=?",[sqlDate,sqlDate2])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    				 
    			}else if(startDate1 && endDate1 && category!= "xyz" && status == "xyz" && statusType!="xyz"){
    				if(statusType=="BMW"){ 
    				bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.indRegMasterObj.category.id=? ",[sqlDate,sqlDate2,categoryLong])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    				}
    				if(statusType=="MSW"){
    				 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus != 'unattended' and msw.dateCreated>=? and msw.dateCreated<=? and msw.indRegMasterObj.category.id=? ",[sqlDate,sqlDate2,categoryLong])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    				if(statusType=="HWM"){
    				 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? and hwa.industryRegMasterObj.category.id=? ",[sqlDate,sqlDate2,categoryLong])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    			}else if(startDate1 && endDate1 && category == "xyz" && status != "xyz" && statusType!="xyz"){
    				if(statusType=="BMW"){
    				 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=?",[status,sqlDate,sqlDate2])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    				}
    				if(statusType=="MSW"){
    				 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = ? and msw.dateCreated>=? and msw.dateCreated<=?",[status,sqlDate,sqlDate2])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    				if(statusType=="HWM"){
    				 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = ? and hwa.dateCreated>=? and hwa.dateCreated<=?",[status,sqlDate,sqlDate2])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    			}else if(startDate1 && endDate1 && category != "xyz" && status != "xyz" && statusType!="xyz"){
    				if(statusType=="BMW"){
    				 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.indRegMasterObj.category.id=? ",[status,sqlDate,sqlDate2,categoryLong])
    				 if(bioList){
    		   				for(int a=0;a<bioList.size();a++)
    						{
    							allFourB=bioList.get(a)
    							if(allFourB)
    							{
    								checkBio=true
    								appListB.add((allFourB))
    								def appliFor="BMW"
    								def appliIdStr=(allFourB.id).toString()
    							def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    							def checkInst=	checkInstList[0]			
    							if(checkInst)
    												{
    												statusListB.add(checkInst.applicationStatus)
    												pendingWithB.add(checkInst.pendingWith)
    												pendingWithRoleB.add(checkInst.role)
    												}
    												else
    												{
    													statusListB.add("Unattended")
    													pendingWithB.add("Unknown")
    												    pendingWithRoleB.add("Unknown")
    												}
    							}
    						}
    		   				}
    				}
    				if(statusType=="MSW"){
    				 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = ? and msw.dateCreated>=? and msw.dateCreated<=? and msw.indRegMasterObj.category.id=? ",[status,sqlDate,sqlDate2,categoryLong])
    				 if(municipalList){
    		   				for(int a=0;a<municipalList.size();a++)
    						{
    							allFourM=municipalList.get(a)
    							if(allFourM)
    							{
    								checkBio=true
    								appListM.add((allFourM))
    								def appliFor="MSW"
    									def appliIdStr=(allFourM.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListM.add(checkInst.applicationStatus)
    													pendingWithM.add(checkInst.pendingWith)
    													pendingWithRoleM.add(checkInst.role)
    													}
    													else
    													{
    														statusListM.add("Unattended")
    														pendingWithM.add("Unknown")
    												    	pendingWithRoleM.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    				if(statusType=="HWM"){
    				 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = ? and hwa.dateCreated>=? and hwa.dateCreated<=? and hwa.industryRegMasterObj.category.id=? ",[status,sqlDate,sqlDate2,categoryLong])
    				 if(hazardeousList){
    		   				for(int a=0;a<hazardeousList.size();a++)
    						{
    							allFourH=hazardeousList.get(a)
    							if(allFourH)
    							{
    								checkBio=true
    								appListH.add((allFourH))
    								def appliFor="HWM"
    									def appliIdStr=(allFourH.id).toString()
    								def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    								def checkInst=	checkInstList[0]			
    								if(checkInst)
    													{
    													statusListH.add(checkInst.applicationStatus)
    													pendingWithH.add(checkInst.pendingWith)
    													pendingWithRoleH.add(checkInst.role)
    													}
    													else
    													{
    														statusListH.add("Unattended")
    														pendingWithH.add("Unknown")
    												    	pendingWithRoleH.add("Unknown")
    													}
    							}
    						}
    		   				}
    				}
    			}
    			}	
    		if(bioList && municipalList && hazardeousList){
    		finalListToPrint=bioList+municipalList+hazardeousList
    		}else if(bioList && municipalList && !hazardeousList){
    			finalListToPrint=bioList+municipalList
    		}else if(bioList && !municipalList && !hazardeousList){
    			finalListToPrint=bioList
    		}else if(!bioList && !municipalList && hazardeousList){
    			finalListToPrint=hazardeousList
    		}else if(!bioList && municipalList && !hazardeousList){
    			finalListToPrint=municipalList
    		}else if(bioList && !municipalList && hazardeousList){
    			finalListToPrint=bioList+municipalList+hazardeousList
    		}else if(!bioList && municipalList && hazardeousList){
    			finalListToPrint=municipalList+hazardeousList
    		}
    		render(view:'searchPage',model:[finalListToPrint:finalListToPrint,status:status,checkBio:checkBio,bioList:bioList,municipalList:municipalList,hazardeousList:hazardeousList,statusListB:statusListB,pendingWithB:pendingWithB,pendingWithRoleB:pendingWithRoleB,statusListM:statusListM,pendingWithM:pendingWithM,pendingWithRoleM:pendingWithRoleM,statusListH:statusListH,pendingWithH:pendingWithH,pendingWithRoleH:pendingWithRoleH])
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

def printAllCriteriasList={
    	 try {
    	   def applicationObject
    	    	def finalList=new ArrayList()
    	    	def statusList=new ArrayList()
    	    	def pendingWith=new ArrayList()
    			def pendingWithRole=new ArrayList()
    			def applicationFor=new ArrayList()
    	    	def checkingClass=params.listVal
    	    	if(checkingClass.getClass().getName()=="java.lang.String"){
    	    		def appId=checkingClass.toLong()
    	    		if(HazardeousWasteAuthApp.get(appId)){
    	    			applicationObject=HazardeousWasteAuthApp.get(appId)
    	    			finalList.add(applicationObject)
    	    			applicationFor.add("HWM")
    	    			def appliFor="HWM"
    					def appliIdStr=(appId).toString()
    					def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    					def checkInst=	checkInstList[0]			
    					if(checkInst)
    										{
    										statusList.add(checkInst.applicationStatus)
    										pendingWith.add(checkInst.pendingWith)
    										pendingWithRole.add(checkInst.role)
    										}
    										else
    										{
    											statusList.add("Unattended")
    											pendingWith.add("Unknown")
    											pendingWithRole.add("Unknown")
    										}
    	    		}else if(BioMedicalWaste.get(appId)){
    	    			applicationObject=BioMedicalWaste.get(appId)
    	    			finalList.add(applicationObject)
    	    			applicationFor.add("BMW")
    	    			def appliFor="BMW"
    					def appliIdStr=(appId).toString()
    					def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    					def checkInst=	checkInstList[0]			
    					if(checkInst)
    										{
    										statusList.add(checkInst.applicationStatus)
    										pendingWith.add(checkInst.pendingWith)
    										pendingWithRole.add(checkInst.role)
    										}
    										else
    										{
    											statusList.add("Unattended")
    											pendingWith.add("Unknown")
    											pendingWithRole.add("Unknown")
    										}
    	    		}else {
    	    			applicationObject=MunicipalSolidWaste.get(appId)
    	    			finalList.add(applicationObject)
    	    			applicationFor.add("MSW")
    	    			def appliFor="MSW"
    					def appliIdStr=(appId).toString()
    					def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    					def checkInst=	checkInstList[0]			
    					if(checkInst)
    										{
    										statusList.add(checkInst.applicationStatus)
    										pendingWith.add(checkInst.pendingWith)
    										pendingWithRole.add(checkInst.role)
    										}
    										else
    										{
    											statusList.add("Unattended")
    											pendingWith.add("Unknown")
    											pendingWithRole.add("Unknown")
    										}
    	    		}
    	    	}else {
    	    		for(int i=0;i<checkingClass.size();i++){
    	    		def appId=checkingClass[i].toLong()
    	    		if(HazardeousWasteAuthApp.get(appId)){
    	    			applicationObject=HazardeousWasteAuthApp.get(appId)
    	    			finalList.add(applicationObject)
    	    			applicationFor.add("HWM")
    	    			def appliFor="HWM"
    					def appliIdStr=(appId).toString()
    					def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
    					def checkInst=	checkInstList[0]			
    					if(checkInst)
    										{
    										statusList.add(checkInst.applicationStatus)
    										pendingWith.add(checkInst.pendingWith)
    										pendingWithRole.add(checkInst.role)
    										}
    										else
    										{
    											statusList.add("Unattended")
    											pendingWith.add("Unknown")
    											pendingWithRole.add("Unknown")
    										}
    		}else if(BioMedicalWaste.get(appId)){
    	    			applicationObject=BioMedicalWaste.get(appId)
    	    			finalList.add(applicationObject)
    	    			applicationFor.add("BMW")
    	    			def appliFor="BMW"
    					def appliIdStr=(appId).toString()
    					def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
    					def checkInst=	checkInstList[0]			
    					if(checkInst)
    										{
    										statusList.add(checkInst.applicationStatus)
    										pendingWith.add(checkInst.pendingWith)
    										pendingWithRole.add(checkInst.role)
    										}
    										else
    										{
    											statusList.add("Unattended")
    											pendingWith.add("Unknown")
    											pendingWithRole.add("Unknown")
    										}
    	    		}else {
    	    			applicationObject=MunicipalSolidWaste.get(appId)
    	    			finalList.add(applicationObject)
    	    			applicationFor.add("MSW")
    	    			def appliFor="MSW"
    					def appliIdStr=(appId).toString()
    					def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
    					def checkInst=	checkInstList[0]			
    					if(checkInst)
    										{
    										statusList.add(checkInst.applicationStatus)
    										pendingWith.add(checkInst.pendingWith)
    										pendingWithRole.add(checkInst.role)
    										}
    										else
    										{
    											statusList.add("Unattended")
    											pendingWith.add("Unknown")
    											pendingWithRole.add("Unknown")
    											
    										}
    	    		}
    	    		}
    	    	}
    	    	return [finalList:finalList,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole,applicationFor:applicationFor]
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

def routeUnattended={
    	 try {
    	  def applicationUnattendedCountB=BioMedicalWaste.findAll("From BioMedicalWaste as bmw WHERE  bmw.applicationStatus='unattended' and  bmw.completionStatus='Completed' ")
    	    	def applicationUnattendedCountM=MunicipalSolidWaste.findAll("From MunicipalSolidWaste as bmw WHERE  bmw.applicationStatus='unattended' and bmw.completionStatus='Completed' ")
    	    	def applicationUnattendedCountH=HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp as bmw WHERE  bmw.applicationStatus='unattended' and bmw.completionStatus='Completed'" )
    	    	def allFourB= new ArrayList()
    	    	def appListB= new ArrayList()
    	    	def allFourM= new ArrayList()
    	    	def appListM= new ArrayList()
    	    	def allFourH= new ArrayList()
    	    	def appListH= new ArrayList()
    	    	if(applicationUnattendedCountB){
    				for(int variable1=0;variable1<applicationUnattendedCountB.size();variable1++)
    					{
    						allFourB=applicationUnattendedCountB.get(variable1)
    						if(allFourB)
    							{
    								appListB.add((allFourB))
    							}
    					}
    				}
    				if(applicationUnattendedCountM){
    				for(int variable1=0;variable1<applicationUnattendedCountM.size();variable1++)
    					{
    						allFourM=applicationUnattendedCountM.get(variable1)
    						if(allFourM)
    						{
    							
    							appListM.add((allFourM))
    							
    						}
    					}
    				}
    				if(applicationUnattendedCountH){
    				for(int variable1=0;variable1<applicationUnattendedCountH.size();variable1++)
    					{
    						allFourH=applicationUnattendedCountH.get(variable1)
    						if(allFourH)
    						{
    							appListH.add((allFourH))
    						}
    					}
    				}
    				return[appListB:appListB,appListM:appListM,appListH:appListH]
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

def routeChecked={
    	 try {
    	        def groupPresentBio=new ArrayList()
    			def groupPresentMun=new ArrayList()
    			def groupPresentHaz=new ArrayList()
    			def offIns=OfficeMaster.findByPriority(1)
    			groupPresentBio=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc='BMW' and gm.office=? ",[offIns])
    			groupPresentMun=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc='MSW' and gm.office=? ",[offIns])
    			groupPresentHaz=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc='HWM' and gm.office=? ",[offIns])
    			def checkMessage=false
    			def checkMessageList=false
    			def indregInstance
    			def routed
    			def bioGroup
    			def munGroup
    			def hazGroup
    	    	def groupName
    	    	def objectType 
    	    	def grpList
    	    	def group = new GroupMaster()
    	    	/*if(groupPresentBio){
    				bioGroup=groupPresentBio[0]
    			}
    	    	if(groupPresentMun){
    	    		munGroup=groupPresentMun[0]
    	    	}
    	    	if(groupPresentHaz){
    	    		hazGroup=groupPresentHaz[0]
    	    	}*/
    	    	
    	    	def applicationObject
    	    	def checkingClass=params.routeThese
    	    	if(checkingClass.getClass().getName()=="java.lang.String"){
    	    		def appId=checkingClass.toLong()
    	    		if(HazardeousWasteAuthApp.get(appId)){
    	    			applicationObject=HazardeousWasteAuthApp.get(appId)
    	    			indregInstance=applicationObject.industryRegMasterObj
    	    			def locationId = applicationObject.industryRegMasterObj.district.id
    	    			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
    	    			for(int i=0;i<grpList.size();i++){
    	    				
    	    				
    	    				if(((grpList.get(i)).group).office == offIns){
    	    					
    	    					group = (grpList.get(i)).group
    	    				}
    	    			}
    	    			def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    			for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new WasteManagementPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationFor = "HWM"
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance;
    	    						appPendDetails
    	    						checkMessage=true
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="Inprogress"
    	    								applicationObject.save()
    	    						}else{

    	    							if(appPendDetails.hasErrors()){
    	    								appPendDetails.errors.allErrors.each {
    	    				        			 println it
    	    				        		 }
    	    				        	 }
    	    			    		}
    	    					}else{
    	    					}
    	    				}
    	    				if(!checkMessage){
    							flash.message="Hazardeous waste Group workflow not set.  "	
    						}
    	    			
    	    		}else if(BioMedicalWaste.get(appId)){
    	    			applicationObject=BioMedicalWaste.get(appId)
    	    			indregInstance=applicationObject.indRegMasterObj
    	    			def locationId = applicationObject.indRegMasterObj.district.id
    	    			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
    	    			for(int i=0;i<grpList.size();i++){
    	    				
    	    				
    	    				if(((grpList.get(i)).group).office == offIns){
    	    					
    	    					group = (grpList.get(i)).group
    	    				}
    	    			}
    	    			
    	    				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new WasteManagementPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationFor = "BMW"
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						checkMessage=true
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="Inprogress"
    	    								applicationObject.save()
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		   }
    	    			    		}
    	    					}else{
    	    					}
    	    				}
    	    				if(!checkMessage){
    	    					flash.message=" BioMedical Group workflow not set.  "
    						}
    	    			//}
    	    		}else{
    	    			applicationObject=MunicipalSolidWaste.get(appId)
    	    			indregInstance=applicationObject.indRegMasterObj
    	    			def locationId = applicationObject.indRegMasterObj.district.id
    	    			grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
    	    			for(int i=0;i<grpList.size();i++){
    	    				
    	    				
    	    				if(((grpList.get(i)).group).office == offIns){
    	    					
    	    					group = (grpList.get(i)).group
    	    				}
    	    			}
    	    			
    	    				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new WasteManagementPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationFor = "MSW"
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						checkMessage=true
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="Inprogress"
    	    								applicationObject.save()
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		   }
    	    			    		}
    	    					}else{
    	    					}
    	    				}
    	    				if(!checkMessage){
    	        				flash.message=" Municipal Solid Group workflow not set.  "
    	    				}
    	    			//}
    	    		}
    	    }else{
    	    	for(int vari=0;vari<checkingClass.size();vari++){
    	    		def appId=checkingClass[vari].toLong()
    	    		if(HazardeousWasteAuthApp.get(appId)){
    	    			applicationObject=HazardeousWasteAuthApp.get(appId)
    	    			indregInstance=applicationObject.industryRegMasterObj
    	    			if(!hazGroup){
    	    				flash.message="Hazardeous waste Group not created .  "
    	    			}else{
    	    				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    				groupName=hazGroup.groupName
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new WasteManagementPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationFor = "HWM"
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						checkMessageList=true
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="Inprogress"
    	    								applicationObject.save()
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		   }
    	    			    		}
    	    					}else{
    	    					}
    	    				}
    	    				if(!checkMessageList){
    							flash.message="Hazardeous waste Group workflow not set.  "
    						}
    	    			}
    	    		}else if(BioMedicalWaste.get(appId)){
    	    			applicationObject=BioMedicalWaste.get(appId)
    	    			indregInstance=applicationObject.indRegMasterObj
    	    			if(!bioGroup){
    	    				flash.message=" BioMedical Group not created .  "
    	    			}else{
    	    				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    				groupName=bioGroup.groupName
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new WasteManagementPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationFor = "BMW"
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						checkMessageList="true"
    	    					appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="Inprogress"
    	    								applicationObject.save()
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		        
    	    			    		   }
    	    			    		}
    	    					}else{
    	    					}
    	    				}
    	    				if(!checkMessageList){
    							flash.message=" BioMedical Group workflow not set.  "
    						}
    	    			}
    	    		}else{
    	    			applicationObject=MunicipalSolidWaste.get(appId)
    	    			indregInstance=applicationObject.indRegMasterObj
    	if(!munGroup){
    		flash.message=" Municipal Solid Group not created .  "
    	    			}else{
    	    				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    				groupName=munGroup.groupName
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new WasteManagementPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationFor = "MSW"
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						checkMessageList="true"
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="Inprogress"
    	    								applicationObject.save()
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		   }
    	    			    		}
    	    					}else{
    	    					}
    	    				}
    	    				if(!checkMessageList){
    							flash.message=" Municipal Solid Group workflow not set.  "
    						}
    	    			}
    	    		}
    	    	}
    	    }
    	    	redirect(action:routeUnattended)
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
    
    
    def pendingList2={
    		def userProfileInstance=(UserMaster) session.userMaster
    		def application
    		def isClarList=new ArrayList()
    		def isInspecList=new ArrayList()
    		def isShowCauseList=new ArrayList()
    		def appId
    		def wasteManagementPendingList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wpd where wpd.applicationFor='PWM' and wpd.pendingWith=? and wpd.applicationStatus='pending'",[userProfileInstance])
    		println("wasteManagementPendingList "+wasteManagementPendingList)
    		if(wasteManagementPendingList){
    		for (int i=0;i<wasteManagementPendingList.size();i++){
    			def instancePend=wasteManagementPendingList[i]
    			def appFor=instancePend.applicationFor
    			def appIdStr=instancePend.applicationId
    			appId=(instancePend.applicationId).toLong()
    			println("appId....................."+appId)
    			if(appFor=="HWM"){
    	    		application=HazardeousWasteAuthApp.get(appId)
    	    		isClarList.add(application.clarification)
    	    		isShowCauseList.add(application.showCause)
    	    		isInspecList.add(application.inspection)
    	    	}else if(appFor=="MSW"){
    	    		application=MunicipalSolidWaste.get(appId)
    	    		isClarList.add(application.clarification)
    	    		isInspecList.add(application.inspection)
    	    	}else if(appFor=="PWM"){
    	    		application=PlasticWaste.get(appId)
    	    		isClarList.add(application.clarification)
    	    		isShowCauseList.add(application.showCause)
    	    		isInspecList.add(application.inspection)
    	    	}else{
    	    		application=BioMedicalWaste.get(appId)
    	    		isClarList.add(application.clarification)
    	    		isShowCauseList.add(application.showCause)
    	    		isInspecList.add(application.inspection)
    	    	}
    		}
    		}
    		def wasteManagementCompletedList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wpd where wpd.applicationFor='PWM' and wpd.pendingWith=? and wpd.applicationStatus!='pending' and wpd.applicationStatus!='returned' order by wpd.dateCreated desc",[userProfileInstance]) 
    		println("  wasteManagementPendingList  "+wasteManagementPendingList+ "  wasteManagementCompletedList  "+wasteManagementCompletedList)
    		return ['wasteManagementPendingList':wasteManagementPendingList,wasteManagementCompletedList:wasteManagementCompletedList,isShowCauseList:isShowCauseList,isClarList:isClarList,isInspecList:isInspecList,appId:appId]

    	}
    
    
//  added a new method for show clarification in spcb user// start by shashank
    def viewClarification = {
    		 try {
    			    

//    			 println("params shashank---"+params)
    	        	def appFor=params.appFor
    	        	def appliId=params.appliId
//    	        	println("shashank id"+appliId)
    	       	    def appId=appliId.toLong()
    	       	    def application
    	       	    if(appFor == "HWM"){
    	    		      application=HazardeousWasteAuthApp.get(appId)
    	       	 }else if(appFor == "MSW"){
    	     		application=MunicipalSolidWaste.get(appId)
    	       	}else {
    	        	
    	        	 application=BioMedicalWaste.get(appId)
    	       	}
//    	        	println("appFor---"+appFor)
//    	        	 println("application---"+application)

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
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	          
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }
    }
    //end by shashank
    
 /******   //added a action for view inspection report on inspection window by shashank   */
    
    def viewInspection = {
    		 try {
    			    
    	    		
    		    	

//    			 println("params shashank---"+params)
    	        	def appFor=params.appFor
    	        	def appliId=params.appliId
//    	        	println("shashank id"+appliId)
    	       	    def appId=appliId.toLong()
    	       	    def application
    	       	    if(appFor == "HWM"){
    	    		      application=HazardeousWasteAuthApp.get(appId)
    	       	 }else if(appFor == "MSW"){
    	     		application=MunicipalSolidWaste.get(appId)
    	       	}else {
    	        	
    	        	 application=BioMedicalWaste.get(appId)
    	       	}
//    	        	println("appFor---"+appFor)
//    	        	 println("application---"+application)
    		    	def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor=? order by wmpd.id desc",[appliId,appFor]) 

    		    	
    		    	for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){

    		    		if((applicationProcessingDetailsInstanceList.get(i)).inspection){
    		    			return[appClarification:applicationProcessingDetailsInstanceList.get(i),app:application,appFor:appFor,appliId:appliId]
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
}