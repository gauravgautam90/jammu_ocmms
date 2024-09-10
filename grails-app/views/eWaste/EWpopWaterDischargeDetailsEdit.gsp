<head>
<g:javascript library="prototype" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body>
<g:form name="waterSourceUses" method="post" action="deleteEWWaterDischargeDetails" >
<table align="center">

	<tr align="center">

		<td width="100%" align="center">

		<div>


<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0" id="countrytabs">
			<tr>
				<td width="11"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
					width="11" height="27" /></td>
				<td width="155" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">Water Discharge Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="432">&nbsp;</td>
			</tr>
		</table>


		<div >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 
 					
 					<tr><td><table class="tblbdr" width="100%"> 
 					<tr bgcolor="#D1D1D1">
					<td colspan="7"  align="center" valign="middle"  class="headngblue">Waste Water Discharge Details </td>
				</tr>
 					<tr bgcolor="#A8DAF3" align="center">
 					 <td width="50%" class="headngblue" ><div  class="style3">Location</div></td>
 					  <td width="50%" class="headngblue" ><div  class="style3">Quantity(m3/day)</div></td>
 					   <td width="50%" class="headngblue" ><div  class="style3">Parameter</div></td>
 					    <td width="50%" class="headngblue" ><div  class="style3">Delete</div></td>
 				
				
              	</tr>
 <g:each in="${waterGenarationList}" status="i" var="powerDetails">
  	<tr align="center" >
  					<td ><span class="txt style6">${powerDetails.location}
                        </span></td>
                        <td ><span class="txt style6">${powerDetails.quantity}
                        </span></td>
                      <td ><span class="txt style6">${powerDetails.parameter} ${powerDetails.otherParameter}
                        </span></td>
                          <td ><span class="txt style6"><input type="checkbox" name="delete" value="<%=powerDetails.id%>" />
                        </span></td>      
    </tr>		
 </g:each>			
 
 
 
 					
 
 
 
 
 
 
 
 
 
 
 					<tr bgcolor="#F4F7FB">
 					<td align="center" colspan="6"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
 					</tr>
 					</table>
 				</td></tr>
 				
  </table>
  <div align="left" class="txt" style="color: navy">
  </br></br>
  &nbsp;<b>* Instructions:</b>
  &nbsp;<ul> 
  <li>Please select the checkbox to delete the water discharge details and click "Delete" button</li>
  <li>Select multiple check box and click "Delete" button to delete multiple records</li>
  <li>To edit the water discharge details, delete the water discharge details and then add new one</li>
  </ul>
  

</div>
		</div>
		</div>
		</td>
	</tr>

	<tr>



	</tr>



</table>
<!-- - -->

  		</g:form>
  		
  		
  		<script language="JavaScript" type="text/javascript">
 var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("location","req","Please enter the Location");
  frmvalidator.addValidation("quantity","dec","Please enter decimal or numeric value in Quantity");
   
 
  
  
 </script>  
</body>