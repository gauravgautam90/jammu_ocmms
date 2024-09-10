

class IndAStkEmContMsrController {
    
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
    	        [ indAStkEmContMsrInstanceList: IndAStkEmContMsr.list( params ), indAStkEmContMsrInstanceTotal: IndAStkEmContMsr.count() ]
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
 			def indAStkEmContMsrInstance = IndAStkEmContMsr.get( params.id )
 			if(!indAStkEmContMsrInstance) {
    	            flash.message = "IndAStkEmContMsr not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indAStkEmContMsrInstance : indAStkEmContMsrInstance ] }
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
        def indAStkEmContMsrInstance = IndAStkEmContMsr.get( params.id )
        if(indAStkEmContMsrInstance) {
            try {
                indAStkEmContMsrInstance.delete()
                flash.message = "IndAStkEmContMsr ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndAStkEmContMsr ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndAStkEmContMsr not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
 			 def indAStkEmContMsrInstance = IndAStkEmContMsr.get( params.id )
 			 if(!indAStkEmContMsrInstance) {
    	            flash.message = "IndAStkEmContMsr not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indAStkEmContMsrInstance : indAStkEmContMsrInstance ]
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
 			 def indAStkEmContMsrInstance = IndAStkEmContMsr.get( params.id )
    	        if(indAStkEmContMsrInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indAStkEmContMsrInstance.version > version) {
    	                    indAStkEmContMsrInstance.errors.rejectValue("version", "indAStkEmContMsr.optimistic.locking.failure", "Another user has updated this IndAStkEmContMsr while you were editing.")
    	                    render(view:'edit',model:[indAStkEmContMsrInstance:indAStkEmContMsrInstance])
    	                    return
    	                }
    	            }
    	            indAStkEmContMsrInstance.properties = params
    	            if(!indAStkEmContMsrInstance.hasErrors() && indAStkEmContMsrInstance.save()) {
    	                flash.message = "IndAStkEmContMsr ${params.id} updated"
    	                redirect(action:show,id:indAStkEmContMsrInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indAStkEmContMsrInstance:indAStkEmContMsrInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndAStkEmContMsr not found with id ${params.id}"
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
 			def indAStkEmContMsrInstance = new IndAStkEmContMsr()
    	        indAStkEmContMsrInstance.properties = params
    	        return ['indAStkEmContMsrInstance':indAStkEmContMsrInstance]
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
 			def indAStkEmContMsrInstance = new IndAStkEmContMsr(params)
    	        if(!indAStkEmContMsrInstance.hasErrors() && indAStkEmContMsrInstance.save()) {
    	            flash.message = "IndAStkEmContMsr ${indAStkEmContMsrInstance.id} created"
    	            redirect(action:show,id:indAStkEmContMsrInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indAStkEmContMsrInstance:indAStkEmContMsrInstance])
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
