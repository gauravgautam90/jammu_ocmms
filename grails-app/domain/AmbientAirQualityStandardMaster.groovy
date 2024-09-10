class AmbientAirQualityStandardMaster{
	Long id
	String areaCategory
	String spm
	String so2
	String co
	String nox
	String noiseDay
	String noiseNight
	String rspm
	
	String toString(){
		"$areaCategory"
	}
	static def constraints = {
		areaCategory(blank:false)
		
	}
}