
public class FeeChequeRecord{

		
	   byte[] data
	   String level
	   String name
	   int size
	   String extension
	   IndApplicationDetails indApplication
	   Date dateCreated
	   
	   String additionalfee
		
		public FeeChequeRecord()
		{
		additionalfee="NO"
		}
	   static constraints = {
		    // data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
		     data( nullable: false, minSize: 1)
		     name( nullable: false, blank: false )
		     level( nullable: false, blank: false )
		     size( nullable: false,maxSize: 2 )
		     indApplication(nullable: false,blank:false)
		   }
	
	
}
