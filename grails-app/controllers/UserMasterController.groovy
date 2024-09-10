import sun.misc.Request
import java.lang.System
import javax.servlet.http.Cookie
import org.postgresql.util.MD5Digest
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.postgresql.core.Encoding
import java.lang.Math
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;
import java.security.MessageDigest;
import grails.converters.JSON

class UserMasterController {

boolean compareDate(Date d1,Date d2)
	   {
		   if(d1.getYear()==d2.getYear())
		   {
			   if(d1.getMonth()==d2.getMonth())
			   {
				   if(d1.getDay()==d2.getDay())
				   {
					   if(d1.getHours()==d2.getHours())
					   {
						   if((d1.getMinutes()-d2.getMinutes())<=15)
						   {
							   return true;
							   
						   }
						   else
						   {
							   return false;
						   }
					   }
					   else
					   {
						   return false;
					   }
				 }
				   else
				   {
					   return false;
				   }
			   }
			   else
			   {
				   return false;
			   }
		   }
		   else
		   {
			   return false;
		   }
		 }
	boolean PasswordCheck(String password1,String password2,String password3,String password4,String password5,String newPass)
	   {
		   if(password1==newPass)
		   {
			   return true;
		   }
		   else if(password2==newPass )
		   {
			   return true;
		   }
		   else if(password3==newPass )
		   {
			   return true;
		   }
		   else if(password4==newPass )
		   {
			   return true;
		   }
		   else if(password5==newPass )
		   {
			   return true;
		   }
		   else 
		   {
			   return false;
		   }
	   }
	   String GenerateRandomCode()
	    {
		   Random rand=new Random();
	        String s ="";
	        for (int i = 0; i < 6; i++)
	         s=s+rand.nextInt(10).toString();
	        return s;
	    }
	 String MD5_Encryption(String db_Password, String Salt)
	    {
		   String netJava=db_Password+Salt;
		   String result = null;
		   MessageDigest md5 = MessageDigest.getInstance("MD5");
		   byte[] digest = md5.digest(netJava.getBytes());
	      StringBuffer hexString = new StringBuffer(); 
	       for (int i=0;i<digest.length;i++) 
	       {
	    	 if((0xFF & digest[i])>0x0F)
	    	 {
	    		  hexString.append(Integer.toHexString(0xFF & digest[i]));  
	    	  }
	    	  else
	    	  {
	    		  switch(0xFF & digest[i])
	    		  {
	    		  case 0x00:
	    			  hexString.append('00');  
	    			  break;
	    		  case 0x01:
	    			  hexString.append('01');  
	    			  break;
	    		  case 0x02:
	    			  hexString.append('02');  
	    			  break;
	    		  case 0x03:
	    			  hexString.append('03');
	    			  break;
	    		  case 0x04:
	    			  hexString.append('04');
	    			  break;
	    		  case 0x05:
	    			  hexString.append('05');
	    			  break;
	    		  case 0x06:
	    			  hexString.append('06');
	    			  break;
	    		  case 0x07:
	    			  hexString.append('07');
	    			  break;
	    		  case 0x08:
	    			  hexString.append('08');
	    			  break;
	    		  case 0x09:
	    			  hexString.append('09');
	    			  break;
	    		  case 0x0A:
	    			  hexString.append('0a');
	    			  break;
	    		  case 0x0B:
	    			  hexString.append('0b');
	    			  break;
	    		  case 0x0C:
	        	      hexString.append('0c');
	        	      break;
	        	  case 0x0D:
	                  hexString.append('0d');
	                  break;
	              case 0x0E:
	              	  hexString.append('0e');
	              	break;
	              case 0x0F:
	       			  hexString.append('0f');
	    		  }
	    	  }
	    	}
	       return hexString;
	    }
	  String MD5_Encryption1(String db_Password)
	  {
		   String netJava=db_Password;
		   String result = null;
 MessageDigest md5 = MessageDigest.getInstance("MD5");
		 byte[] digest = md5.digest(netJava.getBytes());
	     StringBuffer hexString = new StringBuffer(); 
	     for (int i=0;i<digest.length;i++) 
	     {
	  	  if((0xFF & digest[i])>0x0F)
	  	 {
	  		  hexString.append(Integer.toHexString(0xFF & digest[i]));  
	  	  }
	  	  else
	  	  {
	  		  switch(0xFF & digest[i])
	  		  {
	  		  case 0x00:
	  			  hexString.append('00');  
	  			  break;
	  		  case 0x01:
	  			  hexString.append('01');  
	  			  break;
	  		  case 0x02:
	  			  hexString.append('02');  
	  			  break;
	  		  case 0x03:
	  			  hexString.append('03');
	  			  break;
	  		  case 0x04:
	  			  hexString.append('04');
	  			  break;
	  		  case 0x05:
	  			  hexString.append('05');
	  			  break;
	  		  case 0x06:
	  			  hexString.append('06');
	  			  break;
	  		  case 0x07:
	  			  hexString.append('07');
	  			  break;
	  		  case 0x08:
	  			  hexString.append('08');
	  			  break;
	  		  case 0x09:
	  			  hexString.append('09');
	  			  break;
	  		  case 0x0A:
	  			  hexString.append('0a');
	  			  break;
	  		  case 0x0B:
	  			  hexString.append('0b');
	  			  break;
	  		  case 0x0C:
	      	      hexString.append('0c');
	      	      break;
	      	  case 0x0D:
	                hexString.append('0d');
	                break;
	            case 0x0E:
	            	  hexString.append('0e');
	            	break;
	            case 0x0F:
	     			  hexString.append('0f');
	  		  }
	  	  }
	  	 }
	     return hexString;
	  }
		
def cookieService
		def userLogin = {
			  try {
				Random rand=new Random();
					def tunt=rand.nextInt(100)+99;
					def capCode=GenerateRandomCode()
					session.tunt=tunt.toString()
					session.capCode=capCode
					render(view:'userLogin',model:[tunt1:tunt,capCode1:capCode])
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
	  
def ajaxCaptcha = {}
	  
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
		        [ userMasterInstanceList: UserMaster.list( params ), userMasterInstanceTotal: UserMaster.count() ]
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
		   def userMasterInstance = UserMaster.get( params.id )
		        if(!userMasterInstance) {
		            flash.message = "UserMaster not found with id ${params.id}"
		            redirect(action:list)
		        }
		        else { return [ userMasterInstance : userMasterInstance ] }
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
        def userMasterInstance = UserMaster.get( params.id )
        if(userMasterInstance) {
            try {
                userMasterInstance.delete()
                flash.message = "UserMaster ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "UserMaster ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "UserMaster not found with id ${params.id}"
            redirect(action:list)
        }
    }

 def edit = {
		  try {
		    def userMasterInstance = UserMaster.get( params.id )
		        if(!userMasterInstance) {
		            flash.message = "UserMaster not found with id ${params.id}"
		            redirect(action:list)
		        }
		        else {
		            return [ userMasterInstance : userMasterInstance ]
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
		      def userMasterInstance = UserMaster.get( params.id )
		        if(userMasterInstance) {
		            if(params.version) {
		                def version = params.version.toLong()
		                if(userMasterInstance.version > version) {
		                    
		                    userMasterInstance.errors.rejectValue("version", "userMaster.optimistic.locking.failure", "Another user has updated this UserMaster while you were editing.")
		                    render(view:'edit',model:[userMasterInstance:userMasterInstance])
		                    return
		                }
		            }
		            userMasterInstance.properties = params
		            if(!userMasterInstance.hasErrors() && userMasterInstance.save()) {
		                flash.message = "UserMaster ${params.id} updated"
		                redirect(action:show,id:userMasterInstance.id)
		            }
		            else {
		                render(view:'edit',model:[userMasterInstance:userMasterInstance])
		            }
		        }
		        else {
		            flash.message = "UserMaster not found with id ${params.id}"
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
		      def userMasterInstance = new UserMaster()
		        userMasterInstance.properties = params
		        return ['userMasterInstance':userMasterInstance]
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
		     def userMasterInstance = new UserMaster(params)
		        if(!userMasterInstance.hasErrors() && userMasterInstance.save()) {
		            flash.message = "UserMaster ${userMasterInstance.id} created"
		            redirect(action:show,id:userMasterInstance.id)
		        }
		        else {
		            render(view:'create',model:[userMasterInstance:userMasterInstance])
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

 def doLogin = {
		  try {
		     def myAuditInstance=new MyAudit()
				myAuditInstance.properties = params
				String cc=params['captchaCode']
				 if(session.capCode==null)
		      	{    
		          	flash.message="Your session has been expired ! Please login again."
		      	}
				if(session.capCode!=cc)
			{   
					myAuditInstance.userType=params['radioButton']
				    myAuditInstance.userID=params['userId']
				    myAuditInstance.ipAddress=request.getRemoteAddr() 
				    myAuditInstance.loginDate=new Date()
				    myAuditInstance.loginStatus='Un-Successfull'
				    myAuditInstance.reason="In-Correct Captcha Code"
				    if(!myAuditInstance.save())
		    		{
				    	myAuditInstance.errors.each {
		    			}
		    		}
					flash.message = "Please Enter Correct Captcha Code."
		            redirect(uri:"/index.gsp")
		            return
				}
		    	def usertype = params['radioButton']
		    	if (usertype.equals('SPCB') ){
		    		String abc = params['password']
		    	def userMaster = UserMaster.findWhere(id:params['userId'])
		    	String salt=session.tunt
		    		 if(session.tunt==null)
		    	      	{
		    	          	flash.message="Your session has been expired ! Please login again."
		    	      		redirect(uri:'/index.gsp')
		    	      		return
		    	      	}
		    		def userPP=UserProfile.findWhere(id:params['userId'])
		    		 if(userMaster)
		    	    {
		    	    	if(userMaster.logAttempt==1)
		    	    	{
		    	    		myAuditInstance.userType=params['radioButton']
						    myAuditInstance.userID=params['userId']
						    myAuditInstance.ipAddress=request.getRemoteAddr() 
						    myAuditInstance.loginDate=new Date()
						    myAuditInstance.loginStatus='Un-Successfull'
						    myAuditInstance.reason="User Account Locked."
					    	 if(!myAuditInstance.save())
					    		{
							    	myAuditInstance.errors.each {
					    			}
					    		}
		    	    		flash.message = "Maximum Login attempts exceeded,Please do Forget Password to unlock account."
		    	            redirect(uri:"/index.gsp")
		    	            return
		    	    	}
		    		if (abc==MD5_Encryption(userMaster.password,salt)){
		    			
		    			if(userMaster.tempLog >0)
		    			{
		    				userMaster.tempLog=0
		    				userMaster.save();
		    			}
		    			def todaysDate = new Date()
		    			if ((todaysDate - 1)> (userMaster.end_date )){
		    				flash.message = "You are not authorized"
		    					redirect(uri:"/index.gsp")
		    			}else{
						if(userMaster.status.equals('active')){
							if(session.indUser)
							{
								session.indUser=null
							}
							 session.userMaster = userMaster
							 session.userprof=userPP
							def flag1 = userMaster.flag
							if(flag1==0){
								myAuditInstance.userType=params['radioButton']
							    myAuditInstance.userID=params['userId']
							    myAuditInstance.ipAddress=request.getRemoteAddr() 
							    myAuditInstance.loginDate=new Date()
							    myAuditInstance.loginStatus='Successfull'
							    myAuditInstance.reason="First Time Login for changing the password"
						    	 if(!myAuditInstance.save())
						    		{
								    	myAuditInstance.errors.each {
						    			}
						    		}
								flash.message = "Please Change Your Password For Security Purpose"
								redirect(uri:"/userMaster/changePassword.gsp")
							}
							else {    
								myAuditInstance.userType=params['radioButton']
							    myAuditInstance.userID=params['userId']
							    myAuditInstance.ipAddress=request.getRemoteAddr() 
							    myAuditInstance.loginDate=new Date()
							    myAuditInstance.loginStatus='Successfull'
							    myAuditInstance.reason="Login Successfull."
						    	 if(!myAuditInstance.save())
						    		{
								    	myAuditInstance.errors.each {
						    			}
						    		}
								Random rand=new Random();
							  	String s ="";
							  	s=s+rand.nextInt(10000).toString()+session.id;
						       session.mycookie=s;
						       Cookie cookie1 = new Cookie("mycookie",s);
						       cookie1.setMaxAge(24*60*60);
						       cookie1.setPath("/");
						       response.addCookie(cookie1);
						      session.brow=request.getHeader("User-Agent");
		                         session.auditIDSPCB=myAuditInstance.id
//		                       ======Pragya====
			                	 def userMasterInstance=session.userMaster
			                	 println("userMasterInstance..."+userMasterInstance)
							  def DistList=new ArrayList()
						    	 def DistListUnique=new ArrayList()
							    	 if(userMasterInstance.accessLevel!="admin")
							    	 {
							    		 println("Inside Employeer")
							    		 def roleProfileInstance=RoleProfileAssignment.findAll("From RoleProfileAssignment dateCheck where dateCheck.primaryEmployee.id = ? and role.group.groupDesc NOT in ('BMW','HWM','CESS','MSW','Grievance','Industry') order by role.group.groupName ",[userMasterInstance.id])
							    	     println("roleProfileInstance..."+roleProfileInstance)
							    		 for(int i=0;i<roleProfileInstance.size();i++)
							                {
							                	
							    	    	def groupDistInst = GroupDistrictMaster.findAll("from GroupDistrictMaster where group = ?",[roleProfileInstance[i].role.group]) 
							    	    	 println("groupDistInst..."+groupDistInst)
							    	    	  for(int j=0;j<groupDistInst.size();j++)
							                {
							    	    		def distId = groupDistInst[j].district.id  
							    	    		if(!(DistList.contains(distId)))
							            		 { 
							    	    			DistList.add(distId)
							    	    		//	println("DistList-------"+DistList)
							                		 DistListUnique.add(groupDistInst[j].district);
							    	    		//	println("DistListUnique-------"+DistListUnique)
							                     }  
							    	    		  
							                }
							    	    	 
							                }
							    		 session.relatedDistrict=DistListUnique
							    		 println("session.relatedDistrict-------"+session.relatedDistrict)
							    		
							    	 }
//			                      ==========	  
							  
								 redirect(action:recentAppl1)
							}
						}else{
							myAuditInstance.userType=params['radioButton']
						    myAuditInstance.userID=params['userId']
						    myAuditInstance.ipAddress=request.getRemoteAddr() 
						    myAuditInstance.loginDate=new Date()
						    myAuditInstance.loginStatus='Un-Successfull'
						    myAuditInstance.reason="User Account is in-active."
					    	 if(!myAuditInstance.save())
					    		{
							    	myAuditInstance.errors.each {
					    			}
					    		}
							flash.message = "You are not authorized"
							redirect(uri:"/index.gsp")
						}
		    		}}else{
		    			myAuditInstance.userType=params['radioButton']
					    myAuditInstance.userID=params['userId']
					    myAuditInstance.ipAddress=request.getRemoteAddr() 
					    myAuditInstance.loginDate=new Date()
					    myAuditInstance.loginStatus='Un-Successfull'
					    myAuditInstance.reason="Password in-correct"
				    	 if(!myAuditInstance.save())
				    		{
						    	myAuditInstance.errors.each {
				    			}
				    		}
		    			if(userMaster.tempLog==null ||userMaster.tempLog==0 )
		    			{
		    				userMaster.date1=new Date()
		    				userMaster.tempLog=1
		    				if(!userMaster.save())
				    		{
		                    	 userMaster.errors.each {
				    			}
				    		}
		    				flash.message = "Your User ID or Password is incorrect."
		    	            redirect(uri:"/index.gsp")
		    	            return
		    			}
		    			Date date2=new Date()
		    			if(compareDate(date2,userMaster.date1))
		    			{
		    				userMaster.tempLog=userMaster.tempLog+1
		    				userMaster.save()
		    				if(userMaster.tempLog>=3)
		    				{
		    					userMaster.logAttempt=1
		    					userMaster.save();
		    					flash.message = "Maximum Login attempts exceeded,Please do Forget Password to unlock account."
		    	    	        redirect(uri:"/index.gsp")
		    	    	        return
		    				}
		    				userMaster.save()
		    				flash.message = "Your User ID or Password is incorrect."
		                	redirect(uri:"/index.gsp")
		                	return
		    			}
		    			else
		    			{   userMaster.tempLog=1
		    				userMaster.date1=date2
		    			    userMaster.logAttempt=0
		    			    userMaster.save()
		    			  flash.message = "Your User ID or Password is incorrect."
		    	            redirect(uri:"/index.gsp")
		    	            return
		    	        }
		    		}
		    	    }
		    	    else 
		    	    {myAuditInstance.userType=params['radioButton']
				    myAuditInstance.userID=params['userId']
				    myAuditInstance.ipAddress=request.getRemoteAddr() 
				    myAuditInstance.loginDate=new Date()
				    myAuditInstance.loginStatus='Un-Successfull'
				    myAuditInstance.reason="In-correct User ID."
			    	 if(!myAuditInstance.save())
			    		{
					    	myAuditInstance.errors.each {
			    				
			    			}
			    		}
		    	    	flash.message = "Your User ID or Password is incorrect."
		                	redirect(uri:"/index.gsp")
		    	    }
		    	}
		    	if(usertype.equals('Industry')) {
		    		String abc = params['password']
		    		def indUser = IndUser.findWhere(id:params['userId'])
		    		String salt=session.tunt
		    		if(session.tunt==null)
			      	{
			          	flash.message="Your session has been expired ! Please login again."
			      		redirect(uri:'/index.gsp')
			      		return
			      	}
///////Pragya//////////////////////////	
		    		def newUser = NewUser.find("from NewUser where userId=?",[params.userId])
		    		println("newUser-----"+newUser)
		    	///end here
		    		if(indUser)
		    		{
		    			if(indUser.logAttempt==1)
		    	    	{
		    				myAuditInstance.userType=params['radioButton']
						    myAuditInstance.userID=params['userId']
						    myAuditInstance.ipAddress=request.getRemoteAddr() 
						    myAuditInstance.loginDate=new Date()
						    myAuditInstance.loginStatus='Un-Successfull'
						    myAuditInstance.reason="User Account Locked."
					    	 if(!myAuditInstance.save())
					    		{
							    	myAuditInstance.errors.each {
					    			}
					    		}
		    	    		flash.message = "Maximum Login attempts exceeded,Please do Forget Password to unlock account."
		    	            redirect(uri:"/index.gsp")
		    	            return
		    	    	}
		    		if (abc==MD5_Encryption(indUser.password,salt)){
		    			if(indUser.tempLog >0)
		    			{
		    				indUser.tempLog=0
		    				indUser.save();
		    			}
		    			if(session.userMaster)
						{
							session.userMaster=null
						}
		    			def indregSESS=indUser.industryRegMaster
		    			session.indUser = indUser
		    			session.indregName=indregSESS
		    			println("session.indregName    "+session.indregName)
		    			def flag1 =indUser.flag 
		    			if (flag1 == 0){
		    				myAuditInstance.userType=params['radioButton']
						    myAuditInstance.userID=params['userId']
						    myAuditInstance.ipAddress=request.getRemoteAddr() 
						    myAuditInstance.loginDate=new Date()
						    myAuditInstance.loginStatus='Successfull'
						    myAuditInstance.reason="First Time Login for changing the password "
					    	 if(!myAuditInstance.save())
					    		{
							    	myAuditInstance.errors.each {
					    			}
					    		}
		    				flash.message = "Please Change Your Password For Security Purpose"
		    				redirect(uri:"/industryRegMaster/changePassword.gsp")
		    			}
		    			else {
		    				myAuditInstance.userType=params['radioButton']
						    myAuditInstance.userID=params['userId']
						    myAuditInstance.ipAddress=request.getRemoteAddr() 
						    myAuditInstance.loginDate=new Date()
						    myAuditInstance.loginStatus='Successfull'
						    myAuditInstance.reason="Login Successfull"
					    	 if(!myAuditInstance.save())
					    		{
							    	myAuditInstance.errors.each {
					    			}
					    		}
		    				Random rand=new Random();
						  	String s ="";
						  	s=s+rand.nextInt(10000).toString()+session.id;
					       session.mycookie=s;
					       Cookie cookie1 = new Cookie("mycookie",s);
					       cookie1.setMaxAge(24*60*60);
					       cookie1.setPath("/");
					       response.addCookie(cookie1);
					       session.brow=request.getHeader("User-Agent");
		                    session.login="xyz"
		                    session.auditIDSPCB=myAuditInstance.id
		    				redirect(controller:'indUser',action:'openIndustryHome')	
		    			}
		    		}
		    		else{
		    			myAuditInstance.userType=params['radioButton']
					    myAuditInstance.userID=params['userId']
					    myAuditInstance.ipAddress=request.getRemoteAddr() 
					    myAuditInstance.loginDate=new Date()
					    myAuditInstance.loginStatus='Un-Successfull'
					    myAuditInstance.reason="In-correct Password "
				    	 if(!myAuditInstance.save())
				    		{
						    	myAuditInstance.errors.each {
				    			}
				    		}
		    			if(indUser.tempLog==null ||indUser.tempLog==0 )
					    {
		    			indUser.date1=new Date()
						indUser.tempLog=1
						indUser.save()     
					flash.message = "Your User ID or Password is incorrect."
			            redirect(uri:"/index.gsp")
			            return
					}
					Date date2=new Date()
					if(compareDate(date2,indUser.date1))
					{
						indUser.tempLog=indUser.tempLog+1
						indUser.save()
						if(indUser.tempLog>=3)
						{
							indUser.logAttempt=1
							indUser.save();
							flash.message = "Maximum Login attempts exceeded,Please do Forget Password to unlock account."
			    	        redirect(uri:"/index.gsp")
			    	        return
						}
						indUser.save()
						flash.message = "Your User ID or Password is incorrect."
		            	redirect(uri:"/index.gsp")
		            	return
					}
					else
					{   indUser.tempLog=1
						indUser.date1=date2
						indUser.logAttempt=0
						indUser.save()
					   flash.message = "Your User ID or Password is incorrect."
			            redirect(uri:"/index.gsp")
			            return
			        }
		    	    }
		    		}
//////		    	Pragya//////////////////////////	
		    		else if(newUser){
		    			
		    			println("new user login---"+newUser.userId)
		    			session.newUser = newUser.userId
		    			if (abc==MD5_Encryption(newUser.password,salt)){

		        			
		        				myAuditInstance.userType=params['radioButton']
		    				    myAuditInstance.userID=params['userId']
		    				    myAuditInstance.ipAddress=request.getRemoteAddr() 
		    				    
		    				   
		    				    myAuditInstance.loginDate=new Date()
		    				    myAuditInstance.loginStatus='Successfull'
		    				    myAuditInstance.reason="Login Successfull"
		    			    	 if(!myAuditInstance.save())
		    			    		{
		    					    	myAuditInstance.errors.each {
		    			    				println it
		    			    			}
		    			    		}
		        				Random rand=new Random();
		    				  	String s ="";
		    				  	
		    				  	
		    			       s=s+rand.nextInt(10000).toString()+session.id;
		    			       session.mycookie=s;
		    			       
		    			       Cookie cookie1 = new Cookie("mycookie",s);
		    			       cookie1.setMaxAge(24*60*60);
		    			       cookie1.setPath("/");
		    			       response.addCookie(cookie1);
		    			      
		    			       session.brow=request.getHeader("User-Agent");
		                       
		                       println session.brow
		    			       
		                        session.login="xyz"

		        				session.auditIDSPCB=myAuditInstance.id
		        				println("new user login---"+session.newUser)

		        		
		        				
		        				redirect(controller:'industryRegMaster',action:'registerUpdate')
		        				return
		        				println("new user login end---")
		    			}
		    			else{
		    			
		        			myAuditInstance.userType=params['radioButton']
		    			    myAuditInstance.userID=params['userId']
		    			    myAuditInstance.ipAddress=request.getRemoteAddr() 
		    			     myAuditInstance.macAddress = macVal
		    			     myAuditInstance.UserName = newUser.name
		    			    myAuditInstance.loginDate=new Date()
		    			    myAuditInstance.loginStatus='Un-Successfull'
		    			    myAuditInstance.reason="In-correct Password "
		    		    	 if(!myAuditInstance.save())
		    		    		{
		    				    	myAuditInstance.errors.each {
		    		    				println it
		    		    			}
		    		    		}
		        			
		    		
		    				flash.message = "Your User ID or Password is incorrect."
		    	            redirect(uri:"/index.gsp")
		    	            return
		    	        
		    			}
		    			
		    		
		    			
		    		}
		    	//////end here
		    		else
		    		{
		    			myAuditInstance.userType=params['radioButton']
					    myAuditInstance.userID=params['userId']
					    myAuditInstance.ipAddress=request.getRemoteAddr() 
					    myAuditInstance.loginDate=new Date()
					    myAuditInstance.loginStatus='Un-Successfull'
					    myAuditInstance.reason="In-correct User ID."
				    	 if(!myAuditInstance.save())
				    		{
						    	myAuditInstance.errors.each {
				    			}
				    		}
		    			flash.message = "Your User ID or Password is incorrect."
		            		redirect(uri:"/index.gsp")
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
    
 def recentAppl={
		  try {
		      def listBB= new ArrayList()
		    	def listHigh= new ArrayList()
		    	def listObj= new ArrayList()
		    	def listIndObj= new ArrayList()
		    	def listIndStore= new ArrayList()
		    	def listHighIND= new ArrayList()
		    	def listFinalIND= new ArrayList()
		    	def listFinalDate=new ArrayList()
		    	if(!session.userMaster)
		    		{
		    		redirect(uri:"/index.gsp")
		    		}
		    	else
		    	{
		    	def aa = session.userMaster
		    	def offStr=(aa.id).toString()
		    	def	nis=ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails app, IndApplicationDetails dateCheck  WHERE dateCheck.id = app.application and app.officerFwd=? order by app.lastUpdated desc " ,[offStr]); 
		    	def	newNis=ApplicationPendingDetails.findAll(" From  ApplicationPendingDetails appPendDet, IndApplicationDetails dateCheck  WHERE dateCheck.id = appPendDet.application  and appPendDet.pendingWith= ? and appPendDet.applicationStatus= 'pending' order by dateCheck.actualApplicationDate desc" ,[aa]); 
				for(int gN=0;gN<newNis.size();gN++)
							{
								def bol=false
				    			listIndObj=newNis.get(gN)
				    			for(int varI=0;varI<listHighIND.size();varI++)
									{
				    				def listCheck=listIndObj[1]
										if(listCheck==listHighIND[varI])
											{
												bol=true;
												break
											}
									}
								if(!bol)
									{	
										listHighIND.add(((ArrayList)listIndObj).get(1))
									}
				    				if(listHighIND.size()==10)
									{
				    					break
									}
							}
				for(int g=0;g<nis.size();g++)
					{
					def bol=false
							listBB=nis.get(g)
							def checkComp=listBB[1]
							def preCheck=ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=? and apd.pendingWith = ?",[checkComp,aa])
							if(preCheck)
								{
									if(preCheck.applicationStatus=="pending")
										{
											for(int varI=0;varI<listHigh.size();varI++)
												{
													def listCheck=listBB[1]
													if(listCheck==listHigh[varI])
														{
															
															bol=true;
															break
														}
												}
											if(!bol)
												{
													
													listHigh.add(((ArrayList)listBB).get(1))
													listObj.add((ArrayList)listBB)
												}
										}
								}
							if(listObj.size()==10)
								{
									break
								}
					}
		       int c=0;
		        for(int i=0;i<listObj.size();i++)
					{
		        		def indSp=listObj[i]
						def indApplicationD=indSp[0]
						for(int j=c;j<listHighIND.size();j++)
							{
							if(listFinalIND.size()== 10)
									{ 
										break
									}
		        		if( indApplicationD.lastUpdated > listHighIND[j].actualApplicationDate)
									{
										def ifPresent=false
										for(int n=0;n<=listFinalIND.size();n++)
											{
												if(indSp[1]==listFinalIND[n])
													{
														ifPresent=true
														break
													}	
											}
										if(!ifPresent)
											{
												
												listFinalIND.add(indSp[1])
												listFinalDate.add(indSp[0].lastUpdated)
												break
											}
									}
								else
									{
										
										if( indApplicationD.lastUpdated < listHighIND[j].actualApplicationDate)
											{
												def ifPresent=false
												for(int n=0;n<=listFinalIND.size();n++)
													{
														if(listHighIND[j]==listFinalIND[n])
															{  ifPresent=true
																break
															}	
													}
												if(!ifPresent)
													{
														listFinalIND.add(listHighIND[j])
														listFinalDate.add(listHighIND[j].actualApplicationDate)
													}
												c++
											}
										else
											{
												if( indApplicationD == listHighIND[j])
													{
														def ifPresent=false
														for(int n=0;n<=listFinalIND.size();n++)
															{	
																if(indSp[1]==listFinalIND[n])
																	{
																		ifPresent=true
																		break
																	}
															}
														if(!ifPresnt)
															{
																listFinalIND.add(indSp[1])
																listFinalDate.add(indSp[0].lastUpdated)
																break
															}
													}
												else
													{
														def ifPresent=false
														def ifPresentSec=false
														for(int n=0;n<=listFinalIND.size();n++)
															{
																if(indSp[1]==listFinalIND[n])
																	{
																	ifPresent=true
																		break
																	}
															}
														if(!ifPresnt)
															{				
																listFinalIND.add(indSp[1])
																listFinalDate.add(indSp[0].lastUpdated)
															}
														for(int n=0;n<=listFinalIND.size();n++)
															{	
																if(listHighIND[j]==listFinalIND[n])
																	{
																	ifPresentSec=true
																	}
															}
														if(!ifPresntSec)
															{	
																listFinalIND.add(listHighIND[j])
																listFinalDate.add(listHighIND[j].actualApplicationDate)
															}
														c++
														break
													}
		        					}
		        			}
		        	}
					if(listFinalIND.size()== 10)
						{
							break
						}
		        	if(listFinalIND.size()< 10)
						{
		        		def cTrue=false
		        		for(int n=0;n<=listFinalIND.size();n++)
						{	
						if(indSp[1]==listFinalIND[n])
								{
									cTrue=true
								}
						}
		        		if(!cTrue)
						{	
							listFinalIND.add(indSp[1])
							listFinalDate.add(indSp[0].lastUpdated)
						}
						}
		        }
		       if(listFinalIND.size()< 10)
		    		{
		    	   		def varFor=10-c
						for(int k=c;k<listHighIND.size();k++)
							{
							def cTrue=false
							for(int n=0;n<=listFinalIND.size();n++)
							{	
								if(listHighIND[c]==listFinalIND[n])
									{
										cTrue=true
									}
							}
							if(listFinalIND.size()== 10)
									{
										break
									}
								if(!cTrue)
								{	
									listFinalIND.add(listHighIND[c])
									listFinalDate.add(listHighIND[c].actualApplicationDate)
								}
							}
		    		}
		       def checkAdmin = aa.accessLevel
				if (checkAdmin.equals('admin'))
					{
						render(view:'recentAppl',model:[listFinalIND:listFinalIND,listFinalDate:listFinalDate])
					}
		    	else
					{
						render(view:'recentAppl',model:[listFinalIND:listFinalIND,listFinalDate:listFinalDate])
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

def openSpcbHome = {
		  try {
		     params.max = Math.min( params.max ? params.max.toInteger() : 20,  100)
		    	def xyz5
				def qwe
				def xyz55
				def qwe5
				if(!params.init)
				{
					xyz5=20
					qwe=0
					xyz55=20
					qwe5=0
				}
				else
				{
					
					def ch=params.check
					if(ch == "true" )
					{
						xyz5=20
						qwe=0
						xyz55=(params.max).toInteger()
						qwe5=(params.offset).toInteger()
					}
					else
					{
						xyz5=(params.max).toInteger()
						qwe=(params.offset).toInteger()
						xyz55=(params.max).toInteger()
						qwe5=0
					}
				}
		    	if(!session.userMaster)
		    	{
		    		redirect(uri:"/index.gsp")
		    	}
		    	else
		    	{
		    		def aa = session.userMaster
				    	def sizePending= ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.pendingWith= ? ",[aa])
				    	def totalPend=sizePending.size()
				    	def offStr=(aa.id).toString()
				    	
				    	def newlist = new ArrayList()
				    	def pendinglist = new ArrayList()
				    	def completedlist = new ArrayList()
		    		def applicationPendingDetailsInstanceList = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.pendingWith= ? and apd.completionStatus!='Completed' order by apd.application.id desc",[aa])
				    	def complistS = ApplicationPendingDetails.findAll("from ApplicationPendingDetails as b where b.pendingWith=? and b.applicationStatus=? or b.applicationStatus=? and b.completionStatus!='Completed'",[aa,'approved','rejected'])
				    	def complist = ApplicationPendingDetails.findAll("from ApplicationPendingDetails as b where b.pendingWith=? and b.applicationStatus=? or b.applicationStatus=? and b.completionStatus!='Completed' order by b.application.id desc",[aa,'approved','rejected'],[max:xyz55,offset:qwe5])
				    	def totalComp=complistS.size()
				    	for(int i=0; i<applicationPendingDetailsInstanceList.size; i++ ){	
				    		if((applicationPendingDetailsInstanceList.get(i)).applicationStatus.equals('pending')){
				    			newlist.add((applicationPendingDetailsInstanceList.get(i)).application)
				    		}
				    		if((applicationPendingDetailsInstanceList.get(i)).applicationStatus.equals('inprogress')){
					    		pendinglist.add((applicationPendingDetailsInstanceList.get(i)).application)	
					    		
				    		}
				    		if((applicationPendingDetailsInstanceList.get(i)).applicationStatus.equals('approved') || (applicationPendingDetailsInstanceList.get(i)).applicationStatus.equals('rejected')){
		                        completedlist.add((applicationPendingDetailsInstanceList.get(i)).application)        
		                        
		                }
				    	}
				    	def checkAdmin = aa.accessLevel
				    	if (checkAdmin.equals('admin')){
				    		render(view:'spcbadminhome',model:[totalPend:totalPend,totalComp:totalComp,completedIndApplicationDetailsInstanceList:completedlist,pendingIndApplicationDetailsInstanceList:pendinglist,newIndApplicationDetailsInstanceList:newlist])
				    	}
				    	else{
				    		render(view:'spcbhome',model:[totalPend:totalPend,totalComp:totalComp,completedIndApplicationDetailsInstanceList:completedlist,pendingIndApplicationDetailsInstanceList:pendinglist,newIndApplicationDetailsInstanceList:newlist])
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
    
 def forgetPassSPCB1 ={
		  try {
		    def userMasterInstance1 = new UserMaster()
		    	def userMasterInstance = UserMaster.findWhere(id:params['userName'])
		    	if(userMasterInstance) {
		    		render(view:'forgetPass2',model:[userMasterInstance:userMasterInstance])
		    		}
		   else if (!userMasterInstance){
		    		flash.message ="${params.userName} do not exist"
		    	render(view:'/forgetPassword',model:[userMasterInstance:userMasterInstance])	
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
    
 def forgetPass2 ={
		  try {
		    def b  = params.hintAnswer  
		    	def userMasterInstance = UserMaster.findWhere(id:params['id'])
		    	if (userMasterInstance.hintAnswer.equals(b)){
		    		render(view:'forgetPass3',model:[userMasterInstance:userMasterInstance])
		    	}
		    	  else { 
		    		  flash.message = "your Answer does not match "
		    		  render(view:'forgetPass2',model:[userMasterInstance:userMasterInstance])
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
    
def forgetPassSPCB3={
		  try {
		     def a = params.password1
		    	def b = params.password2
		    	def userMasterInstance = UserMaster.get(params.userMasId)
		    	if (a.equals(b)) {
		    	if(userMasterInstance) {
		    			if(userMasterInstance.lPass==null )
		    	    	{
		    				userMasterInstance.password1=userMasterInstance.password     		
		    				userMasterInstance.lPass=1
		    	    		if(!userMasterInstance.save())
		    	    		{
		    	    			userMasterInstance.errors.each {
		    	    			}
		    	    		}
		    	    	}
		    			if( PasswordCheck(userMasterInstance.password1,userMasterInstance.password2,userMasterInstance.password3,userMasterInstance.password4,userMasterInstance.password5,b))
		  			  {
		  				  flash.message="Password can not be a last 5 password"
		  					render(view:'forgetPass3',model:[userMasterInstance:userMasterInstance])
		  		    	  return
		  		    	
		  			  }
		  			  else
		  			  {
		  				  if(userMasterInstance.lPass==0)
		  				  {
		  					  userMasterInstance.lPass=1
		  					  userMasterInstance.password1=b
		  				  }
		  				  else if(userMasterInstance.lPass==1)
		  				  {
		  					  userMasterInstance.lPass=2
		  					  userMasterInstance.password2=b
		  				  }
		  				  else if(userMasterInstance.lPass==2)
		  				  {
		  					  userMasterInstance.lPass=3
		  					  userMasterInstance.password3=b
		  				  }
		  				  else if(userMasterInstance.lPass==3)
		  				  {
		  					  userMasterInstance.lPass=4
		  					  userMasterInstance.password4=b
		  				  }
		  				  else if(userMasterInstance.lPass==4)
		  				  {
		  					  userMasterInstance.lPass=0
		  					  userMasterInstance.password5=b
		  				  }
		  			 }
		    		userMasterInstance.password = b
		    			userMasterInstance.logAttempt=0
		    			userMasterInstance.tempLog=0
		    			userMasterInstance.save()
		    			flash.message = "your password has been Reset "
		    				redirect(uri:"/indCatMaster/forgetPassword")
		    		}
		    	 else {
		            flash.message = "UserMaster not found with id ${params.id}"
		            redirect(action:edit,id:params.id)
		        }
		        }
		    	else {
		    		flash.message="retype password"
		    		render(view:'forgetPass3',model:[userMasterInstance:userMasterInstance])
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
      
 def changePassword ={
		  try {
		   if(session.userMaster==null)
		  	  {
		  		  session.invalidate()
		    		redirect(uri:'/index.gsp')
		    		return
		  	  }
		      	def userMasterInstance = UserMaster.get(params.id)
		          def preFlag
		          if (userMasterInstance){
		      	preFlag = userMasterInstance.flag
		      	def old = params.old
		      	if(userMasterInstance.lPass==null )
		      	{
		      		userMasterInstance.password1=userMasterInstance.password     		
		      		userMasterInstance.lPass=1
		      		if(!userMasterInstance.save())
		      		{
		      			userMasterInstance.errors.each {
		      			}
		      		}
		      	}
		      	def pass =userMasterInstance.password 
		      	if (pass.equals(old)){
		      		def newpass1 =params.newPass1
		      		def newpass2 =params.newPass2
		      		 if(newpass1.equals(newpass2)){
		      			   if( PasswordCheck(userMasterInstance.password1,userMasterInstance.password2,userMasterInstance.password3,userMasterInstance.password4,userMasterInstance.password5,newpass2))
		      			  {
		      				  flash.message="Password can not be a last 5 password"
		      		    	  render(view:'changePassword')
		      		    	  return
		      		    	 }
		      			  else
		      			  {
		      				  if(userMasterInstance.lPass==0)
		      				  {
		      					  userMasterInstance.lPass=1
		      					  userMasterInstance.password1=newpass2
		      				  }
		      				  else if(userMasterInstance.lPass==1)
		      				  {
		      					  userMasterInstance.lPass=2
		      					  userMasterInstance.password2=newpass2
		      				  }
		      				  else if(userMasterInstance.lPass==2)
		      				  {
		      					  userMasterInstance.lPass=3
		      					  userMasterInstance.password3=newpass2
		      				  }
		      				  else if(userMasterInstance.lPass==3)
		      				  {
		      					  userMasterInstance.lPass=4
		      					  userMasterInstance.password4=newpass2
		      				  }
		      				  else if(userMasterInstance.lPass==4)
		      				  {
		      					  userMasterInstance.lPass=0
		      					  userMasterInstance.password5=newpass2
		      				  }
		      				}
		      			  userMasterInstance.password = newpass2
		      	    	userMasterInstance.save()
		      	    	if(userMasterInstance.save()){
		      	    		if(preFlag == 0){
		      	    	flash.message = "your password has been Reset Please Login"
		      	    		userMasterInstance.flag = preFlag + 1
		      	    		redirect(uri:"/index.gsp")
		      	    	}else{
		      	    		flash.message = "your password has been Reset"
		          	    		userMasterInstance.flag = preFlag + 1
		      	    	}
		      	    		}
		      	    	 }else {
		      			  flash.message= "Enter again"
		      		  }
		      	}else {
		      		flash.message="please enter valid password"
		      			render(view:'changePassword')
		      	}
		       }else {
		      		if(params.id){
		      		flash.message ="UserName not Found"
		      		}
		  		   	render(view:'changePassword')
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

def auditSearch ={
		  try {
		     if(session.userMaster==null)
	       	{
	           	flash.message="Your session has been expired ! Please login again."
	       		redirect(uri:'/index.gsp')
	       		return
	       	}
	        	def my=session.userMaster
	    	  if(!(my.accessLevel=='admin'))
	    	  {
	    		 flash.message="Only Admin user Can view Audit Trail" 
	    		 redirect(action: 'recentAppl')
	    		 return
	    	  }
	    	  else
	    	  {   
	    		render(view:'auditSearch')
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
  
def cessHomePage={
		  try {
		      redirect(controller:"cessPendingDetails",action:"cessPendingReturn")
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
	  
def cessIndustryMenuVertical={
		  try {
		      render(view:'cessIndustryMenuVerticalPage')
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
    
def cessAdminMenuVertical={
		  try {
		      render(view:'cessAdminMenuVerticalPage') 
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
	  
def cessEmpMenuVertical={
		  try {
		      render(view:'cessEmpMenuVerticalPage') 
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
	  
def cessEmpMenuVerticalPage={ }
    
def wasteManagementHomePage={
		  try {
		     redirect(controller:"wasteManagementPendingDetails",action:"pendingList")
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
    
def wasteManagementAdminVertical={
		  try {
		      render(view:'wasteManagementAdminVerticalPage') 
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
	  
 def wasteManagementEmpVertical={
		  try {
		      render(view:'wasteManagementEmpVerticalPage') 
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
	  
def wasteManagementIndustryVertical={
		  try {
		     render(view:'wasteManagementIndustryVerticalPage') 
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
   
def wasteManagementAdminVerticalPage={}
	  
def wasteManagementEmpVerticalPage={}
	  
def wasteManagementIndustryVerticalPage={}
	  
def labAdmin={
		  try {
		      render(view:'labAdminPage') 
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
	  
def labEmployee={
		  try {
		      render(view:'labEmployeePage') 
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
	  
def labAdminPage={}
	  
def labEmployeePage={ }

def reportAdminMenuVertical={
		  try {
		      render(view:'reportAdminMenuVerticalPage') 
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
    
 def reportAdminMenuVerticalPage={  }
         
 def showSpcbHeader = {
		  try {
		      render(view:'spcbHeader')
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
	  
 def showSpcbFooter = {
		  try {
		     render(view:'spcbFooter')
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
	  
def showAdminMenuHorizontal = {
		  try {
		     render(view:'menuAdminHorizontal')
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
	  
def showSpcbUserMenuHorizontal = {
		  try {
			    render(view:'menuSpcbUserHorizontal')
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
	  
def showIndustryMenuHorizontal = {
		  try {
			   render(view:'menuIndustryHorizontal')
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
	  
def showAdminMenu = {
	 try {
			 render(view:'menuAdmin')
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
	  
def showSpcbUserMenu = {
		  try {
			  render(view:'menuSpcbUser')
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

def showSpcbIndustryMenu = {
		  try {
			    render(view:'menuSpcbIndustry')
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
	  
 def showIndexMenu = {
		  try {
			 render(view:'menuIndex')
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
	  
 def showMenu={
		  try {
			    render(view:'horizontalMenuChattisgarh')
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
    
def showIndexMenuHorizontal = {
		  try {
			    render(view:'menuIndexHorizontal')
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
	  
def newRegIndustryMenu = 
    {
try {
		     redirect(uri:"/index.gsp")
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
    
def logout = {
		  try {
			String referrer = request.getHeader("referer");
			  if(referrer==null)
			  {
				  redirect(uri:"/index.gsp")
			  return
			  }
			  if(!session.auditIDSPCB)	
			    {
			    	flash.message="Your session has been expired ! Please login again."
			    		session.invalidate()
			       		redirect(uri:'/index.gsp')
			       		return
			    }
			    def  myAuditInstance=MyAudit.get(session.auditIDSPCB)
			    myAuditInstance.logoutDate=new Date()
			    if(!myAuditInstance.save())
				{
			    	myAuditInstance.errors.each {
					}
				}
			   session.invalidate()
		      redirect(uri:"/index.gsp")
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
	  
def searchAudit ={
		  try {
			    def industry=null
			              def checkDate=null
									def startDate1=params.start_date_value
									def endDate1=params.end_date_value
									session.startDate1=startDate1
									session.endDate1=endDate1
									def x
									def y
									try
									{
										def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
										x = sdfh.parse(startDate1); //Date
										y = sdfh.parse(endDate1);
										checkDate="checked"
									}
									catch(Exception e)
									{
										flash.message="Enter Both The Dates in correct Format"
										redirect(action:auditSearch)
									}
							if(checkDate)
							{
								java.sql.Date sqlDate = new java.sql.Date(x.getTime())
									java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
									sqlDate2.setDate((sqlDate2.getDate()+1))
									if(sqlDate>sqlDate2)
								{
										flash.message="End Date should be Greater than Start Date"
											redirect(action:auditSearch)
								}
								else
								{
								if(startDate1 && endDate1)
									{
										industry=MyAudit.findAll("From MyAudit idUser where idUser.loginDate >= ? and idUser.loginDate <= ? order by loginDate desc",[sqlDate,sqlDate2]);
									}
									}
									}
								if(industry.size()==0)
						{
							flash.message="No Result Found With This Search Combination"
						}	
							render(view:'auditSearch',model:[industry:industry])	
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

def pendingAppSearch = {
 try {
     def grp = GroupMaster.findAll()
	  		return[grp:grp]
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
	  	  
def search = {
	  try {
		    
			
			if(!params.frmDate_value && !params.toDate_value)
		{
			flash.message="Please Enter Both the Dates"
			redirect(action:pendingAppSearch)
			return
		}
	 def allApprovedApp1 = new ArrayList()
	 def startDate1 = params.frmDate_value
	  def endDate1 = params.toDate_value
	  def group = params.group
	  def pendingWith = params.pendingWith
	  def abc
	 def c
	
	 
	 if(params.searchOp==null)
		{
			flash.message = "Please Select The Radio Button "
			redirect(action:pendingAppSearch)
			return
		}
	 
	 else{
		 
			if(params.searchOp=="ApplId")
			{
				if(params.autocomplete_parameter==null || params.autocomplete_parameter=="" || params.autocomplete_parameter==" ")
				{
					flash.message="Please Enter the Application Id"
					redirect(action:pendingAppSearch)
					return
				}
				else
				{
					
				abc=AllSummaryReport.find("from AllSummaryReport where applicationId=? and applicationStatus='pending'",[(params.autocomplete_parameter)])
					if(!abc){
						flash.message="Please Enter valid Application Id"
							redirect(action:pendingAppSearch)
						return
					}
					else{
						
						c=abc
						
					}
								
				
				}
				

			} 
		 
		 
		 
		 
		 
			if(params.searchOp=="Others")
			{
		 
		  def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
			def v = sdfh.parse(startDate1); //Date
			def y = sdfh.parse(endDate1);
			
		
		
			def allApprovedApp = new ArrayList()
			
		java.sql.Date sqlDate = new java.sql.Date(v.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		sqlDate2.setDate((sqlDate2.getDate()+1))
		if(sqlDate>sqlDate2)
		{
			flash.message="To Date should be Greater than From Date"
			redirect(action:pendingAppSearch)
			return
		}
		if(group=="None" && pendingWith=="None" )
		{
		c = AllSummaryReport.findAll("from AllSummaryReport asr where asr.applicationRecieptDate >=? and asr.applicationRecieptDate <=? and asr.applicationStatus='pending' order by asr.applicationRecieptDate desc",[sqlDate,sqlDate2])
	 
		}
			}
	  if(!c)
	  {
		  flash.message="No Record found for this search combination"
	  }
	  
	 }
	  render(view:'pendingAppSearch',model:[frmDate:startDate1,toDate:endDate1,indList:c])

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

def pendingWith = {
 try {
  def grp = GroupMaster.get((params.id).toLong())
	  		   def pendingWith = RoleMaster.findAll("from RoleMaster rm where rm.group=? order by roleDesc asc",[grp])
	  		  render pendingWith as JSON
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

def printConditionalPage = {
	  try {
		  def appList = new ArrayList()
  if((params.indList).getClass().getName()=="java.lang.String")
  {
	  def cc=AllSummaryReport.get((params.indList).toLong())
	  appList.add(cc)
  }
  else
  {
  String[] a=params.indList
 for(int i=0;i<a.size();i++)
  {
	  def cc=AllSummaryReport.get(a[i].toLong())
	  appList.add(cc)
  }
  
  }
  return[indList:appList]
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
	  	  
def grantedApplicationSearch = {
		  try {
			 def grp = GroupMaster.findAll()
	  		  	return[grp:grp]
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
	  
def grantApplicationSearch =
	  {
	  try {
		  println("params..."+params)
		 def startDate1 = params.start_date_value
		  def endDate1 = params.end_date_value
		  def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		  def x = sdfh.parse(startDate1); //Date
		  def y = sdfh.parse(endDate1);
		  def c = []
		  def c11 = []
		  def d
		  def district1
		  def abc
		  def appFor
		 
		  appFor=params.applicationForInd
		  
		  println("appFor..."+appFor)
		  if(params.searchOp==null)
		  {
		  	flash.message = "Please Select The Radio Button "
		  	redirect(action:pendingAppSearch)
		  	return
		  } else{
		if(params.searchOp=="ApplId")
		  	{
		  		if(params.autocomplete_parameter==null || params.autocomplete_parameter=="" || params.autocomplete_parameter==" ")
		  		{
		  			flash.message="Please Enter the Application Id"
		  			redirect(action:grantedApplicationSearch)
		  			return
		  		}
		  		else
		  		{
		  		abc=AllSummaryReport.find("from AllSummaryReport where applicationId=? and applicationStatus='approved'",[(params.autocomplete_parameter)])
		  			if(!abc){
		  				flash.message="Please Enter valid Application Id"
		  					redirect(action:grantedApplicationSearch)
		  				return
		  			}
		  			else{
		  				c11.add(abc)
		  			}
		  			}
		  		} 
		   	if(params.searchOp=="Others")
		  	{
		  def dealGroup = params.group;
		  def app = params.applicationType;
		  def allApprovedApp = new ArrayList()
		  java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		  java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		  sqlDate2.setDate((sqlDate2.getDate()+1))
		  if(sqlDate !=null && sqlDate2 !=null ){
		  if(app=="None" && dealGroup=="None" && appFor=="None" ){
			  println("111111111111...")
		  	c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved' order by asr.pendingSince desc",[sqlDate,sqlDate2])
		  }else if(app=="None" && dealGroup=="None" && appFor!="None" ){
			  println("AAAAAAAAAAAAAA...")
			  	c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved' and asr.applicationFor=? order by asr.pendingSince desc",[sqlDate,sqlDate2,appFor])
			  }
		  else if(app!="None" && dealGroup=="None" && appFor=="None" ){
			  println("2222222222...")
		  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved' and asr.applicationType=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,app])
		  }
		  else if(app!="None" && dealGroup=="None" && appFor!="None" ){
			  println("3333333333...")
		  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved' and asr.applicationType=?  and asr.applicationFor=?   order by asr.pendingSince desc",[sqlDate,sqlDate2,app,appFor])
		  }
		  else if(app!="None" && dealGroup!="None" && appFor!="None" ){
			  println("44444444444...")
		  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved' and asr.applicationType=?  and asr.applicationFor=? and asr.groupId=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,app,appFor,dealGroup])
		  }else if(app!="None" && dealGroup!="None" && appFor=="None" ){
			  println("555555555555...")
		  	c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved' and asr.applicationType=?   and asr.groupId=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,app,dealGroup])
		  }
		  else if(app=="None" && dealGroup!="None" && appFor=="None" ){
			  println("666666666666...")
			  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='approved'   and asr.groupId=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,dealGroup])
		  }
		  }	
	}
		  	if(c11.size()==0)
		  {	
		  flash.message="No applications of this type is Granted yet"

		  }
		  }
		  def grp = GroupMaster.findAll()	
		  render(view:'grantedApplicationSearch',model:[start_date:startDate1,end_date:endDate1,indList:c11,grp:grp])
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
	  
def downLoadingCertificate1={
		  try {
			
	  			def appId=IndApplicationDetails.get((params.id).toLong())
	  			def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentOrder' order by afr.dateCreated desc",[appId],[max:1])
	  			def fileSingle=fileDownLoad.get(0);
	  			response.setContentType( "application-xdownload")
	  			response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
	  			response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
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
	  		  
def downLoadingCertificate={
		  try {
			def appId=IndApplicationDetails.get((params.id).toLong())
				def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate' order by afr.id desc",[appId],[max:1])
				def fileSingle=fileDownLoad.get(0);
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
				response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
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
	  
def printConditionalPage1 = 
	  	  {
		  try {
			  println("params..."+params)
			def appList1 = new ArrayList()
		  	    def appList = new ArrayList()
		  	    if((params.indList).getClass().getName()=="java.lang.String")
		  	    {
		  	    	def cc=AllSummaryReport.get((params.indList).toLong())
		  	  	  appList.add(cc)
		  	    }
		  	    else
		  	    {
		  	  	  String[] a=params.indList
		  	  	  for(int i=0;i<a.size();i++)
		  	    {
		  	  	  def cc=AllSummaryReport.get(a[i].toLong())
		  	  	  appList.add(cc)
		  	    }
		  	    }
			  println("params..."+appList1)
		  	   return[indList:appList]
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
	    
def rejectedApplicationSearch = {
	  try {
		    
		  def grp = GroupMaster.findAll()
		  		  
		  		return[grp:grp]
		    	  
		    
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

 def rejectApplicationSearch ={
	  try {
		  println("params.rejectApplicationSearch.."+params)
		  def startDate1 = params.start_date_value
		  def endDate1 = params.end_date_value
		  def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
		  def x = sdfh.parse(startDate1); //Date
		  def y = sdfh.parse(endDate1);
		  def c = []
		  def c11 = []
		  def d
		  def district1
		  def abc
		  def appFor
		 
		  appFor=params.applicationForInd
		  
		  if(params.searchOp==null)
				{
					flash.message = "Please Select The Radio Button "
					redirect(action:pendingAppSearch)
					return
				} else{
				 if(params.searchOp=="ApplId")
					{
						if(params.autocomplete_parameter==null || params.autocomplete_parameter=="" || params.autocomplete_parameter==" ")
						{
							flash.message="Please Enter the Application Id"
							redirect(action:rejectedApplicationSearch)
							return
						}
						else
						{
						abc=AllSummaryReport.find("from AllSummaryReport where applicationId=? and applicationStatus='rejected'",[(params.autocomplete_parameter)])
							if(!abc){
								flash.message="Please Enter valid Application Id"
									redirect(action:rejectedApplicationSearch)
								return
							}
							else{
								c11.add(abc)
							}
						}
					} 
			if(params.searchOp=="Others")
				{
				def dealGroup = params.group;
		  def app = params.applicationType;
		  def allApprovedApp = new ArrayList()
		  java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		  java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		  sqlDate2.setDate((sqlDate2.getDate()+1))

		  if(sqlDate !=null && sqlDate2 !=null ){
		  if(app=="None" && dealGroup=="None" && appFor=="None" ){
		  	c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected' order by asr.pendingSince desc",[sqlDate,sqlDate2])
		  }else if(app=="None" && dealGroup=="None" && appFor!="None" ){
			c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected' and asr.applicationFor=? order by asr.pendingSince desc",[sqlDate,sqlDate2,appFor])
		  }
		  else if(app!="None" && dealGroup=="None" && appFor=="None" ){
		  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected' and asr.applicationType=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,app])
		  }
		  else if(app!="None" && dealGroup=="None" && appFor!="None" ){
		  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected' and asr.applicationType=?  and asr.applicationFor=?   order by asr.pendingSince desc",[sqlDate,sqlDate2,app,appFor])
		  }
		  else if(app!="None" && dealGroup!="None" && appFor!="None" ){
		  c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected' and asr.applicationType=?  and asr.applicationFor=? and asr.groupId=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,app,appFor,dealGroup])
		  }else if(app!="None" && dealGroup!="None" && appFor=="None" ){
		  	c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected' and asr.applicationType=?   and asr.groupId=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,app,dealGroup])
		  }
		  else if(app=="None" && dealGroup!="None" && appFor=="None" ){
		 c11 = AllSummaryReport.findAll("from AllSummaryReport asr where asr.pendingSince >=? and asr.pendingSince <=? and asr.applicationStatus='rejected'   and asr.groupId=?  order by asr.pendingSince desc",[sqlDate,sqlDate2,dealGroup])
		  }
		  }	
	}
		if(c11.size()==0)
		  {	
		  flash.message="No applications of this type is Rejected yet"
		  }
			 }
		  def grp = GroupMaster.findAll()	
		  render(view:'rejectedApplicationSearch',model:[start_date:startDate1,end_date:endDate1,indList:c11,grp:grp])
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

def grantedApplicationSearchBMW = {
		  try {
			 def grp = GroupMaster.findAll()
			  	return[grp:grp]
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
	  	 
def grantApplicationSearchBMW ={
		  try {
			 def industryType1
	  		    def startDate1 = params.start_date_value
	  			def endDate1 = params.end_date_value
	  			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
	  			def x = sdfh.parse(startDate1); //Date
	  			def y = sdfh.parse(endDate1);
	  			def c
	  			def d
	  			def appFor
	  			def bioList=null
	  			def municipalList=null
	  			def hazardeousList=null
	  			industryType1=params.industryType.toString()
	  			def certFor
	  			def app
	  			app=params.applicationType;
	  			certFor=params.certificateFor;
	  			def allApprovedApp = new ArrayList()
	  			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
	  			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
	  			sqlDate2.setDate((sqlDate2.getDate()+1))
	  			if(startDate1 && endDate1 && industryType1 == "None" && certFor == "None")
	  				{
	  					bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = 'approved' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.dateCreated desc",[sqlDate,sqlDate2])
	  					municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = 'approved' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.dateCreated desc",[sqlDate,sqlDate2])
	  					 hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = 'approved' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.dateCreated desc",[sqlDate,sqlDate2])
	  				}
	  			else if(startDate1 && endDate1 && industryType1 != "None" && certFor == "None")
	  			   {
	  				    if(industryType1=="industry"){
	  				hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = 'approved' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.dateCreated desc",[sqlDate,sqlDate2])
	  			  }
	  				    else if(industryType1=="bmw"){
	  					bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = 'approved' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.dateCreated desc",[sqlDate,sqlDate2])
	  				    }
	  				    else if(industryType1=="localBody"){
	  					 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = 'approved' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.dateCreated desc",[sqlDate,sqlDate2])
	  			 }
	  			}
	else if(startDate1 && endDate1 && industryType1 == "None" && certFor != "None")
	  			   {
	  				 if(certFor=="new"){
	  				    	bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = 'approved' and authorizationType='FreshApplication' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.dateCreated desc",[sqlDate,sqlDate2])
	  				        hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = 'approved' and hwa.is_Renew='fresh' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.dateCreated desc",[sqlDate,sqlDate2])
	  				        municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = 'approved' and authorizationType='FreshApplication' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.dateCreated desc",[sqlDate,sqlDate2])
	  				        }
	  				     else{
	  				    	bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = 'approved' and authorizationType='RenewalApplication' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.dateCreated desc",[sqlDate,sqlDate2])
	  				        hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = 'approved' and hwa.is_Renew='renew' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.dateCreated desc",[sqlDate,sqlDate2])
	  				        municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = 'approved' and authorizationType='RenewalApplication' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.dateCreated desc",[sqlDate,sqlDate2])
	  				        }
	  			}
	  		else if(startDate1 && endDate1 && industryType1 != "None" && certFor != "None")
	  			   {
	  				    if(industryType1=="industry"){
	  					if(certFor=="new"){
	  				        hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = 'approved' and hwa.is_Renew='fresh' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.dateCreated desc",[sqlDate,sqlDate2])
	  				        }
	  				     else{
	  				        hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus = 'approved' and hwa.is_Renew='renew' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.dateCreated desc",[sqlDate,sqlDate2])	
	  				        }
	  			  }
	  				    else if(industryType1=="bmw"){
	  						if(certFor=="new"){
	  				    		bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = 'approved' and authorizationType='FreshApplication' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.dateCreated desc",[sqlDate,sqlDate2])
	  					        }
	  					     else{
	  					    	 bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus = 'approved' and authorizationType='RenewalApplication' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.dateCreated desc",[sqlDate,sqlDate2])	
	  					        }
	  				 }
	  				    else if(industryType1=="localBody"){
	  						if(certFor=="new"){
	  				    		municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = 'approved' and authorizationType='FreshApplication' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.dateCreated desc",[sqlDate,sqlDate2])
	  					        }
	  					     else{
	  					    	 municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus = 'approved' and authorizationType='RenewalApplication' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.dateCreated desc",[sqlDate,sqlDate2])	
	  					        }
	  			 }
	  			}
	  			if(!bioList && !municipalList && !hazardeousList)
	  			{  
	  				flash.message="No applications of this type is Granted yet"
	  			} 
	  		 render(view:'grantedApplicationSearchBMW',model:[start_date:startDate1,end_date:endDate1,bioList:bioList,municipalList:municipalList,hazardeousList:hazardeousList])
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
	  	  
 def updateAll={
		  
	  }

def updateAllWMS={
	 
	  render(view:'updateAllWMS')
}
 ////////////////Inspection generated applications///////////////////////////////////////////////////////////   
def inspectionApplicationSearch = {
	 try {
	     def grp = GroupMaster.findAll()
		  		return[grp:grp]
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
	  
def saveinspectApplicationSearch =
	  {
	println("params..."+params)
	try {
		   if(!params.frmDate_value && !params.toDate_value)
	  			{
	  				flash.message="Please Enter Both the Dates"
	  				redirect(action:pendingAppSearch)
	  				return
	  			}
	  		 def allApprovedApp1 = new ArrayList()
	  		 def startDate1 = params.frmDate_value
	  		  def endDate1 = params.toDate_value
	  		  def indList
	  			  def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
	  				def v = sdfh.parse(startDate1); //Date
	  				def y = sdfh.parse(endDate1);
	  				def allApprovedApp = new ArrayList()
	  			java.sql.Date sqlDate = new java.sql.Date(v.getTime())
	  			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
	  			sqlDate2.setDate((sqlDate2.getDate()+1))
	  			if(sqlDate>sqlDate2)
	  			{
	  				flash.message="To Date should be Greater than From Date"
	  				redirect(action:pendingAppSearch)
	  				return
	  			}
	  			//c=ConsentInspectionReport.findAll("from ConsentInspectionReport ind where ind.application.actualApplicationDate >=? and ind.application.actualApplicationDate <=? and ind.application.completionStatus IN ('completed','orphan') order by ind.application.applicationDate desc",[sqlDate,sqlDate2])
	  			indList=ApplicationFileRecord.findAll("from ApplicationFileRecord ind where ind.dateCreated >=? and ind.dateCreated <=? and ind.typeOfFile ='Inspection Report' and ind.indApplication.completionStatus IN ('completed','orphan') order by ind.dateCreated desc",[sqlDate,sqlDate2])
	  		session.indlist=indList
	  			if(!indList)
	  		  {
	  			  flash.message="No Inspection Report is Generated for this search combination"
	  		  }
	  		  render(view:'inspectionApplicationSearch',model:[frmDate:startDate1,toDate:endDate1,indList:indList])
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
def printInspectionlPage = {
	  try {
	def indList=session.indList
return[indList:indList]
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
////////////////////////////////Transfer Pending Applications//////////////////////////////////////
def transferPending={
	println("----"+session.userMaster)
}

def searchByOfficerTransfer={
	 try {
		 println("params.."+params.applicationFor)
		 def officerID=params.transferFrom
		 println("params.."+officerID)
		 if(params.applicationFor=='Consent'){
		 def listAbc=ApplicationPendingDetails.findAll("from ApplicationPendingDetails abc where abc.applicationStatus='pending' and abc.pendingWith.id=?",[officerID])
		 println("params.."+listAbc)
		 if(listAbc){
			 println("params.in CTE and CTO."+listAbc)
			 render(view:'transferPending',model:[listAbc:listAbc])
			 return
		 }
			else{
				flash.message="Please Enter Valid Officer Id"
					redirect(action:transferPending)
					return;
			}
		 }
		 else if(params.applicationFor=='wastemanagement'){
			 def listOfApplication=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wm where wm.applicationStatus='pending' and wm.pendingWith.id=?",[officerID])
			 println("listOfApplication.."+listOfApplication)
			 if(listOfApplication){
				 println("listOfApplication.in BMW and PWM."+listOfApplication)
				 render(view:'transferPending',model:[listWaste:listOfApplication])
				 return
			 }else{
					flash.message="Please Enter Valid Officer Id"
						redirect(action:transferPending)
						return;
				}
		 }
		// render(view:'transferPending',model:[start_date:startDate1,end_date:endDate1,indList:allApprovedApp,grp:grp])
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

def myOfficers ={
	 try { 
		 println("params.myOfficers..."+params)
			def a 
			def dist
			if(params.cont== '9999' ) {
				
				render g.select( width:'10', optionKey:'id',name:'forward', from:dist)
			}
			else {
				a = params.cont
				def grp = GroupMaster.get((a).toLong())
				println("grp..."+grp)
				dist = RoleMaster.findAll("from RoleMaster rm where rm.group=? order by roleDesc asc",[grp])
				println("dist..."+dist)
				render g.select( width:'10', optionKey:'id',name:'forward', from:dist) 
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

def processMultipleAppPending={
	println("Params in processMultipleAppPending ----"+params)
	  def applicationIds = params.multipleForwardApp
	  def wasteApplicationIds=params.multipleForwardWasteApp
	  if(applicationIds){
	  def notForwarded = ""
	  def roleFwd = RoleMaster.get((params.forward).toLong())
	  println("Role Forwarded----"+roleFwd.id)
	  println("Class Name-----"+(applicationIds).getClass().getName())
	  if((applicationIds).getClass().getName()== "java.lang.String"){
		  def appProcessing = new ApplicationProcessingDetails()
	  	println("applicationIds[i]--->"+applicationIds)
	  	def application = IndApplicationDetails.get(applicationIds)
	  	def appPendingInst = ApplicationPendingDetails.findByApplication(application)
	  	def appWithRole = appPendingInst.role
	  	println("appWithRole.group.id--->"+appWithRole.group.id)
		  println("roleFwd.group.id-->"+roleFwd.group.id)
	  	if(appWithRole.group.id==roleFwd.group.id){
	  	println("appWithRole====>"+appWithRole)
	  	println("appppp====>"+application)
	  	def user = session.userMaster
	      	
	  	user.refresh()
	  	
	  	appProcessing.application = application
	  	appProcessing.role = appWithRole
	  	appProcessing.officer = user.userProfile.id
	    appProcessing.roleFwd = roleFwd
	    appProcessing.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
	    appProcessing.fileNote=""
	  	appProcessing.inspection=false
	  	appProcessing.inspectionNote=""
	  	appProcessing.inspectionClose=false		
	  	appProcessing.inspectionCloseNote=""
	  	appProcessing.returnNote=""
	  	appProcessing.returned=""
	  	appProcessing.clarificationReplyAttachedFile=false
	  	appProcessing.approve=false
	  	appProcessing.approveNote=""
	  	appProcessing.reject=false
	  	appProcessing.rejectNote=""
	  	appProcessing.approvalStatus=""
	  	appProcessing.dateCreated= new Date()
	  	appProcessing.lastUpdated= new Date()
	  	appProcessing.clarification=false		
	  	appProcessing.clarificationNote=""
	  	appProcessing.attachedFile=false
	    appProcessing.clarificationAttachedFile=false
	  	appProcessing.inspectionAttachedFile=false
	  	appProcessing.inspectionCloseAttachedFile=false
		
		def applicationPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[application])

	  	  applicationPending.role = roleFwd
	  	  applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  	   applicationPending.completionDate = new Date()    //Added by DEEPAK 
	  	 ////////////////////Change in Allsummary///////////////////////////
	  	  def allSummaryInstance=AllSummaryReport.find("from AllSummaryReport abc where abc.applicationId=?",[application.toString()])
	  	println("allSummaryInstance..."+allSummaryInstance)
	  	if(allSummaryInstance){
	  	allSummaryInstance.roleId = roleFwd
	  	allSummaryInstance.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  	}
	  	  if(appProcessing.save()){
	  				println("appProcessing save A")
	  				
	  			}else{
	  				appProcessing.errors.allErrors.each {
	  		        	println it
	  		        	println("appProcessing error A")
	  			}
	  	}
	  	flash.message= "Application is forwarded.";
	  }
	  else{
	  		 notForwarded=""+applicationIds;
	  		 flash.message= notForwarded+" application are not forwarded.";	
	  	}
	 }else{
		 
	    for(int i = 0 ; i<applicationIds.size() ; i++ ){
	  	def appProcessing = new ApplicationProcessingDetails()
	  	println("applicationIds[i]--->"+applicationIds[i])
	  	def application = IndApplicationDetails.get(applicationIds[i])
	  		def appPendingInst = ApplicationPendingDetails.findByApplication(application)
	  	def appWithRole = appPendingInst.role
	  	println("Application with Role====>"+appWithRole)
	  	println("Application====>"+application)
	  	println("appWithRole.group.id====>"+appWithRole.group.id)
	  	println("roleFwd.group.id====>"+roleFwd.group.id)
	  	if(appWithRole.group.id==roleFwd.group.id){
	  	def user = session.userMaster
	      	user.refresh()
	  	
	  	appProcessing.application = application
	  	appProcessing.role = appWithRole
	  	appProcessing.officer = user.userProfile.id
	    appProcessing.roleFwd = roleFwd
	    appProcessing.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
	    appProcessing.fileNote=""
	  	appProcessing.inspection=false
	  	appProcessing.inspectionNote=""
	  	appProcessing.inspectionClose=false		
	  	appProcessing.inspectionCloseNote=""
	  	appProcessing.returnNote=""
	  	appProcessing.returned=""
	  	appProcessing.clarificationReplyAttachedFile=false
	  	appProcessing.approve=false
	  	appProcessing.approveNote=""
	  	appProcessing.reject=false
	  	appProcessing.rejectNote=""
	  	appProcessing.approvalStatus=""
	  	appProcessing.dateCreated= new Date()
	  	appProcessing.lastUpdated= new Date()
	  	appProcessing.clarification=false		
	  	appProcessing.clarificationNote=""
	  	appProcessing.attachedFile=false
	    appProcessing.clarificationAttachedFile=false
	  	appProcessing.inspectionAttachedFile=false
	  	appProcessing.inspectionCloseAttachedFile=false
	  	
	  	def applicationPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[application])

	  		applicationPending.role = roleFwd
	  	    applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  		////////////////////Change in Allsummary///////////////////////////
	  	  def allSummaryInstance=AllSummaryReport.find("from AllSummaryReport abc where abc.applicationId=?",[application.toString()])
	  	println("allSummaryInstance..."+allSummaryInstance)
	  	if(allSummaryInstance){
	  	allSummaryInstance.roleId = roleFwd
	  	allSummaryInstance.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  	}
	  	    if(appProcessing.save()){
	  			  println("appProcessing save B")
	  		}else{
	  				appProcessing.errors.allErrors.each {
	  		        println it
	  		        println("appProcessing error B")
	  			}
	     }
	  	flash.message= "Applications are forwarded.";
	 }
	 else{
	  		
		 if(notForwarded==""){
	  		notForwarded=""+applicationIds[i];
	  		
	  		}else{
	  			notForwarded=notForwarded+","+applicationIds[i];
	  			 flash.message= notForwarded+" application are not forwarded.";
	  			
	  		  }
	  	  }
	   }
    }
	     redirect(controller:'userMaster',action:'transferPending')
  }else if(wasteApplicationIds){
	  println("--invoked--in Waste-")
	  def notForwarded1 = ""
	  def roleFwd1 = RoleMaster.get((params.forward).toLong())
	  println("Role Forwarded----"+roleFwd1.id)
	  println("Class Name-----"+(wasteApplicationIds).getClass().getName())
	  if(wasteApplicationIds.getClass().getName()== "java.lang.String"){
		  def wastePending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=? ",[wasteApplicationIds.toString()])
		  println("-----wastePending-----"+wastePending)
		  if(wastePending.applicationFor=='BMW'|| wastePending.applicationFor=='HWM'){
			  println("---Invoked inside BMW----")
			  def wasteApplicationInstance
			  if(wastePending.applicationFor=='BMW'){
			  wasteApplicationInstance= BioMedicalWaste.get(wastePending.applicationId.toLong())
			  }else if(wastePending.applicationFor=='HWM'){
				  wasteApplicationInstance=HazardeousWasteAuthApp.get(wastePending.applicationId.toLong())
			  }
			  def wasteManagementProcessing=new WasteManagementProcessingDetails()
			  if(roleFwd1.group.id==wastePending.role.group.id){
			  def user = session.userMaster
	      	user.refresh()
	      	 println("---Invoked inside if group Matched----")
			  wasteManagementProcessing.dateCreated=new Date()
			  wasteManagementProcessing.lastUpdated=new Date()
			  wasteManagementProcessing.role=wastePending.role
			  wasteManagementProcessing.officer=user.userProfile.id
			  wasteManagementProcessing.roleFwd=roleFwd1
			  wasteManagementProcessing.officerFwd=(RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee.id
			  wasteManagementProcessing.fileNote=""
			  wasteManagementProcessing.clarification=false
			  wasteManagementProcessing.clarificationNote=""
			  wasteManagementProcessing.inspection=false
			  wasteManagementProcessing.inspectionNote=""
			  wasteManagementProcessing.inspectionClose=false
			  wasteManagementProcessing.inspectionCloseNote=""
			  wasteManagementProcessing.approve=false
			  wasteManagementProcessing.approveNote=""
			  wasteManagementProcessing.reject=false
			  wasteManagementProcessing.attachedFile=false
			  wasteManagementProcessing.rejectNote=""
			  wasteManagementProcessing.applicationId=String.valueOf(wasteApplicationInstance.id)
			  wasteManagementProcessing.applicationFor=wastePending.applicationFor
			  wasteManagementProcessing.clarificationAttachedFile=false
			  wasteManagementProcessing.clarificationReplyAttachedFile=false
			  wasteManagementProcessing.inspectionAttachedFile=false
			  wasteManagementProcessing.inspectionCloseAttachedFile=false
			  wasteManagementProcessing.approvalStatus=""
			  wasteManagementProcessing.clarificationDays=""

				  	//def applicationPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[application])

				  		wastePending.role = roleFwd1
				  		wastePending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee)
				  		////////////////////Change in Allsummary///////////////////////////
				  	  def allSummaryInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS abc where abc.applicationId=?",[wasteApplicationIds.toString()])
				  	println("allSummaryInstance..."+allSummaryInstance)
				  	if(allSummaryInstance){
				  	allSummaryInstance.roleId = roleFwd1
				  	allSummaryInstance.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee)
				  	}
				  	    if(wasteManagementProcessing.save()){
				  			  println("wasteManagementProcessing save B")
				  		}
				  	    
			  else{
				  wasteManagementProcessing.errors.allErrors.each {
		  		        println it
		  		        println("wasteManagementProcessing error B")
		  			}
		     }
				  	  flash.message= "Application are forwarded.";
			  }else{
				  flash.message= "Application are not forwarded.";
			  }
		  }
		  
	  }else{
		  for(int i = 0 ; i<wasteApplicationIds.size() ; i++){

			  def wastePending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=? ",[wasteApplicationIds[i]])
			  println("-----wastePending-----"+wastePending)
			  if(wastePending.applicationFor=='BMW'|| wastePending.applicationFor=='HWM'){
				  println("---Invoked inside BMW----")
				  def wasteApplicationInstance
				  if(wastePending.applicationFor=='BMW'){
				  wasteApplicationInstance= BioMedicalWaste.get(wastePending.applicationId.toLong())
				  }else if(wastePending.applicationFor=='HWM'){
					  wasteApplicationInstance=HazardeousWasteAuthApp.get(wastePending.applicationId.toLong())
				  }
				  def wasteManagementProcessing=new WasteManagementProcessingDetails()
				  if(roleFwd1.group.id==wastePending.role.group.id){
				  def user = session.userMaster
		      	user.refresh()
		      	 println("---Invoked inside if group Matched----")
				  wasteManagementProcessing.dateCreated=new Date()
				  wasteManagementProcessing.lastUpdated=new Date()
				  wasteManagementProcessing.role=wastePending.role
				  wasteManagementProcessing.officer=user.userProfile.id
				  wasteManagementProcessing.roleFwd=roleFwd1
				  wasteManagementProcessing.officerFwd=(RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee.id
				  wasteManagementProcessing.fileNote=""
				  wasteManagementProcessing.clarification=false
				  wasteManagementProcessing.clarificationNote=""
				  wasteManagementProcessing.inspection=false
				  wasteManagementProcessing.inspectionNote=""
				  wasteManagementProcessing.inspectionClose=false
				  wasteManagementProcessing.inspectionCloseNote=""
				  wasteManagementProcessing.approve=false
				  wasteManagementProcessing.approveNote=""
				  wasteManagementProcessing.reject=false
				  wasteManagementProcessing.attachedFile=false
				  wasteManagementProcessing.rejectNote=""
				  wasteManagementProcessing.applicationId=String.valueOf(wasteApplicationInstance.id)
				  wasteManagementProcessing.applicationFor=wastePending.applicationFor
				  wasteManagementProcessing.clarificationAttachedFile=false
				  wasteManagementProcessing.clarificationReplyAttachedFile=false
				  wasteManagementProcessing.inspectionAttachedFile=false
				  wasteManagementProcessing.inspectionCloseAttachedFile=false
				  wasteManagementProcessing.approvalStatus=""
				  wasteManagementProcessing.clarificationDays=""

					  	//def applicationPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[application])

					  		wastePending.role = roleFwd1
					  		wastePending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee)
					  		////////////////////Change in Allsummary///////////////////////////
					  	  def allSummaryInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS abc where abc.applicationId=?",[wasteApplicationIds[i].toString()])
					  	println("allSummaryInstance..."+allSummaryInstance)
					  	if(allSummaryInstance){
					  	allSummaryInstance.roleId = roleFwd1
					  	allSummaryInstance.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd1)).primaryEmployee)
					  	}
					  	    if(wasteManagementProcessing.save()){
					  			  println("wasteManagementProcessing save B")
					  		}
				  else{
					  wasteManagementProcessing.errors.allErrors.each {
			  		        println it
			  		        println("wasteManagementProcessing error B")
			  			}
			     }
					  	  flash.message= "Applications are forwarded.";
				  }else{
					  flash.message= "Applications are not forwarded.";
				  }
			  }
			  
		  
		  }
	  }
	  
	  redirect(controller:'userMaster',action:'transferPending')
  }
	  else{
		  flash.message="Please Select applications to Transfer"
				redirect(action:transferPending)
				return;  
	  }
}
////////////////////////////////Transfer Pending Applications//////////////////////////////////////
def transferCompleted={
	
}
def searchByOfficerTransferCompleted={
	 try {
		 println("params.."+params)
		 def officerID=params.transferFrom
		 println("params.."+officerID)
		 def listAbc=ApplicationPendingDetails.findAll("from ApplicationPendingDetails abc where (abc.applicationStatus='approved' or abc.applicationStatus='rejected') and abc.pendingWith.id=?",[officerID])
		 println("params.."+listAbc)
		 if(listAbc){
			 render(view:'transferCompleted',model:[listAbc:listAbc])
			 return
		 }
			else{
				flash.message="Please Enter Valid Officer Id"
					redirect(action:transferCompleted)
					return;
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
def processMultipleAppCompleted={
	println("Params in processMultipleApp ----"+params)
	  def applicationIds = params.multipleForwardApp
	  if(applicationIds){}else{
		  flash.message="Please Select applications to Transfer"
				redirect(action:transferCompleted)
				return;  
	  }
	  def notForwarded = ""
	  def roleFwd = RoleMaster.get((params.forward).toLong())
	  println("Role Forwarded----"+roleFwd.id)
	  println("Class Name-----"+(applicationIds).getClass().getName())
	  if((applicationIds).getClass().getName()== "java.lang.String"){
		  def appProcessing = new ApplicationProcessingDetails()
	  	println("applicationIds[i]--->"+applicationIds)
	  	def application = IndApplicationDetails.get(applicationIds)
	  	def appPendingInst = ApplicationPendingDetails.findByApplication(application)
	  	def appWithRole = appPendingInst.role
	  	println("appWithRole.group.id--->"+appWithRole.group.id)
		  println("roleFwd.group.id-->"+roleFwd.group.id)
	  	if(appWithRole.group.id==roleFwd.group.id){
	  	println("appWithRole====>"+appWithRole)
	  	println("appppp====>"+application)
	  	def user = session.userMaster
	      	
	  	user.refresh()
	  	
	  	appProcessing.application = application
	  	appProcessing.role = appWithRole
	  	appProcessing.officer = user.userProfile.id
	    appProcessing.roleFwd = roleFwd
	    appProcessing.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
	    appProcessing.fileNote="Manually Transfer by officer"
	  	appProcessing.inspection=false
	  	appProcessing.inspectionNote=""
	  	appProcessing.inspectionClose=false		
	  	appProcessing.inspectionCloseNote=""
	  	appProcessing.returnNote=""
	  	appProcessing.returned=""
	  	appProcessing.clarificationReplyAttachedFile=false
	  	appProcessing.approve=false
	  	appProcessing.approveNote=""
	  	appProcessing.reject=false
	  	appProcessing.rejectNote=""
	  	appProcessing.approvalStatus=""
	  	appProcessing.dateCreated= new Date()
	  	appProcessing.lastUpdated= new Date()
	  	appProcessing.clarification=false		
	  	appProcessing.clarificationNote=""
	  	appProcessing.attachedFile=false
	    appProcessing.clarificationAttachedFile=false
	  	appProcessing.inspectionAttachedFile=false
	  	appProcessing.inspectionCloseAttachedFile=false
		
		def applicationPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[application])

	  	  applicationPending.role = roleFwd
	  	  applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  	 ////////////////////Change in Allsummary///////////////////////////
	  	  def allSummaryInstance=AllSummaryReport.find("from AllSummaryReport abc where abc.applicationId=?",[application.toString()])
	  	println("allSummaryInstance..."+allSummaryInstance)
	  	if(allSummaryInstance){
	  	allSummaryInstance.roleId = roleFwd
	  	allSummaryInstance.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  	}
	  	  if(appProcessing.save()){
	  				println("appProcessing save A")
	  				
	  			}else{
	  				appProcessing.errors.allErrors.each {
	  		        	println it
	  		        	println("appProcessing error A")
	  			}
	  	}
	  	flash.message= "Application is forwarded.";
	  }
	  else{
	  		 notForwarded=""+applicationIds;
	  		 flash.message= notForwarded+" application are not forwarded.";	
	  	}
	 }else{
		 
	    for(int i = 0 ; i<applicationIds.size() ; i++ ){
	  	def appProcessing = new ApplicationProcessingDetails()
	  	println("applicationIds[i]--->"+applicationIds[i])
	  	def application = IndApplicationDetails.get(applicationIds[i])
	  		def appPendingInst = ApplicationPendingDetails.findByApplication(application)
	  	def appWithRole = appPendingInst.role
	  	println("Application with Role====>"+appWithRole)
	  	println("Application====>"+application)
	  	println("appWithRole.group.id====>"+appWithRole.group.id)
	  	println("roleFwd.group.id====>"+roleFwd.group.id)
	  	if(appWithRole.group.id==roleFwd.group.id){
	  	def user = session.userMaster
	      	user.refresh()
	  	
	  	appProcessing.application = application
	  	appProcessing.role = appWithRole
	  	appProcessing.officer = user.userProfile.id
	    appProcessing.roleFwd = roleFwd
	    appProcessing.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
	    appProcessing.fileNote=""
	  	appProcessing.inspection=false
	  	appProcessing.inspectionNote=""
	  	appProcessing.inspectionClose=false		
	  	appProcessing.inspectionCloseNote=""
	  	appProcessing.returnNote=""
	  	appProcessing.returned=""
	  	appProcessing.clarificationReplyAttachedFile=false
	  	appProcessing.approve=false
	  	appProcessing.approveNote=""
	  	appProcessing.reject=false
	  	appProcessing.rejectNote=""
	  	appProcessing.approvalStatus=""
	  	appProcessing.dateCreated= new Date()
	  	appProcessing.lastUpdated= new Date()
	  	appProcessing.clarification=false		
	  	appProcessing.clarificationNote=""
	  	appProcessing.attachedFile=false
	    appProcessing.clarificationAttachedFile=false
	  	appProcessing.inspectionAttachedFile=false
	  	appProcessing.inspectionCloseAttachedFile=false
	  	
	  	def applicationPending = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[application])

	  		applicationPending.role = roleFwd
	  	    applicationPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  		////////////////////Change in Allsummary///////////////////////////
	  	  def allSummaryInstance=AllSummaryReport.find("from AllSummaryReport abc where abc.applicationId=?",[application.toString()])
	  	println("allSummaryInstance..."+allSummaryInstance)
	  	if(allSummaryInstance){
	  	allSummaryInstance.roleId = roleFwd
	  	allSummaryInstance.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
	  	}
	  	    if(appProcessing.save()){
	  			  println("appProcessing save B")
	  		}else{
	  				appProcessing.errors.allErrors.each {
	  		        println it
	  		        println("appProcessing error B")
	  			}
	     }
	  	flash.message= "Applications are forwarded.";
	 }
	 else{
	  		
		 if(notForwarded==""){
	  		notForwarded=""+applicationIds[i];
	  		
	  		}else{
	  			notForwarded=notForwarded+","+applicationIds[i];
	  			 flash.message= notForwarded+" application are not forwarded.";
	  			
	  		  }
	  	  }
	   }
    }
	     redirect(controller:'userMaster',action:'transferCompleted')
  }

	def verifyAllByDate = {
        try {
            def sdfh = new SimpleDateFormat("dd/MM/yyyy");
            def x = sdfh.parse(params.start_date_value); //Date
            def y = sdfh.parse(params.end_date_value);  //Date
            java.sql.Date date1 = new java.sql.Date(x.getTime())

            java.sql.Date date2 = new java.sql.Date(y.getTime())
            if (date1 > date2) {
                flash.message = "End Date should be Greater than Starting Date"
                render(view: 'verification')
            } else {
                CheckTrans check = new CheckTrans();
                check.webServiceUpdate(date1, date2);
                flash.message = "Verification Done"
                render(view: 'verification')

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


def pwmIndustryMenuVertical ={
    try {
        render(view: 'pwmIndustryMenuVerticalPage')
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
def eWasteIndustryMenuVertical = {
    try {
        render(view: 'eWasteIndustryMenuVerticalPage')
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

def eWasteEmpMenuVertical = {
    try {
        render(view: 'eWasteEmpMenuVerticalPage')
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

def eWasteAdminMenuVertical = {
    try {
        render(view: 'eWasteAdminMenuVerticalPage')
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

def checkFee={
	
}

def updateFee={
	println("---------"+params)
	
	def applicationNo=params.appId
	def appFor=params.appFor
	if(appFor=='CONSENT'){
	def indApp=IndApplicationDetails.get(applicationNo.toLong())
	def appProcessing=ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails a where a.application=? order by dateCreated desc",[indApp])
	def appPending=ApplicationPendingDetails.findByApplication(indApp)
	if(appProcessing){
		if(appProcessing[0].returned==true && appProcessing[0].resubmitStatus==false && appPending){
			
			appPending.applicationStatus='returned'
			appPending.save()
			flash.message = "Done"+applicationNo;
		}else{
			flash.message="Something went wrong "+appProcessing.returned +"-Status--"+appPending.applicationStatus
		}
		
	}
	}else if(appFor=='BMW'){
		def bioInstance=BioMedicalWaste.get(params.appId.toLong())
		def wastePending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wp where wp.applicationId=? ",[bioInstance.id.toString()])
		def wasteProcess=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails wp where wp.applicationId=? order by dateCreated desc",[bioInstance.id.toString()])
		if(wastePending){
			if(wastePending.applicationStatus=='returned')
			{
				
			}else{
				wastePending.applicationStatus='returned'
				wastePending.save();
			}
			if(wasteProcess)
			{
				if(wasteProcess.returned==true && wasteProcess.resubmitStatus!=true){
					
				}else{
					wasteProcess.returned=true
					wasteProcess.resubmitStatus=false;
					wasteProcess.save();
					flash.message = "Done  "+bioInstance.id.toString();
				}
				
			}
			
		}
	
	}else if(appFor=="backapp"){
		def indApp=IndApplicationDetails.get(applicationNo.toLong())
		def pending=ApplicationPendingDetails.findByApplication(indApp)
		pending.applicationStatus="pending"
			pending.save();
		flash.message = "Done  "+indApp.id.toString();
	}else if(appFor=="aprovedsumm"){
		def indApp=AllSummaryReport.find("from AllSummaryReport where applicationId=?",[applicationNo])
		indApp.applicationStatus='approved';
		indApp.save();
		flash.message = "Done  "+applicationNo;
	}else if(appFor=="rejectedsumm"){
		def indApp=AllSummaryReport.find("from AllSummaryReport where applicationId=?",[applicationNo])
		indApp.applicationStatus='rejected';
		indApp.save();
		flash.message = "Done  "+applicationNo;
	}else if(appFor=="returnsmm"){
		def indApp=AllSummaryReport.find("from AllSummaryReport where applicationId=?",[applicationNo])
		indApp.applicationStatus='returned';
		indApp.save();
		flash.message = "Done  "+applicationNo;
	}else if(appFor=="resubmitcon"){
		def appprocess=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application.id=? order by dateCreated desc",[applicationNo.toLong()])
		if(appprocess){
			if(appprocess.returned==true && appprocess.resubmitStatus==false){
				appprocess.resubmitStatus=true
				appprocess.save();
				flash.message = "Done  "+applicationNo;
			}
		}
		
	}else if(appFor=="routebmw"){
		def applicationn=BioMedicalWaste.get(applicationNo.toLong())
		    RouteWasteManagement routeWaste=new RouteWasteManagement()
			def routed=routeWaste.routeWasteManagementApp(applicationn.id,"BMW",applicationn.industryRegMasterObj)
	    	updateAllSummaryReportWMS((indApplicationDetailsInstance.id).toString());
		
	}
	
	render(view:'checkFee')
}
def recentAppl1={
	println("recentAppl1--------"+session.userMaster)
	if(!session.userMaster)
        {
            redirect(uri:"/index.gsp")
        }
	def listFinalIND=new ArrayList()
	def listFinalDate= new ArrayList()
	def avv= new ArrayList()
	def avv1=new ArrayList()
	def avv18=new ArrayList()
	def avv2=new ArrayList()
	def aa = session.userMaster
    def offStr=(aa.id).toString()
   //def nis=ApplicationProcessingDetails.executeQuery("Select distinct app.application from ApplicationProcessingDetails app WHERE app.officerFwd=? and app.application.id IN (Select application.id from ApplicationPendingDetails ap where ap.applicationStatus='pending' and ap.pendingWith.id=?)" ,[offStr,offStr],[max: 10]);
	//println("=nis========="+nis)
	 def newNis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet WHERE   appPendDet.pendingWith= ? and appPendDet.applicationStatus= 'pending' and appPendDet.completionStatus!='Completed'  order by appPendDet.application.applicationDate desc" ,[aa],[max: 10]);
	println("=newNis========="+newNis)
	if(newNis){
	for(int i=0;i<newNis.size;i++){
		def indobj=newNis[i].application
		avv.add(indobj)
	}
}
println("=avv========="+avv)
/*if(nis){
	for(int i=0;i<nis.size();i++){
		def indOj=nis[i]
		avv1.add(indOj)
	}
}*/
avv2.addAll(avv)
//avv2.addAll(avv1)
avv2.addAll(avv18)
avv2.unique()
println("avv======"+avv2)
def uss=session.userMaster
//session.moduleName="OCMMS"
render(view:'recentAppl',model:[listFinalIND:avv2,listFinalDate:listFinalDate])

}
def authApplicationSearch = {
    def grp = GroupMaster.findAll()
	println("in grantedApplicationSearch.............kaviiiiiiiiiiiiiiiiiiiiiiiiiiiii...................")
	return[grp:grp]
}
/**
 * @Created By:VINEET KUMAR RAGHAV
 * @Created Date:06/03/2017
 * @Purpose:downLoading industryHome method 
 * @Return:statusReturn arrayList
 * ****/
   def authorizationreportsearch=
     {  
   try {
	   println("searchOp--"+params.searchOp+"------"+params.autocomplete_parameter)
	   if(params.searchOp=='ApplId'){
		   def applicationw
		   def applicationFor
		   def applicationPending= WasteManagementPendingDetails.find("from WasteManagementPendingDetails w where w.applicationId=? ",[params.autocomplete_parameter])
		   if(!applicationPending){
			   flash.message="NO record found"
			   render(view:'authApplicationSearch')
			   return;
		   }
		   println("--applicationPending.applicationId--"+applicationPending.applicationFor)
		   if(applicationPending.applicationFor=='HWM'){
			   applicationw=HazardeousWasteAuthApp.get(applicationPending.applicationId.toLong())
			   applicationFor=applicationw.is_Renew
			}else if(applicationPending.applicationFor=='BMW'){
				println("-Inside in Admin--34--")
				applicationw=BioMedicalWaste.get(applicationPending.applicationId.toLong())
				applicationFor=applicationw.authorisationAppliedFor
			}else if(applicationPending.applicationFor=='PWM'){
				println("-Inside in Admin--")
				applicationw=PlasticWaste.find("from PlasticWaste  where id=?",[applicationPending.applicationId.toLong()])
				println("-Inside in Admin--"+applicationw)
				applicationFor=applicationw.authorisationAppliedFor
			}else{
						flash.message="NO record found for application"
	    			   render(view:'authApplicationSearch')
	    			   return;
			}
		   
		   println("----application-----"+applicationw)
		   render(view:'authApplicationSearch',model:[applicationw:applicationw,applicationFor:applicationFor])
		   
	   }else{
	   println("PARAMS IN authorizationreportsearch---"+params)
        def startDate1=params.start_date_value
        def endDate1=params.end_date_value
        def status=params.status
        def group=params.group
        def appFor=params.appFor
        ArrayList allSummaryReportWMSList=new ArrayList()
        def x
        def y
        def sdfh = new SimpleDateFormat("dd/MM/yyyy");
        x = sdfh.parse(startDate1);
        y = sdfh.parse(endDate1);
        java.sql.Date sqlDate = new java.sql.Date(x.getTime())
        java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())
        java.sql.Date sqlDate3 = new java.sql.Date(y.getTime())
        sqlDate2.setDate((sqlDate2.getDate()+1))
        def category=params.category;
        def districtId=params.districtId;
        String query="";
        if(params.status =='approved')
        {
        	 query="From AllSummaryReportWMS abc where abc.pendingSince >= '"+sqlDate+"' and abc.pendingSince <= '"+sqlDate2+"' ";
        }else
        {
        	 query="From AllSummaryReportWMS abc where abc.authDate >= '"+sqlDate+"' and abc.authDate <= '"+sqlDate2+"' ";
        }
        if(params.status !='All')
        {
        	query=query+" and abc.applicationStatus ='"+params.status+"'";
        } 
        if(params.appFor !='101')
        {
        	query=query+" and abc.applicationFor='"+params.appFor+"'";
        }
        if(params.districtId !='NotSelected')
        {
        	query=query+" and abc.districtName='"+params.districtId+"'";
        }
        
        if(params.status =='All' && params.appFor =='101' && params.districtId =='NotSelected' && params.category =='101' )
        {
        	query=query;
        }
        query=query+" order by abc.authDate desc ";
        println("==query======="+query)
        allSummaryReportWMSList=AllSummaryReportWMS.findAll(query);
        println("allSummaryReportWMSList========="+allSummaryReportWMSList)
        session.sqlDate=sqlDate
        session.sqlDate2=sqlDate2
        session.status=status
        session.appFor=appFor
        session.districtId=districtId
        session.category=category
        session.allSummaryReportWMSList=allSummaryReportWMSList
        
        if(sqlDate>sqlDate2)
        {
            flash.message="End Date should be Greater than or Equal to Start Date"
            render(view:'authApplicationSearch')
        }
        else
        {
        	if(allSummaryReportWMSList.size() == 0)
        	{
        		flash.message="No Record Found"
                render(view:'authApplicationSearch')
                return
        	}else
        	{
        		render(view:'authApplicationSearch',model:[sqlDate3:sqlDate3,status:status,group:group,appFor:appFor,sqlDate:sqlDate,sqlDate2:sqlDate2,allSummaryReportWMSList:allSummaryReportWMSList,districtId:districtId,category:category])
        	}
            
        }
     }}catch(Exception e) {
            e.printStackTrace();
            flash.message = "Server Busy ..Please try after some time....";
            if(session.indUser)
            {
            redirect(controller:'indUser',action:'openIndustryHome')
            }else if(session.userMaster){
            redirect(controller:'userMaster',action:'openSpcbHome');
            }else{
            session.invalidate()
            redirect(uri:'/index.gsp');
        }
     }
 }
def viewCertificateWaste={
	def singleInstanceOfApplicationDocument=WasteManagementCertificates.get(params.id.toLong())
	response.setContentType( "application-xdownload")
	 response.setHeader("Content-Disposition","attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"" )
	response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
}


def revertApplication = {
	
}
// --------------------------   Scrutiny Completed Appication revert code Start by Deepak---------------------
def scruAppSubmit = {
try {
	println("params scruAppSubmit "+params)
	
	def applcationPendingDetails=ApplicationPendingDetails.find("from ApplicationPendingDetails where completionStatus='Completed' and scrutinyStatus='Complete' and application.id = ? order by id desc limit 1",[(params.autocomplete_parameter).toLong()])
	  println("applcationPendingDetails:"+applcationPendingDetails)
		
		applcationPendingDetails.scrutinyStatus=""
		applcationPendingDetails.completionStatus="" 
			if(applcationPendingDetails.save()){
				println("data saved")
				def applcationProcessingDetails=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where scrutinyStatus='Complete' and application.id = ? order by id desc limit 1",[(params.autocomplete_parameter).toLong()])
				println("applcationProcessingDetails:"+applcationProcessingDetails)
				applcationProcessingDetails.delete()
				println("Application Deleted")
				flash.message = "Status updated "
					redirect(action:revertApplication)
            }
          	else{
          		println("Data not saved")
  					redirect(action:revertApplication)
          		applcationPendingDetails.errors.each {
			    	println it
			  }
		  }

} catch (Exception e) {
e.printStackTrace();
flash.message = "Server is busy , please try after sometime";
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

def revertWasteApplication = {
	
}

def scruWasteAppSubmit = {

println("params "+params)
def applcationPendingDetails=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where completionStatus='Completed' and scrutinyStatus='Complete' and applicationId = ? order by id desc limit 1",[(params.autocomplete_parameter).toString()])
println("applcationPendingDetails-----"+applcationPendingDetails)
	if(applcationPendingDetails){
	applcationPendingDetails.scrutinyStatus=""
	applcationPendingDetails.completionStatus="" 
		if(applcationPendingDetails.save()){
			def applcationProcessingDetails=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where scrutinyStatus='Complete' and applicationId = ? order by id desc limit 1",[(params.autocomplete_parameter).toString()])
			applcationProcessingDetails.delete()
			flash.message = "Status updated "
				redirect(action:revertWasteApplication)
        }
      	else{
					redirect(action:revertApplication)
      		applcationPendingDetails.errors.each {
		    	println it
		  }
	  }
	
}



}

//--------------------------   Scrutiny Completed Appication revert end end by Deepak---------------------

//--------------------------   Scrutiny In-Completed Appication revert Start Start by Deepak---------------------


	  def revertInCompleteApplication = {
			
	  }
	  
	  def scruInCompleteAppSubmit = {
			try {
				println("params scruInCompleteAppSubmit:"+params)
				def applcationPendingDetails=ApplicationPendingDetails.find("from ApplicationPendingDetails where completionStatus='In-Complete' and scrutinyStatus='In-Complete' and application.id = ? order by id desc limit 1",[(params.autocomplete_parameter).toLong()])
				  println("applcationPendingDetails:---"+applcationPendingDetails)
					applcationPendingDetails.applicationStatus="pending"
					applcationPendingDetails.scrutinyStatus=""
					applcationPendingDetails.scrutinyStatus=""
					applcationPendingDetails.completionStatus="" 
						if(applcationPendingDetails.save()){
							println("data is saved")
							def applcationProcessingDetails=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where scrutinyStatus='In-Complete' and application.id = ? order by id desc limit 1",[(params.autocomplete_parameter).toLong()])
							println("applcationProcessingDetails:"+applcationProcessingDetails)
							if(applcationProcessingDetails){
							applcationProcessingDetails.delete()
							flash.message = "Status updated "
		    					redirect(action:revertInCompleteApplication)
						}
			              }
			            	else{
			            		println("data is not saved")
			    					redirect(action:revertInCompleteApplication)
			            		applcationPendingDetails.errors.each {
						    	println it
						  }
					  }
					
				
				
				    //flash.message = "Status updated "
					//redirect(action:revertInCompleteApplication)
} catch (Exception e) {
	 e.printStackTrace();
     flash.message = "Server is busy , please try after sometime";
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

//--------------------------   Scrutiny In-Completed Appication revert end Start by Deepak---------------------


	  def compledApplication = {
	   
	
	  }
  
  def scruAppComplet = {
	try {
		println("params scruAppComplet "+params)
		println("params scruAppComplet "+(params.autocomplete_parameter).getClass().getName())
		def applcationPendingDetails=ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id = ? order by id desc limit 1",[(params.autocomplete_parameter).toLong()])
		  println("applcationPendingDetails:"+applcationPendingDetails)
			if(applcationPendingDetails){
				  println("applcationPendingDetails----if")
				 render(view:'scruAppComplet',model:[applcationPendingDetails:applcationPendingDetails])
			}else{
			        flash.message="No record found."
		            render(view:'scruAppComplet') 
		        }
				
} catch (Exception e) {
 e.printStackTrace();
 flash.message = "Server is busy , please try after sometime";
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

def updateScruAppComplet = {
	
	println("params scruAppComplet "+params)
	try {
		println("params scruAppComplet "+params)
		println("params scruAppComplet "+(params.surroundingName).getClass().getName())
		def applcationPendingDetails=ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id = ? order by id desc limit 1",[(params.surroundingName).toLong()])
		  println("applcationPendingDetails:"+applcationPendingDetails)
		  
			if(applcationPendingDetails){
				
				  applcationPendingDetails.completionStatus ="Complete"
			      applcationPendingDetails.scrutinyStatus ="Complete"
				  
			    	  if(applcationPendingDetails.save()){
							println("data saved")
							
							flash.message = "Status updated "
		    					redirect(action:compledApplication)
			              }
			            	else{
			            		println("Data not saved")
			    					redirect(action:compledApplication)
			            		applcationPendingDetails.errors.each {
						    	println it
						  }
					  }
				
				 
			}else{
			        flash.message="No record found."
		            render(view:'scruAppComplet') 
		        }
				
} catch (Exception e) {
 e.printStackTrace();
 flash.message = "Server is busy , please try after sometime";
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


def insIssue = {
	   
	
}

def scruAppCompletIns = {
try {
	println("params scruAppCompletIns "+params)
	println("params scruAppCompletIns "+(params.autocomplete_parameter).getClass().getName())
	def applcationPendingDetails=IndApplicationDetails.find("from IndApplicationDetails where id = ? order by id desc limit 1",[(params.autocomplete_parameter).toLong()])
	  println("applcationPendingDetails:"+applcationPendingDetails)
		if(applcationPendingDetails){
			  println("applcationPendingDetails----if")
			  applcationPendingDetails.inspection=false;
			  applcationPendingDetails.save();
			  
			 render(view:'insIssue',model:[applcationPendingDetails:applcationPendingDetails])
		}else{
		        flash.message="No record found."
	            render(view:'insIssue') 
	        }
			
} catch (Exception e) {
e.printStackTrace();
flash.message = "Server is busy , please try after sometime";
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

public boolean updateAllSummaryReportWMS(String AppId){

    try
    {
    	String appliId = AppId.toString()	
    	
    def allSummaryReportWMSInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[AppId.toString()]);
	if(!allSummaryReportWMSInstance)
	{
    		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
       String userInput = "01/01/1950";
     Date defaulDate = formatter1.parse(userInput);
     def authFor = "" 
     def bioInst = BioMedicalWaste.get((AppId).toLong())
     println("bioInst----"+bioInst)
     if(bioInst){
    	 if(bioInst.authorizationType)
    	 authFor = bioInst.authorizationType
    	 else
    		 authFor = bioInst.authorisationAppliedFor	 
     }
    	def WasteMgmtPendDetInstance=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId = ? ",[(AppId).toString()]);
    		if(WasteMgmtPendDetInstance)
		{
			
		def aPDInstance=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? and officer!=? and officerFwd=? order by dateCreated desc limit 1",[WasteMgmtPendDetInstance.applicationId,WasteMgmtPendDetInstance.pendingWith.id,WasteMgmtPendDetInstance.pendingWith.id]);
		def roleFwd=WasteMgmtPendDetInstance.role;
		def indRegMasterInstance=WasteMgmtPendDetInstance.indRegInstance
		allSummaryReportWMSInstance=new AllSummaryReportWMS();
		allSummaryReportWMSInstance.applicationId=(WasteMgmtPendDetInstance.applicationId).toString()
		allSummaryReportWMSInstance.indRegMasterId=(indRegMasterInstance.id).toString()
		allSummaryReportWMSInstance.applicationName=indRegMasterInstance.indName
		allSummaryReportWMSInstance.districtId=(indRegMasterInstance.district.id).toString()
		allSummaryReportWMSInstance.districtName=indRegMasterInstance.district.districtName
		allSummaryReportWMSInstance.roleId=(roleFwd.id).toString();
		allSummaryReportWMSInstance.categoryName=indRegMasterInstance.category.name
		println("--Category--"+indRegMasterInstance.category.id)
		allSummaryReportWMSInstance.categoryId=indRegMasterInstance.category.id
		//allSummaryReportWMSInstance.industryUnit=indRegMasterInstance.industryUnit
		allSummaryReportWMSInstance.roleName=roleFwd.roleName;
		allSummaryReportWMSInstance.groupId=(roleFwd.group.id).toString()
		allSummaryReportWMSInstance.groupName=roleFwd.group.groupName
		allSummaryReportWMSInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
		allSummaryReportWMSInstance.applicationFor=WasteMgmtPendDetInstance.applicationFor
		allSummaryReportWMSInstance.authorizationtype = authFor
		allSummaryReportWMSInstance.applicationStatus=WasteMgmtPendDetInstance.applicationStatus
		allSummaryReportWMSInstance.recieptDate=WasteMgmtPendDetInstance.dateCreated;
		
		allSummaryReportWMSInstance.industryTypeId=indRegMasterInstance.industryType.id.toString();
		allSummaryReportWMSInstance.industryTypeName=indRegMasterInstance.industryType.industryType;
		allSummaryReportWMSInstance.industryAddress=indRegMasterInstance.indAddress;
		allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith.id
	    allSummaryReportWMSInstance.dateCreated=WasteMgmtPendDetInstance.dateCreated
	    allSummaryReportWMSInstance.scrutinyStatus=""
	  	allSummaryReportWMSInstance.indCapInvt=(indRegMasterInstance.indCapInvt).toString()
		def ind_ins=IndUser.find("from IndUser where industryRegMaster=?  order by dateCreated desc limit 1",[indRegMasterInstance]);
		if(ind_ins) 
	        allSummaryReportWMSInstance.indId=ind_ins.id
	      else
	        allSummaryReportWMSInstance.indId=""
			allSummaryReportWMSInstance.clarificationDate=defaulDate;
			allSummaryReportWMSInstance.refusedDate=defaulDate;
			allSummaryReportWMSInstance.returnedDate=defaulDate;
			allSummaryReportWMSInstance.dateOfIssue=defaulDate;
			allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
			allSummaryReportWMSInstance.authDate=WasteMgmtPendDetInstance.dateCreated;
		
		if(aPDInstance)
		  allSummaryReportWMSInstance.pendingSince=aPDInstance.lastUpdated
		else
		  allSummaryReportWMSInstance.pendingSince=WasteMgmtPendDetInstance.dateCreated		  
		allSummaryReportWMSInstance.pendingWith=(WasteMgmtPendDetInstance.pendingWith).toString()
		
		if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true)) 
		{
			println("in updateAllSummaryReportWMS-saved----"+allSummaryReportWMSInstance)	
		}
		
		else {
			println("in updateAllSummaryReportWMS--not--saved----"+AppId)	
			allSummaryReportWMSInstance.errors.each {
		        println it
			}
		}	
	 }
   }
	else
	{
		println("in updateAllSummaryReportWMS--inst already----")	
		def WasteMgmtPendDetInstance=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId = ? ",[(appliId).toString()]);	
    	def roleFwd=WasteMgmtPendDetInstance.role;
    	def indRegMasterInstance=WasteMgmtPendDetInstance.indRegInstance
    	 def authFor = ""
    	def bioInst = BioMedicalWaste.get((appliId).toLong())
         println("bioInst----"+bioInst)
         if(bioInst){
        	 if(bioInst.authorizationType)
        	 authFor = bioInst.authorizationType
        	 else
        		 authFor = bioInst.authorisationAppliedFor	 
         }
    	
		allSummaryReportWMSInstance.applicationStatus=WasteMgmtPendDetInstance.applicationStatus
		
		if(allSummaryReportWMSInstance.roleId!=(roleFwd.id).toString())
		{
			allSummaryReportWMSInstance.roleId=(roleFwd.id).toString()
			allSummaryReportWMSInstance.roleName=roleFwd.roleName
			allSummaryReportWMSInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
			
			allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith.id
			allSummaryReportWMSInstance.groupId=(roleFwd.group.id).toString()
			allSummaryReportWMSInstance.groupName=roleFwd.group.groupName
		}
    	allSummaryReportWMSInstance.pendingSince=new Date();
    	allSummaryReportWMSInstance.applicationName=indRegMasterInstance.indName
		allSummaryReportWMSInstance.districtId=(indRegMasterInstance.district.id).toString()
		allSummaryReportWMSInstance.districtName=indRegMasterInstance.district.districtName
		allSummaryReportWMSInstance.categoryName=indRegMasterInstance.category.name
		allSummaryReportWMSInstance.categoryId=indRegMasterInstance.category.id
		allSummaryReportWMSInstance.industryTypeId=indRegMasterInstance.industryType.id.toString();
		allSummaryReportWMSInstance.industryTypeName=indRegMasterInstance.industryType.industryType;
		allSummaryReportWMSInstance.industryAddress=indRegMasterInstance.indAddress;
		allSummaryReportWMSInstance.scrutinyStatus=""
		allSummaryReportWMSInstance.returned=false
		allSummaryReportWMSInstance.indCapInvt=(indRegMasterInstance.indCapInvt).toString()
		allSummaryReportWMSInstance.authorizationtype = authFor
		allSummaryReportWMSInstance.authDate=WasteMgmtPendDetInstance.dateCreated;
		
		if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true)) 
		{
			
			println("in updateAllSummaryReportWMS--inst already--saved----"+allSummaryReportWMSInstance)	
		}
		
		else {
			println("in updateAllSummaryReportWMS--inst already--saved-not---"+AppId)
			allSummaryReportWMSInstance.errors.each {
		        println it
			}
		 }
	  }
	}
    catch(Exception e)
    {
        e.printStackTrace();
		flash.message = "Server Busy ..Please try after some time....";
		if(session.indUser){

            redirect(controller:'indUser',action:'openIndustryHome')
         }else if(session.userMaster)
         {

            redirect(controller:'userMaster',action:'openSpcbHome');
           }else
           {
     
		  session.invalidate()
          redirect(uri:'/index.gsp');
          } 
    }

}


    	  def doCheck = {
  		
  		def result
  		
  		if(params.indUser){
  				
      		result = 	IndUser.executeQuery(params.indUser)
      		
  		}
  		
  		
  		////////////////////////////
  		else if(params.upGipen){
  			
  		result = 	UserMaster.executeUpdate(params.upGipen)
  		
  		}
  		else if(params.insertApp){
  			
  		result = 	GeneralInspectionPendingDetails.executeInsert(params.insertApp)
  		
  		}
  		
  		def name = "dfkdk"
  		render(view: 'doCheck', model: [result: result,name:name ])
  	
  		
  }
    	  
    	  def checkFee11={
    			  
    	  }
    	  
    	  
    	  def updateDataAb={;
    		  def recordd
    		  def appFor=params.appFor
    		   if(appFor.equals("getDetails")){
    	    	recordd=IndustryRegMaster.executeQuery("select ir from IndustryRegMaster ir where ir NOT IN (select ipa.indUser.id from IndApplicationDetails ipa)")
    	    println("listas-------"+recordd)
    	    	}
    		   else if(appFor.equals("deleteExtra")){
    			   def industryReg=IndustryRegMaster.get(params.appId.toLong())
    	    		if(industryReg){
    	    			def indUssr=IndUser.findAllByIndustryRegMaster(industryReg)
    	    			if(indUssr){
    	    				for(int j=0;j<indUssr.size();j++){
    	    					
    	    					indUssr[j].delete()
    	    				}
    	    			}
    	    			def indProfl=IndFileRecord.findAllByIndUser(industryReg)
    	    			if(indProfl){
    	    				for(int i=0;i<indProfl.size();i++){
    	    					indProfl[i].delete();
    	    				}
    	    			}
    	    			industryReg.delete();
    	    			flash.message="Irr deleted"
    			   
    		   }
    		   }
    		   else if(appFor.equals("updateReg")){
    			   def industryReg=IndustryRegMaster.get(params.appId.toLong())
    	    		if(industryReg){
    	    			industryReg.regId=params.regid
    	    			industryReg.save();
    	    		}
    		   } else if(appFor.equals("updateCompStatus")){
    			   def indApp=IndApplicationDetails.get(params.appId.toLong())
    	    		if(indApp){
    	    			indApp.completionStatus="completed"
    	    			indApp.save();
    	    		}
    		   }else if(appFor.equals("SENDMAIL")){
    			 SendMail s= new SendMail();
    			 String mail=params.appId
    			 s.testingMail(mail)
    		   }else if(appFor.equals("sendtestingcheck")){
    				 SendSms s= new SendSms();
    				 String number=params.appId
    				 s.sendtestingcheck(number)
    			   }
    		   else if(appFor.equals("sendtestingcheckold")){
    			   SendSms s= new SendSms();
    				 String number=params.appId
    				 s.sendtestingcheckold(number)
    			   }
    		   else if(appFor.equals("sendtestingcheckoldnew")){
    			   SendSms s= new SendSms();
    				 String number=params.appId
    				 s.sendtestingcheckoldnew(number)
    			   }
    		   else if(appFor.equals("sendtestingcheckoldnewhttp")){
    			   SendSms s= new SendSms();
    				 String number=params.appId
    				 s.sendtestingcheckoldnewhttp(number)
    			   }
    		   else if(appFor.equals("sendtestingcheckAphttps")){
    			   SendSms s= new SendSms();
    				 String number=params.appId
    				 s.sendtestingcheckAphttps(number)
    			   }
    		   else if(appFor.equals("sendtestingcheckAphttp")){
    			   SendSms s= new SendSms();
    				 String number=params.appId
    				 s.sendtestingcheckAphttp(number)
    			   }
    		  render(view:'checkFee11',model:[recordd:recordd])
    		  return;
    	  }
    
}