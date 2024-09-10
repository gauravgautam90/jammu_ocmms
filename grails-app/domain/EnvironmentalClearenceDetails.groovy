class EnvironmentalClearenceDetails{
		Long id	
		IndustryRegMaster indUserUniversal
		String proposalNo
		String stateName
		String proposalName
		String category
		String userAgencyName
		String proposalRecievedon
		String fileNo
		String dateOfGrant
		String letter
		
	    String toString(){
	        "$id"    
	    }
	   
	    
	    static def constraints = {
	    	
		}
	    
	}
