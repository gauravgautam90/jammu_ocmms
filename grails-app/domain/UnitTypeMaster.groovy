/**
 * 
 */



/**
 * @author Devendra.Kumar
 *
 */
public class UnitTypeMaster{
	Long id
	String unitTypeName
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
	    "$unitTypeName"
		}
    static  constraints = {	
    	unitTypeName(blank:false,unique:true)
    }
	
	
}
