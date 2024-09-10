

class EffluentMeasureStandardMasterController {
    
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
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    	     params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ effluentMeasureStandardMasterInstanceList: EffluentMeasureStandardMaster.list( params ), effluentMeasureStandardMasterInstanceTotal: EffluentMeasureStandardMaster.count() ]
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
    	      def effluentMeasureStandardMasterInstance = EffluentMeasureStandardMaster.get( params.id )
    	      if(!effluentMeasureStandardMasterInstance) {
    	            flash.message = "EffluentMeasureStandardMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ effluentMeasureStandardMasterInstance : effluentMeasureStandardMasterInstance ] }
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
        def effluentMeasureStandardMasterInstance = EffluentMeasureStandardMaster.get( params.id )
        if(effluentMeasureStandardMasterInstance) {
            try {
                effluentMeasureStandardMasterInstance.delete(flush:true)
                flash.message = "Effluent Measure Standard ${params.measureStandard} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Effluent Measure Standard ${params.measureStandard} could not be deleted"
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "EffluentMeasureStandardMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    	      def effluentMeasureStandardMasterInstance = EffluentMeasureStandardMaster.get( params.effluentMeasureStandardMaster_Id )
    	      if(!effluentMeasureStandardMasterInstance) {
    	            flash.message = "EffluentMeasureStandardMaster not found with id ${params.id}"
    	            redirect(action:updatePage)
    	        }
    	        else {
    	            return [ effluentMeasureStandardMasterInstance : effluentMeasureStandardMasterInstance ]
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
    	      def effluentMeasureStandardMasterInstance = EffluentMeasureStandardMaster.get( params.id )
    	        if(effluentMeasureStandardMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(effluentMeasureStandardMasterInstance.version > version) {
    	                    
    	                    effluentMeasureStandardMasterInstance.errors.rejectValue("version", "effluentMeasureStandardMaster.optimistic.locking.failure", "Another user has updated this EffluentMeasureStandardMaster while you were editing.")
    	                    render(view:'edit',model:[effluentMeasureStandardMasterInstance:effluentMeasureStandardMasterInstance])
    	                    return
    	                }
    	            }
    	            effluentMeasureStandardMasterInstance.properties = params
    	            effluentMeasureStandardMasterInstance.updatedBy=session.userMaster
    	            if(!effluentMeasureStandardMasterInstance.hasErrors() && effluentMeasureStandardMasterInstance.save()) {
    	                flash.message = "Effluent Measure Standard ${effluentMeasureStandardMasterInstance.measureStandard} updated"
    	                redirect(action:show,id:effluentMeasureStandardMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[effluentMeasureStandardMasterInstance:effluentMeasureStandardMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "EffluentMeasureStandardMaster not found with id ${params.id}"
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
    	      def effluentMeasureStandardMasterInstance = new EffluentMeasureStandardMaster()
    	        effluentMeasureStandardMasterInstance.properties = params
    	        return ['effluentMeasureStandardMasterInstance':effluentMeasureStandardMasterInstance]
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
    	      def effluentMeasureStandardMasterInstance = new EffluentMeasureStandardMaster(params)
    	        effluentMeasureStandardMasterInstance.createdBy = session.userMaster
    	        effluentMeasureStandardMasterInstance.updatedBy = session.userMaster
    	        effluentMeasureStandardMasterInstance.dateCreated= new Date()
    	        effluentMeasureStandardMasterInstance.lastUpdated = new Date()
    	        if(!effluentMeasureStandardMasterInstance.hasErrors() && effluentMeasureStandardMasterInstance.save()) {
    	            flash.message = "Effluent Measure Standard ${effluentMeasureStandardMasterInstance.measureStandard} created"
    	            redirect(action:show,id:effluentMeasureStandardMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[effluentMeasureStandardMasterInstance:effluentMeasureStandardMasterInstance])
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
