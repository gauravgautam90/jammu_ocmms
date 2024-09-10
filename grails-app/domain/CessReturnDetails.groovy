/**
 * 
 */



/**
 * @author robin.soni
 *
 */
public class CessReturnDetails{

	Long id
	CessWaterConsumptionPurposeMaster waterConsumptionPurposeMaster
	CessSourceConsumptionMaster waterSourceConsumptionMaster
	CessReturn cessReturn
	String meterWorking
	int startReading 
	int endReading 
	int quantity
	int threeMonthWaterQtyAvg
	int qtyForWaterRebate
	String remarks
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	String toString(){
		"$id"
	}
	
	static mapping = {
    } 
    static def constraints = {
		
	}
	
	
	
}
