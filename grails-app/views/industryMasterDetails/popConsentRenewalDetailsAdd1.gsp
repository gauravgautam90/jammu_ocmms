<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Add Consent/Renewal Details</title>
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
  <g:form  method="post" action="saveConsentRenewalDetails1" name="myForm2" enctype="multipart/form-data">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 	<tr bgcolor="#D1D1D1">
<td align="center" valign="middle"  class="headngblue">Consent/Renewal Details</td>
</tr>
 	<tr><td><table class="tblbdr">
 	
 	<tr bgcolor="#A8DAF3">
 	<td width="140px" align="center" class="txt">Date of Application</td>
   	<td width="140px" align="center" class="txt">Consent Application (Consents/Renewals)</td>
	<td width="140px" align="center" class="txt">Issued Date</td>
 	<td width="140px" align="center"  class="txt" >Valid Date</td>
    <td width="140px" align="center"  class="txt" >Status and reason for pending if not issued</td>
    <td width="140px" align="center"  class="txt" >Attach Document</td>

                      </tr>

  <tr align="center" >
 
 
 
  <td bgcolor="#E8F6F9" >	<span class="txt style6"> 
 
 <calendar:datePicker name="dateOfApp" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
                        <br><span class="sidetxt">(select date)</span></span></td>

<td bgcolor="#E8F6F9"><span class="txt style6">
    <g:select class="txt4" from="${['Select Consent Application','CTE','CTE-Revised','CTE-Extension','CTE-Expansion','CTO-After CTE','CTO-Direct','CTO-Expansion','CTO-Renewal']}" name="consentApp" id="consentApp"  > </g:select>
                        <br><span class="sidetxt"></span></span></td>
 
<td bgcolor="#E8F6F9"><span class="txt style6">
 <calendar:datePicker name="issueDate" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
                        <br><span class="sidetxt">(select date)</span></span></td>
                        

 <td bgcolor="#E8F6F9"><span class="txt style6">
 <input name="appId" type="hidden" value="<%=appDetId%>" />
 <input name="applicationId" type="hidden" value="<%=appId%>" />
 <input type="hidden" name="page" value="${page}"/> 
                        <calendar:datePicker name="validDate" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
                        <br><span class="sidetxt">(select date)</span></span></td>
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">
    <g:select class="txt4" from="${['Select Status','Issued','Court Case','Closure order Issued','Closed and vacated-File to be closed','Directions Issued','Non-compliance of Consent Order conditions','Not in operation temporarily','Consent Fee Not Paid','Performance of APC measures','Performance of ETP/STP','Application Rejected','Application Returned','Show Cause Notice Issued','Under Process at CO','Under Process at DO','Under Process at ZO']}" name="status" id="status"  > </g:select>
                        <br><span class="sidetxt"></span></span></td>
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">
    					<input type="file" name="consentOrderFile" id="consentOrderFile"/></span><span class="sidetxt ">(.pdf max of 5MB in size)</span>
                        <br><span class="sidetxt"></span></span></td>
 
                        
                        
                        
                        
                      
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
<span class="txt" style="color: navy"><b>List of Consent/Renewal Details added.</b></span>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 	
 	<tr><td><table class="tblbdr" width="100%">
 	
 	
 	
 <tr bgcolor="#A8DAF3">
 	<td width="150px" align="center" class="txt">Date of Application</td>
   	<td width="150px" align="center" class="txt">Consent Application (Consents/Renewals)</td>
	<td width="150px" align="center" class="txt">Issued Date</td>
 	<td width="150px" align="center"  class="txt" >Valid Date</td>
    <td width="150px" align="center"  class="txt" >Status and reason for pending if not issued</td>
    <td width="150px" align="center"  class="txt" >Consent Order</td>


                      </tr>
 <g:each in="${consentRenewalDetailsList}" status="i" var="consentRenewalDetailsInst">
  <tr align="center" >
  
   <td bgcolor="#E8F6F9"><span class="txt style6">${consentRenewalDetailsInst.dateOfApp}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentRenewalDetailsInst.consentApp}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentRenewalDetailsInst.issueDate}
                        </span></td>
                        
  <td bgcolor="#E8F6F9"><span class="txt style6">${consentRenewalDetailsInst.validDate}
                        </span></td>
  <td bgcolor="#E8F6F9"><span class="txt style6">${consentRenewalDetailsInst.status}
                        </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">
                <%
                def consentRenewalInst=ConsentRenewalDetails.get(consentRenewalDetailsInst.id) 
				def consentOrderFile = ExistingConsentFileRecord.find("from ExistingConsentFileRecord afd where afd.consentDetails=?",[consentRenewalInst])
				%>
				<% if(consentOrderFile){%>
                        <g:def var="fooVar" value="${consentRenewalDetailsInst.id}"/>
						<g:link action="viewConsentOrderFile" controller="industryMasterDetails" params="[appliLoc:fooVar,verValue:versionVal]">
						<span class="innerlink"><span class="innerlink"><u>Click to Download</u></span></g:link>
				<%}%>
                        
                        </span>
               </td>
                        
                       
                         
                              
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
    	frmvalidator.addValidation("consentOrderFile","req","please Browse Any File");
    	function Checkfiles()
		{
		  var frm = document.forms["myForm2"];  
		  var fupp = document.getElementsByName('consentOrderFile');
		  var fup = fupp[0];
		  var fileName = fup.value;
		  var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();		  
		  if(ext == "pdf" || fileName =="" )
		           return true;
		  else
		      {
		          sfm_show_error_msg('Please upload only pdf files',fupp);		                       
		           return false;
		      }
		}
		      frmvalidator.setAddnlValidationFunction("Checkfiles"); 
		    					
    			 

 </script>    	
  
  
  </body>
