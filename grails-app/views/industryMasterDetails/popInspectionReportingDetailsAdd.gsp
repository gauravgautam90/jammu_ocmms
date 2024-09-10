<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Add Inspection and Reporting Details</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
<g:javascript library="prototype" />



<script language="javascript" type="text/javascript" src="${createLinkTo(dir:'js',file:'datetimepicker.js')}">


</script>
<calendar:resources lang="en" theme="aqua"/>
<script language="javascript" type="text/javascript">


</script>
</head>
  <body>
  <g:form  method="post" action="saveInspectionReportingDetails" name="myForm2">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 	<tr bgcolor="#D1D1D1">
<td align="center" valign="middle"  class="headngblue">Inspection and Reporting Details</td>
</tr>
 	<tr><td><table align="center" class="tblbdr">
 	
 	<tr bgcolor="#A8DAF3">
 	<td width="25%" align="center" class="txt">Name and Designation of Officials accompanied during Inspection</td>
   <td width="25%" align="center" class="txt">Date of Inspection</td>
	<td width="25%" align="center" class="txt">IR Format Type</td>

                      </tr>
                      

  <tr align="center" > 
  <td bgcolor="#E8F6F9" ><span class="txt style6"> 
  <input name="appId" type="hidden" value="<%=appDetId%>" />
  <input name="applicationId" type="hidden" value="<%=applicationId%>" />
 <textarea name="nameDesignation" rows="4" cols="30" maxlength="1000" class="txt4"></textarea></span>	
 </td>

 <td bgcolor="#E8F6F9"><span class="txt style6">
     <calendar:datePicker name="dateOfInspection" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
     <br><span class="sidetxt">(select date)</span></span>
 </td>
  <td bgcolor="#E8F6F9"><span class="txt style6"> 
  <input name="irType1" type="text" maxlength="30" value="<%=certificateFor%>" size="30" class="txt4" disabled/>
  <input name="irType" type="hidden" maxlength="30" value="<%=certificateFor%>" size="30" class="txt4" />
  <br ><span class="sidetxt"></span></span>
  </td>           
        </tr>	
     
 	<tr bgcolor="#F4F7FB">
 	<td>&nbsp;</td>
 	</tr>
 	
 	
 	
 	</table></td></tr>
 	<tr>
 	<td align="center"  ><input type="submit" name="Add" value="Add" class="actionbutton"></td>
 	</tr>
 	
 	</g:form>
 	
 	<tr align="center">
  <td><div style="width: 500px;  vertical-align: middle"><span
class="error"> <g:if test="${flash.message}">
<div class="message">${flash.message}.</div>
</g:if>
<g:hasErrors bean="${unitMasterInstance}">
<div class="errors">
<g:renderErrors bean="${unitMasterInstance}" as="list" />
</div>
</g:hasErrors></span></div></td></tr>
 	
 	
 	
 	
 	
 	
 	
 	<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
<tr>
<td align="left"> 
<span class="txt" style="color: navy"><b>List of Inspection and Reporting Details added.</b></span>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 	
 	<tr><td><table class="tblbdr" width="100%">
 	
 	
 	
 	<tr bgcolor="#A8DAF3">
 	<td width="150px" align="center" class="txt">Name and Designation of Officials accompanied during Inspection</td>
   <td width="150px" align="center" class="txt">Date of Inspection</td>
<td width="150px" align="center" class="txt">IR Format Type</td>
 	<td width="150px" align="center"  class="txt" >IR Submitted Date</td>


                      </tr>
 <g:each in="${inspectionReportingDetailsList}" status="i" var="inspectionReportingDetailsInst">
  <tr align="center" >
  
   <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionReportingDetailsInst.inspectingOfficer}<br>${inspectionReportingDetailsInst.nameDesignation}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionReportingDetailsInst.dateOfInspection}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionReportingDetailsInst.irType}
                        </span></td>
                        
  <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionReportingDetailsInst.irDate}
                        </span></td>
                         
                              
        </tr>	
      </g:each>	
 	
 	
 	
 	
 	
 	</table></td></tr>
 
  </table>
</td>
</tr>	
<%if(session.getAttribute("userMaster")){
UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
if(userType.equals("admin") || userType.equals("employee")) { 
%>
<tr>
   
  </tr>
  <%}}%>	
 
  </table>
  
  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm2");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("nameDesignation","req","Please enter Name and Designation of the Engineer");
 </script> 
  
  
  </body>
