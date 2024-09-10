class AirEmmisionParameter {
	
	Long id
	String name
	AirEmmisionType type

	String toString(){
          "$name"    
	}
    	static def constraints = {
      
    	}
}
