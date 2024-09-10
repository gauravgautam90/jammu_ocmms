class WaterModeUseDetailsMaster {
	Long id
	WaterSourceMaster source
	WaterModeUseMaster modeUse
	float quantity
	float wasteWaterGenerated
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}