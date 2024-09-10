class EcCrzDetails{
	Long id
	String licenceNo
	String industryName
	String ecNo
	String issueDate
	String type
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    	ecNo(nullable:true)
    	issueDate(nullable:true)
    }
}