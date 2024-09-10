class IndWaterDischargeDetails {
	Long id
	WaterDisTypeMaster dischargeType
	String maxEffluentGen
	String effluentRecycled
	String effluentDisposed
	WaterDisModeMaster disposalMode
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}