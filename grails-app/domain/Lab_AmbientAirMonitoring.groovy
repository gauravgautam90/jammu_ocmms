/**
 * 
 */



/**
 * @author Robin.Soni
 *
 */
public class Lab_AmbientAirMonitoring{

	Long id
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	String samplingStation
	Date dateOfSample
	String shift
	int totalSamplingTime
	int powerFailure
	int initialFlowRateOfManometer
	int finalFlowRateOfManometer
	int averageFlowRateOfManometer
	int initialAtmosphericPressure
	int finalAtmosphericPressure
	int averageAtmosphericPressure
	int ambientTemperatureFirstHour
	int ambientTemperatureSecondHour
	int ambientTemperatureThirdHour
	int ambientTemperatureFourthHour
	int ambientTemperatureFifthHour
	int ambientTemperatureSixthHour
	int ambientTemperatureSeventhHour
	int ambientTemperatureEighthHour
	int wtOfBlankFilterPaper
	int wtOfFilterAndSample
	int wtOfParticulateMatter
	int particulateMatterConcentration
	
	int flowRateOfRotameter
	int netSamplingTime
	int totalVolumeInIts
	String horizons
	int oneSO
	int twoSO
	int oneNox
	int twoNox
	
	int relativeHumOneHour
	int relativeHumTwoHour
	int relativeHumThirdHour
	int relativeHumFourthHour
	int relativeHumFifthHour
	int relativeHumSixthHour
	int relativeHumSeventhHour
	int relativeHumEighthHour
	
	int windSpeedOneHour
	int windSpeedTwoHour
	int windSpeedThirdHour
	int windSpeedFourthHour
	int windSpeedFifthHour
	int windSpeedSixthHour
	int windSpeedSeventhHour
	int windSpeedEighthHour
	
	String windDirectionOneHour
	String windDirectionTwoHour
	String windDirectionThirdHour
	String windDirectionFourthHour
	String windDirectionFifthHour
	String windDirectionSixthHour
	String windDirectionSeventhHour
	String windDirectionEighthHour
	
	String remarks
	String windPattern
	String variations
	
	String completionStatus
	String applicationStatus
	boolean generateReport
	
	
	
	String toString(){
		"$id"
	}
	static def constraints = {
		
	}
}
