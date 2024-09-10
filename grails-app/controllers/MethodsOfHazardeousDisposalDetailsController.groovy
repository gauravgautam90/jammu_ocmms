class MethodsOfHazardeousDisposalDetailsController {

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
    	        [ methodsOfHazardeousDisposalDetailsInstanceList: MethodsOfHazardeousDisposalDetails.list( params ), methodsOfHazardeousDisposalDetailsInstanceTotal: MethodsOfHazardeousDisposalDetails.count() ]
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
    	  def methodsOfHazardeousDisposalDetailsInstance = MethodsOfHazardeousDisposalDetails.get( params.id )
    	  if(!methodsOfHazardeousDisposalDetailsInstance) {
    	            flash.message = "MethodsOfHazardeousDisposalDetails not found"
    	            redirect(action:create)
    	        }
    	        else { return [ methodsOfHazardeousDisposalDetailsInstance : methodsOfHazardeousDisposalDetailsInstance ] }
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
    	    def methodsOfHazardeousDisposalDetailsInstance= new MethodsOfHazardeousDisposalDetails(params)
    	        methodsOfHazardeousDisposalDetailsInstance.properties=params
    	        return['methodsOfHazardeousDisposalDetailsInstance':methodsOfHazardeousDisposalDetailsInstance]
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
    	  if(params.methodOfDisposal==""||params.methodOfDisposal== null )
            {
                flash.message="Please Enter the Method Of Disposal"
                redirect(action:create)
            }
         else{
            	def methodsOfHazardeousDisposalDetailsInstance= new MethodsOfHazardeousDisposalDetails(params)
               def method=params.methodOfDisposal
                def methodInstance=MethodsOfHazardeousDisposalDetails.findBymethodOfDisposal(method)
               if(methodInstance!=null)
                {
                    flash.message="${method} already Exist"
                    redirect(action:create)
                }
               else
                {
            methodsOfHazardeousDisposalDetailsInstance= new MethodsOfHazardeousDisposalDetails(params)
            methodsOfHazardeousDisposalDetailsInstance.createdBy=session.userMaster
            methodsOfHazardeousDisposalDetailsInstance.updatedBy=session.userMaster
            methodsOfHazardeousDisposalDetailsInstance.dateCreated=new Date()
            methodsOfHazardeousDisposalDetailsInstance.lastUpdated=new Date()
            if(!methodsOfHazardeousDisposalDetailsInstance.hasErrors()&&methodsOfHazardeousDisposalDetailsInstance.save())
            {   flash.message = "Method Of Disposal  ${methodsOfHazardeousDisposalDetailsInstance.methodOfDisposal} has been created with id ${methodsOfHazardeousDisposalDetailsInstance.id}"
                redirect(action:show,id:methodsOfHazardeousDisposalDetailsInstance.id)
            }
            else
            {
                redirect(view:'create',model:[methodsOfHazardeousDisposalDetailsInstance:methodsOfHazardeousDisposalDetailsInstance])
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
    	        def methodsOfHazardeousDisposalDetailsInstance = MethodsOfHazardeousDisposalDetails.get(params.methodsOfHazardeousDisposalDetails_Id)
    	        if(!methodsOfHazardeousDisposalDetailsInstance.id)
    	        {
    	            flash.message="Method Of Disposal with Id${methodsOfHazardeousDisposalDetailsInstance.id}"
    	            redirect(action:updatePage)
    	        }
    	        else
    	        {
    	        return[methodsOfHazardeousDisposalDetailsInstance : methodsOfHazardeousDisposalDetailsInstance]
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
    	      def methodsOfHazardeousDisposalDetailsInstance = MethodsOfHazardeousDisposalDetails.get( params.id )
    	        if(methodsOfHazardeousDisposalDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(methodsOfHazardeousDisposalDetailsInstance.version > version) {
    	                	methodsOfHazardeousDisposalDetailsInstance.errors.rejectValue("version", "methodsOfHazardeousDisposalDetails.optimistic.locking.failure", "Another user has updated this MethodsOfHazardeousDisposalDetails while you were editing.")
    	                    render(view:'edit',model:[methodsOfHazardeousDisposalDetailsInstance:methodsOfHazardeousDisposalDetailsInstance])
    	                    return
    	                }
    	            }
    	            methodsOfHazardeousDisposalDetailsInstance.properties = params
    	            methodsOfHazardeousDisposalDetailsInstance.updatedBy=session.userMaster
    	            if(!methodsOfHazardeousDisposalDetailsInstance.hasErrors() && methodsOfHazardeousDisposalDetailsInstance.save()) {
    	                flash.message = "Method Of Disposal ${methodsOfHazardeousDisposalDetailsInstance.methodOfDisposal} updated"
    	                redirect(action:show,id:methodsOfHazardeousDisposalDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[methodsOfHazardeousDisposalDetailsInstance:methodsOfHazardeousDisposalDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "MethodsOfHazardeousDisposalDetails not found"
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
	def methodsOfHazardeousDisposalDetailsInstance = MethodsOfHazardeousDisposalDetails.get( params.id )
        if(methodsOfHazardeousDisposalDetailsInstance) {
            try {
                methodsOfHazardeousDisposalDetailsInstance.delete(flush:true)
                flash.message = "Method Of Disposal ${params.methodOfDisposal} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Method Of Disposal ${params.methodOfDisposal} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "MethodsOfHazardeousDisposalDetails not found"
            redirect(action:updatePage)
        }
 }

}
