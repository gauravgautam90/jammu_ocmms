import java.util.ArrayList
import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

class IndUserController {
    
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
    	
    	   if(session.indUser==null && session.userMaster==null)
           {
             redirect(uri:'/index.gsp')
       		return

           }  
    	 try {
    			params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ indUserInstanceList: IndUser.list( params ), indUserInstanceTotal: IndUser.count() ]
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
    			def indUserInstance = IndUser.get( params.id )
    			if(!indUserInstance) {
    	            flash.message = "IndUser not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indUserInstance : indUserInstance ] }
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
        def indUserInstance = IndUser.get( params.id )
        if(indUserInstance) {
            try {
                indUserInstance.delete()
                flash.message = "IndUser ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndUser ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndUser not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    			 def indUserInstance = IndUser.get( params.id )
    			 if(!indUserInstance) {
    	            flash.message = "IndUser not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indUserInstance : indUserInstance ]
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
    			def indUserInstance = IndUser.get( params.id )
    	        if(indUserInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indUserInstance.version > version) {
    	                     indUserInstance.errors.rejectValue("version", "indUser.optimistic.locking.failure", "Another user has updated this IndUser while you were editing.")
    	                    render(view:'edit',model:[indUserInstance:indUserInstance])
    	                    return
    	                }
    	            }
    	            indUserInstance.properties = params
    	            if(!indUserInstance.hasErrors() && indUserInstance.save()) {
    	                flash.message = "IndUser ${params.id} updated"
    	                redirect(action:show,id:indUserInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indUserInstance:indUserInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndUser not found with id ${params.id}"
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
    			 def indUserInstance = new IndUser()
    	        indUserInstance.properties = params
    	        return ['indUserInstance':indUserInstance]
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
    			 def indUserInstance1 = new IndUser(params)
    	        if(!indUserInstance1.hasErrors() && indUserInstance1.save()) {
    	           redirect(action:show,id:indUserInstance1.id)
    	        }
    	        else {
    	            render(view:'create',model:[indUserInstance1:indUserInstance1])
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
    
    def openIndustryHome = {
    	 try {
    		 if(!session.indUser)
    	    	{
    	    		redirect(uri:"/index.gsp")
    	    	}
    	    	else{
    	    		def industryId = session.indUser
    				def indUserID = industryId.industryRegMaster
    				def pendinglist = new ArrayList()
    		    	def completedlist = new ArrayList()
    	    		def compStatusList = new ArrayList();
    	    		def pendingWith = new ArrayList();
    	    		def indApplicationDetailsList = IndApplicationDetails.findAllWhere(indUser:indUserID)
    				for(int i=0; i<indApplicationDetailsList.size; i++) 
    				{  
    					if((indApplicationDetailsList.get(i)).completionStatus.equals('pending')){
    						pendinglist.add((indApplicationDetailsList.get(i)))
    	   				}else{
    	   					completedlist.add((indApplicationDetailsList.get(i)))
    	   					def status = ApplicationPendingDetails.findByApplication(indApplicationDetailsList.get(i))
    	   					//code by vikas
    	   					def returnStatus = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by id desc",[indApplicationDetailsList.get(i)])
    					//code ended by vikas
    					if(status){
    	   						/*if(status.applicationStatus=="pending"){
    	   	   						compStatusList.add("In-Progress")
    	   	   					}else if(status.applicationStatus=="approved"){
    	   	   						compStatusList.add("Granted")
    	   	   					}*/
//    	   					CODE BY VIKAS RATHORE

    						 if(status.completionStatus=="Completed"){
 	   	   						compStatusList.add("Scrutiny Complete")
 	   	   					}
 	   						 else if(status.applicationStatus=="pending"){
 	   	   						compStatusList.add("In-Progress")
 	   	   					}else if(status.applicationStatus=="returned"){
 	   	   						compStatusList.add("Returned")
 	   	   					}else if(status.scrutinyStatus=="In-Complete"){
 	   	   						compStatusList.add("Scrutiny In-Complete")
 	   	   					}else if(status.applicationStatus=="approved"){
 	   	   						compStatusList.add("Granted")
 	   	   						}
 	   	   				    else if(returnStatus){
    	   	   				if(returnStatus.returned==true){
    	   	   					
	   	   						compStatusList.add("Returned")
    	   	   				}else{
    	   	   				if(status.applicationStatus=="pending"){
	   	   						compStatusList.add("In-Progress")
	   	   					}else if(status.applicationStatus=="returned"){
	   	   						compStatusList.add("Returned")
	   	   					}else if(status.applicationStatus=="rejected"){
	   	   						compStatusList.add("Rejected")
	   	   					}
	   						else if(status.applicationStatus=="approved"){
	   	   						compStatusList.add("Granted")
	   	   					}else{
    	   							compStatusList.add("In-Progress")
    	   					}
    	   					}
    	   	   				
	   	   					}
    	   	   				/*else if(returnStatus!=null){
	   		   				 if(returnStatus.returned==true){
	   		   					 compStatusList.add("Returned")
	   	   					    }else{
	   		   						compStatusList.add("Refused")
		   						}
    	   	   				}*/
   	   	   	   				//CODE ENDED BY VIKAS RATHORE
    	   	   					else{
    	   	   						compStatusList.add("Refused")
    	   	   					}
    	   						pendingWith.add(status.role)
    	   					}else{
    	   							compStatusList.add("In-Progress")
    	   								pendingWith.add("Unknown")
    	   					}
    	   				}
    				}
    	    		for(int j=0; j<pendinglist.size; j++)	
    	    		{
    	    			def dateWithTime =(pendinglist.get(j)).applicationDate
    	    			DateCustom dd=new DateCustom()
    	    			def xyz= dd.toDate(dateWithTime)
    	    			(pendinglist.get(j)).applicationDate=xyz	
    	    		}
    	    		for(int k=0; k<completedlist.size; k++)	
    	    		{
    	    			def dateWithTime1 =(completedlist.get(k)).applicationDate
    	    			DateCustom dd1=new DateCustom()
    	    			def xyz1= dd1.toDate(dateWithTime1)
    	    			(completedlist.get(k)).applicationDate=xyz1	
    	    		}
    	    		def evcList = EnvironmentalClearenceDetails.findAll("from EnvironmentalClearenceDetails s where s.indUserUniversal.id=? ",[industryId.industryRegMaster.id])
    	    	//	println("completedIndApplicationDetailsInstanceList..."+completedlist)
    	    	//	println("completedIndApplicationDetailsInstanceList..."+completedlist.size())
    	    	//	println("pendingIndApplicationDetailsInstanceList..."+pendinglist)
    	    	//	println("pendingIndApplicationDetailsInstanceList..."+pendinglist.size())
    	    	//	println("compStatusList..."+compStatusList)
    	    	//	println("compStatusList..."+compStatusList.size())
    	    	//	println("pendingWith..."+pendingWith)
    	    	//	println("pendingWith..."+pendingWith.size())
    	    	//	println("evcList..."+evcList)
    	    	//	println("evcList..."+evcList.size())
    	    		render(view:'indUser/industryhome',model:[completedIndApplicationDetailsInstanceList:completedlist,pendingIndApplicationDetailsInstanceList:pendinglist,compStatusList:compStatusList,pendingWith:pendingWith,evcList:evcList])

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
