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


public class PlasticWasteController{

	
	def extractExtension( MultipartFile file ) {
		String filename = file.getOriginalFilename()
		return filename.substring(filename.lastIndexOf( "." ) + 1 )
	}
	
	
	def create = {

		    	def industryId = session.indUser
		    	if(industryId==null || industryId=="")
		        {
		              redirect(controller:"userMaster",action:"logout")
		        }

				IndUser indUserInstance=(IndUser)session.indUser
		    	def wasteManagementpendingDetails= WasteManagementPendingDetails.findAll("from WasteManagementPendingDetails wmp where wmp.indRegInstance=? and wmp.applicationStatus='pending' and applicationFor='PWM'",[indUserInstance.industryRegMaster])
		    	
		    	
		    	
				def induserQuery=IndUser.get(indUserInstance.id)
			
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
		    	def PlasticWasteInstanceOld1 = PlasticWaste.find("from PlasticWaste abc where abc.industryRegMasterObj=? and (applicationStatus='approved' or applicationStatus='rejected' or applicationStatus='pending') order by  applicationStatus ",[indRegInstanceGet])
		    	def plasticWasteInstance = new PlasticWaste()
				String authReqFor=""
					if(params['chkProducers']=="on") {
							authReqFor=authReqFor.concat("Producers of Carry Bags and Containers")
							authReqFor=authReqFor.concat(",")
						}
				        if(params['chkRecycling']=="on") {
							authReqFor=authReqFor.concat("Recycling or Processing waste")
							authReqFor=authReqFor.concat(",")
						}
						if(params['chkManufacturer']=="on") {
							authReqFor=authReqFor.concat("Manufacturer of Plastic to be used as raw material")
							authReqFor=authReqFor.concat(",")
						}
						
						
						if(authReqFor.length()>0)
						{
							authReqFor = authReqFor.substring(0, authReqFor.length() - 1);	
						}
					
						
				plasticWasteInstance.applicationFor=authReqFor
				plasticWasteInstance.industryRegMasterObj=indRegInstanceGet
				plasticWasteInstance.nameOfApplicant=""
				plasticWasteInstance.authorisationAppliedFor = ""
				plasticWasteInstance.activityAuthorizationSoughtFor=""
				plasticWasteInstance.previousAuthNo=""
				plasticWasteInstance.manufactoringCapacity=""
				plasticWasteInstance.authorizationType=""
				plasticWasteInstance.previousAuthDate=new Date()
				plasticWasteInstance.createdBy = ""
				plasticWasteInstance.updatedBy = ""
				plasticWasteInstance.dateCreated = new Date()
				plasticWasteInstance.lastUpdated = new Date()
				
				plasticWasteInstance.prevExpDate = new Date()
				plasticWasteInstance.waterValidity = new Date()
				plasticWasteInstance.airValidity = new Date()
				plasticWasteInstance.authorizationValidity = new Date()
					
				plasticWasteInstance.clarification = false
				plasticWasteInstance.inspection = false
				plasticWasteInstance.showCause = false
				plasticWasteInstance.applicationStatus = "Inprogress"
				plasticWasteInstance.completionStatus = "Inprogress"
				if(session.cafUniqueNo){
					plasticWasteInstance.cafUniqueNo=session.cafUniqueNo
				}else{
					plasticWasteInstance.cafUniqueNo=""
				}
				if(session.serviceId){
					plasticWasteInstance.serviceId=session.serviceId
				}else{
					plasticWasteInstance.serviceId=""
				}
				if(session.cafUniqueNo && session.serviceId){
					plasticWasteInstance.singleWin=true
				}else{
					plasticWasteInstance.singleWin=false
				}
				
				
				
					if(plasticWasteInstance.save(flush:true))
					{
					}
					else{

	    				plasticWasteInstance.errors.each {
	    			        println it
	    			   }
	    			
						
					}
				println("PlasticWasteController---indRegInstance---"+indRegInstance)
		            return ['PlasticWasteInstance':plasticWasteInstance,indRegInstanceGet:indRegInstanceGet,indRegInstance:indRegInstance]
	}
	
	
def show={

        	
        	def industryId = session.indUser
        	if(industryId==null || industryId=="")
            {
                  redirect(controller:"userMaster",action:"logout")
            }
        
            def plasticWasteInstance = PlasticWaste.get( params.id ) 
            def indusrtyInstance=IndustryRegMaster.get((plasticWasteInstance.industryRegMasterObj.id).toLong())
            def appId=plasticWasteInstance.id
            def appFor="PWM"
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
        	
    		
            render(view:'show',model:[indusrtyInstance:indusrtyInstance,certInstanceId:certInstanceId, plasticWasteInstance : plasticWasteInstance ,indRegInstance:indRegInstance , id:plasticWasteInstance.id ]) 
    }

	
	def edit = {

			def testValue=params.testValue
			println("===testValue===="+testValue)
	    	def industryId = session.indUser
	    	if(industryId==null || industryId=="")
	        {
	              redirect(controller:"userMaster",action:"logout")
	        }
	        def plasticWasteInstance = PlasticWaste.get(params.id)
	        String aasf=plasticWasteInstance.activityAuthorizationSoughtFor
	        
	        def tmp=aasf.split(",")
	        ArrayList tmp1=new ArrayList()
	    	for(int i=0;i<tmp.size();i++)
	    	{
	    		tmp1.add(tmp[i])
	    	}
	        
	    	for(int i=0;i<tmp1.size();i++)
	    	{
	    	}
	        
	        
	        
	        IndUser indUserInstance=(IndUser)session.indUser
			def induserQuery=IndUser.get(indUserInstance.id)
			
			
			def indRegInstance=indUserInstance.industryRegMaster
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
			
	        if(!plasticWasteInstance) {
	            flash.message = "plasticWaste not found with id ${params.id}"
	            redirect(action:list)
	        }
	        else {
	        	println("tmp---%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%-"+tmp1)
	            return ['PlasticWasteInstance':plasticWasteInstance,indRegInstance:indRegInstance,indRegInstanceGet:indRegInstanceGet,tmp1:tmp1,testValue:testValue]
	        }
	    
	}
	
	def save = {
			    println("PARAMS----------"+params);
			    def appFor="PWM"
				def file
				def DistrictPlan1 = "Not Attached"
				def Manufacturing1 = "Not Attached"
				def Collection1 = "Not Attached"
				def analysis1 = "Not Attached"
				def enclosure1 = "Not Attached"
				def consentWater1 = "Not Attached"
				def consentAir1 = "Not Attached"
				def personalBrand1 = "Not Attached"
				def supplyingPlastic1 = "Not Attached"
				def producersQuantum1 = "Not Attached"
		    	def industryId = session.indUser
		    	def testValue=params.testValue
		    	if(industryId==null || industryId=="")
		        {
		              redirect(controller:"userMaster",action:"logout")
		        }
		    
		       def indusrtyInstance=IndustryRegMaster.get((params.indRegId).toLong())
		        def plasticWasteInstance =	PlasticWaste.get((params.indAppDetId).toLong())
		    	plasticWasteInstance.industryRegMasterObj=indusrtyInstance
		    	IndUser indUserInstance=(IndUser)session.indUser
		    	def indRegInstance=indUserInstance.industryRegMaster
		    	if(params.applicantName){
		    		indusrtyInstance.occName=params.applicantName
		    		}
		       if(params.applicantDesignation){
		   			indusrtyInstance.occDesignation=params.applicantDesignation
		      		}
		       if(params.industryName){
		    	   indusrtyInstance.indName=params.industryName
				}
		       if(params.industryAddress){
		    	   indusrtyInstance.indAddress=params.industryAddress
				}
				if(params.industryAddress){
			    	   indusrtyInstance.indAddress=params.industryAddress
					}
					if(params.indCapInvt){
				    	   indusrtyInstance.indCapInvt=(params.indCapInvt).toFloat()
						}	
						/*if(params.City){
					    	   indusrtyInstance.occCity=params.City
							}
							if(params.District){
						    	   indusrtyInstance.occDistrict=params.District
								}
								if(params.Tehsil){
							    	   indusrtyInstance.occTehsil=params.Tehsil
									}*/
									if(params.Pin){
								    	   indusrtyInstance.indPin=params.Pin
										}
										if(params.indPhoneCode){
									    	   indusrtyInstance.indPhoneCode=params.indPhoneCode
											}
											if(params.indPhoneNo){
										    	   indusrtyInstance.indPhoneNo=params.indPhoneNo
												}
												if(params.indFaxCode){
											    	   indusrtyInstance.indFaxCode=params.indFaxCode
													}
													if(params.indFaxNo){
												    	   indusrtyInstance.indFaxNo=params.indFaxNo
														}
														if(params.Mobile){
													    	   indusrtyInstance.occMobile=params.Mobile
															}
															if(params.Email){
														    	   indusrtyInstance.indEmail=params.Email
																}
																if(params.expNoEmp){
															    	   indusrtyInstance.expNoEmp=params.expNoEmp
																	}
				
																println("plasticWaste---params---"+params)
																//def b12 = params.dateOfCom
																//def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
																//indusrtyInstance.dateOfComm= params.dateOfCom											
							
					
		            if(indusrtyInstance.save(flush:true))
		            				{
		            	println("savedddddddddd")
		            					 
		            					
		            				}
		            				else{
		            					println("not savedddddddddd")	

		                				indusrtyInstance.errors.each {
		                			        println it
		                			   }}
			
		            
		            def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
		            
		            String authReqFor=""
		    			
		        		if(params['chkGeneration']=="on") {
		    				authReqFor=authReqFor.concat("Generation during manufacturing or refurbishing")
		    				authReqFor=authReqFor.concat(",")
		    			}
		        	
		    			if(params['chkTreatment']=="on") {
		    				authReqFor=authReqFor.concat("Treatment if any")
		    				authReqFor=authReqFor.concat(",")
		    			}
		    			
		    			if(params['chkStorage']=="on") {
		    				authReqFor=authReqFor.concat("CollectionTransportationStorage")
		    				authReqFor=authReqFor.concat(",")
		    			}
		    			if(params['chkRefurbishing']=="on") {
		    				authReqFor=authReqFor.concat("Refurbishing")
		    				authReqFor=authReqFor.concat(",")
		    			}
		    			
		    			authReqFor = authReqFor.substring(0, authReqFor.length() - 1);
		    			plasticWasteInstance.activityAuthorizationSoughtFor=authReqFor
		        	    
		    			plasticWasteInstance.authorisationAppliedFor=params.authorisationAppliedFor
		    			plasticWasteInstance.manufactoringCapacity=params.manufactoringCapacity

		    			
		    			def x22 = sdfh1.parse(params.waterValidity_value);
		        		java.util.Date sqlDate22 = new java.util.Date(x22.getTime())
		        		plasticWasteInstance.waterValidity=sqlDate22;
		        		
		        		
		        		def x33 = sdfh1.parse(params.airValidity_value);
		        		java.util.Date sqlDate33 = new java.util.Date(x33.getTime())
		        		plasticWasteInstance.airValidity=sqlDate33;
		        		
		        		
		        		def x44 = sdfh1.parse(params.authorizationValidity_value);
		        		java.util.Date sqlDate44 = new java.util.Date(x44.getTime())
		        		plasticWasteInstance.authorizationValidity=sqlDate44;
		    			
		    			
		    			
		    			plasticWasteInstance.createdBy=indRegInstance.indName
		    			if(testValue=="true"){
		    				
		    			}else{
		    			plasticWasteInstance.completionStatus="Inprogress"
		    			}
		    			plasticWasteInstance.clarification=false
		    			plasticWasteInstance.showCause=false
		    			plasticWasteInstance.inspection=false
		    			plasticWasteInstance.updatedBy=""
		    			if(testValue=="true"){
		    				
		    			}else{
		    			plasticWasteInstance.applicationStatus=params.appStatus
		    			}
		    			plasticWasteInstance.districtIndustriesCenter=params.districtIndustriesCenter1
		    			plasticWasteInstance.detailsDisposalFacility=params.detailsDisposalFacility
		    			plasticWasteInstance.namePlastic=params.namePlastic
		    			plasticWasteInstance.quantityPlastic=params.quantityPlastic
		    			plasticWasteInstance.occupationalFacilities=params.occupationalFacilities
		    			plasticWasteInstance.emmisionEffulant=params.emmisionEffulant
		    			plasticWasteInstance.emmisionEffulantDetails=params.emmisionEffulantDetails
		    			plasticWasteInstance.unitCompliance=params.unitCompliance
		    			plasticWasteInstance.materialProceed=params.materialProceed
		    			plasticWasteInstance.materialHandled=params.materialHandled
		    			plasticWasteInstance.otherInfor=params.otherInfor
		    			plasticWasteInstance.enclosure=params.enclosure
		    			plasticWasteInstance.thiknessRulz=params.thiknessRulz
		    			plasticWasteInstance.waterAct=params.waterAct
		    			plasticWasteInstance.airAct=params.airAct
		    			plasticWasteInstance.actionPlan=params.actionPlan
		    			plasticWasteInstance.unitLocation=params.unitLocation
		    			
		    			
		    			
		    			
			
		    			if(!plasticWasteInstance.hasErrors() && plasticWasteInstance.save()) {
		    				
		    				
		    				def consentFeeMasterInstance = new ConsentFeeMasterPWM()
		    				def calculatedfee = ConsentFeeMasterPWM.findByApplication(plasticWasteInstance)
		    	    		println("calculatedfee..........."+calculatedfee)
		    	    		if(calculatedfee){
		    	    			
		    	    			calculatedfee.delete()
		    	    			
		    	    		}
		    	    		println("feesinstanceBMW...222222........")
		    	    		consentFeeMasterInstance.application = plasticWasteInstance
		    	    		if(params.yearsApplied != ""){
		    	    			consentFeeMasterInstance.noOfYears = (params.yearsApplied).toLong()
		    	    		}
		    	    		else{
		    	    			consentFeeMasterInstance.noOfYears = 0
		    	    		}
		    	    		println("feesinstanceBMW....333333333.......")
		    	    		if(params.feeApplicable != ""){
		    	     			consentFeeMasterInstance.calculatedFee = (params.feeApplicable).toLong()
		    	    		
		    	    		}
		    	    		else{
		    	    			consentFeeMasterInstance.calculatedFee = 0
		    	    		}
		    	    		println("feesinstanceBMW...44444........")
		    	    		consentFeeMasterInstance.save()
		    				
		    				
		    				
		    				
		 ///////////////////////////////////////////////attachment added/////////////////////////////////////////////////////
		 
		 
		 /////////////unit registered with District Industries Centre of the State Goverment///////////////////
		    				file = new WasteManagementFile()
		    		    	def layoutMap = request.getFile('attachDistrictPlan1');
		    		    	def layoutMapDoc = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachDistrictPlan' and abc.description='registered with District Industries Centre' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	println("layoutMap---"+layoutMap)
		    		    	println("layoutMapDoc---"+layoutMapDoc) 
		    		    	if(layoutMap!=null)
		    		    	{

		    		    	    if(!layoutMap.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(layoutMapDoc){
		    		    	    		println(" inside ## ifff layoutMapDoc 1111111111") 
		    		    	    	//	if()
		    		    	    		def layoutMapDocInstance = layoutMapDoc
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('attachDistrictPlan1')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="registered with District Industries Centre"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachDistrictPlan"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			DistrictPlan1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def layoutMapDoc1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachDistrictPlan' and abc.description='registered with District Industries Centre' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(layoutMapDoc1){
		    		    		DistrictPlan1 = "Attached"
		    				}
               ///////////end////////////
               
               ///////////////////Manufacturing Process////////////
               
		    		    	file = new WasteManagementFile()
		    		    	def layoutMap1 = request.getFile('processManufacturing');
		    		    	def layoutMapDoc111 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProcessManufacturing' and abc.description='Manufacturing Process' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(layoutMap1!=null)
		    		    	{

		    		    	    if(!layoutMap1.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(layoutMapDoc111){
		    		    	    		println(" inside ## ifff layoutMapDoc 2222222222222")
		    		    	    		def layoutMapDocInstance = layoutMapDoc111[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('processManufacturing')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="Manufacturing Process"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachProcessManufacturing"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			Manufacturing1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def layoutMapDoc11 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProcessManufacturing' and abc.description='Manufacturing Process' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(layoutMapDoc11){
		    		    		Manufacturing1 = "Attached"
		    				}
               
               
               //////////////////end///////
		 
              ///////////////// Waste Collection and transportation details///////////
              
		    		    	file = new WasteManagementFile()
		    		    	def collection = request.getFile('wasteCollectionDetails');
		    		    	def collectionDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachWasteCollection' and abc.description='Waste Collection and transportation details' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(collection!=null)
		    		    	{

		    		    	    if(!collection.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(collectionDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 3333333333")
		    		    	    		def layoutMapDocInstance = collectionDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('wasteCollectionDetails')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="Waste Collection and transportation details"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachWasteCollection"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			Collection1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def collectionDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachWasteCollection' and abc.description='Waste Collection and transportation details' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(collectionDetails1){
		    		    		Collection1 = "Attached"
		    				}
              
              
              //////////////////end//////////
              
              /////////////////////analysis report//////////////////
              
              
		    		    	file = new WasteManagementFile()
		    		    	def analysis = request.getFile('attachmentAnalysis');
		    		    	def analysisDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachAnalysisReport' and abc.description='analysis report' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(analysis!=null)
		    		    	{

		    		    	    if(!analysis.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(analysisDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 44444444")
		    		    	    		def layoutMapDocInstance = analysisDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('attachmentAnalysis')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="analysis report"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachAnalysisReport"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			analysis1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def analysisDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachAnalysisReport' and abc.description='analysis report' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(analysisDetails1){
		    		    		analysis1 = "Attached"
		    				}
              
              
              ///////////////////////end//////
              
              ////////////////////////List of enclosure as per rule///////////
		    		    	file = new WasteManagementFile()
		    		    	def enclosure = request.getFile('attachEnclosure');
		    		    	def enclosureDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachEnclosure' and abc.description='List of enclosure as per rule' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(enclosure!=null)
		    		    	{

		    		    	    if(!enclosure.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(enclosureDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 5555555555")
		    		    	    		def layoutMapDocInstance = enclosureDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('attachEnclosure')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="List of enclosure as per rule"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachEnclosure"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			enclosure1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def enclosureDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachEnclosure' and abc.description='List of enclosure as per rule' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(enclosureDetails1){
		    		    		enclosure1 = "Attached"
		    				}
              ///////////////////end/////////////
              ////////////////////////consent under the Water (Prevention and control of pollution) Act,1974///////////
		    		    	file = new WasteManagementFile()
		    		    	def consentWater = request.getFile('waterActAttatch');
		    		    	def consentWaterDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentWater' and abc.description='consent under the Water' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(consentWater!=null)
		    		    	{

		    		    	    if(!consentWater.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(consentWaterDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 566666666666")
		    		    	    		def layoutMapDocInstance = consentWaterDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('waterActAttatch')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="consent under the Water"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachConsentWater"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			consentWater1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def consentWaterDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentWater' and abc.description='consent under the Water' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(consentWaterDetails1){
		    		    		consentWater1 = "Attached"
		    				}
              ///////////////////end/////////////
              ////////////////////////consent under the Air (Prevention and control of pollution) Act,1981///////////
		    		    	file = new WasteManagementFile()
		    		    	def consentAir = request.getFile('airActAttatch');
		    		    	def consentAirDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentAir' and abc.description='consent under the Air' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(consentAir!=null)
		    		    	{

		    		    	    if(!consentAir.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(consentAirDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 77777777777")
		    		    	    		def layoutMapDocInstance = consentAirDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('airActAttatch')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="consent under the Air"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachConsentAir"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			consentAir1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def consentAirDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentAir' and abc.description='consent under the Air' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(consentAirDetails1){
		    		    		consentAir1 = "Attached"
		    				}
              ///////////////////end/////////////
//////////////////////// list of personal or Brand owners///////////
		    		    	file = new WasteManagementFile()
		    		    	def personalBrand = request.getFile('brandOwner');
		    		    	def personalBrandDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachPersonalBrand' and abc.description='list of personal or Brand owners' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(personalBrand!=null)
		    		    	{

		    		    	    if(!personalBrand.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(personalBrandDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 888888888")
		    		    	    		def layoutMapDocInstance = personalBrandDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('brandOwner')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="list of personal or Brand owners"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachPersonalBrand"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			personalBrand1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def personalBrandDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachPersonalBrand' and abc.description='list of personal or Brand owners' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(personalBrandDetails1){
		    		    		personalBrand1 = "Attached"
		    				}
              ///////////////////end/////////////
              //////////////////////// list of person supplying plastic///////////
		    		    	file = new WasteManagementFile()
		    		    	def supplyingPlastic = request.getFile('supplyingPlastic1');
		    		    	def supplyingPlasticDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachSupplyingPlastic' and abc.description='list of person supplying plastic' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(supplyingPlastic!=null)
		    		    	{

		    		    	    if(!supplyingPlastic.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(supplyingPlasticDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 9999999999")
		    		    	    		def layoutMapDocInstance = supplyingPlasticDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('supplyingPlastic1')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="list of person supplying plastic"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachSupplyingPlastic"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			supplyingPlastic1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def supplyingPlasticDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachSupplyingPlastic' and abc.description='list of person supplying plastic' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(supplyingPlasticDetails1){
		    		    		supplyingPlastic1 = "Attached"
		    				}
              ///////////////////end/////////////

////////////////////////List of producers and quantum of raw materials supplied to producers///////////
		    		    	file = new WasteManagementFile()
		    		    	def producersQuantum = request.getFile('producersQuantumAttachment');
		    		    	def producersQuantumDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProducersQuantum' and abc.description='List of producers and quantum' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	
		    		    	if(producersQuantum!=null)
		    		    	{

		    		    	    if(!producersQuantum.empty) 
		    		    	     {
		    		    	        
		    		    	    	if(producersQuantumDetails){
		    		    	    		println(" inside ## ifff layoutMapDoc 1212121212")
		    		    	    		def layoutMapDocInstance = producersQuantumDetails[0]
		    		    	        	if(layoutMapDocInstance){
		    		    	        		println(" inside ## ifff layoutMapDocInstance ")
		    		    	        		layoutMapDocInstance.delete()
		    		    	        		println(" instance deleted successfully ")
		    		    	        	}
		    		    	    	}
		    		    	    	
		    		    	    	
		    		    	    	MultipartFile multi = request.getFile('producersQuantumAttachment')
		    		    			file.size = multi.getSize() / 1024
		    						file.name =multi.getOriginalFilename()
		    						file.data=multi.getBytes() 
		    						file.extension = extractExtension( multi )
		    						file.description="List of producers and quantum"
		    						file.createdBy=session.indUser
		    						file.updatedBy=session.indUser
		    						file.typeOfFile="attachProducersQuantum"
		    						file.indreg=indRegInstance
		    						file.applicationId=plasticWasteInstance.id
		    						file.applicationFor="PWM"
		    		    			file.save()
		    		    			producersQuantum1 = "Attached"
		    		    	     }
		    		    	}
		    		    	
		    		    	def producersQuantumDetails1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProducersQuantum' and abc.description='List of producers and quantum' and abc.applicationId=?",[plasticWasteInstance.id]);
		    		    	if(producersQuantumDetails1){
		    		    		producersQuantum1 = "Attached"
		    				}
              ///////////////////end/////////////
               
               
		 //////////////////////////////////////////////////////end///////////////////////////////////////////////////////////
		    				
		    				
		    				
		    				
		    				
		    				
		    				def plasticId=plasticWasteInstance.id
		    				if(params.appStatus=="Inprogress"){
		    	    				flash.message = "Plastic Waste Application No ${plasticWasteInstance.id} is Available for Future modification"
		    	    				if(plasticWasteInstance.singleWin==true){
		    	    					Response responsePush=new Response()
		             					String consentAppNo=plasticWasteInstance.id.toString();
		             					String cafNo=plasticWasteInstance.cafUniqueNo
		             					String serviceId=plasticWasteInstance.serviceId
		             					String applicationType="PWM"
		             						String applicationFor1=""
		             					if(plasticWasteInstance.authorisationAppliedFor=="fresh"){
		             						applicationFor1="Fresh"
		             					}else if(plasticWasteInstance.authorisationAppliedFor=="renew")
		             					{
		             						applicationFor1="Renew"
		             					}
		             					
		             					String statusCode="I"
		             					String appRemarks="Application Saved as draft"
		             					
		             					String pendingWith=""
		             					String pendingWithRole=""
		             					String printAppUrl=""
		             					String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+plasticWasteInstance.industryRegMasterObj.indName+"&indDistrict="+plasticWasteInstance.industryRegMasterObj.district.districtName+"&serviceCode="+plasticWasteInstance.serviceId+"&cafUniqueNo="+plasticWasteInstance.cafUniqueNo
		             					String certificateUrl=""
		             					
		             					responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationType,applicationFor1,statusCode,appRemarks,pendingWith,pendingWithRole,printAppUrl,revertedUrl,certificateUrl)
		    	    					
		    	    				}
		    	    				
		    	    				redirect(action:show,id:plasticWasteInstance.id)
		    	    				return;
		    	    				
		    	    			}
		    				if(params.appStatus=="Completed"){
		    					
		    					 //===========================Document mandatory Code by Deepak=================================//
		    		            def dcCkeck
		    					    def applicationFordoc
		    						ArrayList strList = new ArrayList()				
		    					def appId

		    						dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor= 'PWM' ")
		    						println("dcCkeck---PWM--"+dcCkeck)
		    					
		    				//	dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.consentFor='BMW' and doc.isMandatory='Yes' and doc.isNewApplication='true'")
		    				for(int i=0;i<dcCkeck.size();i++)
		    				{
		    					if(((dcCkeck.get(i)).isMandatory).equalsIgnoreCase("Yes"))
		    					{
		    						def isOrNot = WasteManagementFile.find("from WasteManagementFile abc where abc.description=? and abc.applicationId=?",[(dcCkeck.get(i)).document,plasticWasteInstance.id])
		    						if(!isOrNot)
		    						  strList.add(dcCkeck.get(i).document+"\n")
		    					}
		    				}
		    			   if(strList)
		    				{
		    				     println("strList---PWM--"+strList)
		    					def strr = "Please Upload following documents:\n"
		    			        for(int i=0;i<strList.size();i++)
		    			    		{
		    			        		strr += ("("+(i+1)+"). "+strList.get(i)).toString()+"\n"
		    			    		}
		    			        flash.message = strr
		    			        plasticWasteInstance.completionStatus = "Inprogress"
		    			        	plasticWasteInstance.save(flush:true)	
		    			        	// render(view: 'edit', model: [plasticWasteInstance: plasticWasteInstance, indRegInstance:indRegInstance])
		    					redirect(action:edit,id:plasticWasteInstance)
		    					return ;
		    				}
		    			   //============================================================//
		    					
		    					def indTaluk
		    					def indVillage
		    					def indDistrict
		    					def indPincode		    					
		    					
		    					if(indusrtyInstance.tehsil){
		    					 indTaluk=indusrtyInstance.tehsil.tehsilName
		    					}else{
		    					 indTaluk=""
		    					}
		    					
		    					if(indusrtyInstance.indCity){
		    						indVillage=indusrtyInstance.indCity
			    					}else{
			    					indVillage=""
			    					}
		    					
		    					if(indusrtyInstance.district){
		    						indDistrict=indusrtyInstance.district.districtName
			    					}else{
			    						indDistrict=""
			    					}
		    					
		    					if(indusrtyInstance.indPin){
		    						indPincode=indusrtyInstance.indPin
			    					}else{
			    					indPincode=""
			    					}
		    					
		    					
		    					
		    					
		    					def unitName=indusrtyInstance.indName
		    					def applicantName=indusrtyInstance.occName
		    					def applicantDesignation=indusrtyInstance.occDesignation
		    					if(applicantDesignation.equals("Others")){
		    						applicantDesignation=(indusrtyInstance.otherOccDesignation).toString()
		    				    }
		    					def factoryPostalAddress=indusrtyInstance.indAddress
		    					def occupierTel=indusrtyInstance.indPhoneNo
		    					def occupierTelCode=indusrtyInstance.indPhoneCode
		    					def occupierMobile=indusrtyInstance.occMobile
		    					def occupierEmail=indusrtyInstance.occEmail
		    					
		    					println("indusrtyInstance---dateOfComm---"+(indusrtyInstance.dateOfComm).getClass())
		    					
		    					def tempDate = indusrtyInstance.dateOfComm;
		    					def yearOfCommencement= tempDate;
		    					
		    					SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy"); 
		    					
		    					//def yearOfCommencement= formatter1.format(tempDate)
		    					println("indusrtyInstance---yearOfCommencement---"+yearOfCommencement)
		    					//def yearOfCommencement=indusrtyInstance.dateOfComm
		    					println("ssssss"+yearOfCommencement)
		    					def capitalInvestment=(indusrtyInstance.indCapInvt).toString()
		    					def numOfEmployee=indusrtyInstance.expNoEmp
		    					
		    					def dateWater = plasticWasteInstance.waterValidity
		    					def dateAir = plasticWasteInstance.airValidity
		    					def dateAuthorization = plasticWasteInstance.authorizationValidity
		    					
		    					def dateOfWater= formatter1.format(dateWater)
		    					def dateOfAir= formatter1.format(dateAir)
		    					def dateOfAuthorization= formatter1.format(dateAuthorization)
		    					
		    					
		    					
		    					
		    					
		    					def authorizationRequiredFor=plasticWasteInstance.activityAuthorizationSoughtFor
		    					def manuCapacity = plasticWasteInstance.manufactoringCapacity
		    					def isUnitRegistered = plasticWasteInstance.districtIndustriesCenter
		    					def unitLocation = plasticWasteInstance.unitLocation
		    					def thiknessRulz = plasticWasteInstance.thiknessRulz
		    					def waterAct = plasticWasteInstance.waterAct
		    					def airAct = plasticWasteInstance.airAct
		    					def actionPlan = plasticWasteInstance.actionPlan
		    					def detailsDisposalFacility = plasticWasteInstance.detailsDisposalFacility
		    					def namePlastic = plasticWasteInstance.namePlastic
		    					def quantityPlastic = plasticWasteInstance.quantityPlastic
		    					def occupationalFacilities = plasticWasteInstance.occupationalFacilities
		    					def emmisionEffulant = plasticWasteInstance.emmisionEffulant
		    					def emmisionEffulantDetails = plasticWasteInstance.emmisionEffulantDetails
		    					def unitCompliance = plasticWasteInstance.unitCompliance
		    					def materialProceed = plasticWasteInstance.materialProceed
		    					def materialHandled = plasticWasteInstance.materialHandled
		    					def otherInfor = plasticWasteInstance.otherInfor
		    					def enclosureDetailing = plasticWasteInstance.enclosure
		    					
		    					
		    					
		    					
//////////////////////////////////////////////addviewdelete/////////////////////////////////////////
								def PWMPreviousAuthorisationDetailsInstance = new ArrayList()
//		    					def PWMPreviousAuthorisationInstanceList = PWMPreviousAuthorisationDetails.findAllByApplication(plasticWasteInstance.industryRegMasterObj.id)
		    					def PWMPreviousAuthorisationInstanceList = PWMPreviousAuthorisationDetails.findAll("from PWMPreviousAuthorisationDetails s where s.indUser.id=? and s.wasteManagementFileId!='' order by to_date(Issued_date, 'dd/mm/yyyy') ",[plasticWasteInstance.industryRegMasterObj.id])
		    					for(int var1=0;var1<PWMPreviousAuthorisationInstanceList.size();var1++)
		    					{
		    						def PWMPreviousAuthorisationDetailsInstanceList= new ArrayList()
		    						PWMPreviousAuthorisationDetailsInstanceList.add((PWMPreviousAuthorisationInstanceList.get(var1).PWMApplication_Date).toString())
		    						PWMPreviousAuthorisationDetailsInstanceList.add((PWMPreviousAuthorisationInstanceList.get(var1).PWMAType).toString())
		    						PWMPreviousAuthorisationDetailsInstanceList.add((PWMPreviousAuthorisationInstanceList.get(var1).AuthorisationNo).toString())
		    						PWMPreviousAuthorisationDetailsInstanceList.add((PWMPreviousAuthorisationInstanceList.get(var1).Issued_date).toString())
		    						PWMPreviousAuthorisationDetailsInstanceList.add((PWMPreviousAuthorisationInstanceList.get(var1).Valid_date).toString())
		    						PWMPreviousAuthorisationDetailsInstance.add(PWMPreviousAuthorisationDetailsInstanceList)
		    					}
		    					println("PWMPreviousAuthorisationDetailsInstance rrrrrrrrrrrrrrr"+PWMPreviousAuthorisationDetailsInstance)



		    			    	def productDetailsInstance = new ArrayList()
		    					def productDetailsPWMInstanceList = ProductDetailsPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var1=0;var1<productDetailsPWMInstanceList.size();var1++)
		    					{
		    						def productDetailsList= new ArrayList()
		    						productDetailsList.add((productDetailsPWMInstanceList.get(var1).product).toString())
		    						productDetailsList.add((productDetailsPWMInstanceList.get(var1).quantity).toString())
		    						productDetailsList.add((productDetailsPWMInstanceList.get(var1).unit).toString())
		    						productDetailsList.add((productDetailsPWMInstanceList.get(var1).installedCapacity).toString())
		    						productDetailsInstance.add(productDetailsList)
		    					}
		    					
		    					def productDetailsInstance1 = new ArrayList()
		    					def productDetailsPWMInstanceList1 = ProductDetailsPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var1=0;var1<productDetailsPWMInstanceList1.size();var1++)
		    					{
		    						def productDetailsList= new ArrayList()
		    						productDetailsList.add(productDetailsPWMInstanceList1.get(var1).product)
		    						productDetailsList.add(productDetailsPWMInstanceList1.get(var1).installedCapacity)
		    						productDetailsInstance1.add(productDetailsList)
		    					}
		    					
		    			    	def byProductDetails = new ArrayList()
		    					def byProductDetailsPWMInstanceList = ByProductDetailsPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var2=0;var2<byProductDetailsPWMInstanceList.size();var2++)
		    					{
		    						def byProductList= new ArrayList()
		    						byProductList.add((byProductDetailsPWMInstanceList.get(var2).product).toString())
		    						byProductList.add((byProductDetailsPWMInstanceList.get(var2).quantity).toString())
		    						byProductList.add((byProductDetailsPWMInstanceList.get(var2).unit).toString())
		    						byProductList.add((byProductDetailsPWMInstanceList.get(var2).installedCapacity).toString())
		    						byProductDetails.add(byProductList)
		    					}
		    			    	
		    			    	def rawMaterials = new ArrayList()
		    					def rawMaterialsPWMInstanceList = RawMaterialsPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var3=0;var3<rawMaterialsPWMInstanceList.size();var3++)
		    					{
		    						def rawMaterialsList= new ArrayList()
		    						rawMaterialsList.add((rawMaterialsPWMInstanceList.get(var3).rawMaterial).toString())
		    						rawMaterialsList.add((rawMaterialsPWMInstanceList.get(var3).quantity).toString())
		    						rawMaterialsList.add((rawMaterialsPWMInstanceList.get(var3).unit).toString())
		    						rawMaterials.add(rawMaterialsList)
		    					}
		    			    	
		    			    	def manufactureProcess = new ArrayList()
		    					def manufactureProcessPWMInstanceList = ManufactureProcessPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var4=0;var4<manufactureProcessPWMInstanceList.size();var4++)
		    					{
		    						def manufactureProcessList= new ArrayList()
		    						manufactureProcessList.add(manufactureProcessPWMInstanceList.get(var4).flow)
		    						manufactureProcessList.add(manufactureProcessPWMInstanceList.get(var4).description)
		    						manufactureProcess.add(manufactureProcessList)
		    					}
		    			    	
		    			    	def solidWasteReject = new ArrayList()
		    					def solidWasteRejectPWMInstanceList = SolidWasteRejectPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var5=0;var5<solidWasteRejectPWMInstanceList.size();var5++)
		    					{
		    						def solidWasteRejectList= new ArrayList()
		    						solidWasteRejectList.add((solidWasteRejectPWMInstanceList.get(var5).totalQuantum).toString())
		    						solidWasteRejectList.add((solidWasteRejectPWMInstanceList.get(var5).unit).toString())
		    						solidWasteRejectList.add((solidWasteRejectPWMInstanceList.get(var5).storageMode).toString())
		    						solidWasteRejectList.add((solidWasteRejectPWMInstanceList.get(var5).disposalProvision).toString())
		    						solidWasteReject.add(solidWasteRejectList)
		    					}
		    			    	
		    			    	def disposalDetails = new ArrayList()
		    					/*def disposalDetailsPWMInstanceList = DisposalDetailsPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var6=0;var6<disposalDetailsPWMInstanceList.size();var6++){
		    						def disposalDetailsList= new ArrayList()
		    						disposalDetailsList.add(disposalDetailsPWMInstanceList.get(var6).type)
		    						disposalDetailsList.add(disposalDetailsPWMInstanceList.get(var6).category)
		    						disposalDetailsList.add(disposalDetailsPWMInstanceList.get(var6).quantity)
		    						solidWasteReject.add(disposalDetailsList)
		    					}*/
		    					
		    			    	def generationDetails = new ArrayList()
		    					def generationDetailsPWMInstanceList = GenerationDetailsPWM.findAllByApplication(plasticWasteInstance)
		    					for(int var7=0;var7<generationDetailsPWMInstanceList.size();var7++)
		    					{
		    						def generationDetailsList= new ArrayList()
		    						generationDetailsList.add(generationDetailsPWMInstanceList.get(var7).type)
		    						generationDetailsList.add(generationDetailsPWMInstanceList.get(var7).category)
		    						generationDetailsList.add(generationDetailsPWMInstanceList.get(var7).quantity)
		    						generationDetails.add(generationDetailsList)
		    					}
		    			    	///////////////////////////////////////////////////end//////////////////////////////////////////////
		    					
		    					////////////////// For Routing application /////////////////
            				
		    				/*	RoutePlasticWasteManagement routeWaste=new RoutePlasticWasteManagement()
		    			    	def routed=routeWaste.routePlasticWasteManagementApp(plasticWasteInstance.id,appFor,indusrtyInstance)*/
		    					
		    					Form1PWM  pdf3 = new Form1PWM()
		    					Form2PWM  pdf1 = new Form2PWM()
		    					Form3PWM  pdf2 = new Form3PWM()
		    			    	
		    			    	
		    					def producers =false
		    					def recycling = false
		    					def manufacturer =false
		    			    	println("plasticWasteInstance..11: "+plasticWasteInstance.applicationFor)
		    					def splt = ((plasticWasteInstance.applicationFor).toString()).split(",")
		        				for(int j=0;j<splt.size();j++)
		        					{
		        					
		        					println("splt[j].toLowerCase()"+splt[j].toLowerCase())
		        					if(splt[j].toLowerCase()=="producers of carry bags and containers")
		        					{
		        						
		        						producers=true
		        					}
		        					else if(splt[j].toLowerCase()=="recycling or processing waste")
		        					{
		        						recycling=true
		        					}
		        					else if(splt[j].toLowerCase()=="manufacturer of plastic to be used as raw material")
		        					{
		        						manufacturer=true
		        					}
				
		        					}
			
		    			    	
		        				File certFile1
		        				if(producers)
		        				{
		        					certFile1 = pdf1.form2PWMPdfFunction(unitName,applicantName,applicantDesignation,factoryPostalAddress,
			        						occupierTel,occupierTelCode,occupierEmail,yearOfCommencement,capitalInvestment,numOfEmployee,
			        						dateOfWater,dateOfAir,dateOfAuthorization,manuCapacity,authorizationRequiredFor,
			        						isUnitRegistered,unitLocation,thiknessRulz,waterAct,airAct,actionPlan,
			        						detailsDisposalFacility,namePlastic,quantityPlastic,occupationalFacilities,
			        						emmisionEffulant,emmisionEffulantDetails,unitCompliance,materialProceed,materialHandled,
			        						otherInfor,enclosureDetailing,DistrictPlan1,Manufacturing1,Collection1,analysis1,enclosure1,
			        						consentWater1,consentAir1,personalBrand1,supplyingPlastic1,producersQuantum1,
			        						productDetailsInstance,productDetailsInstance1,
			        						byProductDetails,rawMaterials,manufactureProcess,solidWasteReject,disposalDetails,
			        						generationDetails,PWMPreviousAuthorisationDetailsInstance,indTaluk,indVillage,indDistrict,indPincode)
			                		println("AAAAAA")
			        				byte[] b = new byte[(int) certFile1.length()];
			        				FileInputStream fileInputStream = new FileInputStream(certFile1);
			        				fileInputStream.read(b);
			        				
			        				def industryReg1=IndustryRegMaster.get((params.indRegId).toLong())
			        				
			        				
			        				WasteManagementFile file1=new WasteManagementFile()
			        				def fileLength=certFile1.length()
			        				file1.applicationId = plasticId
			        				file1.size = fileLength / 1024  //f.getSize() 
			        				file1.extension ="pdf"//extractExtension( f )
			        				file1.data=b;
			        				file1.name="PwmForm1.pdf"
			        				file1.description="PWM Application Form"
			        				file1.createdBy= session.indUser
			        				file1.updatedBy=session.indUser
			        				file1.typeOfFile="PwmForm1"
			        				file1.applicationFor="PWM"
			        				file1.indreg=industryReg1
			        				def appFile1=WasteManagementFile.findAll("from WasteManagementFile wm where wm.applicationId=? and wm.typeOfFile='PwmForm1'",[plasticWasteInstance.id])
			        				if(appFile1){
			        					for(int i=0;i<appFile1.size();i++){
			        						appFile1[i].delete();
			        					}
			        				}
			        				if(!file1.hasErrors() && file1.save()) {
			        					
			        				}
			        				else{

			        					file1.errors.each {
					    	   		        println it
					    	   			}
					    			
					    				
					    			
			        				}	
		        				}
		        				
		        				
		        				
		        				
		        				File certFile2
		        				if(manufacturer){
		        				certFile2 = pdf2.form3PWMPdfFunction(unitName,applicantName,applicantDesignation,factoryPostalAddress,occupierTel,occupierTelCode,occupierEmail,yearOfCommencement,capitalInvestment,numOfEmployee,dateOfWater,dateOfAir,dateOfAuthorization,manuCapacity,authorizationRequiredFor,isUnitRegistered,unitLocation,thiknessRulz,waterAct,airAct,actionPlan,detailsDisposalFacility,namePlastic,quantityPlastic,occupationalFacilities,
		        						emmisionEffulant,emmisionEffulantDetails,unitCompliance,materialProceed,materialHandled,otherInfor,enclosureDetailing,DistrictPlan1,Manufacturing1,Collection1,analysis1,enclosure1,consentWater1,consentAir1,personalBrand1,supplyingPlastic1,producersQuantum1,productDetailsInstance,productDetailsInstance1,
		        						byProductDetails,rawMaterials,manufactureProcess,solidWasteReject,disposalDetails,generationDetails,PWMPreviousAuthorisationDetailsInstance,indTaluk,indVillage,indDistrict,indPincode)
		                		
		        				byte[] b2 = new byte[(int) certFile2.length()];
		        				FileInputStream fileInputStream2 = new FileInputStream(certFile2);
		        				fileInputStream2.read(b2);
		        				
		        				def industryReg2=IndustryRegMaster.get((params.indRegId).toLong())
		        				println("BBBBB")
		        				
		        				WasteManagementFile file2=new WasteManagementFile()
		        				def fileLength2=certFile2.length()
		        				file2.applicationId = plasticId
		        				file2.size = fileLength2 / 1024  //f.getSize() 
		        				file2.extension ="pdf"//extractExtension( f )
		        				file2.data=b2;
		        				file2.name="PwmForm2.pdf"
		        				file2.description="PWM Application Form"
		        				file2.createdBy= session.indUser
		        				file2.updatedBy=session.indUser
		        				file2.typeOfFile="PwmForm2"
		        				file2.applicationFor="PWM"
		        				file2.indreg=industryReg2
		        				def appFile2=WasteManagementFile.findAll("from WasteManagementFile wm where wm.applicationId=? and wm.typeOfFile='PwmForm2'",[plasticWasteInstance.id])
		        				if(appFile2){
		        					for(int i=0;i<appFile2.size();i++){
		        						appFile2[i].delete();
		        					}
		        				}
		        				if(!file2.hasErrors() && file2.save()) {
		        					
		        				}
		        				else{

		        					file2.errors.each {
				    	   		        println it
				    	   			}
				    			
				    				
				    			
		        				}	
		        				}
		        				
		        				File certFile3
		        				if(recycling){
		        				certFile3 = pdf3.form1PWMPdfFunction(unitName,applicantName,applicantDesignation,factoryPostalAddress,occupierTel,occupierTelCode,occupierEmail,yearOfCommencement,capitalInvestment,numOfEmployee,dateOfWater,dateOfAir,dateOfAuthorization,manuCapacity,authorizationRequiredFor,isUnitRegistered,unitLocation,thiknessRulz,waterAct,airAct,actionPlan,detailsDisposalFacility,namePlastic,quantityPlastic,occupationalFacilities,
		        						emmisionEffulant,emmisionEffulantDetails,unitCompliance,materialProceed,materialHandled,otherInfor,enclosureDetailing,DistrictPlan1,Manufacturing1,Collection1,analysis1,enclosure1,consentWater1,consentAir1,personalBrand1,supplyingPlastic1,producersQuantum1,productDetailsInstance,productDetailsInstance1,
		        						byProductDetails,rawMaterials,manufactureProcess,solidWasteReject,disposalDetails,generationDetails,PWMPreviousAuthorisationDetailsInstance,indTaluk,indVillage,indDistrict,indPincode)
		                		
		        				byte[] b3 = new byte[(int) certFile3.length()];
		        				FileInputStream fileInputStream3 = new FileInputStream(certFile3);
		        				fileInputStream3.read(b3);
		        				
		        				def industryReg3=IndustryRegMaster.get((params.indRegId).toLong())
		        				
		        				println("CCCC")
		        				WasteManagementFile file3=new WasteManagementFile()
		        				def fileLength3=certFile3.length()
		        				file3.applicationId = plasticId
		        				file3.size = fileLength3 / 1024  //f.getSize() 
		        				file3.extension ="pdf"//extractExtension( f )
		        				file3.data=b3;
		        				file3.name="PwmForm3.pdf"
		        				file3.description="PWM Application Form"
		        				file3.createdBy= session.indUser
		        				file3.updatedBy=session.indUser
		        				file3.typeOfFile="PwmForm3"
		        				file3.applicationFor="PWM"
		        				file3.indreg=industryReg3
		        				def appFile3=WasteManagementFile.findAll("from WasteManagementFile wm where wm.applicationId=? and wm.typeOfFile='PwmForm3'",[plasticWasteInstance.id])
		        				if(appFile3){
		        					for(int i=0;i<appFile3.size();i++){
		        						appFile3[i].delete();
		        					}
		        				}
		        				if(!file3.hasErrors() && file3.save()) {
		        					
		        				}
		        				else{

		        					file3.errors.each {
				    	   		        println it
				    	   			}
				    			
				    				
				    			
		        				}	
		    					
		    				}
		        				//flash.message = "PlasticWaste Application No ${plasticWasteInstance.id} is successfully completed"
		        				
		        				
		    					def fee=0.0
		    					render(view:'Payment',model:[feesPaid:fee,plasticWasteInstance:plasticWasteInstance])
		        				//redirect(action:show,id:plasticWasteInstance.id)
		    				}
		    				
		    			}else
		    			{
		    				plasticWasteInstance.errors.each {
		    	   		        println it
		    	   			}
		    			
		    				
		    			}
			
			
	}
	
	///////////////////////////////////////////addViewDelete////////////////////////////////////////////
	
	
	def popGenerationAdd = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = GenerationDetailsPWM.findAll("from GenerationDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def popGenerationView = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = GenerationDetailsPWM.findAll("from GenerationDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def popGenerationEdit = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = GenerationDetailsPWM.findAll("from GenerationDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def saveGenerationDetails = {

			def app = PlasticWaste.get((params.appDetId))
			def unitInstance = UnitMaster.get((params.unit))
	    	def ProductDetailsPWMInstance= new GenerationDetailsPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.type=params.type
				ProductDetailsPWMInstance.category=params.category
				ProductDetailsPWMInstance.quantity=params.quantity
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popGenerationAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	
	}
	
	def deleteGenerationDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = GenerationDetailsPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = GenerationDetailsPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popGenerationEdit,id:app)
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	def popDisposalAdd = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = DisposalDetailsPWM.findAll("from DisposalDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def popDisposalView = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = DisposalDetailsPWM.findAll("from DisposalDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def popDisposalEdit = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = DisposalDetailsPWM.findAll("from DisposalDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def saveDisposalDetails = {

			def app = PlasticWaste.get((params.appDetId))
			def unitInstance = UnitMaster.get((params.unit))
	    	def ProductDetailsPWMInstance= new DisposalDetailsPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.type=params.type
				ProductDetailsPWMInstance.category=params.category
				ProductDetailsPWMInstance.quantity=params.quantity
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popDisposalAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	
	}
	
	def deleteDisposalDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = DisposalDetailsPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = DisposalDetailsPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popDisposalEdit,id:app)
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	def popProductDetailsAdd = {
			 def app = PlasticWaste.get((params.id))
		       def productDetails = ProductDetailsPWM.findAll("from ProductDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
		   
	}
	def popProductDetailsView = {
			 def app = PlasticWaste.get((params.id))
		       def productDetails = ProductDetailsPWM.findAll("from ProductDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
		
	}
	def popProductDetailsEdit = {
			 def app = PlasticWaste.get((params.id))
		       def productDetails = ProductDetailsPWM.findAll("from ProductDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
		
	}
	
	def saveProductDetails = {
			def app = PlasticWaste.get((params.appDetId))
		    def unitInstance = UnitMaster.get((params.unit))
	    	def ProductDetailsPWMInstance= new ProductDetailsPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.product=params.Product
				ProductDetailsPWMInstance.quantity=params.quantity
				ProductDetailsPWMInstance.unit=unitInstance
				ProductDetailsPWMInstance.installedCapacity=params.installedProductCapacity
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popProductDetailsAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	}
	
	def deleteProductDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = ProductDetailsPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = ProductDetailsPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popProductDetailsEdit,id:app)
        
	}
	
	
	
	
	def popByProductDetailsAdd = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = ByProductDetailsPWM.findAll("from ByProductDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popByProductDetailsView = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = ByProductDetailsPWM.findAll("from ByProductDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popByProductDetailsEdit = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = ByProductDetailsPWM.findAll("from ByProductDetailsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def saveByProductDetails = {
			def app = PlasticWaste.get((params.appDetId))
			println("app "+app)
		    def unitInstance = UnitMaster.get((params.unit))
	    	def ProductDetailsPWMInstance= new ByProductDetailsPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.product=params.Product
				ProductDetailsPWMInstance.quantity=params.quantity
				ProductDetailsPWMInstance.unit=unitInstance
				ProductDetailsPWMInstance.installedCapacity=params.installedProductCapacity
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popByProductDetailsAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	}
	
	def deleteByProductDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = ByProductDetailsPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = ByProductDetailsPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popByProductDetailsEdit,id:app)
        
	}
	
	
	
	def popRawMaterialAdd = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = RawMaterialsPWM.findAll("from RawMaterialsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popRawMaterialView = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = RawMaterialsPWM.findAll("from RawMaterialsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popRawMaterialEdit = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = RawMaterialsPWM.findAll("from RawMaterialsPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def saveRawMaterialDetails = {

			def app = PlasticWaste.get((params.appDetId))
		    def unitInstance = UnitMaster.get((params.unit))
	    	def ProductDetailsPWMInstance= new RawMaterialsPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.rawMaterial=params.rawMaterialName
				ProductDetailsPWMInstance.quantity=params.quantity
				ProductDetailsPWMInstance.unit=unitInstance
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popRawMaterialAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	
	}
	
	def deleteRawMaterialDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = RawMaterialsPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = RawMaterialsPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popRawMaterialEdit,id:app)
        
	}
	
	
	
	
	
	
	
	def popDescriptionOfProcessOfManufactureAdd = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = ManufactureProcessPWM.findAll("from ManufactureProcessPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popDescriptionOfProcessOfManufactureView = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = ManufactureProcessPWM.findAll("from ManufactureProcessPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popDescriptionOfProcessOfManufactureEdit = {
			def app = PlasticWaste.get((params.id))
		       def productDetails = ManufactureProcessPWM.findAll("from ManufactureProcessPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	def saveProcessOfManufacturing = {

			def app = PlasticWaste.get((params.appDetId))
	    	def ProductDetailsPWMInstance= new ManufactureProcessPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.flow=params.flow
				ProductDetailsPWMInstance.description=params.description
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popDescriptionOfProcessOfManufactureAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	
	}
	
	def deleteManufacturingProcessDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = ManufactureProcessPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = ManufactureProcessPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popDescriptionOfProcessOfManufactureEdit,id:app)
        
	}
	
	
	
	
	
	
	
	
	
	
	def addAuthorisationPopup = {
	       def app = PlasticWaste.get((params.id))
	       def previousAuthDetails = PWMPreviousAuthorisationDetails.findAll("from PWMPreviousAuthorisationDetails afr where afr.indUser=? order by to_date(Issued_date, 'dd/mm/yyyy')",[app.industryRegMasterObj])
	       def docList8 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='Applied Authorisation' and abc.description='authorisation attachment' and abc.applicationId=? order by id desc",[app.id])
	       return [appDetId:params.id,previousAuthDetails:previousAuthDetails,docList8:docList8]
	   
	}
	def viewAuthorisationPopup = {
        	   def app = PlasticWaste.get((params.id).toLong())
               def previousAuthList = PWMPreviousAuthorisationDetails.findAll("from PWMPreviousAuthorisationDetails afr where afr.indUser=? order by to_date(Issued_date, 'dd/mm/yyyy')",[app.industryRegMasterObj])
               def previousAuthAttachment = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='Applied Authorisation' and abc.description='authorisation attachment' and abc.applicationId=? order by id desc",[app.id])
               return [appDetId:params.id,previousAuthList:previousAuthList,previousAuthAttachment:previousAuthAttachment]
	}
	def editAuthorisationPopup = {

    	    def app = PlasticWaste.get((params.id).toLong())
            def previousAuthList = PWMPreviousAuthorisationDetails.findAll("from PWMPreviousAuthorisationDetails afr where afr.indUser=? order by to_date(Issued_date, 'dd/mm/yyyy')",[app.industryRegMasterObj])
               def previousAuthAttachment = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='Applied Authorisation' and abc.description='authorisation attachment' and abc.applicationId=? order by id desc",[app.id])
               return [appDetId:params.id,previousAuthList:previousAuthList,previousAuthAttachment:previousAuthAttachment]
      
	}
	
	
	def popWaterSolidWasteAdd = {
			   def app = PlasticWaste.get((params.id))
		       def productDetails = SolidWasteRejectPWM.findAll("from SolidWasteRejectPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popWaterSolidWasteView = {
			   def app = PlasticWaste.get((params.id))
		       def productDetails = SolidWasteRejectPWM.findAll("from SolidWasteRejectPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	def popWaterSolidWasteEdit = {
			   def app = PlasticWaste.get((params.id))
		       def productDetails = SolidWasteRejectPWM.findAll("from SolidWasteRejectPWM afr where afr.application=? order by id desc",[app])
		       return [appDetId:params.id,productDetails:productDetails,app:app]
	}
	
	
	def saveWaterSolidWaste = {

			def app = PlasticWaste.get((params.appDetId))
			def unitInstance = UnitMaster.get((params.unit))
	    	def ProductDetailsPWMInstance= new SolidWasteRejectPWM() 
			
				ProductDetailsPWMInstance.properties = params
				ProductDetailsPWMInstance.application=app
				ProductDetailsPWMInstance.totalQuantum=params.totalQuantum
				ProductDetailsPWMInstance.unit=unitInstance
				ProductDetailsPWMInstance.storageMode=params.storageMode
				ProductDetailsPWMInstance.disposalProvision=params.disposalProvision
		    	
			    if(ProductDetailsPWMInstance.save() && !ProductDetailsPWMInstance.hasErrors())
			    {
			    	flash.message = "Details Saved."
			    	redirect(action:popWaterSolidWasteAdd,id:app.id)
			    }
						
			    else
			    {
			    	ProductDetailsPWMInstance.errors.each {
	   		        println it
	   			}
	         
				}			
	
	}
	
	def deleteWaterSolidWasteDetails = {

    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = SolidWasteRejectPWM.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = SolidWasteRejectPWM.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	
        		}
        		
        	}
        	redirect(action:popWaterSolidWasteEdit,id:app)
        
	}
	
	
	
	
	
	
	
	
	
	
	def deleteAuthorisationPopup = {
    		def app 
    		if(params.id){
        	app = PlasticWaste.get((params.id).toLong())
    		}
    		else{
    			app = PlasticWaste.get((params.appId).toLong())
    		}
        	if((params.delete).getClass().getName()== "java.lang.String"){
        		def feeDetInst = PWMPreviousAuthorisationDetails.get((params.delete).toInteger())
        		
        		feeDetInst.delete()
        	
        		if(params.delete1)
        		{
        		def feeCheque = WasteManagementFile.get((params.delete1).toInteger())
        		if(feeCheque){
            	
            			feeCheque.delete()
            		}
        			
                	flash.message="Please attach again the scan copy of Drafts/Cheques"

        		}
        	}else{
        		if(params.delete){
            	for(int i=0;i<(params.delete).size();i++){
            		def feeDetInst = PWMPreviousAuthorisationDetails.get((params.delete[i]).toInteger())
            		
            		feeDetInst.delete()
            	}
            	if(params.delete1)
        		{
        		def feeCheque = WasteManagementFile.get((params.delete1).toInteger())
        		if(feeCheque){
        			
        			feeCheque.delete()
            		}
            	flash.message("Please attach again the scan copy of above Drafts/Cheques")

        		}
        		}
        		
        	}
        	redirect(action:editAuthorisationPopup,id:app)
        }
	
	def saveAuthorisationDetails = {
			def app = PlasticWaste.get((params.appDetId))
			def indUserInstance=app.industryRegMasterObj
			def indRegInstanceId=indUserInstance.id
		    def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
		    
	    	def PWMPreviousAuthorisationDetailsInstance
	    	if(params.PWMApplication_Date_value){
	    	PWMPreviousAuthorisationDetailsInstance= new PWMPreviousAuthorisationDetails() 
			
	    	PWMPreviousAuthorisationDetailsInstance.properties = params
	    	PWMPreviousAuthorisationDetailsInstance.application=""
	    	PWMPreviousAuthorisationDetailsInstance.indUser=app.industryRegMasterObj
	    	PWMPreviousAuthorisationDetailsInstance.PWMApplication_Date=params.PWMApplication_Date_value
	    	PWMPreviousAuthorisationDetailsInstance.PWMAType=params.PWMAType
	    	PWMPreviousAuthorisationDetailsInstance.AuthorisationNo=params.AuthorisationNo
	    	PWMPreviousAuthorisationDetailsInstance.Issued_date=params.Issued_date_value
			
	    	PWMPreviousAuthorisationDetailsInstance.Valid_date=params.Valid_date_value
	    	PWMPreviousAuthorisationDetailsInstance.wasteManagementFileId=""
		    if(PWMPreviousAuthorisationDetailsInstance.save() && !PWMPreviousAuthorisationDetailsInstance.hasErrors())
         {
		    	flash.message = "Details Saved."
		    	redirect(action:addAuthorisationPopup,id:app.id)
         }
					
         else
         {
        	 PWMPreviousAuthorisationDetailsInstance.errors.each {
   		        println it
   			}
         
			}			
       	
	    }	
	//////////////////////////// For Multiple File Attachment in each row ////////////////////
		
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	def date = new Date();
	def t = dateFormat.format(date)		

   def file16 = new WasteManagementFile()
   def f16 = request.getFile('pmwAuthAttach')

	if(!f16.empty) {
		MultipartFile multi = request.getFile('pmwAuthAttach')
		file16.size = multi.getSize() / 1024
		file16.name =multi.getOriginalFilename()
		file16.data=multi.getBytes() 
		file16.extension = extractExtension( multi )
		file16.description="authorisation attachment"
		file16.createdBy=indUserInstance.indName
		file16.dateCreated=dateFormat.parse(t)
		file16.typeOfFile="Applied Authorisation"
		file16.indreg=indUserInstance
		file16.applicationId=app.id
		file16.applicationFor="PWM"
		if(file16.save()) {
			PWMPreviousAuthorisationDetailsInstance.wasteManagementFileId=file16.id
			PWMPreviousAuthorisationDetailsInstance.save(flush:true)
							
	}}
//	 redirect(action:addAuthorisationPopup,id:params.appDetId)
	    }

	
	///////////////////////////////////////////////end//////////////////////////////////////////////////
	
	///////////////////////////////////////////////////download///////////////////////////////////////////////
	
	def viewMswPdf={
			println("viewMswPdf "+params)
		def app = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? order by crf.id desc",[(params.appliLoc).toLong()])
		def appli = app.description
		def appSize = app.extension
		def application1 = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='PwmForm1' order by crf.id desc",[(params.appliLoc).toLong()],[max:1])
		if(application1){
			def application=application1[0]
			def applicationInstance = application
			response.setContentType( "application-xdownload")
			response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
			response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
		}
		else {
			println("hiiiiiiiiiiiiiii")
		}
	}
	def viewMswPdf2={
			println("viewMswPdf "+params)
		def app = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? order by crf.id desc",[(params.appliLoc).toLong()])
		def appli = app.description
		def appSize = app.extension
		def application1 = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='PwmForm2' order by crf.id desc",[(params.appliLoc).toLong()],[max:1])
		if(application1){
			def application=application1[0]
			def applicationInstance = application
			response.setContentType( "application-xdownload")
			response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
			response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
		}
		else {
			
		}
	}
	def viewMswPdf3={
			println("viewMswPdf "+params)
		def app = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? order by crf.id desc",[(params.appliLoc).toLong()])
		def appli = app.description
		def appSize = app.extension
		def application1 = WasteManagementFile.findAll(" from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='PwmForm3' order by crf.id desc",[(params.appliLoc).toLong()],[max:1])
		if(application1){
			def application=application1[0]
			def applicationInstance = application
			response.setContentType( "application-xdownload")
			response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
			response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
		}
		else {
			
		}
	}
	
	
	def viewAuthorisationAttached={
	 		 
			 def applicationFileInstance = WasteManagementFile.get(params.appliLoc)
               response.setContentType( "application-xdownload")
			   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileInstance.name+"\"")
			response.getOutputStream() << new ByteArrayInputStream( applicationFileInstance.data )
	 }
	
	def viewDocumentRecy_111={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 println("appli "+appli)
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachDistrictPlan' and abc.description='registered with District Industries Centre' and abc.applicationId=?",[appli]);
			 println("applicationFileInstance "+applicationFileInstance)
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_112={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProcessManufacturing' and abc.description='Manufacturing Process' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_113={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachWasteCollection' and abc.description='Waste Collection and transportation details' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_114={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachAnalysisReport' and abc.description='analysis report' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_115={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachEnclosure' and abc.description='List of enclosure as per rule' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_116={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentWater' and abc.description='consent under the Water' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_117={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentAir' and abc.description='consent under the Air' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_118={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachPersonalBrand' and abc.description='list of personal or Brand owners' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_119={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 println("appli "+appli)
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachSupplyingPlastic' and abc.description='list of person supplying plastic' and abc.applicationId=?",[appli]);
			 println("applicationFileInstance "+applicationFileInstance)
			def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	def viewDocumentRecy_120={
			def applicationFileInstance
			 def appli=(params.appliLoc).toLong()
			 applicationFileInstance = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProducersQuantum' and abc.description='List of producers and quantum' and abc.applicationId=?",[appli]);
			 def applicationFileSingleInstance=applicationFileInstance[0]
			 response.setContentType( "application-xdownload")
			 response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
			 response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
     }
	
	
	////////////////////////////////////////////////////end////////////////////////////////////////////////////
	//////////////////////////////////////////////////upload documents/////////////////////////////////////////
	def popUploadDoc ={
		
		
    	def app = PlasticWaste.get((params.id).toInteger())
    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor='Authorization' ")
    	//def feeDetailsList = FeeBankDetails.findAllByApplication(app)
    	return [appDetId:params.id,docList:docList]
  



}

    def saveDocs={
    	def app = PlasticWaste.get((params.indAppId).toInteger())
    	def apliId = app.id
    	def extn
    	def bioMedicalWasteInstance = PlasticWaste.get( params.indAppId )
		//println("qqqqqqqqqqqqq"+hazardeousWasteAuthAppInstance)
		def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
		def indRegInstanceId=indRegInstance.id
		def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor='PWM' ")
    	println("params..."+params)
    	println("doclist"+docList)
        MultipartFile multi
            for(int i=0;i<docList.size();i++){
            //	def applicationDocumentL=ApplicationDocuments.findAll("from ApplicationDocuments apd where apd.indApplication=? and apd.level=?",[app,docName],[max:1] )
            	 def file = new WasteManagementFile()
            	def f = request.getFile((docList.get(i)).document)
            	println("docList.get(i)).document::"+docList.get(i).document)
            	println("i::"+i)
            	println("f::"+f)
            	if(!f.empty){
            		
            	multi = request.getFile( (docList.get(i)).document)
            	
					file.size = multi.getSize() / 1024
					file.name =multi.getOriginalFilename()
					file.data=multi.getBytes() 
					file.extension = extractExtension( multi )
					file.description=docList.get(i)
					file.createdBy=indRegInstanceGet.indName
					file.updatedBy=indRegInstanceGet.indName
					file.typeOfFile="PWM Documents"
					file.indreg=indRegInstanceGet
					file.applicationId=apliId
					file.applicationFor="PWM"
				
        	    
             	
             	
                if(file.save()) {
                	
                	System.out.println(" Done getting new file in save"+app)
                	 render(view: 'saveDocs', model: [app:app])
                	
                }
                	
        	        else {
        	        	
        	        	file.errors.each {
        			        println it
        			   }
        	        
        	        }
        	        }
 		              	  }
   	 render(view: 'saveDocs', model: [app:app])

                // end //
            	}
	
def saveMoreDocs = {
			

			println("params...in start"+params.app)
			def app = PlasticWaste.get((params.app).toInteger())
	    	def apliId = app.id
	    	def extn
	    	def bioMedicalWasteInstance = PlasticWaste.get( params.app )
			//println("qqqqqqqqqqqqq"+hazardeousWasteAuthAppInstance)
			def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
	    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor='pwm' ")
	    	println("params..."+params)
	    	println("doclist"+docList)
	      def other1 = params.other
		def other = params.otherDoc
//		FormDataMultiPart multiPart = multiPart.getFields("test");
		println("params..."+params)
		println("doclist"+docList)
	    	MultipartFile multi
	    	 def file = new WasteManagementFile()
			
	            	//def applicationDocumentL=ApplicationDocuments.findAll("from ApplicationDocuments apd where apd.indApplication=? and apd.level=?",[app,docName],[max:1] )
	          	 
	          	
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
				file.typeOfFile="PWM Documents"
				file.indreg=indRegInstanceGet
				file.applicationId=apliId
				file.applicationFor="PWM"
	           	
	           	
	           	
	           	
	              if(file.save()) {
	            	
	                	 flash.message="Document Uploaded Successfully"

	            	  render(view: 'saveDocs', model: [app: app])
	      	       } else {
	      	    	   println("inEsle")
	      	          render(view: 'create', model: [fileUpload: fileUpload])
	      	          }
	               
	          	}
	           
	          	else {
	       	    	   println("inEsle")
	       	    	   flash.message="Please Upload document"
	       	          render(view: 'saveDocs', model: [app: app,other:params.other])
	       	          }
	       
	        

	       
	        
	            // end //
	        	}
	
	def popUploadDocPwm ={
    		
	  		  //  println("Inside Upload Document Function")
	  	    	def app = PlasticWaste.get((params.id).toInteger())
	  	    	//println("IDD is:::"+app)
	  	    	def certFor="PWM"  
	  	    	
	  	    	def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=?  order by abc.id asc",[certFor])
	  	    	
	  	     	 def listDoc= new ArrayList()
	  	    
	  	    	 def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='PWM Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
	  	     	
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
	  	    
	  			 
	  		     return [app:app,appDetId:params.id,docList:docList,uploadedDocList:listDoc]
	  	    }
	
	
	
	      
	      def popDeleteDocPwm = {
	      	
	  	
	  		def app =PlasticWaste.get((params.id).toInteger())
	      	def docList = DocumentChecklistMaster.list()
	   
	      	def listDoc= new ArrayList()    
	      	
	          def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.typeOfFile='PWM Documents' and apd.applicationId=? order by apd.id asc",[params.id.toLong()])
	      		
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
	    return [appDetId:params.id,docList:docList,app:app,listDoc:listDoc]
	   }
	
	
	
	
	  	def deleteDocs = {
	  		
	       def app =PlasticWaste.get((params.indAppId).toLong())
	          	
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
	          	redirect(action:popDeleteDocPwm,id:app)
	          
	  	}	
	
	
	
def viewFile1 = {
   		
    		
        	def docType = params.docType
        	println("asd:::"+docType)
        	def application = params.appliLoc
        	println("asd:::"+application)
        	def indApplInstance=(params.appliLoc).toLong()
        	def docName = params.docName
        	println("docType : "+docType+" application : "+application+" docName : "+docName)
        	def fileLoc
        	def file
        	def docFName = docName.replace(" ","_")
        	println(docFName)
        	println("111111111111"+indApplInstance)
        	
        	
        	def applicationDocumentL=WasteManagementFile.findAll("from WasteManagementFile apd where apd.applicationId=? and apd.description=? order by apd.id desc",[indApplInstance,docName],[max:1] )
        	
        	println("3333"+applicationDocumentL)
        	
        	def singleInstanceOfApplicationDocument=applicationDocumentL[0]
        	println("2222222222"+singleInstanceOfApplicationDocument)
        	response.setContentType( "application-xdownload")
        		
        	 response.setHeader("Content-Disposition", "attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"")
      	
        	
        		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
        	
        
    }
	///////////////////////////////////////////////////////end////////////////////////////////////////////////
	//////////////////////////////////////////////FEE DETAILS/////////////////////////////////////////////////
	    def popFeeDetailsAddPWM = {
			println("popFeeDetailsAddPWM "+params)
            	def app = PlasticWaste.get((params.id).toInteger())
            	println("hhi"+app)
            	def feeDetailsList = FeeBankDetailsPWM.findAllByApplication(app)
            	def feeCheque = FeeChequeRecordPWM.findByindApplication(app)
            	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
            }
        
        def saveBankFeeDetails = {
            	
            	def dateCheck = params.dateval_value
            	println("dateCheck"+dateCheck)
            	def currentDate=new Date()
            	DateCustom dd=new DateCustom()
            	def sqlCurrentDate=dd.sQLdate(currentDate)
            	println(currentDate.getClass().getName())
            
            	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
        		def x = sdfh.parse(dateCheck);
        		
        		println("x"+x)
            	
            	def app = PlasticWaste.get((params.appId).toInteger())
            	if(x>sqlCurrentDate)
        		{
        			flash.message="DD/Cheque issue date can not be greater than current date"
        			println("HIIIIIII")
        			redirect(action:popFeeDetailsAddPWM,id:app.id)
        		}
            	else
            	{
            	println("app " +app)
            		if((params.ddNo).getClass().getName()== "java.lang.String"){
                		if(params.ddNo!=""){
                			def feeBankDetails = new FeeBankDetailsPWM()
                    		feeBankDetails.application = app
                    		feeBankDetails.ddChequeNo = params.ddNo
                    		println(params)
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
                				System.out.println("saved")
                			}else{
                				feeBankDetails.errors.each {
                			        println it
                			   }
                			}
                			
                    		}
                		
                		
                	}else{
                		println("size "+params.ddNo.size())
                		for(int i=0;i<params.ddNo.size();i++){
                			if(ddNo[i]!=""){
                				def feeBankDetails = new FeeBankDetailsPWM()
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
            	redirect(action:popFeeDetailsAddPWM,id:app.id)
            	
            }
            }
        
        
        def saveChequeAttach = {
       		 println("params"+params)
       		 println("in save cheque attch...........;;;;;;;?????????????"+params)
       		def app = PlasticWaste.get((params.appId1).toInteger())
       		
       		def feeCheque = FeeChequeRecordPWM.findByIndApplication(app)
       		println("feeCheque"+feeCheque)
       		if(feeCheque){
           	//	def feeCheque = FeeChequeRecord.get((params.delete1).toInteger())
       			println("feeCheque"+feeCheque)
       			feeCheque.delete()
          		 
       		}
       		
       		def file1 = new FeeChequeRecordPWM()
       		
       		
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
       		redirect(action:popFeeDetailsAddPWM,id:app)
       }
        
        def popFeeDetailsViewPWM = {
            	def app = PlasticWaste.get((params.id).toInteger())
            	println("in pop fee details view... m hereerererererreeeeeeeeeee")
            	def feeDetailsList = FeeBankDetailsPWM.findAllByApplication(app)
            	def feeCheque = FeeChequeRecordPWM.findByIndApplication(app)
            	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
            }

        
        def viewChequeAttached={
          		 println("params"+params)
          		 
          		
        		 def applicationFileInstance
        	    	def application = PlasticWaste.get((params.appliLoc).toLong())
        	    	
        	        applicationFileInstance=FeeChequeRecordPWM.findAll("from FeeChequeRecordPWM afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[application],[max:1])
        	    	
        	    	def applicationFileSingleInstance=applicationFileInstance[0]
        		   response.setContentType( "application-xdownload")
        		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
        		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
          } 
        def popFeeDetailsEditPWM = {
            	def app = PlasticWaste.get((params.id).toInteger())
            	def feeDetailsList = FeeBankDetailsPWM.findAllByApplication(app)
            	def feeCheque = FeeChequeRecordPWM.findByIndApplication(app)
            	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
            }
        
        def deleteFeeBankDetails = {
            	def app = PlasticWaste.get((params.appId).toInteger())
            	if((params.delete).getClass().getName()== "java.lang.String"){
            		def feeDetInst = FeeBankDetailsPWM.get((params.delete).toInteger())
            		
            		feeDetInst.delete()
            	
            		if(params.delete1)
            		{
            		def feeCheque = FeeChequeRecordPWM.get((params.delete1).toInteger())
            		println("feeCheque"+feeCheque)
            		if(feeCheque){
                	
                		println("feeCheque"+feeCheque)
                		
                			println("asas")
                			feeCheque.delete()
                		}
            			
                    	flash.message="Please attach again the scan copy of Drafts/Cheques"

            		}
            	}else{
            		if(params.delete){
                	for(int i=0;i<(params.delete).size();i++){
                		def feeDetInst = FeeBankDetailsPWM.get((params.delete[i]).toInteger())
                		
                		feeDetInst.delete()
                	}
                	if(params.delete1)
            		{
            		def feeCheque = FeeChequeRecordPWM.get((params.delete1).toInteger())
            		if(feeCheque){
            			
                        	
                    		println("feeCheque"+feeCheque)
                    		
                    			println("asas")
                    			
                    		
                    		
            			feeCheque.delete()
                		}
                	flash.message("Please attach again the scan copy of above Drafts/Cheques")

            		}
            		}
            		
            	}
            	redirect(action:popFeeDetailsEditPWM,id:app)
            }
        
        
        def popChallan = {
            	
            	println("params:"+params)

            	def indApplicationDetailsInstance = PlasticWaste.get(params.id)
            	def feesBankOnlineInstance = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
            	def check = false
//            	def neftTransInstance = NeftTransactionBMWDetails.find("from NeftTransactionBMWDetails fee where fee.indApplication=? order by id ",[indApplicationDetailsInstance])
            	println("feesBankOnlineInstance:"+feesBankOnlineInstance)
            	
            //	if(neftTransInstance)//{
            		//check=true
            	//}
            	
            	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.industryRegMasterObj.district)
        	println("group---"+group.group.groupName)
            	def feeDetailsList = FeeBankOtherDetailsBMW.findAllByApplication(indApplicationDetailsInstance)
            
            	[appDetId:params.id,check:check,feesBankOnlineInstance:feesBankOnlineInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,group:group.group.groupName,feeDetailsList:feeDetailsList]
            }
        ///////////////////////////////////////////////////////////
	//////////////////////////////////////////////////END/////////////////////////////////////////////////////
	
	def uploadPwmCertificate = {
    	
    	def userId = session.userMaster
    	if(userId==null || userId=="")
    	{
    		flash.message="Your session has been expired ! Please login again."
    		redirect(controller:"userMaster",action:"logout")
    	}
	println("System.out.println111111111111"+params)
	println("session"+session)
		def bioMedicalWasteInstance = PlasticWaste.get( (params.id).toLong())
    	def bioid=bioMedicalWasteInstance.id
    	println("bioid------------------------------------"+bioMedicalWasteInstance)
    	def app = WasteManagementPendingDetails.findByApplicationId(bioid.toString())
	
    	println("app---------------"+app)
    	def id=app.id
    	
		
		def checkForView = false
		def certInst = RecordCertificatePWM.findByApplication(bioMedicalWasteInstance)
		if(certInst)
		{
			checkForView = true
		}
		def roleHeader=app.role.roleName
    	return [appDetId:params.id,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,checkForView:checkForView]
    }
	
	def saveConsentOrder= {
	    	println("Params---------------------------------"+params)
			def idAppl= (params.idIndApp).toLong()
			def bioMedicalWasteInstance=PlasticWaste.get(idAppl)
				def bioid=bioMedicalWasteInstance.id
			def app = WasteManagementPendingDetails.findByapplicationId(bioMedicalWasteInstance.toString())
			println("Params---------------------------------"+params)
			def id=app.id
			def checkForView = false
			def certInst = RecordCertificatePWM.findByApplication(bioMedicalWasteInstance)

			if(certInst)
			{
				checkForView = true
			}
			def roleHeader=app.role.roleName
			def indRegInstance=bioMedicalWasteInstance.industryRegMasterObj
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
			
			
			def recordCertificateInstanceBMW =new RecordCertificatePWM()
			
			WasteManagementCertificates file=new WasteManagementCertificates()
			

			def referenceDate=params.referenceDate_value

			def checkDate
			def x
			def y
			def zz

	try {
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 

				zz = sdfh.parse(referenceDate);
				checkDate="checked"
			}
			catch(Exception e) {
				flash.message="Enter Both The BMW Granted Dates "
				render(view:'uploadPwmCertificate',model:[appDetId:params.idIndApp,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,viewCert:viewCert])
			}

	if(checkDate) {
				
				java.sql.Date refDate = new java.sql.Date(zz.getTime())
				
				

				
	if(session.userMaster==null)
			    	{
						flash.message="Your session has been expired ! Please login again."
			    		redirect(uri:'/index.gsp')
			    		return
			    	}
					
					
					def refNo = ""
					if(params.referenceNo)
					{
						println("in if of ref    "+params.referenceNo)
						refNo = params.referenceNo
					}
					else
					{
						println("in elseeeeee of ref   "+params.referenceNo)
						flash.message="Please enter Reference no. for this application"
							render(view:'uploadPwmCertificate',model:[appDetId:params.idIndApp,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,checkForView:checkForView])
							return
					}
					recordCertificateInstanceBMW.referenceNo=refNo
					recordCertificateInstanceBMW.referenceDate=refDate
			    	
					recordCertificateInstanceBMW.updatedBy=session.userMaster
					recordCertificateInstanceBMW.createdBy=session.userMaster
				

					def fileid
						
							
								recordCertificateInstanceBMW.application=bioMedicalWasteInstance

								if(recordCertificateInstanceBMW.save()){
				    				println("----------------------instance saved---------------------")
				    			}
								
						if(!recordCertificateInstanceBMW.hasErrors()) {
						
						
						
						
							
						def f = request.getFile('BioMedicalWasteCertificate')
						println("f-----------"+f)
			    		println("------support system here----")
						if(!f.empty) {
							println("------support system here--222222222222222222222222--")
			    			MultipartFile multi = request.getFile('BioMedicalWasteCertificate')
							file.size = multi.getSize() / 1024
							file.extension = extractExtension( multi )
							file.data=multi.getBytes()
							 file.indreg=indRegInstanceGet
							def abc = "PlasticWasteCertificate"
				            def b = abc+"."+extractExtension( multi )
			            println("extractExtension( multi )....: "+extractExtension( multi ))
				            file.name =b
				            file.description="PlasticWaste - New Generation Record"	
				            	if(session.userMaster==null)
				            	{
				            		flash.message="Your session has been expired ! Please login again."
				            		redirect(uri:'/index.gsp')
				            		return
				            	}

							file.createdBy=(session.userMaster).toString()
					 	    file.updatedBy=(session.userMaster).toString()
							file.typeOfFile="PWM"
								file.applicationFor="PWM"
				 	    	file.applicationId=bioMedicalWasteInstance.id
				 	    	file.dateCreated=new Date()
					
							Byte[] bytes=multi.getBytes() 
	            	println("extractExtension( multi )..........."+extractExtension( multi ).getClass())

	            
							println("link22222")
							if(file.save(flush:true) && !file.hasErrors()) {
								
								fileid=file.id
								checkForView=true
								println("link22222223333"+file)						
								recordCertificateInstanceBMW.save ()  
								flash.message = "Certificate Generated and Record Saved "
								println("In save of binary")
							} else {
								println("ring")	
								file.errors.allErrors.each {
							println it
								}
								flash.userMessage = "File [${file.name}] has NOT not been uploaded."
									render(view:'uploadPwmCertificate',model:[appDetId:params.idIndApp,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,checkForView:checkForView])
							
							}
						}
								redirect(controller:'wasteManagementProcessingDetails', action:'appProcessing',params:[id:id,checkForView:checkForView,fileid:fileid])
								return;

	}
					else {
						flash.message="Can not contain special characters or reserve words"
						render(view:'uploadPwmCertificate',model:[appDetId:params.idIndApp,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,checkForView:checkForView])
					}
			
	}

	}
	
	def spcbShowFormNewFormat={ 	
            println("spcbShowFormNewFormat.."+params)
            def bioMedicalWasteInstance = PlasticWaste.get( params.appliId )        
            def appId=bioMedicalWasteInstance.id
            def appFor="PWM"
            def checkCertificate=WasteManagementCertificates.findAll("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
            def certInstance=checkCertificate[0]
            def certInstanceId
            if(certInstance){
            certInstanceId=certInstance.id
            }
        	IndUser indUserInstance=IndUser.find("from IndUser as bb where bb.industryRegMaster=?",[bioMedicalWasteInstance.industryRegMasterObj])
    		def induserQuery=IndUser.get(indUserInstance.id)
    		
    		
    		def indRegInstance=indUserInstance.industryRegMaster
    		def indRegInstanceId=indRegInstance.id
    		def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
        	
    		
          
            if(!bioMedicalWasteInstance) {
                flash.message = "PlasticWaste not found with id ${params.id}"
                redirect(action:list)
            }
            else {
            	render(view:'spcbShowFormNewFormat',model:[certInstanceId:certInstanceId, bioMedicalWasteInstance : bioMedicalWasteInstance ,indRegInstance:indRegInstance , id:bioMedicalWasteInstance.id ]) }
            	 
    
    }
	
	def showforSpcb = {
	    	println("---")
	        def plasticWasteInstance = PlasticWaste.get( params.id )
	        def appId=plasticWasteInstance.id
	        def appFor="PWM"
	       def viewCert=false
	        def checkCertificate=WasteManagementCertificates.find("from WasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=? order by wmc.id desc",[appId,appFor])
	       
	       if(checkCertificate){
	    	   viewCert=true
	       }
	       def certInstance=checkCertificate
	        def certInstanceId
	        if(certInstance){
	        certInstanceId=certInstance.id
	        }
	   def indRegInstance=plasticWasteInstance.industryRegMasterObj
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=indRegInstance
	    	def indusrtyInstance = indRegInstance
	         if(!plasticWasteInstance) {
	            flash.message = "PlasticWaste not found with id ${params.id}"
	            redirect(action:create)
	        }
	        else {
	        	   render(view:'show',model:[indusrtyInstance:indusrtyInstance,certInstanceId:certInstanceId, plasticWasteInstance : plasticWasteInstance ,indRegInstance:indRegInstance , id:plasticWasteInstance.id ,viewCert:viewCert])
	        }      
	     }
	
	def viewPwmCert={
		    
	    	def industryId = session.indUser
	    	def userId = session.userMaster
	    	if((userId==null || userId=="") && (industryId==null || industryId==""))
	    	{
	    		flash.message="Your session has been expired ! Please login again."
	    		redirect(controller:"userMaster",action:"logout")
	    	}
	    	println(params.id)
	    	def application = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.id=? and afr.typeOfFile='uploaded'",[params.id.toLong()])
println("-------application----"+application)
	    	def applicationFileSingleInstance=application
		   response.setContentType( "application-xdownload")
		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )

	    }
	
	def viewPlasticCert1={
	    	def industryId = session.indUser
	    	def userId = session.userMaster
	    	if((userId==null || userId=="") && (industryId==null || industryId==""))
	    	{
	    		flash.message="Your session has been expired ! Please login again."
	    		redirect(controller:"userMaster",action:"logout")
	    	}
	    	
	    	def temp=(params.id).toLong()
	    	def application = WasteManagementCertificates.findAll("from WasteManagementCertificates afr where afr.applicationId=? and afr.typeOfFile='PWM' order by afr.id desc",[params.id.toLong()],[max:1])
	  	
	    	def applicationFileSingleInstance=application[(application.size())-1]
		   response.setContentType( "application-xdownload")
		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		   response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )

	    }
	def list ={
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
				def industryId = session.indUser
				if(industryId==null || industryId=="") {
					flash.message="Your session has been expired ! Please login again."
					redirect(controller:"userMaster",action:"logout")
				}
				def indUserID = industryId.industryRegMaster
				def status1 = "Inprogress"
				def status2="Completed"
				def municipalSolidWasteInprogressList1 = PlasticWaste.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status1)
			    def municipalSolidWasteCompletedList1 = PlasticWaste.findAllWhere(industryRegMasterObj:indUserID , completionStatus : status2)
			
				
				params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				[municipalSolidWasteInprogressList1: municipalSolidWasteInprogressList1,municipalSolidWasteCompletedList1: municipalSolidWasteCompletedList1 ]
			  
					            
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
	
	def plasticWasteCheckBox ={
	        try {
	            System.out.println("Hey.. this is inside PlasticWasteCheckBox")

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
	def paymentOption={

			try {
			def indApp = params.indAppDetId
	    	def indApplicationDetailsInstance;
			
			def feeAmt =0;
			
			IndUser indUserInstance=(IndUser)session.indUser
			def indRegInstance=indUserInstance.industryRegMaster
			
	    	indApplicationDetailsInstance = PlasticWaste.get(params.indAppDetId)
	    	Random random = new Random(new Date().getTime());
	    	int randomInt = random.nextInt(1000000000);
	    	if(params.radio=="online")
	    	{
	    		 println("ABCS---B");    	
	    		render(view:'paymentOption',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,randomInt:randomInt])
	    	}
	    	else if (params.radio=="offline")
	    	{
	    		redirect(action:bankPaymentMode,id:indApplicationDetailsInstance)
	    	}else if(params.radio=="noPaymentNow"){
	    		def appFor='PWM'
	    		indApplicationDetailsInstance.completionStatus="Completed"
	    		indApplicationDetailsInstance.save();
	    		RoutePlasticWasteManagement routeWaste=new RoutePlasticWasteManagement()
	    	    def routed=routeWaste.routePlasticWasteManagementApp(indApplicationDetailsInstance.id,appFor,indRegInstance)
	    		updateAllSummaryReportWMS(indApplicationDetailsInstance.id.toString())
	    		
				render(view: 'confirmationSubmit', model: [pWasteInstance: indApplicationDetailsInstance, indRegInstance: indApplicationDetailsInstance])
		    	return;
	    	}}
	    	catch(Exception e)
		       {
		       	flash.message="Server is busy ,Please try after some time !" 
		       		if(session.indUser)
		       		  {
		       		   redirect(controller:'indUser',action:'openIndustryHome');				
		       		  }
		       		else if (session.userMaster)
		       		  {
		       		   redirect(controller:'userMaster',action:'openSpcbHome')
		       		  }
		       		else
		       		  {
		       		     session.invalidate()
		       		     redirect(uri:'/index.gsp')
		       		  }
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
			allSummaryReportWMSInstance.pendingWith=(WasteMgmtPendDetInstance.pendingWith.id).toString()
			
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
	def viewMswPdfNew={
			def docName = params.appltype
			def appId21=PlasticWaste.get((params.appliLoc).toLong());
			println("===appId21===="+appId21.id)
			println("===docName===="+docName)
			def application1 = WasteManagementFile.find("from WasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile=? order by crf.id desc",[appId21.id,docName])
	        def applicationInstance = application1
			response.setContentType( "application-xdownload")
			response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
			response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
	}
	def viewReturnReasonForPWaste={
			try {
			    			println("--invoked---"+params.id)
			    				def application = PlasticWaste.get((params.id).toLong())
			    				println("--invoked---"+application)
			    				def applicationProcessingDetailsInstanceList =  WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails w where w.applicationId=? order by w.id desc",[String.valueOf(application.id)]) 
			    				println("--invoked---"+applicationProcessingDetailsInstanceList.size())
			    				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
			    					if((applicationProcessingDetailsInstanceList.get(i)).returned==true){
			    						return[appReturn:applicationProcessingDetailsInstanceList.get(i),app:application]
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
}

