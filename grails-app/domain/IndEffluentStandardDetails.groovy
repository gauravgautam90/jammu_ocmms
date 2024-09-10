class IndEffluentStandardDetails{
	Long id
	EffluentParameterMaster parameter
	EffluentStandardMaster standard
	EffluentTypeMaster type
	String effParameterStandard
	IndApplicationDetails application
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}