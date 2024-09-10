class DesignationMaster {
	
	Long id
	String designation
	DepartmentMaster department
	
	String toString(){
		"$designation"
	}
	static def constraints = {
		designation(blank:false,unique:'department')
		department(blank:false)
		
	}
}