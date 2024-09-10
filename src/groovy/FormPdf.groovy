import java.util.*
import java.text.*
public class FormPdf{

	public void formAir(Long appId,String sessionValue)
	{
		try{
		File certFile
		ApplicationFileRecord file=new ApplicationFileRecord()
	
		def arrayListStack= new ArrayList()
		def testList1= new ArrayList()
		
		def feeDetails1= new ArrayList()
		
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		
		
		def applicationId=appId.toString()
		
		def abcF=indApplicationDetailsInstance.applicationDate
		DateCustom dd=new DateCustom()
				if(abcF.getClass().getName()=="java.sql.Date")
				{
					indApplicationDetailsInstance.applicationDate=abcF
				}
				else
				{
					def xyz= dd.toDate(abcF)
					indApplicationDetailsInstance.applicationDate=xyz
				}
		def dateOfSubmission=(indApplicationDetailsInstance.applicationDate).toString()
		def industryName=indApplicationDetailsInstance.indUser.indName
		def industryPlot=indApplicationDetailsInstance.indUser.plotNo
		def industryAddress=indApplicationDetailsInstance.indUser.indAddress
		def industryTehsil=indApplicationDetailsInstance.indUser.tehsil.tehsilName
		def industryDistrict=indApplicationDetailsInstance.indUser.district.districtName
		def industryTelephone=indApplicationDetailsInstance.indUser.indPhoneCode+"-"+indApplicationDetailsInstance.indUser.indPhoneNo
		def totEmployees=indApplicationDetailsInstance.indUser.noOfEmp
		def licAnnualCap=indApplicationDetailsInstance.annualProdCap
		
		def generalShift=indApplicationDetailsInstance.indUser.shiftsIndustry
		
		def nameAddressPartners=indApplicationDetailsInstance.indUser.nameAddressPartners
		
		
		def occupierName=indApplicationDetailsInstance.indUser.occName
		def occupierDesignation=indApplicationDetailsInstance.indUser.occDesignation
		def occupierAddress=indApplicationDetailsInstance.indUser.occAddress
		def occupierTehsil=indApplicationDetailsInstance.indUser.occTehsil
		def occupierDistrict=indApplicationDetailsInstance.indUser.occDistrict
		def occupierTelephone=indApplicationDetailsInstance.indUser.occPhoneCode+"-"+indApplicationDetailsInstance.indUser.occPhoneNo
		
		def dtOfCommissioning=indApplicationDetailsInstance.indUser.dateOfComm
		def capitalInvestment=(indApplicationDetailsInstance.indUser.indCapInvt).toString()
		
//		def newCapitalInvestment=(indApplicationDetailsInstance.indUser.indNewCapInvt).toString()
		
		def airStackDetailsList= AirStackDetails.findAllByApplication(indApplicationDetailsInstance)
		
		def naturaldraft=""
		def materialConstruction=""
		def aboveGroundHeight=""
		def aboveFactHeight=""
		def nameEquipment = new String[airStackDetailsList.size()]
		def reductionEff 
		def quantity
		def quality
		def monitoring
		def pollInstall= new ArrayList()
		def plantEquipmentDetails= new ArrayList()
		def stackMonitor = new ArrayList()
		def plantQuantityDetails = new ArrayList()
		def reductionEfficieDetails = new ArrayList()
		
		if(airStackDetailsList.size()<1){
			reductionEff= new String[1]
			quantity= new String[1]
			quality= new String[1]
			monitoring= new String[1]
			reductionEff[0]="";
			quantity[0]="";
			quality[0]="";
			monitoring[0]="";
		}
		
		for(int var1=0;var1<airStackDetailsList.size();var1++)
		{
			def firstD=airStackDetailsList.get(var1)
			def second=indApplicationDetailsInstance
			
			nameEquipment[var1]=(firstD).toString()
			
			def airStackEquipmentInstance=AirStackEquipmentDetails.findAllByStack(firstD)
			if(airStackEquipmentInstance){
				reductionEff= new String[airStackEquipmentInstance.size()]
				quantity= new String[airStackEquipmentInstance.size()]
				quality= new String[airStackEquipmentInstance.size()]
				monitoring= new String[airStackEquipmentInstance.size()]
				nameEquipment[var1]=nameEquipment[var1]+ " ["
			}else{
				reductionEff= new String[1]
				quantity= new String[1]
				quality= new String[1]
				monitoring= new String[1]
				reductionEff[0]="";
				quantity[0]="";
				quality[0]="";
				monitoring[0]="";
			}
			if(airStackEquipmentInstance){
				for(int varEquip=0;varEquip<airStackEquipmentInstance.size();varEquip++)
				{
					def installPoll=new ArrayList()
					nameEquipment[var1]=nameEquipment[var1]+((airStackEquipmentInstance.get(varEquip)).equipment.controlMeasure).toString()
					reductionEff[varEquip]=((airStackEquipmentInstance.get(varEquip)).equipment.controlMeasure).toString()+" : "+(airStackEquipmentInstance.get(varEquip)).redEfficiency
					quantity[varEquip]=((airStackEquipmentInstance.get(varEquip)).equipment.controlMeasure).toString()+" : "+(airStackEquipmentInstance.get(varEquip)).quantity
					quality[varEquip]=((airStackEquipmentInstance.get(varEquip)).equipment.controlMeasure).toString()+" : "+(airStackEquipmentInstance.get(varEquip)).quality
					monitoring[varEquip]=((airStackEquipmentInstance.get(varEquip)).equipment.controlMeasure).toString()+" : "+(airStackEquipmentInstance.get(varEquip)).monitoring
				
					installPoll.add(((airStackEquipmentInstance.get(varEquip)).stack.stack).toString())
					
					installPoll.add(((airStackEquipmentInstance.get(varEquip)).equipment.controlMeasure).toString())
					installPoll.add((airStackEquipmentInstance.get(varEquip)).pollutant)
					installPoll.add((airStackEquipmentInstance.get(varEquip)).state)
					
					installPoll.add((airStackEquipmentInstance.get(varEquip)).installation)
					pollInstall.add(installPoll)
				}
				if(airStackEquipmentInstance){
					nameEquipment[var1]=nameEquipment[var1]+ " ]"
				}
///////////////////////////////////////// Name of Equipment table details ////////////////////// 

	def numberStacks=(airStackDetailsList.size()).toString()
//
				if(airStackEquipmentInstance){
					for(int varEq=0;varEq<airStackEquipmentInstance.size();varEq++)
					{
						def plantEquipment = new ArrayList()
						
						plantEquipment.add(((airStackEquipmentInstance.get(varEq)).stack.stack).toString())
						plantEquipment.add(((airStackEquipmentInstance.get(varEq)).equipment.controlMeasure).toString())
						plantEquipmentDetails.add(plantEquipment)
						
					}
				}
				
				if(airStackEquipmentInstance){
					for(int varEq=0;varEq<airStackEquipmentInstance.size();varEq++)
					{
						def plantQuantity = new ArrayList()
						
						plantQuantity.add(((airStackEquipmentInstance.get(varEq)).stack.stack).toString())
						plantQuantity.add((airStackEquipmentInstance.get(varEq)).quantity)
						plantQuantity.add((airStackEquipmentInstance.get(varEq)).quality)
						
						plantQuantityDetails.add(plantQuantity)
					}
				}
				
				if(airStackEquipmentInstance){
					for(int varEq=0;varEq<airStackEquipmentInstance.size();varEq++)
					{
						def reductionEfficie = new ArrayList()
						
						reductionEfficie.add(((airStackEquipmentInstance.get(varEq)).stack.stack).toString())
						reductionEfficie.add(((airStackEquipmentInstance.get(varEq)).equipment.controlMeasure).toString())
						reductionEfficie.add((airStackEquipmentInstance.get(varEq)).redEfficiency)
						
						reductionEfficieDetails.add(reductionEfficie)
					}
				}
				
				
				
//////////////////////////////////////////////////////////////////////////////////////
			}
			
			def airFlueGasDetailsList=AirFlueGasDetails.findAll("From AirFlueGasDetails afg where afg.stack=? and afg.application=? " ,[firstD,second])
			
			//arrayListStack.add(airStackDetailsList.get(var1))
			//arrayListStack.add(airFlueGasDetailsList)
			
			def space = "/";
			def space1 = ",";
			def space2 = " ";
			
			def testList= new ArrayList()
			def flueList= new ArrayList()
			def fuelConsumpList= new ArrayList()
			testList.add(airStackDetailsList.get(var1).stack)
			testList.add(airStackDetailsList.get(var1).heightGrdLevel)
			testList.add(airStackDetailsList.get(var1).capacity)
			testList.add(airStackDetailsList.get(var1).unit.unitName)
			naturaldraft=naturaldraft+(airStackDetailsList.get(var1).draftType)+" , "
			materialConstruction=materialConstruction+(airStackDetailsList.get(var1).matOfCon)+" , "
			aboveGroundHeight=aboveGroundHeight+(airStackDetailsList.get(var1).heightGrdLevel)+" , "
			aboveFactHeight=aboveFactHeight+(airStackDetailsList.get(var1).heightFacLevel)+" , "
			for(int var2=0;var2<airFlueGasDetailsList.size();var2++)
			{
			flueList.add(airFlueGasDetailsList.get(var2).fuel)
			flueList.add(space);
			flueList.add(airFlueGasDetailsList.get(var2).consumption)
			flueList.add(space2);
			flueList.add(airFlueGasDetailsList.get(var2).unit.unitName)
			flueList.add(space1);
			}

			testList.add(flueList)
//			testList1.add(fuelConsumpList)
			arrayListStack.add(testList)
			
		}
		
		
		def feeDetailsList=FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
		
		String str=null;
		String dateStr=null;
		String rupeeString=null;
		
		for(int var2=0;var2<feeDetailsList.size();var2++)
		{
			def feeDetails= new ArrayList()
			feeDetails.add(feeDetailsList.get(var2).bankName)
			feeDetails.add(feeDetailsList.get(var2).branch)
			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
			feeDetails.add(feeDetailsList.get(var2).date)
			feeDetails.add((feeDetailsList.get(var2).amount).toString())
			
			feeDetails1.add(feeDetails)
		
		}
		
		println("indApplicationDetailsInstance"+indApplicationDetailsInstance)
		  def onlineFee=new ArrayList()
		  def onlineFeeList=BankTransactionDetails.findAll("from BankTransactionDetails bm where bm.indApplication=? and bm.transactionStatus='S'",[indApplicationDetailsInstance])
		    for(int var88=0;var88<onlineFeeList.size();var88++){
		    	def onlineFeeDetails=new ArrayList()
		    	onlineFeeDetails.add((onlineFeeList.get(var88).id).toString())
		    	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		    	String dateCreated1=sdf1.format(onlineFeeList.get(var88).dateCreated);
		    	onlineFeeDetails.add(dateCreated1)
		    	onlineFeeDetails.add((onlineFeeList.get(var88).amount).toString())
		    	onlineFeeDetails.add("Successful")
		    	onlineFee.add(onlineFeeDetails)
		    }
		
//--------------------------------------------Product Details----------------------------------------------
		def productDetailsList = new ArrayList()
		
		def productDetailsInstance=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<productDetailsInstance.size();var10++)
		{
			def productList= new ArrayList()
			
			productList.add(productDetailsInstance.get(var10).product)
			productList.add(productDetailsInstance.get(var10).quantity)
			productList.add(productDetailsInstance.get(var10).unit.unitName)
			productList.add(productDetailsInstance.get(var10).byProduct)
			
			productDetailsList.add(productList)
		}
		
		//---------------------------------------------------------------------------------------------------------

//////////----------------Uploaded Documents----------//////////////////////////////////////////////		
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
  		def listDocuments = new ArrayList()
  		listDocuments.add(listDoc.level)
  	
  		
 ///////////////////////////////////////////////////////////
	
	//-----Ashish-------- 03/01/2011 ---------------------------------------Stack monitoring details----------------------------------------------
		
		
		def airStackEquipmentDetailsInstance=AirStackEquipmentDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var20=0;var20<airStackEquipmentDetailsInstance.size();var20++)
		{
			def plant= new ArrayList()
			
			plant.add(airStackEquipmentDetailsInstance.get(var20).stack.stack)
			plant.add(airStackEquipmentDetailsInstance.get(var20).monitoring)
			
			stackMonitor.add(plant)
		}
		//---------------------------------------------------------------------------------------------------------
	
			
		FormAir form_air=new FormAir()
		println("DFLKFGHDLFGHDFKJGILVJKBXGJKHBLDJFGBDLJ")
		
		certFile=form_air.formAirPdf(generalShift,pollInstall,monitoring,
				quality,quantity,reductionEff,
				nameEquipment,aboveFactHeight,aboveGroundHeight,
				materialConstruction,naturaldraft,licAnnualCap,
				totEmployees,applicationId,dateOfSubmission,
				industryName,industryPlot,industryAddress,industryTehsil,
				industryDistrict,industryTelephone,occupierName,
				occupierDesignation,occupierAddress,occupierTehsil,
				occupierDistrict,occupierTelephone,dtOfCommissioning,
				capitalInvestment,arrayListStack,
				feeDetails1,nameAddressPartners,productDetailsList,
				plantEquipmentDetails,plantQuantityDetails,listDocuments,stackMonitor, reductionEfficieDetails,onlineFee)
		
	
		 byte[] b = new byte[(int) certFile.length()];
        
        FileInputStream fileInputStream = new FileInputStream(certFile);
        fileInputStream.read(b);
 	        
 	        def fileLength=certFile.length()
        	file.size = fileLength / 1024  //f.getSize() 
 	         file.extension ="pdf"//extractExtension( f )
 	       	 file.data=b;
 	       	 file.name="FormAir.pdf"
 	    	 file.description="Certificate Generation Record"
 	    	 file.createdBy=sessionValue
 	    	 file.updatedBy=sessionValue
 	    	 file.typeOfFile="FormAir"
 	    	 println("-----indApplicationDetailsInstance----"+indApplicationDetailsInstance)
 	    	 file.indApplication=indApplicationDetailsInstance
 	    	
 	       if(!file.hasErrors() && file.save(flush:true)) {
 	    	   println("----------Air file saved------"+file)
 	    	   if(certFile){
 	    		   println("-----certFile------"+certFile)
 	    	  
 	    	   }
 	    	   } else {
 	    	   
 	         
 	       }
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	public void formWaterPdf(Long appId,String sessionValue)
	{
		try{
		File certFile
		ApplicationFileRecord file=new ApplicationFileRecord()
		
		def applicationId=appId.toString()
		def feeDetails1= new ArrayList()
		
		def wetherTreatMent
		
		def rawMaterialUsedList= new ArrayList()
		
		def waterUsesDetailsList= new ArrayList()
		def waterSourceDetailsList= new ArrayList()
		def waterModeUseDetailList= new ArrayList()
		
		def wasteWaterGenerationDetailsFinalList= new ArrayList()
		def wasteWaterGenerationDetailsFinalList1= new ArrayList()
		def waterSolidWasteGenDetailsInstanceFinalList= new ArrayList()
		def indExpenditureCostDetailsInstanceFinalList = new ArrayList()
		def plantEquipmentDetails= new ArrayList()
      
		String rawMaterialString="";
		
		String monitoringString="";
		
		def productDetailsList = new ArrayList()
		
		String deli = "";
		
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		
		def applicationIdwater=appId.toString()
		
		def abcF=indApplicationDetailsInstance.applicationDate
		DateCustom dd=new DateCustom()
				if(abcF.getClass().getName()=="java.sql.Date")
				{
					indApplicationDetailsInstance.applicationDate=abcF
				}
				else
				{
					def xyz= dd.toDate(abcF)
					indApplicationDetailsInstance.applicationDate=xyz
				}
		def dateOfSubmission=(indApplicationDetailsInstance.applicationDate).toString()
		
		
		
		
		def industryName=indApplicationDetailsInstance.indUser.indName
		def industryPlot=indApplicationDetailsInstance.indUser.plotNo
		def industryAddress=indApplicationDetailsInstance.indUser.indAddress
		def industryCity=indApplicationDetailsInstance.indUser.indCity
		def industryTehsil=indApplicationDetailsInstance.indUser.tehsil.tehsilName
		def industryDistrict=indApplicationDetailsInstance.indUser.district.districtName
		def industryTelephone=indApplicationDetailsInstance.indUser.indPhoneCode+"-"+indApplicationDetailsInstance.indUser.indPhoneNo
		def statusOfApplicant=indApplicationDetailsInstance.indUser.statusOfAppl
		def totalEmployees=indApplicationDetailsInstance.indUser.noOfEmp
		def occCity =indApplicationDetailsInstance.indUser.occCity
		def annualCapacity=indApplicationDetailsInstance.annualProdCap
		def nationality=indApplicationDetailsInstance.indUser.nationality
		def expectedDate=indApplicationDetailsInstance.indUser.expDate
		def expectedNoEmployees=indApplicationDetailsInstance.indUser.expNoEmp
		def waterMonitoring=indApplicationDetailsInstance.indUser.waterMonitoring
		def nameAddressPartners=indApplicationDetailsInstance.indUser.nameAddressPartners
		
	//	def industryId=indApplicationDetailsInstance.indUser.id
	
		
		def occupierName=indApplicationDetailsInstance.indUser.occName
		def occupierDesignation=indApplicationDetailsInstance.indUser.occDesignation
		def occupierAddress=indApplicationDetailsInstance.indUser.occAddress
		def occupierTehsil=indApplicationDetailsInstance.indUser.occTehsil
		def occupierDistrict=indApplicationDetailsInstance.indUser.occDistrict
		def occupierTelephone=indApplicationDetailsInstance.indUser.occPhoneCode+"-"+indApplicationDetailsInstance.indUser.occPhoneNo
		
		def dtOfCommissioning=indApplicationDetailsInstance.indUser.dateOfComm
		
		def registrationNumber=indApplicationDetailsInstance.indUser.indRegNum
		
		def capitalInvestment=(indApplicationDetailsInstance.indUser.indCapInvt).toInteger()
		
		//def newCapitalInvestment=(indApplicationDetailsInstance.indUser.indNewCapInvt).toInteger()
		
		def categoryIndustry=indApplicationDetailsInstance.indUser.category.name
		def industryScale=indApplicationDetailsInstance.indUser.industryScale
		def consentFor=indApplicationDetailsInstance.applicationFor
		def regAuthority=indApplicationDetailsInstance.indUser.regAuthority
		
		def totalCostPoll=indApplicationDetailsInstance.indUser.totalCostPoll
		def regDate=(indApplicationDetailsInstance.indUser.regDate).toString()
		
		def certificateFor=indApplicationDetailsInstance.certificateFor
		if(certificateFor=="new"){
			certificateFor="Fresh"
		}else{
			certificateFor="Renewal"
		}
		println("certificateFor ---"+certificateFor)
		
//		def indCapInvtLand=(indApplicationDetailsInstance.indUser.indCapInvtLand).toInteger()		
//		def indCapInvtBuilding=(indApplicationDetailsInstance.indUser.indCapInvtBuilding).toInteger()
		def nearRiver=indApplicationDetailsInstance.indUser.nearRiver
		def riverName=indApplicationDetailsInstance.indUser.riverName
		def riverDist=indApplicationDetailsInstance.indUser.riverDist
		def disposalSysProv=indApplicationDetailsInstance.indUser.disposalSysProv
		def utilizeSys=indApplicationDetailsInstance.indUser.utilizeSys
		def proposalDetails=indApplicationDetailsInstance.indUser.proposalDetails
		def totalPlotArea=indApplicationDetailsInstance.indUser.totalPlotArea
		def plotArea=indApplicationDetailsInstance.indUser.plotArea
		def builtUpArea=indApplicationDetailsInstance.indUser.builtUpArea
		def commMonth=indApplicationDetailsInstance.indUser.commMonth
		def expNoEmp=indApplicationDetailsInstance.indUser.expNoEmp
		def noOfEmp=indApplicationDetailsInstance.indUser.noOfEmp
		def nearResidCol=indApplicationDetailsInstance.indUser.nearResidCol
		def colPopulation=indApplicationDetailsInstance.indUser.colPopulation
		def colLocation=indApplicationDetailsInstance.indUser.colLocation
		def colDistance=indApplicationDetailsInstance.indUser.colDistance
		def totalProjectCost=indApplicationDetailsInstance.indUser.totalProjectCost
		def pollutionMonitoringCost=indApplicationDetailsInstance.indUser.pollutionMonitoringCost
		def equipWithSepMeters=indApplicationDetailsInstance.indUser.equipWithSepMeters
		def equipDGSet=indApplicationDetailsInstance.indUser.equipDGSet
		def nonHwmProdName=indApplicationDetailsInstance.indUser.nonHwmProdName
		def landArea=indApplicationDetailsInstance.indUser.landArea
		def prodCapacity=indApplicationDetailsInstance.indUser.prodCapacity
		def treePlantDev=indApplicationDetailsInstance.indUser.treePlantDev
		def wasteMinDetail=indApplicationDetailsInstance.indUser.wasteMinDetail
		def underPubHearing=indApplicationDetailsInstance.indUser.underPubHearing
		def monitoring = indApplicationDetailsInstance.indUser.monitoring
		def sewage    = indApplicationDetailsInstance.indUser.sewage
		def sewageState  = indApplicationDetailsInstance.indUser.sewageState
		def treatedEffCapacity  = indApplicationDetailsInstance.indUser.treatedEffCapacity
		def hotelArea = indApplicationDetailsInstance.indUser.hotelArea
		//////////////////////////////////////////////////////////////
		def possibilityOfRecovery=indApplicationDetailsInstance.indUser.possibilityOfRecovery
		def present=indApplicationDetailsInstance.indUser.present
		def presentdetails=indApplicationDetailsInstance.indUser.presentdetails
		def authForList
		if(indApplicationDetailsInstance.hazardeousType=="HWM"){
		
		def hazarDisposalDetailscccc=HazardousWasteGenDetails.find("from HazardousWasteGenDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		println("vvvvvvvvvvvvv....."+hazarDisposalDetailscccc)
		if(hazarDisposalDetailscccc){
		def authForList1=hazarDisposalDetailscccc.authFor
		if(authForList1){
		println("xxxx.....1"+authForList1)
		authForList=authForList1
		}else{
			authForList=''	
		}
		}else{
			authForList=''	
		}
		
		println("xxxx....."+authForList)
		
		}else{
			 authForList=''	
			
		}
		
		//////////////////////////////////////////////////////////////
		Format formatter = new SimpleDateFormat("dd/MM/yyyy")
		def b2= formatter.format(indApplicationDetailsInstance.indUser.regDate) 
		Format formatter1 = new SimpleDateFormat("dd/MM/yyyy");
 
      //parse the string into Date object
      def dateOfSub = formatter1.format(indApplicationDetailsInstance.applicationDate);
		// code for DG Set//////////////Vivek////////////////
		def makeDGset =""
			def modelDGset =""
				def fuel=""
					def stackHeight=""
						def heightOfBuilding=""
						 	def totalHeight=""
				def powerRating =""
					def soundLevel =""
						def locationDg =""
							def loadShedding =""
								def sheddingInfo =""
									def noise =""
										def room =""
											def exhaustGas =""
												def installation =""
													def minVibration =""
														def minLeaks =""
															//def minHeight =""
			
		def DGSetDetailsInstance=DGSetDetails.findByApplication(indApplicationDetailsInstance)
		if(DGSetDetailsInstance)
		{
		
			makeDGset = DGSetDetailsInstance.makeDGset
			modelDGset = DGSetDetailsInstance.modelDGset
			fuel = DGSetDetailsInstance.fuel
			stackHeight = DGSetDetailsInstance.stackHeight			
			heightOfBuilding = DGSetDetailsInstance.heightOfBuilding.toString()			
			totalHeight = DGSetDetailsInstance.totalHeight.toString()			
			powerRating = DGSetDetailsInstance.powerRating
			soundLevel = DGSetDetailsInstance.soundLevel
			locationDg = DGSetDetailsInstance.location
			loadShedding = DGSetDetailsInstance.loadShedding
			sheddingInfo = DGSetDetailsInstance.sheddingInfo
			noise = DGSetDetailsInstance.noise
			room =DGSetDetailsInstance.room
			exhaustGas =  DGSetDetailsInstance.exhaustGas
			installation = DGSetDetailsInstance.installation
			minVibration =  DGSetDetailsInstance.minVibration
			minLeaks =  DGSetDetailsInstance.minLeaks
			//minHeight =  DGSetDetailsInstance.minHeight
	
		}
		///////////////////////////////////////////////////
		//----------------------------------------D.G.Sets----Emission Source Details----------------------------------------------
		
		def dGSetEmissionDetailsInstance=DGSetEmissionDetails.findAllByApplication(indApplicationDetailsInstance)
		def emissionDetailsList = new ArrayList()
		for(int var10=0;var10<dGSetEmissionDetailsInstance.size();var10++)
		{
			def emissionList= new ArrayList()
			
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).source)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).horsePower)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).noLoadRPM)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).fullLoadRPM)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).fuelQuantity)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).capacity)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).buildingHeight)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).stackHeight)
			emissionList.add(dGSetEmissionDetailsInstance.get(var10).totalHeight)
			
					emissionDetailsList.add(emissionList)
		}
		//---------------------------------------------------------------------------------------------------------
		
		//----------------------------------------D.G.Sets----Parameter Details----------------------------------------------
		
		def dGSetParameterDetailsInstance=DGSetParameterDetails.findAllByApplication(indApplicationDetailsInstance)
		def parameterDetailsList = new ArrayList()
		for(int var10=0;var10<dGSetParameterDetailsInstance.size();var10++)
		{
			def parameterList= new ArrayList()
			
			parameterList.add(dGSetParameterDetailsInstance.get(var10).parameters)
			parameterList.add(dGSetParameterDetailsInstance.get(var10).noLoad)
			parameterList.add(dGSetParameterDetailsInstance.get(var10).fullLoad)
		
			
			parameterDetailsList.add(parameterList)
		}
		//---------------------------------------------------------------------------------------------------------
		
		//def HazardousChemicalDetailsInstance=HazardousChemicalDetails.findAll(" from HazardousChemicalDetails apd where apd.application=? ",[indApplicationDetailsInstance])
    	
		    def accident = ""
			def isolatedStorage =  ""
			def compStatus =  ""
			def siteApproval =  ""
			def emergency =  ""
			def isUpdated =  ""
			def importChem =  ""
			def pliAct =  ""
			def hwmGenerating =  ""
			def categoryNo =  ""
			def presentTreatment =  ""
			def area =  ""
			def location =  ""
			def methodology =  ""
				
		def HazardousChemicalDetailsInstance=HazardousChemicalDetails.findByApplication(indApplicationDetailsInstance)
		if(HazardousChemicalDetailsInstance)
		{
		
		accident = HazardousChemicalDetailsInstance.accident
		isolatedStorage = HazardousChemicalDetailsInstance.isolatedStorage
		compStatus = HazardousChemicalDetailsInstance.compStatus
		siteApproval = HazardousChemicalDetailsInstance.siteApproval
		emergency = HazardousChemicalDetailsInstance.emergency
		isUpdated = HazardousChemicalDetailsInstance.isUpdated
		importChem = HazardousChemicalDetailsInstance.importChem
		pliAct = HazardousChemicalDetailsInstance.pliAct
		hwmGenerating =HazardousChemicalDetailsInstance.hwmGenerating
		categoryNo =  HazardousChemicalDetailsInstance.categoryNo
		presentTreatment = HazardousChemicalDetailsInstance.presentTreatment
		area =  HazardousChemicalDetailsInstance.area
		location =  HazardousChemicalDetailsInstance.location
		methodology =  HazardousChemicalDetailsInstance.methodology
	
		}
		
		
				def odorCompounds =  ""
				def facility =  ""
				def quality =  ""
				
					
			def AirMiscDetailsInstance=AirMiscDetails.findByApplication(indApplicationDetailsInstance)
			if(AirMiscDetailsInstance)
			{
			
			odorCompounds = AirMiscDetailsInstance.odorCompounds
			facility = AirMiscDetailsInstance.facility
			quality = AirMiscDetailsInstance.quality
					
			}
			
		
		def rawMaterials=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		if(rawMaterials)
		{
		for(int var5=0;var5<rawMaterials.size();var5++)
		{
			
//			int i = 2;
		
		deli = rawMaterialString == ""? (deli = ""): (deli = ",");
			 rawMaterialString=rawMaterialString+ deli +rawMaterials.get(var5).rawMaterials
			 deli = ",";
		}
		}
		//----------------------------------------------Monitoring details----------------------------------
		def monitoringArrangementDetails=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		if(monitoringArrangementDetails)
		{
		for(int var5=0;var5<monitoringArrangementDetails.size();var5++)
		{
			
//			int i = 2;
		
		deli = monitoringString == ""? (deli = ""): (deli = ",");
		monitoringString=monitoringString+ deli +monitoringArrangementDetails.get(var5).monitoringArrangementDetails
			 deli = ",";
		}
		}
		//--------------------------------------------------------------------------------------------------
		//--------------------------------------------Product Details----------------------------------------------
		
		def productDetailsInstance=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<productDetailsInstance.size();var10++)
		{
			def productList= new ArrayList()
			
			productList.add(productDetailsInstance.get(var10).product)
			productList.add(productDetailsInstance.get(var10).quantity)
			productList.add(productDetailsInstance.get(var10).unit.unitName)
			productList.add(productDetailsInstance.get(var10).byProduct)
			
			productDetailsList.add(productList)
		}
		//---------------------------------------------------------------------------------------------------------
		
		def waterUserDetailInstance=WaterUsesDetails.findAllByApplication(indApplicationDetailsInstance)
		 
		for(int var6=0;var6<waterUserDetailInstance.size();var6++)
		{
			def waterUserDetailList= new ArrayList()
			
			waterUserDetailList.add(waterUserDetailInstance.get(var6).use.useType)
			waterUserDetailList.add(waterUserDetailInstance.get(var6).source.sourceName)//This is source Type
			waterUserDetailList.add(waterUserDetailInstance.get(var6).sourceName)//This is source Name
			waterUserDetailList.add((waterUserDetailInstance.get(var6).quantity).toString())
			
			waterUsesDetailsList.add(waterUserDetailList)
		}
		
		
		def waterSourceDetailInstance=WaterSourceDetails.findAllByApplication(indApplicationDetailsInstance)
		 
		for(int var6=0;var6<waterSourceDetailInstance.size();var6++)
		{
			def waterSourDetailList= new ArrayList()
			
			waterSourDetailList.add(waterSourceDetailInstance.get(var6).source.sourceName)//This is source Type
			waterSourDetailList.add(waterSourceDetailInstance.get(var6).sourceName)//This is source Name
			waterSourDetailList.add((waterSourceDetailInstance.get(var6).quantity).toString())
			
			waterSourceDetailsList.add(waterSourDetailList)
		}
		
		def waterModeDetailInstance=WaterModeUseDetails.findAllByApplication(indApplicationDetailsInstance)
			
		def waterModeQuantity = 0
		def waterModeQuantity1 = waterModeDetailInstance.quantity
		for(int var6=0;var6<waterModeDetailInstance.size();var6++)
		{
			def waterModeDetailList= new ArrayList()
			
			waterModeDetailList.add(waterModeDetailInstance.get(var6).source.sourceName)//This is source Type
			waterModeDetailList.add(waterModeDetailInstance.get(var6).modeUse.modeUsage)//This is source Name
			waterModeDetailList.add((waterModeDetailInstance.get(var6).quantity).toString())
			
			waterModeUseDetailList.add(waterModeDetailList)
			waterModeQuantity =  waterModeQuantity+ (waterModeQuantity1[var6]).toInteger()
		}
		
		
		def wasteWaterGenerationDetailsInstance=WaterWasteGenerationDetails.findAllByApplication(indApplicationDetailsInstance)
			def totaleffluentGenerated = 0
			def totaleffluentGenerated1 = wasteWaterGenerationDetailsInstance.maxGeneration
			for(int var7=0;var7<wasteWaterGenerationDetailsInstance.size();var7++)
			{
				def wasteWaterGenerationDetailsInstanceList= new ArrayList()
			
				wasteWaterGenerationDetailsInstanceList.add(wasteWaterGenerationDetailsInstance.get(var7).typeOfEffluent)
				wasteWaterGenerationDetailsInstanceList.add((wasteWaterGenerationDetailsInstance.get(var7).maxGeneration).toString())
			//	wasteWaterGenerationDetailsInstanceList.add((wasteWaterGenerationDetailsInstance.get(var7).effRecycle).toString())
			//	wasteWaterGenerationDetailsInstanceList.add(wasteWaterGenerationDetailsInstance.get(var7).disposalMode)
			//	wasteWaterGenerationDetailsInstanceList.add((wasteWaterGenerationDetailsInstance.get(var7).effDischarge).toString())
				totaleffluentGenerated =  totaleffluentGenerated+ (totaleffluentGenerated1[var7]).toInteger()
				
				wasteWaterGenerationDetailsFinalList.add(wasteWaterGenerationDetailsInstanceList)
				
			}
		//////////////////////////////////////
		
			def wasteWaterGenerationDetailsInstance1=WaterWasteGenerationDetails.findAllByApplication(indApplicationDetailsInstance)
	
			for(int var7=0;var7<wasteWaterGenerationDetailsInstance1.size();var7++)
			{
				def wasteWaterGenerationDetailsInstanceList1= new ArrayList()
			
				wasteWaterGenerationDetailsInstanceList1.add(wasteWaterGenerationDetailsInstance1.get(var7).typeOfEffluent)
				wasteWaterGenerationDetailsInstanceList1.add((wasteWaterGenerationDetailsInstance1.get(var7).maxGeneration).toString())
				wasteWaterGenerationDetailsInstanceList1.add((wasteWaterGenerationDetailsInstance1.get(var7).effRecycle).toString())
				wasteWaterGenerationDetailsInstanceList1.add(wasteWaterGenerationDetailsInstance1.get(var7).disposalMode)
				wasteWaterGenerationDetailsInstanceList1.add((wasteWaterGenerationDetailsInstance1.get(var7).effDischarge).toString())
				
				wasteWaterGenerationDetailsFinalList1.add(wasteWaterGenerationDetailsInstanceList1)
				
			} 
		//////////////////////////////////////
				
		
		def list = new ArrayList()
		list.add(wasteWaterGenerationDetailsInstance)
		def a = wasteWaterGenerationDetailsInstance.effDischarge
		
		def totalEffDischarge = 0
		for (int j=0;j<wasteWaterGenerationDetailsInstance.size();j++){
		
			totalEffDischarge = totalEffDischarge + (a[j]).toInteger()
			
		}
	 
		
		//////////////////////////////////////////////////
		def waterSolidWasteGenDetailsInstance=WaterSolidWasteGenDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<waterSolidWasteGenDetailsInstance.size();var7++)
			{
				def waterSolidWasteGenDetailsInstanceList= new ArrayList()
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).description)
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).quantQual)
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).meathodCollection)
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).meathodDisposal)
				
				waterSolidWasteGenDetailsInstanceFinalList.add(waterSolidWasteGenDetailsInstanceList)
				
			}
		
		def indExpenditureCostDetailsInstance=IndExpenditureCostDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<indExpenditureCostDetailsInstance.size();var7++)
	{
		def indExpenditureCostDetailsInstanceList= new ArrayList()
		indExpenditureCostDetailsInstanceList.add(indExpenditureCostDetailsInstance.get(var7).expenditureProposed)
		indExpenditureCostDetailsInstanceList.add(indExpenditureCostDetailsInstance.get(var7).capital.toString())
		indExpenditureCostDetailsInstanceList.add(indExpenditureCostDetailsInstance.get(var7).recurring.toString())
			
		indExpenditureCostDetailsInstanceFinalList.add(indExpenditureCostDetailsInstanceList)
		
	}
		
		
		//------------------------------------------Water Treatment Details--------------------------------------------------------------
		
		def treatmentStatus = new ArrayList()
		def treatmentStatusDetailsInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
				for(int var12=0;var12<treatmentStatusDetailsInstance.size();var12++)
			{
				def treatmentStatusDetailsInstanceList= new ArrayList()
				treatmentStatusDetailsInstanceList.add(treatmentStatusDetailsInstance.get(var12).uses)
				treatmentStatusDetailsInstanceList.add(treatmentStatusDetailsInstance.get(var12).treatmentArrangementStatus)
			
				treatmentStatus.add(treatmentStatusDetailsInstanceList)
				
			}
		
		
		def treatmentDetails = new ArrayList()
		def treatmentDetailsInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
				for(int var12=0;var12<treatmentDetailsInstance.size();var12++)
			{
				def treatmentDetailsInstanceList= new ArrayList()
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).uses)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).category.category)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).treatmentUnits)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).capacity)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).investmentInTreatmentUnit)
			
				treatmentDetails.add(treatmentDetailsInstanceList)
				
			}
		
		def treatedEffluent = new ArrayList()
		def treatedEffluentInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
				for(int var12=0;var12<treatedEffluentInstance.size();var12++)
			{
				def treatedEffluentInstanceList= new ArrayList()
				treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).uses)
				treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).treatedEffluentQuality)
				treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).parametersQuantityTreated)
				treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).parametersQuantity)
			
				treatedEffluent.add(treatedEffluentInstanceList)
				
			}

		//-------------------------------------------------------------------------------------------------------------------------------
		
def hazarList = new ArrayList()
def collection =false
def transport = false
def reception =false
def storage = false
def treatment = false
def disposal = false
def hazarInst=HazardousWasteGenDetails.findAllByApplication(indApplicationDetailsInstance)
for(int var20=0;var20<hazarInst.size();var20++)
		{
			
			def hazadousInst= new ArrayList()
			
//			hazadousInst.add(hazarInst.get(var20).authFor)
			if(hazarInst.get(var20).authFor)
			{
				def splt = ((hazarInst.get(var20).authFor).toString()).split(",")
				for(int var202=0;var202<splt.size();var202++)
				{
					hazarList.add(splt[var202])
					if(splt[var202].toLowerCase()=="collection")
					{
						collection=true
					}
					else if(splt[var202].toLowerCase()=="transport")
					{
						transport=true
					}
					else if(splt[var202].toLowerCase()=="reception")
					{
						reception=true
					}
					else if(splt[var202].toLowerCase()=="storage")
					{
						storage=true
					}
					else if(splt[var202].toLowerCase()=="treatment")
					{
						treatment=true
					}
					else if(splt[var202].toLowerCase()=="disposal")
					{
						disposal=true
					}
				}
			}
			 //hazarList.add(hazadousInst)
		}		
		
		
		
		
		
		
		def activity = ""
		/*def hazardousGenDetails = new ArrayList()
//		def hazardousGenDetailsInstance1=HazardousWasteGeneraDetails.findByApplication(indApplicationDetailsInstance)
		def hazardousGenDetailsInstance1=HazardousWasteGeneraDetails.findAll("from HazardousWasteGeneraDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		
		println("ccccccccccc"+hazardousGenDetailsInstance1)
		if(hazardousGenDetailsInstance1)
		{
		activity = hazardousGenDetailsInstance1.authFor
		}
		def hazardousGenDetailsInstance=HazardousWasteGenDetails.findAllByApplication(indApplicationDetailsInstance)
			
		println("vvvvvvvvvvv"+hazardousGenDetailsInstance)
		for(int var12=0;var12<hazardousGenDetailsInstance.size();var12++)
			{
				def hazardousGenDetailsInstanceList= new ArrayList()
				hazardousGenDetailsInstanceList.add(hazardousGenDetailsInstance.get(var12).sourceName.name)
				hazardousGenDetailsInstanceList.add(hazardousGenDetailsInstance.get(var12).categoryName.name)
				hazardousGenDetailsInstanceList.add(hazardousGenDetailsInstance.get(var12).cate)
				hazardousGenDetailsInstanceList.add(hazardousGenDetailsInstance.get(var12).quantity)

				hazardousGenDetails.add(hazardousGenDetailsInstanceList)
				
			}*/
		
	////////////////////////////////////////////////////////////////////////////
	
		def hazardousGenDetails= new ArrayList()
		def hazarDisposalDetails=	HazardousWasteGenDetails.findAll("from HazardousWasteGenDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var12=0;var12<hazarDisposalDetails.size();var12++)
		{
			def hazarDisposalList= new ArrayList()
			hazarDisposalList.add(hazarDisposalDetails.get(var12).sourceName.name)		
			
			hazarDisposalList.add(hazarDisposalDetails.get(var12).categoryName.name)		
			hazarDisposalList.add(hazarDisposalDetails.get(var12).categoryName.category)	
			hazarDisposalList.add(hazarDisposalDetails.get(var12).quantity)	
				
			
			
			hazardousGenDetails.add(hazarDisposalList)
		}
		///////////////////////////////////////////////////////////////////
		def hazardousDisposalDetails1 = new ArrayList()
		
		def hazardousDisposalDetailsInstance1=QuantHaz.findAllByapp8(indApplicationDetailsInstance)
		
		for(int var12=0;var12<hazardousDisposalDetailsInstance1.size();var12++)
			{
				def hazardousDisposalDetailsInstanceList1= new ArrayList()
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).name)
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).nature)
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).category)
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).totalquant)
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).quantTSDF)
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).quantRec)
				hazardousDisposalDetailsInstanceList1.add(hazardousDisposalDetailsInstance1.get(var12).quantPre)

				hazardousDisposalDetails1.add(hazardousDisposalDetailsInstanceList1)
				
			}
		/////////////////////////////////////////////////////////////////////
		def hazardousDisposalDetails = new ArrayList()
		
		def hazardousDisposalDetailsInstance=HazardousWasteStorDisDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<hazardousDisposalDetailsInstance.size();var12++)
			{
				def hazardousDisposalDetailsInstanceList= new ArrayList()
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).hazardName)
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).nature)
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).categoryName)
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).totalQuantity)
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).quantityTSDF)
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).quantityRecycler)
				hazardousDisposalDetailsInstanceList.add(hazardousDisposalDetailsInstance.get(var12).quantityPremises)

				hazardousDisposalDetails.add(hazardousDisposalDetailsInstanceList)
				
			}
		
		def hazardousStorageDetails = new ArrayList()
		
		def hazardousStorageDetailsInstance=HazardousWasteStorDisDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<hazardousStorageDetailsInstance.size();var12++)
			{
				def hazardousStorageDetailsInstanceList= new ArrayList()
				hazardousStorageDetailsInstanceList.add(hazardousStorageDetailsInstance.get(var12).hazardName)
				hazardousStorageDetailsInstanceList.add(hazardousStorageDetailsInstance.get(var12).categoryName)
				hazardousStorageDetailsInstanceList.add(hazardousStorageDetailsInstance.get(var12).roomSize)
				hazardousStorageDetailsInstanceList.add(hazardousStorageDetailsInstance.get(var12).storageCapacity)
			
				hazardousStorageDetails.add(hazardousStorageDetailsInstanceList)
				
			}
		
def hazardousStorageDetails1 = new ArrayList()
		
		def hazardousStorageDetailsInstance1=StoreMode.findAllByapp8(indApplicationDetailsInstance)
		
		for(int var12=0;var12<hazardousStorageDetailsInstance1.size();var12++)
			{
				def hazardousStorageDetailsInstanceList1= new ArrayList()
				hazardousStorageDetailsInstanceList1.add(hazardousStorageDetailsInstance1.get(var12).name)
				hazardousStorageDetailsInstanceList1.add(hazardousStorageDetailsInstance1.get(var12).category)
				hazardousStorageDetailsInstanceList1.add(hazardousStorageDetailsInstance1.get(var12).roomsize)
				hazardousStorageDetailsInstanceList1.add(hazardousStorageDetailsInstance1.get(var12).storage)
			
				hazardousStorageDetails1.add(hazardousStorageDetailsInstanceList1)
				
			}
		
		
		
		
		
		
		
		
		
		
		
		def waterWasteTreatmentInst=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		
		if(waterWasteTreatmentInst)
		{
			wetherTreatMent="yes"
		}
		else
		{
			wetherTreatMent="No"
		}
			
		//---------------Fees---------------------------------------------------
		String feeType="";
		println("indApplicationDetailsInstance"+indApplicationDetailsInstance)
		def feeDetailsList=FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
		println("feeDetailsList----"+feeDetailsList.size())
		if(feeDetailsList.size()>0){
			feeType="Offline"
		}
		for(int var2=0;var2<feeDetailsList.size();var2++)
		{
			def feeDetails= new ArrayList()
			feeDetails.add(feeDetailsList.get(var2).bankName)
			feeDetails.add(feeDetailsList.get(var2).branch)
			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
			feeDetails.add(feeDetailsList.get(var2).date)
			feeDetails.add((feeDetailsList.get(var2).amount).toString())
			
			feeDetails1.add(feeDetails)
		
		}
		//-----------------------------Online Fees---------------------------------
		println("indApplicationDetailsInstance"+indApplicationDetailsInstance)
		  
		  def onlineFeeList22=BankTransactionDetails.findAll("from BankTransactionDetails bm where bm.indApplication=? and bm.transactionStatus='S'",[indApplicationDetailsInstance])
		  if(onlineFeeList22.size()>0){
			  feeType="Online"
		  }
		    for(int var88=0;var88<onlineFeeList22.size();var88++){
		    	def onlineFeeDetails=new ArrayList()
		    	onlineFeeDetails.add((onlineFeeList22.get(var88).id).toString())
		    	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		    	String dateCreated1=sdf1.format(onlineFeeList22.get(var88).dateCreated);
		    	onlineFeeDetails.add(dateCreated1)
		    	onlineFeeDetails.add("Successful")
		    	onlineFeeDetails.add((onlineFeeList22.get(var88).amount).toString())
		    	feeDetails1.add(onlineFeeDetails)
		    }
		
		
		
	
	def airStackDetailsList= AirStackDetails.findAllByApplication(indApplicationDetailsInstance)
		 
	def numberStacks=(airStackDetailsList.size()).toString()
	
		
		def stack = ""
		def capacity=""
		def fuelTyp=""
		def fuelQty=""
		def naturaldraft=""
		def materialConstruction=""
		def shape=""
		def aboveGroundHeight=""
		def aboveFactHeight=""
		def diamSize=""
		def gasQty=""
		def gasTemp=""
		def gasVel=""
		def nameEquipment = new String[airStackDetailsList.size()]
		
				
		for(int var1=0;var1<airStackDetailsList.size();var1++)
		{
				
			def firstD=airStackDetailsList.get(var1)
			
			def airStackEquipmentInstance=AirStackPollutionCntrlDetails.findAllByStack(firstD)	
			
			stack=stack+(airStackDetailsList.get(var1).stack)+" , "
			capacity=capacity+(airStackDetailsList.get(var1).capacity)+" , "
			fuelTyp=fuelTyp+(airStackDetailsList.get(var1).fuelTyp)+" , "
			fuelQty=fuelQty+(airStackDetailsList.get(var1).fuelQty)+" , "
			materialConstruction=materialConstruction+(airStackDetailsList.get(var1).matOfCon)+" , "
			shape=shape+(airStackDetailsList.get(var1).shape)+" , "
			aboveGroundHeight=aboveGroundHeight+(airStackDetailsList.get(var1).heightGrdLevel)+" , "
			aboveFactHeight=aboveFactHeight+(airStackDetailsList.get(var1).heightFacLevel)+" , "
			diamSize=diamSize+(airStackDetailsList.get(var1).diamSize)+" , "
			gasQty=gasQty+(airStackDetailsList.get(var1).gasQty)+" , "
			gasTemp=gasTemp+(airStackDetailsList.get(var1).gasTemp)+" , "
			gasVel=gasVel+(airStackDetailsList.get(var1).gasVel)+" , "
						
			if(airStackEquipmentInstance){
				for(int varEq=0;varEq<airStackEquipmentInstance.size();varEq++)
				{
					def plantEquipment = new ArrayList()
					
					plantEquipment.add(((airStackEquipmentInstance.get(varEq)).stack.stack).toString())
					plantEquipment.add(((airStackEquipmentInstance.get(varEq)).pollutionCntrlMeasure.controlMeasure).toString())
					plantEquipmentDetails.add(plantEquipment)
				}
			}
		}

	
	def airFlueGasEmissionDetails = new ArrayList()
		
		def airFlueGasDetailsList1=AirFlueGasDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<airFlueGasDetailsList1.size();var12++)
			{
				def airFlueGasDetailsInstanceList= new ArrayList()
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).fuel)
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).consumption)
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).unit.unitName)
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).calorValue)
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).ashCon)
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).sulphurCon)
				airFlueGasDetailsInstanceList.add(airFlueGasDetailsList1.get(var12).otherCon)
			
				airFlueGasEmissionDetails.add(airFlueGasDetailsInstanceList)
				
			}
		
//	def SurrDetailsFinalList11= new ArrayList()
//	def industryId=indApplicationDetailsInstance.indUser

//	def surrDetailsInstance11=IndSurrounding.findAllByIndustryReg(industryId)

//	//for(int var7=0;var7<surrDetailsInstance11.size();var7++)
//	//{
//	def surrDetailsInstanceList11= new ArrayList()
//
//	surrDetailsInstanceList11.add(surrDetailsInstance11.get(var7).surrounding.surroundingName)
//	surrDetailsInstanceList11.add(surrDetailsInstance11.get(var7).distance)
//	surrDetailsInstanceList11.add(surrDetailsInstance11.get(var7).description)
//
//	SurrDetailsFinalList11.add(surrDetailsInstanceList11)
//
//	}
//


		def stoneCrusherSittingCriteriaDetail = new ArrayList()
		
		def stoneCrusherSittingCriteriaDetailInstance=StoneCrusherSittingCriteria.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<stoneCrusherSittingCriteriaDetailInstance.size();var12++)
			{
				def stoneCrusherSittingCriteriaDetailInstanceList= new ArrayList()
				stoneCrusherSittingCriteriaDetailInstanceList.add(stoneCrusherSittingCriteriaDetailInstance.get(var12).parameter.parameterName)
				stoneCrusherSittingCriteriaDetailInstanceList.add(stoneCrusherSittingCriteriaDetailInstance.get(var12).distance)
				
				stoneCrusherSittingCriteriaDetail.add(stoneCrusherSittingCriteriaDetailInstanceList)
				
			}
		
		def stoneCrusherControlDevicesDetail = new ArrayList()
		
		def stoneCrusherControlDevicesDetailInstance=StoneCrusherControlDevices.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<stoneCrusherControlDevicesDetailInstance.size();var12++)
			{
				def stoneCrusherControlDevicesDetailInstanceList= new ArrayList()
				stoneCrusherControlDevicesDetailInstanceList.add(stoneCrusherControlDevicesDetailInstance.get(var12).device.deviceName)
				stoneCrusherControlDevicesDetailInstanceList.add(stoneCrusherControlDevicesDetailInstance.get(var12).name)
				stoneCrusherControlDevicesDetailInstanceList.add(stoneCrusherControlDevicesDetailInstance.get(var12).status)
				
				stoneCrusherControlDevicesDetail.add(stoneCrusherControlDevicesDetailInstanceList)
				
			}
		
		def brickKilnsSittingCriteriaDetail = new ArrayList()
		
		def brickKilnsSittingCriteriaDetailInstance=BrickSittingCriteriaDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<brickKilnsSittingCriteriaDetailInstance.size();var12++)
			{
				def brickKilnsSittingCriteriaDetailInstanceList= new ArrayList()
				brickKilnsSittingCriteriaDetailInstanceList.add(brickKilnsSittingCriteriaDetailInstance.get(var12).parameter.parameterName)
				brickKilnsSittingCriteriaDetailInstanceList.add(brickKilnsSittingCriteriaDetailInstance.get(var12).distance)
				
				brickKilnsSittingCriteriaDetail.add(brickKilnsSittingCriteriaDetailInstanceList)
				
			}
		
		
		
		def brickKilnDetailInstance=BrickKilnDetail.findByApplication(indApplicationDetailsInstance)
		def capacity1 = ""
		def trenchSize=""
		def chimeny=""
		def height9=""
		def ecd=""
		def cluster=""
		if(brickKilnDetailInstance)
		{
		
			capacity1 = brickKilnDetailInstance.capacity
			trenchSize = brickKilnDetailInstance.trenchSize
			chimeny = brickKilnDetailInstance.chimeny
			height9 = brickKilnDetailInstance.height
			ecd = brickKilnDetailInstance.ecd
			cluster = brickKilnDetailInstance.cluster
					
		}
		
//		def hotelGeneralDetailsInstance=HotelGeneralDetails.findByApplication(indApplicationDetailsInstance)
//		def hotelNameValue = ""
//		def roomCapacity = ""
//		def restaurantN = ""
//		def capacityN = ""
//		def yearN = ""
//		def investmentN = ""
//		def locationN = ""
//		def distanceN = ""
//		def prevention = ""
//		def relInfo = ""
//		def dgSetN = ""
//		def makeN = ""
//		def dgcapacity = ""
//		if(hotelGeneralDetailsInstance)
//		{
//		
//			hotelNameValue = hotelGeneralDetailsInstance.hotelName
//			roomCapacity = hotelGeneralDetailsInstance.roomCapacity
//			restaurantN = hotelGeneralDetailsInstance.restaurantN
//			capacityN = hotelGeneralDetailsInstance.capacity
//			yearN = hotelGeneralDetailsInstance.year
//			investmentN = hotelGeneralDetailsInstance.investment
//			locationN = hotelGeneralDetailsInstance.location
//			distanceN = hotelGeneralDetailsInstance.distance
//			prevention = hotelGeneralDetailsInstance.prevention
//			relInfo = hotelGeneralDetailsInstance.relInfo
//			dgSetN = hotelGeneralDetailsInstance.dgSet
//			makeN = hotelGeneralDetailsInstance.make
//			dgcapacity = hotelGeneralDetailsInstance.dgcapacity
//					
//		}
//		
//		
//		def hotelWaterConsumptionDetail = new ArrayList()
//		
//		def hotelWaterConsumptionDetailInstance=HotelWaterConsumptionDetail.findAllByApplication(indApplicationDetailsInstance)
//		
//		for(int var12=0;var12<hotelWaterConsumptionDetailInstance.size();var12++)
//			{
//				def hotelWaterConsumptionDetailInstanceList= new ArrayList()
//				hotelWaterConsumptionDetailInstanceList.add(hotelWaterConsumptionDetailInstance.get(var12).type.name)
//				hotelWaterConsumptionDetailInstanceList.add(hotelWaterConsumptionDetailInstance.get(var12).quantity)
//				
//				hotelWaterConsumptionDetail.add(hotelWaterConsumptionDetailInstanceList)
//				
//			}
//		
//		def hotelFacilityDetail = new ArrayList()
//		
//		def hotelFacilityDetailInstance = HotelFacilityDetail.findAll("from HotelFacilityDetail indPow where indPow.type='Hotel' and indPow.application=?",[indApplicationDetailsInstance])
//		
//		for(int var12=0;var12<hotelFacilityDetailInstance.size();var12++)
//			{
//				def hotelFacilityDetailInstanceList= new ArrayList()
//				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).type)
//				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facility.name)
//				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facilityDetail)
//				
//				hotelFacilityDetail.add(hotelFacilityDetailInstanceList)
//				
//			}
//	
//		def hotelFacilityDetailRestaurent = new ArrayList()
//		
//		def hotelFacilityDetailRestaurentInstance = HotelFacilityDetail.findAll("from HotelFacilityDetail indPow where indPow.type='Restaurent' and indPow.application=?",[indApplicationDetailsInstance])
//		
//		for(int var12=0;var12<hotelFacilityDetailRestaurentInstance.size();var12++)
//			{
//				def hotelFacilityDetailRestaurentInstanceList= new ArrayList()
//				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).type)
//				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).facility.name)
//				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).facilityDetail)
//				
//				hotelFacilityDetailRestaurent.add(hotelFacilityDetailRestaurentInstanceList)
//				
//			}
//		
//		def hotelWasteEmissionDetail = new ArrayList()
//		
//		def hotelWasteEmissionDetailInstance=HotelWasteEmissionDetail.findAllByApplication(indApplicationDetailsInstance)
//		
//		for(int var12=0;var12<hotelWasteEmissionDetailInstance.size();var12++)
//			{
//				def hotelWasteEmissionDetailInstanceList= new ArrayList()
//				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).type.name)
//				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).quantity)
//				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).nature)
//				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).tmethod)
//				
//				hotelWasteEmissionDetail.add(hotelWasteEmissionDetailInstanceList)
//				
//			}

		def hotelGeneralDetailsInstance=HotelGeneralDetails.findByApplication(indApplicationDetailsInstance)
		def hotelNameValue = ""
		def roomCapacity = ""
		def restaurantN = ""
		def capacityN = ""
		def yearN = ""
		def investmentN = ""
		def locationN = ""
		def distanceN = ""
		def prevention = ""
		def relInfo = ""
		def dgSetN = ""
		def makeN = ""
		def dgcapacity = ""
		def deptTourism = ""
		def	tourismDetails = ""
		def	septicTank= ""
		def	soakagePit=""
		def	sewagePlant=" "
		def	exhaustFans=" "
		def	greenery=" "
		def	indpendentRestaurant =" "
		def	nocObtained=" "
		def	hotelchimeny=" "
		
		if(hotelGeneralDetailsInstance)
		{
		
			hotelNameValue = hotelGeneralDetailsInstance.hotelName
			roomCapacity = hotelGeneralDetailsInstance.roomCapacity
			restaurantN = hotelGeneralDetailsInstance.restaurantN
			capacityN = hotelGeneralDetailsInstance.capacity
			yearN = hotelGeneralDetailsInstance.year
			investmentN = hotelGeneralDetailsInstance.investment
			locationN = hotelGeneralDetailsInstance.location
			distanceN = hotelGeneralDetailsInstance.distance
			prevention = hotelGeneralDetailsInstance.prevention
			relInfo = hotelGeneralDetailsInstance.relInfo
			dgSetN = hotelGeneralDetailsInstance.dgSet
			makeN = hotelGeneralDetailsInstance.make
			dgcapacity = hotelGeneralDetailsInstance.dgcapacity
			deptTourism = hotelGeneralDetailsInstance.deptTourism
			tourismDetails = hotelGeneralDetailsInstance.tourismDetails
			septicTank = hotelGeneralDetailsInstance.septicTank	
			soakagePit = hotelGeneralDetailsInstance.soakagePit
			sewagePlant = hotelGeneralDetailsInstance.sewagePlant
			hotelchimeny = hotelGeneralDetailsInstance.hotelchimeny
			exhaustFans = hotelGeneralDetailsInstance.exhaustFans
			greenery = hotelGeneralDetailsInstance.greenery
			indpendentRestaurant = hotelGeneralDetailsInstance.indpendentRestaurant
			nocObtained = hotelGeneralDetailsInstance.nocObtained
			
		}
		
		
		def hotelWaterConsumptionDetail = new ArrayList()
		
		def hotelWaterConsumptionDetailInstance=HotelWaterConsumptionDetail.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<hotelWaterConsumptionDetailInstance.size();var12++)
			{
				def hotelWaterConsumptionDetailInstanceList= new ArrayList()
				hotelWaterConsumptionDetailInstanceList.add(hotelWaterConsumptionDetailInstance.get(var12).type.name)
				hotelWaterConsumptionDetailInstanceList.add(hotelWaterConsumptionDetailInstance.get(var12).quantity)
				
				hotelWaterConsumptionDetail.add(hotelWaterConsumptionDetailInstanceList)
				
			}
		
		def hotelFacilityDetail = new ArrayList()
		
		//def hotelFacilityDetailInstance=HotelFacilityDetail.findAllByApplication(indApplicationDetailsInstance)
		
		def hotelFacilityDetailInstance = HotelFacilityDetail.findAll("from HotelFacilityDetail indPow where indPow.hotelFacilityType.typeName='Hotel' and indPow.application=?",[indApplicationDetailsInstance])
				
		
		for(int var12=0;var12<hotelFacilityDetailInstance.size();var12++)
			{
				def hotelFacilityDetailInstanceList= new ArrayList()
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).hotelFacilityType.typeName)
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facility.name)
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).capacity)
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facilityDetail)
				
				hotelFacilityDetail.add(hotelFacilityDetailInstanceList)
				
			}
	
		def hotelFacilityDetailRestaurent = new ArrayList()
		
    	//def hotelFacilityDetailRestaurentInstance=HotelFacilityDetail.findAllByApplication(indApplicationDetailsInstance)
    	
    	def hotelFacilityDetailRestaurentInstance = HotelFacilityDetail.findAll("from HotelFacilityDetail indPow where indPow.hotelFacilityType.typeName='Restaurant' and indPow.application=?",[indApplicationDetailsInstance])
				
		
		for(int var12=0;var12<hotelFacilityDetailRestaurentInstance.size();var12++)
			{
				def hotelFacilityDetailRestaurentInstanceList= new ArrayList()
				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).hotelFacilityType.typeName)
				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).facility.name)
				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).capacity)
				hotelFacilityDetailRestaurentInstanceList.add(hotelFacilityDetailRestaurentInstance.get(var12).facilityDetail)
				
				
				hotelFacilityDetailRestaurent.add(hotelFacilityDetailRestaurentInstanceList)
				
			}
		
		def hotelWasteEmissionDetail = new ArrayList()
		
		def hotelWasteEmissionDetailInstance=HotelWasteEmissionDetail.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<hotelWasteEmissionDetailInstance.size();var12++)
			{
				def hotelWasteEmissionDetailInstanceList= new ArrayList()
				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).type.name)
				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).quantity)
				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).nature)
				hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).tmethod)
				
				hotelWasteEmissionDetail.add(hotelWasteEmissionDetailInstanceList)
				
			}
		

		
		def greenWaterUsesDetail = new ArrayList()
		
		def greenWaterUsageDetailsInstance=WaterUsageDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var12=0;var12<greenWaterUsageDetailsInstance.size();var12++)
			{
				def greenWaterUsageDetailsInstanceList= new ArrayList()
				greenWaterUsageDetailsInstanceList.add(greenWaterUsageDetailsInstance.get(var12).description)
				greenWaterUsageDetailsInstanceList.add(greenWaterUsageDetailsInstance.get(var12).quantQual)
			
				
				greenWaterUsesDetail.add(greenWaterUsageDetailsInstanceList)
				
			}
		
		def wasteDischargeDetail = new ArrayList()

		def wasteDischargeInstance=WaterWasteDischarge.findAllByApplication(indApplicationDetailsInstance)

		for(int var12=0;var12<wasteDischargeInstance.size();var12++)
		{
		def wasteDischargeInstanceList= new ArrayList()
		wasteDischargeInstanceList.add(wasteDischargeInstance.get(var12).description)
		wasteDischargeInstanceList.add(wasteDischargeInstance.get(var12).quantQual)

		wasteDischargeDetail.add(wasteDischargeInstanceList)

		}

		def stoneCrusherWaterReq = new ArrayList()

		def stoneCrusherWaterInstance=StoneCrusherWaterReq.findAllByApplication(indApplicationDetailsInstance)

		for(int var12=0;var12<stoneCrusherWaterInstance.size();var12++)
		{
		def stoneCrusherWaterInstanceList= new ArrayList()
		stoneCrusherWaterInstanceList.add(stoneCrusherWaterInstance.get(var12).sourceOfWaterSupply)
		stoneCrusherWaterInstanceList.add(stoneCrusherWaterInstance.get(var12).quantity)

		stoneCrusherWaterReq.add(stoneCrusherWaterInstanceList)

		}

		def waterConsumptionDetail = new ArrayList()

		def waterConsumptionInstance=WaterConsumptionDetail.findAllByApplication(indApplicationDetailsInstance)

		for(int var12=0;var12<waterConsumptionInstance.size();var12++)
		{
		def waterConsumptionInstanceList= new ArrayList()
		waterConsumptionInstanceList.add(waterConsumptionInstance.get(var12).waterConsumptionType)
		waterConsumptionInstanceList.add(waterConsumptionInstance.get(var12).quantity)
		waterConsumptionInstanceList.add(waterConsumptionInstance.get(var12).storageFacility)

		waterConsumptionDetail.add(waterConsumptionInstanceList)

		}

//		/******************* NOC AUTHORITY DETAILS **********************
  		
  		def nocDetailsList = new ArrayList()
		
		def nocDetailsInstance=NocAuthorityDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<nocDetailsInstance.size();var10++)
		{
			def nocList= new ArrayList()
			
			nocList.add(nocDetailsInstance.get(var10).authorityDetails)
			nocList.add(nocDetailsInstance.get(var10).status)
			nocList.add(nocDetailsInstance.get(var10).number)
			nocList.add(nocDetailsInstance.get(var10).date)
			
			
			nocDetailsList.add(nocList)
		}
		
		/************************** Miscelleneous Details **************************************/
	  		
	  		def controlMeasures = ""
	  		def totalCost=""
	  		def dgStInstalled=""
	  		def dgSetCapacity=""
	  		def AcausticEnclosure=""
	  		def noisePollution=""
	  		def noiseMeasures=""
	  		def presParameters=""
	  		def hazardeousSubs=""
	  		def nameOfHazardeous=""
	  		def quatityOfHazard=""
	  		def isHazarSubstanceProduced=""
	  		def nameOfHazardWaste=""
	  		def quatityOfWaste=""
	  		
	  			def miscelleneousDetailsInstance=MiscellaneousDetails.findByApplication(indApplicationDetailsInstance)
	  			if(miscelleneousDetailsInstance)
	  			{
	  			
	  				controlMeasures=miscelleneousDetailsInstance.controlMeasures
	  				totalCost=miscelleneousDetailsInstance.totalCost
	  				dgStInstalled=miscelleneousDetailsInstance.dgStInstalled
	  				dgSetCapacity=miscelleneousDetailsInstance.dgSetCapacity
	  				AcausticEnclosure=miscelleneousDetailsInstance.AcausticEnclosure
	  				noisePollution=miscelleneousDetailsInstance.noisePollution
	  				noiseMeasures=miscelleneousDetailsInstance.noiseMeasures
	  				presParameters=miscelleneousDetailsInstance.presParameters
	  				hazardeousSubs=miscelleneousDetailsInstance.hazardeousSubs
	   				nameOfHazardeous=miscelleneousDetailsInstance.nameOfHazardeous
	  				quatityOfHazard=miscelleneousDetailsInstance.quatityOfHazard
	  				isHazarSubstanceProduced=miscelleneousDetailsInstance.isHazarSubstanceProduced
	  				nameOfHazardWaste=miscelleneousDetailsInstance.nameOfHazardWaste
	  				quatityOfWaste=miscelleneousDetailsInstance.quatityOfWaste
	  				
	  		
	  			}
	  		
		def boilerDetailsList = new ArrayList()
		
		def boilerDetailsInstance=BoilerDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<boilerDetailsInstance.size();var10++)
		{
			def boilerList= new ArrayList()
			
			boilerList.add(boilerDetailsInstance.get(var10).boilerInstalled)
			boilerList.add(boilerDetailsInstance.get(var10).boilerName)
			boilerList.add(boilerDetailsInstance.get(var10).streamCapacity)
			boilerList.add(boilerDetailsInstance.get(var10).airPollControlDeviceBoiler)				
			boilerList.add(boilerDetailsInstance.get(var10).stackHeight)
			boilerList.add(boilerDetailsInstance.get(var10).samplingPlatform)
			
			boilerDetailsList.add(boilerList)
		}
	  		/********************************* END ****************************************/

	  		///*******************FURNACE DETAILS **********************/
	  		
	  		def furnaceDetailsList = new ArrayList()
			
			def furnaceDetailsInstance=FurnaceDetails.findAllByApplication(indApplicationDetailsInstance)
			
			for(int var10=0;var10<furnaceDetailsInstance.size();var10++)
			{
				def furnaceList= new ArrayList()
				
				furnaceList.add(furnaceDetailsInstance.get(var10).furnaceInstalled)
				furnaceList.add(furnaceDetailsInstance.get(var10).furnaceName)
				furnaceList.add(furnaceDetailsInstance.get(var10).airPollControlDevicefurnace)
				furnaceList.add(furnaceDetailsInstance.get(var10).prescribedParameters)
				furnaceList.add(furnaceDetailsInstance.get(var10).stackHeight)
				furnaceList.add(furnaceDetailsInstance.get(var10).typeOfFuel)
				furnaceList.add(furnaceDetailsInstance.get(var10).quantity)
				furnaceList.add(furnaceDetailsInstance.get(var10).unit)
				furnaceDetailsList.add(furnaceList)
			}
			
	  		
	  		/*******************end****************************************/
	  		
	  		
	  		
	  		///*******************FURNACE DETAILS **********************/
	  		
	  		def HazsubList = new ArrayList()
			
			def HazsubInstance=Hazsub.findAllByApp8(indApplicationDetailsInstance)
			
			for(int var10=0;var10<HazsubInstance.size();var10++)
			{
				def subHazList= new ArrayList()
				
				subHazList.add(HazsubInstance.get(var10).name)
				subHazList.add(HazsubInstance.get(var10).quantity)
				
				HazsubList.add(subHazList)
			}
			
	  		
	  		
	  		
	  		def HazwasteList = new ArrayList()
	  		println("sdfasadf")
			def HazwasteInstance=Hazwaste.findAllByApp8(indApplicationDetailsInstance)
			println("HazwasteInstance"+HazwasteInstance)
			for(int var10=0;var10<HazwasteInstance.size();var10++)
			{
				def wasteHazList= new ArrayList()
				println("wasteHazList"+wasteHazList)
				wasteHazList.add(HazwasteInstance.get(var10).name)
				wasteHazList.add(HazwasteInstance.get(var10).quantity)
				
				HazwasteList.add(wasteHazList)
				
			}
	  		
//////////----------------Uploaded Documents----------//////////////////////////////////////////////		
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
    		def listDocuments = new ArrayList()
    		listDocuments.add(listDoc.level)
    		
   ///////////////////////////////////////////////////////////
		
		FormWater formWaterObj=new FormWater()
		certFile=formWaterObj.formWaterPdf(applicationIdwater,dateOfSub,industryName,industryPlot,industryAddress,industryTehsil,industryDistrict,industryTelephone,occupierName,occupierDesignation,occupierAddress,occupierTehsil,occupierDistrict,occupierTelephone,dtOfCommissioning,registrationNumber,capitalInvestment,categoryIndustry,rawMaterialString,wasteWaterGenerationDetailsFinalList,feeDetails1,nameAddressPartners,productDetailsList,treatmentDetails,treatedEffluent,listDocuments, industryCity, occCity, consentFor, regAuthority, regDate, nearRiver, riverName, riverDist, disposalSysProv,utilizeSys,proposalDetails, plotArea, builtUpArea, commMonth, expNoEmp, noOfEmp, nearResidCol, colPopulation, colLocation, colDistance, totalProjectCost, pollutionMonitoringCost, equipWithSepMeters, equipDGSet, nonHwmProdName, landArea, prodCapacity, accident, isolatedStorage, compStatus, siteApproval, emergency, isUpdated, importChem, pliAct,treePlantDev, wasteMinDetail, underPubHearing, waterSourceDetailsList, waterModeUseDetailList, waterModeQuantity, totaleffluentGenerated, wasteWaterGenerationDetailsFinalList1, indExpenditureCostDetailsInstanceFinalList,hazardousStorageDetails,activity,hazardousGenDetails, hwmGenerating, categoryNo ,presentTreatment ,area	,location, methodology, numberStacks, stack, capacity,fuelTyp,fuelQty,naturaldraft,materialConstruction,shape,aboveGroundHeight,aboveFactHeight, diamSize, gasQty, gasTemp, gasVel,  plantEquipmentDetails, monitoring, odorCompounds, facility, quality, sewage, sewageState, treatedEffCapacity, airFlueGasEmissionDetails,  totalPlotArea, stoneCrusherSittingCriteriaDetail, stoneCrusherControlDevicesDetail, brickKilnsSittingCriteriaDetail, hotelArea, capacity1 , trenchSize, chimeny, height9, ecd, cluster,	makeDGset , modelDGset , powerRating ,	soundLevel , locationDg ,	loadShedding ,	sheddingInfo ,	noise ,	room ,	exhaustGas , installation , minVibration , minLeaks ,	emissionDetailsList, parameterDetailsList, industryScale,hotelNameValue , roomCapacity , restaurantN , capacityN , yearN , investmentN , locationN , distanceN , prevention , relInfo , dgSetN , makeN , dgcapacity,hotelWaterConsumptionDetail,hotelFacilityDetail,hotelFacilityDetailRestaurent,hotelWasteEmissionDetail, greenWaterUsesDetail, wasteDischargeDetail,stoneCrusherWaterReq, waterConsumptionDetail, nocDetailsList,fuel,stackHeight,heightOfBuilding,totalHeight, dgStInstalled, dgSetCapacity, AcausticEnclosure, boilerDetailsList, furnaceDetailsList, noisePollution,	noiseMeasures,	presParameters, totalCost, controlMeasures ,deptTourism,tourismDetails,septicTank,soakagePit,sewagePlant,hotelchimeny,exhaustFans,
				greenery,indpendentRestaurant,nocObtained,b2,possibilityOfRecovery,authForList,hazardousStorageDetails1,present,presentdetails,hazardousDisposalDetails1,HazsubList,HazwasteList,totalCostPoll,waterSolidWasteGenDetailsInstanceFinalList,feeType,certificateFor)
		
		
		 byte[] b = new byte[(int) certFile.length()];
        
        FileInputStream fileInputStream = new FileInputStream(certFile);
        fileInputStream.read(b);
 	        
 	        def fileLength=certFile.length()
        	file.size = fileLength / 1024  //f.getSize() 
 	         file.extension ="pdf"//extractExtension( f )
 	       	 file.data=b;
 	       	 file.name="FormWater.pdf"
 	    	 file.description="Certificate Generation Record"
 	    	 file.createdBy=sessionValue
 	    	 file.updatedBy=sessionValue
 	    	 file.typeOfFile="FormWater"
 	    	 println("--------indApplicationDetailsInstance----"+indApplicationDetailsInstance)
 	    	 file.indApplication=indApplicationDetailsInstance
 	    	 if(!file.hasErrors() && file.save(flush:true)) {
 	    		 println("-----water file saved---")
 	    	  if(certFile){
 	    		 
 	    	   }
 	    	   } else {
 	    	   
 	         
 	       }
	}catch(Exception e){
		e.printStackTrace();
	}
}
	
	
	
	def public void whiteIntimationPdf(Long appId){
		println("appId : "+appId)
		def whiteCateInt = WhiteCategoryIntegration.get(appId)
		def indUser = IndUser.findByIndustryRegMaster(whiteCateInt.indUser)
		def arrRawMaterialsUsedTemp = new ArrayList();
		def arrOfProductTemp = new ArrayList();
		def arrOfSourceofwaterTemp = new ArrayList();
		def arrOfWaterConsumptionDetailsTemp = new ArrayList();
		def arrOfDomesticwasteWaterTemp = new ArrayList();
		def arrOfDGSetDetailsTemp = new ArrayList();

		def whiteCatRawMaterialDetails = "" //WhiteCatRawMaterialDetails.findAll("from WhiteCatRawMaterialDetails where whiteCatIntegn=?", [whiteCateInt])
		println("whiteCatRawMaterialDetails: "+whiteCatRawMaterialDetails)
		def arrRawMaterialsUsed
		/*if(whiteCatRawMaterialDetails){
			for (int i = 0; i < whiteCatRawMaterialDetails.size(); i++) {
				arrRawMaterialsUsedTemp.add(whiteCatRawMaterialDetails.rawMaterialName[i])
				arrRawMaterialsUsedTemp.add(whiteCatRawMaterialDetails.quantity[i])
				arrRawMaterialsUsedTemp.add((whiteCatRawMaterialDetails.unit[i]).toString())
			}
			arrRawMaterialsUsed = arrRawMaterialsUsedTemp as String[]
		}else{
			arrRawMaterialsUsed = ["--","--","--"] as String[]
		}*/

		//----------------------------------------------------------------
		def whiteProductDetails = ""//WhiteProductDetails.findAll("from WhiteProductDetails where whiteCatIntegn=?", [whiteCateInt])
		def arrOfProduct
		/*if(whiteProductDetails) {
			for (int i = 0; i < whiteProductDetails.size(); i++) {
				arrOfProductTemp.add(whiteProductDetails.productName[i])
				arrOfProductTemp.add(whiteProductDetails.capacity[i])
				arrOfProductTemp.add((whiteProductDetails.unit[i]).toString())
			}
			arrOfProduct = arrOfProductTemp as String[]
		}else{
			arrOfProduct = ["--","--","--"] as String[]
		}*/
		//--------------------------------------------------

		def whiteSourceOfWater = ""//WhiteSourceOfWater.findAll("from WhiteSourceOfWater where whiteCatIntegn=?", [whiteCateInt])

		def arrOfSourceofwater
		/*if(whiteSourceOfWater) {
			for (int i = 0; i < whiteSourceOfWater.size(); i++) {
				arrOfSourceofwaterTemp.add(whiteSourceOfWater.sourceType[i])
				arrOfSourceofwaterTemp.add(whiteSourceOfWater.noOfSource[i])
				arrOfSourceofwaterTemp.add(whiteSourceOfWater.quantity[i])
			}
			arrOfSourceofwater = arrOfSourceofwaterTemp as String[]
		}else{
			arrOfSourceofwater = ["--","--","--"] as String[]
		}*/
		//--------------------------------------------------


		def whiteWaterConsumptionDetails = "" //WhiteWaterConsumptionDetails.findAll("from WhiteWaterConsumptionDetails where whiteCatIntegn=?", [whiteCateInt])
		def arrOfWaterConsumptionDetails
	/*	if(whiteWaterConsumptionDetails) {
			for (int i = 0; i < whiteWaterConsumptionDetails.size(); i++) {
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.industrialPurpose[i])
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.coolingPurpose[i])
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.domesticPurpose[i])
				arrOfWaterConsumptionDetailsTemp.add(whiteWaterConsumptionDetails.total[i])
			}
			arrOfWaterConsumptionDetails = arrOfWaterConsumptionDetailsTemp as String[]
		}else{
			arrOfWaterConsumptionDetails =["--","--","--","--"] as String[]
		}*/
		//--------------------------------------------------


		def whiteDomesticWasteWater = ""//WhiteDomesticWasteWater.findAll("from WhiteDomesticWasteWater where whiteCatIntegn=?", [whiteCateInt])
		def arrOfDomesticwasteWater
		/*if(whiteDomesticWasteWater) {
			for (int i = 0; i < whiteWaterConsumptionDetails.size(); i++) {
				arrOfDomesticwasteWaterTemp.add(whiteDomesticWasteWater.quantityGenerated[i])
				arrOfDomesticwasteWaterTemp.add(whiteDomesticWasteWater.quantityDisposedInToSewer[i])
				arrOfDomesticwasteWaterTemp.add(whiteDomesticWasteWater.duantityDisposedOnToLand[i])
			}
			arrOfDomesticwasteWater = arrOfDomesticwasteWaterTemp as String[]
		}else{
			arrOfDomesticwasteWater =["--","--","--"]as String[];
		}*/
		//--------------------------------------------------
		def whiteDGSetDetails = "" //WhiteDGSetDetails.findAll("from WhiteDGSetDetails where whiteCatIntegn=?", [whiteCateInt])
		def arrOfDGSetDetails
		/*if(whiteDGSetDetails) {
			for (int i = 0; i < whiteDGSetDetails.size(); i++) {
				arrOfDGSetDetailsTemp.add(whiteDGSetDetails.kva[i])
				arrOfDGSetDetailsTemp.add(whiteDGSetDetails.stackAtAbove[i])
				arrOfDGSetDetailsTemp.add(whiteDGSetDetails.cnopy_y_n[i])
			}
			arrOfDGSetDetails = arrOfDGSetDetailsTemp as String[]
		}else{
			arrOfDGSetDetails =["--","--","--"] as String[];
		}*/
		//--------------------------------------------------
		String[] arrOfUndertaking = ["1.   That there is / will be no trade effluent generation and discharge from the aforementioned Industry / Unit / Establishment and not required to install ETP / Waste Water Treatment system.",
									 "2.   That the Industry/ Unit/ Establishment does not/ will not possess any boiler, furnace  and does not/ will not carry any activity leading to the change of the White categorization of aforementioned Industry/ Unit/ Establishment.",
									 "3.   (i) That proposed / installed DG Set is / will be having integral acoustic enclosure/ acoustic treated room to meet the prescribed norms under the Environment (Protection) Rules 1986, as amended to date for Diesel Generation and have /shall provide adequate stack height for the DG Set as per the prescribed norms (ii) That used oil generated from DG set(s)/ units shall be disposed only through the recycler of used oil authorized by State Pollution Control Board/ Central Pollution Control Board. (For DG Sets only).",
									 "4.   That provisions of Water Act, 1974, Air Act, 1981, Environment (Protection) Act 1986 and Rules made there under, as amended to date, shall be complied.",
									 "5.   That in case of any change in the process(es) or activity(ies) leading to change of the categorization of the activities from White Category to some other Category, Application for Consent to Establish &amp; Consent to Operate under the Air and Water Act and other applicable Rules under the Environment (Protection) Act 1986, as amended to date, shall be sought from JKPCC and the activity(ies) shall not be carried out without taking prior Consent from JKPCC. <br> Failure to seek the consent in case of activity does not fall under white category, shall attract action under environmental laws.",
									 "6.   II, hereby verify and declare that what has been stated above is true and correct to the best of my knowledge and nothing has been concealed therefrom. I hold myself liable for perjury, falsehood, misrepresentation and / or omission and / or falsification or act of dishonesty from any fraudulent, fake or tampered documents that have been submitted.",
									 "7.	  That I hereby agree to abide by all the conditions mentioned in the self declaration / certification / undertaking;"
		]

		def sdfh = new SimpleDateFormat("dd/MM/yyyy");
		def sdyear = new SimpleDateFormat("yyyy");
		String appDate = sdfh.format(whiteCateInt.dateOfCreated);
		String appyear = sdyear.format(whiteCateInt.dateOfCreated);
		String upDate = sdfh.format(whiteCateInt.dateOfLastUpdated);
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
		String investmentPlant = ""//whiteCateInt.indUser.indNewCapInvt
		String noOfWorkers = whiteCateInt.noOfWorkers
		String occName = whiteCateInt.indUser.occName
		String indCategory = whiteCateInt.indUser.category
		String indType = whiteCateInt.indUser.industryType
		String indTypeId = whiteCateInt.indUser.industryType.id
		String occAddress = whiteCateInt.indUser.occAddress
		String product = whiteCateInt.product
		String quantity = whiteCateInt.quantity
		def grp=GroupDistrictMaster.find("from GroupDistrictMaster where district=?",[whiteCateInt.indUser.district])
		def groupname = grp.district.districtCode.toString()
		def regionalOffice=grp.group.groupName;
		String autoNumber = "(W/"+groupname+"/"+appyear+"/"+intimationAppId+")";
		println("indType on whiteIntimationPdf ---------"+indType)  
		FormWhiteCategoryIntegration out = new FormWhiteCategoryIntegration();
		try {
			File formOfWhiteCate
			File formOfAcknowledgement
            if(indType!="Establishment and operation of School that does not involve any activity which require Consent/Environmental Clearance"){
            	println("inside not School ")  
			formOfAcknowledgement =out.pdfAcknowledgement(indUserId, intimationAppId, dateOfApply, industryName, indAddress, indCity, indDistrict,
					industryPin, nameAddressPartners, mobile, email, totalInvestment, investmentPlant, noOfWorkers, occName, indCategory, indType, occAddress,
					arrRawMaterialsUsed, arrOfProduct, arrOfSourceofwater, arrOfWaterConsumptionDetails, arrOfDomesticwasteWater, arrOfDGSetDetails, arrOfUndertaking, autoNumber, regionalOffice,indTypeId,upDate,product,quantity);
            }else{
            	println("inside School ")  
            	formOfAcknowledgement =out.pdfAcknowledgementForSchool(indUserId, intimationAppId, dateOfApply, industryName, indAddress, indCity, indDistrict,
    					industryPin, nameAddressPartners, mobile, email, totalInvestment, investmentPlant, noOfWorkers, occName, indCategory, indType, occAddress,
    					arrRawMaterialsUsed, arrOfProduct, arrOfSourceofwater, arrOfWaterConsumptionDetails, arrOfDomesticwasteWater, arrOfDGSetDetails, arrOfUndertaking, autoNumber, regionalOffice,indTypeId,upDate,product,quantity);
              
            }
			byte[] b1 = new byte[(int) formOfAcknowledgement.length()];
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
			file11.createdBy =indUser
			file11.updatedBy =indUser
			file11.typeOfFile = "White AUTO ACKNOWLEDGEMENT"
			file11.lastUpdated = new Date()
			file11.dateCreated = new Date()

			if (file11.save()) {
				println("Data has been Save ACKNOWLEDGEMENT")
			} else {

			}
//===================================================================================================================================================
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
