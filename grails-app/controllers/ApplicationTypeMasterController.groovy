

class ApplicationTypeMasterController {
    
    def index = {
    		 try { redirect(action:list,params:params) 
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
    	        [ applicationTypeMasterInstanceList: ApplicationTypeMaster.list( params ), applicationTypeMasterInstanceTotal: ApplicationTypeMaster.count() ]
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
    	        def applicationTypeMasterInstance = ApplicationTypeMaster.get( params.id )
    	        if(!applicationTypeMasterInstance) {
    	            flash.message = "ApplicationTypeMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ applicationTypeMasterInstance : applicationTypeMasterInstance ] }
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
    	        def applicationTypeMasterInstance = ApplicationTypeMaster.get( params.id )
    	        if(applicationTypeMasterInstance) {
    	            try {
    	                applicationTypeMasterInstance.delete()
    	                flash.message = "ApplicationTypeMaster ${params.id} deleted"
    	                redirect(action:list)
    	            }
    	            catch(org.springframework.dao.DataIntegrityViolationException e) {
    	                flash.message = "ApplicationTypeMaster ${params.id} could not be deleted"
    	                redirect(action:show,id:params.id)
    	            }
    	        }
    	        else {
    	            flash.message = "ApplicationTypeMaster not found with id ${params.id}"
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
    	        def applicationTypeMasterInstance = ApplicationTypeMaster.get( params.id )
    	        if(!applicationTypeMasterInstance) {
    	            flash.message = "ApplicationTypeMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ applicationTypeMasterInstance : applicationTypeMasterInstance ]
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
    	       def applicationTypeMasterInstance = ApplicationTypeMaster.get( params.id )
    	        if(applicationTypeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(applicationTypeMasterInstance.version > version) {
    	                     applicationTypeMasterInstance.errors.rejectValue("version", "applicationTypeMaster.optimistic.locking.failure", "Another user has updated this ApplicationTypeMaster while you were editing.")
    	                    render(view:'edit',model:[applicationTypeMasterInstance:applicationTypeMasterInstance])
    	                    return
    	                }
    	            }
    	            applicationTypeMasterInstance.properties = params
    	            if(!applicationTypeMasterInstance.hasErrors() && applicationTypeMasterInstance.save()) {
    	                flash.message = "ApplicationTypeMaster ${params.id} updated"
    	                redirect(action:show,id:applicationTypeMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[applicationTypeMasterInstance:applicationTypeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "ApplicationTypeMaster not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
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

    def create = {
    	 try { 
    	        def applicationTypeMasterInstance = new ApplicationTypeMaster()
    	        applicationTypeMasterInstance.properties = params
    	        return ['applicationTypeMasterInstance':applicationTypeMasterInstance]
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
    	       def applicationTypeMasterInstance = new ApplicationTypeMaster(params)
    	        if(!applicationTypeMasterInstance.hasErrors() && applicationTypeMasterInstance.save()) {
    	            flash.message = "ApplicationTypeMaster ${applicationTypeMasterInstance.id} created"
    	            redirect(action:show,id:applicationTypeMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[applicationTypeMasterInstance:applicationTypeMasterInstance])
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
