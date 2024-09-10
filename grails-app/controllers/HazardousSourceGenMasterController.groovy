class HazardousSourceGenMasterController {
    
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
    
    static allowedMethods = [delete:'POST', save:'POST', update:'POST',deletex:'POST', savex:'POST', updatex:'POST']
    
    def list = {
    	 try {
    		 def hazardousSourceGenMasterList = HazardousSourceGenMaster.list()
    	       params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	       [ hazardousSourceGenMasterInstanceList: HazardousSourceGenMaster.list( params ), hazardousSourceGenMasterInstanceTotal: HazardousSourceGenMaster.count() ,hazardousSourceGenMasterList:hazardousSourceGenMasterList]
    	   
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
    		def hazardousSourceGenMasterInstance = HazardousCategoryMaster.get( params.id )
            if(!hazardousSourceGenMasterInstance) {
                flash.message = "Hazardous Category not found with id ${params.id}"
                redirect(action:updatePage)
            }
            else { return [ hazardousSourceGenMasterInstance : hazardousSourceGenMasterInstance ] }
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
    	 def hazardousSourceGenMasterInstance = HazardousCategoryMaster.get( params.ind )
        if(hazardousSourceGenMasterInstance) {
            try {
                hazardousSourceGenMasterInstance.delete(flush:true)
                flash.message = "Hazardous Category ${params.industryType} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = "Hazardous Category ${params.industryType} could not be deleted"
                redirect(action:show,id:params.ind)
            }
        }
        else {
            flash.message = "HazardousSourceGenMaster not found with id ${params.id}"
            redirect(action:updatePage)
        }
    }

    def edit = {
    	 try {
    			 def hazardousCategoryMasterInstance = HazardousCategoryMaster.get(params.hazardousSourceGenMasterList.id)
    	        def hazardousSourceGenMasterInstance= HazardousSourceGenMaster.get(params.category.id)
    	        if(!hazardousCategoryMasterInstance) {
    	            flash.message = "Hazardous Category not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ hazardousCategoryMasterInstance : hazardousCategoryMasterInstance,hazardousSourceGenMasterInstance:hazardousSourceGenMasterInstance ]
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
    			def a=params.ind
    	        def hazardousCategoryMasterInstance = HazardousCategoryMaster.find("from HazardousCategoryMaster hc where hc.id='$a'")
    	       if(hazardousCategoryMasterInstance) {
    	    	     if(params.version) {
    	                def version = params.version.toLong()
    	                if(hazardousCategoryMasterInstance.version > version) {
    	                    
    	                	hazardousCategoryMasterInstance.errors.rejectValue("version", "hazardousCategoryMaster.optimistic.locking.failure", "Another user has updated this HazardousSourceGenMaster while you were editing.")
    	                    render(view:'edit',model:[hazardousCategoryMasterInstance:hazardousCategoryMasterInstance])
    	                    return
    	                }
    	            }
    	    	   def b=params.category.id
    	            hazardousCategoryMasterInstance.sourceName = HazardousSourceGenMaster.get(b)
    	           def aa=HazardousCategoryMaster.findAll("from HazardousCategoryMaster hc where hc.sourceName=$b")
    	            def x=0;
    	            for (HazardousCategoryMaster aaa : aa) {
    	            	
    		x++;
    	} 
    	            hazardousCategoryMasterInstance.name=params.industryType
    	            hazardousCategoryMasterInstance.version=0
    	            if(!hazardousCategoryMasterInstance.hasErrors() && hazardousCategoryMasterInstance.save()) {
    	                flash.message = "Hazardous Category ${params.industryType} updated"
    	                redirect(action:show,id:hazardousCategoryMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[hazardousCategoryMasterInstance:hazardousCategoryMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Hazardous Category not found with id ${params.id}"
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
    	        def hazardousSourceGenMasterInstance = new HazardousSourceGenMaster()
    	         hazardousSourceGenMasterInstance.properties = params
    	        return ['hazardousSourceGenMasterInstance':hazardousSourceGenMasterInstance]
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
    	       def hazardousCategoryMasterInstance = new HazardousCategoryMaster()
    	        def b=params.category.id
    	        def aa=HazardousCategoryMaster.findAll("from HazardousCategoryMaster hc where hc.sourceName=$b")
    	        def x=0;
    	        for (HazardousCategoryMaster aaa : aa) {
    	x++;
    	} 
    	      def n=params.industryType
    	        hazardousCategoryMasterInstance.name=n
    	        hazardousCategoryMasterInstance.sourceName=HazardousSourceGenMaster.get(b)
    	        x++;
    	        hazardousCategoryMasterInstance.category=(b+"."+x)
    	        hazardousCategoryMasterInstance.version=0
    	        def hazardousSourceGenMasterInstance=hazardousCategoryMasterInstance
    	        if(!hazardousSourceGenMasterInstance.hasErrors() && hazardousSourceGenMasterInstance.save()) {
    	            flash.message = "HazardousCategoryMaster  ${hazardousSourceGenMasterInstance.name} created"
    	            redirect(action:show,id:hazardousCategoryMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[hazardousSourceGenMasterInstance:hazardousSourceGenMasterInstance])
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

	def myAjaxIndustryType ={
    	 try {
    	       def hazardousSourceGenMasterList
    			def hazardousSourceGenMasterListp
    			def a 
    			def cat
    			if(params.cont== '9999' ) {
    				
    				render g.select( width:'10', optionKey:'id',name:'hazardousSourceGenMaster', from:hazardousSourceGenMasterList)
    			}
    			else {
    				a = params.cont
    				hazardousSourceGenMasterList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster tm where tm.sourceName=$a order by tm.category asc")
    				render g.select( width:'10', optionKey:'id',name:'hazardousSourceGenMasterList.id', from:hazardousSourceGenMasterList) 
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
    
    def go={
    	 try {
    	      if( params.industryType.id==null || params.industryType.id=="")
    	    	{
    	    		flash.message="Please Select The Hazardous Category To Update"
    	    		redirect(action:list)
    	    	}
    	    	else
    	    	{
    	    	 def hazardousSourceGenMasterInstance = HazardousSourceGenMaster.get( params.industryType.id )
    	    	   
    	    	     redirect(action:edit,id: params.industryType.id )
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
 
    def createx = {
    	 try {
    	       def hazardousSourceGenMasterInstance = new HazardousSourceGenMaster()
    	        hazardousSourceGenMasterInstance.properties = params
    	        return ['hazardousSourceGenMasterInstance':hazardousSourceGenMasterInstance]
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
    
    def listx = {
    	 try {
    	       params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ hazardousSourceGenMasterList: HazardousSourceGenMaster.list( params ), hazardousSourceGenMasterInstanceTotal: HazardousSourceGenMasterInstance.count() ]
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
    
    def updatePagex={}
    
    def savex = {
    	 try {
    	      def  hazardousSourceGenMasterInstance = new  HazardousSourceGenMaster(params)
    	        hazardousSourceGenMasterInstance.version=0
    	        hazardousSourceGenMasterInstance.name=params.unitTypeName
    	        
    	        if(! hazardousSourceGenMasterInstance.hasErrors() &&  hazardousSourceGenMasterInstance.save()) {
    	            flash.message = "Hazardous Source ${ hazardousSourceGenMasterInstance.name} created"
    	            redirect(action:showx,id:hazardousSourceGenMasterInstance.id)
    	        }
    	        else {
    	            render(view:'createx',model:[hazardousSourceGenMasterInstance:hazardousSourceGenMasterInstance])
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
    
    def showx = {
    	 try {
    	      def hazardousSourceGenMasterInstance = HazardousSourceGenMaster.get( params.id )
    	        if(!hazardousSourceGenMasterInstance) {
    	            flash.message = "Hazardous Source not found with id ${params.id}"
    	            redirect(action:createx)
    	        }
    	        else { return [ hazardousSourceGenMasterInstance : hazardousSourceGenMasterInstance ] }
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
    
    def deletex = {
    	def hazardousSourceGenMasterInstance = HazardousSourceGenMaster.get( params.hazardousSourceGenMaster_Id )
        if(hazardousSourceGenMasterInstance) {
            try {
            	hazardousSourceGenMasterInstance.delete(flush:true)
                flash.message = "Hazardous Source ${params.unitTypeName} deleted"
                redirect(action:updatePagex)
            }
            catch(Exception e) {
                flash.message = "${params.unitTypeName} is still used in Unit. First delete Unit related to ${params.unitTypeName} "
                redirect(action:updatePagex)
            }
        }
        else {
            flash.message = "Hazardous Source not found with id ${params.id}"
            redirect(action:showx)
        }
    }
    
    def editx = {
    	 try {
    	     def hazardousSourceGenMasterInstance = HazardousSourceGenMaster.get( params.hazardousSourceGenMaster_Id )
          if(!hazardousSourceGenMasterInstance) {
                flash.message = "Hazardous Source not found with id ${params.id}"
                redirect(action:updatePagex)
            }
            else {
                return [ hazardousSourceGenMasterInstance : hazardousSourceGenMasterInstance ]
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

    def updatex = {
    	 try {
    	      def hazardousSourceGenMasterInstance =HazardousSourceGenMaster.get( params.hazardousSourceGenMaster_Id )
    	        if(hazardousSourceGenMasterInstance) {
    	        	 if(params.version) {
    	                def version = params.version.toLong()
    	                if(hazardousSourceGenMasterInstance.version > version) {
    	                    
    	                	hazardousSourceGenMasterInstance.errors.rejectValue("version", "hazardousSourceGenMaster.optimistic.locking.failure", "Another user has updated this hazardousSourceGenMaster while you were editing.")
    	                    render(view:'editx',model:[hazardousSourceGenMasterInstance:hazardousSourceGenMasterInstance])
    	                    return
    	                }
    	            }
    	        	 hazardousSourceGenMasterInstance.name = params.unitTypeName
    	            hazardousSourceGenMasterInstance.version=0
    	        	if(!hazardousSourceGenMasterInstance.hasErrors() && hazardousSourceGenMasterInstance.save()) {
    	                flash.message = "Hazardous Source ${hazardousSourceGenMasterInstance.name} updated"
    	                redirect(action:showx,id:hazardousSourceGenMasterInstance.id)
    	            }
    	            else {
    	                render(view:'editx',model:[hazardousSourceGenMasterInstance:hazardousSourceGenMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Hazardous Source not found with id ${params.id}"
    	            redirect(action:editx,id:params.id)
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
