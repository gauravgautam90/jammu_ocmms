class DGSetEmissionDetailsMaster
{
	Long id
	IndApplicationDetails application
	String source
	String horsePower
	String noLoadRPM
	String fullLoadRPM
	String fuelQuantity
	String capacity
	String buildingHeight
	String stackHeight
	String totalHeight
		
	String toString()
	{
		"$id"    
    }
	static def constraints = {}
}