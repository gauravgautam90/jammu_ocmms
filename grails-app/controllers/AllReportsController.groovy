import java.io.*;
import java.text.*;

import DateCustom;
import java.util.*;

import groovy.sql.*
import com.CheckSumRequestBean;
import com.CheckSumResponseBean;

class AllReportsController {

	def dataSource
	
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
    static allowedMethods = [delete:'POST', save:'POST', update:'POST',getConsentCertificate:'POST']

    def consentRenewalInfo={
       
    }

     def consentCertificateDetail={
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{
    	            def aa1 = session.userMaster
    	            def checkAdmin = aa1.accessLevel
    	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
    	                render(view:'consentCertificateDetail')
    	            }
    	            else{
    	            	redirect(uri:"/index.gsp")
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
   
    def conReport = {
    	 try { 
    			def appIdList=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck where dateCheck.completionStatus != 'pending'"); 
    			params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    			   def checkDate=null
    			def xyz5
    			def qwe
    			def statusList= new ArrayList()
    			def stdate = new ArrayList() 
    			def eddate = new ArrayList()
    			if(params.max)
    			{
    				xyz5=(params.max).toInteger()
    			}
    			else
    			{
    				xyz5=10
    			}
    			if(params.offset)
    			{
    				qwe=(params.offset).toInteger()
    			}
    			else
    			{
    				qwe=0
    			}
    			def paramList= new ArrayList()
    			paramList=params
    			def appList= new ArrayList()
    				def allFour= new ArrayList()
    				def abc= new IndApplicationDetails()
    				def cess=new CessReturn()
    			def abcR= new IndApplicationDetails()
    			def pendingWith= new ArrayList()
    			def pendingWithRole= new ArrayList()
    				int total;
    			def startDate1=params.start_date_value
    					def endDate1=params.end_date_value
    					def x
    					def y
    					def totalRes
    					def appType=params.status
    					def appFor=params.appFor
    					def consentFor=params.consentFor
    					if(appFor=="New")
    					{
    						appFor="new"
    					}
    					if(appFor=="Renew")
    					{
    						appFor="reNew"
    					}
    					if(appFor=="Modernization")
    					{
    						appFor="Modern"
    					}
    					if(appFor=="Expansion")
    					{
    						appFor="expan"
    					}
    					try
    					{
    						def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    						x = sdfh.parse(startDate1); //Date
    						y = sdfh.parse(endDate1);
    						checkDate="checked"
    					}
    					catch(Exception e)
    					{
    						flash.message="Enter Both The Dates in correct Format"
    						redirect(action:consentCertificateDetail)
    					}
    				if(checkDate)
    				{
    					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    					java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    					sqlDate2.setDate((sqlDate2.getDate()+1))
    					session.startDate1=startDate1
    							session.endDate1=endDate1
    					if(sqlDate>sqlDate2)
    					{
    						flash.message="End Date should be Greater than Starting Date"
    							redirect(action:consentCertificateDetail)
    					}else
    					{
 ////////////////////check with both dates and application type  ////////////
if(startDate1 && endDate1 && appType != "NotSelected" && appFor == "NotSelected" && consentFor == "ashu")
    					{
    						def xyz
    						def	nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails dateCheck WHERE dateCheck.applicationStatus = 'approved' ")
    						if(nis!=null)
    						{
    						xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, RecordCertificate record, ApplicationPendingDetails appDetail WHERE dateCheck.id = record.applicationId and dateCheck.id = appDetail.application and appDetail.applicationStatus = 'approved' and dateCheck.applicationType = ? and record.endDate >= ? and record.endDate <= ? ", [appType,sqlDate,sqlDate2])
    						
    						for(int g=0;g<xyz.size();g++)
    						{
    							allFour=xyz.get(g)
    							if(allFour)
    							{
    								appList.add(((ArrayList)allFour).get(0))
    							}
    						}
    						abc=appList
    						for(int abcIndex=0;abcIndex<abc.size();abcIndex++)
    						{
    							def indappInst=abc.get(abcIndex)
    							def checkInst=ApplicationPendingDetails.findByApplication(indappInst)
    							def checkInst1=RecordCertificate.findByApplicationId(indappInst)
    							if(checkInst)
    							{
    							statusList.add(checkInst.applicationStatus)
    							}
    							if(checkInst1)
    							{
    								stdate.add(checkInst1.startDate)
    								eddate.add(checkInst1.endDate)
    							}
    							}
    						total=nis.size()
    						for(int d=0;d<abc.size();d++)
    						{
    							def abcFina=(abc.get(d)).actualApplicationDate
    							if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    								(abc.get(d)).actualApplicationDate=abcFina
    									}
    								else
    								{
    									DateCustom dd2=new DateCustom()
    									def xyz2= dd2.toDate(abcFina)
    								(abc.get(d)).actualApplicationDate=xyz2
    								}
    						}
    				}
    					}
//////////////////// check with both dates and application type and application for ////////////
	if(startDate1 && endDate1 && appType != "NotSelected" && appFor != "NotSelected" && consentFor == "ashu" )
    					{
    						def xyz
    						def	nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails dateCheck WHERE dateCheck.applicationStatus = 'approved' ")
    						if(nis!=null)
    						{
    						xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, RecordCertificate record, ApplicationPendingDetails appDetail WHERE dateCheck.id = record.applicationId and dateCheck.id = appDetail.application and appDetail.applicationStatus = 'approved' and dateCheck.applicationType = ? and dateCheck.certificateFor = ? and record.endDate >= ? and record.endDate <= ? ", [appType,appFor,sqlDate,sqlDate2])
    						for(int g=0;g<xyz.size();g++)
    						{
    							allFour=xyz.get(g)
    							if(allFour)
    							{
    								appList.add(((ArrayList)allFour).get(0))
    							}
    						}
    						abc=appList
    						for(int abcIndex=0;abcIndex<abc.size();abcIndex++)
    						{
    							def indappInst=abc.get(abcIndex)
    							def checkInst=ApplicationPendingDetails.findByApplication(indappInst)
    							def checkInst1=RecordCertificate.findByApplicationId(indappInst)
    							if(checkInst)
    							{
    							statusList.add(checkInst.applicationStatus)
    							}
    							if(checkInst1)
    							{
    								stdate.add(checkInst1.startDate)
    								eddate.add(checkInst1.endDate)
    							}
    							}
    					total=nis.size()
    						for(int d=0;d<abc.size();d++)
    						{
    							def abcFina=(abc.get(d)).actualApplicationDate
    							if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    								(abc.get(d)).actualApplicationDate=abcFina
    									}
    								else
    								{
    									DateCustom dd2=new DateCustom()
    									def xyz2= dd2.toDate(abcFina)
    								(abc.get(d)).actualApplicationDate=xyz2
    								}
    							}
    						}
    						}
//////////////////// check with both dates ////////////
    				if(startDate1 && endDate1 && appType == "NotSelected" && appFor == "NotSelected" && consentFor == "ashu")
    				{
    					def xyz
    					def	nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails dateCheck WHERE dateCheck.applicationStatus = 'approved' ")
    					if(nis!=null)
    					{
    					xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, RecordCertificate record, ApplicationPendingDetails appDetail WHERE dateCheck.id = record.applicationId and dateCheck.id = appDetail.application and appDetail.applicationStatus = 'approved' and record.endDate >= ? and record.endDate <= ? ", [sqlDate,sqlDate2])
    					for(int g=0;g<xyz.size();g++)
    					{
    						allFour=xyz.get(g)
    						if(allFour)
    						{
    							appList.add(((ArrayList)allFour).get(0))
    						}
    					}
    					abc=appList
    					for(int abcIndex=0;abcIndex<abc.size();abcIndex++)
    					{
    						def indappInst=abc.get(abcIndex)
    						def checkInst=ApplicationPendingDetails.findByApplication(indappInst)
    						def checkInst1=RecordCertificate.findByApplicationId(indappInst)
    						if(checkInst)
    						{
    						statusList.add(checkInst.applicationStatus)
    						}
    						if(checkInst1)
    						{
    							stdate.add(checkInst1.startDate)
    							eddate.add(checkInst1.endDate)
    						}
    						}
    					total=nis.size()
    					for(int d=0;d<abc.size();d++)
    					{
    						def abcFina=(abc.get(d)).actualApplicationDate
    						if(abcFina.getClass().getName()=="java.sql.Date")
    								{
    							(abc.get(d)).actualApplicationDate=abcFina
    								}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    							(abc.get(d)).actualApplicationDate=xyz2
    							}
    						}
    					}
    					}
//////////////////// check with both dates and consent for////////////
    					if(startDate1 && endDate1 && appType == "NotSelected" && appFor == "NotSelected" && consentFor != "ashu")
    					{
    						def xyz
    						def	nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails dateCheck WHERE dateCheck.applicationStatus = 'approved' ")
    						if(nis!=null)
    						{
    						xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, RecordCertificate record, ApplicationPendingDetails appDetail WHERE dateCheck.id = record.applicationId and dateCheck.id = appDetail.application and appDetail.applicationStatus = 'approved' and dateCheck.applicationFor=? and record.endDate >= ? and record.endDate <= ? ", [consentFor,sqlDate,sqlDate2])
    						for(int g=0;g<xyz.size();g++)
    						{
    							allFour=xyz.get(g)
    							if(allFour)
    							{
    								appList.add(((ArrayList)allFour).get(0))
    							}
    						}
    						abc=appList
    						for(int abcIndex=0;abcIndex<abc.size();abcIndex++)
    						{
    							def indappInst=abc.get(abcIndex)
    							def checkInst=ApplicationPendingDetails.findByApplication(indappInst)
    							def checkInst1=RecordCertificate.findByApplicationId(indappInst)
    							if(checkInst)
    							{
    							statusList.add(checkInst.applicationStatus)
    							}
    							if(checkInst1)
    							{
    								stdate.add(checkInst1.startDate)
    								eddate.add(checkInst1.endDate)
    							}
    							}
    						total=nis.size()
    						for(int d=0;d<abc.size();d++)
    						{
    							def abcFina=(abc.get(d)).actualApplicationDate
    							if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    								(abc.get(d)).actualApplicationDate=abcFina
    									}
    								else
    								{
    									DateCustom dd2=new DateCustom()
    									def xyz2= dd2.toDate(abcFina)
    								(abc.get(d)).actualApplicationDate=xyz2
    								}
    							}
    						}
    						}
//////////////////// check with both dates and consent for and app type////////////
    				if(startDate1 && endDate1 && appType != "NotSelected" && appFor == "NotSelected" && consentFor != "ashu")
    				{
    					def xyz
    					def	nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails dateCheck WHERE dateCheck.applicationStatus = 'approved' ")
    					if(nis!=null)
    					{
    					xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, RecordCertificate record, ApplicationPendingDetails appDetail WHERE dateCheck.id = record.applicationId and dateCheck.id = appDetail.application and appDetail.applicationStatus = 'approved' and dateCheck.applicationFor=? and dateCheck.applicationType=? and record.endDate >= ? and record.endDate <= ? ", [consentFor,appType,sqlDate,sqlDate2])
    					for(int g=0;g<xyz.size();g++)
    					{
    						allFour=xyz.get(g)
    						if(allFour)
    						{
    							appList.add(((ArrayList)allFour).get(0))
    						}
    					}
    					abc=appList
    					for(int abcIndex=0;abcIndex<abc.size();abcIndex++)	
    					{
    						def indappInst=abc.get(abcIndex)
    						def checkInst=ApplicationPendingDetails.findByApplication(indappInst)
    						def checkInst1=RecordCertificate.findByApplicationId(indappInst)
    						if(checkInst)
    						{
    						statusList.add(checkInst.applicationStatus)
    						}
    						if(checkInst1)
    						{
    							stdate.add(checkInst1.startDate)
    							eddate.add(checkInst1.endDate)
    						}	
    					}
    					total=nis.size()
    					for(int d=0;d<abc.size();d++)
    					{
    						def abcFina=(abc.get(d)).actualApplicationDate
    						if(abcFina.getClass().getName()=="java.sql.Date")
    								{
    							(abc.get(d)).actualApplicationDate=abcFina
    								}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    							(abc.get(d)).actualApplicationDate=xyz2
    							}
    					}
    				}
    				}
////////////////////    	check with both dates and application type and application for and consent for////////////

    				if(startDate1 && endDate1 && appType != "NotSelected" && appFor != "NotSelected" && consentFor != "ashu")
    				{
    					def xyz
    					def	nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails dateCheck WHERE dateCheck.applicationStatus = 'approved' ")
    					if(nis!=null)
    					{
    					xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, RecordCertificate record, ApplicationPendingDetails appDetail WHERE dateCheck.id = record.applicationId and dateCheck.id = appDetail.application and appDetail.applicationStatus = 'approved' and dateCheck.applicationType = ? and dateCheck.certificateFor = ? and dateCheck.applicationFor = ? and record.endDate >= ? and record.endDate <= ? ", [appType,appFor,consentFor,sqlDate,sqlDate2])
    					for(int g=0;g<xyz.size();g++)
    					{
    						allFour=xyz.get(g)
    						if(allFour)
    						{
    							appList.add(((ArrayList)allFour).get(0))
    						}
    					}
    					abc=appList
    					for(int abcIndex=0;abcIndex<abc.size();abcIndex++)
    					{
    						def indappInst=abc.get(abcIndex)
    						def checkInst=ApplicationPendingDetails.findByApplication(indappInst)
    						def checkInst1=RecordCertificate.findByApplicationId(indappInst)
    						if(checkInst)
    						{
    						statusList.add(checkInst.applicationStatus)
    						}
    						if(checkInst1)
    						{
    							stdate.add(checkInst1.startDate)
    							eddate.add(checkInst1.endDate)
    						}	
    					}
    					total=nis.size()
    					for(int d=0;d<abc.size();d++)
    					{
    						def abcFina=(abc.get(d)).actualApplicationDate
    						if(abcFina.getClass().getName()=="java.sql.Date")
    								{
    							(abc.get(d)).actualApplicationDate=abcFina
    								}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    								(abc.get(d)).actualApplicationDate=xyz2
    							}
    						}
    					}
    					}
    					}
    					}
    				if(abc.getClass().getName()=="java.util.ArrayList")
    				{
    				if(abc.size()==0)
    				{
    					flash.message="No Result Found With This Search Combination"
    				}
    				}
    				session.test=abc
    				session.test1=statusList
    				session.test2=stdate
    				session.test3=eddate
    				render(view:'consentCertificateDetail',model:[appIdList:appIdList,abc:abc,total:total,paramList:paramList,statusList:statusList,stdate:stdate,eddate:eddate])
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
    
    def myAjax ={
    	 try { 
    			def list = new ArrayList()
    			def a 
    			if(params.cont== 'NotSelected' ) {
    				list.add('NotSelected')
    				render g.select( width:'10',name:'appFor', from:list)
    			}
    			else {
    				a = params.cont
    				if(a=="CTO")
    				{
    				list.add('NotSelected')
    				list.add('New')
    				list.add('Renew')
    				}
    				if(a=="CTE")
    				{
    				list.add('NotSelected')
    				list.add('New')
    				list.add('Modernization')
    				list.add('Expansion')
    				}
    				render g.select( width:'10', name:'appFor', from:list) 
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
    }    def searchIndustryPage={
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{
    	    		def aa1 = session.userMaster
    	            def checkAdmin = aa1.accessLevel
    	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
    	                render(view:'searchIndustry')
    	            }
    	            else{
    	            	redirect(uri:"/index.gsp")
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
    }    def search = 	{
    	 try { 
    	    	def industrySize=IndUser.findAll("From IndUser idUser order by idUser.industryRegMaster.indName")
    			params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	   		   def checkDate=null
    	   		def xyz5
    	   		def qwe
    	   		def statusList= new ArrayList()
    	   		if(params.max)
    	   		{
    	   			xyz5=(params.max).toInteger()
    	   		}
    	   		else
    	   		{
    	   			xyz5=10
    	   		}
    	   		if(params.offset)
    	   		{
    	   			qwe=(params.offset).toInteger()
    	   		}
    	   		else
    	   		{
    	   			qwe=0
    	   		}
    	    		def paramList= new ArrayList()
    	    		paramList=params
    	    		def appList= new ArrayList()
    					def allFour= new ArrayList()
    					def abc= new IndApplicationDetails()
    	    		def abcR= new IndApplicationDetails()
    	    		def pendingWith= new ArrayList()
    	    		def pendingWithRole= new ArrayList()
    					int total;
    	    		def industry
    	    		def industry1
    	    		def apply
    	    		def consentList
    				if(params.searchOp==null)
    				{
    					flash.message = "Please Select The Radio Button "
    					redirect(action:searchIndustryPage)
    				}
    				else
    				{
    						if(params.searchOp=="AllIndReg")
    						{
    							industry=IndUser.findAll("From IndUser idUser order by idUser.industryRegMaster.indName")
    						for(int d=0;d<industry.size();d++)
    						{
    							def abcFina=(industry.get(d)).dateCreated
    							if(abcFina.getClass().getName()=="java.sql.Date")
    							{
    								(industry.get(d)).dateCreated=abcFina
    							}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    								(industry.get(d)).dateCreated=xyz2
    							}
    							}
    							}
    						if(params.searchOp=="industryName")
    						{
    							def indName = params.autocomplete_parameter1
    							industry=IndUser.findAll("From IndUser idUser where idUser.industryRegMaster.indName=? order by idUser.industryRegMaster.indName",[indName])
    						for(int d=0;d<industry.size();d++)
    						{
    							def abcFina=(industry.get(d)).dateCreated
    							if(abcFina.getClass().getName()=="java.sql.Date")
    							{
    								(industry.get(d)).dateCreated=abcFina
    							}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    							(industry.get(d)).dateCreated=xyz2
    							}
    							}
    							}
    						if(params.searchOp=="districtName")
    						{
    							def districtid = (params.district).toLong()
    							industry=IndUser.findAll("From IndUser idUser where idUser.industryRegMaster.district.id=? order by idUser.industryRegMaster.indName",[districtid])
    						for(int d=0;d<industry.size();d++)
    						{
    							def abcFina=(industry.get(d)).dateCreated
    							if(abcFina.getClass().getName()=="java.sql.Date")
    							{
    								(industry.get(d)).dateCreated=abcFina
    							}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    								(industry.get(d)).dateCreated=xyz2
    							}
    							}
    							}
    						if(params.searchOp=="Others")
    						{
    							def category=(params.category.id)
    							def districtid1 = (params.district1.id)
    							def startDate1=params.start_date_value
    							def endDate1=params.end_date_value
    							session.startDate1=startDate1
    							session.endDate1=endDate1
    							def x
    							def y
    							try
    							{
    								def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    								x = sdfh.parse(startDate1); //Date
    								y = sdfh.parse(endDate1);
    								checkDate="checked"
    							}
    							catch(Exception e)
    							{
    								flash.message="Enter Both The Dates in correct Format"
    								redirect(action:searchIndustryPage)
    							}
    					if(checkDate)
    					{
    						java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    							java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    							sqlDate2.setDate((sqlDate2.getDate()+1))
    						if(sqlDate>sqlDate2)
    						{
    								flash.message="End Date should be Greater than Starting Date"
    									redirect(action:searchIndustryPage)
    						}
    						else
    						{
    						// search with both dates
    							if(startDate1 && endDate1 && category == "111" && districtid1 == "123")
    							{
    								industry=IndUser.findAll("From IndUser idUser where idUser.dateCreated >= ? and idUser.dateCreated <= ? order by idUser.industryRegMaster.indName",[sqlDate,sqlDate2]);
    								for(int d=0;d<industry.size();d++)
    								{
    									def abcFina=(industry.get(d)).dateCreated
    									if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    										(industry.get(d)).dateCreated=abcFina
    									}
    									else
    									{
    										DateCustom dd2=new DateCustom()
    										def xyz2= dd2.toDate(abcFina)
    										(industry.get(d)).dateCreated=xyz2
    									}
    									}
    								}
    						//search with all
    							if(startDate1 && endDate1 && category != "111" && districtid1 != "123" )
    							{
    								industry=IndUser.findAll("From IndUser idUser where idUser.industryRegMaster.district.id=? and idUser.industryRegMaster.category.name=? and idUser.dateCreated >= ? and idUser.dateCreated <= ? order by idUser.industryRegMaster.indName",[districtid1.toLong(),category,sqlDate,sqlDate2])
    								for(int d=0;d<industry.size();d++)
    								{
    									def abcFina=(industry.get(d)).dateCreated
    									if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    										(industry.get(d)).dateCreated=abcFina
    									}
    									else
    									{
    										DateCustom dd2=new DateCustom()
    										def xyz2= dd2.toDate(abcFina)
    										(industry.get(d)).dateCreated=xyz2
    									}}}
    							//search with dates and category
    							else if(startDate1 && endDate1 && category != "111" && districtid1 == "123" )
    							{
    								industry=IndUser.findAll("From IndUser idUser where idUser.industryRegMaster.category.name=? and idUser.dateCreated >= ? and idUser.dateCreated <= ? order by idUser.industryRegMaster.indName",[category,sqlDate,sqlDate2])
    								for(int d=0;d<industry.size();d++)
    								{
    									def abcFina=(industry.get(d)).dateCreated
    									if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    										(industry.get(d)).dateCreated=abcFina
    									}
    									else
    									{
    										DateCustom dd2=new DateCustom()
    										def xyz2= dd2.toDate(abcFina)
    										(industry.get(d)).dateCreated=xyz2
    									}
    								}
    							}
    							//search with dates and district
    							else if(startDate1 && endDate1 && category == "111" && districtid1 != "123" )
    							{
    								industry=IndUser.findAll("From IndUser idUser where idUser.industryRegMaster.district.id=? and idUser.dateCreated >= ? and idUser.dateCreated <= ? order by idUser.industryRegMaster.indName",[districtid1.toLong(),sqlDate,sqlDate2])
    								for(int d=0;d<industry.size();d++)
    								{
    									def abcFina=(industry.get(d)).dateCreated
    						
    									if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    										(industry.get(d)).dateCreated=abcFina
    									}
    									else
    									{
    										DateCustom dd2=new DateCustom()
    										def xyz2= dd2.toDate(abcFina)
    										(industry.get(d)).dateCreated=xyz2
    									}
    									}
    								}
    							}
    							}
    					}
    						}
    				if(industry.getClass().getName()=="java.util.ArrayList")
    				{
    				if(industry.size()==0)
    				{
    					flash.message="No Result Found With This Search Combination"
    				}
    				}
    				session.industry=industry
    				render(view:'searchIndustry',model:[industry:industry,total:total,paramList:paramList,industry1:industry1,apply:apply,industrySize:industrySize])
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
    def popPageReport={
    	 try { 
    	    	def asd=session.test
    	    	def industry=session.industry
    	    	def status=session.test1
    			def startDate=session.test2
    			def endDate=session.test3
    	    	render(view:'popPageReport',model:[asd:asd,industry:industry,status:status,startDate:startDate,endDate:endDate]) 
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
    def popIndustryReport={
    	 try { 
    	    	def industry=session.industry
    	    	render(view:'popIndustryReport',model:[industry:industry]) 
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
    def popConsentReport={
    	 try { 
    	    	def appId = (params.id).toLong()
    	    	def industryName = IndustryRegMaster.findWhere(id:appId)
    	    	def consentReport = IndApplicationDetails.findAll("From IndApplicationDetails appDetail WHERE appDetail.completionStatus='completed' and appDetail.indUser.id=?",[appId])
    	    	def appDate
    	    	def asd1 = new ArrayList()
    	    	for(int d=0;d<consentReport.size();d++)
    			{
    	    		appDate=(consentReport.get(d)).actualApplicationDate
    	    		if(appDate.getClass().getName()=="java.sql.Date")
    				{
    					(consentReport.get(d)).actualApplicationDate=appDate
    				}
    				else
    				{
    					DateCustom dd2=new DateCustom()
    					def xyz2= dd2.toDate(appDate)
    						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    								String s = formatter.format(xyz2);
    								asd1.add(s)
    				}
    			}
    	    	if(consentReport.size()==0)
    				{
    					flash.message="Not Applied for Consent"
    				}
    	    	render(view:'popConsentReport',model:[consentReport:consentReport,industryName:industryName,asd1:asd1]) 
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
    def popWasteReport={
    	 try { 
    	    	def appId = (params.id).toLong()
    	    	def industryName = IndustryRegMaster.findWhere(id:appId)
    	    	def hazardeousReport = HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp appDetail WHERE appDetail.completionStatus='Completed' and appDetail.industryRegMasterObj.id=?",[appId])
    	    	def biomedicalReport = BioMedicalWaste.findAll("From BioMedicalWaste appDetail WHERE appDetail.completionStatus='Completed' and appDetail.indRegMasterObj.id=?",[appId])
    	    	def municipalReport = MunicipalSolidWaste.findAll("From MunicipalSolidWaste appDetail WHERE appDetail.completionStatus='Completed' and appDetail.indRegMasterObj.id=?",[appId])
    	    	def abcFina
    	    	def appDate
    	    	def toDate
    	    	def asd = new ArrayList()
    	    	def asd1 = new ArrayList()
    	    	def asd2 = new ArrayList()
    	    				for(int d=0;d<hazardeousReport.size();d++)
    						{
    							abcFina=(hazardeousReport.get(d)).dateCreated
    							if(abcFina.getClass().getName()=="java.sql.Date")
    							{
    								(hazardeousReport.get(d)).dateCreated=abcFina	
    							}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								Date xyz2= dd2.toDate(abcFina)
    								Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    								String s = formatter.format(xyz2);
    								asd.add(s)
    							}
    						}
    	    	for(int d=0;d<biomedicalReport.size();d++)
    			{
    	    		appDate=(biomedicalReport.get(d)).dateCreated
    	    		if(appDate.getClass().getName()=="java.sql.Date")
    				{
    					(biomedicalReport.get(d)).dateCreated=appDate
    				}
    				else
    				{
    					DateCustom dd2=new DateCustom()
    					def xyz2= dd2.toDate(appDate)
    						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    								String s = formatter.format(xyz2);
    								asd1.add(s)
    				}
    			}
    	    	for(int d=0;d<municipalReport.size();d++)
    			{
    	    		toDate=(municipalReport.get(d)).dateCreated
    	    		if(toDate.getClass().getName()=="java.sql.Date")
    				{
    					(municipalReport.get(d)).dateCreated=toDate
    				}
    				else
    				{
    					DateCustom dd2=new DateCustom()
    					def xyz2= dd2.toDate(toDate)
    				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    					String s = formatter.format(xyz2);
    					asd2.add(s)
    				}
    			}
    	    	if(hazardeousReport.size()==0 && biomedicalReport.size()==0 && municipalReport.size()==0)
    				{
    					flash.message="Not Applied for Waste"
    				}
    	    	render(view:'popWasteReport',model:[industryName:industryName,hazardeousReport:hazardeousReport,biomedicalReport:biomedicalReport,municipalReport:municipalReport,asd:asd,asd1:asd1,asd2:asd2]) 
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
    def popCessReport={
    	 try { 
    	    	def appId = (params.id).toLong()
    	    	def industryName = IndustryRegMaster.findWhere(id:appId)
    	    	def cessReport = CessReturn.findAll("From CessReturn appDetail WHERE appDetail.completionStatus='completed' and appDetail.industryReg.id=?",[appId])
    	    	def abcFina
    	    	def appDate
    	    	def toDate
    	    	def asd = new ArrayList()
    	    	def asd1 = new ArrayList()
    	    	def asd2 = new ArrayList()
    	    				for(int d=0;d<cessReport.size();d++)
    						{
    							abcFina=(cessReport.get(d)).cessAppliedFromDate
    							if(abcFina.getClass().getName()=="java.sql.Date")
    							{
    								(cessReport.get(d)).cessAppliedFromDate=abcFina
    							}
    							else
    							{
    								DateCustom dd2=new DateCustom()
    								Date xyz2= dd2.toDate(abcFina)
    								Format formatter = new SimpleDateFormat("MMMM/yyyy");
    								String s = formatter.format(xyz2);
    								asd.add(s)
    							}
    						}
    	    	for(int d=0;d<cessReport.size();d++)
    			{
    	    		appDate=(cessReport.get(d)).dateCreated
    	    		if(appDate.getClass().getName()=="java.sql.Date")
    				{
    					(cessReport.get(d)).dateCreated=appDate
    				}
    				else
    				{
    					DateCustom dd2=new DateCustom()
    					def xyz2= dd2.toDate(appDate)
    						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    								String s = formatter.format(xyz2);
    								asd1.add(s)
    			}
    			}
    	    	for(int d=0;d<cessReport.size();d++)
    			{
    	    		toDate=(cessReport.get(d)).cessAppliedToDate
    	    		if(toDate.getClass().getName()=="java.sql.Date")
    				{
    					(cessReport.get(d)).cessAppliedToDate=toDate
    				}
    				else
    				{
    					DateCustom dd2=new DateCustom()
    					def xyz2= dd2.toDate(toDate)
    				Format formatter = new SimpleDateFormat("MMMM/yyyy");
    					String s = formatter.format(xyz2);
    					asd2.add(s)
    				}
    			}
    	    	if(cessReport.size()==0)
    				{
    					flash.message="Not Applied for Cess"
    				}
    	    	render(view:'popCessReport',model:[cessReport:cessReport,industryName:industryName,asd:asd,asd1:asd1,asd2:asd2]) 
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
    
    
//************************************************All reports*************************************************************
	def searchByIndustryName=
		{
    	 try { 
    	    	render(view:'searchByIndustryName')
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
    
    def searchByIndNameSubmit={
    	 try { 
    	    	def indName=params.autocomplete_parameter1
    	    	def allSummaryReportList=AllSummaryReport.findAll("from AllSummaryReport asr where asr.applicationName= ? order by applicationRecieptDate desc",indName);
    	    	def allSummaryReportListUnique=new ArrayList();
    			Set<String> uniqueIndustry=new LinkedHashSet<String>();
    			for(int i=0;i<allSummaryReportList.size();i++)
    			{
    				if(uniqueIndustry.add(allSummaryReportList[i].indRegMasterId))
    				{
    					allSummaryReportListUnique.add(allSummaryReportList[i]);
    				}
    			}
    			session.allSummaryReportList=null
    	    	session.allSummaryReportList=allSummaryReportListUnique
    	    	render(view:'searchByIndustryName',model:[allSummaryReportList:allSummaryReportListUnique])
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
    
    def popSearchByIndustryNameExc={
    	 try { 
    	    	def allSummaryReportList=session.allSummaryReportList
    	    	render(view:'popSearchByIndustryNameExc',model:[allSummaryReportList:allSummaryReportList])
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
    
    def noOfIndustriesDistrict11 = {
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{	
    	    	  def  districtMasterList = DistrictMaster.list( sort:"districtName", order:"asc")
    	    	  session.districtMasterList=districtMasterList
    	    	  render(view:'noOfIndustriesDistrict11',model:[districtMasterList:districtMasterList])
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
    
    def noOfIndustriesDistrictTehsil={
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{	
    	    		def districtMasterInstance=DistrictMaster.get((params.district).toLong())   		
    		    	def tehsilMasterList=TehsilMaster.findAll("from TehsilMaster tm where tm.district.id=? order by tehsilName asc",[districtMasterInstance.id]);
    	    		session.districtMasterInstance=districtMasterInstance
    	        	Date today=new Date();
    	        	String newstring = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(today);
    	        	render(view:'noOfIndustriesDistrictTehsil',model:[tehsilMasterList:tehsilMasterList,districtMasterInstance:districtMasterInstance,today:newstring])
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
    
    def getAppValueForDistrictTehsil = {
    	 try { 
    	    	def redSmall
    	        if(params.category == 'redS'){
    	            redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Small' and application.indUser.category.name = 'RED' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        } else if (params.category == 'redL') {           
    	           redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Large' and application.indUser.category.name = 'RED' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'redM') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Medium'  and application.indUser.category.name = 'RED' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'orangeS') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Small' and application.indUser.category.name = 'ORANGE' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'orangeM') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Medium' and application.indUser.category.name = 'ORANGE' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'orangeL') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Large' and application.indUser.category.name = 'ORANGE' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'greenS') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Small' and application.indUser.category.name = 'GREEN' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'greenM') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Medium' and application.indUser.category.name = 'GREEN' ",[(params.district).toLong(),(params.tehsil).toLong()])
    	        }  else if(params.category == 'greenL') 	{
    	        	redSmall = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser.district.id = ? and  application.indUser.tehsil.id = ? and application.indUser.industryScale = 'Large' and application.indUser.category.name = 'GREEN' ",[(params.district).toLong(),(params.tehsil).toLong()])
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
    
    def popNoOfIndustriesDistrict = {
    	 try { 
    	    	def districtMasterList=session.districtMasterList
    	    	render(view:'popNoOfIndustriesDistrict',model:[districtMasterList:districtMasterList]) 
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
    
    def popNoOfIndustriesDistrictExc = {
    	 try { 
    	    	def districtMasterList=session.districtMasterList
    	    	render(view:'popNoOfIndustriesDistrictExc',model:[districtMasterList:districtMasterList]) 
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
    
    def popDistrictTehsilExc={
    	 try { 
    	    	def districtMasterInstance=session.districtMasterInstance
    	    	def tehsilMasterList=TehsilMaster.findAll("from TehsilMaster tm where tm.district.id=? order by tehsilName asc",[districtMasterInstance.id]);
    	    	Date today=new Date();
    	    	String newstring = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(today);
    	    	render(view:'popDistrictTehsilExc',model:[tehsilMasterList:tehsilMasterList,districtMasterInstance:districtMasterInstance,today:newstring])	
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
    
    def consentCertificateDetail1={
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{
    	           def aa1 = session.userMaster
    	             def checkAdmin = aa1.accessLevel
    	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
    	                render(view:'consentCertificateDetail1')
    	            }
    	            else{
    	            	redirect(uri:"/index.gsp")
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
    
def conReport11 = {
    	 try { 
    	    	def startDate1=params.start_date_value
    			def endDate1=params.end_date_value
    			def applicationType
    			def certificateFor
    			def appFor=params.appFor
    			if(appFor!="NotSelected")
    			{
    				if(appFor=="CTE Fresh")
    				{
    					applicationType="CTE"
    					certificateFor="new"
    				}
    				else if(appFor=="CTE Modernization")
    				{
    					applicationType="CTE"
    					certificateFor="Modern"
    				}
    				else if(appFor=="CTE Expansion")
    				{
    					applicationType="CTE"
    					certificateFor="expan"
    				}
    				else if(appFor=="CTE Renew")
    				{
    					applicationType="CTE"
    					certificateFor="reNew"
    				}
    				else if(appFor=="CTO Fresh")
    				{
    					applicationType="CTO"
    					certificateFor="new"
    				}
    				else if(appFor=="CTO Modernization")
    				{
    					applicationType="CTO"
    					certificateFor="Modern"
    				}
    				else if(appFor=="CTO Expansion")
    				{
    					applicationType="CTO"
    					certificateFor="expan"
    				}
    				else if(appFor=="CTO Renew")
    				{
    					applicationType="CTO"
    					certificateFor="reNew"
    				}
    				else
    				{
    					applicationType="NotSelected"
    					certificateFor="NotSelected"
    				}
    			}
    			def x
    			def y
    			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    			x = sdfh.parse(startDate1); //Date
    			y = sdfh.parse(endDate1);
    			def  newGroupList = GroupMaster.list(sort:"groupName", order:"asc")
    			def groupList = new ArrayList()
    			for(int i = 0 ; i < newGroupList.size(); i++ ){
    				if(!(newGroupList[i].groupName=="HO CONSENT")){
    					groupList.add(newGroupList[i])
    			}
    			}
    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    			java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())	
    			sqlDate2.setDate((sqlDate2.getDate()+1))
    			session.groupList=groupList
    			session.applicationType=applicationType
    			session.certificateFor=certificateFor
    	      	session.sqlDate=sqlDate
    	      	session.sqlDate2=sqlDate2
    	      	session.appFor=appFor
    	      	if(sqlDate>sqlDate2)
    			{
    				flash.message="End Date should be Greater than Starting Date"
    				render(view:'consentCertificateDetail1')
    			}
    	      	else if(appFor=="NotSelected")
    			{
    				flash.message="Choose Certificate for"
    				render(view:'consentCertificateDetail1')
    			}
    	      	else
    			{
    				render(view:'consentCertificateDetail1',model:[sqlDate3:sqlDate3,appFor:appFor,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,applicationType:applicationType,certificateFor:certificateFor])
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
 
    def popListofIndReport={
    	 try {
    	    	def appFor = session.appFor
    			def groupList=session.groupList
    			def applicationType=session.applicationType
    			def certificateFor=session.certificateFor
    	    	def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3=sqlDate2-1
    			return[sqlDate3:sqlDate3,appFor:appFor,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,applicationType:applicationType,certificateFor:certificateFor]
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
    
    def popListofIndReportExc=
    {
    	 try {
    	    	def appFor = session.appFor
    			def groupList=session.groupList
    			def applicationType=session.applicationType
    			def certificateFor=session.certificateFor
    	    	def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3=sqlDate2-1
    			return[sqlDate3:sqlDate3,appFor:appFor,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,applicationType:applicationType,certificateFor:certificateFor]
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
    
    def monitoringDetail={
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{
    	            def aa1 = session.userMaster
    	            def checkAdmin = aa1.accessLevel
    	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
    	            {
    	            	render(view:'monitoringDetail')
    	            }
    	            else
    	            {
    	            	redirect(uri:"/index.gsp")
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
    
    def conReport1 = {
    	 try { 
    	    	def startDate1=params.start_date_value
    			def endDate1=params.end_date_value
    			def x
    			def y
    			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    			x = sdfh.parse(startDate1); //Date
    			y = sdfh.parse(endDate1);
    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    			java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
    			sqlDate2.setDate((sqlDate2.getDate()+1))
    		    def groups=params.groupName
    			if(sqlDate>sqlDate2)
    			{
    				flash.message="End Date should be Greater than Starting Date"
    				render(view:'monitoringDetail')
    			}
    			else if(!groups)
    	    	{
    	    		session.groupList=null
    	    		flash.message="Choose group"
    	    		render(view:'monitoringDetail')
    	    	}
    	    	else if(groups.getClass().getName()=="java.lang.String")
    	    	{
    	    		def groupList = new ArrayList()
    	    		def groupInstance=GroupMaster.findByGroupName(groups);
    	        	if(groupInstance)
    	        	{
    	        		groupList.add(groupInstance)
    	        	}
    	        	session.groupList=groupList
    	          	session.sqlDate=sqlDate
    	          	session.sqlDate2=sqlDate2
    	          	render(view:'monitoringDetail',model:[ sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])	
    	    	}
    	    	else
    	    	{
    	    		def groupList = new ArrayList()
    	    		for(int i = 0 ; i < groups.length; i++ ){
    	        		def groupInstance=GroupMaster.findByGroupName(groups[i]);
    	        		if(groupInstance)
    	        		{
    	        			groupList.add(groupInstance)
    	        		}
    	    		}
    	    		session.groupList=groupList
    	          	session.sqlDate=sqlDate
    	          	session.sqlDate2=sqlDate2
    	          	render(view:'monitoringDetail',model:[ sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])	
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
    
    def popNewPageReport={
    	 try { 
    	    	def groupList=session.groupList
    	    	def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3
    			if(sqlDate2)
    			sqlDate3=sqlDate2-1
    	    	render(view:'popNewPageReport',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
    
def popNewPageReportExc={
    	 try { 
    	    	def groupList=session.groupList
    	    	def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3
    			if(sqlDate2)
    			sqlDate3=sqlDate2-1
    	    	render(view:'popNewPageReportExc',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
    
    def monitoringDetailOffice={
    	 try { 
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{
    	            def aa1 = session.userMaster
    	            def checkAdmin = aa1.accessLevel
    	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
    	        		def groupList = GroupMaster.list( sort:"groupName", order:"asc")
    	        	def roleArray = new ArrayList()
    	        		def pArray = new ArrayList()
    	        		def pendingList = new ArrayList()
    	        		def roles = new ArrayList()
    	        		for(int i=0;i<groupList.size();i++){
    	        		def groupId = groupList[i].id
    	        			 roles = RoleMaster.findAll("from RoleMaster  as abc where abc.group.id=?",[groupId])
    	        			 roleArray.add(roles)
    	        		}
    	        		 for(int ii=0;ii<roleArray.size();ii++){
    	        			def var1 = roleArray[ii].id
    	        			 for(int iii=0;iii<var1.size();iii++){
    	     				def var = (var1.get(iii)).toString()
    	     			pendingList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.roleId=?",[var])
    	     			pArray.add(pendingList)
    	        			 }
    	     		}
    	        		  java.sql.Date sqlDate2 = new java.sql.Date(new Date().getTime())
    						Date sqlDate = new Date()
    						Calendar cal = Calendar.getInstance();
    						cal.setTime(sqlDate);
    						cal.add(Calendar.DAY_OF_YEAR,1);
    						cal.set(Calendar.HOUR_OF_DAY, 0);
    						cal.set(Calendar.MINUTE, 0);
    						cal.set(Calendar.SECOND, 0);
    						cal.set(Calendar.MILLISECOND, 0);
    						java.sql.Date sqlTommorow = new java.sql.Date(cal.getTimeInMillis());
    	            	render(view:'monitoringDetailOffice')
    	            }
    	            else{
    	            	redirect(uri:"/index.gsp")
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
    
def conReport1Office = {
    	 try { 
    			def startDate1=params.start_date_value
    			def endDate1=params.end_date_value
    			def x
    			def y
    			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    			x = sdfh.parse(startDate1); //Date
    			y = sdfh.parse(endDate1);
    			def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
    			def groupList = new ArrayList()
    			for(int i = 0 ; i < newGroupList.size(); i++ ){
    				if(!(newGroupList[i].groupName=="HO CONSENT")){
    					groupList.add(newGroupList[i])
    			}
    			}
    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    			java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
    			sqlDate2.setDate((sqlDate2.getDate()+1))
    			session.groupList=groupList
    	      	session.sqlDate=sqlDate
    	      	session.sqlDate2=sqlDate2
    			if(sqlDate>sqlDate2)
    			{
    				flash.message="End Date should be Greater than Starting Date"
    					render(view:'monitoringDetailOffice')
    			}else
    			{
    				render(view:'monitoringDetailOffice',model:[ sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])		
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
    
    def popNewPageReportOffice={
    	 try { 
    	    	def groupList=session.groupList
    	    	def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3
    			if(sqlDate2)
    			sqlDate3=sqlDate2-1
    	    	render(view:'popNewPageReportOffice',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
    
def popNewPageReportOfficeExc={
    	 try { 
    	    	def groupList=session.groupList
    	    	def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3
    			if(sqlDate2)
    			sqlDate3=sqlDate2-1
    	    	render(view:'popNewPageReportOfficeExc',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
    
    def totalApplicationsDetail={
    	if(!session.userMaster)
    	{
            redirect(uri:"/index.gsp")
    	}
    	else
    	{
            def aa1 = session.userMaster
            def checkAdmin = aa1.accessLevel
            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
                render(view:'totalApplicationsDetail')
            }
            else{
            	redirect(uri:"/index.gsp")
            }
        }
    }
   
    def appMonitoringReport={
    		def startDate1=params.start_date_value
    		def endDate1=params.end_date_value
    		def x
    		def y
    		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    		x = sdfh.parse(startDate1); //Date
    		y = sdfh.parse(endDate1);
    		def  newGroupList = GroupMaster.list()
    		def groupList = new ArrayList()
    		for(int i = 0 ; i < newGroupList.size(); i++ ){
    			if(!(newGroupList[i].groupName=="HO CONSENT")){
    				groupList.add(newGroupList[i])
    		}
    		}
    		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
    		sqlDate2.setDate((sqlDate2.getDate()+1))
    		session.groupList=groupList
    		session.sqlDate=sqlDate
    		session.sqlDate2=sqlDate2
        	if(sqlDate>sqlDate2)
    		{
    			flash.message="End Date should be Greater than Starting Date"
    				render(view:'totalApplicationsDetail')
    		}
        	else
    		{
    			render(view:'totalApplicationsDetail',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])
    		}	
        }
    
    def popListOfApplicationsReport={
    	 try { 
    	    	def groupList=session.groupList
    			def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3 = sqlDate2-1
    			render(view:'popListOfApplicationsReport',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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

    def popListOfApplicationsReportExc={
    	 try { 
    	    	def groupList=session.groupList
    			def sqlDate=session.sqlDate
    			def sqlDate2=session.sqlDate2
    			def sqlDate3 = sqlDate2-1
    			render(view:'popListOfApplicationsReportExc',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
    def popListOfBMWApplicationsReportExc={

   	 try { 
   	    	def groupList=session.groupList
   			def sqlDate=session.sqlDate
   			
   			def sqlDate2=session.sqlDate2
   			def allSummaryReport=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS aw where aw.applicationFor='BMW' and aw.authDate>=? and aw.authDate <=? order by aw.authDate desc",[sqlDate,sqlDate2])
   			println("--sqlDate--sqlDate--2"+sqlDate+"---------"+sqlDate2)
   			def sqlDate3 = sqlDate2-1
   			render(view:'popListOfBMWApplicationsReportExc',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2,allSummaryReport:allSummaryReport]) 
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
	
    def conReportPendingDaysTest = {
    	 try { 
    		 println("hello deepak ")
    	    	render(view:'monitoringReportPendingDaysTest')
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
    
    def conReportPendingDaysSubmit = {
    	 try { 
    	    	def groups=params.groupName
    	    	if(!groups)
    	    	{
    	    		session.groupList=null
    	    		flash.message="Choose group"
    	    		render(view:'monitoringReportPendingDaysTest')
    	    	}
    	    	else if(groups.getClass().getName()=="java.lang.String")
    	    	{
    	    		def groupList = new ArrayList()
    	    		def groupInstance=GroupMaster.findByGroupName(groups);
    	        	if(groupInstance)
    	        	{
    	        		groupList.add(groupInstance)
    	        	}
    	    		session.groupList=groupList
    	    		session.groups=groups
    	    		render(view:'monitoringReportPendingDaysTest',model:[groupList:groupList,groups:groups])	
    	    	}
    	    	else
    	    	{
    	    		def groupList = new ArrayList()
    	    		for(int i = 0 ; i < groups.length; i++ ){
    	        		def groupInstance=GroupMaster.findByGroupName(groups[i]);
    	        		if(groupInstance)
    	        		{
    	        			groupList.add(groupInstance)
    	        		}
    	    		}
    	    		session.groupList=groupList
    	    		render(view:'monitoringReportPendingDaysTest',model:[groupList:groupList])	
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
	
	 def conReportPendingDaysSubmit_BackUp_Deepak ={
   	 try { 
	    	def groups=params.groupName
	    	if(!groups)
	    	{
	    		session.groupList=null
	    		flash.message="Choose group"
	    		render(view:'monitoringReportPendingDaysTest')
	    	}
	    	else if(groups.getClass().getName()=="java.lang.String")
	    	{
	    		def groupList = new ArrayList()
	    		def groupInstance=GroupMaster.findByGroupName(groups);
	        	if(groupInstance)
	        	{
	        		groupList.add(groupInstance)
	        	}
	    		session.groupList=groupList
	    		render(view:'monitoringReportPendingDaysTest',model:[groupList:groupList])	
	    	}
	    	else
	    	{
	    		def groupList = new ArrayList()
	    		for(int i = 0 ; i < groups.length; i++ ){
	        		def groupInstance=GroupMaster.findByGroupName(groups[i]);
	        		if(groupInstance)
	        		{
	        			groupList.add(groupInstance)
	        		}
	    		}
	    		session.groupList=groupList
	    		render(view:'monitoringReportPendingDaysTest',model:[groupList:groupList])	
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
    
    def popNewPagePendingReport={
    	 try { 
    	    def groupList=session.groupList
    	    def groups=session.groups
    		render(view:'popNewPagePendingReport',model:[groupList:groupList,groups:groups]) 
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

  def popNewPagePendingReportExc={
    	 try { 
    	    	def groupList=session.groupList
    	    	def groups=session.groups
    		    render(view:'popNewPagePendingReportExc',model:[groupList:groupList,groups:groups]) 
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
    
    def sectorTypeWiseSummary={
    	 try { 
    	    	render(view:'sectorTypeWiseSummary')
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
    
    def sectorTypeSubmit={
    	 try { 
    	    	def districtOfficeMasterInstance=DistrictMaster.findByDistrictName(params.region)
    	    	Date today=new Date();
    	    	String newstring = new SimpleDateFormat("dd-MMM-yyyy").format(today);
    	    	session.districtOfficeMasterInstance=districtOfficeMasterInstance
    	    	render(view:'sectorTypeWiseSummary',model:[districtOfficeMasterInstance:districtOfficeMasterInstance,today:newstring])
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
    
	def industrySectorTypeWise={
    	 try { 
    	    	def applicationPendingDetailsList=ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.applicationStatus='approved' and apd.application.indUser.district.id=? and apd.application.indUser.category.name=? and apd.application.indUser.industryType.id = ? and apd.application.indUser.industryScale=?" ,[(params.districtOfficeId).toLong(),params.category,(params.industryTypeId).toLong(),params.classification]);
    			def applicationPendingDetailsListUnique=new ArrayList();
    			Set<String> uniqueIndustry=new LinkedHashSet<String>();
    			for(int i=0;i<applicationPendingDetailsList.size();i++)
    			{
    				if(uniqueIndustry.add(applicationPendingDetailsList[i].application.indUser.id))
    				{
    					applicationPendingDetailsListUnique.add(applicationPendingDetailsList[i]);
    				}
    			}
    			render(view:'popIndustrySectorTypeWise',model:[applicationPendingDetailsList:applicationPendingDetailsListUnique])
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

    def popSectorTypeWiseSummaryExc={
    	 try { 
    	    	Date today=new Date();
    	    	String newstring = new SimpleDateFormat("dd-MMM-yyyy").format(today);
    	    	def districtOfficeMasterInstance=session.districtOfficeMasterInstance
    	    	render(view:'popSectorTypeWiseSummaryExc',model:[districtOfficeMasterInstance:districtOfficeMasterInstance,today:newstring])
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
    
    def consentExpire = {
	}
    
    def conReportExpiry = {
    	 try { 
    	    	def group = params.group
    	    	def expiryDate
    	    	def allSummaryReportList=new ArrayList();
    	    	def expiryDaysList=new ArrayList<Integer>();
    	    	def fileRecordInstance
    	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	    	Set<String> uniqueIndustry=new LinkedHashSet<String>();
    			def indList = AllSummaryReport.findAll("from AllSummaryReport irm where irm.groupName = ? order by irm.applicationRecieptDate desc",[group])
    			for(int j =0 ;  j< indList.size() ; j ++)
    	     	{
    			 fileRecordInstance = RecordCertificate.find("from RecordCertificate where applicationId.id = ? ",[(indList[j].applicationId).toLong()])
    			 if(fileRecordInstance && uniqueIndustry.add(indList[j].indRegMasterId))
    			 {
    				  expiryDate = fileRecordInstance.endDate
    				  Date todayDate = sdf.parse(sdf.format(new Date()));
    			      def diff =  expiryDate.getTime() - todayDate.getTime() 
    			      def diffDays=diff / (1000*60*60*24)
    			     
    			      if("22"=="22")	  
    			      {
    			    	  allSummaryReportList.add(indList.get(j))
    			    	  expiryDaysList.add(diffDays);
    			      }
    			   }
    			}	
    			session.allSummaryReportList=allSummaryReportList
    			session.expiryDaysList=expiryDaysList
    			render(view: 'consentExpire', model :[allSummaryReportList:allSummaryReportList,expiryDaysList:expiryDaysList])
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
    
    def popConsentExpire={
    	 try { 
    	    	def allSummaryReportList=session.allSummaryReportList
    			def expiryDaysList=session.expiryDaysList
    			render(view:'popConsentExpire',model:[allSummaryReportList:allSummaryReportList,expiryDaysList:expiryDaysList]) 
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
    
    def popConsentExpireExc={
    	 try { 
    	    	def allSummaryReportList=session.allSummaryReportList
    			def expiryDaysList=session.expiryDaysList
    			render(view:'popConsentExpireExc',model:[allSummaryReportList:allSummaryReportList,expiryDaysList:expiryDaysList]) 
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
    
    def consentCTODetail1={
    	 try { 
    	    def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
    			def groupList = new ArrayList()
    			for(int i = 0 ; i < newGroupList.size(); i++ ){
    				if(!(newGroupList[i].groupName=="HO CONSENT")){
    					groupList.add(newGroupList[i])
    			} }
    				session.groupList=groupList
    				render(view:'consentCTODetail1',model:[groupList:groupList])
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

def popConsentCTODetail1 = {
    	 try { 
    	    	def groupList=session.groupList
    			render(view:'popConsentCTODetail1',model:[groupList:groupList]) 
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

def popConsentCTODetail1Exc = {
    	 try {  
    			def groupList=session.groupList
    			render(view:'popConsentCTODetail1Exc',model:[groupList:groupList]) 
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
    
    def consentCTEDetail1={
    	 try { 
    		   def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
    			def groupList = new ArrayList()
    			for(int i = 0 ; i < newGroupList.size(); i++ ){
    				if(!(newGroupList[i].groupName=="HO CONSENT")){
    					groupList.add(newGroupList[i])
    			}}
    				session.groupList=groupList
    				render(view:'consentCTEDetail1',model:[groupList:groupList])
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
    
    def popConsentCTEDetail1 = {
    	 try { 
    		   def groupList=session.groupList
    	    	render(view:'popConsentCTEDetail1',model:[groupList:groupList]) 
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
    
    def popConsentCTEDetail1Exc = {
    	 try { 
    		   def groupList=session.groupList
    	    	render(view:'popConsentCTEDetail1Exc',model:[groupList:groupList]) 
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
    
    def consentCertificateDetail2={
    	 try { 
    		    
    	    	if(!session.userMaster)
    	    	{
    	            redirect(uri:"/index.gsp")
    	    	}
    	    	else
    	    	{
    	            def aa1 = session.userMaster
    	            def checkAdmin = aa1.accessLevel
    	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
    	            {
    	                render(view:'consentCertificateDetail2')
    	            }
    	            else
    	            {
    	            	redirect(uri:"/index.gsp")
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
    
    def conReportList=
    {
    	 try { 
    		def allSummaryReportList=new ArrayList();
 	    	def certificatesList=new ArrayList();
 	    	def certificatesListAll=new ArrayList();
 		    boolean checkDate=false
 			def startDate1=params.start_date_value
 			def endDate1=params.end_date_value
 			def x
 			def y
 			def groupName=params.groupName
 			Set<String> uniqueIndustry=new LinkedHashSet<String>();
 			try
 			{
 				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
 				x = sdfh.parse(startDate1); //Date
 				y = sdfh.parse(endDate1);
 				checkDate=true
 			}
 			catch(Exception e)
 			{
 				flash.message="Enter Both The Dates in correct Format"
 				redirect(action:consentCertificateDetail2)
 			}
 			if(checkDate)
 			{
 				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
 				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
 				sqlDate2.setDate((sqlDate2.getDate()+1))
 				
 				if(sqlDate>sqlDate2)
 				{
 					flash.message="End Date should be Greater than Starting Date"
 					redirect(action:consentCertificateDetail2)
 				}
 				else
 				{
 					allSummaryReportList=AllSummaryReport.findAll("From AllSummaryReport abc where abc.groupName=? order by abc.applicationRecieptDate desc",[groupName]);
 					for(int kk=0;kk<allSummaryReportList.size();kk++)
 					{
 						if(uniqueIndustry.add(allSummaryReportList[kk].indRegMasterId))
 						{
 							certificatesList=RecordCertificate.findAll("From RecordCertificate record  WHERE  record.applicationId.id = ? and record.dateCreated >= ? and record.dateCreated <= ? order by record.id desc limit 1", [(allSummaryReportList.get(kk).applicationId).toLong(),sqlDate,sqlDate2])
 							if(certificatesList)
 							certificatesListAll.add(certificatesList[0]);	
 						}
 					}
 				}
 				session.startDate1=sqlDate
 				session.endDate1=sqlDate2
 				session.groupName=groupName
 				session.certificatesListAll=certificatesListAll
 			}
 			render(view:'consentCertificateDetail2',model:[certificatesListAll:certificatesListAll])
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
    
    def popPageReportInd={
    	 try { 
    	    	def certificatesListAll=session.certificatesListAll
    	    	render(view:'popPageReportInd',model:[certificatesListAll:certificatesListAll]) 
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
    
    def popPageReportIndExc={
    	 try { 
    	    	def certificatesListAll=session.certificatesListAll
    	    	render(view:'popPageReportIndExc',model:[certificatesListAll:certificatesListAll]) 
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
    
    def conReportPendingDaysWise = {
    	 try { 
    			render(view:'monitoringReportPendingDaysWise')
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
    
    
    def conReportPendingDaysWiseSubmit = {
    	 try { 
    			
    	    	def groups=params.groupName
    	    	if(!groups)
    	    	{
    	    		session.groupList=null
    	    		flash.message="Choose group"
    	    		render(view:'monitoringReportPendingDaysWise')
    	    	}
    	    	else 
    	    	{
    	    		def noOfDays=params.noOfDays
    	    		def groupList = new ArrayList()
    	    		def groupMasterInstance=GroupMaster.findByGroupName(groups);
    	        	session.groupMasterInstance=groupMasterInstance
    	        	session.noOfDays=noOfDays
    	    		render(view:'monitoringReportPendingDaysWise',model:[groupMasterInstance:groupMasterInstance,noOfDays:noOfDays])	
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
    
    def popPendingReportDaysWiseExc={
    	 try { 
    			def groupMasterInstance=session.groupMasterInstance
    	    	def noOfDays=session.noOfDays
    			render(view:'popPendingReportDaysWiseExc',model:[groupMasterInstance:groupMasterInstance,noOfDays:noOfDays]) 
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
    
//////////////////////////////////////////////////Report By Pragya//////////////////////////////
def completeStatus={
    	if(!session.userMaster)
    	{
            redirect(uri:"/index.gsp")
    	}
    	else
    	{
            def aa1 = session.userMaster
            def checkAdmin = aa1.accessLevel
            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
                render(view:'completeStatus')
            }
            else{
            	redirect(uri:"/index.gsp")
            }
        }
     }
    
def saveCompleteStatus={
    	def appSummary
		def startDate1=params.start_date_value
		def endDate1=params.end_date_value
		def x
		def y
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		x = sdfh.parse(startDate1); //Date
		y = sdfh.parse(endDate1);
		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
		sqlDate2.setDate((sqlDate2.getDate()+1))
		session.sqlDate=sqlDate
		session.sqlDate2=sqlDate2
		session.sqlDate3=sqlDate3
    	if(sqlDate>sqlDate2)
		{
			flash.message="End Date should be Greater than Starting Date"
				render(view:'completeStatus')
		}
    	else
		{
    		appSummary = AllSummaryReport.findAll("from AllSummaryReport where applicationRecieptDate>= ? and  applicationRecieptDate<= ? order by id desc ",[sqlDate,sqlDate2])        			
			session.appSummary=appSummary
    		render(view:'completeStatus',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary])
		}	
    }
    
def popCompleteStatus={
   	 try { 
   	    	def sqlDate=session.sqlDate
   	    	def sqlDate2=session.sqlDate2
   	    	def sqlDate3=session.sqlDate3
   	    	def appSummary=session.appSummary
   	    	render(view:'popCompleteStatus',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary]) 
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
   
def popCompleteStatusExc={
   	 try { 
   		def sqlDate=session.sqlDate
	    	def sqlDate2=session.sqlDate2
	    	def appSummary=session.appSummary
	    	def sqlDate3=session.sqlDate3
   	    	render(view:'popCompleteStatusExc',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary]) 
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
 ///////////////////////////////////////Report OfficerID//////////////////////////
 def officerIDStatus={
    	if(!session.userMaster)
    	{
            redirect(uri:"/index.gsp")
    	}
    	else
    	{
            def aa1 = session.userMaster
            def checkAdmin = aa1.accessLevel
            def officerId=""
            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
            	if(checkAdmin.equals('employee')){
            		officerId=aa1.id
            		
            	}
                render(view:'officerIDStatus',model:[officerId:officerId])
            }
            else{
            	redirect(uri:"/index.gsp")
            }
        }
     }
    
 def searchByOfficerIDStatus={
    	println("params...."+params)
    	def appSummary
		def startDate1=params.start_date_value
		def endDate1=params.end_date_value
		def officerID=params.officerID
		def x
		def y
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		x = sdfh.parse(startDate1); //Date
		y = sdfh.parse(endDate1);
		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
		sqlDate2.setDate((sqlDate2.getDate()+1))
		session.sqlDate=sqlDate
		session.sqlDate2=sqlDate2
		session.sqlDate3=sqlDate3
		session.officerID=officerID
    	if(sqlDate>sqlDate2)
		{
			flash.message="End Date should be Greater than Starting Date"
				render(view:'officerIDStatus')
		}
    	else
		{
    		appSummary = ApplicationProcessingDetails.executeQuery("select distinct application from ApplicationProcessingDetails dateCheck1 where  (dateCheck1.officer = ? OR dateCheck1.officerFwd = ? ) and dateCheck1.dateCreated >=? and dateCheck1.dateCreated <=? ",  [officerID.trim(),officerID.trim(),sqlDate,sqlDate2] );
    		println("appSummary..."+appSummary)
    		session.appSummary=appSummary
    		def aa1 = session.userMaster
            def checkAdmin = aa1.accessLevel
            def officerId=""
            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
            	if(checkAdmin.equals('employee')){
            		officerId=aa1.id
            		
            	}
            }
    		
    		render(view:'officerIDStatus',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary,officerId:officerId,officerID:officerID])
		}	
    }
    def popByOfficerIDStatus={
      	 try { 
      	    	def sqlDate=session.sqlDate
      	    	def sqlDate2=session.sqlDate2
      	    	def sqlDate3=session.sqlDate3
      	    	def appSummary=session.appSummary
      	    	def officerID=session.officerID
      	    	render(view:'popByOfficerIDStatus',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary,officerID:officerID]) 
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
      
   def popByOfficerIDStatusExc={
      	 try { 
      		def sqlDate=session.sqlDate
   	    	def sqlDate2=session.sqlDate2
   	    	def appSummary=session.appSummary
   	    	def sqlDate3=session.sqlDate3
   	    	def officerID=session.officerID
      	    	render(view:'popByOfficerIDStatusExc',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary,officerID:officerID]) 
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
////////////////////////////////////////////////Category wise(16Th report)///////////////////////////
    def consentCategoryWise={
       	if(!session.userMaster)
       	{
               redirect(uri:"/index.gsp")
       	}
       	else
       	{
               def aa1 = session.userMaster
               def checkAdmin = aa1.accessLevel
               if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
                   render(view:'consentCategoryWise')
               }
               else{
               	redirect(uri:"/index.gsp")
               }
           }
       }
       def categoryMonitoringReport={
   		def startDate1=params.start_date_value
   		def endDate1=params.end_date_value
   		def x
   		def y
   		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
   		x = sdfh.parse(startDate1); //Date
   		y = sdfh.parse(endDate1);
   		def  newGroupList = DistrictMaster.list()
   		def groupList = new ArrayList()
   		for(int i = 0 ; i < newGroupList.size(); i++ ){
   			groupList.add(newGroupList[i])
   		}
   		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
   		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
   		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
   		sqlDate2.setDate((sqlDate2.getDate()+1))
   		session.groupList=groupList
   		session.sqlDate=sqlDate
   		session.sqlDate2=sqlDate2
       	if(sqlDate>sqlDate2)
   		{
   			flash.message="End Date should be Greater than Starting Date"
   				render(view:'consentCategoryWise')
   		}
       	else
   		{
   			render(view:'consentCategoryWise',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])
   		}	
       }
    def popListOfApplicationsCategory={
      	 try { 
      	    	def groupList=session.groupList
      			def sqlDate=session.sqlDate
      			def sqlDate2=session.sqlDate2
      			def sqlDate3 = sqlDate2-1
      			render(view:'popListOfApplicationsCategory',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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

      def popListOfApplicationsCategoryExc={
      	 try { 
      	    	def groupList=session.groupList
      			def sqlDate=session.sqlDate
      			def sqlDate2=session.sqlDate2
      			def sqlDate3 = sqlDate2-1
      			render(view:'popListOfApplicationsCategoryExc',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
///////////////delete allsummary table data  		
    def deleteAllRecordFromAllSummary={
     	 def aa = session.userMaster
          def checkAdmin = aa.accessLevel
          def xyz
          if(checkAdmin.equals('admin'))
          {
        	  
        	  def db = new Sql(dataSource) 
        	  xyz=db.rows("DELETE FROM all_summary_report;")
        	      
//    	   groovySql.execute("DELETE FROM all_summary_report;")
    	  
          }
    }	
//////////////////    /count of allsummary and appPending
     def countAllRecordFromAllSummary={
     	 def aa = session.userMaster
          def checkAdmin = aa.accessLevel
          def abc
          def abc2
          if(checkAdmin.equals('admin'))
          {
    	  abc = AllSummaryReport.executeQuery("SELECT COUNT(*) FROM AllSummaryReport")
    	  abc2 = ApplicationPendingDetails.executeQuery("SELECT COUNT(*) FROM ApplicationPendingDetails")
          }
     		render(view:'test',model:[abc:abc,abc2:abc2])
    }
	
	
/////////------Kumar Ashish Dashboard------//////////
	  def dashboard = {
	    Calendar cal = new GregorianCalendar();
	    Date today = new Date()
	    cal.setTime(today)
	    //int year = cal.get(Calendar.YEAR);
	    int year = 2017;
	    String dateCurrentYear_04_01 =  String.valueOf(year) + "-04-01"
	    println("dateCurrentYear_04_01: " + dateCurrentYear_04_01)
	    cal.add(Calendar.DAY_OF_MONTH, -730);
	    Date today730 = cal.getTime()
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
	    redirect(action: "searchDashboard", params: [fromDate: dateCurrentYear_04_01, toDate: sdf.format(today)])
	    return
	 }
		
		   def searchDashboard = {
		
		 def db = new Sql(dataSource)
		   /*
		   * this action is called when from period and to period is selected in dashboard search
		   */
		   try {

			      println("Params in searchDashboard--"+params);
			   	  def region=params.region
			   	  def groupMasterInstance
		          def fromDateStr = params.fromDate
		          def toDateStr = params.toDate
		          def regionalOffice;
		          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		          if(!fromDateStr){
		           flash.message = "Please enter valid 'From date'"
		           render(view: "searchDashboard")
		              return
		          }else if(!toDateStr){
		              flash.message = "Please enter valid 'To date'"
		           render(view: "searchDashboard")
		              return
		          }
		          
		          
		          Date fromDate = sdf.parse(fromDateStr)
		          Date toDate = sdf.parse(toDateStr)

		          if(toDate.before(fromDate)){
		           flash.message = "'To Date' should be greater than or equal to 'From Date'"
		           render(view: "searchDashboard")
		              return
		          }
		         String query=""; 
		         String query1="";
		         String groupId="";
		         String query2="";
		         String query3="";
		         String query4="";
		         String query5="";
		         String query6="";
		         String query7="";
		         String query8="";
		         String query9="";
		         String query10="";
		         
		         if(region !="NotSelected" && region !="All" && region!=null)
		          {
		        	  groupMasterInstance=GroupMaster.find("from GroupMaster where groupName= ?",[region]);
		        	//query="appDel = 'false' and singleWindow='false' and groupId ='"+(groupMasterInstance.id).toString()+"'";
		        	  query=" groupId ='"+(groupMasterInstance.id).toString()+"'";
		        	  query1="applicationFor = 'HWM' and groupId ='"+(groupMasterInstance.id).toString()+"'"; 
		        	  query2="applicationFor = 'BMW' and groupId ='"+(groupMasterInstance.id).toString()+"'";
		        	  query3="applicationFor = 'PWM' and groupId ='"+(groupMasterInstance.id).toString()+"'";
		        	  query4="applicationFor = 'MSW' and groupId ='"+(groupMasterInstance.id).toString()+"'";
		        	  query5="applicationFor = 'EWaste' and role.group.id ='"+(groupMasterInstance.id).toString()+"'";
		        	  query6="application_for='HWM' and group_id ='"+(groupMasterInstance.id).toString()+"'";
		        	  query7="application_for='BMW' and group_id ='"+(groupMasterInstance.id).toString()+"'";
		        	  query8="application_for='PWM' and group_id ='"+(groupMasterInstance.id).toString()+"'";
		        	  query9="application_for='MSW' and group_id ='"+(groupMasterInstance.id).toString()+"'";
		        	  query10="application_for='EWaste' and role.group.id ='"+(groupMasterInstance.id).toString()+"'";
		        	  regionalOffice=groupMasterInstance;
		        	  groupId=(groupMasterInstance.id).toString();
		        	  println("Deepak--1111")   
		          }
		        else
		         {
		        	 //query="appDel = 'false' and singleWindow='false'";
		        	 query="";
		        	 query1="applicationFor = 'HWM'";
		        	 query2="applicationFor = 'BMW'";
		        	 query3="applicationFor = 'PWM'";
		        	 query4="applicationFor = 'MSW'";
		        	 query5="applicationFor = 'EWaste'";
		        	 query6 ="application_for='HWM'";
		        	 query7 ="application_for='BMW'";
		        	 query8 ="application_for='PWM'";
		        	 query9 ="application_for='MSW'";
		        	 query10="application_for='EWaste'";
		        	 
		        	 regionalOffice="All";
		        	 groupId="All"
		        		 println("Deepak--3333")
		         }
		        // println("query--111--"+query);
		        // println("query1--222--"+query1);
		          // println("groupId"+groupId);
		         
		          
		          
		          Date today = new Date()
		          WorkingDays workingDays=new WorkingDays();
		          
		          def day120=workingDays.calDueDate(today,120);
		          Date date120 = formatter.parse(day120)
		          Calendar cal = new GregorianCalendar();
		          cal.setTime(date120)
		          Date today120 = cal.getTime()
		          //println("today120: " + today120)
		          
		          
		          def day40=workingDays.calDueDate(today,40);
		          Date date40 = formatter.parse(day40)
		          Calendar ca2 = new GregorianCalendar();
		          ca2.setTime(date40)
		          Date today40 = ca2.getTime()
		          //println("today40: " + today40)
		          
		          
		          def day32=workingDays.calDueDate(today,32);
		          Date date32 = formatter.parse(day32)
		          Calendar ca3 = new GregorianCalendar();
		          ca3.setTime(date32)
		          Date today32 = ca3.getTime()
		          //println("today32: " + today32)
		          
		          
		          def day20=workingDays.calDueDate(today,20);
		          Date date20 = formatter.parse(day20)
		          Calendar ca4 = new GregorianCalendar();
		          ca4.setTime(date20)
		          Date today20 = ca4.getTime()
		          //println("today20: " + today20)
		          
		          
		          def day28=workingDays.calDueDate(today,28);
		          Date date28 = formatter.parse(day28)
		          Calendar ca5= new GregorianCalendar();
		          ca5.setTime(date28)
		          Date today28 = ca5.getTime()
		          //println("today28: " + today28)
		          Median median = new Median()
		          
		          def cteAvgGranted = 0.0
		          def cteAvgRejected = 0.0
		          
		          def ctoReceivedCount = 0.0
		          def ctoGrantedWithinTime = 0.0
		          def ctoGrantedBeyondTime = 0.0
		          def ctoRejectedWithinTime = 0.0
		          def ctoRejectedBeyondTime = 0.0
		          def ctoPendingWithinTime = 0.0
		          def ctoPendingBeyondTime = 0.0
		          
		          
		          def cteReceivedCount = 0.0
		          def cteGrantedWithinTime = 0.0
		          def cteGrantedBeyondTime = 0.0
		          def cteRejectedWithinTime = 0.0
		          def cteRejectedBeyondTime = 0.0
		          def ctePendingWithinTime = 0.0
		          def ctePendingBeyondTime = 0.0
		          
		          
		          //1.CTO
		          
		          //a.RED CATEGORY
		          def ctoRedReceivedCount = 0.0
		          def ctoRedGrantedWithinTime = 0.0
		          def ctoRedGrantedBeyondTime = 0.0
		          def ctoRedRejectedWithinTime = 0.0
		          def ctoRedRejectedBeyondTime = 0.0
		          def ctoRedPendingWithinTime = 0.0
		          def ctoRedPendingBeyondTime = 0.0
		          
		          
		          
	              //B.RED Large & Medium CATEGORY
		          def ctoRedLMReceivedCount = 0.0
		          def ctoRedLMGrantedWithinTime = 0.0
		          def ctoRedLMGrantedBeyondTime = 0.0
		          def ctoRedLMRejectedWithinTime = 0.0
		          def ctoRedLMRejectedBeyondTime = 0.0
		          def ctoRedLMPendingWithinTime = 0.0
		          def ctoRedLMPendingBeyondTime = 0.0
		          
		          //b.GREEN  CATEGORY
		          def ctoGreenReceivedCount = 0.0
		          def ctoGreenGrantedWithinTime = 0.0
		          def ctoGreenGrantedBeyondTime = 0.0
		          def ctoGreenRejectedWithinTime = 0.0
		          def ctoGreenRejectedBeyondTime = 0.0
		          def ctoGreenPendingWithinTime = 0.0
		          def ctoGreenPendingBeyondTime = 0.0
		          
		          //c.ORANGE CATEGORY
		          def ctoOrangeReceivedCount = 0.0
		          def ctoOrangeGrantedWithinTime = 0.0
		          def ctoOrangeGrantedBeyondTime = 0.0
		          def ctoOrangeRejectedWithinTime = 0.0
		          def ctoOrangeRejectedBeyondTime = 0.0
		          def ctoOrangePendingWithinTime = 0.0
		          def ctoOrangePendingBeyondTime = 0.0
		          
		          
		          
	           // 2.CTE
	           
	           
		          //a.RED CATEGORY
		          def cteRedReceivedCount = 0.0
		          def cteRedGrantedWithinTime = 0.0
		          def cteRedGrantedBeyondTime = 0.0
		          def cteRedRejectedWithinTime = 0.0
		          def cteRedRejectedBeyondTime = 0.0
		          def cteRedPendingWithinTime = 0.0
		          def cteRedPendingBeyondTime = 0.0
		          
		         
		          //b.GREEN  CATEGORY
		          def cteGreenReceivedCount = 0.0
		          def cteGreenGrantedWithinTime = 0.0
		          def cteGreenGrantedBeyondTime = 0.0
		          def cteGreenRejectedWithinTime = 0.0
		          def cteGreenRejectedBeyondTime = 0.0
		          def cteGreenPendingWithinTime = 0.0
		          def cteGreenPendingBeyondTime = 0.0
		          
		          //c.ORANGE CATEGORY
		          def cteOrangeReceivedCount = 0.0
		          def cteOrangeGrantedWithinTime = 0.0
		          def cteOrangeGrantedBeyondTime = 0.0
		          def cteOrangeRejectedWithinTime = 0.0
		          def cteOrangeRejectedBeyondTime = 0.0
		          def cteOrangePendingWithinTime = 0.0
		          def cteOrangePendingBeyondTime = 0.0
		          
		          // 2.CTE (R)
		           
		           
		          //a.RED CATEGORY
		          def cteRedReceivedCountr = 0.0
		          def cteRedGrantedWithinTimer = 0.0
		          def cteRedGrantedBeyondTimer = 0.0
		          def cteRedRejectedWithinTimer = 0.0
		          def cteRedRejectedBeyondTimer = 0.0
		          def cteRedPendingWithinTimer = 0.0
		          def cteRedPendingBeyondTimer = 0.0
		          
		          def cteGreenReceivedCountr = 0.0
		          def cteGreenGrantedWithinTimer = 0.0
		          def cteGreenGrantedBeyondTimer = 0.0
		          def cteGreenRejectedWithinTimer = 0.0
		          def cteGreenRejectedBeyondTimer = 0.0
		          def cteGreenPendingWithinTimer = 0.0
		          def cteGreenPendingBeyondTimer = 0.0
		          
		          def cteOrangeReceivedCountr = 0.0
		          def cteOrangeGrantedWithinTimer = 0.0
		          def cteOrangeGrantedBeyondTimer = 0.0
		          def cteOrangeRejectedWithinTimer = 0.0
		          def cteOrangeRejectedBeyondTimer = 0.0
		          def cteOrangePendingWithinTimer = 0.0
		          def cteOrangePendingBeyondTimer = 0.0
		          
		          def hwmReceivedCount = 0.0
		          def hwmGrantedWithinTime = 0.0
		          def hwmGrantedBeyondTime = 0.0
		          def hwmRejectedWithinTime = 0.0
		          def hwmRejectedBeyondTime = 0.0
		          def hwmPendingWithinTime = 0.0
		          def hwmPendingBeyondTime = 0.0

		          def bmwReceivedCount = 0.0
		          def bmwGrantedWithinTime = 0.0
		          def bmwGrantedBeyondTime = 0.0
		          def bmwRejectedWithinTime = 0.0
		          def bmwRejectedBeyondTime = 0.0
		          def bmwPendingWithinTime = 0.0
		          def bmwPendingBeyondTime = 0.0
		          
		          //3.CTO (R) 
		          def ctoRedReceivedCountr = 0.0
		          def ctoRedGrantedWithinTimer = 0.0
		          def ctoRedGrantedBeyondTimer = 0.0
		          def ctoRedRejectedWithinTimer = 0.0
		          def ctoRedRejectedBeyondTimer = 0.0
		          def ctoRedPendingWithinTimer = 0.0
		          def ctoRedPendingBeyondTimer = 0.0
		          
		          def ctoGreenReceivedCountr = 0.0
		          def ctoGreenGrantedWithinTimer = 0.0 
		          def ctoGreenGrantedBeyondTimer = 0.0
		          def ctoGreenRejectedWithinTimer = 0.0
		          def ctoGreenRejectedBeyondTimer = 0.0
		          def ctoGreenPendingWithinTimer = 0.0
		          def ctoGreenPendingBeyondTimer = 0.0
		          
		          def ctoOrangeReceivedCountr = 0.0
		          def ctoOrangeGrantedWithinTimer = 0.0
		          def ctoOrangeGrantedBeyondTimer = 0.0
		          def ctoOrangeRejectedWithinTimer= 0.0
		          def ctoOrangeRejectedBeyondTimer = 0.0
		          def ctoOrangePendingWithinTimer = 0.0
		          def ctoOrangePendingBeyondTimer = 0.0
		         
		          
		          def ctoRedLMGrantedWithinTimer = 0.0
		          def ctoRedLMGrantedBeyondTimer = 0.0
		          def ctoRedLMRejectedBeyondTimer = 0.0
		          def ctoRedLMPendingWithinTimer = 0.0	
		         
		          
		          //-----ADDED BY DEEPAK KUMAR------------
		          def pwmReceivedCount = 0.0
		          def pwmGrantedWithinTime = 0.0			          
		          def pwmGrantedBeyondTime = 0.0
		          def pwmRejectedWithinTime = 0.0
		          def pwmRejectedBeyondTime = 0.0
		          def pwmPendingWithinTime = 0.0
		          def pwmPendingBeyondTime = 0.0
		          
		          //-----ADDED BY DEEPAK KUMAR------------
		          
		          def ewasteReceivedCount = 0.0
		          def ewasteGrantedWithinTime = 0.0			          
		          def ewasteGrantedBeyondTime = 0.0
		          def ewasteRejectedWithinTime = 0.0
		          def ewasteRejectedBeyondTime = 0.0
		          def ewastePendingWithinTime = 0.0
		          def ewastePendingBeyondTime = 0.0 
		          
//-----ADDED BY DEEPAK KUMAR------------
		          
		          def mswReceivedCount = 0.0
		          def mswGrantedWithinTime = 0.0			          
		          def mswGrantedBeyondTime = 0.0
		          def mswRejectedWithinTime = 0.0
		          def mswRejectedBeyondTime = 0.0
		          def mswPendingWithinTime = 0.0
		          def mswPendingBeyondTime = 0.0
		          
		          def hwmAvgGranted = 0.0
		          def hwmAvgRejected = 0.0
		          def hwmMedian = 0.0
		          
		          
		          def cteAvgGrantedGreen = 0.0
		          def cteAvgRejectedGreen = 0.0
		          def cteMediangGreen = 0.0
		          
		          def cteAvgGrantedOrange = 0.0
		          def cteAvgRejectedOrange = 0.0
		          def cteMediangOrange = 0.0
		          
		         
		          def cteReMedianTempR = 0.0
		       
		          
		          def cteReAvgRejectedRed = 0.0
		          def cteReAvgGrantedRed = 0.0
		          def cteReMedianRed = 0.0
		        
		          def cteReAvgGrantedOrange = 0.0
		          def cteReAvgRejectedOrange = 0.0
		          def cteReMedianOrange = 0.0
		        
		          def cteReAvgGrantedGreen = 0.0
		          def cteReAvgRejectedGreen = 0.0
		          def cteReMedianGreen = 0.0 
		          
		          def ctoFAvgGrantedRed = 0.0
		          def ctoFAvgRejectedRed = 0.0
		          def ctoFMedianRed = 0.0 
		          
		          def ctoFAvgGrantedGreen = 0.0
		          def ctoFAvgRejectedGreen = 0.0
		          def ctoFMedianGreen = 0.0
		          
		          def ctoFAvgGrantedOrange = 0.0
		          def ctoFAvgRejectedOrange = 0.0
		          def ctoFMedianOrange = 0.0
		          
		          def ctoRAvgGrantedRed = 0.0
		          def ctoRAvgRejectedRed = 0.0
		          def ctoRMedianRed = 0.0
		          
		          def ctoRMedianGreen = 0.0
		          def ctoRAvgGrantedGreen = 0.0
		          def ctoRAvgRejectedGreen = 0.0
		          
		          def ctoRAvgGrantedOrange = 0.0
		          def ctoRAvgRejectedOrange = 0.0
		          def ctoRMedianOrange = 0.0
		          
		          def HWMAvgGranted = 0.0
		          def HWMAvgRejected = 0.0		          
		          def HWMMedian = 0.0
		          
		          def bmwAvgGranted = 0.0
		          def bmwAvgRejected = 0.0
		          def bmwMedian = 0.0
		          
		          def pwmAvgGranted = 0.0
		          def pwmAvgRejected = 0.0
		          def pwmMedian = 0.0
		          
		          def mswAvgGranted = 0.0
		          def mswAvgRejected = 0.0
		          def mswMedian = 0.0
		          
		          def ewAvgGranted = 0.0
		          def ewAvgRejected = 0.0
		          def ewMedian = 0.0
		          
		          /************************************************************************************************************************************************/
		          /******************************CTO START***********************************************************(*********************************************/
		          /************************************************************************************************************************************************/
		         
		      if((groupId.equals("All"))){   
		    	  
		    	  
		    	  println("hello DEEPAK  TESING")
		         ctoRedGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +				    	     
		    	       "applicationType = 'CTO' and certificateFor ='new' and indCategoryName='RED' and applicationStatus = 'approved' and pendingSince - applicationRecieptDate <= '120 days' " +
			           " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		         ctoGreenGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				   	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		         ctoOrangeGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				   	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		           ctoRedGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		    //     println("ctoRedGrantedBeyondTime--"+ctoRedGrantedBeyondTime);
		          
		           ctoRedLMGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'approved'  and indCategoryName='RED' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0)
		           
		         
		           ctoGreenGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		          ctoOrangeGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		         
		          ctoRedRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		          
		          ctoRedLMRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'rejected'  and indCategoryName='RED' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0)
		         
		          ctoGreenRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		          ctoOrangeRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and  pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		           
		        //   println("ctoOrangeRejectedWithinTime--"+ctoOrangeRejectedWithinTime);
		           
		           
		           /***4. Red/Orange/Green  CTO Rejected beyond the Time**/
		            ctoRedRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='new' and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		         //  println("ctoRedRejectedBeyondTime--"+ctoRedRejectedBeyondTime);
		          ctoRedLMRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
						           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				           
		           // println("ctoRedLMRejectedBeyondTime--"+ctoRedLMRejectedBeyondTime);
		           
		           ctoGreenRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='new' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		          // println("ctoGreenRejectedBeyondTime--"+ctoGreenRejectedBeyondTime);
		           
		           ctoOrangeRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='new'   and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		           
		        //   println("ctoOrangeRejectedBeyondTime--"+ctoOrangeRejectedBeyondTime);
		           
		           /***5. Red/Orange/Green  CTO Pending with in Time**/
		               ctoRedPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'new'   and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				           
				       //    println("ctoRedPendingWithinTime--"+ctoRedPendingWithinTime);
		          ctoRedLMPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' " +
				           " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?  and indCategoryName='RED' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate, today40, today]).get(0)
		           
		         ctoGreenPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'new'   and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);		          
		        //   println("ctoGreenPendingWithinTime--"+ctoGreenPendingWithinTime);
		           
		          ctoOrangePendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'new'   and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);		          
		        //   println("ctoOrangePendingWithinTime--"+ctoOrangePendingWithinTime);
		           
		           /***6. Red/Orange/Green  CTO Pending Beyond The Time**/
		          ctoRedPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'new'   and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);		          
		        
				    //       println("ctoRedPendingBeyondTime--"+ctoRedPendingBeyondTime);
		           ctoGreenPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'new'   and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);	          
		              
		        //   println("ctoGreenPendingBeyondTime--"+ctoGreenPendingBeyondTime);
		             ctoOrangePendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'new' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);	          
		           
		           //---------ADDED BY DEEPAK KUMAR--------------
		           
		           
		             
		           // Red/Orange/Green  CTO (R) Granted with in Time** Added By DEEPAK KUMAR 
		           
		             ctoRedGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	      "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	      
		       //   println("ctoRedGrantedWithinTimer--"+ctoRedGrantedWithinTimer);
		         
		           
		      //  println("ctoRedLMGrantedWithinTimer--"+ctoRedLMGrantedWithinTimer);
		        
		          ctoGreenGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				   	           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		          
		        //  println("ctoGreenGrantedWithinTimer--"+ctoGreenGrantedWithinTimer);
		           ctoOrangeGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				   	           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		          
		         // println("ctoOrangeGrantedWithinTimer--"+ctoOrangeGrantedWithinTimer);
		          
		          /***2. Red/Orange/Green  CTO (R)Granted beyond the Time**/
	              
		           ctoRedGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		         // println("ctoRedGrantedBeyondTimer--"+ctoRedGrantedBeyondTimer);
		          
		          ctoRedLMGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'approved'  and indCategoryName='RED' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0)
		           
		         
		         
		           ctoGreenGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		          // println("ctoGreenGrantedBeyondTimer--"+ctoGreenGrantedBeyondTimer);
		           
		           ctoOrangeGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		         
		        // println("ctoOrangeGrantedBeyondTimer--"+ctoOrangeGrantedBeyondTimer);
		           
		           /***3. Red/Orange/Green  CTO(R) Rejected with in Time**/
		           
		          ctoRedRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		       // println("ctoRedLMRejectedWithinTimer--"+ctoRedLMRejectedWithinTimer);
		           
		           
		         ctoGreenRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days'and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		          // println("ctoGreenRejectedWithinTimer--"+ctoGreenRejectedWithinTimer);
		           
		           ctoOrangeRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and  pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		           
		       //    println("ctoOrangeRejectedWithinTimer--"+ctoOrangeRejectedWithinTimer);
		           
		           
		           /***4. Red/Orange/Green  CTO Rejected beyond the Time**/
		           
		           ctoRedRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='reNew' and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		        //   println("ctoRedRejectedBeyondTimer--"+ctoRedRejectedBeyondTimer);
		           ctoRedLMRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
						           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				           
		           // println("ctoRedLMRejectedBeyondTimer--"+ctoRedLMRejectedBeyondTimer);
		           
		            ctoGreenRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='reNew' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		        //   println("ctoGreenRejectedBeyondTimer--"+ctoGreenRejectedBeyondTimer);
		           
		          ctoOrangeRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='reNew'   and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		           
		           
		       //   println("ctoOrangeRejectedBeyondTimer--"+ctoOrangeRejectedBeyondTimer);
		           
		           /***5. Red/Orange/Green  CTO(R) Pending with in Time**/
		           
		            ctoRedPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew'   and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				           
				        //  println("ctoRedPendingWithinTimer--"+ctoRedPendingWithinTimer);
		           
		           
		          ctoRedLMPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' " +
				           " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?  and indCategoryName='RED' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate, today40, today]).get(0)
		           
		           
		         //  println("ctoRedLMPendingWithinTimer--"+ctoRedLMPendingWithinTimer);
		            
		           ctoGreenPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew'   and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);		          
		         //  println("ctoGreenPendingWithinTimer--"+ctoGreenPendingWithinTimer);
		           
		          ctoOrangePendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew'   and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);	          
		         //  println("ctoOrangePendingWithinTimer--"+ctoOrangePendingWithinTimer);
		           
		           /***6. Red/Orange/Green  CTO Pending Beyond The Time**/
		           
		          ctoRedPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew'   and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);	          
		        
				    //     println("ctoRedPendingBeyondTimer--"+ctoRedPendingBeyondTimer);
		           
		           ctoGreenPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew'   and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);	          
		              
		        //   println("ctoGreenPendingBeyondTimer--"+ctoGreenPendingBeyondTimer);
		           
		           ctoOrangePendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);		          
		              
		          
		      //    println("ctoOrangePendingBeyondTimer--"+ctoOrangePendingBeyondTimer);
		           
		           
		                 // println("--------Deepak kumar------")
		                 
		           def ctoFAvgGrantRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"'";
		            def ctoFMedianTempRed = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new'and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoFAvgRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and application_status='rejected' and ind_category_name = 'RED' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

		            def abc1 = db.rows(ctoFAvgGrantRed)
		            def abc2 = db.rows(ctoFAvgRed)
		     //       println("abc1 "+abc1)
		        //    println("abc2 "+abc2)
		            
		            if(abc1.avg[0] !=null){
		                if ((abc1.avg[0]).toInteger() == 0.0) {
		                    ctoFAvgGrantedRed = 0.5
		                }else {
		                	ctoFAvgGrantedRed = (abc1.avg[0]).toInteger()
		                }
		            }
		            if(abc2.avg[0] !=null){
		                if ((abc2.avg[0]).toInteger() == 0.0) {
		                    ctoFAvgRejectedRed = 0.5
		                }else {
		                	ctoFAvgRejectedRed = (abc2.avg[0]).toInteger()
		                }
		            }
		            if(ctoFMedianTempRed) {
		                def abc = db.rows(ctoFMedianTempRed)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("Median = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                        ctoFMedianRed=test
		                    }
		                }
		            }
		            def ctoFAvgGrantGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoFMedianTempGreen = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoFAvgGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and application_status='rejected' and  ind_category_name = 'GREEN' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

		            def abcE1 = db.rows(ctoFAvgGrantGreen)
		            def abcE2 = db.rows(ctoFAvgGreen)
		          
		            if(abcE1.avg[0] !=null){
		                if ((abcE1.avg[0]).toInteger() == 0.0) {
		                    ctoFAvgGrantedGreen = 0.5
		                }else {
		                	ctoFAvgGrantedGreen = (abcE1.avg[0]).toInteger()
		                }
		            }
		            if(abcE2.avg[0] !=null){
		                if ((abcE2.avg[0]).toInteger() == 0.0) {
		                    ctoFAvgRejectedGreen = 0.5
		                }else {
		                	ctoFAvgRejectedGreen = (abcE2.avg[0]).toInteger()
		                }
		            }
		            if(ctoFMedianTempGreen) {
		                def abc = db.rows(ctoFMedianTempGreen)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("Median = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                        ctoFMedianGreen=test
		                    }
		                }
		            }
		            def ctoFAvgGrantOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoFMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoFAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and application_status='rejected' and  ind_category_name = 'ORANGE' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

		            def abcF1 = db.rows(ctoFAvgGrantOrange)
		            def abcF2 = db.rows(ctoFAvgOrange)
		            if(abcF1.avg[0] !=null){
		                if ((abcF1.avg[0]).toInteger() == 0.0) {
		                    ctoFAvgGrantedOrange = 0.5
		                }else {
		                	ctoFAvgGrantedOrange = (abcF1.avg[0]).toInteger()
		                }
		            }
		            if(abcF2.avg[0] !=null){
		                if ((abcF2.avg[0]).toInteger() == 0.0) {
		                    ctoFAvgRejectedOrange = 0.5
		                }else {
		                	ctoFAvgRejectedOrange = (abcF2.avg[0]).toInteger()
		                }
		            }
		            if(ctoFMedianTempOrange) {
		                def abc = db.rows(ctoFMedianTempOrange)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("Median = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                        ctoFMedianOrange=test
		                    }
		                }
		            }
		          //  println("ctoFAvgGrantedOrange"+ctoFAvgGrantedOrange)
		         //  println("ctoFMedianOrange"+ctoFMedianOrange)
		            
		            def ctoRAvgGrantRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoRMedianTempRed = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoRAvgRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and application_status='rejected' and  ind_category_name = 'RED' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

		            def abcR1 = db.rows(ctoRAvgGrantRed)
		            def abcR2 = db.rows(ctoRAvgRed)
		            
		            // println("abcR1"+abcR1)
		          //   println("abcR2"+abcR2)
		            if(abcR1.avg[0] !=null){
		                if ((abcR1.avg[0]).toInteger() == 0.0) {
		                    ctoRAvgGrantedRed = 0.5
		                }else {
		                	ctoRAvgGrantedRed = (abcR1.avg[0]).toInteger()
		                }
		            }
		            if(abcR2.avg[0] !=null){
		                if ((abcR2.avg[0]).toInteger() == 0.0) {
		                    ctoRAvgRejectedRed = 0.5
		                }else {
		                	ctoRAvgRejectedRed = (abcR2.avg[0]).toInteger()
		                }
		            }
		            if(ctoRMedianTempRed) {
		                def abc = db.rows(ctoRMedianTempRed)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("Median = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                    	ctoRMedianRed=test
		                    }
		                }
		            }
		         //  println("ctoRAvgGrantedRed"+ctoRAvgGrantedRed)
		        //   println("ctoRMedianRed"+ctoRMedianRed)
		        
		            def ctoRAvgGrantGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"'";
		            def ctoRMedianTempGreen = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoRAvgGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and application_status='rejected' and  ind_category_name = 'GREEN' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

		            def abcRg1 = db.rows(ctoRAvgGrantGreen)
		            def abcRg2 = db.rows(ctoRAvgGreen)
		            
		            // println("abcRg1"+abcRg1)
		          //   println("abcRg2"+abcRg2)
		            if(abcRg1.avg[0] !=null){
		                if ((abcRg1.avg[0]).toInteger() == 0.0) {
		                    ctoRAvgGrantedGreen = 0.5
		                }else {
		                	ctoRAvgGrantedGreen = (abcRg1.avg[0]).toInteger()
		                }
		            }
		            if(abcRg2.avg[0] !=null){
		                if ((abcRg2.avg[0]).toInteger() == 0.0) {
		                    ctoRAvgRejectedGreen = 0.5
		                }else {
		                	ctoRAvgRejectedGreen = (abcRg2.avg[0]).toInteger()
		                }
		            }
		            if(ctoRMedianTempGreen) {
		                def abc = db.rows(ctoRMedianTempGreen)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("Median = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                    	ctoRMedianGreen=test
		                    }
		                }
		            }
		       //     println("ctoRAvgGrantedGreen "+ctoRAvgGrantedGreen)
		       //    println("ctoRMedianGreen "+ctoRMedianGreen)
		       
		       
		            def ctoRAvgGrantOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoRMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
		            def ctoRAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and application_status='rejected' and  ind_category_name = 'ORANGE' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

		            def abcRo1 = db.rows(ctoRAvgGrantOrange)
		            def abcRo2 = db.rows(ctoRAvgOrange)
		            
		             println("abcRo1"+abcRo1)
		            println("abcRo2"+abcRo2)
		            if(abcRo1.avg[0] !=null){
		                if ((abcRo1.avg[0]).toInteger() == 0.0) {
		                    ctoRAvgGrantedOrange = 0.5
		                }else {
		                	ctoRAvgGrantedOrange = (abcRg1.avg[0]).toInteger()
		                }
		            }
		            if(abcRo2.avg[0] !=null){
		                if ((abcRo2.avg[0]).toInteger() == 0.0) {
		                	ctoRAvgRejectedOrange = 0.5
		                }else {
		                	ctoRAvgRejectedOrange = (abcRo2.avg[0]).toInteger()
		                }
		            }
		            if(ctoRMedianTempOrange) {
		                def abc = db.rows(ctoRMedianTempOrange)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("Median = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                    	ctoRMedianOrange=test
		                    }
		                }
		            }
	         
		   } else{
			   
			  // println("hello IN ELSE ");
			   ctoRedGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	           ctoRedLMGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		   	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved' and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	   	    ctoGreenGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			   	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);     
	          
	         ctoOrangeGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			   	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	        ctoRedGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	         ctoRedLMGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	         
	          
	           ctoGreenGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	       //    println("ctoGreenGrantedBeyondTime--"+ctoGreenGrantedBeyondTime);
	           
	          ctoOrangeGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	         
	       //    println("ctoOrangeGrantedBeyondTime--"+ctoOrangeGrantedBeyondTime);
	           
	           ctoRedRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	          
	       //    println("ctoRedRejectedWithinTime--"+ctoRedRejectedWithinTime);
	           
	            ctoRedLMRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	         
	           
	      //     println("ctoRedLMRejectedWithinTime--"+ctoRedLMRejectedWithinTime);
	           
	          ctoGreenRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	      //     println("ctoGreenRejectedWithinTime--"+ctoGreenRejectedWithinTime);
	           
	           ctoOrangeRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	           
	       //    println("ctoOrangeRejectedWithinTime--"+ctoOrangeRejectedWithinTime);
	           
	           
	           /***4. Red/Orange/Green  CTO Rejected beyond the Time**/
	           
	           ctoRedRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	      //     println("ctoRedRejectedBeyondTime--"+ctoRedRejectedBeyondTime);
	           
	           ctoRedLMRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	       //    println("ctoRedLMRejectedBeyondTime--"+ctoRedLMRejectedBeyondTime);
	           
	           
	           ctoGreenRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	         //  println("ctoGreenRejectedBeyondTime--"+ctoGreenRejectedBeyondTime);
	           
	          
	           ctoOrangeRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0)
	           
	           
	        //   println("ctoOrangeRejectedBeyondTime--"+ctoOrangeRejectedBeyondTime);
	           
	           /***5. Red/Orange/Green  CTO Pending with in Time**/
	           
	           ctoRedPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
			           "and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	           
	       //    println("ctoRedPendingWithinTime--"+ctoRedPendingWithinTime);
	           
	           
	            ctoRedLMPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
			           " and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	           
	           
	        //   println("ctoRedPendingWithinTime--"+ctoRedPendingWithinTime);
	            
	           
	           ctoGreenPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
			           " and indCategoryName='GREEN' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	        //   println("ctoGreenPendingWithinTime--"+ctoGreenPendingWithinTime);
	           
	          ctoOrangePendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
			           " and indCategoryName='ORANGE' and groupId=? and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	       //    println("ctoOrangePendingWithinTime--"+ctoOrangePendingWithinTime);
	           
	           /***6. Red/Orange/Green  CTO Pending Beyond The Time**/
	           
	           ctoRedPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
			           "   and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	         //  println("ctoRedPendingBeyondTime--"+ctoRedPendingBeyondTime);
	           
	           ctoRedLMPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
			           "  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	           
	        //   println("ctoRedLMPendingBeyondTime--"+ctoRedLMPendingBeyondTime);
	          
	           ctoGreenPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and certificateFor ='new' and applicationStatus = 'pending' " +
	           "  and indCategoryName='GREEN' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	         //  println("ctoGreenPendingBeyondTime--"+ctoGreenPendingBeyondTime);
	           
	           ctoOrangePendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO'  and certificateFor ='new' and applicationStatus = 'pending' " +
	           "  and indCategoryName='ORANGE' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	          
	        //   println("ctoOrangePendingBeyondTime--"+ctoOrangePendingBeyondTime);
	           
	          
//	         Red/Orange/Green  CTO (R) Granted with in Time** Added By DEEPAK KUMAR 
	           
	             ctoRedGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			    	    
	    	       "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	       //   println("ctoRedGrantedWithinTimer--111"+ctoRedGrantedWithinTimer);
	         
	         ctoGreenGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			   	           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved' and groupId=? and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	          
	        //  println("ctoGreenGrantedWithinTimer--"+ctoGreenGrantedWithinTimer);
	           ctoOrangeGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			   	           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved' and groupId=? and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	          
	       //   println("ctoOrangeGrantedWithinTimer--"+ctoOrangeGrantedWithinTimer);
	          
	          /***2. Red/Orange/Green  CTO (R)Granted beyond the Time**/
           
	           ctoRedGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	           
	        //  println("ctoRedGrantedBeyondTimer--"+ctoRedGrantedBeyondTimer);
	          
	          ctoRedLMGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and applicationStatus = 'approved'  and indCategoryName='RED' and groupId=? and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	           
	         
	         
	           ctoGreenGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved' and  groupId=? and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	         //  println("ctoGreenGrantedBeyondTimer--"+ctoGreenGrantedBeyondTimer);
	           
	           ctoOrangeGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'approved' and groupId=? and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	         
	      //   println("ctoOrangeGrantedBeyondTimer--"+ctoOrangeGrantedBeyondTimer);
	           
	           /***3. Red/Orange/Green  CTO(R) Rejected with in Time**/
	           
	          ctoRedRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected' and groupId=? and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	          
	         
	         ctoGreenRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected' and groupId=? and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	         //  println("ctoGreenRejectedWithinTimer--"+ctoGreenRejectedWithinTimer);
	           
	           ctoOrangeRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected' and groupId=? and indCategoryName='ORANGE' and  pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	           
	        //   println("ctoOrangeRejectedWithinTimer--"+ctoOrangeRejectedWithinTimer);
	           
	           
	           /***4. Red/Orange/Green  CTO Rejected beyond the Time**/
	           
	           ctoRedRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='reNew'and groupId=? and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	        //   println("ctoRedRejectedBeyondTimer--"+ctoRedRejectedBeyondTimer);
	           ctoRedLMRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
					           "applicationType = 'CTO' and certificateFor ='reNew' and applicationStatus = 'rejected' and groupId=? and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
			           
	          //  println("ctoRedLMRejectedBeyondTimer--"+ctoRedLMRejectedBeyondTimer);
	           
	            ctoGreenRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='reNew' and groupId=? and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	        //   println("ctoGreenRejectedBeyondTimer--"+ctoGreenRejectedBeyondTimer);
	           
	          ctoOrangeRejectedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and applicationStatus = 'rejected' and certificateFor ='reNew' and groupId=?  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? ", [groupId, fromDate, toDate]).get(0);
	           
	           
	       //   println("ctoOrangeRejectedBeyondTimer--"+ctoOrangeRejectedBeyondTimer);
	           
	           /***5. Red/Orange/Green  CTO(R) Pending with in Time**/
	           
	            ctoRedPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew' and groupId=? and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
			           
			      //    println("ctoRedPendingWithinTimer--"+ctoRedPendingWithinTimer);
	           
	           
	       
	            
	           ctoGreenPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew' and groupId=?  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);		          
	        //   println("ctoGreenPendingWithinTimer--"+ctoGreenPendingWithinTimer);
	           
	          ctoOrangePendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
			           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew' and groupId=?  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);	          
	        //   println("ctoOrangePendingWithinTimer--"+ctoOrangePendingWithinTimer);
	           
	           /***6. Red/Orange/Green  CTO Pending Beyond The Time**/
	           
	          ctoRedPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew'and groupId=?  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);	          
	        
			   //     println("ctoRedPendingBeyondTimer--"+ctoRedPendingBeyondTimer);
	           
	           ctoGreenPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew' and groupId=? and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);        
	              
	         // println("ctoGreenPendingBeyondTimer--"+ctoGreenPendingBeyondTimer);
	           
	           ctoOrangePendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	           "applicationType = 'CTO' and applicationStatus = 'pending' and certificateFor = 'reNew' and groupId=? and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [groupId, fromDate, toDate]).get(0);
	              
	          
	          println("groupId--1111111111 "+groupId);
	          
	          def ctoFAvgGrantRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoFMedianTempRed = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new'and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoFAvgRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and application_status='rejected' and ind_category_name = 'RED' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

	            def abc1 = db.rows(ctoFAvgGrantRed)
	            def abc2 = db.rows(ctoFAvgRed)
	     //       println("abc1 "+abc1)
	        //    println("abc2 "+abc2)
	            
	            if(abc1.avg[0] !=null){
	                if ((abc1.avg[0]).toInteger() == 0.0) {
	                    ctoFAvgGrantedRed = 0.5
	                }else {
	                	ctoFAvgGrantedRed = (abc1.avg[0]).toInteger()
	                }
	            }
	            if(abc2.avg[0] !=null){
	                if ((abc2.avg[0]).toInteger() == 0.0) {
	                    ctoFAvgRejectedRed = 0.5
	                }else {
	                	ctoFAvgRejectedRed = (abc2.avg[0]).toInteger()
	                }
	            }
	            if(ctoFMedianTempRed) {
	                def abc = db.rows(ctoFMedianTempRed)
	                if (abc) {
	                    int[] a = (abc.abclist).toArray();
	                    int n = a.length;
	                    System.out.println("Median = " + median.findMedian(a, n));
	                    def test = median.findMedian(a, n);
	                    if(test<0){
	                    }else{
	                        ctoFMedianRed=test
	                    }
	                }
	            }
	            def ctoFAvgGrantGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoFMedianTempGreen = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoFAvgGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and application_status='rejected' and  ind_category_name = 'GREEN' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

	            def abcE1 = db.rows(ctoFAvgGrantGreen)
	            def abcE2 = db.rows(ctoFAvgGreen)
	          
	            if(abcE1.avg[0] !=null){
	                if ((abcE1.avg[0]).toInteger() == 0.0) {
	                    ctoFAvgGrantedGreen = 0.5
	                }else {
	                	ctoFAvgGrantedGreen = (abcE1.avg[0]).toInteger()
	                }
	            }
	            if(abcE2.avg[0] !=null){
	                if ((abcE2.avg[0]).toInteger() == 0.0) {
	                    ctoFAvgRejectedGreen = 0.5
	                }else {
	                	ctoFAvgRejectedGreen = (abcE2.avg[0]).toInteger()
	                }
	            }
	            if(ctoFMedianTempGreen) {
	                def abc = db.rows(ctoFMedianTempGreen)
	                if (abc) {
	                    int[] a = (abc.abclist).toArray();
	                    int n = a.length;
	                    System.out.println("Median = " + median.findMedian(a, n));
	                    def test = median.findMedian(a, n);
	                    if(test<0){
	                    }else{
	                        ctoFMedianGreen=test
	                    }
	                }
	            }
	            def ctoFAvgGrantOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoFMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoFAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='new' and application_status='rejected' and  ind_category_name = 'ORANGE' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

	            def abcF1 = db.rows(ctoFAvgGrantOrange)
	            def abcF2 = db.rows(ctoFAvgOrange)
	            if(abcF1.avg[0] !=null){
	                if ((abcF1.avg[0]).toInteger() == 0.0) {
	                    ctoFAvgGrantedOrange = 0.5
	                }else {
	                	ctoFAvgGrantedOrange = (abcF1.avg[0]).toInteger()
	                }
	            }
	            if(abcF2.avg[0] !=null){
	                if ((abcF2.avg[0]).toInteger() == 0.0) {
	                    ctoFAvgRejectedOrange = 0.5
	                }else {
	                	ctoFAvgRejectedOrange = (abcF2.avg[0]).toInteger()
	                }
	            }
	            if(ctoFMedianTempOrange) {
	                def abc = db.rows(ctoFMedianTempOrange)
	                if (abc) {
	                    int[] a = (abc.abclist).toArray();
	                    int n = a.length;
	                    System.out.println("Median = " + median.findMedian(a, n));
	                    def test = median.findMedian(a, n);
	                    if(test<0){
	                    }else{
	                        ctoFMedianOrange=test
	                    }
	                }
	            }
	          //  println("ctoFAvgGrantedOrange"+ctoFAvgGrantedOrange)
	         //  println("ctoFMedianOrange"+ctoFMedianOrange)
	            
	            def ctoRAvgGrantRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoRMedianTempRed = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoRAvgRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and application_status='rejected' and  ind_category_name = 'RED' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

	            def abcR1 = db.rows(ctoRAvgGrantRed)
	            def abcR2 = db.rows(ctoRAvgRed)
	            
	            // println("abcR1"+abcR1)
	          //   println("abcR2"+abcR2)
	            if(abcR1.avg[0] !=null){
	                if ((abcR1.avg[0]).toInteger() == 0.0) {
	                    ctoRAvgGrantedRed = 0.5
	                }else {
	                	ctoRAvgGrantedRed = (abcR1.avg[0]).toInteger()
	                }
	            }
	            if(abcR2.avg[0] !=null){
	                if ((abcR2.avg[0]).toInteger() == 0.0) {
	                    ctoRAvgRejectedRed = 0.5
	                }else {
	                	ctoRAvgRejectedRed = (abcR2.avg[0]).toInteger()
	                }
	            }
	            if(ctoRMedianTempRed) {
	                def abc = db.rows(ctoRMedianTempRed)
	                if (abc) {
	                    int[] a = (abc.abclist).toArray();
	                    int n = a.length;
	                    System.out.println("Median = " + median.findMedian(a, n));
	                    def test = median.findMedian(a, n);
	                    if(test<0){
	                    }else{
	                    	ctoRMedianRed=test
	                    }
	                }
	            }
	         //  println("ctoRAvgGrantedRed"+ctoRAvgGrantedRed)
	        //   println("ctoRMedianRed"+ctoRMedianRed)
	        
	            def ctoRAvgGrantGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoRMedianTempGreen = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoRAvgGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and application_status='rejected' and  ind_category_name = 'GREEN' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

	            def abcRg1 = db.rows(ctoRAvgGrantGreen)
	            def abcRg2 = db.rows(ctoRAvgGreen)
	            
	            // println("abcRg1"+abcRg1)
	          //   println("abcRg2"+abcRg2)
	            if(abcRg1.avg[0] !=null){
	                if ((abcRg1.avg[0]).toInteger() == 0.0) {
	                    ctoRAvgGrantedGreen = 0.5
	                }else {
	                	ctoRAvgGrantedGreen = (abcRg1.avg[0]).toInteger()
	                }
	            }
	            if(abcRg2.avg[0] !=null){
	                if ((abcRg2.avg[0]).toInteger() == 0.0) {
	                    ctoRAvgRejectedGreen = 0.5
	                }else {
	                	ctoRAvgRejectedGreen = (abcRg2.avg[0]).toInteger()
	                }
	            }
	            if(ctoRMedianTempGreen) {
	                def abc = db.rows(ctoRMedianTempGreen)
	                if (abc) {
	                    int[] a = (abc.abclist).toArray();
	                    int n = a.length;
	                    System.out.println("Median = " + median.findMedian(a, n));
	                    def test = median.findMedian(a, n);
	                    if(test<0){
	                    }else{
	                    	ctoRMedianGreen=test
	                    }
	                }
	            }
	       //     println("ctoRAvgGrantedGreen "+ctoRAvgGrantedGreen)
	       //    println("ctoRMedianGreen "+ctoRMedianGreen)
	       
	       
	            def ctoRAvgGrantOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoRMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date)) as abclist FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
	            def ctoRAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTO' and certificate_For ='reNew' and application_status='rejected' and  ind_category_name = 'ORANGE' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

	            def abcRo1 = db.rows(ctoRAvgGrantOrange)
	            def abcRo2 = db.rows(ctoRAvgOrange)
	            
	             println("abcRo1"+abcRo1)
	            println("abcRo2"+abcRo2)
	            if(abcRo1.avg[0] !=null){
	                if ((abcRo1.avg[0]).toInteger() == 0.0) {
	                    ctoRAvgGrantedOrange = 0.5
	                }else {
	                	ctoRAvgGrantedOrange = (abcRg1.avg[0]).toInteger()
	                }
	            }
	            if(abcRo2.avg[0] !=null){
	                if ((abcRo2.avg[0]).toInteger() == 0.0) {
	                	ctoRAvgRejectedOrange = 0.5
	                }else {
	                	ctoRAvgRejectedOrange = (abcRo2.avg[0]).toInteger()
	                }
	            }
	            if(ctoRMedianTempOrange) {
	                def abc = db.rows(ctoRMedianTempOrange)
	                if (abc) {
	                    int[] a = (abc.abclist).toArray();
	                    int n = a.length;
	                    System.out.println("Median = " + median.findMedian(a, n));
	                    def test = median.findMedian(a, n);
	                    if(test<0){
	                    }else{
	                    	ctoRMedianOrange=test
	                    }
	                }
	            }
		   }
		           ctoRedReceivedCount=   ctoRedGrantedWithinTime+ctoRedGrantedBeyondTime+ctoRedRejectedWithinTime+ctoRedRejectedBeyondTime+ctoRedPendingWithinTime+ctoRedPendingBeyondTime
		           ctoRedLMReceivedCount= ctoRedLMGrantedWithinTime+ctoRedLMGrantedBeyondTime+ctoRedLMRejectedWithinTime+ctoRedLMRejectedBeyondTime+ctoRedLMPendingWithinTime+ctoRedLMPendingBeyondTime
		           ctoGreenReceivedCount= ctoGreenGrantedWithinTime+ctoGreenGrantedBeyondTime+ctoGreenRejectedWithinTime+ctoGreenRejectedBeyondTime+ctoGreenPendingWithinTime+ctoGreenPendingBeyondTime
		           ctoOrangeReceivedCount=ctoOrangeGrantedWithinTime+ctoOrangeGrantedBeyondTime+ctoOrangeRejectedWithinTime+ctoOrangeRejectedBeyondTime+ctoOrangePendingWithinTime+ctoOrangePendingBeyondTime
		           
		           ctoRedReceivedCountr=   ctoRedGrantedWithinTimer+ctoRedGrantedBeyondTimer+ctoRedRejectedWithinTimer+ctoRedRejectedBeyondTimer+ctoRedPendingWithinTimer+ctoRedPendingBeyondTimer
		          // ctoRedLMReceivedCount= ctoRedLMGrantedWithinTime+ctoRedLMGrantedBeyondTime+ctoRedLMRejectedWithinTime+ctoRedLMRejectedBeyondTime+ctoRedLMPendingWithinTime+ctoRedLMPendingBeyondTime
		           ctoGreenReceivedCountr= ctoGreenGrantedWithinTimer+ctoGreenGrantedBeyondTimer+ctoGreenRejectedWithinTimer+ctoGreenRejectedBeyondTimer+ctoGreenPendingWithinTimer+ctoGreenPendingBeyondTimer
		           ctoOrangeReceivedCountr=ctoOrangeGrantedWithinTimer+ctoOrangeGrantedBeyondTimer+ctoOrangeRejectedWithinTimer+ctoOrangeRejectedBeyondTimer+ctoOrangePendingWithinTimer+ctoOrangePendingBeyondTimer
		          
		           //println("====================================================");
		          
		          
		           // println("====================================================");
		            /************************************************************************************************************************************************/
		            /******************************CTO END***********************************************************(*********************************************/
		            /************************************************************************************************************************************************/
		          
		           
		            /************************************************************************************************************************************************/
		            /******************************CTE START***********************************************************(*********************************************/
		            /************************************************************************************************************************************************/
		          

	               /***1. Red/Orange/Green  CTE Granted with in Time**/
		        if((groupId.equals("All"))){
		        	
		        	
		        
		               cteRedGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	      "applicationType = 'CTE' and certificateFor ='new' and applicationStatus = 'approved' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	      
		    	      cteGreenGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		   		    	        "applicationType = 'CTE' and applicationStatus = 'approved' and certificateFor ='new' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	        
		    	     // println("HELLO cteGreenGrantedWithinTime--"+cteGreenGrantedWithinTime);    
		    	           
		    	         cteOrangeGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	           
		    	 //    println("HELLO cteOrangeGrantedWithinTime--"+cteOrangeGrantedWithinTime);      
		    	           
		    	           
		    	    /***2. Red/Orange/Green  CTE Granted Beyond the Time**/
		    	   
		    	       cteRedGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);    
		    	           
		    	   //  println("HELLO cteRedGrantedBeyondTime--"+cteRedGrantedBeyondTime);
		    	    
		    	      cteGreenGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
						    	           "applicationType = 'CTE' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
				    	           
				    	           
		    	    //  println("HELLO cteGreenGrantedBeyondTime--"+cteGreenGrantedBeyondTime);  
		    	     
		    	    cteOrangeGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor ='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	           
		    	        //   println("HELLO cteOrangeGrantedBeyondTime--"+cteOrangeGrantedBeyondTime);
		    	              
		    	    /***3. Red/Orange/Green  CTO Rejected with in Time**/  
		    	    
		    	     cteRedRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'rejected'  and certificateFor ='new' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	           
		    	           
		    	     //println("HELLO cteRedRejectedWithinTime--"+cteRedRejectedWithinTime);
		    	    
		    	    
		    	          cteGreenRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'rejected'  and certificateFor ='new'  and indCategoryName='GREEN' and  pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);     
		    	    
		    	           
		    	  //  println("HELLO cteGreenRejectedWithinTime--"+cteGreenRejectedWithinTime);
		    	     
		    	          cteOrangeRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'rejected' and certificateFor ='new' and indCategoryName='ORANGE' and  pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);    
		    	   
		    	  //  println("HELLO cteOrangeRejectedWithinTime--"+cteOrangeRejectedWithinTime);       
		    	           
		    	    /***4. Red/Orange/Green  CTO Rejected beyond the time **/    
		    	          
		    	          cteRedRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'rejected'   and  certificateFor ='new' and indCategoryName='RED'  and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	     
		    	   //   println("HELLO cteRedRejectedBeyondTime--"+cteRedRejectedBeyondTime);             
		    	           
		    	       cteGreenRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'rejected'  and certificateFor ='new' and  indCategoryName='GREEN' and  pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	           
		    	 //   println("HELLO cteGreenRejectedBeyondTime--"+cteGreenRejectedBeyondTime);       
		    	           
		    	        cteOrangeRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
						    	           "applicationType = 'CTE' and applicationStatus = 'rejected' and certificateFor ='new' and indCategoryName='ORANGE' and  pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	           
		    	   
		    	//   println("HELLO cteOrangeRejectedBeyondTime--"+cteOrangeRejectedBeyondTime);        
		    	    /***5. Red/Orange/Green  CTO Pending with in Time**/
		    	   
		    	   
		    	        cteRedPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='new' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0); 
		    	          
		    	  //  println("HELLO cteRedPendingWithinTime--"+cteRedPendingWithinTime);
		    	           
		    	        cteGreenPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='new' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
		    	    // println("HELLO cteGreenPendingWithinTime--"+cteGreenPendingWithinTime);
		    	      
		    	        cteOrangePendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='new' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0); 
				    	           
		    	   //  println("HELLO cteOrangePendingWithinTime--"+cteOrangePendingWithinTime);
		    	      
		    	    /***6. Red/Orange/Green  CTO Pending beyond the  Time**/       
		    	       cteRedPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='new' and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				    	           
				    	           
				    	         //  println("HELLO cteRedPendingBeyondTime--"+cteRedPendingBeyondTime);
		    	    
		    	      cteGreenPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='new' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
				    	         
				    	      //    println("HELLO cteGreenPendingBeyondTime--"+cteGreenPendingBeyondTime);
		    	      
		    	         cteOrangePendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='new' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
				    	         
				    	           
				    	         
		    	    //  println("HELLO cteOrangePendingBeyondTime--"+cteOrangePendingBeyondTime);
		    	      
		    	      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    	       /***4. Red/Orange/Green  CTE ReNew WithIn time **/ 
		    	      
		    	       
		    	         
		     cteRedGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	      
		    	     // println("HELLO DEEPAK cteRedGrantedWithinTimer--"+cteRedGrantedWithinTimer);
		    	      
			 cteGreenGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
						    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				    	      
				    	   //   println("HELLO cteGreenGrantedWithinTimer--"+cteGreenGrantedWithinTimer);
			          
			 cteOrangeGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
						    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
				    	      
				    	      //println("HELLO cteOrangeGrantedWithinTimer--"+cteOrangeGrantedWithinTimer);
		    
						    	      /***4. Red/Orange/Green  CTE ReNew Beyond time **/
						    	      
		     cteRedGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	       //   println("HELLO cteRedGrantedBeyondTimer--"+cteRedGrantedBeyondTimer);
		     
			 cteGreenGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	        //  println("HELLO cteGreenGrantedBeyondTimer--"+cteGreenGrantedBeyondTimer);
				
			 cteOrangeGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	        //  println("HELLO cteOrangeGrantedBeyondTimer--"+cteOrangeGrantedBeyondTimer);
	      
			 /*. --------------------Red/Orange/Green  CTE ReNew Rejected Within time -----------------------**/
	      
			 cteRedRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	      //    println("HELLO cteRedRejectedWithinTimer--"+cteRedRejectedWithinTimer);
			 
	      cteGreenRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	     //     println("HELLO cteGreenRejectedWithinTimer--"+cteGreenRejectedWithinTimer);
	      
	      cteOrangeRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	     //     println("HELLO cteOrangeRejectedWithinTimer--"+cteOrangeRejectedWithinTimer);
	      
				 /*. --------------------Red/Orange/Green  CTE ReNew Rejected BEYOND time -----------------------**/

			 cteRedRejectedBeyondTimer  = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	      
	    //  println("HELLO cteRedRejectedBeyondTimer--"+cteRedRejectedBeyondTimer); 
				 
	     cteGreenRejectedBeyondTimer  = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	      
	     // println("HELLO cteGreenRejectedBeyondTimer--"+cteGreenRejectedBeyondTimer); 
	     
	      cteOrangeRejectedBeyondTimer  = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	      
	   //   println("HELLO cteOrangeRejectedBeyondTimer--"+cteOrangeRejectedBeyondTimer); 
	      /***5. Red/Orange/Green  CTE RENEW Pending with in Time**/
	    	   
	    	
		    cteRedPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
	          
	  //  println("HELLO cteRedPendingWithinTimer--"+cteRedPendingWithinTimer);
	           
	      cteGreenPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
	 //   println("HELLO cteGreenPendingWithinTimer--"+cteGreenPendingWithinTimer);
	      
	      cteOrangePendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);
		    	           
	 //   println("HELLO cteOrangePendingWithinTimer--"+cteOrangePendingWithinTimer);
	      
	    /***6. Red/Orange/Green  CTE(R) Pending beyond the  Time**/       
	           
	       cteRedPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
		    	          
		    	        //   println("HELLO cteRedPendingBeyondTimer--"+cteRedPendingBeyondTimer);
	    cteGreenPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
		    	         
		    	      //   println("HELLO cteGreenPendingBeyondTimer--"+cteGreenPendingBeyondTimer);
	     cteOrangePendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [fromDate, toDate]).get(0);  
		             
	    //  println("HELLO cteOrangePendingBeyondTimer--"+cteOrangePendingBeyondTimer);
	      
	      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        def cteAvgG = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def hwmMedianTemp = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteAvgR = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

        def abc5 = db.rows(cteAvgG)
        def abc6 = db.rows(cteAvgR)
    //   println("HELLO abc5--"+abc5);
        
     //   println("HELLO abc6--"+abc6);
        
        if(abc5.avg[0] !=null){
            if ((abc5.avg[0]).toInteger() == 0.0) {
                hwmAvgGranted = 0.5
            }else {
                hwmAvgGranted = (abc5.avg[0]).toInteger()
            }
        }
        if(abc6.avg[0] !=null){
            if ((abc6.avg[0]).toInteger() == 0.0) {
                hwmAvgRejected = 0.5
            }else {
                hwmAvgRejected = (abc6.avg[0]).toInteger()
            }
        }
        if(hwmMedianTemp) {
            def abc = db.rows(hwmMedianTemp)
            if (abc) {
                int[] a = (abc.abclist).toArray();
                int n = a.length;
                System.out.println("hwmMedianTemp = " + median.findMedian(a, n));
                def test = median.findMedian(a, n);
                if(test<0){
                }else{
                    hwmMedian=test
                }
            }
        }
        
        def cteAvgGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def hwmMedianTempGreen = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteAvgRGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and ind_category_name = 'GREEN' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

        def abcg5 = db.rows(cteAvgGreen)
        def abcg6 = db.rows(cteAvgRGreen)
       
        if(abcg5.avg[0] !=null){
            if ((abcg5.avg[0]).toInteger() == 0.0) {
                cteAvgGrantedGreen = 0.5
            }else {
            	cteAvgGrantedGreen = (abcg5.avg[0]).toInteger()
            }
        }
        if(abcg6.avg[0] !=null){
            if ((abcg6.avg[0]).toInteger() == 0.0) {
                cteAvgRejectedGreen = 0.5
            }else {
            	cteAvgRejectedGreen = (abcg6.avg[0]).toInteger()
            }
        }
        if(hwmMedianTempGreen) {
            def abc = db.rows(hwmMedianTempGreen)
            if (abc) {
                int[] a = (abc.abclist).toArray();
                int n = a.length;
                System.out.println("hwmMedianTempGreen = " + median.findMedian(a, n));
                def test = median.findMedian(a, n);
                if(test<0){
                }else{
                	cteMediangGreen=test
                }
            }
        }
        
        
        def cteAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"'";
        def cteMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteAvgROrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

        def abco5 = db.rows(cteAvgOrange)
        def abco6 = db.rows(cteAvgROrange)
   //     println("abco5"+abco5)
   //    println("abco6"+abco6)
        if(abco5.avg[0] !=null){
            if ((abco5.avg[0]).toInteger() == 0.0) {
            	cteAvgGrantedOrange = 0.5
            }else {
            	cteAvgGrantedOrange = (abco5.avg[0]).toInteger()
            }
        }
        if(abco6.avg[0] !=null){
            if ((abco6.avg[0]).toInteger() == 0.0) {
                cteAvgRejectedOrange = 0.5
            }else {
            	cteAvgRejectedOrange = (abco6.avg[0]).toInteger()
            }
        }
        if(cteMedianTempOrange) {
            def abc = db.rows(cteMedianTempOrange)
            if (abc) {
                int[] a = (abc.abclist).toArray();
                int n = a.length;
                System.out.println("cteMedianTempOrange = " + median.findMedian(a, n));
                def test = median.findMedian(a, n);
                if(test<0){
                }else{
                	cteMediangOrange=test
                }
            }
        }
        def cteReAvgRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteReMedianTempRed = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteReAvgReda = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

        def abcreOr5 = db.rows(cteReAvgRed)
        def abcOr6 = db.rows(cteReAvgReda)
//       println("abcreOr5"+abcreOr5)
 //      println("abcOr6"+abcOr6)
        if(abcreOr5.avg[0] !=null){
            if ((abcreOr5.avg[0]).toInteger() == 0.0) {
            	cteReAvgGrantedRed = 0.5
            }else {
            	cteReAvgGrantedRed = (abcreOr5.avg[0]).toInteger()
            }
        }
        if(abcOr6.avg[0] !=null){
            if ((abcOr6.avg[0]).toInteger() == 0.0) {
                cteReAvgRejectedRed = 0.5
            }else {
            	cteReAvgRejectedRed = (abcOr6.avg[0]).toInteger()
            }
        }
        if(cteReMedianTempRed) {
            def abc = db.rows(cteReMedianTempRed)
            if (abc) {
                int[] a = (abc.abclist).toArray();
                int n = a.length;
                System.out.println("cteReMedianTempRed = " + median.findMedian(a, n));
                def test = median.findMedian(a, n);
                if(test<0){
                }else{
                    cteReMedianRed=test
                }
            }
        }  
        def cteReAvgGreena = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteReMedianTempGreenaa = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteReAvgGreenaa = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

        def abcreg5 = db.rows(cteReAvgGreena)
        def abcreg6 = db.rows(cteReAvgGreenaa)
   //    println("abcreg5"+abcreg5)
   //    println("abcreg6"+abcreg6)
   //     println("cteReMedianTempGreenaa"+cteReMedianTempGreenaa)
        if(abcreg5.avg[0] !=null){
            if ((abcreg5.avg[0]).toInteger() == 0.0) {
                cteReAvgGrantedGreen = 0.5
            }else {
            	cteReAvgGrantedGreen = (abcreg5.avg[0]).toInteger()
            }
        }
        if(abcreg6.avg[0] !=null){
            if ((abcreg6.avg[0]).toInteger() == 0.0) {
                cteReAvgRejectedGreen = 0.5
            }else {
            	cteReAvgRejectedGreen = (abcreg6.avg[0]).toInteger()
            }
        }
        if(cteReMedianTempGreenaa) {
            def abc = db.rows(cteReMedianTempGreenaa)
            if (abc) {
                int[] a = (abc.abclist).toArray();
                int n = a.length;
                System.out.println("cteReMedianTempGreenaa = " + median.findMedian(a, n));
                def test = median.findMedian(a, n);
                if(test<0){
                }else{
                    cteReMedianGreen=test
                }
            }
        }
        
        
        def cteReAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteReMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";
        def cteReAvgOrangee = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew'  and application_status='rejected' and ind_category_name = 'ORANGE' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' ";

        def abcreO5 = db.rows(cteReAvgOrange)
        def abcreO6 = db.rows(cteReAvgOrangee)
      
        if(abcreO5.avg[0] !=null){
            if ((abcreO5.avg[0]).toInteger() == 0.0) {
                cteReAvgGrantedOrange = 0.5
            }else {
            	cteReAvgGrantedOrange = (abcreO5.avg[0]).toInteger()
            }
        }
        if(abcreO6.avg[0] !=null){
            if ((abcreO6.avg[0]).toInteger() == 0.0) {
            	cteReAvgRejectedOrange = 0.5
            }else {
            	cteReAvgRejectedOrange = (abcreO6.avg[0]).toInteger()
            }
        }
        if(cteReMedianTempOrange) {
            def abc = db.rows(cteReMedianTempOrange)
            if (abc) {
                int[] a = (abc.abclist).toArray();
                int n = a.length;
                System.out.println("cteReMedianTempOrange = " + median.findMedian(a, n));
                def test = median.findMedian(a, n);
                if(test<0){
                }else{
                    cteReMedianOrange=test
                }
            }
        }   
	      
		    	      
		        } else {
		     	     // println("IN ELSE CTE ");

		        

		             cteRedGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	      "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	      
		    	      
		    	   //   println("HELLO222211 cteRedGrantedWithinTime--"+cteRedGrantedWithinTime);
		    	        cteGreenGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		   		    	        "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	        
		    	    //   println("HELLO cteGreenGrantedWithinTime--"+cteGreenGrantedWithinTime);    
		    	           
		    	        cteOrangeGrantedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	           
		    	  //  println("HELLO cteOrangeGrantedWithinTime--"+cteOrangeGrantedWithinTime);      
		    	           
		    	           
		    	    /***2. Red/Orange/Green  CTE Granted Beyond the Time**/
		    	     cteRedGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)  ;    
		    	           
		    	  //   println("HELLO cteRedGrantedBeyondTime--"+cteRedGrantedBeyondTime);
		    	    
		    	     cteGreenGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	           
		    	    //  println("HELLO cteGreenGrantedBeyondTime--"+cteGreenGrantedBeyondTime);  
		    	     
		    	        cteOrangeGrantedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	    
		    	   //  println("HELLO cteOrangeGrantedBeyondTime--"+cteOrangeGrantedBeyondTime);
		    	              
		    	    /***3. Red/Orange/Green  CTO Rejected with in Time**/  
		    	    
		    	     cteRedRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)  ;   
		    	           
		    	           
		    	  //   println("HELLO cteRedRejectedWithinTime--"+cteRedRejectedWithinTime);
		    	    
		    	    
		    	     cteGreenRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)  ;    
		    	    
		    	           
		    	 //   println("HELLO cteGreenRejectedWithinTime--"+cteGreenRejectedWithinTime);
		    	     
		    	      cteOrangeRejectedWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)  ;    
		    	   
		    	//   println("HELLO cteOrangeRejectedWithinTime--"+cteOrangeRejectedWithinTime);       
		    	           
		    	    /***4. Red/Orange/Green  CTO Rejected beyond the time **/    
		    	          
		    	     cteRedRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0) ;    
		    	     
		    	  //    println("HELLO cteRedRejectedBeyondTime--"+cteRedRejectedBeyondTime);             
		    	           
		    	        cteGreenRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	           
		    	//  println("HELLO cteGreenRejectedBeyondTime--"+cteGreenRejectedBeyondTime);       
		    	           
		    	       cteOrangeRejectedBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)  ;    
		    	           
		    	   
		    	 //  println("HELLO cteOrangeRejectedBeyondTime--"+cteOrangeRejectedBeyondTime);        
		    	    /***5. Red/Orange/Green  CTO Pending with in Time**/
		    	   
		    	   
		    	       cteRedPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'pending' " +
				    	           "  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	          
		    	//    println("HELLO cteRedPendingWithinTime--"+cteRedPendingWithinTime);
		    	           
		    	        cteGreenPendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'pending' " +
				    	           " and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	          
		    	   //  println("HELLO cteGreenPendingWithinTime--"+cteGreenPendingWithinTime);
		    	      
		    	       cteOrangePendingWithinTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'pending' " +
				    	           "  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)     
		    	          
		    	   //  println("HELLO cteOrangePendingWithinTime--"+cteOrangePendingWithinTime);
		    	      
		    	    /***6. Red/Orange/Green  CTO Pending beyond the  Time**/       
		    	           
		    	       cteRedPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'pending' " +
				    	           " and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate < ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)    
		    	         
		    	   // println("HELLO cteRedPendingBeyondTime--"+cteRedPendingBeyondTime);
		    	    
		    	        cteGreenPendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'pending' " +
				    	           "   and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate < ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)
		    	         
		    	  //   println("HELLO cteGreenPendingBeyondTime--"+cteGreenPendingBeyondTime);
		    	         cteOrangePendingBeyondTime = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
				    	           "applicationType = 'CTE' and certificateFor='new' and applicationStatus = 'pending' " +
				    	           " and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate < ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0)
		    	      
		    	   //   println("HELLO cteOrangePendingBeyondTime--"+cteOrangePendingBeyondTime);
		    	      
		    	           /***4. Red/Orange/Green  CTE ReNew WithIn time **/ 
				    	      
			    	       
			    	         
	     cteRedGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    			    	      
		    	//  println("HELLO DEEPAK cteRedGrantedWithinTimer--"+cteRedGrantedWithinTimer);
		    			    	      
		 cteGreenGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    					    	      
		    	   //  println("HELLO cteGreenGrantedWithinTimer--"+cteGreenGrantedWithinTimer);
		    				          
			 cteOrangeGrantedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    				   	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    					    	      
		    		 //     println("HELLO cteOrangeGrantedWithinTimer--"+cteOrangeGrantedWithinTimer);
		    			    
		    	      /***4. Red/Orange/Green  CTE ReNew Beyond time **/
		    							    	      
	     cteRedGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	   	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	    //	          println("HELLO cteRedGrantedBeyondTimer--"+cteRedGrantedBeyondTimer);
		    			     
		 cteGreenGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	 	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	 //   println("HELLO cteGreenGrantedBeyondTimer--"+cteGreenGrantedBeyondTimer);
		    					
		 cteOrangeGrantedBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	 	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'approved'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
	 		       //   println("HELLO cteOrangeGrantedBeyondTimer--"+cteOrangeGrantedBeyondTimer);
		    	 	      
		    				 /*. --------------------Red/Orange/Green  CTE ReNew Rejected Within time -----------------------**/
		    	 	      
		 cteRedRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		     	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	      //    println("HELLO cteRedRejectedWithinTimer--"+cteRedRejectedWithinTimer);
		    				 
		   cteGreenRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	 	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	 	    //      println("HELLO cteGreenRejectedWithinTimer--"+cteGreenRejectedWithinTimer);
		    	 	      
		   cteOrangeRejectedWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		 		       //   println("HELLO cteOrangeRejectedWithinTimer--"+cteOrangeRejectedWithinTimer);
		    	 	      
		    					 /*. --------------------Red/Orange/Green  CTE ReNew Rejected BEYOND time -----------------------**/

		     cteRedRejectedBeyondTimer  = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	 	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	 	      
		    	   //   println("HELLO cteRedRejectedBeyondTimer--"+cteRedRejectedBeyondTimer); 
		    					 
	    cteGreenRejectedBeyondTimer  = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    		      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		     	      
	  	 	   //   println("HELLO cteGreenRejectedBeyondTimer--"+cteGreenRejectedBeyondTimer); 
		    	 	     
	     cteOrangeRejectedBeyondTimer  = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    	      "applicationType = 'CTE' and certificateFor ='reNew' and applicationStatus = 'rejected'  and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	 	      
		    	 	//      println("HELLO cteOrangeRejectedBeyondTimer--"+cteOrangeRejectedBeyondTimer); 
		    	 	      /***5. Red/Orange/Green  CTE RENEW Pending with in Time**/
		    		    	   
		    		    	
		 cteRedPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    			 "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='RED' and pendingSince - applicationRecieptDate <= '120 days'and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	 	          
		    	 //	    println("HELLO cteRedPendingWithinTimer--"+cteRedPendingWithinTimer);
		    	 	           
	    cteGreenPendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    			    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    	 	//    println("HELLO cteGreenPendingWithinTimer--"+cteGreenPendingWithinTimer);
		    	 	      
	     cteOrangePendingWithinTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		       	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate <= '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    			    	           
	   	 	//    println("HELLO cteOrangePendingWithinTimer--"+cteOrangePendingWithinTimer);
		    	 	      
		 	 	    /***6. Red/Orange/Green  CTE(R) Pending beyond the  Time**/       
		    	 	           
		 cteRedPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		 			    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='RED' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0); 
		    			    	          
					        // println("HELLO cteRedPendingBeyondTimer--"+cteRedPendingBeyondTimer);
		  cteGreenPendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    		          "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='GREEN' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    			    	         
		    			    	  //       println("HELLO cteGreenPendingBeyondTimer--"+cteGreenPendingBeyondTimer);
		    cteOrangePendingBeyondTimer = AllSummaryReport.executeQuery("select count(*) from AllSummaryReport where " +
		    			    	           "applicationType = 'CTE' and applicationStatus = 'pending' and certificateFor ='reNew' and indCategoryName='ORANGE' and pendingSince - applicationRecieptDate > '120 days' and groupId=? and applicationRecieptDate >=  ? and applicationRecieptDate <=  ?", [ groupId, fromDate, toDate]).get(0);
		    			             

           def cteAvgG = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def hwmMedianTemp = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteAvgR = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

           def abc5 = db.rows(cteAvgG)
           def abc6 = db.rows(cteAvgR)
          println("HELLO abc5--"+abc5);
           
           println("HELLO abc6--"+abc6);
           
           if(abc5.avg[0] !=null){
               if ((abc5.avg[0]).toInteger() == 0.0) {
                   hwmAvgGranted = 0.5
               }else {
                   hwmAvgGranted = (abc5.avg[0]).toInteger()
               }
           }
           if(abc6.avg[0] !=null){
               if ((abc6.avg[0]).toInteger() == 0.0) {
                   hwmAvgRejected = 0.5
               }else {
                   hwmAvgRejected = (abc6.avg[0]).toInteger()
               }
           }
           if(hwmMedianTemp) {
               def abc = db.rows(hwmMedianTemp)
               if (abc) {
                   int[] a = (abc.abclist).toArray();
                   int n = a.length;
                   System.out.println("hwmMedianTemp = " + median.findMedian(a, n));
                   def test = median.findMedian(a, n);
                   if(test<0){
                   }else{
                       hwmMedian=test
                   }
               }
           }
           
           def cteAvgGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def hwmMedianTempGreen = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteAvgRGreen = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and ind_category_name = 'GREEN' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

           def abcg5 = db.rows(cteAvgGreen)
           def abcg6 = db.rows(cteAvgRGreen)
          
           if(abcg5.avg[0] !=null){
               if ((abcg5.avg[0]).toInteger() == 0.0) {
                   cteAvgGrantedGreen = 0.5
               }else {
               	cteAvgGrantedGreen = (abcg5.avg[0]).toInteger()
               }
           }
           if(abcg6.avg[0] !=null){
               if ((abcg6.avg[0]).toInteger() == 0.0) {
                   cteAvgRejectedGreen = 0.5
               }else {
               	cteAvgRejectedGreen = (abcg6.avg[0]).toInteger()
               }
           }
           if(hwmMedianTempGreen) {
               def abc = db.rows(hwmMedianTempGreen)
               if (abc) {
                   int[] a = (abc.abclist).toArray();
                   int n = a.length;
                   System.out.println("hwmMedianTempGreen = " + median.findMedian(a, n));
                   def test = median.findMedian(a, n);
                   if(test<0){
                   }else{
                   	cteMediangGreen=test
                   }
               }
           }
           
           
           def cteAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteAvgROrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

           def abco5 = db.rows(cteAvgOrange)
           def abco6 = db.rows(cteAvgROrange)
      //     println("abco5"+abco5)
      //    println("abco6"+abco6)
           if(abco5.avg[0] !=null){
               if ((abco5.avg[0]).toInteger() == 0.0) {
               	cteAvgGrantedOrange = 0.5
               }else {
               	cteAvgGrantedOrange = (abco5.avg[0]).toInteger()
               }
           }
           if(abco6.avg[0] !=null){
               if ((abco6.avg[0]).toInteger() == 0.0) {
                   cteAvgRejectedOrange = 0.5
               }else {
               	cteAvgRejectedOrange = (abco6.avg[0]).toInteger()
               }
           }
           if(cteMedianTempOrange) {
               def abc = db.rows(cteMedianTempOrange)
               if (abc) {
                   int[] a = (abc.abclist).toArray();
                   int n = a.length;
                   System.out.println("cteMedianTempOrange = " + median.findMedian(a, n));
                   def test = median.findMedian(a, n);
                   if(test<0){
                   }else{
                   	cteMediangOrange=test
                   }
               }
           }
           def cteReAvgRed = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteReMedianTempRed = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new' and ind_category_name = 'RED' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteReAvgReda = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'new'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

           def abcreOr5 = db.rows(cteReAvgRed)
           def abcOr6 = db.rows(cteReAvgReda)
  //        println("abcreOr5"+abcreOr5)
    //      println("abcOr6"+abcOr6)
           if(abcreOr5.avg[0] !=null){
               if ((abcreOr5.avg[0]).toInteger() == 0.0) {
               	cteReAvgGrantedRed = 0.5
               }else {
               	cteReAvgGrantedRed = (abcreOr5.avg[0]).toInteger()
               }
           }
           if(abcOr6.avg[0] !=null){
               if ((abcOr6.avg[0]).toInteger() == 0.0) {
                   cteReAvgRejectedRed = 0.5
               }else {
               	cteReAvgRejectedRed = (abcOr6.avg[0]).toInteger()
               }
           }
           if(cteReMedianTempRed) {
               def abc = db.rows(cteReMedianTempRed)
               if (abc) {
                   int[] a = (abc.abclist).toArray();
                   int n = a.length;
                   System.out.println("cteReMedianTempRed = " + median.findMedian(a, n));
                   def test = median.findMedian(a, n);
                   if(test<0){
                   }else{
                       cteReMedianRed=test
                   }
               }
           }  
           def cteReAvgGreena = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteReMedianTempGreenaa = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'GREEN' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteReAvgGreenaa = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew'  and application_status='rejected' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

           def abcreg5 = db.rows(cteReAvgGreena)
           def abcreg6 = db.rows(cteReAvgGreenaa)
      //    println("abcreg5"+abcreg5)
      //    println("abcreg6"+abcreg6)
      //     println("cteReMedianTempGreenaa"+cteReMedianTempGreenaa)
           if(abcreg5.avg[0] !=null){
               if ((abcreg5.avg[0]).toInteger() == 0.0) {
                   cteReAvgGrantedGreen = 0.5
               }else {
               	cteReAvgGrantedGreen = (abcreg5.avg[0]).toInteger()
               }
           }
           if(abcreg6.avg[0] !=null){
               if ((abcreg6.avg[0]).toInteger() == 0.0) {
                   cteReAvgRejectedGreen = 0.5
               }else {
               	cteReAvgRejectedGreen = (abcreg6.avg[0]).toInteger()
               }
           }
           if(cteReMedianTempGreenaa) {
               def abc = db.rows(cteReMedianTempGreenaa)
               if (abc) {
                   int[] a = (abc.abclist).toArray();
                   int n = a.length;
                   System.out.println("cteReMedianTempGreenaa = " + median.findMedian(a, n));
                   def test = median.findMedian(a, n);
                   if(test<0){
                   }else{
                       cteReMedianGreen=test
                   }
               }
           }
           
           
           def cteReAvgOrange = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteReMedianTempOrange = "SELECT ((pending_since::date) - (application_reciept_date::date))as abclist FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew' and ind_category_name = 'ORANGE' and application_status='approved' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";
           def cteReAvgOrangee = "SELECT avg((pending_since::date) - (application_reciept_date::date)) FROM all_summary_report WHERE application_type='CTE' and certificate_For = 'reNew'  and application_status='rejected' and ind_category_name = 'ORANGE' and application_reciept_date>='"+fromDate+"' and application_reciept_date<='"+toDate+"' and group_id='"+groupId+"'";

           def abcreO5 = db.rows(cteReAvgOrange)
           def abcreO6 = db.rows(cteReAvgOrangee)
         
           if(abcreO5.avg[0] !=null){
               if ((abcreO5.avg[0]).toInteger() == 0.0) {
                   cteReAvgGrantedOrange = 0.5
               }else {
               	cteReAvgGrantedOrange = (abcreO5.avg[0]).toInteger()
               }
           }
           if(abcreO6.avg[0] !=null){
               if ((abcreO6.avg[0]).toInteger() == 0.0) {
               	cteReAvgRejectedOrange = 0.5
               }else {
               	cteReAvgRejectedOrange = (abcreO6.avg[0]).toInteger()
               }
           }
           if(cteReMedianTempOrange) {
               def abc = db.rows(cteReMedianTempOrange)
               if (abc) {
                   int[] a = (abc.abclist).toArray();
                   int n = a.length;
                   System.out.println("cteReMedianTempOrange = " + median.findMedian(a, n));
                   def test = median.findMedian(a, n);
                   if(test<0){
                   }else{
                       cteReMedianOrange=test
                   }
               }
           }   
		        
		        }
		            
		           
		            
		           
		         //   println("cteReAvgGrantedGreen"+cteReAvgGrantedGreen)
		         //   println("cteReMedianGreen"+cteReMedianGreen)
		         //   println("--------Deepak kumar----111--")
		            	
		       
		        
		            
		    	      cteReceivedCount = cteGrantedWithinTime + cteGrantedBeyondTime + cteRejectedWithinTime + cteRejectedBeyondTime + ctePendingWithinTime + ctePendingBeyondTime
		    	      cteRedReceivedCount=   cteRedGrantedWithinTime+cteRedGrantedBeyondTime+cteRedRejectedWithinTime+cteRedRejectedBeyondTime+cteRedPendingWithinTime+cteRedPendingBeyondTime
			          cteGreenReceivedCount= cteGreenGrantedWithinTime+cteGreenGrantedBeyondTime+cteGreenRejectedWithinTime+cteGreenRejectedBeyondTime+cteGreenPendingWithinTime+cteGreenPendingBeyondTime
			          cteOrangeReceivedCount=cteOrangeGrantedWithinTime+cteOrangeGrantedBeyondTime+cteOrangeRejectedWithinTime+cteOrangeRejectedBeyondTime+cteOrangePendingWithinTime+cteOrangePendingBeyondTime
			          
			          cteRedReceivedCountr =  cteRedGrantedWithinTimer+cteRedGrantedBeyondTimer+cteRedRejectedWithinTimer+cteRedRejectedBeyondTimer+cteRedPendingWithinTimer+cteRedPendingBeyondTimer
			          cteGreenReceivedCountr= cteGreenGrantedWithinTimer+cteGreenGrantedBeyondTimer+cteGreenRejectedWithinTimer+cteGreenRejectedBeyondTimer+cteGreenPendingWithinTimer+cteGreenPendingBeyondTimer
			          cteOrangeReceivedCountr=cteOrangeGrantedWithinTimer+cteOrangeGrantedBeyondTimer+cteOrangeRejectedWithinTimer+cteOrangeRejectedBeyondTimer+cteOrangePendingWithinTimer+cteOrangePendingBeyondTimer
			          //println("====================================================");
			           //println("CTE COUNT--RED--"+cteRedReceivedCount);
			           //println("CTE COUNT--GREEN--"+cteGreenReceivedCount);
			           //println("CTE COUNT--ORANGE--"+cteOrangeReceivedCount);
		    	       //println("====================================================");
		    	      /************************************************************************************************************************************************/
			          /******************************CTE END***********************************************************(*********************************************/
			          /************************************************************************************************************************************************/
			              
		    	           
		    	             hwmGrantedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
		   	    	           ""+query1+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
		   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
		   	    	 //   println("HELLO hwmGrantedWithinTime--"+hwmGrantedWithinTime);
		   	    	           hwmGrantedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
		   	    	           ""+query1+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
		   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
		   	    	           
		   	    	  //  println("HELLO hwmGrantedBeyondTime--"+hwmGrantedBeyondTime);       
		   	    	           hwmRejectedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
		   	    	           ""+query1+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
		   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
		   	    	   //  println("HELLO hwmRejectedWithinTime--"+hwmRejectedWithinTime);      
		   	    	           
		   	    	           hwmRejectedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
		   	    	           ""+query1+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
		   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
		   	    	   //  println("HELLO hwmRejectedBeyondTime--"+hwmRejectedBeyondTime);     
		   	    	           hwmPendingWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
		   	    	           ""+query1+" and applicationStatus = 'pending' " +
		   	    	           " and authDate >=  ? and authDate <=  ? and authDate >=  ? and authDate <=  ?", [fromDate, toDate, today120, today]).get(0)
		   	    	  //   println("HELLO hwmPendingWithinTime--"+hwmPendingWithinTime);     
		   	    	           hwmPendingBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
		   	    	           ""+query1+" and applicationStatus = 'pending' " +
		   	    	           " and authDate >=  ? and authDate <=  ? and authDate < ? ", [fromDate, toDate, today120]).get(0)
		   	    	 //     println("HELLO hwmPendingBeyondTime--"+hwmPendingBeyondTime);    
		   	    	          hwmReceivedCount = hwmGrantedWithinTime + hwmGrantedBeyondTime + hwmRejectedWithinTime + hwmRejectedBeyondTime + hwmPendingWithinTime + hwmPendingBeyondTime
		   	    	          
		   	    	    //      println("hwmReceivedCount---"+hwmReceivedCount);
			          
		    	      def HWMAvgG = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query6+"and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
		              def HWMMedianTemp = "SELECT ((pending_since::date) - (auth_date::date)) as abclist FROM all_summary_reportwms WHERE "+query6+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
		              def HWMAvgR = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query6+" and application_status='rejected' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";

		              def abc7 = db.rows(HWMAvgG)
		              def abc8 = db.rows(HWMAvgR)
		              if(abc7.avg[0] !=null){
		                  if ((abc7.avg[0]).toInteger() == 0.0) {
		                      HWMAvgGranted = 0.5
		                  }else {
		                      HWMAvgGranted = (abc7.avg[0]).toInteger()
		                  }
		              }
		              if(abc8.avg[0] !=null){
		                  if ((abc8.avg[0]).toInteger() == 0.0) {
		                      HWMAvgRejected = 0.5
		                  }else {
		                      HWMAvgRejected = (abc8.avg[0]).toInteger()
		                  }
		              }
		              if(HWMMedianTemp) {
		                  def abc = db.rows(HWMMedianTemp)
		                  if (abc) {
		                      int[] a = (abc.abclist).toArray();
		                      int n = a.length;
		                      System.out.println("HWMMedianTemp = " + median.findMedian(a, n));
		                      def test = median.findMedian(a, n);
		                      if(test<0){
		                      }else{
		                          HWMMedian=test
		                      }
		                  }
		              }
		          //    println("HWMAvgGranted "+HWMAvgGranted)
			       //     println("HWMMedian "+HWMMedian)
		   	    	          
		   	    	          bmwGrantedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	           ""+query2+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
			   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
			   	    	          
			   	    	           bmwGrantedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	           ""+query2+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
			   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
			   	    	           
			   	    	           
			   	    	           bmwRejectedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	           ""+query2+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
			   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
			   	    	           
			   	    	           
			   	    	           bmwRejectedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	           ""+query2+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
			   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
			   	    	          
			   	    	           bmwPendingWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	           ""+query2+" and applicationStatus = 'pending' and pendingSince - authDate <= '120 days' " +
			   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate,]).get(0)
			   	    	          
			   	    	           bmwPendingBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	           ""+query2+" and applicationStatus = 'pending' and pendingSince - authDate > '120 days'" +
			   	    	           " and authDate >=  ? and authDate <=  ? ", [fromDate, toDate,]).get(0)
			   	    	          
			   	    	          bmwReceivedCount = bmwGrantedWithinTime + bmwGrantedBeyondTime + bmwRejectedWithinTime + bmwRejectedBeyondTime + bmwPendingWithinTime + bmwPendingBeyondTime
			   	    	          
			   	    	          //println("bmwReceivedCount---"+bmwReceivedCount);
		          
			   	    	   def bmwAvgG = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query7+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
		   	               def bmwMedianTemp = "SELECT ((pending_since::date) - (auth_date::date)) as abclist FROM all_summary_reportwms WHERE "+query7+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
		   	               def bmwAvgR = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query7+" and application_status='rejected' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";

		   	               def abc9 = db.rows(bmwAvgG)
		   	               def abc10 = db.rows(bmwAvgR)
		   	               if(abc9.avg[0] !=null){
		   	                   if ((abc9.avg[0]).toInteger() == 0.0) {
		   	                       bmwAvgGranted = 0.5
		   	                   }else {
		   	                       bmwAvgGranted = (abc9.avg[0]).toInteger()
		   	                   }
		   	               }
		   	               if(abc10.avg[0] !=null){
		   	                   if ((abc10.avg[0]).toInteger() == 0.0) {
		   	                       bmwAvgRejected = 0.5
		   	                   }else {
		   	                       bmwAvgRejected = (abc10.avg[0]).toInteger()
		   	                   }
		   	               }
		   	               if(bmwMedianTemp) {
		   	                   def abc = db.rows(bmwMedianTemp)
		   	                   if (abc) {
		   	                       int[] a = (abc.abclist).toArray();
		   	                       int n = a.length;
		   	                       System.out.println("bmwMedianTemp = " + median.findMedian(a, n));
		   	                       def test = median.findMedian(a, n);
		   	                       if(test<0){
		   	                       }else{
		   	                           bmwMedian=test
		   	                       }
		   	                   }
		   	               }
		   	         //   println("bmwAvgGranted "+bmwAvgGranted)
					 //   println("bmwMedian "+bmwMedian)   
					 
					 
		   	    	          // PWM  ADDED BY DEEPAK KUMAR
		   	    	          
			   	    	          pwmGrantedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	        		  ""+query3+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
					   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
				   	    	           
				   	    	    
					   	    	           
				   	    	     println("pwmGrantedWithinTime---"+pwmGrantedWithinTime);
			   	    	       
		   	    	          
			   	    	          pwmGrantedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	        		""+query3+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
					   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
					   	    	           
			   	    	        //		   println("pwmGrantedBeyondTime---"+pwmGrantedBeyondTime); 
			   	    	        
			   	    	          pwmRejectedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	        		 ""+query3+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
					   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)  
			   	    	        	//	    println("pwmRejectedWithinTime---"+pwmRejectedWithinTime);
			   	    	          
			   	    	          pwmRejectedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	        		""+query3+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
					   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
			   	    	        	//	   println("pwmRejectedBeyondTime---"+pwmRejectedBeyondTime);
			   	    	 
			   	    	          pwmPendingWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +			   	    	        		
			   	    	        		""+query3+" and applicationStatus = 'pending' and pendingSince - authDate <= '120 days' " +
					   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0) 
	   	    	           		//	   println("pwmPendingWithinTime---"+pwmPendingWithinTime);  
			   	    	     
			   	    	          pwmPendingBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
			   	    	        		  "applicationFor = 'PWM' and applicationStatus = 'pending' and pendingSince - authDate > '120 days'" +
			   	    	        		" and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0) 
			   	    	           
			   	    	        	//	      println("pwmPendingBeyondTime---"+pwmPendingBeyondTime); 
			   	    	   
			   	    	 pwmReceivedCount =   pwmGrantedWithinTime+pwmGrantedBeyondTime+pwmRejectedWithinTime+pwmRejectedBeyondTime+pwmPendingWithinTime+pwmPendingBeyondTime
			   	    	
			   	      def pwmAvgG = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query8+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
			   	               def pwmMedianTemp = "SELECT ((pending_since::date) - (auth_date::date)) as abclist FROM all_summary_reportwms WHERE "+query8+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
			   	               def pwmAvgR = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query8+" and application_status='rejected' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";

			   	               def abc11 = db.rows(pwmAvgG)
			   	               def abc12 = db.rows(pwmAvgR)
			   	               if(abc11.avg[0] !=null){
			   	                   if ((abc11.avg[0]).toInteger() == 0.0) {
			   	                       pwmAvgGranted = 0.5
			   	                   }else {
			   	                       pwmAvgGranted = (abc11.avg[0]).toInteger()
			   	                   }
			   	               }
			   	               if(abc12.avg[0] !=null){
			   	                   if ((abc12.avg[0]).toInteger() == 0.0) {
			   	                       pwmAvgRejected = 0.5
			   	                   }else {
			   	                       pwmAvgRejected = (abc12.avg[0]).toInteger()
			   	                   }
			   	               }
			   	               if(pwmMedianTemp) {
			   	                   def abc = db.rows(pwmMedianTemp)
			   	                   if (abc) {
			   	                       int[] a = (abc.abclist).toArray();
			   	                       int n = a.length;
			   	                       System.out.println("pwmMedianTemp = " + median.findMedian(a, n));
			   	                       def test = median.findMedian(a, n);
			   	                       if(test<0){
			   	                       }else{
			   	                           pwmMedian=test
			   	                       }
			   	                   }
			   	               }
			   	    	 // ------------------------EWASTE  ADDED BY DEEPAK KUMAR-------------------------//
			   	    	 
		    	  ewasteGrantedWithinTime = EWasteManagementPendingDetails.executeQuery("select count(*) from EWasteManagementPendingDetails where " +
		    			  ""+query5+" and applicationStatus = 'approved' and lastUpdated - dateCreated <= '120 days' " +
	   	    	           " and dateCreated >=  ? and dateCreated <=  ?", [fromDate, toDate]).get(0)
				   	    	           
				   	    	      /*  ewasteGrantedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
				   	    	           "applicationFor = 'PWM' and applicationStatus = 'approved' and pendingSince - authDate <= '120 days'").get(0)   */
				   	    	    //   println("ewasteGrantedWithinTime---"+ewasteGrantedWithinTime);
			   	    	       
		   	    	          
				   	    	      ewasteGrantedBeyondTime = EWasteManagementPendingDetails.executeQuery("select count(*) from EWasteManagementPendingDetails where " +
				   	    	    		 ""+query5+" and applicationStatus = 'approved' and lastUpdated - dateCreated  > '120 days'" +
					   	    	           " and dateCreated >=  ? and dateCreated <=  ?", [fromDate, toDate]).get(0) 
					   	    	           
			   	    	        	//	    println("ewasteGrantedBeyondTime---"+ewasteGrantedBeyondTime); 
			   	    	        
			   	    	        		ewasteRejectedWithinTime = EWasteManagementPendingDetails.executeQuery("select count(*) from EWasteManagementPendingDetails where " +
			   	    	        			 ""+query5+" and applicationStatus = 'rejected' and lastUpdated - dateCreated <= '120 days' " +
						   	    	           " and dateCreated >=  ? and dateCreated <=  ?", [fromDate, toDate]).get(0)
			   	    	        	//	    println("ewasteRejectedWithinTime---"+ewasteRejectedWithinTime);
			   	    	          
			   	    	        		ewasteRejectedBeyondTime = EWasteManagementPendingDetails.executeQuery("select count(*) from EWasteManagementPendingDetails where " +
			   	    	        				""+query5+" and applicationStatus = 'rejected' and lastUpdated - dateCreated  > '120 days'" +
			 			   	    	           " and dateCreated >=  ? and dateCreated <=  ?", [fromDate, toDate]).get(0)
			   	    	        	//	   println("ewasteRejectedBeyondTime---"+ewasteRejectedBeyondTime);
			   	    	 
			   	    	        		ewastePendingWithinTime = EWasteManagementPendingDetails.executeQuery("select count(*) from EWasteManagementPendingDetails where " +
			   	    	        			 ""+query5+" and applicationStatus = 'pending'  and lastUpdated - dateCreated  <= '120 days'"  +
						   	    	           " and dateCreated >=  ? and dateCreated <=  ?", [fromDate, toDate]).get(0)
	   	    	           			//  println("ewastePendingWithinTime---"+ewastePendingWithinTime);  
			   	    	     
			   	    	        		ewastePendingBeyondTime = EWasteManagementPendingDetails.executeQuery("select count(*) from EWasteManagementPendingDetails where " +
			   	    	        			 ""+query5+" and applicationStatus = 'pending'  and lastUpdated - dateCreated  > '120 days'"  +
						   	    	           " and dateCreated >=  ? and dateCreated <=  ?", [fromDate, toDate]).get(0)
			   	    	           
			   	    	        		 //    println("ewastePendingBeyondTime---"+ewastePendingBeyondTime); 
			   	    	   
			   	    	        		ewasteReceivedCount =   ewasteGrantedWithinTime+ewasteGrantedBeyondTime+ewasteRejectedWithinTime+ewasteRejectedBeyondTime+ewastePendingWithinTime+ewastePendingBeyondTime
			   	    	
			   	    def ewAvgG = "SELECT avg((last_updated::date) - (date_created::date)) FROM ewaste_management_pending_details WHERE application_for='EWaste' and application_status='approved' and date_created>='"+fromDate+"' and date_created<='"+toDate+"'";
		            def ewMedianTemp = "SELECT ((last_updated::date) - (date_created::date)) as abclist FROM ewaste_management_pending_details WHERE application_for='EWaste' and application_status='approved' and date_created>='"+fromDate+"' and date_created<='"+toDate+"'";
		            def ewAvgR = "SELECT avg((last_updated::date) - (date_created::date)) FROM ewaste_management_pending_details WHERE application_for='EWaste' and application_status='rejected' and date_created>='"+fromDate+"' and date_created<='"+toDate+"'";

		            def abc13 = db.rows(ewAvgG)
		            println("abc13 "+abc13)
		            def abc14 = db.rows(ewAvgR)
		            println("abc14 "+abc14)
		            if(abc13.avg[0] !=null){
		                if ((abc13.avg[0]).toInteger() == 0.0) {
		                    ewAvgGranted = 0.5
		                }else {
		                    ewAvgGranted = (abc13.avg[0]).toInteger()
		                }
		            }
		            if(abc14.avg[0] !=null){
		                if ((abc14.avg[0]).toInteger() == 0.0) {
		                    ewAvgRejected = 0.5
		                }else {
		                    ewAvgRejected = (abc14.avg[0]).toInteger()
		                }
		            }
		            if(ewMedianTemp) {
		                def abc = db.rows(ewMedianTemp)
		                if (abc) {
		                    int[] a = (abc.abclist).toArray();
		                    int n = a.length;
		                    System.out.println("ewMedianTemp = " + median.findMedian(a, n));
		                    def test = median.findMedian(a, n);
		                    if(test<0){
		                    }else{
		                        ewMedian=test
		                    }
		                }
		            }  
		            
	        
	            println("ewAvgGranted "+ewAvgGranted)
		        println("ewMedian "+ewMedian)  
			   	    	        		
			   	    	        		// MSW  ADDED BY DEEPAK KUMAR
					   	    	          
					   	    	          mswGrantedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
					   	    	        		 ""+query4+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
							   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)
						   	    	           
						   	    	     
						   	    	   //    println("mswGrantedWithinTime---"+mswGrantedWithinTime);
					   	    	       
				   	    	          
					   	    	          mswGrantedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
					   	    	        		 ""+query4+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days'" +
							   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0) 
							   	    	           
					   	    	        	//	    println("mswGrantedBeyondTime---"+mswGrantedBeyondTime); 
					   	    	        
					   	    	        		mswRejectedWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
					   	    	        				""+query4+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days'" +
									   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)   
					   	    	        	//	    println("mswRejectedWithinTime---"+mswRejectedWithinTime);
					   	    	          
					   	    	        		mswRejectedBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
					   	    	        				""+query4+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
									   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0) 
					   	    	        	//	   println("mswRejectedBeyondTime---"+mswRejectedBeyondTime);
					   	    	 
					   	    	        		mswPendingWithinTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
					   	    	        				""+query4+" and applicationStatus = 'pending' and pendingSince - authDate <= '120 days' " +
									   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)    
			   	    	           			   println("mswPendingWithinTime---"+mswPendingWithinTime);  
					   	    	     //
					   	    	        		mswPendingBeyondTime = AllSummaryReportWMS.executeQuery("select count(*) from AllSummaryReportWMS where " +
					   	    	        				""+query4+" and applicationStatus = 'pending' and pendingSince - authDate > '120 days' " +
									   	    	           " and authDate >=  ? and authDate <=  ?", [fromDate, toDate]).get(0)    
					   	    	           
					   	    	        		//      println("mswPendingBeyondTime---"+mswPendingBeyondTime); 
					   	    	   
					   	    	        		mswReceivedCount =   mswGrantedWithinTime+mswGrantedBeyondTime+mswRejectedWithinTime+mswRejectedBeyondTime+mswPendingWithinTime+mswPendingBeyondTime

					   	    	        	  def mswAvgG = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE "+query9+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
								   	               def mswMedianTemp = "SELECT ((pending_since::date) - (auth_date::date)) as abclist FROM all_summary_reportwms WHERE "+query9+" and application_status='approved' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";
								   	               def mswAvgR = "SELECT avg((pending_since::date) - (auth_date::date)) FROM all_summary_reportwms WHERE  "+query9+"  and application_status='rejected' and auth_date>='"+fromDate+"' and auth_date<='"+toDate+"'";

								   	               def abcm11 = db.rows(mswAvgG)
								   	               def abcm12 = db.rows(mswAvgR)
								   	               if(abcm11.avg[0] !=null){
								   	                   if ((abcm11.avg[0]).toInteger() == 0.0) {
								   	                       mswAvgGranted = 0.5
								   	                   }else {
								   	                	mswAvgGranted = (abcm11.avg[0]).toInteger()
								   	                   }
								   	               }
								   	               if(abcm12.avg[0] !=null){
								   	                   if ((abcm12.avg[0]).toInteger() == 0.0) {
								   	                	mswAvgRejected = 0.5
								   	                   }else {
								   	                	mswAvgRejected = (abcm12.avg[0]).toInteger()
								   	                   }
								   	               }
								   	               if(mswMedianTemp) {
								   	                   def abc = db.rows(mswMedianTemp)
								   	                   if (abc) {
								   	                       int[] a = (abc.abclist).toArray();
								   	                       int n = a.length;
								   	                       System.out.println("mswMedianTemp = " + median.findMedian(a, n));
								   	                       def test = median.findMedian(a, n);
								   	                       if(test<0){
								   	                       }else{
								   	                           mswMedian=test
								   	                       }
								   	                   }
								   	               }   	        		
			   	    	 
			   	    	 [
		          
		          //CTO RED Small
		          ctoRedReceivedCount: ctoRedReceivedCount, ctoRedGrantedWithinTime: ctoRedGrantedWithinTime, ctoRedGrantedBeyondTime: ctoRedGrantedBeyondTime, 
		          ctoRedRejectedWithinTime: ctoRedRejectedWithinTime, ctoRedRejectedBeyondTime: ctoRedRejectedBeyondTime, ctoRedPendingWithinTime: ctoRedPendingWithinTime,
		          ctoRedPendingBeyondTime: ctoRedPendingBeyondTime,
		          
		          //CTO RED Medium Large
		          ctoRedLMReceivedCount: ctoRedLMReceivedCount, ctoRedLMGrantedWithinTime: ctoRedLMGrantedWithinTime, ctoRedLMGrantedBeyondTime: ctoRedLMGrantedBeyondTime, 
		          ctoRedLMRejectedWithinTime: ctoRedLMRejectedWithinTime, ctoRedLMRejectedBeyondTime: ctoRedLMRejectedBeyondTime, ctoRedLMPendingWithinTime: ctoRedLMPendingWithinTime,
		          ctoRedLMPendingBeyondTime: ctoRedLMPendingBeyondTime, 
		          
	              //CTO green
		          ctoGreenReceivedCount: ctoGreenReceivedCount, ctoGreenGrantedWithinTime: ctoGreenGrantedWithinTime, ctoGreenGrantedBeyondTime: ctoGreenGrantedBeyondTime, 
		          ctoGreenRejectedWithinTime: ctoGreenRejectedWithinTime, ctoGreenRejectedBeyondTime: ctoGreenRejectedBeyondTime, ctoGreenPendingWithinTime: ctoGreenPendingWithinTime,
		          ctoGreenPendingBeyondTime: ctoGreenPendingBeyondTime, 
		          
	              
		          //CTO orange
		          ctoOrangeReceivedCount: ctoOrangeReceivedCount, ctoOrangeGrantedWithinTime: ctoOrangeGrantedWithinTime,
		          ctoOrangeGrantedBeyondTime: ctoOrangeGrantedBeyondTime, ctoOrangeRejectedWithinTime: ctoOrangeRejectedWithinTime, ctoOrangeRejectedBeyondTime: ctoOrangeRejectedBeyondTime,
		          ctoOrangePendingWithinTime: ctoOrangePendingWithinTime, ctoOrangePendingBeyondTime: ctoOrangePendingBeyondTime,
		          
		         // CTO (R)RED
		          ctoRedReceivedCountr: ctoRedReceivedCountr,
		          ctoRedGrantedWithinTimer: ctoRedGrantedWithinTimer, ctoRedGrantedBeyondTimer: ctoRedGrantedBeyondTimer, ctoRedRejectedWithinTimer: ctoRedRejectedWithinTimer, ctoRedRejectedBeyondTimer: ctoRedRejectedBeyondTimer,
		          ctoRedPendingWithinTimer : ctoRedPendingWithinTimer, ctoRedPendingBeyondTimer: ctoRedPendingBeyondTimer,
		          
		         // CTO (R)GREEN
		          ctoGreenReceivedCountr: ctoGreenReceivedCountr,
		          ctoGreenGrantedWithinTimer: ctoGreenGrantedWithinTimer, ctoGreenGrantedBeyondTimer: ctoGreenGrantedBeyondTimer, ctoGreenRejectedWithinTimer: ctoGreenRejectedWithinTimer,
		          ctoGreenPendingWithinTimer: ctoGreenPendingWithinTimer, ctoGreenPendingBeyondTimer: ctoGreenPendingBeyondTimer,
		          
		         // CTO (R)ORANGE
		         ctoOrangeReceivedCountr: ctoOrangeReceivedCountr,
		          ctoOrangeGrantedWithinTimer: ctoOrangeGrantedWithinTimer, ctoOrangeGrantedBeyondTimer: ctoOrangeGrantedBeyondTimer, ctoOrangeRejectedWithinTimer: ctoOrangeRejectedWithinTimer, ctoOrangeRejectedBeyondTimer: ctoOrangeRejectedBeyondTimer,
		          ctoOrangePendingWithinTimer : ctoOrangePendingWithinTimer, ctoOrangePendingBeyondTimer: ctoOrangePendingBeyondTimer,
		          
		          //CTE RED Small
		          cteRedReceivedCount: cteRedReceivedCount, cteRedGrantedWithinTime: cteRedGrantedWithinTime, cteRedGrantedBeyondTime: cteRedGrantedBeyondTime, 
		          cteRedRejectedWithinTime: cteRedRejectedWithinTime, cteRedRejectedBeyondTime: cteRedRejectedBeyondTime, cteRedPendingWithinTime: cteRedPendingWithinTime,
		          cteRedPendingBeyondTime: cteRedPendingBeyondTime,  
		          
		          
	              // CTE green
		          cteGreenReceivedCount: cteGreenReceivedCount, cteGreenGrantedWithinTime: cteGreenGrantedWithinTime, cteGreenGrantedBeyondTime: cteGreenGrantedBeyondTime, 
		          cteGreenRejectedWithinTime: cteGreenRejectedWithinTime, cteGreenRejectedBeyondTime: cteGreenRejectedBeyondTime, cteGreenPendingWithinTime: cteGreenPendingWithinTime,
		          cteGreenPendingBeyondTime: cteGreenPendingBeyondTime, 
		          
	              //CTE orange
		          cteOrangeReceivedCount: cteOrangeReceivedCount, cteOrangeGrantedWithinTime: cteOrangeGrantedWithinTime,
		          cteOrangeGrantedBeyondTime: cteOrangeGrantedBeyondTime, cteOrangeRejectedWithinTime: cteOrangeRejectedWithinTime, cteOrangeRejectedBeyondTime: cteOrangeRejectedBeyondTime,
		          cteOrangePendingWithinTime: cteOrangePendingWithinTime, cteOrangePendingBeyondTime: cteOrangePendingBeyondTime,

		          // CTE(R) RED 
		          cteRedReceivedCountr: cteRedReceivedCountr, cteRedGrantedWithinTimer: cteRedGrantedWithinTimer, cteRedGrantedBeyondTimer: cteRedGrantedBeyondTimer,cteRedRejectedWithinTimer: cteRedRejectedWithinTimer, cteRedRejectedBeyondTimer: cteRedRejectedBeyondTimer,
		          cteRedPendingWithinTimer: cteRedPendingWithinTimer, cteRedPendingBeyondTimer: cteRedPendingBeyondTimer,
		          
		          // CTE(R) GREEN
		          cteGreenReceivedCountr: cteGreenReceivedCountr, cteGreenGrantedWithinTimer: cteGreenGrantedWithinTimer, cteGreenGrantedBeyondTimer: cteGreenGrantedBeyondTimer, cteGreenRejectedWithinTimer: cteGreenRejectedWithinTimer, cteGreenRejectedBeyondTimer: cteGreenRejectedBeyondTimer,
		          cteGreenPendingWithinTimer: cteGreenPendingWithinTimer, cteGreenPendingBeyondTimer: cteGreenPendingBeyondTimer, ctoGreenRejectedBeyondTimer: ctoGreenRejectedBeyondTimer,
		         
		          // CTE(R) Orange
		          cteOrangeReceivedCountr: cteOrangeReceivedCountr, cteOrangeGrantedWithinTimer: cteOrangeGrantedWithinTimer, cteOrangeGrantedBeyondTimer: cteOrangeGrantedBeyondTimer, cteOrangeRejectedWithinTimer: cteOrangeRejectedWithinTimer, cteOrangeRejectedBeyondTimer: cteOrangeRejectedBeyondTimer,
		          cteOrangePendingWithinTimer: cteOrangePendingWithinTimer, cteOrangePendingBeyondTimer: cteOrangePendingBeyondTimer,
		          
//		          fromDateStr: fromDateStr, toDateStr: toDateStr,regionalOffice:regionalOffice,groupId:groupId
	              //HWM
		          hwmReceivedCount: hwmReceivedCount, hwmGrantedWithinTime: hwmGrantedWithinTime,
		          hwmGrantedBeyondTime: hwmGrantedBeyondTime, hwmRejectedWithinTime: hwmRejectedWithinTime, hwmRejectedBeyondTime: hwmRejectedBeyondTime,
		          hwmPendingWithinTime: hwmPendingWithinTime, hwmPendingBeyondTime: hwmPendingBeyondTime, 
		          
		          hwmAvgGranted: hwmAvgGranted, hwmAvgRejected: hwmAvgRejected, hwmMedian: hwmMedian, cteAvgGrantedGreen: cteAvgGrantedGreen, cteMediangGreen: cteMediangGreen,
		          cteAvgGrantedOrange: cteAvgGrantedOrange, cteMediangOrange: cteMediangOrange,
		          
		          cteReAvgGrantedRed: cteReAvgGrantedRed, cteReMedianRed: cteReMedianRed, cteReAvgGrantedOrange: cteReAvgGrantedOrange, cteReAvgRejectedOrange: cteReAvgRejectedOrange,
		          cteReMedianOrange: cteReMedianOrange,
		          
		          cteReAvgGrantedGreen: cteReAvgGrantedGreen, cteReAvgRejectedGreen: cteReAvgRejectedGreen, cteReMedianGreen: cteReMedianGreen,
		          ctoFAvgRejectedRed: ctoFAvgRejectedRed, ctoFAvgGrantedRed: ctoFAvgGrantedRed, ctoFMedianRed: ctoFMedianRed,
		          
		          ctoFAvgGrantedGreen: ctoFAvgGrantedGreen, ctoFAvgRejectedGreen: ctoFAvgRejectedGreen, ctoFMedianGreen: ctoFMedianGreen,
		          ctoFAvgGrantedOrange: ctoFAvgGrantedOrange, ctoFAvgRejectedOrange: ctoFAvgRejectedOrange, ctoFMedianOrange: ctoFMedianOrange,
		          
		          ctoRMedianRed: ctoRMedianRed, ctoRAvgGrantedRed: ctoRAvgGrantedRed,
		          ctoRMedianGreen: ctoRMedianGreen, ctoRAvgRejectedGreen: ctoRAvgRejectedGreen, ctoRAvgGrantedGreen: ctoRAvgGrantedGreen,
		          
		          ctoRAvgGrantedOrange: ctoRAvgGrantedOrange, ctoRAvgRejectedOrange: ctoRAvgRejectedOrange, ctoRMedianOrange: ctoRMedianOrange,
		          
		          HWMAvgGranted: HWMAvgGranted, HWMAvgRejected: HWMAvgRejected, HWMMedian: HWMMedian,
		          
		          bmwAvgGranted: bmwAvgGranted, bmwAvgRejected: bmwAvgRejected, bmwMedian: bmwMedian,
		          
		          pwmAvgGranted: pwmAvgGranted, pwmAvgRejected: pwmAvgRejected, pwmMedian: pwmMedian,
		          
		          mswAvgGranted: mswAvgGranted, mswAvgRejected: mswAvgRejected, mswMedian: mswMedian,
		          
		          ewAvgGranted: ewAvgGranted, ewAvgRejected: ewAvgRejected, ewMedian: ewMedian,
		          
		          //BMW
		          bmwReceivedCount: bmwReceivedCount, 
		          bmwGrantedWithinTime: bmwGrantedWithinTime, bmwGrantedBeyondTime: bmwGrantedBeyondTime, bmwRejectedWithinTime: bmwRejectedWithinTime,
		          bmwRejectedBeyondTime: bmwRejectedBeyondTime, bmwPendingWithinTime: bmwPendingWithinTime, bmwPendingBeyondTime: bmwPendingBeyondTime,
		          

		          //   PWM
		          pwmReceivedCount: pwmReceivedCount, pwmGrantedWithinTime: pwmGrantedWithinTime, pwmGrantedBeyondTime: pwmGrantedBeyondTime, pwmRejectedWithinTime: pwmRejectedWithinTime,
		          pwmRejectedBeyondTime: pwmRejectedBeyondTime, pwmPendingWithinTime: pwmPendingWithinTime, pwmPendingBeyondTime: pwmPendingBeyondTime,
		         
		          //   EWASTE
		          ewasteReceivedCount : ewasteReceivedCount, ewasteGrantedWithinTime: ewasteGrantedWithinTime, ewasteGrantedBeyondTime: ewasteGrantedBeyondTime, ewasteRejectedWithinTime:ewasteRejectedWithinTime, ewasteRejectedBeyondTime:ewasteRejectedBeyondTime,
		          ewastePendingWithinTime: ewastePendingWithinTime, ewastePendingBeyondTime: ewastePendingBeyondTime,
		        // MSW
		          mswReceivedCount: mswReceivedCount, mswGrantedWithinTime: mswGrantedWithinTime, mswGrantedBeyondTime: mswGrantedBeyondTime, mswRejectedWithinTime:mswRejectedWithinTime, mswRejectedBeyondTime: mswRejectedBeyondTime,
		          mswPendingWithinTime: mswPendingWithinTime, mswPendingBeyondTime: mswPendingBeyondTime,
		          fromDateStr: fromDateStr, toDateStr: toDateStr,regionalOffice:regionalOffice,groupId:groupId
	        
		          
		          
		          ]
		          
		          
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
//////////////////////////////////////////////////////////	/
	def popApplicationCountAllModuleCto = {

	    println("Params in popApplicationCountAllModuleCto---"+params)
	    //println("params: " + params)
	    //println("fromDateStr: " + params.fromDateStr)
	    //println("toDateStr: " + params.toDateStr)
	    def groupId=params.groupId;
	    String query="";
	    String query1="";
	    String query2="";
	    String query3="";
	    String query4="";
	    String query5="";
	    if(groupId=="All")
	    {
	    //	 query="singleWindow='false' and applicationStatus !='returned'";
	    	 query="applicationStatus !='returned'";
	    	 query1="applicationFor = 'HWM' and applicationStatus !='returned'"; 
	         query2="applicationFor = 'BMW' and applicationStatus !='returned'";
	    	// query1="applicationStatus !='returned'"; 
	    	// query2="applicationStatus !='returned'";
	    	 query3="applicationFor = 'PWM' and applicationStatus !='returned'";
	    	 query4="applicationFor = 'MSW' and applicationStatus !='returned'";
	    	 query5="applicationStatus !='returned'";
	    }else
	    {
	    //	query="singleWindow='false' and applicationStatus !='returned' and groupId ='"+groupId+"'";
	    	query="applicationStatus !='returned' and groupId ='"+groupId+"'";
	    	query1="applicationFor = 'HWM' and applicationStatus !='returned' and groupId ='"+groupId+"'"; 
	    	query2="applicationFor = 'BMW' and applicationStatus !='returned' and groupId ='"+groupId+"'";
	    	query3="applicationFor = 'PWM' and applicationStatus !='returned' and groupId ='"+groupId+"'";
	    	query4="applicationFor = 'MSW' and applicationStatus !='returned' and groupId ='"+groupId+"'";
	    	query5="applicationFor = 'EWaste' and applicationStatus !='returned' and role.group.id ='"+groupId+"'";
	    //	query3="applicationStatus !='returned' and groupId ='"+groupId+"'"; 
	    //	query2="applicationStatus !='returned' and groupId ='"+groupId+"'";
	    }
	    
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    def simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String fromDateStr = params.fromDateStr
	    String toDateStr = params.toDateStr
	    def fromDate = simpleDateFormat.parse(fromDateStr)
	    def toDate = simpleDateFormat.parse(toDateStr)
	    WorkingDays workingDays=new WorkingDays();
		Date today = new Date()
	    def day730=workingDays.calDueDate(today,730);
		Date date730 = formatter.parse(day730)
	    Calendar cal112 = new GregorianCalendar();
		cal112.setTime(date730)
	    Date today730 = cal112.getTime();
	    
	    def isGrantedWithinTime = params.gwt
	    def isGrantedBeyondTime = params.gbt
	    def isRejectedWithinTime = params.rwt
	    def isRejectedBeyondTime = params.rbt
	    def isPendingWithinTime = params.pwt
	    def isPendingBeyondTime = params.pbt
	    
	    
	    def applicationType=params.type;
	    def category=params.cat;
	    def forApplication=	params.number;
	    def certificateFor = params.certificate
	   
	   
	    
	    println("certificateFor---"+certificateFor);
	    println("applicationType---"+applicationType);
	    println("category---"+category);
	    println("forApplication---"+forApplication);
	    def var;
	    def catVar;
	    def certiFor;
	    def certiForR;
	    def cate;
	    
	    
	    def day120=workingDays.calDueDate(today,120);
		Date date120 = formatter.parse(day120)
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(date120)
	    Date today120 = cal.getTime()
	    
	    
	    def day40=workingDays.calDueDate(today,40);
		Date date40 = formatter.parse(day40)
	    Calendar ca2 = new GregorianCalendar();
	    ca2.setTime(date40)
	    Date today40 = ca2.getTime()
	    //println("today40: " + today40)
	    
	    
	    def day32=workingDays.calDueDate(today,32);
		Date date32 = formatter.parse(day32)
		Calendar ca3 = new GregorianCalendar();
	    ca3.setTime(date32)
	    Date today32 = ca3.getTime()
	    //println("today32: " + today32)
	    
	    
	    def day20=workingDays.calDueDate(today,20);
		Date date20 = formatter.parse(day20)
		Calendar ca4 = new GregorianCalendar();
	    ca4.setTime(date20)
	    Date today20 = ca4.getTime()
	    //println("today20: " + today20)
	    
	    
	    def day28=workingDays.calDueDate(today,28);
		Date date28 = formatter.parse(day28)
	    Calendar ca5= new GregorianCalendar();
	    ca5.setTime(date28)
	    Date today28 = ca5.getTime()
	    //println("today28: " + today28)
	    
	    Date finalDate
	    def finalDateStr
	    
	  /*  if(applicationType=='cto' && category=='redLM')
	    {
	      var="CTO";
	      finalDate=today40;
	      finalDateStr=40;
	      catVar=" and indCategoryName ='RED'";
	      
	    }else*/
	    
	    if (applicationType=='cto' && category=='red' && certificateFor=='new')
	    {
	    	var="CTO";
	        finalDate=today32;
	        finalDateStr=32;
	        catVar=" and indCategoryName ='RED'";
	        certiFor="certificateFor ='new'";
	        
	    }else if (applicationType=='cto' && category=='orange' && certificateFor=='new')
	    {
	    	var="CTO";
	        finalDate=today28;
	        finalDateStr=28;
	        catVar=" and indCategoryName ='ORANGE'";
	        certiFor="certificateFor ='new'";
	    }else if (applicationType=='cto' && category=='green' && certificateFor=='new')
	    {
	    	var="CTO";
	        finalDate=today20;
	        finalDateStr=20;
	        catVar=" and indCategoryName ='GREEN'";
	        certiFor="certificateFor ='new'";
	    }else if (applicationType=='cto' && category=='red' && certificateFor=='renew')
	    {
	    	println(" RED reNew")
	    	var="CTO";
	        finalDate=today40;
	        finalDateStr=40;
	        catVar=" and indCategoryName ='RED'";
	        certiFor="certificateFor ='reNew'";
	      //  cate="RED"
	        
	    	
	    }else if (applicationType=='cto' && category=='orange' && certificateFor=='renew')
	    {
	    	println("Orange reNew")
	    	var="CTO";
	        finalDate=today28;
	        finalDateStr=28;
	        catVar=" and indCategoryName ='ORANGE'";
	        certiFor="certificateFor ='reNew'";
	      //  cate="ORANGE"
	    	
	    }else if (applicationType=='cto' && category=='green' && certificateFor=='renew')
	    {
	    	println("Green reNew")
	    	var="CTO";
	        finalDate=today20;
	        finalDateStr=20
	        catVar=" and indCategoryName ='GREEN'";
	        certiFor="certificateFor ='reNew'";
	     //   cate="GREEN"
	    	
	    }
	    
	    else if (applicationType=='cte' && category=='red' && certificateFor=='new')
	    {
	    	println("1111")
	    	var="CTE";
	        finalDate=today40;
	        finalDateStr=40;
	        catVar=" and indCategoryName ='RED'";
	        certiFor="certificateFor ='new'";
	      //  cate="RED"
	        
	    	
	    }else if (applicationType=='cte' && category=='orange' && certificateFor=='new')
	    {
	    //	println("Orange New")
	    	var="CTE";
	        finalDate=today28;
	        finalDateStr=28;
	        catVar=" and indCategoryName ='ORANGE'";
	        certiFor="certificateFor ='new'";
	      //  cate="ORANGE"
	    	
	    }else if (applicationType=='cte' && category=='green' && certificateFor=='new')
	    {
	    	//println("Green New")
	    	var="CTE";
	        finalDate=today20;
	        finalDateStr=20
	        catVar=" and indCategoryName ='GREEN'";
	        certiFor="certificateFor ='new'";
	     //   cate="GREEN"
	    	
	    } else if (applicationType=='cte' && category=='red' && certificateFor=='renew')
	    {
	    	println(" RED reNew")
	    	var="CTE";
	        finalDate=today40;
	        finalDateStr=40;
	        catVar=" and indCategoryName ='RED'";
	        certiFor="certificateFor ='reNew'";
	      //  cate="RED"
	        
	    	
	    }else if (applicationType=='cte' && category=='orange' && certificateFor=='renew')
	    {
	    	println("Orange reNew")
	    	var="CTE";
	        finalDate=today28;
	        finalDateStr=28;
	        catVar=" and indCategoryName ='ORANGE'";
	        certiFor="certificateFor ='reNew'";
	      //  cate="ORANGE"
	    	
	    }else if (applicationType=='cte' && category=='green' && certificateFor=='renew')
	    {
	    	println("Green reNew")
	    	var="CTE";
	        finalDate=today20;
	        finalDateStr=20
	        catVar=" and indCategoryName ='GREEN'";
	        certiFor="certificateFor ='reNew'";
	     //   cate="GREEN"
	    	
	    }
	    else if(applicationType=='hwm')
	    {
	    
	    	var="HWM";
	    	finalDate=today120;
	    }
	    else if(applicationType=='bmw')
	    {
	    
	    	var="BMW";
	    	finalDate=today120;
	    }else if(applicationType=='pwm')
	    {
	    	var="PWM";
	    	finalDate=today120;
	    }
	    else if(applicationType=='msw')
	    {
	    	var="MSW";
	    	finalDate=today120;
	    }
	    else if(applicationType=='ewaste')
	    {
	    	var="EWaste";
	    	finalDate=today120;
	    }else{
	    	println("helllooo")
	    }
	   
	    
	    ArrayList outer = new ArrayList()
	    ArrayList inner
	    println("certiFor--- "+certiFor)
	   // println("certiForR--- "+certiForR)
	    println("cate--- "+cate)
	    
	   
	    if(var=='HWM'){
	    	if (forApplication.equals("1")) {
	        	 def ctoReceivedApplication =  AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                     ""+query1+" and authDate >=  ? and authDate <=  ? order by districtName asc" , [fromDate, toDate])
	                     println("query1 "+query1)
	                    for (int i = 0; i < ctoReceivedApplication.size(); i++) {
	                   inner = new ArrayList()
	                   def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoReceivedApplication[i].indRegMasterId))
	                   def groupIdA=(ctoReceivedApplication[i].groupId)
	                   def districtId=industryRegMaster.district.id
	                   def dealingGroup
	                   def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	                   inner.add(ctoReceivedApplication[i].applicationId.toString())
	                   inner.add(ctoReceivedApplication[i].applicationName)
	                   if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                   }else{
	                    inner.add("")
	                    inner.add("")
	                  }

	                 inner.add("HWM") //
	                 inner.add(df.format(ctoReceivedApplication[i].authDate))
	                 if (ctoReceivedApplication[i].applicationStatus.equals("pending")) {
	                    inner.add("")
	                 } else {
	                    inner.add(df.format(ctoReceivedApplication[i].pendingSince))
	                 }
	                inner.add(ctoReceivedApplication[i].applicationStatus)
	                inner.add("HWM")
	                inner.add(ctoReceivedApplication[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }
	         } else if (forApplication.equals("2")) {
	          
	               def ctoGrantedWithinTime =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                       ""+query1+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
	                       " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])

	              for (int i = 0; i < ctoGrantedWithinTime.size(); i++) {
	                 inner = new ArrayList()
	                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedWithinTime[i].indRegMasterId))
	                 def groupIdA=(ctoGrantedWithinTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                   {
	                   	dealingGroup=disList.group
	                  }
	                 inner.add(ctoGrantedWithinTime[i].applicationId.toString())
	                 inner.add(ctoGrantedWithinTime[i].applicationName)
	                 if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                 }else{
	                    inner.add("")
	                    inner.add("")
	                 }
	                 inner.add("HWM") //
	                 inner.add(df.format(ctoGrantedWithinTime[i].authDate))
	                 inner.add(df.format(ctoGrantedWithinTime[i].pendingSince))
	                 inner.add(ctoGrantedWithinTime[i].applicationStatus)
	                 inner.add("HWM")
	                 inner.add(ctoGrantedWithinTime[i].roleName)
	                 inner.add(dealingGroup)
	                 outer.add(inner)
	            }
	        } else if (forApplication.equals("3")) {
	            
	        	def ctoGrantedBeyondTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                    ""+query1+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
	                    "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	             
	            for (int i = 0; i < ctoGrantedBeyondTime.size(); i++) {
	                inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedBeyondTime[i].indRegMasterId))
	                 def groupIdA=(ctoGrantedBeyondTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	                inner.add(ctoGrantedBeyondTime[i].applicationId.toString())
	                inner.add(ctoGrantedBeyondTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	                inner.add("HWM") //
	                inner.add(df.format(ctoGrantedBeyondTime[i].authDate))
	                inner.add(df.format(ctoGrantedBeyondTime[i].pendingSince))
	                inner.add(ctoGrantedBeyondTime[i].applicationStatus)
	                inner.add("HWM")
	                inner.add(ctoGrantedBeyondTime[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }

	        } else if (forApplication.equals("4")) {
	           
	        	def ctoRejectedWithinTime =  AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                    ""+query1+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
	                    "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	                    
	              println("ctoRejectedWithinTime "+ctoRejectedWithinTime  )      
	           for (int i = 0; i < ctoRejectedWithinTime.size(); i++) {
	                inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedWithinTime[i].indRegMasterId))
	                 def groupIdA=(ctoRejectedWithinTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	                inner.add(ctoRejectedWithinTime[i].applicationId.toString())
	                inner.add(ctoRejectedWithinTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	                inner.add("HWM") //
	                inner.add(df.format(ctoRejectedWithinTime[i].authDate))
	                inner.add(df.format(ctoRejectedWithinTime[i].pendingSince))
	                inner.add(ctoRejectedWithinTime[i].applicationStatus)
	                inner.add("HWM")
	                inner.add(ctoRejectedWithinTime[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }
	        } else if (forApplication.equals("5")) {
	        	def ctoRejectedBeyondTime =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                    ""+query1+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
	                    "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	           
	            for (int i = 0; i < ctoRejectedBeyondTime.size(); i++) {
	                inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedBeyondTime[i].indRegMasterId))
	                def groupIdA=(ctoRejectedBeyondTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	                inner.add(ctoRejectedBeyondTime[i].applicationId.toString())
	                inner.add(ctoRejectedBeyondTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	                inner.add("HWM") //
	                inner.add(df.format(ctoRejectedBeyondTime[i].authDate))
	                inner.add(df.format(ctoRejectedBeyondTime[i].pendingSince))
	                inner.add(ctoRejectedBeyondTime[i].applicationStatus)
	                inner.add("HWM")
	                inner.add(ctoRejectedBeyondTime[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }

	        } else if (forApplication.equals("6")) {
	            
	        	def ctoPendingWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                    ""+query1+" and applicationStatus = 'pending' " +
	                    " and authDate >=  ? and authDate <=  ? and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate, today120, today])
	           
	             for (int i = 0; i < ctoPendingWithinTime.size(); i++) {
	              inner = new ArrayList()
	                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingWithinTime[i].indRegMasterId))
	                 def groupIdA=(ctoPendingWithinTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	              inner.add(ctoPendingWithinTime[i].applicationId.toString())
	              inner.add(ctoPendingWithinTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	              inner.add("HWM")
	              inner.add(df.format(ctoPendingWithinTime[i].authDate))
	              inner.add("")
	              inner.add(ctoPendingWithinTime[i].applicationStatus)
	              inner.add("HWM")
	              inner.add(ctoPendingWithinTime[i].roleName)
	              inner.add(dealingGroup)
	              outer.add(inner)
	       }

	      } else if (forApplication.equals("7")) {
	        def ctoPendingBeyondTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                    ""+query1+" and applicationStatus = 'pending' " +
                    " and authDate >=  ? and authDate <=  ? and authDate < ? order by districtName asc", [fromDate, toDate, today120])
	                   
	          for (int i = 0; i < ctoPendingBeyondTime.size(); i++) {
	            inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingBeyondTime[i].indRegMasterId))
	                def groupIdA=(ctoPendingBeyondTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	                inner.add(ctoPendingBeyondTime[i].applicationId.toString())
	                inner.add(ctoPendingBeyondTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	            inner.add("HWM") //
	            inner.add(df.format(ctoPendingBeyondTime[i].authDate))
	            inner.add("")
	            inner.add(ctoPendingBeyondTime[i].applicationStatus)
	            inner.add("HWM")
	            inner.add(ctoPendingBeyondTime[i].roleName)
	            inner.add(dealingGroup)
	            outer.add(inner)
	      }

	    }
	    } else if (var=='BMW'){
	    	if (forApplication.equals("1")) {
	          
	      	def ctoReceivedApplication = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                  ""+query2+" and authDate >=  ? and authDate <=  ? order by districtName asc" , [fromDate, toDate])
	           
	                 for (int i = 0; i < ctoReceivedApplication.size(); i++) {
	                 inner = new ArrayList()
	                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoReceivedApplication[i].indRegMasterId))
	                 def groupIdA=(ctoReceivedApplication[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	                inner.add(ctoReceivedApplication[i].applicationId.toString())
	                 inner.add(ctoReceivedApplication[i].applicationName)
	                 if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	                 }else{
	                  inner.add("")
	                  inner.add("")
	                }

	               inner.add("BMW") //
	               inner.add(df.format(ctoReceivedApplication[i].authDate))
	               if (ctoReceivedApplication[i].applicationStatus.equals("pending")) {
	                  inner.add("")
	               } else {
	                  inner.add(df.format(ctoReceivedApplication[i].pendingSince))
	               }
	              inner.add(ctoReceivedApplication[i].applicationStatus)
	              inner.add("BMW")
	              inner.add(ctoReceivedApplication[i].roleName)
	              inner.add(dealingGroup)
	              outer.add(inner)
	          }
	       } else if (forApplication.equals("2")) {
	        
	             def ctoGrantedWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                     ""+query2+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
	                     " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])

	            for (int i = 0; i < ctoGrantedWithinTime.size(); i++) {
	               inner = new ArrayList()
	               def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedWithinTime[i].indRegMasterId))
	               def groupIdA=(ctoGrantedWithinTime[i].groupId)
	               def districtId=industryRegMaster.district.id
	               def dealingGroup
	               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	               if(disList)
	                 {
	                 	dealingGroup=disList.group
	                }
	               inner.add(ctoGrantedWithinTime[i].applicationId.toString())
	               inner.add(ctoGrantedWithinTime[i].applicationName)
	               if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	               }else{
	                  inner.add("")
	                  inner.add("")
	               }
	               inner.add("BMW") //
	               inner.add(df.format(ctoGrantedWithinTime[i].authDate))
	               inner.add(df.format(ctoGrantedWithinTime[i].pendingSince))
	               inner.add(ctoGrantedWithinTime[i].applicationStatus)
	               inner.add("BMW")
	               inner.add(ctoGrantedWithinTime[i].roleName)
	               inner.add(dealingGroup)
	               outer.add(inner)
	          }
	      } else if (forApplication.equals("3")) {
	          
	      	def ctoGrantedBeyondTime =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                  ""+query2+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
	                  "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	           
	          for (int i = 0; i < ctoGrantedBeyondTime.size(); i++) {
	              inner = new ArrayList()
	              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedBeyondTime[i].indRegMasterId))
	               def groupIdA=(ctoGrantedBeyondTime[i].groupId)
	               def districtId=industryRegMaster.district.id
	               def dealingGroup
	               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	              inner.add(ctoGrantedBeyondTime[i].applicationId.toString())
	              inner.add(ctoGrantedBeyondTime[i].applicationName)
	              if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	              }else{
	                  inner.add("")
	                  inner.add("")
	              }
	              inner.add("BMW") //
	              inner.add(df.format(ctoGrantedBeyondTime[i].authDate))
	              inner.add(df.format(ctoGrantedBeyondTime[i].pendingSince))
	              inner.add(ctoGrantedBeyondTime[i].applicationStatus)
	              inner.add("BMW")
	              inner.add(ctoGrantedBeyondTime[i].roleName)
	              inner.add(dealingGroup)
	              outer.add(inner)
	          }

	      } else if (forApplication.equals("4")) {
	         
	      	def ctoRejectedWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                  ""+query2+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
	                  "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	                 
	         for (int i = 0; i < ctoRejectedWithinTime.size(); i++) {
	              inner = new ArrayList()
	              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedWithinTime[i].indRegMasterId))
	               def groupIdA=(ctoRejectedWithinTime[i].groupId)
	               def districtId=industryRegMaster.district.id
	               def dealingGroup
	               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	              inner.add(ctoRejectedWithinTime[i].applicationId.toString())
	              inner.add(ctoRejectedWithinTime[i].applicationName)
	              if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	              }else{
	                  inner.add("")
	                  inner.add("")
	              }
	              inner.add("BMW") //
	              inner.add(df.format(ctoRejectedWithinTime[i].authDate))
	              inner.add(df.format(ctoRejectedWithinTime[i].pendingSince))
	              inner.add(ctoRejectedWithinTime[i].applicationStatus)
	              inner.add("BMW")
	              inner.add(ctoRejectedWithinTime[i].roleName)
	              inner.add(dealingGroup)
	              outer.add(inner)
	          }
	      } else if (forApplication.equals("5")) {
	      	def ctoRejectedBeyondTime =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                  ""+query2+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
	                  "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	                  
	         
	          for (int i = 0; i < ctoRejectedBeyondTime.size(); i++) {
	              inner = new ArrayList()
	              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedBeyondTime[i].indRegMasterId))
	              def groupIdA=(ctoRejectedBeyondTime[i].groupId)
	               def districtId=industryRegMaster.district.id
	               def dealingGroup
	               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	              inner.add(ctoRejectedBeyondTime[i].applicationId.toString())
	              inner.add(ctoRejectedBeyondTime[i].applicationName)
	              if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	              }else{
	                  inner.add("")
	                  inner.add("")
	              }
	              inner.add("BMW") //
	              inner.add(df.format(ctoRejectedBeyondTime[i].authDate))
	              inner.add(df.format(ctoRejectedBeyondTime[i].pendingSince))
	              inner.add(ctoRejectedBeyondTime[i].applicationStatus)
	              inner.add("BMW")
	              inner.add(ctoRejectedBeyondTime[i].roleName)
	              inner.add(dealingGroup)
	              outer.add(inner)
	          }

	      } else if (forApplication.equals("6")) {
	          
	      	def ctoPendingWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
	                  ""+query2+" and applicationStatus = 'pending' and pendingSince - authDate <= '120 days' " +
	                  "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	         
	           for (int i = 0; i < ctoPendingWithinTime.size(); i++) {
	            inner = new ArrayList()
	               def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingWithinTime[i].indRegMasterId))
	               def groupIdA=(ctoPendingWithinTime[i].groupId)
	               def districtId=industryRegMaster.district.id
	               def dealingGroup
	               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	            inner.add(ctoPendingWithinTime[i].applicationId.toString())
	            inner.add(ctoPendingWithinTime[i].applicationName)
	              if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	              }else{
	                  inner.add("")
	                  inner.add("")
	              }
	            inner.add("BMW")
	            inner.add(df.format(ctoPendingWithinTime[i].authDate))
	            inner.add("")
	            inner.add(ctoPendingWithinTime[i].applicationStatus)
	            inner.add("BMW")
	            inner.add(ctoPendingWithinTime[i].roleName)
	            inner.add(dealingGroup)
	            outer.add(inner)
	     }

	    } else if (forApplication.equals("7")) {
	  	 def ctoPendingBeyondTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                 ""+query2+" and applicationStatus = 'pending' and pendingSince - authDate > '120 days' " +
                 "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
	         
	        for (int i = 0; i < ctoPendingBeyondTime.size(); i++) {
	          inner = new ArrayList()
	              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingBeyondTime[i].indRegMasterId))
	              def groupIdA=(ctoPendingBeyondTime[i].groupId)
	               def districtId=industryRegMaster.district.id
	               def dealingGroup
	               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	              inner.add(ctoPendingBeyondTime[i].applicationId.toString())
	              inner.add(ctoPendingBeyondTime[i].applicationName)
	              if(industryRegMaster){
	                  inner.add(industryRegMaster.district.districtName)
	                  inner.add(industryRegMaster.occName)
	              }else{
	                  inner.add("")
	                  inner.add("")
	              }
	          inner.add("BMW") //
	          inner.add(df.format(ctoPendingBeyondTime[i].authDate))
	          inner.add("")
	          inner.add(ctoPendingBeyondTime[i].applicationStatus)
	          inner.add("BMW")
	          inner.add(ctoPendingBeyondTime[i].roleName)
	          inner.add(dealingGroup)
	          outer.add(inner)
	    }

	  }
	  }else if(var=='PWM'){
	    	
    	  if (forApplication.equals("1")) {
        	 def ctoReceivedApplication =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                     ""+query3+" and authDate >=  ? and authDate <=  ? order by districtName asc" , [fromDate, toDate])
                    for (int i = 0; i < ctoReceivedApplication.size(); i++) {
                   inner = new ArrayList()
                   def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoReceivedApplication[i].indRegMasterId))
                   def groupIdA=(ctoReceivedApplication[i].groupId)
                   def districtId=industryRegMaster.district.id
                   def dealingGroup
                   def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                   if(disList)
                   {
                   	dealingGroup=disList.group
                   }
                   
                   
                   
                   inner.add(ctoReceivedApplication[i].applicationId.toString())
                   inner.add(ctoReceivedApplication[i].applicationName)
                   if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                   }else{
                    inner.add("")
                    inner.add("")
                  }

                 inner.add("PWM") //
                 inner.add(df.format(ctoReceivedApplication[i].authDate))
                 if (ctoReceivedApplication[i].applicationStatus.equals("pending")) {
                    inner.add("")
                 } else {
                    inner.add(df.format(ctoReceivedApplication[i].pendingSince))
                 }
                inner.add(ctoReceivedApplication[i].applicationStatus)
                inner.add("PWM")
                inner.add(ctoReceivedApplication[i].roleName)
                inner.add(dealingGroup)
                outer.add(inner)
            }
         } else if (forApplication.equals("2")) {          
               def ctoGrantedWithinTime =  AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                       ""+query3+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
                       " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])

              for (int i = 0; i < ctoGrantedWithinTime.size(); i++) {
                 inner = new ArrayList()
                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedWithinTime[i].indRegMasterId))
                 def groupIdA=(ctoGrantedWithinTime[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                   {
                   	dealingGroup=disList.group
                  }
                 
                 
                 inner.add(ctoGrantedWithinTime[i].applicationId.toString())
                 inner.add(ctoGrantedWithinTime[i].applicationName)
                 if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                 }else{
                    inner.add("")
                    inner.add("")
                 }
                 inner.add("PWM") //
                 inner.add(df.format(ctoGrantedWithinTime[i].authDate))
                 inner.add(df.format(ctoGrantedWithinTime[i].pendingSince))
                 inner.add(ctoGrantedWithinTime[i].applicationStatus)
                 inner.add("PWM")
                 inner.add(ctoGrantedWithinTime[i].roleName)
                 inner.add(dealingGroup)
                 outer.add(inner)
            }
        } else if (forApplication.equals("3")) {
            
        	def ctoGrantedBeyondTime =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                    ""+query3+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
                    "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
             
            for (int i = 0; i < ctoGrantedBeyondTime.size(); i++) {
                inner = new ArrayList()
                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedBeyondTime[i].indRegMasterId))
                 def groupIdA=(ctoGrantedBeyondTime[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                   if(disList)
                   {
                   	dealingGroup=disList.group
                   }
                
                
                inner.add(ctoGrantedBeyondTime[i].applicationId.toString())
                inner.add(ctoGrantedBeyondTime[i].applicationName)
                if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                }else{
                    inner.add("")
                    inner.add("")
                }
                inner.add("PWM") //
                inner.add(df.format(ctoGrantedBeyondTime[i].authDate))
                inner.add(df.format(ctoGrantedBeyondTime[i].pendingSince))
                inner.add(ctoGrantedBeyondTime[i].applicationStatus)
                inner.add("PWM")
                inner.add(ctoGrantedBeyondTime[i].roleName)
                inner.add(dealingGroup)
                outer.add(inner)
            }

        } else if (forApplication.equals("4")) {
           
        	def ctoRejectedWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                    ""+query3+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
                    "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
                    
              println("ctoRejectedWithinTime "+ctoRejectedWithinTime  )      
           for (int i = 0; i < ctoRejectedWithinTime.size(); i++) {
                inner = new ArrayList()
                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedWithinTime[i].indRegMasterId))
                 def groupIdA=(ctoRejectedWithinTime[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                   if(disList)
                   {
                   	dealingGroup=disList.group
                   }
                inner.add(ctoRejectedWithinTime[i].applicationId.toString())
                inner.add(ctoRejectedWithinTime[i].applicationName)
                if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                }else{
                    inner.add("")
                    inner.add("")
                }
                inner.add("PWM") //
                inner.add(df.format(ctoRejectedWithinTime[i].authDate))
                inner.add(df.format(ctoRejectedWithinTime[i].pendingSince))
                inner.add(ctoRejectedWithinTime[i].applicationStatus)
                inner.add("PWM")
                inner.add(ctoRejectedWithinTime[i].roleName)
                inner.add(dealingGroup)
                outer.add(inner)
            }
        } else if (forApplication.equals("5")) {
            
        	
        	def ctoRejectedBeyondTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                    ""+query3+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
                    "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
                    
           
            for (int i = 0; i < ctoRejectedBeyondTime.size(); i++) {
                inner = new ArrayList()
                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedBeyondTime[i].indRegMasterId))
                def groupIdA=(ctoRejectedBeyondTime[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                   if(disList)
                   {
                   	dealingGroup=disList.group
                   }
                inner.add(ctoRejectedBeyondTime[i].applicationId.toString())
                inner.add(ctoRejectedBeyondTime[i].applicationName)
                if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                }else{
                    inner.add("")
                    inner.add("")
                }
                inner.add("PWM") //
                inner.add(df.format(ctoRejectedBeyondTime[i].authDate))
                inner.add(df.format(ctoRejectedBeyondTime[i].pendingSince))
                inner.add(ctoRejectedBeyondTime[i].applicationStatus)
                inner.add("PWM")
                inner.add(ctoRejectedBeyondTime[i].roleName)
                inner.add(dealingGroup)
                outer.add(inner)
            }

        } else if (forApplication.equals("6")) {
            
          def ctoPendingWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                  ""+query3+" and applicationStatus = 'pending' and pendingSince - authDate <= '120 days' " +
                  "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
           
             for (int i = 0; i < ctoPendingWithinTime.size(); i++) {
              inner = new ArrayList()
                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingWithinTime[i].indRegMasterId))
                 def groupIdA=(ctoPendingWithinTime[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                   if(disList)
                   {
                   	dealingGroup=disList.group
                   }
              inner.add(ctoPendingWithinTime[i].applicationId.toString())
              inner.add(ctoPendingWithinTime[i].applicationName)
                if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                }else{
                    inner.add("")
                    inner.add("")
                }
              inner.add("PWM")
              inner.add(df.format(ctoPendingWithinTime[i].authDate))
              inner.add("")
              inner.add(ctoPendingWithinTime[i].applicationStatus)
              inner.add("PWM")
              inner.add(ctoPendingWithinTime[i].roleName)
              inner.add(dealingGroup)
              outer.add(inner)
       }

      } else if (forApplication.equals("7")) {
         def ctoPendingBeyondTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                 ""+query3+" and applicationStatus = 'pending' and pendingSince - authDate > '120 days' " +
                 "and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
                   
          for (int i = 0; i < ctoPendingBeyondTime.size(); i++) {
            inner = new ArrayList()
                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingBeyondTime[i].indRegMasterId))
                def groupIdA=(ctoPendingBeyondTime[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                   if(disList)
                   {
                   	dealingGroup=disList.group
                   }
                inner.add(ctoPendingBeyondTime[i].applicationId.toString())
                inner.add(ctoPendingBeyondTime[i].applicationName)
                if(industryRegMaster){
                    inner.add(industryRegMaster.district.districtName)
                    inner.add(industryRegMaster.occName)
                }else{
                    inner.add("")
                    inner.add("")
                }
            inner.add("PWM") //
            inner.add(df.format(ctoPendingBeyondTime[i].authDate))
            inner.add("")
            inner.add(ctoPendingBeyondTime[i].applicationStatus)
            inner.add("PWM")
            inner.add(ctoPendingBeyondTime[i].roleName)
            inner.add(dealingGroup)
            outer.add(inner)
      }

    }
    }else if(var=='MSW'){
    	println("Deepak--")
    	
  	  if (forApplication.equals("1")) {
      	 def ctoReceivedApplication =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                 ""+query4+" and authDate >=  ? and authDate <=  ? order by districtName asc" , [fromDate, toDate])
                  for (int i = 0; i < ctoReceivedApplication.size(); i++) {
                 inner = new ArrayList()
                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoReceivedApplication[i].indRegMasterId))
                 def groupIdA=(ctoReceivedApplication[i].groupId)
                 def districtId=industryRegMaster.district.id
                 def dealingGroup
                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                 {
                 	dealingGroup=disList.group
                 }
                 
                 
                 
                 inner.add(ctoReceivedApplication[i].applicationId.toString())
                 inner.add(ctoReceivedApplication[i].applicationName)
                 if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
                 }else{
                  inner.add("")
                  inner.add("")
                }

               inner.add("MSW") //
               inner.add(df.format(ctoReceivedApplication[i].authDate))
               if (ctoReceivedApplication[i].applicationStatus.equals("pending")) {
                  inner.add("")
               } else {
                  inner.add(df.format(ctoReceivedApplication[i].pendingSince))
               }
              inner.add(ctoReceivedApplication[i].applicationStatus)
              inner.add("MSW")
              inner.add(ctoReceivedApplication[i].roleName)
              inner.add(dealingGroup)
              outer.add(inner)
          }
       } else if (forApplication.equals("2")) {
             def ctoGrantedWithinTime =  AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                     ""+query4+" and applicationStatus = 'approved' and pendingSince - authDate <= '120 days' " +
                     " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])

            for (int i = 0; i < ctoGrantedWithinTime.size(); i++) {
               inner = new ArrayList()
               def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedWithinTime[i].indRegMasterId))
               def groupIdA=(ctoGrantedWithinTime[i].groupId)
               def districtId=industryRegMaster.district.id
               def dealingGroup
               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
               if(disList)
                 {
                 	dealingGroup=disList.group
                }
               
               
               inner.add(ctoGrantedWithinTime[i].applicationId.toString())
               inner.add(ctoGrantedWithinTime[i].applicationName)
               if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
               }else{
                  inner.add("")
                  inner.add("")
               }
               inner.add("MSW") //
               inner.add(df.format(ctoGrantedWithinTime[i].authDate))
               inner.add(df.format(ctoGrantedWithinTime[i].pendingSince))
               inner.add(ctoGrantedWithinTime[i].applicationStatus)
               inner.add("MSW")
               inner.add(ctoGrantedWithinTime[i].roleName)
               inner.add(dealingGroup)
               outer.add(inner)
          }
      } else if (forApplication.equals("3")) {
          
      	def ctoGrantedBeyondTime =AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                ""+query4+" and applicationStatus = 'approved' and pendingSince - authDate > '120 days' " +
                " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
           
          for (int i = 0; i < ctoGrantedBeyondTime.size(); i++) {
              inner = new ArrayList()
              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedBeyondTime[i].indRegMasterId))
               def groupIdA=(ctoGrantedBeyondTime[i].groupId)
               def districtId=industryRegMaster.district.id
               def dealingGroup
               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                 {
                 	dealingGroup=disList.group
                 }
              
              
              inner.add(ctoGrantedBeyondTime[i].applicationId.toString())
              inner.add(ctoGrantedBeyondTime[i].applicationName)
              if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
              }else{
                  inner.add("")
                  inner.add("")
              }
              inner.add("MSW") //
              inner.add(df.format(ctoGrantedBeyondTime[i].authDate))
              inner.add(df.format(ctoGrantedBeyondTime[i].pendingSince))
              inner.add(ctoGrantedBeyondTime[i].applicationStatus)
              inner.add("MSW")
              inner.add(ctoGrantedBeyondTime[i].roleName)
              inner.add(dealingGroup)
              outer.add(inner)
          }

      } else if (forApplication.equals("4")) {
      	def ctoRejectedWithinTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                ""+query4+" and applicationStatus = 'rejected' and pendingSince - authDate <= '120 days' " +
                " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
                  
            println("ctoRejectedWithinTime "+ctoRejectedWithinTime  )      
         for (int i = 0; i < ctoRejectedWithinTime.size(); i++) {
              inner = new ArrayList()
              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedWithinTime[i].indRegMasterId))
               def groupIdA=(ctoRejectedWithinTime[i].groupId)
               def districtId=industryRegMaster.district.id
               def dealingGroup
               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                 {
                 	dealingGroup=disList.group
                 }
              inner.add(ctoRejectedWithinTime[i].applicationId.toString())
              inner.add(ctoRejectedWithinTime[i].applicationName)
              if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
              }else{
                  inner.add("")
                  inner.add("")
              }
              inner.add("MSW") //
              inner.add(df.format(ctoRejectedWithinTime[i].authDate))
              inner.add(df.format(ctoRejectedWithinTime[i].pendingSince))
              inner.add(ctoRejectedWithinTime[i].applicationStatus)
              inner.add("MSW")
              inner.add(ctoRejectedWithinTime[i].roleName)
              inner.add(dealingGroup)
              outer.add(inner)
          }
      } else if (forApplication.equals("5")) {
          
      	
      	def ctoRejectedBeyondTime = AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                ""+query4+" and applicationStatus = 'rejected' and pendingSince - authDate > '120 days' " +
                " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
                  
         
          for (int i = 0; i < ctoRejectedBeyondTime.size(); i++) {
              inner = new ArrayList()
              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedBeyondTime[i].indRegMasterId))
              def groupIdA=(ctoRejectedBeyondTime[i].groupId)
               def districtId=industryRegMaster.district.id
               def dealingGroup
               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                 {
                 	dealingGroup=disList.group
                 }
              inner.add(ctoRejectedBeyondTime[i].applicationId.toString())
              inner.add(ctoRejectedBeyondTime[i].applicationName)
              if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
              }else{
                  inner.add("")
                  inner.add("")
              }
              inner.add("MSW") //
              inner.add(df.format(ctoRejectedBeyondTime[i].authDate))
              inner.add(df.format(ctoRejectedBeyondTime[i].pendingSince))
              inner.add(ctoRejectedBeyondTime[i].applicationStatus)
              inner.add("MSW")
              inner.add(ctoRejectedBeyondTime[i].roleName)
              inner.add(dealingGroup)
              outer.add(inner)
          }

      } else if (forApplication.equals("6")) {
              def ctoPendingWithinTime =  AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
                      ""+query4+" and applicationStatus = 'pending' and pendingSince - authDate <= '120 days' " +
                      " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
         
           for (int i = 0; i < ctoPendingWithinTime.size(); i++) {
            inner = new ArrayList()
               def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingWithinTime[i].indRegMasterId))
               def groupIdA=(ctoPendingWithinTime[i].groupId)
               def districtId=industryRegMaster.district.id
               def dealingGroup
               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                 {
                 	dealingGroup=disList.group
                 }
            inner.add(ctoPendingWithinTime[i].applicationId.toString())
            inner.add(ctoPendingWithinTime[i].applicationName)
              if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
              }else{
                  inner.add("")
                  inner.add("")
              }
            inner.add("MSW")
            inner.add(df.format(ctoPendingWithinTime[i].authDate))
            inner.add("")
            inner.add(ctoPendingWithinTime[i].applicationStatus)
            inner.add("MSW")
            inner.add(ctoPendingWithinTime[i].roleName)
            inner.add(dealingGroup)
            outer.add(inner)
     }

    } else if (forApplication.equals("7")) {
        
  	  
  	 def ctoPendingBeyondTime =  AllSummaryReportWMS.findAll("from AllSummaryReportWMS where " +
             ""+query4+" and applicationStatus = 'pending' and pendingSince - authDate > '120 days' " +
             " and authDate >=  ? and authDate <=  ? order by districtName asc", [fromDate, toDate])
                 
        for (int i = 0; i < ctoPendingBeyondTime.size(); i++) {
          inner = new ArrayList()
              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingBeyondTime[i].indRegMasterId))
              def groupIdA=(ctoPendingBeyondTime[i].groupId)
               def districtId=industryRegMaster.district.id
               def dealingGroup
               def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
                 if(disList)
                 {
                 	dealingGroup=disList.group
                 }
              inner.add(ctoPendingBeyondTime[i].applicationId.toString())
              inner.add(ctoPendingBeyondTime[i].applicationName)
              if(industryRegMaster){
                  inner.add(industryRegMaster.district.districtName)
                  inner.add(industryRegMaster.occName)
              }else{
                  inner.add("")
                  inner.add("")
              }
          inner.add("MSW") //
          inner.add(df.format(ctoPendingBeyondTime[i].authDate))
          inner.add("")
          inner.add(ctoPendingBeyondTime[i].applicationStatus)
          inner.add("MSW")
          inner.add(ctoPendingBeyondTime[i].roleName)
          inner.add(dealingGroup)
          outer.add(inner)
    }

  }
  } 
	   else
	    {
	    	println("CCCCCCCCC---");
	        if (forApplication.equals("1")) {
	            
	        	println("BBBBBBBBBB---");
	        	
	        	def ctoReceivedApplication = AllSummaryReport.findAll("from AllSummaryReport where " +
	                    "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+ 
	                    " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	                    println("NUMBER 1111");
	              for (int i = 0; i < ctoReceivedApplication.size(); i++) {
	                   inner = new ArrayList()
	                   def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoReceivedApplication[i].indRegMasterId))
	                   def groupIdA=(ctoReceivedApplication[i].groupId)
	                   def districtId=industryRegMaster.district.id
	                   def dealingGroup
	                   def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
	                   if(disList)
	                   {
	                   	dealingGroup=disList.group
	                   }
	                   
	                   inner.add(ctoReceivedApplication[i].applicationId.toString())
	                   inner.add(ctoReceivedApplication[i].applicationName)
	                   if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                    
	                   }else{
	                    inner.add("")
	                    inner.add("")
	                  }

	                 inner.add(ctoReceivedApplication[i].applicationType) //
	                 inner.add(df.format(ctoReceivedApplication[i].applicationRecieptDate))
	                 
	                 if (ctoReceivedApplication[i].applicationStatus.equals("pending")) {
	                    inner.add("")
	                 } else {
	                    inner.add(df.format(ctoReceivedApplication[i].pendingSince))
	                 }
	                inner.add(ctoReceivedApplication[i].applicationStatus)
	                inner.add(ctoReceivedApplication[i].indCategoryName)
	                inner.add(ctoReceivedApplication[i].roleName)
	                inner.add(dealingGroup) //
	                outer.add(inner)
	            }
	         } else if (forApplication.equals("2")) {
	           def ctoGrantedWithinTime = AllSummaryReport.findAll("from AllSummaryReport where " +
	                   "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+" and applicationStatus = 'approved' and pendingSince - applicationRecieptDate <= '120 days'"+
	                   " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	                   	 println("NUMBER 2222");
	              for (int i = 0; i < ctoGrantedWithinTime.size(); i++) {
	                 inner = new ArrayList()
	                 def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedWithinTime[i].indRegMasterId))
	                 def groupIdB=(ctoGrantedWithinTime[i].groupId)
	                 def districtId=industryRegMaster.district.id
	                 def dealingGroup
	                 def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdB).toLong()])
	                 if(disList)
	                 {
	                 	dealingGroup=disList.group
	                 }
	                 
	                 inner.add(ctoGrantedWithinTime[i].applicationId.toString())
	                 inner.add(ctoGrantedWithinTime[i].applicationName)
	                 if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                 }else{
	                    inner.add("")
	                    inner.add("")
	                 }
	                 inner.add(ctoGrantedWithinTime[i].applicationType)
	                 inner.add(df.format(ctoGrantedWithinTime[i].applicationRecieptDate))
	                 inner.add(df.format(ctoGrantedWithinTime[i].pendingSince))
	                 inner.add(ctoGrantedWithinTime[i].applicationStatus)
	                 inner.add(ctoGrantedWithinTime[i].indCategoryName)
	                 inner.add(ctoGrantedWithinTime[i].roleName)
	                 inner.add(dealingGroup)
	                 outer.add(inner)
	            }
	        } else if (forApplication.equals("3")) {
	            
	        	def ctoGrantedBeyondTime =  AllSummaryReport.findAll("from AllSummaryReport where " +
		                   "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+" and applicationStatus = 'approved' and pendingSince - applicationRecieptDate > '120 days'"+
		                   " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	              println("NUMBER 3333");
	            for (int i = 0; i < ctoGrantedBeyondTime.size(); i++) {
	                inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoGrantedBeyondTime[i].indRegMasterId))
	                def groupIdB=(ctoGrantedBeyondTime[i].groupId)
	                def districtId=industryRegMaster.district.id
	                def dealingGroup
	                def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdB).toLong()])
	                if(disList)
	                {
	                	dealingGroup=disList.group
	                }
	                
	                inner.add(ctoGrantedBeyondTime[i].applicationId.toString())
	                inner.add(ctoGrantedBeyondTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	                inner.add(ctoGrantedBeyondTime[i].applicationType)
	                inner.add(df.format(ctoGrantedBeyondTime[i].applicationRecieptDate))
	                inner.add(df.format(ctoGrantedBeyondTime[i].pendingSince))
	                inner.add(ctoGrantedBeyondTime[i].applicationStatus)
	                inner.add(ctoGrantedBeyondTime[i].indCategoryName)
	                inner.add(ctoGrantedBeyondTime[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }

	        } else if (forApplication.equals("4")) {
	            def ctoRejectedWithinTime =  AllSummaryReport.findAll("from AllSummaryReport where " +
		                   "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+" and applicationStatus = 'rejected' and pendingSince - applicationRecieptDate <= '120 days'"+
		                   " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	            println("NUMBER 4444");
		                   for (int i = 0; i < ctoRejectedWithinTime.size(); i++) {
	                inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedWithinTime[i].indRegMasterId))
	                def groupIdB=(ctoRejectedWithinTime[i].groupId)
	                def districtId=industryRegMaster.district.id
	                def dealingGroup
	                def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdB).toLong()])
	                if(disList)
	                {
	                	dealingGroup=disList.group
	                }
	                
	                inner.add(ctoRejectedWithinTime[i].applicationId.toString())
	                inner.add(ctoRejectedWithinTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	                inner.add(ctoRejectedWithinTime[i].applicationType)
	                inner.add(df.format(ctoRejectedWithinTime[i].applicationRecieptDate))
	                inner.add(df.format(ctoRejectedWithinTime[i].pendingSince))
	                inner.add(ctoRejectedWithinTime[i].applicationStatus)
	                inner.add(ctoRejectedWithinTime[i].indCategoryName)
	                inner.add(ctoRejectedWithinTime[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }
	        } else if (forApplication.equals("5")) {
	            def ctoRejectedBeyondTime =  AllSummaryReport.findAll("from AllSummaryReport where " +
		                   "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+" and applicationStatus = 'rejected' and pendingSince - applicationRecieptDate > '120 days'"+
		                   " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	            println("NUMBER 5555");
	            println("var " +var);
	            println("catVar " +catVar);
	            println("query " +query);
	            println("certiFor " +certiFor);
	            
		                   for (int i = 0; i < ctoRejectedBeyondTime.size(); i++) {
	                inner = new ArrayList()
	                def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoRejectedBeyondTime[i].indRegMasterId))
	                def groupIdB=(ctoRejectedBeyondTime[i].groupId)
	                def districtId=industryRegMaster.district.id
	                def dealingGroup
	                def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdB).toLong()])
	                if(disList)
	                {
	                	dealingGroup=disList.group
	                }
	                
	                inner.add(ctoRejectedBeyondTime[i].applicationId.toString())
	                inner.add(ctoRejectedBeyondTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	                inner.add(ctoRejectedBeyondTime[i].applicationType)
	                inner.add(df.format(ctoRejectedBeyondTime[i].applicationRecieptDate))
	                inner.add(df.format(ctoRejectedBeyondTime[i].pendingSince))
	                inner.add(ctoRejectedBeyondTime[i].applicationStatus)
	                inner.add(ctoRejectedBeyondTime[i].indCategoryName)
	                inner.add(ctoRejectedBeyondTime[i].roleName)
	                inner.add(dealingGroup)
	                outer.add(inner)
	            }

	        } else if (forApplication.equals("6")) {
	              def ctoPendingWithinTime =  AllSummaryReport.findAll("from AllSummaryReport where " +
		                   "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+" and applicationStatus = 'pending' and pendingSince - applicationRecieptDate <= '120 days'"+
		                   " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	                 println("NUMBER 6666");    
	              for (int i = 0; i < ctoPendingWithinTime.size(); i++) {
	              inner = new ArrayList()
	              def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingWithinTime[i].indRegMasterId))
	              def groupIdB=(ctoPendingWithinTime[i].groupId)
	              def districtId=industryRegMaster.district.id
	              def dealingGroup
	              def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdB).toLong()])
	              if(disList)
	              {
	              	dealingGroup=disList.group
	              }
	              
	              inner.add(ctoPendingWithinTime[i].applicationId.toString())
	              inner.add(ctoPendingWithinTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	              inner.add(ctoPendingWithinTime[i].applicationType)
	              inner.add(df.format(ctoPendingWithinTime[i].applicationRecieptDate))
	              inner.add("")
	              inner.add(ctoPendingWithinTime[i].applicationStatus)
	              inner.add(ctoPendingWithinTime[i].indCategoryName)
	              inner.add(ctoPendingWithinTime[i].roleName)
	              inner.add(dealingGroup)
	              outer.add(inner)
	       }

	      } else if (forApplication.equals("7")) {
	          
	    	    def ctoPendingBeyondTime =  AllSummaryReport.findAll("from AllSummaryReport where " +
		                   "applicationType = '"+var+"' "+catVar+" and "+query+" and "+certiFor+" and applicationStatus = 'pending' and pendingSince - applicationRecieptDate > '120 days'"+
		                   " and applicationRecieptDate >=  ? and applicationRecieptDate <=  ? order by districtName asc", [fromDate, toDate])
	            println("NUMBER 7777");
	             //println("ctoPendingBeyondTime---"+ctoPendingBeyondTime);
	          
	            for (int i = 0; i < ctoPendingBeyondTime.size(); i++) {
	            inner = new ArrayList()
	            def groupIdB=(ctoPendingBeyondTime[i].groupId)
	            def industryRegMaster = IndustryRegMaster.get(Long.parseLong(ctoPendingBeyondTime[i].indRegMasterId))
	            def districtId=industryRegMaster.district.id
	            def dealingGroup
	            def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdB).toLong()])
	            if(disList)
	            {
	            	dealingGroup=disList.group
	            }
	           
	                inner.add(ctoPendingBeyondTime[i].applicationId.toString())
	                inner.add(ctoPendingBeyondTime[i].applicationName)
	                if(industryRegMaster){
	                    inner.add(industryRegMaster.district.districtName)
	                    inner.add(industryRegMaster.occName)
	                }else{
	                    inner.add("")
	                    inner.add("")
	                }
	            inner.add(ctoPendingBeyondTime[i].applicationType)
	            inner.add(df.format(ctoPendingBeyondTime[i].applicationRecieptDate))
	            inner.add("")
	            inner.add(ctoPendingBeyondTime[i].applicationStatus);
	            inner.add(ctoPendingBeyondTime[i].indCategoryName)
	            inner.add(ctoPendingBeyondTime[i].roleName)
	            inner.add(dealingGroup)
	            outer.add(inner)
	     }

	    }
	    	
	    }
	    
	    println("AAA----"+params.cat);
	    if(params.isPrint){
	    	println("AAAAAAAA---")
	        render(view: "popApplicationCountAllModuleCtoPrint", model:
	        	 [outer: outer, flashMessage: params.flashMessage,type:params.type,cat:params.cat,number:params.number,fromDate: params.fromDateStr, toDate: params.toDateStr,groupId:params.groupId]
	        )

	    }else{
	         [outer: outer, flashMessage: params.flashMessage,type:params.type,cat:params.cat,number:params.number, fromDate: params.fromDateStr, toDate: params.toDateStr,groupId:params.groupId]

	    }
	}
	
	//  REMAINING DASHBOARD CODE IS STARTED ADDED BY DEEPAK KUMAR




						def popApplicationCountAllModuleCto8 = {
						
						println("testing inside popApplicationCountAllModuleCto8   "+params)
						def groupId=params.groupId;
						def applicationType=params.type;
						def category=params.cat;
						def forApplication=	params.number;
						def certificateFor = params.certificate
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						def simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						String fromDateStr = params.fromDateStr
						String toDateStr = params.toDateStr
						def fromDate = simpleDateFormat.parse(fromDateStr)
						def toDate = simpleDateFormat.parse(toDateStr)
						WorkingDays workingDays=new WorkingDays();
						Date today = new Date()
						def day730=workingDays.calDueDate(today,730);
						Date date730 = formatter.parse(day730)
						Calendar cal112 = new GregorianCalendar();
						cal112.setTime(date730)
						Date today730 = cal112.getTime();
						
						
						println("certificateFor---"+certificateFor);
						println("applicationType---"+applicationType);
						println("category---"+category);
						println("forApplication---"+forApplication);
						def var;
						def catVar;
						def certiFor;
						def certiForR;
						def cate;
						
						String query5="";
						if(groupId=="All")
						{
						//	 query="singleWindow='false' and applicationStatus !='returned'";
						// query="applicationStatus !='returned'";
						//	 query1="applicationFor = 'HWM' and applicationStatus !='returned'"; 
						//	 query3="applicationFor = 'BMW' and applicationStatus !='returned'";
						//query1="applicationStatus !='returned'"; 
						//query2="applicationStatus !='returned'";
						// query3="applicationStatus !='returned'";
						// query4="applicationStatus !='returned'";
						query5="applicationFor = 'EWaste' and applicationStatus !='returned'";
						}else
						{
						//	query="singleWindow='false' and applicationStatus !='returned' and groupId ='"+groupId+"'";
						//	query="applicationStatus !='returned' and groupId ='"+groupId+"'";
						//query1="applicationFor = 'HWM' and applicationStatus !='returned' and groupId ='"+groupId+"'"; 
						//query2="applicationFor = 'BMW' and applicationStatus !='returned' and groupId ='"+groupId+"'";
						//query3="applicationFor = 'PWM' and applicationStatus !='returned' and groupId ='"+groupId+"'";
						//query4="applicationFor = 'MSW' and applicationStatus !='returned' and groupId ='"+groupId+"'";
						query5="applicationFor = 'EWaste' and applicationStatus !='returned' and role.group.id ='"+groupId+"'";
						//	query3="applicationStatus !='returned' and groupId ='"+groupId+"'"; 
						//	query2="applicationStatus !='returned' and groupId ='"+groupId+"'";
						}
						ArrayList outer = new ArrayList()
						ArrayList inner
						
						if (applicationType=='cte' && category=='green' && certificateFor=='new')
						{
						println("Green New")
						var="CTE";
						
						catVar=" and indCategoryName ='GREEN'";
						certiFor="NEW"
						cate="GREENA"
						
						}else  if (applicationType=='cte' && category=='red' && certificateFor=='renew')
						{
						println("1111")
						var="CTE";
						
						catVar=" and indCategoryName ='RED'";
						certiFor="NEW"
						cate="RED"
						
						
						}else if (applicationType=='cte' && category=='orange' && certificateFor=='renew')
						{
						println("Orange New")
						var="CTE";
						
						catVar=" and indCategoryName ='ORANGE'";
						certiFor="NEW"
						cate="ORANGE"
						
						}else if (applicationType=='cte' && category=='green' && certificateFor=='renew')
						{
						println("Green New")
						var="CTE";
						
						catVar=" and indCategoryName ='GREEN'";
						certiFor="NEW"
						cate="GREEN"
						
						}else  if (applicationType=='cto' && category=='red' && certificateFor=='new')
						{
						println("11111111")
						var="CTE";
						
						catVar=" and indCategoryName ='RED'";
						certiFor="NEW"
						cate="REDNEW"
						
						
						}else if (applicationType=='cto' && category=='orange' && certificateFor=='new')
						{
						println("Orange New")
						var="CTE";
						
						catVar=" and indCategoryName ='ORANGE'";
						certiFor="NEW"
						cate="ORANGENEW"
						
						}else if (applicationType=='cto' && category=='green' && certificateFor=='new')
						{
						println("Green New")
						var="CTE";
						
						catVar=" and indCategoryName ='GREEN'";
						certiFor="NEW"
						cate="GREENNEW"
						
						}else  if (applicationType=='cto' && category=='red' && certificateFor=='renew')
						{
						println("1111")
						var="CTE";
						
						catVar=" and indCategoryName ='RED'";
						certiFor="NEW"
						cate="REDRENEW"
						
						
						}else if (applicationType=='cto' && category=='orange' && certificateFor=='renew')
						{
						println("Orange ReNew")
						var="CTE";
						
						catVar=" and indCategoryName ='ORANGE'";
						certiFor="NEW"
						cate="ORANGERENEW"
						
						}else if (applicationType=='cto' && category=='green' && certificateFor=='renew')
						{
						println("Green ReNew")
						var="CTE";
						
						catVar=" and indCategoryName ='GREEN'";
						certiFor="NEW"
						cate="GREENRENEW"
						
						} else if(applicationType=='ewaste')
						{
						var="EWaste";
						
						}
						println("cate "+ cate)
						
						if(var=='EWaste'){
						
						println("Deepak- IN EWASTE")
						
						if (forApplication.equals("1")) {
						
						def ctoReceivedApplication = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc" , [fromDate, toDate])
						for (int i = 0; i < ctoReceivedApplication.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoReceivedApplication[i].indRegInstance
						def groupIdA=(ctoReceivedApplication[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						
						
						
						inner.add(ctoReceivedApplication[i].applicationId.toString())
						inner.add(ctoReceivedApplication[i].indRegInstance.indName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						
						inner.add("EWaste") //
						inner.add(df.format(ctoReceivedApplication[i].dateCreated))
						if (ctoReceivedApplication[i].applicationStatus.equals("pending")) {
						inner.add("")
						} else {
						inner.add(df.format(ctoReceivedApplication[i].lastUpdated))
						}
						inner.add(ctoReceivedApplication[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoReceivedApplication[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						} else if (forApplication.equals("2")) {
						
						def ctoGrantedWithinTime = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and applicationStatus = 'approved' and lastUpdated - dateCreated <= '120 days' " +
						" and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc", [fromDate, toDate])
						
						
						for (int i = 0; i < ctoGrantedWithinTime.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoGrantedWithinTime[i].indRegInstance
						def groupIdA=(ctoGrantedWithinTime[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						
						
						inner.add(ctoGrantedWithinTime[i].applicationId.toString())
						inner.add(ctoGrantedWithinTime[i].indRegInstance.indName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						inner.add("EWaste") //
						inner.add(df.format(ctoGrantedWithinTime[i].dateCreated))
						inner.add(df.format(ctoGrantedWithinTime[i].lastUpdated))
						inner.add(ctoGrantedWithinTime[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoGrantedWithinTime[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						} else if (forApplication.equals("3")) {
						
						def ctoGrantedBeyondTime = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and applicationStatus = 'approved' and lastUpdated - dateCreated > '120 days' " +
						"and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc", [fromDate, toDate])
						
						for (int i = 0; i < ctoGrantedBeyondTime.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoGrantedBeyondTime[i].indRegInstance
						def groupIdA=(ctoGrantedBeyondTime[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						
						
						inner.add(ctoGrantedBeyondTime[i].applicationId.toString())
						inner.add(ctoGrantedBeyondTime[i].indRegInstance.indName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						inner.add("EWaste") //
						inner.add(df.format(ctoGrantedBeyondTime[i].dateCreated))
						inner.add(df.format(ctoGrantedBeyondTime[i].lastUpdated))
						inner.add(ctoGrantedBeyondTime[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoGrantedBeyondTime[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						
						} else if (forApplication.equals("4")) {
						
						def ctoRejectedWithinTime = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and applicationStatus = 'rejected' and lastUpdated - dateCreated <= '120 days' " +
						"and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc", [fromDate, toDate])
						
						for (int i = 0; i < ctoRejectedWithinTime.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoRejectedWithinTime[i].indRegInstance
						def groupIdA=(ctoRejectedWithinTime[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						inner.add(ctoRejectedWithinTime[i].applicationId.toString())
						inner.add(ctoRejectedWithinTime[i].indRegInstance.indName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						inner.add("EWaste") //
						inner.add(df.format(ctoRejectedWithinTime[i].dateCreated))
						inner.add(df.format(ctoRejectedWithinTime[i].lastUpdated))
						inner.add(ctoRejectedWithinTime[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoRejectedWithinTime[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						} else if (forApplication.equals("5")) {
						def ctoRejectedBeyondTime = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and applicationStatus = 'rejected' and lastUpdated - dateCreated > '120 days' " +
						"and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc", [fromDate, toDate])
						
						
						for (int i = 0; i < ctoRejectedBeyondTime.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoRejectedBeyondTime[i].indRegInstance
						def groupIdA=(ctoRejectedBeyondTime[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						inner.add(ctoRejectedBeyondTime[i].applicationId.toString())
						inner.add(ctoRejectedBeyondTime[i].applicationName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						inner.add("EWaste") //
						inner.add(df.format(ctoRejectedBeyondTime[i].dateCreated))
						inner.add(df.format(ctoRejectedBeyondTime[i].lastUpdated))
						inner.add(ctoRejectedBeyondTime[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoRejectedBeyondTime[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						
						} else if (forApplication.equals("6")) {
						
						def ctoPendingWithinTime = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and applicationStatus = 'pending' and lastUpdated - dateCreated <= '120 days' " +
						"and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc", [fromDate, toDate])
						
						for (int i = 0; i < ctoPendingWithinTime.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoPendingWithinTime[i].indRegInstance
						def groupIdA=(ctoPendingWithinTime[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						inner.add(ctoPendingWithinTime[i].applicationId.toString())
						inner.add(ctoPendingWithinTime[i].indRegInstance.indName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						inner.add("EWaste")
						inner.add(df.format(ctoPendingWithinTime[i].dateCreated))
						inner.add("")
						inner.add(ctoPendingWithinTime[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoPendingWithinTime[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						
						} else if (forApplication.equals("7")) {
						def ctoPendingBeyondTime = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails where " +
						""+query5+" and applicationStatus = 'pending' and lastUpdated - dateCreated > '120 days' " +
						"and dateCreated >=  ? and dateCreated <=  ? order by indRegInstance.district.districtName asc", [fromDate, toDate])
						
						for (int i = 0; i < ctoPendingBeyondTime.size(); i++) {
						inner = new ArrayList()
						def industryRegMaster = ctoPendingBeyondTime[i].indRegInstance
						def groupIdA=(ctoPendingBeyondTime[i].role.group.id)
						def districtId=industryRegMaster.district.id
						def dealingGroup
						def disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and group.id=? order by abc.id desc ",[(districtId).toLong(),(groupIdA).toLong()])
						if(disList)
						{
						dealingGroup=disList.group
						}
						inner.add(ctoPendingBeyondTime[i].applicationId.toString())
						inner.add(ctoPendingBeyondTime[i].indRegInstance.indName)
						if(industryRegMaster){
						inner.add(industryRegMaster.district.districtName)
						inner.add(industryRegMaster.occName)
						}else{
						inner.add("")
						inner.add("")
						}
						inner.add("EWaste") //
						inner.add(df.format(ctoPendingBeyondTime[i].dateCreated))
						inner.add("")
						inner.add(ctoPendingBeyondTime[i].applicationStatus)
						inner.add("EWaste")
						inner.add(ctoPendingBeyondTime[i].role.roleName)
						inner.add(dealingGroup)
						outer.add(inner)
						}
						
						}
						}
						
						render(view:'popApplicationCountAllModuleCto',  model: [outer: outer, flashMessage: params.flashMessage,type:params.type,cat:params.cat,number:params.number, fromDate: params.fromDateStr, toDate: params.toDateStr,groupId:params.groupId])
						
}

//  REMAINING DASHBOARD CODE IS ENDED HERE ADDED BY DEEPAK KUMAR
	
	def misReport={

        try {
               
               if(!session.userMaster)
               {
                   redirect(uri:"/index.gsp")
               }
               else
               {   
                   def challanInstance=false;
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
                      activityRecInstance.status = "Report Consent Payment Reconcile Report Click "
                      if(activityRecInstance.save()){         
                        }
                       else{
                           activityRecInstance.errors.each {
                           println it
                     }
                    }
                   render(view:'misReport11')
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
	
	def searchMis={

        try {
             
               def checkDate=null
               def appList= new ArrayList()
               def allFour= new ArrayList()
               def abc= new IndApplicationDetails()
           def abcR= new IndApplicationDetails()
           def groupList= new ArrayList()
           def groupListBMW = new ArrayList()
           def groupListCess = new ArrayList()
           def cteFee= new ArrayList()
           def bmwFee= new ArrayList()
           def wcFee= new ArrayList()
               def ctofee1 = new ArrayList()
           def ctoFeeAir= new ArrayList()
           def ctoFeeWater= new ArrayList()
               def sampleAir = new ArrayList()
               def sampleWater = new ArrayList()
               def sampleBoth = new ArrayList()
               def performanceSecurity = new ArrayList()
               
                   int total;
               def industry = new ArrayList()
               def industryBMW = new ArrayList()
               def industryWC = new ArrayList()
               def industry1
               def apply
               def consentList
                   
                   if(params.searchOp==null)
                   {
                       flash.message = "Please Select The Radio Button "
                       redirect(action:misReport)
                   }
                   else
                   {
                           
                               def startDate1=params.start_date_value
                               def endDate1=params.end_date_value
                               
                               session.startDate1=startDate1
                               session.endDate1=endDate1
                               
                               def x
                               def y
                               try
                               {
                                   def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
                                   x = sdfh.parse(startDate1); //Date
                                   y = sdfh.parse(endDate1);
                                   
                               }
                               catch(Exception e)
                               {
                                   flash.message="Enter Both The Dates in correct Format"
                                   redirect(action:misReport)
                               }
                       
                               java.sql.Date sqlDate = new java.sql.Date(x.getTime())
                               java.sql.Date sqlDate2 = new java.sql.Date(y.getTime()) 
                               sqlDate2.setDate((sqlDate2.getDate()+1))
               
               
                           if(sqlDate>sqlDate2)
                           {
                                   flash.message="End Date should be Greater than Starting Date"
                                       redirect(action:misReport)
                                       return
                           }
                           else
                           {
                           
                               if(startDate1 && endDate1)
                               {

                               
                                   def inr = new ArrayList()
                                   def industryList=BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='F' and idUser.paymentType='e-Wallet' order by idUser.dateCreated desc",[sqlDate,sqlDate2])
                                   
                                   
                               /////////////////////////////////////start////////////////////////////
                               for(int i=0;i<industryList.size();i++){
                                   
                                   def indAppId=industryList[i].indApplication
                                   def indNameObj=indAppId.indUser
                                   def indUserId=IndUser.findByIndustryRegMaster(indNameObj)
                               
                                 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:ms");
                                 Date newdate=new Date();
                                 String date=dateFormat.format(newdate);
    
                            

                               def user = session.getAttribute("indUser")
                               def strAcctNo11 = "JKPCB~"+indUserId.id+"~NA~NA~"+date+"~QUERY"+"~NA";
                               def strTranID11 = industryList[i].id 
                               def strMarketCode11 = "JKPCB"
                               def strTxnAmount11 = industryList[i].amount  
                               def strBankCode11 = "ICICI"
           

                    String contextPath11 = getServletContext().getRealPath("")+"/check.properties/";
           
           
           
           CheckSumRequestBean obj = new CheckSumRequestBean();
                           
                       obj.setStrMerchantTranId(strTranID11);
                       obj.setStrMarketCode(strMarketCode11);
                       obj.setStrAccountNo(strAcctNo11);
                       obj.setStrAmt(strTxnAmount11);
                       obj.setStrBankCode(strBankCode11);
                     
                   
                       obj.setStrPropertyPath(contextPath11)
                   
                       com.TPSLUtil util11 = new com.TPSLUtil();
                       String strMsg11 = util11.transactionRequestMessage(obj)
       
                      String RequestUrl="https://www.techprocess.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx";
                      QueryRequest query=new QueryRequest();
                      String Res= query.callPostRequest(RequestUrl,strMsg11);
         
                      
               //  code start for response/////////

                   
                   def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[indAppId])
       
       
                   String strBillerId = "";
                   String strMarketCode = "";
                   String strAccountNo = "";
                   String strResponseUrl = "";
                   String strMsg = "";
                   String strCustomerID = "";
                   String strTransactionRefNo = "";
                   String strBankRefNo = "";
                   String strTxnAmount = "";
                   String strCSTBANKID = "";
                   String strBankMerchantId = "";
                   String strTxnType = "";
                   String strMerCRN = "";
                   String strItemCode = "";
                   String strSecurityType = "";
                   String strSecurityId = "";
                   String strSecurityPassword = "";
                   String strTranDate = "";
                   String strAuthStatus = "";
                   String strSettlementType = "";
                   String strAddInfo1 = "";
                   String strAddInfo2 = "";
                   String strAddInfo3 = "";
                   String strAddInfo4 = "";
                   String strAddInfo5 = "";
                   String strAddInfo6 = "";
                   String strAddInfo7 = "";
                   String strReturnURL = "";
                   String strErrorStatus = "";
                   String strErrorDescription = "";
                   String strCheckSum = "";
                   String strStatus = "";
                   String strCheckSumValue = "";
                   String strResponseMsg="";
                   
                   
                   strResponseMsg =Res;
                   
                       StringTokenizer token = new StringTokenizer(strResponseMsg,"|");
       
                       if(token.countTokens()==26)
                           {
                               strBillerId=token.nextToken();
                               strCustomerID=token.nextToken();
                               strTransactionRefNo=token.nextToken();
                               strBankRefNo=token.nextToken();
                               strTxnAmount=token.nextToken();
                               strCSTBANKID=token.nextToken();
                               strBankMerchantId=token.nextToken();
                               strTxnType=token.nextToken();
                               strMerCRN=token.nextToken();
                               strItemCode=token.nextToken();
                               strSecurityType=token.nextToken();
                               strSecurityId=token.nextToken();
                               strSecurityPassword=token.nextToken();
                               strTranDate=token.nextToken();
                               strAuthStatus=token.nextToken();
                               strSettlementType=token.nextToken();
                               strAddInfo1=token.nextToken();
                               strAddInfo2=token.nextToken();
                               strAddInfo3=token.nextToken();
                               strAddInfo4=token.nextToken();
                               strAddInfo5=token.nextToken();
                               strAddInfo6=token.nextToken();
                               strAddInfo7=token.nextToken();
                               strErrorStatus=token.nextToken();
                               strErrorDescription=token.nextToken();
                               strCheckSum=token.nextToken();
                           }
                           else
                           {
       
                           }
       
                       
                     def inst = indAppId.applicationType
                     def inst1 = indAppId.applicationFor
                     def inst2 = indAppId.certificateFor
                     
                     def val = indAppId.indUser
       
                     def occName = val.occName
                     String contextPath
                     
                             if(strBillerId=="OPCB"){
                                    contextPath = getServletContext().getRealPath("")+"/check.properties/";
                                 }
                                 else{
                                   
                                     contextPath  = getServletContext().getRealPath("")+"/check.properties/";   
                                 }
                     
                     
       
                   
                     com.CheckSumResponseBean res = new com.CheckSumResponseBean();
                       
                       res.setStrMSG(strResponseMsg); 
       
                       res.setStrPropertyPath(contextPath);
                   
       
                       
                   
                   com.TPSLUtil util = new com.TPSLUtil();
                   strCheckSumValue = util.transactionResponseMessage(res);
                   
       
       
                     if (strAuthStatus != null) {
                         
                         if(strAuthStatus.equals("0300") || strAuthStatus.equals("0333") ||strAuthStatus.equals("0331") || strAuthStatus.equals("0301")){
                             if (!strCheckSumValue.equals("")) {
                                 if (!strCheckSumValue.equals(strCheckSum)) {
                               
                                 strAuthStatus = "0399";
                                 flash.message="Payment Not Success";
       
                                 redirect(action:misReport)
                                 return
                                 }
                                 
                                 else{
                                 
                               
                                   if(!appPendingInst){
                                
                                 
                                 def a = new GetData((indAppId.id).toLong())
                                 a.routeApp()
                                       }
                                
                                     
                                     def group = GroupDistrictMaster.findByDistrict(indAppId.indUser.district)
                                
                               
                                 def transInstance = BankTransactionDetails.get(strCustomerID)
                                 if(transInstance){
                                 if(transInstance.transactionStatus!="S"){
                                 transInstance.transactionStatus = "S"
                               
                   
                               
                                   if(strBillerId=="OPCB"){
                                  
                                   }
                                     
                                   else{
                                       
                                def bankId = BankMaster.find("from BankMaster abc where abc.bankCode=?",[strCSTBANKID])
       
                                     if(bankId){
                                    transInstance.bankName = bankId.bankName
                                     }
                                     else{
                                        transInstance.bankName = "NA"  
                                     }
                                   transInstance.bankId = strCSTBANKID
                                    
       
                                   }
                                 transInstance.lastUpdated = new Date()
                                   
                                
                                 
                                   if(transInstance.save()){
                                       
       
                                       
                                   }
                                 else{
                                    if(transInstance.hasErrors()){
                                       transInstance.errors.allErrors.each {
                                    println it
                                    }
                                    } 
                                    }
                                 
        
                         
                                 }else{
        
                                 }
                                 }
                                     
                                 else{
        
                                      flash.message="Payment Not Success";
                                     redirect(action:misReport) 
                                     return
                                  } 
                                                       
                                 }
                                 }
                             else{
                             strAuthStatus = "0399";  
                             
          
                             }
                             }
                         else{
                             strAuthStatus = "0399"; 
                                                    
          
                         }
              }
                     
                     else{
                         strAuthStatus = "0399"; 
                         
                         if(!appPendingInst){
                             flash.message="Payment Not Sucess";
          
                         redirect(action:misReport)
                         }
                         else{
                             flash.message="Payment Not Sucess";
          
                             redirect(action:misReport)   
                             
                         }
          
                     }
                   
                   
               //   code end for response/////////
               
                               }
                               ///////////////////////////////////////end///////////////////////////
                               ///////////////////////?????????PG verification start
                               
                                   CheckTrans check = new CheckTrans();
                                   check.webServiceUpdate(sqlDate,sqlDate2);
                                   
                                   ///////////////////////?????????PG verification end
                           ////?????Success List    
                               
               
       session.group = "All ROs"
       //////////////   Consent Start //////////////
       
           def inr11 = new ArrayList()
           def industryList11=BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' order by idUser.dateCreated desc",[sqlDate,sqlDate2])
           
       
           for(int d1=0;d1<industryList11.size();d1++)
           {

               industry.add(industryList11.get(d1))

           }
           
           for(int d=0;d<industry.size();d++)
           {
               def abcFina=(industry.get(d)).dateCreated

               if(abcFina.getClass().getName()=="java.sql.Date")
               {
                   (industry.get(d)).dateCreated=abcFina
               }
               else
               {
                   DateCustom dd2=new DateCustom()
                   
                   def xyz2= dd2.toDate(abcFina)
       
                   (industry.get(d)).dateCreated=xyz2
                   
               }
               
                       
               def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industry.get(d)).indApplication]);
                       
                   if(pendingInstance){
               groupList.add(pendingInstance.role.group.groupName)
                   }else{
                       groupList.add("")
                   }
               
               def feesOnlineCTE = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTE' order by id desc",[(industry.get(d)).indApplication])

               def feesOnlineCTOA = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Air' order by id desc",[(industry.get(d)).indApplication])

               def feesOnlineCTOW = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Water' order by id desc",[(industry.get(d)).indApplication])

               def feesOnlineCTO11 = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO' order by id desc",[(industry.get(d)).indApplication])

               
                   if(feesOnlineCTE)
               {
                   
                   def totalNOCFee=0
                   
                   for(int i=0;i<feesOnlineCTE.size();i++){
                       
                       totalNOCFee = totalNOCFee+feesOnlineCTE[i].amount
                   }
                   
                   
                   
                   
                       cteFee.add(totalNOCFee)
               }
               else {
                   cteFee.add(0)
               }
               
                   
                   if(feesOnlineCTOA)
               {
                   def feesOnlineCTOAir = 0
                   
                   for(int i=0;i<feesOnlineCTOA.size();i++)
                   {
                       
                       feesOnlineCTOAir    = feesOnlineCTOAir+feesOnlineCTOA[i].amount
                   }
                   
                   
                   
               ctoFeeAir.add(feesOnlineCTOAir)
               
               }
       
               else {
                   ctoFeeAir.add(0)
               }
               
                   
                   
               if(feesOnlineCTOW)
               {
                   
                   def fessOnlineCTOWater = 0
                   
                   
                   for(int u =0;u<feesOnlineCTOW.size();u++){
                       fessOnlineCTOWater =fessOnlineCTOWater +feesOnlineCTOW[u].amount
                       
                   }
                   
                   
                   ctoFeeWater.add(fessOnlineCTOWater)
                   
               }
               
               else {
                   ctoFeeWater.add(0)
               }

               if(feesOnlineCTO11)
               {
                   
                   def feesOnlineCTO1 = 0
                   
                   
                   for(int u =0;u<feesOnlineCTO11.size();u++){
                       feesOnlineCTO1 =feesOnlineCTO1 +feesOnlineCTO11[u].amount
                       
                   }
                   
                   
                   ctofee1.add(feesOnlineCTO1)
                   
               }
               
               else {
                   ctofee1.add(0)
               }
               
       }
       
            if(industry.getClass().getName()=="java.util.ArrayList" && industryWC.getClass().getName()=="java.util.ArrayList" && industryBMW.getClass().getName()=="java.util.ArrayList")
               {
                   
                
               if(industry.size()==0 && industryWC.size()==0  && industryBMW.size()==0)
               {
                   
                   flash.message="No Result Found With This Search Combination"
               }
               }
               
           
                session.industry = industry
                   session.cteFee = cteFee
                   
                   session.ctoFeeAir = ctoFeeAir
               
                   session.ctoFeeWater = ctoFeeWater
                   session.ctofee1 = ctofee1
                   
                   session.industryBMW = industryBMW
                   session.bmwFee=bmwFee
                   session.groupListBMW=groupListBMW
                   session.groupList = groupList
                   session.industryWC = industryWC
                   session.wc = industryWC.amount
                   session.groupListCess=groupListCess
                   
                   
                   render(view:'misReport11',model:[industry:industry,total:total,
                             industry1:industry1,apply:apply,
                              groupList:groupList,
                              cteFee:cteFee,ctoFeeAir:ctoFeeAir,ctoFeeWater:ctoFeeWater,ctofee1:ctofee1,
                              
                              industryWC:industryWC,industryBMW:industryBMW,groupListCess:groupListCess,bmwFee:bmwFee,groupListBMW:groupListBMW])

                               

                               ////?????Success List end       
                               }
                       
                               }                       
                           
                           }   
          
        
               render(view:'misReport11',model:[industry:industry,total:total,
                                             industry1:industry1,apply:apply,
                                              groupList:groupList,
                                              cteFee:cteFee,ctoFeeAir:ctoFeeAir,ctoFeeWater:ctoFeeWater,ctofee1:ctofee1,
                                              
                                              industryWC:industryWC,industryBMW:industryBMW,groupListCess:groupListCess,bmwFee:bmwFee,groupListBMW:groupListBMW])

                       
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
	
	def paymentReport={

        try {
               
               if(!session.userMaster)
               {
                   redirect(uri:"/index.gsp")
               }
               else
               {

                   def aa1 = session.userMaster
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
                      activityRecInstance.status = "Report Consent Payment Report Click "
                      if(activityRecInstance.save()){         
                        }
                       else{
                           activityRecInstance.errors.each {
                           println it
                     }
                    }
                   
                   def checkAdmin = aa1.accessLevel
                   if ((checkAdmin.equals('admin'))||(checkAdmin.equals('admin II'))||(checkAdmin.equals('employee'))){
                       render(view:'bankPaymentReport')
                   }
                   else{
                       redirect(uri:"/index.gsp")
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
	def searchPayment={

        try {
              
               def industrySize=IndUser.findAll("From IndUser idUser order by idUser.industryRegMaster.indName")
                   
                   params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
                  def checkDate=null
               def xyz5
               def qwe
               def statusList= new ArrayList()
               if(params.max)
               {
                   xyz5=(params.max).toInteger()
               }
               else
               {
                   xyz5=10
               }
               if(params.offset)
               {
                   qwe=(params.offset).toInteger()
               }
               else
               {
                   qwe=0
               }
                   def paramList= new ArrayList()
                   paramList=params
                       def appList= new ArrayList()
                       def allFour= new ArrayList()
                       def abc= new IndApplicationDetails()
                   def abcR= new IndApplicationDetails()
                   def groupList= new ArrayList()
                   def groupListBMW = new ArrayList()
                   def groupListCess = new ArrayList()
                   def cteFee= new ArrayList()
                   def ctofee1= new ArrayList()
                   def bmwFee= new ArrayList()
                   def wcFee= new ArrayList()
                   def ctoFeeAir= new ArrayList()
                   def ctoFeeWater= new ArrayList()
                   
                   def sampleAir = new ArrayList()
                   def sampleWater = new ArrayList()
                   def sampleBoth = new ArrayList()
                   def performanceSecurity = new ArrayList()
                   
                       int total;
                   def industry = new ArrayList()
                   def industryBMW = new ArrayList()
                   def industryWC = new ArrayList()
                   def industry1
                   def apply
                   def consentList
                   
                   def paymentType = params.paymentType
                   
                   def group=params.group.id
                   
                   if(params.searchOp==null)
                   {
                       flash.message = "Please Select The Radio Button "
                       redirect(action:paymentReport)
                   }
                   else
                   {
                       
                           
                           if(params.searchOp=="Others")
                           {
                               
                               def startDate1=params.start_date_value
                               def endDate1=params.end_date_value
                               
                               session.startDate1=startDate1
                               session.endDate1=endDate1
                               def x
                               def y
                               try
                               {
                                   def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
                                   x = sdfh.parse(startDate1); //Date
                                   y = sdfh.parse(endDate1);
                                   checkDate="checked"
                               }
                               catch(Exception e)
                               {
                                   flash.message="Enter Both The Dates in correct Format"
                                   redirect(action:paymentReport)
                               }
                       if(checkDate)
                       {
                           
                               java.sql.Date sqlDate = new java.sql.Date(x.getTime())
                               java.sql.Date sqlDate2 = new java.sql.Date(y.getTime()) 
                               sqlDate2.setDate((sqlDate2.getDate()+1))
                           if(sqlDate>sqlDate2)
                           {
                                   flash.message="End Date should be Greater than Starting Date"
                                       redirect(action:paymentReport)
                           }
                           else
                           {
                               
                           /////// search with both dates//////
                           
                               if(startDate1 && endDate1 && group == "321" && paymentType == "921")
                               {

                               session.group = "All ROs"
                               //////////////   Consent Start //////////////
                               
                                   def inr = new ArrayList()
                                   def industryList=BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' order by idUser.dateCreated desc",[sqlDate,sqlDate2])
                               
                                   for(int d1=0;d1<industryList.size();d1++)
                                   {
                                       
                                       industry.add(industryList.get(d1))
                                   
                                   }
                                   
                                   
                                   for(int d=0;d<industry.size();d++)
                                   {
                                       def abcFina=(industry.get(d)).dateCreated
                           
                                       if(abcFina.getClass().getName()=="java.sql.Date")
                                       {
                                           (industry.get(d)).dateCreated=abcFina
                                       }
                                       else
                                       {
                                           DateCustom dd2=new DateCustom()
                                           def xyz2= dd2.toDate(abcFina)
                               
                                           (industry.get(d)).dateCreated=xyz2
                                       }
                                           
                                       def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industry.get(d)).indApplication]);
                                               
                                           if(pendingInstance){
                                       groupList.add(pendingInstance.role.group.groupName)
                                           }else{
                                               groupList.add("")
                                           }
                                       
                                       def feesOnlineCTE = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTE' order by id desc",[(industry.get(d)).indApplication])
        
                                       def feesOnlineCTOA = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Air' order by id desc",[(industry.get(d)).indApplication])

                                       def feesOnlineCTOW = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Water' order by id desc",[(industry.get(d)).indApplication])
                                       
                                       def feesOnlineCTO11 = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO' order by id desc",[(industry.get(d)).indApplication])

                                           if(feesOnlineCTE)
                                       {
                                           
                                           def totalNOCFee=0
                                           
                                           for(int i=0;i<feesOnlineCTE.size();i++){
                                               
                                               totalNOCFee = totalNOCFee+feesOnlineCTE[i].amount
                                           }
                                           
                                               cteFee.add(totalNOCFee)
                                       }
                                       else {
                                           cteFee.add(0)
                                       }
                                       
                                           if(feesOnlineCTO11)
                                           {
                                               
                                               def feesOnlineCTO1 = 0
                                               
                                               
                                               for(int u =0;u<feesOnlineCTO11.size();u++){
                                                   feesOnlineCTO1 =feesOnlineCTO1 +feesOnlineCTO11[u].amount
                                                   
                                               }
                                               
                                               ctofee1.add(feesOnlineCTO1)
                                           }
                                           
                                           else {
                                               ctofee1.add(0)
                                           }
                                           
                                           
                                           if(feesOnlineCTOA)
                                       {
                                           def feesOnlineCTOAir = 0
                                           
                                           for(int i=0;i<feesOnlineCTOA.size();i++)
                                           {
                                               
                                               feesOnlineCTOAir    = feesOnlineCTOAir+feesOnlineCTOA[i].amount
                                           }
                                           
                                       ctoFeeAir.add(feesOnlineCTOAir)
                                       
                                       }
                               
                                       else {
                                           ctoFeeAir.add(0)
                                       }
                                       
                                       if(feesOnlineCTOW)
                                       {
                                           
                                           def fessOnlineCTOWater = 0
                                           
                                           
                                           for(int u =0;u<feesOnlineCTOW.size();u++){
                                               fessOnlineCTOWater =fessOnlineCTOWater +feesOnlineCTOW[u].amount
                                               
                                           }
                                           
                                           ctoFeeWater.add(fessOnlineCTOWater)
                                       }
                                       
                                       else {
                                           ctoFeeWater.add(0)
                                       }

                               }
                               
                               }
                       ///// with date and payment type/////
                       if(startDate1 && endDate1 && group == "321" && paymentType != "921")
                           
                               {   
                           def industryList
                           def inr = new ArrayList()
                           if(paymentType=="Net-banking PNB"){ 
                               
                               paymentType = "Net-banking PNB"
                               
               industryList = BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' and idUser.bankName='PNB' order by idUser.dateCreated desc",[sqlDate,sqlDate2])

                               
                           }
                           
                           else if(paymentType=="Net-banking"){
                               paymentType == "Net-banking"
                               industryList = BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' and idUser.paymentType='Net Banking' order by idUser.dateCreated desc",[sqlDate,sqlDate2])

                           }
                           else{
                               
                           industryList = BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' and idUser.paymentType=? order by idUser.dateCreated desc",[sqlDate,sqlDate2,paymentType])
                           }
                           
                           
                               for(int d1=0;d1<industryList.size();d1++)
                               {
                               
                                   
                                   industry.add(industryList.get(d1))
                               
                               }
                               
                               
                               for(int d=0;d<industry.size();d++)
                               {
                                   def abcFina=(industry.get(d)).dateCreated
                       
                                   if(abcFina.getClass().getName()=="java.sql.Date")
                                   {
                                       (industry.get(d)).dateCreated=abcFina
                                   }
                                   else
                                   {
                                       DateCustom dd2=new DateCustom()
                                       def xyz2= dd2.toDate(abcFina)
                           
                                       (industry.get(d)).dateCreated=xyz2
                                   }
                                   
                                   
                               
                                   def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industry.get(d)).indApplication]);
                                           
                                   if(pendingInstance){
                                       groupList.add(pendingInstance.role.group.groupName)
                                           }else{
                                               groupList.add("")
                                           }
                                   
                                   def feesOnlineCTE = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTE' order by id desc",[(industry.get(d)).indApplication])

                                   
                                   
                                   def feesOnlineCTOA = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Air' order by id desc",[(industry.get(d)).indApplication])

                                   def feesOnlineCTOW = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Water' order by id desc",[(industry.get(d)).indApplication])
                                   def feesOnlineCTO11 = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO' order by id desc",[(industry.get(d)).indApplication])

           
                                                   
                                                       if(feesOnlineCTE)
                                                   {
                                                       
                                                       def totalNOCFee=0
                                                       
                                                       for(int i=0;i<feesOnlineCTE.size();i++){
                                                           
                                                           totalNOCFee = totalNOCFee+feesOnlineCTE[i].amount
                                                       }
                                                       
                                                           cteFee.add(totalNOCFee)
                                                   }
                                                   else {
                                                       cteFee.add(0)
                                                   }
                                                   
                                                       if(feesOnlineCTO11)
                                                       {
                                                           
                                                           def feesOnlineCTO1 = 0
                                                           
                                                           
                                                           for(int u =0;u<feesOnlineCTO11.size();u++){
                                                               feesOnlineCTO1 =feesOnlineCTO1 +feesOnlineCTO11[u].amount
                                                               
                                                           }
                                                           
                                                           ctofee1.add(feesOnlineCTO1)
                                                       }
                                                       
                                                       else {
                                                           ctofee1.add(0)
                                                       }   
                                                       
                                                       
                                                       if(feesOnlineCTOA)
                                                   {
                                                       def feesOnlineCTOAir = 0
                                                       
                                                       for(int i=0;i<feesOnlineCTOA.size();i++)
                                                       {
                                                           
                                                           feesOnlineCTOAir    = feesOnlineCTOAir+feesOnlineCTOA[i].amount
                                                       }
                                                       
                                                   ctoFeeAir.add(feesOnlineCTOAir)
                                                   
                                                   }
                                           
                                                   else {
                                                       ctoFeeAir.add(0)
                                                   }
                                                   
                                                   if(feesOnlineCTOW)
                                                   {
                                                       
                                                       def fessOnlineCTOWater = 0
                                                       
                                                       
                                                       for(int u =0;u<feesOnlineCTOW.size();u++){
                                                           fessOnlineCTOWater =fessOnlineCTOWater +feesOnlineCTOW[u].amount
                                                           
                                                       }
                                                       
                                                       ctoFeeWater.add(fessOnlineCTOWater)
                                                   }
                                                   
                                                   else {
                                                       ctoFeeWater.add(0)
                                                   }

                                                   
                                           }
                                           
                           
                               
                }
                       if(startDate1 && endDate1 && group != "321" && paymentType != "921")
                           
                       {   
                           
                   def industryList
                   def inr = new ArrayList()
                   
               if(paymentType=="Net-banking PNB")
               { 
                       
               paymentType = "Net-banking PNB"
                       
               industryList = BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' and idUser.bankName='PNB' order by idUser.dateCreated desc",[sqlDate,sqlDate2])
                       
               }
                   
               else if(paymentType=="Net-banking")
               {

              paymentType == "Net-banking"
              industryList = BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' and idUser.paymentType='Net Banking' order by idUser.dateCreated desc",[sqlDate,sqlDate2])

               }
               
               else{

               industryList = BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' and idUser.paymentType=? order by idUser.dateCreated desc",[sqlDate,sqlDate2,paymentType])
               
               }
                   
                   
               for(int d1=0;d1<industryList.size();d1++)
               {
               def groupName = GroupDistrictMaster.find("from GroupDistrictMaster where group.id=?",[group.toLong()])                      
               def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industryList.get(d1)).indApplication]);
                           if(groupName && pendingInstance){                       
               if(pendingInstance.role.group.groupName==groupName.group.groupName){
                       
               industry.add(industryList.get(d1))
               }
                           }
               }
                       
                       for(int d=0;d<industry.size();d++)
                       {
                           def abcFina=(industry.get(d)).dateCreated
               
                           if(abcFina.getClass().getName()=="java.sql.Date")
                           {
                               (industry.get(d)).dateCreated=abcFina
                           }
                           else
                           {
                               DateCustom dd2=new DateCustom()
                               def xyz2= dd2.toDate(abcFina)
                   
                               (industry.get(d)).dateCreated=xyz2
                           }
                           
                                                   
                           def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industry.get(d)).indApplication]);
                               
                           if(pendingInstance){
                               groupList.add(pendingInstance.role.group.groupName)
                                   }else{
                                       groupList.add("")
                                   }
                                   
                           def feesOnlineCTE = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTE' order by id desc",[(industry.get(d)).indApplication])

                           
                           
                           def feesOnlineCTOA = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Air' order by id desc",[(industry.get(d)).indApplication])

                           def feesOnlineCTOW = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Water' order by id desc",[(industry.get(d)).indApplication])
                           def feesOnlineCTO11 = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO' order by id desc",[(industry.get(d)).indApplication])
                           if(feesOnlineCTE)
                                       {
                                           
                                           def totalNOCFee=0
                                           
                                           for(int i=0;i<feesOnlineCTE.size();i++){
                                               
                                               totalNOCFee = totalNOCFee+feesOnlineCTE[i].amount
                                           }
                                           
                                           
                                           
                                           
                                               cteFee.add(totalNOCFee)
                                       }
                                       else {
                                           cteFee.add(0)
                                       }
                                       
                                           if(feesOnlineCTO11)
                                           {
                                               
                                               def feesOnlineCTO1 = 0
                                               
                                               
                                               for(int u =0;u<feesOnlineCTO11.size();u++){
                                                   feesOnlineCTO1 =feesOnlineCTO1 +feesOnlineCTO11[u].amount
                                                   
                                               }
                                               
                                               ctofee1.add(feesOnlineCTO1)
                                           }
                                           
                                           else {
                                               ctofee1.add(0)
                                           }   
                                           
                                           
                                           if(feesOnlineCTOA)
                                       {
                                           def feesOnlineCTOAir = 0
                                           
                                           for(int i=0;i<feesOnlineCTOA.size();i++)
                                           {
                                               
                                               feesOnlineCTOAir    = feesOnlineCTOAir+feesOnlineCTOA[i].amount
                                           }
                                           
                                           
                                           
                                       ctoFeeAir.add(feesOnlineCTOAir)
                                       
                                       }
                               
                                       else {
                                           ctoFeeAir.add(0)
                                       }
                                       
                                       if(feesOnlineCTOW)
                                       {
                                           
                                           def fessOnlineCTOWater = 0
                                           
                                           
                                           for(int u =0;u<feesOnlineCTOW.size();u++){
                                               fessOnlineCTOWater =fessOnlineCTOWater +feesOnlineCTOW[u].amount
                                               
                                           }
                                           
                                           ctoFeeWater.add(fessOnlineCTOWater)
                                       }
                                       
                                       else {
                                           ctoFeeWater.add(0)
                                       }

                                   
                                       
                               }
                   
                               
       }
               ///////////////////////////////////////////
                  if(startDate1 && endDate1 && group != "321" && paymentType == "921")
                           
                       {   
                   def inr = new ArrayList()               
                   def industryList=BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.dateCreated >= ? and  idUser.dateCreated <= ? and idUser.transactionStatus='S' order by idUser.dateCreated desc",[sqlDate,sqlDate2])
                   
                   
                       for(int d1=0;d1<industryList.size();d1++)
                       {
                           def groupName = GroupDistrictMaster.find("from GroupDistrictMaster where group.id=?",[group.toLong()])                      
                           //println("--------groupname---------------"+groupName)    
                           def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industryList.get(d1)).indApplication]);
                                                   println("-----pendingInstance--------"+pendingInstance)
                                                   if(groupName && pendingInstance){
                           if(pendingInstance.role.group.groupName==groupName.group.groupName){
                           industry.add(industryList.get(d1))
                           }
                       }
                       }
                       
                       
                       for(int d=0;d<industry.size();d++)
                       {
                           def abcFina=(industry.get(d)).dateCreated
               
                           if(abcFina.getClass().getName()=="java.sql.Date")
                           {
                               (industry.get(d)).dateCreated=abcFina
                           }
                           else
                           {
                               DateCustom dd2=new DateCustom()
                               def xyz2= dd2.toDate(abcFina)
                   
                               (industry.get(d)).dateCreated=xyz2
                           }
                           
                                                   
                           def pendingInstance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[(industry.get(d)).indApplication]);
                               
                           if(pendingInstance){
                               groupList.add(pendingInstance.role.group.groupName)
                                   }else{
                                       groupList.add("")
                                   }
                                   
                           def feesOnlineCTE = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTE' order by id desc",[(industry.get(d)).indApplication])

                           
                           
                           def feesOnlineCTOA = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Air' order by id desc",[(industry.get(d)).indApplication])

                           def feesOnlineCTOW = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO Water' order by id desc",[(industry.get(d)).indApplication])
                               def feesOnlineCTO11 = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.feeFor='CTO' order by id desc",[(industry.get(d)).indApplication])
   
                                           if(feesOnlineCTE)
                                       {
                                           
                                           def totalNOCFee=0
                                           
                                           for(int i=0;i<feesOnlineCTE.size();i++){
                                               
                                               totalNOCFee = totalNOCFee+feesOnlineCTE[i].amount
                                           }
                                           
                                           
                                           
                                           
                                               cteFee.add(totalNOCFee)
                                       }
                                       else {
                                           cteFee.add(0)
                                       }
                                       
                                           if(feesOnlineCTO11)
                                           {
                                               
                                               def feesOnlineCTO1 = 0
                                               
                                               
                                               for(int u =0;u<feesOnlineCTO11.size();u++){
                                                   feesOnlineCTO1 =feesOnlineCTO1 +feesOnlineCTO11[u].amount
                                                   
                                               }
                                               
                                               ctofee1.add(feesOnlineCTO1)
                                           }
                                           
                                           else {
                                               ctofee1.add(0)
                                           }
                                           
                                           
                                           if(feesOnlineCTOA)
                                       {
                                           def feesOnlineCTOAir = 0
                                           
                                           for(int i=0;i<feesOnlineCTOA.size();i++)
                                           {
                                               
                                               feesOnlineCTOAir    = feesOnlineCTOAir+feesOnlineCTOA[i].amount
                                           }
                                           
                                           
                                           
                                       ctoFeeAir.add(feesOnlineCTOAir)
                                       
                                       }
                               
                                       else {
                                           ctoFeeAir.add(0)
                                       }
                                       
                                       if(feesOnlineCTOW)
                                       {
                                           
                                           def fessOnlineCTOWater = 0
                                           
                                           
                                           for(int u =0;u<feesOnlineCTOW.size();u++){
                                               fessOnlineCTOWater =fessOnlineCTOWater +feesOnlineCTOW[u].amount
                                               
                                           }
                                           println("fessOnlineCTOWater---"+fessOnlineCTOWater)
                                           
                                           ctoFeeWater.add(fessOnlineCTOWater)
                                           println("ctoFeeWater---"+ctoFeeWater)
                                       }
                                       
                                       else {
                                           ctoFeeWater.add(0)
                                       }

                                       
                               }
                       
       }
           
               }
       }
                   
                           }       
                           
                           
                           }
           
          
           if(industry.getClass().getName()=="java.util.ArrayList" && industryWC.getClass().getName()=="java.util.ArrayList" && industryBMW.getClass().getName()=="java.util.ArrayList")
           {
               System.out.println("COUNT123"+industryWC.getClass().getName()+industryWC.size())
            
           if(industry.size()==0 && industryWC.size()==0  && industryBMW.size()==0)
           {
               
               flash.message="No Result Found With This Search Combination"
           }
           }
           
            session.industry = industry
               session.cteFee = cteFee
               session.ctofee1 = ctofee1
               session.ctoFeeAir = ctoFeeAir
           
               session.ctoFeeWater = ctoFeeWater
               
               session.industryBMW = industryBMW
               session.bmwFee=bmwFee
               session.groupListBMW=groupListBMW
               session.groupList = groupList
               session.industryWC = industryWC
               session.wc = industryWC.amount
               session.groupListCess=groupListCess
               
               render(view:'paymentReport',model:[industry:industry,total:total,
                          paramList:paramList,industry1:industry1,apply:apply,
                          groupList:groupList,industrySize:industrySize,
                          cteFee:cteFee,ctoFeeAir:ctoFeeAir,ctoFeeWater:ctoFeeWater,
                          paymentType:paymentType,ctofee1:ctofee1,
                          industryWC:industryWC,industryBMW:industryBMW,groupListCess:groupListCess,bmwFee:bmwFee,groupListBMW:groupListBMW])



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
	def monitoringDetailBMW={

   	 try { 
   	    	if(!session.userMaster)
   	    	{
   	            redirect(uri:"/index.gsp")
   	    	}
   	    	else
   	    	{
   	            def aa1 = session.userMaster
   	            def checkAdmin = aa1.accessLevel
   	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
   	            {
   	            	render(view:'monitoringDetailBMW')
   	            }
   	            else
   	            {
   	            	redirect(uri:"/index.gsp")
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
	
	/*def searchMonitoringDetails={
		try{
			def fromDate=params.start_date_value
			println("-----fromDate------"+fromDate)
			def toDate=params.end_date_value
			println("=--------toDate-------"+toDate)
			def appFor=params.appFor
			def districtName = params.groupName
			println("--------districtName--------------"+districtName)
			def wastependingReord
			def listApplication=new ArrayList()
			for(int i=0;i<districtName.size();i++){
				def groupId=GroupMaster.find("from GroupMaster g where g.groupName=? ",[districtName[i]])
				wastependingReord=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails w ,RoleMaster  r where w.role.id=r.id and r.group.id=? and w.applicationFor='BMW'",[groupId.id])
				println("----wastependingReord---"+wastependingReord.size())
				listApplication.add(wastependingReord)
			}
			println(listApplication.toString())
			render(view:'monitoringDetailBMW1',model:[wastependingReord:listApplication])	
				
			
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
	}*/
	/*
	def updateAllSummaryWaste={
		if(bioMedicalInstance.size()>0){
			for(int i=0; i<bioMedicalInstance.size();i++){
				def bioInstance=bioMedicalInstance[i]
				def wastePending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails w where w.applicationId=?",[String.valueOf(bioInstance.id)])
				def allSummaryReport=new AllSummaryReportWMS()
				allSummaryReport.applicationId=bioInstance.id.toString()
				allSummaryReport.indRegMasterId=bioInstance.industryRegMasterObj.id
				allSummaryReport.applicationStatus=bioInstance.applicationStatus
				
				allSummaryReport.scrutinyStatus=""
				String applicationFor=wastePending.applicationFor
				Date pendingSince=wastePending.dateCreated
				String pendingWith=wastePending.pendingWith.id
			    Date dateCreated=wastePending.dateCreated
				Date recieptDate=
				String applicationName=bioInstance.createdBy
				def distId=GroupDistricMaster.findByGroup(wastePending.role.group)
				String districtId  =distId.district.id.toString()
				String districtName=distId.district.districtName
				long categoryId=
				String categoryName=
				String roleId=
				String roleName=
				String groupId=
				String groupName=
				String officerName=
				String industryTypeId=
				String industryTypeName=
				String industryAddress=
			    String indCapInvt=
				String indId=
				String authorizationtype=
				Date authDate=
				boolean clarification=
				String  clarificationType=
				Date clarificationDate=
				String clarificationReplyDate=
				Date dateOfIssue=
				Date dateOfExpaire=
				boolean refused=
				boolean returned=
				Date refusedDate=
				Date returnedDate=
				
			}
			
			
		}
		
	}*/
	
	def searchMonitoringDetails={

   	 try { 
   	    	def startDate1=params.start_date_value
   			def endDate1=params.end_date_value
   			def x
   			def y
   			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
   			x = sdfh.parse(startDate1); //Date
   			y = sdfh.parse(endDate1);
   			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
   			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
   			java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
   			sqlDate2.setDate((sqlDate2.getDate()+1))
   		    def groups=params.groupName
   			if(sqlDate>sqlDate2)
   			{
   				flash.message="End Date should be Greater than Starting Date"
   				render(view:'monitoringDetail')
   			}
   			else if(!groups)
   	    	{
   	    		session.groupList=null
   	    		flash.message="Choose group"
   	    		render(view:'monitoringDetailBMW1')
   	    	}
   	    	else if(groups.getClass().getName()=="java.lang.String")
   	    	{
   	    		def groupList = new ArrayList()
   	    		def groupInstance=GroupMaster.findByGroupName(groups);
   	        	if(groupInstance)
   	        	{
   	        		groupList.add(groupInstance)
   	        	}
   	        	session.groupList=groupList
   	          	session.sqlDate=sqlDate
   	          	session.sqlDate2=sqlDate2
   	          	render(view:'monitoringDetailBMW1',model:[ sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])	
   	    	}
   	    	else
   	    	{
   	    		def groupList = new ArrayList()
   	    		for(int i = 0 ; i < groups.length; i++ ){
   	        		def groupInstance=GroupMaster.findByGroupName(groups[i]);
   	        		if(groupInstance)
   	        		{
   	        			groupList.add(groupInstance)
   	        		}
   	    		}
   	    		session.groupList=groupList
   	          	session.sqlDate=sqlDate
   	          	session.sqlDate2=sqlDate2
   	          	render(view:'monitoringDetailBMW1',model:[ sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])	
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
	
	def monitoringDetailBMWAllDistrict=
	{
  	 try { 
  	    	if(!session.userMaster)
  	    	{
  	            redirect(uri:"/index.gsp")
  	    	}
  	    	else
  	    	{
  	            def aa1 = session.userMaster
  	            def checkAdmin = aa1.accessLevel
  	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
  	            {
  	            	render(view:'totalWasteApplicationsDetail')
  	            }
  	            else
  	            {
  	            	redirect(uri:"/index.gsp")
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
	def searchWasteMonitoringReport={

		def startDate1=params.start_date_value
		def endDate1=params.end_date_value
		def x
		def y
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		x = sdfh.parse(startDate1); //Date
		y = sdfh.parse(endDate1);
		def  newGroupList = GroupMaster.list()
		def groupList = new ArrayList()
		for(int i = 0 ; i < newGroupList.size(); i++ ){
			if(!(newGroupList[i].groupName=="HO CONSENT")){
				groupList.add(newGroupList[i])
		}
		}
		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
		sqlDate2.setDate((sqlDate2.getDate()+1))
		session.groupList=groupList
		session.sqlDate=sqlDate
		session.sqlDate2=sqlDate2
    	if(sqlDate>sqlDate2)
		{
			flash.message="End Date should be Greater than Starting Date"
				render(view:'totalApplicationsDetail')
		}
    	else
		{
			render(view:'totalWasteApplicationsDetail',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])
		}	
    
	}
	
	def monitoringDetailBMWConsentWise={

	  	 try { 
	  	    	if(!session.userMaster)
	  	    	{
	  	            redirect(uri:"/index.gsp")
	  	    	}
	  	    	else
	  	    	{
	  	            def aa1 = session.userMaster
	  	            def checkAdmin = aa1.accessLevel
	  	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
	  	            {
	  	            	render(view:'totalWasteApplicationsDetailConsentWise')
	  	            }
	  	            else
	  	            {
	  	            	redirect(uri:"/index.gsp")
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
	def searchMonitoringWasteReportConsentWise={

println("---searchMonitoringWasteReportConsentWise-------")
		def startDate1=params.start_date_value
		def endDate1=params.end_date_value
		def x
		def y
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		x = sdfh.parse(startDate1); //Date
		y = sdfh.parse(endDate1);
		def  newGroupList = GroupMaster.list()
		def groupList = new ArrayList()
		for(int i = 0 ; i < newGroupList.size(); i++ ){
			if(!(newGroupList[i].groupName=="HO CONSENT")){
				groupList.add(newGroupList[i])
		}
		}
		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
		sqlDate2.setDate((sqlDate2.getDate()+1))
		session.groupList=groupList
		session.sqlDate=sqlDate
		session.sqlDate2=sqlDate2
    	if(sqlDate>sqlDate2)
		{
			flash.message="End Date should be Greater than Starting Date"
				render(view:'totalWasteApplicationsDetailConsentWise')
		}
    	else
		{
			render(view:'totalWasteApplicationsDetailConsentWise',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])
		}	
    
	
	}
	
	def monitoringDetailBMWConsentCatWise={


	  	 try { 
	  	    	if(!session.userMaster)
	  	    	{
	  	            redirect(uri:"/index.gsp")
	  	    	}
	  	    	else
	  	    	{
	  	            def aa1 = session.userMaster
	  	            def checkAdmin = aa1.accessLevel
	  	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
	  	            {
	  	            	render(view:'totalWasteApplicationsDetailConsentCatWise')
	  	            }
	  	            else
	  	            {
	  	            	redirect(uri:"/index.gsp")
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
	
	def searchBMWMonitoringReportConsentCat={


		println("---searchMonitoringWasteReportConsentWise-------")
				def startDate1=params.start_date_value
				def endDate1=params.end_date_value
				def x
				def y
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
				x = sdfh.parse(startDate1); //Date
				y = sdfh.parse(endDate1);
				def  newGroupList = GroupMaster.list()
				def groupList = new ArrayList()
				for(int i = 0 ; i < newGroupList.size(); i++ ){
					if(!(newGroupList[i].groupName=="HO CONSENT")){
						groupList.add(newGroupList[i])
				}
				}
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
				sqlDate2.setDate((sqlDate2.getDate()+1))
				session.groupList=groupList
				session.sqlDate=sqlDate
				session.sqlDate2=sqlDate2
		    	if(sqlDate>sqlDate2)
				{
					flash.message="End Date should be Greater than Starting Date"
						render(view:'totalWasteApplicationsDetailConsentCatWise')
				}
		    	else
				{
					render(view:'totalWasteApplicationsDetailConsentCatWise',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList])
				}	
		    
			
			
		
	}
	def monitoringDetailBMWAllApplication={
		 try { 
	  	    	if(!session.userMaster)
	  	    	{
	  	            redirect(uri:"/index.gsp")
	  	    	}
	  	    	else
	  	    	{
	  	            def aa1 = session.userMaster
	  	            def checkAdmin = aa1.accessLevel
	  	            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee')))
	  	            {
	  	            	render(view:'AllBMWApplicationsDetail')
	  	            }
	  	            else
	  	            {
	  	            	redirect(uri:"/index.gsp")
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
	
	def searchAllBMWApplication={
				println("---searchMonitoringWasteReportConsentWise-------")
				def startDate1=params.start_date_value
				def endDate1=params.end_date_value
				def x
				def y
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
				x = sdfh.parse(startDate1); //Date
				y = sdfh.parse(endDate1);
				def  newGroupList = GroupMaster.list()
				def groupList = new ArrayList()
				for(int i = 0 ; i < newGroupList.size(); i++ ){
					if(!(newGroupList[i].groupName=="HO CONSENT")){
						groupList.add(newGroupList[i])
				}
				}
				
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
				def allSummaryReport=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS aw where aw.applicationFor='BMW' and aw.authDate>=? and aw.authDate <=? order by aw.authDate desc",[sqlDate,sqlDate2])
				println("--allSummaryReport--"+allSummaryReport.size())
				sqlDate2.setDate((sqlDate2.getDate()+1))
				session.groupList=groupList
				session.sqlDate=sqlDate
				session.sqlDate2=sqlDate2
		    	if(sqlDate>sqlDate2)
				{
					flash.message="End Date should be Greater than Starting Date"
						render(view:'AllBMWApplicationsDetail')
				}
		    	else
				{
					render(view:'AllBMWApplicationsDetail',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,allSummaryReport:allSummaryReport])
				}	
		    
			
			
		
	
		
	}
	
	def viewUploadedCerti={
println("Params--------"+params)
		 try {
			 	def appFor=params.appliFor
	        	def appIdStr=params.appliLoc
	        	println("appIdStr---"+appIdStr)
	        	def application
	        	def type=params.docName
	        	
	    		def applicationFileInstance
	    		if(appFor=='BMW'){
	    			
	 	    	 applicationFileInstance=WasteManagementCertificates.findAll("from WasteManagementCertificates wmf where wmf.id=? and wmf.applicationFor=? and wmf.typeOfFile=? order by wmf.id desc",[appIdStr.toLong(),appFor,type],[max:1])
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
	def popNewPageReportExcBMW={


	   	 try { 
	   	    	def groupList=session.groupList
	   			def sqlDate=session.sqlDate
	   			
	   			def sqlDate2=session.sqlDate2
	   			
	   			println("--sqlDate--sqlDate--2"+sqlDate+"---------"+sqlDate2)
	   			def sqlDate3 = sqlDate2-1
	   			render(view:'popNewPageReportExcBMW',model:[sqlDate3:sqlDate3,groupList:groupList,sqlDate:sqlDate,sqlDate2:sqlDate2]) 
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
	
	def hwmWithConsent={


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
	    activityRecInstance.status = "hwmWithConsent"
	    if(activityRecInstance.save()){		   
	      }
	    	else{
	    		activityRecInstance.errors.each {
		    	println it
		  }
	   }
	    render(view:'hwmWithConsent')    
	 
	}
def hwmWithConsentSearch={
		  
		 
		try {
			println("HELLO VINEET in HWM"+params);
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setDateHeader("Expires", 0); // Proxies.
			
		   def startDate1=params.start_date_value
		   def endDate1=params.end_date_value
		   def status=params.status
		   def group=params.group
		   def appFor
		   if(params.appFor=='Fresh'){
			   appFor='new'
		   }else if(params.appFor=='Renew'){
			   appFor='reNew'
		   }
		  
			println("-----District NAme----"+params.districtId)
			
		   ArrayList allSummaryReportWMSList=new ArrayList()
		   def x
		   def y
		   def sdfh = new SimpleDateFormat("dd/MM/yyyy");
		   x = sdfh.parse(startDate1);
		   y = sdfh.parse(endDate1);
		   java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		   java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())
		   java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
		   sqlDate2.setDate((sqlDate2.getDate()+1))
		   def category=params.category;
		   def districtId=params.districtId;
		   String query="";
		   if(params.status =='approved'|| params.status =='rejected ' || params.status =='returned')
		   {
		   	 query="From AllSummaryReport abc where abc.pendingSince >= '"+sqlDate+"' and abc.pendingSince <= '"+sqlDate2+"' ";
		   }else
		   {
		   	 query="From AllSummaryReport abc where abc.applicationRecieptDate >= '"+sqlDate+"' and abc.applicationRecieptDate <= '"+sqlDate2+"' ";
		   }
		   if(params.status !='All')
		   {
		   	query=query+" and abc.applicationStatus ='"+params.status+"'";
		   } 
		   if(params.appFor !='101')
		   {
		   	query=query+" and abc.certificateFor='"+appFor+"'";
		   }
		   if(params.districtId !='NotSelected')
		   {
		   	query=query+" and abc.districtName='"+params.districtId+"'";
		   }
		   if(params.category !='101')
		   {
		   	query=query+" and indCategoryName='"+params.category+"'";
		   }
		   
		   if(params.status =='All' && params.appFor =='101' && params.districtId =='NotSelected' && params.category =='101')
		   {
		   	query=query;
		   }
		   query=query+" order by abc.applicationRecieptDate desc ";
		   println("----------query-------"+query)
		   allSummaryReportWMSList=AllSummaryReport.findAll(query);
		   println("---allSummaryReportWMSList-----"+allSummaryReportWMSList.size())
		   session.sqlDate=sqlDate
		   session.sqlDate2=sqlDate2
		   session.status=status
		   session.appFor=appFor
		   session.districtId=districtId
		   session.category=category
		   
		   session.allSummaryReportWMSList22=allSummaryReportWMSList
		   
		   if(sqlDate>sqlDate2)
		   {
		       flash.message="End Date should be Greater than or Equal to Start Date"
		       render(view:'hwmWithConsent')
		   }
		   else
		   {
		   	if(allSummaryReportWMSList.size() == 0)
		   	{
		   		flash.message="No Record Found"
		           render(view:'hwmWithConsent')
		           return
		   	}else
		   	{
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
		           activityRecInstance.status = "Report 25 Consent Application Report Search "
		           if(activityRecInstance.save()){		   
		             }
		           	else{
		           		activityRecInstance.errors.each {
		       	    	println it
		       	  }
		         }
		           ArrayList allSummaryReportWithHWM=new ArrayList()
		          if(allSummaryReportWMSList.size()>0){
		        	  for(int i=0;i<allSummaryReportWMSList.size();i++){
		        		  def indApp=IndApplicationDetails.get(allSummaryReportWMSList[i].applicationId.toLong())
		        		  if(indApp.hazardeousType=='HWM'){
		        			  allSummaryReportWithHWM.add(allSummaryReportWMSList[i])
		        		  }
		        		  
		        	  }
		        	  
		          }
		           println("-gfg---"+allSummaryReportWithHWM.size())
		           session.allSummaryReportWithHWM111=allSummaryReportWithHWM
		   		render(view:'hwmWithConsent',model:[sqlDate3:sqlDate3,status:status,group:group,appFor:appFor,sqlDate:sqlDate,sqlDate2:sqlDate2,allSummaryReportWMSList:allSummaryReportWMSList,districtId:districtId,category:category,allSummaryReportWithHWM:allSummaryReportWithHWM])
		   	}
		       
		   }
		}catch(Exception e) {
		       e.printStackTrace();
		       flash.message = "Server Busy ..Please try after some time....";
		       if(session.indUser)
		       {
		       redirect(controller:'indUser',action:'openIndustryHome')
		       }else if(session.userMaster){
		       redirect(controller:'userMaster',action:'openSpcbHome');
		       }else{
		       session.invalidate()
		       redirect(uri:'/index.gsp');
		   }
		}
		
		
	}
	def popNewApplicationsExc25={
		try {
		      
			def applicationDetailList= session.allSummaryReportWithHWM111
			def startDateHWM=session.sqlDate
			def endDateHWM= session.sqlDate2
			 
			println("LIST SIZE---"+applicationDetailList.size());
		    render(view:'popNewApplicationExc25',model:[allSummaryReportWMSList:applicationDetailList,startDateHWM:startDateHWM,endDateHWM:endDateHWM]) 

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
		

	def searchPaymentNew={
		def payType=params.paymentType
		
		def groupName=params.group.id
		
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		def	x = sdfh.parse(params.start_date_value); //Date
		def	y = sdfh.parse(params.end_date_value);  //Date
		session.Datee1=params.start_date_value
		session.Dateee2=params.end_date_value
		java.sql.Date date1 = new java.sql.Date(x.getTime()) 
		java.sql.Date date2 = new java.sql.Date(y.getTime())
		date2.setDate((date2.getDate()+1))
		println('------date1---'+date1)
		println('------date1---'+date2)
		println('------groupName---'+groupName)
		def bankTransaction
		
		if(groupName=='All'){
			bankTransaction=BankTransactionDetails.findAll("from BankTransactionDetails bt where bt.transactionStatus='S' and bt.dateCreated>=? and bt.dateCreated<=? and bt.indApplication.id IN (Select ap.application.id from ApplicationPendingDetails ap)",[date1,date2])
		}else {
			def group=GroupMaster.get(groupName.toLong())
			bankTransaction=BankTransactionDetails.findAll("from BankTransactionDetails bt where bt.transactionStatus='S' and bt.dateCreated>=? and bt.dateCreated<=? and bt.indApplication.id IN (Select ap.application.id from ApplicationPendingDetails ap where ap.role.group=?)",[date1,date2,group])
		}
		
		session.listofTransaction=bankTransaction
		println('------bankTransaction---'+bankTransaction)
		render(view:'bankPaymentReport',model:[bankTransaction:bankTransaction])
	}
	def popBankOnlinePayReport={
		def bankTransaction=session.listofTransaction
		def date1=session.Datee1
		def date2=session.Dateee2
		return[bankTransaction:bankTransaction,date1:date1,date2:date2]
	}
	def paymentReportBMW={

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
	    activityRecInstance.status = "BMW MIS Payment"
	    if(activityRecInstance.save()){		   
	      }
	    	else{
	    		activityRecInstance.errors.each {
		    	println it
		  }
	   }
	    render(view:'paymentReportBMW')    
	 
	}
	def paymentReportHWM={
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
	    activityRecInstance.status = "HWM MIS Payment"
	    if(activityRecInstance.save()){		   
	      }
	    	else{
	    		activityRecInstance.errors.each {
		    	println it
		  }
	   }
	    render(view:'paymentReportHWM')    
	 
		
	}
	def searchPaymentNewBMW={

		def payType=params.paymentType
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		def	x = sdfh.parse(params.start_date_value); //Date
		def	y = sdfh.parse(params.end_date_value);  //Date
		session.Datee1=params.start_date_value
		session.Dateee2=params.end_date_value
		java.sql.Date date1 = new java.sql.Date(x.getTime()) 
		java.sql.Date date2 = new java.sql.Date(y.getTime())
		date2.setDate((date2.getDate()+1))
		println('------date1---'+date1)
		println('------date1---'+date2)
		
		def bankTransaction=BankTransactionDetailsBMW.findAll("from BankTransactionDetailsBMW bt where bt.transactionStatus='S' and bt.dateCreated>=? and bt.dateCreated<=? ",[date1,date2])
		
		
		session.listofTransaction=bankTransaction
		
		render(view:'paymentReportBMW',model:[bankTransaction:bankTransaction])
	
	}
	def popBankOnlinePayReportBMW={
		def bankTransaction=session.listofTransaction
		def date1=session.Datee1
		def date2=session.Dateee2
		return[bankTransaction:bankTransaction,date1:date1,date2:date2]
	}
	def searchPaymentNewHWM={


		def payType=params.paymentType
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		def	x = sdfh.parse(params.start_date_value); //Date
		def	y = sdfh.parse(params.end_date_value);  //Date
		session.Datee1=params.start_date_value
		session.Dateee2=params.end_date_value
		java.sql.Date date1 = new java.sql.Date(x.getTime()) 
		java.sql.Date date2 = new java.sql.Date(y.getTime())
		date2.setDate((date2.getDate()+1))
		println('------date1---'+date1)
		println('------date1---'+date2)
		
		def bankTransaction=BankTransactionDetailsHWM.findAll("from BankTransactionDetailsHWM bt where bt.transactionStatus='S' and bt.dateCreated>=? and bt.dateCreated<=? ",[date1,date2])
		
		
		session.listofTransaction=bankTransaction
		
		render(view:'paymentReportHWM',model:[bankTransaction:bankTransaction])
	
		
	}
	def popBankOnlinePayReportHWM={
		def bankTransaction=session.listofTransaction
		def date1=session.Datee1
		def date2=session.Dateee2
		return[bankTransaction:bankTransaction,date1:date1,date2:date2]
	}
	def searchByIndustryTypeWithProductNew={
		if(!session.userMaster){
			session.invalidate()
			redirect(uri:'/index.gsp')
		}
	}
		def searchProdcutDetails={


				try {
					println("=====ds="+params)
					def startDate1=params.start_date_value
			        def endDate1=params.end_date_value
			        def appType=params.appType
			        def status=params.status
			        def indName=params.autocomplete_parameter1
			        def indusName
			        if(params.autocomplete_parameter1=='All'){
			        	indusName="All"
			        }else{
			        	indusName =IndustryTypeMaster.get(indName.toLong()).industryType
			        }
					ArrayList industryTypeList=new ArrayList()
			        def x
			        def y
			        def sdfh = new SimpleDateFormat("dd/MM/yyyy");
			        x = sdfh.parse(startDate1);
			        y = sdfh.parse(endDate1);
			        java.sql.Date sqlDate = new java.sql.Date(x.getTime())
			        java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())
			        java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
			        sqlDate2.setDate((sqlDate2.getDate()+1))
			        String query="";
			        
			        query="select abc  from AllSummaryReport abc where abc.applicationRecieptDate >= '"+sqlDate+"' and abc.applicationRecieptDate <= '"+sqlDate2+"' ";
			      
			        if(params.appType!='All')
			        {
			        	query=query+" and abc.applicationType ='"+appType+"'";
			        } 
			        
			        if(indName !="All")
			        {
			        	query=query+" and abc.indTypeId='"+indName+"'";
			        }else{
			        	query=query+" and cast (abc.indTypeId AS int ) IN (Select mm.id from IndustryTypeMaster mm where mm.dashboard!=0)";
			        }
			        if(status !="All")
			        {
			        	query=query+" and abc.applicationStatus='"+status+"'";
			        }
			        if(params.status =='All' && params.indName =='All')
			        {
			        	query=query;
			        }
			        query=query+" order by abc.applicationRecieptDate desc";
			        println("==query==="+query)
			        industryTypeList=AllSummaryReport.executeQuery(query).unique { user ->
			        user.indRegMasterId
			        };
			        
			        session.sqlDate=sqlDate
			        session.sqlDate2=sqlDate2
			        session.appType=appType;
			        session.industryTypeList=industryTypeList;
			        session.indName=indusName;
			        session.status=status
			        
			        println("===industryTypeList="+industryTypeList)
			        if(sqlDate>sqlDate2)
			        {
			            flash.message="End Date should be Greater than or Equal to Start Date"
			            render(view:'searchByIndustryTypeWithProductNew')
			        }
			        else
			        {
			        	if(industryTypeList.size() == 0)
			        	{
			        		flash.message="No Record Found"
			                render(view:'searchByIndustryTypeWithProductNew')
			                return
			        	}else
			        	{
			        		
			        		
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
			                activityRecInstance.status = "Report Consent Search by Industry Type searchByIndustryTypeWithProductNew "+indName
			                if(activityRecInstance.save()){		   
			                  }
			                	else{
			                		activityRecInstance.errors.each {
			        		    	println it
			        		  }
			        	  }
			                render(view:'searchByIndustryTypeWithProductNew',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,industryTypeList:industryTypeList,indName:indusName])
			        	}
			            
			        }
				} catch(Exception e)
			       {
			       	flash.message="Server is busy ,Please try after some time !" 
			       		e.printStackTrace()                                                                                                                   
			       		if(session.indUser)
			       		  {
			       		   redirect(controller:'indUser',action:'openIndustryHome');				
			       		  }
			       		else if (session.userMaster)
			       		  {
			       		   redirect(controller:'userMaster',action:'openSpcbHome')
			       		  }
			       		else
			       		  {
			       		     session.invalidate()
			       		     redirect(uri:'/index.gsp')
			       		  }
			       }


		}
		
	def popSearchByIndustryTypeExcWithProdNew={

		
		def industryRegMasterList=session.industryTypeList;
		def sqlDate=session.sqlDate;
		def sqlDate2=session.sqlDate2;
		def indName= session.indName;
		
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
	    activityRecInstance.status = "Report Consent Search by Industry Type Print in Excell Click"
	    if(activityRecInstance.save()){		   
	      }
	    	else{
	    		activityRecInstance.errors.each {
		    	println it
		  }
	  }
		render(view:'popSearchByIndustryTypeExcWithProdNew',model:[industryRegMasterList:industryRegMasterList,sqlDate:sqlDate,sqlDate2:sqlDate2,,indName:indName])
				
	}
	def getConsentCertificate={
	response.setContentType("application/json")
	def appid=request.getParameter("app_id")
	def application=IndApplicationDetails.get(appid.toLong())
	String abc=""
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	  
	Response res=new Response()
	if(application){
		String expDate="Not Generated"
		def appPending=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=? and applicationStatus='approved'",[application])
		def recordCerti=RecordCertificate.findByApplicationId(application)
		if(recordCerti){
			expDate=dateFormat.format(recordCerti.endDate)
		}
		if(appPending){
			String occname=application.indUser.occName
			String appdate=dateFormat.format(application.applicationDate)
			String certiexpdate=expDate
			String address="Address: "+application.indUser.indAddress
			String mobileno=application.indUser.occMobile
			String certiUrl="http://localhost:8080/JKPCB/applicationProcessingDetails/openCerificate12/"+application.id.toString()
			abc=res.getjson(occname,appdate,certiexpdate,address,mobileno,certiUrl)		
		}else{
			String msg1="Application not approved by dept."
			String msg="Application Found"
		    abc=res.getNotFindjson(msg,msg1)
		}
	}else{
		String msg="Application not Found"
		String msg1="Invalid Application number. Please send a valid application number."
		abc=res.getNotFindjson(msg,msg1)
	}
	
	render abc
	}
	
	
////==========BMW Report Start by Kripal 
	def monitoringDetailBmwOfficerWise={
   	 try { 
	    	render(view:'monitoringDetailBmwOfficerWise')
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
	
	
	def monitoringDetailBmwOfficerWiseSubmit = {
   	 try { 
   		 println("monitoringDetailBmwOfficerWiseSubmit==> "+params)
	    	def groups=params.groupName
	    	def appFor=params.appFor
	    	if(!groups || !appFor)
	    	{
	    		session.groupList=null
	    		flash.message="Choose group and Application Type"
	    		render(view:'monitoringDetailBmwOfficerWise')
	    	}
	    	else if(groups.getClass().getName()=="java.lang.String")
	    	{
	    		def groupList = new ArrayList()
	    		def groupInstance=GroupMaster.findByGroupName(groups);
	        	if(groupInstance)
	        	{
	        		groupList.add(groupInstance)
	        	}
	    		session.groupList=groupList
	    		render(view:'monitoringDetailBmwOfficerWise',model:[groupList:groupList,appFor:appFor])	
	    	}
	    	else
	    	{
	    		def groupList = new ArrayList()
	    		for(int i = 0 ; i < groups.length; i++ ){
	        		def groupInstance=GroupMaster.findByGroupName(groups[i]);
	        		if(groupInstance)
	        		{
	        			groupList.add(groupInstance)
	        		}
	    		}
	    		session.groupList=groupList
	    		session.appFor=appFor
	    		render(view:'monitoringDetailBmwOfficerWise',model:[groupList:groupList,appFor:appFor])	
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
	
	

    def popMonitoringDetailBmwOfficerWise={
   	 try { 
   		 println("popMonitoringDetailBmwOfficerWise=> "+params)
   	    def groupList=session.groupList
   	    def appFor=params.appFor
   	    println("appFor=> "+appFor)
   		render(view:'popMonitoringDetailBmwOfficerWise',model:[groupList:groupList,appFor:appFor]) 

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
    
    def popMonitoringDetailBmwOfficerWiseExc={
   	 try { 
	    	def groupList=session.groupList
	    	   def appFor=params.appFor
		    render(view:'popMonitoringDetailBmwOfficerWiseExc',model:[groupList:groupList,appFor:appFor]) 
	   } catch(Exception e) {
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
				def days = 0
				def reportType=params.reportType
	            if(params.days){
	                 days = (params.days).toInteger()
	            }
	            def days1 = (params.days1).toInteger()
	            def a= params.a
	            def appFor= params.appFor
	            long  diff = 0
	            int diffDays = 0
	          //  def appFor=session.appFor
	            def applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where  abc.applicationStatus='pending' and  abc.applicationFor=? and abc.roleId=? ",[appFor,(params.id).toString()])
	            def applicationTotalInstanceNew =new ArrayList()
	            if(reportType=="type6")
	            {
	            	applicationTotalInstanceNew=applicationTotalInstance
	            }
	            else
	            {
	            	for(int ip =0; ip<applicationTotalInstance.size(); ip++)
	                {
	                   def  appRecieveDate = applicationTotalInstance.get(ip).recieptDate
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
	
	// officerIDStatusWaste
	def officerIDStatusWaste={
		
    	if(!session.userMaster){
            redirect(uri:"/index.gsp")
    	}else{
            def aa1 = session.userMaster
            def checkAdmin = aa1.accessLevel
            def officerId=""
            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
            	if(checkAdmin.equals('employee')){
            		officerId=aa1.id
            		
            	}
                render(view:'officerIDStatusWaste',model:[officerId:officerId])
            }
            else{
            	redirect(uri:"/index.gsp")
            }
        }
     
	}
	
	def searchByOfficerIDStatusWaste={

    	println("searchByOfficerIDStatusWaste params ==> "+params)
    	def appSummary
		def startDate1=params.start_date_value
		def endDate1=params.end_date_value
		def officerID=params.officerID
		def appFor=params.appFor
		def x
		def y
		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		x = sdfh.parse(startDate1); //Date
		y = sdfh.parse(endDate1);
		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
		sqlDate2.setDate((sqlDate2.getDate()+1))
		session.sqlDate=sqlDate
		session.sqlDate2=sqlDate2
		session.sqlDate3=sqlDate3
		session.officerID=officerID
    	if(sqlDate>sqlDate2){
		
			flash.message="End Date should be Greater than Starting Date"
				render(view:'officerIDStatusWaste')
				return;
		}else{
		
    		appSummary = WasteManagementProcessingDetails.executeQuery("select distinct applicationFor , applicationId from WasteManagementProcessingDetails dateCheck1 where  (dateCheck1.officer = ? OR dateCheck1.officerFwd = ? ) and dateCheck1.applicationFor=?  and  dateCheck1.dateCreated >=? and dateCheck1.dateCreated <=? ",  [officerID.trim(),officerID.trim(),appFor,sqlDate,sqlDate2] );
    		println("appSummary waste ==> "+appSummary)
    		def appSummaryList=new ArrayList();
    		if(appSummary){
    			for(int i=0;i<appSummary.size();i++){
    				def single=appSummary.get(i)
    				def application=null;
    				println("single => "+single)
    				if(single[0]=="BMW"){
    					application=BioMedicalWaste.get(single[1].toLong())
    				}else if(single[0]=="HWM"){
    					application=HazardeousWasteAuthApp.get(single[1].toLong())
    				}else if(single[0]=="PWM"){
    					application=PlasticWaste.get(single[1].toLong())
    				}else if(single[0]=="MSW"){
    					application=MunicipalSolidWaste.get(single[1].toLong())
    				}
    				println("application=> "+application)
    				if(application){
    					appSummaryList.add(application);
    				}
    			}
    		}
    		session.appSummary=appSummaryList
    		
    		def aa1 = session.userMaster
            def checkAdmin = aa1.accessLevel
            def officerId=""
            if ((checkAdmin.equals('admin'))||(checkAdmin.equals('employee'))){
            	if(checkAdmin.equals('employee')){
            		officerId=aa1.id
            		
            	}
            }
    		session.sqlDate3=sqlDate3
    		session.sqlDate=sqlDate
    		session.sqlDate2=sqlDate2
    		session.officerId=officerId
    		session.officerID=officerID
    		session.appFor=appFor
    		
    		
    		render(view:'officerIDStatusWaste',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummaryList,officerId:officerId,officerID:officerID,appFor:appFor])
    		return;
		}	
    
	}
	
	def popByOfficerIDStatusWaste={
		def appSummary=session.appSummary
		def sqlDate3=session.sqlDate3
		def sqlDate=session.sqlDate
		def sqlDate2=session.sqlDate2
		def officerId=session.officerId
		def officerID=session.officerID
		def appFor=session.appFor
		[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary,officerId:officerId,officerID:officerID,appFor:appFor]
	}
	def popByOfficerIDStatusWasteExc={
		def appSummary=session.appSummary
		def sqlDate3=session.sqlDate3
		def sqlDate=session.sqlDate
		def sqlDate2=session.sqlDate2
		def officerId=session.officerId
		def officerID=session.officerID
		def appFor=session.appFor
		[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,appSummary:appSummary,officerId:officerId,officerID:officerID,appFor:appFor]
	}
	
	
	//reprot wasteAuthorizationCateWise
	def wasteAuthorizationCateWise={
		
	}
    def authorizationCateWiseSubmit={
		println("authorizationCateWiseSubmit==> "+params)
   		def startDate1=params.start_date_value
   		def endDate1=params.end_date_value
   		def appFor=params.appFor
   		def x
   		def y
   		def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
   		x = sdfh.parse(startDate1); //Date
   		y = sdfh.parse(endDate1);
   		def  newGroupList = DistrictMaster.list()
   		def groupList = new ArrayList()
   		for(int i = 0 ; i < newGroupList.size(); i++ ){
   			groupList.add(newGroupList[i])
   		}
   		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
   		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
   		java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
   		sqlDate2.setDate((sqlDate2.getDate()+1))
   		session.groupList=groupList
   		session.sqlDate=sqlDate
   		session.sqlDate2=sqlDate2
   		session.sqlDate3=sqlDate3
   		session.appFor=appFor
       	if(sqlDate>sqlDate2)
   		{
   			flash.message="End Date should be Greater than Starting Date"
   				render(view:'wasteAuthorizationCateWise')
   		}
       	else
   		{
   			render(view:'wasteAuthorizationCateWise',model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,appFor:appFor])
   		}	
       }
	
	def popWasteAuthorizationCateWise={
		def groupList=session.groupList
   		def sqlDate=session.sqlDate
   		def sqlDate2=session.sqlDate2
   		def sqlDate3=session.sqlDate3
   		def appFor=session.appFor
   		
   		[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,appFor:appFor]
	}
	def popWasteAuthorizationCateWiseExc={
		def groupList=session.groupList
   		def sqlDate=session.sqlDate
   		def sqlDate2=session.sqlDate2
   		def sqlDate3=session.sqlDate3
   		def appFor=session.appFor
   		
   		[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2,groupList:groupList,appFor:appFor]
	}
	
	def getTotAppCategoryWise = {
		 try {
			 println("getTotAppCategoryWise params..."+params)
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
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.categoryName=? and abc.pendingSince >= ? and abc.pendingSince <= ? and abc.applicationFor=?",[(params.districtId).toString(),cat,sqlDate,sqlDate2,appType])	
				}else if(certFor=="new"){
				applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.applicationFor=? and (abc.authorizationtype='Fresh' or abc.authorizationtype='fresh') and abc.categoryName=? and abc.pendingSince >= ? and abc.pendingSince <= ? ",[(params.districtId).toString(),appType,cat,sqlDate,sqlDate2])	
				}else if(certFor=="reNew"){
				applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.applicationFor=? and  (abc.authorizationtype='renew' or abc.authorizationtype='Renew')  and abc.categoryName=? and abc.pendingSince >= ? and abc.pendingSince <= ? ",[(params.districtId).toString(),appType,cat,sqlDate,sqlDate2])	
				}
				render(view:'getTotAppCategoryWise',model:[allSummaryReportList:applicationTotalInstance,appType:appType])
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
					applicationTotalInstance = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.districtId=? and abc.applicationStatus='approved' and abc.pendingSince >= ? and abc.pendingSince <= ? and abc.authorizationtype IN ('Fresh','fresh','Renew','renew') and abc.applicationFor=?",[(params.districtId).toString(),sqlDate,sqlDate2,appType])	
					
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
	
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    def consentAutoRenewalDetails = {// method for get all Industry list page 
        	println("params "+params)
        	if(!session.userMaster)
        	{
                redirect(uri:"/index.gsp")
        	}
        	else
        	{
                def aa1 = session.userMaster

                def checkAdmin = aa1.accessLevel
                if ((checkAdmin.equals('admin')))
                {
                	def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
                    def groupList = new ArrayList()
                    for(int i = 0 ; i < newGroupList.size(); i++ )
                    {
    	                if(!(newGroupList[i].groupName=="Industry"))
    	                {
    	    	        groupList.add(newGroupList[i])
    	                }
                    }
                    render(view:'consentAutoRenewalDetails',model:[groupList:groupList])
                }
                else if (checkAdmin.equals('employee'))
                {
                	 
                	 def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
                     def groupList = new ArrayList()
                     for(int i = 0 ; i < newGroupList.size(); i++ )
                     {
     	                if(!(newGroupList[i].groupName=="Industry"))
     	                {
     	    	        groupList.add(newGroupList[i])
     	                }
                     }
                     render(view:'consentAutoRenewalDetails',model:[groupList:groupList])
                }
                else{
                	redirect(uri:"/index.gsp")
                }
              
            }
		}
    
    def consentAutoRenewalRecord = {// method for get all application list group wise report 2
    	
    	println(" ** params: "+params)
	
    def searchOp=params.searchOp
    def indTypeInstance
    def allSummaryReportList
    def xyz5
	def qwe
	def type=params.type
	if(searchOp=="industryType"){
		
	}else{
		println("hhhhhhhhhhhhh ")
		def startDate1=params.start_date_value
    	def endDate1=params.end_date_value
    	
    	def x
    	def y
    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    	x = sdfh.parse(startDate1); //Date
    	y = sdfh.parse(endDate1);
    	
    	java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    	java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    	java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
    	sqlDate2.setDate((sqlDate2.getDate()+1))

    	session.sqlDate=sqlDate
    	session.sqlDate2=sqlDate2
    	if(sqlDate>sqlDate2)
    	{
    		println("ggggggggggggg")
    		flash.message="End Date should be Greater than Starting Date"
    			render(view:'consentAutoRenewalDetails')
    	}
    	else
    	{
    		println("sqlDate "+sqlDate)
    		println("sqlDate2 "+sqlDate2)
    		println("sqlDate3 "+sqlDate3)
    		session.indTypeInstance=indTypeInstance
    		
    		if(type=="Preview"){
    			println("Preview=> "+type)
    			render(view:'popConsentAutoRenewalDetails',model:[indTypeInstance:indTypeInstance,sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2])
    			return;
    		}else if(type=="Excel"){
    			println("Excel=> "+type)
    			render(view:'popConsentAutoRenewalDetailsExl',model:[indTypeInstance:indTypeInstance,sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2])
    			return;
    		}else{
    			render(view:'consentAutoRenewalDetails',model:[indTypeInstance:indTypeInstance,sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2])
    			return;
    		}
    		
    	}	
	}
			
	}
	 def popConsentAutoRenewalReport = {
    	def sqlDate=session.sqlDate
    	def sqlDate2=session.sqlDate2
    	def sqlDate3
    	if(sqlDate2)
    	sqlDate3=sqlDate2-1
   	render(view:'popConsentAutoRenewalReport' ,model:[sqlDate3:sqlDate3,sqlDate:sqlDate,sqlDate2:sqlDate2])
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
	////==========BMW Report End  by Kripal }