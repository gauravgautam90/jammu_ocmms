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

class MunicipalSolidWasteController {
	def processDetAttach
	def siteclearenceAttach
	def detailAttach
	def utilizationprogrammeAttach
	def methodologyAttach
	def detailsexistingsiteAttach
	def layoutmapsAttach
	def detailmethodologyorcriteriaAttach
	def methodologyoperationaldetailsAttach
	
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
				[ municipalSolidWasteInstanceList: MunicipalSolidWaste.list( params ), municipalSolidWasteInstanceTotal: MunicipalSolidWaste.count() ]
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
				if((userId==null || userId=="") && (industryId==null || industryId==""))
				{
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				def docType = params.docType
				def application = params.appliLoc
				def wasteManagementFileInstance=WasteManagementFile.get((params.appliLoc).toLong())
				def singleInstanceOfWasteManagementFile=wasteManagementFileInstance
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition", "attachment;filename=${singleInstanceOfWasteManagementFile.name}")
				response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfWasteManagementFile.data )
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
				if(industryId==null || industryId=="")
				{
					redirect(controller:"userMaster",action:"logout")
				}
				def municipalSolidWasteInstance = MunicipalSolidWaste.get( (params.id).toLong() )
				def appId=municipalSolidWasteInstance.id
				def appFor="MSW"
				def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
				def certInstance=checkCertificate[0]
				def certInstanceId
				if(certInstance){
					certInstanceId=certInstance.id
				}
				def idab=municipalSolidWasteInstance.id
				IndUser indUserInstance=(IndUser)session.indUser
				def induserQuery=IndUser.get(indUserInstance.id)
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def wasteManagementFileInstance=WasteManagementFile.findAll(" from WasteManagementFile wfd where wfd.applicationId=? and wfd.typeOfFile!='attachedInspectionReport' and wfd.typeOfFile!='attachedClarificationReport' and wfd.typeOfFile!='MSWForm' and wfd.typeOfFile!='attachLetter' and wfd.typeOfFile!='inspectionReport' and wfd.typeOfFile!='indClarificationFile' order by wfd.id desc",[idab])
				def listDoc=new ArrayList()
				for(int ig=0;ig<wasteManagementFileInstance.size();ig++){
					def boolCheck=false
					if(listDoc.size()==0){
						listDoc.add(wasteManagementFileInstance.get(ig))
					}
					for(int intCheck=0;intCheck<listDoc.size();intCheck++){
						if(listDoc[intCheck].description==(wasteManagementFileInstance.get(ig)).description){
							boolCheck=true
						}
					}
					if(boolCheck==false){
						listDoc.add(wasteManagementFileInstance.get(ig))
					}
				}
				if(!municipalSolidWasteInstance) {
					flash.message = "MunicipalSolidWaste not found with id ${params.id}"
					redirect(action:list)
				}
				else { return [certInstanceId:certInstanceId, municipalSolidWasteInstance : municipalSolidWasteInstance , indRegInstanceGet:indRegInstanceGet,listDoc:listDoc,id:municipalSolidWasteInstance.id] }
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
	
def showforSpcb = {
		 try {
			 def industryId = session.indUser
				def municipalSolidWasteInstance = MunicipalSolidWaste.get( (params.id).toLong() )
				def appId=municipalSolidWasteInstance.id
				def appFor="MSW"
				def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
				def certInstance=checkCertificate[0]
				def certInstanceId
				if(certInstance){
					certInstanceId=certInstance.id
				}
				def idab=municipalSolidWasteInstance.id
				def indRegInstance=municipalSolidWasteInstance.indRegMasterObj
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=indRegInstance
				def wasteManagementFileInstance=WasteManagementFile.findAll(" from WasteManagementFile wfd where wfd.applicationId=? and wfd.typeOfFile!='attachedInspectionReport' and wfd.typeOfFile!='attachedClarificationReport' and wfd.typeOfFile!='inspectionReport' and wfd.typeOfFile!='indClarificationFile' order by wfd.id desc",[idab])
				def listDoc=new ArrayList()
				for(int ig=0;ig<wasteManagementFileInstance.size();ig++){
					def boolCheck=false
					if(listDoc.size()==0){
						listDoc.add(wasteManagementFileInstance.get(ig))
					}
					for(int intCheck=0;intCheck<listDoc.size();intCheck++){
						if(listDoc[intCheck].description==(wasteManagementFileInstance.get(ig)).description){
							boolCheck=true
						}
					}
					if(boolCheck==false){
						listDoc.add(wasteManagementFileInstance.get(ig))
					}
				}
				if(!municipalSolidWasteInstance) {
					flash.message = "MunicipalSolidWaste not found with id ${params.id}"
					redirect(action:list)
				}
				else { 
					render(view:'show',model:[certInstanceId:certInstanceId, municipalSolidWasteInstance : municipalSolidWasteInstance , indRegInstanceGet:indRegInstanceGet,listDoc:listDoc,id:municipalSolidWasteInstance.id])
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
		def municipalSolidWasteInstance = MunicipalSolidWaste.get( params.id )
		if(municipalSolidWasteInstance) {
			try {
				municipalSolidWasteInstance.delete()
				flash.message = "MunicipalSolidWaste ${params.id} deleted"
				redirect(action:list)
			}
			catch(org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "MunicipalSolidWaste ${params.id} could not be deleted"
				redirect(action:show,id:params.id)
			}
		}
		else {
			flash.message = "MunicipalSolidWaste not found with id ${params.id}"
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
				def municipalSolidWasteInstance = MunicipalSolidWaste.get( params.muId )
				List m1=new ArrayList()
				List m2=new ArrayList()
				List m3=new ArrayList()
				m1=(municipalSolidWasteInstance.measuresPrevention).split(",")
				m2=(municipalSolidWasteInstance.measuresSafety).split(",")
				m3=(municipalSolidWasteInstance.measuresPollution).split(",")
				def measureMaster=new MeasureMaster()
				List measuremasterList=new ArrayList()
				measuremasterList=measureMaster.list()
				List measurenameList=new ArrayList()
				measurenameList=measuremasterList.measureName
				def indRegInstance=municipalSolidWasteInstance.indRegMasterObj
				IndUser indUserInstance=(IndUser)session.indUser
				def induserQuery=IndUser.get(indUserInstance.id)
				def measureMasterInstance=new MeasureMaster()
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def wasteManagementFileList = WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? order by wmf.id asc",[municipalSolidWasteInstance.id])
				if(!municipalSolidWasteInstance) {
					flash.message = "MunicipalSolidWaste not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					return [ municipalSolidWasteInstance : municipalSolidWasteInstance , indRegInstanceGet:indRegInstanceGet , wasteManagementFileList:wasteManagementFileList,measurenameList:measurenameList,m1:m1,m2:m2,m3:m3]
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
				if(industryId==null || industryId=="")
				{
					redirect(controller:"userMaster",action:"logout")
				}
				IndUser indUserInstance=(IndUser)session.indUser
				def indRegInstance=indUserInstance.industryRegMaster
				def municipalSolidWasteInstance = MunicipalSolidWaste.get( params.muId )
					def municipalId=municipalSolidWasteInstance.id
					def checkFileList=WasteManagementFile.findAll("from WasteManagementFile as wmf where wmf.applicationId=? order by wmf.id desc",[municipalId])
					if(municipalSolidWasteInstance) {
						if(params.version) {
							def version = params.version.toLong()
							if(municipalSolidWasteInstance.version > version) {
								municipalSolidWasteInstance.errors.rejectValue("version", "municipalSolidWaste.optimistic.locking.failure", "Another user has updated this MunicipalSolidWaste while you were editing.")
								render(view:'edit',model:[municipalSolidWasteInstance:municipalSolidWasteInstance])
								return
							}
						}
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						def date = new Date();
						def t = dateFormat.format(date)    
						municipalSolidWasteInstance.nameNodal=params.nameNodal
						municipalSolidWasteInstance.desigNodal=params.desigNodal
						if(params.authApp=="Settingup&operationofwasteprocessingfacility")
						{
							municipalSolidWasteInstance.authApp="Setting up & operation of waster processing facility"
						}
						else
						{
							municipalSolidWasteInstance.authApp="Setting up & operation of disposal facility"
						}
						municipalSolidWasteInstance.authorizationType=params.authorizationType
						municipalSolidWasteInstance.locationSite=params.locationSite
						municipalSolidWasteInstance.qtyProcessed=(params.qtyProcessed).toLong()    
						def unitMasterInstance=UnitMaster.get((params.(unitMasterobjqtyProd)).toLong())
						municipalSolidWasteInstance.unitMasterobjqtyPro=unitMasterInstance
						def ckeckMeasure=params.measuresPrevention
						municipalSolidWasteInstance.measuresPrevention=""
						if(ckeckMeasure.getClass().getName()=="java.lang.String")
						{
							municipalSolidWasteInstance.measuresPrevention=params.measuresPrevention
						}
						else
						{
							for(int i=0;i<ckeckMeasure.size();i++)
							{
								municipalSolidWasteInstance.measuresPrevention+=ckeckMeasure[i]
								municipalSolidWasteInstance.measuresPrevention+=","
							}
						}
						def msaf=params.measureSafety
						municipalSolidWasteInstance.measuresSafety=""
						if(msaf.getClass().getName()=="java.lang.String")
						{
							municipalSolidWasteInstance.measuresSafety=params.measureSafety
						}
						else
						{
							for(int i=0;i<msaf.size();i++)
							{
								municipalSolidWasteInstance.measuresSafety+=msaf[i]
								municipalSolidWasteInstance.measuresSafety+=","
							}
						}
						def mpol=params.measurePollution
						municipalSolidWasteInstance.measuresPollution=""
						if(mpol.getClass().getName()=="java.lang.String")
						{
							municipalSolidWasteInstance.measuresPollution=params.measurePollution
						}
						else
						{
							for(int i=0;i<mpol.size();i++)
							{
								municipalSolidWasteInstance.measuresPollution+=mpol[i]
								municipalSolidWasteInstance.measuresPollution+=","
							}
						}
						municipalSolidWasteInstance.invenstment=(params.invenstment).toLong()
						municipalSolidWasteInstance.expectedReturn=(params.expectedReturn).toLong()
						municipalSolidWasteInstance.nameWasteProcessingTech=params.nameWasteProcessingTech
						municipalSolidWasteInstance.dateCreated=dateFormat.parse(t)
						municipalSolidWasteInstance.createdBy=indRegInstance.indName
						municipalSolidWasteInstance.updatedBy=" "
						if(params.numSites == "")
						{
							municipalSolidWasteInstance.numSites=null
						}
						else
						{
							municipalSolidWasteInstance.numSites=(params.numSites).toLong()
						}
						if(params.qtyDisposed == "")
						{
							municipalSolidWasteInstance.qtyDisposed=null
						}
						else
						{
							municipalSolidWasteInstance.qtyDisposed=(params.qtyDisposed).toLong()
						}
						def unitMasterInstancedis=UnitMaster.get((params.unitMasterobjqtyDiss).toLong())
						municipalSolidWasteInstance.unitMasterobjqtyDis=unitMasterInstancedis
						municipalSolidWasteInstance.natureWaste=params.natureWaste
						municipalSolidWasteInstance.compWaste=params.compWaste
						municipalSolidWasteInstance.completionStatus=params.appStatus	
						municipalSolidWasteInstance.clarification=false
						municipalSolidWasteInstance.inspection=false
						municipalSolidWasteInstance.properties = params
						if(!municipalSolidWasteInstance.hasErrors() && municipalSolidWasteInstance.save()) {
							def atest=params.wasteManagementFileInstanceId
							if(checkFileList[0]!=null)
							{
								WasteManagementFile file=new WasteManagementFile()
								if(atest.getClass().getName()=="java.lang.String"){
									file=WasteManagementFile.get(params.wasteManagementFileInstanceId)
								}else{
									file=WasteManagementFile.get(params.wasteManagementFileInstanceId[0])
								}
								def f = request.getFile('processingTechnology')
								MultipartFile multi = request.getFile('processingTechnology')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of Processing Technology"
									file.createdBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="processingTechnology"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									if(file.save())
									{
									}
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('processingTechnology')
								MultipartFile multi = request.getFile('processingTechnology')
								if(f.empty) {
									processDetAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of Processing Technology"
									file.createdBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="processingTechnology"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									if(file.save())
									{
										processDetAttach = "Attached"
									}
								}
							}
							if(checkFileList[1]!=null)
							{
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[1])
								def f = request.getFile('siteclearence')
								MultipartFile multi = request.getFile('siteclearence')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Site clearence (from Local Authority)"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="siteclearence"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('siteclearence')
								MultipartFile multi = request.getFile('siteclearence')
								if(f.empty) {
									siteclearenceAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Site clearence (from Local Authority)"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="siteclearence"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									siteclearenceAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[2]!=null)
							{
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[2])
								def f = request.getFile('detail')
								MultipartFile multi = request.getFile('detail')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of agreement between municipal authority and operating agency"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="detail"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('detail')
								MultipartFile  multi = request.getFile('detail')
								if(f.empty) {
									detailAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of agreement between municipal authority and operating agency"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="detail"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									detailAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[3]!=null)
							{	
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[3])
								def f = request.getFile('utilizationprogramme')
								MultipartFile multi = request.getFile('utilizationprogramme')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Utilization programme for waste processed (Product utilization)"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="utilizationprogramme"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('utilizationprogramme')
								MultipartFile multi = request.getFile('utilizationprogramme')
								if(f.empty) {
									utilizationprogrammeAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Utilization programme for waste processed (Product utilization)"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="utilizationprogramme"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									utilizationprogrammeAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[4]!=null)
							{	
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[4])
								def f = request.getFile('methodology')
								MultipartFile multi = request.getFile('methodology')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Methodology for disposal of waste processing rejects (quantity and quality)"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="methodology"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def  f = request.getFile('methodology')
								MultipartFile multi = request.getFile('methodology')
								if(f.empty) {
									methodologyAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Methodology for disposal of waste processing rejects (quantity and quality)"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="methodology"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									methodologyAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[5]!=null)
							{	
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[5])
								def f = request.getFile('detailsexistingsite')
								MultipartFile multi = request.getFile('detailsexistingsite')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of Existing Site under construction"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="detailsexistingsite"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('detailsexistingsite')
								MultipartFile  multi = request.getFile('detailsexistingsite')
								if(f.empty) {
									detailsexistingsiteAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of Existing Site under construction"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="detailsexistingsite"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									detailsexistingsiteAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[6]!=null)
							{
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[6])
								def f = request.getFile('layoutmaps')
								MultipartFile multi = request.getFile('layoutmaps')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Layout maps of site"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="layoutmaps"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('layoutmaps')
								MultipartFile multi = request.getFile('layoutmaps')
								if(f.empty) {
									layoutmapsAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Layout maps of site"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="layoutmaps"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									layoutmapsAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[7]!=null)
							{
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[7])
								def f = request.getFile('detailmethodologyorcriteria')
								MultipartFile multi = request.getFile('detailmethodologyorcriteria')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of methodology or criteria followed for site selection"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="detailmethodologyorcriteria"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('detailmethodologyorcriteria')
								MultipartFile multi = request.getFile('detailmethodologyorcriteria')
								if(f.empty) {
									detailmethodologyorcriteriaAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Details of methodology or criteria followed for site selection"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="detailmethodologyorcriteria"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									detailmethodologyorcriteriaAttach = "Attached"
									file.save()
								}
							}
							if(checkFileList[8]!=null)
							{
								WasteManagementFile file=new WasteManagementFile()
								file=WasteManagementFile.get(params.wasteManagementFileInstanceId[8])
								def f = request.getFile('methodologyoperationaldetails')
								MultipartFile multi = request.getFile('methodologyoperationaldetails')
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Methodology and operational details of landfilling"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="methodologyoperationaldetails"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									file.save()
								}
							}
							else
							{
								WasteManagementFile file=new WasteManagementFile()
								def f = request.getFile('methodologyoperationaldetails')
								MultipartFile multi = request.getFile('methodologyoperationaldetails')
								if(f.empty) {
									methodologyoperationaldetailsAttach = "Not Attached"
								}
								if(!f.empty) {
									file.size = multi.getSize() / 1024
									file.name =multi.getOriginalFilename()
									file.data=multi.getBytes() 
									file.extension = extractExtension( multi )
									file.description="Methodology and operational details of landfilling"
									file.createdBy=indRegInstance.indName
									file.updatedBy=indRegInstance.indName
									file.dateCreated=dateFormat.parse(t)
									file.lastUpdated=dateFormat.parse(t)
									file.typeOfFile="methodologyoperationaldetails"
									file.indreg=indRegInstance
									file.applicationId=municipalSolidWasteInstance.id
									file.applicationFor="Municipal Waste"
									methodologyoperationaldetailsAttach = "Attached"
									file.save()
								}
							}
							def appFor="MSW"
							def industryRegInstanceWaste=indRegInstance
							def app = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=?",[municipalId])
							def app1 = app.description
							if(app1.contains("Details of Processing Technology"))
							{
								processDetAttach = "Attached"
							}
							if(app1.contains("Site clearence (from Local Authority)"))
							{
								siteclearenceAttach = "Attached"
							}
							if(app1.contains("Utilization programme for waste processed (Product utilization)"))
							{
								utilizationprogrammeAttach = "Attached"
							}
							if(app1.contains("Methodology and operational details of landfilling"))
							{
								methodologyoperationaldetailsAttach = "Attached"
							}
							if(app1.contains("Details of agreement between municipal authority and operating agency"))
							{
								detailAttach = "Attached"
							}
							if(app1.contains("Methodology for disposal of waste processing rejects (quantity and quality)"))
							{
								methodologyAttach = "Attached"
							}
							if(app1.contains("Details of Existing Site under construction"))
							{
								detailsexistingsiteAttach = "Attached"
							}
							
							if(app1.contains("Layout maps of site"))
							{
								layoutmapsAttach = "Attached"
							}
							if(app1.contains("Details of methodology or criteria followed for site selection"))
							{
								detailmethodologyorcriteriaAttach = "Attached"
							}
							if(municipalSolidWasteInstance.completionStatus=="Completed"){
								RouteWasteManagement routeWaste=new RouteWasteManagement()
								def routed=routeWaste.routeWasteManagementApp(municipalSolidWasteInstance.id,appFor,industryRegInstanceWaste)
							}
							if(params.appStatus=="Completed"){
								def mswId = municipalSolidWasteInstance.id
								def industryName = indRegInstance.indName
								def industryAdd = params.Addr
								def industryCity = params.City
								def industryDist = params.District
								def industryTeh = params.Tehsil
								def industryTele = params.PhoneNo
								def industryPin = params.Pin
								def industryFax = params.FaxNo
								def address = industryAdd+ " , " +industryCity+ " , "+industryDist + " , "+industryTeh
								def nodalOfficer = params.nameNodal
								def nodalDesig = params.desigNodal
								def authorizationAppl = params.authApp
								def authorizationType = params.authorizationType
								def location = params.locationSite
								def nameWastePro = params.nameWasteProcessingTech
								def qtyProcessed = params.qtyProcessed
								def unitProcessed=municipalSolidWasteInstance.unitMasterobjqtyPro
								def qtyProcessedUnit = qtyProcessed+" "+unitProcessed
								def measurePrevention = municipalSolidWasteInstance.measuresPrevention
								def measureSafety = municipalSolidWasteInstance.measuresSafety
								def measurePollution = municipalSolidWasteInstance.measuresPollution
								def invest = params.invenstment
								def expectedReturn = params.expectedReturn
								def investReturn = invest+" and "+expectedReturn
								def sites = params.numSites
								def qtyDisposed = params.qtyDisposed
								def unitDisposed = municipalSolidWasteInstance.unitMasterobjqtyDis
								def qtyDisposedUnit = qtyDisposed+" "+unitDisposed
								def natureWaste = params.natureWaste
								def compWaste = params.compWaste
								def natureComp = natureWaste+" and "+compWaste
								MswPdfFile pdf = new MswPdfFile()
								File certFile
								certFile = pdf.mswPdfFunction(industryName,natureComp,qtyDisposedUnit,sites,investReturn,measurePollution,measureSafety,qtyProcessedUnit,measurePrevention,nameWastePro,location,authorizationType,authorizationAppl,address,industryTele,industryPin,industryFax,nodalOfficer,nodalDesig,processDetAttach,siteclearenceAttach,detailAttach,utilizationprogrammeAttach,methodologyAttach,detailsexistingsiteAttach,layoutmapsAttach,detailmethodologyorcriteriaAttach,methodologyoperationaldetailsAttach)
								byte[] b = new byte[(int) certFile.length()];
								FileInputStream fileInputStream = new FileInputStream(certFile);
								fileInputStream.read(b);
								WasteManagementFile file1=new WasteManagementFile()
								def fileLength=certFile.length()
								file1.applicationId = mswId
								file1.size = fileLength / 1024  //f.getSize() 
								file1.extension ="pdf"//extractExtension( f )
								file1.data=b;
								file1.name="MSWForm.pdf"
								file1.description="MSW Application Form"
								file1.createdBy= session.indUser
								file1.updatedBy=session.indUser
								file1.typeOfFile="MSWForm"
								file1.applicationFor="MSW"
								file1.indreg=indRegInstance
								if(file1.save()) {
								}
								else{
								}	
								flash.message = "Congratulations! Your Application No. ${municipalSolidWasteInstance.id} is submitted successfully." 
							}
							else
							{
								flash.message = "MunicipalSolidWaste ${municipalSolidWasteInstance.id} Submitted for further modification"
							}
							redirect(action:show,id:municipalSolidWasteInstance.id)
						}
						else {
							render(view:'edit',model:[municipalSolidWasteInstance:municipalSolidWasteInstance])
						}
					}
					else {
						flash.message = "MunicipalSolidWaste not found with id ${params.id}"
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
			 def industryId = session.indUser
				if(industryId==null || industryId=="")
				{
					redirect(controller:"userMaster",action:"logout")
				}
				def municipalSolidWasteInstance = new MunicipalSolidWaste()
				IndUser indUserInstance=(IndUser)session.indUser
				def induserQuery=IndUser.get(indUserInstance.id)
				def measureMasterInstance=new MeasureMaster()
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				municipalSolidWasteInstance.properties = params
				return ['municipalSolidWasteInstance':municipalSolidWasteInstance,indRegInstanceId:indRegInstanceId,measureMasterInstance:measureMasterInstance,indRegInstanceGet:indRegInstanceGet]
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
			 def industryId = session.indUser
				if(industryId==null || industryId=="")
				{
					redirect(controller:"userMaster",action:"logout")
				}
				IndUser indUserInstance=(IndUser)session.indUser
				def indRegInstance=indUserInstance.industryRegMaster
				def indusrtyInstance=IndustryRegMaster.get((params.indRegId).toLong())
					def municipalSolidWasteInstance = new MunicipalSolidWaste(params)
					municipalSolidWasteInstance.indRegMasterObj=indusrtyInstance
					println("municipalSolidWasteInstance.indRegMasterObj---"+municipalSolidWasteInstance.indRegMasterObj)
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					def date = new Date();
					def t = dateFormat.format(date)
					municipalSolidWasteInstance.nameNodal=params.nameNodal
					municipalSolidWasteInstance.desigNodal=params.desigNodal
					if(params.authApp=="Settingup&operationofwasteprocessingfacility")
					{
						municipalSolidWasteInstance.authApp="Setting up & operation of waster processing facility"
					}
					else
					{
						municipalSolidWasteInstance.authApp="Setting up & operation of disposal facility"
					}
					municipalSolidWasteInstance.authorizationType=params.authorizationType
					municipalSolidWasteInstance.locationSite=params.locationSite
					municipalSolidWasteInstance.qtyProcessed=(params.qtyProcessed).toLong()
					
					def unitMasterInstance=UnitMaster.get((params.(unitMasterobjqtyProd)).toLong())
					municipalSolidWasteInstance.unitMasterobjqtyPro=unitMasterInstance
					def ckeckMeasure=params.measuresPrevention
					municipalSolidWasteInstance.measuresPrevention=""
					if(ckeckMeasure.getClass().getName()=="java.lang.String")
					{
						municipalSolidWasteInstance.measuresPrevention=params.measuresPrevention
					}
					else
					{
						for(int i=0;i<ckeckMeasure.size();i++)
						{
							municipalSolidWasteInstance.measuresPrevention+=ckeckMeasure[i]
							municipalSolidWasteInstance.measuresPrevention+=","
						}
					}
					def msaf=params.measureSafety
					municipalSolidWasteInstance.measuresSafety=""
					if(msaf.getClass().getName()=="java.lang.String")
					{
						municipalSolidWasteInstance.measuresSafety=params.measureSafety
					}
					else
					{
						for(int i=0;i<msaf.size();i++)
						{
							municipalSolidWasteInstance.measuresSafety+=msaf[i]
							municipalSolidWasteInstance.measuresSafety+=","
						}
					}
					def mpol=params.measurePollution
					municipalSolidWasteInstance.measuresPollution=""
					if(mpol.getClass().getName()=="java.lang.String")
					{
						municipalSolidWasteInstance.measuresPollution=params.measurePollution
					}
					else
					{
						for(int i=0;i<mpol.size();i++)
						{
							municipalSolidWasteInstance.measuresPollution+=mpol[i]
							municipalSolidWasteInstance.measuresPollution+=","
						}
					}
					municipalSolidWasteInstance.invenstment=(params.invenstment).toLong()
					municipalSolidWasteInstance.expectedReturn=(params.expectedReturn).toLong()
					municipalSolidWasteInstance.nameWasteProcessingTech=params.nameWasteProcessingTech
					municipalSolidWasteInstance.dateCreated=dateFormat.parse(t)
					municipalSolidWasteInstance.createdBy=indRegInstance.indName
					municipalSolidWasteInstance.updatedBy=" "
					
					if(params.numSites == "")
					{
						municipalSolidWasteInstance.numSites=null
					}
					else
					{
						municipalSolidWasteInstance.numSites=(params.numSites).toLong()
					}
					if(params.qtyDisposed == "")
					{
						municipalSolidWasteInstance.qtyDisposed=null
					}
					else
					{
						municipalSolidWasteInstance.qtyDisposed=(params.qtyDisposed).toLong()
					}
					def unitMasterInstancedis=UnitMaster.get((params.unitMasterobjqtyDiss).toLong())
					municipalSolidWasteInstance.unitMasterobjqtyDis=unitMasterInstancedis
					municipalSolidWasteInstance.natureWaste=params.natureWaste
					municipalSolidWasteInstance.compWaste=params.compWaste
					municipalSolidWasteInstance.completionStatus=params.appStatus	
					municipalSolidWasteInstance.clarification=false
					municipalSolidWasteInstance.inspection=false
					municipalSolidWasteInstance.applicationStatus="Inprogress"
					if(!municipalSolidWasteInstance.hasErrors() && municipalSolidWasteInstance.save()) {
						WasteManagementFile file=new WasteManagementFile()
						def f = request.getFile('processingTechnology')
						MultipartFile multi = request.getFile('processingTechnology')
						if(f.empty) {
									processDetAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Details of Processing Technology"
							file.createdBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="processingTechnology"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							if(file.save())
							{
								processDetAttach = "Attached"
							}
						}
						file=new WasteManagementFile()
						f = request.getFile('siteclearence')
						multi = request.getFile('siteclearence')
						if(f.empty) {
									siteclearenceAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Site clearence (from Local Authority)"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="siteclearence"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							siteclearenceAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('detail')
						multi = request.getFile('detail')
						if(f.empty) {
							detailAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Details of agreement between municipal authority and operating agency"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="detail"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							detailAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('utilizationprogramme')
						multi = request.getFile('utilizationprogramme')
						if(f.empty) {
							utilizationprogrammeAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Utilization programme for waste processed (Product utilization)"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="utilizationprogramme"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							utilizationprogrammeAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('methodology')
						multi = request.getFile('methodology')
						if(f.empty) {
							methodologyAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Methodology for disposal of waste processing rejects (quantity and quality)"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="methodology"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							methodologyAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('detailsexistingsite')
						multi = request.getFile('detailsexistingsite')
						if(f.empty) {
							detailsexistingsiteAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Details of Existing Site under construction"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="detailsexistingsite"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							detailsexistingsiteAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('layoutmaps')
						multi = request.getFile('layoutmaps')
						if(f.empty) {
							layoutmapsAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Layout maps of site"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="layoutmaps"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							layoutmapsAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('detailmethodologyorcriteria')
						multi = request.getFile('detailmethodologyorcriteria')
						if(f.empty) {
							detailmethodologyorcriteriaAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Details of methodology or criteria followed for site selection"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="detailmethodologyorcriteria"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							detailmethodologyorcriteriaAttach = "Attached"
							file.save()
						}
						file=new WasteManagementFile()
						f = request.getFile('methodologyoperationaldetails')
						multi = request.getFile('methodologyoperationaldetails')
						if(f.empty) {
							methodologyoperationaldetailsAttach = "Not Attached"
								}
						if(!f.empty) {
							file.size = multi.getSize() / 1024
							file.name =multi.getOriginalFilename()
							file.data=multi.getBytes() 
							file.extension = extractExtension( multi )
							file.description="Methodology and operational details of landfilling"
							file.createdBy=indRegInstance.indName
							file.updatedBy=indRegInstance.indName
							file.dateCreated=dateFormat.parse(t)
							file.lastUpdated=dateFormat.parse(t)
							file.typeOfFile="methodologyoperationaldetails"
							file.indreg=indRegInstance
							file.applicationId=municipalSolidWasteInstance.id
							file.applicationFor="Municipal Waste"
							methodologyoperationaldetailsAttach = "Attached"
							file.save()
						}
						def appFor="MSW"
						def industryRegInstanceWaste=indRegInstance
						if(municipalSolidWasteInstance.completionStatus=="Completed"){
							def mswId = municipalSolidWasteInstance.id
							def industryName = indRegInstance.indName
							def industryAdd = params.Addr
							def industryCity = params.City
							def industryDist = params.District
							def industryTeh = params.Tehsil
							def industryTele = params.PhoneNo
							def industryPin = params.Pin
							def industryFax = params.FaxNo
							def address = industryAdd+ " , " +industryCity+ " , "+industryDist + " , "+industryTeh
							def nodalOfficer = params.nameNodal
							def nodalDesig = params.desigNodal
							def authorizationAppl = params.authApp
							def authorizationType = params.authorizationType
							def location = params.locationSite
							def nameWastePro = params.nameWasteProcessingTech
							def qtyProcessed = params.qtyProcessed
							def unitProcessed=municipalSolidWasteInstance.unitMasterobjqtyPro
							def qtyProcessedUnit = qtyProcessed+" "+unitProcessed
							def measurePrevention = municipalSolidWasteInstance.measuresPrevention
							def measureSafety = municipalSolidWasteInstance.measuresSafety
							def measurePollution = municipalSolidWasteInstance.measuresPollution
							def invest = params.invenstment
							def expectedReturn = params.expectedReturn
							def investReturn = invest+" and "+expectedReturn
							def sites = params.numSites
							def qtyDisposed = params.qtyDisposed
							def unitDisposed = municipalSolidWasteInstance.unitMasterobjqtyDis
							def qtyDisposedUnit = qtyDisposed+" "+unitDisposed
							def natureWaste = params.natureWaste
							def compWaste = params.compWaste
							def natureComp = natureWaste+" and "+compWaste
							MswPdfFile pdf = new MswPdfFile()
							File certFile
							certFile = pdf.mswPdfFunction(industryName,natureComp,qtyDisposedUnit,sites,investReturn,measurePollution,measureSafety,qtyProcessedUnit,measurePrevention,nameWastePro,location,authorizationType,authorizationAppl,address,industryTele,industryPin,industryFax,nodalOfficer,nodalDesig,processDetAttach,siteclearenceAttach,detailAttach,utilizationprogrammeAttach,methodologyAttach,detailsexistingsiteAttach,layoutmapsAttach,detailmethodologyorcriteriaAttach,methodologyoperationaldetailsAttach)
							byte[] b = new byte[(int) certFile.length()];
							FileInputStream fileInputStream = new FileInputStream(certFile);
							fileInputStream.read(b);
							WasteManagementFile file1=new WasteManagementFile()
							def fileLength=certFile.length()
							file1.applicationId = mswId
							file1.size = fileLength / 1024  //f.getSize() 
							file1.extension ="pdf"//extractExtension( f )
							file1.data=b;
							file1.name="MSWForm.pdf"
							file1.description="MSW Application Form"
							file1.createdBy= session.indUser
							file1.updatedBy=session.indUser
							file1.typeOfFile="MSWForm"
							file1.applicationFor="MSW"
							file1.indreg=indRegInstance
							if(file1.save()) {
							}
							else{
							}	
							flash.message = "Congratulations! Your Application No. ${municipalSolidWasteInstance.id} is submitted successfully." 
							RouteWasteManagement routeWaste=new RouteWasteManagement()
							def routed=routeWaste.routeWasteManagementApp(municipalSolidWasteInstance.id,appFor,industryRegInstanceWaste)
						}
						println("municipalSolidWasteInstance.indRegMasterObj---"+municipalSolidWasteInstance.indRegMasterObj)
						redirect(action:show,id:municipalSolidWasteInstance.id)
					}
					else {
						render(view:'create',model:[municipalSolidWasteInstance:municipalSolidWasteInstance])
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
	
def printMunicipalSolidWaste={
			 try {
				 def industryId = session.indUser
					def municipalSolidWasteInstance = MunicipalSolidWaste.get( (params.id).toLong() )
					def industryRegId=municipalSolidWasteInstance.indRegMasterObj
					def wastefileattachList=WasteManagementFile.findAllWhere(applicationId : municipalSolidWasteInstance.id)
					if(!municipalSolidWasteInstance) {
						flash.message = "Municipal Solid Waste not found with id ${params.id}"
						redirect(action:show)
					}
					else { 
						return [ municipalSolidWasteInstance : municipalSolidWasteInstance ,industryRegId:industryRegId,wastefileattachList:wastefileattachList] 
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
	
def printMunicipalSolidWaste1={
			 try {
				 def industryId = session.indUser
					def municipalSolidWasteInstance = MunicipalSolidWaste.get( (params.id).toLong() )
					def industryRegId=municipalSolidWasteInstance.indRegMasterObj
					def wastefileattachList=WasteManagementFile.findAllWhere(applicationId : municipalSolidWasteInstance.id)
					if(!municipalSolidWasteInstance) {
						flash.message = "Municipal Solid Waste not found with id ${params.id}"
						redirect(action:show)
					}
					else {
						render(view:'printMunicipalSolidWaste',model:[ municipalSolidWasteInstance : municipalSolidWasteInstance ,industryRegId:industryRegId,wastefileattachList:wastefileattachList] )
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

def genCertMunicipalNew={
			 try {
				 def userId = session.userMaster
					if(userId==null || userId=="")
					{
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def municipalSolidInstance = MunicipalSolidWaste.get( (params.id))
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=municipalSolidInstance.indRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					if(!municipalSolidInstance) {
						flash.message = "BioMedicalWaste not found with id ${params.id}"
						redirect(action:list)
					}
					else {
						return [ municipalSolidInstance : municipalSolidInstance , indRegInstanceGet:indRegInstanceGet , id:municipalSolidInstance.id] }
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
	
def generateMunicipalNewCert={
			 try {
				 def userId = session.userMaster
					if(userId==null || userId=="")
					{
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def municipalInstance = MunicipalSolidWaste.get( (params.id))
					def muid=municipalInstance.id
					def app = WasteManagementPendingDetails.findByApplicationId(muid.toString())
					def id=app.id
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=municipalInstance.indRegMasterObj
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
					def industryPhone=indRegInstanceGet.indPhoneNo+""
					def copyTo=params.copyTo
					def authorizationNumber=params.authNo
					def letternumber=params.letterNo
					def noticeDate=params.noticeDate_value
					def terms=params.termsco
					ArrayList chk=new ArrayList()
					WasteManagementCertificates file=new WasteManagementCertificates()
					MunicipalSolidCertNew cert=new MunicipalSolidCertNew()
					def certFile=cert.municipalCert(industryPhone,industryName,industryAddress,industryTehsil,industryDistrict,authorizationNumber,letternumber,noticeDate,terms,copyTo,id.toString())
					byte[] b = new byte[(int) certFile.length()];
					FileInputStream fileInputStream = new FileInputStream(certFile);
					fileInputStream.read(b);
					def fileLength=certFile.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.name=(muid.toString()).concat("MunicipalSolidWaste(New)").concat(".pdf")
					file.description="Municipal Solid Waste - New Generation Record"
					file.createdBy=indRegInstance.indName//"abc"//session.userMaster
					file.updatedBy=indRegInstance.indName//"xyz"//session.userMaster
					file.typeOfFile="MSW"
					file.indreg=indRegInstanceGet
					file.applicationId=muid
					file.applicationFor="MSW"
					file.dateCreated=currentDate
					def wastecert
					def fileid = null
					if(file.save()) {
						fileid=file.id
						flash.userMessage = "Municipal Solid Waste - New Certificate is generated properly."
						checkForView=true
						redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
					}
					else {
					flash.userMessage = "Municipal Solid Waste - New Certificate is not generated."
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
	
def genCertMunicipalReNew={
			 try {
				 def userId = session.userMaster
					if(userId==null || userId=="")
					{
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}
					def municipalSolidInstance = MunicipalSolidWaste.get( (params.id))
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=municipalSolidInstance.indRegMasterObj
					def indRegInstanceId=indRegInstance.id
					def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
					if(!municipalSolidInstance) {
						
						flash.message = "BioMedicalWaste not found with id ${params.id}"
						redirect(action:list)
					}
					else {
						return [ municipalSolidInstance : municipalSolidInstance , indRegInstanceGet:indRegInstanceGet , id:municipalSolidInstance.id] }
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
	
def generateMunicipalReNewCert={
			 try {
				 def userId = session.userMaster
					if(userId==null || userId=="")
					{
						flash.message="Your session has been expired ! Please login again."
						redirect(controller:"userMaster",action:"logout")
					}	
					def municipalInstance = MunicipalSolidWaste.get( (params.id))
					def muid=municipalInstance.id
					def app = WasteManagementPendingDetails.findByApplicationId(muid.toString())
					def id=app.id
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=municipalInstance.indRegMasterObj
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
					def industryPhone=indRegInstanceGet.indPhoneNo+""
					def copyTo=params.copyTo
					def authorizationNumber=params.authNo
					def letternumber=params.letterNo
					def noticeDate=params.noticeDate_value
					def terms=params.termsco
					ArrayList chk=new ArrayList()
					WasteManagementCertificates file=new WasteManagementCertificates()
					MunicipalSolidCertReNew cert=new MunicipalSolidCertReNew()
					def certFile=cert.municipalCertRenew(industryPhone,industryName,industryAddress,industryTehsil,industryDistrict,authorizationNumber,letternumber,noticeDate,terms,copyTo,id.toString())
					byte[] b = new byte[(int) certFile.length()];
					FileInputStream fileInputStream = new FileInputStream(certFile);
					fileInputStream.read(b);
					def fileLength=certFile.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.name=(muid.toString()).concat("MunicipalSolidWaste(ReNew)").concat(".pdf")
					file.description="Municipal Solid Waste - ReNew Generation Record"
					file.createdBy=indRegInstance.indName//"abc"//session.userMaster
					file.updatedBy=indRegInstance.indName//"xyz"//session.userMaster
					file.typeOfFile="MSW"
					file.indreg=indRegInstanceGet
					file.applicationId=muid
					file.applicationFor="MSW"
					file.dateCreated=currentDate
					def wastecert
					def fileid = null
					if(file.save()) {
						fileid=file.id
						flash.userMessage = "Municipal Solid Waste - New Certificate is generated properly."
						checkForView=true
						redirect(controller:"wasteManagementProcessingDetails" , action:"appProcessing", params:[id:id,checkForView:checkForView,fileid:fileid])
					}
					else {
						flash.userMessage = "Municipal Solid Waste - New Certificate is not generated."
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
	
def viewMunCert={
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
	
def viewMunCert1={
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
	
def viewMswPdf={
			 try {
				 def app = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? order by crf.id desc",[(params.appliLoc).toLong()])
					def appli = app.description
					def appSize = app.extension
					def application1 = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='MSWForm' order by crf.id desc",[(params.appliLoc).toLong()],[max:1])
					if(application1){
						def application=application1[0]
						def applicationInstance = application
						response.setContentType( "application-xdownload")
						response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
						response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
					}
					else {
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
