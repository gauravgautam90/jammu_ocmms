class SourcesOfHazardeousWasteController {

 def index = {
    		 try {
    			  redirect(action:create1,params:params) 
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
    	        [ sourcesOfHazardeousWasteInstanceList: SourcesOfHazardeousWaste.list( params ), sourcesOfHazardeousWasteInstanceTotal: SourcesOfHazardeousWaste.count() ]
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
    	def sourcesOfHazardeousWasteInstance = SourcesOfHazardeousWaste.get( params.id )
    	        if(!sourcesOfHazardeousWasteInstance) {
    	            flash.message = "SourcesOfHazardeousWaste not found"
    	            redirect(action:create1)
    	        }
    	        else { return [ sourcesOfHazardeousWasteInstance : sourcesOfHazardeousWasteInstance ] }
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
   
def create1={
    	 try {
    		def sourcesOfHazardeousWasteInstance= new SourcesOfHazardeousWaste(params)
    	        sourcesOfHazardeousWasteInstance.properties=params
    	        return['sourcesOfHazardeousWasteInstance':sourcesOfHazardeousWasteInstance]
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
    		if(params.sources==""||params.sources==null )
    	        {
    	            flash.message="Please Enter the Source"
    	            redirect(action:create1)
    	        }
    	        else
    	        {
    	       def sourcesOfHazardeousWasteInstance= new SourcesOfHazardeousWaste(params)
    	        def Source=params.sources
    	        def SourcesInstance=SourcesOfHazardeousWaste.findBySources(Source)
    	         if(SourcesInstance!=null)
    	        {
    	            flash.message="${Source} already Exist"
    	            redirect(action:create1)
    	        }
    	       else
    	        {
    	        sourcesOfHazardeousWasteInstance.createdBy=session.userMaster
    	        sourcesOfHazardeousWasteInstance.updatedBy=session.userMaster
    	        sourcesOfHazardeousWasteInstance.dateCreated=new Date()
    	        sourcesOfHazardeousWasteInstance.lastUpdated=new Date()
    	        if(!sourcesOfHazardeousWasteInstance.hasErrors()&&sourcesOfHazardeousWasteInstance.save())
    	        {
    	            flash.message = "Source ${sourcesOfHazardeousWasteInstance.sources} has been created "
    	            redirect(action:show,id:sourcesOfHazardeousWasteInstance.id)
    	        }
    	        else
    	        {
    	            redirect(view:'create1',model:[sourcesOfHazardeousWasteInstance:sourcesOfHazardeousWasteInstance])
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
    	 def sourcesOfHazardeousWasteInstance = SourcesOfHazardeousWaste.get(params.sourcesOfHazardeousWaste_Id)
            if(!sourcesOfHazardeousWasteInstance.id)
            {
                flash.message="Sorce with Id${sourcesOfHazardeousWasteInstance.id}"
                redirect(action:updatePage)
            }
            else
            {
            return[sourcesOfHazardeousWasteInstance : sourcesOfHazardeousWasteInstance]
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
    		 def sourcesOfHazardeousWasteInstance = SourcesOfHazardeousWaste.get( params.id )
    	        if(sourcesOfHazardeousWasteInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(sourcesOfHazardeousWasteInstance.version > version) {
    	                	sourcesOfHazardeousWasteInstance.errors.rejectValue("version", "waterDisposalModeMaster.optimistic.locking.failure", "Another user has updated this WaterDisposalModeMaster while you were editing.")
    	                    render(view:'edit',model:[sourcesOfHazardeousWasteInstance:sourcesOfHazardeousWasteInstance])
    	                    return
    	                }
    	            }
    	            sourcesOfHazardeousWasteInstance.properties = params
    	            sourcesOfHazardeousWasteInstance.updatedBy=session.userMaster
    	            if(!sourcesOfHazardeousWasteInstance.hasErrors() && sourcesOfHazardeousWasteInstance.save()) {
    	                flash.message = "source ${sourcesOfHazardeousWasteInstance.sources} updated"
    	                redirect(action:show,id:sourcesOfHazardeousWasteInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[sourcesOfHazardeousWasteInstance:sourcesOfHazardeousWasteInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "SourcesOfHazardeousWaste not found"
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
    	def sourcesOfHazardeousWasteInstance = SourcesOfHazardeousWaste.get( params.id )
        if(sourcesOfHazardeousWasteInstance) {
            try {
                sourcesOfHazardeousWasteInstance.delete(flush:true)
                flash.message = "Source ${params.sources} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Source ${params.sources} could not be deleted"
               redirect(action:updatePage)
            }
        }
        else {
            flash.message = "SourcesOfHazardeousWaste not found"
            redirect(action:updatePage)
        }
}

}
