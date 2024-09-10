/**
 * @author Vivek.Raj
 *
 */
class CessPaySlipDetails{

	   Long id	  
	   Date dateCreated
	   Date lastUpdated
	   Date cessPaySlipDate
	   IndustryRegMaster indreg
	   CessReturn cessReturn
	   String ddNo
	   String ddAmount
	   Date ddDate
	   String waterCessAssesmentNo
	   String interestAssesmentNo
	   String penalityAssesmentNo
	   String otherAssesmentNo
	   Date waterCessAssesmentDate
	   Date interestAssesmentDate
	   Date penalityAssesmentDate
	   Date otherAssesmentDate
	   Date waterCessAssesmentFromDate
	   Date interestAssesmentFromDate
	   Date penalityAssesmentFromDate
	   Date otherAssesmentFromDate
	   Date waterCessAssesmentToDate
	   Date interestAssesmentToDate
	   Date penalityAssesmentToDate
	   Date otherAssesmentToDate
	   float waterCessAssesmentAmount
	   float interestAssesmentAmount
	   float penalityAssesmentAmount
	   float otherAssesmentAmount
	   float totalAmount
	   String waterCessAssesmentRemarks
	   String interestAssesmentRemarks
	   String penalityAssesmentRemarks
	   String otherAssesmentRemarks
	   
	    
	    
	   static constraints = {
		  
		     indreg(nullable: false,blank:false)
		     cessReturn(nullable: false,blank:false)
	
}
	
}
