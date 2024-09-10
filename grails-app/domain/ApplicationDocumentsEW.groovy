public class ApplicationDocumentsEW{

	// private static final int FIVE_MEG_IN_BYTES = 1024*1024*5
	   byte[] data
	   String level
	   String name
	   int size
	   String extension
	   EWaste indApplication
	   
	   
	   static constraints = {
		    // data( nullable: false, minSize: 1, maxSize: FIVE_MEG_IN_BYTES )
		     data( nullable: false, minSize: 1)
		     name( nullable: false, blank: false )
		     level( nullable: false, blank: false )
		     size( nullable: false,maxSize: 2 )
		     indApplication(nullable: false,blank:false)

		   }
	
}
