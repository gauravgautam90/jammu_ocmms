

class DesignationMasterController {
    
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
    
    def updatePage={}
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ designationMasterInstanceList: DesignationMaster.list( params ), designationMasterInstanceTotal: DesignationMaster.count() ]
    	     }
    	 catch(Exception e) {
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
    		 def designationMasterInstance = DesignationMaster.get( params.id )
    		 if(!designationMasterInstance) {
    	            flash.message = "DesignationMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else { return [ designationMasterInstance : designationMasterInstance ] }
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
        def designationMasterInstance = DesignationMaster.get( params.id )
        if(designationMasterInstance) {
            try {
                designationMasterInstance.delete(flush:true)
                flash.message = "Designation ${params.designation} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Designation ${params.designation} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Designation not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    		 def designationMasterInstance = DesignationMaster.get( params.desgMasterList_Id )
    		 if(!designationMasterInstance) {
    	            flash.message = "Designation not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ designationMasterInstance : designationMasterInstance ]
    	        }
    	     }
    	 catch(Exception e) {
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
    		 def designationMasterInstance = DesignationMaster.get( params.id )
    	        if(designationMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(designationMasterInstance.version > version) {
    	                    
    	                    designationMasterInstance.errors.rejectValue("version", "designationMaster.optimistic.locking.failure", "Another user has updated this DesignationMaster while you were editing.")
    	                    render(view:'edit',model:[designationMasterInstance:designationMasterInstance])
    	                    return
    	                }
    	            }
    	            designationMasterInstance.properties = params
    	            if(!designationMasterInstance.hasErrors() && designationMasterInstance.save()) {
    	                flash.message = "Designation ${params.designation} updated"
    	                redirect(action:show,id:designationMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[designationMasterInstance:designationMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "DesignationMaster not found  "
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
    		 def designationMasterInstance = new DesignationMaster()
    	        designationMasterInstance.properties = params
    	        return ['designationMasterInstance':designationMasterInstance]
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

    def myAjax3={
    	 try {
    		 def depF=DepartmentMaster.list()
    	    	def a =params.selectedValue
    	    	def dep2 = DepartmentMaster.get(a)
    	    	def designationList = DesignationMaster.findAllByDepartment(dep2)
    	   render g.select( width:'10', optionKey:'id',name:'desgMasterList_Id', from:designationList)
    	     }
    	 catch(Exception e) {
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
    		 def designationMasterInstance = new DesignationMaster(params)
    	        if(!designationMasterInstance.hasErrors() && designationMasterInstance.save()) {
    	            flash.message = "Designation ${designationMasterInstance.designation} created"
    	            redirect(action:show,id:designationMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[designationMasterInstance:designationMasterInstance])
    	        }
    	     }
    	 catch(Exception e) {
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
