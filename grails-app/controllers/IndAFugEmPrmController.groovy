

class IndAFugEmPrmController {
    
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
    	        [ indAFugEmPrmInstanceList: IndAFugEmPrm.list( params ), indAFugEmPrmInstanceTotal: IndAFugEmPrm.count() ]
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
    	      def indAFugEmPrmInstance = IndAFugEmPrm.get( params.id )
    	      if(!indAFugEmPrmInstance) {
    	            flash.message = "IndAFugEmPrm not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indAFugEmPrmInstance : indAFugEmPrmInstance ] }
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
        def indAFugEmPrmInstance = IndAFugEmPrm.get( params.id )
        if(indAFugEmPrmInstance) {
            try {
                indAFugEmPrmInstance.delete()
                flash.message = "IndAFugEmPrm ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndAFugEmPrm ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndAFugEmPrm not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	      def indAFugEmPrmInstance = IndAFugEmPrm.get( params.id )
    	      if(!indAFugEmPrmInstance) {
    	            flash.message = "IndAFugEmPrm not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indAFugEmPrmInstance : indAFugEmPrmInstance ]
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
    	       def indAFugEmPrmInstance = IndAFugEmPrm.get( params.id )
    	        if(indAFugEmPrmInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indAFugEmPrmInstance.version > version) {
    	                    
    	                    indAFugEmPrmInstance.errors.rejectValue("version", "indAFugEmPrm.optimistic.locking.failure", "Another user has updated this IndAFugEmPrm while you were editing.")
    	                    render(view:'edit',model:[indAFugEmPrmInstance:indAFugEmPrmInstance])
    	                    return
    	                }
    	            }
    	            indAFugEmPrmInstance.properties = params
    	            if(!indAFugEmPrmInstance.hasErrors() && indAFugEmPrmInstance.save()) {
    	                flash.message = "IndAFugEmPrm ${params.id} updated"
    	                redirect(action:show,id:indAFugEmPrmInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indAFugEmPrmInstance:indAFugEmPrmInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndAFugEmPrm not found with id ${params.id}"
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
    	       def indAFugEmPrmInstance = new IndAFugEmPrm()
    	        indAFugEmPrmInstance.properties = params
    	        return ['indAFugEmPrmInstance':indAFugEmPrmInstance]
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
    	       def indAFugEmPrmInstance = new IndAFugEmPrm(params)
    	        if(!indAFugEmPrmInstance.hasErrors() && indAFugEmPrmInstance.save()) {
    	            flash.message = "IndAFugEmPrm ${indAFugEmPrmInstance.id} created"
    	            redirect(action:show,id:indAFugEmPrmInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indAFugEmPrmInstance:indAFugEmPrmInstance])
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
