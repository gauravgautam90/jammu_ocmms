

class WaterWasteCategoryMasterController {
    
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
	        [ waterWasteCategoryMasterInstanceList: WaterWasteCategoryMaster.list( params ), waterWasteCategoryMasterInstanceTotal: WaterWasteCategoryMaster.count() ]
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
	      def waterWasteCategoryMasterInstance = WaterWasteCategoryMaster.get( params.id )
	      if(!waterWasteCategoryMasterInstance) {
	            flash.message = "WaterWasteCategoryMaster not found with id ${params.id}"
	            redirect(action:create)
	        }
	        else { return [ waterWasteCategoryMasterInstance : waterWasteCategoryMasterInstance ] }
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
        def waterWasteCategoryMasterInstance = WaterWasteCategoryMaster.get( params.id )
        if(waterWasteCategoryMasterInstance) {
            try {
                waterWasteCategoryMasterInstance.delete(flush:true)
                flash.message = "Water Waste Category ${params.category} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Water Waste Category ${params.category} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "WaterWasteCategoryMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
	 try {
	    def waterWasteCategoryMasterInstance = WaterWasteCategoryMaster.get( params.waterWasteCategoryMaster_Id )
	        if(!waterWasteCategoryMasterInstance) {
	            flash.message = "WaterWasteCategoryMaster not found with id ${params.id}"
	            redirect(action:updatePage)
	        }
	        else {
	            return [ waterWasteCategoryMasterInstance : waterWasteCategoryMasterInstance ]
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
	       def waterWasteCategoryMasterInstance = WaterWasteCategoryMaster.get( params.id )
	        if(waterWasteCategoryMasterInstance) {
	            if(params.version) {
	                def version = params.version.toLong()
	                if(waterWasteCategoryMasterInstance.version > version) {
	                    waterWasteCategoryMasterInstance.errors.rejectValue("version", "waterWasteCategoryMaster.optimistic.locking.failure", "Another user has updated this WaterWasteCategoryMaster while you were editing.")
	                    render(view:'edit',model:[waterWasteCategoryMasterInstance:waterWasteCategoryMasterInstance])
	                    return
	                }
	            }
	            waterWasteCategoryMasterInstance.properties = params
	            waterWasteCategoryMasterInstance.updatedBy=session.userMaster
	            if(!waterWasteCategoryMasterInstance.hasErrors() && waterWasteCategoryMasterInstance.save()) {
	                flash.message = "Water Waste Category ${waterWasteCategoryMasterInstance.category} updated"
	                redirect(action:show,id:waterWasteCategoryMasterInstance.id)
	            }
	            else {
	                render(view:'edit',model:[waterWasteCategoryMasterInstance:waterWasteCategoryMasterInstance])
	            }
	        }
	        else {
	            flash.message = "WaterWasteCategoryMaster not found with id ${params.id}"
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
	      def waterWasteCategoryMasterInstance = new WaterWasteCategoryMaster()
	        waterWasteCategoryMasterInstance.properties = params
	        return ['waterWasteCategoryMasterInstance':waterWasteCategoryMasterInstance]
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
	       def waterWasteCategoryMasterInstance = new WaterWasteCategoryMaster(params)
	        waterWasteCategoryMasterInstance.createdBy = session.userMaster
	        waterWasteCategoryMasterInstance.updatedBy = session.userMaster
	        waterWasteCategoryMasterInstance.dateCreated= new Date()
	        waterWasteCategoryMasterInstance.lastUpdated = new Date()
	        if(!waterWasteCategoryMasterInstance.hasErrors() && waterWasteCategoryMasterInstance.save()) {
	            flash.message = "Water Waste Category ${waterWasteCategoryMasterInstance.category} created"
	            redirect(action:show,id:waterWasteCategoryMasterInstance.id)
	        }
	        else {
	            render(view:'create',model:[waterWasteCategoryMasterInstance:waterWasteCategoryMasterInstance])
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
