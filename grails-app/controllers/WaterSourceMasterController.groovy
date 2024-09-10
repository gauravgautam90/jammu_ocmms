

class WaterSourceMasterController {
    
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
    	        [ waterSourceMasterInstanceList: WaterSourceMaster.list( params ), waterSourceMasterInstanceTotal: WaterSourceMaster.count() ]
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
    	   def waterSourceMasterInstance = WaterSourceMaster.get( params.id )
    	   if(!waterSourceMasterInstance) {
    	            flash.message = "WaterSourceMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterSourceMasterInstance : waterSourceMasterInstance ] }
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
        def waterSourceMasterInstance = WaterSourceMaster.get( params.id )
        if(waterSourceMasterInstance) {
            try {
                waterSourceMasterInstance.delete(flush:true)
                flash.message = "Water Source ${params.sourceName} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Water Source ${params.sourceName} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterSourceMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    	    def waterSourceMasterInstance = WaterSourceMaster.get( params.waterSourceMaster_Id )
    	    if(!waterSourceMasterInstance) {
    	            flash.message = "WaterSourceMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ waterSourceMasterInstance : waterSourceMasterInstance ]
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
    	   def waterSourceMasterInstance = WaterSourceMaster.get( params.id )
    	        if(waterSourceMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterSourceMasterInstance.version > version) {
    	                    waterSourceMasterInstance.errors.rejectValue("version", "waterSourceMaster.optimistic.locking.failure", "Another user has updated this WaterSourceMaster while you were editing.")
    	                    render(view:'edit',model:[waterSourceMasterInstance:waterSourceMasterInstance])
    	                    return
    	                }
    	            }
    	            waterSourceMasterInstance.properties = params
    	            waterSourceMasterInstance.updatedBy=session.userMaster
    	            if(!waterSourceMasterInstance.hasErrors() && waterSourceMasterInstance.save()) {
    	                flash.message = "Water Source ${waterSourceMasterInstance.sourceName} updated"
    	                redirect(action:show,id:waterSourceMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterSourceMasterInstance:waterSourceMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterSourceMaster not found with id ${params.id}"
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
    	 def waterSourceMasterInstance = new WaterSourceMaster()
    	        waterSourceMasterInstance.properties = params
    	        return ['waterSourceMasterInstance':waterSourceMasterInstance]
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
    	    def waterSourceMasterInstance = new WaterSourceMaster(params)
    	        waterSourceMasterInstance.createdBy = session.userMaster
    	        waterSourceMasterInstance.updatedBy = session.userMaster
    	        waterSourceMasterInstance.dateCreated= new Date()
    	        waterSourceMasterInstance.lastUpdated = new Date()
    	        if(!waterSourceMasterInstance.hasErrors() && waterSourceMasterInstance.save()) {
    	            flash.message = "Water Source ${waterSourceMasterInstance.sourceName} created"
    	            redirect(action:show,id:waterSourceMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[waterSourceMasterInstance:waterSourceMasterInstance])
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
