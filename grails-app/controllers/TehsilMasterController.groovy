

class TehsilMasterController {
    
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
    		 def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
            params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
            [ tehsilMasterInstanceList: TehsilMaster.list( params ), tehsilMasterInstanceTotal: TehsilMaster.count() ,districtList:districtList]
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
        
def cancel ={
    	 try {
    		 redirect(action:home,params:params) 
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
     
def updatetehsil ={
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
    
def myAjax2={
    	 try {
    		 def tehsilList2
        	if(params.cont=='xyz')
        	{
        		
        		render g.select( width:'10', optionKey:'id',name:'tehsilName_id', from:tehsilList2)
        	}
        	else
        	{
        	def a = params.cont
        	def dist2 = DistrictMaster.get(a)
        	tehsilList2 = TehsilMaster.findAllByDistrict(dist2)
        	render g.select( width:'10', optionKey:'id',name:'tehsilName_id', from:tehsilList2)
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
    		if( params.tehsilName_id==null || params.tehsilName_id=="")
    	    	{
    	    		flash.message="Please Select The Tehsil To Update"
    	    		redirect(action:list)
    	    	}
    	    	else
    	    	{
    	    	 def tehsilMasterInstance = TehsilMaster.get( params.tehsilName_id )
    	    	    redirect(action:edit,id: params.tehsilName_id )
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
    
def show = {
    	 try {
    		 def tehsilMasterInstance = TehsilMaster.get( params.id )
    	        if(!tehsilMasterInstance) {
    	            flash.message = "Tehsil not found "
    	            redirect(action:list)
    	        }
    	        else { return [ tehsilMasterInstance : tehsilMasterInstance ] }
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
        def tehsilMasterInstance = TehsilMaster.get( params.id )
        if(tehsilMasterInstance) {
            try {
                tehsilMasterInstance.delete()
                flash.message = "Tehsil deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Tehsil could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Tehsil not found "
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		def tehsilMasterInstance = TehsilMaster.get( params.id )
    	        if(!tehsilMasterInstance) {
    	            flash.message = "Tehsil not found "
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ tehsilMasterInstance : tehsilMasterInstance ]
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
    		 def tehsilMasterInstance = TehsilMaster.get( params.id )
    	        if(tehsilMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(tehsilMasterInstance.version > version) {
    	                    tehsilMasterInstance.errors.rejectValue("version", "tehsilMaster.optimistic.locking.failure", "Another user has updated this TehsilMaster while you were editing.")
    	                    render(view:'edit',model:[tehsilMasterInstance:tehsilMasterInstance])
    	                    return
    	                }
    	            }
    	            tehsilMasterInstance.properties = params
    	            tehsilMasterInstance.updatedBy=session.userMaster
    	            if(!tehsilMasterInstance.hasErrors() && tehsilMasterInstance.save()) {
    	                flash.message = "Tehsil ${tehsilMasterInstance.tehsilName} updated"
    	                redirect(action:show,id:tehsilMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[tehsilMasterInstance:tehsilMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "TehsilMaster not found "
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
    		 def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
            def tehsilMasterInstance = new TehsilMaster()
            tehsilMasterInstance.properties = params
            return ['tehsilMasterInstance':tehsilMasterInstance,'districtList':districtList]
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
    		 def tehsilMasterInstance = new TehsilMaster(params)
    	        tehsilMasterInstance.dateCreated= new Date()
    	        tehsilMasterInstance.createdBy =session.userMaster
    	        tehsilMasterInstance.lastUpdated= new Date()
    	        tehsilMasterInstance.updatedBy =session.userMaster
    	        if(!tehsilMasterInstance.hasErrors() && tehsilMasterInstance.save()) {
    	            flash.message = "Tehsil ${tehsilMasterInstance.tehsilName} created"
    	            redirect(action:show,id:tehsilMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[tehsilMasterInstance:tehsilMasterInstance])
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

