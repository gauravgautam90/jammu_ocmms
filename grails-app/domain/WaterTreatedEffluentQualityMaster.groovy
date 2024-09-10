class WaterTreatedEffluentQualityMaster{

	Long id
	String quality
	
	String toString(){
		"$quality"
}
	static def constraints = {
		quality(blank:false)
	}
	
}
