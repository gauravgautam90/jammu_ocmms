 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Add Fee Details</title>
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

<script language="javascript" type="text/javascript">

function select4()
{

var selectmenu1=document.getElementById("feeFor")
selectmenu1.onchange=function()
 {    
 
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Application Form")
   	 {
   	 
   	 document.getElementById('ddAmount').value = '500';
	 }
else{
 
    document.getElementById('ddAmount').value = '';
   		 }
   }
}
</script>
</head>
  <body>
  <g:form  method="post" action="saveBankFeeDetails" name="myForm">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Bank Details</td>
					</tr>
 					<tr><td><table 	class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					
                        <td width="15%" align="center"  class="txt" > DD No./Cheque No. </td>
							  <td width="380px" align="center" class="txt">Date</td>
							  <td width="140px" align="center" class="txt">Bank Name</td>
							  <td width="140px" align="center" class="txt">Branch Name</td>
							  <td width="140px" align="center" class="txt">Amount(In Rs.)</td>
                      </tr>

  <tr align="center" >
  
  					<td bgcolor="#E8F6F9"><span class="txt style6"> <input name="ddNo" type="text" maxlength="15" size="6"class="txt4"  />
  						<br ><span class="sidetxt"></span></span></td>
                        
						<td bgcolor="#E8F6F9"><span class="txt style6">
						
						<input name="appId" type="hidden" value="<%=appDetId%>" />
						<calendar:resources lang="en" theme="aqua"/> <calendar:datePicker name="dateval"  dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>
						<br><span class="sidetxt">(select date)</span></span>
						</td>
						<td bgcolor="#E8F6F9"><span class="txt style6"><input name="bankName" type="text" maxlength="250" size="15" class="txt4"  />
                        <br><span class="sidetxt">(max 250 chars)</span></span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input name="branchName" type="text" size="15" maxlength="250" class="txt4" />
                        <br><span class="sidetxt">(max 250 chars)</span></span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/><input name="ddAmount" id="ddAmount" type="text" maxlength="25" size="8" class="txt4" />
                        <br><span class="sidetxt">(max 25 digits)</span></span></td>
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
 					
 					<g:form  method="post" action="saveChequeAttach" name="myForm1" enctype="multipart/form-data">
 					<input name="appId1" type="hidden" value="<%=appDetId%>" />
 					<tr bgcolor="#A8DAF3">
 					<td class="txt style6" colspan="6">Please Attach Scan Copy Of all Drafts/Cheques <input type="file" name="draftattach" id="draftattach"> <input type="submit" name="Attach" value="Attach" class="actionbutton"></td>
 					
 					</tr>
 					</g:form>
 					
 					
 					<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"><b>List of DD Details added.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					
                        <td width="20%" align="center"  class="txt" >DD No./Cheque No.</td>
							  <td width="150px" align="center" class="txt">Date</td>
							  <td width="150px" align="center" class="txt">Bank Name</td>
							  <td width="150px" align="center" class="txt">Branch Name</td>
							  <td width="150px" align="center" class="txt">Amount(In Rs.)</td>
                      </tr>
 <g:each in="${feeDetailsList}" status="i" var="feeDetailsListInst">
  <tr align="center" >
  
  					<td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.ddChequeNo}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.date}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.bankName}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.branch}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${feeDetailsListInst.amount}
                        </span></td>
                         
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB" >
 					<td class="txt style6" align="right" colspan="3">Scaned Copy of Drafts/Cheques &nbsp;: </td>
 					<td class="txt style6" align="left" colspan="3"><%if(feeCheque){%>	<g:def var="fooVar" value="${appDetId}"/><g:link action="viewChequeAttached" controller="industryMasterDetails" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
<%}%></td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>
  
  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("ddNo","req","Please enter DD/Cheque number");
  frmvalidator.addValidation("ddNo","numeric","DD/Chque number should be numeric");
//  frmvalidator.addValidation("ddNo","minlength=6","DD/Chque number should be 6 digits");
//  frmvalidator.addValidation("ddNo","maxlength=6","DD/Chque number should be 6 digits");
  frmvalidator.addValidation("date","req","Please enter DD/Cheque issue Date");
  frmvalidator.addValidation("bankName","req","Please enter Bank Name");
  frmvalidator.addValidation("bankName","maxlength=25","Bank Name should be upto 25 characters");
  frmvalidator.addValidation("branchName","req","Please enter Branch Name");
  frmvalidator.addValidation("bankName","maxlength=50","Branch Name should be upto 50 characters");
  frmvalidator.addValidation("ddAmount","req","Please enter DD/Chque Amount");
  frmvalidator.addValidation("ddAmount","numeric","DD/Chque Amount should be numeric or decimal");
 </script> 
  </body>