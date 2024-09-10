class InspectionFwdNotice{
    Long id
	RoleMaster role
    UserMaster user
    IndApplicationDetails application
    boolean active
    String inspectionNote
    int noOfDays
    Date dateCreated
    String noticeType
    String reasonToChooseOfficer
    String typeOfInspection // Regular Inspection OR Fresh Inspection  
    boolean regularInspectionAssigned
    
    String toString(){
       "$id"
    }
    
	static mapping = {
		reasonToChooseOfficer defaultValue: "' '"
		regularInspectionAssigned : "false"
    } 

}