
class RoleMasterController {
    
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

 def gotoCreate = {
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
   
def del = {
    		 try {
    			  redirect(action:deleteRoleManagement,params:params) 
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
    
def delRes = {  }

def UP = {
    		 try {
    			 redirect(action:updateRoleManagement,params:params) 
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
    
def deleteRoleManagement={}
    
def pop1={
    		 try {
    			 ArrayList myArrayList2 = new ArrayList()
    	    		def empList=UserProfile.list()
    	    		for(int q=0;q<empList.size();q++)
    	    			{
    	    			if((empList.get(q)).status=="active")
    	    					{
    	    					myArrayList2.add((empList.get(q)))
    	    					}
    			}
    	    		 return[myArrayList2:myArrayList2]
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
    
def updateRoleManagement={}
    
 static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ roleMasterInstanceList: RoleMaster.list( params ), roleMasterInstanceTotal: RoleMaster.count() ]
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
    		 def roleMasterInstance = RoleMaster.get(params.id)
    	        def roleProfileAssignmentInstance=RoleProfileAssignment.findByRole(roleMasterInstance)
    	         if(!roleMasterInstance) {
    	            flash.message = "Role not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ roleMasterInstance : roleMasterInstance ,roleProfileAssignmentInstance:roleProfileAssignmentInstance] }
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
    	 try {
    		 if(params.grp == null || params.grp == "")
        	 	{
        		 	flash.message = "Please Select The Role to be Deleted"
        		 	redirect(action:updateRoleManagement)
        	 	}else{ 	
        	 		def roleMasterInstance = RoleMaster.get((params.grp).toLong())
        	 		println("roleMasterInstance ---"+roleMasterInstance.id)
        	 		if(ApplicationPendingDetails.findByRole(roleMasterInstance))
        	 			{
        	 				flash.message = "Applications Pending with this Role hence role can not be deleted"
        	 				redirect(action:delRes)
    		    	 			}else{
    		    	 				def roleProfileAssignmentInstance1 = RoleProfileAssignment.findByRole(roleMasterInstance)
    				    				 	def workFlowMasterInstance1 =WorkFlowMaster.findAllByRole(roleMasterInstance)
    				    	        		if(workFlowMasterInstance1.size()>0)
    				    	        		 {
    				    	        			 for(int var=0;var<workFlowMasterInstance1.size();var++)
    				    	        			 	{
    				    	        				 	try
    				    	        				 		{
    				    	        				 			workFlowMasterInstance1.get(var).delete()
    				    	        				 		}
    				    	        				 	catch(Exception e)
    				    	        				 		{
    				    	        				 		}
    				    	        			 	}
    				    	        		 } 
    				    				 	def workFlowMasterInstance =WorkFlowMaster.findAllByCanForwardTo(roleMasterInstance)
    				    				 	if(workFlowMasterInstance.size()>0)
    				    				 		{
    				    				 			for(int var=0;var<workFlowMasterInstance.size();var++)
    				    				 				{
    				    				 					try
    				    				 						{
    				    				 							workFlowMasterInstance.get(var).delete()
    				    				 						}
    				    				 					catch(Exception e)
    				    				 						{
    				    				 						}
    				    				 				}
    				    				 		} 
    				    				 	def roleVsActivityInstance =RoleVsActivity.findAllByRole(roleMasterInstance)
    				    				 	if(roleVsActivityInstance)
    				    				 		{
    				    				 		for(int var=0;var<roleVsActivityInstance.size();var++)
    				    				 				{
    				    				 					roleVsActivityInstance.get(var).delete()
    				    				 				}
    				    				 		}
    				    				 	def consentApplicationApprovalInstance =ConsentApplicationApprovalCriteria.findAllByRole(roleMasterInstance)
    				    				 	if(consentApplicationApprovalInstance)
    				    				 		{
    				    				 		for(int var=0;var<consentApplicationApprovalInstance.size();var++)
    				    				 				{
    			    				 				consentApplicationApprovalInstance.get(var).delete()
    				    				 				}
    				    				 		}
    				    				 	if(roleMasterInstance)
    				    				 		{
    				    				 			try 
    				    				 				{
    				    				 					if(roleProfileAssignmentInstance1)
    				    				 						{
    				    				 							roleProfileAssignmentInstance1.delete()
    				    				 						}
    				    				 					roleMasterInstance.delete()
    				    				 					flash.message = "Role ${roleMasterInstance} deleted"
    				    				 					redirect(action:delRes)
    				    				 				}
    				    				 			catch(org.springframework.dao.DataIntegrityViolationException e)
    				    				 				{
    				    				 					flash.message = "Role ${roleMasterInstance} could not be deleted"
    				    				 					redirect(action:updateRoleManagement)
    				    				 				}
    				    				 		}
    				    				 	else 
    				    				 		{
    				    				 			flash.message = "Role not found with id ${params.id}"
    				    				 			redirect(action:updateRoleManagement)
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
			 	
def edit = {
    		 try {
    			 ArrayList myArrayList2 = new ArrayList()
    	    		def empList=UserProfile.list()
    	    		for(int q=0;q<empList.size();q++)
    	    		{
    	    			if((empList.get(q)).status=="active")
    	    			{
    	    				myArrayList2.add((empList.get(q)))
    	    			}
    	    		}
    			   if(params.grp == null || params.grp == "")
    			   {
    				   flash.message = "Please Select The Role to be Updated"
    					   redirect(action:updateRoleManagement)
    			   }
    			   else
    			   {
    			def roleMasterInstance = RoleMaster.get( (params.grp).toLong())
    			def roleProfileAssignmentInstance=RoleProfileAssignment.findByRole(roleMasterInstance)
    			 if(!roleMasterInstance) {
    	            flash.message = "Role not found with id ${params.id}"
    	            redirect(action:updateRoleManagement)
    	        }
    	        else {
    	            return [ myArrayList2:myArrayList2,roleMasterInstance : roleMasterInstance ,roleProfileAssignmentInstance:roleProfileAssignmentInstance]
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
   
 def update = {
    		 try {
    			 ArrayList myArrayList2 = new ArrayList()
    	    		def empList=UserProfile.list()
    	    		for(int q=0;q<empList.size();q++)
    	    		{
    	    			if((empList.get(q)).status=="active")
    	    			{
    	    				myArrayList2.add((empList.get(q)))
    	    			}
    	    		}
    			def roleMasterInstance = RoleMaster.get(params.id )
    	   if(roleMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(roleMasterInstance.version > version) {
    	                    roleMasterInstance.errors.rejectValue("version", "roleMaster.optimistic.locking.failure", "Another user has updated this Role while you were editing.")
    	                    render(view:'edit',model:[roleMasterInstance:roleMasterInstance,myArrayList2:myArrayList2])
    	                    return
    	                }
    	            }
    	            roleMasterInstance.properties = params
    	            roleMasterInstance.updatedBy=session.userMaster
    	            if(!roleMasterInstance.hasErrors() && roleMasterInstance.save()) {
    	                flash.message = "Role ${RoleMaster.get(params.id)} updated"
    	                 def roleProfileAssignmentInstance = RoleProfileAssignment.get( params.profid )
    	                	 if(roleProfileAssignmentInstance) {
    	                         if(params.profversion) {
    	                             def version = params.profversion.toLong()
    	                             if(roleProfileAssignmentInstance.version > version) {
    	                                 roleProfileAssignmentInstance.errors.rejectValue("version", "roleProfileAssignment.optimistic.locking.failure", "Another user has updated this RoleProfileAssignment while you were editing.")
    	                                 render(view:'edit',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance,myArrayList2:myArrayList2])
    	                                 return
    	                             }
    	                         }
    	                         roleProfileAssignmentInstance.properties = params
    	                  if(!roleProfileAssignmentInstance.hasErrors() && roleProfileAssignmentInstance.save()) {
    	                          }
    	                         else {
    	                             render(view:'edit',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance,myArrayList2:myArrayList2])
    	                         }
    	                     }
    	                     else {
    	                         flash.message = "RoleProfileAssignment not found with id ${params.id}"
    	                         redirect(action:edit)
    	                     }
    	                redirect(action:show,id:roleMasterInstance.id,id1:roleProfileAssignmentInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[roleMasterInstance:roleMasterInstance,myArrayList2:myArrayList2])
    	            }
    	        }
    	        else {
    	            flash.message = "Role not found with id ${params.id}"
    	            redirect(action:edit,id:params.grp)
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
    			 ArrayList myArrayList2 = new ArrayList()
    	    		def empList=UserProfile.list(sort:"employeeFirstName", order:"asc")
    	    		for(int q=0;q<empList.size();q++)
    	    		{
    	    			if((empList.get(q)).status=="active")
    	    			{
    	    				myArrayList2.add((empList.get(q)))
    	    			}
    	    		}
    	    	def roleMasterInstance = new RoleMaster()
    	        roleMasterInstance.properties = params
    	        return ['roleMasterInstance':roleMasterInstance,myArrayList2:myArrayList2]
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

 def save =
	{
    	 try {
    		 ArrayList myArrayList2 = new ArrayList()
    	 		def empList=UserProfile.list()
    	 		for(int q=0;q<empList.size();q++)
    	 		{
    	 			if((empList.get(q)).status=="active")
    	 			{
    	 				myArrayList2.add((empList.get(q)))
    	 			}
    	 		}
    			 	def roleMasterInstance = new RoleMaster(params)
    				if(roleMasterInstance.group ==null )
    				{
    					flash.message="Group Should Be Selected"
    					redirect(action:create)
    				}
    				roleMasterInstance.createdBy =session.userMaster
    	        	roleMasterInstance.updatedBy =session.userMaster
    				if(!roleMasterInstance.hasErrors() && roleMasterInstance.save())
    					{
    						def roleProfileAssignmentInstance = new RoleProfileAssignment(params)
    						
    								roleProfileAssignmentInstance.role = roleMasterInstance
    							
    								if(!roleProfileAssignmentInstance.hasErrors() && roleProfileAssignmentInstance.save())
    									{
    										flash.message = "RoleProfileAssignment ${roleProfileAssignmentInstance.id} created"
    									}
    								else 
    									{
    										render(view:'create',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance,myArrayList2:myArrayList2])
    									}
    									flash.message = "Role ${roleMasterInstance} created"
    							 redirect(action:show,id1:roleProfileAssignmentInstance.id,id:roleMasterInstance.id)
    					}
    				else 	
    					{
    								render(view:'create',model:[roleMasterInstance:roleMasterInstance,myArrayList2:myArrayList2])
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

 def updateSelect1 = {
    		 try {
    			 if(params.selectedValue=='xyz')
    		    	{
    		    		def roleList= new ArrayList()
    		    		render g.select( width:'10',from:roleList,optionKey:'id', id:'group.id',name:'group.id')
    		    	}
    		    	else{
    		    	def groupId = OfficeMaster.get((params.selectedValue).toInteger())
    		    	def roleList = GroupMaster.findAllByOffice(groupId)
    		    	render g.select( width:'10',from:roleList,optionKey:'id',  id:'group.id',name:'group.id')
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
    			 if(params.selectedValue=='xyz')
    		    	{
    		    		def roleList1= new ArrayList()
    		    		render (template:"selectgroup", model : ['roleList1' : roleList1])
    		    	}
    		    	else{
    		    	def groupId = OfficeMaster.get((params.selectedValue).toInteger())
    		    	def roleList1 = GroupMaster.findAllByOffice(groupId)
    		    	render (template:"selectgroup", model : ['roleList1' : roleList1])
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
    			 if(params['cont']!="xyz" && params['cont']!=""){
    			    		def gpId = (params['cont']).toInteger()
    				    	def grpInst = GroupMaster.get(gpId)
    				    	def roleList = RoleMaster.findAllByGroup(grpInst)
    				    	render g.select( width:'10',from:roleList,optionKey:'id',  id:'grp',name:'grp')
    				   }else{
    			    		
    			    		def roleList= new ArrayList()
    		        		render g.select( width:'10',from:roleList,optionKey:'id',  id:'grp',name:'grp')
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

def updateSelect = {
    		 try {
    			 if(params.selectedValue=='xyz')
    	        	{
    	        		def roleList= new ArrayList()
    	        		render g.select( width:'10',from:roleList,optionKey:'id',  id:'grp',name:'grp')
    	        	}
    	    		else
    	    		{
    	    	def groupId = GroupMaster.get((params.selectedValue).toInteger())
    	    	def roleList = RoleMaster.findAllByGroup(groupId)
    	    	render g.select( width:'10',from:roleList,optionKey:'id',  id:'grp',name:'grp')
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

  def updateSelectRoleProfile = {
    		 try {
    			 if(params.selectedValue=='xyz')
    	        	{
    	        		def roleList= new ArrayList()
    	        		render g.select( width:'10',from:roleList,optionKey:'id',  id:'grp',name:'grp')
    	        	}
    	    		else
    	    		{
    	    		ArrayList myArrayList = new ArrayList()
    	    		def groupId = GroupMaster.get((params.selectedValue).toInteger())
    	        	def roleList = RoleMaster.findAllByGroup(groupId)
    	        	for(int i=0;i<roleList.size();i++)
    	        	{
    	        	def var=roleList.get(i)
    	           def roleListAssign = RoleProfileAssignment.findByRole(var)
    	        	if(roleListAssign)
    	        	{
    	        		myArrayList.add(roleListAssign)
    	        	}
    	            }
    	        	for(int i=0;i<myArrayList.size();i++)
    	        	{
    	        	}
    	        	render g.select( width:'10',from:myArrayList,optionKey:'id',  id:'grp',name:'grp')
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
   
 def popsave = 
 {
    try {
    		ArrayList myArrayList2 = new ArrayList()
    	 		def empList=UserProfile.list()
    	 		for(int q=0;q<empList.size();q++)
    	 		{
    	 			if((empList.get(q)).status=="active")
    	 			{
    	 				myArrayList2.add((empList.get(q)))
    	 			}
    	 		}
    				def roleMasterInstance = new RoleMaster(params)
    				def userIns = /*(User)*/session.user
    				roleMasterInstance.createdBy =session.userMaster
    	        	roleMasterInstance.updatedBy =session.userMaster
    				if(!roleMasterInstance.hasErrors() && roleMasterInstance.save())
    					{
    						def roleProfileAssignmentInstance = new RoleProfileAssignment(params)
    						roleProfileAssignmentInstance.role = roleMasterInstance
    								if(!roleProfileAssignmentInstance.hasErrors() && roleProfileAssignmentInstance.save())
    									{
    										flash.message = "RoleProfileAssignment ${roleProfileAssignmentInstance.id} created"
    									}
    								else 
    									{
    										render(view:'create',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance,myArrayList2:myArrayList2])
    									}
    									flash.message = "Role ${roleMasterInstance} created"
    										 redirect(uri:"/roleMaster/showpop.gsp")
    					}
    				else 	
    					{
    					flash.message = "Role cannot be created.......invalid fields"
    						 redirect(uri:"/roleMaster/showpop.gsp")
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
def updateGrpSel11 = {
		println("params in updateGrpSel11"+params)
		def fwdRoleList = new ArrayList()
		def aa = session.userMaster
		    	System.out.println("aa"+aa)
	    	if(params['cont']!="xyz" && params['cont']!=""){
	    		
	    		def roleProfile = RoleProfileAssignment.findAll("from RoleProfileAssignment where primaryEmployee.id=?",[aa.id])
	    	println("roleProfile----"+roleProfile.role.group.groupName)
	  for(int k=0; k<roleProfile.size(); k++){
	    	if(roleProfile[k].role.group.groupName==params.cont)
	    	{
	    		println("roleProfile same----")	
	    		println("roleProfile ----"+roleProfile[k].role)	
	    		
	    		def workFlowMasterList = WorkFlowMaster.findAllByRole(roleProfile[k].role)
	    		for(int i=0;i<workFlowMasterList.size();i++){ 
	    			fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
	    		}
	    	}	
	  }
	    		render g.select( width:'10',from:fwdRoleList,optionKey:'id',  name:'forward')
	    	}
	    }   
}
