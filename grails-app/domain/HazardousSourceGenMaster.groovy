class HazardousSourceGenMaster{
	Long id
	String name
	String schedule
	String toString(){
		"$name" 
		
	}
	
	static def constraints = {
		name(blank:false,unique:true)
	}
}