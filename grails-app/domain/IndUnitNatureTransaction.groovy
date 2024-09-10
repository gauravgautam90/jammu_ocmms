class IndUnitNatureTransaction{
	Long id
	IndustryRegMaster indReg
	UnitNatureMaster unitNature
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}