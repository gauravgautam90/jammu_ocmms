

class DgParameterMasterController {
    
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
    	        [ dgParameterMasterInstanceList: DgParameterMaster.list( params ), dgParameterMasterInstanceTotal: DgParameterMaster.count() ]
    	     }
    	 catch(Exception e) {
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
    		 def dgParameterMasterInstance = DgParameterMaster.get( params.id )
    		 if(!dgParameterMasterInstance) {
    	            flash.message = "DgParameterMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ dgParameterMasterInstance : dgParameterMasterInstance ] }
    	    }
    	 catch(Exception e) {
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
        def dgParameterMasterInstance = DgParameterMaster.get( params.id )
        if(dgParameterMasterInstance) {
            try {
            	dgParameterMasterInstance.delete(flush:true)
                flash.message = " ${params.parameterDG} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = " ${params.parameterDG} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "DGParameter not found"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    		 def dgParameterMasterInstance = DgParameterMaster.get( params.id )
    		 if(!dgParameterMasterInstance) {
    	            flash.message = "DgParameterMaster not found"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ dgParameterMasterInstance : dgParameterMasterInstance ]
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
    		 def dgParameterMasterInstance = DgParameterMaster.get( params.id )
    	        if(dgParameterMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(dgParameterMasterInstance.version > version) {
    	                    
    	                	dgParameterMasterInstance.errors.rejectValue("version", "dgParameterMaster.optimistic.locking.failure", "Another user has updated this DgParameterMaster while you were editing.")
    	                    render(view:'edit',model:[dgParameterMasterInstance:dgParameterMasterInstance])
    	                    return
    	                }
    	            }
    	            dgParameterMasterInstance.properties = params
    	            if(!dgParameterMasterInstance.hasErrors() && dgParameterMasterInstance.save()) {
    	                flash.message = "DG Parameter ${dgParameterMasterInstance.parameterDG} updated"
    	                redirect(action:show,id:dgParameterMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[dgParameterMasterInstance:dgParameterMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "DgParameterMaster not found with id ${params.id}"
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
    		 def dgParameterMasterInstance = new DgParameterMaster()
    	        dgParameterMasterInstance.properties = params
    	        return ['dgParameterMasterInstance':dgParameterMasterInstance]
    	     }
    	 catch(Exception e) {
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
    		 def dgParameterMasterInstance= new DgParameterMaster(params)
    	       def dgname=params.parameterDG
    	        def dgnameInstance=DgParameterMaster.findByparameterDG(dgname)
    	        if(dgnameInstance!=null)
    	        {
    	            flash.message="${dgname} already Exist"
    	            redirect(action:create)
    	        }
    	       else
    	        {
    	    	   dgParameterMasterInstance = new DgParameterMaster(params)
    	        if(!dgParameterMasterInstance.hasErrors() && dgParameterMasterInstance.save()) {
    	            flash.message = "  ${dgParameterMasterInstance.parameterDG} created"
    	            redirect(action:show,id:dgParameterMasterInstance.id)
    	        }
    	        else 
    	        {
    	            render(view:'create',model:[dgParameterMasterInstance:dgParameterMasterInstance])
    	        }
    	        }
    	    }
    	 catch(Exception e) {
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
