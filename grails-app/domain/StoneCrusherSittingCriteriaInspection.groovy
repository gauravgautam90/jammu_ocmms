class StoneCrusherSittingCriteriaInspection
{
	Long id
	IndApplicationDetails application
	StoneCrusherParameterMaster parameter
	String distance
		
	String toString()
	{
		"$id"    
    }
	static def constraints = {}
}