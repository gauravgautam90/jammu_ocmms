class HazardousWasteGeneraDetails{
	Long id
	String authFor
	IndApplicationDetails application
	HazardousSourceGenMaster sourceName
	HazardousCategoryMaster categoryName
	String cate
	String quantity
	String unit
	String otherSource
	String quantityTPA
	String store
	String dispo
	String exist
	String propo
	String totalaftr
	
	
	String toString(){
		
	}
	static def constrains = {
		authFor(blank:false)
	}
}