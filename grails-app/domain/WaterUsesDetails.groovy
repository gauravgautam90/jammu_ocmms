class WaterUsesDetails {
	Long id
	WaterSourceMaster source
	WaterUsesMaster use
	float quantity
	IndApplicationDetails application
	String sourceName
	
	String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}