/**
 * 
 */



/**
 * @author Richa
 *
 */
public class AirFlueGasDetailsMaster{
	Long id
	IndApplicationDetails application
	AirStackDetailsMaster stack
	String fuel
	String consumption
	UnitMaster unit
	String calorValue
	String ashCon
	String sulphurCon
	String otherCon
	
	String toString(){
		"$stack"
	}
	static def constrains = {
		
	}
}
