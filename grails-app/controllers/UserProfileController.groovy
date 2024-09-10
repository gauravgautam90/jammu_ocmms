import org.apache.jasper.tagplugins.jstl.core.Param
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import DateCustom;
import TimestampToDate;
class UserProfileController {
    
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
    
def list1 = {
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
    	        def dList=UserProfile.list( params )
    	        for(int p=0;p<dList.size();p++)
    							{
    								def abcFinal=(dList.get(p)).dateCreated
    							DateCustom dd=new DateCustom()
    								def xyz= dd.toDate(abcFinal)
    							(dList.get(p)).dateCreated=xyz
    	   					}
    	        [ userProfileInstanceList: dList, userProfileInstanceTotal: UserProfile.count() ]
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
    	def userProfileInstance1 = new UserProfile()
    	         def userProfileInstance = UserProfile.get( params.id )
    	          def userMasterInstance = UserMaster.get( params.id )
    	        if(!userProfileInstance) {
    	            flash.message = "User not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else 
    	        { return [ userProfileInstance : userProfileInstance,userMasterInstance:userMasterInstance ] }
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

def showForUser = {
    	 try {
    	  def userMasterObj=session.userMaster
    			userMasterObj.refresh() 
    			def userProfileInstance = userMasterObj.userProfile
    	         if(!userProfileInstance) {
    	            flash.message = "User not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else 
    	       { return [ userProfileInstance : userProfileInstance ] }
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
        def userProfileInstance = UserProfile.get( params.id )        def userMasterInstance = UserMaster.get(params.id)
        if(userProfileInstance) {
            try {            	userMasterInstance.delete()
            	userProfileInstance.delete()
                flash.message = "User with Id ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "User with Id ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "UserProfile not found "
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    	 def userProfileInstance = UserProfile.get( params.id )
             def userMasterInstance = UserMaster.get(params.id)
             def startdate = (userMasterInstance.start_date)
             def enddate = (userMasterInstance.end_date)
           def abc11 =  userMasterInstance.type
         	TimestampToDate tmp = new TimestampToDate()
     		def x = tmp.timestampToMonthDayYear(startdate)
     			def y=tmp.timestampToMonthDayYear(enddate)
     		 if(!userProfileInstance) {
                 flash.message = "UserProfile not found "
                 redirect(action:list)
             }
             else {
                 return [ userProfileInstance : userProfileInstance,userMasterInstance:userMasterInstance,x:x,y:y ,abc11:abc11]
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
    	   def startDate1=params.start_date
     		def endDate1=params.end_date
     		def userProfileInstance = UserProfile.get( params.id )
           def userMasterInstance = UserMaster.get( params.id )
             if(userProfileInstance) {
                 if(params.version) {
                     def version = params.version.toLong()
                     if(userProfileInstance.version > version) {
                         userProfileInstance.errors.rejectValue("version", "userProfile.optimistic.locking.failure", "Another user has updated this UserProfile while you were editing.")
                         render(view:'edit',model:[userProfileInstance:userProfileInstance])
                         return
                     }
                 }
                 userProfileInstance.properties = params
                 def sessionOf = session.userMaster
             if(sessionOf.accessLevel=="admin")	{
                 userMasterInstance.type = params.type
                def a =  userMasterInstance.type
                 if(a =="Permanent")
         		{
                 	def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
         			def x = sdfh.parse("01/01/1987");// Date
     				def y = sdfh.parse("01/01/2987");  //Date
     				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
     				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
         			userMasterInstance.start_date= sqlDate
         			userMasterInstance.end_date= sqlDate2
         			userMasterInstance.accessLevel= params.accessLevel
         			userMasterInstance.status= params.status
         			userMasterInstance.hintQuestion= params.hintQuestion
         			userMasterInstance.hintAnswer= params.hintAnswer
         		}
         		else{
         			if((a.equals("Temporary"))||(a.equals("Contractor")))
         			{
         				if((params.start_date=="") || (params.end_date=="")){
         					def date1 =userMasterInstance.start_date
         					userMasterInstance.start_date= date1
         					def date2 = userMasterInstance.end_date
                 			userMasterInstance.end_date= date2
                 			userMasterInstance.accessLevel= params.accessLevel
         	    			userMasterInstance.status= params.status
         	    			userMasterInstance.hintQuestion= params.hintQuestion
         	    			userMasterInstance.hintAnswer= params.hintAnswer
                }
         				else {
         			def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
         			def x = sdfh.parse(startDate1); //Date
     				def y = sdfh.parse(endDate1);  //Date
     				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
     				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
     				userMasterInstance.start_date= sqlDate
         			userMasterInstance.end_date= sqlDate2
         			userMasterInstance.properties = params
         		}
         		}
              }}
             else{
             	if(sessionOf.accessLevel=="employee")	{
             		def a = userMasterInstance.type
             		if(a =="Permanent")
             		{
             			def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
             			def x = sdfh.parse("01/01/1987");// Date
         				def y = sdfh.parse("01/01/2987");  //Date
         				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
         				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
             			userMasterInstance.start_date= sqlDate
             			userMasterInstance.end_date= sqlDate2
             			userMasterInstance.accessLevel= userMasterInstance.accessLevel
              			userMasterInstance.status= userMasterInstance.status
             			userMasterInstance.hintQuestion=params.hintQuestion
             			userMasterInstance.hintAnswer=params.hintAnswer
             		}
             		else{
             			if((a.equals("Temporary"))||(a.equals("Contractor")))
             			{ 
             				def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
                     			def x = sdfh.parse(startDate1); //Date
                 				def y = sdfh.parse(endDate1);  //Date
                 				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
                 				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
                 				userMasterInstance.start_date= sqlDate
                     			userMasterInstance.end_date= sqlDate2
                     			 userMasterInstance.properties = params
             				}
             				}
              }}
                 if(!userProfileInstance.hasErrors() && userProfileInstance.save() && !userMasterInstance.hasErrors() && userMasterInstance.save())  {
                     flash.message = "Profile has been updated"
                     redirect(action:show,id:userProfileInstance.id)
                 }
                 else {
                 	render(view:'edit',model:[userProfileInstance:userProfileInstance])
                 }
             }
             else {
                 flash.message = "UserProfile not found "
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
    	    def userProfileInstance = new UserProfile()
    	        userProfileInstance.properties = params
    	        return ['userProfileInstance':userProfileInstance]
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
    	  def startDate1=params.start_date_value
    			def endDate1=params.end_date_value
    			def userProfileInstance = new UserProfile(params)
    	    		def userMasterInstance = new UserMaster()
    	    	if(params.id!="" ){
    	            userProfileInstance.id = params.id
    	            }
    	            else
    	            {   
    	            	 render(view:'create',model:[userProfileInstance:userProfileInstance])
    	            }
    	    	userProfileInstance.createdBy =session.userMaster
    	        	userProfileInstance.employeeFirstName = params.employeeFirstName
    	        	userProfileInstance.employeeLastName = params.employeeLastName
    	        	if(params.designation_id!=null)
    	        		{
    	        			userProfileInstance.designation=DesignationMaster.get((params.designation_id).toLong())
    	        	}
    	        	 else
    	        	 	{
    	        		    render(view:'create',model:[userProfileInstance:userProfileInstance])
    	        	 	}
    	    	if(params.department_id!=null){
    	        	userProfileInstance.department=DepartmentMaster.get((params.department_id).toLong())
    	    	} 
    	    	else 
    	    	{
    	    		  render(view:'create',model:[userProfileInstance:userProfileInstance])
    	    	}
    	        userProfileInstance.email=params.email
    	        	userProfileInstance.officePhone=params.officePhone
    	        	userProfileInstance.status=params.status
    	        	userProfileInstance.mobile=params.mobile
    	        	userProfileInstance.dateCreated=new Date()
    	        	userProfileInstance.lastUpdated= new Date()
    	        	try{
    	    	  if(!userProfileInstance.hasErrors()) 
    	        	{
    	        		userMasterInstance.id = params.id
    	        			userMasterInstance.hintQuestion = params.hintQuestion
    	        			userMasterInstance.accessLevel= params.accessLevel
    	        			userMasterInstance.createdBy = session.userMaster
    	        			if(params.hintAnswer!=""){
    	        			userMasterInstance.hintAnswer = params.hintAnswer
    	        			}
    	        			else
    	        			{
    	        				flash.message = "please enter hint answer"
    	        					render(view:'create',model:[userProfileInstance:userProfileInstance])
    	        			}
    	        			session.sesvar = params.password
    	        			def pass = session.sesvar
    	        			params.passF=pass
    	        			if((params.password!="d41d8cd98f00b204e9800998ecf8427e")&&(params.passwordEncrypt!= null)&&(params.password!="")&&(params.password!=" ")) {       			
    	        				userMasterInstance.password = params.password
    	        			}
    	        			else
    	        			{
    	        				flash.message = "please click generate for password"
    	        				render(view:'create',model:[userProfileInstance:userProfileInstance,userMasterInstance:userMasterInstance])
    	        			}
    	        			userMasterInstance.status = params.status
    	        			userMasterInstance.dateCreated = new Date()
    	        			userMasterInstance.lastUpdated = new Date()
    	        			userMasterInstance.type = params.type
    	        			userMasterInstance.flag = 0
    	        			def a=userMasterInstance.type
    	        			if(a =="Permanent")
    	        		{
    	        			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    	        			def x = sdfh.parse("01/01/1987");// Date
    	    				def y = sdfh.parse("01/01/2987");  //Date
    	    				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    	    				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    	        			userMasterInstance.start_date= sqlDate
    	        			userMasterInstance.end_date= sqlDate2
    	        		}
    	        		else{
    	        			if((a.equals("Temporary"))||(a.equals("Contractor")))
    	        			{
    	        			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    	        			def x = sdfh.parse(startDate1); //Date
    	    				def y = sdfh.parse(endDate1);  //Date
    	    				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    	    				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    	    				userMasterInstance.start_date= sqlDate
    	        			userMasterInstance.end_date= sqlDate2
    	        		}
    	        		}
    	        			userProfileInstance.save()
    	        			userMasterInstance.userProfile=userProfileInstance
    	        	if(!userMasterInstance.hasErrors() && !userProfileInstance.hasErrors() && userMasterInstance.save() && userProfileInstance.save())
    	        	{ 
    	        		def mailPermit = params.radiobutton
    	        			if(mailPermit.equals('yes'))
    	        			{
    	        				if ((params.email))
    	        					{
    	        						String recept=params.email
    	        						def userName = params.id
    	        						def password = params.password
    	        						def pass1 = params.passwordEncrypt
    	        						SendMail send = new SendMail()
    	        						send.sendMail(recept,userName,pass1)
    	        						flash.message = "Mail has been Sent "
    	        					} 
    	        				else
    	        					{
    	        						flash.message="please enter email-Id" 
    	        					}
    	        		}
    	        			else {
    	        				if (mailPermit.equals('no'))
    	        					{
    	        		           }}
    	        	flash.message = "User is Successfully registered with LoginId : ${userMasterInstance.id} and password : ${params.passwordEncrypt}"
    					redirect(action:show,id:userMasterInstance.id)
    	        	}
    	     	else 
    	    			{
    	    			 render(view:'create',model:[userMasterInstance:userMasterInstance,userProfileInstance:userProfileInstance])
    	    			}
    	      		}
    	        else 
    	  		{
    	  		  render(view:'create',model:[userProfileInstance:userProfileInstance,userMasterInstance:userMasterInstance])
    	  		}
    	        	}
    	        	catch(Exception e)
    				{
    					    flash.message="Employee Id already exist"
    						render(view:'create',model:[userProfileInstance:userProfileInstance])
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
        	     
def myAjax3={
    	 try {
    	 def depF=DepartmentMaster.list()
    	    	def a =params.selectedValue
    	    def dep2 = DepartmentMaster.get(a)
    	    	def designationList = DesignationMaster.findAllByDepartment(dep2)
    	    render g.select( width:'10', optionKey:'id',name:'designation_id', from:designationList)
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
    
def myAjax11={
    	 try {
    	   def depF=DepartmentMaster.list()
    	    	def a =params.selectedValue
    	    	def dep2 = DepartmentMaster.findWhere(depName:a)
    	    	def designationList = DesignationMaster.findAllByDepartment(dep2)
    	     render g.select( width:'10', optionKey:'designation',name:'designation', from:designationList )
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
 
    def userSearch={
    		 try {
    		     def  userIdSearch
        		 def abcFinal
        		 def total
        		 def userIdSearch1
        		 def input1
        		 def input
        		 def user_name
        		 def xyz5
        	   	 def qwe
        	   	def paramList= new ArrayList()
         		paramList=params
        		 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
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
        	  if(params.searchOp=="EmpId"){
        		 input1= params.idsearch
        	   userIdSearch = UserProfile.findAll("from UserProfile as country where country.id= ? ", [input1],[max:xyz5,offset:qwe])
        		userIdSearch1 = UserProfile.findAll("from UserProfile as country where country.id= ? ", [input1])
        		 total=userIdSearch1.size()
        		 if(!userIdSearch){
        			 flash.message="no record found"
        		 }
        	}
        	 else {
        		 if(params.searchOp=="empName"){
        			 if(params.autocomplete_parameter==null || params.autocomplete_parameter=="")
    					{
    						flash.message="Please write the name of SPCB User to Search"
    						redirect(action:userSearch)
    					}
        			 else{
        				 def inputL=(params.autocomplete_parameter).toLowerCase()
     		    		 input1 = inputL + '%' 
        			 userIdSearch = UserProfile.findAll("from UserProfile as country where lower(country.employeeFirstName) like :employeeFirstName", [employeeFirstName:input1],[max:xyz5,offset:qwe]) 
        	    		 userIdSearch1 = UserProfile.findAll("from UserProfile as country where lower(country.employeeFirstName) like :employeeFirstName", [employeeFirstName:input1])  
        		     total=userIdSearch1.size()
        	    		 if(!userIdSearch){
        	      			 flash.message="no record found"
        	      		 }
        	     }}
        	 }
        	if(userIdSearch.getClass().getName()=="java.util.ArrayList"){
        		def dList= userIdSearch.size()
                for(int p=0;p<dList;p++)
    				{if(userIdSearch)
    					 abcFinal=(userIdSearch.get(p)).dateCreated
    					DateCustom dd=new DateCustom()
    					def xyz= dd.toDate(abcFinal)
    				(userIdSearch.get(p)).dateCreated=xyz
    			}
        		}
        		else
        		{ if(userIdSearch){
        			 abcFinal=userIdSearch.dateCreated
        			DateCustom dd=new DateCustom()
    				def xyz= dd.toDate(abcFinal)
    			userIdSearch.dateCreated=xyz
        		}}
        	 render(view:'list',model:[userIdSearch:userIdSearch,total:total,paramList:paramList])
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
      		
 def ajaxAutoComplete1 = {
    		 try {
    		if(params.autocomplete_parameter)
 		    	{
 		    		def inputL=(params.autocomplete_parameter).toLowerCase()
 		    		def input = inputL + '%' 
 		    		def list = UserProfile.findAll("from UserProfile as country where lower(country.employeeFirstName) like :employeeFirstName", [employeeFirstName:input]) 
 		    		StringBuffer idList = new StringBuffer() 
 		    		idList.append("<ul>")
 		    		list?.each{c -> idList.append("<li>" + c.employeeFirstName+"</li>")} 
 		    		idList.append("</ul>")   
 		    		render idList.toString()
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
    
def ajaxAutoComplete2 = {
    		 try {
    		   if(params.idsearch)
    		     {
    		        	def inputL=(params.idsearch).toLowerCase()
    		        	def input = inputL + '%' 
    		            def list = UserProfile.findAll("from UserProfile as country where lower(country.id) like :id", [id:input]) 
    		            StringBuffer idList = new StringBuffer() 
    		        	idList.append("<ul>")
    		        	list?.each{c -> idList.append("<li>" + c.id+"</li>")} 
    		        	idList.append("</ul>")   
    		        	render idList.toString()
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

