/**
 * 
 */



/**
 * @author Administrator
 *
 */
public class EWasteWaterDischargeDetails{

Long id
	
	//WaterUsesMaster use
	float quantity
	String location
	String parameter
	String otherParameter
	
	EWaste application
	
	String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
	
}
