class FeeBankDetailsMaster{
	Long id
	String ddChequeNo
	String date
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