<%@ page import="java.text.SimpleDateFormat"%>
<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
</head>
<body>
<g:form action="" enctype="multipart/form-data" name="myform" method="post" >
<%if(appReturn){ %>
<table align="center">
<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
String strDate = sdfDestination.format(appReturn.dateCreated );

%>
<tr align="center">
                        <td colspan="2" class="headngblue" >&nbsp;</td>
                        </tr>
<tr align="center" bgcolor="grey">
                        <td colspan="2" class="headngblue" ><font color="white">Application Return Details</font></td>
                        </tr>
<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>
					
					   <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Return Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appReturn.returnNote}</td>
                      </tr>
                      
                     
                    <tr>
										
										<td align="center" valign="top" colspan="2">
										<div
											style="width: 400px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}.</div>
										</g:if>
										</span></div>
										</td>
									</tr>
</table>
<%}%>
</g:form>
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("general");
 frmvalidator.EnableFocusOnError(false); 
   // frmvalidator.EnableMsgsTogether();  

 
</script>
</body>
 