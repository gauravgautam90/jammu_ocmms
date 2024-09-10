

class WaterModeUseMasterController {
    
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
    	        [ waterModeUseMasterInstanceList: WaterModeUseMaster.list( params ), waterModeUseMasterInstanceTotal: WaterModeUseMaster.count() ]
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
    	   def waterModeUseMasterInstance = WaterModeUseMaster.get( params.id )
    	        if(!waterModeUseMasterInstance) {
    	            flash.message = "WaterModeUseMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterModeUseMasterInstance : waterModeUseMasterInstance ] }
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
        def waterModeUseMasterInstance = WaterModeUseMaster.get( params.id )
        if(waterModeUseMasterInstance) {
            try {
                waterModeUseMasterInstance.delete(flush:true)
                flash.message = "Water Mode Use ${params.modeUsage} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Water Mode Use ${params.modeUsage} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterModeUseMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    	  def waterModeUseMasterInstance = WaterModeUseMaster.get( params.waterModeUseMaster_Id )
    	        if(!waterModeUseMasterInstance) {
    	            flash.message = "WaterModeUseMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ waterModeUseMasterInstance : waterModeUseMasterInstance ]
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
    	   def waterModeUseMasterInstance = WaterModeUseMaster.get( params.id )
    	        if(waterModeUseMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterModeUseMasterInstance.version > version) {
    	                    
    	                    waterModeUseMasterInstance.errors.rejectValue("version", "waterModeUseMaster.optimistic.locking.failure", "Another user has updated this WaterModeUseMaster while you were editing.")
    	                    render(view:'edit',model:[waterModeUseMasterInstance:waterModeUseMasterInstance])
    	                    return
    	                }
    	            }
    	            waterModeUseMasterInstance.properties = params
    	            waterModeUseMasterInstance.updatedBy=session.userMaster
    	            if(!waterModeUseMasterInstance.hasErrors() && waterModeUseMasterInstance.save()) {
    	                flash.message = "Water Mode Use ${waterModeUseMasterInstance.modeUsage} updated"
    	                redirect(action:show,id:waterModeUseMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterModeUseMasterInstance:waterModeUseMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterModeUseMaster not found with id ${params.id}"
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
    	   def waterModeUseMasterInstance = new WaterModeUseMaster()
    	        waterModeUseMasterInstance.properties = params
    	        return ['waterModeUseMasterInstance':waterModeUseMasterInstance]
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
    	   def waterModeUseMasterInstance = new WaterModeUseMaster(params)
    	        waterModeUseMasterInstance.createdBy = session.userMaster
    	        waterModeUseMasterInstance.updatedBy = session.userMaster
    	        waterModeUseMasterInstance.dateCreated= new Date()
    	        waterModeUseMasterInstance.lastUpdated = new Date()
    	        if(!waterModeUseMasterInstance.hasErrors() && waterModeUseMasterInstance.save()) {
    	            flash.message = "Water Mode Use ${waterModeUseMasterInstance.modeUsage} created"
    	            redirect(action:show,id:waterModeUseMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[waterModeUseMasterInstance:waterModeUseMasterInstance])
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
