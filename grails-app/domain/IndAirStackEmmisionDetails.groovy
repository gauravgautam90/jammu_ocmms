class IndAirStackEmmisionDetails {
	
	Long id
	String stackToPlant
	String sourceCapacity
	AirEmmisionUnitMaster sourceUnit
	AirEmmisionParameter parameter
	String prescribedStandards
	String height
	IndApplicationDetails application
	String toString(){
          "$id"    
         }
	static def constraints = {
		
    	}
}
