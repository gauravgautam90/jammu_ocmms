/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class Lab_WaterEffluentMonitoring{

	Long id
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	Date sampleDate
	String samplerName
	String otherFieldPeople
	String location
	String sampleType
	int subSampleVolume
	int pH
	int TC
	int conductivity
	int dO_ppm
	int CL
	String comment
	String fieldConditions
	String pHCheck
	String additionalPreservativeUsed
	String otherObservations
	String remarks
	String completionStatus
	String applicationStatus
	boolean generateReport
	
	
	
	String toString(){
		"$id"
	}
	static def constraints = {
		
	}
}
