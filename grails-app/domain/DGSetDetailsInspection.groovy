class DGSetDetailsInspection
{
	Long id
	IndApplicationDetails application
	String makeDGset
	String modelDGset
	String powerRating
	String soundLevel
	String location
	String loadShedding
	String sheddingInfo
	String noise
	String room
	String exhaustGas
	String installation
	String minVibration
	String minLeaks

	
	String fuel
	String stackHeight
	int heightOfBuilding
	Float totalHeight
		
	String toString()
	{
		"$id"    
    }
	static def constraints = {}
}