/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class ConditionMaster{
	
	Long id
	IndustryTypeMaster industryTypeMaster
	ApplicationTypeMaster applicationTypeMaster
	String consentFor
	String conditionType
	String applicationFor
	String condition
	Date dateCreated
 	String createdBy
 	Date lastUpdated
 	String updatedBy
	String toString(){
	    "$condition"
		}
	    static def constraints = {	
	    	industryTypeMaster(blank:false)
	    	applicationTypeMaster(blank:false)
	    	consentFor(blank:false)
	    	conditionType(blank:false)
	    	applicationFor(blank:false)
	    	condition(blank:false)
	    	createdBy(nullable:false)
	    	updatedBy(nullable:false)
	    	
	    }
	

	
	
}
