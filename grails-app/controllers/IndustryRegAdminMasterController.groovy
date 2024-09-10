

class IndustryRegAdminMasterController {
    
    def index = {
    		 try { redirect(action:list,params:params) 
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
    	        [ industryRegAdminMasterInstanceList: IndustryRegAdminMaster.list( params ), industryRegAdminMasterInstanceTotal: IndustryRegAdminMaster.count() ]
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
    	       def industryRegAdminMasterInstance = IndustryRegAdminMaster.get( params.id )
    	       if(!industryRegAdminMasterInstance) {
    	            flash.message = "IndustryRegAdminMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ industryRegAdminMasterInstance : industryRegAdminMasterInstance ] }
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
        def industryRegAdminMasterInstance = IndustryRegAdminMaster.get( params.id )
        if(industryRegAdminMasterInstance) {
            try {
                industryRegAdminMasterInstance.delete()
                flash.message = "IndustryRegAdminMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndustryRegAdminMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndustryRegAdminMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

 def edit = {
    	 try { 
    	        def industryRegAdminMasterInstance = IndustryRegAdminMaster.get( params.id )
    	        if(!industryRegAdminMasterInstance) {
    	            flash.message = "IndustryRegAdminMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ industryRegAdminMasterInstance : industryRegAdminMasterInstance ]
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
    	       def industryRegAdminMasterInstance = IndustryRegAdminMaster.get( params.id )
    	        if(industryRegAdminMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(industryRegAdminMasterInstance.version > version) {
    	                    industryRegAdminMasterInstance.errors.rejectValue("version", "industryRegAdminMaster.optimistic.locking.failure", "Another user has updated this IndustryRegAdminMaster while you were editing.")
    	                    render(view:'edit',model:[industryRegAdminMasterInstance:industryRegAdminMasterInstance])
    	                    return
    	                }
    	            }
    	            industryRegAdminMasterInstance.properties = params
    	            if(!industryRegAdminMasterInstance.hasErrors() && industryRegAdminMasterInstance.save()) {
    	                flash.message = "IndustryRegAdminMaster ${params.id} updated"
    	                redirect(action:show,id:industryRegAdminMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[industryRegAdminMasterInstance:industryRegAdminMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndustryRegAdminMaster not found with id ${params.id}"
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
    	        def industryRegAdminMasterInstance = new IndustryRegAdminMaster()
    	        industryRegAdminMasterInstance.properties = params
    	        return ['industryRegAdminMasterInstance':industryRegAdminMasterInstance]
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
    	        def industryRegAdminMasterInstance = new IndustryRegAdminMaster(params)
    	        if(!industryRegAdminMasterInstance.hasErrors() && industryRegAdminMasterInstance.save()) {
    	            flash.message = "IndustryRegAdminMaster ${industryRegAdminMasterInstance.id} created"
    	            redirect(action:show,id:industryRegAdminMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[industryRegAdminMasterInstance:industryRegAdminMasterInstance])
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
