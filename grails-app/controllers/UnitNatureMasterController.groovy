

class UnitNatureMasterController {
    
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
    
 def updatePage={}
    
 def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ unitNatureMasterInstanceList: UnitNatureMaster.list( params ), unitNatureMasterInstanceTotal: UnitNatureMaster.count() ]
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
    		def unitNatureMasterInstance = UnitNatureMaster.get( params.id )
    		if(!unitNatureMasterInstance) {
    	            flash.message = "UnitNatureMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ unitNatureMasterInstance : unitNatureMasterInstance ] }
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
        def unitNatureMasterInstance = UnitNatureMaster.get( params.id )
        if(unitNatureMasterInstance) {
            try {
                unitNatureMasterInstance.delete()
                flash.message = "UnitNatureMaster ${unitNatureMasterInstance} deleted"
                redirect(action:updatePage)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "UnitNatureMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "UnitNatureMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    		if(params.unitNature_Id == null || params.unitNature_Id=="")
    	    	{
    	    		flash.message = "Please Select Unit Nature to update"
    	    		redirect(action:updatePage)
    	    	}
    	    	else {
    	    	 def unitNatureMasterInstance = UnitNatureMaster.get( params.unitNature_Id )
    	        if(!unitNatureMasterInstance) {
    	            flash.message = "UnitNatureMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ unitNatureMasterInstance : unitNatureMasterInstance ]
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
    
def update = {
    	 try {
    		def unitNatureMasterInstance = UnitNatureMaster.get( params.id )
    	        if(unitNatureMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(unitNatureMasterInstance.version > version) {
    	                    
    	                    unitNatureMasterInstance.errors.rejectValue("version", "unitNatureMaster.optimistic.locking.failure", "Another user has updated this UnitNatureMaster while you were editing.")
    	                    render(view:'edit',model:[unitNatureMasterInstance:unitNatureMasterInstance])
    	                    return
    	                }
    	            }
    	            unitNatureMasterInstance.properties = params
    	            if(!unitNatureMasterInstance.hasErrors() && unitNatureMasterInstance.save()) {
    	                flash.message = "UnitNatureMaster ${unitNatureMasterInstance} updated"
    	                redirect(action:show,id:unitNatureMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[unitNatureMasterInstance:unitNatureMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "UnitNatureMaster not found with id ${params.id}"
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
    		 def unitNatureMasterInstance = new UnitNatureMaster()
    	        unitNatureMasterInstance.properties = params
    	        return ['unitNatureMasterInstance':unitNatureMasterInstance]
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
    		def unitNatureMasterInstance = new UnitNatureMaster(params)
    	        if(!unitNatureMasterInstance.hasErrors() && unitNatureMasterInstance.save()) {
    	            flash.message = "UnitNatureMaster ${unitNatureMasterInstance} created"
    	            redirect(action:show,id:unitNatureMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[unitNatureMasterInstance:unitNatureMasterInstance])
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
