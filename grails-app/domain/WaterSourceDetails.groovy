class WaterSourceDetails {
	Long id
	WaterSourceMaster source
	float quantity
	String sourceName
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}