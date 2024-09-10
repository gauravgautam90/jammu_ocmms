

class IndAirStkEmPrmController {
    
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
    	        [ indAirStkEmPrmInstanceList: IndAirStkEmPrm.list( params ), indAirStkEmPrmInstanceTotal: IndAirStkEmPrm.count() ]
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
    	      def indAirStkEmPrmInstance = IndAirStkEmPrm.get( params.id )
    	      if(!indAirStkEmPrmInstance) {
    	            flash.message = "IndAirStkEmPrm not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indAirStkEmPrmInstance : indAirStkEmPrmInstance ] }
    	    
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
        def indAirStkEmPrmInstance = IndAirStkEmPrm.get( params.id )
        if(indAirStkEmPrmInstance) {
            try {
                indAirStkEmPrmInstance.delete()
                flash.message = "IndAirStkEmPrm ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndAirStkEmPrm ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndAirStkEmPrm not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	       def indAirStkEmPrmInstance = IndAirStkEmPrm.get( params.id )
    	       if(!indAirStkEmPrmInstance) {
    	            flash.message = "IndAirStkEmPrm not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indAirStkEmPrmInstance : indAirStkEmPrmInstance ]
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
    	       def indAirStkEmPrmInstance = IndAirStkEmPrm.get( params.id )
    	        if(indAirStkEmPrmInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indAirStkEmPrmInstance.version > version) {
    	                    
    	                    indAirStkEmPrmInstance.errors.rejectValue("version", "indAirStkEmPrm.optimistic.locking.failure", "Another user has updated this IndAirStkEmPrm while you were editing.")
    	                    render(view:'edit',model:[indAirStkEmPrmInstance:indAirStkEmPrmInstance])
    	                    return
    	                }
    	            }
    	            indAirStkEmPrmInstance.properties = params
    	            if(!indAirStkEmPrmInstance.hasErrors() && indAirStkEmPrmInstance.save()) {
    	                flash.message = "IndAirStkEmPrm ${params.id} updated"
    	                redirect(action:show,id:indAirStkEmPrmInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indAirStkEmPrmInstance:indAirStkEmPrmInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndAirStkEmPrm not found with id ${params.id}"
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
    	      def indAirStkEmPrmInstance = new IndAirStkEmPrm()
    	        indAirStkEmPrmInstance.properties = params
    	        return ['indAirStkEmPrmInstance':indAirStkEmPrmInstance]
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
    	       def indAirStkEmPrmInstance = new IndAirStkEmPrm(params)
    	        if(!indAirStkEmPrmInstance.hasErrors() && indAirStkEmPrmInstance.save()) {
    	            flash.message = "IndAirStkEmPrm ${indAirStkEmPrmInstance.id} created"
    	            redirect(action:show,id:indAirStkEmPrmInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indAirStkEmPrmInstance:indAirStkEmPrmInstance])
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
