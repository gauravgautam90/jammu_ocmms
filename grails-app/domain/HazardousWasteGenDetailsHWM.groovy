/* shashank srivastava
 * 
 * 
 */

class HazardousWasteGenDetailsHWM{
	Long id
	HazardeousWasteAuthApp application
	HazardousSourceGenMaster sourceName
	HazardousCategoryMaster categoryName
	String quantity
	String quantityTPA
	UnitMaster unit
	UnitMaster unitTPA
	String otherProcess
	String otherHazardousName
	String stream
	
	public HazardousWasteGenDetailsHWM(){
	    otherProcess=""
		otherHazardousName=""
		stream = ""
	}
	
	String toString(){
		"$id" 
	}
	static def constrains = {
		
	}
}