

class EffluentTypeMasterController {
    
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
    	        [ effluentTypeMasterInstanceList: EffluentTypeMaster.list( params ), effluentTypeMasterInstanceTotal: EffluentTypeMaster.count() ]
    	    
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
    	     def effluentTypeMasterInstance = EffluentTypeMaster.get( params.id )
    	     if(!effluentTypeMasterInstance) {
    	            flash.message = "EffluentTypeMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ effluentTypeMasterInstance : effluentTypeMasterInstance ] }
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
        def effluentTypeMasterInstance = EffluentTypeMaster.get( params.id )
        if(effluentTypeMasterInstance) {
            try {
                effluentTypeMasterInstance.delete(flush:true)
                flash.message = "Effluent Type ${params.effluentType} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Effluent Type ${params.effluentType} could not be deleted"
               redirect(action:updatePage)
            }
        }
        else {
            flash.message = "EffluentTypeMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    	     def effluentTypeMasterInstance = EffluentTypeMaster.get( params.effluentTypeMaster_Id )
    	     if(!effluentTypeMasterInstance) {
    	            flash.message = "EffluentTypeMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ effluentTypeMasterInstance : effluentTypeMasterInstance ]
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
        def effluentTypeMasterInstance = EffluentTypeMaster.get( params.id )
        if(effluentTypeMasterInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(effluentTypeMasterInstance.version > version) {
                    
                    effluentTypeMasterInstance.errors.rejectValue("version", "effluentTypeMaster.optimistic.locking.failure", "Another user has updated this EffluentTypeMaster while you were editing.")
                    render(view:'edit',model:[effluentTypeMasterInstance:effluentTypeMasterInstance])
                    return
                }
            }
            effluentTypeMasterInstance.properties = params
            effluentTypeMasterInstance.updatedBy=session.userMaster
            if(!effluentTypeMasterInstance.hasErrors() && effluentTypeMasterInstance.save()) {
                flash.message = "Effluent Type ${effluentTypeMasterInstance.effluentType} updated"
                redirect(action:show,id:effluentTypeMasterInstance.id)
            }
            else {
                render(view:'edit',model:[effluentTypeMasterInstance:effluentTypeMasterInstance])
            }
        }
        else {
            flash.message = "EffluentTypeMaster not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
    	 try {
    	      def effluentTypeMasterInstance = new EffluentTypeMaster()
    	        effluentTypeMasterInstance.properties = params
    	        return ['effluentTypeMasterInstance':effluentTypeMasterInstance]
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
    	     def effluentTypeMasterInstance = new EffluentTypeMaster(params)
    	        effluentTypeMasterInstance.createdBy = session.userMaster
    	        effluentTypeMasterInstance.updatedBy = session.userMaster
    	        effluentTypeMasterInstance.dateCreated= new Date()
    	        effluentTypeMasterInstance.lastUpdated = new Date()
    	        if(!effluentTypeMasterInstance.hasErrors() && effluentTypeMasterInstance.save()) {
    	            flash.message = "Effluent Type ${effluentTypeMasterInstance.effluentType} created"
    	            redirect(action:show,id:effluentTypeMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[effluentTypeMasterInstance:effluentTypeMasterInstance])
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
