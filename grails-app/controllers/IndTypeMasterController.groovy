

class IndTypeMasterController {
    
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
    	        [ indTypeMasterInstanceList: IndTypeMaster.list( params ), indTypeMasterInstanceTotal: IndTypeMaster.count() ]
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
    			 def indTypeMasterInstance = IndTypeMaster.get( params.id )
    			 if(!indTypeMasterInstance) {
    	            flash.message = "IndTypeMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indTypeMasterInstance : indTypeMasterInstance ] }
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
        def indTypeMasterInstance = IndTypeMaster.get( params.id )
        if(indTypeMasterInstance) {
            try {
                indTypeMasterInstance.delete()
                flash.message = "IndTypeMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndTypeMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndTypeMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    			def indTypeMasterInstance = IndTypeMaster.get( params.id )
    			if(!indTypeMasterInstance) {
    	            flash.message = "IndTypeMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indTypeMasterInstance : indTypeMasterInstance ]
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
    			def indTypeMasterInstance = IndTypeMaster.get( params.id )
    	        if(indTypeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indTypeMasterInstance.version > version) {
    	                    indTypeMasterInstance.errors.rejectValue("version", "indTypeMaster.optimistic.locking.failure", "Another user has updated this IndTypeMaster while you were editing.")
    	                    render(view:'edit',model:[indTypeMasterInstance:indTypeMasterInstance])
    	                    return
    	                }
    	            }
    	            indTypeMasterInstance.properties = params
    	            if(!indTypeMasterInstance.hasErrors() && indTypeMasterInstance.save()) {
    	                flash.message = "IndTypeMaster ${params.id} updated"
    	                redirect(action:show,id:indTypeMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indTypeMasterInstance:indTypeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndTypeMaster not found with id ${params.id}"
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
    			def indTypeMasterInstance = new IndTypeMaster()
    	        indTypeMasterInstance.properties = params
    	        return ['indTypeMasterInstance':indTypeMasterInstance]
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
    			def indTypeMasterInstance = new IndTypeMaster(params)
    	        if(!indTypeMasterInstance.hasErrors() && indTypeMasterInstance.save()) {
    	            flash.message = "IndTypeMaster ${indTypeMasterInstance.id} created"
    	            redirect(action:show,id:indTypeMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indTypeMasterInstance:indTypeMasterInstance])
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
