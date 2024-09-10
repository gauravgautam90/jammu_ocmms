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
<g:form name="waterSourceModeUses" method="post" action="saveAirFlueEmmision" >
<table width="100%" cellpadding="0" cellspacing="0">
<tr bgcolor="#D1D1D1">
					<td  align="center" valign="middle"  class="headngblue">Flue Gas Emission Details</td>
				</tr>
				<tr >
					<td>
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Stack Attached To Plant(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							 <input name="appId" type="hidden" value="<%=appDetId%>" /> <g:select class="txt4" optionKey="id" from="${stackList}" name="stack"></g:select>
							<span class="sidetxt">(select stack)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Fuel Name</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="fuel" type="text" maxlength="250" size="25"class="txt4" />
							<span class="sidetxt">(e.g.coal,LSHS,furnace oil,etc., max 250 chars)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Fuel Consumption</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="consumption" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(enter quantity of fuel consumption)</span></span></td>
							</tr>
				
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Unit</td> 
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" optionKey="id" from="${UnitMaster.list()}" name="unit"></g:select>
							<span class="sidetxt">(select unit of consumption)</span></span></td>
							</tr>
					
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Calorific Value %</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="calorValue" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(enter calorific value)</span></span></td>
							</tr>
				
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Ash Content %</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="ashCon" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(enter ash content)</span></span></td>
							</tr>
				
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Sulphur Content %</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="sulphurCon" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(enter sulphur content)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Others</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="otherCon" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(enter other content)</span></span></td>
							</tr>
				
				
						
							<% 
								def app1 = IndApplicationDetails.get((params.id).toInteger())
								def finalL = new ArrayList()
								def stackList = AirStackDetails.findAllByApplication(app1)
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
							
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Pollution Control Equipment</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							<!--  <g:select class="txt4" multiple="multiple" optionKey="id" from="${AirEmiControlMeasureMaster.list()}" name="airFlueGasCntrlMeasure"></g:select> -->
								<g:select class="txt4" multiple="multiple"  from="${a}" name="airFlueGasCntrlMeasure"></g:select>
							
							<span class="sidetxt">(Press Ctrl for more then one selection)</span></span></td>
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
				<span class="txt" style="color: navy"><b>List of fuel gas emission details added.</b></span>
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="10%" class="headngblue" ><div  class="style3">Stack Attached To Plant(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</div></td>
                        <td width="15%" class="headngblue" ><div  class="style3">Fuel Name</div></td>
                        <td width="10%" class="headngblue" ><div  class="style3">Fuel Consumption</div></td>
                  
                     	<td width="15%" class="headngblue" ><div  class="style3">Unit</div></td>  
                  		
                  		<td width="7%" class="headngblue" ><div  class="style3">Calorific Value %</div></td>
                        <td width="8%" class="headngblue" ><div  class="style3">Ash Content %</div></td>
                        <td width="8%" class="headngblue" ><div  class="style3">Sulphur Content %</div></td>
 	                 	<td width="7%" class="headngblue" ><div  class="style3">Others</div></td>
                  
                  
                      	<td width="20%" class="headngblue" ><div  class="style3">Pollution Control Equipments</div></td>
                      </tr>
 <g:each in="${flueList}" status="i" var="flueInst">
  <tr align="center" >
  						<td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.stack}
                        </span></td> 
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.fuel}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.consumption}
                        </span></td>
                  
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.unit}
                        </span></td>		
                  
                  		<td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.calorValue}
                        </span></td> 
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.ashCon}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.sulphurCon}
                        </span></td>
                  		<td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.otherCon}
                        </span></td>
                  
                  
                         <td bgcolor="#E8F6F9" align="left	">
                         <%
                         ArrayList pollCntrlList = pollCntrlBList.get(i);
                         for(int j=0;j<pollCntrlList.size();j++){ %>
                         <span class="txt style6"><%=(pollCntrlList.get(j)).pollutionCntrlMeasure %></span><%if(j<(pollCntrlList.size()-1)){%>,<%}%>
                         <%}%>
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
  frmvalidator.addValidation("airFlueGasCntrlMeasure","req","Please enter pollution Control Equipments");
  frmvalidator.addValidation("fuel","maxlength=25","Fuel Name should be upto 25 characters");
  frmvalidator.addValidation("consumption","decimal","Fuel Consumption should be numeric or decimal");
  frmvalidator.addValidation("consumption","req","Please enter Fuel Consumption");
  frmvalidator.addValidation("consumption","maxlength=10","Fuel Consumption should be upto 10 digits");
  
 </script> 
</body>