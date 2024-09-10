class FeeBankDetailsHWM{
	Long id
	String ddChequeNo
	String date
	String bankName
	String branch
	float amount
	
	HazardeousWasteAuthApp application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}