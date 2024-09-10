class IndUser {
	String id
	String password
	String hintQuestion
	String hintAnswer
	Date dateCreated
    String createdBy
    Long flag
    Long logAttempt
	Long tempLog
	Date date1
	String password1
	String password2
	String password3
	String password4
	String password5
	Long lPass
    IndustryRegMaster industryRegMaster   // FK  Industry_Reg_Master
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
	
	static mapping = {
		id generator:'assigned'
	}
    	static def constraints = {
		   
		    
		 
			password(password:true,blank:false)
    		createdBy(nullable:false)
    		hintAnswer(blank:false, validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
    		logAttempt(nullable:true)
    		lPass(nullable:true)
		password1(nullable:true)
		password2(nullable:true)
		password3(nullable:true)
		password4(nullable:true)
		password5(nullable:true)
		tempLog(nullable:true)
		date1(nullable:true)
    		
    	}
}
