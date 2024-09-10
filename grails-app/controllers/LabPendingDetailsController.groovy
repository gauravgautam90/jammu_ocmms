

import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
class LabPendingDetailsController {
    
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
	        [ labPendingDetailsInstanceList: LabPendingDetails.list( params ), labPendingDetailsInstanceTotal: LabPendingDetails.count() ]
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
		 def labPendingDetailsInstance = LabPendingDetails.get( params.id )
	        if(!labPendingDetailsInstance) {
	            flash.message = "LabPendingDetails not found with id ${params.id}"
	            redirect(action:list)
	        }
	        else { return [ labPendingDetailsInstance : labPendingDetailsInstance ] }
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
        def labPendingDetailsInstance = LabPendingDetails.get( params.id )
        if(labPendingDetailsInstance) {
            try {
                labPendingDetailsInstance.delete()
                flash.message = "LabPendingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "LabPendingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "LabPendingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
	 try {
		 def labPendingDetailsInstance = LabPendingDetails.get( params.id )
	        if(!labPendingDetailsInstance) {
	            flash.message = "LabPendingDetails not found with id ${params.id}"
	            redirect(action:list)
	        }
	        else {
	            return [ labPendingDetailsInstance : labPendingDetailsInstance ]
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
		 def labPendingDetailsInstance = LabPendingDetails.get( params.id )
	        if(labPendingDetailsInstance) {
	            if(params.version) {
	                def version = params.version.toLong()
	                if(labPendingDetailsInstance.version > version) {
	                    labPendingDetailsInstance.errors.rejectValue("version", "labPendingDetails.optimistic.locking.failure", "Another user has updated this LabPendingDetails while you were editing.")
	                    render(view:'edit',model:[labPendingDetailsInstance:labPendingDetailsInstance])
	                    return
	                }
	            }
	            labPendingDetailsInstance.properties = params
	            if(!labPendingDetailsInstance.hasErrors() && labPendingDetailsInstance.save()) {
	                flash.message = "LabPendingDetails ${params.id} updated"
	                redirect(action:show,id:labPendingDetailsInstance.id)
	            }
	            else {
	                render(view:'edit',model:[labPendingDetailsInstance:labPendingDetailsInstance])
	            }
	        }
	        else {
	            flash.message = "LabPendingDetails not found with id ${params.id}"
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
		def labPendingDetailsInstance = new LabPendingDetails()
	        labPendingDetailsInstance.properties = params
	        return ['labPendingDetailsInstance':labPendingDetailsInstance]
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
		 def labPendingDetailsInstance = new LabPendingDetails(params)
	        if(!labPendingDetailsInstance.hasErrors() && labPendingDetailsInstance.save()) {
	            flash.message = "LabPendingDetails ${labPendingDetailsInstance.id} created"
	            redirect(action:show,id:labPendingDetailsInstance.id)
	        }
	        else {
	            render(view:'create',model:[labPendingDetailsInstance:labPendingDetailsInstance])
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
    
 def labDashBoard={
	 try {
		def userProfileInstance=(UserMaster) session.userMaster 
	    	def currentDate=new Date()
	    	def listlist=LabPendingDetails.list()
	    	def labPendingList=LabPendingDetails.findAll("from LabPendingDetails as cpd where cpd.pendingWith=? and cpd.applicationStatus='pending' order by cpd.sample.id desc",[userProfileInstance])
	    	def labCompletedList=LabPendingDetails.findAll("from LabPendingDetails as cpd where cpd.pendingWith=? and cpd.applicationStatus='completed' order by cpd.sample.id desc",[userProfileInstance])
	    	return ['labPendingList':labPendingList,labCompletedList:labCompletedList]
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
    
 def labSampleDashBoard={
	 try {
		def userProfileInstance=session.userMaster 
	    	def userIns=(session.userMaster).toString()
	    	def currentDate=new Date()
	    	 def sampleIncompleteWater=Lab_WaterEffluentMonitoring.findAll("from Lab_WaterEffluentMonitoring as lwm where lwm.completionStatus='pending' and lwm.createdBy=? order by lwm.id",[userIns])
		   def sampleCompleteWater=Lab_WaterEffluentMonitoring.findAll("from Lab_WaterEffluentMonitoring as lwm where lwm.completionStatus='completed' and lwm.createdBy=? order by lwm.id",[userIns])
		  def sampleIncompleteAir=Lab_AmbientAirMonitoring.findAll("from Lab_AmbientAirMonitoring as lwm where lwm.completionStatus='pending' and lwm.createdBy=? order by lwm.id",[userIns])
		  def sampleCompleteAir=Lab_AmbientAirMonitoring.findAll("from Lab_AmbientAirMonitoring as lwm where lwm.completionStatus='completed' and lwm.createdBy=? order by lwm.id",[userIns])
			return ['sampleIncompleteWater':sampleIncompleteWater,sampleCompleteWater:sampleCompleteWater,sampleIncompleteAir:sampleIncompleteAir,sampleCompleteAir:sampleCompleteAir]
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
    
 def searchPage={}
 
 def labSummary={
	 try {
			def applicationReceivedCount=LabPendingDetails.list(sort:"id", order:"desc")
	    	def applicationPendingCount=LabPendingDetails.findAll("From LabPendingDetails as cpd WHERE  cpd.applicationStatus='pending' order by cpd.id")
	    	def applicationCompletedCount=LabPendingDetails.findAll("From LabPendingDetails as cpd WHERE cpd.applicationStatus='completed' order by cpd.id")
	    	def receivedSize=applicationReceivedCount.size()
	    	def pendingSize=applicationPendingCount.size()
	    	def completedSize=applicationCompletedCount.size()
	    	def linksch="true"
	    	def labMidList
	    	def formList=new ArrayList()
	    		if(params.checkVar){
	       			if(params.checkVar=="received"){
	       				if(applicationReceivedCount){
	       					for(int i=0;i<applicationReceivedCount.size();i++){
	       						labMidList=applicationReceivedCount[i]
	       						formList.add(labMidList)
	       					}
	       				}
	       			}else if(params.checkVar=="completed"){
	       				if(applicationCompletedCount){
	       					for(int i=0;i<applicationCompletedCount.size();i++){
	       						labMidList=applicationCompletedCount[i]
	       						formList.add(labMidList)
	       						}
	       				}
	       			}else if(params.checkVar=="pending"){
	       				if(applicationPendingCount){
	       					for(int i=0;i<applicationPendingCount.size();i++){
	       						labMidList=applicationPendingCount[i]
	       						formList.add(labMidList)
	       						}
	       				}
	       				}
	       		}
	    	render(view:'searchPage',model:[receivedSize:receivedSize,pendingSize:pendingSize,completedSize:completedSize,linksch:linksch,formList:formList])
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
			def allFour= new ArrayList()
	    	def appList= new ArrayList()
	    	def statusList= new ArrayList()
	    	def pendingWith= new ArrayList()
			def pendingWithRole= new ArrayList()
	    	def pendTableList=new ArrayList()
			def formList=new ArrayList()
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
				redirect(action:labSummary)
			}	
			if(checkDate)
			{
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				sqlDate2.setDate((sqlDate2.getDate()+1))
			def labMidList
			def labSearchList=LabPendingDetails.findAll("from LabPendingDetails as cpd WHERE cpd.dateCreated>? and cpd.dateCreated<? order by cpd.id desc",[sqlDate,sqlDate2])
			if(labSearchList){
				for(int i=0;i<labSearchList.size();i++){
					labMidList=labSearchList[i]
					formList.add(labMidList)
					}
			}
			}
			def applicationReceivedCount=LabPendingDetails.list(sort:"id", order:"desc")
	    	def applicationPendingCount=LabPendingDetails.findAll("From LabPendingDetails as cpd WHERE  cpd.applicationStatus='pending' order by cpd.id")
	    	def applicationCompletedCount=LabPendingDetails.findAll("From LabPendingDetails as cpd WHERE cpd.applicationStatus='completed' order by cpd.id")
	    	def receivedSize=applicationReceivedCount.size()
	    	def pendingSize=applicationPendingCount.size()
	    	def completedSize=applicationCompletedCount.size()
	    	def linksch="true"
	    	render(view:'searchPage',model:[receivedSize:receivedSize,pendingSize:pendingSize,completedSize:completedSize,linksch:linksch,formList:formList])
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
