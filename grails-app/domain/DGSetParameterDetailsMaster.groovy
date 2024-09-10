class DGSetParameterDetailsMaster
{
	Long id
	String parameters
	String noLoad
	String fullLoad
	IndApplicationDetails application
	
	String toString(){
          "$id"    
	}
    static def constraints = {
    }
}