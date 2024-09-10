/**
 * @author Prashant
 *
 */
 import java.util.ArrayList
 import java.text.*
 import java.text.SimpleDateFormat;

public class MasterReport{
	
	public void freshReport(Long appId,String userMstr1,IndustryMasterDetails mastReportInst){
		System.out.println("qqqqqqqqqqq");
		ApplicationFileRecord file=new ApplicationFileRecord()
		File certFile
		MasterReportJava pdfInsp=new MasterReportJava()
		def userMstr=UserMaster.get(userMstr1)
		
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		def industryRegMasterInst=indApplicationDetailsInstance.indUser
		
		def indName=mastReportInst.indName
		def indAddress=mastReportInst.indAddress
		def indNewCapInvt=mastReportInst.indCapInvt
		def dateOfComm=mastReportInst.dateOfComm
		def indEmail=mastReportInst.indEmail
		def expDate=mastReportInst.expDate
		def shiftsIndustry=mastReportInst.shiftsIndustry
		def monitoring=mastReportInst.monitoring
		def expNoEmp=mastReportInst.expNoEmp
		def noOfEmp=mastReportInst.noOfEmp
		def waterMonitoring=mastReportInst.waterMonitoring
		def siteArea=mastReportInst.siteArea
		def nearRiver=mastReportInst.nearRiver
		def riverName=mastReportInst.riverName
		def riverDist=mastReportInst.riverDist
		def nearResidCol=mastReportInst.nearResidCol
		def colPopulation=mastReportInst.colPopulation
		def colLocation=mastReportInst.colLocation
		def colDistance=mastReportInst.colDistance
		def nearIndEstate=mastReportInst.nearIndEstate
		def disposalSysProv=mastReportInst.disposalSysProv
		def utilizeSys=mastReportInst.utilizeSys
		def proposalDetails=mastReportInst.proposalDetails
		def totalPlotArea=mastReportInst.totalPlotArea
		def plotArea=mastReportInst.plotArea
		def builtUpArea=mastReportInst.builtUpArea
		
		
		
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
	
	

//		 Sewage Disposal Details
		
		SimpleDateFormat tradeDate=new SimpleDateFormat("dd/MM/yyyy");		
		
///////////////////////////////////////Fee Details////////////////////////////
		def feeList= new ArrayList()
		def feeDetailsList=FeeBankDetails.findAllByApplication(indApplicationDetailsInstance)
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
		////////////////////////////////////////////////////
		///////////////////AIR STACK//////////////////////
		
		def AirStackDetailsList= new ArrayList()
		def airStackDetails=AirStackDetailsMaster.findAll("from AirStackDetailsMaster s where s.application=? order by id asc",[indApplicationDetailsInstance])
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
		///////////////////////////////////////////////////////////////////////////
		
		def IndProductDetailsList= new ArrayList()
		def IndProductDetails=IndProductDetailsMaster.findAll("from IndProductDetailsMaster s where s.application=? order by id asc",[indApplicationDetailsInstance])
		for(int var10=0;var10<IndProductDetails.size();var10++)
		{
			def IndProductList= new ArrayList()
			
			
			IndProductList.add(IndProductDetails.get(var10).rawMaterials)
			IndProductList.add(IndProductDetails.get(var10).product)
			IndProductList.add(IndProductDetails.get(var10).quantity)
			IndProductList.add(IndProductDetails.get(var10).unit.unitName)
			IndProductList.add(IndProductDetails.get(var10).byProduct)
			IndProductList.add(IndProductDetails.get(var10).unit.unitName)
			IndProductDetailsList.add(IndProductList)
		}
		/////////////////////////////////////////////////////////////
		
		def airFlueGasEmissionDetailsList = new ArrayList()
		def airFlueGasDetailsList1=AirFlueGasDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
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
				airFlueGasEmissionDetailsList.add(airFlueGasDetailsInstanceList)
				
			}
		/////////////////////////////////////////////////////////////////
		def airMiscDetailsList = new ArrayList()
		def airMiscDetailsList1=AirMiscDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var12=0;var12<airMiscDetailsList1.size();var12++)
			{
			
				def airMiscDetailsInstanceList= new ArrayList()
				airMiscDetailsInstanceList.add(airMiscDetailsList1.get(var12).facility)
				airMiscDetailsInstanceList.add(airMiscDetailsList1.get(var12).quality)
				airMiscDetailsInstanceList.add(airMiscDetailsList1.get(var12).odorCompounds)
				
				airMiscDetailsList.add(airMiscDetailsInstanceList)
				
			}
		/////////////////////////////////////////////////////////////////
		def waterSourceDetailsList = new ArrayList()
		def waterSourceDetailInstance=WaterSourceDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
		 
		for(int var6=0;var6<waterSourceDetailInstance.size();var6++)
		{
			def waterSourDetailList= new ArrayList()
			
			waterSourDetailList.add(waterSourceDetailInstance.get(var6).source.sourceName)//This is source Type
			waterSourDetailList.add(waterSourceDetailInstance.get(var6).sourceName)//This is source Name
			waterSourDetailList.add((waterSourceDetailInstance.get(var6).quantity).toString())
			
			waterSourceDetailsList.add(waterSourDetailList)
		}
		
		//////////////////////////////////////////////////////////////////
		
		def treatmentDetailsList = new ArrayList()
		def treatmentDetailsInstance=WasteWaterTreatmentDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
				for(int var12=0;var12<treatmentDetailsInstance.size();var12++)
			{
				def treatmentDetailsInstanceList= new ArrayList()
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).uses)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).category.category)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).treatmentUnits)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).capacity)
				treatmentDetailsInstanceList.add(treatmentDetailsInstance.get(var12).investmentInTreatmentUnit)
			
				treatmentDetailsList.add(treatmentDetailsInstanceList)
				
			}
//////////////////////////////////////////////////////////////////////////////////
def HazardousWasteGenDetailsList= new ArrayList()
		def HazardousWasteGenDetails=HazardousWasteGenDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
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
		
//////////////////////////////////////
		def wasteWaterGenerationDetailsFinalList1 = new ArrayList()
		def wasteWaterGenerationDetailsInstance1=WaterWasteGenerationDetailsMaster.findAllByApplication(indApplicationDetailsInstance)

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

		//////////////////////////////////////////////////
		
		def waterSolidWasteGenDetailsInstanceFinalList = new ArrayList()
		def waterSolidWasteGenDetailsInstance=WaterSolidWasteGenDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<waterSolidWasteGenDetailsInstance.size();var7++)
			{
				def waterSolidWasteGenDetailsInstanceList= new ArrayList()
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).description)
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).quantQual)
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).meathodCollection)
				waterSolidWasteGenDetailsInstanceList.add(waterSolidWasteGenDetailsInstance.get(var7).meathodDisposal)
				
				waterSolidWasteGenDetailsInstanceFinalList.add(waterSolidWasteGenDetailsInstanceList)
				
			}
		
		/////////////////////////////////////////////////////////////////
		
		def stoneCrusherList = new ArrayList()
		def stoneCrusherInstance=StoneCrusherSittingCriteriaMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<stoneCrusherInstance.size();var7++)
			{
				def stoneCrusherInstanceList= new ArrayList()
				stoneCrusherInstanceList.add(stoneCrusherInstance.get(var7).parameter.parameterName)
				stoneCrusherInstanceList.add(stoneCrusherInstance.get(var7).distance)
				
				
				stoneCrusherList.add(stoneCrusherInstanceList)
				
			}
		
		/////////////////////////////////////////////////////////////////
		
		def stoneCrusherControlList = new ArrayList()
		def stoneCrusherControlInstance=StoneCrusherControlDevicesMasterM.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<stoneCrusherControlInstance.size();var7++)
			{
				def stoneCrusherControlInstanceList= new ArrayList()
				stoneCrusherControlInstanceList.add(stoneCrusherControlInstance.get(var7).device.deviceName)
				stoneCrusherControlInstanceList.add(stoneCrusherControlInstance.get(var7).name)
				stoneCrusherControlInstanceList.add(stoneCrusherControlInstance.get(var7).status)
				
				
				stoneCrusherControlList.add(stoneCrusherControlInstanceList)
				
			}
		
/////////////////////////////////////////////////////////////////
		
		def NocAuthorityList = new ArrayList()
		def NocAuthorityInstance=NocAuthorityDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<NocAuthorityInstance.size();var7++)
			{
				def NocAuthorityInstanceList= new ArrayList()
				NocAuthorityInstanceList.add(NocAuthorityInstance.get(var7).authorityDetails)
				NocAuthorityInstanceList.add(NocAuthorityInstance.get(var7).status)
				NocAuthorityInstanceList.add(NocAuthorityInstance.get(var7).number)
				NocAuthorityInstanceList.add(NocAuthorityInstance.get(var7).date)
				
				NocAuthorityList.add(NocAuthorityInstanceList)
				
			}

/////////////////////////////////////////////////////////////////
		
		def StoneCrusherWaterList = new ArrayList()
		def StoneCrusherWaterInstance=StoneCrusherWaterReqMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<StoneCrusherWaterInstance.size();var7++)
			{
				def StoneCrusherWaterInstanceList= new ArrayList()
				StoneCrusherWaterInstanceList.add(StoneCrusherWaterInstance.get(var7).sourceOfWaterSupply)
				StoneCrusherWaterInstanceList.add(StoneCrusherWaterInstance.get(var7).quantity)
				
				
				StoneCrusherWaterList.add(StoneCrusherWaterInstanceList)
				
			}

/////////////////////////////////////////////////////////////////
		
		def WaterConsumptionList = new ArrayList()
		def WaterConsumptionInstance=WaterConsumptionDetailMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<WaterConsumptionInstance.size();var7++)
			{
				def WaterConsumptionInstanceList= new ArrayList()
				WaterConsumptionInstanceList.add(WaterConsumptionInstance.get(var7).waterConsumptionType)
				WaterConsumptionInstanceList.add(WaterConsumptionInstance.get(var7).quantity)
				WaterConsumptionInstanceList.add(WaterConsumptionInstance.get(var7).storageFacility)
				
				
				WaterConsumptionList.add(WaterConsumptionInstanceList)
				
			}


/////////////////////////////////////////////////////////////////
		
		def BrickSittingList = new ArrayList()
		def BrickSittingInstance=BrickSittingCriteriaDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<BrickSittingInstance.size();var7++)
			{
				def BrickSittingInstanceList= new ArrayList()
				BrickSittingInstanceList.add(BrickSittingInstance.get(var7).parameter.parameterName)
				BrickSittingInstanceList.add(BrickSittingInstance.get(var7).distance)
				
				
				BrickSittingList.add(BrickSittingInstanceList)
				
			}

////////////////////////////////////////////////////////////////
		
		def BrickKilnList = new ArrayList()
		def BrickKilnInstance=BrickKilnDetailMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<BrickKilnInstance.size();var7++)
			{
				def BrickKilnInstanceList= new ArrayList()
				BrickKilnInstanceList.add(BrickKilnInstance.get(var7).capacity)
				BrickKilnInstanceList.add(BrickKilnInstance.get(var7).trenchSize)
				BrickKilnInstanceList.add(BrickKilnInstance.get(var7).chimeny)
				BrickKilnInstanceList.add(BrickKilnInstance.get(var7).height)
				BrickKilnInstanceList.add(BrickKilnInstance.get(var7).ecd)
				BrickKilnInstanceList.add(BrickKilnInstance.get(var7).cluster)
				
				
				BrickKilnList.add(BrickKilnInstanceList)
				
			}


////////////////////////////////////////////////////////////////
		
		def HotelGeneralList = new ArrayList()
		def HotelGeneralInstance=HotelGeneralDetailsMaster.findAllByApplication(indApplicationDetailsInstance)
		for(int var7=0;var7<HotelGeneralInstance.size();var7++)
			{
				def HotelGeneralInstanceList= new ArrayList()
				HotelGeneralInstanceList.add(HotelGeneralInstance.get(var7).hotelName)
				HotelGeneralInstanceList.add(HotelGeneralInstance.get(var7).roomCapacity)
				HotelGeneralInstanceList.add(HotelGeneralInstance.get(var7).investment)
				HotelGeneralInstanceList.add(HotelGeneralInstance.get(var7).location)
				HotelGeneralInstanceList.add(HotelGeneralInstance.get(var7).distance)
				
				HotelGeneralList.add(HotelGeneralInstanceList)
				
			}


////////////////////////////////////////////////////////////////


def hotelFacilityDetail = new ArrayList()
		
		//def hotelFacilityDetailInstance=HotelFacilityDetail.findAllByApplication(indApplicationDetailsInstance)
		
		def hotelFacilityDetailInstance = HotelFacilityDetailMaster.findAll("from HotelFacilityDetail indPow where indPow.hotelFacilityType.typeName='Hotel' and indPow.application=?",[indApplicationDetailsInstance])
				
		
		for(int var12=0;var12<hotelFacilityDetailInstance.size();var12++)
			{
				def hotelFacilityDetailInstanceList= new ArrayList()
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).hotelFacilityType.typeName)
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facility.name)
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).capacity)
				hotelFacilityDetailInstanceList.add(hotelFacilityDetailInstance.get(var12).facilityDetail)
				
				hotelFacilityDetail.add(hotelFacilityDetailInstanceList)
				
			}


////////////////////////////////////////////////////////////////

def hotelWasteEmissionDetail = new ArrayList()

def hotelWasteEmissionDetailInstance=HotelWasteEmissionDetailMaster.findAllByApplication(indApplicationDetailsInstance)

for(int var12=0;var12<hotelWasteEmissionDetailInstance.size();var12++)
	{
		def hotelWasteEmissionDetailInstanceList= new ArrayList()
		hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).type.name)
		hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).quantity)
		hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).nature)
		hotelWasteEmissionDetailInstanceList.add(hotelWasteEmissionDetailInstance.get(var12).tmethod)
		
		hotelWasteEmissionDetail.add(hotelWasteEmissionDetailInstanceList)
		
	}

////////////////////////////////////////////////////////////////
def hotelWaterConsumptionDetail = new ArrayList()
def hotelWaterConsumptionDetailInstance=HotelWasteEmissionDetailMaster.findAllByApplication(indApplicationDetailsInstance)
for(int var12=0;var12<hotelWaterConsumptionDetailInstance.size();var12++)
	{
	
		def hotelWaterConsumptionDetailInstanceList= new ArrayList()
		hotelWaterConsumptionDetailInstanceList.add(hotelWaterConsumptionDetailInstance.get(var12).type.name)
		hotelWaterConsumptionDetailInstanceList.add(hotelWaterConsumptionDetailInstance.get(var12).quantity)
		
		hotelWaterConsumptionDetail.add(hotelWaterConsumptionDetailInstanceList)
		
	}


////////////////////////////////////////////////////////////////
def SetDetails = new ArrayList()

def SetDetailsInstance=DGSetDetailsMaster.findAllByApplication(indApplicationDetailsInstance)

for(int var12=0;var12<SetDetailsInstance.size();var12++)
	{
		def SetDetailsInstanceList= new ArrayList()
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).makeDGset)
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).modelDGset)
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).powerRating)
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).fuel)
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).stackHeight)
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).heightOfBuilding.toString())
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).soundLevel)
		SetDetailsInstanceList.add(SetDetailsInstance.get(var12).location)
		
		SetDetails.add(SetDetailsInstanceList)
		
	}

/////////////////////////////////////////////////////////////////
def emissionDetailsList = new ArrayList()
def dGSetEmissionDetailsInstance=DGSetEmissionDetailsMaster.findAllByApplication(indApplicationDetailsInstance)

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
		
/////////////////////////////////////////////////////////////////
def parameterDetailsList = new ArrayList()
def dGSetParameterDetailsInstance=DGSetParameterDetailsMaster.findAllByApplication(indApplicationDetailsInstance)

for(int var10=0;var10<dGSetParameterDetailsInstance.size();var10++)
{
	def parameterList= new ArrayList()
	
	parameterList.add(dGSetParameterDetailsInstance.get(var10).parameters)
	parameterList.add(dGSetParameterDetailsInstance.get(var10).noLoad)
	parameterList.add(dGSetParameterDetailsInstance.get(var10).fullLoad)

	
	parameterDetailsList.add(parameterList)

}	
		/////////////////////////////////////////////////////////////////
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
		def hazardeousType=indApplicationDetailsInstance.hazardeousType
		Integer strYear1 = new Date().getYear().toInteger()
		String stringYear=(strYear1+1900).toString()
		certFile=pdfInsp.freshInspectionPdf(applicationType,certificateFor,feeList,applicationFor,AirStackDetailsList,IndProductDetailsList,airFlueGasEmissionDetailsList
				,airMiscDetailsList,waterSourceDetailsList,treatmentDetailsList,wasteWaterGenerationDetailsFinalList1,waterSolidWasteGenDetailsInstanceFinalList
				,indName,indAddress,indNewCapInvt,dateOfComm,indEmail,expDate,shiftsIndustry,monitoring,expNoEmp,noOfEmp,waterMonitoring,siteArea,nearRiver
				,riverName,riverDist,nearResidCol,colPopulation,colLocation,colDistance,nearIndEstate,disposalSysProv,utilizeSys,proposalDetails,totalPlotArea
				,plotArea,builtUpArea,stoneCrusherList,stoneCrusherControlList,NocAuthorityList,StoneCrusherWaterList,WaterConsumptionList,BrickSittingList
				,BrickKilnList,HotelGeneralList,hotelFacilityDetail,hotelWasteEmissionDetail,hotelWaterConsumptionDetail,SetDetails,emissionDetailsList,parameterDetailsList,HazardousWasteGenDetailsList,
				hazardeousType)
				
		 
				
			 byte[] b = new byte[(int) certFile.length()];
	        
	        FileInputStream fileInputStream = new FileInputStream(certFile);
	        
	        fileInputStream.read(b);
	 	        def fileLength=certFile.length()
	        	file.size = fileLength / 1024  //f.getSize() 
	 	         file.extension ="pdf"//extractExtension( f )
	 	       	 file.data=b;
	 	       	 file.name="Master Report.pdf"
	 	    	 file.description="Master Report"
	 	    	 file.createdBy=(userMstr).toString()
	 	    	 file.updatedBy=(userMstr).toString()
	 	    	 file.typeOfFile="Master Report"
	 	    	 file.indApplication=indApplicationDetailsInstance
	 	       	 
	 	       	if(!file.hasErrors() && file.save(flush:true)) {
	 	       } else {
					file.errors.each {
				   }
				}
	 	       	 
	 	     
	 			
	 	       	 
		}			

		
//////////////////////////////////////////////////////////////////


		
		
}	
		
		