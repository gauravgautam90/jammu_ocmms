/**
 * 
 */



/**
 * @author robin.soni
 *
 */
public class CessReturn{

	Long id
	IndustryRegMaster industryReg //FK
//	String month
//	String year
	int firstDayReading
	int lastDayReading
	int totunitOfWaterConsumption
	int threeMonthsAvgWaterConsumption
	int totQuantityOfWaterConsumed
	int totQuantityOfWaterRebate
	String completionStatus
	String applicationStatus
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	boolean assessmentIssue
	boolean assessmentOrder
	boolean fees
	boolean feesNotice
	boolean inspection
	boolean inspectionClose
	Date cessAppliedFromDate
	Date cessAppliedToDate
	
	String toString(){
		"$id"
	}
	
	static mapping = {
    } 
    static def constraints = {
		
	}
	
}
