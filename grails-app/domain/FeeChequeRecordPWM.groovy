/**
 * 
 */



/**
 * @author Uday
 *
 */
public class FeeChequeRecordPWM{

	byte[] data
	   String level
	   String name
	   int size
	   String extension
	   PlasticWaste indApplication
	   Date dateCreated
	   
	   static constraints = {
		    // data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
		     data( nullable: false, minSize: 1)
		     name( nullable: false, blank: false )
		     level( nullable: false, blank: false )
		     size( nullable: false,maxSize: 2 )
		     indApplication(nullable: false,blank:false)
		   }
	
}
