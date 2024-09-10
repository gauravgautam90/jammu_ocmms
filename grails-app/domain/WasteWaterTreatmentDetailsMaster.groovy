/**
 * 
 */



/**
 * @author Richa
 *
 */
public class WasteWaterTreatmentDetailsMaster{
	Long id
	WaterWasteTreatmentCategoryMaster category
	String treatmentUnits
	String capacity
	IndApplicationDetails application
	String uses
	float effluentGeneration
	String treatmentArrangementStatus
	String monitoringArrangementDetails
	String treatedEffluentQuality
	String parametersQuantity
	String investmentInTreatmentUnit
	String parametersQuantityTreated
	String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}
