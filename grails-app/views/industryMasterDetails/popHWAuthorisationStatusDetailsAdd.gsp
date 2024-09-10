 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Add Authorisation Details</title>
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
  <g:form  method="post" action="saveAuthorisationDetails" name="myForm2">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Hazardous Wastes Authorisation Status Details</td>
					</tr>
 					<tr><td><table 	class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="15%" align="center"  class="txt" > HW generation </td>
                        <td width="15%" align="center"  class="txt" > Applied for Authorisation</td>
							  <td width="380px" align="center" class="txt">Date of Application for HWA</td>
							  <td width="140px" align="center" class="txt">HWA Type</td>
							  <td width="140px" align="center" class="txt">Issued date</td>
							  <td width="140px" align="center" class="txt">Valid date</td>
                      </tr>

  <tr align="center" >
  				
  				
  				
  				<td bgcolor="#E8F6F9" >	<span class="txt style6"> 
  				
  					
				
				<g:select  class="txt4" from="['Yes','No']" name="generation" id="generation">  </g:select>
				<input type="hidden" name="page" value="${page}">
				
					</span>		
				
				</td>
				
				
  					<td bgcolor="#E8F6F9"><span class="txt style6"> 
  					<g:select  class="txt4" from="['Yes','No','D']" name="appliedFor" id="appliedFor">  </g:select>
  						<br ><span class="sidetxt"></span></span></td>
                        
						
						
						<td bgcolor="#E8F6F9"><span class="txt style6">
						<input name="appId" type="hidden" value="<%=appDetId%>" />
						<calendar:datePicker name="date" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
						<br><span class="sidetxt">(select date)</span></span>
						</td>
						
					
					
						<td bgcolor="#E8F6F9"><span class="txt style6">
						<g:select  class="txt4" from="['Select HWA Type','Fresh ','Renewal','Amendment']" name="type" id="type">  </g:select>
                        <br><span class="sidetxt"></span></span></td>
                        
                        
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        <calendar:datePicker name="issuedDate" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
                        <br><span class="sidetxt">(select date)</span></span></td>
                        
                        
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="validDate" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
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
  <td><div style="width: 500px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}.</div>
										</g:if>
										<g:hasErrors bean="${unitMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${unitMasterInstance}" as="list" />
										</div>
										</g:hasErrors></span></div></td></tr>
 					
 					
 					
 					
 					
 					<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm2");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
//  frmvalidator.addValidation("ddNo","req","Please enter DD/Cheque number");
//  frmvalidator.addValidation("ddNo","numeric","DD/Chque number should be numeric");
//  frmvalidator.addValidation("ddNo","minlength=6","DD/Chque number should be 6 digits");
//  frmvalidator.addValidation("ddNo","maxlength=6","DD/Chque number should be 6 digits");
//  frmvalidator.addValidation("date","req","Please enter DD/Cheque issue Date");
//  frmvalidator.addValidation("bankName","req","Please enter Bank Name");
//  frmvalidator.addValidation("bankName","maxlength=25","Bank Name should be upto 25 characters");
//  frmvalidator.addValidation("branchName","req","Please enter Branch Name/Address");
//  frmvalidator.addValidation("bankName","maxlength=50","Branch Name/Address should be upto 50 characters");
//  frmvalidator.addValidation("amount","req","Please enter DD/Chque Amount");
//  frmvalidator.addValidation("amount","decimal","DD/Chque Amount should be numeric");
 </script> 
 					
 					<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"><b>List of Authorisation Details added.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="20%" align="center"  class="txt" >HW generation</td>
                        <td width="20%" align="center"  class="txt" >Applied for Authorisation</td>
							  <td width="150px" align="center" class="txt">Date of Application for HWA</td>
							  <td width="150px" align="center" class="txt">HWA Type</td>
							  <td width="150px" align="center" class="txt">Issued date</td>
							  <td width="150px" align="center" class="txt">Valid date</td>
                      </tr>
 <g:each in="${hWAuthorisationStatusDetailsList}" status="i" var="inspectionHWAuthorisationStatusDetailsInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.generation}
                        </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.appliedFor}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.date}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.type}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.issuedDate}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.validDate}
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
  
  
  </body>