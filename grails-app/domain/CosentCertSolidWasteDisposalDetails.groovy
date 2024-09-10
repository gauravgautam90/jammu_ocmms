class CosentCertSolidWasteDisposalDetails{
	Long id
	String typeofWaste
	String quantity
	WaterDisposalModeMaster disMode
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}