

class CertificateRecordController {
    
    def index = {
    		 try {
    	         redirect(action:list,params:params) 
    	    }
    		 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	  redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
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
    	        [ certificateRecordInstanceList: CertificateRecord.list( params ), certificateRecordInstanceTotal: CertificateRecord.count() ]
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	       session.invalidate()
       redirect(uri:'/index.gsp');
    	 }
     }
    }

    def show = {
    	 try {
    	       def certificateRecordInstance = CertificateRecord.get( params.id )
    	       if(!certificateRecordInstance) {
    	            flash.message = "CertificateRecord not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ certificateRecordInstance : certificateRecordInstance ] }
    	   }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	   redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	         redirect(uri:'/index.gsp');
    	 }
     }
    }

    def delete = {
        def certificateRecordInstance = CertificateRecord.get( params.id )
        if(certificateRecordInstance) {
            try {
                certificateRecordInstance.delete()
                flash.message = "CertificateRecord ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CertificateRecord ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "CertificateRecord not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	        def certificateRecordInstance = CertificateRecord.get( params.id )
    	        if(!certificateRecordInstance) {
    	            flash.message = "CertificateRecord not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ certificateRecordInstance : certificateRecordInstance ]
    	        }
    	   }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	         redirect(uri:'/index.gsp');
    	 }
     }
    }

    def update = {
    	 try {
    	        def certificateRecordInstance = CertificateRecord.get( params.id )
    	        if(certificateRecordInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(certificateRecordInstance.version > version) {
    	                    
    	                    certificateRecordInstance.errors.rejectValue("version", "certificateRecord.optimistic.locking.failure", "Another user has updated this CertificateRecord while you were editing.")
    	                    render(view:'edit',model:[certificateRecordInstance:certificateRecordInstance])
    	                    return
    	                }
    	            }
    	            certificateRecordInstance.properties = params
    	            if(!certificateRecordInstance.hasErrors() && certificateRecordInstance.save()) {
    	                flash.message = "CertificateRecord ${params.id} updated"
    	                redirect(action:show,id:certificateRecordInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[certificateRecordInstance:certificateRecordInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "CertificateRecord not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
    	        }
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	  redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	         session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
     }
    }

    def create = {
    	 try {
    	       def certificateRecordInstance = new CertificateRecord()
    	        certificateRecordInstance.properties = params
    	        return ['certificateRecordInstance':certificateRecordInstance]
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
   }
   }

    def save = {
    	 try {
    	       def certificateRecordInstance = new CertificateRecord(params)
    	        if(!certificateRecordInstance.hasErrors() && certificateRecordInstance.save()) {
    	            flash.message = "CertificateRecord ${certificateRecordInstance.id} created"
    	            redirect(action:show,id:certificateRecordInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[certificateRecordInstance:certificateRecordInstance])
    	        }
    	    }
    	 catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    	 redirect(controller:'indUser',action:'openIndustryHome')
    	 }else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
     }
    }
    
}
