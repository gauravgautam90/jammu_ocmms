/**
 * @author Prashant Sharma
 *
 */
 import java.text.*;
 import java.io.*;
 import java.lang.NumberFormatException
 import org.apache.commons.fileupload.DiskFileUpload
 import org.apache.commons.fileupload.FileItem
 import org.apache.commons.io.*
 import org.springframework.web.multipart.MultipartFile
public class IndustryMasterDetailsController{
	
	def createIndustryMaster = {
			 try {
					def idAppl= (params.appliId).toLong()
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				    def roleHeader=app.role.roleName		
					def industryRegMasteInstance= indApplicationDetailsInstance.indUser		
					insertIndustryDataIntoMaster(indApplicationDetailsInstance.indUser)
					def industryMasterDetailsInstance=IndustryMasterDetails.findByIndUser(indApplicationDetailsInstance.indUser)			
					insertDataIntoMaster(indApplicationDetailsInstance);
					render(view:'createIndustryMaster',model:[roleHeader:roleHeader,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasteInstance:industryRegMasteInstance,industryMasterDetailsInstance:industryMasterDetailsInstance])
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
	
	def createWasteMasterData = {
			 try {
				 println("-----createWasteMasterData invoked-----"+params.appliId)
					def idAppl= (params.appliId).toLong()
					def applicationDetailsInstance
				    def app = WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=?",[String.valueOf(idAppl)])
					println("---------app---"+app)
				    def appFor=app.applicationFor
				    def industryRegMasteInstance
				    def appId=app.applicationId.toLong()
				    if(appFor=='HWM'){
				    	applicationDetailsInstance=HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp wm where wm.id=? order By wm.id desc",[appId])
				    	industryRegMasteInstance=applicationDetailsInstance.industryRegMasterObj
				    	
				    }else if(appFor=='BMW'){
				    	applicationDetailsInstance=BioMedicalWaste.find("from BioMedicalWaste wm where wm.id=? order By wm.id desc",[appId])
				    	industryRegMasteInstance=applicationDetailsInstance.industryRegMasterObj
				    	println("---------Industry Reg instance-----"+industryRegMasteInstance+applicationDetailsInstance)
				    	def roleHeader=app.role.roleName		
						insertIndustryDataIntoMaster(industryRegMasteInstance)
						def industryMasterDetailsInstance=IndustryMasterDetails.findByIndUser(industryRegMasteInstance)			
						insertBMWDataIntoMaster(applicationDetailsInstance);
						println("----app.applicationId--"+app.applicationId+"----"+app.applicationId.getClass())
						def wasteMasterInstance=WasteMasterDataDetails.find("from WasteMasterDataDetails bmw where bmw.applicationId=? ",[app.applicationId])
						println("----wasteMasterInstance---"+wasteMasterInstance)
						def bioMasterId=wasteMasterInstance.masterApplicationId.toLong()
						def biomedicalwasteMaster=BioMedicalWasteMaster.find("from BioMedicalWasteMaster bmw where bmw.id=? ",[bioMasterId])
						println("----biomedicalwasteMaster---"+biomedicalwasteMaster)
						render(view:'createWasteMaster',model:[roleHeader:roleHeader, bioMedicalWasteInst:biomedicalwasteMaster,industryRegMasteInstance:industryRegMasteInstance,industryMasterDetailsInstance:industryMasterDetailsInstance,app:app])
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
	
	
	
	def saveIndustryMaster = {
			 try {
				 println("params in saveIndustryMaster.."+saveIndustryMaster)
					def indApplicationDetailsInstance=IndApplicationDetails.get((params.id).toInteger())			
					def industryRegMasteInstance=indApplicationDetailsInstance.indUser
					println("-----------industryRegMasteInstance---------"+industryRegMasteInstance)
					def indMasterDetails=IndustryMasterDetails.findByIndUser(industryRegMasteInstance)
					println("-----------indMasterDetails---------"+indMasterDetails)
					def industryMasterRecordObj=IndustryMasterDetailsRecord.findByApplicationAndIndMasterUser(indApplicationDetailsInstance,indMasterDetails)
					println("-----------industryMasterRecordObj---------"+industryMasterRecordObj)
					industryRegMasteInstance.properties = params.properties
					def indMasterDetailsIns= IndustryMasterDetails.get((indMasterDetails.id).toLong())
					indMasterDetailsIns.properties = params.properties
					indMasterDetailsIns.indUser=industryRegMasteInstance
					if(!indMasterDetailsIns.hasErrors() && indMasterDetailsIns.save()) {
		 	       } else {
						indMasterDetailsIns.errors.each {
							println it
					    }
					}	
					if(!industryRegMasteInstance.hasErrors() && industryRegMasteInstance.save(flush:true)) {
						if(!industryMasterRecordObj){
							def IndustryMasterDetailsRecordNew=new IndustryMasterDetailsRecord()
							IndustryMasterDetailsRecordNew.application=indApplicationDetailsInstance
							IndustryMasterDetailsRecordNew.indMasterUser=indMasterDetailsIns
							IndustryMasterDetailsRecordNew.save(flush:true);
						}
		 	       } else {
						industryRegMasteInstance.errors.each {
							println it
					   }
					}	
					def mastReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Master Report'",[indApplicationDetailsInstance])
				if(mastReport)
	            		{
						mastReport.delete()
	            		}
				
				   FormPdf form=new FormPdf()
			    	def sessValue=(session.userMaster).toString()
			    	def formView
					if(indApplicationDetailsInstance.applicationFor=="air")
		    	{
						form.formAir(indApplicationDetailsInstance.id,sessValue)
		    	formView="air"
		    	}
		    	else
		    	{
		    	if(indApplicationDetailsInstance.applicationFor=="water")
		    	{
		    	form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
		    	formView="water"
		    	}
		    	else
		    	{
		    	form.formAir(indApplicationDetailsInstance.id,sessValue)
		    	form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
		    	formView="both"
		    	}
		    	}
			   def mastReportInst=IndustryMasterDetails.findByIndUser(industryRegMasteInstance)
				  UserMaster sess=(UserMaster)session.userMaster
					def userMasterInst=UserMaster.get(sess.id)
				MasterReport report=new MasterReport()
				   report.freshReport(indApplicationDetailsInstance.id,userMasterInst.id,mastReportInst)
					flash.message = "Master Report Details Saved"  
					println("----------saved-----"+indApplicationDetailsInstance.id)
				   redirect(controller:'applicationProcessingDetails',action:'appProcessing',params:["id":indApplicationDetailsInstance.id])
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

	def saveWasteMaster={
			try{
			println("----invoked ----"+params.id+params.noofbeds)
			
			def wasteMasterInstance=WasteMasterDataDetails.find("from WasteMasterDataDetails bmw where bmw.masterApplicationId=? ",[params.id])
			def biomedicalwasteMaster
			WasteMasterReport wmr= new WasteMasterReport()
			//def mastReportInst=IndustryMasterDetails.findByIndUser(wasteMasterInstance.indRegInstance)
			UserMaster sess=(UserMaster)session.userMaster
			def userMasterInst=UserMaster.get(sess.id)
			if(wasteMasterInstance){
			def bioMasterId=wasteMasterInstance.masterApplicationId.toLong()
			biomedicalwasteMaster=BioMedicalWasteMaster.find("from BioMedicalWasteMaster bmw where bmw.id=? ",[bioMasterId])
			if(biomedicalwasteMaster!=null){
				biomedicalwasteMaster.properties=params.properties
				//biomedicalwasteMaster.noofbeds=params.noofbeds
				//biomedicalwasteMaster.patientspermonth=params.patientspermonth
				biomedicalwasteMaster.save()
			}}
			def app = WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=?",[wasteMasterInstance.applicationId])
			println("---waste mnmt app ---"+app)
			def industryMasterDetailsInstance=IndustryMasterDetails.findByIndUser(wasteMasterInstance.indRegInstance)
			industryMasterDetailsInstance.properties=params.properties
			industryMasterDetailsInstance.save()
			println("---waste mnmt app ---"+industryMasterDetailsInstance)
			def roleHeader=app.role.roleName
			def industryRegMasteInstance=biomedicalwasteMaster.industryRegMasterObj
			industryRegMasteInstance.properties=params.properties
			industryRegMasteInstance.save()
			//println("--biomedicalwasteMaster---"+biomedicalwasteMaster.getClass()+"--wasteMasterInstance---"+wasteMasterInstance.getClass()+"----userMasterInst------"+userMasterInst.getClass()+"---mastReportInst--"+mastReportInst.getClass())
			wmr.freshReportForWasteMaster(userMasterInst.id,industryMasterDetailsInstance,biomedicalwasteMaster,,wasteMasterInstance)
			println("---biomedicalwasteMaster---"+biomedicalwasteMaster)
			//render(view:'createWasteMaster',model:[roleHeader:roleHeader, bioMedicalWasteInst:biomedicalwasteMaster,industryRegMasteInstance:industryRegMasteInstance,industryMasterDetailsInstance:industryMasterDetailsInstance,app:app])
			redirect(controller:'wasteManagementProcessingDetails',action:'appProcessing',params:["id":app.id])
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
}}
	/*def saveWasteMaster={
	 try {
		 println("params in saveIndustryMaster.."+saveIndustryMaster)
			def indApplicationDetailsInstance=IndApplicationDetails.get((params.id).toInteger())			
			def industryRegMasteInstance=indApplicationDetailsInstance.indUser
			println("-----------industryRegMasteInstance---------"+industryRegMasteInstance)
			def indMasterDetails=IndustryMasterDetails.findByIndUser(industryRegMasteInstance)
			println("-----------indMasterDetails---------"+indMasterDetails)
			def industryMasterRecordObj=IndustryMasterDetailsRecord.findByApplicationAndIndMasterUser(indApplicationDetailsInstance,indMasterDetails)
			println("-----------industryMasterRecordObj---------"+industryMasterRecordObj)
			industryRegMasteInstance.properties = params.properties
			def indMasterDetailsIns= IndustryMasterDetails.get((indMasterDetails.id).toLong())
			indMasterDetailsIns.properties = params.properties
			indMasterDetailsIns.indUser=industryRegMasteInstance
			if(!indMasterDetailsIns.hasErrors() && indMasterDetailsIns.save()) {
 	       } else {
				indMasterDetailsIns.errors.each {
					println it
			    }
			}	
			if(!industryRegMasteInstance.hasErrors() && industryRegMasteInstance.save(flush:true)) {
				if(!industryMasterRecordObj){
					def IndustryMasterDetailsRecordNew=new IndustryMasterDetailsRecord()
					IndustryMasterDetailsRecordNew.application=indApplicationDetailsInstance
					IndustryMasterDetailsRecordNew.indMasterUser=indMasterDetailsIns
					IndustryMasterDetailsRecordNew.save(flush:true);
				}
 	       } else {
				industryRegMasteInstance.errors.each {
					println it
			   }
			}	
			def mastReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Master Report'",[indApplicationDetailsInstance])
		if(mastReport)
        		{
				mastReport.delete()
        		}
		
		   FormPdf form=new FormPdf()
	    	def sessValue=(session.userMaster).toString()
	    	def formView
			if(indApplicationDetailsInstance.applicationFor=="air")
    	{
				form.formAir(indApplicationDetailsInstance.id,sessValue)
    	formView="air"
    	}
    	else
    	{
    	if(indApplicationDetailsInstance.applicationFor=="water")
    	{
    	form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
    	formView="water"
    	}
    	else
    	{
    	form.formAir(indApplicationDetailsInstance.id,sessValue)
    	form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
    	formView="both"
    	}
    	}
	   def mastReportInst=IndustryMasterDetails.findByIndUser(industryRegMasteInstance)
		  UserMaster sess=(UserMaster)session.userMaster
			def userMasterInst=UserMaster.get(sess.id)
		MasterReport report=new MasterReport()
		   report.freshReport(indApplicationDetailsInstance.id,userMasterInst.id,mastReportInst)
			flash.message = "Master Report Details Saved"  
			println("----------saved-----"+indApplicationDetailsInstance.id)
		   redirect(controller:'applicationProcessingDetails',action:'appProcessing',params:["id":indApplicationDetailsInstance.id])
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
   }}
   */

	
def viewIndustryMaster = {
			 try {
					def idAppl= (params.id).toLong()
					println("zzzzzz"+idAppl)
					def indApplicationDetailsInstance=IndApplicationDetails.get(idAppl)
					println("indApplicationDetailsInstance"+indApplicationDetailsInstance)
					def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
				    println("app"+app)
					def roleHeader=app.role.roleName	
					def industryRegMasteInstance=indApplicationDetailsInstance.indUser		
					def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
		        	def intTest
		        	if(consentFeeMasterInstance){
		        	intTest=(int)consentFeeMasterInstance.totalApplicableFee
		        	}
					def industryMasterDetailsInstance=IndustryMasterDetails.findByIndUser(indApplicationDetailsInstance.indUser)
					render(view:'viewIndustryMaster',model:[roleHeader:roleHeader,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasteInstance:industryRegMasteInstance,consentFeeMasterInstance:consentFeeMasterInstance,intTest:intTest,industryMasterDetailsInstance:industryMasterDetailsInstance])
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
	
	
	def printFreshMasterReport={
			 try {
		   		 def applicationFileInstance
		 	    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
		 	    	println("aaaaaa..."+application)
		 	    	applicationFileInstance=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Master Report' order by afr.id desc",[application])
		 	    	println("bbbbbb..."+applicationFileInstance)
		 	    	def applicationFileSingleInstance=applicationFileInstance
		 	    	println("ccccccccc..."+applicationFileSingleInstance)
		 	    	response.setContentType( "application-xdownload")
		 		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
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
	
	
	def insertDataIntoMaster(IndApplicationDetails indAppDetailInstance) {
		println("params in insertDataIntoMaster.."+params)
		 try {
				//air stack emmission 1
				def airInstanceList = AirStackDetailsMaster.findAll("from AirStackDetailsMaster where application = ? ",[indAppDetailInstance])
				if(airInstanceList.size() == 0){
	        		def oldAirInstanceList = AirStackDetails.findAll("from AirStackDetails where application = ? ",[indAppDetailInstance])
	        		if(oldAirInstanceList.size() != 0){
	        			for(int i=0;i<oldAirInstanceList.size();i++){
	        				AirStackDetailsMaster airStackMaster = new AirStackDetailsMaster();
	        				def oldAirstackSingleInstance = AirStackDetails.find("from AirStackDetails where id = ? ",[oldAirInstanceList.get(i).id])
	        				airStackMaster.application   = indAppDetailInstance
	        				airStackMaster.stack  = oldAirstackSingleInstance.stack
	        				airStackMaster.heightGrdLevel  = oldAirstackSingleInstance.heightGrdLevel
	        				airStackMaster.heightFacLevel  = oldAirstackSingleInstance.heightFacLevel
	        				airStackMaster.draftType  = oldAirstackSingleInstance.draftType
	        				airStackMaster.matOfCon  = oldAirstackSingleInstance.matOfCon
	        				airStackMaster.capacity  = oldAirstackSingleInstance.capacity
	        				airStackMaster.unit	 = oldAirstackSingleInstance.unit
	        				airStackMaster.fuelTyp  = oldAirstackSingleInstance.fuelTyp
	        				airStackMaster.fuelQty  = oldAirstackSingleInstance.fuelQty
	        				airStackMaster.gasQty  = oldAirstackSingleInstance.gasQty
	        				airStackMaster.shape  = oldAirstackSingleInstance.shape
	        				airStackMaster.diamSize  = oldAirstackSingleInstance.diamSize
	        				airStackMaster.gasTemp  = oldAirstackSingleInstance.gasTemp
	        				airStackMaster.gasVel  = oldAirstackSingleInstance.gasVel
	        				if(!airStackMaster.hasErrors() && airStackMaster.save(flush:true)) {
	        	 	       } else {
	        					airStackMaster.errors.each {
	        				   }
	        				}	
	        			}
	        		}else{
	        		}
	       	 }
//				air stack emmission 2
				def newList = AirFlueGasDetailsMaster.findAll("from AirFlueGasDetailsMaster where application = ? ",[indAppDetailInstance])
				if(newList.size() == 0){
	        		def oldList = AirFlueGasDetails.findAll("from AirFlueGasDetails where application = ? ",[indAppDetailInstance])
	        		if(oldList.size() != 0){
	        			for(int i=0;i<oldList.size();i++){
	        				AirFlueGasDetailsMaster master = new AirFlueGasDetailsMaster();
	        				def oldSingleInstance = AirFlueGasDetails.find("from AirFlueGasDetails where id = ? ",[oldList.get(i).id])
	        				master.application   = indAppDetailInstance
	        				master.fuel  = oldSingleInstance.fuel
	        				master.consumption  = oldSingleInstance.consumption
	        				master.calorValue  = oldSingleInstance.calorValue
	        				master.ashCon  = oldSingleInstance.ashCon
	        				master.sulphurCon  = oldSingleInstance.sulphurCon
	        				master.otherCon  = oldSingleInstance.otherCon
	        				def obj = AirStackDetailsMaster.findByApplication(indAppDetailInstance)
	        				master.stack  =  obj
	        				master.unit  = oldSingleInstance.unit
	        				if(!master.hasErrors() && master.save(flush:true)) {
	        	 	       	} else {
	        					master.errors.each {
	        				   }
	        				}	
	        			}
	        		}else{
	        		}
	       	 }
//				air stack emmission 3
				def newList1 = AirMiscDetailsMaster.findAll("from AirMiscDetailsMaster where application = ? ",[indAppDetailInstance])
				if(newList1.size() == 0){
	        		def oldList1 = AirMiscDetails.findAll("from AirMiscDetails where application = ? ",[indAppDetailInstance])
	        		if(oldList1.size() != 0){
	        			for(int i=0;i<oldList1.size();i++){
	        				AirMiscDetailsMaster master1 = new AirMiscDetailsMaster();
	        				def oldSingleInstance1 = AirMiscDetails.find("from AirMiscDetails where id = ? ",[oldList1.get(i).id])
	        				master1.application   = indAppDetailInstance
	        				master1.facility  = oldSingleInstance1.facility
	        				master1.quality   = oldSingleInstance1.quality
	        				master1.odorCompounds = oldSingleInstance1.odorCompounds
	        				if(!master1.hasErrors() && master1.save(flush:true)) {
	        	 	       } else {
	        					master1.errors.each {
	        				    }
	        				}	
	        			}
	        		}else{
	        		}
	       	 }
//				water source 1
				def newList6 = WaterSourceDetailsMaster.findAll("from WaterSourceDetailsMaster where application = ? ",[indAppDetailInstance])
				if(newList6.size() == 0){
					def oldList6 = WaterSourceDetails.findAll("from WaterSourceDetails where application = ? ",[indAppDetailInstance])
					if(oldList6.size() != 0){
						for(int i=0;i<oldList6.size();i++){
							WaterSourceDetailsMaster master6 = new WaterSourceDetailsMaster();
							def oldSingleInstance6 = WaterSourceDetails.find("from WaterSourceDetails where id = ? ",[oldList6.get(i).id])
							master6.application   = indAppDetailInstance
							master6.source = oldSingleInstance6.source
							master6.quantity = oldSingleInstance6.quantity
							master6.sourceName = oldSingleInstance6.sourceName
							if(!master6.hasErrors() && master6.save(flush:true)) {
				 	       	} else {
								master6.errors.each {
							    }
							}	
						}
					}else{
					}
				 }
//		water source 2
		def newList2 = WasteWaterTreatmentDetailsMaster.findAll("from WasteWaterTreatmentDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList2.size() == 0){
			def oldList2 = WasteWaterTreatmentDetails.findAll("from WasteWaterTreatmentDetails where application = ? ",[indAppDetailInstance])
			if(oldList2.size() != 0){
				for(int i=0;i<oldList2.size();i++){
					WasteWaterTreatmentDetailsMaster master2 = new WasteWaterTreatmentDetailsMaster();
					def oldSingleInstance2 = WasteWaterTreatmentDetails.find("from WasteWaterTreatmentDetails where id = ? ",[oldList2.get(i).id])
					master2.application   = indAppDetailInstance
					master2.treatmentUnits = oldSingleInstance2.treatmentUnits
					master2.capacity = oldSingleInstance2.capacity
					master2.uses = oldSingleInstance2.uses
					master2.effluentGeneration = oldSingleInstance2.effluentGeneration
					master2.treatmentArrangementStatus  = oldSingleInstance2.treatmentArrangementStatus
					master2.monitoringArrangementDetails  = oldSingleInstance2.monitoringArrangementDetails
					master2.treatedEffluentQuality  = oldSingleInstance2.treatedEffluentQuality
					master2.parametersQuantity  = oldSingleInstance2.parametersQuantity
					master2.investmentInTreatmentUnit  = oldSingleInstance2.investmentInTreatmentUnit
					master2.parametersQuantityTreated  = oldSingleInstance2.parametersQuantityTreated
					master2.category  = oldSingleInstance2.category
					if(!master2.hasErrors() && master2.save(flush:true)) {
		 	       } else {
						master2.errors.each {
					   }
					}	
				}
			}else{
			}
		 }
//		water source 3
		def newList3 = WaterWasteGenerationDetailsMaster.findAll("from WaterWasteGenerationDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList3.size() == 0){
			def oldList3 = WaterWasteGenerationDetails.findAll("from WaterWasteGenerationDetails where application = ? ",[indAppDetailInstance])
			if(oldList3.size() != 0){
				for(int i=0;i<oldList3.size();i++){
					WaterWasteGenerationDetailsMaster master3 = new WaterWasteGenerationDetailsMaster();
					def oldSingleInstance3 = WaterWasteGenerationDetails.find("from WaterWasteGenerationDetails where id = ? ",[oldList3.get(i).id])
					master3.application   = indAppDetailInstance
					master3.disposalMode = oldSingleInstance3.disposalMode
					master3.typeOfEffluent = oldSingleInstance3.typeOfEffluent
					master3.maxGeneration = oldSingleInstance3.maxGeneration
					master3.effRecycle = oldSingleInstance3.effRecycle
					master3.effDischarge = oldSingleInstance3.effDischarge
					if(!master3.hasErrors() && master3.save(flush:true)) {
		 	       } else {
						master3.errors.each {
					    }
					}	
				}
			}else{
			}
		 }
//		water source 4
		def newList4 = WaterSolidWasteGenDetailsMaster.findAll("from WaterSolidWasteGenDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList4.size() == 0){
			def oldList4 = WaterSolidWasteGenDetails.findAll("from WaterSolidWasteGenDetails where application = ? ",[indAppDetailInstance])
			if(oldList4.size() != 0){
				for(int i=0;i<oldList4.size();i++){
					WaterSolidWasteGenDetailsMaster master4 = new WaterSolidWasteGenDetailsMaster();
					def oldSingleInstance4 = WaterSolidWasteGenDetails.find("from WaterSolidWasteGenDetails where id = ? ",[oldList4.get(i).id])
					master4.application   = indAppDetailInstance
					master4.description = oldSingleInstance4.description
					master4.quantQual = oldSingleInstance4.quantQual
					master4.meathodCollection = oldSingleInstance4.meathodCollection
					master4.meathodDisposal = oldSingleInstance4.meathodDisposal
					if(!master4.hasErrors() && master4.save(flush:true)) {
		 	       	} else {
						master4.errors.each {
					    }
					}	
				}
			}else{
			}
		 }
//		product 1 
		def newList5 = IndProductDetailsMaster.findAll("from IndProductDetailsMaster where application = ? ",[indAppDetailInstance])
		println("IndProductDetailsMaster.."+newList5.size())
		if(newList5.size() == 0){
			def oldList5 = IndProductDetails.findAll("from IndProductDetails where application = ? ",[indAppDetailInstance])
			println("IndProductDetails.."+oldList5)
			println("IndProductDetails.."+oldList5.size())
			if(oldList5.size() != 0){
				for(int i=0;i<oldList5.size();i++){
					IndProductDetailsMaster master5 = new IndProductDetailsMaster();
					def oldSingleInstance5 = IndProductDetails.find("from IndProductDetails where id = ? ",[oldList5.get(i).id])
					master5.application   = indAppDetailInstance
					master5.product = oldSingleInstance5.product
					master5.quantity = oldSingleInstance5.quantity
					master5.unit = oldSingleInstance5.unit
					master5.byProduct = oldSingleInstance5.byProduct
					master5.unitbyProduct = oldSingleInstance5.unitbyProduct
					master5.rawMaterials = oldSingleInstance5.rawMaterials
					if(!master5.hasErrors() && master5.save(flush:true)) {
		 	       	} else {
						master5.errors.each {
					   }
					}	
				}
			}else{
			}
		 }
//////////////////	 Stonme crusher////////////////////////////////////
def newList61= StoneCrusherSittingCriteriaMaster.findAll("from StoneCrusherSittingCriteriaMaster where application = ? ",[indAppDetailInstance])
		if(newList61.size() == 0){
			def oldList61 = StoneCrusherSittingCriteria.findAll("from StoneCrusherSittingCriteria where application = ? ",[indAppDetailInstance])
			if(oldList61.size() != 0){
				for(int i=0;i<oldList61.size();i++){
					StoneCrusherSittingCriteriaMaster master61= new StoneCrusherSittingCriteriaMaster();
					def oldSingleInstance61= StoneCrusherSittingCriteria.find("from StoneCrusherSittingCriteria where id = ? ",[oldList61.get(i).id])
					master61.application   = indAppDetailInstance
					master61.parameter = oldSingleInstance61.parameter
					master61.distance = oldSingleInstance61.distance
					if(!master61.hasErrors() && master61.save(flush:true)) {
		 	       	} else {
						master61.errors.each {
					   }
					}	
				}
			}else{
			}
		 }
////////////////////////////////////////////////////////////////////////////
def newList61Z= StoneCrusherControlDevicesMasterM.findAll("from StoneCrusherControlDevicesMasterM where application = ? ",[indAppDetailInstance])
if(newList61Z.size() == 0){
	def oldList61Z = StoneCrusherControlDevices.findAll("from StoneCrusherControlDevices where application = ? ",[indAppDetailInstance])
	if(oldList61Z.size() != 0){
		for(int i=0;i<oldList61Z.size();i++){
			StoneCrusherControlDevicesMasterM master61Z= new StoneCrusherControlDevicesMasterM();
			def oldSingleInstance61Z= StoneCrusherControlDevices.find("from StoneCrusherControlDevices where id = ? ",[oldList61Z.get(i).id])
			master61Z.application   = indAppDetailInstance
			master61Z.device = oldSingleInstance61Z.device
			master61Z.name = oldSingleInstance61Z.name
			master61Z.status = oldSingleInstance61Z.status
			if(!master61Z.hasErrors() && master61Z.save(flush:true)) {
 	       	} else {
 	       	master61Z.errors.each {
			   }
			}	
		}
	}else{
	}
 }




		def newList8 = NocAuthorityDetailsMaster.findAll("from NocAuthorityDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList8.size() == 0){
			def oldList8 = NocAuthorityDetails.findAll("from NocAuthorityDetails where application = ? ",[indAppDetailInstance])
			if(oldList8.size() != 0){
				for(int i=0;i<oldList8.size();i++){
					NocAuthorityDetailsMaster master8 = new NocAuthorityDetailsMaster();
					def oldSingleInstance8 = NocAuthorityDetails.find("from NocAuthorityDetails where id = ? ",[oldList8.get(i).id])
					master8.application   = indAppDetailInstance
					master8.authorityDetails = oldSingleInstance8.authorityDetails
					master8.number = oldSingleInstance8.number
					master8.status=oldSingleInstance8.status
					master8.date=oldSingleInstance8.date
					if(!master8.hasErrors() && master8.save(flush:true)) {
		 	       } else {
						master8.errors.each {
					   }
					}	
				}
			}else{
			}
		 }

def newList9 = StoneCrusherWaterReqMaster.findAll("from StoneCrusherWaterReqMaster where application = ? ",[indAppDetailInstance])
		if(newList9.size() == 0){
			def oldList9 = StoneCrusherWaterReq.findAll("from StoneCrusherWaterReq where application = ? ",[indAppDetailInstance])
			if(oldList9.size() != 0){
				for(int i=0;i<oldList9.size();i++){
					StoneCrusherWaterReqMaster master9 = new StoneCrusherWaterReqMaster();
					def oldSingleInstance9 = StoneCrusherWaterReq.find("from StoneCrusherWaterReq where id = ? ",[oldList9.get(i).id])
					master9.application   = indAppDetailInstance
					master9.sourceOfWaterSupply = oldSingleInstance9.sourceOfWaterSupply
					master9.quantity = oldSingleInstance9.quantity
					if(!master9.hasErrors() && master9.save(flush:true)) {
		 	       	} else {
						master9.errors.each {
					    }
					}	
				}
			}else{
			}
		 }

def newList10 = WaterConsumptionDetailMaster.findAll("from WaterConsumptionDetailMaster where application = ? ",[indAppDetailInstance])
		if(newList10.size() == 0){
			def oldList10 = WaterConsumptionDetail.findAll("from WaterConsumptionDetail where application = ? ",[indAppDetailInstance])
			if(oldList10.size() != 0){
				for(int i=0;i<oldList10.size();i++){
					WaterConsumptionDetailMaster master10 = new WaterConsumptionDetailMaster();
					def oldSingleInstance10 = WaterConsumptionDetail.find("from WaterConsumptionDetail where id = ? ",[oldList10.get(i).id])
					master10.application   = indAppDetailInstance
					master10.waterConsumptionType = oldSingleInstance10.waterConsumptionType
					master10.quantity = oldSingleInstance10.quantity
					master10.storageFacility=oldSingleInstance10.storageFacility
					if(!master10.hasErrors() && master10.save(flush:true)) {
		 	       	} else {
						master10.errors.each {
					    }
					}	
				}
			}else{
			
			}
		 }
//////////////////////////////////////////////	/DG set/////////////////////////////////////////////////
def newList11 = DGSetDetailsMaster.findAll("from DGSetDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList11.size() == 0){
			def oldList11 = DGSetDetails.findAll("from DGSetDetails where application = ? ",[indAppDetailInstance])
			if(oldList11.size() != 0){
				for(int i=0;i<oldList11.size();i++){
					DGSetDetailsMaster master11 = new DGSetDetailsMaster();
					def oldSingleInstance11 = DGSetDetails.find("from DGSetDetails where id = ? ",[oldList11.get(i).id])
					master11.application   = indAppDetailInstance
					master11.makeDGset = oldSingleInstance11.makeDGset
					master11.modelDGset = oldSingleInstance11.modelDGset
					master11.powerRating=oldSingleInstance11.powerRating
					master11.soundLevel = oldSingleInstance11.soundLevel
					master11.location = oldSingleInstance11.location
					master11.loadShedding=oldSingleInstance11.loadShedding
					master11.sheddingInfo = oldSingleInstance11.sheddingInfo
					master11.noise = oldSingleInstance11.noise
					master11.room=oldSingleInstance11.room
					master11.exhaustGas = oldSingleInstance11.exhaustGas
					master11.installation = oldSingleInstance11.installation
					master11.minVibration=oldSingleInstance11.minVibration
					master11.minLeaks = oldSingleInstance11.minLeaks
					master11.fuel = oldSingleInstance11.fuel
					master11.stackHeight=oldSingleInstance11.stackHeight
					master11.heightOfBuilding = oldSingleInstance11.heightOfBuilding
					master11.totalHeight = oldSingleInstance11.totalHeight
					if(!master11.hasErrors() && master11.save(flush:true)) {
		 	       } else {
						master11.errors.each {
					    }
					}	
				}
			}else{
			}
		 }

def newList12 = DGSetEmissionDetailsMaster.findAll("from DGSetEmissionDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList12.size() == 0){
			def oldList12 = DGSetEmissionDetails.findAll("from DGSetEmissionDetails where application = ? ",[indAppDetailInstance])
			if(oldList12.size() != 0){
				for(int i=0;i<oldList12.size();i++){
					DGSetEmissionDetailsMaster master12 = new DGSetEmissionDetailsMaster();
					def oldSingleInstance12 = DGSetDetails.find("from DGSetEmissionDetails where id = ? ",[oldList12.get(i).id])
					master12.application   = indAppDetailInstance
					master12.source = oldSingleInstance12.source
					master12.horsePower = oldSingleInstance12.horsePower
					master12.noLoadRPM=oldSingleInstance12.noLoadRPM
					master12.fullLoadRPM = oldSingleInstance12.fullLoadRPM
					master12.fuelQuantity = oldSingleInstance12.fuelQuantity
					master12.capacity=oldSingleInstance12.capacity
					master12.buildingHeight = oldSingleInstance12.buildingHeight
					master12.stackHeight = oldSingleInstance12.stackHeight
					master12.totalHeight=oldSingleInstance12.totalHeight
					if(!master12.hasErrors() && master12.save(flush:true)) {
		 	       	} else {
						master12.errors.each {
					   }
					}	
				}
			}else{
			}
		 }

def newList13 = DGSetParameterDetailsMaster.findAll("from DGSetParameterDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList13.size() == 0){
			def oldList13 = DGSetParameterDetails.findAll("from DGSetParameterDetails where application = ? ",[indAppDetailInstance])
			if(oldList13.size() != 0){
				for(int i=0;i<oldList13.size();i++){
					DGSetParameterDetailsMaster master13 = new DGSetParameterDetailsMaster();
					def oldSingleInstance13 = DGSetParameterDetails.find("from DGSetParameterDetails where id = ? ",[oldList13.get(i).id])
					master13.application   = indAppDetailInstance
					master13.parameters = oldSingleInstance13.parameters
					master13.noLoad=oldSingleInstance13.noLoad
					master13.fullLoad = oldSingleInstance13.fullLoad
					if(!master13.hasErrors() && master13.save(flush:true)) {
		 	       } else {
						master13.errors.each {
					   }
					}	
				}
			}else{
			}
		 }

def newList14 = BrickSittingCriteriaDetailsMaster.findAll("from BrickSittingCriteriaDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList14.size() == 0){
			def oldList14 = BrickSittingCriteriaDetails.findAll("from BrickSittingCriteriaDetails where application = ? ",[indAppDetailInstance])
			if(oldList14.size() != 0){
				for(int i=0;i<oldList14.size();i++){
					BrickSittingCriteriaDetailsMaster master14 = new BrickSittingCriteriaDetailsMaster();
					def oldSingleInstance14 = BrickSittingCriteriaDetails.find("from BrickSittingCriteriaDetails where id = ? ",[oldList14.get(i).id])
					master14.application   = indAppDetailInstance
					master14.parameter = oldSingleInstance14.parameter
					master14.distance=oldSingleInstance14.distance
					if(!master14.hasErrors() && master14.save(flush:true)) {
		 	       	} else {
						master14.errors.each {
					   }
					}	
				}
			}else{
			}
		 }

def newList15 = BrickKilnDetailMaster.findAll("from BrickKilnDetailMaster where application = ? ",[indAppDetailInstance])
		if(newList15.size() == 0){
			def oldList15 = BrickKilnDetail.findAll("from BrickKilnDetail where application = ? ",[indAppDetailInstance])
			if(oldList15.size() != 0){
				for(int i=0;i<oldList15.size();i++){
					BrickKilnDetailMaster master15 = new BrickKilnDetailMaster();
					def oldSingleInstance15 = BrickKilnDetail.find("from BrickKilnDetail where id = ? ",[oldList15.get(i).id])
					master15.application   = indAppDetailInstance
					master15.capacity = oldSingleInstance15.capacity
					master15.trenchSize = oldSingleInstance15.trenchSize
					master15.chimeny=oldSingleInstance15.chimeny
					master15.height = oldSingleInstance15.height
					master15.ecd = oldSingleInstance15.ecd
					master15.cluster=oldSingleInstance15.cluster
					if(!master15.hasErrors() && master15.save(flush:true)) {
		 	       } else {
						master15.errors.each {
					   }
					}	
				}
			}else{
			}
		 }

def newList16 = HotelGeneralDetailsMaster.findAll("from HotelGeneralDetailsMaster where application = ? ",[indAppDetailInstance])
		if(newList16.size() == 0){
			def oldList16 = HotelGeneralDetails.findAll("from HotelGeneralDetails where application = ? ",[indAppDetailInstance])
			if(oldList16.size() != 0){
				for(int i=0;i<oldList16.size();i++){
					HotelGeneralDetailsMaster master16= new HotelGeneralDetailsMaster();
					def oldSingleInstance16 = HotelGeneralDetails.find("from HotelGeneralDetails where id = ? ",[oldList16.get(i).id])
					master16.application   = indAppDetailInstance
					master16.hotelName = oldSingleInstance16.hotelName
					master16.roomCapacity = oldSingleInstance16.roomCapacity
					master16.restaurantN=oldSingleInstance16.restaurantN
					master16.capacity = oldSingleInstance16.capacity
					master16.year = oldSingleInstance16.year
					master16.investment=oldSingleInstance16.investment
					master16.location = oldSingleInstance16.location
					master16.distance = oldSingleInstance16.distance
					master16.prevention=oldSingleInstance16.prevention
					master16.relInfo = oldSingleInstance16.relInfo
					master16.dgSet = oldSingleInstance16.dgSet
					master16.make=oldSingleInstance16.make
					master16.dgcapacity = oldSingleInstance16.dgcapacity
					master16.deptTourism = oldSingleInstance16.deptTourism
					master16.tourismDetails=oldSingleInstance16.tourismDetails
					master16.septicTank = oldSingleInstance16.septicTank
					master16.soakagePit = oldSingleInstance16.soakagePit
					master16.sewagePlant=oldSingleInstance16.sewagePlant
					master16.hotelchimeny = oldSingleInstance16.hotelchimeny
					master16.exhaustFans = oldSingleInstance16.exhaustFans
					master16.solidWaste=oldSingleInstance16.solidWaste
					master16.greenery = oldSingleInstance16.greenery
					master16.indpendentRestaurant = oldSingleInstance16.indpendentRestaurant
					master16.nocObtained=oldSingleInstance16.nocObtained
					if(!master16.hasErrors() && master16.save(flush:true)) {
		 	       	} else {
						master16.errors.each {
					    }
					}	
				}
			}else{
			}
		 }

		def newList17 = HotelFacilityDetailMaster.findAll("from HotelFacilityDetailMaster where application = ? ",[indAppDetailInstance])
		if(newList17.size() == 0){
			def oldList17 = HotelFacilityDetail.findAll("from HotelFacilityDetail where application = ? ",[indAppDetailInstance])
			if(oldList17.size() != 0){
				for(int i=0;i<oldList17.size();i++){
					HotelFacilityDetailMaster master17 = new HotelFacilityDetailMaster();
					def oldSingleInstance17 = HotelFacilityDetail.find("from HotelFacilityDetail where id = ? ",[oldList17.get(i).id])
					master17.application   = indAppDetailInstance
					master17.hotelFacilityType = oldSingleInstance17.hotelFacilityType
					master17.facility = oldSingleInstance17.facility
					master17.capacity=oldSingleInstance17.capacity
					master17.facilityDetail = oldSingleInstance17.facilityDetail
					if(!master17.hasErrors() && master17.save(flush:true)) {
		 	       	} else {
						master17.errors.each {
					    }
					}	
				}
			}else{
			}
		 }

def newList18 = HotelWasteEmissionDetailMaster.findAll("from HotelWasteEmissionDetailMaster where application = ? ",[indAppDetailInstance])
		if(newList18.size() == 0){
			def oldList18 = HotelWasteEmissionDetail.findAll("from HotelWasteEmissionDetail where application = ? ",[indAppDetailInstance])
			if(oldList18.size() != 0){
				for(int i=0;i<oldList18.size();i++){
					HotelWasteEmissionDetailMaster master18 = new HotelWasteEmissionDetailMaster();
					def oldSingleInstance18 = HotelWasteEmissionDetail.find("from HotelWasteEmissionDetail where id = ? ",[oldList18.get(i).id])
					master18.application   = indAppDetailInstance
					master18.type = oldSingleInstance18.type
					master18.quantity = oldSingleInstance18.quantity
					master18.nature=oldSingleInstance18.nature
					master18.tmethod = oldSingleInstance18.tmethod
					if(!master18.hasErrors() && master18.save(flush:true)) {
		 	       	} else {
						master18.errors.each {
					   }
					}	
				}
			}else{
			}
		 }

def newList19 = HotelWaterConsumptionDetailMaster.findAll("from HotelWaterConsumptionDetailMaster where application = ? ",[indAppDetailInstance])
		if(newList19.size() == 0){
			def oldList19 = HotelWaterConsumptionDetail.findAll("from HotelWaterConsumptionDetail where application = ? ",[indAppDetailInstance])
			if(oldList19.size() != 0){
				for(int i=0;i<oldList19.size();i++){
					HotelWaterConsumptionDetailMaster master19 = new HotelWaterConsumptionDetailMaster();
					def oldSingleInstance19 = HotelWaterConsumptionDetail.find("from HotelWaterConsumptionDetail where id = ? ",[oldList19.get(i).id])
					master19.application   = indAppDetailInstance
					master19.type = oldSingleInstance19.type
					master19.quantity = oldSingleInstance19.quantity
					if(!master19.hasErrors() && master19.save(flush:true)) {
		 	       	} else {
						master19.errors.each {
					    }
					}	
				}
			}else{
			}
		 }
////////////////////////Hazardeous Details////////////////////////////////////////////////////////////////
def newList20 = HazardousWasteGenDetailsMaster.findAll("from HazardousWasteGenDetailsMaster where application = ? ",[indAppDetailInstance])
if(newList20.size() == 0){
	def oldList20 = HazardousWasteGenDetails.findAll("from HazardousWasteGenDetails where application = ? ",[indAppDetailInstance])
	if(oldList20.size() != 0){
		for(int i=0;i<oldList20.size();i++){
			HazardousWasteGenDetailsMaster master1 = new HazardousWasteGenDetailsMaster();
			def oldSingleInstance1 = HazardousWasteGenDetails.find("from HazardousWasteGenDetails where id = ? ",[oldList20.get(i).id])
			master1.application   = indAppDetailInstance
			master1.authFor  = oldSingleInstance1.authFor
			master1.sourceName  = oldSingleInstance1.sourceName
			master1.categoryName = oldSingleInstance1.categoryName
			master1.quantity = oldSingleInstance1.quantity
			if(!master1.hasErrors() && master1.save(flush:true)) {
 	       } else {
				master1.errors.each {
					println it
			    }
			}	
		}
	}else{
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

	def insertBMWDataIntoMaster(BioMedicalWaste bmwDetails){
		try{println("----params in--"+bmwDetails.id)
		def wasteMasterInstance=WasteMasterDataDetails.find("from WasteMasterDataDetails wm where wm.applicationId=?",[String.valueOf(bmwDetails.id)])
		println("---wasteMasterInstance---in -insertBMWDataIntoMaster---"+wasteMasterInstance)
		if(wasteMasterInstance==null){
		def bmwMaster= new BioMedicalWasteMaster()
		bmwMaster.industryRegMasterObj =bmwDetails.industryRegMasterObj
		bmwMaster.nameOfApplicant=bmwDetails.nameOfApplicant
			bmwMaster.nameOfInstitution=bmwDetails.nameOfInstitution
			bmwMaster.activityAuthorizationSoughtFor=bmwDetails.activityAuthorizationSoughtFor
			bmwMaster.authorizationType=bmwDetails.authorizationType
			bmwMaster.previousAuthNo=bmwDetails.previousAuthNo
			bmwMaster.previousAuthDate=bmwDetails.previousAuthDate
			bmwMaster.nameAddressInstitution=bmwDetails.nameAddressInstitution
			bmwMaster.addrTreatmentFacility=bmwDetails.addrTreatmentFacility
			bmwMaster.addrPlaceDisposalOfWaste=bmwDetails.addrPlaceDisposalOfWaste
			bmwMaster.completionStatus=bmwDetails.completionStatus
			bmwMaster.modeTrans=bmwDetails.modeTrans
			bmwMaster.modeTreat=bmwDetails.modeTreat
			bmwMaster.descrip=bmwDetails.descrip
			bmwMaster.dateCreated=bmwDetails.dateCreated
			bmwMaster.createdBy=bmwDetails.createdBy
			bmwMaster.lastUpdated=bmwDetails.lastUpdated
			bmwMaster.updatedBy=bmwDetails.updatedBy
			bmwMaster.applicationStatus=bmwDetails.applicationStatus
			bmwMaster.clarification=bmwDetails.clarification
			bmwMaster.inspection=bmwDetails.inspection
			bmwMaster.condImposedRenew=bmwDetails.condImposedRenew
			bmwMaster.categHAW=bmwDetails.categHAW
			bmwMaster.categAW=bmwDetails.categAW
			bmwMaster.categMBW=bmwDetails.categMBW
			bmwMaster.categWS=bmwDetails.categWS
			bmwMaster.categDMCD=bmwDetails.categDMCD
			bmwMaster.categSW6=bmwDetails.categSW6
			bmwMaster.categSW7=bmwDetails.categSW7
			bmwMaster.categLW=bmwDetails.categLW
			bmwMaster.categIA=bmwDetails.categIA
			bmwMaster.categCW=bmwDetails.categCW
		bmwMaster.categHAWUnit=bmwDetails.categHAWUnit
		bmwMaster.categAWUnit=bmwDetails.categAWUnit
		bmwMaster.categMBWUnit=bmwDetails.categMBWUnit
		bmwMaster.categWSUnit=bmwDetails.categWSUnit
		bmwMaster.categDMCDUnit=bmwDetails.categDMCDUnit
		bmwMaster.categSW6Unit=bmwDetails.categSW6Unit
		bmwMaster.categSW7Unit=bmwDetails.categSW7Unit
		bmwMaster.categLWUnit=bmwDetails.categLWUnit
		bmwMaster.categIAUnit=bmwDetails.categIAUnit
		bmwMaster.categCWUnit=bmwDetails.categCWUnit
		bmwMaster.prevExpDate=bmwDetails.prevExpDate
		bmwMaster.authorisationAppliedFor=bmwDetails.authorisationAppliedFor
		bmwMaster.hcfType=bmwDetails.hcfType
		bmwMaster.bmwfacility=bmwDetails.bmwfacility
		bmwMaster.bmwstatus=bmwDetails.bmwstatus
		bmwMaster.wastelocationaddress=bmwDetails.wastelocationaddress
		bmwMaster.wastedisposalplace=bmwDetails.wastedisposalplace
		bmwMaster.outpatientsFacility= bmwDetails.outpatientsFacility
		bmwMaster.inpatientsFacility=bmwDetails.inpatientsFacility
		bmwMaster.noofbeds=bmwDetails.noofbeds
		bmwMaster.other1=bmwDetails.other1
		bmwMaster.other2=bmwDetails.other2
		bmwMaster.patientspermonth=bmwDetails.patientspermonth
		bmwMaster.destroyer=bmwDetails.destroyer
		bmwMaster.bmwrules1=bmwDetails.bmwrules1
		bmwMaster.NoofHCF=bmwDetails.NoofHCF
		bmwMaster.Jurisdictionalarea=bmwDetails.Jurisdictionalarea
		bmwMaster.authorisationDay=bmwDetails.authorisationDay
		bmwMaster.authorisationMonth=bmwDetails.authorisationMonth
		bmwMaster.detailapc=bmwDetails.detailapc
		bmwMaster.detailetp=bmwDetails.detailetp
		 bmwMaster.quantityperDay=bmwDetails.quantityperDay
		 bmwMaster.quantityperMonth=bmwDetails.quantityperMonth
		 bmwMaster.quantityperDay1=bmwDetails.quantityperDay1
		 bmwMaster.quantityperMonth1=bmwDetails.quantityperMonth1
		 bmwMaster.authapply=bmwDetails.authapply
		 bmwMaster.hcfTypeMenu=bmwDetails.hcfTypeMenu
		 bmwMaster.anatomicalwaste=bmwDetails.anatomicalwaste
		 bmwMaster.animalwaste=bmwDetails.animalwaste
	     bmwMaster.biowaste=bmwDetails.biowaste
	     bmwMaster.wastesharp=bmwDetails.wastesharp
	     bmwMaster.discardedwaste=bmwDetails.discardedwaste
	     bmwMaster.soiledwaste=bmwDetails.soiledwaste
	     bmwMaster.solidwaste=bmwDetails.solidwaste
	     bmwMaster.liquidwaste=bmwDetails.liquidwaste
	     bmwMaster.ash=bmwDetails.ash
	     bmwMaster.chemicalwaste=bmwDetails.chemicalwaste
	     bmwMaster.total1=bmwDetails.total1
	     bmwMaster.paymentDeviation=bmwDetails.paymentDeviation
		 bmwMaster.remittedFees=bmwDetails.remittedFees
		 bmwMaster.statusCteCto=bmwDetails.statusCteCto
		 bmwMaster.latitude=bmwDetails.latitude
		 bmwMaster.longtitude=bmwDetails.longtitude
		 bmwMaster.detailsOfDirections=bmwDetails.detailsOfDirections
		 bmwMaster.noOfNonBeds=bmwDetails.noOfNonBeds
		 bmwMaster.noOfNonBeds1=bmwDetails.noOfNonBeds1
		 bmwMaster.noOfInOutPatients=bmwDetails.noOfInOutPatients
		 bmwMaster.colorCodedBags=bmwDetails.colorCodedBags
		 bmwMaster.noOfBedsCbmwtf=bmwDetails.noOfBedsCbmwtf
		 bmwMaster.treatmentAndDisposal=bmwDetails.treatmentAndDisposal
		bmwMaster.qtyOfBmwTreated=bmwDetails.qtyOfBmwTreated
		bmwMaster.contingencyPlan=bmwDetails.contingencyPlan
		bmwMaster.detailsOfTraining=bmwDetails.detailsOfTraining
		bmwMaster.incinrators=bmwDetails.incinrators
		bmwMaster.incinratorsType=bmwDetails.incinratorsType
		bmwMaster.plasmaPyrolysis=bmwDetails.plasmaPyrolysis
		bmwMaster.plasmaPyrolysisType=bmwDetails.plasmaPyrolysisType
		bmwMaster.autoclaves=bmwDetails.autoclaves
		bmwMaster.autoclavesType=bmwDetails.autoclavesType
		bmwMaster.microwave=bmwDetails.microwave
		bmwMaster.microwaveType=bmwDetails.microwaveType
		bmwMaster.hydroclave=bmwDetails.hydroclave
		bmwMaster.hydroclaveType=bmwDetails.hydroclaveType
		bmwMaster.shredders=bmwDetails.shredders
		bmwMaster.shreddersType=bmwDetails.shreddersType
		bmwMaster.needleTipCutter=bmwDetails.needleTipCutter
		bmwMaster.needleTipCutterType=bmwDetails.needleTipCutterType
		bmwMaster.sharpEncapsulation=bmwDetails.sharpEncapsulation
		bmwMaster.sharpEncapsulationType=bmwDetails.sharpEncapsulationType
		bmwMaster.deepBurial=bmwDetails.deepBurial
		bmwMaster.deepBurialType=bmwDetails.deepBurialType
		bmwMaster.chemDisinfection=bmwDetails.chemDisinfection
		bmwMaster.chemDisinfectionType=bmwDetails.chemDisinfectionType
		bmwMaster.anyOtherTretmntEquip=bmwDetails.anyOtherTretmntEquip
		bmwMaster.anyOtherTretmntEquipType=bmwDetails.anyOtherTretmntEquipType
		bmwMaster.chemicalSolidWaste=bmwDetails.chemicalSolidWaste
		bmwMaster.chemicalLiquidWaste=bmwDetails.chemicalLiquidWaste
		bmwMaster.discardedLinen=bmwDetails.discardedLinen
		bmwMaster.otherClininLabWaste=bmwDetails.otherClininLabWaste
		bmwMaster.contaminatedwaste=bmwDetails.contaminatedwaste
		bmwMaster.wasteSharps=bmwDetails.wasteSharps
		bmwMaster.glassWare=bmwDetails.glassWare
		bmwMaster.metallicBodyImplants=bmwDetails.metallicBodyImplants
		boolean isNewApplication=bmwDetails.isNewApplication	
		bmwMaster.save()
		println("---bmwMaster---"+bmwMaster)
		def wasteMasterDetailsInst=new WasteMasterDataDetails() 
		wasteMasterDetailsInst.applicationId=String.valueOf(bmwDetails.id)
		wasteMasterDetailsInst.applicationFor="BMW"
		wasteMasterDetailsInst.masterApplicationId=bmwMaster.id
		wasteMasterDetailsInst.indRegInstance=bmwMaster.industryRegMasterObj
		wasteMasterDetailsInst.dateCreated= new Date()
		wasteMasterDetailsInst.save(flush:true)
		}}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
//	air Emmsion
	def popAirStackAddMaster = {
			 try {
					def app
			    	if(params.id){
			    		 app = IndApplicationDetails.get((params.id).toInteger())
			    	}else{
			    		app = IndApplicationDetails.get((params.app).toInteger())
			    	}
			    	 def count1
			         def count2 
			        def airInstanceList = AirStackDetailsMaster.findAllWhere(application:app)
			        	if(airInstanceList){
			        	count1 = airInstanceList.size()
			          }
			    	else{
			    		count1 = '0'
			    	}
			    	 	app.noOfStack = count1
			    	def stackList = AirStackDetailsMaster.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<stackList.size();i++){
			    		def pollCntrlList = AirStackPollutionCntrlDetailsMaster.findAllWhere(stack:stackList.get(i))
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	return [appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,count1:count1,app:app]
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

	def popAirStackViewMaster = {
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
			    	def stackList = AirStackDetailsMaster.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<stackList.size();i++){
			    		def pollCntrlList = AirStackPollutionCntrlDetailsMaster.findAllWhere(stack:stackList.get(i))
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	return [appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,app:app]
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
	
	def popAirStackEditMaster = {
			 try {
					def app = IndApplicationDetails.get((params.id).toInteger())
			    	def stackList = AirStackDetailsMaster.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<stackList.size();i++){
			    		def pollCntrlList = AirStackPollutionCntrlDetailsMaster.findAllWhere(stack:stackList.get(i))
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	return [appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,app:app]
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

	def saveAirStackDetailsMaster = {
			 try {
					def count1
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.capacity).getClass().getName()== "java.lang.String"){
			    		def unit = UnitMaster.get((params.capacityUnit).toInteger())
			    		def airStackInst = new AirStackDetailsMaster()
			    		airStackInst.application = app
			    		airStackInst.capacity = params.capacity
			    		airStackInst.heightGrdLevel = params.heightGrdLevel
			    		airStackInst.heightFacLevel = params.heightFacLevel
			    		airStackInst.matOfCon = params.matOfCon
			    		airStackInst.draftType = params.draftType
			    		airStackInst.stack = params.stack
			    		airStackInst.unit = unit
			    		airStackInst.fuelTyp=params.fuelTyp
			    		airStackInst.fuelQty=params.fuelQty
			    		airStackInst.gasQty=params.gasQty
			    		airStackInst.shape=params.shape
			    		airStackInst.diamSize=params.diamSize
			    		airStackInst.gasTemp=params.gasTemp
			    		airStackInst.gasVel=params.gasVel
			    		if(airStackInst.save()){
			    			if((params.pollCntrlMeasure).getClass().getName()== "java.lang.String"){
			    	    		def airStackPollCntrlDetailsInst = new AirStackPollutionCntrlDetailsMaster()
			    	    		airStackPollCntrlDetailsInst.stack = airStackInst
			    	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.pollCntrlMeasure).toInteger())
			    	    		airStackPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
			    	    		airStackPollCntrlDetailsInst.save()
			        		}else{
			        			for(int i=0;i<params.pollCntrlMeasure.size();i++){
			        				def airStackPollCntrlDetailsInst = new AirStackPollutionCntrlDetailsMaster()
			        	    		airStackPollCntrlDetailsInst.stack = airStackInst
			        	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.pollCntrlMeasure[i]).toInteger())
			        	    		airStackPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
			        	    		airStackPollCntrlDetailsInst.save()
			        			}
			        		}
			    		}else{
			    			airStackInst.errors.allErrors.each {
			    			       
			    			    }
			    		}
				   }else{
			    		for(int i=0;i<params.capacity.size();i++){
			    			
			    		}
			    	}
			    	flash.message = "Details Saved"
			        redirect(action:popAirStackAddMaster,id:app,params:[count1:count1])
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

	def deleteAirStackDetailsMaster = {
			 try {
				 def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def airStackDetInst = AirStackDetailsMaster.get((params.delete).toInteger())
			    		def airStackPollCntrlInstList = AirStackPollutionCntrlDetailsMaster.findAllByStack(airStackDetInst)
			    		for(int j=0;j<airStackPollCntrlInstList.size();j++){
			    			(airStackPollCntrlInstList.get(j)).delete()
			    		}
			    		airStackDetInst.delete()
			    	}else{
			    		if(params.delete)
			    		for(int i=0;i<(params.delete).size();i++){
			    			def airStackDetInst = AirStackDetailsMaster.get((params.delete[i]).toInteger())
			    			def airStackPollCntrlInstList = AirStackPollutionCntrlDetailsMaster.findAllByStack(airStackDetInst)
			    			for(int j=0;j<airStackPollCntrlInstList.size();j++){
			        			(airStackPollCntrlInstList.get(j)).delete()
			        		}
			        		airStackDetInst.delete()
			    		}
			    	}
			    	def page=params.page
			    	redirect(action:popAirStackEditMaster,id:app,params:[page:page])
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
	
	def popAirFlueEmmisionAddMaster = {
			 try {
				 def app = IndApplicationDetails.get((params.id).toInteger())
			    	def airStackInstList = AirStackDetailsMaster.findAllByApplication(app)
			    	def flueList = AirFlueGasDetailsMaster.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<flueList.size();i++){
			    		def pollCntrlList = AirFlueGasPollutionCntrlDetailsMaster.findAllWhere(stack:(flueList.get(i)).stack)
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	return [appDetId:params.id,stackList:airStackInstList,flueList:flueList,pollCntrlBList:pollCntrlBList]
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

	def popAirFlueEmmisionViewMaster = {
			 try {
				 def app = IndApplicationDetails.get((params.id).toInteger())
			    	def flueList = AirFlueGasDetailsMaster.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<flueList.size();i++){
			    		def pollCntrlList = AirFlueGasPollutionCntrlDetailsMaster.findAllWhere(stack:(flueList.get(i)).stack)
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	return [appDetId:params.id,flueList:flueList,pollCntrlBList:pollCntrlBList]
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
	
def popAirFlueEmmisionEditMaster = {
			 try {
				 def app = IndApplicationDetails.get((params.id).toInteger())
			    	def flueList = AirFlueGasDetailsMaster.findAllByApplication(app)
			    	def pollCntrlBList = new ArrayList()
			    	for(int i=0;i<flueList.size();i++){
			    		def pollCntrlList = AirFlueGasPollutionCntrlDetailsMaster.findAllWhere(stack:(flueList.get(i)).stack)
			    		pollCntrlBList.add(pollCntrlList)
			    	}
			    	return [appDetId:params.id,flueList:flueList,pollCntrlBList:pollCntrlBList]
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
	
	def saveAirFlueEmmisionMaster = {
			 try {
				 def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.stack).getClass().getName()== "java.lang.String"){
			    		def airFlueGasDetailsInst = new AirFlueGasDetailsMaster()
			    		def unit = UnitMaster.get((params.unit).toInteger())
			    		def airStack = AirStackDetailsMaster.get((params.stack).toInteger())
			    		airFlueGasDetailsInst.application = app
			    		airFlueGasDetailsInst.consumption = params.consumption
			    		airFlueGasDetailsInst.fuel = params.fuel
			    		airFlueGasDetailsInst.stack = airStack
			    		airFlueGasDetailsInst.unit = unit
			    		airFlueGasDetailsInst.calorValue = params.calorValue
						airFlueGasDetailsInst.ashCon = params.ashCon
						airFlueGasDetailsInst.sulphurCon = params.sulphurCon
						airFlueGasDetailsInst.otherCon = params.otherCon
			    		airFlueGasDetailsInst.save()
				    	if((params.airFlueGasCntrlMeasure).getClass().getName()== "java.lang.String"){
				    		def airFlueGasPollCntrlDetailsInst = new AirFlueGasPollutionCntrlDetailsMaster()
				    		airFlueGasPollCntrlDetailsInst.stack = airFlueGasDetailsInst.stack
				    		def b = params.airFlueGasCntrlMeasure
				    		def cntrlMeasure = AirEmiControlMeasureMaster.findWhere(controlMeasure:b)
				    		airFlueGasPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
				    		airFlueGasPollCntrlDetailsInst.save()
			    		}else{
			    			for(int i=0;i<params.airFlueGasCntrlMeasure.size();i++){
			    				def airFlueGasPollCntrlDetailsInst = new AirFlueGasPollutionCntrlDetailsMaster()
			    	    		airFlueGasPollCntrlDetailsInst.stack = airFlueGasDetailsInst.stack
			    	    		def b=params.airFlueGasCntrlMeasure
			    	    		def a = b[i]
			    	    		def cntrlMeasure = AirEmiControlMeasureMaster.findWhere(controlMeasure:a)
			    	    		airFlueGasPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
			    	    		airFlueGasPollCntrlDetailsInst.save()
			    			}
			    		}
			    	}else{
			    		for(int i=0;i<params.stack.size();i++){
			    		}
			    	}
			    	flash.message = "Details Saved"
			            redirect(action:popAirFlueEmmisionAddMaster,id:app)
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

def deleteAirFlueEmmisionMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def airFlueGasDetInst = AirFlueGasDetailsMaster.get((params.delete).toInteger())
			    		def airFluePollCntrlInstList = AirFlueGasPollutionCntrlDetailsMaster.findAllByStack(airFlueGasDetInst.stack)
			    		for(int j=0;j<airFluePollCntrlInstList.size();j++){
			    			(airFluePollCntrlInstList.get(j)).delete()
			    		}
			    		airFlueGasDetInst.delete()
			    	}else{
			    		if(params.delete)
			    		for(int i=0;i<(params.delete).size();i++){
			    			def airFlueGasDetInst = AirFlueGasDetailsMaster.get((params.delete[i]).toInteger())
			        		def airFluePollCntrlInstList = AirFlueGasPollutionCntrlDetailsMaster.findAllByStack(airFlueGasDetInst.stack)
			        		for(int j=0;j<airFluePollCntrlInstList.size();j++){
			        			(airFluePollCntrlInstList.get(j)).delete()
			        		}
			        		airFlueGasDetInst.delete()
			    		}
			    	}
			    	redirect(action:popAirFlueEmmisionEditMaster,id:app)
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
	
	def popAirMiscDetailAddMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def miscList = AirMiscDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,miscList:miscList]
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

	def popAirMiscDetailViewMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
			    	def miscList = AirMiscDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,miscList:miscList]//,pollCntrlBList:pollCntrlBList]
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
	
	def popAirMiscDetailEditMaster = {
			 try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
			    	def miscList = AirMiscDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,miscList:miscList]//,pollCntrlBList:pollCntrlBList]
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
	
	def saveAirMiscDetailMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.odorCompounds).getClass().getName()== "java.lang.String")
			    	{
			    		def airMiscDetailsInst = new AirMiscDetailsMaster()
			    		airMiscDetailsInst.application = app
			    		airMiscDetailsInst.facility = params.facility
			    		airMiscDetailsInst.quality = params.quality
			    		airMiscDetailsInst.odorCompounds = params.odorCompounds
			    		airMiscDetailsInst.save()
				    }
			    	flash.message = "Details Saved"
			            redirect(action:popAirMiscDetailAddMaster,id:app)
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

	def deleteAirMiscDetailMaster = {
			 try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def airMiscDetInst = AirMiscDetailsMaster.get((params.delete).toInteger())
			    		airMiscDetInst.delete()
			    	}
			    	else
			    	{
			    		if(params.delete)
			    			for(int i=0;i<(params.delete).size();i++)
			    			{
			    			def airMiscDetInst = AirMiscDetailsMaster.get((params.delete[i]).toInteger())
			        		airMiscDetInst.delete()
			    			}
			    	}
			    	redirect(action:popAirMiscDetailEditMaster,id:app)
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

 def popWaterAddUsesMaster = { }
    
 def popWaterSourceAddMaster = {
			 try {
				   return [appDetId:params.id]
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

	def popWaterSourceViewMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
			    	def sourceList = WaterSourceDetailsMaster.findAllByApplication(app)
			    	def usesBList = new ArrayList()
			    	def modeUseBlist = new ArrayList()
			    	for(int i=0;i<sourceList.size();i++){
			    		def usesList = WaterUsesDetailsMaster.findAllWhere(source:(sourceList.get(i)).source,application:app)
			    		usesBList.add(usesList)
			    		def modeUseList = WaterModeUseDetailsMaster.findAllWhere(source:(sourceList.get(i)).source,application:app)
			    		modeUseBlist.add(modeUseList)
			    	}
			    	return [appDetId:params.id,sourceList:sourceList, usesBList:usesBList,modeUseBlist:modeUseBlist]
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
	
	def popWaterSourceEditMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
			    	def sourceList = WaterSourceDetailsMaster.findAllByApplication(app)
			    	def usesBList = new ArrayList()
			    	def modeUseBlist = new ArrayList()
			    	for(int i=0;i<sourceList.size();i++){
			    		def usesList = WaterUsesDetailsMaster.findAllWhere(source:(sourceList.get(i)).source,application:app)
			    		usesBList.add(usesList)
			    		def modeUseList = WaterModeUseDetailsMaster.findAllWhere(source:(sourceList.get(i)).source,application:app)
			    		modeUseBlist.add(modeUseList)
			    	}
			    	return [appDetId:params.id,sourceList:sourceList, usesBList:usesBList,modeUseBlist:modeUseBlist]
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

	def saveWaterSourceMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.indAppId).toInteger())
			    	def waterSourceInstance = new WaterSourceDetailsMaster()
			    	def source = WaterSourceMaster.get((params.waterSource).toInteger())
			    	def sourceName = params.sourceName
			    	waterSourceInstance.application = app
			    	waterSourceInstance.source = source
			    	waterSourceInstance.sourceName = sourceName
			    	def quant = null
			    	try{
			    		quant = (params.sourceQuantity).toFloat()
			    	}catch (NumberFormatException e) {
			    		quant = 0
			    	}
			    	waterSourceInstance.quantity = quant
			    	if(waterSourceInstance.save(flush:true)){
						
					}else{
						waterSourceInstance.errors.each {
					       
					   }
					}
			    	render(view:'popWaterAddUsesMaster',model:[waterSourceInstance:waterSourceInstance,app:params.indAppId])
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

	def saveWaterSourceUses = {
			 try {
				  def sourceDetIns = WaterSourceDetailsMaster.get((params.source).toInteger())
			    	if((params.waterSourceUses).getClass().getName()== "java.lang.String"){
			    		def waterUsesDetails = new WaterUsesDetailsMaster()
			    		waterUsesDetails.source = sourceDetIns.source
			    		waterUsesDetails.sourceName = params.sourceName
			    		waterUsesDetails.use = WaterUsesMaster.get((params.waterSourceUses).toInteger())
			    		def quant = null
			        	try{
			        		quant = (params.sourceUseQuantity).toFloat()
			        	}catch (NumberFormatException e) {
			        		quant = 0
			        	}
			    		waterUsesDetails.quantity = quant
			    		waterUsesDetails.application = IndApplicationDetails.get((params.app).toInteger())
			    		waterUsesDetails.save()
			    		render(view:'popWaterAddModeUseMaster',model:[waterSourceInstance:sourceDetIns,app:params.app])
			    	}else{
			    		for(int i=0;i<params.waterSourceUses.size();i++){
			    			def waterUsesDetails = new WaterUsesDetailsMaster()
			    			waterUsesDetails.source = sourceDetIns.source
			    			waterUsesDetails.sourceName = params.sourceName
			        		waterUsesDetails.use = WaterUsesMaster.get((params.waterSourceUses[i]).toInteger())
			        		def quant = null
				        	try{
				        		quant = (params.sourceUseQuantity[i]).toFloat()
				        	}catch (NumberFormatException e) {
				        		quant = 0
				        	}
			        		waterUsesDetails.quantity = quant
			        		waterUsesDetails.application = IndApplicationDetails.get((params.app).toInteger())
			        		waterUsesDetails.save()
			        		}
			    	}
			    	render(view:'popWaterAddModeUseMaster',model:[waterSourceInstance:sourceDetIns,app:params.app])
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

	def saveWaterSourceModeUse = {
			 try {
				   def sourceDetIns = WaterSourceDetailsMaster.get((params.source).toInteger())
			    	if((params.waterModeUse).getClass().getName()== "java.lang.String"){
			    		def waterModeUseDetailsInst = new WaterModeUseDetailsMaster()
			    		waterModeUseDetailsInst.source = sourceDetIns.source
			    		waterModeUseDetailsInst.modeUse = WaterModeUseMaster.get((params.waterModeUse).toInteger())
			    		def quant = null
				        	try{
				        		quant = (params.modeUseQuantity).toFloat()
				        	}catch (NumberFormatException e) {
				        		quant = 0
				        	}
			    		waterModeUseDetailsInst.quantity = quant
			    		def quant2 = null
			        	try{
			        		quant2 = (params.modeUseWasteGeneration).toFloat()
			        	}catch (NumberFormatException e) {
			        		quant2 = 0
			        	}
			    		waterModeUseDetailsInst.wasteWaterGenerated = quant2
			    		waterModeUseDetailsInst.application = IndApplicationDetails.get((params.app).toInteger())
			    		waterModeUseDetailsInst.save()
			    	}else{
			    		for(int i=0;i<params.waterModeUse.size();i++){
			    			def waterModeUseDetailsInst = new WaterModeUseDetailsMaster()
			        		waterModeUseDetailsInst.source = sourceDetIns.source
			    			waterModeUseDetailsInst.modeUse = WaterModeUseMaster.get((params.waterModeUse[i]).toInteger())
			    			def quant = null
				        	try{
				        		quant = (params.modeUseQuantity[i]).toInteger()
				        	}catch (NumberFormatException e) {
				        		quant = 0
				        	}
				    		waterModeUseDetailsInst.quantity = quant
				    		def quant2 = null
				        	try{
				        		quant2 = (params.modeUseWasteGeneration[i]).toInteger()
				        	}catch (NumberFormatException e) {
				        		quant2 = 0
				        	}
			        		waterModeUseDetailsInst.wasteWaterGenerated = quant2
			        		waterModeUseDetailsInst.application = IndApplicationDetails.get((params.app).toInteger())
			        		waterModeUseDetailsInst.save()
			    		}
			    	}
			    	flash.message = "Details Saved"
			    	render(view:'popCloseMaster',model:[app:params.app])
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
	
	def deleteWaterSourceMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.source).getClass().getName()== "java.lang.String"){
			    		def waterSourceDetIns = WaterSourceDetailsMaster.get((params.source).toInteger())
			    		def waterUsesDetList = WaterUsesDetailsMaster.findAllWhere(source:waterSourceDetIns.source,application:app)
			    		def waterModeUseDetList = WaterModeUseDetailsMaster.findAllWhere(source:waterSourceDetIns.source,application:app)
			    		for(int i=0;i<waterUsesDetList.size();i++){
			    			(waterUsesDetList.get(i)).delete()
			    		}
			    		for(int i=0;i<waterModeUseDetList.size();i++){
			    			(waterModeUseDetList.get(i)).delete()
			    		}
			    		waterSourceDetIns.delete()
			    	}
			    	else{
			    		if(params.source)
			        		for(int j=0;j<(params.source).size();j++){
			        			def waterSourceDetIns = WaterSourceDetailsMaster.get((params.source[j]).toInteger())
			    	    		def waterUsesDetList = WaterUsesDetailsMaster.findAllWhere(source:waterSourceDetIns.source,application:app)
			    	    		def waterModeUseDetList = WaterModeUseDetailsMaster.findAllWhere(source:waterSourceDetIns.source,application:app)
			    	    		for(int i=0;i<waterUsesDetList.size();i++){
			    	    			(waterUsesDetList.get(i)).delete()
			    	    		}
			    	    		for(int i=0;i<waterModeUseDetList.size();i++){
			    	    			(waterModeUseDetList.get(i)).delete()
			    	    		}
			    	    		waterSourceDetIns.delete()	
			        		}
			    	}
			    	redirect(action:popWaterSourceEditMaster,id:app)
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

def popWaterTreatmentAddMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def waterWasteTreatmentDetList = WasteWaterTreatmentDetailsMaster.findAll("From WasteWaterTreatmentDetailsMaster w where w.application = ? ",[app])
			    	return [appDetId:params.id,waterWasteTreatmentDetList:waterWasteTreatmentDetList]
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

	def popWaterTreatmentViewMaster = {
			 try {
			    def app = IndApplicationDetails.get((params.id).toInteger())
			    	def waterWasteTreatmentDetList = WasteWaterTreatmentDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,waterWasteTreatmentDetList:waterWasteTreatmentDetList]
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
	
	def popWaterTreatmentEditMaster = {
			 try {
			    def app = IndApplicationDetails.get((params.id).toInteger())
			    	def waterWasteTreatmentDetList = WasteWaterTreatmentDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,waterWasteTreatmentDetList:waterWasteTreatmentDetList]
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

	def saveWaterTreatmentMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.waterWasteTeatCat).getClass().getName()== "java.lang.String"){
			    		def waterWasteTreatInst = new WasteWaterTreatmentDetailsMaster()
			    		def category  = WaterWasteTreatmentCategoryMaster.get((params.waterWasteTeatCat).toInteger())
			    		def treatmentStatus  = WaterTreatmentStatusMaster.get((params.treatmentStatus).toInteger())
			    		def treatmentEffluent  = WaterTreatedEffluentQualityMaster.get((params.treatmentEffluent).toInteger())
			    		waterWasteTreatInst.application = app
			    		waterWasteTreatInst.uses = params.uses
			    		waterWasteTreatInst.category = category
			    		waterWasteTreatInst.treatmentUnits = params.treatUnits
			    		waterWasteTreatInst.capacity = params.capacity
			    		waterWasteTreatInst.investmentInTreatmentUnit = params.investmentInTreatmentUnit    		
			    		waterWasteTreatInst.effluentGeneration = params.effluentGen.toFloat()
			    		waterWasteTreatInst.treatmentArrangementStatus = treatmentStatus
			    		waterWasteTreatInst.monitoringArrangementDetails = params.monitoringDetails
			    		waterWasteTreatInst.treatedEffluentQuality = treatmentEffluent
			    		waterWasteTreatInst.parametersQuantity = params.parametersQuantity
			    		waterWasteTreatInst.parametersQuantityTreated = params.parametersQuantityTreated
			    		waterWasteTreatInst.save()
			    	}else{
			    		for(int i=0;i<params.waterWasteTeatCat.size();i++){
			    			def waterWasteTreatInst = new WasteWaterTreatmentDetailsMaster()
			        		def category  = WaterWasteTreatmentCategoryMaster.get((params.waterWasteTeatCat[i]).toInteger())
			        		def treatmentStatus  = WaterTreatmentStatusMaster.get((params.treatmentStatus[i]).toInteger())
			        		def treatmentEffluent  = WaterTreatedEffluentQualityMaster.get((params.treatmentEffluent[i]).toInteger())
			    		 	waterWasteTreatInst.application = app
			        		waterWasteTreatInst.category = category
			        		waterWasteTreatInst.uses = params.uses[i]
			        		waterWasteTreatInst.treatmentUnits = params.treatUnits[i]
			        		waterWasteTreatInst.capacity = params.capacity[i]
			    			waterWasteTreatInst.investmentInTreatmentUnit = params.investmentInTreatmentUnit[i]
			    			waterWasteTreatInst.effluentGeneration = params.effluentGen[i].toFloat()
			        		waterWasteTreatInst.treatmentArrangementStatus = treatmentStatus[i]
			        		waterWasteTreatInst.monitoringArrangementDetails = params.monitoringDetails[i]
			        		waterWasteTreatInst.treatedEffluentQuality = treatmentEffluent[i]
			    			waterWasteTreatInst.parametersQuantity = params.parametersQuantity[i]
			    			waterWasteTreatInst.parametersQuantityTreated = params.parametersQuantityTreated[i]
			        		waterWasteTreatInst.save()
			    		}
			    	}
			    		flash.message = "Details Saved"
			    		redirect(action:popWaterTreatmentAddMaster,id:app)
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

	def deleteWaterTreatmentMaster = {
			 try {
			    	def wasteWaterTreatDetInst
			    	def app
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		
			    		wasteWaterTreatDetInst = WasteWaterTreatmentDetailsMaster.get((params.delete).toInteger())
			    		app = wasteWaterTreatDetInst.application
			    		wasteWaterTreatDetInst.delete()
			    	}else{
			    		if(params.delete)
			    		for(int i=0;i<(params.delete).size();i++){
			    			 wasteWaterTreatDetInst = WasteWaterTreatmentDetailsMaster.get((params.delete[i]).toInteger())
			        		app = wasteWaterTreatDetInst.application
			    			 wasteWaterTreatDetInst.delete()
			    		}
			    	}
			    	redirect(action:popWaterTreatmentEditMaster,id:app)
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

	def popwastegenAddMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def wasteWaterGenDetInstList = WaterWasteGenerationDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,wasteWaterGenDetInstList:wasteWaterGenDetInstList]
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
	
	def popwastegenViewMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def wasteWaterGenDetInstList = WaterWasteGenerationDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,wasteWaterGenDetInstList:wasteWaterGenDetInstList]
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
	
	def popwastegenEditMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def wasteWaterGenDetInstList = WaterWasteGenerationDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,wasteWaterGenDetInstList:wasteWaterGenDetInstList]
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
	
	def saveWastegenMaster = {
			 try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def list = new ArrayList()
			    	if((params.waterDisposalMode).getClass().getName()== "java.lang.String"){
			    		def waterWasteGenerationInst = new WaterWasteGenerationDetailsMaster()
			    		waterWasteGenerationInst.application = app
			    		waterWasteGenerationInst.disposalMode = params.waterDisposalMode
			    		waterWasteGenerationInst.typeOfEffluent = params.typeOfEffluent
			    		def quant = null
			        	try{
			        		quant = (params.effDischarge).toFloat()
			        	}catch (NumberFormatException e) {
			        		quant = 0
			        	}
			    		waterWasteGenerationInst.effDischarge = quant
			    		def quant2 = null
			        	try{
			        		quant2 = (params.effRecycle).toFloat()
			        	}catch (NumberFormatException e) {
			        		quant2 = 0
			        	}
			    		waterWasteGenerationInst.effRecycle = quant2
			    		def quant3 = null
			        	try{
			        		quant3 = (params.maxGeneration).toFloat()
			        	}catch (NumberFormatException e) {
			        		quant3 = 0
			        	}
			    		waterWasteGenerationInst.maxGeneration = quant3
			    		waterWasteGenerationInst.save()
			    		list.add(waterWasteGenerationInst)
			    	}else{
			    		for(int i=0;i<params.waterDisposalMode.size();i++){
			    			def waterWasteGenerationInst = new WaterWasteGenerationDetailsMaster()
			        		waterWasteGenerationInst.application = app
			        		waterWasteGenerationInst.disposalMode = params.waterDisposalMode
			        		waterWasteGenerationInst.typeOfEffluent = params.typeOfEffluent
			        		def quant = null
			            	try{
			            		quant = (params.effDischarge).toFloat()
			            	}catch (NumberFormatException e) {
			            		quant = 0
			            	}
			        		waterWasteGenerationInst.effDischarge = quant
			        		def quant2 = null
			            	try{
			            		quant2 = (params.effRecycle).toFloat()
			            	}catch (NumberFormatException e) {
			            		quant2 = 0
			            	}
			        		waterWasteGenerationInst.effRecycle = quant2
			        		def quant3 = null
			            	try{
			            		quant3 = (params.maxGeneration).toFloat()
			            	}catch (NumberFormatException e) {
			            		quant3 = 0
			            	}
			        		waterWasteGenerationInst.maxGeneration = quant3
			        		waterWasteGenerationInst.save()
			        		list.add(waterWasteGenerationInst)
			        	}
			    	}
			    	 def waterWasteGenerationInstance = WaterWasteGenerationDetailsMaster.findAllWhere(application:app)
			    	 def a = waterWasteGenerationInstance.effDischarge
			    		def d = 0
			    		for (int j=0;j<waterWasteGenerationInstance.size();j++){
			    			d = d+ (a[j]).toInteger()
			    		}
			    	    def i =0
			    	    def p = list.effDischarge[i]
			    		def b = (p).toInteger()
			    		d= d+b
			    		flash.message = "Details Saved"
			       redirect(action:popwastegenAddMaster,id:app)
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

	def deleteWastegenMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def wasteWaterGenInst = WaterWasteGenerationDetailsMaster.get((params.delete).toInteger())
			    		wasteWaterGenInst.delete()
			    	}else{
			    		if(params.delete)
			    		for(int i=0;i<(params.delete).size();i++){
			    			def wasteWaterGenInst = WaterWasteGenerationDetailsMaster.get((params.delete[i]).toInteger())
			        		wasteWaterGenInst.delete()
			    		}
			    	}
			    	redirect(action:popwastegenEditMaster,id:app)
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

	def popWaterSolidWasteAddMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def waterSolidWasteGenList = WaterSolidWasteGenDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,waterSolidWasteGenList:waterSolidWasteGenList]
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

	def popWaterSolidWasteViewMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def waterSolidWasteGenList = WaterSolidWasteGenDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,waterSolidWasteGenList:waterSolidWasteGenList]
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
	
	def popWaterSolidWasteEditMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def waterSolidWasteGenList = WaterSolidWasteGenDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,waterSolidWasteGenList:waterSolidWasteGenList]
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

	def saveWaterSolidWasteMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def waterSolidWasteGenDetailsInst = new WaterSolidWasteGenDetailsMaster()
		        	waterSolidWasteGenDetailsInst.description = params.description
		        	waterSolidWasteGenDetailsInst.quantQual = params.quantity
		        	waterSolidWasteGenDetailsInst.meathodCollection = params.methodCollection
		        	def waterDisp = WaterDisposalModeMaster.get((params.methodDisposal).toInteger())
		        	waterSolidWasteGenDetailsInst.meathodDisposal = waterDisp
		        	waterSolidWasteGenDetailsInst.application = app
		        	waterSolidWasteGenDetailsInst.save()
		        	redirect(action:popWaterSolidWasteAddMaster,id:app)
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

	def deleteWaterSolidWasteMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		
		        		def wastersolidDetails = WaterSolidWasteGenDetailsMaster.get((params.delete).toInteger())
		        		wastersolidDetails.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			
		        			def wastersolidDetails = WaterSolidWasteGenDetailsMaster.get((params.delete[i]).toInteger())
		            		wastersolidDetails.delete()
		        		}
		        	}
		        	redirect(action:popWaterSolidWasteEditMaster,id:app)
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

	def popProductDetailsAddMaster = {
			 try {
			    	def d = params.d
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def productDetailsList = IndProductDetailsMaster.findAll("from IndProductDetailsMaster s where s.application=? order by id asc",[app])
			    	def appFor=app.certificateFor
			    	def page=params.page
			    	return [appDetId:params.id,page:page,productDetailsList:productDetailsList,d:d,appFor:appFor]
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
	
	def popProductDetailsViewMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def productDetailsList = IndProductDetailsMaster.findAll("from IndProductDetailsMaster s where s.application=? order by id asc",[app])
			    	def page=params.page
			    	def appFor=app.certificateFor
			    	return [appDetId:params.id,page:page,productDetailsList:productDetailsList,appFor:appFor]
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
	
	def popProductDetailsEditMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def productDetailsList = IndProductDetailsMaster.findAll("from IndProductDetailsMaster s where s.application=? order by id asc",[app])
			    	def page=params.page
			    	def appFor=app.certificateFor
			    	return [appDetId:params.id,productDetailsList:productDetailsList,page:page,appFor:appFor]
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
	
	def saveProductDetailsMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def indProductDetailsInstanceList = new ArrayList()
			        def qty = 0
			    	params.unit
			    	params.rawMaterials
			    	String []product = params.product
			    	String []quantity = params.quantity
			    	String []byProduct = params.byProduct
			    	String []unit = params.unit
			    	String []rawMaterials = params.rawMaterials
			    	if((params.product).getClass().getName()== "java.lang.String"){
			    		if(params.product != ""){
			    			def indProductDetailsInstance = new IndProductDetailsMaster()
			        		indProductDetailsInstance.application = app
			        		indProductDetailsInstance.product = params.product
			        		indProductDetailsInstance.quantity = params.quantity
			        		indProductDetailsInstance.byProduct = params.byProduct
			        		indProductDetailsInstance.rawMaterials = params.rawMaterials
			        		indProductDetailsInstance.unit = UnitMaster.get((params.unit).toInteger())
			        		indProductDetailsInstance.unitbyProduct = UnitMaster.get((params.unitbyProduct).toInteger())
			        		def qty1 = (params.quantity).toFloat()
			        		qty = qty + qty1
			        		indProductDetailsInstance.save()
			        		indProductDetailsInstanceList.add(indProductDetailsInstance)
			        	}
			    	}else{
			    	for(int i=0;i<params.product.size();i++){
			    			if(product[i] != ""){
			        			def indProductDetailsInstance = new IndProductDetailsMaster()
			            		indProductDetailsInstance.application = indApplicationDetailsInstance
			            		indProductDetailsInstance.product = product[i] 
			            		indProductDetailsInstance.quantity = quantity[i]
			            		indProductDetailsInstance.byProduct = byProduct[i] 
			            		indProductDetailsInstance.rawMaterials = rawMaterials[i]
			            		indProductDetailsInstance.unit = UnitMaster.get((params.unit[i]).toInteger())
			            		indProductDetailsInstance.unitbyProduct = UnitMaster.get((params.unitbyProduct[i]).toInteger())
			            		indProductDetailsInstance.save()
			            		indProductDetailsInstanceList.add(indProductDetailsInstance)
			    			}
			    		}
			    	}
			    def indProdDetailsInstance = IndProductDetails.findAllWhere(application:app)
				def a = indProdDetailsInstance.quantity
				def d = 0
				for (int j=0;j<indProdDetailsInstance.size();j++){
				d = d+ (a[j]).toFloat()
				}
			    def i =0
			    def p = indProductDetailsInstanceList.quantity[i]
				def b = (p).toFloat()
				d= d+b
				app.annualProdCap = d
				redirect(action:popProductDetailsAddMaster,id:app,params:[d:d])
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
	
	def deleteProductDetailsMaster = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indProdDetInst = IndProductDetailsMaster.get((params.delete).toInteger())
			    		indProdDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indProdDetInst = IndProductDetailsMaster.get((params.delete[i]).toInteger())
			        		indProdDetInst.delete()
			        	}
			    	}
			    	redirect(action:popProductDetailsEditMaster,id:app)
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

def popFeeDetailsAdd = {
			 try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def feeDetailsList = FeeBankDetailsMaster.findAllByApplication(app)
			    	def feeCheque = FeeChequeRecordMaster.findByIndApplication(app)
			    	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
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
	
	 def popFeeDetailsView = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
			    	def feeDetailsList = FeeBankDetailsMaster.findAllByApplication(app)
			    	def feeCheque = FeeChequeRecordMaster.findByIndApplication(app)
			    	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
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
	    
def popFeeDetailsEdit = {
			 try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
			    	def feeDetailsList = FeeBankDetailsMaster.findAllByApplication(app)
			    	def feeCheque = FeeChequeRecordMaster.findByIndApplication(app)
			    	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque]
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
	
	 def saveBankFeeDetails = {
			 try {
				   def dateCheck = params.dateval_value
			    	def currentDate=new Date()
			    	DateCustom dd=new DateCustom()
			    	def sqlCurrentDate=dd.sQLdate(currentDate)
			    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					def x = sdfh.parse(dateCheck);
					def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if(x>sqlCurrentDate)
					{
						flash.message="DD/Cheque issue date can not be greater than current date"
						redirect(action:popFeeDetailsAdd,id:app.id)
					}
			    	else
			    	{
			    	if((params.ddNo).getClass().getName()== "java.lang.String"){
			        		if(params.ddNo!=""){
			        			def feeBankDetails = new FeeBankDetailsMaster()
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
			        			   }
			        			}
			        			}
			        	}else{
			        		for(int i=0;i<params.ddNo.size();i++){
			        			if(ddNo[i]!=""){
			        				def feeBankDetails = new FeeBankDetailsMaster()
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
			    	redirect(action:popFeeDetailsAdd,id:app.id)
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
	
	  def deleteFeeBankDetails = {
			 try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def feeDetInst = FeeBankDetailsMaster.get((params.delete).toInteger())
			    		feeDetInst.delete()
			    		if(params.delete1)
			    		{
			    		def feeCheque = FeeChequeRecordMaster.get((params.delete1).toInteger())
			    		if(feeCheque){
			    			feeCheque.delete()
			        		}
			    			flash.message="Please attach again the scan copy of Drafts/Cheques"
			    		}
			    	}else{
			    		if(params.delete){
			        	for(int i=0;i<(params.delete).size();i++){
			        		def feeDetInst = FeeBankDetailsMaster.get((params.delete[i]).toInteger())
			        		feeDetInst.delete()
			        	}
			        	if(params.delete1)
			    		{
			    		def feeCheque = FeeChequeRecordMaster.get((params.delete1).toInteger())
			    		if(feeCheque){
			    			feeCheque.delete()
			        		}
			        	flash.message("Please attach again the scan copy of above Drafts/Cheques")
			    		}
			    		}
			    	}
			    	redirect(action:popFeeDetailsEdit,id:app)
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
	
	  def saveChequeAttach = {
			  try {
			        def app = IndApplicationDetails.get((params.appId1).toInteger())
			   		def feeCheque = FeeChequeRecordMaster.findByIndApplication(app)
			   		if(feeCheque){
			       	feeCheque.delete()
			      	}
			   		def file1 = new FeeChequeRecordMaster()
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
			   		redirect(action:popFeeDetailsAdd,id:app)
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
	
	def viewChequeAttached={
			  try {
			       def applicationFileInstance
				    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
				    	 applicationFileInstance=FeeChequeRecordMaster.findAll("from FeeChequeRecordMaster afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[application],[max:1])
				    	def applicationFileSingleInstance=applicationFileInstance[0]
					   response.setContentType( "application-xdownload")
					   response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
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
		
	  def popDGsetAddMaster = 
		{
			  try {
			       def app = IndApplicationDetails.get((params.id).toInteger())
			    	def DGList = DGSetDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,DGList:DGList]
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
	    
	    def popDGsetEditMaster = 
	    {
			  try {
			        def app = IndApplicationDetails.get((params.id).toInteger())
			    	def DGList = DGSetDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,DGList:DGList]
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
	    
	    def popDGsetViewMaster = 
	    {
			  try {
			       def app = IndApplicationDetails.get((params.id).toInteger())
			    	def DGList = DGSetDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,DGList:DGList]
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

	    def saveDGsetMaster = 
	    {
			  try {
			        def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def DGList=DGSetDetailsMaster.findAll("from DGSetDetailsMaster abcd where abcd.application=?",[app])
		        	def a = ""
		        	int x = 0
		        	float z= 0.0
		        	if(DGList)
		        	{
		        		flash.message="Details already exist!!!"
		        		redirect(action:popDGsetAdd,id:app)
		        	}
		        	else
		        	{
		        	def dgInst = new DGSetDetailsMaster(params)
		        	 a = params.powerRating
		        		if(!(a=="")){
		        		 x= Integer.parseInt(a)
		        		} 
		        		if(!(params.heightOfBuilding=="")){
		        		z = params.heightOfBuilding.toFloat()
		        		}
		        		float y =0.0
		        		if(x==0){
		        			y=0.0
		        		}
		        		else if(x<50){
		        			y=z+1.5   			
		        	}
		        		else if(x>50 && x<=100) {
		        			y=z+2.0
		        		}
		        		else if(x>100 && x<=150){
		        			y=z+2.5
		        		}
		        		else if(x>150 && x<=200){
		        			y=z+3.0
		        		}	
		        		else if(x>200 && x<=250){
		        			y=z+3.5
		        		}	
		        		else if(x>250 && x<=300){
		        			y=z+3.5
		        		}
		        		dgInst.totalHeight=y
		        		dgInst.application = app
		        		dgInst.save()
		            	flash.message = "Details Saved"
		                redirect(action:popDGsetAddMaster,id:app)
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
	    
	    def editDGsetMaster = {
			  try {
			    	def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def dgInst = DGSetDetailsMaster.get((params.delete).toInteger())
			    		dgInst.delete()
			    	}
			    	else
			    	{
			    		if(params.delete)
			    			for(int i=0;i<(params.delete).size();i++)
			    			{
			    			def stackDetInst = DGSetDetailsMaster.get((params.delete[i]).toInteger())
			        		stackDetInst.delete()
			    			}
			    	}
			    	redirect(action:popDGsetEditMaster,id:app)
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
	  
		def popDGSourceAddMaster = 
		{
			  try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def DGList = DGSetEmissionDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,DGList:DGList]
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
	    
	    def popDGSourceEditMaster = 
	    {
			  try {
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def DGList = DGSetEmissionDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,DGList:DGList]
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
	    
	    def popDGSourceViewMaster = 
	    {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
			    	def DGList = DGSetEmissionDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,DGList:DGList]
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

	    def saveDGSourceMaster = 
	    {
			  try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def DGList=DGSetEmissionDetailsMaster.findAll("from DGSetEmissionDetailsMaster abcd where abcd.application=?",[app])
			    	if((params.source).getClass().getName()== "java.lang.String")
			    	{
			    		def dgInst = new DGSetEmissionDetailsMaster(params)
			    		dgInst.application = app
			    		dgInst.save()
			        	flash.message = "Details Saved"
			            redirect(action:popDGSourceAddMaster,id:app)
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
	    
	    def editDGSourceMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def dgInst = DGSetEmissionDetailsMaster.get((params.delete).toInteger())
			    		dgInst.delete()
			    	}
			    	else
			    	{
			    		if(params.delete)
			    			for(int i=0;i<(params.delete).size();i++)
			    			{
			    			def stackDetInst = DGSetEmissionDetailsMaster.get((params.delete[i]).toInteger())
			        		stackDetInst.delete()
			    			}
			    	}
			    	redirect(action:popDGSourceEditMaster,id:app)
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

	  def popDGParameterAddMaster = 
		{
			  try {
				    def d = params.d
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def dgList = DGSetParameterDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,dgList:dgList]
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
	    
	    def popDGParameterViewMaster = 
	    {
			  try {
				    
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def dgList = DGSetParameterDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,dgList:dgList]
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
	    
	    def popDGParameterEditMaster = 
	    {
			  try {
				    
			    	def app = IndApplicationDetails.get((params.id).toInteger())
			    	def dgList = DGSetParameterDetailsMaster.findAllByApplication(app)
			    	return [appDetId:params.id,dgList:dgList]
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
		
		def saveDGParameterMaster = 
		{
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def dgInstance = new DGSetParameterDetailsMaster()
			    	def parameters = params.parameters
			    	def dgList = DGSetParameterDetailsMaster.findAll("from DGSetParameterDetails abc where abc.parameters=? and abc.application=?",[parameters,app])
			    	if(parameters=="Not Selected")
			    	{
			    		flash.message = "Please Select Parameters"
			        	redirect(action:popDGParameterAdd,id:app,params:[dgInstance:dgInstance])
			    	}
			    	else if(dgList)
			    	{
			    		flash.message = "D.G. Set Parameter details regarding ${parameters} already exists"
			    		redirect(action:popDGParameterAddMaster,id:app,params:[dgInstance:dgInstance])
			    	}
			    	else
			    	{
			    		dgInstance.parameters = params.parameters
			    		dgInstance.noLoad = params.noLoad
			    		dgInstance.fullLoad = params.fullLoad 
			    		dgInstance.application = app
			        	dgInstance.save()
			        	redirect(action:popDGParameterAddMaster,id:app,params:[dgInstance:dgInstance])
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
		
		def editDGParameterMaster = 
		{
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	if((params.delete).getClass().getName()== "java.lang.String"){
			    		def indCostDetInst = DGSetParameterDetailsMaster.get((params.delete).toInteger())
			    		indCostDetInst.delete()
			    	}else{
			    		if(params.delete)
			        	for(int i=0;i<(params.delete).size();i++){
			        		def indCostDetInst = DGSetParameterDetailsMaster.get((params.delete[i]).toInteger())
			        		indCostDetInst.delete()
			        	}
			    	}
			    	redirect(action:popDGParameterEditMaster,id:app)
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

	   def popBrickKilnAddMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
		        	def brickList = BrickKilnDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,brickList:brickList]
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
	        
	        def popBrickKilnEditMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
		        	def brickList = BrickKilnDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,brickList:brickList]
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
	        
	        def popBrickKilnViewMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
		        	def brickList = BrickKilnDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,brickList:brickList]
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

	        def saveBrickKilnDetailMaster = 
	        {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
	            	def airMiscDetailsInst = new BrickKilnDetailMaster(params)
	        		def dgList = BrickKilnDetailMaster.findAll("from BrickKilnDetailMaster abc where abc.application=?",[app])
	            	if(dgList)
	            	{
	            		flash.message = "Brick Kiln details already exists"
	            		redirect(action:popBrickKilnAddMaster,id:app,params:[airMiscDetailsInst:airMiscDetailsInst])
	            	}
	            	else
	            	{
	            		airMiscDetailsInst.application = app
	            		airMiscDetailsInst.save()
	    	        	redirect(action:popBrickKilnAddMaster,id:app,params:[airMiscDetailsInst:airMiscDetailsInst])
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
	  
	        def editBrickKilnDetailMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def airMiscDetInst = BrickKilnDetailMaster.get((params.delete).toInteger())
		        		airMiscDetInst.delete()
		        	}
		        	else
		        	{
		        		if(params.delete)
		        			for(int i=0;i<(params.delete).size();i++)
		        			{
		        			def airMiscDetInst = BrickKilnDetailMaster.get((params.delete[i]).toInteger())
		            		airMiscDetInst.delete()
		        			}
		        	}
		        	redirect(action:popBrickKilnEditMaster,id:app)
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
	  
	 def popWaterSourceDetailsAddMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneCrusherWaterReqList = StoneCrusherWaterReqMaster.findAllByApplication(app)
		        	return [appDetId:params.id,stoneCrusherWaterReqList:stoneCrusherWaterReqList]
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
	    
	    def popWaterSourceDetailsViewMaster = {
			  try {
				  def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneCrusherWaterReqList = StoneCrusherWaterReqMaster.findAllByApplication(app)
		        	return [appDetId:params.id,stoneCrusherWaterReqList:stoneCrusherWaterReqList]
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
	    
	    def popWaterSourceDetailsEditMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneCrusherWaterReqList = StoneCrusherWaterReqMaster.findAllByApplication(app)
		        	return [appDetId:params.id,stoneCrusherWaterReqList:stoneCrusherWaterReqList]	
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
	    
 def popWaterConsumptionDetailAddMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
		        	def waterConsumptionDetailList = WaterConsumptionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,waterConsumptionDetailList:waterConsumptionDetailList]
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
	  
def popWaterConsumptionDetailViewMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def waterConsumptionDetailList = WaterConsumptionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,waterConsumptionDetailList:waterConsumptionDetailList]
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
	    
	 def popWaterConsumptionDetailEditMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def waterConsumptionDetailList = WaterConsumptionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,waterConsumptionDetailList:waterConsumptionDetailList]
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
	   
	    def editWaterSourceDetailMaster= {
			  try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def wastersourceDetails = StoneCrusherWaterReqMaster.get((params.delete).toInteger())
		        		wastersourceDetails.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			def wastersourceDetails = StoneCrusherWaterReqMaster.get((params.delete[i]).toInteger())
		            		wastersourceDetails.delete()
		        		}
		        	}
		        	redirect(action:popWaterSourceDetailsEditMaster,id:app)
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
	       
	def saveWaterSourceDetailMaster= {
			  try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
		        def stoneCrusherWaterReqList = new StoneCrusherWaterReqMaster()
		        	def waterDisp = params.sourceOfWaterSupply
		       def dgList = StoneCrusherWaterReqMaster.findAll("from StoneCrusherWaterReqMaster abc where abc.sourceOfWaterSupply=? and abc.application=?",[waterDisp,app])
		       if(waterDisp=="Not Selected")
		 	{
		 		flash.message = "Please Select Water Source Details"
		     	redirect(action:popWaterSourceDetailsAddMaster,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
		 	}
		 	else if(dgList)
		 	{
		 		flash.message = "Water Source details regarding ${waterDisp} already exists"
		 		redirect(action:popWaterSourceDetailsAddMaster,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
		 	}
		 	else
		 	{  	stoneCrusherWaterReqList.sourceOfWaterSupply = waterDisp
		 		stoneCrusherWaterReqList.quantity = params.quantity
		 		stoneCrusherWaterReqList.application = app
		 		stoneCrusherWaterReqList.save(flush:true)
		     	redirect(action:popWaterSourceDetailsAddMaster,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
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
	    
def editWaterConsumptionDetailMaster= {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        def wasterconsumptionDetails = WaterConsumptionDetailMaster.get((params.delete).toInteger())
		        		wasterconsumptionDetails.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			def wasterconsumptionDetails = WaterConsumptionDetailMaster.get((params.delete[i]).toInteger())
		            		wasterconsumptionDetails.delete()
		        		}
		        	}
		        	redirect(action:popWaterConsumptionDetailEditMaster,id:app)
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
	    
	  def saveWaterConsumptionDetailMaster= {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def waterConsumptionDetailList = new WaterConsumptionDetailMaster()
		        	def waterConsumptionType = params.waterConsumptionType
		       def dgList = WaterConsumptionDetailMaster.findAll("from WaterConsumptionDetailMaster abc where abc.waterConsumptionType=? and abc.application=?",[waterConsumptionType,app])
		     if(waterConsumptionType=="Not Selected")
		 	{
		 		flash.message = "Please Select Water consumption Details"
		     	redirect(action:popWaterConsumptionDetailAddMaster,id:app,params:[waterConsumptionDetailList:waterConsumptionDetailList])
		 	}
		 	else if(dgList)
		 	{
		 		flash.message = "Water Consumption details regarding ${waterConsumptionType} already exists"
		 		redirect(action:popWaterConsumptionDetailAddMaster,id:app,params:[waterConsumptionDetailList:waterConsumptionDetailList])
		 	}
		 	else
		 	{  	waterConsumptionDetailList.waterConsumptionType = waterConsumptionType
		 		waterConsumptionDetailList.quantity = params.quantity
		 		waterConsumptionDetailList.storageFacility = params.storageFacility
		 		waterConsumptionDetailList.application = app
		 		waterConsumptionDetailList.save(flush:true)
		     	redirect(action:popWaterConsumptionDetailAddMaster,id:app,params:[waterConsumptionDetailList:waterConsumptionDetailList])
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
	    
 def popStoneSittingCriteriaAddMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneSittingCriteriaList = StoneCrusherSittingCriteriaMaster.findAllByApplication(app)
		        	return [appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
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
	  
	    def  popStoneSittingCriteriaViewMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneSittingCriteriaList = StoneCrusherSittingCriteriaMaster.findAllByApplication(app)
		        	return [appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
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
	  
def popStoneSittingCriteriaEditMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneSittingCriteriaList = StoneCrusherSittingCriteriaMaster.findAllByApplication(app)
		        	return [appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
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
	  
def saveStoneSittingCriteriaMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	println("cccvvvvvvv111"+app)
				   def stoneSittingCriteriaInst = new StoneCrusherSittingCriteriaMaster()
				   println("cccvvvvvvv222"+stoneSittingCriteriaInst)
				   def par = StoneCrusherParameterMaster.get((params.parameter).toInteger())
		        	println("cccvvvvvvv333"+par)
				   def dgList = StoneCrusherSittingCriteriaMaster.findAll("from StoneCrusherSittingCriteriaMaster abc where abc.parameter=? and abc.application=?",[par,app])
		        	println("cccvvvvvvv444"+dgList)
				   if(dgList)
		        	{
		        		flash.message = "Stone Sitting Criteria Details regarding ${par.toString()} already exists"
		        		redirect(action:popStoneSittingCriteriaAddMaster,id:app,params:[stoneSittingCriteriaInst:stoneSittingCriteriaInst])
		        	}
		        	else
		        	{
		        		flash.message = "Stone Sitting Criteria Details regarding ${par.toString()} is saved"
		            	stoneSittingCriteriaInst.application = app
		            	stoneSittingCriteriaInst.parameter = par
		            	stoneSittingCriteriaInst.distance = params.distance
		            	stoneSittingCriteriaInst.save(flush:true)
		            	redirect(action:popStoneSittingCriteriaAddMaster,id:app)
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
	  
def editStoneSittingCriteriaMaster= {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String")
		        	{
		        		def stoneSittingCriteriaInst = StoneCrusherSittingCriteriaMaster.get((params.delete).toInteger())
		        		stoneSittingCriteriaInst.delete()
		        	}
		        	else
		        	{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++)
		        		{
		        			def stoneSittingCriteriaInst = StoneCrusherSittingCriteriaMaster.get((params.delete[i]).toInteger())
		            		stoneSittingCriteriaInst.delete()
		        		}
		        	}
		        	redirect(action:popStoneSittingCriteriaEditMaster,id:app)
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

def popBrickSittingCriteriaAddMaster = {
			  try {
				def app = IndApplicationDetails.get((params.id).toInteger())
		        	def brickSittingCriteriaList = BrickSittingCriteriaDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,brickSittingCriteriaList:brickSittingCriteriaList]
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
	  
def  popBrickSittingCriteriaViewMaster = {
			  try {
				def app = IndApplicationDetails.get((params.id).toInteger())
		        	def brickSittingCriteriaList = BrickSittingCriteriaDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,brickSittingCriteriaList:brickSittingCriteriaList]
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
	  
def popBrickSittingCriteriaEditMaster = {
			  try {
				 def app = IndApplicationDetails.get((params.id).toInteger())
		        	def brickSittingCriteriaList = BrickSittingCriteriaDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,brickSittingCriteriaList:brickSittingCriteriaList]
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
	  
def saveBrickSittingCriteriaMaster= {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def brickSittingCriteriaInst = new BrickSittingCriteriaDetailsMaster()
		        	def par = StoneCrusherParameterMaster.get((params.parameter).toInteger())
		        	def dgList = BrickSittingCriteriaDetailsMaster.findAll("from BrickSittingCriteriaDetails abc where abc.parameter=? and abc.application=?",[par,app])
		        	if(dgList)
		        	{
		        		flash.message = "Brick Sitting Criteria Details regarding ${par.toString()} already exists"
		        		redirect(action:popBrickSittingCriteriaAddMaster,id:app,params:[brickSittingCriteriaInst:brickSittingCriteriaInst])
		        	}
		        	else
		        	{
		        		flash.message = "Brick Sitting Criteria Details regarding ${par.toString()} is saved"
		            	brickSittingCriteriaInst.application = app
		            	brickSittingCriteriaInst.parameter = par
		            	brickSittingCriteriaInst.distance = params.distance
		            	brickSittingCriteriaInst.save()
		            	redirect(action:popBrickSittingCriteriaAddMaster,id:app)
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
	  
def editBrickSittingCriteriaMaster= {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String")
		        	{
		        		def brickSittingCriteriaInst = BrickSittingCriteriaDetailsMaster.get((params.delete).toInteger())
		        		brickSittingCriteriaInst.delete()
		        	}
		        	else
		        	{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++)
		        		{
		        			def brickSittingCriteriaInst = BrickSittingCriteriaDetailsMaster.get((params.delete[i]).toInteger())
		            		brickSittingCriteriaInst.delete()
		        		}
		        	}
		        	redirect(action:popBrickSittingCriteriaEditMaster,id:app)
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
  
 def popStoneCrusherControlDevicesAddMaster = {
			  try {
				  def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneSittingCriteriaList = StoneCrusherControlDevicesMasterM.findAllByApplication(app)
		        	return [appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
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
	   
def  popStoneCrusherControlDevicesViewMaster = {
			  try {
				def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneSittingCriteriaList = StoneCrusherControlDevicesMasterM.findAllByApplication(app)
		        	return [appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
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
	  
def popStoneCrusherControlDevicesEditMaster = {
			  try {
				 def app = IndApplicationDetails.get((params.id).toInteger())
		        	def stoneSittingCriteriaList = StoneCrusherControlDevicesMasterM.findAllByApplication(app)
		        	return [appDetId:params.id,stoneSittingCriteriaList:stoneSittingCriteriaList]
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
	  
 def saveStoneCrusherControlMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	println("cccvvvvvvv111"+app)
				   def stoneSittingCriteriaInst = new StoneCrusherControlDevicesMasterM()
				   println("cccvvvvvvv222"+stoneSittingCriteriaInst)
				   def par = StoneCrusherControlDevicesMaster.get((params.device).toInteger())
		        	println("cccvvvvvvv333"+par)
				   def dgList = StoneCrusherControlDevicesMasterM.findAll("from StoneCrusherControlDevicesMasterM abc where abc.device=? and abc.application=?",[par,app])
		        	if(dgList)
		        	{
		        		flash.message = "Stone Crusher Pollution Control Devices Details regarding ${par.toString()} already exists"
		        		redirect(action:popStoneCrusherControlDevicesAddMaster,id:app,params:[stoneSittingCriteriaInst:stoneSittingCriteriaInst])
		        	}
		        	else
		        	{
		        		flash.message = "Stone Crusher Pollution Control Devices Details regarding ${par.toString()} is saved"
		            	stoneSittingCriteriaInst.application = app
		            	stoneSittingCriteriaInst.device = par
		            	stoneSittingCriteriaInst.name = params.name
		            	stoneSittingCriteriaInst.status = params.status
		            	stoneSittingCriteriaInst.save()
		            	redirect(action:popStoneCrusherControlDevicesAddMaster,id:app)
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
	  
def editStoneCrusherControlMaster= {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String")
		        	{
		        		def stoneSittingCriteriaInst = StoneCrusherControlDevicesMasterM.get((params.delete).toInteger())
		        		stoneSittingCriteriaInst.delete()
		        	}
		        	else
		        	{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++)
		        		{
		        			def stoneSittingCriteriaInst = StoneCrusherControlDevicesMasterM.get((params.delete[i]).toInteger())
		            		stoneSittingCriteriaInst.delete()
		        		}
		        	}
		        	redirect(action:popStoneCrusherControlDevicesEditMaster,id:app)
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

 def popNocAuthorityAddMaster = {
			  try {
				   def d = params.d
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def nocAuthorityDetailsInst = NocAuthorityDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,nocAuthorityDetailsInst:nocAuthorityDetailsInst,d:d]
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
	  
def popNocAuthorityViewMaster = {
			  try {
				    def d = params.d
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def nocAuthorityDetailsInst = NocAuthorityDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,nocAuthorityDetailsInst:nocAuthorityDetailsInst,d:d]
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
	   
 def popNocAuthorityEditMaster = {
			  try {
				   def d = params.d
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def nocAuthorityDetailsInst = NocAuthorityDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,nocAuthorityDetailsInst:nocAuthorityDetailsInst,d:d]
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
	    
def saveNOCAuthorityMaster = 
	    {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
			    	def nocAuthorityDetailsInst = new NocAuthorityDetailsMaster(params)
			    	def authorityDetails =params.authorityDetails
			    	def dgList = NocAuthorityDetailsMaster.findAll("from NocAuthorityDetailsMaster abc where abc.authorityDetails=? and abc.application=?",[authorityDetails,app])
			     	 if(dgList)
			 	{
			 		flash.message = "NOC Authority details regarding ${authorityDetails} already exists"
			 		redirect(action:popNocAuthorityAddMaster,id:app,params:[nocAuthorityDetailsInst:nocAuthorityDetailsInst])
			 	}
			 	else
			 	{  	nocAuthorityDetailsInst.authorityDetails = params.authorityDetails
			 		nocAuthorityDetailsInst.status = params.status
			 		nocAuthorityDetailsInst.number = params.number
			 		
			 		nocAuthorityDetailsInst.date = params.date_value
			 		nocAuthorityDetailsInst.application = app
			 		nocAuthorityDetailsInst.save()
			     	
			 		flash.message = "Details Saved"
			 		redirect(action:popNocAuthorityAddMaster,id:app,params:[nocAuthorityDetailsInst:nocAuthorityDetailsInst])
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
	  
def editNocAuthorityDetailMaster= {
			  try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def wastersolidDetails = NocAuthorityDetailsMaster.get((params.delete).toInteger())
		        		wastersolidDetails.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			def wastersolidDetails = NocAuthorityDetailsMaster.get((params.delete[i]).toInteger())
		            		wastersolidDetails.delete()
		        		}
		        	}
		        	redirect(action:popNocAuthorityEditMaster,id:app)
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
	  
def popHotelFacilityAddMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		            	def hotelFacilitylist = HotelFacilityDetailMaster.findAllByApplication(app)
		               def districtList = HotelFacilityTypeMaster.list( sort:"typeName", order:"asc")
		            	return [appDetId:params.id ,districtList:districtList,hotelFacilitylist:hotelFacilitylist]
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
	        
def saveHotelFacilityDetailMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
		    		def hotelFacilityInst = new HotelFacilityDetailMaster(params)
		    		def hotelFacilityMasterInst = HotelFacilityMaster.get(params.facility.id)
		    		def facilityId = params.facility.id
		    		def facilityTypeList = params.hotelFacilityType.id
		    		def hotelFacilitylist = HotelFacilityDetailMaster.findAll("from HotelFacilityDetailMaster abc where abc.facility.id=? and abc.hotelFacilityType.id=? and abc.application=?",[facilityId.toLong(),facilityTypeList.toLong(),app])
		    		def name = hotelFacilitylist.facility.name
		    		if(hotelFacilitylist)
		    		{
		    		flash.message = "Hotel Facility Details regarding ${name.toString()} already exists"
		    		redirect(action:popHotelFacilityAddMaster,id:app,params:[hotelFacilitylist:hotelFacilitylist])
		    		}
		    		else
		    		{
		    		hotelFacilityInst.application = app
		    		hotelFacilityInst.capacity = params.capacity
		    		hotelFacilityInst.facilityDetail = params.facilityDetail
		    		hotelFacilityInst.save()
		    		redirect(action:popHotelFacilityAddMaster,id:app)
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
	  
def myAjax12 ={
			  try {
				   def facilityTypeList
		    		def a
		    		def dist
		    		if(params.cont== '9999' ) {
		    			render g.select( width:'10', optionKey:'id',name:'facility.id', from:facilityTypeList)
		    		}
		    		else {
		    		a = params.cont
		    		dist = HotelFacilityTypeMaster.get(a)
		    		facilityTypeList = HotelFacilityMaster.findAll("from HotelFacilityMaster tm where tm.hotelFacilityType=? order by tm.name asc",[dist])
		    		render g.select( width:'10', optionKey:'id',name:'facility.id', from:facilityTypeList)
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
	    
def popHotelFacilityViewMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelFacilitylist = HotelFacilityDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelFacilitylist:hotelFacilitylist]
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
	    
 def popHotelFacilityEditMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelFacilitylist = HotelFacilityDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelFacilitylist:hotelFacilitylist]
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
	    
def editHotelFcilityDetailMaster = {
			  try {
				  def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def hotelFacilityDetail = HotelFacilityDetailMaster.get((params.delete).toInteger())
		        		hotelFacilityDetail.delete()
		        	}else{
		        		if(params.delete)
		        		for(int i=0;i<(params.delete).size();i++){
		        			def hotelFacilityDetail = HotelFacilityDetailMaster.get((params.delete[i]).toInteger())
		            		hotelFacilityDetail.delete()
		        		}
		        	}
		        	redirect(action:popHotelFacilityEditMaster,id:app)
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
	    
def popHotelWasteEmissionAddMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		            	def hotelWasteEmissionList = HotelWasteEmissionDetailMaster.findAllByApplication(app)
		                	return [appDetId:params.id ,hotelWasteEmissionList:hotelWasteEmissionList]
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
	         
def saveHotelWasteEmissionDetailMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.appId).toInteger())
	            	def hotelWasteEmissionInst = new HotelWasteEmissionDetailMaster()
	            	def par = HotelWasteEmissionGenerationMaster.get((params.type).toInteger())
	            	def hotelWasteEmissionList = HotelWasteEmissionDetailMaster.findAll("from HotelWasteEmissionDetailMaster abc where abc.type=? and abc.application=?",[par,app])
	           if(hotelWasteEmissionList)
	            	{
	            	        		flash.message = "Hotel Waste Emission Details regarding ${par.toString()} already exists"
	            	        			
	            	        		redirect(action:popHotelWasteEmissionAddMaster,id:app,params:[hotelWasteEmissionList:hotelWasteEmissionList])
	            	}
	            	else
	            	{
	            		flash.message = "Hotel Waste Emission Details regarding ${par.toString()} is saved"
	            			hotelWasteEmissionInst.application = app
	            			hotelWasteEmissionInst.type = par
	            			hotelWasteEmissionInst.quantity = params.quantity
	            			hotelWasteEmissionInst.nature = params.nature
	            			hotelWasteEmissionInst.tmethod = params.tmethod
	            			hotelWasteEmissionInst.save()
	                	redirect(action:popHotelWasteEmissionAddMaster,id:app)
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

	    
def popHotelWasteEmissionViewMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelWasteEmissionList = HotelWasteEmissionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelWasteEmissionList:hotelWasteEmissionList]
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
	    
def popHotelWasteEmissionEditMaster = {
			  try {
				  def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelWasteEmissionList = HotelWasteEmissionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelWasteEmissionList:hotelWasteEmissionList]
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
	    
def editHotelWasteEmissionMaster = {
			  try {
				def app = IndApplicationDetails.get((params.appId).toInteger())
  	        	if((params.delete).getClass().getName()== "java.lang.String"){
  	        		
  	        		def hotelWasteEmissionDetail = HotelWasteEmissionDetailMaster.get((params.delete).toInteger())
  	        		hotelWasteEmissionDetail.delete()
  	        	}else{
  	        		if(params.delete)
  	        		for(int i=0;i<(params.delete).size();i++){
  	        			def hotelWasteEmissionDetail = HotelWasteEmissionDetailMaster.get((params.delete[i]).toInteger())
  	            		hotelWasteEmissionDetail.delete()
  	        		}
  	        	}
  	        	redirect(action:popHotelWasteEmissionEditMaster,id:app)
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
	    
def popHotelOtherDetailAddMaster = {
			  try {
				  def app = IndApplicationDetails.get((params.id).toInteger())
		            def hotelOtherDetailList = HotelGeneralDetailsMaster.findAllByApplication(app)
		           return [appDetId:params.id ,hotelOtherDetailList:hotelOtherDetailList]
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
	    
def saveHotelOtherDetailMaster= {
			  try {
				 def app = IndApplicationDetails.get((params.appId).toInteger())
		          def hotelOtherDetailList = HotelGeneralDetailsMaster.findAllByApplication(app)
		          	if(hotelOtherDetailList)
		          	{
		          		flash.message = "Hotel ganeral details already exists"
			        			redirect(action:popHotelOtherDetailAddMaster,id:app)
		          	}
		          	else
		          	{      		
		          		flash.message = "Hotel ganeral details saved"
		           def hotelOtherDetailInst = new HotelGeneralDetailsMaster(params)
		      		hotelOtherDetailInst.application = app
		      		
		      		hotelOtherDetailInst.save()
		      		redirect(action:popHotelOtherDetailAddMaster,id:app)
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
	    
 def popHotelOtherDetailViewMaster = {
			  try {
				    def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelOtherDetailList = HotelGeneralDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelOtherDetailList:hotelOtherDetailList]
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
	    
def popHotelOtherDetailEditMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelOtherDetailList = HotelGeneralDetailsMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelOtherDetailList:hotelOtherDetailList]
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
	    
def editHotelOtherDetailMaster = {
			  try {
				def app = IndApplicationDetails.get((params.appId).toInteger())
  	        	if((params.delete).getClass().getName()== "java.lang.String"){
  	        		def hotelGeneralDetails = HotelGeneralDetailsMaster.get((params.delete).toInteger())
  	        		hotelGeneralDetails.delete()
  	        	}else{
  	        		if(params.delete)
  	        		for(int i=0;i<(params.delete).size();i++){
  	        			def hotelGeneralDetails = HotelGeneralDetailsMaster.get((params.delete[i]).toInteger())
  	            		hotelGeneralDetails.delete()
  	        		}
  	        	}
  	        	redirect(action:popHotelOtherDetailEditMaster,id:app)
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
	  
def popHotelWaterConsumptionAddMaster = {
			  try {
				  def app = IndApplicationDetails.get((params.id).toInteger())
		            def hotelWaterConsumptionlist = HotelWaterConsumptionDetailMaster.findAllByApplication(app)
		           return [appDetId:params.id ,hotelWaterConsumptionlist:hotelWaterConsumptionlist]
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
	 
def saveHotelWaterConsumptionMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def hotelWaterConsumptionInst = new HotelWaterConsumptionDetailMaster()
		        	def par = HotelWaterConsumptionMaster.get((params.type).toInteger())
		        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetailMaster.findAll("from HotelWaterConsumptionDetailMaster abc where abc.type=? and abc.application=?",[par,app])
		       if(hotelWaterConsumptionlist)
		        	{
		        	      flash.message = "Hotel Water Consumption Details regarding ${par.toString()} already exists"
		        	       redirect(action:popHotelWaterConsumptionAddMaster,id:app,params:[hotelWaterConsumptionlist:hotelWaterConsumptionlist])
		        	}
		        	else
		        	{
		        		flash.message = "Hotel Water Consumption Details regarding ${par.toString()} is saved"
		        			hotelWaterConsumptionInst.application = app
		        			hotelWaterConsumptionInst.type = par
		        			hotelWaterConsumptionInst.quantity = params.quantity
		        			hotelWaterConsumptionInst.save()
		            	redirect(action:popHotelWaterConsumptionAddMaster,id:app)
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
	    	    
def popHotelWaterConsumptionViewMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelWaterConsumptionlist:hotelWaterConsumptionlist]
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
	    
def popHotelWaterConsumptionEditMaster = {
			  try {
				   def app = IndApplicationDetails.get((params.id).toInteger())
		        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetailMaster.findAllByApplication(app)
		        	return [appDetId:params.id,hotelWaterConsumptionlist:hotelWaterConsumptionlist]
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
	    
	    def editHotelWaterConsumptionMaster = {
			  try {
				def app = IndApplicationDetails.get((params.appId).toInteger())
  	        	if((params.delete).getClass().getName()== "java.lang.String"){
  	        		def hotelWaterConsumptionDetail = HotelWaterConsumptionDetailMaster.get((params.delete).toInteger())
  	        		hotelWaterConsumptionDetail.delete()
  	        	}else{
  	        		if(params.delete)
  	        		for(int i=0;i<(params.delete).size();i++){
  	        			def hotelWaterConsumptionDetail = HotelWaterConsumptionDetailMaster.get((params.delete[i]).toInteger())
  	            		hotelWaterConsumptionDetail.delete()
  	        		}
  	        	}
  	        	redirect(action:popHotelWaterConsumptionEditMaster,id:app)
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
	  
	def insertIndustryDataIntoMaster(IndustryRegMaster industryRegMaster){
		  try {
			   def newList = IndustryMasterDetails.find("from IndustryMasterDetails where indUser = ? ",[industryRegMaster])
				println("newList....."+newList)
			   if(newList == null){
					def oldSingleInstance = IndustryRegMaster.find("from IndustryRegMaster where id = ? ",[industryRegMaster.id])
					println("oldSingleInstance....."+oldSingleInstance)
					IndustryMasterDetails masterDetails = new IndustryMasterDetails()
					println("zzzzzzzzzzz"+params.conclution)
	
			masterDetails.conclution=""
		
					
					
	//masterDetails.conclution	 = 	params.conclution
	masterDetails.indUser  = oldSingleInstance
	masterDetails.indName  = oldSingleInstance.indName
	masterDetails.indType  = oldSingleInstance.indType//
	masterDetails.industryType  = oldSingleInstance.industryType//
	masterDetails.category  = oldSingleInstance.category//
	masterDetails.indStatus  = oldSingleInstance.indStatus
	masterDetails.dateOfComm  = oldSingleInstance.dateOfComm
	masterDetails.indRegNum  = oldSingleInstance.indRegNum
	masterDetails.indCapInvt  = oldSingleInstance.indCapInvt
	masterDetails.siteArea	 = 	oldSingleInstance.siteArea
	masterDetails.indAddress	 = 	oldSingleInstance.indAddress
	masterDetails.plotNo	 = 	oldSingleInstance.plotNo
	masterDetails.indCity	 = 	oldSingleInstance.indCity
	masterDetails.tehsil	 = 	oldSingleInstance.tehsil
	masterDetails.district	 = 	oldSingleInstance.district
	masterDetails.indPin	 = 	oldSingleInstance.indPin
	masterDetails.indTypeOther	 = 	oldSingleInstance.indTypeOther
	masterDetails.indPhoneCode	 = 	oldSingleInstance.indPhoneCode
	masterDetails.indPhoneNo	 = 	oldSingleInstance.indPhoneNo
	masterDetails.indFaxCode	 = 	oldSingleInstance.indFaxCode
	masterDetails.indFaxNo	 = 	oldSingleInstance.indFaxNo
	masterDetails.indEmail	 = 	oldSingleInstance.indEmail
	masterDetails.occName	 = 	oldSingleInstance.occName
	masterDetails.occDesignation	 = 	oldSingleInstance.occDesignation
	masterDetails.occAddress	 = 	oldSingleInstance.occAddress
	masterDetails.occCity	 = 	oldSingleInstance.occCity
	masterDetails.occTehsil	 = 	oldSingleInstance.occTehsil
	masterDetails.occDistrict	 = 	oldSingleInstance.occDistrict
	masterDetails.occPin	 = 	oldSingleInstance.occPin
	masterDetails.occPhoneCode	 = 	oldSingleInstance.occPhoneCode
	masterDetails.occPhoneNo	 = 	oldSingleInstance.occPhoneNo
	masterDetails.occFaxCode	 = 	oldSingleInstance.occFaxCode
	masterDetails.occFaxNo	 = 	oldSingleInstance.occFaxNo
	masterDetails.occMobile	 = 	oldSingleInstance.occMobile
	masterDetails.occEmail	 = 	oldSingleInstance.occEmail
	masterDetails.statusOfAppl	 = 	oldSingleInstance.statusOfAppl
	masterDetails.nameAddressPartners	 = 	oldSingleInstance.nameAddressPartners
	/////////////ritesh///////////////
	
	//////////////////////////////////
	masterDetails.noOfEmp	 = 	oldSingleInstance.noOfEmp
	masterDetails.shiftsIndustry	 = 	oldSingleInstance.shiftsIndustry
	masterDetails.monitoring	 = 	oldSingleInstance.monitoring
	masterDetails.nationality	 = 	oldSingleInstance.nationality
	masterDetails.expDate	 = 	oldSingleInstance.expDate
	masterDetails.expNoEmp	 = 	oldSingleInstance.expNoEmp
	masterDetails.waterMonitoring	 = 	oldSingleInstance.waterMonitoring
	masterDetails.dateCreated	 = 	oldSingleInstance.dateCreated
	masterDetails.createdBy	 = 	oldSingleInstance.createdBy
	masterDetails.lastUpdated	 = 	oldSingleInstance.lastUpdated
	masterDetails.updatedBy	 = 	oldSingleInstance.updatedBy
	masterDetails.regDate	 = 	oldSingleInstance.regDate
	masterDetails.regAuthority	 = 	oldSingleInstance.regAuthority
	masterDetails.commMonth	 = 	oldSingleInstance.commMonth
	masterDetails.industryScale	 = 	oldSingleInstance.industryScale
	masterDetails.equipWithSepMeters	 = 	oldSingleInstance.equipWithSepMeters
	masterDetails.equipDGSet	 = 	oldSingleInstance.equipDGSet
	masterDetails.treePlantDev	 = 	oldSingleInstance.treePlantDev
	masterDetails.wasteMinDetail	 = 	oldSingleInstance.wasteMinDetail
	masterDetails.underPubHearing	 = 	oldSingleInstance.underPubHearing
	masterDetails.nearRiver	 = 	oldSingleInstance.nearRiver
	masterDetails.riverName	 = 	oldSingleInstance.riverName
	masterDetails.riverDist	 = 	oldSingleInstance.riverDist
	masterDetails.nearResidCol	 = 	oldSingleInstance.nearResidCol
	masterDetails.colPopulation	 = 	oldSingleInstance.colPopulation
	masterDetails.colLocation	 = 	oldSingleInstance.colLocation
	masterDetails.colDistance	 = 	oldSingleInstance.colDistance
	masterDetails.nearIndEstate	 = 	oldSingleInstance.nearIndEstate
	masterDetails.disposalSysProv	 = 	oldSingleInstance.disposalSysProv
	masterDetails.utilizeSys	 = 	oldSingleInstance.utilizeSys
	masterDetails.proposalDetails	 = 	oldSingleInstance.proposalDetails
	masterDetails.plotArea	 = 	oldSingleInstance.plotArea
	masterDetails.builtUpArea	 = 	oldSingleInstance.builtUpArea
	masterDetails.totalProjectCost	 = 	oldSingleInstance.totalProjectCost
	masterDetails.pollutionMonitoringCost	 = 	oldSingleInstance.pollutionMonitoringCost
	masterDetails.nonHwmProdName	 = 	oldSingleInstance.nonHwmProdName
	masterDetails.landArea	 = 	oldSingleInstance.landArea
	masterDetails.prodCapacity	 = 	oldSingleInstance.prodCapacity
	masterDetails.sewage	 = 	oldSingleInstance.sewage
	masterDetails.sewageState	 = 	oldSingleInstance.sewageState
	masterDetails.treatedEffCapacity	 = 	oldSingleInstance.treatedEffCapacity
	masterDetails.hotelArea	 = 	oldSingleInstance.hotelArea
	masterDetails.totalPlotArea	 = 	oldSingleInstance.totalPlotArea
if(!masterDetails.hasErrors() && masterDetails.save(flush:true)) {
	    	 	       } else {
	    					masterDetails.errors.each {
	    						println it
	    				   }
	    				}	
	    		}else{
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

def popHazardActivityGenDetailsAddMaster = {
	    		 try {
	    		      def app = IndApplicationDetails.get((params.id).toInteger())
	    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsMaster.findAllByApplication(app)
	    	    		return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
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

def popHazardActivityGenDetailsViewMaster = {
	    		 try {
	    		     def app = IndApplicationDetails.get((params.id).toInteger())
	    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsMaster.findAllByApplication(app)
	    	    		return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
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

def popHazardActivityGenDetailsEditMaster = {
	    		 try {
	    		     def app = IndApplicationDetails.get((params.id).toInteger())
	    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsMaster.findAllByApplication(app)
	    	    		return [appDetId:params.id,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
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
	    		       def hazardNameList
	    	    		def a
	    	    		def dist
	    	    		if(params.cont== '9999' ) {
	    	    			render g.select( width:'10', optionKey:'id',name:'categoryName.id', from:hazardNameList)
	    	    		}
	    	    		else {
	    	    		a = params.cont
	    	    		dist = HazardousSourceGenMaster.get(a)
	    	    		hazardNameList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster tm where tm.sourceName=? ",[dist])
	    	    		render g.select( width:'10', optionKey:'id',name:'categoryName.id', from:hazardNameList)
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

def saveHazardGenDetailsMaster = {
	    		 try {
	    		       def app = IndApplicationDetails.get((params.appId).toInteger())
	    	    		if((params.quantity).getClass().getName()== "java.lang.String"){
	    	    			def hazardousWasteGenDetailsInst = new HazardousWasteGenDetailsMaster(params)
	    	    		def hazarName = params.categoryName.id
	    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetailsMaster.findByApplication(app)
	    	    		def harardName = HazardousWasteGenDetailsMaster.findAll("from HazardousWasteGenDetailsMaster indPower where indPower.categoryName.id=? and indPower.application=?",[hazarName.toLong(),app])
	    	    		
	    	    		if(harardName)
	    	    		{
	    	    		flash.message = "Details regarding ${harardName.categoryName} already exist"
	    	    		redirect(action:popHazardActivityGenDetailsAdd,id:app)
	    	    		}
	    	    		else
	    	    		{
	    	    		hazardousWasteGenDetailsInst.application = app
	    	    		def categoryList = HazardousCategoryMaster.findAll("from HazardousCategoryMaster tm where tm.id=? ",[hazarName.toLong()])
	    	    		
	    	    		String authReqFor=""

	    	    		if(hazarWasteGenDetailsList!=null)
	    	    		{
	    	    		authReqFor = hazarWasteGenDetailsList.authFor
	    	    		}
	    	    		else
	    	    		{
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
	    	    		}
	    	    		hazardousWasteGenDetailsInst.authFor=authReqFor
	    	    		hazardousWasteGenDetailsInst.save()
	    	    		flash.message = "Details Saved"
	    	    		redirect(action:popHazardActivityGenDetailsAddMaster,id:app)
	    	    		}}
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
	    
def deleteHazardGenDetailsMaster = {
	    		 try {
	    	    		def app = IndApplicationDetails.get((params.appId).toInteger())
	    	    		if((params.delete).getClass().getName()== "java.lang.String"){
	    	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetailsMaster.get((params.delete).toInteger())
	    	    		hazardousWasteGenDetailsInst.delete()
	    	    		}else{
	    	    		if(params.delete)
	    	    		for(int i=0;i<(params.delete).size();i++){
	    	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetailsMaster.get((params.delete[i]).toInteger())
	    	    		hazardousWasteGenDetailsInst.delete()
	    	    		}
	    	    		}
	    	    		redirect(action:popHazardActivityGenDetailsEditMaster,id:app)
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
