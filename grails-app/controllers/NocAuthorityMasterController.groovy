
class NocAuthorityMasterController {
    
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

static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ nocAuthorityMasterInstanceList: NocAuthorityMaster.list( params ), nocAuthorityMasterInstanceTotal: NocAuthorityMaster.count() ]
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
    		 def nocAuthorityMasterInstance = NocAuthorityMaster.get( params.id )
    	        if(!nocAuthorityMasterInstance) {
    	            flash.message = "NocAuthorityMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ nocAuthorityMasterInstance : nocAuthorityMasterInstance ] }
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
        def nocAuthorityMasterInstance = NocAuthorityMaster.get( params.id )
        if(nocAuthorityMasterInstance) {
            try {
            	nocAuthorityMasterInstance.delete(flush:true)
                flash.message = " ${params.authority} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = " ${params.authority} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "NOC Authority not found"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		 def nocAuthorityMasterInstance = NocAuthorityMaster.get( params.id )
    	        if(!nocAuthorityMasterInstance) {
    	            flash.message = "NocAuthorityMaster not found"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ nocAuthorityMasterInstance : nocAuthorityMasterInstance ]
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
    		 def nocAuthorityMasterInstance = NocAuthorityMaster.get( params.id )
    	        if(nocAuthorityMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(nocAuthorityMasterInstance.version > version) {
    	                    nocAuthorityMasterInstance.errors.rejectValue("version", "nocAuthorityMaster.optimistic.locking.failure", "Another user has updated this NocAuthorityMaster while you were editing.")
    	                    render(view:'edit',model:[nocAuthorityMasterInstance:nocAuthorityMasterInstance])
    	                    return
    	                }
    	            }
    	            nocAuthorityMasterInstance.properties = params
    	            if(!nocAuthorityMasterInstance.hasErrors() && nocAuthorityMasterInstance.save()) {
    	                flash.message = "NOC Authority Master ${nocAuthorityMasterInstance.authority} updated"
    	                redirect(action:show,id:nocAuthorityMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[nocAuthorityMasterInstance:nocAuthorityMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "NOC Authority Master not found with id ${params.id}"
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
    		 def nocAuthorityMasterInstance = new NocAuthorityMaster()
    	        nocAuthorityMasterInstance.properties = params
    	        return ['nocAuthorityMasterInstance':nocAuthorityMasterInstance]
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
    		 def nocAuthorityMasterInstance= new NocAuthorityMaster(params)
    	        def authorityname=params.authority
    	        def authoritynameInstance=NocAuthorityMaster.findByAuthority(authorityname)
    	        if(authoritynameInstance!=null)
    	        {
    	            flash.message="${authorityname} already Exist"
    	            redirect(action:create)
    	        }
    	       else
    	        {
    	    	   nocAuthorityMasterInstance = new NocAuthorityMaster(params)
    	        if(!nocAuthorityMasterInstance.hasErrors() && nocAuthorityMasterInstance.save()) {
    	            flash.message = "  ${nocAuthorityMasterInstance.authority} created"
    	            redirect(action:show,id:nocAuthorityMasterInstance.id)
    	        }
    	        else 
    	        {
    	            render(view:'create',model:[nocAuthorityMasterInstance:nocAuthorityMasterInstance])
    	        }
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
