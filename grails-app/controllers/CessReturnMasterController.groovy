 

class CessReturnMasterController {
    
    def index = {
    		 try { redirect(action:list,params:params) 
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ cessReturnMasterInstanceList: CessReturnMaster.list( params ), cessReturnMasterInstanceTotal: CessReturnMaster.count() ]
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
    	        def cessReturnMasterInstance = CessReturnMaster.get( params.id )
    	        if(!cessReturnMasterInstance) {
    	            flash.message = "CessReturnMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ cessReturnMasterInstance : cessReturnMasterInstance ] }
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

    def delete = {
        def cessReturnMasterInstance = CessReturnMaster.get( params.id )
        if(cessReturnMasterInstance) {
            try {
                cessReturnMasterInstance.delete()
                flash.message = "CessReturnMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CessReturnMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "CessReturnMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try { 
    	        def cessReturnMasterInstance = CessReturnMaster.get( params.id )
    	        if(!cessReturnMasterInstance) {
    	            flash.message = "CessReturnMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ cessReturnMasterInstance : cessReturnMasterInstance ]
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
    	        def cessReturnMasterInstance = CessReturnMaster.get( params.id )
    	        if(cessReturnMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(cessReturnMasterInstance.version > version) {
    	                    
    	                    cessReturnMasterInstance.errors.rejectValue("version", "cessReturnMaster.optimistic.locking.failure", "Another user has updated this CessReturnMaster while you were editing.")
    	                    render(view:'edit',model:[cessReturnMasterInstance:cessReturnMasterInstance])
    	                    return
    	                }
    	            }
    	            cessReturnMasterInstance.properties = params
    	            if(!cessReturnMasterInstance.hasErrors() && cessReturnMasterInstance.save()) {
    	                flash.message = "CessReturnMaster ${params.id} updated"
    	                redirect(action:show,id:cessReturnMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[cessReturnMasterInstance:cessReturnMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "CessReturnMaster not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
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

    def create = {
    	 try { 
    	       def cessReturnMasterInstance = new CessReturnMaster()
    	        cessReturnMasterInstance.properties = params
    	        def sourceMaster = CessSourceConsumptionMaster.list()
    	        return ['cessReturnMasterInstance':cessReturnMasterInstance,'sourceMaster':sourceMaster]
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
    	        def cessReturnMasterInstance = new CessReturnMaster(params)
    	        if(!cessReturnMasterInstance.hasErrors() && cessReturnMasterInstance.save()) {
    	            flash.message = "CessReturnMaster ${cessReturnMasterInstance.id} created"
    	            redirect(action:show,id:cessReturnMasterInstance.id)
    	        }
    	        else {
    	        	def sourceMaster = CessSourceConsumptionMaster.list()
    	            render(view:'create',model:[cessReturnMasterInstance:cessReturnMasterInstance,sourceMaster:sourceMaster])
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
