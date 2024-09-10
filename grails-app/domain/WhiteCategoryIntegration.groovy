
/**
 * @author Mithilesh
 *
 */
public class WhiteCategoryIntegration{
	long id
	String noOfWorkers
	String undertaking
	IndustryRegMaster indUser
	Date dateOfCreated
	Date dateOfLastUpdated
	boolean completionStatus
	String createdBy
	String updatedBy
	String pollutionMeasures  // Added By DEEPAK
	String aadharNo   // Added By DEEPAK
	String serialNo    // Added By DEEPAK
	String product
	String quantity
	String electricityLoad
	
	
	String toString(){
		"$id"
	}
	public WhiteCategoryIntegration(){
		noOfWorkers=""
		undertaking=""
		dateOfCreated=new Date()
		dateOfLastUpdated=new Date()
		completionStatus=false
		pollutionMeasures=""
		aadharNo=""
		serialNo=""
			product=""
			quantity=""
			electricityLoad=""
			
		
		
	}
}
