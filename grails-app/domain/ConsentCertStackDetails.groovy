class ConsentCertStackDetails {
	Long id
	IndApplicationDetails application
	String stackAttachedTo
	String stackVolume
	String stackHeight
	String topDiameter
	String velocityOfGasEmission
	String pollutionCntrlMeasure
	String typeOfFuel
	String maximumQuantity
	UnitMaster unit
	
	
	String toString(){
		"$id"
	}
	static def constrains = {
		
	}
}