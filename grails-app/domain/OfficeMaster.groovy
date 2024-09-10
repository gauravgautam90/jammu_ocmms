class OfficeMaster{
	Long id
	String officeName
	int priority
	String toString(){
		"$officeName"
	}
	static def constraints = {
		officeName(blank:false,unique:true)
		priority(blank:false,unique:true)
	}
}