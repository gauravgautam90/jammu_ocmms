/**
 * 
 */



/**
 * @author Uday
 *
 */
public class PlasticWaste{

	Long id
	IndustryRegMaster industryRegMasterObj
	String nameOfApplicant
	String authorisationAppliedFor
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	String completionStatus
	String applicationStatus
	String manufactoringCapacity
	
	String unitLocation
	String districtIndustriesCenter
	String detailsDisposalFacility
	String namePlastic
	String quantityPlastic
	String occupationalFacilities
	String emmisionEffulant
	String emmisionEffulantDetails
	String unitCompliance
	String materialProceed
	String materialHandled
	String otherInfor
	String enclosure
	String thiknessRulz
	String waterAct
	String airAct
	String actionPlan
	
	String activityAuthorizationSoughtFor
	String applicationFor
	String authorizationType
	String previousAuthNo
	Date previousAuthDate
	Date prevExpDate
	Date waterValidity
	Date airValidity
	Date authorizationValidity
	boolean clarification
	boolean showCause
	boolean inspection
	boolean isNewApplication
	String scrutinyStatus
	String cafUniqueNo //for single window
	String serviceId
	boolean singleWin
	
	 public PlasticWaste(){
		singleWin=false
		cafUniqueNo=""
		serviceId=""
		scrutinyStatus=""
		nameOfApplicant=""
		authorisationAppliedFor=""
		completionStatus=""
		applicationStatus=""
		manufactoringCapacity=""
			applicationFor=""
		unitLocation=""
		districtIndustriesCenter=""
		detailsDisposalFacility=""
		namePlastic=""
		quantityPlastic=""
		occupationalFacilities=""
		emmisionEffulant=""
		emmisionEffulantDetails=""
		unitCompliance=""
		materialProceed=""
		materialHandled=""
		otherInfor=""
		enclosure=""
		thiknessRulz=""
		waterAct=""
		airAct=""
		actionPlan=""
		
		
		
		activityAuthorizationSoughtFor=""
		authorizationType=""
		previousAuthNo=""
		updatedBy=""
		createdBy=""
		clarification=false;
		showCause=false;
		inspection=false;
		isNewApplication=true;
	}
	
	String toString(){
		"$id"
	}
	static def constraints = {
		previousAuthDate(nullable:true,blank:true)
		applicationFor(nullable:true,blank:true)
				
	}
	
}
