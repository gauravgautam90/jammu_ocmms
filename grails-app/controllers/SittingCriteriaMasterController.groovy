

class SittingCriteriaMasterController {
    
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
    
def updatePage={}

static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [sittingCriteriaMasterInstanceList:StoneCrusherParameterMaster.list( params ), sittingCriteriaMasterInstanceTotal: StoneCrusherParameterMaster.count() ]
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
    		  def sittingCriteriaMasterInstance = StoneCrusherParameterMaster.get( params.id )
    	        if(!sittingCriteriaMasterInstance) {
    	            flash.message = "StoneCrusherParameterMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ sittingCriteriaMasterInstance : sittingCriteriaMasterInstance ] }
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
        def sittingCriteriaMasterInstance = StoneCrusherParameterMaster.get( params.id )
        if(sittingCriteriaMasterInstance) {
            try {
            	sittingCriteriaMasterInstance.delete(flush:true)
                flash.message = "Sitting Criteria ${params.parameterName} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Sitting Criteria ${params.parameterName} could not be deleted"
               redirect(action:updatePage)
            }
        }
        else {
            flash.message = "StoneCrusherParameterMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }
    
def edit = {
    	 try {
    		def sittingCriteriaMasterInstance = StoneCrusherParameterMaster.get( params.parameterName )
    	        if(!sittingCriteriaMasterInstance) {
    	            flash.message = "StoneCrusherParameterMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ sittingCriteriaMasterInstance : sittingCriteriaMasterInstance ]
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
    		def sittingCriteriaMasterInstance = StoneCrusherParameterMaster.get( params.id )
    	        if(sittingCriteriaMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(sittingCriteriaMasterInstance.version > version) {
    	                    sittingCriteriaMasterInstance.errors.rejectValue("version", "stoneCrusherParameterMaster.optimistic.locking.failure", "Another user has updated this StoneCrusherParameterMaster while you were editing.")
    	                    render(view:'edit',model:[sittingCriteriaMasterInstance:sittingCriteriaMasterInstance])
    	                    return
    	                }
    	            }
    	            sittingCriteriaMasterInstance.properties = params
    	            if(!sittingCriteriaMasterInstance.hasErrors() && sittingCriteriaMasterInstance.save()) {
    	                flash.message = "Sitting Criteria updated"
    	                redirect(action:show,id:sittingCriteriaMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[sittingCriteriaMasterInstance:sittingCriteriaMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "StoneCrusherParameterMaster not found with id ${params.id}"
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
    		def sittingCriteriaMasterInstance = new StoneCrusherParameterMaster()
    	        sittingCriteriaMasterInstance.properties = params
    	        return ['sittingCriteriaMasterInstance':sittingCriteriaMasterInstance]
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
    		def sittingCriteriaMasterInstance = new StoneCrusherParameterMaster(params)
    	        if(!sittingCriteriaMasterInstance.hasErrors() && sittingCriteriaMasterInstance.save()) {
    	            flash.message = "Sitting Criteria created"
    	            redirect(action:show,id:sittingCriteriaMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[sittingCriteriaMasterInstance:sittingCriteriaMasterInstance])
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
