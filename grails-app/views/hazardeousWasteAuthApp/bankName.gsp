
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Online Consent Management And Monitoring System</title>         
    <%
				String merchant = "PPCB"
			String date1 = new SimpleDateFormat("dd-MM-yyyy hh:mm").format(new Date());
			
				  String prn1 = session.getAttribute("random")	
				 String depositer = indApplicationDetailsInstance.industryRegMasterObj.occName
				  String applicationId = indApplicationDetailsInstance.id
				  
				  session.appId = applicationId
				  def amount1 = session.getAttribute("fee")
				  
				 def feesOnline = FeeBankOtherDetailsHWM.findAll("from FeeBankOtherDetailsHWM fee where fee.application=?",[indApplicationDetailsInstance])
				
				
				  
				  def indName = indApplicationDetailsInstance.industryRegMasterObj.indName
				  def indAddress = indApplicationDetailsInstance.industryRegMasterObj.indAddress+", "+indApplicationDetailsInstance.industryRegMasterObj.indCity+", "+indApplicationDetailsInstance.industryRegMasterObj.tehsil.tehsilName+", "+indApplicationDetailsInstance.industryRegMasterObj.district.districtName
				  def waterCess = "0"
				  def nocFee = "0"
				  def waterCons = "0"
				  def airCons = "0"
				  def bmw = "0"
				  def testingFee = "0"
				  def ebg = "0"
				  def hmw = "0"
				  def ihw = "0"
				  def formFee = "0"
				  def misc = "0"
				  def misc1 = "0"
				  def interest = "0"
				  if(feesOnline.feeFor.contains('HWM'))
				{
				
					def feesOnline1 = FeeBankOtherDetailsHWM.find("from FeeBankOtherDetailsHWM fee where fee.feeFor='HWM' and fee.application=?",[indApplicationDetailsInstance])
					bmw = feesOnline1.amount
				}
    	  
    	 
    	  
    	  		if(feesOnline.feeFor.contains('Application Form'))
    	  		{
			
    	  			def feesOnline2 = FeeBankOtherDetailsHWM.find("from FeeBankOtherDetailsHWM fee where fee.feeFor='Application Form' and fee.application=?",[indApplicationDetailsInstance])
    	  			
    	  			formFee = feesOnline2.amount
    	  		}
    	  		
    	  		if(feesOnline.feeFor.contains('Balance Fee'))
    	  		{
			
    	  			def feesOnline3 = FeeBankOtherDetailsHWM.find("from FeeBankOtherDetailsHWM fee where fee.feeFor='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
    	  			
    	  			misc = feesOnline3.amount
    	  		}
    	  		
    	  		
    	  			def feesOnline4 = FeeBankOtherDetailsHWM.find("from FeeBankOtherDetailsHWM fee where fee.feeFor!='Application Form' and fee.feeFor!='HWM' and fee.feeFor!='Balance Fee' and fee.application=?",[indApplicationDetailsInstance])
    	  			
    	  			
    	  			
    	  			
    	  			if(feesOnline4)
    	  			{
    	  				misc = misc + feesOnline4.amount
    	  			}
    	  			
    	  			if(bmw!='0')
    	  			{
    	  			bmw = bmw + misc
    	  			}
    	  			
				  System.out.println("bmw--->"+bmw)
				  
				  EncodeDecode encodeDecode = new EncodeDecode()
				  
				  String data = "prn="+prn1+"&amount="+amount1
				  
				   def data2 = "app_id="+indApplicationDetailsInstance+"&Int="+interest
				  def data3 = "noc_fee="+nocFee+"&water_cons="+waterCons+"&air_cons="+airCons
				  def data4 = "testing_fee="+testingFee+"&ebg="+ebg+"&hmw="+hmw+"&ihw="+ihw+"&form_fee="+formFee
				  def data5 = "water_cess="+waterCess+"&bmw="+bmw+"&misc="+misc1
				 
    	 String  encdata1 = encodeDecode.Encrypt(data,"a@m#i@t");
    	 String encdata2 = encdata1.replace("+","~")
		
		def encdata11 = encodeDecode.Encrypt(data2,"a@m#i@t");
		def encdata12 = encodeDecode.Encrypt(data3,"a@m#i@t");
		def encdata13 = encodeDecode.Encrypt(data4,"a@m#i@t");
		def encdata14 = encodeDecode.Encrypt(data5,"a@m#i@t");
		
    	 String encdata21 = encdata11.replace("+","~")
    	 String encdata22 = encdata12.replace("+","~")
    	 String encdata23 = encdata13.replace("+","~")
    	 String encdata24 = encdata14.replace("+","~")
    	
		
		String abc = "NIAfqT5DxFLk8inh5u~h1gF5EPWa0hQt~1WUjjfvpy/9ITKkxB/L3A3s83FwStAEXIghZNt99US/dtbbx7BJqI99/KvGawX3KFKCQB8DFL57DKVreQUlLS99c4gK3Sc9CODQNqcz073sVc4e6BRGiu7E06iWMqveha2KOJ8RoelKhEzMCzLIS/Z0Ab8tCnApJFu5~3X5ac6mzwkuRRF4nWIxip4kd5Uxe2tsqQ0/17LL2AznzHeXABq78Zr/QFT0"
		
		String abc2 = abc.replace("~","+")
		String str1=encodeDecode.Decrypt(abc2,"a@m#i@t");
		
    String[] res = str1.split("&");
  
   
    String[] desName = res[0].split("=");
	 String[] desName1 = res[1].split("=");
	 String[] desName2 = res[2].split("=");
	 String[] desName3 = res[3].split("=");
	 String[] desName4 = res[4].split("=");
	 String[] desName5 = res[5].split("=");
	 String[] desName6 = res[6].split("=");
	 String[] desName7 = res[8].split("=");
  	
  		
  		
		 String depositorVal = desName[1]
		 String merVal = desName1[1]
		 String dateVal = desName2[1]
		 String amtVal = desName3[1]
		 String prnVal = desName4[1]
		 String cinVal = desName5[1]
		 String bankVal = desName6[1]
		  String statusVal = desName7[1]
	 
				%>
     <%
		
		if(bankTransaction.bankName=="PNB"){%>
    
    <script>

window.location='https://gateway.netpnb.com/HSPCB/Getparameters.aspx?encdata=<%=encdata2%>&Industry_add=<%=indAddress%>&depositerName=<%=depositer%>&industryName=<%=indName%>&merchantName=<%=merchant%>&date=<%=date1%>&encdata3=<%=encdata21%>&encdata4=<%=encdata22%>&encdata5=<%=encdata23%>&encdata6=<%=encdata24%>&encdata7=<%=encdata25%>&district=<%=district%>&group=<%=group%>'
</script>

<%}else if(bankTransaction.bankName=="other"){

%>

   
   <script>
   
 <!--  
window.location='https://www.tpsl-india.in/PaymentGateway/TransactionRequest.jsp?strMsg=<%=strMsg%>'
 -->
 <%
 

System.out.println("strin in gps-------"+strMsg)
  response.sendRedirect(strMsg);
 
 %>
 
  </script>


<%}else{
%>

   
   <script>
 
 <%
 
 
 System.out.println("strin in gps-------"+strMsg)
  response.sendRedirect(strMsg);
 %>
 
  </script>


<%}%>

    </head>
    
</html>
