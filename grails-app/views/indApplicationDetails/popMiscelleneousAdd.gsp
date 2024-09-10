<head>
<g:javascript library="prototype" />
<g:javascript>

function select1()
{
	var selectmenu1=document.getElementById("hazardeousSubs")
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
	var selectmenu1=document.getElementById("noisePollution")
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
	var selectmenu1=document.getElementById("dgStInstalled")
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




function select4()
{
	var selectmenu1=document.getElementById("isHazarSubstanceProduced")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp4").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp4").style.display = 'none';
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
<g:form name="saveHazardousChemical" method="post" action="saveMiscellaneous" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Miscellaneous Details</td>
					<input name="appId" type="hidden" value="<%=appDetId%>" />
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						 
						 
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Pollution Control Equipments(For Water pollution control</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" multiple="multiple" from="${GreenIndPollutionControlMeasureMaster.list()}" name="controlMeasures"></g:select>
							<span class="sidetxt">(select control measure)</span></span></td>
							  
						  </tr>	
						
						
						
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Total Cost on pollution control</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="totalCost" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(in Rupees)</span></span></td>
							</tr>
							
						
						
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  
							  
							  <td width="30%" align="left" >Is D.G Set installed?</td>
							 
							 
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="dgStInstalled" id="dgStInstalled" onclick="javascript:select3()" class="txt4">
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
										  <td width="20%" align="left" >D.G Set Capacity (in KVA)</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   
										   
										   
										   <input name="dgSetCapacity"  id ="dgSetCapacity" type="text" maxlength="100" size="12"class="txt4" /></td>
									
									
									
									
									 <td width="20%" align="left" >Acoastic enclosure</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										
										   
									 <g:select class="txt4" from="${['No','Yes']}" name="AcausticEnclosure"></g:select>
											
									</td>
									
									</tr></table>
								</div></td>
						  </tr>
						  
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Noise Pollution</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="noisePollution" id="noisePollution" onclick="javascript:select2()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
						 						
							<tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp1"  >
									<table width="60%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="20%" align="left" >Measures to control noise pollution taken</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
											
											<g:select class="txt4" from="${['No','Yes']}" name="noiseMeasures"></g:select>
											
											</td>
									<td width="30%" align="left" >Prescribed parameters achieved for noise</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
											
											<g:select class="txt4" from="${['No','Yes']}" name="presParameters"></g:select>
											
											</td>
									
									
									
									
									
									</tr></table>
								</div></td>
						  </tr>
						
						  
						  
													  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Hazardeous substance used</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="hazardeousSubs" id="hazardeousSubs" onclick="javascript:select1()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
							
						  <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp"  >
									<table width="60%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="20%" align="left" >Name of substance</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
			   <input name="nameOfHazardeous"  id ="nameOfHazardeous" type="text" maxlength="100" size="12"class="txt4" /></td>



 <td width="30%" align="left" >Quantity (in TPA)</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
			   <input name="quatityOfHazard"  id ="quatityOfHazard" type="text" maxlength="100" size="12"class="txt4" /></td>

									</tr></table>
								</div></td>
						  </tr>
								
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" > Hazardeous Waste is being produced?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="isHazarSubstanceProduced" id="isHazarSubstanceProduced" onclick="javascript:select4()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
							
						  
						    <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp4"  >
									<table width="60%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="20%" align="left" >Name of hazardeous waste</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   
										   
										   <input name="nameOfHazardWaste"  id ="nameOfHazardWaste" type="text" maxlength="100" size="12"class="txt4" /></td>
									
									 <td width="20%" align="left" >Quantity (in TPA)</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										
										
										   <input name="quatityOfWaste"  id ="quatityOfWaste" type="text" maxlength="100" size="12"class="txt4" /></td>
									 
									</tr></table>
								</div></td>
						  </tr>
						 
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b><br></span>
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
					<td><span class="txt" style="color: navy"><b>List of  Miscellaneous Details added.</b><br></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 				
 					<tr bgcolor="#A8DAF3">
 					     <td width="12.5%" class="headngblue" ><div  class="style3">Pollution Control Equipments(For Water pollution control</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Total Cost on pollution control</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Is DG Set installed</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">D.G Set capacity</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Acostic enclosure</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Noise Pollution</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Measure to contain noise pollution taken</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Prescribed parameters achieved for noise</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Hazardeous Substance Used</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Name of the substance</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Quantity (in TPA)</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Hazardeous waste being produced</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Name of hazardeous waste</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Quantity (in TPA)</div></td>
                     </tr>
                     
                     
 <g:each in="${miscelleneousList}" status="i" var="miscelleneousList">
 
 
 
  <tr align="center" >
                   <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.controlMeasures} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.totalCost} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.dgStInstalled} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.dgSetCapacity} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.AcausticEnclosure} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.noisePollution} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.noiseMeasures} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.presParameters} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.hazardeousSubs} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.nameOfHazardeous} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.quatityOfHazard} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.isHazarSubstanceProduced} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.nameOfHazardWaste} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.quatityOfWaste} </span></td>
                        
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