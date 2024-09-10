class WaterConsumptionDetailMaster {
	Long id
	String waterConsumptionType
	String quantity
	String storageFacility
	
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}