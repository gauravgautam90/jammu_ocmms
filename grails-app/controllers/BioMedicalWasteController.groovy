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

class BioMedicalWasteController {
    
    def index = {
    		 try {  redirect(action:list,params:params) 
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
    	        [ bioMedicalWasteInstanceList: BioMedicalWaste.list( params ), bioMedicalWasteInstanceTotal: BioMedicalWaste.count() ]
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
    
    def listgen={
    	 try {  
    	        def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }
    	        def indUserID = industryId.industryRegMaster
    			def status1 = "Inprogress"
    			def status2="Completed"
    			def hazardeousWasteAuthAppInstanceInprogressList = HazardeousWasteAuthApp.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status1)
    			def hazardeousWasteAuthAppInstanceCompletedList = HazardeousWasteAuthApp.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status2)
    			def municipalSolidWasteInprogressList = MunicipalSolidWaste.findAllWhere(indRegMasterObj:indUserID , completionStatus : status1)
    	        def municipalSolidWasteCompletedList = MunicipalSolidWaste.findAllWhere(indRegMasterObj:indUserID , completionStatus : status2)
    	        def bioMedicalWasteInprogressList = BioMedicalWaste.findAllWhere(indRegMasterObj:indUserID , completionStatus : status1)
    			def bioMedicalWasteCompletedList = BioMedicalWaste.findAllWhere(indRegMasterObj:indUserID , completionStatus : status2)
    	        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ hazardeousWasteAuthAppInstanceInprogressList: hazardeousWasteAuthAppInstanceInprogressList,hazardeousWasteAuthAppInstanceCompletedList: hazardeousWasteAuthAppInstanceCompletedList,municipalSolidWasteInprogressList: municipalSolidWasteInprogressList,municipalSolidWasteCompletedList: municipalSolidWasteCompletedList,bioMedicalWasteInprogressList: bioMedicalWasteInprogressList,bioMedicalWasteCompletedList: bioMedicalWasteCompletedList ,hazardeousWasteAuthAppInstanceTotal: hazardeousWasteAuthAppInstanceInprogressList.size(), bioMedicalWasteInstanceList: BioMedicalWaste.list( params ), bioMedicalWasteInstanceTotal: BioMedicalWaste.count() ]
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
    
    def showForGen={
   	 try {
		    
   		 	println("PARAMS IN showForGen----------"+params);
	    	def userId = session.userMaster
	    	def userProfileInstance = userId.userProfile
			def wmpdOb=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wmpd where wmpd.applicationId=? ",[params.id])
			def appProcessInst = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails apd where apd.applicationId=? and apd.approvalStatus='Approved' order by apd.id desc",[params.id])
			def recordCertificateInstance = RecordCertificateBMW.find("from RecordCertificateBMW apd where apd.application.id=? order by id desc",[(params.id).toLong()])
			if(appProcessInst)
			{
				
				
				flash.message = "Certificate can not be modified because application is Approved ";
				redirect(controller:"wasteManagementProcessingDetails" ,action:'appProcessing',params:["id":wmpdOb.id])
				return
				
			}
	    	
			def roleNameOb = wmpdOb.role;
	    	def roleName = roleNameOb.roleName;

	    	
	    	if(userId==null || userId=="")
	    	{
	    		flash.message="Your session has been expired ! Please login again."
	    		redirect(controller:"userMaster",action:"logout")
	    	}


	    	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id))
	    	
	    	IndUser indUserInstance=(IndUser)session.indUser
			
			def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
			
	    	 String aasf=bioMedicalWasteInstance.activityAuthorizationSoughtFor
	    	  def tmp=aasf.split(",")
	          ArrayList tmp1=new ArrayList()
	      	for(int i=0;i<tmp.size();i++)
	      	{
	      		tmp1.add(tmp[i])
	      	}

	      	for(int i=0;i<tmp1.size();i++)
	      	{

	      	}

     
		//recordCertificateInstance.authorizationFor=chk

		def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
	  	println("bioWasteCategQuantList00000000000000========"+bioWasteCategQuantList.size());
	    if(!bioMedicalWasteInstance) {

	            flash.message = "BioMedicalWaste not found with id ${params.id}"
	            redirect(action:list)
	        }
	        else {

	        	
				def userType;
	            def userIdV;
	            if(session.indUser)
	            {
	            	userType="Industry";
	            	userIdV = ((session.indUser).toString()).trim();
	            	
	            }
	            else if (session.userMaster)
	            {
	            	userType="SPCB";
	            	userIdV = ((session.userMaster).toString()).trim();
	            	
	            }
	            def activityRecInstance=new ActivityRecord();
	            activityRecInstance.userType=userType;
	            activityRecInstance.userID=userIdV;
	            activityRecInstance.ipAddress=request.getRemoteAddr() 
	            activityRecInstance.activity = "view"
	            activityRecInstance.status = "Waste Application "+wmpdOb.applicationId+ " Generate Certificate Click. "
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	        	    	println it
	        	  }
	          }
	        	
	        	return [ bioWasteCategQuantList:bioWasteCategQuantList,bioMedicalWasteInstance : bioMedicalWasteInstance , indRegInstanceGet:indRegInstanceGet , tmp1:tmp1,roleName:roleName] 
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
    
    def generateBioNew={
    	 try {  
    	    	def userId = session.userMaster
    	    	if(userId==null || userId=="")
    	    	{
    	    		flash.message="Your session has been expired ! Please login again."
    	    		redirect(controller:"userMaster",action:"logout")
    	    	}
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id).toLong())
    	    	def bioid=bioMedicalWasteInstance.id
    	    	def app = WasteManagementPendingDetails.findByApplicationId(bioid.toString())
    			def id=app.id
    	    	IndUser indUserInstance=(IndUser)session.indUser
    			def indRegInstance=bioMedicalWasteInstance.indRegMasterObj
    			def indRegInstanceId=indRegInstance.id
    			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    	    	def checkForView=false
    			def actionList = new ArrayList()
    	    	def assessmentIssue = false
    	    	def assessmentOrder = false
    	    	def feeDefaulterNotice = false
    	    	def fwdRoleList = new ArrayList()
    	    	 def currentDate=new Date()
    	    	def industryName=indRegInstanceGet.indName+""
    	    	def industryPlot=indRegInstanceGet.plotNo+""
    			def industryAddress=indRegInstanceGet.indAddress+""
    			def industryTehsil=indRegInstanceGet.tehsil.tehsilName+""
    	    	def industryDistrict=indRegInstanceGet.district.districtName+""
    	    	def copyTo=params.copyTo
    	    	def nameOfDistrict=params.nameOfDistrict
    	    	def authorizationNumber=params.authNo
    	    	def letternumber=params.letterNo
    	    	def noticeDate=params.noticeDate_value
    	    	def terms=params.termsco
    	    	def validationMonth=params.validationMonth
    	    	def validationYear=params.validationYear
    	    	def authorizationperiod=params.authPer
    	    	ArrayList chk=new ArrayList()
    	    	int i=0
    	    	if(params['checkboxGeneration']=="on")
    	    	{
    	    		chk[i]="Generation"
    	    			i++
    	        }
    	    	if(params['checkboxCollection']=="on")
    	    	{
    	    		chk[i]="Collection"
    	    			i++
    	        }
    	    	if(params['checkboxReception']=="on")
    	    	{
    	    		chk[i]="Reception"
    	    			i++
    	        }
    	    	if(params['checkboxStorage']=="on")
    	    	{
    	    		chk[i]="Storage"
    	    			i++
    	        }
    	    	if(params['checkboxTransportation']=="on")
    	    	{
    	    		chk[i]="Transportation"
    	    			i++
    	        }
    	    	if(params['checkboxTreatment']=="on")
    	    	{
    	    		chk[i]="Treatment"
    	    			i++
    	        }
    	    	if(params['checkboxDisposal']=="on")
    	    	{
    	    		chk[i]="Disposal"
    	    			i++
    	        }
    	    	if(params['checkboxAnyother']=="on")
    	    	{
    	    		chk[i]="Anyother"
    	    			i++
    	        }
    	    	WasteManagementCertificates file=new WasteManagementCertificates()
    	    	BioMedicalWasteCertificate cert=new BioMedicalWasteCertificate()
    	    	def certFile=cert.bioCert(industryName,industryAddress,industryTehsil,industryDistrict,nameOfDistrict,authorizationNumber,letternumber,noticeDate,terms,copyTo,chk,authorizationperiod,validationMonth,validationYear)
    	    	byte[] b = new byte[(int) certFile.length()];
    	    	FileInputStream fileInputStream = new FileInputStream(certFile);
    	    	fileInputStream.read(b);
    	    		def fileLength=certFile.length()
    	     	 file.size = fileLength / 1024  //f.getSize() 
    	     	 file.extension ="pdf"//extractExtension( f )
    	         file.data=b;
    	    	 file.name=(bioid.toString()).concat("BioMedicalWaste(New)").concat(".pdf")
    	       	 file.description="BioMedicalWaste - New Generation Record"
    	    	 file.createdBy=indRegInstance.indName//"abc"//session.userMaster
    	    	 file.updatedBy=indRegInstance.indName//"xyz"//session.userMaster
    	    	 file.typeOfFile="BMW"
    	    	 file.indreg=indRegInstanceGet
    	    	 file.applicationId=bioid
    	    	 file.applicationFor="BMW"
    	    	 file.dateCreated=currentDate
    	    	 def wastecert
    	    	 def fileid = null
    	    		 if(file.save()) {
    	    			 fileid=file.id
    	     	    	  flash.userMessage = "BioMedicalWaste - New Certificate is generated properly."
    	     	    		 checkForView=true
    	     	    		redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
    	    	     }
    	     	    	else {
    	     	    	   flash.userMessage = "BioMedicalWaste - New Certificate is not generated."
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
    def generateBioReNew={
       	 try {
 		    
 	    	
 	    	def userId = session.userMaster
 	    	if(userId==null || userId=="")
 	    	{
 	    		flash.message="Your session has been expired ! Please login again."
 	    		redirect(controller:"userMaster",action:"logout")
 	    	}
 	    	
 	    	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id).toLong())
 	    	def bioid=bioMedicalWasteInstance.id
 	    	
 	    	def app = WasteManagementPendingDetails.findByApplicationId(bioid.toString())
 			def id=app.id
 			 def appId=params.id
 			 def dateofsubmition=params.dateofsubmition
 			IndUser indUserInstance=(IndUser)session.indUser
 			
 			IndUser indUserInstance1=(IndUser)session.indUser
 			
 			def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
 			def indRegInstanceId=indRegInstance.id
 			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
 	    	
 	    	def noOfBeds 
 	    	def	noOfPatients
 	    	def	noOfpatients
 	    	def noOfSamples
 	    	def noOfsamples
 	    	def noOfbeds
 	    	def noOfChairs
 	    	def checkForView=false
 			def actionList = new ArrayList()
 	    	def assessmentIssue = false
 	    	def assessmentOrder = false
 	    	def feeDefaulterNotice = false
 	    	def expiryDate=params.expiryDate_value
 	    	def fwdRoleList = new ArrayList()
 	    	def roleName1=params.roleName
 	    	
 	      	def termsco=params.termsco
 	    	

 	    	def cat = IndustryRegMaster.findById(indRegInstanceGet.id.toLong())

 	    	def catinst = cat.category.name
 	    	def authorisationAppliedFor =bioMedicalWasteInstance.authorisationAppliedFor
 	    	def inspectionData=BioMedicalInspectionReport.findByApplication(bioMedicalWasteInstance)
 	    	def inspectionDataList= new ArrayList()
 	    	if(!inspectionData){
 	    		println("---Inspection is not generated----------")
 	    		flash.message="Please Generate Inspection Report."
 	    		redirect(controller:'wasteManagementProcessingDetails',action:'appProcessing',id:id);
 	    		return
 	    	}
 	    	else if(inspectionData){
 	    		inspectionDataList.add(inspectionData.authorizationSought)
 	    		inspectionDataList.add(inspectionData.hcfType)
 	    		inspectionDataList.add(inspectionData.hcfTypeMenu)
 	    		inspectionDataList.add(inspectionData.wasteGenQuantity)
 	    	}else{
 	    		println("---Inspection is not generated----------")
 	    		flash.message="Please Generate Inspection Report."
 	    			redirect(controller:'userMaster',action:'openSpcbHome');
 	    		return
 	    	}


 	    	
 	    	if(catinst.equals("HOSPITAL"))
 	    	{
 	    		noOfBeds =(indRegInstanceGet.indCapInvt).toInteger()+""	
 	    				

 	    	}
 	    	
 	    	else if(catinst.equals("CLINIC")){
 	    		
 	    		noOfPatients=indRegInstanceGet.indCapInvt.toInteger()+""
 		
 	    		}
 	    	
 	    	
 	    	else if(catinst.equals("VETERINARY")){
 	    		
 	    	noOfpatients=indRegInstanceGet.indCapInvt.toInteger()+""
 		
 	       		}

 	    	else if(catinst.equals("BLOOD BANK")){
 	    		
 	        noOfSamples=indRegInstanceGet.indCapInvt.toInteger()+""
 			
 	          		}
 	    	
 	    	else if(catinst.equals("LAB")){
 	    		
 	          noOfsamples=indRegInstanceGet.indCapInvt.toInteger()+""
 			
 	         		}
 	    	else if(catinst.equals("DENTAL CLINIC")){
 	    		
 	            noOfChairs=indRegInstanceGet.indCapInvt.toInteger()+""
 			
 	           		}
 	    	else if(catinst.equals("CBWTF")){
 	    		
 	    		noOfbeds=indRegInstanceGet.indCapInvt.toInteger()+""
 			
 	           		}
 	    	
 	        def currentDate=new Date()
 	    	def industryName=indRegInstanceGet.indName+""

 	    	def industryPlot=indRegInstanceGet.plotNo+""
 			def industryAddress=indRegInstanceGet.indAddress+""
 	def industryTehsil=indRegInstanceGet.tehsil.tehsilName+""
 	def occName=indRegInstanceGet.occName+""
 	def addrPlaceDisposalOfWaste = bioMedicalWasteInstance.addrPlaceDisposalOfWaste+""
 			String str32 = industryTehsil.toLowerCase();
 	        char[] c32 = str32.toCharArray();
 	        c32[0] = Character.toUpperCase(c32[0]);
 	        industryTehsil=c32.toString()
 			
 	    	def industryDistrict=indRegInstanceGet.district.districtName+""
 	    	String str33 = industryDistrict.toLowerCase();
 	        char[] c33 = str33.toCharArray();
 	        c33[0] = Character.toUpperCase(c33[0]);
 	        industryDistrict=c33.toString()
 	    	def draftDate=params.draftLetterDate_value
 	    	def copyTo=params.copyTo
 	    	def nameOfDistrict=params.nameOfDistrict
 	    	//def authorizationNumber=params.authNo
 	    	def authorizationNumber="JKPCB/"+params.typeOfOfficer+"/"+"BMW/"+bioMedicalWasteInstance.id
//////////////////////////////////// 	/

 	        def officername=params.officername
 	    	def offname=params.offname
 	    	def offdesg=params.offdesg
 	    	String renewFrom = ""
 	    		String renewTo = ""
 	    	if(params.draftLetterFor=="Granted"){
 	    	 renewFrom = params.noticeDate_value
 			 renewTo = params.expiryDate_value
 	    	}
 	    	///////////////////////////////////
 	    	def letternumber=params.letterNo
 	    	def noticeDate=params.noticeDate_value
 	    	def terms=params.termsco
 	    	def authorizationperiod=params.authPer
 	    	def authfrom=params.renewalFrom_value
 	    	def authto=params.renewalTo_value
 	    	def offAddres = params.offAddres
 	    	def name=params.name
 	    	def nameind=params.nameind
 	    	def address=params.address
 	    	
 	    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 			def dateToday = new Date();
 	    	def date = dateFormat.format(dateToday)
 	    	
 	    	def activityauthorizationsoughtfor=bioMedicalWasteInstance.activityAuthorizationSoughtFor+""
 	    	activityauthorizationsoughtfor = activityauthorizationsoughtfor.replace(',',', ')
 			
 	    	
 			DateCustom dd2=new DateCustom()
 				def currentDate11= (dd2.sQLdate1(new Date()))
 				
 				def cryr=(currentDate11.getYear()).toInteger()+1900
 				
 			
 			
 	    	ArrayList chk=new ArrayList()
 	    	int i=0
 	    	if(params['checkboxGeneration']=="on")
 	    	{
 	    		chk[i]="Generation"
 	    			i++
 	        }
 	    	if(params['checkboxCollection']=="on")
 	    	{
 	    		chk[i]="Collection"
 	    			i++
 	        }
 	    	if(params['checkboxReception']=="on")
 	    	{
 	    		chk[i]="Reception"
 	    			i++
 	        }
 	    	if(params['checkboxStorage']=="on")
 	    	{
 	    		chk[i]="Storage"
 	    			i++
 	        }
 	    	if(params['checkboxTransportation']=="on")
 	    	{
 	    		chk[i]="Transportation"
 	    			i++
 	        }
 	    	if(params['checkboxTreatment']=="on")
 	    	{
 	    		chk[i]="Treatment"
 	    			i++
 	        }
 	    	if(params['checkboxDisposal']=="on")
 	    	{
 	    		chk[i]="Disposal"
 	    			i++
 	        }
 	    	if(params['checkboxAnyother']=="on")
 	    	{
 	    		chk[i]="Anyother"
 	    			i++
 	        }
 	    	
 	    	
 	    	
 	    	
 	    	def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
 	    	        	

 	    	def catListDetails =new ArrayList()
 	    	for(int u = 0 ; u <bioWasteCategQuantList.size();u++){
 	    		def catList =new ArrayList()
 	    		if(u==0){
 	    		catList.add("Category I :")
 	    		}else if(u==1){
 	    			catList.add("Category II :")
 	    		}else if(u==2){
 	    			catList.add("Category III :")
 	    		}else if(u==3){
 	    			catList.add("Category IV :")
 	    		}else if(u==4){
 	    			catList.add("Category V :")
 	    		}else if(u==5){
 	    			catList.add("Category VI :")
 	    		}else if(u==6){
 	    			catList.add("Category VII :")
 	    		}else if(u==7){
 	    			catList.add("Category VIII :")
 	    		}else if(u==8){
 	    			catList.add("Category IX :")
 	    		}else if(u==9){
 	    			catList.add("Category X :")
 	    		}
 	    		
 	    		
 	    		catList.add(bioWasteCategQuantList.category.get(u))
 	    		catList.add("		")
 	    		catList.add(bioWasteCategQuantList.quantity.get(u)+" "+bioWasteCategQuantList.unit.get(u))
 	    		catList.add("")
 	    		catListDetails.add(catList)
 	    		
 	    	}
 	    	

 	    	def referenceCheck=params.copyTo
 	    	def refSize=referenceCheck.size()


 	    	def referencesArray = new String[refSize] 

 	    	def referenceStore=""



 	    	if(referenceCheck.getClass().getName()=="java.lang.String") {
 	    		referenceStore="1. "+referenceCheck
 	    	}else{
 	    		for(int varI=0; varI<referenceCheck.size();varI++) {
 	    			int varInteger=varI+1
 	    			referencesArray[varI]=referenceCheck[varI]
 	    			referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
 	    		}
 	    	}
 	    	for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {

 	    	}



 	    	  def generation =false
   			def collection = false
   			def storage =false
   			def transportation = false
   			def reception = false
   			def reuse = false
   			def recycling =false
   			def recovery = false
   			def preprocessing =false
   			def coprocessing = false
   			def utilisation = false
   			def treatment = false
   			def disposal =false
   			def incineration = false
   	        
   	        
   	        String authReqFor=""
   				if(params['chkGeneration']=="on") {
   					authReqFor=authReqFor.concat("Generation")
   					authReqFor=authReqFor.concat(",")
   					generation=true
   					
   				}
   		        if(params['chkCollection']=="on") {
   					authReqFor=authReqFor.concat("Collection")
   					authReqFor=authReqFor.concat(",")
   					collection=true
   				}
   				if(params['chkStorage']=="on") {
   					authReqFor=authReqFor.concat("Storage")
   					authReqFor=authReqFor.concat(",")
   					storage=true
   				}
   				if(params['chkTransportation']=="on") {
   					authReqFor=authReqFor.concat("Transportation")
   					authReqFor=authReqFor.concat(",")
   					transportation=true
   				}
   				if(params['chkReception']=="on") {
   					authReqFor=authReqFor.concat("Reception")
   					authReqFor=authReqFor.concat(",")
   					reception=true
   				}
   				if(params['chkReuse']=="on") {
   					authReqFor=authReqFor.concat("Reuse")
   					authReqFor=authReqFor.concat(",")
   					reuse=true
   				}
   				if(params['chkRecycling']=="on") {
   					authReqFor=authReqFor.concat("Recycling")
   					authReqFor=authReqFor.concat(",")
   					recycling=true
   				}
   				if(params['chkRecovery']=="on") {
   					authReqFor=authReqFor.concat("Recovery")
   					authReqFor=authReqFor.concat(",")
   					recovery=true
   				}
   				if(params['chkPre-processing']=="on") {
   					authReqFor=authReqFor.concat("Pre-processing")
   					authReqFor=authReqFor.concat(",")
   					preprocessing=true
   				}
   				if(params['chkCo-processing']=="on") {
   					authReqFor=authReqFor.concat("Co-processing")
   					authReqFor=authReqFor.concat(",")
   					coprocessing=true
   				}
   				if(params['chkUtilisation']=="on") {
   					authReqFor=authReqFor.concat("Utilisation")
   					authReqFor=authReqFor.concat(",")
   					utilisation=true
   				}
   				if(params['chkTreatment']=="on") {
   					authReqFor=authReqFor.concat("Treatment")
   					authReqFor=authReqFor.concat(",")
   					treatment=true
   				}
   				if(params['chkDisposal']=="on") {
   					authReqFor=authReqFor.concat("Disposal")
   					authReqFor=authReqFor.concat(",")
   					disposal=true
   				}
   				if(params['chkIncineration']=="on") {
   					authReqFor=authReqFor.concat("Incineration")
   					authReqFor=authReqFor.concat(",")
   					incineration=true
   				}
   				println("authReqFor---"+authReqFor)
   				if(authReqFor.length()>0)
   				{
   					authReqFor = authReqFor.substring(0, authReqFor.length() - 1);	
   				}
   				
   				println("authReqFor-222--"+authReqFor)
 	    	
 	    	
 	    	def recordCertificate = RecordCertificateBMW.findByApplication(bioMedicalWasteInstance)

 	    	    	
 	    	    	//////////////////////////////////////////////////////////////////
 	    	    	WasteManagementCertificates file=new WasteManagementCertificates()
 	    	    	
 	    	    	
 	    	    	/////////////saving instance in bmw by richa///////////////////
 	    	    	RecordCertificateBMW recordCertificateInstance = new RecordCertificateBMW()
 	    	    	
 	    	    	
 	    	    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
 	    			if(params.noticeDate_value){
 	    	    	def x = sdfh.parse(params.noticeDate_value);
 	    	    	recordCertificateInstance.issueDate=x
 	    	    	}
 	    			else{
 	    				recordCertificateInstance.issueDate=new Date()
 	    			}
 	    			def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
 	    			
 	    			
 	    			if(params.expiryDate_value){		
 	    			def xy = sdfh.parse(params.expiryDate_value);
 	    			recordCertificateInstance.expiryDate=xy
 	    			}else{
 	    				recordCertificateInstance.expiryDate=new Date()
 	    			}
 	    		///// For Year
 	    			recordCertificateInstance.year=cryr.toString()
 	    			
 	    			recordCertificateInstance.letterFor=params.draftLetterFor
 	    			recordCertificateInstance.termsco=params.termsco
 	    			recordCertificateInstance.authPeriod=params.authPer
 	    			recordCertificateInstance.offAddres=params.offAddres
 	    			recordCertificateInstance.authorizationNo=params.authNo
 	    			recordCertificateInstance.application=bioMedicalWasteInstance
 	    			//recordCertificateInstance.authorizationFor=chk
 	    			recordCertificateInstance.copyTo=params.copyTo
 	    			recordCertificateInstance.facility=params.facility
 	    			recordCertificateInstance.serviceProvider=params.serviceProvider
 	    			recordCertificateInstance.collected=params.collected
 	    			recordCertificateInstance.authCancelled=params.authCancelled
 	    			
 	    			recordCertificateInstance.offdesg=params.offdesg
 	    			recordCertificateInstance.officername=params.officername
 	    			recordCertificateInstance.offname=params.offname
 	    			
 	    			recordCertificateInstance.typeOfOfficer=params.typeOfOfficer
 	    			recordCertificateInstance.RegionalOffice=params.RegionalOffice
 	    			if(authReqFor)
 					{
 	    				recordCertificateInstance.authorizationFor=authReqFor
 					}
 					else{
 						
 						recordCertificateInstance.authorizationFor=""
 					}
 	    			
 	    			if(params.draftLetterFor=="Granted"){
 	    				
 	    			
 	    				
 	    			recordCertificateInstance.subject=""
 	    			recordCertificateInstance.authPeriod=""
 	    			recordCertificateInstance.draftLetterFor="Granted"
 	    			recordCertificateInstance.letterNo=params.letterNo
 	    			recordCertificateInstance.letterFor=params.draftLetterFor
 	    			recordCertificateInstance.termsco=params.termsco
 	    			recordCertificateInstance.authorizationNo=params.authNo
 	    			recordCertificateInstance.application=bioMedicalWasteInstance
// 	    			recordCertificateInstance.authorizationFor=chk
 	    			recordCertificateInstance.copyTo=params.copyTo
 	    			recordCertificateInstance.offAddres=params.offAddres
 	    			recordCertificateInstance.facility=params.facility
 	    			recordCertificateInstance.serviceProvider=params.serviceProvider
 	    			recordCertificateInstance.collected=params.collected
 	    			recordCertificateInstance.authCancelled=params.authCancelled
 	    			recordCertificateInstance.name=params.name
 	    			recordCertificateInstance.nameind=params.nameind
 	    			recordCertificateInstance.address=params.address
 	    			}else{
 	    				
 	    			
 	    				recordCertificateInstance.subject=""
 	    				recordCertificateInstance.authPeriod=""
 	    				recordCertificateInstance.draftLetterFor="Rejected"
 	    					recordCertificateInstance.letterNo=""
 	    						recordCertificateInstance.letterFor=params.draftLetterFor
 	    						recordCertificateInstance.termsco=""
 	    						recordCertificateInstance.authorizationNo=params.authNo
 	    						recordCertificateInstance.application=bioMedicalWasteInstance
// 	    						recordCertificateInstance.authorizationFor=""
 	    						recordCertificateInstance.copyTo=params.copyTo
 	    						recordCertificateInstance.offAddres=params.offAddres
 	    						recordCertificateInstance.facility=""
 	    						recordCertificateInstance.serviceProvider=""
 	    						recordCertificateInstance.collected=""
 	    						recordCertificateInstance.authCancelled=""
 	    							recordCertificateInstance.name=params.name
 	    							recordCertificateInstance.nameind=params.nameind
 	    							recordCertificateInstance.address=params.address
 	    					
 	    			}
 	    			if(recordCertificateInstance.save(flush:true)){
 	    				if(recordCertificate)
 	    		    	{
 	    		    		recordCertificate.delete()
 	    		    	}
 	    				
 	    			}else{
 	    	        	  if(recordCertificateInstance.hasErrors()){
 	    	        		  recordCertificateInstance.errors.allErrors.each {
 	    	        	  println it
 	    	        	  }
 	    	        	  } 
 	    	        	  }
 	    	    	
 	    	    	def details=params.authPer
 	    	    	
 	    	    	def appDate = app.dateCreated
 	    	    	String S = new SimpleDateFormat("MM/dd/yyyy").format(appDate);
 	    	    	def subject = params.subject
 	    	    	def draftLetterFor = params.draftLetterFor
 	    	    	
 	    	    	def facility = params.facility
 	    	    	def serviceProvider = params.serviceProvider
 	    	    	def collected = params.collected
 	    	    	def authCancelled = params.authCancelled
 	    	    	
 	    	
 	    
 	    	 def certFile
 	    	 if(params.draftLetterFor=="Granted"){ 	
 	    		 
 	    		 
 	    		 BioMedicalWasteRenewCertificate cert=new BioMedicalWasteRenewCertificate()
 	    		 GenerateBMWAuth auth= new GenerateBMWAuth()
 	    	    	flash.userMessage="certificate has been generated"
 	    	    	if(referenceCheck.getClass().getName()=="java.lang.String") {
 	    	    				certFile=auth.bioCertRenew(draftLetterFor,catListDetails,
 	    	       			industryName,industryAddress,industryTehsil,industryDistrict,nameOfDistrict,
 	    	       			authorizationNumber,letternumber,noticeDate,copyTo,chk,authorizationperiod,
 	    	       			noOfBeds,noOfsamples,noOfSamples,noOfpatients,noOfPatients,expiryDate,activityauthorizationsoughtfor,
 	    	       			subject,S,catinst,noOfChairs,noOfbeds,occName,offAddres,addrPlaceDisposalOfWaste,termsco,
 	    	       			draftDate,referenceCheck,roleName1,appId,dateofsubmition,name,nameind,address,date,
 	    	       			offname,offdesg,renewFrom,renewTo,officername,generation,collection,storage,transportation,
 	    	    			reception,reuse,recycling,recovery,preprocessing,coprocessing,
 	    	        	    treatment,disposal,incineration,utilisation,facility,serviceProvider,
 	    	    			collected,authCancelled,inspectionDataList,authorisationAppliedFor)
 	    	       		}else{
 	    	       			certFile=cert.bioCertRenew(draftLetterFor,catListDetails,
 	    	       	    			industryName,industryAddress,industryTehsil,industryDistrict,nameOfDistrict,
 	    	       	    			authorizationNumber,letternumber,noticeDate,copyTo,chk,authorizationperiod,
 	    	       	    			noOfBeds,noOfsamples,noOfSamples,noOfpatients,noOfPatients,expiryDate,activityauthorizationsoughtfor,
 	    	       	    			subject,S,catinst,noOfChairs,noOfbeds,occName,offAddres,addrPlaceDisposalOfWaste,termsco,
 	    	       	    			draftDate,referenceStore,roleName1,appId,dateofsubmition,name,nameind,address,date,offname,
 	    	       	    			offdesg,renewFrom,renewTo,officername,generation,collection,storage,transportation,
 	    	    	    			reception,reuse,recycling,recovery,preprocessing,coprocessing,
 	    	    	        	    treatment,disposal,incineration,utilisation,facility,serviceProvider,
 	    	    	    			collected,authCancelled)
 	    	       			
 	    	       		}
 	    		 
 	    		 file.name=(bioid.toString()).concat("BioMedicalWaste(ReNew)").concat(".pdf")
 	    		 file.description="BioMedicalWaste - Re-New Generation Record"
 	    		 file.typeOfFile="BMW"
 	    		 
 	    		 
 	    		 
 	    	 }else
 	    	 {
 	    		 
 	    		    BioMedicalWasteRefusalCertificate cert1=new BioMedicalWasteRefusalCertificate()
 	      	    	flash.message="certificate has been generated"
 	      	    			if(referenceCheck.getClass().getName()=="java.lang.String") {
 	      	    				certFile=cert1.bioCertRefusal(draftLetterFor,catListDetails,
 	      	   	       	    			industryName,industryAddress,industryTehsil,industryDistrict,nameOfDistrict,
 	      	   	       	    			authorizationNumber,letternumber,noticeDate,copyTo,chk,authorizationperiod,
 	      	   	       	    			noOfBeds,noOfsamples,noOfSamples,noOfpatients,noOfPatients,expiryDate,activityauthorizationsoughtfor,
 	      	   	       	    			subject,S,catinst,noOfChairs,noOfbeds,occName,offAddres,addrPlaceDisposalOfWaste,termsco,
 	      	   	       	    			draftDate,referenceStore,roleName1,appId,dateofsubmition,name,nameind,address,date,offname,
 	      	   	       	    			offdesg,renewFrom,renewTo,officername,generation,collection,storage,transportation,
 	      	   	    	    			reception,reuse,recycling,recovery,preprocessing,coprocessing,
 	      	   	    	        	    treatment,disposal,incineration,utilisation,facility,serviceProvider,
 	      	   	    	    			collected,authCancelled)
 	      	       		}else{
 	      	       			certFile=cert1.bioCertRefusal(draftLetterFor,catListDetails,
 	      	       	    			industryName,industryAddress,industryTehsil,industryDistrict,nameOfDistrict,
 	      	       	    			authorizationNumber,letternumber,noticeDate,copyTo,chk,authorizationperiod,
 	      	       	    			noOfBeds,noOfsamples,noOfSamples,noOfpatients,noOfPatients,expiryDate,activityauthorizationsoughtfor,
 	      	       	    			subject,S,catinst,noOfChairs,noOfbeds,occName,offAddres,addrPlaceDisposalOfWaste,termsco,
 	      	       	    			draftDate,referenceStore,roleName1,appId,dateofsubmition,name,nameind,address,date,offname,
 	      	       	    			offdesg,renewFrom,renewTo,officername,generation,collection,storage,transportation,
 	      	    	    			reception,reuse,recycling,recovery,preprocessing,coprocessing,
 	      	    	        	    treatment,disposal,incineration,utilisation,facility,serviceProvider,
 	      	    	    			collected,authCancelled)
 	      	       			
 	      	       		}
 	    		 
 	    		    file.name=(bioid.toString()).concat("BioMedicalWaste(Refusal)").concat(".pdf");
 	    		    file.description="BioMedicalWaste - Refusal Generation Record";
 	    		    file.typeOfFile="BmwRefusalCertificate"
 	    		    
 	    	 }
 	    	 byte[] b = new byte[(int) certFile.length()];
 	    	 FileInputStream fileInputStream = new FileInputStream(certFile);
 	    	 fileInputStream.read(b);
 	    	
 	    	 def fileLength=certFile.length()
 	     	 file.size = fileLength / 1024  //f.getSize() 

 	         file.extension ="pdf"//extractExtension( f )

 	       	 file.data=b;

 	       	 
 	    	 file.createdBy=indRegInstance.indName//"abc"//session.userMaster

 	    	 file.updatedBy=indRegInstance.indName//"xyz"//session.userMaster
 	    	 file.indreg=indRegInstanceGet

 	    	 file.applicationId=bioid

 	    	 file.applicationFor="BMW"

 	    	 file.dateCreated=currentDate
 	    	 def appliCert = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.typeOfFile='BMW' order by afr.id asc",[bioid])
			  	
 	    	 
 	    	 def wastecert
 	    	 def fileid = null
 	    		 if(file.save(flush:true)) {
 	    			 if(appliCert){
  	  		    		appliCert.delete();
  	  		    	}
 	    			 fileid=file.id

 	      	    	  flash.userMessage = "BioMedicalWaste - Certificate is generated properly."
 	      	    		 checkForView=true
 	      	    		def userType;
	    	            def userIdV;
	    	            if(session.indUser)
	    	            {
	    	            	userType="Industry";
	    	            	userIdV = ((session.indUser).toString()).trim();
	    	            	
	    	            }
	    	            else if (session.userMaster)
	    	            {
	    	            	userType="SPCB";
	    	            	userIdV = ((session.userMaster).toString()).trim();
	    	            	
	    	            }
	    	            def activityRecInstance=new ActivityRecord();
	    	            activityRecInstance.userType=userType;
	    	            activityRecInstance.userID=userIdV;
	    	            activityRecInstance.ipAddress=request.getRemoteAddr() 
	    	            activityRecInstance.activity = "add"
	    	            activityRecInstance.status = "Waste Application "+params.id+ " Generate Certificate Successfully. "
	    	            if(activityRecInstance.save()){		   
	    	              }
	    	            	else{
	    	            		activityRecInstance.errors.each {
	    	        	    	println it
	    	        	  }
	    	          }
 	      	    		redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
 	     		 }
 	     	    		else {

 	     	    	   flash.userMessage = "BioMedicalWaste - Certificate is not generated."
 	     	    		  
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
    
    def viewBioCert={
    	 try {  
    	    	def industryId = session.indUser
    	    	def userId = session.userMaster
    	    	if((userId==null || userId=="") && (industryId==null || industryId==""))
    	    	{
    	    		flash.message="Your session has been expired ! Please login again."
    	    		redirect(controller:"userMaster",action:"logout")
    	    	}
    	    	
    	    	def application = WasteManagementCertificates.get((params.id).toLong())
    	    	def applicationFileSingleInstance=application
    		   response.setContentType( "application-xdownload")
    		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
    
def viewBioCert1={
    	 try { 
    	    	def industryId = session.indUser
    	    	def userId = session.userMaster
    	    	if((userId==null || userId=="") && (industryId==null || industryId==""))
    	    	{
    	    		flash.message="Your session has been expired ! Please login again."
    	    		redirect(controller:"userMaster",action:"logout")
    	    	}
    	    	def temp=(params.id).toLong()
    	    	def application = WasteManagementCertificates.findAllWhere(applicationId:temp)    	
    	    	def applicationFileSingleInstance=application[(application.size())-1]
    	    	response.setContentType( "application-xdownload")
    		   response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    		   response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
    
    def showForGenRenew={
       	 try {
 		    
 	    	def userId = session.userMaster
 	    	if(userId==null || userId=="")
 	    	{
 	    		flash.message="Your session has been expired ! Please login again."
 	    		redirect(controller:"userMaster",action:"logout")
 	    	}
 	    	
 	def wmpdOb=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wmpd where wmpd.applicationId=? ",[params.id])
 			
 		def recordCertificateInstance = RecordCertificateBMW.find("from RecordCertificateBMW apd where apd.application.id=? order by id desc",[(params.id).toLong()])
 				
 			def appProcessInst = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails apd where apd.applicationId=? and apd.approvalStatus='Approved' order by apd.id desc",[params.id])
 			
 			if(appProcessInst)
 			{
 				
 				
 				flash.message = "Certificate can not be modified because application is Approved ";
 				redirect(controller:"wasteManagementProcessingDetails" ,action:'appProcessing',params:["id":wmpdOb.id])
 				return
 				
 			}
 			
 			def roleNameOb = wmpdOb.role;

 	    	def roleName = roleNameOb.roleName;

 	    	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id))
 	    	
 	    	IndUser indUserInstance=(IndUser)session.indUser
 			def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
 			def indRegInstanceId=indRegInstance.id
 			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
 			def offaddress = params.offAddres
 			
 	    	 String aasf=bioMedicalWasteInstance.activityAuthorizationSoughtFor
 	    	  def tmp=aasf.split(",")
 	          ArrayList tmp1=new ArrayList()
 	      	for(int i=0;i<tmp.size();i++)
 	      	{
 	      		tmp1.add(tmp[i])
 	      	}

 	      	for(int i=0;i<tmp1.size();i++)
 	      	{

 	      	}
 			


 		def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
 	    	 
 	    	 if(!bioMedicalWasteInstance) {
 	    	     flash.message = "BioMedicalWaste not found with id ${params.id}"
 	            redirect(action:list)
 	        }
 	        else {
 	        	def userType;
 	            def userIdV;
 	            if(session.indUser)
 	            {
 	            	userType="Industry";
 	            	userIdV = ((session.indUser).toString()).trim();
 	            	
 	            }
 	            else if (session.userMaster)
 	            {
 	            	userType="SPCB";
 	            	userIdV = ((session.userMaster).toString()).trim();
 	            	
 	            }
 	            def activityRecInstance=new ActivityRecord();
 	            activityRecInstance.userType=userType;
 	            activityRecInstance.userID=userIdV;
 	            activityRecInstance.ipAddress=request.getRemoteAddr() 
 	            activityRecInstance.activity = "view"
 	            activityRecInstance.status = "Waste Application "+wmpdOb.applicationId+ " Generate Certificate Click. "
 	            if(activityRecInstance.save()){		   
 	              }
 	            	else{
 	            		activityRecInstance.errors.each {
 	        	    	println it
 	        	  }
 	          }
 	        	return [ bioWasteCategQuantList:bioWasteCategQuantList,bioMedicalWasteInstance : bioMedicalWasteInstance , indRegInstanceGet:indRegInstanceGet , tmp1:tmp1,roleName:roleName ] }
 	    
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
    
    def show = {
    	 try {
    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }
    	     def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )
    	      def appId=bioMedicalWasteInstance.id
    	        def appFor="BMW"
    	        def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
    	        def certInstance=checkCertificate[0]
    	        def certInstanceId
    	        if(certInstance){
    	        certInstanceId=certInstance.id
    	        }
    	    	IndUser indUserInstance=(IndUser)session.indUser
    			def induserQuery=IndUser.get(indUserInstance.id)
    			def indRegInstance=indUserInstance.industryRegMaster
    			def indRegInstanceId=indRegInstance.id
    			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    			def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
    	        if(!bioMedicalWasteInstance) {
    	            flash.message = "BioMedicalWaste not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	        	return [certInstanceId:certInstanceId, bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance , id:bioMedicalWasteInstance.id ] }
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

def showforSpcb = {
    	 try {
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )
    	      	def appId=bioMedicalWasteInstance.id
    	        def appFor="BMW"
    	        def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
    	        def certInstance=checkCertificate[0]
    	        def certInstanceId
    	        if(certInstance){
    	        certInstanceId=certInstance.id
    	        }
    	   def indRegInstance=bioMedicalWasteInstance.indRegMasterObj
    			def indRegInstanceId=indRegInstance.id
    			def indRegInstanceGet=indRegInstance
    	   def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
    	         if(!bioMedicalWasteInstance) {
    	            flash.message = "BioMedicalWaste not found with id ${params.id}"
    	            redirect(action:create)
    	        }
    	        else {
    	        	   render(view:'show',model:[certInstanceId:certInstanceId, bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance , id:bioMedicalWasteInstance.id ])
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
    
    def delete = {
        def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )
        if(bioMedicalWasteInstance) {
            try {
                bioMedicalWasteInstance.delete()
                flash.message = "BioMedicalWaste ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "BioMedicalWaste ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "BioMedicalWaste not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	             redirect(controller:"userMaster",action:"logout")
    	        }
    	    	 def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )
    	        String aasf=bioMedicalWasteInstance.activityAuthorizationSoughtFor
    	        def tmp=aasf.split(",")
    	        ArrayList tmp1=new ArrayList()
    	    	for(int i=0;i<tmp.size();i++)
    	    	{
    	    		tmp1.add(tmp[i])
    	    	}
    	    	 for(int i=0;i<tmp1.size();i++)
    	    	{
    	    	}
    	        def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
    	        IndUser indUserInstance=(IndUser)session.indUser
    			def induserQuery=IndUser.get(indUserInstance.id)
    			def indRegInstance=indUserInstance.industryRegMaster
    	        if(!bioMedicalWasteInstance) {
    	            flash.message = "BioMedicalWaste not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	        	 return [ bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance,tmp1:tmp1]
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

    def update = {
    	 try {
    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )
    	        if(bioMedicalWasteInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(bioMedicalWasteInstance.version > version) {
    	                    bioMedicalWasteInstance.errors.rejectValue("version", "bioMedicalWaste.optimistic.locking.failure", "Another user has updated this BioMedicalWaste while you were editing.")
    	                    render(view:'edit',model:[bioMedicalWasteInstance:bioMedicalWasteInstance])
    	                    return
    	                }
    	            }
    	            bioMedicalWasteInstance.properties = params
    	            if(!bioMedicalWasteInstance.hasErrors() && bioMedicalWasteInstance.save()) {
    	            	def appFor="BMW"
    	            		def industryRegInstanceWaste=indRegInstance
    	            		if(bioMedicalWasteInstance.completionStatus=="Completed"){
    	            		RouteWasteManagement routeWaste=new RouteWasteManagement()
    	            		def routed=routeWaste.routeWasteManagementApp(bioMedicalWasteInstance.id,appFor,industryRegInstanceWaste)
    	            		}
    	            	flash.message = "BioMedicalWaste ${params.id} updated"
    	                redirect(action:show,id:bioMedicalWasteInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[bioMedicalWasteInstance:bioMedicalWasteInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "BioMedicalWaste not found with id ${params.id}"
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
    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }
    	    	def cessReturnInstance = new CessReturn()
    			IndUser indUserInstance=(IndUser)session.indUser
    			def induserQuery=IndUser.get(indUserInstance.id)
    			def indRegInstance=indUserInstance.industryRegMaster
    			def indRegInstanceId=indRegInstance.id
    			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    	    	def bioMedicalWasteInstance = new BioMedicalWaste()
    	        bioMedicalWasteInstance.properties = params
    	        return ['bioMedicalWasteInstance':bioMedicalWasteInstance,indRegInstance:indRegInstance]
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
    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }
    	    	println("P_ARAAAM---------------"+params);
    	    	def indusrtyInstance=IndustryRegMaster.get((params.indRegId).toLong())
    	    	def bioMedicalWasteInstance = new BioMedicalWaste(params)
    	    	bioMedicalWasteInstance.indRegMasterObj=indusrtyInstance
    	    	IndUser indUserInstance=(IndUser)session.indUser
    	    	def indRegInstance=indUserInstance.industryRegMaster
    	    	def dateCheck=params.prevauthDate_value
    	    	def x
    	    	def sqlCurrentDate
    	    	def currentDate=new Date()
    	    	DateCustom dd=new DateCustom()
    	    	sqlCurrentDate=dd.sQLdate(currentDate)
    	    	if(dateCheck)
    	    	{
    	    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    	    	 x= sdfh.parse(dateCheck);
    	    	}
    	    	bioMedicalWasteInstance.nameOfApplicant=params.nameOfApplicant
    	    	bioMedicalWasteInstance.nameOfInstitution=params.nameOfInstitution
    	    	bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	    		bioMedicalWasteInstance.noOfBed=params.noOfBed
    	    		bioMedicalWasteInstance.noOfPatient=params.noOfPatient
    	    	def flag
    	    	if(params['checkboxGeneration']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Generation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxCollection']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Collection"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxReception']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Reception"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxStorage']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Storage"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxTransportation']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Transportation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxTreatment']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Treatment"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxDisposal']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Disposal"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxAnyother']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Anyother"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	bioMedicalWasteInstance.authorizationType=params.authorizationType
    	    	   	if(bioMedicalWasteInstance.authorizationType=="RenewalApplication")
    	    		{
    	    			bioMedicalWasteInstance.previousAuthNo=(params.prevauthNo).toInteger()
    	    			bioMedicalWasteInstance.previousAuthDate=x
    	    		}
    	    		else
    	        	{
    	    		bioMedicalWasteInstance.previousAuthNo=0
    	        	bioMedicalWasteInstance.previousAuthDate=x
    	        	}
    	    	bioMedicalWasteInstance.addrPlaceDisposalOfWaste=params.addrPlaceDisposalOfWaste
    	    	bioMedicalWasteInstance.addrTreatmentFacility=params.addrTreatmentFacility
    	    	bioMedicalWasteInstance.descrip=params.descrip
    	    	bioMedicalWasteInstance.createdBy=indRegInstance.indName
    	    	bioMedicalWasteInstance.modeTrans=params.modeTrans
    	    	bioMedicalWasteInstance.modeTreat=params.modeTreat
    	    	bioMedicalWasteInstance.nameAddressInstitution=params.nameAddressInstitution
    	    	bioMedicalWasteInstance.completionStatus=params.appStatus
    	    	bioMedicalWasteInstance.clarification=false
    	    	bioMedicalWasteInstance.inspection=false
    	    	bioMedicalWasteInstance.updatedBy=""
    	    	bioMedicalWasteInstance.applicationStatus="Inprogress"
    	    	println("AAAAAAAAAAA===="+bioMedicalWasteInstance);
    	    	if(!bioMedicalWasteInstance.hasErrors() && bioMedicalWasteInstance.save()) {
    	    		println("BBBBBBBBB===="+bioMedicalWasteInstance);
    	    		def appFor="BMW"
    	    			def industryRegInstanceWaste=indRegInstance
    	    			if(bioMedicalWasteInstance.completionStatus=="Inprogress"){
    	    				flash.message = "BioMedicalWaste Application No ${bioMedicalWasteInstance.id} is Available for Future modification"
    	    				redirect(action:show,id:bioMedicalWasteInstance.id)
    	    			}
    	    			if(bioMedicalWasteInstance.completionStatus=="Completed"){
    	    				println("INSIDE===="+bioMedicalWasteInstance);
    	    				RouteWasteManagement routeWaste=new RouteWasteManagement()
    	    				def routed=routeWaste.routeWasteManagementApp(bioMedicalWasteInstance.id,appFor,industryRegInstanceWaste)
    	    				println("INSIDE FFFF===="+routed);
    	    				flash.message = "BioMedicalWaste Application No ${bioMedicalWasteInstance.id} is Submitted Successfully"
    	    				def bioId=bioMedicalWasteInstance.id
    	    				def bioIdInstance=BioMedicalWaste.get(bioId)
    	    				
    	    				def applicantName = params.nameOfApplicant
    	    				def instutionName = params.nameOfInstitution
    	    				def nameAddressInstitution = params.nameAddressInstitution
    	    				def authorizationType = params.authorizationType
    	    				def previousAuthNo
    	    				if(params.prevauthNo==null){
    	    					previousAuthNo ="NA"
    	    				}else{
    	    					previousAuthNo = params.prevauthNo
    	    				}
    	    				def previousAuthDate
    	    				if(params.prevauthDate_value==""){
    	    					previousAuthDate ="NA"
    	    				}else{
    	    					previousAuthDate = params.prevauthDate_value
    	    				}
    	    				def addrPlaceDisposalOfWaste = params.addrPlaceDisposalOfWaste
    	    				def addrTreatmentFacility = params.addrTreatmentFacility
    	    				def descrip = params.descrip
    	    				def modeTrans = params.modeTrans
    	    				def modeTreat = params.modeTreat
    	    				def applicationStatus = params.appStatus
    	    				def noOfBed = params.noOfBed.toString()
    	    				def noOfPatient = params.noOfPatient.toString()
    	    				def humanAnatomicalWaste
    	    				if(params.categHAW==""){
    	    					humanAnatomicalWaste ="NA"
    	    				}else{
    	    					humanAnatomicalWaste = params.categHAW
    	    				}
    	    				def animalWaste
    	    				if(params.categAW==""){
    	    					animalWaste ="NA"
    	    				}else{
    	    					animalWaste = params.categAW
    	    				}
    	    				def microbiologyBiotechnologyWaste
    	    				if(params.categMBW==""){
    	    					microbiologyBiotechnologyWaste ="NA"
    	    				}else{
    	    					microbiologyBiotechnologyWaste = params.categMBW
    	    				}
    	    				def wasteSharps
    	    				if(params.categWS==""){
    	    					wasteSharps ="NA"
    	    				}else{
    	    					wasteSharps = params.categWS
    	    				}
    	    				def discardedMedicinesAndCytotoxicdrugs
    	    				if(params.categDMCD==""){
    	    					discardedMedicinesAndCytotoxicdrugs ="NA"
    	    				}else{
    	    					discardedMedicinesAndCytotoxicdrugs = params.categDMCD
    	    				}
    	    				def solidWaste
    	    				if(params.categSW6==""){
    	    					solidWaste ="NA"
    	    				}else{
    	    					solidWaste = params.categSW6
    	    				}
    	    				def solidWasteDisposalGenerated
    	    				if(params.categSW7==""){
    	    					solidWasteDisposalGenerated ="NA"
    	    				}else{
    	    					solidWasteDisposalGenerated = params.categSW7
    	    				}
    	    				def liquidWaste
    	    				if(params.categLW==""){
    	    					liquidWaste ="NA"
    	    				}else{
    	    					liquidWaste = params.categLW
    	    				}
    	    				def incinerationAsh 
    	    				if(params.categIA==""){
    	    					incinerationAsh ="NA"
    	    				}else{
    	    					incinerationAsh = params.categIA
    	    				}
    	    				def chemicalWaste
    	    				if(params.categCW==""){
    	    					chemicalWaste ="NA"
    	    				}else{
    	    					chemicalWaste = params.categCW
    	    				}
    	    				def humanAnatomicalWasteMethod
    	    				if(params.methodHAW==""){
    	    					humanAnatomicalWasteMethod ="NA"
    	    				}else{
    	    					humanAnatomicalWasteMethod = params.methodHAW
    	    				}
    	    				def animalWasteMethod
    	    				if(params.methodAW==""){
    	    					animalWasteMethod ="NA"
    	    				}else{
    	    					animalWasteMethod = params.methodAW
    	    				}
    	    				def microbiologyBiotechnologyWasteMethod
    	    				if(params.methodMBW==""){
    	    					microbiologyBiotechnologyWasteMethod ="NA"
    	    				}else{
    	    					microbiologyBiotechnologyWasteMethod = params.methodMBW
    	    				}
    	    				def wasteSharpsMethod
    	    				if(params.methodWS==""){
    	    					wasteSharpsMethod ="NA"
    	    				}else{
    	    					wasteSharpsMethod = params.methodWS
    	    				}
    	    				def discardedMedicinesAndCytotoxicdrugsMethod
    	    				if(params.methodDMCD==""){
    	    					discardedMedicinesAndCytotoxicdrugsMethod ="NA"
    	    				}else{
    	    					discardedMedicinesAndCytotoxicdrugsMethod = params.methodDMCD
    	    				}
    	    				def solidWasteMethod
    	    				if(params.methodSW6==""){
    	    					solidWasteMethod ="NA"
    	    				}else{
    	    					solidWasteMethod = params.methodSW6
    	    				}
    	    				def solidWasteDisposalGeneratedMethod
    	    				if(params.methodSW7==""){
    	    					solidWasteDisposalGeneratedMethod ="NA"
    	    				}else{
    	    					solidWasteDisposalGeneratedMethod = params.methodSW7
    	    				}
    	    				def liquidWasteMethod
    	    				if(params.methodLW==""){
    	    					liquidWasteMethod ="NA"
    	    				}else{
    	    					liquidWasteMethod = params.methodLW
    	    				}
    	    				def incinerationAshMethod 
    	    				if(params.methodIA==""){
    	    					incinerationAshMethod ="NA"
    	    				}else{
    	    					incinerationAshMethod = params.methodIA
    	    				}
    	    				def chemicalWasteMethod 
    	    				if(params.methodCW==""){
    	    					chemicalWasteMethod ="NA"
    	    				}else{
    	    					chemicalWasteMethod = params.methodCW
    	    				}
    	    				bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	    	def flag1
    	    	if(params['checkboxGeneration']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Generation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxCollection']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Collection"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxReception']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Reception"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxStorage']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Storage"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxTransportation']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Transportation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxTreatment']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Treatment"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxDisposal']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Disposal"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxAnyother']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Anyother"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	def activityAuthorizationSoughtFor = bioMedicalWasteInstance.activityAuthorizationSoughtFor
    	    				BmwPdfFile  pdf = new BmwPdfFile()
    	    				File certFile1
    	    				certFile1 = pdf.bmwPdfFunction(applicantName, instutionName, authorizationType, nameAddressInstitution, addrTreatmentFacility, addrPlaceDisposalOfWaste, modeTrans, modeTreat, descrip, humanAnatomicalWaste, animalWaste, microbiologyBiotechnologyWaste, wasteSharps, discardedMedicinesAndCytotoxicdrugs, solidWaste, solidWasteDisposalGenerated, liquidWaste, incinerationAsh, chemicalWaste,humanAnatomicalWasteMethod, animalWasteMethod, microbiologyBiotechnologyWasteMethod, wasteSharpsMethod, discardedMedicinesAndCytotoxicdrugsMethod, solidWasteMethod, solidWasteDisposalGeneratedMethod, liquidWasteMethod, incinerationAshMethod, chemicalWasteMethod, previousAuthNo, previousAuthDate, activityAuthorizationSoughtFor,noOfBed,noOfPatient)
    	    				byte[] b = new byte[(int) certFile1.length()];
    	    				FileInputStream fileInputStream = new FileInputStream(certFile1);
    	    				fileInputStream.read(b);
    	    				def industryReg1=IndustryRegMaster.get((params.indRegId).toLong())
    	    				WasteManagementFile file1=new WasteManagementFile()
    	    				def fileLength=certFile1.length()
    	    				file1.applicationId = bioId
    	    				file1.size = fileLength / 1024  //f.getSize() 
    	    				file1.extension ="pdf"//extractExtension( f )
    	    				file1.data=b;
    	    				file1.name="BmwForm.pdf"
    	    				file1.description="BMW Application Form"
    	    				file1.createdBy= session.indUser
    	    				file1.updatedBy=session.indUser
    	    				file1.typeOfFile="BmwForm"
    	    				file1.applicationFor="BMW"
    	    				file1.indreg=industryReg1
    	    				if(file1.save()) {
    	    				}
    	    				else{
    	    				}				
    	    				redirect(action:show,id:bioMedicalWasteInstance.id)
    	    			}
    	    			
    	    			
    	    			
    	    	 }
    	        else {
    	        	
    	        	bioMedicalWasteInstance.errors.each {
					        println it
						 }
    	        	def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
    	            render(view:'create',model:[bioMedicalWasteInstance:bioMedicalWasteInstance,bioWasteCategQuantList:bioWasteCategQuantList])
    	        }
    	    	if(params['checkboxHAW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Human Anatomical Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categHAW).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodHAW)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    	    		if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxAW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Animal Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categAW).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodAW)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxMBW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Microbiology & Biotechnology Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categMBW).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodMBW)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxWS']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Waste sharps"
    	    		bioWasteCategQuantInstance.quantity=(params.categWS).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodWS)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxDMCD']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Discarded Medicines and Cytotoxic drugs"
    	    		bioWasteCategQuantInstance.quantity=(params.categDMCD).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodDMCD)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxSW6']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Solid Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categSW6).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodSW6)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxSW7']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Solid Waste disposal generated"
    	    		bioWasteCategQuantInstance.quantity=(params.categSW7).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodSW7)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxLW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Liquid Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categLW).toInteger()
    	    	    bioWasteCategQuantInstance.method=(params.methodLW)
    	    	    bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxIA']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Incineration Ash"
    	    		bioWasteCategQuantInstance.quantity=(params.categIA).toInteger()
    	    		    		bioWasteCategQuantInstance.method=(params.methodIA)
    	    		    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	     	if(params['checkboxCW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Chemical Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categCW).toInteger()
    	    		bioWasteCategQuantInstance.method=(params.methodCW)
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=""
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
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
    
    def saveEdit={
    	 try {
    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }
    	    	println("PARAMS IN save----------"+params);
    	    	def indusrtyInstance=IndustryRegMaster.get((params.indRegId).toLong())
    	    	IndUser indUserInstance=(IndUser)session.indUser
    	    	def indRegInstance=indUserInstance.industryRegMaster
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get((params.bioMedId).toLong())
    	    	bioMedicalWasteInstance.indRegMasterObj=indusrtyInstance
    	    	bioMedicalWasteInstance.authorizationType=params.authorizationType
    	    	if(bioMedicalWasteInstance.authorizationType=="RenewalApplication")
    	    	{
    	    		def dateCheck=params.prevauthDate_value
    	        	def x
    	        	def sqlCurrentDate
    	        	def currentDate=new Date()
    	        	DateCustom dd=new DateCustom()
    		    	if(dateCheck)
    		    	{
    		    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    		    	x= sdfh.parse(dateCheck);
    		    	bioMedicalWasteInstance.previousAuthDate=x
    		    	}
    	    	}
    	    	if(params.authorizationType=="RenewalApplication")
    	    	{
    	    	 	bioMedicalWasteInstance.previousAuthNo=(params.prevauthNo).toInteger()
    			}
    	    	bioMedicalWasteInstance.nameOfApplicant=params.nameOfApplicant
    	    	bioMedicalWasteInstance.nameOfInstitution=params.nameOfInstitution
    	    	bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	    	def flag
    	    	if(params['checkboxGeneration']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Generation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxCollection']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Collection"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxReception']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Reception"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxStorage']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Storage"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxTransportation']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Transportation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxTreatment']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Treatment"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxDisposal']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Disposal"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	if(params['checkboxAnyother']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Anyother"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag=1
    	        }
    	    	bioMedicalWasteInstance.addrPlaceDisposalOfWaste=params.addrPlaceDisposalOfWaste
    	    	bioMedicalWasteInstance.addrTreatmentFacility=params.addrTreatmentFacility
    	    	bioMedicalWasteInstance.descrip=params.descrip
    	    	bioMedicalWasteInstance.createdBy=indRegInstance.indName
    	    	bioMedicalWasteInstance.updatedBy=indRegInstance.indName
    	    	bioMedicalWasteInstance.modeTrans=params.modeTrans
    	    	bioMedicalWasteInstance.modeTreat=params.modeTreat
    	    	bioMedicalWasteInstance.nameAddressInstitution=params.nameAddressInstitution
    	    	bioMedicalWasteInstance.completionStatus=params.appStatus
    	    	println("VINEEETTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+bioMedicalWasteInstance);
    	    	if(!bioMedicalWasteInstance.hasErrors() && bioMedicalWasteInstance.save()) {
    	    		println("INSIDEEEEEEEEEEEEEEEEEEEEEEEE"+bioMedicalWasteInstance);
    	    			def appFor="BMW"
    	    			def industryRegInstanceWaste=indRegInstance
    	    			if(bioMedicalWasteInstance.completionStatus=="Inprogress"){
    	    				flash.message = "BioMedicalWaste Application No ${bioMedicalWasteInstance.id} is Available for Future modification"
    	    				redirect(action:show,id:bioMedicalWasteInstance.id)
    	    			}
    	    			if(bioMedicalWasteInstance.completionStatus=="Completed"){
    	    				RouteWasteManagement routeWaste=new RouteWasteManagement()
    	    				def routed=routeWaste.routeWasteManagementApp(bioMedicalWasteInstance.id,appFor,industryRegInstanceWaste)
    	    				flash.message = "BioMedicalWaste Application No ${bioMedicalWasteInstance.id} is Submitted Successfully"
    	    				def bioId=bioMedicalWasteInstance.id
    	    				def bioIdInstance=BioMedicalWaste.get(bioId)
    	    				def applicantName = params.nameOfApplicant
    	    				def instutionName = params.nameOfInstitution
    	    				def nameAddressInstitution = params.nameAddressInstitution
    	    				def authorizationType = params.authorizationType
    	    				def noOfBed = params.noOfBed.toString()
    	    				def noOfPatient = params.noOfPatient.toString()
    	    				def previousAuthNo
    	    				if(params.prevauthNo==null){
    	    					previousAuthNo ="NA"
    	    				}else{
    	    					previousAuthNo = params.prevauthNo
    	    				}
    	    				def previousAuthDate
    	    				if(params.prevauthDate_value==""){
    	    					previousAuthDate ="NA"
    	    				}else{
    	    					previousAuthDate = params.prevauthDate_value
    	    				}
    	    				def addrPlaceDisposalOfWaste = params.addrPlaceDisposalOfWaste
    	    				def addrTreatmentFacility = params.addrTreatmentFacility
    	    				def descrip = params.descrip
    	    				def modeTrans = params.modeTrans
    	    				def modeTreat = params.modeTreat
    	    				def applicationStatus = params.appStatus
    	    				def humanAnatomicalWaste
    	    				if(params.categHAW==""){
    	    					humanAnatomicalWaste ="NA"
    	    				}else{
    	    					humanAnatomicalWaste = params.categHAW
    	    				}
    	    				def animalWaste
    	    				if(params.categAW==""){
    	    					animalWaste ="NA"
    	    				}else{
    	    					animalWaste = params.categAW
    	    				}
    	    				def microbiologyBiotechnologyWaste
    	    				if(params.categMBW==""){
    	    					microbiologyBiotechnologyWaste ="NA"
    	    				}else{
    	    					microbiologyBiotechnologyWaste = params.categMBW
    	    				}
    	    				def wasteSharps
    	    				if(params.categWS==""){
    	    					wasteSharps ="NA"
    	    				}else{
    	    					wasteSharps = params.categWS
    	    				}
    	    				def discardedMedicinesAndCytotoxicdrugs
    	    				if(params.categDMCD==""){
    	    					discardedMedicinesAndCytotoxicdrugs ="NA"
    	    				}else{
    	    					discardedMedicinesAndCytotoxicdrugs = params.categDMCD
    	    				}
    	    				def solidWaste
    	    				if(params.categSW6==""){
    	    					solidWaste ="NA"
    	    				}else{
    	    					solidWaste = params.categSW6
    	    				}
    	    				
    	    				def solidWasteDisposalGenerated
    	    				if(params.categSW7==""){
    	    					solidWasteDisposalGenerated ="NA"
    	    				}else{
    	    					solidWasteDisposalGenerated = params.categSW7
    	    				}
    	    				
    	    				def liquidWaste
    	    				if(params.categLW==""){
    	    					liquidWaste ="NA"
    	    				}else{
    	    					liquidWaste = params.categLW
    	    				}
    	    				
    	    				def incinerationAsh 
    	    				if(params.categIA==""){
    	    					incinerationAsh ="NA"
    	    				}else{
    	    					incinerationAsh = params.categIA
    	    				}
    	    				
    	    				def chemicalWaste = (params.categCW)
    	    				if(params.categCW==""){
    	    					chemicalWaste ="NA"
    	    				}else{
    	    					chemicalWaste = params.categCW
    	    				}
    	    				
    	    				def humanAnatomicalWasteMethod
    	    				if(params.methodHAW==""){
    	    					humanAnatomicalWasteMethod ="NA"
    	    				}else{
    	    					humanAnatomicalWasteMethod = params.methodHAW
    	    				}
    	    				
    	    				def animalWasteMethod
    	    				if(params.methodAW==""){
    	    					animalWasteMethod ="NA"
    	    				}else{
    	    					animalWasteMethod = params.methodAW
    	    				}
    	    				
    	    				def microbiologyBiotechnologyWasteMethod
    	    				if(params.methodMBW==""){
    	    					microbiologyBiotechnologyWasteMethod ="NA"
    	    				}else{
    	    					microbiologyBiotechnologyWasteMethod = params.methodMBW
    	    				}
    	    				
    	    				def wasteSharpsMethod
    	    				if(params.methodWS==""){
    	    					wasteSharpsMethod ="NA"
    	    				}else{
    	    					wasteSharpsMethod = params.methodWS
    	    				}
    	    			
    	    				def discardedMedicinesAndCytotoxicdrugsMethod
    	    				if(params.methodDMCD==""){
    	    					discardedMedicinesAndCytotoxicdrugsMethod ="NA"
    	    				}else{
    	    					discardedMedicinesAndCytotoxicdrugsMethod = params.methodDMCD
    	    				}
    	    				
    	    				def solidWasteMethod
    	    				if(params.methodSW6==""){
    	    					solidWasteMethod ="NA"
    	    				}else{
    	    					solidWasteMethod = params.methodSW6
    	    				}
    	    				
    	    				def solidWasteDisposalGeneratedMethod
    	    				if(params.methodSW7==""){
    	    					solidWasteDisposalGeneratedMethod ="NA"
    	    				}else{
    	    					solidWasteDisposalGeneratedMethod = params.methodSW7
    	    				}
    	    				
    	    				def liquidWasteMethod
    	    				if(params.methodLW==""){
    	    					liquidWasteMethod ="NA"
    	    				}else{
    	    					liquidWasteMethod = params.methodLW
    	    				}
    	    				
    	    				def incinerationAshMethod 
    	    				if(params.methodIA==""){
    	    					incinerationAshMethod ="NA"
    	    				}else{
    	    					incinerationAshMethod = params.methodIA
    	    				}
    	    				
    	    				def chemicalWasteMethod 
    	    				if(params.methodCW==""){
    	    					chemicalWasteMethod ="NA"
    	    				}else{
    	    					chemicalWasteMethod = params.methodCW
    	    				}
    	    	
    	    				bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	    	def flag1
    	    	if(params['checkboxGeneration']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Generation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxCollection']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Collection"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxReception']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Reception"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxStorage']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Storage"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxTransportation']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Transportation"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxTreatment']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Treatment"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxDisposal']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Disposal"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	if(params['checkboxAnyother']=="on")
    	    	{
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor+="Anyother"
    	    			bioMedicalWasteInstance.activityAuthorizationSoughtFor+=","
    	    				flag1=1
    	        }
    	    	
    	    	def activityAuthorizationSoughtFor = bioMedicalWasteInstance.activityAuthorizationSoughtFor
    	    				BmwPdfFile  pdf = new BmwPdfFile()
    	    				File certFile1
    	    				certFile1 = pdf.bmwPdfFunction(applicantName, instutionName, authorizationType, nameAddressInstitution, addrTreatmentFacility, addrPlaceDisposalOfWaste, modeTrans, modeTreat, descrip, humanAnatomicalWaste, animalWaste, microbiologyBiotechnologyWaste, wasteSharps, discardedMedicinesAndCytotoxicdrugs, solidWaste, solidWasteDisposalGenerated, liquidWaste, incinerationAsh, chemicalWaste,humanAnatomicalWasteMethod, animalWasteMethod, microbiologyBiotechnologyWasteMethod, wasteSharpsMethod, discardedMedicinesAndCytotoxicdrugsMethod, solidWasteMethod, solidWasteDisposalGeneratedMethod, liquidWasteMethod, incinerationAshMethod, chemicalWasteMethod, previousAuthNo, previousAuthDate, activityAuthorizationSoughtFor,noOfBed,noOfPatient)
    	    				byte[] b = new byte[(int) certFile1.length()];
    	    				
    	    				FileInputStream fileInputStream = new FileInputStream(certFile1);
    	    				fileInputStream.read(b);
    	    				
    	    				def industryReg1=IndustryRegMaster.get((params.indRegId).toLong())
    	    				WasteManagementFile file1=new WasteManagementFile()
    	    				def fileLength=certFile1.length()
    	    				file1.applicationId = bioId
    	    				file1.size = fileLength / 1024  //f.getSize() 
    	    				file1.extension ="pdf"//extractExtension( f )
    	    				file1.data=b;
    	    				file1.name="BmwForm.pdf"
    	    				file1.description="BMW Application Form"
    	    				file1.createdBy= session.indUser
    	    				file1.updatedBy=session.indUser
    	    				file1.typeOfFile="BmwForm"
    	    				file1.applicationFor="BMW"
    	    				file1.indreg=industryReg1
    	    				if(file1.save()) {
    	    				}
    	    				else{
    	    				}				
    	    				redirect(action:show,id:bioMedicalWasteInstance.id)
    	    			}
    	    	 }else
    	    	 {
    	    		 bioMedicalWasteInstance.errors.each {
					        println it
						   }
    	    		 
    	    		 render(view:'create',model:[bioMedicalWasteInstance:bioMedicalWasteInstance])
    	    	 }
    	    	def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
    	    	if(bioWasteCategQuantList){
    				for(int i=0;i<bioWasteCategQuantList.size();i++){
    					bioWasteCategQuantList[i].delete()
    				}
    			}
    	    	if(params['checkboxHAW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Human Anatomical Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categHAW).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    	    		if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxAW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Animal Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categAW).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxMBW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Microbiology & Biotechnology Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categMBW).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxWS']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Waste sharps"
    	    		bioWasteCategQuantInstance.quantity=(params.categWS).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxDMCD']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Discarded Medicines and Cytotoxic drugs"
    	    		bioWasteCategQuantInstance.quantity=(params.categDMCD).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxSW6']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Solid Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categSW6).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxSW7']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Solid Waste disposal generated"
    	    		bioWasteCategQuantInstance.quantity=(params.categSW7).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxLW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Liquid Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categLW).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	    	if(params['checkboxIA']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Incineration Ash"
    	    		bioWasteCategQuantInstance.quantity=(params.categIA).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
    	        }
    	     	if(params['checkboxCW']=="on")
    	    	{
    	    		def bioWasteCategQuantInstance=new BioWasteCategQuant()
    	    		bioWasteCategQuantInstance.bioMedicalWasteObj=bioMedicalWasteInstance
    	    		bioWasteCategQuantInstance.category="Chemical Waste"
    	    		bioWasteCategQuantInstance.quantity=(params.categCW).toInteger()
    	    		bioWasteCategQuantInstance.createdBy=indRegInstance.indName
    	    		bioWasteCategQuantInstance.updatedBy=indRegInstance.indName
    		    	if(bioWasteCategQuantInstance.save()){
    		    	}else{
    		    	}
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
    
def printBioMedicalWaste={
    	 try {
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id).toLong() )
    			def industryRegId=bioMedicalWasteInstance.indRegMasterObj
    			def bioDetailList=BioMedicalWaste.findAllByid(bioMedicalWasteInstance.id)
    			def bioWasteCategQuantList=BioWasteCategQuant.findAllBybioMedicalWasteObj(bioMedicalWasteInstance)
    	    	 String aasf=bioMedicalWasteInstance.activityAuthorizationSoughtFor
    	   	    def tmp=aasf.split(",")
    	         ArrayList tmp1=new ArrayList()
    	     	for(int i=0;i<tmp.size();i++)
    	     	{
    	     		tmp1.add(tmp[i])
    	     	}
    	    	if(!bioMedicalWasteInstance) {
    				flash.message = "BioMedical Waste not found with id ${params.id}"
    				redirect(action:show)
    			}
    			else { 
    					return [ bioMedicalWasteInstance : bioMedicalWasteInstance ,industryRegId:industryRegId,bioDetailList:bioDetailList , bioWasteCategQuantList:bioWasteCategQuantList,tmp1:tmp1] 
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
 
    def popBioMedActivityGenDetailsAdd = {
    	 try {
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id).toLong() )
    			def bioMedWasteGenDetailsList = BioMedWasteGenDetails.findAllBybioId(bioMedicalWasteInstance)
    			return [appDetId:params.id,bioMedWasteGenDetailsList:bioMedWasteGenDetailsList]
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

	def popHazardActivityGenDetailsView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    			def hazarWasteGenDetailsList = HazardousWasteGenDetails.findAllByApplication(app)
    			return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
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
    
    def printBioMedicalWaste1={
    	 try {
         	def bioMedicalWasteInstance = BioMedicalWaste.get( (params.id).toLong() )
     		def industryRegId=bioMedicalWasteInstance.indRegMasterObj
     		def bioDetailList=BioMedicalWaste.findAllByid(bioMedicalWasteInstance.id)
     		def bioWasteCategQuantList=BioWasteCategQuant.findAllBybioMedicalWasteObj(bioMedicalWasteInstance)
         	 String aasf=bioMedicalWasteInstance.activityAuthorizationSoughtFor
        	    def tmp=aasf.split(",")
              ArrayList tmp1=new ArrayList()
          	for(int i=0;i<tmp.size();i++)
          	{
          		tmp1.add(tmp[i])
          	}
         	if(!bioMedicalWasteInstance) {
     			flash.message = "BioMedical Waste not found with id ${params.id}"
     			redirect(action:show)
     		}
     			else { 
     				render(view:'printBioMedicalWaste',model:[ bioMedicalWasteInstance : bioMedicalWasteInstance ,industryRegId:industryRegId,bioDetailList:bioDetailList , bioWasteCategQuantList:bioWasteCategQuantList,tmp1:tmp1] )
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

    def viewBmwPdf={
    	 try {
         		def application1
         		def user = session.indUser.toString();
         		println("-----session User-----"+user)
         		if(!session.indUser){
         			user=session.userMaster.toString();
         			println("-----session User-----"+user)
         		}
         		BmwFormFormat bmwformat= new BmwFormFormat()
         		application1 = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='BmwForm' order by crf.id asc",[(params.appliLoc.toLong())])
         		println("---application1----"+application1.size())
         		if(application1.size()>0){
         			application1[0].delete()
         			bmwformat.getBmwPdf(params.appliLoc.toLong(),user)
         	    }
    			def application2 = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='BmwForm' order by crf.id desc",[(params.appliLoc.toLong())])
    			if(application2.size()>0){
    				def application=application2[0]
    				def applicationInstance = application
    				response.setContentType( "application-xdownload")
    				response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
    				response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
    			}
    			else {
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
    
    
    
    
    
    
    
//////////?????????? New BMW Format Start
	
	
	def createNewFormat = {
    		 try {
    			    
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
    			    activityRecInstance.activity = "save"
    		        activityRecInstance.status = "Bio-Medical Waste Apply Application Click"
    		        if(activityRecInstance.save()){		   
    		          }
    		        	else{
    		        		activityRecInstance.errors.each {
    				    	println it
    				   }
    			      }

     	    	def industryId = session.indUser
     	    	if(industryId==null || industryId=="")
     	        {
     	              redirect(controller:"userMaster",action:"logout")
     	        }

     			IndUser indUserInstance=(IndUser)session.indUser
     	    	def wasteManagementpendingDetails= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wmp where wmp.indRegInstance=? and wmp.applicationStatus='pending' and applicationFor='BMW'",[indUserInstance.industryRegMaster])
    	    	
     			def induserQuery=IndUser.get(indUserInstance.id)
     		
     			def indRegInstance=indUserInstance.industryRegMaster
     			def indRegInstanceId=indRegInstance.id
     			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
     	    	//added by sharvan start from here
     	    	def hcfAddressFacilityBmwMaster= HcfAddressFacilityBmwMaster.find("from HcfAddressFacilityBmwMaster")

     	    	//added by sharvan end here
     			def bioMedicalWasteInstance = new BioMedicalWaste()


     	    			
     	    			//added by sharvan to get the previous authorization details
     	    			def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser.id=? order by to_date(Issued_date, 'dd/mm/yyyy')",[indRegInstanceId.toLong()])
     	    			def approveApplicationList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wms where wms.indRegInstance=? and applicationStatus='approved'",[indRegInstance])
     	    			// added by sharvan end here
     	    			
     	    			/////////////// If BMW Application Already applied //////////////////////////////
     	    			//added by sharvan start from here
     	    			def bioMedicalWasteInstanceOld1 = BioMedicalWaste.find("from BioMedicalWaste abc where abc.industryRegMasterObj=? and (applicationStatus='approved' or applicationStatus='rejected' or applicationStatus='pending') order by  applicationStatus ",[indRegInstanceGet])

     	    			//added by sharvan end here
     	    			def bioMedicalWasteInstanceOld = BioMedicalWaste.find("from BioMedicalWaste abc where abc.industryRegMasterObj=? and abc.completionStatus='Completed' order by abc.id desc ",[indRegInstanceGet])

     	    			//added by sharvan start from here
     	    			if(bioMedicalWasteInstanceOld1){

     	               	def bioWasteCategQuantList = BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstanceOld1)

     	               	   String aasf=bioMedicalWasteInstanceOld.activityAuthorizationSoughtFor
     	               	  
     	               	 
     	               	   def tmp=aasf.split(",")
     	                    ArrayList tmp1=new ArrayList()
     	                	for(int i=0;i<tmp.size();i++)
     	                	{
     	                		tmp1.add(tmp[i])
     	                	}
     	               	
     	       		    bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet
     	              		bioMedicalWasteInstance.nameOfApplicant=""
     	               	bioMedicalWasteInstance.nameOfInstitution=""
     	               		bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
     	               			bioMedicalWasteInstance.previousAuthNo=""
     	               				bioMedicalWasteInstance.previousAuthDate=new Date()
     	               				
     	               									
     	   							bioMedicalWasteInstance.dateCreated= new Date()
     	   								bioMedicalWasteInstance.createdBy=bioMedicalWasteInstanceOld1.createdBy
     	   									bioMedicalWasteInstance.lastUpdated=new Date()
     	   										bioMedicalWasteInstance.updatedBy= bioMedicalWasteInstanceOld1.updatedBy
     	   											bioMedicalWasteInstance.clarification=false
     	   												bioMedicalWasteInstance.inspection=false
     	   												bioMedicalWasteInstance.prevExpDate=new Date()
     	               	
     	               	//new code added from here by sharvan
     	               	bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet
     	    		bioMedicalWasteInstance.nameOfApplicant=""
     	    		bioMedicalWasteInstance.nameOfInstitution=""
     	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
     	    		bioMedicalWasteInstance.previousAuthNo=""
     	    		bioMedicalWasteInstance.previousAuthDate=new Date()


     	    		bioMedicalWasteInstance.completionStatus=""
     	    		bioMedicalWasteInstance.dateCreated= new Date()
     	    		bioMedicalWasteInstance.createdBy=bioMedicalWasteInstanceOld1.createdBy
     	    		bioMedicalWasteInstance.lastUpdated=new Date()
     	    		bioMedicalWasteInstance.updatedBy= ""
     	    		bioMedicalWasteInstance.applicationStatus=""
     	    		bioMedicalWasteInstance.clarification=false
     	    		bioMedicalWasteInstance.inspection=false
     	    		bioMedicalWasteInstance.prevExpDate=new Date()
     	    		bioMedicalWasteInstance.properties = params
     	    		bioMedicalWasteInstance.condImposedRenew = ""
     	    		             ///////////////// Added By Ankit Sharma ////////
     	    					 bioMedicalWasteInstance.authorisationAppliedFor = ""
     	    					 bioMedicalWasteInstance.hcfType = ""
     	    					 bioMedicalWasteInstance.hcfTypeMenu = ""
     	    					 bioMedicalWasteInstance.bmwfacility = ""
     	    					 bioMedicalWasteInstance.bmwstatus = ""
     	    					 bioMedicalWasteInstance.wastelocationaddress = ""
     	    		             bioMedicalWasteInstance.wastedisposalplace = ""
     	    					 bioMedicalWasteInstance.outpatientsFacility = ""
     	    					 bioMedicalWasteInstance.inpatientsFacility = ""
     	    					 bioMedicalWasteInstance.noofbeds = ""
     	    					 bioMedicalWasteInstance.other1 = ""
     	    					 bioMedicalWasteInstance.other2 = ""
     	    					 bioMedicalWasteInstance.patientspermonth = ""
     	    					 bioMedicalWasteInstance.destroyer = ""
     	    					 bioMedicalWasteInstance.bmwrules1 = ""
     	    					 bioMedicalWasteInstance.NoofHCF = ""
     	    					 bioMedicalWasteInstance.Jurisdictionalarea = ""
     	    					 bioMedicalWasteInstance.authorisationDay = ""
     	    					 bioMedicalWasteInstance.authorisationMonth = ""
     	    					 bioMedicalWasteInstance.shredders = ""
     	    					 bioMedicalWasteInstance.detailapc = ""
     	    					 bioMedicalWasteInstance.detailetp = ""
     	    					 bioMedicalWasteInstance.quantityperDay = ""
     	    					 bioMedicalWasteInstance.quantityperMonth = ""
     	    				     bioMedicalWasteInstance.quantityperDay1 = ""
     	    					 bioMedicalWasteInstance.quantityperMonth1 = ""
     	    					 bioMedicalWasteInstance.authapply = ""
     	    				     bioMedicalWasteInstance.hcfTypeMenu = ""
     	    					 bioMedicalWasteInstance.anatomicalwaste = ""
     	    					 bioMedicalWasteInstance.animalwaste = ""
     	    					 bioMedicalWasteInstance.biowaste = ""
     	    					 bioMedicalWasteInstance.wastesharp = ""
     	    					 bioMedicalWasteInstance.discardedwaste = ""
     	    					 bioMedicalWasteInstance.soiledwaste = ""
     	    					 bioMedicalWasteInstance.solidwaste = ""
     	    					 bioMedicalWasteInstance.liquidwaste = ""
     	    					 bioMedicalWasteInstance.ash = ""
     	    					 bioMedicalWasteInstance.chemicalwaste = ""
     	    					 
     	    					 bioMedicalWasteInstance.total1 = ""
     	    					 
     	    					bioMedicalWasteInstance.paymentDeviation = ""
     	    					bioMedicalWasteInstance.remittedFees = ""
     	    					 
     	    					// added by sharvan start from here for new rules
     	    					
     	    					//addded by sharvan for new changes start from here
     	    					
     	    						bioMedicalWasteInstance.statusCteCto=""
     	    						bioMedicalWasteInstance.latitude=""
     	    						bioMedicalWasteInstance.longtitude=""
     	    						bioMedicalWasteInstance.detailsOfDirections=""
     	    						bioMedicalWasteInstance.noOfNonBeds=""
     	    						bioMedicalWasteInstance.noOfNonBeds1=""
     	    						bioMedicalWasteInstance.noOfInOutPatients=""
     	    						bioMedicalWasteInstance.colorCodedBags=""
     	    						bioMedicalWasteInstance.noOfBedsCbmwtf=""
     	    						bioMedicalWasteInstance.treatmentAndDisposal=""
     	    						bioMedicalWasteInstance.qtyOfBmwTreated=""
     	    						bioMedicalWasteInstance.contingencyPlan=""
     	    						bioMedicalWasteInstance.detailsOfTraining=""
     	    						bioMedicalWasteInstance.incinrators=""
     	    						bioMedicalWasteInstance.incinratorsType=""
     	    						bioMedicalWasteInstance.plasmaPyrolysis=""
     	    						bioMedicalWasteInstance.plasmaPyrolysisType=""
     	    						bioMedicalWasteInstance.autoclaves=""
     	    						bioMedicalWasteInstance.autoclavesType=""
     	    						bioMedicalWasteInstance.microwave=""
     	    						bioMedicalWasteInstance.microwaveType=""
     	    						bioMedicalWasteInstance.hydroclave=""
     	    						bioMedicalWasteInstance.hydroclaveType=""
     	    						bioMedicalWasteInstance.shredders=""
     	    						bioMedicalWasteInstance.shreddersType=""
     	    						bioMedicalWasteInstance.needleTipCutter=""
     	    						bioMedicalWasteInstance.needleTipCutterType=""
     	    						bioMedicalWasteInstance.sharpEncapsulation=""
     	    						bioMedicalWasteInstance.sharpEncapsulationType=""
     	    						bioMedicalWasteInstance.deepBurial=""
     	    						bioMedicalWasteInstance.deepBurialType=""
     	    						bioMedicalWasteInstance.chemDisinfection=""
     	    						bioMedicalWasteInstance.chemDisinfectionType=""
     	    						bioMedicalWasteInstance.anyOtherTretmntEquip=""
     	    						bioMedicalWasteInstance.anyOtherTretmntEquipType=""
     	    						bioMedicalWasteInstance.chemicalSolidWaste=""
     	    						bioMedicalWasteInstance.chemicalLiquidWaste=""
     	    						bioMedicalWasteInstance.discardedLinen=""
     	    						bioMedicalWasteInstance.otherClininLabWaste=""
     	    						bioMedicalWasteInstance.contaminatedwaste=""
     	    						bioMedicalWasteInstance.wasteSharps=""
     	    						bioMedicalWasteInstance.glassWare=""
     	    						bioMedicalWasteInstance.metallicBodyImplants=""
     	    					
     	    					// added by sharvan for new changes end here
     	    					
     	    					
     	    					// adeded by sharvan end here 
     	    					
     	    				   bioMedicalWasteInstance.properties = params
     	    		            //////////////////////////////////////////////////	
     	    				   if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors()){
     	   		            	
     	   		            } 
     	   		            else{

     	   		            }

     	    		            def id=bioMedicalWasteInstance.id
     	               	//new code end here 
     	               	
     	               	
     	               			return ['bioMedicalWasteInstance':bioMedicalWasteInstanceOld1,indRegInstance:indRegInstance,hcfAddressFacilityBmwMaster:hcfAddressFacilityBmwMaster, tmp1:tmp1, id:id, previousAuthList:previousAuthList,approveApplicationList:approveApplicationList]
     	               }//added by sharvan end here
     	    			else {
     	    				if(bioMedicalWasteInstanceOld){

     	            	def bioWasteCategQuantList = BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstanceOld)

     	            	String aasf=bioMedicalWasteInstanceOld.activityAuthorizationSoughtFor
     	            	  
     	            	 
     	            	   def tmp=aasf.split(",")
     	                 ArrayList tmp1=new ArrayList()
     	             	for(int i=0;i<tmp.size();i++)
     	             	{
     	             		tmp1.add(tmp[i])
     	             	}

     	    		    bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet
     	           		bioMedicalWasteInstance.nameOfApplicant=bioMedicalWasteInstanceOld.nameOfApplicant
     	            	bioMedicalWasteInstance.nameOfInstitution=bioMedicalWasteInstanceOld.nameOfInstitution
     	            		bioMedicalWasteInstance.activityAuthorizationSoughtFor=bioMedicalWasteInstanceOld.activityAuthorizationSoughtFor
     	            			bioMedicalWasteInstance.previousAuthNo=bioMedicalWasteInstanceOld.previousAuthNo
     	            				bioMedicalWasteInstance.previousAuthDate=new Date()
     	            				
     	            									
     								bioMedicalWasteInstance.dateCreated= new Date()
     									bioMedicalWasteInstance.createdBy=bioMedicalWasteInstanceOld.createdBy
     										bioMedicalWasteInstance.lastUpdated=new Date()
     											bioMedicalWasteInstance.updatedBy= bioMedicalWasteInstanceOld.updatedBy
     												bioMedicalWasteInstance.clarification=false
     													bioMedicalWasteInstance.inspection=false
     													bioMedicalWasteInstance.prevExpDate=new Date()
     	    				}
     	            
     	    		bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet

     	    		bioMedicalWasteInstance.nameOfApplicant=""
     	    		bioMedicalWasteInstance.nameOfInstitution=""
     	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
     	    		bioMedicalWasteInstance.previousAuthNo=""
     	    		bioMedicalWasteInstance.previousAuthDate=new Date()

     	    		bioMedicalWasteInstance.completionStatus=""
     	    		bioMedicalWasteInstance.dateCreated= new Date()
     	    		bioMedicalWasteInstance.createdBy=""
     	    		bioMedicalWasteInstance.lastUpdated=new Date()
     	    		bioMedicalWasteInstance.updatedBy= ""
     	    		bioMedicalWasteInstance.applicationStatus=""
     	    		bioMedicalWasteInstance.clarification=false
     	    		bioMedicalWasteInstance.inspection=false
     	    		bioMedicalWasteInstance.prevExpDate=new Date()
     	    		bioMedicalWasteInstance.properties = params
     	    		bioMedicalWasteInstance.condImposedRenew = ""
     	    		             ///////////////// Added By Ankit Sharma ////////
     	    					 bioMedicalWasteInstance.authorisationAppliedFor = ""
     	    					 bioMedicalWasteInstance.hcfType = ""
     	    					 bioMedicalWasteInstance.hcfTypeMenu = ""
     	    					 bioMedicalWasteInstance.bmwfacility = ""
     	    					 bioMedicalWasteInstance.bmwstatus = ""
     	    					 bioMedicalWasteInstance.wastelocationaddress = ""
     	    		             bioMedicalWasteInstance.wastedisposalplace = ""
     	    					 bioMedicalWasteInstance.outpatientsFacility = ""
     	    					 bioMedicalWasteInstance.inpatientsFacility = ""
     	    					 bioMedicalWasteInstance.noofbeds = ""
     	    					 bioMedicalWasteInstance.other1 = ""
     	    					 bioMedicalWasteInstance.other2 = ""
     	    					 bioMedicalWasteInstance.patientspermonth = ""
     	    					 bioMedicalWasteInstance.destroyer = ""
     	    					 bioMedicalWasteInstance.bmwrules1 = ""
     	    					 bioMedicalWasteInstance.NoofHCF = ""
     	    					 bioMedicalWasteInstance.Jurisdictionalarea = ""
     	    					 bioMedicalWasteInstance.authorisationDay = ""
     	    					 bioMedicalWasteInstance.authorisationMonth = ""
     	    					 bioMedicalWasteInstance.shredders = ""
     	    					 bioMedicalWasteInstance.detailapc = ""
     	    					 bioMedicalWasteInstance.detailetp = ""
     	    					 bioMedicalWasteInstance.quantityperDay = ""
     	    					 bioMedicalWasteInstance.quantityperMonth = ""
     	    				     bioMedicalWasteInstance.quantityperDay1 = ""
     	    					 bioMedicalWasteInstance.quantityperMonth1 = ""
     	    					 bioMedicalWasteInstance.authapply = ""
     	    				     bioMedicalWasteInstance.hcfTypeMenu = ""
     	    					 bioMedicalWasteInstance.anatomicalwaste = ""
     	    					 bioMedicalWasteInstance.animalwaste = ""
     	    					 bioMedicalWasteInstance.biowaste = ""
     	    					 bioMedicalWasteInstance.wastesharp = ""
     	    					 bioMedicalWasteInstance.discardedwaste = ""
     	    					 bioMedicalWasteInstance.soiledwaste = ""
     	    					 bioMedicalWasteInstance.solidwaste = ""
     	    					 bioMedicalWasteInstance.liquidwaste = ""
     	    					 bioMedicalWasteInstance.ash = ""
     	    					 bioMedicalWasteInstance.chemicalwaste = ""
     	    					 
     	    					 bioMedicalWasteInstance.total1 = ""
     	    					 
     	    					bioMedicalWasteInstance.paymentDeviation = ""
     	    					bioMedicalWasteInstance.remittedFees = ""
     	    					
     	    					//addded by sharvan for new changes start from here
     	    					
     	    						bioMedicalWasteInstance.statusCteCto=""
     	    						bioMedicalWasteInstance.latitude=""
     	    						bioMedicalWasteInstance.longtitude=""
     	    						bioMedicalWasteInstance.detailsOfDirections=""
     	    						bioMedicalWasteInstance.noOfNonBeds=""
     	    						bioMedicalWasteInstance.noOfNonBeds1=""
     	    						bioMedicalWasteInstance.noOfInOutPatients=""
     	    						bioMedicalWasteInstance.colorCodedBags=""
     	    						bioMedicalWasteInstance.noOfBedsCbmwtf=""
     	    						bioMedicalWasteInstance.treatmentAndDisposal=""
     	    						bioMedicalWasteInstance.qtyOfBmwTreated=""
     	    						bioMedicalWasteInstance.contingencyPlan=""
     	    						bioMedicalWasteInstance.detailsOfTraining=""
     	    						bioMedicalWasteInstance.incinrators=""
     	    						bioMedicalWasteInstance.incinratorsType=""
     	    						bioMedicalWasteInstance.plasmaPyrolysis=""
     	    						bioMedicalWasteInstance.plasmaPyrolysisType=""
     	    						bioMedicalWasteInstance.autoclaves=""
     	    						bioMedicalWasteInstance.autoclavesType=""
     	    						bioMedicalWasteInstance.microwave=""
     	    						bioMedicalWasteInstance.microwaveType=""
     	    						bioMedicalWasteInstance.hydroclave=""
     	    						bioMedicalWasteInstance.hydroclaveType=""
     	    						bioMedicalWasteInstance.shredders=""
     	    						bioMedicalWasteInstance.shreddersType=""
     	    						bioMedicalWasteInstance.needleTipCutter=""
     	    						bioMedicalWasteInstance.needleTipCutterType=""
     	    						bioMedicalWasteInstance.sharpEncapsulation=""
     	    						bioMedicalWasteInstance.sharpEncapsulationType=""
     	    						bioMedicalWasteInstance.deepBurial=""
     	    						bioMedicalWasteInstance.deepBurialType=""
     	    						bioMedicalWasteInstance.chemDisinfection=""
     	    						bioMedicalWasteInstance.chemDisinfectionType=""
     	    						bioMedicalWasteInstance.anyOtherTretmntEquip=""
     	    						bioMedicalWasteInstance.anyOtherTretmntEquipType=""
     	    						bioMedicalWasteInstance.chemicalSolidWaste=""
     	    						bioMedicalWasteInstance.chemicalLiquidWaste=""
     	    						bioMedicalWasteInstance.discardedLinen=""
     	    						bioMedicalWasteInstance.otherClininLabWaste=""
     	    						bioMedicalWasteInstance.contaminatedwaste=""
     	    						bioMedicalWasteInstance.wasteSharps=""
     	    						bioMedicalWasteInstance.glassWare=""
     	    						bioMedicalWasteInstance.metallicBodyImplants=""
     	    					
     	    					// added by sharvan for new changes end here
     	    					 
     	    				   bioMedicalWasteInstance.properties = params
     	    		            //////////////////////////////////////////////////				 
     	    		            if(bioMedicalWasteInstance.save()){
     	    		            	
     	    		            	
     	    		            } 
     	    		            else{

     	    		            }
     	    		println("--invoked in old 2-")
     	    		            def id=bioMedicalWasteInstance.id
     	    		            return ['bioMedicalWasteInstance':bioMedicalWasteInstance,indRegInstance:indRegInstance,hcfAddressFacilityBmwMaster:hcfAddressFacilityBmwMaster,id:id, previousAuthList:previousAuthList,approveApplicationList:approveApplicationList]
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
	def createNewFormatSingle={

   		 try {
   			    
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
   			    activityRecInstance.activity = "save"
   		        activityRecInstance.status = "Bio-Medical Waste Apply Application Click"
   		        if(activityRecInstance.save()){		   
   		          }
   		        	else{
   		        		activityRecInstance.errors.each {
   				    	println it
   				   }
   			      }

    	    	def industryId = session.indUser
    	    	if(industryId==null || industryId=="")
    	        {
    	              redirect(controller:"userMaster",action:"logout")
    	        }

    			IndUser indUserInstance=(IndUser)session.indUser
    	    	def wasteManagementpendingDetails= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wmp where wmp.indRegInstance=? and wmp.applicationStatus='pending' and applicationFor='BMW'",[indUserInstance.industryRegMaster])
   	    	
    			def induserQuery=IndUser.get(indUserInstance.id)
    		
    			def indRegInstance=indUserInstance.industryRegMaster
    			def indRegInstanceId=indRegInstance.id
    			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    	    	//added by sharvan start from here
    	    	def hcfAddressFacilityBmwMaster= HcfAddressFacilityBmwMaster.find("from HcfAddressFacilityBmwMaster")

    	    	//added by sharvan end here
    			def bioMedicalWasteInstance = new BioMedicalWaste()


    	    			
    	    			//added by sharvan to get the previous authorization details
    	    			def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser.id=? order by to_date(Issued_date, 'dd/mm/yyyy')",[indRegInstanceId.toLong()])
    	    			def approveApplicationList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wms where wms.indRegInstance=? and applicationStatus='approved'",[indRegInstance])
    	    			// added by sharvan end here
    	    			
    	    			/////////////// If BMW Application Already applied //////////////////////////////
    	    			//added by sharvan start from here
    	    			def bioMedicalWasteInstanceOld1 = BioMedicalWaste.find("from BioMedicalWaste abc where abc.industryRegMasterObj=? and (applicationStatus='approved' or applicationStatus='rejected' or applicationStatus='pending') order by  applicationStatus ",[indRegInstanceGet])

    	    			//added by sharvan end here
    	    			def bioMedicalWasteInstanceOld = BioMedicalWaste.find("from BioMedicalWaste abc where abc.industryRegMasterObj=? and abc.completionStatus='Completed' order by abc.id desc ",[indRegInstanceGet])

    	    			//added by sharvan start from here
    	    			if(bioMedicalWasteInstanceOld1){

    	               	def bioWasteCategQuantList = BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstanceOld1)

    	               	   String aasf=bioMedicalWasteInstanceOld.activityAuthorizationSoughtFor
    	               	  
    	               	 
    	               	   def tmp=aasf.split(",")
    	                    ArrayList tmp1=new ArrayList()
    	                	for(int i=0;i<tmp.size();i++)
    	                	{
    	                		tmp1.add(tmp[i])
    	                	}
    	               	
    	       		    bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet
    	              		bioMedicalWasteInstance.nameOfApplicant=""
    	               	bioMedicalWasteInstance.nameOfInstitution=""
    	               		bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	               			bioMedicalWasteInstance.previousAuthNo=""
    	               				bioMedicalWasteInstance.previousAuthDate=new Date()
    	               				
    	               									
    	   							bioMedicalWasteInstance.dateCreated= new Date()
    	   								bioMedicalWasteInstance.createdBy=bioMedicalWasteInstanceOld1.createdBy
    	   									bioMedicalWasteInstance.lastUpdated=new Date()
    	   										bioMedicalWasteInstance.updatedBy= bioMedicalWasteInstanceOld1.updatedBy
    	   											bioMedicalWasteInstance.clarification=false
    	   												bioMedicalWasteInstance.inspection=false
    	   												bioMedicalWasteInstance.prevExpDate=new Date()
    	               	
    	               	//new code added from here by sharvan
    	               	bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet
    	    		bioMedicalWasteInstance.nameOfApplicant=""
    	    		bioMedicalWasteInstance.nameOfInstitution=""
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	    		bioMedicalWasteInstance.previousAuthNo=""
    	    		bioMedicalWasteInstance.previousAuthDate=new Date()


    	    		bioMedicalWasteInstance.completionStatus="Inprogress"
    	    		bioMedicalWasteInstance.dateCreated= new Date()
    	    		bioMedicalWasteInstance.createdBy=bioMedicalWasteInstanceOld1.createdBy
    	    		bioMedicalWasteInstance.lastUpdated=new Date()
    	    		bioMedicalWasteInstance.updatedBy= ""
    	    		bioMedicalWasteInstance.applicationStatus=""
    	    		bioMedicalWasteInstance.clarification=false
    	    		bioMedicalWasteInstance.inspection=false
    	    		bioMedicalWasteInstance.prevExpDate=new Date()
    	    		bioMedicalWasteInstance.properties = params
    	    		bioMedicalWasteInstance.condImposedRenew = ""
    	    		             ///////////////// Added By Ankit Sharma ////////
    	    					 bioMedicalWasteInstance.authorisationAppliedFor = ""
    	    					 bioMedicalWasteInstance.hcfType = ""
    	    					 bioMedicalWasteInstance.hcfTypeMenu = ""
    	    					 bioMedicalWasteInstance.bmwfacility = ""
    	    					 bioMedicalWasteInstance.bmwstatus = ""
    	    					 bioMedicalWasteInstance.wastelocationaddress = ""
    	    		             bioMedicalWasteInstance.wastedisposalplace = ""
    	    					 bioMedicalWasteInstance.outpatientsFacility = ""
    	    					 bioMedicalWasteInstance.inpatientsFacility = ""
    	    					 bioMedicalWasteInstance.noofbeds = ""
    	    					 bioMedicalWasteInstance.other1 = ""
    	    					 bioMedicalWasteInstance.other2 = ""
    	    					 bioMedicalWasteInstance.patientspermonth = ""
    	    					 bioMedicalWasteInstance.destroyer = ""
    	    					 bioMedicalWasteInstance.bmwrules1 = ""
    	    					 bioMedicalWasteInstance.NoofHCF = ""
    	    					 bioMedicalWasteInstance.Jurisdictionalarea = ""
    	    					 bioMedicalWasteInstance.authorisationDay = ""
    	    					 bioMedicalWasteInstance.authorisationMonth = ""
    	    					 bioMedicalWasteInstance.shredders = ""
    	    					 bioMedicalWasteInstance.detailapc = ""
    	    					 bioMedicalWasteInstance.detailetp = ""
    	    					 bioMedicalWasteInstance.quantityperDay = ""
    	    					 bioMedicalWasteInstance.quantityperMonth = ""
    	    				     bioMedicalWasteInstance.quantityperDay1 = ""
    	    					 bioMedicalWasteInstance.quantityperMonth1 = ""
    	    					 bioMedicalWasteInstance.authapply = ""
    	    				     bioMedicalWasteInstance.hcfTypeMenu = ""
    	    					 bioMedicalWasteInstance.anatomicalwaste = ""
    	    					 bioMedicalWasteInstance.animalwaste = ""
    	    					 bioMedicalWasteInstance.biowaste = ""
    	    					 bioMedicalWasteInstance.wastesharp = ""
    	    					 bioMedicalWasteInstance.discardedwaste = ""
    	    					 bioMedicalWasteInstance.soiledwaste = ""
    	    					 bioMedicalWasteInstance.solidwaste = ""
    	    					 bioMedicalWasteInstance.liquidwaste = ""
    	    					 bioMedicalWasteInstance.ash = ""
    	    					 bioMedicalWasteInstance.chemicalwaste = ""
    	    					 
    	    					 bioMedicalWasteInstance.total1 = ""
    	    					 
    	    					bioMedicalWasteInstance.paymentDeviation = ""
    	    					bioMedicalWasteInstance.remittedFees = ""
    	    					 
    	    					// added by sharvan start from here for new rules
    	    					
    	    					//addded by sharvan for new changes start from here
    	    					
    	    						bioMedicalWasteInstance.statusCteCto=""
    	    						bioMedicalWasteInstance.latitude=""
    	    						bioMedicalWasteInstance.longtitude=""
    	    						bioMedicalWasteInstance.detailsOfDirections=""
    	    						bioMedicalWasteInstance.noOfNonBeds=""
    	    						bioMedicalWasteInstance.noOfNonBeds1=""
    	    						bioMedicalWasteInstance.noOfInOutPatients=""
    	    						bioMedicalWasteInstance.colorCodedBags=""
    	    						bioMedicalWasteInstance.noOfBedsCbmwtf=""
    	    						bioMedicalWasteInstance.treatmentAndDisposal=""
    	    						bioMedicalWasteInstance.qtyOfBmwTreated=""
    	    						bioMedicalWasteInstance.contingencyPlan=""
    	    						bioMedicalWasteInstance.detailsOfTraining=""
    	    						bioMedicalWasteInstance.incinrators=""
    	    						bioMedicalWasteInstance.incinratorsType=""
    	    						bioMedicalWasteInstance.plasmaPyrolysis=""
    	    						bioMedicalWasteInstance.plasmaPyrolysisType=""
    	    						bioMedicalWasteInstance.autoclaves=""
    	    						bioMedicalWasteInstance.autoclavesType=""
    	    						bioMedicalWasteInstance.microwave=""
    	    						bioMedicalWasteInstance.microwaveType=""
    	    						bioMedicalWasteInstance.hydroclave=""
    	    						bioMedicalWasteInstance.hydroclaveType=""
    	    						bioMedicalWasteInstance.shredders=""
    	    						bioMedicalWasteInstance.shreddersType=""
    	    						bioMedicalWasteInstance.needleTipCutter=""
    	    						bioMedicalWasteInstance.needleTipCutterType=""
    	    						bioMedicalWasteInstance.sharpEncapsulation=""
    	    						bioMedicalWasteInstance.sharpEncapsulationType=""
    	    						bioMedicalWasteInstance.deepBurial=""
    	    						bioMedicalWasteInstance.deepBurialType=""
    	    						bioMedicalWasteInstance.chemDisinfection=""
    	    						bioMedicalWasteInstance.chemDisinfectionType=""
    	    						bioMedicalWasteInstance.anyOtherTretmntEquip=""
    	    						bioMedicalWasteInstance.anyOtherTretmntEquipType=""
    	    						bioMedicalWasteInstance.chemicalSolidWaste=""
    	    						bioMedicalWasteInstance.chemicalLiquidWaste=""
    	    						bioMedicalWasteInstance.discardedLinen=""
    	    						bioMedicalWasteInstance.otherClininLabWaste=""
    	    						bioMedicalWasteInstance.contaminatedwaste=""
    	    						bioMedicalWasteInstance.wasteSharps=""
    	    						bioMedicalWasteInstance.glassWare=""
    	    						bioMedicalWasteInstance.metallicBodyImplants=""
    	    						bioMedicalWasteInstance.serviceId=session.serviceId
        	    					bioMedicalWasteInstance.cafUniqueNo=session.cafUniqueNo
        	    					bioMedicalWasteInstance.singleWin=true
    	    					// added by sharvan for new changes end here
    	    					
    	    					
    	    					// adeded by sharvan end here 
    	    					
    	    				   bioMedicalWasteInstance.properties = params
    	    		            //////////////////////////////////////////////////	
    	    				   if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors()){
    	   		            	
    	   		            } 
    	   		            else{

    	   		            }

    	    		            def id=bioMedicalWasteInstance.id
    	               	//new code end here 
    	               	
    	               	        render (view:'createNewFormat',model:['bioMedicalWasteInstance':bioMedicalWasteInstanceOld1,indRegInstance:indRegInstance,hcfAddressFacilityBmwMaster:hcfAddressFacilityBmwMaster, tmp1:tmp1, id:id, previousAuthList:previousAuthList,approveApplicationList:approveApplicationList])
    	    		            return;
    	               }//added by sharvan end here
    	    			else {
    	    				if(bioMedicalWasteInstanceOld){

    	            	def bioWasteCategQuantList = BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstanceOld)

    	            	String aasf=bioMedicalWasteInstanceOld.activityAuthorizationSoughtFor
    	            	  
    	            	 
    	            	   def tmp=aasf.split(",")
    	                 ArrayList tmp1=new ArrayList()
    	             	for(int i=0;i<tmp.size();i++)
    	             	{
    	             		tmp1.add(tmp[i])
    	             	}

    	    		    bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet
    	           		bioMedicalWasteInstance.nameOfApplicant=bioMedicalWasteInstanceOld.nameOfApplicant
    	            	bioMedicalWasteInstance.nameOfInstitution=bioMedicalWasteInstanceOld.nameOfInstitution
    	            		bioMedicalWasteInstance.activityAuthorizationSoughtFor=bioMedicalWasteInstanceOld.activityAuthorizationSoughtFor
    	            			bioMedicalWasteInstance.previousAuthNo=bioMedicalWasteInstanceOld.previousAuthNo
    	            				bioMedicalWasteInstance.previousAuthDate=new Date()
    	            				
    	            									
    								bioMedicalWasteInstance.dateCreated= new Date()
    									bioMedicalWasteInstance.createdBy=bioMedicalWasteInstanceOld.createdBy
    										bioMedicalWasteInstance.lastUpdated=new Date()
    											bioMedicalWasteInstance.updatedBy= bioMedicalWasteInstanceOld.updatedBy
    												bioMedicalWasteInstance.clarification=false
    													bioMedicalWasteInstance.inspection=false
    													bioMedicalWasteInstance.prevExpDate=new Date()
    	    				}
    	            
    	    		bioMedicalWasteInstance.industryRegMasterObj=indRegInstanceGet

    	    		bioMedicalWasteInstance.nameOfApplicant=""
    	    		bioMedicalWasteInstance.nameOfInstitution=""
    	    		bioMedicalWasteInstance.activityAuthorizationSoughtFor=""
    	    		bioMedicalWasteInstance.previousAuthNo=""
    	    		bioMedicalWasteInstance.previousAuthDate=new Date()

    	    		bioMedicalWasteInstance.completionStatus="Inprogress"
    	    		bioMedicalWasteInstance.dateCreated= new Date()
    	    		bioMedicalWasteInstance.createdBy=""
    	    		bioMedicalWasteInstance.lastUpdated=new Date()
    	    		bioMedicalWasteInstance.updatedBy= ""
    	    		bioMedicalWasteInstance.applicationStatus=""
    	    		bioMedicalWasteInstance.clarification=false
    	    		bioMedicalWasteInstance.inspection=false
    	    		bioMedicalWasteInstance.prevExpDate=new Date()
    	    		bioMedicalWasteInstance.properties = params
    	    		bioMedicalWasteInstance.condImposedRenew = ""
    	    		             ///////////////// Added By Ankit Sharma ////////
    	    					 bioMedicalWasteInstance.authorisationAppliedFor = ""
    	    					 bioMedicalWasteInstance.hcfType = ""
    	    					 bioMedicalWasteInstance.hcfTypeMenu = ""
    	    					 bioMedicalWasteInstance.bmwfacility = ""
    	    					 bioMedicalWasteInstance.bmwstatus = ""
    	    					 bioMedicalWasteInstance.wastelocationaddress = ""
    	    		             bioMedicalWasteInstance.wastedisposalplace = ""
    	    					 bioMedicalWasteInstance.outpatientsFacility = ""
    	    					 bioMedicalWasteInstance.inpatientsFacility = ""
    	    					 bioMedicalWasteInstance.noofbeds = ""
    	    					 bioMedicalWasteInstance.other1 = ""
    	    					 bioMedicalWasteInstance.other2 = ""
    	    					 bioMedicalWasteInstance.patientspermonth = ""
    	    					 bioMedicalWasteInstance.destroyer = ""
    	    					 bioMedicalWasteInstance.bmwrules1 = ""
    	    					 bioMedicalWasteInstance.NoofHCF = ""
    	    					 bioMedicalWasteInstance.Jurisdictionalarea = ""
    	    					 bioMedicalWasteInstance.authorisationDay = ""
    	    					 bioMedicalWasteInstance.authorisationMonth = ""
    	    					 bioMedicalWasteInstance.shredders = ""
    	    					 bioMedicalWasteInstance.detailapc = ""
    	    					 bioMedicalWasteInstance.detailetp = ""
    	    					 bioMedicalWasteInstance.quantityperDay = ""
    	    					 bioMedicalWasteInstance.quantityperMonth = ""
    	    				     bioMedicalWasteInstance.quantityperDay1 = ""
    	    					 bioMedicalWasteInstance.quantityperMonth1 = ""
    	    					 bioMedicalWasteInstance.authapply = ""
    	    				     bioMedicalWasteInstance.hcfTypeMenu = ""
    	    					 bioMedicalWasteInstance.anatomicalwaste = ""
    	    					 bioMedicalWasteInstance.animalwaste = ""
    	    					 bioMedicalWasteInstance.biowaste = ""
    	    					 bioMedicalWasteInstance.wastesharp = ""
    	    					 bioMedicalWasteInstance.discardedwaste = ""
    	    					 bioMedicalWasteInstance.soiledwaste = ""
    	    					 bioMedicalWasteInstance.solidwaste = ""
    	    					 bioMedicalWasteInstance.liquidwaste = ""
    	    					 bioMedicalWasteInstance.ash = ""
    	    					 bioMedicalWasteInstance.chemicalwaste = ""
    	    					 
    	    					 bioMedicalWasteInstance.total1 = ""
    	    					 
    	    					bioMedicalWasteInstance.paymentDeviation = ""
    	    					bioMedicalWasteInstance.remittedFees = ""
    	    					
    	    					//addded by sharvan for new changes start from here
    	    					
    	    						bioMedicalWasteInstance.statusCteCto=""
    	    						bioMedicalWasteInstance.latitude=""
    	    						bioMedicalWasteInstance.longtitude=""
    	    						bioMedicalWasteInstance.detailsOfDirections=""
    	    						bioMedicalWasteInstance.noOfNonBeds=""
    	    						bioMedicalWasteInstance.noOfNonBeds1=""
    	    						bioMedicalWasteInstance.noOfInOutPatients=""
    	    						bioMedicalWasteInstance.colorCodedBags=""
    	    						bioMedicalWasteInstance.noOfBedsCbmwtf=""
    	    						bioMedicalWasteInstance.treatmentAndDisposal=""
    	    						bioMedicalWasteInstance.qtyOfBmwTreated=""
    	    						bioMedicalWasteInstance.contingencyPlan=""
    	    						bioMedicalWasteInstance.detailsOfTraining=""
    	    						bioMedicalWasteInstance.incinrators=""
    	    						bioMedicalWasteInstance.incinratorsType=""
    	    						bioMedicalWasteInstance.plasmaPyrolysis=""
    	    						bioMedicalWasteInstance.plasmaPyrolysisType=""
    	    						bioMedicalWasteInstance.autoclaves=""
    	    						bioMedicalWasteInstance.autoclavesType=""
    	    						bioMedicalWasteInstance.microwave=""
    	    						bioMedicalWasteInstance.microwaveType=""
    	    						bioMedicalWasteInstance.hydroclave=""
    	    						bioMedicalWasteInstance.hydroclaveType=""
    	    						bioMedicalWasteInstance.shredders=""
    	    						bioMedicalWasteInstance.shreddersType=""
    	    						bioMedicalWasteInstance.needleTipCutter=""
    	    						bioMedicalWasteInstance.needleTipCutterType=""
    	    						bioMedicalWasteInstance.sharpEncapsulation=""
    	    						bioMedicalWasteInstance.sharpEncapsulationType=""
    	    						bioMedicalWasteInstance.deepBurial=""
    	    						bioMedicalWasteInstance.deepBurialType=""
    	    						bioMedicalWasteInstance.chemDisinfection=""
    	    						bioMedicalWasteInstance.chemDisinfectionType=""
    	    						bioMedicalWasteInstance.anyOtherTretmntEquip=""
    	    						bioMedicalWasteInstance.anyOtherTretmntEquipType=""
    	    						bioMedicalWasteInstance.chemicalSolidWaste=""
    	    						bioMedicalWasteInstance.chemicalLiquidWaste=""
    	    						bioMedicalWasteInstance.discardedLinen=""
    	    						bioMedicalWasteInstance.otherClininLabWaste=""
    	    						bioMedicalWasteInstance.contaminatedwaste=""
    	    						bioMedicalWasteInstance.wasteSharps=""
    	    						bioMedicalWasteInstance.glassWare=""
    	    						bioMedicalWasteInstance.metallicBodyImplants=""
    	    						bioMedicalWasteInstance.serviceId=session.serviceId
    	    						bioMedicalWasteInstance.cafUniqueNo=session.cafUniqueNo
    	    					// added by sharvan for new changes end here
    	    					 bioMedicalWasteInstance.singleWin=true
    	    				   bioMedicalWasteInstance.properties = params
    	    		            //////////////////////////////////////////////////				 
    	    		            if(bioMedicalWasteInstance.save()){
    	    		            	
    	    		            	
    	    		            } 
    	    		            else{

    	    		            }
    	    		println("--invoked in old 2-")
    	    		            def id=bioMedicalWasteInstance.id
    	    		            render(view:'createNewFormat',model:['bioMedicalWasteInstance':bioMedicalWasteInstance,indRegInstance:indRegInstance,hcfAddressFacilityBmwMaster:hcfAddressFacilityBmwMaster,id:id, previousAuthList:previousAuthList,approveApplicationList:approveApplicationList])
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
        
        def saveNewFormat = {
    		println("params in saveNewFormat bmw--"+params)
    		 try {
    			    
    	        	
         	def totalfee = 0.0
         	def appFor="BMW"
         	def industryId = session.indUser
         	if(industryId==null || industryId=="")
             {
                   redirect(controller:"userMaster",action:"logout")
             }
         
            def indusrtyInstance=IndustryRegMaster.get((params.indRegId).toLong())
             def bioMedicalWasteInstance =	BioMedicalWaste.get((params.indAppDetId).toLong())

         	bioMedicalWasteInstance.industryRegMasterObj=indusrtyInstance
         	IndUser indUserInstance=(IndUser)session.indUser
         	def indRegInstance=indUserInstance.industryRegMaster
         	 

         	def dateCheck=params.prevauthDate_value
            def x=new Date()
         	def sqlCurrentDate
         	def currentDate=new Date()
         	DateCustom dd=new DateCustom()
         	sqlCurrentDate=dd.sQLdate(currentDate)
         	if(dateCheck)
         	{


         	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
         	 x= sdfh.parse(dateCheck);

         	bioMedicalWasteInstance.previousAuthDate=x
         	}
        
              def dateCheck1=params.prevexpDate_value
         	def y=new Date()
         	def sqlCurrentDate1
         	def currentDate1=new Date()
         	DateCustom dd1=new DateCustom()
         	sqlCurrentDate1=dd1.sQLdate(currentDate1)
         	if(dateCheck1)
         	{
         	def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
         	y= sdfh1.parse(dateCheck1);

         	bioMedicalWasteInstance.prevExpDate=y
         	}
        
         	/////////////////// For Inserting into DB BioMedical Waste Table..................////////////
         	bioMedicalWasteInstance.nameOfApplicant=params.nameOfApplicant
         	bioMedicalWasteInstance.nameOfInstitution=params.nameOfInstitution
         	def flag
         	
         	


         	bioMedicalWasteInstance.createdBy=indRegInstance.indName
         	bioMedicalWasteInstance.isNewApplication=true
         	
         	////////////////// Added By Ankit Sharma ///////////////////
         	String authReqFor=""
     			
         		if(params['checkboxGeneration']=="on") {
     				authReqFor=authReqFor.concat("Generation, segregation")
     				authReqFor=authReqFor.concat(",")
     			}
         	
     			if(params['checkboxCollection']=="on") {
     				authReqFor=authReqFor.concat("Collection")
     				authReqFor=authReqFor.concat(",")
     			}
     			
     			if(params['checkboxStorage']=="on") {
     				authReqFor=authReqFor.concat("Storage")
     				authReqFor=authReqFor.concat(",")
     			}
     			if(params['checkboxPackaging']=="on") {
     				authReqFor=authReqFor.concat("Packaging")
     				authReqFor=authReqFor.concat(",")
     			}
     			if(params['checkboxReception']=="on") {
     				authReqFor=authReqFor.concat("Reception")
     				authReqFor=authReqFor.concat(",")
     			}
     			
     			if(params['checkboxTransportation']=="on") {
     				authReqFor=authReqFor.concat("Transportation")
     				authReqFor=authReqFor.concat(",")
     			}
     			
     			if(params['checkboxTreatment']=="on") {
     				authReqFor=authReqFor.concat("Treatment or processing or conversion")
     				authReqFor=authReqFor.concat(",")
     			}
     			if(params['checkboxRecycling']=="on") {
     				authReqFor=authReqFor.concat("Recycling")
     				authReqFor=authReqFor.concat(",")
     			}
     			if(params['checkboxDisposal']=="on") {
     				authReqFor=authReqFor.concat("Disposal or destruction use")
     				authReqFor=authReqFor.concat(",")
     			}
     			if(params['checkboxOffering']=="on") {
     				authReqFor=authReqFor.concat("Offering for sale, transfer")
     				authReqFor=authReqFor.concat(",")
     			}
     			if(params['checkboxAnyother']=="on") {
     				authReqFor=authReqFor.concat("Any Other Form Of Handling")
     				authReqFor=authReqFor.concat(",")
     			}
     			
     			authReqFor = authReqFor.substring(0, authReqFor.length() - 1);

     			 bioMedicalWasteInstance.activityAuthorizationSoughtFor=authReqFor
         	    
     	    bioMedicalWasteInstance.authorisationAppliedFor=params.authorisationAppliedFor
     	    	if(params.hcfType){
     	    		bioMedicalWasteInstance.hcfType=params.hcfType
     	    		}else{
     	    			bioMedicalWasteInstance.hcfType=""
     	    		}
     	    		if(params.hcfType=='HCF' && params.hcfTypeMenu){
     	        	bioMedicalWasteInstance.hcfTypeMenu=params.hcfTypeMenu
     	    		}
     	    		else{
     	    			bioMedicalWasteInstance.hcfTypeMenu=""
     	    		}

         	if(params.bmwfacility){
         	bioMedicalWasteInstance.bmwfacility=params.bmwfacility
         	}else{
         		bioMedicalWasteInstance.bmwfacility=""
         	}
         	if(params.hcfType){

             	bioMedicalWasteInstance.bmwstatus=params.bmwstatus
             	bioMedicalWasteInstance.wastelocationaddress=params.wastelocationaddress
         	}else{
         		bioMedicalWasteInstance.bmwstatus=""
             	bioMedicalWasteInstance.wastelocationaddress=""
         	}
         	if(params.outpatientsFacility){
         	bioMedicalWasteInstance.outpatientsFacility=params.outpatientsFacility
         	}else{
         		bioMedicalWasteInstance.outpatientsFacility=""
         	}
         	if(params.inpatientsFacility){
         	bioMedicalWasteInstance.inpatientsFacility=params.inpatientsFacility
         	}else{
         		bioMedicalWasteInstance.inpatientsFacility=""
         	}
         	if(params.noofbeds){
         	bioMedicalWasteInstance.noofbeds=params.noofbeds
         	}else{
         		bioMedicalWasteInstance.noofbeds=""
         	}
         	bioMedicalWasteInstance.other1=""
         	bioMedicalWasteInstance.other2=""
         	bioMedicalWasteInstance.patientspermonth=""
         		bioMedicalWasteInstance.quantityperDay=""
         			bioMedicalWasteInstance.quantityperMonth=""
         			bioMedicalWasteInstance.quantityperDay1=""
         			bioMedicalWasteInstance.quantityperMonth1=""
         			if(params.authorisationDay){
         			        	bioMedicalWasteInstance.authorisationDay=params.authorisationDay
         			        	}else{
         			        		bioMedicalWasteInstance.authorisationDay=""
         			        	}
         			        	
         			        	bioMedicalWasteInstance.authorisationMonth=""

         			        	if(params.destroyer){
         			        	bioMedicalWasteInstance.destroyer=params.destroyer
         			        	}
         			        	else{
         			        		bioMedicalWasteInstance.destroyer=""
         			        	}
         			        	if(params.bmwrules1){
         			        	bioMedicalWasteInstance.bmwrules1=params.bmwrules1
         			        	}
         			        	else{
         			        		bioMedicalWasteInstance.bmwrules1=""
         			        	}
         	
         	if(params.NoofHCF){
         	bioMedicalWasteInstance.NoofHCF=params.NoofHCF
         	}else{
         		bioMedicalWasteInstance.NoofHCF=""
         	}
         	if(params.Jurisdictionalarea){
         	bioMedicalWasteInstance.Jurisdictionalarea=params.Jurisdictionalarea
         	}else{
         		bioMedicalWasteInstance.Jurisdictionalarea=""
         	}
         	if(params.shredders){
         	bioMedicalWasteInstance.shredders=params.shredders
         	}else{
         		bioMedicalWasteInstance.shredders=""
         	}
         	if(params.detailapc){
         	bioMedicalWasteInstance.detailapc=params.detailapc
         	}else{
         		bioMedicalWasteInstance.detailapc=""
         	}
         	if(params.detailetp){
         	bioMedicalWasteInstance.detailetp=params.detailetp
         	}else{
         		bioMedicalWasteInstance.detailetp=""
         	}
         	
         	if(params.anatomicalwaste){
         	bioMedicalWasteInstance.anatomicalwaste=params.anatomicalwaste
         	}else{
         		bioMedicalWasteInstance.anatomicalwaste=""
         	}
         	if(params.animalwaste){
         	bioMedicalWasteInstance.animalwaste=params.animalwaste
         	}else{
         		bioMedicalWasteInstance.animalwaste=""
         	}
         	if(params.discardedwaste){
         	bioMedicalWasteInstance.discardedwaste=params.discardedwaste
         	}else{
         		bioMedicalWasteInstance.discardedwaste=""
         	}
         	if(params.soiledwaste){
         	bioMedicalWasteInstance.soiledwaste=params.soiledwaste
         	}else{
         		bioMedicalWasteInstance.soiledwaste=""
         	}
         	if(params.total1){
         	bioMedicalWasteInstance.total1=params.total1
         	}else{
         		bioMedicalWasteInstance.total1=""
         	}
         	bioMedicalWasteInstance.completionStatus="Inprogress"
         	
         	bioMedicalWasteInstance.clarification=false
         	bioMedicalWasteInstance.inspection=false
         	bioMedicalWasteInstance.updatedBy=""
         	bioMedicalWasteInstance.applicationStatus=params.appStatus
         	
         		def industryRegInstanceWaste=indRegInstance
         		
         		//added by sharvan for new changes 
         	if(params.statusCteCto){
         	bioMedicalWasteInstance.statusCteCto= params.statusCteCto
         	}else{
         		bioMedicalWasteInstance.statusCteCto=""
         	}
         	if(params.latitude){
         	bioMedicalWasteInstance.latitude=params.latitude
         	}else{
         		bioMedicalWasteInstance.latitude=""
         	}
         	bioMedicalWasteInstance.longtitude=params.longtitude
         	bioMedicalWasteInstance.detailsOfDirections=params.detailsOfDirections

         	if(params.noOfNonBeds){
         	bioMedicalWasteInstance.noOfNonBeds=params.noOfNonBeds
         	}else{
         		bioMedicalWasteInstance.noOfNonBeds=""
         	}
         	if(params.noOfNonBeds1){
         	bioMedicalWasteInstance.noOfNonBeds1=params.noOfNonBeds1
         	}else{
         		bioMedicalWasteInstance.noOfNonBeds1==""
         	}
         	if(params.noOfInOutPatients){
         	bioMedicalWasteInstance.noOfInOutPatients=params.noOfInOutPatients
         	}else{
         		bioMedicalWasteInstance.noOfInOutPatients=""
         	}
         	if(params.colorCodedBags){
         	bioMedicalWasteInstance.colorCodedBags=params.colorCodedBags
         	}else{
         		bioMedicalWasteInstance.colorCodedBags=""
         	}
         	if(params.NoofBedsCbmwtf){
         	bioMedicalWasteInstance.noOfBedsCbmwtf=params.NoofBedsCbmwtf
         	}else{
         		bioMedicalWasteInstance.noOfBedsCbmwtf=""
         	}
         	if(params.treatmentAndDisposal){
         	bioMedicalWasteInstance.treatmentAndDisposal=params.treatmentAndDisposal
         	}else{
         		bioMedicalWasteInstance.treatmentAndDisposal=""
         	}
         	if(params.qtyOfBmwTreated){
         	bioMedicalWasteInstance.qtyOfBmwTreated=params.qtyOfBmwTreated
         	}else{
         		bioMedicalWasteInstance.qtyOfBmwTreated=""
         	}
         	if(params.contingencyPlan){
         	bioMedicalWasteInstance.contingencyPlan=params.contingencyPlan
         	}else{
         		bioMedicalWasteInstance.contingencyPlan=""
         	}
         	if(params.hcfType=="HCF"){
         	if(params.detailsOfTraining){
         		bioMedicalWasteInstance.detailsOfTraining=params.detailsOfTraining
         	}else{
         		bioMedicalWasteInstance.detailsOfTraining=""
         		}
         	}else{
         	
         		if(params.detailsOfTraining1){
         		bioMedicalWasteInstance.detailsOfTraining=params.detailsOfTraining1
         	}else{
         		bioMedicalWasteInstance.detailsOfTraining=""
         		}
         	}
         	if(params.incinrators){
         	bioMedicalWasteInstance.incinrators=params.incinrators
         	}else{
         		bioMedicalWasteInstance.incinrators=""
         	}
         	if(params.incinratorsType){
         	bioMedicalWasteInstance.incinratorsType=params.incinratorsType
         	}else{
         		bioMedicalWasteInstance.incinratorsType=""
         	}
         	if(params.plasmaPyrolysis){
         	bioMedicalWasteInstance.plasmaPyrolysis=params.plasmaPyrolysis
         	}else{
         		bioMedicalWasteInstance.plasmaPyrolysis=""
         	}
         	if(params.plasmaPyrolysisType){
         	bioMedicalWasteInstance.plasmaPyrolysisType=params.plasmaPyrolysisType
         	}else{
         		bioMedicalWasteInstance.plasmaPyrolysisType=""
         	}
         	if(params.autoclaves){
         	bioMedicalWasteInstance.autoclaves=params.autoclaves
         	}else{
         		bioMedicalWasteInstance.autoclaves=""
         	}
         	if(params.autoclavesType){
         	bioMedicalWasteInstance.autoclavesType=params.autoclavesType
         	}else{
         		bioMedicalWasteInstance.autoclavesType=""
         	}
         	if(params.microwave){
         	bioMedicalWasteInstance.microwave=params.microwave
         	}else{
         		bioMedicalWasteInstance.microwave=""
         	}
         	if(params.microwaveType){
         	bioMedicalWasteInstance.microwaveType=params.microwaveType
         	}else{
         		bioMedicalWasteInstance.microwaveType=""
         	}
         	if(params.hydroclave){
         	bioMedicalWasteInstance.hydroclave=params.hydroclave
         	}else{
         		bioMedicalWasteInstance.hydroclave=""
         	}
         	if(params.hydroclaveType){
         	bioMedicalWasteInstance.hydroclaveType=params.hydroclaveType
         	}else{
         		bioMedicalWasteInstance.hydroclaveType=""
         	}
         	if(params.shredders){
         	bioMedicalWasteInstance.shredders=params.shredders
         	}else{
         		bioMedicalWasteInstance.shredders=""
         	}
         	if(params.shreddersType){
         	bioMedicalWasteInstance.shreddersType=params.shreddersType
         	}else{
         		bioMedicalWasteInstance.shreddersType=""
         	}
         	if(params.needleTipCutter){
         	bioMedicalWasteInstance.needleTipCutter=params.needleTipCutter
         	}else{
         		bioMedicalWasteInstance.needleTipCutter=""
         	}
         	if(params.needleTipCutterType){
         	bioMedicalWasteInstance.needleTipCutterType=params.needleTipCutterType
         	}else{
         		bioMedicalWasteInstance.needleTipCutterType=""
         	}
         	if(params.sharpEncapsulation){
         	bioMedicalWasteInstance.sharpEncapsulation=params.sharpEncapsulation
         	}else{
         		bioMedicalWasteInstance.sharpEncapsulation=""
         	}
         	if(params.sharpEncapsulationType){
         	bioMedicalWasteInstance.sharpEncapsulationType=params.sharpEncapsulationType
         	}else{
         		bioMedicalWasteInstance.sharpEncapsulationType=""
         	}
         	if(params.deepBurial){
         	bioMedicalWasteInstance.deepBurial=params.deepBurial
         	}else{
         		bioMedicalWasteInstance.deepBurial=""
         	}
         	if(params.deepBurialType){
         	bioMedicalWasteInstance.deepBurialType=params.deepBurialType
         	}else{
         		bioMedicalWasteInstance.deepBurialType=""
         	}
         	if(params.chemDisinfection){
         	bioMedicalWasteInstance.chemDisinfection=params.chemDisinfection
         	}else{
         		bioMedicalWasteInstance.chemDisinfection=""
         	}
         	if(params.chemDisinfectionType){
         	bioMedicalWasteInstance.chemDisinfectionType=params.chemDisinfectionType
         	}else{
         		bioMedicalWasteInstance.chemDisinfectionType=""
         	}
         	if(params.anyOtherTreatmentEquip){
         	bioMedicalWasteInstance.anyOtherTretmntEquip=params.anyOtherTreatmentEquip
         	}else{
         		bioMedicalWasteInstance.anyOtherTretmntEquip=""
         	}
         	if(params.anyOtherTretmntEquipType){
         	bioMedicalWasteInstance.anyOtherTretmntEquipType=params.anyOtherTretmntEquipType
         	}else{
         		bioMedicalWasteInstance.anyOtherTretmntEquipType=""
         	}
         	if(params.chemicalSolidWaste){
         	bioMedicalWasteInstance.chemicalSolidWaste=params.chemicalSolidWaste
         	}else{
         		bioMedicalWasteInstance.chemicalSolidWaste=""
         	}
         	if(params.chemicalLiquidWaste){
         	bioMedicalWasteInstance.chemicalLiquidWaste=params.chemicalLiquidWaste
         	}else{
         		bioMedicalWasteInstance.chemicalLiquidWaste=""
         	}
         	if(params.discardedLinen){
         	bioMedicalWasteInstance.discardedLinen=params.discardedLinen
         	}else{
         		bioMedicalWasteInstance.discardedLinen=""
         	}
         	if(params.otherClinicLabWaste){
         	bioMedicalWasteInstance.otherClininLabWaste=params.otherClinicLabWaste
         	}else{
         		bioMedicalWasteInstance.otherClininLabWaste=""
         	}
         	if(params.contaminatedWaste){
         	bioMedicalWasteInstance.contaminatedwaste=params.contaminatedWaste
         	}else{
         		bioMedicalWasteInstance.contaminatedwaste=""
         	}
         	if(params.wasteSharps){
         	bioMedicalWasteInstance.wasteSharps=params.wasteSharps
         	}else{
         		bioMedicalWasteInstance.wasteSharps=""
         	}
         	if(params.glassWare){
         	bioMedicalWasteInstance.glassWare=params.glassWare
         	}else{
         		bioMedicalWasteInstance.glassWare=""
         	}
         	if(params.metallicBodyImplants){
         	bioMedicalWasteInstance.metallicBodyImplants=params.metallicBodyImplants
         	}else{
         		bioMedicalWasteInstance.metallicBodyImplants=""
         	}	
         		// added by sharvan end here
         		
         	 def consentFeeMasterInstance = new ConsentFeeMasterBMW()
     			
       		def calculatedfee = ConsentFeeMasterBMW.findByApplication(bioMedicalWasteInstance)
       		
       		if(calculatedfee){
       			
       			calculatedfee.delete()
       			
       		}
       		consentFeeMasterInstance.application = bioMedicalWasteInstance
       		if(params.yearsApplied != ""){
       			println("------yearsApplied----2"+params.yearsApplied)
       			consentFeeMasterInstance.noOfYears = (params.yearsApplied).toLong()
       		}
       		else{
       			consentFeeMasterInstance.noOfYears = 0
       		}
       			
       		if(params.feeApplicable != ""){
       			consentFeeMasterInstance.calculatedFee = (params.feeApplicable).toFloat()
       		
       		}
       		else{
       			consentFeeMasterInstance.calculatedFee = 0
       		}
       		if(consentFeeMasterInstance.save())
       		{

       		}else{
       			consentFeeMasterInstance.errors.each{
       				println it;
       			}
       		}
        ////////////////???????????? single window code 		
       	 SendSms sms = new SendSms()
         def cafUniqueNo1=session.cafUniqueNo;
         def registration_id=session.registrationId;
         def ack_no=bioMedicalWasteInstance.id;
         def status="In-Progress";
         def departmentId=session.departmentId;
         def serviceId1=session.serviceId;
         def industryName=indRegInstance.indName;
         def distName=indRegInstance.district.districtName;
         def indus_add=indRegInstance.indAddress;

         println("VINEET DISTRICT--------"+distName);
        
       ////////////////????????????????
     	   if(params.appStatus=="Inprogress"){
         				
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
	            activityRecInstance.status = "BMW Application ${bioMedicalWasteInstance.id} Available for Future Modification."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
				    	println it
				  }
			  }
         			
         				flash.message = "BioMedicalWaste Application No ${bioMedicalWasteInstance.id} is Available for Future modification"
         				if((bioMedicalWasteInstance.cafUniqueNo!="") && (bioMedicalWasteInstance.cafUniqueNo!=null)){
         					Response responsePush=new Response()
         					String consentAppNo=bioMedicalWasteInstance.id.toString();
         					String cafNo=bioMedicalWasteInstance.cafUniqueNo
         					String serviceId=bioMedicalWasteInstance.serviceId
         					String applicationType="BMW"
         						String applicationFor1=""
         					if(bioMedicalWasteInstance.authorisationAppliedFor=="fresh"){
         						applicationFor1="Fresh"
         					}else if(bioMedicalWasteInstance.authorisationAppliedFor=="renew")
         					{
         						applicationFor1="Renew"
         					}
         					
         					String statusCode="I"
         					String appRemarks="Application Saved as draft"
         					
         					String pendingWith=""
         					String pendingWithRole=""
         					String printAppUrl=""
         					String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+bioMedicalWasteInstance.industryRegMasterObj.indName+"&indDistrict="+bioMedicalWasteInstance.industryRegMasterObj.district.districtName+"&serviceCode="+bioMedicalWasteInstance.serviceId+"&cafUniqueNo="+bioMedicalWasteInstance.cafUniqueNo
         					String certificateUrl=""
         					
         					responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationType,applicationFor1,statusCode,appRemarks,pendingWith,pendingWithRole,printAppUrl,revertedUrl,certificateUrl)
         				}
         				
         				redirect(action:showNewFormat,id:bioMedicalWasteInstance.id)
         				return;
         				
         			}
         			if(params.appStatus=="Completed"){
         			  def feesinstance = FeeBankOtherDetailsBMW.find("from FeeBankOtherDetailsBMW fee where fee.application=?",[bioMedicalWasteInstance])

         				/*if(!feesinstance){
         					flash.message = "Please enter Bank fee Detail"
         					bioMedicalWasteInstance.completionStatus="Inprogress"
             				bioMedicalWasteInstance.save()
         					redirect(action:editNewFormat,id:bioMedicalWasteInstance.id)
         					return;
         				}*/
         				
         			  def feeListBMW=FeeBankOtherDetailsBMW.findAllByApplication(bioMedicalWasteInstance)
         	    		
         	    		
         	        	
         	        	for(int i=0;i<feeListBMW.size();i++)
         	        	{
         	        		totalfee = totalfee + feeListBMW.get(i).amount
         	        	}

         			  
         				def bioId=bioMedicalWasteInstance.id

         				def bioIdInstance=BioMedicalWaste.get(bioId)

         				
         				
         			
     				
             			//////////////////////       Document mandetory code Added by Deepak    //////////////////////////////////////         	
             			
         				
     				    def dcCkeck
     				    def applicationFordoc
     					ArrayList strList = new ArrayList()
         				
         				if(bioMedicalWasteInstance.authorisationAppliedFor=="fresh"){
     						applicationFordoc="BMW Fresh"
     					}else if(bioMedicalWasteInstance.authorisationAppliedFor=="renew")
     					{
     						applicationFordoc="BMW Renew"
     					}
         				println("applicationFordoc---bmw--"+applicationFordoc)

     					dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor= ? ",[applicationFordoc])
     					println("dcCkeck---bmw--"+dcCkeck)
     				
     			//	dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.consentFor='BMW' and doc.isMandatory='Yes' and doc.isNewApplication='true'")
					for(int i=0;i<dcCkeck.size();i++)
					{
						if(((dcCkeck.get(i)).isMandatory).equalsIgnoreCase("Yes"))
						{
							def isOrNot = WasteManagementFile.find("from WasteManagementFile abc where abc.description=? and abc.applicationId=?",[(dcCkeck.get(i)).document,bioMedicalWasteInstance.id])
							if(!isOrNot)
							  strList.add(dcCkeck.get(i).document+"\n")
						}
					}
				   if(strList)
					{
						def strr = "Please Upload following documents:\n"
				        for(int i=0;i<strList.size();i++)
				    		{
				        		strr += ("("+(i+1)+"). "+strList.get(i)).toString()+"\n"
				    		}
				        flash.message = strr
				        bioMedicalWasteInstance.completionStatus = "Inprogress"
				        bioMedicalWasteInstance.save(flush:true)	
						redirect(action:editNewFormat,id:bioMedicalWasteInstance.id)
						return ;
					}
				   //============================  end  ================================//
     				
     				
     				
     				
     				
     				
     				
     				
     	//////////////////////////// For getting Receiving officer Name//////////////////////////////def investCap1 =  hazardeousWasteAuthAppInstance.industryRegMasterObj.indCapInvt
         				def investCap1 =  bioMedicalWasteInstance.industryRegMasterObj.indCapInvt

     	              def indSize
         				String office
         				def roleNameForpdf
         				def grp
         			
         				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
         				
         					for(int i=0;i<roleVsActList.size();i++){
         		    	if(((roleVsActList.get(i)).role).group == grp){
         		    		roleNameForpdf = (roleVsActList.get(i)).role.roleName
         		    	}
         					}
         			
         				////////////////// For Routing application /////////////////
    					
         				
     				///////////////////////////////////////  Code for generating File Number /////////////////////////
           def indApplInst=bioMedicalWasteInstance

     		def industryRegMasterInstance=IndustryRegMaster.get(indApplInst.industryRegMasterObj.id)

     		def districtOfiiceMasterInstance= ""

     		
     		//added by sharvan start
     		 def jurisdictionOfficeName=""
     		//aded by sharvan end
     		def sdfh = new SimpleDateFormat("dd/MM/yyyy");   
     		def fileNoArrayList=new ArrayList()
     		def fileNoString
     		def fileNoSize
     		def fileNoValue
     		def fileNo
      
         	/////////////////////////////////// Values to be inserted into PDF.............../////////////////////
       
         	def activityAuthorizationSoughtFor = bioMedicalWasteInstance.activityAuthorizationSoughtFor
     		def phnCodeOfOccupier = indRegInstance.occPhoneCode
     		def phnOfOccupier = indRegInstance.occPhoneNo
     		def faxCodeOfOccupier = indRegInstance.occFaxCode
     		def faxOfOccupier = indRegInstance.occFaxNo
     		def emailOfOccupier = indRegInstance.occEmail
     		def applicantName = indRegInstance.occName

     		def applicantDesignation
     		if(indRegInstance.occDesignation=="Others"){
     			applicantDesignation=indRegInstance.otherOccDesignation
     		}else{
     			applicantDesignation=indRegInstance.occDesignation
     		}
     		def instutionName = indRegInstance.indName

     		def addressOfInd = indRegInstance.indAddress

     		def phnCodeOfInd = indRegInstance.indPhoneCode

     		def phnOfInd = indRegInstance.indPhoneNo

     		def faxCodeOfInd = indRegInstance.indFaxCode

     		def faxOfInd = indRegInstance.indFaxNo

     		def emailOfInd = indRegInstance.occEmail

     		
     		def mobileNo=indRegInstance.occMobile
     		def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
     		def district = cat.district.districtName
            def applFor12
             def authorisationFor =bioMedicalWasteInstance.activityAuthorizationSoughtFor
             def appliedFor=bioMedicalWasteInstance.authorisationAppliedFor
             if(bioMedicalWasteInstance.authorisationAppliedFor=="renew"){
             	appliedFor="Renewal"
             	applFor12="BMW Renew"
             }
             else{
             	appliedFor="Fresh"
             	applFor12="BMW Fresh"
             }
     		
     		 // new changes made by sharvan start from here
             def statusCteCto=bioMedicalWasteInstance.statusCteCto
             def lat=bioMedicalWasteInstance.latitude
             def longt=bioMedicalWasteInstance.longtitude
             def detailsOfDirections=bioMedicalWasteInstance.detailsOfDirections
             //Details Of HCF added by sharvan as per new rules
             def outpatientsFacility=bioMedicalWasteInstance.outpatientsFacility
             def inpatientsFacility=bioMedicalWasteInstance.inpatientsFacility
             def noofbeds=bioMedicalWasteInstance.noofbeds
             def noOfNonBeds=bioMedicalWasteInstance.noOfNonBeds
             def noOfInOutPatients=bioMedicalWasteInstance.noOfInOutPatients
             // Details Of CBMWTF added by sharvan as per new rules
             def NoofHCF=bioMedicalWasteInstance.NoofHCF
             def noOfBedsCbmwtf=bioMedicalWasteInstance.noOfBedsCbmwtf
             def treatmentAndDisposal=bioMedicalWasteInstance.treatmentAndDisposal
             def qtyOfBmwTreated=bioMedicalWasteInstance.qtyOfBmwTreated
             def Jurisdictionalarea=bioMedicalWasteInstance.Jurisdictionalarea
             def contingencyPlan=bioMedicalWasteInstance.contingencyPlan
             //new changes ends here
            
             
     		def hcfType=bioMedicalWasteInstance.hcfType
             def wasteFacilityStatus=bioMedicalWasteInstance.bmwfacility
             def officeAddress=bioMedicalWasteInstance.bmwstatus
             def wasteLocationAddress=bioMedicalWasteInstance.wastelocationaddress
             def placeOfTreatment="dsf"
             def placeOfDisposal="sdfds"
             	/////////////// Table in PdF for Screen 3/////////////////
            def anatomicalwaste=bioMedicalWasteInstance.anatomicalwaste
            def animalwaste=bioMedicalWasteInstance.animalwaste
            def solidwaste=bioMedicalWasteInstance.soiledwaste
            def discardedwaste=bioMedicalWasteInstance.discardedwaste
            def chemicalSolidWaste=bioMedicalWasteInstance.chemicalSolidWaste
            def chemicalLiquidWaste=bioMedicalWasteInstance.chemicalLiquidWaste
            def discardedLinen=bioMedicalWasteInstance.discardedLinen
            def otherClininLabWaste=bioMedicalWasteInstance.otherClininLabWaste
            def contaminatedwaste=bioMedicalWasteInstance.contaminatedwaste
            def wasteSharps=bioMedicalWasteInstance.wasteSharps
            def glassWare=bioMedicalWasteInstance.glassWare
            def metallicBodyImplants=bioMedicalWasteInstance.metallicBodyImplants
            def biowaste1="5"
            def wastesharp=bioMedicalWasteInstance.wastesharp
            def wastesharp1="4"
            def soiledwaste=bioMedicalWasteInstance.soiledwaste
            def soiledwaste1="5"
            def liquidwaste="3"
            def liquidwaste2="3"
            def ash="2"
            def ash1="3"
            def chemicalwaste="2"
            def chemicalwaste1="3"
            def chemicalwaste2="1"
            def total1=bioMedicalWasteInstance.total1
            def total2="2"
            ////added by sharvan start
            //table in pdf for screen 4 added by sharvan start from here
            def appNo=bioMedicalWasteInstance.id
            def incinrators=bioMedicalWasteInstance.incinrators
            def incinratorsType=bioMedicalWasteInstance.incinratorsType
            def plasmaPyrolysis=bioMedicalWasteInstance.plasmaPyrolysis
            def plasmaPyrolysisType=bioMedicalWasteInstance.plasmaPyrolysisType
            def autoclaves=bioMedicalWasteInstance.autoclaves
            def autoclavesType=bioMedicalWasteInstance.autoclavesType
            def microwave=bioMedicalWasteInstance.microwave
            def microwaveType=bioMedicalWasteInstance.microwaveType
            def hydroclave=bioMedicalWasteInstance.hydroclave
            def hydroclaveType=bioMedicalWasteInstance.hydroclaveType
            def shredders=bioMedicalWasteInstance.shredders
            def shreddersType=bioMedicalWasteInstance.shreddersType
            def needleTipCutter=bioMedicalWasteInstance.needleTipCutter
            def needleTipCutterType=bioMedicalWasteInstance.needleTipCutterType
            def sharpEncapsulation=bioMedicalWasteInstance.sharpEncapsulation
            def sharpEncapsulationType=bioMedicalWasteInstance.sharpEncapsulationType
            def deepBurial=bioMedicalWasteInstance.deepBurial
            def deepBurialType=bioMedicalWasteInstance.deepBurialType
            def chemDisinfection=bioMedicalWasteInstance.chemDisinfection
            def chemDisinfectionType=bioMedicalWasteInstance.chemDisinfectionType
            def anyOtherTretmntEquip=bioMedicalWasteInstance.anyOtherTretmntEquip
            def anyOtherTretmntEquipType=bioMedicalWasteInstance.anyOtherTretmntEquipType
            //table in pdf for screen 4 added by sharvan end here
            
            	SimpleDateFormat formatNowYear = new SimpleDateFormat("dd/MM/yyyy");
     		def BMWApplicationDate=formatNowYear.format(bioMedicalWasteInstance.dateCreated)
         		
            //////added by sharvan end
////////////////////////////////     / Endss////////////////////////////////////


////////////////////////////////////     / Previous BMW Authorisation Details Table /////////////////////////////			
     		    def hwPreviousAuthDetails = new ArrayList()	

     			 def hwPreviousAuthDetailsList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails s where s.indUser.id=? and s.wasteManagementFileId!='' order by to_date(Issued_date, 'dd/mm/yyyy') ",[bioMedicalWasteInstance.industryRegMasterObj.id])
     			
     			 for(int var33=0;var33<hwPreviousAuthDetailsList.size();var33++)
     				{
     					def hwmPreviousAuthorisationList= new ArrayList()
     					
     					
     				    hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).BMWApplication_Date)
     					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).BMWAType)
     					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).AuthorisationNo)
     					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Issued_date)
     					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Valid_date)
     					

     					hwPreviousAuthDetails.add(hwmPreviousAuthorisationList)
     					
     				}	

     					def waste	
     	///////////////////////////////////// ENDSSSSSSSSSSSSS //////////////////////////////////////////// 

            //-----------------fees---------------------//

        def feeList= new ArrayList()
		def feeDetailsList=FeeBankDetailsBMW.findAllByApplication(bioMedicalWasteInstance)
		println("feeDetailsList"+feeDetailsList)
		for(int var2=0;var2<feeDetailsList.size();var2++)
		{
			def feeDetails= new ArrayList()
			feeDetails.add(feeDetailsList.get(var2).bankName)
			feeDetails.add(feeDetailsList.get(var2).branch)
			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
			feeDetails.add(feeDetailsList.get(var2).date)
			feeDetails.add((feeDetailsList.get(var2).amount).toString())
			feeList.add(feeDetails)
		
		}
        def onlineFee=new ArrayList()
        def onlineFeeList=BankTransactionDetailsBMW.findAll("from BankTransactionDetailsBMW bm where bm.bioApplication=? and bm.transactionStatus='S'",[bioMedicalWasteInstance])
           for(int var88=0;var88<onlineFeeList.size();var88++){
           	def onlineFeeDetails=new ArrayList()
           	onlineFeeDetails.add((onlineFeeList.get(var88).id).toString())
           	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           	String dateCreated1=sdf.format(onlineFeeList.get(var88).dateCreated);
           	onlineFeeDetails.add(dateCreated1)
           	onlineFeeDetails.add((onlineFeeList.get(var88).amount).toString())
           	onlineFeeDetails.add("Successful")
           	onlineFee.add(onlineFeeDetails)
           }
        
           
            
            //----------------------end code----------------//
            String str3 = district.toLowerCase();
             char[] c3 = str3.toCharArray();
             c3[0] = Character.toUpperCase(c3[0]);
             district=c3.toString()
     		
     		def listDoc= new ArrayList()
     	   	 
     		def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.applicationId=? and apd.typeOfFile='BMW Documents' and apd.applicationFor=? order by apd.id asc",[bioMedicalWasteInstance.id,applFor12])
         	
         	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
         		def boolCheck=false

         		if(listDoc.size()==0){

         			listDoc.add(applicationDocumentInstance.get(ig))
         		}

         		for(int intCheck=0;intCheck<listDoc.size();intCheck++){

         			if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description){

         				boolCheck=true
         			}
         		}
         		if(boolCheck==false){

         			listDoc.add(applicationDocumentInstance.get(ig))
         		}
         	}
     	

     	
     		 def listDocuments = new ArrayList()
         		listDocuments.add(listDoc.description)

         				
     		          BmwPdfFileNewFormat  pdf = new BmwPdfFileNewFormat()

         				
         				File certFile1

                  certFile1 = pdf.bmwPdfFunction(applicantName,applicantDesignation,instutionName,addressOfInd,phnCodeOfInd,phnOfInd,mobileNo,emailOfInd,authorisationFor,appliedFor,hcfType,
                 		         wasteFacilityStatus,officeAddress,wasteLocationAddress,placeOfDisposal,statusCteCto,lat,longt,detailsOfDirections,outpatientsFacility,inpatientsFacility,noofbeds,
                 		         noOfNonBeds,noOfInOutPatients,NoofHCF,noOfBedsCbmwtf,treatmentAndDisposal,
                 		         qtyOfBmwTreated,Jurisdictionalarea,contingencyPlan,anatomicalwaste,animalwaste, soiledwaste,discardedwaste,chemicalSolidWaste,
                 		         chemicalLiquidWaste,discardedLinen,otherClininLabWaste,contaminatedwaste,wasteSharps,glassWare,metallicBodyImplants,total1
                 		         ,incinrators,incinratorsType,plasmaPyrolysis,plasmaPyrolysisType,autoclaves,autoclavesType,microwave,microwaveType,hydroclave,hydroclaveType,
                 		         shredders,shreddersType,needleTipCutter,needleTipCutterType,sharpEncapsulation,sharpEncapsulationType,deepBurial,deepBurialType,chemDisinfection,chemDisinfectionType,anyOtherTretmntEquip,anyOtherTretmntEquipType,roleNameForpdf,listDocuments,hwPreviousAuthDetails,BMWApplicationDate,jurisdictionOfficeName,feeList,appNo,onlineFee)
                 		

         				

         				byte[] b = new byte[(int) certFile1.length()];
         				
         				FileInputStream fileInputStream = new FileInputStream(certFile1);
         				fileInputStream.read(b);
         				
         				def industryReg1=IndustryRegMaster.get((params.indRegId).toLong())

         				
         				
         				WasteManagementFile file1=new WasteManagementFile()
         				def fileLength=certFile1.length()
         				file1.applicationId = bioId
         				file1.size = fileLength / 1024  //f.getSize() 
         				file1.extension ="pdf"//extractExtension( f )
         				file1.data=b;
         				file1.name="BmwForm.pdf"
         				file1.description="BMW Application Form"
         				file1.createdBy= session.indUser
         				file1.updatedBy=session.indUser
         				file1.typeOfFile="BmwForm"
         				file1.applicationFor="BMW"
         				file1.indreg=industryReg1

         				
         				if(file1.save()) {

         					
         				}
         				else{
         					
         				}	
         				



         		
         			}
         			
         			
         			 if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors())
         	         {
         		  

             		
             		

         	         }
         						
         	        
         			else
         			{
         				bioMedicalWasteInstance.errors.each {
         	   		        println it
         	   			}
         			
         				
         			}
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
    	            activityRecInstance.status = "BMW Application ${bioMedicalWasteInstance.id} saved for payment."
    	            if(activityRecInstance.save()){		   
    	              }
    	            	else{
    	            		activityRecInstance.errors.each {
    				    	println it
    				  }
    			  }
    	                println("bioMedicalWasteInstance--in saveNewFormat--"+bioMedicalWasteInstance)
         				//render(view:'Payment',model:[feesPaid:totalfee,bioMedicalWasteInstance:bioMedicalWasteInstance])
         				redirect(action:confirmation,id:bioMedicalWasteInstance.id)
         	    		
             
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
	
	
    def showNewFormat1 = {
       	 try {
       		    def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )

       	        def appId=bioMedicalWasteInstance.id
       	        def appFor="BMW"
       	        def checkCertificate=WasteManagementCertificates.find("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? and typeOfFile='BMW' order by wmc.id desc",[appId,appFor])
       	       
       	        def certInstanceId
       	        if(checkCertificate){
       	        certInstanceId=checkCertificate.id
       	        }
       		    println("====certInstanceId==="+certInstanceId)
       	   def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
       			def indRegInstanceId=indRegInstance.id
       			def indRegInstanceGet=indRegInstance
       			def approveApplicationList= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails bmr where bmr.indRegInstance=? and applicationFor='BMW' and applicationStatus='approved'",[bioMedicalWasteInstance.industryRegMasterObj])
       		def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
       	         if(!bioMedicalWasteInstance) {
       	            flash.message = "BioMedicalWaste not found with id ${params.id}"
       	            redirect(action:create)
       	        }
       	        else {
       	        	
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
       	            activityRecInstance.status = "Bio-Medical Waste Application "+bioMedicalWasteInstance.id+ " Click for View."
       	            if(activityRecInstance.save()){		   
       	              }
       	            	else{
       	            		activityRecInstance.errors.each {
       	    		    	println it
       	    		  }
       	    	  }
       	        	   render(view:'showNewFormat',model:[certInstanceId:certInstanceId, bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance , id:bioMedicalWasteInstance.id,indApplicationDetailsInstance:bioMedicalWasteInstance,approveApplicationList:approveApplicationList ])
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
       
    
    
        def showNewFormat={
    		 try {
    			    

             	

             	
             	def industryId = session.indUser
             	if(industryId==null || industryId=="")
                 {
                       redirect(controller:"userMaster",action:"logout")
                 }
             	

                 def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )

                 def appId=bioMedicalWasteInstance.id
                 def appFor="BMW"
                 def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
                 def certInstance=checkCertificate[0]
                 def certInstanceId
                 if(certInstance){
                 certInstanceId=certInstance.id
                 }
             	IndUser indUserInstance=(IndUser)session.indUser
         		def induserQuery=IndUser.get(indUserInstance.id)
         		
         		
         		def indRegInstance=indUserInstance.industryRegMaster
         		def indRegInstanceId=indRegInstance.id
         		def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
             	
         		def approveApplicationList= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails bmr where bmr.indRegInstance=? and applicationFor='BMW' and applicationStatus='approved'",[indRegInstanceGet])
                 
                 def bioWasteCategQuantList=BioWasteCategQuant.findAllByBioMedicalWasteObj(bioMedicalWasteInstance)
                 

                 if(!bioMedicalWasteInstance) {
                     flash.message = "BioMedicalWaste not found with id ${params.id}"
                     redirect(action:list)
                 }
                 else {
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
                     activityRecInstance.status = "Bio-Medical Waste Application "+bioMedicalWasteInstance.id+ " Click for View."
                     if(activityRecInstance.save()){		   
                       }
                     	else{
                     		activityRecInstance.errors.each {
             		    	println it
             		  }
             	  }
                 	render(view:'showNewFormat',model:[certInstanceId:certInstanceId, bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance , id:bioMedicalWasteInstance.id,approveApplicationList:approveApplicationList ]) }
         
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
	
        
        def editNewFormat={
    		 try {
    			    println("params------"+params)
    			    def editableMode = params.editableMode
    			    def testValue=params.testVal
    			 println("editableMode--------"+editableMode)
    	           	def industryId = session.indUser
    	           	if(industryId==null || industryId=="")
    	               {
    	                     redirect(controller:"userMaster",action:"logout")
    	               }

    	               def bioMedicalWasteInstance = BioMedicalWaste.get( params.id )
    	               String aasf=bioMedicalWasteInstance.activityAuthorizationSoughtFor
    	               def tmp=aasf.split(",")
    	               ArrayList tmp1=new ArrayList()
    	           	for(int i=0;i<tmp.size();i++)
    	           	{
    	           		tmp1.add(tmp[i])
    	           	}


    	               
//    	             added by sharvan to get the previous authorization details
    	       		def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser=? order by to_date(Issued_date, 'dd/mm/yyyy')",[bioMedicalWasteInstance.industryRegMasterObj])
    	       		def wasteManagementList= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails bmr where bmr.indRegInstance=? and applicationStatus!='pending'",[bioMedicalWasteInstance.industryRegMasterObj])
    	       		def approveApplicationList= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails bmr where bmr.indRegInstance=? and applicationFor='BMW' and applicationStatus='approved'",[bioMedicalWasteInstance.industryRegMasterObj])
    	       		//def authBmwAppList=BioMedicalWaste.findAll("from BioMedicalWaste bmw where bmw.")
    	       		// added by sharvan end here
    	       	
    	               
    	               def bioWasteCategQuantList=BioWasteCategQuant.findAllBybioMedicalWasteObj(bioMedicalWasteInstance)
    	               

    	               
    	               IndUser indUserInstance=(IndUser)session.indUser
    	       		def induserQuery=IndUser.get(indUserInstance.id)
    	       		
    	       		
    	       		def indRegInstance=indUserInstance.industryRegMaster
    	               if(!bioMedicalWasteInstance) {
    	                   flash.message = "BioMedicalWaste not found with id ${params.id}"
    	                   redirect(action:list)
    	               }
    	               else {

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
    	   	            activityRecInstance.status = "BMW Application ${params.id} Edit Click"
    	   	            if(activityRecInstance.save()){		   
    	   	              }
    	   	            	else{
    	   	            		activityRecInstance.errors.each {
    	   				    	println it
    	   				  }
    	   			  }  
    	                   return [ bioMedicalWasteInstance : bioMedicalWasteInstance ,bioWasteCategQuantList:bioWasteCategQuantList,indRegInstance:indRegInstance,tmp1:tmp1,previousAuthList:previousAuthList,wasteManagementList:wasteManagementList,editableMode:editableMode,approveApplicationList:approveApplicationList,testValue:testValue]
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
        
        def popUploadDocBmwFresh ={
    		 try {
    			def app = BioMedicalWaste.get((params.id).toInteger())
    			def certFor="BMW Fresh" 
       	    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where  abc.applicationFor=? order by abc.id asc",[certFor])
       	    	def listDoc= new ArrayList()
    			def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='BMW Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
       	     	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
       	     		def boolCheck=false
       	     	
       	     		if(listDoc.size()==0){
       	     			
       	     			listDoc.add(applicationDocumentInstance.get(ig))
       	     		}
       	     	
       	     		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
       	     		
       	     			if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description){
       	     				boolCheck=true
       	     			}
       	     		}
       	     		if(boolCheck==false){
       	     			listDoc.add(applicationDocumentInstance.get(ig))
       	     		}
       	     		
       	     	}
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
 		    activityRecInstance.status = "BMW Fresh Application "+params.id+ " Upload Required Documents Click"
             if(activityRecInstance.save()){		   
               }
             	else{
             		activityRecInstance.errors.each {
 			    	println it
 			  }
 		  }
             println("--------uploadedDocList-------"+docList.size())
       		     return [app:app,appDetId:params.id,docList:docList,uploadedDocList:listDoc]
       	    
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
    
    
    	def popUploadDocBmwRenew={

   		 try {
   			def app = BioMedicalWaste.get((params.id).toInteger())

      	    	def certFor="BMW Renew"  
      	    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=?  order by abc.id asc",[certFor])

      	    	
      	     	def listDoc= new ArrayList()
      	    
      	    	def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='BMW Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
      	     	
      	     	 for(int ig=0;ig<applicationDocumentInstance.size();ig++){
      	     		def boolCheck=false
      	     	
      	     		if(listDoc.size()==0){
      	     			
      	     			listDoc.add(applicationDocumentInstance.get(ig))
      	     		}
      	     	
      	     		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
      	     		
      	     			if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description){
      	     				boolCheck=true
      	     			}
      	     		}
      	     		if(boolCheck==false){
      	     			listDoc.add(applicationDocumentInstance.get(ig))
      	     		}
      	     		
      	     	}
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
		    activityRecInstance.status = "BMW Renew Application "+params.id+ " Upload Required Documents Click"
            if(activityRecInstance.save()){		   
              }
            	else{
            		activityRecInstance.errors.each {
			    	println it
			  }
		  }
      			 println("--------uploadedDocList------"+listDoc.size())
      		     return [app:app,appDetId:params.id,docList:docList,uploadedDocList:listDoc]
      	    
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
          
          def popDeleteDocBmw = {
    		 try {
    			    def app =BioMedicalWaste.get((params.id).toInteger())
    	          	def docList = DocumentChecklistMaster.list()
    	       
    	          	def listDoc= new ArrayList()    
    	          	
    	              def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='BMW Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
    	          		println("------applicationDocumentInstance---"+applicationDocumentInstance)
    	          	if(applicationDocumentInstance){
    	          	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
    	          		def boolCheck=false
    	          
    	          		if(listDoc.size()==0){
    	          		
    	          			listDoc.add(applicationDocumentInstance.get(ig))
    	          		}
    	          	
    	          		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	          			
    	          			if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description){
    	          				boolCheck=true
    	          			}
    	          		}
    	          		if(boolCheck==false){
    	          			listDoc.add(applicationDocumentInstance.get(ig))
    	          		}
    	          		
    	          	}
    	        }	
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
    	      	    activityRecInstance.status = "BMW Application "+params.id+ " Delete Saved Documents Click"
    	      	    if(activityRecInstance.save()){		   
    	      	      }
    	      	    	else{
    	      	    		activityRecInstance.errors.each {
    	      		    	println it
    	      		  }
    	      	  }
    	        return [appDetId:params.id,docList:docList,app:app,listDoc:listDoc]
    	       
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
        
        
        def deleteDocs = {
    		 try {
    			    
         		
        	     def app =BioMedicalWaste.get((params.indAppId).toLong())
        	        	
        	        	if((params.delete).getClass().getName()== "java.lang.String"){
        	        		def applicationDocumentInstance = WasteManagementFile.get((params.delete).toLong())
        	        		
        	        		applicationDocumentInstance.delete()
        	        	}else{
        	        		if(params.delete)
        	        		for(int i=0;i<(params.delete).size();i++){
        	        			def applicationDocumentInstance = WasteManagementFile.get((params.delete[i]).toLong())
        	            		
        	            		applicationDocumentInstance.delete()
        	        		}
        	        	}
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
        		    activityRecInstance.activity = "delete"
        		    activityRecInstance.status = "BMW Application "+params.indAppId+ " Document Delete."
        	        if(activityRecInstance.save()){		   
        	          }
        	        	else{
        	        		activityRecInstance.errors.each {
        			    	println it
        			  }
        		  }
        	        	redirect(action:popDeleteDocBmw,id:app)
        	        
        		
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

        def saveEditNewFormat={
    		 try {
    			   println("params----"+params) 
         		def totalfee = 0.0
         		def editableMode = params.editableMode
         		 println("editableMode----"+editableMode)
    			 def testValue=params.testValue  
    			 println("testValue----"+testValue)
             	def industryId = session.indUser
             	if(industryId==null || industryId=="")
                 {
                       redirect(controller:"userMaster",action:"logout")
                       return
                 }
             	
             
             	def appFor="BMW"
             	def indusrtyInstance=IndustryRegMaster.get((params.indRegId).toLong())
             	IndUser indUserInstance=(IndUser)session.indUser
             	def indRegInstance=indUserInstance.industryRegMaster
            ////////////////////Start/////////////////////////Vivek///////////////////////////////// 
             	def proceedOk=true
             	def checkPend=params.appStatus

             	
             	if(!proceedOk){
             		 flash.message = "BioMedicalWaste application is already submitted and in pending state."
             	            redirect(action:showNewFormat,id:params.bioMedId)
             	            return
             	}else{
          
                 
             	def bioMedicalWasteInstance = BioMedicalWaste.get((params.bioMedId).toLong())
             	bioMedicalWasteInstance.industryRegMasterObj=indusrtyInstance
             	
            
             		def dateCheck=params.prevauthDate_value
                 	def x
                 	def sqlCurrentDate
                 	def currentDate=new Date()
                 	DateCustom dd=new DateCustom()
         	    	if(dateCheck)
         	    	{
         	    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
         	    	x= sdfh.parse(dateCheck);

         	    	}
             	

             		def dateCheck1=params.prevexpDate_value
                 	def y
                 	def sqlCurrentDate1
                 	def currentDate1=new Date()
                 	DateCustom dd1=new DateCustom()
         	    	if(dateCheck1)
         	    	{
         	    	def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
         	    	y= sdfh1.parse(dateCheck1);
         	    	
         	    	}
             	
                 	bioMedicalWasteInstance.nameOfApplicant=params.nameOfApplicant
                 	bioMedicalWasteInstance.nameOfInstitution=params.nameOfInstitution
                 
                 	def flag
                 
                 	bioMedicalWasteInstance.createdBy=indRegInstance.indName        	
                 	bioMedicalWasteInstance.isNewApplication=true
                 	String authReqFor=""
             			
                 		if(params['checkboxGeneration']=="on") {
             				authReqFor=authReqFor.concat("Generation, segregation")
             				authReqFor=authReqFor.concat(",")
             			}
                 	
             			if(params['checkboxCollection']=="on") {
             				authReqFor=authReqFor.concat("Collection")
             				authReqFor=authReqFor.concat(",")
             			}
             			
             			if(params['checkboxStorage']=="on") {
             				authReqFor=authReqFor.concat("Storage")
             				authReqFor=authReqFor.concat(",")
             			}
             			
             			
             			if(params['checkboxPackaging']=="on") {
             				authReqFor=authReqFor.concat("Packaging")
             				authReqFor=authReqFor.concat(",")
             			}
             			
             			if(params['checkboxReception']=="on") {
             				authReqFor=authReqFor.concat("Reception")
             				authReqFor=authReqFor.concat(",")
             			}
             			
             			if(params['checkboxTransportation']=="on") {
             				authReqFor=authReqFor.concat("Transportation")
             				authReqFor=authReqFor.concat(",")
             			}
             			if(params['checkboxTreatment']=="on") {
             				authReqFor=authReqFor.concat("Treatment or processing or conversion")
             				authReqFor=authReqFor.concat(",")
             			}
             			

         				if(params['checkboxRecycling']=="on") {
         				authReqFor=authReqFor.concat("Recycling")
         				authReqFor=authReqFor.concat(",")
         			}
         			if(params['checkboxDisposal']=="on") {
         				authReqFor=authReqFor.concat("Disposal or destruction use")
         				authReqFor=authReqFor.concat(",")
         			}
         			if(params['checkboxOffering']=="on") {
         				authReqFor=authReqFor.concat("Offering for sale, transfer")
         				authReqFor=authReqFor.concat(",")
         			}
         			if(params['checkboxAnyother']=="on") {
         				authReqFor=authReqFor.concat("Any Other Form Of Handling")
         				authReqFor=authReqFor.concat(",")
         			}
         			
             			
             			authReqFor = authReqFor.substring(0, authReqFor.length() - 1);

             			
             			 bioMedicalWasteInstance.activityAuthorizationSoughtFor=authReqFor
                 	
             	    bioMedicalWasteInstance.authorisationAppliedFor=params.authorisationAppliedFor

             		if(params.hcfType){
             		bioMedicalWasteInstance.hcfType=params.hcfType
             		}else{
             			bioMedicalWasteInstance.hcfType=""
             		}
             		if(params.hcfTypeMenu){
                 	bioMedicalWasteInstance.hcfTypeMenu=params.hcfTypeMenu
             		}
             		else{
             			bioMedicalWasteInstance.hcfTypeMenu=""
             		}
             		if(params.bmwfacility){
                 	bioMedicalWasteInstance.bmwfacility=params.bmwfacility
             		}else{
             			bioMedicalWasteInstance.bmwfacility=""
             		}
             		
             		
             		if(params.hcfType){

                     	bioMedicalWasteInstance.bmwstatus=params.bmwstatus
                     	bioMedicalWasteInstance.wastelocationaddress=params.wastelocationaddress
                 	}else{
                 		bioMedicalWasteInstance.bmwstatus=""
                     	bioMedicalWasteInstance.wastelocationaddress=""
                 	}


             		if(params.outpatientsFacility){
                 	bioMedicalWasteInstance.outpatientsFacility=params.outpatientsFacility
             		}else{
             			bioMedicalWasteInstance.outpatientsFacility=""
             		}
             		if(params.inpatientsFacility){
                 	bioMedicalWasteInstance.inpatientsFacility=params.inpatientsFacility
             		}else{
             			bioMedicalWasteInstance.inpatientsFacility=""
             		}
             		if(params.noofbeds){
                 	bioMedicalWasteInstance.noofbeds=params.noofbeds
             		}else{
             			bioMedicalWasteInstance.noofbeds=""
             		}
             		if(params.other1){
                 	bioMedicalWasteInstance.other1=params.other1
             		}else{
             			bioMedicalWasteInstance.other1=""
             		}
             		if(params.other2){
                 	bioMedicalWasteInstance.other2=params.other2
             		}else{
             			bioMedicalWasteInstance.other2=""
             		}
             		if(params.patientspermonth){
                 	bioMedicalWasteInstance.patientspermonth=params.patientspermonth
             		}else{
             			bioMedicalWasteInstance.patientspermonth=""
             		}
                 	if(params.destroyer){
                 	bioMedicalWasteInstance.destroyer=params.destroyer
                 	}
                 	else{
                 		bioMedicalWasteInstance.destroyer=""
                 	}
                 	if(params.bmwrules1){
                 	bioMedicalWasteInstance.bmwrules1=params.bmwrules1
                 	}
                 	else{
                 		bioMedicalWasteInstance.bmwrules1=""
                 	}
                 	if(params.NoofHCF){
                 	bioMedicalWasteInstance.NoofHCF=params.NoofHCF
                 	}else{
                 		bioMedicalWasteInstance.NoofHCF=""
                 	}
                 	if(params.Jurisdictionalarea){
                 	bioMedicalWasteInstance.Jurisdictionalarea=params.Jurisdictionalarea
                 	}else{
                 		bioMedicalWasteInstance.Jurisdictionalarea=""
                 	}
                 	if(params.authorisationDay){
                 	bioMedicalWasteInstance.authorisationDay=params.authorisationDay
                 	}else{
                 		bioMedicalWasteInstance.authorisationDay=""
                 	}
                 	
                 	bioMedicalWasteInstance.authorisationMonth=""
                 
                 	bioMedicalWasteInstance.detailapc=""
                 	if(params.detailetp){
                 	bioMedicalWasteInstance.detailetp=params.detailetp
                 	}else{
                 		bioMedicalWasteInstance.detailetp=""
                 	}
                 	bioMedicalWasteInstance.quantityperDay=""
                 	bioMedicalWasteInstance.quantityperMonth=""
                 	bioMedicalWasteInstance.quantityperDay1=""
                 	bioMedicalWasteInstance.quantityperMonth1=""
          
//                 	added by sharvan start
                 	if(params.authapply){
                     	bioMedicalWasteInstance.authapply=params.authapply
                     	}
                     	else{
                     		bioMedicalWasteInstance.authapply=""
                     	}
                 	// added by sharvan end
                 	if(params.anatomicalwaste){
                 	bioMedicalWasteInstance.anatomicalwaste=params.anatomicalwaste
                 	}else{
                 		bioMedicalWasteInstance.anatomicalwaste=""
                 	}
                 	if(params.animalwaste){
                 	bioMedicalWasteInstance.animalwaste=params.animalwaste
                 	}else{
                 		bioMedicalWasteInstance.animalwaste=""
                 	}
                 	if(params.biowaste){
                 	bioMedicalWasteInstance.biowaste=params.biowaste
                 	}else{
                 		bioMedicalWasteInstance.biowaste=""
                 	}
                 	
                 	if(params.wastesharp){
                 	bioMedicalWasteInstance.wastesharp=params.wastesharp
                 	}else{
                 		bioMedicalWasteInstance.wastesharp=""
                 	}
                 	if(params.discardedwaste){
                 	bioMedicalWasteInstance.discardedwaste=params.discardedwaste
                 	}else{
                 		bioMedicalWasteInstance.discardedwaste=""
                 	}
                 	if(params.soiledwaste){
                 	bioMedicalWasteInstance.soiledwaste=params.soiledwaste
                 	}else{
                 		bioMedicalWasteInstance.soiledwaste =""
                 	}
         			if(params.total1){
                 	bioMedicalWasteInstance.total1=params.total1
         			}else{
         				bioMedicalWasteInstance.total1=""
         			}
                 
                 	/*if(testValue=="true"){
                 	bioMedicalWasteInstance.completionStatus="Completed"
                 	}else{
                 	bioMedicalWasteInstance.completionStatus="Inprogress"
                 	}*/
                   bioMedicalWasteInstance.clarification=false
                 	bioMedicalWasteInstance.inspection=false
                 	bioMedicalWasteInstance.updatedBy=""
                 	if(testValue=="true"){
                 		println("--if tyest value true-"+bioMedicalWasteInstance.applicationStatus)
                 		bioMedicalWasteInstance.applicationStatus=bioMedicalWasteInstance.applicationStatus
                 	}else{
                 		println("--else tyest value ---"+bioMedicalWasteInstance.applicationStatus+"-----"+testValue)
                 	bioMedicalWasteInstance.applicationStatus=params.appStatus
                 	}
                 		def industryRegInstanceWaste=indRegInstance
                 		
//                 		added by sharvan for new changes 
                     	if(params.statusCteCto){
                     	bioMedicalWasteInstance.statusCteCto= params.statusCteCto
                     	}else{
                     		bioMedicalWasteInstance.statusCteCto=""
                     	}
                     	if(params.latitude){
                     	bioMedicalWasteInstance.latitude=params.latitude
                     	}else{
                     		bioMedicalWasteInstance.latitude=""
                     	}
                     	bioMedicalWasteInstance.longtitude=params.longtitude
                     	bioMedicalWasteInstance.detailsOfDirections=params.detailsOfDirections

                     	if(params.noOfNonBeds){
                     	bioMedicalWasteInstance.noOfNonBeds=params.noOfNonBeds
                     	}else{
                     		bioMedicalWasteInstance.noOfNonBeds=""
                     	}
                     	if(params.noOfNonBeds1){
                     	bioMedicalWasteInstance.noOfNonBeds1=params.noOfNonBeds1
                     	}else{
                     		bioMedicalWasteInstance.noOfNonBeds1==""
                     	}
                     	if(params.noOfInOutPatients){
                     	bioMedicalWasteInstance.noOfInOutPatients=params.noOfInOutPatients
                     	}else{
                     		bioMedicalWasteInstance.noOfInOutPatients=""
                     	}
                     	if(params.colorCodedBags){
                     	bioMedicalWasteInstance.colorCodedBags=params.colorCodedBags
                     	}else{
                     		bioMedicalWasteInstance.colorCodedBags=""
                     	}
                     	if(params.NoofBedsCbmwtf){
                     	bioMedicalWasteInstance.noOfBedsCbmwtf=params.NoofBedsCbmwtf
                     	}else{
                     		bioMedicalWasteInstance.noOfBedsCbmwtf=""
                     	}
                     	if(params.treatmentAndDisposal){
                     	bioMedicalWasteInstance.treatmentAndDisposal=params.treatmentAndDisposal
                     	}else{
                     		bioMedicalWasteInstance.treatmentAndDisposal=""
                     	}
                     	if(params.qtyOfBmwTreated){
                     	bioMedicalWasteInstance.qtyOfBmwTreated=params.qtyOfBmwTreated
                     	}else{
                     		bioMedicalWasteInstance.qtyOfBmwTreated=""
                     	}
                     	if(params.contingencyPlan){
                     	bioMedicalWasteInstance.contingencyPlan=params.contingencyPlan
                     	}else{
                     		bioMedicalWasteInstance.contingencyPlan=""
                     	}
                     	if(params.hcfType=="HCF"){
                         	if(params.detailsOfTraining){
                         		bioMedicalWasteInstance.detailsOfTraining=params.detailsOfTraining
                         	}else{
                         		bioMedicalWasteInstance.detailsOfTraining=""
                         		}
                         	}else{
                         	
                         		if(params.detailsOfTraining1){
                         		bioMedicalWasteInstance.detailsOfTraining=params.detailsOfTraining1
                         	}else{
                         		bioMedicalWasteInstance.detailsOfTraining=""
                         		}
                         	}
                     	if(params.incinrators){
                     	bioMedicalWasteInstance.incinrators=params.incinrators
                     	}else{
                     		bioMedicalWasteInstance.incinrators=""
                     	}
                     	if(params.incinratorsType){
                     	bioMedicalWasteInstance.incinratorsType=params.incinratorsType
                     	}else{
                     		bioMedicalWasteInstance.incinratorsType=""
                     	}
                     	if(params.plasmaPyrolysis){
                     	bioMedicalWasteInstance.plasmaPyrolysis=params.plasmaPyrolysis
                     	}else{
                     		bioMedicalWasteInstance.plasmaPyrolysis=""
                     	}
                     	if(params.plasmaPyrolysisType){
                     	bioMedicalWasteInstance.plasmaPyrolysisType=params.plasmaPyrolysisType
                     	}else{
                     		bioMedicalWasteInstance.plasmaPyrolysisType=""
                     	}
                     	if(params.autoclaves){
                     	bioMedicalWasteInstance.autoclaves=params.autoclaves
                     	}else{
                     		bioMedicalWasteInstance.autoclaves=""
                     	}
                     	if(params.autoclavesType){
                     	bioMedicalWasteInstance.autoclavesType=params.autoclavesType
                     	}else{
                     		bioMedicalWasteInstance.autoclavesType=""
                     	}
                     	if(params.microwave){
                     	bioMedicalWasteInstance.microwave=params.microwave
                     	}else{
                     		bioMedicalWasteInstance.microwave=""
                     	}
                     	if(params.microwaveType){
                     	bioMedicalWasteInstance.microwaveType=params.microwaveType
                     	}else{
                     		bioMedicalWasteInstance.microwaveType=""
                     	}
                     	if(params.hydroclave){
                     	bioMedicalWasteInstance.hydroclave=params.hydroclave
                     	}else{
                     		bioMedicalWasteInstance.hydroclave=""
                     	}
                     	if(params.hydroclaveType){
                     	bioMedicalWasteInstance.hydroclaveType=params.hydroclaveType
                     	}else{
                     		bioMedicalWasteInstance.hydroclaveType=""
                     	}
                     	if(params.shredders){
                     	bioMedicalWasteInstance.shredders=params.shredders
                     	}else{
                     		bioMedicalWasteInstance.shredders=""
                     	}
                     	if(params.shreddersType){
                     	bioMedicalWasteInstance.shreddersType=params.shreddersType
                     	}else{
                     		bioMedicalWasteInstance.shreddersType=""
                     	}
                     	if(params.needleTipCutter){
                     	bioMedicalWasteInstance.needleTipCutter=params.needleTipCutter
                     	}else{
                     		bioMedicalWasteInstance.needleTipCutter=""
                     	}
                     	if(params.needleTipCutterType){
                     	bioMedicalWasteInstance.needleTipCutterType=params.needleTipCutterType
                     	}else{
                     		bioMedicalWasteInstance.needleTipCutterType=""
                     	}
                     	if(params.sharpEncapsulation){
                     	bioMedicalWasteInstance.sharpEncapsulation=params.sharpEncapsulation
                     	}else{
                     		bioMedicalWasteInstance.sharpEncapsulation=""
                     	}
                     	if(params.sharpEncapsulationType){
                     	bioMedicalWasteInstance.sharpEncapsulationType=params.sharpEncapsulationType
                     	}else{
                     		bioMedicalWasteInstance.sharpEncapsulationType=""
                     	}
                     	if(params.deepBurial){
                     	bioMedicalWasteInstance.deepBurial=params.deepBurial
                     	}else{
                     		bioMedicalWasteInstance.deepBurial=""
                     	}
                     	if(params.deepBurialType){
                     	bioMedicalWasteInstance.deepBurialType=params.deepBurialType
                     	}else{
                     		bioMedicalWasteInstance.deepBurialType=""
                     	}
                     	if(params.chemDisinfection){
                     	bioMedicalWasteInstance.chemDisinfection=params.chemDisinfection
                     	}else{
                     		bioMedicalWasteInstance.chemDisinfection=""
                     	}
                     	if(params.chemDisinfectionType){
                     	bioMedicalWasteInstance.chemDisinfectionType=params.chemDisinfectionType
                     	}else{
                     		bioMedicalWasteInstance.chemDisinfectionType=""
                     	}
                     	if(params.anyOtherTreatmentEquip){
                     	bioMedicalWasteInstance.anyOtherTretmntEquip=params.anyOtherTreatmentEquip
                     	}else{
                     		bioMedicalWasteInstance.anyOtherTretmntEquip=""
                     	}
                     	if(params.anyOtherTretmntEquipType){
                     	bioMedicalWasteInstance.anyOtherTretmntEquipType=params.anyOtherTretmntEquipType
                     	}else{
                     		bioMedicalWasteInstance.anyOtherTretmntEquipType=""
                     	}
                     	if(params.chemicalSolidWaste){
                     	bioMedicalWasteInstance.chemicalSolidWaste=params.chemicalSolidWaste
                     	}else{
                     		bioMedicalWasteInstance.chemicalSolidWaste=""
                     	}
                     	if(params.chemicalLiquidWaste){
                     	bioMedicalWasteInstance.chemicalLiquidWaste=params.chemicalLiquidWaste
                     	}else{
                     		bioMedicalWasteInstance.chemicalLiquidWaste=""
                     	}
                     	if(params.discardedLinen){
                     	bioMedicalWasteInstance.discardedLinen=params.discardedLinen
                     	}else{
                     		bioMedicalWasteInstance.discardedLinen=""
                     	}
                     	if(params.otherClinicLabWaste){
                     	bioMedicalWasteInstance.otherClininLabWaste=params.otherClinicLabWaste
                     	}else{
                     		bioMedicalWasteInstance.otherClininLabWaste=""
                     	}
                     	if(params.contaminatedWaste){
                     	bioMedicalWasteInstance.contaminatedwaste=params.contaminatedWaste
                     	}else{
                     		bioMedicalWasteInstance.contaminatedwaste=""
                     	}
                     	if(params.wasteSharps){
                     	bioMedicalWasteInstance.wasteSharps=params.wasteSharps
                     	}else{
                     		bioMedicalWasteInstance.wasteSharps=""
                     	}
                     	if(params.glassWare){
                     	bioMedicalWasteInstance.glassWare=params.glassWare
                     	}else{
                     		bioMedicalWasteInstance.glassWare=""
                     	}
                     	if(params.metallicBodyImplants){
                     	bioMedicalWasteInstance.metallicBodyImplants=params.metallicBodyImplants
                     	}else{
                     		bioMedicalWasteInstance.metallicBodyImplants=""
                     	}	
                     		// added by sharvan end here
                       
                     	 def consentFeeMasterInstance = new ConsentFeeMasterBMW()
         	    			
         		     		def calculatedfee = ConsentFeeMasterBMW.findByApplication(bioMedicalWasteInstance)
         		     		
         		     		if(calculatedfee){
         		     			
         		     			calculatedfee.delete()
         		     			
         		     		}
         		     		consentFeeMasterInstance.application = bioMedicalWasteInstance
         		     		if(params.yearsApplied != ""){
         		     			println("------yearsApplied----1"+params.yearsApplied)
         		     			consentFeeMasterInstance.noOfYears = (params.yearsApplied).toLong()
         		     		}
         		     		else{
         		     			consentFeeMasterInstance.noOfYears = 0
         		     		}
         		     			
         		     		if(params.feeApplicable != ""){
         		     			consentFeeMasterInstance.calculatedFee = (params.feeApplicable).toFloat()
         		     		
         		     		}
         		     		else{
         		     			consentFeeMasterInstance.calculatedFee = 0
         		     		}
         		     		if(consentFeeMasterInstance.save())
         		     		{

         		     		}else{
         		     			consentFeeMasterInstance.errors.each{
         		     				println it;
         		     			}
         		     		}
         		     		
                 		
                     		
             	   if(params.appStatus=="Inprogress"){
                 				
                 		
                 				flash.message = "BioMedicalWaste Application No ${bioMedicalWasteInstance.id} is Available for Future modification"
                 				
                 					if((bioMedicalWasteInstance.cafUniqueNo!="") && (bioMedicalWasteInstance.cafUniqueNo!=null)){
                     					Response responsePush=new Response()
                     					String consentAppNo=bioMedicalWasteInstance.id.toString();
                     					String cafNo=bioMedicalWasteInstance.cafUniqueNo
                     					String serviceId=bioMedicalWasteInstance.serviceId
                     					String applicationType="BMW"
                     						String applicationFor1=""
                     					if(bioMedicalWasteInstance.authorisationAppliedFor=="fresh"){
                     						applicationFor1="Fresh"
                     					}else if(bioMedicalWasteInstance.authorisationAppliedFor=="renew")
                     					{
                     						applicationFor1="Renew"
                     					}
                     					String statusCode="I"
                     					String appRemarks="Application Saved as draft"
                     					String pendingWith=""
                     					String pendingWithRole=""
                     					String printAppUrl=""
                     					String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+bioMedicalWasteInstance.industryRegMasterObj.indName+"&indDistrict="+bioMedicalWasteInstance.industryRegMasterObj.district.districtName+"&serviceCode="+bioMedicalWasteInstance.serviceId+"&cafUniqueNo="+bioMedicalWasteInstance.cafUniqueNo
                     					String certificateUrl=""
                     					
                     					responsePush.sendStatus( consentAppNo, cafNo, serviceId, applicationType, applicationFor1, statusCode, appRemarks, pendingWith, pendingWithRole, printAppUrl, revertedUrl, certificateUrl)
                     				}
                 				
                 				
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
                 	            activityRecInstance.status = "BMW Application ${bioMedicalWasteInstance.id} updated."
                 	            if(activityRecInstance.save()){		   
                 	              }
                 	            	else{
                 	            		activityRecInstance.errors.each {
                 				    	println it
                 				  }
                 			  }
                         	
                 				redirect(action:showNewFormat,id:bioMedicalWasteInstance.id)
                 				return;
                 				
                 			}
                 			if(params.appStatus=="Completed"){
                 				
                 				
                 				 def feesinstance = FeeBankOtherDetailsBMW.find("from FeeBankOtherDetailsBMW fee where fee.application=?",[bioMedicalWasteInstance])

                    				/*if(!feesinstance){
                    					flash.message = "Please enter Bank fee Detail"
                    					bioMedicalWasteInstance.completionStatus="Inprogress"
                        				bioMedicalWasteInstance.save()
                    					redirect(action:showNewFormat,id:bioMedicalWasteInstance.id)
                    					return;
                    				}*/
                 				 
                 				 
                 				 def feeListBMW=FeeBankOtherDetailsBMW.findAllByApplication(bioMedicalWasteInstance)
                  	    		
                  	    		
                  	        	
                  	        	for(int i=0;i<feeListBMW.size();i++)
                  	        	{
                  	        		totalfee = totalfee + feeListBMW.get(i).amount
                  	        	}

                  			  

                 				def bioId=bioMedicalWasteInstance.id

                 				def bioIdInstance=BioMedicalWaste.get(bioId)

                 				
                 				
                 				////////////////// For Routing application /////////////////
                 				
             				
             				
//             			       Document mandetory code Added by Deepak             	
                     			
                 				
             				    def dcCkeck
             				    def applicationFordoc
             					ArrayList strList = new ArrayList()
                 				
                 				if(bioMedicalWasteInstance.authorisationAppliedFor=="fresh"){
             						applicationFordoc="BMW Fresh"
             					}else if(bioMedicalWasteInstance.authorisationAppliedFor=="renew")
             					{
             						applicationFordoc="BMW Renew"
             					}
                 				println("applicationFordoc---bmw-edit-"+applicationFordoc)

             					dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor= ? ",[applicationFordoc])
             					//println("dcCkeck---bmw--"+dcCkeck)
             				
             			//	dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.consentFor='BMW' and doc.isMandatory='Yes' and doc.isNewApplication='true'")
        					for(int i=0;i<dcCkeck.size();i++)
        					{
        						if(((dcCkeck.get(i)).isMandatory).equalsIgnoreCase("Yes"))
        						{
        							def isOrNot = WasteManagementFile.find("from WasteManagementFile abc where abc.description=? and abc.applicationId=?",[(dcCkeck.get(i)).document,bioMedicalWasteInstance.id])
        							if(!isOrNot)
        							  strList.add(dcCkeck.get(i).document+"\n")
        						}
        					}
        				   if(strList)
        					{
        						def strr = "Please Upload following documents:\n"
        				        for(int i=0;i<strList.size();i++)
        				    		{
        				        		strr += ("("+(i+1)+"). "+strList.get(i)).toString()+"\n"
        				    		}
        				        flash.message = strr
        				        bioMedicalWasteInstance.completionStatus = "Inprogress"
        				        bioMedicalWasteInstance.save(flush:true)	
        						redirect(action:editNewFormat,id:bioMedicalWasteInstance.id)
        						return ;
        					}
        				   //============================================================//

             			

             		   
             				
             				
             				
             				
             	//////////////////////////// For getting Receiving officer Name//////////////////////////////def investCap1 =  hazardeousWasteAuthAppInstance.industryRegMasterObj.indCapInvt
                 				def investCap1 =  bioMedicalWasteInstance.industryRegMasterObj.indCapInvt

             					def indSize
                 				String office
                 				def roleNameForpdf
                 				def grp
                 			
                 				
                 				def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
                 				
                 					for(int i=0;i<roleVsActList.size();i++){
                 		    	if(((roleVsActList.get(i)).role).group == grp){
                 		    		roleNameForpdf = (roleVsActList.get(i)).role.roleName
                 		    	}
                 					}
 			
             				
                 				
                 								///////////////////////////////////////  Code for generating File Number /////////////////////////
               def indApplInst=bioMedicalWasteInstance

         		def industryRegMasterInstance=IndustryRegMaster.get(indApplInst.industryRegMasterObj.id)

         		def districtOfiiceMasterInstance= ""

         		
         		
         		//added by sharvan start
         		 def jurisdictionOfficeName=""
         			def sdfh = new SimpleDateFormat("dd/MM/yyyy");   
         		def fileNoArrayList=new ArrayList()
         		def fileNoString
         		def fileNoSize
         		def fileNoValue
         		def fileNo
                 
         	        			 
               
                 	def activityAuthorizationSoughtFor = bioMedicalWasteInstance.activityAuthorizationSoughtFor
             		def phnCodeOfOccupier = indRegInstance.occPhoneCode
             		def phnOfOccupier = indRegInstance.occPhoneNo
             		def faxCodeOfOccupier = indRegInstance.occFaxCode
             		def faxOfOccupier = indRegInstance.occFaxNo
             		def emailOfOccupier = indRegInstance.occEmail
             		def applicantName = indRegInstance.occName

         				
             		def applicantDesignation
             		if(indRegInstance.occDesignation=="Others"){
             			applicantDesignation=indRegInstance.otherOccDesignation
             		}else{
             			applicantDesignation=indRegInstance.occDesignation
             		}
             		def instutionName = indRegInstance.indName

             		def addressOfInd = indRegInstance.indAddress

             		def phnCodeOfInd = indRegInstance.indPhoneCode

             		def phnOfInd = indRegInstance.indPhoneNo

             		def faxCodeOfInd = indRegInstance.indFaxCode

             		def faxOfInd = indRegInstance.indFaxNo

             		def emailOfInd = indRegInstance.occEmail

             		//added by sharvan for mobile no 
             		def mobileNo=indRegInstance.occMobile
             		
             		def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
             		def district = cat.district.districtName
             		def applFor12
                     def authorisationFor =bioMedicalWasteInstance.activityAuthorizationSoughtFor
                     def appliedFor=bioMedicalWasteInstance.authorisationAppliedFor
                     if(bioMedicalWasteInstance.authorisationAppliedFor=="renew"){
                     	appliedFor="Renewal"
                     	applFor12="BMW Renew"
                     }else{
                     	appliedFor="Fresh"
                     	applFor12="BMW Fresh"
                     }
             		
             		def hcfType=bioMedicalWasteInstance.hcfType
             		def wasteFacilityStatus=bioMedicalWasteInstance.bmwfacility
                     def officeAddress=bioMedicalWasteInstance.bmwstatus
                     def wasteLocationAddress=bioMedicalWasteInstance.wastelocationaddress
                     def placeOfTreatment=""
                     def placeOfDisposal=""
                     
                     	 // new changes made by sharvan start from here
                     	 def appNo=bioMedicalWasteInstance.id
                         def statusCteCto=bioMedicalWasteInstance.statusCteCto
                         def lat=bioMedicalWasteInstance.latitude
                         def longt=bioMedicalWasteInstance.longtitude
                         def detailsOfDirections=bioMedicalWasteInstance.detailsOfDirections
                         //Details Of HCF added by sharvan as per new rules
                         def outpatientsFacility=bioMedicalWasteInstance.outpatientsFacility
                         def inpatientsFacility=bioMedicalWasteInstance.inpatientsFacility
                         def noofbeds=bioMedicalWasteInstance.noofbeds
                         def noOfNonBeds=bioMedicalWasteInstance.noOfNonBeds
                         def noOfInOutPatients=bioMedicalWasteInstance.noOfInOutPatients
                         // Details Of CBMWTF added by sharvan as per new rules
                         def NoofHCF=bioMedicalWasteInstance.NoofHCF
                         def noOfBedsCbmwtf=bioMedicalWasteInstance.noOfBedsCbmwtf
                         def treatmentAndDisposal=bioMedicalWasteInstance.treatmentAndDisposal
                         def qtyOfBmwTreated=bioMedicalWasteInstance.qtyOfBmwTreated
                         def Jurisdictionalarea=bioMedicalWasteInstance.Jurisdictionalarea
                         def contingencyPlan=bioMedicalWasteInstance.contingencyPlan
                         //new changes ends here
                        
                    //////////////// Table in PdF /////////////////
                    def anatomicalwaste=bioMedicalWasteInstance.anatomicalwaste
                    def animalwaste=bioMedicalWasteInstance.animalwaste
                    def biowaste=""
                    def wastesharp=""
                    def discardedwaste=bioMedicalWasteInstance.discardedwaste
                    def soiledwaste=bioMedicalWasteInstance.soiledwaste
                    def solidwaste=""
                    
                    def chemicalSolidWaste=bioMedicalWasteInstance.chemicalSolidWaste
                    def chemicalLiquidWaste=bioMedicalWasteInstance.chemicalLiquidWaste
                    def discardedLinen=bioMedicalWasteInstance.discardedLinen
                    def otherClininLabWaste=bioMedicalWasteInstance.otherClininLabWaste
                    def contaminatedwaste=bioMedicalWasteInstance.contaminatedwaste
                    def wasteSharps=bioMedicalWasteInstance.wasteSharps
                    def glassWare=bioMedicalWasteInstance.glassWare
                    def metallicBodyImplants=bioMedicalWasteInstance.metallicBodyImplants
                    
                    def liquidwaste=""
              
                    def ash=""
                    def chemicalwaste=""
                    def chemicalwaste1=""
                    def chemicalwaste2=""
                    def total1=bioMedicalWasteInstance.total1
                    def total2=""
                    
////                 	added by sharvan start
                        //table in pdf for screen 4 added by sharvan start from here
                        def incinrators=bioMedicalWasteInstance.incinrators
                        def incinratorsType=bioMedicalWasteInstance.incinratorsType
                        def plasmaPyrolysis=bioMedicalWasteInstance.plasmaPyrolysis
                        def plasmaPyrolysisType=bioMedicalWasteInstance.plasmaPyrolysisType
                        def autoclaves=bioMedicalWasteInstance.autoclaves
                        def autoclavesType=bioMedicalWasteInstance.autoclavesType
                        def microwave=bioMedicalWasteInstance.microwave
                        def microwaveType=bioMedicalWasteInstance.microwaveType
                        def hydroclave=bioMedicalWasteInstance.hydroclave
                        def hydroclaveType=bioMedicalWasteInstance.hydroclaveType
                        def shredders=bioMedicalWasteInstance.shredders
                        def shreddersType=bioMedicalWasteInstance.shreddersType
                        def needleTipCutter=bioMedicalWasteInstance.needleTipCutter
                        def needleTipCutterType=bioMedicalWasteInstance.needleTipCutterType
                        def sharpEncapsulation=bioMedicalWasteInstance.sharpEncapsulation
                        def sharpEncapsulationType=bioMedicalWasteInstance.sharpEncapsulationType
                        def deepBurial=bioMedicalWasteInstance.deepBurial
                        def deepBurialType=bioMedicalWasteInstance.deepBurialType
                        def chemDisinfection=bioMedicalWasteInstance.chemDisinfection
                        def chemDisinfectionType=bioMedicalWasteInstance.chemDisinfectionType
                        def anyOtherTretmntEquip=bioMedicalWasteInstance.anyOtherTretmntEquip
                        def anyOtherTretmntEquipType=bioMedicalWasteInstance.anyOtherTretmntEquipType
                        //table in pdf for screen 4 added by sharvan end here
                        
////                added by sharvan start
                   	SimpleDateFormat formatNowYear = new SimpleDateFormat("dd/MM/yyyy");
             		def BMWApplicationDate=formatNowYear.format(bioMedicalWasteInstance.dateCreated)
                	
////////////////////////////////             / Endss////////////////////////////////////
                   
            ///////////////////////////////////// Previous BMW Authorisation Details Table /////////////////////////////			
         		    def hwPreviousAuthDetails = new ArrayList()	

         			 def hwPreviousAuthDetailsList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails s where s.indUser.id=? and s.wasteManagementFileId!='' order by to_date(Issued_date, 'dd/mm/yyyy') ",[bioMedicalWasteInstance.industryRegMasterObj.id])
         			
         			 for(int var33=0;var33<hwPreviousAuthDetailsList.size();var33++)
         				{
         					def hwmPreviousAuthorisationList= new ArrayList()
         					
         					
         				    hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).BMWApplication_Date)
         					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).BMWAType)
         					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).AuthorisationNo)
         					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Issued_date)
         					hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Valid_date)
         					

         					hwPreviousAuthDetails.add(hwmPreviousAuthorisationList)
         					
         				}	

             		def bmwAppPdfFile=WasteManagementFile.findAll("from WasteManagementFile wm where wm.applicationId=? and wm.typeOfFile='BmwForm'",[bioMedicalWasteInstance.id])
             		if(bmwAppPdfFile.size()>0){
             			for(int i=0;i<bmwAppPdfFile.size();i++){
             				bmwAppPdfFile[i].delete()
             			}
             		}
             	   //-----------------fees---------------------//

                    def feeList= new ArrayList()
            		def feeDetailsList=FeeBankDetailsBMW.findAllByApplication(bioMedicalWasteInstance)
            		println("feeDetailsList"+feeDetailsList)
            		for(int var2=0;var2<feeDetailsList.size();var2++)
            		{
            			def feeDetails= new ArrayList()
            			feeDetails.add(feeDetailsList.get(var2).bankName)
            			feeDetails.add(feeDetailsList.get(var2).branch)
            			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
            			feeDetails.add(feeDetailsList.get(var2).date)
            			feeDetails.add((feeDetailsList.get(var2).amount).toString())
            			feeList.add(feeDetails)
            		
            		}
                           	
                        
                    def onlineFee=new ArrayList()
                    def onlineFeeList=BankTransactionDetailsBMW.findAll("from BankTransactionDetailsBMW bm where bm.bioApplication=? and bm.transactionStatus='S'",[bioMedicalWasteInstance])
                       for(int var88=0;var88<onlineFeeList.size();var88++){
                       	def onlineFeeDetails=new ArrayList()
                       	onlineFeeDetails.add((onlineFeeList.get(var88).id).toString())
                       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                       	String dateCreated1=sdf.format(onlineFeeList.get(var88).dateCreated);
                       	onlineFeeDetails.add(dateCreated1)
                       	onlineFeeDetails.add((onlineFeeList.get(var88).amount).toString())
                       	onlineFeeDetails.add("Successful")
                       	onlineFee.add(onlineFeeDetails)
                       }
                        
                        //----------------------end code----------------//
         						
         	///////////////////////////////////// ENDSSSSSSSSSSSSS //////////////////////////////////////////// 



                       	
                    String str3 = district.toLowerCase();
                     char[] c3 = str3.toCharArray();
                     c3[0] = Character.toUpperCase(c3[0]);
                     district=c3.toString()
             		
             		def listDoc= new ArrayList()
             	   	 
             		def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.applicationId=? and apd.typeOfFile='BMW Documents' and apd.applicationFor=? order by apd.id asc",[bioMedicalWasteInstance.id,applFor12])
                 	
                 	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
                 		def boolCheck=false

                 		if(listDoc.size()==0){

                 			listDoc.add(applicationDocumentInstance.get(ig))
                 		}

                 		for(int intCheck=0;intCheck<listDoc.size();intCheck++){

                 			if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description){

                 				boolCheck=true
                 			}
                 		}
                 		if(boolCheck==false){

                 			listDoc.add(applicationDocumentInstance.get(ig))
                 		}
                 	}
             	
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
     	            activityRecInstance.status = "BMW Application ${bioMedicalWasteInstance.id} updated."
     	            if(activityRecInstance.save()){		   
     	              }
     	            	else{
     	            		activityRecInstance.errors.each {
     				    	println it
     				  }
     			  }
             	
             		 def listDocuments = new ArrayList()
                 		listDocuments.add(listDoc.description)

                 				
             		          BmwPdfFileNewFormat  pdf = new BmwPdfFileNewFormat()

                 				
                 				File certFile1

                          certFile1 = pdf.bmwPdfFunction(applicantName,applicantDesignation,instutionName,addressOfInd,phnCodeOfInd,phnOfInd,mobileNo,emailOfInd,authorisationFor,appliedFor,hcfType,
                 		         wasteFacilityStatus,officeAddress,wasteLocationAddress,placeOfDisposal,statusCteCto,lat,longt,detailsOfDirections,outpatientsFacility,inpatientsFacility,noofbeds,
                 		         noOfNonBeds,noOfInOutPatients,NoofHCF,noOfBedsCbmwtf,treatmentAndDisposal,
                 		         qtyOfBmwTreated,Jurisdictionalarea,contingencyPlan,anatomicalwaste,animalwaste, soiledwaste,discardedwaste,chemicalSolidWaste,
                 		         chemicalLiquidWaste,discardedLinen,otherClininLabWaste,contaminatedwaste,wasteSharps,glassWare,metallicBodyImplants,total1
                 		         ,incinrators,incinratorsType,plasmaPyrolysis,plasmaPyrolysisType,autoclaves,autoclavesType,microwave,microwaveType,hydroclave,hydroclaveType,
                 		         shredders,shreddersType,needleTipCutter,needleTipCutterType,sharpEncapsulation,sharpEncapsulationType,deepBurial,deepBurialType,chemDisinfection,chemDisinfectionType,anyOtherTretmntEquip,anyOtherTretmntEquipType,roleNameForpdf,listDocuments,hwPreviousAuthDetails,BMWApplicationDate,jurisdictionOfficeName,feeList,appNo,onlineFee)

                 				

                 				byte[] b = new byte[(int) certFile1.length()];
                 				
                 				FileInputStream fileInputStream = new FileInputStream(certFile1);
                 				fileInputStream.read(b);
                 				
                 				def industryReg1=IndustryRegMaster.get((params.indRegId).toLong())

                 				
                 				
                 				WasteManagementFile file1=new WasteManagementFile()
                 				def fileLength=certFile1.length()
                 				file1.applicationId = bioId
                 				file1.size = fileLength / 1024  //f.getSize() 
                 				file1.extension ="pdf"//extractExtension( f )
                 				file1.data=b;
                 				file1.name="BmwForm.pdf"
                 				file1.description="BMW Application Form"
                 				file1.createdBy= session.indUser
                 				file1.updatedBy=session.indUser
                 				file1.typeOfFile="BmwForm"
                 				file1.applicationFor="BMW"
                 				file1.indreg=industryReg1

                 				
                 				if(file1.save()) {

                 					
                 				}
                 				else{
                 					
                 				}	
                 				
                 			
                 		
                 			}
                 			
//                 			added by sharvan start from here
                 			def applicationProcessingDetails1 = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails indPower where indPower.applicationId=? order by indPower.id desc",[params.bioMedId])
                 			println("123123123123123")
                 			if(applicationProcessingDetails1 !=null){
                 				if(applicationProcessingDetails1.returned==true){
                 					println("applicationProcessingDetails1.returned==true")
                 					if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors())
                        	         {
                 						println("hey scrutiny return query")
                 						RouteWasteManagement a=new RouteWasteManagement()
                    		  			def appFor1 = "BMW"
                                			
                             
                                		    	a.routeWasteManagementApp(bioMedicalWasteInstance.id,appFor1,indRegInstance)
                        					flash.message = "Application re-submitted sucessfully" 
                            		
                        	         }
                        						
                        	        
                        			else
                        			{
                        				bioMedicalWasteInstance.errors.each {
                        	   		        println it
                        	   			}
                        			
                        				
                        			}
                        			
                        			 redirect(action:showNewFormat,id:bioMedicalWasteInstance.id)	
                        return
                 					
                 				}else if(applicationProcessingDetails1.reject==true){
                 					println("applicationProcessingDetails1.rejected==true")
                 					if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors())
                        	         {
                 						println("hey scrutiny return query")
                 						
                 						
                 						def scrutinyReturn=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId= ? order by id desc",[bioMedicalWasteInstance.id.toString()])
                 	                	System.out.println("scrutinyReturn+++++"+scrutinyReturn);
                 	                	if(scrutinyReturn==null){
                 	                		println("scrutinyReturn is null")
                 	                	}else if(scrutinyReturn.scrutinyStatus=="In-Complete"){
                 	                			scrutinyReturn.applicationStatus="pending"
                 	                			scrutinyReturn.completionStatus="In-Process"
                 	                			scrutinyReturn.scrutinyStatus=""


                 	                				if(scrutinyReturn.save() && !scrutinyReturn.hasErrors())
                                       	         {
                 	                					println("scrutinyReturn.scrutinyStatus=saved l"+scrutinyReturn.scrutinyStatus)
                                           		
                                       	         }else
                                     			{
                                       	        	println("scrutinyReturn.scrutinyStatus= not savedl"+scrutinyReturn.scrutinyStatus)
                                       	        	scrutinyReturn.errors.each {
                                     	   		        println it
                                     	   			}
                                     			
                                     				
                                     			}
                 	                			println("scrutinyReturn.scrutinyStatus=l"+scrutinyReturn.scrutinyStatus)
                 	                	}
                 	                	def scrutinyWasteManagementProcessingDetails=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId= ? order by id desc",[bioMedicalWasteInstance.id.toString()])
                 	                	System.out.println("scrutinyWasteManagementProcessingDetails+++++"+scrutinyWasteManagementProcessingDetails);
                 	                	if(scrutinyWasteManagementProcessingDetails==null){
                 	                		println("scrutinyWasteManagementProcessingDetails is null")
                 	                	}else if(scrutinyWasteManagementProcessingDetails.scrutinyStatus=="In-Complete"){
                 	                		scrutinyWasteManagementProcessingDetails.reject=false
                 	                		scrutinyWasteManagementProcessingDetails.fileNote = params.scrutinyReply
                 	                		//scrutinyWasteManagementProcessingDetails.fileNote = ""
                 	                		scrutinyWasteManagementProcessingDetails.scrutinyStatus="In-Complete"
                 	                		scrutinyWasteManagementProcessingDetails.resubmitStatus=true
                 	                 		//scrutinyWasteManagementProcessingDetails.save()
                 	                 			if(scrutinyWasteManagementProcessingDetails.save() && !scrutinyWasteManagementProcessingDetails.hasErrors())
                                       	         {
                 	                					println("scrutinyWasteManagementProcessingDetails. saved l"+scrutinyWasteManagementProcessingDetails)
                                           		
                                       	         }else
                                     			{
                                       	        	println("scrutinyReturn.scrutinyStatus= not savedl"+scrutinyWasteManagementProcessingDetails)
                                       	        	scrutinyWasteManagementProcessingDetails.errors.each {
                                     	   		        println it
                                     	   			}
                                     			
                                     				
                                     			}
                 	                	}
                 	                	def biomedicalwastescrutiny=BioMedicalWaste.find("from BioMedicalWaste where id= ? order by id desc",[bioMedicalWasteInstance.id.toLong()])
                 	                	System.out.println("biomedicalwastescrutiny+++++"+biomedicalwastescrutiny);
                 	                	if(biomedicalwastescrutiny==null){
                 	                		println("scrutinyWasteManagementProcessingDetails is null")
                 	                	}else if(biomedicalwastescrutiny){
                 	                		biomedicalwastescrutiny.applicationStatus="Inprogress"
                 	                	    biomedicalwastescrutiny.completionStatus="Completed"
                 	                		//biomedicalwastescrutiny.save()
                 	                		if(biomedicalwastescrutiny.save() && !biomedicalwastescrutiny.hasErrors())
                                       	         {
                 	                					println("biomedicalwastescrutiny. saved l"+biomedicalwastescrutiny)
                                           		
                                       	         }else
                                     			{
                                       	        	println("biomedicalwastescrutinynot savedl"+biomedicalwastescrutiny)
                                       	        	biomedicalwastescrutiny.errors.each {
                                     	   		        println it
                                     	   			}
                                     			
                                     				
                                     			}
                 	                	}
                 						
                 	                	flash.message ="Congratulations! Your Application No. ${bioMedicalWasteInstance.id} is submitted successfully." 
                            		
                        	         }
                        						
                        	        
                        			else
                        			{
                        				bioMedicalWasteInstance.errors.each {
                        	   		        println it
                        	   			}
                        			
                        				
                        			}
                        			
                        			 redirect(action:showNewFormat,id:bioMedicalWasteInstance.id)	
                        return
                 					
                 				}else{
                 					
                 					if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors())
                        	         {
                        		  
                            		
                        	         }
                        						
                        	        
                        			else
                        			{
                        				bioMedicalWasteInstance.errors.each {
                        	   		        println it
                        	   			}
                        			
                        				
                        			}
                        			
                        			 redirect(action:showNewFormat,id:bioMedicalWasteInstance.id)	
                        			 return
                 					
                 					
                 				}
                 			}else{
                 			 if(bioMedicalWasteInstance.save() && !bioMedicalWasteInstance.hasErrors())
                 	         {
                 				 println("save scrutiny return query")
                 				 
                     		
                 	         }
                 						
                 	        
                 			else
                 			{
                 				bioMedicalWasteInstance.errors.each {
                 	   		        println it
                 	   			}
                 			
                 				
                 			}
                 			println("gdjfjfjfkhkhhkjvhkg")
                 			//render(view:'Payment',model:[feesPaid:totalfee,bioMedicalWasteInstance:bioMedicalWasteInstance])
                 			redirect(action:confirmation,id:bioMedicalWasteInstance.id)
                 			}}
                
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
    
    
    def popFeeOtherDetailsAddBMW1 = {
		 try {
		    	

    		def app = BioMedicalWaste.get((params.id).toInteger())
   

        	def feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(app)
        	def totalfee = 0.0
        	
        	for(int i=0;i<feeDetailsList.size();i++)
        	{
        		totalfee = totalfee + feeDetailsList.get(i).amount
        	}

    		def feeCheque = FeeChequeRecordBMW.find("from FeeChequeRecordBMW afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])

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
	        activityRecInstance.status = "BMW Application "+params.id+ " Bank Details Click on Add."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
    		return [appDetId:params.id,feeDetailsList:feeDetailsList,totalfee:totalfee,app:app,feeCheque:feeCheque]

    		
    
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

   def popFeeOtherDetailsViewBMW1 = {
		 try {
		    	
    		def app = BioMedicalWaste.get((params.id).toInteger())

        	def feeDetailsListBMW = FeeBankOtherDetailsBMW.findAllByApplication(app)
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
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
	        activityRecInstance.status = "BMW Application "+params.id+ " Bank Details View."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
        	return [appDetId:params.id,feeDetailsListBMW:feeDetailsListBMW]
    
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


   def saveBankOtherFeeDetailsBMW1 ={
		 try {
			    
        	
	         	
        	def app = BioMedicalWaste.get((params.appId).toInteger())

            	
            			def feeBankDetailsBMW = new FeeBankOtherDetailsBMW()
        	feeBankDetailsBMW.application = app
                		
                		if(params.feeFor=="Other"){
                			feeBankDetailsBMW.feeFor = params.feeFor+","+params.otherDetail	
                		}else{
                		
                		
                			feeBankDetailsBMW.feeFor = params.feeFor
                		}
                		
                		
                	
                		if(params.ddAmount != ""){
                			try{
                				feeBankDetailsBMW.amount = (params.ddAmount).toLong()
                			}catch (Exception e) {
                				feeBankDetailsBMW.amount = 0
                			}
            				
            			}else{
            				feeBankDetailsBMW.amount = 0
            			}
            		
if(feeBankDetailsBMW.save(flush:true)){
						
											
        				
							
							
							
        			}else{
        				feeBankDetailsBMW.errors.each {
        			        println it
        			   }
        			}
        			
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
activityRecInstance.status = "BMW Application "+params.appId+ " Bank Details Save ."
if(activityRecInstance.save()){		   
}
else{
	activityRecInstance.errors.each {
   	println it
 }
}
    	redirect(action:popFeeOtherDetailsAddBMW,id:app.id)

                		
                		
                		
                		
    
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
       
   def popFeeOtherDetailsEditBMW1 = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.id).toInteger())
        	def feeDetailsBMWList = FeeBankOtherDetailsBMW.findAllByApplication(app)
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
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
	        activityRecInstance.status = "BMW Application "+params.id+ " Bank Details Click on Edit."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
        	return [appDetId:params.id,feeDetailsBMWList:feeDetailsBMWList]
        
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
   
   
   
   def deleteFeeOtherBankDetailsBMW1 = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.appId).toInteger())
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInstBMW = FeeBankOtherDetailsBMW.get((params.delete).toInteger())
        		
        		feeDetInstBMW.delete()

        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = FeeBankOtherDetailsBMW.get((params.delete[i]).toInteger())
            		
            		feeDetInstBMW.delete()
            	}

        		}
        		
        	}
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
			    activityRecInstance.activity = "delete"
			    activityRecInstance.status = "BMW Application "+params.appId+ " Bank Details Delete."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
				    	println it
				  }
			  } 
        	redirect(action:popFeeOtherDetailsEditBMW,id:app)
        
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
  		


    def popFeeOtherDetailsAddBMW = {
		 try {
		    	

    		def app = BioMedicalWaste.get((params.id).toInteger())
   

        	def feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(app)
        	def totalfee = 0.0
        	
        	for(int i=0;i<feeDetailsList.size();i++)
        	{
        		totalfee = totalfee + feeDetailsList.get(i).amount
        	}

    		def feeCheque = FeeChequeRecordBMW.find("from FeeChequeRecordBMW afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])

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
	        activityRecInstance.status = "BMW Application "+params.id+ " Bank Details Click on Add."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
    		return [appDetId:params.id,feeDetailsList:feeDetailsList,totalfee:totalfee,app:app,feeCheque:feeCheque]

    		
    
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

   def popFeeOtherDetailsViewBMW = {
		 try {
		    	
    		def app = BioMedicalWaste.get((params.id).toInteger())

        	def feeDetailsListBMW = FeeBankOtherDetailsBMW.findAllByApplication(app)
        	println("-----feeDetailsListBMW---"+feeDetailsListBMW.size())
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
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
	        activityRecInstance.status = "BMW Application "+params.id+ " Bank Details View."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
        	return [appDetId:params.id,feeDetailsListBMW:feeDetailsListBMW]
    
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


   def saveBankOtherFeeDetailsBMW ={
		 try {
			    
        	
	         	
        	def app = BioMedicalWaste.get((params.appId).toInteger())

            	
            			def feeBankDetailsBMW = new FeeBankOtherDetailsBMW()
        	feeBankDetailsBMW.application = app
                		
                		if(params.feeFor=="Other"){
                			feeBankDetailsBMW.feeFor = params.feeFor+","+params.otherDetail	
                		}else{
                		
                		
                			feeBankDetailsBMW.feeFor = params.feeFor
                		}
                		
                		
                	
                		if(params.ddAmount != ""){
                			try{
                				feeBankDetailsBMW.amount = (params.ddAmount).toLong()
                			}catch (Exception e) {
                				feeBankDetailsBMW.amount = 0
                			}
            				
            			}else{
            				feeBankDetailsBMW.amount = 0
            			}
            		
if(feeBankDetailsBMW.save(flush:true)){
						
											
        				
							
							
							
        			}else{
        				feeBankDetailsBMW.errors.each {
        			        println it
        			   }
        			}
        			
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
activityRecInstance.status = "BMW Application "+params.appId+ " Bank Details Save ."
if(activityRecInstance.save()){		   
}
else{
	activityRecInstance.errors.each {
   	println it
 }
}
    	redirect(action:popFeeOtherDetailsAddBMW,id:app.id)

                		
                		
                		
                		
    
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
       
   def popFeeOtherDetailsEditBMW = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.id).toInteger())
        	def feeDetailsBMWList = FeeBankOtherDetailsBMW.findAllByApplication(app)
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
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
	        activityRecInstance.status = "BMW Application "+params.id+ " Bank Details Click on Edit."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
        	return [appDetId:params.id,feeDetailsBMWList:feeDetailsBMWList]
        
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
   
   
   
   def deleteFeeOtherBankDetailsBMW = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.appId).toInteger())
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInstBMW = FeeBankOtherDetailsBMW.get((params.delete).toInteger())
        		
        		feeDetInstBMW.delete()

        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = FeeBankOtherDetailsBMW.get((params.delete[i]).toInteger())
            		
            		feeDetInstBMW.delete()
            	}

        		}
        		
        	}
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
			    activityRecInstance.activity = "delete"
			    activityRecInstance.status = "BMW Application "+params.appId+ " Bank Details Delete."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
				    	println it
				  }
			  } 
        	redirect(action:popFeeOtherDetailsEditBMW,id:app)
        
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
  		
    def paymentOption = {
   	 try {
   		    def testValue= params.testValue
   		    println("--testValue--"+testValue)
   	    	def fee = params.fees

   	    	def indApp = params.indAppDetId
   	    	def indApplicationDetailsInstance
   	    	
   	    	indApplicationDetailsInstance = BioMedicalWaste.get( params.indAppDetId)
   	    	
   	    	
   	    	Random random = new Random(new Date().getTime());
   	    	int randomInt = random.nextInt(1000000000);

   	    	  
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
               activityRecInstance.status = "BMW Application ${params.indAppDetId} select for payment option"
               if(activityRecInstance.save()){		   
                 }
               	else{
               		activityRecInstance.errors.each {
   			    	println it
   			  }
   		  }
   	    	if(params.radio=="online")
   	    	{
   	    		render(view:'paymentOption',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,randomInt:randomInt])
   	    	}
   	    	else if(params.radio=="offline")
   	    	{
   	    		redirect(action:bankPaymentMode,id:indApplicationDetailsInstance)
   	    	}else if(params.radio=="paymentAlreadySubmitted"){
   	    		redirect(action:paymentAlreadySub,id:indApplicationDetailsInstance)
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


    def bankPaymentMode = {
     		 try {
     			    

     	    	 def indApplicationDetailsInstance = BioMedicalWaste.get( params.id )
     	    	 [indApplicationDetailsInstance:indApplicationDetailsInstance]
     	    	
     	    
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
    
    def bankName={
    		println("PARAMS IN bankName------>"+params)
			def indApplicationDetailsInstance = BioMedicalWaste.get( params.indAppDetId)
			println(indApplicationDetailsInstance)
			def bankTransaction = new BankTransactionDetailsBMW()
			def bank
			//def fees = session.getAttribute("fee")
			
			println("session--------->"+session)
			
			def fees = ConsentFeeMasterBMW.find("from ConsentFeeMasterBMW  where application = ?",[indApplicationDetailsInstance])
			println("fees--bank name------->"+fees)
			println("fees--bank name------->"+fees.getClass().getName())
			if(params.radio=="PNB")
			{
			println("bank---"+bank)
			println("session.getAttribute----"+session.getAttribute("random"))
			def id = session.getAttribute("random")
			bankTransaction.bankId = ""
			bankTransaction.amount = session.getAttribute("fee")
			bankTransaction.bankName = params.radio 
			bankTransaction.bioApplication = indApplicationDetailsInstance
			bankTransaction.dateCreated = new Date()
			bankTransaction.lastUpdated = new Date()
			bankTransaction.transactionStatus = "F"
			bankTransaction.id = id
			bankTransaction.paymentType="Net Banking"
			bankTransaction.paymentGateway=""
			println("bankTransaction.id--"+bankTransaction.id)
			bankTransaction.save()
			println("bankTransaction.id--"+bankTransaction.id)
			render(view:'bankName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction])
			}
			else if(params.radio=="onlineHDFC")
			{
				println("====INSIDE=========HDFC");
				redirect(action:bankNameHDFC,id:params.indAppDetId,radio:"other");
				return
			}
    }
    
    //-----------------------For online payment HDFC-----------------//
    def bankNameHDFC = {
					
			println("----PARAMS in bankNameHDFC----"+params);
			try{
				def indApplicationDetailsInstance = BioMedicalWaste.get(params.id)
	    		def bankTransaction = new BankTransactionDetailsBMW()
	    		def bank
	    		//def fees = session.getAttribute("fee");
	    		def feesInst = ConsentFeeMasterBMW.find("from ConsentFeeMasterBMW  where application = ?",[indApplicationDetailsInstance])
	    	    def fees = feesInst.totalFees
				println("fees-totalFees-bankNameHDFC------->"+fees)
				println("fees--totalFeesbankNameHDFC------->"+fees.getClass().getName())
				
				def appFor="BMW"
	    		if (true){

	    			def id = session.getAttribute("random")
			    	bankTransaction.bankId = ""
			    	bankTransaction.amount = fees//session.getAttribute("fee")
			    	bankTransaction.bankName = "Tech Process"
			    	bankTransaction.bioApplication = indApplicationDetailsInstance
			    	bankTransaction.dateCreated = new Date()
			    	bankTransaction.lastUpdated = new Date()
			    	bankTransaction.transactionStatus = "F"
			    	bankTransaction.paymentType=""
			    	bankTransaction.id = id
			    	bankTransaction.paymentGateway="BILLDESK"
			    	println("bankTransaction.bankName.id--"+bankTransaction.id)    	
			    //	bankTransaction.save()   
			    	if(bankTransaction.save(flush:true) ){
						println("bankTransaction-inst-save--bmw--"+bankTransaction)
					}else{
						println("bankTransaction-inst-not-saved--bmw--"+bankTransaction)
				        if(bankTransaction.hasErrors()){
				        	bankTransaction.errors.allErrors.each {
				                    println it
				                 }
				                } 
				     }
	            	
			    	def waterCess = "0"
			        def nocFee = "0"
				    def waterCons = "0"
				    def airCons = "0"
					def ctobothFee = "0"
					def bmw = "0"
					def testingFee = "0"
					def ebg = "0"
					def hmw = "0"
					def ihw = "0"
					def formFee = "0"
				    def misc = "0"
					
				    
				    def group1 = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
			        println("group1---------"+group1)
			        def group = group1.group.groupName
			        def feesOnline = FeeBankOtherDetailsBMW.findAll("from FeeBankOtherDetailsBMW fee where fee.application=?",[indApplicationDetailsInstance])
					println("feesOnline.......>>>>>"+feesOnline.feeFor)
					
			        def accNo = "appid"+indApplicationDetailsInstance+"_"+"dist"+indApplicationDetailsInstance.industryRegMasterObj.district.districtName+"_"+"appFor"+appFor+"_"+"appType"+indApplicationDetailsInstance.hcfType+
		            	"_"+"certFor"+indApplicationDetailsInstance.authorisationAppliedFor+"_"+"nocFee"+nocFee+"_"+"airCons"+airCons+"_"+"waterCons"+waterCons+"_"+"formFee"+formFee+"misc"+"_"+misc+"group"+"_"+group+"indName"+"_"+indApplicationDetailsInstance.industryRegMasterObj.indName
		            def indName = indApplicationDetailsInstance.id
		          	def indAddress = indApplicationDetailsInstance.industryRegMasterObj.indAddress
		            def indEmail = indApplicationDetailsInstance.industryRegMasterObj.indEmail
		            println("indName----"+indName)
		            println("indEmail----"+indEmail)
		          	println("accNo----"+accNo)
		            String industryName = indName
		            String merchantCode = indAddress
	            	String accountNu = accNo
	            	//String fee = session.getAttribute("fee")
	            	String bankCode ="NA"
	            	String industryEmail = indEmail
	            	println("feefeefeefeefeefee.......----"+fees)
	            	println("industryName----"+industryName)
	                println("industryEmail----"+industryEmail)
	            	def industryName1 = indApplicationDetailsInstance.industryRegMasterObj.indName
	            	VenderRegistration venderRegistrationObj=new VenderRegistration();
	                def indNameD=venderRegistrationObj.ReplaceSpecialChar(industryName1)
	                println("indNameD-----------------------"+indNameD)
	                println(".....priyanka....."+fees.getClass().getName())
	            	String txnAmount="0.00"
	                if(fees)
	                 {
	                     txnAmount=fees+""
	                 }
	                String txnAmount1="0.0"
	                if(fees){
	                	
	                    txnAmount1=fees
	                    
	                   }
	                String shoppingCart="JKPCB_"+txnAmount1+"_0.0"
	                String customerId = id    		
	                println("......txnAmount....."+txnAmount);
	                println("......shoppingCart....."+shoppingCart);
	                println("......customerId....."+customerId.getClass().getName());
	                println("......industryName....."+industryName.getClass().getName());
	                println("......industryEmail....."+industryEmail.getClass().getName());
	                  
	                def sdfh = new SimpleDateFormat("dd-MM-yyyy"); 
	                println("......sdfh.format(new Date())....."+sdfh.format(new Date()));
	                String checksum = "Zio5SNM7a47U"
	                String merchantId = "JKZPOLCBR"
	                String securityId = "jkzpolcbr"
	                def transDate = sdfh.format(new Date());
	               //def url = "http://164.100.163.18/JKPCB/bioMedicalWaste/responsePageHDFC"
	                def url="https://jkocmms.nic.in/bioMedicalWaste/responsePageHDFC"
	              
	            	println("......securityId....."+securityId.getClass().getName());
	                println("......transDate....."+transDate.getClass().getName());
	                println("......transDate.toString()...."+transDate.toString().getClass().getName());
	                println("......indNameD....."+indNameD.getClass().getName());
	                //def transValue = "JKZPOLCBR"+"|"+customerId+"|"+"NA"+"|"+txnAmount+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"INR"+"|"+"NA"+"|"+"R"+"|"+securityId+"|"+"NA"+"|"+"NA"+"|"+"F"+"|"+industryName+"|"+industryEmail+"|"+indNameD+"|"+transDate.toString()+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+url;
	                //def transValue = "JKZPOLCBR"+"|"+customerId+"|"+"NA"+"|"+txnAmount+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"INR"+"|"+"NA"+"|"+"R"+"|"+securityId+"|"+"NA"+"|"+"NA"+"|"+"F"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+url;
	                def transValue = "JKZPOLCBR"+"|"+customerId+"|"+"NA"+"|"+txnAmount+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+"INR"+"|"+"NA"+"|"+"R"+"|"+securityId+"|"+"NA"+"|"+"NA"+"|"+"F"+"|"+industryName+"|"+industryEmail+"|"+indNameD+"|"+transDate.toString()+"|"+"NA"+"|"+"NA"+"|"+"NA"+"|"+url;
	        		println("transValue in bank name---------"+transValue)
	                TestHMac checksumGenerate=new TestHMac();
	                def checksumValue=checksumGenerate.HmacSHA256(transValue,checksum)
	                println("checksumValue---------"+checksumValue)
	                String msg = transValue+"|"+checksumValue
	                println("msg---------"+msg)
	                render(view:'bankName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction,strMsg:msg])
	        	}
	    		
	    	}catch(Exception e) {
	    	e.printStackTrace();
	       }
	    }
    
    //-------------------------end-----------------------------------//
 
     /*
		  * @Created by : KUMAR
		  * @Created Date :28-09-18
		  * Purpose : Bank Payment through New Gateway 
		  */
    def responsePageHDFC = {
		
			
				println("===Session in responsePageHDFC======="+session)
	    		def testVal1=session.getAttribute("testVal1");
	    		println("===testVal1============"+testVal1);
	    	          
	    		String msg = request.getParameter("msg")
	    		
	    		println("4 msg: " + msg)
	    		
	    		String aa = msg
	    		String merchantId = "";
		    	String transId = "";
		    	String billDeskId = "";
		    	String value1 = "";
		    	String txnAmount = "";
		
		    	String bankId = "";
		    	String value2 = "";
		    	String txnType = "";
		    	
		    	String CurrencyType = "";
		    	String  type2= "";
		    	String value4 = ""; 
		    	String value5 = "";
		    	String value6 = "";
		    	String transDateB = "";
		    	String strAuthStatus = "";
		    	String value7 = "";
		    	String appNo = "";
		    	String indMail = "";
		    	String indName = "";
		    	String transDateK = "";
		    	String value8 = "";
		    	String value9 = "";
		    	String value10 = "";
		    	String value11 = "";
		    	String strErrorDescription = "";
		    	String msgChecksum = "";
	
	    		StringTokenizer token = new StringTokenizer(aa,"|");
	    		println("5 token: "+token)
	    		println("6 token.countTokens(): "+token.countTokens())
	    		if(token.countTokens()>0){
	    			
	    			merchantId = token.nextToken();
	    			transId = token.nextToken();
	    			billDeskId = token.nextToken();
	    			value1 = token.nextToken();
	    			txnAmount = token.nextToken();
	    			bankId = token.nextToken();
	    			value2 = token.nextToken();
	    			txnType = token.nextToken();
	    			CurrencyType = token.nextToken();
	    			type2= token.nextToken();
	    			value4 = token.nextToken(); 
	    			value5 = token.nextToken();
	    			value6 = token.nextToken();
	    			transDateB = token.nextToken();
	    			strAuthStatus = token.nextToken();
	    			value7 = token.nextToken();
	    			appNo = token.nextToken();
	    			indMail = token.nextToken();
	    			indName = token.nextToken();
	    			transDateK = token.nextToken();
	    			value8 = token.nextToken();
	    			value9 = token.nextToken();
	    			value10 = token.nextToken();
	    			value11 = token.nextToken();
	    			strErrorDescription = token.nextToken();
	    			msgChecksum = token.nextToken();

   		}
   		else{
   			
   			System.out.println("7 token.countTokens()>0 is false");
   		}
	    		def transInstance = BankTransactionDetailsBMW.get(transId) 
	    		def appId = transInstance.bioApplication
	    	    println("1 appId: " + appId)
	    	    def indApplicationDetailsInstance = BioMedicalWaste.get(appId.id)
	    	    println("2 responsePage1=>indApplicationDetailsInstance: " + indApplicationDetailsInstance)
	    	    def indName1 = indApplicationDetailsInstance.industryRegMasterObj.indName
	          	String industryName = indApplicationDetailsInstance.id
	          	def indEmail = indApplicationDetailsInstance.industryRegMasterObj.indEmail
	          	String industryEmail = indEmail
	          	def bioAppId=indApplicationDetailsInstance.id
	          	def appPendingInst = WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=?",[String.valueOf(bioAppId)]) 
	    		println("8 transId: " + transId)
	    		println("9 billDeskId: " + billDeskId)
	    		println("10 msgChecksum: " + msgChecksum)
	    		def inst = indApplicationDetailsInstance.hcfType
	    		def inst1 = "BMW"
	    		def inst2 = indApplicationDetailsInstance.authorisationAppliedFor
	    		def val = indApplicationDetailsInstance.industryRegMasterObj
	    		def occName = val.occName
	    		def fee = transInstance.amount
	    		if(session.appId){
	    			
	    		}else{
	    			  session.fee = transInstance.amount
	    			   
	    			  session.indregName = indApplicationDetailsInstance.industryRegMasterObj
	    			  session.appId = indApplicationDetailsInstance.id
	    			  session.cafUniqueNo=indApplicationDetailsInstance.cafUniqueNo
	    			  session.serviceId=indApplicationDetailsInstance.serviceId
	    			  session.login = "xyz"
	    			  def insUser=IndUser.findByIndustryRegMaster(indApplicationDetailsInstance.industryRegMasterObj)
	    			  session.indUser =insUser 
	    			  session.random = transInstance.id
	    			  
	    		}
	    		String checksum = "Zio5SNM7a47U"
	    		println("11 inst: " + inst)
	    		println("12 inst1: " + inst1)
	    		println("13 inst2: " + inst2)
	    		println("14 val: " + val)
	    		println("15 occName: " + occName)
	    		println("16 fee: " + fee)
	    		String aa1 = msg;
	            String msgChecksum1 = "";
	            
	            String[] msgbreak=aa1.split("\\|");
	            println("17 msgbreak: " + msgbreak)
	            msgChecksum1=msgbreak[msgbreak.length-1];
	            println("18 msgChecksum1: " + msgChecksum1)
	            
	            String finalmsg="";
	            boolean checksumMatch = false;
	     
	            println("19 msgbreak.length: " + msgbreak.length)
	   		    for(int i=0;i<msgbreak.length-1;i++)
	   		    {
	   		    	println("20 i: " + i)
	   		    	println("21 i==msgbreak.length-2: " + i==msgbreak.length-2)
	   		    	println("22 !(i==msgbreak.length-2): " + !(i==msgbreak.length-2))
	   		    	if(!(i==msgbreak.length-2)){
	   		    		finalmsg=finalmsg+msgbreak[i]+"|";
		    			println("23 inside if")
		    			println("24 finalmsg: " + finalmsg)
	   		    	}else{
	   		    		finalmsg=finalmsg+msgbreak[i];
	   		    		println("25 inside else")
		    			println("26 finalmsg: " + finalmsg)
	   		    	}
	   		    	
	   		    }
	   		    System.out.println("27 after for loop finalmsg: "+finalmsg);
	   		    TestHMac checksumGenerate=new TestHMac();
	   		    println("28 checksumGenerate: " + checksumGenerate)
	   		    def checksumres=checksumGenerate.HmacSHA256(finalmsg,checksum)
	   		    println("29 checksumres: " + checksumres)
	   		    println("30 checksumres==msgChecksum: " + checksumres==msgChecksum)
	   		    if(checksumres==msgChecksum)
	   		    {
	   		    	System.out.println("31 In side True");
	   		    	checksumMatch = true;
	   		    	
	   		    }else{
	   		    	
	   		    	System.out.println("32 not same....");
	   		    }
	   		    println("33 checksumMatch: " + checksumMatch)
	   		    println("34 strAuthStatus: " + strAuthStatus)
	   		    println("35 strAuthStatus.equals(\"0300\"): " + strAuthStatus.equals("0300"))
	   		    if(checksumMatch && strAuthStatus.equals("0300"))
	   		    {
	   		    	
	   			       	
	               	println("36 transInstance: "+transInstance)
	               	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
	               	def feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(indApplicationDetailsInstance)
	                def a
	               	println("37 testVal1==\"true\": " + testVal1=="true")
	               
	       			if(testVal1=="true"){
	       				RouteWasteManagement routeWaste=new RouteWasteManagement()
	       				def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,"BMW",val)
	       		    	updateAllSummaryReportWMS((indApplicationDetailsInstance.id).toString());// all summary
	       		     }else{
	       		    	RouteWasteManagement routeWaste=new RouteWasteManagement()
	       				def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,"BMW",val)
	       		    	updateAllSummaryReportWMS((indApplicationDetailsInstance.id).toString());// all summary
	       		      }
	   			   transInstance.transactionStatus = "S"
	   			   println("40 transInstance.transactionStatus: " + transInstance.transactionStatus)
	   			   println("41 txnType: " + txnType)
	   			   if(txnType=="01"){
	   				transInstance.paymentType="Net Banking"
	   			   }else if(txnType=="02"){
	   				transInstance.paymentType="Credit"
	   			   }else if(txnType=="03"){
	   				transInstance.paymentType="Debit"
	   			   }else if(txnType=="04"){
	   				transInstance.paymentType="Cash Card"
	   			   }else if(txnType=="05"){
	   				transInstance.paymentType="Mobile Wallet"
	   			   }else if(txnType=="06"){
	   				transInstance.paymentType="IMPS"
	   			   }else if(txnType=="07"){
	   				transInstance.paymentType="Reward Points"
	   			   }else if(txnType=="08"){
	   				transInstance.paymentType="Rupay"
	   			   }else {
	   				transInstance.paymentType=""
	   			   }
	   			   println("42 transInstance.paymentType: " + transInstance.paymentType)
	   			   
	   			   transInstance.bankName = "NA"
	   			   transInstance.bankId = bankId
	   			   transInstance.lastUpdated = new Date()
	   		    	
	   			 if(transInstance.save()){
	   				 println("43 transInstance is saved successfully")
	   				 println("44 transInstance.transactionStatus: " + transInstance.transactionStatus)
	   			  }
	             else{
	           	   	if(transInstance.hasErrors()){
	            		 transInstance.errors.allErrors.each {
	            			 println it
	            	}
	           	  } 
	            }
	   			println("45 after bank transaction instance is saved \ntransInstance.transactionStatus: " + transInstance.transactionStatus)
	   			println("46 testVal1==\"true\": " + testVal1=="true")
	 	        if(testVal1=="true"){
	 	    	   println("47 redirecting to view=onlinePaymentReciept")
	 	    	   render(view:'onlinePaymentReciept',model:[indApplicationDetailsInstance:indApplicationDetailsInstance.id,feeDetailsList:feeDetailsList,
	          	                                            group:group.group.groupName,strMarketCode:transId,strCSTBANKID:"",
	         	                                            dateVal:transInstance.lastUpdated,strTxnAmount:txnAmount,
	         	                                            status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,
	         	                                            testVal1:testVal1,transInstance:transInstance])
	           }
	 	       else{
	 	    	   println("48 redirecting to view=challanFormGateway")
	 	           render(view:'challanFormGateway',model:[indApplicationDetailsInstance:indApplicationDetailsInstance.id,feeDetailsList:feeDetailsList,
	 	                                            group:group.group.groupName,strMarketCode:transId,strCSTBANKID:"",
	 	                                            dateVal:transInstance.lastUpdated,strTxnAmount:txnAmount,
	 	                                            status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,
	 	                                            testVal1:testVal1,transInstance:transInstance])
	 	    	   }
	            }
	   		    else{
	   		    	strAuthStatus = "0399"; 
	   		    	redirect(action:payment,id:indApplicationDetailsInstance.id)   
	   		    	return
	   		 }		
		}
	    
	    def payment={

			 try {
				 println("soniaaaaaaaaaaaaaaaa---------------"+params)
				println("hgfhgfhgfhgfhfghgf"+params.id)
				def testVal = params.testVal
		         def indApplicationDetailsInstance = BioMedicalWaste.get( params.id )
		    	def feeAmountId = ConsentFeeMasterBMW.find("from ConsentFeeMasterBMW  where application = ?",[indApplicationDetailsInstance])
		    	def feeAmount = (feeAmountId.calculatedFee).toInteger()
		    	println("fdh fee=======ammount========="+feeAmount.toInteger())
		    	def feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(indApplicationDetailsInstance)
		        	def totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
				 println("totalfee--"+totalfee)
		        render(view:'Payment',model:[bioMedicalWasteInstance:indApplicationDetailsInstance,feesPaid:totalfee])
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
    
    
    
    def popFeeDetailsAddBMW = {
		 try {
			println("PARAMS in popFeeDetailsAddBMW---------"+params);   
        	def app = BioMedicalWaste.get((params.id).toInteger())
        	def feeDetailsList = FeeBankDetailsBMW.findAllByApplication(app)
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
        	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
        
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
   
   def saveBankFeeDetails = {
		 try {
			    
        	
        	def dateCheck = params.dateval_value

        	def currentDate=new Date()
        	DateCustom dd=new DateCustom()
        	def sqlCurrentDate=dd.sQLdate(currentDate)

        
        	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    		def x = sdfh.parse(dateCheck);
    		

        	
        	def app = BioMedicalWaste.get((params.appId).toInteger())
        	if(x>sqlCurrentDate)
    		{
    			flash.message="DD/Cheque issue date can not be greater than current date"

    			redirect(action:popFeeDetailsAddBMW,id:app.id)
    		}
        	else
        	{

        		if((params.ddNo).getClass().getName()== "java.lang.String"){
            		if(params.ddNo!=""){
            			def feeBankDetails = new FeeBankDetailsBMW()
                		feeBankDetails.application = app
                		feeBankDetails.ddChequeNo = params.ddNo

                		feeBankDetails.date = params.dateval_value
                		feeBankDetails.bankName = params.bankName
                		feeBankDetails.branch = params.branchName
                		if(params.ddAmount != ""){
                			try{
                				feeBankDetails.amount = (params.ddAmount).toLong()
                			}catch (Exception e) {
                				feeBankDetails.amount = 0
                			}
            				
            			}else{
            				feeBankDetails.amount = 0
            			}
            			if(feeBankDetails.save(flush:true)){

            			}else{
            				feeBankDetails.errors.each {
            			        println it
            			   }
            			}
            			
                		}
            		
            		
            	}else{

            		for(int i=0;i<params.ddNo.size();i++){
            			if(ddNo[i]!=""){
            				def feeBankDetails = new FeeBankDetailsBMW()
                    		feeBankDetails.application = app
                    		feeBankDetails.ddChequeNo = ddNo[i]
                    		feeBankDetails.date = date[i]
                    		feeBankDetails.bankName = bankName[i]
                    		feeBankDetails.branch = branchName[i]
                			if(ddAmount[i]!=""){
                				feeBankDetails.amount = (ddAmount[i]).toLong()
                			}else{
                				feeBankDetails.amount = 0
                			}
                    		feeBankDetails.save()
                    		
            			}
            			
                	}
            	}	
        	redirect(action:popFeeDetailsAddBMW,id:app.id)
        	
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
   
   
   def saveChequeAttach = {
		 try {
			    println("--bioId----"+params.appId1.getClass()+"----params.delete1-----"+params.delete1)


	       		def app = BioMedicalWaste.get((params.appId1).toInteger())
	       		
	       		def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)

	       		if(feeCheque){
	           		feeCheque.delete()
	          		 
	       		}
	       		
	       		def file1 = new FeeChequeRecordBMW()
	       		
	       		
	       		def f = request.getFile('draftattach')
	   			
	       		if(!f.empty) {
	       			MultipartFile multi1 = request.getFile('draftattach')
	   				file1.size = multi1.getSize() / 1024
	   				file1.level="Fee_Cheque"
	   				file1.dateCreated = new Date()
	                file1.data=multi1.getBytes() 
	                file1.extension = extractExtension( multi1 )
	                def abc = "Fee_Cheque"
	   	            def b = abc+"."+extractExtension( multi1 )
	   	            file1.name =b
	           	    file1.indApplication = app
	   	            file1.save(flush:true)
	   			}
	       		redirect(action:popFeeDetailsAddBMW,id:app)
	       
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
   
   def popFeeDetailsViewBMW = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.id).toInteger())

        	def feeDetailsList = FeeBankDetailsBMW.findAllByApplication(app)
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
        	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
        
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

   
   def viewChequeAttached={
		 try {
			    

     		 
      		
   		 def applicationFileInstance
   	    	def application = BioMedicalWaste.get((params.appliLoc).toLong())
   	    	
   	        applicationFileInstance=FeeChequeRecordBMW.findAll("from FeeChequeRecordBMW afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[application],[max:1])
   	    	
   	    	def applicationFileSingleInstance=applicationFileInstance[0]
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
   def popFeeDetailsEditBMW = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.id).toInteger())
        	def feeDetailsList = FeeBankDetailsBMW.findAllByApplication(app)
        	def feeCheque = FeeChequeRecordBMW.findByIndApplication(app)
        	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
        
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
   
   def deleteFeeBankDetails = {
		 try {
			    
        	def app = BioMedicalWaste.get((params.appId).toInteger())
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = FeeBankDetailsBMW.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		if(params.delete1)
        		{
        		def feeCheque = FeeChequeRecordBMW.get((params.delete1).toInteger())

        		if(feeCheque){
            	

            		

            			feeCheque.delete()
            		}
        			
                	flash.message="Please attach again the scan copy of Drafts/Cheques"

        		}
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = FeeBankDetailsBMW.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	if(params.delete1)
        		{
        		def feeCheque = FeeChequeRecordBMW.get((params.delete1).toInteger())
        		if(feeCheque){
        			
                    	

                		

                			
                		
                		
        			feeCheque.delete()
            		}
            	flash.message("Please attach again the scan copy of above Drafts/Cheques")

        		}
        		}
        		
        	}
        	redirect(action:popFeeDetailsEditBMW,id:app)
        
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
	
    
    
    
    
    
    
    def confirmation = {
		 try {
			 println("hey "+params)
			 def indApplicationDetailsInstance
			def id = params.id
			def id1 = params.indAppDetId
                 if(id){
                	 indApplicationDetailsInstance = BioMedicalWaste.get(params.id)
                 }
			  if(id1){
				  indApplicationDetailsInstance = BioMedicalWaste.get(params.indAppDetId)
			  }
		    	//def indApplicationDetailsInstance = BioMedicalWaste.get(params.indAppDetId)
		  
		    	//def fees = FeeBankDetailsBMW.find("from FeeBankDetailsBMW fee where fee.application=?",[indApplicationDetailsInstance])
				
					
				
		    	indApplicationDetailsInstance.completionStatus = "Completed"
		    		
		    	indApplicationDetailsInstance.save()
		    	
		    	IndUser indUserInstance=(IndUser)session.indUser
		    	def industryRegInstanceWaste=indUserInstance.industryRegMaster

		    	def appFor="BMW"
		    	
//////////////////////////////////////////////for scrutiny return//////////////////////////////////
					
					def scrutinyReturn=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId= ? order by id desc",[(indApplicationDetailsInstance.id).toString()])
	             	System.out.println("scrutinyReturn+++++"+scrutinyReturn);
			    	if(scrutinyReturn){
	             	if(scrutinyReturn==null){
	             		println("scrutinyReturn is null")
	             	}else if(scrutinyReturn.scrutinyStatus=="In-Complete"){
	             			scrutinyReturn.applicationStatus="pending"
	             			scrutinyReturn.completionStatus="In-Process"
	             			scrutinyReturn.scrutinyStatus=""
	             			scrutinyReturn.save()
	             	}else if(scrutinyReturn.applicationStatus=="returned"){
	             			scrutinyReturn.applicationStatus="pending"
	             			scrutinyReturn.completionStatus="In-Process"
	             			scrutinyReturn.scrutinyStatus=""
	             			scrutinyReturn.save()
	             	}
	             	def scrutinyWasteManagementProcessingDetails=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId= ? order by id desc",[(indApplicationDetailsInstance.id).toString()])
	             	System.out.println("scrutinyWasteManagementProcessingDetails+++++"+scrutinyWasteManagementProcessingDetails);
	             	if(scrutinyWasteManagementProcessingDetails==null){
	             		println("scrutinyWasteManagementProcessingDetails is null")
	             	}else if(scrutinyWasteManagementProcessingDetails.scrutinyStatus=="In-Complete"){
	             		scrutinyWasteManagementProcessingDetails.reject=false
	             		scrutinyWasteManagementProcessingDetails.scrutinyStatus="In-Complete"
	             		scrutinyWasteManagementProcessingDetails.resubmitStatus=true
	              		scrutinyWasteManagementProcessingDetails.save()
	             	}else if(scrutinyWasteManagementProcessingDetails.returned){
	             		println("hi 111111 ")
	             		
	             		def wasteProcessingDetails = new WasteManagementProcessingDetails()	
	             		wasteProcessingDetails.dateCreated = new Date()
	             		wasteProcessingDetails.lastUpdated = new Date()
	             		wasteProcessingDetails.role = scrutinyWasteManagementProcessingDetails.role
	             		wasteProcessingDetails.officer = scrutinyWasteManagementProcessingDetails.officer
	             		wasteProcessingDetails.roleFwd = scrutinyWasteManagementProcessingDetails.roleFwd
	             		wasteProcessingDetails.officerFwd = scrutinyWasteManagementProcessingDetails.officerFwd
	             		wasteProcessingDetails.fileNote = ""
	             		wasteProcessingDetails.noticeType = ""
	             		wasteProcessingDetails.clarification = scrutinyWasteManagementProcessingDetails.clarification
	             		wasteProcessingDetails.clarificationNote = ""
	             		wasteProcessingDetails.inspection = scrutinyWasteManagementProcessingDetails.inspection
	             		wasteProcessingDetails.inspectionNote = ""
	             		wasteProcessingDetails.inspectionClose = scrutinyWasteManagementProcessingDetails.inspectionClose
	             		wasteProcessingDetails.inspectionCloseNote = scrutinyWasteManagementProcessingDetails.inspectionCloseNote
	             		wasteProcessingDetails.approve = scrutinyWasteManagementProcessingDetails.approve
	             		wasteProcessingDetails.approveNote = scrutinyWasteManagementProcessingDetails.approveNote
	             		wasteProcessingDetails.reject = scrutinyWasteManagementProcessingDetails.reject
	             		wasteProcessingDetails.attachedFile = scrutinyWasteManagementProcessingDetails.attachedFile
	             		wasteProcessingDetails.rejectNote = scrutinyWasteManagementProcessingDetails.rejectNote
	             		wasteProcessingDetails.applicationId = scrutinyWasteManagementProcessingDetails.applicationId
	             		wasteProcessingDetails.applicationFor = scrutinyWasteManagementProcessingDetails.applicationFor
	             		wasteProcessingDetails.clarificationAttachedFile = scrutinyWasteManagementProcessingDetails.clarificationAttachedFile
	             		wasteProcessingDetails.clarificationReplyAttachedFile = scrutinyWasteManagementProcessingDetails.clarificationReplyAttachedFile
	             		wasteProcessingDetails.inspectionAttachedFile = scrutinyWasteManagementProcessingDetails.inspectionAttachedFile
	             		wasteProcessingDetails.inspectionCloseAttachedFile = scrutinyWasteManagementProcessingDetails.inspectionCloseAttachedFile
						wasteProcessingDetails.approvalStatus = scrutinyWasteManagementProcessingDetails.approvalStatus
						wasteProcessingDetails.scrutinyStatus = ""
						wasteProcessingDetails.scrutinyDescription = ""
						wasteProcessingDetails.returned = false
						wasteProcessingDetails.returnNote = ""
						wasteProcessingDetails.clarificationDays = ""
						wasteProcessingDetails.resubmitStatus = true
	             		wasteProcessingDetails.save()
	             	}
	             	def plasticWastescrutiny=BioMedicalWaste.find("from BioMedicalWaste where id= ? order by id desc",[(indApplicationDetailsInstance.id).toLong()])
	             	System.out.println("plasticWastescrutiny+++++"+plasticWastescrutiny);
	             	if(plasticWastescrutiny==null){
	             		println("scrutinyWasteManagementProcessingDetails is null")
	             	}else if(plasticWastescrutiny){
	             		plasticWastescrutiny.applicationStatus="Inprogress"
	             		plasticWastescrutiny.save()
	             	}
			    	}else{
					////////////////////////////////////////////////////end code////////////////////////////////////////
		    	
		    	       RouteWasteManagement routeWaste=new RouteWasteManagement()
		    	
		    	def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,appFor,industryRegInstanceWaste)
		    	 //UpdateAllSummaryReportWMS
		   //     updateAllSummaryReportWMS(indApplicationDetailsInstance.id.toString());// for update the data of all sumryWMS table
			    	}			
		    	//redirect(action:showNewFormat,id:indApplicationDetailsInstance.id)
		    	flash.message = "BioMedicalWaste Application No ${indApplicationDetailsInstance.id} is Submitted Successfully"
				//render(view:'confirmationSubmit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
				redirect(action:showNewFormat,id:indApplicationDetailsInstance.id)
		    
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
	    def confirm={ 
	    		try{
    		def indApplicationDetailsInstance = BioMedicalWaste.get(params.indAppDetId)
    		indApplicationDetailsInstance.completionStatus = "Completed"
	    	indApplicationDetailsInstance.save()
		    IndUser indUserInstance=(IndUser)session.indUser
		    def industryRegInstanceWaste=indUserInstance.industryRegMaster
		    def appFor="BMW"
		   // redirect(action:showNewFormat,id:indApplicationDetailsInstance.id)
		    flash.message = "BioMedicalWaste Application No ${indApplicationDetailsInstance.id} is Submitted Successfully"
		    render(view:'confirmationSubmit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
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
    
    
    def saveDocs={
	    		println("dhdshjdhjd")
  		  try {
  			  //-----------------code for audit----19/09/17 :Start By Vineet Kumar Raghav------------------------------/
  	            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
  	    		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
  	    	    response.setDateHeader("Expires", 0); // Proxies.
  	            //------------------ End Vineet Kumar Raghav----------------------------------------------------/
  	            if(session.indUser==null && session.userMaster==null)
  	            {
  	              redirect(uri:'/index.gsp')
  		    		return

  	            }
  		    	def app = BioMedicalWaste.get((params.indAppId).toInteger())
  		    	def apliId = app.id
  		    	def extn
  		    	def appType="CTO"
  		       	def certFor
  		       	if(params.appFor=="BMW Fresh"){
  		       		certFor="BMW Fresh"
  		       	}else if(params.appFor=="BMW Renew"){
  		       	certFor="BMW Renew"
  		       	}
  		    	def bioMedicalWasteInstance = BioMedicalWaste.get( params.indAppId )
  				def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
  				def indRegInstanceId=indRegInstance.id
  				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
  		    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where  abc.applicationFor=? order by abc.id asc",[certFor])
  		    	MultipartFile multi
  		            for(int i=0;i<docList.size();i++){
  		            //	def applicationDocumentL=ApplicationDocuments.findAll("from ApplicationDocuments apd where apd.indApplication=? and apd.level=?",[app,docName],[max:1] )
  		            	 def file = new WasteManagementFile()
  		            	def f = request.getFile((docList.get(i)).document)
  		            	if(!f.empty){
  		            		
  		            	multi = request.getFile( (docList.get(i)).document)
  		            	
  							file.size = multi.getSize() / 1024
  							file.name =multi.getOriginalFilename()
  							file.data=multi.getBytes() 
  							file.extension = extractExtension( multi )
  							file.description=docList.get(i)
  							file.createdBy=indRegInstanceGet.indName
  							file.updatedBy=indRegInstanceGet.indName
  							file.typeOfFile="BMW Documents"
  							file.indreg=indRegInstanceGet
  							file.applicationId=apliId
  							file.applicationFor=certFor
  							Byte[] bytes=multi.getBytes() 
  							if(file.save()) {
  		                	
  		                	 render(view: 'saveDocs', model: [app:app])
  		                	
  		                }
  		                	
  		        	        else {
  		        	        	
  		        	        	file.errors.each {
  		        			   }
  		        	        
  		        	        }
  		        	        }
  		 		              	  }
  		   	 render(view:'saveDocs', model: [app:app])

  		                // end //
  		            	   
  	           
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
    
    
    def saveMoreDocs = {
    		try {
                
    			if(session.indUser==null && session.userMaster==null)
                {
                  redirect(uri:'/index.gsp')
    	    		return

                }
        		def app = BioMedicalWaste.get((params.app).toInteger())
    	    	def apliId = app.id
    	    	def extn
    	    	def appType="CTO"
    		    def certFor="bmw"
    	    	def bioMedicalWasteInstance = BioMedicalWaste.get( params.app )
    			def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
    			def indRegInstanceId=indRegInstance.id
    			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    	    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=? order by abc.id asc",[appType])
    	    	def other1 = params.other
    	    	def other = params.otherDoc
    			MultipartFile multi
    	    	def file = new WasteManagementFile()
    			def otherDoc = request.getFile("otherDoc")
    	        if(!otherDoc.empty){
    	          		
    	          	multi = request.getFile("otherDoc")
    	          	file.size = multi.getSize() / 1024
    				file.name =multi.getOriginalFilename()
    				file.data=multi.getBytes() 
    				file.extension = extractExtension( multi )
    				file.description=other1
    				file.createdBy=indRegInstanceGet.indName
    			    file.updatedBy=indRegInstanceGet.indName
    				file.typeOfFile="BMW Documents"
    				file.indreg=indRegInstanceGet
    				file.applicationId=apliId
    				file.applicationFor="BMW"
    				Byte[] bytes=multi.getBytes() 
					if(file.save()) {
    	            	
    	                	 flash.message="Document Uploaded Successfully"

    	            	  render(view: 'saveDocs', model: [app: app])
    	      	       } else {
    	      	    	   render(view: 'create', model: [fileUpload: fileUpload])
    	      	          }
    	               
    	          	}
    	           
    	          	else {
    	       	    	   flash.message="Please Upload document"
    	       	          render(view: 'saveDocs', model: [app: app,other:params.other])
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
    
   def viewFile1 = {
    		try {
                
    			if(session.indUser==null && session.userMaster==null)
                {
                  redirect(uri:'/index.gsp')
    	    		return

                }
        		
            	def docType = params.docType
            	def application = params.appliLoc
            	def indApplInstance=(params.appliLoc).toLong()
            	def docName = params.docName
            	def fileLoc
            	def file
            	def docFName = docName.replace(" ","_")
            	
            	def applicationDocumentL=WasteManagementFile.findAll("from WasteManagementFile apd where apd.applicationId=? and apd.description=? order by apd.id desc",[indApplInstance,docName],[max:1] )
            	def singleInstanceOfApplicationDocument=applicationDocumentL[0]
            	response.setContentType( "application-xdownload")
            		
            	 response.setHeader("Content-Disposition", "attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"")
          	
            	
            		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
            	
            
           
               
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
    def viewFile2={

    		try {
                
    			if(session.indUser==null && session.userMaster==null)
                {
                  redirect(uri:'/index.gsp')
    	    		return

                }
        		
            	def docType = params.docType
            	def application = params.appliLoc
            	def indApplInstance=(params.appliLoc).toLong()
            	def docName = params.docName
            	def fileLoc
            	def file
            	def docFName = docName.replace(" ","_")
            	
            	def applicationDocumentL=WasteManagementFile.findAll("from WasteManagementFile apd where apd.applicationId=? and apd.description=? order by apd.id desc",[indApplInstance,docName],[max:1] )
            	def singleInstanceOfApplicationDocument=applicationDocumentL[0]
            	response.setContentType( "application-xdownload")
            		
            	 response.setHeader("Content-Disposition", "attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"")
          	
            	
            		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
            	
            
           
               
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
    def addAuthorisationPopup={

   		 try {  def app = BioMedicalWaste.get((params.id).toInteger())
   			 println("---app in addauthorization--"+app)

      	    	def certFor="bmw"  
      	    		def industryId = session.indUser
      		    	if(industryId==null || industryId=="")
      		        {
      		              redirect(controller:"userMaster",action:"logout")
      		        }

      				IndUser indUserInstance=(IndUser)session.indUser
      		    	def wasteManagementpendingDetails= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wmp where wmp.indRegInstance=? and wmp.applicationStatus='pending' and applicationFor='BMW'",[indUserInstance.industryRegMaster])
      		    	
      				def induserQuery=IndUser.get(indUserInstance.id)
      			
      				def indRegInstance=indUserInstance.industryRegMaster
      				def indRegInstanceId=indRegInstance.id
      				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
      	    	    def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=?  order by abc.id asc",[certFor])

      	    	
      	     	    def listDoc= new ArrayList()
      	    
      	    	 //def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='BMW Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
      	     	def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser.id=? order by to_date(Issued_date, 'dd/mm/yyyy')",[indRegInstanceId.toLong()])
      	     	/* for(int ig=0;ig<previousAuthList.size();ig++){
      	     		def boolCheck=false
      	     	
      	     		if(listDoc.size()==0){
      	     			
      	     			listDoc.add(applicationDocumentInstance.get(ig))
      	     		}
      	     	
      	     		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
      	     		
      	     			if(listDoc[intCheck].description==(previousAuthList.get(ig)).description){
      	     				boolCheck=true
      	     			}
      	     		}
      	     		if(boolCheck==false){
      	     			listDoc.add(applicationDocumentInstance.get(ig))
      	     		}
      	     		
      	     	}*/
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
		    activityRecInstance.status = "BMW Application "+params.id+ " Upload Add Authorisation Documents Click"
            if(activityRecInstance.save()){		   
              }
            	else{
            		activityRecInstance.errors.each {
			    	println it
			  }
		  }
      			 
      		     return [previousAuthList:previousAuthList,app:app]
      	    
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
    def viewAuthorisationPopup={
    		try{
	    	def industryId = session.indUser
	    	def userId=session.userMaster
	    	if(session.userMaster){
	    		println("-in User session-")
	    		redirect(controller:'wasteManagementProcessingDetails',action:'viewAuthorisationPopup',params:["id":params.id])
	    	}
	    	if(industryId==null || industryId=="")
	        {
	              redirect(controller:"userMaster",action:"logout")
	        }

			IndUser indUserInstance=(IndUser)session.indUser
	    	def wasteManagementpendingDetails= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wmp where wmp.indRegInstance=? and wmp.applicationStatus='pending' and applicationFor='BMW'",[indUserInstance.industryRegMaster])
	    	
			def induserQuery=IndUser.get(indUserInstance.id)
		
			def indRegInstance=indUserInstance.industryRegMaster
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
	    	//added by sharvan start from here
	    	def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser.id=? order by to_date(Issued_date, 'dd/mm/yyyy')",[indRegInstanceId.toLong()])
	    	return [previousAuthList:previousAuthList]
    }catch(Exception e){

        	e.printStackTrace();
        	flash.message = "Server Busy ..Please try after some time....";
		 	if(session.indUser){

			redirect(controller:'indUser',action:'openIndustryHome')
}			else if(session.userMaster){

			redirect(controller:'userMaster',action:'openSpcbHome');
}			else{
      
			session.invalidate()
			redirect(uri:'/index.gsp');
}
        
    }
    		}
    def deleteAuthorisationPopup={

    		try{
	    	def industryId = session.indUser
	    	if(industryId==null || industryId=="")
	        {
	              redirect(controller:"userMaster",action:"logout")
	        }

			IndUser indUserInstance=(IndUser)session.indUser
	    	def wasteManagementpendingDetails= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wmp where wmp.indRegInstance=? and wmp.applicationStatus='pending' and applicationFor='BMW'",[indUserInstance.industryRegMaster])
	    	
			def induserQuery=IndUser.get(indUserInstance.id)
		
			def indRegInstance=indUserInstance.industryRegMaster
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
	    	//added by sharvan start from here
	    	def previousAuthList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails afr where afr.indUser.id=? order by to_date(Issued_date, 'dd/mm/yyyy')",[indRegInstanceId.toLong()])
	    	return [previousAuthList:previousAuthList,indRegInstanceId:indRegInstanceId]
    }catch(Exception e){

        	e.printStackTrace();
        	flash.message = "Server Busy ..Please try after some time....";
		 	if(session.indUser){

			redirect(controller:'indUser',action:'openIndustryHome')
}			else if(session.userMaster){

			redirect(controller:'userMaster',action:'openSpcbHome');
}			else{
      
			session.invalidate()
			redirect(uri:'/index.gsp');
}
        
    }
    		
    }
    def saveAuthorisationDetails={
    		
    		def industryId = session.indUser
    		if(industryId==null || industryId=="")
	        {
	              redirect(controller:"userMaster",action:"logout")
	        }
    		IndUser indUserInstance=(IndUser)session.indUser
    		def induserQuery=IndUser.get(indUserInstance.id)
    		
		def indRegInstance=indUserInstance.industryRegMaster
    	def app4=(params.appId1)	
    	def previousAuthorisationInstance =	new BMWPreviousAuthorisationDetails()
    	previousAuthorisationInstance.application=app4
    	previousAuthorisationInstance.indUser=indRegInstance
        def x=params.bmwAppDate_value
		previousAuthorisationInstance.BMWApplication_Date=x 
        previousAuthorisationInstance.Issued_date=params.Issued_date_value
    	previousAuthorisationInstance.Valid_date=params.Valid_date_value
    	previousAuthorisationInstance.BMWAType=params.BMWAType
    	println("------params.AuthorisationNo---"+params.AuthorisationNo+"---id--"+params.appId1)
    	previousAuthorisationInstance.AuthorisationNo=params.AuthorisationNo

		  try {
			  //-----------------code for audit----19/09/17 :Start By Vineet Kumar Raghav------------------------------/
	          
		    	def app = BioMedicalWaste.get((params.appId1).toInteger())
		    	println("----app---"+app)
		    	def apliId = app.id
		    	def extn
		    	def bioMedicalWasteInstance = BioMedicalWaste.get( params.appId1 )
				def indRegInstance1=bioMedicalWasteInstance.industryRegMasterObj
				def indRegInstanceId=indRegInstance1.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
		    	println("----indRegInstanceGet---"+indRegInstanceGet)
		    	MultipartFile multi
		                def file = new WasteManagementFile()
		            	def f = params.bmwAuthAttach
		            	if(!f.empty){
		            		println("--------file size---"+f)
		            	multi = params.bmwAuthAttach
		            	
							file.size = multi.getSize() / 1024
							file.name =extractFileName(multi)+"."+extractExtension( multi )
							println("---name of file ---"+file.name)
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="BMW Previous Auth"
							file.createdBy=indRegInstanceGet.indName
							file.updatedBy=indRegInstanceGet.indName
							file.typeOfFile="BMW Documents"
							file.indreg=indRegInstanceGet
							file.applicationId=apliId
							file.applicationFor="BMW Previous Auth"
							Byte[] bytes=multi.getBytes() 
							if(file.save()) {
		                	
		                	}
		                	
		        	        else {
		        	        	
		        	        	file.errors.each {
		        			   }
		        	        
		        	        }
		        	        }
		    	def fileId=file.id
		    	previousAuthorisationInstance.wasteManagementFileId=fileId
		    	if(previousAuthorisationInstance.save()){
		    		
		   	 render(view:'addAuthorisationPopup', model: [app:app,previousAuthorisationInstance:previousAuthorisationInstance])
		    	}
		                // end //
		            	   
	           
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
    
    		def viewAuthorisationAttached={
    		try {
                def application = params.appliLoc
            	def indApplInstance=(params.appliLoc).toLong()
            	println("--indApplInstance--"+indApplInstance)
            	def docName = params.docName
            	def fileLoc
            	def file
            	def applicationDocumentL=WasteManagementFile.findAll("from WasteManagementFile apd where apd.id=?  order by apd.id desc",[indApplInstance],[max:1] )
            	println("----applicationDocumentL---"+applicationDocumentL.size())
            	def singleInstanceOfApplicationDocument=applicationDocumentL[0]
            	response.setContentType( "application-xdownload")
            		
            	 response.setHeader("Content-Disposition", "attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"")
          	
            		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
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
    	def deleteAuthorisation={ try{
    		def app 
    		if(params.appId){
    			def indRegId=IndustryRegMaster.get((params.appId).toLong())
    			app = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails abc where abc.indUser=? ",[indRegId])
    		}
    		else{
		  app=BMWPreviousAuthorisationDetails.find("from BMWPreviousAuthorisationDetails abc where abc.id=? ",[params.appId])
	}
    		if((params.delete).getClass().getName()== "java.lang.String"){
    			def bmwPreviousAuthorisationDetails = BMWPreviousAuthorisationDetails.find("from BMWPreviousAuthorisationDetails abc where abc.id=? ",[(params.delete).toLong()])
    			def wasteId=bmwPreviousAuthorisationDetails.wasteManagementFileId
    			def wasteManagementFileInstance=WasteManagementFile.find("from WasteManagementFile abc where abc.id=? ",[wasteId.toLong()])
    			wasteManagementFileInstance.delete();
    			bmwPreviousAuthorisationDetails.delete()
    		}else{
    			if(params.delete){
    				for(int i=0;i<(params.delete).size();i++){
    					def bmwPreviousAuthorisationDetails = BMWPreviousAuthorisationDetails.find("from BMWPreviousAuthorisationDetails abc where abc.id=? ",[(params.delete[i]).toLong()])
    					def wasteId=bmwPreviousAuthorisationDetails.wasteManagementFileId
    	    			def wasteManagementFileInstance=WasteManagementFile.find("from WasteManagementFile abc where abc.id=? ",[wasteId.toLong()])
    	    			wasteManagementFileInstance.delete();
    	    			bmwPreviousAuthorisationDetails.delete()
    				}
    			}
		
	}
    		redirect(action:deleteAuthorisationPopup,id:app)
    		}catch(Exception e){
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
    		}}
    
    def extractFileName(MultipartFile file){
		String fileName=file.getOriginalFilename()
		return fileName.substring(0, fileName.lastIndexOf("."));
	}
    def delAppBMW={
    		
    }
    def deleteApp={
            try{
			println("Params in deleteApp-----"+params) ;
			def bmwApplicationId = params.surroundingName;
			def bioMedicalWasteInstance =BioMedicalWaste.get(bmwApplicationId.toLong())
			if(bmwApplicationId)
			{
				println("bioMedicalWasteInstance-----"+bioMedicalWasteInstance);
				def feeChequeRecordBMWInstList=FeeChequeRecordBMW.findAll("from FeeChequeRecordBMW charachter where charachter.indApplication=? ",[bioMedicalWasteInstance]);
			    if(feeChequeRecordBMWInstList){
					for(int i=0;i<feeChequeRecordBMWInstList.size();i++){
						feeChequeRecordBMWInstList.get(i).delete()
					}
				}
			    
			    def feeBankDetailsInstance = FeeBankDetailsBMW.findAll("from FeeBankDetailsBMW indPower where indPower.application=?",[bioMedicalWasteInstance])
            	println("feeBankDetailsInstance-----"+feeBankDetailsInstance);
			    if(feeBankDetailsInstance){
					for(int i=0;i<feeBankDetailsInstance.size();i++){
						feeBankDetailsInstance.get(i).delete()
					}
				}
			    
			  def feeBankOtherDetailsBMWInstance = FeeBankOtherDetailsBMW.findAll("from FeeBankOtherDetailsBMW indPower where indPower.application=?",[bioMedicalWasteInstance])
            	println("feeBankDetailsInstance-----"+feeBankOtherDetailsBMWInstance);
			    if(feeBankOtherDetailsBMWInstance){
					for(int i=0;i<feeBankOtherDetailsBMWInstance.size();i++){
						feeBankOtherDetailsBMWInstance.get(i).delete()
					}
				}
			    
			    def consentFeeMasterList = ConsentFeeMasterBMW.findAll("from ConsentFeeMasterBMW s where s.application=? order by id asc",[bioMedicalWasteInstance])
               println("consentFeeMasterList-----"+consentFeeMasterList);
			    if(consentFeeMasterList){
					for(int i=0;i<consentFeeMasterList.size();i++){
						consentFeeMasterList.get(i).delete()
					}
				}
			    def deletionFromWasteFile = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationId=?",[bmwApplicationId.toLong()])
				println("deletionFromWasteFile-----------"+deletionFromWasteFile) 
				if(deletionFromWasteFile){
					
					for(int i=0;i<deletionFromWasteFile.size();i++){
						deletionFromWasteFile.get(i).delete()
					  }
				}
			    
			    def deletionFromBioMedicalWaste = BioMedicalWaste.findAll("from BioMedicalWaste abc where abc.id=? ",[bmwApplicationId.toLong()])
               println("deletionFromBioMedicalWaste-----"+deletionFromBioMedicalWaste);
			    if(deletionFromBioMedicalWaste){

				for(int i=0;i<deletionFromBioMedicalWaste.size();i++){
					deletionFromBioMedicalWaste.get(i).delete()
				}
				flash.message="Application  Deleted Successfully ."
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
			    activityRecInstance.activity = "delete"
	            activityRecInstance.status = "BMW Inprogress Application "+bmwApplicationId+" Delete."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
				    	println it
				  }
			  }
				render(view:'delAppBMW')

				}
			    
            }
			else {
				flash.message="Please select Application Id !! "
				render(view:'delAppBMW')

		}
            }catch(Exception e){

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
    def viewAuthorisationPopupForOnline={
    		println("--Invoked---"+params.id)
    		def indRegId=WasteManagementPendingDetails.get((params.id).toLong())
    		def wasteManagementcertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates wmc where wmc.indreg=? and applicationFor='BMW' and typeOfFile='uploaded'  order by wmc.id desc",[indRegId.indRegInstance])
    		println("--Invoked---"+wasteManagementcertificate.id)
    		redirect(action:"viewAuthorisation",params:["id":wasteManagementcertificate.get(0).id])
    }
    def viewAuthorisation={
    		def applicationDocumentL=WasteManagementCertificates.find("from WasteManagementCertificates apd where apd.id=?",[(params.id).toLong()] )
        	def singleInstanceOfApplicationDocument=applicationDocumentL
        	response.setContentType( "application-xdownload")
        	response.setHeader("Content-Disposition", "attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"")
      	  response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
        	
        
    }
    def deleteAppForHMW={
    		try{
    		println("--Invoked deleteAppForHMW--")
    		render(view:'delAppBMW')
    		}catch(Exception e){
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
    def viewMasterPdf={
    		def applicationDocumentL=WasteManagementFile.find("from WasteManagementFile apd where apd.id=?",[(params.id).toLong()] )
        	def singleInstanceOfApplicationDocument=applicationDocumentL
        	response.setContentType( "application-xdownload")
        	response.setHeader("Content-Disposition", "attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"")
      	  response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
        	
        
    }
    
    def paymentAlreadySub={
    		println("----paymentAlreadySub------"+params.id)
    	def bioMedId=BioMedicalWaste.get(params.id)
    		def applicationProcessingDetails1 = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails indPower where indPower.applicationId=? order by indPower.id desc",[String.valueOf(bioMedId.id)])
 			if(applicationProcessingDetails1 !=null){
 				
 				if(applicationProcessingDetails1.returned==true){
 					bioMedId.completionStatus = "Completed"
 					bioMedId.save()
 					RouteWasteManagement a=new RouteWasteManagement()
    		  			def appFor1 = "BMW"
                			a.routeWasteManagementApp(bioMedId.id,appFor1,bioMedId.industryRegMasterObj)
        					flash.message = "Application re-submitted sucessfully" 
            		}
        			 redirect(action:showNewFormat,id:bioMedId.id)	
        return
 		
    }
}
    
//  UpdateAllSummaryReportWMS
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
    def popChallan = {
        	try {
                
            	def indApplicationDetailsInstance = BioMedicalWaste.get(params.id)
            	def feesBankOnlineInstance = BankTransactionDetailsBMW.findAll("from BankTransactionDetailsBMW fee where fee.bioApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
            	def check = false
            	//def neftTransInstance = NeftTransactionBMWDetails.find("from NeftTransactionBMWDetails fee where fee.indApplication=? order by id ",[indApplicationDetailsInstance])
            	
            	
            	
            	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
        		def feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(indApplicationDetailsInstance)
            
            	[appDetId:params.id,feesBankOnlineInstance:feesBankOnlineInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,group:group.group.groupName,feeDetailsList:feeDetailsList]
               
                   
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
  