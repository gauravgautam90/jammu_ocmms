/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class SampleHandover{

	Long id
	GroupMaster groupMasterInstance
	String sourceOfSample
	IndustryRegMaster indUser
	String description
	Date handoverDate
	String sampleId
	String sampleType
	
	String toString(){
        "$id"    
	}
  static def constraints = {
  }
	
}
