

class OfficeMasterController {
    
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
    	        [ officeMasterInstanceList: OfficeMaster.list( params ), officeMasterInstanceTotal: OfficeMaster.count() ]
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

def myAjax = {
    	 try {
    		 def a = params.cont
    	    	def prior = OfficeMaster.get(a)
    	    	def priorList = OfficeMaster.findAllByOfficeName(prior)
    	    	render g.select( width:'10', optionKey:'id',name:'officeName.id', from:priorList)
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
    		 def officeMasterInstance = OfficeMaster.get(params.officeName.id )
       	    redirect(action:edit,id:params.officeName.id )
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
    
def updateoffice = {
    	 try {
    		 redirect(action:list ,params:params)
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
    		 def officeMasterInstance = OfficeMaster.get( params.id )
    	        if(!officeMasterInstance) {
    	            flash.message = "Office ${params.officeName} not found "
    	            redirect(action:list)
    	        }
    	        else { return [ officeMasterInstance : officeMasterInstance ] }
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
        def officeMasterInstance = OfficeMaster.get( params.id )
        if(officeMasterInstance) {
            try {
                officeMasterInstance.delete()
                flash.message = "OfficeMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "OfficeMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "OfficeMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		 def officeMasterInstance = OfficeMaster.get( params.id )
    	        ArrayList priorityList1 = new ArrayList()
    	        def currentPriority = officeMasterInstance.priority
    	    	priorityList1.add(currentPriority)
    	    	for(int i =1;i<11;i++){
    	        	def list = OfficeMaster.findAllByPriority(i)
    	        	if(list.size()==0){
    	        		priorityList1.add(i)
    	        	}
    	       }
    	        if(!officeMasterInstance) {
    	            flash.message = "Office ${params.officeName} not found "
    	            redirect(action:list)
    	        }
    	        else {
    	        	 return [ officeMasterInstance : officeMasterInstance,priorityList1:priorityList1 ]
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
    		 def officeMasterInstance = OfficeMaster.get( params.id )
    	        if(officeMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(officeMasterInstance.version > version) {
    	                     officeMasterInstance.errors.rejectValue("version", "officeMaster.optimistic.locking.failure", "Another user has updated this OfficeMaster while you were editing.")
    	                    render(view:'edit',model:[officeMasterInstance:officeMasterInstance])
    	                    return
    	                }
    	            }
    	            officeMasterInstance.properties = params
    	            if(!officeMasterInstance.hasErrors() && officeMasterInstance.save()) {
    	                flash.message = "Office ${params.officeName} updated"
    	                redirect(action:show,id:officeMasterInstance.id)
    	            }
    	            else {
    	            	flash.message="priority ${params.priority} already assigned to other office"
    	                render(view:'edit',model:[officeMasterInstance:officeMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "OfficeMaster  ${params.officeName} not found "
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
    
def popsave={
    	 try {
    		 def officeMasterInstance = new OfficeMaster(params)
    	   if(!officeMasterInstance.hasErrors() && officeMasterInstance.save()) {
    	       flash.message = "OfficeMaster ${officeMasterInstance.officeName} created"
    	       redirect(uri:"/officeMaster/showpop.gsp")
    	   }  else {
    		   flash.message="Office cannot be created, duplicate Office name or priority"
    		  
    		        	redirect(uri:"/officeMaster/showpop.gsp")
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
    		 def officeMasterInstance = new OfficeMaster()
    	        officeMasterInstance.properties = params
    	        ArrayList priorityList = new ArrayList()
    	        for(int i =1;i<11;i++){
    	        	def list = OfficeMaster.findAllByPriority(i)
    	        	if(list.size()==0){
    	        		priorityList.add(i)
    	        	}
    	        }
    	       return ['officeMasterInstance':officeMasterInstance,'priorityList':priorityList]
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
    		 def officeMasterInstance = new OfficeMaster(params)
    	        if(!officeMasterInstance.hasErrors() && officeMasterInstance.save()) {
    	            flash.message = "Office ${officeMasterInstance.officeName} created"
    	            redirect(action:show,id:officeMasterInstance.id)
    	        }
    	        else {
    	        	 render(view:'create',model:[officeMasterInstance:officeMasterInstance])
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
    
def myPriorList ={
    	 try {
    		 officeMasterInstance1 = OfficeMaster.list(priority)
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

def create1 = {
    	 try {
    		 ArrayList priorityList = new ArrayList()
    	        for(int i =1;i<11;i++){
    	        	def list = OfficeMaster.findAllByPriority(i)
    	        	if(list.size()==0){
    	        		priorityList.add(i)
    	        	}
    	        }
    	    	[priorityList:priorityList]
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