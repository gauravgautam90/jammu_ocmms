<%-- 
    Document   : Server2ServerCall
    Created on : Jul 14, 2015, 6:15:45 PM
    Author     : 74150
--%><%@page import="javax.crypto.Cipher"%><%@page import="javax.crypto.spec.SecretKeySpec"%><%@page import="java.util.StringTokenizer"%><%@page import="java.util.HashMap"%><%@page import="java.io.FileInputStream"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%
try{
		String str=msg;
		System.out.println("str "+str);
		String strReponse="0|0|Not Updated";

		System.out.println("DATA REACHED ");
		String aa =  str;
	    System.out.println("a--------hereee-----"+aa);
	    String merchantId = "";
    	String transId = "";
    	String billDeskId = "";
    	String value1 = "";
    	String txnAmount = "";

    	String bankId = "";
    	String value2 = "";
    	String txnType = "";
    	
    	String CurrencyType = "";
    	String  type2= "";
    	String value4 = ""; 
    	String value5 = "";
    	String value6 = "";
    	String transDateB = "";
    	String strAuthStatus = "";
    	String value7 = "";
    	String appNo = "";
    	String indMail = "";
    	String indName = "";
    	String transDateK = "";
    	String value8 = "";
    	String value9 = "";
    	String value10 = "";
    	String value11 = "";
    	String strErrorDescription = "";
    	String msgChecksum = "";
		String status = "I";
    		
    		StringTokenizer token = new StringTokenizer(aa,"|");
    		System.out.println("---11111-----token.countTokens()--------------"+token.countTokens());
    		
    		
    		if(token.countTokens()==26){
    			
    			System.out.println("---AA----");
    			merchantId = token.nextToken();
    			transId = token.nextToken();
    			billDeskId = token.nextToken();
    			value1 = token.nextToken();
    			txnAmount = token.nextToken();

    			bankId = token.nextToken();
    			value2 = token.nextToken();
    			txnType = token.nextToken();
    			
    			CurrencyType = token.nextToken();
    			 type2= token.nextToken();
    			value4 = token.nextToken(); 
    			value5 = token.nextToken();
    			value6 = token.nextToken();
    			transDateB = token.nextToken();
    			strAuthStatus = token.nextToken();
    			value7 = token.nextToken();
    			appNo = token.nextToken();
    			indMail = token.nextToken();
    			indName = token.nextToken();
    			transDateK = token.nextToken();
    			value8 = token.nextToken();
    			value9 = token.nextToken();
    			value10 = token.nextToken();
    			value11 = token.nextToken();
    			strErrorDescription = token.nextToken();
    			msgChecksum = token.nextToken();
    			System.out.println("---BB----");

    		}
    		else
    			{
    				System.out.println("Inside ELSE of Response***********");
    			}
    		
			
	def val1 = 	bankId	
	def bankTransactionInst 
	if(transId){
	
		System.out.println("---CC----");
	 System.out.println("transId.toInteger() Response***********"+transId);
	 System.out.println("val1 Response***********"+val1);
	 System.out.println("---DD----");
	 bankTransactionInst = BankTransactionDetails.get(transId);
	 System.out.println("bankTransactionInst Response***********"+bankTransactionInst);

		}			 
		 System.out.println("not verified-------"); 

                   		
 if(bankTransactionInst){
						 
	///if(bankTransactionInst.transactionStatus!="S")//{
	
			String checksum = "Zio5SNM7a47U"
    		String aa1 = str;
            String msgChecksum1 = "";
            System.out.println("aa1---------"+aa1);
   			String[] msgbreak=aa1.split("\\|");
   			msgChecksum1=msgbreak[msgbreak.length-1];
   			System.out.println("msgChecksum1---------"+msgChecksum1);
   		    String finalmsg="";
   		    boolean checksumMatch = false;
   		    //String strAuthStatus = "0300";
   		    System.out.println("msgbreak---------"+msgbreak);
   		    System.out.println("msgbreak.length---------"+msgbreak.length);
   		    for(int i=0;i<msgbreak.length-1;i++)
   		    {
   		    	if(!(i==msgbreak.length-2)){
   		    		finalmsg=finalmsg+msgbreak[i]+"|";

   		    	}else{
   		    		finalmsg=finalmsg+msgbreak[i];

   		    	}
   		      System.out.println("msgbreak[i]...."+msgbreak[i]);
   		    }
   		    System.out.println("finalmsg...."+finalmsg);
   		    TestHMac checksumGenerate=new TestHMac();
   		    def checksumres=checksumGenerate.HmacSHA256(finalmsg,checksum)
   		    System.out.println("checksumres...."+checksumres);
   		    
   		    if(checksumres==msgChecksum)
   		    {
   		    	System.out.println("same....");
   		    	checksumMatch = true;
   		    	
   		    }else{
   		    	
   		    	System.out.println("not same....");
   		    	checksumMatch = false;
   		    }
			
		 if(checksumMatch && strAuthStatus.equals("0300"))
   		    {
	
	                	bankTransactionInst.transactionStatus = "S";
	                	bankTransactionInst.bankId = val1
	                	bankTransactionInst.paymentGateway="BILLDESK";
						System.out.println("val1 innnnnnnnnn Response***********"+val1);
                	    def bankId1 = BankMaster.find("from BankMaster abc where abc.bankCode=?",[val1])
                 	    System.out.println("----------bank id11111---------:"+bankId1);
                	    if(bankId1){
                	    System.out.println("bankId innnnnnnnnn Response***********");
                		   bankTransactionInst.bankName = bankId1.bankName
                       	   }
                       	   else
                       	   {
                       	   System.out.println("bankId elseeeeeeeeeee Response***********");
                       		bankTransactionInst.bankName = "NA"
                       	
                       	   }
                	        	 
                          	    if(txnType=="01"){
   				bankTransactionInst.paymentType="Net Banking"
   			   }else if(txnType=="02"){
   				bankTransactionInst.paymentType="Credit"
   			   }else if(txnType=="03"){
   				bankTransactionInst.paymentType="Debit"
   			   }else if(txnType=="04"){
   				bankTransactionInst.paymentType="Cash Card"
   			   }else if(txnType=="05"){
   				bankTransactionInst.paymentType="Mobile Wallet"
   			   }else if(txnType=="06"){
   				bankTransactionInst.paymentType="IMPS"
   			   }else if(txnType=="07"){
   				bankTransactionInst.paymentType="Reward Points"
   			   }else if(txnType=="08"){
   				bankTransactionInst.paymentType="Rupay"
   			   }else {
   				bankTransactionInst.paymentType=""
   			   }
   			   //bankTransactionInst.billdeskId = billDeskId
	                		   if(!bankTransactionInst.hasErrors() && bankTransactionInst.save(flush:true)) {
	       			       		System.out.println("in bankTransactionInst save function ")
	       			       					System.out.println("In save of bankTransactionInst"+bankTransactionInst);
	       			       		System.out.println("In save of binary")
	       					} else {
	       						bankTransactionInst.errors.each {
	       					        println it
	       						}
	       						System.out.println("In Else")
	       					}
						def appId = bankTransactionInst.indApplication
						 System.out.println("appId Response***********"+appId);
						def indApplicationDetailsInstance = IndApplicationDetails.get(appId.id)
						 System.out.println("indApplicationDetailsInstance Response***********"+indApplicationDetailsInstance);
                	   indApplicationDetailsInstance.completionStatus = "completed"
                		   if(!indApplicationDetailsInstance.hasErrors() && indApplicationDetailsInstance.save(flush:true)) {
	       			       		System.out.println("in indApplicationDetailsInstance save function ");			
	       			       		System.out.println("In save of binary");
	       					} else {
	       						indApplicationDetailsInstance.errors.each {
	       					        System.out.println it
	       						}
	       						System.out.println("In Else");
	       					}
                	   def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?",[appId])
                       
                       System.out.println("appPendingInst--"+appPendingInst);
                       	   def group = GroupDistrictMaster.findByDistrict(indApplicationDetailsInstance.indUser.district)
                               	   def feeDetailsList = FeeBankOtherDetails.findAllByApplication(indApplicationDetailsInstance)
                               	System.out.println("in indApplicationDetailsInstance group group "+group);			
	       			       		System.out.println("In feeDetailsList"+feeDetailsList);
                       if(!appPendingInst){
                               System.out.println("hollaa!!!!!!!!!!!!!!!!!!!!"+appId);
                               def a = new GetData((appId.id))
                               System.out.println("-------------in get data------>")
                               a.routeApp()
                               /////////////////////////////added for allsummary report///////////////
                           //IndApplicationDetailsController inddetails=new IndApplicationDetailsController();
                           //inddetails.updateAllSummaryReport((appId.id).toString());
                           ////////////////////////////////////////end/////////////////////
                           
                       }
					   	status = "Y";
					   	System.out.println("Transaction Success in Server to Server Push"+transId.toString());
					   	strReponse=transId.toString()+"|"+billDeskId.toString()+"|"+"Updated";
						
						}
						else{
						status = "N";
						 System.out.println("Transaction checksum mismatch"+transId.toString());
						 strReponse=transId.toString()+"|"+billDeskId.toString()+"|"+"Not Updated";
						}
							
					  
							
							 
 }               			  				
else{
		
		System.out.println("unble to decrypt the data");
		strReponse=transId.toString()+"|"+billDeskId.toString()+"|"+"Not Updated";
	}


System.out.println("strReponse-------"+strReponse);
//println(strReponse);
StringToDocumentToString xmlResponse = new StringToDocumentToString()
String resXML = xmlResponse.createXML(transId,billDeskId,transDateB,status,txnAmount);
System.out.println("resXML----"+resXML);
print(resXML);
}catch(Exception e)
{
	System.out.println("Excp is....:"+e);
	e.printStackTrace();
}
%>