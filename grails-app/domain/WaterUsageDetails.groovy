class WaterUsageDetails{
	Long id
	String description
	String quantQual
	
	IndApplicationDetails application
    String toString(){
        "$description"    
    }
    static def constrains = {
    		
    }
}