
 class ApplicationTypeMaster{

	Long id
	String consentType
	String description
	String toString(){
		"$consentType"
	}
	static def constrains = {
		
	}
}
