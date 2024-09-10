import pool.JDBCConnection;
import java.io.IOException;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
/**
 * @Created By:VINEET KUMAR RAGHAV
 * @Created Date:24/11/2017
 * @Purpose:getIndustryDetails
 * @Return:arrayList
 * @Param:controlId,unitId,serviceId,passsalt,processIndustryId
 * ****/
public class Response
{
	    @SuppressWarnings("unchecked")
	    
	    private static HttpsURLConnection httpConn;
	     /**
		 * Makes an HTTP request using POST method to the specified URL.
		 * 
		 * @param requestURL
		 *            the URL of the remote server
		 * @param params
		 *            A map containing POST data in form of key-value pairs
		 * @return An HttpURLConnection object
		 * @throws IOException
		 *             thrown if any I/O error occurred
		 */
	    
		public static HttpsURLConnection sendPostRequest(String requestURL,
				Map<String, String> params) throws IOException {
			URL url = new URL(requestURL);
			httpConn = (HttpsURLConnection) url.openConnection();
			httpConn.setUseCaches(false);
			httpConn.setDoInput(true); 
			StringBuffer requestParams = new StringBuffer();
			if (params != null && params.size() > 0) {
				httpConn.setDoOutput(true); 
				Iterator<String> paramIterator = params.keySet().iterator();
				while (paramIterator.hasNext()) {
					String key = paramIterator.next();
					String value = params.get(key);
					requestParams.append(URLEncoder.encode(key, "UTF-8"));
					requestParams.append("=").append(
							URLEncoder.encode(value, "UTF-8"));
					requestParams.append("&");
				}

				OutputStreamWriter writer = new OutputStreamWriter(
						httpConn.getOutputStream());
				writer.write(requestParams.toString());
				writer.flush();
			}
			System.out.println("-httpConn--"+httpConn);
			return httpConn;
		}
		
		
		public static HttpURLConnection sendPost(String requestURL,
				Map<String, String> params)throws IOException{
			 URL obj = new URL(requestURL);
			 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			 	con.setRequestMethod("POST");
			    con.setRequestProperty("User-Agent", "Mozilla/5.0");
			    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			    con.setDoInput(true); 
			    
			    StringBuffer requestParams = new StringBuffer();
				if (params != null && params.size() > 0) {
					con.setDoOutput(true); 
					Iterator<String> paramIterator = params.keySet().iterator();
					while (paramIterator.hasNext()) {
						String key = paramIterator.next();
						String value = params.get(key);
						requestParams.append(URLEncoder.encode(key, "UTF-8"));
						requestParams.append("=").append(
								URLEncoder.encode(value, "UTF-8"));
						requestParams.append("&");
					}

					OutputStreamWriter writer = new OutputStreamWriter(
							con.getOutputStream());
					writer.write(requestParams.toString());
					writer.flush();
				}
				System.out.println("-httpConn--"+con);
				return con;
		}
		
		
		
		
		
		/**
		 * Returns an array of lines from the server's response. This method should
		 * be used if the server returns multiple lines of String.
		 * 
		 * @return an array of Strings of the server's response
		 * @throws IOException
		 *             thrown if any I/O error occurred
		 */
		
		public static String[] readMultipleLinesRespone() throws IOException {
			InputStream inputStream = null;
			if (httpConn != null) {
				inputStream = httpConn.getInputStream();
			} else {
				throw new IOException("Connection is not established.");
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			List<String> response = new ArrayList<String>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				response.add(line);
			}
			reader.close();
			return response.toArray(new String[0]);
		}
		
		
	    /**
		 * Closes the connection if opened
		 */
		
		public static void disconnect() {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}
		
		
		
		 
		 
		 public static String getMd5(String input) 
		    { 
		        try { 
		  
		            MessageDigest md = MessageDigest.getInstance("MD5"); 
		            byte[] messageDigest = md.digest(input.getBytes()); 
		  
		            BigInteger no = new BigInteger(1, messageDigest); 
		  
		            
		            String hashtext = no.toString(16); 
		            while (hashtext.length() < 32) { 
		                hashtext = "0" + hashtext; 
		            } 
		            return hashtext; 
		        }  
		  
		        catch (NoSuchAlgorithmException e) { 
		            throw new RuntimeException(e); 
		        } 
		    }
		 
		   public void sendStatus(String consentAppNo,String cafNo,String serviceId,String applicationType,String applicationFor1,String statusCode,String appRemarks,String pendingWith,String pendingWithRole,String printAppUrl,String revertedUrl,String certificateUrl) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException
	        
		     {
			   System.out.println("--Inside in Send Status----------------");
		    	System.out.println("appNo------------------"+consentAppNo);
		    	System.out.println("cafNo------------------"+cafNo);
		    	System.out.println("applicationType------------------"+applicationType);
		    	System.out.println("applicationFor1------------------"+applicationFor1);
		    	System.out.println("status code------------------"+statusCode);
		    	System.out.println("appRemarks------------------"+appRemarks);
		    	System.out.println("pendingWith-----------------"+pendingWith);
		    	System.out.println("pendingWithRole------------------"+pendingWithRole);
		    	System.out.println("ServiceId------------------"+serviceId);
		    	System.out.println("printAppUrl------------------"+printAppUrl);
		    	System.out.println("revertedUrl-----------------"+revertedUrl);
		    	System.out.println("certificateUrl------------------"+certificateUrl);
		    	String responce = "";
		    	
		    	Response rs=new Response();
			     rs.saveStatus(consentAppNo,  cafNo,  serviceId,   applicationType, applicationFor1,  statusCode,  appRemarks,  pendingWith,  pendingWithRole, printAppUrl,  revertedUrl,  certificateUrl,  responce);

		    	//String requestUR="";
			//	String requestUR="https://www.investjk.in/jkspcbestablish/updateStatus/";       //  old URL
				String requestUR="https://singlewindow.jk.gov.in/jkspcbestablish/updateStatus/";  // NEW URL 
				Map<String, String> params = new HashMap<String, String>();
				params.put("consentAppNo",consentAppNo);
				params.put("cafNo",cafNo);
				params.put("service_id",serviceId);
				params.put("app_type",applicationType);
				params.put("app_for",applicationFor1);
				params.put("status_code",statusCode);
				params.put("remarks",appRemarks);
				params.put("pending_with",pendingWith);
				params.put("officer_role",pendingWithRole);
				params.put("print_app_url",printAppUrl);
				params.put("revert_url",revertedUrl);
				params.put("certificate_url",certificateUrl);
				
				try {
					httpConn = sendT(requestUR, params);
					if (httpConn.getResponseCode() == 200) {
						String[] response = readMultipleLinesRespone();
						for (String line : response) {
							responce = line;
						}
						System.out.println("Response Code--" + responce);
					}
					else {
						responce = Integer.toString(httpConn.getResponseCode());
						
						System.out.println("Response Code-" + responce);
					}
				
					  
					rs.updateStatus(consentAppNo ,responce);     // Added by DEEPAK for Scheduler 
					
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				disconnect();
		    }
		   
		   ////////////////////////                                      New Code Added by Deepak for     /////////////////////////////////////////
		   
		   public void reSendStatus(String consentAppNo,String cafNo,String serviceId,String applicationType,String applicationFor1,String statusCode,String appRemarks,String pendingWith,String pendingWithRole,String printAppUrl,String revertedUrl,String certificateUrl) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException
	        
		     {
			   System.out.println("--Inside in reSend Status ----------------");
		    	System.out.println("appNo------------------"+consentAppNo);
		    	System.out.println("cafNo------------------"+cafNo);
		    	System.out.println("applicationType------------------"+applicationType);
		    	System.out.println("applicationFor1------------------"+applicationFor1);
		    	System.out.println("status code------------------"+statusCode);
		    	System.out.println("appRemarks------------------"+appRemarks);
		    	System.out.println("pendingWith-----------------"+pendingWith);
		    	System.out.println("pendingWithRole------------------"+pendingWithRole);
		    	System.out.println("ServiceId------------------"+serviceId);
		    	System.out.println("printAppUrl------------------"+printAppUrl);
		    	System.out.println("revertedUrl-----------------"+revertedUrl);
		    	System.out.println("certificateUrl------------------"+certificateUrl);
		    	String responce = "";
		    	
		    	Response rs=new Response();
		//	     rs.saveStatus(consentAppNo,  cafNo,  serviceId,   applicationType, applicationFor1,  statusCode,  appRemarks,  pendingWith,  pendingWithRole, printAppUrl,  revertedUrl,  certificateUrl,  responce);

		    	//String requestUR="";
			//	String requestUR="https://www.investjk.in/jkspcbestablish/updateStatus/";       //  old URL
				String requestUR="https://singlewindow.jk.gov.in/jkspcbestablish/updateStatus/";  // NEW URL 
				Map<String, String> params = new HashMap<String, String>();
				params.put("consentAppNo",consentAppNo);
				params.put("cafNo",cafNo);
				params.put("service_id",serviceId);
				params.put("app_type",applicationType);
				params.put("app_for",applicationFor1);
				params.put("status_code",statusCode);
				params.put("remarks",appRemarks);
				params.put("pending_with",pendingWith);
				params.put("officer_role",pendingWithRole);
				params.put("print_app_url",printAppUrl);
				params.put("revert_url",revertedUrl);
				params.put("certificate_url",certificateUrl);
				
				try {
					httpConn = sendT(requestUR, params);
					if (httpConn.getResponseCode() == 200) {
						String[] response = readMultipleLinesRespone();
						for (String line : response) {
							responce = line;
						}
						System.out.println("reSendStatus Response Code--" + responce);
					}
					else {
						responce = Integer.toString(httpConn.getResponseCode());
						
						System.out.println("reSendStatus Response Code-" + responce);
					}
				
					  
					rs.updateStatus(consentAppNo ,responce);
					
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				disconnect();
		    }
		   
		   public static void updateStatus(String appId,String responseCode ) {
				try {
					System.out.println("==updateStatus==responseCode====="+responseCode);
					Connection c = null;
					PreparedStatement ps1 = null;
					c = JDBCConnection.getConnection();
					ps1=c.prepareStatement("UPDATE single_window_status set responce=? WHERE id = (SELECT id FROM single_window_status WHERE app_id='"+appId+"' ORDER BY created_date desc LIMIT 1)");
					ps1.setString(1,responseCode);

					int i=ps1.executeUpdate();
					System.out.println("updateStatus i: "+i);
					System.out.println("applicationNo----Data has been updated: "+appId);

					if (ps1!=null ){
						ps1.close();
					}
					if(c!=null ){
						c.close();
					}


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		  
		  
		  public static HttpsURLConnection sendT(String requestURL,Map<String, String> params)throws IOException {
			   
			   TrustManager[] trustAllCerts = new TrustManager[]{
					    new X509TrustManager() {
					        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					            return null;
					        }
					        public void checkClientTrusted(
					            java.security.cert.X509Certificate[] certs, String authType) {
					        }
					        public void checkServerTrusted(
					            java.security.cert.X509Certificate[] certs, String authType) {
					        }
					    }
					};

					// Install the all-trusting trust manager
					try {
					    SSLContext sc = SSLContext.getInstance("SSL");
					    sc.init(null, trustAllCerts, new java.security.SecureRandom());
					    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
					    
					    HostnameVerifier allHostsValid = new HostnameVerifier() {
			                public boolean verify(String hostname, SSLSession session) {
			                    return true;
			                }
			            };
			            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
					} catch (Exception e) {
					}

					// Now you can access an https URL without having the certificate in the truststore
					try {
					    URL url = new URL(requestURL);
					    
					    httpConn = (HttpsURLConnection)url.openConnection();
						httpConn.setUseCaches(false);
						httpConn.setDoInput(true); 
						StringBuffer requestParams = new StringBuffer();
						if (params != null && params.size() > 0) {
							httpConn.setDoOutput(true); 
							Iterator<String> paramIterator = params.keySet().iterator();
							while (paramIterator.hasNext()) {
								String key = paramIterator.next();
								String value = params.get(key);
								requestParams.append(URLEncoder.encode(key, "UTF-8"));
								requestParams.append("=").append(
										URLEncoder.encode(value, "UTF-8"));
								requestParams.append("&");
								
							}

							OutputStreamWriter writer = new OutputStreamWriter(
									httpConn.getOutputStream());
							writer.write(requestParams.toString());
							writer.flush();
						}
					    
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					return httpConn;
		   }

		  public String getjson(String occname,String appdate,String certiexpdate,String address,String mobileno,String certiUrl){
				String abc="{"
					+ "\"STATUS\":"+"\"200\","
					+ "\"MSG\":"+"\"Application Found\","
					+ "\"RESPONSE\":{" 
				+ "\"FullName\":\"" + occname + "\","
				+ "\"ApplicationDate\":\"" + appdate + "\","
				+ "\"CertificateExpiryDate\":\"" + certiexpdate + "\","
				+ "\"UDF1\":\"" + address + "\","
				+ "\"UDF2\":\"" + mobileno + "\","
				+ "\"DocContent\":\"" + certiUrl + "\""
				+"}}";
				
				return abc;
			}
		  public String getNotFindjson(String msg,String msg1){
				String abc="{"
					+ "\"STATUS\":404,"
					+ "\"MSG\":\""+msg+"\","
					+ "\"RESPONSE\":"+msg1+"}";
				
				return abc;
			}
		  
		//========================Start Seven Teen Category Data=========================================================================================================
			public String sendSevenTeenCategoryData(String industry_id, String industry_name, String ind_address, String district_name, String ind_category_name, String ind_type_name , String occ_email, String occupier_name, String occupier_designation, String application_id, String application_reciept_date,String state, String grant_date, String product_name, String quantity, String unit, String ipaddr, String occ_mobile, String application_type) throws Exception{
				String abc="";
				try{


					System.out.println("industry_id:"+industry_id);
					System.out.println("industry_name:"+industry_name);
					System.out.println("ind_address:"+ind_address);
					System.out.println("district_name:"+district_name);
					System.out.println("ind_category_name:"+ind_category_name);
					System.out.println("ind_type_name:"+ind_type_name);
					System.out.println("occ_email:"+occ_email);
					System.out.println("occupier_name:"+occupier_name);
					System.out.println("occupier_designation:"+occupier_designation);
					System.out.println("application_id:"+application_id);
					System.out.println("application_reciept_date:"+application_reciept_date);
					System.out.println("state:"+state);
					System.out.println("grant_date:"+grant_date);
					System.out.println("product_name:"+product_name);
					System.out.println("quantity:"+quantity);
					System.out.println("unit:"+unit);
					System.out.println("ipaddr:"+ipaddr);
					System.out.println("occ_mobile:"+occ_mobile);
					System.out.println("application_type:"+application_type);

					System.out.println("UpdateWebService Step 1.  inside sendApplication");

					// Create a trust manager that does not validate certificate chains
					TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
						public java.security.cert.X509Certificate[] getAcceptedIssuers() {
							return null;
						}
						public void checkClientTrusted(X509Certificate[] certs, String authType) {
						}
						public void checkServerTrusted(X509Certificate[] certs, String authType) {
						}
					}
					};

					// Install the all-trusting trust manager
					SSLContext sc = SSLContext.getInstance("SSL");
					sc.init(null, trustAllCerts, new java.security.SecureRandom());
					HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

					// Create all-trusting host name verifier
					HostnameVerifier allHostsValid = new HostnameVerifier() {
						public boolean verify1(String hostname, SSLSession session) {
							return true;
						}

						public boolean verify(String arg0, SSLSession arg1) {
							// TODO Auto-generated method stub
							return false;
						}
					};

					// Install the all-trusting host verifier
					HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

					String urlInString = "http://parivesh.nic.in/apicto/api/Status/GetDetails/"; //live
					//String urlInString = "http://164.100.213.214/ctostaging/api/Status/GetDetails/"; //live Staging db
					//String urlInString = "http://164.100.213.73/sw/ctoapi/api/Status/GetDetails/"; //public test

					URL url = new URL(urlInString);
					URLConnection con = url.openConnection();
					HttpURLConnection http = (HttpURLConnection)con;
					System.out.println("UpdateWebService http 2222222222222222: " + http);
					http.setRequestMethod("POST"); // PUT is another valid option
					http.setDoOutput(true);
					http.setDoInput(true);
					System.out.println("email:"+occ_email);
					System.out.println();
					System.out.println("{"
							+ "\"industry_id\":\"" + industry_id + "\","
							+ "\"industry_name\":\"" + industry_name + "\","
							+ "\"ind_address\":\"" + ind_address + "\","
							+ "\"district_name\":\"" + district_name + "\","
							+ "\"ind_category_name\":\"" + ind_category_name + "\","
							+ "\"ind_type_name\":\"" + ind_type_name + "\","
							+ "\"occ_email\":\"" + occ_email + "\","
							+ "\"occupier_name\":\"" + occupier_name + "\","

							+ "\"occupier_designation\":\"" + occupier_designation + "\","
							+ "\"application_id\":\"" + application_id + "\","
							+ "\"application_reciept_date\":\"" + application_reciept_date + "\","
							+ "\"state\":\"" + state + "\","
							+ "\"grant_date\":\"" + grant_date + "\","
							+ "\"product_name\":\"" + product_name + "\","
							+ "\"quantity\":\"" + quantity + "\","
							+ "\"unit\":\"" + unit + "\","
							+ "\"ipaddr\":\"" + ipaddr + "\","
							+ "\"occ_mobile\":\"" + occ_mobile + "\","
							+ "\"application_type\":\"" + application_type + "\""
							+ "}");


					byte[] out = ("{"
							+ "\"industry_id\":\"" + industry_id + "\","
							+ "\"industry_name\":\"" + industry_name + "\","
							+ "\"ind_address\":\"" + ind_address + "\","
							+ "\"district_name\":\"" + district_name + "\","

							+ "\"ind_category_name\":\"" + ind_category_name + "\","
							+ "\"ind_type_name\":\"" + ind_type_name + "\","
							+ "\"occ_email\":\"" + occ_email + "\","
							+ "\"occupier_name\":\"" + occupier_name + "\","

							+ "\"occupier_designation\":\"" + occupier_designation + "\","
							+ "\"application_id\":\"" + application_id + "\","
							+ "\"application_reciept_date\":\"" + application_reciept_date + "\","
							+ "\"state\":\"" + state + "\","
							+ "\"grant_date\":\"" + grant_date + "\","
							+ "\"product_name\":\"" + product_name + "\","
							+ "\"quantity\":\"" + quantity + "\","
							+ "\"unit\":\"" + unit + "\","
							+ "\"ipaddr\":\"" + ipaddr + "\","
							+ "\"occ_mobile\":\"" + occ_mobile + "\","
							+ "\"application_type\":\"" + application_type + "\""
							+ "}")
							.getBytes("UTF8");


					int length = out.length;

					http.setFixedLengthStreamingMode(length);
					http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
					http.connect();

					OutputStream os = http.getOutputStream();
					os.write(out);
					System.out.println("UpdateWebService response code aaaaaaaaaaaaaaaaaaaaa: ");
					System.out.println(http.getResponseCode());
					System.out.println();
					System.out.println("UpdateWebService response message bbbbbbbbbbbbbbbbbbbb:");
					System.out.println(http.getResponseMessage());
					System.out.println();

					if(http.getResponseCode() == 200 || http.getResponseCode() == 201){
						System.out.println("UpdateWebService response code is 200 or 201");
						abc=http.getResponseCode()+"";
						//return abc;

					}else{
						System.out.println("UpdateWebService response code is neither 200 nor 201");
						System.out.println("http.getResponseMessage():\n"+http.getResponseMessage()+"\n");
						abc=http.getResponseCode()+"";
						//return abc;
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return abc;

			}
			
			

			public static void saveStatus(
					
					  String consentAppNo, String cafNo, String serviceId, String applicationType, String applicationFor1,
					  String statusCode, String appRemarks, String pendingWith, String pendingWithRole, String printAppUrl,
					  String revertedUrl, String certificateUrl, String responce) {

					  Random random = new Random(new java.util.Date().getTime());
				      int randomInt = random.nextInt(1000000);
				  	System.out.println("inside saveStatus =======");
				try {
					
					Connection c = null;
					PreparedStatement ps = null;
					Statement stmt = null;
					ResultSet res = null;
					c = JDBCConnection.getConnection();
					ps =c.prepareStatement("insert into single_window_status (id, version, app_id, caf_no, service_id, application_type, application_for,status_code,app_remarks, pending_with , pending_with_role,print_app_url, reverted_url, certificate_url, responce ,created_date) values(?, 0,?,?,?, ?,?,?,?,?, ?,?,?,?,?,current_timestamp)");
	//				                                   INSERT INTO single_window_status (id,VERSION, app_id, caf_no, service_Id,application_Type, application_For,status_Code,app_Remarks,pending_With,pending_With_Role,print_App_Url,reverted_Url,certificate_Url,responce,created_Date) VALUES(2,0,'1133','sdfsfs','CTO','new','845447','www.werg.com','hdfhdh','dfhdfh','fhdfh','gdfhsfh','sdgsdg','sdgsg','sdgsdgsdgsg','2021-01-01')
					ps.setInt(1,randomInt);

					ps.setString(2,consentAppNo);
					ps.setString(3,cafNo);
					ps.setString(4,serviceId);
					ps.setString(5,applicationType);
					ps.setString(6,applicationFor1);

					ps.setString(7,statusCode);
					ps.setString(8,appRemarks);
					ps.setString(9,pendingWith);
					ps.setString(10,pendingWithRole);
					ps.setString(11,printAppUrl);
					ps.setString(12,revertedUrl);
					ps.setString(13,certificateUrl);
					ps.setString(14,responce);




					int i=ps.executeUpdate();
					System.out.println("i: "+i);

					if (ps!=null ){
						ps.close();
					}
					if(c!=null ){
						c.close();
					}


				} catch (Exception e) {
					e.printStackTrace();
				}


			}
			
			
			
   }