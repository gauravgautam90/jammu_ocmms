class CosentCertHotelDetails{
	Long id
	String product
	String quantity
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}