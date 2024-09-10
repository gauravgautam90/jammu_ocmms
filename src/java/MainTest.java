import javax.crypto.SecretKey;

public class MainTest{
	public static void main(String []args){
		
		String recept[] = {"anamika.shrivastava@infogain.com"};
		SendMail send = new SendMail();
		//String test = "this is a test java mail \r\n"+ "please reply to varun.bhatia@infogain.com when you receive this mail \r\n"+" thanks & regards \r\n"+ "varun bhatia";
		try{
		send.postMail("172.18.65.28",recept,"WE ARE WATCHING YOU","message body","Anamika");
	
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}