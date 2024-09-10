class DgParameterMaster {
	Long id
	String parameterDG
	
    String toString(){
        "$parameterDG"    
    }
    	static def constrains = {
    		parameterDG(blank:false)
    	}
}