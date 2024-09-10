

class ConditionMasterController {
    
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	       params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ conditionMasterInstanceList: ConditionMaster.list( params ), conditionMasterInstanceTotal: ConditionMaster.count() ]
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
    	       def conditionMasterInstance = ConditionMaster.get( params.id )
    	       if(!conditionMasterInstance) {
    	            flash.message = "ConditionMaster not found with id ${params.id}"
    	            redirect(action:searchCondition)
    	        }
    	        else { return [ conditionMasterInstance : conditionMasterInstance ] }
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
        def conditionMasterInstance = ConditionMaster.get( params.id )
        if(conditionMasterInstance) {
            try {
                conditionMasterInstance.delete()
                flash.message = "Condition ${params.id} deleted"
                redirect(action:searchCondition)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "ConditionMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "ConditionMaster not found with id ${params.id}"
            redirect(action:searchCondition)
        }
    }

    def edit = {
    	 try { 
    	     def conditionMasterInstance = ConditionMaster.get( params.id )
    	     if(!conditionMasterInstance) {
                flash.message = "ConditionMaster not found with id ${params.id}"
                redirect(action:searchCondition)
            }
            else {
            	 return [ conditionMasterInstance : conditionMasterInstance ]
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
    	     def conditionMasterInstance = ConditionMaster.get( params.id )
            if(conditionMasterInstance) {
                if(params.version) {
                    def version = params.version.toLong()
                    if(conditionMasterInstance.version > version) {
                        
                        conditionMasterInstance.errors.rejectValue("version", "conditionMaster.optimistic.locking.failure", "Another user has updated this ConditionMaster while you were editing.")
                        render(view:'edit',model:[conditionMasterInstance:conditionMasterInstance])
                        return
                    }
                }
                conditionMasterInstance.properties = params
                conditionMasterInstance.updatedBy=session.userMaster
                if(!conditionMasterInstance.hasErrors() && conditionMasterInstance.save()) {
                    flash.message = "Condition updated"
                    redirect(action:show,id:conditionMasterInstance.id)
                }
                else {
                    render(view:'edit',model:[conditionMasterInstance:conditionMasterInstance])
                }
            }
            else {
                flash.message = "ConditionMaster not found with id ${params.id}"
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
    	        def conditionMasterInstance = new ConditionMaster()
    	        conditionMasterInstance.properties = params
    	        return ['conditionMasterInstance':conditionMasterInstance]
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
    	       def conditionMasterInstance = new ConditionMaster(params)
    	        conditionMasterInstance.createdBy=session.userMaster
    	        conditionMasterInstance.updatedBy=session.userMaster
    	        if(!conditionMasterInstance.hasErrors() && conditionMasterInstance.save()) {
    	            flash.message = "Condition created"
    	            redirect(action:show,id:conditionMasterInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[conditionMasterInstance:conditionMasterInstance])
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
    
    def searchCondition={}
    def search={
    	 try { 
    	       if(params.conditionType && params.consentFor && params.applicationTypeMaster_id && params.applicationFor && params.industryTypeMaster_id)
    	    	{
    	    		
    	    		params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
    	    		def xyz5
    	    		def qwe
    	    		if(params.max)
    	    			{
    	    				xyz5=(params.max).toInteger()
    	    			}
    	    		else
    	    			{
    	    				xyz5=10
    	    			}
    	    		if(params.offset)
    	    			{
    	    				qwe=(params.offset).toInteger()
    	    			}
    	    		else
    	    			{
    	    				qwe=0
    	    			}
    	    		def paramList=params
    	    		def conditionMasterList
    	    		def total
    	    		def id1=(params.industryTypeMaster_id).toLong()
    	    		def id2=(params.applicationTypeMaster_id).toLong()
    	    		def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
    	    		def applicationTypeMasterInstance=ApplicationTypeMaster.get(id2)
    	    		if(params.conditionType=="General")
    	    		{
    	    			if(params.consentFor=="new")
    	    			{
    	    				if(params.applicationFor=="air")
    	    				{
    	    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'new',applicationFor:'air',conditionType:'General')
    	    		    		conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='new' and cond.applicationFor='air' and cond.conditionType='General' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    	    		    		def sizeVal=conditionMaster.size()
    	    		    		total=sizeVal
    	    					render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    	    				}
    	    				if(params.applicationFor=="water")
    	    				{
    	    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'new',applicationFor:'water',conditionType:'General')
    	    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='new' and cond.applicationFor='water' and cond.conditionType='General' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    	    					def sizeVal=conditionMaster.size()
    	    		    		total=sizeVal
    	    					render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    	    				}
    	    				if(params.applicationFor=="both")
    	    				{
    	    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'new',applicationFor:'both',conditionType:'General')
    	    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='new' and cond.applicationFor='both' and cond.conditionType='General' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    	    		    		def sizeVal=conditionMaster.size()
    	    		    		total=sizeVal
    	    					render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    	    				}
    	    				
    	    			}else
    	    				{
    		    				if(params.applicationFor=="air")
    		    				{
    		    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'reNew',applicationFor:'air',conditionType:'General')
    		    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='reNew' and cond.applicationFor='air' and cond.conditionType='General' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    					def sizeVal=conditionMaster.size()
    		    		    		total=sizeVal
    		    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    		    				}
    		    				if(params.applicationFor=="water")
    		    				{
    		    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'reNew',applicationFor:'water',conditionType:'General')
    		    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='reNew' and cond.applicationFor='water' and cond.conditionType='General' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    					def sizeVal=conditionMaster.size()
    		    		    		total=sizeVal
    		    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    		    				}
    		    				if(params.applicationFor=="both")
    		    				{
    		    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'reNew',applicationFor:'both',conditionType:'General')
    		    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='reNew' and cond.applicationFor='both' and cond.conditionType='General' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    					def sizeVal=conditionMaster.size()
    		    		    		total=sizeVal
    		    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    		    				}
    	    				}
    	    		}else 
    	    			{
    	    			if(params.consentFor=="new")
    	    				{
    		    				if(params.applicationFor=="air")
    		    				{
    		    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'new',applicationFor:'air',conditionType:'Specific')
    		    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='new' and cond.applicationFor='air' and cond.conditionType='Specific' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    					def sizeVal=conditionMaster.size()
    		    		    		total=sizeVal
    		    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    		    				}
    		    				if(params.applicationFor=="water")
    		    				{
    		    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'new',applicationFor:'water',conditionType:'Specific')
    		    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='new' and cond.applicationFor='water' and cond.conditionType='Specific' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    					def sizeVal=conditionMaster.size()
    		    		    		total=sizeVal
    		    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    		    				}
    		    				if(params.applicationFor=="both")
    		    				{
    		    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'new',applicationFor:'both',conditionType:'Specific')
    		    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='new' and cond.applicationFor='both' and cond.conditionType='Specific' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    					def sizeVal=conditionMaster.size()
    		    		    		total=sizeVal
    		    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    		    				}
    	    				
    	    				}else
    	    					{
    		    					if(params.applicationFor=="air")
    			    				{
    		    						def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'reNew',applicationFor:'air',conditionType:'Specific')
    		    						conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='reNew' and cond.applicationFor='air' and cond.conditionType='Specific' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    		    						def sizeVal=conditionMaster.size()
    		        		    		total=sizeVal
    		        		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    			    				}
    			    				if(params.applicationFor=="water")
    			    				{
    			    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'reNew',applicationFor:'water',conditionType:'Specific')
    			    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='reNew' and cond.applicationFor='water' and cond.conditionType='Specific' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    			    					def sizeVal=conditionMaster.size()
    			    		    		total=sizeVal
    			    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    			    				}
    			    				if(params.applicationFor=="both")
    			    				{
    			    					def conditionMaster=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:'reNew',applicationFor:'both',conditionType:'Specific')
    			    					conditionMasterList=ConditionMaster.findAll("From ConditionMaster cond where cond.industryTypeMaster=? and cond.applicationTypeMaster=? and cond.consentFor='reNew' and cond.applicationFor='both' and cond.conditionType='Specific' order by cond.id ",[industryTypeMasterInstance,applicationTypeMasterInstance],[max:xyz5,offset:qwe])
    			    					def sizeVal=conditionMaster.size()
    			    		    		total=sizeVal
    			    		    		render(view:'searchCondition',model:[total:total,conditionMasterList:conditionMasterList,paramList:paramList])
    			    				}
    	    					}
    		}
    	    		if(!conditionMasterList)
    	    		{
    	    			flash.message="No Result Found with these Criterias to Search"
    	    	    		render(view:'searchCondition')
    	    		}
    	    	}else
    	    		{
    	    		flash.message="Please select all the Criterias to Search"
    	    		render(view:'searchCondition')
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
