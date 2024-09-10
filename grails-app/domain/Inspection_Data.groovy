class Inspection_Data {

    Long id
	Long application_id
	Long app_pending_details_id
	String lat_long
	String pending_with_id
	Long role_id
	String inspection_report
    byte[] image1
	byte[] image2
	byte[] image3
//	byte[] image4
	Date date_created
	String image1_url
	String image2_url
	String image3_url
	
	String toString(){
		"$id"
	}
    
	
	
}