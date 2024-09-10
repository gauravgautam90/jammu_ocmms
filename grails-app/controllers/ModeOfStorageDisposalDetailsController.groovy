class ModeOfStorageDisposalDetailsController {

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
    	        [ modeOfStorageDisposalDetailsInstanceList: ModeOfStorageDisposalDetails.list( params ), modeOfStorageDisposalDetailsInstanceTotal: ModeOfStorageDisposalDetails.count() ]
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
    	  def modeOfStorageDisposalDetailsInstance = ModeOfStorageDisposalDetails.get( params.id )
    	  if(!modeOfStorageDisposalDetailsInstance) {
    	            flash.message = "ModeOfStorageDisposalDetails not found"
    	            redirect(action:create)
    	        }
    	        else { return [ modeOfStorageDisposalDetailsInstance : modeOfStorageDisposalDetailsInstance ] }
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
    	    def modeOfStorageDisposalDetailsInstance= new ModeOfStorageDisposalDetails(params)
    	        modeOfStorageDisposalDetailsInstance.properties=params
    	        return['modeOfStorageDisposalDetailsInstance':modeOfStorageDisposalDetailsInstance]
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
    	    if(params.modeOfStorage==""||params.modeOfStorage==null )
    	        {
    	            flash.message="Please Enter the Mode Of Storage"
    	            redirect(action:create)
    	        }
    	        else
    	        {

    	        def modeOfStorageDisposalDetailsInstance= new ModeOfStorageDisposalDetails(params)
    	        def disposal=params.modeOfStorage
    	       def disposalInstance= ModeOfStorageDisposalDetails.findByModeOfStorage(disposal)
    	        if(disposalInstance!=null)
    	        {
    	            flash.message="${disposal} already Exit"
    	            redirect(action:create)
    	        }
    	       else
    	        {
    	        modeOfStorageDisposalDetailsInstance.createdBy=session.userMaster
    	        modeOfStorageDisposalDetailsInstance.updatedBy=session.userMaster
    	        modeOfStorageDisposalDetailsInstance.dateCreated=new Date()
    	        modeOfStorageDisposalDetailsInstance.lastUpdated=new Date()
    	        if(!modeOfStorageDisposalDetailsInstance.hasErrors()&&modeOfStorageDisposalDetailsInstance.save())
    	        {
    	            flash.message = "Mode Of Storage ${modeOfStorageDisposalDetailsInstance.modeOfStorage} has been created "
    	            redirect(action:show,id:modeOfStorageDisposalDetailsInstance.id)
    	        }
    	        else
    	        {
    	            redirect(view:'create',model:[modeOfStorageDisposalDetailsInstance:modeOfStorageDisposalDetailsInstance])
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
    	  def modeOfStorageDisposalDetailsInstance = ModeOfStorageDisposalDetails.get(params.modeOfStorageDisposalDetails_Id)
    	        if(!modeOfStorageDisposalDetailsInstance.id)
    	        {
    	            flash.message="Mode Of Storage with Id${modeOfStorageDisposalDetailsInstance.id}"
    	            redirect(action:updatePage)
    	        }
    	        else
    	        {
    	        return[modeOfStorageDisposalDetailsInstance : modeOfStorageDisposalDetailsInstance]
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
    	     def modeOfStorageDisposalDetailsInstance = ModeOfStorageDisposalDetails.get( params.id )
    	        if(modeOfStorageDisposalDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(modeOfStorageDisposalDetailsInstance.version > version) {
    	                	modeOfStorageDisposalDetailsInstance.errors.rejectValue("version", "ModeOfStorageDisposalDetails.optimistic.locking.failure", "Another user has updated this ModeOfStorageDisposalDetails while you were editing.")
    	                    render(view:'edit',model:[modeOfStorageDisposalDetailsInstance:modeOfStorageDisposalDetailsInstance])
    	                    return
    	                }
    	            }
    	            modeOfStorageDisposalDetailsInstance.properties = params
    	            modeOfStorageDisposalDetailsInstance.updatedBy=session.userMaster
    	            if(!modeOfStorageDisposalDetailsInstance.hasErrors() && modeOfStorageDisposalDetailsInstance.save()) {
    	                flash.message = "Mode Of Storage ${modeOfStorageDisposalDetailsInstance.modeOfStorage} updated"
    	                redirect(action:show,id:modeOfStorageDisposalDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[modeOfStorageDisposalDetailsInstance:modeOfStorageDisposalDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "ModeOfStorageDisposalDetails not found"
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
    	def modeOfStorageDisposalDetailsInstance = ModeOfStorageDisposalDetails.get( params.id )
        if(modeOfStorageDisposalDetailsInstance) {
            try {
                modeOfStorageDisposalDetailsInstance.delete(flush:true)
                flash.message = "Mode Of Storage ${params.modeOfStorage} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Mode Of Storage ${params.modeOfStorage} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "ModeOfStorageDisposalDetails not found"
            redirect(action:updatePage)
        }
 }

}
