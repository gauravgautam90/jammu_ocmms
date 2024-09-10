 
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
function nonZero(){
var selectmenu1=document.getElementById("ddAmount").value

if(selectmenu1==0){
alert("please enter Amount more then zero");
document.getElementById("ddAmount").value=""
}
}
function select4()
{

var selectmenu1=document.getElementById("feeFor")
selectmenu1.onchange=function()
 {    
 
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Other")
   	 {
   	
   	 document.getElementById('selectTemp5').style.display = 'block';
	 }
else{
 
   document.getElementById('selectTemp5').style.display = 'none';
   		 }
   }
}
</script>
</head>
  <body>
  <g:form  method="post" action="saveBankOtherFeeDetails" name="myForm">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Consent Fee Details</td>
					</tr>
 					<tr><td><table 	class="tblbdr" width="100%">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="15%" align="center"  class="txt" > Fee For </td>
                       	   <td width="140px" align="center" class="txt">Amount(In Rs.)</td>
							    
							 
							
                      </tr>

  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6"> <select name="feeFor" id="feeFor" onclick="javascript:select4()" class="txt4">
													      				 <%if(app.applicationType=="CTE"){%>
													      				<option value="CTE">CTE</option>
													      				
													      				<%}else if(app.applicationType=="CTO"){%>
													      				<option value="CTO">CTO</option>
													      			<!--	<option value="CTO Water">CTO Water</option>
													      		<option value="CTO Both">CTO Both</option> -->
													      				<%}%>	
													      				
															<!--		   <option value="Sample Testing AIR">Sample Testing AIR</option>
																	 	 <option value="Sample Testing WATER">Sample Testing WATER</option>
																	 	 <option value="Sample Testing BOTH">Sample Testing BOTH</option>
																	 	  <option value="Late fee Air">Late fee Air</option>	
													      			 	 	 	 <option value="Late fee Water">Late fee Water</option>	
																														    
														       <option value="Performance security fee">Performance security fee</option>
													      	-->			
														       </select>
  						<br >
  						<div style="display:none; border:0;"  id="selectTemp5"  >
  						<input name="otherDetail" id="otherDetail" type="text" value="" AUTOCOMPLETE=OFF/>
  						</div>
  						<span class="sidetxt"></span></span></td>
  					     
							<input name="appId" type="hidden" value="<%=appDetId%>" />
						 
						 
						 
						
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input name="ddAmount" id="ddAmount" onBlur="nonZero()" type="text" maxlength="25" size="8" AUTOCOMPLETE=OFF class="txt4" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>
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
 					
 					
 					<!--
 					<g:form  method="post" action="saveChequeAttachFee" name="myForm1" enctype="multipart/form-data">
 					<input name="appId1" type="hidden" value="<%=appDetId%>" />
 					<tr bgcolor="#A8DAF3">
 					<td class="txt style6" colspan="6">Please Attach Fee Details(if any) <input type="file" name="draftattach" id="draftattach"> <input type="submit" name="Attach" value="Attach" class="actionbutton"></td>
 					
 					</tr>
 					</g:form>
 					-->
 					
 					<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"><b>List of Fee Details added.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="50%" align="center"  class="txt" >Fee For</td>
                       	  
							  <td width="150px" align="center" class="txt">Amount(In Rs.)</td>
							 
                      </tr>
 <g:each in="${feeDetailsList}" status="i" var="feeDetailsListInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.feeFor}
                        </span></td>
  					      <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.amount}<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>
                        </span></td>
                       
                         
                              
        </tr>		
      </g:each>		
 					
 			 <tr align="center" >
  
                        <td colspan="2" align="center"
                       bgcolor="#A8DAF3"><span class="txt style6"><b>Total Fee :   ${totalfee} </b>
                        </span><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
                         
                              
        </tr>	<!--		
 				<tr bgcolor="#F4F7FB" >
 					<td class="txt style6" align="right">Scaned Copy of Fee Details     &nbsp;: </td>
 					<td class="txt style6" align="left" ><%if(feeCheque){%>	<g:def var="fooVar" value="${appDetId}"/><g:link action="viewChequeAttachedFee" controller="indApplicationDetails" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
<%}%></td>
 					</tr>	
 					-->	
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>
  
  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
   frmvalidator.addValidation("ddAmount","req","Please enter Amount");
  frmvalidator.addValidation("ddAmount","numeric","Amount should be numeric or decimal");
 </script> 
  </body>