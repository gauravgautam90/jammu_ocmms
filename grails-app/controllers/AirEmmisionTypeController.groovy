

class AirEmmisionTypeController {
    
    def index = {
    		 try { 
    	    	 redirect(action:list,params:params) 
    	    }catch(Exception e) {
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
    
    def UP = {
    		 try { 
    	    	  redirect(action:UpdateAirEmmisionType,params:params) 
    	    }catch(Exception e) {
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
    
    def UpdateAirEmmisionType = {  }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ airEmmisionTypeInstanceList: AirEmmisionType.list( params ), airEmmisionTypeInstanceTotal: AirEmmisionType.count() ]
    	    }catch(Exception e) {
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
    	        def airEmmisionTypeInstance = AirEmmisionType.get( params.id )
    	        if(!airEmmisionTypeInstance) {
    	            flash.message = "AirEmmisionType not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ airEmmisionTypeInstance : airEmmisionTypeInstance ] }
    	    }catch(Exception e) {
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
        def airEmmisionTypeInstance = AirEmmisionType.get( params.id )
        if(airEmmisionTypeInstance) {
            try {
                airEmmisionTypeInstance.delete()
                flash.message = "AirEmmisionType ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "AirEmmisionType ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "AirEmmisionType not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try { 
    	        def airEmmisionTypeInstance = AirEmmisionType.get( params.typeName )
    	        if(!airEmmisionTypeInstance) {
    	            flash.message = "AirEmmisionType not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ airEmmisionTypeInstance : airEmmisionTypeInstance ]
    	        }
    	    }catch(Exception e) {
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
    	        def airEmmisionTypeInstance = AirEmmisionType.get( params.id )
    	        if(airEmmisionTypeInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(airEmmisionTypeInstance.version > version) {
    	                    
    	                    airEmmisionTypeInstance.errors.rejectValue("version", "airEmmisionType.optimistic.locking.failure", "Another user has updated this AirEmmisionType while you were editing.")
    	                    render(view:'edit',model:[airEmmisionTypeInstance:airEmmisionTypeInstance])
    	                    return
    	                }
    	            }
    	            airEmmisionTypeInstance.properties = params
    	            if(!airEmmisionTypeInstance.hasErrors() && airEmmisionTypeInstance.save()) {
    	                flash.message = "AirEmmisionType ${params.id} updated"
    	                redirect(action:show,id:airEmmisionTypeInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[airEmmisionTypeInstance:airEmmisionTypeInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AirEmmisionType not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
    	        }
    	    }catch(Exception e) {
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
    	        def airEmmisionTypeInstance = new AirEmmisionType()
    	        airEmmisionTypeInstance.properties = params
    	        return ['airEmmisionTypeInstance':airEmmisionTypeInstance]
    	    }catch(Exception e) {
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
    	        def airEmmisionTypeInstance = new AirEmmisionType(params)
    	        if(!airEmmisionTypeInstance.hasErrors() && airEmmisionTypeInstance.save()) {
    	            flash.message = "AirEmmisionType ${airEmmisionTypeInstance.id} created"
    	            redirect(action:show,id:airEmmisionTypeInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[airEmmisionTypeInstance:airEmmisionTypeInstance])
    	        }
    	    }catch(Exception e) {
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
