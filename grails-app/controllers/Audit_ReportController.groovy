

class Audit_ReportController {
    
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
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ audit_ReportInstanceList: Audit_Report.list( params ), audit_ReportInstanceTotal: Audit_Report.count() ]
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
    	       def audit_ReportInstance = Audit_Report.get( params.id )
    	       if(!audit_ReportInstance) {
    	            flash.message = "Audit_Report not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ audit_ReportInstance : audit_ReportInstance ] }
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
    	 try { 
    	        def audit_ReportInstance = Audit_Report.get( params.id )
    	        if(audit_ReportInstance) {
    	            try {
    	                audit_ReportInstance.delete()
    	                flash.message = "Audit_Report ${params.id} deleted"
    	                redirect(action:list)
    	            }
    	            catch(org.springframework.dao.DataIntegrityViolationException e) {
    	                flash.message = "Audit_Report ${params.id} could not be deleted"
    	                redirect(action:show,id:params.id)
    	            }
    	        }
    	        else {
    	            flash.message = "Audit_Report not found with id ${params.id}"
    	            redirect(action:list)
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

    def edit = {
    	 try { 
    	        def audit_ReportInstance = Audit_Report.get( params.id )
    	        if(!audit_ReportInstance) {
    	            flash.message = "Audit_Report not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ audit_ReportInstance : audit_ReportInstance ]
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

    def update = {
    	 try { 
    	        def audit_ReportInstance = Audit_Report.get( params.id )
    	        if(audit_ReportInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(audit_ReportInstance.version > version) {
    	                    audit_ReportInstance.errors.rejectValue("version", "audit_Report.optimistic.locking.failure", "Another user has updated this Audit_Report while you were editing.")
    	                    render(view:'edit',model:[audit_ReportInstance:audit_ReportInstance])
    	                    return
    	                }
    	            }
    	            audit_ReportInstance.properties = params
    	            if(!audit_ReportInstance.hasErrors() && audit_ReportInstance.save()) {
    	                flash.message = "Audit_Report ${params.id} updated"
    	                redirect(action:show,id:audit_ReportInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[audit_ReportInstance:audit_ReportInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Audit_Report not found with id ${params.id}"
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
    	        def audit_ReportInstance = new Audit_Report()
    	        audit_ReportInstance.properties = params
    	        return ['audit_ReportInstance':audit_ReportInstance]
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
    	       def audit_ReportInstance = new Audit_Report(params)
    	        if(!audit_ReportInstance.hasErrors() && audit_ReportInstance.save()) {
    	            flash.message = "Audit_Report ${audit_ReportInstance.id} created"
    	            redirect(action:show,id:audit_ReportInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[audit_ReportInstance:audit_ReportInstance])
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
    
}
