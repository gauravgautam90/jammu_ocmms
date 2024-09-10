class CessWaterConsumptionDetails 
{
	String id
	CessWaterConsumptionPurposeMaster WaterConsumption
	CessSourceConsumptionMaster source
	boolean meterReading
	int startReading
	int lastReading
	int waterQuantity
	int averageWaterQuantity
	int waterRebateQuantity
	String toString(){
	    "$id"    
	}
	static def constraints = {
	}
}