

class WaterDisposalModeMasterController {
    
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
    
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    	     params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ waterDisposalModeMasterInstanceList: WaterDisposalModeMaster.list( params ), waterDisposalModeMasterInstanceTotal: WaterDisposalModeMaster.count() ]
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
    	   def waterDisposalModeMasterInstance = WaterDisposalModeMaster.get( params.id )
    	        if(!waterDisposalModeMasterInstance) {
    	            flash.message = "WaterDisposalModeMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterDisposalModeMasterInstance : waterDisposalModeMasterInstance ] }
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
        def waterDisposalModeMasterInstance = WaterDisposalModeMaster.get( params.id )
        if(waterDisposalModeMasterInstance) {
            try {
                waterDisposalModeMasterInstance.delete(flush:true)
                flash.message = "Water Disposal Mode ${params.disposalMode} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Water Disposal Mode ${params.disposalMode} could not be deleted"
                 redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterDisposalModeMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    	   def waterDisposalModeMasterInstance = WaterDisposalModeMaster.get( params.waterDisposalModeMaster_Id )
    	        if(!waterDisposalModeMasterInstance) {
    	            flash.message = "WaterDisposalModeMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ waterDisposalModeMasterInstance : waterDisposalModeMasterInstance ]
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
    	   def waterDisposalModeMasterInstance = WaterDisposalModeMaster.get( params.id )
    	        if(waterDisposalModeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterDisposalModeMasterInstance.version > version) {
    	                    waterDisposalModeMasterInstance.errors.rejectValue("version", "waterDisposalModeMaster.optimistic.locking.failure", "Another user has updated this WaterDisposalModeMaster while you were editing.")
    	                    render(view:'edit',model:[waterDisposalModeMasterInstance:waterDisposalModeMasterInstance])
    	                    return
    	                }
    	            }
    	            waterDisposalModeMasterInstance.properties = params
    	            waterDisposalModeMasterInstance.updatedBy=session.userMaster
    	            if(!waterDisposalModeMasterInstance.hasErrors() && waterDisposalModeMasterInstance.save()) {
    	                flash.message = "Water Disposal Mode ${waterDisposalModeMasterInstance.disposalMode} updated"
    	                redirect(action:show,id:waterDisposalModeMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterDisposalModeMasterInstance:waterDisposalModeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterDisposalModeMaster not found with id ${params.id}"
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
    	     def waterDisposalModeMasterInstance = new WaterDisposalModeMaster()
    	        waterDisposalModeMasterInstance.properties = params
    	        return ['waterDisposalModeMasterInstance':waterDisposalModeMasterInstance]
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
    	     def waterDisposalModeMasterInstance = new WaterDisposalModeMaster(params)
    	        waterDisposalModeMasterInstance.createdBy = session.userMaster
    	        waterDisposalModeMasterInstance.updatedBy = session.userMaster
    	        waterDisposalModeMasterInstance.dateCreated= new Date()
    	        waterDisposalModeMasterInstance.lastUpdated = new Date()
    	        if(!waterDisposalModeMasterInstance.hasErrors() && waterDisposalModeMasterInstance.save()) {
    	            flash.message = "Water Disposal Mode ${waterDisposalModeMasterInstance.disposalMode} created"
    	            redirect(action:show,id:waterDisposalModeMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[waterDisposalModeMasterInstance:waterDisposalModeMasterInstance])
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
