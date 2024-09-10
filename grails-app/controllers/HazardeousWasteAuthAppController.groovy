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
import java.text.Format;
import org.springframework.web.multipart.MultipartFile

class HazardeousWasteAuthAppController {
	
	def index = { 
			 try {redirect(action:list,params:params)
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
				def industryId = session.indUser
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
					
				}
				println("industryId---"+industryId)
				def indUserID = industryId.industryRegMaster
				def status1 = "Inprogress"
				def status2="Completed"
				def hazardeousWasteAuthAppInstanceInprogressList = HazardeousWasteAuthApp.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status1)
				def hazardeousWasteAuthAppInstanceCompletedList = HazardeousWasteAuthApp.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status2)
				def municipalSolidWasteInprogressList = MunicipalSolidWaste.findAllWhere(indRegMasterObj:indUserID , completionStatus : status1)
				def municipalSolidWasteCompletedList = MunicipalSolidWaste.findAllWhere(indRegMasterObj:indUserID , completionStatus : status2)
				def bioMedicalWasteInprogressList = BioMedicalWaste.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status1)
				def bioMedicalWasteCompletedList = BioMedicalWaste.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status2)
				params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				[ hazardeousWasteAuthAppInstanceInprogressList: hazardeousWasteAuthAppInstanceInprogressList,hazardeousWasteAuthAppInstanceCompletedList: hazardeousWasteAuthAppInstanceCompletedList,municipalSolidWasteInprogressList: municipalSolidWasteInprogressList,municipalSolidWasteCompletedList: municipalSolidWasteCompletedList,bioMedicalWasteInprogressList: bioMedicalWasteInprogressList,bioMedicalWasteCompletedList: bioMedicalWasteCompletedList ,hazardeousWasteAuthAppInstanceTotal: hazardeousWasteAuthAppInstanceInprogressList.size() ]
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
				def industryId = session.indUser
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
				def appId=hazardeousWasteAuthAppInstance.id
				def appFor="HWM"
				def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
				def certInstance=checkCertificate[0]
				def certInstanceId
				if(certInstance){
					certInstanceId=certInstance.id
				}
				def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				
				def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				def wasteManagementFileList = WasteManagementFile.findAll("from WasteManagementFile as wmf where applicationId=? and wmf.typeOfFile!='attachedInspectionReport' and wmf.typeOfFile!='attachedClarificationReport' and wmf.typeOfFile!='HazardeousProfile' and wmf.typeOfFile!='inspectionReport' and wmf.typeOfFile!='indClarificationFile' ",[hazardeousWasteAuthAppInstance.id])
				
				String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
				ArrayList tmp1=new ArrayList()
				tmp1=tmp.split(",")
				
				if(!hazardeousWasteAuthAppInstance) {
					flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					render(view:'showTest',model:[ certInstanceId:certInstanceId,hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1] )
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
				def industryId = session.indUser
				def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
				def appId=hazardeousWasteAuthAppInstance.id
				def appFor="HWM"
				def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
				def certInstance=checkCertificate[0]
				def certInstanceId
				if(certInstance){
					certInstanceId=certInstance.id
				}
				def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				
				def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				def wasteManagementFileList = WasteManagementFile.findAll("from WasteManagementFile as wmf where applicationId=? and wmf.typeOfFile!='attachedInspectionReport' and wmf.typeOfFile!='attachedClarificationReport' and wmf.typeOfFile!='inspectionReport' and wmf.typeOfFile!='indClarificationFile' ",[hazardeousWasteAuthAppInstance.id])
				
				String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
				ArrayList tmp1=new ArrayList()
				tmp1=tmp.split(",")
				
				if(!hazardeousWasteAuthAppInstance) {
					flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					render(view:'showTest',model:[ certInstanceId:certInstanceId,hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1] )
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
		def industryId = session.indUser
		if(industryId==null || industryId=="") {
			flash.message="Your session has been expired ! Please login again."
			redirect(controller:"userMaster",action:"logout")
		}
		def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
		if(hazardeousWasteAuthAppInstance) {
			try {
				hazardeousWasteAuthAppInstance.delete()
				flash.message = "HazardeousWasteAuthApp ${params.id} deleted"
				redirect(action:list)
			}
			catch(org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "HazardeousWasteAuthApp ${params.id} could not be deleted"
				redirect(action:show,id:params.id)
			}
		}
		else {
			flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit1={
		 try {
				def industryId = session.indUser
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( (params.idCH).toLong() )
				def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
				ArrayList tmp1=new ArrayList()
				tmp1=tmp.split(",")
				
				if(!hazardeousWasteAuthAppInstance) {
					flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					render(view:'edit',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , tmp1:tmp1])
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
				def industryId = session.indUser
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( (params.id).toLong() )
				def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
				String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
				ArrayList tmp1=new ArrayList()
				tmp1=tmp.split(",")
				
				if(!hazardeousWasteAuthAppInstance) {
					flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					return [ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , tmp1:tmp1]
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
				def industryId = session.indUser
				def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.hazardeousWasteAuthAppInstanceId )
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				IndUser indUserInstance=(IndUser)session.indUser
				def indRegInstance=indUserInstance.industryRegMaster
				def editId = params.hazardeousWasteAuthAppInstanceId
				def checkOM=true
				def chekin = true
				if(params.product_Name.getClass().getName()!="java.lang.String") {
					for(int i =0 ; i<params.product_Name.size();i++) {
						if(checkOM){
							if(params.product_Name[i]=="") {
								flash.message = "Please Enter all Product Names"
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.product_Qty[i]=="") {
								flash.message = "Please Enter all Product's Quantity "
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(!(params.product_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Product's Quantity "
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
								
							}
							else if(params.by_Product_Name[i]=="") {
								flash.message = "Please Enter all By-Product Names"
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.by_Product_Qty[i]=="") {
								flash.message = "Please Enter all By-Product's Quantity "
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(!(params.by_Product_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For By-Product's Quantity "
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
								
							}
							else if(params.raw_Material_Name[i]=="") {
								flash.message = "Please Enter all Raw Material Names"
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.raw_Material_Qty[i]=="") {
								flash.message = "Please Enter all Raw-Material's Quantity "
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(!(params.raw_Material_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Raw-Material's Quantity "
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
						}
					}
				}
				def testString=params.hw_Type
				if(testString.getClass().getName()!="java.lang.String"){
					for(int i =0 ; i<testString.size();i++){
						if(checkOM){
							if(params.hw_Type[i]=="") {
								flash.message = "Please Enter all Hazardous Waste Type"
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.hw_Qty[i]=="") {
								flash.message = "Please Enter all Hazardous Waste's Quantity "
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(!(params.hw_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Hazardous Waste's Quantity "
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
								
							}
							else if(params.hw_Source[i]=="") {
								flash.message = "Please Enter all Hazardous Waste Source"
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.mode_Of_Storage[i]=="") {
								flash.message = "Please Enter all Mode Of Storage"
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.method_Of_Disposal[i]=="") {
								flash.message = "Please Enter all Method Of Disposal"
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(params.capacity_Of_Disposal[i]=="") {
								flash.message = "Please Enter all Capacity of Disposal "
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
							else if(!(params.capacity_Of_Disposal[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Capacity of Disposal "
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
								
							}else if(params.quantityDisposed[i]=="") {
								flash.message = "Please Enter all Quantity disposed"
								chekin = false
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}else if(!(params.quantityDisposed[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Quantity Disposed "
								chekin = false	
								checkOM= false
								redirect(action:'edit1',params:[idCH:params.hazardeousWasteAuthAppInstanceId])
							}
						}
					}
				}    	
				if(chekin) {
					if(hazardeousWasteAuthAppInstance) {
						if(params.version) {
							def version = params.version.toLong()
							if(hazardeousWasteAuthAppInstance.version > version) {
								
								hazardeousWasteAuthAppInstance.errors.rejectValue("version", "hazardeousWasteAuthApp.optimistic.locking.failure", "Another user has updated this HazardeousWasteAuthApp while you were editing.")
								render(view:'edit',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance])
								return
							}
						}
						hazardeousWasteAuthAppInstance.completionStatus=params.progress_Status
						hazardeousWasteAuthAppInstance.expectedReturn=(params.expectedReturn).toLong()
						String authReqFor=""
						if(params['chkCollection']=="on") {
							authReqFor=authReqFor.concat("Collection")
							authReqFor=authReqFor.concat(",")
						}
						if(params['chkReception']=="on") {
							authReqFor=authReqFor.concat("Reception")
							authReqFor=authReqFor.concat(",")
						}
						if(params['chkTreatment']=="on") {
							authReqFor=authReqFor.concat("Treatment")
							authReqFor=authReqFor.concat(",")
						}
						if(params['chkTransport']=="on") {
							authReqFor=authReqFor.concat("Transport")
							authReqFor=authReqFor.concat(",")
						}
						if(params['chkStorage']=="on") {
							authReqFor=authReqFor.concat("Storage")
							authReqFor=authReqFor.concat(",")
						}
						if(params['chkDisposal']=="on") {
							authReqFor=authReqFor.concat("Disposal")
							authReqFor=authReqFor.concat(",")
						}
						hazardeousWasteAuthAppInstance.authorization_Required_For=authReqFor
						hazardeousWasteAuthAppInstance.is_Renew=params.is_Renew
						if(hazardeousWasteAuthAppInstance.is_Renew=="Yes") {
							hazardeousWasteAuthAppInstance.auth_Renew_No=(params.auth_Renew_No).toLong();
							
							
							def dateCheck=params.auth_Renew_Date_value
							def x
							def sqlCurrentDate
							def currentDate=new Date()
							DateCustom dd=new DateCustom()
							sqlCurrentDate=dd.sQLdate(currentDate)
							if(dateCheck) {
								def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
								x= sdfh.parse(dateCheck);
								hazardeousWasteAuthAppInstance.auth_Renew_Date=x
							}
						}
						
						hazardeousWasteAuthAppInstance.hw_Defined=params.hw_Defined
						hazardeousWasteAuthAppInstance.industryRegMasterObj=indRegInstance
						
						hazardeousWasteAuthAppInstance.updatedBy=indRegInstance.indName
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						def date = new Date();
						def t = dateFormat.format(date)
						
						if(!hazardeousWasteAuthAppInstance.hasErrors() && hazardeousWasteAuthAppInstance.save()) {
							def indHWProductDetailsInstance =new IndHWProductDetails()
							if(params.indHWProductDetailsInstanceId.getClass().getName()=="java.lang.String" && !(params.indHWProductDetailsInstanceId=="") ) {
								indHWProductDetailsInstance = IndHWProductDetails.get( params.indHWProductDetailsInstanceId )
								indHWProductDetailsInstance.delete()
							}
							else {
								
								for(int i=0;i<params.indHWProductDetailsInstanceId.size();i++) {
									indHWProductDetailsInstance =new IndHWProductDetails()
									indHWProductDetailsInstance = IndHWProductDetails.get( params.indHWProductDetailsInstanceId[i] )
									indHWProductDetailsInstance.delete()
								}
							}
							indHWProductDetailsInstance = new IndHWProductDetails(params)
							if(params.product_Name.getClass().getName()=="java.lang.String"){
								
								
								indHWProductDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
								indHWProductDetailsInstance.createdBy=indRegInstance.indName
								indHWProductDetailsInstance.save()
							}
							else{
								for(int i=0;i<params.product_Name.size();i++) {
									indHWProductDetailsInstance = new IndHWProductDetails(params)
									indHWProductDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
									indHWProductDetailsInstance.product_Name=params.product_Name[i]
									indHWProductDetailsInstance.product_Qty=params.product_Qty[i].toInteger()
									indHWProductDetailsInstance.by_Product_Name=params.by_Product_Name[i]
									indHWProductDetailsInstance.by_Product_Qty=params.by_Product_Qty[i].toInteger()
									indHWProductDetailsInstance.raw_Material_Name=params.raw_Material_Name[i]
									indHWProductDetailsInstance.raw_Material_Qty=params.raw_Material_Qty[i].toInteger()
									indHWProductDetailsInstance.createdBy=indRegInstance.indName
									indHWProductDetailsInstance.save()
								}
							}
							
							def indHazardeousWasteDetailsInstance = new IndHazardeousWasteDetails()
							if(params.indHazardeousWasteDetailsInstanceId.getClass().getName()=="java.lang.String" && !(params.indHazardeousWasteDetailsInstanceId=="")) {
								indHazardeousWasteDetailsInstance = IndHazardeousWasteDetails.get( params.indHazardeousWasteDetailsInstanceId )
								indHazardeousWasteDetailsInstance.delete()
							}
							else {
								for(int i=0;i<params.indHazardeousWasteDetailsInstanceId.size();i++) {
									indHazardeousWasteDetailsInstance = new IndHazardeousWasteDetails()
									indHazardeousWasteDetailsInstance = IndHazardeousWasteDetails.get( params.indHazardeousWasteDetailsInstanceId[i] )
									indHazardeousWasteDetailsInstance.delete()
								}
							}
							if(params.hw_Type.getClass().getName()=="java.lang.String") {
								indHazardeousWasteDetailsInstance = new IndHazardeousWasteDetails(params)
								indHazardeousWasteDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
								indHazardeousWasteDetailsInstance.waste_Characteristics=params.characteristics
								indHazardeousWasteDetailsInstance.quantityDisposed=params.quantityDisposed.toInteger()
								indHazardeousWasteDetailsInstance.createdBy=indRegInstance.indName
								indHazardeousWasteDetailsInstance.save()
							}
							else {
								for(int i=0;i<params.hw_Type.size();i++) {
									indHazardeousWasteDetailsInstance = new IndHazardeousWasteDetails(params)
									indHazardeousWasteDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
									indHazardeousWasteDetailsInstance.hw_Type=params.hw_Type[i]
									indHazardeousWasteDetailsInstance.waste_Characteristics=params.characteristics[i]
									indHazardeousWasteDetailsInstance.quantityDisposed=params.quantityDisposed[i].toInteger()
									indHazardeousWasteDetailsInstance.hw_Qty=params.hw_Qty[i].toInteger()
									indHazardeousWasteDetailsInstance.hw_Source=params.hw_Source[i]
									indHazardeousWasteDetailsInstance.mode_Of_Storage=params.mode_Of_Storage[i]
									indHazardeousWasteDetailsInstance.method_Of_Disposal=params.method_Of_Disposal[i]
									indHazardeousWasteDetailsInstance.capacity_Of_Disposal=params.capacity_Of_Disposal[i].toInteger()
									indHazardeousWasteDetailsInstance.createdBy=indRegInstance.indName
									indHazardeousWasteDetailsInstance.save()
								}
							}
							
							def strID=(hazardeousWasteAuthAppInstance.id).toString()
							WasteManagementFile file=new WasteManagementFile()
							def checkFileDel=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='flowDiagramManufacturingProcess' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel1=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='locationOfSite' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel2=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='processingTechDetails' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel3=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='siteClearance' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel4=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='utilizationProgramme' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel5=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='disposalMethod' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel6=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='wasteNatureAndComposition' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel7=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='landfillingIncinerationMethodology' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel8=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='preventionAndControlMeasures' ",[hazardeousWasteAuthAppInstance.id])
							def checkFileDel9=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? and wmf.applicationFor='HWM' and wmf.typeOfFile='safetyMeasures' ",[hazardeousWasteAuthAppInstance.id])
						
						def flowDiagramManufactureProcess
						def locationSite
						def detailsOfProcessing
						def siteClearance
						def utilizationProgramme
						def methodOfDisposal
						def compositionWaste
						def detailsOfLandfilling
						def environmentalPollution
						def safetyWorkers
						def f = request.getFile('flowDiagramManufacturingProcess')
							MultipartFile multi = request.getFile('flowDiagramManufacturingProcess')
							if(!f.empty) {
								flowDiagramManufactureProcess = "Attached"
								
								if(checkFileDel){
									def sizeCH=checkFileDel.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Flow Diagram Of Manufacturing Process"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="flowDiagramManufacturingProcess"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
								
							}
							
							file=new WasteManagementFile()
							f = request.getFile('locationOfSite')
							multi = request.getFile('locationOfSite')
							if(!f.empty) {
								
								locationSite = "Attached"
								if(checkFileDel1){
									def sizeCH=checkFileDel1.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel1[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Location Of Site(Map)"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="locationOfSite"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('processingTechDetails')
							multi = request.getFile('processingTechDetails')
							
							if(!f.empty) {
								
								detailsOfProcessing = "Attached"
								
								if(checkFileDel2){
									
									def sizeCH=checkFileDel2.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel2[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Details of Processing Technology"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="processingTechDetails"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('siteClearance')
							multi = request.getFile('siteClearance')
							if(!f.empty) {
								
								siteClearance = "Attached"
								
								if(checkFileDel3){
									def sizeCH=checkFileDel3.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel3[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Site Clearance(From local authority, if any)"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="siteClearance"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('utilizationProgramme')
							multi = request.getFile('utilizationProgramme')
							if(!f.empty) {
								
								utilizationProgramme = "Attached"
								
								if(checkFileDel4){
									def sizeCH=checkFileDel4.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel4[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Utilization Programme For Waste Processed"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="utilizationProgramme"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('disposalMethod')
							multi = request.getFile('disposalMethod')
							if(!f.empty) {
							
								methodOfDisposal = "Attached"
								
								if(checkFileDel5){
									def sizeCH=checkFileDel5.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel5[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Method Of Disposal"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="disposalMethod"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('wasteNatureAndComposition')
							multi = request.getFile('wasteNatureAndComposition')
							if(!f.empty) {
							
								compositionWaste = "Attached"
								
								if(checkFileDel6){
									def sizeCH=checkFileDel6.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel6[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Nature And Composition Of Waste"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="wasteNatureAndComposition"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('landfillingIncinerationMethodology')
							multi = request.getFile('landfillingIncinerationMethodology')
							if(!f.empty) {
							detailsOfLandfilling = "Attached"
								if(checkFileDel7){
									def sizeCH=checkFileDel7.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel7[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Methodology For Landfilling/Incineration"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="landfillingIncinerationMethodology"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('preventionAndControlMeasures')
							multi = request.getFile('preventionAndControlMeasures')
							if(!f.empty) {
								
								environmentalPollution = "Attached"
								
								if(checkFileDel8){
									def sizeCH=checkFileDel8.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel8[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Prevention And Control Measures"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="preventionAndControlMeasures"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							file=new WasteManagementFile()
							f = request.getFile('safetyMeasures')
							multi = request.getFile('safetyMeasures')
							if(!f.empty) {
							safetyWorkers = "Attached"
								if(checkFileDel9){
									def sizeCH=checkFileDel9.size()
									for(int i=0;i<sizeCH;i++){
										def insDEL=checkFileDel9[i]
										if(insDEL){
											insDEL.delete()
										}
									}
								}
								file.size = multi.getSize() / 1024
								file.name =multi.getOriginalFilename()
								file.data=multi.getBytes() 
								file.extension = extractExtension( multi )
								file.description="Safety Measures"
								file.createdBy=indRegInstance.indName
								file.typeOfFile="safetyMeasures"
								file.indreg=indRegInstance
								file.applicationId=hazardeousWasteAuthAppInstance.id
								file.applicationFor="HWM"
								file.save()
							}
							
							def hazardeousId = hazardeousWasteAuthAppInstance.id
							def app = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=?",[hazardeousId])
							def app1 = app.description
						
							if(app1.contains("Flow Diagram Of Manufacturing Process"))
							{
								flowDiagramManufactureProcess = "Attached"
							}
							if(app1.contains("Location Of Site(Map)"))
							{
								locationSite = "Attached"
							}
							if(app1.contains("Details of Processing Technology"))
							{
								detailsOfProcessing = "Attached"
							}
							if(app1.contains("Site Clearance(From local authority, if any)"))
							{
								siteClearance = "Attached"
							}
							if(app1.contains("Utilization Programme For Waste Processed"))
							{
								utilizationProgramme = "Attached"
							}
							if(app1.contains("Method Of Disposal"))
							{
								methodOfDisposal = "Attached"
							}
							if(app1.contains("Nature And Composition Of Waste"))
							{
								compositionWaste = "Attached"
							}
							if(app1.contains("Methodology For Landfilling/Incineration"))
							{
								detailsOfLandfilling = "Attached"
							}
							if(app1.contains("Prevention And Control Measures"))
							{
								environmentalPollution = "Attached"
							}
							if(app1.contains("Safety Measures"))
							{
								safetyWorkers = "Attached"
							}
							if(flowDiagramManufactureProcess!= "Attached")
							{
								flowDiagramManufactureProcess = "Not Attached"
							}
							if(locationSite!= "Attached")
							{
								locationSite = "Not Attached"
							}
							if(detailsOfProcessing!= "Attached")
							{
								detailsOfProcessing = "Not Attached"
							}
							if(siteClearance!= "Attached")
							{
								siteClearance = "Not Attached"
							}
							if(utilizationProgramme!= "Attached")
							{
								utilizationProgramme = "Not Attached"
							}
							if(methodOfDisposal!= "Attached")
							{
								methodOfDisposal = "Not Attached"
							}
							if(compositionWaste!= "Attached")
							{
								compositionWaste = "Not Attached"
							}
							if(detailsOfLandfilling!= "Attached")
							{
								detailsOfLandfilling = "Not Attached"
							}
							if(environmentalPollution!= "Attached")
							{
								environmentalPollution = "Not Attached"
							}
							if(safetyWorkers!= "Attached")
							{
								safetyWorkers = "Not Attached"
							}
							
							WasteManagementFile file1=new WasteManagementFile()
							File certFile
							HazardeousWasteFormPdf pdfG=new HazardeousWasteFormPdf()
							
							def txtIndName=params.txtIndName
							def txtIndCity=params.txtIndCity
							def txtIndTehsil=params.txtIndTehsil
							def txtIndDistrict=params.txtIndDistrict
							def txtIndAddress=params.txtIndAddress
							def txtIndPin=params.txtIndPin
							def hw_Defined=params.hw_Defined
							def totalCapitalInves=params.totalCapitalInves
							def yearofcommision=params.yearofcommision
							def auth_Renew_Date=params.auth_Renew_Date_value
							def industryShift=params.industryShift
							def auth_Renew_No=params.auth_Renew_No
							def location_Of_Activity=params.location_Of_Activity
							def expectedReturn=params.expectedReturn
							def productList= new ArrayList()
							
							def productDetailsList= new ArrayList()
							if(params.product_Name.getClass().getName()=="java.lang.String"){
								productList.add(params.product_Name)
								productList.add(params.product_Qty)
								productList.add(params.by_Product_Name)
								productList.add(params.by_Product_Qty)
								
								productDetailsList.add(productList)		
							
							}
							else
							{
							for(int i=0;i<params.product_Name.size();i++) 
							{
								productList.add(params.product_Name[i])
								productList.add(params.product_Qty[i])
								productList.add(params.by_Product_Name[i])
								productList.add(params.by_Product_Qty[i])
								
							}
							productDetailsList.add(productList)
							}
							def rawMaterialList= new ArrayList()
							def rawMaterialDetailsList= new ArrayList()
							if(params.product_Name.getClass().getName()=="java.lang.String"){
								rawMaterialList.add(params.raw_Material_Name)
								rawMaterialList.add(params.raw_Material_Qty)
								
								rawMaterialDetailsList.add(rawMaterialList)		
							
							}
							else
							{
							for(int i=0;i<params.product_Name.size();i++) 
							{
								rawMaterialList.add(params.raw_Material_Name[i])
								rawMaterialList.add(params.raw_Material_Qty[i])
								
							}
							rawMaterialDetailsList.add(rawMaterialList)
							}
							def hazarWasteList= new ArrayList()
							
							def hazarWasteDetailsList= new ArrayList()
							if(params.hw_Type.getClass().getName()=="java.lang.String"){
								hazarWasteList.add(params.hw_Type)
								hazarWasteList.add(params.hw_Qty)
								
								hazarWasteDetailsList.add(hazarWasteList)		
							
							}
							else
							{
							for(int i=0;i<params.hw_Type.size();i++) 
							{
								hazarWasteList.add(params.hw_Type[i])
								hazarWasteList.add(params.hw_Qty[i])
								
							}
							hazarWasteDetailsList.add(hazarWasteList)
							}
							def hazarWasteList1= new ArrayList()
							
							def hazarWasteDetailsList1= new ArrayList()
							if(params.hw_Type.getClass().getName()=="java.lang.String"){
								hazarWasteList1.add(params.hw_Type)
								hazarWasteList1.add(params.hw_Qty)
								hazarWasteList1.add(params.hw_Source)
								hazarWasteList1.add(params.mode_Of_Storage)
								hazarWasteList1.add(params.method_Of_Disposal)
								hazarWasteList1.add(params.capacity_Of_Disposal)
										
								hazarWasteDetailsList1.add(hazarWasteList1)		
							}
							else
							{
							for(int i=0;i<params.hw_Type.size();i++) 
							{
								hazarWasteList1.add(params.hw_Type[i])
								hazarWasteList1.add(params.hw_Qty[i])
								hazarWasteList1.add(params.hw_Source[i])
								hazarWasteList1.add(params.mode_Of_Storage[i])
								hazarWasteList1.add(params.method_Of_Disposal[i])
								hazarWasteList1.add(params.capacity_Of_Disposal[i])
							}
							hazarWasteDetailsList1.add(hazarWasteList1)
							}
							hazardeousWasteAuthAppInstance.properties = params
							if(!hazardeousWasteAuthAppInstance.hasErrors() && hazardeousWasteAuthAppInstance.save()) {
								def appFor="HWM"
								def industryRegInstanceWaste=indRegInstance
								if(hazardeousWasteAuthAppInstance.completionStatus=="Completed"){
									certFile = pdfG.hazaFunction(txtIndName,txtIndCity,txtIndTehsil,txtIndDistrict,txtIndAddress,txtIndPin,location_Of_Activity,authReqFor,auth_Renew_No,auth_Renew_Date,hw_Defined,totalCapitalInves,yearofcommision,expectedReturn,flowDiagramManufactureProcess,locationSite,detailsOfProcessing,siteClearance,utilizationProgramme,methodOfDisposal,compositionWaste,detailsOfLandfilling,environmentalPollution,safetyWorkers,industryShift,productDetailsList,rawMaterialDetailsList,hazarWasteDetailsList,hazarWasteDetailsList1)  
									byte[] b = new byte[(int) certFile.length()];
									FileInputStream fileInputStream = new FileInputStream(certFile);
									fileInputStream.read(b);
									def fileLength=certFile.length()
									file1.size = fileLength / 1024  //f.getSize()
									file1.extension ="pdf"//extractExtension( f )
									file1.data=b;
									file1.name="HazardeousWasteForm.pdf"
									file1.description="Hazardeous Saved"
									if(indRegInstance.indName){
										file1.createdBy=session.indUser
										file1.updatedBy=session.indUser
									}
									
									file1.typeOfFile="HazardeousProfile"
									file1.indreg=indRegInstance.get(indRegInstance.id.toLong())
									file1.applicationFor="HazardeousWaste"
									file1.dateCreated=dateFormat.parse(t)
									file1.applicationId=hazardeousWasteAuthAppInstance.id
									if(file1.save()) { 
									}
									else {
									}
									RouteWasteManagement routeWaste=new RouteWasteManagement()
									def routed=routeWaste.routeWasteManagementApp(hazardeousWasteAuthAppInstance.id,appFor,industryRegInstanceWaste)
									flash.message ="Congratulations! Your Application No. ${hazardeousWasteAuthAppInstance.id} is submitted successfully." 
								}
								else{
									flash.message="Your Application No. ${hazardeousWasteAuthAppInstance.id} is saved and available for future update..."
								}
								redirect(action:show,id:hazardeousWasteAuthAppInstance.id)
							}
							else {
								render(view:'edit',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance])
							}
						}
					}
					else {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
						redirect(action:edit,id:params.id)
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
	
	def create = {
		 try {
				def industryId = session.indUser
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				
				def hazardeousWasteAuthAppInstance = new HazardeousWasteAuthApp()
				IndUser indUserInstance=(IndUser)session.indUser
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				hazardeousWasteAuthAppInstance.properties = params
				return ['hazardeousWasteAuthAppInstance':hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil]
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
				println("PARAMS IN SAVE METHOD----------"+params);
			 	def industryId = session.indUser
				IndUser indUserInstance=(IndUser)session.indUser
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				def hazardeousWasteAuthAppInstance = new HazardeousWasteAuthApp(params)
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				def checkinOM=true
				def chekin = true
				def checkinForWaste=true
				if(params.product_Name.getClass().getName()!="java.lang.String") {
					for(int i =0 ; i<params.product_Name.size();i++) {
						if(checkinOM){
							if(params.product_Name[i]=="") {
								flash.message = "Please Enter all Product Names"
								chekin = false
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.product_Qty[i]=="") {
								flash.message = "Please Enter all Product's Quantity "
								chekin = false
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(!(params.product_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Product's Quantity "
								chekin = false
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
								
							}
							else if(params.by_Product_Name[i]=="") {
								flash.message = "Please Enter all By-Product Names"
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.by_Product_Qty[i]=="") {
								flash.message = "Please Enter all By-Product's Quantity "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(!(params.by_Product_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For By-Product's Quantity "
								chekin = false
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
								
							}
							else if(params.raw_Material_Name[i]=="") {
								flash.message = "Please Enter all Raw Material Names"
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.raw_Material_Qty[i]=="") {
								flash.message = "Please Enter all Raw-Material's Quantity "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(!(params.raw_Material_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Raw-Material's Quantity "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
								
							}
						}
					}
				}
				def testString=params.hw_Type
				if(testString.getClass().getName()!="java.lang.String"){
					
					for(int i =0 ; i<testString.size();i++){
						if(checkinOM){
							if(params.hw_Type[i]=="") {
								flash.message = "Please Enter all Hazardous Waste Type"
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.hw_Qty[i]=="") {
								flash.message = "Please Enter all Hazardous Waste's Quantity "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(!(params.hw_Qty[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Hazardous Waste's Quantity "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
								
							}
							else if(params.hw_Source[i]=="") {
								flash.message = "Please Enter all Hazardous Waste Source"
								chekin = false
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.mode_Of_Storage[i]=="") {
								flash.message = "Please Enter all Mode Of Storage"
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.method_Of_Disposal[i]=="") {
								flash.message = "Please Enter all Method Of Disposal"
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(params.capacity_Of_Disposal[i]=="") {
								flash.message = "Please Enter all Capacity of Disposal "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}
							else if(!(params.capacity_Of_Disposal[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Capacity of Disposal "
								chekin = false
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
								
							}else if(params.quantityDisposed[i]=="") {
								flash.message = "Please Enter all Quantity disposed"
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
							}else if(!(params.quantityDisposed[i].isLong())) {
								flash.message = "Please Enter Only Numeric Value For Quantity Disposed "
								chekin = false	
								checkinOM=false
								render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
								
							}
							
						}
					}
				}
				if(chekin) {
					hazardeousWasteAuthAppInstance.clarification=false
					hazardeousWasteAuthAppInstance.inspection=false
					hazardeousWasteAuthAppInstance.completionStatus=params.progress_Status
					String authReqFor=""
					
					if(params['chkCollection']=="on") {
						authReqFor=authReqFor.concat("Collection")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkReception']=="on") {
						authReqFor=authReqFor.concat("Reception")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkTreatment']=="on") {
						authReqFor=authReqFor.concat("Treatment")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkTransport']=="on") {
						authReqFor=authReqFor.concat("Transport")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkStorage']=="on") {
						authReqFor=authReqFor.concat("Storage")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkDisposal']=="on") {
						authReqFor=authReqFor.concat("Disposal")
						authReqFor=authReqFor.concat(",")
					}
					hazardeousWasteAuthAppInstance.authorization_Required_For=authReqFor
					hazardeousWasteAuthAppInstance.applicationStatus="Inprogress"
					hazardeousWasteAuthAppInstance.expectedReturn=(params.expectedReturn).toLong()
					hazardeousWasteAuthAppInstance.is_Renew=params.is_Renew
					if(hazardeousWasteAuthAppInstance.is_Renew=="Yes") {
						
						hazardeousWasteAuthAppInstance.auth_Renew_No=(params.auth_Renew_No).toLong();
						def dateCheck=params.auth_Renew_Date_value
						def x
						def sqlCurrentDate
						def currentDate=new Date()
						DateCustom dd=new DateCustom()
						sqlCurrentDate=dd.sQLdate(currentDate)
						if(dateCheck) {
							def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
							x= sdfh.parse(dateCheck);
							hazardeousWasteAuthAppInstance.auth_Renew_Date=x
						}
					}
					
					hazardeousWasteAuthAppInstance.hw_Defined=params.hw_Defined
					hazardeousWasteAuthAppInstance.industryRegMasterObj=indRegInstance
					
					hazardeousWasteAuthAppInstance.createdBy=indRegInstance.indName
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					def date = new Date();
					def t = dateFormat.format(date)
					println("=========================================="+hazardeousWasteAuthAppInstance);
					hazardeousWasteAuthAppInstance.updatedBy="";
					if(!hazardeousWasteAuthAppInstance.hasErrors() && hazardeousWasteAuthAppInstance.save()) {
						println("INSIDE B--------------");
						def indHWProductDetailsInstance = new IndHWProductDetails(params)
						if(params.product_Name.getClass().getName()=="java.lang.String"){
							
							indHWProductDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
							indHWProductDetailsInstance.createdBy=indRegInstance.indName
							indHWProductDetailsInstance.save()
						}
						else{
							for(int i=0;i<params.product_Name.size();i++) {
								
								("params prodsdfdfdfdfd")
								indHWProductDetailsInstance = new IndHWProductDetails(params)
								indHWProductDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
								indHWProductDetailsInstance.product_Name=params.product_Name[i]
								indHWProductDetailsInstance.product_Qty=params.product_Qty[i].toInteger()
								indHWProductDetailsInstance.by_Product_Name=params.by_Product_Name[i]
								indHWProductDetailsInstance.by_Product_Qty=params.by_Product_Qty[i].toInteger()
								indHWProductDetailsInstance.raw_Material_Name=params.raw_Material_Name[i]
								indHWProductDetailsInstance.raw_Material_Qty=params.raw_Material_Qty[i].toInteger()
								indHWProductDetailsInstance.createdBy=indRegInstance.indName
								indHWProductDetailsInstance.save()
							}
						}
						if(params.hw_Type.getClass().getName()=="java.lang.String") {
							def indHazardeousWasteDetailsInstance = new IndHazardeousWasteDetails(params)
							indHazardeousWasteDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
							indHazardeousWasteDetailsInstance.waste_Characteristics=params.characteristics
							indHazardeousWasteDetailsInstance.quantityDisposed=params.quantityDisposed.toInteger()
							indHazardeousWasteDetailsInstance.createdBy=indRegInstance.indName
							indHazardeousWasteDetailsInstance.save()
						}
						else {
							for(int i=0;i<params.hw_Type.size();i++) {
								def indHazardeousWasteDetailsInstance = new IndHazardeousWasteDetails(params)
								indHazardeousWasteDetailsInstance.hazardeousWasteAuthAppObj = hazardeousWasteAuthAppInstance
								indHazardeousWasteDetailsInstance.hw_Type=params.hw_Type[i]
								indHazardeousWasteDetailsInstance.waste_Characteristics=params.characteristics[i]
								indHazardeousWasteDetailsInstance.quantityDisposed=params.quantityDisposed[i].toInteger()
								indHazardeousWasteDetailsInstance.hw_Qty=params.hw_Qty[i].toInteger()
								indHazardeousWasteDetailsInstance.hw_Source=params.hw_Source[i]
								indHazardeousWasteDetailsInstance.mode_Of_Storage=params.mode_Of_Storage[i]
								indHazardeousWasteDetailsInstance.method_Of_Disposal=params.method_Of_Disposal[i]
								indHazardeousWasteDetailsInstance.capacity_Of_Disposal=params.capacity_Of_Disposal[i].toInteger()
								indHazardeousWasteDetailsInstance.createdBy=indRegInstance.indName
								indHazardeousWasteDetailsInstance.save()
							}
						}
						
						println("INSIDE C--------------");
						def flowDiagramManufactureProcess
						def locationSite
						def detailsOfProcessing
						def siteClearance
						def utilizationProgramme
						def methodOfDisposal
						def compositionWaste
						def detailsOfLandfilling
						def environmentalPollution
						def safetyWorkers
						WasteManagementFile file=new WasteManagementFile()
						def f = request.getFile('flowDiagramManufacturingProcess')
						MultipartFile multi = request.getFile('flowDiagramManufacturingProcess')
						if(f.empty) {
							flowDiagramManufactureProcess = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Flow Diagram Of Manufacturing Process"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="flowDiagramManufacturingProcess"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								flowDiagramManufactureProcess = "Attached"
								
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('locationOfSite')
						multi = request.getFile('locationOfSite')
						if(f.empty) {
							locationSite = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Location Of Site(Map)"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="locationOfSite"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								locationSite = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('processingTechDetails')
						multi = request.getFile('processingTechDetails')
						if(f.empty) {
							detailsOfProcessing = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Details of Processing Technology"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="processingTechDetails"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								detailsOfProcessing = "Attached"
								
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('siteClearance')
						multi = request.getFile('siteClearance')
						if(f.empty) {
							siteClearance = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Site Clearance(From local authority, if any)"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="siteClearance"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								siteClearance = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('utilizationProgramme')
						multi = request.getFile('utilizationProgramme')
						if(f.empty) {
							utilizationProgramme = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Utilization Programme For Waste Processed"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="utilizationProgramme"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								utilizationProgramme = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('disposalMethod')
						multi = request.getFile('disposalMethod')
						if(f.empty) {
							methodOfDisposal = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Method Of Disposal"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="disposalMethod"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								methodOfDisposal = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('wasteNatureAndComposition')
						multi = request.getFile('wasteNatureAndComposition')
						if(f.empty) {
							compositionWaste = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Nature And Composition Of Waste"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="wasteNatureAndComposition"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								compositionWaste = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('landfillingIncinerationMethodology')
						multi = request.getFile('landfillingIncinerationMethodology')
						if(f.empty) {
							detailsOfLandfilling = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Methodology For Landfilling/Incineration"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="landfillingIncinerationMethodology"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								detailsOfLandfilling = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('preventionAndControlMeasures')
						multi = request.getFile('preventionAndControlMeasures')
						if(f.empty) {
							environmentalPollution = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Prevention And Control Measures"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="preventionAndControlMeasures"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								environmentalPollution = "Attached"
							}
						}
						
						file=new WasteManagementFile()
						f = request.getFile('safetyMeasures')
						multi = request.getFile('safetyMeasures')
						if(f.empty) {
							safetyWorkers = "Not Attached"
						}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Safety Measures"
							file.createdBy=indRegInstance.indName
							file.typeOfFile="safetyMeasures"
							file.indreg=indRegInstance
							file.applicationId=hazardeousWasteAuthAppInstance.id
							file.applicationFor="HWM"
							if(file.save()) {
								safetyWorkers = "Attached"
							}
						}
						WasteManagementFile file1=new WasteManagementFile()
						File certFile
						HazardeousWasteFormPdf pdfG=new HazardeousWasteFormPdf()
						
						def txtIndName=params.txtIndName
						def txtIndCity=params.txtIndCity
						def txtIndTehsil=params.txtIndTehsil
						def txtIndDistrict=params.txtIndDistrict
						def txtIndAddress=params.txtIndAddress
						def txtIndPin=params.txtIndPin
						def hw_Defined=params.hw_Defined
						def totalCapitalInves=params.totalCapitalInves
						def yearofcommision=params.yearofcommision
						def auth_Renew_Date=params.auth_Renew_Date_value
						def industryShift=params.industryShift
						def auth_Renew_No=params.auth_Renew_No
						def location_Of_Activity=params.location_Of_Activity
						def expectedReturn=params.expectedReturn
						def productList= new ArrayList()
						
						
						println("INSIDE D--------------");
						
						def productDetailsList= new ArrayList()
						if(params.product_Name.getClass().getName()=="java.lang.String"){
							productList.add(params.product_Name)
							productList.add(params.product_Qty)
							productList.add(params.by_Product_Name)
							productList.add(params.by_Product_Qty)
							
							productDetailsList.add(productList)		
						
						}
						else
						{
						for(int i=0;i<params.product_Name.size();i++) 
						{
							productList.add(params.product_Name[i])
							productList.add(params.product_Qty[i])
							productList.add(params.by_Product_Name[i])
							productList.add(params.by_Product_Qty[i])
						}
						productDetailsList.add(productList)
						}
						def rawMaterialList= new ArrayList()
						def rawMaterialDetailsList= new ArrayList()
						if(params.product_Name.getClass().getName()=="java.lang.String"){
							rawMaterialList.add(params.raw_Material_Name)
							rawMaterialList.add(params.raw_Material_Qty)
							rawMaterialDetailsList.add(rawMaterialList)		
						}
						else
						{
						for(int i=0;i<params.product_Name.size();i++) 
						{
							rawMaterialList.add(params.raw_Material_Name[i])
							rawMaterialList.add(params.raw_Material_Qty[i])
							
						}
						rawMaterialDetailsList.add(rawMaterialList)
						}
						def hazarWasteList= new ArrayList()
						
						def hazarWasteDetailsList= new ArrayList()
						if(params.hw_Type.getClass().getName()=="java.lang.String"){
							hazarWasteList.add(params.hw_Type)
							hazarWasteList.add(params.hw_Qty)
							
							hazarWasteDetailsList.add(hazarWasteList)		
						
						}
						else
						{
						for(int i=0;i<params.hw_Type.size();i++) 
						{
							hazarWasteList.add(params.hw_Type[i])
							hazarWasteList.add(params.hw_Qty[i])
							
						}
						hazarWasteDetailsList.add(hazarWasteList)
						}
						def hazarWasteList1= new ArrayList()
						def hazarWasteDetailsList1= new ArrayList()
						if(params.hw_Type.getClass().getName()=="java.lang.String"){
							hazarWasteList1.add(params.hw_Type)
							hazarWasteList1.add(params.hw_Qty)
							hazarWasteList1.add(params.hw_Source)
							hazarWasteList1.add(params.mode_Of_Storage)
							hazarWasteList1.add(params.method_Of_Disposal)
							hazarWasteList1.add(params.capacity_Of_Disposal)
									
							hazarWasteDetailsList1.add(hazarWasteList1)		
						
						}
						else
						{
						for(int i=0;i<params.hw_Type.size();i++) 
						{
							hazarWasteList1.add(params.hw_Type[i])
							hazarWasteList1.add(params.hw_Qty[i])
							hazarWasteList1.add(params.hw_Source[i])
							hazarWasteList1.add(params.mode_Of_Storage[i])
							hazarWasteList1.add(params.method_Of_Disposal[i])
							hazarWasteList1.add(params.capacity_Of_Disposal[i])
						}
						hazarWasteDetailsList1.add(hazarWasteList1)
						}
						def appFor="HWM"
						def industryRegInstanceWaste=indRegInstance
						println("INSIDE E--------------"+hazardeousWasteAuthAppInstance.completionStatus);
						if(hazardeousWasteAuthAppInstance.completionStatus=="Completed"){
							certFile = pdfG.hazaFunction(txtIndName,txtIndCity,txtIndTehsil,txtIndDistrict,txtIndAddress,txtIndPin,location_Of_Activity,authReqFor,auth_Renew_No,auth_Renew_Date,hw_Defined,totalCapitalInves,yearofcommision,expectedReturn,flowDiagramManufactureProcess,locationSite,detailsOfProcessing,siteClearance,utilizationProgramme,methodOfDisposal,compositionWaste,detailsOfLandfilling,environmentalPollution,safetyWorkers,industryShift,productDetailsList,rawMaterialDetailsList,hazarWasteDetailsList,hazarWasteDetailsList1)  
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							def fileLength=certFile.length()
							file1.size = fileLength / 1024  //f.getSize()
							file1.extension ="pdf"//extractExtension( f )
							file1.data=b;
							file1.name="HazardeousWasteForm.pdf"
							file1.description="Hazardeous Saved"
							if(indRegInstance.indName){
								file1.createdBy=session.indUser
								file1.updatedBy=session.indUser
							}
							file1.typeOfFile="HazardeousProfile"
							file1.indreg=indRegInstance.get(indRegInstance.id.toLong())
							file1.applicationFor="HazardeousWaste"
							file1.dateCreated=dateFormat.parse(t)
							file1.applicationId=hazardeousWasteAuthAppInstance.id
							if(file1.save()) { 
							}
							else {
								
							}
							println("INSIDE F-------------"+hazardeousWasteAuthAppInstance.completionStatus);
							RouteWasteManagement routeWaste=new RouteWasteManagement()
							def routed=routeWaste.routeWasteManagementApp(hazardeousWasteAuthAppInstance.id,appFor,industryRegInstanceWaste)
							println("INSIDE G-------------"+routed);
							flash.message ="Congratulations! Your Application No. ${hazardeousWasteAuthAppInstance.id} is submitted successfully." 
						}
						else{
							flash.message="Your Application No. ${hazardeousWasteAuthAppInstance.id} is saved and available for future update..."
						}
						redirect(action:show,id:hazardeousWasteAuthAppInstance.id)
					}
					else {
						
						if(hazardeousWasteAuthAppInstance.hasErrors()){
			        		 hazardeousWasteAuthAppInstance.errors.allErrors.each {
			        			 println it
			        		 }
			        	 } 
			        	 
						
						
						
						
						
						render(view:'create',model:[hazardeousWasteAuthAppInstance:hazardeousWasteAuthAppInstance])
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
	
	def viewFile1 = {
			 try {
					def industryId = session.indUser
					def userId = session.userMaster
					def wasteManagementFileInstance = WasteManagementFile.get( params.id )
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${wasteManagementFileInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( wasteManagementFileInstance.data )
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
	
	def listForCert = {
			 try {
					def industryId = session.indUser
					if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
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
					[ hazardeousWasteAuthAppInstanceInprogressList: hazardeousWasteAuthAppInstanceInprogressList,hazardeousWasteAuthAppInstanceCompletedList: hazardeousWasteAuthAppInstanceCompletedList,municipalSolidWasteInprogressList: municipalSolidWasteInprogressList,municipalSolidWasteCompletedList: municipalSolidWasteCompletedList,bioMedicalWasteInprogressList: bioMedicalWasteInprogressList,bioMedicalWasteCompletedList: bioMedicalWasteCompletedList ,hazardeousWasteAuthAppInstanceTotal: hazardeousWasteAuthAppInstanceInprogressList.size() ]
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
	
	def insrtCertificateDetailsForRenewal = {
			 try {
					def userId = session.userMaster
					if(userId==null || userId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
					
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def wasteManagementFileList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id)
					
					String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
					ArrayList tmp1=new ArrayList()
					tmp1=tmp.split(",")
					
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
						redirect(action:list)
					}
					else {
						render(view:'insrtCertDetails',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1] )
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
	
	def insrtCertificateDetailsForNew = {
			 try {
					def userId = session.userMaster
					if(userId==null || userId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
					
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def wasteManagementFileList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id)
					
					String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
					ArrayList tmp1=new ArrayList()
					tmp1=tmp.split(",")
					
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
						redirect(action:list)
					}
					else {
						render(view:'insrtCertDetailsForNew',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1] )
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
	
	def createRenewalCertificate = {
			 try {
					def remarksSized=params.remarks
					def userId = session.userMaster
					if(userId==null || userId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.hazardeousWasteAuthAppInstanceid )
					def checkForView=false
					def app = WasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString())
					def id=app.id
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def wasteManagementFileList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id)
					
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					def dateToday = new Date();
					
					String number = params.authNumber
					String date = dateFormat.format(dateToday)
					String indName = indRegInstanceGet.indName
					String indAddress = indRegInstanceGet.indAddress
					String indDistrict = district
					String indTehsil = tehsil
					String appId = hazardeousWasteAuthAppInstance.id
					
					def t = dateFormat.format(hazardeousWasteAuthAppInstance.dateCreated)
					String appDate = t
					String renewPeriod = params.period_of_Auth
					def renewFrom = ""
					def renewTo = ""
					String authLetterNo = params.authNumber
					String authLetterDate = dateFormat.format(dateToday)
					String endtNo = params.authNumber
					String endtDate = dateFormat.format(dateToday)
					String indLocation = hazardeousWasteAuthAppInstance.location_Of_Activity
					
					ArrayList authFor = new ArrayList()
					if(params['chkCollection']=="on") {
						authFor.add("Collection")
					}
					if(params['chkReception']=="on") {
						authFor.add("Reception")
					}
					if(params['chkTreatment']=="on") {
						authFor.add("Treatment")
					}
					if(params['chkTransport']=="on") {
						authFor.add("Transport")
					}
					if(params['chkStorage']=="on") {
						authFor.add("Storage")
					}
					if(params['chkDisposal']=="on") {
						authFor.add("Disposal")
					}
					ArrayList hazardousWaste = new ArrayList()
					ArrayList hazardousSource = new ArrayList()
					ArrayList hazardousQuantity = new ArrayList()
					ArrayList hazardousRemarks = new ArrayList()
					for(IndHazardeousWasteDetails indHW:hazardeousWasteDetailsList) {
						hazardousWaste.add(indHW.hw_Type)
						hazardousSource.add(indHW.hw_Source)
						hazardousQuantity.add(indHW.hw_Qty)
					}
					if(params.remarks.getClass().getName()=="java.lang.String") {
						hazardousRemarks.add(params.remarks)
					}
					else{
						for(int k = 0;k < remarksSized.size();k++ ) {
							hazardousRemarks.add(params.remarks[k])
						}
					}
					String termsAndConditions = params.termsConditions
					String copyTo = params.copyTo
					String process = params.process
					
					WasteManagementCertificates file = new WasteManagementCertificates()
					HazardeousWasteCertificates hwCert = new HazardeousWasteCertificates()
					File certificate = hwCert.generateRenewalCertificate( number,  date, indName,  indAddress, indDistrict,  indTehsil, appId, appDate, renewPeriod, renewFrom, renewTo, authLetterNo, authLetterDate, endtNo,  endtDate, indLocation, authFor, hazardousWaste, hazardousSource, hazardousQuantity,hazardousRemarks,termsAndConditions ,copyTo, process)
					
					byte[] b = new byte[(int) certificate.length()];
					
					FileInputStream fileInputStream = new FileInputStream(certificate);
					fileInputStream.read(b);
					def fileLength=certificate.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					String fileName = appId.concat("Renewal").concat(".pdf")
					file.name=fileName
					file.description="HWRenewal"
					file.createdBy=indRegInstance.indName
					file.updatedBy=indRegInstance.indName
					file.typeOfFile="HWRenewal"
					file.indreg=indRegInstance
					file.applicationId = hazardeousWasteAuthAppInstance.id
					file.applicationFor = "HWM"
					def fileid = null
					if(file.save()) {
						fileid=file.id
						flash.userMessage = "Hazardous Waste - New Certificate is generated properly."
						checkForView=true
						redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
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
	
	def createNewCertificate = {
			 try {
					def userId = session.userMaster
					if(userId==null || userId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.hazardeousWasteAuthAppInstanceid )
					def checkForView=false
					def app = WasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString())
					def id=app.id
					
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					
					def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					
					def wasteManagementFileList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id)
					
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					def dateToday = new Date();
					
					
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, 5);

					String formattedDate = dateFormat.format(cal.getTime());
					
					String occName = indRegInstanceGet.occName
					String number = params.authNumber
					String date = dateFormat.format(dateToday)
					String indName = indRegInstanceGet.indName
					String indAddress = indRegInstanceGet.indAddress
					String indDistrict = district
					String indTehsil = tehsil
					String appId = hazardeousWasteAuthAppInstance.id
					String name= params.name
					String address=params.address
					
					def officerName = params.officerName
					def officerDes = params.officerDes	
					
					def office = params.office
					
					def t = dateFormat.format(hazardeousWasteAuthAppInstance.dateCreated)
					String appDate = t
					
					String renewPeriod = params.period_of_Auth
					String authLetterNo = params.authNumber
					String authLetterDate = dateFormat.format(dateToday)
					String endtNo = params.authNumber
					String endtDate = dateFormat.format(dateToday)
					String indLocation = hazardeousWasteAuthAppInstance.location_Of_Activity
					
					ArrayList authFor = new ArrayList()
					if(params['chkCollection']=="on") {
						authFor.add("Collection")
					}
					if(params['chkReception']=="on") {
						authFor.add("Reception")
					}
					if(params['chkTreatment']=="on") {
						authFor.add("Treatment")
					}
					if(params['chkTransport']=="on") {
						authFor.add("Transport")
					}
					if(params['chkStorage']=="on") {
						authFor.add("Storage")
					}
					if(params['chkDisposal']=="on") {
						authFor.add("Disposal")
					}
					
					
					ArrayList hazardousWaste = new ArrayList()
					ArrayList hazardousSource = new ArrayList()
					ArrayList hazardousQuantity = new ArrayList()
					for(IndHazardeousWasteDetails indHW:hazardeousWasteDetailsList) {
						hazardousWaste.add(indHW.hw_Type)
						hazardousSource.add(indHW.hw_Source)
						hazardousQuantity.add(indHW.hw_Qty)
					}
					String termsAndConditions = params.termsConditions
					String copyTo = params.copyTo
					
					DateCustom dd2=new DateCustom()
					def currentDate11= (dd2.sQLdate1(new Date()))
					def cryr=(currentDate11.getYear()).toInteger()+1900
					/////////////?????????? recordCertificateHWM
					def recordCertificateInstance=new RecordCertificateHWM()
					
					
					 def recordCertificate = RecordCertificateHWM.findByApplication(hazardeousWasteAuthAppInstance)
						
					
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					if(params.auth_Renew_Date_From_value){
			    	def x = sdfh.parse(params.auth_Renew_Date_From_value);
			    	recordCertificateInstance.issueDate=x
			    	}
					else{
						recordCertificateInstance.issueDate=new Date()
					}
					def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
					
					
					if(params.auth_Renew_Date_To_value){		
					def xy = sdfh.parse(params.auth_Renew_Date_To_value);
					recordCertificateInstance.expiryDate=xy
					}else{
						recordCertificateInstance.expiryDate=new Date()
					}
					
					recordCertificateInstance.dateCreated = new Date()
							
					recordCertificateInstance.year=cryr.toString()
					
								recordCertificateInstance.authorizationNo=params.authNumber
								recordCertificateInstance.copyTo=params.copyTo
								recordCertificateInstance.name=params.name
								
								recordCertificateInstance.application=hazardeousWasteAuthAppInstance
								
								recordCertificateInstance.office=params.office
								recordCertificateInstance.officerName = params.officerName
								recordCertificateInstance.officerDes = params.officerDes
								recordCertificateInstance.termsConditions = params.termsConditions
								
								recordCertificateInstance.typeOfOfficer=params.typeOfOfficer
								recordCertificateInstance.RegionalOffice=params.RegionalOffice
								
								recordCertificateInstance.address=params.address
							
								/////////validity
								recordCertificateInstance.valid=renewPeriod
					
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
								
								/////////////////////////////?????????????
					def authList11= new ArrayList()
					
					def authInstance11=AuthorisationDetailsHWM.findAllByApplication(hazardeousWasteAuthAppInstance)
				int iNo = 1;
					for(int var7=0;var7<authInstance11.size();var7++)
					{
					def authInstanceList11= new ArrayList()
					authInstanceList11.add(iNo.toString())
					authInstanceList11.add(authInstance11.get(var7).category)
					authInstanceList11.add(authInstance11.get(var7).mode)
					authInstanceList11.add(authInstance11.get(var7).quantity)
					
					authList11.add(authInstanceList11)
					iNo++;
					}
					
					
					WasteManagementCertificates file = new WasteManagementCertificates()
					HazardeousWasteCertificates hwCert = new HazardeousWasteCertificates()
					
					File certificate = hwCert.generateNewCertificate( number,  date,indAddress, indDistrict,  indTehsil, appId, appDate, renewPeriod,authLetterNo, authLetterDate, endtNo,  endtDate, indLocation, authFor, hazardousWaste, hazardousSource, hazardousQuantity,termsAndConditions , copyTo, name, address ,formattedDate,officerName,officerDes,office,authList11,indName,occName)
					
					byte[] b = new byte[(int) certificate.length()];
					
					FileInputStream fileInputStream = new FileInputStream(certificate);
					fileInputStream.read(b);
					
					def fileLength=certificate.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					String fileName = appId.concat("New").concat(".pdf")
					file.name=fileName
					file.description="HWNew"
					file.createdBy=indRegInstance.indName
					file.updatedBy=indRegInstance.indName
					file.typeOfFile="HWNew"
					
					
					file.indreg=indRegInstance
					file.applicationId = hazardeousWasteAuthAppInstance.id
					file.applicationFor = "HWM"
					
						def appliCert = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.typeOfFile='HWNew' order by afr.id asc",[hazardeousWasteAuthAppInstance.id])
					  	
				    	
				
					
					def fileid=null
					if(file.save(flush:true)) {
						
						if(appliCert){
				    		appliCert.delete();
				    	}
						fileid=file.id
						flash.userMessage = "Hazardous Waste - Certificate is generated properly."
						checkForView=true
						def userType;
				        def userIdA;
				        if(session.indUser)
				        {
				        	userType="Industry";
				        	userIdA = ((session.indUser).toString()).trim();
				        	
				        }
				        else if (session.userMaster)
				        {
				        	userType="SPCB";
				        	userIdA = ((session.userMaster).toString()).trim();
				        	
				        }
				        def activityRecInstance=new ActivityRecord();
				        activityRecInstance.userType=userType;
				        activityRecInstance.userID=userIdA;
				        activityRecInstance.ipAddress=request.getRemoteAddr() 
					    activityRecInstance.activity = "add"
					    activityRecInstance.status = "Hazardous Waste Application "+hazardeousWasteAuthAppInstance.id+ " Certificate Generated."
				        if(activityRecInstance.save()){		   
				          }
				        	else{
				        		activityRecInstance.errors.each {
						    	println it
						  }
					  }
						redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
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
	
	
	def searchApp={

			 try {
				    
				 	def userType="SPCB";
					def userId = session.userMaster
					if(userId==null || userId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					
					//def appIdListHazard=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp cr where cr.completionStatus='Completed' order by cr.id desc")
					def appIdListHazard= HazardeousWasteAuthApp.findAll("From HazardeousWasteAuthApp as bmw WHERE bmw.completionStatus='Completed'" )
					
					def appIdListBio=BioMedicalWaste.findAll(" from BioMedicalWaste cr where cr.completionStatus='Completed' order by cr.id desc")
					def appIdListMunicipal=MunicipalSolidWaste.findAll(" from MunicipalSolidWaste cr where cr.completionStatus='Completed' order by cr.id desc")
					List appIdList =new ArrayList()
							
					if(appIdListHazard.size()>0) {
						
						for(HazardeousWasteAuthApp hw:appIdListHazard)
						appIdList+=hw
					}
					
					if(appIdListBio.size()>0) {
						
						for(BioMedicalWaste bmw:appIdListBio)
						appIdList+=bmw
					}
					
					if(appIdListMunicipal.size()>0) {
						
						for(MunicipalSolidWaste mw:appIdListMunicipal)
						appIdList+=mw
					}
					
					
					return ['appIdList':appIdList]
				
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
	
	def viewSearchResult={
			 try {
				    
					
					def userId = session.userMaster
					
					def accessLevelAdEm=userId.accessLevel
					if(userId==null || userId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def appIdListHazard=HazardeousWasteAuthApp.findAll(" from HazardeousWasteAuthApp cr where cr.completionStatus='Completed' order by cr.id desc")

					
					def appIdListBio=BioMedicalWaste.findAll(" from BioMedicalWaste cr where cr.completionStatus='Completed' order by cr.id desc")
					
					def appIdListMunicipal=MunicipalSolidWaste.findAll(" from MunicipalSolidWaste cr where cr.completionStatus='Completed' order by cr.id desc")
					
					def appIdListPlastic=PlasticWaste.findAll(" from PlasticWaste cr where cr.completionStatus='Completed' order by cr.id desc")
					
					
					
					List appIdList =new ArrayList()
					
					if(appIdListHazard.size()>0) {
						for(HazardeousWasteAuthApp hw:appIdListHazard)
						appIdList+=hw
					}
					
					if(appIdListBio.size()>0) {
						for(BioMedicalWaste bmw:appIdListBio)
						appIdList+=bmw
					}
					
					if(appIdListMunicipal.size()>0) {
						for(MunicipalSolidWaste mw:appIdListMunicipal)
						appIdList+=mw
					}
					
					if(appIdListPlastic.size()>0) {
						for(PlasticWaste pwm:appIdListPlastic)
						appIdList+=pwm
					}
					
					
					def hwStatusList= new ArrayList()
					def hwPendingWith= new ArrayList()
					def hwPendingWithRole= new ArrayList()
					
					def bmwStatusList= new ArrayList()
					def bmwPendingWith= new ArrayList()
					def bmwPendingWithRole= new ArrayList()
					
					def mswStatusList= new ArrayList()
					def mswPendingWith= new ArrayList()
					def mswPendingWithRole= new ArrayList()
					
					def pwmStatusList= new ArrayList()
					def pwmPendingWith= new ArrayList()
					def pwmPendingWithRole= new ArrayList()
					
					def hwInst
					def bmwInst
					def mwInst
					def pwmInst
					
					if(params.searchOp=="ApplId"){
						if(params.idList==null || params.idList=="xyz") {
							flash.message="Please Select the Application Id"
							redirect(action:searchApp)
						}else {
							def appId= (params.idList).toLong()
							
							if(params.appTypeName == "xyz") {
								hwInst=HazardeousWasteAuthApp.findAllWhere(id : appId)
								println("---hwInst-----"+hwInst.size())
								if(hwInst.size()>0) {
									for(HazardeousWasteAuthApp hw:hwInst) {
										def checkInst=WasteManagementPendingDetails.findByapplicationId((hw.id).toString())
										
										if(checkInst) {
											hwStatusList.add(checkInst.applicationStatus)
											hwPendingWith.add(checkInst.pendingWith)
											hwPendingWithRole.add(checkInst.role)
										}
										else {
											
											hwStatusList.add("Unattended")
											hwPendingWith.add("Unknown")
											hwPendingWithRole.add("Unknown")
										}
									}
									
								}
								
								bmwInst=BioMedicalWaste.findAllWhere(id : appId)
								println("---bmwInst-----"+bmwInst.size())
								if(bmwInst.size()>0) {
									for(BioMedicalWaste bmw:bmwInst) {
										def checkInst=WasteManagementPendingDetails.findByapplicationId((bmw.id).toString())
										if(checkInst) {
											bmwStatusList.add(checkInst.applicationStatus)
											bmwPendingWith.add(checkInst.pendingWith)
											bmwPendingWithRole.add(checkInst.role)
										}
										else {
											
											bmwStatusList.add("Unattended")
											bmwPendingWith.add("Unknown")
											bmwPendingWithRole.add("Unknown")
										}
									}
									
								}
								
								mwInst=MunicipalSolidWaste.findAllWhere(id : appId)
								
								if(mwInst.size()>0) {
									for(MunicipalSolidWaste msw:mwInst) {
										def checkInst=WasteManagementPendingDetails.findByapplicationId((msw.id).toString())
										if(checkInst) {
											mswStatusList.add(checkInst.applicationStatus)
											mswPendingWith.add(checkInst.pendingWith)
											mswPendingWithRole.add(checkInst.role)
										}
										else {
											
											mswStatusList.add("Unattended")
											mswPendingWith.add("Unknown")
											mswPendingWithRole.add("Unknown")
										}
									}
									
								}
								
								pwmInst=PlasticWaste.findAllWhere(id : appId)
								
								if(pwmInst.size()>0) {
									for(PlasticWaste pwm:pwmInst) {
										def checkInst=WasteManagementPendingDetails.findByapplicationId((pwm.id).toString())
										if(checkInst) {
											pwmStatusList.add(checkInst.applicationStatus)
											pwmPendingWith.add(checkInst.pendingWith)
											pwmPendingWithRole.add(checkInst.role)
										}
										else {
											
											pwmStatusList.add("Unattended")
											pwmPendingWith.add("Unknown")
											pwmPendingWithRole.add("Unknown")
										}
									}
									
								}
								
								render(view:'searchApp',model:[accessLevelAdEm:accessLevelAdEm,hwInst:hwInst,bmwInst:bmwInst,mwInst:mwInst,pwmInst:pwmInst,appIdList:appIdList,hwStatusList:hwStatusList,hwPendingWith:hwPendingWith,hwPendingWithRole:hwPendingWithRole,bmwStatusList:bmwStatusList,bmwPendingWith:bmwPendingWith,bmwPendingWithRole:bmwPendingWithRole,mswStatusList:mswStatusList,mswPendingWith:mswPendingWith,mswPendingWithRole:mswPendingWithRole,pwmStatusList:pwmStatusList,pwmPendingWith:pwmPendingWith,pwmPendingWithRole:pwmPendingWithRole])
								
							}
							
							else {
								
								if(params.appTypeName=="Hazardous Waste") {
									hwInst=HazardeousWasteAuthApp.findAllWhere(id : appId)
									if(hwInst.size()>0) {
										for(HazardeousWasteAuthApp hw:hwInst) {
											def checkInst=WasteManagementPendingDetails.findByapplicationId((hw.id).toString())
											if(checkInst) {
												hwStatusList.add(checkInst.applicationStatus)
												hwPendingWith.add(checkInst.pendingWith)
												hwPendingWithRole.add(checkInst.role)
											}
											else {
												hwStatusList.add("Unattended")
												hwPendingWith.add("Unknown")
												hwPendingWithRole.add("Unknown")
											}
										}
										
									}
								}
								else if(params.appTypeName=="Bio-Medical Waste") {
									bmwInst=BioMedicalWaste.findAllWhere(id : appId)
									if(bmwInst.size()>0) {
										for(BioMedicalWaste bmw:bmwInst) {
											def checkInst=WasteManagementPendingDetails.findByapplicationId((bmw.id).toString())
											if(checkInst) {
												bmwStatusList.add(checkInst.applicationStatus)
												bmwPendingWith.add(checkInst.pendingWith)
												bmwPendingWithRole.add(checkInst.role)
											}
											else {
												bmwStatusList.add("Unattended")
												bmwPendingWith.add("Unknown")
												bmwPendingWithRole.add("Unknown")
											}
										}
										
									}
								}
								else if(params.appTypeName=="Municipal Solid Waste") {
									mwInst=MunicipalSolidWaste.findAllWhere(id : appId)
									if(mwInst.size()>0) {
										for(BioMedicalWaste msw:mwInst) {
											def checkInst=WasteManagementPendingDetails.findByapplicationId((msw.id).toString())
											if(checkInst) {
												mswStatusList.add(checkInst.applicationStatus)
												mswPendingWith.add(checkInst.pendingWith)
												mswPendingWithRole.add(checkInst.role)
											}
											else {
												mswStatusList.add("Unattended")
												mswPendingWith.add("Unknown")
												mswPendingWithRole.add("Unknown")
											}
										}
										
									}
								}
								else if(params.appTypeName=="Plastic Waste") {
									pwmInst=PlasticWaste.findAllWhere(id : appId)
									if(pwmInst.size()>0) {
										for(PlasticWaste pwm:pwmInst) {
											def checkInst=WasteManagementPendingDetails.findByapplicationId((pwm.id).toString())
											if(checkInst) {
												pwmStatusList.add(checkInst.applicationStatus)
												pwmPendingWith.add(checkInst.pendingWith)
												pwmPendingWithRole.add(checkInst.role)
											}
											else {
												pwmStatusList.add("Unattended")
												pwmPendingWith.add("Unknown")
												pwmPendingWithRole.add("Unknown")
											}
										}
										
									}
								}
								render(view:'searchApp',model:[accessLevelAdEm:accessLevelAdEm,hwInst:hwInst,bmwInst:bmwInst,mwInst:mwInst,pwmInst:pwmInst,appIdList:appIdList,hwStatusList:hwStatusList,hwPendingWith:hwPendingWith,hwPendingWithRole:hwPendingWithRole,bmwStatusList:bmwStatusList,bmwPendingWith:bmwPendingWith,bmwPendingWithRole:bmwPendingWithRole,mswStatusList:mswStatusList,mswPendingWith:mswPendingWith,mswPendingWithRole:mswPendingWithRole,pwmStatusList:pwmStatusList,pwmPendingWith:pwmPendingWith,pwmPendingWithRole:pwmPendingWithRole])
								
							}
							
							
							
						}
					}
					else if(params.searchOp=="ApplName") {
						if(params.autocomplete_parameter1==null || params.autocomplete_parameter1=="") {
							flash.message="Please Select the Industry Name"
							redirect(action:searchApp)
						}else {
							def firstInput = (params.autocomplete_parameter1).toLowerCase()
							
							def input1= firstInput + '%' 
							
							if(params.autocomplete_parameter1==null || params.autocomplete_parameter1=="") {
								flash.message="Please Write The Name Of Industry To Search"
								redirect(action:searchApp)
							}
							else {	
								def appIndName= (params.autocomplete_parameter1).trim();
								
								def indRegInstanceGet=IndustryRegMaster.findAll("from IndustryRegMaster as wmc where wmc.indName=? ",[appIndName])
								if(indRegInstanceGet.size()<=0 ){	
									flash.message="No industry of that name found"
									redirect(action:searchApp)
								}
								else {
									def indId = (indRegInstanceGet[0].id).toLong()
									
									if(params.appTypeName == "xyz") {
										hwInst=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as wmc where wmc.industryRegMasterObj.id=? order by wmc.id desc ",[indId])
										if(hwInst.size()>0) {
											for(HazardeousWasteAuthApp hw:hwInst) {
												def checkInst=WasteManagementPendingDetails.findByapplicationId((hw.id).toString())
												if(checkInst) {
													hwStatusList.add(checkInst.applicationStatus)
													hwPendingWith.add(checkInst.pendingWith)
													hwPendingWithRole.add(checkInst.role)
												}
												else {
													hwStatusList.add("Unattended")
													hwPendingWith.add("Unknown")
													hwPendingWithRole.add("Unknown")
												}
											}
											
										}
										
										bmwInst=BioMedicalWaste.findAll("from BioMedicalWaste as wmc where wmc.industryRegMasterObj.id=? order by wmc.id desc",[indId])
										if(bmwInst.size()>0) {
											for(BioMedicalWaste bmw:bmwInst) {
												def checkInst=WasteManagementPendingDetails.findByapplicationId((bmw.id).toString())
												if(checkInst) {
													bmwStatusList.add(checkInst.applicationStatus)
													bmwPendingWith.add(checkInst.pendingWith)
													bmwPendingWithRole.add(checkInst.role)
												}
												else {
													bmwStatusList.add("Unattended")
													bmwPendingWith.add("Unknown")
													bmwPendingWithRole.add("Unknown")
												}
											}
											
										}
										
										mwInst=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as wmc where wmc.indRegMasterObj.id=? order by wmc.id desc",[indId])
										if(mwInst.size()>0) {
											for(BioMedicalWaste msw:mwInst) {
												def checkInst=WasteManagementPendingDetails.findByapplicationId((msw.id).toString())
												if(checkInst) {
													mswStatusList.add(checkInst.applicationStatus)
													mswPendingWith.add(checkInst.pendingWith)
													mswPendingWithRole.add(checkInst.role)
												}
												else {
													mswStatusList.add("Unattended")
													mswPendingWith.add("Unknown")
													mswPendingWithRole.add("Unknown")
												}
											}
											
										}
										
										pwmInst=PlasticWaste.findAll("from PlasticWaste as wmc where wmc.industryRegMasterObj.id=? order by wmc.id desc",[indId])
										if(pwmInst.size()>0) {
											for(PlasticWaste pwm:pwmInst) {
												def checkInst=WasteManagementPendingDetails.findByapplicationId((pwm.id).toString())
												if(checkInst) {
													pwmStatusList.add(checkInst.applicationStatus)
													pwmPendingWith.add(checkInst.pendingWith)
													pwmPendingWithRole.add(checkInst.role)
												}
												else {
													pwmStatusList.add("Unattended")
													pwmPendingWith.add("Unknown")
													pwmPendingWithRole.add("Unknown")
												}
											}
											
										}
										
										render(view:'searchApp',model:[accessLevelAdEm:accessLevelAdEm,hwInst:hwInst,bmwInst:bmwInst,mwInst:mwInst,pwmInst:pwmInst,appIdList:appIdList,hwStatusList:hwStatusList,hwPendingWith:hwPendingWith,hwPendingWithRole:hwPendingWithRole,bmwStatusList:bmwStatusList,bmwPendingWith:bmwPendingWith,bmwPendingWithRole:bmwPendingWithRole,mswStatusList:mswStatusList,mswPendingWith:mswPendingWith,mswPendingWithRole:mswPendingWithRole,pwmStatusList:pwmStatusList,pwmPendingWith:pwmPendingWith,pwmPendingWithRole:pwmPendingWithRole])
										
									}
									
									else {
										
										if(params.appTypeName=="Hazardeous Waste") {
											hwInst=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as wmc where wmc.industryRegMasterObj.id=? and wmc.completionStatus='Completed' order by wmc.id desc",[indId])
											if(hwInst.size()>0) {
												for(HazardeousWasteAuthApp hw:hwInst) {
													def checkInst=WasteManagementPendingDetails.findByapplicationId((hw.id).toString())
													if(checkInst) {
														hwStatusList.add(checkInst.applicationStatus)
														hwPendingWith.add(checkInst.pendingWith)
														hwPendingWithRole.add(checkInst.role)
													}
													else {
														hwStatusList.add("Unattended")
														hwPendingWith.add("Unknown")
														hwPendingWithRole.add("Unknown")
													}
												}
												
											}
										}
										if(params.appTypeName=="Bio-Medical Waste") {
											bmwInst=BioMedicalWaste.findAll("from BioMedicalWaste as wmc where wmc.industryRegMasterObj.id=? and wmc.completionStatus='Completed' order by wmc.id desc",[indId])
											if(bmwInst.size()>0) {
												for(BioMedicalWaste bmw:bmwInst) {
													def checkInst=WasteManagementPendingDetails.findByapplicationId((bmw.id).toString())
													if(checkInst) {
														bmwStatusList.add(checkInst.applicationStatus)
														bmwPendingWith.add(checkInst.pendingWith)
														bmwPendingWithRole.add(checkInst.role)
													}
													else {
														bmwStatusList.add("Unattended")
														bmwPendingWith.add("Unknown")
														bmwPendingWithRole.add("Unknown")
													}
												}
												
											}
										}
										if(params.appTypeName=="Municipal Solid Waste") {
											mwInst=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as wmc where wmc.industryRegMasterObj.id=? and wmc.completionStatus='Completed' order by wmc.id desc",[indId])
											if(mwInst.size()>0) {
												for(BioMedicalWaste msw:mwInst) {
													def checkInst=WasteManagementPendingDetails.findByapplicationId((msw.id).toString())
													if(checkInst) {
														mswStatusList.add(checkInst.applicationStatus)
														mswPendingWith.add(checkInst.pendingWith)
														mswPendingWithRole.add(checkInst.role)
													}
													else {
														mswStatusList.add("Unattended")
														mswPendingWith.add("Unknown")
														mswPendingWithRole.add("Unknown")
													}
												}
												
											}
										}
										if(params.appTypeName=="Plastic Waste") {
											pwmInst=PlasticWaste.findAll("from PlasticWaste as wmc where wmc.industryRegMasterObj.id=? and wmc.completionStatus='Completed' order by wmc.id desc",[indId])
											if(pwmInst.size()>0) {
												for(PlasticWaste pwm:pwmInst) {
													def checkInst=WasteManagementPendingDetails.findByapplicationId((pwm.id).toString())
													if(checkInst) {
														pwmStatusList.add(checkInst.applicationStatus)
														pwmPendingWith.add(checkInst.pendingWith)
														pwmPendingWithRole.add(checkInst.role)
													}
													else {
														pwmStatusList.add("Unattended")
														pwmPendingWith.add("Unknown")
														pwmPendingWithRole.add("Unknown")
													}
												}
												
											}
										}
										render(view:'searchApp',model:[accessLevelAdEm:accessLevelAdEm,hwInst:hwInst,bmwInst:bmwInst,mwInst:mwInst,pwmInst:pwmInst,appIdList:appIdList,hwStatusList:hwStatusList,hwPendingWith:hwPendingWith,hwPendingWithRole:hwPendingWithRole,bmwStatusList:bmwStatusList,bmwPendingWith:bmwPendingWith,bmwPendingWithRole:bmwPendingWithRole,mswStatusList:mswStatusList,mswPendingWith:mswPendingWith,mswPendingWithRole:mswPendingWithRole,pwmStatusList:pwmStatusList,pwmPendingWith:pwmPendingWith,pwmPendingWithRole:pwmPendingWithRole])
										
									}
									
									
									
									
								}
							}
						}
					}else if(params.searchOp=="ApplDate"){
						
						def checkDate
						Date today = new Date();
						
						def x
						def y
						def startDate1=params.start_date_value
						def endDate1=params.end_date_value
						
						def finalListToPrint=new ArrayList()
						
						
						def statusType=params.statusType
						
						
						
						
						def bioList
						def municipalList
						def hazardeousList
						def plasticWasteList
						
						def allFourB= new ArrayList()
						def appListB= new ArrayList()
						def statusListB= new ArrayList()
						def pendingWithB= new ArrayList()
						def pendingWithRoleB= new ArrayList()
						
						def allFourM= new ArrayList()
						def appListM= new ArrayList()
						def statusListM= new ArrayList()
						def pendingWithM= new ArrayList()
						def pendingWithRoleM= new ArrayList()
						
						def allFourH= new ArrayList()
						def appListH= new ArrayList()
						def statusListH= new ArrayList()
						def pendingWithH= new ArrayList()
						def pendingWithRoleH= new ArrayList()
						
						def allFourP= new ArrayList()
						def appListP= new ArrayList()
						def statusListP= new ArrayList()
						def pendingWithP= new ArrayList()
						def pendingWithRoleP= new ArrayList()
						
						def checkBio=false
						
						
						
						try {
							def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
							x = sdfh.parse(startDate1); //Date
							y = sdfh.parse(endDate1);  //Date
							checkDate="checked"
						}
						catch(Exception e) {
							println(e)
							flash.message="Enter Both The Dates in Correct Format "
							redirect(action:wasteSummary)
						}	
						if(checkDate) {
							java.sql.Date sqlDate = new java.sql.Date(x.getTime())
							java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
							sqlDate2.setDate((sqlDate2.getDate()+1))
							
							
							
							
							if(startDate1 && endDate1 && statusType=="xyz"){
								
								bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.id desc",[sqlDate,sqlDate2])
								
								if(bioList){
									for(int a=0;a<bioList.size();a++) {
										allFourB=bioList.get(a)
										if(allFourB) {
											checkBio=true
											
											appListB.add((allFourB))
											def appliFor="BMW"
											def appliIdStr=(allFourB.id).toString()
											def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
											def checkInst=	checkInstList[0]			
											if(checkInst) {
												statusListB.add(checkInst.applicationStatus)
												pendingWithB.add(checkInst.pendingWith)
												pendingWithRoleB.add(checkInst.role)
											}
											else {
												statusListB.add("Unattended")
												pendingWithB.add("Unknown")
												pendingWithRoleB.add("Unknown")
											}
										}
									}
								}
								
								municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus != 'unattended' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.id desc",[sqlDate,sqlDate2])
								if(municipalList){
									for(int a=0;a<municipalList.size();a++) {
										allFourM=municipalList.get(a)
										if(allFourM) {
											checkBio=true
											appListM.add((allFourM))
											
											def appliFor="MSW"
											def appliIdStr=(allFourM.id).toString()
											def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
											def checkInst=	checkInstList[0]			
											if(checkInst) {
												statusListM.add(checkInst.applicationStatus)
												pendingWithM.add(checkInst.pendingWith)
												pendingWithRoleM.add(checkInst.role)
											}
											else {
												statusListM.add("Unattended")
												pendingWithM.add("Unknown")
												pendingWithRoleM.add("Unknown")
											}
										}
									}
								}
								
								
								hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.id desc",[sqlDate,sqlDate2])
								if(hazardeousList){
									for(int a=0;a<hazardeousList.size();a++) {
										allFourH=hazardeousList.get(a)
										if(allFourH) {
											checkBio=true
											appListH.add((allFourH))
											def appliFor="HWM"
											def appliIdStr=(allFourH.id).toString()
											def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
											def checkInst=	checkInstList[0]			
											if(checkInst) {
												statusListH.add(checkInst.applicationStatus)
												pendingWithH.add(checkInst.pendingWith)
												pendingWithRoleH.add(checkInst.role)
											}
											else {
												statusListH.add("Unattended")
												pendingWithH.add("Unknown")
												pendingWithRoleH.add("Unknown")
											}
										}
									}
								}
								
								
								plasticWasteList=PlasticWaste.findAll("from PlasticWaste as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.id desc",[sqlDate,sqlDate2])
								if(plasticWasteList){
									for(int a=0;a<plasticWasteList.size();a++) {
										allFourP=plasticWasteList.get(a)
										if(allFourP) {
											checkBio=true
											appListP.add((allFourP))
											def appliFor="PWM"
											def appliIdStr=(allFourP.id).toString()
											def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='PWM'",[appliIdStr],[max:1])
											def checkInst=	checkInstList[0]			
											if(checkInst) {
												statusListP.add(checkInst.applicationStatus)
												pendingWithP.add(checkInst.pendingWith)
												pendingWithRoleP.add(checkInst.role)
											}
											else {
												statusListP.add("Unattended")
												pendingWithP.add("Unknown")
												pendingWithRoleP.add("Unknown")
											}
										}
									}
								}
								
							}else if(startDate1 && endDate1 && statusType!="xyz"){
								if(statusType=="BMW"){
									bioList=BioMedicalWaste.findAll("from BioMedicalWaste as bmw where bmw.completionStatus='Completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.id desc ",[sqlDate,sqlDate2])
									
									if(bioList){
										for(int a=0;a<bioList.size();a++) {
											allFourB=bioList.get(a)
											if(allFourB) {
												checkBio=true
												
												appListB.add((allFourB))
												def appliFor="BMW"
												def appliIdStr=(allFourB.id).toString()
												def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='BMW'",[appliIdStr],[max:1])
												def checkInst=	checkInstList[0]			
												if(checkInst) {
													statusListB.add(checkInst.applicationStatus)
													pendingWithB.add(checkInst.pendingWith)
													pendingWithRoleB.add(checkInst.role)
												}
												else {
													statusListB.add("Unattended")
													pendingWithB.add("Unknown")
													pendingWithRoleB.add("Unknown")
												}
											}
										}
									}
								}
								if(statusType=="MSW"){
									municipalList=MunicipalSolidWaste.findAll("from MunicipalSolidWaste as msw where msw.completionStatus='Completed' and msw.applicationStatus != 'unattended' and msw.dateCreated>=? and msw.dateCreated<=? order by msw.id desc",[sqlDate,sqlDate2])
									if(municipalList){
										for(int a=0;a<municipalList.size();a++) {
											allFourM=municipalList.get(a)
											if(allFourM) {
												checkBio=true
												appListM.add((allFourM))
												
												def appliFor="MSW"
												def appliIdStr=(allFourM.id).toString()
												def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='MSW'",[appliIdStr],[max:1])
												def checkInst=	checkInstList[0]			
												if(checkInst) {
													statusListM.add(checkInst.applicationStatus)
													pendingWithM.add(checkInst.pendingWith)
													pendingWithRoleM.add(checkInst.role)
												}
												else {
													statusListM.add("Unattended")
													pendingWithM.add("Unknown")
													pendingWithRoleM.add("Unknown")
												}
											}
										}
									}
								}
								if(statusType=="HWM"){
									hazardeousList=HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.id desc",[sqlDate,sqlDate2])
									if(hazardeousList){
										for(int a=0;a<hazardeousList.size();a++) {
											allFourH=hazardeousList.get(a)
											if(allFourH) {
												checkBio=true
												appListH.add((allFourH))
												def appliFor="HWM"
												def appliIdStr=(allFourH.id).toString()
												def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='HWM'",[appliIdStr],[max:1])
												def checkInst=	checkInstList[0]			
												if(checkInst) {
													statusListH.add(checkInst.applicationStatus)
													pendingWithH.add(checkInst.pendingWith)
													pendingWithRoleH.add(checkInst.role)
												}
												else {
													statusListH.add("Unattended")
													pendingWithH.add("Unknown")
													pendingWithRoleH.add("Unknown")
												}
											}
										}
									}
								}
								if(statusType=="PWM"){

									plasticWasteList=PlasticWaste.findAll("from PlasticWaste as hwa where hwa.completionStatus='Completed' and hwa.applicationStatus != 'unattended' and hwa.dateCreated>=? and hwa.dateCreated<=? order by hwa.id desc",[sqlDate,sqlDate2])
									if(plasticWasteList){
										for(int a=0;a<plasticWasteList.size();a++) {
											allFourP=plasticWasteList.get(a)
											if(allFourP) {
												checkBio=true
												appListP.add((allFourP))
												def appliFor="PWM"
												def appliIdStr=(allFourP.id).toString()
												def checkInstList=WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='PWM'",[appliIdStr],[max:1])
												def checkInst=	checkInstList[0]			
												if(checkInst) {
													statusListP.add(checkInst.applicationStatus)
													pendingWithP.add(checkInst.pendingWith)
													pendingWithRoleP.add(checkInst.role)
												}
												else {
													statusListP.add("Unattended")
													pendingWithP.add("Unknown")
													pendingWithRoleP.add("Unknown")
												}
											}
										}
									}
								
								}
								
							}
						}
						
						if(bioList && municipalList && hazardeousList && plasticWasteList){
							finalListToPrint=bioList+municipalList+hazardeousList+plasticWasteList
						}else if(bioList && municipalList && !hazardeousList){
							finalListToPrint=bioList+municipalList
						}else if(bioList && !municipalList && !hazardeousList){
							finalListToPrint=bioList
						}else if(!bioList && !municipalList && hazardeousList){
							finalListToPrint=hazardeousList
						}else if(!bioList && municipalList && !hazardeousList){
							finalListToPrint=municipalList
						}else if(bioList && !municipalList && hazardeousList){
							finalListToPrint=bioList+municipalList+hazardeousList
						}else if(!bioList && municipalList && hazardeousList){
							finalListToPrint=municipalList+hazardeousList
						}
						
						
						render(view:'searchApp',model:[accessLevelAdEm:accessLevelAdEm,appIdList:appIdList,finalListToPrint:finalListToPrint,checkBio:checkBio,bioList:bioList,municipalList:municipalList,hazardeousList:hazardeousList,plasticWasteList:plasticWasteList,statusListB:statusListB,pendingWithB:pendingWithB,pendingWithRoleB:pendingWithRoleB,statusListM:statusListM,pendingWithM:pendingWithM,pendingWithRoleM:pendingWithRoleM,statusListH:statusListH,pendingWithH:pendingWithH,pendingWithRoleH:pendingWithRoleH,statusListP:statusListP,pendingWithP:pendingWithP,pendingWithRoleP:pendingWithRoleP])
						
					}
					else {
						flash.message="Please select search criteria first"
						redirect(action:searchApp)
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
	
	def printHazardeousWaste={
			 try {
					def industryId = session.indUser
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
					def appId=hazardeousWasteAuthAppInstance.id
					def appFor="HWM"
					def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
					def certInstance=checkCertificate[0]
					def certInstanceId
					if(certInstance){
						certInstanceId=certInstance.id
					}
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					
					def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def wasteManagementFileList = WasteManagementFile.findAll("from WasteManagementFile as wmf where applicationId=? and wmf.typeOfFile!='attachedInspectionReport' and wmf.typeOfFile!='attachedClarificationReport' and wmf.typeOfFile!='inspectionReport' and wmf.typeOfFile!='indClarificationFile' ",[hazardeousWasteAuthAppInstance.id])
					def flowDiagList=WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "flowDiagramManufacturingProcess")
					def siteMapList= WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "locationOfSite") 
					def prossTechDetailsList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "processingTechDetails")
					def siteClearenceList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "siteClearance")
					def utilProgList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "utilizationProgramme") 
					def disposalMethodList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "disposalMethod")
					def wasteNatureAndCompList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "wasteNatureAndComposition")
					def landfillingIncinerationList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "landfillingIncinerationMethodology")
					def prevAndControlList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "preventionAndControlMeasures")
					
					def saftyMeasureList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id , typeOfFile : "safetyMeasures")
					
					String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
					ArrayList tmp1=new ArrayList()
					tmp1=tmp.split(",")
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "Hazardeous Waste not found with id ${params.id}"
						redirect(action:show)
					}
					else { 
						return [certInstanceId:certInstanceId,hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1,flowDiagList:flowDiagList,siteMapList:siteMapList,prossTechDetailsList:prossTechDetailsList,siteClearenceList:siteClearenceList,utilProgList:utilProgList,disposalMethodList:disposalMethodList,wasteNatureAndCompList:wasteNatureAndCompList,landfillingIncinerationList:landfillingIncinerationList,prevAndControlList:prevAndControlList,saftyMeasureList:saftyMeasureList] 
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
	
	def viewHazCert={
			 try {
					def industryId = session.indUser
					def userId = session.userMaster
					if((userId==null || userId=="") && (industryId==null || industryId=="")) {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def application = WasteManagementCertificates.get((params.id).toLong())
					def applicationFileSingleInstance=application
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
	
	def viewHazCert1={
			 try {
					def industryId = session.indUser
					def userId = session.userMaster
					if((userId==null || userId=="") && (industryId==null || industryId=="")) {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def temp=(params.id).toLong()
					def application = WasteManagementCertificates.findAllWhere(applicationId:temp)    	
					def applicationFileSingleInstance=application[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
	
	def callEdit = {
			 try {
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.editId )
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					
					String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
					ArrayList tmp1=new ArrayList()
					tmp1=tmp.split(",")
					
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
						redirect(action:list)
					}
					else {
						render(view:'edit',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , tmp1:tmp1])
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
	
	def deleteRow ={
			 try {
					def editId = HazardeousWasteAuthApp.get(params.verValue)
					def hazardeousWasteDetails = IndHazardeousWasteDetails.get((params.appliLoc).toLong())
					hazardeousWasteDetails.delete()
					
					flash.message = "Hazardeous Waste Details deleted click edit for future modification"
					
					redirect(action:show,id:editId)
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
	
	def deleteRowPro ={
			 try {
					def editId = HazardeousWasteAuthApp.get(params.verValue)
					def hazardeousProductDetails = IndHWProductDetails.get((params.appliLoc).toLong())
					hazardeousProductDetails.delete()
					flash.message = "Product Details deleted click edit for future modification"
					redirect(action:show,id:editId)
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
	
	def viewFormPdf = {
			 try {
					def applicationFileInstance
					def appli=(params.appliLoc).toLong()
					applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile afr where afr.applicationId=? and afr.typeOfFile='HazardeousProfile' ",[appli])
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
	
	
	def showNewFormat1 = {
			 try {
				    
					def industryId = session.indUser
					/*if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}*/
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( (params.id).toInteger() )
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def listDoc=WasteManagementFile.findAll("from WasteManagementFile where applicationId = ? and typeOfFile='Uploded Documents' and resubmittedDoc=false ",[hazardeousWasteAuthAppInstance.id]);
					def listDoc1=WasteManagementFile.findAll("from WasteManagementFile where applicationId = ? and typeOfFile='Uploded Documents' and resubmittedDoc=true ",[hazardeousWasteAuthAppInstance.id]);
					
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
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
			            
						render(view:'showNewFormat',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,listDoc:listDoc,listDoc1:listDoc1] ) 
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
	
	
	
	
///////////////////////////////////New HWM application format Start//////////////////////////////
	def createNewFormat={
			 try {
				    
					def industryId = session.indUser
					if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					
					def hazardeousWasteAuthAppInstance = new HazardeousWasteAuthApp()		
					
					IndUser indUserInstance=(IndUser)session.indUser
					
					def indRegInstance=indUserInstance.industryRegMaster
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					
					
					
				
					hazardeousWasteAuthAppInstance.industryRegMasterObj = indRegInstanceGet
					hazardeousWasteAuthAppInstance.completionStatus = "Inprogress"
					hazardeousWasteAuthAppInstance.authorization_Required_For = ""
					hazardeousWasteAuthAppInstance.is_Renew = ""
					hazardeousWasteAuthAppInstance.auth_Renew_No = 0
					hazardeousWasteAuthAppInstance.auth_Renew_Date = new Date()
					hazardeousWasteAuthAppInstance.createdBy = ""
					hazardeousWasteAuthAppInstance.updatedBy = ""
					hazardeousWasteAuthAppInstance.dateCreated = new Date()
					
					hazardeousWasteAuthAppInstance.clarification = false
					hazardeousWasteAuthAppInstance.inspection = false
					hazardeousWasteAuthAppInstance.applicationStatus = "Inprogress"
						hazardeousWasteAuthAppInstance.sourceAndWasteChar = ""
						hazardeousWasteAuthAppInstance.hazardChemicalRules = ""
						hazardeousWasteAuthAppInstance.publicLiability = ""
						hazardeousWasteAuthAppInstance.handlingQuantity = ""
						hazardeousWasteAuthAppInstance.importingHazardChemicals = ""
						hazardeousWasteAuthAppInstance.recycleHazard = ""
						hazardeousWasteAuthAppInstance.isNewApplication = true
						hazardeousWasteAuthAppInstance.statusOfRecycle = ""
						hazardeousWasteAuthAppInstance.registerRecyclerDetails = ""
						hazardeousWasteAuthAppInstance.importHazard = ""
						hazardeousWasteAuthAppInstance.statusOfImport = ""
						hazardeousWasteAuthAppInstance.regDate = new Date()
						hazardeousWasteAuthAppInstance.expDate = new Date()
						hazardeousWasteAuthAppInstance.passNo = ""
						hazardeousWasteAuthAppInstance.authorQty = ""
						hazardeousWasteAuthAppInstance.issuedBy = ""
						///////////////added by shashank/////////////////
						hazardeousWasteAuthAppInstance.generatinghazardous=""
						hazardeousWasteAuthAppInstance.generatinghazardousname=""
						hazardeousWasteAuthAppInstance.generatinghazardousquantity=""
						hazardeousWasteAuthAppInstance.situatedcritically=""
						
						
						
						hazardeousWasteAuthAppInstance.Locofsite=""
						hazardeousWasteAuthAppInstance.protechnology=""
						hazardeousWasteAuthAppInstance.Dprotechnology=""
						hazardeousWasteAuthAppInstance.Typewasteprocessed=""
						hazardeousWasteAuthAppInstance.Quantitywasteprocessed=""
						hazardeousWasteAuthAppInstance.Methodofdisposalbrief=""
						hazardeousWasteAuthAppInstance.Quantityofwaste=""
						hazardeousWasteAuthAppInstance.Naturencomposition=""
						hazardeousWasteAuthAppInstance.Methodologynoperational=""
						hazardeousWasteAuthAppInstance.Measurestakenprevention=""
						hazardeousWasteAuthAppInstance.InvestmentProject=""
						hazardeousWasteAuthAppInstance.ExpectedreturnsProject=""
						hazardeousWasteAuthAppInstance.workingplant=""
						
						hazardeousWasteAuthAppInstance.is_transporters=""
						hazardeousWasteAuthAppInstance.transporterSource=""
						hazardeousWasteAuthAppInstance.transporterDestination=""
							hazardeousWasteAuthAppInstance.expectedReturn=0
							hazardeousWasteAuthAppInstance.hw_Defined=""
								hazardeousWasteAuthAppInstance.location_Of_Activity=""
						
						////////////////end by shashank/////////////
						
						
						hazardeousWasteAuthAppInstance.properties = params
						if(hazardeousWasteAuthAppInstance.save(flush:true))
						{
							
							
							
						}
						else{
								

		    				hazardeousWasteAuthAppInstance.errors.each {
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
				    activityRecInstance.activity = "view"
		            activityRecInstance.status = "Hazardeous Waste Apply Click"
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
					return ['hazardeousWasteAuthAppInstance':hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil]
				
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
				    
					def industryId = session.indUser
					if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					
					def hazardeousWasteAuthAppInstance = new HazardeousWasteAuthApp()		
					
					IndUser indUserInstance=(IndUser)session.indUser
					
					def indRegInstance=indUserInstance.industryRegMaster
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					
					
					
				
					hazardeousWasteAuthAppInstance.industryRegMasterObj = indRegInstanceGet
					hazardeousWasteAuthAppInstance.completionStatus = "Inprogress"
					hazardeousWasteAuthAppInstance.authorization_Required_For = ""
					hazardeousWasteAuthAppInstance.is_Renew = ""
					hazardeousWasteAuthAppInstance.auth_Renew_No = 0
					hazardeousWasteAuthAppInstance.auth_Renew_Date = new Date()
					hazardeousWasteAuthAppInstance.createdBy = ""
					hazardeousWasteAuthAppInstance.updatedBy = ""
					hazardeousWasteAuthAppInstance.dateCreated = new Date()
					
					hazardeousWasteAuthAppInstance.clarification = false
					hazardeousWasteAuthAppInstance.inspection = false
					hazardeousWasteAuthAppInstance.applicationStatus = "Inprogress"
						hazardeousWasteAuthAppInstance.sourceAndWasteChar = ""
						hazardeousWasteAuthAppInstance.hazardChemicalRules = ""
						hazardeousWasteAuthAppInstance.publicLiability = ""
						hazardeousWasteAuthAppInstance.handlingQuantity = ""
						hazardeousWasteAuthAppInstance.importingHazardChemicals = ""
						hazardeousWasteAuthAppInstance.recycleHazard = ""
						hazardeousWasteAuthAppInstance.isNewApplication = true
						hazardeousWasteAuthAppInstance.statusOfRecycle = ""
						hazardeousWasteAuthAppInstance.registerRecyclerDetails = ""
						hazardeousWasteAuthAppInstance.importHazard = ""
						hazardeousWasteAuthAppInstance.statusOfImport = ""
						hazardeousWasteAuthAppInstance.regDate = new Date()
						hazardeousWasteAuthAppInstance.expDate = new Date()
						hazardeousWasteAuthAppInstance.passNo = ""
						hazardeousWasteAuthAppInstance.authorQty = ""
						hazardeousWasteAuthAppInstance.issuedBy = ""
						///////////////added by shashank/////////////////
						hazardeousWasteAuthAppInstance.generatinghazardous=""
						hazardeousWasteAuthAppInstance.generatinghazardousname=""
						hazardeousWasteAuthAppInstance.generatinghazardousquantity=""
						hazardeousWasteAuthAppInstance.situatedcritically=""
						
						
						
						hazardeousWasteAuthAppInstance.Locofsite=""
						hazardeousWasteAuthAppInstance.protechnology=""
						hazardeousWasteAuthAppInstance.Dprotechnology=""
						hazardeousWasteAuthAppInstance.Typewasteprocessed=""
						hazardeousWasteAuthAppInstance.Quantitywasteprocessed=""
						hazardeousWasteAuthAppInstance.Methodofdisposalbrief=""
						hazardeousWasteAuthAppInstance.Quantityofwaste=""
						hazardeousWasteAuthAppInstance.Naturencomposition=""
						hazardeousWasteAuthAppInstance.Methodologynoperational=""
						hazardeousWasteAuthAppInstance.Measurestakenprevention=""
						hazardeousWasteAuthAppInstance.InvestmentProject=""
						hazardeousWasteAuthAppInstance.ExpectedreturnsProject=""
						hazardeousWasteAuthAppInstance.workingplant=""
						
						hazardeousWasteAuthAppInstance.is_transporters=""
						hazardeousWasteAuthAppInstance.transporterSource=""
						hazardeousWasteAuthAppInstance.transporterDestination=""
						hazardeousWasteAuthAppInstance.expectedReturn=0
						hazardeousWasteAuthAppInstance.hw_Defined=""
						hazardeousWasteAuthAppInstance.location_Of_Activity=""
						hazardeousWasteAuthAppInstance.serviceId=session.serviceId
						hazardeousWasteAuthAppInstance.cafUniqueNo=session.cafUniqueNo
						hazardeousWasteAuthAppInstance.singleWin=true
						////////////////end by shashank/////////////
						
						
						hazardeousWasteAuthAppInstance.properties = params
						if(hazardeousWasteAuthAppInstance.save(flush:true))
						{
							
							
							
						}
						else{
								

		    				hazardeousWasteAuthAppInstance.errors.each {
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
				    activityRecInstance.activity = "view"
		            activityRecInstance.status = "Hazardeous Waste Apply Click"
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
					render(view:'createNewFormat',model:['hazardeousWasteAuthAppInstance':hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil])
				    return;
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
	
	def popHazardActivityGenDetailsAddNewFormat = {
			 try {
				    
					
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def hazardousWasteDetailsList = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM s where s.application=? order by id asc",[app])
			    	def hazarMasterList1 = HazardousSourceGenMaster.findAllBySchedule("Schedule I",[sort: "version"])
			    	def hazarMasterList2 = HazardousSourceGenMaster.findAllBySchedule("Schedule II",[sort: "version"])
			    	def hazarMasterList3 = HazardousSourceGenMaster.findAllBySchedule("Schedule III",[sort: "version"])
			    	

			    	def page=params.page
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
			        activityRecInstance.status = "Waste Application "+params.id+ " Hazardous Waste Generation Details Click on Add."
			        if(activityRecInstance.save()){		   
			          }
			        	else{
			        		activityRecInstance.errors.each {
					    	println it
					  }
				    }
			    	return [appDetId:params.id,hazardousWasteDetailsList:hazardousWasteDetailsList,hazarMasterList1:hazarMasterList1,hazarMasterList2:hazarMasterList2,hazarMasterList3:hazarMasterList3]
			    
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
 def popHazardActivityGenDetailsViewNewFormat = {
			 try {
				    
					
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())

			    	
			    	def hazardousWasteDetailsList = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM s where s.application=? order by id asc",[app])

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
			        activityRecInstance.status = "Waste Application "+params.id+ " Hazardous Waste Generation Click on View."
			        if(activityRecInstance.save()){		   
			          }
			        	else{
			        		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			    	return [appDetId:params.id,hazardousWasteDetailsList:hazardousWasteDetailsList]
			    
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
	def popHazardActivityGenDetailsEditNewFormat = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def hazardousWasteDetailsList = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM s where s.application=? order by id asc",[app])
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
			        activityRecInstance.status = "Waste Application "+params.id+ " Hazardous Waste Generation Click on Edit."
			        if(activityRecInstance.save()){		   
			          }
			        	else{
			        		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			    	return [appDetId:params.id,hazardousWasteDetailsList:hazardousWasteDetailsList]
			    
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
	
	  def deleteHazardGenDetailsNewFormat = {
			 try {
				    
					def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
					if((params.delete).getClass().getName()== "java.lang.String"){
					
					
			   		def hazardousWasteGenDetailsInst = HazardousWasteDetailsHWM.get((params.delete).toInteger())
			   		def characteristicsAndManagementInst=CharacteristicsAndManagementHWM.find("from CharacteristicsAndManagementHWM c where c.wasteDetails=? ",[hazardousWasteGenDetailsInst]);
			   		if(characteristicsAndManagementInst){
			   			characteristicsAndManagementInst.delete()
			   		}
			   		hazardousWasteGenDetailsInst.delete()
				}else{
			   		if(params.delete)
			       	for(int i=0;i<(params.delete).size();i++){
			       		def hazardousWasteGenDetailsInst = HazardousWasteDetailsHWM.get((params.delete[i]).toInteger())
			       		def characteristicsAndManagementInst=CharacteristicsAndManagementHWM.find("from CharacteristicsAndManagementHWM c where c.wasteDetails=? ",[hazardousWasteGenDetailsInst]);
			       		if(characteristicsAndManagementInst){
			       			characteristicsAndManagementInst.delete()
			       		}
			       		hazardousWasteGenDetailsInst.delete()
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
					    activityRecInstance.status = "Waste Application "+params.appId+" Hazardous Waste Generation Details Delete"
				        if(activityRecInstance.save()){		   
				          }
				        	else{
				        		activityRecInstance.errors.each {
						    	println it
						  }
					  }
					redirect(action:popHazardActivityGenDetailsEditNewFormat,id:app)
			   
		    
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
	def popCharacteristicsAndManagement = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def hazardousWasteDetailsList = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM s where s.application=? order by id asc",[app])
			        return [appDetId:params.id,hazardousWasteDetailsList:hazardousWasteDetailsList]
			    
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
	
	def popCharacteristicsAndManagementView = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def hazardousWasteDetailsList = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM s where s.application=? order by id asc",[app])
			        return [appDetId:params.id,hazardousWasteDetailsList:hazardousWasteDetailsList]
			    
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
	
	def popCharacteristicsAndManagementSave = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
					(params.hazardousWasteDetailsId).getClass()
			    	
			    	if((params.hazardousWasteDetailsId).getClass().getName()== "java.lang.String")
			       	{
			    		def hazardousWasteDetailsInstance=HazardousWasteDetailsHWM.get((params.hazardousWasteDetailsId).toLong());
			    		if(hazardousWasteDetailsInstance)
			    		{
			    			def instCharacteristicsAndManagementHWM=CharacteristicsAndManagementHWM.findByWasteDetails(hazardousWasteDetailsInstance);
			    			if(!instCharacteristicsAndManagementHWM)
			    			{
			    				instCharacteristicsAndManagementHWM= new CharacteristicsAndManagementHWM();
			    			}
			    			instCharacteristicsAndManagementHWM.application=app;
			    			instCharacteristicsAndManagementHWM.wasteDetails=hazardousWasteDetailsInstance;
			    			instCharacteristicsAndManagementHWM.characterisitics=params.characterisitics;
			    			instCharacteristicsAndManagementHWM.utilization=params.utilization;
			    			instCharacteristicsAndManagementHWM.ifNotUtilized=params.ifNotUtilized;
			    			instCharacteristicsAndManagementHWM.arrangementsForTransportation=params.arrangementsForTransportation;
			    			instCharacteristicsAndManagementHWM.environmentalSafeguards=params.environmentalSafeguards;
			    			if(!instCharacteristicsAndManagementHWM.hasErrors() && instCharacteristicsAndManagementHWM.save()) {
			    				
			    				flash.message = "Details Saved"
			    			}
			    			else
			    			{
			    				instCharacteristicsAndManagementHWM.errors.each { println it}
			    				flash.message = "Error occurs..Try Again"
			    			}
			    			
			    		}
			    		
			       	}
			    	else
			    	{
			    		for(int ii=0;ii<params.hazardousWasteDetailsId.size();ii++)
			    		{
			    			def hazardousWasteDetailsInstance=HazardousWasteDetailsHWM.get((params.hazardousWasteDetailsId[ii]).toLong());
			        		if(hazardousWasteDetailsInstance)
			        		{
			        			def instCharacteristicsAndManagementHWM=CharacteristicsAndManagementHWM.findByWasteDetails(hazardousWasteDetailsInstance);
			        			if(!instCharacteristicsAndManagementHWM)
			        			{
			        				instCharacteristicsAndManagementHWM= new CharacteristicsAndManagementHWM();
			        			}
			        			instCharacteristicsAndManagementHWM.application=app;
			        			instCharacteristicsAndManagementHWM.wasteDetails=hazardousWasteDetailsInstance;
			        			instCharacteristicsAndManagementHWM.characterisitics=params.characterisitics[ii];
			        			instCharacteristicsAndManagementHWM.utilization=params.utilization[ii];
			        			instCharacteristicsAndManagementHWM.ifNotUtilized=params.ifNotUtilized[ii];
			        			instCharacteristicsAndManagementHWM.arrangementsForTransportation=params.arrangementsForTransportation[ii];
			        			instCharacteristicsAndManagementHWM.environmentalSafeguards=params.environmentalSafeguards[ii];
			        			if(!instCharacteristicsAndManagementHWM.hasErrors() && instCharacteristicsAndManagementHWM.save()) {
			        				
			        				flash.message = "Details Saved"
			        			}
			        			else
			        			{
			        				instCharacteristicsAndManagementHWM.errors.each { println it}
			        				flash.message = "Error occurs..Try Again"
			        			}
			        			
			        		}	
			    		}
			    	}
			    	
			    	redirect(action:popCharacteristicsAndManagement,id:params.id)
			        return
			    
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
	        
	
	def popRecyclableHazardousWasteAdd = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def recyclableHazardousWasteHWMList = RecyclableHazardousWasteHWM.findAllByApplication(app)
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
		            activityRecInstance.status = "Hazardeous Waste Application "+params.id+ " Nature and quantity of different commonly recyclable Details Click on Add."	
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			    	return [appId:params.id,recyclableHazardousWasteHWMList:recyclableHazardousWasteHWMList]
			    
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
	def popRecyclableHazardousWasteView = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def recyclableHazardousWasteHWMList = RecyclableHazardousWasteHWM.findAllByApplication(app)
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
		            activityRecInstance.status = "Hazardeous Waste Application "+params.id+ " Nature and quantity of different commonly recyclable Details View."	
			        if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
		    		    	println it
		    		  }
		    	  }
			    	return [appId:params.id,recyclableHazardousWasteHWMList:recyclableHazardousWasteHWMList]
			    
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
	def popRecyclableHazardousWasteEdit = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def recyclableHazardousWasteHWMList = RecyclableHazardousWasteHWM.findAllByApplication(app)
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
		            activityRecInstance.status = "Hazardeous Waste Application "+params.id+ " Nature and quantity of different commonly recyclable Details Click on Edit."	
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			    	return [appId:params.id,recyclableHazardousWasteHWMList:recyclableHazardousWasteHWMList]
			    
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
	def deleteRecyclableHazardousWaste = {
			 try {
				    
			    	def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def hazardousWasteGenDetailsInst = RecyclableHazardousWasteHWM.get((params.delete).toInteger())
			    		hazardousWasteGenDetailsInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def hazardousWasteGenDetailsInst = RecyclableHazardousWasteHWM.get((params.delete[i]).toInteger())
			        		hazardousWasteGenDetailsInst.delete()
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
		            activityRecInstance.status = "Hazardeous Waste Application "+params.appId+ " Nature and quantity of different commonly recyclable Details Delete."	
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  }
			    	redirect(action:popRecyclableHazardousWasteEdit,id:app)
			    	
			    
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
	def saveHazardGenDetailsNewFormat = {
			 try {
				    
					
			    	def menu1=params.menu1

			    	def radiobutton1=params.radiobutton1
					if(radiobutton1=="Schedule I")
					{
						menu1=menu1[0];
					}
					else if(radiobutton1=="Schedule II")
					{
						menu1=menu1[1];
					}
					else if(radiobutton1=="Schedule III")
					{
						menu1=menu1[2];
					}
					
			    	def hazardousSourceGenMaster=HazardousSourceGenMaster.get((menu1).toLong());
					def hazardousCategoryMaster=HazardousCategoryMaster.get((params.menu2).toLong());
					def hazardeousWasteAuthApp=HazardeousWasteAuthApp.get((params.appId).toLong());
					def hazardousWasteDetailsHWM=new HazardousWasteDetailsHWM(params);
					hazardousWasteDetailsHWM.application=hazardeousWasteAuthApp;
					hazardousWasteDetailsHWM.category=hazardousCategoryMaster;
					hazardousWasteDetailsHWM.source=hazardousSourceGenMaster;
					hazardousWasteDetailsHWM.schedule=radiobutton1;
					hazardousWasteDetailsHWM.authorisationAcivity="";
					hazardousWasteDetailsHWM.qtyStoredUnit=params.qtyStoredUnit
					
					
					if(hazardousCategoryMaster.id==333330)
					{
						hazardousWasteDetailsHWM.categoryText=params.categoryText;
					}
					else
					{
						hazardousWasteDetailsHWM.categoryText="";
					}
					if(!hazardousWasteDetailsHWM.hasErrors() && hazardousWasteDetailsHWM.save()) {
						
						flash.message = "Details Saved"
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
					    activityRecInstance.status = "Waste Application "+params.appId+ " Hazardous Waste Generation Details Save."
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
						hazardousWasteDetailsHWM.errors.each { println it}
						flash.message = "Error occurs..Try Again"
					}
					
					redirect(action:popHazardActivityGenDetailsAddNewFormat,id:params.appId)
					return
				
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
	
 def myAjaxNewFormat ={
			 try {
				    
					
					def menu1Id=params.menu1Id.toLong()
					String htmlText="";
					// for C-H1 to C-H13 same menu2 list options will appears...
					if(menu1Id==2 ||menu1Id==3 ||menu1Id==4 ||menu1Id==6 ||menu1Id==9 ||menu1Id==10 ||menu1Id==11 ||menu1Id==12 ||menu1Id==13 ||menu1Id==14 ||menu1Id==642 ||menu1Id==25565 ||menu1Id==44344 ||menu1Id==76767)
					{
						menu1Id=642
					}
					def hazardNameList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster where sourceName.id=? order by version",[menu1Id.toLong()])
					
					if(hazardNameList && hazardNameList.size()>0)
					{
						htmlText="<select name='menu2' id='menu2Schedule' style='width:300px;' class='txt4'>";
						htmlText+="<option value='9999'>Not Selected</option>";
						for(int ii=0;ii<hazardNameList.size();ii++)
						{
							htmlText+="<option value='"+(hazardNameList.get(ii).id)+"'>"+(hazardNameList.get(ii).name)+"</option>";
						}
						htmlText+="</select>";
					}
					else
					{
						// for those category list is not there than 333330 id will be default and text field value will insert in 
						// categoryText field. Manish bhardwaj 20-05-2016
						htmlText="<input type='hidden' name='menu2' value='333330' id='menu2Schedule'><input type='text' name='categoryText' id='categoryText' style='width:300px;' class='txt4'>";
					}
					render htmlText
				
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

	
	def updatePassbookType=
	{
			 try {
				    
					def menu1=params.menu1
					def hashMap=new HashMap<String,String>();
					hashMap.put("Brass Dross","Non Ferrous other than Lead");
					hashMap.put("Copper Dross","Non Ferrous other than Lead");
					hashMap.put("Copper Oxide mill scale","Non Ferrous other than Lead");
					hashMap.put("Copper reverts, cake and residue","Non Ferrous other than Lead");
					hashMap.put("Waste Copper and copper alloys in dispersible from","Non Ferrous other than Lead");
					hashMap.put("Slags from copper processing for further processing or refining","Non Ferrous other than Lead");
					hashMap.put("Insulated Copper Wire Scrap or copper with PVC sheathing including ISRI-code material namely Druid","Non Ferrous other than Lead");
					hashMap.put("Jelly filled Copper cables","Non Ferrous other than Lead");
					hashMap.put("Spent cleared metal catalyst containing copper","Non Ferrous other than Lead");
					hashMap.put("Spent catalyst containing nickel, cadmium, Zinc, copper, arsenic, vanadium and cobalt","Non Ferrous other than Lead");
					hashMap.put("Zinc Dross-Hot dip Galvanizers SLAB","Non Ferrous other than Lead");
					hashMap.put("Zinc Dross-Bottom Dross","Non Ferrous other than Lead");
					hashMap.put("Zinc ash/Skimmings arising from galvanizing and die casting operations","Non Ferrous other than Lead");
					hashMap.put("Zinc ash/Skimming/other zinc bearing wastes arising from smelting and refining","Non Ferrous other than Lead");
					hashMap.put("Zinc ash and residues including zinc alloy residues in dispersible from","Non Ferrous other than Lead");
					hashMap.put("Spent cleared metal catalyst containing zinc","Non Ferrous other than Lead");
					hashMap.put("Used Lead acid battery including grid plates and other lead scrap/ashes/residues not covered under Batteries (Management and Handling) Rules, 2001. (Battery scrap, namely: Lead battery plates covered by ISRI, Code word Rails Battery lugs covered by ISRI, Code word Rakes. Scrap drained/dry while intact, lead batteries covered by ISRI, Code word rains.","Lead bearing");
					hashMap.put("Components of waste electrical and electronic assembles comprising accumulators and other batteries included in Part A of Schedule III, mercury-switches, activated glass cullets from cathode-ray tubes and other activated glass and PCB-capacitors, or any other component contaminated with Schedule II constituents (e.g. cadmium, mercury, lead, polychlorinated biphenyl) to an extent that they exhibit hazard characteristics indicated in part C of Schedule III.","E-wastes");
					hashMap.put("Paint and ink Sludge/residues","Used /waste Oil");
					hashMap.put("Used oil and waste oil","Used /waste Oil");
					String htmlText=hashMap.get(menu1);
					render htmlText		
				
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
	
	def saveRecyclableHazardousWaste={
			 try {
				    
					def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
					if(app)
					{
						def recyclableHazardousInstance = new RecyclableHazardousWasteHWM(params);
						recyclableHazardousInstance.application=app;
						
						if(!recyclableHazardousInstance.hasErrors() && recyclableHazardousInstance.save()) {
							
							flash.message = "Details Saved"
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
	          	            activityRecInstance.status = "Hazardeous Waste Application "+params.appId+ " Nature and quantity of different commonly recyclable Details Save."	
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
							recyclableHazardousInstance.errors.each { println it}
							flash.message = "Error occurs..Try Again"
						}
					}
					redirect(action:popRecyclableHazardousWasteAdd,id:params.appId)
			        return
				
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
	
	def popDeleteDoc = {
			 try {
				    
			    	def app =HazardeousWasteAuthApp.get((params.id).toInteger())
			    	def docList = DocumentChecklistMaster.list()
			    	def listDoc= new ArrayList()


			        def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='Uploded Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])

			    		
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
	  			    activityRecInstance.status = "Hazardeous Waste Application "+params.id+ " Delete Saved Documents Click"
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
				    
					
			     def app = HazardeousWasteAuthApp.get((params.indAppId).toLong())
			        	
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
				    activityRecInstance.status = "Hazardeous Waste Application "+params.indAppId+ " Document Delete."
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
					    	println it
					  }
				  } 
			        	redirect(action:popDeleteDoc,id:app)
			        
					
					
					

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
	  def popUploadDocNewFormat = 
      {
			 try {
				    
			  	    def app = HazardeousWasteAuthApp.get((params.id).toInteger())
			  	    def certFor="hwm"  
						def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=? order by abc.id asc",[certFor])
							
					    def listDoc= new ArrayList()
			  	    def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='Uploded Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
					    for(int ig=0;ig<applicationDocumentInstance.size();ig++)
					       {
						     	  def boolCheck=false
						     	  if(listDoc.size()==0)
						     	  {
						     			listDoc.add(applicationDocumentInstance.get(ig))
						     	  }
						     	
						     	  for(int intCheck=0;intCheck<listDoc.size();intCheck++)
						     	  {
						     		  if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description)
						     		  {
						     			  boolCheck=true
						     		  }
						     	  }
						     	
						     	  if(boolCheck==false)
						     	  {
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
	   			    activityRecInstance.status = "Hazardeous Waste Application "+params.id+ " Upload Required Documents Click"
	   	            if(activityRecInstance.save()){		   
	   	              }
	   	            	else{
	   	            		activityRecInstance.errors.each {
	   				    	println it
	   				  }
	   			  }
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
	
	def saveDocsNewFormat={
			 try {
				    
					
					def app = HazardeousWasteAuthApp.get((params.indAppId).toLong())
			    	
			    	def apliId = app.id
				
				 def appType="new"
				 def certFor="hwm"  
					 def extn
				    	def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.indAppId )
						
						def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
						def indRegInstanceId=indRegInstance.id
						def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=? and abc.consentFor=? order by abc.id asc",[certFor,appType])
			   MultipartFile multi
			        for(int i=0;i<docList.size();i++){

			            def file = new WasteManagementFile()
			        	def f = request.getFile((docList.get(i)).document)
			        	
			        	if(f){
			        		if(!f.empty)
			        		{

			        	multi = request.getFile( (docList.get(i)).document)
			        	
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description=docList.get(i)
							if(session.userMaster){
								file.createdBy=session.userMaster
								file.updatedBy=session.userMaster
							}else {
								file.createdBy=session.indUser
								file.updatedBy=session.indUser
						    }
			        	    file.typeOfFile="Uploded Documents"
							file.indreg=indRegInstanceGet
							file.applicationId=apliId
							file.applicationFor="HWM"
								  if(file.save()) {
					                	 flash.message="Documents Uploaded Successfully"	                	
					                	
					                }
					                else {
					        	          file.errors.each {
					        			        println it
					        			   }
					        	        
					        	        }
					        	        } }
					            	
					            	 render(view: 'saveDocsNewFormat', model: [app:app])

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
	    			    activityRecInstance.status = "Hazardeous Waste Application "+params.indAppId+ " Document Uploaded."
	    	         if(activityRecInstance.save()){		   
	    	           }
	    	         	else{
	    	         		activityRecInstance.errors.each {
	    				    	println it
	    				  }
	    			  }
					    	 render(view: 'saveDocsNewFormat', model: [app:app])

					            
					            	
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
	
	   def saveMoreDocsNewFormat = {
			 try {
				    
					

					
					def app = HazardeousWasteAuthApp.get((params.app).toLong())
			    	def apliId = app.id
			    	def extn
			    	def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.app )
			    	def appType="hwm"
				    def certFor="new"
					
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
			    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=? and abc.consentFor=? order by abc.id asc",[appType,certFor])
			    	boolean redoc = false
			    	def applicationProcessingDetails = WasteManagementPendingDetails.find("from WasteManagementPendingDetails indPower where indPower.applicationId=? order by indPower.applicationId desc",[apliId.toString()])
							if(applicationProcessingDetails){
								if(applicationProcessingDetails.applicationStatus=="returned"){
									redoc = true
								}
								}
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
						file.typeOfFile="Uploded Documents"
						file.indreg=indRegInstanceGet
						if(redoc==true){
	    					file.resubmittedDoc = true
			        	}
						file.applicationId=apliId
						file.applicationFor="HWM"          	
			              if(file.save()) {

			                	 flash.message="Document Uploaded Successfully"
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
		    	          		   activityRecInstance.status = "Hazardeous Waste Application "+params.app+ " Add More Document Uploaded."
		    	                   if(activityRecInstance.save()){		   
		    	                     }
		    	                   	else{
		    	                   		activityRecInstance.errors.each {
		    	          			    	println it
		    	          			  }
		    	          		  }
			            	  render(view: 'saveDocsNewFormat', model: [app: app])
			      	       }else{

			      	       }
			               
			          	}		
			        	else {

			       	    	   flash.message="Please Upload document"
			       	          render(view: 'saveDocsNewFormat', model: [app: app,other:params.other])
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
	def viewFileNewFormat = {
			 try {
				    
					def docId = params.docId
					def industryId = session.indUser
					def wasteManagementFileInstance = WasteManagementFile.findById( params.docId.toLong())
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
		            activityRecInstance.status = "Hazardous Waste Application No- ${wasteManagementFileInstance.applicationId} Document ${wasteManagementFileInstance.typeOfFile} Downloaded."
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
		    		    	println it
		    		  }
		    	  }
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=\""+wasteManagementFileInstance.name+"\"")
					response.getOutputStream() << new ByteArrayInputStream( wasteManagementFileInstance.data )
				
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

	def saveNewFormat={
			 try {
				    println("params----"+params)
				    def editMode = params.editMode
				    println("editMode----"+editMode)
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
					//////////field removed by issuedBy,passNo,registerRecyclerDetails
					def industryId = session.indUser
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=indUserInstance.industryRegMaster
					if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def hazardeousWasteAuthAppInstance =	HazardeousWasteAuthApp.get((params.indAppDetId).toLong())
					
			        SimpleDateFormat formatNowYear = new SimpleDateFormat("dd/MM/yyyy");
					def status = params.progress_Status
					hazardeousWasteAuthAppInstance.properties=params
					hazardeousWasteAuthAppInstance.clarification=false
					if(params.recycleHazard){
					hazardeousWasteAuthAppInstance.recycleHazard=params.recycleHazard
					}else{
						hazardeousWasteAuthAppInstance.recycleHazard=""
					}
					hazardeousWasteAuthAppInstance.regDate = new Date()
					hazardeousWasteAuthAppInstance.expDate = new Date()
					hazardeousWasteAuthAppInstance.passNo = ""
					hazardeousWasteAuthAppInstance.authorQty = ""
					hazardeousWasteAuthAppInstance.issuedBy = ""
					hazardeousWasteAuthAppInstance.inspection=false
					hazardeousWasteAuthAppInstance.isNewApplication=true
					hazardeousWasteAuthAppInstance.Auhorisation_status=""
					hazardeousWasteAuthAppInstance.isHandlerGenerator="Yes"
					hazardeousWasteAuthAppInstance.industrywork=params.industrywork
					hazardeousWasteAuthAppInstance.registerRecyclerDetails=""
					if(params.impHazard){
					hazardeousWasteAuthAppInstance.impHazard=params.impHazard
					}else{
						hazardeousWasteAuthAppInstance.impHazard=""
					}
					hazardeousWasteAuthAppInstance.hazardChemicalRules=""
					hazardeousWasteAuthAppInstance.insurance_act=""
					hazardeousWasteAuthAppInstance.handlingQuantity=""
					hazardeousWasteAuthAppInstance.importingHazardChemicals=""
					hazardeousWasteAuthAppInstance.storageDisposalFacility=""
					
					String authReqFor=""
					if(params['chkGeneration']=="on") {
						authReqFor=authReqFor.concat("Generation")
						authReqFor=authReqFor.concat(",")
					}
			        if(params['chkCollection']=="on") {
						authReqFor=authReqFor.concat("Collection")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkStorage']=="on") {
						authReqFor=authReqFor.concat("Storage")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkTransportation']=="on") {
						authReqFor=authReqFor.concat("Transportation")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkReception']=="on") {
						authReqFor=authReqFor.concat("Reception")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkReuse']=="on") {
						authReqFor=authReqFor.concat("Reuse")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkRecycling']=="on") {
						authReqFor=authReqFor.concat("Recycling")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkRecovery']=="on") {
						authReqFor=authReqFor.concat("Recovery")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkPre-processing']=="on") {
						authReqFor=authReqFor.concat("Pre-processing")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkCo-processing']=="on") {
						authReqFor=authReqFor.concat("Co-processing")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkUtilisation']=="on") {
						authReqFor=authReqFor.concat("Utilisation")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkTreatment']=="on") {
						authReqFor=authReqFor.concat("Treatment")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkDisposal']=="on") {
						authReqFor=authReqFor.concat("Disposal")
						authReqFor=authReqFor.concat(",")
					}
					if(params['chkIncineration']=="on") {
						authReqFor=authReqFor.concat("Incineration")
						authReqFor=authReqFor.concat(",")
					}
					
					if(authReqFor.length()>0)
					{
						authReqFor = authReqFor.substring(0, authReqFor.length() - 1);	
					}
					
					hazardeousWasteAuthAppInstance.authorization_Required_For=authReqFor
					hazardeousWasteAuthAppInstance.applicationStatus="Inprogress"
					hazardeousWasteAuthAppInstance.is_Renew=params.is_Renew
					if(params.auth_Renew_No){
						hazardeousWasteAuthAppInstance.auth_Renew_No =params.auth_Renew_No
					}else{
						hazardeousWasteAuthAppInstance.auth_Renew_No=""
					}
			      
					if(hazardeousWasteAuthAppInstance.is_Renew=="Renew") 
					{
						hazardeousWasteAuthAppInstance.auth_Renew_No=(params.auth_Renew_No)
						def dateCheck=params.auth_Renew_Date_value
						def x
						def sqlCurrentDate
						def currentDate=new Date()
						DateCustom dd=new DateCustom()
						sqlCurrentDate=dd.sQLdate(currentDate)
						if(dateCheck) {
							
							x= formatNowYear.parse(dateCheck);
							hazardeousWasteAuthAppInstance.auth_Renew_Date=x
						}
					}
					
					if(params.recycleHazard=="YES") 
					{
						def dateCheck=params.regDate_value
						def x
						def sqlCurrentDate
						def currentDate=new Date()
						DateCustom dd=new DateCustom()
						sqlCurrentDate=dd.sQLdate(currentDate)
						if(dateCheck) 
						{
							
							x= formatNowYear.parse(dateCheck);
							hazardeousWasteAuthAppInstance.regDate=x
						}
					}

					if(params.recycleHazard=="YES") 
					{
						def dateCheck=params.expDate_value
						def x
						def sqlCurrentDate
						def currentDate=new Date()
						DateCustom dd=new DateCustom()
						sqlCurrentDate=dd.sQLdate(currentDate)
						if(dateCheck)
						{
							
							x= formatNowYear.parse(dateCheck);
							hazardeousWasteAuthAppInstance.expDate=x
						}
					}
					
			        hazardeousWasteAuthAppInstance.industryRegMasterObj=indRegInstance
					hazardeousWasteAuthAppInstance.createdBy=indRegInstance.indName
					def date = new Date();
					def t = formatNowYear.format(date)
					def indUserID = industryId.industryRegMaster
				    def hazardeousWasteAuthAppInstanceList = HazardeousWasteAuthApp.findAllWhere(industryRegMasterObj:indUserID,completionStatus:'Completed')
					

					
//////////////////////			/shashank code start/////////////////////////////////
			        def consentFeeMasterInstance = new ConsentFeeMasterHWM()
					
					def calculatedfee = ConsentFeeMasterHWM.findByApplication(hazardeousWasteAuthAppInstance)
					
					if(calculatedfee){
						
						calculatedfee.delete()
						
					}
					consentFeeMasterInstance.application = hazardeousWasteAuthAppInstance
					if(params.yearsApplied != ""){
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
					consentFeeMasterInstance.save()
					//////////////////////////shashank code end/////////////////////////
					
			if(!hazardeousWasteAuthAppInstance.hasErrors() && hazardeousWasteAuthAppInstance.save()) 
			{

				        if(status.equals("Completed"))
						{
				            def FeeBankDetailsHWMobj=FeeBankOtherDetailsHWM.findAll("from FeeBankOtherDetailsHWM abc where abc.application=?",[hazardeousWasteAuthAppInstance]);
				
				 		 /*   if(!FeeBankDetailsHWMobj){		
				 			flash.message = "Please enter Bank fee Detail"
				 			redirect(action:editNewFormat,params:[indAppDetId:hazardeousWasteAuthAppInstance.id])
				 		    return;
				 		     }*/
				        	
				        	
							def HazardousWasteDetailsObj=HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM abc where abc.application=?",[hazardeousWasteAuthAppInstance]);
							if(!HazardousWasteDetailsObj){	
									flash.message = "Please enter Hazardous Waste Generation Details"
									hazardeousWasteAuthAppInstance.completionStatus = "Inprogress"
									hazardeousWasteAuthAppInstance.save(flush:true)	
								    redirect(action:editNewFormat,params:[indAppDetId:hazardeousWasteAuthAppInstance.id])
								    return;
								}


							def dcCkeck
							ArrayList strList = new ArrayList()
							dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor='hwm'")
                          //  println("dcCkeck---HWM----Deewpak----"+dcCkeck)
						    for(int i=0;i<dcCkeck.size();i++)
							{
								if(((dcCkeck.get(i)).isMandatory).equalsIgnoreCase("Yes"))
								{
									def isOrNot = WasteManagementFile.find("from WasteManagementFile abc where abc.description=? and abc.applicationId=?",[(dcCkeck.get(i)).document,hazardeousWasteAuthAppInstance.id])
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
								hazardeousWasteAuthAppInstance.completionStatus = "Inprogress"
								hazardeousWasteAuthAppInstance.save(flush:true)	
								redirect(action:editNewFormat,params:[indAppDetId:hazardeousWasteAuthAppInstance.id])
								return ;
							}
					   }
					
					    
					    
					    def listDoc= new ArrayList()
					    def docListDocumentChecklistMaster = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.consentFor='HWA' order by abc.id asc") 
					    def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='Uploded Documents' and apd.applicationId=? order by apd.id asc",[hazardeousWasteAuthAppInstance.id.toLong()])
				    	
				    	for(int ig=0;ig<applicationDocumentInstance.size();ig++)
				    	{
				    		def boolCheck=false
				    		if(listDoc.size()==0)
				    		{
				    			listDoc.add(applicationDocumentInstance.get(ig).description)
				    		}
				    		for(int intCheck=0;intCheck<listDoc.size();intCheck++)
				    		{
				    			if(listDoc[intCheck]==(applicationDocumentInstance.get(ig).description))
				    			{
				    				boolCheck=true
				    			}
				    		}
				    		if(boolCheck==false)
				    		{
				    			listDoc.add(applicationDocumentInstance.get(ig).description)
				    		}
				    	}
					    
					    def listDocuments1 =  new LinkedHashSet<String>()
			    		for(int intCheck=0;intCheck<docListDocumentChecklistMaster.size();intCheck++)
			    		{
			    			if(listDoc.contains(docListDocumentChecklistMaster[intCheck].documentType))
			    			{
			    				listDocuments1.add(docListDocumentChecklistMaster[intCheck].documentType)
			    			}
			    		}
					    listDocuments1.addAll(listDoc)
					    
					    def listDocuments=new ArrayList();
					    listDocuments.addAll(listDocuments1);
					    
				
						///////////??????? new values for new format
						def isGeneratorHWA=hazardeousWasteAuthAppInstance.isGenerator  
			def prodManufactured=hazardeousWasteAuthAppInstance.prouctsManufactured
			def prodsManufactured=hazardeousWasteAuthAppInstance.prouctsManufactured
			def genWastes=hazardeousWasteAuthAppInstance.generatedWastes
			def isTSDFOper=hazardeousWasteAuthAppInstance.isTSDFOperator
			def generatedWast=hazardeousWasteAuthAppInstance.generatedWastes
			def strgeCapacity=hazardeousWasteAuthAppInstance.storageCapacity
			def trtmntProcesses=hazardeousWasteAuthAppInstance.treatmentProcesses
			def secdLandfills=hazardeousWasteAuthAppInstance.securedLandfills 
			def detailOfIncine=hazardeousWasteAuthAppInstance.detailOfIncineration         
			def trtmntSystem=hazardeousWasteAuthAppInstance.treatmentSystem        
			def fireFightSystems=hazardeousWasteAuthAppInstance.fireFightingSystems 
			def environmentalMgtPlan=hazardeousWasteAuthAppInstance.environmentalManagementPlan
			def transp=hazardeousWasteAuthAppInstance.transportation
			def otherActvs=hazardeousWasteAuthAppInstance.otherActivities
			def isRecyclerOrUsr=hazardeousWasteAuthAppInstance.isRecyclerOrUsers 
			def securedStrge=hazardeousWasteAuthAppInstance.securedStorage
			def endUsrs=hazardeousWasteAuthAppInstance.endUsers
			def pollutionContrlSys=hazardeousWasteAuthAppInstance.pollutionControlSystems
			def saftyMeasures=hazardeousWasteAuthAppInstance.safetyMeasures
			def complianceWithLines=hazardeousWasteAuthAppInstance.complianceWithGuidelines
			def transportationUsrs=hazardeousWasteAuthAppInstance.transportationUsers

			def recyclableHazardousWasteHWM = new ArrayList()
		    def recyclableHazardousWasteHWMList = RecyclableHazardousWasteHWM.findAll("from RecyclableHazardousWasteHWM s where s.application=? order by id asc",[hazardeousWasteAuthAppInstance])
		    for(int var181=0;var181<recyclableHazardousWasteHWMList.size();var181++)
		      {
			 def recyclableHazardousWasteHWMInstanceList= new ArrayList()
			 recyclableHazardousWasteHWMInstanceList.add(recyclableHazardousWasteHWMList.get(var181).hazardousWasteType)
			 recyclableHazardousWasteHWMInstanceList.add(recyclableHazardousWasteHWMList.get(var181).quantity +" "+recyclableHazardousWasteHWMList.get(var181).quantityUnit)
			 recyclableHazardousWasteHWMInstanceList.add(recyclableHazardousWasteHWMList.get(var181).source)
			 recyclableHazardousWasteHWM.add(recyclableHazardousWasteHWMInstanceList)
		     }	
			
			def characteristicsDetails = new ArrayList()	
		    def characteristicsAndManagementInstList=CharacteristicsAndManagementHWM.findAll("from CharacteristicsAndManagementHWM charachter where charachter.application=? ",[hazardeousWasteAuthAppInstance]);
		    for(int var394=0;var394<characteristicsAndManagementInstList.size();var394++)
		    {
		   	     def characteristicsDetailsList= new ArrayList()
		   	     println("AAA--"+characteristicsAndManagementInstList.get(var394).wasteDetails.id);
		   	     def hazardousWasteDetailsList = HazardousWasteDetailsHWM.find("from HazardousWasteDetailsHWM s where s.id=?",[characteristicsAndManagementInstList.get(var394).wasteDetails.id])
				       println("BBB--"+hazardousWasteDetailsList);
				       characteristicsDetailsList.add(hazardousWasteDetailsList.source.schedule);
		               characteristicsDetailsList.add(hazardousWasteDetailsList.source.name);
		               characteristicsDetailsList.add(hazardousWasteDetailsList.category.name);
		               characteristicsDetailsList.add(hazardousWasteDetailsList.quantity+" "+hazardousWasteDetailsList.quantityUnit);
		 	           characteristicsDetailsList.add(characteristicsAndManagementInstList.get(var394).characterisitics);
		 	           characteristicsDetailsList.add(characteristicsAndManagementInstList.get(var394).utilization);
		 	           characteristicsDetailsList.add(characteristicsAndManagementInstList.get(var394).ifNotUtilized);
		 	           characteristicsDetailsList.add(characteristicsAndManagementInstList.get(var394).arrangementsForTransportation);
		 	           characteristicsDetailsList.add(characteristicsAndManagementInstList.get(var394).environmentalSafeguards);
			            
			    characteristicsDetails.add(characteristicsDetailsList);
		    }
		    
//		    def safeGuardDetails1=CharacteristicsAndManagementHWM.findAll("from CharacteristicsAndManagementHWM charachter where charachter.application=? ",[hazardeousWasteAuthAppInstance]);
//		    	     println("safeGuardDetails1 "+safeGuardDetails1);
		    	     def safeGuardDetails = "";
		  	    	
		    	   def copyErp="Not Attatched"
		        def underTaking="Not Attatched"
		        def manufacture="Not Attatched"
		        def layoutMapA="Not Attatched"
		        def copyPrior="Not Attatched"
		        def furnishInstall="Not Attatched"
		        def processDescription="Not Attatched"
		        def detailOfHazardous = "Not Attatched"  
		        def renewal = "Not Attatched"     
		        def detailOther = "Not Attatched"     
		        	boolean redoc = false
		        	
		        	if(editMode=="true"){
		        		redoc = true
		        	}
		        	println("redoc-------"+redoc)
		        	def file = new WasteManagementFile()
		        	def emergencyResponsePlan = request.getFile('emergencyResponsePlan');
		    		 
		        	def emergencyResponsePlanDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of the Emergency Response Plan' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
		        	println("WasteManagementFile.find("+"from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of the Emergency Response Plan' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc"+",[hazardeousWasteAuthAppInstance.id])");
		        	if(emergencyResponsePlan!=null)
		        	{

		        	    if(!emergencyResponsePlan.empty) 
		        	     {	
		        	        
		        	    	
		        	    	if(emergencyResponsePlanDoc){
		        	    		println(" inside ## ifff emergencyResponsePlanDoc ")
		        	    		def emergencyResponsePlanDocInstance = emergencyResponsePlanDoc[0]
		        	        	if(emergencyResponsePlanDocInstance){
		        	        		println(" inside ## ifff emergencyResponsePlanDocInstance ")
		        	        		emergencyResponsePlanDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('emergencyResponsePlan')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Copy of the Emergency Response Plan"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			if(file.save(flush:true) )
		        			{
		        				
		        			}
		        			else{
		        				if(file.hasErrors()){
		        					file.errors.allErrors.each {
				             	  println it
				             	  }
				             	  } 
		        			}
		        			copyErp = "Attached"
		        	    	
		        	     }
		        	}
		        	
		        	def emergencyResponsePlanDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of the Emergency Response Plan' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(emergencyResponsePlanDoc1){
		        		copyErp = "Attached"
		    		}
		        	/******2.Provide undertaking or declaration***************/
		        	file = new WasteManagementFile()
		        	def undertakingOrDeclaration = request.getFile('undertakingOrDeclaration');
		        	def undertakingOrDeclarationDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Undertaking or declaration to comply' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	if(undertakingOrDeclaration!=null)
		        	{

		        	    if(!undertakingOrDeclaration.empty) 
		        	     {
		        	    	
		        	    	if(undertakingOrDeclarationDoc){
		        	    		println(" inside ## ifff undertakingOrDeclarationDoc ")
		        	    		def undertakingOrDeclarationDocInstance = undertakingOrDeclarationDoc[0]
		        	        	if(undertakingOrDeclarationDocInstance){
		        	        		println(" inside ## ifff undertakingOrDeclarationDocInstance ")
		        	        		undertakingOrDeclarationDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('undertakingOrDeclaration')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Undertaking or declaration to comply"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        			underTaking = "Attached"
		        	     }
		        	}
		        	def undertakingOrDeclarationDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Undertaking or declaration to comply' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(undertakingOrDeclarationDoc1){
		    			underTaking = "Attached"
		    		}
		        	/******3.Attatch Safe Guards***************/
		    		file = new WasteManagementFile()
		        	def manufacturingProcess_new = request.getFile('manufacturingProcess_new');
		    		def manufacturingProcess_newDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Manufacturing process with flow sheet' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	
		        	
		        	if(manufacturingProcess_new!=null)
		        	{

		        	    if(!manufacturingProcess_new.empty) 
		        	     {
		        	        
		        	    	if(manufacturingProcess_newDoc){
		        	    		println(" inside ## ifff manufacturingProcess_newDoc ")
		        	    		def manufacturingProcess_newDocInstance = manufacturingProcess_newDoc[0]
		        	        	if(manufacturingProcess_newDocInstance){
		        	        		println(" inside ## ifff manufacturingProcess_newDocInstance ")
		        	        		manufacturingProcess_newDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('manufacturingProcess_new')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Manufacturing process with flow sheet"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        			manufacture = "Attached"
		        	     }
		        	}
		        	
		        	def manufacturingProcess_newDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Manufacturing process with flow sheet' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(manufacturingProcess_newDoc1){
		        		manufacture = "Attached"
		    		}
		        
		        	/******4.Layout map of the TSDF ***************/
		        	file = new WasteManagementFile()
		        	def layoutMap = request.getFile('layoutMap');
		        	def layoutMapDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Layout map of the TSDF' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	
		        	if(layoutMap!=null)
		        	{

		        	    if(!layoutMap.empty) 
		        	     {
		        	        
		        	    	if(layoutMapDoc){
		        	    		println(" inside ## ifff layoutMapDoc ")
		        	    		def layoutMapDocInstance = layoutMapDoc[0]
		        	        	if(layoutMapDocInstance){
		        	        		println(" inside ## ifff layoutMapDocInstance ")
		        	        		layoutMapDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	
		        	    	MultipartFile multi = request.getFile('layoutMap')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Layout map of the TSDF"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        			layoutMapA = "Attached"
		        	     }
		        	}
		        	
		        	def layoutMapDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Layout map of the TSDF' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(layoutMapDoc1){
		        		layoutMapA = "Attached"
		    		}
		        
		        	/******5.Copy of prior Environmental Clearance***************/
		        	file = new WasteManagementFile()
		        	def priorEnv = request.getFile('priorEnv');
		        	
		        	def priorEnvDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of prior Environmental Clearance' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	if(priorEnv!=null)
		        	{

		        	    if(!priorEnv.empty) 
		        	     {
		        	        
		        	    	if(priorEnvDoc){
		        	    		println(" inside ## ifff priorEnvDoc ")
		        	    		def priorEnvDocInstance = priorEnvDoc[0]
		        	        	if(priorEnvDocInstance){
		        	        		println(" inside ## ifff priorEnvDocInstance ")
		        	        		priorEnvDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('priorEnv')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Copy of prior Environmental Clearance"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        			copyPrior="Attatched"
		        	     }
		        	}
		        	
		        	def priorEnvDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of prior Environmental Clearance' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(priorEnvDoc1){
		        		copyPrior = "Attached"
		    		}
		        
		        	
		        	/******6.Furnish installed capacity as per registration***************/
		        	file = new WasteManagementFile()
		        	def furnishInstalledCapacity = request.getFile('furnishInstalledCapacity');
		        	def furnishInstalledCapacityDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Furnish installed capacity as per registration' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	if(furnishInstalledCapacity!=null)
		        	{

		        	    if(!furnishInstalledCapacity.empty) 
		        	     {
		        	        
		        	    	if(furnishInstalledCapacityDoc){
		        	    		println(" inside ## ifff furnishInstalledCapacityDoc ")
		        	    		def furnishInstalledCapacityDocInstance = furnishInstalledCapacityDoc[0]
		        	        	if(furnishInstalledCapacityDocInstance){
		        	        		println(" inside ## ifff furnishInstalledCapacityDocInstance ")
		        	        		furnishInstalledCapacityDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('furnishInstalledCapacity')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Furnish installed capacity as per registration"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        		    furnishInstall="Attatched"
		        	     }
		        	}
		        	
		        	def furnishInstalledCapacityDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Furnish installed capacity as per registration' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(furnishInstalledCapacityDoc1){
		        		furnishInstall = "Attached"
		    		}
		        
		        	/******7.Process description including process flow sheet***************/
		        	file = new WasteManagementFile()
		        	def processDescriptionIncluding = request.getFile('processDescriptionIncluding');
		        	def processDescriptionIncludingDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Process description including process flow sheet' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	if(processDescriptionIncluding!=null)
		        	{

		        	    if(!processDescriptionIncluding.empty) 
		        	     {
		        	        
		        	    	if(processDescriptionIncludingDoc){
		        	    		println(" inside ## ifff processDescriptionIncludingDoc ")
		        	    		def processDescriptionIncludingDocInstance = processDescriptionIncludingDoc[0]
		        	        	if(processDescriptionIncludingDocInstance){
		        	        		println(" inside ## ifff processDescriptionIncludingDocInstance ")
		        	        		processDescriptionIncludingDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	MultipartFile multi = request.getFile('processDescriptionIncluding')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Process description including process flow sheet"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        		    processDescription="Attatched"
		        	     }
		        	}
		        	
		        	def processDescriptionIncludingDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Process description including process flow sheet' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(processDescriptionIncludingDoc1){
		        		processDescription = "Attached"
		    		}
		        
		        	/******8.Detail of Hazardous Waste with Name/ Category and Quantity(Ton/year) to be Co-Processed in Cement Kiln(If Applicable)***************/
		        	file = new WasteManagementFile()
		        	def detailOfHazardousWithIn = request.getFile('detailOfHazardousWithIn');
		        	def detailOfHazardousWithInDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Detail of Hazardous Waste with Name' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
		        	
		        	if(detailOfHazardousWithIn!=null)
		        	{

		        	    if(!detailOfHazardousWithIn.empty) 
		        	     {
		        	        
		        	    	if(detailOfHazardousWithInDoc){
		        	    		println(" inside ## ifff detailOfHazardousWithInDoc ")
		        	    		def detailOfHazardousWithInDocInstance = detailOfHazardousWithInDoc[0]
		        	        	if(detailOfHazardousWithInDocInstance){
		        	        		println(" inside ## ifff detailOfHazardousWithInDocInstance ")
		        	        		detailOfHazardousWithInDocInstance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('detailOfHazardousWithIn')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Detail of Hazardous Waste with Name"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			file.save(flush:true)
		        		    detailOfHazardous = "Attatched"
		        	     }
		        	}
		        	def detailOfHazardousWithInDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Detail of Hazardous Waste with Name' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(detailOfHazardousWithInDoc1){
		        		detailOfHazardous = "Attached"
		    		}
		        	/******9.Detail of Renewal Doc***************/
			        
		        	 file = new WasteManagementFile()
		        	def renewalDoc = request.getFile('renewalDoc');
		    		 
		        	def renewalDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='renewal of Authorisation' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
		        	
		        	if(renewalDoc!=null)
		        	{

		        	    if(!renewalDoc.empty) 
		        	     {	
		        	        
		        	    	
		        	    	if(renewalDoc1){
		        	    		println(" inside ## ifff renewalDoc1 ")
		        	    		def renewalDoc1Instance = renewalDoc1[0]
		        	        	if(renewalDoc1Instance){
		        	        		println(" inside ## ifff renewalDoc1 ")
		        	        		renewalDoc1Instance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('renewalDoc')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="renewal of Authorisation"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			if(file.save(flush:true) )
		        			{
		        				
		        			}
		        			else{
		        				if(file.hasErrors()){
		        					file.errors.allErrors.each {
				             	  println it
				             	  }
				             	  } 
		        			}
		        	    	renewal = "Attached"
		        	    	
		        	     }
		        	}
		        	
		        	def renewalDocDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='renewal of Authorisation' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(renewalDocDoc1){
		        		renewal = "Attached"
		    		}
		        	
		        	
		        	
		        	/******10. Details of any other activities Doc***************/
			        
		        	 file = new WasteManagementFile()
		        	def anyOtherActivitiesDoc = request.getFile('anyOtherActivities');
		    		 
		        	def anyOtherActivitiesDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of any other activities' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
		        	
		        	if(anyOtherActivitiesDoc!=null)
		        	{

		        	    if(!anyOtherActivitiesDoc.empty) 
		        	     {	
		        	        
		        	    	
		        	    	if(anyOtherActivitiesDoc1){
		        	    		println(" inside ## ifff anyOtherActivitiesDoc1 ")
		        	    		def anyOtherActivitiesDoc1Instance = anyOtherActivitiesDoc1[0]
		        	        	if(anyOtherActivitiesDoc1Instance){
		        	        		println(" inside ## ifff anyOtherActivitiesDoc1Instance ")
		        	        		anyOtherActivitiesDoc1Instance.delete()
		        	        		println(" instance deleted successfully ")
		        	        	}
		        	    	}
		        	    	
		        	    	MultipartFile multi = request.getFile('anyOtherActivities')
		        			file.size = multi.getSize() / 1024
		    				file.name =multi.getOriginalFilename()
		    				file.data=multi.getBytes() 
		    				file.extension = extractExtension( multi )
		    				file.description="Details of any other activities"
		    				file.createdBy=session.indUser
		    				file.updatedBy=session.indUser
		    				file.typeOfFile="Application Document"
		    				file.indreg=indRegInstance
		    				if(redoc==true){
		    					file.resubmittedDoc = true
				        	}
		    				file.applicationId=hazardeousWasteAuthAppInstance.id
		    				file.applicationFor="HWM"
		        			if(file.save(flush:true) )
		        			{
		        				
		        			}
		        			else{
		        				if(file.hasErrors()){
		        					file.errors.allErrors.each {
				             	  println it
				             	  }
				             	  } 
		        			}
		        	    	detailOther = "Attached"
		        	    	
		        	     }
		        	}
		        	
		        	def anyOtherActivities1Doc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of any other activities' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
		        	if(anyOtherActivities1Doc1){
		        		detailOther = "Attached"
		    		}
		        	
		        	/******11. Details of secured storage of wastes Doc***************/
				       def  detailSecured = "Not Attached"
			        	 file = new WasteManagementFile()
			        	def detailSecuredStorageDoc = request.getFile('detailSecuredStorage');
			    		 
			        	def detailSecuredStorageDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of secured storage of wastes' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
			        	
			        	if(detailSecuredStorageDoc!=null)
			        	{

			        	    if(!detailSecuredStorageDoc.empty) 
			        	     {	
			        	        
			        	    	
			        	    	if(detailSecuredStorageDoc1){
			        	    		println(detailSecuredStorageDoc1)
			        	    		def detailSecuredStorageDoc1Instance = detailSecuredStorageDoc1[0]
			        	        	if(detailSecuredStorageDoc1Instance){
			        	        		println(" inside ## ifff detailSecuredStorageDoc1Instance ")
			        	        		detailSecuredStorageDoc1Instance.delete()
			        	        		println(" instance deleted successfully ")
			        	        	}
			        	    	}
			        	    	
			        	    	MultipartFile multi = request.getFile('detailSecuredStorage')
			        			file.size = multi.getSize() / 1024
			    				file.name =multi.getOriginalFilename()
			    				file.data=multi.getBytes() 
			    				file.extension = extractExtension( multi )
			    				file.description="Details of secured storage of wastes"
			    				file.createdBy=session.indUser
			    				file.updatedBy=session.indUser
			    				file.typeOfFile="Application Document"
			    				file.indreg=indRegInstance
			    				if(redoc==true){
			    					file.resubmittedDoc = true
					        	}
			    				file.applicationId=hazardeousWasteAuthAppInstance.id
			    				file.applicationFor="HWM"
			        			if(file.save(flush:true) )
			        			{
			        				
			        			}
			        			else{
			        				if(file.hasErrors()){
			        					file.errors.allErrors.each {
					             	  println it
					             	  }
					             	  } 
			        			}
			        	    	detailSecured = "Attached"
			        	    	
			        	     }
			        	}
			        	
			        	def detailSecuredDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of secured storage of wastes' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
			        	if(detailSecuredDoc1){
			        		detailSecured = "Attached"
			    		}
			        	
			        	/******12. Details of end users of products Doc***************/
					       def  detailsEnd = "Not Attached"
				        	 file = new WasteManagementFile()
				        	def detailsEndUsersDoc = request.getFile('detailsEndUsers');
				    		 
				        	def detailsEndUsersDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of end users of products' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
				        	
				        	if(detailsEndUsersDoc!=null)
				        	{

				        	    if(!detailsEndUsersDoc.empty) 
				        	     {	
				        	        
				        	    	
				        	    	if(detailsEndUsersDoc1){
				        	    		println(detailsEndUsersDoc1)
				        	    		def detailsEndUsersDoc1Instance = detailsEndUsersDoc1[0]
				        	        	if(detailsEndUsersDoc1Instance){
				        	        		println(" inside ## ifff detailsEndUsersDoc1Instance ")
				        	        		detailsEndUsersDoc1Instance.delete()
				        	        		println(" instance deleted successfully ")
				        	        	}
				        	    	}
				        	    	
				        	    	MultipartFile multi = request.getFile('detailsEndUsers')
				        			file.size = multi.getSize() / 1024
				    				file.name =multi.getOriginalFilename()
				    				file.data=multi.getBytes() 
				    				file.extension = extractExtension( multi )
				    				file.description="Details of end users of products"
				    				file.createdBy=session.indUser
				    				file.updatedBy=session.indUser
				    				file.typeOfFile="Application Document"
				    				file.indreg=indRegInstance
				    				if(redoc==true){
				    					file.resubmittedDoc = true
						        	}
				    				file.applicationId=hazardeousWasteAuthAppInstance.id
				    				file.applicationFor="HWM"
				        			if(file.save(flush:true) )
				        			{
				        				
				        			}
				        			else{
				        				if(file.hasErrors()){
				        					file.errors.allErrors.each {
						             	  println it
						             	  }
						             	  } 
				        			}
				        	    	detailsEnd = "Attached"
				        	    	
				        	     }
				        	}
				        	
				        	def detailsEndDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of end users of products' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
				        	if(detailsEndDoc1){
				        		detailsEnd = "Attached"
				    		}
				        	
				        	/******13. Details of pollution control systems Doc***************/
						       def  detailsPollution = "Not Attached"
					        	 file = new WasteManagementFile()
					        	def detailsOfPollutionDoc = request.getFile('detailsOfPollution');
					    		 
					        	def detailsOfPollutionDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of pollution control systems' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
					        	
					        	if(detailsOfPollutionDoc!=null)
					        	{

					        	    if(!detailsOfPollutionDoc.empty) 
					        	     {	
					        	        
					        	    	
					        	    	if(detailsOfPollutionDoc1){
					        	    		println(detailsOfPollutionDoc1)
					        	    		def detailsOfPollutionDoc1Instance = detailsOfPollutionDoc1[0]
					        	        	if(detailsOfPollutionDoc1Instance){
					        	        		println(" inside ## ifff detailsOfPollutionDoc1Instance ")
					        	        		detailsOfPollutionDoc1Instance.delete()
					        	        		println(" instance deleted successfully ")
					        	        	}
					        	    	}
					        	    	
					        	    	MultipartFile multi = request.getFile('detailsOfPollution')
					        			file.size = multi.getSize() / 1024
					    				file.name =multi.getOriginalFilename()
					    				file.data=multi.getBytes() 
					    				file.extension = extractExtension( multi )
					    				file.description="Details of pollution control systems"
					    				file.createdBy=session.indUser
					    				file.updatedBy=session.indUser
					    				file.typeOfFile="Application Document"
					    				file.indreg=indRegInstance
					    				if(redoc==true){
					    					file.resubmittedDoc = true
							        	}
					    				file.applicationId=hazardeousWasteAuthAppInstance.id
					    				file.applicationFor="HWM"
					        			if(file.save(flush:true) )
					        			{
					        				
					        			}
					        			else{
					        				if(file.hasErrors()){
					        					file.errors.allErrors.each {
							             	  println it
							             	  }
							             	  } 
					        			}
					        	    	detailsPollution = "Attached"
					        	    	
					        	     }
					        	}
					        	
					        	def detailsPollutionDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of pollution control systems' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
					        	if(detailsPollutionDoc1){
					        		detailsPollution = "Attached"
					    		}
		        	
					        	/******14. Central Pollution Control Board guidelines Doc***************/
							       def  facilitySet = "Not Attached"
						        	 file = new WasteManagementFile()
						        	def facilitySetupDoc = request.getFile('facilitySetup');
						    		 
						        	def facilitySetupDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Central Pollution Control Board guidelines' and abc.applicationId=? and abc.resubmittedDoc="+redoc+" order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);  
						        	
						        	if(facilitySetupDoc!=null)
						        	{

						        	    if(!facilitySetupDoc.empty) 
						        	     {	
						        	        
						        	    	
						        	    	if(facilitySetupDoc1){
						        	    		println(facilitySetupDoc1)
						        	    		def facilitySetupDoc1Instance = facilitySetupDoc1[0]
						        	        	if(facilitySetupDoc1Instance){
						        	        		println(" inside ## ifff facilitySetupDoc1Instance ")
						        	        		facilitySetupDoc1Instance.delete()
						        	        		println(" instance deleted successfully ")
						        	        	}
						        	    	}
						        	    	
						        	    	MultipartFile multi = request.getFile('facilitySetup')
						        			file.size = multi.getSize() / 1024
						    				file.name =multi.getOriginalFilename()
						    				file.data=multi.getBytes() 
						    				file.extension = extractExtension( multi )
						    				file.description="Central Pollution Control Board guidelines"
						    				file.createdBy=session.indUser
						    				file.updatedBy=session.indUser
						    				file.typeOfFile="Application Document"
						    				file.indreg=indRegInstance
						    				if(redoc==true){
						    					file.resubmittedDoc = true
								        	}
						    				file.applicationId=hazardeousWasteAuthAppInstance.id
						    				file.applicationFor="HWM"
						        			if(file.save(flush:true) )
						        			{
						        				
						        			}
						        			else{
						        				if(file.hasErrors()){
						        					file.errors.allErrors.each {
								             	  println it
								             	  }
								             	  } 
						        			}
						        	    	facilitySet = "Attached"
						        	    	
						        	     }
						        	}
						        	
						        	def facilitySetDoc1 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Central Pollution Control Board guidelines' and abc.applicationId=?",[hazardeousWasteAuthAppInstance.id]);
						        	if(facilitySetDoc1){
						        		facilitySet = "Attached"
						    		}
		       ///////////?????????????? new values added 	    
				///////////?????????? for Single Window	    
					  SendSms sms = new SendSms()
		                   def cafUniqueNo=session.cafUniqueNo;
		                   def registration_id=session.registrationId;
		                   def ack_no=hazardeousWasteAuthAppInstance.id;
		                  def industryName11=indRegInstance.indName;
		                   def distName=indRegInstance.district.districtName;
		                   def indus_add=indRegInstance.indAddress;
	   
				//====== For Routing application ==========//	
				if(params.progress_Status=="Completed")
				{
						
						def investCap1 =  hazardeousWasteAuthAppInstance.industryRegMasterObj.indCapInvt
						def indSize
						String office
						def roleNameForpdf
						def grp


			            def indApplInst=hazardeousWasteAuthAppInstance
			            def industryRegMasterInstance=IndustryRegMaster.get(indApplInst.industryRegMasterObj.id)
						
						def fileNoArrayList=new ArrayList()
						def fileNoString
						def fileNoSize
						def fileNoValue
						def fileNo
			    

				
				def applicantName=industryRegMasterInstance.occName
				def indName=industryRegMasterInstance.indName
				def applicantDesignation=industryRegMasterInstance.occDesignation
				if(applicantDesignation.equals("Others")){
					applicantDesignation=(industryRegMasterInstance.otherOccDesignation).toString()
			    }
				def factoryPostalAddress=industryRegMasterInstance.indAddress
				def districtOffice=""
				def industryName=industryRegMasterInstance.indName
				def occupierName=industryRegMasterInstance.occName
				def occupierDesignation=applicantDesignation
				def occupierMobile=industryRegMasterInstance.occMobile
				def occupierEmail=industryRegMasterInstance.occEmail
				def isRenew=hazardeousWasteAuthAppInstance.is_Renew
				def authorizationRequiredFor=hazardeousWasteAuthAppInstance.authorization_Required_For
				def yearOfCommencement=(hazardeousWasteAuthAppInstance.industryRegMasterObj).dateOfComm
				def industrywork=hazardeousWasteAuthAppInstance.industrywork
				
			
    	     
				 def hwPreviousAuthDetails = new ArrayList()	
				 def hwPreviousAuthDetailsList = HWMPreviousAuthorisationDetails.findAll("from HWMPreviousAuthorisationDetails s where s.indUser.id=? and s.wasteManagementFileId!='' order by to_date(Issued_date, 'dd/mm/yyyy') ",[hazardeousWasteAuthAppInstance.industryRegMasterObj.id])
				 for(int var33=0;var33<hwPreviousAuthDetailsList.size();var33++)
					{
						def hwmPreviousAuthorisationList= new ArrayList()
					    hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).HWApplication_Date)
						hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).HWAType)
						hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).AuthorisationNo)
						hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Issued_date)
						hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Valid_date)
						hwPreviousAuthDetails.add(hwmPreviousAuthorisationList)
					}	

			     def hazardousWasteDetails = new ArrayList()	
				 def hazardousWasteDetailsList = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM s where s.application=? order by id asc",[hazardeousWasteAuthAppInstance])
				 for(int var18=0;var18<hazardousWasteDetailsList.size();var18++)
					{
						def hazardousWasteDetailsInstanceList= new ArrayList()
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).source.name)
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).category.name)
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).quantity+" "+hazardousWasteDetailsList.get(var18).quantityUnit)
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).wasteType)
						if(hazardousWasteDetailsList.get(var18).wasteStorage!="Others")
						{
							hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).wasteStorage)
						}
						else
						{
							hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).wasteStorageOthers)
						}
						if(hazardousWasteDetailsList.get(var18).wasteDisposal!="Others")
						{
							hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).wasteDisposal)
						}
						else
						{
							hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).wasteDisposalOthers)
						}
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).sourceOfWaste)
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).physicalStatus)
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).qtyStored)
						hazardousWasteDetailsInstanceList.add(hazardousWasteDetailsList.get(var18).qtyAccumalated+" "+hazardousWasteDetailsList.get(var18).qtyAccumalatedUnit)
						hazardousWasteDetails.add(hazardousWasteDetailsInstanceList) 
					}	
					
					    
					    


					
						
			            WasteManagementFile file1=new WasteManagementFile()
					    File certFile
					    HazardeousWasteFormPdfNewFormat pdfG=new HazardeousWasteFormPdfNewFormat()
					    certFile = pdfG.appFormHWM(applicantName,applicantDesignation,factoryPostalAddress,districtOffice,indName,occupierName,occupierDesignation,occupierMobile,
			    		   occupierEmail,isRenew,authorizationRequiredFor,hwPreviousAuthDetails,hazardousWasteDetails,yearOfCommencement,industrywork
			    		   ,isGeneratorHWA,prodManufactured,prodsManufactured,genWastes,isTSDFOper,generatedWast,strgeCapacity,trtmntProcesses,
			    		   secdLandfills,detailOfIncine,trtmntSystem,fireFightSystems,environmentalMgtPlan,transp,otherActvs,isRecyclerOrUsr,
			    		   securedStrge,endUsrs,pollutionContrlSys,saftyMeasures,complianceWithLines,transportationUsrs,characteristicsDetails,
			    		   recyclableHazardousWasteHWM,copyErp,underTaking,manufacture,layoutMapA,copyPrior,furnishInstall,processDescription,safeGuardDetails
			    		  ,facilitySet,detailsPollution,detailsEnd,detailSecured,detailOther,renewal 
					    )

								 
						def fileCheck=WasteManagementFile.findAll("from WasteManagementFile where applicationId=? and typeOfFile='HazardeousProfile'",[hazardeousWasteAuthAppInstance.id])
						for(int i=0;i<fileCheck.size();i++)
						{
							fileCheck[i].delete();
						}
			    	        
						
						byte[] b = new byte[(int) certFile.length()];
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						def fileLength=certFile.length()
						file1.size = fileLength / 1024  //f.getSize()
						file1.extension ="pdf"//extractExtension( f )
						file1.data=b;
						file1.name="HazardeousWasteForm.pdf"
						file1.description="Hazardeous Saved"
						if(indRegInstance.indName){
							file1.createdBy=session.indUser
							file1.updatedBy=session.indUser
						}
						
						file1.typeOfFile="HazardeousProfile"
						file1.indreg=indRegInstance.get(indRegInstance.id.toLong())
						file1.applicationFor="HWM"
						file1.dateCreated=formatNowYear.parse(t)
						file1.applicationId=hazardeousWasteAuthAppInstance.id
						if(file1.save()) { 
						}
						else {
						}
						
						/*if(editMode=="true"){
							RouteWasteManagement a=new RouteWasteManagement()
        		  			def appFor1 = "HWM"
                          a.routeWasteManagementApp(hazardeousWasteAuthAppInstance.id,appFor1,indRegInstance)
                          updateAllSummaryReportWMS(hazardeousWasteAuthAppInstance.id.toString())
            					flash.message = "Application re-submitted sucessfully" 
            						def activityRecInstance=new ActivityRecord();
				            activityRecInstance.userType=userType;
				            activityRecInstance.userID=userId;
				            activityRecInstance.ipAddress=request.getRemoteAddr() 
						    activityRecInstance.activity = "add"
				            activityRecInstance.status = "Hazardeous Waste Application ${hazardeousWasteAuthAppInstance.id} Saved Complete"
				            if(activityRecInstance.save()){		   
				              }
				            	else{
				            		activityRecInstance.errors.each {
							    	println it
							  }
						  }
            						redirect(action:showNewFormat,id:hazardeousWasteAuthAppInstance.id)
            						return

						}*/
//////////////////////////////////////////////for scrutiny return//////////////////////////////////

						def scrutinyReturn=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId= ? order by id desc",[(hazardeousWasteAuthAppInstance.id).toString()])
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
	 	                			scrutinyReturn.save()
	 	                	}
 	                	def scrutinyWasteManagementProcessingDetails=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId= ? order by id desc",[(hazardeousWasteAuthAppInstance.id).toString()])
 	                	System.out.println("scrutinyWasteManagementProcessingDetails+++++"+scrutinyWasteManagementProcessingDetails);
 	                	if(scrutinyWasteManagementProcessingDetails==null){
 	                		println("scrutinyWasteManagementProcessingDetails is null")
 	                	}else if(scrutinyWasteManagementProcessingDetails.scrutinyStatus=="In-Complete"){
 	                		scrutinyWasteManagementProcessingDetails.reject=false
 	                		scrutinyWasteManagementProcessingDetails.scrutinyStatus="In-Complete"
 	                		scrutinyWasteManagementProcessingDetails.resubmitStatus=true
 	                 		scrutinyWasteManagementProcessingDetails.save()
 	                	}else if(scrutinyWasteManagementProcessingDetails.returned){
 	                		scrutinyWasteManagementProcessingDetails.returned=false
 	                		scrutinyWasteManagementProcessingDetails.resubmitStatus=true
 	                 		scrutinyWasteManagementProcessingDetails.save()
 	                	}
 	                	def plasticWastescrutiny=HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp where id= ? order by id desc",[(hazardeousWasteAuthAppInstance.id).toLong()])
 	                	System.out.println("plasticWastescrutiny+++++"+plasticWastescrutiny);
 	                	if(plasticWastescrutiny==null){
 	                		println("scrutinyWasteManagementProcessingDetails is null")
 	                	}else if(plasticWastescrutiny){
 	                		plasticWastescrutiny.applicationStatus="Inprogress"
 	                		plasticWastescrutiny.save()
 	                	}
    			    	}
						else{
						    def indApplicationDetailsInstance=	hazardeousWasteAuthAppInstance
							    indApplicationDetailsInstance.completionStatus = "Completed"
						    	indApplicationDetailsInstance.save()
						    	//IndUser indUserInstance=(IndUser)session.indUser
						    	def industryRegInstanceWaste=indUserInstance.industryRegMaster
						    	def appFor="HWM"
					         	RouteWasteManagement routeWaste=new RouteWasteManagement()
						    	def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,appFor,industryRegInstanceWaste)
						    	//updateAllSummaryReportWMS(indApplicationDetailsInstance.id.toString());// for update the data of all sumryWMS table
						    	def formView = indApplicationDetailsInstance.is_Renew
						    	render(view:'confirmationSubmit',model:[formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
						
            					//	redirect(action:Payment,id:hazardeousWasteAuthAppInstance.id,consentFeeMasterInstance:consentFeeMasterInstance)
            						return;
            						
						
						}
						}
						else
						{
							flash.message="Your Application No. ${hazardeousWasteAuthAppInstance.id} is saved and available for future update..."
							
							if((hazardeousWasteAuthAppInstance.cafUniqueNo!="") && (hazardeousWasteAuthAppInstance.cafUniqueNo!=null)){
								Response responsePush=new Response();
								String consentAppNo=hazardeousWasteAuthAppInstance.id.toString();
								String cafNo=hazardeousWasteAuthAppInstance.cafUniqueNo
								String serviceId=hazardeousWasteAuthAppInstance.serviceId
								String applicationType="HWM"
								String applicationFor1="Fresh"
								String statusCode="I"
								String appRemarks="Application Saved as draft"
								String pendingWith=""
								String pendingWithRole=""
								String printAppUrl=""
								String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+hazardeousWasteAuthAppInstance.industryRegMasterObj.indName+"&indDistrict="+hazardeousWasteAuthAppInstance.industryRegMasterObj.district.districtName+"&serviceCode="+hazardeousWasteAuthAppInstance.serviceId+"&cafUniqueNo="+hazardeousWasteAuthAppInstance.cafUniqueNo
								String certificateUrl=""
								responsePush.sendStatus(consentAppNo, cafNo, serviceId, applicationType, applicationFor1, statusCode, appRemarks, pendingWith, pendingWithRole, printAppUrl, revertedUrl, certificateUrl)
								
							}
							
							
							def activityRecInstance=new ActivityRecord();
				            activityRecInstance.userType=userType;
				            activityRecInstance.userID=userId;
				            activityRecInstance.ipAddress=request.getRemoteAddr() 
						    activityRecInstance.activity = "save"
				            activityRecInstance.status = "Hazardeous Waste Application ${hazardeousWasteAuthAppInstance.id} Saved In-Progress"
				            if(activityRecInstance.save()){		   
				              }
				            	else{
				            		activityRecInstance.errors.each {
							    	println it
							   }
						      }
						}
			            redirect(action:showNewFormat,id:hazardeousWasteAuthAppInstance.id)	
			            return
			}
			 else
			{
				hazardeousWasteAuthAppInstance.errors.each{println it;}
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
	
	
	def viewDocumentRecy_1={
			 try{
				 
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of the Emergency Response Plan' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
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
             activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Copy of the Emergency Response Plan Downloaded."
             if(activityRecInstance.save()){		   
               }
             	else{
             		activityRecInstance.errors.each {
     		    	println it
     		  }
     	   }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_2={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			  println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Undertaking or declaration to comply' and abc.applicationId=?"+redoc+"",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
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
	            activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Undertaking or declaration to comply Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_3={
			try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Manufacturing process with flow sheet' and abc.applicationId=?"+redoc+"",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
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
	    	    activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Manufacturing process with flow sheet Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_8={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Layout map of the TSDF' and abc.applicationId=?"+redoc+"",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Layout map of the TSDF Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_9={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of prior Environmental Clearance' and abc.applicationId=?"+redoc+"",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Copy of prior Environmental Clearance Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	 def viewDocumentRecy_10={
			 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	   		 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	   		 response.setDateHeader("Expires", 0); // Proxies.
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
   	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Detail of Hazardous Waste with Name Downloaded."
           if(activityRecInstance.save()){		   
             }
           	else{
           		activityRecInstance.errors.each {
   		    	println it
   		  }
   	  }
	   		 def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Detail of Hazardous Waste with Name' and abc.applicationId=? order by abc.id desc",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
    }
	
	def viewDocumentRecy_5={
			try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Furnish installed capacity as per registration' and abc.applicationId=?"+redoc+"",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
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
	    	    activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Furnish installed capacity as per registration Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_6={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Process description including process flow sheet' and abc.applicationId=?"+redoc+"",[appli])
			 def applicationFileSingleInstance=applicationFileInstance[0]
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Process description including process flow sheet Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_11={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='renewal of Authorisation' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
			 
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document renewal of Authorisation Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_12={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of any other activities' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Details of any other activities Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_13={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of secured storage of wastes' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Details of secured storage of wastes Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_14={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of end users of products' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Details of end users of products Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_15={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of pollution control systems' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Details of pollution control systems Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def viewDocumentRecy_16={
			 try{
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 			 println("params-------"+params)
			 def docStatus = params.status
			 def redoc = ""
			 if(docStatus=="true")
			 {
				 redoc = " and abc.resubmittedDoc=true order by abc.id desc " 
			 }
			 else if(docStatus=="false")
				 {
					 redoc = " and abc.resubmittedDoc=false order by abc.id desc " 
				 }
			 applicationFileInstance=WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Central Pollution Control Board guidelines' and abc.applicationId=?"+redoc+"",[appli])
			 println("applicationFileInstance : "+applicationFileInstance.name)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 println("applicationFileSingleInstance : "+applicationFileSingleInstance.name)
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
	    	    	 activityRecInstance.status = "Hazardous Waste Application "+params.appliLoc+ " Document Central Pollution Control Board guidelines Downloaded."
	            if(activityRecInstance.save()){		   
	              }
	            	else{
	            		activityRecInstance.errors.each {
	    		    	println it
	    		  }
	    	  }
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	}catch(Exception e){
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
	
	def showNewFormat = {
			 try {
				    
					def industryId = session.indUser
					/*if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}*/
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( (params.id).toInteger() )
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def listDoc=WasteManagementFile.findAll("from WasteManagementFile where applicationId = ? and typeOfFile='Uploded Documents' and resubmittedDoc=false ",[hazardeousWasteAuthAppInstance.id]);
					def listDoc1=WasteManagementFile.findAll("from WasteManagementFile where applicationId = ? and typeOfFile='Uploded Documents' and resubmittedDoc=true ",[hazardeousWasteAuthAppInstance.id]);
					
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
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
			            activityRecInstance.status = "Hazdeous Waste Application "+hazardeousWasteAuthAppInstance.id+ " Click for View"
			            if(activityRecInstance.save()){		   
			              }
			            	else{
			            		activityRecInstance.errors.each {
						    	println it
						  }
					  }
						render(view:'showNewFormat',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,listDoc:listDoc,listDoc1:listDoc1] ) 
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
	
	def editNewFormat = {
			 try {
				    println("params----"+params)
				    def editMode = params.editMode
				    println("editMode----"+editMode)
					def industryId = session.indUser
					if(industryId==null || industryId=="") {
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					
					def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get((params.indAppDetId).toLong())
					
					def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					
					def district=indRegInstanceGet.district.districtName
					def tehsil=indRegInstanceGet.tehsil.tehsilName
					
			     	def hwProductDetailsList= IndHWProductDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					
					def hazardeousWasteDetailsList = IndHazardeousWasteDetails.findAllWhere(hazardeousWasteAuthAppObj : hazardeousWasteAuthAppInstance)
					
					def docList11 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Documents' and abc.description='recycling process' and abc.applicationId=? ",[hazardeousWasteAuthAppInstance.id])
					def recyclingprogramme =false
			        if(docList11)
					{
			        	recyclingprogramme=true
					}
					
					def docList12 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Documents' and abc.description='importing process' and abc.applicationId=? ",[hazardeousWasteAuthAppInstance.id])
					def importingProcess =false
			        if(docList12)
					{
			        	importingProcess=true
					}
					
					def docList13 = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Documents' and abc.description='manufacturequant process' and abc.applicationId=? ",[hazardeousWasteAuthAppInstance.id])
					def manufacturequantprocess =false
			        if(docList13)
					{
			        	manufacturequantprocess=true
					}
					
					String tmp = hazardeousWasteAuthAppInstance.authorization_Required_For
					ArrayList tmp1=new ArrayList()
					tmp1=tmp.split(",")
					
					if(!hazardeousWasteAuthAppInstance) {
						flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
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
			            activityRecInstance.status = "Hazardeous Waste Application Edit Click"
			            if(activityRecInstance.save()){		   
			              }
			            	else{
			            		activityRecInstance.errors.each {
						    	println it
						  }
					  }
						return [ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , tmp1:tmp1,docList11:docList11,docList12:docList12,docList13:docList13,editMode:editMode]
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
	

	
	/////////////////////////////////////////////////New HWM Application Format end ///////////////////////////////////////////////
	
		def popFeeOtherDetailsAddHWM = {
			 try {
			    	
					
	        		def app = HazardeousWasteAuthApp.get((params.id).toInteger())
	       

	            	def feeDetailsList = FeeBankOtherDetailsHWM.findAllByApplication(app)
	            	def totalfee = 0.0
	            	
	            	for(int i=0;i<feeDetailsList.size();i++)
	            	{
	            		totalfee = totalfee + feeDetailsList.get(i).amount
	            	}

	        		def feeCheque = FeeChequeRecordHWM.find("from FeeChequeRecordHWM afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])

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
	    	        activityRecInstance.status = "HWM Application "+params.id+ " Fee Details Click on Add."
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
	
	
	def saveBankOtherFeeDetailsHWM ={
			 try {
				    
		        	
		         	
		        	def app = HazardeousWasteAuthApp.get((params.appId).toInteger())

		            	
		            			def feeBankDetailsHWM = new FeeBankOtherDetailsHWM()
		        	feeBankDetailsHWM.application = app
		                		
		                		if(params.feeFor=="Other"){
		                			feeBankDetailsHWM.feeFor = params.feeFor+","+params.otherDetail	
		                		}else{
		                		
		                		
		                			feeBankDetailsHWM.feeFor = params.feeFor
		                		}
		                		
		                		
		                	
		                		if(params.ddAmount != ""){
		                			try{
		                				feeBankDetailsHWM.amount = (params.ddAmount).toLong()
		                			}catch (Exception e) {
		                				feeBankDetailsHWM.amount = 0
		                			}
		            				
		            			}else{
		            				feeBankDetailsHWM.amount = 0
		            			}
		            		
		if(feeBankDetailsHWM.save(flush:true)){
								
													
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
	        activityRecInstance.status = "HWM Application "+params.appId+ " Fee Details saved."
	        if(activityRecInstance.save()){		   
	          }
	        	else{
	        		activityRecInstance.errors.each {
			    	println it
			  }
		  }
									
									
									
		        			}else{
		        				feeBankDetailsHWM.errors.each {
		        			        println it
		        			   }
		        			}
		        			
		            		
		    	redirect(action:popFeeOtherDetailsAddHWM,id:app.id)

		                		
		                		
		                		
		                		
		    
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
	
	
	def popFeeOtherDetailsViewHWM = {
			 try {
			    	
		    		def app = HazardeousWasteAuthApp.get((params.id).toInteger())

		        	def feeDetailsListHWM = FeeBankOtherDetailsHWM.findAllByApplication(app)
		        	def feeCheque = FeeChequeRecordHWM.findByIndApplication(app)
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
	    	        activityRecInstance.status = "HWM Application "+params.id+ " Fee Details Click on View."
	    	        if(activityRecInstance.save()){		   
	    	          }
	    	        	else{
	    	        		activityRecInstance.errors.each {
	    			    	println it
	    			  }
	    		  }
		        	return [appDetId:params.id,feeDetailsListHWM:feeDetailsListHWM]
		    
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
	
	
	
	 def popFeeOtherDetailsEditHWM = {
			 try {
				    
		        	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
		        	def feeDetailsHWMList = FeeBankOtherDetailsHWM.findAllByApplication(app)
		        	def feeCheque = FeeChequeRecordHWM.findByIndApplication(app)
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
	    	        activityRecInstance.status = "HWM Application "+params.id+ " Fee Details Click on Edit."
	    	        if(activityRecInstance.save()){		   
	    	          }
	    	        	else{
	    	        		activityRecInstance.errors.each {
	    			    	println it
	    			  }
	    		  }
		        	return [appDetId:params.id,feeDetailsHWMList:feeDetailsHWMList]
		        
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
    
    
    def deleteFeeOtherBankDetailsHWM = {
			 try {
				    
		        	def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def feeDetInstHWM = FeeBankOtherDetailsHWM.get((params.delete).toInteger())
		        		
		        		feeDetInstHWM.delete()

		        	}else{
		        		if(params.delete){
		            	for(int i=0;i<(params.delete).size();i++){
		            		def feeDetInst = FeeBankOtherDetailsHWM.get((params.delete[i]).toInteger())
		            		
		            		feeDetInstHWM.delete()
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
	    	        activityRecInstance.status = "HWM Application "+params.id+ " Fee Details deleted."
	    	        if(activityRecInstance.save()){		   
	    	          }
	    	        	else{
	    	        		activityRecInstance.errors.each {
	    			    	println it
	    			  }
	    		  }
		        	redirect(action:popFeeOtherDetailsEditHWM,id:app)
		        
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
	
	
	
	
	/////////////////////SCANNED COPY//////////////////////
	
	def viewChequeAttachedFee={
			 try {
				    

          		 
	          		
        		 def applicationFileInstance
        	    	def application = HazardeousWasteAuthApp.get((params.appliLoc).toLong())
        	    	
        	        applicationFileInstance=FeeChequeRecordHWM.findAll("from FeeChequeRecordHWM afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[application],[max:1])
        	    	
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
	//////////////////////////////////////////////////////////////////////////
	      def confirm = {
			 try {
				    def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(params.indAppDetId)
				    indApplicationDetailsInstance.completionStatus = "Completed"
	            	indApplicationDetailsInstance.save()
	       		    def formView = indApplicationDetailsInstance.is_Renew
                    render(view:'confirmationSubmit',model:[formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
	 
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
				 	def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(params.indAppDetId)
				 	def fees = FeeBankDetailsHWM.find("from FeeBankDetailsHWM fee where fee.application=?",[indApplicationDetailsInstance])
					if(fees==null)
					{
						flash.message="Please Enter HWM Fee Details"
		           	    redirect(action:bankPaymentMode,id:indApplicationDetailsInstance)
					}  
				else
				{
			    	indApplicationDetailsInstance.completionStatus = "Completed"
			    	indApplicationDetailsInstance.save()
			    	IndUser indUserInstance=(IndUser)session.indUser
			    	def industryRegInstanceWaste=indUserInstance.industryRegMaster
			    	def appFor="HWM"
		         	RouteWasteManagement routeWaste=new RouteWasteManagement()
			    	def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,appFor,industryRegInstanceWaste)
			    	updateAllSummaryReportWMS(indApplicationDetailsInstance.id.toString());// for update the data of all sumryWMS table
			    	def formView = indApplicationDetailsInstance.is_Renew
			    	render(view:'confirmationSubmit',model:[formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
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
	
	
	////////////////////////////////////////////////////////////////////////
	
	
	
	def saveChequeAttachFee = {
			 try {
				    


		      		def app = HazardeousWasteAuthApp.get((params.appId1).toInteger())
		      		def feeCheque = FeeChequeRecordHWM.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])


		      		if(feeCheque){

		      			feeCheque.delete()
		         		 
		      		}
		      		
		      		def file1 = new FeeChequeRecordHWM()
		      		
		      		
		      		def f = request.getFile('draftattach')
		  			
		      		if(!f.empty) {
		      			MultipartFile multi1 = request.getFile('draftattach')
		  				file1.size = multi1.getSize() / 1024
		  				file1.level="Fee_Details"
		  					file1.dateCreated = new Date()
		                  
		  					file1.data=multi1.getBytes() 
		                  file1.extension = extractExtension( multi1 )
		                  def abc = "Fee_Details" 
		  	            	def b = abc+"."+extractExtension( multi1 )
		  	            	file1.name =b
		          	    
		  	            	file1.indApplication = app
		  	            	
		  				file1.save()
		  			}
		      		redirect(action:popFeeOtherDetailsAddHWM,id:app)
		      
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
	
	////////////////////////Ashish//////// Start	////////////////////////
	
	def Payment = {
		 try {
			    

			   

		   	 def indApplicationDetailsInstance = HazardeousWasteAuthApp.get( params.id )
		   	def feeAmountId = ConsentFeeMasterHWM.find("from ConsentFeeMasterHWM  where application = ?",[indApplicationDetailsInstance])
		   	def feeAmount = (feeAmountId.calculatedFee).toInteger()

		   	
		   	def feeDetailsList = FeeBankOtherDetailsHWM.findAllByApplication(indApplicationDetailsInstance)
		       	def totalfee = 0.0
		       	
		       	for(int i=0;i<feeDetailsList.size();i++)
		       	{
		       		totalfee = totalfee + feeDetailsList.get(i).amount
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
            activityRecInstance.status = "HWM Application ${params.id} select for payment option"
            if(activityRecInstance.save()){		   
              }
            	else{
            		activityRecInstance.errors.each {
			    	println it
			  }
		  }
		   	render(view:'Payment',model:[hazardeousWasteAuthAppInstance:indApplicationDetailsInstance,feeAmount:totalfee])

		    	
		    
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
				    
			    	def fee = params.fees

			    	def indApp = params.indAppDetId
			    	def indApplicationDetailsInstance
			    	
			    	indApplicationDetailsInstance = HazardeousWasteAuthApp.get( params.indAppDetId)
			    	
			    	
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
	                activityRecInstance.status = "HWM Application ${params.indAppDetId} selected payment option"
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
			    	else
			    	{
			    		redirect(action:bankPaymentMode,id:indApplicationDetailsInstance)
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
				    ///  this method add by ajay

				    	 def indApplicationDetailsInstance = HazardeousWasteAuthApp.get( params.id )
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
	
	
	
	
	
	def popFeeDetailsAddHWM = {
			 try {
				    
	            	def app = HazardeousWasteAuthApp.get((params.id).toInteger())

	            	def feeDetailsList = FeeBankDetailsHWM.findAllByApplication(app)
	            	def feeCheque = FeeChequeRecordHWM.findByIndApplication(app)
	            	
	            	
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
	        		

	            	
	            	def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
	            	if(x>sqlCurrentDate)
	        		{
	        			flash.message="DD/Cheque issue date can not be greater than current date"

	        			redirect(action:popFeeDetailsAddHWM,id:app.id)
	        		}
	            	else
	            	{

	            		if((params.ddNo).getClass().getName()== "java.lang.String"){
	                		if(params.ddNo!=""){
	                			def feeBankDetails = new FeeBankDetailsHWM()
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
	                				def feeBankDetails = new FeeBankDetailsHWM()
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
	            	redirect(action:popFeeDetailsAddHWM,id:app.id)
	            	
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
				    


		       		def app = HazardeousWasteAuthApp.get((params.appId1).toInteger())
		       		
		       		def feeCheque = FeeChequeRecordHWM.findByIndApplication(app)

		       		if(feeCheque){
		           		def feeChequeWW = FeeChequeRecordHWM.get((params.delete1).toInteger())

		       			feeChequeWW.delete()
		          		 
		       		}
		       		
		       		def file1 = new FeeChequeRecordHWM()
		       		
		       		
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
		   	            	
		   				file1.save()
		   			}
		       		redirect(action:popFeeDetailsAddHWM,id:app)
		       
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
       
       def popFeeDetailsViewHWM = {
			 try {
				    
	            	def app = HazardeousWasteAuthApp.get((params.id).toInteger())

	            	def feeDetailsList = FeeBankDetailsHWM.findAllByApplication(app)
	            	def feeCheque = FeeChequeRecordHWM.findByIndApplication(app)
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
       	    	def application = HazardeousWasteAuthApp.get((params.appliLoc).toLong())
       	    	
       	        applicationFileInstance=FeeChequeRecordHWM.findAll("from FeeChequeRecordHWM afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[application],[max:1])
       	    	
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
       def popFeeDetailsEditHWM = {
			 try {
				    
	            	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
	            	def feeDetailsList = FeeBankDetailsHWM.findAllByApplication(app)
	            	def feeCheque = FeeChequeRecordHWM.findByIndApplication(app)
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
				    
	            	def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
	            	if((params.delete).getClass().getName()== "java.lang.String"){
	            		def feeDetInst = FeeBankDetailsHWM.get((params.delete).toInteger())
	            		
	            		feeDetInst.delete()
	            	
	            		if(params.delete1)
	            		{
	            		def feeCheque = FeeChequeRecordHWM.get((params.delete1).toInteger())

	            		if(feeCheque){
	                	

	                		

	                			feeCheque.delete()
	                		}
	            			
	                    	flash.message="Please attach again the scan copy of Drafts/Cheques"

	            		}
	            	}else{
	            		if(params.delete){
	                	for(int i=0;i<(params.delete).size();i++){
	                		def feeDetInst = FeeBankDetailsHWM.get((params.delete[i]).toInteger())
	                		
	                		feeDetInst.delete()
	                	}
	                	if(params.delete1)
	            		{
	            		def feeCheque = FeeChequeRecordHWM.get((params.delete1).toInteger())
	            		if(feeCheque){
	            			
	                        	

	                    		

	                    			
	                    		
	                    		
	            			feeCheque.delete()
	                		}
	                	flash.message("Please attach again the scan copy of above Drafts/Cheques")

	            		}
	            		}
	            		
	            	}
	            	redirect(action:popFeeDetailsEditHWM,id:app)
	            
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
	
	
	
	
	def popAuthorisationDetailsAdd = {
	    	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
	    	def authorisationdetails = AuthorisationDetailsHWM.findAll("from AuthorisationDetailsHWM s where s.application=? order by id asc",[app])
	        return [appDetId:params.id, authorisationdetails:authorisationdetails]
	    }
	
	
	def saveAuthorisationdetails = {
			
			
			def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
			
			def authorisationdetails = new AuthorisationDetailsHWM()
			
			authorisationdetails.category=params.category
			authorisationdetails.mode=params.mode
			authorisationdetails.quantity=params.quantity
			
			authorisationdetails.application = app
			
			authorisationdetails.save()
			
			flash.message = "Details Saved"
			redirect(action:popAuthorisationDetailsAdd,id:app)
		}


def popAuthorisationDetailsView = {
			
		 	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
	    	def authorisationdetails = AuthorisationDetailsHWM.findAll("from AuthorisationDetailsHWM s where s.application=? order by id asc",[app])
	        return [appDetId:params.id, authorisationdetails:authorisationdetails]
	  	
		}
	
	
	def popAuthorisationDetailsEdit = {
		 	def app = HazardeousWasteAuthApp.get((params.id).toInteger())
	    	def authorisationdetails = AuthorisationDetailsHWM.findAll("from AuthorisationDetailsHWM s where s.application=? order by id asc",[app])
	        return [appDetId:params.id, authorisationdetails:authorisationdetails]
	  }
	
	
	
	def editAuthorisationdetails = {
			def app = HazardeousWasteAuthApp.get((params.appId).toInteger())
			if((params.delete).getClass().getName()== "java.lang.String"){
				def authorisationdetails = AuthorisationDetailsHWM.get((params.delete).toInteger())
				authorisationdetails.delete()
			}else{
				if(params.delete)
				for(int i=0;i<(params.delete).size();i++){
					def authorisationdetails = AuthorisationDetailsHWM.get((params.delete[i]).toInteger())
					authorisationdetails.delete()
				}
			}
			redirect(action:popAuthorisationDetailsEdit,id:app)
			
		}
	
	
	def refusalDraft = {
			 
			 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    	 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    	 response.setDateHeader("Expires", 0); // Proxies. 
	    	 def userId = session.userMaster
	    	 def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.id )
	    	 def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
	    	 def indRegInstanceId=indRegInstance.id
	    	 def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
	    	 def district=indRegInstanceGet.district.districtName
	    	 def tehsil=indRegInstanceGet.tehsil.tehsilName
	    	 def wasteManagementFileList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id)
	    	 String tmp="";	
	    	 
	    	 def recordCertificateInstance = RefusalDraftHWM.findByApplicationId(hazardeousWasteAuthAppInstance)
	    	 println("recordCertificateInstance---"+recordCertificateInstance);
	    	 
	    	 if(!hazardeousWasteAuthAppInstance) {
	    			flash.message = "HazardeousWasteAuthApp not found with id ${params.id}"
	    			redirect(action:list)
	    		}
	    		else {
	    			
	    			
	    			def userType;
	    	        def userIdA;
	    	        if(session.indUser)
	    	        {
	    	        	userType="Industry";
	    	        	userIdA = ((session.indUser).toString()).trim();
	    	        	
	    	        }
	    	        else if (session.userMaster)
	    	        {
	    	        	userType="SPCB";
	    	        	userIdA = ((session.userMaster).toString()).trim();
	    	        	
	    	        }
	    	        def activityRecInstance=new ActivityRecord();
	    	        activityRecInstance.userType=userType;
	    	        activityRecInstance.userID=userIdA;
	    	        activityRecInstance.ipAddress=request.getRemoteAddr() 
	    		    activityRecInstance.activity = "view"
	    		    activityRecInstance.status = "Hazardous Waste Application "+params.id+ " Generate Certificate Click ."
	    	        if(activityRecInstance.save()){		   
	    	          }
	    	        	else{
	    	        		activityRecInstance.errors.each {
	    			    	println it
	    			  }
	    		  }
	    			render(view:'refusalDraft',model:[ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,recordCertificateInstance:recordCertificateInstance] )
	    			 
	    		}
	    	 
			 
	 }
	 
	 

	 def createNewHWMRefusal=
	 {
			 
			 
			    println("HELLO INSIDE IN ---"+params);
			 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			    response.setDateHeader("Expires", 0); // Proxies. 
			    def userId = session.userMaster
				def hazardeousWasteAuthAppInstance = HazardeousWasteAuthApp.get( params.hazardeousWasteAuthAppInstanceid )
				def checkForView=false
				def app = WasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString())
				def id=app.id
				def indRegInstance=hazardeousWasteAuthAppInstance.industryRegMasterObj
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def district=indRegInstanceGet.district.districtName
				def tehsil=indRegInstanceGet.tehsil.tehsilName
				def wasteManagementFileList = WasteManagementFile.findAllWhere(applicationId : hazardeousWasteAuthAppInstance.id)
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				def dateToday = new Date();
				String number = params.authNumber
				String date = dateFormat.format(dateToday)
				String indName = indRegInstanceGet.indName
				String indAddress = indRegInstanceGet.indAddress
				String indDistrict = district
				String indTehsil = tehsil
				String appId = hazardeousWasteAuthAppInstance.id
				String occName = indRegInstanceGet.occName
				def t = dateFormat.format(hazardeousWasteAuthAppInstance.dateCreated)
				String appDate = t
				def renewPeriod = params.period_of_Auth_value
				String authLetterNo = params.authNumber
				String authLetterDate = dateFormat.format(dateToday)
				String endtNo = params.authNumber
				String endtDate = dateFormat.format(dateToday)
				String indLocation = params.location_Of_Activity
				String termCon=params.termsConditions;
				SimpleDateFormat outFormat = new SimpleDateFormat("dd/MM/yyyy");
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
				def d = sdfh.parse(renewPeriod);
				java.sql.Date sqlDate9 = new java.sql.Date(d.getTime())
				
				def hwmInstanse = HazardeousWasteAuthApp.get( params.hazardeousWasteAuthAppInstanceid )
				println("INSTANSE---"+hwmInstanse.getClass().getName());
				if(hwmInstanse)
				{
					hwmInstanse.location_Of_Activity=params.location_Of_Activity
					hwmInstanse.save();
				}
				def refrenceNo;
				//def fileNo=hazardeousWasteAuthAppInstance.fileNo;
				def fileNo;
				def industryDistrictNew=indRegInstance.district.districtName;
				def b3=(hazardeousWasteAuthAppInstance.dateCreated);
			    Format formatter1 = new SimpleDateFormat("dd/MM/yyyy")
				def dateOfSubmission= formatter1.format(b3)
				String[] parts = dateOfSubmission.split("/");
				String part2 = parts[2];
				def appForNew="HWM";
				
				def offDes=params.officerdesig;
				def offName=params.officername;
				def draftLetterDate=params.period_of_Auth_value
				def w = sdfh.parse(draftLetterDate);
				java.sql.Date sqlDate4 = new java.sql.Date(w.getTime())	
				def indRegIdUpdated=(indRegInstance.id).toString();
				def  disList = GroupDistrictMaster.find("from GroupDistrictMaster as abc where abc.district.id=? and abc.group.groupDesc NOT IN ('Grievance','Group') order by abc.id desc ",[(indRegInstance.district.id).toLong()])
				println("F-----------"+disList.group);
			    refrenceNo=fileNo+"/UPPCB"+"/"+disList.group+"/"+appForNew+"/"+industryDistrictNew+"/"+part2;
				
			    		  //Solved VINEET KUMAR RAGHAV:END
				          String termsAndConditions = params.termsConditions
				          String copyTo = params.copyTo
				          def appNo=params.authNumber;
				          
				          
				          def recordCertificateInstance=new RefusalDraftHWM()
			    		  def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
				          recordCertificateInstance.draftLetterDate=sqlDate4
				          recordCertificateInstance.authNumber=params.authNumber
				          recordCertificateInstance.copyTo=params.copyTo
				          recordCertificateInstance.industryName=indName
				          recordCertificateInstance.dateCreated = new Date()
				          recordCertificateInstance.applicationId=hazardeousWasteAuthAppInstance
						  recordCertificateInstance.officername = params.officername
			              recordCertificateInstance.officerdesig = params.officerdesig
						  recordCertificateInstance.termsConditions = params.termsConditions
						  recordCertificateInstance.industryAddress=indAddress
						  recordCertificateInstance.refNo=refrenceNo
						  println("DDDDDDDDDDDDDDDDDDDDD");
				          if(recordCertificateInstance.save(flush:true)){
							  
							  println("VINEET KUMAR ABC SAVE YES---");
							  
				                }else{
				                
				                 println("VINEET KUMAR ABC SAVE NOT---");
					                   if(recordCertificateInstance.hasErrors()){
					                	   recordCertificateInstance.errors.allErrors.each {
			    	                println it
			    	               }
			    	          } 
			    	    }
				          
				        WasteManagementCertificates file = new WasteManagementCertificates()
				        RefusalHWM hwCert = new RefusalHWM()
						String strLong = "";
				        File certificate = hwCert.pdfFunction(copyTo,indName,indAddress,occName,termsAndConditions,sqlDate4,offDes,offName,refrenceNo,dateOfSubmission,indDistrict,indRegIdUpdated,appNo,termCon)
						
				        //def c = appId+"_RefusalCertiFicateHWM"+".pdf";
				        //def userDir = new File("/home1/Documents/UP_Documents/${indRegInstanceId}/");
				        //userDir.mkdirs();
				        //def userDirAA = new File(userDir,c);
				        
				        byte[] b = new byte[(int) certificate.length()];
						FileInputStream fileInputStream = new FileInputStream(certificate);
						fileInputStream.read(b);
						//userDirAA << new ByteArrayInputStream(b);
						def fileLength=certificate.length()
						file.size = fileLength / 1024
						file.extension ="pdf"
						file.data=b;
						String fileName = appId.concat("New").concat(".pdf")
						file.name=fileName
						file.description="HWM_Refusal"
						file.createdBy=indRegInstance.indName
						file.updatedBy=indRegInstance.indName
						file.typeOfFile="HWM_Refusal"
						file.indreg=indRegInstance
						file.applicationId = hazardeousWasteAuthAppInstance.id
						file.applicationFor = "HWM"
						def fileid=null
						if(file.save(flush:true)) {
							println("FILE SAVE---");
							fileid=file.id
							flash.message = "Hazardous Waste - Refusal Certificate is generated properly."
							checkForView=true
							def userType;
							def userIdA;
							if(session.indUser)
							{
								userType="Industry";
								userIdA = ((session.indUser).toString()).trim();
			        	
							}
							else if (session.userMaster)
							{
								userType="SPCB";
								userIdA = ((session.userMaster).toString()).trim();
			        	
							}
							def activityRecInstance=new ActivityRecord();
							activityRecInstance.userType=userType;
							activityRecInstance.userID=userIdA;
							activityRecInstance.ipAddress=request.getRemoteAddr() 
							activityRecInstance.activity = "add"
							activityRecInstance.status = "Hazardous Waste Application "+hazardeousWasteAuthAppInstance.id+ " Refusal Certificate Generated."
							if(activityRecInstance.save()){		   
							}
			        	else{
			        		activityRecInstance.errors.each {
					    	println it
			        		}
			        	}
							println("Save After File in Groovy-");
							redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
					 
				}else
				{
					 println("FILE NOT SAVE---");
			         file.errors.each {
					 println it
				}
					
			}	
	 }
	 
	 
	 
	 def viewHWMRefusalCert={
	        	
			 	println("viewUploadedHWMCert=-=-=-=-"+params)
		    	def appId=(params.id).toLong();
			 	def regMasterIdE;
			 	def docName ="RefusalCertiFicateHWM";
			 	appId=HazardeousWasteAuthApp.get(appId);
			 	def userType;
		        def userId;
		        def apId=appId.id
		        def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.typeOfFile='HWM_Refusal' order by wmc.id desc",[apId])
				println("checkCertificate=-=-=-=-"+checkCertificate)
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
				if(checkCertificate)
				{
					
					def activityRecInstance=new ActivityRecord();
		            activityRecInstance.userType=userType;
		            activityRecInstance.userID=userId;
		            activityRecInstance.ipAddress=request.getRemoteAddr() 
		    	    activityRecInstance.activity = "view"
		    	    activityRecInstance.status = "Hazardous Waste Application "+appId+ " Refusal Certificate Downloaded."
		            if(activityRecInstance.save()){		   
		              }
		            	else{
		            		activityRecInstance.errors.each {
		    		    	println it
		    		   }
		    	   }
		            
		            
		          def applicationFileSingleInstance=checkCertificate[0];
		          response.setContentType( "application-xdownload")
				  response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
				  response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
	        	 

				}
		    }
	 def deleteApp={

			 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	   		 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	   		 response.setDateHeader("Expires", 0); // Proxies.
			
	   		 println("Params in deleteApp-----"+params) ;
				def hwmApplicationId = params.surroundingName;
				
				def hazardousWasteInstanse=HazardeousWasteAuthApp.get(hwmApplicationId.toLong())
				if(hazardousWasteInstanse)
				{
					println("hazardousWasteInstanse-----"+hazardousWasteInstanse);
					def characteristicsAndManagementInstList=CharacteristicsAndManagementHWM.findAll("from CharacteristicsAndManagementHWM charachter where charachter.application=? ",[hazardousWasteInstanse]);
				    if(characteristicsAndManagementInstList){
						for(int i=0;i<characteristicsAndManagementInstList.size();i++){
						   characteristicsAndManagementInstList.get(i).delete()
						}
					}
				    
				    def harardNameInstance = HazardousWasteDetailsHWM.findAll("from HazardousWasteDetailsHWM indPower where indPower.application=?",[hazardousWasteInstanse])
	            	println("harardNameInstance-----"+harardNameInstance);
				    if(harardNameInstance){
						for(int i=0;i<harardNameInstance.size();i++){
							harardNameInstance.get(i).delete()
						}
					}
				   /* def hwmProductDetailsList = HwmProductDetails.findAll("from HwmProductDetails s where s.application=? order by id asc",[hazardousWasteInstanse])
                println("hwmProductDetailsList-----"+hwmProductDetailsList);
				    if(hwmProductDetailsList){
						for(int i=0;i<hwmProductDetailsList.size();i++){
							hwmProductDetailsList.get(i).delete()
						}
					}*/
				   /* def hwmByProductDetailsList = HwmByProductDetails.findAll("from HwmByProductDetails s where s.application=? order by id asc",[hazardousWasteInstanse])
				   	println("hwmByProductDetailsList-----"+hwmByProductDetailsList);
				    if(hwmByProductDetailsList){
						for(int i=0;i<hwmByProductDetailsList.size();i++){
							hwmByProductDetailsList.get(i).delete()
						}
					}*/
				    def consentFeeMasterList = ConsentFeeMasterHWM.findAll("from ConsentFeeMasterHWM s where s.application=? order by id asc",[hazardousWasteInstanse])
		               println("consentFeeMasterList-----"+consentFeeMasterList);
					    if(consentFeeMasterList){
							for(int i=0;i<consentFeeMasterList.size();i++){
								consentFeeMasterList.get(i).delete()
							}
						}
				    def recyclableHazardousWasteHWMList = RecyclableHazardousWasteHWM.findAll("from RecyclableHazardousWasteHWM s where s.application=? order by id asc",[hazardousWasteInstanse])
					println("recyclableHazardousWasteHWMList-----"+recyclableHazardousWasteHWMList);
				    if(recyclableHazardousWasteHWMList){
						for(int i=0;i<recyclableHazardousWasteHWMList.size();i++){
							recyclableHazardousWasteHWMList.get(i).delete()
						}
					}
				    def deletionFromWasteFile = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationId=?",[hwmApplicationId.toLong()])
					println("deletionFromWasteFile-----------"+deletionFromWasteFile) 
					if(deletionFromWasteFile){
						
						for(int i=0;i<deletionFromWasteFile.size();i++){
							deletionFromWasteFile.get(i).delete()
						  }
					}
				    
				    def deletionFromHazardeousWasteAuthApp = HazardeousWasteAuthApp.findAll("from HazardeousWasteAuthApp abc where abc.id=? ",[hwmApplicationId.toLong()])
                println("deletionFromHazardeousWasteAuthApp-----"+deletionFromHazardeousWasteAuthApp);
				    if(deletionFromHazardeousWasteAuthApp){

					for(int i=0;i<deletionFromHazardeousWasteAuthApp.size();i++){
						deletionFromHazardeousWasteAuthApp.get(i).delete()
					}
					flash.message="Application  Deleted Successfully ."
						redirect(controller:'bioMedicalWaste',action:'deleteAppForHMW')
					//render(view:'delAppBMW')
					}
				    
	            }
				else {
					flash.message="Please select Application Id !! "
					render(view:'delApp')

			}
  
	}
	def public boolean updateAllSummaryReportWMS(String AppId){

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        String userInput = "01/01/1950";
        Date defaulDate = formatter1.parse(userInput);
        String appliId = AppId.toString()
        try
           {
        	def allSummaryReportWMSInstance=AllSummaryReportWMS.find("from AllSummaryReportWMS where applicationId = ?",[AppId]);
            if(!allSummaryReportWMSInstance)
              {  
            	
            	def authFor = "" 
                    def hazInst = HazardeousWasteAuthApp.get((AppId).toLong())
                    println("hazInst----"+hazInst)
                    if(hazInst){
                   	 if(hazInst.is_Renew)
                   	 authFor = hazInst.is_Renew
                   	 
                    }
            	
            	def WasteMgmtPendDetInstance=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId = ? ",[(AppId).toString()]);
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
                //allSummaryReportWMSInstance.industryUnit=indRegMasterInstance.industryUnit
                allSummaryReportWMSInstance.roleName=roleFwd.roleName;
                allSummaryReportWMSInstance.groupId=(roleFwd.group.id).toString()
                allSummaryReportWMSInstance.groupName=roleFwd.group.groupName
                allSummaryReportWMSInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
                allSummaryReportWMSInstance.applicationFor=WasteMgmtPendDetInstance.applicationFor
                allSummaryReportWMSInstance.applicationStatus=WasteMgmtPendDetInstance.applicationStatus
                allSummaryReportWMSInstance.recieptDate=WasteMgmtPendDetInstance.dateCreated;
                allSummaryReportWMSInstance.authDate=WasteMgmtPendDetInstance.dateCreated;
                allSummaryReportWMSInstance.industryTypeId=indRegMasterInstance.industryType.id.toString();
                allSummaryReportWMSInstance.industryTypeName=indRegMasterInstance.industryType.industryType;
                allSummaryReportWMSInstance.industryAddress=indRegMasterInstance.indAddress;
                //allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith
                allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith.id
                allSummaryReportWMSInstance.dateCreated=WasteMgmtPendDetInstance.dateCreated
                allSummaryReportWMSInstance.scrutinyStatus=""
                allSummaryReportWMSInstance.indCapInvt=(indRegMasterInstance.indCapInvt).toString()
                
                allSummaryReportWMSInstance.authorizationtype = authFor
                
                def ind_ins=IndUser.find("from IndUser where industryRegMaster=? order by dateCreated desc limit 1",[indRegMasterInstance]);
                if(ind_ins)
                allSummaryReportWMSInstance.indId=ind_ins.id
                else
                allSummaryReportWMSInstance.indId="";
                allSummaryReportWMSInstance.clarificationDate=defaulDate;
                allSummaryReportWMSInstance.refusedDate=defaulDate;
                allSummaryReportWMSInstance.returnedDate=defaulDate;
                allSummaryReportWMSInstance.dateOfIssue=defaulDate;
                allSummaryReportWMSInstance.dateOfExpaire=defaulDate;
                if(aPDInstance)
                allSummaryReportWMSInstance.pendingSince=aPDInstance.lastUpdated
                else
                allSummaryReportWMSInstance.pendingSince=WasteMgmtPendDetInstance.dateCreated
                allSummaryReportWMSInstance.pendingWith=WasteMgmtPendDetInstance.pendingWith.id
                if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true))
                {
                	
                }
                else{
                    allSummaryReportWMSInstance.errors.each {
                        println it
                    }
                }
            }
            else
            {
                def WasteMgmtPendDetInstance=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId = ? ",[appliId.toString()]);
                def roleFwd=WasteMgmtPendDetInstance.role;
                def indRegMasterInstance=WasteMgmtPendDetInstance.indRegInstance
                
                def authFor = "" 
                    def hazInst = HazardeousWasteAuthApp.get((appliId).toLong())
                    println("hazInst----"+hazInst)
                    if(hazInst){
                   	 if(hazInst.is_Renew)
                   	 authFor = hazInst.is_Renew
                   	 
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
    			allSummaryReportWMSInstance.industryTypeId=indRegMasterInstance.industryType.id.toString();
    			allSummaryReportWMSInstance.industryTypeName=indRegMasterInstance.industryType.industryType;
    			allSummaryReportWMSInstance.industryAddress=indRegMasterInstance.indAddress;
    			  allSummaryReportWMSInstance.scrutinyStatus=""
    			  allSummaryReportWMSInstance.indCapInvt=(indRegMasterInstance.indCapInvt).toString()
                  allSummaryReportWMSInstance.authorizationtype = authFor 
                  allSummaryReportWMSInstance.returned=false
                
                if(!allSummaryReportWMSInstance.hasErrors() && allSummaryReportWMSInstance.save(flush:true))
                {
                	
                }
                else {
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
	def bankName={

			
			println("----PARAMS in bankNameHDFC----"+params);
			try{
				def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(params.indAppDetId)
	    		def bankTransaction = new BankTransactionDetailsHWM()
	    		def bank
	    		def fees = session.getAttribute("fee");
				def appFor="BMW"
	    		if (true){

	    			def id = session.getAttribute("random")
			    	bankTransaction.bankId = ""
			    	bankTransaction.amount = session.getAttribute("fee")
			    	bankTransaction.bankName = "Tech Process"
			    	bankTransaction.indApplication = indApplicationDetailsInstance
			    	bankTransaction.dateCreated = new Date()
			    	bankTransaction.lastUpdated = new Date()
			    	bankTransaction.transactionStatus = "F"
			    	bankTransaction.paymentType=""
			    	bankTransaction.id = id
			    	bankTransaction.paymentGateway="BILLDESK"
			    	println("bankTransaction.bankName.id--"+bankTransaction.id)    	
			    	bankTransaction.save()   	
	            	
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
			        def feesOnline = FeeBankOtherDetailsHWM.findAll("from FeeBankOtherDetailsHWM fee where fee.application=?",[indApplicationDetailsInstance])
					println("feesOnline.......>>>>>"+feesOnline.feeFor)
				
			        
		            def indName = indApplicationDetailsInstance.id
		          	def indAddress = indApplicationDetailsInstance.industryRegMasterObj.indAddress
		            def indEmail = indApplicationDetailsInstance.industryRegMasterObj.indEmail
		            println("indName----"+indName)
		            println("indEmail----"+indEmail)
		          	
		            String industryName = indName
		            String merchantCode = indAddress
	            	
	            	String fee = session.getAttribute("fee")
	            	String bankCode ="NA"
	            	String industryEmail = indEmail
	            	println("feefeefeefeefeefee.......----"+fee)
	            	println("industryName----"+industryName)
	                println("industryEmail----"+industryEmail)
	            	def industryName1 = indApplicationDetailsInstance.industryRegMasterObj.indName
	            	VenderRegistration venderRegistrationObj=new VenderRegistration();
	                def indNameD=venderRegistrationObj.ReplaceSpecialChar(industryName1)
	                println("indNameD-----------------------"+indNameD)
	                println(".....priyanka....."+fee.getClass().getName())
	            	String txnAmount="0.00"
	                if(fee)
	                 {
	                     txnAmount=fee+""
	                 }
	                String txnAmount1="0.0"
	                if(fee){
	                	
	                    txnAmount1=fee
	                    
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
	               //def url = "http://164.100.163.18/JKPCB/hazardeousWasteAuthApp/responsePageHDFC"
	                def url="https://jkocmms.nic.in/hazardeousWasteAuthApp/responsePageHDFC"
	                //def url="http://localhost:8080/JKPCB/hazardeousWasteAuthApp/responsePageHDFC"
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
	                //response.sendRedirect(msg)
	                response.sendRedirect("https://pgi.billdesk.com/pgidsk/PGIMerchantPayment?msg="+msg);
	                //render(view:'bankName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction,strMsg:msg])
	        	}
	    		
	    	}catch(Exception e) {
	    	e.printStackTrace();
	       }
	    
	}
	def responsePageHDFC={

			
			
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
    		def transInstance = BankTransactionDetailsHWM.get(transId) 
    		def appId = transInstance.indApplication
    	    println("1 appId: " + appId)
    	    def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(appId.id)
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
    		def inst = "HWM"
    		def inst1 = "HWM"
    		def inst2 = indApplicationDetailsInstance.is_Renew
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
               	def feeDetailsList = FeeBankOtherDetailsHWM.findAllByApplication(indApplicationDetailsInstance)
                def a
               	println("37 testVal1==\"true\": " + testVal1=="true")
       			if(testVal1=="true"){
       				RouteWasteManagement routeWaste=new RouteWasteManagement()
       				def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,"HWM",val)
       		    	updateAllSummaryReportWMS((indApplicationDetailsInstance.id).toString());// all summary
       		     }else{
       		    	RouteWasteManagement routeWaste=new RouteWasteManagement()
       				def routed=routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id,"HWM",val)
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
	def popChallan={

        	try {
                
            	def indApplicationDetailsInstance = HazardeousWasteAuthApp.get(params.id)
            	def feesBankOnlineInstance = BankTransactionDetailsHWM.findAll("from BankTransactionDetailsHWM fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
            	def check = false
            	//def neftTransInstance = NeftTransactionBMWDetails.find("from NeftTransactionBMWDetails fee where fee.indApplication=? order by id ",[indApplicationDetailsInstance])
            	
            	
            	
            	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
        		def feeDetailsList = FeeBankOtherDetailsHWM.findAllByApplication(indApplicationDetailsInstance)
            
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

