

class AirEmmisionParameterController {
    
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
    
def UP = {
    	try { 
    		     redirect(action:updateAirEmmisionParameter,params:params) 
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
    
    def updateAirEmmisionParameter = {  }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ airEmmisionParameterInstanceList: AirEmmisionParameter.list( params ), airEmmisionParameterInstanceTotal: AirEmmisionParameter.count() ]
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
    	        def airEmmisionParameterInstance = AirEmmisionParameter.get( params.id )
    	        if(!airEmmisionParameterInstance) {
    	            flash.message = "AirEmmisionParameter not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ airEmmisionParameterInstance : airEmmisionParameterInstance ] }
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
        def airEmmisionParameterInstance = AirEmmisionParameter.get( params.id )
        if(airEmmisionParameterInstance) {
            try {
                airEmmisionParameterInstance.delete()
                flash.message = "AirEmmisionParameter ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "AirEmmisionParameter ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "AirEmmisionParameter not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try { 
    	        def airEmmisionParameterInstance = AirEmmisionParameter.get( params.param )
    	        if(!airEmmisionParameterInstance) {
    	            flash.message = "AirEmmisionParameter not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ airEmmisionParameterInstance : airEmmisionParameterInstance ]
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
    	        def airEmmisionParameterInstance = AirEmmisionParameter.get( params.id )
    	        if(airEmmisionParameterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(airEmmisionParameterInstance.version > version) {
    	                    
    	                    airEmmisionParameterInstance.errors.rejectValue("version", "airEmmisionParameter.optimistic.locking.failure", "Another user has updated this AirEmmisionParameter while you were editing.")
    	                    render(view:'edit',model:[airEmmisionParameterInstance:airEmmisionParameterInstance])
    	                    return
    	                }
    	            }
    	            airEmmisionParameterInstance.properties = params
    	            if(!airEmmisionParameterInstance.hasErrors() && airEmmisionParameterInstance.save()) {
    	                flash.message = "AirEmmisionParameter ${params.id} updated"
    	                redirect(action:show,id:airEmmisionParameterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[airEmmisionParameterInstance:airEmmisionParameterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AirEmmisionParameter not found with id ${params.id}"
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
    	        def airEmmisionParameterInstance = new AirEmmisionParameter()
    	        airEmmisionParameterInstance.properties = params
    	        return ['airEmmisionParameterInstance':airEmmisionParameterInstance]
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
    	        def airEmmisionParameterInstance = new AirEmmisionParameter(params)
    	        if(!airEmmisionParameterInstance.hasErrors() && airEmmisionParameterInstance.save()) {
    	            flash.message = "AirEmmisionParameter ${airEmmisionParameterInstance.id} created"
    	            redirect(action:show,id:airEmmisionParameterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[airEmmisionParameterInstance:airEmmisionParameterInstance])
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
    
    def updateSelect = {
    	 try { 
    	    	def TypeId = AirEmmisionType.get((params.selectedValue).toInteger())
    	    	def paramList = AirEmmisionParameter.findAllByType(TypeId)
    	    	render g.select( width:'10',from:paramList,optionKey:'id',  id:'param',name:'param')
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
