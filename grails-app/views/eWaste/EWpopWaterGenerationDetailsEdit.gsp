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
<g:form name="waterSourceUses" method="post" action="deleteEWWaterGenerationDetails" >
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
					class="top-lnks"><a href="#" rel="country1">Water Generation Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="432">&nbsp;</td>
			</tr>
		</table>



		<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 
 					
 					<tr><td><table class="tblbdr" width="100%"> 
 					
 					<tr bgcolor="#A8DAF3" align="center">
 					 <td width="50%" class="headngblue" ><div  class="style3">Source Generation</div></td>
 					 <td width="50%" class="headngblue" ><div  class="style3">Quantity (m3/day)</div></td>
 					  <td width="50%" class="headngblue" ><div  class="style3">Delete</div></td>
 					  
              	</tr>
 <g:each in="${waterGenarationList}" status="i" var="powerDetails">
  	<tr align="center" >
  					<td ><span class="txt style6">${powerDetails.modeUse} ${powerDetails.otherSource}
                        </span></td>
                      <!--  <td ><span class="txt style6">${powerDetails.quantity}
                        </span></td>
                        --><td ><span class="txt style6">${powerDetails.quantity}
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
  <li>Please select the checkbox to delete the water generation details and click "Delete" button</li>
  <li>Select multiple check box and click "Delete" button to delete multiple records</li>
  <li>To edit the water generation details, delete the water generation details and then add new one</li>
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
</body>