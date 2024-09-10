class WaterSolidWasteGenDetails {
	Long id
	String description
	String quantQual
	String meathodCollection
	String meathodDisposal
	IndApplicationDetails application
    String toString(){
        "$id"    
    }
    static def constrains = {
    		
    }
}