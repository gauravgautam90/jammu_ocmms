<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Add GFA Upadation Details</title>
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
  <g:form  method="post" action="saveGFAUpadationDetails" name="myForm2">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 	<tr bgcolor="#D1D1D1">
<td align="center" valign="middle"  class="headngblue">GFA Upadation Details</td>
</tr>
 	<tr><td><table class="tblbdr" align="center" border="0">
 	
 	<tr bgcolor="#A8DAF3">
 	<td width="100px" align="center" class="txt">Unit's document(BS/AC) with submission date</td>
   	<td width="100px" align="center" class="txt">Financial Year</td>
	<td width="100px" align="center" class="txt">Plant and machinery cost in Lakhs</td>
 	<td width="100px" align="center"  class="txt" >Total Gross Fixed Assets in Lakhs</td>
    <td width="20%" align="center"  class="txt" >As on (as per BS/AC)</td>

                      </tr>

  <tr align="center" >
 
 
 
  <td bgcolor="#E8F6F9" >	<span class="txt style6"> 
 
 <input name="unitDocument" type="text" maxlength="30" size="20" class="txt4" />
</span>	
</td>

<td bgcolor="#E8F6F9"><span class="txt style6">
                         <input name="financialYear" type="text" maxlength="15" size="20" class="txt4" />
                        <br><span class="sidetxt"></span></span></td>
  <td bgcolor="#E8F6F9"><span class="txt style6"> 
  <input name="cost" type="text" maxlength="10" size="20" class="txt4" />
  <br ><span class="sidetxt"></span></span></td>
                        
<td bgcolor="#E8F6F9"><span class="txt style6">
<input name="totalGross" type="text" maxlength="10" size="20" class="txt4" />
                        <br><span class="sidetxt"></span></span></td>
                        

 <td bgcolor="#E8F6F9"><span class="txt style6">
 <input name="appId" type="hidden" value="<%=appDetId%>" />
                        <calendar:datePicker name="asOn" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
                        <br><span class="sidetxt">(select date)</span></span></td>
                        
                        
                        
                        
                        
                        
                      
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
  <td><div style="width: 500px;  vertical-align: middle"><span class="error"> <g:if test="${flash.message}">
<div class="message">${flash.message}.</div>
</g:if>
<g:hasErrors bean="${unitMasterInstance}">
<div class="errors">
<g:renderErrors bean="${unitMasterInstance}" as="list" />
</div>
</g:hasErrors></span></div></td></tr>
 	
 
 	<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
	<tr align="center">
	<td align="center"> 
	<span class="txt" style="color: navy"><b>List of GFA Upadation Details added.</b></span>
	<table class="tblbdr" width="80%" align="center">
 	<tr bgcolor="#A8DAF3">
	 	<td width="100px" align="center" class="txt">Unit's document(BS/AC) with submission date</td>
	    <td width="100px" align="center" class="txt">Financial Year</td>
		<td width="100px" align="center" class="txt">Plant and machinery cost in Lakhs</td>
	 	<td width="100px" align="center"  class="txt" >Total Gross Fixed Assets in Lakhs</td>
	    <td width="20%" align="center"  class="txt" >As on (as per BS/AC)</td>
	</tr>
  	<g:each in="${gFAUpadationDetailsList}" status="i" var="gFAUpadationDetailsInst">
  	<tr align="center" >  
	   <td bgcolor="#E8F6F9"><span class="txt style6">${gFAUpadationDetailsInst.unitDocument}</span></td>
	   <td bgcolor="#E8F6F9"><span class="txt style6">${gFAUpadationDetailsInst.financialYear}</span></td>
	   <td bgcolor="#E8F6F9"><span class="txt style6">${gFAUpadationDetailsInst.cost}</span></td>                        
	   <td bgcolor="#E8F6F9"><span class="txt style6">${gFAUpadationDetailsInst.totalGross}</span></td>
	   <td bgcolor="#E8F6F9"><span class="txt style6">${gFAUpadationDetailsInst.asOn}</span></td>
    </tr>	
    </g:each>	
  </table>
</td>
</tr>	
	<%if(session.getAttribute("userMaster")){
	UserMaster aa = (UserMaster)session.getAttribute("userMaster");	
	String userType = aa.accessLevel
	if(userType.equals("admin") || userType.equals("employee")) { 
	%>
  <%}}%>	
 
  </table>
  
  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm2");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("unitDocument","req","Please enter unit's Document");
  frmvalidator.addValidation("financialYear","req","Please enter financial Year");
  frmvalidator.addValidation("cost","req","Please enter Plant and Machinery cost");
  frmvalidator.addValidation("totalGross","req","Please enter Total Gross");
 // frmvalidator.addValidation("asOn","req","Please enter As on Date");
  frmvalidator.addValidation("totalGross","dec","Total Gross should be decimal");
  frmvalidator.addValidation("cost","dec","Plant and Machinery cost should be decimal");
//  frmvalidator.addValidation("branchName","req","Please enter Branch Name/Address");
//  frmvalidator.addValidation("bankName","maxlength=50","Branch Name/Address should be upto 50 characters");
//  frmvalidator.addValidation("amount","req","Please enter DD/Chque Amount");
//  frmvalidator.addValidation("amount","decimal","DD/Chque Amount should be numeric");
 </script> 
  
  
  </body>
