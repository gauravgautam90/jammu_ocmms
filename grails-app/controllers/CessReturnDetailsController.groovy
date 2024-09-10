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
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile

class CessReturnDetailsController {
    
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    			 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ cessReturnDetailsInstanceList: CessReturnDetails.list( params ), cessReturnDetailsInstanceTotal: CessReturnDetails.count() ]
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

    def show = {
    	 try {
    			def cessReturnDetailsInstance = CessReturnDetails.get( params.id )
    			if(!cessReturnDetailsInstance) {
    	            flash.message = "CessReturnDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ cessReturnDetailsInstance : cessReturnDetailsInstance ] }
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

    def delete = {
        def cessReturnDetailsInstance = CessReturnDetails.get( params.id )
        if(cessReturnDetailsInstance) {
            try {
                cessReturnDetailsInstance.delete()
                flash.message = "CessReturnDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CessReturnDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "CessReturnDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    			def cessReturnDetailsInstance = CessReturnDetails.get( params.id )
    			if(!cessReturnDetailsInstance) {
    	            flash.message = "CessReturnDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ cessReturnDetailsInstance : cessReturnDetailsInstance ]
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

    def update = {
    	 try {
    			 def cessReturnDetailsInstance = CessReturnDetails.get( params.id )
    	        if(cessReturnDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(cessReturnDetailsInstance.version > version) {
    	                    
    	                    cessReturnDetailsInstance.errors.rejectValue("version", "cessReturnDetails.optimistic.locking.failure", "Another user has updated this CessReturnDetails while you were editing.")
    	                    render(view:'edit',model:[cessReturnDetailsInstance:cessReturnDetailsInstance])
    	                    return
    	                }
    	            }
    	            cessReturnDetailsInstance.properties = params
    	            if(!cessReturnDetailsInstance.hasErrors() && cessReturnDetailsInstance.save()) {
    	                flash.message = "CessReturnDetails ${params.id} updated"
    	                redirect(action:show,id:cessReturnDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[cessReturnDetailsInstance:cessReturnDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "CessReturnDetails not found with id ${params.id}"
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
    			def cessReturnDetailsInstance = new CessReturnDetails()
    	        cessReturnDetailsInstance.properties = params
    	        return ['cessReturnDetailsInstance':cessReturnDetailsInstance]
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

    def save = {
    	 try {
    			 def cessReturnDetailsInstance = new CessReturnDetails(params)
    	        if(!cessReturnDetailsInstance.hasErrors() && cessReturnDetailsInstance.save()) {
    	            flash.message = "CessReturnDetails ${cessReturnDetailsInstance.id} created"
    	            redirect(action:show,id:cessReturnDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[cessReturnDetailsInstance:cessReturnDetailsInstance])
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
    
    def searchUtility={
    	 try {
    			def appIdList=CessReturn.findAll(" from CessReturn cr where cr.completionStatus='completed' order by cr.id desc")
    	    	  return ['appIdList':appIdList]
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
    
    def searchCessApplication={
    	 try {
    			def checkVar=false
    	    	def countVar
    	    	def cessReturnInstList=new ArrayList()
    	    	def statusList= new ArrayList()
    	    	def pendingWith= new ArrayList()
    			def pendingWithRole= new ArrayList()
    	    	def appIdList=CessReturn.findAll(" from CessReturn cr where cr.completionStatus='completed' order by cr.id desc")
    	    	if(params.searchOp=="ApplId"){
    	    		if(params.autocomplete_parameter==null || params.autocomplete_parameter=="xyz")
    					{
    	    				flash.message="Please Select the Application Id"
    						redirect(action:searchUtility)
    					}else {
    						cessReturnInstList=CessReturn.get((params.autocomplete_parameter).toLong())
    						countVar=1
    						def checkInst=CessPendingDetails.findByCessReturn(cessReturnInstList)
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
    	    		checkVar=true
    	    	}else if(params.searchOp=="ApplName"){
    	    		
    	    		def firstInput = (params.autocomplete_parameter1).toLowerCase()
    	    		
    				def input1= firstInput + '%' 
    				if(params.autocomplete_parameter1==null || params.autocomplete_parameter1=="")
    					{
    						flash.message="Please Write The Name Of Industry To Search"
    						redirect(action:searchUtility)
    					}
    				else
    					{	
    					cessReturnInstList=CessReturn.findAll("from CessReturn as cr where lower(cr.industryReg.indName) like :applicationName and cr.completionStatus ='completed' ", [applicationName:input1])
    						countVar=cessReturnInstList.size()
    						for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    						{
    							def indappInst=cessReturnInstList.get(variable1)
    							def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    		checkVar=true
    	    	}else  if(params.searchOp=="Others"){
    	    		
    	    		def month_Value=params.FromMonth
    	    		def year_Value=params.FromYear
    	    		def month_Value1=params.ToMonth
    	    		def year_Value1=params.ToYear
    	    		def status_Value=params.status
    	    		def category_Value=params.category
    				def fromDate = "01"
    	        					
    	        					def fromMonth = params.FromMonth
    	        					
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
    	        								
    	        					def fromYear = params.FromYear
    	        					String appliedFromDate = fromYear+"/"+fromMonth+"/"+fromDate
    	        					session.fromMonth = fromMonth
    	        					session.fromYear = fromYear
    	        					def toMonth = params.ToMonth
    	        					
    	        					if (toMonth=="January"){
    	        						toMonth = "01"
    	        					}else if(toMonth=="February"){
    	        						toMonth = "02"
    	        					}else if(toMonth=="March"){
    	        						toMonth = "03"
    	        					}else if(toMonth=="April"){
    	        						toMonth = "04"
    	        					}else if(toMonth=="May"){
    	        						toMonth = "05"
    	        					}else if(toMonth=="June"){
    	        						toMonth = "06"
    	        					}else if(toMonth=="July"){
    	        						toMonth = "07"
    	        					}else if(toMonth=="August"){
    	        						toMonth = "08"
    	        					}else if(toMonth=="September"){
    	        						toMonth = "09"
    	        					}else if(toMonth=="October"){
    	        						toMonth = "10"
    	        					}else if(toMonth=="November"){
    	        						toMonth = "11"
    	        					}else if(toMonth=="December"){
    	        						toMonth = "12"
    	        					}
    	        				
    	        					def toYear = params.ToYear.toInteger()
    	        					session.toYear = toYear
    	        					session.toMonth = toMonth		
    	        					def toDate

    	        					if(toMonth=="01"||toMonth=="03"||toMonth=="05"||toMonth=="07"||toMonth=="08"||toMonth=="10"||toMonth=="12"){
    	        						toDate = "31"
    	        					}else if (toMonth=="04"||toMonth=="06"||toMonth=="09"||toMonth=="11"){
    	        						toDate = "30"
    	        					}else if (toMonth=="02"){
    	        						boolean isLeapYear = ((toYear % 4 == 0) && (toYear % 100 != 0) || (toYear % 400 == 0));

    	        				        if (isLeapYear)
    	        				        {
    	        				        	toDate = "29"
    	        				        } else
    	        				        	toDate = "28"
    	        					}
    	        						
    	        					String appliedToDate = toYear+"/"+toMonth+"/"+toDate
    	        			def startDate1=appliedFromDate
    	        			def endDate1=appliedToDate
    	        			
    	        			def x
    	        			def y
    	        			def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
    	        				x = sdfh.parse(startDate1); //Date
    	        				y = sdfh.parse(endDate1);
    	        			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    						java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    						
    	        				if(sqlDate>sqlDate2) {
    	        					flash.message="Cess Applied From Month & Year should be Greater than Cess Applied To Month & Year"
    	    					    redirect(action:searchUtility)
    	        				}
    	        	else{
    	    			if(status_Value=="xyz" && category_Value=="xyz"){
    	    			cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where (( cr.cessAppliedFromDate <= ? and cr.cessAppliedToDate >= ? )or( cr.cessAppliedToDate <= ? and cr.cessAppliedFromDate >= ?)) and cr.completionStatus='completed' order by cr.id",[sqlDate2,sqlDate,sqlDate2,sqlDate])
    	    				countVar=cessReturnInstList.size()
    	    				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    						{
    							def indappInst=cessReturnInstList.get(variable1)
    							def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			if(status_Value!="xyz" && category_Value=="xyz"){
    	    				cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where (( cr.cessAppliedFromDate <= ? and cr.cessAppliedToDate >= ? )or( cr.cessAppliedToDate <= ? and cr.cessAppliedFromDate >= ?)) and cr.applicationStatus=? and cr.completionStatus='completed' order by cr.id",[sqlDate2,sqlDate,sqlDate2,sqlDate,status_Value])
    	    				countVar=cessReturnInstList.size()
    	    				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    						{
    							def indappInst=cessReturnInstList.get(variable1)
    							def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			if(status_Value=="xyz" && category_Value!="xyz"){
    	    				def indCatInstance=IndCatMaster.get(category_Value)
    	        			cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where (( cr.cessAppliedFromDate <= ? and cr.cessAppliedToDate >= ? )or( cr.cessAppliedToDate <= ? and cr.cessAppliedFromDate >= ?)) and cr.industryReg.category=? and cr.completionStatus='completed' order by cr.id",[sqlDate2,sqlDate,sqlDate2,sqlDate,indCatInstance])
    	        			countVar=cessReturnInstList.size()
    	        				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)	
    	    					{
    	    						def indappInst=cessReturnInstList.get(variable1)
    	    						def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			if(status_Value!="xyz" && category_Value!="xyz"){
    	        		def indCatInstance=IndCatMaster.get(category_Value)
    	        			cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where (( cr.cessAppliedFromDate <= ? and cr.cessAppliedToDate >= ? )or( cr.cessAppliedToDate <= ? and cr.cessAppliedFromDate >= ?)) and cr.industryReg.category=? and cr.completionStatus='completed' and cr.applicationStatus=? order by cr.id",[sqlDate2,sqlDate,sqlDate2,sqlDate,indCatInstance,status_Value])
    	        			countVar=cessReturnInstList.size()
    	        				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    	    					{
    	    						def indappInst=cessReturnInstList.get(variable1)
    	    						
    	    						def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    		checkVar=true
    	    		}
    	    	}else {
    	    		flash.message = "Please Select the radio button for the type of search."
    	                redirect(action:searchUtility)
    	    	}
    	    	if(checkVar){
    	    		if(countVar==0){
    	    			flash.message = "No Result found with this search criteria."
    	                    redirect(action:searchUtility)
    	    		}else{
    	    	render(view:'searchUtility',model:[appIdList:appIdList,cessReturnInstList:cessReturnInstList,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole])
    	    	}
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
    
     def searchPage={
    	
    }
    
    def summaryCess={
    	 try {
    	    	def applicationReceivedCount=CessReturn.findAll("From CessReturn as cr,CessPendingDetails cpd WHERE cr.id=cpd.cessReturn and cr.completionStatus='completed' order by cr.id")
    	    	def applicationCompletedCount=CessReturn.findAll("From CessReturn as cr,CessPendingDetails cpd WHERE cr.id=cpd.cessReturn and cr.completionStatus='completed' and cr.applicationStatus='Completed' order by cr.id")
    	    	def applicationPendingCount=CessReturn.findAll("From CessReturn as cr,CessPendingDetails cpd WHERE cr.id=cpd.cessReturn and cr.completionStatus='completed' and cr.applicationStatus='In Progress' order by cr.id")
    	    	def applicationUnattendedCount=CessReturn.findAll("From CessReturn as cr where cr.applicationStatus='unattended' and cr.completionStatus='completed' order by cr.id")
    	    	def appIdList=CessReturn.findAll(" from CessReturn cr where cr.completionStatus='completed' order by cr.id desc")
    	    	def receivedCount=applicationReceivedCount.size()
    	    	def completedCount=applicationCompletedCount.size()
    	    	def pendingCount=applicationPendingCount.size()
    	   		def unattendedCount=applicationUnattendedCount.size()
    	   		def fullListToPrint= new ArrayList()
    	   		def allFour= new ArrayList()
    	    	def appList= new ArrayList()
    	    	def statusList= new ArrayList()
    	    	def pendingWith= new ArrayList()
    			def pendingWithRole= new ArrayList()
    	   		def cessReturnInstanceList
    	   		
    	   		if(params.checkVar){
    	   			if(params.checkVar=="received"){
    	   				
    	   				for(int a=0;a<applicationReceivedCount.size();a++)
    					{
    						allFour=applicationReceivedCount.get(a)
    						if(allFour)
    						{
    							appList.add(((ArrayList)allFour).get(0))
    							def cessReturnIns=allFour[0]
    						def checkInst=CessPendingDetails.findByCessReturn(cessReturnIns)
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
    	   				cessReturnInstanceList=appList
    	   				
    	   			}else if(params.checkVar=="completed"){
    	   				for(int a=0;a<applicationCompletedCount.size();a++)
    					{
    						allFour=applicationCompletedCount.get(a)
    						if(allFour)
    						{
    							appList.add(((ArrayList)allFour).get(0))
    						def cessReturnIns=allFour[0]
    						def checkInst=CessPendingDetails.findByCessReturn(cessReturnIns)
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
    	   				cessReturnInstanceList=appList
    	   			}else if(params.checkVar=="pending"){
    	   				for(int a=0;a<applicationPendingCount.size();a++)
    					{
    						allFour=applicationPendingCount.get(a)
    						if(allFour)
    						{
    							appList.add(((ArrayList)allFour).get(0))
    							def cessReturnIns=allFour[0]
    						def checkInst=CessPendingDetails.findByCessReturn(cessReturnIns)
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
    	   				cessReturnInstanceList=appList
    	   			}else{
    	   				cessReturnInstanceList=CessReturn.findAll("From CessReturn as cr where cr.applicationStatus='unattended' and cr.completionStatus='completed' order by cr.id")
    	   				for(int variable1=0;variable1<cessReturnInstanceList.size();variable1++)
    						{
    							def indappInst=cessReturnInstanceList.get(variable1)
    							def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	   		}else{
    	   			
    	   		}
    	   		fullListToPrint=cessReturnInstanceList
    	   		render(view:'searchPage',model:[appIdList:appIdList,fullListToPrint:fullListToPrint,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole,cessReturnInstanceList:cessReturnInstanceList,receivedCount:receivedCount,completedCount:completedCount,pendingCount:pendingCount,unattendedCount:unattendedCount])
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
   
    def searchSummaryApplication={
    	 try {
    	    	def checkVar=false
    	    	def countVar
    	    	def cessReturnInstList=new CessReturn()
    	    	def statusList= new ArrayList()
    	    	def pendingWith= new ArrayList()
    			def pendingWithRole= new ArrayList()
    	    	def fullListToPrint= new ArrayList()
    	    	
    	    		def status_Value=params.status
    	    		def category_Value=params.category
    	    		def startDate1=params.start_date_value
    				def endDate1=params.end_date_value
    				def x
    				def y
    				def totalRes
    				
    				try
    				{
    					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    					x = sdfh.parse(startDate1); //Date
    					y = sdfh.parse(endDate1);
    					
    				}
    				catch(Exception e)
    				{
    					flash.message="Enter Both The Dates in correct Format"
    					redirect(action:summaryCess)
    				}
    			
    				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    				sqlDate2.setDate((sqlDate2.getDate()+1))

    	    		if(sqlDate>sqlDate2)
    				{
    					flash.message="End Date should be Greater than Starting Date"
    					redirect(action:summaryCess)
    				}else{
    	    				if(status_Value=="xyz" && category_Value=="xyz"){
    	    				cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where cr.dateCreated >= ? and cr.dateCreated <= ? and cr.completionStatus='completed' order by cr.id",[sqlDate,sqlDate2])
    	    				countVar=cessReturnInstList.size()
    	    				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    						{
    							def indappInst=cessReturnInstList.get(variable1)
    							def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			if(status_Value!="xyz" && category_Value=="xyz"){
    	    				cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where cr.dateCreated >= ? and cr.dateCreated <= ? and cr.applicationStatus=? and cr.completionStatus='completed' order by cr.id",[sqlDate,sqlDate2,status_Value])
    	    				
    	    				countVar=cessReturnInstList.size()
    	    				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    						{
    							def indappInst=cessReturnInstList.get(variable1)
    							
    							def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			if(status_Value=="xyz" && category_Value!="xyz"){
    	        			def indCatInstance=IndCatMaster.get(category_Value)
    	        			cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where cr.dateCreated >= ? and cr.dateCreated <= ? and cr.industryReg.category=? and cr.completionStatus='completed' order by cr.id",[sqlDate,sqlDate2,indCatInstance])
    	        			countVar=cessReturnInstList.size()
    	        				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    	    					{
    	    						def indappInst=cessReturnInstList.get(variable1)
    	    						def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			if(status_Value!="xyz" && category_Value!="xyz"){
    	        		def indCatInstance=IndCatMaster.get(category_Value)
    	        			cessReturnInstList=CessReturn.findAll(" from CessReturn as cr where cr.dateCreated >= ? and cr.dateCreated <= ? and cr.industryReg.category=? and cr.completionStatus='completed' and cr.applicationStatus=? order by cr.id",[sqlDate,sqlDate2,indCatInstance,status_Value])
    	        			countVar=cessReturnInstList.size()
    	        				for(int variable1=0;variable1<cessReturnInstList.size();variable1++)
    	    					{
    	    						def indappInst=cessReturnInstList.get(variable1)
    	    						def checkInst=CessPendingDetails.findByCessReturn(indappInst)
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
    	    			checkVar=true
    	    		}
    	    	if(checkVar){
    	    		if(countVar==0){
    	    			flash.message = "No Result found with this search criteria."
    	                    redirect(action:summaryCess)
    	    		}else{
    	    			fullListToPrint=cessReturnInstList
    	    	render(view:'searchPage',model:[fullListToPrint:fullListToPrint,cessReturnInstList:cessReturnInstList,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole])
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
    
    def printAllCriteriasList={
    	 try {
    	    	def finalList=new ArrayList()
    	    	def listAll=params.listVal
    	    	def statusList= new ArrayList()
    	    	def pendingWith= new ArrayList()
    			def pendingWithRole= new ArrayList()
    	    	def listSize
    	    	if(listAll.getClass().getName()=="java.lang.String"){
    	    		listSize=1
    	    		def cessReturnInstance=CessReturn.get(listAll)
    	    		def checkInst=CessPendingDetails.findByCessReturn(cessReturnInstance)
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
    	    		if(cessReturnInstance){
    					finalList.add(cessReturnInstance)
    				}
    	    	}else{
    	    		listSize=listAll.size()
    	    		for(int i=0;i<listSize;i++){
    	    			def instances=listAll[i]
    	    			def cessReturnInstance=CessReturn.get(instances)
    	    			def checkInst=CessPendingDetails.findByCessReturn(cessReturnInstance)
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
    	    			if(cessReturnInstance){
    	    				finalList.add(cessReturnInstance)
    	    			}
    	    		}
    	    	}
    	    	render(view:'printAllCriteriasList',model:[pendingWithRole:pendingWithRole,pendingWith:pendingWith,statusList:statusList,listVal:params.listVal,finalList:finalList])
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

    def routeUnattended={
    	 try {
    	    	def applicationUnattendedCess=CessReturn.findAll("From CessReturn as cess WHERE  cess.applicationStatus='unattended' and  cess.completionStatus='completed' ")
    	    	def allFour= new ArrayList()
    	    	def appList= new ArrayList()
    	    	if(applicationUnattendedCess){
    				for(int variable1=0;variable1<applicationUnattendedCess.size();variable1++)
    					{
    						allFour=applicationUnattendedCess.get(variable1)
    						if(allFour)
    							{
    								appList.add((allFour))
    							}
    					}
    				}
    				return[appList:appList]
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
    	    	def groupPresentCess=new ArrayList()
    			def offIns=OfficeMaster.findByPriority(1)
    			 groupPresentCess=GroupMaster.findAll("from GroupMaster gm where gm.groupDesc='CESS' and gm.office=? ",[offIns])
    			def checkMessage=false
    			def checkMessageList=false
    			def indregInstance
    			def routed
    			def cessGroup
    			def groupName
    	    	if(groupPresentCess){
    				cessGroup=groupPresentCess[0]
    			}
    	    	def applicationObject
    	    	def checkingClass=params.routeThese
    	    	if(checkingClass.getClass().getName()=="java.lang.String"){
    	    		
    	    		def appId=checkingClass.toLong()
    	    		if(CessReturn.get(appId)){
    	    			applicationObject=CessReturn.get(appId)
    	    			indregInstance=applicationObject.industryReg
    	    			if(!cessGroup){
    	    				flash.message=" Cess Group not created. "
    	    			}else{
    	    				def group=cessGroup
    	    				def roleVsActList = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("001"))
    	    				groupName=cessGroup.groupName
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new CessPendingDetails()
    	    						appPendDetails.cessReturn = applicationObject
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						appPendDetails.cessAppliedFromDate =applicationObject.cessAppliedFromDate
    	    						appPendDetails.cessAppliedToDate =applicationObject.cessAppliedToDate
    	    						checkMessage=true
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="In Progress"
    	    								applicationObject.save()
    	    							flash.message="Application is routed successfully."
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		   }
    	    			    		}
    	    					}
    	    				}
    	    				if(!checkMessage){
    	    					flash.message=" Cess Group workflow not set.  "
    						}
    	    			}
    	    		}
    	    }else{
    	    	for(int vari=0;vari<checkingClass.size();vari++){
    	    		def appId=checkingClass[vari].toLong()
    	    		if(CessReturn.get(appId)){
    	    			applicationObject=CessReturn.get(appId)
    	    			indregInstance=applicationObject.industryReg
    	    			if(!cessGroup){
    	    				flash.message=" Cess Group not created .  "
    	    			}else{
    	    				def group=cessGroup
    	    				def roleVsActList = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("001"))
    	    				groupName=cessGroup.groupName
    	    				for(int i=0;i<roleVsActList.size();i++){
    	    					if(((roleVsActList.get(i)).role).group == group){
    	    						def appPendDetails = new CessPendingDetails()
    	    						appPendDetails.applicationId = appId+""
    	    						appPendDetails.applicationStatus ="pending"
    	    						appPendDetails.indRegInstance =indregInstance
    	    						appPendDetails.cessAppliedFromDate =applicationObject.cessAppliedFromDate
    	    						appPendDetails.cessAppliedToDate =applicationObjectcessAppliedToDate
    	    						checkMessageList="true"
    	    						appPendDetails.role = (roleVsActList.get(i)).role
    	    						appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
    	    						
    	    						if(appPendDetails.save(flush:true)){
    	    							routed = true
    	    							applicationObject.applicationStatus="In Progress"
    	    								applicationObject.save()
    	    							flash.message="Application is routed successfully."
    	    						}else{
    	    							appPendDetails.errors.each {
    	    			    		   }
    	    			    		}
    	    					}
    	    				}
    	    				if(!checkMessageList){
    							flash.message=" Cess Group workflow not set.  "
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
}
