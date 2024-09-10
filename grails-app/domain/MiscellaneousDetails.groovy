class MiscellaneousDetails{
	Long id
	String controlMeasures
	String totalCost
	String dgStInstalled
	String dgSetCapacity
	String AcausticEnclosure
	String noisePollution
	String noiseMeasures
	String presParameters
	String hazardeousSubs
	String nameOfHazardeous
	String quatityOfHazard
	String isHazarSubstanceProduced
	String nameOfHazardWaste
	String quatityOfWaste
	
	
	
	
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}