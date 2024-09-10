import java.util.ArrayList
import java.text.*
public class AutoRenewalFormPdf{

	
	/*public void formAirPdf(Long appId,String sessionValue,Long appNewId)
	{	
		File certFile
		ApplicationFileRecord file=new ApplicationFileRecord()
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		def indApplicationDetailsNewInstance = IndApplicationDetails.get(appNewId)
		def applicationId=appNewId.toString()
		def appliID = (indApplicationDetailsNewInstance.id).toString()
			def feeDetails1= new ArrayList()
		def wetherTreatMent
		
		def rawMaterialUsedList= new ArrayList()
		
		def waterUsesDetailsList= new ArrayList()
		
		def wasteWaterGenerationDetailsFinalList= new ArrayList()
		def wasteWaterGenDetailsFinalList= new ArrayList()
		def wasteWaterGeDetailsFinalList= new ArrayList()
		def waterSolidWasteGenDetailsInstanceFinalList= new ArrayList()
		
		String rawMaterialString="";
		
		String monitoringString="";
		String IntermediateString=""
		String ProcessingChemString=""
		def productDetailsList = new ArrayList()
		def usageDetailsList = new ArrayList()
		
		def materialDetailsList = new ArrayList()
		String deli = "";
		
		def encloseCopy1 = IndFileRecord.find("from IndFileRecord abc where abc.indUser=? ",[indApplicationDetailsInstance.indUser])
		def encloseCopy="No"
		if(encloseCopy)
		{
		encloseCopy	="Yes"
		}
		
		def indMiscelInst =IndAirMiscelineousDetails.findByApp(indApplicationDetailsInstance)
		def waterWasteTreatment =WasteWaterTreatmentDetails.findByApplication(indApplicationDetailsInstance)
		
		
		
		def noiseInst =NoiseDetails.findByApplication(indApplicationDetailsInstance)
		def xyz
		def applicationIdwater=appId.toString()
		
		def abcF=indApplicationDetailsNewInstance.applicationDate
		DateCustom dd=new DateCustom()
		if(abcF.getClass().getName()=="java.sql.Date") {
			indApplicationDetailsNewInstance.applicationDate=abcF
		}
		else {
			if(abcF.getClass().getName()=="java.sql.Timestamp"){
				 xyz= dd.toDate(abcF)
				}else{
					 xyz= dd.sQLdate(abcF)
				}
			indApplicationDetailsNewInstance.applicationDate=xyz
		}
	
		def b3=(indApplicationDetailsNewInstance.applicationDate)
	
		Format formatter1 = new SimpleDateFormat("dd/MM/yyyy")
		def dateOfSubmission= formatter1.format(b3)       
		
		def manfPro=indApplicationDetailsInstance.manfPro
		def industryName=indApplicationDetailsInstance.indUser.indName
		def indScale=indApplicationDetailsInstance.indUser.indScale
		def industryPlot=indApplicationDetailsInstance.indUser.plotNo
		def industryAddress=indApplicationDetailsInstance.indUser.indAddress
		def industryTehsil=indApplicationDetailsInstance.indUser.tehsil.tehsilName
		def industryDistrict=indApplicationDetailsInstance.indUser.district.districtName
		def industryTelephone=indApplicationDetailsInstance.indUser.indPhoneCode+"-"+indApplicationDetailsInstance.indUser.indPhoneNo
		def statusOfApplicant=indApplicationDetailsInstance.indUser.statusOfAppl
		def totalEmployees=indApplicationDetailsInstance.indUser.noOfPersonResiding
		def annualCapacity=indApplicationDetailsInstance.annualProdCap
		def nationality=indApplicationDetailsInstance.indUser.nationality
		def expectedDate=indApplicationDetailsInstance.indUser.expDate
		def applicationName = indApplicationDetailsInstance.appNo
		def expectedNoEmployees=indApplicationDetailsInstance.indUser.expNoEmp
		def waterMonitoring=indApplicationDetailsInstance.indUser.waterMonitoring
		def nameAddressPartners=indApplicationDetailsInstance.indUser.nameAddressPartners
		def khataNo=indApplicationDetailsInstance.indUser.khataNo
		def postOffice = indApplicationDetailsInstance.indUser.pooffice
		def khesraNo = indApplicationDetailsInstance.indUser.khesraNo
		def proMonArr = indApplicationDetailsInstance.proMonArr
		def stormWater = indApplicationDetailsInstance.stormWater
		def icompositionEffluent = indApplicationDetailsInstance.compositionEffluent
		def authSign  = indApplicationDetailsInstance.indUser.authSign
		def bedCapacity  = indApplicationDetailsInstance.indUser.bedCapacity
		def indFaxNo  = indApplicationDetailsInstance.indUser.indFaxNo
		def indPin  = indApplicationDetailsInstance.indUser.indPin
		def occupierName=indApplicationDetailsInstance.indUser.occName
		def occupierDesignation=indApplicationDetailsInstance.indUser.occDesignation
		def occupierAddress=indApplicationDetailsInstance.indUser.occAddress
		def occupierTehsil=indApplicationDetailsInstance.indUser.occTehsil
		def occupierDistrict=indApplicationDetailsInstance.indUser.occDistrict
		def statusOfAppl=indApplicationDetailsInstance.indUser.statusOfAppl
		def indCity=indApplicationDetailsInstance.indUser.indCity
		def occupierTelephone=indApplicationDetailsInstance.indUser.occPhoneCode+"-"+indApplicationDetailsInstance.indUser.occPhoneNo
		def occMobile=indApplicationDetailsInstance.indUser.occMobile
		def dateOfComm=indApplicationDetailsInstance.indUser.dateOfComm
		def monOfComm=indApplicationDetailsInstance.indUser.monOfComm
		def expdateOfComm=indApplicationDetailsInstance.indUser.expdateOfComm
		def expmonOfComm=indApplicationDetailsInstance.indUser.expmonOfComm
		def registrationNumber=indApplicationDetailsInstance.indUser.indRegNum
		def capitalInvestment=(indApplicationDetailsInstance.indUser.indCapInvt).toString()
		def newCapitalInvestment=(indApplicationDetailsInstance.indUser.indNewCapInvt).toString()
		def categoryIndustry=indApplicationDetailsInstance.indUser.category.name
		def applicationType=indApplicationDetailsInstance.applicationType
		def indRegAdd=indApplicationDetailsInstance.indUser.indRegAdd
		def plotNo=indApplicationDetailsInstance.indUser.plotNo
		def corporation=indApplicationDetailsInstance.indUser.corporation
		def villPanchayat=indApplicationDetailsInstance.indUser.villPanchayat
		def cantonment=indApplicationDetailsInstance.indUser.cantonment
		def defenceDep=indApplicationDetailsInstance.indUser.defenceDep
		def portTrust=indApplicationDetailsInstance.indUser.portTrust
		def stateGovt=indApplicationDetailsInstance.indUser.stateGovt
		def prohibitedArea=indApplicationDetailsInstance.indUser.prohibitedArea
		def others=indApplicationDetailsInstance.indUser.others
		def regDate=indApplicationDetailsInstance.indUser.regDate
		
		
		
		def indTypeOther=indApplicationDetailsInstance.indUser.indTypeOther
		def type=indApplicationDetailsInstance.indUser.type	
		println("FormPdf---formAir--type------"+type)
		def waterDrains=indApplicationDetailsInstance.indUser.waterDrains
		def domestic=indApplicationDetailsInstance.indUser.domestic
		def available=indApplicationDetailsInstance.indUser.available
		
		
		//////////////////
		def land=indApplicationDetailsInstance.indUser.land
		def topography=indApplicationDetailsInstance.indUser.topography	
		def windDir=indApplicationDetailsInstance.indUser.windDir
		def speed=indApplicationDetailsInstance.indUser.speed
		def rainfall=indApplicationDetailsInstance.indUser.rainfall
		def aForPlant=indApplicationDetailsInstance.indUser.aForPlant
		def aForInfra=indApplicationDetailsInstance.indUser.aForInfra	
		def aForEffl=indApplicationDetailsInstance.indUser.aForEffl
		def north=indApplicationDetailsInstance.indUser.north
		def south=indApplicationDetailsInstance.indUser.south
		def east=indApplicationDetailsInstance.indUser.east
		def west=indApplicationDetailsInstance.indUser.west	
		def buildcaptive=indApplicationDetailsInstance.indUser.buildcaptive
		def disCap=indApplicationDetailsInstance.indUser.disCap
		def dweller=indApplicationDetailsInstance.indUser.dweller
		def indEmail = indApplicationDetailsInstance.indUser.indEmail
		def monitoring=indApplicationDetailsInstance.indUser.monitoring	
		def monitoring1=indApplicationDetailsInstance.indUser.monitoring1	
		
		def expanCost = indApplicationDetailsInstance.expansionCost
		println("expanCost:--"+expanCost);
		
		def indUserInst = IndUser.find("from IndUser where industryRegMaster=?",indApplicationDetailsInstance.indUser)
		def industryUserID = indUserInst.id
		def applicationNo = indApplicationDetailsNewInstance.id
		
		println("industryUserID---"+industryUserID)
		println("applicationNo---"+applicationNo)
		def totalInvestment=""
		def year=""
		def estimatedExp=""
		def timeReq=""
		def operAndMantainCost=""
		def actionTaken=""
		
		def soundLevel=""
		def abatement1=""
		def abatement2=""
		def sourceType=""
		def name=""
		
		def renewDateFrom = indApplicationDetailsInstance.renewDateFrom
		def renewDateTo = indApplicationDetailsInstance.renewDateTo
		
		if(indMiscelInst){
			totalInvestment=indMiscelInst.totalInvestment
			
			year=indMiscelInst.year
			estimatedExp=indMiscelInst.estimatedExp
			timeReq=indMiscelInst.timeReq
			
			operAndMantainCost=indMiscelInst.operAndMantainCost
			
			
			actionTaken=indMiscelInst.actionTaken
			
		}
		
		def a1=""
		def a2=""
		if(noiseInst){
			soundLevel=noiseInst.soundLevel
			abatement1=noiseInst.abatement1
			abatement2=noiseInst.abatement2
			sourceType=noiseInst.sourceType
			if(sourceType=="Odour"){
				 a1 = sourceType
			 
					
			}else if(sourceType=="Thermal Pollution"){
				 a2 = sourceType
			}
			
		
			name=noiseInst.name
		
		}
		
		
		def treatmentArrangementStatus=""
		def category=""
		if(waterWasteTreatment){
			treatmentArrangementStatus=waterWasteTreatment.treatmentArrangementStatus
			category=waterWasteTreatment.category.category
			
		}
		
	    Format formatter = new SimpleDateFormat("dd/MM/yyyy")
		def b2=  indApplicationDetailsInstance.indUser.regDate       
		
		
		//----------------------------------------------Monitoring details----------------------------------
		
		//--------------------------------------------------------------------------------------------------
		
			//----------------------------------------------InterMediateProduct details----------------------------------
	
		//--------------------------------------------------------------------------------------------------
			//----------------------------------------------Processing Chemical details----------------------------------
		def ProcessingChemical=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
	
		//--------------------------------------------------------------------------------------------------
		
			
			
		
		
		
		
		
		
		def AirStackListFinal= new ArrayList()
		def AirStackInstance=AirStackDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<AirStackInstance.size();var10++) {
			def AirStackList= new ArrayList()
		
			
			//productList.add(var10.toString())
			AirStackList.add(var10.toString())
			AirStackList.add(AirStackInstance.get(var10).stack)
			AirStackList.add(AirStackInstance.get(var10).heightGrdLevel)
			AirStackList.add(AirStackInstance.get(var10).heightFacLevel)
				AirStackList.add(AirStackInstance.get(var10).matOfCon)
				
					
			//productList.add(productDetailsInstance.get(var10).intermediateProd)
			
			
			AirStackListFinal.add(AirStackList)
		
		
		}
		
		
		
		
		
		
		
		
		
		//--------------------------------------------Usage Details----------------------------------------------
		
		def UsageInstance=WaterUsesDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<UsageInstance.size();var10++) {
			def UsageList= new ArrayList()
		
			
			//productList.add(var10.toString())
			UsageList.add(UsageInstance.get(var10).use.useType)
			UsageList.add(UsageInstance.get(var10).quantity.toString())
				
			//productList.add(productDetailsInstance.get(var10).intermediateProd)
			
			
			usageDetailsList.add(UsageList)
		
		
		}
		//---------------------------------------------------------------------------------------------------------
		
		def airStackDetailsList= AirStackDetails.findAllByApplication(indApplicationDetailsInstance)

def numberStacks=(airStackDetailsList.size()).toString()

def stack = ""
def materialConstruction=""
def aboveGroundHeight=""
def aboveFactHeight=""
def no = ""

for(int var1=0;var1<airStackDetailsList.size();var1++)
{

no = airStackDetailsList.size().toString()
stack=stack+(airStackDetailsList.get(var1).stack)+" , "
materialConstruction=materialConstruction+(airStackDetailsList.get(var1).matOfCon)+" , "
aboveGroundHeight=aboveGroundHeight+(airStackDetailsList.get(var1).heightGrdLevel)+" , "
aboveFactHeight=aboveFactHeight+(airStackDetailsList.get(var1).heightFacLevel)+" , "



}
		
		
		
		//--------------------------------------------Product Details----------------------------------------------
		
		def productDetailsInstance=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<productDetailsInstance.size();var10++) {
			def productList= new ArrayList()
		   productList.add(productDetailsInstance.get(var10).product)
			productList.add(productDetailsInstance.get(var10).quantity)			
			productList.add(productDetailsInstance.get(var10).unit.unitName)		
			productList.add(productDetailsInstance.get(var10).intermediateProd)
			productList.add(productDetailsInstance.get(var10).principalUse)
			productDetailsList.add(productList)
		}
	
		//==== by Product Details List ====
		def productdetailsBy=ProductdetailsBy.findAllByApplication(indApplicationDetailsInstance)
		ArrayList productdetailsByFinal=new ArrayList()
		for(int var10=0;var10<productdetailsBy.size();var10++) {
			def productList= new ArrayList()
		    productList.add(productdetailsBy.get(var10).name)
						
			productList.add(productdetailsBy.get(var10).intalledCap)
			productList.add(productdetailsBy.get(var10).unit)
			productList.add(productdetailsBy.get(var10).avgPro)
			productdetailsByFinal.add(productList)
		}
		//== End By Product Detail List
		
		
		def productDetailssList= new ArrayList()
  	    def productDetailInstance=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<productDetailInstance.size();var10++) {
			def productsList= new ArrayList()
		
			
			//productsList.add(var10.toString())
			productsList.add(productDetailInstance.get(var10).product)
			//productsList.add(productDetailInstance.get(var10).byProduct)
			productsList.add(productDetailInstance.get(var10).quantity)			
			productsList.add(productDetailInstance.get(var10).unit.unitName)		
			//productList.add(productDetailsInstance.get(var10).intermediateProd)
			
			
			productDetailssList.add(productsList)
		}
		

		
		def productDetailsssList= new ArrayList()
		def productDetailInst=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<productDetailInst.size();var10++) {
			def productsList= new ArrayList()
		
			
			
			productsList.add(productDetailInst.get(var10).byProduct)
			
			
			
			productDetailsssList.add(productsList)
		}
		
		
		
		//---------------------------------------raw material details------------------------------------------------------------------
		
		
		def productDetailsList1= new ArrayList()
		def productDetailsInstance1=IndProductDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var10=0;var10<productDetailsInstance1.size();var10++) {
			def productList1= new ArrayList()
		
			
					
			productList1.add(productDetailsInstance1.get(var10).rawMaterials)		
			
			
			
			productDetailsList1.add(productList1)
		}
		
				//--------------------------------------------Material Details----------------------------------------------
		
		def materialDetailsInstance=MaterialDetailAll.findAllByApp(indApplicationDetailsInstance)
		for(int var11=0;var11<materialDetailsInstance.size();var11++) {
			def materialList= new ArrayList()
			materialList.add(materialDetailsInstance.get(var11).material.material)
			materialList.add(materialDetailsInstance.get(var11).materialDetail.materialName)
			materialList.add(materialDetailsInstance.get(var11).weight)
			materialList.add(materialDetailsInstance.get(var11).name)
			materialDetailsList.add(materialList)
		}
		def list = new ArrayList()
		def a //= wasteWaterGenerationDetailsInstance.effDischarge
		def totalEffDischarge = 0
		
		def sourceOfRawMaterial= new ArrayList()
		def sourceOfRawMaterial1=SourceOfRawMaterial.findAllByApplication(indApplicationDetailsInstance)
		for(int var11=0;var11<sourceOfRawMaterial1.size();var11++) {
			def materialList= new ArrayList()
			materialList.add(sourceOfRawMaterial1.get(var11).sourceOfRawMaterials)
			materialList.add(sourceOfRawMaterial1.get(var11).addressPIANO)
			materialList.add(sourceOfRawMaterial1.get(var11).unit)
			sourceOfRawMaterial.add(materialList)
		}
		println("sourceOfRawMaterial----formPDF---"+sourceOfRawMaterial)
		
		
		
		
		def waterSolidWasteGenDetailsInstance=WaterSolidWasteGenDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<waterSolidWasteGenDetailsInstance.size();var7++) {
			def waterSolidWasteGenDetailsInstanceList= new ArrayList()
			
			waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).typeOfWaste)
			waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).description)
			waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).quantQual)
			waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).meathodCollection)
			waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).meathodDisposal)
			
			waterSolidWasteGenDetailsInstanceFinalList.add(waterSolidWasteGenDetailsInstanceList)
			
		}
		
		
		def waterSolidWasteGenDetailInstanceFinalList= new ArrayList()
		def waterSolidWasteGenDetailInstance=WaterSolidWasteGenDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<waterSolidWasteGenDetailInstance.size();var7++) {
			def waterSolidWasteGenDetailInstanceList= new ArrayList()
			
			waterSolidWasteGenDetailInstanceList.add(waterSolidWasteGenDetailInstance.get(var7).typeOfWaste)
			waterSolidWasteGenDetailInstanceList.add(waterSolidWasteGenDetailInstance.get(var7).description)
			waterSolidWasteGenDetailInstanceList.add(waterSolidWasteGenDetailInstance.get(var7).quantQual)
			
			waterSolidWasteGenDetailInstanceFinalList.add(waterSolidWasteGenDetailInstanceList)
			
		}
		
		
		def waterSolidWasteGeDetailInstanceFinalList= new ArrayList()
		def waterSolidWasteGeDetailInstance=WaterSolidWasteGenDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<waterSolidWasteGeDetailInstance.size();var7++) {
			def waterSolidWasteGeDetailInstanceList= new ArrayList()
			
			waterSolidWasteGeDetailInstanceList.add(waterSolidWasteGeDetailInstance.get(var7).typeOfWaste)
			waterSolidWasteGeDetailInstanceList.add(waterSolidWasteGeDetailInstance.get(var7).description)
			//waterSolidWasteGeDetailInstanceList.add(waterSolidWasteGeDetailInstance.get(var7).quantQual)
			
			waterSolidWasteGeDetailInstanceFinalList.add(waterSolidWasteGeDetailInstanceList)
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//------------------------------------------Water Treatment Details--------------------------------------------------------------
		
		def treatmentStatus = new ArrayList()
		def treatmentStatusDetailsInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var12=0;var12<treatmentStatusDetailsInstance.size();var12++) {
			def treatmentStatusDetailsInstanceList= new ArrayList()
			treatmentStatusDetailsInstanceList.add(treatmentStatusDetailsInstance.get(var12).uses)
			treatmentStatusDetailsInstanceList.add(treatmentStatusDetailsInstance.get(var12).treatmentArrangementStatus)
			
			treatmentStatus.add(treatmentStatusDetailsInstanceList)
			
		}
		
		
		def treatmentDetails = new ArrayList()
		def treatmentDetailsInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var12=0;var12<treatmentDetailsInstance.size();var12++) {
			def treatmentDetailsInstanceList= new ArrayList()
			treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).uses)
			treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).category.category)
			treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).treatmentUnits)
			treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).capacity)
			treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).investmentInTreatmentUnit)
			
			treatmentDetails.add(treatmentDetailsInstanceList)
			
		}
		
		def treatmentDetails1 = new ArrayList()
		def treatmentDetailsInstance1=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var12=0;var12<treatmentDetailsInstance1.size();var12++) {
			def treatmentDetailsInstanceList1= new ArrayList()
			treatmentDetailsInstanceList1.add(treatmentDetailsInstance1.get(var12).uses)
			treatmentDetailsInstanceList1.add(treatmentDetailsInstance1.get(var12).treatmentArrangementStatus)
			treatmentDetailsInstanceList1.add(treatmentDetailsInstance1.get(var12).category.category)
			treatmentDetailsInstanceList1.add(treatmentDetailsInstance1.get(var12).treatmentUnits)
			treatmentDetailsInstanceList1.add(treatmentDetailsInstance1.get(var12).capacity)
			treatmentDetailsInstanceList1.add(treatmentDetailsInstance1.get(var12).investmentInTreatmentUnit)
			
			treatmentDetails1.add(treatmentDetailsInstanceList1)
			
		}
		
		
		
		def treatmentDetail = new ArrayList()
		
		
		def waterSourceDetailsList= new ArrayList()
		def waterSourceDetailInstance=WaterSourceDetails.findAllByApplication(indApplicationDetailsInstance)

		for(int var6=0;var6<waterSourceDetailInstance.size();var6++)
		{
		def waterSourDetailList= new ArrayList()

		waterSourDetailList.add(waterSourceDetailInstance.get(var6).type)//This is source Type
		waterSourDetailList.add(waterSourceDetailInstance.get(var6).value1)//This is source Name
		//waterSourDetailList.add((waterSourceDetailInstance.get(var6).quantity).toString())

		waterSourceDetailsList.add(waterSourDetailList)
		}

		
		
		def otherDetailsList= new ArrayList()
		def otherDetailInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)

		for(int var6=0;var6<otherDetailInstance.size();var6++)
		{
		def othersDetailList= new ArrayList()

		othersDetailList.add(otherDetailInstance.get(var6).uses)//This is source Type
		othersDetailList.add(otherDetailInstance.get(var6).alreadyMade)//This is source Name
		othersDetailList.add((otherDetailInstance.get(var6).proposed).toString())

		otherDetailsList.add(othersDetailList)
		}

		
		
		
		
		
		
		
		
		def treatmentDetaill = new ArrayList()
		
		def Airdetail = new ArrayList()
		def AirdetailInstance=AirStackDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var12=0;var12<AirdetailInstance.size();var12++) {
			def AirdetailInstanceList= new ArrayList()
			AirdetailInstanceList.add(AirdetailInstance.get(var12).stack)
		
			Airdetail.add(AirdetailInstanceList)
			
		}
		//////////////////////////
		
		
		def treatedEffluent = new ArrayList()
		def treatedEffluentInstance=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		for(int var12=0;var12<treatedEffluentInstance.size();var12++) {
			def treatedEffluentInstanceList= new ArrayList()
			treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).uses)
//			treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).treatedEffluentQuality)
//			treatedEffluentInstanceList.add(treatedEffluentInstance.get(var12).parametersQuantity)
//			
			treatedEffluent.add(treatedEffluentInstanceList)
			
		}
		
		//-------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		def waterWasteTreatmentInst=WasteWaterTreatmentDetails.findAllByApplication(indApplicationDetailsInstance)
		
		if(waterWasteTreatmentInst) {
			wetherTreatMent="yes"
		}
		else {
			wetherTreatMent="No"
		}
		
		
		
		///////// water rquirments///////////////////////
		def wasteWaterGenerationDetailsFinalList1= new ArrayList()

		
		//////////////////////////////
		def wasteWaterGenerationDetailsFinalList11= new ArrayList()

		
		def SurrDetailsFinalList11= new ArrayList()
		def industryId=indApplicationDetailsInstance.indUser
		println("industryId------------>"+industryId)
		def surrDetailsInstance11=IndSurrounding.findAllByIndustryReg(industryId)
		println("surrDetailsInstance11------------>"+SurrDetailsFinalList11)
		for(int var7=0;var7<surrDetailsInstance11.size();var7++)
		{
		def surrDetailsInstanceList11= new ArrayList()

		surrDetailsInstanceList11.add(surrDetailsInstance11.get(var7).surrounding.surroundingName)
		surrDetailsInstanceList11.add(surrDetailsInstance11.get(var7).distance)
		surrDetailsInstanceList11.add(surrDetailsInstance11.get(var7).description)

		SurrDetailsFinalList11.add(surrDetailsInstanceList11)

		}

		println("SurrDetailsFinalList11------------>"+SurrDetailsFinalList11)
	
		////////////////flue details////////
		def fuelDetail= new ArrayList()

		def fuelDetailInstance=AirFlueGasDetails.findAllByApplication(indApplicationDetailsInstance)
			
					for(int var7=0;var7<fuelDetailInstance.size();var7++)
					{
						def fuelDetailInstanceList= new ArrayList()
					
						fuelDetailInstanceList.add(fuelDetailInstance.get(var7).fuel)
						fuelDetailInstanceList.add(fuelDetailInstance.get(var7).consumption)
						
						fuelDetail.add(fuelDetailInstanceList)
						
					} 
		
		//////////
		
		////////////////Noise details////////
		def noiseDetail= new ArrayList()

		def noiseDetailInstance=NoiseDetails.findAllByApplication(indApplicationDetailsInstance)
			
					for(int var7=0;var7<noiseDetailInstance.size();var7++)
					{
						def noiseDetailInstanceList= new ArrayList()
					
						noiseDetailInstanceList.add(noiseDetailInstance.get(var7).sourceType)
						noiseDetailInstanceList.add(noiseDetailInstance.get(var7).abatement2)
						
						noiseDetail.add(noiseDetailInstanceList)
						
					} 
		
		//////////
		
		//---------------Fees---------------------------------------------------
		def feeDetailsList=FeeBankDetails.findAllByApplication(indApplicationDetailsNewInstance)
		def feeOtherDetailsList1=FeeBankOtherDetails.findAllByApplication(indApplicationDetailsNewInstance)
		 println("feeOtherDetailsList1-----"+feeOtherDetailsList1)
		String draftNo="";
		 String datePay="";
		 float rupeePay=0.0;
		 println("rupeePay-----"+rupeePay)
		 for(int var2=0;var2<feeOtherDetailsList1.size();var2++) {
			 println("rupeePay-----"+rupeePay)
			 println("feeOtherDetailsList1.get(var2).amount-----"+feeOtherDetailsList1.get(var2).amount)
			 rupeePay= rupeePay+feeOtherDetailsList1.get(var2).amount
			 println("rupeePay---after--"+rupeePay)
			    }
		 println("rupeePay---after-final-"+rupeePay)
		    for(int var2=0;var2<feeDetailsList.size();var2++) {
			draftNo=feeDetailsList.get(var2).ddChequeNo
			datePay=feeDetailsList.get(var2).date
			rupeePay= rupeePay+feeDetailsList.get(var2).amount
		    }
		def feeDetails12= new ArrayList()
		def feeDetailsList1=FeeBankDetails.findAllByApplication(indApplicationDetailsNewInstance)
		
		for(int var2=0;var2<feeDetailsList1.size();var2++) {
			def feeDetails11= new ArrayList()
			feeDetails11.add((feeDetailsList1.get(var2).amount).toString())
			feeDetails11.add(feeDetailsList1.get(var2).ddChequeNo)
			feeDetails11.add(feeDetailsList1.get(var2).date)
			feeDetails12.add(feeDetails11)
		}
		//////////----------------Uploaded Documents----------//////////////////////////////////////////////	
		
		
		// for Test Water Add 
		def testWaterAdd= new ArrayList()
		def testWaterAdd1=TestWaterAdd.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var2=0;var2<testWaterAdd1.size();var2++) {
			def testWaterAdd11= new ArrayList()
			testWaterAdd11.add(testWaterAdd1.get(var2).testType)
			testWaterAdd11.add(testWaterAdd1.get(var2).existing)
			testWaterAdd11.add(testWaterAdd1.get(var2).proposed)
			testWaterAdd.add(testWaterAdd11)
		}
      //	 End for Test Water Add 
		
			// for Process of Treatment 
		def processOfTreatment= new ArrayList()
		def processOfTreatment1=ProcessOfTreatment.findAllByApplication(indApplicationDetailsInstance)
		
		    for(int var2=0;var2<processOfTreatment1.size();var2++) {
			def processOfTreatment11= new ArrayList()
			processOfTreatment11.add(processOfTreatment1.get(var2).description)
			processOfTreatment11.add(processOfTreatment1.get(var2).quantity)
			processOfTreatment11.add(processOfTreatment1.get(var2).methodofTreatment)
			processOfTreatment11.add(processOfTreatment1.get(var2).methodofDisposal)
			processOfTreatment.add(processOfTreatment11)
		}
      //	 End for Process of Treatment 
		
		
      
      	// for Water source details 
		def waterSourceDetails= new ArrayList()
		def waterSourceDetails1=WaterSourceDetails.findAllByApplication(indApplicationDetailsInstance)
		
		    for(int var2=0;var2<waterSourceDetails1.size();var2++) {
			def waterSourceDetails11= new ArrayList()
			waterSourceDetails11.add(waterSourceDetails1.get(var2).type)
			waterSourceDetails11.add(waterSourceDetails1.get(var2).value1)
			waterSourceDetails.add(waterSourceDetails11)
		}
      //	 End for Water source details 
		
		 	// for Water Discharge details 
		    def waterWasteDischargeDetails= new ArrayList()
		    def waterWasteDischargeDetails1=WaterWasteDischargeDetails.findAllByApplication(indApplicationDetailsInstance)
		    for(int var2=0;var2<waterWasteDischargeDetails1.size();var2++) {
			def waterWasteDischargeDetails11= new ArrayList()
			waterWasteDischargeDetails11.add(waterWasteDischargeDetails1.get(var2).typeOfEffluent)
			waterWasteDischargeDetails11.add(waterWasteDischargeDetails1.get(var2).quantity)
			waterWasteDischargeDetails.add(waterWasteDischargeDetails11)
		}
      //	 End for Water Discharge details 
		
      
      
      
		 	// for Effluent Treatment & Disposal 
		    def effluentTreatment= new ArrayList()
		    def effluentTreatment1=WaterWasteGenerationDetails.findAllByApplication(indApplicationDetailsInstance)
		    for(int var2=0;var2<effluentTreatment1.size();var2++) {
			def effluentTreatment11= new ArrayList()
			effluentTreatment11.add(effluentTreatment1.get(var2).typeOfEffluent)
			effluentTreatment11.add(effluentTreatment1.get(var2).quantity)
			effluentTreatment.add(effluentTreatment11)
		}
      //	 End forEffluent Treatment & Disposal 
		
      
		
        	// for Waste Water quality parameter 
         	
		    def wasteWaterQualityParameterDetails= new ArrayList()
		    def wasteWaterQualityParameterDetails1=WasteWaterQualityParameterDetails.findAllByApplication(indApplicationDetailsInstance)
		    for(int var2=0;var2<wasteWaterQualityParameterDetails1.size();var2++) {
			def wasteWaterQualityParameterDetails11= new ArrayList()
			wasteWaterQualityParameterDetails11.add(wasteWaterQualityParameterDetails1.get(var2).uses)
			wasteWaterQualityParameterDetails11.add(wasteWaterQualityParameterDetails1.get(var2).qauntity)
			wasteWaterQualityParameterDetails.add(wasteWaterQualityParameterDetails11)
		    }
        //	End Waste Water quality parameter 
		
            def boilerPlantDetails= new ArrayList()
		    def boilerPlantDetails1=InstalledPlantDetails.findAll("from InstalledPlantDetails indAir where indAir.application=? and indAir.equipType='Boilers' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<boilerPlantDetails1.size();var2++) {
			def boilerPlantDetails2= new ArrayList()
			//boilerPlantDetails2.add(boilerPlantDetails1.get(var2).equipType)
			boilerPlantDetails2.add(boilerPlantDetails1.get(var2).equipNo)
			boilerPlantDetails2.add(boilerPlantDetails1.get(var2).equipSubType)
			boilerPlantDetails2.add(boilerPlantDetails1.get(var2).capacity)
			boilerPlantDetails2.add(boilerPlantDetails1.get(var2).fuelType)
			boilerPlantDetails2.add(boilerPlantDetails1.get(var2).fuelConsump)
			boilerPlantDetails.add(boilerPlantDetails2)
		    }
        
        
            def heatersPlantDetails= new ArrayList()
		    def heatersPlantDetails1=InstalledPlantDetails.findAll("from InstalledPlantDetails indAir where indAir.application=? and indAir.equipType='Heaters/Evaporators' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<heatersPlantDetails1.size();var2++) {
			def heatersPlantDetails2= new ArrayList()
			//heatersPlantDetails2.add(heatersPlantDetails1.get(var2).equipType)
			heatersPlantDetails2.add(heatersPlantDetails1.get(var2).equipNo)
			heatersPlantDetails2.add(heatersPlantDetails1.get(var2).equipSubType)
			heatersPlantDetails2.add(heatersPlantDetails1.get(var2).capacity)
			heatersPlantDetails2.add(heatersPlantDetails1.get(var2).fuelType)
			heatersPlantDetails2.add(heatersPlantDetails1.get(var2).fuelConsump)
			heatersPlantDetails.add(heatersPlantDetails2)
		    }
            
            def incineratorPlantDetails= new ArrayList()
		    def incineratorPlantDetails1=InstalledPlantDetails.findAll("from InstalledPlantDetails indAir where indAir.application=? and indAir.equipType='Incinerator' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<incineratorPlantDetails1.size();var2++) {
			def incineratorPlantDetails2= new ArrayList()
			//incineratorPlantDetails2.add(incineratorPlantDetails1.get(var2).equipType)
			incineratorPlantDetails2.add(incineratorPlantDetails1.get(var2).equipNo)
			incineratorPlantDetails2.add(incineratorPlantDetails1.get(var2).equipSubType)
			incineratorPlantDetails2.add(incineratorPlantDetails1.get(var2).capacity)
			incineratorPlantDetails2.add(incineratorPlantDetails1.get(var2).fuelType)
			incineratorPlantDetails2.add(incineratorPlantDetails1.get(var2).fuelConsump)
			incineratorPlantDetails.add(incineratorPlantDetails2)
		    }
            
            
            def dgSetPlantDetails= new ArrayList()
		    def dgSetPlantDetails1=InstalledPlantDetails.findAll("from InstalledPlantDetails indAir where indAir.application=? and indAir.equipType='DG Sets' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<dgSetPlantDetails1.size();var2++) {
			def dgSetPlantDetails2= new ArrayList()
			//dgSetPlantDetails2.add(dgSetPlantDetails1.get(var2).equipType)
			dgSetPlantDetails2.add(dgSetPlantDetails1.get(var2).equipNo)
			dgSetPlantDetails2.add(dgSetPlantDetails1.get(var2).equipSubType)
			dgSetPlantDetails2.add(dgSetPlantDetails1.get(var2).capacity)
			dgSetPlantDetails2.add(dgSetPlantDetails1.get(var2).fuelType)
			dgSetPlantDetails2.add(dgSetPlantDetails1.get(var2).fuelConsump)
			dgSetPlantDetails.add(dgSetPlantDetails2)
		    }
            
            
            def otherPlantDetails= new ArrayList()
		    def othersPlantDetails1=InstalledPlantDetails.findAll("from InstalledPlantDetails indAir where indAir.application=? and indAir.equipType='Others' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<othersPlantDetails1.size();var2++) {
			def othersPlantDetails2= new ArrayList()
			//othersPlantDetails2.add(othersPlantDetails1.get(var2).equipType)
			othersPlantDetails2.add(othersPlantDetails1.get(var2).equipNo)
			othersPlantDetails2.add(othersPlantDetails1.get(var2).equipSubType)
			othersPlantDetails2.add(othersPlantDetails1.get(var2).capacity)
			othersPlantDetails2.add(othersPlantDetails1.get(var2).fuelType)
			othersPlantDetails2.add(othersPlantDetails1.get(var2).fuelConsump)
			otherPlantDetails.add(othersPlantDetails2)
		    }
        
            def emissionRecordDetails= new ArrayList()
		    def emissionRecordDetails1=EmissionRecordDetails.findAll("from EmissionRecordDetails indAir where indAir.application=?  ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<emissionRecordDetails1.size();var2++) {
			def emissionRecordDetails12= new ArrayList()
			emissionRecordDetails12.add(emissionRecordDetails1.get(var2).equipNo)
			emissionRecordDetails12.add(emissionRecordDetails1.get(var2).stackIdent)
			emissionRecordDetails12.add(emissionRecordDetails1.get(var2).concenPoll)
			emissionRecordDetails12.add(emissionRecordDetails1.get(var2).emiRate)
			emissionRecordDetails12.add(emissionRecordDetails1.get(var2).stackHeight)
			emissionRecordDetails.add(emissionRecordDetails12)
		    }
            def emissionProcessDetails= new ArrayList()
		    def emissionProcessDetails1=EmissionProcessDetails.findAll("from EmissionProcessDetails indAir where indAir.application=?  ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<emissionProcessDetails1.size();var2++) {
			def emissionProcessDetails2= new ArrayList()
			emissionProcessDetails2.add(emissionProcessDetails1.get(var2).processName)
			emissionProcessDetails2.add(emissionProcessDetails1.get(var2).emissionRate)
			emissionProcessDetails2.add(emissionProcessDetails1.get(var2).concentrationOfPollution)
			emissionProcessDetails2.add(emissionProcessDetails1.get(var2).heightOfVent)
			emissionProcessDetails.add(emissionProcessDetails2)
		    }
            
            def boilerAirPollutionControlDetails= new ArrayList()
		    def boilerAirPollutionControlDetails1=AirPollutionControlDetails.findAll("from AirPollutionControlDetails indAir where indAir.application=? and indAir.equTypeName='Boilers' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<boilerAirPollutionControlDetails1.size();var2++) {
			def boilerAirPollutionControlDetails2= new ArrayList()
			boilerAirPollutionControlDetails2.add(boilerAirPollutionControlDetails1.get(var2).equType)
			boilerAirPollutionControlDetails2.add(boilerAirPollutionControlDetails1.get(var2).airPollution)
			boilerAirPollutionControlDetails2.add(boilerAirPollutionControlDetails1.get(var2).instaDate)
			boilerAirPollutionControlDetails2.add(boilerAirPollutionControlDetails1.get(var2).efficiency)
			boilerAirPollutionControlDetails2.add(boilerAirPollutionControlDetails1.get(var2).concentrationOfPollution)
			boilerAirPollutionControlDetails.add(boilerAirPollutionControlDetails2)
		    }
        
        
            def heatersAirPollutionControlDetails= new ArrayList()
		    def heatersAirPollutionControlDetails1=AirPollutionControlDetails.findAll("from AirPollutionControlDetails indAir where indAir.application=? and indAir.equTypeName='Heaters/Evaporators' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<heatersAirPollutionControlDetails1.size();var2++) {
			def heatersAirPollutionControlDetails2= new ArrayList()
			heatersAirPollutionControlDetails2.add(heatersAirPollutionControlDetails1.get(var2).equType)
			heatersAirPollutionControlDetails2.add(heatersAirPollutionControlDetails1.get(var2).airPollution)
			heatersAirPollutionControlDetails2.add(heatersAirPollutionControlDetails1.get(var2).instaDate)
			heatersAirPollutionControlDetails2.add(heatersAirPollutionControlDetails1.get(var2).efficiency)
			heatersAirPollutionControlDetails2.add(heatersAirPollutionControlDetails1.get(var2).concentrationOfPollution)
			heatersAirPollutionControlDetails.add(heatersAirPollutionControlDetails2)
		    }
            
            def incineratorAirPollutionControlDetails= new ArrayList()
		    def incineratorAirPollutionControlDetails1=AirPollutionControlDetails.findAll("from AirPollutionControlDetails indAir where indAir.application=? and indAir.equTypeName='Incinerator' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<incineratorAirPollutionControlDetails1.size();var2++) {
			def incineratorAirPollutionControlDetails2= new ArrayList()
			incineratorAirPollutionControlDetails2.add(incineratorAirPollutionControlDetails1.get(var2).equType)
			incineratorAirPollutionControlDetails2.add(incineratorAirPollutionControlDetails1.get(var2).airPollution)
			incineratorAirPollutionControlDetails2.add(incineratorAirPollutionControlDetails1.get(var2).instaDate)
			incineratorAirPollutionControlDetails2.add(incineratorAirPollutionControlDetails1.get(var2).efficiency)
			incineratorAirPollutionControlDetails2.add(incineratorAirPollutionControlDetails1.get(var2).concentrationOfPollution)
			incineratorAirPollutionControlDetails.add(incineratorAirPollutionControlDetails2)
		    }
            
            
            def dgSetAirPollutionControlDetails= new ArrayList()
		    def dgSetAirPollutionControlDetails1=AirPollutionControlDetails.findAll("from AirPollutionControlDetails indAir where indAir.application=? and indAir.equTypeName='DG Sets' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<dgSetAirPollutionControlDetails1.size();var2++) {
			def dgSetAirPollutionControlDetails2= new ArrayList()
			dgSetAirPollutionControlDetails2.add(dgSetAirPollutionControlDetails1.get(var2).equType)
			dgSetAirPollutionControlDetails2.add(dgSetAirPollutionControlDetails1.get(var2).airPollution)
			dgSetAirPollutionControlDetails2.add(dgSetAirPollutionControlDetails1.get(var2).instaDate)
			dgSetAirPollutionControlDetails2.add(dgSetAirPollutionControlDetails1.get(var2).efficiency)
			dgSetAirPollutionControlDetails2.add(dgSetAirPollutionControlDetails1.get(var2).concentrationOfPollution)
			dgSetAirPollutionControlDetails.add(dgSetAirPollutionControlDetails2)
		    }
            
            
            def otherAirPollutionControlDetails= new ArrayList()
		    def othersAirPollutionControlDetails1=AirPollutionControlDetails.findAll("from AirPollutionControlDetails indAir where indAir.application=? and indAir.equTypeName='Others' ",[indApplicationDetailsInstance])
		    for(int var2=0;var2<othersAirPollutionControlDetails1.size();var2++) {
			def othersAirPollutionControlDetails2= new ArrayList()
			othersAirPollutionControlDetails2.add(othersAirPollutionControlDetails1.get(var2).equType)
			othersAirPollutionControlDetails2.add(othersAirPollutionControlDetails1.get(var2).airPollution)
			othersAirPollutionControlDetails2.add(othersAirPollutionControlDetails1.get(var2).instaDate)
			othersAirPollutionControlDetails2.add(othersAirPollutionControlDetails1.get(var2).efficiency)
			othersAirPollutionControlDetails2.add(othersAirPollutionControlDetails1.get(var2).concentrationOfPollution)
			otherAirPollutionControlDetails.add(othersAirPollutionControlDetails2)
		    }
            
            
        //////////----------------Uploaded Documents----------//////////////////////////////////////////////	
		def listDoc= new ArrayList()
		
		def applicationDocumentInstance=ApplicationDocuments.findAll(" from ApplicationDocuments apd where apd.indApplication=? order by apd.id desc",[indApplicationDetailsInstance])
		
		for(int ig=0;ig<applicationDocumentInstance.size();ig++){
			def boolCheck="NO"
			if(listDoc.size()==0){
				listDoc.add(applicationDocumentInstance.get(ig))
			}
			for(int intCheck=0;intCheck<listDoc.size();intCheck++){
				if(listDoc[intCheck].level==(applicationDocumentInstance.get(ig)).level){
					boolCheck="Yes"
				}
			}
			if(boolCheck==false){
				listDoc.add(applicationDocumentInstance.get(ig))
			}
		}
		def listDocuments = new ArrayList()
		listDocuments.add(listDoc.level)
		def deleteDoc=ApplicationFileRecord.find("from ApplicationFileRecord btd where btd.indApplication=? and btd.typeOfFile='FormAir'",[indApplicationDetailsInstance])
   
	if(deleteDoc)
	{
		deleteDoc.delete()	
	}
		
	System.out.println("renewDateFrom--formPDF--"+renewDateFrom)
	System.out.println("renewDateTo--formPDF--"+renewDateTo)
	
/*	AutoRenewalWater form_air=new AutoRenewalWater()
	certFile=form_air.formAirPdf(indScale,productdetailsByFinal,otherAirPollutionControlDetails,dgSetAirPollutionControlDetails,incineratorAirPollutionControlDetails,heatersAirPollutionControlDetails,boilerAirPollutionControlDetails,emissionProcessDetails,emissionRecordDetails,otherPlantDetails,dgSetPlantDetails,incineratorPlantDetails,heatersPlantDetails,boilerPlantDetails,manfPro,sourceOfRawMaterial,bedCapacity,indFaxNo,indPin,rupeePay,datePay,draftNo,encloseCopy,authSign,icompositionEffluent,stormWater,proMonArr,testWaterAdd,processOfTreatment,waterSourceDetails,waterWasteDischargeDetails,effluentTreatment,wasteWaterQualityParameterDetails,expmonOfComm,expdateOfComm,dateOfComm,statusOfAppl,nationality,industryName,applicationType,industryAddress,
			dateOfSubmission,occupierName,occupierAddress,registrationNumber,nameAddressPartners,
			indRegAdd,industryDistrict,industryTehsil,plotNo,monOfComm,dateOfComm,
			waterMonitoring,corporation,villPanchayat,cantonment,defenceDep,portTrust,
			stateGovt,prohibitedArea,others,indTypeOther,type,monitoring,monitoring1,
			expectedNoEmployees,totalEmployees,totalInvestment,year,estimatedExp,
			timeReq,operAndMantainCost,treatmentArrangementStatus,actionTaken,
			category,b2,industryTelephone,indCity,soundLevel,abatement1,abatement2,
			a1,a2,name,materialDetailsList,waterSolidWasteGenDetailsInstanceFinalList
			,productDetailsList,IntermediateString,usageDetailsList,
			listDocuments,feeDetails1,wasteWaterGenDetailsFinalList,
			treatmentDetails1,wasteWaterGeDetailsFinalList,wasteWaterGenerationDetailsFinalList1,
			treatmentDetail,occMobile,treatmentDetaill,
			wasteWaterGenerationDetailsFinalList11,AirStackListFinal,feeDetails12
			,Airdetail,fuelDetail,productDetailsList1,
			waterSolidWasteGenDetailInstanceFinalList,
			productDetailssList,productDetailsssList
			,capitalInvestment,newCapitalInvestment,
			no,stack,materialConstruction,aboveGroundHeight,
			aboveFactHeight,waterSolidWasteGeDetailInstanceFinalList,
			waterSourceDetailsList,waterDrains,domestic,available,otherDetailsList,land,topography,speed,windDir,rainfall,
			aForPlant,aForInfra,aForEffl,north,east,south,west,buildcaptive,disCap,dweller,ProcessingChemString,SurrDetailsFinalList11,
			noiseDetail,applicationName,indEmail,khataNo,occupierTehsil,occupierDistrict,postOffice,khesraNo,appliID,renewDateFrom,renewDateTo,industryUserID.toString(),applicationNo.toString(),expanCost) 
	byte[] b = new byte[(int) certFile.length()];
	
        
        FileInputStream fileInputStream = new FileInputStream(certFile);
        fileInputStream.read(b);
 	        def fileLength=certFile.length()
        	file.size = fileLength / 1024  //f.getSize() 
 	         file.extension ="pdf"//extractExtension( f )
 	       	 file.data=b;
 	       	 file.name="AutoRenwalFormForAir.pdf"
 	    	 file.description="Auto Renewal Application Form"
 	    	 file.createdBy=sessionValue
 	    	 file.updatedBy=sessionValue
 	    	 file.typeOfFile="AutoRenwalFormForAir"
 	    	 file.indApplication=indApplicationDetailsNewInstance
 	       	 
 	       	if(!file.hasErrors() && file.save(flush:true)) {
			} else {
				file.errors.each {
			        println it
				}
			}
		
	} */
	
	public void pdfAutoRenew(String sessValue,Long appId)
	{

		
		println("pdf---appId---"+appId)
		println("pdf---appId---"+appId)
		File certFile
        ApplicationFileRecord file=new ApplicationFileRecord()
        def recordCertificateInstance=new RecordCertificate()
		def appID=appId.toString()
		def indApplicationDetailsInstance=IndApplicationDetails.get((appId).toLong())
		println("indApplicationDetailsInstance "+indApplicationDetailsInstance)
		def indRegInstance=indApplicationDetailsInstance.indUser
		println("indRegInstance "+indRegInstance)
		def applFor=(indApplicationDetailsInstance.applicationFor).toUpperCase()
		println("applFor===== "+applFor)
		def applType=(indApplicationDetailsInstance.applicationType).toUpperCase()
		def certFor=(indApplicationDetailsInstance.certificateFor).toUpperCase()
		def indCategory=(indRegInstance.category.name).toUpperCase()
		def id = (indApplicationDetailsInstance.id).toString()
		def indNewCapInvt=indRegInstance.indCapInvt.toString()
		println("indNewCapInvt "+indNewCapInvt)
		def id3=indApplicationDetailsInstance.indUser 
		def industryTypeMasterInstance=indApplicationDetailsInstance.indUser.industryType
		def id2=indApplicationDetailsInstance.applicationType
		def consentForVar=indApplicationDetailsInstance.certificateFor
		def applicationForVar=indApplicationDetailsInstance.applicationFor
		def applicationTypeMasterInstance=ApplicationTypeMaster.findWhere(consentType:id2)
		def indApplicationDetailsInstanceOld
           def autoInst = AutoRenewDetails.find("from AutoRenewDetails where application=?",[indApplicationDetailsInstance]); 
		println("autoInst "+autoInst)
	//	println("autoInst "+autoInst.oldApplicationId)
		if(autoInst){
			if(autoInst.oldApp)
				if(autoInst.oldApp)
				indApplicationDetailsInstanceOld = IndApplicationDetails.get((autoInst.oldApp).toLong())
				else
				indApplicationDetailsInstanceOld = IndApplicationDetails.get((autoInst.oldApplicationId).toLong())				
			}
		println("indApplicationDetailsInstanceOld"+indApplicationDetailsInstanceOld)
        def conditionMasterList=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'Specific')
        def sizeVal=conditionMasterList.size()
        def conditionArray = new String[sizeVal]
        for(int i=0; i<conditionMasterList.size();i++) {
            conditionArray[i]=(conditionMasterList.get(i)).condition
        }
        def conditionMasterListG=ConditionMaster.findAllWhere(industryTypeMaster:industryTypeMasterInstance,applicationTypeMaster:applicationTypeMasterInstance,consentFor:consentForVar,applicationFor:applicationForVar,conditionType:'General')
        def sizeValG=conditionMasterListG.size()
        def conditionArrayG = new String[sizeValG]
        for(int i=0; i<conditionMasterListG.size();i++) {
            conditionArrayG[i]=(conditionMasterListG.get(i)).condition
        }
        def referenceCheck=""
        def refSize=referenceCheck.size()
        def referencesArray = new String[refSize]
        def referenceStore=""
        if(referenceCheck.getClass().getName()=="java.lang.String") {
            referenceStore="1. "+referenceCheck
            }else{
            for(int varI=0; varI<referenceCheck.size();varI++) {
                int varInteger=varI+1
                referencesArray[varI]=referenceCheck[varI]
                referenceStore=referenceStore+"n"+varInteger+". "+referenceCheck[varI]
            }
        }
        for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
        }
       
        def occupierName=(indRegInstance.occName).toString()
      //  def occAddress=(indRegInstance.occAddress).toString()
        def occCity=(indRegInstance.occCity).toString()
        def occDistrict=(indRegInstance.occDistrict).toString()
        def occPin=(indRegInstance.occPin).toString()
   //    def indNewCapInvt=indRegInstance.indCapInvt.toString()
        def applicantName=indRegInstance.occName
      //  def industryUnit=indRegInstance.indScale
    	
        def feeDetails12= new ArrayList()
		def feeDetailsList1=FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
		
		for(int var2=0;var2<feeDetailsList1.size();var2++) {
			def feeDetails11= new ArrayList()
			feeDetails11.add((feeDetailsList1.get(var2).amount).toString())
			feeDetails11.add(feeDetailsList1.get(var2).ddChequeNo)
			feeDetails11.add(feeDetailsList1.get(var2).date)
			feeDetails12.add(feeDetails11)
		}
        
        def detailsMachineryProcess = ""
        def detailsEffTreatmentPlant = ""
        def standardWaterAct = ""
        def standardAirAct = ""
        def draftLetterFor = "Granted"
        def scrutinyDetails = ""
        def rawMaterialDetails = ""
        def productDetails = ""
        def byProductDetails = ""
        def modeOfDisposal = ""
        def typeOfEffluent = ""
        def stackHeight = ""
        def qtyOfFuel = ""
        def airPollutionDevices = ""
        def videNo="980"
       
      
        	def dateCreateOn=indApplicationDetailsInstance.applicationDate
			def hazType=indApplicationDetailsInstance.hazardeousType
			def abcFinal1=dateCreateOn
			DateCustom dd1=new DateCustom()
			def dateCreated= (dd1.sQLdate1(abcFinal1)).toString()
			def dDate=new Date()
			def abcFinal=dDate
			DateCustom dd=new DateCustom()
			def todayDate= (dd.sQLdate1(abcFinal)).toString()
			/*def val=params.pdfc
			def val2=params.pdfc2
			def val3=params.pdfc3 */
			def val=""
			def val2=""
			def val3=""
			DevImg dimg=new DevImg()
			def name=indRegInstance.indName
			def address=indRegInstance.indAddress
			def tehsil1=indRegInstance.tehsil.toString()
			def indCity = indRegInstance.indCity
			def pin =indRegInstance.indPin
			def district=(indRegInstance.district).toString()
		//	def fileN=params.fileNo
			def fileN=""
			def order="40001"
//			def videNo="980"
			//def subject=params.subject
				def subject=""
		//	def cntrlequipment=params.cntrlequipment
		def cntrlequipment=""
			PdfGenerationgreen pdfG=new PdfGenerationgreen()
        AutoRenewalPdf pdfGNew=new AutoRenewalPdf()
			//def sCondition=params.specificConditions
			def sCondition="No Condition"
			def gCondition="No Condition"
			def indusName = indRegInstance.indName
			def indAddress = indRegInstance.indAddress
			def occName = indRegInstance.occName
		def occAddress=indRegInstance.occAddress
		println("occAddress "+occAddress)
			/////////////////////to get Current year
			SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
			java.util.Date nowDate = new java.util.Date();
			String currentYear = formatNowYear.format(nowDate);
			println("currentYear..."+currentYear)
			def industrytype12=industryTypeMasterInstance.industryType
			def effluentGeneration=""
			def waterConsumption = ""
			///////////////////Consent No////////////////////////
			Integer year1 = new Date().getYear().toInteger()
			String year=(year1+1900).toString()
			String yearString = (String)year.substring(2,4)
			def issuingConsentTypeNo = ""		
			if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="new"){
				issuingConsentTypeNo="01"
			}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="expan"){
				issuingConsentTypeNo="02"
			}else if(indApplicationDetailsInstance.applicationType=="CTE"  && indApplicationDetailsInstance.certificateFor=="reNew"){
				issuingConsentTypeNo="03"
			}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="new"){
				issuingConsentTypeNo="04"
			}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="expan"){
				issuingConsentTypeNo="05"
			}else if(indApplicationDetailsInstance.applicationType=="CTO"  && indApplicationDetailsInstance.certificateFor=="reNew"){
				issuingConsentTypeNo="06"
			}
			
			println("issuingConsentTypeNo..."+issuingConsentTypeNo)
////////////////////////////////Authorization Number/////////////////////////////
			def authno="H"
			
////////////////////////////////////////end here
//////////////////////////////Fetch data from Schedule II(IR)////////////////////////////////////////////////////				
				def check = ConsentInspectionReport.findByApplication(indApplicationDetailsInstance)
				println("check..."+check)
				if(check){
					indNewCapInvt = check.totalCap
				}
				
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			def category=indRegInstance.category.name 
			def regId = (indRegInstance.id).toString()
			//println("regId..."+regId)
			def regDate = indRegInstance.regDate
			def dfh = new SimpleDateFormat("dd/MM/yyyy"); 
			regDate= dfh.format((java.util.Date) regDate)
		def productDetailsList1 = new ArrayList()
			def productDetailsInstance1=IndProductDetails.findAllByApplication(indApplicationDetailsInstanceOld)
		int cc = 1
			for(int var10=0;var10<productDetailsInstance1.size();var10++)
			{
				def productList1= new ArrayList()
				String s = Integer.toString(cc)
				productList1.add(s)
				productList1.add(productDetailsInstance1.get(var10).product)
				productList1.add(productDetailsInstance1.get(var10).quantity)
				productList1.add(productDetailsInstance1.get(var10).unit.unitName)
				productDetailsList1.add(productList1)
				cc++
			}
			
			println("productDetailsList1===="+productDetailsList1)

////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
   
			def stackDetailsList = new ArrayList()
			def stackDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
				int cccc = 1
						for(int var10=0;var10<stackDetailsInstance.size();var10++)
							{
							def stackList= new ArrayList()
							String s = Integer.toString(cccc)
							stackList.add(s)
							stackList.add(stackDetailsInstance.get(var10).stackAttachedTo)
							stackList.add(stackDetailsInstance.get(var10).stackVolume)
							stackList.add(stackDetailsInstance.get(var10).stackHeight)
							stackList.add(stackDetailsInstance.get(var10).topDiameter)
							stackList.add(stackDetailsInstance.get(var10).velocityOfGasEmission)
							stackDetailsList.add(stackList)
							cccc++
							}
////////////////////////////////Air Stack  Details///////////////////////////////////////////////	
def fuelDetailsList = new ArrayList()
			def fuelDetailsInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
				int e22 = 1
						for(int var10=0;var10<fuelDetailsInstance.size();var10++)
							{
							def fuelList= new ArrayList()
							String s = Integer.toString(e22)
							fuelList.add(s)
							fuelList.add(fuelDetailsInstance.get(var10).typeOfFuel)
							fuelList.add(fuelDetailsInstance.get(var10).maximumQuantity)
							fuelList.add(fuelDetailsInstance.get(var10).unit.unitName)
							fuelDetailsList.add(fuelList)
							e22++
							}
////////////////////////////////Solid Waste Disposal Details///////////////////////////////////////////////	
def solidWasteDisposalDetailsList1 = new ArrayList()
				def solidWasteDisposalDetailsInstance1=CosentCertSolidWasteDisposalDetails.findAllByApplication(indApplicationDetailsInstance)
					int cs = 1
					for(int var10=0;var10<solidWasteDisposalDetailsInstance1.size();var10++){
							def solidWasteDisposalDetailsList= new ArrayList()
								String s = Integer.toString(cs)
								solidWasteDisposalDetailsList.add(s)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).typeofWaste)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).quantity)
								solidWasteDisposalDetailsList.add(solidWasteDisposalDetailsInstance1.get(var10).disMode.disposalMode)
								solidWasteDisposalDetailsList1.add(solidWasteDisposalDetailsList)
								cs++
							}

def hotelFacilityDetail = new ArrayList()

//def hotelFacilityDetailInstance=HotelFacilityDetail.findAllByApplication(indApplicationDetailsInstance)

def hotelFacilityDetailInstance = HotelFacilityDetail.findAll("from HotelFacilityDetail indPow where indPow.hotelFacilityType.typeName='Hotel' and indPow.application=?",[indApplicationDetailsInstanceOld])
		
println("hotelFacilityDetailInstance==="+hotelFacilityDetailInstance)
for(int var12=0;var12<hotelFacilityDetailInstance.size();var12++)
	{
		def hotelFacilityDetailInstanceList= new ArrayList()
		hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).hotelFacilityType.typeName)
		hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facility.name)
		hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).capacity)
		hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facilityDetail)
		
		hotelFacilityDetail.add(hotelFacilityDetailInstanceList)
		
	}
println("hotelFacilityDetail==="+hotelFacilityDetail)

//////////////////////////////////////////Hazardeous Waste Details////////////////////////////////////////////////
def hazardousWasteGenDetailsList = new ArrayList()
def hazardousWasteGenDetailsInstance1=HazardousWasteGenDetailsCert.findAllByApplication(indApplicationDetailsInstance)
	for(int var10=0;var10<hazardousWasteGenDetailsInstance1.size();var10++){
			def hazardousWasteDetailsList= new ArrayList()
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).authFor);
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).sourceName.name);
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.name);
				//hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).categoryName.category);
				hazardousWasteDetailsList.add(hazardousWasteGenDetailsInstance1.get(var10).quantity);
				hazardousWasteGenDetailsList.add(hazardousWasteDetailsList)
			}
println("hazardousWasteGenDetailsList..."+hazardousWasteGenDetailsList);
//////////////////////////////////////////////////////////
////////////////////////////Stack details for hote////////////////////////////
def stackDetailsList1 = new ArrayList()
		def stackDetailsInstance1=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
			int cccc1 = 1
					for(int var10=0;var10<stackDetailsInstance1.size();var10++)
						{
						def stackList1= new ArrayList()
						String s = Integer.toString(cccc1)
						stackList1.add(s)
						stackList1.add(stackDetailsInstance1.get(var10).stackAttachedTo)
						stackList1.add(stackDetailsInstance1.get(var10).stackHeight)
						stackDetailsList1.add(stackList1)
						cccc1++
						}
////////////////////////////////////////////////////////Hotel details////////////////////
def productDetailsList11 = new ArrayList()
def productDetailsInstance11=CosentCertHotelDetails.findAllByApplication(indApplicationDetailsInstance)
int cc3 = 1
for(int var10=0;var10<productDetailsInstance11.size();var10++)
{
	def productList11= new ArrayList()
	String s = Integer.toString(cc3)
	productList11.add(s)
	productList11.add(productDetailsInstance11.get(var10).product)
	productList11.add(productDetailsInstance11.get(var10).quantity)
	productDetailsList11.add(productList11)
	cc3++
}
////////////////////////////////Pollution Control Equipment Details////////////////////////////////////////////	
def PollutionControlList = new ArrayList()
		def PollutionControlInstance=ConsentCertStackDetails.findAllByApplication(indApplicationDetailsInstance)
//		println("PollutionControlInstance...."+PollutionControlInstance)
			int e226 = 1
					for(int var10=0;var10<PollutionControlInstance.size();var10++)
						{
						def PollutionList= new ArrayList()
						String s = Integer.toString(e226)
						PollutionList.add(s)
						String pollControl=PollutionControlInstance.get(var10).pollutionCntrlMeasure
//						println("pollControl..."+pollControl)
						pollControl=pollControl.replace("]","")
						pollControl=pollControl.replace("[","")
//						println("pollControl..."+pollControl)
						PollutionList.add(pollControl)
						PollutionControlList.add(PollutionList)
						e226++
						}
//println("PollutionControlList...."+PollutionControlList)
//				def copyTo=params.copyTo 
				def copyTo="No copy"
				// def wasteWater=params.wasteWater
				def wasteWater=""
//				def capInvest=params.capInvest
				def capInvest=indNewCapInvt + "0"
			//	def waterConsume=params.waterConsume
				def waterConsume=""
			//	def sewageEffluent=params.sewageEffluent
				def sewageEffluent=""
			//	def specificConditionsforAuth=params.specificConditionsforAuth
				def specificConditionsforAuth=""
				def fileNumberIn =""
			/*	if(params.fileNumber){
					fileNumberIn=params.fileNumber
				}else{fileNumberIn=""}*/
				def endtNumberIn ="JKPCB-"+appID
				println("endtNumberIn "+endtNumberIn)
				/*if(params.endtNumber){
				endtNumberIn=params.endtNumber
				}else{
					endtNumberIn=""
				}*/
				def nameOfDistrict=""
				def offDistrict=indRegInstance.district.districtName
//				def draftDate=params.draftLetterDate_value
               
//				def startDate1=params.grantedFrom_value
	            def startDate1=autoInst.startDate
				//def endDate1=params.grantedTo_value
				def endDate1=autoInst.endDate
			//	def maxQuantity=params.maxQuantity
			def maxQuantity=""
				//occName="ABC"
				 def indName=indRegInstance.indName
				 def indRegNum = indRegInstance.indRegNum
				def indRegDate=""
				def checkDate
				def x
				def y
				println("startDate1 "+startDate1)
				println("endDate1 "+endDate1)
				
				      Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(startDate1);  
				  Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(endDate1);  
                      System.out.println(startDate1+"\t"+date1); 
                      System.out.println(endDate1+"\t"+date2);   
				
				
				
				                java.util.Date today = new java.util.Date();								
								println("today-" +today)
								java.sql.Timestamp sqlDate3 = new java.sql.Timestamp(today.getTime());
								java.sql.Timestamp sqlDate4 = new java.sql.Timestamp(today.getTime());
								java.sql.Timestamp sqlDate5 = new java.sql.Timestamp(today.getTime());
								println("sqlDate5-" +sqlDate5)
			
								
								
								def draftDate=sqlDate5	
				
								def dfh1 = new SimpleDateFormat("dd/MM/yyyy"); // yyyy-MM-dd HH:mm:ss
								
								draftDate= dfh1.format((java.util.Date) draftDate)
								 println("draftDate-" +draftDate)
								 
								 def dfh2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
								
							def	DownloadDateAndTime= dfh2.format((java.util.Date) sqlDate5)
								println("DownloadDateAndTime-" +sqlDate5)
								
				def recordCertificate = RecordCertificate.find("from RecordCertificate abc where abc.applicationId=? and abc.typeofCertificate='Prepared'",[indApplicationDetailsInstance])
				 def filerecordinstance=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Certificate'",[(indApplicationDetailsInstance.id).toLong()])
				def filerecordinstance1=ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication.id=? and abc.typeOfFile='Authorization'",[(indApplicationDetailsInstance.id).toLong()])
				 if(recordCertificate)
					{
					recordCertificate.delete()
					}
				 if(filerecordinstance)
				 {
					 filerecordinstance.delete();
				 }
				 if(filerecordinstance1)
				 {
					 filerecordinstance1.delete();
				 }
			recordCertificateInstance.startDate=date1
				recordCertificateInstance.endDate=date2
				recordCertificateInstance.updatedBy=sessValue
				recordCertificateInstance.createdBy=sessValue
				recordCertificateInstance.generalCondition=gCondition
				recordCertificateInstance.specificCondition=sCondition
				//recordCertificateInstance.subjectData=params.subject
				recordCertificateInstance.subjectData=""
				recordCertificateInstance.refData=referenceStore
				recordCertificateInstance.maxQuantity=maxQuantity
				recordCertificateInstance.copyTo=copyTo
				recordCertificateInstance.wasteWater=wasteWater
				recordCertificateInstance.capInvest=indNewCapInvt
				recordCertificateInstance.waterConsume=waterConsume
				recordCertificateInstance.sewageEffluent=sewageEffluent
				recordCertificateInstance.typeofCertificate="Prepared"
				if(specificConditionsforAuth!=null){
					recordCertificateInstance.specificConditionsforAuth=specificConditionsforAuth
					}else{
						recordCertificateInstance.specificConditionsforAuth=""
					}
				recordCertificateInstance.applicationId=indApplicationDetailsInstance
				boolean hotelCheck=false
				///////////////////////////HOTEL////////////////////////////
				String string = indRegInstance.industryType.industryType;
			      String keyword = "HOTELS";
			      String keyword1 = "Hotels";
			      String keyword2 = "hotels";
			      boolean found = Arrays.asList(string.split(" ")).contains(keyword);
			      boolean found1 = Arrays.asList(string.split(" ")).contains(keyword1);
			      boolean found2 = Arrays.asList(string.split(" ")).contains(keyword2);
			      if(found || found1 || found2){
			            System.out.println("Keyword matched the string"+found);
			            //cementCheck = true;
			            hotelCheck = true;	
			      }
//			  	println("deepak 666")
				if(!recordCertificateInstance.hasErrors() && recordCertificateInstance.save()) {
				//	flash.message = "Consent Order(Schedule-3) Generated and Record Saved "
						
					
					
//						println("deepak 777")
					if(referenceCheck.getClass().getName()=="java.lang.String") {
					println("deepak 888")
						
						certFile=pdfGNew.generateLabSampleBill(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,capInvest,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,
								applType,maxQuantity,productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,currentYear,industrytype12,
								offDistrict,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,nameOfDistrict,waterConsume,authno,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList,indCategory,DownloadDateAndTime,hotelFacilityDetail,applFor) 
								
				/*	certFile=pdfG.pdfFunction(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
										capInvest,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,applType,maxQuantity,
										productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,currentYear,industrytype12,
										offDistrict,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,nameOfDistrict,waterConsume,
										authno,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList,indCategory)*/
					}else{
					println("deepak 999")
						certFile=pdfG.pdfFunctionArray(indAddress,draftDate,occName,occAddress,certFor,indusName,endDate1,category,id,dateCreated,
								capInvest,gCondition,sCondition,copyTo,fileNumberIn,startDate1,regId,regDate,indCity,pin,tehsil1,district,applType,maxQuantity,
								productDetailsList1,solidWasteDisposalDetailsList1,stackDetailsList,cntrlequipment,fuelDetailsList,currentYear,industrytype12,
								offDistrict,endtNumberIn,subject,appID,yearString,issuingConsentTypeNo,nameOfDistrict,waterConsume,
								authno,sewageEffluent,indName,indRegNum,indRegDate,PollutionControlList,indCategory)
					}
//						println("deepak 111")
					def link="link"
					byte[] b = new byte[(int) certFile.length()];
					FileInputStream fileInputStream = new FileInputStream(certFile);
					fileInputStream.read(b);
					def fileLength=certFile.length()
					file.size = fileLength / 1024  //f.getSize() 
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.name="CertiFicate.pdf"
					file.description="Certificate Generation Record"
					file.createdBy=sessValue
					file.updatedBy=sessValue
					file.typeOfFile="Certificate"
					file.indApplication=indApplicationDetailsInstance
					if(file.save()) {
//						println("deepak 222")
					
//						code added for dashboard change start from here
						def allSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[(indApplicationDetailsInstance.id).toString()]);
						if(allSummaryReportInstance)
						{
						allSummaryReportInstance.dateOfIssue=date1;
						allSummaryReportInstance.dateOfexpiry=date2;
						if( !allSummaryReportInstance.hasErrors()&& allSummaryReportInstance.save(flush:true)){
							
						}
						}
					//code ends here
						//redirect(action:appProcessing,params:["id":params.idIndApp])
					} else {
//						println("in else file");
						file.errors.each
						{
							println it
						}
					//	flash.userMessage = "File [${file.name}] has NOT not been uploaded."
					//	render(view:'greenCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
					}
				}
				else {
//					println("in else recordCertificateInstance");
					recordCertificateInstance.errors.each
					{
						println it
					}
					//render(view:'greenCertificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
				}
			
		}
        
	
	
	
	
}
