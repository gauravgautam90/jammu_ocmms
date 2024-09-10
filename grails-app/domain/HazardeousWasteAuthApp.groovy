import java.util.List
/**
 * 
 */



/**
 * @author Vinamra.Mishra
 *
 */
class HazardeousWasteAuthApp{
	//////////////////////////////////////start/////////////////////////////////
	
	
	
	String sourceAndWasteChar
	String hazardChemicalRules
	String publicLiability
	String handlingQuantity
	String importingHazardChemicals
	String recycleHazard
	String statusOfRecycle
	String registerRecyclerDetails
	String importHazard
	String statusOfImport
	
	
	
	String generatinghazardous
	String generatinghazardousname
	String generatinghazardousquantity
	String situatedcritically
	
	
	String Locofsite
	String protechnology
	String Dprotechnology
	String Typewasteprocessed
	String Quantitywasteprocessed
	String Methodofdisposalbrief
	String Quantityofwaste
	String Naturencomposition
	String Methodologynoperational
	String Measurestakenprevention
	String InvestmentProject
	String ExpectedreturnsProject
	String workingplant
	String is_transporters
	String transporterSource
	String transporterDestination
	Date regDate
	Date expDate
	String passNo
	String authorQty
	String issuedBy
	

	String isHandlerGenerator
	String isGenerator
	String isTSDFOperator
	String isRecyclerOrUsers
	String manufacturingProcess
	String prouctsManufactured
	String generatedWastes
	String storageCapacity
	String treatmentProcesses
	String securedLandfills
	String detailOfIncineration
	String treatmentSystem
	String fireFightingSystems 
	String environmentalManagementPlan
	String transportation
	String otherActivities
	String installedCapacity
	String processDescription
	String securedStorage
	String endUsers
	String pollutionControlSystems
	String safetyMeasures
	String complianceWithGuidelines
	String transportationUsers	
	String impHazard
	String Hazardouswastegen
	String Auhorisation_status
	String industrywork
	String statusofauthorisation
	String insurance_act
	String storageDisposalFacility
    boolean isNewApplication
	///////////////////////////////////////////end////////////////////////

	Long id
	IndustryRegMaster industryRegMasterObj
	String completionStatus
	String location_Of_Activity
	String authorization_Required_For
	String is_Renew
	String auth_Renew_No
	Date auth_Renew_Date
	String hw_Defined
	String createdBy
	String updatedBy
	Date dateCreated
	boolean clarification
	boolean inspection
	String applicationStatus
	Long expectedReturn
	String cafUniqueNo //for single window
	String serviceId
	boolean singleWin
	
	public HazardeousWasteAuthApp(){
		singleWin=false
		cafUniqueNo=""
		serviceId=""
		isHandlerGenerator=""
		isGenerator=""
		isTSDFOperator=""
		isRecyclerOrUsers=""
		manufacturingProcess=""
		prouctsManufactured=""
		generatedWastes=""
		storageCapacity=""
		treatmentProcesses=""
		securedLandfills=""
		detailOfIncineration=""
		treatmentSystem=""
		fireFightingSystems =""
		environmentalManagementPlan=""
		transportation=""
		otherActivities=""
		installedCapacity=""
		processDescription=""
		securedStorage=""
		endUsers=""
		pollutionControlSystems=""
		safetyMeasures=""
		complianceWithGuidelines=""
		transportationUsers	=""
		impHazard=""
		Hazardouswastegen=""
		Auhorisation_status=""
		industrywork=""
		statusofauthorisation=""
		insurance_act=""
		storageDisposalFacility=""
	    isNewApplication=false
	    
	    sourceAndWasteChar=""
		hazardChemicalRules=""
		publicLiability=""
		handlingQuantity=""
		importingHazardChemicals=""
		recycleHazard=""
		statusOfRecycle=""
		registerRecyclerDetails=""
		importHazard=""
		statusOfImport=""
		generatinghazardous=""
		generatinghazardousname=""
		generatinghazardousquantity=""
		situatedcritically=""
		Locofsite=""
		protechnology=""
		Dprotechnology=""
		Typewasteprocessed=""
		Quantitywasteprocessed=""
		Methodofdisposalbrief=""
		Quantityofwaste=""
		Naturencomposition=""
		Methodologynoperational=""
		Measurestakenprevention=""
		InvestmentProject=""
		ExpectedreturnsProject=""
		workingplant=""
		is_transporters=""
		transporterSource=""
		transporterDestination=""
		regDate=new Date();
		expDate=new Date();
		passNo=""
		authorQty=""
		issuedBy=""
 
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
		
		auth_Renew_No(blank:true,nullable:true)
		auth_Renew_Date(blank:true,nullable:true)
		updatedBy(blank:true,nullable:true)
		
		authorQty(blank:true,nullable:true)
		handlingQuantity(blank:true,nullable:true)
		updatedBy(blank:true,nullable:true)
		hazardChemicalRules(blank:true,nullable:true)
		importingHazardChemicals(blank:true,nullable:true)
		auth_Renew_No(blank:true,nullable:true)
		insurance_act(blank:true,nullable:true)
		issuedBy(blank:true,nullable:true)
		passNo(blank:true,nullable:true)
		registerRecyclerDetails(blank:true,nullable:true)
		storageDisposalFacility(blank:true,nullable:true)
		transportation(blank:true,nullable:true)
		treatmentProcesses(blank:true,nullable:true)
		installedCapacity(blank:true,nullable:true)
		manufacturingProcess(blank:true,nullable:true)
		processDescription(blank:true,nullable:true)
		
		
		
		
	}
	
}

