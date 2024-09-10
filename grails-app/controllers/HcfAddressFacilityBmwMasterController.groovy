/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class HcfAddressFacilityBmwMasterController{

	 def create = {
			 try {
			    	
					
				   
			        def hcfAddressFacilityBmwInstance = new HcfAddressFacilityBmwMaster()
			        hcfAddressFacilityBmwInstance.properties = params		     
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
			        activityRecInstance.status = "CBMWTF Office Address of Treatment and Disposal Add Mode";
			        if(activityRecInstance.save()){		   
			          }
			        	else{
			        		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			        return ['hcfAddressFacilityBmwInstance':hcfAddressFacilityBmwInstance]
			    
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
	 
	 def save = {
			 try {
				    
				 UserMaster user= (UserMaster)session.userMaster
				 if(user==null || user=="")
			        {
			              redirect(controller:"userMaster",action:"logout")
			        }			    
			 def hcfAddressFacilityBmwInstance = new HcfAddressFacilityBmwMaster()
			 hcfAddressFacilityBmwInstance.hcfFacilityName=params.hcfFacilityName
			 hcfAddressFacilityBmwInstance.createdBy=user.id	    
		     hcfAddressFacilityBmwInstance.updatedBy=user.id
			 if(hcfAddressFacilityBmwInstance.save() && !hcfAddressFacilityBmwInstance.hasErrors())
	         {	  
				 flash.message ="Details saved successfully" 
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
		            activityRecInstance.status = "CBMWTF Office Address of Treatment and Disposal "+params.hcfFacilityName+" Created";
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
	         }
						
	        
			else
			{
				hcfAddressFacilityBmwInstance.errors.each {

	   		        println it;
	   			}
			
				
			}
			
			 render(view:'view',model:[hcfAddressFacilityBmwinstance:hcfAddressFacilityBmwInstance])	

		 
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
	 
	 def update={
			 try {
				    

			        def hcfAddressFacilityBmwList =  HcfAddressFacilityBmwMaster.list();
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
		            activityRecInstance.status = "CBMWTF Office Address of Treatment and Disposal Update Click"
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			        return ['hcfAddressFacilityBmwList':hcfAddressFacilityBmwList]
			 
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
	 
     def show={
			 try {
				    
				 
					
				 def hcfAddressFacilityBmwinstance =  HcfAddressFacilityBmwMaster.get((params.facilityId).toLong());
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
				    activityRecInstance.activity = "edit"
		            activityRecInstance.status = "CBMWTF Office Address of Treatment and Disposal " +hcfAddressFacilityBmwinstance.hcfFacilityName+" Search For Edit";
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
				 render(view:'edit',model:[hcfAddressFacilityBmwinstance:hcfAddressFacilityBmwinstance])
		 
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
	 
	 def edit={
			 try {
				    
				 
					
				 def hcfAddressFacilityBmwinstance =  HcfAddressFacilityBmwMaster.get((params.facilityId).toLong());
				 hcfAddressFacilityBmwinstance.hcfFacilityName=params.facility

				 hcfAddressFacilityBmwinstance.updatedBy=session.userMaster			
				 if( hcfAddressFacilityBmwinstance.save(flush:true))
		         {	  
					 flash.message ="Details saved successfully" 
				
				
		         }      
				else
				{   	hcfAddressFacilityBmwinstance.errors.each {
		
		   		        println it;
		   			}		
				}
				 flash.message = "facility updated..."
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
	 		     activityRecInstance.activity = "update"
	             activityRecInstance.status = "CBMWTF Office Address of Treatment and Disposal "+params.facility+" Updated " 
	             if(activityRecInstance.save()){		   
	               }
	             	else{
	             		activityRecInstance.errors.each {
	 			    	println it
	 			  }
	 		  }
				 render(view:'view',model:[hcfAddressFacilityBmwinstance:hcfAddressFacilityBmwinstance])
		 
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
	 
	 
	 
	 def createCommonFacility = {
			 try {
				    
			        def hcfAddressFacilityBmwInstance = new HcfCommonFacilityBmwMaster()
			        hcfAddressFacilityBmwInstance.properties = params
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
				        activityRecInstance.status = "CBMWTF Location Address of Treatment and Disposal Facility Add Mode";
				        if(activityRecInstance.save()){		   
				          }
				        	else{
				        		activityRecInstance.errors.each {
						    	println it
						  }
					  }
			        return ['hcfAddressFacilityBmwInstance':hcfAddressFacilityBmwInstance]
			    
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
	 
	 def saveCommonFacility = {
			 try {
				    
				 UserMaster user= (UserMaster)session.userMaster
				 if(user==null || user=="")
			        {
			              redirect(controller:"userMaster",action:"logout")
			        }			
			 def hcfAddressFacilityBmwInstance = new HcfCommonFacilityBmwMaster()
			 hcfAddressFacilityBmwInstance.hcfCommonFacilityName=params.hcfFacilityName
			 hcfAddressFacilityBmwInstance.createdBy=user.id	    
		     hcfAddressFacilityBmwInstance.updatedBy=user.id
			 if(hcfAddressFacilityBmwInstance.save() && !hcfAddressFacilityBmwInstance.hasErrors())
	      {  
				 flash.message ="Details saved successfully" 
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
		            activityRecInstance.status = "CBMWTF Location Address of Treatment and Disposal Facility "+params.hcfFacilityName+" Created";
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
	      }else
			{		hcfAddressFacilityBmwInstance.errors.each {
			
			        println it;
				}	
				
			}
			
			 render(view:'viewCommonFacility',model:[hcfAddressFacilityBmwinstance:hcfAddressFacilityBmwInstance])	

		 
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
	 
	 def updateCommonFacility={
			 try {
				    

			        def hcfAddressFacilityBmwList =  HcfCommonFacilityBmwMaster.list();
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
		            activityRecInstance.status = "CBMWTF Location Address of Treatment and Disposal Facility Update Click"
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			        return ['hcfAddressFacilityBmwList':hcfAddressFacilityBmwList]
			 
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
	 
  def showCommonFacility={
			 try {
				    
				 
				 
				 def hcfAddressFacilityBmwinstance =  HcfCommonFacilityBmwMaster.get((params.facilityId).toLong());
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
				    activityRecInstance.activity = "edit"
		            activityRecInstance.status = "CBMWTF Location Address of Treatment and Disposal Facility " +hcfAddressFacilityBmwinstance.hcfCommonFacilityName+" Search For Edit";
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
				 render(view:'editCommonFacility',model:[hcfAddressFacilityBmwinstance:hcfAddressFacilityBmwinstance])
		 
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
	 
	 def editCommonFacility={
			 try {
				    
				 
				 
				 def hcfAddressFacilityBmwinstance =  HcfCommonFacilityBmwMaster.get((params.facilityId).toLong());
				 hcfAddressFacilityBmwinstance.hcfCommonFacilityName=params.facility
				 hcfAddressFacilityBmwinstance.save(flush:true);
				 flash.message = "facility updated..."
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
	 		     activityRecInstance.activity = "update"
	             activityRecInstance.status = "CBMWTF Location Address of Treatment and Disposal Facility "+params.facility+" Updated " 
	             if(activityRecInstance.save()){		   
	               }
	             	else{
	             		activityRecInstance.errors.each {
	 			    	println it
	 			  }
	 		  }
				 render(view:'viewCommonFacility',model:[hcfAddressFacilityBmwinstance:hcfAddressFacilityBmwinstance])
		 
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
}
