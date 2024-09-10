<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
a:link {
	text-decoration: none;
	color: #1E6BBD;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>

<% String cont=request.getContextPath();
%>

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
  <input type="hidden" value="<%=type%>" name="type"/>
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Bank Details</td>
					</tr>
 					<tr><td><table 	class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="15%" colspan="2" align="center"  class="txt" > For the year</td>
 					
                        <td rowspan="2" width="15%" align="center"  class="txt" > DD No./Cheque No. </td>
							  <td rowspan="2" width="380px" align="center" class="txt">Date</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Bank Name</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Branch Name</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Amount(In Rs.)</td>
                      </tr>
                      <tr bgcolor="#A8DAF3">
   					<td width="380px%" align="center"  class="txt" > From </td>
  							  <td width="380px" align="center" class="txt"> To </td>
  						</tr>
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">
  <calendar:datePicker name="fromDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
 <br><span class="sidetxt">(select date)</span></span>
	</td>
	<td bgcolor="#E8F6F9"><span class="txt style6">
	<calendar:datePicker name="toDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
	<br><span class="sidetxt">(select date)</span></span>
	</td>
  					<td bgcolor="#E8F6F9"><span class="txt style6"> <input name="ddNo"  value="${feeDetailsListByIndustry.ddChequeNo}" type="text" maxlength="15" size="6"class="txt4"  />
  						<br ><span class="sidetxt"></span></span></td>
  						<input name="appId" type="hidden" value="<%=id%>" />
						
						<td bgcolor="#E8F6F9"><span class="txt style6">
						<input name="dateval"  value="${feeDetailsListByIndustry.date}" type="text" class="txt4"  />
						<br></span>
						</td>
						<td bgcolor="#E8F6F9"><span class="txt style6"><input name="bankName"  value="${feeDetailsListByIndustry.bankName}" type="text" maxlength="250" size="15" class="txt4"  />
                        <br><span class="sidetxt">(max 250 chars)</span></span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input name="branchName"  value="${feeDetailsListByIndustry.branch}" type="text" size="15" maxlength="250" class="txt4" />
                        <br><span class="sidetxt">(max 250 chars)</span></span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/><input name="ddAmount" id="ddAmount"  value="${feeDetailsListByIndustry.amount}" type="text" maxlength="25" size="8" class="txt4" />
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
 					
 					
 					
 					<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"><b>List of DD Details added.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="15%" colspan="2" align="center"  class="txt" > For the year</td>
 					
                        <td rowspan="2" width="15%" align="center"  class="txt" > DD No./Cheque No. </td>
							  <td rowspan="2" width="380px" align="center" class="txt">Date</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Bank Name</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Branch Name</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Amount(In Rs.)</td>
                      </tr>
                      <tr bgcolor="#A8DAF3">
   					<td width="380px%" align="center"  class="txt" > From </td>
  							  <td width="380px" align="center" class="txt"> To </td>
  						</tr>
 <g:each in="${feeDetailsList}" status="i" var="feeDetailsListInst">
  <tr align="center" >
  			<td bgcolor="#E8F6F9">${feeDetailsListInst.fromDate}
  			</td>
  			<td bgcolor="#E8F6F9">${feeDetailsListInst.toDate}
  			</td>
  					<td bgcolor="#E8F6F9">${feeDetailsListInst.ddChequeNo}
                        </td>
                        <td bgcolor="#E8F6F9">${feeDetailsListInst.date}
                       </td>
                        <td bgcolor="#E8F6F9">${feeDetailsListInst.bankName}
                        </td>
                         <td bgcolor="#E8F6F9">${feeDetailsListInst.branch}
                        </td>
                        <td bgcolor="#E8F6F9"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${feeDetailsListInst.amount}
                        </td>
                         
                              
        </tr>		
      </g:each>		
 				
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					<tr>
					<td align="center">
					<% if(type=="REGULAR"){
 	           			System.out.println("type...."+type)
 	           			%>
 	           		
 	           		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

 	           			()%>/wasteManagementProcessingDetails/popBMWInspectionReport/<%=id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
 	           				
 	           		<%}else{%>
 	                  
 						<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

 	()%>/wasteManagementProcessingDetails/popBMWInspectionReport/<%=id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
 		
 					<%}%></td></tr>			
					  
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