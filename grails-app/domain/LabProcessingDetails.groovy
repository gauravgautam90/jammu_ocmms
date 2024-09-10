/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class LabProcessingDetails{

	Long id
	Date dateCreated
	Date lastUpdated
	RoleMaster role
	String officer
	RoleMaster roleFwd
	String officerFwd
	String fileNote
	boolean generateReport
	String generateReportNote
	boolean finish
	boolean attachedFile
	String finishNote
	String idOfSample
	String sampleType
	String toString(){
        "$id"
         }
	static def constraints = {
      }
	
}
