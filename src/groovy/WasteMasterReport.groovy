/**
 * @author Prashant
 *
 */
 import java.util.ArrayList
 import java.text.*
 import java.text.SimpleDateFormat;

public class WasteMasterReport{
	
	public void freshReportForWasteMaster(String userMstr1,IndustryMasterDetails mastReportInst,BioMedicalWasteMaster bioMedicalWasteInstance,WasteMasterDataDetails wasteMasterInstance){
		System.out.println("qqqqqqqqqqq");
		WasteManagementFile file=new WasteManagementFile()
		File certFile
		BmwMasterReportJava pdfInsp=new BmwMasterReportJava()
		def userMstr=UserMaster.get(userMstr1)
		
	String nameOfApplicant=bioMedicalWasteInstance.nameOfApplicant
	String nameOfInstitution=bioMedicalWasteInstance.nameOfInstitution
	String activityAuthorizationSoughtFor=bioMedicalWasteInstance.activityAuthorizationSoughtFor
	String authorizationType=bioMedicalWasteInstance.authorizationType
	String previousAuthNo=bioMedicalWasteInstance.previousAuthNo
	Date previousAuthDate=bioMedicalWasteInstance.previousAuthDate
	String nameAddressInstitution=bioMedicalWasteInstance.nameAddressInstitution
	String addrTreatmentFacility=bioMedicalWasteInstance.addrTreatmentFacility
	String addrPlaceDisposalOfWaste=bioMedicalWasteInstance.addrPlaceDisposalOfWaste
	String completionStatus=bioMedicalWasteInstance.completionStatus
	String modeTrans=bioMedicalWasteInstance.modeTrans
	String modeTreat=bioMedicalWasteInstance.modeTreat
	String descrip=bioMedicalWasteInstance.descrip
	Date dateCreated=bioMedicalWasteInstance.dateCreated
	String createdBy=bioMedicalWasteInstance.createdBy
	Date lastUpdated=bioMedicalWasteInstance.lastUpdated
	String updatedBy=bioMedicalWasteInstance.updatedBy
	String applicationStatus=bioMedicalWasteInstance.applicationStatus
	
	String condImposedRenew=bioMedicalWasteInstance.condImposedRenew
	String categHAW=bioMedicalWasteInstance.categHAW
	String categAW=bioMedicalWasteInstance.categAW
	String categMBW=bioMedicalWasteInstance.categMBW
	String categWS=bioMedicalWasteInstance.categWS
	String categDMCD=bioMedicalWasteInstance.categDMCD
	String categSW6=bioMedicalWasteInstance.categSW6
	String categSW7=bioMedicalWasteInstance.categSW7
	String categLW=bioMedicalWasteInstance.categLW
	String categIA=bioMedicalWasteInstance.categIA
	String categCW=bioMedicalWasteInstance.categCW
	String categHAWUnit=bioMedicalWasteInstance.categHAWUnit
	String categAWUnit=bioMedicalWasteInstance.categAWUnit
	String categMBWUnit=bioMedicalWasteInstance.categMBWUnit
	String categWSUnit=bioMedicalWasteInstance.categWSUnit
	String categDMCDUnit=bioMedicalWasteInstance.categDMCDUnit
	String categSW6Unit=bioMedicalWasteInstance.categSW6Unit
	String categSW7Unit=bioMedicalWasteInstance.categSW7Unit
	String categLWUnit=bioMedicalWasteInstance.categLWUnit
	String categIAUnit=bioMedicalWasteInstance.categIAUnit
	String categCWUnit=bioMedicalWasteInstance.categCWUnit
	Date prevExpDate=bioMedicalWasteInstance.prevExpDate
	String authorisationAppliedFor=bioMedicalWasteInstance.authorisationAppliedFor
	String hcfType=bioMedicalWasteInstance.hcfType
	String bmwfacility=bioMedicalWasteInstance.bmwfacility
	String bmwstatus=bioMedicalWasteInstance.bmwstatus
	String wastelocationaddress=bioMedicalWasteInstance.wastelocationaddress
	String wastedisposalplace=bioMedicalWasteInstance.wastedisposalplace
	String outpatientsFacility= bioMedicalWasteInstance.outpatientsFacility
	String inpatientsFacility=bioMedicalWasteInstance.inpatientsFacility
	String noofbeds=bioMedicalWasteInstance.noofbeds
	String other1=bioMedicalWasteInstance.other1
	String other2=bioMedicalWasteInstance.other2
	String patientspermonth=bioMedicalWasteInstance.patientspermonth
	String destroyer=bioMedicalWasteInstance.destroyer
	String bmwrules1=bioMedicalWasteInstance.bmwrules1
	String NoofHCF=bioMedicalWasteInstance.NoofHCF
	String Jurisdictionalarea=bioMedicalWasteInstance.Jurisdictionalarea
	String authorisationDay=bioMedicalWasteInstance.authorisationDay
	String authorisationMonth=bioMedicalWasteInstance.authorisationMonth
	String detailapc=bioMedicalWasteInstance.detailapc
	String detailetp=bioMedicalWasteInstance.detailetp
	String quantityperDay=bioMedicalWasteInstance.quantityperDay
	String quantityperMonth=bioMedicalWasteInstance.quantityperMonth
	String quantityperDay1=bioMedicalWasteInstance.quantityperDay1
	String quantityperMonth1=bioMedicalWasteInstance.quantityperMonth1
	String authapply=bioMedicalWasteInstance.authapply
	String hcfTypeMenu=bioMedicalWasteInstance.hcfTypeMenu
	String anatomicalwaste=bioMedicalWasteInstance.anatomicalwaste
    String animalwaste=bioMedicalWasteInstance.animalwaste
    String biowaste=bioMedicalWasteInstance.biowaste
    String wastesharp=bioMedicalWasteInstance.wastesharp
    String discardedwaste=bioMedicalWasteInstance.discardedwaste
    String soiledwaste=bioMedicalWasteInstance.soiledwaste
    String solidwaste=bioMedicalWasteInstance.solidwaste
    String liquidwaste=bioMedicalWasteInstance.liquidwaste
    String ash=bioMedicalWasteInstance.ash
    String chemicalwaste=bioMedicalWasteInstance.chemicalwaste
    String total1=bioMedicalWasteInstance.total1
	String paymentDeviation=bioMedicalWasteInstance.paymentDeviation
	String remittedFees=bioMedicalWasteInstance.remittedFees
	String statusCteCto=bioMedicalWasteInstance.statusCteCto
	String latitude=bioMedicalWasteInstance.latitude
	String longtitude=bioMedicalWasteInstance.longtitude
	String detailsOfDirections=bioMedicalWasteInstance.detailsOfDirections
	String noOfNonBeds=bioMedicalWasteInstance.noOfNonBeds
	String noOfNonBeds1=bioMedicalWasteInstance.noOfNonBeds1
	String noOfInOutPatients=bioMedicalWasteInstance.noOfInOutPatients
	String colorCodedBags=bioMedicalWasteInstance.colorCodedBags
	String noOfBedsCbmwtf=bioMedicalWasteInstance.noOfBedsCbmwtf
	String treatmentAndDisposal=bioMedicalWasteInstance.treatmentAndDisposal
	String qtyOfBmwTreated=bioMedicalWasteInstance.qtyOfBmwTreated
	String contingencyPlan=bioMedicalWasteInstance.contingencyPlan
	String detailsOfTraining=bioMedicalWasteInstance.detailsOfTraining
	String incinrators=bioMedicalWasteInstance.incinrators
	String incinratorsType=bioMedicalWasteInstance.incinratorsType
	String plasmaPyrolysis=bioMedicalWasteInstance.plasmaPyrolysis
	String plasmaPyrolysisType=bioMedicalWasteInstance.plasmaPyrolysisType
	String autoclaves=bioMedicalWasteInstance.autoclaves
	String autoclavesType=bioMedicalWasteInstance.autoclavesType
	String microwave=bioMedicalWasteInstance.microwave
	String microwaveType=bioMedicalWasteInstance.microwaveType
	String hydroclave=bioMedicalWasteInstance.hydroclave
	String hydroclaveType=bioMedicalWasteInstance.hydroclaveType
	String shredders=bioMedicalWasteInstance.shredders
	String shreddersType=bioMedicalWasteInstance.shreddersType
	String needleTipCutter=bioMedicalWasteInstance.needleTipCutter
	String needleTipCutterType=bioMedicalWasteInstance.needleTipCutterType
	String sharpEncapsulation=bioMedicalWasteInstance.sharpEncapsulation
	String sharpEncapsulationType=bioMedicalWasteInstance.sharpEncapsulationType
	String deepBurial=bioMedicalWasteInstance.deepBurial
	String deepBurialType=bioMedicalWasteInstance.deepBurialType
	String chemDisinfection=bioMedicalWasteInstance.chemDisinfection
	String chemDisinfectionType=bioMedicalWasteInstance.chemDisinfectionType
	String anyOtherTretmntEquip=bioMedicalWasteInstance.anyOtherTretmntEquip
	String anyOtherTretmntEquipType=bioMedicalWasteInstance.anyOtherTretmntEquipType
	String chemicalSolidWaste=bioMedicalWasteInstance.chemicalLiquidWaste
	String chemicalLiquidWaste=bioMedicalWasteInstance.chemicalLiquidWaste
	String discardedLinen=bioMedicalWasteInstance.discardedLinen
	String otherClininLabWaste=bioMedicalWasteInstance.otherClininLabWaste
	String contaminatedwaste=bioMedicalWasteInstance.contaminatedwaste
	String wasteSharps=bioMedicalWasteInstance.wasteSharps
	String glassWare=bioMedicalWasteInstance.glassWare
	String metallicBodyImplants=bioMedicalWasteInstance.metallicBodyImplants
	boolean isNewApplication=	bioMedicalWasteInstance.isNewApplication

		println("-----bioMedicalWasteId-----"+wasteMasterInstance.applicationId)
		def bioMedicalWasteId=wasteMasterInstance.applicationId
		def bioMedicalDetailsInstance = BioMedicalWaste.get(bioMedicalWasteId.toLong())
		def industryRegMasterInst=bioMedicalDetailsInstance.industryRegMasterObj
		
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
		
		String prevAuthDate=sdf.format(previousAuthDate);
		String dateCreatedVar=sdf.format(dateCreated);
		String lastUpdatedVar=sdf.format(lastUpdated);
		String prevExpDateVar=sdf.format(prevExpDate);

//		 Sewage Disposal Details
		
		SimpleDateFormat tradeDate=new SimpleDateFormat("dd/MM/yyyy");		
		
///////////////////////////////////////Fee Details////////////////////////////
		def feeList= new ArrayList()
		def feeDetailsList=FeeBankDetailsBMW.findAllByApplication(bioMedicalDetailsInstance)
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

		def onlineFeeList= new ArrayList()
		def onlinefeeDetailsList=BankTransactionDetailsBMW.findAll(" from BankTransactionDetailsBMW bm Where bm.bioApplication=? and bm.transactionStatus='S'",[bioMedicalDetailsInstance])
		for(int var2=0;var2<onlinefeeDetailsList.size();var2++)
		{
			def onlineFeeDetails=new ArrayList()
	    	onlineFeeDetails.add((onlinefeeDetailsList.get(var2).id).toString())
	    	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    	String dateCreated1=sdf1.format(onlinefeeDetailsList.get(var2).dateCreated);
	    	onlineFeeDetails.add(dateCreated1)
	    	onlineFeeDetails.add((onlinefeeDetailsList.get(var2).amount).toString())
	    	onlineFeeDetails.add("Successful")
	    	onlineFeeList.add(onlineFeeDetails)
		
		}



		////////////////////////////////////////////////////
		///////////////////AIR STACK//////////////////////
	
		///////////////////////////////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////////
		
		/////////////////////////////////////////////////////////////////
	
		
		//////////////////////////////////////////////////////////////////
	
//////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////
	

		//////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////////
		
	
		
		/////////////////////////////////////////////////////////////////
		
		
/////////////////////////////////////////////////////////////////
		
	
/////////////////////////////////////////////////////////////////
		
/////////////////////////////////////////////////////////////////
		
	


/////////////////////////////////////////////////////////////////
		
	

////////////////////////////////////////////////////////////////
	

////////////////////////////////////////////////////////////////
		
	


////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////

		
/////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////
	Random rand = new Random();
   int number= rand.nextInt(1000000) + 1;

//	     Complaints       
       
		Integer strYear1 = new Date().getYear().toInteger()
		String stringYear=(strYear1+1900).toString()
		certFile=pdfInsp.freshInspectionPdf(feeList,indName,indAddress,indNewCapInvt,dateOfComm,indEmail,expDate,shiftsIndustry,monitoring,expNoEmp,noOfEmp,waterMonitoring,siteArea,nearRiver
				,riverName,riverDist,nearResidCol,colPopulation,colLocation,colDistance,nearIndEstate,disposalSysProv,utilizeSys,proposalDetails,totalPlotArea,	plotArea, nameOfApplicant
				, nameOfInstitution
				, activityAuthorizationSoughtFor
				, authorizationType
				, previousAuthNo
				, prevAuthDate
				, nameAddressInstitution
				, addrTreatmentFacility
				, addrPlaceDisposalOfWaste
				, completionStatus
				, modeTrans
				, modeTreat
				, descrip
				, dateCreatedVar
				, createdBy
				, lastUpdatedVar
				, updatedBy
				, applicationStatus
				, condImposedRenew
				, categHAW
				, categAW
				, categMBW
				, categWS
				, categDMCD
				, categSW6
				, categSW7
				, categLW
				, categIA
				, categCW
				, categHAWUnit
				, categAWUnit
				, categMBWUnit
				, categWSUnit
				, categDMCDUnit
				, categSW6Unit
				, categSW7Unit
				, categLWUnit
				, categIAUnit
				, categCWUnit
				, prevExpDateVar
				, authorisationAppliedFor
				, hcfType
				, bmwfacility
				, bmwstatus
				, wastelocationaddress
				, wastedisposalplace
				, outpatientsFacility 
				, inpatientsFacility
				, noofbeds
				, other1
				, other2
				, patientspermonth
				, destroyer
				, bmwrules1
				, NoofHCF
				, Jurisdictionalarea
				, authorisationDay
				, authorisationMonth
				, detailapc
				, detailetp
				, quantityperDay
				, quantityperMonth
				, quantityperDay1
				, quantityperMonth1
				, authapply
				, hcfTypeMenu
				, anatomicalwaste
			    , animalwaste
			    , biowaste
			    , wastesharp
			    , discardedwaste
			    , soiledwaste
			    , solidwaste
			    , liquidwaste
			    , ash
			    , chemicalwaste
			    , total1
				, paymentDeviation
				, remittedFees
				, statusCteCto
				, latitude
				, longtitude
				, detailsOfDirections
				, noOfNonBeds
				, noOfNonBeds1
				, noOfInOutPatients
				, colorCodedBags
				, noOfBedsCbmwtf
				, treatmentAndDisposal
				, qtyOfBmwTreated
				, contingencyPlan
				, detailsOfTraining
				, incinrators
				, incinratorsType
				, plasmaPyrolysis
				, plasmaPyrolysisType
				, autoclaves
				, autoclavesType
				, microwave
				, microwaveType
				, hydroclave
				, hydroclaveType
				, shredders
				, shreddersType
				, needleTipCutter
				, needleTipCutterType
				, sharpEncapsulation
				, sharpEncapsulationType
				, deepBurial
				, deepBurialType
				, chemDisinfection
				, chemDisinfectionType
				, anyOtherTretmntEquip
				, anyOtherTretmntEquipType
				, chemicalSolidWaste
				, chemicalLiquidWaste
				, discardedLinen
				, otherClininLabWaste
				, contaminatedwaste
				, wasteSharps
				, glassWare
				,metallicBodyImplants
				,isNewApplication,onlineFeeList)
				
			 byte[] b = new byte[(int) certFile.length()];
	        
	        FileInputStream fileInputStream = new FileInputStream(certFile);
	        
	        fileInputStream.read(b);
	 	        def fileLength=certFile.length()
	        	file.size = fileLength / 1024  //f.getSize() 
	 	         file.extension ="pdf"//extractExtension( f )
	 	       	 file.data=b;
	 	       	 file.name="Master Report BMW.pdf"
	 	    	 file.description="Master Report BMW"
	 	    	 file.createdBy=(userMstr).toString()
	 	    	 file.updatedBy=(userMstr).toString()
	 	    	 file.typeOfFile="Master Report BMW"
	 	    	 file.indreg=industryRegMasterInst
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

		
//////////////////////////////////////////////////////////////////


		
		
}	
		
		