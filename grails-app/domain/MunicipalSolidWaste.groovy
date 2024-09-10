/**
 * 
 */



/**
 * @author Chaitanya.vishwamoha
 *
 */
public class MunicipalSolidWaste{

	Long id
	IndustryRegMaster indRegMasterObj
	String measuresPrevention
	String measuresSafety
	String measuresPollution
	String authorizationType
	UnitMaster unitMasterobjqtyPro
	UnitMaster unitMasterobjqtyDis
	String nameNodal 
	String desigNodal
	String authApp
	String locationSite
	Long qtyProcessed
	Long invenstment 
	Long expectedReturn
	String nameWasteProcessingTech
	Long numSites
 	Long qtyDisposed
	String natureWaste
	String compWaste
	Date dateCreated
	String createdBy
	boolean clarification
	boolean inspection
	String completionStatus
	Date lastUpdated
	String updatedBy
	String applicationStatus

	String toString(){
	    "$id"
		}
	    static def constraints = {	
	    	
	    
		numSites(nullable:true,blank:true)
		qtyDisposed(nullable:true,blank:true)
		natureWaste(nullable:true,blank:true)
		compWaste(nullable:true,blank:true)
		lastUpdated(nullable:true,blank:true)
	    updatedBy(nullable:true,blank:true)	
	    	
	    }
	
	
}
