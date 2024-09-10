class FeeBankDetails{
	Long id
	String ddChequeNo
	String date
	String bankName
	String branch
	float amount
	IndApplicationDetails application
	String additionalfee
	
	public FeeBankDetails()
	{
	additionalfee="NO"
	}
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}