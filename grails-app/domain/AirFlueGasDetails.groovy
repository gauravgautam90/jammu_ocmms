class AirFlueGasDetails{
	Long id
	IndApplicationDetails application
	AirStackDetails stack
	String fuel
	String consumption
	UnitMaster unit
	String calorValue
	String ashCon
	String sulphurCon
	String otherCon
	
	String toString(){
		"$stack"
	}
	static def constrains = {
		
	}
}