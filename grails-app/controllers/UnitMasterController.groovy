

class UnitMasterController {
    
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
    	        [ unitMasterInstanceList: UnitMaster.list( params ), unitMasterInstanceTotal: UnitMaster.count() ]
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
    		def unitMasterInstance = UnitMaster.get( params.id )
    	        if(!unitMasterInstance) {
    	            flash.message = "UnitMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ unitMasterInstance : unitMasterInstance ] }
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
        def unitMasterInstance = UnitMaster.get( params.id )
        if(unitMasterInstance) {
            try {
                unitMasterInstance.delete(flush:true)
                flash.message = "Unit ${params.unitName} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Unit ${params.unitName} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "UnitMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

def edit = {
    	 try {
    		def unitMasterInstance = UnitMaster.get( params.unitMaster_Id )
    	        if(!unitMasterInstance) {
    	            flash.message = "UnitMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ unitMasterInstance : unitMasterInstance ]
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
    		def unitMasterInstance = UnitMaster.get( params.id )
    	        if(unitMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(unitMasterInstance.version > version) {
    	                   unitMasterInstance.errors.rejectValue("version", "unitMaster.optimistic.locking.failure", "Another user has updated this UnitMaster while you were editing.")
    	                    render(view:'edit',model:[unitMasterInstance:unitMasterInstance])
    	                    return
    	                }
    	            }
    	            unitMasterInstance.properties = params
    	            unitMasterInstance.updatedBy=session.userMaster
    	            if(!unitMasterInstance.hasErrors() && unitMasterInstance.save()) {
    	                flash.message = "Unit ${unitMasterInstance.unitName} updated"
    	                redirect(action:show,id:unitMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[unitMasterInstance:unitMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "UnitMaster not found with id ${params.id}"
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
    		 def unitMasterInstance = new UnitMaster()
    	        unitMasterInstance.properties = params
    	        return ['unitMasterInstance':unitMasterInstance]
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
    		 def unitMasterInstance = new UnitMaster(params)
    	        unitMasterInstance.createdBy = session.userMaster
    	        unitMasterInstance.updatedBy = session.userMaster
    	        unitMasterInstance.dateCreated= new Date()
    	        unitMasterInstance.lastUpdated = new Date()
    	        if(!unitMasterInstance.hasErrors() && unitMasterInstance.save()) {
    	            flash.message = "Unit ${unitMasterInstance.unitName} created"
    	            redirect(action:show,id:unitMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[unitMasterInstance:unitMasterInstance])
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

def updateSelect = {
    	 try {
    		if(params.selectedValue=='xyz')
    	    	{
    	    		def roleList= new ArrayList()
    	    		render g.select( width:'10',from:roleList,optionKey:'id',  id:'unitMaster_Id',name:'unitMaster_Id')
    	    	}
    	    	else{
    	    	def groupId = UnitTypeMaster.get((params.selectedValue).toInteger())
    	    	def roleList = UnitMaster.findAllByUnitType(groupId)
    	    	render g.select( width:'10',from:roleList,optionKey:'id',  id:'unitMaster_Id',name:'unitMaster_Id')
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
