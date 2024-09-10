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
<g:form name="waterSourceModeUses" method="post" action="saveAirStackDetailsInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Air Stack Details</td>
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						   <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Stack Attached To Plant(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="stack" type="text"  maxlength="100" size="20" class="txt4" /><input name="appId" type="hidden" value="<%=appDetId%>" />
							<span class="sidetxt">(enter stack details, max 100 chars)</span></span></td>
							</tr>
						
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Shape</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['Round','Rectangle']}" name="shape"></g:select>
							<span class="sidetxt">(select shape)</span></span></td>
							  
						  </tr>	
						
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Stack Height above Ground Level(in Meters)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="heightGrdLevel" type="text" maxlength="15" size="12"class="txt4" />
							<span class="sidetxt">(enter stack height above ground level)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Stack Height above Factory Room(in Meters)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="heightFacLevel" type="text" maxlength="15" size="12"class="txt4" />
							<span class="sidetxt">(enter stack height above factory level)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Plant Capacity(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="capacity" type="text" size="20" maxlength="50" class="txt4" />
							<span class="sidetxt">(enter plant capacity)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Unit</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select optionKey="id"  class="txt4" from="${UnitMaster.list()}" name="capacityUnit"></g:select>
							<span class="sidetxt">(select capacity unit)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Pollution Control Equipments</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select optionKey="id"  class="txt4" multiple="multiple" from="${AirEmiControlMeasureMaster.list()}" name="pollCntrlMeasure"></g:select>
							<span class="sidetxt">(select control measure)</span></span></td>
							  
						  </tr>
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Stack Draft Type</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['Natural draft','ID Fan','FD Fan']}" name="draftType"></g:select>
							<span class="sidetxt">(select control measure)</span></span></td>
							  
						  </tr>
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Material Of Construction of Stack</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="matOfCon" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter material of construction, max 250)</span></span></td>
							</tr>
						
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Fuel Type</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="fuelTyp" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter the type of fuel, max 250)</span></span></td>
							</tr>
							
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Fuel Quantity(TP/KLD)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="fuelQty" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter quality of fuel)</span></span></td>
							</tr>
						
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Gas Quantity(Nm<sup>3</sup>/hr)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="gasQty" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter quantity of gas in Nm<sup>3</sup>/hr)</span></span></td>
							</tr>
							
							
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Diameter Size(meters)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="diamSize" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter size of diameter in meters)</span></span></td>
							</tr>
						
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Gas Temperature (&deg C)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="gasTemp" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter temperature of gas in &deg C)</span></span></td>
							</tr>
						
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Exit Gas Velocity(m/sec)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="gasVel" type="text" size="20" maxlength="250" class="txt4" />
							<span class="sidetxt">(enter exit gas velocity in m/sec)</span></span></td>
							</tr>
						
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Number of Stacks</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="noOfStack" type="text" readonly size="8" value="${count1}" maxlength="15" class="txt4" />
							<span class="sidetxt"></span></span></td>
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
                        <td width="150px" class="headngblue" ><div  class="style3">Stack Attached To Plant(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Shape</div></td>
  			            <td width="100px" class="headngblue" ><div  class="style3">Stack Height above ground level(meters)</div></td>
                        <td width="100px" class="headngblue" ><div  class="style3">Stack Height above factory room(meters)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Plant Capacity(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Unit</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Pollution Control Equipments</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Stack Draft Type</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Material Of Construction of Stack</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Fuel Type</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Fuel Quantity(TP/KLD)</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Gas Quantity(Nm<sup>3</sup>/hr)</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Diameter Size(meters)</div></td>
                     	<td width="150px" class="headngblue" ><div  class="style3">Gas Temperature (&deg C)</div></td>
                     	<td width="150px" class="headngblue" ><div  class="style3">Exit Gas Velocity(m/sec)</div></td>
                     </tr>
 <g:each in="${stackList}" status="i" var="stackDetInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.stack}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.shape}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.heightGrdLevel}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.heightFacLevel}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.capacity}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.unit}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="left">
                         <%
                         ArrayList pollCntrlList = pollCntrlBList.get(i);
                         for(int j=0;j<pollCntrlList.size();j++){ %>
                         <span class="txt style6"><%=(pollCntrlList.get(j)).pollutionCntrlMeasure %></span><%if(j<(pollCntrlList.size()-1)){%>,<%}%>
                         <%}%>
                         </td>
                    
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.draftType}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.matOfCon}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.fuelTyp}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.fuelQty}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.gasQty}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.diamSize}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.gasTemp}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.gasVel}
                        </span></td>
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
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

		()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
			
	<%}else{%>
   
		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

	<%}%></td></tr>			
					  
  </table>

<!-- --------------------------- -->

</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("stack","req","Please enter Stack attached to plant");
  frmvalidator.addValidation("pollCntrlMeasure","req","Please enter Pollution control Equipment");
  frmvalidator.addValidation("heightGrdLevel","req","Please enter Stack Height above Ground Level");
  frmvalidator.addValidation("heightGrdLevel","decimal","Stack height should be numeric or decimal");
  frmvalidator.addValidation("heightGrdLevel","maxlength=10","Stack height should be upto 10 digits");
  frmvalidator.addValidation("heightFacLevel","req","Please enter Stack Height above Factory Room");
  frmvalidator.addValidation("heightFacLevel","decimal","Stack height should be numeric or decimal");
  frmvalidator.addValidation("heightFacLevel","maxlength=10","Stack height should be upto 10 digits");
  frmvalidator.addValidation("capacity","req","Please enter Capacity");
  frmvalidator.addValidation("capacity","decimal","Capacity should be numeric or decimal");
  frmvalidator.addValidation("capacity","maxlength=10","Capacity should be upto 10 digits");
  frmvalidator.addValidation("matOfCon","req","Please enter Material of Construction");
 </script>  
						
						

</body>