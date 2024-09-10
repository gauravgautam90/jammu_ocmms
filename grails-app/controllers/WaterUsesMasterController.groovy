

class WaterUsesMasterController {
    
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
    	        [ waterUsesMasterInstanceList: WaterUsesMaster.list( params ), waterUsesMasterInstanceTotal: WaterUsesMaster.count() ]
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
    	   def waterUsesMasterInstance = WaterUsesMaster.get( params.id )
    	   if(!waterUsesMasterInstance) {
    	            flash.message = "WaterUsesMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterUsesMasterInstance : waterUsesMasterInstance ] }
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
        def waterUsesMasterInstance = WaterUsesMaster.get( params.id )
        if(waterUsesMasterInstance) {
            try {
                waterUsesMasterInstance.delete(flush:true)
                flash.message = "Water Uses ${params.useType} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Water Uses ${params.useType} could not be deleted"
               redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterUsesMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    	    def waterUsesMasterInstance = WaterUsesMaster.get( params.waterUsesMaster_Id )
    	        if(!waterUsesMasterInstance) {
    	            flash.message = "WaterUsesMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ waterUsesMasterInstance : waterUsesMasterInstance ]
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
    	    def waterUsesMasterInstance = WaterUsesMaster.get( params.id )
    	        if(waterUsesMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterUsesMasterInstance.version > version) {
    	                    
    	                    waterUsesMasterInstance.errors.rejectValue("version", "waterUsesMaster.optimistic.locking.failure", "Another user has updated this WaterUsesMaster while you were editing.")
    	                    render(view:'edit',model:[waterUsesMasterInstance:waterUsesMasterInstance])
    	                    return
    	                }
    	            }
    	            waterUsesMasterInstance.properties = params
    	            waterUsesMasterInstance.updatedBy=session.userMaster
    	            if(!waterUsesMasterInstance.hasErrors() && waterUsesMasterInstance.save()) {
    	                flash.message = "Water Uses ${waterUsesMasterInstance.useType} updated"
    	                redirect(action:show,id:waterUsesMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterUsesMasterInstance:waterUsesMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterUsesMaster not found with id ${params.id}"
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
    	    def waterUsesMasterInstance = new WaterUsesMaster()
    	        waterUsesMasterInstance.properties = params
    	        return ['waterUsesMasterInstance':waterUsesMasterInstance]
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
    	    def waterUsesMasterInstance = new WaterUsesMaster(params)
    	       waterUsesMasterInstance.createdBy = session.userMaster
    	        waterUsesMasterInstance.updatedBy = session.userMaster
    	        waterUsesMasterInstance.dateCreated= new Date()
    	        waterUsesMasterInstance.lastUpdated = new Date()
    	       if(!waterUsesMasterInstance.hasErrors() && waterUsesMasterInstance.save()) {
    	            flash.message = "Water Uses ${waterUsesMasterInstance.useType} created"
    	            redirect(action:show,id:waterUsesMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[waterUsesMasterInstance:waterUsesMasterInstance])
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
