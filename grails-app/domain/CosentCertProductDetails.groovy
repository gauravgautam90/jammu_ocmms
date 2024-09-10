class CosentCertProductDetails{
	Long id
	String product
	String quantity
	UnitMaster unit
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}