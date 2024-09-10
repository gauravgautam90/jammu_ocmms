class FeeBankDetailsBMW{
	Long id
	String ddChequeNo
	String date
	String bankName
	String branch
	float amount
	
	BioMedicalWaste application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}