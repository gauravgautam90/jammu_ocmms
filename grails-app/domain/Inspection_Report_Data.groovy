/**
 * @author VINEET RAGHAV
 *
 */
public class Inspection_Report_Data{

	Long id
	IndApplicationDetails application_id
    String indId
    String indName
    String indAddress
    String district
    String category
    String scale
    String indType
    String operationalStatus
    String typeVisit
    String visitDate
    String contactedPerson
    String desContactedPerson
    String mobNoContactedPerson
    String emaiidContactedPerson
    String visitingOffDetails
    String manuProcess
    String arrangementUntreatedEffluent 
    String otherObservations
	
	String toString(){
		"$id"
	}
    
}
