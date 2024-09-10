class FeeBankDetailsOfficer{
	Long id
	String ddChequeNo
	String date
	String fromDate
	String toDate
	String bankName
	String branch
	float amount
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}