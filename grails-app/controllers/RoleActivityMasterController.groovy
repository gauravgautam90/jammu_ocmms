

class RoleActivityMasterController {
    
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
    	        [ roleActivityMasterInstanceList: RoleActivityMaster.list( params ), roleActivityMasterInstanceTotal: RoleActivityMaster.count() ]
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

    	    	
    	       
    	        def roleActivityMasterInstance = RoleActivityMaster.get( params.id )

    	        if(!roleActivityMasterInstance) {
    	            flash.message = "RoleActivityMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ roleActivityMasterInstance : roleActivityMasterInstance ] }
    	    
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
        def roleActivityMasterInstance = RoleActivityMaster.get( params.id )
        if(roleActivityMasterInstance) {
            try {
                roleActivityMasterInstance.delete()
                flash.message = "RoleActivityMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "RoleActivityMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "RoleActivityMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		 def roleActivityMasterInstance = RoleActivityMaster.get( params.id )
    	        if(!roleActivityMasterInstance) {
    	            flash.message = "RoleActivityMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ roleActivityMasterInstance : roleActivityMasterInstance ]
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
    		 def roleActivityMasterInstance = RoleActivityMaster.get( params.id )
    	        if(roleActivityMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(roleActivityMasterInstance.version > version) {
    	                    
    	                    roleActivityMasterInstance.errors.rejectValue("version", "roleActivityMaster.optimistic.locking.failure", "Another user has updated this RoleActivityMaster while you were editing.")
    	                    render(view:'edit',model:[roleActivityMasterInstance:roleActivityMasterInstance])
    	                    return
    	                }
    	            }
    	            roleActivityMasterInstance.properties = params
    	            if(!roleActivityMasterInstance.hasErrors() && roleActivityMasterInstance.save()) {
    	                flash.message = "RoleActivityMaster ${params.id} updated"
    	                redirect(action:show,id:roleActivityMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[roleActivityMasterInstance:roleActivityMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "RoleActivityMaster not found with id ${params.id}"
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
    		 def roleActivityMasterInstance = new RoleActivityMaster()
    	        roleActivityMasterInstance.properties = params
    	        return ['roleActivityMasterInstance':roleActivityMasterInstance]
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
    		 def roleActivityMasterInstance = new RoleActivityMaster(params)
    	        if(!roleActivityMasterInstance.hasErrors() && roleActivityMasterInstance.save()) {
    	            flash.message = "RoleActivityMaster ${roleActivityMasterInstance.id} created"
    	            redirect(action:show,id:roleActivityMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[roleActivityMasterInstance:roleActivityMasterInstance])
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
