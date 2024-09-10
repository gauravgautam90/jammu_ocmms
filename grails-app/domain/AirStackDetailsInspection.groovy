/**
 * 
 */



/**
 * @author Richa
 *
 */
public class AirStackDetailsInspection{
	Long id
	IndApplicationDetails application
	String stack
	String heightGrdLevel
	String heightFacLevel
	String draftType
	String matOfCon
	String capacity
	UnitMaster unit
	String fuelTyp
	String fuelQty
	String gasQty
	String shape
	String diamSize
	String gasTemp
	String gasVel
	
	String toString(){
		"$stack"
	}
	static def constrains = {
		
	}
}
