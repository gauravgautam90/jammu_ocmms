class ConsentFeeMaster{
	Long id
	IndApplicationDetails application
	Long noOfYears
	float calculatedFee
	float totalApplicableFee
	float outstandingDueInd
	float outstandingDueBrd
	Long noOfYearsadditionalYears
	float lateFees
	float addFees
	float totalFees
	
public ConsentFeeMaster(){
		
	//	consentFee = 0;
	//	inspectionFee = 0;
		lateFees = 0;
		addFees = 0;
		totalFees = 0;
		
	}
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
    static mapping = {
    	noOfYearsadditionalYears defaultValue:0
			
		}
}