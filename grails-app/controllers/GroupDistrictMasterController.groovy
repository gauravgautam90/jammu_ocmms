

class GroupDistrictMasterController {
    
    def index = {
    		 try {
    		     redirect(action:grpDist,params:params) 
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
    def GD= { }
    def del= { }
    def grpDist = {
    		 try {
    			 def finalDistrictList= new ArrayList()
    	    		def officeList= OfficeMaster.list()
    	    		
    	    		def districtList= DistrictMaster.list()
    	    		for(int var1=0;var1<districtList.size();var1++)
    	    		{
    	    		}
    	    		render(view:'create',model:[finalDistrictList:finalDistrictList])
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ groupDistrictMasterInstanceList: GroupDistrictMaster.list( params ), groupDistrictMasterInstanceTotal: GroupDistrictMaster.count() ]
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
    		 def groupDistrictMasterInstance = GroupDistrictMaster.get( params.id )

    	        if(!groupDistrictMasterInstance) {
    	            flash.message = "GroupDistrictMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else { return [ groupDistrictMasterInstance : groupDistrictMasterInstance ] }
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
    		 if(params.districtid==null ||params.districtid=='xyz1')
    	    	{
    	    		flash.message="Please Select The District To Remove"
    	    		redirect(action:del)
    	    	}
    	    	else
    	    	{
    	    		def delList=params.districtid
    	    		if(delList.getClass().getName()=="java.lang.String")
    	    		{
    	        def groupDistrictMasterInstance = GroupDistrictMaster.get(delList )
    	        if(groupDistrictMasterInstance) {
    	            try {
    	                groupDistrictMasterInstance.delete()
    	                flash.message = "District Removed Successfully"
    	                redirect(action:del)
    	            }
    	            catch(org.springframework.dao.DataIntegrityViolationException e) {
    	                flash.message = "GroupDistrictMaster ${params.id} could not be deleted"
    	                redirect(action:del,id:params.id)
    	            }
    	        }
    	        else {
    	            flash.message = "GroupDistrictMaster not found with id ${params.id}"
    	            redirect(action:del)
    	        }
    	    		}
    	    		else
    	    		{
    	    			int var4=0
    	    			for(int var3=0;var3<delList.size();var3++)
    	    			{
    	    				def groupDistrictMasterInstance = GroupDistrictMaster.get(delList[var3] )
    	    		        if(groupDistrictMasterInstance) {
    	    		            try {
    	    		                groupDistrictMasterInstance.delete()
    	    		                flash.message = "GroupDistrictMaster ${params.id} deleted"
    	    		                var4++
    	    		            }
    	    		            catch(org.springframework.dao.DataIntegrityViolationException e) {
    	    		                flash.message = "GroupDistrictMaster ${params.id} could not be deleted"
    	    		                redirect(action:del,id:params.id)
    	    		            }
    	    		        }
    	    		        else {
    	    		            flash.message = "GroupDistrictMaster not found with id ${params.id}"
    	    		            redirect(action:del)
    	    		        }
    	    			}
    	    		if(var4==delList.size())
    	    			{
    	    			flash.message = "District Removed Successfully"
    	    			redirect(action:del)
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
    	        def groupDistrictMasterInstance = GroupDistrictMaster.get( params.id )
    	        if(!groupDistrictMasterInstance) {
    	            flash.message = "GroupDistrictMaster not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else {
    	            return [ groupDistrictMasterInstance : groupDistrictMasterInstance ]
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
    	        def groupDistrictMasterInstance = GroupDistrictMaster.get( params.id )
    	        if(groupDistrictMasterInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(groupDistrictMasterInstance.version > version) {
    	                    
    	                    groupDistrictMasterInstance.errors.rejectValue("version", "groupDistrictMaster.optimistic.locking.failure", "Another user has updated this GroupDistrictMaster while you were editing.")
    	                    render(view:'edit',model:[groupDistrictMasterInstance:groupDistrictMasterInstance])
    	                    return
    	                }
    	            }
    	            groupDistrictMasterInstance.properties = params
    	            if(!groupDistrictMasterInstance.hasErrors() && groupDistrictMasterInstance.save()) {
    	                flash.message = "GroupDistrictMaster ${params.id} updated"
    	                redirect(action:show,id:groupDistrictMasterInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[groupDistrictMasterInstance:groupDistrictMasterInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "GroupDistrictMaster not found with id ${params.id}"
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
    	        def groupDistrictMasterInstance = new GroupDistrictMaster()
    	        groupDistrictMasterInstance.properties = params
    	        return ['groupDistrictMasterInstance':groupDistrictMasterInstance]
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
    	    def check1=params.group_id
     		def xyz
     		if(check1==null || check1=='xyz1')
     			{
     				flash.message="Please Select The Group To Which District Will Be Attached"
     				redirect(action:grpDist)
     			}else{if(params.district_id==null ||params.district_id=='xyz1')
     			{
     				flash.message="Please Select The District To Attach"
     				redirect(action:grpDist)
     			}
     		else
     			{
     				xyz=params.district_id
     		def grp=GroupMaster.get((params.group_id).toLong())
     		
     		def districtData
     	if(xyz.getClass().getName()== "java.lang.String")
     	    	{
     	    	 districtData=DistrictMaster.get((params.district_id).toLong())
     	    		def groupDistrictMasterInstance = new GroupDistrictMaster()
     	    		groupDistrictMasterInstance.group=grp
     	    		groupDistrictMasterInstance.district=districtData
     	    		if(!groupDistrictMasterInstance.hasErrors() && groupDistrictMasterInstance.save())
     	    			{
     	    				flash.message = "District Attached To Group"
     	    				redirect(action:grpDist)
     	    			}
     	    		else 
     	    			{
     	    				
     	    				render(view:'create',model:[groupDistrictMasterInstance:groupDistrictMasterInstance])
     	    			}
     	    	}
     	    else
     	    	{
     	    		int check=0
     	    		for(int i=0;i<xyz.size();i++)
     	    			{
     	    				def groupDistrictMasterInstance = new GroupDistrictMaster()
     	    				def districtMaster=DistrictMaster.get(xyz[i].toLong())
     	    				groupDistrictMasterInstance.district=districtMaster
     	    				groupDistrictMasterInstance.group=grp
     	    				if(!groupDistrictMasterInstance.hasErrors() && groupDistrictMasterInstance.save())
     	    					{
     	    						check++
     	    					}
     	    				else 
     	    					{
     	    						render(view:'create',model:[groupDistrictMasterInstance:groupDistrictMasterInstance])
     	    					}
     	    			}
            if(check==xyz.size())
     	    			{
     	    				flash.message = "Districts Attached To Group Successfully"	
     	    				redirect(action:grpDist)
     	    			}
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
    
    def updateSelect1 = {
    	 try {
    	    	def finalDistrictList= new ArrayList()
    	    	if(params['cont1']=='xyz')
    	    	{
    	    		def roleList= new ArrayList()
    	    		render (template:"officeDistrict", model : ['roleList' : roleList,'finalDistrictList':finalDistrictList])
    	    	}
    	    	else{
    	    	def officeMasterInstance = OfficeMaster.get((params['cont1']).toInteger())
    	    	def roleList = GroupMaster.findAllByOffice(officeMasterInstance)
    	    	def officeId=officeMasterInstance.id
    	    		
    	    		def districtList= DistrictMaster.list()
    	    		for(int var1=0;var1<districtList.size();var1++)
    	    		{
    	    			def checkedVAR=districtList.get(var1)
    	    			def testResult=GroupDistrictMaster.findAll("From GroupDistrictMaster gdm where gdm.district= ? and gdm.group.office.id = ?",  [checkedVAR,officeId]);// district:districtList.get(var1),group.office:officeMasterInstance)
    	    			
    	    			if(testResult)
    	    			{
    	    			}
    	    			else
    	    			{
    	    				finalDistrictList.add(districtList.get(var1))
    	    			}
    	    		}
    	    	render (template:"officeDistrict", model : ['roleList' : roleList,'finalDistrictList':finalDistrictList])
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
    	    	if(params.selectedValue=='xyz1')
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
 
  def updateSelect = {
    	 try {
    	    	def finalListToRemove= new ArrayList()
    	    	if(params['cont']==null || params['cont']=='xyz1' )
    	    	{
    	    		def roleList= new ArrayList()
    	    		render g.select( width:'10',from:finalListToRemove,optionKey:'id',  id:'districtid',name:'districtid')
    	    	}
    			else
    			{
    					def groupId = GroupMaster.get(params['cont'].toInteger())
    					def roleList = GroupDistrictMaster.findAllByGroup(groupId)
    					for(int var=0;var<roleList.size();var++)
    						{
    							finalListToRemove.add(roleList[var])
    						}
    					render g.select( width:'10',from:finalListToRemove,optionKey:'id',multiple:'multiple' ,size:'5',name:'districtid')
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
    
    def updateSelectSHOW = {
    	 try {
    	    def distStr=""
         	def finalListToRemove= new ArrayList()
         	if(params['cont']==null)
         	{
         		def roleList= new ArrayList()
         		render (template:"levelDistrict", model : ['distStr' : distStr])
         	}
     		else
     		{
     	def groupId = GroupMaster.get(params['cont'].toInteger())
     	def roleList = GroupDistrictMaster.findAllByGroup(groupId)
     	def deli
     		for(int var=0;var<roleList.size();var++)
     		{
     			finalListToRemove.add(roleList[var])
     			deli = distStr == ""? (deli = ""): (deli = ", ");
     			distStr=distStr+ deli +roleList[var].district.districtName
    			 deli = ",";
     		}
     	render (template:"levelDistrict", model : ['distStr' : distStr])
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
