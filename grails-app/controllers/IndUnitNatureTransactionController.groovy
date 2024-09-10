

class IndUnitNatureTransactionController {
    
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
    	        [ indUnitNatureTransactionInstanceList: IndUnitNatureTransaction.list( params ), indUnitNatureTransactionInstanceTotal: IndUnitNatureTransaction.count() ]
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
    			 def indUnitNatureTransactionInstance = IndUnitNatureTransaction.get( params.id )
    			 if(!indUnitNatureTransactionInstance) {
    	            flash.message = "IndUnitNatureTransaction not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indUnitNatureTransactionInstance : indUnitNatureTransactionInstance ] }
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
        def indUnitNatureTransactionInstance = IndUnitNatureTransaction.get( params.id )
        if(indUnitNatureTransactionInstance) {
            try {
                indUnitNatureTransactionInstance.delete()
                flash.message = "IndUnitNatureTransaction ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndUnitNatureTransaction ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndUnitNatureTransaction not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    			 def indUnitNatureTransactionInstance = IndUnitNatureTransaction.get( params.id )
    			 if(!indUnitNatureTransactionInstance) {
    	            flash.message = "IndUnitNatureTransaction not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indUnitNatureTransactionInstance : indUnitNatureTransactionInstance ]
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
    			def indUnitNatureTransactionInstance = IndUnitNatureTransaction.get( params.id )
    	        if(indUnitNatureTransactionInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indUnitNatureTransactionInstance.version > version) {
    	                     indUnitNatureTransactionInstance.errors.rejectValue("version", "indUnitNatureTransaction.optimistic.locking.failure", "Another user has updated this IndUnitNatureTransaction while you were editing.")
    	                    render(view:'edit',model:[indUnitNatureTransactionInstance:indUnitNatureTransactionInstance])
    	                    return
    	                }
    	            }
    	            indUnitNatureTransactionInstance.properties = params
    	            if(!indUnitNatureTransactionInstance.hasErrors() && indUnitNatureTransactionInstance.save()) {
    	                flash.message = "IndUnitNatureTransaction ${params.id} updated"
    	                redirect(action:show,id:indUnitNatureTransactionInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indUnitNatureTransactionInstance:indUnitNatureTransactionInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndUnitNatureTransaction not found with id ${params.id}"
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
    			 def indUnitNatureTransactionInstance = new IndUnitNatureTransaction()
    	        indUnitNatureTransactionInstance.properties = params
    	        return ['indUnitNatureTransactionInstance':indUnitNatureTransactionInstance]
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
    			def indUnitNatureTransactionInstance = new IndUnitNatureTransaction(params)
    	        if(!indUnitNatureTransactionInstance.hasErrors() && indUnitNatureTransactionInstance.save()) {
    	            flash.message = "IndUnitNatureTransaction ${indUnitNatureTransactionInstance.id} created"
    	            redirect(action:show,id:indUnitNatureTransactionInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indUnitNatureTransactionInstance:indUnitNatureTransactionInstance])
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
