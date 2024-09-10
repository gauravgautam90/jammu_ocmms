
public class RefundTransactionDetails{

	   String id
	   String tpslId
	  // String bankId
	   String amount
	   String bankName
	   String accountNo
	   String name
	   String ifscCode
	   IndUser indUser
	   Date dateCreated
	   Date lastUpdated
	   String refundStatus
	   String paymentType
	   
	   String toString(){
	        "$id"    
	    }
	   static belongsTo = [indUser:IndUser]
	   static mapping = {
			id generator:'assigned'
				indUser lazy : false
		}
	   
	   static constraints = {
		    // data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
		    
		   }
	
	
}
