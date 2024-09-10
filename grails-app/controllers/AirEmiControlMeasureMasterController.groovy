

class AirEmiControlMeasureMasterController {
def index = {
    	try {
    		  redirect(action:list,params:params) 
    		}
    	catch(Exception e) {
    		    e.printStackTrace();
    		    flash.message = "Server Busy ..Please try after some time....";
    			if(session.indUser){
    		 redirect(controller:'indUser',action:'openIndustryHome')
    		 }else if(session.userMaster){
    		  redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    					session.invalidate()
    		            redirect(uri:'/index.gsp');
    		 }
    	}
    }

def updatePage = {  }

// the delete, save and update actions only accept POST requests
static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
    	 try {
    	        params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ airEmiControlMeasureMasterInstanceList: AirEmiControlMeasureMaster.list( params ), airEmiControlMeasureMasterInstanceTotal: AirEmiControlMeasureMaster.count() ]
    		}
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	     }
    }
  
def show = {
    	 try {
    	   def airEmiControlMeasureMasterInstance = AirEmiControlMeasureMaster.get( params.id )
    	   if(!airEmiControlMeasureMasterInstance) {
    	            flash.message = "AirEmiControlMeasureMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ airEmiControlMeasureMasterInstance : airEmiControlMeasureMasterInstance ] }
    				}
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }			
    }

def delete = {
   def airEmiControlMeasureMasterInstance = AirEmiControlMeasureMaster.get( params.id )
    if(airEmiControlMeasureMasterInstance) {
    try {
    	    airEmiControlMeasureMasterInstance.delete(flush:true)
    	    flash.message = "Air Emission Control Measure ${params.controlMeasure} deleted"
    	     redirect(action:updatePage)
    	 }
   catch(Exception e) {
    	     flash.message = "Air Emission Control Measure ${params.controlMeasure} could not be deleted"
    	          redirect(action:updatePage)
    	            }
    	        }
    	   else {
    	          flash.message = "AirEmiControlMeasureMaster not found with id ${params.id}"
    	           redirect(action:updatePage)
    	        }				
    }

    def edit = {
    	 try {
    	        def airEmiControlMeasureMasterInstance = AirEmiControlMeasureMaster.get( params.airEmiControlMeasureMaster_Id )

    	        if(!airEmiControlMeasureMasterInstance) {
    	            flash.message = "AirEmiControlMeasureMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ airEmiControlMeasureMasterInstance : airEmiControlMeasureMasterInstance ]
    	        }
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	          
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }	
    }

    def update = {
    	 try {
    	        def airEmiControlMeasureMasterInstance = AirEmiControlMeasureMaster.get( params.id )
    	        if(airEmiControlMeasureMasterInstance) {
    	            if(params.version) { 
    	                def version = params.version.toLong()
    	                if(airEmiControlMeasureMasterInstance.version > version) {
    	                    
    	                    airEmiControlMeasureMasterInstance.errors.rejectValue("version", "airEmiControlMeasureMaster.optimistic.locking.failure", "Another user has updated this AirEmiControlMeasureMaster while you were editing.")
    	                    render(view:'edit',model:[airEmiControlMeasureMasterInstance:airEmiControlMeasureMasterInstance])
    	                    return
    	                }
    	            }
    	            airEmiControlMeasureMasterInstance.properties = params
    	            airEmiControlMeasureMasterInstance.updatedBy=session.userMaster
    	            if(!airEmiControlMeasureMasterInstance.hasErrors() && airEmiControlMeasureMasterInstance.save()) {
    	                flash.message = "Air Emission Control Measure ${airEmiControlMeasureMasterInstance.controlMeasure} updated"
    	                redirect(action:show,id:airEmiControlMeasureMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[airEmiControlMeasureMasterInstance:airEmiControlMeasureMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AirEmiControlMeasureMaster not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
    	        }
    	    
    				}catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	          
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }	
    }

    def create = {
    	 try {
    	        def airEmiControlMeasureMasterInstance = new AirEmiControlMeasureMaster()
    	        airEmiControlMeasureMasterInstance.properties = params
    	        return ['airEmiControlMeasureMasterInstance':airEmiControlMeasureMasterInstance]
    	    
    				}catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	          
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }
    }

    def save = {
    	 try {
    	        def airEmiControlMeasureMasterInstance = new AirEmiControlMeasureMaster(params)
    	        airEmiControlMeasureMasterInstance.createdBy = session.userMaster
    	        airEmiControlMeasureMasterInstance.updatedBy = session.userMaster
    	        airEmiControlMeasureMasterInstance.dateCreated= new Date()
    	        airEmiControlMeasureMasterInstance.lastUpdated = new Date()
    	        if(!airEmiControlMeasureMasterInstance.hasErrors() && airEmiControlMeasureMasterInstance.save()) {
    	            flash.message = "Air Emission Control Measure ${airEmiControlMeasureMasterInstance.controlMeasure} created"
    	            redirect(action:show,id:airEmiControlMeasureMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[airEmiControlMeasureMasterInstance:airEmiControlMeasureMasterInstance])
    	        }
    				}catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	          
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }		
    }
}
