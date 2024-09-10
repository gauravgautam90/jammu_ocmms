<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >

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
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Application Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432"><a href="javascript:window.print()">print</a></td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 				
 				<% int varCheck=0; 
 				 int varCheckIns = 0;
 					int varCheckCla=0;
 					int varCheckCl=0;
 				%>
 					<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="applicationProcessingDetailsInstance">
 					<tr><td><table>
 					<% 
 					
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );
%>
 					
 					<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left"><span class="txt style6">
                         <%=strDate%>
                        </span></td>
                      </tr>
 
  <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Note By:</div></td>
                        <td ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})</span></div></td>
        </tr>		
        <tr >
                         <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Forwarded To:</div></td>
                        <td ><div align="left"><span class="txt style6"><%if( (i+1)<applicationProcessingDetailsInstanceList.size() && applicationProcessingDetailsInstanceList.get(i+1)){out.print((applicationProcessingDetailsInstanceList.get(i+1)).role);}else{out.print(currentPending);} %></span></div></td>
        </tr>	
					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.role.roleName=='Industry'}"><g:def var="versionVal1" value="${varCheckCla}"/><g:def var="foooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewFileClarification" controller="applicationProcessingDetails" params="[appliLoc:foooVar,docName:'Clarification',docType:'pdf',verValue:versionVal1]">View Document</g:link><% varCheckCla=varCheckCla+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.fileNote}  </span></td>
                      </tr>
		
 					
 					
 					
 					
 					</table></td></tr>
						<tr><td>&nbsp;</td></tr>
					</g:each>
					  
  </table>
	  
  			

  <tr>

    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>

  </tr>

  

</table>

</body>
</html>
 