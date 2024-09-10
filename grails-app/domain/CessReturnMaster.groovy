class CessReturnMaster 
{
String id
IndApplicationDetails application //FK
//String month
//String year
 Date cessAppliedFromDate
 Date cessAppliedToDate
// String ulbId
 int firstReading
 int lastReading
 int unitsOfWaterConsumed
 int quantityOfWaterConsumed
 int averageWaterConsumption
 int quantityWaterRebate
 Date createdOn
 Date updatedOn
 
 String toString(){
    "$id"    
}
static def constraints = {
}
}