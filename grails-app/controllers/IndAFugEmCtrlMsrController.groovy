

class IndAFugEmCtrlMsrController {
    
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
    	        [ indAFugEmCtrlMsrInstanceList: IndAFugEmCtrlMsr.list( params ), indAFugEmCtrlMsrInstanceTotal: IndAFugEmCtrlMsr.count() ]
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
    	      def indAFugEmCtrlMsrInstance = IndAFugEmCtrlMsr.get( params.id )
    	      if(!indAFugEmCtrlMsrInstance) {
    	            flash.message = "IndAFugEmCtrlMsr not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indAFugEmCtrlMsrInstance : indAFugEmCtrlMsrInstance ] }
    	    
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
        def indAFugEmCtrlMsrInstance = IndAFugEmCtrlMsr.get( params.id )
        if(indAFugEmCtrlMsrInstance) {
            try {
                indAFugEmCtrlMsrInstance.delete()
                flash.message = "IndAFugEmCtrlMsr ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndAFugEmCtrlMsr ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndAFugEmCtrlMsr not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	       def indAFugEmCtrlMsrInstance = IndAFugEmCtrlMsr.get( params.id )

    	        if(!indAFugEmCtrlMsrInstance) {
    	            flash.message = "IndAFugEmCtrlMsr not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indAFugEmCtrlMsrInstance : indAFugEmCtrlMsrInstance ]
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
    	       def indAFugEmCtrlMsrInstance = IndAFugEmCtrlMsr.get( params.id )
    	        if(indAFugEmCtrlMsrInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indAFugEmCtrlMsrInstance.version > version) {
    	                    
    	                    indAFugEmCtrlMsrInstance.errors.rejectValue("version", "indAFugEmCtrlMsr.optimistic.locking.failure", "Another user has updated this IndAFugEmCtrlMsr while you were editing.")
    	                    render(view:'edit',model:[indAFugEmCtrlMsrInstance:indAFugEmCtrlMsrInstance])
    	                    return
    	                }
    	            }
    	            indAFugEmCtrlMsrInstance.properties = params
    	            if(!indAFugEmCtrlMsrInstance.hasErrors() && indAFugEmCtrlMsrInstance.save()) {
    	                flash.message = "IndAFugEmCtrlMsr ${params.id} updated"
    	                redirect(action:show,id:indAFugEmCtrlMsrInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indAFugEmCtrlMsrInstance:indAFugEmCtrlMsrInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndAFugEmCtrlMsr not found with id ${params.id}"
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
    	       def indAFugEmCtrlMsrInstance = new IndAFugEmCtrlMsr()
    	        indAFugEmCtrlMsrInstance.properties = params
    	        return ['indAFugEmCtrlMsrInstance':indAFugEmCtrlMsrInstance]
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
    	      def indAFugEmCtrlMsrInstance = new IndAFugEmCtrlMsr(params)
    	        if(!indAFugEmCtrlMsrInstance.hasErrors() && indAFugEmCtrlMsrInstance.save()) {
    	            flash.message = "IndAFugEmCtrlMsr ${indAFugEmCtrlMsrInstance.id} created"
    	            redirect(action:show,id:indAFugEmCtrlMsrInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indAFugEmCtrlMsrInstance:indAFugEmCtrlMsrInstance])
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
