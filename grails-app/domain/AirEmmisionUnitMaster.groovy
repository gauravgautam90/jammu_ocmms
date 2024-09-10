class AirEmmisionUnitMaster{
	Long id
	String unitName
	AirEmmisionType type
	
	String toString(){
		"$unitName"
	}
	static def constrains = {
		
	}
}