

class WorkFlowMasterController {
    
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
    	        [ workFlowMasterInstanceList: WorkFlowMaster.list( params ), workFlowMasterInstanceTotal: WorkFlowMaster.count() ]
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
    	   def workFlowMasterInstance = WorkFlowMaster.get( params.id )
    	        if(!workFlowMasterInstance) {
    	            flash.message = "WorkFlowMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ workFlowMasterInstance : workFlowMasterInstance ] }
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
        def workFlowMasterInstance = WorkFlowMaster.get( params.id )
        if(workFlowMasterInstance) {
            try {
                workFlowMasterInstance.delete()
                flash.message = "WorkFlowMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "WorkFlowMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "WorkFlowMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

 def edit = {
    	 try {
    	 def workFlowMasterInstance = WorkFlowMaster.get( params.id )
    	        if(!workFlowMasterInstance) {
    	            flash.message = "WorkFlowMaster not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ workFlowMasterInstance : workFlowMasterInstance ]
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
    	    def workFlowMasterInstance = WorkFlowMaster.get( params.id )
    	        if(workFlowMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(workFlowMasterInstance.version > version) {
    	                    
    	                    workFlowMasterInstance.errors.rejectValue("version", "workFlowMaster.optimistic.locking.failure", "Another user has updated this WorkFlowMaster while you were editing.")
    	                    render(view:'edit',model:[workFlowMasterInstance:workFlowMasterInstance])
    	                    return
    	                }
    	            }
    	            workFlowMasterInstance.properties = params
    	            if(!workFlowMasterInstance.hasErrors() && workFlowMasterInstance.save()) {
    	                flash.message = "WorkFlowMaster ${params.id} updated"
    	                redirect(action:show,id:workFlowMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[workFlowMasterInstance:workFlowMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "WorkFlowMaster not found with id ${params.id}"
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
    	  def aa= "1"
    	    	params.id = aa
    	    def workFlowMasterInstance = new WorkFlowMaster()
    	        workFlowMasterInstance.properties = params
    	        return ['workFlowMasterInstance':workFlowMasterInstance]
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

def abc = {}
    
 def save = {
    	 try {
    	    if(params['role']!=null && params['role']!=""){
    	    		def roleInst = RoleMaster.get((params['role']).toInteger())
    	        	def g = null
    	        	def workFlowMasterList = WorkFlowMaster.findAllByRole(roleInst)
    	        	def roleVsActivityList = RoleVsActivity.findAllByRole(roleInst)
    	        	if(!workFlowMasterList){
    	        		def gpId = params['grp'].toInteger()
    	    	    	def grpInst = GroupMaster.get(gpId)
    	    	    	g=grpInst
    	    	    	def roleList = RoleMaster.findAllByGroup(grpInst)
    	    	    	def actList = RoleActivityMaster.list()
    	    	    	for (int i=0;i<roleList.size();i++){
    	    	    		if(params[(roleList.get(i)).roleName] == "on"){
    	    			    	def workFlowInstance = new WorkFlowMaster()
    	    			    	def roleMasterInstance = roleInst
    	    			    	def fwdRoleIns = RoleMaster.get(((roleList.get(i)).id).toLong())
    	    			    	workFlowInstance.role = roleMasterInstance
    	    			    	workFlowInstance.canForwardTo = fwdRoleIns
    	    			    	workFlowInstance.group = grpInst
    	    			    	if(workFlowInstance.save()){
    	    			    		flash.message = "Saved"
    	    			    	}
    	    			   }
    	    	    	}
    	    	   }else{
    	        		for(int i=0;i<workFlowMasterList.size();i++){
    	        			try{
    	        				(workFlowMasterList.get(i)).delete()
    	        			}catch(Exception e){
    	        			}
    	        		}
    	        	def gpId = params['grp'].toInteger()
    	    	    	def grpInst = GroupMaster.get(gpId)
    	    	    	g=grpInst
    	    	    	def roleList = RoleMaster.findAllByGroup(grpInst)
    	    	    	def actList = RoleActivityMaster.list()
    	    	    	for (int i=0;i<roleList.size();i++){
    	    	    		if(params[(roleList.get(i)).roleName] == "on"){
    	    			    	def workFlowInstance = new WorkFlowMaster()
    	    			    	def roleMasterInstance = roleInst
    	    			    	def fwdRoleIns = RoleMaster.get(((roleList.get(i)).id).toLong())
    	    			    	workFlowInstance.role = roleMasterInstance
    	    			    	workFlowInstance.canForwardTo = fwdRoleIns
    	    			    	workFlowInstance.group = grpInst
    	    			    	if(workFlowInstance.save()){
    	    			    		flash.message = "Saved"
    	    			    	}
    	    			   }
    	    	    	}
    	        	}
    	        	render(view:"create",model:[g:g,r:roleInst])
    	    	}else{
    	    		flash.message = "role not selected"
    	    			render(view:"create")
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
    
 def saveActCess = {
    	 try {
    	    	if(params.rcRole==null||params.clariRole==null||params.insRole==null||params.insCloseRole==null||params.applicationCompletedRole==null||params.inspectionOpenRole==null||params.inspectionCloseRole==null){
    	    		flash.message = "At least one Role is necessary for each right"
    	    			redirect(action:actCreateCess)
    	    	}else{
    	    		def groupInstanceVal=GroupMaster.get((params.id).toLong())
    	    		def roleList = RoleMaster.findAllByGroup(groupInstanceVal)
    	    		if(roleList){
    	    			
    	    			def roleVsActList = null
    	    			for(int i=0;i<roleList.size();i++){
    	    				roleVsActList = CessRoleVsActivity.findAllByRole(roleList.get(i))
    	    				if(roleVsActList){
    	    				for(int j=0;j<roleVsActList.size();j++){
    	    					roleVsActList.get(j).delete()
    	    				}    			
    	    			}
    	    		}
    	    	}
    	if((params.rcRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("001")
    	    			rVaInst.role = RoleMaster.get((params.rcRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.rcRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("001")
    	        			rVaInst.role = RoleMaster.get((params.rcRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    if((params.clariRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("002")
    	    			rVaInst.role = RoleMaster.get((params.clariRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.clariRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("002")
    	        			rVaInst.role = RoleMaster.get((params.clariRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	if((params.insRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("003")
    	    			rVaInst.role = RoleMaster.get((params.insRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.insRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("003")
    	        			rVaInst.role = RoleMaster.get((params.insRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	  if((params.insCloseRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("004")
    	    			rVaInst.role = RoleMaster.get((params.insCloseRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.insCloseRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("004")
    	        			rVaInst.role = RoleMaster.get((params.insCloseRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	if((params.inspectionOpenRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("005")
    	    			rVaInst.role = RoleMaster.get((params.inspectionOpenRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.inspectionOpenRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("005")
    	        			rVaInst.role = RoleMaster.get((params.inspectionOpenRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    if((params.inspectionCloseRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("007")
    	    			rVaInst.role = RoleMaster.get((params.inspectionCloseRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.inspectionCloseRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("007")
    	        			rVaInst.role = RoleMaster.get((params.inspectionCloseRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    if((params.applicationCompletedRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new CessRoleVsActivity()
    	    			rVaInst.activity = CessActivityMaster.findByActivityCode("006")
    	    			rVaInst.role = RoleMaster.get((params.applicationCompletedRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.applicationCompletedRole).size();i++){
    	    				def rVaInst = new CessRoleVsActivity()
    	        			rVaInst.activity = CessActivityMaster.findByActivityCode("006")
    	        			rVaInst.role = RoleMaster.get((params.applicationCompletedRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    		flash.message = "Activity Rights Saved"
    	    			redirect(action:actCreateCess)
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
       
def actCreateCess = {
    	 try {
    	   def grpInstList = GroupMaster.findAll("from GroupMaster as gm where gm.groupDesc='CESS' and gm.office.priority='01' ",[max:1])
    	    	def grpInst=grpInstList[0]
    	    	if(grpInst){
    	    	def officeVal=grpInst.office
    	    	def groupVal=grpInst.groupName
    	    	def rolesList = RoleMaster.findAllByGroup(grpInst)
    	    	def list = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("001"))
    			ArrayList fwdListRc = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListRc.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<list.size();j++){
    	    			if(rolesList.get(i)==list.get(j).role){
    	        			temp = true
    	        		}
    	    		}
    				fwdListRc.add(temp)
    	    }
    def listCessIssue = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("002"))
    			ArrayList fwdListClari = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListClari.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<listCessIssue.size();j++){
    	    			if(rolesList.get(i)==listCessIssue.get(j).role){
    	        			temp = true
    	        		}
    	    		}
    				fwdListClari.add(temp)
    	    	}
  def listAssessOrder = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("003"))
    			ArrayList fwdListIns = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListIns.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<listAssessOrder.size();j++){
    	    			if(rolesList.get(i)==listAssessOrder.get(j).role){
    	    				temp = true
    	        		}
    	    		}
    				fwdListIns.add(temp)
    	    	}
 def listfeesOrder = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("004"))
    			ArrayList fwdListInsClose = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListInsClose.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<listfeesOrder.size();j++){
    	    			if(rolesList.get(i)==listfeesOrder.get(j).role){
    	    				temp = true
    	        		}
    	    		}
    				fwdListInsClose.add(temp)
    	    	}
    def listInspectionOrder = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("005"))
    			ArrayList fwdListInspectionOpen = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListInspectionOpen.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<listInspectionOrder.size();j++){
    	    			if(rolesList.get(i)==listInspectionOrder.get(j).role){
    	    				temp = true
    	        		}
    	    		}
    				fwdListInspectionOpen.add(temp)
    	    	}
def listCessComplete = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("006"))
    			ArrayList fwdListlistCessComplete = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListlistCessComplete.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<listCessComplete.size();j++){
    	    			if(rolesList.get(i)==listCessComplete.get(j).role){
    	    				temp = true
    	        		}
    	    		}
    				fwdListlistCessComplete.add(temp)
    	    	}
    			def listInspectionClose = CessRoleVsActivity.findAllByActivity(CessActivityMaster.findByActivityCode("007"))
    			ArrayList fwdListInspectionClose = new ArrayList()
    			for(int i=0;i<rolesList.size();i++){
    				fwdListInspectionClose.add(rolesList.get(i))
    	    		def temp = false
    	    		for(int j=0;j<listInspectionClose.size();j++){
    	    			if(rolesList.get(i)==listInspectionClose.get(j).role){
    	    				temp = true
    	        		}
    	    		}
    				fwdListInspectionClose.add(temp)
    	    	}
    	    	render(view:"actCreateCess",model:[grpInst:grpInst,officeVal:officeVal,groupVal:groupVal,fwdListRc:fwdListRc,fwdListInsClose:fwdListInsClose,fwdListIns:fwdListIns,fwdListClari:fwdListClari,fwdListInspectionOpen:fwdListInspectionOpen,fwdListlistCessComplete:fwdListlistCessComplete,fwdListInspectionClose:fwdListInspectionClose])
    		}else{
    			flash.message="Group Cess is not formed in Head Office."
    			render(view:"create")
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
   
 def saveAct = {
    	 try {
    		 if(params.grp==null||params.grp==""){
    	    		if(GroupMaster.get((params.grp).toLong())){
    	    			flash.message = "Please Select Valid grp"
    	    				redirect(action:actCreate)
    	    		}
    	    	}else if(params.rcRole==null||params.appRole==null||params.clariRole==null||params.insRole==null||params.rejRole==null||params.certRole==null||params.insCloseRole==null){
    	    		flash.message = "At least one Role is necessary for each right"
    	    			redirect(action:actCreate)
    	    	}else{
    	    		def roleList = RoleMaster.findAllByGroup(GroupMaster.get((params.grp).toLong()))
    	    		if(roleList){
    	    			def roleVsActList = null
    	    			for(int i=0;i<roleList.size();i++){
    	    				roleVsActList = RoleVsActivity.findAllByRole(roleList.get(i))
    	    				if(roleVsActList){
    	    				for(int j=0;j<roleVsActList.size();j++){
    	    					roleVsActList.get(j).delete()
    	    				}    			
    	    			}
    	    		}
    	    	}
    	    		if((params.rcRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("001")
    	    			rVaInst.role = RoleMaster.get((params.rcRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.rcRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("001")
    	        			rVaInst.role = RoleMaster.get((params.rcRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    		if((params.clariRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("006")
    	    			rVaInst.role = RoleMaster.get((params.clariRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.clariRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("006")
    	        			rVaInst.role = RoleMaster.get((params.clariRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.insRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("007")
    	    			rVaInst.role = RoleMaster.get((params.insRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.insRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("007")
    	        			rVaInst.role = RoleMaster.get((params.insRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.insCloseRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("008")
    	    			rVaInst.role = RoleMaster.get((params.insCloseRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.insCloseRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("008")
    	        			rVaInst.role = RoleMaster.get((params.insCloseRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.appRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("005")
    	    			rVaInst.role = RoleMaster.get((params.appRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.appRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("005")
    	        			rVaInst.role = RoleMaster.get((params.appRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.rejRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("003")
    	    			rVaInst.role = RoleMaster.get((params.rejRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.rejRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("003")
    	        			rVaInst.role = RoleMaster.get((params.rejRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.certRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new RoleVsActivity()
    	    			rVaInst.activity = RoleActivityMaster.findByActivityCode("002")
    	    			rVaInst.role = RoleMaster.get((params.certRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.certRole).size();i++){
    	    				def rVaInst = new RoleVsActivity()
    	        			rVaInst.activity = RoleActivityMaster.findByActivityCode("002")
    	        			rVaInst.role = RoleMaster.get((params.certRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    		flash.message = "Activity Rights Saved"
    	    			redirect(action:actCreate)
    	    }}catch(Exception e) {
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

def updateSelect = {
    	 try {
    		 println("-updateSelect---")
    	     if(params.selectedValue!="null" && params.selectedValue!=""){
    		    	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
    		    	def grpList = GroupMaster.findAllByOffice(officeInt)
    		    	render g.select( width:'10', optionKey:'id', value:'${g}',  id:'grp',name:'grp', from:grpList,onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateGrpSel2',update:'roleDiv', params:'\'cont=\' + this.value' )}")
    		    	
    			}else{
    				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp')
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

def updateSelect2 = {
    	 try {
    	  if(params.selectedValue!="null"){
    		    	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
    		    	def grpList = GroupMaster.findAllByOffice(officeInt)
    		    	render g.select( width:'10', optionKey:'id', value:'${g}',  id:'grp',name:'grp', from:grpList,onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateActRights',update:'actRights', params:'\'cont=\' + this.value' )}")
    			}else{
    				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp')
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

def updateSelect3={
    	 try {
    	if(params.selectedValue!="null"){
    		    	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
    		    	def grpList = GroupMaster.findAllByOffice(officeInt)
    		    	render g.select( width:'10', optionKey:'id', value:'${g}',  id:'grp',name:'grp', from:grpList,onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateActRightsLab',update:'actRights', params:'\'cont=\' + this.value' )}")
    			}else{
    				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp')
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

def updateSelect5={
    	 try {
    	    if(params.selectedValue!="null"){
    		    	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
    		    	def grpList = GroupMaster.findAll("from GroupMaster as gm where gm.office=? and gm.groupDesc='LAB' ",[officeInt])
    		    	render g.select( width:'10', optionKey:'id', value:'${g}',  id:'grp',name:'grp', from:grpList,onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateActRightsLab',update:'actRights', params:'\'cont=\' + this.value' )}")
    			}else{
    				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp')
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

def updateGrpSel = {
    	 try {
    		 println("------updateGrpSel--------")
    	    if(params['cont']!=""){
    		    	def gpId = (params['cont']).toInteger()
    		    	def grpInst = GroupMaster.get(gpId)
    		    	def roleList = RoleMaster.findAllByGroup(grpInst)
    		    	def actList = RoleActivityMaster.list()
    		    	render(template:"getRoles", model:[roleMasterInstanceList:roleList,roleActivityMasterInstanceList:actList])
    		   }else{
    	    		render(template:"blank")
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
    
 def updateGrpSel2 = {
    	 try {
    		 println("---------click``----------")
    	    if(params['cont']!=""){
    		    	def gpId = (params['cont']).toInteger()
    		    	def grpInst = GroupMaster.get(gpId)
    		    	
    		    	def roleList = RoleMaster.findAllByGroup(grpInst)
    		    	def actList = RoleActivityMaster.list()
    		    	render g.select( width:'10', optionKey:'id',  id:'role',name:'role', from:roleList, value:'${r}',onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateRoleSel',update:'fwdRights', params:'\'cont=\' + this.value' )}")
    		   }else{
    	    		render(template:"blank")
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
    
 def updateRoleSel = {
    	 try {
    	    if(params['cont']!=""){
    	    		def role = RoleMaster.get((params['cont']).toInteger())
    	        	def group = (RoleMaster.get((params['cont']).toInteger())).group
    	        	def roleList = RoleMaster.findAllByGroup(group)
    	        	def list = WorkFlowMaster.findAllByRole(role)
    	        	ArrayList fwdRoleList = new ArrayList()
    	        	for(int i=0;i<roleList.size();i++){
    	        		fwdRoleList.add(roleList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<list.size();j++){
    	        			if(roleList.get(i)==list.get(j).canForwardTo){
    	            			temp = true
    	            		}
    	        		}
    	        		fwdRoleList.add(temp)
    	        	}
    	    		render(template:"getFwdRights", model:[fwdRoleList:fwdRoleList])
    	    	}else{
    	    		render(template:"blank")
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
    
def getRoleView = {
    	 try {
    	    if(params['cont']!=""){
    	    		def gpId = (params['cont']).toInteger()
    		    	def grpInst = GroupMaster.get(gpId)
    		    	def roleList = RoleMaster.findAllByGroup(grpInst)
    		    	def actList = RoleActivityMaster.list()
    		    	render(template:"getGrid", model:[roleList:roleList,roleActivityMasterInstanceList:actList])
    	    	}else{
    	    		render(template:"blank")
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
    
def applicationProcessing = {}
    
def actCreate = { }

def updateActRights = {
    	 try {
    	     if(params['cont']!=""){
    	    		def gpId = (params['cont']).toInteger()
    		    	def grpInst = GroupMaster.get(gpId)
    		    	def rolesList = RoleMaster.findAllByGroup(grpInst)
    		    	def list = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
    	    		ArrayList fwdListRc = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListRc.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<list.size();j++){
    	        			if(rolesList.get(i)==list.get(j).role){
    	            			temp = true
    	            		}
    	        		}
    	    			fwdListRc.add(temp)
    	        	}
    	    def listClari = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("006"))
    	    		ArrayList fwdListClari = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListClari.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<listClari.size();j++){
    	        			if(rolesList.get(i)==listClari.get(j).role){
    	            			temp = true
    	            		}
    	        		}
    	    			fwdListClari.add(temp)
    	        	}
    	    	def listIns = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("007"))
    	    		ArrayList fwdListIns = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListIns.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<listIns.size();j++){
    	        			if(rolesList.get(i)==listIns.get(j).role){
    	        				temp = true
    	            		}
    	        		}
    	    			fwdListIns.add(temp)
    	        	}
    	    def listInsClose = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("008"))
    	    		ArrayList fwdListInsClose = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListInsClose.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<listInsClose.size();j++){
    	        			if(rolesList.get(i)==listInsClose.get(j).role){
    	        				temp = true
    	            		}
    	        		}
    	    			fwdListInsClose.add(temp)
    	        	}
    	    def listApp = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("005"))
    	    		ArrayList fwdListApp = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListApp.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<listApp.size();j++){
    	        			if(rolesList.get(i)==listApp.get(j).role){
    	            			temp = true
    	            		}
    	        		}
    	    			fwdListApp.add(temp)
    	        	}
    	    def listRej = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("003"))
    	    		ArrayList fwdListRej = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListRej.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<listRej.size();j++){
    	        			if(rolesList.get(i)==listRej.get(j).role){
    	            			temp = true
    	            		}
    	        		}
    	    			fwdListRej.add(temp)
    	        	}
    	    	def listCert = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("002"))
    	    		ArrayList fwdListCert = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListCert.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<listCert.size();j++){
    	        			if(rolesList.get(i)==listCert.get(j).role){
    	            			temp = true
    	            		}
    	        		}
    	    			fwdListCert.add(temp)
    	        	}
    	    		render(template:"getActRights", model:[fwdListRc:fwdListRc,fwdListClari:fwdListClari,fwdListIns:fwdListIns,fwdListApp:fwdListApp,fwdListRej:fwdListRej,fwdListCert:fwdListCert,fwdListInsClose:fwdListInsClose])
    	    	}else{
    	    		render(template:"blank")
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
    
def actCreateLab = {}
    
def updateActRightsLab = {
    	 try {
    	     if(params['cont']!=""){
    	    		def gpId = (params['cont']).toInteger()
    		    	def grpInst = GroupMaster.get(gpId)
    		    	def rolesList = RoleMaster.findAllByGroup(grpInst)
    		    	def list =LabRoleVsActivity.findAllByLabActivity(LabActivityMaster.findByActivityCode("001"))
    	    		ArrayList fwdListRc = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListRc.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<list.size();j++){
    	        			if(rolesList.get(i)==list.get(j).role){
    	            			temp = true
    	            		}
    	        		}
    	    			fwdListRc.add(temp)
    	        	}
    	    def generateReport = LabRoleVsActivity.findAllByLabActivity(LabActivityMaster.findByActivityCode("002"))
    	    		ArrayList fwdListClari = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListClari.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<generateReport.size();j++){
    	        			if(rolesList.get(i)==generateReport.get(j).role){
    	            			temp = true
    	            		}
    	        			
    	        		}
    	    			fwdListClari.add(temp)
    	        	}
    	 def comp = LabRoleVsActivity.findAllByLabActivity(LabActivityMaster.findByActivityCode("003"))
    	    		ArrayList fwdListIns = new ArrayList()
    	    		for(int i=0;i<rolesList.size();i++){
    	    			fwdListIns.add(rolesList.get(i))
    	        		def temp = false
    	        		for(int j=0;j<comp.size();j++){
    	        			if(rolesList.get(i)==comp.get(j).role){
    	        				temp = true
    	            		}
    	        		}
    	    			fwdListIns.add(temp)
    	        	}
    	    		render(template:"getActRightsLab", model:[fwdListRc:fwdListRc,fwdListClari:fwdListClari,fwdListIns:fwdListIns])
    	    	}else{
    	    		render(template:"blank")
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
    
 def saveActLab = {
    	 try {
    	     if(params.rcRole==null||params.clariRole==null||params.insRole==null){
    	    		flash.message = "At least one Role is necessary for each right"
    	    			redirect(action:actCreateLab)
    	    	}else{
    	    		def groupInstanceVal=GroupMaster.get((params.grp).toLong())
    	    		def roleList = RoleMaster.findAllByGroup(groupInstanceVal)
    	    		if(roleList){
    	    			def roleVsActList = null
    	    			for(int i=0;i<roleList.size();i++){
    	    				roleVsActList = LabRoleVsActivity.findAllByRole(roleList.get(i))
    	    				if(roleVsActList){
    	    				for(int j=0;j<roleVsActList.size();j++){
    	    					roleVsActList.get(j).delete()
    	    				}    			
    	    			}
    	    		}
    	    	}
    	    		if((params.rcRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new LabRoleVsActivity()
    	    			rVaInst.labActivity = LabActivityMaster.findByActivityCode("001")
    	    			rVaInst.role = RoleMaster.get((params.rcRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.rcRole).size();i++){
    	    				def rVaInst = new LabRoleVsActivity()
    	        			rVaInst.labActivity = LabActivityMaster.findByActivityCode("001")
    	        			rVaInst.role = RoleMaster.get((params.rcRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.clariRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new LabRoleVsActivity()
    	    			rVaInst.labActivity = LabActivityMaster.findByActivityCode("002")
    	    			rVaInst.role = RoleMaster.get((params.clariRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.clariRole).size();i++){
    	    				def rVaInst = new LabRoleVsActivity()
    	        			rVaInst.labActivity = LabActivityMaster.findByActivityCode("002")
    	        			rVaInst.role = RoleMaster.get((params.clariRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	if((params.insRole).getClass().getName()== "java.lang.String"){
    	    			def rVaInst = new LabRoleVsActivity()
    	    			rVaInst.labActivity = LabActivityMaster.findByActivityCode("003")
    	    			rVaInst.role = RoleMaster.get((params.insRole).toLong())
    	    			rVaInst.save()
    	    		}else{
    	    			for(int i=0;i<(params.insRole).size();i++){
    	    				def rVaInst = new LabRoleVsActivity()
    	        			rVaInst.labActivity = LabActivityMaster.findByActivityCode("003")
    	        			rVaInst.role = RoleMaster.get((params.insRole[i]).toLong())
    	        			rVaInst.save()
    	    			}
    	    		}
    	    	flash.message = "Activity Rights Saved"
    	    			redirect(action:actCreateLab)
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
    /* ############ For Regular Inspection Activity ############ */

    def actCreateRegularInspection = {}

    def updateActRightsRegularIns = {
        try {
            if (params['cont'] != "") {
                def gpId = (params['cont']).toInteger()
                def grpInst = GroupMaster.get(gpId)

                /***************code by Gajendra for regular inspection*raised and closed*******10/08/2016***************/
                def rolesList = RoleMaster.findAllByGroup(grpInst)
                def regularClarificatioRaised = InspectionRoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("011"))
                ArrayList regularClarificationList = new ArrayList()
                for (int i = 0; i < rolesList.size(); i++) {
                    regularClarificationList.add(rolesList.get(i))
                    def temp = false
                    for (int j = 0; j < regularClarificatioRaised.size(); j++) {
                        if (rolesList.get(i) == regularClarificatioRaised.get(j).role) {
                            temp = true
                        }
                    }
                    regularClarificationList.add(temp)

                }

                def regularInspectionClosed = InspectionRoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("012"))
                ArrayList regularInspectionclosedListApproved = new ArrayList()
                for (int i = 0; i < rolesList.size(); i++) {
                    regularInspectionclosedListApproved.add(rolesList.get(i))
                    def temp = false
                    for (int j = 0; j < regularInspectionClosed.size(); j++) {
                        if (rolesList.get(i) == regularInspectionClosed.get(j).role) {
                            temp = true
                        }
                    }
                    regularInspectionclosedListApproved.add(temp)
                }

                def regularInspectionClosedAfterReject = InspectionRoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("013"))
                ArrayList regularInspectionclosedListReject = new ArrayList()
                for (int i = 0; i < rolesList.size(); i++) {
                    regularInspectionclosedListReject.add(rolesList.get(i))
                    def temp = false
                    for (int j = 0; j < regularInspectionClosedAfterReject.size(); j++) {
                        if (rolesList.get(i) == regularInspectionClosedAfterReject.get(j).role) {
                            temp = true
                        }
                    }
                    regularInspectionclosedListReject.add(temp)
                }

                def regularInspectionPrepareCertificateRevoke = InspectionRoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("017"))
                ArrayList regularInspectionPrepareCertificateRevokeList = new ArrayList()
                for (int i = 0; i < rolesList.size(); i++) {
                    regularInspectionPrepareCertificateRevokeList.add(rolesList.get(i))
                    def temp = false
                    for (int j = 0; j < regularInspectionPrepareCertificateRevoke.size(); j++) {
                        if (rolesList.get(i) == regularInspectionPrepareCertificateRevoke.get(j).role) {
                            temp = true
                        }
                    }
                    regularInspectionPrepareCertificateRevokeList.add(temp)
                }

                /*********** Code Ends here ********/
                render(template: "getActRightsRegularIns", model: [regularClarificationList: regularClarificationList, regularInspectionclosedListApproved: regularInspectionclosedListApproved, regularInspectionclosedListReject: regularInspectionclosedListReject, regularInspectionPrepareCertificateRevokeList: regularInspectionPrepareCertificateRevokeList])
            } else {
                render(template: "blank")
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveActRegularInspection = {
        try {
            if (params.grp == null || params.grp == "") {
                if (GroupMaster.get((params.grp).toLong())) {
                    flash.message = "Please Select Valid grp"
                    redirect(action: actCreate)
                }
            } else if (params.regInspectionClose == null || params.regInspection == null || params.regInspectionCloseReject == null || params.prepareRevokeCertificate == null) {
                flash.message = "At least one Role is necessary for each right"
                redirect(action: actCreate)
            } else {
                def roleList = RoleMaster.findAllByGroup(GroupMaster.get((params.grp).toLong()))
                if (roleList) {

                    def roleVsActList = null
                    for (int i = 0; i < roleList.size(); i++) {
                        roleVsActList = InspectionRoleVsActivity.findAllByRole(roleList.get(i))
                        if (roleVsActList) {
                            for (int j = 0; j < roleVsActList.size(); j++) {
                                roleVsActList.get(j).delete()
                            }
                        }
                    }
                }

                if ((params.regInspection).getClass().getName() == "java.lang.String") {

                    def rVaInst = new InspectionRoleVsActivity()

                    rVaInst.activity = RoleActivityMaster.findByActivityCode("011")
                    rVaInst.role = RoleMaster.get((params.regInspection).toLong())

                    rVaInst.save()

                } else {
                    for (int i = 0; i < (params.regInspection).size(); i++) {
                        def rVaInst = new InspectionRoleVsActivity()
                        rVaInst.activity = RoleActivityMaster.findByActivityCode("011")
                        rVaInst.role = RoleMaster.get((params.regInspection[i]).toLong())
                        rVaInst.save()
                    }
                }

                if ((params.regInspectionClose).getClass().getName() == "java.lang.String") {

                    def rVaInst = new InspectionRoleVsActivity()

                    rVaInst.activity = RoleActivityMaster.findByActivityCode("012")
                    rVaInst.role = RoleMaster.get((params.regInspectionClose).toLong())

                    rVaInst.save()

                } else {
                    for (int i = 0; i < (params.regInspectionClose).size(); i++) {
                        def rVaInst = new InspectionRoleVsActivity()
                        rVaInst.activity = RoleActivityMaster.findByActivityCode("012")
                        rVaInst.role = RoleMaster.get((params.regInspectionClose[i]).toLong())
                        rVaInst.save()
                    }
                }

                if ((params.regInspectionCloseReject).getClass().getName() == "java.lang.String") {

                    def rVaInst = new InspectionRoleVsActivity()

                    rVaInst.activity = RoleActivityMaster.findByActivityCode("013")
                    rVaInst.role = RoleMaster.get((params.regInspectionCloseReject).toLong())

                    rVaInst.save()

                } else {
                    for (int i = 0; i < (params.regInspectionCloseReject).size(); i++) {
                        def rVaInst = new InspectionRoleVsActivity()
                        rVaInst.activity = RoleActivityMaster.findByActivityCode("013")
                        rVaInst.role = RoleMaster.get((params.regInspectionCloseReject[i]).toLong())
                        rVaInst.save()
                    }
                }


                if ((params.prepareRevokeCertificate).getClass().getName() == "java.lang.String") {

                    def rVaInst = new InspectionRoleVsActivity()

                    rVaInst.activity = RoleActivityMaster.findByActivityCode("017")
                    rVaInst.role = RoleMaster.get((params.prepareRevokeCertificate).toLong())

                    rVaInst.save()

                } else {
                    for (int i = 0; i < (params.prepareRevokeCertificate).size(); i++) {
                        def rVaInst = new InspectionRoleVsActivity()
                        rVaInst.activity = RoleActivityMaster.findByActivityCode("017")
                        rVaInst.role = RoleMaster.get((params.prepareRevokeCertificate[i]).toLong())
                        rVaInst.save()
                    }
                }

                flash.message = "Activity Rights Saved"
                redirect(action: actCreateRegularInspection)
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def updateSelectRegularIns = {
        try {
            if (params.selectedValue != "null") {
            	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
		    	def grpList = GroupMaster.findAllByOffice(officeInt)
                render g.select(width: '10', optionKey: 'id', value: '${g}', id: 'grp', name: 'grp', from: grpList, onclick: "${remoteFunction(controller: 'workFlowMaster', action: 'updateActRightsRegularIns', update: 'actRightsRegular', params: '\'cont=\' + this.value')}")
            } else {
                render g.select(width: '10', optionKey: 'id', id: 'grp', name: 'grp')
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    
    
    /* ############ Code Ends Here, For Regular Inspection Activity ########### */
    
    def createManualActivity = {
        try {
               
               
               def aa= "1"
               params.id = aa
               def userType;
               def userId;
               if(session.indUser)
               {
                   userType="Industry";
                   userId = ((session.indUser).toString()).trim();
                   
               }
               else if (session.userMaster)
               {
                   userType="SPCB";
                   userId = ((session.userMaster).toString()).trim();
                   
               }
               def activityRecInstance=new ActivityRecord();
               activityRecInstance.userType=userType;
               activityRecInstance.userID=userId;
               activityRecInstance.ipAddress=request.getRemoteAddr() 
               activityRecInstance.activity = "view"
               activityRecInstance.status = "Work Flow Administration Forward Right Click."
               if(activityRecInstance.save()){        
                 }
                   else{
                       activityRecInstance.errors.each {
                       println it
                   }
               }
               def workFlowMasterInstance = new AutoFlowMaster();
               workFlowMasterInstance.properties = params;
               println("workFlowMasterInstance--------"+workFlowMasterInstance);
               return ['workFlowMasterInstance':workFlowMasterInstance]
           
                   }catch(Exception e) {
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
    
    
    
    
    def saveManualyRight = {
        try {
        	/*println("print-----"+params)
              if(params.roleSize>1){
            	  flash.message = "Please select only one officer";
            	  render(view:'createManualActivity')
            	  return;
              }*/
               if(params['role']!=null && params['role']!=""){
                   def roleInst = RoleMaster.get((params['role']).toInteger())
                   def g = null

                   def workFlowMasterList = AutoFlowMaster.findAllByRole(roleInst)
                   def roleVsActivityList = RoleVsActivity.findAllByRole(roleInst)
                   if(!workFlowMasterList){

                	   def gpId = params['grp'].toInteger()
                       def grpInst = GroupMaster.get(gpId)
                       g=grpInst
                       def roleList = RoleMaster.findAllByGroup(grpInst)
                       def actList = RoleActivityMaster.list()
                       for (int i=0;i<roleList.size();i++){
                           if(params[(roleList.get(i)).roleName] == "on"){
                               
                        	   def workFlowInstance = new AutoFlowMaster()
                               def roleMasterInstance = roleInst
                               def fwdRoleIns = RoleMaster.get(((roleList.get(i)).id).toLong())
                               workFlowInstance.role = roleMasterInstance
                               workFlowInstance.canForwardTo = fwdRoleIns
                               workFlowInstance.group = grpInst
                               if(workFlowInstance.save(flush:true)){

                                   flash.message = "Forwarding Rights Save";
                                   
                                   def userType;
                                   def userId;
                                   if(session.indUser)
                                   {
                                       userType="Industry";
                                       userId = ((session.indUser).toString()).trim();
                                       
                                   }
                                   else if (session.userMaster)
                                   {
                                       userType="SPCB";
                                       userId = ((session.userMaster).toString()).trim();
                                       
                                   }
                                   def activityRecInstance=new ActivityRecord();
                                   activityRecInstance.userType=userType;
                                   activityRecInstance.userID=userId;
                                   activityRecInstance.ipAddress=request.getRemoteAddr() 
                                   activityRecInstance.activity = "add"
                                   activityRecInstance.status = "Forwarding Rights For ${roleMasterInstance.roleName} ${grpInst.groupName} Created or Updated."
                                   if(activityRecInstance.save()){        
                                     }
                                       else{
                                           activityRecInstance.errors.each {
                                           println it
                                       }
                                   }
                               }else
                               {
                            	   workFlowInstance.errors.each {
                                       println it
                                   } 
                               }
                               
                           }
                       }
                       
                   }else{

                       for(int i=0;i<workFlowMasterList.size();i++){
                           try{
                               (workFlowMasterList.get(i)).delete()
                           }catch(Exception e){

                           }
                       }
                       def gpId = params['grp'].toInteger()
                       def grpInst = GroupMaster.get(gpId)
                       g=grpInst
                       def roleList = RoleMaster.findAllByGroup(grpInst)
                       def actList = RoleActivityMaster.list();
                       for (int i=0;i<roleList.size();i++){
                           if(params[(roleList.get(i)).roleName] == "on"){
                               def workFlowInstance = new AutoFlowMaster()
                               def roleMasterInstance = roleInst

                               def fwdRoleIns = RoleMaster.get(((roleList.get(i)).id).toLong())
                               workFlowInstance.role = roleMasterInstance
                               workFlowInstance.canForwardTo = fwdRoleIns
                               workFlowInstance.group = grpInst


                               if(workFlowInstance.save(flush:true)){

                                   flash.message = "Routing Rights Save";
                                   
                                   def userType;
                                   def userId;
                                   if(session.indUser)
                                   {
                                       userType="Industry";
                                       userId = ((session.indUser).toString()).trim();
                                       
                                   }
                                   else if (session.userMaster)
                                   {
                                       userType="SPCB";
                                       userId = ((session.userMaster).toString()).trim();
                                       
                                   }
                                   def activityRecInstance=new ActivityRecord();
                                   activityRecInstance.userType=userType;
                                   activityRecInstance.userID=userId;
                                   activityRecInstance.ipAddress=request.getRemoteAddr() 
                                   activityRecInstance.activity = "add"
                                   activityRecInstance.status = "Forwarding Rights For ${roleMasterInstance.roleName} ${grpInst.groupName} Created or Updated."
                                   if(activityRecInstance.save()){        
                                     }
                                       else{
                                           activityRecInstance.errors.each {
                                           println it
                                       }
                                   }
                               }else
                               {
                            	   workFlowInstance.errors.each {
                                       println it
                                   }
                               }
                               
                           }
                       }
                       
                       
                       
                   }
                   render(view:"createManualActivity",model:[g:g,r:roleInst])
               }else{
                   flash.message = "role not selected"
                       render(view:"createManualActivity")
               }
               
             
           
                   }catch(Exception e) {
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
    
    def updateSelectForAutoWork = {
   	 try {
   		
   	     if(params.selectedValue!="null" && params.selectedValue!=""){
   		    	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
   		    	def grpList = GroupMaster.findAllByOffice(officeInt)
   		    	render g.select( width:'10', optionKey:'id', value:'${g}',  id:'grp',name:'grp', from:grpList,onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateGrpSel234',update:'roleDiv', params:'\'cont=\' + this.value' )}")
   		    	
   			}else{
   				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp')
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
    
    def updateGrpSel234 = {
   	 try {
   		
   	    if(params['cont']!=""){
   		    	def gpId = (params['cont']).toInteger()
   		    	def grpInst = GroupMaster.get(gpId)
   		    	
   		    	def roleList = RoleMaster.findAllByGroup(grpInst)
   		    	def actList = RoleActivityMaster.list()
   		    	render g.select( width:'10', optionKey:'id',  id:'role',name:'role', from:roleList, value:'${r}',onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateRoleSelforAuto',update:'fwdRights', params:'\'cont=\' + this.value' )}")
   		   }else{
   	    		render(template:"blank")
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
    def updateRoleSelforAuto = {
   	 try {
   	    if(params['cont']!=""){
   	    		def role = RoleMaster.get((params['cont']).toInteger())
   	        	def group = (RoleMaster.get((params['cont']).toInteger())).group
   	        	def roleList = RoleMaster.findAllByGroup(group)
   	        	def list = AutoFlowMaster.findAllByRole(role)
   	        	ArrayList fwdRoleList = new ArrayList()
   	        	for(int i=0;i<roleList.size();i++){
   	        		fwdRoleList.add(roleList.get(i))
   	        		def temp = false
   	        		for(int j=0;j<list.size();j++){
   	        			if(roleList.get(i)==list.get(j).canForwardTo){
   	            			temp = true
   	            		}
   	        		}
   	        		fwdRoleList.add(temp)
   	        	}
   	    		render(template:"getFwdRights", model:[fwdRoleList:fwdRoleList])
   	    	}else{
   	    		render(template:"blank")
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
def getRoleNameList={
    	
    	def abc=""
    	
    	return[abc:abc]
    } 
    
    def searchRoleNameList={
    	println("--params-"+params)
    	def groupInstance=GroupMaster.get(params.grp.toLong())
    	def roleMaster
    	if(groupInstance){
    	 roleMaster=RoleMaster.findAll("from RoleMaster r where r.group.id=?",[groupInstance.id])
    	println("-roleMaster--"+roleMaster.size())
    	}
    	def abc=""
    		session.RoleListOfUser=roleMaster
    render(view:'getRoleNameList',model:[abc:roleMaster,roleMaster:roleMaster])
    }
    
    def popRoleUser={

    	try {
    		def roleDetailList=session.RoleListOfUser
    		render(view:'popRoleUser',model:[roleMaster:roleDetailList]) 

    				}catch(Exception e) {
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
    def updateSelectForRoleName = {
    	try {
    		
    	if(params.selectedValue!="null" && params.selectedValue!=""){
	    	def officeInt = OfficeMaster.get((params.selectedValue).toInteger())
	    	def grpList = GroupMaster.findAllByOffice(officeInt)
	    	//def grpList = GroupMaster.findAll("from GroupMaster where office=? and groupDesc!='Industry'",[officeInt])
	    	render g.select( width:'10', optionKey:'id', value:'${g}',  id:'grp',name:'grp', from:grpList,onclick:"${remoteFunction(controller:'workFlowMaster', action:'updateGrpSel2',update:'roleDiv', params:'\'cont=\' + this.value' )}")
	    	
		}else{
			render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp')
		}
    	 }catch(Exception e)
         {
             flash.message="Server is busy ,Please try after some time !"
             e.printStackTrace()
             if(session.indUser)
             {
                 redirect(controller:'indUser',action:'openIndustryHome');
             }
             else if (session.userMaster)
             {
                 redirect(controller:'userMaster',action:'openSpcbHome')
             }
             else
             {
                 session.invalidate()
                 redirect(uri:'/index.gsp')
             }
         }
    }

}
    

