class ConsentFeeMasterBMW{
	Long id
	BioMedicalWaste application
	Long noOfYears 
	float calculatedFee
	float lateFees // Added by deepak
	float addFees //Added by deepak
	float totalFees //Added by deepak
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
    
    public ConsentFeeMasterBMW(){
		//catDetails = ""
		//category = ""
		lateFees = 0;
		addFees = 0;
		totalFees = 0;
}
}