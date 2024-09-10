

class EffluentParameterMasterController {
    
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
    	        [ effluentParameterMasterInstanceList: EffluentParameterMaster.list( params ), effluentParameterMasterInstanceTotal: EffluentParameterMaster.count() ]
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
    	     def effluentParameterMasterInstance = EffluentParameterMaster.get( params.id )
    	     if(!effluentParameterMasterInstance) {
    	            flash.message = "EffluentParameterMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ effluentParameterMasterInstance : effluentParameterMasterInstance ] }
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
        def effluentParameterMasterInstance = EffluentParameterMaster.get( params.id )
        if(effluentParameterMasterInstance) {
            try {
                effluentParameterMasterInstance.delete(flush:true)
                flash.message = "Effluent Parameter ${params.parameter} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Effluent Parameter ${params.parameter} could not be deleted"
               redirect(action:updatePage)
            }
        }
        else {
            flash.message = "EffluentParameterMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    	      def effluentParameterMasterInstance = EffluentParameterMaster.get( params.effluentParameterMaster_Id )
    	      if(!effluentParameterMasterInstance) {
    	            flash.message = "EffluentParameterMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ effluentParameterMasterInstance : effluentParameterMasterInstance ]
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
    	     def effluentParameterMasterInstance = EffluentParameterMaster.get( params.id )
    	        if(effluentParameterMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(effluentParameterMasterInstance.version > version) {
    	                    
    	                    effluentParameterMasterInstance.errors.rejectValue("version", "effluentParameterMaster.optimistic.locking.failure", "Another user has updated this EffluentParameterMaster while you were editing.")
    	                    render(view:'edit',model:[effluentParameterMasterInstance:effluentParameterMasterInstance])
    	                    return
    	                }
    	            }
    	            effluentParameterMasterInstance.properties = params
    	           effluentParameterMasterInstance.updatedBy = session.userMaster
    	            if(!effluentParameterMasterInstance.hasErrors() && effluentParameterMasterInstance.save()) {
    	                flash.message = "Effluent Parameter ${effluentParameterMasterInstance.parameter} updated"
    	                redirect(action:show,id:effluentParameterMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[effluentParameterMasterInstance:effluentParameterMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "EffluentParameterMaster not found with id ${params.id}"
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
    	      def effluentParameterMasterInstance = new EffluentParameterMaster()
    	        effluentParameterMasterInstance.properties = params
    	        return ['effluentParameterMasterInstance':effluentParameterMasterInstance]
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
    	      def effluentParameterMasterInstance = new EffluentParameterMaster(params)
    	        effluentParameterMasterInstance.createdBy = session.userMaster
    	        effluentParameterMasterInstance.updatedBy = session.userMaster
    	        effluentParameterMasterInstance.dateCreated= new Date()
    	        effluentParameterMasterInstance.lastUpdated = new Date()
    	        if(!effluentParameterMasterInstance.hasErrors() && effluentParameterMasterInstance.save()) {
    	            flash.message = "Effluent Parameter ${effluentParameterMasterInstance.parameter} created"
    	            redirect(action:show,id:effluentParameterMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[effluentParameterMasterInstance:effluentParameterMasterInstance])
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
