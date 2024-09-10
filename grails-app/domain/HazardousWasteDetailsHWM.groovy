/**
 * @author Manish Bhardwaj
 */
public class HazardousWasteDetailsHWM{
	Long id
	HazardeousWasteAuthApp application
	HazardousSourceGenMaster source
	HazardousCategoryMaster category
	String categoryText // textfield value of category save in this and default value assign to category.id is 333330 
	String quantity
	String quantityUnit
	String wasteType
	String wasteStorage
	String wasteStorageOthers
	String wasteDisposal
	String wasteDisposalOthers
	String sourceOfWaste
	String physicalStatus
	String qtyStored
	String qtyStoredUnit // add unit
	String qtyAccumalated
	String qtyAccumalatedUnit
	String authorisationAcivity
	String schedule
	//new field add dd
	//String areaOfLand
	//String accumulatedQty
	//String categoryNameId
	
	
	String toString(){
		
	}
	static def constrains = {
		
	}
	
}
