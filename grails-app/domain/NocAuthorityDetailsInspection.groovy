class NocAuthorityDetailsInspection{
	Long id
	String authorityDetails
	String status
	String number
	String date
	
	
	
	
	
	IndApplicationDetails application
	
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}