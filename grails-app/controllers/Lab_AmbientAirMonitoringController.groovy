
import java.text.SimpleDateFormat;
class Lab_AmbientAirMonitoringController {
    
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
    	        [ lab_AmbientAirMonitoringInstanceList: Lab_AmbientAirMonitoring.list( params ), lab_AmbientAirMonitoringInstanceTotal: Lab_AmbientAirMonitoring.count() ]
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
    			def lab_AmbientAirMonitoringInstance = Lab_AmbientAirMonitoring.get( params.id )
    	       def noEdit=params.noEdit
    	       if(!lab_AmbientAirMonitoringInstance) {
    	            flash.message = "Lab_AmbientAirMonitoring not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ lab_AmbientAirMonitoringInstance : lab_AmbientAirMonitoringInstance,noEdit:noEdit ] }
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
        def lab_AmbientAirMonitoringInstance = Lab_AmbientAirMonitoring.get( params.id )
        if(lab_AmbientAirMonitoringInstance) {
            try {
                lab_AmbientAirMonitoringInstance.delete()
                flash.message = "Lab_AmbientAirMonitoring ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Lab_AmbientAirMonitoring ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Lab_AmbientAirMonitoring not found with id ${params.id}"
            redirect(action:create)
        }
    }

def edit = {
    	 try {
    			 def lab_AmbientAirMonitoringInstance = Lab_AmbientAirMonitoring.get( params.id )
    	        if(!lab_AmbientAirMonitoringInstance) {
    	            flash.message = "Lab_AmbientAirMonitoring not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ lab_AmbientAirMonitoringInstance : lab_AmbientAirMonitoringInstance ]
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
    			 def lab_AmbientAirMonitoringInstance = Lab_AmbientAirMonitoring.get( params.id )
    	        if(lab_AmbientAirMonitoringInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(lab_AmbientAirMonitoringInstance.version > version) {
    	                     lab_AmbientAirMonitoringInstance.errors.rejectValue("version", "lab_AmbientAirMonitoring.optimistic.locking.failure", "Another user has updated this Lab_AmbientAirMonitoring while you were editing.")
    	                    render(view:'edit',model:[lab_AmbientAirMonitoringInstance:lab_AmbientAirMonitoringInstance])
    	                    return
    	                }
    	            }
    	            lab_AmbientAirMonitoringInstance.properties = params
    	            if(!lab_AmbientAirMonitoringInstance.hasErrors() && lab_AmbientAirMonitoringInstance.save()) {
    	                flash.message = "Lab_AmbientAirMonitoring ${params.id} updated"
    	                redirect(action:show,id:lab_AmbientAirMonitoringInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[lab_AmbientAirMonitoringInstance:lab_AmbientAirMonitoringInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Lab_AmbientAirMonitoring not found with id ${params.id}"
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
    			def lab_AmbientAirMonitoringInstance = new Lab_AmbientAirMonitoring()
    	        lab_AmbientAirMonitoringInstance.properties = params
    	       return ['lab_AmbientAirMonitoringInstance':lab_AmbientAirMonitoringInstance]
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
    			def lab_AmbientAirMonitoringInstance = new Lab_AmbientAirMonitoring(params)
    	        def checkDate=params.dateOfSample_value
    			def x
    			try
    					{
    						def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
    						x = sdfh.parse(checkDate); //Date
    					}
    					catch(Exception e)
    					{
    					}
    					java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    					if(sqlDate > new Date()){
    	    				flash.message="Notice date cannot be greater than current date."
    	    					render(view:"create",model:[lab_AmbientAirMonitoringInstance:lab_AmbientAirMonitoringInstance])
    					}else{
    			lab_AmbientAirMonitoringInstance.completionStatus="pending"
    	         lab_AmbientAirMonitoringInstance.applicationStatus="pending"
    	        lab_AmbientAirMonitoringInstance.generateReport=false
    	        def userIns=(session.userMaster).toString()
    	        lab_AmbientAirMonitoringInstance.createdBy=userIns
    	        lab_AmbientAirMonitoringInstance.updatedBy=userIns
    	        if(!lab_AmbientAirMonitoringInstance.hasErrors() && lab_AmbientAirMonitoringInstance.save()) {
    	            flash.message = "Lab_AmbientAirMonitoring ${lab_AmbientAirMonitoringInstance.id} created"
    	            redirect(action:show,id:lab_AmbientAirMonitoringInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[lab_AmbientAirMonitoringInstance:lab_AmbientAirMonitoringInstance])
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
    
    def labHandOver={
    	 try {
    		def sampleId=params.id
            def sampleType=params.type
            redirect(controller:'sampleHandover',action:"create",id:sampleId, params:[typeOfSample:sampleType])
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
