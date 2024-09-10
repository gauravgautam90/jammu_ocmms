class IndAirStackEmmision{
	
	Long id
	String stackAttachedToPlant
	String sourceCapacity
	String srcCapacityUnit
	Long height
	String stackMoniter
	String fuelType
	String fuelName
	String fuelQty
	String qtyUnit
	String fuelCapacity
	String fuelCapacityUnit
	String applicationId     // FK IndApplicationDetail

     	String toString(){
          "$id"    

    	}
    	static def constraints = {
      
    	}
}
