class IndAirFuelDetails {
	
	Long id
	AirEmmisionFuelMaster fuel
	AirEmmisionFuelTypeMaster fuelType
	String fuelQuantity
	AirEmmisionUnitMaster quantUnit
	String capacity
	AirEmmisionUnitMaster capacityUnit
	IndApplicationDetails application
	String toString(){
          "$id"    
         }
	static def constraints = {
		
    	}
}
