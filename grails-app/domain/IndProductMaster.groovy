class IndProductMaster{
	
	Long id
	String productName
	String toString(){
          "$productName($id)"    
	}
    static def constrains = {
    	productName(blank:false)
    }
}
