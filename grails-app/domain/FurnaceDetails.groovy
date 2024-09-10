class FurnaceDetails{
	Long id
	String furnaceInstalled
	String furnaceName
	String prescribedParameters
	String airPollControlDevicefurnace
	String stackHeight
	String typeOfFuel
	String quantity
	String unit
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}