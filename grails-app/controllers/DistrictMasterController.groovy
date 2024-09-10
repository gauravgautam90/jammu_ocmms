

class DistrictMasterController {
    
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
    
    def search = 
    	{
    		 try {
    			 if(params.autocomplete_parameter==null || params.autocomplete_parameter=="")
    	    		{
    	    			flash.message="Please Enter District Name To Be Updated"
    	    			redirect(action:list)
    	    		}
    	    		else
    	    		{
    	    		 params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	    		def qwe
    	    		 if(params.offset)
    	 	   		{
    	 	   			qwe=(params.offset).toInteger()
    	 	   		}
    	 	   		else
    	 	   		{
    	 	   			qwe=0
    	 	   		}
    	    		 def firstInput = (params.autocomplete_parameter).toLowerCase()
    	    		 def distName=firstInput + '%' 
    	    		 		 
    	    		 def listSize=DistrictMaster.findAll("from DistrictMaster as country where lower(country.districtName) like :districtName", [districtName:distName]) ;	
    	    		def total=listSize.size()
    	    		 def listDist=DistrictMaster.findAll("from DistrictMaster as country where lower(country.districtName) like :districtName", [districtName:distName],[max:5,offset:qwe]) ;
    	    		  if(listDist)
    	    		 {
    	    			 render(view:'list',model:[listDist:listDist,total:total])
    	    		 }
    	    		 else
    	    		 {
    	    			 flash.message="No District Found With This Name"
    	    				 redirect(action:list)
    	    		 }
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ districtMasterInstanceList: DistrictMaster.list( params ), districtMasterInstanceTotal: DistrictMaster.count() ]
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
    	        def districtMasterInstance = DistrictMaster.get( params.id )
    	        if(!districtMasterInstance) {
    	            flash.message = "DistrictMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ districtMasterInstance : districtMasterInstance ] }
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
      
    
  def updatedistrict= {
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
    
    def delete = {
        def districtMasterInstance = DistrictMaster.get( params.id )
        if(districtMasterInstance) {
            try {
                districtMasterInstance.delete()
                flash.message = "District ${districtMasterInstance.districtName} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "District ${params.districtName} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "DistrictMaster not found"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	      def districtMasterInstance = DistrictMaster.get( params.id )
    	        if(!districtMasterInstance) {
    	            flash.message = "District not found "
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ districtMasterInstance : districtMasterInstance ]
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
    	      def districtMasterInstance = DistrictMaster.get( params.id )
    	        if(districtMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(districtMasterInstance.version > version) {
    	                     districtMasterInstance.errors.rejectValue("version", "districtMaster.optimistic.locking.failure", "Another user has updated this DistrictMaster while you were editing.")
    	                    render(view:'edit',model:[districtMasterInstance:districtMasterInstance])
    	                    return
    	                }
    	            }
    	            districtMasterInstance.properties = params
    	            districtMasterInstance.updatedBy=session.userMaster
    	            if(!districtMasterInstance.hasErrors() && districtMasterInstance.save()) {
    	                flash.message = "District ${districtMasterInstance.districtName} updated"
    	                redirect(action:show,id:districtMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[districtMasterInstance:districtMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "DistrictMaster not found with id ${params.id}"
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
    	      def districtMasterInstance = new DistrictMaster()
    	        districtMasterInstance.properties = params
    	        return ['districtMasterInstance':districtMasterInstance]
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
    	   def districtMasterInstance = new DistrictMaster(params)
    	   districtMasterInstance.createdBy = session.userMaster
         	districtMasterInstance.updatedBy = session.userMaster
         	districtMasterInstance.dateCreated= new Date()
         	districtMasterInstance.lastUpdated = new Date()
         	districtMasterInstance.districtName= params.districtName
          if(!districtMasterInstance.hasErrors() && districtMasterInstance.save()) {
             flash.message = "District  ${districtMasterInstance.districtName} created"
             redirect(action:show,id:districtMasterInstance.id)
         }
         else {
             render(view:'create',model:[districtMasterInstance:districtMasterInstance])
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
    
    def ajaxAutoComplete = {
    	 try {
    	      if(params.autocomplete_parameter)
    	    	{
    	    		def firstInput = (params.autocomplete_parameter).toLowerCase()
    	    		def input = firstInput + '%' 
    	    		def list = DistrictMaster.findAll("from DistrictMaster as country where lower(country.districtName) like :districtName", [districtName:input]) 
    	    		StringBuffer idList = new StringBuffer() 
    	    		idList.append("<ul>")
    	    		list?.each{c -> idList.append("<li>" + c.districtName+"</li>")} 
    	    		idList.append("</ul>")   
    	    		render idList.toString()}
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
