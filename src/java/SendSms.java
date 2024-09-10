import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SendSms
{
	public void send(final String industryName,final String industryId,final String tempPass,final String oMobNo) throws Exception
	{
		Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
        	      String msg="Your Industry "+industryName+" Registered Successfully.User Id: "+industryId+" Temporary Password: "+tempPass+" Please Login within 15 days. URL:- http://jkocmms.nic.in/";
       		      String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
					sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }
	
public void sendClarification(final String applicationId,final String days,final String oMobNo,final String appFor) throws Exception
	{
		final String date1 = "";
		Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
        	   String msg= "Clarification has been Raised on your Application for "+appFor+" no. "+applicationId+".Please Reply With in "+days+" day/s.";
        	       String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
					sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }

public void sendInspection(final String applicationId,final String days,final String oMobNo, final String appFor) throws Exception
	{

		Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
        	   String msg= "Inspection has been Raised on your Application for "+appFor+" no. "+applicationId+" which is forwarded into your account.Please Reply With in "+days+" days";
        	   String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
					sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }

public void sendEmployeeForward(final String applicationId,final String oMobNo,final String appFor) throws Exception
	{

		Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
        		String msg= "New Application for "+appFor+" no. "+applicationId+" has been sent into your account.Please check your OCMMS Account for details.";
        		String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
						sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }

public void sendEmployeeForward12(final String applicationId,final String oMobNo) throws Exception
{

	Thread thread=new Thread( new Runnable()
    {
       public void run()
           {
    		String msg= "New Application no. "+applicationId+" has been sent into your account.Please check your OCMMS Account for details.";
    		String https_url;
			try {
				System.out.println("1111111111111111111"+msg);
				https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
					sendMessage(https_url);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
           }
     });
	thread.start();
}

public void sendGranted(final String applicationId,final String oMobNo, final String appFor) throws Exception
	{
	Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
        		String msg= "Your Application for "+appFor+" no. "+applicationId+" has been Granted.Please check your OCMMS Account for details.";
        		String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
							sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }

public void sendRejected(final String applicationId,final String oMobNo, final String appFor) throws Exception
	{
	Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
       		String msg= "Your Application for "+appFor+" no. "+applicationId+" has been Refused due to some Reason.Please check your OCMMS Account for details.";
	        String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
							sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }

public void sendReturned(final String applicationId,final String oMobNo, final String appFor) throws Exception
	{
	Thread thread=new Thread( new Runnable()
        {
           public void run()
               {
        		String msg= "Your Application for "+appFor+" no. "+applicationId+" has been Returned due to some Reason.Please check your OCMMS Account for details.";
        		String https_url;
				try {
					System.out.println("1111111111111111111"+msg);
					https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+oMobNo+"&signature=JKSPCB";
							sendMessage(https_url);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
               }
         });
		thread.start();
  }


public void sendingOTP1(final String applicationId,final String mobileNo,final String otp) throws Exception
{


	Thread thread=new Thread( new Runnable()
    {
       public void run()
           {
    		String msg= "Your OTP for Re-Open application no. ("+applicationId+") is "+otp+".";
    		String https_url;
			try {
				https_url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=jkocmms.sms&pin=Bs%23Au7y9M&message="+URLEncoder.encode(msg, "UTF-8")+"&mnumber="+mobileNo+"&signature=JKSPCB";
				sendMessage(https_url);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
           }
     });
	thread.start();


}

public void sendeeWastepplicationSubmitted(final String applicationId,
		final String oMobNo, final String appFor) throws Exception {
	String mssg = "Your Applicaion for " + appFor + " no. " + applicationId
			+ " has been Submitted.";
	try {
		//sendSingleSMS(oMobNo, mssg);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void sendPWMApplicationSubmitted(final String applicationId,
		final String oMobNo, final String appFor) throws Exception {
	String mssg = "Your Applicaion for " + appFor + " no. " + applicationId
			+ " has been Submitted.";
	try {
		//sendSingleSMS(oMobNo, mssg);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	private TrustManager[] get_trust_mgr() {
		TrustManager[] certs = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String t) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String t) {
			}
		} };
		return certs;
}

private void print_content(HttpsURLConnection con) {
		if (con != null) {

			try {

				System.out.println("****** Content of the URL ********");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream()));

				String input;

				while ((input = br.readLine()) != null) {
					System.out.println(input);
				}
				br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

public void sendMessage(String https_url)
	{
		URL url;
		try {
			System.out.println("URL sendSMS ==  "+https_url);
			SSLContext ssl_ctx = SSLContext.getInstance("TLS");
			TrustManager[] trust_mgr = get_trust_mgr();
			ssl_ctx.init(null, // key manager
					trust_mgr, // trust manager
					new SecureRandom()); // random number generator
			HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx
					.getSocketFactory());

			url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			print_content(con);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

	}

}