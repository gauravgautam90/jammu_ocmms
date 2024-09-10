

class UnitTypeMasterController {
    
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
    	        [ unitTypeMasterInstanceList: UnitTypeMaster.list( params ), unitTypeMasterInstanceTotal: UnitTypeMaster.count() ]
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
    	 def unitTypeMasterInstance = UnitTypeMaster.get( params.id )
    	        if(!unitTypeMasterInstance) {
    	            flash.message = "UnitTypeMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ unitTypeMasterInstance : unitTypeMasterInstance ] }
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
        def unitTypeMasterInstance = UnitTypeMaster.get( params.id )
        if(unitTypeMasterInstance) {
            try {
                unitTypeMasterInstance.delete(flush:true)
                flash.message = "Unit Type ${params.unitTypeName} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "${params.unitTypeName} is still used in Unit. First delete Unit related to ${params.unitTypeName} "
                 redirect(action:updatePage)
            }
        }
        else {
            flash.message = "UnitTypeMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    		def unitTypeMasterInstance = UnitTypeMaster.get( params.unitTypeMaster_Id )
    	        if(!unitTypeMasterInstance) {
    	            flash.message = "UnitTypeMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ unitTypeMasterInstance : unitTypeMasterInstance ]
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
    		def unitTypeMasterInstance = UnitTypeMaster.get( params.id )
    	        if(unitTypeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(unitTypeMasterInstance.version > version) {
    	                    unitTypeMasterInstance.errors.rejectValue("version", "unitTypeMaster.optimistic.locking.failure", "Another user has updated this UnitTypeMaster while you were editing.")
    	                    render(view:'edit',model:[unitTypeMasterInstance:unitTypeMasterInstance])
    	                    return
    	                }
    	            }
    	            unitTypeMasterInstance.properties = params
    	            unitTypeMasterInstance.updatedBy=session.userMaster
    	            if(!unitTypeMasterInstance.hasErrors() && unitTypeMasterInstance.save()) {
    	                flash.message = "Unit Type ${unitTypeMasterInstance.unitTypeName} updated"
    	                redirect(action:show,id:unitTypeMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[unitTypeMasterInstance:unitTypeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "UnitTypeMaster not found with id ${params.id}"
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
    		def unitTypeMasterInstance = new UnitTypeMaster()
    	        unitTypeMasterInstance.properties = params
    	        return ['unitTypeMasterInstance':unitTypeMasterInstance]
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
    		def unitTypeMasterInstance = new UnitTypeMaster(params)
    	        unitTypeMasterInstance.createdBy = session.userMaster
    	        unitTypeMasterInstance.updatedBy = session.userMaster
    	        unitTypeMasterInstance.dateCreated= new Date()
    	        unitTypeMasterInstance.lastUpdated = new Date()
    	        unitTypeMasterInstance.unitTypeName= params.unitTypeName
    	        if(!unitTypeMasterInstance.hasErrors() && unitTypeMasterInstance.save()) {
    	            flash.message = "Unit Type ${unitTypeMasterInstance.unitTypeName} created"
    	            redirect(action:show,id:unitTypeMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[unitTypeMasterInstance:unitTypeMasterInstance])
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
