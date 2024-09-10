
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Online Consent Management And Monitoring System</title>         
  
   <%
		
		System.out.println("refundTransaction.paymentType---"+refundTransaction.bankName)
		
		if(refundTransaction.paymentType=="refund"){

%>

   
   <script>
   
   
window.location='https://www.tpsl.co.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx?msg=<%=strMsg%>'
 
 <%
 
 System.out.println("strin in gps--qweeeeeeeeee-----")
System.out.println("strin in gps-------"+strMsg)
//  response.sendRedirect(strMsg);
 response.sendRedirect("https://www.techprocess.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx?msg="+strMsg);
 %>
 
  </script>


<%}else{
%>
<!--
   window.location='https://www.tpsl.co.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx?msg=<%=strMsg%>'
  -->
   <script>
 
 <%
 
 System.out.println("strin in gps----rrrrrrrrrrrrrrrrrrrrr---")
 System.out.println("strin in gps-------"+strMsg)
 response.sendRedirect("https://www.techprocess.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx?msg="+strMsg);
 %>
 
  </script>


<%}%>


    </head>
    
</html>
   
   
   