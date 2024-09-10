/**
 * 
 */



/**
 * @author Ashish
 *
 */
public class SurpriseInspectionFwdNotice{
    Long id
	RoleMaster role
    UserMaster user
    IndustryRegMaster industry
    boolean active
    String inspectionNote
    int noOfDays
    Date dateCreated
    String noticeType
    boolean isAttending
    String reasonToChooseOfficer
    boolean surpriseInspectionAssigned

    String toString(){
       "$id"
    }
    
    static mapping = {
		reasonToChooseOfficer defaultValue: "' '"
			surpriseInspectionAssigned : "false"
    } 

}
