 
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
  <g:form  method="post" action="saveAnnualProduction" name="myForm" enctype="multipart/form-data">
  

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
 					
 	
 					
 					
					<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"></br><b>List of Quantity of products dispatched (wherever applicable).</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="150px" align="center"  class="txt" >Sr.no</td>
                     <td width="150px" align="center"  class="txt" > Product dispatched</td>
					<td width="150px" align="center" class="txt">Quantity</td>
					 <td width="150px" align="center" class="txt">Unit</td>
				    
					 </tr>
      <g:each in="${hwmAnnualReturnList}" status="i" var="previousAuthDetailsInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${i+1}
                        </span></td>
  					    <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.productName}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.quantity}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.unit}&nbsp&nbsp&nbsp
                        </span><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteHazardeousPartDDetailsRecord/<%=previousAuthDetailsInst.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" class="actionbutton">  <input type="button" value="Delete" class="actionbutton">	</a></td>
                       
                        
                       
                         
        </tr>		
      </g:each>		
 		
 			
 					
 					</table></td></tr>
						
 					<tr><td><span class="txt" style="color: navy"><b>Click on Delete button to Delete details.</b></span>
 			 		</td></tr>	
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>
  
  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("authattach","req","Please attach a required pdf file");
  frmvalidator.addValidation("ddNo","numeric","DD number should be numeric");
//  frmvalidator.addValidation("ddNo","minlength=6","DD number should be 6 digits");
//  frmvalidator.addValidation("ddNo","maxlength=6","DD number should be 6 digits");
  frmvalidator.addValidation("date","req","Please enter DD issue Date");
  frmvalidator.addValidation("bankName","req","Please enter Bank Name");
  frmvalidator.addValidation("bankName","maxlength=25","Bank Name should be upto 25 characters");
  frmvalidator.addValidation("branchName","req","Please enter Branch Name/Address");
  frmvalidator.addValidation("bankName","maxlength=50","Branch Name/Address should be upto 50 characters");
  frmvalidator.addValidation("ddAmount","req","Please enter DD Amount");
  frmvalidator.addValidation("ddAmount","numeric","DD Amount should be numeric or decimal");
 </script> 
  </body>