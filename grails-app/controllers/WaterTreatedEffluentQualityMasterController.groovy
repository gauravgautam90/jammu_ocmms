class WaterTreatedEffluentQualityMasterController {

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
    	        [ waterTreatedEffluentQualityMasterInstanceList: WaterTreatedEffluentQualityMaster.list( params ), waterTreatedEffluentQualityMasterInstanceTotal: WaterTreatedEffluentQualityMaster.count() ]
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
    	   def waterTreatedEffluentQualityMasterInstance = WaterTreatedEffluentQualityMaster.get( params.id )
    	        if(!waterTreatedEffluentQualityMasterInstance) {
    	            flash.message = "WaterTreatedEffluentQuality not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterTreatedEffluentQualityMasterInstance : waterTreatedEffluentQualityMasterInstance ] }
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
    	    def waterTreatedEffluentQualityMasterInstance= new WaterTreatedEffluentQualityMaster(params)
    	        waterTreatedEffluentQualityMasterInstance.properties=params
    	        return['waterTreatedEffluentQualityMasterInstance':waterTreatedEffluentQualityMasterInstance]
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
    	      if(params.quality==""||params.quality==null )
    	        {
    	            flash.message="Please Enter the quality"
    	            redirect(action:create)

    	        }
    	        else
    	        {
    	        	def waterTreatedEffluentQualityMasterInstance= new WaterTreatedEffluentQualityMaster(params)
    	        def quality_type=params.quality
    	       def qualityInstance= WaterTreatedEffluentQualityMaster.findByQuality(quality_type)
    	         if(qualityInstance!=null)
    	        {
    	            flash.message="${quality_type} already Exit"
    	            redirect(action:create)
    	        }
    	       else
    	        {
    	        if(!waterTreatedEffluentQualityMasterInstance.hasErrors()&&waterTreatedEffluentQualityMasterInstance.save())
    	        {
    	            flash.message = "Effluent Quality ${waterTreatedEffluentQualityMasterInstance.quality} has been created "
    	            redirect(action:show,id:waterTreatedEffluentQualityMasterInstance.id)
    	        }
    	        else
    	        {
    	            redirect(view:'create',model:[waterTreatedEffluentQualityMasterInstance:waterTreatedEffluentQualityMasterInstance])
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
    	   def waterTreatedEffluentQualityMasterInstance = WaterTreatedEffluentQualityMaster.get(params.waterTreatedEffluentQualityMaster_Id)
    	        if(!waterTreatedEffluentQualityMasterInstance.id)
    	        {
    	            flash.message="Effluent Quality with Id${waterTreatedEffluentQualityMasterInstance.id}"
    	            redirect(action:updatePage)
    	        }
    	        else
    	        {
    	        return[waterTreatedEffluentQualityMasterInstance : waterTreatedEffluentQualityMasterInstance]
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
    	   def waterTreatedEffluentQualityMasterInstance = WaterTreatedEffluentQualityMaster.get( params.id )
    	        if(waterTreatedEffluentQualityMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterTreatedEffluentQualityMasterInstance.version > version) {
    	                	waterTreatedEffluentQualityMasterInstance.errors.rejectValue("version", "WaterTreatedEffluentQualityMaster.optimistic.locking.failure", "Another user has updated this WaterWasteTreatmentCategoryMaster while you were editing.")
    	                    render(view:'edit',model:[waterTreatedEffluentQualityMasterInstance:waterTreatedEffluentQualityMasterInstance])
    	                    return
    	                }
    	            }
    	            waterTreatedEffluentQualityMasterInstance.properties = params
    	            if(!waterTreatedEffluentQualityMasterInstance.hasErrors() && waterTreatedEffluentQualityMasterInstance.save()) {
    	                flash.message = "Effluent Quality ${waterTreatedEffluentQualityMasterInstance.quality} updated"
    	                redirect(action:show,id:waterTreatedEffluentQualityMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterTreatedEffluentQualityMasterInstance:waterTreatedEffluentQualityMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterTreatedEffluentQualityMaster not found with id ${params.id}"
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
 def waterTreatedEffluentQualityMasterInstance = WaterTreatedEffluentQualityMaster.get( params.id )
        if(waterTreatedEffluentQualityMasterInstance) {
            try {
            	waterTreatedEffluentQualityMasterInstance.delete(flush:true)
                flash.message = "Effluent Quality ${params.quality} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Effluent Quality ${params.quality} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterTreatedEffluentQualityMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
}

}
