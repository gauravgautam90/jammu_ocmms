
class SurroundingMaster {
	Long id
	String surroundingName
	
	
	String toString(){
		"$surroundingName"
}
	static def constraints = {
		surroundingName(blank:false)
	}
}