class IndAirAmbientDetails {
	
	Long id
	AmbientAirQualityStandardMaster ambient
	IndApplicationDetails application
	String toString(){
          "$id"    
         }
	static def constraints = {
		
    	}
}
