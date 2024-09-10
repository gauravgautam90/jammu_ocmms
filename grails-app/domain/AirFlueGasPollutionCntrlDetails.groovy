class AirFlueGasPollutionCntrlDetails{
	Long id
	AirStackDetails stack
	AirEmiControlMeasureMaster pollutionCntrlMeasure
	
	
	String toString(){
		"$id"
	}
	static def constrains = {
		
	}
}