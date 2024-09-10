/**
 * @author Vivek.Raj
 *
 */
class CessAssesmentOrderDetails{

	   Long id	  
	   Date dateCreated
	   Date lastUpdated
	   Date noticeDate
	   Date dueDate
	   IndustryRegMaster indreg
	   CessReturn cessReturn
	   Date assesmentFromDate
	   Date assesmentToDate
	   String letterNo
	   String remarks
	   float indCoolingConsumption
	   float indCoolingGrossAmount
	   float indCoolingQtyWaterRebate
	   float indCoolingRebateAllowed
	   float indCoolingConsumptionNetAmount
	   float domesticConsumption
	   float domesticGrossAmount
	   float domesticQtyWaterRebate
	   float domesticRebateAllowed
	   float domesticConsumptionNetAmount
	   float processingPollutantsAreConsumption
	   float processingPollutantsAreGrossAmount
	   float processingPollutantsAreQtyWaterRebate
	   float processingPollutantsAreRebateAllowed
	   float processingPollutantsAreConsumptionNetAmount
	   float processingPollutantsAreNotConsumption
	   float processingPollutantsAreNotGrossAmount
	   float processingPollutantsAreNotQtyWaterRebate
	   float processingPollutantsAreNotRebateAllowed
	   float processingPollutantsAreNotConsumptionNetAmount
	   float grossAmountTotal
	   float netAmountTotal
	   
	    
	    
	   static constraints = {
		  
		     indreg(nullable: false,blank:false)
		     cessReturn(nullable: false,blank:false)
	
}
	
}
