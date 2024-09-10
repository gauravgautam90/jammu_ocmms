import java.io.File
import java.text.DecimalFormat;
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
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.EncodeDecodeprogram;
import com.tp.pg.util.TransactionRequestBean;
import com.tp.pg.util.TransactionResponseBean;

import com.CheckSumRequestBean;
import com.CheckSumResponseBean;
import reconglobalsoap.ReconGlobal;
import java.security.Security;
import java.security.Provider;
import java.security.Security;


class IndApplicationDetailsController {
    
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

    static allowedMethods = [delete:'POST', save:'POST', update:'POST',checkTransaction:'POST',checkTestTrans:'GET']
    
    def list = {
    	 try {
    	     params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ indApplicationDetailsInstanceList: IndApplicationDetails.list( params ), indApplicationDetailsInstanceTotal: IndApplicationDetails.count() ]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	      def indApplicationDetailsInstance = IndApplicationDetails.get( params.id )
    	      if(!indApplicationDetailsInstance) {
    	            flash.message = "IndApplicationDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ indApplicationDetailsInstance : indApplicationDetailsInstance ] }
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
        def indApplicationDetailsInstance = IndApplicationDetails.get( params.id )
        if(indApplicationDetailsInstance) {
            try {
                indApplicationDetailsInstance.delete()
                flash.message = "IndApplicationDetails ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "IndApplicationDetails ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "IndApplicationDetails not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
    	 try {
    	     def indApplicationDetailsInstance = IndApplicationDetails.get( params.id )
    	     if(!indApplicationDetailsInstance) {
    	            flash.message = "IndApplicationDetails not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else {
    	            return [ indApplicationDetailsInstance : indApplicationDetailsInstance ]
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
    	     def indApplicationDetailsInstance = IndApplicationDetails.get( params.id )
    	        if(indApplicationDetailsInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(indApplicationDetailsInstance.version > version) {
    	                    
    	                    indApplicationDetailsInstance.errors.rejectValue("version", "indApplicationDetails.optimistic.locking.failure", "Another user has updated this IndApplicationDetails while you were editing.")
    	                    render(view:'edit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
    	                    return
    	                }
    	            }
    	            indApplicationDetailsInstance.properties = params
    	            if(!indApplicationDetailsInstance.hasErrors() && indApplicationDetailsInstance.save()) {
    	                flash.message = "IndApplicationDetails ${params.id} updated"
    	                redirect(action:show,id:indApplicationDetailsInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "IndApplicationDetails not found with id ${params.id}"
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
    	     def indApplicationDetailsInstance = new IndApplicationDetails()
    	        indApplicationDetailsInstance.properties = params
    	        return ['indApplicationDetailsInstance':indApplicationDetailsInstance]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	     def indApplicationDetailsInstance = new IndApplicationDetails(params)
    	        if(!indApplicationDetailsInstance.hasErrors() && indApplicationDetailsInstance.save()) {
    	            flash.message = "IndApplicationDetails ${indApplicationDetailsInstance.id} created"
    	            redirect(action:show,id:indApplicationDetailsInstance.id)
    	        }
    	        else {
    	            render(view:'create',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])
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
    
    def doEdit = {
    	 try {
    	     def indUserIns = (IndUser)(session.indUser)
    	    	def abc = IndUser.get(indUserIns.id)
    	    	def industryRegMasterInstance = abc.industryRegMaster
    	    	if(params.indAppDetId != "" && params.indAppDetId != null){
    	    		def indApplicationDetailsInstance = IndApplicationDetails.get((params.indAppDetId).toLong())
    	    		return [indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance]
    	    	}else{
    	    		return [industryRegMasterInstance:industryRegMasterInstance]
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
    
    def saveGeneral = {
    	 try {
    	     def industryRegMasterInstance = IndustryRegMaster.get((params.regMasId).toLong())
    	    	def indAppDet  = null
    	    	def totalList = new ArrayList()
    	    	if(params.indAppDetId != null && !(params.indAppDetId).equals("")){
    	    		indAppDet =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	}	
    	    	industryRegMasterInstance.properties = params
    	    	industryRegMasterInstance.save()
    	    	if(indAppDet == null){
    	    		def indApplicationDetailsInstance =	new IndApplicationDetails()
    	    		indApplicationDetailsInstance.indUser = industryRegMasterInstance
    	    		indApplicationDetailsInstance.applicationType = params.radiobutton1
    	            indApplicationDetailsInstance.applicationFor = params.consent
    	            indApplicationDetailsInstance.certificateFor = params.appFor
    	            indApplicationDetailsInstance.applicationDate = new Date()
    	    		 indApplicationDetailsInstance.actualApplicationDate = new Date()
    	    		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
    	            indApplicationDetailsInstance.completionStatus = "pending"
    	            indApplicationDetailsInstance.save()
    	            render(view:'doShow',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance])
    	            }
    	    	else{
    	    		def indApplicationDetailsInstance =	indAppDet
    	    		indApplicationDetailsInstance.indUser = IndustryRegMaster.get((params.regMasId).toLong())
    	            indApplicationDetailsInstance.applicationType = params.radiobutton1
    	            indApplicationDetailsInstance.applicationFor = params.consent
    	            indApplicationDetailsInstance.certificateFor = params.appFor
    	            indApplicationDetailsInstance.applicationDate = new Date()
    	    		 indApplicationDetailsInstance.actualApplicationDate = new Date()
    	            indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
    	            indApplicationDetailsInstance.save()
    	            def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indAppDet)
    	           def consentFeeMasterInstance = ConsentFeeMaster.findAllByApplication(indAppDet)
    	            render(view:'doShow',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance])
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
    
    def saveProducts = {
    	 try {
    	    	def industryRegMasterInstance = IndustryRegMaster.get((params.regMasId).toLong())
    	    	def indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	def indProductDetailsInstanceList = new ArrayList()
    	    	String []product = params.product
    	    	String []quantity = params.quantity
    	    	String []byProduct = params.byProduct
    	    	String []unit = params.unit
    	    	if((params.product).getClass().getName()== "java.lang.String"){
    	    		def indProductDetailsInstance = new IndProductDetails()
    	    		indProductDetailsInstance.application = indApplicationDetailsInstance
    	    		indProductDetailsInstance.product = IndProductMaster.get((params.product).toLong()) 
    	    		indProductDetailsInstance.quantity = params.quantity
    	    		indProductDetailsInstance.byProduct = IndProductMaster.get((params.byProduct).toLong()) 
    	    		indProductDetailsInstance.unit = params.unit
    	    		indProductDetailsInstance.save()
    	    		indProductDetailsInstanceList.add(indProductDetailsInstance)
    	    	}else{
    	    		for(int i=0;i<params.product.size();i++){
    	        		def indProductDetailsInstance = new IndProductDetails()
    	        		indProductDetailsInstance.application = indApplicationDetailsInstance
    	        		indProductDetailsInstance.product = IndProductMaster.get((product[i]).toLong()) 
    	        		indProductDetailsInstance.quantity = quantity[i]
    	        		indProductDetailsInstance.byProduct = IndProductMaster.get((byProduct[i]).toLong()) 
    	        		indProductDetailsInstance.unit = unit[i]
    	        		
    	        		indProductDetailsInstance.save()
    	        		indProductDetailsInstanceList.add(indProductDetailsInstance)
    	        	}
    	    	}
    	    	render(view:'doShow',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveFee={
    	 try {
    	    	def industryRegMasterInstance = IndustryRegMaster.get((params.regMasId).toLong())
    	    	def indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def consentFeeMasterInstance = new ConsentFeeMaster()
    	    	consentFeeMasterInstance.application = indApplicationDetailsInstance
    	    	consentFeeMasterInstance.noOfYears = (params.yearsApplied).toLong()
    	    	consentFeeMasterInstance.calculatedFee = (params.feeApplicable).toLong()
    	    	consentFeeMasterInstance.outstandingDueBrd=0
    	    	consentFeeMasterInstance.outstandingDueInd=0
    	    	consentFeeMasterInstance.totalApplicableFee=(params.totalApplied).toLong()
    	    	consentFeeMasterInstance.save()
    	    	String [] ddNo = params.ddNo
    	    	String [] date = params.date
    	    	String [] bankName = params.bankName
    	    	String [] branchName = params.branchName
    	    	String [] ddAmount = params.ddAmount
    	    	if((params.ddNo).getClass().getName()== "java.lang.String"){
    	    		def feeBankDetails = new FeeBankDetails()
    	    		feeBankDetails.application = indApplicationDetailsInstance
    	    		feeBankDetails.ddChequeNo = params.ddNo
    	    		feeBankDetails.date = params.date
    	    		feeBankDetails.bankName = params.bankName
    	    		feeBankDetails.branch = params.branchName
    	    		feeBankDetails.amount = (params.ddAmount).toLong()
    	    		if(feeBankDetails.save(flush:true)){
	    			}else{
	    				feeBankDetails.errors.each {
	    			      println it;  
	    			   }
	    			}
    	    	}else{
    	    		for(int i=0;i<params.ddNo.size();i++){
    	    			def feeBankDetails = new FeeBankDetails()
    	        		feeBankDetails.application = indApplicationDetailsInstance
    	        		feeBankDetails.ddChequeNo = ddNo[i]
    	        		feeBankDetails.date = date[i]
    	        		feeBankDetails.bankName = bankName[i]
    	        		feeBankDetails.branch = branchName[i]
    	        		feeBankDetails.amount = (ddAmount[i]).toLong()
    	        		if(feeBankDetails.save(flush:true)){
    	    			}else{
    	    				feeBankDetails.errors.each {
    	    			      println it;  
    	    			   }
    	    			}
    	        	}
    	    	}
    	    	render(view:'doShow',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveWater = {
    	 try {
    	    	String [] waterConMode = params.waterConMode
    	    	String [] conQuantity = params.conQuantity
    	    	String [] waterGenMode = params.waterGenMode
    	    	String [] genQuantity = params.genQuantity
    	    	String [] waterDisType = params.waterDisType
    	    	String [] maxEffGen = params.maxEffGen
    	    	String [] effRecycle = params.effRecycle
    	    	String [] effDisposed = params.effDisposed
    	    	String [] waterDisMode = params.waterDisMode
    	    	def indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	if((params.waterConMode).getClass().getName()== "java.lang.String"){
    	    		def indWaterConsumptionDetailsInstance = new IndWaterConsumptionDetails()
    	    		indWaterConsumptionDetailsInstance.consumptionMode = WaterConModeMaster.get((params.waterConMode).toLong())
    	    		indWaterConsumptionDetailsInstance.consumptionQuantity = params.conQuantity
    	    		indWaterConsumptionDetailsInstance.generationMode = WaterGenModeMaster.get((params.waterGenMode).toLong())
    	    		indWaterConsumptionDetailsInstance.generationQuantity = params.genQuantity
    	    		indWaterConsumptionDetailsInstance.application = indApplicationDetailsInstance
    	    		indWaterConsumptionDetailsInstance.save()
    	    	}else{
    	    		for(int i=0;i<params.waterConMode.size();i++){
    		    		def indWaterConsumptionDetailsInstance =new IndWaterConsumptionDetails()
    		    		indWaterConsumptionDetailsInstance.consumptionMode = WaterConModeMaster.get((waterConMode[i]).toLong())
    		    		indWaterConsumptionDetailsInstance.consumptionQuantity = conQuantity[i]
    		    		indWaterConsumptionDetailsInstance.generationMode = WaterGenModeMaster.get((waterGenMode[i]).toLong())
    		    		indWaterConsumptionDetailsInstance.generationQuantity = genQuantity[i]
    		    		indWaterConsumptionDetailsInstance.application = indApplicationDetailsInstance
    		    		indWaterConsumptionDetailsInstance.save()
    	    		}
    	    	}
    	    	if((params.waterDisType).getClass().getName()== "java.lang.String"){
    	    		def indWaterDischargeDetailsInstance = new IndWaterDischargeDetails()
    	    		indWaterDischargeDetailsInstance.dischargeType = WaterDisTypeMaster.get((params.waterDisType).toLong())
    	    		indWaterDischargeDetailsInstance.maxEffluentGen = params.maxEffGen
    	    		indWaterDischargeDetailsInstance.effluentRecycled = params.effRecycle
    	    		indWaterDischargeDetailsInstance.effluentDisposed = params.effDisposed
    	    		indWaterDischargeDetailsInstance.disposalMode = WaterDisModeMaster.get((params.waterDisMode).toLong())
    	    		indWaterConsumptionDetailsInstance.application = indApplicationDetailsInstance
    	    		indWaterDischargeDetailsInstance.save()
    	    	}else{
    	    		for(int i=0;i<params.waterDisType.size();i++){
    	    			def indWaterDischargeDetailsInstance = new IndWaterDischargeDetails()
    	        		indWaterDischargeDetailsInstance.dischargeType = WaterDisTypeMaster.get((waterDisType[i]).toLong())
    	        		indWaterDischargeDetailsInstance.maxEffluentGen = maxEffGen[i]
    	        		indWaterDischargeDetailsInstance.effluentRecycled = effRecycle[i]
    	        		indWaterDischargeDetailsInstance.effluentDisposed = effDisposed[i]
    	        		indWaterDischargeDetailsInstance.disposalMode = WaterDisModeMaster.get((waterDisMode[i]).toLong())
    	        		indWaterConsumptionDetailsInstance.application = indApplicationDetailsInstance
    	        		indWaterDischargeDetailsInstance.save()
    	    		}
    	    	}
    	    	render(view:'doShow',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveEffStandards = {
    	 try {
    	    	String [] effType = params.effType
    	    	String [] effStand = params.effStand
    	    	String [] effParameter = params.effParameter
    	    	String [] parameterStandard = params.parameterStandard
    	    	def indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	if((params.effType).getClass().getName()== "java.lang.String"){
    	    		def indEffluentStandardDetails = new IndEffluentStandardDetails()
    	    		indEffluentStandardDetails.type = EffluentTypeMaster.get((params.effType).toLong())
    	    		indEffluentStandardDetails.standard = EffluentStandardMaster.get((params.effStand).toLong())
    	    		indEffluentStandardDetails.parameter = EffluentParameterMaster.get((params.effParameter).toLong())
    	    		indEffluentStandardDetails.effParameterStandard = params.parameterStandard
    	    		indEffluentStandardDetails.application = indApplicationDetailsInstance
    	    		indEffluentStandardDetails.save()
    	    	}else{
    	    		for(int i=0;i<params.effType.size();i++){
    		    		def indEffluentStandardDetails = new IndEffluentStandardDetails()
    		    		indEffluentStandardDetails.type = EffluentTypeMaster.get((effType[i]).toLong())
    		    		indEffluentStandardDetails.standard = EffluentStandardMaster.get((effStand[i]).toLong())
    		    		indEffluentStandardDetails.parameter = EffluentParameterMaster.get((effParameter[i]).toLong())
    		    		indEffluentStandardDetails.effParameterStandard = parameterStandard[i]
    		    		indEffluentStandardDetails.application = indApplicationDetailsInstance	    		
    		    		indEffluentStandardDetails.save()
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
    
    def saveAir = {
    	 try {
    	    	def indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	String[] stackPlant = params.stackPlant
    	    	String[] sourceCapacity = params.sourceCapacity
    	    	String[] sourceUnit = params.sourceUnit
    	    	String[] stackPresPara = params.stackPresPara
    	    	String[] presStand = params.presStand
    	    	params.stackHeight
    	    	String[] stackContMesure = params.stackContMesure
    	    	String[] fuelType = params.fuelType
    	    	String[] fuelName = params.fuelName
    	    	String[] fuelQuantity = params.fuelQuantity
    	    	String[] fuelQuantityUnit = params.fuelQuantityUnit
    	    	String[] fuelCapacity = params.fuelCapacity
    	    	String[] fuelCapacityUnit = params.fuelCapacityUnit
    	    	String[] sourceFugitiveEmmision = params.sourceFugitiveEmmision
    	    	String[] fugitivePresPara = params.fugitivePresPara
    	    	String[] fugPresStand = params.fugPresStand
    	    	String[] fugContMesure = params.fugContMesure
    	    	AmbientAirQualityStandardMaster.list()
    	    	def indAirStackEmmisionDetailsInstance = new IndAirStackEmmisionDetails()
    	    	def indEmmisionCntrlDetailsInstance = new IndEmmisionCntrlDetails()
    	    	def indAirFuelDetailsInstance = new IndAirFuelDetails()
    	    	def indAirFugitiveDetailsInstance = new IndAirFugitiveDetails()
    	    	def indEmmisionCntrlDetailsInstance2 = new IndEmmisionCntrlDetails()
    	    	if((params.stackPlant).getClass().getName()== "java.lang.String"){
    	    		indAirStackEmmisionDetailsInstance.stackToPlant = params.stackPlant
    	    		indAirStackEmmisionDetailsInstance.sourceCapacity = params.sourceCapacity
    	    		indAirStackEmmisionDetailsInstance.sourceUnit = AirEmmisionUnitMaster.get((params.sourceUnit).toLong())
    	    		indAirStackEmmisionDetailsInstance.parameter = AirEmmisionParameter.get((params.stackPresPara).toLong())
    	    		indAirStackEmmisionDetailsInstance.prescribedStandards = params.presStand
    	    		indAirStackEmmisionDetailsInstance.height = params.stackHeight
    	    		indAirStackEmmisionDetailsInstance.application = indApplicationDetailsInstance
    	    		indAirStackEmmisionDetailsInstance.save()
    	    	}
    	    	else{
    		    		for(int i=0;i<params.stackPlant.size();i++){
    			    		indAirStackEmmisionDetailsInstance.stackToPlant = params.stackPlant[i]
    			    		indAirStackEmmisionDetailsInstance.sourceCapacity = params.sourceCapacity[i]
    			    		indAirStackEmmisionDetailsInstance.sourceUnit = AirEmmisionUnitMaster.get((params.sourceUnit[i]).toLong())
    			    		indAirStackEmmisionDetailsInstance.parameter = AirEmmisionParameter.get((params.stackPresPara[i]).toLong())
    			    		indAirStackEmmisionDetailsInstance.prescribedStandards = params.presStand[i]
    			    		indAirStackEmmisionDetailsInstance.height = params.stackHeight
    			    		indAirStackEmmisionDetailsInstance.application = indApplicationDetailsInstance
    			    		indAirStackEmmisionDetailsInstance.save()
    			    	}
    	    		}
    	    	if((params.stackContMesure).getClass().getName()== "java.lang.String"){
    	    		def airEmmisionControlMeasuresInstance = AirEmmisionControlMeasures.get((params.stackContMesure).toLong())
    	    		indEmmisionCntrlDetailsInstance.cntrlMeasures = airEmmisionControlMeasuresInstance
    	    		indEmmisionCntrlDetailsInstance.type = airEmmisionControlMeasuresInstance.type
    	    		indEmmisionCntrlDetailsInstance.application = indApplicationDetailsInstance
    	    		indEmmisionCntrlDetailsInstance.save()
    	    	}
    	    	else{
    	    		for(int i=0;i<params.stackContMesure.size();i++){
    	    			def airEmmisionControlMeasuresInstance = AirEmmisionControlMeasures.get((params.stackContMesure[i]).toLong())
    	        		indEmmisionCntrlDetailsInstance.cntrlMeasures = airEmmisionControlMeasuresInstance
    	        		indEmmisionCntrlDetailsInstance.type = airEmmisionControlMeasuresInstance.type
    	        		indEmmisionCntrlDetailsInstance.application = indApplicationDetailsInstance
    	        		indEmmisionCntrlDetailsInstance.save()
    	    		}
    	    	}
    	    	if((params.fuelType).getClass().getName()== "java.lang.String"){
    	    		indAirFuelDetailsInstance.fuel = AirEmmisionFuelMaster.get((params.fuelName).toLong())
    	    		indAirFuelDetailsInstance.fuelType = AirEmmisionFuelTypeMaster.get((params.fuelType).toLong())
    	    		indAirFuelDetailsInstance.fuelQuantity = params.fuelQuantity
    	    		indAirFuelDetailsInstance.quantUnit = AirEmmisionUnitMaster.get((params.fuelQuantityUnit).toLong())
    	    		indAirFuelDetailsInstance.capacity = params.fuelCapacity
    	    		indAirFuelDetailsInstance.capacityUnit = AirEmmisionUnitMaster.get((params.fuelCapacityUnit).toLong())
    	    		indAirFuelDetailsInstance.application = indApplicationDetailsInstance
    	    		indAirFuelDetailsInstance.save()
    	    	}else{
    	    		for(int i=0;i<params.fuelType.size();i++){
    	    			indAirFuelDetailsInstance.fuel = AirEmmisionFuelMaster.get((params.fuelName[i]).toLong())
    	        		indAirFuelDetailsInstance.fuelType = AirEmmisionFuelTypeMaster.get((params.fuelType[i]).toLong())
    	        		indAirFuelDetailsInstance.fuelQuantity = params.fuelQuantity[i]
    	        		indAirFuelDetailsInstance.quantUnit = AirEmmisionUnitMaster.get((params.fuelQuantityUnit[i]).toLong())
    	        		indAirFuelDetailsInstance.capacity = params.fuelCapacity[i]
    	        		indAirFuelDetailsInstance.capacityUnit = AirEmmisionUnitMaster.get((params.fuelCapacityUnit[i]).toLong())
    	        		indAirFuelDetailsInstance.application = indApplicationDetailsInstance
    	        		indAirFuelDetailsInstance.save()
    	    		}
    	    	}
    	    	if((params.sourceFugitiveEmmision).getClass().getName()== "java.lang.String"){
    	    		indAirFugitiveDetailsInstance.sourceFugEmmision = params.sourceFugitiveEmmision
    	    		indAirFugitiveDetailsInstance.parameter = AirEmmisionParameter.get((params.fugitivePresPara).toLong())
    	    		indAirFugitiveDetailsInstance.prescribedStand = params.fugPresStand
    	    		indAirFugitiveDetailsInstance.application = indApplicationDetailsInstance
    	    		indAirFugitiveDetailsInstance.save()
    	    	}else{
    	    		for(int i=0;i<params.sourceFugitiveEmmision.size();i++){
    	    			indAirFugitiveDetailsInstance.sourceFugEmmision = params.sourceFugitiveEmmision[i]
    	        		indAirFugitiveDetailsInstance.parameter = AirEmmisionParameter.get((params.fugitivePresPara[i]).toLong())
    	        		indAirFugitiveDetailsInstance.prescribedStand = params.fugPresStand[i]
    	        		indAirFugitiveDetailsInstance.application = indApplicationDetailsInstance
    	        		indAirFugitiveDetailsInstance.save()
    	    		}
    	    	}
    	    	if((params.fugContMesure).getClass().getName()== "java.lang.String"){
    	    		def airEmmisionControlMeasuresInstance = AirEmmisionControlMeasures.get((params.fugContMesure).toLong())
    	    		indEmmisionCntrlDetailsInstance2.cntrlMeasures = airEmmisionControlMeasuresInstance
    	    		indEmmisionCntrlDetailsInstance2.type = airEmmisionControlMeasuresInstance.type
    	    		indEmmisionCntrlDetailsInstance2.application = indApplicationDetailsInstance
    	    		indEmmisionCntrlDetailsInstance2.save()
    	    	}else{
    	    		for(int i=0;i<params.fugContMesure.size();i++){
    	    			def airEmmisionControlMeasuresInstance = AirEmmisionControlMeasures.get((params.fugContMesure[i]).toLong())
    	        		indEmmisionCntrlDetailsInstance2.cntrlMeasures = airEmmisionControlMeasuresInstance
    	        		indEmmisionCntrlDetailsInstance2.type = airEmmisionControlMeasuresInstance.type
    	        		indEmmisionCntrlDetailsInstance2.application = indApplicationDetailsInstance
    	        		indEmmisionCntrlDetailsInstance2.save()
    	    		}
    	    	}
    	    	def ambientAirList = AmbientAirQualityStandardMaster.list()
    	    	for(int i=0;i<ambientAirList.size();i++){
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
    
    def saveCheckList = {
    	 try {
    	    	def indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	String appId = (indApplicationDetailsInstance.id).toString()
    	    	String strDirectoy = appId;
    	    	boolean success = (new File(strDirectoy)).mkdir();
    	        if (success) {
    	         } 
    	    	def f = request.getFile('upfile')
    	    	def projectReport = request.getFile('ProjectReport')
    	    	
    	    	if(f){
    	    		if(!f.empty) {
    	        		f.transferTo( new File(appId +'/Land_Allotment_Letter') )
    	        	}
    	    	}
    	    	if(projectReport){
    	    		if(!projectReport.empty) {
    	            	projectReport.transferTo( new File(appId+'/Project_Report') )
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
    
    
    def downLoadingCertificate1={
    	 try {
    		 println("IN downLoadingCertificate1 "+params)
    	    //	def appId=IndApplicationDetails.get((params.appliLoc).toLong())
    	    	def appId=IndApplicationDetails.get((params.id).toLong())
    	    	println("appId "+appId)
    			def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='ConsentOrder' order by afr.dateCreated desc",[appId],[max:1])
    		println("fileDownLoad "+fileDownLoad)
    			def fileSingle=fileDownLoad.get(0);
    		 println("fileSingle "+fileSingle)
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
    def viewAutoRenewConsentWater = {
    	println("HELLOOO"+params)
        try {
        def applicationFileInstance
    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
        applicationFileInstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.typeOfFile='Certificate' and abc.indApplication=? order by id desc",[application])
    	println("application=="+application)
        println("applicationFileInstance=="+applicationFileInstance)
        if(applicationFileInstance){
		response.setContentType( "application-xdownload")
		response.setHeader("Content-Disposition", "attachment;filename=${applicationFileInstance.name}")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileInstance.data )
		}else{
			// Added by DEEPAK
		AutoRenewalFormPdf autoRenewPdf1=new AutoRenewalFormPdf();   // by DEEPAK
			     def sessValue=(session.indUser).toString()
		  	      println("TESTINT AUTORENEEW")
	 	       	  println("sessValue------"+sessValue)
	 	       	   println("application-----"+application)
 	       autoRenewPdf1.pdfAutoRenew(sessValue,(params.appliLoc).toLong()) 
 	     
		flash.message = "Document not Attached...!!";
		redirect(action:viewAutoRenewConsentWater,params:[appliLoc:params.appliLoc])
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

    def saveConsent = {
   	 try {
		 
		 	println("saveConsent---params---"+params)
		 			 	println("consent---params---"+params.consent)
	    	def check1=true
	    	def indUserIns = (IndUser)(session.indUser)
	    	def abc = IndUser.get(indUserIns.id)
	    	def industryRegMasterInstance = abc.industryRegMaster
	    	def isApplicable = false
	    	if(params.radiobutton1 == "CTE"){
	    	if(params.consent == "air" || params.consent == "water" || params.consent == "both"|| 
	    			params.consent == "stonecrusher"|| params.consent == "dgset"|| params.consent == "brickkilns"|| params.consent == "hotel" ||
	    			params.consent == "hotmixplants" || params.consent == "stonecrusher and hotmixplants"){
	    		if(params.appFor == "new" || params.appFor == "Modern" || params.appFor == "expan" || params.appFor == "reNew" || params.appFor == "autoReNew"){
	    		 isApplicable = true
	    	}
	    	}
	    	}
	    	else if(params.radiobutton1 == "CTO"){
	        	if(params.consent == "air" || params.consent == "water" || params.consent == "both"|| 
	        			params.consent == "stonecrusher"|| params.consent == "dgset"|| params.consent == "brickkilns"|| params.consent == "hotel" || 
	        				params.consent == "hotmixplants" || params.consent == "stonecrusher and hotmixplants"){
	        		if(params.appFor == "new" || params.appFor == "Modern" || params.appFor == "expan" || params.appFor == "reNew"){
	        		 isApplicable = true
	        	}
	        	}
	        	}
		 	
//		 	=====for autoRenew application by Dheeraj Tiwari ==start
	    	if(params.appFor == "autoReNew" && params.radiobutton1 == "CTO"){
	    		 //flash.message="Please read Terms and condition carefully"	
	    	    
	    		 def catVal = industryRegMasterInstance.category.name
	    		 println("catVal-------"+catVal)
	    		 
	    		 if(catVal!="GREEN")
	    		 {
	    			 flash.message="Auto Renewal can be applied only by Industries of Green category." 
		  		  			redirect(action:applyConsent)
		  		  			return 
	    			 
	    		 }
	    		 
	    		 if(params.hazardeousType=="HWM")
	    		 {
	    			 flash.message="Auto Renewal can be applied only by Industries of NON-HWM ." 
		  		  			redirect(action:applyConsent)
		  		  			return 
	    			 
	    		 }
	    		 
	    			println("industryRegMasterInstance===saveConsent=="+industryRegMasterInstance)
	    			
	    		 def appCheck = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO'",[industryRegMasterInstance])
	    		println("appCheck-------application---pending====="+appCheck)
	    		 if(!appCheck)
	    		 {
	    			 flash.message="You can not apply for Auto renewal as there is no CTO application approved on OCMMS" 
		  		  			redirect(action:applyConsent)
		  		  			return 
	    			 
	    		 }
	    		 
	    		 
	    		 render(view:'autoRenewApply',model:[industryRegMasterInstance:industryRegMasterInstance,consentFor:params.consent,consentType:params.radiobutton1])
	    	     return
	          }
	    	if(params.appFor == "autoReNew" && params.radiobutton1 == "CTE"){
	    		
	    		 def catVal = industryRegMasterInstance.category.name
	    		 println("catVal-2------"+catVal)
	    		 
	    		 if(catVal!="GREEN")
	    		 {
	    			 flash.message="Auto Renewal can be applied only by Industries of Green category." 
		  		  			redirect(action:applyConsent)
		  		  			return 
	    			 
	    		 }
	    		 
	    		 def appCheck = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO'",[industryRegMasterInstance])
	    		  if(!appCheck)
	    		 {
	    			 flash.message="You can not apply for Auto renewal as there is no CTO application approved on OCMMS" 
		  		  			redirect(action:applyConsent)
		  		  			return 
	    			 
	    		 }
	    		 
	   		 //flash.message="Please read Terms and condition carefully"	
	   	     render(view:'autoRenewApply',model:[industryRegMasterInstance:industryRegMasterInstance,consentFor:params.consent,consentType:params.radiobutton1])
	   	     return
	         }
	    	if(isApplicable){
	    		def ecDetInst = EcCrzDetails.findByLicenceNo(industryRegMasterInstance.indRegNum)
	        	def ec = false
	        	if(ecDetInst){
	        		ec = true
	        		def ecInst =  ecDetInst
	        		ecInst.ecNo = params.ec_crz
	        		ecInst.issueDate = params.date
	        		if(ecInst.save(flush:true)){
	    			}else{
	    				ecInst.errors.each {
	    			      println it;  
	    			   }
	    			}
	        	}
	    		def indApplicationDetailsInstance =	new IndApplicationDetails()
	    		indApplicationDetailsInstance.indUser = industryRegMasterInstance
	    		indApplicationDetailsInstance.applicationType = params.radiobutton1
	    		if(params.hazardeousType){
	            	indApplicationDetailsInstance.hazardeousType = params.hazardeousType 
	                }else{
	                	indApplicationDetailsInstance.hazardeousType ="";
	                }
	            indApplicationDetailsInstance.applicationFor = params.consent
	            indApplicationDetailsInstance.certificateFor = params.appFor
	            indApplicationDetailsInstance.applicationDate = new Date()
	    		indApplicationDetailsInstance.actualApplicationDate = new Date()
	    		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
	            indApplicationDetailsInstance.completionStatus = "pending"
	            indApplicationDetailsInstance.clarification = false;
	        	indApplicationDetailsInstance.inspection = false;
	        	indApplicationDetailsInstance.annualProdCap = "0"
	        	indApplicationDetailsInstance.noOfStack = "0"
	            if(indApplicationDetailsInstance.save()){
	            }else{
	            	if(indApplicationDetailsInstance.hasErrors()){
	              	   indUserInstance.errors.allErrors.each {
	              		   println it;
	                  }
	                 }
	            }
	  /*      	if(params.appFor=="autoReNew"){
	        		 def catVal = industryRegMasterInstance.category.name
	        		 println("catVal-------"+catVal)
	        		 
	        		 if(catVal!="GREEN")
	        		 {
	        			 flash.message="Auto Renewal can be applied only by Industries of Green category." 
	    	  		  			redirect(action:applyConsent)
	    	  		  			return 
	        			 
	        		 }
	        		flash.message="Please read Terms and condition carefully";
	        		render(view:'autoRenewApply',model:[industryRegMasterInstance:industryRegMasterInstance,consentFor:params.appFor])
	        	}*/
	        	//else{
	            render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,appFor:params.consent])
	        //	}
	        	}else{
	    		redirect(action:applyConsent)
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
    
    def saveNew = {
    	 try {
    		 println("-----SaveNew --jk-----Called")
    	    	def testVal = params.testVal
    			FormPdf form=new FormPdf()
    	    	def status = params.appStatus
    	    	def industryRegMasterInstance = IndustryRegMaster.get((params.regMasId).toLong())
    	    	def indAppDet = null
    	    	if(params.indAppDetId != null && !(params.indAppDetId).equals("")){
    	    	indAppDet = IndApplicationDetails.get((params.indAppDetId).toLong())
    	    	}
    	    	industryRegMasterInstance.properties = params
    	    	industryRegMasterInstance.save()
    	    	def indApplicationDetailsInstance = indAppDet
    	    	def check=false
    	    	
    	    	if(status.equals("completed"))
    	    	{

    				println("status completed--111---")
    				

    				  //def docListCheck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster dc where dc.applicationTypeMaster.consentType=? and dc.consentFor = ? and dc.isMandatory='Yes'",[indApplicationDetailsInstance.applicationType,indApplicationDetailsInstance.certificateFor])
    	            /*  def docListCheck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster dc where dc.applicationFor=? and dc.consentFor = ? and dc.isMandatory='Yes' ",[indApplicationDetailsInstance.applicationType,indApplicationDetailsInstance.certificateFor])
    				  println("-*Abhiiii--*-docListCheck*-*"+docListCheck)
    				if (indApplicationDetailsInstance && docListCheck) {
    					for (int i = 0; i < docListCheck.size(); i++) {
    							if (((docListCheck.get(i)).isMandatory).equalsIgnoreCase("Yes")) {
    	            def isOrNot = ApplicationDocuments.find("from ApplicationDocuments abc where abc.level=? and abc.indApplication=?", [(docListCheck.get(i)).document, indApplicationDetailsInstance])
    	            if (!isOrNot) {
    	                flash.message = "Please Upload Mandatory Documents"
    	                    render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,renewDateFrom:renewDateFrom,renewDateTo:renewDateTo])
    	                return
    	            		   }
    	        			 }
    	    				}
    					  }*/
    				
    	    		
    	    		
    	    	def waterUsesMasterInstance = WaterUsageDetailMaster.findAll("from WaterUsageDetailMaster")
    	    	def useMaster = waterUsesMasterInstance.usage
    	    	def waterUsesInstance = WaterUsageDetails.findAll("from WaterUsageDetails use where use.application=?",[indAppDet])
    	    	def use = waterUsesInstance.description
    	    	def waterConsumptionInstance1 = WaterConsumptionDetail.findAll("from WaterConsumptionDetail use where use.application=?",[indAppDet])
    	    	def use1 = waterConsumptionInstance1.waterConsumptionType
    	    	def waterWasteDischargeInstance = WaterWasteDischargeMaster.findAll("from WaterWasteDischargeMaster")
    	    	def dischargeMaster = waterWasteDischargeInstance.usage
    	    	def wasteDischargeInstance = WaterWasteDischarge.findAll("from WaterWasteDischarge use where use.application=?",[indAppDet])
    	    	def discharge = wasteDischargeInstance.description
    	    	def wasteDischargeInstancegen = WaterWasteGenerationDetails.findAll("from WaterWasteGenerationDetails use where use.application=?",[indAppDet])
    	    	def waterConsumptionInstance = HotelWaterConsumptionMaster.findAll("from HotelWaterConsumptionMaster")
    	    	def consumptionMaster = waterConsumptionInstance.name
    	    	def waterSourceInstance = WaterSourceMaster.findAll("from WaterSourceMaster")
    	    	def sourceMaster = waterSourceInstance.sourceName
    	    	def consumptionInstance = HotelWaterConsumptionDetail.findAll("from HotelWaterConsumptionDetail use where use.application=?",[indAppDet])
    	    	def consumption = consumptionInstance.type.name
    	    	def sourceInstance = StoneCrusherWaterReq.findAll("from StoneCrusherWaterReq use where use.application=?",[indAppDet])
    	    	def source = sourceInstance.sourceOfWaterSupply
    	    	def nocAuthorityMasterInstance = NocAuthorityMaster.findAll("from NocAuthorityMaster")
    	    	def nocAuthorityMaster = nocAuthorityMasterInstance.authority
    	    	def nocAuthorityInstance = NocAuthorityDetails.findAll("from NocAuthorityDetails use where use.application=?",[indAppDet])
    	    	def nocAuthority = nocAuthorityInstance.authorityDetails
    	    	def stoneCrusherControlMasterInstance = StoneCrusherControlDevicesMaster.findAll("from StoneCrusherControlDevicesMaster")
    	    	def stoneCrusherControlMaster = stoneCrusherControlMasterInstance.deviceName
    	    	def stoneCrusherControlInstance = StoneCrusherControlDevices.findAll("from StoneCrusherControlDevices use where use.application=?",[indAppDet])
    	    	def stoneCrusherControl = stoneCrusherControlInstance.device.deviceName
    	    	def stoneCrusherParameterMasterInstance = StoneCrusherParameterMaster.findAll("from StoneCrusherParameterMaster")
    	    	def stoneCrusherMaster = stoneCrusherParameterMasterInstance.parameterName
    	    	def stoneCrusherSittingCriteriaInstance = StoneCrusherSittingCriteria.findAll("from StoneCrusherSittingCriteria use where use.application=?",[indAppDet])
    	    	def sittingCriteria = stoneCrusherSittingCriteriaInstance.parameter.parameterName
    	    	def brickilnInstance = BrickSittingCriteriaDetails.findAll("from BrickSittingCriteriaDetails use where use.application=?",[indAppDet])
    	    	def brickiln = brickilnInstance.parameter.parameterName
    	    	String appFor = indApplicationDetailsInstance.applicationFor
    	    	String category = indApplicationDetailsInstance.indUser.category
    	    	}
    	    	if(check==false)
    	    	{
    	    		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
    	    	def feeBankDetailsInstanceList = new ArrayList()
    	    	def consentFeeMasterInstance = new ConsentFeeMaster()
    	    		consentFeeMasterInstance.application = indApplicationDetailsInstance
    	    	if(params.yearsApplied1 != ""){
    	    	    def abc=params.yearsApplied1;
    	    		if(abc)
    	    	    {
    	    			abc=abc.toLong();
    	    	    }else
    	    	    {
    	    	    	abc=0.0;
    	    	    }
    	    		consentFeeMasterInstance.noOfYearsadditionalYears = abc;
    	    	}else{
    	    	consentFeeMasterInstance.noOfYearsadditionalYears = 0
    	    	}
    	    		if(params.yearsApplied != "" && indApplicationDetailsInstance.certificateFor=="new"){
    	        	consentFeeMasterInstance.noOfYears = 1
    	        	}else{
    	        	consentFeeMasterInstance.noOfYears = 0
    	        	}
    	    	if(params.feeApplicable1 != "" && indApplicationDetailsInstance.certificateFor=="new"){
    	    	
    	    		
    	    		def abcA=params.feeApplicable1;
    	    		if(abcA)
    	    	    {
    	    			abcA=abcA.toLong();
    	    	    }else
    	    	    {
    	    	    	abcA=0.0;
    	    	    }
    	    		
    	    		
    	    	consentFeeMasterInstance.calculatedFee = abcA
    	    	consentFeeMasterInstance.totalApplicableFee=abcA
    	    	}else{
    	    	consentFeeMasterInstance.calculatedFee = 0
    	    	consentFeeMasterInstance.totalApplicableFee = 0
    	    	}
    	    	if(params.feeApplicable != "" && indApplicationDetailsInstance.certificateFor=="new" ){
    	    	
    	    		def abcB=params.feeApplicable;
    	    		if(abcB)
    	    	    {
    	    			abcB=abcB.toLong();
    	    	    }else
    	    	    {
    	    	    	abcB=0.0;
    	    	    }
    	    		consentFeeMasterInstance. outstandingDueInd=abcB;
    	    	}else{
    	    		consentFeeMasterInstance.outstandingDueInd=0
    	    	}
    	    	if(params.feeApplicable2 != ""){
    	    		def abcBC=params.feeApplicable2;
    	    		if(abcBC)
    	    	    {
    	    			abcBC=abcBC.toLong();
    	    	    }else
    	    	    {
    	    	    	abcBC=0.0;
    	    	    }
    	    		consentFeeMasterInstance.outstandingDueBrd =abcBC;
    	    	}else{
    	    		consentFeeMasterInstance.outstandingDueBrd=0
    	    	}
    	    	consentFeeMasterInstance.save()
    	    	def fees = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
    	    	String applicationFor = indApplicationDetailsInstance.applicationFor	
   	    	 /////////////////////////////////For Product Details Mandatory Table/////////////////////////////////////  
   	    	 if((applicationFor.equals("stonecrusher") && status.equals("completed")) || 
   	    	    	 (applicationFor.equals("both") && status.equals("completed")) ||
   	    	    	 (applicationFor.equals("hotmixplants") && status.equals("completed")) ||
   	    	    	 (applicationFor.equals("stonecrusher and hotmixplants") && status.equals("completed")) ||
   	    	    	 (applicationFor.equals("brickkilns") && status.equals("completed"))){
   	    	def ProdDetails=IndProductDetails.find("from IndProductDetails abc where abc.application=?",[indApplicationDetailsInstance])
   	    	if(ProdDetails==null && status.equals("completed"))
   	    	{
   	    	flash.message="Please Enter Product Details"
   	    	render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,consentFeeMasterInstance:consentFeeMasterInstance])
   	    	return;
   	    	}}
//////////////////////////////For Stone Crusher Mandatory Tables///////////////////////////////
			
   	    	println("applicationFor 11111111111111111"+applicationFor)
   	    	println("status 11111111111111111"+status)
   	    	if(applicationFor.equals("stonecrusher") && status.equals("completed") ||
   	    			applicationFor.equals("hotmixplants") && status.equals("completed") ||
   	    			applicationFor.equals("stonecrusher and hotmixplants") && status.equals("completed")){
   	    		println("In If")
   	    	def waterCons=WaterConsumptionDetail.find("from WaterConsumptionDetail abc where abc.application=?",[indApplicationDetailsInstance])
   	    	if(waterCons==null && status.equals("completed")){
			    	flash.message="Please Enter Water Consumption Details"
		    	    render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,consentFeeMasterInstance:consentFeeMasterInstance])
		    	return;
   	    	}
				def waterSource=StoneCrusherWaterReq.find("from StoneCrusherWaterReq abc where abc.application=?",[indApplicationDetailsInstance])
		    	if(waterSource==null && status.equals("completed")){
		    		flash.message="Please Enter Water Source Details"
	    	    	render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,consentFeeMasterInstance:consentFeeMasterInstance])
	    	    return;
		    	}
		    	def stoneCrusherPollDevice=StoneCrusherControlDevices.find("from StoneCrusherControlDevices abc where abc.application=?",[indApplicationDetailsInstance])
		    	if(stoneCrusherPollDevice==null && status.equals("completed")){
		    		flash.message="Please Enter Stone Crusher Pollution Control Devices Details"
	    	    	render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,consentFeeMasterInstance:consentFeeMasterInstance])
	    	    return;
		    	}
		    	}
///////////////////////////////////////////end here/////////////////////////////////////////////////////////	

   	 	//    Documnets mandetory code added by Deepak Start 
	  		
  			def dcCkeck
		ArrayList strList = new ArrayList()

		    println("-*Deepak--*-indApplicationDetailsInstance.applicationType*-*"+indApplicationDetailsInstance.applicationType)
		     println("-*Deepak--*-indApplicationDetailsInstance.certificateFor*-*"+indApplicationDetailsInstance.certificateFor)
    		  //def docListCheck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster dc where dc.applicationTypeMaster.consentType=? and dc.consentFor = ? and dc.isMandatory='Yes'",[indApplicationDetailsInstance.applicationType,indApplicationDetailsInstance.certificateFor])
             def docList 
		     if(indApplicationDetailsInstance.applicationType=="CTO" && applicationFor=="both"){

	    			if(indApplicationDetailsInstance.certificateFor=="new"){
	    				
	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Fresh' and consentFor='new'")
	    			
	    			}else if(indApplicationDetailsInstance.certificateFor=="reNew"){
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Renew' and consentFor='new'")
	    			}else{
	    				 
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Expansion' and consentFor='new'")
	    			}
	    			
	    		}else if(indApplicationDetailsInstance.applicationType=="CTE" && applicationFor=="both"){
	    			if(indApplicationDetailsInstance.certificateFor=="new"){
	    				 
	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor='new'")
	    			
	    			}else if(indApplicationDetailsInstance.certificateFor=="reNew"){
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Renew' and consentFor='new'")
	    			}else{
	    				
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Expansion' and consentFor='new'")
	    			}
	    			}else{
	    			if(indApplicationDetailsInstance.applicationType=="CTE"){

		    			if(indApplicationDetailsInstance.certificateFor=="new"){
		    				
		    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor=? ",[applicationFor])
		    			
		    			}else if(indApplicationDetailsInstance.certificateFor=="reNew"){
		    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Renew' and consentFor=? ",[applicationFor])
		    			}else{
		    				
		    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Expansion' and consentFor=? ",[applicationFor])
		    			}
		    			
	    				
	    			//docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTE Fresh','CTE Renew''CTE Expansion''Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and consentFor=? ",[appfor])
	    			}else{

		    			if(indApplicationDetailsInstance.certificateFor=="new"){
		    				
		    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Fresh' and consentFor=? ",[applicationFor])
		    			
		    			}else if(indApplicationDetailsInstance.certificateFor=="reNew"){
		    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Renew' and  consentFor=? ",[applicationFor])
		    			}else{
		    				
		    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Expansion' and  consentFor=? ",[applicationFor])
		    			}        	    			
		    		
	    				//docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTO','Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and  consentFor=? ",[appfor])
		    		}
	    			} 
	   		
	   		  
	   		//  def docListCheck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster dc where dc.applicationFor=? and dc.consentFor = ? and dc.isMandatory='Yes' ",[indApplicationDetailsInstance.applicationType,indApplicationDetailsInstance.certificateFor])
			//  println("-*Deepak--*-docList*-*"+docList)
			   println("-*Deepak--*-indApplicationDetailsInstance*-*"+indApplicationDetailsInstance)
			if (indApplicationDetailsInstance && docList) {
				for (int i = 0; i < docList.size(); i++) {
						if (((docList.get(i)).isMandatory).equalsIgnoreCase("Yes")) {
							 println("-*Deepak--*-docList*-*"+docList.get(i).document)
            def isOrNot = ApplicationDocuments.find("from ApplicationDocuments abc where abc.level=? and abc.indApplication=?", [(docList.get(i)).document, indApplicationDetailsInstance])
            if (!isOrNot) {
                flash.message = "Please Upload Mandatory Documents"
                	render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,consentFeeMasterInstance:consentFeeMasterInstance])
                //  render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,renewDateFrom:renewDateFrom,renewDateTo:renewDateTo])
                return
            		   }
        			 }
    				}
				  }
    	
//		    Documnets mandetory code added by Deepak ends 
    	    		
    	    	
    	    		if(testVal=="true"){
    	    			def delPDFFormAir = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='FormAir'",[indApplicationDetailsInstance])  
    	         		def delPDFFormWater = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='FormWater'",[indApplicationDetailsInstance])  
    	    			if(delPDFFormAir)
    	    			{
    	    				delPDFFormAir.delete();
    	    			}
    	    			if(delPDFFormWater)
    	    			{
    	    				delPDFFormWater.delete();
    	    			}
    	    		}	
    	    		/*if(status.equals("completed")){
    	    	indApplicationDetailsInstance.completionStatus = "completed"
    	    	}*/
    	    	indApplicationDetailsInstance.save()
    	    	
    	    	def fee = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
    	    	if(fee)
    	    	{
    	    		fee.delete()
    	    	}
    	    	def indProductDetailsInstanceList = new ArrayList()
    	    	def feeBankDetList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indWaterConsumptionDetailsInstanceList = new ArrayList()
    	    	def indWaterDischargeDetailsInstanceList = new ArrayList()
    	    	def indEffluentStandardDetailsInstanceList = new ArrayList()
    	    	def indAirStackEmmisionDetailsInstanceList = new ArrayList()
    	    	def indEmmisionCntrlDetailsInstanceList = new ArrayList()
    	    	def indAirFuelDetailsInstanceList = new ArrayList()
    	    	def indAirFugitiveDetailsInstanceList = new ArrayList()
    	    	def indEmmisionCntrlDetailsInstanceList2 = new ArrayList()
    	    	String apliId = (indApplicationDetailsInstance.id).toString()
    	    	def sessValue=(session.indUser).toString()
    	    	def formView
    	    	if(status.equals("completed")){
    	    		println("in completed")
    	    	if(indApplicationDetailsInstance.applicationFor=="air")
    	    	{
    	    		println("in air")
    	    		form.formAir(indApplicationDetailsInstance.id,sessValue)
    	    	formView="air"
    	    	}
    	    	else
    	    	{
    	    		println("in water")
    	    	if(indApplicationDetailsInstance.applicationFor=="water")
    	    	{
    	    	form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
    	    	formView="water"
    	    	}
    	    	else
    	    	{
    	    		println("in else case--------"+indApplicationDetailsInstance.applicationFor)
    	    	form.formAir(indApplicationDetailsInstance.id,sessValue)
    	    	form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
    	    	formView="both"
    	    	}
    	    	}
    	    	//def a
    	    	
    	    	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def totalfee = 0.0
    	    	for(int i=0;i<feeDetailsList.size();i++)
    	    	{
    	    		totalfee = totalfee + feeDetailsList.get(i).amount
    	    	}
    	    	println("testVal--------"+testVal)
    	   	 if(testVal=="true"){
     			 def a = new GetData((indApplicationDetailsInstance.id).toLong())
     		     	a.routeAppForAppReturn()
 		    	//a.routeApp(testVal)
 		    	def applicationProcessingDetails = ApplicationProcessingDetails.find("from ApplicationProcessingDetails indPower where indPower.application.id=? order by indPower.id desc",[(indApplicationDetailsInstance.id).toLong()])
 		    	if(applicationProcessingDetails){
     				applicationProcessingDetails.fileNote = params.scrutinyReply
     			//	applicationProcessingDetails.save()
     				if(!applicationProcessingDetails.hasErrors() && applicationProcessingDetails.save()) {
					flash.message = "Data saved"
					println("data saved of scrutiny reply")
				}else {
					println("scrutni reply not saved")
					if(applicationProcessingDetails.hasErrors()){
						applicationProcessingDetails.errors.allErrors.each {
							println it
						}
					}
				}
     				
     			}else{}
 		    	
 		    	 formView = indApplicationDetailsInstance.applicationFor
 	      	    	 updateAllSummaryReport(indApplicationDetailsInstance.toString());
     			 
             		 render(view:'confirmationSubmit',model:[testVal:testVal,formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2])
   
     		 } else{        		 
        		def a = new GetData((indApplicationDetailsInstance.id).toLong())
 		    	a.routeApp()
 		    	def applicationProcessingDetails = ApplicationProcessingDetails.find("from ApplicationProcessingDetails indPower where indPower.application.id=? order by indPower.id desc",[(indApplicationDetailsInstance.id).toLong()])
     			println("applicationProcessingDetails:"+applicationProcessingDetails)
 		    	if(applicationProcessingDetails){
     				applicationProcessingDetails.fileNote = params.scrutinyReply
     				//applicationProcessingDetails.save()
     				if(!applicationProcessingDetails.hasErrors() && applicationProcessingDetails.save()) {
					flash.message = "Data save successfully"
					println("scrutiny reply blaablal saved")
				}else {
					println("scrutiny reply not saved yet")
					if(applicationProcessingDetails.hasErrors()){
						applicationProcessingDetails.errors.allErrors.each {
							println it
						}
					}
				}
     			}else{
     				
     			}       		
        		
 		    	      formView = indApplicationDetailsInstance.applicationFor
 		    	
 		    	
 		//       	     updateAllSummaryReport(indApplicationDetailsInstance.toString());
             		 render(view:'confirmationSubmit',model:[testVal:testVal,formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2])
   
     		 
     		 }
    	    // render(view:'Payment',model:[testVal:testVal,feesPaid:totalfee,formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2])
    	 	}else{
    	    	def listDoc= new ArrayList()
    	    	def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id desc",[indApplicationDetailsInstance])
    	    	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
    	    	def boolCheck=false
    	    	if(listDoc.size()==0){
    	    	listDoc.add(applicationDocumentInstance.get(ig))
    	    	}
    	    	for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	    	if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
    	    	boolCheck=true
    	    	}
    	    	}
    	    	if(boolCheck==false){
    	    	listDoc.add(applicationDocumentInstance.get(ig))
    	    	}
    	    	}
    	    	if((indApplicationDetailsInstance.cafUniqueNo!=null) && (indApplicationDetailsInstance.cafUniqueNo!="")){
        	    	Response responsePush=new Response();
        	    	String consentAppNo=indApplicationDetailsInstance.id.toString();
        	    	String cafNo=indApplicationDetailsInstance.cafUniqueNo
        	    	String applicationType=indApplicationDetailsInstance.applicationType;
        	    	String applicationFor1=indApplicationDetailsInstance.certificateFor;
        	    	String statusCode="I"
        	    	String appRemarks="Application saved as a draft"
        	    	String pendingWith=""
        	    	String pendingWithRole=""
        	    	String printAppUrl=""
        	    	String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+indApplicationDetailsInstance.indUser.indName+"&indDistrict="+indApplicationDetailsInstance.indUser.district.districtName+"&serviceCode="+indApplicationDetailsInstance.serviceId+"&cafUniqueNo="+indApplicationDetailsInstance.cafUniqueNo
        	    	String certificateUrl=""
        	    	String serviceId=indApplicationDetailsInstance.serviceId
        	    	
        	    	responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationType,applicationFor1,statusCode,appRemarks,pendingWith,pendingWithRole,printAppUrl,revertedUrl,certificateUrl)
        	    	}
    	    	flash.message = "Your Application No. ${indApplicationDetailsInstance.id} is saved and available for future update."
    	    	render(view:'doShow',model:[listDoc:listDoc,formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2])
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
    
    def confirmationShow={
    	 try {
    	    	if(!params.edit || params.edit==""){
    	    		def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
    	    		def viewCert = false
    	    		def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
    	    		def appProcessDetList = ApplicationPendingDetails.findAllByApplication(indApplicationDetailsInstance);
    	    		if(appProcessDetList){
    	    			def appProcessDet = appProcessDetList.get(appProcessDetList.size()-1)
    	        		if(certInst && appProcessDet.applicationStatus == "approved"){
    	        			viewCert = true
    	        		}
    	    		}
    	    		 def listDoc= new ArrayList()
    	        	 def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id desc",[indApplicationDetailsInstance])
    	         	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
    	         		def boolCheck=false
    	         	if(listDoc.size()==0){
    	         			listDoc.add(applicationDocumentInstance.get(ig))
    	         		}
    	         		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	         			
    	         			if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
    	         				boolCheck=true
    	         			}
    	         		}
    	         		if(boolCheck==false){
    	         			listDoc.add(applicationDocumentInstance.get(ig))
    	         		}
    	         	}
    	    		def appFor = indApplicationDetailsInstance.applicationFor
    	    		def industryRegMasterInstance = indApplicationDetailsInstance.indUser
    	        	def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
    	        	def feeBankDetailsInstanceList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterConsumptionDetailsInstanceList = IndWaterConsumptionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterDischargeDetailsInstanceList = IndWaterDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEffluentStandardDetailsInstanceList = IndEffluentStandardDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirStackEmmisionDetailsInstanceList = IndAirStackEmmisionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFuelDetailsInstanceList = IndAirFuelDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFugitiveDetailsInstanceList = IndAirFugitiveDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList2 = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	render(view:'doShow',model:[listDoc:listDoc,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2,appFor:appFor,viewCert:viewCert])
    	    		}else{
    	    		def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
    	    		def viewCert = false
    	    		def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
    	    		def appProcessDetList = ApplicationPendingDetails.findAllByApplication(indApplicationDetailsInstance);
    	    		if(appProcessDetList){
    	    			def appProcessDet = appProcessDetList.get(appProcessDetList.size()-1)
    	        		if(certInst && appProcessDet.applicationStatus == "approved"){
    	        			viewCert = true
    	        		}
    	    		}
    	    		def appFor = indApplicationDetailsInstance.applicationFor
    	    		def industryRegMasterInstance = indApplicationDetailsInstance.indUser
    	        	def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
    	        	def feeBankDetailsInstanceList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterConsumptionDetailsInstanceList = IndWaterConsumptionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterDischargeDetailsInstanceList = IndWaterDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEffluentStandardDetailsInstanceList = IndEffluentStandardDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirStackEmmisionDetailsInstanceList = IndAirStackEmmisionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFuelDetailsInstanceList = IndAirFuelDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFugitiveDetailsInstanceList = IndAirFugitiveDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList2 = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2,appFor:appFor,viewCert:viewCert])
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
    
    def doGetShow = {
    	 try {
    	    	def listDoc= new ArrayList()
    	    	def testVal= params.testVal
    	    	if(!params.edit || params.edit==""){
    	    		def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
    	    		def viewCert = false
    	    		def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
    	    		def appProcessDetList = ApplicationPendingDetails.findAllByApplication(indApplicationDetailsInstance);
    	    		if(appProcessDetList){
    	    			def appProcessDet = appProcessDetList.get(appProcessDetList.size()-1)
    	        		if(certInst && appProcessDet.applicationStatus == "approved"){
    	        			viewCert = true
    	        		}
    	    		}
    	    		def appFor = indApplicationDetailsInstance.applicationFor
    	    		def industryRegMasterInstance = indApplicationDetailsInstance.indUser
    	        	def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
    	        	def feeBankDetailsInstanceList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterConsumptionDetailsInstanceList = IndWaterConsumptionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterDischargeDetailsInstanceList = IndWaterDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEffluentStandardDetailsInstanceList = IndEffluentStandardDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirStackEmmisionDetailsInstanceList = IndAirStackEmmisionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFuelDetailsInstanceList = IndAirFuelDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFugitiveDetailsInstanceList = IndAirFugitiveDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList2 = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id desc",[indApplicationDetailsInstance])
    	        	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
    	        		def boolCheck=false
    	        		if(listDoc.size()==0){
    	        			listDoc.add(applicationDocumentInstance.get(ig))
    	        		}
    	        		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	        			if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
    	        				boolCheck=true
    	        			}
    	        		}
    	        		if(boolCheck==false){
    	        			listDoc.add(applicationDocumentInstance.get(ig))
    	        		}
    	        	}
    	    		///////// Added by deepak for scrutiny
    	    		def return_status = ""
    					println("indApplicationDetailsInstance:"+indApplicationDetailsInstance)
    					def retrunInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by id desc",[indApplicationDetailsInstance])
    					println("retrunInst ------:"+retrunInst)
    					if(retrunInst){
    						println("retrunInst.returned:-----------"+retrunInst.returned)
    						println("retrunInst.resubmitStatus:-----------"+retrunInst.resubmitStatus)
    						println("retrunInst.scrutiny:---------------"+retrunInst.scrutinyStatus)
    					if(retrunInst.returned==true && retrunInst.resubmitStatus==false){
    						return_status = "true";
    						println("return_status in if:-----------------"+return_status)
    					}
    					else if(retrunInst.scrutinyStatus=="In-Complete" && retrunInst.resubmitStatus==false){
    						return_status = "true";
    						println("return_status in else:--------------------"+return_status)
    					}
    					}
    	    	// New code Added by DEEPAK 	
    	    		def pendingRetrunInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=? order by id desc",[indApplicationDetailsInstance])
    	    		println("pendingRetrunInst ------:"+pendingRetrunInst)
    	    		if(pendingRetrunInst){    	    			
    	    			println("pendingRetrunInst.applicationStatus:-----------"+pendingRetrunInst.applicationStatus)
    	    			if(pendingRetrunInst.applicationStatus=="returned"){
    						return_status = "true";    						
    					}
    	    			
    	    		}
						
						println("final return_status:------------------"+return_status)
    	    		
    	    		
    	    		
    	        	render(view:'doShow',model:[listDoc:listDoc,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2,return_status:return_status,appFor:appFor,viewCert:viewCert])
    	    		}else{
    	    		def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
    	    		def viewCert = false
    	    		def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
    	    		if(certInst){
    	    			viewCert = true
    	    		}
    	    		def appFor = indApplicationDetailsInstance.applicationFor
    	    		def industryRegMasterInstance = indApplicationDetailsInstance.indUser
    	        	def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
    	        	def intTest
    	        	def intTest1
    	        	def intTest2
    	        	if(consentFeeMasterInstance){
    	        	intTest=(int)consentFeeMasterInstance.totalApplicableFee
    	        	intTest1=(int)consentFeeMasterInstance.outstandingDueInd
    	        	intTest2=(int)consentFeeMasterInstance.outstandingDueBrd
    	        	}
    	        	def feeBankDetailsInstanceList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterConsumptionDetailsInstanceList = IndWaterConsumptionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indWaterDischargeDetailsInstanceList = IndWaterDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEffluentStandardDetailsInstanceList = IndEffluentStandardDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirStackEmmisionDetailsInstanceList = IndAirStackEmmisionDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indEmmisionCntrlDetailsInstanceList = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFuelDetailsInstanceList = IndAirFuelDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	def indAirFugitiveDetailsInstanceList = IndAirFugitiveDetails.findAllByApplication(indApplicationDetailsInstance)
    	          	def indEmmisionCntrlDetailsInstanceList2 = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	        	render(view:'doEdit',model:[testVal:testVal,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2,appFor:appFor,viewCert:viewCert,intTest:intTest,intTest2:intTest2,intTest1:intTest1])
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
    
    def doGetShowPop = {
    	 try {
    	    	def listDoc= new ArrayList()
    	    	def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
    	    	def viewCert = false
    			def certInst = RecordCertificate.findByApplicationId(indApplicationDetailsInstance)
    			def appProcessDetList = ApplicationPendingDetails.findAllByApplication(indApplicationDetailsInstance);
    			if(appProcessDetList){
    				def appProcessDet = appProcessDetList.get(appProcessDetList.size()-1)
    	    		if(certInst && appProcessDet.applicationStatus == "approved"){
    	    			viewCert = true
    	    		}
    			}
    			def appFor = indApplicationDetailsInstance.applicationFor
    			def industryRegMasterInstance = indApplicationDetailsInstance.indUser
    	    	def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
    	    	def feeBankDetailsInstanceList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indWaterConsumptionDetailsInstanceList = IndWaterConsumptionDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indWaterDischargeDetailsInstanceList = IndWaterDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indEffluentStandardDetailsInstanceList = IndEffluentStandardDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indAirStackEmmisionDetailsInstanceList = IndAirStackEmmisionDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indEmmisionCntrlDetailsInstanceList = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indAirFuelDetailsInstanceList = IndAirFuelDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indAirFugitiveDetailsInstanceList = IndAirFugitiveDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def indEmmisionCntrlDetailsInstanceList2 = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
    	    	def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id desc",[indApplicationDetailsInstance])
    	    	for(int ig=0;ig<applicationDocumentInstance.size();ig++){
    	    		def boolCheck=false
    	    		if(listDoc.size()==0){
    	    			listDoc.add(applicationDocumentInstance.get(ig))
    	    		}
    	    		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	    			if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
    	    				boolCheck=true
    	    			}
    	    		}
    	    		if(boolCheck==false){
    	    			listDoc.add(applicationDocumentInstance.get(ig))
    	    		}
    	    	}
    	    	render(view:'doShowPop',model:[listDoc:listDoc,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2,appFor:appFor,viewCert:viewCert])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
   
    def saveWaterSource = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.indAppId).toInteger())
    	    	def waterSourceInstance = new WaterSourceDetails()
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
    					println it;
    			   }
    			}
    	    	render(view:'popWaterAddUses',model:[waterSourceInstance:waterSourceInstance,app:params.indAppId])
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	    	def sourceDetIns = WaterSourceDetails.get((params.source).toInteger())
    	    	if((params.waterSourceUses).getClass().getName()== "java.lang.String"){
    	    		def waterUsesDetails = new WaterUsesDetails()
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
    	    		render(view:'popWaterAddModeUse',model:[waterSourceInstance:sourceDetIns,app:params.app])
    	    	}else{
    	    		for(int i=0;i<params.waterSourceUses.size();i++){
    	    			def waterUsesDetails = new WaterUsesDetails()
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
    	    	render(view:'popWaterAddModeUse',model:[waterSourceInstance:sourceDetIns,app:params.app])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	    	def sourceDetIns = WaterSourceDetails.get((params.source).toInteger())
    	    	if((params.waterModeUse).getClass().getName()== "java.lang.String"){
    	    		def waterModeUseDetailsInst = new WaterModeUseDetails()
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
    	    			def waterModeUseDetailsInst = new WaterModeUseDetails()
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
    	    	render(view:'popClose',model:[app:params.app])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editWaterSource = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.source).getClass().getName()== "java.lang.String"){
    	    		def waterSourceDetIns = WaterSourceDetails.get((params.source).toInteger())
    	    		def waterUsesDetList = WaterUsesDetails.findAllWhere(source:waterSourceDetIns.source,application:app)
    	    		def waterModeUseDetList = WaterModeUseDetails.findAllWhere(source:waterSourceDetIns.source,application:app)
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
    	        			def waterSourceDetIns = WaterSourceDetails.get((params.source[j]).toInteger())
    	    	    		def waterUsesDetList = WaterUsesDetails.findAllWhere(source:waterSourceDetIns.source,application:app)
    	    	    		def waterModeUseDetList = WaterModeUseDetails.findAllWhere(source:waterSourceDetIns.source,application:app)
    	    	    		for(int i=0;i<waterUsesDetList.size();i++){
    	    	    			(waterUsesDetList.get(i)).delete()
    	    	    		}
    	    	    		for(int i=0;i<waterModeUseDetList.size();i++){
    	    	    			(waterModeUseDetList.get(i)).delete()
    	    	    		}
    	    	    		waterSourceDetIns.delete()	
    	        		}
    	    	}
    	    	redirect(action:popWaterSourceEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveWaterWasteGen = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	def list = new ArrayList()
    	    	if((params.waterDisposalMode).getClass().getName()== "java.lang.String"){
    	    		
    	    		def waterWasteGenerationInst = new WaterWasteGenerationDetails()
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
    	    			def waterWasteGenerationInst = new WaterWasteGenerationDetails()
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
    	    	 def waterWasteGenerationInstance = WaterWasteGenerationDetails.findAllWhere(application:app)
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
    	        redirect(action:popWaterWasteGenAdd,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
   	   }
    }
    
    def editWaterWasteGen = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def wasteWaterGenInst = WaterWasteGenerationDetails.get((params.delete).toInteger())
    	    		wasteWaterGenInst.delete()
    	    	}else{
    	    		if(params.delete)
    	    		for(int i=0;i<(params.delete).size();i++){
    	    			def wasteWaterGenInst = WaterWasteGenerationDetails.get((params.delete[i]).toInteger())
    	        		wasteWaterGenInst.delete()
    	    		}
    	    	}
    	    	redirect(action:popWaterWasteGenEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveWaterWasteTreatment = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.waterWasteTeatCat).getClass().getName()== "java.lang.String"){
    	    		def waterWasteTreatInst = new WasteWaterTreatmentDetails()
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
    	    			def waterWasteTreatInst = new WasteWaterTreatmentDetails()
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
    	    		redirect(action:popWaterTreatmentAdd,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editWaterTreatment = {
    	 try {
    	    	def wasteWaterTreatDetInst
    	    	def app
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		wasteWaterTreatDetInst = WasteWaterTreatmentDetails.get((params.delete).toInteger())
    	    		app = wasteWaterTreatDetInst.application
    	    		wasteWaterTreatDetInst.delete()
    	    	}else{
    	    		if(params.delete)
    	    		for(int i=0;i<(params.delete).size();i++){
    	    			 wasteWaterTreatDetInst = WasteWaterTreatmentDetails.get((params.delete[i]).toInteger())
    	        		app = wasteWaterTreatDetInst.application
    	    			 wasteWaterTreatDetInst.delete()
    	    		}
    	    	}
    	    	redirect(action:popWaterTreatmentEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def savewaterSolidWasteGen = {
    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	def waterSolidWasteGenDetailsInst = new WaterSolidWasteGenDetails()
    	waterSolidWasteGenDetailsInst.description = params.description
    	waterSolidWasteGenDetailsInst.quantQual = params.quantity
    	waterSolidWasteGenDetailsInst.meathodCollection = params.methodCollection
    	waterSolidWasteGenDetailsInst.meathodDisposal = params.methodDisposal
    	waterSolidWasteGenDetailsInst.application = app
    	waterSolidWasteGenDetailsInst.save()
    	redirect(action:popWaterSolidWasteAdd,id:app)
    }
    
    def saveAirStackDetails = {
    	 try {
    	    	def count1
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.capacity).getClass().getName()== "java.lang.String"){
    	    		def unit = UnitMaster.get((params.capacityUnit).toInteger())
    	    		def airStackInst = new AirStackDetails()
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
    	    	    		def airStackPollCntrlDetailsInst = new AirStackPollutionCntrlDetails()
    	    	    		airStackPollCntrlDetailsInst.stack = airStackInst
    	    	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.pollCntrlMeasure).toInteger())
    	    	    		airStackPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
    	    	    		airStackPollCntrlDetailsInst.save()
    	        		}else{
    	        			for(int i=0;i<params.pollCntrlMeasure.size();i++){
    	        				def airStackPollCntrlDetailsInst = new AirStackPollutionCntrlDetails()
    	        	    		airStackPollCntrlDetailsInst.stack = airStackInst
    	        	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.pollCntrlMeasure[i]).toInteger())
    	        	    		airStackPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
    	        	    		airStackPollCntrlDetailsInst.save()
    	        			}
    	        		}
    	    		}else{
    	    			airStackInst.errors.allErrors.each {
    	    				println it;
    	    			    }
    	    		}
    		    }else{
    	    		for(int i=0;i<params.capacity.size();i++){
    	    		}
    	    	}
    	    	flash.message = "Details Saved"
    	       redirect(action:popAirStackAdd,id:app,params:[count1:count1])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
   
    def editAirStack = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def airStackDetInst = AirStackDetails.get((params.delete).toInteger())
    	    		def airStackPollCntrlInstList = AirStackPollutionCntrlDetails.findAllByStack(airStackDetInst)
    	    		def airFlueGasInstList = AirFlueGasDetails.findAllByStack(airStackDetInst)
    	    		def airFugitiveInstList = AirFugitivePollutionControlDetails.findAllByStack(airStackDetInst)
    	    		def airFluePollCntrlInstList = AirFlueGasPollutionCntrlDetails.findAllByStack(airStackDetInst)
    	    		def airStackEquipmentList = AirStackEquipmentDetails.findAllByStack(airStackDetInst)
    	    		for(int j=0;j<airStackPollCntrlInstList.size();j++){
    	    			(airStackPollCntrlInstList.get(j)).delete()
    	    		}
    	    		for(int j=0;j<airFlueGasInstList.size();j++){
    	    			(airFlueGasInstList.get(j)).delete()
    	    		}
    	    		for(int j=0;j<airFugitiveInstList.size();j++){
    	    			(airFugitiveInstList.get(j)).delete()
    	    		}
    	    		for(int j=0;j<airFluePollCntrlInstList.size();j++){
    	    			(airFluePollCntrlInstList.get(j)).delete()
    	    		}
    	    		for(int j=0;j<airStackEquipmentList.size();j++){
    	    			(airStackEquipmentList.get(j)).delete()
    	    		}
    	    		airStackDetInst.delete()
    	    	}else{
    	    		if(params.delete)
    	    		for(int i=0;i<(params.delete).size();i++){
    	    			def airStackDetInst = AirStackDetails.get((params.delete[i]).toInteger())
    	        		def airStackPollCntrlInstList = AirStackPollutionCntrlDetails.findAllByStack(airStackDetInst)
    	        		def airFlueGasInstList = AirFlueGasDetails.findAllByStack(airStackDetInst)
    	        		def airFugitiveInstList = AirFugitivePollutionControlDetails.findAllByStack(airStackDetInst)
    	        		def airFluePollCntrlInstList = AirFlueGasPollutionCntrlDetails.findAllByStack(airStackDetInst)
    	        		def airStackEquipmentList = AirStackEquipmentDetails.findAllByStack(airStackDetInst)
    	        		for(int j=0;j<airStackPollCntrlInstList.size();j++){
    	        			(airStackPollCntrlInstList.get(j)).delete()
    	        		}
    	        		for(int j=0;j<airFlueGasInstList.size();j++){
    	        			(airFlueGasInstList.get(j)).delete()
    	        		}
    	        		for(int j=0;j<airFugitiveInstList.size();j++){
    	        			(airFugitiveInstList.get(j)).delete()
    	        		}
    	        		for(int j=0;j<airFluePollCntrlInstList.size();j++){
    	        			(airFluePollCntrlInstList.get(j)).delete()
    	        		}
    	        		for(int j=0;j<airStackEquipmentList.size();j++){
    	        			(airStackEquipmentList.get(j)).delete()
    	        		}
    	        		airStackDetInst.delete()
    	    		}
    	    	}
    	    	redirect(action:popAirStackEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveAirFlueEmmision = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.stack).getClass().getName()== "java.lang.String"){
    	    		def airFlueGasDetailsInst = new AirFlueGasDetails()
    	    		def unit = UnitMaster.get((params.unit).toInteger())
    	    		def airStack = AirStackDetails.get((params.stack).toInteger())
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
    		    		def airFlueGasPollCntrlDetailsInst = new AirFlueGasPollutionCntrlDetails()
    		    		airFlueGasPollCntrlDetailsInst.stack = airFlueGasDetailsInst.stack
    		    		def b = params.airFlueGasCntrlMeasure
    		    		def cntrlMeasure = AirEmiControlMeasureMaster.findWhere(controlMeasure:b)
    		    		airFlueGasPollCntrlDetailsInst.pollutionCntrlMeasure = cntrlMeasure
    		    		airFlueGasPollCntrlDetailsInst.save()
    	    		}else{
    	    			for(int i=0;i<params.airFlueGasCntrlMeasure.size();i++){
    	    				def airFlueGasPollCntrlDetailsInst = new AirFlueGasPollutionCntrlDetails()
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
    	            redirect(action:popAirFlueEmmision,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editAirFlueEmmision = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def airFlueGasDetInst = AirFlueGasDetails.get((params.delete).toInteger())
    	    		def airFluePollCntrlInstList = AirFlueGasPollutionCntrlDetails.findAllByStack(airFlueGasDetInst.stack)
    	    		for(int j=0;j<airFluePollCntrlInstList.size();j++){
    	    			(airFluePollCntrlInstList.get(j)).delete()
    	    		}
    	    		airFlueGasDetInst.delete()
    	    	}else{
    	    		if(params.delete)
    	    		for(int i=0;i<(params.delete).size();i++){
    	    			def airFlueGasDetInst = AirFlueGasDetails.get((params.delete[i]).toInteger())
    	        		def airFluePollCntrlInstList = AirFlueGasPollutionCntrlDetails.findAllByStack(airFlueGasDetInst.stack)
    	        		for(int j=0;j<airFluePollCntrlInstList.size();j++){
    	        			(airFluePollCntrlInstList.get(j)).delete()
    	        		}
    	        		airFlueGasDetInst.delete()
    	    		}
    	    	}
    	    	redirect(action:popAirFlueEmmisionEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveAirFugitiveEmmision = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.stack).getClass().getName()== "java.lang.String"){
    	    		if((params.airFugiCntrlMeasure).getClass().getName()== "java.lang.String"){
    		    		def airFugitivePollutionControlDetInst = new AirFugitivePollutionControlDetails()
    		    		airFugitivePollutionControlDetInst.stack = AirStackDetails.get((params.stack).toInteger())
    		    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.airFugiCntrlMeasure).toInteger())
    		    		airFugitivePollutionControlDetInst.pollutionCntrlMeasure = cntrlMeasure
    		    		airFugitivePollutionControlDetInst.save()
    	    		}else{
    	    			for(int i=0;i<params.airFugiCntrlMeasure.size();i++){
    	    				def airFugitivePollutionControlDetInst = new AirFugitivePollutionControlDetails()
    	    	    		airFugitivePollutionControlDetInst.stack = AirStackDetails.get((params.stack).toInteger())
    	    	    		def cntrlMeasure = AirEmiControlMeasureMaster.get((params.airFugiCntrlMeasure[i]).toInteger())
    	    	    		airFugitivePollutionControlDetInst.pollutionCntrlMeasure = cntrlMeasure
    	    	    		airFugitivePollutionControlDetInst.save()
    	    			}
    	    		}
    	    	}else{
    	    		for(int i=0;i<params.stack.size();i++){
    	    		}
    	    	}
    	    	flash.message = "Details Saved"
    	            redirect(action:popAirFugitiveEmmision,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editAirFugitiveEmmission = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def stackInst = AirStackDetails.get((params.delete).toInteger())
    	    		def airFugitivePollutionControlDetIntList = AirFugitivePollutionControlDetails.findAllByStack(stackInst)
    	    		for(int j=0;j<airFugitivePollutionControlDetIntList.size();j++){
    	    			(airFugitivePollutionControlDetIntList.get(j)).delete()
    	    		}
    	    	}else{
    	    		if(params.delete)
    	        	for(int i=0;i<(params.delete).size();i++){
    	        		def stackInst = AirStackDetails.get((params.delete[i]).toInteger())
    	        		def airFugitivePollutionControlDetIntList = AirFugitivePollutionControlDetails.findAllByStack(stackInst)
    	        		for(int j=0;j<airFugitivePollutionControlDetIntList.size();j++){
    	        			(airFugitivePollutionControlDetIntList.get(j)).delete()
    	        		}
    	        	}
    	    	}
    	    	redirect(action:popAirFugitiveEmmisionEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveAmbientAirStandard = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	def ambientAirList = AmbientAirQualityStandardMaster.list()
    	    	for(int i=0;i<ambientAirList.size();i++){
    	    		if(params[(ambientAirList.get(i)).areaCategory]){
    	    			def ambientAirQualityStandardDetInst = new AmbientAirQualityStandardDetails()
    	    			ambientAirQualityStandardDetInst.ambient = AmbientAirQualityStandardMaster.get((params[(ambientAirList.get(i)).areaCategory]).toInteger())
    	    			ambientAirQualityStandardDetInst.application = app
    	    			ambientAirQualityStandardDetInst.save()
    	    		}
    	    	}
    	    		flash.message = "Details Saved"
    	            redirect(action:popAmbientAirStandardAdd,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editAmbientAirStandard = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def ambientAirDetInst = AmbientAirQualityStandardDetails.get((params.delete).toInteger())
    	    		ambientAirDetInst.delete()
    	    	}else{
    	    		if(params.delete)
    	        	for(int i=0;i<(params.delete).size();i++){
    	        		def ambientAirDetInst = AmbientAirQualityStandardDetails.get((params.delete[i]).toInteger())
    	        		ambientAirDetInst.delete()
    	        	}
    	    	}
    	    	redirect(action:popAmbientAirStandardDelete,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 	}
    	   }
    }
    
    def saveProductDetails = {
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
	    			def indProductDetailsInstance = new IndProductDetails()
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
	        			def indProductDetailsInstance = new IndProductDetails()
	            		indProductDetailsInstance.application = indApplicationDetailsInstance
	            		indProductDetailsInstance.product = product[i] 
	            		indProductDetailsInstance.quantity = quantity[i]
	            		indProductDetailsInstance.byProduct = byProduct[i] 
	            		indProductDetailsInstance.rawMaterials = rawMaterials[i]
	            		indProductDetailsInstance.unit = UnitMaster.get((params.unit[i]).toInteger())
	            		indProductDetailsInstance.unitbyProduct = UnitMaster.get((params.unitbyProduct[i]).toInteger())
	            		if(indProductDetailsInstance.save()){
	            			println("okay")
	            		}else{
	            			indProductDetailsInstance.errors.each(){
	            				println it
	            			}
	            		}
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
			redirect(action:popProductDetailsAdd,id:app,params:[d:d])
	    
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
}
    
    def saveCostDetails = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	def indExpenditureCostDetailsInstance = new IndExpenditureCostDetails()
    	    	def expenditureProposed = params.expenditureProposed
    	    	def costDetailList = IndExpenditureCostDetails.findAll("from IndExpenditureCostDetails indPower where indPower.expenditureProposed=? and indPower.application=?",[expenditureProposed,app])
    	    	if(expenditureProposed=="Not Selected")
    	    	{
    	    		flash.message = "Please Select Expenditure Proposed For"
    	        	redirect(action:popEstimetedDetailsAdd,id:app,params:[indExpenditureCostDetailsInstance:indExpenditureCostDetailsInstance])
    	    	}
    	    	else if(costDetailList)
    	    	{
    	    		flash.message = "Expenditure Proposed details regarding ${expenditureProposed} already exists"
    	    		redirect(action:popEstimetedDetailsAdd,id:app,params:[indExpenditureCostDetailsInstance:indExpenditureCostDetailsInstance])
    	    	}
    	    	else
    	    	{
    	    		indExpenditureCostDetailsInstance.expenditureProposed = params.expenditureProposed
    	    	
    	    	if(params.capital == null)
    	    	{
    	    		indExpenditureCostDetailsInstance.capital = 0
    	    	}
    	    	else
    	    	{
    	    		indExpenditureCostDetailsInstance.capital = params.capital.toFloat()
    	    	}
    	    	if(params.recurring == null)
    	    	{
    	    		indExpenditureCostDetailsInstance.recurring = 0
    	    	}
    	    	else
    	    	{
    	    		indExpenditureCostDetailsInstance.recurring = params.recurring.toFloat()
    	    	}
    	    	indExpenditureCostDetailsInstance.application = app
    	    	indExpenditureCostDetailsInstance.save()
    	    	redirect(action:popEstimetedDetailsAdd,id:app,params:[indExpenditureCostDetailsInstance:indExpenditureCostDetailsInstance])
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
    
    def deleteProductDetails = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def indProdDetInst = IndProductDetails.get((params.delete).toInteger())
    	    		indProdDetInst.delete()
    	    	}else{
    	    		if(params.delete)
    	        	for(int i=0;i<(params.delete).size();i++){
    	        		def indProdDetInst = IndProductDetails.get((params.delete[i]).toInteger())
    	        		indProdDetInst.delete()
    	        	}
    	    	}
    	    	redirect(action:popProductDetailsEdit,id:app)
    	    	}catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def deleteCostDetails = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def indCostDetInst = IndExpenditureCostDetails.get((params.delete).toInteger())
    	    		indCostDetInst.delete()
    	    	}else{
    	    		if(params.delete)
    	        	for(int i=0;i<(params.delete).size();i++){
    	        		def indCostDetInst = IndExpenditureCostDetails.get((params.delete[i]).toInteger())
    	        		indCostDetInst.delete()
    	        	}
    	    	}
    	    	redirect(action:popEstimetedDetailsEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	        			def feeBankDetails = new FeeBankDetails()
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
    	        					println it;
    	        			   }
    	        			}
    	        			}
    	        	}else{
    	        		for(int i=0;i<params.ddNo.size();i++){
    	        			if(ddNo[i]!=""){
    	        				def feeBankDetails = new FeeBankDetails()
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
    
    def popFeeDetailsAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def feeDetailsList = FeeBankDetails.findAllByApplication(app)
    	    	def feeCheque = FeeChequeRecord.findByIndApplication(app)
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
    
    def deleteFeeBankDetails = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def feeDetInst = FeeBankDetails.get((params.delete).toInteger())
    	    		feeDetInst.delete()
    	    	if(params.delete1)
    	    		{
    	    		def feeCheque = FeeChequeRecord.get((params.delete1).toInteger())
    	    		if(feeCheque){
    	        	feeCheque.delete()
    	        		}
    	    			flash.message="Please attach again the scan copy of Drafts/Cheques"
    	    		}
    	    	}else{
    	    		if(params.delete){
    	        	for(int i=0;i<(params.delete).size();i++){
    	        		def feeDetInst = FeeBankDetails.get((params.delete[i]).toInteger())
    	        		feeDetInst.delete()
    	        	}
    	        	if(params.delete1)
    	    		{
    	    		def feeCheque = FeeChequeRecord.get((params.delete1).toInteger())
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
    
    def popWaterAddUses = {}
    
    def popWaterSourceAdd = {
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
    
    def popWaterSourceView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def sourceList = WaterSourceDetails.findAllByApplication(app)
    	    	def usesBList = new ArrayList()
    	    	def modeUseBlist = new ArrayList()
    	    	for(int i=0;i<sourceList.size();i++){
    	    		def usesList = WaterUsesDetails.findAllWhere(source:(sourceList.get(i)).source,application:app)
    	    		usesBList.add(usesList)
    	    		def modeUseList = WaterModeUseDetails.findAllWhere(source:(sourceList.get(i)).source,application:app)
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
    
    def popWaterSourceEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def sourceList = WaterSourceDetails.findAllByApplication(app)
    	    	def usesBList = new ArrayList()
    	    	def modeUseBlist = new ArrayList()
    	    	for(int i=0;i<sourceList.size();i++){
    	    		def usesList = WaterUsesDetails.findAllWhere(source:(sourceList.get(i)).source,application:app)
    	    		usesBList.add(usesList)
    	    		def modeUseList = WaterModeUseDetails.findAllWhere(source:(sourceList.get(i)).source,application:app)
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
    
    def popWaterTreatmentAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def waterWasteTreatmentDetList = WasteWaterTreatmentDetails.findAllByApplication(app)
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
    
    def popWaterTreatmentView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def waterWasteTreatmentDetList = WasteWaterTreatmentDetails.findAllByApplication(app)
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
    
    def popWaterTreatmentEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def waterWasteTreatmentDetList = WasteWaterTreatmentDetails.findAllByApplication(app)
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
    
    def popWaterWasteGenAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def wasteWaterGenDetInstList = WaterWasteGenerationDetails.findAllByApplication(app)
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
    
    def popWaterWasteGenView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def wasteWaterGenDetInstList = WaterWasteGenerationDetails.findAllByApplication(app)
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
    
    def popWaterWasteGenEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def wasteWaterGenDetInstList = WaterWasteGenerationDetails.findAllByApplication(app)
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
    
    def popWaterSolidWasteAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def waterSolidWasteGenList = WaterSolidWasteGenDetails.findAllByApplication(app)
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
  
    def saveAirStackEquipmentDetails ={
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	def airStackEquipmentInst
    	    	def x
    	    	if((params.stack).getClass().getName()== "java.lang.String"){
    	    		 airStackEquipmentInst = new AirStackEquipmentDetails()
    	    		def unit = UnitMaster.get((params.unit).toInteger())
    	    		def airStack = AirStackDetails.get((params.stack).toInteger())
    	    		airStackEquipmentInst.application = app
    	    		airStackEquipmentInst.redEfficiency = params.redEfficiency
    	    		airStackEquipmentInst.quantity = params.quantity
    	    		airStackEquipmentInst.pollutant = params.pollutant
    	    		def inst = params.installation_value
    	    		 def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
    					x = sdfh.parse(inst);
    	    		airStackEquipmentInst.installation =inst
    	    		airStackEquipmentInst.quality = params.quality
    	    		airStackEquipmentInst.monitoring = params.monitoring
    	    		airStackEquipmentInst.stack = airStack
    	    		airStackEquipmentInst.state = params.state
    	    		airStackEquipmentInst.unit = unit
    	    		def equip = params.equipment
    	    		def cntrlEquip = AirEmiControlMeasureMaster.findWhere(controlMeasure:equip)
    	    		airStackEquipmentInst.equipment = cntrlEquip
    	    		airStackEquipmentInst.save()
    	    	}
    	    	if(!airStackEquipmentInst.hasErrors()){
    	    	flash.message = "Details Saved"
    	            redirect(action:popAirStackEquipmentAdd,id:app)
    	    	}
    	    	else{
    	    		flash.message = "duplicate equipment name under same stack"
    	                redirect(action:popAirStackEquipmentAdd,id:app)
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
    
    def popAirStackEquipmentAdd = {
    	 try {
    	    def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackInstList = AirStackDetails.findAllByApplication(app)
    	    	def airStackEquipmentList = AirStackEquipmentDetails.findAllByApplication(app)
    	    	return [appDetId:params.id, stackList:airStackInstList,airStackEquipmentList:airStackEquipmentList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editAirStackEquipmentDetails = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	if((params.delete).getClass().getName()== "java.lang.String"){
    		    		def airStackEquipmentList = AirStackEquipmentDetails.get((params.delete).toInteger())
    		    		airStackEquipmentList.delete()
    		    	}else{
    		    		if(params.delete)
    		    		for(int i=0;i<(params.delete).size();i++){
    		    			def airStackEquipmentList = AirStackEquipmentDetails.get((params.delete[i]).toInteger())
    		        		airStackEquipmentList.delete()
    		    		}
    		    	}
    		    	redirect(action:popAirStackEquipmentEdit,id:app)
    		    }catch(Exception e) {
    		            e.printStackTrace();
    					 flash.message = "Server Busy ..Please try after some time....";
    					if(session.indUser){
    				redirect(controller:'indUser',action:'openIndustryHome')
    		 }
    		 else if(session.userMaster){
    		  redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    		        session.invalidate()
    		        redirect(uri:'/index.gsp');
    		 }
    		   }
    }
   
    def popAirStackEquipmentEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackEquipmentList = AirStackEquipmentDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,airStackEquipmentList:airStackEquipmentList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirStackEquipmentView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackEquipmentList = AirStackEquipmentDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,airStackEquipmentList:airStackEquipmentList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
    
    def popAirStackAdd = {
    	 try {
    	    	def app
    	    	if(params.id){
    	    		app = IndApplicationDetails.get((params.id).toInteger())
    	    	}else{
    	    		app = IndApplicationDetails.get((params.app).toInteger())
    	    	}
    	    	 def count1
    	         def count2 
    	        def airInstanceList =AirStackDetails.findAllWhere(application:app)
    	        	if(airInstanceList){
    	        	count1 = airInstanceList.size()
    	         }
    	    	else{
    	    		count1 = '0'
    	    	}
    	    	 	app.noOfStack = count1
    	    	def stackList = AirStackDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<stackList.size();i++){
    	    		def pollCntrlList = AirStackPollutionCntrlDetails.findAllWhere(stack:stackList.get(i))
    	    		pollCntrlBList.add(pollCntrlList)
    	    	}
    	    	return [appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList,count1:count1]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirStackEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def stackList = AirStackDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<stackList.size();i++){
    	    		def pollCntrlList = AirStackPollutionCntrlDetails.findAllWhere(stack:stackList.get(i))
    	    		pollCntrlBList.add(pollCntrlList)
    	    	}
    	    	return [appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirStackView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def stackList = AirStackDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<stackList.size();i++){
    	    		def pollCntrlList = AirStackPollutionCntrlDetails.findAllWhere(stack:stackList.get(i))
    	    		pollCntrlBList.add(pollCntrlList)
    	    	}
    	    	return [appDetId:params.id,stackList:stackList,pollCntrlBList:pollCntrlBList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirPollutantAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackInstList = AirStackDetails.findAllByApplication(app)
    	    	return [appDetId:params.id, stackList:airStackInstList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirFlueEmmision = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackInstList = AirStackDetails.findAllByApplication(app)
    	    	def flueList = AirFlueGasDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<flueList.size();i++){
    	    		def pollCntrlList = AirFlueGasPollutionCntrlDetails.findAllWhere(stack:(flueList.get(i)).stack)
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
    
    def popAirFlueEmmisionEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def flueList = AirFlueGasDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<flueList.size();i++){
    	    		def pollCntrlList = AirFlueGasPollutionCntrlDetails.findAllWhere(stack:(flueList.get(i)).stack)
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
    
    def popAirFlueEmmisionView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def flueList = AirFlueGasDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<flueList.size();i++){
    	    		def pollCntrlList = AirFlueGasPollutionCntrlDetails.findAllWhere(stack:(flueList.get(i)).stack)
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
    
    def popAirMiscDetail = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def miscList = AirMiscDetails.findAllByApplication(app)
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
    
    def popAirMiscDetailEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def miscList = AirMiscDetails.findAllByApplication(app)
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
    
    def popAirMiscDetailView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def miscList = AirMiscDetails.findAllByApplication(app)
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

    def saveAirMiscDetail = 
    {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.odorCompounds).getClass().getName()== "java.lang.String")
    	    	{
    	    		def airMiscDetailsInst = new AirMiscDetails()
    	    		airMiscDetailsInst.application = app
    	    		airMiscDetailsInst.facility = params.facility
    	    		airMiscDetailsInst.quality = params.quality
    	    		airMiscDetailsInst.odorCompounds = params.odorCompounds
    	    		airMiscDetailsInst.save()
    		    }
    	    	flash.message = "Details Saved"
    	            redirect(action:popAirMiscDetail,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def editAirMiscDetail = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    	if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def airMiscDetInst = AirMiscDetails.get((params.delete).toInteger())
    	    		airMiscDetInst.delete()
    	    	}
    	    	else
    	    	{
    	    		if(params.delete)
    	    			for(int i=0;i<(params.delete).size();i++)
    	    			{
    	    			def airMiscDetInst = AirMiscDetails.get((params.delete[i]).toInteger())
    	        		airMiscDetInst.delete()
    	    			}
    	    	}
    	    	redirect(action:popAirMiscDetailEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirFugitiveEmmision = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackInstList = AirStackDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<airStackInstList.size();i++){
    	    		def pollCntrlList = AirFugitivePollutionControlDetails.findAllWhere(stack:airStackInstList.get(i))
    	    		pollCntrlBList.add(pollCntrlList)
    	    	}
    	    	return [appDetId:params.id,airStackInstList:airStackInstList,pollCntrlBList:pollCntrlBList,stackList:airStackInstList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirFugitiveEmmisionEdit= {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackInstList = AirStackDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<airStackInstList.size();i++){
    	    		def pollCntrlList = AirFugitivePollutionControlDetails.findAllWhere(stack:airStackInstList.get(i))
    	    		pollCntrlBList.add(pollCntrlList)
    	    	}
    	    	return [appDetId:params.id,airStackInstList:airStackInstList,pollCntrlBList:pollCntrlBList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAirFugitiveEmmisionView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def airStackInstList = AirStackDetails.findAllByApplication(app)
    	    	def pollCntrlBList = new ArrayList()
    	    	for(int i=0;i<airStackInstList.size();i++){
    	    		def pollCntrlList = AirFugitivePollutionControlDetails.findAllWhere(stack:airStackInstList.get(i))
    	    		pollCntrlBList.add(pollCntrlList)
    	    	}
    	    	return [appDetId:params.id,airStackInstList:airStackInstList,pollCntrlBList:pollCntrlBList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAmbientAirStandardAdd = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def ambientAirQualityStadDetList = AmbientAirQualityStandardDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,ambientAirQualityStadDetList:ambientAirQualityStadDetList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAmbientAirStandardView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def ambientAirQualityStadDetList = AmbientAirQualityStandardDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,ambientAirQualityStadDetList:ambientAirQualityStadDetList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popAmbientAirStandardDelete = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def ambientAirQualityStadDetList = AmbientAirQualityStandardDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,ambientAirQualityStadDetList:ambientAirQualityStadDetList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popProductDetailsAdd = {
    	 try {
    	    	def d = params.d
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def productDetailsList = IndProductDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,productDetailsList:productDetailsList,d:d]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popProductDetailsView = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def productDetailsList = IndProductDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,productDetailsList:productDetailsList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popProductDetailsEdit = {
    	 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def productDetailsList = IndProductDetails.findAllByApplication(app)
    	    	return [appDetId:params.id,productDetailsList:productDetailsList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	    	def feeDetailsList = FeeBankDetails.findAllByApplication(app)
    	    	def feeCheque = FeeChequeRecord.findByIndApplication(app)
    	    	def feeChequeAdditional=FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.additionalfee='YES'",[app])
    	    	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque,feeChequeAdditional:feeChequeAdditional]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
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
    	    	def feeDetailsList = FeeBankDetails.findAllByApplication(app)
    	    	def feeCheque = FeeChequeRecord.findByIndApplication(app)
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
    def popUploadDoc_old_Deepak= {
   	 try {
   		 println("params in popUploadDoc.."+params)
   	    	def app = IndApplicationDetails.get((params.id).toInteger())
   	    	def appfor=app.applicationFor
   	    	println("appfor..."+appfor)
   	    	def appType=app.applicationType
   	    	println("appType..."+appType)
   	    	def hazardeousType=app.hazardeousType
   	    	println("hazardeousType..."+hazardeousType)
   	    	def listDoc= new ArrayList()
   	    	def docList 
   	    	if(hazardeousType=="HWM"){
   	    		if(app.applicationType=="CTO" && appfor=="both"){
   	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor!='CTE' and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and consentFor='new'")
   	    		}else if(app.applicationType=="CTE" && appfor=="both"){
   	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor!='CTO' and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and consentFor='new'")
   	    		}else{
   	    			if(app.applicationType=="CTE"){
   	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTE','Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and consentFor=? ",[appfor])
   	    			}else{
   	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTO','Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and  consentFor=? ",[appfor])
       	    		}
   	    			} 
   	    		}else{

       	    		if(app.applicationType=="CTO" && appfor=="both"){
       	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor='CTO' and consentFor='new' and applicationFor !='Authorization' and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' ")
       	    		}else if(app.applicationType=="CTE" && appfor=="both"){
       	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor='CTE' and consentFor='new' and applicationFor !='Authorization' and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' ")
       	    		}else{
       	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor=? and consentFor=? and applicationFor!='Authorization' and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' ",[appType,appfor])
       	    			println("----docList----"+docList.size())
           	    	} 	
       	    	}
   	    	def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id asc",[app])
   	     	 for(int ig=0;ig<applicationDocumentInstance.size();ig++){
   	     		def boolCheck=false
   	     		if(listDoc.size()==0){
   	     			listDoc.add(applicationDocumentInstance.get(ig))
   	     		}
   	     		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
   	     			if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
   	     				boolCheck=true
   	     			}
   	     		}
   	     		if(boolCheck==false){
   	     			listDoc.add(applicationDocumentInstance.get(ig))
   	     		}
   	     		
   	     	}
   	    	return [appDetId:params.id,docList:docList,uploadedDocList:listDoc]
   	    }catch(Exception e) {
   	            e.printStackTrace();
   				 flash.message = "Server Busy ..Please try after some time....";
   				if(session.indUser){
   			redirect(controller:'indUser',action:'openIndustryHome')
   	 }
   	 else if(session.userMaster){
   	  redirect(controller:'userMaster',action:'openSpcbHome');
   	 }else{
   	        session.invalidate()
   	        redirect(uri:'/index.gsp');
   	 }
   	   }
   }
    
    def popUploadDoc = {
    	 try {
    		 println("params in popUploadDoc.."+params)
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    	def appfor=app.applicationFor
    	    	println("appfor..."+appfor)
    	    	def appType=app.applicationType
    	    	println("appType..."+appType)
    	    	def hazardeousType=app.hazardeousType
    	    	println("hazardeousType..."+hazardeousType)
    		    def certificateFor=app.certificateFor
 	    	    println("certificateFor..."+certificateFor)
    	    	def listDoc= new ArrayList()
    	    	def docList 
    	    	
    	    		if(app.applicationType=="CTO" && appfor=="both"){

    	    			if(app.certificateFor=="new"){
    	    				 println("inside CTO new...")
    	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Fresh' and consentFor='new'")
    	    			 println("inside CTO new..docList."+docList)
    	    			}else if(app.certificateFor=="reNew"){
    	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Renew' and consentFor='new'")
    	    			}else{
    	    				 println("inside CTO new..other.")
    	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Expansion' and consentFor='new'")
    	    			}
    	    			
    	    		}else if(app.applicationType=="CTE" && appfor=="both"){
    	    			if(app.certificateFor=="new"){
    	    				 println("inside CTE new...")
    	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor='new'")
    	    			 println("inside CTE new..docList."+docList)
    	    			}else if(app.certificateFor=="reNew"){
    	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Renew' and consentFor='new'")
    	    			}else{
    	    				 println("inside CTE new..other46456.")
    	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Expansion' and consentFor='new'")
    	    			}
    	    			}else{
    	    			if(app.applicationType=="CTE"){

        	    			if(app.certificateFor=="new"){
        	    				 println("inside CTE new...")
        	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor=? order by document asc",[appfor])
        	    			 println("inside CTE new..docList.--==-=="+docList.document)
        	    			}else if(app.certificateFor=="reNew"){
        	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Renew' and consentFor=? ",[appfor])
        	    			}else{
        	    				 println("inside CTE new..other.5654")
        	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Expansion' and consentFor=? ",[appfor])
        	    			}
        	    			
    	    				
    	    			//docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTE Fresh','CTE Renew''CTE Expansion''Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and consentFor=? ",[appfor])
    	    			}else{

        	    			if(app.certificateFor=="new"){
        	    				 println("inside CTO new...")
        	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Fresh' and consentFor=? ",[appfor])
        	    			 println("inside CTO new..docList."+docList)
        	    			}else if(app.certificateFor=="reNew"){
        	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Renew' and  consentFor=? ",[appfor])
        	    			}else{
        	    				 println("inside CTO new..other.")
        	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Expansion' and  consentFor=? ",[appfor])
        	    			}        	    			
        	    		
    	    				//docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTO','Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and  consentFor=? ",[appfor])
        	    		}
    	    			} 
    	    		
    	    	def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id asc",[app])
    	     	 for(int ig=0;ig<applicationDocumentInstance.size();ig++){
    	     		def boolCheck=false
    	     		if(listDoc.size()==0){
    	     			listDoc.add(applicationDocumentInstance.get(ig))
    	     		}
    	     		for(int intCheck=0;intCheck<listDoc.size();intCheck++){
    	     			if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
    	     				boolCheck=true
    	     			}
    	     		}
    	     		if(boolCheck==false){
    	     			listDoc.add(applicationDocumentInstance.get(ig))
    	     		}
    	     		
    	     	}
    	    	return [appDetId:params.id,docList:docList,uploadedDocList:listDoc]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def docSel = {
    	 try {
    	    	if(params['cont']!="yes"){
    	    		render(template:"tempDocNew")
    	    	}else{
    	    		render(template:"blank")
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
    
    def applyConsent = {
    	 try {
    	    	if(session.indUser){
    	    		def indUserIns = (IndUser)(session.indUser)
    	        	def abc = IndUser.get(indUserIns.id)
    	        	def industryRegMasterInstance = abc.industryRegMaster
    	        	def ecDetInst = EcCrzDetails.findByLicenceNo(industryRegMasterInstance.indRegNum)
    	        	def ec = false
    	        	if(ecDetInst){
    	        		
    	        		ec = true
    	        		return [ ec : ec,ecType:ecDetInst.type,ecNum:ecDetInst.ecNo,ecDate:ecDetInst.issueDate ]
    	        	}
    	    		return [ ec : ec ]
    	    	}else{
    	    		redirect(view:'./index')
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
    
    def viewFile = {
    	def docType = params.docType
    	def application = params.appliLoc
    	def docName = params.docName
    	def fileLoc
    	def file
    	def docFName = docName.replace(" ","_")
    	WildCardFileFilter abc = new WildCardFileFilter()
    	String path = abc.getFile("SPCB_DOCUMENTS//"+application,docFName);
    	try{
    			file = new File(path)
    			response.setContentType("application/octet-stream")
    			response.setHeader("Content-Disposition","attachment;filename=\""+file.getName+"\"" )
                response.outputStream << file.newInputStream() // Performing a binary stream copy
    	}catch(Exception e) {
            e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
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
    		 
    		 println("viewFileNew--params->"+params)
    		/*	def application = params.id
    			def docName = params.docName
    			   def appId=IndApplicationDetails.get((params.id).toInteger())
    			    def fileDownLoad = ApplicationDocuments.find("from ApplicationDocuments apd where apd.indApplication.id=? and apd.level=? order by apd.id desc",[application.toLong(),docName])
    				println("fileDownLoad "+fileDownLoad)
    				if(fileDownLoad){
    					println("fileDownLoad id "+fileDownLoad.id)
    					if(fileDownLoad.extension=="pdf" || fileDownLoad.extension=="PDF"){
    					println("fileDownLoad pdf format---")
    					render (view: "viewFileNew", model:[fileDownLoad:fileDownLoad]) 
    				}else{
    					println("fileDownLoad not pdf format---")
    					def applicationFileSingleInstance=fileDownLoad
    					response.setContentType( "application-xdownload")
    					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
    					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
    					}		
    				}
    				else{
    	        		flash.message = "No Document Found";
    	        		redirect(controller:'indUser',action:'openIndustryHome')
    	        	}*/
    		 
    		 
    		 
    	    	def docType = params.docType
    	    	def application = params.appliLoc
    	    	def indApplInstance=IndApplicationDetails.get((params.appliLoc).toInteger())
    	    	def docName = params.docName
    	    	def fileLoc
    	    	def file
    	    	def docFName = docName.replace(" ","_")
    	    	def applicationDocumentL=ApplicationDocuments.findAll("from ApplicationDocuments apd where apd.indApplication=? and apd.level=? order by apd.id desc",[indApplInstance,docName],[max:1] )
    	    	def singleInstanceOfApplicationDocument=applicationDocumentL[0]
    	    	response.setContentType( "application-xdownload")
    	    	 response.setHeader("Content-Disposition","attachment;filename=\""+singleInstanceOfApplicationDocument.name+"\"" )
    	    	response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveDocs_old={
    	 try {
    		 println("inside saveDocs"+params)
    	    	def app = IndApplicationDetails.get((params.indAppId).toInteger())
    	    	String apliId = (app.id).toString()
    	    	def extn
    	    	def docList 
    	    	def appfor=app.applicationFor
    	    	def appType=app.applicationType
    	    	def hazardeousType=app.hazardeousType
    	    	if(hazardeousType=="HWM"){
    	    		if(app.applicationType=="CTO" && appfor=="both"){
    	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor!='CTE' and applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and consentFor='new'")
    	    		}else if(app.applicationType=="CTE" && appfor=="both"){
    	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor!='CTO' and applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and consentFor='new'")
    	    		}else{
    	    			if(app.applicationType=="CTE"){
    	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTE','Authorization') and applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and consentFor=? ",[appfor])
    	    			}else{
    	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTO','Authorization') and applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and consentFor=? ",[appfor])
        	    		}
    	    			} 
    	    		}else{
        	    		if(app.applicationType=="CTO" && appfor=="both"){
            	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor='CTO' and applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and consentFor='new' and applicationFor !='Authorization' ")
            	    		}else if(app.applicationType=="CTE" && appfor=="both"){
            	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor='CTE' and applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and consentFor='new' and applicationFor !='Authorization' ")
            	    		}else{
            	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where  applicationFor!='BMW Fresh' and  applicationFor!='BMW Renew' and applicationFor=? and consentFor=? and applicationFor!='Authorization' ",[appType,appfor])
                	    	}	
        	    		println("Otside HWM"+docList)
        	    	}
    	    	 MultipartFile multi
    	            for(int i=0;i<docList.size();i++){
    	             def fileUpload = new ApplicationDocuments()
    	            	def f = request.getFile((docList.get(i)).document)
    	            	if(!f.empty){
    	            		def applicationDocumentInstance = ApplicationDocuments.find("from ApplicationDocuments abc where abc.level=? and abc.indApplication=?",[(docList.get(i)).toString(),app])
    	    				if(applicationDocumentInstance)
    	    	        	{
    	    	        	   applicationDocumentInstance.delete()
    	    	        	}
    	            	multi = request.getFile( (docList.get(i)).document)
    	            	fileUpload.size = multi.getSize() / 1024
    	            	fileUpload.level=docList.get(i)
    	                fileUpload.data=multi.getBytes() 
    	                fileUpload.extension = extractExtension( multi )
    	                def abc = ((docList.get(i)).document).replace(" ","_")
    		            	def b = abc+"."+extractExtension( multi )
    		            	fileUpload.name =b
    	        	    fileUpload.indApplication=app  
    	             	if(fileUpload.save()) {
    	             		render(view: 'saveDocs', model: [app:app])
    	        	        } else {
    	        	    	 }
    	                }
    	             }
    		// redirect(action:popUploadDoc,id:app.id)
    			 render(view:'saveDocs', model: [app:app])
    	      }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveDocs={
   	 try {
   		 println("inside saveDocs"+params)
   	    	def app = IndApplicationDetails.get((params.indAppId).toInteger())
   	    	String apliId = (app.id).toString()
   	    	def extn
   	    	def docList 
   	    	def appfor=app.applicationFor
   	    	def appType=app.applicationType
   	    	def hazardeousType=app.hazardeousType
   	    	if(app.applicationType=="CTO" && appfor=="both"){

    			if(app.certificateFor=="new"){
    				 println("inside CTO new...")
    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Fresh' and consentFor='new'")
    			 println("inside CTO new..docList."+docList)
    			}else if(app.certificateFor=="reNew"){
    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Renew' and consentFor='new'")
    			}else{
    				 println("inside CTO new..other.")
    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Expansion' and consentFor='new'")
    			}
    			
    		}else if(app.applicationType=="CTE" && appfor=="both"){
    			if(app.certificateFor=="new"){
    				 println("inside CTE new...")
    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor='new'")
    			 println("inside CTE new..docList."+docList)
    			}else if(app.certificateFor=="reNew"){
    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Renew' and consentFor='new'")
    			}else{
    				 println("inside CTE new..other46456.")
    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Expansion' and consentFor='new'")
    			}
    			}else{
    			if(app.applicationType=="CTE"){

	    			if(app.certificateFor=="new"){
	    				 println("inside CTE new...")
	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor=? ",[appfor])
	    			 println("inside CTE new..docList."+docList)
	    			}else if(app.certificateFor=="reNew"){
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Renew' and consentFor=? ",[appfor])
	    			}else{
	    				 println("inside CTE new..other.5654")
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Expansion' and consentFor=? ",[appfor])
	    			}
	    			
    				
    			//docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTE Fresh','CTE Renew''CTE Expansion''Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and consentFor=? ",[appfor])
    			}else{

	    			if(app.certificateFor=="new"){
	    				 println("inside CTO new...")
	    			docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Fresh' and consentFor=? ",[appfor])
	    			 println("inside CTO new..docList."+docList)
	    			}else if(app.certificateFor=="reNew"){
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Renew' and  consentFor=? ",[appfor])
	    			}else{
	    				 println("inside CTO new..other.")
	    				docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTO Expansion' and  consentFor=? ",[appfor])
	    			}        	    			
	    		
    				//docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor IN ('CTO','Authorization') and applicationFor!='BMW Fresh' and applicationFor!='BMW Renew' and  consentFor=? ",[appfor])
	    		}
    			} 
   		println("Otside docList"+docList)
   	    	 MultipartFile multi
   	            for(int i=0;i<docList.size();i++){
   	             def fileUpload = new ApplicationDocuments()
   	            	def f = request.getFile((docList.get(i)).document)
   	            	if(!f.empty){
   	            		def applicationDocumentInstance = ApplicationDocuments.find("from ApplicationDocuments abc where abc.level=? and abc.indApplication=?",[(docList.get(i)).toString(),app])
   	    				if(applicationDocumentInstance)
   	    	        	{
   	    	        	   applicationDocumentInstance.delete()
   	    	        	}
   	            	multi = request.getFile( (docList.get(i)).document)
   	            	fileUpload.size = multi.getSize() / 1024
   	            	fileUpload.level=docList.get(i)
   	                fileUpload.data=multi.getBytes() 
   	                fileUpload.extension = extractExtension( multi )
   	                def abc = ((docList.get(i)).document).replace(" ","_")
   		            	def b = abc+"."+extractExtension( multi )
   		            	fileUpload.name =b
   	        	    fileUpload.indApplication=app  
   	             	if(fileUpload.save()) {
   	             		println("fileUpload---"+fileUpload)
   	             		println("app---"+app)
   	             		render(view: 'saveDocs', model: [app:app])
   	        	        } else {
   	        	    	 }
   	                }
   	             }
   		// redirect(action:popUploadDoc,id:app.id)
   			 render(view:'saveDocs', model: [app:app])
   	      }catch(Exception e) {
   	            e.printStackTrace();
   				 flash.message = "Server Busy ..Please try after some time....";
   				if(session.indUser){
   			redirect(controller:'indUser',action:'openIndustryHome')
   	 }
   	 else if(session.userMaster){
   	  redirect(controller:'userMaster',action:'openSpcbHome');
   	 }else{
   	        session.invalidate()
   	        redirect(uri:'/index.gsp');
   	 }
   	   }
   }
   
    
    //  Added by deepak for Other Document uploaded  
    
    def saveMoreDocs = {
    	println(" params in saveMoreDocs"+params)
    	try {
	def app = IndApplicationDetails.get((params.app).toInteger())
	String apliId = (app.id).toString()
	def extn
	def docList = DocumentChecklistMaster.list()
	def other = params.otherDoc
	
    	MultipartFile multi
    	def fileUpload = new ApplicationDocuments()
		def otherDoc = request.getFile("otherDoc")
          	if(!otherDoc.empty){
          		
          	multi = request.getFile("otherDoc")
          	fileUpload.size = multi.getSize() / 1024
          	fileUpload.level=params.other
              
              fileUpload.data=multi.getBytes() 
              fileUpload.extension = extractExtension( multi )
              def abc = ("otherDoc").replace(" ","_")
	          def b = abc+"."+extractExtension( multi )
	          fileUpload.name =b
      	    println("ffff------"+multi.getSize())
	         /* if(multi.getSize()>512000){
      	    	flash.message="File should be less then 500 KB"
      	    	render(view: 'saveDocs', model: [app:app])
      	    }else{*/
      	    	fileUpload.indApplication=app  
           	
              if(fileUpload.save()) {
            	  println(" file saved saveMoreDocs"+fileUpload)
            	  flash.message="Document Uploaded Successfully"
            	  render(view: 'saveDocs', model: [app: app])
      	       } 
      	    	
      	  //  }
               
          	}
           
          	else {
   	    	   flash.message="Please Upload document"
   	          render(view: 'saveDocs', model: [app: app,other:params.other])
   	          }
        	
	}catch(Exception e) {
        //e.printStackTrace();
		 flash.message = "Server Busy. Please try after sometime....";
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
//                         END 
  
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
    
    def viewFormPdf={
    		 try {
    			    println("AAAA-----"+params);
    		     	def applicationFileInstance
    	  	    	def fileVer=(params.verValue)
    	  	    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
    	  	    	def sessValue=(session.indUser).toString()
    	    	   def formView
    	    	   FormPdf form=new FormPdf()
    		     if(session.indUser){
    		    	 println("--inside in session --"+sessValue)
    	  	    	if(fileVer=="air"){
    	  	    		 applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='FormAir' order by afr.id desc",[application],[max:1])
    	  	    		applicationFileInstance[0].delete();
    	  	    		form.formAir(application.id,sessValue)
    	    	    	formView="air"
    	  	    	}else {
    	  	    		 applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='FormWater' order by afr.id desc",[application],[max:1])
    	  	    		 if(applicationFileInstance){
    	  	    			applicationFileInstance[0].delete()
    	  	    			form.formWaterPdf(application.id,sessValue)
    	    	    	    formView="water"
    	  	    		 }
    	  	    		 else
    	  	    		 {
    	  	    			applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='AutoReNewForm' order by afr.id desc",[application],[max:1])
       	  	    		 
    	  	    		 }
    	  	    		
    	  	    	}}
    		     	if(fileVer=="air"){
   	  	    		 applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='FormAir' order by afr.id desc",[application],[max:1])
   	  	    	}else {
   	  	    		 applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='FormWater' order by afr.id desc",[application],[max:1])
   	  	    		 if(!applicationFileInstance)
   	  	    		 {
   	  	    			applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='AutoReNewForm' order by afr.id desc",[application],[max:1])
      	  	    		 
   	  	    		 }
   	  	    	}
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
    
    def doShow = {}
    
    def error = {}
   
    def saveWaterSolidWasteGen= {
    		 try {
    		       def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def waterSolidWasteGenDetailsInst = new WaterSolidWasteGenDetails()
    	        	waterSolidWasteGenDetailsInst.description = params.description
    	        	waterSolidWasteGenDetailsInst.quantQual = params.quantity
    	        	waterSolidWasteGenDetailsInst.meathodCollection = params.methodCollection
    	        	def waterDisp = WaterDisposalModeMaster.get((params.methodDisposal).toInteger())
    	        	waterSolidWasteGenDetailsInst.meathodDisposal = waterDisp
    	        	waterSolidWasteGenDetailsInst.application = app
    	        	waterSolidWasteGenDetailsInst.save()
    	        	redirect(action:popWaterSolidWasteAdd,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }   
    
    def editWaterSolidDispos= {
    		 try {
    		       def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def wastersolidDetails = WaterSolidWasteGenDetails.get((params.delete).toInteger())
    	        		wastersolidDetails.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def wastersolidDetails = WaterSolidWasteGenDetails.get((params.delete[i]).toInteger())
    	            		wastersolidDetails.delete()
    	        		}
    	        	}
    	        	redirect(action:popWaterSolidWasteEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def  popWaterSolidWasteView = {
    		 try {
    		       def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterSolidWasteGenList = WaterSolidWasteGenDetails.findAllByApplication(app)
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
    
    def popWaterSolidWasteEdit = {
    		 try {
    		       def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterSolidWasteGenList = WaterSolidWasteGenDetails.findAllByApplication(app)
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
    
    def popEstimetedDetailsAdd = {
    		 try {
    		       def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def costDetailsList = IndExpenditureCostDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,costDetailsList:costDetailsList]
    	      }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        def popEstimetedDetailsView = {
    		 try {
    		       def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def costDetailsList = IndExpenditureCostDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,costDetailsList:costDetailsList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        def popEstimetedDetailsEdit = {
    		 try {
    		      def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def costDetailsList = IndExpenditureCostDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,costDetailsList:costDetailsList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popHazardousChemicalAdd = {
    		 try {
    		      def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hazList = HazardousChemicalDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,hazList:hazList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        def popHazardousChemicalEdit = {
    		 try {
    		       def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hazList = HazardousChemicalDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,hazList:hazList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        def popHazardousChemicalView = {
    		 try {
    		       def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hazList = HazardousChemicalDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,hazList:hazList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

        def saveHazardousChemical = 
        {
    		 try {
    		       def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def hazList=HazardousChemicalDetails.findAll("from HazardousChemicalDetails abcd where abcd.application=?",[app])
    	        	if(hazList)
    	        	{
    	        		flash.message="Details already exist!!!"
    	        		redirect(action:popHazardousChemicalAdd,id:app)
    	        	}
    	        	else
    	        	{
    	        	if((params.isolatedStorage).getClass().getName()== "java.lang.String")
    	        	{
    	        		def stackDetInst = new HazardousChemicalDetails(params)
    	        		stackDetInst.application = app
    	        		stackDetInst.save()
    	        	}
    	        	flash.message = "Details Saved"
    	                redirect(action:popHazardousChemicalAdd,id:app)
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
        
        def editHazardousChemical = {
    		 try {
    		       def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def stackDetInst = HazardousChemicalDetails.get((params.delete).toInteger())
    	        		stackDetInst.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        			for(int i=0;i<(params.delete).size();i++)
    	        			{
    	        			def stackDetInst = HazardousChemicalDetails.get((params.delete[i]).toInteger())
    	            		stackDetInst.delete()
    	        			}
    	        	}
    	        	redirect(action:popHazardousChemicalEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        
    def popHazardActivityGenDetailsAdd = {
    		 try {
    		      def app = IndApplicationDetails.get((params.id).toInteger())
    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetails.findAllByApplication(app)
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

    		def popHazardActivityGenDetailsView = {
    		 try {
    		     def app = IndApplicationDetails.get((params.id).toInteger())
    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetails.findAllByApplication(app)
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

    		def popHazardActivityGenDetailsEdit = {
    		 try {
    		     def app = IndApplicationDetails.get((params.id).toInteger())
    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetails.findAllByApplication(app)
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

 def saveHazardGenDetails = {
    		 try {
    		       def app = IndApplicationDetails.get((params.appId).toInteger())
    	    		if((params.quantity).getClass().getName()== "java.lang.String"){
    	    			def hazardousWasteGenDetailsInst = new HazardousWasteGenDetails(params)
    	    		def hazarName = params.categoryName.id
    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetails.findByApplication(app)
    	    		def harardName = HazardousWasteGenDetails.findAll("from HazardousWasteGenDetails indPower where indPower.categoryName.id=? and indPower.application=?",[hazarName.toLong(),app])
    	    		
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
    	    		redirect(action:popHazardActivityGenDetailsAdd,id:app)
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
    
    		def deleteHazardGenDetails = {
    		 try {
    	    		def app = IndApplicationDetails.get((params.appId).toInteger())
    	    		if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetails.get((params.delete).toInteger())
    	    		hazardousWasteGenDetailsInst.delete()
    	    		}else{
    	    		if(params.delete)
    	    		for(int i=0;i<(params.delete).size();i++){
    	    		def hazardousWasteGenDetailsInst = HazardousWasteGenDetails.get((params.delete[i]).toInteger())
    	    		hazardousWasteGenDetailsInst.delete()
    	    		}
    	    		}
    	    		redirect(action:popHazardActivityGenDetailsEdit,id:app)
    		 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

  def popStorageDisposalDetailsAdd = {
    		 try {
    	    		def app = IndApplicationDetails.get((params.id).toInteger())
    	    		def hazarWasteGenDetailsList = HazardousWasteGenDetails.findAllByApplication(app)
    	    		def hazardousWasteStorDisDetailsList = HazardousWasteStorDisDetails.findAllByApplication(app)
    	    		return [appDetId:params.id,hazardousWasteStorDisDetailsList:hazardousWasteStorDisDetailsList,hazarWasteGenDetailsList:hazarWasteGenDetailsList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

    		def popStorageDisposalDetailsView = {
    		 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    		def hazardousWasteStorDisDetailsList = HazardousWasteStorDisDetails.findAllByApplication(app)
    	    		return [appDetId:params.id,hazardousWasteStorDisDetailsList:hazardousWasteStorDisDetailsList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

    		def popStorageDisposalDetailsEdit = {
    		 try {
    	    	def app = IndApplicationDetails.get((params.id).toInteger())
    	    		def hazardousWasteStorDisDetailsList = HazardousWasteStorDisDetails.findAllByApplication(app)
    	    		return [appDetId:params.id,hazardousWasteStorDisDetailsList:hazardousWasteStorDisDetailsList]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveStorageDisposalDetails = {
    		 try {
    	    		def app = IndApplicationDetails.get((params.appId).toInteger())
    	    		if((params.totalQuantity).getClass().getName()== "java.lang.String"){
    	    			def hazardousWasteStorDisDetailsInst = new HazardousWasteStorDisDetails(params)
    	    			hazardousWasteStorDisDetailsInst.application = app
    	    		def hazarName = params.hazardName
    	    		def categoryList = HazardousCategoryMaster.findByName(hazarName)
    	    		hazardousWasteStorDisDetailsInst.categoryName = categoryList.category
    	    		hazardousWasteStorDisDetailsInst.save()
    	    		}
    	    		flash.message = "Details Saved"
    	    		redirect(action:popStorageDisposalDetailsAdd,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    		def deleteStorageDisposalDetails = {
    		 try {
    	    		def app = IndApplicationDetails.get((params.appId).toInteger())
    	    		if((params.delete).getClass().getName()== "java.lang.String"){
    	    		def hazardousWasteStorDisDetailsInst = HazardousWasteStorDisDetails.get((params.delete).toInteger())
    	    		hazardousWasteStorDisDetailsInst.delete()
    	    		}else{
    	    		if(params.delete)
    	    		for(int i=0;i<(params.delete).size();i++){
    	    		def hazardousWasteStorDisDetailsInst = HazardousWasteStorDisDetails.get((params.delete[i]).toInteger())
    	    		hazardousWasteStorDisDetailsInst.delete()
    	    		}
    	    		}
    	    		redirect(action:popStorageDisposalDetailsEdit,id:app)
    		 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popDGsetAdd = 
	{
    		 try {
    	    		def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def DGList = DGSetDetails.findAllByApplication(app)
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
    
    def popDGsetEdit = 
    {
    		 try {
    	    		def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def DGList = DGSetDetails.findAllByApplication(app)
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
    
    def popDGsetView = 
    {
    		 try {
    	    		def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def DGList = DGSetDetails.findAllByApplication(app)
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

    def saveDGset = 
    {
    		 try {
    	    		def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def DGList=DGSetDetails.findAll("from DGSetDetails abcd where abcd.application=?",[app])
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
    	        		def dgInst = new DGSetDetails(params)
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
    	        	}else if(x>50 && x<=100) {
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
    	                redirect(action:popDGsetAdd,id:app)
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
    
    def editDGset = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	if((params.delete).getClass().getName()== "java.lang.String"){
    		    		def dgInst = DGSetDetails.get((params.delete).toInteger())
    		    		dgInst.delete()
    		    	}
    		    	else
    		    	{
    		    		if(params.delete)
    		    			for(int i=0;i<(params.delete).size();i++)
    		    			{
    		    			def stackDetInst = DGSetDetails.get((params.delete[i]).toInteger())
    		        		stackDetInst.delete()
    		    			}
    		    	}
    		    	redirect(action:popDGsetEdit,id:app)
    		    }catch(Exception e) {
    		            e.printStackTrace();
    					 flash.message = "Server Busy ..Please try after some time....";
    					if(session.indUser){
    				redirect(controller:'indUser',action:'openIndustryHome')
    		 }
    		 else if(session.userMaster){
    		  redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    		        session.invalidate()
    		        redirect(uri:'/index.gsp');
    		 }
    		   }
    }

def popDGSourceAdd = 
	{
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def DGList = DGSetEmissionDetails.findAllByApplication(app)
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
    
    def popDGSourceEdit = 
    {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def DGList = DGSetEmissionDetails.findAllByApplication(app)
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
    
    def popDGSourceView = 
    {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def DGList = DGSetEmissionDetails.findAllByApplication(app)
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

    def saveDGSource = 
    {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	def DGList=DGSetEmissionDetails.findAll("from DGSetEmissionDetails abcd where abcd.application=?",[app])
    		    	if((params.source).getClass().getName()== "java.lang.String")
    		    	{
    		    		def dgInst = new DGSetEmissionDetails(params)
    		    		dgInst.application = app
    		    		dgInst.save()
    		        	flash.message = "Details Saved"
    		            redirect(action:popDGSourceAdd,id:app)
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
    
    def editDGSource = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	if((params.delete).getClass().getName()== "java.lang.String"){
    		    		def dgInst = DGSetEmissionDetails.get((params.delete).toInteger())
    		    		dgInst.delete()
    		    	}
    		    	else
    		    	{
    		    		if(params.delete)
    		    			for(int i=0;i<(params.delete).size();i++)
    		    			{
    		    			def stackDetInst = DGSetEmissionDetails.get((params.delete[i]).toInteger())
    		        		stackDetInst.delete()
    		    			}
    		    	}
    		    	redirect(action:popDGSourceEdit,id:app)
    		    }catch(Exception e) {
    		            e.printStackTrace();
    					 flash.message = "Server Busy ..Please try after some time....";
    					if(session.indUser){
    				redirect(controller:'indUser',action:'openIndustryHome')
    		 }
    		 else if(session.userMaster){
    		  redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    		        session.invalidate()
    		        redirect(uri:'/index.gsp');
    		 }
    		   }
    }

def popDGParameterAdd = 
	{
    		 try {
    		    	def d = params.d
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def dgList = DGSetParameterDetails.findAllByApplication(app)
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
    
    def popDGParameterView = 
    {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def dgList = DGSetParameterDetails.findAllByApplication(app)
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
    
    def popDGParameterEdit = 
    {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def dgList = DGSetParameterDetails.findAllByApplication(app)
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
	
	def saveDGParameter = 
	{
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	def dgInstance = new DGSetParameterDetails()
    		    	def parameters = params.parameters
    		    	def dgList = DGSetParameterDetails.findAll("from DGSetParameterDetails abc where abc.parameters=? and abc.application=?",[parameters,app])
    		    	if(parameters=="Not Selected")
    		    	{
    		    		flash.message = "Please Select Parameters"
    		        	redirect(action:popDGParameterAdd,id:app,params:[dgInstance:dgInstance])
    		    	}
    		    	else if(dgList)
    		    	{
    		    		flash.message = "D.G. Set Parameter details regarding ${parameters} already exists"
    		    		redirect(action:popDGParameterAdd,id:app,params:[dgInstance:dgInstance])
    		    	}
    		    	else
    		    	{
    		    		dgInstance.parameters = params.parameters
    		    		dgInstance.noLoad = params.noLoad
    		    		dgInstance.fullLoad = params.fullLoad 
    		    		dgInstance.application = app
    		        	dgInstance.save()
    		        	redirect(action:popDGParameterAdd,id:app,params:[dgInstance:dgInstance])
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
	
	def editDGParameter = 
	{
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	if((params.delete).getClass().getName()== "java.lang.String"){
    		    		def indCostDetInst = DGSetParameterDetails.get((params.delete).toInteger())
    		    		indCostDetInst.delete()
    		    	}else{
    		    		if(params.delete)
    		        	for(int i=0;i<(params.delete).size();i++){
    		        		def indCostDetInst = DGSetParameterDetails.get((params.delete[i]).toInteger())
    		        		indCostDetInst.delete()
    		        	}
    		    	}
    		    	redirect(action:popDGParameterEdit,id:app)
    		     }catch(Exception e) {
    		            e.printStackTrace();
    					 flash.message = "Server Busy ..Please try after some time....";
    					if(session.indUser){
    				redirect(controller:'indUser',action:'openIndustryHome')
    		 }
    		 else if(session.userMaster){
    		  redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    		        session.invalidate()
    		        redirect(uri:'/index.gsp');
    		 }
    		   }
	}

    def popBrickKilnAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def brickList = BrickKilnDetail.findAllByApplication(app)
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
        
        def popBrickKilnEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def brickList = BrickKilnDetail.findAllByApplication(app)
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
        
        def popBrickKilnView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def brickList = BrickKilnDetail.findAllByApplication(app)
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

        def saveBrickKilnDetail = 
        {
    		 try {
    		    def app = IndApplicationDetails.get((params.appId).toInteger())
             	def airMiscDetailsInst = new BrickKilnDetail(params)
         		def dgList = BrickKilnDetail.findAll("from BrickKilnDetail abc where abc.application=?",[app])
             	if(dgList)
             	{
             		flash.message = "Brick Kiln details already exists"
             		redirect(action:popBrickKilnAdd,id:app,params:[airMiscDetailsInst:airMiscDetailsInst])
             	}
             	else
             	{
             		airMiscDetailsInst.application = app
             		airMiscDetailsInst.save()
     	        	redirect(action:popBrickKilnAdd,id:app,params:[airMiscDetailsInst:airMiscDetailsInst])
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
    
        def editBrickKilnDetail = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def airMiscDetInst = BrickKilnDetail.get((params.delete).toInteger())
    	        		airMiscDetInst.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        			for(int i=0;i<(params.delete).size();i++)
    	        			{
    	        			def airMiscDetInst = BrickKilnDetail.get((params.delete[i]).toInteger())
    	            		airMiscDetInst.delete()
    	        			}
    	        	}
    	        	redirect(action:popBrickKilnEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popStoneSittingCriteriaAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneSittingCriteriaList = StoneCrusherSittingCriteria.findAllByApplication(app)
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
    
    def  popStoneSittingCriteriaView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneSittingCriteriaList = StoneCrusherSittingCriteria.findAllByApplication(app)
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
    
    def popStoneSittingCriteriaEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneSittingCriteriaList = StoneCrusherSittingCriteria.findAllByApplication(app)
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
    
    def saveStoneSittingCriteria = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def stoneSittingCriteriaInst = new StoneCrusherSittingCriteria()
    	        	def par = StoneCrusherParameterMaster.get((params.parameter).toInteger())
    	        	def dgList = StoneCrusherSittingCriteria.findAll("from StoneCrusherSittingCriteria abc where abc.parameter=? and abc.application=?",[par,app])
    	        	if(dgList)
    	        	{
    	        		flash.message = "Stone Sitting Criteria Details regarding ${par.toString()} already exists"
    	        		redirect(action:popStoneSittingCriteriaAdd,id:app,params:[stoneSittingCriteriaInst:stoneSittingCriteriaInst])
    	        	}
    	        	else
    	        	{
    	        		flash.message = "Stone Sitting Criteria Details regarding ${par.toString()} is saved"
    	            	stoneSittingCriteriaInst.application = app
    	            	stoneSittingCriteriaInst.parameter = par
    	            	stoneSittingCriteriaInst.distance = params.distance
    	            	stoneSittingCriteriaInst.save()
    	            	redirect(action:popStoneSittingCriteriaAdd,id:app)
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
    
    def editStoneSittingCriteria= {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String")
    	        	{
    	        		def stoneSittingCriteriaInst = StoneCrusherSittingCriteria.get((params.delete).toInteger())
    	        		stoneSittingCriteriaInst.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++)
    	        		{
    	        			def stoneSittingCriteriaInst = StoneCrusherSittingCriteria.get((params.delete[i]).toInteger())
    	            		stoneSittingCriteriaInst.delete()
    	        		}
    	        	}
    	        	redirect(action:popStoneSittingCriteriaEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

    def popBrickSittingCriteriaAdd = {
    		 try {
    		   def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def brickSittingCriteriaList = BrickSittingCriteriaDetails.findAllByApplication(app)
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
    
    def  popBrickSittingCriteriaView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def brickSittingCriteriaList = BrickSittingCriteriaDetails.findAllByApplication(app)
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
    
    def popBrickSittingCriteriaEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def brickSittingCriteriaList = BrickSittingCriteriaDetails.findAllByApplication(app)
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
    
    def saveBrickSittingCriteria = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def brickSittingCriteriaInst = new BrickSittingCriteriaDetails()
    	        	def par = StoneCrusherParameterMaster.get((params.parameter).toInteger())
    	        	def dgList = BrickSittingCriteriaDetails.findAll("from BrickSittingCriteriaDetails abc where abc.parameter=? and abc.application=?",[par,app])
    	        	if(dgList)
    	        	{
    	        		flash.message = "Brick Sitting Criteria Details regarding ${par.toString()} already exists"
    	        		redirect(action:popBrickSittingCriteriaAdd,id:app,params:[brickSittingCriteriaInst:brickSittingCriteriaInst])
    	        	}
    	        	else
    	        	{
    	        		flash.message = "Brick Sitting Criteria Details regarding ${par.toString()} is saved"
    	            	brickSittingCriteriaInst.application = app
    	            	brickSittingCriteriaInst.parameter = par
    	            	brickSittingCriteriaInst.distance = params.distance
    	            	brickSittingCriteriaInst.save()
    	            	redirect(action:popBrickSittingCriteriaAdd,id:app)
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
    
    def editBrickSittingCriteria= {
    		 try {
    		    def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String")
    	        	{
    	        		def brickSittingCriteriaInst = BrickSittingCriteriaDetails.get((params.delete).toInteger())
    	        		brickSittingCriteriaInst.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++)
    	        		{
    	        			def brickSittingCriteriaInst = BrickSittingCriteriaDetails.get((params.delete[i]).toInteger())
    	            		brickSittingCriteriaInst.delete()
    	        		}
    	        	}
    	        	redirect(action:popBrickSittingCriteriaEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
   
    def popStoneCrusherControlDevicesAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneSittingCriteriaList = StoneCrusherControlDevices.findAllByApplication(app)
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
    
    def  popStoneCrusherControlDevicesView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneSittingCriteriaList = StoneCrusherControlDevices.findAllByApplication(app)
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
    
    def popStoneCrusherControlDevicesEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneSittingCriteriaList = StoneCrusherControlDevices.findAllByApplication(app)
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
    
    def saveStoneCrusherControl = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def stoneSittingCriteriaInst = new StoneCrusherControlDevices()
    	        	def par = StoneCrusherControlDevicesMaster.get((params.device).toInteger())
    	        	def dgList = StoneCrusherControlDevices.findAll("from StoneCrusherControlDevices abc where abc.device=? and abc.application=?",[par,app])
    	        	if(dgList)
    	        	{
    	        		flash.message = "Stone Crusher Pollution Control Devices Details regarding ${par.toString()} already exists"
    	        		redirect(action:popStoneCrusherControlDevicesAdd,id:app,params:[stoneSittingCriteriaInst:stoneSittingCriteriaInst])
    	        	}
    	        	else
    	        	{
    	        		flash.message = "Stone Crusher Pollution Control Devices Details regarding ${par.toString()} is saved"
    	            	stoneSittingCriteriaInst.application = app
    	            	stoneSittingCriteriaInst.device = par
    	            	stoneSittingCriteriaInst.name = params.name
    	            	stoneSittingCriteriaInst.status = params.status
    	            	stoneSittingCriteriaInst.save()
    	            	redirect(action:popStoneCrusherControlDevicesAdd,id:app)
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
    
    def editStoneCrusherControl= {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String")
    	        	{
    	        		def stoneSittingCriteriaInst = StoneCrusherControlDevices.get((params.delete).toInteger())
    	        		stoneSittingCriteriaInst.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++)
    	        		{
    	        			def stoneSittingCriteriaInst = StoneCrusherControlDevices.get((params.delete[i]).toInteger())
    	            		stoneSittingCriteriaInst.delete()
    	        		}
    	        	}
    	        	redirect(action:popStoneCrusherControlDevicesEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

    def popHotelFacilityAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	            	def hotelFacilitylist = HotelFacilityDetail.findAllByApplication(app)
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
    
        def saveHotelFacilityDetail = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	    		def hotelFacilityInst = new HotelFacilityDetail(params)
    		    	def hotelFacilityMasterInst = HotelFacilityMaster.get(params.facility.id)
    		    	def facilityId = params.facility.id
    	    		def facilityTypeList = params.hotelFacilityType.id
    	    		def hotelFacilitylist = HotelFacilityDetail.findAll("from HotelFacilityDetail abc where abc.facility.id=? and abc.hotelFacilityType.id=? and abc.application=?",[facilityId.toLong(),facilityTypeList.toLong(),app])
    	    		def name = hotelFacilitylist.facility.name
    	    		if(hotelFacilitylist)
    	    		{
    	    		flash.message = "Hotel Facility Details regarding ${name.toString()} already exists"
    	    		redirect(action:popHotelFacilityAdd,id:app,params:[hotelFacilitylist:hotelFacilitylist])
    	    		}
    	    		else
    	    		{
    	    		hotelFacilityInst.application = app
    	    		hotelFacilityInst.capacity = params.capacity
    	    		hotelFacilityInst.facilityDetail = params.facilityDetail
    	    		hotelFacilityInst.save()
    	    		redirect(action:popHotelFacilityAdd,id:app)
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
    
    def popHotelFacilityView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelFacilitylist = HotelFacilityDetail.findAllByApplication(app)
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
    
    def popHotelFacilityEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelFacilitylist = HotelFacilityDetail.findAllByApplication(app)
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
    
    def editHotelFcilityDetail = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def hotelFacilityDetail = HotelFacilityDetail.get((params.delete).toInteger())
    	        		hotelFacilityDetail.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def hotelFacilityDetail = HotelFacilityDetail.get((params.delete[i]).toInteger())
    	            		hotelFacilityDetail.delete()
    	        		}
    	        	}
    	        	redirect(action:popHotelFacilityEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }	
    }
    
    def popHotelWasteEmissionAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	            	def hotelWasteEmissionList = HotelWasteEmissionDetail.findAllByApplication(app)
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
    
        def saveHotelWasteEmissionDetail = {
    		 try {
    		   def app = IndApplicationDetails.get((params.appId).toInteger())
             	def hotelWasteEmissionInst = new HotelWasteEmissionDetail()
             	def par = HotelWasteEmissionGenerationMaster.get((params.type).toInteger())
             	def hotelWasteEmissionList = HotelWasteEmissionDetail.findAll("from HotelWasteEmissionDetail abc where abc.type=? and abc.application=?",[par,app])
            	if(hotelWasteEmissionList)
             	{
             	       flash.message = "Hotel Waste Emission Details regarding ${par.toString()} already exists"
             	        redirect(action:popHotelWasteEmissionAdd,id:app,params:[hotelWasteEmissionList:hotelWasteEmissionList])
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
                 	redirect(action:popHotelWasteEmissionAdd,id:app)
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

    def popHotelWasteEmissionView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelWasteEmissionList = HotelWasteEmissionDetail.findAllByApplication(app)
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
    
    def popHotelWasteEmissionEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelWasteEmissionList = HotelWasteEmissionDetail.findAllByApplication(app)
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
    
    def editHotelWasteEmission = {
    		 try {
    		  def app = IndApplicationDetails.get((params.appId).toInteger())
 	        	if((params.delete).getClass().getName()== "java.lang.String"){
 	        		def hotelWasteEmissionDetail = HotelWasteEmissionDetail.get((params.delete).toInteger())
 	        		hotelWasteEmissionDetail.delete()
 	        	}else{
 	        		if(params.delete)
 	        		for(int i=0;i<(params.delete).size();i++){
 	        				def hotelWasteEmissionDetail = HotelWasteEmissionDetail.get((params.delete[i]).toInteger())
 	            		hotelWasteEmissionDetail.delete()
 	        		}
 	        	}
 	        	redirect(action:popHotelWasteEmissionEdit,id:app)
 	 }catch(Exception e) {
         e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
     session.invalidate()
     redirect(uri:'/index.gsp');
}
}
    }
    
    def popHotelOtherDetailAdd = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	            def hotelOtherDetailList = HotelGeneralDetails.findAllByApplication(app)
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
    
           def saveHotelOtherDetail= {
    		 try {
    		    def app = IndApplicationDetails.get((params.appId).toInteger())
    	          def hotelOtherDetailList = HotelGeneralDetails.findAllByApplication(app)
    	          	if(hotelOtherDetailList)
    	          	{
    	          		flash.message = "Hotel ganeral details already exists"
    		        			redirect(action:popHotelOtherDetailAdd,id:app)
    	          	}
    	          	else
    	          	{      		
    	          		flash.message = "Hotel ganeral details saved"
    	           def hotelOtherDetailInst = new HotelGeneralDetails(params)
    	      		hotelOtherDetailInst.application = app
    	      		hotelOtherDetailInst.save()
    	      		redirect(action:popHotelOtherDetailAdd,id:app)
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
           
    def popHotelOtherDetailView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelOtherDetailList = HotelGeneralDetails.findAllByApplication(app)
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
    
    def popHotelOtherDetailEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelOtherDetailList = HotelGeneralDetails.findAllByApplication(app)
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
    
    def editHotelOtherDetail = {
    		 try {
    		   def app = IndApplicationDetails.get((params.appId).toInteger())
 	        	if((params.delete).getClass().getName()== "java.lang.String"){
 	        		def hotelGeneralDetails = HotelGeneralDetails.get((params.delete).toInteger())
 	        		hotelGeneralDetails.delete()
 	        	}else{
 	        		if(params.delete)
 	        		for(int i=0;i<(params.delete).size();i++){
 	        			def hotelGeneralDetails = HotelGeneralDetails.get((params.delete[i]).toInteger())
 	            		hotelGeneralDetails.delete()
 	        		}
 	        	}
 	        	redirect(action:popHotelOtherDetailEdit,id:app)
 	 }catch(Exception e) {
         e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
     session.invalidate()
     redirect(uri:'/index.gsp');
}
}
    }
    
    def popHotelWaterConsumptionAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	            def hotelWaterConsumptionlist = HotelWaterConsumptionDetail.findAllByApplication(app)
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
 
    def saveHotelWaterConsumption = {
    		 try {
    		    def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def hotelWaterConsumptionInst = new HotelWaterConsumptionDetail()
    	        	def par = HotelWaterConsumptionMaster.get((params.type).toInteger())
    	        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetail.findAll("from HotelWaterConsumptionDetail abc where abc.type=? and abc.application=?",[par,app])
    	       if(hotelWaterConsumptionlist)
    	        	{
    	        	     flash.message = "Hotel Water Consumption Details regarding ${par.toString()} already exists"
    	        	       	redirect(action:popHotelWaterConsumptionAdd,id:app,params:[hotelWaterConsumptionlist:hotelWaterConsumptionlist])
    	        	}
    	        	else
    	        	{
    	        		flash.message = "Hotel Water Consumption Details regarding ${par.toString()} is saved"
    	        			hotelWaterConsumptionInst.application = app
    	        			hotelWaterConsumptionInst.type = par
    	        			hotelWaterConsumptionInst.quantity = params.quantity
    	        			hotelWaterConsumptionInst.save()
    	            	redirect(action:popHotelWaterConsumptionAdd,id:app)
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
    
    def popHotelWaterConsumptionView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetail.findAllByApplication(app)
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
    
   def popHotelWaterConsumptionEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def hotelWaterConsumptionlist = HotelWaterConsumptionDetail.findAllByApplication(app)
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
    
    def editHotelWaterConsumption = {
    		 try {
    		   def app = IndApplicationDetails.get((params.appId).toInteger())
 	        	if((params.delete).getClass().getName()== "java.lang.String"){
 	        		def hotelWaterConsumptionDetail = HotelWaterConsumptionDetail.get((params.delete).toInteger())
 	        		hotelWaterConsumptionDetail.delete()
 	        	}else{
 	        		if(params.delete)
 	        		for(int i=0;i<(params.delete).size();i++){
 	        			def hotelWaterConsumptionDetail = HotelWaterConsumptionDetail.get((params.delete[i]).toInteger())
 	            		hotelWaterConsumptionDetail.delete()
 	        		}
 	        	}
 	        	redirect(action:popHotelWaterConsumptionEdit,id:app)
 	  }catch(Exception e) {
         e.printStackTrace();
			 flash.message = "Server Busy ..Please try after some time....";
			if(session.indUser){
		redirect(controller:'indUser',action:'openIndustryHome')
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
    		   		def feeCheque=FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.additionalfee='NO'",[app])
    		   		if(feeCheque){
    		       	feeCheque.delete()
    		      	}
    		   		def file1 = new FeeChequeRecord()
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
    		    	applicationFileInstance=FeeChequeRecord.findAll("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Cheque' and afr.additionalfee='NO' order by id desc",[application],[max:1])
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
    
    def popFurnaceDetailEdit = {
    		 try {
    		    	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def furnaceDetailList = FurnaceDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,furnaceDetailList:furnaceDetailList,d:d]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        def popFurnaceDetailAdd = {
    		 try {
    		    	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def furnaceDetailList = FurnaceDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,furnaceDetailList:furnaceDetailList,d:d]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }

      def popFurnaceDetailView = {
    		 try {
    		    	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def furnaceDetailList = FurnaceDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,furnaceDetailList:furnaceDetailList,d:d]
    	       }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popBoilerDetailAdd = {
    		 try {
    		    	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def boilerDetailsList = BoilerDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,boilerDetailsList:boilerDetailsList,d:d]
    	       }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
    def popBoilerDetailView = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def boilerDetailsList = BoilerDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,boilerDetailsList:boilerDetailsList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
        def popBoilerDetailEdit = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def boilerDetailsList = BoilerDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,boilerDetailsList:boilerDetailsList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
      
    def popMiscelleneousAdd = {
    		 try {
    		    def d = params.d
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    		    	def miscelleneousList = MiscellaneousDetails.findAllByApplication(app)
    		    	return [appDetId:params.id,miscelleneousList:miscelleneousList,d:d]
    		     }catch(Exception e) {
    		            e.printStackTrace();
    					 flash.message = "Server Busy ..Please try after some time....";
    					if(session.indUser){
    				redirect(controller:'indUser',action:'openIndustryHome')
    		 }
    		 else if(session.userMaster){
    		  redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    		        session.invalidate()
    		        redirect(uri:'/index.gsp');
    		 }
    		   }
    }
    
    def popMiscellaneousEdit = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def miscelleneousList = MiscellaneousDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,miscelleneousList:miscelleneousList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
        
         def popMiscellaneousView = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def miscelleneousList = MiscellaneousDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,miscelleneousList:miscelleneousList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popWaterSourceDetailsAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneCrusherWaterReqList = StoneCrusherWaterReq.findAllByApplication(app)
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
    
    def popWaterSourceDetailsView = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneCrusherWaterReqList = StoneCrusherWaterReq.findAllByApplication(app)
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
    
    def popWaterSourceDetailsEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def stoneCrusherWaterReqList = StoneCrusherWaterReq.findAllByApplication(app)
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
    
    def popWaterConsumptionDetailAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterConsumptionDetailList = WaterConsumptionDetail.findAllByApplication(app)
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
    
    def popWaterConsumptionDetailView = {
    		 try {
    		    def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterConsumptionDetailList = WaterConsumptionDetail.findAllByApplication(app)
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
    
    def popWaterConsumptionDetailEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterConsumptionDetailList = WaterConsumptionDetail.findAllByApplication(app)
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
    
    def popWaterWasteDischargeAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterWasteDischargeList = WaterWasteDischarge.findAllByApplication(app)
    	        	return [appDetId:params.id,waterWasteDischargeList:waterWasteDischargeList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def  popWaterWasteDischargeView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterWasteDischargeList = WaterWasteDischarge.findAllByApplication(app)
    	        	return [appDetId:params.id,waterWasteDischargeList:waterWasteDischargeList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    } 
    
   def popWaterWasteDischargeEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterWasteDischargeList = WaterWasteDischarge.findAllByApplication(app)
    	        	return [appDetId:params.id,waterWasteDischargeList:waterWasteDischargeList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
} 
   
    def popWaterUsageDetailAdd = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterUsageDetailList = WaterUsageDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,waterUsageDetailList:waterUsageDetailList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
   def  popWaterUsageDetailView = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterUsageDetailList = WaterUsageDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,waterUsageDetailList:waterUsageDetailList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    } 
    
    def popWaterUsageDetailEdit = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def waterUsageDetailList = WaterUsageDetails.findAllByApplication(app)
    	        	return [appDetId:params.id,waterUsageDetailList:waterUsageDetailList]
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    } 
   
    def editFurnaceDetail = {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def furnaceDetailList = FurnaceDetails.get((params.delete).toInteger())
    	        		furnaceDetailList.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        			for(int i=0;i<(params.delete).size();i++)
    	        			{
    	        			def furnaceDetailList = FurnaceDetails.get((params.delete[i]).toInteger())
    	            		furnaceDetailList.delete()
    	        			}
    	        	}
    	        	redirect(action:popFurnaceDetailEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
   
    def saveFurnaceDetail = 
    {
    		 try {
    		    	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	def furnaceDetailList = new FurnaceDetails()
    		    	def furnaceInstalled =""
    		    	def r = params.furnaceInstalled
    		    	if(r=="No"){
    		    		furnaceInstalled=FurnaceDetails.find("from FurnaceDetails abcd where abcd.furnaceInstalled=? and abcd.application=?",[r,app])
    		    		}  		
    		    	if(furnaceInstalled)
    		        	{
    		        		flash.message="Furnace is not installed!!!"
    		        		redirect(action:popFurnaceDetailAdd,id:app)
    		        			  }
    		        else
    		        	{
    		    		String b = ""
    		        		def list =""
    		        			list = params.airPollControlDevicefurnace
    		        		if((params.furnaceInstalled=="No")){
    		        			b=""
    		        		}
    		        		else{
    		        			if(list.getClass().getName()== "java.lang.String"){
    		        				b=list
    		        			}
    		            		else{
    		        		for (String a : list)
    		       			{
    		       			    b += a + ",";
    		       			}
    		        		}
    		        		}
    		      		furnaceDetailList.furnaceInstalled=params.furnaceInstalled
    		    		furnaceDetailList.furnaceName=params.furnaceName
    		    		furnaceDetailList.prescribedParameters=params.prescribedParameters
    		    		furnaceDetailList.airPollControlDevicefurnace=b
    		    		furnaceDetailList.stackHeight=params.stackHeight
    		    		furnaceDetailList.typeOfFuel=params.typeOfFuel
    		    		furnaceDetailList.quantity=params.quantity
    		    		if(params.furnaceInstalled=="Yes"){
    		    		furnaceDetailList.unit=params.unit
    		    		}else{
    		    			furnaceDetailList.unit=""
    		    		}
    		    		furnaceDetailList.application = app
    		    		furnaceDetailList.save()
    		    	flash.message = "Details Saved"
    		            redirect(action:popFurnaceDetailAdd,id:app,furnaceDetailList:furnaceDetailList)
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
  
    def editBoilerDetail = {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def boilerDetailsList = BoilerDetails.get((params.delete).toInteger())
    	        		boilerDetailsList.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        			for(int i=0;i<(params.delete).size();i++)
    	        			{
    	        			def boilerDetailsList = BoilerDetails.get((params.delete[i]).toInteger())
    	            		boilerDetailsList.delete()
    	        			}
    	        	}
    	        	redirect(action:popBoilerDetailEdit,id:app)
    	      }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveBoilerDetail = 
    {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	def boilerDetailsList = new BoilerDetails()
    		    		def boilerInstalled
    		    		def r = params.boilerInstalled
    		    		if(r=="No"){
    		    		boilerInstalled=BoilerDetails.find("from BoilerDetails abcd where abcd.boilerInstalled=? and abcd.application=?",[r,app])
    		    		}
    		    	if(boilerInstalled)
    		        	{
    		        		flash.message="Boiler is not installed!!!"
    		        		redirect(action:popBoilerDetailAdd,id:app)
    		        			  }
    		        	else
    		        	{
    		    		String b = ""
    		            		int y =0
    		            		def list =""
    		            			list = params.airPollControlDeviceBoiler
    		            		if((params.furnaceInstalled=="No")){
    		            			b=""
    		            		}
    		            		else{
    		            			if(list.getClass().getName()== "java.lang.String"){
    		            				b=list
    		            			}
    		                		else{
    		            		for (String a : list)
    		           			{
    		           			    b += a + ",";
    		           			}
    		            		}
    		            		}
    		          	boilerDetailsList.boilerInstalled=params.boilerInstalled
    		    		boilerDetailsList.boilerName=params.boilerName
    		    		boilerDetailsList.streamCapacity=params.streamCapacity
    		    		boilerDetailsList.airPollControlDeviceBoiler=b
    		    		boilerDetailsList.stackHeight=params.stackHeight
    		    		if(params.boilerInstalled=="Yes"){
    		    		boilerDetailsList.samplingPlatform=params.samplingPlatform
    		    		}else{
    		    			boilerDetailsList.samplingPlatform=""
    		    		}
    		    		boilerDetailsList.application = app
    		    		boilerDetailsList.save()
    		    	flash.message = "Details Saved"
    		            redirect(action:popBoilerDetailAdd,id:app,boilerDetailsList:boilerDetailsList)
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
   
    def editMiscellaneous = {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def miscelleneousList = MiscellaneousDetails.get((params.delete).toInteger())
    	        		miscelleneousList.delete()
    	        	}
    	        	else
    	        	{
    	        		if(params.delete)
    	        			for(int i=0;i<(params.delete).size();i++)
    	        			{
    	        			def miscelleneousList = MiscellaneousDetails.get((params.delete[i]).toInteger())
    	            		miscelleneousList.delete()
    	        			}
    	        	}
    	        	redirect(action:popMiscellaneousEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
  
    def saveMiscellaneous = 
    {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	def hazList=MiscellaneousDetails.findAll("from MiscellaneousDetails abcd where abcd.application=?",[app])
    		    	if(hazList)
    		    	{
    		    		flash.message="Details already exist!!!"
    		    		redirect(action:popMiscelleneousAdd,id:app)
    		    	}
    		    	else
    		    	{
    		    		def miscelleneousList = new MiscellaneousDetails()
    		    		def list = params.controlMeasures
    		    		String b = ""
    		    		if(list.getClass().getName()== "java.lang.String"){
    						b=list
    					}
    		    		else{
    				for (String a : list)
    					{
    					    b += a + ",";
    					}
    				}
    				miscelleneousList.controlMeasures=b
    		    		miscelleneousList.totalCost=params.totalCost
    		    		miscelleneousList.dgStInstalled=params.dgStInstalled
    		    		miscelleneousList.dgSetCapacity=params.dgSetCapacity
    		    		miscelleneousList.AcausticEnclosure=params.AcausticEnclosure
    		    		miscelleneousList.noisePollution=params.noisePollution
    		    		miscelleneousList.noiseMeasures=params.noiseMeasures
    		    		miscelleneousList.presParameters=params.presParameters
    		    		miscelleneousList.hazardeousSubs=params.hazardeousSubs
    		    		miscelleneousList.nameOfHazardeous=params.nameOfHazardeous
    		    		miscelleneousList.quatityOfHazard=params.quatityOfHazard
    		    		miscelleneousList.isHazarSubstanceProduced=params.isHazarSubstanceProduced
    		    		miscelleneousList.nameOfHazardWaste=params.nameOfHazardWaste
    		    		miscelleneousList.quatityOfWaste=params.quatityOfWaste
    		    		miscelleneousList.application = app
    		    		miscelleneousList.save()
    		    	flash.message = "Details Saved"
    		            redirect(action:popMiscelleneousAdd,id:app,miscelleneousList:miscelleneousList)
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

    def editWaterWasteDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		
    	        		def wastersolidDetails = WaterWasteDischarge.get((params.delete).toInteger())
    	        		wastersolidDetails.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def wastersolidDetails = WaterWasteDischarge.get((params.delete[i]).toInteger())
    	            		wastersolidDetails.delete()
    	        		}
    	        	}
    	        	redirect(action:popWaterWasteDischargeEdit,id:app)
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
   def saveWaterWasteDischrgeDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def waterUsageDetailsInst = new WaterWasteDischarge()
    	        	def waterDisp = params.description
    	       def dgList = WaterWasteDischarge.findAll("from WaterWasteDischarge abc where abc.description=? and abc.application=?",[waterDisp,app])
    	       if(waterDisp=="Not Selected")
    	 	{
    	 		flash.message = "Please Select Water Discharge Details"
    	     	redirect(action:popWaterWasteDischargeAdd,id:app,params:[waterUsageDetailsInst:waterUsageDetailsInst])
    	 	}
    	 	else if(dgList)
    	 	{
    	 		flash.message = "Water Waste Discharge details regarding ${waterDisp} already exists"
    	 		redirect(action:popWaterWasteDischargeAdd,id:app,params:[waterUsageDetailsInst:waterUsageDetailsInst])
    	 	}
    	 	else
    	 	{  	waterUsageDetailsInst.description = waterDisp
    	 		waterUsageDetailsInst.quantQual = params.quantity
    	 		waterUsageDetailsInst.application = app
    	 		waterUsageDetailsInst.save()
    	     	redirect(action:popWaterWasteDischargeAdd,id:app,params:[waterUsageDetailsInst:waterUsageDetailsInst])
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
     
   def editWaterSourceDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def wastersourceDetails = StoneCrusherWaterReq.get((params.delete).toInteger())
    	        		wastersourceDetails.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def wastersourceDetails = StoneCrusherWaterReq.get((params.delete[i]).toInteger())
    	            		wastersourceDetails.delete()
    	        		}
    	        	}
    	        	redirect(action:popWaterSourceDetailsEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
       
def saveWaterSourceDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def stoneCrusherWaterReqList = new StoneCrusherWaterReq()
    	        	def waterDisp = params.sourceOfWaterSupply
    	       def dgList = StoneCrusherWaterReq.findAll("from StoneCrusherWaterReq abc where abc.sourceOfWaterSupply=? and abc.application=?",[waterDisp,app])
    	       if(waterDisp=="Not Selected")
    	 	{
    	 		flash.message = "Please Select Water Source Details"
    	     	redirect(action:popWaterSourceDetailsAdd,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
    	 	}
    	 	else if(dgList)
    	 	{
    	 		flash.message = "Water Source details regarding ${waterDisp} already exists"
    	 		redirect(action:popWaterSourceDetailsAdd,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
    	 	}
    	 	else
    	 	{  	stoneCrusherWaterReqList.sourceOfWaterSupply = waterDisp
    	 		stoneCrusherWaterReqList.quantity = params.quantity
    	 		stoneCrusherWaterReqList.application = app
    	 		stoneCrusherWaterReqList.save()
    	     	redirect(action:popWaterSourceDetailsAdd,id:app,params:[stoneCrusherWaterReqList:stoneCrusherWaterReqList])
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
    
   def editWaterConsumptionDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def wasterconsumptionDetails = WaterConsumptionDetail.get((params.delete).toInteger())
    	        		wasterconsumptionDetails.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def wasterconsumptionDetails = WaterConsumptionDetail.get((params.delete[i]).toInteger())
    	            		wasterconsumptionDetails.delete()
    	        		}
    	        	}
    	        	redirect(action:popWaterConsumptionDetailEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def saveWaterConsumptionDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	def waterConsumptionDetailList = new WaterConsumptionDetail()
    	        	def waterConsumptionType = params.waterConsumptionType
    	       def dgList = WaterConsumptionDetail.findAll("from WaterConsumptionDetail abc where abc.waterConsumptionType=? and abc.application=?",[waterConsumptionType,app])
    	     if(waterConsumptionType=="Not Selected")
    	 	{
    	 		flash.message = "Please Select Water consumption Details"
    	     	redirect(action:popWaterConsumptionDetailAdd,id:app,params:[waterConsumptionDetailList:waterConsumptionDetailList])
    	 	}
    	 	else if(dgList)
    	 	{
    	 		flash.message = "Water Consumption details regarding ${waterConsumptionType} already exists"
    	 		redirect(action:popWaterConsumptionDetailAdd,id:app,params:[waterConsumptionDetailList:waterConsumptionDetailList])
    	 	}
    	 	else
    	 	{  	waterConsumptionDetailList.waterConsumptionType = waterConsumptionType
    	 		waterConsumptionDetailList.quantity = params.quantity
    	 		waterConsumptionDetailList.storageFacility = params.storageFacility
    	 		waterConsumptionDetailList.application = app
    	 		waterConsumptionDetailList.save()
    	     	redirect(action:popWaterConsumptionDetailAdd,id:app,params:[waterConsumptionDetailList:waterConsumptionDetailList])
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
    
 def saveWaterUsageDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    		     def waterUsageDetailsInst = new WaterUsageDetails()
    		      def waterDisp =params.description
    		     	def dgList = WaterUsageDetails.findAll("from WaterUsageDetails abc where abc.description=? and abc.application=?",[waterDisp,app])
    		     if(waterDisp=="Not Selected")
    		 	{
    		 		flash.message = "Please Select Water Usage"
    		     	redirect(action:popWaterUsageDetailAdd,id:app,params:[waterUsageDetailsInst:waterUsageDetailsInst])
    		 	}
    		 	else if(dgList)
    		 	{
    		 		flash.message = "Water Usage details regarding ${waterDisp} already exists"
    		 		redirect(action:popWaterUsageDetailAdd,id:app,params:[waterUsageDetailsInst:waterUsageDetailsInst])
    		 	}
    		 	else
    		 	{  	waterUsageDetailsInst.description = waterDisp
    		 		waterUsageDetailsInst.quantQual = params.quantity
    		 		waterUsageDetailsInst.application = app
    		 		waterUsageDetailsInst.save()
    		     	redirect(action:popWaterUsageDetailAdd,id:app,params:[waterUsageDetailsInst:waterUsageDetailsInst])
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
    
    def editWaterUsageDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def wastersolidDetails = WaterUsageDetails.get((params.delete).toInteger())
    	        		wastersolidDetails.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def wastersolidDetails = WaterUsageDetails.get((params.delete[i]).toInteger())
    	            		wastersolidDetails.delete()
    	        		}
    	        	}
    	        	redirect(action:popWaterUsageDetailEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    def popNocAuthorityAdd = {
    		 try {
    	        	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def nocAuthorityDetailsInst = NocAuthorityDetails.findAllByApplication(app)
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
  
    def popNocAuthorityView = {
    		 try {
    	        	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def nocAuthorityDetailsInst = NocAuthorityDetails.findAllByApplication(app)
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
   
    def popNocAuthorityEdit = {
    		 try {
    	        	def d = params.d
    	        	def app = IndApplicationDetails.get((params.id).toInteger())
    	        	def nocAuthorityDetailsInst = NocAuthorityDetails.findAllByApplication(app)
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
    
    def saveNOCAuthority = 
    {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    		    	def nocAuthorityDetailsInst = new NocAuthorityDetails(params)
    		    	def authorityDetails =params.authorityDetails
    		    	def dgList = NocAuthorityDetails.findAll("from NocAuthorityDetails abc where abc.authorityDetails=? and abc.application=?",[authorityDetails,app])
    		     	 if(dgList)
    		 	{
    		 		flash.message = "NOC Authority details regarding ${authorityDetails} already exists"
    		 		redirect(action:popNocAuthorityAdd,id:app,params:[nocAuthorityDetailsInst:nocAuthorityDetailsInst])
    		 	}
    		 	else
    		 	{  	nocAuthorityDetailsInst.authorityDetails = params.authorityDetails
    		 		nocAuthorityDetailsInst.status = params.status
    		 		nocAuthorityDetailsInst.number = params.number
    		 		nocAuthorityDetailsInst.date = params.date_value
    		 		nocAuthorityDetailsInst.application = app
    		 		nocAuthorityDetailsInst.save()
    		     	flash.message = "Details Saved"
    		 		redirect(action:popNocAuthorityAdd,id:app,params:[nocAuthorityDetailsInst:nocAuthorityDetailsInst])
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
    
    def editNocAuthorityDetail= {
    		 try {
    	        	def app = IndApplicationDetails.get((params.appId).toInteger())
    	        	if((params.delete).getClass().getName()== "java.lang.String"){
    	        		def wastersolidDetails = NocAuthorityDetails.get((params.delete).toInteger())
    	        		wastersolidDetails.delete()
    	        	}else{
    	        		if(params.delete)
    	        		for(int i=0;i<(params.delete).size();i++){
    	        			def wastersolidDetails = NocAuthorityDetails.get((params.delete[i]).toInteger())
    	            		wastersolidDetails.delete()
    	        		}
    	        	}
    	        	redirect(action:popNocAuthorityEdit,id:app)
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
    public boolean updateAllSummaryReport(String AppId)
    {
        try
        {
        	println("params.in updateAllSummaryReport.."+params)
        	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
        	def AllSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[AppId]);
        	println("params.in updateAllSummaryReport.AllSummaryReportInstance."+AllSummaryReportInstance)
			if(!AllSummaryReportInstance)
			{
				def applicationPending=ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id = ? ",[(AppId).toLong()]);	
				def aPDInstance=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and officer!=? and officerFwd=? order by dateCreated desc limit 1",[applicationPending.application,applicationPending.pendingWith.id,applicationPending.pendingWith.id]);
				def roleFwd=applicationPending.role;
				def indRegMasterInstance=applicationPending.application.indUser;
				def applicationDate
			    Date date1=applicationPending.application.actualApplicationDate 
			    Date date2=applicationPending.application.applicationDate
			 
			    	applicationDate=date1;
			
				AllSummaryReportInstance=new AllSummaryReport();
				AllSummaryReportInstance.applicationId=(applicationPending.application.id).toString()
				AllSummaryReportInstance.indRegMasterId=(indRegMasterInstance.id).toString()
				AllSummaryReportInstance.applicationName=indRegMasterInstance.indName
				AllSummaryReportInstance.districtId=(indRegMasterInstance.district.id).toString()
				AllSummaryReportInstance.districtName=indRegMasterInstance.district.districtName
				AllSummaryReportInstance.roleId=(roleFwd.id).toString();
				AllSummaryReportInstance.roleName=roleFwd.roleName;
				AllSummaryReportInstance.groupId=(roleFwd.group.id).toString()
				AllSummaryReportInstance.groupName=roleFwd.group.groupName
				AllSummaryReportInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
				AllSummaryReportInstance.applicationType=applicationPending.application.applicationType
				AllSummaryReportInstance.applicationFor=applicationPending.application.applicationFor
				AllSummaryReportInstance.certificateFor=applicationPending.application.certificateFor
				AllSummaryReportInstance.applicationStatus=applicationPending.applicationStatus
				AllSummaryReportInstance.applicationRecieptDate=applicationDate;
				
				AllSummaryReportInstance.indTypeId=(indRegMasterInstance.industryType.id).toString()
				AllSummaryReportInstance.indTypeName=indRegMasterInstance.industryType.industryType
				AllSummaryReportInstance.indCategoryId=(indRegMasterInstance.category.id).toString()
				AllSummaryReportInstance.indCategoryName=indRegMasterInstance.category.name;
				
				AllSummaryReportInstance.occEmail=indRegMasterInstance.occEmail
				AllSummaryReportInstance.occMobile=indRegMasterInstance.occMobile
			
				////////??????				code added for OCMMS dashboard start from here
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String userInput = "01/01/1950";
				Date defaulDate = formatter.parse(userInput);
				def indUserId=IndUser.find("from IndUser where industryRegMaster.id=?",[indRegMasterInstance.id])
				
				AllSummaryReportInstance.indId=indUserId.id;
				AllSummaryReportInstance.clarificationRaiseDt=defaulDate;   
				AllSummaryReportInstance.clarificationSubmitDt=defaulDate;
				AllSummaryReportInstance.dateOfIssue=defaulDate;
				AllSummaryReportInstance.dateOfexpiry=defaulDate;
			AllSummaryReportInstance.indAddress=indRegMasterInstance.indAddress
				
				/////////????????	
				AllSummaryReportInstance.lastClarificationDate = ''
				AllSummaryReportInstance.lastForward = 'Not Forwarded'
				if(aPDInstance)
				  AllSummaryReportInstance.pendingSince=aPDInstance.dateCreated
				else
				AllSummaryReportInstance.pendingSince=applicationPending.application.actualApplicationDate
				AllSummaryReportInstance.pendingWith=(applicationPending.pendingWith).toString()
				
				if(!AllSummaryReportInstance.hasErrors() && AllSummaryReportInstance.save(flush:true)) 
				{
				}else {
					AllSummaryReportInstance.errors.each {
				        println it
					}
				}	
			}
			else
			{
				def applicationPending=ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id = ? ",[(AppId).toLong()]);	
		    	def roleFwd=applicationPending.role;
				AllSummaryReportInstance.applicationStatus=applicationPending.applicationStatus
				
					AllSummaryReportInstance.roleId=(roleFwd.id).toString()
					AllSummaryReportInstance.roleName=roleFwd.roleName
					AllSummaryReportInstance.officerName=(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeFirstName+" "+(RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.employeeLastName
					AllSummaryReportInstance.pendingSince=new Date();
					AllSummaryReportInstance.lastForward = sdfh.format(new Date());
					AllSummaryReportInstance.pendingWith=(applicationPending.pendingWith).toString()
				AllSummaryReportInstance.applicationRecieptDate=new Date();
					
				if(!AllSummaryReportInstance.hasErrors() && AllSummaryReportInstance.save(flush:true)) 
				{}
				
				else {
					AllSummaryReportInstance.errors.each {
				        println it
					}
				}
			}
		}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }

	def newPage=
    {
			 try {
		        def indUserID = (params.id).toLong()
	    		  def indId = IndustryRegMaster.get((params.id).toLong())
	    		  def indApplicationDetailsList = IndApplicationDetails.findAllWhere(indUser:indId,completionStatus:'completed')
	    		  def grantApplicationInstance
	    		  def app = new ArrayList()
	    		  for(int i=0; i<indApplicationDetailsList.size(); i++)
	    		  {
	    		  grantApplicationInstance = ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=?  and applicationStatus!='pending' order by id desc",[indApplicationDetailsList.get(i)])
	    		  app.add(grantApplicationInstance)
	    		  }
	    		  render(view:'newPage',model:[indId:indId,indApplicationDetailsList:indApplicationDetailsList,grantApplicationInstance:grantApplicationInstance,app:app])
	     }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
    }
	
	def popFeeOtherDetailsAdd = {
			 try {
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(app)
		        	def totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
		        	def feeCheque = FeeChequeRecord.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])
		        	return [appDetId:params.id,feeDetailsList:feeDetailsList,totalfee:totalfee,app:app,feeCheque:feeCheque]
		      }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
    def popFeeOtherDetailsView = {
			 try {
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(app)
		        	def totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
		        	def feeCheque = FeeChequeRecord.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])
		        	return [appDetId:params.id,feeDetailsList:feeDetailsList,totalfee:totalfee,feeCheque:feeCheque]
		     }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
        
        def popFeeOtherDetailsEdit = {
			 try {
		        	def app = IndApplicationDetails.get((params.id).toInteger())
		        	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(app)
		        	def totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
		        	def feeCheque = FeeChequeRecord.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])
		        	return [appDetId:params.id,feeDetailsList:feeDetailsList,totalfee:totalfee,feeCheque:feeCheque]
		      }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
    def saveBankOtherFeeDetails ={
			 try {
		        	def app = IndApplicationDetails.get((params.appId).toInteger())
		        	def feeBankDetails = new FeeBankOtherDetails()
		                		feeBankDetails.application = app
		                		if(params.feeFor=="Other"){
		                			feeBankDetails.feeFor = params.feeFor+","+params.otherDetail	
		                		}else{
		                		feeBankDetails.feeFor = params.feeFor
		                		}
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
		            					println it;
		            			   }
		            			}
		          redirect(action:popFeeOtherDetailsAdd,id:app.id)
		     }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
    
    def deleteFeeOtherBankDetails = {
			 try {
		        	def app = IndApplicationDetails.get((params.appId).toInteger())
		        	if((params.delete).getClass().getName()== "java.lang.String"){
		        		def feeDetInst = FeeBankOtherDetails.get((params.delete).toInteger())
		        		feeDetInst.delete()
		        	}else{
		        		if(params.delete){
		            	for(int i=0;i<(params.delete).size();i++){
		            		def feeDetInst = FeeBankOtherDetails.get((params.delete[i]).toInteger())
		            		
		            		feeDetInst.delete()
		            	}
		        		}
		        	}
		        	redirect(action:popFeeOtherDetailsEdit,id:app)
		      }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
    		
    def payment = {
			 try {
				 println("soniaaaaaaaaaaaaaaaa---------------"+params)
				println("hgfhgfhgfhgfhfghgf"+params.id)
				def testVal = params.testVal
		         def indApplicationDetailsInstance = IndApplicationDetails.get( params.id )
		    	def feeAmountId = ConsentFeeMaster.find("from ConsentFeeMaster  where application = ?",[indApplicationDetailsInstance])
		    	def feeAmount = (feeAmountId.totalApplicableFee).toInteger()
		    	println("fdh fee=======ammount========="+feeAmount.toInteger())
		    	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
		        	def totalfee = 0.0
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
				 println("totalfee--"+totalfee)
		        render(view:'Payment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feeAmount:totalfee])
		     }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
    
    def paymentOption_OLD_BY_DEEPAK = {
			 try {def fee = params.fees
				 println("params---->>----"+params)
				def testVal = params.testVal
				println("testVal in paymentoption action---->>----"+testVal)
			    	def indApp = params.indAppDetId
			    	def indApplicationDetailsInstance
			    	indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
			    
			      def applicationFileRecordInst = ApplicationFileRecord.findAll("from ApplicationFileRecord where indApplication=?",[indApplicationDetailsInstance])
			      String fees = request.getParameter("fees")
			    	Random random = new Random(new Date().getTime());
			    	int randomInt = random.nextInt(1000000000);
			    	  def feesOnline = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
						println("feesOnline.......>>>>>"+feesOnline.feeFor)	  
			    	  def indName = indApplicationDetailsInstance.indUser.indName
							  def waterCess = "0"
							  def nocFee = "0"
							  def waterCons = "0"
							  def airCons = "0"
							  def bmw = "0"
							  def testingFee = "0"
							  def ebg = "0"
							  def hmw = "0"
							  def ihw = "0"
							  def formFee = "0"
							  def misc = "0"
							  def ctobothFee = "0"
							  if(feesOnline.feeFor.contains('CTE'))
							{
							def feesOnline1 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTE' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...1....>>>>>"+feesOnline1.amount)
							nocFee = feesOnline1.amount
							}
			    	  if(feesOnline.feeFor.contains('CTO Air'))
						{
						def feesOnline5 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Air' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...5....>>>>>"+feesOnline5.amount)
						airCons = feesOnline5.amount
						}
			    	  if(feesOnline.feeFor.contains('CTO Water'))
						{
						def feesOnline6 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Water' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...6....>>>>>"+feesOnline6.amount)
						waterCons = feesOnline6.amount
						}
			    	  if(feesOnline.feeFor.contains('CTO Both'))
						{
						def feesOnline7 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...7....>>>>>"+feesOnline7.amount)
						ctobothFee = feesOnline7.amount
						}
			    	  if(feesOnline.feeFor.contains('Application Form'))
			    	  		{
						def feesOnline2 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...2....>>>>>"+feesOnline2.amount)
			    	  			formFee = feesOnline2.amount
			    	  		}
			    	  		if(feesOnline.feeFor.contains('Balance Fee'))
			    	  		{
						def feesOnline3 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...3....>>>>>"+feesOnline3.amount)
			    	  			misc = feesOnline3.amount
			    	  		}
			    	  		if(feesOnline.feeFor.contains('Other'))
			    	  		{
						def feesOnline4 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor!='Application Form' and fee.feeFor!='CTE' and fee.feeFor!='CTO Air' and fee.feeFor!='CTO Water' and fee.feeFor!='CTO Both' and fee.feeFor!='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  		println("feesOnline...4....>>>>>"+feesOnline4.amount)
			    	  		}
							  EncodeDecode encodeDecode = new EncodeDecode()
							  def data2 = "app_id="+indApplicationDetailsInstance+"&industry_name="+indName
							  def data3 = "noc_fee="+nocFee+"&water_cons="+waterCons+"&air_cons="+airCons
							  def data4 = "testing_fee="+testingFee+"&ebg="+ebg+"&hmw="+hmw+"&ihw="+ihw+"&form_fee="+formFee
							  def data5 = "water_cess="+waterCess+"&bmw="+bmw+"&misc="+misc
							  
							  System.out.println("data2=="+data2);
							  System.out.println("data2=="+data3);
							  System.out.println("data2=="+data4);
							  System.out.println("data2=="+data5);
							  
					def encdata11 = encodeDecode.Encrypt(data2,"a@m#i@t");
					def encdata12 = encodeDecode.Encrypt(data3,"a@m#i@t");
					def encdata13 = encodeDecode.Encrypt(data4,"a@m#i@t");
					def encdata14 = encodeDecode.Encrypt(data5,"a@m#i@t");
					 def encdata22 = encdata11.replace("+","~")
					 
					 System.out.println("e--1---"+encdata11);
					 System.out.println("e--2---"+encdata12);
					 System.out.println("e---3--"+encdata13);
					 System.out.println("e---3--"+encdata14);
					 
			    	String str1=encodeDecode.Decrypt(encdata11,"a@m#i@t");
			    	System.out.println("decryptingggggggggggggggggggggg------------------"+str1);
			    	
					 if(applicationFileRecordInst){
			    	if(params.radio=="online")
			    	{
			    		render(view:'paymentOption',model:[testVal:testVal,indApplicationDetailsInstance:indApplicationDetailsInstance,fees:fees,randomInt:randomInt])
			    	}
			    	else if(params.radio=="offline")
			    	{
			    		redirect(action:bankPaymentMode,id:indApplicationDetailsInstance,params:[testVal:testVal])
			    	}else if(params.radio=="paymentAlreadySubmitted"){
                        redirect(action:confirmation,id:indApplicationDetailsInstance,params:[indAppDetId: indApplicationDetailsInstance.id, testVal:testVal])
                    }
			    	}else{
			    		flash.message = 'Please go back and Complete the application again as Application Form has not been generated.'
			    		render(view:'Payment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feesPaid:fees,randomInt:randomInt])
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
	
	def paymentOption = {
			 try {def fee = params.fees
				 println("params---->>----"+params)
				def testVal = params.testVal
				println("testVal in paymentoption action---->>----"+testVal)
			    	def indApp = params.indAppDetId
			    	def indApplicationDetailsInstance
			    	indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
			    
			      def applicationFileRecordInst = ApplicationFileRecord.findAll("from ApplicationFileRecord where indApplication=?",[indApplicationDetailsInstance])
			      String fees = request.getParameter("fees")
			    	Random random = new Random(new Date().getTime());
			    	int randomInt = random.nextInt(1000000000);
			    	  def feesOnline = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
						println("feesOnline.......>>>>>"+feesOnline.feeFor)	  
			    	  def indName = indApplicationDetailsInstance.indUser.indName
							  def waterCess = "0"
							  def nocFee = "0"
							  def waterCons = "0"
							  def airCons = "0"
							  def bmw = "0"
							  def testingFee = "0"
							  def ebg = "0"
							  def hmw = "0"
							  def ihw = "0"
							  def formFee = "0"
							  def misc = "0"
							  def ctobothFee = "0"
							  if(feesOnline.feeFor.contains('CTE'))
							{
							def feesOnline1 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTE' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...1....>>>>>"+feesOnline1.amount)
							nocFee = feesOnline1.amount
							}
			    	  if(feesOnline.feeFor.contains('CTO Air'))
						{
						def feesOnline5 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Air' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...5....>>>>>"+feesOnline5.amount)
						airCons = feesOnline5.amount
						}
			    	  if(feesOnline.feeFor.contains('CTO Water'))
						{
						def feesOnline6 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Water' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...6....>>>>>"+feesOnline6.amount)
						waterCons = feesOnline6.amount
						}
			    	  if(feesOnline.feeFor.contains('CTO Both'))
						{
						def feesOnline7 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...7....>>>>>"+feesOnline7.amount)
						ctobothFee = feesOnline7.amount
						}
			    	  if(feesOnline.feeFor.contains('Application Form'))
			    	  		{
						def feesOnline2 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...2....>>>>>"+feesOnline2.amount)
			    	  			formFee = feesOnline2.amount
			    	  		}
			    	  		if(feesOnline.feeFor.contains('Balance Fee'))
			    	  		{
						def feesOnline3 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...3....>>>>>"+feesOnline3.amount)
			    	  			misc = feesOnline3.amount
			    	  		}
			    	  		if(feesOnline.feeFor.contains('Other'))
			    	  		{
						def feesOnline4 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor!='Application Form' and fee.feeFor!='CTE' and fee.feeFor!='CTO Air' and fee.feeFor!='CTO Water' and fee.feeFor!='CTO Both' and fee.feeFor!='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  		println("feesOnline...4....>>>>>"+feesOnline4.amount)
			    	  		}
							  EncodeDecode encodeDecode = new EncodeDecode()
							  def data2 = "app_id="+indApplicationDetailsInstance+"&industry_name="+indName
							  def data3 = "noc_fee="+nocFee+"&water_cons="+waterCons+"&air_cons="+airCons
							  def data4 = "testing_fee="+testingFee+"&ebg="+ebg+"&hmw="+hmw+"&ihw="+ihw+"&form_fee="+formFee
							  def data5 = "water_cess="+waterCess+"&bmw="+bmw+"&misc="+misc
							  
							  System.out.println("data2=="+data2);
							  System.out.println("data2=="+data3);
							  System.out.println("data2=="+data4);
							  System.out.println("data2=="+data5);
							  
					def encdata11 = encodeDecode.Encrypt(data2,"a@m#i@t");
					def encdata12 = encodeDecode.Encrypt(data3,"a@m#i@t");
					def encdata13 = encodeDecode.Encrypt(data4,"a@m#i@t");
					def encdata14 = encodeDecode.Encrypt(data5,"a@m#i@t");
					 def encdata22 = encdata11.replace("+","~")
					 
					 System.out.println("e--1---"+encdata11);
					 System.out.println("e--2---"+encdata12);
					 System.out.println("e---3--"+encdata13);
					 System.out.println("e---3--"+encdata14);
					 
			    	String str1=encodeDecode.Decrypt(encdata11,"a@m#i@t");
			    	System.out.println("decryptingggggggggggggggggggggg------------------"+str1);
			    	
					 if(applicationFileRecordInst){
			    	if(params.radio=="online")
			    	{
			    		render(view:'paymentOption',model:[testVal:testVal,indApplicationDetailsInstance:indApplicationDetailsInstance,fees:fees,randomInt:randomInt])
			    	}
			    	else if(params.radio=="offline")
			    	{
//			    		redirect(action:bankPaymentMode,id:indApplicationDetailsInstance,params:[testVal:testVal]) 
						redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,params:[testVal:testVal])
			    	}else if(params.radio=="paymentAlreadySubmitted"){
                       redirect(action:confirmation,id:indApplicationDetailsInstance,params:[indAppDetId: indApplicationDetailsInstance.id, testVal:testVal])
                   }
			    	}else{
			    		flash.message = 'Please go back and Complete the application again as Application Form has not been generated.'
			    		render(view:'Payment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feesPaid:fees,randomInt:randomInt])
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
    
	def bankPaymentMode={
			 try {
					def testVal=params.testVal;
					println("bank payment mode"+params)
					println("session-------"+session)
					println("testVal in bank payment mode action..."+testVal)
					def indApplicationDetailsInstance = IndApplicationDetails.get(params.id)
					[indApplicationDetailsInstance:indApplicationDetailsInstance,testVal:testVal]
				 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def confirmation = {
			try {
				println(params)
					def indApplicationDetailsInstance = IndApplicationDetails.get(params.indAppDetId)
					def indUserIns = (IndUser)(session.indUser)
					println("indUserIns "+indUserIns.id)
					def abc = IndUser.get(indUserIns.id)
					def industryRegMasterInstance = abc.industryRegMaster
					def testVal=params.testVal
                    if(testVal==null){
                        testVal = "false"
                    }
					println("testVal in confirmation action.::"+testVal)
					def fees = FeeBankDetails.find("from FeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])
					println("fees::00000000000000000000000000"+fees)
						def feeCheque = FeeChequeRecord.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[indApplicationDetailsInstance])
					println("feeCheque"+feeCheque)

					if(fees==null && !testVal.equals("true"))
						{
							println("fees34343::"+fees)
							flash.message="Please Enter Bank Fee Details4545454854"
				       	   redirect(action:bankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
				       	    return
						}
					else if(feeCheque==null && !testVal.equals("true"))
						{	
					flash.message="Please Attach Scan Copy Of all Drafts/Cheques "
							 redirect(action:bankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance,params:[testVal:testVal])
							 return
						  }
				else
					{
					indApplicationDetailsInstance.completionStatus = "completed"
						
					indApplicationDetailsInstance.save()
					if(testVal=="true"){
						
						def a = new GetData((indApplicationDetailsInstance.id).toLong())
				    	System.out.println("--------------in get data------->"+a.getCategory())
				    	a.routeAppForAppReturn()	
				}else{
					 def a = new GetData((indApplicationDetailsInstance.id).toLong())
				    	System.out.println("--------------in get data------->"+a.getCategory())
				    	a.routeApp()
				}
					
					 updateAllSummaryReport((indApplicationDetailsInstance.id).toString());	
					// insertIntoTracking(indApplicationDetailsInstance);// for insert into tracking table;
					def formView = indApplicationDetailsInstance.applicationFor
					println("formView---"+formView)
					render(view:'confirmationSubmit',model:[testVal:testVal,formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
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

	def confirm = {
			try {
			    println(params)
			    def indApplicationDetailsInstance = IndApplicationDetails.get(params.indAppDetId)
			 indApplicationDetailsInstance.completionStatus = "completed"
			    	 def a = new GetData((indApplicationDetailsInstance.id).toLong())
				System.out.println("--------------in get data------->"+a.getCategory())
				//a.routeApp()                          Comment By DEEPAK FOR SCRUTINY BECAUSE APPLICATION ALREADY ROUTED
			    indApplicationDetailsInstance.save()
			    updateAllSummaryReport((indApplicationDetailsInstance.id).toString());	//add by 
			   // insertIntoTracking(indApplicationDetailsInstance);// for insert into tracking table;
			    def formView = indApplicationDetailsInstance.applicationFor
			    println("formView---"+formView)
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
	
    def bankName = {
			try {
				println("PARAMS IN bankName------>"+params)
				def indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
				println(indApplicationDetailsInstance)
				def bankTransaction = new BankTransactionDetails()
				def bank				
				   def fees = session.getAttribute("fee")
				   println("session--------->"+session)
				   println("fees--------->"+fees.getClass().getName())
				 /*  def feeAmount = ConsentFeeMaster.find("from ConsentFeeMaster where application.id= ? order by id desc",[indApplicationDetailsInstance])
			    	   String fee = (feeAmount.totalFees).toString()
			    	   println("fee----"+fee)*/
				
				if(params.radio=="PNB")
				{
				println("bank---"+bank)
				println("session.getAttribute----"+session.getAttribute("random"))
				def id = session.getAttribute("random")
				bankTransaction.bankId = ""
				bankTransaction.amount = fees.toString()//session.getAttribute("fee")
				
				bankTransaction.bankName = params.radio 
				bankTransaction.indApplication = indApplicationDetailsInstance
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
				else if (params.radio=="other"){

			    	def id = session.getAttribute("random")
			    	bankTransaction.bankId = ""
			    	bankTransaction.amount = fees.toString()//session.getAttribute("fee")//
			    	println("bankTransaction.amount---"+bankTransaction.amount)
				    println("bankTransaction.amount---"+(bankTransaction.amount).getClass().getName())
			    	bankTransaction.bankName = ""
			    	bankTransaction.indApplication = indApplicationDetailsInstance
			    	bankTransaction.dateCreated = new Date()
			    	bankTransaction.lastUpdated = new Date()
			    	bankTransaction.transactionStatus = "F"
			    	bankTransaction.paymentType=""
			    	bankTransaction.id = id
			    	bankTransaction.paymentGateway="ICICI"
			    	println("bankTransaction.bankName.id--"+bankTransaction.id)    	
			    	//println("bankTransaction.id--"+params.selectBank)   	
			    	//bankTransaction.save() 
			    	
			    	if(bankTransaction.save(flush:true) ){
						println("bankTransaction-inst-save----"+bankTransaction)
					}else{
						println("bankTransaction-inst-not-saved"+bankTransaction)
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
						
			                      
			                  def group1 = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
			                  println("group1---------"+group1)
			                  def group = group1.group.groupName
			  
						    	  def feesOnline = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
										 println("feesOnline.......>>>>>"+feesOnline.feeFor)
									  
							  
								  if(feesOnline.feeFor.contains('CTE'))
								{
								
									def feesOnline1 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTE' and fee.application=?",[indApplicationDetailsInstance])
									println("feesOnline...1....>>>>>"+feesOnline1.amount)
									nocFee = feesOnline1.amount
								}
				    	  
				    	  if(feesOnline.feeFor.contains('CTO'))
							{
							
								def feesOnline5 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...5....>>>>>"+feesOnline5.amount)
								airCons = feesOnline5.amount
							}
				    	  
				    	  if(feesOnline.feeFor.contains('CTO Water'))
							{
							
								def feesOnline6 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Water' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...6....>>>>>"+feesOnline6.amount)
								waterCons = feesOnline6.amount
							}
				    	  if(feesOnline.feeFor.contains('CTO Both'))
							{
							
								def feesOnline7 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...6....>>>>>"+feesOnline7.amount)
								ctobothFee = feesOnline7.amount
							}
				    	  
				    	  		if(feesOnline.feeFor.contains('Application Form'))
				    	  		{
							
				    	  			def feesOnline2 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
				    	  			println("feesOnline...2....>>>>>"+feesOnline2.amount)
				    	  			formFee = feesOnline2.amount
				    	  		}
				    	  		
				    	  		if(feesOnline.feeFor.contains('Balance Fee'))
				    	  		{
							
				    	  			def feesOnline3 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
				    	  			println("feesOnline...3....>>>>>"+feesOnline3.amount)
				    	  			misc = feesOnline3.amount
				    	  		}
				    	  		
				    	  		if(feesOnline.feeFor.contains('Other'))
				    	  		{
							
				    	  			def feesOnline4 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor!='Application Form' and fee.feeFor!='CTE' and fee.feeFor!='CTO Air' and fee.feeFor!='CTO Water' and fee.feeFor!='Balance Fee' and fee.feeFor!='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
				    	  			println("feesOnline...4....>>>>>"+feesOnline4.amount)
				    	  		}
			    		
			    		def accNo = "appid"+indApplicationDetailsInstance+"_"+"dist"+indApplicationDetailsInstance.indUser.district.districtName+"_"+"appFor"+indApplicationDetailsInstance.applicationFor+"_"+"appType"+indApplicationDetailsInstance.applicationType+
			    		"_"+"certFor"+indApplicationDetailsInstance.certificateFor+"_"+"nocFee"+nocFee+"_"+"airCons"+airCons+"_"+"waterCons"+waterCons+"_"+"formFee"+formFee+"misc"+"_"+misc+"group"+"_"+group+"indName"+"_"+indApplicationDetailsInstance.indUser.indName
			    		def indName = indApplicationDetailsInstance.id
			  	    	def indAddress = indApplicationDetailsInstance.indUser.indAddress
			        	def indEmail = indApplicationDetailsInstance.indUser.indEmail
			        	println("indName----"+indName)
			    		println("indEmail----"+indEmail)
			  	    	println("accNo----"+accNo)
			    		String industryName = indName
			    		String merchantCode = indAddress
			    	    String accountNu = accNo
			    	    String fee = session.getAttribute("fee")
			    	   println("fee-54446---"+fee.getClass().getName())
			    	    String bankCode ="NA"
			    	    String industryEmail = indEmail
			    	    	
			    	    println("industryName----"+industryName)
			    		println("industryEmail----"+industryEmail)
			    	   String merchantId = id   
			    	    	
			    	    	
			    	    	
			    	   def industryName1 = indApplicationDetailsInstance.indUser.indName
			    	   def appType = indApplicationDetailsInstance.applicationType
			    	   def appFor = indApplicationDetailsInstance.applicationFor
			    	   println("industryName1----"+industryName1)
			    	   VenderRegistration vr = new VenderRegistration()
			    	   def reportIndName = vr.ReplaceSpecialChar(industryName1)            
			    	   println(".....deepak....."+fee)
			    	   println(".....priyanka....."+fee.getClass().getName())
			    	   String txnAmount="0.00"
			            		 if(fee){
			            			 txnAmount=fee+"0"
			            		 }
			            		 String txnAmount1="0.0"
			                		 if(fee){
			                			 txnAmount1=fee
			                			    }
			           String shoppingCart="FIRST_"+txnAmount1+"_0.0"
			           
			           println("......txnAmount....."+txnAmount);
			           println("......shoppingCart....."+shoppingCart);
			           println("......merchantId....."+merchantId);
			           println("......industryName....."+industryName);
			           println("......industryEmail....."+industryEmail);
			           
			           def sdfh = new SimpleDateFormat("dd-MM-yyyy"); 
			           println("......sdfh.format(new Date())....."+sdfh.format(new Date()));
			           String strKey = "1365775075TETTPF" // will be diff for merchant code
			           String strIV = "5124632302OFYFAB" // will be diff for merchant code

			           TransactionRequestBean objTransactionRequestBean=new TransactionRequestBean();

			            objTransactionRequestBean.setStrRequestType("T");
			            objTransactionRequestBean.setStrMerchantCode("L235106");
			            objTransactionRequestBean.setMerchantTxnRefNumber(merchantId);
			            objTransactionRequestBean.setStrAmount(txnAmount); // amount will be dynamic , need to pass
			            objTransactionRequestBean.setStrCurrencyCode("INR"); 
			            objTransactionRequestBean.setStrITC("Industry Name:"+reportIndName+"~Application Type:"+appType+"~Application For:"+appFor+"~regional office:NA"); // to send extra parameter
			            //objTransactionRequestBean.setStrReturnURL("http://164.100.163.18/JKPCB/indApplicationDetails/responsePage"); // return url whr response has to be recieved
			            objTransactionRequestBean.setStrReturnURL("https://jkocmms.nic.in/indApplicationDetails/responsePage"); // return url whr response has to be recieved
			            objTransactionRequestBean.setStrS2SReturnURL("https://tpslvksrv6046/LoginModule/Test.jsp"); // to be entered as NA 
			            objTransactionRequestBean.setStrShoppingCartDetails(shoppingCart);
			            objTransactionRequestBean.setTxnDate(sdfh.format(new Date())); // txn date(datecrated from banktransactiondetails table)
			            objTransactionRequestBean.setStrBankCode("NA"); // bank code from bank master
			            //objTransactionRequestBean.setWebServiceLocator("https://www.tekprocess.co.in/PaymentGateway/services/TransactionDetailsNew"); // need to be change when to be upload on live
			            objTransactionRequestBean.setWebServiceLocator("https://www.tpsl-india.in/PaymentGateway/services/TransactionDetailsNew"); // need to be change when to be upload on live
		                objTransactionRequestBean.setStrTPSLTxnID("NA");  //NA
			            objTransactionRequestBean.setStrMobileNumber("NA"); //NA
			            objTransactionRequestBean.setKey(strKey.getBytes());
			            objTransactionRequestBean.setIv(strIV.getBytes());
			            objTransactionRequestBean.setStrCustomerName(industryName);//industry name
			            objTransactionRequestBean.setLogPath("/home1/payloadLog/MerchantRequestLog/txt.log");//NA
			            objTransactionRequestBean.setStrEmail(industryEmail);//email id of industry
			            String strMsg =  objTransactionRequestBean.getTransactionToken();
			            println("strMsg----------objTransactionRequestBean--------"+objTransactionRequestBean)
			            println("strMsg----------T--------"+strMsg)
			    	    println("PRAGYA TESTING HELLO-")
			    	    println("PRAGYA TESTING HELLO-"+session)
			    	    response.sendRedirect(strMsg);
			    	    //render(view:'bankName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction,strMsg:strMsg])
				}
				else if(params.radio=="Credit/Debit"){
					def id = session.getAttribute("random")
					bankTransaction.bankId = ""
			    	bankTransaction.amount = fees.toString()//session.getAttribute("fee")
			    	bankTransaction.bankName = "" 
			    	bankTransaction.indApplication = indApplicationDetailsInstance
			    	bankTransaction.dateCreated = new Date()
			    	bankTransaction.lastUpdated = new Date()
			    	bankTransaction.transactionStatus = "F"
			    	bankTransaction.id = id
			    	bankTransaction.paymentType=params.radio        	 	
			    	bankTransaction.save()   
			    	
			    	
					 def waterCess = "0"
						  def nocFee = "0"
						  def waterCons = "0"
						  def airCons = "0"
						  def bmw = "0"
						  def testingFee = "0"
						  def ebg = "0"
						  def hmw = "0"
						  def ihw = "0"
						  def formFee = "0"
						  def misc = "0"
					
			                  
			              def group1 = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
			                def group = group1.group.groupName

					    	  def feesOnline = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
									 println("feesOnline.......>>>>>"+feesOnline.feeFor)
								  
						  
							  if(feesOnline.feeFor.contains('CTE'))
							{
							
								def feesOnline1 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTE' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...1....>>>>>"+feesOnline1.amount)
								nocFee = feesOnline1.amount
							}
			    	  
			    	  if(feesOnline.feeFor.contains('CTO Air'))
						{
						
							def feesOnline5 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Air' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...5....>>>>>"+feesOnline5.amount)
							airCons = feesOnline5.amount
						}
			    	  
			    	  if(feesOnline.feeFor.contains('CTO Water'))
						{
						
							def feesOnline6 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Water' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...6....>>>>>"+feesOnline6.amount)
							waterCons = feesOnline6.amount
						}
			    	  if(feesOnline.feeFor.contains('CTO Both'))
						{
						
							def feesOnline7 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...7...>>>>>"+feesOnline7.amount)
							waterCons = feesOnline6.amount
						}
			    	  
			    	  		if(feesOnline.feeFor.contains('Application Form'))
			    	  		{
						
			    	  			def feesOnline2 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...2....>>>>>"+feesOnline2.amount)
			    	  			formFee = feesOnline2.amount
			    	  		}
			    	  		
			    	  		if(feesOnline.feeFor.contains('Balance Fee'))
			    	  		{
						
			    	  			def feesOnline3 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...3....>>>>>"+feesOnline3.amount)
			    	  			misc = feesOnline3.amount
			    	  		}
			    	  		
			    	  		if(feesOnline.feeFor.contains('Other'))
			    	  		{
						
			    	  			def feesOnline4 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor!='Application Form' and fee.feeFor!='CTE' and fee.feeFor!='CTO Air' and fee.feeFor!='CTO Water' and fee.feeFor!='CTO Both' and fee.feeFor!='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...4....>>>>>"+feesOnline4.amount)
			    	  		}
					
			    	  		def accNo = "appid"+indApplicationDetailsInstance+"_"+"dist"+indApplicationDetailsInstance.indUser.district.districtName+"_"+"appFor"+indApplicationDetailsInstance.applicationFor+"_"+"appType"+indApplicationDetailsInstance.applicationType+
			        		"_"+"certFor"+indApplicationDetailsInstance.certificateFor+"_"+"nocFee"+nocFee+"_"+"airCons"+airCons+"_"+"waterCons"+waterCons+"_"+"formFee"+formFee+"misc"+"_"+misc+"group"+"_"+group+"indName"+"_"+indApplicationDetailsInstance.indUser.indName

			      	    	def indAddress = indApplicationDetailsInstance.indUser.indAddress
			            	println("accNo----"+accNo)
			        			String merchantCode = indAddress
			    	    String accountNu = accNo
			    	    String fee = fees.toString()//session.getAttribute("fee")
			    	    String bankCode ="NA"
			    	    com.CheckSumRequestBean obj = new com.CheckSumRequestBean();
			    	    String merchantId = id    		
			    		obj.setStrMerchantTranId(merchantId);
			    	    obj.setStrMarketCode(merchantCode);
			    	    obj.setStrAccountNo(accountNu);
			    	    obj.setStrAmt(fee);
			    	    obj.setStrBankCode(bankCode);
			    	    String contextPath = getServletContext().getRealPath("")+"/file1.properties/";
			    	  
			    	
			    	    obj.setStrPropertyPath(contextPath)
			    	
			    	    com.TPSLUtil util = new com.TPSLUtil();
			    	    String strMsg = util.transactionRequestMessage(obj)
			    
			    	    render(view:'bankName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction,strMsg:strMsg])

			    		}
						else if(params.radio=="onlineHDFC")
						{
							println("====INSIDE=========HDFC");
							redirect(action:bankNameHDFC,id:params.indAppDetId,radio:"other");
							return
						}
						else
						{
							redirect(action:eWalletInstruction,id:indApplicationDetailsInstance,fees:fees);
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
	
	def eWalletInstruction = {
			try {
				
				println("params.44444..."+params)
				
				def indApplicationDetailsInstance = IndApplicationDetails.get( params.id)
				render(view:'eWalletInstruction',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])

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
	
	def eWalletOption = {
			try {
				
				println("params...."+params)
				def indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
				render(view:'eWalletOption',model:[indApplicationDetailsInstance:indApplicationDetailsInstance])

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
	
	def eWalletOption1 = {
			try {
				println("params...."+params)
				println("session...."+session)
				 Random random = new Random(new Date().getTime());
				int randomInt = random.nextInt(1000000000);
				println("randomInt...."+randomInt)
				render(view:'eWalletOption1',model:[randomInt:randomInt])

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
	
	def eWalletName = {
			try {

				println("eWalletName Name params------>"+params)
				def indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
				println(indApplicationDetailsInstance)
				def bankTransaction = new BankTransactionDetails()
				def refundTransaction = new RefundTransactionDetails()
				def bank
				def fees = session.getAttribute("fee")
				println("session--------->"+session)
				
				if (params.radio=="refund"){
					

					def id = session.getAttribute("random")
					refundTransaction.tpslId = ""
			    	refundTransaction.amount = params.refundAmount
			    	refundTransaction.bankName = params.bankName
			    	refundTransaction.name = params.accountName
			    	refundTransaction.accountNo = params.accountNo
			    	refundTransaction.ifscCode = params.ifscCode
			    	refundTransaction.indUser =  session.getAttribute("indUser")
			    	refundTransaction.dateCreated = new Date()
			    	refundTransaction.lastUpdated = new Date()
			    	refundTransaction.refundStatus = "F"
			    	refundTransaction.id = id
			    	refundTransaction.paymentType=params.radio        	 	
			    	refundTransaction.save()   
			    	
			    	
							//MCGM~12371~NA~NA~date~EMD~ok
								 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:ms");
			                      Date newdate=new Date();
			                     String date=dateFormat.format(newdate);
			                 //    String fee = session.getAttribute("fee")	
								def refundAccNo = params.accountNo
								
								def ifsc = params.ifscCode
								def bankName = params.bankName
					        	def payeeName = params.accountName
					        	def ewalletNo = session.getAttribute("indUser")	   	
					        	
						def accNo = "JPCB"+"~"+"DEMOUSER"+"~"+refundAccNo+"~NA~"+date+"~Refund~"+ifsc+"\$"+payeeName+"\$"+bankName
//						def accNo1 = "JPCB"+"~"+ewalletNo+"~"+refundAccNo+"~NA~"+date+"~Refund~"+ifsc+"\$"+payeeName+"\$"+bankName
						
						def accNo1 = "JPCB"+"~"+"G151432899"+"~"+refundAccNo+"~NA~"+date+"~Refund~"+ifsc+"\$"+payeeName+"\$"+bankName
						
			      	    //	def indAddress = indApplicationDetailsInstance.indUser.indAddress
			            	println("accNo----"+accNo)
								println("accNo11111111----"+accNo1)
			        			String merchantCode = "JPCB"
			    	    String accountNu = accNo
			    	    String accountNu1 = accNo1
			    	    String fee = params.refundAmount
			    	    String txnAmount="0.00"
			       		 if(fee){
			       			 txnAmount=fee+"0"
			       		 }
			       		 String txnAmount1="0.0"
			           		 if(fee){
			           			 txnAmount1=fee
			           			    }
			       		 String shoppingCart=txnAmount1+".00"
			       		 
			       		 println("fee------------------->"+fee)
			         println("shoppingCart------------------>"+shoppingCart)
			    	    
			    	    String bankCode ="ICICI"
			    	    CheckSumRequestBean obj = new CheckSumRequestBean();
			    	    String merchantId = id    		
			    		obj.setStrMerchantTranId(merchantId);
			    	    obj.setStrMarketCode(merchantCode);
			    	    obj.setStrAccountNo(accountNu1);
			    	    obj.setStrAmt(shoppingCart);
			    	    obj.setStrBankCode(bankCode);
			    	    String contextPath = getServletContext().getRealPath("")+"/file1.properties/";
			    	  
			    	
			    	    obj.setStrPropertyPath(contextPath)
			    	
			    	    com.TPSLUtil util = new com.TPSLUtil();
			    	    String strMsg = util.transactionRequestMessage(obj)
			    println("strMsg----------------->"+strMsg)
			   
			    	    render(view:'eWalletRefundName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,refundTransaction:refundTransaction,strMsg:strMsg])

			    		
					
				}
				else if(params.radio=="e-Wallet"){
					def id = session.getAttribute("random")
					bankTransaction.bankId = ""
			    	bankTransaction.amount = session.getAttribute("fee")
			    	bankTransaction.bankName = "" 
			    	bankTransaction.indApplication = indApplicationDetailsInstance
			    	bankTransaction.dateCreated = new Date()
			    	bankTransaction.lastUpdated = new Date()
			    	bankTransaction.transactionStatus = "F"
			    	bankTransaction.id = id
			    	bankTransaction.paymentType=params.radio        	 	
			    	bankTransaction.save()   
			    	
			    	
					 def waterCess = "0"
						  def nocFee = "0"
						  def waterCons = "0"
						  def airCons = "0"
						  def bmw = "0"
						  def testingFee = "0"
						  def ebg = "0"
						  def hmw = "0"
						  def ihw = "0"
						  def formFee = "0"
						  def misc = "0"
					
			                  
			              def group1 = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
			                def group = group1.group.groupName

					    	  def feesOnline = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
									 println("feesOnline.......>>>>>"+feesOnline.feeFor)
								  
						  
							  if(feesOnline.feeFor.contains('CTE'))
							{
							
								def feesOnline1 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTE' and fee.application=?",[indApplicationDetailsInstance])
								println("feesOnline...1....>>>>>"+feesOnline1.amount)
								nocFee = feesOnline1.amount
							}
			    	  
			    	  if(feesOnline.feeFor.contains('CTO'))
						{
						
							def feesOnline5 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...5....>>>>>"+feesOnline5.amount)
							airCons = feesOnline5.amount
						}
			    	  
			    	  if(feesOnline.feeFor.contains('CTO Water'))
						{
						
							def feesOnline6 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Water' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...6....>>>>>"+feesOnline6.amount)
							waterCons = feesOnline6.amount
						}
			    	  if(feesOnline.feeFor.contains('CTO Both'))
						{
						
							def feesOnline7 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...7...>>>>>"+feesOnline7.amount)
							waterCons = feesOnline6.amount
						}
			    	  
			    	  		if(feesOnline.feeFor.contains('Application Form'))
			    	  		{
						
			    	  			def feesOnline2 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...2....>>>>>"+feesOnline2.amount)
			    	  			formFee = feesOnline2.amount
			    	  		}
			    	  		
			    	  		if(feesOnline.feeFor.contains('Balance Fee'))
			    	  		{
						
			    	  			def feesOnline3 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...3....>>>>>"+feesOnline3.amount)
			    	  			misc = feesOnline3.amount
			    	  		}
			    	  		
			    	  		if(feesOnline.feeFor.contains('Other'))
			    	  		{
						
			    	  			def feesOnline4 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor!='Application Form' and fee.feeFor!='CTE' and fee.feeFor!='CTO Air' and fee.feeFor!='CTO Water' and fee.feeFor!='CTO Both' and fee.feeFor!='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
			    	  			println("feesOnline...4....>>>>>"+feesOnline4.amount)
			    	  		}
					
//			    	  		def accNo = "appid"+indApplicationDetailsInstance+"_"+"dist"+indApplicationDetailsInstance.indUser.district.districtName+"_"+"appFor"+indApplicationDetailsInstance.applicationFor+"_"+"appType"+indApplicationDetailsInstance.applicationType+
//			        		"_"+"certFor"+indApplicationDetailsInstance.certificateFor+"_"+"nocFee"+nocFee+"_"+"airCons"+airCons+"_"+"waterCons"+waterCons+"_"+"formFee"+formFee+"misc"+"_"+misc+"group"+"_"+group+"indName"+"_"+indApplicationDetailsInstance.indUser.indName
								//MCGM~12371~NA~NA~date~EMD~ok
								def indName = indApplicationDetailsInstance.indUser.indName
				  		def appNo = indApplicationDetailsInstance.id
				  		def appType = indApplicationDetailsInstance.applicationType
								println("indName-----------------------"+indName)
								println("appNo-----------------------"+appNo)
								println("appType-----------------------"+appType)
								
								
									VenderRegistration vr = new VenderRegistration()
							        def ewalletIndName = vr.ReplaceSpecialChar(indName)

								println("ewalletIndName-----------------------"+ewalletIndName)
								
								
								 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:ms");
			                      Date newdate=new Date();
			                     String date=dateFormat.format(newdate);
			                 //    String fee = session.getAttribute("fee")	
							def ewalletNo = session.getAttribute("indUser")	
							println("ewallet no---------------"+ewalletNo)
							
						def accNo = "JPCB"+"~"+"DEMOUSER"+"~NA~NA~"+date+"~EMD~ok"
						//def accNo1 = "JPCB"+"~"+ewalletNo+"~NA~NA~"+date+"~EMD~ok"
//						def accNo1 = "JPCB"+"~"+ewalletNo+"~NA~NA~"+date+"~EMD~"+"Industry Name="+ewalletIndName+"\$"+"Application Number="+appNo+"\$"+"Application Type="+appType
						def accNo1 = "JPCB"+"~"+"G151432899"+"~NA~NA~"+date+"~EMD~"+"Industry Name="+ewalletIndName+"\$"+"Application Number="+appNo+"\$"+"Application Type="+appType
						
						
			      	    	def indAddress = indApplicationDetailsInstance.indUser.indAddress
			            	println("accNo----"+accNo)
							println("accNo1111111111111----"+accNo1)
			        			String merchantCode = "JPCB"
			    	    String accountNu = accNo
			    	    String accountNu1 = accNo1
			    	    String fee = session.getAttribute("fee")
			    	    String txnAmount="0.00"
			       		 if(fee){
			       			 txnAmount=fee+"0"
			       		 }
			       		 String txnAmount1="0.0"
			           		 if(fee){
			           			 txnAmount1=fee
			           			    }
			       		 String shoppingCart=txnAmount1+"0"
			       		 
			       		 println("fee------------------->"+fee)
			         println("shoppingCart------------------>"+shoppingCart)
			    	    
			    	    String bankCode ="ICICI"
			    	    CheckSumRequestBean obj = new CheckSumRequestBean();
			    	    String merchantId = id    		
			    		obj.setStrMerchantTranId(merchantId);
			    	    obj.setStrMarketCode(merchantCode);
			    	    obj.setStrAccountNo(accountNu1);
			    	    obj.setStrAmt(shoppingCart);
			    	    obj.setStrBankCode(bankCode);
			    	    String contextPath = getServletContext().getRealPath("")+"/file.properties/";
			    	  
			    	
			    	    obj.setStrPropertyPath(contextPath)
			    	
			    	    com.TPSLUtil util = new com.TPSLUtil();
			    	    String strMsg = util.transactionRequestMessage(obj)
			    println("strMsg----------------->"+strMsg)
			   
			    	    render(view:'eWalletName',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,bankTransaction:bankTransaction,strMsg:strMsg])

			    		}
				
						else
						{
							//redirect(action:bankList,id:indApplicationDetailsInstance)
						//	redirect(action:eWalletInstruction,id:indApplicationDetailsInstance,fees:fees)
						def accountNo = "JPCB"+session.getAttribute("indUser")
						println("session.getAttribute(induser)....................."+accountNo)
						 render(view:'eWalletChallanReciept',model:[accountNo:accountNo])
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
	
	def neftResponse = {
			try {

				
				println("==================="+session)
				
				def appId = session.appId
				def indApplicationDetailsInstance = IndApplicationDetails.get(session.appId)
				
				def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[indApplicationDetailsInstance])

				System.out.println("msg-------"+request.getParameter("msg"));
				String strBillerId = "";
				String strMarketCode = "";
				String strAccountNo = "";
				String strResponseUrl = "";
				String strMsg = "";
				String strCustomerID = "";
				String strTransactionRefNo = "";
				String strBankRefNo = "";
				String strTxnAmount = "";
				String strCSTBANKID = "";
				String strBankMerchantId = "";
				String strTxnType = "";
				String strMerCRN = "";
				String strItemCode = "";
				String strSecurityType = "";
				String strSecurityId = "";
				String strSecurityPassword = "";
				String strTranDate = "";
				String strAuthStatus = "";
				String strSettlementType = "";
				String strAddInfo1 = "";
				String strAddInfo2 = "";
				String strAddInfo3 = "";
				String strAddInfo4 = "";
				String strAddInfo5 = "";
				String strAddInfo6 = "";
				String strAddInfo7 = "";
				String strReturnURL = "";
				String strErrorStatus = "";
				String strErrorDescription = "";
				String strCheckSum = "";
				String strStatus = "";
				String strCheckSumValue = "";
				String strResponseMsg="";
				
				
			strResponseMsg =  request.getParameter("msg");
				
				
					StringTokenizer token = new StringTokenizer(strResponseMsg,"|");
			    println("tokennnnnnnnnnnnnnnn--------------"+token.countTokens());
					if(token.countTokens()==26)
						{
							strBillerId=token.nextToken();
							strCustomerID=token.nextToken();
							strTransactionRefNo=token.nextToken();
							strBankRefNo=token.nextToken();
							strTxnAmount=token.nextToken();
							strCSTBANKID=token.nextToken();
							strBankMerchantId=token.nextToken();
							strTxnType=token.nextToken();
							strMerCRN=token.nextToken();
							strItemCode=token.nextToken();
							strSecurityType=token.nextToken();
							strSecurityId=token.nextToken();
							strSecurityPassword=token.nextToken();
							strTranDate=token.nextToken();
							strAuthStatus=token.nextToken();
							strSettlementType=token.nextToken();
							strAddInfo1=token.nextToken();
							strAddInfo2=token.nextToken();
							strAddInfo3=token.nextToken();
							strAddInfo4=token.nextToken();
							strAddInfo5=token.nextToken();
							strAddInfo6=token.nextToken();
							strAddInfo7=token.nextToken();
							strErrorStatus=token.nextToken();
							strErrorDescription=token.nextToken();
							strCheckSum=token.nextToken();
						}
						else
						{
							System.out.println("Inside ELSE of Response***********");
						}
					System.out.println("strTranDate---**"+strTranDate);
					
				
				
					//strResponseMsg =  request.getParameter("msg");		
				
				
				  def inst = indApplicationDetailsInstance.applicationType
				  def inst1 = indApplicationDetailsInstance.applicationFor
				  def inst2 = indApplicationDetailsInstance.certificateFor
				  
				  def val = indApplicationDetailsInstance.indUser
				  println("val------------------"+val)
			            	  
				  println("------------"+val.occName)
				  
				  def occName = val.occName
				  String contextPath
				  
			           if(strBillerId=="JPCB"){
				   contextPath = getServletContext().getRealPath("")+"/file.properties/";
			            	  }
			            	  else{
			            		  
			            		  
			            		  
			            		  contextPath  = getServletContext().getRealPath("")+"/file.properties/";   
			            	  }
				  
				  
				  println("---------------------strBillerId-----"+strBillerId)
				
				  com.CheckSumResponseBean res = new com.CheckSumResponseBean();
				  	
					res.setStrMSG(strResponseMsg); 
				   println("---------------------m here-----")
					res.setStrPropertyPath(contextPath);
				
					 println("--------------------have reached here-----")
					
				
				com.TPSLUtil util = new com.TPSLUtil();
				strCheckSumValue = util.transactionResponseMessage(res);
				
				 println("strAuthStatus==============="+strAuthStatus)
					println("strCheckSumValue==============="+strCheckSumValue)
				  if (strAuthStatus != null && strAuthStatus.equals("0300")) {
			           if (!strCheckSumValue.equals("")) {
			               if (!strCheckSumValue.equals(strCheckSum)) {
			            	
			            	  strAuthStatus = "0399";
			            	  
			            	  System.out.println("Transaction failed");
			            	  redirect(action:payment,id:appId)
			               }
			               
			               else{
			            	  
			            	
			            	  println("--------------------successful transacti-----")
			             	 
			            	
			             	 
			             	  
			            		if(!appPendingInst){
			            	 
			            	  
			            	  def a = new GetData((indApplicationDetailsInstance.id).toLong())
//			            	 
//			            	  System.out.println("--------------in get data------->"+a.getCategory())
//			   
//			            	  
			            	  a.routeApp()
			            			}
			            	 
			             	  
			             	  def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
			            	 
			            	  def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
			            	
			            	  def transInstance = BankTransactionDetails.get(strCustomerID)
				
			            	  
			            	  transInstance.transactionStatus = "S"
			            	
				
			            	  println("strCSTBANKID---"+strCSTBANKID)
			            	    
			            	
			            	   	if(strBillerId=="JPCB"){
			            	   
			            	  if(strCSTBANKID=="1210")
			            	  {
			            		 
			            	//	  transInstance.paymentType="Credit"
			            		 
			            	  }
			            	  
			            	  if(strCSTBANKID=="1110")
			               	{
			               		
			            		
			               //		transInstance.paymentType="Debit"
			               		
			               		
			               	}
			            	  
			            	   	}
			             	  
			            	   	else{
			            	  
			            	   		println("---------------------strBillerId-----"+strBillerId)	
			            	   		
			            	 def bankId = BankMaster.find("from BankMaster abc where abc.bankCode=?",[strCSTBANKID])
			             	  println(bankId)
			             	  if(bankId){
			             	 transInstance.bankName = bankId.bankName
			             	  }
			             	  else{
			             		 transInstance.bankName = "NA"  
			             	  }
			             	transInstance.bankId = strCSTBANKID
			             	 
			             	 println("transInstance.bankName==============="+transInstance.bankName)
			            	   	}
			            	  transInstance.lastUpdated = new Date()
			           		
			            	 
			            	  
			           		if(transInstance.save()){
			           			
			           		  println("---idddd-"+ transInstance.id)
			           			
			           		}
			               else{
			             	 if(transInstance.hasErrors()){
			             		transInstance.errors.allErrors.each {
			             	 println it
			             	 }
			             	 } 
			             	 }
			            	  
			       System.out.println("Transaction successful"); 
			       if(!appPendingInst){
			    	  System.out.println("redirecting to challanform gateway"+appPendingInst); 
			         render(view:'challanFormGateway',model:[indApplicationDetailsInstance:appId,feeDetailsList:feeDetailsList,
			                                          group:group.group.groupName,strMarketCode:strCustomerID,strCSTBANKID:strCSTBANKID,
			                                          dateVal:transInstance.lastUpdated,strTxnAmount:strTxnAmount,
			                                          status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,transInstance:transInstance])
			              
			       }
			       
			       else{
			    	  System.out.println("redirecting to online Payment Reciept"); 
			    	  render(view:'onlinePaymentReciept',model:[indApplicationDetailsInstance:appId,feeDetailsList:feeDetailsList,
			    	                                             group:group.group.groupName,strMarketCode:strCustomerID,strCSTBANKID:strCSTBANKID,
			    	                                             dateVal:transInstance.lastUpdated,strTxnAmount:strTxnAmount,
			    	                                             status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,transInstance:transInstance])
			    	                  
			       }
			                                      
			               }
			               }
			           else{
			        	  strAuthStatus = "0399";  
			        	  
			        	  System.out.println("Transaction failed due to invalid parameters");   
			           }
			           }
				  
				  else{
					  strAuthStatus = "0399"; 
					  
					  if(!appPendingInst){
						  
						  System.out.println("redirecting to payment page");   
					  redirect(action:payment,id:appId)
					  }
					  else{
						  System.out.println("redirecting to add payment through clarification");   
						  redirect(action:addPayment,id:appId)   
						  
					  }
			    	  System.out.println("Transaction failed11");   
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
	
	def eWalletName1 = {
			try {
				println("eWalletName Name params------>"+params)
				def refundTransaction = new RefundTransactionDetails()
					def bank
				println("session--------->"+session)
					if (params.radio=="refund"){
						def id = session.getAttribute("random")
						refundTransaction.tpslId = ""
				    	refundTransaction.amount = params.refundAmount
				    	refundTransaction.bankName = params.bankName
				    	refundTransaction.name = params.accountName
				    	refundTransaction.accountNo = params.accountNo
				    	refundTransaction.ifscCode = params.ifscCode
				    	refundTransaction.indUser =  session.getAttribute("indUser")
				    	refundTransaction.dateCreated = new Date()
				    	refundTransaction.lastUpdated = new Date()
				    	refundTransaction.refundStatus = "F"
				    	refundTransaction.id = id
				    	refundTransaction.paymentType=params.radio        	 	
				    	refundTransaction.save()   
				    	
				    	
								//MCGM~12371~NA~NA~date~EMD~ok
									 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:ms");
				                      Date newdate=new Date();
				                     String date=dateFormat.format(newdate);
				                 //    String fee = session.getAttribute("fee")	
									def refundAccNo = params.accountNo
									
									def ifsc = params.ifscCode
									def bankName = params.bankName
						        	def payeeName = params.accountName
						        	def ewalletNo = session.getAttribute("indUser")	   	
						        	
							def accNo = "JPCB"+"~"+"DEMOUSER"+"~"+refundAccNo+"~NA~"+date+"~Refund~"+ifsc+"\$"+payeeName+"\$"+bankName
						//	def accNo1 = "JPCB"+"~"+ewalletNo+"~"+refundAccNo+"~NA~"+date+"~Refund~"+ifsc+"\$"+payeeName+"\$"+bankName
							def accNo1 = "JPCB"+"~"+"G151432899"+"~"+refundAccNo+"~NA~"+date+"~Refund~"+ifsc+"\$"+payeeName+"\$"+bankName
								
							
				      	    //	def indAddress = indApplicationDetailsInstance.indUser.indAddress
				            	println("accNo----"+accNo)
									println("accNo11111111----"+accNo1)
				        			String merchantCode = "JPCB"
				    	    String accountNu = accNo
				    	    String accountNu1 = accNo1
				    	    String fee = params.refundAmount
				    	    String txnAmount="0.00"
				       		 if(fee){
				       			 txnAmount=fee+"0"
				       		 }
				       		 String txnAmount1="0.0"
				           		 if(fee){
				           			 txnAmount1=fee
				           			    }
				       		 String shoppingCart=txnAmount1+".00"
				       		 
				       		 println("fee------------------->"+fee)
				         println("shoppingCart------------------>"+shoppingCart)
				    	    
				    	    String bankCode ="ICICI"
				    	    CheckSumRequestBean obj = new CheckSumRequestBean();
				    	    String merchantId = id    		
				    		obj.setStrMerchantTranId(merchantId);
				    	    obj.setStrMarketCode(merchantCode);
				    	    obj.setStrAccountNo(accountNu1);
				    	    obj.setStrAmt(shoppingCart);
				    	    obj.setStrBankCode(bankCode);
				    	    String contextPath = getServletContext().getRealPath("")+"/file2.properties/";
				    	  
				    	
				    	    obj.setStrPropertyPath(contextPath)
				    	
				    	    com.TPSLUtil util = new com.TPSLUtil();
				    	    String strMsg = util.transactionRequestMessage(obj)
				    println("strMsg----------------->"+strMsg)
				   
				    	    render(view:'eWalletRefundName1',model:[refundTransaction:refundTransaction,strMsg:strMsg])
				}else
							{
							def accountNo = "JPCB"+session.getAttribute("indUser")
							println("session.getAttribute(induser)....................."+accountNo)
							 render(view:'eWalletChallanReciept',model:[accountNo:accountNo])
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
   
	def popChallan = {
			
		  	   if(session.indUser==null && session.userMaster==null)
	           {
	             redirect(uri:'/index.gsp')
	       		return

	           }  
			 try {
					println("params:"+params)
					def indApplicationDetailsInstance = IndApplicationDetails.get(params.id)
						def feesBankOnlineInstance = BankTransactionDetails.findAll("from BankTransactionDetails fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
						def check = false
						def neftTransInstance 
						println("feesBankOnlineInstance:"+feesBankOnlineInstance)
						if(neftTransInstance){
							check=true
						}
						def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
					println("group---"+group.group.groupName)
						def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
					[appDetId:params.id,check:check,neftTransInstance:neftTransInstance,feesBankOnlineInstance:feesBankOnlineInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,group:group.group.groupName,feeDetailsList:feeDetailsList,back:params.back]
					 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	 def refundResponse1 = {
			try {
				println("======session============="+session)
					println("======session End=============")
					System.out.println("msg-------"+request.getParameter("msg"));
					String strBillerId = "";
					String strMarketCode = "";
					String strAccountNo = "";
					String strResponseUrl = "";
					String strMsg = "";
					String strCustomerID = "";
					String strTransactionRefNo = "";
					String strBankRefNo = "";
					String strTxnAmount = "";
					String strCSTBANKID = "";
					String strBankMerchantId = "";
					String strTxnType = "";
					String strMerCRN = "";
					String strItemCode = "";
					String strSecurityType = "";
					String strSecurityId = "";
					String strSecurityPassword = "";
					String strTranDate = "";
					String strAuthStatus = "";
					String strSettlementType = "";
					String strAddInfo1 = "";
					String strAddInfo2 = "";
					String strAddInfo3 = "";
					String strAddInfo4 = "";
					String strAddInfo5 = "";
					String strAddInfo6 = "";
					String strAddInfo7 = "";
					String strReturnURL = "";
					String strErrorStatus = "";
					String strErrorDescription = "";
					String strCheckSum = "";
					String strStatus = "";
					String strCheckSumValue = "";
					String strResponseMsg="";
				strResponseMsg =  request.getParameter("msg");
					StringTokenizer token = new StringTokenizer(strResponseMsg,"|");
				    println("tokennnnnnnnnnnnnnnn--------------"+token.countTokens());
						if(token.countTokens()==26)
							{
								strBillerId=token.nextToken();
								strCustomerID=token.nextToken();
								strTransactionRefNo=token.nextToken();
								strBankRefNo=token.nextToken();
								strTxnAmount=token.nextToken();
								strCSTBANKID=token.nextToken();
								strBankMerchantId=token.nextToken();
								strTxnType=token.nextToken();
								strMerCRN=token.nextToken();
								strItemCode=token.nextToken();
								strSecurityType=token.nextToken();
								strSecurityId=token.nextToken();
								strSecurityPassword=token.nextToken();
								strTranDate=token.nextToken();
								strAuthStatus=token.nextToken();
								strSettlementType=token.nextToken();
								strAddInfo1=token.nextToken();
								strAddInfo2=token.nextToken();
								strAddInfo3=token.nextToken();
								strAddInfo4=token.nextToken();
								strAddInfo5=token.nextToken();
								strAddInfo6=token.nextToken();
								strAddInfo7=token.nextToken();
								strErrorStatus=token.nextToken();
								strErrorDescription=token.nextToken();
								strCheckSum=token.nextToken();
							}
							else
							{
								System.out.println("Inside ELSE of Response***********");
							}
						System.out.println("strTranDate---**"+strTranDate);
						//strResponseMsg =  request.getParameter("msg");		
					 String contextPath
					  
				           if(strBillerId=="MCGM"){
					   contextPath = getServletContext().getRealPath("")+"/file2.properties/";
				            	  }
				            	  else{
				            		  
				            		  
				            		  
				            		  contextPath  = getServletContext().getRealPath("")+"/file2.properties/";   
				            	  }
					  
					  
					  println("---------------------strBillerId-----"+strBillerId)
					
					  com.CheckSumResponseBean res = new com.CheckSumResponseBean();
					  	
						res.setStrMSG(strResponseMsg); 
					   println("---------------------m here-----")
						res.setStrPropertyPath(contextPath);
					
						 println("--------------------have reached here-----")
						
					
					com.TPSLUtil util = new com.TPSLUtil();
					strCheckSumValue = util.transactionResponseMessage(res);
					
					 println("strAuthStatus==============="+strAuthStatus)
						println("strCheckSumValue==============="+strCheckSumValue)
					  if (strAuthStatus != null && strAuthStatus.equals("0300")) {
				           if (!strCheckSumValue.equals("")) {
				               if (!strCheckSumValue.equals(strCheckSum)) {
				            	
				            	  strAuthStatus = "0399";
				            	  
				            	  System.out.println("Transaction failed");
				            	  redirect(controller:indUser,action:openIndustryHome)
				               }
				               
				               else{
				            	  
				            	
				            	  println("--------------------successful transacti-----")
				              def transInstance = RefundTransactionDetails.get(strCustomerID)
					
				            	  
				            	  transInstance.refundStatus = "S"
				            		  println("strTransactionRefNo---"+strTransactionRefNo)
				            	  
				            		  transInstance.tpslId = strTransactionRefNo
					
				            	  println("strCSTBANKID---"+strCSTBANKID)
				            	    
				            	
				            	 
				            	  transInstance.lastUpdated = new Date()
				           		
				            	 
				            	  
				           		if(transInstance.save()){
				           			
				           		  println("--transInstance----idddd-"+ transInstance.id)
				           			
				           		}
				               else{
				             	 if(transInstance.hasErrors()){
				             		transInstance.errors.allErrors.each {
				             	 println it
				             	 }
				             	 } 
				             	 }
				            	  
				       System.out.println("Transaction successful"); 
				       
				       
				       
				     
				    	   System.out.println("redirecting to Refund Page"); 
				     	  render(view:'refundPage',model:[])
				    	   
				    
				                                      
				               }
				               }
				           else{
				        	  strAuthStatus = "0399";  
				        	  
				        	  System.out.println("Transaction failed due to invalid parameters");   
				           }
				           }
					  
					  else{
						  strAuthStatus = "0399"; 
						  
						 
							  
							  System.out.println("redirecting to payment page");   
							  redirect(controller:"indUser",action:"openIndustryHome")
					  
				    	  System.out.println("refund failed11");   
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
	    
	def challan = {
			 try {
			    	def indApp = params.indAppDetId
			    	String encdata1 = request.getParameter("encdata")
			    	EncodeDecode encodeDecode = new EncodeDecode()
			    	String encdata2 = encdata1.replace("~","+")
					String str1=encodeDecode.Decrypt(encdata2,"a@m#i@t");
					String[] res = str1.split("&");
			  String[] desName3 = res[2].split("=");
				 String stVal = desName3[1]
			  if(stVal=="N")
			    {
			    	flash.message = "Your Transaction is Incomplete"
			    	render(view:'errorPage')
			    }
			    else
			    {
			    String[] desName4 = res[4].split("=");
			    String[] desName6 = res[6].split("=");
				String[] desName8 = res[7].split("=");
				String[] desName2 = res[2].split("=");
				String prnVal = desName4[1]
			    String bankVal = desName6[1]
				String statusVal = desName8[1]
			    String dateVal = desName2[1]
			    	def indApplicationDetailsInstance = IndApplicationDetails.get(session.appId)
			    	if(session.check1!="true")
					    	{
					    	def a = new GetData((indApplicationDetailsInstance.id).toLong())
			    	a.routeApp()
					    	}
				def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
					def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
			    	def transInstance = BankTransactionDetails.get(prnVal)
			    	transInstance.bankId = bankVal
			    	
			    	SimpleDateFormat sdfh = new SimpleDateFormat("dd/MM/yyyy hh:mm"); 
				if(statusVal=="Y")
			    	{
			    	transInstance.transactionStatus = "S"
			    	}
			    transInstance.save()
			    if(session.check1!="true")
					    	{
			    	indApplicationDetailsInstance.completionStatus = "completed"
			    if(indApplicationDetailsInstance.save())
			    	{
			    	}
			    		}
			    	render(view:'challanForm',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feeDetailsList:feeDetailsList,group:group.group.groupName,check1:session.check1])
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
	
	def responsePage={
			 try {
					println("====PARAMS IN responsePage==============="+params)
					def testVal=session.getAttribute("testVal")
				    
					System.out.println("msg-------"+request.getParameter("msg"));
					String msg = request.getParameter("msg")
					String strKey = "1365775075TETTPF" // will be diff for merchant code
					String strIV = "5124632302OFYFAB" // will be diff for merchant code
					TransactionResponseBean  beanObj=new TransactionResponseBean ();
					beanObj.setIv(strIV.getBytes());
				    beanObj.setKey(strKey.getBytes());
				    beanObj.setResponsePayload(msg); //set the pg response message
					String aa =  beanObj.getResponsePayload();
				    println("a--------hereee-----"+aa)
					String strTransactionRefNo = ""; //TPSL txn id
					String strTxnAmount = ""; //amount of txn
					String strCSTBANKID = ""; // bank code
					String strTranDate = ""; // txn date
					String strAuthStatus = ""; // 0300(s),0399(f)
					String strErrorDescription = ""; // error of description with code
					String strAuthTxnMsg = ""; //success /fail msg
					String strAddInfo = "";  // client meta data like- itc,mobile no.,customer name, email -id
					String strTpslRefndId = ""; // NA
					String strBalnceAmt = ""; //NA
					String strReqToken = ""; // request token encrypted
					String strHash = ""; // hash value
					String strCustomerID = ""; //bankTransactionDetails id

						StringTokenizer token = new StringTokenizer(aa,"|");
						String[] result
						String[] resultMsg
						String[] cstBankId
						String[] customerId
						String[] txnAmt
						println("---11111-----token.countTokens()--------------"+token.countTokens())
						if(token.countTokens()==13)
							{
							 strAuthStatus = token.nextToken();
							 strAuthTxnMsg = token.nextToken();
							 strErrorDescription =token.nextToken();
							 strCustomerID = token.nextToken();
							 strCSTBANKID = token.nextToken();
							 strTransactionRefNo = token.nextToken(); //TPSL txn id
							 strTxnAmount = token.nextToken();
							 strAddInfo = token.nextToken();  // client meta data like- itc,mobile no.,customer name, email -id
							 strTranDate = token.nextToken();
							 strTpslRefndId = token.nextToken();
							 strBalnceAmt = token.nextToken();
							 strReqToken = token.nextToken();
							 strHash = token.nextToken();
							 System.out.println("strAuthStatus---**"+strAuthStatus);
							 result = strAuthStatus.split("=");
							 resultMsg = strAuthTxnMsg.split("=");
							 cstBankId = strCSTBANKID.split("=");
							 customerId = strCustomerID.split("=");
							 txnAmt = strTxnAmount.split("=");
							 
							 System.out.println("result***********"+result);
							 System.out.println("resultMsg***********"+resultMsg);
							 System.out.println("cstBankId***********"+cstBankId);							 
							 System.out.println("customerId***********"+customerId);
							 System.out.println("txnAmt***********"+txnAmt);
							 
							 
							}
							else
							{
								System.out.println("Inside ELSE of Response***********");
							}
					   def transInstance = BankTransactionDetails.get(customerId[1])
					   def appId = transInstance.indApplication
					   def indApplicationDetailsInstance = IndApplicationDetails.get(appId.id)
					   def indName = indApplicationDetailsInstance.indUser.indName
					    String industryName = indApplicationDetailsInstance.id
					  def indEmail = indApplicationDetailsInstance.indUser.indEmail
					  String industryEmail = indEmail
					  def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[indApplicationDetailsInstance])
					   def inst = indApplicationDetailsInstance.applicationType
					   def inst1 = indApplicationDetailsInstance.applicationFor
					   def inst2 = indApplicationDetailsInstance.certificateFor
					   def val = indApplicationDetailsInstance.indUser
					   println("val------------------"+val)
					   println("------------"+val.occName)
					   def occName = val.occName
					   def returnStatus = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by id desc",[indApplicationDetailsInstance])
					  if(returnStatus)
						  {
						  if(returnStatus.returned==true && returnStatus.resubmitStatus!=true){
							  testVal="true"
						}else{
							testVal=""
						}
					}else{
						testVal=""
					}
					  
					   if(session.appId){
						   
					   }else{
						   session.fee = transInstance.amount
						   session.indregName = indApplicationDetailsInstance.indUser
						   session.appId = indApplicationDetailsInstance.id
						   session.login = "xyz"
						   def insUser=IndUser.findByIndustryRegMaster(indApplicationDetailsInstance.indUser)
						   session.indUser = insUser
						   session.random = transInstance.id
						   session.testVal=testVal
						 }
					   def fee = transInstance.amount
					   if (resultMsg[1].equals("success") && result[1].equals("0300")) {
					    println("--------------------successful transacti-----")
					            	  def id1 = transInstance.id
					            	   String merchantId1=id1
					            	   println("..merchantId1.."+merchantId1);
					            	    TransactionRequestBean objTransactionRequestBean=new TransactionRequestBean();
					            	    
					            	    String txnAmount="0.00"
					               		 if(fee){
					               			 txnAmount=fee+"0"
					               		 }
					            	    String txnAmount1="0.0"
					               		 if(fee){
					               			 txnAmount1=fee
					               		 }
					           		   String shoppingCart="FIRST_"+txnAmount1+"_0.0"
					           		   def sdfh = new SimpleDateFormat("dd-MM-yyyy");   
					           		   objTransactionRequestBean.setStrRequestType("S");
					                   objTransactionRequestBean.setStrMerchantCode("L235106");
					                   objTransactionRequestBean.setMerchantTxnRefNumber(merchantId1);
					                   objTransactionRequestBean.setStrAmount(txnAmount); // amount will be dynamic , need to pass
					                   objTransactionRequestBean.setStrCurrencyCode("INR"); 
					                   objTransactionRequestBean.setStrITC("NA"); // to send extra parameter
					                // objTransactionRequestBean.setStrReturnURL("http://jhkocmms.nic.in/OCMMS/indApplicationDetails/responsePage"); // return url whr response has to be recieved
					                   objTransactionRequestBean.setStrReturnURL("NA"); // return url whr response has to be recieved
					             //    objTransactionRequestBean.setStrS2SReturnURL("https://tpslvksrv6046/LoginModule/Test.jsp"); // to be entered as NA 
					                   objTransactionRequestBean.setStrShoppingCartDetails(shoppingCart); // statename(scheme code)_txnamount_0.0
					                   objTransactionRequestBean.setTxnDate(sdfh.format(new Date())); // txn date(datecrated from banktransactiondetails table)
					                   objTransactionRequestBean.setStrBankCode("NA"); // bank code from bank master
					                   //objTransactionRequestBean.setWebServiceLocator("https://www.tekprocess.co.in/PaymentGateway/services/TransactionDetailsNew"); // need to be change when to be upload on live
					                   objTransactionRequestBean.setWebServiceLocator("https://www.tpsl-india.in/PaymentGateway/services/TransactionDetailsNew"); // need to be change when to be upload on live
					                   objTransactionRequestBean.setStrTPSLTxnID("NA");  //NA
					                   objTransactionRequestBean.setStrMobileNumber("NA"); //NA
					                   objTransactionRequestBean.setKey(strKey.getBytes());
					                   objTransactionRequestBean.setIv(strIV.getBytes());
					                   objTransactionRequestBean.setStrCustomerName(industryName);//industry name
					                   objTransactionRequestBean.setLogPath("/home1/payloadLog/MerchantRequestLog/txt.log");//NA
					                   objTransactionRequestBean.setStrEmail(industryEmail);//email id of industry
					                   String strMsg =  objTransactionRequestBean.getTransactionToken();

					                   println("strMsg---S-----"+strMsg)
					                   
					                   StringTokenizer token1 = new StringTokenizer(strMsg,"|");
					               	
					                   String strAuthStatus1 = "";
					               	 String strAuthTxnMsg1 = "";
					               	 String[] result1
					               	 String[] resultMsg1
					               	 println("...token1.countTokens()..."+token1.countTokens());
					               	 /*
					               	   * ////for refund
					                  println("qertty-------------")
					                  TransactionRequestBean objTransactionRequestBean1=new TransactionRequestBean();
					                 	objTransactionRequestBean1.setStrRequestType("R");
					                         objTransactionRequestBean1.setStrMerchantCode("L235106");
					                         objTransactionRequestBean1.setMerchantTxnRefNumber("NA");
					                         objTransactionRequestBean1.setStrAmount(txnAmount);// amount will be dynamic , need to pass
					                         objTransactionRequestBean1.setStrCurrencyCode("INR"); 
					                         objTransactionRequestBean1.setStrITC("NA"); // to send extra parameter
					                         objTransactionRequestBean1.setStrReturnURL("NA"); // return url whr response has to be recieved
					                         objTransactionRequestBean1.setStrS2SReturnURL("NA"); // to be entered as NA 
					                         objTransactionRequestBean1.setStrShoppingCartDetails(shoppingCart); // statename(scheme code)_txnamount_0.0
					                         objTransactionRequestBean1.setTxnDate(sdfh.format(new Date())); // txn date(datecrated from banktransactiondetails table)
					                         objTransactionRequestBean1.setStrBankCode("NA"); // bank code from bank master
					                         objTransactionRequestBean1.setWebServiceLocator("https://www.tekprocess.co.in/PaymentGateway/services/TransactionDetailsNew"); // need to be change when to be upload on live
					                         objTransactionRequestBean1.setStrTPSLTxnID("179648737");  //NA
					                         objTransactionRequestBean1.setStrMobileNumber("8451053257"); //NA
					                         objTransactionRequestBean1.setKey(strKey.getBytes());
					                         objTransactionRequestBean1.setIv(strIV.getBytes());
					                         objTransactionRequestBean1.setStrCustomerName(industryName);//industry name
					                         objTransactionRequestBean.setLogPath("D://payloadLog//MerchantRequestLog//txt.log");//NA
					                         objTransactionRequestBean.setStrEmail(industryEmail);//email id of industry
					                 

					                         String strMsg1 =  objTransactionRequestBean1.getTransactionToken();
					                         println("strMsg1---R-----"+strMsg1)
					                         StringTokenizer token11 = new StringTokenizer(strMsg1,"|");
					                         println("...token11.countTokens()..."+token11.countTokens());
					                         ////////////////////////////
					                         * */
					               	 	
					                         if(token1.countTokens()==11 || token1.countTokens()==12 || token1.countTokens()==13)
					               				{
					                        	 strAuthStatus1 = token1.nextToken();
					                        	 strAuthTxnMsg1 = token1.nextToken();
					                        	 result1 = strAuthStatus1.split("=");    			 
					                        	 resultMsg1 = strAuthTxnMsg1.split("=");
					               			}
					                         println("Game Start Here Result---"+result1+"..and .resultMsg..."+resultMsg1)
					               			  
					               			    	
					                           	println("transInstance---"+transInstance)
					                           	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
					                            def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
					                           	   
					               			  	def bankTransactionInst
					                    		System.out.println("not verified-------"); 

					               			  	 if(result1 && resultMsg1){
					                     		 System.out.println(" verified single timeeeeeeeeeeeeeeeeeeeeeeeee-------"); 

					               				  System.out.println("==============="+result1[1]+"........."+resultMsg1[1])
					               				  if (resultMsg1[1].equals("SUCCESS") && result1[1].equals("0300")) {
					                     
					                               	   println("--------------------successful dual verification transacti-----")
					                               	   System.out.println(" verified 2nd timeeeeeeeeeeeeeeee-------"); 
					                               	   def a
					                               	  println("-testVal----"+testVal)
					                               	   if(testVal=="true"){
					                       				a = new GetData((indApplicationDetailsInstance.id).toLong())
					                       		    	System.out.println("--------------in get data---testVal---->"+a.getCategory())
					                       		    	//a.routeApp()	
					                       		    	a.routeAppForAppReturn()	
					                       		    	println("-----------qwerty--------")
					                       		     }else{
					                       			    a = new GetData((indApplicationDetailsInstance.id).toLong())
					                       		    	System.out.println("--------------in get data------->"+a.getCategory())
					                       		    	 a.routeApp() 
					                       		    	println("-----------qwerty11111111111111111--------")
					                       		      }
					                           			
					                           	  updateAllSummaryReport((indApplicationDetailsInstance.id).toString());	 
					                              println("customerId[1]---"+customerId[1])
					                           	  transInstance.transactionStatus = "S"
					                           	  println("strCSTBANKID---"+strCSTBANKID)
					                           	  println("cstBankId[1]---"+cstBankId[1])
					                           	  
					                           	  
					                           	  
					                            }
					               			  }
					         
					        	   if(cstBankId[1].equals("50") || cstBankId[1].equals("340") || cstBankId[1].equals("310") || cstBankId[1].equals("240") || 
					        			   cstBankId[1].equals("750") || cstBankId[1].equals("930") || cstBankId[1].equals("740") || cstBankId[1].equals("440") || cstBankId[1].equals("120")
					        			   || cstBankId[1].equals("1130") || cstBankId[1].equals("330") || cstBankId[1].equals("540") || cstBankId[1].equals("370") || cstBankId[1].equals("270")
					        			   || cstBankId[1].equals("300") || cstBankId[1].equals("10") || cstBankId[1].equals("520") || cstBankId[1].equals("490") 
					        			   || cstBankId[1].equals("420") || cstBankId[1].equals("860") || cstBankId[1].equals("830") || cstBankId[1].equals("350")
					        			   || cstBankId[1].equals("140") || cstBankId[1].equals("760") || cstBankId[1].equals("910") || cstBankId[1].equals("160") 
					        			   || cstBankId[1].equals("180") || cstBankId[1].equals("450") || cstBankId[1].equals("950") || cstBankId[1].equals("560")
					        			   || cstBankId[1].equals("530") || cstBankId[1].equals("550") || cstBankId[1].equals("880") || cstBankId[1].equals("680")
					        			   || cstBankId[1].equals("620") || cstBankId[1].equals("190") || cstBankId[1].equals("570") || cstBankId[1].equals("200")
					        			   || cstBankId[1].equals("130") || cstBankId[1].equals("1220"))
					              	{
					              		
					           		
					              		transInstance.paymentType="Net Banking"
					              		
					              		
					              	}
					        	   else {
					        		   transInstance.paymentType="Credit/Debit"
					        		   
					        	   }
					        	       		
					        	  def bankId = BankMaster.find("from BankMaster abc where abc.bankCode=?",[cstBankId[1]])
					         	 if(bankId){
					         	 transInstance.bankName = bankId.bankName
					         	   }
					         	   else
					         	   {
					         	 transInstance.bankName = "NA"
					         	
					         	   }
					         	 transInstance.bankId = cstBankId[1]
					         	 println("transInstance.bankName==============="+transInstance.bankName)
					        	 transInstance.lastUpdated = new Date()
					       		 System.out.println("Transaction details-------"+transInstance); 
					             System.out.println("Transaction details status-------"+transInstance.transactionStatus); 

					        	   
					       		if(transInstance.save()){
					       		 System.out.println("Transaction details saved-------"+transInstance); 
					       		   // appPendingInst.completionStatus = "Complete"
					       			//appPendingInst.scrutinyStatus = "Complete"
					       				//appPendingInst.save()
					       		 
					       		    // println("---idddd-"+ transInstance.id)
					         		 System.out.println("Transaction details statusjjjjjjjjjjjj-------"+transInstance.transactionStatus); 

					       		}
					           else{
					         		 System.out.println("Transaction details not saved-------"+transInstance); 
					           		 System.out.println("Transaction details statusqweeeeeeeeeeeeeee-------"+transInstance.transactionStatus); 

					        	   if(transInstance.hasErrors()){
					         		 transInstance.errors.allErrors.each {
					         	  println it
					         	  }
					         	  } 
					         	  }
					      		 System.out.println("Transaction details statuswqeeee-------"+transInstance.transactionStatus); 

					   System.out.println("Transaction successful"); 
					   if(testVal=="true"){
					 		 System.out.println("Transaction details status2222222222222222-------"+transInstance.transactionStatus); 

						   System.out.println("redirecting to online Payment Reciept"); 
						   render(view:'onlinePaymentReciept',model:[indApplicationDetailsInstance:indApplicationDetailsInstance.id,feeDetailsList:feeDetailsList,
						                                              group:group.group.groupName,strMarketCode:customerId[1],strCSTBANKID:cstBankId[1],
						                                              dateVal:transInstance.lastUpdated,strTxnAmount:txnAmt[1],
						                                              status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,
						                                              testVal:testVal,transInstance:transInstance])
					   }
					   
					   else{
					 		 System.out.println("Transaction details status3333333333333-------"+transInstance.transactionStatus); 

						   System.out.println("redirecting to challanform gateway"+appPendingInst); 
					       render(view:'challanFormGateway',model:[indApplicationDetailsInstance:indApplicationDetailsInstance.id,feeDetailsList:feeDetailsList,
					                                        group:group.group.groupName,strMarketCode:customerId[1],strCSTBANKID:cstBankId[1],
					                                        dateVal:transInstance.lastUpdated,strTxnAmount:txnAmt[1],
					                                        status:transInstance.transactionStatus,val:val,occName:occName,inst:inst,inst1:inst1,inst2:inst2,
					                                        testVal:testVal,transInstance:transInstance])
						                   
					   }
					  
					       }
					   
					   else{
						    strAuthStatus = "0399"; 
					 		redirect(action:payment,id:indApplicationDetailsInstance.id)   
						    System.out.println("Transaction failed11");   
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
	    
	def doEditProceed={
			 try {
					 def indApplicationDetailsInstance=	IndApplicationDetails.get((params.id).toLong())
			        def industryRegMasterInstance=IndustryRegMaster.get(indApplicationDetailsInstance.indUser.id)
			        def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
					render(view:'doEdit',model:[testVal:params.testVal,indApplicationDetailsInstance:indApplicationDetailsInstance,
					                            industryRegMasterInstance:industryRegMasterInstance,consentFeeMasterInstance:consentFeeMasterInstance])
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
def deleteDocs=
	{
		println("in delete Docs.."+params)
		def app = IndApplicationDetails.get((params.indAppId).toInteger())
    	String apliId = (app.id).toString()
		 if((params.delete).getClass().getName()== "java.lang.String"){
    		def indApplicationDocInst = ApplicationDocuments.get((params.delete).toInteger())
    		indApplicationDocInst.delete()
    	}else{
    		if(params.delete)
        	for(int i=0;i<(params.delete).size();i++){
        		def indApplicationDocInst = ApplicationDocuments.get((params.delete[i]).toInteger())
        		indApplicationDocInst.delete()
        	}
    	}			
		redirect(action:popUploadDoc,id:app.id)	
	}
	def ajaxGetEnvironmentClearence ={
			println("params..."+params)
			def type="1";
			def formType="EC";
			def enterValueForSearch=params.environmentClearence;
			def state="-1";
			def category="-1";
			def listValue;
			def environmentalClearenceList = new ArrayList()
			EnvironmentalClearenceWebService ecs=new EnvironmentalClearenceWebService();
			environmentalClearenceList=ecs.sendEnvironmentClearenceValue(type,formType,enterValueForSearch,state,category);
			
			EnvironmentalClearenceDetails environmentalClearenceDetailsObj;
			
			if(environmentalClearenceList){
			
			def evcList = EnvironmentalClearenceDetails.findAll("from EnvironmentalClearenceDetails s where s.proposalNo=? ",[environmentalClearenceList[0]])
			
			if(evcList){
				
			}else{
				environmentalClearenceDetailsObj=new EnvironmentalClearenceDetails();
				environmentalClearenceDetailsObj.indUserUniversal=session.indUser.industryRegMaster;
				environmentalClearenceDetailsObj.proposalNo=environmentalClearenceList[0];
				environmentalClearenceDetailsObj.stateName=environmentalClearenceList[1];
				environmentalClearenceDetailsObj.proposalName=environmentalClearenceList[2];
				environmentalClearenceDetailsObj.category=environmentalClearenceList[3];
				environmentalClearenceDetailsObj.userAgencyName=environmentalClearenceList[4];
				environmentalClearenceDetailsObj.proposalRecievedon=environmentalClearenceList[5];
				environmentalClearenceDetailsObj.fileNo=environmentalClearenceList[6];
				environmentalClearenceDetailsObj.dateOfGrant=environmentalClearenceList[7];
				environmentalClearenceDetailsObj.letter=environmentalClearenceList[8];
				
				environmentalClearenceDetailsObj.save(flush:true);
			
			}
			}
			
			if(environmentalClearenceList){
				listValue="Yes"
				render listValue;
			}else{
				listValue="No"
				render listValue;
			}
		}

	def popEnvironmentalClearenceDetails={
		
			def evcList = EnvironmentalClearenceDetails.findAll("from EnvironmentalClearenceDetails s where s.indUserUniversal.id=? ",[params.id.toLong()])
		//	System.out.println(evcList);
			return[evcList:evcList]
			
	}
///////////////////////////////Added by Ritesh Sir/////////////////////////////////////////////
 def popStoreModeAdd = {
  		def app = IndApplicationDetails.get((params.id).toInteger())
  		def soliddetails = StoreMode.findAllByapp8(app)
  		return [appDetId:params.id, soliddetails:soliddetails]
        }
    
      def savesoliddetails = {
  		System.out.println("params"+params.app8)
  		
  		def app = IndApplicationDetails.get((params.app8).toInteger())
  		def soliddetails = new StoreMode()
  		soliddetails.name = params.name
  		soliddetails.category = params.category
  		soliddetails.roomsize = params.roomsize
  		soliddetails.storage = params.storage
  		
  		
  		soliddetails.app8 = IndApplicationDetails.get((params.app8).toInteger())
  		soliddetails.save()
  			
  			flash.message = "Details Saved"
  			redirect(action:popStoreModeAdd,id:app)
  }
  	def popStoreModeView = {
  			def app = IndApplicationDetails.get((params.id).toInteger())
  			def soliddetails = StoreMode.findAllByapp8(app)
  			return [appDetId:params.id, soliddetails:soliddetails]
  	}

  	def popStoreModeEdit = {
  			def app = IndApplicationDetails.get((params.id).toInteger())
  			def soliddetails = StoreMode.findAllByApp8(app)
  			
  			return [appDetId:params.id,soliddetails:soliddetails]
  		}
  	def editsoliddetails = {println("params...."+params)
  			def app = IndApplicationDetails.get((params.app8).toInteger())
  			println("params.delete"+params.delete)

  			
  			if((params.delete).getClass().getName()== "java.lang.String"){
  				println("par99999")
  				def soliddetails = StoreMode.get((params.delete).toInteger())
  				soliddetails.delete()
  			}else{
  				if(params.delete)
  					
  				for(int i=0;i<(params.delete).size();i++){
  					println("padjfjdkjlkcsjhfkjdr99999")
  					def soliddetails = StoreMode.get((params.delete[i]).toInteger())
  				soliddetails.delete()
  				}
  			}
  			redirect(action:popStoreModeEdit,id:app)
  			
  		}

	 def popQuantHazAdd = {
	  		def app = IndApplicationDetails.get((params.id).toInteger())
	  		def soliddetails1 = QuantHaz.findAllByapp8(app)
	  		return [appDetId:params.id, soliddetails1:soliddetails1]
	        }
	    
	      def saveStoreModedetails = {
	  		System.out.println("params"+params.app8)
	  		
	  		def app = IndApplicationDetails.get((params.app8).toInteger())
	  		def soliddetails1 = new QuantHaz()
	  		soliddetails1.name = params.name
	  		soliddetails1.nature = params.nature
	  		soliddetails1.category = params.category
	  		soliddetails1.totalquant = params.totalquant
	  		soliddetails1.quantTSDF = params.quantTSDF
	  		soliddetails1.quantRec = params.quantRec
	  		soliddetails1.quantPre = params.quantPre
	  		
	  		
	  		soliddetails1.app8 = IndApplicationDetails.get((params.app8).toInteger())
	  		soliddetails1.save()
	  			
	  			flash.message = "Details Saved"
	  			redirect(action:popQuantHazAdd,id:app)
	  }
	    
	    def popQuantHazView = {
	  			def app = IndApplicationDetails.get((params.id).toInteger())
	  			def soliddetails1 = QuantHaz.findAllByapp8(app)
	  			return [appDetId:params.id, soliddetails1:soliddetails1]
	  	}
	    
 def popQuantHazEdit = {
	  			def app = IndApplicationDetails.get((params.id).toInteger())
	  			def soliddetails1 = QuantHaz.findAllByApp8(app)
	  			
	  			return [appDetId:params.id,soliddetails1:soliddetails1]
	  		}
def editstormodedetails = {println("params...."+params)
	  			def app = IndApplicationDetails.get((params.app8).toInteger())
	  			println("params.delete"+params.delete)

	  			
	  			if((params.delete).getClass().getName()== "java.lang.String"){
	  				println("par99999")
	  				def soliddetails1 = QuantHaz.get((params.delete).toInteger())
	  				soliddetails1.delete()
	  			}else{
	  				if(params.delete)
	  					
	  				for(int i=0;i<(params.delete).size();i++){
	  					println("padjfjdkjlkcsjhfkjdr99999")
	  					def soliddetails1 = QuantHaz.get((params.delete[i]).toInteger())
	  				soliddetails1.delete()
	  				}
	  			}
	  			redirect(action:popQuantHazEdit,id:app)
	  			
	  		}
	 def popHazsubAdd = {
	  		def app = IndApplicationDetails.get((params.id).toInteger())
	  		def Hazsubdetails = Hazsub.findAllByapp8(app)
	  		return [appDetId:params.id, Hazsubdetails:Hazsubdetails]
	        }
	    
	      def saveHazsubdetails = {
	  		System.out.println("params"+params.app8)
	  		
	  		def app = IndApplicationDetails.get((params.app8).toInteger())
	  		def Hazsubdetails = new Hazsub()
	  		Hazsubdetails.name = params.name
	  		Hazsubdetails.quantity = params.quantity
	  		Hazsubdetails.app8 = IndApplicationDetails.get((params.app8).toInteger())
	  		Hazsubdetails.save()
	  			
	  			flash.message = "Details Saved"
	  			redirect(action:popHazsubAdd,id:app)
	  }
	  	def popHazsubView = {
	  			def app = IndApplicationDetails.get((params.id).toInteger())
	  			def Hazsubdetails = Hazsub.findAllByapp8(app)
	  			return [appDetId:params.id, Hazsubdetails:Hazsubdetails]
	  	}

	    def popHazsubEdit = {
	  			def app = IndApplicationDetails.get((params.id).toInteger())
	  			def Hazsubdetails = Hazsub.findAllByApp8(app)
	  			
	  			return [appDetId:params.id,Hazsubdetails:Hazsubdetails]
	  		}
	  	def editHazsubdetails = {println("params...."+params)
	  			def app = IndApplicationDetails.get((params.app8).toInteger())
	  			println("params.delete"+params.delete)

	  			
	  			if((params.delete).getClass().getName()== "java.lang.String"){
	  				println("par99999")
	  				def Hazsubdetails = Hazsub.get((params.delete).toInteger())
	  				Hazsubdetails.delete()
	  			}else{
	  				if(params.delete)
	  					
	  				for(int i=0;i<(params.delete).size();i++){
	  					println("padjfjdkjlkcsjhfkjdr99999")
	  					def Hazsubdetails = Hazsub.get((params.delete[i]).toInteger())
	  				Hazsubdetails.delete()
	  				}
	  			}
	  			redirect(action:popHazsubEdit,id:app)
	  			
	  		}
	def popHazwasteAdd = {
	  		def app = IndApplicationDetails.get((params.id).toInteger())
	  		def Hazwastedetails = Hazwaste.findAllByapp8(app)
	  		return [appDetId:params.id, Hazwastedetails:Hazwastedetails]
	        }
	    
	      def saveHazwastedetails = {
	  		System.out.println("params"+params.app8)
	  		
	  		def app = IndApplicationDetails.get((params.app8).toInteger())
	  		def Hazwastedetails = new Hazwaste()
	  		Hazwastedetails.name = params.name
	  		Hazwastedetails.quantity = params.quantity
	  		Hazwastedetails.app8 = IndApplicationDetails.get((params.app8).toInteger())
	  		Hazwastedetails.save()
	  			
	  			flash.message = "Details Saved"
	  			redirect(action:popHazwasteAdd,id:app)
	  }
	  	def popHazwasteView = {
	  			def app = IndApplicationDetails.get((params.id).toInteger())
	  			def Hazwastedetails = Hazwaste.findAllByapp8(app)
	  			return [appDetId:params.id, Hazwastedetails:Hazwastedetails]
	  	}

	    def popHazwasteEdit = {
	  			def app = IndApplicationDetails.get((params.id).toInteger())
	  			def Hazwastedetails = Hazwaste.findAllByApp8(app)
	  			
	  			return [appDetId:params.id,Hazwastedetails:Hazwastedetails]
	  		}
	  	def editHazwastedetails = {
			println("params...."+params)
	  			def app = IndApplicationDetails.get((params.app8).toInteger())
	  			println("params.delete"+params.delete)
	  			if((params.delete).getClass().getName()== "java.lang.String"){
	  				println("par99999")
	  				def Hazwastedetails = Hazwaste.get((params.delete).toInteger())
	  				Hazwastedetails.delete()
	  			}else{
	  				if(params.delete)
	  				for(int i=0;i<(params.delete).size();i++){
	  					println("padjfjdkjlkcsjhfkjdr99999")
	  					def Hazwastedetails = Hazwaste.get((params.delete[i]).toInteger())
	  				Hazwastedetails.delete()
	  				}
	  			}
	  			redirect(action:popHazwasteEdit,id:app)
	  		}
////////////////////////////For Additional payment(In case of Clarification)/////////////////////////////
	def addPayment = {
			 try {
				    
		    	 def indApplicationDetailsInstance = IndApplicationDetails.get( (params.id ).toLong())
		    	def feeAmountId = ConsentFeeMaster.find("from ConsentFeeMaster abc where abc.application = ?",[indApplicationDetailsInstance])
		    	def feeAmount = (feeAmountId.totalApplicableFee).toInteger()
		    	
		    	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
		        	def totalfee = 0.0
		        	
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
		    	render(view:'addPayment',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feeAmount:totalfee])
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
	  def addPaymentNew = {

			 try {
				    
		    	 def indApplicationDetailsInstance = IndApplicationDetails.get( (params.id ).toLong())
		    	println("indApplicationDetailsInstance:"+indApplicationDetailsInstance)
		    	 def feeAmountId = ConsentFeeMaster.find("from ConsentFeeMaster abc where abc.application = ? order by id desc",[indApplicationDetailsInstance])
		    	println("feeAmountId:"+feeAmountId)
		    	 def feeAmount = (feeAmountId.totalFees).toFloat()
		    	println("feeAmount:"+feeAmount)
		    	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
		        	def totalfee = 0.0
		        	
		        	for(int i=0;i<feeDetailsList.size();i++)
		        	{
		        		totalfee = totalfee + feeDetailsList.get(i).amount
		        	}
		    	 def abc = feeAmount
				 def tes = abc.toDouble()
				 println("abc------"+abc)
				 println("tes------"+tes)
				 DecimalFormat df = new DecimalFormat("0.00");
				 df.setMaximumFractionDigits(2);
				 def ss = df.format(tes)
				 println("ss------"+ss)
				 println("ss-class-----"+ss.getClass().getName())
		        	
		    	render(view:'addPaymentNew',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,feeAmount:totalfee,ss:ss])
		    
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
def popFeeOtherDetailsAddAdditional = {
   		 try {
   			    
   	        	def app = IndApplicationDetails.get((params.id).toInteger())
   	        	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(app)
   	        	def totalfee = 0.0
   	        	
   	        	for(int i=0;i<feeDetailsList.size();i++)
   	        	{
   	        		totalfee = totalfee + feeDetailsList.get(i).amount
   	        	}
   	        	def feeCheque = FeeChequeRecord.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Details' order by id desc",[app])
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
def saveBankOtherFeeDetailsAdditional ={
   		 try {
   			   def app = IndApplicationDetails.get((params.appId).toInteger())
   		         def feeBankOtherDetailsObj=FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=? and fee.additionalfee='YES'",[app])
   		        			def feeBankDetails = new FeeBankOtherDetails()
   		            		feeBankDetails.application = app
   		            		feeBankDetails.additionalfee = "YES"
   		            		feeBankDetails.version = feeBankOtherDetailsObj.size()+1;
   		            		if(params.feeFor=="Other"){
   		            			feeBankDetails.feeFor = params.feeFor+","+params.otherDetail	
   		            		}
   		            		else
   		            		{           		
   		            		feeBankDetails.feeFor = params.feeFor
   		            		}
   		            	if(params.ddAmount != ""){
   		            			try{
   		            				feeBankDetails.amount = (params.ddAmount).toLong()
   		            			}catch (Exception e) {
   		            				feeBankDetails.amount = 0
   		            			}
   		        		}else{
   		        				feeBankDetails.amount = 0
   		        			}
   		        		if(feeBankDetails.save(flush:true)){}else{
   		        				feeBankDetails.errors.each {
   		        			        println it
   		        			   }
   		        			}
   		      redirect(action:popFeeOtherDetailsAddAdditional,id:app.id)
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
    
def addPaymentOption = {
    		 try {
    			 println("params.addPaymentOption.."+params)
    			   def indApp = params.indAppDetId
    			    	def indApplicationDetailsInstance
    			    	indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
    			    	String fees = params.addFee
    			    	 Random random = new Random(new Date().getTime());
    			    	int randomInt = random.nextInt(1000000000);
    			    	session.setAttribute("fee",fees)
    			    	println("i am here.........")
    					def feeBankDetailsObj = FeeBankOtherDetails.findAll("from FeeBankOtherDetails abc where abc.application=? and abc.additionalfee='YES'",[indApplicationDetailsInstance])
    						println("feeBankDetailsObj.."+feeBankDetailsObj)
    					if(!feeBankDetailsObj){
    							 flash.message ="Please Click on Add to Enter Additional Fees"
    								 redirect(action:addPayment,id:indApplicationDetailsInstance)
    								 return	
    						 }else{
    			    		redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance)
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
	
	   def addPaymentOptionNew = {

     		 try {
   			      		    	

   			    
   			   	def indApp = params.indAppDetId
   			    	def indApplicationDetailsInstance
   			    	
   			    	indApplicationDetailsInstance = IndApplicationDetails.get( params.indAppDetId)
   			    	
   			    	def totalFee=params.totalFees
   			    	String fees = params.addFee
   			    	 Random random = new Random(new Date().getTime());
   			    	int randomInt = random.nextInt(1000000000);
   			    	  
   			 
   					
   				session.setAttribute("fee",fees)
   					
   			    	  
   			    	if(params.radio=="online")
   			    	{
   			    		render(view:'addPaymentOptionNew',model:[totalFee:totalFee,indApplicationDetailsInstance:indApplicationDetailsInstance,fees:fees,randomInt:randomInt])
   			    	}
   			    	else
   			    	{
   			    		redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance)
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
def addBankPaymentMode={
			 try {
				   def indApplicationDetailsInstance = IndApplicationDetails.get(params.id)
				 return[indApplicationDetailsInstance:indApplicationDetailsInstance]
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

def updatefeeBankDetailSize={ 
			 try{
	    	def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
			def feeBankDetailSize=0
				def feeBankDetailsObj = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
			
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}
	    	println("feeBankDetailSize.....on controller..."+feeBankDetailSize)
			render feeBankDetailSize
	 
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
def popFeeDetailsAddAdditional = {
	    	 try {
	    	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	    	def feeDetailsList = FeeBankDetails.findAllByApplication(app)
	    	    	def feeCheque = FeeChequeRecord.findByIndApplication(app)
	    	    	def feeChequeAdditional=FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.additionalfee='YES'",[app])
	    	    	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque,feeChequeAdditional:feeChequeAdditional]
	    	     }catch(Exception e) {
	    	            e.printStackTrace();
	    				 flash.message = "Server Busy ..Please try after some time....";
	    				if(session.indUser){
	    			redirect(controller:'indUser',action:'openIndustryHome')
	    	 }
	    	 else if(session.userMaster){
	    	  redirect(controller:'userMaster',action:'openSpcbHome');
	    	 }else{
	    	        session.invalidate()
	    	        redirect(uri:'/index.gsp');
	    	 }
	    	   }
	    }
def saveBankFeeDetailsAdditional = {
	    	 try {
	    		 println("in saveBankFeeDetailsAdditional.."+params)
	    		 def dateCheck = params.dateval_value
	    	    	def currentDate=new Date()
	    	    	DateCustom dd=new DateCustom()
	    	    	def sqlCurrentDate=dd.sQLdate(currentDate)
	    	    	def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
	    			def x = sdfh.parse(dateCheck);
	    			def app = IndApplicationDetails.get((params.appId).toInteger())
	    			def feeBankOtherDetailsObj=FeeBankDetails.findAll("from FeeBankDetails fee where fee.application=? and fee.additionalfee='YES'",[app])
	   		        println("in feeBankOtherDetailsObj.."+feeBankOtherDetailsObj)
	   		        println("in params.ddNo.."+params.ddNo)
	    	    	if(x>sqlCurrentDate)
	    			{
	    				flash.message="DD/Cheque issue date can not be greater than current date"
	    				redirect(action:popFeeDetailsAddAdditional,id:app.id)
	    			}
	    	    	else
	    	    	{
	    	    		if((params.ddNo).getClass().getName()== "java.lang.String"){
	    	        		if(params.ddNo!=""){
	    	        			println("Here in String..")
	    	        			def feeBankDetails = new FeeBankDetails()
	    	            		feeBankDetails.application = app
	    	            		feeBankDetails.ddChequeNo = params.ddNo
	    	            		feeBankDetails.date = params.dateval_value
	    	            		feeBankDetails.bankName = params.bankName
	    	            		feeBankDetails.branch = params.branchName
	    	            		feeBankDetails.additionalfee = "YES"
	   		            		feeBankDetails.version = feeBankOtherDetailsObj.size()+1;
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
	    	        					println it;
	    	        			   }
	    	        			}
	    	        			}
	    	        	}else{
	    	        		println("Here in array..")
	    	        		for(int i=0;i<params.ddNo.size();i++){
	    	        			if(ddNo[i]!=""){
	    	        				def feeBankDetails = new FeeBankDetails()
	    	                		feeBankDetails.application = app
	    	                		feeBankDetails.ddChequeNo = ddNo[i]
	    	                		feeBankDetails.date = date[i]
	    	                		feeBankDetails.bankName = bankName[i]
	    	                		feeBankDetails.branch = branchName[i]
	    	        				feeBankDetails.additionalfee = "YES"
	    	   		            	feeBankDetails.version = feeBankOtherDetailsObj.size()+1;
	    	            			if(ddAmount[i]!=""){
	    	            				feeBankDetails.amount = (ddAmount[i]).toLong()
	    	            			}else{
	    	            				feeBankDetails.amount = 0
	    	            			}
	    	                		if(feeBankDetails.save(flush:true)){}else{
	    	                			feeBankDetails.errors.each {
		    	        					println it;
		    	        			   }
		    	        			}
	    	                	}
	    	        		}
	    	        	}	
	    	    	redirect(action:popFeeDetailsAddAdditional,id:app.id)
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
def popFeeDetailsViewAdditional = {
	    	 try {
	    	    	def app = IndApplicationDetails.get((params.id).toInteger())
	    	    	def feeDetailsList = FeeBankDetails.findAllByApplication(app)
	    	    	def feeCheque = FeeChequeRecord.findByIndApplication(app)
	    	    	def feeChequeAdditional=FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.additionalfee='YES'",[app])
	    	    	return [appDetId:params.id,feeDetailsList:feeDetailsList,feeCheque:feeCheque,feeChequeAdditional:feeChequeAdditional]
	    	    }catch(Exception e) {
	    	            e.printStackTrace();
	    				 flash.message = "Server Busy ..Please try after some time....";
	    				if(session.indUser){
	    			redirect(controller:'indUser',action:'openIndustryHome')
	    	 }
	    	 else if(session.userMaster){
	    	  redirect(controller:'userMaster',action:'openSpcbHome');
	    	 }else{
	    	        session.invalidate()
	    	        redirect(uri:'/index.gsp');
	    	 }
	    	   }
	    }
 def saveChequeAttachAdditional = {
   		 try {
   			 println("params..."+params)
   		    	def app = IndApplicationDetails.get((params.appId1).toInteger())
   		    	def feeCheque=FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.additionalfee='YES'",[app])
	   		    if(feeCheque){
   		       	feeCheque.delete()
   		      	}
   		   		def file1 = new FeeChequeRecord()
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
   			            	file1.additionalfee = "YES"
   			            	if(file1.save(flush:true)){}else{
   			            		file1.errors.each{
   			            			println it
   			            		}
   			            	}
   					}
   		   		redirect(action:popFeeDetailsAddAdditional,id:app)
   		   }catch(Exception e) {
   		            e.printStackTrace();
   					 flash.message = "Server Busy ..Please try after some time....";
   					if(session.indUser){
   				redirect(controller:'indUser',action:'openIndustryHome')
   		 }
   		 else if(session.userMaster){
   		  redirect(controller:'userMaster',action:'openSpcbHome');
   		 }else{
   		        session.invalidate()
   		        redirect(uri:'/index.gsp');
   		 }
   		   }
   }
def viewChequeAttachedAdditional={
   		 try {
   		    def applicationFileInstance
   		    	def application = IndApplicationDetails.get((params.appliLoc).toLong())
   		    	 applicationFileInstance=FeeChequeRecord.findAll("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Cheque' and afr.additionalfee='YES' order by id desc",[application],[max:1])
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
	def addConfirmation = {
			 try {
				 println("here in confirmation....")
			    	def indApplicationDetailsInstance = IndApplicationDetails.get(params.indAppDetId)
			        def indUserIns = (IndUser)(session.indUser)
			    	def abc = IndUser.get(indUserIns.id)
			    	FormPdf form=new FormPdf()
			    	def sessValue=(session.indUser).toString()
			    	def industryRegMasterInstance = abc.industryRegMaster
			    	def feeBankDetailsObj = FeeBankDetails.find("from FeeBankDetails abc where abc.application=? and abc.additionalfee='YES'",[indApplicationDetailsInstance])
						println("feeBankDetailsObj..1111111111111111"+feeBankDetailsObj)
					def feeBankChequeDetailsObj = FeeChequeRecord.find("from FeeChequeRecord abc where abc.indApplication=? and abc.additionalfee='YES'",[indApplicationDetailsInstance])
						println("feeBankChequeDetailsObj..1111111111111111"+feeBankChequeDetailsObj)
						if(!feeBankDetailsObj){
							flash.message ="Please Click on Add to Enter Additional Fees"
								 redirect(action:'addBankPaymentMode',id:indApplicationDetailsInstance)
							return
						}else if(!feeBankChequeDetailsObj){
							flash.message ="Please Attach Scan Copy for Additional Fees"
								 redirect(action:'addBankPaymentMode',id:indApplicationDetailsInstance)
							return
						}else{
						redirect(controller:'applicationProcessingDetails',action:'submitClarification',id:indApplicationDetailsInstance.id);
						return
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

	  def addConfirmationNew = {

			 try {
				    println("Inside Confirmation-------"+params)
			    	def indApplicationDetailsInstance = IndApplicationDetails.get(params.indAppDetId);
				    println("Inside Confirmation a-------"+indApplicationDetailsInstance)
				    def applicationId = (indApplicationDetailsInstance.id).toString()
					 def indName = indApplicationDetailsInstance.indUser.indName
					 def indAddress=indApplicationDetailsInstance.indUser.indAddress
					 def indDistrict=indApplicationDetailsInstance.indUser.district.districtName
					 def serviceId=indApplicationDetailsInstance.serviceId
					// def cafNo = indApplicationDetailsInstance.cafNo
					 def statusCode = ""
					 def printAppURL = ""
					 def downCertURL = ""
					 def remarks = ""
					 def pendingWith = ""
			        def indUserIns = (IndUser)(session.indUser)
			    	def abc = IndUser.get(indUserIns.id)
			    	def appPendInst
			    	def testVal = params.testVal
			    	FormPdf form=new FormPdf()
					def sessValue=(session.indUser).toString()		
			    	println("Session-------"+sessValue)
			    	float finalPayment = 0;
			    	def industryRegMasterInstance = abc.industryRegMaster
			    	println("industryRegMasterInstance-------"+industryRegMasterInstance)
			    	def fees = FeeBankDetails.find("from FeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])
					println("fees-------"+fees)
			    	def feeCheque = FeeChequeRecord.find("from FeeChequeRecord afr where afr.indApplication=? and afr.level='Fee_Cheque' order by id desc",[indApplicationDetailsInstance])
					println("feeCheque-------"+feeCheque)
			    	if(fees==null)
						{
							
							flash.message="Please Enter Bank Fee Details"
			         	    redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
			           	    return
						}
			    	

						else if(feeCheque==null)			
						{	
					
						flash.message="Please Attach Scan Copy Of all Drafts/Cheques "
							 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
							 return
						  }

			    	
					else
					{
						
					def feeDetailInst = FeeBankDetails.findAll("from FeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])	
					println("feeDetailInst-------"+feeDetailInst);
					for(int i=0; i<feeDetailInst.size(); i++)
					{
						
						finalPayment = finalPayment + feeDetailInst[i].amount
					}
					
					def conFeeInst = ConsentFeeMaster.find("from ConsentFeeMaster where application=? order by id desc",[indApplicationDetailsInstance])
					println("conFeeInst-------"+conFeeInst)
					println("finalPayment-------"+finalPayment)
					
				/*	if(conFeeInst){
						if(conFeeInst.totalFees == finalPayment)
						{
							
						}
						else{
								flash.message="Total Bank Amount should be equal to Total Payable Amount "
								 redirect(action:addBankPaymentMode,id:indApplicationDetailsInstance,industryRegMaster:industryRegMasterInstance)
								 return	
							
						}
						
					}*/
					println("conFeeInst-eeg------")
					indApplicationDetailsInstance.completionStatus = "completed"
			    	indApplicationDetailsInstance.applicationDate = new Date()
			    	indApplicationDetailsInstance.save()
			    	appPendInst = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
			    
			    if(appPendInst){
			    	appPendInst.scrutinyStatus="Complete"
			    	appPendInst.completionStatus = "Complete"
			    	appPendInst.completionDate = new Date()
			    	if(appPendInst.save()){
			    		
			    		
			    		def applcationProcessingDetails=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application.id = ? order by id desc",[indApplicationDetailsInstance.id])
						if(applcationProcessingDetails)
						{
							applcationProcessingDetails.scrutinyStatus="Complete"
							if(applcationProcessingDetails.save()){
							}
							else{
		            		applcationProcessingDetails.errors.each {
					    	println it
		            	}
		            		
						}
						}
			    		
			    	}else{
	            		appPendInst.errors.each {
				    	println it
				  }
	            		
			  }
			    	
			    	
			    	
			    }
			    
			    	
			    	if(testVal!="true"){
				         
			     		def delPDF = ApplicationFileRecord.find("from ApplicationFileRecord  as abc where abc.indApplication=? and abc.typeOfFile='Application Form'",[indApplicationDetailsInstance])  
			     		  if(delPDF!=null){
			     			 
			     		delPDF.delete()
			     		  }
			         
			   		
					 }
			    	
			    	/*if(indApplicationDetailsInstance.applicationType=="CTE") {
			    	
			    	form.formAir(indApplicationDetailsInstance.id,sessValue)
			    	}else{
			    	
			    	form.CtoFormWater(indApplicationDetailsInstance.id,sessValue)
			    	}*/
			    	def cat = indApplicationDetailsInstance.indUser.category.name
					// def ind = indApplicationDetailsInstance.indUser.typeOfIndustry
					 def appType = indApplicationDetailsInstance.applicationType
					 
					/* if(cat=="RED" && appType=="CTE" && ind=="industry"){
						 
						 form.formCteRedOrange(indApplicationDetailsInstance.id,sessValue)
					 
					 }else if(cat=="ORANGE" && appType=="CTE" && ind=="industry"){
						 
						 form.formCteRedOrange(indApplicationDetailsInstance.id,sessValue)
					 
					 }else if(cat=="GREEN" && appType=="CTE" &&  ind=="industry"){
						 
						 form.formCteGreen(indApplicationDetailsInstance.id,sessValue)
					 
					 }else if(appType=="CTE" &&  ind=="bmw"){
						println("cte hce industry ")
						 form.formCteHce(indApplicationDetailsInstance.id,sessValue)
					 
					 }else if(cat=="RED" && cat=="ORANGE" && appType=="CTO" && ind=="industry"){
						 
						 form.formCtoRedOrange(indApplicationDetailsInstance.id,sessValue)
					 
					 }else if(cat=="GREEN" && appType=="CTO" &&  ind=="industry"){
						 
						 form.formCtoGreen(indApplicationDetailsInstance.id,sessValue)
					 
					 }else if(appType=="CTO" &&  ind=="bmw"){
						
						 form.formCtoHce(indApplicationDetailsInstance.id,sessValue)
					 
					 }
			    	
			    	/*if(indApplicationDetailsInstance.applicationFor=="air") {
						form.formAir(indApplicationDetailsInstance.id,sessValue)
						formView="air"
					}
					else {
						if(indApplicationDetailsInstance.applicationFor=="water") {
							form.CtoFormWater(indApplicationDetailsInstance.id,sessValue)
							formView="water"
						}
						else {
							
							
							if(indApplicationDetailsInstance.applicationType=="CTE") {
								form.formAir(indApplicationDetailsInstance.id,sessValue)
								//form.formWaterPdf(indApplicationDetailsInstance.id,sessValue)
							formView="water"
							}
							else
							{
								//form.formAir(indApplicationDetailsInstance.id,sessValue)
								form.CtoFormWater(indApplicationDetailsInstance.id,sessValue)
								formView="both"
							}
							
						}
					}*/
			    	
			    	
			    	
					IndApplicationDetailsController inddetails=new IndApplicationDetailsController();
	               
			    	def formView = indApplicationDetailsInstance.applicationFor
			    	println("indApplicationDetailsInstance.applicationFor==========="+indApplicationDetailsInstance.applicationFor)
			    	if(indApplicationDetailsInstance.certificateFor=="autoReNew")
				    {
				    	def a = new GetData((indApplicationDetailsInstance.id).toLong())
		 		    	a.routeApp();
				    	def autoReNew="autoReNew";
				    	inddetails.updateAllSummaryReport(indApplicationDetailsInstance.toString());// added for allsummary update
				    	render(view:'confirmationSubmit',model:[testVal:true,formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
				    	
				    }else
				    {
				    	inddetails.updateAllSummaryReport(indApplicationDetailsInstance.toString());// added for allsummary update
				    	render(view:'confirmPayment',model:[formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
				    	/*if(indApplicationDetailsInstance.singleWindow){
	    					
	    					println("inside single window")
	    					def pendWith = ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id= ? order by id desc",[indApplicationDetailsInstance.id])
	    					statusCode = "P"
	    					pendingWith = (pendWith.pendingWith).toString()
	    					remarks = "Offline payment has been made of Rs. "+finalPayment.toString()
	    					printAppURL = ("https://wbocmms.nic.in/indApplicationDetails/viewFormPdfSingleWindow/"+applicationId).toString()
	    					Response res= new Response();
	    					if(indApplicationDetailsInstance.indUser.portalName=='COALINDIA'){
	    						res.sendCoalIndiaDetail(applicationId, indName, indAddress, indDistrict, serviceId, cafNo, statusCode, printAppURL, downCertURL, remarks, pendingWith);
	    					}else if(indApplicationDetailsInstance.indUser.portalName=='SILPASATHI'){
	    						res.sendSingleWindowDetail(applicationId, indName, indAddress, indDistrict, serviceId, cafNo, statusCode, printAppURL, downCertURL, remarks, pendingWith);
	    					}
	    				//	res.sendSingleWindowDetail(applicationId, indName, indAddress, indDistrict, serviceId, cafNo, statusCode, printAppURL, downCertURL, remarks, pendingWith);
	    					render(view:'confirmPayment',model:[formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
		 		    	}else{
		 		    		render(view:'confirmPayment',model:[formView:formView,indApplicationDetailsInstance:indApplicationDetailsInstance])
		 		    	}*/
				    	
				    }
			    	
			    	
			    	
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
	 
	/*
	  * @Created by :VINEET KUMAR
	  * @Created Date :11-09-18
	  * Purpose : Bank Payment through New Gateway 
	  */

	 def bankNameHDFC = {
					
			println("----PARAMS in bankNameHDFC----"+params);
			try{
				def indApplicationDetailsInstance = IndApplicationDetails.get(params.id)
	    		def bankTransaction = new BankTransactionDetails()
	    		def bank
	    		def fees = session.getAttribute("fee");
				println("fees---"+fees)
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
					
				    
				    def group1 = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
			        println("group1---------"+group1)
			        def group = group1.group.groupName
			        def feesOnline = FeeBankOtherDetails.findAll("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
					println("feesOnline.......>>>>>"+feesOnline.feeFor)
					
					if(feesOnline.feeFor.contains('CTE'))
						{
							def feesOnline1 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTE' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...1....>>>>>"+feesOnline1.amount)
							nocFee = feesOnline1.amount
						}
	    			if(feesOnline.feeFor.contains('CTO'))
						{
							def feesOnline5 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...5....>>>>>"+feesOnline5.amount)
							airCons = feesOnline5.amount
						}
	    			if(feesOnline.feeFor.contains('CTO Water'))
	    			   {
							def feesOnline6 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Water' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...6....>>>>>"+feesOnline6.amount)
							waterCons = feesOnline6.amount
					   }
	    			if(feesOnline.feeFor.contains('CTO Both'))
						{
							def feesOnline7 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
							println("feesOnline...6....>>>>>"+feesOnline7.amount)
							ctobothFee = feesOnline7.amount
						}
	    			if(feesOnline.feeFor.contains('Application Form'))
				    	{
							def feesOnline2 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
				    	  	println("feesOnline...2....>>>>>"+feesOnline2.amount)
				    	  	formFee = feesOnline2.amount
				    	}
	    			if(feesOnline.feeFor.contains('Balance Fee'))
				    	 {
							 def feesOnline3 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
				    	  	 println("feesOnline...3....>>>>>"+feesOnline3.amount)
				    	  	 misc = feesOnline3.amount
				    	 }
	    			if(feesOnline.feeFor.contains('Other'))
				    	 {
							  def feesOnline4 = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.feeFor!='Application Form' and fee.feeFor!='CTE' and fee.feeFor!='CTO Air' and fee.feeFor!='CTO Water' and fee.feeFor!='Balance Fee' and fee.feeFor!='CTO Both' and fee.application=?",[indApplicationDetailsInstance])
				    	  	  println("feesOnline...4....>>>>>"+feesOnline4.amount)
				    	 }
	    			
			        def accNo = "appid"+indApplicationDetailsInstance+"_"+"dist"+indApplicationDetailsInstance.indUser.district.districtName+"_"+"appFor"+indApplicationDetailsInstance.applicationFor+"_"+"appType"+indApplicationDetailsInstance.applicationType+
		            	"_"+"certFor"+indApplicationDetailsInstance.certificateFor+"_"+"nocFee"+nocFee+"_"+"airCons"+airCons+"_"+"waterCons"+waterCons+"_"+"formFee"+formFee+"misc"+"_"+misc+"group"+"_"+group+"indName"+"_"+indApplicationDetailsInstance.indUser.indName
		            def indName = indApplicationDetailsInstance.id
		          	def indAddress = indApplicationDetailsInstance.indUser.indAddress
		            def indEmail = indApplicationDetailsInstance.indUser.indEmail
		            println("indName----"+indName)
		            println("indEmail----"+indEmail)
		          	println("accNo----"+accNo)
		            String industryName = indName
		            String merchantCode = indAddress
	            	String accountNu = accNo
	            	String fee = session.getAttribute("fee")
	            	String bankCode ="NA"
	            	String industryEmail = indEmail
	            	println("feefeefeefeefeefee.......----"+fee.getClass().getName())
	            	println("industryName----"+industryName)
	                println("industryEmail----"+industryEmail)
	            	def industryName1 = indApplicationDetailsInstance.indUser.indName
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
	               def url = "https://jkocmms.nic.in/indApplicationDetails/responsePageHDFC"
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

		 /*
		  * @Created by :VINEET KUMAR
		  * @Created Date :11-09-18
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
	    		 def transInstance = BankTransactionDetails.get(transId)
	    		 def appId = transInstance.indApplication
	    	    println("1 appId: " + appId)
	    	    def indApplicationDetailsInstance = IndApplicationDetails.get(appId.id)
	    	    println("2 responsePage1=>indApplicationDetailsInstance: " + indApplicationDetailsInstance)
	    	    def indName1 = indApplicationDetailsInstance.indUser.indName
	          	String industryName = indApplicationDetailsInstance.id
	          	def indEmail = indApplicationDetailsInstance.indUser.indEmail
	          	String industryEmail = indEmail
	          	def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[indApplicationDetailsInstance])
	    		println("8 transId: " + transId)
	    		println("9 billDeskId: " + billDeskId)
	    		println("10 msgChecksum: " + msgChecksum)
	    		def inst = indApplicationDetailsInstance.applicationType
	    		def inst1 = indApplicationDetailsInstance.applicationFor
	    		def inst2 = indApplicationDetailsInstance.certificateFor
	    		def val = indApplicationDetailsInstance.indUser
	    		def occName = val.occName
	    		def fee = transInstance.amount
	    		def returnStatus = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by id desc",[indApplicationDetailsInstance])
	    		if(returnStatus)
	    	{
	    		if(returnStatus.returned==true && returnStatus.resubmitStatus!=true){
	    			testVal1="true"
	    		}else{
	    			testVal1=""
	    		}
	    		
	    		}else{
	    			testVal1=""
	    		}
	    		
	    		if(session.appId){
	    			
	    		}else{
	    			  session.fee = transInstance.amount
	    			  session.indregName = indApplicationDetailsInstance.indUser
	    			  session.appId = indApplicationDetailsInstance.id
	    			  session.login = "xyz"
	    			  def insuser=IndUser.findByIndustryRegMaster(indApplicationDetailsInstance.indUser)
	    			  session.indUser = insuser
	    			  session.random = transInstance.id
	    			  session.testVal1=testVal1
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
	               	def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
	               	def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
	                def a
	               	println("37 testVal1==\"true\": " + testVal1=="true")
	       			if(testVal1=="true"){
	       				a = new GetData((indApplicationDetailsInstance.id).toLong())
	       				println("38 a: " + a)
	       		    	 a.routeAppForAppReturn() 					
	       		    	//updateAllSummaryReport((indApplicationDetailsInstance.id).toString());// all summary
	       		     }else{
	       			    a = new GetData((indApplicationDetailsInstance.id).toLong())
	       			    println("39 a: " + a)
	       		    	 a.routeApp() 								 
	       		    	//updateAllSummaryReport((indApplicationDetailsInstance.id).toString());// all summary
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
	    
	    
		 def checkTransaction=
			{
	    		
				println("PARAMS IN checkTransaction====="+params)
	    		def msg=params.msg;
	    		[msg:msg]
	    		
		 }
	    
		 def checkTestTrans=
			{
	    		
				println("PARAMS IN checkTransaction====="+params)
	    		def msg=params.msg;
	    		[msg:msg]
	    		
			}
	    
	    
/////////////////--------Kumar AutoRenewal----start-----///////////////////	    
    
    def proceedAutoRenew={
	    		try {
	    			 println("proceedAutoRenew 11>>  "+params)
	    			
	            	
	            	def indUserIns = (IndUser)(session.indUser)
	            	if(session.indUser==null)
	                	{
	                    	flash.message="Your session has been expired ! Please login again."
	                		redirect(uri:'/index.gsp')
	                		return
	                	}
	            	
	        	def abc = IndUser.get(indUserIns.id)
	            def industryRegMasterInstance = abc.industryRegMaster
	            
	            def allreadyPendAutoRenwal=IndApplicationDetails.find("from IndApplicationDetails where indUser.id=? and certificateFor='autoReNew' and applicationType='CTO' order by id desc",[indUserIns.industryRegMaster.id])
	    	    //	pend = ApplicationPendingDetails.findByApplicationAndApplicationStatus(allreadyPendAutoRenwal,"pending")
	    	    	
	    	    	if(allreadyPendAutoRenwal && allreadyPendAutoRenwal.completionStatus=="pending"){
	    	    		flash.message=" Auto Renewal Aplication Allready InProgress..!!"
	    	    		redirect(controller:'indUser',action:'openIndustryHome')
	    	        	return;
	    	    	}
	        		
	        	if(params.radiobutton == "online"){
	        	 
	        	 println("indUserIns.industryRegMaster.id >> "+industryRegMasterInstance.id)
	       		 def allApprovedApp = new ArrayList()
	       		 def sublist = []
	             def pend
	             println("RegMaster ID---  "+indUserIns.industryRegMaster.id)
	        	 println("params.consentFor===  "+params.consentFor)
	    		 sublist =  IndApplicationDetails.findAll("from IndApplicationDetails where indUser.id=?  and completionStatus='completed'  and applicationType=?  order by id desc",[indUserIns.industryRegMaster.id,params.consentFor])
	       		 println("indApplication 11>>  "+sublist)
	       		 for(int i=0;i<sublist.size;i++){
	    					pend = ApplicationPendingDetails.findByApplicationAndApplicationStatus(sublist[i],"approved")
	    					println("pend 11Q1111111111>>  "+pend)
	    					if(pend)
	    					{
	    				
	    						allApprovedApp.add(pend.application)
	    					}
	    				}
	       	
	       		
	       		 if(allApprovedApp.size() != 0){
	       			
	       			  render(view:'autoRenewPage',model:[industryRegMasterInstance:industryRegMasterInstance,indAppInstance:allApprovedApp,autoRenewDisplay:'autoRenewFirstPage',lastConsentGranted:params.radiobutton,consentFor:params.consentFor,consentType:params.consentType])
	       			       return
	       		 }else{
	       		
	       			 if((session.cafUniqueNo==null || session.cafUniqueNo==""))
	       			 {
	       				flash.message="No Application found for this combination for Auto Renew.."	
	       				redirect(action:applyConsent)
	         	   		return
	       			 }else
	       			 {
	       				flash.message="No Application found for this combination for Auto Renew.."	
	       	   		    redirect(action:consentApply)
	       	   	        return
	       			 }
	       		 }
	       	 }else{
	       		 
	       		
	        		def indApplicationDetailsInstance=new IndApplicationDetails();    	
	        		
	        		def capInv = industryRegMasterInstance.indCapInvt
	            	
	        		indApplicationDetailsInstance.indUser = industryRegMasterInstance    		
	        		indApplicationDetailsInstance.applicationType = params.consentType   		
	                indApplicationDetailsInstance.applicationFor = params.consentFor  		    		
	                indApplicationDetailsInstance.certificateFor = "autoReNew"
	              //  indApplicationDetailsInstance.previousAppNo = "0000"
	                indApplicationDetailsInstance.applicationDate = new Date()
	        	    indApplicationDetailsInstance.actualApplicationDate = new Date()   		
	        		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
	                indApplicationDetailsInstance.completionStatus = "pending"
	                indApplicationDetailsInstance.clarification = false;
	            	indApplicationDetailsInstance.inspection = false;
	            	indApplicationDetailsInstance.annualProdCap = "0"
	            	indApplicationDetailsInstance.noOfStack = "0"
	            //		indApplicationDetailsInstance.recieptDate = new Date()   		
	        	//	indApplicationDetailsInstance.authorFor = ""
	            //    indApplicationDetailsInstance.recieptNo = ""
	                indApplicationDetailsInstance.hazardeousType = "";
	            	indApplicationDetailsInstance.applicationType = "CTO"    	
	            //		 indApplicationDetailsInstance.previousAppNo = "0000"
	            //	indApplicationDetailsInstance.bookNo = "";
	            	//indApplicationDetailsInstance.noOfStack = "0"
	            	//	indApplicationDetailsInstance.totalFee = 0.0
	            	//		indApplicationDetailsInstance.annualFeelease = "0"
	            	//			indApplicationDetailsInstance.applicableFee = 0.0
	                if(indApplicationDetailsInstance.save()){
	                	
	                }else{
	                	if(indApplicationDetailsInstance.hasErrors()){
	                		indApplicationDetailsInstance.errors.allErrors.each {
	                         println it
	                  	   }
	                     }
	                }
	       		  
	       		 //////////////////////1st pdf /////////////
	             
	       	    def fileUpload = new ApplicationDocuments()         
	       		 
	         	def multi = request.getFile('consentOrder')
	         	
	         	
	         	if(!multi.empty){            		
	         	
	         	fileUpload.size = multi.getSize() / 1024
	         	fileUpload.level="consentOrderManually"
	             
	             fileUpload.data=multi.getBytes() 
	             fileUpload.extension = extractExtension( multi )
	            
	             fileUpload.name =multi.getOriginalFilename()
	           	fileUpload.indApplication=indApplicationDetailsInstance              	
	         	Byte[] bytes=multi.getBytes()             	
	          	  if(!fileCheck(bytes))
	    			  { 
	    				  flash.message="You are trying to upload restricted file"
	    				  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    				  return					  
	    			  }             	
	             if(fileUpload.save(flush:true)) {                	
	     	      
	     	      
	     	       }
	             
	             else {
	             	if(fileUpload.hasErrors()){
	             		fileUpload.errors.allErrors.each {
	                      println it
	               	   }
	                  }
	             }              
	            
	         	}
	          
	    	       	 //////////////end///////////////
	    	       	 /////////////2nd pdf//////////////

	         	 def fileUpload1 = new ApplicationDocuments()
	    	    
	         	def multi1 = request.getFile('consentApplication')
	         	
	         	
	         	if(!multi1.empty){
	         		
	         	fileUpload1.size = multi1.getSize() / 1024
	         	fileUpload1.level="consentApplicationManually"
	             
	             fileUpload1.data=multi1.getBytes() 
	             fileUpload1.extension = extractExtension( multi1 )
	            
	             fileUpload1.name =multi1.getOriginalFilename()
	          	fileUpload1.indApplication=indApplicationDetailsInstance 
	          	
	         	Byte[] bytes1=multi1.getBytes()             	
	          	  if(!fileCheck(bytes1))
	    			  { 
	    				  flash.message="You are trying to upload restricted file"
	    					  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj])
	    				  return					  
	    			  }             	
	             if(fileUpload1.save(flush:true)) {                	
	     	    
	     	      
	     	       }
	             
	             else {
	             	if(fileUpload1.hasErrors()){
	             		fileUpload1.errors.allErrors.each {
	                      println it
	               	   }
	                  }
	             }
	           
	             
	         	}  
	         
	    	       	 
	       	     redirect(action:saveAutoRenewConsent,params:[lastConsentGranted:params.radiobutton,consentFor:params.consentFor,indAppId:indApplicationDetailsInstance.id,consentType:params.consentType])
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
    
    
    
def saveAutoRenewDetails = {
	    		try {
	    			 def indUserIns = (IndUser)(session.indUser)
	    			println("saveAutoRenewDetails---params---33333333333333"+params)
	    			
	    	  	             println("sd "+params.strtDate)
     			    	     println("endDate "+params.endDate)
	    	        def lastConsentGranted        
	    			AutoRenewDetails auotoRenewObj
	    			
	    			   println("AutoRenewDetails oj on controller==== "+auotoRenewObj)
	    			File certFile
	    			AutoRenewPdf  autoRenewPdf;
	    			
	    			AutoRenewalFormPdf autoRenewPdf1=new AutoRenewalFormPdf();   // DD
	    			def consentFeeMasterObj
	    			def applicationPendingObj
	    			def groupNameObj="SE I"
	    			def indApplicationDetailsInstanceOld
	    					
	    	    	def industryRegMasterInstance = IndustryRegMaster.get((params.regMasId).toLong())
	    	    	def sessValue=(session.indUser).toString()
	    	    	def capInvestment=(industryRegMasterInstance.indCapInvt).toString();
	    	    	def oldApplication=params.oldIndApplicationId
	    	    	def oldApplicationDate=params.applicationDate
	    	    	def capInv = industryRegMasterInstance.indCapInvt
	    	    	def industryRegMaster1 = SurroundingMaster.list()
	    	    	def indApplicationDetailsInstance  = null
	    	    	
	    	    	
	    	    	if(params.indAppDetId != null && !(params.indAppDetId).equals("")){
	    	    	indApplicationDetailsInstance =	IndApplicationDetails.get((params.indAppDetId).toLong())
	    	    	
	    	    		
	    	    	   }   
	    	    	
	    			 
	    			 if(params.lastConsentGranted=="online")
	    			 {
	    				
	    			  indApplicationDetailsInstanceOld =	IndApplicationDetails.get((params.oldIndApplicationId).toLong())
	    			  applicationPendingObj=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=?",[indApplicationDetailsInstanceOld])
	    			  groupNameObj=applicationPendingObj.role.group.groupName
	    	    	   	
	    			
	    			 }else{
	    				
	    				 indApplicationDetailsInstanceOld =	indApplicationDetailsInstance
	    			 }
	    			 println("indApplicationDetailsInstance "+indApplicationDetailsInstance)
	    			   def  auotoRenewOldObj=AutoRenewDetails.find("from AutoRenewDetails abc where abc.application=?",[indApplicationDetailsInstance])
	    			    println("auotoRenewOldObj "+auotoRenewOldObj)
	    			  
	    			    if(auotoRenewOldObj)
	    			    {		    	   
	    			    	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    					   // Date validUpto = sdf.parse(params.validUpto_value);
	    					   // Date consentDate = sdf.parse(params.consentDate_value);			
	    					
	    					   
	    					    lastConsentGranted=auotoRenewOldObj.lastConsentGranted
	    					    if(params.feeApplicableBothAct1){
	    					    	auotoRenewOldObj.feeApplicable=params.feeApplicableBothAct1
	    					    }else{
	    					    	auotoRenewOldObj.feeApplicable=""
	    					    }
	    					 //   auotoRenewOldObj.oldApplicationDate=params.applicationDate
	    					    auotoRenewOldObj.noOfYear=params.yearsApplied
	    					    //auotoRenewOldObj.validUpto=validUpto
	    					  //  auotoRenewOldObj.consentOrderNo=params.consentOrderNo
	    					  //  auotoRenewOldObj.consentDate=consentDate
	    					   //   Date date = new Date();  
	    					   
	    					 	
	    					    					 
	    					    def startDateNew = params.strtDate
	    					     def endDateNew = params.endDate
	    					     println("sd 11 ---  "+startDateNew)
	    					     println("ed 11 ---  "+endDateNew)
	    					     java.util.Date stdm = new java.util.Date(startDateNew);
	    					     java.util.Date stdme = new java.util.Date(endDateNew);
	    					     println("stdm ---  "+stdm)
	    					     println("edm ---  "+stdme)
	    					     
	    					     def stdm1 = stdm
	    					     def stdme1 = stdme
	    					     java.sql.Timestamp sqlDate3 = new java.sql.Timestamp(stdm1.getTime());
	    					     java.sql.Timestamp sqlDate4 = new java.sql.Timestamp(stdme1.getTime());
	    					     println("sqlDate3 "+sqlDate3)
	    					      println("sqlDate4 "+sqlDate4)
	    					     def dfh11 = new SimpleDateFormat("dd/MM/yyyy");
	    					     def dfh12 = new SimpleDateFormat("dd/MM/yyyy");
	    					     def draftDate1= dfh11.format(sqlDate3)
	    					      def draftDate2= dfh12.format(sqlDate4)
	    					      println("Start Date "+draftDate1)
	    					     println("End Date "+draftDate2)
	    					     
	    					    /* println("startDateNew "+startDateNew.getClass().getName())
	    					     
	    						 SimpleDateFormat sdff = new SimpleDateFormat("dd/MM/yyyy");
	    					     
		    					    java.util.Date date = sdff.parse(startDateNew);
		    					    
		    					    java.sql.Date sqlDate = new Date(date.getTime());
		    					    
		    					    println("sqlDate "+sqlDate)*/
		    					    
		    				
	    					    auotoRenewOldObj.startDate= draftDate1
	    					    auotoRenewOldObj.endDate=draftDate2
	    				//	    auotoRenewOldObj.oldApplicationId=params.oldIndApplicationNo
	    					    auotoRenewOldObj.application=indApplicationDetailsInstance
	    					    if(params.noIncreaseProduction){
	    					    	auotoRenewOldObj.noIncreaseProduction="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.noIncreaseProduction=""
		    					    }
	    					    if(params.noSewageTradeEffluent){
	    					    	auotoRenewOldObj.noSewageTradeEffluent="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.noSewageTradeEffluent=""
		    					    }
	    					    if(params.noIncreaseStacksEmission){
	    					    	auotoRenewOldObj.noIncreaseStacksEmission="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.noIncreaseStacksEmission=""
		    					    }
	    					    if(params.noChangeManagementOwnership){
	    					    	auotoRenewOldObj.noChangeManagementOwnership="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.noChangeManagementOwnership=""
		    					    }
	    					    if(params.noIncreaseProductionOverconsented){
	    					    	auotoRenewOldObj.noIncreaseProductionOverconsented="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.noIncreaseProductionOverconsented=""
		    					    }
	    					    if(params.noCasePending){
	    					    	auotoRenewOldObj.noCasePending="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.noCasePending=""
		    					    }
	    					    if(params.devicesInstalled){
	    					    	auotoRenewOldObj.devicesInstalled="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.devicesInstalled=""
		    					    }
	    					    if(params.consentConditions){
	    					    	auotoRenewOldObj.consentConditions="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.consentConditions=""
		    					    }
	    					    if(params.failure){
	    					    	auotoRenewOldObj.failure="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.failure=""
		    					    }
	    					    if(params.abide){
	    					    	auotoRenewOldObj.abide="Checked"
		    					    }else{
		    					    	auotoRenewOldObj.abide=""
		    					    }
	    						if(auotoRenewOldObj.save()){
	    							println("auotoRenewOldObj Saved "+auotoRenewOldObj)
	    						}else{
	    							println("auotoRenewOldObj Not Saved")
	    							auotoRenewOldObj.errors.each{
	    								println it
	    							}
	    						}
	    			   
	    			    }	
	    			    
	    			   def fees = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
	    				if(params.appStatus=="completed"){
	    					   if(params.feeApplicableBothAct1=="0")
	    	   	    	    	{
	    	   	    	    		flash.message="Please Calculate Fee"
	    	   	    	    		 render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewObj:auotoRenewOldObj,indAppInstance:indApplicationDetailsInstanceOld,consentType:params.consentType])
	    	       					return;
	    	   	    	    		
	    	   	    	    	}
	    				
	    			/*	if(fees==null)
	    		         {    	
	    		        
	    		   
	    		         flash.message="Please Enter Bank Fee Details"
	    		    
	    		         render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,indAppInstance:indApplicationDetailsInstanceOld,consentType:params.consentType])
	    		         
	    		         return;
	    		         }*/
	    			   
	    			   def consentFeeMasterObj1=ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
	    			   
	    			   
	    			   
	    			   if(consentFeeMasterObj1){
	    				  consentFeeMasterObj=ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)		  
	    			   }
	    			   else
	    			       {
	    				   consentFeeMasterObj=new ConsentFeeMaster(); 
	    				   }
	    			   
	    			   
	    			    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    			  //  Date startDate = sdf1.parse(params.strtDate);
	    			//    Date endtDate = sdf1.parse(params.endDate);		
	    			   
	    			   consentFeeMasterObj.application=indApplicationDetailsInstance
	    			   consentFeeMasterObj.noOfYears=(params.yearsApplied).toDouble()
	    			   if(params.yearsApplied1 != ""){
	       	    	    def abc=params.yearsApplied1;
	       	    		if(abc)
	       	    	    {
	       	    			abc=abc.toLong();
	       	    	    }else
	       	    	    {
	       	    	    	abc=0.0;
	       	    	    }
	       	    		consentFeeMasterObj.noOfYearsadditionalYears = abc;
	       	    	}else{
	       	    		consentFeeMasterObj.noOfYearsadditionalYears = 0
	       	    	}
	    			   if(params.totalFee==null || params.totalFee==""){
	    				   consentFeeMasterObj.totalApplicableFee = (params.feeApplicableBothAct1).toLong()
	    			   }else{
	    				   consentFeeMasterObj.totalApplicableFee = (params.totalFee).toLong()
	    			   }
	    			   
	    			//   consentFeeMasterObj.totalApplicableFee = (params.totalFee).toLong()
	    			   consentFeeMasterObj.calculatedFee = (params.feeApplicableBothAct1).toLong()
	    			   //consentFeeMasterObj.feeApplicableWaterAct=0.0
	    			   //consentFeeMasterObj.feeCurrentDemandPeriod=""
	    			   //consentFeeMasterObj.remarksRaisingDemand=""
	    			   consentFeeMasterObj.outstandingDueInd=0.0 //kumar
	    			   consentFeeMasterObj.outstandingDueBrd=0.0 //kumar
	    			   
	    			   if(params.addRestFee==null || params.addRestFee==""){
	    				   consentFeeMasterObj.addFees = 0.0
	    			   }else{
	    				   consentFeeMasterObj.addFees = (params.addRestFee).toLong()
	    			   }
	    			 //  consentFeeMasterObj.addFees=(params.addRestFee).toDouble()
	    			 /*  consentFeeMasterObj.outstandingDueInd=0.0
	    			   consentFeeMasterObj.outstandingDueBrd=0.0 
	    			  */ 
	    				   
	    				   if(consentFeeMasterObj.save()){
	    					  
	    				   }else{
	    					   consentFeeMasterObj.errors.each{
	    						   println it;
	    					   }
	    				   }
	    			   
	    			   
	    			   
	    			   
	    			
	    			
	    			def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
	    	    	def totalfee = 0.0
	    	    	
	    	    	for(int i=0;i<feeDetailsList.size();i++)
	    	    	{
	    	    		totalfee = totalfee + feeDetailsList.get(i).amount
	    	    	}
	    	    	
	    			
	    			autoRenewPdf=new AutoRenewPdf();
	    	    	
	    	    	
	    	    	def fileAutoReNew=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication=? and abc.name='AutoReNew.pdf'",[indApplicationDetailsInstance])
	    		       	if(fileAutoReNew){
	    		       		
	    		       	fileAutoReNew.delete();
	    		       	}
	    			
	    		    	def roGroupName = groupNameObj
	    				def consentOrderNo = params.consentOrderNo
	    				def oldIndApplicationNo = params.oldIndApplicationNo
	    				def consentValidDate = params.consentDate_value
	    				def validDate = params.validUpto_value
	    				def upTODate = params.endDate
	    				def amount = params.feeApplicableBothAct1
	    				def amountWords = ""
	    				def industryProfile = industryRegMasterInstance.indName
	    				def occupierName = industryRegMasterInstance.occName
	    				def indAddress = industryRegMasterInstance.indAddress
	    				def designation = industryRegMasterInstance.occDesignation
	    				def phoneNo = industryRegMasterInstance.occPhoneCode + "-"+ industryRegMasterInstance.occPhoneNo
	    				def emailId = industryRegMasterInstance.occEmail
	    				def appType = indApplicationDetailsInstance.applicationType
	    				def noIncreaseProduction
	    				def noSewageTradeEffluent
	    				def noIncreaseStacksEmission
	    				 def noChangeManagementOwnership
	    				 def noIncreaseProductionOverconsented
	    				 def noCasePending
	    				 def devicesInstalled
	    				def consentConditions
	    				def failure
	    				def abide
	    				def indCapInvt1 = (industryRegMasterInstance.indCapInvt).toString()
	    				def indCapInvt =indCapInvt1 + 0
	    				def noOfYear = params.yearsApplied
	    				// Added by Deepak for Autorenew
	    				println("params.noIncreaseProduction "+params.noIncreaseProduction)
	    				if(params.noIncreaseProduction){
	    					noIncreaseProduction ="Checked"
	    				}else{
	    				 noIncreaseProduction =""
	    				}
	    		    	println("noIncreaseProduction "+noIncreaseProduction)
	    		    	  if(params.noSewageTradeEffluent){
	    		    		  noSewageTradeEffluent="Checked"
	    					    }else{
	    					    	noSewageTradeEffluent=""
	    					    }
  					    if(params.noIncreaseStacksEmission){
	    					    noIncreaseStacksEmission="Checked"
	    					    }else{
	    					    	   noIncreaseStacksEmission=""
	    					    }
  					    if(params.noChangeManagementOwnership){
	    					      noChangeManagementOwnership="Checked"
	    					    }else{
	    					    	  noChangeManagementOwnership=""
	    					    }
  					    if(params.noIncreaseProductionOverconsented){
  					    	  noIncreaseProductionOverconsented="Checked"
	    					    }else{
	    					    	  noIncreaseProductionOverconsented=""
	    					    }
  					    if(params.noCasePending){
  					    	   noCasePending="Checked"
	    					    }else{
	    					    	  noCasePending=""
	    					    }
  					    if(params.devicesInstalled){
  					    	  devicesInstalled="Checked"
	    					    }else{
	    					    	  devicesInstalled=""
	    					    }
  					    if(params.consentConditions){
  					    	  consentConditions="Checked"
	    					    }else{
	    					    	  consentConditions=""
	    					    }
  					    if(params.failure){
  					    	  failure="Checked"
	    					    }else{
	    					    	failure=""
	    					    }
  					    if(params.abide){
  					    	  abide="Checked"
	    					    }else{
	    					    	  abide=""
	    					    }
	    				
	    				def dist = industryRegMasterInstance.district.districtName
	    				def pin = industryRegMasterInstance.indPin
//	    				certFile= autoRenewPdf.autoRenewpdf_Function(roGroupName,consentOrderNo,consentValidDate,validDate,upTODate,industryProfile,capInvestment,oldApplication,oldApplicationDate,occupierName,designation,phoneNo,emailId,appType);
	    		    	certFile= autoRenewPdf.autoRenewpdf_Function(roGroupName,consentOrderNo,consentValidDate,validDate,upTODate,industryProfile,capInvestment,oldApplication,oldApplicationDate,occupierName,designation,phoneNo,emailId,indAddress,dist,pin,oldIndApplicationNo,noIncreaseProduction,noSewageTradeEffluent,noIncreaseStacksEmission,noChangeManagementOwnership,noIncreaseProductionOverconsented,noCasePending,devicesInstalled,consentConditions,failure,abide,noOfYear,indCapInvt);
	    				
	    		    	//certFile=autoRenewPdf.autoRenewpdf_Function(roGroupName,consentOrderNo,consentValidDate,validDate,upTODate,amount,amountWords,industryProfile,capInvestment,oldApplication,oldApplicationDate,occupierName,designation,phoneNo,emailId);
	    		    
	    				ApplicationFileRecord file=new ApplicationFileRecord()
	    		    	
	    		    	 byte[] b = new byte[(int) certFile.length()];
	    		        
	    		        FileInputStream fileInputStream = new FileInputStream(certFile);
	    		        fileInputStream.read(b);
	    		 	        
	    		 	         def fileLength=certFile.length()
	    		        	 file.size = fileLength / 1024  //f.getSize() 
	    		 	         file.extension ="pdf"//extractExtension( f )
	    		 	       	 file.data=b;
	    		 	       	 file.name="AutoReNew.pdf"
	    		 	    	 file.description="AutoReNew Certificate"
	    		 	    	 file.createdBy="sessionValue"
	    		 	    	 file.updatedBy="sessionValue"
	    		 	    	 file.typeOfFile="AutoReNewForm"
	    		 	    	 file.indApplication=indApplicationDetailsInstance
	    		 	    	
	    		 	       if(file.save(flush:true)) {
	    		 	    	  
	    		 	    	   if(certFile){
	    		 	    		  	  
	    		 	    	   }
	    		 	    	   } else {
	    		 	    		  file.errors.each{
	    		 	    			  println it;
	    		 	    		  }   	         
	    		 	       }  	
	    		 	       	 
	    		 	       
	    		 	       	 
	    	            	 /////////////3nd pdf//////////////             Added by Deepak Kumar
	    	            	 def fileUpload2 = new ApplicationDocuments()
	    		 	       	 
	    	            	def latestConsent=ApplicationDocuments.find("from ApplicationDocuments abc where abc.indApplication=? and abc.level='latestConsent'",[indApplicationDetailsInstance])
	    	 	 	       	if(latestConsent){
	    	 	 	       	
	    	 	 	       	latestConsent.delete();
	    	 	 	       	}
	    		 	       	 
	    	            	def multi2 = request.getFile('latestConsent')
	    	            	
	    	            	
	    	            	if(!multi2.empty){
	    	            		
	    	            		fileUpload2.size = multi2.getSize() / 1024
	    	            		fileUpload2.level="Copy of last / latest consent issued by the Board / PCC"
	    	                
	    	            			fileUpload2.data=multi2.getBytes() 
	    	                fileUpload2.extension = extractExtension( multi2 )
	    	               
	    		            fileUpload2.name =multi2.getOriginalFilename()
	    	             	fileUpload2.indApplication=indApplicationDetailsInstance 
	    	             	
	    	            	Byte[] bytes1=multi2.getBytes()             	
	    	             	  if(!fileCheck(bytes1))
	    					  { 
	    						  flash.message="You are trying to upload restricted file"
	    							  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    						  return					  
	    					  }             	
	    	                if(fileUpload2.save(flush:true)) {                	
	    	        	      
	    	        	     
	    	        	       }
	    	                
	    	                else {
	    	                	if(fileUpload2.hasErrors()){
	    	                		fileUpload2.errors.allErrors.each {
	    	                         println it
	    	                  	   }
	    	                     }
	    	                }
	    	              
	    	                
	    	            	} 
	    	             
	    		 	       	 /////////////////////end///////////////
	    		 	       	 
	    	            	 /////////////4nd pdf//////////////             Added by Deepak Kumar
	    	            	 def fileUpload3 = new ApplicationDocuments()
	    		 	       	 
	    	            	def unitFall=ApplicationDocuments.find("from ApplicationDocuments abc where abc.indApplication=? and abc.level='unitFall'",[indApplicationDetailsInstance])
	    	 	 	       	if(unitFall){
	    	 	 	       	
	    	 	 	       	unitFall.delete();
	    	 	 	       	}
	    		 	       	 
	    	            	def multi3 = request.getFile('unitFall')
	    	            	
	    	            	
	    	            	if(!multi3.empty){
	    	            		
	    	            		fileUpload3.size = multi3.getSize() / 1024
	    	            		fileUpload3.level="The unit falls under the provisions of PWM Rules, 2016 (PIPB)"
	    	                
	    	            			fileUpload3.data=multi3.getBytes() 
	    	                fileUpload3.extension = extractExtension( multi3 )
	    	               
	    		            fileUpload3.name =multi3.getOriginalFilename()
	    	             	fileUpload3.indApplication=indApplicationDetailsInstance 
	    	             	
	    	            	Byte[] bytes1=multi3.getBytes()             	
	    	             	  if(!fileCheck(bytes1))
	    					  { 
	    						  flash.message="You are trying to upload restricted file"
	    							  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    						  return					  
	    					  }             	
	    	                if(fileUpload3.save(flush:true)) {                	
	    	        	      
	    	                	 
	    	        	       }
	    	                
	    	                else {
	    	                	if(fileUpload3.hasErrors()){
	    	                		fileUpload3.errors.allErrors.each {
	    	                         println it
	    	                  	   }
	    	                     }
	    	                }
	    	              
	    	                
	    	            	}  
	    	             
	    		 	       	 /////////////////////end///////////////
	    		 	       	 
	    	           
	    		 	       	 
	    		 	       	 
	    	            	 /////////////6nd pdf//////////////             Added by Deepak Kumar
	    	            	 def fileUpload5 = new ApplicationDocuments()
	    		 	       	 
	    	            	def photographs=ApplicationDocuments.find("from ApplicationDocuments abc where abc.indApplication=? and abc.level='photographs'",[indApplicationDetailsInstance])
	    	 	 	       	if(photographs){
	    	 	 	       	
	    	 	 	       	photographs.delete();
	    	 	 	       	}
	    		 	       	 
	    	            	def multi5 = request.getFile('photographs')
	    	            	
	    	            	
	    	            	if(!multi5.empty){
	    	            		
	    	            		fileUpload5.size = multi5.getSize() / 1024
	    	            		fileUpload5.level="Latest photographs of the unit, P&M and PCDs with date and name of the Industry on it"
	    	                
	    	            			fileUpload5.data=multi5.getBytes() 
	    	                fileUpload5.extension = extractExtension( multi5 )
	    	               
	    		            fileUpload5.name =multi5.getOriginalFilename()
	    	             	fileUpload5.indApplication=indApplicationDetailsInstance 
	    	             	
	    	            	Byte[] bytes1=multi5.getBytes()             	
	    	             	  if(!fileCheck(bytes1))
	    					  { 
	    						  flash.message="You are trying to upload restricted file"
	    							  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    						  return					  
	    					  }             	
	    	                if(fileUpload5.save(flush:true)) {                	
	    	        	      
	    	                	 
	    	        	       }
	    	                
	    	                else {
	    	                	if(fileUpload5.hasErrors()){
	    	                		fileUpload5.errors.allErrors.each {
	    	                         println it
	    	                  	   }
	    	                     }
	    	                }
	    	              
	    	                
	    	            	}  
	    	             
	    		 	       	 /////////////////////end///////////////
	    	            	
	    		 	       	 
	    	            	
	    	             
	    	            	
	    	            	 
	     		 	       	 def appId
	     		 	         def appNewId
	     	            	 if(oldApplication)
	     	            		// println("oldApplication"+oldApplication)
	     	            	 {
	     		 	       	 //appId=oldApplication.toLong()
	     	            	 }
	     		 	       	 if(auotoRenewOldObj)
	     		 	       	 {
	     		 	       	println("auotoRenewOldObj.application.id"+auotoRenewOldObj.application.id)
	     		 	       	 appNewId=(auotoRenewOldObj.application.id).toLong()
	     		 	       	 println("oldApplication"+appNewId)
	     		 	       	/* if(auotoRenewOldObj.oldApplicationId)
	     		 	       	 println("auotoRenewOldObj.oldApplicationId"+auotoRenewOldObj.oldApplicationId)
	     		 	         	appId=(auotoRenewOldObj.oldApplicationId).toLong() */
	     		 	       	 }
	     		 	       	 
	     		 	       	 
	     		 	       	/* if(indApplicationDetailsInstance.applicationFor=="both"){
	     		 	       	 autoRenewPdf.formAirPdf(appId,sessValue,appNewId)
	     		 	       	 autoRenewPdf.formWaterPdf(appId,sessValue,appNewId)
	     		 	       	 } 
	     		 	       	 else if(indApplicationDetailsInstance.applicationFor=="air"){
	         		 	       	 autoRenewPdf.formAirPdf(appId,sessValue,appNewId)
	         		 	       	 //autoRenewPdf.formWaterPdf(appId,sessValue,appNewId)
	         		 	       	 }
	     		 	        else if(indApplicationDetailsInstance.applicationFor=="water"){
	       		 	       	 //autoRenewPdf.formAirPdf(appId,sessValue,appNewId)
	       		 	       	 autoRenewPdf.formWaterPdf(appId,sessValue,appNewId)
	       		 	       	 } */
	       		 	       	 println("TESTINT AUTORENEEW")
	       		 	       	  println("sessValue===="+sessValue)
	       		 	       	   println("appNewId===="+appNewId)
	     		 	       autoRenewPdf1.pdfAutoRenew(sessValue,appNewId) 
	     		 	       	  println("TESTINT AUTORENEEW  111")	
	     		 	       	 /////////////////////end///////////////   PdfGenerationgreen pdfG=new PdfGenerationgreen()
	    		 	       	 /////////////////////end///////////////
	    		    	
	    		 	        render(view:'Payment',model:[feesPaid:consentFeeMasterObj.totalApplicableFee,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,formView:'autoReNew'])
	    		 	        return
	    			              	}else{
	    			              		
	    			              		 /////////////3nd pdf//////////////             Added by Deepak Kumar
	    		    	            	 def fileUpload2 = new ApplicationDocuments()
	    		    		 	       	 
	    		    	            	def latestConsent=ApplicationDocuments.find("from ApplicationDocuments abc where abc.indApplication=? and abc.level='latestConsent'",[indApplicationDetailsInstance])
	    		    	 	 	       	if(latestConsent){
	    		    	 	 	       	
	    		    	 	 	       	latestConsent.delete();
	    		    	 	 	       	}
	    		    		 	       	 
	    		    	            	def multi2 = request.getFile('latestConsent')
	    		    	            	
	    		    	            	
	    		    	            	if(!multi2.empty){
	    		    	            		
	    		    	            		fileUpload2.size = multi2.getSize() / 1024
	    		    	            		fileUpload2.level="Copy of last / latest consent issued by the Board / PCC"
	    		    	                
	    		    	            			fileUpload2.data=multi2.getBytes() 
	    		    	                fileUpload2.extension = extractExtension( multi2 )
	    		    	               
	    		    		            fileUpload2.name =multi2.getOriginalFilename()
	    		    	             	fileUpload2.indApplication=indApplicationDetailsInstance 
	    		    	             	
	    		    	            	Byte[] bytes1=multi2.getBytes()             	
	    		    	             	  if(!fileCheck(bytes1))
	    		    					  { 
	    		    						  flash.message="You are trying to upload restricted file"
	    		    							  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    		    						  return					  
	    		    					  }             	
	    		    	                if(fileUpload2.save(flush:true)) {                	
	    		    	        	      
	    		    	        	     
	    		    	        	       }
	    		    	                
	    		    	                else {
	    		    	                	if(fileUpload2.hasErrors()){
	    		    	                		fileUpload2.errors.allErrors.each {
	    		    	                         println it
	    		    	                  	   }
	    		    	                     }
	    		    	                }
	    		    	              
	    		    	                
	    		    	            	}  
	    		    	             
	    		    		 	       	 /////////////////////end///////////////
	    		    		 	       	 
	    		    	            	 /////////////4nd pdf//////////////             Added by Deepak Kumar
	    		    	            	 def fileUpload3 = new ApplicationDocuments()
	    		    		 	       	 
	    		    	            	def unitFall=ApplicationDocuments.find("from ApplicationDocuments abc where abc.indApplication=? and abc.level='unitFall'",[indApplicationDetailsInstance])
	    		    	 	 	       	if(unitFall){
	    		    	 	 	       	
	    		    	 	 	       	unitFall.delete();
	    		    	 	 	       	}
	    		    		 	       	 
	    		    	            	def multi3 = request.getFile('unitFall')
	    		    	            	
	    		    	            	
	    		    	            	if(!multi3.empty){
	    		    	            		
	    		    	            		fileUpload3.size = multi3.getSize() / 1024
	    		    	            		fileUpload3.level="The unit falls under the provisions of PWM Rules, 2016 (PIPB)"
	    		    	                
	    		    	            			fileUpload3.data=multi3.getBytes() 
	    		    	                fileUpload3.extension = extractExtension( multi3 )
	    		    	               
	    		    		            fileUpload3.name =multi3.getOriginalFilename()
	    		    	             	fileUpload3.indApplication=indApplicationDetailsInstance 
	    		    	             	
	    		    	            	Byte[] bytes1=multi3.getBytes()             	
	    		    	             	  if(!fileCheck(bytes1))
	    		    					  { 
	    		    						  flash.message="You are trying to upload restricted file"
	    		    							  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    		    						  return					  
	    		    					  }             	
	    		    	                if(fileUpload3.save(flush:true)) {                	
	    		    	        	      
	    		    	                	 
	    		    	        	       }
	    		    	                
	    		    	                else {
	    		    	                	if(fileUpload3.hasErrors()){
	    		    	                		fileUpload3.errors.allErrors.each {
	    		    	                         println it
	    		    	                  	   }
	    		    	                     }
	    		    	                }
	    		    	              
	    		    	                
	    		    	            	}  
	    		    	             
	    		    		 	       	 /////////////////////end///////////////
	    		    		 	       	 
	    		    	            	 
	    		    	            	 /////////////6nd pdf//////////////             Added by Deepak Kumar
	    		    	            	 def fileUpload5 = new ApplicationDocuments()
	    		    		 	       	 
	    		    	            	def photographs=ApplicationDocuments.find("from ApplicationDocuments abc where abc.indApplication=? and abc.level='photographs'",[indApplicationDetailsInstance])
	    		    	 	 	       	if(photographs){
	    		    	 	 	       	
	    		    	 	 	       	photographs.delete();
	    		    	 	 	       	}
	    		    		 	       	 
	    		    	            	def multi5 = request.getFile('photographs')
	    		    	            	
	    		    	            	
	    		    	            	if(!multi5.empty){
	    		    	            		
	    		    	            		fileUpload5.size = multi5.getSize() / 1024
	    		    	            		fileUpload5.level="Latest photographs of the unit, P&M and PCDs with date and name of the Industry on it"
	    		    	                
	    		    	            			fileUpload5.data=multi5.getBytes() 
	    		    	                fileUpload5.extension = extractExtension( multi5 )
	    		    	               
	    		    		            fileUpload5.name =multi5.getOriginalFilename()
	    		    	             	fileUpload5.indApplication=indApplicationDetailsInstance 
	    		    	             	
	    		    	            	Byte[] bytes1=multi5.getBytes()             	
	    		    	             	  if(!fileCheck(bytes1))
	    		    					  { 
	    		    						  flash.message="You are trying to upload restricted file"
	    		    							  render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,consentType:params.consentType])
	    		    						  return					  
	    		    					  }             	
	    		    	                if(fileUpload5.save(flush:true)) {                	
	    		    	        	      
	    		    	                	 println("PHOTOGRAGH SAVED")
	    		    	        	       }
	    		    	                
	    		    	                else {
	    		    	                	if(fileUpload5.hasErrors()){
	    		    	                		fileUpload5.errors.allErrors.each {
	    		    	                         println it
	    		    	                  	   }
	    		    	                     }
	    		    	                }
	    		    	              
	    		    	                
	    		    	            	}  
	    		    	             
	    		    		 	       	 /////////////////////end///////////////
	    			              		
	    			              		flash.message="Your Application No. ${indApplicationDetailsInstance.id} is saved and available for future update."
	    			              		render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,capInv:capInv,oldIndApplicationId:params.oldIndApplicationId,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewOldObj,indAppInstance:indApplicationDetailsInstanceOld,lastConsentGranted:lastConsentGranted])
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
    
def saveAutoRenewConsent_old = {
	    		try {
	    	           
	    			println("yyyyyyyyyyyy........222......"+params)
	    			def indAppInstance
	    			def indApplicationDetailsInstance
	    	    	 if(params.lastConsentGranted=="manually")
	    	    	 { 
	    	    		 println("zzzzzzzzzzzzzzzzzzzzzasasdas.......222.......")
	    	    	  indAppInstance =  IndApplicationDetails.find("from IndApplicationDetails where id=? ",[params.indAppId.toLong()])
	    	    	  println("indAppInstance.......1111......."+indAppInstance)
	    	    	 }
	    	    	 else
	    	    	 {
	    	    		 println("zzzzzzzzzzzzzzzzzzzzzasasdaszzzzzzzzzzzzzz.......2222.......")
	    	    	  indAppInstance=IndApplicationDetails.get((params.id).toLong())
	    	    	  println("indAppInstance.......2222......."+indAppInstance)
	    	    	 }
	        		 if(indAppInstance != null){
	        			 def check1=true
	        		    	def indUserIns = (IndUser)(session.indUser)
	        		    	if(session.indUser==null)
	        		        	{
	        		            	flash.message="Your session has been expired ! Please login again."
	        		        		redirect(uri:'/index.gsp')
	        		        		return
	        		        	}
	        		    	
	        		    	def abc = IndUser.get(indUserIns.id)
	        		    	
	        		    	def industryRegMasterInstance = abc.industryRegMaster
	        		    	println("industryRegMasterInstance.......2222......."+industryRegMasterInstance)
	        		    	/*def capInv = industryRegMasterInstance.indCapInvt
	    		        	    		     		
	        		    		def ecDetInst = EcCrzDetails.findByLicenceNo(industryRegMasterInstance.indRegNum)
	        		        	
	        		        	def ec = false
	        		        	if(ecDetInst){
	        		        		ec = true
	        		        		def ecInst =  ecDetInst
	        		        		ecInst.ecNo = params.ec_crz
	        		        		ecInst.issueDate = params.date
	        		        		if(ecInst.save(flush:true)){
	        		    	
	        		    			}else{
	        		    				ecInst.errors.each {
	        		    			
	        		    			   }
	        		    			}
	        		        		
	        		        	}*/
	        		    	if(params.lastConsentGranted=="online"){
	        		    		indApplicationDetailsInstance =	new IndApplicationDetails()
	        		    		indApplicationDetailsInstance.indUser = industryRegMasterInstance
	        		    		indApplicationDetailsInstance.applicationType = "CTO"  		    		
	        		    		indApplicationDetailsInstance.applicationFor = params.consentFor  		    		
	        		            indApplicationDetailsInstance.certificateFor = "autoReNew"
	        		            //indApplicationDetailsInstance.previousAppNo = "0000"
	        		            indApplicationDetailsInstance.applicationDate = new Date()
	        		    	    indApplicationDetailsInstance.actualApplicationDate = new Date()
	        		    		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
	        		            indApplicationDetailsInstance.completionStatus = "pending"
	        		            indApplicationDetailsInstance.clarification = false;
	        		        	indApplicationDetailsInstance.inspection = false;
	        		        	indApplicationDetailsInstance.annualProdCap = "0"
	        		        	indApplicationDetailsInstance.noOfStack = "0"
	        		        	
	        		        	//indApplicationDetailsInstance.authorFor = ""
	            		        //indApplicationDetailsInstance.recieptNo = "" 
	            		        indApplicationDetailsInstance.hazardeousType = ""
	            		        //indApplicationDetailsInstance.bookNo = ""
	            		        //indApplicationDetailsInstance.recieptDate = new Date()
	        		        	//indApplicationDetailsInstance.appDel = false;
	        		        	
	        		            if(indApplicationDetailsInstance.save()){
	        		            	println("saveee.......2222.......")
	        		            }else{
	        		            if(indApplicationDetailsInstance.hasErrors()){
	        		            indApplicationDetailsInstance.errors.allErrors.each {
	        		             
	        		              	   }
	        		                 }
	        		            }
	        		    	}else{
	        		    		
	        		    		indApplicationDetailsInstance=indAppInstance
	        		    	}
	        		        	println("lastConsentGranted.......2222......."+params.lastConsentGranted)
	        		    		println("indApplicationDetailsInstance.......2222......."+indApplicationDetailsInstance)
	        		        	def auotoRenewObj=new AutoRenewDetails();	
	        		        	auotoRenewObj.feeApplicable = "No"
	        					auotoRenewObj.oldApplicationDate = "No"
	        					auotoRenewObj.lastConsentGranted = params.lastConsentGranted
	        					auotoRenewObj.validUpto = new Date()
	        					auotoRenewObj.consentOrderNo = "No"
	        					auotoRenewObj.consentDate=new Date()
	        					auotoRenewObj.startDate="No"
	        					auotoRenewObj.endDate="No"
	        						auotoRenewObj.noOfYear = "No"
	        							auotoRenewObj.noIncreaseProduction = "No"
	        								auotoRenewObj.noSewageTradeEffluent = "No"
	        									auotoRenewObj.noIncreaseStacksEmission = "No"
	        										auotoRenewObj.noChangeManagementOwnership = "No"
	        											auotoRenewObj.noIncreaseProductionOverconsented = "No"
	        												auotoRenewObj.noCasePending = "No"
	        													auotoRenewObj.devicesInstalled = "No"
	        														auotoRenewObj.consentConditions = "No"
	        															auotoRenewObj.failure = "No"
	        																auotoRenewObj.abide = "No"
	        																
	        					if(params.lastConsentGranted=="online")
	        				    {
	        					auotoRenewObj.oldApplicationId=params.id
	        				    }else{
	        				    	
	        				    auotoRenewObj.oldApplicationId=" "
	        				    }
	        		        	println(" auotoRenewObj.oldApplicationId.......2222......."+ auotoRenewObj.oldApplicationId)
	        		        	// auotoRenewObj.oldApplicationId="No"
	        					auotoRenewObj.application=indApplicationDetailsInstance
	        					
	        					if(auotoRenewObj.save(flush:true)){
	        						println("Saveeeeeeeeeeeeeee.......2222.......")
	        					}else{
	        						auotoRenewObj.errors.each{
	        						println it
	        						}
	        					}
	        		       
	      
	        		           // render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,appFor:params.consent,capInv:capInv,oldIndApplicationId:indAppInstance.id,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewObj,indAppInstance:indAppInstance,lastConsentGranted:params.lastConsentGranted])
	        		             render(view:'autoRenewPage',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,appFor:params.consent,oldIndApplicationId:indAppInstance.id,autoRenewDisplay:'autoRenewSecondPage',checkForOldApplicationID:"firstTimeEntryForApplicationID",auotoRenewOldObj:auotoRenewObj,indAppInstance:indAppInstance,lastConsentGranted:params.lastConsentGranted])
	        		     	}
	        		        else
	        		    	{   
	        		        	flash.message="No application found for this request..."
	        		        	render(view:'autoRenewPage',model:[indAppInstance:indAppInstance,autoRenewDisplay:'autoRenewFirstPage'])
	        		     	    		        	
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
	    
	    
		 def saveAutoRenewConsent = {

	    		println("params---saveAutoRenewConsent-----"+params)
	    			println("session---saveAutoRenewConsent-----"+session)
	    		        //   println("strtDate "+params.strtDate)
	     			    	     println("expDate "+params.expDate)
	     			    	      println("issDate "+params.issDate)
		try {
			
			 def indUserIns = (IndUser)(session.indUser)
		    	if(session.indUser==null){
	            	flash.message="Your session has been expired ! Please login again."
	        		redirect(uri:'/index.gsp')
	        		return
		    	}
		
	    def indAppInstance
		def indApplicationDetailsInstance
		def abc = IndUser.get(indUserIns.id)
		def industryRegMasterInstance = abc.industryRegMaster
		def sublist = []
	    def pend
	    def pendReturn
//	    ////     Code Added by Deepak for single window
	    def cafUniqueNo
	   def  serviceId
	   def singleWin = false
	   
		if(session.cafUniqueNo){
			cafUniqueNo =session.cafUniqueNo
		}else{			
			cafUniqueNo =""
		}
		if(session.serviceId){
			serviceId=session.serviceId
		}else{
			serviceId=""
		}
		if(session.serviceId && session.cafUniqueNo){
			singleWin=true
		}
	   // 
		//def allreadyPendAutoRenwal=IndApplicationDetails.find("from IndApplicationDetails where indUserUniversal.id=? and certificateFor='autoReNew' and completionStatus='pending' and applicationType=? order by id desc",[indUserIns.industryRegMaster.id,params.consentType])
		def appCheck = ApplicationPendingDetails.find("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO' and application.certificateFor!='autoReNew' order by completionDate desc",[industryRegMasterInstance])
		def allreadyPendAutoRenwal=IndApplicationDetails.find("from IndApplicationDetails where indUser.id=? and certificateFor='autoReNew' and applicationType='CTO' order by id desc",[indUserIns.industryRegMaster.id])
		pend = ApplicationPendingDetails.findByApplicationAndApplicationStatus(allreadyPendAutoRenwal,"pending")
		
		def indAppInstanceForReturn=IndApplicationDetails.findAll("from IndApplicationDetails where indUser.id=? and certificateFor='autoReNew' and applicationType='CTO' order by id desc",[indUserIns.industryRegMaster.id])
		for(int i=0;i<indAppInstanceForReturn.size;i++){
			def pend22 = ApplicationPendingDetails.findByApplicationAndApplicationStatus(indAppInstanceForReturn[i],"rejected")
			if(pend22){
					flash.message=" Auto Renewal Aplication Allready Rejected..!!"
	    			redirect(controller:'indUser',action:'openIndustryHome')
		        	return;
			}
		}
		
		if(allreadyPendAutoRenwal && allreadyPendAutoRenwal.completionStatus=="pending"){
			flash.message=" Auto Renewal Aplication Allready InProgress..!!"
			redirect(controller:'indUser',action:'openIndustryHome')
	    	return;
		}
	    if(pend){
	    	flash.message=" Auto Renewal Aplication In In-Progress..!!"
				redirect(controller:'indUser',action:'openIndustryHome')
	        	return;
	    }
	    
	    int yearVal = Calendar.getInstance().get(Calendar.YEAR);
	    println("yearVal------"+yearVal)
	    if(params.expDate){
						def sdfh1 = new SimpleDateFormat("dd/MM/yyyy");
						
						def dVal = sdfh1.parse(params.expDate)
						println("dVal-----"+dVal)
						Calendar myCal = Calendar.getInstance(TimeZone.getDefault());
						myCal.setTime(dVal);
						System.out.println("myCal-----"+myCal);
						System.out.println("year-----"+myCal.get(Calendar.YEAR));
			int expYear = myCal.get(Calendar.YEAR)
			System.out.println("expYear-----"+expYear);
			
			/*Calendar todayDate1 = Calendar.getInstance();
			println("todayDate1-----"+todayDate1)
			todayDate1.set(Calendar.MONTH, 04);
			todayDate1.set(Calendar.DATE, 15);
			//todayDate.set(Calendar.YEAR, yearVal);
			println("todayDate1-new----"+todayDate1)
			
			Calendar todayDate2 = Calendar.getInstance();
			println("todayDate2-----"+todayDate2)
			todayDate2.set(Calendar.MONTH, 04);
			todayDate2.set(Calendar.DATE, 16);
			
			int valCheck = todayDate1.compareTo(myCal);
			println("valCheck----->"+valCheck)
			
			if(valCheck >=0){
				System.out.println("date before 15 april-----");
				
			}
			else {
				System.out.println("date after 15 april-----");
				flash.message=" Auto Renewal Aplication can not be applied as timeline for application is exhausted."
	    			redirect(controller:'indUser',action:'openIndustryHome')
		        	return;	
			}*/
			
			/*if(expYear == yearVal)
			{
				System.out.println("expYear--yearVal same---");
				
				Calendar todayDate = Calendar.getInstance();
				println("todayDate-----"+todayDate)
				todayDate.set(Calendar.MONTH, 04);
				todayDate.set(Calendar.DATE, 30);
				//todayDate.set(Calendar.YEAR, yearVal);
				println("todayDate-new----"+todayDate)
				
				Calendar todayDate2 = Calendar.getInstance();
			println("todayDate2-----"+todayDate2)
			//todayDate2.set(Calendar.MONTH, 04);
			//todayDate2.set(Calendar.DATE, 16);
				
				int valCheck = todayDate.compareTo(todayDate2);
				println("valCheck----->"+valCheck)
				
				if(valCheck >=0){
					System.out.println("date before 15 april-----");
					
				}
				else {
					System.out.println("date after 15 april-----");
					flash.message=" Auto Renewal Aplication can not be applied as timeline for application is exhausted."
		    			redirect(controller:'indUser',action:'openIndustryHome')
			        	return;	
				}
				
				
			}*/
		  /*  else if(expYear > yearVal)
			{
				System.out.println("expYear--greater----yearVal-----");
				flash.message=" Auto Renewal Aplication can not be applied as previous CTO granted is not going to expire in 90 days."
	    			redirect(controller:'indUser',action:'openIndustryHome')
		        	return;
			} 
			else if(expYear < yearVal)
			{
				System.out.println("expYear----yearVal----greater---");
				flash.message=" Auto Renewal Aplication can not be applied as previous CTO granted is already expired."
	    			redirect(controller:'indUser',action:'openIndustryHome')
		        	return;
			}*/
			
	    }
	    
	    
		//def enterdIndAppId=(params.lastestConRenewalNo).substring(5)
		def enterdIndAppId=(params.prevApp)
		if(params.online == "online" && enterdIndAppId){
		
			indAppInstance=IndApplicationDetails.find("from IndApplicationDetails where id=? ",[enterdIndAppId.toLong()])
			
	  }
		
		
		           if(indAppInstance != null){
				   def check1=true
			    	
			    	def capInv = industryRegMasterInstance.indCapInvt
		        	
			    	if(params.online=="online"){
			    	
			    		indApplicationDetailsInstance =	new IndApplicationDetails()
			    		indApplicationDetailsInstance.indUser = industryRegMasterInstance
			    		indApplicationDetailsInstance.indUser = industryRegMasterInstance
			    		indApplicationDetailsInstance.applicationType = params.consentType 		    		
			    		indApplicationDetailsInstance.applicationFor = params.consentFor  		    		
			            indApplicationDetailsInstance.certificateFor = "autoReNew"
			            indApplicationDetailsInstance.applicationDate = new Date()
			    	    indApplicationDetailsInstance.actualApplicationDate = new Date()
			    		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
			            indApplicationDetailsInstance.completionStatus = "pending"
			            indApplicationDetailsInstance.clarification = false;
			        	indApplicationDetailsInstance.inspection = false;
			        	indApplicationDetailsInstance.annualProdCap = "0"
			        	indApplicationDetailsInstance.noOfStack = "0"
			        	indApplicationDetailsInstance.hazardeousType = "NONHWM"
			        	indApplicationDetailsInstance.cafUniqueNo = cafUniqueNo
	    		        indApplicationDetailsInstance.serviceId = serviceId
	    		        indApplicationDetailsInstance.singleWin =singleWin
//	    		        indApplicationDetailsInstance.recieptDate = new Date()
			        	//indApplicationDetailsInstance.appDel = false;
			        	
			            if(indApplicationDetailsInstance.save()){
			            	
			            }else{
			            	if(indApplicationDetailsInstance.hasErrors()){
			            		println("indApplicationDetailsInstance not saved")
			            			indApplicationDetailsInstance.errors.allErrors.each {
			            		}
			                 }
			            }
			    	}else{
			    		
			    		//indApplicationDetailsInstance=indAppInstance[0]
			    	}
			    		    	    	
		    	   def auotoRenewObj=new AutoRenewDetails();
		    	   
			        auotoRenewObj.feeApplicable=""
					auotoRenewObj.lastConsentGranted=params.online
					println("params.expDate-----"+params.expDate)
			        println("params.issDate-----"+params.issDate)
			        
					if(params.expDate){
						def sdfh = new SimpleDateFormat("dd/MM/yyyy");
						
						def dVal = sdfh.parse(params.expDate)
						println("dVal-----"+dVal)
						Calendar myCal = Calendar.getInstance(TimeZone.getDefault());
						myCal.setTime(dVal);
						System.out.println("myCal-----"+myCal);
						System.out.println("year-----"+myCal.get(Calendar.YEAR));
						
						
						def sdfh11 = new SimpleDateFormat("dd/MM/yyyy"); 
						java.util.Date date = sdfh11.parse(params.expDate);
						java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
						
						java.util.Date dates = sdfh11.parse(params.issDate);
						java.sql.Date sqlStartDates = new java.sql.Date(dates.getTime());
						
						
						
						//def x = sdfh11.parse(params.issDate);
						println("sqlStartDate-----"+sqlStartDate)
						println("sqlStartDates-----"+sqlStartDates)
						
					/*	java.util.Date sqlDate = new java.util.Date(x.getTime())
						java.util.Date sqlDate1 = new java.util.Date(dVal.getTime()) 
						
						def dfh1 = new SimpleDateFormat("dd/MM/yyyy");
						
						
					    def	draftDate= dfh1.format((java.util.Date) sqlDate)
					     def draftDate2= dfh1.format((java.util.Date) sqlDate1)
						 println("draftDate-" +draftDate)
						 println("draftDate-" +draftDate2)*/
						
					//	Date validUpto = sdfh11.parse(params.expDate);
					//	println("sqlDate-----"+sqlDate)
					//	println("sqlDate1-----"+sqlDate1)
						
					//	def validUpto=""
			        		auotoRenewObj.consentOrderNo=enterdIndAppId
   			        		auotoRenewObj.consentDate= sqlStartDates// Previous consent Auto Renewal Start Date
	        				auotoRenewObj.validUpto=sqlStartDate  // Previous consent Auto Renewal end Date
	        				  println("consentDate-----"+auotoRenewObj.consentDate)
						      println("validUpto-----"+auotoRenewObj.validUpto)
	        				
	        			//	auotoRenewObj.validUptoYear = myCal.get(Calendar.YEAR)+""
	        				
			        }else{
			        		auotoRenewObj.consentOrderNo="NA"
			        		auotoRenewObj.consentDate=""
		        			auotoRenewObj.validUpto=""  
			        	}
			     //   auotoRenewObj.conFor=params.consentFor
			        if(appCheck)
			        	auotoRenewObj.oldApp= (appCheck.application.id).toString()
			        	println("oldApp-----"+auotoRenewObj.oldApp)
						auotoRenewObj.startDate=""
						auotoRenewObj.endDate=""
						auotoRenewObj.noOfYear=""
				//		auotoRenewObj.consentRenwalOrderNo=""
					if(indAppInstance)
					   {
						auotoRenewObj.oldApplicationId=indAppInstance
						auotoRenewObj.oldApplicationDate=indAppInstance.actualApplicationDate
					   }else{
					    auotoRenewObj.oldApplicationId=""
					    auotoRenewObj.oldApplicationDate=""
					   }
			        auotoRenewObj.abide=""
			        auotoRenewObj.consentConditions=""
			        auotoRenewObj.devicesInstalled=""
			        auotoRenewObj.failure=""
			        auotoRenewObj.noCasePending=""
			        auotoRenewObj.noChangeManagementOwnership=""
			        auotoRenewObj.noIncreaseProduction=""
			        auotoRenewObj.noIncreaseProductionOverconsented=""
			        auotoRenewObj.noIncreaseStacksEmission=""
			        auotoRenewObj.noSewageTradeEffluent=""
			        									 
					//	auotoRenewObj.autoRenwalApplied=""
			        	auotoRenewObj.application=(IndApplicationDetails)indApplicationDetailsInstance
						
						if(auotoRenewObj.save()){
							println("auotoRenewObj saved "+auotoRenewObj)
							
						}else{
							println("auotoRenewObj not saved "+auotoRenewObj)
							auotoRenewObj.errors.each{
							println it
							}
						}
			             println("DEEPAK indApplicationDetailsInstance "+indApplicationDetailsInstance)
			              println("DEEPAK auotoRenewObj "+auotoRenewObj)

			            render(view:'autoRenewPage',model:[consentType:params.consentType,indApplicationDetailsInstance:indApplicationDetailsInstance,oldIndApplicationId:indAppInstance.id,autoRenewDisplay:'autoRenewSecondPage',industryRegMasterInstance:industryRegMasterInstance,auotoRenewObj:auotoRenewObj])
			     	}
			        else
			    	{   
			        	flash.message="No application found for this request..!!"
			        	//render(view:'autoRenewPage',model:[indAppInstance:indAppInstance,autoRenewDisplay:'autoRenewFirstPage'])
			        	redirect(action:applyConsent)
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
	    // Added By Deepak Kumar
		 def editAutoRenewConsent = {
	    		println("HELLO DEEPAK"+params)
	    		   try {
	    		   def indApplicationDetailsInstance=IndApplicationDetails.get((params.indAppDetId).toLong())
	    		   def oldIndApplicationId1=AutoRenewDetails.findByApplication(indApplicationDetailsInstance)
	    		   def oldIndApplicationId=oldIndApplicationId1.oldApplicationId
	    		   def indUser1=indApplicationDetailsInstance.indUser
	    		   def industryRegMasterInstance=IndustryRegMaster.get((indUser1.id).toLong())   
	    		   def consentType=indApplicationDetailsInstance.applicationType   
	    		   def  auotoRenewObj=AutoRenewDetails.find("from AutoRenewDetails abc where abc.application=?",[indApplicationDetailsInstance])
	    		   println("auotoRenewOldObj "+auotoRenewObj)
	    		   render(view:'autoRenewPage',model:[oldIndApplicationId:oldIndApplicationId,consentType:consentType,autoRenewDisplay:'autoRenewFirstPage',autoRenewDisplay:'autoRenewSecondPage',indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,auotoRenewObj:auotoRenewObj])

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
	    
		  def doGetShowOfficer ={

			def testVal1 = params.testVal1
			def listDoc= new ArrayList()
			def listDocNew1= new ArrayList()
			def listDocNew2= new ArrayList()
			def listDocNew= new ArrayList()
			def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
			def viewCert = false
			def certInst = RecordCertificate.find("from RecordCertificate where applicationId=? order by id desc ",[indApplicationDetailsInstance])	
				
				def appProcessDetList = ApplicationPendingDetails.findAllByApplication(indApplicationDetailsInstance);
				if(appProcessDetList){
					def appProcessDet = appProcessDetList.get(appProcessDetList.size()-1)
					if(certInst && appProcessDet.applicationStatus == "approved"){
						viewCert = true
					}
				}

				def appFor = indApplicationDetailsInstance.applicationFor
				def industryRegMasterInstance = indApplicationDetailsInstance.indUser
				def indProductDetailsInstanceList = IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
				def consentFeeMasterInstance = ConsentFeeMaster.findByApplication(indApplicationDetailsInstance)
				def feeBankDetailsInstanceList = FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
				def indWaterConsumptionDetailsInstanceList = IndWaterConsumptionDetails.findAllByApplication(indApplicationDetailsInstance)
				def indWaterDischargeDetailsInstanceList = IndWaterDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
				def indEffluentStandardDetailsInstanceList = IndEffluentStandardDetails.findAllByApplication(indApplicationDetailsInstance)
				def indAirStackEmmisionDetailsInstanceList = IndAirStackEmmisionDetails.findAllByApplication(indApplicationDetailsInstance)
				def indEmmisionCntrlDetailsInstanceList = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
				def indAirFuelDetailsInstanceList = IndAirFuelDetails.findAllByApplication(indApplicationDetailsInstance)
				def indAirFugitiveDetailsInstanceList = IndAirFugitiveDetails.findAllByApplication(indApplicationDetailsInstance)
				def indEmmisionCntrlDetailsInstanceList2 = IndEmmisionCntrlDetails.findAllByApplication(indApplicationDetailsInstance)
				def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id desc",[indApplicationDetailsInstance])
				
				for(int ig=0;ig<applicationDocumentInstance.size();ig++){
					def boolCheck=false
					if(listDoc.size()==0){
						listDoc.add(applicationDocumentInstance.get(ig))
					}
					for(int intCheck=0;intCheck<listDoc.size();intCheck++){
						if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
							boolCheck=true
						}
					}
					if(boolCheck==false){
						listDoc.add(applicationDocumentInstance.get(ig))
					}
					
				}
				def appFileRecordIns=ApplicationFileRecord.findAll(" from ApplicationFileRecord apd where apd.indApplication=? and apd.typeOfFile= 'attachedClarificationReport'  order by apd.id desc",[indApplicationDetailsInstance])
				for(int igi=0;igi<appFileRecordIns.size();igi++)
				{
					listDocNew.add(appFileRecordIns.get(igi))
				}
				
				def appFileRecordIns1=ApplicationFileRecord.findAll(" from ApplicationFileRecord apd where apd.indApplication=? and apd.description= 'Application Clarification Report File' and apd.typeOfFile='indClarificationFile'  order by apd.id desc",[indApplicationDetailsInstance])
				for(int igi=0;igi<appFileRecordIns1.size();igi++)
				{
					listDocNew1.add(appFileRecordIns1.get(igi))
				}
				
				def appFileRecordIns2=ApplicationFileRecord.findAll(" from ApplicationFileRecord apd where apd.indApplication=? and apd.description= 'Application Clarification Report File' and apd.typeOfFile!='indClarificationFile'  order by apd.id desc",[indApplicationDetailsInstance])
				for(int igi=0;igi<appFileRecordIns2.size();igi++)
				{
					listDocNew2.add(appFileRecordIns2.get(igi))
				}
	 			
				
				render(view:'doShowOfficer',model:[listDocNew2:listDocNew2,listDocNew1:listDocNew1,listDoc:listDoc,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,indProductDetailsInstanceList:indProductDetailsInstanceList,consentFeeMasterInstance:consentFeeMasterInstance,feeBankDetailsInstanceList:feeBankDetailsInstanceList,indWaterConsumptionDetailsInstanceList:indWaterConsumptionDetailsInstanceList,indWaterDischargeDetailsInstanceList:indWaterDischargeDetailsInstanceList,indEffluentStandardDetailsInstanceList:indEffluentStandardDetailsInstanceList,indAirStackEmmisionDetailsInstanceList:indAirStackEmmisionDetailsInstanceList,indEmmisionCntrlDetailsInstanceList:indEmmisionCntrlDetailsInstanceList,indAirFuelDetailsInstanceList:indAirFuelDetailsInstanceList,indAirFugitiveDetailsInstanceList:indAirFugitiveDetailsInstanceList,indEmmisionCntrlDetailsInstanceList2:indEmmisionCntrlDetailsInstanceList2,appFor:appFor,viewCert:viewCert,listDocNew:listDocNew])
		
			
		
	    }
		 def viewAutoRenewConsentCom = {
      		   try {
      		   
      		   def indApplicationDetailsInstance=IndApplicationDetails.get((params.id).toLong())
      		   def oldIndApplicationId1=AutoRenewDetails.findByApplication(indApplicationDetailsInstance)
          //	   def oldIndApplicationId=oldIndApplicationId1.oldApplicationId
      		   def feeDetails=FeeBankOtherDetails.findByApplication(indApplicationDetailsInstance)
      		   def indUser1=indApplicationDetailsInstance.indUser
      		   def industryRegMasterInstance=IndustryRegMaster.get((indUser1.id).toLong())   
      		   def consentType=indApplicationDetailsInstance.applicationType   
      		   def  auotoRenewObj=AutoRenewDetails.find("from AutoRenewDetails abc where abc.application=?",[indApplicationDetailsInstance])
      		   println("auotoRenewObj "+auotoRenewObj)
      		   render(view:'viewAutoRenewConsentCom',model:[feeDetails:feeDetails,consentType:consentType,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,auotoRenewObj:auotoRenewObj])

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
		  def viewAutoRenewConsent = {
				   try {
				   def indApplicationDetailsInstance=IndApplicationDetails.get((params.id).toLong())
				   def feeDetails=FeeBankOtherDetails.findByApplication(indApplicationDetailsInstance)
				   def indUser1=indApplicationDetailsInstance.indUser
				   def industryRegMasterInstance=IndustryRegMaster.get((indUser1.id).toLong())   
				   def consentType=indApplicationDetailsInstance.applicationType
				   def catVal = industryRegMasterInstance.category.name
	    		    println("catVal-------"+catVal)
	    		     
	    		    if(catVal!="GREEN")
	    		   {
	    			        flash.message="Auto Renewal can be applied only by Industries of Green category." 
		  		  			redirect(action:applyConsent)
		  		  			return 
	    			 
	    		   }
				   def  auotoRenewObj=AutoRenewDetails.find("from AutoRenewDetails abc where abc.application=?",[indApplicationDetailsInstance])
				   render(view:'viewAutoRenewConsent',model:[oldIndApplicationId:params.oldIndApplicationId,feeDetails:feeDetails,consentType:consentType,indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,auotoRenewObj:auotoRenewObj])

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
    
	    
		 def viewFormPdfAutoRenew={
	    		println("IN viewFormPdfAutoRenew")
		    		def applicationFileInstance
		    		def fileVer=(params.verValue)
		    		def application = IndApplicationDetails.get((params.appliLoc).toLong())
		    		if(fileVer=="air"){
		    			println("IN viewFormPdfAutoRenew air")
		    			applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='AutoRenwalFormForAir' order by id desc",[application],[max:1])
		    		}else {
		    			println("IN viewFormPdfAutoRenew WATER")
		    			applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='AutoRenwalFormForWater' order by id desc",[application],[max:1])
		    		}
	    		println("applicationFileInstance "+applicationFileInstance)
		    		if(applicationFileInstance){
		    		def applicationFileSingleInstance=applicationFileInstance[0]
		    		response.setContentType( "application-xdownload")
		    		response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
		    		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
		    		}else{
		    			flash.message = 'Document not found'
		    			//redirect(action:doGetShow,id:application)
		    			redirect(controller:'indUser',action:'openIndustryHome')
		    		}
		    	    }
		 def downLoadUploadedDoc = {
         		def indApplInstance=(params.id).toLong()
         		def applicationDocumentL=ApplicationDocuments.findAll("from ApplicationDocuments apd where apd.id=? ",[indApplInstance],[max:1] )
         		def singleInstanceOfApplicationDocument=applicationDocumentL[0]
         		response.setContentType( "application-xdownload")
         		response.setHeader("Content-Disposition", "attachment;filename=${singleInstanceOfApplicationDocument.name}")
         		response.getOutputStream() << new ByteArrayInputStream( singleInstanceOfApplicationDocument.data )
         	    }     
         
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
		 def saveConsentSingle={
				 println("iNSIDE  saveConsentSingle Param-----------"+params)
					println("iNSIDE  saveConsentSingle Session -----------"+session)
				 try {
		    		def check1=true
		        	def indUserIns = (IndUser)(session.indUser)
		        	println("indUserIns "+indUserIns.id)
		        	def abc = IndUser.get(indUserIns.id)
		        	def industryRegMasterInstance = abc.industryRegMaster
		        	def cafUniqueNo= params.cafUniqueNo
		        	def serviceId=params.serviceId
		        	
		        	// Code by Deepak for white cat
		        	def cat = industryRegMasterInstance.category.name
    	    		println("cat-----"+cat)
    	    		if(cat=='WHITE'){
    	    			
    	    			redirect(controller:'industryRegMaster',action:'createWhiteCategory')
    	    			 //render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,appFor:params.consent])
    	    		}
		        	def indAppp=IndApplicationDetails.findAll("from IndApplicationDetails iss Where iss.cafUniqueNo=? and iss.indUser=? and iss.serviceId=?",[cafUniqueNo,industryRegMasterInstance,serviceId])
		        	 println("hello jiiiii "+indAppp)
		        	 println("hello jiiiii "+indAppp.size())
		        	if(indAppp){
		        		//  New Code added by deepak   
		        		for (int i =0; i< indAppp.size(); i ++)
						{
							
							/********Pending Application*******************/
							def indAppInstancePending =IndApplicationDetails.find("from IndApplicationDetails as iad where iad.completionStatus='pending' and iad.id = ? ",[indAppp[i].id]);
							println("Pending Application*** "+indAppInstancePending)        
							if (indAppInstancePending)
							{					
								                                                                                                     
									redirect(controller:'indUser',action:'openIndustryHome');
									return
								
							}
							/********Completed Application*******************/
							def indAppInstanceCompleted =IndApplicationDetails.find("from IndApplicationDetails as iad where iad.completionStatus='completed' and iad.id = ? ",[indAppp[i].id]);
							if (indAppInstanceCompleted)
							{	    
								    println("Completed Application*** "+indAppInstanceCompleted)                                                                                                          
									def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=? and abc.applicationStatus IN ('pending','returned')",[indAppp[i]]);
								    println("appPendingInst 222*** "+appPendingInst)
								    if(appPendingInst){										   
										redirect(controller:'indUser',action:'openIndustryHome');
										return
									}
								    def appPendingScrIncomple = ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=? and abc.applicationStatus ='rejected' and abc.completionStatus='In-Complete' ",[indAppp[i]]);
								    println("appPendingScrIncomple 222*** "+appPendingScrIncomple)
								    if(appPendingScrIncomple){										   
										redirect(controller:'indUser',action:'openIndustryHome');
										return
									}
								
							}
											
						}
		        		 render(view:'setHwmDetails',model:[industryRegMasterInstance:industryRegMasterInstance,radiobutton1:params.radiobutton1,appFor:params.appFor,serviceId:params.serviceId])
		        	
		        		//redirect(controller:'indUser',action:'openIndustryHome');
						//return;
		        	}
		        	
		    		 render(view:'setHwmDetails',model:[industryRegMasterInstance:industryRegMasterInstance,radiobutton1:params.radiobutton1,appFor:params.appFor,serviceId:params.serviceId])
		    		
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
			 def saveConsentForSingleWindow = {

			        	println("params in saveConsentForSingleWindow,,,,,,"+params)
			        	
			        	def check1=true
			        	def indUserIns = (IndUser)(session.indUser)
			        	println("indUserIns "+indUserIns.id)
			        	def abc = IndUser.get(indUserIns.id)
			        	def industryRegMasterInstance = abc.industryRegMaster
			        	def cafUniqueNo= params.cafUniqueNo
			        	def serviceId=params.serviceId
			        	def isApplicable = false
		    	    	if(params.radiobutton1 == "CTE"){
		    	    	if(params.consent == "air" || params.consent == "water" || params.consent == "both"|| 
		    	    			params.consent == "stonecrusher"|| params.consent == "dgset"|| params.consent == "brickkilns"|| params.consent == "hotel" ||
		    	    			params.consent == "hotmixplants" || params.consent == "stonecrusher and hotmixplants"){
		    	    		if(params.appFor == "new" || params.appFor == "Modern" || params.appFor == "expan" || params.appFor == "reNew"){
		    	    		 isApplicable = true
		    	    	}
		    	    	}
		    	    	}
		    	    	else if(params.radiobutton1 == "CTO"){
		    	        	if(params.consent == "air" || params.consent == "water" || params.consent == "both"|| 
		    	        			params.consent == "stonecrusher"|| params.consent == "dgset"|| params.consent == "brickkilns"|| params.consent == "hotel" || 
		    	        				params.consent == "hotmixplants" || params.consent == "stonecrusher and hotmixplants"){
		    	        		if(params.appFor == "new" || params.appFor == "Modern" || params.appFor == "expan" || params.appFor == "reNew"){
		    	        		 isApplicable = true
		    	        	}
		    	        	}
		    	        	}
			        	
                          ////////////////				 	Code for AutoReNew for Single Window by Deepak   ////////////////////

				    	if(params.appFor == "autoReNew" && params.radiobutton1 == "CTO"){
				    		 //flash.message="Please read Terms and condition carefully"	
				    	    
				    		 def catVal = industryRegMasterInstance.category.name
				    		 println("catVal-------"+catVal)
				    		 
				    		 if(catVal!="GREEN")
				    		 {
				    			 flash.message="Auto Renewal can be applied only by Industries of Green category." 
					  		  			redirect(action:applyConsent)
					  		  			return 
				    			 
				    		 }
				    		 
				    		 if(params.hazardeousType=="HWM")
				    		 {
				    			 flash.message="Auto Renewal can be applied only by Industries of NON-HWM ." 
					  		  			redirect(action:applyConsent)
					  		  			return 
				    			 
				    		 }
				    		 
				    			println("industryRegMasterInstance===saveConsent=="+industryRegMasterInstance)
				    			
				    		 def appCheck = ApplicationPendingDetails.findAll("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO'",[industryRegMasterInstance])
				    		println("appCheck-------application---pending====="+appCheck)
				    		 if(!appCheck)
				    		 {
				    			 flash.message="You can not apply for Auto renewal as there is no CTO application approved on OCMMS" 
					  		  			redirect(action:applyConsent)
					  		  			return 
				    			 
				    		 }			    		 
				    		 
				    		 render(view:'autoRenewApply',model:[industryRegMasterInstance:industryRegMasterInstance,consentFor:params.consent,consentType:params.radiobutton1])
				    	     return
				          }

		    	    	if(isApplicable){
		    	    		// New code for white category by Deepak
		    	    		def cat = industryRegMasterInstance.category.name
		    	    		println("cat-----"+cat)
		    	    		if(cat=='WHITE'){
		    	    			
		    	    			redirect(controller:'industryRegMaster',action:'createWhiteCategory')
		    	    			 //render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,appFor:params.consent])
		    	    		}else{
		    	    		
		    	    		def ecDetInst = EcCrzDetails.findByLicenceNo(industryRegMasterInstance.indRegNum)
		    	        	def ec = false
		    	        	if(ecDetInst){
		    	        		ec = true
		    	        		def ecInst =  ecDetInst
		    	        		ecInst.ecNo = params.ec_crz
		    	        		ecInst.issueDate = params.date
		    	        		if(ecInst.save(flush:true)){
		    	    			}else{
		    	    				ecInst.errors.each {
		    	    			      println it;  
		    	    			   }
		    	    			}
		    	        	}
		    	    		def indApplicationDetailsInstance =	new IndApplicationDetails()
		    	    		println("......calling..params.cafUniqueNo....."+params.cafUniqueNo)
		    	    		indApplicationDetailsInstance.cafUniqueNo=params.cafUniqueNo
		    	    		
		    	    		
		    	    		indApplicationDetailsInstance.indUser = industryRegMasterInstance
		    	    		indApplicationDetailsInstance.applicationType = params.radiobutton1
		    	    		if(params.hazardeousType){
		    	            	indApplicationDetailsInstance.hazardeousType = params.hazardeousType 
		    	                }else{
		    	                	indApplicationDetailsInstance.hazardeousType ="";
		    	                }
		    	            indApplicationDetailsInstance.applicationFor = params.consent
		    	            indApplicationDetailsInstance.certificateFor = params.appFor
		    	            indApplicationDetailsInstance.applicationDate = new Date()
		    	    		indApplicationDetailsInstance.actualApplicationDate = new Date()
		    	    		indApplicationDetailsInstance.applicationName = industryRegMasterInstance.indName
		    	            indApplicationDetailsInstance.completionStatus = "pending"
		    	            indApplicationDetailsInstance.clarification = false;
		    	        	indApplicationDetailsInstance.inspection = false;
		    	        	indApplicationDetailsInstance.annualProdCap = "0"
		    	        	indApplicationDetailsInstance.noOfStack = "0"
		    	        	indApplicationDetailsInstance.serviceId=serviceId
		    	        	indApplicationDetailsInstance.singleWin=true
		    	        	if(params.hazardeousType){
		    	        	indApplicationDetailsInstance.hazardeousType=params.hazardeousType
		    	        	}else{
		    	        		indApplicationDetailsInstance.hazardeousType="NONHWM"
		    	        	}
		    	            if(indApplicationDetailsInstance.save()){
		    	            	println("...details....save......")
		    	            }else{
		    	            	if(indApplicationDetailsInstance.hasErrors()){
		    	              	   indUserInstance.errors.allErrors.each {
		    	              		   println it;
		    	                  }
		    	                 }
		    	            }
		    	            render(view:'doEdit',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,industryRegMasterInstance:industryRegMasterInstance,appFor:params.consent])
		    	    	}
		    	    	}else{
		    	    		redirect(action:applyConsent)
		    	    	}
		    }
		 def downloadApplicationForm={
				 try{
				 println("params in downloadApplicationForm ----"+params)
				def appId=params.id
				def application=IndApplicationDetails.get(appId.toLong())
					def applicationFileInstance
				
				if(application.certificateFor!="autoReNew"){
				 applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile IN('FormAir','FormWater') order by afr.id desc",[application],[max:1])
				}else{
					 applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile IN('AutoReNewForm') order by afr.id desc",[application],[max:1])
				}
				 def applicationFileSingleInstance=applicationFileInstance[0]
    	  		 response.setContentType( "application-xdownload")
    	  		 response.setHeader("Content-Disposition","attachment;filename=\""+"applicationform.pdf"+"\"" )
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
		 def confirmSubmission={

					try {
					    println(params)
					    def indApplicationDetailsInstance = IndApplicationDetails.get(params.indAppDetId)
					   indApplicationDetailsInstance.completionStatus = "completed"
					   indApplicationDetailsInstance.save()
					    updateAllSummaryReport((indApplicationDetailsInstance.id).toString());	//add by 
					   // insertIntoTracking(indApplicationDetailsInstance);// for insert into tracking table;
					    def formView = indApplicationDetailsInstance.applicationFor
					    println("formView---"+formView)
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
		 def checkList ={
					def docList =DocumentChecklistMaster.findAll("from DocumentChecklistMaster where applicationFor ='CTE Fresh' and consentFor='new' order by document asc")
	    			 println("inside CTE new..docList."+docList)
		 }
}