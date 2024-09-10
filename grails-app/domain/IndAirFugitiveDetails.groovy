class IndAirFugitiveDetails {
	
	Long id
	String sourceFugEmmision
	AirEmmisionParameter parameter
	String prescribedStand
	IndApplicationDetails application
	String toString(){
          "$id"    
         }
	static def constraints = {
		
    	}
}
