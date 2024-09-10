class UserMaster {
	String id					// User Id
	String password
	String hintQuestion
	String hintAnswer
	String type
	String status
	String accessLevel
	UserProfile userProfile  // Employee id from UserProfile table
	Date dateCreated
	String createdBy
	Date lastUpdated
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
	Date start_date
	Date end_date
	String toString(){
    " $id "
	}
	static mapping = {
		id generator:'assigned'
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
    static  constraints = {
		id(unique:true, validator: {indnm,obj->return  obj.specialCharCheck(indnm)})	
		password(blank:false,password:true)
		hintAnswer(blank:false,validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
		status(blank:false,validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
		userProfile(blank:false)	
		type(validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
		status(validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
		accessLevel(validator: {indnm,obj->return  obj.specialCharCheck(indnm)})
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
