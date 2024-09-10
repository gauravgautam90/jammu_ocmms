class HazardousCategoryMaster{
	Long id
	String name
	String category
	HazardousSourceGenMaster sourceName
	String toString(){
		"$name"
	}
	static def constraints = {
		name(blank:false,unique:true)
	}
}