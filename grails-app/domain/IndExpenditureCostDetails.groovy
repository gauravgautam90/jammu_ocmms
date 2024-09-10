class IndExpenditureCostDetails{
	Long id
	String expenditureProposed
	float capital
	float recurring 
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}