

class IndAirStackEmmisionController {
    
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
    	        [ indAirStackEmmisionInstanceList: IndAirStackEmmision.list( params ), indAirStackEmmisionInstanceTotal: IndAirStackEmmision.count() ]
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
    	       def indAirStackEmmisionInstance = IndAirStackEmmision.get( params.id )
    	       if(!indAirStackEmmisionInstance) {
    	            flash.message = "IndAirStackEmmision not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indAirStackEmmisionInstance : indAirStackEmmisionInstance ] }
    	    
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
        def indAirStackEmmisionInstance = IndAirStackEmmision.get( params.id )
        if(indAirStackEmmisionInstance) {
            try {
                indAirStackEmmisionInstance.delete()
                flash.message = "IndAirStackEmmision ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndAirStackEmmision ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndAirStackEmmision not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	       def indAirStackEmmisionInstance = IndAirStackEmmision.get( params.id )
    	       if(!indAirStackEmmisionInstance) {
    	            flash.message = "IndAirStackEmmision not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indAirStackEmmisionInstance : indAirStackEmmisionInstance ]
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
    	       def indAirStackEmmisionInstance = IndAirStackEmmision.get( params.id )
    	        if(indAirStackEmmisionInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indAirStackEmmisionInstance.version > version) {
    	                    
    	                    indAirStackEmmisionInstance.errors.rejectValue("version", "indAirStackEmmision.optimistic.locking.failure", "Another user has updated this IndAirStackEmmision while you were editing.")
    	                    render(view:'edit',model:[indAirStackEmmisionInstance:indAirStackEmmisionInstance])
    	                    return
    	                }
    	            }
    	            indAirStackEmmisionInstance.properties = params
    	            if(!indAirStackEmmisionInstance.hasErrors() && indAirStackEmmisionInstance.save()) {
    	                flash.message = "IndAirStackEmmision ${params.id} updated"
    	                redirect(action:show,id:indAirStackEmmisionInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indAirStackEmmisionInstance:indAirStackEmmisionInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndAirStackEmmision not found with id ${params.id}"
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
    	      def indAirStackEmmisionInstance = new IndAirStackEmmision()
    	        indAirStackEmmisionInstance.properties = params
    	        return ['indAirStackEmmisionInstance':indAirStackEmmisionInstance]
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
    	      def indAirStackEmmisionInstance = new IndAirStackEmmision(params)
    	        if(!indAirStackEmmisionInstance.hasErrors() && indAirStackEmmisionInstance.save()) {
    	            flash.message = "IndAirStackEmmision ${indAirStackEmmisionInstance.id} created"
    	            redirect(action:show,id:indAirStackEmmisionInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indAirStackEmmisionInstance:indAirStackEmmisionInstance])
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
