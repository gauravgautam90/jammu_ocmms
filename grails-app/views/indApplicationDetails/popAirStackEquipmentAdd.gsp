<head>
<g:javascript library="prototype" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
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
<g:form name="waterSourceModeUses" method="post" action="saveAirStackEquipmentDetails" >
	
	<% 
								def app1 = IndApplicationDetails.get((params.id).toInteger())
								def finalL = new ArrayList()
								
								def pollCtrlMeasr
								def ctrlEquip
								for(int i=0;i<stackList.size();i++){
									def stackId =  stackList.get(i)   	
									 ctrlEquip = AirStackPollutionCntrlDetails.findAllWhere(stack:stackId)
									for(int j=0;j<ctrlEquip.size();j++){
									 pollCtrlMeasr = ctrlEquip[j].pollutionCntrlMeasure
										finalL.add(pollCtrlMeasr)
									}	
								
								}
								def a = (finalL).unique()
								
								
							%>
<table width="100%" cellpadding="0" cellspacing="0">

<tr bgcolor="#D1D1D1">
					<td  align="center" valign="middle"  class="headngblue">Control Equipment Details</td>
				</tr>
				<tr align="center" class="error" >  <td> <g:if test="${flash.message}">
												<div class="message">${flash.message}</div>
												</g:if>
												<g:hasErrors bean="${airStackEquipmentInst}">
												<div class="errors">
													<g:renderErrors bean="${airStackEquipmentInst}" as="list" />
												</div>
												</g:hasErrors></td></tr>
				<tr >
					<td>
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Stack Attached To Plant</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							 <input name="appId" type="hidden" value="<%=appDetId%>" /><g:select class="txt4" optionKey="id" from="${stackList}" name="stack"></g:select>
							<span class="sidetxt">(select stack)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Equipment Name</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							 <g:select class="txt4"  from="${a}" name="equipment"></g:select>
							<span class="sidetxt">(enter equipment name, max 25 chars)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Reduction Efficiency Guaranteed By Manufacturer</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="redEfficiency" type="text" maxlength="100" size="20"class="txt4" />
							<span class="sidetxt">(enter quantity)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Existing or Proposed</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							 <g:select class="txt4"  from="${['Existing','Proposed']}" name="state"></g:select> 
							<span class="sidetxt"></span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >For which Pollutant</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							   <input name="pollutant" type="text" maxlength="100" size="20"class="txt4" />
							<span class="sidetxt">(enter for which pollutant, max 100)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Date of Installation</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							 <calendar:datePicker name="installation" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							</span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Quantity of Current/Expected Emission(Kg/D)</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							   <input name="quantity" type="text" maxlength="100" size="20"class="txt4" />
							<span class="sidetxt">(e.g. Sulpher Dioxide - 500 Kg/D)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Unit</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" optionKey="id" from="${UnitMaster.list()}" name="unit"></g:select>
							<span class="sidetxt">(select unit of consumption)</span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Quality of Current/Expected Emission(mg/NCum)</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue">
							   <input name="quality" type="text" maxlength="100" size="20"class="txt4" />
							<span class="sidetxt">(e.g. Particute Matter - 45 mg/NCum)</span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Whether monitoring is being Done or Proposed</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							   <g:select class="txt4"  from="${['done','proposed']}" name="monitoring"></g:select>
							<span class="sidetxt"></span></span></td>
							</tr>
							
						  <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						 
						 </table>
					</td>
				</tr>
				<tr>
				<td>
				<!-- ------------ -->
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
				<span class="txt" style="color: navy"><b>List of Control Equipments details added.</b></span>
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="15%" class="headngblue" ><div  class="style3">Stack Attached To Plant</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">Equipment Name</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">Existing or Proposed</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">For which Pollutant</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">Date of Installation</div></td>
                        <td width="10%" class="headngblue" ><div  class="style3">Reduction Efficiency Guaranteed By Manufacturer(in %)</div></td>
                      	<td width="15%" class="headngblue" ><div  class="style3">Quantity of Current/Expected Emission(Kg/D)</div></td>
                      	<td width="20%" class="headngblue" ><div  class="style3">Quality of Current/Expected Emission(mg/NCum)</div></td>
                      	<td width="20%" class="headngblue" ><div  class="style3">Whether monitoring is being Done or Proposed</div></td>
                      	
                      </tr>
 <g:each in="${airStackEquipmentList}" status="i" var="stackInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.stack}
                        </span></td> 
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.equipment}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.state}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.pollutant}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.installation}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.redEfficiency}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.quantity}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="left"><span class="txt style6">${stackInst.quality}
                       </span>
                         </td>
                               <td bgcolor="#E8F6F9" align="left"><span class="txt style6">${stackInst.monitoring}
                       </span>
                         </td>
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 				
 					
 					</table>
 					
 					<!-- ------ -->
				</td>
				</tr>
</table>
</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("fuel","req","Please enter Fuel Name");
  frmvalidator.addValidation("stack","req","Please enter Stack attached to Plant");
  
  frmvalidator.addValidation("consumption","req","Please enter Fuel Consumption");
  frmvalidator.addValidation("consumption","maxlength=10","Fuel Consumption should be upto 10 digits");
  
 </script> 
</body>