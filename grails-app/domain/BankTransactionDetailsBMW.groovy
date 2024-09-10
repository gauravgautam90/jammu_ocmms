
public class BankTransactionDetailsBMW{

	   String id	
	   String bankId
	   String amount
	   String bankName
	   BioMedicalWaste bioApplication
	   Date dateCreated
	   Date lastUpdated
	   String transactionStatus
	   String paymentType
	   String paymentGateway
	   String toString(){
	        "$id"    
	    }
	   static belongsTo = [bioApplication:BioMedicalWaste]
	   static mapping = {
			id generator:'assigned'
				bioApplication lazy : false
		}
	   
	   static constraints = {
		    // data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
		    
		   }
	
	
}
