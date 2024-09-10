class FeeBankBMWDetailsOfficer{
	Long id
	String ddChequeNo
	String date
	String fromDate
	String toDate
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