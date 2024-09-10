/**
 * 
 */



/**
 * @author Richa
 *
 */
public class AirStackPollutionCntrlDetailsMasterInspection{
	Long id
	AirStackDetailsInspection stack
	AirEmiControlMeasureMaster pollutionCntrlMeasure
	
	
	String toString(){
		"$id"
	}
	static def constrains = {
		
	}
}
