class DepartmentMaster{
	
	Long id
	String depName
	String toString(){
		"$depName"
	}
		static def constraints = {
			
			depName(blank:false)
			
		}
		
	
}