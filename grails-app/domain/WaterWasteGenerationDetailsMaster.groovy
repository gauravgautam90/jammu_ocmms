/**
 * 
 */



/**
 * @author Richa
 *
 */
public class WaterWasteGenerationDetailsMaster{
	Long id
	String disposalMode
	String typeOfEffluent
	IndApplicationDetails application
	float maxGeneration
	float effRecycle
	float effDischarge
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}
