class CharacteristicsOfHazardeousWasteController {

    def index = {
    	 try { 
    		   redirect(action:create,params:params) 
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

    def updatePage={}

    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	        [ characteristicsOfHazardeousWasteInstanceList: CharacteristicsOfHazardeousWaste.list( params ), characteristicsOfHazardeousWasteInstanceTotal: CharacteristicsOfHazardeousWaste.count() ]
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
    	       def characteristicsOfHazardeousWasteInstance = CharacteristicsOfHazardeousWaste.get( params.id )
    	        if(!characteristicsOfHazardeousWasteInstance) {
    	            flash.message = "CharacteristicsOfHazardeousWaste not found"
    	            redirect(action:create)
    	        }
    	        else { return [ characteristicsOfHazardeousWasteInstance : characteristicsOfHazardeousWasteInstance ] }
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
   
    def create={
    	 try { 
    	       def characteristicsOfHazardeousWasteInstance= new CharacteristicsOfHazardeousWaste(params)
    	        characteristicsOfHazardeousWasteInstance.properties=params
    	        return['characteristicsOfHazardeousWasteInstance':characteristicsOfHazardeousWasteInstance]
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

     def save={
    	 try { 
    	      if(params.characteristics==""||params.characteristics==null )
    	        {
    	            flash.message="Please Enter the Characteristics"
    	            redirect(action:create)
    	        }
    	        else
    	        {
    	        def characteristicsOfHazardeousWasteInstance= new CharacteristicsOfHazardeousWaste(params)
    	        def Characteristic=params.characteristics
    	         def CharacteristicInstance=CharacteristicsOfHazardeousWaste.findBycharacteristics(Characteristic)
    	        if(CharacteristicInstance!=null)
    	        {
    	            flash.message="Characteristic ${Characteristic} already Exist"
    	            redirect(action:create)

    	        }
    	       else
    	        {
    	    	   characteristicsOfHazardeousWasteInstance.createdBy=session.userMaster
    	    	   characteristicsOfHazardeousWasteInstance.updatedBy=session.userMaster
    	    	   characteristicsOfHazardeousWasteInstance.dateCreated=new Date()
    	    	   characteristicsOfHazardeousWasteInstance.lastUpdated=new Date()
    	        if(!characteristicsOfHazardeousWasteInstance.hasErrors()&&characteristicsOfHazardeousWasteInstance.save())
    	        {
    	            flash.message = "Characteristic ${characteristicsOfHazardeousWasteInstance.characteristics} has been created "
    	            redirect(action:show,id:characteristicsOfHazardeousWasteInstance.id)
    	        }
    	        else
    	        {
    	            redirect(view:'create',model:[characteristicsOfHazardeousWasteInstance:characteristicsOfHazardeousWasteInstance])
    	        }
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

    def edit={
    	 try { 
    	        def characteristicsOfHazardeousWasteInstance = CharacteristicsOfHazardeousWaste.get(params.characteristicsOfHazardeousWaste_Id)
    	        if(!characteristicsOfHazardeousWasteInstance.id)
    	        {
    	            flash.message="Sorce with Id${characteristicsOfHazardeousWasteInstance.id}"
    	            redirect(action:updatePage)
    	        }
    	        else
    	        {
    	        return[characteristicsOfHazardeousWasteInstance : characteristicsOfHazardeousWasteInstance]
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
    
    def update={
    	 try { 
    	        def characteristicsOfHazardeousWasteInstance = CharacteristicsOfHazardeousWaste.get( params.id )
    	        if(characteristicsOfHazardeousWasteInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(characteristicsOfHazardeousWasteInstance.version > version) {

    	                	characteristicsOfHazardeousWasteInstance.errors.rejectValue("version", "waterDisposalModeMaster.optimistic.locking.failure", "Another user has updated this WaterDisposalModeMaster while you were editing.")
    	                    render(view:'edit',model:[characteristicsOfHazardeousWasteInstance:characteristicsOfHazardeousWasteInstance])
    	                    return
    	                }
    	            }
    	            characteristicsOfHazardeousWasteInstance.properties = params
    	            characteristicsOfHazardeousWasteInstance.updatedBy=session.userMaster
    	            if(!characteristicsOfHazardeousWasteInstance.hasErrors() && characteristicsOfHazardeousWasteInstance.save()) {
    	                flash.message = "Characteristic ${characteristicsOfHazardeousWasteInstance.characteristics} updated"
    	                redirect(action:show,id:characteristicsOfHazardeousWasteInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[characteristicsOfHazardeousWasteInstance:characteristicsOfHazardeousWasteInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "CharacteristicsOfHazardeousWaste not found"
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

    def delete={

        def characteristicsOfHazardeousWasteInstance = CharacteristicsOfHazardeousWaste.get( params.id )
        if(characteristicsOfHazardeousWasteInstance) {
            try {
            	characteristicsOfHazardeousWasteInstance.delete(flush:true)
                flash.message = "Characteristic ${params.characteristics} deleted"
                redirect(action:updatePage)
            }
            catch(Exception e) {
                flash.message = "Characteristic ${params.characteristics} could not be deleted"
                
                redirect(action:updatePage)
            }
        }
        else {
            flash.message = "CharacteristicsOfHazardeousWaste not found"
            redirect(action:updatePage)
        }

    }

}
