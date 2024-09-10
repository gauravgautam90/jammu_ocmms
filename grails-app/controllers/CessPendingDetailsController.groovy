import groovy.sql.*
import java.lang.Exception
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File
import java.io.FileInputStream
import java.lang.NumberFormatException
import java.util.*;
import java.text.*;

class CessPendingDetailsController {
    def dataSource
    
    def index = {
    		 try {
    		       redirect(action:list,params:params) 
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    	       params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ cessPendingDetailsInstanceList: CessPendingDetails.list( params ), cessPendingDetailsInstanceTotal: CessPendingDetails.count() ]
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
    	       def cessPendingDetailsInstance = CessPendingDetails.get( params.id )
    	       if(!cessPendingDetailsInstance) {
    	            flash.message = "CessPendingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ cessPendingDetailsInstance : cessPendingDetailsInstance ] }
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
        def cessPendingDetailsInstance = CessPendingDetails.get( params.id )
        if(cessPendingDetailsInstance) {
            try {
                cessPendingDetailsInstance.delete()
                flash.message = "CessPendingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CessPendingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "CessPendingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	       def cessPendingDetailsInstance = CessPendingDetails.get( params.id )
    	       if(!cessPendingDetailsInstance) {
    	            flash.message = "CessPendingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ cessPendingDetailsInstance : cessPendingDetailsInstance ]
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
    	      def cessPendingDetailsInstance = CessPendingDetails.get( params.id )
    	        if(cessPendingDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(cessPendingDetailsInstance.version > version) {
    	                   cessPendingDetailsInstance.errors.rejectValue("version", "cessPendingDetails.optimistic.locking.failure", "Another user has updated this CessPendingDetails while you were editing.")
    	                    render(view:'edit',model:[cessPendingDetailsInstance:cessPendingDetailsInstance])
    	                    return
    	                }
    	            }
    	            cessPendingDetailsInstance.properties = params
    	            if(!cessPendingDetailsInstance.hasErrors() && cessPendingDetailsInstance.save()) {
    	                flash.message = "CessPendingDetails ${params.id} updated"
    	                redirect(action:show,id:cessPendingDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[cessPendingDetailsInstance:cessPendingDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "CessPendingDetails not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
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

    def create = {
    	 try {
    	       def cessPendingDetailsInstance = new CessPendingDetails()
    	        cessPendingDetailsInstance.properties = params
    	        return ['cessPendingDetailsInstance':cessPendingDetailsInstance]
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
    	      def cessPendingDetailsInstance = new CessPendingDetails(params)
    	        if(!cessPendingDetailsInstance.hasErrors() && cessPendingDetailsInstance.save()) {
    	            flash.message = "CessPendingDetails ${cessPendingDetailsInstance.id} created"
    	            redirect(action:show,id:cessPendingDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[cessPendingDetailsInstance:cessPendingDetailsInstance])
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
    
    def cessPendingReturn={
    	 try {
    	      def userProfileInstance=(UserMaster) session.userMaster 
    	    	def currentDate=new Date()
    	    	def listlist=CessPendingDetails.list()
    	    	def cessList=CessPendingDetails.findAll("from CessPendingDetails as cd where cd.pendingWith=? and cd.applicationStatus='pending' order by cd.cessReturn.id",[userProfileInstance])
    	    	def cessPendingList=CessPendingDetails.findAll("from CessPendingDetails as cpd where cpd.pendingWith=? and cpd.applicationStatus='pending' order by cpd.cessReturn.id desc",[userProfileInstance])
    	    	def cessCompletedList=CessPendingDetails.findAll("from CessPendingDetails as cpd where cpd.pendingWith=? and cpd.applicationStatus='completed' order by cpd.cessReturn.id desc",[userProfileInstance]) 
    	    	return ['cessPendingList':cessPendingList,cessCompletedList:cessCompletedList]
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
    
    def cessUnattendedApplications={
    	 try {
    	      def unattendedApplications=CessUnattendedApplication.findAll("from CessUnattendedApplication as cua where cua.routedStatus='unattended' order by cua.cessReturn.id desc")
    	    	return ['unattendedApplications':unattendedApplications]
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
    
    def cessDefaulter={
    }
    
    def searchCessDefaulter={
    	 try {
    	      def paramList=params
    	    	def monthValue=params.monthValue
    	    	def yearValue=params.yearValue
    	    	def monthValue11=params.monthValue
    	    	def yearValue11=params.yearValue
    	    	def fromDate 
    	    			def fromYear = params.yearValue.toInteger()
    				def fromMonth = params.monthValue
    				if (fromMonth=="January"){
    					fromMonth = "01"
    				}else if(fromMonth=="February"){
    					fromMonth = "02"
    				}else if(fromMonth=="March"){
    					fromMonth = "03"
    				}else if(fromMonth=="April"){
    					fromMonth = "04"
    				}else if(fromMonth=="May"){
    					fromMonth = "05"
    				}else if(fromMonth=="June"){
    					fromMonth = "06"
    				}else if(fromMonth=="July"){
    					fromMonth = "07"
    				}else if(fromMonth=="August"){
    					fromMonth = "08"
    				}else if(fromMonth=="September"){
    					fromMonth = "09"
    				}else if(fromMonth=="October"){
    					fromMonth = "10"
    				}else if(fromMonth=="November"){
    					fromMonth = "11"
    				}else if(fromMonth=="December"){
    					fromMonth = "12"
    				}
    			if(fromMonth=="01"||fromMonth=="03"||fromMonth=="05"||fromMonth=="07"||fromMonth=="08"||fromMonth=="10"||fromMonth=="12"){
    	    		fromDate = "31"
    			}else if (fromMonth=="04"||fromMonth=="06"||fromMonth=="09"||fromMonth=="11"){
    				fromDate = "30"
    			}else if (fromMonth=="02"){
    				boolean isLeapYear = ((fromYear % 4 == 0) && (fromYear % 100 != 0) || (fromYear % 400 == 0));
    				if (isLeapYear)
    		        {
    		        	fromDate = "29"
    		        } else
    		        	fromDate = "28"
    			}
    				
    	    	String appliedFromDate = fromYear+"/"+fromMonth+"/"+fromDate
    				def startDate1=appliedFromDate
    				String monthYear
    				def x
    				def a
    							
    				java.sql.Date upperDate
    				def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
    					x = sdfh.parse(startDate1); //Date
    					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    					
    	    	def cessDefaultersList=new ArrayList()
    	    	def cessPendingdetailsList=CessPendingDetails.findAll("from CessPendingDetails as cpd where cpd.cessAppliedToDate >=? ",[sqlDate])
    	    	def cessUnattendedList=CessUnattendedApplication.findAll("from CessUnattendedApplication as cua where cua.cessAppliedToDate >=? ",[sqlDate])
    	    	def industryRegList=IndustryRegMaster.list()
    	    	
    	    	for(int var1=0;var1<industryRegList.size();var1++){
    	    		def checkVar1=false
    	    		def industryRegInstance=industryRegList.get(var1)
    	    		for(int var2=0;var2<cessPendingdetailsList.size();var2++){
    	    			def industryCessPending=(cessPendingdetailsList.get(var2)).indRegInstance
    	    			if(industryRegInstance==industryCessPending){
    	    				checkVar1=true
    	    			}
    	    		}
    	    		if(!checkVar1){
    	    		for(int var3=0;var3<cessUnattendedList.size();var3++){
    	    			def industryCessUnattended=(cessUnattendedList.get(var3)).indRegInstance
    	    			if(industryRegInstance==industryCessUnattended){
    	    				checkVar1=true
    	    			}
    	    		}}
    	    		if(!checkVar1){
    	    			cessDefaultersList.add(industryRegInstance)
    	    		}
    	    	}
    			session.cessDefaultersList = cessDefaultersList
    			session.MonthAndYear = monthValue11+"/"+yearValue11
    	    	 render(view:'cessDefaulter',model:[cessDefaultersList:cessDefaultersList,monthValue11:monthValue11,yearValue11:yearValue11,paramList:paramList,monthVal:monthValue,yearVal:yearValue])
    	    
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
    
    def generateDefaulterNotice={
    	 try {
    	    	def monthValue=params.monthValue
    	    	def yearValue=params.yearValue
    	    	def industryReg=IndustryRegMaster.get((params.id).toLong())
    	    	return ['industryReg':industryReg,monthValue:monthValue,yearValue:yearValue]
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
    
    def generateNotice={
    	 try {
    	    	
    	    	File noticeForm1A
    	    	def industryReg=IndustryRegMaster.get((params.idIndReg).toLong()) 
    	    	def varCheck=false
    	    	CessFileRecord file=new CessFileRecord() 
    	    	def industryName=industryReg.indName+""
    			def industryPlot=industryReg.plotNo+""
    			def industryAddress=industryReg.indAddress+""
    			def industryTehsil=industryReg.tehsil.tehsilName+""
    			def industryDistrict=industryReg.district.districtName+""
    			def copyTo=params.copyTo
    			def noticeNum=params.fileNumber
    			def fileNumber=params.fileNumber
    			 def dateNotice=params.draftLetterDate_value
    			 def assessmentPeriodFrom=params.grantedFrom_value
    			 def assessmentPeriodTo=params.grantedTo_value
    			 def month=params.monthValue
    			 def officeAddress=params.offAddres
    			 def offDistrict=params.nameOfDistrict
    			 def monthValue=params.monthValue
    		    	def yearValue=params.yearValue
    		    
    			 def check =  CessFileRecord.findAll("from CessFileRecord cfr where cfr.month=? And cfr.year=? and indreg=?",[monthValue,yearValue,industryReg])
    			 if(check)
    			 {
    				 flash.message="Notice for ${monthValue}/${yearValue} was Already generated to ${industryName}"
    	    		 render(view:'cessDefaulter')
    	    	}
    			 else
    			 {
    			 Form1A_Notice fileNotice=new Form1A_Notice()
    	    	noticeForm1A= fileNotice.Form1A_Notice_Function(offDistrict,dateNotice,officeAddress,industryName,industryPlot,industryAddress,industryTehsil,industryDistrict,noticeNum,assessmentPeriodFrom,assessmentPeriodTo, month,copyTo, fileNumber)
    	    	 byte[] b = new byte[(int) noticeForm1A.length()];
    		        
    		        FileInputStream fileInputStream = new FileInputStream(noticeForm1A);
    		        fileInputStream.read(b);
    		 	        
    		 	        def fileLength=noticeForm1A.length()
    		        	file.size = fileLength / 1024  //f.getSize() 
    		 	         file.extension ="pdf"//extractExtension( f )
    		 	       	 file.data=b;
    		 	       	 file.name="noticeForm1A.pdf"
    		 	    	 file.description="Notice Cess"
    		 	    	 file.createdBy=session.userMaster
    		 	    	 file.updatedBy=session.userMaster
    		 	    	 file.typeOfFile="NoticeForm1A"
    		 	    	 file.indreg=industryReg
    		 	    	 
    		 	    	file.month=monthValue
    		 	    	file.year=yearValue
    		 	    	
    		 	    	if(file.save()) {
    		 	    	  varCheck=true
    		 	    	 flash.message="Notice Generated to ${industryName} for ${monthValue}/${yearValue} "
    		 	    	 render(view:'cessDefaulter')
    		 	    	   } else {
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
    
    def downLoadNotice = {
    	 try {
   		  def fileVer=(params.id).toLong()
   	    	def applicationFileInstance = CessFileRecord.get(fileVer)
   	    	def applicationFileSingleInstance=applicationFileInstance
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
    
    def viewCessDefaulterPage={
    	
    }
    
    def viewCessDefaulter={
    	 try {
   		  	def monthV=params.monthValue
    	    	def yearV=params.yearValue
    	    	
    	    	def noticeList=CessFileRecord.findAll("from CessFileRecord as cfreco where cfreco.month=? and cfreco.year=? order by cfreco.id desc",[monthV,yearV])
    	    	
    	    	session.MonthAndYear=monthV+"/"+yearV
    	    	session.noticeList=noticeList
    	    	render(view:'viewCessDefaulterPage',model:[noticeList:noticeList,monthVal:monthV,yearVal:yearV])
    	    
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
   
    def popGeneratedCessDefaulter={
    	 try {
    			def cessDefaultersListSession = session.cessDefaultersList
    	    	def MonthAndYear=session.MonthAndYear
    	    	render(view:'popGeneratedCessDefaulter',model:[cessDefaultersListSession:cessDefaultersListSession,MonthAndYear:MonthAndYear])
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
    
    def popViewCessDefaulter={
    	 try {
    			def MonthAndYear1=session.MonthAndYear
    	    	def noticeList=session.noticeList
    	    	render(view:'popViewCessDefaulter',model:[noticeList:noticeList,MonthAndYear1:MonthAndYear1])
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
