

class DepartmentMasterController {
    
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
    	        [ departmentMasterInstanceList: DepartmentMaster.list( params ), departmentMasterInstanceTotal: DepartmentMaster.count() ]
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
    		 def departmentMasterInstance = DepartmentMaster.get( params.id )
    		 if(!departmentMasterInstance) {
    	            flash.message = "DepartmentMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else { return [ departmentMasterInstance : departmentMasterInstance ] }
    	    
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
        def departmentMasterInstance = DepartmentMaster.get( params.id )
        if(departmentMasterInstance) {
            try {
                departmentMasterInstance.delete(flush:true)
                flash.message = "Department ${params.depName} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Department ${params.depName} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "DepartmentMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    		 def departmentMasterInstance = DepartmentMaster.get( params.deptMasterList_Id )
    		 if(!departmentMasterInstance) {
    	            flash.message = "Department  not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ departmentMasterInstance : departmentMasterInstance ]
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
    		 def departmentMasterInstance = DepartmentMaster.get( params.id )
    	        if(departmentMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(departmentMasterInstance.version > version) {
    	                    
    	                    departmentMasterInstance.errors.rejectValue("version", "departmentMaster.optimistic.locking.failure", "Another user has updated this DepartmentMaster while you were editing.")
    	                    render(view:'edit',model:[departmentMasterInstance:departmentMasterInstance])
    	                    return
    	                }
    	            }
    	            departmentMasterInstance.properties = params
    	            if(!departmentMasterInstance.hasErrors() && departmentMasterInstance.save()) {
    	                flash.message = "Department ${params.depName} updated"
    	                redirect(action:show,id:departmentMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[departmentMasterInstance:departmentMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Department  not found "
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
    		 def departmentMasterInstance = new DepartmentMaster()
    	        departmentMasterInstance.properties = params
    	        return ['departmentMasterInstance':departmentMasterInstance]
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
    		 def departmentMasterInstance = new DepartmentMaster(params)
    	        if(!departmentMasterInstance.hasErrors() && departmentMasterInstance.save()) {
    	            flash.message = "Department ${departmentMasterInstance.depName} created"
    	            redirect(action:show,id:departmentMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[departmentMasterInstance:departmentMasterInstance])
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
