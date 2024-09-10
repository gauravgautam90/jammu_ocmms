

class RoleVsActivityController {
    
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
    	        [ roleVsActivityInstanceList: RoleVsActivity.list( params ), roleVsActivityInstanceTotal: RoleVsActivity.count() ]
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
    		def roleVsActivityInstance = RoleVsActivity.get( params.id )
 if(!roleVsActivityInstance) {
    	            flash.message = "RoleVsActivity not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ roleVsActivityInstance : roleVsActivityInstance ] }
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
        def roleVsActivityInstance = RoleVsActivity.get( params.id )
        if(roleVsActivityInstance) {
            try {
                roleVsActivityInstance.delete()
                flash.message = "RoleVsActivity ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "RoleVsActivity ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "RoleVsActivity not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    	def roleVsActivityInstance = RoleVsActivity.get( params.id )
    	if(!roleVsActivityInstance) {
    	            flash.message = "RoleVsActivity not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ roleVsActivityInstance : roleVsActivityInstance ]
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
    		def roleVsActivityInstance = RoleVsActivity.get( params.id )
    	        if(roleVsActivityInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(roleVsActivityInstance.version > version) {
    	                    roleVsActivityInstance.errors.rejectValue("version", "roleVsActivity.optimistic.locking.failure", "Another user has updated this RoleVsActivity while you were editing.")
    	                    render(view:'edit',model:[roleVsActivityInstance:roleVsActivityInstance])
    	                    return
    	                }
    	            }
    	            roleVsActivityInstance.properties = params
    	            if(!roleVsActivityInstance.hasErrors() && roleVsActivityInstance.save()) {
    	                flash.message = "RoleVsActivity ${params.id} updated"
    	                redirect(action:show,id:roleVsActivityInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[roleVsActivityInstance:roleVsActivityInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "RoleVsActivity not found with id ${params.id}"
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
    		 def roleVsActivityInstance = new RoleVsActivity()
    	        roleVsActivityInstance.properties = params
    	        return ['roleVsActivityInstance':roleVsActivityInstance]
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
    		def roleVsActivityInstance = new RoleVsActivity(params)
    	        if(!roleVsActivityInstance.hasErrors() && roleVsActivityInstance.save()) {
    	            flash.message = "RoleVsActivity ${roleVsActivityInstance.id} created"
    	            redirect(action:show,id:roleVsActivityInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[roleVsActivityInstance:roleVsActivityInstance])
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
