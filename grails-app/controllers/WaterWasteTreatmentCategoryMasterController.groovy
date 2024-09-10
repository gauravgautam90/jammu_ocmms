class WaterWasteTreatmentCategoryMasterController {

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
    	        [ waterWasteTreatmentCategoryMasterInstanceList: WaterWasteTreatmentCategoryMaster.list( params ), waterWasteTreatmentCategoryMasterInstanceTotal: WaterWasteTreatmentCategoryMaster.count() ]
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
    	    def waterWasteTreatmentCategoryMasterInstance = WaterWasteTreatmentCategoryMaster.get( params.id )
    	    if(!waterWasteTreatmentCategoryMasterInstance) {
    	            flash.message = "ModeOfStorageDisposalDetails not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ waterWasteTreatmentCategoryMasterInstance : waterWasteTreatmentCategoryMasterInstance ] }
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
    	     def waterWasteTreatmentCategoryMasterInstance= new WaterWasteTreatmentCategoryMaster(params)
    	        waterWasteTreatmentCategoryMasterInstance.properties=params
    	        return['waterWasteTreatmentCategoryMasterInstance':waterWasteTreatmentCategoryMasterInstance]
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
    	       if(params.category==""||params.category==null )
    	        {
    	            flash.message="Please Enter the category"
    	            redirect(action:create)
    	        }
    	        else
    	        {
    	        	def waterWasteTreatmentCategoryMasterInstance= new WaterWasteTreatmentCategoryMaster(params)
    	       def category_type=params.category
    	       def categoryInstance= WaterWasteTreatmentCategoryMaster.findByCategory(category_type)
    	        if(categoryInstance!=null)
    	        {
    	            flash.message="${category_type} already Exit"
    	            redirect(action:create)
    	        }
    	       else
    	        {
    	        if(!waterWasteTreatmentCategoryMasterInstance.hasErrors()&&waterWasteTreatmentCategoryMasterInstance.save())
    	        {
    	            flash.message = "Category ${waterWasteTreatmentCategoryMasterInstance.category} has been created "
    	            redirect(action:show,id:waterWasteTreatmentCategoryMasterInstance.id)
    	        }
    	        else
    	        {
    	            redirect(view:'create',model:[waterWasteTreatmentCategoryMasterInstance:waterWasteTreatmentCategoryMasterInstance])
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
    	      def waterWasteTreatmentCategoryMasterInstance = WaterWasteTreatmentCategoryMaster.get(params.waterWasteTreatmentCategoryMaster_Id)
    	        if(!waterWasteTreatmentCategoryMasterInstance.id)
    	        {
    	            flash.message="Category with Id${waterWasteTreatmentCategoryMasterInstance.id}"
    	            redirect(action:updatePage)
    	        }
    	        else
    	        {
    	        return[waterWasteTreatmentCategoryMasterInstance : waterWasteTreatmentCategoryMasterInstance]
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
    	    def waterWasteTreatmentCategoryMasterInstance = WaterWasteTreatmentCategoryMaster.get( params.id )
    	        if(waterWasteTreatmentCategoryMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(waterWasteTreatmentCategoryMasterInstance.version > version) {
    	                	waterWasteTreatmentCategoryMasterInstance.errors.rejectValue("version", "WaterWasteTreatmentCategoryMaster.optimistic.locking.failure", "Another user has updated this WaterWasteTreatmentCategoryMaster while you were editing.")
    	                    render(view:'edit',model:[waterWasteTreatmentCategoryMasterInstance:waterWasteTreatmentCategoryMasterInstance])
    	                    return
    	                }
    	            }
    	            waterWasteTreatmentCategoryMasterInstance.properties = params
    	            if(!waterWasteTreatmentCategoryMasterInstance.hasErrors() && waterWasteTreatmentCategoryMasterInstance.save()) {
    	                flash.message = "Category ${waterWasteTreatmentCategoryMasterInstance.category} updated"
    	                redirect(action:show,id:waterWasteTreatmentCategoryMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[waterWasteTreatmentCategoryMasterInstance:waterWasteTreatmentCategoryMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WaterWasteTreatmentCategoryMaster not found with id ${params.id}"
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
    	def waterWasteTreatmentCategoryMasterInstance = WaterWasteTreatmentCategoryMaster.get( params.id )
        if(waterWasteTreatmentCategoryMasterInstance) {
            try {
                waterWasteTreatmentCategoryMasterInstance.delete(flush:true)
                flash.message = "Category ${params.category} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Category ${params.category} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterWasteTreatmentCategoryMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
}

}
