import java.io.File
import java.io.FileInputStream
import java.lang.NumberFormatException
import org.apache.commons.fileupload.DiskFileUpload
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date; 
import org.springframework.web.multipart.MultipartFile
import com.EncodeDecodeprogram;
import com.CheckSumRequestBean;
import com.CheckSumResponseBean;
import java.util.Random;
import java.security.Security;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import reconglobalsoap.ReconGlobal;
import com.tp.pg.util.TransactionRequestBean;
import com.tp.pg.util.TransactionResponseBean;

class ApplicationPendingDetailsController {
    
    def index = {
    		 try { 
    		       redirect(action:list,params:params) 
    		    }
    		 catch(Exception e) {
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

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
    	 try { 
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ applicationPendingDetailsInstanceList: ApplicationPendingDetails.list( params ), applicationPendingDetailsInstanceTotal: ApplicationPendingDetails.count() ]
    	    }
    	 catch(Exception e) {
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

    def show = {
    	 try { 
    	        def applicationPendingDetailsInstance = ApplicationPendingDetails.get( params.id )
    	        if(!applicationPendingDetailsInstance) {
    	            flash.message = "ApplicationPendingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ applicationPendingDetailsInstance : applicationPendingDetailsInstance ] }
    	    }
    	 catch(Exception e) {
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

    def delete = {
        def applicationPendingDetailsInstance = ApplicationPendingDetails.get( params.id )
        if(applicationPendingDetailsInstance) {
            try {
                applicationPendingDetailsInstance.delete()
                flash.message = "ApplicationPendingDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "ApplicationPendingDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "ApplicationPendingDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try { 
    	        def applicationPendingDetailsInstance = ApplicationPendingDetails.get( params.id )
    	        if(!applicationPendingDetailsInstance) {
    	            flash.message = "ApplicationPendingDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ applicationPendingDetailsInstance : applicationPendingDetailsInstance ]
    	        }
    	   }
    	 catch(Exception e) {
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

    def update = {
    	 try { 
    	        def applicationPendingDetailsInstance = ApplicationPendingDetails.get( params.id )
    	        if(applicationPendingDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(applicationPendingDetailsInstance.version > version) {
    	                   applicationPendingDetailsInstance.errors.rejectValue("version", "applicationPendingDetails.optimistic.locking.failure", "Another user has updated this ApplicationPendingDetails while you were editing.")
    	                    render(view:'edit',model:[applicationPendingDetailsInstance:applicationPendingDetailsInstance])
    	                    return
    	                }
    	            }
    	            applicationPendingDetailsInstance.properties = params
    	            if(!applicationPendingDetailsInstance.hasErrors() && applicationPendingDetailsInstance.save()) {
    	                flash.message = "ApplicationPendingDetails ${params.id} updated"
    	                redirect(action:show,id:applicationPendingDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[applicationPendingDetailsInstance:applicationPendingDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "ApplicationPendingDetails not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
    	        }
    	    }
    	 catch(Exception e) {
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

    def create = {
    	 try { 
    	        def applicationPendingDetailsInstance = new ApplicationPendingDetails()
    	        applicationPendingDetailsInstance.properties = params
    	        return ['applicationPendingDetailsInstance':applicationPendingDetailsInstance]
    	    }
    	 catch(Exception e) {
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
    	        def applicationPendingDetailsInstance = new ApplicationPendingDetails(params)
    	        if(!applicationPendingDetailsInstance.hasErrors() && applicationPendingDetailsInstance.save()) {
    	            flash.message = "ApplicationPendingDetails ${applicationPendingDetailsInstance.id} created"
    	            redirect(action:show,id:applicationPendingDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[applicationPendingDetailsInstance:applicationPendingDetailsInstance])
    	        }
    	    }
    	 catch(Exception e) {
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
//////////////???????????  
	  
	  ////////////??????????? code for 17 Industry type Industry data
	
			  
	 def ajaxAutoCompleteTest = {
	    	 try {
	    		 def list   
	    		println("params in ajaxAutoCompleteTest----"+params)

	 	    	if(params.autocomplete_parameter1)
	 	    	{
	 	    		String industryTypeId = "";
	 	    		def indType = params.indType
	 	    		def indDist = params.indDist
	 	    		def districtInst = DistrictMaster.get(indDist.toLong())
	 	    		println("districtInst----"+districtInst)
	 	    		def industryTypeList = IndustryTypeMaster.find("from IndustryTypeMaster where id=?",[indType.toLong()])
	 	    		def indTypeId = industryTypeList.id
	 	    		industryTypeId = (indTypeId).toString()
	 	    		
	 	    		println("industryTypeId----"+industryTypeId)
	 	    		def firstInput = (params.autocomplete_parameter1).toLowerCase()
	 	    		def input = firstInput + '%'
	 	    		 list = IndustryRegMaster.findAll("from IndustryRegMaster as country where  country.industryType.id IN ("+industryTypeId+") and country.district.id = "+districtInst.id+" and lower(country.indName) like :applicationName ", [applicationName:input])
	 	    		println("list----"+list)
	 	    	    StringBuffer idList = new StringBuffer() 
	 	    		idList.append("<ul>")
	 	    		list?.each{c -> idList.append("<li>" + c.indName+"</li>")}
	 	    		idList.append("</ul>")   
	 	    		render idList.toString()
	 	    		
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
	


def ajaxVineet = {
    	println("params in ajaxVineet----"+params) 
    	def country1 = new ArrayList()	
    	def cont
    	def a
    	def b
    	def cat
    	def d
    	def certRecord
    	def certId = ""
    	def indScale
    	String industryTypeId = "";
    	def indType = params.indType
    	
    	def indDist = params.indDist
 		def districtInst = DistrictMaster.get(indDist.toLong())
 		println("districtInst----"+districtInst)
 		
    	
    	def industryTypeList = IndustryTypeMaster.findAll("from IndustryTypeMaster where id=?",[indType.toLong()])
    	def indTypeId = industryTypeList.id

    	for(int i=0; i<indTypeId.size(); i++)
    	{
    	if(industryTypeId==""){
    		industryTypeId = (indTypeId[i]).toString()
    	}else{
    			
    		industryTypeId = industryTypeId+","+(indTypeId[i]).toString()	
    	}
    	}
    	println("industryTypeId----"+industryTypeId)
    	
    	System.out.println("districtInst.id==="+districtInst.id);
    	System.out.println("ind name========"+params.id);
    	country1 = IndustryRegMaster.find("from IndustryRegMaster as a where a.industryType.id IN ("+industryTypeId+") and a.district.id = "+districtInst.id+" and a.indName=?",[params.id])
    	println("params in country1----"+country1) 

    	if(country1)
    	{
    	a = country1.indAddress	
    	b = country1.occPhoneNo	

    	cat = country1.category.name
    	d = country1.id
    	indScale = country1.industryScale
    	def appPend = ApplicationPendingDetails.find("from ApplicationPendingDetails where application.applicationType='CTO' and applicationStatus='approved' and application.indUser=? order by id desc",[country1])
    	println("appPend----"+appPend) 

    	if(appPend){
    	certRecord = ApplicationFileRecord.find("from ApplicationFileRecord where indApplication.applicationType='CTO' and indApplication=? and typeOfFile='ConsentOrder' order by dateCreated desc",[appPend.application])	 
    	println("certRecord----"+certRecord) 
    	if(certRecord)
    	{
    		certId = ""+certRecord.indApplication.id	
    		
    	}
    	}
    	}
    	if(country1){
    		cont = a+"#"+b+"#"+cat+"#"+d+"#"+certId+"#"+indScale
    		
    	}else{
    		cont = ""
    			
    	}
    	println("render cont----"+cont) 
    	render cont
}
		
def ajaxGetCities ={
	System.out.println("============ajaxGetCities===============");
	try {
		System.out.println("============params==============="+params);	
		
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

	def insertData = {
			  
			  
	  }		  
			  
def saveData = {println("params----"+params)	  
		def indName = (params.autocomplete_parameter1).toLowerCase()	  
		println("indName----"+indName)
		def industryData
		
		def distInst
		
		def indDataInst = IndustryCategoryWiseDetails.find("from IndustryCategoryWiseDetails as abc where lower(abc.industryName) = ? and districtId = ? and indAddress = ?",[indName,params.district.id,params.indAddress])	
		println("indDataInst----"+indDataInst)
		
		if(indDataInst){
			flash.message="Details regarding same Industry name , district and address already exists."
				render(view:'insertData',model:[abc:indDataInst])
				return
		}
		else{
			industryData = new IndustryCategoryWiseDetails()
			
			// def industryTypeList = IndustryTypeListMaster.get((params.industryType).toLong())
	 	   // println("industryTypeList----"+industryTypeList)	
			def indTypeList = IndustryTypeMaster.find("from IndustryTypeMaster where id=?",[(params.industryType.id).toLong()])
			println("indTypeList.dashboard----"+indTypeList.dashboard)	
			//industryData.industryType = industryTypeList.industryType
			//industryData.indTypeId = params.industryType
			println("indTypeList----"+indTypeList)	
			if(indTypeList){
				
				industryData.industryTypeNew = indTypeList.industryType
				industryData.indTypeIdNew = (params.industryType.id).toString()
				
				if(indTypeList.dashboard !=0){
					def industryTypeList = IndustryTypeListMaster.get(indTypeList.dashboard)
					
					println("industryTypeList----"+industryTypeList)	
					
					industryData.industryType = industryTypeList.industryType
					industryData.indTypeId = (indTypeList.dashboard).toString()
					
				}
				
			}
			
			if(params.district.id)
			{
				industryData.districtId = params.district.id
			 distInst = DistrictMaster.get((params.district.id).toLong())
				
				if(distInst){
					
					industryData.district = distInst.districtName
				}
				
			}
			
			String[] indNameStr=params.autocomplete_parameter1.split(",")
			
			if(params.indregId){
				industryData.indRegId = params.indregId
				}
				else{
					def newUserInst = NewUser.find("from NewUser as abc where lower(abc.name) = ? and abc.districtId=? and abc.address=?",[indName,params.district.id,params.indAddress])	
					println("newUserInst----"+newUserInst)
						if(newUserInst){
							
							println("industry already registered----")	
						}
						else{
					def newUserInstance = new NewUser()
					
					newUserInstance.address = params.indAddress	
					newUserInstance.mobile = params.mobileNo
					newUserInstance.category = params.category	
					
					newUserInstance.industryType = indTypeList.industryType
					newUserInstance.industryTypeId = (params.industryType.id).toString()
					
					newUserInstance.indScale = params.indScale
					
					newUserInstance.name = params.autocomplete_parameter1
					def distCode = "00"
					
					if(params.district.id)
					{
						newUserInstance.districtId = params.district.id
					// distInst = DistrictMaster.get((params.district.id).toLong())
						
						if(distInst){
							
							newUserInstance.district = distInst.districtName
							distCode = distInst.districtCode
						}
						
					}
					
					def date1 = new Date()
					println("date1----"+date1)
					String year1 = date1.getYear().toString()
					println("year1----"+year1)
					String yearString = (String)year1.substring(1,3)
					println("yearString----"+yearString)
					String catValue = params.category	
					println("catValue----"+catValue)
					String catCode =(String)catValue.substring(0,1)
					println("catCode----"+catCode)
					
					Random random = new Random(new Date().getTime());
					int randomInt = random.nextInt(1000000);
					println("randomInt----"+randomInt)
			
				def indRegNew = randomInt.toString()
				println("indRegNew----"+indRegNew)
				
				def userIdValue = ""+catCode+yearString+distCode+indRegNew
				println("userIdValue----"+userIdValue)
				
					newUserInstance.userId = userIdValue
					newUserInstance.regId = randomInt
					
					def pass = Math.round((Math.random()+100000)*Math.random()+10000)
					println("pass----"+pass)
					newUserInstance.passwordEncrypt = params.passwordEncrypt
					newUserInstance.password = params.password
					if(newUserInstance.save(flush:true) ){
						println("newUserInstance saved----")
						}
					else{
						println("newUserInstance not saved----")
						newUserInstance.errors.allErrors.each {
						println it
					
				}
					}
				}
				}
			
			
			industryData.industryName = indNameStr[0]
			industryData.indAddress = params.indAddress
			industryData.mobileNo = params.mobileNo
			industryData.category = params.category
			industryData.operational = params.operational
			industryData.closed = params.closed
			industryData.complying = params.complying
			industryData.nonComplying = params.nonComplying
			industryData.ccaExpiry = params.ccaExpiry
			
			industryData.ccaValidity = params.ccaValidity_value
			industryData.indScale = params.indScale
			
			industryData.createdBy=session.userMaster
			industryData.updatedBy=session.userMaster
			
			industryData.gpi=params.gpi
			if(params.gpi == "Yes"){
				industryData.ganga = params.ganga
				industryData.waterCourse = params.waterCourse
				
			}
			
			if(params.nonComplying=="Yes"){
				industryData.lastAction = params.lastAction
				industryData.scnNote = params.scnNote
				
			}
				if(params.ccaExpiry=="Yes"){
					industryData.lastActionScn = params.lastActionScn
					
					industryData.scnNoteScn = params.scnNoteScn
					
				
				}
			def currDate = new Date()
			
			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
			def validity = sdfh.parse(params.ccaValidity_value); //Date
			
			println("currDate---"+currDate)	
			println("validity---"+validity)	
			
			println("difff---"+validity - currDate)
			
			if(params.ccaExpiry=="Yes")
			{
				if(validity>currDate)
				{
					
					println("validity--g-")	
					industryData.ccaValidity = 	sdfh.format(new Date())
					
				}
				else{
					println("currDate--g-")	
					
				}
			}
			
			if(industryData.save(flush:true)){
				println("industryData-saved---"+industryData)	
				flash.message="Details regarding Industry saved."
				
					def file = new CategoryDataFileRecord()
					def file1 = new CategoryDataFileRecord()
				
				
				def f = request.getFile('consentOrder')
				
				if(!f.empty) {
					MultipartFile multi1 = request.getFile('consentOrder')
					file.size = multi1.getSize() / 1024
					
						file.dateCreated = new Date()
					file.lastUpdated = new Date()
						file.data=multi1.getBytes() 
		            file.extension = extractExtension( multi1 )
		            def abc = "ConsentOrder"
		            	def b = abc+"."+extractExtension( multi1 )
		            	file.name =b
		            	file.description="Industry Consent Order"
		            		file.createdBy=session.userMaster
		            		file.updatedBy=session.userMaster
		            		file.typeOfFile="ConsentOrder"
		            	file.indUser = industryData
		            	
		            	
					if(file.save(flush:true) ){
						println("consent order-saved---"+file)		
						industryData.certificate = true
						industryData.save(flush:true)
					}
					else{
					println("consent order---not saved---")	
					file.errors.each {
				        println it
					}
					}
				}
				else if(params.certApp!=""){
					println("params.certApp----"+params.certApp)
					
					def appId=IndApplicationDetails.get((params.certApp).toLong())
					
					def fileDownLoad = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentOrder' order by afr.dateCreated desc",[appId])
					
				if(fileDownLoad){
					
					file1.size = fileDownLoad.size
					
					file1.dateCreated = new Date()
				file1.lastUpdated = new Date()
					file1.data=fileDownLoad.data
	            file1.extension = fileDownLoad.extension
	            def abc = "ConsentOrder"
	            	def b = abc+"."+fileDownLoad.extension
	            	file1.name =b
	            	file1.description="Industry Consent Order"
	            		file1.createdBy=session.userMaster
	            		file1.updatedBy=session.userMaster
	            		file1.typeOfFile="ConsentOrder"
	            	file1.indUser = industryData
	            	
	            	
				if(file1.save(flush:true) ){
					println("consent order-saved-from App--"+file1)		
					industryData.certificate = true
					industryData.save(flush:true)
				}else{
				println("consent order-from App--not saved---")	
				file1.errors.each {
			        println it
				}
				}
					
				}	
					
				}

				def file2 = new CategoryDataFileRecord()
			
			
			def f1 = request.getFile('scnDoc')
			
			if(!f1.empty) {
				MultipartFile multi2 = request.getFile('scnDoc')
				file2.size = multi2.getSize() / 1024
				
					file2.dateCreated = new Date()
				file2.lastUpdated = new Date()
					file2.data=multi2.getBytes() 
	            file2.extension = extractExtension( multi2 )
	            def abc = "scnDoc"
	            	def b = abc+"."+extractExtension( multi2 )
	            	file2.name =b
	            	file2.description="Industry scn Doc"
	            		file2.createdBy=session.userMaster
	            		file2.updatedBy=session.userMaster
	            		file2.typeOfFile="scnDoc"
	            	file2.indUser = industryData
	            	
	            	
				if(file2.save(flush:true) ){
					println("scnDoc order-saved---"+file2)		
					industryData.scnDoc = true
					industryData.save(flush:true)
				}else{
				println("scnDoc order---not saved---")	
				file2.errors.each {
			        println it
				}
			}
			}
				
				def file3 = new CategoryDataFileRecord()
				
				
				def f2 = request.getFile('scnDocScn')
				
				if(!f2.empty) {
					MultipartFile multi3 = request.getFile('scnDocScn')
					file3.size = multi3.getSize() / 1024
					
						file3.dateCreated = new Date()
					file3.lastUpdated = new Date()
						file3.data=multi3.getBytes() 
		            file3.extension = extractExtension( multi3 )
		            def abc = "scnDocScn"
		            	def b = abc+"."+extractExtension( multi3 )
		            	file3.name =b
		            	file3.description="Industry scn Doc"
		            		file3.createdBy=session.userMaster
		            		file3.updatedBy=session.userMaster
		            		file3.typeOfFile="scnDocScn"
		            	file3.indUser = industryData
		            	
		            	
					if(file3.save(flush:true) ){
						println("scnDocScn order-saved---"+file3)		
						industryData.scnDocScn = true
						industryData.save(flush:true)
					}else{
					println("scnDocScn order---not saved---")	
					file3.errors.each {
				        println it
					}
				}	
				
				}
				
			}
			else{
				println("industryData-not-saved---")	
				industryData.errors.each {
			        println it
				}
			}
			 render(view:'insertData',model:[abc:industryData])
			 return
		}
			  
			 render(view:'insertData')
			 return
			 }		  
	  		  

def downLoadingCertificate={
	 try {
		    
			def appId=IndustryCategoryWiseDetails.get((params.id).toLong())
			
			def fileDownLoad = CategoryDataFileRecord.findAll("from CategoryDataFileRecord afr where afr.indUser=? and afr.typeOfFile='ConsentOrder' order by afr.id desc",[appId],[max:1])
			def fileSingle=fileDownLoad.get(0);
			response.setContentType( "application-xdownload")
			response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
			response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
			
		
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
	

def downLoadingSCNDoc={
	 try {
		    
			def appId=IndustryCategoryWiseDetails.get((params.id).toLong())
			
			def fileDownLoad = CategoryDataFileRecord.findAll("from CategoryDataFileRecord afr where afr.indUser=? and afr.typeOfFile='scnDoc' order by afr.id desc",[appId],[max:1])
			def fileSingle=fileDownLoad.get(0);
			response.setContentType( "application-xdownload")
			response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
			response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
			
		
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

def updatePage = {
			  
			  
	  }

def editData = {
	println("params-----"+params)  
	def indName = params.industry
	println("indName-----"+indName)  
	def indDataInst = IndustryCategoryWiseDetails.find("from IndustryCategoryWiseDetails as abc where abc.industryName = ?",[indName])	
	println("indDataInst----"+indDataInst)

	if(indDataInst){
	//	flash.message="Details regarding Industry already exists."
			render(view:'editData',model:[xyz:indDataInst])
			return
	}
	else{
		flash.message="Please select Industry"
		render(view:'updatePage')
		return
	}
	
}

def updateData = {
	 println("params-----"+params)  
	 def appId = params.indCatId
	 def indDataInst = IndustryCategoryWiseDetails.get(appId.toLong())	
		println("indDataInst----"+indDataInst)
	def distInst
		if(indDataInst){
			
			def indDataInst1 = IndustryCategoryWiseDetails.find("from IndustryCategoryWiseDetails as abc where abc.industryName = ? and abc.districtId = ? and abc.indAddress = ? and abc.id !=?",[params.autocomplete_parameter1,params.district.id,params.indAddress,appId.toLong()])	
			println("indDataInst1----"+indDataInst1)
		
			if(indDataInst1){
				flash.message="Details regarding same Industry name , district and address already exists."
					render(view:'editData',model:[xyz:indDataInst])
					return  
			}	
				
			def indTypeList = IndustryTypeMaster.find("from IndustryTypeMaster where id=?",[(params.industryType.id).toLong()])
			
			
			println("indTypeList----"+indTypeList)	
			if(indTypeList){
				println("indTypeList.dashboard----"+indTypeList.dashboard)	
				indDataInst.industryTypeNew = indTypeList.industryType
				indDataInst.indTypeIdNew = (params.industryType.id).toString()
				
				if(indTypeList.dashboard !=0){
					def industryTypeList = IndustryTypeListMaster.get(indTypeList.dashboard)
					
					println("industryTypeList----"+industryTypeList)	
					
					indDataInst.industryType = industryTypeList.industryType
					indDataInst.indTypeId = (indTypeList.dashboard).toString()
					
				}
				
			}
			
			if(params.district.id)
			{
				indDataInst.districtId = params.district.id
				distInst = DistrictMaster.get((params.district.id).toLong())
				
				if(distInst){
					
					indDataInst.district = distInst.districtName
				}
				
			}
				
			if(params.indregId){
				indDataInst.indRegId = params.indregId
				}
				else{
					
					def indName = (params.autocomplete_parameter1).toLowerCase()	  
					println("indName----"+indName)
					def industryData
				def newUserInst = NewUser.find("from NewUser as abc where lower(abc.name) = ? and abc.districtId=? and abc.address=?",[indName,params.district.id,params.indAddress])	
					println("newUserInst----"+newUserInst)
						if(newUserInst){
							
							println("industry already registered----")	
						}
						else{
					
					def newUserInstance = new NewUser()
					
					newUserInstance.address = params.indAddress	
					newUserInstance.mobile = params.mobileNo
					newUserInstance.category = params.category	
					
					newUserInstance.industryType = indTypeList.industryType
					newUserInstance.industryTypeId = (params.industryType.id).toString()
					
					newUserInstance.indScale = params.indScale
					
					newUserInstance.name = params.autocomplete_parameter1
					
					def distCode = "00"
						
						if(params.district.id)
						{
							newUserInstance.districtId = params.district.id
						// distInst = DistrictMaster.get((params.district.id).toLong())
							
							if(distInst){
								
								newUserInstance.district = distInst.districtName
								distCode = distInst.districtCode
							}
							
						}
					
					def date1 = new Date()
					println("date1----"+date1)
					String year1 = date1.getYear().toString()
					println("year1----"+year1)
					String yearString = (String)year1.substring(1,3)
					println("yearString----"+yearString)
					String catValue = params.category	
					println("catValue----"+catValue)
					String catCode =(String)catValue.substring(0,1)
					println("catCode----"+catCode)
					
					Random random = new Random(new Date().getTime());
					int randomInt = random.nextInt(1000000);
					println("randomInt----"+randomInt)
			
				def indRegNew = randomInt.toString()
				println("indRegNew----"+indRegNew)
				
				def userIdValue = ""+catCode+yearString+distCode+indRegNew
				println("userIdValue----"+userIdValue)
				
					newUserInstance.userId = userIdValue
					newUserInstance.regId = randomInt
					
					def pass = Math.round((Math.random()+100000)*Math.random()+10000)
					println("pass----"+pass)
					newUserInstance.passwordEncrypt = params.passwordEncrypt
					newUserInstance.password = params.password
					if(newUserInstance.save(flush:true) ){
						println("newUserInstance saved----")
						}
					else{
						println("newUserInstance not saved----")
						newUserInstance.errors.allErrors.each {
						println it
					
				}
					}
						}
				}
			
				indDataInst.industryName = params.autocomplete_parameter1
				indDataInst.indAddress = params.indAddress
				indDataInst.mobileNo = params.mobileNo
				indDataInst.category = params.category
				indDataInst.operational = params.operational
				indDataInst.closed = params.closed
				indDataInst.complying = params.complying
				indDataInst.nonComplying = params.nonComplying
				indDataInst.ccaExpiry = params.ccaExpiry
		//		indDataInst.lastAction = params.lastAction
				indDataInst.ccaValidity = params.ccaValidity_value
				indDataInst.indScale = params.indScale
				
				indDataInst.updatedBy=session.userMaster
				
				indDataInst.gpi=params.gpi
				if(params.gpi == "Yes"){
					indDataInst.ganga = params.ganga
					indDataInst.waterCourse = params.waterCourse
					
				}
				
				
				if(params.nonComplying=="Yes"){
					indDataInst.lastAction = params.lastAction
					
					indDataInst.scnNote = params.scnNote
					
				}
					if(params.ccaExpiry=="Yes"){
						indDataInst.lastActionScn = params.lastActionScn
						
					
						indDataInst.scnNoteScn = params.scnNoteScn
						
					
					}
			 
				def currDate = new Date()
				
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
				def validity = sdfh.parse(params.ccaValidity_value); //Date
				
				println("currDate---"+currDate)	
				println("validity---"+validity)	
				
				println("difff---"+validity - currDate)
				
				if(params.ccaExpiry=="Yes")
				{
					if(validity>currDate)
					{
						
						println("validity--g-")	
						indDataInst.ccaValidity = 	sdfh.format(new Date())
						
					}
					else{
						println("currDate--g-")	
						
					}
				}
				
				if(indDataInst.save(flush:true)){
					println("indDataInst-saved---"+indDataInst)	
					flash.message="Details regarding Industry saved."
					
					
						def file1 = new CategoryDataFileRecord()
					
					
					def f = request.getFile('consentOrder')
					
					if(!f.empty) {
						MultipartFile multi1 = request.getFile('consentOrder')
						file1.size = multi1.getSize() / 1024
						
							file1.dateCreated = new Date()
						file1.lastUpdated = new Date()
							file1.data=multi1.getBytes() 
			            file1.extension = extractExtension( multi1 )
			            def abc = "ConsentOrder"
			            	def b = abc+"."+extractExtension( multi1 )
			            	file1.name =b
			            	file1.description="Industry Consent Order"
			            		file1.createdBy=session.userMaster
			            		file1.updatedBy=session.userMaster
			            		file1.typeOfFile="ConsentOrder"
			            	file1.indUser = indDataInst
			            	
			            	
						if(file1.save(flush:true) ){
							println("consent order-saved---"+file1)		
							indDataInst.certificate = true
							indDataInst.save(flush:true)
						}
						println("consent order---not saved---")	
						file1.errors.each {
					        println it
						}
					}
					
					def file2 = new CategoryDataFileRecord()
					
					
					def f1 = request.getFile('scnDoc')
					
					if(!f1.empty) {
						MultipartFile multi2 = request.getFile('scnDoc')
						file2.size = multi2.getSize() / 1024
						
							file2.dateCreated = new Date()
						file2.lastUpdated = new Date()
							file2.data=multi2.getBytes() 
			            file2.extension = extractExtension( multi2 )
			            def abc = "scnDoc"
			            	def b = abc+"."+extractExtension( multi2 )
			            	file2.name =b
			            	file2.description="Industry scn Doc"
			            		file2.createdBy=session.userMaster
			            		file2.updatedBy=session.userMaster
			            		file2.typeOfFile="scnDoc"
			            	file2.indUser = indDataInst
			            	
			            	
						if(file2.save(flush:true) ){
							println("scnDoc order-saved---"+file2)		
							indDataInst.scnDoc = true
							indDataInst.save(flush:true)
						}else{
						println("scnDoc order---not saved---")	
						file2.errors.each {
					        println it
						}
					}
					}
					def file3 = new CategoryDataFileRecord()
					
					
					def f2 = request.getFile('scnDocScn')
					
					if(!f2.empty) {
						MultipartFile multi3 = request.getFile('scnDocScn')
						file3.size = multi3.getSize() / 1024
						
							file3.dateCreated = new Date()
						file3.lastUpdated = new Date()
							file3.data=multi3.getBytes() 
			            file3.extension = extractExtension( multi3 )
			            def abc = "scnDocScn"
			            	def b = abc+"."+extractExtension( multi3 )
			            	file3.name =b
			            	file3.description="Industry scn Doc"
			            		file3.createdBy=session.userMaster
			            		file3.updatedBy=session.userMaster
			            		file3.typeOfFile="scnDocScn"
			            	file3.indUser = indDataInst
			            	
			            	
						if(file3.save(flush:true) ){
							println("scnDocScn order-saved---"+file3)		
							indDataInst.scnDocScn = true
							indDataInst.save(flush:true)
						}else{
						println("scnDocScn order---not saved---")	
						file3.errors.each {
					        println it
						}
					}	
					
					}
					
					
					
				}
				else{
					println("indDataInst-not-saved---")	
					indDataInst.errors.each {
				        println it
					}
				}    
		 	    
			 flash.message="Details regarding Industry updated."
					render(view:'editData',model:[xyz:indDataInst,abc:indDataInst])
					return  
		}
		else{
			flash.message="Please select Industry"
				render(view:'updatePage')
				return
			
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
	 }else if(session.userMaster){
	  
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
    	 }else if(session.userMaster){
    	  
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	          
    				session.invalidate()
    	            redirect(uri:'/index.gsp');
    	 }
    	            }
 }

	/////////////////?????????????	
			def downLoadingSCNDocScn={
		 try {
			    
				def appId=IndustryCategoryWiseDetails.get((params.id).toLong())
				
				def fileDownLoad = CategoryDataFileRecord.findAll("from CategoryDataFileRecord afr where afr.indUser=? and afr.typeOfFile='scnDocScn' order by afr.id desc",[appId],[max:1])
				def fileSingle=fileDownLoad.get(0);
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
				response.getOutputStream() << new ByteArrayInputStream( fileSingle.data )
				
			
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
