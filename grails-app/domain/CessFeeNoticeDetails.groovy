/**
 * @author Vivek.Raj
 *
 */
class CessFeeNoticeDetails{

	   Long id	  
	   Date dateCreated
	   Date lastUpdated
	   Date assesmentOrderDate
	   IndustryRegMaster indreg
	   CessReturn cessReturn
	   Date assesmentFromDate
	   Date assesmentToDate
	   String letterNo
	   String assesmentOrderNo
	   Date noticeDate
	   Date dueFeeDate
	   Date dueDate
	   Date paidOnDate
	   float assesmentAmount
	   float balanceAmount
	   float interestAmount
	   float totalPayableAmount
	   String copyTo
           String officeAddress
	   String endtNo
           String officeDistrict

	    
	    
	    
	   static constraints = {
		  
		     indreg(nullable: false,blank:false)
		     cessReturn(nullable: false,blank:false)
	
}
	
}
