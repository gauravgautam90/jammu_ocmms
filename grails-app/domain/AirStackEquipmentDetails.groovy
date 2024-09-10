class AirStackEquipmentDetails{
	Long id
	IndApplicationDetails application
	AirStackDetails stack
	AirEmiControlMeasureMaster equipment
	String state
	String redEfficiency
	String quantity
	UnitMaster unit
	String quality
	String monitoring
	String pollutant
	String installation
	
	
	
	String toString(){
		"$equipment"
	}
	static def constraints = {
		equipment(unique:'stack')

		
	}
}