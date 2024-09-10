class IndApplicationDetails{
	Long id
	IndustryRegMaster indUser    // FK of IndustryRegMaster
	String applicationType
	String applicationFor
	Date applicationDate
	String applicationName
	String certificateFor
	String completionStatus
	String annualProdCap
	String noOfStack
	boolean clarification
	boolean inspection
	Date actualApplicationDate
	
	String hazardeousType
	String cafUniqueNo //for single window
	String serviceId
	boolean singleWin
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
    public IndApplicationDetails(){
		cafUniqueNo=""
		serviceId=""
		singleWin=false
	}
}
