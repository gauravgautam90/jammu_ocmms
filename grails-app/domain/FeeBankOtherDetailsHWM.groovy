class FeeBankOtherDetailsHWM{
	Long id
	String feeFor
	float amount
	
	HazardeousWasteAuthApp application
	String additionalfee
	
	public FeeBankOtherDetailsHWM()
	{
	additionalfee="NO"
	}
	
	String toString(){
          "$id"    
	}
	 Boolean  specialCharCheck(String field)
		{
			for(int i=0;i<field.size();i++)
			{
				char a=field.charAt(i)
				
				if(a=='<'||a=='>'||a=='+' ||a=='%' ||a=='^'|| a=='\''|| a=='='||a=='-'||a=='\"' || a=='\\' ||a=='$' ||a=='?' ||a=='&'||a=='#')
				{
					return false
					
				}
				
				
			}
			String field1=field.toLowerCase();
			
			if(field1.contains("script")|| field1.contains("delete")||field1.contains("drop")||field1.contains("select")||field1.contains("insert")||field1.contains("update")||field1.contains("select * from")||field1.contains("order by")||field1.contains("distinct")||field1.contains("create")||field1.contains("truncate")||field1.contains("alert")||field1.contains("javascript")||field1.contains("database")||field1.contains("function")||field1.contains("exec"))
			{
				return false
			}
			
			return true
		}
	 
	 
	    static def constraints = {
			   
		    
			feeFor(validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
			
		
		}
}