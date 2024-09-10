<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%><html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<g:javascript library="prototype" />
</head>
<body>
<table align="center">
<tr align="center">
<td width="100%" align="center">
<div >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Consent Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="">&nbsp;</td>
							</tr>
</table>

 <table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1" class="tblbdr" >
 
 <tr>
   
				<td  width="35%" align="center" class="headngblue">Consent </td>
                <td width="15%" align="center" class="headngblue">Number</td>
                <td width="15%" align="center" class="headngblue">Date</td>
				</tr>
  <g:each in="${consentDetailsList}" status="i" var="consentDetailsinst">
              	<tr align="center" >
              	<%def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
              	def x=consentDetailsinst.dateConsent
              	def date2=sdfh.format(x)
             
              	%>
              					
                        <td ><span class="txt style6">${consentDetailsinst.consent}
                        </span></td>
                        <td ><span class="txt style6">${consentDetailsinst.number}
                        </span></td>
                        
                              <td ><span class="txt style6">${date2}
                        </span></td>
					
	</tr>
</g:each> 
<tr><td align="center">
<% if(type=="REGULAR"){
		System.out.println("type...."+type)
		%>
	
	<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

		()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
			
	<%}else{%>
   
		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

	<%}%></td></tr>		
 
 					
</table>
</body>
</html>                        
                      