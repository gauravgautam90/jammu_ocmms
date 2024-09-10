/**
 * @author Prashant
 *
 */
 import java.util.ArrayList
 import java.text.*
 import java.text.SimpleDateFormat;

public class InspectionReport{
	
	public void freshReport(Long appId,String userMstr1,ConsentInspectionReport consentInspectionReportInst){
		
		ApplicationFileRecord file=new ApplicationFileRecord()
		File certFile
		ConsentInspectionReportJava pdfInsp=new ConsentInspectionReportJava()
		def userMstr=UserMaster.get(userMstr1)
		
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		def industryRegMasterInst=indApplicationDetailsInstance.indUser
		def indType=indApplicationDetailsInstance.indUser.industryType.industryType
		println("indType.."+indType)
		
		System.out.println("consentInspectionReportInst.."+consentInspectionReportInst)
		System.out.println("consentInspectionReportInst.."+consentInspectionReportInst.indNameConReport)
		def indName=consentInspectionReportInst.indNameConReport
		def capInvt=consentInspectionReportInst.totalCap
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		def dateOfReceipt=sdf.format(consentInspectionReportInst.dateOfReceipt)
		
		def dateOfReceiptdistrict=sdf.format(consentInspectionReportInst.dateOfReceiptdistrict)
		def dateOfReceiptcentral=sdf.format(consentInspectionReportInst.dateOfReceiptcentral)
		
		def periodapplied= sdf.format(consentInspectionReportInst.periodapplied)
		
		
		
	//	def chemicalName=consentInspectionReportInst.chemicalName		
		def industrialArea=consentInspectionReportInst.industrialArea
		
		def papersub=consentInspectionReportInst.papersub		
		def senstiveArea=consentInspectionReportInst.senstiveArea
		def specificArea=consentInspectionReportInst.specificArea
		def areaSenstive=consentInspectionReportInst.areaSenstive
		def areaSpecific=consentInspectionReportInst.areaSpecific
		
		def incSewage=consentInspectionReportInst.incSewage
		def areaincSewage=consentInspectionReportInst.areaincSewage
		println("areaincSewage.."+areaincSewage)
		
		def distanceRiver=consentInspectionReportInst.distanceRiver		
		def distanceNational=consentInspectionReportInst.distanceNational
		
		def districtRoad=consentInspectionReportInst.districtRoad		
		def distanceHabitat=consentInspectionReportInst.distanceHabitat
		
		def touristComplex=consentInspectionReportInst.touristComplex		
		def forest=consentInspectionReportInst.forest
		
		def hospital=consentInspectionReportInst.hospital		
		def controlledArea=consentInspectionReportInst.controlledArea
		
		
		def nationalPark=consentInspectionReportInst.nationalPark		
		def agriculture=consentInspectionReportInst.agriculture
		
		def chamber=consentInspectionReportInst.chamber	
		
		def plantation=consentInspectionReportInst.plantation
		
		def others=consentInspectionReportInst.others		
		def sewageEffluent=consentInspectionReportInst.sewageEffluent
		
		def enviorment=consentInspectionReportInst.enviorment	
		def addSewagereq=consentInspectionReportInst.addSewagereq
		def shed=consentInspectionReportInst.shed
		
		def groundLevel=consentInspectionReportInst.groundLevel		
		def stackHeight=consentInspectionReportInst.stackHeight
		
		def fuel=consentInspectionReportInst.fuel	
		
		def boilerType=consentInspectionReportInst.boilerType
		
		
		def pollutionSystem=consentInspectionReportInst.pollutionSystem		
		def controlMeasure=consentInspectionReportInst.controlMeasure
		
		def fugitiveEmission=consentInspectionReportInst.fugitiveEmission		
		def noiseLevels=consentInspectionReportInst.noiseLevels
		
		def typeofNonHaz=consentInspectionReportInst.typeofNonHaz		
		def nonHazQty=consentInspectionReportInst.nonHazQty
		
		def treatmentArrang=consentInspectionReportInst.treatmentArrang	
		
		def disposalArrange=consentInspectionReportInst.disposalArrange
		
		def quantityrecycler=consentInspectionReportInst.quantityrecycler		
		def methodOfDisposal=consentInspectionReportInst.methodOfDisposal
		
		def methodOftreatment=consentInspectionReportInst.methodOftreatment		
		def saleName=consentInspectionReportInst.saleName
		
		def closeShed=consentInspectionReportInst.closeShed		
		def storedOrDisposed=consentInspectionReportInst.storedOrDisposed
		
		def leachate=consentInspectionReportInst.leachate	
		
		def chemicalStorage=consentInspectionReportInst.chemicalStorage
		
		def management=consentInspectionReportInst.management		
		def publicLiability=consentInspectionReportInst.publicLiability
		def regNo=indApplicationDetailsInstance.indUser.indRegNum
		def separateElectric=consentInspectionReportInst.separateElectric		
		def legal=consentInspectionReportInst.legal
		def acoustic=consentInspectionReportInst.acoustic		
		def adequacy=consentInspectionReportInst.adequacy
		
		def recieveEnviroment=consentInspectionReportInst.recieveEnviroment	
		
		def publicComplain=consentInspectionReportInst.publicComplain
		///////////////////RITESH///////////////////////////
		def location=consentInspectionReportInst.location
		def propermi=consentInspectionReportInst.propermi
		def oprmain=consentInspectionReportInst.oprmain
		def prestan=consentInspectionReportInst.prestan
		def aircomm=consentInspectionReportInst.aircomm
		def incwxam=consentInspectionReportInst.incwxam
		def pubcom=consentInspectionReportInst.pubcom
		def enviclea=consentInspectionReportInst.enviclea
		def reinspoff=consentInspectionReportInst.reinspoff
		def redistoff=consentInspectionReportInst.redistoff
		def reregioff=consentInspectionReportInst.reregioff
		
		def spmLevel=consentInspectionReportInst.spmLevel
		def resArea=consentInspectionReportInst.resArea
		
		//////////////////////////////////////////////////////
		def hotelRest=consentInspectionReportInst.hotelRest		
		
		def expansionPlant=consentInspectionReportInst.expansionPlant
		
		def capacityUtili=consentInspectionReportInst.capacityUtili
		def modernization=consentInspectionReportInst.modernization
		
		def categoryHaz= consentInspectionReportInst.categoryHaz
		
		def leachateCollect	=consentInspectionReportInst.leachateCollect
		def chemicalQty=consentInspectionReportInst.chemicalQty
		
		def commYear=consentInspectionReportInst.commYear
		def inspecRepCategory=consentInspectionReportInst.inspecRepCategory
		def inspecRepScale=consentInspectionReportInst.inspecRepScale
		def brickTiles=consentInspectionReportInst.brickTiles
		def waterSupply=consentInspectionReportInst.waterSupply
		def educationalInstituion = consentInspectionReportInst.educationalInstituion
		def metallingRoads =consentInspectionReportInst.metallingRoads
		def windBreaking=consentInspectionReportInst.windBreaking
		def jacketing= consentInspectionReportInst.jacketing
		def waterSprinkle= consentInspectionReportInst.waterSprinkle
		def greenBelt= consentInspectionReportInst.greenBelt
		def chimney= consentInspectionReportInst.chimney
	def roadsWall=consentInspectionReportInst.roadsWall
	def costPCD=consentInspectionReportInst.costPCD
	def authorityName=consentInspectionReportInst.authorityName
	def indAddressConReport=consentInspectionReportInst.indAddressConReport
	
	def standards=consentInspectionReportInst.standards
		
		//def userMstr=(UserMaster)session.userMaster
		
		def roomCapacity=consentInspectionReportInst.roomCapacity

//		 Sewage Disposal Details
		
		SimpleDateFormat tradeDate=new SimpleDateFormat("dd/MM/yyyy");		
		def tradeEffluentList= new ArrayList()
				def tradeEffluent=TradeEffluent.findAll("from TradeEffluent s where s.application=? order by id asc",[indApplicationDetailsInstance])
				for(int var10=0;var10<tradeEffluent.size();var10++)
				{
					def tradeList= new ArrayList()
					String date22=tradeDate.format(tradeEffluent.get(var10).(doss))
					tradeList.add(date22)
					tradeList.add(tradeEffluent.get(var10).ph)
					tradeList.add(tradeEffluent.get(var10).doin)
					tradeList.add(tradeEffluent.get(var10).bdo)
					tradeList.add(tradeEffluent.get(var10).cod)
					tradeList.add(tradeEffluent.get(var10).ss)
					tradeList.add(tradeEffluent.get(var10).og)
					tradeList.add(tradeEffluent.get(var10).other)
					tradeEffluentList.add(tradeList)
				}
		
		def sewageDetailsList= new ArrayList()
		def sewageDetails=SewageDetails.findAll("from SewageDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<sewageDetails.size();var10++)
		{
			def sewageList= new ArrayList()
			
			
			sewageList.add(sewageDetails.get(var10).(dossc).toString())
			sewageList.add(sewageDetails.get(var10).ph)
			sewageList.add(sewageDetails.get(var10).tss)
			sewageList.add(sewageDetails.get(var10).bdo)
			sewageDetailsList.add(sewageList)
		}
		
		
		def waterBudgetList= new ArrayList()
		def waterBudget=WaterBudget.findAll("from WaterBudget s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<waterBudget.size();var10++)
		{
			def waterList= new ArrayList()
			waterList.add(waterBudget.get(var10).waterbudgettype)
			waterList.add(waterBudget.get(var10).wcpresent)
			waterList.add(waterBudget.get(var10).wcprevious)
			waterList.add(waterBudget.get(var10).egpresent)
			waterList.add(waterBudget.get(var10).egprevious)
			
			waterList.add(waterBudget.get(var10).waterbudgettype2)
			waterList.add(waterBudget.get(var10).wcpresent2)
			waterList.add(waterBudget.get(var10).wcprevious2)
			waterList.add(waterBudget.get(var10).egpresent2)
			waterList.add(waterBudget.get(var10).egprevious2)
			
			waterList.add(waterBudget.get(var10).waterbudgettype3)
			waterList.add(waterBudget.get(var10).wcpresent3)
			waterList.add(waterBudget.get(var10).wcprevious3)
			waterList.add(waterBudget.get(var10).egpresent3)
			waterList.add(waterBudget.get(var10).egprevious3)
			
			waterList.add(waterBudget.get(var10).waterbudgettype4)
			waterList.add(waterBudget.get(var10).wcpresent4)
			waterList.add(waterBudget.get(var10).wcprevious4)
			waterList.add(waterBudget.get(var10).egpresent4)
			waterList.add(waterBudget.get(var10).egprevious4)
			
			waterBudgetList.add(waterList)
		}
		
		
		def hotelWaterConsumptionList= new ArrayList()
		def hotelWaterConsumptionDetails=HotelWaterConsumptionDetailInspection.findAll("from HotelWaterConsumptionDetailInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<hotelWaterConsumptionDetails.size();var10++)
		{
			def hotelWaterList= new ArrayList()
			
			
			hotelWaterList.add(hotelWaterConsumptionDetails.get(var10).type.name)
			hotelWaterList.add(hotelWaterConsumptionDetails.get(var10).quantity)
			
			
			hotelWaterConsumptionList.add(hotelWaterList)
		}
		
		def HazardousWasteGenDetailsList= new ArrayList()
		def HazardousWasteGenDetails=HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<HazardousWasteGenDetails.size();var10++)
		{
			def HazardousWasteList= new ArrayList()
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).authFor)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).sourceName.name)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).categoryName.name)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).categoryName.category)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).quantity)
			HazardousWasteGenDetailsList.add(HazardousWasteList)
		}
		
		
		
		def hotelFacilityDetailList= new ArrayList()
		def hotelFacilityDetail=HotelFacilityDetailInspection.findAll("from HotelFacilityDetailInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<hotelFacilityDetail.size();var10++)
		{
			def hotelFacilityList= new ArrayList()
			
			
			hotelFacilityList.add(hotelFacilityDetail.get(var10).hotelFacilityType.typeName)
			hotelFacilityList.add(hotelFacilityDetail.get(var10).facility.name)
			hotelFacilityList.add(hotelFacilityDetail.get(var10).capacity)
			hotelFacilityList.add(hotelFacilityDetail.get(var10).facilityDetail)
			
			
			hotelFacilityDetailList.add(hotelFacilityList)
		}
		def IndProductDetailsList= new ArrayList()
		def IndProductDetails=IndProductDetailsInspection.findAll("from IndProductDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<IndProductDetails.size();var10++)
		{
			def IndProductList= new ArrayList()
			
			
			IndProductList.add(IndProductDetails.get(var10).rawMaterials)
			IndProductList.add(IndProductDetails.get(var10).product)
			IndProductList.add(IndProductDetails.get(var10).quantity)
			IndProductList.add(IndProductDetails.get(var10).unit.unitName)
			IndProductList.add(IndProductDetails.get(var10).byProduct)
			IndProductList.add(IndProductDetails.get(var10).unitbyProduct.unitName)
			IndProductDetailsList.add(IndProductList)
		}
		
		def AirStackDetailsList= new ArrayList()
		def airStackDetails=AirStackDetailsInspection.findAll("from AirStackDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<airStackDetails.size();var10++)
		{
			def AirStackList= new ArrayList()
			
			AirStackList.add((var10).toString())
			AirStackList.add(airStackDetails.get(var10).heightGrdLevel)
			AirStackList.add(airStackDetails.get(var10).diamSize)
			AirStackList.add(airStackDetails.get(var10).stack)
			AirStackList.add(airStackDetails.get(var10).fuelTyp)
			AirStackList.add(airStackDetails.get(var10).gasQty)
			AirStackList.add(airStackDetails.get(var10).gasVel)
			AirStackList.add(airStackDetails.get(var10).draftType)
			AirStackList.add(airStackDetails.get(var10).matOfCon)
			AirStackDetailsList.add(AirStackList)
		}
		def ConsentDetailsList= new ArrayList()
		def consentDetails=ConsentDetails.findAll("from ConsentDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		println("consentDetails.."+consentDetails)
		SimpleDateFormat smt=new SimpleDateFormat("dd/MM/yyyy");
		
		
		for(int var10=0;var10<consentDetails.size();var10++)
		{   
			println("date in database.."+consentDetails.get(var10).(dateConsent))
			String date22=smt.format(consentDetails.get(var10).(dateConsent))
			def ConsentList= new ArrayList()
			
			
			ConsentList.add(consentDetails.get(var10).consent)
			ConsentList.add(date22);
			println("date22.."+date22)
			ConsentList.add(consentDetails.get(var10).number)
			
			
			ConsentDetailsList.add(ConsentList)
		}
		println("ConsentDetailsList.."+ConsentDetailsList)
		
		def HotelGeneralDetailsInspectionList= new ArrayList()
		def HotelGeneralDetails=HotelGeneralDetailsInspection.findAll("from HotelGeneralDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<HotelGeneralDetails.size();var10++)
		{
			def HotelGeneralList= new ArrayList()
			
			HotelGeneralList.add(HotelGeneralDetails.get(var10).location)
			HotelGeneralList.add(distanceRiver)
			HotelGeneralList.add(HotelGeneralDetails.get(var10).distance)
			HotelGeneralList.add(distanceHabitat)
			HotelGeneralDetailsInspectionList.add(HotelGeneralList)
		}
///////////////////////////////////////Fee Details////////////////////////////
		def feeList= new ArrayList()
		def feeDetailsList=FeeBankDetailsOfficer.findAllByApplication(indApplicationDetailsInstance)
		println("feeDetailsList"+feeDetailsList)
		for(int var2=0;var2<feeDetailsList.size();var2++)
		{
			def feeDetails= new ArrayList()
			feeDetails.add(feeDetailsList.get(var2).fromDate)
			feeDetails.add(feeDetailsList.get(var2).toDate)
			feeDetails.add(feeDetailsList.get(var2).bankName)
			feeDetails.add(feeDetailsList.get(var2).branch)
			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
			feeDetails.add(feeDetailsList.get(var2).date)
			feeDetails.add((feeDetailsList.get(var2).amount).toString())
			feeList.add(feeDetails)
		
		}
		
		
		/////////////////////////////////////////////////////
		
		def deeRecommendationsListbb=new ArrayList();
		println("ritesh1...."+deeRecommendationsListbb)
		def deeRecommendationsInsbb=ConsentInspectionReportEERecommendations.findAll("from ConsentInspectionReportEERecommendations s where s.application=? order by dateCreated asc",[indApplicationDetailsInstance])
		println("ritesh12...."+deeRecommendationsInsbb)
		for(int var10=0;var10<deeRecommendationsInsbb.size();var10++)
		{
			def deeRecommendListbb= new ArrayList()
			println("ritesh123...."+deeRecommendListbb)
			deeRecommendListbb.add(deeRecommendationsInsbb.get(var10).deeRecommendations)
			deeRecommendListbb.add(deeRecommendationsInsbb.get(var10).deeOfficer.userProfile.employeeFirstName+" "+deeRecommendationsInsbb.get(var10).deeOfficer.userProfile.employeeLastName+
					"( "+deeRecommendationsInsbb.get(var10).deeOfficer.userProfile.designation + " )")
			deeRecommendationsListbb.add(deeRecommendListbb)
		}
		def district=indApplicationDetailsInstance.indUser.district.districtName
		def email=	indApplicationDetailsInstance.indUser.occEmail
		
		////////////////////////////////////////////////////
	Random rand = new Random();
   int number= rand.nextInt(1000000) + 1;

//	     Complaints       
       
		def applicationType=indApplicationDetailsInstance.applicationType
		def certificateFor=indApplicationDetailsInstance.certificateFor
		 if(certificateFor.equals("new")){
        	 certificateFor="Fresh"
         }
         if(certificateFor.equals("Modern")){
        	 certificateFor = "Modernization "
         }
         if(certificateFor.equals("expan")){
        	 certificateFor = "Expansion"
         }
         if(certificateFor.equals("reNew")){
        	 certificateFor = "Renew"
         }
		def applicationFor=indApplicationDetailsInstance.applicationFor
		Integer strYear1 = new Date().getYear().toInteger()
		String stringYear=(strYear1+1900).toString()
		certFile=pdfInsp.freshInspectionPdf(indName,capInvt,dateOfReceipt,dateOfReceiptdistrict,dateOfReceiptcentral,
				periodapplied,industrialArea,papersub,senstiveArea,distanceRiver,distanceNational,districtRoad,
				distanceHabitat,touristComplex,forest,hospital,controlledArea,nationalPark,agriculture,chamber,
				plantation,others,sewageEffluent,enviorment,shed,
				groundLevel,stackHeight,fuel,boilerType,pollutionSystem,
				controlMeasure,fugitiveEmission,noiseLevels,typeofNonHaz,
				nonHazQty,treatmentArrang,disposalArrange,quantityrecycler,
				methodOfDisposal,methodOftreatment,
				saleName,closeShed,storedOrDisposed,
				leachate,chemicalStorage,management,
				publicLiability,separateElectric,legal,acoustic,adequacy,recieveEnviroment,publicComplain,hotelRest,number,
				expansionPlant,capacityUtili,modernization,ConsentDetailsList,IndProductDetailsList,AirStackDetailsList
				,hotelFacilityDetailList,hotelWaterConsumptionList,waterBudgetList,sewageDetailsList,tradeEffluentList,categoryHaz,leachateCollect,chemicalQty,applicationFor,
				commYear,inspecRepCategory,inspecRepScale,brickTiles,waterSupply,
				educationalInstituion,metallingRoads,windBreaking,jacketing,waterSprinkle,greenBelt,chimney,roadsWall,costPCD,applicationType,certificateFor
				,roomCapacity,authorityName,indAddressConReport,standards,feeList,specificArea,areaSpecific,areaSenstive,
				incSewage,areaincSewage,addSewagereq,location,propermi,oprmain,prestan,aircomm,incwxam,pubcom,enviclea,reinspoff,redistoff,reregioff,deeRecommendationsListbb,HotelGeneralDetailsInspectionList,
				resArea,spmLevel,HazardousWasteGenDetailsList,indType,regNo,district,email
				)
				
		def inss1= ApplicationFileRecord.findAll("from ApplicationFileRecord where typeOfFile='Inspection Report' and indApplication=?",[indApplicationDetailsInstance])
		if(inss1){
			for(int h=0;h<inss1.size();h++){
				inss1[h].delete();
			}
		}
			 byte[] b = new byte[(int) certFile.length()];
	        
	        FileInputStream fileInputStream = new FileInputStream(certFile);
	        
	        fileInputStream.read(b);
	 	        def fileLength=certFile.length()
	        	file.size = fileLength / 1024  //f.getSize() 
	 	         file.extension ="pdf"//extractExtension( f )
	 	       	 file.data=b;
	 	       	 file.name="Inspection Report.pdf"
	 	    	 file.description="Inspection Report"
	 	    	 file.createdBy=(userMstr).toString()
	 	    	 file.updatedBy=(userMstr).toString()
	 	    	 file.typeOfFile="Inspection Report"
	 	    	 file.indApplication=indApplicationDetailsInstance
	 	       	 
	 	       	if(!file.hasErrors() && file.save(flush:true)) {
	 	       } else {
					file.errors.each {
				   }
				}
	 	       	 
	 	     
	 			
	 	       	 
		}			
	
		
///////////////////////Regular inspection Report///////////////////////////////////////////
public void regularReport(Long appId,String userMstr1,IndustryInspectionReport consentInspectionReportInst){
		
		ApplicationFileRecord file=new ApplicationFileRecord()
		File certFile
		InspectionreportIns pdfInsp=new InspectionreportIns()
		def userMstr=UserMaster.get(userMstr1)
		
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		def industryRegMasterInst=indApplicationDetailsInstance.indUser
		def indType=indApplicationDetailsInstance.indUser.industryType.industryType
		println("indType.."+indType)
		
		System.out.println("consentInspectionReportInst.."+consentInspectionReportInst)
		System.out.println("consentInspectionReportInst.."+consentInspectionReportInst.indNameConReport)
		def indName=consentInspectionReportInst.indNameConReport
		def capInvt=consentInspectionReportInst.totalCap
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		def dateOfReceipt=sdf.format(consentInspectionReportInst.dateOfReceipt)
		
		def dateOfReceiptdistrict=sdf.format(consentInspectionReportInst.dateOfReceiptdistrict)
		def dateOfReceiptcentral=sdf.format(consentInspectionReportInst.dateOfReceiptcentral)
		
		def periodapplied= sdf.format(consentInspectionReportInst.periodapplied)
		
		
		
	//	def chemicalName=consentInspectionReportInst.chemicalName		
		def industrialArea=consentInspectionReportInst.industrialArea
		
		def papersub=consentInspectionReportInst.papersub		
		def senstiveArea=consentInspectionReportInst.senstiveArea
		def specificArea=consentInspectionReportInst.specificArea
		def areaSenstive=consentInspectionReportInst.areaSenstive
		def areaSpecific=consentInspectionReportInst.areaSpecific
		
		def incSewage=consentInspectionReportInst.incSewage
		def areaincSewage=consentInspectionReportInst.areaincSewage
		println("areaincSewage.."+areaincSewage)
		
		def distanceRiver=consentInspectionReportInst.distanceRiver		
		def distanceNational=consentInspectionReportInst.distanceNational
		
		def districtRoad=consentInspectionReportInst.districtRoad		
		def distanceHabitat=consentInspectionReportInst.distanceHabitat
		
		def touristComplex=consentInspectionReportInst.touristComplex		
		def forest=consentInspectionReportInst.forest
		
		def hospital=consentInspectionReportInst.hospital		
		def controlledArea=consentInspectionReportInst.controlledArea
		
		
		def nationalPark=consentInspectionReportInst.nationalPark		
		def agriculture=consentInspectionReportInst.agriculture
		
		def chamber=consentInspectionReportInst.chamber	
		
		def plantation=consentInspectionReportInst.plantation
		
		def others=consentInspectionReportInst.others		
		def sewageEffluent=consentInspectionReportInst.sewageEffluent
		
		def enviorment=consentInspectionReportInst.enviorment	
		def addSewagereq=consentInspectionReportInst.addSewagereq
		def shed=consentInspectionReportInst.shed
		
		def groundLevel=consentInspectionReportInst.groundLevel		
		def stackHeight=consentInspectionReportInst.stackHeight
		
		def fuel=consentInspectionReportInst.fuel	
		
		def boilerType=consentInspectionReportInst.boilerType
		
		
		def pollutionSystem=consentInspectionReportInst.pollutionSystem		
		def controlMeasure=consentInspectionReportInst.controlMeasure
		
		def fugitiveEmission=consentInspectionReportInst.fugitiveEmission		
		def noiseLevels=consentInspectionReportInst.noiseLevels
		
		def typeofNonHaz=consentInspectionReportInst.typeofNonHaz		
		def nonHazQty=consentInspectionReportInst.nonHazQty
		
		def treatmentArrang=consentInspectionReportInst.treatmentArrang	
		
		def disposalArrange=consentInspectionReportInst.disposalArrange
		
		def quantityrecycler=consentInspectionReportInst.quantityrecycler		
		def methodOfDisposal=consentInspectionReportInst.methodOfDisposal
		
		def methodOftreatment=consentInspectionReportInst.methodOftreatment		
		def saleName=consentInspectionReportInst.saleName
		
		def closeShed=consentInspectionReportInst.closeShed		
		def storedOrDisposed=consentInspectionReportInst.storedOrDisposed
		
		def leachate=consentInspectionReportInst.leachate	
		
		def chemicalStorage=consentInspectionReportInst.chemicalStorage
		
		def management=consentInspectionReportInst.management		
		def publicLiability=consentInspectionReportInst.publicLiability
		def regNo=indApplicationDetailsInstance.indUser.indRegNum
		def separateElectric=consentInspectionReportInst.separateElectric		
		def legal=consentInspectionReportInst.legal
		def acoustic=consentInspectionReportInst.acoustic		
		def adequacy=consentInspectionReportInst.adequacy
		
		def recieveEnviroment=consentInspectionReportInst.recieveEnviroment	
		
		def publicComplain=consentInspectionReportInst.publicComplain
		///////////////////RITESH///////////////////////////
		def location=consentInspectionReportInst.location
		def propermi=consentInspectionReportInst.propermi
		def oprmain=consentInspectionReportInst.oprmain
		def prestan=consentInspectionReportInst.prestan
		def aircomm=consentInspectionReportInst.aircomm
		def incwxam=consentInspectionReportInst.incwxam
		def pubcom=consentInspectionReportInst.pubcom
		def enviclea=consentInspectionReportInst.enviclea
		def reinspoff=consentInspectionReportInst.reinspoff
		def redistoff=consentInspectionReportInst.redistoff
		def reregioff=consentInspectionReportInst.reregioff
		
		def spmLevel=consentInspectionReportInst.spmLevel
		def resArea=consentInspectionReportInst.resArea
		
		//////////////////////////////////////////////////////
		def hotelRest=consentInspectionReportInst.hotelRest		
		
		def expansionPlant=consentInspectionReportInst.expansionPlant
		
		def capacityUtili=consentInspectionReportInst.capacityUtili
		def modernization=consentInspectionReportInst.modernization
		
		def categoryHaz= consentInspectionReportInst.categoryHaz
		
		def leachateCollect	=consentInspectionReportInst.leachateCollect
		def chemicalQty=consentInspectionReportInst.chemicalQty
		
		def commYear=consentInspectionReportInst.commYear
		def inspecRepCategory=consentInspectionReportInst.inspecRepCategory
		def inspecRepScale=consentInspectionReportInst.inspecRepScale
		def brickTiles=consentInspectionReportInst.brickTiles
		def waterSupply=consentInspectionReportInst.waterSupply
		def educationalInstituion = consentInspectionReportInst.educationalInstituion
		def metallingRoads =consentInspectionReportInst.metallingRoads
		def windBreaking=consentInspectionReportInst.windBreaking
		def jacketing= consentInspectionReportInst.jacketing
		def waterSprinkle= consentInspectionReportInst.waterSprinkle
		def greenBelt= consentInspectionReportInst.greenBelt
		def chimney= consentInspectionReportInst.chimney
	def roadsWall=consentInspectionReportInst.roadsWall
	def costPCD=consentInspectionReportInst.costPCD
	def authorityName=consentInspectionReportInst.authorityName
	def indAddressConReport=consentInspectionReportInst.indAddressConReport
	
	def standards=consentInspectionReportInst.standards
		
		//def userMstr=(UserMaster)session.userMaster
		
		def roomCapacity=consentInspectionReportInst.roomCapacity

//		 Sewage Disposal Details
		
		SimpleDateFormat tradeDate=new SimpleDateFormat("dd/MM/yyyy");		
		def tradeEffluentList= new ArrayList()
				def tradeEffluent=TradeEffluent.findAll("from TradeEffluent s where s.application=? order by id asc",[indApplicationDetailsInstance])
				for(int var10=0;var10<tradeEffluent.size();var10++)
				{
					def tradeList= new ArrayList()
					String date22=tradeDate.format(tradeEffluent.get(var10).(doss))
					tradeList.add(date22)
					tradeList.add(tradeEffluent.get(var10).ph)
					tradeList.add(tradeEffluent.get(var10).doin)
					tradeList.add(tradeEffluent.get(var10).bdo)
					tradeList.add(tradeEffluent.get(var10).cod)
					tradeList.add(tradeEffluent.get(var10).ss)
					tradeList.add(tradeEffluent.get(var10).og)
					tradeList.add(tradeEffluent.get(var10).other)
					tradeEffluentList.add(tradeList)
				}
		
		def sewageDetailsList= new ArrayList()
		def sewageDetails=SewageDetails.findAll("from SewageDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<sewageDetails.size();var10++)
		{
			def sewageList= new ArrayList()
			
			
			sewageList.add(sewageDetails.get(var10).(dossc).toString())
			sewageList.add(sewageDetails.get(var10).ph)
			sewageList.add(sewageDetails.get(var10).tss)
			sewageList.add(sewageDetails.get(var10).bdo)
			sewageDetailsList.add(sewageList)
		}
		
		
		def waterBudgetList= new ArrayList()
		def waterBudget=WaterBudget.findAll("from WaterBudget s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<waterBudget.size();var10++)
		{
			def waterList= new ArrayList()
			waterList.add(waterBudget.get(var10).waterbudgettype)
			waterList.add(waterBudget.get(var10).wcpresent)
			waterList.add(waterBudget.get(var10).wcprevious)
			waterList.add(waterBudget.get(var10).egpresent)
			waterList.add(waterBudget.get(var10).egprevious)
			
			waterList.add(waterBudget.get(var10).waterbudgettype2)
			waterList.add(waterBudget.get(var10).wcpresent2)
			waterList.add(waterBudget.get(var10).wcprevious2)
			waterList.add(waterBudget.get(var10).egpresent2)
			waterList.add(waterBudget.get(var10).egprevious2)
			
			waterList.add(waterBudget.get(var10).waterbudgettype3)
			waterList.add(waterBudget.get(var10).wcpresent3)
			waterList.add(waterBudget.get(var10).wcprevious3)
			waterList.add(waterBudget.get(var10).egpresent3)
			waterList.add(waterBudget.get(var10).egprevious3)
			
			waterList.add(waterBudget.get(var10).waterbudgettype4)
			waterList.add(waterBudget.get(var10).wcpresent4)
			waterList.add(waterBudget.get(var10).wcprevious4)
			waterList.add(waterBudget.get(var10).egpresent4)
			waterList.add(waterBudget.get(var10).egprevious4)
			
			waterBudgetList.add(waterList)
		}
		
		
		def hotelWaterConsumptionList= new ArrayList()
		def hotelWaterConsumptionDetails=HotelWaterConsumptionDetailInspection.findAll("from HotelWaterConsumptionDetailInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<hotelWaterConsumptionDetails.size();var10++)
		{
			def hotelWaterList= new ArrayList()
			
			
			hotelWaterList.add(hotelWaterConsumptionDetails.get(var10).type.name)
			hotelWaterList.add(hotelWaterConsumptionDetails.get(var10).quantity)
			
			
			hotelWaterConsumptionList.add(hotelWaterList)
		}
		
		def HazardousWasteGenDetailsList= new ArrayList()
		def HazardousWasteGenDetails=HazardousWasteGenDetailsInspection.findAll("from HazardousWasteGenDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<HazardousWasteGenDetails.size();var10++)
		{
			def HazardousWasteList= new ArrayList()
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).authFor)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).sourceName.name)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).categoryName.name)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).categoryName.category)
			HazardousWasteList.add(HazardousWasteGenDetails.get(var10).quantity)
			HazardousWasteGenDetailsList.add(HazardousWasteList)
		}
		
		
		
		def hotelFacilityDetailList= new ArrayList()
		def hotelFacilityDetail=HotelFacilityDetailInspection.findAll("from HotelFacilityDetailInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<hotelFacilityDetail.size();var10++)
		{
			def hotelFacilityList= new ArrayList()
			
			
			hotelFacilityList.add(hotelFacilityDetail.get(var10).hotelFacilityType.typeName)
			hotelFacilityList.add(hotelFacilityDetail.get(var10).facility.name)
			hotelFacilityList.add(hotelFacilityDetail.get(var10).capacity)
			hotelFacilityList.add(hotelFacilityDetail.get(var10).facilityDetail)
			
			
			hotelFacilityDetailList.add(hotelFacilityList)
		}
		def IndProductDetailsList= new ArrayList()
		def IndProductDetails=IndProductDetailsInspection.findAll("from IndProductDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<IndProductDetails.size();var10++)
		{
			def IndProductList= new ArrayList()
			
			
			IndProductList.add(IndProductDetails.get(var10).rawMaterials)
			IndProductList.add(IndProductDetails.get(var10).product)
			IndProductList.add(IndProductDetails.get(var10).quantity)
			IndProductList.add(IndProductDetails.get(var10).unit.unitName)
			IndProductList.add(IndProductDetails.get(var10).byProduct)
			IndProductList.add(IndProductDetails.get(var10).unitbyProduct.unitName)
			IndProductDetailsList.add(IndProductList)
		}
		
		def AirStackDetailsList= new ArrayList()
		def airStackDetails=AirStackDetailsInspection.findAll("from AirStackDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<airStackDetails.size();var10++)
		{
			def AirStackList= new ArrayList()
			
			AirStackList.add((var10).toString())
			AirStackList.add(airStackDetails.get(var10).heightGrdLevel)
			AirStackList.add(airStackDetails.get(var10).diamSize)
			AirStackList.add(airStackDetails.get(var10).stack)
			AirStackList.add(airStackDetails.get(var10).fuelTyp)
			AirStackList.add(airStackDetails.get(var10).gasQty)
			AirStackList.add(airStackDetails.get(var10).gasVel)
			AirStackList.add(airStackDetails.get(var10).draftType)
			AirStackList.add(airStackDetails.get(var10).matOfCon)
			AirStackDetailsList.add(AirStackList)
		}
		def ConsentDetailsList= new ArrayList()
		def consentDetails=ConsentDetails.findAll("from ConsentDetails s where s.application=? order by id asc",[indApplicationDetailsInstance])
		println("consentDetails.."+consentDetails)
		SimpleDateFormat smt=new SimpleDateFormat("dd/MM/yyyy");
		
		
		for(int var10=0;var10<consentDetails.size();var10++)
		{   
			println("date in database.."+consentDetails.get(var10).(dateConsent))
			String date22=smt.format(consentDetails.get(var10).(dateConsent))
			def ConsentList= new ArrayList()
			
			
			ConsentList.add(consentDetails.get(var10).consent)
			ConsentList.add(date22);
			println("date22.."+date22)
			ConsentList.add(consentDetails.get(var10).number)
			
			
			ConsentDetailsList.add(ConsentList)
		}
		println("ConsentDetailsList.."+ConsentDetailsList)
		
		def HotelGeneralDetailsInspectionList= new ArrayList()
		def HotelGeneralDetails=HotelGeneralDetailsInspection.findAll("from HotelGeneralDetailsInspection s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<HotelGeneralDetails.size();var10++)
		{
			def HotelGeneralList= new ArrayList()
			
			HotelGeneralList.add(HotelGeneralDetails.get(var10).location)
			HotelGeneralList.add(distanceRiver)
			HotelGeneralList.add(HotelGeneralDetails.get(var10).distance)
			HotelGeneralList.add(distanceHabitat)
			HotelGeneralDetailsInspectionList.add(HotelGeneralList)
		}
///////////////////////////////////////Fee Details////////////////////////////
		def feeList= new ArrayList()
		def feeDetailsList=FeeBankDetailsOfficer.findAllByApplication(indApplicationDetailsInstance)
		println("feeDetailsList"+feeDetailsList)
		for(int var2=0;var2<feeDetailsList.size();var2++)
		{
			def feeDetails= new ArrayList()
			feeDetails.add(feeDetailsList.get(var2).fromDate)
			feeDetails.add(feeDetailsList.get(var2).toDate)
			feeDetails.add(feeDetailsList.get(var2).bankName)
			feeDetails.add(feeDetailsList.get(var2).branch)
			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
			feeDetails.add(feeDetailsList.get(var2).date)
			feeDetails.add((feeDetailsList.get(var2).amount).toString())
			feeList.add(feeDetails)
		
		}
		
		
		/////////////////////////////////////////////////////
		
		def deeRecommendationsListbb=new ArrayList();
		println("ritesh1...."+deeRecommendationsListbb)
		def deeRecommendationsInsbb=ConsentInspectionReportEERecommendations.findAll("from ConsentInspectionReportEERecommendations s where s.application=? order by dateCreated asc",[indApplicationDetailsInstance])
		println("ritesh12...."+deeRecommendationsInsbb)
		for(int var10=0;var10<deeRecommendationsInsbb.size();var10++)
		{
			def deeRecommendListbb= new ArrayList()
			println("ritesh123...."+deeRecommendListbb)
			deeRecommendListbb.add(deeRecommendationsInsbb.get(var10).deeRecommendations)
			deeRecommendListbb.add(deeRecommendationsInsbb.get(var10).deeOfficer.userProfile.employeeFirstName+" "+deeRecommendationsInsbb.get(var10).deeOfficer.userProfile.employeeLastName+
					"( "+deeRecommendationsInsbb.get(var10).deeOfficer.userProfile.designation + " )")
			deeRecommendationsListbb.add(deeRecommendListbb)
		}
		
		
		////////////////////////////////////////////////////
	Random rand = new Random();
   int number= rand.nextInt(1000000) + 1;

//	     Complaints       
       
		def applicationType=indApplicationDetailsInstance.applicationType
		def certificateFor=indApplicationDetailsInstance.certificateFor
		 if(certificateFor.equals("new")){
        	 certificateFor="Fresh"
         }
         if(certificateFor.equals("Modern")){
        	 certificateFor = "Modernization "
         }
         if(certificateFor.equals("expan")){
        	 certificateFor = "Expansion"
         }
         if(certificateFor.equals("reNew")){
        	 certificateFor = "Renew"
         }
		def applicationFor=indApplicationDetailsInstance.applicationFor
		Integer strYear1 = new Date().getYear().toInteger()
		String stringYear=(strYear1+1900).toString()
		certFile=pdfInsp.regularInspectionPdf(indName,capInvt,dateOfReceipt,dateOfReceiptdistrict,dateOfReceiptcentral,
				periodapplied,industrialArea,papersub,senstiveArea,distanceRiver,distanceNational,districtRoad,
				distanceHabitat,touristComplex,forest,hospital,controlledArea,nationalPark,agriculture,chamber,
				plantation,others,sewageEffluent,enviorment,shed,
				groundLevel,stackHeight,fuel,boilerType,pollutionSystem,
				controlMeasure,fugitiveEmission,noiseLevels,typeofNonHaz,
				nonHazQty,treatmentArrang,disposalArrange,quantityrecycler,
				methodOfDisposal,methodOftreatment,
				saleName,closeShed,storedOrDisposed,
				leachate,chemicalStorage,management,
				publicLiability,separateElectric,legal,acoustic,adequacy,recieveEnviroment,publicComplain,hotelRest,number,
				expansionPlant,capacityUtili,modernization,ConsentDetailsList,IndProductDetailsList,AirStackDetailsList
				,hotelFacilityDetailList,hotelWaterConsumptionList,waterBudgetList,sewageDetailsList,tradeEffluentList,categoryHaz,leachateCollect,chemicalQty,applicationFor,
				commYear,inspecRepCategory,inspecRepScale,brickTiles,waterSupply,
				educationalInstituion,metallingRoads,windBreaking,jacketing,waterSprinkle,greenBelt,chimney,roadsWall,costPCD,applicationType,certificateFor
				,roomCapacity,authorityName,indAddressConReport,standards,feeList,specificArea,areaSpecific,areaSenstive,
				incSewage,areaincSewage,addSewagereq,location,propermi,oprmain,prestan,aircomm,incwxam,pubcom,enviclea,reinspoff,redistoff,reregioff,deeRecommendationsListbb,HotelGeneralDetailsInspectionList,
				resArea,spmLevel,HazardousWasteGenDetailsList,indType,regNo
				)
				
				def inss1= ApplicationFileRecord.findAll("from ApplicationFileRecord where typeOfFile='Regular Inspection Report' and indApplication=?",[indApplicationDetailsInstance])
				if(inss1){
					for(int h=0;h<inss1.size();h++){
						inss1[h].delete();
					}
				}
			 byte[] b = new byte[(int) certFile.length()];
	        
	        FileInputStream fileInputStream = new FileInputStream(certFile);
	        
	        fileInputStream.read(b);
	 	        def fileLength=certFile.length()
	        	file.size = fileLength / 1024  //f.getSize() 
	 	         file.extension ="pdf"//extractExtension( f )
	 	       	 file.data=b;
	 	       	 file.name="Regular Inspection Report.pdf"
	 	    	 file.description="Regular Inspection Report"
	 	    	 file.createdBy=(userMstr).toString()
	 	    	 file.updatedBy=(userMstr).toString()
	 	    	 file.typeOfFile="Regular Inspection Report"
	 	    	 file.indApplication=indApplicationDetailsInstance
	 	       	 
	 	       	if(!file.hasErrors() && file.save(flush:true)) {
	 	       } else {
					file.errors.each {
				   }
				}
	 	       	 
	 	     
	 			
	 	       	 
		}	
//-----------------------------------------------------------------BIO-MEDICAL WASTE INSPECTION REPORT------------------------------------------//
		
		public void getBmwInspectionPdf(Long id,String user){
			File certFile
			WasteManagementFile file=new WasteManagementFile()
			def bioMedicalDetailsInstance=BioMedicalWaste.get(id)
			def bioMedicalInspectionReport=BioMedicalInspectionReport.findByApplication(bioMedicalDetailsInstance)
			def  indName=bioMedicalInspectionReport.indName
			def indAddress=bioMedicalInspectionReport.indAddress
			def occName=bioMedicalInspectionReport.occName
			def occPhone=bioMedicalInspectionReport.occPhone
			def hcfName=bioMedicalInspectionReport.hcfName
			def correspondenceAddress=bioMedicalInspectionReport.correspondenceAddress
			def yearOfEstablishment=bioMedicalInspectionReport.yearOfEstablishment
			def monthofEstablishment=bioMedicalInspectionReport.monthofEstablishment
			def hcfType=bioMedicalInspectionReport.hcfType
			def hcfTypeMenu=bioMedicalInspectionReport.hcfTypeMenu
			def authorizationSought= bioMedicalInspectionReport.authorizationSought
			def authunderbiomed=bioMedicalInspectionReport.authunderbiomed
			def consentunderwateract=bioMedicalInspectionReport.consentunderwateract
			def noOfyear=bioMedicalInspectionReport.noOfyear
			def avgOccupancy=bioMedicalInspectionReport.avgOccupancy
			def noOfBeds=bioMedicalInspectionReport.noOfBeds
			def ctectoStatus=bioMedicalInspectionReport.ctectoStatus
			def authorizationFor= bioMedicalInspectionReport.authorizationFor
			def annualReport=bioMedicalInspectionReport.annualReport
			def noOfPersoninBmw=bioMedicalInspectionReport.noOfPersoninBmw
			def sourceBioWasteGen=bioMedicalInspectionReport.sourceBioWasteGen
			def wasteGenQuantity=bioMedicalInspectionReport.wasteGenQuantity
			def colorCodingBins=bioMedicalInspectionReport.colorCodingBins
			def waterProofLabels=bioMedicalInspectionReport.waterProofLabels
			def postersSegregation=bioMedicalInspectionReport.postersSegregation
			def intraRuralTrans=bioMedicalInspectionReport.intraRuralTrans
			def awayHCF=bioMedicalInspectionReport.awayHCF
			def withinHCF=bioMedicalInspectionReport.withinHCF
			def lightingAndVentilation=bioMedicalInspectionReport.lightingAndVentilation
			def leachateProvided=bioMedicalInspectionReport.leachateProvided
			def accessRestricted=bioMedicalInspectionReport.accessRestricted
			def modeofDisposal=bioMedicalInspectionReport.modeofDisposal
			def onSite=bioMedicalInspectionReport.onSite
			def throughCBWTF=bioMedicalInspectionReport.throughCBWTF
			def adequateOnSite=bioMedicalInspectionReport.adequateOnSite
			def untreatedWaste=bioMedicalInspectionReport.untreatedWaste
			def treatedWaste=bioMedicalInspectionReport.treatedWaste
			def trolleysProvided=bioMedicalInspectionReport.trolleysProvided
			def plantProvided=bioMedicalInspectionReport.plantProvided
			def incinerationQuant=bioMedicalInspectionReport.incinerationQuant
			def autoclavingQuant=bioMedicalInspectionReport.autoclavingQuant
			def shreddingQuant=bioMedicalInspectionReport.shreddingQuant
			def chemicaldisQuant=bioMedicalInspectionReport.chemicaldisQuant
			def deepBurialQuant=bioMedicalInspectionReport.deepBurialQuant
			def sharpPit=bioMedicalInspectionReport.sharpPit
			def othermodeTreatment=bioMedicalInspectionReport.othermodeTreatment
			def capacityofAutoclave=bioMedicalInspectionReport.capacityofAutoclave
			def capacityofShredder=bioMedicalInspectionReport.capacityofShredder
			def conditionsofAutoclave=bioMedicalInspectionReport.conditionsofAutoclave
			def trolleywastefeeding=bioMedicalInspectionReport.trolleywastefeeding
			def recordingDeviceAttached=bioMedicalInspectionReport.recordingDeviceAttached
			def stripsporeTest=bioMedicalInspectionReport.stripsporeTest
			def performanceofAutoclaving=bioMedicalInspectionReport.performanceofAutoclaving
			def workingofshredder=bioMedicalInspectionReport.workingofshredder
			def quantityofWater=bioMedicalInspectionReport.quantityofWater
			def quantityofWastewater=bioMedicalInspectionReport.quantityofWastewater
	def vehicleWashing=bioMedicalInspectionReport.vehicleWashing
	def containerWashing=bioMedicalInspectionReport.containerWashing
	def effluentTreatmentPlant=bioMedicalInspectionReport.effluentTreatmentPlant
	def neutralization=bioMedicalInspectionReport.neutralization
	def smrConducted=bioMedicalInspectionReport.smrConducted
	def reusedorRecycled=bioMedicalInspectionReport.reusedorRecycled
	def dischargethroughdrain=bioMedicalInspectionReport.dischargethroughdrain
	def etpSludge =bioMedicalInspectionReport.etpSludge
	def plasticTreatment =bioMedicalInspectionReport.plasticTreatment
	def treatedWasteSharps =bioMedicalInspectionReport.treatedWasteSharps
	def mercurywastedisposal =bioMedicalInspectionReport.mercurywastedisposal
	def outdatedCytotoxicDrugs =bioMedicalInspectionReport.outdatedCytotoxicDrugs
	def hyposolutiongenerated =bioMedicalInspectionReport.hyposolutiongenerated
	def segregationofwaste =bioMedicalInspectionReport.segregationofwaste
	def wardsmaintains =bioMedicalInspectionReport.wardsmaintains
	def CBMWTFoperator =bioMedicalInspectionReport.CBMWTFoperator
	def firesafetymeasures =bioMedicalInspectionReport.firesafetymeasures
	def logbookOperation =bioMedicalInspectionReport.logbookOperation
	def awarenessprogrammes =bioMedicalInspectionReport.awarenessprogrammes
	def statusWaste =bioMedicalInspectionReport.statusWaste
	def officerRecom =bioMedicalInspectionReport.officerRecom
	def officerRemark =bioMedicalInspectionReport.officerRemark
	def officerName =bioMedicalInspectionReport.officerName
	def officerDesignation =bioMedicalInspectionReport.officerDesignation
	
//------------------Fee
def feeList= new ArrayList()
		def feeDetailsList=FeeBankBMWDetailsOfficer.findAllByApplication(bioMedicalDetailsInstance)
		println("feeDetailsList"+feeDetailsList)
		for(int var2=0;var2<feeDetailsList.size();var2++)
		{
			def feeDetails= new ArrayList()
			feeDetails.add(feeDetailsList.get(var2).fromDate)
			feeDetails.add(feeDetailsList.get(var2).toDate)
			feeDetails.add(feeDetailsList.get(var2).bankName)
			feeDetails.add(feeDetailsList.get(var2).branch)
			feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
			feeDetails.add(feeDetailsList.get(var2).date)
			feeDetails.add((feeDetailsList.get(var2).amount).toString())
			feeList.add(feeDetails)
		
		}


//-------------------------
			BioMedicalInspection br = new BioMedicalInspection();
			certFile=br.getDetails(indName
					, indAddress
					, occName
					, occPhone
					, hcfName
					, correspondenceAddress
					, yearOfEstablishment
					, monthofEstablishment
					, hcfType
					, hcfTypeMenu
					, authorizationSought 
					, authunderbiomed
					, consentunderwateract
					, noOfyear
					, avgOccupancy
					, noOfBeds
					, ctectoStatus
					, authorizationFor 
					, annualReport
					, noOfPersoninBmw
					, sourceBioWasteGen
					, wasteGenQuantity
					, colorCodingBins
					, waterProofLabels
					, postersSegregation
					, intraRuralTrans
					, awayHCF
					, withinHCF
					, lightingAndVentilation
					, leachateProvided
					, accessRestricted
					, modeofDisposal
					, onSite
					, throughCBWTF
					, adequateOnSite
					, untreatedWaste
					, treatedWaste
					, trolleysProvided
					, plantProvided
					, incinerationQuant
					, autoclavingQuant
					, shreddingQuant
					, chemicaldisQuant
					, deepBurialQuant
					, sharpPit
					, othermodeTreatment
					, capacityofAutoclave
					, capacityofShredder
					, conditionsofAutoclave
					, trolleywastefeeding
					, recordingDeviceAttached
					, stripsporeTest
					, performanceofAutoclaving
					, workingofshredder
					, quantityofWater
					, quantityofWastewater
					, vehicleWashing
					, containerWashing
					, effluentTreatmentPlant
					, neutralization
					, smrConducted
					, reusedorRecycled
					, dischargethroughdrain
					, etpSludge 
					, plasticTreatment
					, treatedWasteSharps
					, mercurywastedisposal
					, outdatedCytotoxicDrugs
					, hyposolutiongenerated
					, segregationofwaste
					, wardsmaintains
					, CBMWTFoperator
					, firesafetymeasures
					, logbookOperation
					, awarenessprogrammes
					, statusWaste
					, officerRecom
					, officerRemark
					, officerName
					, officerDesignation
					,feeList)
			 byte[] b = new byte[(int) certFile.length()];
		        
		        FileInputStream fileInputStream = new FileInputStream(certFile);
		        
		        fileInputStream.read(b);
		 	        def fileLength=certFile.length()
		        	file.size = fileLength / 1024  //f.getSize() 
		 	         file.extension ="pdf"//extractExtension( f )
		 	       	 file.data=b;
		 	       	 file.name="Inspection Report BMW.pdf"
		 	    	 file.description="Inspection Report BMW"
		 	    	 file.createdBy=user
		 	    	 file.updatedBy=user
		 	    	 file.typeOfFile="Inspection Report BMW"
		 	    	 file.indreg=bioMedicalDetailsInstance.industryRegMasterObj
		 	    	 file.applicationId=bioMedicalDetailsInstance.id
		 	    	 file.resubmittedDoc=false
		 	    	 file.applicationFor="BMW"
		 	       	 
		 	       	if(!file.hasErrors() && file.save(flush:true)) {
		 	       		println(" bmw master file saved")
		 	       } else {
						file.errors.each {
					   }
					}
}
}	
		
		