

class AirStackCtrlMsrController {
    
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
    	         redirect(action:updateAirStackCtrlMsr,params:params)  
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
    def updateAirStackCtrlMsr = {  }
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
              params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ airStackCtrlMsrInstanceList: AirStackCtrlMsr.list( params ), airStackCtrlMsrInstanceTotal: AirStackCtrlMsr.count() ]
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
    	        def airStackCtrlMsrInstance = AirStackCtrlMsr.get( params.id )
    	        if(!airStackCtrlMsrInstance) {
    	            flash.message = "AirStackCtrlMsr not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ airStackCtrlMsrInstance : airStackCtrlMsrInstance ] }
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
        def airStackCtrlMsrInstance = AirStackCtrlMsr.get( params.id )
        if(airStackCtrlMsrInstance) {
            try {
                airStackCtrlMsrInstance.delete()
                flash.message = "AirStackCtrlMsr ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "AirStackCtrlMsr ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "AirStackCtrlMsr not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try { 
    	        def airStackCtrlMsrInstance = AirStackCtrlMsr.get( params.paramStack )
    	        if(!airStackCtrlMsrInstance) {
    	            flash.message = "AirStackCtrlMsr not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ airStackCtrlMsrInstance : airStackCtrlMsrInstance ]
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
    	        def airStackCtrlMsrInstance = AirStackCtrlMsr.get( params.id )
    	        if(airStackCtrlMsrInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(airStackCtrlMsrInstance.version > version) {
    	                    
    	                    airStackCtrlMsrInstance.errors.rejectValue("version", "airStackCtrlMsr.optimistic.locking.failure", "Another user has updated this AirStackCtrlMsr while you were editing.")
    	                    render(view:'edit',model:[airStackCtrlMsrInstance:airStackCtrlMsrInstance])
    	                    return
    	                }
    	            }
    	            airStackCtrlMsrInstance.properties = params
    	            if(!airStackCtrlMsrInstance.hasErrors() && airStackCtrlMsrInstance.save()) {
    	                flash.message = "AirStackCtrlMsr ${params.id} updated"
    	                redirect(action:show,id:airStackCtrlMsrInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[airStackCtrlMsrInstance:airStackCtrlMsrInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AirStackCtrlMsr not found with id ${params.id}"
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
    	        def airStackCtrlMsrInstance = new AirStackCtrlMsr()
    	        airStackCtrlMsrInstance.properties = params
    	        return ['airStackCtrlMsrInstance':airStackCtrlMsrInstance]
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
    	        def airStackCtrlMsrInstance = new AirStackCtrlMsr(params)
    	        if(!airStackCtrlMsrInstance.hasErrors() && airStackCtrlMsrInstance.save()) {
    	            flash.message = "AirStackCtrlMsr ${airStackCtrlMsrInstance.id} created"
    	            redirect(action:show,id:airStackCtrlMsrInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[airStackCtrlMsrInstance:airStackCtrlMsrInstance])
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
    	    	def aEmmisionTypeId = AirEmmisionType.get((params.selectedValue).toInteger())
    	    	def parameterList = AirStackCtrlMsr.findAllByTypeId(aEmmisionTypeId)
    	    	render g.select( width:'10',from:parameterList,optionKey:'id',  id:'paramStack',name:'paramStack')
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
