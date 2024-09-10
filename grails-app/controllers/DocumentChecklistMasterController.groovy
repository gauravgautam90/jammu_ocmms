

class DocumentChecklistMasterController {
    
    def index = {
    		 try {
    		      redirect(action:list,params:params) 
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

    def searchCondition={
        	
    }
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    	       params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ documentChecklistMasterInstanceList: DocumentChecklistMaster.list( params ), documentChecklistMasterInstanceTotal: DocumentChecklistMaster.count() ]
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
    	      def documentChecklistMasterInstance = DocumentChecklistMaster.get( params.id )
    	      if(!documentChecklistMasterInstance) {
    	            flash.message = "DocumentChecklistMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ documentChecklistMasterInstance : documentChecklistMasterInstance ] }
    	    
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
        def documentChecklistMasterInstance = DocumentChecklistMaster.get( params.id )
        if(documentChecklistMasterInstance) {
            try {
                documentChecklistMasterInstance.delete()
                flash.message = "DocumentChecklist ${documentChecklistMasterInstance} deleted"
                redirect(action:searchCondition)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "DocumentChecklistMaster ${documentChecklistMasterInstance} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "DocumentChecklist not found with id ${params.id}"
            redirect(action:searchCondition)
        }
    }

    def edit = {
    	 try {
    	      def documentChecklistMasterInstance = DocumentChecklistMaster.get( params.industryTypeMaster.id )
    	      if(!documentChecklistMasterInstance) {
    	            flash.message = "DocumentChecklistMaster not found with id ${params.id}"
    	            redirect(action:searchCondition)
    	        }
    	        else {
    	            return [ documentChecklistMasterInstance : documentChecklistMasterInstance ]
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
    	      def documentChecklistMasterInstance = DocumentChecklistMaster.get( params.id )
    	        if(documentChecklistMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(documentChecklistMasterInstance.version > version) {
    	                    
    	                    documentChecklistMasterInstance.errors.rejectValue("version", "documentChecklistMaster.optimistic.locking.failure", "Another user has updated this DocumentChecklistMaster while you were editing.")
    	                    render(view:'edit',model:[documentChecklistMasterInstance:documentChecklistMasterInstance])
    	                    return
    	                }
    	            }
    	            documentChecklistMasterInstance.documentType = params.document
    	            documentChecklistMasterInstance.properties = params    	       
    	            if(!documentChecklistMasterInstance.hasErrors() && documentChecklistMasterInstance.save()) {
    	                flash.message = "DocumentChecklistMaster ${documentChecklistMasterInstance} updated"
    	                redirect(action:show,id:documentChecklistMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[documentChecklistMasterInstance:documentChecklistMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "DocumentChecklistMaster not found with id ${params.id}"
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
    	      def documentChecklistMasterInstance = new DocumentChecklistMaster()
    	        documentChecklistMasterInstance.properties = params
    	        return ['documentChecklistMasterInstance':documentChecklistMasterInstance]
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
    		   println("params in save documentChecklistMaster.."+params)
    	       def documentChecklistMasterInstance = new DocumentChecklistMaster(params)
    	       documentChecklistMasterInstance.documentType=params.document
    	       
    	       if(params.consentFor=='D.G.Set'){
    	    	   documentChecklistMasterInstance.consentFor="dgset"
    	       }else if(params.consentFor=='Stone Crusher'){
    	    	   documentChecklistMasterInstance.consentFor="stonecrusher"
    	       }else if(params.consentFor=='Stone Crusher and Hot mix plants'){
    	    	   documentChecklistMasterInstance.consentFor="stonecrusher and hotmixplants"
    	       }else if(params.consentFor=='Hot mix plants'){
    	    	   documentChecklistMasterInstance.consentFor="hotmixplants"
    	       }else if(params.consentFor=='Brick Kilns'){
    	    	   documentChecklistMasterInstance.consentFor="brickkilns"
    	       }else if(params.consentFor=='Hotel'){
    	    	   documentChecklistMasterInstance.consentFor="hotel"
    	       }else{
    	        documentChecklistMasterInstance.consentFor="new"
    	       }
    		 
    		   
    		   		if(params.applicationFor=='HWM')
    		   		{
    			   documentChecklistMasterInstance.applicationFor="hwm"
    		   }else  if(params.applicationFor=='BMW')
    			   {
        			   documentChecklistMasterInstance.applicationFor="bmw"
    			   }
    			else if(params.applicationFor=='MSW')
    			    {
        			  documentChecklistMasterInstance.applicationFor="msw"
            		}
        	     else  if(params.applicationFor=='PWM')
        	        {
            			    documentChecklistMasterInstance.applicationFor="PWM"
                	 }
    		   		
        	     else  if(params.applicationFor=='EWASTE')
     	        {
         			    documentChecklistMasterInstance.applicationFor="eWaste"
             	 }
    		   
    	       documentChecklistMasterInstance.createdBy=session.userMaster;
    	       documentChecklistMasterInstance.updatedBy=session.userMaster;
    	       documentChecklistMasterInstance.isMandatory=params.isMandatory
    	       
    	       if(!documentChecklistMasterInstance.hasErrors() && documentChecklistMasterInstance.save()) {
    	            flash.message = "DocumentChecklistMaster ${documentChecklistMasterInstance} created"
    	            redirect(action:show,id:documentChecklistMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[documentChecklistMasterInstance:documentChecklistMasterInstance])
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
   
def search={
    	 try {
    	      def industryTypeMasterInstance = IndustryTypeMaster.get(params.industryType.id)
    	        def other = params.industryType.id
    	            
    	            if(other.equals("1236")||other.equals("1235")||other.equals("1234"))
    	            {
    	                flash.message = "Industry Type Other cannot be updated"
    	                	redirect(action:list)
    	            }
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
    
}
