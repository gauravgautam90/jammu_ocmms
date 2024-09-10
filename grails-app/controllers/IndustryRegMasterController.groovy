import java.lang.Byte
import sun.nio.cs.Surrogate
import javax.mail.*;
import SendMail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import DateCustom;
import org.springframework.web.multipart.MultipartFile;
import java.security.MessageDigest;
import java.util.Random;
import sun.nio.cs.Surrogate
import grails.converters.*
import java.util.ArrayList
import java.io.*;
import grails.converters.*
import javax.servlet.http.Cookie;
import org.codehaus.groovy.grails.web.util.WebUtils
class IndustryRegMasterController {

	boolean fileCheck(Byte[] bytes)
	{
		if(bytes[0]==37 && bytes[1]==80&& bytes[2]==68 &&bytes[3]==70 )
		{
			return true;
		}
		else if(bytes[0]==71 && bytes[1]==73&& bytes[2]==70 &&bytes[3]==56 )
		{
			return true;
		}
		else if(bytes[0]==255 && bytes[1]==216&& bytes[2]==255 &&bytes[3]==224 )
		{
			return true;
		}
		else if(bytes[0]==255 && bytes[1]==216 && bytes[2]==255 &&bytes[3]==225 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	Boolean  specialCharCheck(String field)
	{
		for(int i=0;i<field.size();i++)
		{
			char a=field.charAt(i)
			if(a=='<'||a=='>'||a=='+' ||a=='%' ||a=='^'|| a=='\''|| a=='='||a=='-'||a=='\"' || a=='\\' ||a=='$' ||a=='?' ||a=='&'||a=='#')
			{
				return false
			}
		}
		String field1=field.toLowerCase();
		if(field1.contains("script")|| field1.contains("delete")||field1.contains("drop")||field1.contains("select")||field1.contains("insert")||field1.contains("update")||field1.contains("select * from")||field1.contains("order by")||field1.contains("distinct")||field1.contains("create")||field1.contains("truncate")||field1.contains("alert")||field1.contains("javascript")||field1.contains("database")||field1.contains("function")||field1.contains("exec"))
		{
			return false
		}
		return true
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
	
	def changePassword = {
			 try { 
			       if(session.userMaster!=null)
					{

					if(session.userMaster.accessLevel=='employee')
					{
						session.invalidate()
			    		redirect(uri:'/index.gsp')
			    		return
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
	
	static allowedMethods = [delete:'POST', save:'POST', update:'POST',doLoginWithDetails:'POST']
	
	def regUPd = {
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
	
def list = {
		 try {
			    params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				def dList=IndustryRegMaster.list( params )
				for(int p=0;p<dList.size();p++) {
					def abcFinal=(dList.get(p)).dateCreated
					DateCustom dd=new DateCustom()
					def xyz= dd.toDate(abcFinal)
					(dList.get(p)).dateCreated=xyz
					
				}
				[ industryRegMasterInstanceList: dList, industryRegMasterInstanceTotal: IndustryRegMaster.count() ]
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

	def ajaxGetCities1 = {
		 try { 
		      def country = IndustryTypeMaster.get(params.id)
				def a = country.cities
				a = a.sort{it.toString()}
				render a as JSON
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
		       def industryRegMasterInstance = IndustryRegMaster.get((params.id).toLong())
				def abc = IndUser.findWhere(industryRegMaster:industryRegMasterInstance)
				def pass2 = params.passwordEncrypt
				if(!industryRegMasterInstance) {
					flash.message = "Industry not found "
					redirect(action:list)
				}
				else { render(view:'show',model:[ industryRegMasterInstance : industryRegMasterInstance , abc : abc , pass2:pass2] )
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
	
def show1 = {
		 try { 
		       def industryRegMasterInstance = IndustryRegMaster.get((params.id).toLong())
				def abc = IndUser.findWhere(industryRegMaster:industryRegMasterInstance)
				def pass2 = params.passwordEncrypt
				if(!industryRegMasterInstance) {
					flash.message = "Industry not found "
					redirect(action:list)
				}
				else { render(view:'show1',model:[ industryRegMasterInstance : industryRegMasterInstance , abc : abc , pass2:pass2] )
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
	
	def showForIndustry = {
		 try { 
		        def indUserObj = session.indUser
				indUserObj.refresh() 
				def industryRegMasterInstance = indUserObj.industryRegMaster
				def abc = IndUser.findWhere(industryRegMaster:industryRegMasterInstance)
				def pass2 = abc.password
				if(!industryRegMasterInstance) {
					flash.message = "Industry not found "
					redirect(action:list)
				}
				else { render(view:'show',model:[ industryRegMasterInstance : industryRegMasterInstance , abc : abc , pass2:pass2] )
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
		
	def delete = {
		def industryRegMasterInstance = IndustryRegMaster.get( params.id )
		if(industryRegMasterInstance) {
			try {
				industryRegMasterInstance.delete()
				flash.message = "Industry  deleted"
				redirect(action:list)
			}
			catch(org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "Industry could not be deleted"
				redirect(action:show,id:params.id1)
			}
		}
		else {
			flash.message = "Industry not found "
			redirect(action:list)
		}
	}
	
	def edit = {
		 try { 
		        def industryRegMasterInstance = IndustryRegMaster.get(params.id1)
				def indUserInstance = IndUser.findWhere(industryRegMaster:industryRegMasterInstance)
				def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
				if(!industryRegMasterInstance) {
					flash.message = "Industry not found "
					redirect(action:edit)
				}
				else {
					return [ industryRegMasterInstance : industryRegMasterInstance,indUserInstance:indUserInstance,districtList:districtList]
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
			 IndProfilePdf pdfG1=new IndProfilePdf()
		        def file12=IndFileRecord.find("from IndFileRecord abc where abc.indUser.id=?",[(params.id).toLong()]);
		        if(file12)
		        {
		        	file12.delete();
		        }
				IndFileRecord file=new IndFileRecord()
				File certFile
				def industryRegMasterInstance = IndustryRegMaster.get( params.id )
				def indUserInstance = IndUser.findWhere(industryRegMaster:industryRegMasterInstance)
				if(industryRegMasterInstance) {
					if(params.version) {
						def version = params.version.toLong()
						if(industryRegMasterInstance.version > version) {
							industryRegMasterInstance.errors.rejectValue("version", "industryRegMaster.optimistic.locking.failure", "Another user has updated this IndustryRegMaster while you were editing.")
							render(view:'edit',model:[industryRegMasterInstance:industryRegMasterInstance])
							return
						}
					}
					def districtMasterInstance = DistrictMaster.get(params.district.id)
					industryRegMasterInstance.occAddress = params.occAddress
					industryRegMasterInstance.properties = params
					indUserInstance.properties =params
					def date=new Date()
					DateCustom dd=new DateCustom()
					def sqlD=dd.sQLdate(date)
					def day=(date.getDate()).toString() 
					def month=(date.getMonth()).toString()
					def year=(date.getYear()+1900).toString() 
					def dateStr=day+"/"+month+"/"+year
					def login=(indUserInstance.id).toString()
					def passwordStr=""
					def iregId=industryRegMasterInstance.indRegNum
					def iName=industryRegMasterInstance.indName
					def iType=industryRegMasterInstance.industryType.industryType
					def iOtherType=industryRegMasterInstance.indTypeOther
					def iCategory=industryRegMasterInstance.category.name
					def iYear=industryRegMasterInstance.dateOfComm
					def iStatus=(industryRegMasterInstance.indStatus).toString()
					def iCapInvest=(industryRegMasterInstance.indCapInvt).toString()
					def iAddress=industryRegMasterInstance.indAddress
					def iCity=industryRegMasterInstance.indCity
					def iDistrict=industryRegMasterInstance.district.districtName
					def iTehsil=industryRegMasterInstance.tehsil.tehsilName
					def iPin=industryRegMasterInstance.indPin
					def iAreaC=industryRegMasterInstance.indPhoneCode
					def iPhone=industryRegMasterInstance.indPhoneNo
					def iFax=industryRegMasterInstance.indFaxNo
					def iFaxCode=industryRegMasterInstance.indFaxCode
					def iEmail=industryRegMasterInstance.indEmail
					def oName=industryRegMasterInstance.occName
					def oDesignation=industryRegMasterInstance.occDesignation
					def oAddress=industryRegMasterInstance.occAddress
					def oCity=industryRegMasterInstance.occCity
					def oDistrict=industryRegMasterInstance.occDistrict
					def oTehsil=industryRegMasterInstance.occTehsil
					def oPin=industryRegMasterInstance.occPin
					def oAreaC=industryRegMasterInstance.occPhoneCode
					def oPhoneNum=industryRegMasterInstance.occPhoneNo
					def oFaxNo=industryRegMasterInstance.occFaxNo
					def oFaxCode=industryRegMasterInstance.occFaxCode
					def oMobNo=industryRegMasterInstance.occMobile
					def oEmail=industryRegMasterInstance.occEmail
					def oHintQ=indUserInstance.hintQuestion
					def oAns=indUserInstance.hintAnswer
					def comMonth=industryRegMasterInstance.commMonth
					if(!industryRegMasterInstance.hasErrors() && industryRegMasterInstance.save()) {
						certFile = pdfG1.indProfileFunction(dateStr,login,passwordStr,iregId,iName,iType,iCategory,iYear,iStatus,iCapInvest,iAddress,iCity,iDistrict,iTehsil,iPin,iAreaC,iPhone,iFax,iEmail,oName,oDesignation,oAddress,oCity,oDistrict,oTehsil,oPin,oAreaC,oPhoneNum,oFaxNo,oMobNo,oEmail,oHintQ,oAns,iOtherType,comMonth,iFaxCode,oFaxCode)
						flash.message = "Industry ${params.indName} updated"
						byte[] b = new byte[(int) certFile.length()];
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						def fileLength=certFile.length()
						file.size = fileLength / 1024  //f.getSize() 
						file.extension ="pdf"//extractExtension( f )
						file.data=b;
						file.name=iregId+".pdf"
						file.description="Industry Profile Saved"
						if(session.userMaster){
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
						}else {
							file.createdBy=iName
							file.updatedBy=iName
						}
						file.typeOfFile="IndustryProfile"
						file.indUser=industryRegMasterInstance
						if(!file.hasErrors() && file.save()) {
						} else {
							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
							render(view:'create',model:[file:file,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
						}
						redirect(action:show,id:industryRegMasterInstance.id)
					}
					else {
						render(view:'edit',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
					}
				}
				else {
					flash.message = "Industry not found "
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
				def industryRegMasterInstance = new IndustryRegMaster()
				industryRegMasterInstance.properties = params
				def industryRegMaster1 = SurroundingMaster.list()
				def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
				return ['industryRegMasterInstance':industryRegMasterInstance,'industryRegMaster1':industryRegMaster1,'districtList':districtList]
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
				def industryRegMasterInstance = new IndustryRegMaster()
				industryRegMasterInstance.properties = params
				def industryRegMaster1 = SurroundingMaster.list()
				def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
				return ['industryRegMasterInstance':industryRegMasterInstance,'industryRegMaster1':industryRegMaster1,'districtList':districtList]
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
			 println("params.."+params)
				IndFileRecord file=new IndFileRecord()
				File certFile
				def expDate = params.expDate_value
				IndProfilePdf pdfG=new IndProfilePdf()
				def industryRegMasterInstance = new IndustryRegMaster(params)
			 
			 Random random = new Random(new Date().getTime());
				int randomInt = random.nextInt(1000000);
				println("randomInt----"+randomInt)
				industryRegMasterInstance.id = randomInt
				
				def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
				def x = sdfh.parse(expDate);
				industryRegMasterInstance.expDate = x
				industryRegMasterInstance.expDate =expDate
				industryRegMasterInstance.occAddress = params.occAddress
				industryRegMasterInstance.statusOfAppl = params.statusOfAppl
				industryRegMasterInstance.statusOfAppl = params.statusOfAppl
				industryRegMasterInstance.nameAddressPartners = params.nameAddressPartners
				industryRegMasterInstance.noOfEmp = params.noOfEmp
				industryRegMasterInstance.indTypeOther = ""
				def checkCategory = params.category.id
				
				def indUserInstance= new IndUser()
				def districtMasterInstance =  DistrictMaster.get(params.district.id)
				def indName = params.indName
				String output = indName.replaceAll("\\s+",""); 
				String iname = ((String)output.substring(0,3)).toUpperCase()
				def categoryId = params.category.id
				def districtId = params.district.id
				
				if(categoryId.equals('100')) {
					flash.message= "please select category"
					render(view:'create',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}
				if(districtId.equals('100')) {
					flash.message= "please select industry distict"
					render(view:'create',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}
				if((!session.userMaster) || (!session.indUser)){
					industryRegMasterInstance.updatedBy=params.indName
				}
				else{
					if(session.userMaster){
						industryRegMasterInstance.updatedBy = session.userMaster
					}else{
						industryRegMasterInstance.updatedBy = session.indUser
					}
				}
				if(session.userMaster){
					industryRegMasterInstance.createdBy = session.userMaster
				}
				else{
					industryRegMasterInstance.createdBy = params.indName
				}
				industryRegMasterInstance.indName=params.indName
				industryRegMasterInstance.dateCreated = new Date()
				industryRegMasterInstance.lastUpdated = new Date()
				industryRegMasterInstance.plotNo = params.plotNo
				industryRegMasterInstance.siteArea = params.siteArea
				def indTypeInstance = IndTypeMaster.findWhere(name:"medium") 
				Double capInt=Double.parseDouble(params.indCapInvt)
				def min =indTypeInstance.min
				def max =indTypeInstance.max
				if(capInt == "" ) {
					flash.message= "please enter capital investment"
					render(view:'create',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}else{
					if ((capInt.toLong()) >= max ) {
						def large = IndTypeMaster.findWhere(name:"large")
						industryRegMasterInstance.indType = large
					}else{
						if((capInt.toLong()) <= min){
							def small = IndTypeMaster.findWhere(name:"small") 
							industryRegMasterInstance.indType = small
						}
						else {
							def medium = IndTypeMaster.findWhere(name:"medium") 
							industryRegMasterInstance.indType = medium
						}
					}
				}
				if(industryRegMasterInstance.save()&& !industryRegMasterInstance.hasErrors()) { 
					if(params.indRegNum){
						industryRegMasterInstance.indRegNum = params.indRegNum
					}else{
						industryRegMasterInstance.indRegNum = ""
					}
					def pass =params.password
					indUserInstance.password=pass
					indUserInstance.hintQuestion=params.hintQuestion
					indUserInstance.hintAnswer=params.hintAnswer
					if(session.userMaster){
						indUserInstance.createdBy = session.userMaster
					}
					else{
						indUserInstance.createdBy = params.indName
					}
					indUserInstance.dateCreated= new Date()
					indUserInstance.industryRegMaster = industryRegMasterInstance
					if(!districtMasterInstance){
						flash.message ="please enter industry district"
						render(view:'create',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
					}
					else{
						indUserInstance.id=iname+industryRegMasterInstance.id
					}
					indUserInstance.flag = 0
					indUserInstance.save()
					def surrList = SurroundingMaster.list()
					def dList2
					def dist1 = params.distance
					def description = params.description
					def j=0
					for(int i=0;i<surrList.size();i++){
						def indSurroundingInstance = new IndSurrounding()
						def surr = surrList.get(i)
						def surrId = surr.surroundingName
						if(params[surrList.get(i).surroundingName]=="on"){
							def abc = (surrList.get(i)).id
							indSurroundingInstance.surrounding = surrList.get(i)
							indSurroundingInstance.industryReg=industryRegMasterInstance
							indSurroundingInstance.distance = dist1[j]
							indSurroundingInstance.description = description[j]
							indSurroundingInstance.save()
						}
						j=j + 1
					}
					def mailPermit = params.radiobutton
					if(mailPermit.equals('yes')) {    
						if ((params.occEmail)) {
							def recp = params.occEmail
							String recept = recp
							def userName = indUserInstance.id
							def industryName = params.indName
							def pass1= IndUser.findWhere(id:params.id)
							def password = params.passwordEncrypt
							SendMail mail = new SendMail()
							mail.sendMail(recept,userName,password, industryName)
							flash.message = "Mail has been Sent "
						} 
						else {
							flash.message="please enter email-Id" 
						}
					}
					else {}
					if(indUserInstance.hasErrors()){
						indUserInstance.errors.allErrors.each {
						}
					}
					def date=new Date()
					DateCustom dd=new DateCustom()
					def sqlD=dd.sQLdate(date)
					def day=(date.getDate()).toString() 
					def month=(date.getMonth()+1).toString()
					def year=(date.getYear()+1900).toString() 
					def dateStr=day+"/"+month+"/"+year
					def login=(indUserInstance.id).toString()
					def passwordStr=params.passwordEncrypt
					def iregId=industryRegMasterInstance.indRegNum
					def iName=industryRegMasterInstance.indName
					def iType=industryRegMasterInstance.industryType.industryType
					def iOtherType=industryRegMasterInstance.indTypeOther
					def iCategory=industryRegMasterInstance.category.name
					def iYear=industryRegMasterInstance.dateOfComm
					def iStatus=(industryRegMasterInstance.indStatus).toString()
					def iCapInvest=(industryRegMasterInstance.indCapInvt).toString()
					def iAddress=industryRegMasterInstance.indAddress
					def iCity=industryRegMasterInstance.indCity
					def iDistrict=industryRegMasterInstance.district.districtName
					def iTehsil=industryRegMasterInstance.tehsil.tehsilName
					def iPin=industryRegMasterInstance.indPin
					def iAreaC=industryRegMasterInstance.indPhoneCode
					def iPhone=industryRegMasterInstance.indPhoneNo
					def iFax=industryRegMasterInstance.indFaxNo
					def iFaxCode=industryRegMasterInstance.indFaxCode
					def iEmail=industryRegMasterInstance.indEmail
					def oName=industryRegMasterInstance.occName
					def oDesignation=industryRegMasterInstance.occDesignation
					def oAddress=industryRegMasterInstance.occAddress
					def oCity=industryRegMasterInstance.occCity
					def oDistrict=params.occDistrict
					def oTehsil=params.occTehsil
					def oPin=industryRegMasterInstance.occPin
					def oAreaC=industryRegMasterInstance.occPhoneCode
					def oPhoneNum=industryRegMasterInstance.occPhoneNo
					def oFaxNo=industryRegMasterInstance.occFaxNo
					def occFaxCode = industryRegMasterInstance.occFaxCode
					def oMobNo=industryRegMasterInstance.occMobile
					def oEmail=industryRegMasterInstance.occEmail
					def oHintQ=indUserInstance.hintQuestion
					def oAns=indUserInstance.hintAnswer
					def comMonth = industryRegMasterInstance.commMonth
					if( !indUserInstance.hasErrors() && indUserInstance.save()&& !industryRegMasterInstance.hasErrors()) {
						flash.message = "Industry Registration completed sucessfuly as User ID: ${indUserInstance.id} and Temporary Password: ${params.passwordEncrypt}. Please change your password."
						certFile = pdfG.indProfileFunction(dateStr,login,passwordStr,iregId,iName,iType,iCategory,iYear,iStatus,iCapInvest,iAddress,iCity,iDistrict,iTehsil,iPin,iAreaC,iPhone,iFax,iEmail,oName,oDesignation,oAddress,oCity,oDistrict,oTehsil,oPin,oAreaC,oPhoneNum,oFaxNo,oMobNo,oEmail,oHintQ,oAns,iOtherType,comMonth,iFaxCode,occFaxCode)
						byte[] b = new byte[(int) certFile.length()];
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						def fileLength=certFile.length()
						file.size = fileLength / 1024  //f.getSize() 
						file.extension ="pdf"//extractExtension( f )
						file.data=b;
						file.name=iregId+".pdf"
						file.description="Industry Profile Saved"
						if(session.userMaster){
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
						}else {
							file.createdBy=iName
							file.updatedBy=iName
						}
						file.typeOfFile="IndustryProfile"
						file.indUser=industryRegMasterInstance
						if(!file.hasErrors() && file.save()) {
						} else {
							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
							render(view:'create1',model:[file:file,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
						}
						def industryId = indUserInstance.id
						def tempPass = params.passwordEncrypt
						SendSms sms = new SendSms()
						sms.send(iName,industryId,tempPass,oMobNo)
						redirect(action:show,id:industryRegMasterInstance.id)
					}
					else {
						render(view:'create1',model:[indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
					}
				}
				else{
					industryRegMasterInstance.errors.each {
						println it
					}
					def industryRegMaster1 = SurroundingMaster.list()
					def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
					render(view:'create1',model:[districtList:districtList,industryRegMaster1:industryRegMaster1,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
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
	
def save1 = {
		 try { 
				IndFileRecord file=new IndFileRecord()
				File certFile
				def expDate = params.expDate_value
				IndProfilePdf pdfG=new IndProfilePdf()
				def industryRegMasterInstance = new IndustryRegMaster(params)
				
				Random random = new Random(new Date().getTime());
				int randomInt = random.nextInt(1000000);
				println("randomInt----"+randomInt)
				industryRegMasterInstance.id = randomInt
				
				def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
				def x = sdfh.parse(expDate);
				industryRegMasterInstance.expDate = x
				industryRegMasterInstance.expDate =expDate
				industryRegMasterInstance.occAddress = params.occAddress
				industryRegMasterInstance.statusOfAppl = params.statusOfAppl
				industryRegMasterInstance.statusOfAppl = params.statusOfAppl
				industryRegMasterInstance.nameAddressPartners = params.nameAddressPartners
				industryRegMasterInstance.noOfEmp = params.noOfEmp
				industryRegMasterInstance.indTypeOther = params.indTypeOther
				def checkCategory = params.category.id
				def indUserInstance= new IndUser()
				def districtMasterInstance =  DistrictMaster.get(params.district.id)
				def categoryId = params.category.id
				def districtId = params.district.id
				if(categoryId.equals('100')) {
					flash.message= "please select category"
					render(view:'create1',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}
				if(districtId.equals('100')) {
					flash.message= "please select industry distict"
					render(view:'create1',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}
				if((!session.userMaster) || (!session.indUser)){
					industryRegMasterInstance.updatedBy=params.indName
				}
				else{
					if(session.userMaster){
						industryRegMasterInstance.updatedBy = session.userMaster
					}else{
						industryRegMasterInstance.updatedBy = session.indUser
					}
				}
				if(session.userMaster){
					industryRegMasterInstance.createdBy = session.userMaster
				}
				else{
					industryRegMasterInstance.createdBy = params.indName
				}
				industryRegMasterInstance.indName=params.indName
				industryRegMasterInstance.dateCreated = new Date()
				industryRegMasterInstance.lastUpdated = new Date()
				industryRegMasterInstance.plotNo = params.plotNo
				industryRegMasterInstance.indCapInvtLand = params.indCapInvtLand.toLong()
				industryRegMasterInstance.indCapInvtBuilding = params.indCapInvtBuilding.toLong()
				industryRegMasterInstance.siteArea = params.siteArea
				def indTypeInstance = IndTypeMaster.findWhere(name:"medium") 
				def capInt =(params.indCapInvt)
				def indNewCapInvt =(params.indNewCapInvt).toLong()
				def min =indTypeInstance.min
				def max =indTypeInstance.max
				if(capInt == "" ) {
					flash.message= "please enter capital investment"
					render(view:'create1',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}else{
					if ((capInt.toLong()) >= max ) {
						def large = IndTypeMaster.findWhere(name:"large")
						industryRegMasterInstance.indType = large
					}else{
						
						if((capInt.toLong()) <= min){
							def small = IndTypeMaster.findWhere(name:"small") 
							industryRegMasterInstance.indType = small
						}
						else {
							def medium = IndTypeMaster.findWhere(name:"medium") 
							industryRegMasterInstance.indType = medium
						}
					}
				}
				if(industryRegMasterInstance.save()&& !industryRegMasterInstance.hasErrors()) {         
					def pass =params.password
					indUserInstance.password=pass
					indUserInstance.hintQuestion=params.hintQuestion
					indUserInstance.hintAnswer=params.hintAnswer
					if(session.userMaster){
						indUserInstance.createdBy = session.userMaster
					}
					else{
						indUserInstance.createdBy = params.indName
					}
					indUserInstance.dateCreated= new Date()
					indUserInstance.industryRegMaster = industryRegMasterInstance
					if(!districtMasterInstance){
						flash.message ="please enter industry district"
						render(view:'create1',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
					}
					else{
						indUserInstance.id=districtMasterInstance.districtCode+industryRegMasterInstance.id
					}
					indUserInstance.flag = 0
					indUserInstance.save()
					def surrList = SurroundingMaster.list()
					def dList2
					def dist1 = params.distance
					def description = params.description
					def j=0
					for(int i=0;i<surrList.size();i++){
						def indSurroundingInstance = new IndSurrounding()
						def surr = surrList.get(i)
						def surrId = surr.surroundingName
						if(params[surrList.get(i).surroundingName]=="on"){
							def abc = (surrList.get(i)).id
							indSurroundingInstance.surrounding = surrList.get(i)
							indSurroundingInstance.industryReg=industryRegMasterInstance
							indSurroundingInstance.distance = dist1[j]
							indSurroundingInstance.description = description[j]
							indSurroundingInstance.save()
						}
						j=j + 1
					}
					def mailPermit = params.radiobutton
					if(mailPermit.equals('yes')) {   
						if ((params.occEmail)) {
							def recp = params.occEmail
							String recept = recp
							def userName = indUserInstance.id
							def industryName = params.indName
							def pass1= IndUser.findWhere(id:params.id)
							def password = params.passwordEncrypt
							SendMail mail = new SendMail()
							mail.sendMail(recept,userName,password, industryName)
							flash.message = "Mail has been Sent "
						} 
						else {
							flash.message="please enter email-Id" 
						}
					}
					else {}
					if(indUserInstance.hasErrors()){
						indUserInstance.errors.allErrors.each {
							
						}
					}
					def date=new Date()
					DateCustom dd=new DateCustom()
					def sqlD=dd.sQLdate(date)
					def day=(date.getDate()).toString() 
					def month=(date.getMonth()+1).toString()
					def year=(date.getYear()+1900).toString() 
					def dateStr=day+"/"+month+"/"+year
					def login=(indUserInstance.id).toString()
					def passwordStr=params.passwordEncrypt
					def iregId=industryRegMasterInstance.indRegNum
					def iName=industryRegMasterInstance.indName
					def iType=industryRegMasterInstance.industryType.industryType
					def iOtherType=industryRegMasterInstance.indTypeOther
					def iCategory=industryRegMasterInstance.category.name
					def iYear=industryRegMasterInstance.dateOfComm
					def iStatus=(industryRegMasterInstance.indStatus).toString()
					def iCapInvest=(industryRegMasterInstance.indCapInvt).toString()
					def newCapInvestment=(industryRegMasterInstance.indNewCapInvt).toString()
					def iAddress=industryRegMasterInstance.indAddress
					def iCity=industryRegMasterInstance.indCity
					def iDistrict=industryRegMasterInstance.district.districtName
					def iTehsil=industryRegMasterInstance.tehsil.tehsilName
					def iPin=industryRegMasterInstance.indPin
					def iAreaC=industryRegMasterInstance.indPhoneCode
					def iPhone=industryRegMasterInstance.indPhoneNo
					def iFax=industryRegMasterInstance.indFaxNo
					def iEmail=industryRegMasterInstance.indEmail
					def oName=industryRegMasterInstance.occName
					def oDesignation=industryRegMasterInstance.occDesignation
					def oAddress=industryRegMasterInstance.occAddress
					def oCity=industryRegMasterInstance.occCity
					def oDistrict=params.occDistrict
					def oTehsil=params.occTehsil
					def oPin=industryRegMasterInstance.occPin
					def oAreaC=industryRegMasterInstance.occPhoneCode
					def oPhoneNum=industryRegMasterInstance.occPhoneNo
					def oFaxNo=industryRegMasterInstance.occFaxNo
					def oMobNo=industryRegMasterInstance.occMobile
					def oEmail=industryRegMasterInstance.occEmail
					def oHintQ=indUserInstance.hintQuestion
					def oAns=indUserInstance.hintAnswer
					def comMonth = industryRegMasterInstance.commMonth
					if( !indUserInstance.hasErrors() && indUserInstance.save()&& !industryRegMasterInstance.hasErrors()) {
						flash.message = "Industry Registration completed sucessfuly as User ID: ${indUserInstance.id} and Temporary Password: ${params.passwordEncrypt}. Please change your password."
						certFile = pdfG.indProfileFunction(dateStr,login,passwordStr,iregId,iName,iType,iCategory,iYear,iStatus,iCapInvest,newCapInvestment,iAddress,iCity,iDistrict,iTehsil,iPin,iAreaC,iPhone,iFax,iEmail,oName,oDesignation,oAddress,oCity,oDistrict,oTehsil,oPin,oAreaC,oPhoneNum,oFaxNo,oMobNo,oEmail,oHintQ,oAns,iOtherType,comMonth)
						byte[] b = new byte[(int) certFile.length()];
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						def fileLength=certFile.length()
						file.size = fileLength / 1024  //f.getSize() 
						file.extension ="pdf"//extractExtension( f )
						file.data=b;
						file.name=iregId+".pdf"
						file.description="Industry Profile Saved"
						if(session.userMaster){
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
						}else {
							file.createdBy=iName
							file.updatedBy=iName
						}
						file.typeOfFile="IndustryProfile"
						file.indUser=industryRegMasterInstance
						if(!file.hasErrors() && file.save()) {
						} else {
							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
							render(view:'create1',model:[file:file,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
						}
						def industryId = indUserInstance.id
						def tempPass = params.passwordEncrypt
						SendSms sms = new SendSms()
						sms.send(iName,industryId,tempPass,oMobNo)
						redirect(action:show,id:industryRegMasterInstance.id)
					}
					else {
						render(view:'create1',model:[indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
					}
				}
				else{
					industryRegMasterInstance.errors.each {
					}
					def industryRegMaster1 = SurroundingMaster.list()
					def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
					render(view:'create1',model:[districtList:districtList,industryRegMaster1:industryRegMaster1,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
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
	
	def downLoadingCertificate={
		 try { 
				def appId=IndustryRegMaster.get((params.id).toLong())
				def fileDownLoad = IndFileRecord.findAllByIndUser(appId,[max:1,sort:"dateCreated", order:"desc"])
				def fileSingle=fileDownLoad.get(0);
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition","attachment;filename=\""+fileSingle.name+"\"" )	
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
	
def myAjax ={
		 try { 
				def tehsilList
				def a 
				def dist
				if(params.cont== '9999' ) {
					
					render g.select( width:'10', optionKey:'id',name:'tehsil.id', from:tehsilList)
				}
				else {
					a = params.cont
					dist = DistrictMaster.get(a)
					tehsilList = TehsilMaster.findAll("from TehsilMaster tm where tm.district=? order by tm.tehsilName asc",[dist])
					render g.select( width:'10', optionKey:'id',name:'tehsil.id', from:tehsilList) 
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
	
def myAjax1 ={
		 try { 
				def tehsilList1
				def b 
				def dist1
				if(params.cont== '9999' ){
					render g.select( width:'10', optionKey:'id',name:'occTehsil.id', from:tehsilList1)
				}
				else{
					b = params.cont
					dist1 = DistrictMaster.get(b)
					tehsilList1 = TehsilMaster.findAll("from TehsilMaster tm where tm.district=? order by tm.tehsilName asc",[dist1])
					render g.select( width:'10', optionKey:'id',name:'occTehsil.id', from:tehsilList1)
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

def myAjaxIndustryType ={
		 try { 
				def industryTypeList
				def a 
				def cat
				if(params.cont== '9999' ) {
					render g.select( width:'10', optionKey:'id',name:'industryType.id', from:industryTypeList)
				}
				else {
					a = params.cont
					cat = IndCatMaster.get(a)
					industryTypeList = IndustryTypeMaster.findAll("from IndustryTypeMaster tm where tm.category=? order by tm.category asc",[cat])
					render g.select( width:'10', optionKey:'id',name:'industryType.id', from:industryTypeList) 
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
	
def forgetPassIND1 ={
		 try { 
				def industryRegMasterInstance = IndUser.findWhere(id:params['userName'])
				if(industryRegMasterInstance) {
					
					render(view:'forgetPass2',model:[industryRegMasterInstance:industryRegMasterInstance])
				}
				else if (!industryRegMasterInstance){
					flash.message = "${params.id} does not exist"
					render(view:'/forgetPassword',model:[industryRegMasterInstance:industryRegMasterInstance])	
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
	
	def forgetPassIND2 ={
		 try { 
				def b  = params.hintAnswer  
				def industryRegMasterInstance =IndUser.findWhere(id:params['userName'])
				if (industryRegMasterInstance.hintAnswer.equals(b)){
					render(view:'forgetPass3',model:[industryRegMasterInstance:industryRegMasterInstance])
				}
				else { 
					flash.message = "your Answer does not match "
					render(view:'forgetPass2',model:[industryRegMasterInstance:industryRegMasterInstance])
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
	
	def forgetPassIND3={
		 try { 
				if(session.userMaster!=null)
				{
					if(session.userMaster.accessLevel=='employee')
				{
					session.invalidate()
		    		redirect(uri:'/index.gsp')
		    		return
				}
				}
				def a = params.password1
				def b = params.password2
				def industryRegMasterInstance = IndUser.get(params.indUserId)
				if (a.equals(b)) {
					if(industryRegMasterInstance) {
						if(industryRegMasterInstance .lPass==null )
		    	    	{
		    				industryRegMasterInstance .password1=industryRegMasterInstance .password     		
		    				industryRegMasterInstance .lPass=1
		    	    		if(!industryRegMasterInstance .save())
		    	    		{
		    	    			industryRegMasterInstance .errors.each {
		    	    			}
		    	    		}
		    	    	}
		    			if( PasswordCheck(industryRegMasterInstance .password1,industryRegMasterInstance .password2,industryRegMasterInstance .password3,industryRegMasterInstance .password4,industryRegMasterInstance .password5,b))
		  			  {
		  				  flash.message="Password can not be a last 5 password"
		  					render(view:'forgetPass3',model:[industryRegMasterInstance:industryRegMasterInstance])
		  		    	  return
		  		     }
		  			  else
		  			  {
		  				  if(industryRegMasterInstance .lPass==0)
		  				  {
		  					  industryRegMasterInstance .lPass=1
		  					  industryRegMasterInstance .password1=b
		  				  }
		  				  else if(industryRegMasterInstance .lPass==1)
		  				  {
		  					  industryRegMasterInstance .lPass=2
		  					  industryRegMasterInstance .password2=b
		  				  }
		  				  else if(industryRegMasterInstance .lPass==2)
		  				  {
		  					  industryRegMasterInstance .lPass=3
		  					  industryRegMasterInstance .password3=b
		  				  }
		  				  else if(industryRegMasterInstance .lPass==3)
		  				  {
		  					  industryRegMasterInstance .lPass=4
		  					  industryRegMasterInstance .password4=b
		  				  }
		  				  else if(industryRegMasterInstance .lPass==4)
		  				  {
		  					  industryRegMasterInstance .lPass=0
		  					  industryRegMasterInstance .password5=b
		  				  }
		  			 }
						industryRegMasterInstance.password = b
						industryRegMasterInstance.logAttempt=0
						industryRegMasterInstance.tempLog=0
						industryRegMasterInstance.save()
						flash.message = "your password has been Reset"
						redirect(uri:"/indCatMaster/forgetPassword")
					}
					else {
						flash.message = "Industry not found with id ${params.id}"
						redirect(action:edit,id:params.id)
					}
				}   
				else {
					flash.message="re-enter"
					render(view:'forgetPass3',model:[industryRegMasterInstance:industryRegMasterInstance])
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

	def uploadFiles = {
		 try { 
				params.uploadFilename.transferTo(new File('c:/SPCBfiles/filename.txt'))
				flash.message = "file uploaded successfully"
				render(view:'upload')
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
	
	def changePass ={
		 try { 
				def indUserInstance = IndUser.get(params.id)
				def indRegMasterInstance = IndUser.get(params.id)
				if(indRegMasterInstance) {
					def old = params.old
					def pass =indRegMasterInstance.password 
					if (pass.equals(old)){
						def newpass1 =params.newPass1
						def newpass2 =params.newPass2
						if(newpass1.equals(newpass2)){
							indRegMasterInstance.password = newpass2
							if(indRegMasterInstance.save()){
								def preFlag = indUserInstance.flag
								if(preFlag==0){
									flash.message = "your password has been Reset Please Login"
									indUserInstance.flag = preFlag + 1
									redirect(uri:"/index.gsp")
								}else{
									flash.message = "your password has been Reset"
									indUserInstance.flag = preFlag + 1
									render(view:'changePassword')
								}
							}
						}
						else {
							flash.message= "New Password and Re Enter password Should be Same"
							render(view:'changePassword')
						}
					}
					else {
						flash.message="please enter valid password"
						render(view:'changePassword')
					}
				}
				else {
					flash.message="User Not Find with This Id"
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
	
	def industrySearch= {
		 try {
			    println("params..."+params)
				def xyz5
				def qwe
				def startDate1=params.start_date_value
				def endDate1=params.end_date_value
				def x
				def y
				def totalRes
				def  abcFinal
				def checkDate
				def indSearch= new IndustryRegMaster()
				def abcR= new IndustryRegMaster()
				int total;
				
				params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				if(params.max) {
					xyz5=(params.max).toInteger()
				}
				else {
					xyz5=10
				}
				if(params.offset) {
					qwe=(params.offset).toInteger()
				}
				else {
					qwe=0
				}
				
				
				def paramList= new ArrayList()
				paramList=params
				
				
				if(params.searchOp=="IndId"){
					def firstInput = (params.indName1).toLowerCase()
					def input = firstInput+ '%' 
					
					abcR= IndustryRegMaster.findAll("from IndustryRegMaster as country where lower(country.indName) like :indName", [indName:input]) 
					indSearch = IndustryRegMaster.findAll("from IndustryRegMaster as country where lower(country.indName) like :indName", [indName:input],[max:xyz5,offset:qwe]) 
					
					total=abcR.size()
					if(indSearch.getClass().getName()=="java.util.ArrayList"){
						total= indSearch.size()
						for(int p=0;p<total;p++) {if(indSearch)
							abcFinal=(indSearch.get(p)).dateCreated
							
							DateCustom dd=new DateCustom()
							def xyz= dd.toDate(abcFinal)
							(indSearch.get(p)).dateCreated=xyz
						}
					}
					else { if(indSearch){
							abcFinal=indSearch.dateCreated
							DateCustom dd=new DateCustom()
							def xyz= dd.toDate(abcFinal)
							indSearch.dateCreated=xyz
							
						}
					}  
				} 
				
				else {
					if(params.searchOp=="indDate"){
						println("here in searchDate")
						try {
							def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
							x = sdfh.parse(startDate1); //Date
							y = sdfh.parse(endDate1);  //Date
							checkDate="checked"
						}
						catch(Exception e) {
							flash.message="please verify date range"
							redirect(action:list)
						}
						if(checkDate){	
							java.sql.Date sqlDate = new java.sql.Date(x.getTime())
							java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
							sqlDate2.setDate((sqlDate2.getDate()+1))
						println("here in searchDate"+startDate1)
						println("here in searchDate"+endDate1)
						println("here in sqlDate"+sqlDate)
						println("here in sqlDate2"+sqlDate2)
						println("here in searchDate"+sqlDate.getClass().getName())
						println("here in searchDate"+sqlDate2.getClass().getName())
							if(startDate1 && endDate1) {
								abcR=IndustryRegMaster.findAll("From IndustryRegMaster dateCheck where dateCheck.dateCreated >=? and dateCheck.dateCreated <?",[sqlDate,sqlDate2]); 
								println("here in searchDate"+abcR)
								indSearch=IndustryRegMaster.findAll("From IndustryRegMaster dateCheck where dateCheck.dateCreated >= ? and dateCheck.dateCreated < ? order by dateCheck.id",[sqlDate,sqlDate2],[max:xyz5,offset:qwe] ); 
								println("here in searchDate"+indSearch)
								total=abcR.size()
								
								for(int p=0;p<indSearch.size();p++) {
									abcFinal=(indSearch.get(p)).dateCreated
										DateCustom dd=new DateCustom()
									def xyz= dd.toDate(abcFinal)
									(indSearch.get(p)).dateCreated=xyz
									
								}
							}  
						}
					}
				}
				
				
				if(indSearch){
					render(view:'list',model:[indSearch:indSearch,indSearchTotal:IndustryRegMaster.count(),total:total,paramList:paramList])
				}
				else{
					flash.message ="Record Not Found"
					render(view:'list',model:[indSearch:indSearch])
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
	
def ajaxAutoComplete = {
		 try {
				if(params.indName1) {
					def firstInput = (params.indName1).toLowerCase()
					def input = firstInput + '%' 
					def list = IndustryRegMaster.findAll("from IndustryRegMaster as country where lower(country.indName) like :indName", [indName:input]) 
					StringBuffer idList = new StringBuffer() 
					idList.append("<ul>")
					list?.each{c -> idList.append("<li>" + c.indName+"</li>")
					} 
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
	
def industryMasterCreate = {
		 try {
				
				def industryRegMasterInstance = new IndustryRegMaster()
				industryRegMasterInstance.properties = params
				def industryRegMaster1 = SurroundingMaster.list()
				render(view:'industryMasterCreate',model:['industryRegMasterInstance':industryRegMasterInstance,'industryRegMaster1':industryRegMaster1])
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
	
	def industryMasterSave ={
		 try {
				def industryMasterInstance = new IndustryRegAdminMaster(params)
				industryMasterInstance.indName = params.indName
				industryMasterInstance.dateCreated = new Date()
				industryMasterInstance.lastUpdated = new Date()
				industryMasterInstance.plotNo = params.plotNo
				industryMasterInstance.dateOfComm = params.dateOfComm
				industryMasterInstance.indCapInvt = (params.indCapInvt).toLong()
				industryMasterInstance.indAddress = params.indAddress
				industryMasterInstance.indCity = params.indCity
				industryMasterInstance.indPin =params.indPin
				industryMasterInstance.indPhoneCode =params.indPhoneCode
				industryMasterInstance.indPhoneNo =params.indPhoneNo
				industryMasterInstance.indFaxCode =params.indFaxCode
				industryMasterInstance.indFaxNo =params.indFaxNo
				industryMasterInstance.indEmail =params.indEmail
				industryMasterInstance.indRegNum =params.indRegNum
				industryMasterInstance.createdBy ="abc"
				industryMasterInstance.updatedBy ="abc"    	 
				if(!industryMasterInstance.hasErrors() &&industryMasterInstance.save()) {
					flash.message ="Industry Details has been saved" 
					render(view:'industryMasterShow',model:[industryMasterInstance:industryMasterInstance]) 
				}
				else{
					flash.message = "Industry Details not Saved"
					render(view:'industryMasterCreate',model:[industryMasterInstance:industryMasterInstance])
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
	
	def industryMasterEdit = {
		 try {
				def industryMasterInstance = IndustryRegAdminMaster.get(params.id1)
				if(!industryMasterInstance) {
					flash.message = "IndustryMaster not found "
					redirect(action:industryMasterEdit)
				}
				else {
					return [ industryMasterInstance : industryMasterInstance ]
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
	
	def industryMasterUpdate = {
		 try {
				def industryMasterInstance = IndustryRegAdminMaster.get( params.id )
				if(industryMasterInstance) {
					if(params.version) { 
						def version = params.version.toLong()
						if(industryMasterInstance.version > version) {
							industryMasterInstance.errors.rejectValue("version", "industryRegAdminMaster.optimistic.locking.failure", "Another user has updated this IndustryRegMaster while you were editing.")
							render(view:'industryMasterEdit',model:[industryMasterInstance:industryMasterInstance])
							return
						}
					}
					industryMasterInstance.properties = params
					if(!industryMasterInstance.hasErrors() && industryMasterInstance.save()) {
						
						flash.message = "Industry  updated"
						redirect(action:industryMasterShow,id:industryMasterInstance.id)
					}
					else {
						flash.message = "IndustryMaster not found"
						render(view:'industryMasterEdit',model:[industryMasterInstance:industryMasterInstance])
					}
				}
				else {
					flash.message = "IndustryMaster not found"
					redirect(action:industryMasterEdit,id:params.id)
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
	
	def industryMasterShow = {
		 try {
				def industryMasterInstance = IndustryRegAdminMaster.get((params.id).toLong())
				if(!industryMasterInstance) {
					flash.message = "IndustryMaster not found"
					redirect(action:industryMasterList)
				}
				else { render(view:'industryMasterShow',model:[ industryMasterInstance : industryMasterInstance] )
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
	
	def industryMasterList = {
		 try {
				params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				[ industryMasterInstanceList: IndustryRegAdminMaster.list( params ), industryMasterInstanceTotal: IndustryRegAdminMaster.count() ]
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
	
def industryMasterSearch= {
		 try {
				def xyz5
				def qwe
				def startDate1=params.start_date_value
				def endDate1=params.end_date_value
				def x
				def y
				def totalRes
				def  abcFinal
				def checkDate
				def indSearch= new IndustryRegAdminMaster()
				def abcR= new IndustryRegAdminMaster()
				int total;
				params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				if(params.max) {
					xyz5=(params.max).toInteger()
				}
				else {
					xyz5=10
				}
				if(params.offset) {
					qwe=(params.offset).toInteger()
				}
				else {
					qwe=0
				}
				def paramList= new ArrayList()
				paramList=params
				if(params.searchOp=="IndId"){
					def input = params.indName1
					abcR= IndustryRegAdminMaster.findAll("from IndustryRegAdminMaster as country where country.indName= ? ", [input],[max:xyz5,offset:qwe])
					indSearch = IndustryRegAdminMaster.findAll("from IndustryRegAdminMaster as country where country.indName= ? ", [input],[max:xyz5,offset:qwe])
					total=abcR.size()
					if(indSearch.getClass().getName()=="java.util.ArrayList"){
						total= indSearch.size()
						for(int p=0;p<total;p++) {if(indSearch)
							abcFinal=(indSearch.get(p)).dateCreated
							DateCustom dd=new DateCustom()
							def xyz= dd.toDate(abcFinal)
							(indSearch.get(p)).dateCreated=xyz
						}
					}
					else { if(indSearch){
							abcFinal=indSearch.dateCreated
							DateCustom dd=new DateCustom()
							def xyz= dd.toDate(abcFinal)
							indSearch.dateCreated=xyz
						}
					}  
				} 
				else {
					if(params.searchOp=="indDate"){
						try {
							def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
							x = sdfh.parse(startDate1); //Date
							y = sdfh.parse(endDate1);  //Date
							checkDate="checked"
						}
						catch(Exception e) {
							flash.message="Please verify date range "
							redirect(action:industryMasterList)
						}
						if(checkDate)	{	
							java.sql.Date sqlDate = new java.sql.Date(x.getTime())
							java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
							sqlDate2.setDate((sqlDate2.getDate()+1))
							if(startDate1 && endDate1) {
								abcR=IndustryRegAdminMaster.findAll("From IndustryRegAdminMaster dateCheck where dateCheck.dateCreated >= ? and dateCheck.dateCreated <= ? ",  [sqlDate,sqlDate2] ); 
								indSearch=IndustryRegAdminMaster.findAll("From IndustryRegAdminMaster dateCheck where dateCheck.dateCreated >= ? and dateCheck.dateCreated <= ? order by dateCheck.id",  [sqlDate,sqlDate2],[max:xyz5,offset:qwe] ); 
								total=abcR.size()
								for(int p=0;p<indSearch.size();p++) {
									abcFinal=(indSearch.get(p)).dateCreated
									DateCustom dd=new DateCustom()
									def xyz= dd.toDate(abcFinal)
									(indSearch.get(p)).dateCreated=xyz
								}
							}  
						}
					}
				} 
				if(indSearch){
					render(view:'industryMasterList',model:[indSearch:indSearch,indSearchTotal:IndustryRegAdminMaster.count(),total:total,paramList:paramList])
				}
				else{
					flash.message ="Record Not Found"
					render(view:'industryMasterList',model:[indSearch:indSearch])
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
	
def ajaxAutoComplete1 = {
		 try {
				if(params.indName1) {
					def firstInput = (params.indName1).toLowerCase()
					def input = firstInput+ '%' 
					def list = IndustryRegAdminMaster.findAll("from IndustryRegAdminMaster as country where lower(country.indName) like :indName", [indName:input]) 
					StringBuffer idList = new StringBuffer() 
					idList.append("<ul>")
					list?.each{c -> idList.append("<li>" + c.indName+"</li>")
					} 
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
	
def extractExtension( MultipartFile file ) {
		 try {
				String filename = file.getOriginalFilename()
				return filename.substring(filename.lastIndexOf( "." ) + 1 )
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
	
def updateTemplate ={
			 try {
					def industrydetailInstance
					if(params.selectedValue=='xyz') {
						render (template:"selectIndDetails")
					}
					else{
						industrydetailInstance = IndustryRegAdminMaster.findWhere(id:(params.selectedValue).toLong())
						render (template:"selectIndDetails", model : [industrydetailInstance : industrydetailInstance])
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

/////////////Added by Pragya Delete application
def delApp = {}
	
def deleteApp = {
			 try {
					def indId = params.surroundingName
					def getApplicationID	
					getApplicationID = IndApplicationDetails.findAll("from IndApplicationDetails abc where abc.id=? ",[indId.toLong()])
					getApplicationID= getApplicationID.id
					def app =  IndApplicationDetails.find("from IndApplicationDetails abc where abc.id=? ",[indId.toLong()])						
///////////////////////deleting application id from all consent tables/////////////////////////////		
					if(getApplicationID){
						for(int ui=0;ui<getApplicationID.size();ui++){				
//////////////////////////////HotelWaterConsumptionDetail///////////////////////////////////
							def deletionFromHotelWaterConsumptionDetail = HotelWaterConsumptionDetail.findAll("from HotelWaterConsumptionDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromHotelWaterConsumptionDetail){
								for(int i=0;i<deletionFromHotelWaterConsumptionDetail.size();i++){
									deletionFromHotelWaterConsumptionDetail.get(i).delete()
									}
								}
//////////////////////////////StoneCrusherWaterReq///////////////////////////////////
							def deletionFromStoneCrusherWaterReq = StoneCrusherWaterReq.findAll("from StoneCrusherWaterReq abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromStoneCrusherWaterReq){
								for(int i=0;i<deletionFromStoneCrusherWaterReq.size();i++){
									deletionFromStoneCrusherWaterReq.get(i).delete()
									}
								}
//////////////////////////////HotelWasteEmissionDetail///////////////////////////////////
							def deletionFromHotelWasteEmissionDetail = HotelWasteEmissionDetail.findAll("from HotelWasteEmissionDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromHotelWasteEmissionDetail){
								for(int i=0;i<deletionFromHotelWasteEmissionDetail.size();i++){
									deletionFromHotelWasteEmissionDetail.get(i).delete()
									}
								}
//////////////////////////////HotelWasteEmissionDetailMaster///////////////////////////////////
							def deletionFromHotelWasteEmissionDetailMaster = HotelWasteEmissionDetailMaster.findAll("from HotelWasteEmissionDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromHotelWasteEmissionDetailMaster){
								for(int i=0;i<deletionFromHotelWasteEmissionDetailMaster.size();i++){
									deletionFromHotelWasteEmissionDetailMaster.get(i).delete()
									}
								}
//////////////////////////////HotelFacilityDetail///////////////////////////////////
							def deletionFromHotelFacilityDetail = HotelFacilityDetail.findAll("from HotelFacilityDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromHotelFacilityDetail){
								for(int i=0;i<deletionFromHotelFacilityDetail.size();i++){
									deletionFromHotelFacilityDetail.get(i).delete()
									}
								}
//////////////////////////////HotelGeneralDetails///////////////////////////////////
							def deletionFromHotelGeneralDetails = HotelGeneralDetails.findAll("from HotelGeneralDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromHotelGeneralDetails){
								for(int i=0;i<deletionFromHotelGeneralDetails.size();i++){
									deletionFromHotelGeneralDetails.get(i).delete()
									}
								}
//////////////////////////////WaterConsumptionDetail///////////////////////////////////
							def deletionFromWaterConsumptionDetail = WaterConsumptionDetail.findAll("from WaterConsumptionDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromWaterConsumptionDetail){
								for(int i=0;i<deletionFromWaterConsumptionDetail.size();i++){
									deletionFromWaterConsumptionDetail.get(i).delete()
									}
								}
/////////////////////////////BrickKilnDetail///////////////////////////////////
							def deletionFromBrickKilnDetail = BrickKilnDetail.findAll("from BrickKilnDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromBrickKilnDetail){
								for(int i=0;i<deletionFromBrickKilnDetail.size();i++){
									deletionFromBrickKilnDetail.get(i).delete()
									}
								}
//////////////////////////////BrickSittingCriteriaDetails///////////////////////////////////
							def deletionFromBrickSittingCriteriaDetails = BrickSittingCriteriaDetails.findAll("from BrickSittingCriteriaDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromBrickSittingCriteriaDetails){
								for(int i=0;i<deletionFromBrickSittingCriteriaDetails.size();i++){
									deletionFromBrickSittingCriteriaDetails.get(i).delete()
									}
								}
//////////////////////////////NocAuthorityDetails///////////////////////////////////
							def deletionFromNocAuthorityDetails = NocAuthorityDetails.findAll("from NocAuthorityDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromNocAuthorityDetails){
								for(int i=0;i<deletionFromNocAuthorityDetails.size();i++){
									deletionFromNocAuthorityDetails.get(i).delete()
									}
								}
//////////////////////////////StoneCrusherControlDevices///////////////////////////////////
							def deletionFromStoneCrusherControlDevices = StoneCrusherControlDevices.findAll("from StoneCrusherControlDevices abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromStoneCrusherControlDevices){
								for(int i=0;i<deletionFromStoneCrusherControlDevices.size();i++){
									deletionFromStoneCrusherControlDevices.get(i).delete()
									}
								}
//////////////////////////////StoneCrusherSittingCriteria///////////////////////////////////
							def deletionFromStoneCrusherSittingCriteria = StoneCrusherSittingCriteria.findAll("from StoneCrusherSittingCriteria abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromStoneCrusherSittingCriteria){
								for(int i=0;i<deletionFromStoneCrusherSittingCriteria.size();i++){
									deletionFromStoneCrusherSittingCriteria.get(i).delete()
									}
								}
//////////////////////////////DGSetParameterDetails///////////////////////////////////
							def deletionFromDGSetParameterDetails = DGSetParameterDetails.findAll("from DGSetParameterDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromDGSetParameterDetails){
								for(int i=0;i<deletionFromDGSetParameterDetails.size();i++){
									deletionFromDGSetParameterDetails.get(i).delete()
									}
								}
///////////////////////////DGSetEmissionDetails///////////////////////////////////
							def deletionFromDGSetEmissionDetails = DGSetEmissionDetails.findAll("from DGSetEmissionDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromDGSetEmissionDetails){
								for(int i=0;i<deletionFromDGSetEmissionDetails.size();i++){
									deletionFromDGSetEmissionDetails.get(i).delete()
									}
								}
////////////////////////////DGSetDetails///////////////////////////////////
							def deletionFromDGSetDetails = DGSetDetails.findAll("from DGSetDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromDGSetDetails){
								for(int i=0;i<deletionFromDGSetDetails.size();i++){
									deletionFromDGSetDetails.get(i).delete()
									}
								}
////////////////////////////AirMiscDetails///////////////////////////////////
							def deletionFromAirMiscDetails = AirMiscDetails.findAll("from AirMiscDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
							if(deletionFromAirMiscDetails){
								for(int i=0;i<deletionFromAirMiscDetails.size();i++){
									deletionFromAirMiscDetails.get(i).delete()
									}
								}
////////////////////////////AirFlueGasDetails///////////////////////////////////
			def deletionFromAirFlueGasDetails = AirFlueGasDetails.findAll("from AirFlueGasDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromAirFlueGasDetails){
				for(int ii=0;ii<deletionFromAirFlueGasDetails.size();ii++){
					deletionFromAirFlueGasDetails.get(ii).delete()	
				}
			}
////////////////////////////AirStackDetails///////////////////////////////////
			def deletionFromAirStackDetails = AirStackDetails.findAll("from AirStackDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			def deletionFromAirStackDetails1 = deletionFromAirStackDetails.id
			if(deletionFromAirStackDetails1){
				for(int i=0;i<deletionFromAirStackDetails1.size();i++){
					def deletionFromAirFlueGasPollutionCntrlDetails = AirFlueGasPollutionCntrlDetails.findAll("from AirFlueGasPollutionCntrlDetails abc where abc.stack.id=?",[deletionFromAirStackDetails1.get(ui).toLong()])
					if(deletionFromAirFlueGasPollutionCntrlDetails){
						for(int ii=0;ii<deletionFromAirFlueGasPollutionCntrlDetails.size();ii++){
							deletionFromAirFlueGasPollutionCntrlDetails.get(ii).delete()	
						}
					}
					def deletionFromAirStackPollutionCntrlDetails = AirStackPollutionCntrlDetails.findAll("from AirStackPollutionCntrlDetails abc where abc.stack.id=?",[deletionFromAirStackDetails1.get(ui).toLong()])
					if(deletionFromAirStackPollutionCntrlDetails){
						for(int ii=0;ii<deletionFromAirStackPollutionCntrlDetails.size();ii++){
							deletionFromAirStackPollutionCntrlDetails.get(ii).delete()	
						}
					}
					}
				}
			if(deletionFromAirStackDetails){
				for(int ii=0;ii<deletionFromAirStackDetails.size();ii++){
					deletionFromAirStackDetails.get(ii).delete()	
				}
			}
////////////////////////////MiscellaneousDetails///////////////////////////////////
			def deletionFromMiscellaneousDetails = MiscellaneousDetails.findAll("from MiscellaneousDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromMiscellaneousDetails){
				for(int i=0;i<deletionFromMiscellaneousDetails.size();i++){
					deletionFromMiscellaneousDetails.get(i).delete()
					}
				}
////////////////////////////HazardousChemicalDetails///////////////////////////////////
			def deletionFromHazardousChemicalDetails = HazardousChemicalDetails.findAll("from HazardousChemicalDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHazardousChemicalDetails){
				for(int i=0;i<deletionFromHazardousChemicalDetails.size();i++){
					deletionFromHazardousChemicalDetails.get(i).delete()
					}
				}
////////////////////////////HazardousWasteStorDisDetails///////////////////////////////////
			def deletionFromHazardousWasteStorDisDetails = HazardousWasteStorDisDetails.findAll("from HazardousWasteStorDisDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHazardousWasteStorDisDetails){
				for(int i=0;i<deletionFromHazardousWasteStorDisDetails.size();i++){
					deletionFromHazardousWasteStorDisDetails.get(i).delete()
					}
				}
////////////////////////////HazardousWasteGenDetails///////////////////////////////////
			def deletionFromHazardousWasteGenDetails = HazardousWasteGenDetails.findAll("from HazardousWasteGenDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromHazardousWasteGenDetails){
				for(int ii=0;ii<deletionFromHazardousWasteGenDetails.size();ii++){
					deletionFromHazardousWasteGenDetails.get(ii).delete()	
				}
				}
////////////////////////////HazardousWasteGenDetailsCert///////////////////////////////////
			def deletionFromHazardousWasteGenDetailsCert = HazardousWasteGenDetailsCert.findAll("from HazardousWasteGenDetailsCert abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromHazardousWasteGenDetailsCert){
				for(int ii=0;ii<deletionFromHazardousWasteGenDetailsCert.size();ii++){
					deletionFromHazardousWasteGenDetailsCert.get(ii).delete()	
				}
				}			
////////////////////////////WaterWasteGenerationDetails///////////////////////////////////
			def deletionFromWaterWasteGenerationDetails = WaterWasteGenerationDetails.findAll("from WaterWasteGenerationDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromWaterWasteGenerationDetails){
				for(int i=0;i<deletionFromWaterWasteGenerationDetails.size();i++){
					deletionFromWaterWasteGenerationDetails.get(i).delete()
					}
				}
////////////////////////////WasteWaterTreatmentDetails///////////////////////////////////
			def deletionFromWasteWaterTreatmentDetails = WasteWaterTreatmentDetails.findAll("from WasteWaterTreatmentDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			 
			if(deletionFromWasteWaterTreatmentDetails){
				for(int i=0;i<deletionFromWasteWaterTreatmentDetails.size();i++){
					deletionFromWasteWaterTreatmentDetails.get(i).delete()
					}
				}
////////////////////////////WaterSourceDetails///////////////////////////////////
			def deletionFromWaterSourceDetails = WaterSourceDetails.findAll("from WaterSourceDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromWaterSourceDetails){
				for(int i=0;i<deletionFromWaterSourceDetails.size();i++){
					deletionFromWaterSourceDetails.get(i).delete()
					}
				}
////////////////////////////QuantHaz///////////////////////////////////
			def deletionFromQuantHazDetails = QuantHaz.findAll("from QuantHaz abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromQuantHazDetails){
				for(int i=0;i<deletionFromQuantHazDetails.size();i++){
					deletionFromQuantHazDetails.get(i).delete()
					}
				}
////////////////////////////StoreMode///////////////////////////////////
			def deletionFromStoreModeDetails = StoreMode.findAll("from StoreMode abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoreModeDetails){
				for(int i=0;i<deletionFromStoreModeDetails.size();i++){
					deletionFromStoreModeDetails.get(i).delete()
					}
				}	
////////////////////////////InspectionFwdNotice///////////////////////////////////
			def deletionFromInspectionFwdNoticeDetails = InspectionFwdNotice.findAll("from InspectionFwdNotice abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromInspectionFwdNoticeDetails){
				for(int i=0;i<deletionFromInspectionFwdNoticeDetails.size();i++){
					deletionFromInspectionFwdNoticeDetails.get(i).delete()
					}
				}	
////////////////////////////RegularInspectionRaised///////////////////////////////////
			def deletionFromRegularInspectionRaisedDetails = RegularInspectionRaised.findAll("from RegularInspectionRaised abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromRegularInspectionRaisedDetails){
				for(int i=0;i<deletionFromRegularInspectionRaisedDetails.size();i++){
					deletionFromRegularInspectionRaisedDetails.get(i).delete()
					}
				}	
////////////////////////////IndustryInspectionReport///////////////////////////////////
			def deletionFromIndustryInspectionReportDetails = IndustryInspectionReport.findAll("from IndustryInspectionReport abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndustryInspectionReportDetails){
				for(int i=0;i<deletionFromIndustryInspectionReportDetails.size();i++){
					deletionFromIndustryInspectionReportDetails.get(i).delete()
					}
				}
////////////////////////////CosentCertHotelDetails///////////////////////////////////
			def deletionFromCosentCertHotelDetails = CosentCertHotelDetails.findAll("from CosentCertHotelDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromCosentCertHotelDetails){
				for(int i=0;i<deletionFromCosentCertHotelDetails.size();i++){
					deletionFromCosentCertHotelDetails.get(i).delete()
					}
				}
////////////////////////////CosentCertProductDetails///////////////////////////////////
			def deletionFromCosentCertProductDetails = CosentCertProductDetails.findAll("from CosentCertProductDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromCosentCertProductDetails){
				for(int i=0;i<deletionFromCosentCertProductDetails.size();i++){
					deletionFromCosentCertProductDetails.get(i).delete()
					}
				}
////////////////////////////CosentCertSolidWasteDisposalDetails///////////////////////////////////
			def deletionFromCosentCertSolidWasteDisposalDetails = CosentCertSolidWasteDisposalDetails.findAll("from CosentCertSolidWasteDisposalDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromCosentCertSolidWasteDisposalDetails){
				for(int i=0;i<deletionFromCosentCertSolidWasteDisposalDetails.size();i++){
					deletionFromCosentCertSolidWasteDisposalDetails.get(i).delete()
					}
				}
////////////////////////////ConsentInspectionReportEERecommendations///////////////////////////////////
			def deletionFromConsentInspectionReportEERecommendations = ConsentInspectionReportEERecommendations.findAll("from ConsentInspectionReportEERecommendations abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromConsentInspectionReportEERecommendations){
				for(int i=0;i<deletionFromConsentInspectionReportEERecommendations.size();i++){
					deletionFromConsentInspectionReportEERecommendations.get(i).delete()
					}
				}
////////////////////////////ConsentRegularInspectionEERecommendations///////////////////////////////////
			def deletionFromConsentRegularInspectionEERecommendations = ConsentRegularInspectionEERecommendations.findAll("from ConsentRegularInspectionEERecommendations abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromConsentRegularInspectionEERecommendations){
				for(int i=0;i<deletionFromConsentRegularInspectionEERecommendations.size();i++){
					deletionFromConsentRegularInspectionEERecommendations.get(i).delete()
					}
				}
////////////////////////////FeeBankDetailsOfficer///////////////////////////////////
			def deletionFromFeeBankDetailsOfficer = FeeBankDetailsOfficer.findAll("from FeeBankDetailsOfficer abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromFeeBankDetailsOfficer){
				for(int i=0;i<deletionFromFeeBankDetailsOfficer.size();i++){
					deletionFromFeeBankDetailsOfficer.get(i).delete()
					}
				}	
////////////////////////////Hazsub///////////////////////////////////
			def deletionFromHazsubDetails = Hazsub.findAll("from Hazsub abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHazsubDetails){
			for(int i=0;i<deletionFromHazsubDetails.size();i++){
				deletionFromHazsubDetails.get(i).delete()
			}
			}
////////////////////////////Hazwaste///////////////////////////////////
			def deletionFromHazwasteDetails = Hazwaste.findAll("from Hazwaste abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHazwasteDetails){
			for(int i=0;i<deletionFromHazwasteDetails.size();i++){
				deletionFromHazwasteDetails.get(i).delete()
			}
			}
////////////////////////////InspectionNoteHistory///////////////////////////////////
			def deletionFromInspectionNoteHistoryDetails = InspectionNoteHistory.findAll("from InspectionNoteHistory abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromInspectionNoteHistoryDetails){
				for(int i=0;i<deletionFromInspectionNoteHistoryDetails.size();i++){
					deletionFromInspectionNoteHistoryDetails.get(i).delete()
					}
				}
////////////////////////////WaterUsesDetails///////////////////////////////////
			def deletionFromWaterUsesDetails = WaterUsesDetails.findAll("from WaterUsesDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromWaterUsesDetails){
				for(int i=0;i<deletionFromWaterUsesDetails.size();i++){
					deletionFromWaterUsesDetails.get(i).delete()
				}
			}
////////////////////////////IndProductDetailsMaster///////////////////////////////////
			def deletionFromIndProductDetailsMaster = IndProductDetailsMaster.findAll("from IndProductDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndProductDetailsMaster){
				for(int i=0;i<deletionFromIndProductDetailsMaster.size();i++){
					deletionFromIndProductDetailsMaster.get(i).delete()
					}
				}	
////////////////////////////IndProductDetailsInspection///////////////////////////////////
			def deletionFromIndProductDetailsInspection = IndProductDetailsInspection.findAll("from IndProductDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndProductDetailsInspection){
				for(int i=0;i<deletionFromIndProductDetailsInspection.size();i++){
					deletionFromIndProductDetailsInspection.get(i).delete()
					}
				}	
////////////////////////////AirStackDetailsMaster///////////////////////////////////
			def deletionFromAirStackDetailsMaster = AirStackDetailsMaster.findAll("from AirStackDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromAirStackDetailsMaster){
				for(int i=0;i<deletionFromAirStackDetailsMaster.size();i++){
					def deletionFromAirFlueGasPollutionCntrlDetails = AirFlueGasPollutionCntrlDetailsMaster.findAll("from AirFlueGasPollutionCntrlDetailsMaster abc where abc.stack.id=?",[deletionFromAirStackDetailsMaster.get(ui).toLong()])
					if(deletionFromAirFlueGasPollutionCntrlDetails){
						for(int ii=0;ii<deletionFromAirFlueGasPollutionCntrlDetails.size();ii++){
							deletionFromAirFlueGasPollutionCntrlDetails.get(ii).delete()	
						}
					}
					def deletionFromAirStackPollutionCntrlDetails = AirStackPollutionCntrlDetailsMaster.findAll("from AirStackPollutionCntrlDetailsMaster abc where abc.stack.id=?",[deletionFromAirStackDetailsMaster.get(ui).toLong()])
					if(deletionFromAirStackPollutionCntrlDetails){
						for(int ii=0;ii<deletionFromAirStackPollutionCntrlDetails.size();ii++){
							deletionFromAirStackPollutionCntrlDetails.get(ii).delete()	
						}
					}
					}
				}
			if(deletionFromAirStackDetailsMaster){
				for(int ii=0;ii<deletionFromAirStackDetailsMaster.size();ii++){
					deletionFromAirStackDetailsMaster.get(ii).delete()	
				}
			}
////////////////////////////AirStackDetailsInspection///////////////////////////////////
			def deletionFromAirStackDetailsInspection = AirStackDetailsInspection.findAll("from AirStackDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromAirStackDetailsInspection){
				for(int i=0;i<deletionFromAirStackDetailsInspection.size();i++){
					deletionFromAirStackDetailsInspection.get(i).delete()
					}
				}	
////////////////////////////	HotelFacilityDetailMaster///////////////////////////////////
			def deletionFromHotelFacilityDetailMaster = HotelFacilityDetailMaster.findAll("from HotelFacilityDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHotelFacilityDetailMaster){
				for(int i=0;i<deletionFromHotelFacilityDetailMaster.size();i++){
					deletionFromHotelFacilityDetailMaster.get(i).delete()
					}
				}	
////////////////////////////	HotelFacilityDetailInspection///////////////////////////////////
			def deletionFromHotelFacilityDetailInspection = HotelFacilityDetailInspection.findAll("from HotelFacilityDetailInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHotelFacilityDetailInspection){
				for(int i=0;i<deletionFromHotelFacilityDetailInspection.size();i++){
					deletionFromHotelFacilityDetailInspection.get(i).delete()
					}
				}	
////////////////////////////	HotelWaterConsumptionDetailMaster///////////////////////////////////
			def deletionFromHotelWaterConsumptionDetailMaster = HotelWaterConsumptionDetailMaster.findAll("from HotelWaterConsumptionDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHotelWaterConsumptionDetailMaster){
				for(int i=0;i<deletionFromHotelWaterConsumptionDetailMaster.size();i++){
					deletionFromHotelWaterConsumptionDetailMaster.get(i).delete()
					}
				}	
////////////////////////////	HotelWaterConsumptionDetailInspection///////////////////////////////////
			def deletionFromHotelWaterConsumptionDetailInspection = HotelWaterConsumptionDetailInspection.findAll("from HotelWaterConsumptionDetailInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHotelWaterConsumptionDetailInspection){
				for(int i=0;i<deletionFromHotelWaterConsumptionDetailInspection.size();i++){
					deletionFromHotelWaterConsumptionDetailInspection.get(i).delete()
					}
				}	
////////////////////////////	HotelGeneralDetailsMaster///////////////////////////////////
			def deletionFromHotelGeneralDetailsMaster = HotelGeneralDetailsMaster.findAll("from HotelGeneralDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHotelGeneralDetailsMaster){
				for(int i=0;i<deletionFromHotelGeneralDetailsMaster.size();i++){
					deletionFromHotelGeneralDetailsMaster.get(i).delete()
					}
				}	
////////////////////////////	HotelGeneralDetailsInspection///////////////////////////////////
			def deletionFromHotelGeneralDetailsInspection = HotelGeneralDetailsInspection.findAll("from HotelGeneralDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHotelGeneralDetailsInspection){
				for(int i=0;i<deletionFromHotelGeneralDetailsInspection.size();i++){
					deletionFromHotelGeneralDetailsInspection.get(i).delete()
					}
				}	
////////////////////////////	HazardousWasteGenDetailsMaster///////////////////////////////////
			def deletionFromHazardousWasteGenDetailsMaster = HazardousWasteGenDetailsMaster.findAll("from HazardousWasteGenDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHazardousWasteGenDetailsMaster){
				for(int i=0;i<deletionFromHazardousWasteGenDetailsMaster.size();i++){
					deletionFromHazardousWasteGenDetailsMaster.get(i).delete()
					}
				}	
////////////////////////////	HazardousWasteGenDetailsInspection///////////////////////////////////
			def deletionFromHazardousWasteGenDetailsInspection = HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromHazardousWasteGenDetailsInspection){
				for(int i=0;i<deletionFromHazardousWasteGenDetailsInspection.size();i++){
					deletionFromHazardousWasteGenDetailsInspection.get(i).delete()
					}
				}	
////////////////////////////	StoneCrusherWaterReqMaster///////////////////////////////////
			def deletionFromStoneCrusherWaterReqMaster = StoneCrusherWaterReqMaster.findAll("from StoneCrusherWaterReqMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoneCrusherWaterReqMaster){
				for(int i=0;i<deletionFromStoneCrusherWaterReqMaster.size();i++){
					deletionFromStoneCrusherWaterReqMaster.get(i).delete()
					}
				}	
////////////////////////////StoneCrusherWaterReqInspection///////////////////////////////////
			def deletionFromStoneCrusherWaterReqInspection = StoneCrusherWaterReqInspection.findAll("from StoneCrusherWaterReqInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoneCrusherWaterReqInspection){
				for(int i=0;i<deletionFromStoneCrusherWaterReqInspection.size();i++){
					deletionFromStoneCrusherWaterReqInspection.get(i).delete()
					}
				}	
////////////////////////////BrickKilnDetailMaster///////////////////////////////////
			def deletionFromBrickKilnDetailMaster = BrickKilnDetailMaster.findAll("from BrickKilnDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromBrickKilnDetailMaster){
				for(int i=0;i<deletionFromBrickKilnDetailMaster.size();i++){
					deletionFromBrickKilnDetailMaster.get(i).delete()
					}
				}	
////////////////////////////BrickKilnDetailInspection///////////////////////////////////
			def deletionFromBrickKilnDetailInspection = BrickKilnDetailInspection.findAll("from BrickKilnDetailInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromBrickKilnDetailInspection){
				for(int i=0;i<deletionFromBrickKilnDetailInspection.size();i++){
					deletionFromBrickKilnDetailInspection.get(i).delete()
					}
				}	
////////////////////////////BrickSittingCriteriaDetailsMaster///////////////////////////////////
			def deletionFromBrickSittingCriteriaDetailsMaster = BrickSittingCriteriaDetailsMaster.findAll("from BrickSittingCriteriaDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromBrickSittingCriteriaDetailsMaster){
				for(int i=0;i<deletionFromBrickSittingCriteriaDetailsMaster.size();i++){
					deletionFromBrickSittingCriteriaDetailsMaster.get(i).delete()
					}
				}
////////////////////////////BrickSittingCriteriaDetailsInspection///////////////////////////////////
			def deletionFromBrickSittingCriteriaDetailsInspection = BrickSittingCriteriaDetailsInspection.findAll("from BrickSittingCriteriaDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromBrickSittingCriteriaDetailsInspection){
				for(int i=0;i<deletionFromBrickSittingCriteriaDetailsInspection.size();i++){
					deletionFromBrickSittingCriteriaDetailsInspection.get(i).delete()
					}
				}
////////////////////////////StoneCrusherControlDevicesMasterM///////////////////////////////////
			def deletionFromStoneCrusherControlDevicesMasterM = StoneCrusherControlDevicesMasterM.findAll("from StoneCrusherControlDevicesMasterM abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoneCrusherControlDevicesMasterM){
				for(int i=0;i<deletionFromStoneCrusherControlDevicesMasterM.size();i++){
					deletionFromStoneCrusherControlDevicesMasterM.get(i).delete()
					}
				}
////////////////////////////StoneCrusherControlDevicesInspection///////////////////////////////////
			def deletionFromStoneCrusherControlDevicesInspection = StoneCrusherControlDevicesInspection.findAll("from StoneCrusherControlDevicesInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoneCrusherControlDevicesInspection){
				for(int i=0;i<deletionFromStoneCrusherControlDevicesInspection.size();i++){
					deletionFromStoneCrusherControlDevicesInspection.get(i).delete()
					}
				}
////////////////////////////StoneCrusherSittingCriteriaMaster///////////////////////////////////
			def deletionFromStoneCrusherSittingCriteriaMaster = StoneCrusherSittingCriteriaMaster.findAll("from StoneCrusherSittingCriteriaMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoneCrusherSittingCriteriaMaster){
				for(int i=0;i<deletionFromStoneCrusherSittingCriteriaMaster.size();i++){
					deletionFromStoneCrusherSittingCriteriaMaster.get(i).delete()
					}
				}
////////////////////////////StoneCrusherSittingCriteriaInspection///////////////////////////////////
			def deletionFromStoneCrusherSittingCriteriaInspection = StoneCrusherSittingCriteriaInspection.findAll("from StoneCrusherSittingCriteriaInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromStoneCrusherSittingCriteriaInspection){
				for(int i=0;i<deletionFromStoneCrusherSittingCriteriaInspection.size();i++){
					deletionFromStoneCrusherSittingCriteriaInspection.get(i).delete()
					}
				}
////////////////////////////NocAuthorityDetailsMaster///////////////////////////////////
			def deletionFromNocAuthorityDetailsMaster = NocAuthorityDetailsMaster.findAll("from NocAuthorityDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromNocAuthorityDetailsMaster){
				for(int i=0;i<deletionFromNocAuthorityDetailsMaster.size();i++){
					deletionFromNocAuthorityDetailsMaster.get(i).delete()
					}
				}
////////////////////////////NocAuthorityDetailsInspection///////////////////////////////////
			def deletionFromNocAuthorityDetailsInspection = NocAuthorityDetailsInspection.findAll("from NocAuthorityDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromNocAuthorityDetailsInspection){
				for(int i=0;i<deletionFromNocAuthorityDetailsInspection.size();i++){
					deletionFromNocAuthorityDetailsInspection.get(i).delete()
					}
				}
////////////////////////////DGSetParameterDetailsMaster///////////////////////////////////
			def deletionFromDGSetParameterDetailsMaster = DGSetParameterDetailsMaster.findAll("from DGSetParameterDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromDGSetParameterDetailsMaster){
				for(int i=0;i<deletionFromDGSetParameterDetailsMaster.size();i++){
					deletionFromDGSetParameterDetailsMaster.get(i).delete()
					}
				}
////////////////////////////DGSetParameterDetailsInspection///////////////////////////////////
			def deletionFromDGSetParameterDetailsInspection = DGSetParameterDetailsInspection.findAll("from DGSetParameterDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromDGSetParameterDetailsInspection){
				for(int i=0;i<deletionFromDGSetParameterDetailsInspection.size();i++){
					deletionFromDGSetParameterDetailsInspection.get(i).delete()
					}
				}
////////////////////////////DGSetEmissionDetailsMaster///////////////////////////////////
			def deletionFromDGSetEmissionDetailsMaster = DGSetEmissionDetailsMaster.findAll("from DGSetEmissionDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromDGSetEmissionDetailsMaster){
				for(int i=0;i<deletionFromDGSetEmissionDetailsMaster.size();i++){
					deletionFromDGSetEmissionDetailsMaster.get(i).delete()
					}
				}
////////////////////////////DGSetEmissionDetailsInspection///////////////////////////////////
			def deletionFromDGSetEmissionDetailsInspection = DGSetEmissionDetailsInspection.findAll("from DGSetEmissionDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromDGSetEmissionDetailsInspection){
				for(int i=0;i<deletionFromDGSetEmissionDetailsInspection.size();i++){
					deletionFromDGSetEmissionDetailsInspection.get(i).delete()
					}
				}
////////////////////////////DGSetDetailsMaster///////////////////////////////////
			def deletionFromDGSetDetailsMaster = DGSetDetailsMaster.findAll("from DGSetDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromDGSetDetailsMaster){
				for(int i=0;i<deletionFromDGSetDetailsMaster.size();i++){
					deletionFromDGSetDetailsMaster.get(i).delete()
					}
				}
////////////////////////////DGSetDetailsInspection///////////////////////////////////
			def deletionFromDGSetDetailsInspection = DGSetDetailsInspection.findAll("from DGSetDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromDGSetDetailsInspection){
				for(int i=0;i<deletionFromDGSetDetailsInspection.size();i++){
					deletionFromDGSetDetailsInspection.get(i).delete()
					}
				}
////////////////////////////ConsentDetails///////////////////////////////////
			def deletionFromConsentDetails = ConsentDetails.findAll("from ConsentDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromConsentDetails){
				for(int i=0;i<deletionFromConsentDetails.size();i++){
					deletionFromConsentDetails.get(i).delete()
					}
				}
////////////////////////////IndustryMasterDetailsRecord///////////////////////////////////
			def deletionFromIndustryMasterDetailsRecord = IndustryMasterDetailsRecord.findAll("from IndustryMasterDetailsRecord abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndustryMasterDetailsRecord){
				for(int i=0;i<deletionFromIndustryMasterDetailsRecord.size();i++){
					deletionFromIndustryMasterDetailsRecord.get(i).delete()
					}
				}
////////////////////////////ConsentInspectionReport///////////////////////////////////
			def deletionFromConsentInspectionReport = ConsentInspectionReport.findAll("from ConsentInspectionReport abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromConsentInspectionReport){
				for(int i=0;i<deletionFromConsentInspectionReport.size();i++){
					deletionFromConsentInspectionReport.get(i).delete()
					}
				}
////////////////////////////WaterConsumptionDetailMaster///////////////////////////////////
			def deletionFromWaterConsumptionDetailMaster = WaterConsumptionDetailMaster.findAll("from WaterConsumptionDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromWaterConsumptionDetailMaster){
				for(int i=0;i<deletionFromWaterConsumptionDetailMaster.size();i++){
					deletionFromWaterConsumptionDetailMaster.get(i).delete()
					}
				}
////////////////////////////WaterModeUseDetails///////////////////////////////////
			def deletionFromWaterModeUseDetails = WaterModeUseDetails.findAll("from WaterModeUseDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromWaterModeUseDetails){
				for(int i=0;i<deletionFromWaterModeUseDetails.size();i++){
					deletionFromWaterModeUseDetails.get(i).delete()
				}
			}	
////////////////////////////IndExpenditureCostDetails///////////////////////////////////
			def deletionFromIndExpenditureCostDetails = IndExpenditureCostDetails.findAll("from IndExpenditureCostDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndExpenditureCostDetails){
				for(int i=0;i<deletionFromIndExpenditureCostDetails.size();i++){
					deletionFromIndExpenditureCostDetails.get(i).delete()
				}
			}
////////////////////////////WaterSolidWasteGenDetails///////////////////////////////////
			def deletionFromWaterSolidWasteGenDetails = WaterSolidWasteGenDetails.findAll("from WaterSolidWasteGenDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromWaterSolidWasteGenDetails){
			for(int i=0;i<deletionFromWaterSolidWasteGenDetails.size();i++){
				deletionFromWaterSolidWasteGenDetails.get(i).delete()
			}
			}
////////////////////////////IndProductDetails///////////////////////////////////
			def deletionFromIndProductDetails = IndProductDetails.findAll("from IndProductDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndProductDetails){
				for(int i=0;i<deletionFromIndProductDetails.size();i++){
					deletionFromIndProductDetails.get(i).delete()
				}
			}
////////////////////////////ConsentCertStackDetails///////////////////////////////////
			def deletionFromConsentCertStackDetails = ConsentCertStackDetails.findAll("from ConsentCertStackDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromConsentCertStackDetails){
				for(int i=0;i<deletionFromConsentCertStackDetails.size();i++){
					deletionFromConsentCertStackDetails.get(i).delete()
				}
			}	
////////////////////////////FeeBankOtherDetails///////////////////////////////////
			def deletionFromFeeBankOtherDetails = FeeBankOtherDetails.findAll("from FeeBankOtherDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromFeeBankOtherDetails){
				for(int i=0;i<deletionFromFeeBankOtherDetails.size();i++){
					deletionFromFeeBankOtherDetails.get(i).delete()
				}
			}
////////////////////////////FeeBankDetails///////////////////////////////////
			def deletionFromFeeBankDetails = FeeBankDetails.findAll("from FeeBankDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			 
			if(deletionFromFeeBankDetails){
				for(int i=0;i<deletionFromFeeBankDetails.size();i++){
					deletionFromFeeBankDetails.get(i).delete()
				}
			}
////////////////////////////ConsentFeeMaster///////////////////////////////////
			def deletionFromConsentFeeMaster = ConsentFeeMaster.findAll("from ConsentFeeMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromConsentFeeMaster){
				for(int i=0;i<deletionFromConsentFeeMaster.size();i++){
					deletionFromConsentFeeMaster.get(i).delete()
				}
			}
////////////////////////////FeeChequeRecord///////////////////////////////////
			def deletionFromFeeChequeRecord = FeeChequeRecord.findAll("from FeeChequeRecord abc where abc.indApplication.id=?",[getApplicationID.get(ui).toLong()])

			if(deletionFromFeeChequeRecord){
				for(int i=0;i<deletionFromFeeChequeRecord.size();i++){
					deletionFromFeeChequeRecord.get(i).delete()
				}
			}				
/////////////////////////////////////ApplicationProcessingDetails///////////////////////////////////////////////
			def deletionFromApplicationProcessingDetail = ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			 
			if(deletionFromApplicationProcessingDetail){
				for(int i=0;i<deletionFromApplicationProcessingDetail.size();i++){
						deletionFromApplicationProcessingDetail.get(i).delete()
							}
						}	
////////////////////////////ApplicationPendingDetails///////////////////////////////////				
			def deletionFromApplicationPendingDetail = ApplicationPendingDetails.findAll("from ApplicationPendingDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromApplicationPendingDetail){
						for(int i=0;i<deletionFromApplicationPendingDetail.size();i++){
							deletionFromApplicationPendingDetail.get(i).delete()
							}
						}	
////////////////////////////RecordCertificate///////////////////////////////////					
			def deletionFromRecordCertificate = RecordCertificate.findAll("from RecordCertificate abc where abc.applicationId.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromRecordCertificate){
					for(int i=0;i<deletionFromRecordCertificate.size();i++){
						deletionFromRecordCertificate.get(i).delete()
							}
						}
///////////////////////////ApplicationFileRecord///////////////////////////////////
			def deletionFromApplicationFileRecord = ApplicationFileRecord.findAll("from ApplicationFileRecord abc where abc.indApplication.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromApplicationFileRecord){
				for(int i=0;i<deletionFromApplicationFileRecord.size();i++){
						deletionFromApplicationFileRecord.get(i).delete()
						}
				}
///////////for deleting attachment from application Documents////////////////////////
			def deletionFromApplicationDocuments = ApplicationDocuments.findAll("from ApplicationDocuments abc where abc.indApplication.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromApplicationDocuments){
					for(int i=0;i<deletionFromApplicationDocuments.size();i++){
							deletionFromApplicationDocuments.get(i).delete()
							}
					}
///////////UploadConsentOrder//////////////////////////////////////////////////////////////////					
			def deletionFromUploadConsentOrder = UploadConsentOrder.findAll("from UploadConsentOrder abc where abc.applicationId.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromUploadConsentOrder){
					for(int i=0;i<deletionFromUploadConsentOrder.size();i++){
							deletionFromUploadConsentOrder.get(i).delete()
								}
							}	
///////////AllSummaryReport//////////////////////////////////////////////////////////////////						
			def deletionFromAllSummaryReport = AllSummaryReport.findAll("from AllSummaryReport abc where abc.applicationId=?",[getApplicationID.get(ui).toString()])
			if(deletionFromAllSummaryReport){
					for(int i=0;i<deletionFromAllSummaryReport.size();i++){
						deletionFromAllSummaryReport.get(i).delete()
						}
					}
println("[getApplicationID.get(ui).toString()===="+getApplicationID.get(ui).toString())
//////////	/AutoRenew//////////////////////////////////////////////////////////////////						
			def deletionFromAutoRenewDetails = AutoRenewDetails.findAll("from AutoRenewDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
			if(deletionFromAutoRenewDetails){
					for(int i=0;i<deletionFromAutoRenewDetails.size();i++){
						deletionFromAutoRenewDetails.get(i).delete()
						}
					}

////////////////////////////BankTransaction///////////////////////////////////
def deletionFromBankTransactionDetails = BankTransactionDetails.findAll("from BankTransactionDetails abc where abc.indApplication.id=? and abc.transactionStatus ='F' ",[getApplicationID.get(ui).toLong()])
if(deletionFromBankTransactionDetails){
for(int i=0;i<deletionFromBankTransactionDetails.size();i++){
	deletionFromBankTransactionDetails.get(i).delete()
}
}	
///////////IndApplicationDetails//////////////////////////////////////////////////////////////////	
			def deletionFromIndApplicationDetails = IndApplicationDetails.findAll("from IndApplicationDetails abc where abc.id=? ",[getApplicationID.get(ui).toLong()])
			if(deletionFromIndApplicationDetails){
					for(int i=0;i<deletionFromIndApplicationDetails.size();i++){
							deletionFromIndApplicationDetails.get(i).delete()
							}
						flash.message="Application  Deleted !! "
						render(view:'delApp')
						}
					}
					}else{
						flash.message="Enter valid application ID!! "
							render(view:'delApp')	
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
	
def deletedind = {}
	
def deleteIndRegMaster = {
			 try {
					def indId = params.surroundingName
				   def getIndsutryId = IndUser.find("from IndUser abc where abc.id=? ",[indId])
					if(getIndsutryId){
////////////////////////industry ID/////////////////////////
					def industryId = getIndsutryId.industryRegMaster.id
////////////////////////////////////////////////////////////			//
	def getApplicationID = IndApplicationDetails.findAll("from IndApplicationDetails abc where abc.indUser.id=? ",[industryId])
		getApplicationID= getApplicationID.id
///////////////////////deleting application id from all consent tables/////////////////////////////
		if(getApplicationID){
			for(int ui=0;ui<getApplicationID.size();ui++){				
//////////////////////////////		HotelWaterConsumptionDetail///////////////////////////////////
				def deletionFromHotelWaterConsumptionDetail = HotelWaterConsumptionDetail.findAll("from HotelWaterConsumptionDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromHotelWaterConsumptionDetail){
					for(int i=0;i<deletionFromHotelWaterConsumptionDetail.size();i++){
						deletionFromHotelWaterConsumptionDetail.get(i).delete()
						}
					}
//////////////////////////////StoneCrusherWaterReq///////////////////////////////////
				def deletionFromStoneCrusherWaterReq = StoneCrusherWaterReq.findAll("from StoneCrusherWaterReq abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromStoneCrusherWaterReq){
					for(int i=0;i<deletionFromStoneCrusherWaterReq.size();i++){
						deletionFromStoneCrusherWaterReq.get(i).delete()
						}
					}
//////////////////////////////HotelWasteEmissionDetail///////////////////////////////////
				def deletionFromHotelWasteEmissionDetail = HotelWasteEmissionDetail.findAll("from HotelWasteEmissionDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromHotelWasteEmissionDetail){
					for(int i=0;i<deletionFromHotelWasteEmissionDetail.size();i++){
						deletionFromHotelWasteEmissionDetail.get(i).delete()
						}
					}
//////////////////////////////HotelWasteEmissionDetailMaster///////////////////////////////////
				def deletionFromHotelWasteEmissionDetailMaster = HotelWasteEmissionDetailMaster.findAll("from HotelWasteEmissionDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromHotelWasteEmissionDetailMaster){
					for(int i=0;i<deletionFromHotelWasteEmissionDetailMaster.size();i++){
						deletionFromHotelWasteEmissionDetailMaster.get(i).delete()
						}
					}
//////////////////////////////HotelFacilityDetail///////////////////////////////////
				def deletionFromHotelFacilityDetail = HotelFacilityDetail.findAll("from HotelFacilityDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromHotelFacilityDetail){
					for(int i=0;i<deletionFromHotelFacilityDetail.size();i++){
						deletionFromHotelFacilityDetail.get(i).delete()
						}
					}
//////////////////////////////HotelGeneralDetails///////////////////////////////////
				def deletionFromHotelGeneralDetails = HotelGeneralDetails.findAll("from HotelGeneralDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromHotelGeneralDetails){
					for(int i=0;i<deletionFromHotelGeneralDetails.size();i++){
						deletionFromHotelGeneralDetails.get(i).delete()
						}
					}
//////////////////////////////WaterConsumptionDetail///////////////////////////////////
				def deletionFromWaterConsumptionDetail = WaterConsumptionDetail.findAll("from WaterConsumptionDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromWaterConsumptionDetail){
					for(int i=0;i<deletionFromWaterConsumptionDetail.size();i++){
						deletionFromWaterConsumptionDetail.get(i).delete()
						}
					}
//////////////////////////////BrickKilnDetail///////////////////////////////////
				def deletionFromBrickKilnDetail = BrickKilnDetail.findAll("from BrickKilnDetail abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromBrickKilnDetail){
					for(int i=0;i<deletionFromBrickKilnDetail.size();i++){
						deletionFromBrickKilnDetail.get(i).delete()
						}
					}
////////////////////////////ConsentCertStackDetails///////////////////////////////////
				def deletionFromConsentCertStackDetails = ConsentCertStackDetails.findAll("from ConsentCertStackDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromConsentCertStackDetails){
					for(int i=0;i<deletionFromConsentCertStackDetails.size();i++){
						deletionFromConsentCertStackDetails.get(i).delete()
					}
				}
//////////////////////////////BrickSittingCriteriaDetails///////////////////////////////////
				def deletionFromBrickSittingCriteriaDetails = BrickSittingCriteriaDetails.findAll("from BrickSittingCriteriaDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromBrickSittingCriteriaDetails){
					for(int i=0;i<deletionFromBrickSittingCriteriaDetails.size();i++){
						deletionFromBrickSittingCriteriaDetails.get(i).delete()
						}
					}
//////////////////////////////NocAuthorityDetails///////////////////////////////////
				def deletionFromNocAuthorityDetails = NocAuthorityDetails.findAll("from NocAuthorityDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromNocAuthorityDetails){
					for(int i=0;i<deletionFromNocAuthorityDetails.size();i++){
						deletionFromNocAuthorityDetails.get(i).delete()
						}
					}
//////////////////////////////StoneCrusherControlDevices///////////////////////////////////
				def deletionFromStoneCrusherControlDevices = StoneCrusherControlDevices.findAll("from StoneCrusherControlDevices abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromStoneCrusherControlDevices){
					for(int i=0;i<deletionFromStoneCrusherControlDevices.size();i++){
						deletionFromStoneCrusherControlDevices.get(i).delete()
						}
					}
//////////////////////////////StoneCrusherSittingCriteria///////////////////////////////////
				def deletionFromStoneCrusherSittingCriteria = StoneCrusherSittingCriteria.findAll("from StoneCrusherSittingCriteria abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromStoneCrusherSittingCriteria){
					for(int i=0;i<deletionFromStoneCrusherSittingCriteria.size();i++){
						deletionFromStoneCrusherSittingCriteria.get(i).delete()
						}
					}
//////////////////////////////DGSetParameterDetails///////////////////////////////////
				def deletionFromDGSetParameterDetails = DGSetParameterDetails.findAll("from DGSetParameterDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromDGSetParameterDetails){
					for(int i=0;i<deletionFromDGSetParameterDetails.size();i++){
						deletionFromDGSetParameterDetails.get(i).delete()
						}
					}
////////////////////////////DGSetEmissionDetails///////////////////////////////////
				def deletionFromDGSetEmissionDetails = DGSetEmissionDetails.findAll("from DGSetEmissionDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromDGSetEmissionDetails){
					for(int i=0;i<deletionFromDGSetEmissionDetails.size();i++){
						deletionFromDGSetEmissionDetails.get(i).delete()
						}
					}
////////////////////////////DGSetDetails///////////////////////////////////
				def deletionFromDGSetDetails = DGSetDetails.findAll("from DGSetDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromDGSetDetails){
					for(int i=0;i<deletionFromDGSetDetails.size();i++){
						deletionFromDGSetDetails.get(i).delete()
						}
					}
////////////////////////////AirMiscDetails///////////////////////////////////
				def deletionFromAirMiscDetails = AirMiscDetails.findAll("from AirMiscDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
				if(deletionFromAirMiscDetails){
					for(int i=0;i<deletionFromAirMiscDetails.size();i++){
						deletionFromAirMiscDetails.get(i).delete()
						}
					}
////////////////////////////AirFlueGasDetails///////////////////////////////////
		def deletionFromAirFlueGasDetails = AirFlueGasDetails.findAll("from AirFlueGasDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromAirFlueGasDetails){
		for(int ii=0;ii<deletionFromAirFlueGasDetails.size();ii++){
		deletionFromAirFlueGasDetails.get(ii).delete()	
		}
		}
////////////////////////////AirStackDetails///////////////////////////////////
		def deletionFromAirStackDetails = AirStackDetails.findAll("from AirStackDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		def deletionFromAirStackDetails1 = deletionFromAirStackDetails.id
		if(deletionFromAirStackDetails1){
		for(int i=0;i<deletionFromAirStackDetails1.size();i++){
		def deletionFromAirFlueGasPollutionCntrlDetails = AirFlueGasPollutionCntrlDetails.findAll("from AirFlueGasPollutionCntrlDetails abc where abc.stack.id=?",[deletionFromAirStackDetails1.get(i).toLong()])
		if(deletionFromAirFlueGasPollutionCntrlDetails){
			for(int ii=0;ii<deletionFromAirFlueGasPollutionCntrlDetails.size();ii++){
				deletionFromAirFlueGasPollutionCntrlDetails.get(ii).delete()	
			}
		}
		def deletionFromAirStackPollutionCntrlDetails = AirStackPollutionCntrlDetails.findAll("from AirStackPollutionCntrlDetails abc where abc.stack.id=?",[deletionFromAirStackDetails1.get(i).toLong()])
		if(deletionFromAirStackPollutionCntrlDetails){
			for(int ii=0;ii<deletionFromAirStackPollutionCntrlDetails.size();ii++){
				deletionFromAirStackPollutionCntrlDetails.get(ii).delete()	
			}
		}
		}
		}
		if(deletionFromAirStackDetails){
		for(int ii=0;ii<deletionFromAirStackDetails.size();ii++){
		deletionFromAirStackDetails.get(ii).delete()	
		}
		}
////////////////////////////MiscellaneousDetails///////////////////////////////////
		def deletionFromMiscellaneousDetails = MiscellaneousDetails.findAll("from MiscellaneousDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromMiscellaneousDetails){
		for(int i=0;i<deletionFromMiscellaneousDetails.size();i++){
		deletionFromMiscellaneousDetails.get(i).delete()
		}
		}
////////////////////////////HazardousChemicalDetails///////////////////////////////////
		def deletionFromHazardousChemicalDetails = HazardousChemicalDetails.findAll("from HazardousChemicalDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazardousChemicalDetails){
		for(int i=0;i<deletionFromHazardousChemicalDetails.size();i++){
		deletionFromHazardousChemicalDetails.get(i).delete()
		}
		}
////////////////////////////HazardousWasteStorDisDetails///////////////////////////////////
		def deletionFromHazardousWasteStorDisDetails = HazardousWasteStorDisDetails.findAll("from HazardousWasteStorDisDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazardousWasteStorDisDetails){
		for(int i=0;i<deletionFromHazardousWasteStorDisDetails.size();i++){
		deletionFromHazardousWasteStorDisDetails.get(i).delete()
		}
		}
////////////////////////////HazardousWasteGenDetails///////////////////////////////////
		def deletionFromHazardousWasteGenDetails = HazardousWasteGenDetails.findAll("from HazardousWasteGenDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazardousWasteGenDetails){
		for(int ii=0;ii<deletionFromHazardousWasteGenDetails.size();ii++){
		deletionFromHazardousWasteGenDetails.get(ii).delete()	
		}
		}
////////////////////////////HazardousWasteGenDetailsCert///////////////////////////////////
		def deletionFromHazardousWasteGenDetailsCert = HazardousWasteGenDetailsCert.findAll("from HazardousWasteGenDetailsCert abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazardousWasteGenDetailsCert){
			for(int ii=0;ii<deletionFromHazardousWasteGenDetailsCert.size();ii++){
				deletionFromHazardousWasteGenDetailsCert.get(ii).delete()	
			}
			}
////////////////////////////WaterWasteGenerationDetails///////////////////////////////////
		def deletionFromWaterWasteGenerationDetails = WaterWasteGenerationDetails.findAll("from WaterWasteGenerationDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWaterWasteGenerationDetails){
		for(int i=0;i<deletionFromWaterWasteGenerationDetails.size();i++){
		deletionFromWaterWasteGenerationDetails.get(i).delete()
		}
		}
////////////////////////////WasteWaterTreatmentDetails///////////////////////////////////
		def deletionFromWasteWaterTreatmentDetails = WasteWaterTreatmentDetails.findAll("from WasteWaterTreatmentDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWasteWaterTreatmentDetails){
		for(int i=0;i<deletionFromWasteWaterTreatmentDetails.size();i++){
		deletionFromWasteWaterTreatmentDetails.get(i).delete()
		}
		}
////////////////////////////WaterSourceDetails///////////////////////////////////
		def deletionFromWaterSourceDetails = WaterSourceDetails.findAll("from WaterSourceDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWaterSourceDetails){
		for(int i=0;i<deletionFromWaterSourceDetails.size();i++){
		deletionFromWaterSourceDetails.get(i).delete()
		}
		}
////////////////////////////QuantHaz///////////////////////////////////
		def deletionFromQuantHazDetails = QuantHaz.findAll("from QuantHaz abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromQuantHazDetails){
		for(int i=0;i<deletionFromQuantHazDetails.size();i++){
			deletionFromQuantHazDetails.get(i).delete()
		}
		}
////////////////////////////Hazsub///////////////////////////////////
		def deletionFromHazsubDetails = Hazsub.findAll("from Hazsub abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazsubDetails){
		for(int i=0;i<deletionFromHazsubDetails.size();i++){
			deletionFromHazsubDetails.get(i).delete()
		}
		}
////////////////////////////Hazwaste///////////////////////////////////
		def deletionFromHazwasteDetails = Hazwaste.findAll("from Hazwaste abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazwasteDetails){
		for(int i=0;i<deletionFromHazwasteDetails.size();i++){
			deletionFromHazwasteDetails.get(i).delete()
		}
		}		
///////////////////////////StoreMode///////////////////////////////////
		def deletionFromStoreModeDetails = StoreMode.findAll("from StoreMode abc where abc.app8.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoreModeDetails){
			for(int i=0;i<deletionFromStoreModeDetails.size();i++){
				deletionFromStoreModeDetails.get(i).delete()
				}
			}
////////////////////////////InspectionFwdNotice///////////////////////////////////
		def deletionFromInspectionFwdNoticeDetails = InspectionFwdNotice.findAll("from InspectionFwdNotice abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromInspectionFwdNoticeDetails){
			for(int i=0;i<deletionFromInspectionFwdNoticeDetails.size();i++){
				deletionFromInspectionFwdNoticeDetails.get(i).delete()
				}
			}	
////////////////////////////RegularInspectionRaised///////////////////////////////////
		def deletionFromRegularInspectionRaisedDetails = RegularInspectionRaised.findAll("from RegularInspectionRaised abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromRegularInspectionRaisedDetails){
			for(int i=0;i<deletionFromRegularInspectionRaisedDetails.size();i++){
				deletionFromRegularInspectionRaisedDetails.get(i).delete()
				}
			}	
////////////////////////////InspectionNoteHistory///////////////////////////////////
		def deletionFromInspectionNoteHistoryDetails = InspectionNoteHistory.findAll("from InspectionNoteHistory abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromInspectionNoteHistoryDetails){
			for(int i=0;i<deletionFromInspectionNoteHistoryDetails.size();i++){
				deletionFromInspectionNoteHistoryDetails.get(i).delete()
				}
			}	
////////////////////////////IndustryInspectionReport///////////////////////////////////
		def deletionFromIndustryInspectionReportDetails = IndustryInspectionReport.findAll("from IndustryInspectionReport abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndustryInspectionReportDetails){
			for(int i=0;i<deletionFromIndustryInspectionReportDetails.size();i++){
				deletionFromIndustryInspectionReportDetails.get(i).delete()
				}
			}
////////////////////////////CosentCertHotelDetails///////////////////////////////////
		def deletionFromCosentCertHotelDetailsDetails = CosentCertHotelDetails.findAll("from CosentCertHotelDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromCosentCertHotelDetailsDetails){
			for(int i=0;i<deletionFromCosentCertHotelDetailsDetails.size();i++){
				deletionFromCosentCertHotelDetailsDetails.get(i).delete()
				}
			}
////////////////////////////CosentCertProductDetails///////////////////////////////////
		def deletionFromCosentCertProductDetailsDetails = CosentCertProductDetails.findAll("from CosentCertProductDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromCosentCertProductDetailsDetails){
			for(int i=0;i<deletionFromCosentCertProductDetailsDetails.size();i++){
				deletionFromCosentCertProductDetailsDetails.get(i).delete()
				}
			}
////////////////////////////CosentCertSolidWasteDisposalDetails///////////////////////////////////
		def deletionFromCosentCertSolidWasteDisposalDetailsDetails = CosentCertSolidWasteDisposalDetails.findAll("from CosentCertSolidWasteDisposalDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromCosentCertSolidWasteDisposalDetailsDetails){
			for(int i=0;i<deletionFromCosentCertSolidWasteDisposalDetailsDetails.size();i++){
				deletionFromCosentCertSolidWasteDisposalDetailsDetails.get(i).delete()
				}
			}
////////////////////////////ConsentInspectionReportEERecommendations///////////////////////////////////
		def deletionFromConsentInspectionReportEERecommendations = ConsentInspectionReportEERecommendations.findAll("from ConsentInspectionReportEERecommendations abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromConsentInspectionReportEERecommendations){
			for(int i=0;i<deletionFromConsentInspectionReportEERecommendations.size();i++){
				deletionFromConsentInspectionReportEERecommendations.get(i).delete()
				}
			}	
////////////////////////////ConsentRegularInspectionEERecommendations///////////////////////////////////
		def deletionFromConsentRegularInspectionEERecommendations = ConsentRegularInspectionEERecommendations.findAll("from ConsentRegularInspectionEERecommendations abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromConsentRegularInspectionEERecommendations){
			for(int i=0;i<deletionFromConsentRegularInspectionEERecommendations.size();i++){
				deletionFromConsentRegularInspectionEERecommendations.get(i).delete()
				}
			}	
////////////////////////////IndProductDetailsMaster///////////////////////////////////
		def deletionFromIndProductDetailsMaster = IndProductDetailsMaster.findAll("from IndProductDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndProductDetailsMaster){
			for(int i=0;i<deletionFromIndProductDetailsMaster.size();i++){
				deletionFromIndProductDetailsMaster.get(i).delete()
				}
			}	
////////////////////////////IndProductDetailsInspection///////////////////////////////////
		def deletionFromIndProductDetailsInspection = IndProductDetailsInspection.findAll("from IndProductDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndProductDetailsInspection){
			for(int i=0;i<deletionFromIndProductDetailsInspection.size();i++){
				deletionFromIndProductDetailsInspection.get(i).delete()
				}
			}	
////////////////////////////AirStackDetailsMaster///////////////////////////////////
		def deletionFromAirStackDetailsMaster = AirStackDetailsMaster.findAll("from AirStackDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		def deletionFromAirStackDetails11 = deletionFromAirStackDetailsMaster.id
		if(deletionFromAirStackDetails11){
			for(int i=0;i<deletionFromAirStackDetails11.size();i++){
				def deletionFromAirFlueGasPollutionCntrlDetails = AirFlueGasPollutionCntrlDetailsMaster.findAll("from AirFlueGasPollutionCntrlDetailsMaster abc where abc.stack.id=?",[deletionFromAirStackDetails11.get(ui).toLong()])
				if(deletionFromAirFlueGasPollutionCntrlDetails){
					for(int ii=0;ii<deletionFromAirFlueGasPollutionCntrlDetails.size();ii++){
						deletionFromAirFlueGasPollutionCntrlDetails.get(ii).delete()	
					}
				}
				def deletionFromAirStackPollutionCntrlDetails = AirStackPollutionCntrlDetailsMaster.findAll("from AirStackPollutionCntrlDetailsMaster abc where abc.stack.id=?",[deletionFromAirStackDetails11.get(ui).toLong()])
				if(deletionFromAirStackPollutionCntrlDetails){
					for(int ii=0;ii<deletionFromAirStackPollutionCntrlDetails.size();ii++){
						deletionFromAirStackPollutionCntrlDetails.get(ii).delete()	
					}
				}
				}
			}
		if(deletionFromAirStackDetailsMaster){
			for(int ii=0;ii<deletionFromAirStackDetailsMaster.size();ii++){
				deletionFromAirStackDetailsMaster.get(ii).delete()	
			}
		}	
////////////////////////////AirStackDetailsInspection///////////////////////////////////
		def deletionFromAirStackDetailsInspection = AirStackDetailsInspection.findAll("from AirStackDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromAirStackDetailsInspection){
			for(int i=0;i<deletionFromAirStackDetailsInspection.size();i++){
				deletionFromAirStackDetailsInspection.get(i).delete()
				}
			}	
////////////////////////////HotelFacilityDetailMaster///////////////////////////////////
		def deletionFromHotelFacilityDetailMaster = HotelFacilityDetailMaster.findAll("from HotelFacilityDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHotelFacilityDetailMaster){
			for(int i=0;i<deletionFromHotelFacilityDetailMaster.size();i++){
				deletionFromHotelFacilityDetailMaster.get(i).delete()
				}
			}	
////////////////////////////HotelFacilityDetailInspection///////////////////////////////////
		def deletionFromHotelFacilityDetailInspection = HotelFacilityDetailInspection.findAll("from HotelFacilityDetailInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHotelFacilityDetailInspection){
			for(int i=0;i<deletionFromHotelFacilityDetailInspection.size();i++){
				deletionFromHotelFacilityDetailInspection.get(i).delete()
				}
			}	
////////////////////////////HotelWaterConsumptionDetailMaster///////////////////////////////////
		def deletionFromHotelWaterConsumptionDetailMaster = HotelWaterConsumptionDetailMaster.findAll("from HotelWaterConsumptionDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHotelWaterConsumptionDetailMaster){
			for(int i=0;i<deletionFromHotelWaterConsumptionDetailMaster.size();i++){
				deletionFromHotelWaterConsumptionDetailMaster.get(i).delete()
				}
			}	
////////////////////////////HotelWaterConsumptionDetailInspection///////////////////////////////////
		def deletionFromHotelWaterConsumptionDetailInspection = HotelWaterConsumptionDetailInspection.findAll("from HotelWaterConsumptionDetailInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHotelWaterConsumptionDetailInspection){
			for(int i=0;i<deletionFromHotelWaterConsumptionDetailInspection.size();i++){
				deletionFromHotelWaterConsumptionDetailInspection.get(i).delete()
				}
			}	
////////////////////////////HotelGeneralDetailsMaster///////////////////////////////////
		def deletionFromHotelGeneralDetailsMaster = HotelGeneralDetailsMaster.findAll("from HotelGeneralDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHotelGeneralDetailsMaster){
			for(int i=0;i<deletionFromHotelGeneralDetailsMaster.size();i++){
				deletionFromHotelGeneralDetailsMaster.get(i).delete()
				}
			}	
////////////////////////////HotelGeneralDetailsInspection///////////////////////////////////
		def deletionFromHotelGeneralDetailsInspection = HotelGeneralDetailsInspection.findAll("from HotelGeneralDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHotelGeneralDetailsInspection){
			for(int i=0;i<deletionFromHotelGeneralDetailsInspection.size();i++){
				deletionFromHotelGeneralDetailsInspection.get(i).delete()
				}
			}	
////////////////////////////HazardousWasteGenDetailsMaster///////////////////////////////////
		def deletionFromHazardousWasteGenDetailsMaster = HazardousWasteGenDetailsMaster.findAll("from HazardousWasteGenDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazardousWasteGenDetailsMaster){
			for(int i=0;i<deletionFromHazardousWasteGenDetailsMaster.size();i++){
				deletionFromHazardousWasteGenDetailsMaster.get(i).delete()
				}
			}	
////////////////////////////HazardousWasteGenDetailsInspection///////////////////////////////////
		def deletionFromHazardousWasteGenDetailsInspection = HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromHazardousWasteGenDetailsInspection){
			for(int i=0;i<deletionFromHazardousWasteGenDetailsInspection.size();i++){
				deletionFromHazardousWasteGenDetailsInspection.get(i).delete()
				}
			}	
////////////////////////////StoneCrusherWaterReqMaster///////////////////////////////////
		def deletionFromStoneCrusherWaterReqMaster = StoneCrusherWaterReqMaster.findAll("from StoneCrusherWaterReqMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoneCrusherWaterReqMaster){
			for(int i=0;i<deletionFromStoneCrusherWaterReqMaster.size();i++){
				deletionFromStoneCrusherWaterReqMaster.get(i).delete()
				}
			}	
////////////////////////////StoneCrusherWaterReqInspection///////////////////////////////////
		def deletionFromStoneCrusherWaterReqInspection = StoneCrusherWaterReqInspection.findAll("from StoneCrusherWaterReqInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoneCrusherWaterReqInspection){
			for(int i=0;i<deletionFromStoneCrusherWaterReqInspection.size();i++){
				deletionFromStoneCrusherWaterReqInspection.get(i).delete()
				}
			}	
////////////////////////////BrickKilnDetailMaster///////////////////////////////////
		def deletionFromBrickKilnDetailMaster = BrickKilnDetailMaster.findAll("from BrickKilnDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromBrickKilnDetailMaster){
			for(int i=0;i<deletionFromBrickKilnDetailMaster.size();i++){
				deletionFromBrickKilnDetailMaster.get(i).delete()
				}
			}	
////////////////////////////BrickKilnDetailInspection///////////////////////////////////
		def deletionFromBrickKilnDetailInspection = BrickKilnDetailInspection.findAll("from BrickKilnDetailInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromBrickKilnDetailInspection){
			for(int i=0;i<deletionFromBrickKilnDetailInspection.size();i++){
				deletionFromBrickKilnDetailInspection.get(i).delete()
				}
			}	
////////////////////////////BrickSittingCriteriaDetailsMaster///////////////////////////////////
		def deletionFromBrickSittingCriteriaDetailsMaster = BrickSittingCriteriaDetailsMaster.findAll("from BrickSittingCriteriaDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromBrickSittingCriteriaDetailsMaster){
			for(int i=0;i<deletionFromBrickSittingCriteriaDetailsMaster.size();i++){
				deletionFromBrickSittingCriteriaDetailsMaster.get(i).delete()
				}
			}
////////////////////////////BrickSittingCriteriaDetailsInspection///////////////////////////////////
		def deletionFromBrickSittingCriteriaDetailsInspection = BrickSittingCriteriaDetailsInspection.findAll("from BrickSittingCriteriaDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromBrickSittingCriteriaDetailsInspection){
			for(int i=0;i<deletionFromBrickSittingCriteriaDetailsInspection.size();i++){
				deletionFromBrickSittingCriteriaDetailsInspection.get(i).delete()
				}
			}
////////////////////////////StoneCrusherControlDevicesMasterM///////////////////////////////////
		def deletionFromStoneCrusherControlDevicesMasterM = StoneCrusherControlDevicesMasterM.findAll("from StoneCrusherControlDevicesMasterM abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoneCrusherControlDevicesMasterM){
			for(int i=0;i<deletionFromStoneCrusherControlDevicesMasterM.size();i++){
				deletionFromStoneCrusherControlDevicesMasterM.get(i).delete()
				}
			}
////////////////////////////StoneCrusherControlDevicesInspection///////////////////////////////////
		def deletionFromStoneCrusherControlDevicesInspection = StoneCrusherControlDevicesInspection.findAll("from StoneCrusherControlDevicesInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoneCrusherControlDevicesInspection){
			for(int i=0;i<deletionFromStoneCrusherControlDevicesInspection.size();i++){
				deletionFromStoneCrusherControlDevicesInspection.get(i).delete()
				}
			}
////////////////////////////StoneCrusherSittingCriteriaMaster///////////////////////////////////
		def deletionFromStoneCrusherSittingCriteriaMaster = StoneCrusherSittingCriteriaMaster.findAll("from StoneCrusherSittingCriteriaMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoneCrusherSittingCriteriaMaster){
			for(int i=0;i<deletionFromStoneCrusherSittingCriteriaMaster.size();i++){
				deletionFromStoneCrusherSittingCriteriaMaster.get(i).delete()
				}
			}
////////////////////////////StoneCrusherSittingCriteriaInspection///////////////////////////////////
		def deletionFromStoneCrusherSittingCriteriaInspection = StoneCrusherSittingCriteriaInspection.findAll("from StoneCrusherSittingCriteriaInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromStoneCrusherSittingCriteriaInspection){
			for(int i=0;i<deletionFromStoneCrusherSittingCriteriaInspection.size();i++){
				deletionFromStoneCrusherSittingCriteriaInspection.get(i).delete()
				}
			}
////////////////////////////NocAuthorityDetailsMaster///////////////////////////////////
		def deletionFromNocAuthorityDetailsMaster = NocAuthorityDetailsMaster.findAll("from NocAuthorityDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromNocAuthorityDetailsMaster){
			for(int i=0;i<deletionFromNocAuthorityDetailsMaster.size();i++){
				deletionFromNocAuthorityDetailsMaster.get(i).delete()
				}
			}
////////////////////////////NocAuthorityDetailsInspection///////////////////////////////////
		def deletionFromNocAuthorityDetailsInspection = NocAuthorityDetailsInspection.findAll("from NocAuthorityDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromNocAuthorityDetailsInspection){
			for(int i=0;i<deletionFromNocAuthorityDetailsInspection.size();i++){
				deletionFromNocAuthorityDetailsInspection.get(i).delete()
				}
			}
////////////////////////////DGSetParameterDetailsMaster///////////////////////////////////
		def deletionFromDGSetParameterDetailsMaster = DGSetParameterDetailsMaster.findAll("from DGSetParameterDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromDGSetParameterDetailsMaster){
			for(int i=0;i<deletionFromDGSetParameterDetailsMaster.size();i++){
				deletionFromDGSetParameterDetailsMaster.get(i).delete()
				}
			}
////////////////////////////DGSetParameterDetailsInspection///////////////////////////////////
		def deletionFromDGSetParameterDetailsInspection = DGSetParameterDetailsInspection.findAll("from DGSetParameterDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromDGSetParameterDetailsInspection){
			for(int i=0;i<deletionFromDGSetParameterDetailsInspection.size();i++){
				deletionFromDGSetParameterDetailsInspection.get(i).delete()
				}
			}
////////////////////////////DGSetEmissionDetailsMaster///////////////////////////////////
		def deletionFromDGSetEmissionDetailsMaster = DGSetEmissionDetailsMaster.findAll("from DGSetEmissionDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromDGSetEmissionDetailsMaster){
			for(int i=0;i<deletionFromDGSetEmissionDetailsMaster.size();i++){
				deletionFromDGSetEmissionDetailsMaster.get(i).delete()
				}
			}
////////////////////////////DGSetEmissionDetailsInspection///////////////////////////////////
		def deletionFromDGSetEmissionDetailsInspection = DGSetEmissionDetailsInspection.findAll("from DGSetEmissionDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromDGSetEmissionDetailsInspection){
			for(int i=0;i<deletionFromDGSetEmissionDetailsInspection.size();i++){
				deletionFromDGSetEmissionDetailsInspection.get(i).delete()
				}
			}
////////////////////////////DGSetDetailsMaster///////////////////////////////////
		def deletionFromDGSetDetailsMaster = DGSetDetailsMaster.findAll("from DGSetDetailsMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromDGSetDetailsMaster){
			for(int i=0;i<deletionFromDGSetDetailsMaster.size();i++){
				deletionFromDGSetDetailsMaster.get(i).delete()
				}
			}
////////////////////////////DGSetDetailsInspection///////////////////////////////////
		def deletionFromDGSetDetailsInspection = DGSetDetailsInspection.findAll("from DGSetDetailsInspection abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromDGSetDetailsInspection){
			for(int i=0;i<deletionFromDGSetDetailsInspection.size();i++){
				deletionFromDGSetDetailsInspection.get(i).delete()
				}
			}
////////////////////////////ConsentDetails///////////////////////////////////
		def deletionFromConsentDetails = ConsentDetails.findAll("from ConsentDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromConsentDetails){
			for(int i=0;i<deletionFromConsentDetails.size();i++){
				deletionFromConsentDetails.get(i).delete()
				}
			}
////////////////////////////IndustryMasterDetailsRecord///////////////////////////////////
		def deletionFromIndustryMasterDetailsRecord = IndustryMasterDetailsRecord.findAll("from IndustryMasterDetailsRecord abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndustryMasterDetailsRecord){
			for(int i=0;i<deletionFromIndustryMasterDetailsRecord.size();i++){
				deletionFromIndustryMasterDetailsRecord.get(i).delete()
				}
			}
////////////////////////////ConsentInspectionReport///////////////////////////////////
		def deletionFromConsentInspectionReport = ConsentInspectionReport.findAll("from ConsentInspectionReport abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromConsentInspectionReport){
			for(int i=0;i<deletionFromConsentInspectionReport.size();i++){
				deletionFromConsentInspectionReport.get(i).delete()
				}
			}
////////////////////////////WaterConsumptionDetailMaster///////////////////////////////////
		def deletionFromWaterConsumptionDetailMaster = WaterConsumptionDetailMaster.findAll("from WaterConsumptionDetailMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWaterConsumptionDetailMaster){
			for(int i=0;i<deletionFromWaterConsumptionDetailMaster.size();i++){
				deletionFromWaterConsumptionDetailMaster.get(i).delete()
				}
			}
////////////////////////////FeeBankDetailsOfficer///////////////////////////////////
		def deletionFromFeeBankDetailsOfficer = FeeBankDetailsOfficer.findAll("from FeeBankDetailsOfficer abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromFeeBankDetailsOfficer){
			for(int i=0;i<deletionFromFeeBankDetailsOfficer.size();i++){
				deletionFromFeeBankDetailsOfficer.get(i).delete()
				}
			}			
////////////////////////////WaterUsesDetails///////////////////////////////////
		def deletionFromWaterUsesDetails = WaterUsesDetails.findAll("from WaterUsesDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWaterUsesDetails){
		for(int i=0;i<deletionFromWaterUsesDetails.size();i++){
		deletionFromWaterUsesDetails.get(i).delete()
		}
		}
////////////////////////////WaterModeUseDetails///////////////////////////////////
		def deletionFromWaterModeUseDetails = WaterModeUseDetails.findAll("from WaterModeUseDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWaterModeUseDetails){
		for(int i=0;i<deletionFromWaterModeUseDetails.size();i++){
		deletionFromWaterModeUseDetails.get(i).delete()
		}
		}	
////////////////////////////IndExpenditureCostDetails///////////////////////////////////
		def deletionFromIndExpenditureCostDetails = IndExpenditureCostDetails.findAll("from IndExpenditureCostDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndExpenditureCostDetails){
		for(int i=0;i<deletionFromIndExpenditureCostDetails.size();i++){
		deletionFromIndExpenditureCostDetails.get(i).delete()
		}
		}
////////////////////////////WaterSolidWasteGenDetails///////////////////////////////////
		def deletionFromWaterSolidWasteGenDetails = WaterSolidWasteGenDetails.findAll("from WaterSolidWasteGenDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromWaterSolidWasteGenDetails){
		for(int i=0;i<deletionFromWaterSolidWasteGenDetails.size();i++){
			deletionFromWaterSolidWasteGenDetails.get(i).delete()
		}
		}
////////////////////////////IndProductDetails///////////////////////////////////
		def deletionFromIndProductDetails = IndProductDetails.findAll("from IndProductDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndProductDetails){
		for(int i=0;i<deletionFromIndProductDetails.size();i++){
		deletionFromIndProductDetails.get(i).delete()
		}
		}
////////////////////////////FeeBankOtherDetails///////////////////////////////////
		def deletionFromFeeBankOtherDetails = FeeBankOtherDetails.findAll("from FeeBankOtherDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromFeeBankOtherDetails){
		for(int i=0;i<deletionFromFeeBankOtherDetails.size();i++){
		deletionFromFeeBankOtherDetails.get(i).delete()
		}
		}
////////////////////////////FeeBankDetails///////////////////////////////////
		def deletionFromFeeBankDetails = FeeBankDetails.findAll("from FeeBankDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromFeeBankDetails){
		for(int i=0;i<deletionFromFeeBankDetails.size();i++){
		deletionFromFeeBankDetails.get(i).delete()
		}
		}
////////////////////////////ConsentFeeMaster///////////////////////////////////
		def deletionFromConsentFeeMaster = ConsentFeeMaster.findAll("from ConsentFeeMaster abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromConsentFeeMaster){
		for(int i=0;i<deletionFromConsentFeeMaster.size();i++){
		deletionFromConsentFeeMaster.get(i).delete()
		}
		}
////////////////////////////FeeChequeRecord///////////////////////////////////
		def deletionFromFeeChequeRecord = FeeChequeRecord.findAll("from FeeChequeRecord abc where abc.indApplication.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromFeeChequeRecord){
		for(int i=0;i<deletionFromFeeChequeRecord.size();i++){
		deletionFromFeeChequeRecord.get(i).delete()
		}
		}	

	
/////////////////////////////////////ApplicationProcessingDetails///////////////////////////////////////////////
		def deletionFromApplicationProcessingDetail = ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromApplicationProcessingDetail){
		for(int i=0;i<deletionFromApplicationProcessingDetail.size();i++){
			deletionFromApplicationProcessingDetail.get(i).delete()
				}
			}	
////////////////////////////ApplicationPendingDetails///////////////////////////////////				
		def deletionFromApplicationPendingDetail = ApplicationPendingDetails.findAll("from ApplicationPendingDetails abc where abc.application.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromApplicationPendingDetail){
			for(int i=0;i<deletionFromApplicationPendingDetail.size();i++){
				deletionFromApplicationPendingDetail.get(i).delete()
				}
			}	
////////////////////////////RecordCertificate///////////////////////////////////					
		def deletionFromRecordCertificate = RecordCertificate.findAll("from RecordCertificate abc where abc.applicationId.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromRecordCertificate){
		for(int i=0;i<deletionFromRecordCertificate.size();i++){
			deletionFromRecordCertificate.get(i).delete()
				}
			}
////////////////////////////ApplicationFileRecord///////////////////////////////////
		def deletionFromApplicationFileRecord = ApplicationFileRecord.findAll("from ApplicationFileRecord abc where abc.indApplication.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromApplicationFileRecord){
		for(int i=0;i<deletionFromApplicationFileRecord.size();i++){
			deletionFromApplicationFileRecord.get(i).delete()
			}
		}
///////////for deleting attachment from application Documents////////////////////////
		def deletionFromApplicationDocuments = ApplicationDocuments.findAll("from ApplicationDocuments abc where abc.indApplication.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromApplicationDocuments){
		for(int i=0;i<deletionFromApplicationDocuments.size();i++){
				deletionFromApplicationDocuments.get(i).delete()
				}
		}
///////////UploadConsentOrder//////////////////////////////////////////////////////////////////					
		def deletionFromUploadConsentOrder = UploadConsentOrder.findAll("from UploadConsentOrder abc where abc.applicationId.id=?",[getApplicationID.get(ui).toLong()])
		if(deletionFromUploadConsentOrder){
		for(int i=0;i<deletionFromUploadConsentOrder.size();i++){
				deletionFromUploadConsentOrder.get(i).delete()
					}
				}	
///////////AllSummaryReport//////////////////////////////////////////////////////////////////						
		def deletionFromAllSummaryReport = AllSummaryReport.findAll("from AllSummaryReport abc where abc.applicationId=?",[getApplicationID.get(ui).toString()])
		if(deletionFromAllSummaryReport){
		for(int i=0;i<deletionFromAllSummaryReport.size();i++){
			deletionFromAllSummaryReport.get(i).delete()
			}
		}
   

///////////IndApplicationDetails//////////////////////////////////////////////////////////////////	
		def deletionFromIndApplicationDetails = IndApplicationDetails.findAll("from IndApplicationDetails abc where abc.id=? ",[getApplicationID.get(ui).toLong()])
		if(deletionFromIndApplicationDetails){
		for(int i=0;i<deletionFromIndApplicationDetails.size();i++){
				deletionFromIndApplicationDetails.get(i).delete()
				}
			flash.message="Application  Deleted !! "
			render(view:'delApp')
			}
		}				
			}
//////////////////////////////////all data deleted from consent tables//////////////////////////////////		
		def deletionFileRecord = IndFileRecord.findAll("from IndFileRecord abc where abc.indUser.id=? ",[industryId])
			if(deletionFileRecord){
				for(int i=0;i<deletionFileRecord.size();i++){
					deletionFileRecord.get(i).delete()
						}
					}

		def deletionFromIndustryMasterDetails = IndustryMasterDetails.findAll("from IndustryMasterDetails abc where abc.indUser.id=?",[industryId])
		if(deletionFromIndustryMasterDetails){
			for(int i=0;i<deletionFromIndustryMasterDetails.size();i++){
				deletionFromIndustryMasterDetails.get(i).delete()
				}
			}	
		
		def deletionFromIndUser = IndUser.find("from IndUser abc where abc.industryRegMaster.id=? ",[industryId])
			if(deletionFromIndUser){
					deletionFromIndUser.delete()
					}
		
		def deletionFromEnvironmentalClearenceDetails = EnvironmentalClearenceDetails.findAll("from EnvironmentalClearenceDetails abc where abc.indUserUniversal.id=?",[industryId])
		if(deletionFromEnvironmentalClearenceDetails){
		for(int i=0;i<deletionFromEnvironmentalClearenceDetails.size();i++){
			deletionFromEnvironmentalClearenceDetails.get(i).delete()
		}
		}
		
		def deletionFromIndregmaster = IndustryRegMaster.find("from IndustryRegMaster abc where abc.id=? ",[industryId])
					if(deletionFromIndregmaster){
						deletionFromIndregmaster.delete()
						flash.message="Industry Deleted !! "
						render(view:'deletedind')
					}
					}else{
						flash.message="Industry ID Does Not Exit !! "
							render(view:'deletedind')
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
def ajaxGetCitiesRep = {
		try {
		   
		def tst1 = IndCatMaster.findAll("from IndCatMaster aa where aa.name=?",[params.id.toString()])
		def country
		def arr =new ArrayList()
		for(int i=0; i<tst1.size();i++)
		{
//		country = IndustryTypeMaster.get(tst1[i].industryTypeId.toLong())
		country = IndustryTypeMaster.find("from IndustryTypeMaster where id=? ",[tst1[i].industryTypeId.toLong()])
		arr.add(country)
		}
		       arr = arr.sort{it.toString()}
		render arr as JSON

		    
		   
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
//////////?????????? 17 category work

def registerUpdate = {

def a = (session.newUser).toString()
  println("aaaa"+a)
  def newUserInst = NewUser.find("from NewUser where userId= ?",[a])
	println("newUserInst"+newUserInst)
	def tehsilList = TehsilMaster.findAll("from TehsilMaster where district.id = ?",[(newUserInst.districtId).toLong()])

return[newUserInst:newUserInst,tehsilList:tehsilList]		
}



def regUpdate = {
	
	println("params new reg---------"+params)
	
	
	def newUserInst = NewUser.get((params.newId).toLong())
		println("newUserInst---------"+newUserInst)
			println("newUserInst-regId--------"+newUserInst.regId)
			def small = IndTypeMaster.findWhere(name:"small") 
	def indTypeId = newUserInst.industryTypeId
	println("indTypeId--------"+indTypeId)
	println("newUserInst.category--------"+newUserInst.category)
	def catMastId = IndCatMaster.find("from IndCatMaster where name = ? and industryType.id = ?",[newUserInst.category,(indTypeId.toLong())])
	println("catMastId--------"+catMastId)
	def industryRegMasterInstance = new IndustryRegMaster()
	
	industryRegMasterInstance.properties = params
	industryRegMasterInstance.id = newUserInst.regId
	
	industryRegMasterInstance.occName = params.name
	
	industryRegMasterInstance.indName = newUserInst.name
	industryRegMasterInstance.occPhoneNo = newUserInst.mobile
	
	industryRegMasterInstance.dateCreated = new Date()
	industryRegMasterInstance.lastUpdated = new Date()
	industryRegMasterInstance.indType = small
	
	industryRegMasterInstance.industryType = IndustryTypeMaster.get(indTypeId.toLong())
	
	industryRegMasterInstance.category = IndCatMaster.get(catMastId.id)
	
	industryRegMasterInstance.indAddress = newUserInst.address
	
	//industryRegMasterInstance.updated = true
	if(newUserInst.registrationFor=="bmw")
	{
		industryRegMasterInstance.bedNo = params.capNo				
	}
	else{
//		def xyz=String.format("%.2f",params.capNo.toFloat());
//		println("xxxxxxxxxxyyy.."+xyz)
		industryRegMasterInstance.indCapInvt = (params.capNo).toFloat()
	
	}
	if(industryRegMasterInstance.save(flush:true))
	{
		
		println("industryRegMasterInstance>>>>>"+industryRegMasterInstance.id)
	}
	else{
		println("notttttttttt industryRegMasterInstance>>>>>")
		
		industryRegMasterInstance.errors.allErrors.each {
			println it
		
	}
	}
	
	
//	def a = (session.indUser).toString()
//	  println("aaaa"+a)
	  def indUserInstance = new IndUser()
		//println("indUserInstance"+indUserInstance)
	//def indUserInstance= new IndUser()
	  indUserInstance.id = newUserInst.userId
	  indUserInstance.password=newUserInst.password
		indUserInstance.hintQuestion=params.hintQuestion
		indUserInstance.hintAnswer=params.answer
		
	if(session.userMaster){
		indUserInstance.createdBy = session.userMaster
	}
	else{
		indUserInstance.createdBy = newUserInst.name
	}

	  indUserInstance.dateCreated= new Date()
		indUserInstance.industryRegMaster = industryRegMasterInstance
		
		indUserInstance.flag = 1
	if(indUserInstance.save())
	{
		println("indUserInstance>>>>>"+indUserInstance)
		
		newUserInst.regUpdated = true
		newUserInst.save(flush:true)

		session.indUser = indUserInstance
		session.indregName=industryRegMasterInstance
		
		///////?????vr
		if(industryRegMasterInstance && indUserInstance)	
	{
		
		println("In Vender Registration--------")
		VenderRegistration vr = new VenderRegistration()
	
	
		//def ewalletIndName = vr.ReplaceSpecialChar(industryRegMasterInstance.indName)
		HashMap mapq = new HashMap()
		mapq.put("rootElement","vendorDetails")
		mapq.put("RequestID",indUserInstance.id) // request Id is d unique id so send INDUSER id
		mapq.put("merchantCode","ICICI") //hard code by ICICI
		mapq.put("clientCode","JPCB") // by default MCGM
		mapq.put("departmentCode","JPCB") // to be send by ICICI Bank
		mapq.put("vendorCode",indUserInstance.id) // industry user ID
    	mapq.put("vendorName",indUserInstance.id) // Industry Name
    	vr.UserRegistrationservice(mapq)
		println("After Vender Registration--------")
	}
		
		def catvar
		catvar = (industryRegMasterInstance.category).toString()
		println("catvar--------"+catvar)
		if(catvar == "HOSPITAL" || catvar == "CLINIC" || catvar == "LAB" || catvar == "BLOOD BANK" ||catvar == "VETERINARY" || catvar == "DENTAL CLINIC" )
			{
		    	println("why is not coming here")	
		    	redirect(controller:'hazardeousWasteAuthApp',action:'list')	
		    	return
			}else{
				println("why is coming here")
			
			redirect(controller:'indUser',action:'openIndustryHome')
			return
		}
		
		
	}
	else{
		println("notttttttttt indUserInstance>>>>>")
		
		indUserInstance.errors.allErrors.each {
			println it
			redirect(action:'registerUpdate')
	}
	}
	

}		


///////////????????
		
		def reOpenApp={

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
           activityRecInstance.status = "Re-Open Application Click"
           if(activityRecInstance.save()){		   
             }
           	else{
           		activityRecInstance.errors.each {
			    	println it
			  }
		  }
 
	}


def searchApplication1={
		  try{
			  
//				-----------------code for audit----03/07/17------------------------------/
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
					 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
					 response.setDateHeader("Expires", 0); // Proxies.
//		-------------------end---------------------------------------------------------/	

	    		if(session.userMaster!=null)
	    		{
	    			
	        		
	        		def userId = session.userMaster
	    			def appIdList11
	    			def appIdList
	    			
	        		  params.max = Math.min( params.max ? params.max.toInteger() : 20,  100)
	       		   def checkDate=null
	       		def xyz5
	       		def qwe
	       		def statusList= new ArrayList()
	       		if(params.max)
	       		{
	       			xyz5=(params.max).toInteger()
	       		}
	       		else
	       		{
	       			xyz5=20
	       		}
	       		if(params.offset)
	       		{
	       			qwe=(params.offset).toInteger()
	       		}
	       		else
	       		{
	       			qwe=0
	       		}
	        		def paramList= new ArrayList()
	        		paramList=params
	        			def appList= new ArrayList()
	    				def allFour= new ArrayList()
	    				def abc= new ArrayList()
	        		def abcR= new IndApplicationDetails()
	        		def pendingWith= new ArrayList()
	        		def pendingWithRole= new ArrayList()
	    				int total;
	        		
	    			if(params.searchOp==null)
	    			{
	    				flash.message = "Please Select The Radio Button "
	    				redirect(action:reOpenApp)
	    			}
	    		
	    			else
	    			{
	    				
	    				
	    					if(params.searchOp=="ApplId")
	    					{
	    						////////////////////start/////////
	    						
	    						if((params.autocomplete_parameter).length()==0)
	    						{
	    							flash.message="Please enter Application Id"
	    							redirect(action:reOpenApp)
	    							return;
	    						}
	    						else
	    						{
	    							abc=IndApplicationDetails.get((params.autocomplete_parameter).toLong())
	    							println("==========abc======"+abc)
	    							println("==========params.autocomplete_parameter======"+params.autocomplete_parameter)
	    						                if(abc){
	    						                	if(abc.certificateFor!="autoReNew"){
	    										def checkInst=ApplicationPendingDetails.findByApplication(abc)
	    										if(checkInst)
	    										{
	    										statusList.add(checkInst.applicationStatus)
	    										pendingWith.add(checkInst.pendingWith)
	    										pendingWithRole.add(checkInst.role)
	    										}
	    										else
	    										{
	    											statusList.add("Unattended")
	    											pendingWith.add("Unknown")
	    									    	pendingWithRole.add("Unknown")
	    										}
	    						                	}
	    						                	else{
	    						                		flash.message = "Auto Renew Application can not be Re-Opened"
			    											render(view:'reOpenApp') 
			    											return
	    						                		
	    						                	}
	    						                }
	    						}
	    						total=1
	        	
	    					
	    						////////////end/////////
	    						
	    					
	    					}
	        		
	    				
	        		}		   
	    				if(abc.getClass().getName()=="java.util.ArrayList")
	    				{
	    				if(abc.size()==0)
	    				{
	    			
	    					flash.message="No Result Found With This Search Combination"
	    				}
	    				}
	    				else{ 
	    					if(abc==null){
	    					flash.message="No Result Found With This Search Combination"
	    					}
	    				}
	    				
	    				render(view:'reOpenApp',model:[appIdList:appIdList,abc:abc,total:total,paramList:paramList,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole])

	    		}
	    		else
	    		    	{
	    		    		session.invalidate()
	    		    		redirect(uri:'/index.gsp')
	    		    		return
	    		    		
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


def reopenManually=
	{
		  try{
//				-----------------code for audit----03/07/17------------------------------/
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
					 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
					 response.setDateHeader("Expires", 0); // Proxies.
//		-------------------end---------------------------------------------------------/	

			  def autocomplete_parameter
			  if(params.applicationId){
				  autocomplete_parameter= params.applicationId
			  }else{
				  autocomplete_parameter=params.autocomplete_parameter
			  }
			  
			  
	    		if(session.userMaster!=null)
	    		{
	    			
	       		   def statusList= new ArrayList()
	       		   def abc= new ArrayList()
	        	   def pendingWith= new ArrayList()
	        	   def pendingWithRole= new ArrayList()
	    		   def checkInst
	    		   def completedToInprogressRecordIns
	    		   def applicationtype	
	    					if((autocomplete_parameter).length()!=0)
	    					{    	
	    						
	    						
	    						
	    						
	    						
	    										abc=IndApplicationDetails.get((autocomplete_parameter).toLong())
	    							    		if(abc){ 
	    							    		applicationtype=abc.applicationType	
	    										//checkInst=ApplicationPendingDetails.findByApplicationAndApplicationStatus(abc,"'approved' ")
	    										checkInst=ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=?  and applicationStatus!='pending' order by id desc",[abc])
	    										
	    										
	    							    		}
	    										if(checkInst)
	    										{
	    											
	    										statusList.add(checkInst.applicationStatus)
	    										pendingWith.add(checkInst.pendingWith)
	    										pendingWithRole.add(checkInst.role)
	    										
	    										def country = Math.round((Math.random()+10000)*Math.random())
	    										println("country===="+country)
	    										def otp = country.toString()
	    										println("otp===="+otp)
	    										def mobileNo = session.userMaster.userProfile.mobile
	    										def emailId = session.userMaster.userProfile.email
	    										println("mobileNo===="+mobileNo)
	    										println("emailId===="+emailId)
	    										if(mobileNo){
	    										def mobSize = mobileNo.length();
	    										println("abc===="+mobSize)
	    										if((mobSize<10) ){
	    											println("Please enter 10 digit mobile no.");
	    											flash.message = "Registered mobile no. is incorrect"
	    											render(view:'reOpenApp') 
	    											return
	    										}
	    										else if( (mobSize>10) ){
	    											println("Please enter 10 digit mobile no.");
	    											flash.message = "Registered mobile no. is incorrect"
	    											render(view:'reOpenApp') 
	    											return
	    										}
	    										else{
//	    											recordChange.mobile = mobileNo	
	    											
	    										}
	    										}
	    										else{
	    											println("mobile no is not saved");
	    											flash.message = "Registered mobile no. is incorrect"
	    											render(view:'reOpenApp') 
	    											return
	    											
	    										}
	    										
	    										//def indApplicationDetailsObj=IndApplicationDetails.get(abc)
	    										UserMaster userObj=(UserMaster)session.getAttribute("userMaster")
	    										UserProfile aab=(UserProfile)session.getAttribute("userprof");
	    										def applicationPendingDetailsObj=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=?",[abc])
	    									
	    										def webUtils = WebUtils.retrieveGrailsWebRequest()
	    										def request = webUtils.getCurrentRequest()
	    										
	    										def pendingWithIdObj=applicationPendingDetailsObj.pendingWith
	    										def pendingWithRolObje=applicationPendingDetailsObj.role
				
	    										def roleProfileAssignmentObj=RoleProfileAssignment.find("from RoleProfileAssignment rpa where rpa.primaryEmployee=?",[aab])
	    										def roleObj;
	    										if(roleProfileAssignmentObj)
	    										{
	    											roleObj=roleProfileAssignmentObj.role
	    										}
	    										def completedToInprogressRecordObj11=ReopenApplicationRecord.find("from ReopenApplicationRecord abc where abc.application.id=? and appReopenStatus=false",[(autocomplete_parameter).toLong()])
	    										println("completedToInprogressRecordObj11.....sa......"+completedToInprogressRecordObj11)
	    										
	    										if(completedToInprogressRecordObj11){
	    											completedToInprogressRecordObj11.otp=otp
	    											if(completedToInprogressRecordObj11.save() && !completedToInprogressRecordObj11.hasErrors())
		    										{ 
		    											def applicationid=(abc.id).toString();
		    											SendMail send1=new SendMail()
		    											SendSms send=new SendSms()
		    											send1.sendingOTPemail(applicationid,emailId,otp)
		    											send.sendingOTP1(applicationid,mobileNo,otp)
//		    											flash.message = "OTP sent to your registered mobile no and email."+otp
		    											flash.message = "OTP is."+otp
		    											
		    										render(view:'reopenManually',model:[abc:abc,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole,checkInst:checkInst])	
		    											
		    											println("value savedddddddd.................1111111111.......")
		    										}else{
		    											println("value not saved...2222222222222.......")
		    											completedToInprogressRecordObj11.errors.each{
		    												println it;
												
												
		    										}
		    											flash.message="Something went wrong! "
		    											redirect(action:searchApplication)
		    										}
	    										}else
	    										{
	    										
	    										def completedToInprogressRecordObj = new ReopenApplicationRecord();
	    										completedToInprogressRecordObj.application=abc
	    										completedToInprogressRecordObj.loggedInUserName=userObj
	    										completedToInprogressRecordObj.lastPendingWithId=pendingWithIdObj
	    										completedToInprogressRecordObj.lastPendingWithRole=pendingWithRolObje
	    									
	    										completedToInprogressRecordObj.ipAddress=request.getRemoteAddr()
	    										completedToInprogressRecordObj.reasonForReopen=""
	    										completedToInprogressRecordObj.otp=otp
	    										completedToInprogressRecordObj.dateOfReopen=new Date()	
	    										//completedToInprogressRecordObj.lastUpdated=new Date();

	    										if(completedToInprogressRecordObj.save() && !completedToInprogressRecordObj.hasErrors())
	    										{ 
	    											def applicationid=(abc.id).toString();
	    											SendMail send1=new SendMail()
	    											SendSms send=new SendSms()
	    											send1.sendingOTPemail(applicationid,emailId,otp)
	    											send.sendingOTP1(applicationid,mobileNo,otp)
//	    											flash.message = "OTP sent to your registered mobile no and email."+otp
	    											flash.message = "OTP is"+otp
	    											
	    										render(view:'reopenManually',model:[abc:abc,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole,checkInst:checkInst])	
	    											
	    											println("value savedddddddd.................1111111111.......")
	    										}else{
	    											println("value not saved...2222222222222.......")
	    											completedToInprogressRecordObj.errors.each{
	    												println it;
											
											
	    										}
	    											flash.message="Something went wrong! "
	    											redirect(action:reOpenApp)
	    										}
	    										}
	    										}else if(abc){
	    		
	    				    						flash.message="Application not Approved / Reject"
	    				    						redirect(action:reOpenApp)
	    				    						return;
	    										}else{
	    		
	    				    						flash.message="Application not found"
	    				    						redirect(action:reOpenApp)
	    				    						return;	    											
	    										}  										
	    								
	    							
	        	
	    					}
	    					else{ 
	    		
	    						flash.message="Please enter Application Id"
	    						redirect(action:reOpenApp)
	    						return;
	    					}
	        		
	    				render(view:'reopenManually',model:[abc:abc,statusList:statusList,pendingWith:pendingWith,pendingWithRole:pendingWithRole,checkInst:checkInst])

	    		}
	    		else
	    		    	{
	    		    		session.invalidate()
	    		    		redirect(uri:'/index.gsp')
	    		    		return
	    		    		
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


def changStatus={
		  try{
			  if(session.userMaster==null)
	    		{
	    		    		session.invalidate()
	    		    		redirect(uri:'/index.gsp')
	    		    		return
	    		    		
	    		    	}
					
		
			    println("PARAMS in changStatus----------------"+params);
				def appId=params.applicationId
				def statusList= new ArrayList()
				def pendingWith= new ArrayList()
	     	    def pendingWithRole= new ArrayList()
				UserMaster userObj=(UserMaster)session.getAttribute("userMaster")
				UserProfile aab=(UserProfile)session.getAttribute("userprof");
				def roleProfileAssignmentObj=RoleProfileAssignment.find("from RoleProfileAssignment rpa where rpa.primaryEmployee=?",[aab])
				def roleObj;
				if(roleProfileAssignmentObj)
				{
					roleObj=roleProfileAssignmentObj.role
				}
				def indApplicationDetailsObj=IndApplicationDetails.get((appId).toLong())
				def completedToInprogressRecordObj=ReopenApplicationRecord.find("from ReopenApplicationRecord abc where abc.application.id=? order by abc.id desc",[(params.applicationId).toLong()])
				if(completedToInprogressRecordObj)	{
						
					boolean status=completedToInprogressRecordObj.otp==params.otp
					if(status){

							//println("hiiiiiiiiiiiiii./.........."+completedToInprogressRecordObj)
							completedToInprogressRecordObj.reasonForReopen=params.name
							completedToInprogressRecordObj.appReopenStatus=true;
							
						}else{
							
								flash.message="Please Enter correct OTP."
		    						redirect(action:reopenManually,params:["autocomplete_parameter":applicationId])
		    						return;	
						}
					}
					def applicationPendingDetailsObj=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=?",[indApplicationDetailsObj])
					applicationPendingDetailsObj.applicationStatus="pending"
					
					statusList.add(applicationPendingDetailsObj.applicationStatus)
					pendingWith.add(applicationPendingDetailsObj.pendingWith)
					pendingWithRole.add(applicationPendingDetailsObj.role)
					
					def pendingWithIdObj=applicationPendingDetailsObj.pendingWith
					def pendingWithRolObje=applicationPendingDetailsObj.role
					
					def applicationProcessingDetailsObj=ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve=true",[indApplicationDetailsObj])
					
					if(applicationProcessingDetailsObj){
					
						applicationPendingDetailsObj.role = applicationProcessingDetailsObj.role
						applicationPendingDetailsObj.pendingWith = UserMaster.get(applicationProcessingDetailsObj.officer)
						applicationProcessingDetailsObj.delete()
					
					}
					
					def noteHistiryFile2 = new ApplicationFileRecord();	
					def f = request.getFile('documentGrievance')
					MultipartFile multi = request.getFile('documentGrievance')
					println("f----------"+multi.getSize());
					if(multi.getSize() > 0)
					{
						if(!f.empty) {
							
							noteHistiryFile2.size = multi.getSize() / 1024
							if(noteHistiryFile2.size<=6000){
							noteHistiryFile2.name =multi.getOriginalFilename()
							noteHistiryFile2.extension = extractExtension( multi )
							noteHistiryFile2.description="Re-Open document attached"
							noteHistiryFile2.data=multi.getBytes() 
							noteHistiryFile2.createdBy=userObj.id
							noteHistiryFile2.updatedBy=userObj.id
							noteHistiryFile2.typeOfFile="ReOpen";
							noteHistiryFile2.indApplication=indApplicationDetailsObj
							
							if(noteHistiryFile2.save(flush:true)) {
								completedToInprogressRecordObj.docAttached = true	
							} else {
								
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
								render(view:'reOpenApp');
								return true;
						
							}
							}
							else {
								
								flash.message = "Attachment File Size is More Then 5 Mb"
								render(view:'reOpenApp');
								return true;
						
							}
						}
					}
					
					if(completedToInprogressRecordObj.save() && !completedToInprogressRecordObj.hasErrors())
					{ 
						
						
						
						if(applicationPendingDetailsObj.save())
						{
							 def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[appId]);
				    		 if(allSummaryReportInstance)
				 			  {
				    			 
				    			 allSummaryReportInstance.applicationStatus="pending";
				    			 allSummaryReportInstance.pendingSince=new Date();
				    			 allSummaryReportInstance.pendingWith = applicationPendingDetailsObj.pendingWith.id
				    			 allSummaryReportInstance.roleId=(applicationPendingDetailsObj.role.id).toString();
				    			 allSummaryReportInstance.roleName=applicationPendingDetailsObj.role.roleName;
				    			 allSummaryReportInstance.officerName=(RoleProfileAssignment.findByRole(applicationPendingDetailsObj.role)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(applicationPendingDetailsObj.role)).primaryEmployee.employeeLastName
				    				
				    			 allSummaryReportInstance.save();
				 			  }
						}else
						{
						
						}
						 
						    flash.message="application Re-Opened successfully "
						    	redirect(action:reOpenApp)
								return;
						
					}else
					{ 
						applicationProcessingDetailsObj.discard()
						applicationPendingDetailsObj.discard()
						completedToInprogressRecordObj.errors.each{
							println it
						}
					
					    flash.message="Error occured application not re-open"
						redirect(action:reOpenApp)
						return;
						
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

//-----------------------------------Single Window---------------------------------------//

def doLoginWithDetails={
		 try {
		
		if(session.indUser){
			session.indUser=null
		}
		if(session.userMaster){
			session.userMaster=null
		}
		if(session.cafUniqueNo){
			session.cafUniqueNo=null
		}
		if(session.serviceId){
			session.serviceId=null
		}
		if(session.indregName){
			session.indregName=null
		}
		  String indDistrict=(params.indDistrict);
		  String indName=(params.indName);
		  String indAddress=(params.indAddress);
		  String cafUniqueNo=(params.cafUniqueNo);
		  String indPhoneNo=(params.indPhoneNo);
		  String industryEmail=(params.industryEmail);
		  String serviceId=(params.serviceCode)
		  String occupierName=params.occupierName
		  String occupierAddress=params.occupierAddress
		  String occupierMobile=params.occMobile
		  String occupierEmail=params.occupierEmail
		  String formId=params.formId
		  
		  String serviceApplied="";
		  
		  String applyFor="";
		  String industryType="";
		  if(serviceId.equalsIgnoreCase("36"))
		  {
			  serviceApplied="CTE" ;
			  applyFor="new"
			  industryType="industry";
			  
		  }
		  if(serviceId.equalsIgnoreCase("37"))
		  {
			  serviceApplied="CTE" ;
			  applyFor="reNew"
			  industryType="industry";
			 
		  }
		  else if (serviceId.equalsIgnoreCase("38"))
		  {
			  serviceApplied="CTE" ;
			  applyFor="expan";
			  industryType="industry";
			  
		  }
		  
		  else if (serviceId.equalsIgnoreCase("39"))
		  {
			  serviceApplied="CTO" ;
			  applyFor="new";
			  industryType="industry";
			 
		  }
		  else if (serviceId.equalsIgnoreCase("40"))
		  {
			  serviceApplied="CTO" ;
			  applyFor="reNew";
			  industryType="industry";
			 
		  }
		  else if (serviceId.equalsIgnoreCase("41"))
		  {
			  serviceApplied="CTO" ;
			  applyFor="expan";
			  industryType="industry";			  
		  }
		  else if (serviceId.equalsIgnoreCase("42"))
		  {
			  serviceApplied="HWM" ;
			  
		  }else if (serviceId.equalsIgnoreCase("43"))
		  {
			  serviceApplied="EW" ;
			  
		  }else if (serviceId.equalsIgnoreCase("44"))
		  {
			  serviceApplied="PWM" ;
			  
		  }
		  else if (serviceId.equalsIgnoreCase("45"))
		  {
			  serviceApplied="BMW" ;
			  
		  }
		  else if (serviceId.equalsIgnoreCase("46"))
		  {
			  serviceApplied="CTO" ;
			  applyFor="autoReNew";
			  industryType="industry";			  
		  }
		 
		  session.applyFor=applyFor;
		  session.serviceApplied=serviceApplied;
		  session.serviceId=serviceId;
		  def indUserInstanceObj;
		  
		  def cafUniqueNoFortestvalid=(cafUniqueNo).trim()
		  
		  
		  
		  println("........cafUniqueNoFortestvalid......"+cafUniqueNoFortestvalid)
		  println("........indName......"+indName)
		  println("........indDistrict......"+indDistrict)
		  println("........indAddress......"+indAddress)
		  println("........indPhoneNo......"+indPhoneNo)
		  println("........indPhoneNo......"+indPhoneNo)
		  println("........industryEmail......"+industryEmail)
		  println("........serviceId......"+serviceId)
		  println("........occupierName......"+occupierName)
		  println("........occupierAddress......"+occupierAddress)
		  println("........occupierMobile......"+occupierMobile)
		  println("........occupierEmail......"+occupierEmail)
		  println("........cafUniqueNoFortestvalid......"+cafUniqueNoFortestvalid)
		  println("........formId......"+formId)
		  println("........serviceApplied......"+serviceApplied)
		  println("........applyFor......"+applyFor)
		  println("........formId......"+formId)
		        
		  

		  def indUserInstance =IndustryRegMaster.find("from IndustryRegMaster iu where iu.cafUniqueNo=?",[cafUniqueNoFortestvalid]);
		  
		  println("indUserInstance=="+indUserInstance);
             if(indUserInstance){
              indUserInstanceObj=IndUser.find("from IndUser iu where iu.industryRegMaster=?",[indUserInstance]);
                }
  	                println("indUserInstance=="+indUserInstance+".indUserInstanceObj."+indUserInstanceObj)
  	                if(!indUserInstanceObj)
  	                {
  	                	flash.message="Industry not registred with this cafeUnique Number ${cafUniqueNoFortestvalid}"
							  def userTypeLogin="loginAfterRegister"
							  def occName="";
							  session.userTypeLogin=userTypeLogin
							  println("session.userTypeLogin=="+session.userTypeLogin);
							  session.indName=indName
							  session.indDistrict=indDistrict
                              session.indPhoneNo=indPhoneNo
							  session.indEmail=industryEmail
							  session.indAddress=indAddress
							   println("session.indAddress=="+session.indAddress);
							  session.cafUniqueNo=cafUniqueNoFortestvalid
							  session.occupierName=occupierName
							  session.occupierAddress=occupierAddress
							  session.occupierMobile=occupierMobile
							  session.occupierEmail=occupierEmail
							  redirect(action:'create2')
							  return
  	                  }
  	              if(indUserInstance)
				   {  
  	            	  flash.message="You have already registered with OCMMS"
             	     session.cafUniqueNo=cafUniqueNo
             	     session.indregName=indUserInstance;
             	     session.indUser=indUserInstanceObj;
             	     indUserInstance.cafUniqueNo=cafUniqueNo;
             	    indUserInstance.save()
             	    if(serviceId=="36" || serviceId=="37" || serviceId=="38" || serviceId=="39" || serviceId=="40" || serviceId=="41" || serviceId=="46"){
					 redirect(controller:'indApplicationDetails',action:'saveConsentSingle',params:[radiobutton1:serviceApplied,appFor:applyFor,cafUniqueNo:cafUniqueNo,serviceId:serviceId])
						 
					 return 
             	    }else if(serviceId=="42"){
             	    	def hwmWaste=HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp hwm where hwm.cafUniqueNo=? and hwm.serviceId=? and hwm.industryRegMasterObj=?",[cafUniqueNo,serviceId,indUserInstance])
             	    	if(hwmWaste){
             	    		 redirect(controller:'hazardeousWasteAuthApp',action:'list');
							 return;
             	    	}else{
             	    		redirect(controller:'hazardeousWasteAuthApp',action:'createNewFormatSingle');
							 return; 
             	    	}
             	    }else if(serviceId=="43"){
             	    	def eWaste=EWaste.find("from EWaste hwm where hwm.cafUniqueNo=? and hwm.serviceId=? and hwm.industryReg=?",[cafUniqueNo,serviceId,indUserInstance])
             	    	if(eWaste){
             	    		redirect(controller:'eWaste',action:'list');
							 return;
             	    	}else{
             	    		redirect(controller:'eWaste',action:'eWasteCheckBox');
             	    		return;
             	    	}
             	    }else if(serviceId=="44"){
             	    	def pwmWaste=PlasticWaste.find("from PlasticWaste hwm where hwm.cafUniqueNo=? and hwm.serviceId=? and hwm.industryRegMasterObj=?",[cafUniqueNo,serviceId,indUserInstance])
             	    	if(pwmWaste){
             	    		redirect(controller:'plasticWaste',action:'list');
							 return;
             	    	}else{
             	    		redirect(controller:'plasticWaste',action:'plasticWasteCheckBox');
             	    		return;
             	    	}
             	    }else if(serviceId=="45"){
             	 //   	println("4444444444444444444444")
             	    	def bmwaste=BioMedicalWaste.findAll("from BioMedicalWaste hwm where hwm.cafUniqueNo=? and hwm.serviceId=? and hwm.industryRegMasterObj=?",[cafUniqueNo,serviceId,indUserInstance])
             	    		println("bmwaste============"+bmwaste)
             	    	if(bmwaste){
             	    		//  New Code added by deepak   
    		        		for (int i =0; i< bmwaste.size(); i ++)
    						{
    		        			/********Pending Application*******************/
    							def indAppInstancePending =BioMedicalWaste.find("from BioMedicalWaste as iad where iad.completionStatus='Inprogress' and iad.cafUniqueNo=? and iad.serviceId=? and iad.industryRegMasterObj=?",[cafUniqueNo,serviceId,indUserInstance]);
    							if (indAppInstancePending)
    							{								
    								 println("Pending Application*** ")                                                                                                             
    									redirect(controller:'hazardeousWasteAuthApp',action:'list');
    									return
    								
    							}
    							
    							/********Pending Application*******************/
    							def indAppInstanceCompleted =WasteManagementPendingDetails.find("from WasteManagementPendingDetails as iad where iad.applicationStatus='pending' and iad.applicationId = ? ",[bmwaste[i].id.toString()]);
    							if (indAppInstanceCompleted)
    							{								
    								    println("Pending Application*** ")                                                                                                             
    									redirect(controller:'hazardeousWasteAuthApp',action:'list');
    									return
    								
    							}else{
    								redirect(controller:'bioMedicalWaste',action:'createNewFormatSingle');
    								return; 
    							}
    						}
				  }else{
						redirect(controller:'bioMedicalWaste',action:'createNewFormatSingle');
						return; 
					}
             	       }
				   }
  	            else
				  {
  	            	 flash.message="Industry not registred with this name, email address , telephone no."
						  def userTypeLogin="loginAfterRegister"
						  def occName=firstName
						  session.userTypeLogin=userTypeLogin
						  session.indName=indName
						  session.indDistrict=indDistrict
						  session.indPhoneNo=indPhoneNo
						  session.indEmail=industryEmail
						  session.indAddress=indAddress
						  session.cafUniqueNo=cafUniqueNo
						  session.occupierName=occupierName
						  session.occupierAddress=occupierAddress
						  session.occupierMobile=occupierMobile
						  session.occupierEmail=occupierEmail
							  
							  redirect(action:'create2')
							  return
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

def create2={

		def industryRegMasterInstance = new IndustryRegMaster()
		industryRegMasterInstance.properties = params
		def district = (session.indDistrict).toString()
		println("session.cafUniqueNo---11111111111111--------"+session.cafUniqueNo)
		 industryRegMasterInstance.indName=session.indName
		// def districtMasterInstance=DistrictMaster.findByDistrictName(district);
		
		 def districtMasterInstance=DistrictMaster.find("from DistrictMaster where districtName=?",[district])
		 println("districtMasterInstance---11111111111111--------"+districtMasterInstance)
		 if(districtMasterInstance)
		  {
				industryRegMasterInstance.district=districtMasterInstance	
		  }
		  industryRegMasterInstance.indAddress=session.indAddress
		  industryRegMasterInstance.occMobile=session.occMobile
		  industryRegMasterInstance.occEmail=session.occEmail
		  industryRegMasterInstance.indEmail=session.indEmail
		  industryRegMasterInstance.cafUniqueNo=session.cafUniqueNo
		  industryRegMasterInstance.occName=session.occupierName 
		  industryRegMasterInstance.occAddress=session.occupierAddress 
		  
	
		println("---occMobile-------"+session.occupierMobile)
		 industryRegMasterInstance.occMobile=session.occupierMobile 
		 industryRegMasterInstance.occEmail=session.occupierEmail 
		  def tehsilList = TehsilMaster.findAll("from TehsilMaster tm where tm.district=? order by tm.tehsilName asc",[districtMasterInstance])
           println("///.............tehsilList......"+tehsilList)
	      def industryRegMaster1 = SurroundingMaster.list();
		 
		  def districtList = DistrictMaster.list( sort:"districtName", order:"asc");
	      return ['industryRegMasterInstance':industryRegMasterInstance,'industryRegMaster1':industryRegMaster1,'districtList':districtList,'tehsilList':tehsilList]
	
		
}
def save2={

		 try {
			 println("params.."+params)
				IndFileRecord file=new IndFileRecord()
				File certFile
				def expDate = params.expDate_value
				IndProfilePdf pdfG=new IndProfilePdf()
				def industryRegMasterInstance = new IndustryRegMaster(params)
			 
			 Random random = new Random(new Date().getTime());
				int randomInt = random.nextInt(1000000);
				println("randomInt----"+randomInt)
				industryRegMasterInstance.id = randomInt
				
				def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
				def x = sdfh.parse(expDate);
				industryRegMasterInstance.cafUniqueNo =session.cafUniqueNo
				industryRegMasterInstance.expDate = x
				industryRegMasterInstance.expDate =expDate
				industryRegMasterInstance.occAddress = params.occAddress
				industryRegMasterInstance.statusOfAppl = params.statusOfAppl
				industryRegMasterInstance.statusOfAppl = params.statusOfAppl
				industryRegMasterInstance.nameAddressPartners = params.nameAddressPartners
				industryRegMasterInstance.noOfEmp = params.noOfEmp
				industryRegMasterInstance.indTypeOther = ""
				def checkCategory = params.category.id
				
				def indUserInstance= new IndUser()
				def districtMasterInstance = DistrictMaster.findByDistrictName(params.district)
				def indName = params.indName
				String output = indName.replaceAll("\\s+",""); 
				String iname = ((String)output.substring(0,3)).toUpperCase()
				def categoryId = params.category.id
				def districtId = districtMasterInstance.id
				
				if(categoryId.equals('100')) {
					flash.message= "please select category"
					render(view:'create2',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}
				if(districtId.equals('100')) {
					flash.message= "please select industry distict"
					render(view:'create2',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}
				if((!session.userMaster) || (!session.indUser)){
					industryRegMasterInstance.updatedBy=params.indName
				}
				else{
					if(session.userMaster){
						industryRegMasterInstance.updatedBy = session.userMaster
					}else{
						industryRegMasterInstance.updatedBy = session.indUser
					}
				}
				if(session.userMaster){
					industryRegMasterInstance.createdBy = session.userMaster
				}
				else{
					industryRegMasterInstance.createdBy = params.indName
				}
				industryRegMasterInstance.district=districtMasterInstance
				industryRegMasterInstance.indName=params.indName
				industryRegMasterInstance.dateCreated = new Date()
				industryRegMasterInstance.lastUpdated = new Date()
				industryRegMasterInstance.plotNo = params.plotNo
				industryRegMasterInstance.siteArea = params.siteArea
				def indTypeInstance = IndTypeMaster.findWhere(name:"medium") 
				Double capInt=Double.parseDouble(params.indCapInvt)
				def min =indTypeInstance.min
				def max =indTypeInstance.max
				if(capInt == "" ) {
					flash.message= "please enter capital investment"
					render(view:'create2',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
				}else{
					if ((capInt.toLong()) >= max ) {
						def large = IndTypeMaster.findWhere(name:"large")
						industryRegMasterInstance.indType = large
					}else{
						if((capInt.toLong()) <= min){
							def small = IndTypeMaster.findWhere(name:"small") 
							industryRegMasterInstance.indType = small
						}
						else {
							def medium = IndTypeMaster.findWhere(name:"medium") 
							industryRegMasterInstance.indType = medium
						}
					}
				}
				if(industryRegMasterInstance.save()&& !industryRegMasterInstance.hasErrors()) { 
					if(params.indRegNum){
						industryRegMasterInstance.indRegNum = params.indRegNum
					}else{
						industryRegMasterInstance.indRegNum = ""
					}
					def pass =params.password
					indUserInstance.password=pass
					indUserInstance.hintQuestion=params.hintQuestion
					indUserInstance.hintAnswer=params.hintAnswer
					if(session.userMaster){
						indUserInstance.createdBy = session.userMaster
					}
					else{
						indUserInstance.createdBy = params.indName
					}
					indUserInstance.dateCreated= new Date()
					indUserInstance.industryRegMaster = industryRegMasterInstance
					if(!districtMasterInstance){
						flash.message ="please enter industry district"
						render(view:'create2',model:[industryRegMasterInstance:industryRegMasterInstance,indUserInstance:indUserInstance])
					}
					else{
						indUserInstance.id=iname+industryRegMasterInstance.id
					}
					indUserInstance.flag = 0
					indUserInstance.save()
					def surrList = SurroundingMaster.list()
					def dList2
					def dist1 = params.distance
					def description = params.description
					def j=0
					for(int i=0;i<surrList.size();i++){
						def indSurroundingInstance = new IndSurrounding()
						def surr = surrList.get(i)
						def surrId = surr.surroundingName
						if(params[surrList.get(i).surroundingName]=="on"){
							def abc = (surrList.get(i)).id
							indSurroundingInstance.surrounding = surrList.get(i)
							indSurroundingInstance.industryReg=industryRegMasterInstance
							indSurroundingInstance.distance = dist1[j]
							indSurroundingInstance.description = description[j]
							indSurroundingInstance.save()
						}
						j=j + 1
					}
					def mailPermit = params.radiobutton
					if(mailPermit.equals('yes')) {    
						if ((params.occEmail)) {
							def recp = params.occEmail
							String recept = recp
							def userName = indUserInstance.id
							def industryName = params.indName
							def pass1= IndUser.findWhere(id:params.id)
							def password = params.passwordEncrypt
							SendMail mail = new SendMail()
							//mail.sendMail(recept,userName,password, industryName)
							flash.message = "Mail has been Sent "
						} 
						else {
							flash.message="please enter email-Id" 
						}
					}
					else {}
					if(indUserInstance.hasErrors()){
						indUserInstance.errors.allErrors.each {
						}
					}
					def date=new Date()
					DateCustom dd=new DateCustom()
					def sqlD=dd.sQLdate(date)
					def day=(date.getDate()).toString() 
					def month=(date.getMonth()+1).toString()
					def year=(date.getYear()+1900).toString() 
					def dateStr=day+"/"+month+"/"+year
					def login=(indUserInstance.id).toString()
					def passwordStr=params.passwordEncrypt
					def iregId=industryRegMasterInstance.indRegNum
					def iName=industryRegMasterInstance.indName
					def iType=industryRegMasterInstance.industryType.industryType
					def iOtherType=industryRegMasterInstance.indTypeOther
					def iCategory=industryRegMasterInstance.category.name
					def iYear=industryRegMasterInstance.dateOfComm
					def iStatus=(industryRegMasterInstance.indStatus).toString()
					def iCapInvest=(industryRegMasterInstance.indCapInvt).toString()
					def iAddress=industryRegMasterInstance.indAddress
					def iCity=industryRegMasterInstance.indCity
					def iDistrict=industryRegMasterInstance.district.districtName
					def iTehsil=industryRegMasterInstance.tehsil.tehsilName
					def iPin=industryRegMasterInstance.indPin
					def iAreaC=industryRegMasterInstance.indPhoneCode
					def iPhone=industryRegMasterInstance.indPhoneNo
					def iFax=industryRegMasterInstance.indFaxNo
					def iFaxCode=industryRegMasterInstance.indFaxCode
					def iEmail=industryRegMasterInstance.indEmail
					def oName=industryRegMasterInstance.occName
					def oDesignation=industryRegMasterInstance.occDesignation
					def oAddress=industryRegMasterInstance.occAddress
					def oCity=industryRegMasterInstance.occCity
					def oDistrict=params.occDistrict
					def oTehsil=params.occTehsil
					def oPin=industryRegMasterInstance.occPin
					def oAreaC=industryRegMasterInstance.occPhoneCode
					def oPhoneNum=industryRegMasterInstance.occPhoneNo
					def oFaxNo=industryRegMasterInstance.occFaxNo
					def occFaxCode = industryRegMasterInstance.occFaxCode
					def oMobNo=industryRegMasterInstance.occMobile
					def oEmail=industryRegMasterInstance.occEmail
					def oHintQ=indUserInstance.hintQuestion
					def oAns=indUserInstance.hintAnswer
					def comMonth = industryRegMasterInstance.commMonth
					if( !indUserInstance.hasErrors() && indUserInstance.save()&& !industryRegMasterInstance.hasErrors()) {
						//flash.message = "Industry Registration completed sucessfuly as User ID: ${indUserInstance.id} and Temporary Password: ${params.passwordEncrypt}. Please change your password."
						certFile = pdfG.indProfileFunction(dateStr,login,passwordStr,iregId,iName,iType,iCategory,iYear,iStatus,iCapInvest,iAddress,iCity,iDistrict,iTehsil,iPin,iAreaC,iPhone,iFax,iEmail,oName,oDesignation,oAddress,oCity,oDistrict,oTehsil,oPin,oAreaC,oPhoneNum,oFaxNo,oMobNo,oEmail,oHintQ,oAns,iOtherType,comMonth,iFaxCode,occFaxCode)
						byte[] b = new byte[(int) certFile.length()];
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						def fileLength=certFile.length()
						file.size = fileLength / 1024  //f.getSize() 
						file.extension ="pdf"//extractExtension( f )
						file.data=b;
						file.name=iregId+".pdf"
						file.description="Industry Profile Saved"
						if(session.userMaster){
							file.createdBy=session.userMaster
							file.updatedBy=session.userMaster
						}else {
							file.createdBy=iName
							file.updatedBy=iName
						}
						file.typeOfFile="IndustryProfile"
						file.indUser=industryRegMasterInstance
						if(!file.hasErrors() && file.save()) {
						} else {
							flash.userMessage = "File [${file.name}] has NOT not been uploaded."
							render(view:'create2',model:[file:file,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
						}
						def industryId = indUserInstance.id
						def tempPass = params.passwordEncrypt
						SendSms sms = new SendSms()
						//sms.send(iName,industryId,tempPass,oMobNo)
						
					 def myAuditInstance=new MyAudit()
				    myAuditInstance.userID=(indUserInstance.id).toString()
				    myAuditInstance.userType="Industry"
				    myAuditInstance.ipAddress=request.getRemoteAddr() 
				    myAuditInstance.loginDate=new Date()
				    myAuditInstance.loginStatus='Successfull'
				    myAuditInstance.reason="Login throw SingleWindow new Registration"
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
			       session.indUser=indUserInstance
			       session.indregName=indUserInstance.industryRegMaster
			       println session.tunt
		    	   session.brow=request.getHeader("User-Agent");
	               println session.brow
	               session.login="xyz"
				   session.auditIDSPCB=myAuditInstance.id
						  def serviceId =session.serviceId;
		                 def serviceApplied=session.serviceApplied;
		               
		                 def applyFor=session.applyFor;
		                def cafUniqueNo=session.cafUniqueNo
		               println ("===============================");
		               println ("service Id ====" +serviceId);
		               println ("service Applied ====" +serviceApplied);
		          
		               println ("apply For ====" +applyFor);
		               println ("===============================");
		               if(serviceApplied=="CTE" || serviceApplied=="CTO"){
		               redirect(controller:'indApplicationDetails',action:'saveConsentSingle',params:[radiobutton1:serviceApplied,appFor:applyFor,cafUniqueNo:cafUniqueNo,serviceId:serviceId])
						return  
		               }else if(serviceApplied=="HWM"){
		            	   redirect(controller:'hazardeousWasteAuthApp',action:'createNewFormatSingle');
							 return; 
		               }else if(serviceApplied=="BMW"){
		            	   redirect(controller:'bioMedicalWaste',action:'createNewFormatSingle');
							return;
		               }else if(serviceApplied=="PWM"){
		            	   redirect(controller:'plasticWaste',action:'plasticWasteCheckBox');
	        	    		return;
		               }else if(serviceApplied=="EW"){
		            	   redirect(controller:'eWaste',action:'eWasteCheckBox');
	        	    		return;
		               }
						//redirect(action:show,id:industryRegMasterInstance.id)
					}
					else {
						render(view:'create2',model:[indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
					}
				}
				else{
					industryRegMasterInstance.errors.each {
						println it
					}
					def industryRegMaster1 = SurroundingMaster.list()
					def districtList = DistrictMaster.list( sort:"districtName", order:"asc")
					render(view:'create2',model:[districtList:districtList,industryRegMaster1:industryRegMaster1,indUserInstance:indUserInstance,industryRegMasterInstance:industryRegMasterInstance])
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

/////////////////////////////////White Categoty Code By Deepak //////////////////////////////////////////////////////////////////

def createWhiteCategory = {
	println("params : IN White Categoty--" + params)
	println("session : IN White Categoty--" + session)
	def userId;
	if (session.indUser) {
		userId = ((session.indUser).toString()).trim();
	} else {
		session.invalidate();
		redirect(uri: '/index.gsp');
	}
	def indUser = IndUser.get(userId)
	def industryRegMasterInstance = indUser.industryRegMaster
	
	def whiteCategoryInstance = WhiteCategoryIntegration.find("from WhiteCategoryIntegration where indUser=?", [industryRegMasterInstance])
	println("whiteCategoryInstance---"+whiteCategoryInstance)
	println("industryRegMasterInstance---"+industryRegMasterInstance)

	if (whiteCategoryInstance) {
		if (whiteCategoryInstance.completionStatus == false) {
			render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCategoryInstance, industryRegMasterInstance:industryRegMasterInstance])
		} else {
			render(view: 'viewWhiteCategory', model: [whiteCateInt: whiteCategoryInstance, industryRegMasterInstance:industryRegMasterInstance])
		}

	} else {
		def whiteCateInt = new WhiteCategoryIntegration()
		whiteCateInt.indUser = indUser.industryRegMaster
		whiteCateInt.createdBy = userId
		whiteCateInt.updatedBy = userId
		whiteCateInt.noOfWorkers = 0
		whiteCateInt.undertaking = ""
		whiteCateInt.completionStatus = false;
		whiteCateInt.dateOfCreated = new Date()
		whiteCateInt.dateOfLastUpdated = new Date()

		if (whiteCateInt.save()) {
			render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCateInt, userId: userId, industryRegMasterInstance:industryRegMasterInstance])

		}
	}


}

def doSaveWhiteCategory = {
		println("params : doSaveWhiteCategory----" + params)
		def userId
		if (session.indUser) {
			userId = ((session.indUser).toString()).trim();
		} else {
			session.invalidate();
			redirect(uri: '/index.gsp');
		}
		
		try{
		def indUser = IndUser.get(userId)
		def industryRegMasterInstance = indUser.industryRegMaster
		def whiteCateInt = WhiteCategoryIntegration.get(params.id)
		whiteCateInt.indUser = indUser.industryRegMaster
		whiteCateInt.createdBy = userId
		whiteCateInt.updatedBy = userId
		whiteCateInt.pollutionMeasures = params.pollutionMeasures
		whiteCateInt.aadharNo = params.aadharNo
		whiteCateInt.serialNo = ""//params.serialNo
		if(params.product==null || params.product==""){
			whiteCateInt.product = ""
		}else{
			whiteCateInt.product = params.product
		}
		if(params.quantity==null || params.quantity==""){
			whiteCateInt.quantity = ""
		}else{
			whiteCateInt.quantity = params.quantity
		}
		if(params.noOfWorkers==null || params.noOfWorkers==""){
			whiteCateInt.noOfWorkers = ""
		}else{
			whiteCateInt.noOfWorkers = params.noOfWorkers
		}
		
		whiteCateInt.electricityLoad = params.electricityLoad
		//whiteCateInt.serialNo = params.serialNo
		
		
		def underta = params.undertaking
		def arrunderta = new ArrayList();
		boolean tem1 = true;
		boolean tem2 = true;
		boolean tem3 = true;
		boolean tem4 = true;
		boolean tem5 = true;
		boolean tem6 = true;
		boolean tem7 = true;
		if (underta) {

			for (int i = 0; i < underta.size(); i++) {
				if (underta[i] == "undertaking1") {
					tem1 = false
					arrunderta.add("1. That there is / will be no trade effluent generation and discharge from the aforementioned Industry / Unit / Establishment and not required to install ETP / Waste Water Treatment system;")
				}
				if (underta[i] == "undertaking2") {
					tem2 = false
					arrunderta.add("2. That the Industry/ Unit/ Establishment does not/ will not possess any boiler, furnace  and does not/ will not carry any activity leading to the change of the White categorization of aforementioned Industry/ Unit/ Establishment;")
				}
				if (underta[i] == "undertaking3") {
					tem3 = false
					arrunderta.add("3. (i) That proposed / installed DG Set is / will be having integral acoustic enclosure/ acoustic treated room to meet the prescribed norms under the Environment (Protection) Rules 1986, as amended to date for Diesel Generation and have /shall provide adequate stack height for the DG Set as per the prescribed norms (ii) That used oil generated from DG set(s)/ units shall be disposed only through the recycler of used oil authorized by State Pollution Control Board/ Central Pollution Control Board. (For DG Sets only);")
				}
				if (underta[i] == "undertaking4") {
					tem4 = false
					arrunderta.add("4. That provisions of Water Act, 1974, Air Act, 1981, Environment (Protection) Act 1986 and Rules made there under, as amended to date, shall be complied;")
				}
				if (underta[i] == "undertaking5") {
					tem5 = false
					arrunderta.add("5.	That in case of any change in the process(es) or activity(ies) leading to change of the categorization of the activities from White Category to some other Category, Application for Consent to Establish &amp; Consent to Operate under the Air and Water Act and other applicable Rules under the Environment (Protection) Act 1986, as amended to date, shall be sought from JKPCC and the activity(ies) shall not be carried out without taking prior Consent from JKPCC. <br> Failure to seek the consent in case of activity does not fall under white category, shall attract action under environmental laws;")
				}
				if (underta[i] == "undertaking6") {
					tem6 = false
					arrunderta.add("6.	  I, hereby verify and declare that what has been stated above is true and correct to the best of my knowledge and nothing has been concealed therefrom. I hold myself liable for perjury, falsehood, misrepresentation and / or omission and / or falsification or act of dishonesty from any fraudulent, fake or tampered documents that have been submitted;")
				}
				if (underta[i] == "undertaking7") {
					tem7 = false
					arrunderta.add("7.	  That I hereby agree to abide by all the conditions mentioned in the self declaration / certification / undertaking;")
				}
			}
		}
		whiteCateInt.undertaking = arrunderta


		whiteCateInt.dateOfLastUpdated = new Date();

		if (params.completionStatus == "Completed") {
			if (tem1 || tem2 || tem3 || tem4 || tem5 || tem6 || tem6 || tem7) {
				flash.message = "All Asterisk (*) Marks Are Required!!!"
				render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCateInt, industryRegMasterInstance:industryRegMasterInstance])
				return false;
			}
			whiteCateInt.completionStatus = true

			/*def arrRawMaterialsUsedTemp = new ArrayList();
			def arrOfProductTemp = new ArrayList();
			def arrOfSourceofwaterTemp = new ArrayList();
			def arrOfWaterConsumptionDetailsTemp = new ArrayList();
			def arrOfDomesticwasteWaterTemp = new ArrayList();
			def arrOfDGSetDetailsTemp = new ArrayList();

			def whiteCatRawMaterialDetails = WhiteCatRawMaterialDetails.findAll("from WhiteCatRawMaterialDetails where whiteCatIntegn=?", [whiteCateInt])
			for (int i = 0; i < whiteCatRawMaterialDetails.size(); i++) {
				arrRawMaterialsUsedTemp.add(whiteCatRawMaterialDetails.rawMaterialName[i])
				arrRawMaterialsUsedTemp.add(whiteCatRawMaterialDetails.quantity[i])
				arrRawMaterialsUsedTemp.add((whiteCatRawMaterialDetails.unit[i]).toString())
			}
			def arrRawMaterialsUsed = arrRawMaterialsUsedTemp as String[]
			//----------------------------------------------------------------
			def whiteProductDetails = WhiteProductDetails.findAll("from WhiteProductDetails where whiteCatIntegn=?", [whiteCateInt])
			for (int i = 0; i < whiteProductDetails.size(); i++) {
				arrOfProductTemp.add(whiteProductDetails.productName[i])
				arrOfProductTemp.add(whiteProductDetails.capacity[i])
				arrOfProductTemp.add((whiteProductDetails.unit[i]).toString())
			}
			def arrOfProduct = arrOfProductTemp as String[]
			//--------------------------------------------------

			def whiteSourceOfWater = WhiteSourceOfWater.findAll("from WhiteSourceOfWater where whiteCatIntegn=?", [whiteCateInt])
			for (int i = 0; i < whiteSourceOfWater.size(); i++) {
				arrOfSourceofwaterTemp.add(whiteSourceOfWater.sourceType[i])
				arrOfSourceofwaterTemp.add(whiteSourceOfWater.noOfSource[i])
				arrOfSourceofwaterTemp.add(whiteSourceOfWater.quantity[i])
			}
			def arrOfSourceofwater = arrOfSourceofwaterTemp as String[]
			//--------------------------------------------------


			def whiteWaterConsumptionDetails = WhiteWaterConsumptionDetails.findAll("from WhiteWaterConsumptionDetails where whiteCatIntegn=?", [whiteCateInt])
			for (int i = 0; i < whiteWaterConsumptionDetails.size(); i++) {
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.industrialPurpose[i])
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.coolingPurpose[i])
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.domesticPurpose[i])
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.total[i])
			}
			def arrOfWaterConsumptionDetails = arrOfWaterConsumptionDetailsTemp as String[]
			println("arrOfWaterConsumptionDetails : " + arrOfWaterConsumptionDetails)
			//--------------------------------------------------


			def whiteDomesticWasteWater = WhiteDomesticWasteWater.findAll("from WhiteDomesticWasteWater where whiteCatIntegn=?", [whiteCateInt])
			for (int i = 0; i < whiteWaterConsumptionDetails.size(); i++) {
				arrOfDomesticwasteWaterTemp.add(whiteDomesticWasteWater.quantityGenerated[i])
				arrOfDomesticwasteWaterTemp.add(whiteDomesticWasteWater.quantityDisposedInToSewer[i])
				arrOfDomesticwasteWaterTemp.add(whiteDomesticWasteWater.duantityDisposedOnToLand[i])
			}
			def arrOfDomesticwasteWater = arrOfDomesticwasteWaterTemp as String[]
			//--------------------------------------------------
			def whiteDGSetDetails = WhiteDGSetDetails.findAll("from WhiteDGSetDetails where whiteCatIntegn=?", [whiteCateInt])
			for (int i = 0; i < whiteDGSetDetails.size(); i++) {
				arrOfDGSetDetailsTemp.add(whiteDGSetDetails.kva[i])
				arrOfDGSetDetailsTemp.add(whiteDGSetDetails.stackAtAbove[i])
				arrOfDGSetDetailsTemp.add(whiteDGSetDetails.cnopy_y_n[i])
			}
			def arrOfDGSetDetails = arrOfDGSetDetailsTemp as String[]
			//--------------------------------------------------

			def arrOfUndertaking = arrunderta as String[]

			def sdfh = new SimpleDateFormat("dd/MM/yyyy");
			def sdyear = new SimpleDateFormat("yyyy");
			String appDate = sdfh.format(whiteCateInt.dateOfCreated);
			String appyear = sdyear.format(whiteCateInt.dateOfCreated);

			String indUserId = indUser;
			String intimationAppId = (whiteCateInt.id).toString();
			String dateOfApply = appDate;
			String industryName = whiteCateInt.indUser.indName;
			String indAddress = whiteCateInt.indUser.indAddress;
			String indCity = whiteCateInt.indUser.indCity
			String indDistrict = whiteCateInt.indUser.district
			String industryPin = whiteCateInt.indUser.indPin
			String nameAddressPartners = whiteCateInt.indUser.occName
			String mobile = whiteCateInt.indUser.occMobile
			String email = whiteCateInt.indUser.indEmail
			String totalInvestment = whiteCateInt.indUser.indCapInvt
			String investmentPlant = whiteCateInt.indUser.indNewCapInvt
			String noOfWorkers = whiteCateInt.noOfWorkers
			String occName = whiteCateInt.indUser.occName
			String indCategory = whiteCateInt.indUser.category
			String indType = whiteCateInt.indUser.industryType
			String occAddress = whiteCateInt.indUser.occAddress
			String autoNumber = "(W/RO/" + appyear + "/" + intimationAppId + ")";*/

			/*FormWhiteCategoryIntegration out = new FormWhiteCategoryIntegration();
			try {
				File formOfWhiteCate
				File formOfAcknowledgement

				formOfWhiteCate = out.pdfFunction(indUserId, intimationAppId, dateOfApply, industryName, indAddress, indCity, indDistrict,
						industryPin, nameAddressPartners, mobile, email, totalInvestment, investmentPlant, noOfWorkers, occName, indCategory, indType, occAddress,
						arrRawMaterialsUsed, arrOfProduct, arrOfSourceofwater, arrOfWaterConsumptionDetails, arrOfDomesticwasteWater, arrOfDGSetDetails, arrOfUndertaking
				);

				formOfAcknowledgement = out.pdfAcknowledgement(indUserId, intimationAppId, dateOfApply, industryName, indAddress, indCity, indDistrict,
						industryPin, nameAddressPartners, mobile, email,
						occName, indCategory, autoNumber);*/

//=========================DECLARATION FOR REGISTRATION===========================================================================
			/*	byte[] b = new byte[(int) formOfWhiteCate.length()];

				FileInputStream fileInputStream = new FileInputStream(formOfWhiteCate);
				fileInputStream.read(b);*/
				
				
				
       	 /////////////first pdf//////////////             Added by Deepak Kumar
     

				WhiteCategoryIntergrationFile file1 = new WhiteCategoryIntergrationFile()
				
						def photoLatAndLong=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile abc where abc.applicationId=? and abc.typeOfFile='Photograph showing Latitude and Longitude'",[whiteCateInt])
    	 	 	       	if(photoLatAndLong){
    	 	 	       	
    	 	 	       	photoLatAndLong.delete();
    	 	 	       	}
				
				def multi2 = request.getFile('photoLatAndLong')
			//	println("multi2---"+multi2)
				
				//def fileLength = formOfWhiteCate.length()
				file1.applicationId = whiteCateInt
				file1.size = multi2.getSize()            //fileLength / 1024
				file1.extension = "pdf"//extractExtension( f )
				file1.data = multi2.getBytes()
				file1.name = "photoLatAndLong.pdf"
				file1.description = "Photograph showing Latitude and Longitude of the premises"
				file1.createdBy = session.indUser
				file1.updatedBy = session.indUser
				file1.typeOfFile = "Photograph showing Latitude and Longitude"
				file1.lastUpdated = new Date()
				file1.dateCreated = new Date()
				
				Byte[] bytes=multi2.getBytes()             	
	          	  if(!fileCheck(bytes))
	    			  { 
	          		  println("Hello deepak")
	    				  flash.message="You are trying to upload restricted file"
	    					  render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCateInt, industryRegMasterInstance:industryRegMasterInstance])
	    				  return					  
	    			  } 
				if (file1.save()) {
					println("Data has been Save Photograph showing Latitude and Longitude.")
				} else {
				}
				
				
				WhiteCategoryIntergrationFile file2 = new WhiteCategoryIntergrationFile()
				
				def dicRegistration=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile abc where abc.applicationId=? and abc.typeOfFile='DIC Registration'",[whiteCateInt])
 	 	       	if(dicRegistration){
 	 	       	
 	 	       	dicRegistration.delete();
 	 	       	}
		
		      def multi3 = request.getFile('dicRegistration')
		   //   println("multi3---"+multi3)
		
		      //def fileLength = formOfWhiteCate.length()
		      file2.applicationId = whiteCateInt
		      file2.size = multi3.getSize()            //fileLength / 1024
		      file2.extension = "pdf"//extractExtension( f )
		      file2.data = multi3.getBytes()
		      file2.name = "dicRegistration.pdf"
		    file2.description = "DIC Registration"
		   file2.createdBy = session.indUser
		   file2.updatedBy = session.indUser
		    file2.typeOfFile = "DIC Registration"
		    file2.lastUpdated = new Date()
		      file2.dateCreated = new Date()
		      
		      Byte[] bytes1=multi3.getBytes()             	
          	  if(!fileCheck(bytes1))
    			  { 
          		  println("Hello deepak")
    				  flash.message="You are trying to upload restricted file"
    					  render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCateInt, industryRegMasterInstance:industryRegMasterInstance])
    				  return					  
    			  }
		      
		      if (file2.save()) {
		    	  println("Data has been Save DIC Registration.")
		      } else {
		      }
		      
		      
				WhiteCategoryIntergrationFile file3 = new WhiteCategoryIntergrationFile()
				
				def panCard=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile abc where abc.applicationId=? and abc.typeOfFile='Pan Card'",[whiteCateInt])
 	 	       	if(panCard){
 	 	       	
 	 	       	panCard.delete();
 	 	       	}
		
		      def multi4 = request.getFile('panCard')
		   //   println("multi3---"+multi3)
		
		      //def fileLength = formOfWhiteCate.length()
		      file3.applicationId = whiteCateInt
		      file3.size = multi4.getSize()            //fileLength / 1024
		      file3.extension = "pdf"//extractExtension( f )
		      file3.data = multi4.getBytes()
		      file3.name = "panCard.pdf"
		    file3.description = "Pan Card"
		    file3.createdBy = session.indUser
		    file3.updatedBy = session.indUser
		    file3.typeOfFile = "Pan Card"
		    file3.lastUpdated = new Date()
		      
		      file3.dateCreated = new Date()
		      Byte[] bytes2=multi4.getBytes()             	
          	  if(!fileCheck(bytes2))
    			  { 
          		  println("Hello deepak")
    				  flash.message="You are trying to upload restricted file"
    					  render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCateInt, industryRegMasterInstance:industryRegMasterInstance])
    				  return					  
    			  }
		      if (file3.save()) {
		    	  println("Data has been Save Pan Card")
		      } else {
		      }
		      
		  	WhiteCategoryIntergrationFile file4 = new WhiteCategoryIntergrationFile()
			
			def detProjectReport=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile abc where abc.applicationId=? and abc.typeOfFile='Details Project Report'",[whiteCateInt])
	 	       	if(detProjectReport){
	 	       	
	 	       	detProjectReport.delete();
	 	       	}
	
	      def multi5 = request.getFile('detProjectReport')
	   //   println("multi3---"+multi3)
	
	      //def fileLength = formOfWhiteCate.length()
	      file4.applicationId = whiteCateInt
	      file4.size = multi5.getSize()            //fileLength / 1024
	      file4.extension = "pdf"//extractExtension( f )
	      file4.data = multi5.getBytes()
	      file4.name = "detProjectReport.pdf"
	    file4.description = "Details Project Report"
	    file4.createdBy = session.indUser
	    file4.updatedBy = session.indUser
	    file4.typeOfFile = "Details Project Report"
	    file4.lastUpdated = new Date()
	      
	      file4.dateCreated = new Date()
	      Byte[] bytes3=multi5.getBytes()             	
      	  if(!fileCheck(bytes3))
			  { 
      		  println("Hello deepak")
				  flash.message="You are trying to upload restricted file"
					  render(view: 'applyWhiteCategory', model: [whiteCateInt: whiteCateInt, industryRegMasterInstance:industryRegMasterInstance])
				  return					  
			  }
	      if (file4.save()) {
	    	  println("Data has been Save Project Report")
	      } else {
	      }
//===============================AUTO ACKNOWLEDGEMENT CUM REGISTRATION CERTIFICATE===============================================================
				/*byte[] b1 = new byte[(int) formOfAcknowledgement.length()];
				FileInputStream fileInputStream1 = new FileInputStream(formOfAcknowledgement);
				fileInputStream1.read(b1);


				WhiteCategoryIntergrationFile file11 = new WhiteCategoryIntergrationFile()
				def fileLength1 = formOfAcknowledgement.length()

				file11.applicationId = whiteCateInt
				file11.size = fileLength1 / 1024
				file11.extension = "pdf"//extractExtension( f )
				file11.data = b1;
				file11.name = "White_AUTO_ACKNOWLEDGEMENT.pdf"
				file11.description = "White AUTO ACKNOWLEDGEMENT CERTIFICATE"
				file11.createdBy = session.indUser
				file11.updatedBy = session.indUser
				file11.typeOfFile = "White AUTO ACKNOWLEDGEMENT"
				file11.lastUpdated = new Date()
				file11.dateCreated = new Date()

				if (file11.save()) {
					println("Data has been Save White_AUTO_ACKNOWLEDGEMENT.")
				} else {

				}*/
//===================================================================================================================================================
			/*} catch (Exception e) {

				e.printStackTrace();
			}*/

		} else {
			whiteCateInt.completionStatus = false
		}
		if (whiteCateInt.save()) {
			println("whiteCateInt--save-"+whiteCateInt)
			render(view: 'viewWhiteCategory', model: [whiteCateInt: whiteCateInt, industryRegMasterInstance:industryRegMasterInstance])

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


def generateViewAcknowledgement = {
		if (!session.indUser) {
			redirect(uri: '/index.gsp');
		}
		FormPdf form = new FormPdf()
		println("params in generateViewAcknowledgement :--" + params)
		def applicationFileInstance
		def appDetails
		def appli = (params.appliLoc).toLong()
		appDetails = WhiteCategoryIntegration.get(appli)
		def indUser = IndUser.findByIndustryRegMaster(appDetails.indUser)
		def  intimationFor=params.intimationFor
		
		def industryRegMasterInstance = indUser.industryRegMaster
		println("industryRegMasterInstance in generateViewAcknowledgement :--" + industryRegMasterInstance)
		form.whiteIntimationPdf(appDetails.id);
		if (params.intimationFor == "acknowledgement") {
			if (appDetails) {
				applicationFileInstance = WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile afr where afr.applicationId.id=? and afr.typeOfFile='White AUTO ACKNOWLEDGEMENT' ORDER BY last_updated DESC ", [appDetails.id])
				if(applicationFileInstance) {
					println("applicationFileInstance : " + applicationFileInstance.id)
					def applicationFileSingleInstance = applicationFileInstance
					response.setContentType("application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
				}else{
					render(view: 'viewWhiteCategory', model: [whiteCateInt: appDetails, industryRegMasterInstance:industryRegMasterInstance])
				}
			}
		}

	}

def downLoadUploadedDoc = {
 		def indApplInstance=(params.id).toLong()
 		def applicationDocumentL=WhiteCategoryIntergrationFile.findAll("from WhiteCategoryIntergrationFile apd where apd.id=? ",[indApplInstance],[max:1] )
 		def singleInstanceOfApplicationDocument=applicationDocumentL[0]
 		response.setContentType( "application-xdownload")
 		response.setHeader("Content-Disposition", "attachment;filename=${singleInstanceOfApplicationDocument.name}")
 		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
 	    } 


def whiteApplicationStatus={
		 try {
		        
		 	  println("params in whiteApplicationStatus-----"+params)
		 	   println("params in .appliLoc-----"+(params.appliLoc).getClass().getName())
		 		 def CtoAutoRenSysGenCertFileInstance
		 	    	//def fileVer=(params.verValue)
		 	    	def application = WhiteCategoryIntegration.get((params.appliLoc).toLong())
		 	    	def sessVal
		 	    	if((IndUser)session.getAttribute("indUser")){
		 	    		sessVal=(session.indUser).toString()
		 	    	}else if((UserMaster)session.getAttribute("userMaster")){
		 	    		sessVal=(session.userMaster).toString()       
		 	    	}
		 	 println("application...."+application.getClass().getName())

		 		 CtoAutoRenSysGenCertFileInstance=WhiteCategoryIntergrationFile.findAll("from WhiteCategoryIntergrationFile afr where afr.applicationId.id=? and afr.typeOfFile='White AUTO ACKNOWLEDGEMENT' ORDER BY last_updated DESC",[(application.id).toLong()],[max:1])
		 	    	println("dssdsdsd...."+CtoAutoRenSysGenCertFileInstance)
		 	    	/*if(!CtoAutoRenSysGenCertFileInstance)
		 	    	{
		 	    		FormPdf formPdf=new FormPdf();  	    		
		 	    		formPdf.formAirPdf((params.appliLoc).toLong(),sessVal);
		 	    		CtoAutoRenSysGenCertFileInstance=CtoAutoRenSysGenCertFileInstance.findAll("from CtoAutoRenSysGenCertFileInstance afr where afr.indApplication=? and afr.typeOfFile='CtoAutoConsent' order by afr.id desc",[application],[max:1])
		 	    	}*/
		 	    	def applicationFileSingleInstance=CtoAutoRenSysGenCertFileInstance[0]
		 		   response.setContentType( "application-xdownload")
		 		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		 		   response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )

		 		            
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

//------------- Send the Single Window Application Status Start   By DEEPAK MISHRA  -------------------



def lKsingleWindowConsentApplicationStatus = {
		try {
			
			render(view:'lKsingleWindowConsentApplicationStatus')
		}catch(Exception e) {
	          e.printStackTrace();
	 		 flash.message = "Server Busy. Please try after sometime....";
	 		
	         redirect(uri:'/index.gsp');
	 	}
}
	



def lKsingleWindowConsentApplicationStatusShow = {
		try {
			def indId = params.appId
			
			def app =  IndApplicationDetails.find("from IndApplicationDetails abc where abc.id=? ",[indId.toLong()])
			if(!app)
			{
				
				flash.message="Enter valid application ID !! "
				redirect(action: "lKsingleWindowConsentApplicationStatus")
				return
			}	
			else
			{
				
		        render(view:'lKsingleWindowConsentApplicationStatusShow',model:[IndApplicationDetailsInstance:app])
			}
	    
		}catch(Exception e){
	          e.printStackTrace();
	 		 flash.message = "Server Busy. Please try after sometime...."+e;
	 		
	         redirect(uri:'/index.gsp');
	 		}

}



def sendStatusOfConsentApp = {
	try {
             println("sendStatusOfConsentApp-----"+params)
             
			def indApplicationDetailsInstance=IndApplicationDetails.get(params.appId);
    		def industryRegMasterInstance =indApplicationDetailsInstance.indUser
    		
			String pendingWith=""
			String pendingRoleName=""
			
    		def applicationPending = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
    		println("applicationPending-----"+applicationPending)
    		
    		if(applicationPending){
    			pendingRoleName=applicationPending.role.roleName
    			pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
    		}
    	
			Response resPush= new Response();
    		
			String consentAppNo=indApplicationDetailsInstance			
			String cafNo=industryRegMasterInstance.cafUniqueNo			
			String serviceId=indApplicationDetailsInstance.serviceId
			
			String applicationty=indApplicationDetailsInstance.applicationType
			String applicationFr=indApplicationDetailsInstance.certificateFor
			String appRemarks=""
			String statusCode=""
			String applicationRemarks=""
			String certificateUrl=""
			String printAppUrl="https://jkocmms.nic.in/indApplicationDetails/downloadApplicationForm/"+consentAppNo
			String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+indApplicationDetailsInstance.indUser.indName+"&indDistrict="+indApplicationDetailsInstance.indUser.district.districtName+"&serviceCode="+indApplicationDetailsInstance.serviceId+"&cafUniqueNo="+indApplicationDetailsInstance.cafUniqueNo

			
			println("New Web Service Developed By Deepak Mishra- Send Satus:"+params.radiobtnValue+", Application No:"+consentAppNo+", cafNo:"+cafNo+", serviceId:"+serviceId)
			
			if(params.radiobtnValue=="submitted"){
				statusCode="P";
				appRemarks="Application has been submitted"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)			
				
			}else if(params.radiobtnValue=="scrutinyIncompleted"){
				statusCode="RBI";
				appRemarks="Scrutiny has been raised on application.Kindly check and reply."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="payment"){
				statusCode="Payment";
				appRemarks="Request for Payment"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="clarification"){
				statusCode="F";
				appRemarks="Clarification has been raised on application.Kindly check and reply."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="clarificationReplied"){
				statusCode="F";
				appRemarks="Clarification Replied.Application pending with depaartment"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="inspectionRaised"){
				statusCode="F";
				appRemarks="Inspection has been raised by pcb officer"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="inspectionClosed"){
				statusCode="F";
				appRemarks="Inspection has been closed by pcb officer"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="returned"){
				statusCode="RBI";
				appRemarks="Application has been returned.Kindly Check and reply."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="approved"){
				statusCode="A";
				appRemarks="Application approved.Certificate has been issued"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="rejected"){
				statusCode="R";
				appRemarks="Application rejected."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)				
			}
			
            flash.message="Status Send  !! "
            redirect(action: "lKsingleWindowConsentApplicationStatus")
			return

	

}catch(Exception e) {
      e.printStackTrace();
	 flash.message = "Server Busy. Please try after sometime....";
	
    redirect(uri:'/index.gsp');
	}
  

}

def lKsingleWindowWasteApplicationStatus = {
		try {
			
			render(view:'lKsingleWindowWasteApplicationStatus')
		}catch(Exception e) {
	          e.printStackTrace();
	 		 flash.message = "Server Busy. Please try after sometime....";
	 		
	         redirect(uri:'/index.gsp');
	 	}
}
	
def lKsingleWindowWasteApplicationStatusShow = {
		println("inside lKsingleWindowWasteApplicationStatusShow-----"+params)
		try {
			def indId = params.appId
			def appType 
			def app 
			
			if(params.applicationType=="None"){
				flash.message="Please Select Application Type !! "
					redirect(action: "lKsingleWindowWasteApplicationStatus")
					return
			}else{
				appType=  params.applicationType
			}
			println(" appType-----"+appType)
			if(appType=="BMW"){
				
			 app =  BioMedicalWaste.find("from BioMedicalWaste abc where abc.id=? ",[indId.toLong()])
			
			}
			if(appType=="HWM"){
				
				 app =  HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp abc where abc.id=? ",[indId.toLong()])
				
				}
			println(" app-----"+app)	
			
			if(!app)
			{
				
				flash.message="Enter valid application ID !! "
				redirect(action: "lKsingleWindowWasteApplicationStatus")
				return
			}	
			else
			{
				println("app--555555555--"+app)
		        render(view:'lKsingleWindowWasteApplicationStatusShow',model:[IndApplicationDetailsInstance:app,appType:appType])
			}
	    
		}catch(Exception e){
	          e.printStackTrace();
	 		 flash.message = "Server Busy. Please try after sometime...."+e;
	 		
	         redirect(uri:'/index.gsp');
	 		}

}



def sendStatusOfWasteApp = {
	try {
             println("sendStatusOfWasteApp-----"+params)
             
             def appType=params.appType
         	def indApplicationDetailsInstance
             
             if(appType=="BMW"){
             
			 indApplicationDetailsInstance=BioMedicalWaste.get(params.appId);
             }
             if (appType=="HWM"){
            	 indApplicationDetailsInstance=HazardeousWasteAuthApp.get(params.appId);
             }
             println("indApplicationDetailsInstance-----"+indApplicationDetailsInstance)
    		def industryRegMasterInstance =indApplicationDetailsInstance.industryRegMasterObj
    		
			String pendingWith=""
			String pendingRoleName=""
			
    		def applicationPending = WasteManagementPendingDetails.findByApplicationId(indApplicationDetailsInstance.id)
    		println("applicationPending-----"+applicationPending)
    		
    		if(applicationPending){
    			pendingRoleName=applicationPending.role.roleName
    			pendingWith=applicationPending.pendingWith.userProfile.employeeFirstName+" "+applicationPending.pendingWith.userProfile.employeeLastName
    		}
    	
			Response resPush= new Response();
    		
			String consentAppNo=indApplicationDetailsInstance			
			String cafNo=industryRegMasterInstance.cafUniqueNo			
			String serviceId=indApplicationDetailsInstance.serviceId
			String applicationFr
			String printAppUrl
			
			String applicationty=appType
			   if(appType=="BMW"){
		             
					 applicationFr=indApplicationDetailsInstance.authorisationAppliedFor
					  printAppUrl="https://jkocmms.nic.in/bioMedicalWaste/viewBmwPdf/"+consentAppNo
		             }
		             if (appType=="HWM"){
		            	 applicationFr=indApplicationDetailsInstance.is_Renew
		            	  printAppUrl="https://jkocmms.nic.in/hazardeousWasteAuthApp/viewFormPdf/"+consentAppNo
		             }
		
			String appRemarks=""
			String statusCode=""
			String applicationRemarks=""
			String certificateUrl=""
			
			String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+indApplicationDetailsInstance.industryRegMasterObj.indName+"&indDistrict="+indApplicationDetailsInstance.industryRegMasterObj.district.districtName+"&serviceCode="+indApplicationDetailsInstance.serviceId+"&cafUniqueNo="+indApplicationDetailsInstance.cafUniqueNo

			
			println("New Web Service Developed By Deepak Mishra- Send Satus:"+params.radiobtnValue+", Application No:"+consentAppNo+", cafNo:"+cafNo+", serviceId:"+serviceId)
			
			if(params.radiobtnValue=="submitted"){
				statusCode="P";
				appRemarks="Application has been submitted"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)			
				
			}else if(params.radiobtnValue=="scrutinyIncompleted"){
				statusCode="RBI";
				appRemarks="Scrutiny has been raised on application.Kindly check and reply."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="payment"){
				statusCode="Payment";
				appRemarks="Request for Payment"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="clarification"){
				statusCode="F";
				appRemarks="Clarification has been raised on application.Kindly check and reply."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="clarificationReplied"){
				statusCode="F";
				appRemarks="Clarification Replied.Application pending with depaartment"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="inspectionRaised"){
				statusCode="F";
				appRemarks="Inspection has been raised by pcb officer"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="inspectionClosed"){
				statusCode="F";
				appRemarks="Inspection has been closed by pcb officer"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="returned"){
				statusCode="RBI";
				appRemarks="Application has been returned.Kindly Check and reply."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="approved"){
				statusCode="A";
				appRemarks="Application approved.Certificate has been issued"
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
				
			}else if(params.radiobtnValue=="rejected"){
				statusCode="R";
				appRemarks="Application rejected."
				resPush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)				
			}
			
            flash.message="Status Send  !! "
            redirect(action: "lKsingleWindowWasteApplicationStatus")
			return

	

}catch(Exception e) {
      e.printStackTrace();
	 flash.message = "Server Busy. Please try after sometime....";
	
    redirect(uri:'/index.gsp');
	}
  

}

//------------- Send the Single Window Application Status  End -------------------

}
