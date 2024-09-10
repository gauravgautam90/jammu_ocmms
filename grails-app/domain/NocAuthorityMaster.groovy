class NocAuthorityMaster{
		
	Long id
	String authority
	
	
	String toString(){
          "$authority"    
	}
    	
	static def constraints = {
		authority(blank:false,unique:true)
    }
	
	
}
