
class IndTypeMaster{
	Long id
	String name
	String description
	Long min
	Long max
	String toString(){
		"$name"
	}
	static def constrains = {
		name(blank:false,unique:true)
	}
	
}