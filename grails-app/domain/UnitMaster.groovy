
public class UnitMaster{
	Long id
	String unitName
	UnitTypeMaster unitType
	String createdBy
	String updatedBy
	Date dateCreated
	Date lastUpdated
	
	String toString(){
	    "$unitName"
		}
	static  constraints = {	
		unitName(blank:false,unique:'unitType')
    }
		
}
