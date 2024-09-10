

class IndustryTypeMasterController {
    
def index = {
    		 try {
    				def industrydetailInstance
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
    		def catList = IndCatMaster.list()
    	       params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	       [ industryTypeMasterInstanceList: IndustryTypeMaster.list( params ), industryTypeMasterInstanceTotal: IndustryTypeMaster.count() ,catList:catList]
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
    		def industryTypeMasterInstance = IndustryTypeMaster.get( params.id )
    	  def allValues = IndCatMaster.find("from IndCatMaster where industryType=?",[industryTypeMasterInstance])
    	  def name=allValues . name
    	        if(!industryTypeMasterInstance) {
    	            flash.message = "IndustryTypeMaster not found with id ${params.id}"
    	            redirect(action:list,id:industryTypeMasterInstance)
    	        }
    	        else { return [ industryTypeMasterInstance : industryTypeMasterInstance ,name :name] }
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
        def industryTypeMasterInstance = IndustryTypeMaster.get( params.id )
        if(industryTypeMasterInstance) {
            try {
                industryTypeMasterInstance.delete(flush:true)
                flash.message = "Industry Type ${params.industryType} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = "Industry Type ${params.industryType} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndustryTypeMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    			def industryTypeMasterInstance = IndustryTypeMaster.get(params.industryType.id)
    	        if(!industryTypeMasterInstance) {
    	            flash.message = "IndustryTypeMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ industryTypeMasterInstance : industryTypeMasterInstance ]
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
    		 def industryTypeMasterInstance = IndustryTypeMaster.get( params.id )
    	        if(industryTypeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(industryTypeMasterInstance.version > version) {
    	                    
    	                    industryTypeMasterInstance.errors.rejectValue("version", "industryTypeMaster.optimistic.locking.failure", "Another user has updated this IndustryTypeMaster while you were editing.")
    	                    render(view:'edit',model:[industryTypeMasterInstance:industryTypeMasterInstance])
    	                    return
    	                }
    	            }
    	            industryTypeMasterInstance.properties = params
    	            if(!industryTypeMasterInstance.hasErrors() && industryTypeMasterInstance.save()) {
    	                flash.message = "Industry Type ${params.industryType} updated"
    	                redirect(action:show,id:industryTypeMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[industryTypeMasterInstance:industryTypeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Industry Type not found with id ${params.id}"
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
    			 def industryTypeMasterInstance = new IndustryTypeMaster()
    	        industryTypeMasterInstance.properties = params
    	        return ['industryTypeMasterInstance':industryTypeMasterInstance]
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
    			def industryTypeMasterInstance = new IndustryTypeMaster(params)
    	        if(!industryTypeMasterInstance.hasErrors() && industryTypeMasterInstance.save()) {
    	            flash.message = "Industry Type  ${industryTypeMasterInstance.industryType}  created"
    	             def indCatMasterInstance = new IndCatMaster(params)
    	            indCatMasterInstance.industryType = industryTypeMasterInstance
    	             indCatMasterInstance.description = params.name
    	                indCatMasterInstance.name = params.name
    	               if(indCatMasterInstance.save()){
    	         	    }else{
    	                	if(indCatMasterInstance.hasErrors()){
    	                		indCatMasterInstance.errors.allErrors.each {
    	                       }
    	                     }
    	                }
    	                redirect(action:show,id:industryTypeMasterInstance.id)
    	            }
    	        else {
    	            render(view:'create',model:[industryTypeMasterInstance:industryTypeMasterInstance])
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

def myAjaxIndustryType ={
    	 try {
    			def industryTypeList
    			def a 
    			def cat
    			if(params.cont== '9999' ) {
    				
    				render g.select( width:'10', optionKey:'id',name:'industryType.id', from:industryTypeList)
    			}
    			else {
    				a = params.cont
    				cat = IndCatMaster.get(a)
    					
    				industryTypeList = IndustryTypeMaster.findAll("from IndustryTypeMaster tm where tm.category=? order by tm.category asc",[cat])
    				render g.select( width:'10', optionKey:'id',name:'industryType.id', from:industryTypeList) 
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
    
def go={
    	 try {
    			if( params.industryType.id==null || params.industryType.id=="")
    	    	{
    	    		flash.message="Please Select The Industry Type To Update"
    	    		redirect(action:list)
    	    	}
    	    	else
    	    	{
    	    	 def industryTypeMasterInstance = IndustryTypeMaster.get( params.industryType.id )
    	    	   
    	    	     redirect(action:edit,id: params.industryType.id )
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
def popIndustryType={
	try{
		println("fdgdfgdfgdfgfd")
		def listOfIndustryType=IndCatMaster.findAll()
		/*if(listOfIndustryType){
			for(int i=0;i<listOfIndustryType.size();i++){
				
				
			}
		}*/
		render(view:'getIndustryType',model:[listOfIndustryType:listOfIndustryType]) 
		
		
	}catch(Exception e){

        flash.message="Server is busy ,Please try after some time !"
        e.printStackTrace()
        if(session.indUser)
        {
            redirect(controller:'indUser',action:'openIndustryHome');
        }
        else if (session.userMaster)
        {
            redirect(controller:'userMaster',action:'openSpcbHome')
        }
        else
        {
            session.invalidate()
            redirect(uri:'/index.gsp')
        }
    
	}
}

}
