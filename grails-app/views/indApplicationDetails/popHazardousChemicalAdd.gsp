<head>
<g:javascript library="prototype" />
<g:javascript>

function select1()
{
	var selectmenu1=document.getElementById("emergency")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp").style.display = 'none';
		}
	}
} 

function select2()
{
	var selectmenu1=document.getElementById("hwmGenerating")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp1").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp1").style.display = 'none';
		}
	}
} 

function select3()
{
	var selectmenu1=document.getElementById("presentTreatment")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp2").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp2").style.display = 'none';
		}
	}
} 
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
<g:form name="saveHazardousChemical" method="post" action="saveHazardousChemical" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Hazardious Chemical Details</td>
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						 	
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Is the Unit a Major Accident Hazard unit as per MSIHC Rules?</td>
							  <input name="appId" type="hidden" value="<%=appDetId%>" /> 
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							<g:select class="txt4" from="${['No','Yes']}" name="accident"></g:select>
							<span class="sidetxt"></span></span></td>
							  
						  </tr>	  
						 						
							
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Is the unit an isolated storage?</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="isolatedStorage"></g:select>
							<span class="sidetxt">(As defined under the MSIHC Rules)</span></span></td>
							  
						  </tr>	
						  
						   <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Indicate status of compliance</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="compStatus" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(As per MSHIC rules 5,7,10,11,12,13 and 18)</span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Has approval of site been obtained from concerned authority?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <g:select class="txt4" from="${['No','Yes']}" name="siteApproval"></g:select>
							<span class="sidetxt"></span></span></td>
							  
						  </tr>	
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Has the unit prepared an Off-site Emergency Plan?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="emergency" id="emergency" onclick="javascript:select1()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
							
						  <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp"  >
									<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="30%" align="left" >Is it updated?</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										  <g:select class="txt4" from="${['No','Yes']}" name="isUpdated"></g:select>
									</tr></table>
								</div></td>
						  </tr>
																	  
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Has the information on imports of chemicals been provided to the concerned authority?</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="importChem"></g:select>
							<span class="sidetxt"></span></span></td>
							</tr> 
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Does the unit proces a policy under the PLI act?</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="pliAct"></g:select>
							<span class="sidetxt"></span></span></td>
							</tr> 
						  
						   <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Whether unit is generating hazardeous waste?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="hwmGenerating" id="hwmGenerating" onclick="javascript:select2()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt">as per hazardeous waste (Management & Handling) Rules, 1989, as amended</span></span></td>
							</tr>
							
						  <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp1"  >
									<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="30%" align="left" >Enter Category No</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   <input name="categoryNo"  id ="categoryNo" type="text" maxlength="100" size="12"class="txt4" /></td>
									</tr></table>
								</div></td>
						  </tr>
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Present Treatment of Hazardeous Waste?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="presentTreatment" id="presentTreatment" onclick="javascript:select3()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
							
						  <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp2"  >
									<table width="60%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="20%" align="left" >Area</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   <input name="area"  id ="area" type="text" maxlength="100" size="12"class="txt4" /></td>
									 <td width="20%" align="left" >Location</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   <input name="location"  id ="location" type="text" maxlength="100" size="12"class="txt4" /></td>
									 <td width="20%" align="left" >Methodology</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   <input name="methodology"  id ="methodology" type="text" maxlength="100" size="12"class="txt4" /></td>
									
									</tr></table>
								</div></td>
						  </tr>
						 
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
		
 				  
						</table></td></tr>
 					<tr>
										<!-- Div area for errors-->
										<td align="center" valign="middle">
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
											</span>
										</td>
									</tr>				
					<tr>
					<td><span class="txt" style="color: navy"><b>List of Hazardous Chemical details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					     <td width="12.5%" class="headngblue" ><div  class="style3">Is the Unit a Major Accident Hazard unit as per MSIHC Rules?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Is the unit an isolated storage?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Indicate the status of Compliance</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Has approval of site been obtained from concerned authority?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Has the unit prepared an Off-site Emergency Plan?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Is it updated?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Has the information on imports of chemicals been provided to the concerned authority?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Does the unit proces a policy under the PLI act?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Whether unit is generating hazardeous waste?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Category No</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Present Treatment of Hazardeous Waste</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Area</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Location</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Methodology</div></td>
                     </tr>
                     
                     
 <g:each in="${hazList}" status="i" var="stackDetInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.accident} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.isolatedStorage} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.compStatus} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.siteApproval} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.emergency} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.isUpdated} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.importChem} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.pliAct} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.hwmGenerating} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.categoryNo} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.presentTreatment} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.area} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.location} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.methodology} </span></td>
                        
        </tr>		
      </g:each>		
 					
 					</table></td></tr>
  </table>
					</td>
					</tr>	
  </table>
</g:form>
<script language="JavaScript" type="text/javascript">
</script>  
</body>