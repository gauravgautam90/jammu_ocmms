class BrickKilnDetailMaster
{
	Long id
	IndApplicationDetails application
	String capacity
	String trenchSize
	String chimeny
	String height
	String ecd
	String cluster
		
	String toString()
	{
		"$id"    
    }
	static def constraints = {}
}