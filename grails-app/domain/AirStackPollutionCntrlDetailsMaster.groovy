/**
 * 
 */



/**
 * @author Richa
 *
 */
public class AirStackPollutionCntrlDetailsMaster{
	Long id
	AirStackDetailsMaster stack
	AirEmiControlMeasureMaster pollutionCntrlMeasure
	
	
	String toString(){
		"$id"
	}
	static def constrains = {
		
	}
}
