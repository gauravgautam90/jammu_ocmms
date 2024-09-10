class ConsentFeeMasterHWM{
	Long id
	HazardeousWasteAuthApp application
	Long noOfYears 
	float calculatedFee
	float lateFees
	float addFees
	float totalFees
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
    public ConsentFeeMasterHWM(){
		lateFees = 0;
		addFees = 0;
		totalFees = 0;
}
}