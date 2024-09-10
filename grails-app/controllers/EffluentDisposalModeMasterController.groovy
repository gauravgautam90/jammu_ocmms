

class EffluentDisposalModeMasterController {
    
    def index = {
    		 try {
    		      redirect(action:create,params:params) 
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

    def updatePage={}
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    	      params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ effluentDisposalModeMasterInstanceList: EffluentDisposalModeMaster.list( params ), effluentDisposalModeMasterInstanceTotal: EffluentDisposalModeMaster.count() ]
    	    
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
    	      def effluentDisposalModeMasterInstance = EffluentDisposalModeMaster.get( params.id )
    	        if(!effluentDisposalModeMasterInstance) {
    	            flash.message = "EffluentDisposalModeMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ effluentDisposalModeMasterInstance : effluentDisposalModeMasterInstance ] }
    	    
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
        def effluentDisposalModeMasterInstance = EffluentDisposalModeMaster.get( params.id )
        if(effluentDisposalModeMasterInstance) {
            try {
                effluentDisposalModeMasterInstance.delete(flush:true)
                flash.message = "Effluent Disposal Mode ${params.disposalMode} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Effluent Disposal Mode ${params.disposalMode} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "EffluentDisposalModeMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    	       def effluentDisposalModeMasterInstance = EffluentDisposalModeMaster.get( params.effluentDisposalModeMaster_Id )
    	       if(!effluentDisposalModeMasterInstance) {
    	            flash.message = "EffluentDisposalModeMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ effluentDisposalModeMasterInstance : effluentDisposalModeMasterInstance ]
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
    	      def effluentDisposalModeMasterInstance = EffluentDisposalModeMaster.get( params.id )
    	        if(effluentDisposalModeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(effluentDisposalModeMasterInstance.version > version) {
    	                    
    	                    effluentDisposalModeMasterInstance.errors.rejectValue("version", "effluentDisposalModeMaster.optimistic.locking.failure", "Another user has updated this EffluentDisposalModeMaster while you were editing.")
    	                    render(view:'edit',model:[effluentDisposalModeMasterInstance:effluentDisposalModeMasterInstance])
    	                    return
    	                }
    	            }
    	            effluentDisposalModeMasterInstance.properties = params
    	            effluentDisposalModeMasterInstance.updatedBy=session.userMaster
    	            if(!effluentDisposalModeMasterInstance.hasErrors() && effluentDisposalModeMasterInstance.save()) {
    	                flash.message = "Effluent Disposal Mode ${effluentDisposalModeMasterInstance.disposalMode} updated"
    	                redirect(action:show,id:effluentDisposalModeMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[effluentDisposalModeMasterInstance:effluentDisposalModeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "EffluentDisposalModeMaster not found with id ${params.id}"
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
    	      def effluentDisposalModeMasterInstance = new EffluentDisposalModeMaster()
    	        effluentDisposalModeMasterInstance.properties = params
    	        return ['effluentDisposalModeMasterInstance':effluentDisposalModeMasterInstance]
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
    	      def effluentDisposalModeMasterInstance = new EffluentDisposalModeMaster(params)
    	        effluentDisposalModeMasterInstance.createdBy = session.userMaster
    	        effluentDisposalModeMasterInstance.updatedBy = session.userMaster
    	        effluentDisposalModeMasterInstance.dateCreated= new Date()
    	        effluentDisposalModeMasterInstance.lastUpdated = new Date()
    	        if(!effluentDisposalModeMasterInstance.hasErrors() && effluentDisposalModeMasterInstance.save()) {
    	            flash.message = "Effluent Disposal Mode ${effluentDisposalModeMasterInstance.disposalMode} created"
    	            redirect(action:show,id:effluentDisposalModeMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[effluentDisposalModeMasterInstance:effluentDisposalModeMasterInstance])
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
