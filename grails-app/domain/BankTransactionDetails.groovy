
public class BankTransactionDetails{

	   String id	
	   String bankId
	   String amount
	   String bankName
	   IndApplicationDetails indApplication
	   Date dateCreated
	   Date lastUpdated
	   String transactionStatus
	   String paymentType
	   String paymentGateway
	   String toString(){
	        "$id"    
	    }
	   static belongsTo = [indApplication:IndApplicationDetails]
	   static mapping = {
			id generator:'assigned'
				indApplication lazy : false
		}
	   
	   static constraints = {
		    // data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
		    
		   }
	
	
}
