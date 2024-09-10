
 
class AirEmiProbablePollutantMasterController {
    
    def index = {
    		 try { 
    		      redirect(action:list,params:params) 
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

    def updatePage={}
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	         params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ airEmiProbablePollutantMasterInstanceList: AirEmiProbablePollutantMaster.list( params ), airEmiProbablePollutantMasterInstanceTotal: AirEmiProbablePollutantMaster.count() ]
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
    	 def airEmiProbablePollutantMasterInstance = AirEmiProbablePollutantMaster.get( params.id )
    	        if(!airEmiProbablePollutantMasterInstance) {
    	            flash.message = "AirEmiProbablePollutantMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ airEmiProbablePollutantMasterInstance : airEmiProbablePollutantMasterInstance ] }
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
        def airEmiProbablePollutantMasterInstance = AirEmiProbablePollutantMaster.get( params.id )
        if(airEmiProbablePollutantMasterInstance) {
            try {
                airEmiProbablePollutantMasterInstance.delete(flush:true)
                flash.message = "Air Emission Probable Pollutant ${params.pollutant} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Air Emission Probable Pollutant ${params.pollutant} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "AirEmiProbablePollutantMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try { 
    	    	if(!params.airEmiProbablePollutantMaster_Id)
    	    	{
    	    		flash.message="Please Select Pollutant To Update"
    	    			render(view:'updatePage')
    	    		}
    	    	else
    	    	{
    	        def airEmiProbablePollutantMasterInstance = AirEmiProbablePollutantMaster.get( params.airEmiProbablePollutantMaster_Id )
    	        if(!airEmiProbablePollutantMasterInstance) {
    	            flash.message = "AirEmiProbablePollutantMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ airEmiProbablePollutantMasterInstance : airEmiProbablePollutantMasterInstance ]
    	        }
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
    	        def airEmiProbablePollutantMasterInstance = AirEmiProbablePollutantMaster.get( params.id )
    	        if(airEmiProbablePollutantMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(airEmiProbablePollutantMasterInstance.version > version) {
    	                    airEmiProbablePollutantMasterInstance.errors.rejectValue("version", "airEmiProbablePollutantMaster.optimistic.locking.failure", "Another user has updated this AirEmiProbablePollutantMaster while you were editing.")
    	                    render(view:'updatePage',model:[airEmiProbablePollutantMasterInstance:airEmiProbablePollutantMasterInstance])
    	                    return
    	                }
    	            }
    	            airEmiProbablePollutantMasterInstance.properties = params
    	            airEmiProbablePollutantMasterInstance.updatedBy=session.userMaster
    	            if(!airEmiProbablePollutantMasterInstance.hasErrors() && airEmiProbablePollutantMasterInstance.save()) {
    	                flash.message = "Air Emission Probable Pollutant ${airEmiProbablePollutantMasterInstance.pollutant} updated"
    	                redirect(action:show,id:airEmiProbablePollutantMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[airEmiProbablePollutantMasterInstance:airEmiProbablePollutantMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "AirEmiProbablePollutantMaster not found with id ${params.id}"
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
    	        def airEmiProbablePollutantMasterInstance = new AirEmiProbablePollutantMaster()
    	        airEmiProbablePollutantMasterInstance.properties = params
    	        return ['airEmiProbablePollutantMasterInstance':airEmiProbablePollutantMasterInstance]
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
    	        def airEmiProbablePollutantMasterInstance = new AirEmiProbablePollutantMaster(params)
    	        airEmiProbablePollutantMasterInstance.createdBy = session.userMaster
    	        airEmiProbablePollutantMasterInstance.updatedBy = session.userMaster
    	        airEmiProbablePollutantMasterInstance.dateCreated= new Date()
    	        airEmiProbablePollutantMasterInstance.lastUpdated = new Date()
    	        if(!airEmiProbablePollutantMasterInstance.hasErrors() && airEmiProbablePollutantMasterInstance.save()) {
    	            flash.message = "Air Emission Probable Pollutant ${airEmiProbablePollutantMasterInstance.pollutant} created"
    	            redirect(action:show,id:airEmiProbablePollutantMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[airEmiProbablePollutantMasterInstance:airEmiProbablePollutantMasterInstance])
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
