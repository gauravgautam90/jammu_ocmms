 

class AirEmiParameterMasterController {
    
    def index = {
    		 try { redirect(action:create,params:params) }catch(Exception e) {
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
    def updatePage={}
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ airEmiParameterMasterInstanceList: AirEmiParameterMaster.list( params ), airEmiParameterMasterInstanceTotal: AirEmiParameterMaster.count() ]
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
    	        def airEmiParameterMasterInstance = AirEmiParameterMaster.get( params.id )
    	        if(!airEmiParameterMasterInstance) {
    	            flash.message = "AirEmiParameterMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ airEmiParameterMasterInstance : airEmiParameterMasterInstance ] }
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
        def airEmiParameterMasterInstance = AirEmiParameterMaster.get( params.id )
        if(airEmiParameterMasterInstance) {
            try {
                airEmiParameterMasterInstance.delete(flush:true)
                flash.message = "Air Emission Parameter ${params.parameter} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Air Emission Parameter ${params.parameter} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "AirEmiParameterMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {  
    	        def airEmiParameterMasterInstance = AirEmiParameterMaster.get( params.airEmiParameterMaster_Id)
    	        if(!airEmiParameterMasterInstance) {
    	            flash.message = "AirEmiParameterMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ airEmiParameterMasterInstance : airEmiParameterMasterInstance ]
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
    	        def airEmiParameterMasterInstance = AirEmiParameterMaster.get( params.id )
    	        if(airEmiParameterMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(airEmiParameterMasterInstance.version > version) {
    	                    
    	                    airEmiParameterMasterInstance.errors.rejectValue("version", "airEmiParameterMaster.optimistic.locking.failure", "Another user has updated this AirEmiParameterMaster while you were editing.")
    	                    render(view:'edit',model:[airEmiParameterMasterInstance:airEmiParameterMasterInstance])
    	                    return
    	                }
    	            }
    	            airEmiParameterMasterInstance.properties = params
    	            airEmiParameterMasterInstance.updatedBy=session.userMaster
    	            if(!airEmiParameterMasterInstance.hasErrors() && airEmiParameterMasterInstance.save()) {
    	                flash.message = "Air Emission Parameter ${params.parameter} updated"
    	                redirect(action:show,id:airEmiParameterMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[airEmiParameterMasterInstance:airEmiParameterMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AirEmiParameterMaster not found with id ${params.id}"
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
    	        def airEmiParameterMasterInstance = new AirEmiParameterMaster()
    	        airEmiParameterMasterInstance.properties = params
    	        return ['airEmiParameterMasterInstance':airEmiParameterMasterInstance]
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
    	        def airEmiParameterMasterInstance = new AirEmiParameterMaster(params)
    	        airEmiParameterMasterInstance.createdBy = session.userMaster
    	        airEmiParameterMasterInstance.updatedBy = session.userMaster
    	        airEmiParameterMasterInstance.dateCreated= new Date()
    	        airEmiParameterMasterInstance.lastUpdated = new Date()
    	        if(!airEmiParameterMasterInstance.hasErrors() && airEmiParameterMasterInstance.save()) {
    	            flash.message = "Air Emission Parameter ${airEmiParameterMasterInstance.parameter} created"
    	            redirect(action:show,id:airEmiParameterMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[airEmiParameterMasterInstance:airEmiParameterMasterInstance])
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
