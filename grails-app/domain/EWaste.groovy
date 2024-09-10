
public class EWaste{

	Long id
	IndustryRegMaster industryReg 
	
	Date waterConsFrom
	Date waterConsTo
	Date airConsFrom
	Date airConsTo
	Date authorizationFrom
	Date authorizationTo
	Date regDate
	
	String fugEmission
	String disposal
	String healthAspects
	String adequatePoll
	String indCompliance
	String relInfo
	String completionStatus
	Date dateCreated
	boolean clarification
	boolean inspection
	String applicationStatus
	String authorisationType
	String ewasteIsManufacturerOrRefurbisher
    String chkConsent
    String chkBMW
    String chkHWM
    String chkSWM
    String facilityDetail
    String renewalAuth
	
	String checkBoxButton
	String cafUniqueNo //for single window
	String serviceId
	boolean singleWin
	String toString(){
		"$id"
	}
	
	static mapping = {
    } 
    static def constraints = {
		
	}
	public EWaste(){
		 ewasteIsManufacturerOrRefurbisher=""
		 chkConsent=""
		 chkBMW=""
		 chkHWM=""
		 chkSWM=""
		 facilityDetail=""
		 renewalAuth=""
		 checkBoxButton=""
		 authorisationType=""
		 cafUniqueNo="" 
		 serviceId=""
		 singleWin=false
	}
	
}
