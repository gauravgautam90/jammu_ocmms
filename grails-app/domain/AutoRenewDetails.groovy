/**
 * 
 */



/**
 * @author shashank srivastava
 *
 */
public class AutoRenewDetails{
	Long id
	String feeApplicable
	String oldApplicationDate	
	String consentOrderNo
	String lastConsentGranted             
	Date consentDate       
	Date validUpto         
	String startDate
	String endDate
	String oldApplicationId
	
	String noOfYear                    //12 COLUMNS ADDED BY DEEPAK KUMAR
	String noIncreaseProduction 
	String noSewageTradeEffluent
	String noIncreaseStacksEmission
	String noChangeManagementOwnership
	String noIncreaseProductionOverconsented
	String noCasePending
	String devicesInstalled
	String consentConditions
	String failure
	String abide 
	String oldApp       // END
	IndApplicationDetails application
	String toString(){
          "$id"    
	}

	
}
