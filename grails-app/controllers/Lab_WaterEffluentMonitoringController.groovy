

class Lab_WaterEffluentMonitoringController {
    
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
    	        [ lab_WaterEffluentMonitoringInstanceList: Lab_WaterEffluentMonitoring.list( params ), lab_WaterEffluentMonitoringInstanceTotal: Lab_WaterEffluentMonitoring.count() ]
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
    	def lab_WaterEffluentMonitoringInstance = Lab_WaterEffluentMonitoring.get( params.id )
    	        def noEdit=params.noEdit
    	        if(!lab_WaterEffluentMonitoringInstance) {
    	            flash.message = "Lab_WaterEffluentMonitoring not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ lab_WaterEffluentMonitoringInstance : lab_WaterEffluentMonitoringInstance,noEdit:noEdit ] }
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
        def lab_WaterEffluentMonitoringInstance = Lab_WaterEffluentMonitoring.get( params.id )
        if(lab_WaterEffluentMonitoringInstance) {
            try {
                lab_WaterEffluentMonitoringInstance.delete()
                flash.message = "Lab_WaterEffluentMonitoring ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Lab_WaterEffluentMonitoring ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Lab_WaterEffluentMonitoring not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		 def lab_WaterEffluentMonitoringInstance = Lab_WaterEffluentMonitoring.get( params.id )
    	        if(!lab_WaterEffluentMonitoringInstance) {
    	            flash.message = "Lab_WaterEffluentMonitoring not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ lab_WaterEffluentMonitoringInstance : lab_WaterEffluentMonitoringInstance ]
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
    			def lab_WaterEffluentMonitoringInstance = Lab_WaterEffluentMonitoring.get( params.id )
    	        if(lab_WaterEffluentMonitoringInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(lab_WaterEffluentMonitoringInstance.version > version) {
    	                    
    	                    lab_WaterEffluentMonitoringInstance.errors.rejectValue("version", "lab_WaterEffluentMonitoring.optimistic.locking.failure", "Another user has updated this Lab_WaterEffluentMonitoring while you were editing.")
    	                    render(view:'edit',model:[lab_WaterEffluentMonitoringInstance:lab_WaterEffluentMonitoringInstance])
    	                    return
    	                }
    	            }
    	            lab_WaterEffluentMonitoringInstance.completionStatus="pending"
    	                lab_WaterEffluentMonitoringInstance.applicationStatus="pending"
    	            lab_WaterEffluentMonitoringInstance.properties = params
    	            if(!lab_WaterEffluentMonitoringInstance.hasErrors() && lab_WaterEffluentMonitoringInstance.save()) {
    	                flash.message = "Lab_WaterEffluentMonitoring ${params.id} updated"
    	                redirect(action:show,id:lab_WaterEffluentMonitoringInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[lab_WaterEffluentMonitoringInstance:lab_WaterEffluentMonitoringInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Lab_WaterEffluentMonitoring not found with id ${params.id}"
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
    			def lab_WaterEffluentMonitoringInstance = new Lab_WaterEffluentMonitoring()
    	        lab_WaterEffluentMonitoringInstance.properties = params
    	        return ['lab_WaterEffluentMonitoringInstance':lab_WaterEffluentMonitoringInstance]
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
    			def lab_WaterEffluentMonitoringInstance = new Lab_WaterEffluentMonitoring(params)
    	        def userIns=(session.userMaster).toString()
    	        lab_WaterEffluentMonitoringInstance.createdBy=userIns
    	        lab_WaterEffluentMonitoringInstance.updatedBy=userIns
    	        lab_WaterEffluentMonitoringInstance.completionStatus="pending"
    	        lab_WaterEffluentMonitoringInstance.applicationStatus="pending"
    	        if(!lab_WaterEffluentMonitoringInstance.hasErrors() && lab_WaterEffluentMonitoringInstance.save()) {
    	            flash.message = "Lab_WaterEffluentMonitoring ${lab_WaterEffluentMonitoringInstance.id} created"
    	            redirect(action:show,id:lab_WaterEffluentMonitoringInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[lab_WaterEffluentMonitoringInstance:lab_WaterEffluentMonitoringInstance])
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
