
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Online Consent Management And Monitoring System</title>         
  
   <%
	if(refundTransaction.paymentType=="refund"){

%>

   
   <script>
   
   
window.location='https://www.techprocess.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx?msg=<%=strMsg%>'
 
 <%
 
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

 response.sendRedirect("https://www.techprocess.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx?msg="+strMsg);
 %>
 
  </script>


<%}%>


    </head>
    
</html>
   
   
   