class IndEmmisionCntrlDetails {
	
	Long id
	AirEmmisionControlMeasures cntrlMeasures
	AirEmmisionType type
	IndApplicationDetails application
	String toString(){
          "$id"    
         }
	static def constraints = {
		
    }
}
