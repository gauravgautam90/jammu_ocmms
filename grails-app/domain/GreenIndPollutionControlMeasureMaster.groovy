class GreenIndPollutionControlMeasureMaster{
		
	Long id
	String controlMeasure
	
	
	String toString(){
          "$controlMeasure"    
	}
    	
	static def constraints = {
		controlMeasure(blank:false,unique:true)
    }
	
	
}
