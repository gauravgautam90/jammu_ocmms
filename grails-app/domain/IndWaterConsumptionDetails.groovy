class IndWaterConsumptionDetails {
	Long id
	WaterConModeMaster consumptionMode
	String consumptionQuantity
	WaterGenModeMaster generationMode
	String generationQuantity
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}