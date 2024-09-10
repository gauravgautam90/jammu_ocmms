
public class RegularInspectionRaised{

    Long id
	IndApplicationDetails application
	GroupMaster group  // added for MIS of generated inspection List
    boolean inspectionRaised
    String month
    String year
    Date inspectionClosedDate
    Long industryTypeId
    String category
    String officerName
    String officerId  // add new 06/07/2016
    
    String toString(){
       "$id"
    }
    
}