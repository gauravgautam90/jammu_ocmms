

class SurroundingMasterController {
    
 def index = {
		 try {
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

static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
	 try {
		params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
	        [ surroundingMasterInstanceList: SurroundingMaster.list( params ), surroundingMasterInstanceTotal: SurroundingMaster.count() ]
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
		 def surroundingMasterInstance = SurroundingMaster.get( params.id )
 if(!surroundingMasterInstance) {
	            flash.message = "SurroundingMaster not found"
	            redirect(action:list)
	        }
	        else { return [ surroundingMasterInstance : surroundingMasterInstance ] }
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
        def surroundingMasterInstance = SurroundingMaster.get( params.id )
        if(surroundingMasterInstance) {
            try {
                surroundingMasterInstance.delete(flush:true)
                flash.message = " ${params.surroundingName} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = " ${params.surroundingName} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "SurroundingMaster not found"
            redirect(action:list)
        }
    }

def edit = {
	 try {
		 def surroundingMasterInstance = SurroundingMaster.get( params.id )
 if(!surroundingMasterInstance) {
	            flash.message = "SurroundingMaster not found"
	            redirect(action:list)
	        }
	        else {
	            return [ surroundingMasterInstance : surroundingMasterInstance ]
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
		 def surroundingMasterInstance = SurroundingMaster.get( params.id )
	        if(surroundingMasterInstance) {
	            if(params.version) {
	                def version = params.version.toLong()
	                if(surroundingMasterInstance.version > version) {
	                    surroundingMasterInstance.errors.rejectValue("version", "surroundingMaster.optimistic.locking.failure", "Another user has updated this SurroundingMaster while you were editing.")
	                    render(view:'edit',model:[surroundingMasterInstance:surroundingMasterInstance])
	                    return
	                }
	            }
	            surroundingMasterInstance.properties = params
	            if(!surroundingMasterInstance.hasErrors() && surroundingMasterInstance.save()) {
	                flash.message = " ${params.surroundingName} updated"
	                redirect(action:show,id:surroundingMasterInstance.id)
	            }
	            else {
	                render(view:'edit',model:[surroundingMasterInstance:surroundingMasterInstance])
	            }
	        }
	        else {
	            flash.message = "SurroundingMaster not found"
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
		 def surroundingMasterInstance = new SurroundingMaster()
	        surroundingMasterInstance.properties = params
	        return ['surroundingMasterInstance':surroundingMasterInstance]
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
		def surroundingMasterInstance= new SurroundingMaster(params)
	        def surname=params.surroundingName
	        def surnameInstance=SurroundingMaster.findBysurroundingName(surname)
	       if(surnameInstance!=null)
	        {
	            flash.message="${surname} already Exist"
	            redirect(action:create)
	        }
	       else
	        {
	        surroundingMasterInstance = new SurroundingMaster(params)
	        if(!surroundingMasterInstance.hasErrors() && surroundingMasterInstance.save()) {
	            flash.message = "  ${surroundingMasterInstance.surroundingName} created"
	            redirect(action:show,id:surroundingMasterInstance.id)
	        }
	        else 
	        {
	            render(view:'create',model:[surroundingMasterInstance:surroundingMasterInstance])
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
 
}
