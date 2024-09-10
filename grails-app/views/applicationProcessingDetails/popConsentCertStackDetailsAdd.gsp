<head>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</g:javascript>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<g:form name="waterSourceModeUses" method="post" action="saveConsentCertStackDetails" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Stack Details</td>
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						   <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Stack Attached To</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="stackAttachedTo" type="text"  maxlength="100" size="20" class="txt4" />
							  
							  <input name="appId" type="hidden" value="<%=appDetId%>" />
							<span class="sidetxt">(enter stack details, max 100 chars)</span></span></td>
							</tr>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Volume</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="stackVolume" type="text" maxlength="15" size="12"class="txt4" />
							<span class="sidetxt">(Nm^3/hr)</span></span></td>
							</tr>
						
												
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Height</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="stackHeight" type="text" maxlength="15" size="12"class="txt4" />
							<span class="sidetxt">(in Meters)</span></span></td>
							</tr>
							
							
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Top Diameter</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="topDiameter" type="text" size="20" maxlength="50" class="txt4" />
							<span class="sidetxt">(in meters)</span></span></td>
							</tr>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Velocity of Gas Emission</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="velocityOfGasEmission" type="text" size="20" maxlength="50" class="txt4" />
							<span class="sidetxt">(m/sec)</span></span></td>
							</tr>
							
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Pollution Control Equipments</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select  class="txt4" multiple="multiple" from="${AirEmiControlMeasureMaster.list()}" name="pollutionCntrlMeasure"></g:select>
							<span class="sidetxt">(select control measure)</span></span></td>
							  
						  </tr>
						  						  
						  
						
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Type of fuel</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="typeOfFuel" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter the type of fuel, max 250)</span></span></td>
							</tr>
							
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Maximum Quantity</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="maximumQuantity" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter maximum quantity)</span></span></td>
							</tr>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Unit</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select optionKey="id"  class="txt4" from="${UnitMaster.list()}" name="unit"></g:select>
							<span class="sidetxt">(select capacity unit)</span></span></td>
							</tr>
						
						 
						  <tr>
                   <td colspan="6">
                   <div id="AjaxPanelStack">
                   
                   </div>
                   </td>
                   </tr>
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						</table></td></tr>
 					
					<tr>
					<td><span class="txt" style="color: navy"><b>List of Air Stack details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="150px" class="headngblue" ><div  class="style3">Stack Attached To</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Volume(Nm^3/hr)</div></td>
  			            <td width="100px" class="headngblue" ><div  class="style3">Height(in meters)</div></td>
                        <td width="100px" class="headngblue" ><div  class="style3">Top Diameter(in meters)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Velocity of Gas Emission(m/sec)</div></td>
                       	<td width="150px" class="headngblue" ><div  class="style3">Pollution Control Equipments</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Type of fuel</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Maximum Quantity</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Unit</div></td>
                     </tr>
                     
 <g:each in="${consentCertStackList}" status="i" var="consentCertStackInst">
  <tr align="center" >
  <% String pollControl=consentCertStackInst.pollutionCntrlMeasure
	pollControl=pollControl.replace("]","")
	pollControl=pollControl.replace("[","")
	%>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.stackAttachedTo}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.stackVolume}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.stackHeight}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.topDiameter}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.velocityOfGasEmission}
                        </span></td>
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">${pollControl}
                        </span></td>
                       
                         </td>
                    
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.typeOfFuel}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.maximumQuantity}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentCertStackInst.unit}
                        </span></td>
                        
        </tr>		
      </g:each>		
 					
 					
 					</table></td></tr>
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>

<!-- --------------------------- -->

						</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("stack","req","Please enter Stack attached to plant");
  frmvalidator.addValidation("pollCntrlMeasure","req","Please enter Pollutin control Equipment");
  frmvalidator.addValidation("stackVolume","decimal","Please enter Stack volume");
  frmvalidator.addValidation("stackHeight","decimal","Stack height should be numeric or decimal");
 frmvalidator.addValidation("maximumQuantity","decimal","max quantity sholud be numeric or decimal");
    frmvalidator.addValidation("topDiameter","req","Please enter top diameter");
  frmvalidator.addValidation("topDiameter","decimal","Diameter should be numeric or decimal");
  
 </script>  
						
						

</body>