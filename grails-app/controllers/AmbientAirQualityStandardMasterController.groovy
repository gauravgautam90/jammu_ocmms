

class AmbientAirQualityStandardMasterController {
    
    def index = {
    		 try { 
    			 redirect(action:list,params:params) 
    	    }
    		 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	       redirect(uri:'/index.gsp');
    	 }
     }
    }
    def updatePage={
    		
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	      params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	      [ ambientAirQualityStandardMasterInstanceList: AmbientAirQualityStandardMaster.list( params ), ambientAirQualityStandardMasterInstanceTotal: AmbientAirQualityStandardMaster.count() ] 
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	         session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
       }
    }

    def show = {
    	 try { 
    	        def ambientAirQualityStandardMasterInstance = AmbientAirQualityStandardMaster.get( params.id )
    	        if(!ambientAirQualityStandardMasterInstance) {
    	            flash.message = "AmbientAirQualityStandardMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ ambientAirQualityStandardMasterInstance : ambientAirQualityStandardMasterInstance ] }
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	       session.invalidate()
    	       redirect(uri:'/index.gsp');
    	 }
    }
    }

    def delete = {
        def ambientAirQualityStandardMasterInstance = AmbientAirQualityStandardMaster.get( params.id )
       def checkIfPresent=AmbientAirQualityStandardDetails.findAllByAmbient(ambientAirQualityStandardMasterInstance)
     if(checkIfPresent)
       {
    	   flash.message = "Could not be deleted.Still in use"
    	   redirect(action:updatePage)
       }else{
       if(ambientAirQualityStandardMasterInstance) {
            try {
            	 ambientAirQualityStandardMasterInstance.delete()
                flash.message = "Ambient Air Quality Standard deleted"
                	 redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Ambient Air Quality Standard could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "AmbientAirQualityStandardMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }
    } 
    
    def edit = {
    	 try { 
    	       if(params.ambientAirQualityStandardMaster_Id==null || params.ambientAirQualityStandardMaster_Id=="")
    	    	{
    	    		flash.message="Please select Ambient Air Quality Standard Master to update."
    	    		redirect(action:updatePage)
    	    	}
    	    	else{
    	    	 def ambientAirQualityStandardMasterInstance = AmbientAirQualityStandardMaster.get( params.ambientAirQualityStandardMaster_Id )
    	    	 if(!ambientAirQualityStandardMasterInstance) {
    	            flash.message = "AmbientAirQualityStandardMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ ambientAirQualityStandardMasterInstance : ambientAirQualityStandardMasterInstance ]
    	        }
    	    }
    	   }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	       redirect(uri:'/index.gsp');
    	 }
    }
    }
    
    def update = {
    	 try { 
    	      def ambientAirQualityStandardMasterInstance = AmbientAirQualityStandardMaster.get( params.id )
    	        if(ambientAirQualityStandardMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(ambientAirQualityStandardMasterInstance.version > version) {
    	                    ambientAirQualityStandardMasterInstance.errors.rejectValue("version", "ambientAirQualityStandardMaster.optimistic.locking.failure", "Another user has updated this AmbientAirQualityStandardMaster while you were editing.")
    	                    render(view:'edit',model:[ambientAirQualityStandardMasterInstance:ambientAirQualityStandardMasterInstance])
    	                    return
    	                }
    	            }
    	            ambientAirQualityStandardMasterInstance.properties = params
    	            if(!ambientAirQualityStandardMasterInstance.hasErrors() && ambientAirQualityStandardMasterInstance.save()) {
    	                flash.message = "Ambient Air Quality Standard updated"
    	                redirect(action:show,id:ambientAirQualityStandardMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[ambientAirQualityStandardMasterInstance:ambientAirQualityStandardMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AmbientAirQualityStandardMaster not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
    	        }
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	   redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
      }
    }

    def create = {
    	 try { 
    	       def ambientAirQualityStandardMasterInstance = new AmbientAirQualityStandardMaster()
    	        ambientAirQualityStandardMasterInstance.properties = params
    	        return ['ambientAirQualityStandardMasterInstance':ambientAirQualityStandardMasterInstance]
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	         session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
     }
    }

    def save = {
    	 try { 
    	        def ambientAirQualityStandardMasterInstance = new AmbientAirQualityStandardMaster(params)
    	        if(!ambientAirQualityStandardMasterInstance.hasErrors() && ambientAirQualityStandardMasterInstance.save()) {
    	            flash.message = "Ambient Air Quality Standard created"
    	            redirect(action:show,id:ambientAirQualityStandardMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[ambientAirQualityStandardMasterInstance:ambientAirQualityStandardMasterInstance])
    	        }
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	         session.invalidate()
    	       redirect(uri:'/index.gsp');
    	 }
     }
    }
    
}
