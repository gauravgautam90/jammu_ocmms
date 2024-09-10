class BoilerDetails{
	Long id
	String boilerInstalled
	
	String boilerName
	String streamCapacity
	String airPollControlDeviceBoiler
	String stackHeight
	String samplingPlatform
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}