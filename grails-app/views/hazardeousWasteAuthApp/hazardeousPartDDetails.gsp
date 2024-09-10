 
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
  <g:form  method="post" action="saveHazardeousPartDDetails" name="myForm" enctype="multipart/form-data">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Quantity of products dispatched (wherever applicable)</td>
					</tr>
 					<tr><td><table 	class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="150px" align="center"  class="txt" >Sr.no</td>
                     <td width="150px" align="center"  class="txt" > Product dispatched</td>
					<td width="150px" align="center" class="txt">Quantity</td>
					 <td width="150px" align="center" class="txt">Unit</td>
				     </tr>



  <tr align="center" >
 
  				
  					<td bgcolor="#E8F6F9"><span class="txt style6"> 
  					<input name="AuthorisationNo" type="text" readonly value="1"  size="5" class="txt4"  />
  						<br ><span class="sidetxt"></span></span></td>
  						<td bgcolor="#E8F6F9"><span class="txt style6"> 
  	  					<input name="productName" type="text" id="productName"  size="35" class="txt4"  />
  	  						<br ><span class="sidetxt"></span></span></td>
  	  					<td bgcolor="#E8F6F9"><span class="txt style6"> 
  	  					<input name="quantity" type="number" id="quantity"  size="15" class="txt4"  />
  	  						<br ><span class="sidetxt"></span></span></td>
			    
  	  					<td bgcolor="#E8F6F9"><span class="txt style6"> 
  	  				<select name="unit" id="unit">
  	 			 <option value="">Select Unit</option>
  	 			  <option value="Metric Ton">Metric Ton</option>
  	 			  <option value="Kilo Liter">Kilo Liter</option>
  	 			  <option value="Number">Number</option>
  	  						<br ><span class="sidetxt"></span></span></td>
						
                      
        </tr>		
        <input name="returnId" type="hidden" value="<%=returnId%>" />
                     <tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					</table></td></tr>
 					<tr>
 					<td align="center"  ><input type="submit" name="Add" value="Add" onclick="return myFunction();" class="actionbutton"></td>
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
					<span class="txt" style="color: navy"><b>List of Quantity of products dispatched.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="150px" align="center"  class="txt" >Sr.no</td>
                     <td width="150px" align="center"  class="txt" > Product dispatched<span style="color:red">*</span></td>
					<td width="150px" align="center" class="txt">Quantity<span style="color:red">*</span></td>
					 <td width="150px" align="center" class="txt">Unit<span style="color:red">*</span></td>
				     </tr>
      <g:each in="${hwmAnnualReturnList}" status="i" var="previousAuthDetailsInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${i+1}
                        </span></td>
  					    <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.productName}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.quantity}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.unit}
                        </span></td>
                       
                       
                         
        </tr>		
      </g:each>		
 		
 			
 					
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>
  <script>
  function myFunction() {

  var x = document.getElementById("productName").value;
  if(x==""){
  alert("Please Select Product Name");
  document.getElementById("productName").focus();
   return false;
    }
  var x2 = document.getElementById("quantity").value;
  if(x2==""){
  alert("Please Enter Quantity ");
  document.getElementById("quantity").focus();
   return false;
    }

  var x3 = document.getElementById("unit").value;
  if(x3==""){
  alert("Please Select Unit");
  document.getElementById("unit").focus();
   return false;
    }
 


  	}

  </script> 
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