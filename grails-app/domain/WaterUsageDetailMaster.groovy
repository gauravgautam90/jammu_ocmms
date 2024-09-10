class WaterUsageDetailMaster{
	
	Long id
	String usage
	
	
	String toString(){
          "$usage"    
	}
    	
	static def constraints = {
		usage(blank:false,unique:true)
    }
}