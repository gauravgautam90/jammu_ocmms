import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NoticeReminderController {
	
	
	
 def abcTest={
	println("--calling ABC-")
}
 
 
	def sendStatusToSingle = {
		 
		 println("Inside send Status To Single Window ---------")

    			
    	 	def failedStausList =SingleWindowStatus.list()    
	
    //		 println("failedStausList---------"+failedStausList.size())
    		    if(failedStausList){
    		    	
    			for(int i=0;i<failedStausList.size();i++){
    				
    				def resonseCode=failedStausList[i].responce
    				def dateCreated =failedStausList[i].createdDate
    				def appId=failedStausList[i].appId
    		/*		println("resonseCode---"+resonseCode)
    				println("dateCreated---"+dateCreated)
    				println("appId---"+appId)*/
    					
    				Date today = new Date();
	    			long diff2 = today.getTime() - dateCreated.getTime();
	    			int diffDays2=diff2 / (10006060*24) +1;
	    			
    				def resonseCode1 ='{"status":"success","message":" Application status added successfully"}';
    				def resonseCode2 ='{"STATUS":412,"MSG":"No Application Found for the user","RESPONSE":"Condition Failed"}';
    				//println("====Submit failed days ==="+diffDays2)
    				if(diffDays2<=1){
    				     
                   	  if( resonseCode != resonseCode1 ){
                   		 println("inside--if----resonseCode != resonseCode1-------")
    				     Response response=new Response();    				     
    			         response.reSendStatus(failedStausList[i].appId,failedStausList[i].cafNo,failedStausList[i].serviceId,failedStausList[i].applicationType,failedStausList[i].applicationFor,failedStausList[i].statusCode,failedStausList[i].appRemarks,failedStausList[i].pendingWith,failedStausList[i].pendingWithRole,failedStausList[i].printAppUrl,failedStausList[i].revertedUrl,failedStausList[i].certificateUrl);    				
    			//	     response.updateStatus(failedStausList[i].appId,'{"status":"success","message":" Application status added successfully"}');
    				  }else{
    					       println("inside--elseeeeeeeee-single wondow status ------")
    				  }
    				}

    			}
    		
             }
	}
   		def clarificationCONSENT = {/*  
				try {
				    println("==========Inside clarificationCONSENT=========")
				    def indAppList = IndApplicationDetails.findAll("from IndApplicationDetails appProces where clarification='true' order by appProces.id desc")
				    long diff10 = 0
		            int diffDays10 = 0
		            int val = 30;
					println("==========clarificationCONSENT Size========="+indAppList.size());
				    if(indAppList)
				    {
				    	for(int i=0;i<indAppList.size();i++)
						{
							
							def indAppIns=indAppList.get(i);
							def appId=indAppIns.id;
							def clarificatonInstance=ApplicationProcessingDetails.find("from ApplicationProcessingDetails ind where ind.application.id=? and ind.clarification='true' and ind.noticeType='Clarification' order by ind.id desc",[appId.toLong()])
							if(clarificatonInstance)
							{
								 def dateCreated=clarificatonInstance.dateCreated;
					    		 Date today = new Date();
					    		 diff10 = today.getTime() - dateCreated.getTime();
					    		 diffDays10=diff10 / (1000*60*60*24) +1;
					    		 if(diffDays10 >= val)
					    		 {
					    			 
					    			 	def appProcessing = new ApplicationProcessingDetails();
					    		      	appProcessing.clarificationReplyAttachedFile=false;
					    		      	appProcessing.role = RoleMaster.findByRoleName("Industry")
					    				appProcessing.application = indAppIns;
					    				appProcessing.approve = false
					    				appProcessing.approveNote=""
					    				appProcessing.clarification=false
					    				appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application";
										appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application";
					    				appProcessing.resubmitStatus=false
					    				appProcessing.returned=false
					    				appProcessing.inspection=false
					    				appProcessing.inspectionClose=false
					    				appProcessing.inspectionCloseNote=""
					    				appProcessing.inspectionNote=""
					    				appProcessing.roleFwd = RoleMaster.findByRoleName("Industry");
					    				appProcessing.officer = "SPCB"
					    				appProcessing.officerFwd = "SPCB"
					    				appProcessing.reject = false
					    				appProcessing.rejectNote = ""
					    				appProcessing.returnNote= " "
					    				appProcessing.scrutinyStatus = ""
					    				appProcessing.scrutinyDescription = ""
					    				appProcessing.noticeType = "Clarification"
					    				if(appProcessing.save()){
					    					
					    					println("appProcessing.save()   true")
					    					indAppIns.clarification=false;
					    					indAppIns.save(flush:true);
					    					
					    					def applicationPendingInstanse=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=? ",[indAppIns]);
					    					if(applicationPendingInstanse)
					    					{
					    						applicationPendingInstanse.applicationStatus="rejected";
					    						applicationPendingInstanse.save(flush:true);
					    					}
					    				}
					    				else{
					    					println("appProcessing.save()   false")
					    					appProcessing.errors.each {
					    					println it
					    				 }
					    			   }
					    			   def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(indAppIns.id).toString()]);
					   				   if(allSummaryReportInstance)
					   					{		
					   					  allSummaryReportInstance.clarificationSubmitDt=new Date();
					   					  allSummaryReportInstance.applicationStatus="rejected";
					   					  if(!allSummaryReportInstance.hasErrors() && allSummaryReportInstance.save(flush:true)) 
					   					    {
					   						  
					   					    }
					   					    else {
					   						    allSummaryReportInstance.errors.each {
					   					        println it
					   						   }
					   					   }
					   				  }
					    		 } 
							}	
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
		    */}
	
	def showCauseCONSENT = {/*  
                try {
                    println("==========Inside clarificationCONSENT=========")
                    def indAppList = IndApplicationDetails.findAll("from IndApplicationDetails appProces where showCause='true' order by appProces.id desc")
                    long diff10 = 0
                    int diffDays10 = 0
                    int val = 30;
                    println("==========showCauseCONSENT Size========="+indAppList.size());
                    if(indAppList)
                    {
                        for(int i=0;i<indAppList.size();i++)
                        {
                            
                            def indAppIns=indAppList.get(i);
                            def appId=indAppIns.id;
                            def clarificatonInstance=ApplicationProcessingDetails.find("from ApplicationProcessingDetails ind where ind.application.id=? and ind.clarification='true' and ind.noticeType='Show Cause' order by ind.id desc",[appId.toLong()])
                            if(clarificatonInstance)
                            {
                                 def dateCreated=clarificatonInstance.dateCreated;
                                 Date today = new Date();
                                 diff10 = today.getTime() - dateCreated.getTime();
                                 diffDays10=diff10 / (1000*60*60*24) +1;
                                 if(diffDays10 >= val)
                                 {
                                     
                                        def appProcessing = new ApplicationProcessingDetails();
                                        appProcessing.clarificationReplyAttachedFile=false;
                                        appProcessing.role = RoleMaster.findByRoleName("Industry")
                                        appProcessing.application = indAppIns;
                                        appProcessing.approve = false
                                        appProcessing.approveNote=""
                                        appProcessing.clarification=false
                                        appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application";
                                        appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application";
                                        appProcessing.resubmitStatus=false
                                        appProcessing.returned=false
                                        appProcessing.inspection=false
                                        appProcessing.inspectionClose=false
                                        appProcessing.inspectionCloseNote=""
                                        appProcessing.inspectionNote=""
                                        appProcessing.roleFwd = RoleMaster.findByRoleName("Industry");
                                        appProcessing.officer = "SPCB"
                                        appProcessing.officerFwd = "SPCB"
                                        appProcessing.reject = false
                                        appProcessing.rejectNote = ""
                                        appProcessing.returnNote= " "
                                        appProcessing.scrutinyStatus = ""
                                        appProcessing.scrutinyDescription = "";
                                        appProcessing.noticeType = "Show Cause"
                                        if(appProcessing.save()){
                                            
                                            println("appProcessing.save()   true")
                                            indAppIns.showCause=false;
                                            indAppIns.save(flush:true);
                                            
                                            def applicationPendingInstanse=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=? ",[indAppIns]);
                                            if(applicationPendingInstanse)
                                            {
                                                applicationPendingInstanse.applicationStatus="rejected";
                                                applicationPendingInstanse.save(flush:true);
                                            }
                                        }
                                        else{
                                            println("appProcessing.save()   false")
                                            appProcessing.errors.each {
                                            println it
                                         }
                                       }
                                       def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(indAppIns.id).toString()]);
                                       if(allSummaryReportInstance)
                                        {       
                                          allSummaryReportInstance.clarificationSubmitDt=new Date();
                                          allSummaryReportInstance.applicationStatus="rejected";
                                          if(!allSummaryReportInstance.hasErrors() && allSummaryReportInstance.save(flush:true)) 
                                            {
                                              
                                            }
                                            else {
                                                allSummaryReportInstance.errors.each {
                                                println it
                                               }
                                           }
                                      }
                                 } 
                            }   
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
            */}
           
	
   		def clarificationHWM = {/*  
			
   				println("==========Inside clarificationHWM=========")
   			    def hazardousWasteInstanse= HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp hwaapp where hwaapp.clarification='t' order by hwaapp.id desc ")
   				println("==========hazardousWasteInstanse Size HWM========="+hazardousWasteInstanse.size());
   				for(int i=0;i<hazardousWasteInstanse.size();i++)
   				{
   					def abc=hazardousWasteInstanse.get(i);
   					println("HWM ID clarificationHWM-----"+abc);
   					def wasteProcessingInstanse = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails appProces where appProces.applicationId=? and appProces.clarification='t' order by appProces.id desc",[hazardousWasteInstanse.get(i).toString()])
   					def wasteProcessingSingleInstanse=wasteProcessingInstanse;
   					println("==========wasteProcessingSingleInstanse========="+wasteProcessingSingleInstanse)
   					if(wasteProcessingSingleInstanse)
   					  {
   						//println("==========helloo=========")
   						
   						long diff = 0
   			            int diffDays = 0
   			            def dateCreated=wasteProcessingSingleInstanse.dateCreated;
   						//println("==========wwwww========="+dateCreated)
   						Date today = new Date();
   						diff = today.getTime() - dateCreated.getTime();
   						diffDays=diff / (1000*60*60*24) +1
   		    			println("==========Diffrense Days HWM========="+diffDays)
   		    			if(diffDays >=30)
   		    			{
   		    				
   		    				def wastemanagementPendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? order by wmpd.id desc ",[(abc.id).toString()],[max:1])
   		    	        	def pendingInstance=wastemanagementPendingInstance[0]
   		    	        	def appProcessing = new WasteManagementProcessingDetails();
   		    				
   		    					def appFor=pendingInstance.applicationFor;
   		    					appProcessing.noticeType="industry reply"
   		                		appProcessing.scrutinyStatus=""
                                appProcessing.scrutinyDescription=""
                                appProcessing.approvalStatus=""
                                appProcessing.role = RoleMaster.findByRoleName("Industry")
                                appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
                                appProcessing.officer ="SPCB"
                                appProcessing.officerFwd = "SPCB"
                                appProcessing.applicationId = (abc.id).toString();
                                appProcessing.applicationFor =appFor
                                appProcessing.clarificationDays = ""
                                appProcessing.inspection = false
                                appProcessing.inspectionNote = ""
                                appProcessing.inspectionClose = false
                                appProcessing.inspectionCloseNote = ""
                                appProcessing.approve = false
                                appProcessing.approveNote = ""
                                appProcessing.reject =  false
                                appProcessing.rejectNote = ""
                                appProcessing.returned = false
                                appProcessing.returnNote = ""
                                appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.clarificationReplyAttachedFile=false;
                                appProcessing.resubmitStatus=false;
   		                	
   		                	if(appProcessing.save()){
   		                		println("Saved note history")
   		                		abc.clarification = false;
   	   		    				if(abc.save()){
   	   		    					println("abc.save()   true")
   	   		    				}
   	   		    				else{
   	   		    					println("abc.save()   false")
   	   		    					abc.errors.each {
   	   		    					println it
   	   		    				  }
   	   		    			    }
   	   		    				
   	   		    			def applicationPendingInstanse=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=? ",[(abc.id).toString()]);
                            if(applicationPendingInstanse)
                            {
                            	applicationPendingInstanse.applicationStatus="rejected";
                            	applicationPendingInstanse.save(flush:true);
                            }
   	   		    				
   		                	}else{
   		                		appProcessing.errors.each {
   		            		        println it
   		            			}
   		                		println("Not saved")
   		                	}
   		                	
   		                	
   		                	def sdfh123 = new SimpleDateFormat("dd/MM/yyyy"); 
   		    				def AllSummaryReportInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(abc.id).toString()]);
   		    				if(AllSummaryReportInstance)
   		    				{
   		    					AllSummaryReportInstance.clarificationReplyDate = sdfh123.format(new Date());
   		    					AllSummaryReportInstance.clarification = false;
   		    					AllSummaryReportInstance.applicationStatus="rejected";
   		    					AllSummaryReportInstance.save();
   		    				}
   		    		   }
   			       }
   			  }	
		*/}
	
	
   		def clarificationBMW = 
   			    {/*  
   				println("==========Inside clarificationBMW=========");
   				def bioMedicalWasteInstanse= BioMedicalWaste.findAll("from BioMedicalWaste hwaapp where hwaapp.clarification='t' order by hwaapp.id desc ")
   				println("==========clarificationBMW Size========="+bioMedicalWasteInstanse.size())
   				for(int i=0;i<bioMedicalWasteInstanse.size();i++)
   				{
   					def abc=bioMedicalWasteInstanse.get(i);
   					println("BMW ID clarificationHWM-----"+abc);
   					def wasteProcessingInstanse = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails appProces where appProces.applicationId=? and appProces.clarification='t' order by appProces.id desc",[bioMedicalWasteInstanse.get(i).toString()])
   					def wasteProcessingSingleInstanse=wasteProcessingInstanse;
   					println("==========wasteProcessingSingleInstanse BMW========="+wasteProcessingSingleInstanse)
   					if(wasteProcessingSingleInstanse)
   					  {
   						//println("==========helloo=========")
   						long diff = 0
   			            int diffDays = 0
   			            def dateCreated=wasteProcessingSingleInstanse.dateCreated;
   						//println("==========wwwww========="+dateCreated)
   						Date today = new Date();
   						diff = today.getTime() - dateCreated.getTime();
   						diffDays=diff / (1000*60*60*24) +1
   		    			println("==========Diffrense Days BMW========="+diffDays)
   		    			if(diffDays >=30)
   		    			{
   		    				def wastemanagementPendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? order by wmpd.id desc ",[(abc.id).toString()],[max:1])
   		    	        	def pendingInstance=wastemanagementPendingInstance[0]
   		    	        	def appProcessing = new WasteManagementProcessingDetails();
   		    				
   		    					def appFor=pendingInstance.applicationFor;
   		    					appProcessing.noticeType="industry reply"
                                appProcessing.scrutinyStatus=""
                                appProcessing.scrutinyDescription=""
                                appProcessing.approvalStatus=""
                                appProcessing.role = RoleMaster.findByRoleName("Industry")
                                appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
                                appProcessing.officer ="SPCB"
                                appProcessing.officerFwd = "SPCB"
                                appProcessing.applicationId = (abc.id).toString();
                                appProcessing.applicationFor =appFor
                                appProcessing.clarificationDays = ""
                                appProcessing.inspection = false
                                appProcessing.inspectionNote = ""
                                appProcessing.inspectionClose = false
                                appProcessing.inspectionCloseNote = ""
                                appProcessing.approve = false
                                appProcessing.approveNote = ""
                                appProcessing.reject =  false
                                appProcessing.rejectNote = ""
                                appProcessing.returned = false
                                appProcessing.returnNote = ""
                                appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.clarificationReplyAttachedFile=false;
                                appProcessing.resubmitStatus=false;
   		                	
   		                	  if(appProcessing.save()){
   		                		  println("Saved note history IN BMW" )
   		                		  abc.clarification = false;
   	   		    				if(abc.save()){
   	   		    					println("abc.save()   true")
   	   		    				}
   	   		    				else{
   	   		    					println("abc.save()   false")
   	   		    					abc.errors.each {
   	   		    					println it
   	   		    				  }
   	   		    			    }
   	   		    				
   	   		    			def applicationPendingInstanse=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=? ",[(abc.id).toString()]);
                            if(applicationPendingInstanse)
                            {
                                applicationPendingInstanse.applicationStatus="rejected";
                                applicationPendingInstanse.save(flush:true);
                            }
   	   		    				
   	   		    				
   	   		    				
   	   		    				
   		                	}else{
   		                		appProcessing.errors.each {
   		            		        println it
   		            			}
   		                		println("Not saved IN BMW")
   		                	}
   		                	
   		                	def sdfh123 = new SimpleDateFormat("dd/MM/yyyy"); 
   		    				def AllSummaryReportInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(abc.id).toString()]);
   		    				if(AllSummaryReportInstance)
   		    				{
   		    					AllSummaryReportInstance.clarificationReplyDate = sdfh123.format(new Date());
   		    					AllSummaryReportInstance.applicationStatus="rejected";
   		    					AllSummaryReportInstance.clarification = false;
   		    					AllSummaryReportInstance.save();
   		    				}
   		    		   }
   			       }
   			  }	
   	    */}
   	    
   	    
		def clarificationHWMANNUALRETURN = 
   	    	{/*  
   			//	println("==========Inside clarificationHWMANNUALRETURN=========");
   	    		def hazardeousAnnualReturnDetailsInstanse= HazardeousAnnualReturnDetails.findAll("from HazardeousAnnualReturnDetails hwaapp where hwaapp.clarification='t' order by hwaapp.id desc ")
   				//println("==========clarificationHWMANNUALRETURN Size========="+clarificationHWMANNUALRETURN.size())
   				for(int i=0;i<hazardeousAnnualReturnDetailsInstanse.size();i++)
   				{
   					def abc=hazardeousAnnualReturnDetailsInstanse.get(i)
   					def wasteProcessingInstanse = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails appProces where appProces.applicationId=? and appProces.clarification='t' order by appProces.id desc",[hazardeousAnnualReturnDetailsInstanse.get(i).toString()])
   					def wasteProcessingSingleInstanse=wasteProcessingInstanse;
   					//println("==========wasteProcessingSingleInstanse========="+wasteProcessingSingleInstanse)
   					if(wasteProcessingSingleInstanse)
   					  {
   						//println("==========helloo=========")
   						
   						long diff = 0
   			            int diffDays = 0
   			            def dateCreated=wasteProcessingSingleInstanse.dateCreated;
   						///println("==========wwwww========="+dateCreated)
   						Date today = new Date();
   						diff = today.getTime() - dateCreated.getTime();
   						diffDays=diff / (1000*60*60*24) +1
   		    			//println("==========Diffrense Days HWM========="+diffDays)
   		    			if(diffDays >=30)
   		    			{
   		    				def wastemanagementPendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? order by wmpd.id desc ",[(abc.id).toString()],[max:1])
   		    	        	def pendingInstance=wastemanagementPendingInstance[0]
   		    	        	def appProcessing = new WasteManagementProcessingDetails();
   		    				
   		    				def appFor=pendingInstance.applicationFor;
   		    				appProcessing.clarificationReplyAttachedFile=false
   		    				appProcessing.role =RoleMaster.findByRoleName("Industry");
   		                	appProcessing.officer = "SPCB"
   		                	appProcessing.roleFwd = RoleMaster.findByRoleName("Industry");
   		                	appProcessing.officerFwd = "SPCB"
   		                	appProcessing.approvalStatus = "";
   		    				appProcessing.clarification = false
   		    				appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   							appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   		    				appProcessing.inspection = false
   		                	appProcessing.inspectionNote = ""
   		                	appProcessing.inspectionClose = false
   		                	appProcessing.inspectionCloseNote = ""
   		                	appProcessing.approve = false
   		                	appProcessing.approveNote = ""
   		                	appProcessing.reject =  false
   		                	appProcessing.rejectNote = ""
   		                	appProcessing.applicationId = (abc.id).toString();
   		                	appProcessing.applicationFor =appFor;
   		                	
   		                	appProcessing.noticeType="industry reply"
                                appProcessing.scrutinyStatus=""
                                appProcessing.scrutinyDescription=""
                                appProcessing.approvalStatus=""
                                appProcessing.role = RoleMaster.findByRoleName("Industry")
                                appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
                                appProcessing.officer ="SPCB"
                                appProcessing.officerFwd = "SPCB"
                                appProcessing.applicationId = (abc.id).toString();
                                appProcessing.applicationFor =appFor
                                appProcessing.clarificationDays = ""
                                appProcessing.inspection = false
                                appProcessing.inspectionNote = ""
                                appProcessing.inspectionClose = false
                                appProcessing.inspectionCloseNote = ""
                                appProcessing.approve = false
                                appProcessing.approveNote = ""
                                appProcessing.reject =  false
                                appProcessing.rejectNote = ""
                                appProcessing.returned = false
                                appProcessing.returnNote = ""
                                appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.clarificationReplyAttachedFile=false;
                                appProcessing.resubmitStatus=false;
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	if(appProcessing.save()){
   		                		//println("Saved note history")
   		                		abc.clarification = false;
   	   		    				if(abc.save()){
   	   		    					//println("abc.save()   true")
   	   		    				}
   	   		    				else{
   	   		    					//println("abc.save()   false")
   	   		    					abc.errors.each {
   	   		    					println it
   	   		    				  }
   	   		    			    }
   	   		    				
   	   		    				
   	   		    				
   	   		    			def applicationPendingInstanse=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=? ",[(abc.id).toString()]);
                            if(applicationPendingInstanse)
                            {
                                applicationPendingInstanse.applicationStatus="rejected";
                                applicationPendingInstanse.save(flush:true);
                            }
   	   		    			}else{
   		                		appProcessing.errors.each {
   		            		        println it
   		            			}
   		                		//println("Not saved")
   		                	}
   		                	
   		                	def sdfh123 = new SimpleDateFormat("dd/MM/yyyy"); 
   		    				def AllSummaryReportInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(abc.id).toString()]);
   		    				if(AllSummaryReportInstance)
   		    				{
   		    					AllSummaryReportInstance.clarificationReplyDate = sdfh123.format(new Date());
   		    					AllSummaryReportInstance.clarification = false;
   		    					AllSummaryReportInstance.applicationStatus="rejected";
   		    					AllSummaryReportInstance.save();
   		    				}
   		    		   }
   			       }
   			  }	
   	    */}
   	    
   		def clarificationBMWANNUALRETURN = 
   	    {/*  
   				///println("==========Inside clarificationBMWANNUALRETURN=========");
   				def bmwRenewInstanse= BmwRenew.findAll("from BmwRenew hwaapp where hwaapp.clarification='t' order by hwaapp.id desc ")
   				//println("==========clarificationBMWANNUALRETURN.size========="+bmwRenewInstanse.size())
   				for(int i=0;i<bmwRenewInstanse.size();i++)
   				{
   					def abc=bmwRenewInstanse.get(i)
   					def wasteProcessingInstanse = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails appProces where appProces.applicationId=? and appProces.clarification='t' order by appProces.id desc",[bmwRenewInstanse.get(i).toString()])
   					def wasteProcessingSingleInstanse=wasteProcessingInstanse;
   					//println("==========wasteProcessingSingleInstanse========="+wasteProcessingSingleInstanse)
   					if(wasteProcessingSingleInstanse)
   					  {
   					//	println("==========helloo=========")
   						
   						long diff = 0
   			            int diffDays = 0
   			            def dateCreated=wasteProcessingSingleInstanse.dateCreated;
   						//println("==========wwwww========="+dateCreated)
   						Date today = new Date();
   						diff = today.getTime() - dateCreated.getTime();
   						diffDays=diff / (1000*60*60*24) +1
   		    			//println("==========Diffrense Days HWM========="+diffDays)
   		    			if(diffDays >=30)
   		    			{
   		    				def wastemanagementPendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? order by wmpd.id desc ",[(abc.id).toString()],[max:1])
   		    	        	def pendingInstance=wastemanagementPendingInstance[0]
   		    	        	def appProcessing = new WasteManagementProcessingDetails();
   		    				def appFor=pendingInstance.applicationFor;
   		    				appProcessing.clarificationReplyAttachedFile=false
   		    				appProcessing.role =RoleMaster.findByRoleName("Industry");
   		                	appProcessing.officer = "SPCB"
   		                	appProcessing.roleFwd = RoleMaster.findByRoleName("Industry");
   		                	appProcessing.officerFwd = "SPCB"
   		                	appProcessing.approvalStatus = "";
   		    				appProcessing.clarification = false
   		    				appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   							appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   		    				appProcessing.inspection = false
   		                	appProcessing.inspectionNote = ""
   		                	appProcessing.inspectionClose = false
   		                	appProcessing.inspectionCloseNote = ""
   		                	appProcessing.approve = false
   		                	appProcessing.approveNote = ""
   		                	appProcessing.reject =  false
   		                	appProcessing.rejectNote = ""
   		                	appProcessing.applicationId = (abc.id).toString();
   		                	appProcessing.applicationFor =appFor;
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                	
   		                		appProcessing.noticeType="industry reply"
                                appProcessing.scrutinyStatus=""
                                appProcessing.scrutinyDescription=""
                                appProcessing.approvalStatus=""
                                appProcessing.role = RoleMaster.findByRoleName("Industry")
                                appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
                                appProcessing.officer ="SPCB"
                                appProcessing.officerFwd = "SPCB"
                                appProcessing.applicationId = (abc.id).toString();
                                appProcessing.applicationFor =appFor
                                appProcessing.clarificationDays = ""
                                appProcessing.inspection = false
                                appProcessing.inspectionNote = ""
                                appProcessing.inspectionClose = false
                                appProcessing.inspectionCloseNote = ""
                                appProcessing.approve = false
                                appProcessing.approveNote = ""
                                appProcessing.reject =  false
                                appProcessing.rejectNote = ""
                                appProcessing.returned = false
                                appProcessing.returnNote = ""
                                appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                                appProcessing.clarificationReplyAttachedFile=false;
                                appProcessing.resubmitStatus=false;
   		                	if(appProcessing.save()){
   		                		println("Saved note history")
   		                		abc.clarification = false;
   	   		    				if(abc.save()){
   	   		    					println("abc.save()   true")
   	   		    				}
   	   		    				else{
   	   		    					println("abc.save()   false")
   	   		    					abc.errors.each {
   	   		    					println it
   	   		    				  }
   	   		    			    }
   	   		    				
   	   		    				
   	   		    				
   	   		    			def applicationPendingInstanse=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=? ",[(abc.id).toString()]);
                            if(applicationPendingInstanse)
                            {
                                applicationPendingInstanse.applicationStatus="rejected";
                                applicationPendingInstanse.save(flush:true);
                            }
   	   		    				
   	   		    				
   	   		    				
   		                	}else{
   		                		appProcessing.errors.each {
   		            		        println it
   		            			}
   		                		println("Not saved")
   		                	}
   		                	
   		                	
   		                	def sdfh123 = new SimpleDateFormat("dd/MM/yyyy"); 
   		    				def AllSummaryReportInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(abc.id).toString()]);
   		    				if(AllSummaryReportInstance)
   		    				{
   		    					AllSummaryReportInstance.clarificationReplyDate = sdfh123.format(new Date());
   		    					AllSummaryReportInstance.clarification = false;
   		    					AllSummaryReportInstance.applicationStatus="rejected";
   		    					AllSummaryReportInstance.save();
   		    				}
   		    		   }
   			       }
   			  }	
   	    */}
	
	 def clarificationResubmitPWM = 
   	        {/*  
   	            
   	            def bioMedicalWasteInstanse= PlasticWaste.findAll("from PlasticWaste hwaapp where hwaapp.clarification='t' order by hwaapp.id desc ")
   	            println("==========PWM.size========="+bioMedicalWasteInstanse.size())
   	            for(int i=0;i<bioMedicalWasteInstanse.size();i++)
   	            {
   	                def abc=bioMedicalWasteInstanse.get(i)
   	                def wasteProcessingInstanse = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails appProces where appProces.applicationId=? and appProces.clarification='t' order by appProces.id desc",[bioMedicalWasteInstanse.get(i).toString()])
   	                def wasteProcessingSingleInstanse=wasteProcessingInstanse;
   	                println("==========wasteProcessingSingleInstanse========="+wasteProcessingSingleInstanse)
   	                if(wasteProcessingSingleInstanse)
   	                  {
   	                    println("==========helloo=========")
   	                    
   	                    long diff = 0
   	                    int diffDays = 0
   	                    def dateCreated=wasteProcessingSingleInstanse.dateCreated;
   	                    println("==========wwwww========="+dateCreated)
   	                    Date today = new Date();
   	                    diff = today.getTime() - dateCreated.getTime();
   	                    diffDays=diff / (1000*60*60*24) +1
   	                    println("==========Diffrense Days PWM========="+diffDays)
   	                    if(diffDays >=30)
   	                    {
   	                        abc.clarification = false;
   	                        if(abc.save()){
   	                            println("abc.save()   true")
   	                        }
   	                        else{
   	                            println("abc.save()   false")
   	                            abc.errors.each {
   	                            println it
   	                          }
   	                        }
   	                        def wastemanagementPendingInstance=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? order by wmpd.id desc ",[(abc.id).toString()],[max:1])
   	                        def pendingInstance=wastemanagementPendingInstance[0]
   	                        def appProcessing = new WasteManagementProcessingDetails();
   	                        
   	                        def appFor=pendingInstance.applicationFor;
   	                        appProcessing.clarificationReplyAttachedFile=false
   	                        appProcessing.role =pendingInstance.role
   	                        appProcessing.officer = "SPCB"
   	                        appProcessing.roleFwd = pendingInstance.role
   	                        appProcessing.officerFwd = "SPCB"
   	                        appProcessing.approvalStatus = "";
   	                        appProcessing.clarification = false
   	                        appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   	                        appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   	                        appProcessing.inspection = false
   	                        appProcessing.inspectionNote = ""
   	                        appProcessing.inspectionClose = false
   	                        appProcessing.inspectionCloseNote = ""
   	                        appProcessing.approve = false
   	                        appProcessing.approveNote = ""
   	                        appProcessing.reject =  false
   	                        appProcessing.rejectNote = ""
   	                        appProcessing.applicationId = (abc.id).toString();
   	                        appProcessing.applicationFor =appFor;
   	                         
   	                        appProcessing.noticeType="industry reply"
                             appProcessing.scrutinyStatus=""
                             appProcessing.scrutinyDescription=""
                             appProcessing.approvalStatus=""
                             appProcessing.role = RoleMaster.findByRoleName("Industry")
                             appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
                             appProcessing.officer ="SPCB"
                             appProcessing.officerFwd = "SPCB"
                             appProcessing.applicationId = (abc.id).toString();
                             appProcessing.applicationFor =appFor
                             appProcessing.clarificationDays = ""
                             appProcessing.inspection = false
                             appProcessing.inspectionNote = ""
                             appProcessing.inspectionClose = false
                             appProcessing.inspectionCloseNote = ""
                             appProcessing.approve = false
                             appProcessing.approveNote = ""
                             appProcessing.reject =  false
                             appProcessing.rejectNote = ""
                             appProcessing.returned = false
                             appProcessing.returnNote = ""
                             appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                             appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application"
                             appProcessing.clarificationReplyAttachedFile=false;
                             appProcessing.resubmitStatus=false;
   	                        
   	                        
   	                        if(appProcessing.save()){
   	                            println("Saved note history")
   	                            
   	                            def applicationPendingInstanse=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=? ",[(abc.id).toString()]);
   	                            if(applicationPendingInstanse)
   	                            {
                                applicationPendingInstanse.applicationStatus="rejected";
                                applicationPendingInstanse.save(flush:true);
   	                            }
   	                            
   	                       }else{
   	                            appProcessing.errors.each {
   	                                println it
   	                            }
   	                            println("Not saved")
   	                            
   	                        }
   	                        
   	                        
   	                        def sdfh123 = new SimpleDateFormat("dd/MM/yyyy"); 
   	                        def AllSummaryReportInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(abc.id).toString()]);
   	                        if(AllSummaryReportInstance)
   	                        {
   	                            AllSummaryReportInstance.clarificationReplyDate = sdfh123.format(new Date());
   	                            AllSummaryReportInstance.clarification = false;
   	                            AllSummaryReportInstance.applicationStatus="rejected";
   	                            AllSummaryReportInstance.save();
   	                        }
   	                        
   	                        
   	                        
   	                   }
   	               }
   	          } 
   	    */}
   	    
   	    def clarificationResubmitEWASTE = 
   	    {/*  
   	            
   	            def bioMedicalWasteInstanse= EWaste.findAll("from EWaste hwaapp where hwaapp.clarification='t' order by hwaapp.id desc ")
   	            println("==========eWaste.size========="+bioMedicalWasteInstanse.size())
   	            for(int i=0;i<bioMedicalWasteInstanse.size();i++)
   	            {
   	                def abc=bioMedicalWasteInstanse.get(i)
   	                def wasteProcessingInstanse = EWasteProcessingDetails.find("from EWasteProcessingDetails appProces where appProces.applicationId=? and appProces.clarification='t' order by appProces.id desc",[bioMedicalWasteInstanse.get(i).toString()])
   	                def wasteProcessingSingleInstanse=wasteProcessingInstanse;
   	                println("==========wasteProcessingSingleInstanse========="+wasteProcessingSingleInstanse)
   	                if(wasteProcessingSingleInstanse)
   	                  {
   	                    println("==========helloo=========")
   	                    
   	                    long diff = 0
   	                    int diffDays = 0
   	                    def dateCreated=wasteProcessingSingleInstanse.dateCreated;
   	                    println("==========wwwww========="+dateCreated)
   	                    Date today = new Date();
   	                    diff = today.getTime() - dateCreated.getTime();
   	                    diffDays=diff / (1000*60*60*24) +1
   	                    println("==========Diffrense Days PWM========="+diffDays)
   	                    if(diffDays >=30)
   	                    {
   	                        abc.clarification = false;
   	                        if(abc.save()){
   	                            println("abc.save()   true")
   	                        }
   	                        else{
   	                            println("abc.save()   false")
   	                            abc.errors.each {
   	                            println it
   	                          }
   	                        }
   	                        def wastemanagementPendingInstance=EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? order by wmpd.id desc ",[(abc.id).toString()],[max:1])
   	                        def pendingInstance=wastemanagementPendingInstance[0]
   	                        def appProcessing = new EWasteProcessingDetails();
   	                        appProcessing.role =pendingInstance.role
   	                        appProcessing.officer = "SPCB"
   	                        appProcessing.roleFwd = pendingInstance.role
   	                        appProcessing.officerFwd= "SPCB"
   	                        appProcessing.fileNote = "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   	                        appProcessing.clarification= false
   	                        appProcessing.clarificationNote= "Industry not replying with in 30 dayas so clarification automaticly resubmit and reject application.";
   	                        appProcessing.inspection= false;
   	                        appProcessing.inspectionNote= "";
   	                        appProcessing.inspectionClose= false;
   	                        appProcessing.inspectionCloseNote= ""
   	                        appProcessing.approve= false;
   	                        appProcessing.approveNote = "";
   	                        appProcessing.noticeType = "";
   	                        appProcessing.reject= false
   	                        appProcessing.attachedFile= false
   	                        appProcessing.inspectionDays = "";
   	                        appProcessing.clarificationDays= "";
   	                        appProcessing.rejectNote= "";
   	                        appProcessing.applicationId=(abc.id).toString();
   	                        appProcessing.applicationFor="EWaste";
   	                        appProcessing.clarificationAttachedFile =false;
   	                        appProcessing.clarificationReplyAttachedFile =false;
   	                        appProcessing.inspectionAttachedFile =false;
   	                        appProcessing.inspectionCloseAttachedFile =false;
   	                        
   	                        if(appProcessing.save()){
   	                            println("Saved note history");
   	                            
   	                         def applicationPendingInstanse=EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails abc where abc.applicationId=? ",[(abc.id).toString()]);
                             if(applicationPendingInstanse)
                             {
                             applicationPendingInstanse.applicationStatus="rejected";
                             applicationPendingInstanse.save(flush:true);
                             }
   	                        }else{
   	                            appProcessing.errors.each {
   	                                println it
   	                            }
   	                            println("Not saved")
   	                        }
   	                   }
   	               }
   	          } 
   	    */}
   		/**
   	     * @Created By:SHARVAN KUMAR
   	     * @Created Date:03/10/2017
   	     * @Purpose:delete application after Scrutiny Reminder Consent after  60 or 90 days
   	     * @Method:moveAppAfter7Days
   	    * ****/
   	    
   	    def moveConsentAppAfter10Days = {  
   	            try {
   	                
   	                def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where appProces.applicationStatus='pending' order by appProces.id desc")
   	                println("----allSummaryList----"+allSummaryList.size())
   	                for(int i=0;i<allSummaryList.size();i++)
   	                {
   	                	
   	                    def allSummaryIns=allSummaryList.get(i);
   	                	
   	                    def appId=allSummaryIns.applicationId;
   	                	
   	                    def indApplicationDetailsInstance=IndApplicationDetails.get((appId).toLong());
   	                	println("----allSummaryList--4--"+indApplicationDetailsInstance)
   	                    def officer=allSummaryIns.officerName;
   	                	println("----allSummaryList--5--"+officer)
   	                    def role=allSummaryIns.roleId;
   	                	println("----allSummaryList--6--"+role)
   	                    def offId=allSummaryIns.pendingWith;
   	                	println("----allSummaryList--7--"+offId)
   	                    def allSummaryRoleId=allSummaryIns.roleId;
   	                	println("----allSummaryList--8--"+allSummaryRoleId)
   	                    def allSummaryRoleInstanse = RoleMaster.get((allSummaryRoleId).toLong())
   	                    println("----allSummaryList--9--"+allSummaryRoleInstanse)
   	                    def allSummaryGroupId=allSummaryIns.groupId;
   	                	println("----allSummaryList--10--"+allSummaryGroupId)
   	                    def clarification=indApplicationDetailsInstance.clarification;
   	                	println("----allSummaryList--11--"+clarification)
   	                	def allSummaryGroupInstanse = GroupMaster.find("from GroupMaster where id=?",[allSummaryGroupId.toLong()])
   	                	println("----allSummaryList--12--"+allSummaryGroupInstanse)
   	                    def autoFlowForwardedRole;
   	                 	def autoFlowInstanse=AutoFlowMaster.find("from AutoFlowMaster a where a.role=? and a.group=? order by id desc limit 1",[allSummaryRoleInstanse,allSummaryGroupInstanse]);
   	                 	if(autoFlowInstanse && !clarification)
   	                    {
   	                 		
   	                 		def autoFlowRoleId;
   	                 		def autoFlowRoleName;
   	                 		def autoFwdOfficerName;
   	                 		def autoFwdPendingWith;
   	                 		
   	                 		autoFlowForwardedRole=autoFlowInstanse.canForwardTo;
   	                 	println("----allSummaryList--14--"+autoFlowForwardedRole)
   	                    	autoFlowRoleId=(autoFlowForwardedRole.id).toString();
   	                    	autoFlowRoleName=(autoFlowForwardedRole.roleName).toString();
   	                    	autoFwdOfficerName=(RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee.employeeLastName;
   	                    	autoFwdPendingWith=(UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee)).toString();
   	                    	
   	                    	long diff10 = 0
   	                        int diffDays10 = 0
   	                        int val = 0
   	                        val = 7
   	                        def pendingSince=allSummaryIns.pendingSince;
   	                        Date today = new Date();
   	                        diff10 = today.getTime() - pendingSince.getTime();
   	                        diffDays10=diff10 / (1000*60*60*24) +1
   	                    	if(diffDays10 >= 7)
   	                        {
   	                            
   	                            
   	                            def appProcessing = new ApplicationProcessingDetails();
   	                            appProcessing.clarificationReplyAttachedFile=false;
   	                            appProcessing.role =allSummaryRoleInstanse;
   	                            appProcessing.roleFwd =autoFlowForwardedRole;
   	                            appProcessing.officer = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(allSummaryRoleInstanse)).primaryEmployee)
   	                            appProcessing.officerFwd =autoFwdPendingWith;
   	                            appProcessing.application = indApplicationDetailsInstance;
   	                            appProcessing.approve = false
   	                            appProcessing.approveNote=""
   	                            appProcessing.clarification=false
   	                            appProcessing.clarificationNote= "";
   	                            appProcessing.fileNote = "Application moved automatically to Higer Officer Login, Since no action has been taken by officer within the 7 days";
   	                            appProcessing.resubmitStatus=false
   	                            appProcessing.returned=false
   	                            appProcessing.inspection=false
   	                            appProcessing.inspectionClose=false
   	                            appProcessing.inspectionCloseNote=""
   	                            appProcessing.inspectionNote=""
   	                            appProcessing.reject = false
   	                            appProcessing.rejectNote = ""
   	                            appProcessing.returnNote= ""
   	                            appProcessing.dateCreated=new Date()
   	                            appProcessing.lastUpdated=new Date()
   	                            appProcessing.attachedFile=false
   	                            appProcessing.clarificationAttachedFile=false
   	                            appProcessing.inspectionAttachedFile=false
   	                            appProcessing.inspectionCloseAttachedFile=false
   	                            appProcessing.approvalStatus=""
   	                            appProcessing.application=indApplicationDetailsInstance
   	                            if(appProcessing.save()){
   	                                
   	                                def applicationPendingInstanse=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=? ",[indApplicationDetailsInstance]);
   	                                if(applicationPendingInstanse)
   	                                {
   	                                    println("--inside--");
   	                                    applicationPendingInstanse.pendingWith=(UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee));
   	                                    applicationPendingInstanse.role=autoFlowForwardedRole;
   	                                    applicationPendingInstanse.save(flush:true);
   	                                }
   	                                
   	                                def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(appId).toString()]);
   	                                if(allSummaryReportInstance)
   	                                {
   	                                    allSummaryReportInstance.roleId=autoFlowRoleId
   	                                    allSummaryReportInstance.roleName=autoFlowRoleName;
   	                                    allSummaryReportInstance.pendingSince=new Date();
   	                                    allSummaryReportInstance.officerName=autoFwdOfficerName
   	                                    allSummaryReportInstance.pendingWith=UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee);
   	                                    
   	                                    if(allSummaryReportInstance.save()){
   	                                        println("----Completed One LoOP--------------"+allSummaryReportInstance.id)
   	                                        
   	                                    }else{
   	                                      
   	                                        allSummaryReportInstance.errors.each {
   	                                        println it
   	                                      }
   	                                    }
   	                                }
   	                            }
   	                        }
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


		/**
         * @Created By:SHARVAN KUMAR
         * @Created Date:03/10/2017
         * @Purpose:delete application after Scrutiny Reminder Consent after  7 or 10 days
         * @Method:moveWasteAppAfter10Days
        * ****/
        
        def moveWasteAppAfter10Days = {/*  
                try {
                    
                    def allSummaryList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS appProces where (appProces.applicationStatus='pending') order by appProces.id desc")
                    for(int i=0;i<allSummaryList.size();i++)
                    {
                    	def indApplicationDetailsInstance;
                        def allSummaryIns=allSummaryList.get(i);
                        def appId=allSummaryIns.applicationId;
                        def appFor=allSummaryIns.applicationFor;
                        if(appFor=="HWM")
                        {
                        	indApplicationDetailsInstance=HazardeousWasteAuthApp.get((appId).toLong());
                        }else if(appFor=="BMW")
                        {
                        	indApplicationDetailsInstance=BioMedicalWaste.get((appId).toLong());
                        }else if(appFor=="MSW")
                        {
                        	indApplicationDetailsInstance=MunicipalSolidWaste.get((appId).toLong());
                        }
                        else if(appFor=="PWM")
                        {
                        	indApplicationDetailsInstance=PlasticWaste.get((appId).toLong());
                        }
                        else if(appFor=="HWMAnnualReturn")
                        {
                        	indApplicationDetailsInstance=HazardeousAnnualReturnDetails.get((appId).toLong()); 
                        }
                        else if(appFor=="BMWAnnualReturn")
                        {
                        	indApplicationDetailsInstance=BmwRenew.get((appId).toLong()); 
                        }
                        
                        def officer=allSummaryIns.officerName;
                        def role=allSummaryIns.roleId;
                        def offId=allSummaryIns.pendingWith;
                        def allSummaryRoleId=allSummaryIns.roleId;
                        def allSummaryRoleInstanse = RoleMaster.get((allSummaryRoleId).toLong())
                        def allSummaryGroupId=allSummaryIns.groupId;
                        def clarification=indApplicationDetailsInstance.clarification;
                        
                        def allSummaryGroupInstanse = GroupMaster.get((allSummaryGroupId).toLong());
                        
                        def autoFlowForwardedRole;
                        def autoFlowInstanse=AutoFlowMaster.find("from AutoFlowMaster where role=? and group=? order by id desc limit 1",[allSummaryRoleInstanse,allSummaryGroupInstanse]);
                        if(autoFlowInstanse && !clarification)
                        {
                            
                             def autoFlowRoleId;
                            def autoFlowRoleName;
                            def autoFwdOfficerName;
                            def autoFwdPendingWith;
                            
                            autoFlowForwardedRole=autoFlowInstanse.canForwardTo;
                            autoFlowRoleId=(autoFlowForwardedRole.id).toString();
                            autoFlowRoleName=(autoFlowForwardedRole.roleName).toString();
                            autoFwdOfficerName=(RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee.employeeLastName;
                            autoFwdPendingWith=(UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee)).toString();
                            
                            long diff10 = 0
                            int diffDays10 = 0
                            int val = 8
                            
                            def pendingSince=allSummaryIns.pendingSince;
                            Date today = new Date();
                            diff10 = today.getTime() - pendingSince.getTime();
                            diffDays10=diff10 / (1000*60*60*24) +1
                            if(diffDays10 >= 8)
                            {
                                
                                def appProcessing = new WasteManagementProcessingDetails();
                                appProcessing.noticeType="industry reply"
                                appProcessing.scrutinyStatus=""
                                appProcessing.scrutinyDescription=""
                                appProcessing.approvalStatus=""
                                appProcessing.role = allSummaryRoleInstanse
                                appProcessing.roleFwd = autoFlowForwardedRole
                                appProcessing.officer =autoFwdPendingWith
                                appProcessing.officerFwd = autoFwdPendingWith
                                appProcessing.applicationId = (indApplicationDetailsInstance.id).toString();
                                appProcessing.applicationFor =appFor
                                appProcessing.clarificationDays = ""
                                appProcessing.inspection = false
                                appProcessing.inspectionNote = ""
                                appProcessing.inspectionClose = false
                                appProcessing.inspectionCloseNote = ""
                                appProcessing.approve = false
                                appProcessing.approveNote = ""
                                appProcessing.reject =  false
                                appProcessing.rejectNote = ""
                                appProcessing.returned = false
                                appProcessing.returnNote = ""
                                appProcessing.clarificationNote= ""
                                appProcessing.fileNote = "Application moved automatically to Higer Officer Login,Since no action has been taken by officer within the 7 days"
                                appProcessing.clarificationReplyAttachedFile=false;
                                appProcessing.resubmitStatus=false;
                                if(appProcessing.save(flush:true)){
                                def applicationPendingInstanse=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=? ",[(indApplicationDetailsInstance.id).toString()]);
                                if(applicationPendingInstanse)
                                {
                                    applicationPendingInstanse.pendingWith=(UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee));
                                    applicationPendingInstanse.role=autoFlowForwardedRole;
                                    applicationPendingInstanse.save(flush:true);
                                }
                                
                                def AllSummaryReportInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[(indApplicationDetailsInstance.id).toString()]);
                                if(AllSummaryReportInstance)
                                {
                                    AllSummaryReportInstance.roleId=autoFlowRoleId
                                    AllSummaryReportInstance.roleName=autoFlowRoleName;
                                    AllSummaryReportInstance.pendingSince=new Date();
                                    AllSummaryReportInstance.officerName=autoFwdOfficerName
                                    AllSummaryReportInstance.pendingWith=UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(autoFlowForwardedRole)).primaryEmployee);
                                    
                                    if(AllSummaryReportInstance.save()){
                                        
                                        
                                    }else{
                                        
                                        AllSummaryReportInstance.errors.each {
                                        println it
                                      }
                                    }
                                }
                               }else{
                                
                                    appProcessing.errors.each {
                                    println it
                                }
                                println("Not saved")
                            }
                           }
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
       */}
	def clarificationUpdate_old=
	{/*
	
			try {
				long diff10 = 0
                int diffDays10 = 0
                int val = 30;
                  println("==========Inside moveWasteAppAfter10Days=========")
                  def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where (appProces.clarificationRaiseDt !='1950-01-01 00:00:00') order by appProces.id desc")
                  println("==========allSummaryList.size========="+allSummaryList.size());
                  for(int i=0;i<allSummaryList.size();i++)
                  {
                	  def allSummaryInstanse=allSummaryList.get(i);  
                	  def clarificationDays=allSummaryList.get(i).clarificationDays;  
                	  Date today = new Date();
                	  def clarificationRaiseDate=allSummaryList.get(i).clarificationRaiseDt;
                      def appId=allSummaryList.get(i).applicationId;
                	  def allSummaryReportInstanceA=AllSummaryReport.find("from AllSummaryReport where clarificationSubmitDt!='1950-01-01 00:00:00' and applicationId = ?",[(appId).toString()]);
                	  println("==========allSummaryReportInstanceA========="+allSummaryReportInstanceA);
                	  if(allSummaryReportInstanceA)
                      {
                		  //println("==========inside A=========");
                		  def clarificationSubmitDate=allSummaryReportInstanceA.clarificationSubmitDt;
                    	  diff10 = clarificationSubmitDate.getTime() - clarificationRaiseDate.getTime();
                          diffDays10=diff10 / (1000*60*60*24) +1;
                    	  
                      }else
                      {
                    	  //println("==========inside B=========");
                    	  diff10 = today.getTime() - clarificationRaiseDate.getTime();
                          diffDays10=diff10 / (1000*60*60*24) +1;
                      }
                	  //println("DIFFRENCE DATE------"+diffDays10);
                	  
                	  if(diffDays10<0)
                	  {
                		  println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+diffDays10);
                		  diff10 = today.getTime() - clarificationRaiseDate.getTime();
                          diffDays10=diff10 / (1000*60*60*24) +1;
                          println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"+diffDays10);
                		  
                	  }
                	  println("PPPPPPPPPPPPP"+clarificationDays+diffDays10);
                	  allSummaryInstanse.clarificationDays=clarificationDays+diffDays10;
                	  allSummaryInstanse.save(flush:true);
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
	*/}


   		def clarificationUpdate=
   	    {/*
   	    		try {
   	                  println("==========Inside clarificationUpdate=========")
   	                  //def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where appProces.applicationId='42124' order by appProces.id desc")
   	                  def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where appProces.applicationStatus='pending' and appProces.pendingSince > '2019-03-31 00:00:00' order by appProces.id desc")
   	                  println("==========allSummaryList.size clarificationUpdate========="+allSummaryList.size());
   	                  for(int i=0;i<allSummaryList.size();i++)
   	                  {
   	                	  
   	                	def allSummaryIns=allSummaryList.get(i);
   	                	def appId=allSummaryIns.applicationId;
   	                	def indApplicationDetailsInstance=IndApplicationDetails.get((appId).toLong());
   	                	def clarificationRaiseDays;
   	                	def showCauseRaiseDays;
   	                	
   	                	def clarificationSubmitDays;
                        def showCauseSubmitDays;
   	                	
                        Date today = new Date();
                        long claDays = 0
                        int diffClaDays = 0
                        long showDays = 0
                        int diffShowDays = 0
                        long replyClaDays = 0
                        int diffreplyClaDays = 0
                        long replyShoDays = 0
                        int diffreplyShoDays = 0;
                        int finalClarificationDays= 0
                        int finalShowCauseDays= 0;
                        int finalPendingDays=0;
                        
                        def clarificatonInstance=ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails ind where ind.application=? and ind.noticeType IN ('Clarification','Show Cause') order by ind.id desc",[indApplicationDetailsInstance])
                        if(clarificatonInstance)
                        {
                        	
                        	for(int j=0;j<clarificatonInstance.size();j++)
                            {
                        		if(clarificatonInstance.get(j).clarification && clarificatonInstance.get(j).noticeType=="Clarification")
                        		{
                        			 println("Inside Clarification Raised");
                        			clarificationRaiseDays=clarificatonInstance.get(j).dateCreated;
                        			//println("clarificationRaiseDays==="+clarificationRaiseDays);
                        			claDays = today.getTime() - clarificationRaiseDays.getTime();
                        			diffClaDays=diffClaDays+claDays /(1000*60*60*24) +1;
                        			println("Clarification Days==="+diffClaDays);
                        		}
                        		
                        		if(clarificatonInstance.get(j).clarification && clarificatonInstance.get(j).noticeType=="Show Cause")
                                {
                        			println("Inside Show Cause Raised");
                        			showCauseRaiseDays=clarificatonInstance.get(j).dateCreated;
                        			showDays = today.getTime() - showCauseRaiseDays.getTime();
                        			diffShowDays=diffShowDays+showDays / (1000*60*60*24) +1;
                        			println("Show Cause Days==="+diffShowDays);
                                }
                        		
                        		if(clarificatonInstance.get(j).officer=="SPCB" && clarificatonInstance.get(j).noticeType=="Clarification")
                                {
                        			println("Inside Clarification Reply");
                        			clarificationSubmitDays=clarificatonInstance.get(j).dateCreated;
                        			replyClaDays = today.getTime() - clarificationSubmitDays.getTime();
                        			diffreplyClaDays=diffreplyClaDays+replyClaDays / (1000*60*60*24) +1;
                        			println("Clarification Replys Days==="+diffreplyClaDays);
                                }
                                
                                if(clarificatonInstance.get(j).officer=="SPCB" && clarificatonInstance.get(j).noticeType=="Show Cause")
                                {
                                	println("Inside Show Cause Reply");
                                	showCauseSubmitDays=clarificatonInstance.get(j).dateCreated;
                                	replyShoDays = today.getTime() - showCauseSubmitDays.getTime();
                                	diffreplyShoDays=diffreplyShoDays+replyShoDays / (1000*60*60*24) +1;
                                	println("Show Cause Reply Days==="+diffreplyShoDays);
                                }
                             }
                        }  
                        
                        
                        println("Total Reply Clarification Days------="+diffreplyClaDays);
                        println("Total Clarification Days------="+diffClaDays);
                        
                        finalClarificationDays = (diffClaDays) - (diffreplyClaDays);
                        finalShowCauseDays=      (diffShowDays) - (diffreplyShoDays);
                        finalPendingDays=finalClarificationDays+finalShowCauseDays;
                        
                        println("ClarificationDays------="+finalClarificationDays);
                        println("ShowCauseDays-----="+finalShowCauseDays);
                        println("Final Industry Hold Days-----="+finalPendingDays);
                        
                        Date appDate=allSummaryIns.applicationRecieptDate;
                        allSummaryIns.clarificationDays=finalPendingDays;
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        WorkingDays workingDays=new WorkingDays();
                        def dayNow=workingDays.calDueDate(appDate,finalPendingDays);
                        Date date = formatter.parse(dayNow)
                        Calendar ca= new GregorianCalendar();
                        ca.setTime(date)
                        Date todayAppDate = ca.getTime()
                        println("G: " + todayAppDate);
                        allSummaryIns.appDate=todayAppDate;
                        allSummaryIns.save(flush:true);
                        
                        
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
   	   */}


	def clarificationRefused=
		{/*
		
				
                try {
                      println("==========Inside moveWasteAppAfter10Days=========")
                      //def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where appProces.applicationId='42124' order by appProces.id desc")
                      def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where appProces.applicationStatus='rejected' order by appProces.id desc")
                      println("==========allSummaryList.size========="+allSummaryList.size());
                      for(int i=0;i<allSummaryList.size();i++)
                      {
                        def allSummaryIns=allSummaryList.get(i);
                        allSummaryIns.clarificationDays=100;
                        allSummaryIns.save(flush:true);
                        
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
	       */}

   		def clarificationApproved=
   	    {/*
        		try {
                      println("==========Inside moveWasteAppAfter10Days=========")
                      def allSummaryList = AllSummaryReport.findAll("from AllSummaryReport appProces where appProces.applicationStatus='approved' order by appProces.id desc")
                      println("==========allSummaryList.size========="+allSummaryList.size());
                      for(int i=0;i<allSummaryList.size();i++)
                      {
                        def allSummaryIns=allSummaryList.get(i);
                        allSummaryIns.clarificationDays=100;
                        allSummaryIns.save(flush:true);
                        
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
           */}
}