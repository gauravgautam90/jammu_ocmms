class WaterTreatmentStatusMasterController {

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
    	        [ waterTreatmentStatusMasterInstanceList: WaterTreatmentStatusMaster.list( params ), waterTreatmentStatusMasterInstanceTotal: WaterTreatmentStatusMaster.count() ]
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
    	   def waterTreatmentStatusMasterInstance = WaterTreatmentStatusMaster.get( params.id )
    	        if(!waterTreatmentStatusMasterInstance) {
    	            flash.message = "WaterTreatmentStatus not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterTreatmentStatusMasterInstance : waterTreatmentStatusMasterInstance ] }
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

def create={
    	 try {
    	    def waterTreatmentStatusMasterInstance= new WaterTreatmentStatusMaster(params)
    	        waterTreatmentStatusMasterInstance.properties=params
    	        return['waterTreatmentStatusMasterInstance':waterTreatmentStatusMasterInstance]
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

def save={
    	 try {
    	    if(params.status==""||params.status==null)
    	        {
    	            flash.message="Please Enter the status"
    	            redirect(action:create)
    	        }
    	        else
    	        {
    	        	def waterTreatmentStatusMasterInstance= new WaterTreatmentStatusMaster(params)
    	        def status_type=params.status
    	         def statusInstance= WaterTreatmentStatusMaster.findByStatus(status_type)
    	        if(statusInstance!=null)
    	        {
    	            flash.message="${statusInstance} already Exit"
    	            redirect(action:create)

    	        }
    	       else
    	        {
    	        if(!waterTreatmentStatusMasterInstance.hasErrors()&&waterTreatmentStatusMasterInstance.save())
    	        {
    	            flash.message = "Status ${waterTreatmentStatusMasterInstance.status} has been created "
    	            redirect(action:show,id:waterTreatmentStatusMasterInstance.id)
    	        }
    	        else
    	        {
    	            redirect(view:'create',model:[waterTreatmentStatusMasterInstance:waterTreatmentStatusMasterInstance])
    	        }
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

def edit={
    	 try {
    	    def waterTreatmentStatusMasterInstance = WaterTreatmentStatusMaster.get(params.waterTreatmentStatusMaster_Id)
    	        if(!waterTreatmentStatusMasterInstance.id)
    	        {
    	            flash.message="Status with Id${waterTreatmentStatusMasterInstance.id}"
    	            redirect(action:updatePage)
    	        }
    	        else
    	        {
    	        return[waterTreatmentStatusMasterInstance : waterTreatmentStatusMasterInstance]
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

def update={
    	 try {
    	    def waterTreatmentStatusMasterInstance = WaterTreatmentStatusMaster.get( params.id )
    	        if(waterTreatmentStatusMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterTreatmentStatusMasterInstance.version > version) {
    	                	waterTreatmentStatusMasterInstance.errors.rejectValue("version", "WaterTreatmentStatusMaster.optimistic.locking.failure", "Another user has updated this WaterWasteTreatmentCategoryMaster while you were editing.")
    	                    render(view:'edit',model:[waterTreatmentStatusMasterInstance:waterTreatmentStatusMasterInstance])
    	                    return
    	                }
    	            }
    	            waterTreatmentStatusMasterInstance.properties = params
    	            if(!waterTreatmentStatusMasterInstance.hasErrors() && waterTreatmentStatusMasterInstance.save()) {
    	                flash.message = "Status ${waterTreatmentStatusMasterInstance.status} updated"
    	                redirect(action:show,id:waterTreatmentStatusMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterTreatmentStatusMasterInstance:waterTreatmentStatusMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterTreatmentStatusMaster not found with id ${params.id}"
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

    def delete={
    	def waterTreatmentStatusMasterInstance = WaterTreatmentStatusMaster.get( params.id )
        if(waterTreatmentStatusMasterInstance) {
            try {
            	waterTreatmentStatusMasterInstance.delete(flush:true)
                flash.message = "Status ${params.status} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Status ${params.status} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterTreatmentStatusMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
}

}
