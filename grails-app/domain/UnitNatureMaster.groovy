class UnitNatureMaster{
	Long id
	String unitName
	String toString(){
          "$unitName"    
	}
    static def constraints = {
    	unitName(blank:false,unique:true)
    }
}