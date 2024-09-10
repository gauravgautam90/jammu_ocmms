/**
 * @author Chaitanya.vishwamoha
 *
 */
public class BioMedicalWaste{

	Long id
	IndustryRegMaster industryRegMasterObj
	String nameOfApplicant
	String nameOfInstitution
	String activityAuthorizationSoughtFor
	String authorizationType
	String previousAuthNo
	Date previousAuthDate
	String nameAddressInstitution
	String addrTreatmentFacility
	String addrPlaceDisposalOfWaste
	String completionStatus
	String modeTrans
	String modeTreat
	String descrip
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	String applicationStatus
	boolean clarification
	boolean inspection
	String condImposedRenew
	String categHAW
	String categAW
	String categMBW
	String categWS
	String categDMCD
	String categSW6
	String categSW7
	String categLW
	String categIA
	String categCW
	String categHAWUnit
	String categAWUnit
	String categMBWUnit
	String categWSUnit
	String categDMCDUnit
	String categSW6Unit
	String categSW7Unit
	String categLWUnit
	String categIAUnit
	String categCWUnit
	Date prevExpDate
	String authorisationAppliedFor
	String hcfType
	String bmwfacility
	String bmwstatus
	String wastelocationaddress
	String wastedisposalplace
	String outpatientsFacility 
	String inpatientsFacility
	String noofbeds
	String other1
	String other2
	String patientspermonth
	String destroyer
	String bmwrules1
	String NoofHCF
	String Jurisdictionalarea
	String authorisationDay
	String authorisationMonth
	String detailapc
	String detailetp
	String quantityperDay
	String quantityperMonth
	String quantityperDay1
	String quantityperMonth1
	String authapply
	String hcfTypeMenu
	String anatomicalwaste
    String animalwaste
    String biowaste
    String wastesharp
    String discardedwaste
    String soiledwaste
    String solidwaste
    String liquidwaste
    String ash
    String chemicalwaste
    String total1
	String paymentDeviation
	String remittedFees
	String statusCteCto
	String latitude
	String longtitude
	String detailsOfDirections
	String noOfNonBeds
	String noOfNonBeds1
	String noOfInOutPatients
	String colorCodedBags
	String noOfBedsCbmwtf
	String treatmentAndDisposal
	String qtyOfBmwTreated
	String contingencyPlan
	String detailsOfTraining
	String incinrators
	String incinratorsType
	String plasmaPyrolysis
	String plasmaPyrolysisType
	String autoclaves
	String autoclavesType
	String microwave
	String microwaveType
	String hydroclave
	String hydroclaveType
	String shredders
	String shreddersType
	String needleTipCutter
	String needleTipCutterType
	String sharpEncapsulation
	String sharpEncapsulationType
	String deepBurial
	String deepBurialType
	String chemDisinfection
	String chemDisinfectionType
	String anyOtherTretmntEquip
	String anyOtherTretmntEquipType
	String chemicalSolidWaste
	String chemicalLiquidWaste
	String discardedLinen
	String otherClininLabWaste
	String contaminatedwaste
	String wasteSharps
	String glassWare
	String metallicBodyImplants
	boolean isNewApplication	
	String cafUniqueNo //for single window
	String serviceId
	boolean singleWin
	
	public BioMedicalWaste(){
		singleWin=false
		cafUniqueNo=""
		serviceId=""
		authorisationAppliedFor = ""
		hcfType= ""
		bmwfacility= ""
		bmwstatus= ""
		wastelocationaddress= ""
		wastedisposalplace= ""
		outpatientsFacility  = ""
		inpatientsFacility = ""
		noofbeds = ""
		other1 = ""
		other2 = ""
		patientspermonth = ""
		destroyer = ""
		bmwrules1 = ""
		NoofHCF = ""
		Jurisdictionalarea = ""
		authorisationDay = ""
		authorisationMonth = ""
		detailapc = ""
		detailetp = ""
		quantityperDay = ""
		quantityperMonth = ""
		quantityperDay1 = ""
		quantityperMonth1 = ""
		authapply = ""
		hcfTypeMenu = ""
		anatomicalwaste = ""
		animalwaste = ""
		biowaste = ""
	    wastesharp = ""
	    discardedwaste = ""
	   	soiledwaste = ""
	    solidwaste = ""
	   	liquidwaste = ""
	   	ash = ""
	    chemicalwaste = ""
	    total1 = ""
		paymentDeviation = ""
		remittedFees = ""
		statusCteCto = ""
		latitude = ""
		longtitude = ""
		detailsOfDirections = ""
		noOfNonBeds = ""
		noOfNonBeds1 = ""
		noOfInOutPatients = ""
		colorCodedBags = ""
		noOfBedsCbmwtf = ""
		treatmentAndDisposal = ""
		qtyOfBmwTreated = ""
		contingencyPlan = ""
		detailsOfTraining = ""
		incinrators = ""
		incinratorsType = ""
		plasmaPyrolysis = ""
		plasmaPyrolysisType = ""
		autoclaves = ""
		autoclavesType = ""
		microwave = ""
		microwaveType = ""
		hydroclave = ""
		hydroclaveType = ""
		shredders = ""
		shreddersType = ""
		needleTipCutter = ""
		needleTipCutterType = ""
		sharpEncapsulation = ""
		sharpEncapsulationType = ""
		deepBurial = ""
		deepBurialType = ""
		chemDisinfection = ""
		chemDisinfectionType = ""
		anyOtherTretmntEquip = ""
		anyOtherTretmntEquipType = ""
		chemicalSolidWaste = ""
		chemicalLiquidWaste = ""
		discardedLinen = ""
		otherClininLabWaste = ""
		contaminatedwaste = ""
		wasteSharps = ""
		glassWare = ""
		metallicBodyImplants = ""
		isNewApplication= false;
		addrPlaceDisposalOfWaste = ""
		addrTreatmentFacility = ""
		authorizationType = ""
		categAW = ""
		categAWUnit = ""
		categCW = ""
		categCWUnit = ""
		categDMCD = ""
		categDMCDUnit = ""
		categHAW = ""
		categHAWUnit = ""
		categIA = ""
		categIAUnit = ""
		categLW = ""
		categLWUnit = ""
		categMBW = ""
		categMBWUnit = ""
		categSW6 = ""
		categSW6Unit = ""
		categSW7 = ""
		categSW7Unit = ""
		categWS = ""
		categWSUnit = ""
		descrip = ""
		modeTrans = ""
		modeTreat = ""
		nameAddressInstitution = ""

		
	}
			
	String toString(){
		"$id"
	}
	
	
	static belongsTo = [industryRegMasterObj:IndustryRegMaster]
	   static mapping = {
			//id generator:'assigned'
				industryRegMasterObj lazy : false
		}
	static def constraints = {
		previousAuthDate(nullable:true,blank:true)
		
				
	}
	
	
}
