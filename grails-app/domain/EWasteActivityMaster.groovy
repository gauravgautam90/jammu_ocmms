/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class EWasteActivityMaster{

	Long id
	String activityName
	String activityCode 
	String description
    String toString(){
          "$activityName"
	}
    static def constrains = {
    	activityName(blank:false,unique:true)
    	activityCode(blank:false,unique:true)
	
}
	
}
