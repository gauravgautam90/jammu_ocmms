
class Audit_Report 
{
  String id
  String ipAdress
  String userName
  String SucessLogin
  Date login	
  Date logout
  String toString(){
      "$id"    
  }
  
  	static def constraints = {
  		ipAdress(nullable:false)
  		  userName(nullable:false)
  		
  	}
}