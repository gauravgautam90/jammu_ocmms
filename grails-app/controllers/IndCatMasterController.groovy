

class IndCatMasterController {
    
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
 			 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ indCatMasterInstanceList: IndCatMaster.list( params ), indCatMasterInstanceTotal: IndCatMaster.count() ]
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
 			 def indCatMasterInstance = IndCatMaster.get( params.id )
 			 if(!indCatMasterInstance) {
    	            flash.message = "IndCatMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indCatMasterInstance : indCatMasterInstance ] }
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
        def indCatMasterInstance = IndCatMaster.get( params.id )
        if(indCatMasterInstance) {
            try {
                indCatMasterInstance.delete()
                flash.message = "IndCatMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndCatMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndCatMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
 			 def indCatMasterInstance = IndCatMaster.get( params.id )
 			 if(!indCatMasterInstance) {
    	            flash.message = "IndCatMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indCatMasterInstance : indCatMasterInstance ]
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
 			 def indCatMasterInstance = IndCatMaster.get( params.id )
    	        if(indCatMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indCatMasterInstance.version > version) {
    	                    indCatMasterInstance.errors.rejectValue("version", "indCatMaster.optimistic.locking.failure", "Another user has updated this IndCatMaster while you were editing.")
    	                    render(view:'edit',model:[indCatMasterInstance:indCatMasterInstance])
    	                    return
    	                }
    	            }
    	            indCatMasterInstance.properties = params
    	            if(!indCatMasterInstance.hasErrors() && indCatMasterInstance.save()) {
    	                flash.message = "IndCatMaster ${params.id} updated"
    	                redirect(action:show,id:indCatMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indCatMasterInstance:indCatMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndCatMaster not found with id ${params.id}"
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
 			def indCatMasterInstance = new IndCatMaster()
    	        indCatMasterInstance.properties = params
    	        return ['indCatMasterInstance':indCatMasterInstance]
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
    			 def indCatMasterInstance = new IndCatMaster(params)
    	        if(!indCatMasterInstance.hasErrors() && indCatMasterInstance.save()) {
    	            flash.message = "IndCatMaster ${indCatMasterInstance.id} created"
    	            redirect(action:show,id:indCatMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indCatMasterInstance:indCatMasterInstance])
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
    
    def forgetPassword = {
    	 try {
    			def usertype = params.radioButton
    	    	if (usertype.equals('SPCB') ){
    	    		def userMasterInstance = UserMaster.findWhere(id:params.userName)
    	    		if (userMasterInstance){
    	    			redirect(controller:'userMaster',action:'forgetPassSPCB1',params:[userName:params.userName])
    	    		}	
    	    		else if(!userMasterInstance){
    	    			flash.message="UserName do not exist "
    	    			render(view:'/indCatMaster/forgetPassword')
    	    		}
    	    	}
    	    	if(usertype.equals('Industry'))  {
    	    		def industryRegMasterInstance = IndUser.findWhere(id:params['userName'])
    		        if(industryRegMasterInstance){
    	    			 redirect(controller:'industryRegMaster',action:'forgetPassIND1',params:[userName:params.userName])
    	    		 }
    	    		 else if(!industryRegMasterInstance){
    	     			flash.message="UserName do not exist "
    	     			render(view:'/indCatMaster/forgetPassword')
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
