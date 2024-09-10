/**
 * 
 */



/**
 * @author Richa
 *
 */
public class AirFlueGasPollutionCntrlDetailsMaster{
	Long id
	AirStackDetailsMaster stack
	AirEmiControlMeasureMaster pollutionCntrlMeasure
	
	
	String toString(){
		"$id"
	}
	static def constrains = {
		
	}
}
