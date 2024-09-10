
public class TypeOfHazardeousWasteController{

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
    	        [hazardeousWasteTypeInstanceList: TypeOfHazardeousWaste.list( params ), hazardeousWasteTypeInstanceTotal: TypeOfHazardeousWaste.count() ]
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
    		 def typeOfHazardeousWasteInstance = TypeOfHazardeousWaste.get( params.id )
    	        if(!typeOfHazardeousWasteInstance) {
    	            flash.message = "TypeOfHazardeousWaste not found"
    	            redirect(action:list)
    	        }
    	        else { return [ typeOfHazardeousWasteInstance : typeOfHazardeousWasteInstance ] }
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
        def typeOfHazardeousWasteInstance = TypeOfHazardeousWaste.get( params.id )
        if(typeOfHazardeousWasteInstance) {
            try {
            	typeOfHazardeousWasteInstance.delete(flush:true)
                flash.message = " ${params.type} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = " ${params.type} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Hazardeous Waste Type not found"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		def typeOfHazardeousWasteInstance = TypeOfHazardeousWaste.get( params.id )
    	        if(!typeOfHazardeousWasteInstance) {
    	            flash.message = "Hazardeous Waste Type not found"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ typeOfHazardeousWasteInstance : typeOfHazardeousWasteInstance ]
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
    		 def typeOfHazardeousWasteInstance = TypeOfHazardeousWaste.get( params.id )
    	        if(typeOfHazardeousWasteInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(typeOfHazardeousWasteInstance.version > version) {
    	                    
    	                	typeOfHazardeousWasteInstance.errors.rejectValue("version", "surroundingMaster.optimistic.locking.failure", "Another user has updated this SurroundingMaster while you were editing.")
    	                    render(view:'edit',model:[typeOfHazardeousWasteInstance:typeOfHazardeousWasteInstance])
    	                    return
    	                }
    	            }
    	            typeOfHazardeousWasteInstance.properties = params
    	            if(!typeOfHazardeousWasteInstance.hasErrors() && typeOfHazardeousWasteInstance.save()) {
    	                flash.message = " ${params.type} updated"
    	                redirect(action:show,id:typeOfHazardeousWasteInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[typeOfHazardeousWasteInstance:typeOfHazardeousWasteInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "Hazardeous Waste Type not found"
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
    		 def typeOfHazardeousWasteInstance = new TypeOfHazardeousWaste()
    	        typeOfHazardeousWasteInstance.properties = params
    	        return ['typeOfHazardeousWasteInstance':typeOfHazardeousWasteInstance]
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
    		def typeOfHazardeousWasteInstance= new TypeOfHazardeousWaste(params)
             def type=params.type
            def typeInstance=TypeOfHazardeousWaste.findBytype(type)
              if(typeInstance!=null)
             {
                 flash.message="${type} already Exist"
                 redirect(action:create)
             }
            else
             {
         	   typeOfHazardeousWasteInstance = new TypeOfHazardeousWaste(params)
         	   typeOfHazardeousWasteInstance.createdBy = session.userMaster
         	   typeOfHazardeousWasteInstance.updatedBy = session.userMaster
         	   typeOfHazardeousWasteInstance.dateCreated = new Date()
         	   typeOfHazardeousWasteInstance.lastUpdated = new Date()
              if(!typeOfHazardeousWasteInstance.hasErrors() && typeOfHazardeousWasteInstance.save())
         	   {
         		   flash.message = "  ${typeOfHazardeousWasteInstance.type} created"
         		   redirect(action:show,id:typeOfHazardeousWasteInstance.id)
         	   }
         else {
             render(view:'create',model:[typeOfHazardeousWasteInstance:typeOfHazardeousWasteInstance])
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