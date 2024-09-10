class StoneCrusherWaterReqInspection {
	Long id
	String sourceOfWaterSupply
	String quantity
	
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}