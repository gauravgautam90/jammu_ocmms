import javax.mail.*;
import javax.mail.internet.*;
import java.util.*; 
public class SendMail{
	public void postMail( String hostname,String recipients[ ], String subject, String message , String from) throws MessagingException
	{
	    boolean debug = false;

	     //Set the host smtp address
	     Properties props = new Properties();
	     //props.put("mail.smtp.host", "smtp.jcom.net");
	     props.put("mail.smtp.host", hostname);
	     props.put("mail.smtp.user", "anil.kumar@nic.in");
	     props.put("mail.smtp.password", "mannu#321");
	     props.put("mail.smtp.port", "25");

	    // create some properties and get the default Session
	    Session session = Session.getDefaultInstance(props, null);
	    session.setDebug(debug);

	    // create a message
	    Message msg = new MimeMessage(session);

	    // set the from and to address
	    InternetAddress addressFrom = new InternetAddress(from);
	    msg.setFrom(addressFrom);

	    InternetAddress[] addressTo = new InternetAddress[recipients.length];
	    for (int i = 0; i < recipients.length; i++)
	    {
	        addressTo[i] = new InternetAddress(recipients[i]);
	    }
	    msg.setRecipients(Message.RecipientType.TO, addressTo);
	   

	    // Optional : You can also set your custom headers in the Email if you Want
	    msg.addHeader("MyHeaderName", "myHeaderValue");

	    // Setting the Subject and Content Type
	    msg.setSubject(subject);
	    msg.setContent(message, "text/html");
	    Transport.send(msg);
	}
	public void sendMail(String rec,String userName,String password, String industryName){
		
		String recept[] = {rec};
		String mymsg = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0Transitional//EN'> \n";
		mymsg+="<html> \n";
		mymsg+="<head> \n";
		mymsg+=" <title>E-Mail</title> \n";
		mymsg+="</head> \n";
		mymsg+="<body> \n";
		mymsg+="";
		mymsg+="Greetings!";
		mymsg+="";
		mymsg+="";
		mymsg+="<P>You are sucessfuly registered your Industry ("+ industryName+") at Online Consent Management & Monitoring System (Jammu). Please use following login credential to log into the OCMMS Application.</p>\n";
		//mymsg+="</p>\n";
		mymsg+="\n";
		mymsg+="<P>URL : http://jkocmms.nic.in</P>\n" ;
		mymsg+="<P>UserID : "  +userName+  "</P>\n" ;
		mymsg+="<P>Password : "  +password+  "</P>\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="<P>Note : Please change your password within 15 days.</P>\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		//mymsg+="<P><a href=http://us01s200:80/CAisd/pdmweb.exe?OP=SEARCH+FACTORY=chg+SKIPLIST=1+QBE.EQ.id= 5556788 >http://us01s200:80/CAisd/pdmweb.exe?OP=SEARCH+FACTORY=chg+SKIPLIST=1+QBE.EQ.id= 55567567</a></P>\n";
		mymsg+="<P>Thanks & Regards:</p>\n";
		mymsg+="<P>JKSPCB</p>";
		mymsg+="</body>\n";
		mymsg+="</html>\n"; 
		try{
		postMail("relay.nic.in",recept,"Online Industry Registration Details (OCMMS)",mymsg,"jkspcb@nic.in");
		System.out.println("mail sent");
		}catch(Exception e){
			e.printStackTrace();
		}
	
}

public void sendClarification(String applicationId,String days,String emailId,String appFor,String occName,String applicationDate)
{
  try {
	    String recept[] = {emailId};
		String mymsg = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0Transitional//EN'> \n";
		mymsg+="<html> \n";
		mymsg+="<head> \n";
		mymsg+=" <title>Clarification Raised</title> \n";
		mymsg+="</head> \n";
		mymsg+="<body> \n";
		mymsg+="";   		
		mymsg+="<P>Dear "+occName+",</p>\n<p>Clarification raised on your online "+appFor+" Application No. "+applicationId+" Dated "+applicationDate+"";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";		
		mymsg+="\n";
		mymsg+="<P>Thanks & Regards:</p>\n";
		mymsg+="<P>JKSPCB</p>";
		mymsg+="</body>\n";
		mymsg+="</html>\n"; 
		try{
		postMail("relay.nic.in",recept,"Clarification Raised (OCMMS)",mymsg,"jkspcb@nic.in");
		System.out.println("mail sent");
		}catch(Exception e){
			e.printStackTrace();
		}
   }catch (Exception e) {
		e.printStackTrace();
	}
}

public void sendReturned(String applicationId,String emailId,String appFor,String occName,String applicationDate)
{
  try {
	    String recept[] = {emailId};
		String mymsg = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0Transitional//EN'> \n";
		mymsg+="<html> \n";
		mymsg+="<head> \n";
		mymsg+=" <title>Application Returned</title> \n";
		mymsg+="</head> \n";
		mymsg+="<body> \n";
		mymsg+="";   		
		mymsg+="<P>Dear "+occName+",</p>\n<p> your online "+appFor+" Application No. "+applicationId+" Dated "+applicationDate+" has been Returned due to some Reason.Please check your OCMMS Account for details.";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";		
		mymsg+="\n";
		mymsg+="<P>Thanks & Regards:</p>\n";
		mymsg+="<P>JKSPCB</p>";
		mymsg+="</body>\n";
		mymsg+="</html>\n"; 
		try{
		postMail("relay.nic.in",recept,"Application Returned (OCMMS)",mymsg,"jkspcb@nic.in");
		System.out.println("mail sent");
		}catch(Exception e){
			e.printStackTrace();
		}
   }catch (Exception e) {
		e.printStackTrace();
	}
}
public void sendWasteAppSubmit(String applicationId, String oEmail,
		String appFor, String occName) {

	String recept[] = { oEmail };
	String date1 = "";

	String mymsg = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0Transitional//EN'> \n";
	mymsg += "<html> \n";
	mymsg += "<head> \n";
	mymsg += " <title>Application Submitted</title> \n";
	mymsg += "</head> \n";
	mymsg += "<body> \n";
	mymsg += "";
	mymsg += "<P>Dear "
			+ occName
			+ ",</p>\n<p> Your Applicaion for "
			+ appFor
			+ " no. "
			+ applicationId
			+ " has been Submitted.";
	mymsg += "\n";
	mymsg += "\n";
	mymsg += "\n";
	mymsg += "\n";
	mymsg += "\n";
	mymsg += "\n";
	mymsg += "\n";
	mymsg += "<P>Thanks & Regards:</p>\n";
	mymsg += "<P>APPCB</p>";
	mymsg += "</body>\n";
	mymsg += "</html>\n";
	try {
		//postMail("relay.nic.in", recept, "Application Rejected(OCMMS)",
				//mymsg, "it-support@appcb.gov.in");

	} catch (Exception e) {
		e.printStackTrace();
	}
}
 // Added by DEEPAK for sms testing
public void testingMail(String mailAddress)

{
  try {
	    String recept[] = {mailAddress};
		String mymsg = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0Transitional//EN'> \n";
		mymsg+="<html> \n";
		mymsg+="<head> \n";
		mymsg+=" <title>Testing mail</title> \n";
		mymsg+="</head> \n";
		mymsg+="<body> \n";
		mymsg+="";   		
		mymsg+="<P>Dear Sir"+",</p>\n<p>.";
		mymsg+="\n";
		mymsg+="<p>This mail is for testing purpose";
		mymsg+="\n";
		mymsg+="\n";		
		mymsg+="\n";
		mymsg+="<P>Thanks & Regards ,</p>\n";
		mymsg+="<P>JKPCB</p>";
		mymsg+="\n";
		mymsg+="\n<p><b>This is  computer generated mail. Do not send any mail to this email ID</b></p>";
		mymsg+="\n";
		mymsg+="</body>\n";
		mymsg+="</html>\n"; 
		try{
		postMail("relay.nic.in",recept,"Testing Mail (OCMMS)",mymsg,"jkspcb@nic.in");
		System.out.println("mail sent");
		}catch(Exception e){
			e.printStackTrace();
		}
   }catch (Exception e) {
		e.printStackTrace();
	}
}

public void sendingOTPemail(final String applicationid, final String emailId, final String otp ){
	  System.out.println("IN Re-Open mail");
		Thread thread=new Thread( new Runnable() 
    {
       public void run()
           {
    	       
				try {
					System.out.println("Re-Open TRY mail ");
		String recept[] = {emailId};
		String mymsg = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0Transitional//EN'> \n";
		mymsg+="<html> \n";
		mymsg+="<head> \n";
		mymsg+=" <title>E-Mail</title> \n";
		mymsg+="</head> \n";
		mymsg+="<body> \n";
		mymsg+="";
		mymsg+="Greetings!";
		mymsg+="";
		mymsg+="";
		mymsg+="<P>Your One Time Password no. ("+ otp+") for Re-Open Application.</p>\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="\n";
		mymsg+="<P>Thanks & Regards:</p>\n";
		mymsg+="\n";
		mymsg+="\n<p><b>This is  computer generated mail. Do not send any mail to this email ID</b></p>";
		mymsg+="<P>JKSPCB</p>";
		mymsg+="</body>\n";
		mymsg+="</html>\n"; 
		try{
		postMail("relay.nic.in",recept,"Application Re-open(OCMMS)", mymsg,"jkspcb@nic.in");
		System.out.println("Re-Open mail sent");
		}catch(Exception e){
			e.printStackTrace();
		}} catch (Exception e) {
			e.printStackTrace();
		}  
   }
});
thread.start();

	
}

}